package com.app.app.RestController;

import com.app.app.Domini.DTO.CoordenadaDTO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("coord/")
public class CoordenadasRESTController {

    private String apiKey = "AIzaSyDsyhROj0LMUt52bB8PozBnt7tnQToS6Eo";
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("fins/{lat}/{lng}")
    public String geta(@PathVariable String lat, @PathVariable String lng) {
        System.out.println(lat);
        System.out.println(lng);

        String urlBase = "https://maps.googleapis.com/maps/api/geocode/json?latlng=";

        String toSearch = urlBase + lat + "," + lng + "&key=" + apiKey;
        System.out.println(toSearch);
        ResponseEntity<String> response = restTemplate.exchange(toSearch,
                HttpMethod.GET, null, String.class);

        JsonParser parser = new BasicJsonParser();
        try {
            Map a = parser.parseMap(response.getBody());
            // Map b =  a.get("results");
            String as = a.get("results").toString();
            JSONArray jsonArray = new JSONArray(as);
            JSONObject jso = jsonArray.getJSONObject(0);

            return jso.get("formatted_address").toString();


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return "";
    }

    @PostMapping(value = "findStreet", produces = MediaType.APPLICATION_JSON_VALUE)
    public String fins(@RequestBody CoordenadaDTO coord) {
        String urlBase = "https://maps.googleapis.com/maps/api/geocode/json?latlng=";

        String toSearch = urlBase + coord.getLat() + "," + coord.getLng() + "&key=" + apiKey;
        System.out.println(toSearch);
        ResponseEntity<String> response = restTemplate.exchange(toSearch,
                HttpMethod.GET, null, String.class);

        JsonParser parser = new BasicJsonParser();

        try {
            Map resultMap = parser.parseMap(response.getBody());
            String resultString = resultMap.get("results").toString();
            JSONArray jsonArray = new JSONArray(resultString);
            JSONObject jsonWanted = jsonArray.getJSONObject(0);
            String address = jsonWanted.get("formatted_address").toString();
            return address;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }

    @PostMapping(value = "isParcking", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean isParking(@RequestBody CoordenadaDTO coord) {
        return true;
    }

}
