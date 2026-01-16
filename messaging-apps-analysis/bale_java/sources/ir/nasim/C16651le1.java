package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.C8243Vd1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: ir.nasim.le1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C16651le1 {
    public static float U0 = 0.5f;
    public int A;
    int A0;
    public float B;
    int B0;
    public int C;
    boolean C0;
    public int D;
    boolean D0;
    public float E;
    boolean E0;
    public boolean F;
    boolean F0;
    public boolean G;
    boolean G0;
    int H;
    boolean H0;
    float I;
    boolean I0;
    private int[] J;
    int J0;
    private float K;
    int K0;
    private boolean L;
    boolean L0;
    private boolean M;
    boolean M0;
    private boolean N;
    public float[] N0;
    private int O;
    protected C16651le1[] O0;
    private int P;
    protected C16651le1[] P0;
    public C8243Vd1 Q;
    C16651le1 Q0;
    public C8243Vd1 R;
    C16651le1 R0;
    public C8243Vd1 S;
    public int S0;
    public C8243Vd1 T;
    public int T0;
    public C8243Vd1 U;
    C8243Vd1 V;
    C8243Vd1 W;
    public C8243Vd1 X;
    public C8243Vd1[] Y;
    protected ArrayList Z;
    public boolean a;
    private boolean[] a0;
    public AbstractC15192j98[] b;
    public b[] b0;
    public C13475gI0 c;
    public C16651le1 c0;
    public C13475gI0 d;
    int d0;
    public RY2 e;
    int e0;
    public C17727nS7 f;
    public float f0;
    public boolean[] g;
    protected int g0;
    boolean h;
    protected int h0;
    private boolean i;
    protected int i0;
    private boolean j;
    int j0;
    private boolean k;
    int k0;
    private int l;
    protected int l0;
    private int m;
    protected int m0;
    public C13992h98 n;
    int n0;
    public String o;
    protected int o0;
    private boolean p;
    protected int p0;
    private boolean q;
    float q0;
    private boolean r;
    float r0;
    private boolean s;
    private Object s0;
    public int t;
    private int t0;
    public int u;
    private int u0;
    private int v;
    private boolean v0;
    public int w;
    private String w0;
    public int x;
    private String x0;
    public int[] y;
    int y0;
    public int z;
    int z0;

    /* renamed from: ir.nasim.le1$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[b.values().length];
            b = iArr;
            try {
                iArr[b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[C8243Vd1.b.values().length];
            a = iArr2;
            try {
                iArr2[C8243Vd1.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[C8243Vd1.b.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[C8243Vd1.b.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[C8243Vd1.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[C8243Vd1.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[C8243Vd1.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[C8243Vd1.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[C8243Vd1.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[C8243Vd1.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* renamed from: ir.nasim.le1$b */
    public enum b {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public C16651le1() {
        this.a = false;
        this.b = new AbstractC15192j98[2];
        this.e = null;
        this.f = null;
        this.g = new boolean[]{true, true};
        this.h = false;
        this.i = true;
        this.j = false;
        this.k = true;
        this.l = -1;
        this.m = -1;
        this.n = new C13992h98(this);
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = new int[2];
        this.z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.J = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.K = 0.0f;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new C8243Vd1(this, C8243Vd1.b.LEFT);
        this.R = new C8243Vd1(this, C8243Vd1.b.TOP);
        this.S = new C8243Vd1(this, C8243Vd1.b.RIGHT);
        this.T = new C8243Vd1(this, C8243Vd1.b.BOTTOM);
        this.U = new C8243Vd1(this, C8243Vd1.b.BASELINE);
        this.V = new C8243Vd1(this, C8243Vd1.b.CENTER_X);
        this.W = new C8243Vd1(this, C8243Vd1.b.CENTER_Y);
        C8243Vd1 c8243Vd1 = new C8243Vd1(this, C8243Vd1.b.CENTER);
        this.X = c8243Vd1;
        this.Y = new C8243Vd1[]{this.Q, this.S, this.R, this.T, this.U, c8243Vd1};
        this.Z = new ArrayList();
        this.a0 = new boolean[2];
        b bVar = b.FIXED;
        this.b0 = new b[]{bVar, bVar};
        this.c0 = null;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0.0f;
        this.g0 = -1;
        this.h0 = 0;
        this.i0 = 0;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        float f = U0;
        this.q0 = f;
        this.r0 = f;
        this.t0 = 0;
        this.u0 = 0;
        this.v0 = false;
        this.w0 = null;
        this.x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new C16651le1[]{null, null};
        this.P0 = new C16651le1[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        d();
    }

    private void d() {
        this.Z.add(this.Q);
        this.Z.add(this.R);
        this.Z.add(this.S);
        this.Z.add(this.T);
        this.Z.add(this.V);
        this.Z.add(this.W);
        this.Z.add(this.X);
        this.Z.add(this.U);
    }

    private boolean g0(int i) {
        C8243Vd1 c8243Vd1;
        C8243Vd1 c8243Vd12;
        int i2 = i * 2;
        C8243Vd1[] c8243Vd1Arr = this.Y;
        C8243Vd1 c8243Vd13 = c8243Vd1Arr[i2];
        C8243Vd1 c8243Vd14 = c8243Vd13.f;
        return (c8243Vd14 == null || c8243Vd14.f == c8243Vd13 || (c8243Vd12 = (c8243Vd1 = c8243Vd1Arr[i2 + 1]).f) == null || c8243Vd12.f != c8243Vd1) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01db A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0585 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:383:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i(ir.nasim.C8963Xz3 r38, boolean r39, boolean r40, boolean r41, boolean r42, ir.nasim.EH6 r43, ir.nasim.EH6 r44, ir.nasim.C16651le1.b r45, boolean r46, ir.nasim.C8243Vd1 r47, ir.nasim.C8243Vd1 r48, int r49, int r50, int r51, int r52, float r53, boolean r54, boolean r55, boolean r56, boolean r57, boolean r58, int r59, int r60, int r61, int r62, float r63, boolean r64) {
        /*
            Method dump skipped, instructions count: 1472
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16651le1.i(ir.nasim.Xz3, boolean, boolean, boolean, boolean, ir.nasim.EH6, ir.nasim.EH6, ir.nasim.le1$b, boolean, ir.nasim.Vd1, ir.nasim.Vd1, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public float A() {
        return this.q0;
    }

    public void A0(Object obj) {
        this.s0 = obj;
    }

    public int B() {
        return this.J0;
    }

    public void B0(String str) {
        this.w0 = str;
    }

    public b C() {
        return this.b0[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0086 A[PHI: r0
      0x0086: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:46:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C0(java.lang.String r9) throws java.lang.NumberFormatException {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L90
            int r1 = r9.length()
            if (r1 != 0) goto Lb
            goto L90
        Lb:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L39
            int r6 = r1 + (-1)
            if (r2 >= r6) goto L39
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L2b
            goto L36
        L2b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L35
            r3 = r4
            goto L36
        L35:
            r3 = r5
        L36:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L39:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L77
            int r1 = r1 - r4
            if (r2 >= r1) goto L77
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L86
            int r2 = r9.length()
            if (r2 <= 0) goto L86
            float r1 = java.lang.Float.parseFloat(r1)     // Catch: java.lang.NumberFormatException -> L86
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L86
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L86
            if (r5 != r4) goto L71
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch: java.lang.NumberFormatException -> L86
            goto L87
        L71:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch: java.lang.NumberFormatException -> L86
            goto L87
        L77:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L86
            float r9 = java.lang.Float.parseFloat(r9)     // Catch: java.lang.NumberFormatException -> L86
            goto L87
        L86:
            r9 = r0
        L87:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L8f
            r8.f0 = r9
            r8.g0 = r5
        L8f:
            return
        L90:
            r8.f0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16651le1.C0(java.lang.String):void");
    }

    public int D() {
        C8243Vd1 c8243Vd1 = this.Q;
        int i = c8243Vd1 != null ? c8243Vd1.g : 0;
        C8243Vd1 c8243Vd12 = this.S;
        return c8243Vd12 != null ? i + c8243Vd12.g : i;
    }

    public void D0(int i) {
        if (this.L) {
            int i2 = i - this.n0;
            int i3 = this.e0 + i2;
            this.i0 = i2;
            this.R.t(i2);
            this.T.t(i3);
            this.U.t(i);
            this.q = true;
        }
    }

    public int E() {
        return this.O;
    }

    public void E0(int i, int i2) {
        if (this.p) {
            return;
        }
        this.Q.t(i);
        this.S.t(i2);
        this.h0 = i;
        this.d0 = i2 - i;
        this.p = true;
    }

    public int F() {
        return this.P;
    }

    public void F0(int i) {
        this.Q.t(i);
        this.h0 = i;
    }

    public int G() {
        return Y();
    }

    public void G0(int i) {
        this.R.t(i);
        this.i0 = i;
    }

    public int H(int i) {
        if (i == 0) {
            return X();
        }
        if (i == 1) {
            return z();
        }
        return 0;
    }

    public void H0(int i, int i2) {
        if (this.q) {
            return;
        }
        this.R.t(i);
        this.T.t(i2);
        this.i0 = i;
        this.e0 = i2 - i;
        if (this.L) {
            this.U.t(i + this.n0);
        }
        this.q = true;
    }

    public int I() {
        return this.J[1];
    }

    public void I0(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.h0 = i;
        this.i0 = i2;
        if (this.u0 == 8) {
            this.d0 = 0;
            this.e0 = 0;
            return;
        }
        b[] bVarArr = this.b0;
        b bVar = bVarArr[0];
        b bVar2 = b.FIXED;
        if (bVar == bVar2 && i7 < (i6 = this.d0)) {
            i7 = i6;
        }
        if (bVarArr[1] == bVar2 && i8 < (i5 = this.e0)) {
            i8 = i5;
        }
        this.d0 = i7;
        this.e0 = i8;
        int i9 = this.p0;
        if (i8 < i9) {
            this.e0 = i9;
        }
        int i10 = this.o0;
        if (i7 < i10) {
            this.d0 = i10;
        }
        int i11 = this.A;
        if (i11 > 0 && bVar == b.MATCH_CONSTRAINT) {
            this.d0 = Math.min(this.d0, i11);
        }
        int i12 = this.D;
        if (i12 > 0 && this.b0[1] == b.MATCH_CONSTRAINT) {
            this.e0 = Math.min(this.e0, i12);
        }
        int i13 = this.d0;
        if (i7 != i13) {
            this.l = i13;
        }
        int i14 = this.e0;
        if (i8 != i14) {
            this.m = i14;
        }
    }

    public int J() {
        return this.J[0];
    }

    public void J0(boolean z) {
        this.L = z;
    }

    public int K() {
        return this.p0;
    }

    public void K0(int i) {
        this.e0 = i;
        int i2 = this.p0;
        if (i < i2) {
            this.e0 = i2;
        }
    }

    public int L() {
        return this.o0;
    }

    public void L0(float f) {
        this.q0 = f;
    }

    public C16651le1 M(int i) {
        C8243Vd1 c8243Vd1;
        C8243Vd1 c8243Vd12;
        if (i != 0) {
            if (i == 1 && (c8243Vd12 = (c8243Vd1 = this.T).f) != null && c8243Vd12.f == c8243Vd1) {
                return c8243Vd12.d;
            }
            return null;
        }
        C8243Vd1 c8243Vd13 = this.S;
        C8243Vd1 c8243Vd14 = c8243Vd13.f;
        if (c8243Vd14 == null || c8243Vd14.f != c8243Vd13) {
            return null;
        }
        return c8243Vd14.d;
    }

    public void M0(int i) {
        this.J0 = i;
    }

    public C16651le1 N() {
        return this.c0;
    }

    public void N0(int i, int i2) {
        this.h0 = i;
        int i3 = i2 - i;
        this.d0 = i3;
        int i4 = this.o0;
        if (i3 < i4) {
            this.d0 = i4;
        }
    }

    public C16651le1 O(int i) {
        C8243Vd1 c8243Vd1;
        C8243Vd1 c8243Vd12;
        if (i != 0) {
            if (i == 1 && (c8243Vd12 = (c8243Vd1 = this.R).f) != null && c8243Vd12.f == c8243Vd1) {
                return c8243Vd12.d;
            }
            return null;
        }
        C8243Vd1 c8243Vd13 = this.Q;
        C8243Vd1 c8243Vd14 = c8243Vd13.f;
        if (c8243Vd14 == null || c8243Vd14.f != c8243Vd13) {
            return null;
        }
        return c8243Vd14.d;
    }

    public void O0(b bVar) {
        this.b0[0] = bVar;
    }

    public int P() {
        return Y() + this.d0;
    }

    public void P0(int i, int i2, int i3, float f) {
        this.w = i;
        this.z = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.A = i3;
        this.B = f;
        if (f <= 0.0f || f >= 1.0f || i != 0) {
            return;
        }
        this.w = 2;
    }

    public AbstractC15192j98 Q(int i) {
        if (i == 0) {
            return this.e;
        }
        if (i == 1) {
            return this.f;
        }
        return null;
    }

    public void Q0(float f) {
        this.N0[0] = f;
    }

    public int R() {
        return Z();
    }

    protected void R0(int i, boolean z) {
        this.a0[i] = z;
    }

    public float S() {
        return this.r0;
    }

    public void S0(boolean z) {
        this.M = z;
    }

    public int T() {
        return this.K0;
    }

    public void T0(boolean z) {
        this.N = z;
    }

    public b U() {
        return this.b0[1];
    }

    public void U0(int i, int i2) {
        this.O = i;
        this.P = i2;
        X0(false);
    }

    public int V() {
        int i = this.Q != null ? this.R.g : 0;
        return this.S != null ? i + this.T.g : i;
    }

    public void V0(int i) {
        this.J[1] = i;
    }

    public int W() {
        return this.u0;
    }

    public void W0(int i) {
        this.J[0] = i;
    }

    public int X() {
        if (this.u0 == 8) {
            return 0;
        }
        return this.d0;
    }

    public void X0(boolean z) {
        this.i = z;
    }

    public int Y() {
        C16651le1 c16651le1 = this.c0;
        return (c16651le1 == null || !(c16651le1 instanceof C17242me1)) ? this.h0 : ((C17242me1) c16651le1).c1 + this.h0;
    }

    public void Y0(int i) {
        if (i < 0) {
            this.p0 = 0;
        } else {
            this.p0 = i;
        }
    }

    public int Z() {
        C16651le1 c16651le1 = this.c0;
        return (c16651le1 == null || !(c16651le1 instanceof C17242me1)) ? this.i0 : ((C17242me1) c16651le1).d1 + this.i0;
    }

    public void Z0(int i) {
        if (i < 0) {
            this.o0 = 0;
        } else {
            this.o0 = i;
        }
    }

    public boolean a0() {
        return this.L;
    }

    public void a1(int i, int i2) {
        this.h0 = i;
        this.i0 = i2;
    }

    public boolean b0(int i) {
        if (i == 0) {
            return (this.Q.f != null ? 1 : 0) + (this.S.f != null ? 1 : 0) < 2;
        }
        return ((this.R.f != null ? 1 : 0) + (this.T.f != null ? 1 : 0)) + (this.U.f != null ? 1 : 0) < 2;
    }

    public void b1(C16651le1 c16651le1) {
        this.c0 = c16651le1;
    }

    public boolean c0() {
        int size = this.Z.size();
        for (int i = 0; i < size; i++) {
            if (((C8243Vd1) this.Z.get(i)).m()) {
                return true;
            }
        }
        return false;
    }

    public void c1(float f) {
        this.r0 = f;
    }

    public boolean d0() {
        return (this.l == -1 && this.m == -1) ? false : true;
    }

    public void d1(int i) {
        this.K0 = i;
    }

    public void e(C17242me1 c17242me1, C8963Xz3 c8963Xz3, HashSet hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            AbstractC22501vL4.a(c17242me1, c8963Xz3, this);
            hashSet.remove(this);
            g(c8963Xz3, c17242me1.S1(64));
        }
        if (i == 0) {
            HashSet hashSetD = this.Q.d();
            if (hashSetD != null) {
                Iterator it = hashSetD.iterator();
                while (it.hasNext()) {
                    ((C8243Vd1) it.next()).d.e(c17242me1, c8963Xz3, hashSet, i, true);
                }
            }
            HashSet hashSetD2 = this.S.d();
            if (hashSetD2 != null) {
                Iterator it2 = hashSetD2.iterator();
                while (it2.hasNext()) {
                    ((C8243Vd1) it2.next()).d.e(c17242me1, c8963Xz3, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet hashSetD3 = this.R.d();
        if (hashSetD3 != null) {
            Iterator it3 = hashSetD3.iterator();
            while (it3.hasNext()) {
                ((C8243Vd1) it3.next()).d.e(c17242me1, c8963Xz3, hashSet, i, true);
            }
        }
        HashSet hashSetD4 = this.T.d();
        if (hashSetD4 != null) {
            Iterator it4 = hashSetD4.iterator();
            while (it4.hasNext()) {
                ((C8243Vd1) it4.next()).d.e(c17242me1, c8963Xz3, hashSet, i, true);
            }
        }
        HashSet hashSetD5 = this.U.d();
        if (hashSetD5 != null) {
            Iterator it5 = hashSetD5.iterator();
            while (it5.hasNext()) {
                ((C8243Vd1) it5.next()).d.e(c17242me1, c8963Xz3, hashSet, i, true);
            }
        }
    }

    public boolean e0(int i, int i2) {
        C8243Vd1 c8243Vd1;
        C8243Vd1 c8243Vd12;
        if (i == 0) {
            C8243Vd1 c8243Vd13 = this.Q.f;
            return c8243Vd13 != null && c8243Vd13.n() && (c8243Vd12 = this.S.f) != null && c8243Vd12.n() && (this.S.f.e() - this.S.f()) - (this.Q.f.e() + this.Q.f()) >= i2;
        }
        C8243Vd1 c8243Vd14 = this.R.f;
        return c8243Vd14 != null && c8243Vd14.n() && (c8243Vd1 = this.T.f) != null && c8243Vd1.n() && (this.T.f.e() - this.T.f()) - (this.R.f.e() + this.R.f()) >= i2;
        return false;
    }

    public void e1(int i, int i2) {
        this.i0 = i;
        int i3 = i2 - i;
        this.e0 = i3;
        int i4 = this.p0;
        if (i3 < i4) {
            this.e0 = i4;
        }
    }

    boolean f() {
        return (this instanceof DY7) || (this instanceof NS2);
    }

    public void f0(C8243Vd1.b bVar, C16651le1 c16651le1, C8243Vd1.b bVar2, int i, int i2) {
        q(bVar).b(c16651le1.q(bVar2), i, i2, true);
    }

    public void f1(b bVar) {
        this.b0[1] = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:183:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0544  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x05be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(ir.nasim.C8963Xz3 r54, boolean r55) {
        /*
            Method dump skipped, instructions count: 1508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16651le1.g(ir.nasim.Xz3, boolean):void");
    }

    public void g1(int i, int i2, int i3, float f) {
        this.x = i;
        this.C = i2;
        if (i3 == Integer.MAX_VALUE) {
            i3 = 0;
        }
        this.D = i3;
        this.E = f;
        if (f <= 0.0f || f >= 1.0f || i != 0) {
            return;
        }
        this.x = 2;
    }

    public boolean h() {
        return this.u0 != 8;
    }

    public boolean h0() {
        return this.r;
    }

    public void h1(float f) {
        this.N0[1] = f;
    }

    public boolean i0(int i) {
        return this.a0[i];
    }

    public void i1(int i) {
        this.u0 = i;
    }

    public void j(C8243Vd1.b bVar, C16651le1 c16651le1, C8243Vd1.b bVar2) {
        k(bVar, c16651le1, bVar2, 0);
    }

    public boolean j0() {
        C8243Vd1 c8243Vd1 = this.Q;
        C8243Vd1 c8243Vd12 = c8243Vd1.f;
        if (c8243Vd12 != null && c8243Vd12.f == c8243Vd1) {
            return true;
        }
        C8243Vd1 c8243Vd13 = this.S;
        C8243Vd1 c8243Vd14 = c8243Vd13.f;
        return c8243Vd14 != null && c8243Vd14.f == c8243Vd13;
    }

    public void j1(int i) {
        this.d0 = i;
        int i2 = this.o0;
        if (i < i2) {
            this.d0 = i2;
        }
    }

    public void k(C8243Vd1.b bVar, C16651le1 c16651le1, C8243Vd1.b bVar2, int i) {
        C8243Vd1.b bVar3;
        C8243Vd1.b bVar4;
        boolean z;
        C8243Vd1.b bVar5 = C8243Vd1.b.CENTER;
        if (bVar == bVar5) {
            if (bVar2 != bVar5) {
                C8243Vd1.b bVar6 = C8243Vd1.b.LEFT;
                if (bVar2 == bVar6 || bVar2 == C8243Vd1.b.RIGHT) {
                    k(bVar6, c16651le1, bVar2, 0);
                    k(C8243Vd1.b.RIGHT, c16651le1, bVar2, 0);
                    q(bVar5).a(c16651le1.q(bVar2), 0);
                    return;
                }
                C8243Vd1.b bVar7 = C8243Vd1.b.TOP;
                if (bVar2 == bVar7 || bVar2 == C8243Vd1.b.BOTTOM) {
                    k(bVar7, c16651le1, bVar2, 0);
                    k(C8243Vd1.b.BOTTOM, c16651le1, bVar2, 0);
                    q(bVar5).a(c16651le1.q(bVar2), 0);
                    return;
                }
                return;
            }
            C8243Vd1.b bVar8 = C8243Vd1.b.LEFT;
            C8243Vd1 c8243Vd1Q = q(bVar8);
            C8243Vd1.b bVar9 = C8243Vd1.b.RIGHT;
            C8243Vd1 c8243Vd1Q2 = q(bVar9);
            C8243Vd1.b bVar10 = C8243Vd1.b.TOP;
            C8243Vd1 c8243Vd1Q3 = q(bVar10);
            C8243Vd1.b bVar11 = C8243Vd1.b.BOTTOM;
            C8243Vd1 c8243Vd1Q4 = q(bVar11);
            boolean z2 = true;
            if ((c8243Vd1Q == null || !c8243Vd1Q.o()) && (c8243Vd1Q2 == null || !c8243Vd1Q2.o())) {
                k(bVar8, c16651le1, bVar8, 0);
                k(bVar9, c16651le1, bVar9, 0);
                z = true;
            } else {
                z = false;
            }
            if ((c8243Vd1Q3 == null || !c8243Vd1Q3.o()) && (c8243Vd1Q4 == null || !c8243Vd1Q4.o())) {
                k(bVar10, c16651le1, bVar10, 0);
                k(bVar11, c16651le1, bVar11, 0);
            } else {
                z2 = false;
            }
            if (z && z2) {
                q(bVar5).a(c16651le1.q(bVar5), 0);
                return;
            }
            if (z) {
                C8243Vd1.b bVar12 = C8243Vd1.b.CENTER_X;
                q(bVar12).a(c16651le1.q(bVar12), 0);
                return;
            } else {
                if (z2) {
                    C8243Vd1.b bVar13 = C8243Vd1.b.CENTER_Y;
                    q(bVar13).a(c16651le1.q(bVar13), 0);
                    return;
                }
                return;
            }
        }
        C8243Vd1.b bVar14 = C8243Vd1.b.CENTER_X;
        if (bVar == bVar14 && (bVar2 == (bVar4 = C8243Vd1.b.LEFT) || bVar2 == C8243Vd1.b.RIGHT)) {
            C8243Vd1 c8243Vd1Q5 = q(bVar4);
            C8243Vd1 c8243Vd1Q6 = c16651le1.q(bVar2);
            C8243Vd1 c8243Vd1Q7 = q(C8243Vd1.b.RIGHT);
            c8243Vd1Q5.a(c8243Vd1Q6, 0);
            c8243Vd1Q7.a(c8243Vd1Q6, 0);
            q(bVar14).a(c8243Vd1Q6, 0);
            return;
        }
        C8243Vd1.b bVar15 = C8243Vd1.b.CENTER_Y;
        if (bVar == bVar15 && (bVar2 == (bVar3 = C8243Vd1.b.TOP) || bVar2 == C8243Vd1.b.BOTTOM)) {
            C8243Vd1 c8243Vd1Q8 = c16651le1.q(bVar2);
            q(bVar3).a(c8243Vd1Q8, 0);
            q(C8243Vd1.b.BOTTOM).a(c8243Vd1Q8, 0);
            q(bVar15).a(c8243Vd1Q8, 0);
            return;
        }
        if (bVar == bVar14 && bVar2 == bVar14) {
            C8243Vd1.b bVar16 = C8243Vd1.b.LEFT;
            q(bVar16).a(c16651le1.q(bVar16), 0);
            C8243Vd1.b bVar17 = C8243Vd1.b.RIGHT;
            q(bVar17).a(c16651le1.q(bVar17), 0);
            q(bVar14).a(c16651le1.q(bVar2), 0);
            return;
        }
        if (bVar == bVar15 && bVar2 == bVar15) {
            C8243Vd1.b bVar18 = C8243Vd1.b.TOP;
            q(bVar18).a(c16651le1.q(bVar18), 0);
            C8243Vd1.b bVar19 = C8243Vd1.b.BOTTOM;
            q(bVar19).a(c16651le1.q(bVar19), 0);
            q(bVar15).a(c16651le1.q(bVar2), 0);
            return;
        }
        C8243Vd1 c8243Vd1Q9 = q(bVar);
        C8243Vd1 c8243Vd1Q10 = c16651le1.q(bVar2);
        if (c8243Vd1Q9.p(c8243Vd1Q10)) {
            C8243Vd1.b bVar20 = C8243Vd1.b.BASELINE;
            if (bVar == bVar20) {
                C8243Vd1 c8243Vd1Q11 = q(C8243Vd1.b.TOP);
                C8243Vd1 c8243Vd1Q12 = q(C8243Vd1.b.BOTTOM);
                if (c8243Vd1Q11 != null) {
                    c8243Vd1Q11.q();
                }
                if (c8243Vd1Q12 != null) {
                    c8243Vd1Q12.q();
                }
            } else if (bVar == C8243Vd1.b.TOP || bVar == C8243Vd1.b.BOTTOM) {
                C8243Vd1 c8243Vd1Q13 = q(bVar20);
                if (c8243Vd1Q13 != null) {
                    c8243Vd1Q13.q();
                }
                C8243Vd1 c8243Vd1Q14 = q(bVar5);
                if (c8243Vd1Q14.j() != c8243Vd1Q10) {
                    c8243Vd1Q14.q();
                }
                C8243Vd1 c8243Vd1G = q(bVar).g();
                C8243Vd1 c8243Vd1Q15 = q(bVar15);
                if (c8243Vd1Q15.o()) {
                    c8243Vd1G.q();
                    c8243Vd1Q15.q();
                }
            } else if (bVar == C8243Vd1.b.LEFT || bVar == C8243Vd1.b.RIGHT) {
                C8243Vd1 c8243Vd1Q16 = q(bVar5);
                if (c8243Vd1Q16.j() != c8243Vd1Q10) {
                    c8243Vd1Q16.q();
                }
                C8243Vd1 c8243Vd1G2 = q(bVar).g();
                C8243Vd1 c8243Vd1Q17 = q(bVar14);
                if (c8243Vd1Q17.o()) {
                    c8243Vd1G2.q();
                    c8243Vd1Q17.q();
                }
            }
            c8243Vd1Q9.a(c8243Vd1Q10, i);
        }
    }

    public boolean k0() {
        return this.M;
    }

    public void k1(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.v = i;
    }

    public void l(C8243Vd1 c8243Vd1, C8243Vd1 c8243Vd12, int i) {
        if (c8243Vd1.h() == this) {
            k(c8243Vd1.k(), c8243Vd12.h(), c8243Vd12.k(), i);
        }
    }

    public boolean l0() {
        C8243Vd1 c8243Vd1 = this.R;
        C8243Vd1 c8243Vd12 = c8243Vd1.f;
        if (c8243Vd12 != null && c8243Vd12.f == c8243Vd1) {
            return true;
        }
        C8243Vd1 c8243Vd13 = this.T;
        C8243Vd1 c8243Vd14 = c8243Vd13.f;
        return c8243Vd14 != null && c8243Vd14.f == c8243Vd13;
    }

    public void l1(int i) {
        this.h0 = i;
    }

    public void m(C16651le1 c16651le1, float f, int i) {
        C8243Vd1.b bVar = C8243Vd1.b.CENTER;
        f0(bVar, c16651le1, bVar, i, 0);
        this.K = f;
    }

    public boolean m0() {
        return this.N;
    }

    public void m1(int i) {
        this.i0 = i;
    }

    public void n(C16651le1 c16651le1, HashMap map) {
        this.t = c16651le1.t;
        this.u = c16651le1.u;
        this.w = c16651le1.w;
        this.x = c16651le1.x;
        int[] iArr = this.y;
        int[] iArr2 = c16651le1.y;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.z = c16651le1.z;
        this.A = c16651le1.A;
        this.C = c16651le1.C;
        this.D = c16651le1.D;
        this.E = c16651le1.E;
        this.F = c16651le1.F;
        this.G = c16651le1.G;
        this.H = c16651le1.H;
        this.I = c16651le1.I;
        int[] iArr3 = c16651le1.J;
        this.J = Arrays.copyOf(iArr3, iArr3.length);
        this.K = c16651le1.K;
        this.L = c16651le1.L;
        this.M = c16651le1.M;
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.b0 = (b[]) Arrays.copyOf(this.b0, 2);
        this.c0 = this.c0 == null ? null : (C16651le1) map.get(c16651le1.c0);
        this.d0 = c16651le1.d0;
        this.e0 = c16651le1.e0;
        this.f0 = c16651le1.f0;
        this.g0 = c16651le1.g0;
        this.h0 = c16651le1.h0;
        this.i0 = c16651le1.i0;
        this.j0 = c16651le1.j0;
        this.k0 = c16651le1.k0;
        this.l0 = c16651le1.l0;
        this.m0 = c16651le1.m0;
        this.n0 = c16651le1.n0;
        this.o0 = c16651le1.o0;
        this.p0 = c16651le1.p0;
        this.q0 = c16651le1.q0;
        this.r0 = c16651le1.r0;
        this.s0 = c16651le1.s0;
        this.t0 = c16651le1.t0;
        this.u0 = c16651le1.u0;
        this.v0 = c16651le1.v0;
        this.w0 = c16651le1.w0;
        this.x0 = c16651le1.x0;
        this.y0 = c16651le1.y0;
        this.z0 = c16651le1.z0;
        this.A0 = c16651le1.A0;
        this.B0 = c16651le1.B0;
        this.C0 = c16651le1.C0;
        this.D0 = c16651le1.D0;
        this.E0 = c16651le1.E0;
        this.F0 = c16651le1.F0;
        this.G0 = c16651le1.G0;
        this.H0 = c16651le1.H0;
        this.J0 = c16651le1.J0;
        this.K0 = c16651le1.K0;
        this.L0 = c16651le1.L0;
        this.M0 = c16651le1.M0;
        float[] fArr = this.N0;
        float[] fArr2 = c16651le1.N0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        C16651le1[] c16651le1Arr = this.O0;
        C16651le1[] c16651le1Arr2 = c16651le1.O0;
        c16651le1Arr[0] = c16651le1Arr2[0];
        c16651le1Arr[1] = c16651le1Arr2[1];
        C16651le1[] c16651le1Arr3 = this.P0;
        C16651le1[] c16651le1Arr4 = c16651le1.P0;
        c16651le1Arr3[0] = c16651le1Arr4[0];
        c16651le1Arr3[1] = c16651le1Arr4[1];
        C16651le1 c16651le12 = c16651le1.Q0;
        this.Q0 = c16651le12 == null ? null : (C16651le1) map.get(c16651le12);
        C16651le1 c16651le13 = c16651le1.R0;
        this.R0 = c16651le13 != null ? (C16651le1) map.get(c16651le13) : null;
    }

    public boolean n0() {
        return this.i && this.u0 != 8;
    }

    public void n1(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.H == -1) {
            if (z3 && !z4) {
                this.H = 0;
            } else if (!z3 && z4) {
                this.H = 1;
                if (this.g0 == -1) {
                    this.I = 1.0f / this.I;
                }
            }
        }
        if (this.H == 0 && (!this.R.o() || !this.T.o())) {
            this.H = 1;
        } else if (this.H == 1 && (!this.Q.o() || !this.S.o())) {
            this.H = 0;
        }
        if (this.H == -1 && (!this.R.o() || !this.T.o() || !this.Q.o() || !this.S.o())) {
            if (this.R.o() && this.T.o()) {
                this.H = 0;
            } else if (this.Q.o() && this.S.o()) {
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
        if (this.H == -1) {
            int i = this.z;
            if (i > 0 && this.C == 0) {
                this.H = 0;
            } else {
                if (i != 0 || this.C <= 0) {
                    return;
                }
                this.I = 1.0f / this.I;
                this.H = 1;
            }
        }
    }

    public void o(C8963Xz3 c8963Xz3) {
        c8963Xz3.q(this.Q);
        c8963Xz3.q(this.R);
        c8963Xz3.q(this.S);
        c8963Xz3.q(this.T);
        if (this.n0 > 0) {
            c8963Xz3.q(this.U);
        }
    }

    public boolean o0() {
        return this.p || (this.Q.n() && this.S.n());
    }

    public void o1(boolean z, boolean z2) {
        int i;
        int i2;
        boolean zK = z & this.e.k();
        boolean zK2 = z2 & this.f.k();
        RY2 ry2 = this.e;
        int i3 = ry2.h.g;
        C17727nS7 c17727nS7 = this.f;
        int i4 = c17727nS7.h.g;
        int i5 = ry2.i.g;
        int i6 = c17727nS7.i.g;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i3 = 0;
            i6 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (zK) {
            this.h0 = i3;
        }
        if (zK2) {
            this.i0 = i4;
        }
        if (this.u0 == 8) {
            this.d0 = 0;
            this.e0 = 0;
            return;
        }
        if (zK) {
            if (this.b0[0] == b.FIXED && i8 < (i2 = this.d0)) {
                i8 = i2;
            }
            this.d0 = i8;
            int i10 = this.o0;
            if (i8 < i10) {
                this.d0 = i10;
            }
        }
        if (zK2) {
            if (this.b0[1] == b.FIXED && i9 < (i = this.e0)) {
                i9 = i;
            }
            this.e0 = i9;
            int i11 = this.p0;
            if (i9 < i11) {
                this.e0 = i11;
            }
        }
    }

    public void p() {
        if (this.e == null) {
            this.e = new RY2(this);
        }
        if (this.f == null) {
            this.f = new C17727nS7(this);
        }
    }

    public boolean p0() {
        return this.q || (this.R.n() && this.T.n());
    }

    public void p1(C8963Xz3 c8963Xz3, boolean z) {
        C17727nS7 c17727nS7;
        RY2 ry2;
        int iX = c8963Xz3.x(this.Q);
        int iX2 = c8963Xz3.x(this.R);
        int iX3 = c8963Xz3.x(this.S);
        int iX4 = c8963Xz3.x(this.T);
        if (z && (ry2 = this.e) != null) {
            C13476gI1 c13476gI1 = ry2.h;
            if (c13476gI1.j) {
                C13476gI1 c13476gI12 = ry2.i;
                if (c13476gI12.j) {
                    iX = c13476gI1.g;
                    iX3 = c13476gI12.g;
                }
            }
        }
        if (z && (c17727nS7 = this.f) != null) {
            C13476gI1 c13476gI13 = c17727nS7.h;
            if (c13476gI13.j) {
                C13476gI1 c13476gI14 = c17727nS7.i;
                if (c13476gI14.j) {
                    iX2 = c13476gI13.g;
                    iX4 = c13476gI14.g;
                }
            }
        }
        int i = iX4 - iX2;
        if (iX3 - iX < 0 || i < 0 || iX == Integer.MIN_VALUE || iX == Integer.MAX_VALUE || iX2 == Integer.MIN_VALUE || iX2 == Integer.MAX_VALUE || iX3 == Integer.MIN_VALUE || iX3 == Integer.MAX_VALUE || iX4 == Integer.MIN_VALUE || iX4 == Integer.MAX_VALUE) {
            iX = 0;
            iX4 = 0;
            iX2 = 0;
            iX3 = 0;
        }
        I0(iX, iX2, iX3, iX4);
    }

    public C8243Vd1 q(C8243Vd1.b bVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return this.Q;
            case 2:
                return this.R;
            case 3:
                return this.S;
            case 4:
                return this.T;
            case 5:
                return this.U;
            case 6:
                return this.X;
            case 7:
                return this.V;
            case 8:
                return this.W;
            case 9:
                return null;
            default:
                throw new AssertionError(bVar.name());
        }
    }

    public boolean q0() {
        return this.s;
    }

    public int r() {
        return this.n0;
    }

    public void r0() {
        this.r = true;
    }

    public float s(int i) {
        if (i == 0) {
            return this.q0;
        }
        if (i == 1) {
            return this.r0;
        }
        return -1.0f;
    }

    public void s0() {
        this.s = true;
    }

    public int t() {
        return Z() + this.e0;
    }

    public boolean t0() {
        b[] bVarArr = this.b0;
        b bVar = bVarArr[0];
        b bVar2 = b.MATCH_CONSTRAINT;
        return bVar == bVar2 && bVarArr[1] == bVar2;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.x0 != null) {
            str = "type: " + this.x0 + Separators.SP;
        } else {
            str = "";
        }
        sb.append(str);
        if (this.w0 != null) {
            str2 = "id: " + this.w0 + Separators.SP;
        }
        sb.append(str2);
        sb.append(Separators.LPAREN);
        sb.append(this.h0);
        sb.append(", ");
        sb.append(this.i0);
        sb.append(") - (");
        sb.append(this.d0);
        sb.append(" x ");
        sb.append(this.e0);
        sb.append(Separators.RPAREN);
        return sb.toString();
    }

    public Object u() {
        return this.s0;
    }

    public void u0() {
        this.Q.q();
        this.R.q();
        this.S.q();
        this.T.q();
        this.U.q();
        this.V.q();
        this.W.q();
        this.X.q();
        this.c0 = null;
        this.K = 0.0f;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0.0f;
        this.g0 = -1;
        this.h0 = 0;
        this.i0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = 0;
        this.p0 = 0;
        float f = U0;
        this.q0 = f;
        this.r0 = f;
        b[] bVarArr = this.b0;
        b bVar = b.FIXED;
        bVarArr[0] = bVar;
        bVarArr[1] = bVar;
        this.s0 = null;
        this.t0 = 0;
        this.u0 = 0;
        this.x0 = null;
        this.G0 = false;
        this.H0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = false;
        float[] fArr = this.N0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.t = -1;
        this.u = -1;
        int[] iArr = this.J;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.w = 0;
        this.x = 0;
        this.B = 1.0f;
        this.E = 1.0f;
        this.A = Integer.MAX_VALUE;
        this.D = Integer.MAX_VALUE;
        this.z = 0;
        this.C = 0;
        this.h = false;
        this.H = -1;
        this.I = 1.0f;
        this.I0 = false;
        boolean[] zArr = this.g;
        zArr[0] = true;
        zArr[1] = true;
        this.N = false;
        boolean[] zArr2 = this.a0;
        zArr2[0] = false;
        zArr2[1] = false;
        this.i = true;
        int[] iArr2 = this.y;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.l = -1;
        this.m = -1;
    }

    public String v() {
        return this.w0;
    }

    public void v0() {
        w0();
        c1(U0);
        L0(U0);
    }

    public b w(int i) {
        if (i == 0) {
            return C();
        }
        if (i == 1) {
            return U();
        }
        return null;
    }

    public void w0() {
        C16651le1 c16651le1N = N();
        if (c16651le1N != null && (c16651le1N instanceof C17242me1) && ((C17242me1) N()).K1()) {
            return;
        }
        int size = this.Z.size();
        for (int i = 0; i < size; i++) {
            ((C8243Vd1) this.Z.get(i)).q();
        }
    }

    public float x() {
        return this.f0;
    }

    public void x0() {
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        int size = this.Z.size();
        for (int i = 0; i < size; i++) {
            ((C8243Vd1) this.Z.get(i)).r();
        }
    }

    public int y() {
        return this.g0;
    }

    public void y0(C13196fp0 c13196fp0) {
        this.Q.s(c13196fp0);
        this.R.s(c13196fp0);
        this.S.s(c13196fp0);
        this.T.s(c13196fp0);
        this.U.s(c13196fp0);
        this.X.s(c13196fp0);
        this.V.s(c13196fp0);
        this.W.s(c13196fp0);
    }

    public int z() {
        if (this.u0 == 8) {
            return 0;
        }
        return this.e0;
    }

    public void z0(int i) {
        this.n0 = i;
        this.L = i > 0;
    }

    public C16651le1(int i, int i2, int i3, int i4) {
        this.a = false;
        this.b = new AbstractC15192j98[2];
        this.e = null;
        this.f = null;
        this.g = new boolean[]{true, true};
        this.h = false;
        this.i = true;
        this.j = false;
        this.k = true;
        this.l = -1;
        this.m = -1;
        this.n = new C13992h98(this);
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = new int[2];
        this.z = 0;
        this.A = 0;
        this.B = 1.0f;
        this.C = 0;
        this.D = 0;
        this.E = 1.0f;
        this.H = -1;
        this.I = 1.0f;
        this.J = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.K = 0.0f;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = new C8243Vd1(this, C8243Vd1.b.LEFT);
        this.R = new C8243Vd1(this, C8243Vd1.b.TOP);
        this.S = new C8243Vd1(this, C8243Vd1.b.RIGHT);
        this.T = new C8243Vd1(this, C8243Vd1.b.BOTTOM);
        this.U = new C8243Vd1(this, C8243Vd1.b.BASELINE);
        this.V = new C8243Vd1(this, C8243Vd1.b.CENTER_X);
        this.W = new C8243Vd1(this, C8243Vd1.b.CENTER_Y);
        C8243Vd1 c8243Vd1 = new C8243Vd1(this, C8243Vd1.b.CENTER);
        this.X = c8243Vd1;
        this.Y = new C8243Vd1[]{this.Q, this.S, this.R, this.T, this.U, c8243Vd1};
        this.Z = new ArrayList();
        this.a0 = new boolean[2];
        b bVar = b.FIXED;
        this.b0 = new b[]{bVar, bVar};
        this.c0 = null;
        this.f0 = 0.0f;
        this.g0 = -1;
        this.j0 = 0;
        this.k0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = 0;
        float f = U0;
        this.q0 = f;
        this.r0 = f;
        this.t0 = 0;
        this.u0 = 0;
        this.v0 = false;
        this.w0 = null;
        this.x0 = null;
        this.I0 = false;
        this.J0 = 0;
        this.K0 = 0;
        this.N0 = new float[]{-1.0f, -1.0f};
        this.O0 = new C16651le1[]{null, null};
        this.P0 = new C16651le1[]{null, null};
        this.Q0 = null;
        this.R0 = null;
        this.S0 = -1;
        this.T0 = -1;
        this.h0 = i;
        this.i0 = i2;
        this.d0 = i3;
        this.e0 = i4;
        d();
    }

    public C16651le1(int i, int i2) {
        this(0, 0, i, i2);
    }
}
