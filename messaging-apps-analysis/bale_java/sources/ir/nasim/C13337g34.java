package ir.nasim;

import ir.nasim.C10087b34;

/* renamed from: ir.nasim.g34, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13337g34 implements C10087b34.b {
    private final int a;
    private C12701f34 b;

    public C13337g34(int i, C12701f34 c12701f34) {
        AbstractC13042fc3.i(c12701f34, "holder");
        this.a = i;
        this.b = c12701f34;
    }

    @Override // ir.nasim.C10087b34.b
    public int a() {
        return this.a;
    }

    @Override // ir.nasim.C10087b34.b
    public void b() {
        this.b = null;
    }

    @Override // ir.nasim.C10087b34.b
    public void c(String str) {
        C12701f34 c12701f34 = this.b;
        if (c12701f34 != null) {
            c12701f34.M0(str);
        }
    }

    @Override // ir.nasim.C10087b34.b
    public void d(String str) {
        Q14 q14P0;
        C12701f34 c12701f34;
        AbstractC13042fc3.i(str, "formattedPresence");
        C12701f34 c12701f342 = this.b;
        if (c12701f342 == null || (q14P0 = c12701f342.P0()) == null || q14P0.f() != a() || (c12701f34 = this.b) == null) {
            return;
        }
        c12701f34.N0(str);
    }

    @Override // ir.nasim.C10087b34.b
    public void e() {
    }
}
