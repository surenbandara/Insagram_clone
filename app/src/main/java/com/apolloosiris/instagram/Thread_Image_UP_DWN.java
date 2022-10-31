package com.apolloosiris.instagram;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Thread_Image_UP_DWN extends  Thread {
    private PostActivity postActivity;
    private Uri imageUri;
    private ProgressDialog progressDialog;
    private String id;


    public void setdata(PostActivity postActivity, Uri imageUri,ProgressDialog progressDialog,String id) {
        this.postActivity = postActivity;
        this.imageUri = imageUri;
        this.progressDialog= progressDialog;
        this.id=id;

    }

    @Override
    public void run() {
        Bitmap bitmap = null;


        try {
            bitmap = MediaStore.Images.Media.getBitmap(postActivity.getContentResolver(), imageUri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Encoder encoder = new Encoder();
        encoder.Saveimage(bitmap, id, postActivity);
        System.out.println("Saved");
        this.progressDialog.dismiss();
    }


}
