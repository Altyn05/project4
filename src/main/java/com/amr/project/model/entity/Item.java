package com.amr.project.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;

    @ManyToMany
    @JoinTable(
            name = "categories_items",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @OneToMany
//    @JoinColumn(name = "item_img_id")
    private List<Image> images;

    @OneToMany(mappedBy = "item")
    private List<Review> reviews;

    private Integer count;
    private Double rating;

    @Column(columnDefinition = "text")
    private String description;
    private Integer discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;
    private boolean isPretendedToBeDeleted;

    @Transient
    private Long shopId;

    public void addCategory(Category category) {
        if(categories == null) {
            categories = new ArrayList<>();
        }
        categories.add(category);
    }

    public void addImage(Image image) {
        if(images == null) {
            images = new ArrayList<>();
        }
        images.add(image);
    }

}
