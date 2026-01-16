package ir.nasim;

import android.view.View;
import androidx.compose.ui.e;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import ir.nasim.AbstractC21430te5;
import ir.nasim.C22045ua3;
import ir.nasim.InterfaceC23714xO4;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Au3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3419Au3 implements InterfaceC11014cb1, RM5, InterfaceC24304yO4, InterfaceC16813lu3, InterfaceC5953Ln6, InterfaceC16030kb1, InterfaceC23714xO4.b {
    public static final d J0 = new d(null);
    public static final int K0 = 8;
    private static final f L0 = new c();
    private static final SA2 M0 = a.e;
    private static final InterfaceC18354oW7 N0 = new b();
    private static final Comparator O0 = new Comparator() { // from class: ir.nasim.zu3
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return C3419Au3.x((C3419Au3) obj, (C3419Au3) obj2);
        }
    };
    private WH1 A;
    private C5077Hu3 A0;
    private EnumC12613eu3 B;
    private XA4 B0;
    private boolean C0;
    private InterfaceC18354oW7 D;
    private androidx.compose.ui.e D0;
    private androidx.compose.ui.e E0;
    private UA2 F0;
    private InterfaceC11819dc1 G;
    private UA2 G0;
    private g H;
    private boolean H0;
    private boolean I0;
    private g J;
    private boolean Y;
    private final VA4 Z;
    private final boolean a;
    private int b;
    private long c;
    private long d;
    private long e;
    private boolean f;
    private boolean g;
    private int h;
    private boolean i;
    private C3419Au3 j;
    private int k;
    private final C13771gn4 l;
    private C12544en4 m;
    private boolean n;
    private C3419Au3 o;
    private InterfaceC23714xO4 p;
    private AndroidViewHolder q;
    private int r;
    private boolean s;
    private boolean t;
    private SemanticsConfiguration u;
    private boolean v;
    private final C12544en4 w;
    private boolean x;
    private InterfaceC10970cW3 y;
    private C16042kc3 z;
    private final C4594Fu3 z0;

    /* renamed from: ir.nasim.Au3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C3419Au3 invoke() {
            return new C3419Au3(false, 0 == true ? 1 : 0, 3, null);
        }
    }

    /* renamed from: ir.nasim.Au3$b */
    public static final class b implements InterfaceC18354oW7 {
        b() {
        }

        @Override // ir.nasim.InterfaceC18354oW7
        public long a() {
            return 300L;
        }

        @Override // ir.nasim.InterfaceC18354oW7
        public long b() {
            return 40L;
        }

        @Override // ir.nasim.InterfaceC18354oW7
        public long c() {
            return 400L;
        }

        @Override // ir.nasim.InterfaceC18354oW7
        public long e() {
            return C20148rZ1.b.b();
        }

        @Override // ir.nasim.InterfaceC18354oW7
        public float g() {
            return 16.0f;
        }
    }

    /* renamed from: ir.nasim.Au3$c */
    public static final class c extends f {
        c() {
            super("Undefined intrinsics block and it is required");
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public /* bridge */ /* synthetic */ InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
            return (InterfaceC11734dW3) j(interfaceC12377eW3, list, j);
        }

        public Void j(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
            throw new IllegalStateException("Undefined measure and it is required".toString());
        }
    }

    /* renamed from: ir.nasim.Au3$d */
    public static final class d {
        private d() {
        }

        public final SA2 a() {
            return C3419Au3.M0;
        }

        public final Comparator b() {
            return C3419Au3.O0;
        }

        public /* synthetic */ d(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.Au3$e */
    public static final class e {
        public static final e a = new e("Measuring", 0);
        public static final e b = new e("LookaheadMeasuring", 1);
        public static final e c = new e("LayingOut", 2);
        public static final e d = new e("LookaheadLayingOut", 3);
        public static final e e = new e("Idle", 4);
        private static final /* synthetic */ e[] f;
        private static final /* synthetic */ F92 g;

        static {
            e[] eVarArrA = a();
            f = eVarArrA;
            g = G92.a(eVarArrA);
        }

        private e(String str, int i) {
        }

        private static final /* synthetic */ e[] a() {
            return new e[]{a, b, c, d, e};
        }

        public static e valueOf(String str) {
            return (e) Enum.valueOf(e.class, str);
        }

        public static e[] values() {
            return (e[]) f.clone();
        }
    }

    /* renamed from: ir.nasim.Au3$f */
    public static abstract class f implements InterfaceC10970cW3 {
        private final String a;

        public f(String str) {
            this.a = str;
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public /* bridge */ /* synthetic */ int a(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return ((Number) f(interfaceC10436bc3, list, i)).intValue();
        }

        public Void c(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            throw new IllegalStateException(this.a.toString());
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public /* bridge */ /* synthetic */ int d(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return ((Number) e(interfaceC10436bc3, list, i)).intValue();
        }

        public Void e(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            throw new IllegalStateException(this.a.toString());
        }

        public Void f(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            throw new IllegalStateException(this.a.toString());
        }

        public Void g(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            throw new IllegalStateException(this.a.toString());
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public /* bridge */ /* synthetic */ int h(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return ((Number) g(interfaceC10436bc3, list, i)).intValue();
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public /* bridge */ /* synthetic */ int i(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
            return ((Number) c(interfaceC10436bc3, list, i)).intValue();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.Au3$g */
    public static final class g {
        public static final g a = new g("InMeasureBlock", 0);
        public static final g b = new g("InLayoutBlock", 1);
        public static final g c = new g("NotUsed", 2);
        private static final /* synthetic */ g[] d;
        private static final /* synthetic */ F92 e;

        static {
            g[] gVarArrA = a();
            d = gVarArrA;
            e = G92.a(gVarArrA);
        }

        private g(String str, int i) {
        }

        private static final /* synthetic */ g[] a() {
            return new g[]{a, b, c};
        }

        public static g valueOf(String str) {
            return (g) Enum.valueOf(g.class, str);
        }

        public static g[] values() {
            return (g[]) d.clone();
        }
    }

    /* renamed from: ir.nasim.Au3$h */
    public /* synthetic */ class h {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.values().length];
            try {
                iArr[e.e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Au3$i */
    static final class i extends AbstractC8614Ws3 implements SA2 {
        i() {
            super(0);
        }

        public final void a() {
            C3419Au3.this.e0().D();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Au3$j */
    static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C12889fL5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(C12889fL5 c12889fL5) {
            super(0);
            this.f = c12889fL5;
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
        public final void a() {
            VA4 va4T0 = C3419Au3.this.t0();
            int iA = AbstractC9572aB4.a(8);
            C12889fL5 c12889fL5 = this.f;
            if ((va4T0.i() & iA) != 0) {
                for (e.c cVarP = va4T0.p(); cVarP != null; cVarP = cVarP.Y1()) {
                    if ((cVarP.W1() & iA) != 0) {
                        RG1 rg1H = cVarP;
                        ?? c12544en4 = 0;
                        while (rg1H != 0) {
                            if (rg1H instanceof InterfaceC7163Qn6) {
                                InterfaceC7163Qn6 interfaceC7163Qn6 = (InterfaceC7163Qn6) rg1H;
                                if (interfaceC7163Qn6.g0()) {
                                    SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
                                    c12889fL5.a = semanticsConfiguration;
                                    semanticsConfiguration.F(true);
                                }
                                if (interfaceC7163Qn6.L1()) {
                                    ((SemanticsConfiguration) c12889fL5.a).I(true);
                                }
                                interfaceC7163Qn6.U0((InterfaceC11943do6) c12889fL5.a);
                            } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                                e.c cVarW2 = rg1H.w2();
                                int i = 0;
                                rg1H = rg1H;
                                c12544en4 = c12544en4;
                                while (cVarW2 != null) {
                                    if ((cVarW2.W1() & iA) != 0) {
                                        i++;
                                        c12544en4 = c12544en4;
                                        if (i == 1) {
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
                                if (i == 1) {
                                }
                            }
                            rg1H = KG1.h(c12544en4);
                        }
                    }
                }
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public C3419Au3(boolean z, int i2) {
        this.a = z;
        this.b = i2;
        C22045ua3.a aVar = C22045ua3.b;
        this.c = aVar.a();
        this.d = C4414Fa3.b.a();
        this.e = aVar.a();
        this.f = true;
        this.l = new C13771gn4(new C12544en4(new C3419Au3[16], 0), new i());
        this.w = new C12544en4(new C3419Au3[16], 0);
        this.x = true;
        this.y = L0;
        this.A = AbstractC4360Eu3.a;
        this.B = EnumC12613eu3.a;
        this.D = N0;
        this.G = InterfaceC11819dc1.e0.a();
        g gVar = g.c;
        this.H = gVar;
        this.J = gVar;
        this.Z = new VA4(this);
        this.z0 = new C4594Fu3(this);
        this.C0 = true;
        this.D0 = androidx.compose.ui.e.a;
    }

    private final void B(androidx.compose.ui.e eVar) {
        this.D0 = eVar;
        this.Z.F(eVar);
        this.z0.Z();
        if (this.j == null && this.Z.q(AbstractC9572aB4.a(512))) {
            P1(this);
        }
    }

    public static /* synthetic */ void B1(C3419Au3 c3419Au3, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        if ((i2 & 4) != 0) {
            z3 = true;
        }
        c3419Au3.A1(z, z2, z3);
    }

    private final SemanticsConfiguration D() {
        this.v = true;
        C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = new SemanticsConfiguration();
        AbstractC4360Eu3.b(this).getSnapshotObserver().j(this, new j(c12889fL5));
        this.v = false;
        return (SemanticsConfiguration) c12889fL5.a;
    }

    public static /* synthetic */ void D1(C3419Au3 c3419Au3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        c3419Au3.C1(z);
    }

    private final float E0() {
        return m0().V1();
    }

    private final void F() {
        this.J = this.H;
        this.H = g.c;
        C12544en4 c12544en4G0 = G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i2 = 0; i2 < iO; i2++) {
            C3419Au3 c3419Au3 = (C3419Au3) objArr[i2];
            if (c3419Au3.H == g.b) {
                c3419Au3.F();
            }
        }
    }

    public static /* synthetic */ void F1(C3419Au3 c3419Au3, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        if ((i2 & 4) != 0) {
            z3 = true;
        }
        c3419Au3.E1(z, z2, z3);
    }

    private final String G(int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append('\n');
        C12544en4 c12544en4G0 = G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i4 = 0; i4 < iO; i4++) {
            sb.append(((C3419Au3) objArr[i4]).G(i2 + 1));
        }
        String string = sb.toString();
        if (i2 != 0) {
            return string;
        }
        String strSubstring = string.substring(0, string.length() - 1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    static /* synthetic */ String H(C3419Au3 c3419Au3, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return c3419Au3.G(i2);
    }

    private final void H1() {
        this.Z.y();
    }

    public static /* synthetic */ void I0(C3419Au3 c3419Au3, long j2, C18367oY2 c18367oY2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = AbstractC11873dh5.a.e();
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            z = true;
        }
        c3419Au3.H0(j2, c18367oY2, i4, z);
    }

    public static /* synthetic */ void K0(C3419Au3 c3419Au3, long j2, C18367oY2 c18367oY2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = AbstractC11873dh5.a.d();
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            z = true;
        }
        c3419Au3.J0(j2, c18367oY2, i4, z);
    }

    private final String L(C3419Au3 c3419Au3) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot insert ");
        sb.append(c3419Au3);
        sb.append(" because it already has a parent or an owner. This tree: ");
        sb.append(H(this, 0, 1, null));
        sb.append(" Other tree: ");
        C3419Au3 c3419Au32 = c3419Au3.o;
        sb.append(c3419Au32 != null ? H(c3419Au32, 0, 1, null) : null);
        return sb.toString();
    }

    private final void P1(C3419Au3 c3419Au3) {
        if (AbstractC13042fc3.d(c3419Au3, this.j)) {
            return;
        }
        this.j = c3419Au3;
        if (c3419Au3 != null) {
            this.z0.b();
            XA4 xa4K2 = Y().K2();
            for (XA4 xa4W0 = w0(); !AbstractC13042fc3.d(xa4W0, xa4K2) && xa4W0 != null; xa4W0 = xa4W0.K2()) {
                xa4W0.t2();
            }
        } else {
            this.z0.a();
        }
        O0();
    }

    private final void S0() {
        C3419Au3 c3419Au3;
        if (this.k > 0) {
            this.n = true;
        }
        if (!this.a || (c3419Au3 = this.o) == null) {
            return;
        }
        c3419Au3.S0();
    }

    public static /* synthetic */ boolean X0(C3419Au3 c3419Au3, C17833ne1 c17833ne1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            c17833ne1 = c3419Au3.z0.l();
        }
        return c3419Au3.W0(c17833ne1);
    }

    private final void n1(C3419Au3 c3419Au3) {
        if (c3419Au3.z0.d() > 0) {
            this.z0.L(r0.d() - 1);
        }
        if (this.p != null) {
            c3419Au3.I();
        }
        c3419Au3.o = null;
        c3419Au3.w0().u3(null);
        if (c3419Au3.a) {
            this.k--;
            C12544en4 c12544en4C = c3419Au3.l.c();
            Object[] objArr = c12544en4C.a;
            int iO = c12544en4C.o();
            for (int i2 = 0; i2 < iO; i2++) {
                ((C3419Au3) objArr[i2]).w0().u3(null);
            }
        }
        S0();
        p1();
    }

    private final void o1() {
        O0();
        C3419Au3 c3419Au3A0 = A0();
        if (c3419Au3A0 != null) {
            c3419Au3A0.M0();
        }
        N0();
    }

    private final void r1() {
        if (this.n) {
            this.n = false;
            C12544en4 c12544en4 = this.m;
            if (c12544en4 == null) {
                c12544en4 = new C12544en4(new C3419Au3[16], 0);
                this.m = c12544en4;
            }
            c12544en4.k();
            C12544en4 c12544en4C = this.l.c();
            Object[] objArr = c12544en4C.a;
            int iO = c12544en4C.o();
            for (int i2 = 0; i2 < iO; i2++) {
                C3419Au3 c3419Au3 = (C3419Au3) objArr[i2];
                if (c3419Au3.a) {
                    c12544en4.f(c12544en4.o(), c3419Au3.G0());
                } else {
                    c12544en4.d(c3419Au3);
                }
            }
            this.z0.D();
        }
    }

    public static /* synthetic */ boolean t1(C3419Au3 c3419Au3, C17833ne1 c17833ne1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            c17833ne1 = c3419Au3.z0.k();
        }
        return c3419Au3.s1(c17833ne1);
    }

    private final C16042kc3 v0() {
        C16042kc3 c16042kc3 = this.z;
        if (c16042kc3 != null) {
            return c16042kc3;
        }
        C16042kc3 c16042kc32 = new C16042kc3(this, o0());
        this.z = c16042kc32;
        return c16042kc32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int x(C3419Au3 c3419Au3, C3419Au3 c3419Au32) {
        return c3419Au3.E0() == c3419Au32.E0() ? AbstractC13042fc3.k(c3419Au3.B0(), c3419Au32.B0()) : Float.compare(c3419Au3.E0(), c3419Au32.E0());
    }

    public static /* synthetic */ void z1(C3419Au3 c3419Au3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        c3419Au3.y1(z);
    }

    public final C3419Au3 A0() {
        C3419Au3 c3419Au3 = this.o;
        while (c3419Au3 != null && c3419Au3.a) {
            c3419Au3 = c3419Au3.o;
        }
        return c3419Au3;
    }

    public final void A1(boolean z, boolean z2, boolean z3) {
        if (!(this.j != null)) {
            M73.b("Lookahead measure cannot be requested on a node that is not a part of theLookaheadScope");
        }
        InterfaceC23714xO4 interfaceC23714xO4 = this.p;
        if (interfaceC23714xO4 == null || this.s || this.a) {
            return;
        }
        interfaceC23714xO4.j(this, true, z, z2);
        if (z3) {
            GJ3 gj3J0 = j0();
            AbstractC13042fc3.f(gj3J0);
            gj3J0.U1(z);
        }
    }

    public final int B0() {
        return m0().U1();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(ir.nasim.InterfaceC23714xO4 r7) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3419Au3.C(ir.nasim.xO4):void");
    }

    public final C5077Hu3 C0() {
        return this.A0;
    }

    public final void C1(boolean z) {
        InterfaceC23714xO4 interfaceC23714xO4;
        this.f = true;
        if (this.a || (interfaceC23714xO4 = this.p) == null) {
            return;
        }
        InterfaceC23714xO4.C(interfaceC23714xO4, this, false, z, 2, null);
    }

    public InterfaceC18354oW7 D0() {
        return this.D;
    }

    public final void E() {
        this.J = this.H;
        this.H = g.c;
        C12544en4 c12544en4G0 = G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i2 = 0; i2 < iO; i2++) {
            C3419Au3 c3419Au3 = (C3419Au3) objArr[i2];
            if (c3419Au3.H != g.c) {
                c3419Au3.E();
            }
        }
    }

    public final void E1(boolean z, boolean z2, boolean z3) {
        InterfaceC23714xO4 interfaceC23714xO4;
        if (this.s || this.a || (interfaceC23714xO4 = this.p) == null) {
            return;
        }
        InterfaceC23714xO4.A(interfaceC23714xO4, this, false, z, z2, 2, null);
        if (z3) {
            m0().W1(z);
        }
    }

    public final C12544en4 F0() {
        if (this.x) {
            this.w.k();
            C12544en4 c12544en4 = this.w;
            c12544en4.f(c12544en4.o(), G0());
            this.w.C(O0);
            this.x = false;
        }
        return this.w;
    }

    public final C12544en4 G0() {
        Z1();
        if (this.k == 0) {
            return this.l.c();
        }
        C12544en4 c12544en4 = this.m;
        AbstractC13042fc3.f(c12544en4);
        return c12544en4;
    }

    public final void G1(C3419Au3 c3419Au3) {
        if (h.a[c3419Au3.g0().ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + c3419Au3.g0());
        }
        if (c3419Au3.i0()) {
            B1(c3419Au3, true, false, false, 6, null);
            return;
        }
        if (c3419Au3.h0()) {
            c3419Au3.y1(true);
        }
        if (c3419Au3.n0()) {
            F1(c3419Au3, true, false, false, 6, null);
        } else if (c3419Au3.f0()) {
            c3419Au3.C1(true);
        }
    }

    public final void H0(long j2, C18367oY2 c18367oY2, int i2, boolean z) {
        w0().S2(XA4.E0.a(), XA4.w2(w0(), j2, false, 2, null), c18367oY2, i2, z);
    }

    public final void I() {
        InterfaceC23714xO4 interfaceC23714xO4 = this.p;
        if (interfaceC23714xO4 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot detach node that is already detached!  Tree: ");
            C3419Au3 c3419Au3A0 = A0();
            sb.append(c3419Au3A0 != null ? H(c3419Au3A0, 0, 1, null) : null);
            M73.c(sb.toString());
            throw new KotlinNothingValueException();
        }
        C3419Au3 c3419Au3A02 = A0();
        if (c3419Au3A02 != null) {
            c3419Au3A02.M0();
            c3419Au3A02.O0();
            C10354bW3 c10354bW3M0 = m0();
            g gVar = g.c;
            c10354bW3M0.q2(gVar);
            GJ3 gj3J0 = j0();
            if (gj3J0 != null) {
                gj3J0.o2(gVar);
            }
        }
        this.z0.K();
        UA2 ua2 = this.G0;
        if (ua2 != null) {
            ua2.invoke(interfaceC23714xO4);
        }
        if (!C15439jb1.d && this.Z.q(AbstractC9572aB4.a(8))) {
            R0();
        }
        this.Z.A();
        this.s = true;
        C12544en4 c12544en4C = this.l.c();
        Object[] objArr = c12544en4C.a;
        int iO = c12544en4C.o();
        for (int i2 = 0; i2 < iO; i2++) {
            ((C3419Au3) objArr[i2]).I();
        }
        this.s = false;
        this.Z.u();
        interfaceC23714xO4.l(this);
        this.p = null;
        P1(null);
        this.r = 0;
        m0().h2();
        GJ3 gj3J02 = j0();
        if (gj3J02 != null) {
            gj3J02.d2();
        }
        if (C15439jb1.d && this.Z.q(AbstractC9572aB4.a(8))) {
            SemanticsConfiguration semanticsConfiguration = this.u;
            this.u = null;
            this.t = false;
            interfaceC23714xO4.getSemanticsOwner().e(this, semanticsConfiguration);
            interfaceC23714xO4.F();
        }
    }

    public final void I1() {
        C12544en4 c12544en4G0 = G0();
        Object[] objArr = c12544en4G0.a;
        int iO = c12544en4G0.o();
        for (int i2 = 0; i2 < iO; i2++) {
            C3419Au3 c3419Au3 = (C3419Au3) objArr[i2];
            g gVar = c3419Au3.J;
            c3419Au3.H = gVar;
            if (gVar != g.c) {
                c3419Au3.I1();
            }
        }
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
    public final void J() {
        if (g0() != e.e || f0() || n0() || u() || !o()) {
            return;
        }
        VA4 va4 = this.Z;
        int iA = AbstractC9572aB4.a(256);
        if ((va4.i() & iA) != 0) {
            for (e.c cVarK = va4.k(); cVarK != null; cVarK = cVarK.S1()) {
                if ((cVarK.W1() & iA) != 0) {
                    RG1 rg1H = cVarK;
                    ?? c12544en4 = 0;
                    while (rg1H != 0) {
                        if (rg1H instanceof InterfaceC15868kJ2) {
                            InterfaceC15868kJ2 interfaceC15868kJ2 = (InterfaceC15868kJ2) rg1H;
                            interfaceC15868kJ2.u(KG1.j(interfaceC15868kJ2, AbstractC9572aB4.a(256)));
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
                if ((cVarK.R1() & iA) == 0) {
                    return;
                }
            }
        }
    }

    public final void J0(long j2, C18367oY2 c18367oY2, int i2, boolean z) {
        w0().S2(XA4.E0.b(), XA4.w2(w0(), j2, false, 2, null), c18367oY2, AbstractC11873dh5.a.d(), z);
    }

    public final void J1(boolean z) {
        this.Y = z;
    }

    public final void K(UE0 ue0, C21226tK2 c21226tK2) {
        w0().q2(ue0, c21226tK2);
    }

    public final void K1(boolean z) {
        this.g = z;
    }

    public final void L0(int i2, C3419Au3 c3419Au3) {
        if (!(c3419Au3.o == null || c3419Au3.p == null)) {
            M73.b(L(c3419Au3));
        }
        c3419Au3.o = this;
        this.l.a(i2, c3419Au3);
        p1();
        if (c3419Au3.a) {
            this.k++;
        }
        S0();
        InterfaceC23714xO4 interfaceC23714xO4 = this.p;
        if (interfaceC23714xO4 != null) {
            c3419Au3.C(interfaceC23714xO4);
        }
        if (c3419Au3.z0.d() > 0) {
            C4594Fu3 c4594Fu3 = this.z0;
            c4594Fu3.L(c4594Fu3.d() + 1);
        }
    }

    public final void L1(boolean z) {
        this.C0 = z;
    }

    public final boolean M() {
        AbstractC14349hm abstractC14349hmT;
        C4594Fu3 c4594Fu3 = this.z0;
        if (c4594Fu3.c().t().k()) {
            return true;
        }
        InterfaceC14957im interfaceC14957imP = c4594Fu3.p();
        return (interfaceC14957imP == null || (abstractC14349hmT = interfaceC14957imP.t()) == null || !abstractC14349hmT.k()) ? false : true;
    }

    public final void M0() {
        XA4 xa4Z = Z();
        if (xa4Z != null) {
            xa4Z.U2();
            return;
        }
        C3419Au3 c3419Au3A0 = A0();
        if (c3419Au3A0 != null) {
            c3419Au3A0.M0();
        }
    }

    public final void M1(AndroidViewHolder androidViewHolder) {
        this.q = androidViewHolder;
    }

    public final boolean N() {
        return this.E0 != null;
    }

    public final void N0() {
        XA4 xa4Y = Y();
        for (XA4 xa4W0 = w0(); xa4W0 != xa4Y; xa4W0 = xa4W0.K2()) {
            AbstractC13042fc3.g(xa4W0, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            InterfaceC23124wO4 interfaceC23124wO4D2 = ((C22245uu3) xa4W0).D2();
            if (interfaceC23124wO4D2 != null) {
                interfaceC23124wO4D2.invalidate();
            }
        }
        InterfaceC23124wO4 interfaceC23124wO4D22 = Y().D2();
        if (interfaceC23124wO4D22 != null) {
            interfaceC23124wO4D22.invalidate();
        }
    }

    public final void N1(g gVar) {
        this.H = gVar;
    }

    public final boolean O() {
        return this.Y;
    }

    public final void O0() {
        this.f = true;
        if (this.j != null) {
            B1(this, false, false, false, 7, null);
        } else {
            F1(this, false, false, false, 7, null);
        }
    }

    public final void O1(long j2) {
        this.d = j2;
    }

    public final List P() {
        GJ3 gj3J0 = j0();
        AbstractC13042fc3.f(gj3J0);
        return gj3J0.l1();
    }

    public final void P0() {
        if (f0() || n0() || this.H0) {
            return;
        }
        AbstractC4360Eu3.b(this).b(this);
    }

    public final List Q() {
        return m0().s1();
    }

    public final void Q0() {
        this.z0.C();
    }

    public final void Q1(boolean z) {
        this.H0 = z;
    }

    public final List R() {
        return G0().j();
    }

    public final void R0() {
        if (this.v) {
            return;
        }
        if (!C15439jb1.d) {
            this.u = null;
            AbstractC4360Eu3.b(this).F();
        } else {
            if (this.Z.s() || N()) {
                this.t = true;
                return;
            }
            SemanticsConfiguration semanticsConfiguration = this.u;
            this.u = D();
            this.t = false;
            InterfaceC23714xO4 interfaceC23714xO4B = AbstractC4360Eu3.b(this);
            interfaceC23714xO4B.getSemanticsOwner().e(this, semanticsConfiguration);
            interfaceC23714xO4B.F();
        }
    }

    public final void R1(long j2) {
        this.c = j2;
    }

    public InterfaceC11819dc1 S() {
        return this.G;
    }

    public final void S1(UA2 ua2) {
        this.F0 = ua2;
    }

    public WH1 T() {
        return this.A;
    }

    public final boolean T0() {
        return m0().Y1();
    }

    public final void T1(UA2 ua2) {
        this.G0 = ua2;
    }

    public final int U() {
        return this.r;
    }

    public final Boolean U0() {
        GJ3 gj3J0 = j0();
        if (gj3J0 != null) {
            return Boolean.valueOf(gj3J0.o());
        }
        return null;
    }

    public final void U1(long j2) {
        this.e = j2;
    }

    public final List V() {
        return this.l.c().j();
    }

    public final boolean V0() {
        return this.i;
    }

    public final void V1(boolean z) {
        this.f = z;
    }

    public final boolean W() {
        return this.g;
    }

    public final boolean W0(C17833ne1 c17833ne1) {
        if (c17833ne1 == null || this.j == null) {
            return false;
        }
        GJ3 gj3J0 = j0();
        AbstractC13042fc3.f(gj3J0);
        return gj3J0.h2(c17833ne1.r());
    }

    public void W1(int i2) {
        this.b = i2;
    }

    public final boolean X() {
        long jC2 = Y().C2();
        return C17833ne1.j(jC2) && C17833ne1.i(jC2);
    }

    public final void X1(boolean z) {
        this.t = z;
    }

    public final XA4 Y() {
        return this.Z.l();
    }

    public final void Y0() {
        if (this.H == g.c) {
            F();
        }
        GJ3 gj3J0 = j0();
        AbstractC13042fc3.f(gj3J0);
        gj3J0.i2();
    }

    public final void Y1(C5077Hu3 c5077Hu3) {
        this.A0 = c5077Hu3;
    }

    public final XA4 Z() {
        if (this.C0) {
            XA4 xa4Y = Y();
            XA4 xa4L2 = w0().L2();
            this.B0 = null;
            while (true) {
                if (AbstractC13042fc3.d(xa4Y, xa4L2)) {
                    break;
                }
                if ((xa4Y != null ? xa4Y.D2() : null) != null) {
                    this.B0 = xa4Y;
                    break;
                }
                xa4Y = xa4Y != null ? xa4Y.L2() : null;
            }
        }
        XA4 xa4 = this.B0;
        if (xa4 == null || xa4.D2() != null) {
            return xa4;
        }
        M73.c("layer was not set");
        throw new KotlinNothingValueException();
    }

    @Override // ir.nasim.InterfaceC24304yO4
    public boolean Z0() {
        return b();
    }

    public final void Z1() {
        if (this.k > 0) {
            r1();
        }
    }

    public View a0() {
        AndroidViewHolder androidViewHolder = this.q;
        if (androidViewHolder != null) {
            return androidViewHolder.getInteropView();
        }
        return null;
    }

    public final void a1() {
        this.z0.E();
    }

    @Override // ir.nasim.InterfaceC16813lu3
    public boolean b() {
        return this.p != null;
    }

    public final AndroidViewHolder b0() {
        return this.q;
    }

    public final void b1() {
        this.z0.F();
    }

    @Override // ir.nasim.InterfaceC16030kb1
    public void c(EnumC12613eu3 enumC12613eu3) {
        if (this.B != enumC12613eu3) {
            this.B = enumC12613eu3;
            o1();
            for (e.c cVarK = this.Z.k(); cVarK != null; cVarK = cVarK.S1()) {
                cVarK.m0();
            }
        }
    }

    public final g c0() {
        return this.H;
    }

    public final void c1() {
        this.z0.G();
    }

    @Override // ir.nasim.InterfaceC16813lu3
    public int d() {
        return this.b;
    }

    public final long d0() {
        return this.d;
    }

    public final void d1() {
        this.z0.H();
    }

    @Override // ir.nasim.InterfaceC5953Ln6
    public SemanticsConfiguration e() {
        if (!b() || u() || !this.Z.q(AbstractC9572aB4.a(8))) {
            return null;
        }
        if (!C15439jb1.d && this.u == null) {
            this.u = D();
        }
        return this.u;
    }

    public final C4594Fu3 e0() {
        return this.z0;
    }

    public final int e1(int i2) {
        return v0().b(i2);
    }

    @Override // ir.nasim.InterfaceC16030kb1
    public void f(WH1 wh1) {
        if (AbstractC13042fc3.d(this.A, wh1)) {
            return;
        }
        this.A = wh1;
        o1();
        for (e.c cVarK = this.Z.k(); cVarK != null; cVarK = cVarK.S1()) {
            cVarK.E();
        }
    }

    public final boolean f0() {
        return this.z0.n();
    }

    public final int f1(int i2) {
        return v0().c(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // ir.nasim.InterfaceC16030kb1
    public void g(InterfaceC18354oW7 interfaceC18354oW7) {
        if (AbstractC13042fc3.d(this.D, interfaceC18354oW7)) {
            return;
        }
        this.D = interfaceC18354oW7;
        VA4 va4 = this.Z;
        int iA = AbstractC9572aB4.a(16);
        if ((va4.i() & iA) != 0) {
            for (e.c cVarK = va4.k(); cVarK != null; cVarK = cVarK.S1()) {
                if ((cVarK.W1() & iA) != 0) {
                    RG1 rg1H = cVarK;
                    ?? c12544en4 = 0;
                    while (rg1H != 0) {
                        if (rg1H instanceof InterfaceC8508Wg5) {
                            ((InterfaceC8508Wg5) rg1H).J1();
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
                if ((cVarK.R1() & iA) == 0) {
                    return;
                }
            }
        }
    }

    public final e g0() {
        return this.z0.o();
    }

    public final int g1(int i2) {
        return v0().d(i2);
    }

    @Override // ir.nasim.InterfaceC16813lu3
    public int getHeight() {
        return this.z0.j();
    }

    @Override // ir.nasim.InterfaceC16813lu3
    public EnumC12613eu3 getLayoutDirection() {
        return this.B;
    }

    @Override // ir.nasim.InterfaceC16813lu3
    public int getWidth() {
        return this.z0.B();
    }

    @Override // ir.nasim.InterfaceC16030kb1
    public void h(int i2) {
        this.h = i2;
    }

    public final boolean h0() {
        return this.z0.s();
    }

    public final int h1(int i2) {
        return v0().e(i2);
    }

    @Override // ir.nasim.InterfaceC11014cb1
    public void i() {
        if (!C15439jb1.f) {
            AndroidViewHolder androidViewHolder = this.q;
            if (androidViewHolder != null) {
                androidViewHolder.i();
            }
            C5077Hu3 c5077Hu3 = this.A0;
            if (c5077Hu3 != null) {
                c5077Hu3.i();
            }
        }
        this.I0 = true;
        H1();
        if (b()) {
            if (C15439jb1.d) {
                this.u = null;
                this.t = false;
            } else {
                R0();
            }
        }
        InterfaceC23714xO4 interfaceC23714xO4 = this.p;
        if (interfaceC23714xO4 != null) {
            interfaceC23714xO4.t(this);
        }
        if (C15439jb1.f) {
            AndroidViewHolder androidViewHolder2 = this.q;
            if (androidViewHolder2 != null) {
                androidViewHolder2.i();
            }
            C5077Hu3 c5077Hu32 = this.A0;
            if (c5077Hu32 != null) {
                c5077Hu32.i();
            }
        }
    }

    public final boolean i0() {
        return this.z0.u();
    }

    public final int i1(int i2) {
        return v0().f(i2);
    }

    @Override // ir.nasim.InterfaceC16030kb1
    public void j(InterfaceC10970cW3 interfaceC10970cW3) {
        if (AbstractC13042fc3.d(this.y, interfaceC10970cW3)) {
            return;
        }
        this.y = interfaceC10970cW3;
        C16042kc3 c16042kc3 = this.z;
        if (c16042kc3 != null) {
            c16042kc3.k(o0());
        }
        O0();
    }

    public final GJ3 j0() {
        return this.z0.v();
    }

    public final int j1(int i2) {
        return v0().g(i2);
    }

    @Override // ir.nasim.InterfaceC16813lu3
    public List k() {
        return this.Z.n();
    }

    public final C3419Au3 k0() {
        return this.j;
    }

    public final int k1(int i2) {
        return v0().h(i2);
    }

    @Override // ir.nasim.RM5
    public void l() {
        if (this.j != null) {
            B1(this, false, false, false, 5, null);
        } else {
            F1(this, false, false, false, 5, null);
        }
        C17833ne1 c17833ne1K = this.z0.k();
        if (c17833ne1K != null) {
            InterfaceC23714xO4 interfaceC23714xO4 = this.p;
            if (interfaceC23714xO4 != null) {
                interfaceC23714xO4.J(this, c17833ne1K.r());
                return;
            }
            return;
        }
        InterfaceC23714xO4 interfaceC23714xO42 = this.p;
        if (interfaceC23714xO42 != null) {
            InterfaceC23714xO4.B(interfaceC23714xO42, false, 1, null);
        }
    }

    public final C3892Cu3 l0() {
        return AbstractC4360Eu3.b(this).getSharedDrawScope();
    }

    public final int l1(int i2) {
        return v0().i(i2);
    }

    @Override // ir.nasim.InterfaceC11014cb1
    public void m() {
        if (!b()) {
            M73.a("onReuse is only expected on attached node");
        }
        if (!C15439jb1.f) {
            AndroidViewHolder androidViewHolder = this.q;
            if (androidViewHolder != null) {
                androidViewHolder.m();
            }
            C5077Hu3 c5077Hu3 = this.A0;
            if (c5077Hu3 != null) {
                c5077Hu3.m();
            }
        }
        this.v = false;
        if (u()) {
            this.I0 = false;
            if (!C15439jb1.d) {
                R0();
            }
        } else {
            H1();
        }
        int iD = d();
        W1(AbstractC6919Pn6.b());
        InterfaceC23714xO4 interfaceC23714xO4 = this.p;
        if (interfaceC23714xO4 != null) {
            interfaceC23714xO4.D(this, iD);
        }
        if (C15439jb1.f) {
            AndroidViewHolder androidViewHolder2 = this.q;
            if (androidViewHolder2 != null) {
                androidViewHolder2.m();
            }
            C5077Hu3 c5077Hu32 = this.A0;
            if (c5077Hu32 != null) {
                c5077Hu32.m();
            }
        }
        this.Z.t();
        this.Z.z();
        if (C15439jb1.d && this.Z.q(AbstractC9572aB4.a(8))) {
            R0();
        }
        G1(this);
        InterfaceC23714xO4 interfaceC23714xO42 = this.p;
        if (interfaceC23714xO42 != null) {
            interfaceC23714xO42.I(this, iD);
        }
    }

    public final C10354bW3 m0() {
        return this.z0.w();
    }

    public final void m1(int i2, int i3, int i4) {
        if (i2 == i3) {
            return;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            this.l.a(i2 > i3 ? i3 + i5 : (i3 + i4) - 2, (C3419Au3) this.l.d(i2 > i3 ? i2 + i5 : i2));
        }
        p1();
        S0();
        O0();
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
    @Override // ir.nasim.InterfaceC23714xO4.b
    public void n() {
        XA4 xa4Y = Y();
        int iA = AbstractC9572aB4.a(128);
        boolean zI = AbstractC10166bB4.i(iA);
        e.c cVarJ2 = xa4Y.J2();
        if (!zI && (cVarJ2 = cVarJ2.Y1()) == null) {
            return;
        }
        for (e.c cVarP2 = xa4Y.P2(zI); cVarP2 != null && (cVarP2.R1() & iA) != 0; cVarP2 = cVarP2.S1()) {
            if ((cVarP2.W1() & iA) != 0) {
                RG1 rg1H = cVarP2;
                ?? c12544en4 = 0;
                while (rg1H != 0) {
                    if (rg1H instanceof InterfaceC9398Zt3) {
                        ((InterfaceC9398Zt3) rg1H).l0(Y());
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

    public final boolean n0() {
        return this.z0.x();
    }

    @Override // ir.nasim.InterfaceC16813lu3
    public boolean o() {
        return m0().o();
    }

    public InterfaceC10970cW3 o0() {
        return this.y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
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
    @Override // ir.nasim.InterfaceC16030kb1
    public void p(InterfaceC11819dc1 interfaceC11819dc1) {
        this.G = interfaceC11819dc1;
        f((WH1) interfaceC11819dc1.b(AbstractC13040fc1.g()));
        c((EnumC12613eu3) interfaceC11819dc1.b(AbstractC13040fc1.n()));
        g((InterfaceC18354oW7) interfaceC11819dc1.b(AbstractC13040fc1.u()));
        VA4 va4 = this.Z;
        int iA = AbstractC9572aB4.a(32768);
        if ((va4.i() & iA) != 0) {
            for (e.c cVarK = va4.k(); cVarK != null; cVarK = cVarK.S1()) {
                if ((cVarK.W1() & iA) != 0) {
                    RG1 rg1H = cVarK;
                    ?? c12544en4 = 0;
                    while (rg1H != 0) {
                        if (rg1H instanceof InterfaceC9814ac1) {
                            e.c cVarH = ((InterfaceC9814ac1) rg1H).h();
                            if (cVarH.b2()) {
                                AbstractC10166bB4.e(cVarH);
                            } else {
                                cVarH.s2(true);
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
                if ((cVarK.R1() & iA) == 0) {
                    return;
                }
            }
        }
    }

    public final g p0() {
        return m0().S1();
    }

    public final void p1() {
        if (!this.a) {
            this.x = true;
            return;
        }
        C3419Au3 c3419Au3A0 = A0();
        if (c3419Au3A0 != null) {
            c3419Au3A0.p1();
        }
    }

    @Override // ir.nasim.InterfaceC11014cb1
    public void q() {
        if (!C15439jb1.f) {
            AndroidViewHolder androidViewHolder = this.q;
            if (androidViewHolder != null) {
                androidViewHolder.q();
            }
            C5077Hu3 c5077Hu3 = this.A0;
            if (c5077Hu3 != null) {
                c5077Hu3.q();
            }
        }
        XA4 xa4K2 = Y().K2();
        for (XA4 xa4W0 = w0(); !AbstractC13042fc3.d(xa4W0, xa4K2) && xa4W0 != null; xa4W0 = xa4W0.K2()) {
            xa4W0.h3();
        }
        if (C15439jb1.f) {
            AndroidViewHolder androidViewHolder2 = this.q;
            if (androidViewHolder2 != null) {
                androidViewHolder2.q();
            }
            C5077Hu3 c5077Hu32 = this.A0;
            if (c5077Hu32 != null) {
                c5077Hu32.q();
            }
        }
    }

    public final g q0() {
        g gVarM1;
        GJ3 gj3J0 = j0();
        return (gj3J0 == null || (gVarM1 = gj3J0.M1()) == null) ? g.c : gVarM1;
    }

    public final void q1(int i2, int i3) {
        AbstractC21430te5.a placementScope;
        XA4 xa4Y;
        if (this.H == g.c) {
            F();
        }
        C3419Au3 c3419Au3A0 = A0();
        if (c3419Au3A0 == null || (xa4Y = c3419Au3A0.Y()) == null || (placementScope = xa4Y.D1()) == null) {
            placementScope = AbstractC4360Eu3.b(this).getPlacementScope();
        }
        AbstractC21430te5.a.l(placementScope, m0(), i2, i3, 0.0f, 4, null);
    }

    @Override // ir.nasim.InterfaceC16030kb1
    public void r(androidx.compose.ui.e eVar) {
        if (!(!this.a || r0() == androidx.compose.ui.e.a)) {
            M73.a("Modifiers are not supported on virtual LayoutNodes");
        }
        if (!(!u())) {
            M73.a("modifier is updated when deactivated");
        }
        if (!b()) {
            this.E0 = eVar;
            return;
        }
        B(eVar);
        if (this.t) {
            R0();
        }
    }

    public androidx.compose.ui.e r0() {
        return this.D0;
    }

    @Override // ir.nasim.InterfaceC16813lu3
    public InterfaceC11379cu3 s() {
        return Y();
    }

    public final boolean s0() {
        return this.H0;
    }

    public final boolean s1(C17833ne1 c17833ne1) {
        if (c17833ne1 == null) {
            return false;
        }
        if (this.H == g.c) {
            E();
        }
        return m0().m2(c17833ne1.r());
    }

    @Override // ir.nasim.InterfaceC5953Ln6
    public List t() {
        return R();
    }

    public final VA4 t0() {
        return this.Z;
    }

    public String toString() {
        return AbstractC23931xl3.a(this, null) + " children: " + R().size() + " measurePolicy: " + o0();
    }

    @Override // ir.nasim.InterfaceC16813lu3
    public boolean u() {
        return this.I0;
    }

    public final long u0() {
        return this.c;
    }

    public final void u1() {
        int iO = this.l.c().o();
        while (true) {
            iO--;
            if (-1 >= iO) {
                this.l.b();
                return;
            }
            n1((C3419Au3) this.l.c().a[iO]);
        }
    }

    @Override // ir.nasim.InterfaceC5953Ln6
    public boolean v() {
        return w0().X2();
    }

    public final void v1(int i2, int i3) {
        if (!(i3 >= 0)) {
            M73.a("count (" + i3 + ") must be greater than 0");
        }
        int i4 = (i3 + i2) - 1;
        if (i2 > i4) {
            return;
        }
        while (true) {
            n1((C3419Au3) this.l.c().a[i4]);
            if (i4 == i2) {
                return;
            } else {
                i4--;
            }
        }
    }

    public final XA4 w0() {
        return this.Z.o();
    }

    public final void w1() {
        if (this.H == g.c) {
            F();
        }
        m0().n2();
    }

    public final long x0() {
        return this.e;
    }

    public final void x1() {
        if (this.v) {
            return;
        }
        AbstractC4360Eu3.b(this).H(this);
    }

    public final boolean y0() {
        return this.f;
    }

    public final void y1(boolean z) {
        InterfaceC23714xO4 interfaceC23714xO4;
        if (this.a || (interfaceC23714xO4 = this.p) == null) {
            return;
        }
        interfaceC23714xO4.G(this, true, z);
    }

    public final InterfaceC23714xO4 z0() {
        return this.p;
    }

    @Override // ir.nasim.InterfaceC16813lu3, ir.nasim.InterfaceC5953Ln6
    public InterfaceC5953Ln6 a() {
        return A0();
    }

    public /* synthetic */ C3419Au3(boolean z, int i2, int i3, ED1 ed1) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? AbstractC6919Pn6.b() : i2);
    }
}
