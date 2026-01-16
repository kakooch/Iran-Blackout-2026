package ir.nasim;

import androidx.compose.runtime.snapshots.g;
import androidx.compose.ui.e;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import ir.nasim.AbstractC11873dh5;
import kotlin.KotlinNothingValueException;

/* loaded from: classes2.dex */
public abstract class XA4 extends BJ3 implements ZV3, InterfaceC11379cu3, InterfaceC24304yO4 {
    public static final e E0 = new e(null);
    private static final UA2 F0 = d.e;
    private static final UA2 G0 = c.e;
    private static final androidx.compose.ui.graphics.d H0 = new androidx.compose.ui.graphics.d();
    private static final C7921Tt3 I0 = new C7921Tt3();
    private static final float[] J0 = AV3.c(null, 1, null);
    private static final f K0 = new a();
    private static final f L0 = new b();
    private InterfaceC11734dW3 A;
    private C3348Am4 B;
    private boolean B0;
    private InterfaceC23124wO4 C0;
    private C21226tK2 D0;
    private float G;
    private C6908Pm4 H;
    private C7921Tt3 J;
    private C21226tK2 Y;
    private UE0 Z;
    private final C3419Au3 p;
    private boolean q;
    private boolean r;
    private XA4 s;
    private XA4 t;
    private boolean u;
    private boolean v;
    private UA2 w;
    private InterfaceC14603iB2 z0;
    private WH1 x = G1().T();
    private EnumC12613eu3 y = G1().getLayoutDirection();
    private float z = 0.8f;
    private long D = C22045ua3.b.b();
    private final SA2 A0 = new i();

    public static final class a implements f {
        a() {
        }

        @Override // ir.nasim.XA4.f
        public int a() {
            return AbstractC9572aB4.a(16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [androidx.compose.ui.e$c] */
        /* JADX WARN: Type inference failed for: r10v1, types: [androidx.compose.ui.e$c] */
        /* JADX WARN: Type inference failed for: r10v10 */
        /* JADX WARN: Type inference failed for: r10v11 */
        /* JADX WARN: Type inference failed for: r10v12 */
        /* JADX WARN: Type inference failed for: r10v4 */
        /* JADX WARN: Type inference failed for: r10v5, types: [androidx.compose.ui.e$c] */
        /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r10v7 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r10v9 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v11 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [ir.nasim.en4] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6, types: [ir.nasim.en4] */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r3v9 */
        @Override // ir.nasim.XA4.f
        public boolean b(e.c cVar) {
            int iA = AbstractC9572aB4.a(16);
            ?? c12544en4 = 0;
            while (cVar != 0) {
                if (cVar instanceof InterfaceC8508Wg5) {
                    if (((InterfaceC8508Wg5) cVar).k0()) {
                        return true;
                    }
                } else if ((cVar.W1() & iA) != 0 && (cVar instanceof RG1)) {
                    e.c cVarW2 = cVar.w2();
                    int i = 0;
                    c12544en4 = c12544en4;
                    cVar = cVar;
                    while (cVarW2 != null) {
                        if ((cVarW2.W1() & iA) != 0) {
                            i++;
                            c12544en4 = c12544en4;
                            if (i == 1) {
                                cVar = cVarW2;
                            } else {
                                if (c12544en4 == 0) {
                                    c12544en4 = new C12544en4(new e.c[16], 0);
                                }
                                if (cVar != 0) {
                                    c12544en4.d(cVar);
                                    cVar = 0;
                                }
                                c12544en4.d(cVarW2);
                            }
                        }
                        cVarW2 = cVarW2.S1();
                        c12544en4 = c12544en4;
                        cVar = cVar;
                    }
                    if (i == 1) {
                    }
                }
                cVar = KG1.h(c12544en4);
            }
            return false;
        }

        @Override // ir.nasim.XA4.f
        public boolean c(C3419Au3 c3419Au3) {
            return true;
        }

        @Override // ir.nasim.XA4.f
        public void d(C3419Au3 c3419Au3, long j, C18367oY2 c18367oY2, int i, boolean z) {
            c3419Au3.H0(j, c18367oY2, i, z);
        }
    }

    public static final class b implements f {
        b() {
        }

        @Override // ir.nasim.XA4.f
        public int a() {
            return AbstractC9572aB4.a(8);
        }

        @Override // ir.nasim.XA4.f
        public boolean b(e.c cVar) {
            return false;
        }

        @Override // ir.nasim.XA4.f
        public boolean c(C3419Au3 c3419Au3) {
            SemanticsConfiguration semanticsConfigurationE = c3419Au3.e();
            boolean z = false;
            if (semanticsConfigurationE != null && semanticsConfigurationE.B()) {
                z = true;
            }
            return !z;
        }

        @Override // ir.nasim.XA4.f
        public void d(C3419Au3 c3419Au3, long j, C18367oY2 c18367oY2, int i, boolean z) {
            c3419Au3.J0(j, c18367oY2, i, z);
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        public final void a(XA4 xa4) {
            InterfaceC23124wO4 interfaceC23124wO4D2 = xa4.D2();
            if (interfaceC23124wO4D2 != null) {
                interfaceC23124wO4D2.invalidate();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((XA4) obj);
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        public final void a(XA4 xa4) {
            if (xa4.Z0() && XA4.G3(xa4, false, 1, null)) {
                C3419Au3 c3419Au3G1 = xa4.G1();
                C4594Fu3 c4594Fu3E0 = c3419Au3G1.e0();
                if (c4594Fu3E0.d() > 0) {
                    if (c4594Fu3E0.f() || c4594Fu3E0.g()) {
                        C3419Au3.D1(c3419Au3G1, false, 1, null);
                    }
                    c4594Fu3E0.w().e2();
                }
                InterfaceC23714xO4 interfaceC23714xO4B = AbstractC4360Eu3.b(c3419Au3G1);
                interfaceC23714xO4B.getRectManager().j(c3419Au3G1);
                interfaceC23714xO4B.b(c3419Au3G1);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((XA4) obj);
            return C19938rB7.a;
        }
    }

    public static final class e {
        private e() {
        }

        public final f a() {
            return XA4.K0;
        }

        public final f b() {
            return XA4.L0;
        }

        public /* synthetic */ e(ED1 ed1) {
            this();
        }
    }

    public interface f {
        int a();

        boolean b(e.c cVar);

        boolean c(C3419Au3 c3419Au3);

        void d(C3419Au3 c3419Au3, long j, C18367oY2 c18367oY2, int i, boolean z);
    }

    static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(SA2 sa2) {
            super(2);
            this.f = sa2;
        }

        public final void a(UE0 ue0, C21226tK2 c21226tK2) {
            if (!XA4.this.G1().o()) {
                XA4.this.B0 = true;
                return;
            }
            XA4.this.Z = ue0;
            XA4.this.Y = c21226tK2;
            XA4.this.I2().i(XA4.this, XA4.G0, this.f);
            XA4.this.B0 = false;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((UE0) obj, (C21226tK2) obj2);
            return C19938rB7.a;
        }
    }

    static final class h extends AbstractC8614Ws3 implements SA2 {
        h() {
            super(0);
        }

        public final void a() {
            XA4 xa4 = XA4.this;
            UE0 ue0 = xa4.Z;
            AbstractC13042fc3.f(ue0);
            xa4.s2(ue0, XA4.this.Y);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class i extends AbstractC8614Ws3 implements SA2 {
        i() {
            super(0);
        }

        public final void a() {
            XA4 xa4L2 = XA4.this.L2();
            if (xa4L2 != null) {
                xa4L2.U2();
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ e.c f;
        final /* synthetic */ f g;
        final /* synthetic */ long h;
        final /* synthetic */ C18367oY2 i;
        final /* synthetic */ int j;
        final /* synthetic */ boolean k;
        final /* synthetic */ float l;
        final /* synthetic */ boolean m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(e.c cVar, f fVar, long j, C18367oY2 c18367oY2, int i, boolean z, float f, boolean z2) {
            super(0);
            this.f = cVar;
            this.g = fVar;
            this.h = j;
            this.i = c18367oY2;
            this.j = i;
            this.k = z;
            this.l = f;
            this.m = z2;
        }

        public final void a() {
            XA4.this.j3(YA4.d(this.f, this.g.a(), AbstractC9572aB4.a(2)), this.g, this.h, this.i, this.j, this.k, this.l, this.m);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ e.c f;
        final /* synthetic */ f g;
        final /* synthetic */ long h;
        final /* synthetic */ C18367oY2 i;
        final /* synthetic */ int j;
        final /* synthetic */ boolean k;
        final /* synthetic */ float l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(e.c cVar, f fVar, long j, C18367oY2 c18367oY2, int i, boolean z, float f) {
            super(0);
            this.f = cVar;
            this.g = fVar;
            this.h = j;
            this.i = c18367oY2;
            this.j = i;
            this.k = z;
            this.l = f;
        }

        public final void a() {
            XA4.this.j3(YA4.d(this.f, this.g.a(), AbstractC9572aB4.a(2)), this.g, this.h, this.i, this.j, this.k, this.l, false);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(UA2 ua2) {
            super(0);
            this.e = ua2;
        }

        public final void a() {
            this.e.invoke(XA4.H0);
            XA4.H0.W();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public XA4(C3419Au3 c3419Au3) {
        this.p = c3419Au3;
    }

    private final void B3(XA4 xa4, float[] fArr) {
        if (AbstractC13042fc3.d(xa4, this)) {
            return;
        }
        XA4 xa42 = this.t;
        AbstractC13042fc3.f(xa42);
        xa42.B3(xa4, fArr);
        if (!C22045ua3.j(F1(), C22045ua3.b.b())) {
            float[] fArr2 = J0;
            AV3.h(fArr2);
            AV3.o(fArr2, -C22045ua3.k(F1()), -C22045ua3.l(F1()), 0.0f, 4, null);
            AV3.l(fArr, fArr2);
        }
        InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
        if (interfaceC23124wO4 != null) {
            interfaceC23124wO4.i(fArr);
        }
    }

    private final void C3(XA4 xa4, float[] fArr) {
        XA4 xa42 = this;
        while (!AbstractC13042fc3.d(xa42, xa4)) {
            InterfaceC23124wO4 interfaceC23124wO4 = xa42.C0;
            if (interfaceC23124wO4 != null) {
                interfaceC23124wO4.a(fArr);
            }
            if (!C22045ua3.j(xa42.F1(), C22045ua3.b.b())) {
                float[] fArr2 = J0;
                AV3.h(fArr2);
                AV3.o(fArr2, C22045ua3.k(r1), C22045ua3.l(r1), 0.0f, 4, null);
                AV3.l(fArr, fArr2);
            }
            xa42 = xa42.t;
            AbstractC13042fc3.f(xa42);
        }
    }

    public static /* synthetic */ void E3(XA4 xa4, UA2 ua2, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerBlock");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        xa4.D3(ua2, z);
    }

    private final boolean F3(boolean z) {
        InterfaceC23714xO4 interfaceC23714xO4Z0;
        if (this.D0 != null) {
            return false;
        }
        InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
        if (interfaceC23124wO4 == null) {
            if (!(this.w == null)) {
                M73.b("null layer with a non-null layerBlock");
            }
            return false;
        }
        UA2 ua2 = this.w;
        if (ua2 == null) {
            M73.c("updateLayerParameters requires a non-null layerBlock");
            throw new KotlinNothingValueException();
        }
        androidx.compose.ui.graphics.d dVar = H0;
        dVar.N();
        dVar.O(G1().T());
        dVar.P(G1().getLayoutDirection());
        dVar.S(AbstractC4663Ga3.d(a()));
        I2().i(this, F0, new l(ua2));
        C7921Tt3 c7921Tt3 = this.J;
        if (c7921Tt3 == null) {
            c7921Tt3 = new C7921Tt3();
            this.J = c7921Tt3;
        }
        C7921Tt3 c7921Tt32 = I0;
        c7921Tt32.b(c7921Tt3);
        c7921Tt3.a(dVar);
        interfaceC23124wO4.h(dVar);
        boolean z2 = this.v;
        this.v = dVar.o();
        this.z = dVar.b();
        boolean z3 = !c7921Tt32.c(c7921Tt3);
        if (z && ((z3 || z2 != this.v) && (interfaceC23714xO4Z0 = G1().z0()) != null)) {
            interfaceC23714xO4Z0.q(G1());
        }
        return z3;
    }

    static /* synthetic */ boolean G3(XA4 xa4, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLayerParameters");
        }
        if ((i2 & 1) != 0) {
            z = true;
        }
        return xa4.F3(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C24898zO4 I2() {
        return AbstractC4360Eu3.b(G1()).getSnapshotObserver();
    }

    private final boolean N2(int i2) {
        e.c cVarP2 = P2(AbstractC10166bB4.i(i2));
        return cVarP2 != null && KG1.f(cVarP2, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e.c P2(boolean z) {
        e.c cVarJ2;
        if (G1().w0() == this) {
            return G1().t0().k();
        }
        if (z) {
            XA4 xa4 = this.t;
            if (xa4 != null && (cVarJ2 = xa4.J2()) != null) {
                return cVarJ2.S1();
            }
        } else {
            XA4 xa42 = this.t;
            if (xa42 != null) {
                return xa42.J2();
            }
        }
        return null;
    }

    private final void Q2(e.c cVar, f fVar, long j2, C18367oY2 c18367oY2, int i2, boolean z) {
        if (cVar == null) {
            T2(fVar, j2, c18367oY2, i2, z);
            return;
        }
        int i3 = c18367oY2.c;
        c18367oY2.O(c18367oY2.c + 1, c18367oY2.size());
        c18367oY2.c++;
        c18367oY2.a.n(cVar);
        c18367oY2.b.d(AbstractC18958pY2.a(-1.0f, z, false));
        Q2(YA4.d(cVar, fVar.a(), AbstractC9572aB4.a(2)), fVar, j2, c18367oY2, i2, z);
        c18367oY2.c = i3;
    }

    private final void R2(e.c cVar, f fVar, long j2, C18367oY2 c18367oY2, int i2, boolean z, float f2) {
        if (cVar == null) {
            T2(fVar, j2, c18367oY2, i2, z);
            return;
        }
        int i3 = c18367oY2.c;
        c18367oY2.O(c18367oY2.c + 1, c18367oY2.size());
        c18367oY2.c++;
        c18367oY2.a.n(cVar);
        c18367oY2.b.d(AbstractC18958pY2.a(f2, z, false));
        j3(YA4.d(cVar, fVar.a(), AbstractC9572aB4.a(2)), fVar, j2, c18367oY2, i2, z, f2, true);
        c18367oY2.c = i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r9v1, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    private final boolean V2(e.c cVar, long j2, int i2) {
        if (cVar == 0) {
            return false;
        }
        AbstractC11873dh5.a aVar = AbstractC11873dh5.a;
        if (!AbstractC11873dh5.g(i2, aVar.c()) && !AbstractC11873dh5.g(i2, aVar.a())) {
            return false;
        }
        int iA = AbstractC9572aB4.a(16);
        ?? c12544en4 = 0;
        while (cVar != 0) {
            if (cVar instanceof InterfaceC8508Wg5) {
                long jT0 = ((InterfaceC8508Wg5) cVar).T0();
                int i3 = (int) (j2 >> 32);
                if (Float.intBitsToFloat(i3) < (-AbstractC15034it7.b(jT0, getLayoutDirection())) || Float.intBitsToFloat(i3) >= N0() + AbstractC15034it7.c(jT0, getLayoutDirection())) {
                    return false;
                }
                int i4 = (int) (j2 & 4294967295L);
                return Float.intBitsToFloat(i4) >= ((float) (-AbstractC15034it7.h(jT0))) && Float.intBitsToFloat(i4) < ((float) (F0() + AbstractC15034it7.e(jT0)));
            }
            if ((cVar.W1() & iA) != 0 && (cVar instanceof RG1)) {
                e.c cVarW2 = cVar.w2();
                int i5 = 0;
                c12544en4 = c12544en4;
                cVar = cVar;
                while (cVarW2 != null) {
                    if ((cVarW2.W1() & iA) != 0) {
                        i5++;
                        c12544en4 = c12544en4;
                        if (i5 == 1) {
                            cVar = cVarW2;
                        } else {
                            if (c12544en4 == 0) {
                                c12544en4 = new C12544en4(new e.c[16], 0);
                            }
                            if (cVar != 0) {
                                c12544en4.d(cVar);
                                cVar = 0;
                            }
                            c12544en4.d(cVarW2);
                        }
                    }
                    cVarW2 = cVarW2.S1();
                    c12544en4 = c12544en4;
                    cVar = cVar;
                }
                if (i5 == 1) {
                }
            }
            cVar = KG1.h(c12544en4);
        }
        return false;
    }

    private final long Y2(long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
        float fMax = Math.max(0.0f, fIntBitsToFloat < 0.0f ? -fIntBitsToFloat : fIntBitsToFloat - N0());
        return ZG4.e((Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (j2 & 4294967295L)) < 0.0f ? -r6 : r6 - F0())) & 4294967295L) | (Float.floatToRawIntBits(fMax) << 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j3(e.c cVar, f fVar, long j2, C18367oY2 c18367oY2, int i2, boolean z, float f2, boolean z2) {
        if (cVar == null) {
            T2(fVar, j2, c18367oY2, i2, z);
            return;
        }
        if (V2(cVar, j2, i2)) {
            c18367oY2.E(cVar, z, new j(cVar, fVar, j2, c18367oY2, i2, z, f2, z2));
        } else if (z2) {
            R2(cVar, fVar, j2, c18367oY2, i2, z, f2);
        } else {
            w3(cVar, fVar, j2, c18367oY2, i2, z, f2);
        }
    }

    private final void l3(long j2, float f2, UA2 ua2, C21226tK2 c21226tK2) {
        if (c21226tK2 != null) {
            if (!(ua2 == null)) {
                M73.a("both ways to create layers shouldn't be used together");
            }
            if (this.D0 != c21226tK2) {
                this.D0 = null;
                E3(this, null, false, 2, null);
                this.D0 = c21226tK2;
            }
            if (this.C0 == null) {
                InterfaceC23124wO4 interfaceC23124wO4X = InterfaceC23714xO4.x(AbstractC4360Eu3.b(G1()), z2(), this.A0, c21226tK2, false, 8, null);
                interfaceC23124wO4X.e(H0());
                interfaceC23124wO4X.j(j2);
                this.C0 = interfaceC23124wO4X;
                G1().L1(true);
                this.A0.invoke();
            }
        } else {
            if (this.D0 != null) {
                this.D0 = null;
                E3(this, null, false, 2, null);
            }
            E3(this, ua2, false, 2, null);
        }
        if (!C22045ua3.j(F1(), j2)) {
            s3(j2);
            G1().e0().w().e2();
            InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
            if (interfaceC23124wO4 != null) {
                interfaceC23124wO4.j(j2);
            } else {
                XA4 xa4 = this.t;
                if (xa4 != null) {
                    xa4.U2();
                }
            }
            K1(this);
            InterfaceC23714xO4 interfaceC23714xO4Z0 = G1().z0();
            if (interfaceC23714xO4Z0 != null) {
                interfaceC23714xO4Z0.q(G1());
            }
        }
        this.G = f2;
        if (R1()) {
            return;
        }
        h1(q1());
    }

    private final void m2(XA4 xa4, C6908Pm4 c6908Pm4, boolean z) {
        if (xa4 == this) {
            return;
        }
        XA4 xa42 = this.t;
        if (xa42 != null) {
            xa42.m2(xa4, c6908Pm4, z);
        }
        x2(c6908Pm4, z);
    }

    private final long n2(XA4 xa4, long j2, boolean z) {
        if (xa4 == this) {
            return j2;
        }
        XA4 xa42 = this.t;
        return (xa42 == null || AbstractC13042fc3.d(xa4, xa42)) ? v2(j2, z) : v2(xa42.n2(xa4, j2, z), z);
    }

    public static /* synthetic */ void o3(XA4 xa4, C6908Pm4 c6908Pm4, boolean z, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        xa4.n3(c6908Pm4, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s2(UE0 ue0, C21226tK2 c21226tK2) {
        e.c cVarO2 = O2(AbstractC9572aB4.a(4));
        if (cVarO2 == null) {
            k3(ue0, c21226tK2);
        } else {
            G1().l0().o(ue0, AbstractC4663Ga3.d(a()), this, cVarO2, c21226tK2);
        }
    }

    public static /* synthetic */ long w2(XA4 xa4, long j2, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fromParentPosition-8S9VItk");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return xa4.v2(j2, z);
    }

    private final void w3(e.c cVar, f fVar, long j2, C18367oY2 c18367oY2, int i2, boolean z, float f2) {
        if (cVar == null) {
            T2(fVar, j2, c18367oY2, i2, z);
        } else if (fVar.b(cVar)) {
            c18367oY2.P(cVar, f2, z, new k(cVar, fVar, j2, c18367oY2, i2, z, f2));
        } else {
            j3(YA4.d(cVar, fVar.a(), AbstractC9572aB4.a(2)), fVar, j2, c18367oY2, i2, z, f2, false);
        }
    }

    private final void x2(C6908Pm4 c6908Pm4, boolean z) {
        float fK = C22045ua3.k(F1());
        c6908Pm4.i(c6908Pm4.b() - fK);
        c6908Pm4.j(c6908Pm4.c() - fK);
        float fL = C22045ua3.l(F1());
        c6908Pm4.k(c6908Pm4.d() - fL);
        c6908Pm4.h(c6908Pm4.a() - fL);
        InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
        if (interfaceC23124wO4 != null) {
            interfaceC23124wO4.f(c6908Pm4, true);
            if (this.v && z) {
                c6908Pm4.e(0.0f, 0.0f, (int) (a() >> 32), (int) (a() & 4294967295L));
                c6908Pm4.f();
            }
        }
    }

    private final XA4 x3(InterfaceC11379cu3 interfaceC11379cu3) {
        XA4 xa4C;
        EJ3 ej3 = interfaceC11379cu3 instanceof EJ3 ? (EJ3) interfaceC11379cu3 : null;
        if (ej3 != null && (xa4C = ej3.c()) != null) {
            return xa4C;
        }
        AbstractC13042fc3.g(interfaceC11379cu3, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (XA4) interfaceC11379cu3;
    }

    private final InterfaceC14603iB2 z2() {
        InterfaceC14603iB2 interfaceC14603iB2 = this.z0;
        if (interfaceC14603iB2 != null) {
            return interfaceC14603iB2;
        }
        g gVar = new g(new h());
        this.z0 = gVar;
        return gVar;
    }

    public static /* synthetic */ long z3(XA4 xa4, long j2, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toParentPosition-8S9VItk");
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return xa4.y3(j2, z);
    }

    public final boolean A2() {
        return this.r;
    }

    public final CK5 A3() {
        if (!b()) {
            return CK5.e.a();
        }
        InterfaceC11379cu3 interfaceC11379cu3D = AbstractC12000du3.d(this);
        C6908Pm4 c6908Pm4H2 = H2();
        long jO2 = o2(F2());
        int i2 = (int) (jO2 >> 32);
        c6908Pm4H2.i(-Float.intBitsToFloat(i2));
        int i3 = (int) (jO2 & 4294967295L);
        c6908Pm4H2.k(-Float.intBitsToFloat(i3));
        c6908Pm4H2.j(N0() + Float.intBitsToFloat(i2));
        c6908Pm4H2.h(F0() + Float.intBitsToFloat(i3));
        XA4 xa4 = this;
        while (xa4 != interfaceC11379cu3D) {
            xa4.n3(c6908Pm4H2, false, true);
            if (c6908Pm4H2.f()) {
                return CK5.e.a();
            }
            xa4 = xa4.t;
            AbstractC13042fc3.f(xa4);
        }
        return AbstractC7152Qm4.a(c6908Pm4H2);
    }

    public final boolean B2() {
        return this.B0;
    }

    public final long C2() {
        return O0();
    }

    public final InterfaceC23124wO4 D2() {
        return this.C0;
    }

    public final void D3(UA2 ua2, boolean z) {
        InterfaceC23714xO4 interfaceC23714xO4Z0;
        if (!(ua2 == null || this.D0 == null)) {
            M73.a("layerBlock can't be provided when explicitLayer is provided");
        }
        C3419Au3 c3419Au3G1 = G1();
        boolean z2 = (!z && this.w == ua2 && AbstractC13042fc3.d(this.x, c3419Au3G1.T()) && this.y == c3419Au3G1.getLayoutDirection()) ? false : true;
        this.x = c3419Au3G1.T();
        this.y = c3419Au3G1.getLayoutDirection();
        if (!c3419Au3G1.b() || ua2 == null) {
            this.w = null;
            InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
            if (interfaceC23124wO4 != null) {
                interfaceC23124wO4.destroy();
                c3419Au3G1.L1(true);
                this.A0.invoke();
                if (b() && c3419Au3G1.o() && (interfaceC23714xO4Z0 = c3419Au3G1.z0()) != null) {
                    interfaceC23714xO4Z0.q(c3419Au3G1);
                }
            }
            this.C0 = null;
            this.B0 = false;
            return;
        }
        this.w = ua2;
        if (this.C0 != null) {
            if (z2 && G3(this, false, 1, null)) {
                AbstractC4360Eu3.b(c3419Au3G1).getRectManager().j(c3419Au3G1);
                return;
            }
            return;
        }
        InterfaceC23124wO4 interfaceC23124wO4X = InterfaceC23714xO4.x(AbstractC4360Eu3.b(c3419Au3G1), z2(), this.A0, null, c3419Au3G1.W(), 4, null);
        interfaceC23124wO4X.e(H0());
        interfaceC23124wO4X.j(F1());
        this.C0 = interfaceC23124wO4X;
        G3(this, false, 1, null);
        c3419Au3G1.L1(true);
        this.A0.invoke();
    }

    public abstract DJ3 E2();

    @Override // ir.nasim.InterfaceC11379cu3
    public long F(InterfaceC11379cu3 interfaceC11379cu3, long j2) {
        return P(interfaceC11379cu3, j2, true);
    }

    @Override // ir.nasim.BJ3
    public long F1() {
        return this.D;
    }

    public final long F2() {
        return this.x.I1(G1().D0().e());
    }

    @Override // ir.nasim.BJ3, ir.nasim.InterfaceC12986fW3
    public C3419Au3 G1() {
        return this.p;
    }

    public final InterfaceC11379cu3 G2() {
        if (!b()) {
            M73.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        a3();
        return this.t;
    }

    protected final C6908Pm4 H2() {
        C6908Pm4 c6908Pm4 = this.H;
        if (c6908Pm4 != null) {
            return c6908Pm4;
        }
        C6908Pm4 c6908Pm42 = new C6908Pm4(0.0f, 0.0f, 0.0f, 0.0f);
        this.H = c6908Pm42;
        return c6908Pm42;
    }

    protected final boolean H3(long j2) {
        if ((((9187343241974906880L ^ (j2 & 9187343241974906880L)) - 4294967297L) & (-9223372034707292160L)) != 0) {
            return false;
        }
        InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
        return interfaceC23124wO4 == null || !this.v || interfaceC23124wO4.g(j2);
    }

    public abstract e.c J2();

    public final XA4 K2() {
        return this.s;
    }

    public final XA4 L2() {
        return this.t;
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long M(long j2) {
        if (!b()) {
            M73.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        InterfaceC11379cu3 interfaceC11379cu3D = AbstractC12000du3.d(this);
        return F(interfaceC11379cu3D, ZG4.p(AbstractC4360Eu3.b(G1()).r(j2), AbstractC12000du3.e(interfaceC11379cu3D)));
    }

    public final float M2() {
        return this.G;
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public CK5 N(InterfaceC11379cu3 interfaceC11379cu3, boolean z) {
        if (!b()) {
            M73.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        if (!interfaceC11379cu3.b()) {
            M73.b("LayoutCoordinates " + interfaceC11379cu3 + " is not attached!");
        }
        XA4 xa4X3 = x3(interfaceC11379cu3);
        xa4X3.a3();
        XA4 xa4U2 = u2(xa4X3);
        C6908Pm4 c6908Pm4H2 = H2();
        c6908Pm4H2.i(0.0f);
        c6908Pm4H2.k(0.0f);
        c6908Pm4H2.j((int) (interfaceC11379cu3.a() >> 32));
        c6908Pm4H2.h((int) (interfaceC11379cu3.a() & 4294967295L));
        while (xa4X3 != xa4U2) {
            o3(xa4X3, c6908Pm4H2, z, false, 4, null);
            if (c6908Pm4H2.f()) {
                return CK5.e.a();
            }
            xa4X3 = xa4X3.t;
            AbstractC13042fc3.f(xa4X3);
        }
        m2(xa4U2, c6908Pm4H2, z);
        return AbstractC7152Qm4.a(c6908Pm4H2);
    }

    public final e.c O2(int i2) {
        boolean zI = AbstractC10166bB4.i(i2);
        e.c cVarJ2 = J2();
        if (!zI && (cVarJ2 = cVarJ2.Y1()) == null) {
            return null;
        }
        for (e.c cVarP2 = P2(zI); cVarP2 != null && (cVarP2.R1() & i2) != 0; cVarP2 = cVarP2.S1()) {
            if ((cVarP2.W1() & i2) != 0) {
                return cVarP2;
            }
            if (cVarP2 == cVarJ2) {
                return null;
            }
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long P(InterfaceC11379cu3 interfaceC11379cu3, long j2, boolean z) {
        if (interfaceC11379cu3 instanceof EJ3) {
            ((EJ3) interfaceC11379cu3).c().a3();
            return ZG4.e(interfaceC11379cu3.P(this, ZG4.e(j2 ^ (-9223372034707292160L)), z) ^ (-9223372034707292160L));
        }
        XA4 xa4X3 = x3(interfaceC11379cu3);
        xa4X3.a3();
        XA4 xa4U2 = u2(xa4X3);
        while (xa4X3 != xa4U2) {
            j2 = xa4X3.y3(j2, z);
            xa4X3 = xa4X3.t;
            AbstractC13042fc3.f(xa4X3);
        }
        return n2(xa4U2, j2, z);
    }

    public final void S2(f fVar, long j2, C18367oY2 c18367oY2, int i2, boolean z) {
        e.c cVarO2 = O2(fVar.a());
        if (!H3(j2)) {
            if (AbstractC11873dh5.g(i2, AbstractC11873dh5.a.d())) {
                float fP2 = p2(j2, F2());
                if ((Float.floatToRawIntBits(fP2) & Integer.MAX_VALUE) >= 2139095040 || !c18367oY2.I(fP2, false)) {
                    return;
                }
                R2(cVarO2, fVar, j2, c18367oY2, i2, false, fP2);
                return;
            }
            return;
        }
        if (cVarO2 == null) {
            T2(fVar, j2, c18367oY2, i2, z);
        } else if (W2(j2)) {
            Q2(cVarO2, fVar, j2, c18367oY2, i2, z);
        } else {
            float fP22 = !AbstractC11873dh5.g(i2, AbstractC11873dh5.a.d()) ? Float.POSITIVE_INFINITY : p2(j2, F2());
            j3(cVarO2, fVar, j2, c18367oY2, i2, z, fP22, (Float.floatToRawIntBits(fP22) & Integer.MAX_VALUE) < 2139095040 && c18367oY2.I(fP22, z));
        }
    }

    public void T2(f fVar, long j2, C18367oY2 c18367oY2, int i2, boolean z) {
        XA4 xa4 = this.s;
        if (xa4 != null) {
            xa4.S2(fVar, w2(xa4, j2, false, 2, null), c18367oY2, i2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC21430te5
    public void U0(long j2, float f2, UA2 ua2) {
        if (!this.q) {
            l3(j2, f2, ua2, null);
            return;
        }
        DJ3 dj3E2 = E2();
        AbstractC13042fc3.f(dj3E2);
        l3(dj3E2.F1(), f2, ua2, null);
    }

    @Override // ir.nasim.BJ3
    public void U1() {
        C21226tK2 c21226tK2 = this.D0;
        if (c21226tK2 != null) {
            W0(F1(), this.G, c21226tK2);
        } else {
            U0(F1(), this.G, this.w);
        }
    }

    public void U2() {
        InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
        if (interfaceC23124wO4 != null) {
            interfaceC23124wO4.invalidate();
            return;
        }
        XA4 xa4 = this.t;
        if (xa4 != null) {
            xa4.U2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC21430te5
    public void W0(long j2, float f2, C21226tK2 c21226tK2) {
        if (!this.q) {
            l3(j2, f2, null, c21226tK2);
            return;
        }
        DJ3 dj3E2 = E2();
        AbstractC13042fc3.f(dj3E2);
        l3(dj3E2.F1(), f2, null, c21226tK2);
    }

    protected final boolean W2(long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L));
        return fIntBitsToFloat >= 0.0f && fIntBitsToFloat2 >= 0.0f && fIntBitsToFloat < ((float) N0()) && fIntBitsToFloat2 < ((float) F0());
    }

    public final boolean X2() {
        if (this.C0 != null && this.z <= 0.0f) {
            return true;
        }
        XA4 xa4 = this.t;
        if (xa4 != null) {
            return xa4.X2();
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC24304yO4
    public boolean Z0() {
        return (this.C0 == null || this.u || !G1().b()) ? false : true;
    }

    public final void Z2() {
        if (this.C0 != null || this.w == null) {
            return;
        }
        InterfaceC23124wO4 interfaceC23124wO4X = InterfaceC23714xO4.x(AbstractC4360Eu3.b(G1()), z2(), this.A0, this.D0, false, 8, null);
        interfaceC23124wO4X.e(H0());
        interfaceC23124wO4X.j(F1());
        interfaceC23124wO4X.invalidate();
        this.C0 = interfaceC23124wO4X;
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public final long a() {
        return H0();
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long a0(long j2) {
        return AbstractC4360Eu3.b(G1()).d(p0(j2));
    }

    public final void a3() {
        G1().e0().I();
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public boolean b() {
        return J2().b2();
    }

    public final void b3() {
        InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
        if (interfaceC23124wO4 != null) {
            interfaceC23124wO4.destroy();
        }
        this.C0 = null;
    }

    public void c3() {
        InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
        if (interfaceC23124wO4 != null) {
            interfaceC23124wO4.invalidate();
        }
    }

    public final void d3() {
        D3(this.w, true);
        InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
        if (interfaceC23124wO4 != null) {
            interfaceC23124wO4.invalidate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [ir.nasim.en4] */
    protected void e3(int i2, int i3) {
        XA4 xa4;
        InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
        if (interfaceC23124wO4 != null) {
            interfaceC23124wO4.e(C4414Fa3.c((i2 << 32) | (i3 & 4294967295L)));
        } else if (G1().o() && (xa4 = this.t) != null) {
            xa4.U2();
        }
        Y0(C4414Fa3.c((i3 & 4294967295L) | (i2 << 32)));
        if (this.w != null) {
            F3(false);
        }
        int iA = AbstractC9572aB4.a(4);
        boolean zI = AbstractC10166bB4.i(iA);
        e.c cVarJ2 = J2();
        if (zI || (cVarJ2 = cVarJ2.Y1()) != null) {
            for (e.c cVarP2 = P2(zI); cVarP2 != null && (cVarP2.R1() & iA) != 0; cVarP2 = cVarP2.S1()) {
                if ((cVarP2.W1() & iA) != 0) {
                    RG1 rg1H = cVarP2;
                    ?? c12544en4 = 0;
                    while (rg1H != 0) {
                        if (rg1H instanceof InterfaceC15687k02) {
                            ((InterfaceC15687k02) rg1H).l1();
                        } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                            e.c cVarW2 = rg1H.w2();
                            int i4 = 0;
                            rg1H = rg1H;
                            c12544en4 = c12544en4;
                            while (cVarW2 != null) {
                                if ((cVarW2.W1() & iA) != 0) {
                                    i4++;
                                    c12544en4 = c12544en4;
                                    if (i4 == 1) {
                                        rg1H = cVarW2;
                                    } else {
                                        if (c12544en4 == 0) {
                                            c12544en4 = new C12544en4(new e.c[16], 0);
                                        }
                                        if (rg1H != 0) {
                                            c12544en4.d(rg1H);
                                            rg1H = 0;
                                        }
                                        c12544en4.d(cVarW2);
                                    }
                                }
                                cVarW2 = cVarW2.S1();
                                rg1H = rg1H;
                                c12544en4 = c12544en4;
                            }
                            if (i4 == 1) {
                            }
                        }
                        rg1H = KG1.h(c12544en4);
                    }
                }
                if (cVarP2 == cVarJ2) {
                    break;
                }
            }
        }
        InterfaceC23714xO4 interfaceC23714xO4Z0 = G1().z0();
        if (interfaceC23714xO4Z0 != null) {
            interfaceC23714xO4Z0.q(G1());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r9v7, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.Object] */
    public final void f3() {
        e.c cVarY1;
        if (N2(AbstractC9572aB4.a(128))) {
            g.a aVar = androidx.compose.runtime.snapshots.g.e;
            androidx.compose.runtime.snapshots.g gVarD = aVar.d();
            UA2 ua2G = gVarD != null ? gVarD.g() : null;
            androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
            try {
                int iA = AbstractC9572aB4.a(128);
                boolean zI = AbstractC10166bB4.i(iA);
                if (!zI) {
                    cVarY1 = J2().Y1();
                    if (cVarY1 == null) {
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    aVar.l(gVarD, gVarE, ua2G);
                }
                cVarY1 = J2();
                for (e.c cVarP2 = P2(zI); cVarP2 != null && (cVarP2.R1() & iA) != 0; cVarP2 = cVarP2.S1()) {
                    if ((cVarP2.W1() & iA) != 0) {
                        ?? c12544en4 = 0;
                        RG1 rg1H = cVarP2;
                        while (rg1H != 0) {
                            if (rg1H instanceof InterfaceC9398Zt3) {
                                ((InterfaceC9398Zt3) rg1H).S(H0());
                            } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                                e.c cVarW2 = rg1H.w2();
                                int i2 = 0;
                                rg1H = rg1H;
                                c12544en4 = c12544en4;
                                while (cVarW2 != null) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i2++;
                                        c12544en4 = c12544en4;
                                        if (i2 == 1) {
                                            rg1H = cVarW2;
                                        } else {
                                            if (c12544en4 == 0) {
                                                c12544en4 = new C12544en4(new e.c[16], 0);
                                            }
                                            if (rg1H != 0) {
                                                c12544en4.d(rg1H);
                                                rg1H = 0;
                                            }
                                            c12544en4.d(cVarW2);
                                        }
                                    }
                                    cVarW2 = cVarW2.S1();
                                    rg1H = rg1H;
                                    c12544en4 = c12544en4;
                                }
                                if (i2 == 1) {
                                }
                            }
                            rg1H = KG1.h(c12544en4);
                        }
                    }
                    if (cVarP2 == cVarY1) {
                        break;
                    }
                }
                C19938rB7 c19938rB72 = C19938rB7.a;
                aVar.l(gVarD, gVarE, ua2G);
            } catch (Throwable th) {
                aVar.l(gVarD, gVarE, ua2G);
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public void g0(InterfaceC11379cu3 interfaceC11379cu3, float[] fArr) {
        XA4 xa4X3 = x3(interfaceC11379cu3);
        xa4X3.a3();
        XA4 xa4U2 = u2(xa4X3);
        AV3.h(fArr);
        xa4X3.C3(xa4U2, fArr);
        B3(xa4U2, fArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final void g3() {
        int iA = AbstractC9572aB4.a(128);
        boolean zI = AbstractC10166bB4.i(iA);
        e.c cVarJ2 = J2();
        if (!zI && (cVarJ2 = cVarJ2.Y1()) == null) {
            return;
        }
        for (e.c cVarP2 = P2(zI); cVarP2 != null && (cVarP2.R1() & iA) != 0; cVarP2 = cVarP2.S1()) {
            if ((cVarP2.W1() & iA) != 0) {
                RG1 rg1H = cVarP2;
                ?? c12544en4 = 0;
                while (rg1H != 0) {
                    if (rg1H instanceof InterfaceC9398Zt3) {
                        ((InterfaceC9398Zt3) rg1H).l0(this);
                    } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                        e.c cVarW2 = rg1H.w2();
                        int i2 = 0;
                        rg1H = rg1H;
                        c12544en4 = c12544en4;
                        while (cVarW2 != null) {
                            if ((cVarW2.W1() & iA) != 0) {
                                i2++;
                                c12544en4 = c12544en4;
                                if (i2 == 1) {
                                    rg1H = cVarW2;
                                } else {
                                    if (c12544en4 == 0) {
                                        c12544en4 = new C12544en4(new e.c[16], 0);
                                    }
                                    if (rg1H != 0) {
                                        c12544en4.d(rg1H);
                                        rg1H = 0;
                                    }
                                    c12544en4.d(cVarW2);
                                }
                            }
                            cVarW2 = cVarW2.S1();
                            rg1H = rg1H;
                            c12544en4 = c12544en4;
                        }
                        if (i2 == 1) {
                        }
                    }
                    rg1H = KG1.h(c12544en4);
                }
            }
            if (cVarP2 == cVarJ2) {
                return;
            }
        }
    }

    @Override // ir.nasim.WH1
    public float getDensity() {
        return G1().T().getDensity();
    }

    @Override // ir.nasim.InterfaceC10436bc3
    public EnumC12613eu3 getLayoutDirection() {
        return G1().getLayoutDirection();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // ir.nasim.InterfaceC14195hW3, ir.nasim.InterfaceC9236Zb3
    public Object h() {
        if (!G1().t0().q(AbstractC9572aB4.a(64))) {
            return null;
        }
        J2();
        C12889fL5 c12889fL5 = new C12889fL5();
        for (e.c cVarP = G1().t0().p(); cVarP != null; cVarP = cVarP.Y1()) {
            if ((AbstractC9572aB4.a(64) & cVarP.W1()) != 0) {
                int iA = AbstractC9572aB4.a(64);
                ?? c12544en4 = 0;
                RG1 rg1H = cVarP;
                while (rg1H != 0) {
                    if (rg1H instanceof InterfaceC24970zW4) {
                        c12889fL5.a = ((InterfaceC24970zW4) rg1H).C(G1().T(), c12889fL5.a);
                    } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                        e.c cVarW2 = rg1H.w2();
                        int i2 = 0;
                        rg1H = rg1H;
                        c12544en4 = c12544en4;
                        while (cVarW2 != null) {
                            if ((cVarW2.W1() & iA) != 0) {
                                i2++;
                                c12544en4 = c12544en4;
                                if (i2 == 1) {
                                    rg1H = cVarW2;
                                } else {
                                    if (c12544en4 == 0) {
                                        c12544en4 = new C12544en4(new e.c[16], 0);
                                    }
                                    if (rg1H != 0) {
                                        c12544en4.d(rg1H);
                                        rg1H = 0;
                                    }
                                    c12544en4.d(cVarW2);
                                }
                            }
                            cVarW2 = cVarW2.S1();
                            rg1H = rg1H;
                            c12544en4 = c12544en4;
                        }
                        if (i2 == 1) {
                        }
                    }
                    rg1H = KG1.h(c12544en4);
                }
            }
        }
        return c12889fL5.a;
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public void h0(float[] fArr) {
        InterfaceC23714xO4 interfaceC23714xO4B = AbstractC4360Eu3.b(G1());
        XA4 xa4X3 = x3(AbstractC12000du3.d(this));
        C3(xa4X3, fArr);
        if (interfaceC23714xO4B instanceof FV3) {
            ((FV3) interfaceC23714xO4B).g(fArr);
            return;
        }
        long jG = AbstractC12000du3.g(xa4X3);
        if ((9223372034707292159L & jG) != 9205357640488583168L) {
            AV3.n(fArr, Float.intBitsToFloat((int) (jG >> 32)), Float.intBitsToFloat((int) (jG & 4294967295L)), 0.0f);
        }
    }

    public final void h3() {
        this.u = true;
        this.A0.invoke();
        p3();
    }

    public final void i3() {
        if (N2(AbstractC9572aB4.a(1048576))) {
            int iA = AbstractC9572aB4.a(1048576);
            boolean zI = AbstractC10166bB4.i(iA);
            e.c cVarJ2 = J2();
            if (!zI && (cVarJ2 = cVarJ2.Y1()) == null) {
                return;
            }
            for (e.c cVarP2 = P2(zI); cVarP2 != null && (cVarP2.R1() & iA) != 0; cVarP2 = cVarP2.S1()) {
                if ((cVarP2.W1() & iA) != 0) {
                    e.c cVarH = cVarP2;
                    C12544en4 c12544en4 = null;
                    while (cVarH != null) {
                        if ((cVarH.W1() & iA) != 0 && (cVarH instanceof RG1)) {
                            int i2 = 0;
                            for (e.c cVarW2 = ((RG1) cVarH).w2(); cVarW2 != null; cVarW2 = cVarW2.S1()) {
                                if ((cVarW2.W1() & iA) != 0) {
                                    i2++;
                                    if (i2 == 1) {
                                        cVarH = cVarW2;
                                    } else {
                                        if (c12544en4 == null) {
                                            c12544en4 = new C12544en4(new e.c[16], 0);
                                        }
                                        if (cVarH != null) {
                                            c12544en4.d(cVarH);
                                            cVarH = null;
                                        }
                                        c12544en4.d(cVarW2);
                                    }
                                }
                            }
                            if (i2 == 1) {
                            }
                        }
                        cVarH = KG1.h(c12544en4);
                    }
                }
                if (cVarP2 == cVarJ2) {
                    return;
                }
            }
        }
    }

    @Override // ir.nasim.BJ3
    public BJ3 j1() {
        return this.s;
    }

    public abstract void k3(UE0 ue0, C21226tK2 c21226tK2);

    @Override // ir.nasim.BJ3
    public boolean l1() {
        return this.A != null;
    }

    public final void m3(long j2, float f2, UA2 ua2, C21226tK2 c21226tK2) {
        l3(C22045ua3.o(j2, x0()), f2, ua2, c21226tK2);
    }

    public final void n3(C6908Pm4 c6908Pm4, boolean z, boolean z2) {
        InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
        if (interfaceC23124wO4 != null) {
            if (this.v) {
                if (z2) {
                    long jF2 = F2();
                    float fIntBitsToFloat = Float.intBitsToFloat((int) (jF2 >> 32)) / 2.0f;
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jF2 & 4294967295L)) / 2.0f;
                    c6908Pm4.e(-fIntBitsToFloat, -fIntBitsToFloat2, ((int) (a() >> 32)) + fIntBitsToFloat, ((int) (4294967295L & a())) + fIntBitsToFloat2);
                } else if (z) {
                    c6908Pm4.e(0.0f, 0.0f, (int) (a() >> 32), (int) (4294967295L & a()));
                }
                if (c6908Pm4.f()) {
                    return;
                }
            }
            interfaceC23124wO4.f(c6908Pm4, false);
        }
        float fK = C22045ua3.k(F1());
        c6908Pm4.i(c6908Pm4.b() + fK);
        c6908Pm4.j(c6908Pm4.c() + fK);
        float fL = C22045ua3.l(F1());
        c6908Pm4.k(c6908Pm4.d() + fL);
        c6908Pm4.h(c6908Pm4.a() + fL);
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public final InterfaceC11379cu3 o0() {
        if (!b()) {
            M73.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        a3();
        return G1().w0().t;
    }

    protected final long o2(long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) - N0();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L)) - F0();
        float fMax = Math.max(0.0f, fIntBitsToFloat / 2.0f);
        float fMax2 = Math.max(0.0f, fIntBitsToFloat2 / 2.0f);
        return OD6.d((Float.floatToRawIntBits(fMax2) & 4294967295L) | (Float.floatToRawIntBits(fMax) << 32));
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long p(long j2) {
        if (!b()) {
            M73.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return F(AbstractC12000du3.d(this), AbstractC4360Eu3.b(G1()).p(j2));
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long p0(long j2) {
        if (!b()) {
            M73.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        a3();
        long jZ3 = j2;
        for (XA4 xa4 = this; xa4 != null; xa4 = xa4.t) {
            jZ3 = z3(xa4, jZ3, false, 2, null);
        }
        return jZ3;
    }

    protected final float p2(long j2, long j3) {
        if (N0() >= Float.intBitsToFloat((int) (j3 >> 32)) && F0() >= Float.intBitsToFloat((int) (j3 & 4294967295L))) {
            return Float.POSITIVE_INFINITY;
        }
        long jO2 = o2(j3);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jO2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jO2 & 4294967295L));
        long jY2 = Y2(j2);
        if ((fIntBitsToFloat > 0.0f || fIntBitsToFloat2 > 0.0f) && Float.intBitsToFloat((int) (jY2 >> 32)) <= fIntBitsToFloat && Float.intBitsToFloat((int) (jY2 & 4294967295L)) <= fIntBitsToFloat2) {
            return ZG4.l(jY2);
        }
        return Float.POSITIVE_INFINITY;
    }

    public final void p3() {
        if (this.C0 != null) {
            if (this.D0 != null) {
                this.D0 = null;
            }
            E3(this, null, false, 2, null);
            C3419Au3.D1(G1(), false, 1, null);
        }
    }

    @Override // ir.nasim.BJ3
    public InterfaceC11734dW3 q1() {
        InterfaceC11734dW3 interfaceC11734dW3 = this.A;
        if (interfaceC11734dW3 != null) {
            return interfaceC11734dW3;
        }
        throw new IllegalStateException("Asking for measurement result of unmeasured layout modifier".toString());
    }

    public final void q2(UE0 ue0, C21226tK2 c21226tK2) {
        InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
        if (interfaceC23124wO4 != null) {
            interfaceC23124wO4.c(ue0, c21226tK2);
            return;
        }
        float fK = C22045ua3.k(F1());
        float fL = C22045ua3.l(F1());
        ue0.c(fK, fL);
        s2(ue0, c21226tK2);
        ue0.c(-fK, -fL);
    }

    public final void q3(boolean z) {
        this.q = z;
    }

    protected final void r2(UE0 ue0, InterfaceC12969fU4 interfaceC12969fU4) {
        ue0.t(0.5f, 0.5f, ((int) (H0() >> 32)) - 0.5f, ((int) (H0() & 4294967295L)) - 0.5f, interfaceC12969fU4);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r3(ir.nasim.InterfaceC11734dW3 r4) {
        /*
            r3 = this;
            ir.nasim.dW3 r0 = r3.A
            if (r4 == r0) goto L8e
            r3.A = r4
            if (r0 == 0) goto L1c
            int r1 = r4.getWidth()
            int r2 = r0.getWidth()
            if (r1 != r2) goto L1c
            int r1 = r4.getHeight()
            int r0 = r0.getHeight()
            if (r1 == r0) goto L27
        L1c:
            int r0 = r4.getWidth()
            int r1 = r4.getHeight()
            r3.e3(r0, r1)
        L27:
            ir.nasim.Am4 r0 = r3.B
            if (r0 == 0) goto L34
            ir.nasim.AbstractC13042fc3.f(r0)
            boolean r0 = r0.h()
            if (r0 != 0) goto L40
        L34:
            java.util.Map r0 = r4.t()
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L8e
        L40:
            ir.nasim.Am4 r0 = r3.B
            java.util.Map r1 = r4.t()
            boolean r0 = ir.nasim.YA4.a(r0, r1)
            if (r0 != 0) goto L8e
            ir.nasim.im r0 = r3.y2()
            ir.nasim.hm r0 = r0.t()
            r0.m()
            ir.nasim.Am4 r0 = r3.B
            if (r0 != 0) goto L61
            ir.nasim.Am4 r0 = ir.nasim.AbstractC21866uG4.b()
            r3.B = r0
        L61:
            r0.j()
            java.util.Map r4 = r4.t()
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L70:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L8e
            java.lang.Object r1 = r4.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Object r1 = r1.getValue()
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r0.u(r2, r1)
            goto L70
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XA4.r3(ir.nasim.dW3):void");
    }

    @Override // ir.nasim.BJ3
    public BJ3 s1() {
        return this.t;
    }

    protected void s3(long j2) {
        this.D = j2;
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float t1() {
        return G1().T().t1();
    }

    public abstract void t2();

    public final void t3(XA4 xa4) {
        this.s = xa4;
    }

    @Override // ir.nasim.InterfaceC11379cu3
    public long u(long j2) {
        if (!b()) {
            M73.b("LayoutCoordinate operations are only valid when isAttached is true");
        }
        return AbstractC4360Eu3.b(G1()).u(p0(j2));
    }

    public final XA4 u2(XA4 xa4) {
        C3419Au3 c3419Au3G1 = xa4.G1();
        C3419Au3 c3419Au3G12 = G1();
        if (c3419Au3G1 == c3419Au3G12) {
            e.c cVarJ2 = xa4.J2();
            e.c cVarJ22 = J2();
            int iA = AbstractC9572aB4.a(2);
            if (!cVarJ22.h().b2()) {
                M73.b("visitLocalAncestors called on an unattached node");
            }
            for (e.c cVarY1 = cVarJ22.h().Y1(); cVarY1 != null; cVarY1 = cVarY1.Y1()) {
                if ((cVarY1.W1() & iA) != 0 && cVarY1 == cVarJ2) {
                    return xa4;
                }
            }
            return this;
        }
        while (c3419Au3G1.U() > c3419Au3G12.U()) {
            c3419Au3G1 = c3419Au3G1.A0();
            AbstractC13042fc3.f(c3419Au3G1);
        }
        while (c3419Au3G12.U() > c3419Au3G1.U()) {
            c3419Au3G12 = c3419Au3G12.A0();
            AbstractC13042fc3.f(c3419Au3G12);
        }
        while (c3419Au3G1 != c3419Au3G12) {
            c3419Au3G1 = c3419Au3G1.A0();
            c3419Au3G12 = c3419Au3G12.A0();
            if (c3419Au3G1 == null || c3419Au3G12 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        return c3419Au3G12 == G1() ? this : c3419Au3G1 == xa4.G1() ? xa4 : c3419Au3G1.Y();
    }

    public final void u3(XA4 xa4) {
        this.t = xa4;
    }

    public long v2(long j2, boolean z) {
        if (z || !M1()) {
            j2 = AbstractC22635va3.b(j2, F1());
        }
        InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
        return interfaceC23124wO4 != null ? interfaceC23124wO4.d(j2, true) : j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public final boolean v3() {
        e.c cVarP2 = P2(AbstractC10166bB4.i(AbstractC9572aB4.a(16)));
        if (cVarP2 != null && cVarP2.b2()) {
            int iA = AbstractC9572aB4.a(16);
            if (!cVarP2.h().b2()) {
                M73.b("visitLocalDescendants called on an unattached node");
            }
            e.c cVarH = cVarP2.h();
            if ((cVarH.R1() & iA) != 0) {
                while (cVarH != null) {
                    if ((cVarH.W1() & iA) != 0) {
                        RG1 rg1H = cVarH;
                        ?? c12544en4 = 0;
                        while (rg1H != 0) {
                            if (rg1H instanceof InterfaceC8508Wg5) {
                                if (((InterfaceC8508Wg5) rg1H).F1()) {
                                    return true;
                                }
                            } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                                e.c cVarW2 = rg1H.w2();
                                int i2 = 0;
                                rg1H = rg1H;
                                c12544en4 = c12544en4;
                                while (cVarW2 != null) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i2++;
                                        c12544en4 = c12544en4;
                                        if (i2 == 1) {
                                            rg1H = cVarW2;
                                        } else {
                                            if (c12544en4 == 0) {
                                                c12544en4 = new C12544en4(new e.c[16], 0);
                                            }
                                            if (rg1H != 0) {
                                                c12544en4.d(rg1H);
                                                rg1H = 0;
                                            }
                                            c12544en4.d(cVarW2);
                                        }
                                    }
                                    cVarW2 = cVarW2.S1();
                                    rg1H = rg1H;
                                    c12544en4 = c12544en4;
                                }
                                if (i2 == 1) {
                                }
                            }
                            rg1H = KG1.h(c12544en4);
                        }
                    }
                    cVarH = cVarH.S1();
                }
            }
        }
        return false;
    }

    public InterfaceC14957im y2() {
        return G1().e0().c();
    }

    public long y3(long j2, boolean z) {
        InterfaceC23124wO4 interfaceC23124wO4 = this.C0;
        if (interfaceC23124wO4 != null) {
            j2 = interfaceC23124wO4.d(j2, false);
        }
        return (z || !M1()) ? AbstractC22635va3.c(j2, F1()) : j2;
    }

    @Override // ir.nasim.BJ3
    public InterfaceC11379cu3 k1() {
        return this;
    }
}
