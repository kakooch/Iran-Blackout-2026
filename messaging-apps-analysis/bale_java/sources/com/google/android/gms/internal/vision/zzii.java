package com.google.android.gms.internal.vision;

import ir.nasim.AbstractC25160zp8;
import ir.nasim.InterfaceC18561or8;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class zzii extends AbstractC25160zp8 {
    private static final Logger b = Logger.getLogger(zzii.class.getName());
    private static final boolean c = i1.m();
    Z a;

    private static class a extends zzii {
        private final byte[] d;
        private final int e;
        private final int f;
        private int g;

        a(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if (((bArr.length - i2) | i2) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.d = bArr;
            this.e = 0;
            this.g = 0;
            this.f = i2;
        }

        private final void B0(byte[] bArr, int i, int i2) throws zzb {
            try {
                System.arraycopy(bArr, i, this.d, this.g, i2);
                this.g += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void K(int i) throws zzb {
            if (!zzii.c || E.b() || b() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.d;
                        int i2 = this.g;
                        this.g = i2 + 1;
                        bArr[i2] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
                    }
                }
                byte[] bArr2 = this.d;
                int i3 = this.g;
                this.g = i3 + 1;
                bArr2[i3] = (byte) i;
                return;
            }
            if ((i & (-128)) == 0) {
                byte[] bArr3 = this.d;
                int i4 = this.g;
                this.g = i4 + 1;
                i1.l(bArr3, i4, (byte) i);
                return;
            }
            byte[] bArr4 = this.d;
            int i5 = this.g;
            this.g = i5 + 1;
            i1.l(bArr4, i5, (byte) (i | 128));
            int i6 = i >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.d;
                int i7 = this.g;
                this.g = i7 + 1;
                i1.l(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.d;
            int i8 = this.g;
            this.g = i8 + 1;
            i1.l(bArr6, i8, (byte) (i6 | 128));
            int i9 = i >>> 14;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.d;
                int i10 = this.g;
                this.g = i10 + 1;
                i1.l(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.d;
            int i11 = this.g;
            this.g = i11 + 1;
            i1.l(bArr8, i11, (byte) (i9 | 128));
            int i12 = i >>> 21;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.d;
                int i13 = this.g;
                this.g = i13 + 1;
                i1.l(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.d;
            int i14 = this.g;
            this.g = i14 + 1;
            i1.l(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.d;
            int i15 = this.g;
            this.g = i15 + 1;
            i1.l(bArr11, i15, (byte) (i >>> 28));
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void L(int i, int i2) {
            k(i, 0);
            h(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void N(int i, K k) {
            k(1, 3);
            T(2, i);
            m(3, k);
            k(1, 4);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void T(int i, int i2) {
            k(i, 0);
            K(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void U(int i, long j) {
            k(i, 1);
            V(j);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void V(long j) throws zzb {
            try {
                byte[] bArr = this.d;
                int i = this.g;
                bArr[i] = (byte) j;
                bArr[i + 1] = (byte) (j >> 8);
                bArr[i + 2] = (byte) (j >> 16);
                bArr[i + 3] = (byte) (j >> 24);
                bArr[i + 4] = (byte) (j >> 32);
                bArr[i + 5] = (byte) (j >> 40);
                bArr[i + 6] = (byte) (j >> 48);
                this.g = i + 8;
                bArr[i + 7] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
            }
        }

        @Override // ir.nasim.AbstractC25160zp8
        public final void a(byte[] bArr, int i, int i2) throws zzb {
            B0(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void a0(int i) throws zzb {
            try {
                byte[] bArr = this.d;
                int i2 = this.g;
                bArr[i2] = (byte) i;
                bArr[i2 + 1] = (byte) (i >> 8);
                bArr[i2 + 2] = (byte) (i >> 16);
                this.g = i2 + 4;
                bArr[i2 + 3] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final int b() {
            return this.f - this.g;
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void e(byte b) throws zzb {
            try {
                byte[] bArr = this.d;
                int i = this.g;
                this.g = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void f0(int i, int i2) {
            k(i, 5);
            a0(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void h(int i) {
            if (i >= 0) {
                K(i);
            } else {
                r(i);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void k(int i, int i2) {
            K((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void l(int i, long j) {
            k(i, 0);
            r(j);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void m(int i, K k) {
            k(i, 2);
            s(k);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void n(int i, InterfaceC18561or8 interfaceC18561or8) {
            k(1, 3);
            T(2, i);
            k(3, 2);
            t(interfaceC18561or8);
            k(1, 4);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        final void o(int i, InterfaceC18561or8 interfaceC18561or8, P0 p0) {
            k(i, 2);
            D d = (D) interfaceC18561or8;
            int iE = d.e();
            if (iE == -1) {
                iE = p0.i(d);
                d.c(iE);
            }
            K(iE);
            p0.e(interfaceC18561or8, this.a);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void p(int i, String str) {
            k(i, 2);
            u(str);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void q(int i, boolean z) {
            k(i, 0);
            e(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void r(long j) throws zzb {
            if (zzii.c && b() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.d;
                    int i = this.g;
                    this.g = i + 1;
                    i1.l(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.d;
                int i2 = this.g;
                this.g = i2 + 1;
                i1.l(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.d;
                    int i3 = this.g;
                    this.g = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f), 1), e);
                }
            }
            byte[] bArr4 = this.d;
            int i4 = this.g;
            this.g = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void s(K k) {
            K(k.j());
            k.L(this);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void t(InterfaceC18561or8 interfaceC18561or8) {
            K(interfaceC18561or8.f());
            interfaceC18561or8.k(this);
        }

        @Override // com.google.android.gms.internal.vision.zzii
        public final void u(String str) throws zzb {
            int i = this.g;
            try {
                int iK0 = zzii.k0(str.length() * 3);
                int iK02 = zzii.k0(str.length());
                if (iK02 != iK0) {
                    K(k1.d(str));
                    this.g = k1.e(str, this.d, this.g, b());
                    return;
                }
                int i2 = i + iK02;
                this.g = i2;
                int iE = k1.e(str, this.d, i2, b());
                this.g = i;
                K((iE - i) - iK02);
                this.g = iE;
            } catch (n1 e) {
                this.g = i;
                v(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }
    }

    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        zzb(String str, Throwable th) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
        }
    }

    private zzii() {
    }

    public static int A(int i, float f) {
        return k0(i << 3) + 4;
    }

    private static int A0(int i) {
        return (i >> 31) ^ (i << 1);
    }

    static int B(int i, InterfaceC18561or8 interfaceC18561or8, P0 p0) {
        return k0(i << 3) + c(interfaceC18561or8, p0);
    }

    public static int C(int i, String str) {
        return k0(i << 3) + G(str);
    }

    public static int D(int i, boolean z) {
        return k0(i << 3) + 1;
    }

    public static int E(K k) {
        int iJ = k.j();
        return k0(iJ) + iJ;
    }

    public static int F(InterfaceC18561or8 interfaceC18561or8) {
        int iF = interfaceC18561or8.f();
        return k0(iF) + iF;
    }

    public static int G(String str) {
        int length;
        try {
            length = k1.d(str);
        } catch (n1 unused) {
            length = str.getBytes(AbstractC2184m0.a).length;
        }
        return k0(length) + length;
    }

    public static int H(boolean z) {
        return 1;
    }

    public static int I(byte[] bArr) {
        int length = bArr.length;
        return k0(length) + length;
    }

    public static int P(int i, K k) {
        int iK0 = k0(i << 3);
        int iJ = k.j();
        return iK0 + k0(iJ) + iJ;
    }

    static int Q(int i, InterfaceC18561or8 interfaceC18561or8, P0 p0) {
        int iK0 = k0(i << 3) << 1;
        D d = (D) interfaceC18561or8;
        int iE = d.e();
        if (iE == -1) {
            iE = p0.i(d);
            d.c(iE);
        }
        return iK0 + iE;
    }

    public static int R(InterfaceC18561or8 interfaceC18561or8) {
        return interfaceC18561or8.f();
    }

    public static int X(int i, long j) {
        return k0(i << 3) + e0(j);
    }

    public static int Y(int i, K k) {
        return (k0(8) << 1) + l0(2, i) + P(3, k);
    }

    public static int Z(long j) {
        return e0(j);
    }

    static int c(InterfaceC18561or8 interfaceC18561or8, P0 p0) {
        D d = (D) interfaceC18561or8;
        int iE = d.e();
        if (iE == -1) {
            iE = p0.i(d);
            d.c(iE);
        }
        return k0(iE) + iE;
    }

    public static int c0(int i) {
        return k0(i << 3);
    }

    public static zzii d(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int d0(int i, long j) {
        return k0(i << 3) + e0(j);
    }

    public static int e0(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int g0(int i) {
        if (i >= 0) {
            return k0(i);
        }
        return 10;
    }

    public static int h0(int i, int i2) {
        return k0(i << 3) + g0(i2);
    }

    public static int i0(int i, long j) {
        return k0(i << 3) + e0(u0(j));
    }

    public static int j0(long j) {
        return e0(u0(j));
    }

    public static int k0(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int l0(int i, int i2) {
        return k0(i << 3) + k0(i2);
    }

    public static int m0(int i, long j) {
        return k0(i << 3) + 8;
    }

    public static int n0(long j) {
        return 8;
    }

    public static int o0(int i) {
        return k0(A0(i));
    }

    public static int p0(int i, int i2) {
        return k0(i << 3) + k0(A0(i2));
    }

    public static int q0(int i, long j) {
        return k0(i << 3) + 8;
    }

    public static int r0(long j) {
        return 8;
    }

    public static int s0(int i) {
        return 4;
    }

    public static int t0(int i, int i2) {
        return k0(i << 3) + 4;
    }

    private static long u0(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int v0(int i) {
        return 4;
    }

    public static int w0(int i, int i2) {
        return k0(i << 3) + 4;
    }

    public static int x(double d) {
        return 8;
    }

    public static int x0(int i) {
        return g0(i);
    }

    public static int y(float f) {
        return 4;
    }

    public static int y0(int i, int i2) {
        return k0(i << 3) + g0(i2);
    }

    public static int z(int i, double d) {
        return k0(i << 3) + 8;
    }

    public static int z0(int i) {
        return k0(i);
    }

    public final void J() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void K(int i);

    public abstract void L(int i, int i2);

    public final void M(int i, long j) {
        l(i, u0(j));
    }

    public abstract void N(int i, K k);

    public final void O(long j) {
        r(u0(j));
    }

    public final void S(int i) {
        K(A0(i));
    }

    public abstract void T(int i, int i2);

    public abstract void U(int i, long j);

    public abstract void V(long j);

    public abstract void a0(int i);

    public abstract int b();

    public final void b0(int i, int i2) {
        T(i, A0(i2));
    }

    public abstract void e(byte b2);

    public final void f(double d) {
        V(Double.doubleToRawLongBits(d));
    }

    public abstract void f0(int i, int i2);

    public final void g(float f) {
        a0(Float.floatToRawIntBits(f));
    }

    public abstract void h(int i);

    public final void i(int i, double d) {
        U(i, Double.doubleToRawLongBits(d));
    }

    public final void j(int i, float f) {
        f0(i, Float.floatToRawIntBits(f));
    }

    public abstract void k(int i, int i2);

    public abstract void l(int i, long j);

    public abstract void m(int i, K k);

    public abstract void n(int i, InterfaceC18561or8 interfaceC18561or8);

    abstract void o(int i, InterfaceC18561or8 interfaceC18561or8, P0 p0);

    public abstract void p(int i, String str);

    public abstract void q(int i, boolean z);

    public abstract void r(long j);

    public abstract void s(K k);

    public abstract void t(InterfaceC18561or8 interfaceC18561or8);

    public abstract void u(String str);

    final void v(String str, n1 n1Var) throws zzb {
        b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) n1Var);
        byte[] bytes = str.getBytes(AbstractC2184m0.a);
        try {
            K(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (zzb e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzb(e2);
        }
    }

    public final void w(boolean z) {
        e(z ? (byte) 1 : (byte) 0);
    }
}
