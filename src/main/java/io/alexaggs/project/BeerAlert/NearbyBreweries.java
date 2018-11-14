package io.alexaggs.project.BeerAlert;

import com.google.maps.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;

import java.io.IOException;

public class NearbyBreweries {

    private static final String API_KEY_PLACES = "key";
    private static final String API_KEY_GEO = "key";
    private static final String API_KEY_DIST = "key";

    public static PlacesSearchResult[] findPlaces(String city, double radius) throws InterruptedException, ApiException, IOException {
        LatLng coordinates = getCoordinates(city);
        double lat = coordinates.lat;
        double lng = coordinates.lng;

        LatLng location = new LatLng(lat, lng);

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY_PLACES)
                .build();

        PlacesSearchResponse response = PlacesApi.nearbySearchQuery(context, location)
                .radius((int)(radius * 1609)) // miles to meters conversion
                .language("en")
                .type(PlaceType.RESTAURANT)
                .keyword("brew")
                .await();

        return response.results;
    }

    public static LatLng getCoordinates(String city) throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY_GEO)
                .build();

        GeocodingApiRequest result =  GeocodingApi.geocode(context, city);
        GeocodingResult[] finalResults = result.await();
        return finalResults[0].geometry.location;
    }

    public static double getDistance(LatLng one, LatLng two) throws InterruptedException, ApiException, IOException {
        GeoApiContext distCalc = new GeoApiContext.Builder()
                .apiKey(API_KEY_DIST)
                .build();

        DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalc);
        DistanceMatrix result = req.origins(one)
                .destinations(two)
                .await();
        return Math.round(result.rows[0].elements[0].distance.inMeters * .000621371 * 100) / 100.00;
    }
}
