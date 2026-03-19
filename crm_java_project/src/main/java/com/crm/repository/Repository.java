package com.crm.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<T> {
    private List<T> items = new ArrayList<>();

    public void save(T item) {
        items.add(item);
    }

    public List<T> findAll() {
        return new ArrayList<>(items);
    }

    public List<T> find(Predicate<T> filter) {
        return items.stream().filter(filter).collect(Collectors.toList());
    }

    public void remove(T item) {
        items.remove(item);
    }
}
