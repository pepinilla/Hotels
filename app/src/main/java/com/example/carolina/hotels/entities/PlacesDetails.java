package com.example.carolina.hotels.entities;

import java.io.Serializable;

/**
 * Created by carolina on 25/06/17.
 */

public class PlacesDetails implements Serializable{

    String id;
    String place;
    String hotel;
    String image;

    public void setId(String id) {
        this.id = id;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public PlacesDetails(){

    }
    public PlacesDetails(String id, String place, String hotel, String image) {
        this.id = id;
        this.place = place;
        this.hotel = hotel;
        this.image = image;
    }


    public String getId() {
        return id;
    }

    public String getPlace() {
        return place;
    }

    public String getHotel() {
        return hotel;
    }

    public String getImage() {
        return String.format("https://cdn.pixabay.com/photo/%s", image);
    }
}
