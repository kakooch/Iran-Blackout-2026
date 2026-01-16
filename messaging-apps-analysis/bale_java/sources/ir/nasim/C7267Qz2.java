package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.util.Pair;
import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.ML;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.xbill.DNS.TTL;

/* renamed from: ir.nasim.Qz2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C7267Qz2 implements InterfaceC9262Ze2 {
    public static final InterfaceC12462ef2 I = new InterfaceC12462ef2() { // from class: ir.nasim.Oz2
        @Override // ir.nasim.InterfaceC12462ef2
        public final InterfaceC9262Ze2[] c() {
            return C7267Qz2.l();
        }
    };
    private static final byte[] J = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final com.google.android.exoplayer2.X K = new X.b().g0("application/x-emsg").G();
    private int A;
    private int B;
    private int C;
    private boolean D;
    private InterfaceC10465bf2 E;
    private InterfaceC4589Ft7[] F;
    private InterfaceC4589Ft7[] G;
    private boolean H;
    private final int a;
    private final C22835vt7 b;
    private final List c;
    private final SparseArray d;
    private final EW4 e;
    private final EW4 f;
    private final EW4 g;
    private final byte[] h;
    private final EW4 i;
    private final C5045Hq7 j;
    private final C11810db2 k;
    private final EW4 l;
    private final ArrayDeque m;
    private final ArrayDeque n;
    private final InterfaceC4589Ft7 o;
    private int p;
    private int q;
    private long r;
    private int s;
    private EW4 t;
    private long u;
    private int v;
    private long w;
    private long x;
    private long y;
    private b z;

    /* renamed from: ir.nasim.Qz2$a */
    private static final class a {
        public final long a;
        public final boolean b;
        public final int c;

        public a(long j, boolean z, int i) {
            this.a = j;
            this.b = z;
            this.c = i;
        }
    }

    /* renamed from: ir.nasim.Qz2$b */
    private static final class b {
        public final InterfaceC4589Ft7 a;
        public C5540Jt7 d;
        public PE1 e;
        public int f;
        public int g;
        public int h;
        public int i;
        private boolean l;
        public final C3414At7 b = new C3414At7();
        public final EW4 c = new EW4();
        private final EW4 j = new EW4(1);
        private final EW4 k = new EW4();

        public b(InterfaceC4589Ft7 interfaceC4589Ft7, C5540Jt7 c5540Jt7, PE1 pe1) {
            this.a = interfaceC4589Ft7;
            this.d = c5540Jt7;
            this.e = pe1;
            j(c5540Jt7, pe1);
        }

        public int c() {
            int i = !this.l ? this.d.g[this.f] : this.b.k[this.f] ? 1 : 0;
            return g() != null ? i | 1073741824 : i;
        }

        public long d() {
            return !this.l ? this.d.c[this.f] : this.b.g[this.h];
        }

        public long e() {
            return !this.l ? this.d.f[this.f] : this.b.c(this.f);
        }

        public int f() {
            return !this.l ? this.d.d[this.f] : this.b.i[this.f];
        }

        public C24605yt7 g() {
            if (!this.l) {
                return null;
            }
            int i = ((PE1) AbstractC9683aN7.j(this.b.a)).a;
            C24605yt7 c24605yt7A = this.b.n;
            if (c24605yt7A == null) {
                c24605yt7A = this.d.a.a(i);
            }
            if (c24605yt7A == null || !c24605yt7A.a) {
                return null;
            }
            return c24605yt7A;
        }

        public boolean h() {
            this.f++;
            if (!this.l) {
                return false;
            }
            int i = this.g + 1;
            this.g = i;
            int[] iArr = this.b.h;
            int i2 = this.h;
            if (i != iArr[i2]) {
                return true;
            }
            this.h = i2 + 1;
            this.g = 0;
            return false;
        }

        public int i(int i, int i2) {
            EW4 ew4;
            C24605yt7 c24605yt7G = g();
            if (c24605yt7G == null) {
                return 0;
            }
            int length = c24605yt7G.d;
            if (length != 0) {
                ew4 = this.b.o;
            } else {
                byte[] bArr = (byte[]) AbstractC9683aN7.j(c24605yt7G.e);
                this.k.Q(bArr, bArr.length);
                EW4 ew42 = this.k;
                length = bArr.length;
                ew4 = ew42;
            }
            boolean zG = this.b.g(this.f);
            boolean z = zG || i2 != 0;
            this.j.e()[0] = (byte) ((z ? 128 : 0) | length);
            this.j.S(0);
            this.a.a(this.j, 1, 1);
            this.a.a(ew4, length, 1);
            if (!z) {
                return length + 1;
            }
            if (!zG) {
                this.c.O(8);
                byte[] bArrE = this.c.e();
                bArrE[0] = 0;
                bArrE[1] = 1;
                bArrE[2] = (byte) ((i2 >> 8) & 255);
                bArrE[3] = (byte) (i2 & 255);
                bArrE[4] = (byte) ((i >> 24) & 255);
                bArrE[5] = (byte) ((i >> 16) & 255);
                bArrE[6] = (byte) ((i >> 8) & 255);
                bArrE[7] = (byte) (i & 255);
                this.a.a(this.c, 8, 1);
                return length + 9;
            }
            EW4 ew43 = this.b.o;
            int iL = ew43.L();
            ew43.T(-2);
            int i3 = (iL * 6) + 2;
            if (i2 != 0) {
                this.c.O(i3);
                byte[] bArrE2 = this.c.e();
                ew43.j(bArrE2, 0, i3);
                int i4 = (((bArrE2[2] & 255) << 8) | (bArrE2[3] & 255)) + i2;
                bArrE2[2] = (byte) ((i4 >> 8) & 255);
                bArrE2[3] = (byte) (i4 & 255);
                ew43 = this.c;
            }
            this.a.a(ew43, i3, 1);
            return length + 1 + i3;
        }

        public void j(C5540Jt7 c5540Jt7, PE1 pe1) {
            this.d = c5540Jt7;
            this.e = pe1;
            this.a.c(c5540Jt7.a.f);
            k();
        }

        public void k() {
            this.b.f();
            this.f = 0;
            this.h = 0;
            this.g = 0;
            this.i = 0;
            this.l = false;
        }

        public void l(long j) {
            int i = this.f;
            while (true) {
                C3414At7 c3414At7 = this.b;
                if (i >= c3414At7.f || c3414At7.c(i) > j) {
                    return;
                }
                if (this.b.k[i]) {
                    this.i = i;
                }
                i++;
            }
        }

        public void m() {
            C24605yt7 c24605yt7G = g();
            if (c24605yt7G == null) {
                return;
            }
            EW4 ew4 = this.b.o;
            int i = c24605yt7G.d;
            if (i != 0) {
                ew4.T(i);
            }
            if (this.b.g(this.f)) {
                ew4.T(ew4.L() * 6);
            }
        }

        public void n(DrmInitData drmInitData) {
            C24605yt7 c24605yt7A = this.d.a.a(((PE1) AbstractC9683aN7.j(this.b.a)).a);
            this.a.c(this.d.a.f.c().O(drmInitData.c(c24605yt7A != null ? c24605yt7A.b : null)).G());
        }
    }

    public C7267Qz2() {
        this(0);
    }

    private static Pair A(EW4 ew4, long j) throws ParserException {
        long jK;
        long jK2;
        ew4.S(8);
        int iC = ML.c(ew4.o());
        ew4.T(4);
        long jH = ew4.H();
        if (iC == 0) {
            jK = ew4.H();
            jK2 = ew4.H();
        } else {
            jK = ew4.K();
            jK2 = ew4.K();
        }
        long j2 = jK;
        long j3 = j + jK2;
        long jN0 = AbstractC9683aN7.N0(j2, 1000000L, jH);
        ew4.T(2);
        int iL = ew4.L();
        int[] iArr = new int[iL];
        long[] jArr = new long[iL];
        long[] jArr2 = new long[iL];
        long[] jArr3 = new long[iL];
        long j4 = jN0;
        int i = 0;
        long j5 = j2;
        while (i < iL) {
            int iO = ew4.o();
            if ((iO & RecyclerView.UNDEFINED_DURATION) != 0) {
                throw ParserException.a("Unhandled indirect reference", null);
            }
            long jH2 = ew4.H();
            iArr[i] = iO & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j4;
            long j6 = j5 + jH2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i2 = iL;
            long jN02 = AbstractC9683aN7.N0(j6, 1000000L, jH);
            jArr4[i] = jN02 - jArr5[i];
            ew4.T(4);
            j3 += r1[i];
            i++;
            iArr = iArr;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            iL = i2;
            j5 = j6;
            j4 = jN02;
        }
        return Pair.create(Long.valueOf(jN0), new LT0(iArr, jArr, jArr2, jArr3));
    }

    private static long B(EW4 ew4) {
        ew4.S(8);
        return ML.c(ew4.o()) == 1 ? ew4.K() : ew4.H();
    }

    private static b C(EW4 ew4, SparseArray sparseArray, boolean z) {
        ew4.S(8);
        int iB = ML.b(ew4.o());
        b bVar = (b) (z ? sparseArray.valueAt(0) : sparseArray.get(ew4.o()));
        if (bVar == null) {
            return null;
        }
        if ((iB & 1) != 0) {
            long jK = ew4.K();
            C3414At7 c3414At7 = bVar.b;
            c3414At7.c = jK;
            c3414At7.d = jK;
        }
        PE1 pe1 = bVar.e;
        bVar.b.a = new PE1((iB & 2) != 0 ? ew4.o() - 1 : pe1.a, (iB & 8) != 0 ? ew4.o() : pe1.b, (iB & 16) != 0 ? ew4.o() : pe1.c, (iB & 32) != 0 ? ew4.o() : pe1.d);
        return bVar;
    }

    private static void D(ML.a aVar, SparseArray sparseArray, boolean z, int i, byte[] bArr) throws ParserException {
        b bVarC = C(((ML.b) AbstractC20011rK.e(aVar.g(1952868452))).b, sparseArray, z);
        if (bVarC == null) {
            return;
        }
        C3414At7 c3414At7 = bVarC.b;
        long j = c3414At7.q;
        boolean z2 = c3414At7.r;
        bVarC.k();
        bVarC.l = true;
        ML.b bVarG = aVar.g(1952867444);
        if (bVarG == null || (i & 2) != 0) {
            c3414At7.q = j;
            c3414At7.r = z2;
        } else {
            c3414At7.q = B(bVarG.b);
            c3414At7.r = true;
        }
        G(aVar, bVarC, i);
        C24605yt7 c24605yt7A = bVarC.d.a.a(((PE1) AbstractC20011rK.e(c3414At7.a)).a);
        ML.b bVarG2 = aVar.g(1935763834);
        if (bVarG2 != null) {
            w((C24605yt7) AbstractC20011rK.e(c24605yt7A), bVarG2.b, c3414At7);
        }
        ML.b bVarG3 = aVar.g(1935763823);
        if (bVarG3 != null) {
            v(bVarG3.b, c3414At7);
        }
        ML.b bVarG4 = aVar.g(1936027235);
        if (bVarG4 != null) {
            z(bVarG4.b, c3414At7);
        }
        x(aVar, c24605yt7A != null ? c24605yt7A.b : null, c3414At7);
        int size = aVar.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            ML.b bVar = (ML.b) aVar.c.get(i2);
            if (bVar.a == 1970628964) {
                H(bVar.b, c3414At7, bArr);
            }
        }
    }

    private static Pair E(EW4 ew4) {
        ew4.S(12);
        return Pair.create(Integer.valueOf(ew4.o()), new PE1(ew4.o() - 1, ew4.o(), ew4.o(), ew4.o()));
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int F(ir.nasim.C7267Qz2.b r34, int r35, int r36, ir.nasim.EW4 r37, int r38) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C7267Qz2.F(ir.nasim.Qz2$b, int, int, ir.nasim.EW4, int):int");
    }

    private static void G(ML.a aVar, b bVar, int i) throws ParserException {
        List list = aVar.c;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            ML.b bVar2 = (ML.b) list.get(i4);
            if (bVar2.a == 1953658222) {
                EW4 ew4 = bVar2.b;
                ew4.S(12);
                int iJ = ew4.J();
                if (iJ > 0) {
                    i3 += iJ;
                    i2++;
                }
            }
        }
        bVar.h = 0;
        bVar.g = 0;
        bVar.f = 0;
        bVar.b.e(i2, i3);
        int i5 = 0;
        int iF = 0;
        for (int i6 = 0; i6 < size; i6++) {
            ML.b bVar3 = (ML.b) list.get(i6);
            if (bVar3.a == 1953658222) {
                iF = F(bVar, i5, i, bVar3.b, iF);
                i5++;
            }
        }
    }

    private static void H(EW4 ew4, C3414At7 c3414At7, byte[] bArr) throws ParserException {
        ew4.S(8);
        ew4.j(bArr, 0, 16);
        if (Arrays.equals(bArr, J)) {
            y(ew4, 16, c3414At7);
        }
    }

    private void I(long j) throws ParserException {
        while (!this.m.isEmpty() && ((ML.a) this.m.peek()).b == j) {
            n((ML.a) this.m.pop());
        }
        g();
    }

    private boolean J(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        if (this.s == 0) {
            if (!interfaceC9845af2.f(this.l.e(), 0, 8, true)) {
                return false;
            }
            this.s = 8;
            this.l.S(0);
            this.r = this.l.H();
            this.q = this.l.o();
        }
        long j = this.r;
        if (j == 1) {
            interfaceC9845af2.readFully(this.l.e(), 8, 8);
            this.s += 8;
            this.r = this.l.K();
        } else if (j == 0) {
            long length = interfaceC9845af2.getLength();
            if (length == -1 && !this.m.isEmpty()) {
                length = ((ML.a) this.m.peek()).b;
            }
            if (length != -1) {
                this.r = (length - interfaceC9845af2.getPosition()) + this.s;
            }
        }
        if (this.r < this.s) {
            throw ParserException.d("Atom size less than header length (unsupported).");
        }
        long position = interfaceC9845af2.getPosition() - this.s;
        int i = this.q;
        if ((i == 1836019558 || i == 1835295092) && !this.H) {
            this.E.o(new InterfaceC22148uk6.b(this.x, position));
            this.H = true;
        }
        if (this.q == 1836019558) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                C3414At7 c3414At7 = ((b) this.d.valueAt(i2)).b;
                c3414At7.b = position;
                c3414At7.d = position;
                c3414At7.c = position;
            }
        }
        int i3 = this.q;
        if (i3 == 1835295092) {
            this.z = null;
            this.u = position + this.r;
            this.p = 2;
            return true;
        }
        if (N(i3)) {
            long position2 = (interfaceC9845af2.getPosition() + this.r) - 8;
            this.m.push(new ML.a(this.q, position2));
            if (this.r == this.s) {
                I(position2);
            } else {
                g();
            }
        } else if (O(this.q)) {
            if (this.s != 8) {
                throw ParserException.d("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.r > TTL.MAX_VALUE) {
                throw ParserException.d("Leaf atom with length > 2147483647 (unsupported).");
            }
            EW4 ew4 = new EW4((int) this.r);
            System.arraycopy(this.l.e(), 0, ew4.e(), 0, 8);
            this.t = ew4;
            this.p = 1;
        } else {
            if (this.r > TTL.MAX_VALUE) {
                throw ParserException.d("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.t = null;
            this.p = 1;
        }
        return true;
    }

    private void K(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        int i = ((int) this.r) - this.s;
        EW4 ew4 = this.t;
        if (ew4 != null) {
            interfaceC9845af2.readFully(ew4.e(), 8, i);
            p(new ML.b(this.q, ew4), interfaceC9845af2.getPosition());
        } else {
            interfaceC9845af2.k(i);
        }
        I(interfaceC9845af2.getPosition());
    }

    private void L(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        int size = this.d.size();
        long j = Long.MAX_VALUE;
        b bVar = null;
        for (int i = 0; i < size; i++) {
            C3414At7 c3414At7 = ((b) this.d.valueAt(i)).b;
            if (c3414At7.p) {
                long j2 = c3414At7.d;
                if (j2 < j) {
                    bVar = (b) this.d.valueAt(i);
                    j = j2;
                }
            }
        }
        if (bVar == null) {
            this.p = 3;
            return;
        }
        int position = (int) (j - interfaceC9845af2.getPosition());
        if (position < 0) {
            throw ParserException.a("Offset to encryption data was negative.", null);
        }
        interfaceC9845af2.k(position);
        bVar.b.a(interfaceC9845af2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean M(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        int iF;
        b bVarJ = this.z;
        Throwable th = null;
        if (bVarJ == null) {
            bVarJ = j(this.d);
            if (bVarJ == null) {
                int position = (int) (this.u - interfaceC9845af2.getPosition());
                if (position < 0) {
                    throw ParserException.a("Offset to end of mdat was negative.", null);
                }
                interfaceC9845af2.k(position);
                g();
                return false;
            }
            int iD = (int) (bVarJ.d() - interfaceC9845af2.getPosition());
            if (iD < 0) {
                AbstractC18815pI3.k("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                iD = 0;
            }
            interfaceC9845af2.k(iD);
            this.z = bVarJ;
        }
        int i = 4;
        int i2 = 1;
        if (this.p == 3) {
            int iF2 = bVarJ.f();
            this.A = iF2;
            if (bVarJ.f < bVarJ.i) {
                interfaceC9845af2.k(iF2);
                bVarJ.m();
                if (!bVarJ.h()) {
                    this.z = null;
                }
                this.p = 3;
                return true;
            }
            if (bVarJ.d.a.g == 1) {
                this.A = iF2 - 8;
                interfaceC9845af2.k(8);
            }
            if ("audio/ac4".equals(bVarJ.d.a.f.l)) {
                this.B = bVarJ.i(this.A, 7);
                AbstractC18068o2.a(this.A, this.i);
                bVarJ.a.d(this.i, 7);
                this.B += 7;
            } else {
                this.B = bVarJ.i(this.A, 0);
            }
            this.A += this.B;
            this.p = 4;
            this.C = 0;
        }
        C22835vt7 c22835vt7 = bVarJ.d.a;
        InterfaceC4589Ft7 interfaceC4589Ft7 = bVarJ.a;
        long jE = bVarJ.e();
        C5045Hq7 c5045Hq7 = this.j;
        if (c5045Hq7 != null) {
            jE = c5045Hq7.a(jE);
        }
        long j = jE;
        if (c22835vt7.j == 0) {
            while (true) {
                int i3 = this.B;
                int i4 = this.A;
                if (i3 >= i4) {
                    break;
                }
                this.B += interfaceC4589Ft7.f(interfaceC9845af2, i4 - i3, false);
            }
        } else {
            byte[] bArrE = this.f.e();
            bArrE[0] = 0;
            bArrE[1] = 0;
            bArrE[2] = 0;
            int i5 = c22835vt7.j;
            int i6 = i5 + 1;
            int i7 = 4 - i5;
            while (this.B < this.A) {
                int i8 = this.C;
                if (i8 == 0) {
                    interfaceC9845af2.readFully(bArrE, i7, i6);
                    this.f.S(0);
                    int iO = this.f.o();
                    if (iO < i2) {
                        throw ParserException.a("Invalid NAL length", th);
                    }
                    this.C = iO - 1;
                    this.e.S(0);
                    interfaceC4589Ft7.d(this.e, i);
                    interfaceC4589Ft7.d(this.f, i2);
                    this.D = (this.G.length <= 0 || !AbstractC6193Mo4.g(c22835vt7.f.l, bArrE[i])) ? 0 : i2;
                    this.B += 5;
                    this.A += i7;
                } else {
                    if (this.D) {
                        this.g.O(i8);
                        interfaceC9845af2.readFully(this.g.e(), 0, this.C);
                        interfaceC4589Ft7.d(this.g, this.C);
                        iF = this.C;
                        int iQ = AbstractC6193Mo4.q(this.g.e(), this.g.g());
                        this.g.S("video/hevc".equals(c22835vt7.f.l) ? 1 : 0);
                        this.g.R(iQ);
                        KH0.a(j, this.g, this.G);
                    } else {
                        iF = interfaceC4589Ft7.f(interfaceC9845af2, i8, false);
                    }
                    this.B += iF;
                    this.C -= iF;
                    th = null;
                    i = 4;
                    i2 = 1;
                }
            }
        }
        int iC = bVarJ.c();
        C24605yt7 c24605yt7G = bVarJ.g();
        interfaceC4589Ft7.b(j, iC, this.A, 0, c24605yt7G != null ? c24605yt7G.c : null);
        s(j);
        if (!bVarJ.h()) {
            this.z = null;
        }
        this.p = 3;
        return true;
    }

    private static boolean N(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    private static boolean O(int i) {
        return i == 1751411826 || i == 1835296868 || i == 1836476516 || i == 1936286840 || i == 1937011556 || i == 1937011827 || i == 1668576371 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1937011571 || i == 1952867444 || i == 1952868452 || i == 1953196132 || i == 1953654136 || i == 1953658222 || i == 1886614376 || i == 1935763834 || i == 1935763823 || i == 1936027235 || i == 1970628964 || i == 1935828848 || i == 1936158820 || i == 1701606260 || i == 1835362404 || i == 1701671783;
    }

    private static int f(int i) throws ParserException {
        if (i >= 0) {
            return i;
        }
        throw ParserException.a("Unexpected negative value: " + i, null);
    }

    private void g() {
        this.p = 0;
        this.s = 0;
    }

    private PE1 h(SparseArray sparseArray, int i) {
        return sparseArray.size() == 1 ? (PE1) sparseArray.valueAt(0) : (PE1) AbstractC20011rK.e((PE1) sparseArray.get(i));
    }

    private static DrmInitData i(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ML.b bVar = (ML.b) list.get(i);
            if (bVar.a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrE = bVar.b.e();
                UUID uuidF = AbstractC15671jy5.f(bArrE);
                if (uuidF == null) {
                    AbstractC18815pI3.k("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidF, "video/mp4", bArrE));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static b j(SparseArray sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            b bVar2 = (b) sparseArray.valueAt(i);
            if ((bVar2.l || bVar2.f != bVar2.d.b) && (!bVar2.l || bVar2.h != bVar2.b.e)) {
                long jD = bVar2.d();
                if (jD < j) {
                    bVar = bVar2;
                    j = jD;
                }
            }
        }
        return bVar;
    }

    private void k() {
        int i;
        InterfaceC4589Ft7[] interfaceC4589Ft7Arr = new InterfaceC4589Ft7[2];
        this.F = interfaceC4589Ft7Arr;
        InterfaceC4589Ft7 interfaceC4589Ft7 = this.o;
        int i2 = 0;
        if (interfaceC4589Ft7 != null) {
            interfaceC4589Ft7Arr[0] = interfaceC4589Ft7;
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 100;
        if ((this.a & 4) != 0) {
            interfaceC4589Ft7Arr[i] = this.E.b(100, 5);
            i3 = 101;
            i++;
        }
        InterfaceC4589Ft7[] interfaceC4589Ft7Arr2 = (InterfaceC4589Ft7[]) AbstractC9683aN7.G0(this.F, i);
        this.F = interfaceC4589Ft7Arr2;
        for (InterfaceC4589Ft7 interfaceC4589Ft72 : interfaceC4589Ft7Arr2) {
            interfaceC4589Ft72.c(K);
        }
        this.G = new InterfaceC4589Ft7[this.c.size()];
        while (i2 < this.G.length) {
            InterfaceC4589Ft7 interfaceC4589Ft7B = this.E.b(i3, 3);
            interfaceC4589Ft7B.c((com.google.android.exoplayer2.X) this.c.get(i2));
            this.G[i2] = interfaceC4589Ft7B;
            i2++;
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] l() {
        return new InterfaceC9262Ze2[]{new C7267Qz2()};
    }

    private void n(ML.a aVar) throws ParserException {
        int i = aVar.a;
        if (i == 1836019574) {
            r(aVar);
        } else if (i == 1836019558) {
            q(aVar);
        } else {
            if (this.m.isEmpty()) {
                return;
            }
            ((ML.a) this.m.peek()).d(aVar);
        }
    }

    private void o(EW4 ew4) {
        long jN0;
        String str;
        long jN02;
        String str2;
        long jH;
        long jA;
        if (this.F.length == 0) {
            return;
        }
        ew4.S(8);
        int iC = ML.c(ew4.o());
        if (iC == 0) {
            String str3 = (String) AbstractC20011rK.e(ew4.z());
            String str4 = (String) AbstractC20011rK.e(ew4.z());
            long jH2 = ew4.H();
            jN0 = AbstractC9683aN7.N0(ew4.H(), 1000000L, jH2);
            long j = this.y;
            long j2 = j != -9223372036854775807L ? j + jN0 : -9223372036854775807L;
            str = str3;
            jN02 = AbstractC9683aN7.N0(ew4.H(), 1000L, jH2);
            str2 = str4;
            jH = ew4.H();
            jA = j2;
        } else {
            if (iC != 1) {
                AbstractC18815pI3.k("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + iC);
                return;
            }
            long jH3 = ew4.H();
            jA = AbstractC9683aN7.N0(ew4.K(), 1000000L, jH3);
            long jN03 = AbstractC9683aN7.N0(ew4.H(), 1000L, jH3);
            long jH4 = ew4.H();
            str = (String) AbstractC20011rK.e(ew4.z());
            jN02 = jN03;
            jH = jH4;
            str2 = (String) AbstractC20011rK.e(ew4.z());
            jN0 = -9223372036854775807L;
        }
        byte[] bArr = new byte[ew4.a()];
        ew4.j(bArr, 0, ew4.a());
        EW4 ew42 = new EW4(this.k.a(new EventMessage(str, str2, jN02, jH, bArr)));
        int iA = ew42.a();
        for (InterfaceC4589Ft7 interfaceC4589Ft7 : this.F) {
            ew42.S(0);
            interfaceC4589Ft7.d(ew42, iA);
        }
        if (jA == -9223372036854775807L) {
            this.n.addLast(new a(jN0, true, iA));
            this.v += iA;
            return;
        }
        if (!this.n.isEmpty()) {
            this.n.addLast(new a(jA, false, iA));
            this.v += iA;
            return;
        }
        C5045Hq7 c5045Hq7 = this.j;
        if (c5045Hq7 != null) {
            jA = c5045Hq7.a(jA);
        }
        for (InterfaceC4589Ft7 interfaceC4589Ft72 : this.F) {
            interfaceC4589Ft72.b(jA, 1, iA, 0, null);
        }
    }

    private void p(ML.b bVar, long j) throws ParserException {
        if (!this.m.isEmpty()) {
            ((ML.a) this.m.peek()).e(bVar);
            return;
        }
        int i = bVar.a;
        if (i != 1936286840) {
            if (i == 1701671783) {
                o(bVar.b);
            }
        } else {
            Pair pairA = A(bVar.b, j);
            this.y = ((Long) pairA.first).longValue();
            this.E.o((InterfaceC22148uk6) pairA.second);
            this.H = true;
        }
    }

    private void q(ML.a aVar) throws ParserException {
        u(aVar, this.d, this.b != null, this.a, this.h);
        DrmInitData drmInitDataI = i(aVar.c);
        if (drmInitDataI != null) {
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                ((b) this.d.valueAt(i)).n(drmInitDataI);
            }
        }
        if (this.w != -9223372036854775807L) {
            int size2 = this.d.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((b) this.d.valueAt(i2)).l(this.w);
            }
            this.w = -9223372036854775807L;
        }
    }

    private void r(ML.a aVar) {
        int i = 0;
        AbstractC20011rK.h(this.b == null, "Unexpected moov box.");
        DrmInitData drmInitDataI = i(aVar.c);
        ML.a aVar2 = (ML.a) AbstractC20011rK.e(aVar.f(1836475768));
        SparseArray sparseArray = new SparseArray();
        int size = aVar2.c.size();
        long jT = -9223372036854775807L;
        for (int i2 = 0; i2 < size; i2++) {
            ML.b bVar = (ML.b) aVar2.c.get(i2);
            int i3 = bVar.a;
            if (i3 == 1953654136) {
                Pair pairE = E(bVar.b);
                sparseArray.put(((Integer) pairE.first).intValue(), (PE1) pairE.second);
            } else if (i3 == 1835362404) {
                jT = t(bVar.b);
            }
        }
        List listA = NL.A(aVar, new ED2(), jT, drmInitDataI, (this.a & 16) != 0, false, new InterfaceC15205jB2() { // from class: ir.nasim.Pz2
            @Override // ir.nasim.InterfaceC15205jB2
            public final Object apply(Object obj) {
                return this.a.m((C22835vt7) obj);
            }
        });
        int size2 = listA.size();
        if (this.d.size() != 0) {
            AbstractC20011rK.g(this.d.size() == size2);
            while (i < size2) {
                C5540Jt7 c5540Jt7 = (C5540Jt7) listA.get(i);
                C22835vt7 c22835vt7 = c5540Jt7.a;
                ((b) this.d.get(c22835vt7.a)).j(c5540Jt7, h(sparseArray, c22835vt7.a));
                i++;
            }
            return;
        }
        while (i < size2) {
            C5540Jt7 c5540Jt72 = (C5540Jt7) listA.get(i);
            C22835vt7 c22835vt72 = c5540Jt72.a;
            this.d.put(c22835vt72.a, new b(this.E.b(i, c22835vt72.b), c5540Jt72, h(sparseArray, c22835vt72.a)));
            this.x = Math.max(this.x, c22835vt72.e);
            i++;
        }
        this.E.s();
    }

    private void s(long j) {
        while (!this.n.isEmpty()) {
            a aVar = (a) this.n.removeFirst();
            this.v -= aVar.c;
            long jA = aVar.a;
            if (aVar.b) {
                jA += j;
            }
            C5045Hq7 c5045Hq7 = this.j;
            if (c5045Hq7 != null) {
                jA = c5045Hq7.a(jA);
            }
            for (InterfaceC4589Ft7 interfaceC4589Ft7 : this.F) {
                interfaceC4589Ft7.b(jA, 1, aVar.c, this.v, null);
            }
        }
    }

    private static long t(EW4 ew4) {
        ew4.S(8);
        return ML.c(ew4.o()) == 0 ? ew4.H() : ew4.K();
    }

    private static void u(ML.a aVar, SparseArray sparseArray, boolean z, int i, byte[] bArr) throws ParserException {
        int size = aVar.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            ML.a aVar2 = (ML.a) aVar.d.get(i2);
            if (aVar2.a == 1953653094) {
                D(aVar2, sparseArray, z, i, bArr);
            }
        }
    }

    private static void v(EW4 ew4, C3414At7 c3414At7) throws ParserException {
        ew4.S(8);
        int iO = ew4.o();
        if ((ML.b(iO) & 1) == 1) {
            ew4.T(8);
        }
        int iJ = ew4.J();
        if (iJ == 1) {
            c3414At7.d += ML.c(iO) == 0 ? ew4.H() : ew4.K();
        } else {
            throw ParserException.a("Unexpected saio entry count: " + iJ, null);
        }
    }

    private static void w(C24605yt7 c24605yt7, EW4 ew4, C3414At7 c3414At7) throws ParserException {
        int i;
        int i2 = c24605yt7.d;
        ew4.S(8);
        if ((ML.b(ew4.o()) & 1) == 1) {
            ew4.T(8);
        }
        int iF = ew4.F();
        int iJ = ew4.J();
        if (iJ > c3414At7.f) {
            throw ParserException.a("Saiz sample count " + iJ + " is greater than fragment sample count" + c3414At7.f, null);
        }
        if (iF == 0) {
            boolean[] zArr = c3414At7.m;
            i = 0;
            for (int i3 = 0; i3 < iJ; i3++) {
                int iF2 = ew4.F();
                i += iF2;
                zArr[i3] = iF2 > i2;
            }
        } else {
            i = iF * iJ;
            Arrays.fill(c3414At7.m, 0, iJ, iF > i2);
        }
        Arrays.fill(c3414At7.m, iJ, c3414At7.f, false);
        if (i > 0) {
            c3414At7.d(i);
        }
    }

    private static void x(ML.a aVar, String str, C3414At7 c3414At7) throws ParserException {
        byte[] bArr = null;
        EW4 ew4 = null;
        EW4 ew42 = null;
        for (int i = 0; i < aVar.c.size(); i++) {
            ML.b bVar = (ML.b) aVar.c.get(i);
            EW4 ew43 = bVar.b;
            int i2 = bVar.a;
            if (i2 == 1935828848) {
                ew43.S(12);
                if (ew43.o() == 1936025959) {
                    ew4 = ew43;
                }
            } else if (i2 == 1936158820) {
                ew43.S(12);
                if (ew43.o() == 1936025959) {
                    ew42 = ew43;
                }
            }
        }
        if (ew4 == null || ew42 == null) {
            return;
        }
        ew4.S(8);
        int iC = ML.c(ew4.o());
        ew4.T(4);
        if (iC == 1) {
            ew4.T(4);
        }
        if (ew4.o() != 1) {
            throw ParserException.d("Entry count in sbgp != 1 (unsupported).");
        }
        ew42.S(8);
        int iC2 = ML.c(ew42.o());
        ew42.T(4);
        if (iC2 == 1) {
            if (ew42.H() == 0) {
                throw ParserException.d("Variable length description in sgpd found (unsupported)");
            }
        } else if (iC2 >= 2) {
            ew42.T(4);
        }
        if (ew42.H() != 1) {
            throw ParserException.d("Entry count in sgpd != 1 (unsupported).");
        }
        ew42.T(1);
        int iF = ew42.F();
        int i3 = (iF & SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER) >> 4;
        int i4 = iF & 15;
        boolean z = ew42.F() == 1;
        if (z) {
            int iF2 = ew42.F();
            byte[] bArr2 = new byte[16];
            ew42.j(bArr2, 0, 16);
            if (iF2 == 0) {
                int iF3 = ew42.F();
                bArr = new byte[iF3];
                ew42.j(bArr, 0, iF3);
            }
            c3414At7.l = true;
            c3414At7.n = new C24605yt7(z, str, iF2, bArr2, i3, i4, bArr);
        }
    }

    private static void y(EW4 ew4, int i, C3414At7 c3414At7) throws ParserException {
        ew4.S(i + 8);
        int iB = ML.b(ew4.o());
        if ((iB & 1) != 0) {
            throw ParserException.d("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iB & 2) != 0;
        int iJ = ew4.J();
        if (iJ == 0) {
            Arrays.fill(c3414At7.m, 0, c3414At7.f, false);
            return;
        }
        if (iJ == c3414At7.f) {
            Arrays.fill(c3414At7.m, 0, iJ, z);
            c3414At7.d(ew4.a());
            c3414At7.b(ew4);
        } else {
            throw ParserException.a("Senc sample count " + iJ + " is different from fragment sample count" + c3414At7.f, null);
        }
    }

    private static void z(EW4 ew4, C3414At7 c3414At7) throws ParserException {
        y(ew4, 0, c3414At7);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            ((b) this.d.valueAt(i)).k();
        }
        this.n.clear();
        this.v = 0;
        this.w = j2;
        this.m.clear();
        g();
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.E = interfaceC10465bf2;
        g();
        k();
        C22835vt7 c22835vt7 = this.b;
        if (c22835vt7 != null) {
            this.d.put(0, new b(interfaceC10465bf2.b(0, c22835vt7.b), new C5540Jt7(this.b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new PE1(0, 0, 0, 0)));
            this.E.s();
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        return AbstractC17627nH6.b(interfaceC9845af2);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) throws ParserException {
        while (true) {
            int i = this.p;
            if (i != 0) {
                if (i == 1) {
                    K(interfaceC9845af2);
                } else if (i == 2) {
                    L(interfaceC9845af2);
                } else if (M(interfaceC9845af2)) {
                    return 0;
                }
            } else if (!J(interfaceC9845af2)) {
                return -1;
            }
        }
    }

    public C7267Qz2(int i) {
        this(i, null);
    }

    public C7267Qz2(int i, C5045Hq7 c5045Hq7) {
        this(i, c5045Hq7, null, Collections.emptyList());
    }

    public C7267Qz2(int i, C5045Hq7 c5045Hq7, C22835vt7 c22835vt7, List list) {
        this(i, c5045Hq7, c22835vt7, list, null);
    }

    public C7267Qz2(int i, C5045Hq7 c5045Hq7, C22835vt7 c22835vt7, List list, InterfaceC4589Ft7 interfaceC4589Ft7) {
        this.a = i;
        this.j = c5045Hq7;
        this.b = c22835vt7;
        this.c = Collections.unmodifiableList(list);
        this.o = interfaceC4589Ft7;
        this.k = new C11810db2();
        this.l = new EW4(16);
        this.e = new EW4(AbstractC6193Mo4.a);
        this.f = new EW4(5);
        this.g = new EW4();
        byte[] bArr = new byte[16];
        this.h = bArr;
        this.i = new EW4(bArr);
        this.m = new ArrayDeque();
        this.n = new ArrayDeque();
        this.d = new SparseArray();
        this.x = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.E = InterfaceC10465bf2.j0;
        this.F = new InterfaceC4589Ft7[0];
        this.G = new InterfaceC4589Ft7[0];
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }

    protected C22835vt7 m(C22835vt7 c22835vt7) {
        return c22835vt7;
    }
}
