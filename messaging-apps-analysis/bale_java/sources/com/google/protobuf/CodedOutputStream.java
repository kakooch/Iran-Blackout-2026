package com.google.protobuf;

import com.google.protobuf.p0;
import ir.nasim.AbstractC6428No0;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public abstract class CodedOutputStream extends AbstractC6428No0 {
    private static final Logger c = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean d = o0.I();
    C2386j a;
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

    private static abstract class b extends CodedOutputStream {
        final byte[] e;
        final int f;
        int g;
        int h;

        b(int i) {
            super();
            if (i < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i, 20)];
            this.e = bArr;
            this.f = bArr.length;
        }

        final void Y0(byte b) {
            byte[] bArr = this.e;
            int i = this.g;
            this.g = i + 1;
            bArr[i] = b;
            this.h++;
        }

        final void Z0(int i) {
            byte[] bArr = this.e;
            int i2 = this.g;
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >> 16) & 255);
            this.g = i2 + 4;
            bArr[i2 + 3] = (byte) ((i >> 24) & 255);
            this.h += 4;
        }

        final void a1(long j) {
            byte[] bArr = this.e;
            int i = this.g;
            bArr[i] = (byte) (j & 255);
            bArr[i + 1] = (byte) ((j >> 8) & 255);
            bArr[i + 2] = (byte) ((j >> 16) & 255);
            bArr[i + 3] = (byte) (255 & (j >> 24));
            bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
            bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
            bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
            this.g = i + 8;
            bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
            this.h += 8;
        }

        final void b1(int i) {
            if (i >= 0) {
                d1(i);
            } else {
                e1(i);
            }
        }

        final void c1(int i, int i2) {
            d1(r0.c(i, i2));
        }

        final void d1(int i) {
            if (!CodedOutputStream.d) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.e;
                    int i2 = this.g;
                    this.g = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    this.h++;
                    i >>>= 7;
                }
                byte[] bArr2 = this.e;
                int i3 = this.g;
                this.g = i3 + 1;
                bArr2[i3] = (byte) i;
                this.h++;
                return;
            }
            long j = this.g;
            while ((i & (-128)) != 0) {
                byte[] bArr3 = this.e;
                int i4 = this.g;
                this.g = i4 + 1;
                o0.O(bArr3, i4, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            byte[] bArr4 = this.e;
            int i5 = this.g;
            this.g = i5 + 1;
            o0.O(bArr4, i5, (byte) i);
            this.h += (int) (this.g - j);
        }

        final void e1(long j) {
            if (!CodedOutputStream.d) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.e;
                    int i = this.g;
                    this.g = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    this.h++;
                    j >>>= 7;
                }
                byte[] bArr2 = this.e;
                int i2 = this.g;
                this.g = i2 + 1;
                bArr2[i2] = (byte) j;
                this.h++;
                return;
            }
            long j2 = this.g;
            while ((j & (-128)) != 0) {
                byte[] bArr3 = this.e;
                int i3 = this.g;
                this.g = i3 + 1;
                o0.O(bArr3, i3, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr4 = this.e;
            int i4 = this.g;
            this.g = i4 + 1;
            o0.O(bArr4, i4, (byte) j);
            this.h += (int) (this.g - j2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int f0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    private static class c extends CodedOutputStream {
        private final byte[] e;
        private final int f;
        private final int g;
        private int h;

        c(byte[] bArr, int i, int i2) {
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

        @Override // com.google.protobuf.CodedOutputStream
        public final void B0(int i, int i2) throws OutOfSpaceException {
            T0(i, 0);
            C0(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void C0(int i) throws OutOfSpaceException {
            if (i >= 0) {
                V0(i);
            } else {
                X0(i);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void F0(int i, P p, e0 e0Var) throws OutOfSpaceException {
            T0(i, 2);
            V0(((AbstractC2377a) p).getSerializedSize(e0Var));
            e0Var.h(p, this.a);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void G0(P p) throws OutOfSpaceException {
            V0(p.getSerializedSize());
            p.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void H0(int i, P p) throws OutOfSpaceException {
            T0(1, 3);
            U0(2, i);
            a1(3, p);
            T0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void I0(int i, AbstractC2383g abstractC2383g) throws OutOfSpaceException {
            T0(1, 3);
            U0(2, i);
            l0(3, abstractC2383g);
            T0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void R0(int i, String str) throws OutOfSpaceException {
            T0(i, 2);
            S0(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void S0(String str) throws OutOfSpaceException {
            int i = this.h;
            try {
                int iU = CodedOutputStream.U(str.length() * 3);
                int iU2 = CodedOutputStream.U(str.length());
                if (iU2 == iU) {
                    int i2 = i + iU2;
                    this.h = i2;
                    int i3 = p0.i(str, this.e, i2, f0());
                    this.h = i;
                    V0((i3 - i) - iU2);
                    this.h = i3;
                } else {
                    V0(p0.j(str));
                    this.h = p0.i(str, this.e, this.h, f0());
                }
            } catch (p0.d e) {
                this.h = i;
                a0(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void T0(int i, int i2) throws OutOfSpaceException {
            V0(r0.c(i, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void U0(int i, int i2) throws OutOfSpaceException {
            T0(i, 0);
            V0(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void V0(int i) throws OutOfSpaceException {
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

        @Override // com.google.protobuf.CodedOutputStream
        public final void W0(int i, long j) throws OutOfSpaceException {
            T0(i, 0);
            X0(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void X0(long j) throws OutOfSpaceException {
            if (CodedOutputStream.d && f0() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.e;
                    int i = this.h;
                    this.h = i + 1;
                    o0.O(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.e;
                int i2 = this.h;
                this.h = i2 + 1;
                o0.O(bArr2, i2, (byte) j);
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

        public final void Y0(ByteBuffer byteBuffer) throws OutOfSpaceException {
            int iRemaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.e, this.h, iRemaining);
                this.h += iRemaining;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.h), Integer.valueOf(this.g), Integer.valueOf(iRemaining)), e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void Z() {
        }

        public final void Z0(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            try {
                System.arraycopy(bArr, i, this.e, this.h, i2);
                this.h += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.h), Integer.valueOf(this.g), Integer.valueOf(i2)), e);
            }
        }

        @Override // ir.nasim.AbstractC6428No0
        public final void a(ByteBuffer byteBuffer) throws OutOfSpaceException {
            Y0(byteBuffer);
        }

        public final void a1(int i, P p) throws OutOfSpaceException {
            T0(i, 2);
            G0(p);
        }

        @Override // com.google.protobuf.CodedOutputStream, ir.nasim.AbstractC6428No0
        public final void b(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            Z0(bArr, i, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int f0() {
            return this.g - this.h;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void g0(byte b) throws OutOfSpaceException {
            try {
                byte[] bArr = this.e;
                int i = this.h;
                this.h = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.h), Integer.valueOf(this.g), 1), e);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void h0(int i, boolean z) throws OutOfSpaceException {
            T0(i, 0);
            g0(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void k0(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            V0(i2);
            Z0(bArr, i, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void l0(int i, AbstractC2383g abstractC2383g) throws OutOfSpaceException {
            T0(i, 2);
            m0(abstractC2383g);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void m0(AbstractC2383g abstractC2383g) throws OutOfSpaceException {
            V0(abstractC2383g.size());
            abstractC2383g.k0(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void r0(int i, int i2) throws OutOfSpaceException {
            T0(i, 5);
            s0(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void s0(int i) throws OutOfSpaceException {
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

        @Override // com.google.protobuf.CodedOutputStream
        public final void t0(int i, long j) throws OutOfSpaceException {
            T0(i, 1);
            u0(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void u0(long j) throws OutOfSpaceException {
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
    }

    private static final class d extends b {
        private final OutputStream i;

        d(OutputStream outputStream, int i) {
            super(i);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.i = outputStream;
        }

        private void f1() throws IOException {
            this.i.write(this.e, 0, this.g);
            this.g = 0;
        }

        private void g1(int i) throws IOException {
            if (this.f - this.g < i) {
                f1();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void B0(int i, int i2) throws IOException {
            g1(20);
            c1(i, 0);
            b1(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void C0(int i) throws IOException {
            if (i >= 0) {
                V0(i);
            } else {
                X0(i);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        void F0(int i, P p, e0 e0Var) throws IOException {
            T0(i, 2);
            k1(p, e0Var);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void G0(P p) throws IOException {
            V0(p.getSerializedSize());
            p.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void H0(int i, P p) throws IOException {
            T0(1, 3);
            U0(2, i);
            j1(3, p);
            T0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void I0(int i, AbstractC2383g abstractC2383g) throws IOException {
            T0(1, 3);
            U0(2, i);
            l0(3, abstractC2383g);
            T0(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void R0(int i, String str) throws IOException {
            T0(i, 2);
            S0(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void S0(String str) throws IOException {
            int iJ;
            try {
                int length = str.length() * 3;
                int iU = CodedOutputStream.U(length);
                int i = iU + length;
                int i2 = this.f;
                if (i > i2) {
                    byte[] bArr = new byte[length];
                    int i3 = p0.i(str, bArr, 0, length);
                    V0(i3);
                    b(bArr, 0, i3);
                    return;
                }
                if (i > i2 - this.g) {
                    f1();
                }
                int iU2 = CodedOutputStream.U(str.length());
                int i4 = this.g;
                try {
                    if (iU2 == iU) {
                        int i5 = i4 + iU2;
                        this.g = i5;
                        int i6 = p0.i(str, this.e, i5, this.f - i5);
                        this.g = i4;
                        iJ = (i6 - i4) - iU2;
                        d1(iJ);
                        this.g = i6;
                    } else {
                        iJ = p0.j(str);
                        d1(iJ);
                        this.g = p0.i(str, this.e, this.g, iJ);
                    }
                    this.h += iJ;
                } catch (p0.d e) {
                    this.h -= this.g - i4;
                    this.g = i4;
                    throw e;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(e2);
                }
            } catch (p0.d e3) {
                a0(str, e3);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void T0(int i, int i2) throws IOException {
            V0(r0.c(i, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void U0(int i, int i2) throws IOException {
            g1(20);
            c1(i, 0);
            d1(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void V0(int i) throws IOException {
            g1(5);
            d1(i);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void W0(int i, long j) throws IOException {
            g1(20);
            c1(i, 0);
            e1(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void X0(long j) throws IOException {
            g1(10);
            e1(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void Z() throws IOException {
            if (this.g > 0) {
                f1();
            }
        }

        @Override // ir.nasim.AbstractC6428No0
        public void a(ByteBuffer byteBuffer) throws IOException {
            h1(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream, ir.nasim.AbstractC6428No0
        public void b(byte[] bArr, int i, int i2) throws IOException {
            i1(bArr, i, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void g0(byte b) throws IOException {
            if (this.g == this.f) {
                f1();
            }
            Y0(b);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void h0(int i, boolean z) throws IOException {
            g1(11);
            c1(i, 0);
            Y0(z ? (byte) 1 : (byte) 0);
        }

        public void h1(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            int i = this.f;
            int i2 = this.g;
            if (i - i2 >= iRemaining) {
                byteBuffer.get(this.e, i2, iRemaining);
                this.g += iRemaining;
                this.h += iRemaining;
                return;
            }
            int i3 = i - i2;
            byteBuffer.get(this.e, i2, i3);
            int i4 = iRemaining - i3;
            this.g = this.f;
            this.h += i3;
            f1();
            while (true) {
                int i5 = this.f;
                if (i4 <= i5) {
                    byteBuffer.get(this.e, 0, i4);
                    this.g = i4;
                    this.h += i4;
                    return;
                } else {
                    byteBuffer.get(this.e, 0, i5);
                    this.i.write(this.e, 0, this.f);
                    int i6 = this.f;
                    i4 -= i6;
                    this.h += i6;
                }
            }
        }

        public void i1(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.f;
            int i4 = this.g;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.e, i4, i2);
                this.g += i2;
                this.h += i2;
                return;
            }
            int i5 = i3 - i4;
            System.arraycopy(bArr, i, this.e, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.g = this.f;
            this.h += i5;
            f1();
            if (i7 <= this.f) {
                System.arraycopy(bArr, i6, this.e, 0, i7);
                this.g = i7;
            } else {
                this.i.write(bArr, i6, i7);
            }
            this.h += i7;
        }

        public void j1(int i, P p) throws IOException {
            T0(i, 2);
            G0(p);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void k0(byte[] bArr, int i, int i2) throws IOException {
            V0(i2);
            i1(bArr, i, i2);
        }

        void k1(P p, e0 e0Var) throws IOException {
            V0(((AbstractC2377a) p).getSerializedSize(e0Var));
            e0Var.h(p, this.a);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void l0(int i, AbstractC2383g abstractC2383g) throws IOException {
            T0(i, 2);
            m0(abstractC2383g);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void m0(AbstractC2383g abstractC2383g) throws IOException {
            V0(abstractC2383g.size());
            abstractC2383g.k0(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void r0(int i, int i2) throws IOException {
            g1(14);
            c1(i, 5);
            Z0(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void s0(int i) throws IOException {
            g1(4);
            Z0(i);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void t0(int i, long j) throws IOException {
            g1(18);
            c1(i, 1);
            a1(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void u0(long j) throws IOException {
            g1(8);
            a1(j);
        }
    }

    static int A(int i) {
        return U(i) + i;
    }

    public static int B(int i, P p) {
        return (S(1) * 2) + T(2, i) + C(3, p);
    }

    public static int C(int i, P p) {
        return S(i) + E(p);
    }

    static int D(int i, P p, e0 e0Var) {
        return S(i) + F(p, e0Var);
    }

    public static int E(P p) {
        return A(p.getSerializedSize());
    }

    static int F(P p, e0 e0Var) {
        return A(((AbstractC2377a) p).getSerializedSize(e0Var));
    }

    static int G(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int H(int i, AbstractC2383g abstractC2383g) {
        return (S(1) * 2) + T(2, i) + h(3, abstractC2383g);
    }

    public static int I(int i, int i2) {
        return S(i) + J(i2);
    }

    public static int J(int i) {
        return 4;
    }

    public static int K(int i, long j) {
        return S(i) + L(j);
    }

    public static int L(long j) {
        return 8;
    }

    public static int M(int i, int i2) {
        return S(i) + N(i2);
    }

    public static int N(int i) {
        return U(X(i));
    }

    public static int O(int i, long j) {
        return S(i) + P(j);
    }

    public static int P(long j) {
        return W(Y(j));
    }

    public static int Q(int i, String str) {
        return S(i) + R(str);
    }

    public static int R(String str) {
        int length;
        try {
            length = p0.j(str);
        } catch (p0.d unused) {
            length = str.getBytes(B.b).length;
        }
        return A(length);
    }

    public static int S(int i) {
        return U(r0.c(i, 0));
    }

    public static int T(int i, int i2) {
        return S(i) + U(i2);
    }

    public static int U(int i) {
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

    public static int V(int i, long j) {
        return S(i) + W(j);
    }

    public static int W(long j) {
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

    public static int X(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long Y(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static CodedOutputStream c0(OutputStream outputStream, int i) {
        return new d(outputStream, i);
    }

    public static CodedOutputStream d0(byte[] bArr) {
        return e0(bArr, 0, bArr.length);
    }

    public static int e(int i, boolean z) {
        return S(i) + f(z);
    }

    public static CodedOutputStream e0(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    public static int f(boolean z) {
        return 1;
    }

    public static int g(byte[] bArr) {
        return A(bArr.length);
    }

    public static int h(int i, AbstractC2383g abstractC2383g) {
        return S(i) + i(abstractC2383g);
    }

    public static int i(AbstractC2383g abstractC2383g) {
        return A(abstractC2383g.size());
    }

    public static int j(int i, double d2) {
        return S(i) + k(d2);
    }

    public static int k(double d2) {
        return 8;
    }

    public static int l(int i, int i2) {
        return S(i) + m(i2);
    }

    public static int m(int i) {
        return x(i);
    }

    public static int n(int i, int i2) {
        return S(i) + o(i2);
    }

    public static int o(int i) {
        return 4;
    }

    public static int p(int i, long j) {
        return S(i) + q(j);
    }

    public static int q(long j) {
        return 8;
    }

    public static int r(int i, float f) {
        return S(i) + s(f);
    }

    public static int s(float f) {
        return 4;
    }

    static int t(int i, P p, e0 e0Var) {
        return (S(i) * 2) + v(p, e0Var);
    }

    public static int u(P p) {
        return p.getSerializedSize();
    }

    static int v(P p, e0 e0Var) {
        return ((AbstractC2377a) p).getSerializedSize(e0Var);
    }

    public static int w(int i, int i2) {
        return S(i) + x(i2);
    }

    public static int x(int i) {
        if (i >= 0) {
            return U(i);
        }
        return 10;
    }

    public static int y(int i, long j) {
        return S(i) + z(j);
    }

    public static int z(long j) {
        return W(j);
    }

    final void A0(P p, e0 e0Var) {
        e0Var.h(p, this.a);
    }

    public abstract void B0(int i, int i2);

    public abstract void C0(int i);

    public final void D0(int i, long j) {
        W0(i, j);
    }

    public final void E0(long j) {
        X0(j);
    }

    abstract void F0(int i, P p, e0 e0Var);

    public abstract void G0(P p);

    public abstract void H0(int i, P p);

    public abstract void I0(int i, AbstractC2383g abstractC2383g);

    public final void J0(int i, int i2) {
        r0(i, i2);
    }

    public final void K0(int i) {
        s0(i);
    }

    public final void L0(int i, long j) {
        t0(i, j);
    }

    public final void M0(long j) {
        u0(j);
    }

    public final void N0(int i, int i2) {
        U0(i, X(i2));
    }

    public final void O0(int i) {
        V0(X(i));
    }

    public final void P0(int i, long j) {
        W0(i, Y(j));
    }

    public final void Q0(long j) {
        X0(Y(j));
    }

    public abstract void R0(int i, String str);

    public abstract void S0(String str);

    public abstract void T0(int i, int i2);

    public abstract void U0(int i, int i2);

    public abstract void V0(int i);

    public abstract void W0(int i, long j);

    public abstract void X0(long j);

    public abstract void Z();

    final void a0(String str, p0.d dVar) throws OutOfSpaceException {
        c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(B.b);
        try {
            V0(bytes.length);
            b(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new OutOfSpaceException(e);
        }
    }

    @Override // ir.nasim.AbstractC6428No0
    public abstract void b(byte[] bArr, int i, int i2);

    boolean b0() {
        return this.b;
    }

    public final void d() {
        if (f0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract int f0();

    public abstract void g0(byte b2);

    public abstract void h0(int i, boolean z);

    public final void i0(boolean z) {
        g0(z ? (byte) 1 : (byte) 0);
    }

    public final void j0(byte[] bArr) {
        k0(bArr, 0, bArr.length);
    }

    abstract void k0(byte[] bArr, int i, int i2);

    public abstract void l0(int i, AbstractC2383g abstractC2383g);

    public abstract void m0(AbstractC2383g abstractC2383g);

    public final void n0(int i, double d2) {
        t0(i, Double.doubleToRawLongBits(d2));
    }

    public final void o0(double d2) {
        u0(Double.doubleToRawLongBits(d2));
    }

    public final void p0(int i, int i2) {
        B0(i, i2);
    }

    public final void q0(int i) {
        C0(i);
    }

    public abstract void r0(int i, int i2);

    public abstract void s0(int i);

    public abstract void t0(int i, long j);

    public abstract void u0(long j);

    public final void v0(int i, float f) {
        r0(i, Float.floatToRawIntBits(f));
    }

    public final void w0(float f) {
        s0(Float.floatToRawIntBits(f));
    }

    public final void x0(int i, P p) {
        T0(i, 3);
        z0(p);
        T0(i, 4);
    }

    final void y0(int i, P p, e0 e0Var) {
        T0(i, 3);
        A0(p, e0Var);
        T0(i, 4);
    }

    public final void z0(P p) {
        p.writeTo(this);
    }

    private CodedOutputStream() {
    }
}
