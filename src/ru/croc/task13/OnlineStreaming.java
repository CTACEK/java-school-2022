package ru.croc.task13;

import ru.croc.task13.exceptions.UserNotFoundException;
import ru.croc.task13.utilities.Parser;

import java.nio.file.Path;
import java.util.*;

public class OnlineStreaming {
    private final Map<Integer, String> films;
    private final Map<Integer, List<Integer>> history;

    private Integer maxId;

    public OnlineStreaming(Path db_films, Path db_history) {
        films = Parser.pasreDbFilms(db_films);
        history = Parser.pasreDbHistory(db_history);
        maxId = Collections.max(history.keySet());
    }

    public int addUserInHistory(String newHistory){
        maxId++;
        history.put(maxId, Parser.pasreEnteredHistory(newHistory));
        return maxId;
    }


    private boolean isCompatibility(Integer keySupposedUser, Integer keyCurrentUser) {
        /*
        Для просмотров пользователя из историй по всем пользователям выбираются те,
        у которых хотя бы половина фильмов совпадает с заданной.
         */

        List<Integer> filmsCurrentUser = history.get(keyCurrentUser);
        List<Integer> filmsSupposedUser = history.get(keySupposedUser);

        int countCompatibilityFilms = 0;

        Set<Integer> userFilms = new HashSet<>(filmsSupposedUser);

        for (Integer idFilm : userFilms) {
            if (filmsCurrentUser.contains(idFilm)) {
                countCompatibilityFilms++;
            }
        }

        return countCompatibilityFilms >= userFilms.size() / 2;
    }

    private Set<Integer> getIdsRecommendedFilms(Integer idCurrentUser) {
        /*
        Из отобранных списков исключаются все, которые пользователь уже посмотрел.
        */
        Set<Integer> idRecommendedFilms = new HashSet<>();

        for (Integer keyUser : history.keySet()) {
            if (!Objects.equals(keyUser, idCurrentUser) && isCompatibility(keyUser, idCurrentUser)) {
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

        Set<Integer> keysOfFilms = getIdsRecommendedFilms(idUser);

        Map<Integer, Integer> rating = new HashMap<>();

        for (Integer keyOfFilm : keysOfFilms) {
            rating.put(keyOfFilm, 0);
        }

        Integer maxRating = 0;

        for (Integer user : history.keySet()) {
            List<Integer> userFilms = history.get(user);
            for (Integer userFilm : userFilms) {
                Integer tempFilm = rating.get(userFilm);
                if (tempFilm != null){
                    tempFilm++;
                    if (tempFilm > maxRating) maxRating = tempFilm;
                    rating.put(userFilm, tempFilm);
                }
            }
        }

        for (Integer key : rating.keySet()) {
            if (Objects.equals(rating.get(key), maxRating)) return films.get(key);
        }
        return null;
    }

    public Integer getMaxId() {
        return maxId;
    }
}
