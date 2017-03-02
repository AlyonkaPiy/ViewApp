package applicationcards.viewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

/*
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Glide.with(this)
                .load("http://www.ya-case.ru/upload/catalog/458/55237_47.jpg")
                .placeholder(R.drawable.ic_sun)
                .error(R.drawable.ic_not_image)
                .into(imageView);

        ImageView imageViewCircle = (ImageView) findViewById(R.id.imageViewCircle);
        Glide.with(MainActivity.this)
                .load("http://www.ya-case.ru/upload/catalog/458/55237_47.jpg")
                .transform(new CircleTransform(MainActivity.this))
                .into(imageViewCircle);
*/
        ImageView imageViewR= (ImageView) findViewById(R.id.imageViewR);
        Glide.with(MainActivity.this)
                .load("http://www.ya-case.ru/upload/catalog/458/55237_47.jpg")
                .transform(new RhombusesTransact(MainActivity.this))
                .into(imageViewR);

    }
}
