package ir.nasim;

import android.widget.ImageView;
import org.xbill.DNS.dnssec.ValidatingResolver;

/* renamed from: ir.nasim.dN7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11657dN7 {
    public static final C11657dN7 a = new C11657dN7();

    private C11657dN7() {
    }

    public static final void a(float f, float f2) {
        if (f >= f2) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Maximum zoom. Call setMinimumZoom() with a more appropriate value".toString());
        }
    }

    public static final int b(int i) {
        return (i & ValidatingResolver.VALIDATION_REASON_QCLASS) >> 8;
    }

    public static final boolean c(ImageView imageView) {
        AbstractC13042fc3.i(imageView, "imageView");
        return imageView.getDrawable() != null;
    }

    public static final boolean d(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (scaleType != ImageView.ScaleType.MATRIX) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
