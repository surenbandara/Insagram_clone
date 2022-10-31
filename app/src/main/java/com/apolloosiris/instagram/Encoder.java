package com.apolloosiris.instagram;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;

import java.util.ArrayList;

public class Encoder {
    private Uri imageuri;
    private Database_Utill database_utill=new Database_Utill();

    public void Saveimage(Bitmap data, String id, Context context){

        database_utill.saveToInternalStorage(data,id,context);
    }

    public Bitmap Loadimage(String id,Context context){

        //ImageView image = (ImageView)this.findViewById(R.id.ImageView);
        //image.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));

        return database_utill.loadImageFromStorage(id,context);
    }

}
