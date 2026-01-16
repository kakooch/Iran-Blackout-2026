package ir.nasim;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;

/* renamed from: ir.nasim.hv7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14447hv7 {
    public static final RectF a = new RectF(-1.0f, -1.0f, 1.0f, 1.0f);

    public static float a(float f, float f2, float f3, float f4) {
        float f5 = (f * f3) + (f2 * f4);
        float f6 = (f * f4) - (f2 * f3);
        double dSqrt = Math.sqrt((f * f) + (f2 * f2)) * Math.sqrt((f3 * f3) + (f4 * f4));
        return (float) Math.toDegrees(Math.atan2(f6 / dSqrt, f5 / dSqrt));
    }

    public static Matrix b(Rect rect) {
        return c(new RectF(rect));
    }

    public static Matrix c(RectF rectF) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(a, rectF, Matrix.ScaleToFit.FILL);
        return matrix;
    }

    public static Matrix d(RectF rectF, RectF rectF2, int i) {
        return e(rectF, rectF2, i, false);
    }

    public static Matrix e(RectF rectF, RectF rectF2, int i, boolean z) {
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, a, Matrix.ScaleToFit.FILL);
        matrix.postRotate(i);
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
        }
        matrix.postConcat(c(rectF2));
        return matrix;
    }

    public static Size f(Rect rect, int i) {
        return o(m(rect), i);
    }

    public static int g(Matrix matrix) {
        matrix.getValues(new float[9]);
        return u((int) Math.round(Math.atan2(r0[3], r0[0]) * 57.29577951308232d));
    }

    public static boolean h(Rect rect, Size size) {
        return (rect.left == 0 && rect.top == 0 && rect.width() == size.getWidth() && rect.height() == size.getHeight()) ? false : true;
    }

    public static boolean i(int i) {
        if (i == 90 || i == 270) {
            return true;
        }
        if (i == 0 || i == 180) {
            return false;
        }
        throw new IllegalArgumentException("Invalid rotation degrees: " + i);
    }

    public static boolean j(Size size, Size size2) {
        return k(size, false, size2, false);
    }

    public static boolean k(Size size, boolean z, Size size2, boolean z2) {
        float width;
        float width2;
        float width3;
        float width4;
        if (z) {
            width = size.getWidth() / size.getHeight();
            width2 = width;
        } else {
            width = (size.getWidth() + 1.0f) / (size.getHeight() - 1.0f);
            width2 = (size.getWidth() - 1.0f) / (size.getHeight() + 1.0f);
        }
        if (z2) {
            width3 = size2.getWidth() / size2.getHeight();
            width4 = width3;
        } else {
            width3 = (size2.getWidth() - 1.0f) / (size2.getHeight() + 1.0f);
            width4 = (size2.getWidth() + 1.0f) / (size2.getHeight() - 1.0f);
        }
        return width >= width3 && width4 >= width2;
    }

    public static boolean l(Matrix matrix) {
        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
        matrix.mapVectors(fArr);
        return a(fArr[0], fArr[1], fArr[2], fArr[3]) > 0.0f;
    }

    public static Size m(Rect rect) {
        return new Size(rect.width(), rect.height());
    }

    public static Size n(Size size) {
        return new Size(size.getHeight(), size.getWidth());
    }

    public static Size o(Size size, int i) {
        AbstractC4980Hj5.b(i % 90 == 0, "Invalid rotation degrees: " + i);
        return i(u(i)) ? n(size) : size;
    }

    public static Rect p(Size size) {
        return q(size, 0, 0);
    }

    public static Rect q(Size size, int i, int i2) {
        return new Rect(i, i2, size.getWidth() + i, size.getHeight() + i2);
    }

    public static RectF r(Size size) {
        return s(size, 0, 0);
    }

    public static RectF s(Size size, int i, int i2) {
        return new RectF(i, i2, i + size.getWidth(), i2 + size.getHeight());
    }

    public static Matrix t(Matrix matrix, Rect rect) {
        Matrix matrix2 = new Matrix(matrix);
        matrix2.postTranslate(-rect.left, -rect.top);
        return matrix2;
    }

    public static int u(int i) {
        return ((i % 360) + 360) % 360;
    }
}
