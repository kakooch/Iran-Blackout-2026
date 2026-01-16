package ir.nasim;

/* renamed from: ir.nasim.Mw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC6264Mw3 {

    /* renamed from: ir.nasim.Mw3$a */
    public static final class a implements InterfaceC6030Lw3 {
        final /* synthetic */ GT4 a;
        final /* synthetic */ boolean b;

        a(GT4 gt4, boolean z) {
            this.a = gt4;
            this.b = z;
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public int a() {
            return this.a.C().e() + this.a.C().c();
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public float b() {
            return IT4.g(this.a.C(), this.a.H());
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public Object c(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objD0 = GT4.d0(this.a, i, 0.0f, interfaceC20295rm1, 2, null);
            return objD0 == AbstractC14862ic3.e() ? objD0 : C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public OW0 d() {
            return this.b ? new OW0(this.a.H(), 1) : new OW0(1, this.a.H());
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public int e() {
            return (int) (this.a.C().a() == EnumC24286yM4.a ? this.a.C().b() & 4294967295L : this.a.C().b() >> 32);
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public float f() {
            return AbstractC24943zT4.a(this.a);
        }
    }

    public static final InterfaceC6030Lw3 a(GT4 gt4, boolean z) {
        return new a(gt4, z);
    }
}
