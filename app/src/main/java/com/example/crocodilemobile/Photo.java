package com.example.crocodilemobile;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Photo extends Activity {


    private int CAMERA_CAPTURE;
    private Uri pUri;
    final int PIC_CROUP = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);

        Button button = (Button) findViewById(R.id.buttonfoto);
    }
        public void Photo (View view){
            try {
                Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(captureIntent, CAMERA_CAPTURE);
            } catch (ActivityNotFoundException cant) {
                String errorMessage = " No contact";
                Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
            }
        }
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == CAMERA_CAPTURE) {
                pUri = data.getData();
                cropImage();
            } else if (requestCode == PIC_CROUP) {
                Bundle extras = data.getExtras();
                Bitmap thePic = extras.getParcelable("data");
                ImageView picView = (ImageView) findViewById(R.id.imageView2);
                picView.setImageBitmap(thePic);
            }
        }
        private void cropImage () {
            try {
            } catch (ActivityNotFoundException cant) {
                String errorMessage = " No contact";
                Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
                toast.show();
            }
            Intent cropIntent = new Intent("com.android.camera.action.CROUP");
            cropIntent.setDataAndType(pUri, "image/*");
            cropIntent.putExtra("crop", "true");
            cropIntent.putExtra("aspectX", 1);
            cropIntent.putExtra("aspectY", 1);
            //Указываем размер в X и Y
            cropIntent.putExtra("outputX", 256);
            cropIntent.putExtra("outputY", 256);
            //Извлекаем данные:
            cropIntent.putExtra("return-data", true);
            //Запускаем Activity и возвращаемся в метод onActivityResult
            startActivityForResult(cropIntent, PIC_CROUP);
        }
}
