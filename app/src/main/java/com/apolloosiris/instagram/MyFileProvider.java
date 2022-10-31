package com.apolloosiris.instagram;

import android.annotation.SuppressLint;

import androidx.core.content.FileProvider;

public class MyFileProvider extends FileProvider {
    @SuppressLint("ResourceType")
    public MyFileProvider() {
        super(3);
    }
}
