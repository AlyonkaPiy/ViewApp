package applicationcards.viewapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;



public class RhombusesTransact extends BitmapTransformation {
    public RhombusesTransact(Context context) {
        super(context);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return rhombuses(pool, toTransform);
    }

    private static Bitmap rhombuses(BitmapPool pool, Bitmap source) {
        if (source == null) return null;


        int x = (source.getWidth() ) / 2;
        int y = (source.getHeight()  ) / 2;


        // TODO this could be acquired from the pool too
        Bitmap squared = Bitmap.createBitmap(source, x, y, source.getWidth(), source.getHeight());

        Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);

        float x1=(source.getWidth() ) / 2;
        float y1=(source.getHeight() ) / 2;
        float w=x1+source.getWidth();
        float h= y1+source.getHeight();
        RectF rectF=new RectF(x, y, w, h);
        Path path = new Path();

        path.addRect( rectF,Path.Direction.CW);
        canvas.save();
        canvas.rotate(45);
        canvas.drawPath(path, paint);

        return result;
    }

    @Override
    public String getId() {
        return getClass().getName();
    }
}
