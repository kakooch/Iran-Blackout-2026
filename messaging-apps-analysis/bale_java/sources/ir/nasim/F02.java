package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
abstract class F02 {
    private static final InterfaceC13106fg0 a = new a();

    static DW5 a(InterfaceC13106fg0 interfaceC13106fg0, Drawable drawable, int i, int i2) {
        Bitmap bitmapB;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmapB = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmapB = null;
        } else {
            bitmapB = b(interfaceC13106fg0, current, i, i2);
            z = true;
        }
        if (!z) {
            interfaceC13106fg0 = a;
        }
        return C14288hg0.d(bitmapB, interfaceC13106fg0);
    }

    private static Bitmap b(InterfaceC13106fg0 interfaceC13106fg0, Drawable drawable, int i, int i2) {
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        Lock lockI = AbstractC16827lv7.i();
        lockI.lock();
        Bitmap bitmapD = interfaceC13106fg0.d(i, i2, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapD);
            drawable.setBounds(0, 0, i, i2);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmapD;
        } finally {
            lockI.unlock();
        }
    }

    class a extends C13697gg0 {
        a() {
        }

        @Override // ir.nasim.C13697gg0, ir.nasim.InterfaceC13106fg0
        public void c(Bitmap bitmap) {
        }
    }
}
