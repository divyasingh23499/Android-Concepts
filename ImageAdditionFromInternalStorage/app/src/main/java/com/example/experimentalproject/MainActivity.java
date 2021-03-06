package com.example.experimentalproject;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "error find";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   public void buttonOnClick(View v)
   {
       Intent i = new Intent();
       i.setType("image/*");
       i.setAction(Intent.ACTION_GET_CONTENT);
       startActivityForResult(Intent.createChooser(i , "Select Image") , 101);
   }

   @Override
    protected void onActivityResult(int requestCode , int resultCode , Intent data) {

       super.onActivityResult(requestCode, resultCode, data);
       if (requestCode == 101 && resultCode == RESULT_OK && data != null)
       {
           Uri uri = data.getData();

           //Name of file

           String path = getRealPAthFromUri(this,uri);
           String name = getFileName(uri);
           try {
               insertInPrivateStorage(name, path);
           }
           catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }

    private void insertInPrivateStorage(String name, String path) throws IOException {
        FileOutputStream fos = openFileOutput(name , MODE_APPEND);
        File file = new File(path);
        byte[] bytes = getBytesFromFile(file);
        fos.write(bytes);
        fos.close();

        Toast.makeText(getApplicationContext() , "File saved in " + getFilesDir() + "/" + name , Toast.LENGTH_SHORT);
    }

    private byte[] getBytesFromFile(File file){
        int size = (int) file.length();
        byte[] bytes = new byte[size];
        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bytes;
    }

    private void createFile(String name, String path) {
    }

    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

    private static String getRealPAthFromUri(Context context , Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(contentUri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } catch (Exception e) {
            Log.e(TAG, "getRealPathFromURI Exception : " + e.toString());
            return "";
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}