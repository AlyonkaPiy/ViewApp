package applicationcards.viewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;

import java.util.List;

import static android.R.attr.width;
import static applicationcards.viewapp.R.attr.height;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview_layout);


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

        ImageView imageViewR= (ImageView) findViewById(R.id.imageViewR);
        int width = Utils.dip2px(MainActivity.this, 933.33f);
        int height = Utils.dip2px(MainActivity.this, 926.33f);
        Glide.with(MainActivity.this)
                .load("http://www.ya-case.ru/upload/catalog/458/55237_47.jpg")
                .override(width, height)
                .bitmapTransform(new FitCenter(MainActivity.this),
                        new MaskTransformation(MainActivity.this, R.drawable.romb))
                .into(imageViewR);

        ImageView imageGif= (ImageView) findViewById(R.id.imageGif);
        Glide   .with( MainActivity.this )
                .load( "http://v.img.com.ua/b/orig/3/b3/d8660522f3acaaa7fed1fa319c2adb33.gif" )
                .error( R.drawable.ic_not_image )
                //http://multik-pic.ru/images/rusalochka/rusalochka36.gif
                .into( imageGif );

        ImageView imageViewN= (ImageView) findViewById(R.id.imageN);
        Glide.with(MainActivity.this)
                .load("http://images1.fanpop.com/images/photos/1700000/Alice-in-Wonderland-1951-alice-in-wonderland-1759199-500-372.jpg")
                .transform(new CircleTransform(MainActivity.this))
                .into(imageViewN);



    }
}
