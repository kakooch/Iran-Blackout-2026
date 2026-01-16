package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.e0;
import ir.nasim.AbstractC6189Mo0;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class CodedOutputStream extends AbstractC6189Mo0 {
    private static final Logger c = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean d = d0.E();
    C2348j a;
    private boolean b;

    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        OutOfSpaceException(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    private static class b extends CodedOutputStream {
        private final byte[] e;
        private final int f;
        private final int g;
        private int h;

        b(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            this.e = bArr;
            this.f = i;
            this.h = i;
            this.g = i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void C0(int i, String str) throws OutOfSpaceException {
            D0(i, 2);
            M0(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void D0(int i, int i2) throws OutOfSpaceException {
            F0(f0.c(i, i2));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void E0(int i, int i2) throws OutOfSpaceException {
            D0(i, 0);
            F0(i2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void F0(int i) throws OutOfSpaceException {
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr = this.e;
                    int i2 = this.h;
                    this.h = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.h), Integer.valueOf(this.g), 1), e);
                }
            }
            byte[] bArr2 = this.e;
            int i3 = this.h;
            this.h = i3 + 1;
            bArr2[i3] = (byte) i;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void G0(int i, long j) throws OutOfSpaceException {
            D0(i, 0);
            H0(j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void H0(long j) throws OutOfSpaceException {
            if (CodedOutputStream.d && W() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.e;
                    int i = this.h;
                    this.h = i + 1;
                    d0.K(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.e;
                int i2 = this.h;
                this.h = i2 + 1;
                d0.K(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.e;
                    int i3 = this.h;
                    this.h = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.h), Integer.valueOf(this.g), 1), e);
                }
            }
            byte[] bArr4 = this.e;
            int i4 = this.h;
            this.h = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        public final void I0(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            try {
                System.arraycopy(bArr, i, this.e, this.h, i2);
                this.h += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.h), Integer.valueOf(this.g), Integer.valueOf(i2)), e);
            }
        }

        public final void J0(AbstractC2345g abstractC2345g) throws OutOfSpaceException {
            F0(abstractC2345g.size());
            abstractC2345g.g0(this);
        }

        public final void K0(int i, I i2) throws OutOfSpaceException {
            D0(i, 2);
            L0(i2);
        }

        public final void L0(I i) throws OutOfSpaceException {
            F0(i.getSerializedSize());
            i.c(this);
        }

        public final void M0(String str) throws OutOfSpaceException {
            int i = this.h;
            try {
                int iN = CodedOutputStream.N(str.length() * 3);
                int iN2 = CodedOutputStream.N(str.length());
                if (iN2 == iN) {
                    int i2 = i + iN2;
                    this.h = i2;
                    int iF = e0.f(str, this.e, i2, W());
                    this.h = i;
                    F0((iF - i) - iN2);
                    this.h = iF;
                } else {
                    F0(e0.g(str));
                    this.h = e0.f(str, this.e, this.h, W());
                }
            } catch (e0.d e) {
                this.h = i;
                S(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int W() {
            return this.g - this.h;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void X(byte b) throws OutOfSpaceException {
            try {
                byte[] bArr = this.e;
                int i = this.h;
                this.h = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.h), Integer.valueOf(this.g), 1), e);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void Y(int i, boolean z) throws OutOfSpaceException {
            D0(i, 0);
            X(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, ir.nasim.AbstractC6189Mo0
        public final void a(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            I0(bArr, i, i2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void a0(int i, AbstractC2345g abstractC2345g) throws OutOfSpaceException {
            D0(i, 2);
            J0(abstractC2345g);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void f0(int i, int i2) throws OutOfSpaceException {
            D0(i, 5);
            g0(i2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void g0(int i) throws OutOfSpaceException {
            try {
                byte[] bArr = this.e;
                int i2 = this.h;
                bArr[i2] = (byte) (i & 255);
                bArr[i2 + 1] = (byte) ((i >> 8) & 255);
                bArr[i2 + 2] = (byte) ((i >> 16) & 255);
                this.h = i2 + 4;
                bArr[i2 + 3] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.h), Integer.valueOf(this.g), 1), e);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void h0(int i, long j) throws OutOfSpaceException {
            D0(i, 1);
            i0(j);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void i0(long j) throws OutOfSpaceException {
            try {
                byte[] bArr = this.e;
                int i = this.h;
                bArr[i] = (byte) (((int) j) & 255);
                bArr[i + 1] = (byte) (((int) (j >> 8)) & 255);
                bArr[i + 2] = (byte) (((int) (j >> 16)) & 255);
                bArr[i + 3] = (byte) (((int) (j >> 24)) & 255);
                bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
                bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
                bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
                this.h = i + 8;
                bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.h), Integer.valueOf(this.g), 1), e);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void n0(int i, int i2) throws OutOfSpaceException {
            D0(i, 0);
            o0(i2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void o0(int i) throws OutOfSpaceException {
            if (i >= 0) {
                F0(i);
            } else {
                H0(i);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        final void r0(int i, I i2, V v) throws OutOfSpaceException {
            D0(i, 2);
            F0(((AbstractC2339a) i2).a(v));
            v.j(i2, this.a);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void s0(int i, I i2) throws OutOfSpaceException {
            D0(1, 3);
            E0(2, i);
            K0(3, i2);
            D0(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void t0(int i, AbstractC2345g abstractC2345g) throws OutOfSpaceException {
            D0(1, 3);
            E0(2, i);
            a0(3, abstractC2345g);
            D0(1, 4);
        }
    }

    public static int A(int i, AbstractC2345g abstractC2345g) {
        return (L(1) * 2) + M(2, i) + f(3, abstractC2345g);
    }

    public static int B(int i, int i2) {
        return L(i) + C(i2);
    }

    public static int C(int i) {
        return 4;
    }

    public static int D(int i, long j) {
        return L(i) + E(j);
    }

    public static int E(long j) {
        return 8;
    }

    public static int F(int i, int i2) {
        return L(i) + G(i2);
    }

    public static int G(int i) {
        return N(Q(i));
    }

    public static int H(int i, long j) {
        return L(i) + I(j);
    }

    public static int I(long j) {
        return P(R(j));
    }

    public static int J(int i, String str) {
        return L(i) + K(str);
    }

    public static int K(String str) {
        int length;
        try {
            length = e0.g(str);
        } catch (e0.d unused) {
            length = str.getBytes(AbstractC2360w.b).length;
        }
        return x(length);
    }

    public static int L(int i) {
        return N(f0.c(i, 0));
    }

    public static int M(int i, int i2) {
        return L(i) + N(i2);
    }

    public static int N(int i) {
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

    public static int O(int i, long j) {
        return L(i) + P(j);
    }

    public static int P(long j) {
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

    public static int Q(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long R(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static CodedOutputStream U(byte[] bArr) {
        return V(bArr, 0, bArr.length);
    }

    public static CodedOutputStream V(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    public static int d(int i, boolean z) {
        return L(i) + e(z);
    }

    public static int e(boolean z) {
        return 1;
    }

    public static int f(int i, AbstractC2345g abstractC2345g) {
        return L(i) + g(abstractC2345g);
    }

    public static int g(AbstractC2345g abstractC2345g) {
        return x(abstractC2345g.size());
    }

    public static int h(int i, double d2) {
        return L(i) + i(d2);
    }

    public static int i(double d2) {
        return 8;
    }

    public static int j(int i, int i2) {
        return L(i) + k(i2);
    }

    public static int k(int i) {
        return u(i);
    }

    public static int l(int i, int i2) {
        return L(i) + m(i2);
    }

    public static int m(int i) {
        return 4;
    }

    public static int n(int i, long j) {
        return L(i) + o(j);
    }

    public static int o(long j) {
        return 8;
    }

    public static int p(int i, float f) {
        return L(i) + q(f);
    }

    public static int q(float f) {
        return 4;
    }

    static int r(int i, I i2, V v) {
        return (L(i) * 2) + s(i2, v);
    }

    static int s(I i, V v) {
        return ((AbstractC2339a) i).a(v);
    }

    public static int t(int i, int i2) {
        return L(i) + u(i2);
    }

    public static int u(int i) {
        if (i >= 0) {
            return N(i);
        }
        return 10;
    }

    public static int v(int i, long j) {
        return L(i) + w(j);
    }

    public static int w(long j) {
        return P(j);
    }

    static int x(int i) {
        return N(i) + i;
    }

    static int y(int i, I i2, V v) {
        return L(i) + z(i2, v);
    }

    static int z(I i, V v) {
        return x(((AbstractC2339a) i).a(v));
    }

    public final void A0(int i, long j) {
        G0(i, R(j));
    }

    public final void B0(long j) {
        H0(R(j));
    }

    public abstract void C0(int i, String str);

    public abstract void D0(int i, int i2);

    public abstract void E0(int i, int i2);

    public abstract void F0(int i);

    public abstract void G0(int i, long j);

    public abstract void H0(long j);

    final void S(String str, e0.d dVar) throws OutOfSpaceException {
        c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(AbstractC2360w.b);
        try {
            F0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new OutOfSpaceException(e);
        }
    }

    boolean T() {
        return this.b;
    }

    public abstract int W();

    public abstract void X(byte b2);

    public abstract void Y(int i, boolean z);

    public final void Z(boolean z) {
        X(z ? (byte) 1 : (byte) 0);
    }

    @Override // ir.nasim.AbstractC6189Mo0
    public abstract void a(byte[] bArr, int i, int i2);

    public abstract void a0(int i, AbstractC2345g abstractC2345g);

    public final void b0(int i, double d2) {
        h0(i, Double.doubleToRawLongBits(d2));
    }

    public final void c() {
        if (W() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void c0(double d2) {
        i0(Double.doubleToRawLongBits(d2));
    }

    public final void d0(int i, int i2) {
        n0(i, i2);
    }

    public final void e0(int i) {
        o0(i);
    }

    public abstract void f0(int i, int i2);

    public abstract void g0(int i);

    public abstract void h0(int i, long j);

    public abstract void i0(long j);

    public final void j0(int i, float f) {
        f0(i, Float.floatToRawIntBits(f));
    }

    public final void k0(float f) {
        g0(Float.floatToRawIntBits(f));
    }

    final void l0(int i, I i2, V v) {
        D0(i, 3);
        m0(i2, v);
        D0(i, 4);
    }

    final void m0(I i, V v) {
        v.j(i, this.a);
    }

    public abstract void n0(int i, int i2);

    public abstract void o0(int i);

    public final void p0(int i, long j) {
        G0(i, j);
    }

    public final void q0(long j) {
        H0(j);
    }

    abstract void r0(int i, I i2, V v);

    public abstract void s0(int i, I i2);

    public abstract void t0(int i, AbstractC2345g abstractC2345g);

    public final void u0(int i, int i2) {
        f0(i, i2);
    }

    public final void v0(int i) {
        g0(i);
    }

    public final void w0(int i, long j) {
        h0(i, j);
    }

    public final void x0(long j) {
        i0(j);
    }

    public final void y0(int i, int i2) {
        E0(i, Q(i2));
    }

    public final void z0(int i) {
        F0(Q(i));
    }

    private CodedOutputStream() {
    }
}
