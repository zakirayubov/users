package ru.users.mapper;

import java.util.Collection;
import java.util.stream.Collectors;

public interface Mapper<S, T> {
    T map(S source);

    default Collection<T> mapAll(Collection<S> sources) {
        return sources.stream().map(this::map).collect(Collectors.toList());
    }
}
