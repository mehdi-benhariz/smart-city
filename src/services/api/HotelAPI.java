package services.api;

import java.io.*;
import java.net.*;
import java.net.http.*;
import java.util.Vector;

import org.json.simple.*;
import org.json.simple.parser.*;

import models.Hotel;

public class HotelAPI {
    public static final String POSTS_API_URL = "https://jsonplaceholder.typicode.com/posts";

    private HttpResponse<String> createReq() {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(POSTS_API_URL);
        HttpRequest request = HttpRequest.newBuilder().GET().header("accept", "application/json").uri(uri).build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    private Hotel convertToHotel(JSONObject obj) {
        System.out.println(obj);
        return null;
    }

    private Vector<Hotel> convertJSONToObj(JSONArray dataArr) {
        Vector<Hotel> res = new Vector<Hotel>();
        for (Object object : dataArr)
            res.add(convertToHotel((JSONObject) object));

        return res;
    }

    public Vector<Hotel> getData() throws IOException, InterruptedException, ParseException {
        HttpResponse<String> res = createReq();
        String data = res.body();
        JSONParser parser = new JSONParser();
        /*
         * // in case of one json object JSONObject json =
         * (JSONObject)parser.parse(data);
         */
        // in case of an array
        Object obj = parser.parse(data);
        JSONArray dataArr = (JSONArray) obj;
        // print all the data
        /*
         * System.out.println(dataArr); System.out.println(((JSONObject)
         * dataArr.get(1))); System.out.println(((JSONObject)
         * dataArr.get(1)).get("title"));
         */
        return convertJSONToObj(dataArr);
    }
}
