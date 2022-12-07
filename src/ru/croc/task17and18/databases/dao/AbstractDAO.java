package ru.croc.task17and18.databases.dao;

public abstract class AbstractDAO<K extends Number, T> {

    public abstract T find(K id);

    public abstract boolean delete(K id);

    public abstract boolean delete(T entity);

    public abstract boolean create(T entity);

    public abstract T update(T entity);
}
