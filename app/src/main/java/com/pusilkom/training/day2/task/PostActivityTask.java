package com.pusilkom.training.day2.task;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.pusilkom.training.day2.MainActivity;
import com.pusilkom.training.day2.R;
import com.pusilkom.training.day2.model.ListMenuItem;
import com.pusilkom.training.day2.model.Post;
import com.pusilkom.training.day2.model.Repo;
import com.pusilkom.training.day2.model.UserEmail;
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

    public List<UserEmail> getItems() {
        return items;
    }

    private List<UserEmail> items;

    public PostActivityTask(Context ctx) {
        this.context = ctx;
    }

    @Override
    protected Void doInBackground(Object... objects) {

        String password = objects[0].toString();
        String username = objects[1].toString();

        Retrofit client = new Retrofit.Builder()
                .baseUrl(context.getResources().getString(R.string.api_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostService service = client.create(PostService.class);
        String token =  username + ":" + password;
        String tokenAuth = "Basic "+ Base64.encodeToString(token.getBytes(), Base64.DEFAULT);

        Call<List<UserEmail>> call = service.listAllEmail(tokenAuth.trim());
        try {
            Response<List<UserEmail>> response = call.execute();
            Log.d("RESPONSE BACKEND", new Gson().toJson(response.body()));
            items = response.body();

            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra("myRepo", new Gson().toJson(items));

            context.startActivity(intent);

        } catch (IOException e) {
            e.printStackTrace();
        }



        return null;
    }


}
