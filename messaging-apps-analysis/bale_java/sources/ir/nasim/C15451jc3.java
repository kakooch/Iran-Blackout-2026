package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.jc3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15451jc3 implements InterfaceC12377eW3, InterfaceC10436bc3 {
    private final EnumC12613eu3 a;
    private final /* synthetic */ InterfaceC10436bc3 b;

    public C15451jc3(InterfaceC10436bc3 interfaceC10436bc3, EnumC12613eu3 enumC12613eu3) {
        this.a = enumC12613eu3;
        this.b = interfaceC10436bc3;
    }

    @Override // ir.nasim.WH1
    public int A1(long j) {
        return this.b.A1(j);
    }

    @Override // ir.nasim.WH1
    public int B0(float f) {
        return this.b.B0(f);
    }

    @Override // ir.nasim.WH1
    public float D(int i) {
        return this.b.D(i);
    }

    @Override // ir.nasim.InterfaceC12377eW3
    public InterfaceC11734dW3 E0(int i, int i2, Map map, UA2 ua2, UA2 ua22) {
        boolean z = false;
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if ((i & (-16777216)) == 0 && ((-16777216) & i2) == 0) {
            z = true;
        }
        if (!z) {
            M73.b("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new a(i, i2, map, ua2);
    }

    @Override // ir.nasim.WH1
    public float I0(long j) {
        return this.b.I0(j);
    }

    @Override // ir.nasim.WH1
    public long I1(long j) {
        return this.b.I1(j);
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public long T(float f) {
        return this.b.T(f);
    }

    @Override // ir.nasim.WH1
    public long U(long j) {
        return this.b.U(j);
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float Y(long j) {
        return this.b.Y(j);
    }

    @Override // ir.nasim.WH1
    public float getDensity() {
        return this.b.getDensity();
    }

    @Override // ir.nasim.InterfaceC10436bc3
    public EnumC12613eu3 getLayoutDirection() {
        return this.a;
    }

    @Override // ir.nasim.WH1
    public long j0(float f) {
        return this.b.j0(f);
    }

    @Override // ir.nasim.WH1
    public float o1(float f) {
        return this.b.o1(f);
    }

    @Override // ir.nasim.InterfaceC10436bc3
    public boolean s0() {
        return this.b.s0();
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float t1() {
        return this.b.t1();
    }

    @Override // ir.nasim.WH1
    public float w1(float f) {
        return this.b.w1(f);
    }

    /* renamed from: ir.nasim.jc3$a */
    public static final class a implements InterfaceC11734dW3 {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ Map c;
        final /* synthetic */ UA2 d;

        a(int i, int i2, Map map, UA2 ua2) {
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
        public UA2 k() {
            return this.d;
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public Map t() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public void j() {
        }
    }
}
