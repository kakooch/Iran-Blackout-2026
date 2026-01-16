package ir.nasim;

import androidx.camera.core.impl.C;
import androidx.camera.core.impl.D;
import java.util.UUID;

/* renamed from: ir.nasim.fY6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C13007fY6 implements C.a {
    private final androidx.camera.core.impl.q a;

    C13007fY6() {
        this(androidx.camera.core.impl.q.Z());
    }

    @Override // ir.nasim.InterfaceC3513Be2
    public androidx.camera.core.impl.p a() {
        return this.a;
    }

    @Override // androidx.camera.core.impl.C.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C13625gY6 b() {
        return new C13625gY6(androidx.camera.core.impl.r.X(this.a));
    }

    public C13007fY6 d(D.b bVar) {
        a().p(androidx.camera.core.impl.C.B, bVar);
        return this;
    }

    public C13007fY6 e(Class cls) {
        a().p(InterfaceC24505yj7.G, cls);
        if (a().g(InterfaceC24505yj7.F, null) == null) {
            f(cls.getCanonicalName() + "-" + UUID.randomUUID());
        }
        return this;
    }

    public C13007fY6 f(String str) {
        a().p(InterfaceC24505yj7.F, str);
        return this;
    }

    C13007fY6(androidx.camera.core.impl.q qVar) {
        this.a = qVar;
        Class cls = (Class) qVar.g(InterfaceC24505yj7.G, null);
        if (cls == null || cls.equals(C12398eY6.class)) {
            d(D.b.STREAM_SHARING);
            e(C12398eY6.class);
            return;
        }
        throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
    }
}
