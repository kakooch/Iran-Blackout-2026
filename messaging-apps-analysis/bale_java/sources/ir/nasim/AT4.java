package ir.nasim;

/* loaded from: classes.dex */
public abstract class AT4 {

    public static final class a implements InterfaceC5563Jw3, InterfaceC8748Xd6 {
        private final /* synthetic */ InterfaceC8748Xd6 a;
        final /* synthetic */ GT4 b;

        a(InterfaceC8748Xd6 interfaceC8748Xd6, GT4 gt4) {
            this.b = gt4;
            this.a = interfaceC8748Xd6;
        }

        @Override // ir.nasim.InterfaceC5563Jw3
        public int a() {
            return this.b.H();
        }

        @Override // ir.nasim.InterfaceC5563Jw3
        public int b() {
            return ((InterfaceC9734aT4) AbstractC15401jX0.C0(this.b.C().i())).getIndex();
        }

        @Override // ir.nasim.InterfaceC5563Jw3
        public void c(int i, int i2) {
            this.b.m0(i, i2 / this.b.J(), true);
        }

        @Override // ir.nasim.InterfaceC8748Xd6
        public float e(float f) {
            return this.a.e(f);
        }

        @Override // ir.nasim.InterfaceC5563Jw3
        public int f(int i, int i2) {
            return (int) (AbstractC23053wG5.o(AbstractC24943zT4.a(this.b) + AbstractC20723sV3.d((((i - this.b.v()) * this.b.J()) - (this.b.w() * this.b.J())) + i2), this.b.F(), this.b.D()) - AbstractC24943zT4.a(this.b));
        }

        @Override // ir.nasim.InterfaceC5563Jw3
        public int g() {
            return this.b.z();
        }

        @Override // ir.nasim.InterfaceC5563Jw3
        public int h() {
            return this.b.y();
        }
    }

    public static final InterfaceC5563Jw3 a(GT4 gt4, InterfaceC8748Xd6 interfaceC8748Xd6) {
        return new a(interfaceC8748Xd6, gt4);
    }
}
