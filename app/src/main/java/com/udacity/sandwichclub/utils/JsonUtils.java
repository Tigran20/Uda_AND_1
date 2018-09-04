package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static final String KEY_NAME = "name";
    public static final String KEY_MAIN_NAME = "mainName";
    public static final String KEY_ALSO_KNOW_AS = "alsoKnownAs";
    public static final String KEY_PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject rootObject = new JSONObject(json);
            JSONObject nameObject = rootObject.getJSONObject(KEY_NAME);
            sandwich.setMainName(nameObject.getString(KEY_MAIN_NAME));
            sandwich.setAlsoKnownAs(getJsonArrayAsList(nameObject.getJSONArray(KEY_ALSO_KNOW_AS)));
            sandwich.setPlaceOfOrigin(rootObject.getString(KEY_PLACE_OF_ORIGIN));
            sandwich.setDescription(rootObject.getString(KEY_DESCRIPTION));
            sandwich.setImage(rootObject.getString(KEY_IMAGE));
            sandwich.setIngredients(getJsonArrayAsList(rootObject.getJSONArray(KEY_INGREDIENTS)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }

    public static ArrayList<String> getJsonArrayAsList(JSONArray array) {
        ArrayList<String> list = new ArrayList<>();
        try {
            for (int i = 0; i < array.length(); i++) {
                list.add(array.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
