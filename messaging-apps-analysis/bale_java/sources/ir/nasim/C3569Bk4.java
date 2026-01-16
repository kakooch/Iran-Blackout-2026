package ir.nasim;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.ML;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.TTL;

/* renamed from: ir.nasim.Bk4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3569Bk4 implements InterfaceC9262Ze2, InterfaceC22148uk6 {
    public static final InterfaceC12462ef2 y = new InterfaceC12462ef2() { // from class: ir.nasim.Ak4
        @Override // ir.nasim.InterfaceC12462ef2
        public final InterfaceC9262Ze2[] c() {
            return C3569Bk4.s();
        }
    };
    private final int a;
    private final EW4 b;
    private final EW4 c;
    private final EW4 d;
    private final EW4 e;
    private final ArrayDeque f;
    private final C7136Qk6 g;
    private final List h;
    private int i;
    private int j;
    private long k;
    private int l;
    private EW4 m;
    private int n;
    private int o;
    private int p;
    private int q;
    private InterfaceC10465bf2 r;
    private a[] s;
    private long[][] t;
    private int u;
    private long v;
    private int w;
    private MotionPhotoMetadata x;

    /* renamed from: ir.nasim.Bk4$a */
    private static final class a {
        public final C22835vt7 a;
        public final C5540Jt7 b;
        public final InterfaceC4589Ft7 c;
        public final C18019nw7 d;
        public int e;

        public a(C22835vt7 c22835vt7, C5540Jt7 c5540Jt7, InterfaceC4589Ft7 interfaceC4589Ft7) {
            this.a = c22835vt7;
            this.b = c5540Jt7;
            this.c = interfaceC4589Ft7;
            this.d = "audio/true-hd".equals(c22835vt7.f.l) ? new C18019nw7() : null;
        }
    }

    public C3569Bk4() {
        this(0);
    }

    private boolean A(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        ML.a aVar;
        if (this.l == 0) {
            if (!interfaceC9845af2.f(this.e.e(), 0, 8, true)) {
                w();
                return false;
            }
            this.l = 8;
            this.e.S(0);
            this.k = this.e.H();
            this.j = this.e.o();
        }
        long j = this.k;
        if (j == 1) {
            interfaceC9845af2.readFully(this.e.e(), 8, 8);
            this.l += 8;
            this.k = this.e.K();
        } else if (j == 0) {
            long length = interfaceC9845af2.getLength();
            if (length == -1 && (aVar = (ML.a) this.f.peek()) != null) {
                length = aVar.b;
            }
            if (length != -1) {
                this.k = (length - interfaceC9845af2.getPosition()) + this.l;
            }
        }
        if (this.k < this.l) {
            throw ParserException.d("Atom size less than header length (unsupported).");
        }
        if (E(this.j)) {
            long position = interfaceC9845af2.getPosition();
            long j2 = this.k;
            int i = this.l;
            long j3 = (position + j2) - i;
            if (j2 != i && this.j == 1835365473) {
                u(interfaceC9845af2);
            }
            this.f.push(new ML.a(this.j, j3));
            if (this.k == this.l) {
                v(j3);
            } else {
                n();
            }
        } else if (F(this.j)) {
            AbstractC20011rK.g(this.l == 8);
            AbstractC20011rK.g(this.k <= TTL.MAX_VALUE);
            EW4 ew4 = new EW4((int) this.k);
            System.arraycopy(this.e.e(), 0, ew4.e(), 0, 8);
            this.m = ew4;
            this.i = 1;
        } else {
            z(interfaceC9845af2.getPosition() - this.l);
            this.m = null;
            this.i = 1;
        }
        return true;
    }

    private boolean B(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        boolean z;
        long j = this.k - this.l;
        long position = interfaceC9845af2.getPosition() + j;
        EW4 ew4 = this.m;
        if (ew4 != null) {
            interfaceC9845af2.readFully(ew4.e(), this.l, (int) j);
            if (this.j == 1718909296) {
                this.w = x(ew4);
            } else if (!this.f.isEmpty()) {
                ((ML.a) this.f.peek()).e(new ML.b(this.j, ew4));
            }
        } else {
            if (j >= 262144) {
                c8292Vi5.a = interfaceC9845af2.getPosition() + j;
                z = true;
                v(position);
                return (z || this.i == 2) ? false : true;
            }
            interfaceC9845af2.k((int) j);
        }
        z = false;
        v(position);
        if (z) {
        }
    }

    private int C(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) throws ParserException {
        int i;
        C8292Vi5 c8292Vi52;
        long position = interfaceC9845af2.getPosition();
        if (this.n == -1) {
            int iQ = q(position);
            this.n = iQ;
            if (iQ == -1) {
                return -1;
            }
        }
        a aVar = this.s[this.n];
        InterfaceC4589Ft7 interfaceC4589Ft7 = aVar.c;
        int i2 = aVar.e;
        C5540Jt7 c5540Jt7 = aVar.b;
        long j = c5540Jt7.c[i2];
        int i3 = c5540Jt7.d[i2];
        C18019nw7 c18019nw7 = aVar.d;
        long j2 = (j - position) + this.o;
        if (j2 < 0) {
            i = 1;
            c8292Vi52 = c8292Vi5;
        } else {
            if (j2 < 262144) {
                if (aVar.a.g == 1) {
                    j2 += 8;
                    i3 -= 8;
                }
                interfaceC9845af2.k((int) j2);
                C22835vt7 c22835vt7 = aVar.a;
                if (c22835vt7.j == 0) {
                    if ("audio/ac4".equals(c22835vt7.f.l)) {
                        if (this.p == 0) {
                            AbstractC18068o2.a(i3, this.d);
                            interfaceC4589Ft7.d(this.d, 7);
                            this.p += 7;
                        }
                        i3 += 7;
                    } else if (c18019nw7 != null) {
                        c18019nw7.d(interfaceC9845af2);
                    }
                    while (true) {
                        int i4 = this.p;
                        if (i4 >= i3) {
                            break;
                        }
                        int iF = interfaceC4589Ft7.f(interfaceC9845af2, i3 - i4, false);
                        this.o += iF;
                        this.p += iF;
                        this.q -= iF;
                    }
                } else {
                    byte[] bArrE = this.c.e();
                    bArrE[0] = 0;
                    bArrE[1] = 0;
                    bArrE[2] = 0;
                    int i5 = aVar.a.j;
                    int i6 = 4 - i5;
                    while (this.p < i3) {
                        int i7 = this.q;
                        if (i7 == 0) {
                            interfaceC9845af2.readFully(bArrE, i6, i5);
                            this.o += i5;
                            this.c.S(0);
                            int iO = this.c.o();
                            if (iO < 0) {
                                throw ParserException.a("Invalid NAL length", null);
                            }
                            this.q = iO;
                            this.b.S(0);
                            interfaceC4589Ft7.d(this.b, 4);
                            this.p += 4;
                            i3 += i6;
                        } else {
                            int iF2 = interfaceC4589Ft7.f(interfaceC9845af2, i7, false);
                            this.o += iF2;
                            this.p += iF2;
                            this.q -= iF2;
                        }
                    }
                }
                int i8 = i3;
                C5540Jt7 c5540Jt72 = aVar.b;
                long j3 = c5540Jt72.f[i2];
                int i9 = c5540Jt72.g[i2];
                if (c18019nw7 != null) {
                    c18019nw7.c(interfaceC4589Ft7, j3, i9, i8, 0, null);
                    if (i2 + 1 == aVar.b.b) {
                        c18019nw7.a(interfaceC4589Ft7, null);
                    }
                } else {
                    interfaceC4589Ft7.b(j3, i9, i8, 0, null);
                }
                aVar.e++;
                this.n = -1;
                this.o = 0;
                this.p = 0;
                this.q = 0;
                return 0;
            }
            c8292Vi52 = c8292Vi5;
            i = 1;
        }
        c8292Vi52.a = j;
        return i;
    }

    private int D(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) throws ParserException {
        int iC = this.g.c(interfaceC9845af2, c8292Vi5, this.h);
        if (iC == 1 && c8292Vi5.a == 0) {
            n();
        }
        return iC;
    }

    private static boolean E(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1701082227 || i == 1835365473;
    }

    private static boolean F(int i) {
        return i == 1835296868 || i == 1836476516 || i == 1751411826 || i == 1937011556 || i == 1937011827 || i == 1937011571 || i == 1668576371 || i == 1701606260 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1953196132 || i == 1718909296 || i == 1969517665 || i == 1801812339 || i == 1768715124;
    }

    private void G(a aVar, long j) {
        C5540Jt7 c5540Jt7 = aVar.b;
        int iA = c5540Jt7.a(j);
        if (iA == -1) {
            iA = c5540Jt7.b(j);
        }
        aVar.e = iA;
    }

    private static int l(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static long[][] m(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            jArr[i] = new long[aVarArr[i].b.b];
            jArr2[i] = aVarArr[i].b.f[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < aVarArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < aVarArr.length; i4++) {
                if (!zArr[i4]) {
                    long j3 = jArr2[i4];
                    if (j3 <= j2) {
                        i3 = i4;
                        j2 = j3;
                    }
                }
            }
            int i5 = iArr[i3];
            long[] jArr3 = jArr[i3];
            jArr3[i5] = j;
            C5540Jt7 c5540Jt7 = aVarArr[i3].b;
            j += c5540Jt7.d[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr3.length) {
                jArr2[i3] = c5540Jt7.f[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    private void n() {
        this.i = 0;
        this.l = 0;
    }

    private static int p(C5540Jt7 c5540Jt7, long j) {
        int iA = c5540Jt7.a(j);
        return iA == -1 ? c5540Jt7.b(j) : iA;
    }

    private int q(long j) {
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.s;
            if (i3 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i3];
            int i4 = aVar.e;
            C5540Jt7 c5540Jt7 = aVar.b;
            if (i4 != c5540Jt7.b) {
                long j5 = c5540Jt7.c[i4];
                long j6 = ((long[][]) AbstractC9683aN7.j(this.t))[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= 262144;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    j4 = j7;
                    i2 = i3;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z = z3;
                    i = i3;
                    j2 = j6;
                }
            }
            i3++;
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + 10485760) ? i2 : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] s() {
        return new InterfaceC9262Ze2[]{new C3569Bk4()};
    }

    private static long t(C5540Jt7 c5540Jt7, long j, long j2) {
        int iP = p(c5540Jt7, j);
        return iP == -1 ? j2 : Math.min(c5540Jt7.c[iP], j2);
    }

    private void u(InterfaceC9845af2 interfaceC9845af2) {
        this.d.O(8);
        interfaceC9845af2.m(this.d.e(), 0, 8);
        NL.e(this.d);
        interfaceC9845af2.k(this.d.f());
        interfaceC9845af2.e();
    }

    private void v(long j) {
        while (!this.f.isEmpty() && ((ML.a) this.f.peek()).b == j) {
            ML.a aVar = (ML.a) this.f.pop();
            if (aVar.a == 1836019574) {
                y(aVar);
                this.f.clear();
                this.i = 2;
            } else if (!this.f.isEmpty()) {
                ((ML.a) this.f.peek()).d(aVar);
            }
        }
        if (this.i != 2) {
            n();
        }
    }

    private void w() {
        if (this.w != 2 || (this.a & 2) == 0) {
            return;
        }
        this.r.b(0, 4).c(new X.b().Z(this.x == null ? null : new Metadata(this.x)).G());
        this.r.s();
        this.r.o(new InterfaceC22148uk6.b(-9223372036854775807L));
    }

    private static int x(EW4 ew4) {
        ew4.S(8);
        int iL = l(ew4.o());
        if (iL != 0) {
            return iL;
        }
        ew4.T(4);
        while (ew4.a() > 0) {
            int iL2 = l(ew4.o());
            if (iL2 != 0) {
                return iL2;
            }
        }
        return 0;
    }

    private void y(ML.a aVar) {
        Metadata metadata;
        Metadata metadata2;
        List list;
        int i;
        ArrayList arrayList = new ArrayList();
        boolean z = this.w == 1;
        ED2 ed2 = new ED2();
        ML.b bVarG = aVar.g(1969517665);
        if (bVarG != null) {
            Pair pairB = NL.B(bVarG);
            Metadata metadata3 = (Metadata) pairB.first;
            Metadata metadata4 = (Metadata) pairB.second;
            if (metadata3 != null) {
                ed2.c(metadata3);
            }
            metadata = metadata4;
            metadata2 = metadata3;
        } else {
            metadata = null;
            metadata2 = null;
        }
        ML.a aVarF = aVar.f(1835365473);
        Metadata metadataN = aVarF != null ? NL.n(aVarF) : null;
        List listA = NL.A(aVar, ed2, -9223372036854775807L, null, (this.a & 1) != 0, z, new InterfaceC15205jB2() { // from class: ir.nasim.zk4
            @Override // ir.nasim.InterfaceC15205jB2
            public final Object apply(Object obj) {
                return C3569Bk4.r((C22835vt7) obj);
            }
        });
        int size = listA.size();
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        int i2 = 0;
        int size2 = -1;
        while (i2 < size) {
            C5540Jt7 c5540Jt7 = (C5540Jt7) listA.get(i2);
            if (c5540Jt7.b == 0) {
                list = listA;
                i = size;
            } else {
                C22835vt7 c22835vt7 = c5540Jt7.a;
                list = listA;
                i = size;
                long j3 = c22835vt7.e;
                if (j3 == j) {
                    j3 = c5540Jt7.h;
                }
                long jMax = Math.max(j2, j3);
                a aVar2 = new a(c22835vt7, c5540Jt7, this.r.b(i2, c22835vt7.b));
                int i3 = "audio/true-hd".equals(c22835vt7.f.l) ? c5540Jt7.e * 16 : c5540Jt7.e + 30;
                X.b bVarC = c22835vt7.f.c();
                bVarC.Y(i3);
                if (c22835vt7.b == 2 && j3 > 0) {
                    int i4 = c5540Jt7.b;
                    if (i4 > 1) {
                        bVarC.R(i4 / (j3 / 1000000.0f));
                    }
                }
                AbstractC3983De4.k(c22835vt7.b, ed2, bVarC);
                AbstractC3983De4.l(c22835vt7.b, metadata2, metadataN, bVarC, metadata, this.h.isEmpty() ? null : new Metadata(this.h));
                aVar2.c.c(bVarC.G());
                if (c22835vt7.b == 2 && size2 == -1) {
                    size2 = arrayList.size();
                }
                arrayList.add(aVar2);
                j2 = jMax;
            }
            i2++;
            listA = list;
            size = i;
            j = -9223372036854775807L;
        }
        this.u = size2;
        this.v = j2;
        a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
        this.s = aVarArr;
        this.t = m(aVarArr);
        this.r.s();
        this.r.o(this);
    }

    private void z(long j) {
        if (this.j == 1836086884) {
            int i = this.l;
            this.x = new MotionPhotoMetadata(0L, j, -9223372036854775807L, j + i, this.k - i);
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        this.f.clear();
        this.l = 0;
        this.n = -1;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        if (j == 0) {
            if (this.i != 3) {
                n();
                return;
            } else {
                this.g.g();
                this.h.clear();
                return;
            }
        }
        for (a aVar : this.s) {
            G(aVar, j2);
            C18019nw7 c18019nw7 = aVar.d;
            if (c18019nw7 != null) {
                c18019nw7.b();
            }
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.r = interfaceC10465bf2;
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public InterfaceC22148uk6.a c(long j) {
        return o(j, -1);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        return AbstractC17627nH6.d(interfaceC9845af2, (this.a & 2) != 0);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) {
        while (true) {
            int i = this.i;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return C(interfaceC9845af2, c8292Vi5);
                    }
                    if (i == 3) {
                        return D(interfaceC9845af2, c8292Vi5);
                    }
                    throw new IllegalStateException();
                }
                if (B(interfaceC9845af2, c8292Vi5)) {
                    return 1;
                }
            } else if (!A(interfaceC9845af2)) {
                return -1;
            }
        }
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public boolean g() {
        return true;
    }

    @Override // ir.nasim.InterfaceC22148uk6
    public long i() {
        return this.v;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.InterfaceC22148uk6.a o(long r17, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r19
            ir.nasim.Bk4$a[] r4 = r0.s
            int r5 = r4.length
            if (r5 != 0) goto L13
            ir.nasim.uk6$a r1 = new ir.nasim.uk6$a
            ir.nasim.wk6 r2 = ir.nasim.C23334wk6.c
            r1.<init>(r2)
            return r1
        L13:
            r5 = -1
            if (r3 == r5) goto L18
            r6 = r3
            goto L1a
        L18:
            int r6 = r0.u
        L1a:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = -1
            if (r6 == r5) goto L58
            r4 = r4[r6]
            ir.nasim.Jt7 r4 = r4.b
            int r6 = p(r4, r1)
            if (r6 != r5) goto L35
            ir.nasim.uk6$a r1 = new ir.nasim.uk6$a
            ir.nasim.wk6 r2 = ir.nasim.C23334wk6.c
            r1.<init>(r2)
            return r1
        L35:
            long[] r11 = r4.f
            r12 = r11[r6]
            long[] r11 = r4.c
            r14 = r11[r6]
            int r11 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r11 >= 0) goto L5e
            int r11 = r4.b
            int r11 = r11 + (-1)
            if (r6 >= r11) goto L5e
            int r1 = r4.b(r1)
            if (r1 == r5) goto L5e
            if (r1 == r6) goto L5e
            long[] r2 = r4.f
            r9 = r2[r1]
            long[] r2 = r4.c
            r1 = r2[r1]
            goto L60
        L58:
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = r1
        L5e:
            r1 = r9
            r9 = r7
        L60:
            if (r3 != r5) goto L80
            r3 = 0
        L63:
            ir.nasim.Bk4$a[] r4 = r0.s
            int r5 = r4.length
            if (r3 >= r5) goto L80
            int r5 = r0.u
            if (r3 == r5) goto L7d
            r4 = r4[r3]
            ir.nasim.Jt7 r4 = r4.b
            long r5 = t(r4, r12, r14)
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L7c
            long r1 = t(r4, r9, r1)
        L7c:
            r14 = r5
        L7d:
            int r3 = r3 + 1
            goto L63
        L80:
            ir.nasim.wk6 r3 = new ir.nasim.wk6
            r3.<init>(r12, r14)
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L8f
            ir.nasim.uk6$a r1 = new ir.nasim.uk6$a
            r1.<init>(r3)
            return r1
        L8f:
            ir.nasim.wk6 r4 = new ir.nasim.wk6
            r4.<init>(r9, r1)
            ir.nasim.uk6$a r1 = new ir.nasim.uk6$a
            r1.<init>(r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C3569Bk4.o(long, int):ir.nasim.uk6$a");
    }

    public C3569Bk4(int i) {
        this.a = i;
        this.i = (i & 4) != 0 ? 3 : 0;
        this.g = new C7136Qk6();
        this.h = new ArrayList();
        this.e = new EW4(16);
        this.f = new ArrayDeque();
        this.b = new EW4(AbstractC6193Mo4.a);
        this.c = new EW4(4);
        this.d = new EW4();
        this.n = -1;
        this.r = InterfaceC10465bf2.j0;
        this.s = new a[0];
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C22835vt7 r(C22835vt7 c22835vt7) {
        return c22835vt7;
    }
}
