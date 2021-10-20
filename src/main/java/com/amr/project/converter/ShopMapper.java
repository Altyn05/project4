package com.amr.project.converter;

import com.amr.project.model.dto.*;
import com.amr.project.model.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShopMapper {
    @Mapping(target = "username", source = "user.username")
    ShopDto shopToDto(Shop shop);

    CountryDto countryToDto(Country country);

    ItemDto itemToDto(Item item);

    ReviewDto reviewToDto(Review review);

    ImageDto imageToDto(Image image);

    CategoryDto categoryDto(Category category);
}
