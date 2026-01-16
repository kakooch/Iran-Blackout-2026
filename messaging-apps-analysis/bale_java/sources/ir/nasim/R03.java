package ir.nasim;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
public class R03 {
    private static final Object d = new Object();
    private final Context a;
    private final String b;
    private final Map c;

    public R03(Drawable.Callback callback, String str, Q03 q03, Map map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.b = str;
        } else {
            this.b = str + '/';
        }
        this.c = map;
        d(q03);
        if (callback instanceof View) {
            this.a = ((View) callback).getContext().getApplicationContext();
        } else {
            this.a = null;
        }
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (d) {
            ((VK3) this.c.get(str)).g(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        VK3 vk3 = (VK3) this.c.get(str);
        if (vk3 == null) {
            return null;
        }
        Bitmap bitmapB = vk3.b();
        if (bitmapB != null) {
            return bitmapB;
        }
        Context context = this.a;
        if (context == null) {
            return null;
        }
        String strC = vk3.c();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strC.startsWith("data:") && strC.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strC.substring(strC.indexOf(44) + 1), 0);
                try {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                    if (bitmapDecodeByteArray != null) {
                        return c(str, AbstractC16500lN7.m(bitmapDecodeByteArray, vk3.f(), vk3.d()));
                    }
                    JI3.c("Decoded image `" + str + "` is null.");
                    return null;
                } catch (IllegalArgumentException e) {
                    JI3.d("Unable to decode image `" + str + "`.", e);
                    return null;
                }
            } catch (IllegalArgumentException e2) {
                JI3.d("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.b)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.b + strC), null, options);
                if (bitmapDecodeStream != null) {
                    return c(str, AbstractC16500lN7.m(bitmapDecodeStream, vk3.f(), vk3.d()));
                }
                JI3.c("Decoded image `" + str + "` is null.");
                return null;
            } catch (IllegalArgumentException e3) {
                JI3.d("Unable to decode image `" + str + "`.", e3);
                return null;
            }
        } catch (IOException e4) {
            JI3.d("Unable to open asset.", e4);
            return null;
        }
    }

    public boolean b(Context context) {
        if (context == null) {
            return this.a == null;
        }
        if (this.a instanceof Application) {
            context = context.getApplicationContext();
        }
        return context == this.a;
    }

    public void d(Q03 q03) {
    }
}
