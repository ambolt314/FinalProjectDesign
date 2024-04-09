package com.amb.BServices;

public class BeeDTO {
    private int id;
    private String name;
    private int favouriteNumber = 5;
    private String queen;

    public BeeDTO(
            int id,
            String name,
            int favouriteNumber,
            String queen
    ) {
        this.setId(id);
        this.setName(name);
        this.setFavouriteNumber(favouriteNumber);
        this.setQueen(queen);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFavouriteNumber() {
        return favouriteNumber;
    }

    public void setFavouriteNumber(int favouriteNumber) {
        this.favouriteNumber = favouriteNumber;
    }

    public String getQueen() {
        return queen;
    }

    public void setQueen(String queen) {
        this.queen = queen;
    }
}
