package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import okio.BufferedSource;

/* renamed from: ir.nasim.vd2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22664vd2 {
    public static final C22664vd2 a = new C22664vd2();
    private static final Paint b = new Paint(3);

    private C22664vd2() {
    }

    public final C16642ld2 a(String str, BufferedSource bufferedSource, EnumC19597qd2 enumC19597qd2) {
        if (!AbstractC23260wd2.c(enumC19597qd2, str)) {
            return C16642ld2.d;
        }
        C17233md2 c17233md2 = new C17233md2(new C18415od2(bufferedSource.peek().inputStream()));
        return new C16642ld2(c17233md2.y(), c17233md2.p());
    }

    public final Bitmap b(Bitmap bitmap, C16642ld2 c16642ld2) {
        if (!c16642ld2.b() && !AbstractC23260wd2.a(c16642ld2)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width = bitmap.getWidth() / 2.0f;
        float height = bitmap.getHeight() / 2.0f;
        if (c16642ld2.b()) {
            matrix.postScale(-1.0f, 1.0f, width, height);
        }
        if (AbstractC23260wd2.a(c16642ld2)) {
            matrix.postRotate(c16642ld2.a(), width, height);
        }
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        float f = rectF.left;
        if (f != 0.0f || rectF.top != 0.0f) {
            matrix.postTranslate(-f, -rectF.top);
        }
        Bitmap bitmapCreateBitmap = AbstractC23260wd2.b(c16642ld2) ? Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), AbstractC10667c.c(bitmap)) : Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), AbstractC10667c.c(bitmap));
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, matrix, b);
        bitmap.recycle();
        return bitmapCreateBitmap;
    }
}
