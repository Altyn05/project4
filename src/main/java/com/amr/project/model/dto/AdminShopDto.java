package com.amr.project.model.dto;

import com.amr.project.model.entity.Country;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AdminShopDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private Country location;
    private List<AdminItemShortDto> items;
    private AdminUserDto user;
    private double rating;
    private String description;
}
