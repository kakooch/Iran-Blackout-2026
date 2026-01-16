package androidx.compose.runtime.snapshots;

import ir.nasim.AbstractC15263jH6;
import ir.nasim.AbstractC16176kp7;
import ir.nasim.C7620Sm4;
import ir.nasim.InterfaceC14710iL6;
import ir.nasim.UA2;
import kotlin.KotlinNothingValueException;

/* loaded from: classes.dex */
public final class l extends b {
    private final b s;
    private final boolean t;
    private final boolean u;
    private UA2 v;
    private UA2 w;
    private final long x;

    public l(b bVar, UA2 ua2, UA2 ua22, boolean z, boolean z2) {
        UA2 ua2K;
        UA2 ua2G;
        super(j.b, i.e.a(), j.K(ua2, (bVar == null || (ua2G = bVar.g()) == null) ? j.k.g() : ua2G, z), j.M(ua22, (bVar == null || (ua2K = bVar.k()) == null) ? j.k.k() : ua2K));
        this.s = bVar;
        this.t = z;
        this.u = z2;
        this.v = super.g();
        this.w = super.k();
        this.x = AbstractC16176kp7.a();
    }

    private final b U() {
        b bVar = this.s;
        return bVar == null ? j.k : bVar;
    }

    @Override // androidx.compose.runtime.snapshots.b
    public h C() {
        return U().C();
    }

    @Override // androidx.compose.runtime.snapshots.b
    public C7620Sm4 E() {
        return U().E();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public UA2 g() {
        return this.v;
    }

    @Override // androidx.compose.runtime.snapshots.b
    public void Q(C7620Sm4 c7620Sm4) {
        AbstractC15263jH6.a();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b
    public b R(UA2 ua2, UA2 ua22) {
        UA2 ua2L = j.L(ua2, g(), false, 4, null);
        UA2 ua2M = j.M(ua22, k());
        return !this.t ? new l(U().R(null, ua2M), ua2L, ua2M, false, true) : U().R(ua2L, ua2M);
    }

    public final long V() {
        return this.x;
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public Void m(g gVar) {
        AbstractC15263jH6.a();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public Void n(g gVar) {
        AbstractC15263jH6.a();
        throw new KotlinNothingValueException();
    }

    public void Y(UA2 ua2) {
        this.v = ua2;
    }

    public void Z(UA2 ua2) {
        this.w = ua2;
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    public void d() {
        b bVar;
        t(true);
        if (!this.u || (bVar = this.s) == null) {
            return;
        }
        bVar.d();
    }

    @Override // androidx.compose.runtime.snapshots.g
    public i f() {
        return U().f();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    public boolean h() {
        return U().h();
    }

    @Override // androidx.compose.runtime.snapshots.g
    public long i() {
        return U().i();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    public int j() {
        return U().j();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    public UA2 k() {
        return this.w;
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    public void o() {
        U().o();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    public void p(InterfaceC14710iL6 interfaceC14710iL6) {
        U().p(interfaceC14710iL6);
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void u(i iVar) {
        AbstractC15263jH6.a();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.g
    public void v(long j) {
        AbstractC15263jH6.a();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    public void w(int i) {
        U().w(i);
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.g
    public g x(UA2 ua2) {
        UA2 ua2L = j.L(ua2, g(), false, 4, null);
        return !this.t ? j.E(U().x(null), ua2L, true) : U().x(ua2L);
    }
}
