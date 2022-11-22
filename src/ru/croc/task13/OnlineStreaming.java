package ru.croc.task13;

import ru.croc.task13.exceptions.UserNotFoundException;
import ru.croc.task13.utilities.Parser;

import java.nio.file.Path;
import java.util.*;

public class OnlineStreaming {
    private Map<Integer, String> films;
    private Map<Integer, List<Integer>> history;
    private Integer maxId;

    public OnlineStreaming(Path db_films, Path db_history) {
        films = Parser.pasreFilms(db_films);
        history = Parser.pasreHistory(db_history);
        maxId = Collections.max(history.keySet());
    }

    public void addUserInHistory(String newHistory){
        int max = Collections.max(history.keySet());
        max++;

        Integer newId = max;
        this.maxId = max;
        history.put(newId, Parser.pasreHistory(newHistory));
    }

    public Integer getMaxId() {
        return maxId;
    }

    private boolean isCompatibility(Integer keySupposedUser, Integer keyCurrentUser) throws UserNotFoundException {
        /*
        Для просмотров пользователя из историй по всем пользователям выбираются те,
        у которых хотя бы половина фильмов совпадает с заданной.
         */

        if (!history.containsKey(keyCurrentUser)) throw new UserNotFoundException(keyCurrentUser);
        if (!history.containsKey(keySupposedUser)) throw new UserNotFoundException(keySupposedUser);

        Map<Integer, Integer> countFilms = new HashMap<>();
        List<Integer> filmsCurrentUser = history.get(keyCurrentUser);
        int countCompatibilityFilms = 0;

        for (Integer idFilm : filmsCurrentUser) { // Инициализация словаря количества фильмов
            if (!countFilms.containsKey(idFilm)) countFilms.put(idFilm, 0);
        }

        Integer tempCountFilms;

        for (Integer idFilmSupposed : history.get(keySupposedUser)) { // Подсчёт количества фильмов
            if (countFilms.containsKey(idFilmSupposed)) {
                tempCountFilms = countFilms.get(idFilmSupposed);
                tempCountFilms++;
                countFilms.put(idFilmSupposed, tempCountFilms);
            }
        }

        for (Integer value : countFilms.values()) {
            countCompatibilityFilms += value;
        }

        return countCompatibilityFilms > history.get(keyCurrentUser).size() / 2;
    }

    private Set<Integer> getIdsRecommendedFilms(Integer idCurrentUser) throws UserNotFoundException {
        /*
        Из отобранных списков исключаются все, которые пользователь уже посмотрел.
        */
        Set<Integer> idRecommendedFilms = new HashSet<>();

        for (Integer keyUser : history.keySet()) {
            if (isCompatibility(keyUser, idCurrentUser) && !Objects.equals(keyUser, idCurrentUser)) {
                for (Integer idFilm : history.get(keyUser)) {
                    if (!history.get(idCurrentUser).contains(idFilm)) idRecommendedFilms.add(idFilm);
                }
            }
        }
        return idRecommendedFilms;
    }


    public String getRecommendation(int idUser) throws UserNotFoundException {
        /*
        Для оставшегося списка фильмов подсчитывается суммарное количество просмотров среди всех пользователей
        сервиса и фильм с максимальным числом просмотров выбирается как рекомендация
        (если таких фильмов оказалось несколько, выбирается любой из них).
         */
        if (!history.containsKey(idUser)) throw new UserNotFoundException(idUser);

        Map<Integer, Integer> rating = new HashMap<>();

        Integer maxRating = 0;

        Set<Integer> keysOfFilms = getIdsRecommendedFilms(idUser);

        for (Integer idFilm : keysOfFilms) { // Инициализация словаря количества фильмов
            Integer counter = rating.get(idFilm);
            if (counter == null) counter = 0;
            counter++;
            if (counter > maxRating) maxRating = counter;
            rating.put(idFilm, counter);
        }

        for (Integer key : rating.keySet()) {
            if (Objects.equals(rating.get(key), maxRating)) return films.get(key);
        }
        return null;
    }
}
