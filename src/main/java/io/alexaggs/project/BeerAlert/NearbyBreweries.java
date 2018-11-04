package io.alexaggs.project.BeerAlert;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;

import java.io.IOException;

public class NearbyBreweries {

    private static final String API_KEY = "AIzaSyD9Fs6gvBbIq-Bf9iAP3lNUMsJhJsRSn9I";

    public static void findPlaces() throws InterruptedException, ApiException, IOException {
        LatLng location = new LatLng(40.023026, -75.315178);

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();

        PlacesSearchResponse response = PlacesApi.nearbySearchQuery(context, location)
                .radius(5000)
                .language("en")
                .type(PlaceType.RESTAURANT)
                .keyword("brew")
                .await();

        PlacesSearchResult[] places = response.results;
        for(PlacesSearchResult p: places) {
            System.out.println(p.name);
        }
    }
}
