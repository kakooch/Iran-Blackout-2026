package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class ZP6 {
    public static final ZP6 a = new ZP6();

    private ZP6() {
    }

    public final Bitmap a(View view) {
        AbstractC13042fc3.i(view, "view");
        view.measure(View.MeasureSpec.makeMeasureSpec(((Number) b(view).e()).intValue(), ((Number) b(view).e()).intValue()), View.MeasureSpec.makeMeasureSpec(((Number) b(view).f()).intValue(), ((Number) b(view).f()).intValue()));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        return bitmapCreateBitmap;
    }

    public final XV4 b(View view) {
        AbstractC13042fc3.i(view, "view");
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            return new XV4(Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
        }
        throw new IllegalStateException("View dimensions are invalid: width=" + measuredWidth + ", height=" + measuredHeight);
    }

    public final String c(Context context, Bitmap bitmap) throws IOException {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(bitmap, "bitmap");
        String absolutePath = new File(context.getCacheDir(), System.currentTimeMillis() + ".png").getAbsolutePath();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return absolutePath;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public final String d(Context context, Drawable drawable) throws IOException {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(drawable, "drawable");
        File file = new File(context.getCacheDir(), "temp_drawable.png");
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String absolutePath = file.getAbsolutePath();
        AbstractC13042fc3.h(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }
}
