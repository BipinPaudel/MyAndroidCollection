package com.hanselandpetal.catalog.parsers;

import com.hanselandpetal.catalog.model.Flower;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bips on 7/28/16.
 */
public class FlowerJSONParser {
    public static List<Flower> parseFeed(String content){

        try {
            JSONArray ar = new JSONArray(content);
            List<Flower> flowerList = new ArrayList<>();
            for (int i = 0; i < ar.length(); i++) {
                Flower flower = new Flower();
                JSONObject obj = ar.getJSONObject(i);

                flower.setCategory(obj.getString("category"));
                flower.setPrice(obj.getDouble("price"));


                flower.setInstructions(obj.getString("instructions"));

                flower.setPhoto(obj.getString("photo"));
                flower.setName(obj.getString("name"));
                flower.setProductId(obj.getInt("productId"));

                flowerList.add(flower);
            }
            return flowerList;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }

    }
}

















