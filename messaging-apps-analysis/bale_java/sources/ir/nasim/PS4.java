package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.internal.utils.ImageUtil;

/* loaded from: classes.dex */
public abstract class PS4 {
    public static PS4 j(Bitmap bitmap, C14871id2 c14871id2, Rect rect, int i, Matrix matrix, QB0 qb0) {
        return new C21321tT(bitmap, c14871id2, 42, new Size(bitmap.getWidth(), bitmap.getHeight()), rect, i, matrix, qb0);
    }

    public static PS4 k(androidx.camera.core.f fVar, C14871id2 c14871id2, Rect rect, int i, Matrix matrix, QB0 qb0) {
        return l(fVar, c14871id2, new Size(fVar.getWidth(), fVar.getHeight()), rect, i, matrix, qb0);
    }

    public static PS4 l(androidx.camera.core.f fVar, C14871id2 c14871id2, Size size, Rect rect, int i, Matrix matrix, QB0 qb0) {
        if (ImageUtil.g(fVar.C())) {
            AbstractC4980Hj5.h(c14871id2, "JPEG image must have Exif.");
        }
        return new C21321tT(fVar, c14871id2, fVar.C(), size, rect, i, matrix, qb0);
    }

    public static PS4 m(byte[] bArr, C14871id2 c14871id2, int i, Size size, Rect rect, int i2, Matrix matrix, QB0 qb0) {
        return new C21321tT(bArr, c14871id2, i, size, rect, i2, matrix, qb0);
    }

    public abstract QB0 a();

    public abstract Rect b();

    public abstract Object c();

    public abstract C14871id2 d();

    public abstract int e();

    public abstract int f();

    public abstract Matrix g();

    public abstract Size h();

    public boolean i() {
        return AbstractC14447hv7.h(b(), h());
    }
}
