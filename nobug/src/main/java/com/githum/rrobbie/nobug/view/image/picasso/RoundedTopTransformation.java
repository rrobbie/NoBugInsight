package com.githum.rrobbie.nobug.view.image.picasso;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Path.Direction;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;

import com.squareup.picasso.Transformation;

/**
 * Created by rrobbie on 2015-01-19.
 */
public class RoundedTopTransformation implements Transformation {
    private final int radius;
    private final int margin;

    public RoundedTopTransformation(final int radiusDP, final int marginDP) {
        this.radius = radiusDP;
        this.margin = marginDP;
    }

    @Override
    public Bitmap transform(final Bitmap source) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));

        Bitmap output = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);                        
        canvas.drawRoundRect(new RectF(margin, margin, source.getWidth() - margin, source.getHeight() - margin), radius, radius, paint);
        
        Path bottomPath = new Path();
        bottomPath.addRect(new RectF(margin, source.getHeight() - radius, source.getWidth() - margin, source.getHeight() - margin), Direction.CW);
        canvas.drawPath(bottomPath, paint);
                
        if (source != output) {
            source.recycle();
        }

        return output;
    }

    @Override
    public String key() {
        return "rounded";
    }
}
