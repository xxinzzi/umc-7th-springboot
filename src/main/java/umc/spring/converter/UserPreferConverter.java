package umc.spring.converter;

import umc.spring.domain.MenuCategory;
import umc.spring.domain.mapping.UserPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {
    public static List<UserPrefer> toUserPreferList(List<MenuCategory> menuCategoryList){

        return menuCategoryList.stream()
                .map(menuCategory ->
                        UserPrefer.builder()
                                .menuCategory(menuCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
