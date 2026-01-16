package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.javax.sip.parser.TokenTypes;
import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import okhttp3.internal.http.StatusLine;

/* renamed from: ir.nasim.v48, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22346v48 implements InterfaceC9262Ze2 {
    public static final InterfaceC12462ef2 h = new InterfaceC12462ef2() { // from class: ir.nasim.u48
        @Override // ir.nasim.InterfaceC12462ef2
        public final InterfaceC9262Ze2[] c() {
            return C22346v48.g();
        }
    };
    private InterfaceC10465bf2 a;
    private InterfaceC4589Ft7 b;
    private b e;
    private int c = 0;
    private long d = -1;
    private int f = -1;
    private long g = -1;

    /* renamed from: ir.nasim.v48$a */
    private static final class a implements b {
        private static final int[] m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        private static final int[] n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, 130, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER, 173, SetRpcStruct$ComposedRpc.SIGN_UP_FIELD_NUMBER, 209, SetRpcStruct$ComposedRpc.CREATE_GROUP_FIELD_NUMBER, 253, 279, StatusLine.HTTP_TEMP_REDIRECT, 337, 371, 408, 449, 494, 544, 598, 658, SetRpcStruct$ComposedRpc.SET_CAN_SEE_MESSAGES_FIELD_NUMBER, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, TokenTypes.SERVER, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        private final InterfaceC10465bf2 a;
        private final InterfaceC4589Ft7 b;
        private final C22942w48 c;
        private final int d;
        private final byte[] e;
        private final EW4 f;
        private final int g;
        private final com.google.android.exoplayer2.X h;
        private int i;
        private long j;
        private int k;
        private long l;

        public a(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC4589Ft7 interfaceC4589Ft7, C22942w48 c22942w48) throws ParserException {
            this.a = interfaceC10465bf2;
            this.b = interfaceC4589Ft7;
            this.c = c22942w48;
            int iMax = Math.max(1, c22942w48.c / 10);
            this.g = iMax;
            EW4 ew4 = new EW4(c22942w48.g);
            ew4.x();
            int iX = ew4.x();
            this.d = iX;
            int i = c22942w48.b;
            int i2 = (((c22942w48.e - (i * 4)) * 8) / (c22942w48.f * i)) + 1;
            if (iX == i2) {
                int iL = AbstractC9683aN7.l(iMax, iX);
                this.e = new byte[c22942w48.e * iL];
                this.f = new EW4(iL * h(iX, i));
                int i3 = ((c22942w48.c * c22942w48.e) * 8) / iX;
                this.h = new X.b().g0("audio/raw").I(i3).b0(i3).Y(h(iMax, i)).J(c22942w48.b).h0(c22942w48.c).a0(2).G();
                return;
            }
            throw ParserException.a("Expected frames per block: " + i2 + "; got: " + iX, null);
        }

        private void d(byte[] bArr, int i, EW4 ew4) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < this.c.b; i3++) {
                    e(bArr, i2, i3, ew4.e());
                }
            }
            int iG = g(this.d * i);
            ew4.S(0);
            ew4.R(iG);
        }

        private void e(byte[] bArr, int i, int i2, byte[] bArr2) {
            C22942w48 c22942w48 = this.c;
            int i3 = c22942w48.e;
            int i4 = c22942w48.b;
            int i5 = (i * i3) + (i2 * 4);
            int i6 = (i4 * 4) + i5;
            int i7 = (i3 / i4) - 4;
            int iP = (short) (((bArr[i5 + 1] & 255) << 8) | (bArr[i5] & 255));
            int iMin = Math.min(bArr[i5 + 2] & 255, 88);
            int i8 = n[iMin];
            int i9 = ((i * this.d * i4) + i2) * 2;
            bArr2[i9] = (byte) (iP & 255);
            bArr2[i9 + 1] = (byte) (iP >> 8);
            for (int i10 = 0; i10 < i7 * 2; i10++) {
                byte b = bArr[((i10 / 8) * i4 * 4) + i6 + ((i10 / 2) % 4)];
                int i11 = i10 % 2 == 0 ? b & 15 : (b & 255) >> 4;
                int i12 = ((((i11 & 7) * 2) + 1) * i8) >> 3;
                if ((i11 & 8) != 0) {
                    i12 = -i12;
                }
                iP = AbstractC9683aN7.p(iP + i12, -32768, 32767);
                i9 += i4 * 2;
                bArr2[i9] = (byte) (iP & 255);
                bArr2[i9 + 1] = (byte) (iP >> 8);
                int i13 = iMin + m[i11];
                int[] iArr = n;
                iMin = AbstractC9683aN7.p(i13, 0, iArr.length - 1);
                i8 = iArr[iMin];
            }
        }

        private int f(int i) {
            return i / (this.c.b * 2);
        }

        private int g(int i) {
            return h(i, this.c.b);
        }

        private static int h(int i, int i2) {
            return i * 2 * i2;
        }

        private void i(int i) {
            long jN0 = this.j + AbstractC9683aN7.N0(this.l, 1000000L, this.c.c);
            int iG = g(i);
            this.b.b(jN0, 1, iG, this.k - iG, null);
            this.l += i;
            this.k -= iG;
        }

        @Override // ir.nasim.C22346v48.b
        public void a(int i, long j) {
            this.a.o(new C24122y48(this.c, this.d, i, j));
            this.b.c(this.h);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0035 -> B:4:0x001b). Please report as a decompilation issue!!! */
        @Override // ir.nasim.C22346v48.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(ir.nasim.InterfaceC9845af2 r7, long r8) {
            /*
                r6 = this;
                int r0 = r6.g
                int r1 = r6.k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.d
                int r0 = ir.nasim.AbstractC9683aN7.l(r0, r1)
                ir.nasim.w48 r1 = r6.c
                int r1 = r1.e
                int r0 = r0 * r1
                r1 = 0
                int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                r2 = 1
                if (r1 != 0) goto L1d
            L1b:
                r1 = r2
                goto L1e
            L1d:
                r1 = 0
            L1e:
                if (r1 != 0) goto L3e
                int r3 = r6.i
                if (r3 >= r0) goto L3e
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r3 = (int) r3
                byte[] r4 = r6.e
                int r5 = r6.i
                int r3 = r7.read(r4, r5, r3)
                r4 = -1
                if (r3 != r4) goto L38
                goto L1b
            L38:
                int r4 = r6.i
                int r4 = r4 + r3
                r6.i = r4
                goto L1e
            L3e:
                int r7 = r6.i
                ir.nasim.w48 r8 = r6.c
                int r8 = r8.e
                int r7 = r7 / r8
                if (r7 <= 0) goto L75
                byte[] r8 = r6.e
                ir.nasim.EW4 r9 = r6.f
                r6.d(r8, r7, r9)
                int r8 = r6.i
                ir.nasim.w48 r9 = r6.c
                int r9 = r9.e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.i = r8
                ir.nasim.EW4 r7 = r6.f
                int r7 = r7.g()
                ir.nasim.Ft7 r8 = r6.b
                ir.nasim.EW4 r9 = r6.f
                r8.d(r9, r7)
                int r8 = r6.k
                int r8 = r8 + r7
                r6.k = r8
                int r7 = r6.f(r8)
                int r8 = r6.g
                if (r7 < r8) goto L75
                r6.i(r8)
            L75:
                if (r1 == 0) goto L82
                int r7 = r6.k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L82
                r6.i(r7)
            L82:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22346v48.a.b(ir.nasim.af2, long):boolean");
        }

        @Override // ir.nasim.C22346v48.b
        public void c(long j) {
            this.i = 0;
            this.j = j;
            this.k = 0;
            this.l = 0L;
        }
    }

    /* renamed from: ir.nasim.v48$b */
    private interface b {
        void a(int i, long j);

        boolean b(InterfaceC9845af2 interfaceC9845af2, long j);

        void c(long j);
    }

    /* renamed from: ir.nasim.v48$c */
    private static final class c implements b {
        private final InterfaceC10465bf2 a;
        private final InterfaceC4589Ft7 b;
        private final C22942w48 c;
        private final com.google.android.exoplayer2.X d;
        private final int e;
        private long f;
        private int g;
        private long h;

        public c(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC4589Ft7 interfaceC4589Ft7, C22942w48 c22942w48, String str, int i) throws ParserException {
            this.a = interfaceC10465bf2;
            this.b = interfaceC4589Ft7;
            this.c = c22942w48;
            int i2 = (c22942w48.b * c22942w48.f) / 8;
            if (c22942w48.e == i2) {
                int i3 = c22942w48.c;
                int i4 = i3 * i2 * 8;
                int iMax = Math.max(i2, (i3 * i2) / 10);
                this.e = iMax;
                this.d = new X.b().g0(str).I(i4).b0(i4).Y(iMax).J(c22942w48.b).h0(c22942w48.c).a0(i).G();
                return;
            }
            throw ParserException.a("Expected block size: " + i2 + "; got: " + c22942w48.e, null);
        }

        @Override // ir.nasim.C22346v48.b
        public void a(int i, long j) {
            this.a.o(new C24122y48(this.c, 1, i, j));
            this.b.c(this.d);
        }

        @Override // ir.nasim.C22346v48.b
        public boolean b(InterfaceC9845af2 interfaceC9845af2, long j) {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.g) < (i2 = this.e)) {
                int iF = this.b.f(interfaceC9845af2, (int) Math.min(i2 - i, j2), true);
                if (iF == -1) {
                    j2 = 0;
                } else {
                    this.g += iF;
                    j2 -= iF;
                }
            }
            int i3 = this.c.e;
            int i4 = this.g / i3;
            if (i4 > 0) {
                long jN0 = this.f + AbstractC9683aN7.N0(this.h, 1000000L, r1.c);
                int i5 = i4 * i3;
                int i6 = this.g - i5;
                this.b.b(jN0, 1, i5, i6, null);
                this.h += i4;
                this.g = i6;
            }
            return j2 <= 0;
        }

        @Override // ir.nasim.C22346v48.b
        public void c(long j) {
            this.f = j;
            this.g = 0;
            this.h = 0L;
        }
    }

    private void f() {
        AbstractC20011rK.i(this.b);
        AbstractC9683aN7.j(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceC9262Ze2[] g() {
        return new InterfaceC9262Ze2[]{new C22346v48()};
    }

    private void h(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        AbstractC20011rK.g(interfaceC9845af2.getPosition() == 0);
        int i = this.f;
        if (i != -1) {
            interfaceC9845af2.k(i);
            this.c = 4;
        } else {
            if (!AbstractC23532x48.a(interfaceC9845af2)) {
                throw ParserException.a("Unsupported or unrecognized wav file type.", null);
            }
            interfaceC9845af2.k((int) (interfaceC9845af2.g() - interfaceC9845af2.getPosition()));
            this.c = 1;
        }
    }

    private void i(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        C22942w48 c22942w48B = AbstractC23532x48.b(interfaceC9845af2);
        int i = c22942w48B.a;
        if (i == 17) {
            this.e = new a(this.a, this.b, c22942w48B);
        } else if (i == 6) {
            this.e = new c(this.a, this.b, c22942w48B, "audio/g711-alaw", -1);
        } else if (i == 7) {
            this.e = new c(this.a, this.b, c22942w48B, "audio/g711-mlaw", -1);
        } else {
            int iA = AbstractC24712z48.a(i, c22942w48B.f);
            if (iA == 0) {
                throw ParserException.d("Unsupported WAV format type: " + c22942w48B.a);
            }
            this.e = new c(this.a, this.b, c22942w48B, "audio/raw", iA);
        }
        this.c = 3;
    }

    private void j(InterfaceC9845af2 interfaceC9845af2) {
        this.d = AbstractC23532x48.c(interfaceC9845af2);
        this.c = 2;
    }

    private int k(InterfaceC9845af2 interfaceC9845af2) {
        AbstractC20011rK.g(this.g != -1);
        return ((b) AbstractC20011rK.e(this.e)).b(interfaceC9845af2, this.g - interfaceC9845af2.getPosition()) ? -1 : 0;
    }

    private void l(InterfaceC9845af2 interfaceC9845af2) throws ParserException {
        Pair pairE = AbstractC23532x48.e(interfaceC9845af2);
        this.f = ((Long) pairE.first).intValue();
        long jLongValue = ((Long) pairE.second).longValue();
        long j = this.d;
        if (j != -1 && jLongValue == 4294967295L) {
            jLongValue = j;
        }
        this.g = this.f + jLongValue;
        long length = interfaceC9845af2.getLength();
        if (length != -1 && this.g > length) {
            AbstractC18815pI3.k("WavExtractor", "Data exceeds input length: " + this.g + ", " + length);
            this.g = length;
        }
        ((b) AbstractC20011rK.e(this.e)).a(this.f, this.g);
        this.c = 4;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        this.c = j == 0 ? 0 : 4;
        b bVar = this.e;
        if (bVar != null) {
            bVar.c(j2);
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        this.a = interfaceC10465bf2;
        this.b = interfaceC10465bf2.b(0, 1);
        interfaceC10465bf2.s();
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        return AbstractC23532x48.a(interfaceC9845af2);
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) throws ParserException {
        f();
        int i = this.c;
        if (i == 0) {
            h(interfaceC9845af2);
            return 0;
        }
        if (i == 1) {
            j(interfaceC9845af2);
            return 0;
        }
        if (i == 2) {
            i(interfaceC9845af2);
            return 0;
        }
        if (i == 3) {
            l(interfaceC9845af2);
            return 0;
        }
        if (i == 4) {
            return k(interfaceC9845af2);
        }
        throw new IllegalStateException();
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
    }
}
