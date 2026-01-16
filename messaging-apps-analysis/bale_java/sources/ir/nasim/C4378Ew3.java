package ir.nasim;

import androidx.compose.runtime.snapshots.g;
import ir.nasim.C4861Gw3;
import ir.nasim.InterfaceC8013Ud5;

/* renamed from: ir.nasim.Ew3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C4378Ew3 implements InterfaceC8013Ud5, InterfaceC8013Ud5.a, C4861Gw3.a {
    private final Object a;
    private final C4861Gw3 b;
    private int d;
    private InterfaceC8013Ud5.a e;
    private boolean f;
    private int c = -1;
    private final InterfaceC9102Ym4 g = AbstractC13472gH6.d(null, null, 2, null);

    public C4378Ew3(Object obj, C4861Gw3 c4861Gw3) {
        this.a = obj;
        this.b = c4861Gw3;
    }

    private final InterfaceC8013Ud5 c() {
        return (InterfaceC8013Ud5) this.g.getValue();
    }

    private final void g(InterfaceC8013Ud5 interfaceC8013Ud5) {
        this.g.setValue(interfaceC8013Ud5);
    }

    @Override // ir.nasim.InterfaceC8013Ud5
    public InterfaceC8013Ud5.a a() {
        if (!(!this.f)) {
            P73.c("Pin should not be called on an already disposed item ");
        }
        if (this.d == 0) {
            this.b.t(this);
            InterfaceC8013Ud5 interfaceC8013Ud5B = b();
            this.e = interfaceC8013Ud5B != null ? interfaceC8013Ud5B.a() : null;
        }
        this.d++;
        return this;
    }

    public final InterfaceC8013Ud5 b() {
        return c();
    }

    public final void d() {
        this.f = true;
    }

    public void e(int i) {
        this.c = i;
    }

    public final void f(InterfaceC8013Ud5 interfaceC8013Ud5) {
        g.a aVar = androidx.compose.runtime.snapshots.g.e;
        androidx.compose.runtime.snapshots.g gVarD = aVar.d();
        UA2 ua2G = gVarD != null ? gVarD.g() : null;
        androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
        try {
            if (interfaceC8013Ud5 != c()) {
                g(interfaceC8013Ud5);
                if (this.d > 0) {
                    InterfaceC8013Ud5.a aVar2 = this.e;
                    if (aVar2 != null) {
                        aVar2.release();
                    }
                    this.e = interfaceC8013Ud5 != null ? interfaceC8013Ud5.a() : null;
                }
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            aVar.l(gVarD, gVarE, ua2G);
        } catch (Throwable th) {
            aVar.l(gVarD, gVarE, ua2G);
            throw th;
        }
    }

    @Override // ir.nasim.C4861Gw3.a
    public int getIndex() {
        return this.c;
    }

    @Override // ir.nasim.C4861Gw3.a
    public Object getKey() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC8013Ud5.a
    public void release() {
        if (this.f) {
            return;
        }
        if (!(this.d > 0)) {
            P73.c("Release should only be called once");
        }
        int i = this.d - 1;
        this.d = i;
        if (i == 0) {
            this.b.v(this);
            InterfaceC8013Ud5.a aVar = this.e;
            if (aVar != null) {
                aVar.release();
            }
            this.e = null;
        }
    }
}
