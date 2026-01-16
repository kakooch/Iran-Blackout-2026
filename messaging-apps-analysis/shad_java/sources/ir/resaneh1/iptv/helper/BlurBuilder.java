package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* loaded from: classes3.dex */
public class BlurBuilder {
    public static Bitmap blur(Context context, Bitmap bitmap) {
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.4f), Math.round(bitmap.getHeight() * 0.4f), false);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
        RenderScript renderScriptCreate = RenderScript.create(context);
        int i = Build.VERSION.SDK_INT;
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = i >= 17 ? ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate)) : null;
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
        Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
        if (i >= 17) {
            scriptIntrinsicBlurCreate.setRadius(7.5f);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
        }
        allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }
}
