package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.impl.v;
import ir.nasim.C24677z13;
import java.util.List;

/* loaded from: classes.dex */
public interface CameraControlInternal {
    public static final CameraControlInternal a = new a();

    public static final class CameraControlException extends Exception {
    }

    class a implements CameraControlInternal {
        a() {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void a(v.b bVar) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public Rect c() {
            return new Rect();
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void d(int i) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public j e() {
            return null;
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void f(j jVar) {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal
        public void g() {
        }
    }

    public interface b {
        void a();

        void b(List list);
    }

    void a(v.b bVar);

    Rect c();

    void d(int i);

    j e();

    void f(j jVar);

    void g();

    default void b(C24677z13.f fVar) {
    }
}
