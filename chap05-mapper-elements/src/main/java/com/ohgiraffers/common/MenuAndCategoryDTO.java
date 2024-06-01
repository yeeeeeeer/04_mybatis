package com.ohgiraffers.common;

// 일대일 관계를 볼 DTO(메뉴가 중점) (menu:category)
public class MenuAndCategoryDTO {

    private int code;
    private String name;
    private int price;
    private CategoryDTO category;
    private String orderableStatus;   // 일대일 관계라 Stirng으로 받음

    public MenuAndCategoryDTO() {
    }

    public MenuAndCategoryDTO(int code, String name, int price, CategoryDTO category, String orderableStaus) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.category = category;
        this.orderableStatus = orderableStaus;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getOrderableStaus() {
        return orderableStatus;
    }

    public void setOrderableStaus(String orderableStaus) {
        this.orderableStatus = orderableStaus;
    }

    @Override
    public String toString() {
        return "MenuAndCategoryDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", orderableStaus='" + orderableStatus + '\'' +
                '}';
    }
}
