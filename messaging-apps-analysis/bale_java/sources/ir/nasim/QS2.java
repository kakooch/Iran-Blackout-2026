package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import com.google.android.exoplayer2.X;
import ir.nasim.InterfaceC22268uw7;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class QS2 implements B52 {
    private static final float[] l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final C23663xI7 a;
    private final EW4 b;
    private final C5960Lo4 e;
    private b f;
    private long g;
    private String h;
    private InterfaceC4589Ft7 i;
    private boolean j;
    private final boolean[] c = new boolean[4];
    private final a d = new a(128);
    private long k = -9223372036854775807L;

    private static final class a {
        private static final byte[] f = {0, 0, 1};
        private boolean a;
        private int b;
        public int c;
        public int d;
        public byte[] e;

        public a(int i) {
            this.e = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.e;
                int length = bArr2.length;
                int i4 = this.c;
                if (length < i4 + i3) {
                    this.e = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.e, this.c, i3);
                this.c += i3;
            }
        }

        public boolean b(int i, int i2) {
            int i3 = this.b;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i == 179 || i == 181) {
                                this.c -= i2;
                                this.a = false;
                                return true;
                            }
                        } else if ((i & SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER) != 32) {
                            AbstractC18815pI3.k("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.d = this.c;
                            this.b = 4;
                        }
                    } else if (i > 31) {
                        AbstractC18815pI3.k("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.b = 3;
                    }
                } else if (i != 181) {
                    AbstractC18815pI3.k("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.b = 2;
                }
            } else if (i == 176) {
                this.b = 1;
                this.a = true;
            }
            byte[] bArr = f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.a = false;
            this.c = 0;
            this.b = 0;
        }
    }

    private static final class b {
        private final InterfaceC4589Ft7 a;
        private boolean b;
        private boolean c;
        private boolean d;
        private int e;
        private int f;
        private long g;
        private long h;

        public b(InterfaceC4589Ft7 interfaceC4589Ft7) {
            this.a = interfaceC4589Ft7;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.c) {
                int i3 = this.f;
                int i4 = (i + 1) - i3;
                if (i4 >= i2) {
                    this.f = i3 + (i2 - i);
                } else {
                    this.d = ((bArr[i4] & 192) >> 6) == 0;
                    this.c = false;
                }
            }
        }

        public void b(long j, int i, boolean z) {
            if (this.e == 182 && z && this.b) {
                long j2 = this.h;
                if (j2 != -9223372036854775807L) {
                    this.a.b(j2, this.d ? 1 : 0, (int) (j - this.g), i, null);
                }
            }
            if (this.e != 179) {
                this.g = j;
            }
        }

        public void c(int i, long j) {
            this.e = i;
            this.d = false;
            this.b = i == 182 || i == 179;
            this.c = i == 182;
            this.f = 0;
            this.h = j;
        }

        public void d() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = -1;
        }
    }

    QS2(C23663xI7 c23663xI7) {
        this.a = c23663xI7;
        if (c23663xI7 != null) {
            this.e = new C5960Lo4(SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER, 128);
            this.b = new EW4();
        } else {
            this.e = null;
            this.b = null;
        }
    }

    private static com.google.android.exoplayer2.X f(a aVar, int i, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(aVar.e, aVar.c);
        DW4 dw4 = new DW4(bArrCopyOf);
        dw4.s(i);
        dw4.s(4);
        dw4.q();
        dw4.r(8);
        if (dw4.g()) {
            dw4.r(4);
            dw4.r(3);
        }
        int iH = dw4.h(4);
        float f = 1.0f;
        if (iH == 15) {
            int iH2 = dw4.h(8);
            int iH3 = dw4.h(8);
            if (iH3 == 0) {
                AbstractC18815pI3.k("H263Reader", "Invalid aspect ratio");
            } else {
                f = iH2 / iH3;
            }
        } else {
            float[] fArr = l;
            if (iH < fArr.length) {
                f = fArr[iH];
            } else {
                AbstractC18815pI3.k("H263Reader", "Invalid aspect ratio");
            }
        }
        if (dw4.g()) {
            dw4.r(2);
            dw4.r(1);
            if (dw4.g()) {
                dw4.r(15);
                dw4.q();
                dw4.r(15);
                dw4.q();
                dw4.r(15);
                dw4.q();
                dw4.r(3);
                dw4.r(11);
                dw4.q();
                dw4.r(15);
                dw4.q();
            }
        }
        if (dw4.h(2) != 0) {
            AbstractC18815pI3.k("H263Reader", "Unhandled video object layer shape");
        }
        dw4.q();
        int iH4 = dw4.h(16);
        dw4.q();
        if (dw4.g()) {
            if (iH4 == 0) {
                AbstractC18815pI3.k("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i2 = 0;
                for (int i3 = iH4 - 1; i3 > 0; i3 >>= 1) {
                    i2++;
                }
                dw4.r(i2);
            }
        }
        dw4.q();
        int iH5 = dw4.h(13);
        dw4.q();
        int iH6 = dw4.h(13);
        dw4.q();
        dw4.q();
        return new X.b().U(str).g0("video/mp4v-es").n0(iH5).S(iH6).c0(f).V(Collections.singletonList(bArrCopyOf)).G();
    }

    @Override // ir.nasim.B52
    public void a(EW4 ew4) {
        AbstractC20011rK.i(this.f);
        AbstractC20011rK.i(this.i);
        int iF = ew4.f();
        int iG = ew4.g();
        byte[] bArrE = ew4.e();
        this.g += ew4.a();
        this.i.d(ew4, ew4.a());
        while (true) {
            int iC = AbstractC6193Mo4.c(bArrE, iF, iG, this.c);
            if (iC == iG) {
                break;
            }
            int i = iC + 3;
            int i2 = ew4.e()[i] & 255;
            int i3 = iC - iF;
            int i4 = 0;
            if (!this.j) {
                if (i3 > 0) {
                    this.d.a(bArrE, iF, iC);
                }
                if (this.d.b(i2, i3 < 0 ? -i3 : 0)) {
                    InterfaceC4589Ft7 interfaceC4589Ft7 = this.i;
                    a aVar = this.d;
                    interfaceC4589Ft7.c(f(aVar, aVar.d, (String) AbstractC20011rK.e(this.h)));
                    this.j = true;
                }
            }
            this.f.a(bArrE, iF, iC);
            C5960Lo4 c5960Lo4 = this.e;
            if (c5960Lo4 != null) {
                if (i3 > 0) {
                    c5960Lo4.a(bArrE, iF, iC);
                } else {
                    i4 = -i3;
                }
                if (this.e.b(i4)) {
                    C5960Lo4 c5960Lo42 = this.e;
                    ((EW4) AbstractC9683aN7.j(this.b)).Q(this.e.d, AbstractC6193Mo4.q(c5960Lo42.d, c5960Lo42.e));
                    ((C23663xI7) AbstractC9683aN7.j(this.a)).a(this.k, this.b);
                }
                if (i2 == 178 && ew4.e()[iC + 2] == 1) {
                    this.e.e(i2);
                }
            }
            int i5 = iG - iC;
            this.f.b(this.g - i5, i5, this.j);
            this.f.c(i2, this.k);
            iF = i;
        }
        if (!this.j) {
            this.d.a(bArrE, iF, iG);
        }
        this.f.a(bArrE, iF, iG);
        C5960Lo4 c5960Lo43 = this.e;
        if (c5960Lo43 != null) {
            c5960Lo43.a(bArrE, iF, iG);
        }
    }

    @Override // ir.nasim.B52
    public void b() {
        AbstractC6193Mo4.a(this.c);
        this.d.c();
        b bVar = this.f;
        if (bVar != null) {
            bVar.d();
        }
        C5960Lo4 c5960Lo4 = this.e;
        if (c5960Lo4 != null) {
            c5960Lo4.d();
        }
        this.g = 0L;
        this.k = -9223372036854775807L;
    }

    @Override // ir.nasim.B52
    public void c(InterfaceC10465bf2 interfaceC10465bf2, InterfaceC22268uw7.d dVar) {
        dVar.a();
        this.h = dVar.b();
        InterfaceC4589Ft7 interfaceC4589Ft7B = interfaceC10465bf2.b(dVar.c(), 2);
        this.i = interfaceC4589Ft7B;
        this.f = new b(interfaceC4589Ft7B);
        C23663xI7 c23663xI7 = this.a;
        if (c23663xI7 != null) {
            c23663xI7.b(interfaceC10465bf2, dVar);
        }
    }

    @Override // ir.nasim.B52
    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    @Override // ir.nasim.B52
    public void d() {
    }
}
