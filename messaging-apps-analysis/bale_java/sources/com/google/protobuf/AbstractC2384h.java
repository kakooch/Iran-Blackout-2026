package com.google.protobuf;

import com.google.protobuf.P;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.protobuf.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2384h {
    private static volatile int f = 100;
    int a;
    int b;
    int c;
    C2385i d;
    private boolean e;

    /* renamed from: com.google.protobuf.h$b */
    private static final class b extends AbstractC2384h {
        private final byte[] g;
        private final boolean h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private boolean n;
        private int o;

        private void T() {
            int i = this.i + this.j;
            this.i = i;
            int i2 = i - this.l;
            int i3 = this.o;
            if (i2 <= i3) {
                this.j = 0;
                return;
            }
            int i4 = i2 - i3;
            this.j = i4;
            this.i = i - i4;
        }

        private void W() throws InvalidProtocolBufferException {
            if (this.i - this.k >= 10) {
                X();
            } else {
                Y();
            }
        }

        private void X() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.g;
                int i2 = this.k;
                this.k = i2 + 1;
                if (bArr[i2] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void Y() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (N() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public void A(P.a aVar, C2394s c2394s) throws InvalidProtocolBufferException {
            int iB = B();
            b();
            int iP = p(iB);
            this.a++;
            aVar.h(this, c2394s);
            a(0);
            this.a--;
            if (e() != 0) {
                throw InvalidProtocolBufferException.p();
            }
            o(iP);
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int B() {
            int i;
            int i2 = this.k;
            int i3 = this.i;
            if (i3 != i2) {
                byte[] bArr = this.g;
                int i4 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.k = i4;
                    return b;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    int i6 = (bArr[i4] << 7) ^ b;
                    if (i6 < 0) {
                        i = i6 ^ (-128);
                    } else {
                        int i7 = i2 + 3;
                        int i8 = (bArr[i5] << 14) ^ i6;
                        if (i8 >= 0) {
                            i = i8 ^ 16256;
                        } else {
                            int i9 = i2 + 4;
                            int i10 = i8 ^ (bArr[i7] << 21);
                            if (i10 < 0) {
                                i = (-2080896) ^ i10;
                            } else {
                                i7 = i2 + 5;
                                byte b2 = bArr[i9];
                                int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i9 = i2 + 6;
                                    if (bArr[i7] < 0) {
                                        i7 = i2 + 7;
                                        if (bArr[i9] < 0) {
                                            i9 = i2 + 8;
                                            if (bArr[i7] < 0) {
                                                i7 = i2 + 9;
                                                if (bArr[i9] < 0) {
                                                    int i12 = i2 + 10;
                                                    if (bArr[i7] >= 0) {
                                                        i5 = i12;
                                                        i = i11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i11;
                                }
                                i = i11;
                            }
                            i5 = i9;
                        }
                        i5 = i7;
                    }
                    this.k = i5;
                    return i;
                }
            }
            return (int) S();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int D() {
            return P();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long E() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int F() {
            return AbstractC2384h.c(B());
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long G() {
            return AbstractC2384h.d(R());
        }

        @Override // com.google.protobuf.AbstractC2384h
        public String H() throws InvalidProtocolBufferException {
            int iB = B();
            if (iB > 0) {
                int i = this.i;
                int i2 = this.k;
                if (iB <= i - i2) {
                    String str = new String(this.g, i2, iB, B.b);
                    this.k += iB;
                    return str;
                }
            }
            if (iB == 0) {
                return "";
            }
            if (iB < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.p();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public String I() throws InvalidProtocolBufferException {
            int iB = B();
            if (iB > 0) {
                int i = this.i;
                int i2 = this.k;
                if (iB <= i - i2) {
                    String strH = p0.h(this.g, i2, iB);
                    this.k += iB;
                    return strH;
                }
            }
            if (iB == 0) {
                return "";
            }
            if (iB <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.p();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int J() throws InvalidProtocolBufferException {
            if (g()) {
                this.m = 0;
                return 0;
            }
            int iB = B();
            this.m = iB;
            if (r0.a(iB) != 0) {
                return this.m;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int K() {
            return B();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long L() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public boolean M(int i) throws InvalidProtocolBufferException {
            int iB = r0.b(i);
            if (iB == 0) {
                W();
                return true;
            }
            if (iB == 1) {
                V(8);
                return true;
            }
            if (iB == 2) {
                V(B());
                return true;
            }
            if (iB == 3) {
                U();
                a(r0.c(r0.a(i), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            V(4);
            return true;
        }

        public byte N() throws InvalidProtocolBufferException {
            int i = this.k;
            if (i == this.i) {
                throw InvalidProtocolBufferException.p();
            }
            byte[] bArr = this.g;
            this.k = i + 1;
            return bArr[i];
        }

        public byte[] O(int i) throws InvalidProtocolBufferException {
            if (i > 0) {
                int i2 = this.i;
                int i3 = this.k;
                if (i <= i2 - i3) {
                    int i4 = i + i3;
                    this.k = i4;
                    return Arrays.copyOfRange(this.g, i3, i4);
                }
            }
            if (i > 0) {
                throw InvalidProtocolBufferException.p();
            }
            if (i == 0) {
                return B.d;
            }
            throw InvalidProtocolBufferException.g();
        }

        public int P() throws InvalidProtocolBufferException {
            int i = this.k;
            if (this.i - i < 4) {
                throw InvalidProtocolBufferException.p();
            }
            byte[] bArr = this.g;
            this.k = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        public long Q() throws InvalidProtocolBufferException {
            int i = this.k;
            if (this.i - i < 8) {
                throw InvalidProtocolBufferException.p();
            }
            byte[] bArr = this.g;
            this.k = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        public long R() {
            long j;
            long j2;
            long j3;
            int i = this.k;
            int i2 = this.i;
            if (i2 != i) {
                byte[] bArr = this.g;
                int i3 = i + 1;
                byte b = bArr[i];
                if (b >= 0) {
                    this.k = i3;
                    return b;
                }
                if (i2 - i3 >= 9) {
                    int i4 = i + 2;
                    int i5 = (bArr[i3] << 7) ^ b;
                    if (i5 < 0) {
                        j = i5 ^ (-128);
                    } else {
                        int i6 = i + 3;
                        int i7 = (bArr[i4] << 14) ^ i5;
                        if (i7 >= 0) {
                            j = i7 ^ 16256;
                            i4 = i6;
                        } else {
                            int i8 = i + 4;
                            int i9 = i7 ^ (bArr[i6] << 21);
                            if (i9 < 0) {
                                long j4 = (-2080896) ^ i9;
                                i4 = i8;
                                j = j4;
                            } else {
                                long j5 = i9;
                                i4 = i + 5;
                                long j6 = j5 ^ (bArr[i8] << 28);
                                if (j6 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    int i10 = i + 6;
                                    long j7 = j6 ^ (bArr[i4] << 35);
                                    if (j7 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        i4 = i + 7;
                                        j6 = j7 ^ (bArr[i10] << 42);
                                        if (j6 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            i10 = i + 8;
                                            j7 = j6 ^ (bArr[i4] << 49);
                                            if (j7 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                i4 = i + 9;
                                                long j8 = (j7 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                                if (j8 < 0) {
                                                    int i11 = i + 10;
                                                    if (bArr[i4] >= 0) {
                                                        i4 = i11;
                                                    }
                                                }
                                                j = j8;
                                            }
                                        }
                                    }
                                    j = j7 ^ j2;
                                    i4 = i10;
                                }
                                j = j6 ^ j3;
                            }
                        }
                    }
                    this.k = i4;
                    return j;
                }
            }
            return S();
        }

        long S() throws InvalidProtocolBufferException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & 127) << i;
                if ((N() & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public void U() throws InvalidProtocolBufferException {
            int iJ;
            do {
                iJ = J();
                if (iJ == 0) {
                    return;
                }
            } while (M(iJ));
        }

        public void V(int i) throws InvalidProtocolBufferException {
            if (i >= 0) {
                int i2 = this.i;
                int i3 = this.k;
                if (i <= i2 - i3) {
                    this.k = i3 + i;
                    return;
                }
            }
            if (i >= 0) {
                throw InvalidProtocolBufferException.p();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public void a(int i) throws InvalidProtocolBufferException {
            if (this.m != i) {
                throw InvalidProtocolBufferException.b();
            }
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int e() {
            int i = this.o;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - f();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int f() {
            return this.k - this.l;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public boolean g() {
            return this.k == this.i;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public void o(int i) {
            this.o = i;
            T();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int p(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int iF = i + f();
            if (iF < 0) {
                throw InvalidProtocolBufferException.j();
            }
            int i2 = this.o;
            if (iF > i2) {
                throw InvalidProtocolBufferException.p();
            }
            this.o = iF;
            T();
            return i2;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public boolean q() {
            return R() != 0;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public AbstractC2383g r() {
            int iB = B();
            if (iB > 0) {
                int i = this.i;
                int i2 = this.k;
                if (iB <= i - i2) {
                    AbstractC2383g abstractC2383gJ0 = (this.h && this.n) ? AbstractC2383g.j0(this.g, i2, iB) : AbstractC2383g.L(this.g, i2, iB);
                    this.k += iB;
                    return abstractC2383gJ0;
                }
            }
            return iB == 0 ? AbstractC2383g.b : AbstractC2383g.i0(O(iB));
        }

        @Override // com.google.protobuf.AbstractC2384h
        public double s() {
            return Double.longBitsToDouble(Q());
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int t() {
            return B();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int u() {
            return P();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long v() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public float w() {
            return Float.intBitsToFloat(P());
        }

        @Override // com.google.protobuf.AbstractC2384h
        public void x(int i, P.a aVar, C2394s c2394s) throws InvalidProtocolBufferException {
            b();
            this.a++;
            aVar.h(this, c2394s);
            a(r0.c(i, 4));
            this.a--;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int y() {
            return B();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long z() {
            return R();
        }

        private b(byte[] bArr, int i, int i2, boolean z) {
            super();
            this.o = Integer.MAX_VALUE;
            this.g = bArr;
            this.i = i2 + i;
            this.k = i;
            this.l = i;
            this.h = z;
        }
    }

    /* renamed from: com.google.protobuf.h$c */
    private static final class c extends AbstractC2384h {
        private final InputStream g;
        private final byte[] h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;

        private static int N(InputStream inputStream) throws InvalidProtocolBufferException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e) {
                e.l();
                throw e;
            }
        }

        private static int O(InputStream inputStream, byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            try {
                return inputStream.read(bArr, i, i2);
            } catch (InvalidProtocolBufferException e) {
                e.l();
                throw e;
            }
        }

        private AbstractC2383g P(int i) throws IOException {
            byte[] bArrS = S(i);
            if (bArrS != null) {
                return AbstractC2383g.F(bArrS);
            }
            int i2 = this.k;
            int i3 = this.i;
            int length = i3 - i2;
            this.m += i3;
            this.k = 0;
            this.i = 0;
            List<byte[]> listT = T(i - length);
            byte[] bArr = new byte[i];
            System.arraycopy(this.h, i2, bArr, 0, length);
            for (byte[] bArr2 : listT) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return AbstractC2383g.i0(bArr);
        }

        private byte[] R(int i, boolean z) throws IOException {
            byte[] bArrS = S(i);
            if (bArrS != null) {
                return z ? (byte[]) bArrS.clone() : bArrS;
            }
            int i2 = this.k;
            int i3 = this.i;
            int length = i3 - i2;
            this.m += i3;
            this.k = 0;
            this.i = 0;
            List<byte[]> listT = T(i - length);
            byte[] bArr = new byte[i];
            System.arraycopy(this.h, i2, bArr, 0, length);
            for (byte[] bArr2 : listT) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        private byte[] S(int i) throws InvalidProtocolBufferException {
            if (i == 0) {
                return B.d;
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int i2 = this.m;
            int i3 = this.k;
            int i4 = i2 + i3 + i;
            if (i4 - this.c > 0) {
                throw InvalidProtocolBufferException.n();
            }
            int i5 = this.n;
            if (i4 > i5) {
                c0((i5 - i2) - i3);
                throw InvalidProtocolBufferException.p();
            }
            int i6 = this.i - i3;
            int i7 = i - i6;
            if (i7 >= 4096 && i7 > N(this.g)) {
                return null;
            }
            byte[] bArr = new byte[i];
            System.arraycopy(this.h, this.k, bArr, 0, i6);
            this.m += this.i;
            this.k = 0;
            this.i = 0;
            while (i6 < i) {
                int iO = O(this.g, bArr, i6, i - i6);
                if (iO == -1) {
                    throw InvalidProtocolBufferException.p();
                }
                this.m += iO;
                i6 += iO;
            }
            return bArr;
        }

        private List T(int i) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i > 0) {
                int iMin = Math.min(i, 4096);
                byte[] bArr = new byte[iMin];
                int i2 = 0;
                while (i2 < iMin) {
                    int i3 = this.g.read(bArr, i2, iMin - i2);
                    if (i3 == -1) {
                        throw InvalidProtocolBufferException.p();
                    }
                    this.m += i3;
                    i2 += i3;
                }
                i -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void Y() {
            int i = this.i + this.j;
            this.i = i;
            int i2 = this.m + i;
            int i3 = this.n;
            if (i2 <= i3) {
                this.j = 0;
                return;
            }
            int i4 = i2 - i3;
            this.j = i4;
            this.i = i - i4;
        }

        private void Z(int i) throws InvalidProtocolBufferException {
            if (h0(i)) {
                return;
            }
            if (i <= (this.c - this.m) - this.k) {
                throw InvalidProtocolBufferException.p();
            }
            throw InvalidProtocolBufferException.n();
        }

        private static long a0(InputStream inputStream, long j) throws InvalidProtocolBufferException {
            try {
                return inputStream.skip(j);
            } catch (InvalidProtocolBufferException e) {
                e.l();
                throw e;
            }
        }

        private void d0(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int i2 = this.m;
            int i3 = this.k;
            int i4 = i2 + i3 + i;
            int i5 = this.n;
            if (i4 > i5) {
                c0((i5 - i2) - i3);
                throw InvalidProtocolBufferException.p();
            }
            this.m = i2 + i3;
            int i6 = this.i - i3;
            this.i = 0;
            this.k = 0;
            while (i6 < i) {
                try {
                    long j = i - i6;
                    long jA0 = a0(this.g, j);
                    if (jA0 < 0 || jA0 > j) {
                        throw new IllegalStateException(this.g.getClass() + "#skip returned invalid result: " + jA0 + "\nThe InputStream implementation is buggy.");
                    }
                    if (jA0 == 0) {
                        break;
                    } else {
                        i6 += (int) jA0;
                    }
                } finally {
                    this.m += i6;
                    Y();
                }
            }
            if (i6 >= i) {
                return;
            }
            int i7 = this.i;
            int i8 = i7 - this.k;
            this.k = i7;
            Z(1);
            while (true) {
                int i9 = i - i8;
                int i10 = this.i;
                if (i9 <= i10) {
                    this.k = i9;
                    return;
                } else {
                    i8 += i10;
                    this.k = i10;
                    Z(1);
                }
            }
        }

        private void e0() throws InvalidProtocolBufferException {
            if (this.i - this.k >= 10) {
                f0();
            } else {
                g0();
            }
        }

        private void f0() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.h;
                int i2 = this.k;
                this.k = i2 + 1;
                if (bArr[i2] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void g0() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (Q() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private boolean h0(int i) throws InvalidProtocolBufferException {
            int i2 = this.k;
            int i3 = i2 + i;
            int i4 = this.i;
            if (i3 <= i4) {
                throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
            }
            int i5 = this.c;
            int i6 = this.m;
            if (i > (i5 - i6) - i2 || i6 + i2 + i > this.n) {
                return false;
            }
            if (i2 > 0) {
                if (i4 > i2) {
                    byte[] bArr = this.h;
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                this.m += i2;
                this.i -= i2;
                this.k = 0;
            }
            InputStream inputStream = this.g;
            byte[] bArr2 = this.h;
            int i7 = this.i;
            int iO = O(inputStream, bArr2, i7, Math.min(bArr2.length - i7, (this.c - this.m) - i7));
            if (iO == 0 || iO < -1 || iO > this.h.length) {
                throw new IllegalStateException(this.g.getClass() + "#read(byte[]) returned invalid result: " + iO + "\nThe InputStream implementation is buggy.");
            }
            if (iO <= 0) {
                return false;
            }
            this.i += iO;
            Y();
            if (this.i >= i) {
                return true;
            }
            return h0(i);
        }

        @Override // com.google.protobuf.AbstractC2384h
        public void A(P.a aVar, C2394s c2394s) throws InvalidProtocolBufferException {
            int iB = B();
            b();
            int iP = p(iB);
            this.a++;
            aVar.h(this, c2394s);
            a(0);
            this.a--;
            if (e() != 0) {
                throw InvalidProtocolBufferException.p();
            }
            o(iP);
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int B() {
            int i;
            int i2 = this.k;
            int i3 = this.i;
            if (i3 != i2) {
                byte[] bArr = this.h;
                int i4 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.k = i4;
                    return b;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    int i6 = (bArr[i4] << 7) ^ b;
                    if (i6 < 0) {
                        i = i6 ^ (-128);
                    } else {
                        int i7 = i2 + 3;
                        int i8 = (bArr[i5] << 14) ^ i6;
                        if (i8 >= 0) {
                            i = i8 ^ 16256;
                        } else {
                            int i9 = i2 + 4;
                            int i10 = i8 ^ (bArr[i7] << 21);
                            if (i10 < 0) {
                                i = (-2080896) ^ i10;
                            } else {
                                i7 = i2 + 5;
                                byte b2 = bArr[i9];
                                int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i9 = i2 + 6;
                                    if (bArr[i7] < 0) {
                                        i7 = i2 + 7;
                                        if (bArr[i9] < 0) {
                                            i9 = i2 + 8;
                                            if (bArr[i7] < 0) {
                                                i7 = i2 + 9;
                                                if (bArr[i9] < 0) {
                                                    int i12 = i2 + 10;
                                                    if (bArr[i7] >= 0) {
                                                        i5 = i12;
                                                        i = i11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i11;
                                }
                                i = i11;
                            }
                            i5 = i9;
                        }
                        i5 = i7;
                    }
                    this.k = i5;
                    return i;
                }
            }
            return (int) X();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int D() {
            return U();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long E() {
            return V();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int F() {
            return AbstractC2384h.c(B());
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long G() {
            return AbstractC2384h.d(W());
        }

        @Override // com.google.protobuf.AbstractC2384h
        public String H() throws InvalidProtocolBufferException {
            int iB = B();
            if (iB > 0) {
                int i = this.i;
                int i2 = this.k;
                if (iB <= i - i2) {
                    String str = new String(this.h, i2, iB, B.b);
                    this.k += iB;
                    return str;
                }
            }
            if (iB == 0) {
                return "";
            }
            if (iB > this.i) {
                return new String(R(iB, false), B.b);
            }
            Z(iB);
            String str2 = new String(this.h, this.k, iB, B.b);
            this.k += iB;
            return str2;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public String I() throws IOException {
            byte[] bArrR;
            int iB = B();
            int i = this.k;
            int i2 = this.i;
            if (iB <= i2 - i && iB > 0) {
                bArrR = this.h;
                this.k = i + iB;
            } else {
                if (iB == 0) {
                    return "";
                }
                i = 0;
                if (iB <= i2) {
                    Z(iB);
                    bArrR = this.h;
                    this.k = iB;
                } else {
                    bArrR = R(iB, false);
                }
            }
            return p0.h(bArrR, i, iB);
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int J() throws InvalidProtocolBufferException {
            if (g()) {
                this.l = 0;
                return 0;
            }
            int iB = B();
            this.l = iB;
            if (r0.a(iB) != 0) {
                return this.l;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int K() {
            return B();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long L() {
            return W();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public boolean M(int i) throws InvalidProtocolBufferException {
            int iB = r0.b(i);
            if (iB == 0) {
                e0();
                return true;
            }
            if (iB == 1) {
                c0(8);
                return true;
            }
            if (iB == 2) {
                c0(B());
                return true;
            }
            if (iB == 3) {
                b0();
                a(r0.c(r0.a(i), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            c0(4);
            return true;
        }

        public byte Q() throws InvalidProtocolBufferException {
            if (this.k == this.i) {
                Z(1);
            }
            byte[] bArr = this.h;
            int i = this.k;
            this.k = i + 1;
            return bArr[i];
        }

        public int U() throws InvalidProtocolBufferException {
            int i = this.k;
            if (this.i - i < 4) {
                Z(4);
                i = this.k;
            }
            byte[] bArr = this.h;
            this.k = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        public long V() throws InvalidProtocolBufferException {
            int i = this.k;
            if (this.i - i < 8) {
                Z(8);
                i = this.k;
            }
            byte[] bArr = this.h;
            this.k = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        public long W() {
            long j;
            long j2;
            long j3;
            int i = this.k;
            int i2 = this.i;
            if (i2 != i) {
                byte[] bArr = this.h;
                int i3 = i + 1;
                byte b = bArr[i];
                if (b >= 0) {
                    this.k = i3;
                    return b;
                }
                if (i2 - i3 >= 9) {
                    int i4 = i + 2;
                    int i5 = (bArr[i3] << 7) ^ b;
                    if (i5 < 0) {
                        j = i5 ^ (-128);
                    } else {
                        int i6 = i + 3;
                        int i7 = (bArr[i4] << 14) ^ i5;
                        if (i7 >= 0) {
                            j = i7 ^ 16256;
                            i4 = i6;
                        } else {
                            int i8 = i + 4;
                            int i9 = i7 ^ (bArr[i6] << 21);
                            if (i9 < 0) {
                                long j4 = (-2080896) ^ i9;
                                i4 = i8;
                                j = j4;
                            } else {
                                long j5 = i9;
                                i4 = i + 5;
                                long j6 = j5 ^ (bArr[i8] << 28);
                                if (j6 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    int i10 = i + 6;
                                    long j7 = j6 ^ (bArr[i4] << 35);
                                    if (j7 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        i4 = i + 7;
                                        j6 = j7 ^ (bArr[i10] << 42);
                                        if (j6 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            i10 = i + 8;
                                            j7 = j6 ^ (bArr[i4] << 49);
                                            if (j7 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                i4 = i + 9;
                                                long j8 = (j7 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                                if (j8 < 0) {
                                                    int i11 = i + 10;
                                                    if (bArr[i4] >= 0) {
                                                        i4 = i11;
                                                    }
                                                }
                                                j = j8;
                                            }
                                        }
                                    }
                                    j = j7 ^ j2;
                                    i4 = i10;
                                }
                                j = j6 ^ j3;
                            }
                        }
                    }
                    this.k = i4;
                    return j;
                }
            }
            return X();
        }

        long X() throws InvalidProtocolBufferException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & 127) << i;
                if ((Q() & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public void a(int i) throws InvalidProtocolBufferException {
            if (this.l != i) {
                throw InvalidProtocolBufferException.b();
            }
        }

        public void b0() throws InvalidProtocolBufferException {
            int iJ;
            do {
                iJ = J();
                if (iJ == 0) {
                    return;
                }
            } while (M(iJ));
        }

        public void c0(int i) throws InvalidProtocolBufferException {
            int i2 = this.i;
            int i3 = this.k;
            if (i > i2 - i3 || i < 0) {
                d0(i);
            } else {
                this.k = i3 + i;
            }
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int e() {
            int i = this.n;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - (this.m + this.k);
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int f() {
            return this.m + this.k;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public boolean g() {
            return this.k == this.i && !h0(1);
        }

        @Override // com.google.protobuf.AbstractC2384h
        public void o(int i) {
            this.n = i;
            Y();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int p(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int i2 = i + this.m + this.k;
            int i3 = this.n;
            if (i2 > i3) {
                throw InvalidProtocolBufferException.p();
            }
            this.n = i2;
            Y();
            return i3;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public boolean q() {
            return W() != 0;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public AbstractC2383g r() {
            int iB = B();
            int i = this.i;
            int i2 = this.k;
            if (iB > i - i2 || iB <= 0) {
                return iB == 0 ? AbstractC2383g.b : P(iB);
            }
            AbstractC2383g abstractC2383gL = AbstractC2383g.L(this.h, i2, iB);
            this.k += iB;
            return abstractC2383gL;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public double s() {
            return Double.longBitsToDouble(V());
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int t() {
            return B();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int u() {
            return U();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long v() {
            return V();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public float w() {
            return Float.intBitsToFloat(U());
        }

        @Override // com.google.protobuf.AbstractC2384h
        public void x(int i, P.a aVar, C2394s c2394s) throws InvalidProtocolBufferException {
            b();
            this.a++;
            aVar.h(this, c2394s);
            a(r0.c(i, 4));
            this.a--;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int y() {
            return B();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long z() {
            return W();
        }

        private c(InputStream inputStream, int i) {
            super();
            this.n = Integer.MAX_VALUE;
            B.b(inputStream, "input");
            this.g = inputStream;
            this.h = new byte[i];
            this.i = 0;
            this.k = 0;
            this.m = 0;
        }
    }

    /* renamed from: com.google.protobuf.h$d */
    private static final class d extends AbstractC2384h {
        private final ByteBuffer g;
        private final boolean h;
        private final long i;
        private long j;
        private long k;
        private long l;
        private int m;
        private int n;
        private boolean o;
        private int p;

        private int N(long j) {
            return (int) (j - this.i);
        }

        static boolean O() {
            return o0.J();
        }

        private void U() {
            long j = this.j + this.m;
            this.j = j;
            int i = (int) (j - this.l);
            int i2 = this.p;
            if (i <= i2) {
                this.m = 0;
                return;
            }
            int i3 = i - i2;
            this.m = i3;
            this.j = j - i3;
        }

        private int V() {
            return (int) (this.j - this.k);
        }

        private void Y() throws InvalidProtocolBufferException {
            if (V() >= 10) {
                Z();
            } else {
                a0();
            }
        }

        private void Z() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                long j = this.k;
                this.k = 1 + j;
                if (o0.w(j) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void a0() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (P() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private ByteBuffer b0(long j, long j2) {
            int iPosition = this.g.position();
            int iLimit = this.g.limit();
            ByteBuffer byteBuffer = this.g;
            try {
                try {
                    byteBuffer.position(N(j));
                    byteBuffer.limit(N(j2));
                    return this.g.slice();
                } catch (IllegalArgumentException e) {
                    InvalidProtocolBufferException invalidProtocolBufferExceptionP = InvalidProtocolBufferException.p();
                    invalidProtocolBufferExceptionP.initCause(e);
                    throw invalidProtocolBufferExceptionP;
                }
            } finally {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
            }
        }

        @Override // com.google.protobuf.AbstractC2384h
        public void A(P.a aVar, C2394s c2394s) throws InvalidProtocolBufferException {
            int iB = B();
            b();
            int iP = p(iB);
            this.a++;
            aVar.h(this, c2394s);
            a(0);
            this.a--;
            if (e() != 0) {
                throw InvalidProtocolBufferException.p();
            }
            o(iP);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (com.google.protobuf.o0.w(r3) < 0) goto L34;
         */
        @Override // com.google.protobuf.AbstractC2384h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int B() {
            /*
                r9 = this;
                long r0 = r9.k
                long r2 = r9.j
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto La
                goto L8e
            La:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = com.google.protobuf.o0.w(r0)
                if (r4 < 0) goto L16
                r9.k = r2
                return r4
            L16:
                long r5 = r9.j
                long r5 = r5 - r2
                r7 = 9
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 >= 0) goto L21
                goto L8e
            L21:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = com.google.protobuf.o0.w(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L31
                r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L98
            L31:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.o0.w(r5)
                int r5 = r5 << 14
                r2 = r2 ^ r5
                if (r2 < 0) goto L41
                r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
            L3f:
                r5 = r3
                goto L98
            L41:
                r5 = 4
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.o0.w(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L52
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L98
            L52:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.o0.w(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L96
                r5 = 6
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.o0.w(r3)
                if (r3 >= 0) goto L94
                r3 = 7
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.o0.w(r5)
                if (r5 >= 0) goto L96
                r5 = 8
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.o0.w(r3)
                if (r3 >= 0) goto L94
                long r3 = r0 + r7
                byte r5 = com.google.protobuf.o0.w(r5)
                if (r5 >= 0) goto L96
                r5 = 10
                long r5 = r5 + r0
                byte r0 = com.google.protobuf.o0.w(r3)
                if (r0 >= 0) goto L94
            L8e:
                long r0 = r9.T()
                int r0 = (int) r0
                return r0
            L94:
                r0 = r2
                goto L98
            L96:
                r0 = r2
                goto L3f
            L98:
                r9.k = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.AbstractC2384h.d.B():int");
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int D() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long E() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int F() {
            return AbstractC2384h.c(B());
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long G() {
            return AbstractC2384h.d(S());
        }

        @Override // com.google.protobuf.AbstractC2384h
        public String H() throws InvalidProtocolBufferException {
            int iB = B();
            if (iB <= 0 || iB > V()) {
                if (iB == 0) {
                    return "";
                }
                if (iB < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.p();
            }
            byte[] bArr = new byte[iB];
            long j = iB;
            o0.p(this.k, bArr, 0L, j);
            String str = new String(bArr, B.b);
            this.k += j;
            return str;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public String I() throws InvalidProtocolBufferException {
            int iB = B();
            if (iB > 0 && iB <= V()) {
                String strG = p0.g(this.g, N(this.k), iB);
                this.k += iB;
                return strG;
            }
            if (iB == 0) {
                return "";
            }
            if (iB <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.p();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int J() throws InvalidProtocolBufferException {
            if (g()) {
                this.n = 0;
                return 0;
            }
            int iB = B();
            this.n = iB;
            if (r0.a(iB) != 0) {
                return this.n;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int K() {
            return B();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long L() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public boolean M(int i) throws InvalidProtocolBufferException {
            int iB = r0.b(i);
            if (iB == 0) {
                Y();
                return true;
            }
            if (iB == 1) {
                X(8);
                return true;
            }
            if (iB == 2) {
                X(B());
                return true;
            }
            if (iB == 3) {
                W();
                a(r0.c(r0.a(i), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            X(4);
            return true;
        }

        public byte P() throws InvalidProtocolBufferException {
            long j = this.k;
            if (j == this.j) {
                throw InvalidProtocolBufferException.p();
            }
            this.k = 1 + j;
            return o0.w(j);
        }

        public int Q() throws InvalidProtocolBufferException {
            long j = this.k;
            if (this.j - j < 4) {
                throw InvalidProtocolBufferException.p();
            }
            this.k = 4 + j;
            return ((o0.w(j + 3) & 255) << 24) | (o0.w(j) & 255) | ((o0.w(1 + j) & 255) << 8) | ((o0.w(2 + j) & 255) << 16);
        }

        public long R() throws InvalidProtocolBufferException {
            long j = this.k;
            if (this.j - j < 8) {
                throw InvalidProtocolBufferException.p();
            }
            this.k = 8 + j;
            return ((o0.w(j + 7) & 255) << 56) | (o0.w(j) & 255) | ((o0.w(1 + j) & 255) << 8) | ((o0.w(2 + j) & 255) << 16) | ((o0.w(3 + j) & 255) << 24) | ((o0.w(4 + j) & 255) << 32) | ((o0.w(5 + j) & 255) << 40) | ((o0.w(6 + j) & 255) << 48);
        }

        public long S() {
            long j;
            long j2;
            long j3;
            int i;
            long j4 = this.k;
            if (this.j != j4) {
                long j5 = 1 + j4;
                byte bW = o0.w(j4);
                if (bW >= 0) {
                    this.k = j5;
                    return bW;
                }
                if (this.j - j5 >= 9) {
                    long j6 = 2 + j4;
                    int iW = (o0.w(j5) << 7) ^ bW;
                    if (iW >= 0) {
                        long j7 = 3 + j4;
                        int iW2 = iW ^ (o0.w(j6) << 14);
                        if (iW2 >= 0) {
                            j = iW2 ^ 16256;
                            j6 = j7;
                        } else {
                            j6 = 4 + j4;
                            int iW3 = iW2 ^ (o0.w(j7) << 21);
                            if (iW3 < 0) {
                                i = (-2080896) ^ iW3;
                            } else {
                                long j8 = 5 + j4;
                                long jW = iW3 ^ (o0.w(j6) << 28);
                                if (jW >= 0) {
                                    j3 = 266354560;
                                } else {
                                    long j9 = 6 + j4;
                                    long jW2 = jW ^ (o0.w(j8) << 35);
                                    if (jW2 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        j8 = 7 + j4;
                                        jW = jW2 ^ (o0.w(j9) << 42);
                                        if (jW >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            j9 = 8 + j4;
                                            jW2 = jW ^ (o0.w(j8) << 49);
                                            if (jW2 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                long j10 = j4 + 9;
                                                long jW3 = (jW2 ^ (o0.w(j9) << 56)) ^ 71499008037633920L;
                                                if (jW3 < 0) {
                                                    long j11 = j4 + 10;
                                                    if (o0.w(j10) >= 0) {
                                                        j6 = j11;
                                                        j = jW3;
                                                    }
                                                } else {
                                                    j = jW3;
                                                    j6 = j10;
                                                }
                                            }
                                        }
                                    }
                                    j = j2 ^ jW2;
                                    j6 = j9;
                                }
                                j = j3 ^ jW;
                                j6 = j8;
                            }
                        }
                        this.k = j6;
                        return j;
                    }
                    i = iW ^ (-128);
                    j = i;
                    this.k = j6;
                    return j;
                }
            }
            return T();
        }

        long T() throws InvalidProtocolBufferException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & 127) << i;
                if ((P() & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public void W() throws InvalidProtocolBufferException {
            int iJ;
            do {
                iJ = J();
                if (iJ == 0) {
                    return;
                }
            } while (M(iJ));
        }

        public void X(int i) throws InvalidProtocolBufferException {
            if (i >= 0 && i <= V()) {
                this.k += i;
            } else {
                if (i >= 0) {
                    throw InvalidProtocolBufferException.p();
                }
                throw InvalidProtocolBufferException.g();
            }
        }

        @Override // com.google.protobuf.AbstractC2384h
        public void a(int i) throws InvalidProtocolBufferException {
            if (this.n != i) {
                throw InvalidProtocolBufferException.b();
            }
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int e() {
            int i = this.p;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - f();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int f() {
            return (int) (this.k - this.l);
        }

        @Override // com.google.protobuf.AbstractC2384h
        public boolean g() {
            return this.k == this.j;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public void o(int i) {
            this.p = i;
            U();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int p(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int iF = i + f();
            int i2 = this.p;
            if (iF > i2) {
                throw InvalidProtocolBufferException.p();
            }
            this.p = iF;
            U();
            return i2;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public boolean q() {
            return S() != 0;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public AbstractC2383g r() throws InvalidProtocolBufferException {
            int iB = B();
            if (iB <= 0 || iB > V()) {
                if (iB == 0) {
                    return AbstractC2383g.b;
                }
                if (iB < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.p();
            }
            if (this.h && this.o) {
                long j = this.k;
                long j2 = iB;
                ByteBuffer byteBufferB0 = b0(j, j + j2);
                this.k += j2;
                return AbstractC2383g.h0(byteBufferB0);
            }
            byte[] bArr = new byte[iB];
            long j3 = iB;
            o0.p(this.k, bArr, 0L, j3);
            this.k += j3;
            return AbstractC2383g.i0(bArr);
        }

        @Override // com.google.protobuf.AbstractC2384h
        public double s() {
            return Double.longBitsToDouble(R());
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int t() {
            return B();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int u() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long v() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public float w() {
            return Float.intBitsToFloat(Q());
        }

        @Override // com.google.protobuf.AbstractC2384h
        public void x(int i, P.a aVar, C2394s c2394s) throws InvalidProtocolBufferException {
            b();
            this.a++;
            aVar.h(this, c2394s);
            a(r0.c(i, 4));
            this.a--;
        }

        @Override // com.google.protobuf.AbstractC2384h
        public int y() {
            return B();
        }

        @Override // com.google.protobuf.AbstractC2384h
        public long z() {
            return S();
        }

        private d(ByteBuffer byteBuffer, boolean z) {
            super();
            this.p = Integer.MAX_VALUE;
            this.g = byteBuffer;
            long jK = o0.k(byteBuffer);
            this.i = jK;
            this.j = byteBuffer.limit() + jK;
            long jPosition = jK + byteBuffer.position();
            this.k = jPosition;
            this.l = jPosition;
            this.h = z;
        }
    }

    public static int C(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw InvalidProtocolBufferException.p();
            }
            i2 |= (i4 & 127) << i3;
            if ((i4 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw InvalidProtocolBufferException.p();
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw InvalidProtocolBufferException.f();
    }

    public static int c(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long d(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static AbstractC2384h h(InputStream inputStream) {
        return i(inputStream, 4096);
    }

    public static AbstractC2384h i(InputStream inputStream, int i) {
        if (i > 0) {
            return inputStream == null ? l(B.d) : new c(inputStream, i);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static AbstractC2384h j(ByteBuffer byteBuffer) {
        return k(byteBuffer, false);
    }

    static AbstractC2384h k(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return n(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z);
        }
        if (byteBuffer.isDirect() && d.O()) {
            return new d(byteBuffer, z);
        }
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.duplicate().get(bArr);
        return n(bArr, 0, iRemaining, true);
    }

    public static AbstractC2384h l(byte[] bArr) {
        return m(bArr, 0, bArr.length);
    }

    public static AbstractC2384h m(byte[] bArr, int i, int i2) {
        return n(bArr, i, i2, false);
    }

    static AbstractC2384h n(byte[] bArr, int i, int i2, boolean z) {
        b bVar = new b(bArr, i, i2, z);
        try {
            bVar.p(i2);
            return bVar;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract void A(P.a aVar, C2394s c2394s);

    public abstract int B();

    public abstract int D();

    public abstract long E();

    public abstract int F();

    public abstract long G();

    public abstract String H();

    public abstract String I();

    public abstract int J();

    public abstract int K();

    public abstract long L();

    public abstract boolean M(int i);

    public abstract void a(int i);

    public void b() throws InvalidProtocolBufferException {
        if (this.a >= this.b) {
            throw InvalidProtocolBufferException.k();
        }
    }

    public abstract int e();

    public abstract int f();

    public abstract boolean g();

    public abstract void o(int i);

    public abstract int p(int i);

    public abstract boolean q();

    public abstract AbstractC2383g r();

    public abstract double s();

    public abstract int t();

    public abstract int u();

    public abstract long v();

    public abstract float w();

    public abstract void x(int i, P.a aVar, C2394s c2394s);

    public abstract int y();

    public abstract long z();

    private AbstractC2384h() {
        this.b = f;
        this.c = Integer.MAX_VALUE;
        this.e = false;
    }
}
