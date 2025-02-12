package com.ichwan.outlet.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ComponentMapper {

    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    public static <E, M> M mapEntityToModel(E entity, Class<M> model) {
        TypeMap<E, M> typeMap;
        return modelMapper.map(entity, model);
    }

    public static <E, M> List<M> mapEntitiesToModels(List<E> entities, Class<M> model) {
        return entities.stream()
                .map(entity -> modelMapper.map(entity, model))
                .collect(Collectors.toList());
    }
}
