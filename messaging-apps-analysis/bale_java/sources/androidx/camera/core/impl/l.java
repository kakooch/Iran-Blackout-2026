package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.impl.v;
import ir.nasim.C24677z13;

/* loaded from: classes.dex */
public abstract class l implements CameraControlInternal {
    private final CameraControlInternal b;

    public l(CameraControlInternal cameraControlInternal) {
        this.b = cameraControlInternal;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void a(v.b bVar) {
        this.b.a(bVar);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void b(C24677z13.f fVar) {
        this.b.b(fVar);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Rect c() {
        return this.b.c();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void d(int i) {
        this.b.d(i);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public j e() {
        return this.b.e();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void f(j jVar) {
        this.b.f(jVar);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void g() {
        this.b.g();
    }
}
