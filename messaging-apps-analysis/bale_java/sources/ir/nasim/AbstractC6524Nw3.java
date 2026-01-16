package ir.nasim;

/* renamed from: ir.nasim.Nw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC6524Nw3 {

    /* renamed from: ir.nasim.Nw3$a */
    public static final class a implements InterfaceC6030Lw3 {
        final /* synthetic */ C19206px3 a;
        final /* synthetic */ boolean b;

        a(C19206px3 c19206px3, boolean z) {
            this.a = c19206px3;
            this.b = z;
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public int a() {
            return this.a.x().e() + this.a.x().c();
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public float b() {
            return androidx.compose.foundation.lazy.layout.f.a(this.a.s(), this.a.t(), this.a.e());
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public Object c(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objJ = C19206px3.J(this.a, i, 0, interfaceC20295rm1, 2, null);
            return objJ == AbstractC14862ic3.e() ? objJ : C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public OW0 d() {
            return this.b ? new OW0(-1, 1) : new OW0(1, -1);
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public int e() {
            return (int) (this.a.x().a() == EnumC24286yM4.a ? this.a.x().b() & 4294967295L : this.a.x().b() >> 32);
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public float f() {
            return androidx.compose.foundation.lazy.layout.f.b(this.a.s(), this.a.t());
        }
    }

    public static final InterfaceC6030Lw3 a(C19206px3 c19206px3, boolean z) {
        return new a(c19206px3, z);
    }
}
