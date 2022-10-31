package com.apolloosiris.instagram;


import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



public class Database_Utill {
    private static final int MODE_PRIVATE = 1;
    private ArrayList<User>  mExampleList;
    private Gson gson;
    private String json;
    private SharedPreferences sharedPreferences;
    private ArrayList<String> media;


    public void saveData(Context context,User user,String email) {
        sharedPreferences = context.getSharedPreferences("shared preferences",Context.MODE_PRIVATE);

        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        gson = new Gson();
        json = gson.toJson(user);
        prefsEditor.putString(email, json);
        prefsEditor.commit();}

    public User loadData(final Context context,String email) {
        sharedPreferences = context.getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        gson = new Gson();
        json = sharedPreferences.getString(email,"");
        User obj=new User("","","","");
        try{obj = gson.fromJson(json, User.class);}
        catch(Exception e){}
        return obj;}



    public String saveToInternalStorage(Bitmap bitmapImage, String id, Context context){
        ContextWrapper cw = new ContextWrapper(context);
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,id+".jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

    public Bitmap loadImageFromStorage(String id,Context context)
    {

        try {
            ContextWrapper cw = new ContextWrapper(context);
            File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);


            File f=new File(directory, id+".jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            return b;
            //img.setImageBitmap(b);
        }
        catch (Exception e)
        {   return null;

        }

    }
}
