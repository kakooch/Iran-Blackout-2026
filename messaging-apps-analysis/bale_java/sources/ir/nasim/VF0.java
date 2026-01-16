package ir.nasim;

import androidx.camera.core.impl.j;
import ir.nasim.VF0;

/* loaded from: classes.dex */
public class VF0 implements androidx.camera.core.impl.u {
    private final androidx.camera.core.impl.j H;

    public static final class a implements InterfaceC3513Be2 {
        private final androidx.camera.core.impl.q a = androidx.camera.core.impl.q.Z();

        public static a e(final androidx.camera.core.impl.j jVar) {
            final a aVar = new a();
            jVar.c("camera2.captureRequest.option.", new j.b() { // from class: ir.nasim.UF0
                @Override // androidx.camera.core.impl.j.b
                public final boolean a(j.a aVar2) {
                    return VF0.a.f(this.a, jVar, aVar2);
                }
            });
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean f(a aVar, androidx.camera.core.impl.j jVar, j.a aVar2) {
            aVar.a().n(aVar2, jVar.h(aVar2), jVar.a(aVar2));
            return true;
        }

        @Override // ir.nasim.InterfaceC3513Be2
        public androidx.camera.core.impl.p a() {
            return this.a;
        }

        public VF0 d() {
            return new VF0(androidx.camera.core.impl.r.X(this.a));
        }
    }

    public VF0(androidx.camera.core.impl.j jVar) {
        this.H = jVar;
    }

    @Override // androidx.camera.core.impl.u
    public androidx.camera.core.impl.j getConfig() {
        return this.H;
    }
}
