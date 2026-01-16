package ir.nasim;

import android.content.Context;
import androidx.camera.core.impl.D;
import androidx.camera.core.impl.i;
import androidx.camera.core.impl.v;

/* loaded from: classes.dex */
public final class GB0 implements androidx.camera.core.impl.D {
    final C21341tV1 b;

    public GB0(Context context) {
        this.b = C21341tV1.c(context);
    }

    @Override // androidx.camera.core.impl.D
    public androidx.camera.core.impl.j a(D.b bVar, int i) {
        androidx.camera.core.impl.q qVarZ = androidx.camera.core.impl.q.Z();
        v.b bVar2 = new v.b();
        bVar2.w(AbstractC3333Ak7.b(bVar, i));
        qVarZ.p(androidx.camera.core.impl.C.t, bVar2.o());
        qVarZ.p(androidx.camera.core.impl.C.v, FB0.a);
        i.a aVar = new i.a();
        aVar.r(AbstractC3333Ak7.a(bVar, i));
        qVarZ.p(androidx.camera.core.impl.C.u, aVar.h());
        qVarZ.p(androidx.camera.core.impl.C.w, bVar == D.b.IMAGE_CAPTURE ? C13.c : C19931rB0.a);
        if (bVar == D.b.PREVIEW) {
            qVarZ.p(androidx.camera.core.impl.o.p, this.b.f());
        }
        qVarZ.p(androidx.camera.core.impl.o.k, Integer.valueOf(this.b.d(true).getRotation()));
        if (bVar == D.b.VIDEO_CAPTURE || bVar == D.b.STREAM_SHARING) {
            qVarZ.p(androidx.camera.core.impl.C.z, Boolean.TRUE);
        }
        return androidx.camera.core.impl.r.X(qVarZ);
    }
}
