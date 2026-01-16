package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC21430te5;
import ir.nasim.C3419Au3;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class BJ3 extends AbstractC21430te5 implements InterfaceC12986fW3, InterfaceC14942ik4 {
    public static final b n = new b(null);
    private static final UA2 o = a.e;
    private InterfaceC14568i76 f;
    private boolean g;
    private boolean h;
    private boolean i;
    private final AbstractC21430te5.a j = AbstractC22087ue5.a(this);
    private C25126zm4 k;
    private C25126zm4 l;
    private C7386Rm4 m;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final void a(C22677ve5 c22677ve5) {
            if (c22677ve5.Z0()) {
                c22677ve5.a().g1(c22677ve5);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C22677ve5) obj);
            return C19938rB7.a;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C22677ve5 e;
        final /* synthetic */ BJ3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C22677ve5 c22677ve5, BJ3 bj3) {
            super(0);
            this.e = c22677ve5;
            this.f = bj3;
        }

        public final void a() {
            UA2 ua2K = this.e.b().k();
            if (ua2K != null) {
                ua2K.invoke(this.f.J1());
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public static final class d implements InterfaceC11734dW3 {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ Map c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ BJ3 f;

        d(int i, int i2, Map map, UA2 ua2, UA2 ua22, BJ3 bj3) {
            this.a = i;
            this.b = i2;
            this.c = map;
            this.d = ua2;
            this.e = ua22;
            this.f = bj3;
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
            this.e.invoke(this.f.D1());
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

    public static final class e implements InterfaceC14568i76 {
        e() {
        }

        @Override // ir.nasim.WH1
        public float getDensity() {
            return BJ3.this.getDensity();
        }

        @Override // ir.nasim.InterfaceC23430wu2
        public float t1() {
            return BJ3.this.t1();
        }
    }

    private final void L1(AbstractC13970h76 abstractC13970h76) {
        C7386Rm4 c7386Rm4 = i1(abstractC13970h76).m;
        C7620Sm4 c7620Sm4 = c7386Rm4 != null ? (C7620Sm4) c7386Rm4.u(abstractC13970h76) : null;
        if (c7620Sm4 != null) {
            T1(c7620Sm4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T1(C7620Sm4 c7620Sm4) {
        C3419Au3 c3419Au3;
        Object[] objArr = c7620Sm4.b;
        long[] jArr = c7620Sm4.a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128 && (c3419Au3 = (C3419Au3) ((E48) objArr[(i << 3) + i3]).get()) != null) {
                        if (s0()) {
                            c3419Au3.y1(false);
                        } else {
                            c3419Au3.C1(false);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g1(ir.nasim.C22677ve5 r25) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.BJ3.g1(ir.nasim.ve5):void");
    }

    private final BJ3 i1(AbstractC13970h76 abstractC13970h76) {
        BJ3 bj3 = this;
        while (true) {
            C25126zm4 c25126zm4 = bj3.k;
            if (c25126zm4 != null && c25126zm4.a(abstractC13970h76)) {
                return bj3;
            }
            BJ3 bj3S1 = bj3.s1();
            if (bj3S1 == null) {
                return bj3;
            }
            bj3 = bj3S1;
        }
    }

    public final AbstractC21430te5.a D1() {
        return this.j;
    }

    @Override // ir.nasim.InterfaceC12377eW3
    public InterfaceC11734dW3 E0(int i, int i2, Map map, UA2 ua2, UA2 ua22) {
        if (!((i & (-16777216)) == 0 && ((-16777216) & i2) == 0)) {
            M73.b("Size(" + i + " x " + i2 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new d(i, i2, map, ua2, ua22, this);
    }

    public abstract long F1();

    @Override // ir.nasim.InterfaceC12986fW3
    public abstract C3419Au3 G1();

    @Override // ir.nasim.InterfaceC14195hW3
    public final int J(AbstractC13165fm abstractC13165fm) {
        int iE1;
        return (l1() && (iE1 = e1(abstractC13165fm)) != Integer.MIN_VALUE) ? iE1 + C22045ua3.l(x0()) : RecyclerView.UNDEFINED_DURATION;
    }

    public final InterfaceC14568i76 J1() {
        InterfaceC14568i76 interfaceC14568i76 = this.f;
        return interfaceC14568i76 == null ? new e() : interfaceC14568i76;
    }

    protected final void K1(XA4 xa4) {
        AbstractC14349hm abstractC14349hmT;
        XA4 xa4K2 = xa4.K2();
        if (!AbstractC13042fc3.d(xa4K2 != null ? xa4K2.G1() : null, xa4.G1())) {
            xa4.y2().t().m();
            return;
        }
        InterfaceC14957im interfaceC14957imE = xa4.y2().E();
        if (interfaceC14957imE == null || (abstractC14349hmT = interfaceC14957imE.t()) == null) {
            return;
        }
        abstractC14349hmT.m();
    }

    public boolean M1() {
        return this.g;
    }

    @Override // ir.nasim.InterfaceC14942ik4
    public void O(boolean z) {
        BJ3 bj3S1 = s1();
        C3419Au3 c3419Au3G1 = bj3S1 != null ? bj3S1.G1() : null;
        if (AbstractC13042fc3.d(c3419Au3G1, G1())) {
            V1(z);
            return;
        }
        if ((c3419Au3G1 != null ? c3419Au3G1.g0() : null) != C3419Au3.e.c) {
            if ((c3419Au3G1 != null ? c3419Au3G1.g0() : null) != C3419Au3.e.d) {
                return;
            }
        }
        V1(z);
    }

    public final boolean R1() {
        return this.i;
    }

    public final boolean S1() {
        return this.h;
    }

    public abstract void U1();

    public void V1(boolean z) {
        this.g = z;
    }

    public final void W1(boolean z) {
        this.i = z;
    }

    public final void X1(boolean z) {
        this.h = z;
    }

    public abstract int e1(AbstractC13165fm abstractC13165fm);

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h1(ir.nasim.InterfaceC11734dW3 r14) {
        /*
            r13 = this;
            if (r14 == 0) goto Lb
            ir.nasim.ve5 r0 = new ir.nasim.ve5
            r0.<init>(r14, r13)
            r13.g1(r0)
            goto L62
        Lb:
            ir.nasim.Rm4 r14 = r13.m
            if (r14 == 0) goto L54
            java.lang.Object[] r0 = r14.c
            long[] r14 = r14.a
            int r1 = r14.length
            int r1 = r1 + (-2)
            if (r1 < 0) goto L54
            r2 = 0
            r3 = r2
        L1a:
            r4 = r14[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L4f
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L34:
            if (r8 >= r6) goto L4d
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L49
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            ir.nasim.Sm4 r9 = (ir.nasim.C7620Sm4) r9
            r13.T1(r9)
        L49:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L34
        L4d:
            if (r6 != r7) goto L54
        L4f:
            if (r3 == r1) goto L54
            int r3 = r3 + 1
            goto L1a
        L54:
            ir.nasim.Rm4 r14 = r13.m
            if (r14 == 0) goto L5b
            r14.k()
        L5b:
            ir.nasim.zm4 r14 = r13.k
            if (r14 == 0) goto L62
            r14.h()
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.BJ3.h1(ir.nasim.dW3):void");
    }

    public abstract BJ3 j1();

    public abstract InterfaceC11379cu3 k1();

    public abstract boolean l1();

    public abstract InterfaceC11734dW3 q1();

    @Override // ir.nasim.InterfaceC10436bc3
    public boolean s0() {
        return false;
    }

    public abstract BJ3 s1();
}
