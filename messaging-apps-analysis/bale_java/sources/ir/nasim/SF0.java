package ir.nasim;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.extensions.internal.compat.quirk.CaptureOutputSurfaceOccupiedQuirk;
import ir.nasim.O23;

/* loaded from: classes.dex */
public class SF0 {
    private final ImageWriter b;
    private final O23 c;
    private final Surface e;
    private final boolean f;
    private final boolean g;
    private final Object a = new Object();
    private boolean d = false;
    long h = -1;

    static final class a {
        static void a(Image image, long j) {
            image.setTimestamp(j);
        }
    }

    static final class b {
        static void a(ImageWriter imageWriter) {
            imageWriter.close();
        }

        static ImageWriter b(Surface surface, int i, int i2) {
            return ImageWriter.newInstance(surface, i, i2);
        }

        static void c(ImageWriter imageWriter, Image image) {
            imageWriter.queueInputImage(image);
        }
    }

    public SF0(Surface surface, Size size, boolean z) {
        this.g = z;
        boolean z2 = androidx.camera.extensions.internal.compat.quirk.a.b(CaptureOutputSurfaceOccupiedQuirk.class) != null || z;
        this.f = z2;
        if (Build.VERSION.SDK_INT < 29 || !z2) {
            this.e = surface;
            this.c = null;
            this.b = null;
        } else {
            PI3.a("CaptureOutputSurface", "Enabling intermediate surface");
            O23 o23A = androidx.camera.core.g.a(size.getWidth(), size.getHeight(), 35, 2);
            this.c = o23A;
            this.e = o23A.getSurface();
            this.b = b.b(surface, 2, 35);
            o23A.f(new O23.a() { // from class: ir.nasim.RF0
                @Override // ir.nasim.O23.a
                public final void a(O23 o23) {
                    this.a.d(o23);
                }
            }, AbstractC20567sE0.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(O23 o23) {
        Image imageF1;
        synchronized (this.a) {
            try {
                if (this.d) {
                    return;
                }
                androidx.camera.core.f fVarG = o23.g();
                if (fVarG != null && (imageF1 = fVarG.F1()) != null) {
                    if (this.g) {
                        long j = this.h;
                        if (j != -1) {
                            a.a(imageF1, j);
                        }
                    }
                    b.c(this.b, imageF1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        synchronized (this.a) {
            try {
                this.d = true;
                if (Build.VERSION.SDK_INT >= 29 && this.f) {
                    this.c.d();
                    this.c.close();
                    b.a(this.b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Surface c() {
        return this.e;
    }

    public void e(long j) {
        if (this.g) {
            this.h = j;
        }
    }
}
