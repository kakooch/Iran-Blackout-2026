package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Rational;
import android.util.Size;
import ir.nasim.AbstractC17949np7;
import ir.nasim.AbstractC4217Ee4;

/* loaded from: classes.dex */
class j extends AbstractC4217Ee4 {
    static final PointF e = new PointF(2.0f, 2.0f);
    private final e b;
    private Rect c = null;
    private Matrix d;

    j(e eVar) {
        this.b = eVar;
    }

    void b(Size size, int i) {
        Rect rect;
        AbstractC17949np7.a();
        synchronized (this) {
            try {
                if (size.getWidth() != 0 && size.getHeight() != 0 && (rect = this.c) != null) {
                    this.d = this.b.c(size, i, rect);
                    return;
                }
                this.d = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(Rect rect) {
        a(new Rational(rect.width(), rect.height()));
        synchronized (this) {
            this.c = rect;
        }
    }
}
