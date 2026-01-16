package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import ir.nasim.W13;

/* loaded from: classes.dex */
public final class j extends e {
    private final Object d;
    private final W13 e;
    private Rect f;
    private final int g;
    private final int h;

    j(f fVar, W13 w13) {
        this(fVar, null, w13);
    }

    @Override // androidx.camera.core.e, androidx.camera.core.f
    public int getHeight() {
        return this.h;
    }

    @Override // androidx.camera.core.e, androidx.camera.core.f
    public int getWidth() {
        return this.g;
    }

    @Override // androidx.camera.core.e, androidx.camera.core.f
    public W13 u1() {
        return this.e;
    }

    @Override // androidx.camera.core.e, androidx.camera.core.f
    public void y0(Rect rect) {
        if (rect != null) {
            Rect rect2 = new Rect(rect);
            if (!rect2.intersect(0, 0, getWidth(), getHeight())) {
                rect2.setEmpty();
            }
            rect = rect2;
        }
        synchronized (this.d) {
            this.f = rect;
        }
    }

    public j(f fVar, Size size, W13 w13) {
        super(fVar);
        this.d = new Object();
        if (size == null) {
            this.g = super.getWidth();
            this.h = super.getHeight();
        } else {
            this.g = size.getWidth();
            this.h = size.getHeight();
        }
        this.e = w13;
    }
}
