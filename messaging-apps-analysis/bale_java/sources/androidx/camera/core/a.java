package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.f;
import ir.nasim.AbstractC11476d43;
import ir.nasim.C14935ij7;
import ir.nasim.W13;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class a implements f {
    private final Image a;
    private final C0017a[] b;
    private final W13 c;

    /* renamed from: androidx.camera.core.a$a, reason: collision with other inner class name */
    private static final class C0017a implements f.a {
        private final Image.Plane a;

        C0017a(Image.Plane plane) {
            this.a = plane;
        }

        @Override // androidx.camera.core.f.a
        public int a() {
            return this.a.getRowStride();
        }

        @Override // androidx.camera.core.f.a
        public int b() {
            return this.a.getPixelStride();
        }

        @Override // androidx.camera.core.f.a
        public ByteBuffer getBuffer() {
            return this.a.getBuffer();
        }
    }

    a(Image image) {
        this.a = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.b = new C0017a[planes.length];
            for (int i = 0; i < planes.length; i++) {
                this.b[i] = new C0017a(planes[i]);
            }
        } else {
            this.b = new C0017a[0];
        }
        this.c = AbstractC11476d43.c(C14935ij7.b(), image.getTimestamp(), 0, new Matrix());
    }

    @Override // androidx.camera.core.f
    public int C() {
        return this.a.getFormat();
    }

    @Override // androidx.camera.core.f
    public Image F1() {
        return this.a;
    }

    @Override // androidx.camera.core.f
    public f.a[] P0() {
        return this.b;
    }

    @Override // androidx.camera.core.f, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // androidx.camera.core.f
    public int getHeight() {
        return this.a.getHeight();
    }

    @Override // androidx.camera.core.f
    public int getWidth() {
        return this.a.getWidth();
    }

    @Override // androidx.camera.core.f
    public W13 u1() {
        return this.c;
    }

    @Override // androidx.camera.core.f
    public void y0(Rect rect) {
        this.a.setCropRect(rect);
    }
}
