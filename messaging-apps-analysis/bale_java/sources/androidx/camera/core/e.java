package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.f;
import ir.nasim.W13;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class e implements f {
    protected final f b;
    private final Object a = new Object();
    private final Set c = new HashSet();

    public interface a {
        void a(f fVar);
    }

    protected e(f fVar) {
        this.b = fVar;
    }

    @Override // androidx.camera.core.f
    public int C() {
        return this.b.C();
    }

    @Override // androidx.camera.core.f
    public Image F1() {
        return this.b.F1();
    }

    @Override // androidx.camera.core.f
    public f.a[] P0() {
        return this.b.P0();
    }

    public void a(a aVar) {
        synchronized (this.a) {
            this.c.add(aVar);
        }
    }

    protected void b() {
        HashSet hashSet;
        synchronized (this.a) {
            hashSet = new HashSet(this.c);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(this);
        }
    }

    @Override // androidx.camera.core.f, java.lang.AutoCloseable
    public void close() {
        this.b.close();
        b();
    }

    @Override // androidx.camera.core.f
    public int getHeight() {
        return this.b.getHeight();
    }

    @Override // androidx.camera.core.f
    public int getWidth() {
        return this.b.getWidth();
    }

    @Override // androidx.camera.core.f
    public W13 u1() {
        return this.b.u1();
    }

    @Override // androidx.camera.core.f
    public void y0(Rect rect) {
        this.b.y0(rect);
    }
}
