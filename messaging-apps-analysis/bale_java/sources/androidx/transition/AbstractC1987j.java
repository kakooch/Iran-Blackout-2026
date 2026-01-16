package androidx.transition;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* renamed from: androidx.transition.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC1987j {
    private static boolean a = true;

    static void a(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 29) {
            imageView.animateTransform(matrix);
            return;
        }
        if (matrix != null) {
            b(imageView, matrix);
            return;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
            imageView.invalidate();
        }
    }

    private static void b(ImageView imageView, Matrix matrix) {
        if (a) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }
}
