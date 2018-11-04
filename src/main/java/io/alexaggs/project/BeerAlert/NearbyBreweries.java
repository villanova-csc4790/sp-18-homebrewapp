package io.alexaggs.project.BeerAlert;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;

import java.io.IOException;

public class NearbyBreweries {

    private static final String API_KEY_PLACES = "places key";
    private static final String API_KEY_GEO = "geo key";

    public static void findPlaces() throws InterruptedException, ApiException, IOException {

        LatLng coordinates = getCoordinates("Villanova");
        double lat = coordinates.lat;
        double lng = coordinates.lng;

        LatLng location = new LatLng(lat, lng);

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY_PLACES)
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

    public static LatLng getCoordinates(String city) throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY_GEO)
                .build();

        GeocodingApiRequest result =  GeocodingApi.geocode(context, city);
        GeocodingResult[] finalResults = result.await();
        return finalResults[0].geometry.location;
    }
}
