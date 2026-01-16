package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.nG, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17611nG implements InterfaceC10436bc3, InterfaceC12377eW3 {
    private final C22245uu3 a;

    /* renamed from: ir.nasim.nG$a */
    public static final class a implements InterfaceC11734dW3 {
        private final int a;
        private final int b;
        private final Map c;
        private final UA2 d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ C17611nG f;

        a(int i, int i2, Map map, UA2 ua2, UA2 ua22, C17611nG c17611nG) {
            this.e = ua22;
            this.f = c17611nG;
            this.a = i;
            this.b = i2;
            this.c = map;
            this.d = ua2;
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public int getHeight() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public int getWidth() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public void j() {
            this.e.invoke(this.f.h().D1());
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public UA2 k() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public Map t() {
            return this.c;
        }
    }

    public C17611nG(C22245uu3 c22245uu3, InterfaceC17020mG interfaceC17020mG) {
        this.a = c22245uu3;
    }

    @Override // ir.nasim.WH1
    public int A1(long j) {
        return this.a.A1(j);
    }

    @Override // ir.nasim.WH1
    public int B0(float f) {
        return this.a.B0(f);
    }

    @Override // ir.nasim.WH1
    public float D(int i) {
        return this.a.D(i);
    }

    @Override // ir.nasim.InterfaceC12377eW3
    public InterfaceC11734dW3 E0(int i, int i2, Map map, UA2 ua2, UA2 ua22) {
        if (!((i & (-16777216)) == 0 && ((-16777216) & i2) == 0)) {
            M73.b("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new a(i, i2, map, ua2, ua22, this);
    }

    @Override // ir.nasim.WH1
    public float I0(long j) {
        return this.a.I0(j);
    }

    @Override // ir.nasim.WH1
    public long I1(long j) {
        return this.a.I1(j);
    }

    @Override // ir.nasim.InterfaceC12377eW3
    public InterfaceC11734dW3 P1(int i, int i2, Map map, UA2 ua2) {
        return this.a.P1(i, i2, map, ua2);
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public long T(float f) {
        return this.a.T(f);
    }

    @Override // ir.nasim.WH1
    public long U(long j) {
        return this.a.U(j);
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float Y(long j) {
        return this.a.Y(j);
    }

    public final InterfaceC17020mG b() {
        return null;
    }

    @Override // ir.nasim.WH1
    public float getDensity() {
        return this.a.getDensity();
    }

    @Override // ir.nasim.InterfaceC10436bc3
    public EnumC12613eu3 getLayoutDirection() {
        return this.a.getLayoutDirection();
    }

    public final C22245uu3 h() {
        return this.a;
    }

    @Override // ir.nasim.WH1
    public long j0(float f) {
        return this.a.j0(f);
    }

    public long o() {
        DJ3 dj3E2 = this.a.E2();
        AbstractC13042fc3.f(dj3E2);
        InterfaceC11734dW3 interfaceC11734dW3Q1 = dj3E2.q1();
        return C4414Fa3.c((interfaceC11734dW3Q1.getWidth() << 32) | (interfaceC11734dW3Q1.getHeight() & 4294967295L));
    }

    @Override // ir.nasim.WH1
    public float o1(float f) {
        return this.a.o1(f);
    }

    @Override // ir.nasim.InterfaceC10436bc3
    public boolean s0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float t1() {
        return this.a.t1();
    }

    @Override // ir.nasim.WH1
    public float w1(float f) {
        return this.a.w1(f);
    }

    public final void p(InterfaceC17020mG interfaceC17020mG) {
    }
}
