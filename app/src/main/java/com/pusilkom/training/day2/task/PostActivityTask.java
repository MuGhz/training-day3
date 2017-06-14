package com.pusilkom.training.day2.task;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.pusilkom.training.day2.MainActivity;
import com.pusilkom.training.day2.model.ListMenuItem;
import com.pusilkom.training.day2.model.Post;
import com.pusilkom.training.day2.service.PostService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by purwa on 6/14/17.
 */

public class PostActivityTask extends AsyncTask<Object, Object, Void> {
    private Context context;

    public List<ListMenuItem> getItems() {
        return items;
    }

    private List<ListMenuItem> items;

    public PostActivityTask(Context ctx) {
        this.context = ctx;
    }

    @Override
    protected Void doInBackground(Object... objects) {

        Retrofit client = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostService service = client.create(PostService.class);

        Call<List<ListMenuItem>> call = service.listAllMenu("5940dc3c0f0000a802c62f3a");
        try {
            Response<List<ListMenuItem>> response = call.execute();
            Log.d("RESPONSE BACKEND", new Gson().toJson(response.body()));
            items = response.body();

            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra("myMenu", new Gson().toJson(items));

            context.startActivity(intent);

        } catch (IOException e) {
            e.printStackTrace();
        }



        return null;
    }


}
