package com.example.carolina.hotels.database;

import com.example.carolina.hotels.entities.PlacesDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carolina on 26/06/17.
 */

public class Database {



    private List<PlacesDetails> list;
    private List<PlacesDetails> hotelslist;
    private static volatile Database INSTANCE;

    private void Data() {

        list = new ArrayList<>();
        list.add(new PlacesDetails("277834", "Bogota", "Bogotá is Colombia's beating heart, an engaging and vibrant capital cradled by chilly Andean peaks and steeped in sophisticated urban cool.  Nearly all of Bogotá's traditional attractions are here – radiating out from Plaza de Bolívar – and gorgeous Cerro de Monserrate is just east.", "2017/06/23/14/50/colombia-2434911_960_720.jpg"));
        list.add(new PlacesDetails("121856", "Medellin", "Medellín packs the punch of a city twice its size. Situated in a narrow valley, the city's skyline reaches for the heavens, setting high-rise apartment and office buildings against a backdrop of jagged peaks in every direction. ", "2017/05/25/17/41/medellin-2343953_960_720.jpg"));
        list.add(new PlacesDetails("330459", "Cartagena", "Cartagena de Indias is the undisputed queen of the Caribbean coast, a fairy-tale city of romance, legends and superbly preserved beauty lying within an impressive 13km of centuries-old colonial stone walls. ", "2017/02/11/02/28/island-2056892_960_720.jpg"));
        list.add(new PlacesDetails("283366", "San Andres", "Just 150km east of Nicaragua and some 800km northwest of Colombia, the seahorse-shaped island of San Andrés counts 27 sq km of cultural tug-of-war as both its asset and its handicap. Covered in coconut palms, San Andrés, the largest island in the archipelago, is indeed paradisiacal Caribbean, but not everything here is crystal clear.",  "2013/09/09/20/42/colombia-180789_960_720.jpg"));
        list.add(new PlacesDetails("313369", "Choco", "As the capital city of the Amazonas province, Leticia is the largest city for hundreds of kilometers yet still looks and feels very much like a small frontier town. It's located on the Amazon River at the crossroads – or more accurately, the cross-river – point where Colombia, Brazil and Peru meet. ", "2017/06/20/01/56/by-sunsets-2421476_960_720.jpg"));

    }

    private void DataHotels(){
        hotelslist = new ArrayList<>();
        getHotelslist().add(new PlacesDetails("1", "Hotel las maravillas", "Hotel ubicado en Colombia", "2013/10/14/04/20/sun-195333_960_720.jpg"));
        getHotelslist().add(new PlacesDetails("2", "Hotel las hojas", "Hotel ubicado en Medellin", "2013/11/25/13/44/singapore-217988_960_720.jpg"));
        getHotelslist().add(new PlacesDetails("3", "Hotel las plantas", "HOtel ubicado en Cartagena", "2013/11/25/13/53/singapore-217993_960_720.jpg"));
    }

    public static Database getInstance() {
        Database localInstance = INSTANCE;
        if (localInstance == null) { //1st check (no lock)
            synchronized (Database.class){
                localInstance = INSTANCE;
                if (localInstance == null) { //2nd check (lock)
                    localInstance = INSTANCE = new Database();
                }
            }
        }
        return localInstance;
    }

    public List<PlacesDetails> getList() {
        if (list == null) {
            Data();
        }
        return list;
    }


    public List<PlacesDetails> getHotelslist() {
            if(hotelslist == null){
                DataHotels();
            }
        return hotelslist;
    }
}
