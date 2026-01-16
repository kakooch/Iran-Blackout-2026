package androidx.compose.runtime.snapshots;

import ir.nasim.AbstractC15263jH6;
import ir.nasim.AbstractC16176kp7;
import ir.nasim.InterfaceC14710iL6;
import ir.nasim.UA2;
import kotlin.KotlinNothingValueException;

/* loaded from: classes.dex */
public final class m extends g {
    private final g g;
    private final boolean h;
    private final boolean i;
    private UA2 j;
    private final UA2 k;
    private final long l;
    private final g m;

    public m(g gVar, UA2 ua2, boolean z, boolean z2) {
        UA2 ua2G;
        super(j.b, i.e.a(), null);
        this.g = gVar;
        this.h = z;
        this.i = z2;
        this.j = j.K(ua2, (gVar == null || (ua2G = gVar.g()) == null) ? j.k.g() : ua2G, z);
        this.l = AbstractC16176kp7.a();
        this.m = this;
    }

    private final g A() {
        g gVar = this.g;
        return gVar == null ? j.k : gVar;
    }

    @Override // androidx.compose.runtime.snapshots.g
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public UA2 g() {
        return this.j;
    }

    public final long C() {
        return this.l;
    }

    @Override // androidx.compose.runtime.snapshots.g
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public Void m(g gVar) {
        AbstractC15263jH6.a();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.g
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public Void n(g gVar) {
        AbstractC15263jH6.a();
        throw new KotlinNothingValueException();
    }

    public void F(UA2 ua2) {
        this.j = ua2;
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void d() {
        g gVar;
        t(true);
        if (!this.i || (gVar = this.g) == null) {
            return;
        }
        gVar.d();
    }

    @Override // androidx.compose.runtime.snapshots.g
    public i f() {
        return A().f();
    }

    @Override // androidx.compose.runtime.snapshots.g
    public boolean h() {
        return A().h();
    }

    @Override // androidx.compose.runtime.snapshots.g
    public long i() {
        return A().i();
    }

    @Override // androidx.compose.runtime.snapshots.g
    public UA2 k() {
        return this.k;
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void o() {
        A().o();
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void p(InterfaceC14710iL6 interfaceC14710iL6) {
        A().p(interfaceC14710iL6);
    }

    @Override // androidx.compose.runtime.snapshots.g
    public g x(UA2 ua2) {
        UA2 ua2L = j.L(ua2, g(), false, 4, null);
        return !this.h ? j.E(A().x(null), ua2L, true) : A().x(ua2L);
    }
}
