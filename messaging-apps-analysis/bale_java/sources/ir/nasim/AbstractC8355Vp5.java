package ir.nasim;

import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.core.impl.v;
import ir.nasim.BB0;

/* renamed from: ir.nasim.Vp5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8355Vp5 {
    public static final Rational a = new Rational(16, 9);

    private static boolean a(Size size, Rational rational) {
        return rational.equals(new Rational(size.getWidth(), size.getHeight()));
    }

    public static void b(Size size, v.b bVar) {
        if (((PreviewPixelHDRnetQuirk) androidx.camera.camera2.internal.compat.quirk.b.b(PreviewPixelHDRnetQuirk.class)) == null || a(size, a)) {
            return;
        }
        BB0.a aVar = new BB0.a();
        aVar.f(CaptureRequest.TONEMAP_MODE, 2);
        bVar.g(aVar.c());
    }
}
