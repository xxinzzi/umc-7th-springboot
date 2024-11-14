package umc.spring.repository.RestaurantRepository;

import umc.spring.domain.restaurant;

import java.util.List;


public interface RestaurantRepositoryCustom {
    List<restaurant> dynamicQueryWithBooleanBuilder(String name, Float rating);
}
