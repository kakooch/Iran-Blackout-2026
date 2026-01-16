package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.crypto.tink.shaded.protobuf.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2346h {
    private static volatile int f = 100;
    int a;
    int b;
    int c;
    C2347i d;
    private boolean e;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.h$b */
    private static final class b extends AbstractC2346h {
        private final byte[] g;
        private final boolean h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private boolean n;
        private int o;

        private void M() {
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

        private void P() throws InvalidProtocolBufferException {
            if (this.i - this.k >= 10) {
                Q();
            } else {
                R();
            }
        }

        private void Q() throws InvalidProtocolBufferException {
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

        private void R() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (F() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public String A() throws InvalidProtocolBufferException {
            int iJ = J();
            if (iJ > 0) {
                int i = this.i;
                int i2 = this.k;
                if (iJ <= i - i2) {
                    String strE = e0.e(this.g, i2, iJ);
                    this.k += iJ;
                    return strE;
                }
            }
            if (iJ == 0) {
                return "";
            }
            if (iJ <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.p();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int B() throws InvalidProtocolBufferException {
            if (e()) {
                this.m = 0;
                return 0;
            }
            int iJ = J();
            this.m = iJ;
            if (f0.a(iJ) != 0) {
                return this.m;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int C() {
            return J();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public long D() {
            return K();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public boolean E(int i) throws InvalidProtocolBufferException {
            int iB = f0.b(i);
            if (iB == 0) {
                P();
                return true;
            }
            if (iB == 1) {
                O(8);
                return true;
            }
            if (iB == 2) {
                O(J());
                return true;
            }
            if (iB == 3) {
                N();
                a(f0.c(f0.a(i), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            O(4);
            return true;
        }

        public byte F() throws InvalidProtocolBufferException {
            int i = this.k;
            if (i == this.i) {
                throw InvalidProtocolBufferException.p();
            }
            byte[] bArr = this.g;
            this.k = i + 1;
            return bArr[i];
        }

        public byte[] G(int i) throws InvalidProtocolBufferException {
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
                return AbstractC2360w.d;
            }
            throw InvalidProtocolBufferException.g();
        }

        public int H() throws InvalidProtocolBufferException {
            int i = this.k;
            if (this.i - i < 4) {
                throw InvalidProtocolBufferException.p();
            }
            byte[] bArr = this.g;
            this.k = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        public long I() throws InvalidProtocolBufferException {
            int i = this.k;
            if (this.i - i < 8) {
                throw InvalidProtocolBufferException.p();
            }
            byte[] bArr = this.g;
            this.k = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        public int J() {
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
            return (int) L();
        }

        public long K() {
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
            return L();
        }

        long L() throws InvalidProtocolBufferException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & 127) << i;
                if ((F() & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public void N() throws InvalidProtocolBufferException {
            int iB;
            do {
                iB = B();
                if (iB == 0) {
                    return;
                }
            } while (E(iB));
        }

        public void O(int i) throws InvalidProtocolBufferException {
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

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public void a(int i) throws InvalidProtocolBufferException {
            if (this.m != i) {
                throw InvalidProtocolBufferException.b();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int d() {
            return this.k - this.l;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public boolean e() {
            return this.k == this.i;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public void k(int i) {
            this.o = i;
            M();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int l(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int iD = i + d();
            if (iD < 0) {
                throw InvalidProtocolBufferException.j();
            }
            int i2 = this.o;
            if (iD > i2) {
                throw InvalidProtocolBufferException.p();
            }
            this.o = iD;
            M();
            return i2;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public boolean m() {
            return K() != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public AbstractC2345g n() {
            int iJ = J();
            if (iJ > 0) {
                int i = this.i;
                int i2 = this.k;
                if (iJ <= i - i2) {
                    AbstractC2345g abstractC2345gF0 = (this.h && this.n) ? AbstractC2345g.f0(this.g, i2, iJ) : AbstractC2345g.D(this.g, i2, iJ);
                    this.k += iJ;
                    return abstractC2345gF0;
                }
            }
            return iJ == 0 ? AbstractC2345g.b : AbstractC2345g.d0(G(iJ));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public double o() {
            return Double.longBitsToDouble(I());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int p() {
            return J();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int q() {
            return H();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public long r() {
            return I();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public float s() {
            return Float.intBitsToFloat(H());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int t() {
            return J();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public long u() {
            return K();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int v() {
            return H();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public long w() {
            return I();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int x() {
            return AbstractC2346h.b(J());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public long y() {
            return AbstractC2346h.c(K());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public String z() throws InvalidProtocolBufferException {
            int iJ = J();
            if (iJ > 0) {
                int i = this.i;
                int i2 = this.k;
                if (iJ <= i - i2) {
                    String str = new String(this.g, i2, iJ, AbstractC2360w.b);
                    this.k += iJ;
                    return str;
                }
            }
            if (iJ == 0) {
                return "";
            }
            if (iJ < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.p();
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

    /* renamed from: com.google.crypto.tink.shaded.protobuf.h$c */
    private static final class c extends AbstractC2346h {
        private final InputStream g;
        private final byte[] h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;

        private static int F(InputStream inputStream) throws InvalidProtocolBufferException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e) {
                e.l();
                throw e;
            }
        }

        private static int G(InputStream inputStream, byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            try {
                return inputStream.read(bArr, i, i2);
            } catch (InvalidProtocolBufferException e) {
                e.l();
                throw e;
            }
        }

        private AbstractC2345g H(int i) throws IOException {
            byte[] bArrK = K(i);
            if (bArrK != null) {
                return AbstractC2345g.C(bArrK);
            }
            int i2 = this.k;
            int i3 = this.i;
            int length = i3 - i2;
            this.m += i3;
            this.k = 0;
            this.i = 0;
            List<byte[]> listL = L(i - length);
            byte[] bArr = new byte[i];
            System.arraycopy(this.h, i2, bArr, 0, length);
            for (byte[] bArr2 : listL) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return AbstractC2345g.d0(bArr);
        }

        private byte[] J(int i, boolean z) throws IOException {
            byte[] bArrK = K(i);
            if (bArrK != null) {
                return z ? (byte[]) bArrK.clone() : bArrK;
            }
            int i2 = this.k;
            int i3 = this.i;
            int length = i3 - i2;
            this.m += i3;
            this.k = 0;
            this.i = 0;
            List<byte[]> listL = L(i - length);
            byte[] bArr = new byte[i];
            System.arraycopy(this.h, i2, bArr, 0, length);
            for (byte[] bArr2 : listL) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        private byte[] K(int i) throws InvalidProtocolBufferException {
            if (i == 0) {
                return AbstractC2360w.d;
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
                V((i5 - i2) - i3);
                throw InvalidProtocolBufferException.p();
            }
            int i6 = this.i - i3;
            int i7 = i - i6;
            if (i7 >= 4096 && i7 > F(this.g)) {
                return null;
            }
            byte[] bArr = new byte[i];
            System.arraycopy(this.h, this.k, bArr, 0, i6);
            this.m += this.i;
            this.k = 0;
            this.i = 0;
            while (i6 < i) {
                int iG = G(this.g, bArr, i6, i - i6);
                if (iG == -1) {
                    throw InvalidProtocolBufferException.p();
                }
                this.m += iG;
                i6 += iG;
            }
            return bArr;
        }

        private List L(int i) throws IOException {
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

        private void R() {
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

        private void S(int i) throws InvalidProtocolBufferException {
            if (a0(i)) {
                return;
            }
            if (i <= (this.c - this.m) - this.k) {
                throw InvalidProtocolBufferException.p();
            }
            throw InvalidProtocolBufferException.n();
        }

        private static long T(InputStream inputStream, long j) throws InvalidProtocolBufferException {
            try {
                return inputStream.skip(j);
            } catch (InvalidProtocolBufferException e) {
                e.l();
                throw e;
            }
        }

        private void W(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int i2 = this.m;
            int i3 = this.k;
            int i4 = i2 + i3 + i;
            int i5 = this.n;
            if (i4 > i5) {
                V((i5 - i2) - i3);
                throw InvalidProtocolBufferException.p();
            }
            this.m = i2 + i3;
            int i6 = this.i - i3;
            this.i = 0;
            this.k = 0;
            while (i6 < i) {
                try {
                    long j = i - i6;
                    long jT = T(this.g, j);
                    if (jT < 0 || jT > j) {
                        throw new IllegalStateException(this.g.getClass() + "#skip returned invalid result: " + jT + "\nThe InputStream implementation is buggy.");
                    }
                    if (jT == 0) {
                        break;
                    } else {
                        i6 += (int) jT;
                    }
                } finally {
                    this.m += i6;
                    R();
                }
            }
            if (i6 >= i) {
                return;
            }
            int i7 = this.i;
            int i8 = i7 - this.k;
            this.k = i7;
            S(1);
            while (true) {
                int i9 = i - i8;
                int i10 = this.i;
                if (i9 <= i10) {
                    this.k = i9;
                    return;
                } else {
                    i8 += i10;
                    this.k = i10;
                    S(1);
                }
            }
        }

        private void X() throws InvalidProtocolBufferException {
            if (this.i - this.k >= 10) {
                Y();
            } else {
                Z();
            }
        }

        private void Y() throws InvalidProtocolBufferException {
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

        private void Z() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (I() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private boolean a0(int i) throws InvalidProtocolBufferException {
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
            int iG = G(inputStream, bArr2, i7, Math.min(bArr2.length - i7, (this.c - this.m) - i7));
            if (iG == 0 || iG < -1 || iG > this.h.length) {
                throw new IllegalStateException(this.g.getClass() + "#read(byte[]) returned invalid result: " + iG + "\nThe InputStream implementation is buggy.");
            }
            if (iG <= 0) {
                return false;
            }
            this.i += iG;
            R();
            if (this.i >= i) {
                return true;
            }
            return a0(i);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public String A() throws IOException {
            byte[] bArrJ;
            int iO = O();
            int i = this.k;
            int i2 = this.i;
            if (iO <= i2 - i && iO > 0) {
                bArrJ = this.h;
                this.k = i + iO;
            } else {
                if (iO == 0) {
                    return "";
                }
                i = 0;
                if (iO <= i2) {
                    S(iO);
                    bArrJ = this.h;
                    this.k = iO;
                } else {
                    bArrJ = J(iO, false);
                }
            }
            return e0.e(bArrJ, i, iO);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int B() throws InvalidProtocolBufferException {
            if (e()) {
                this.l = 0;
                return 0;
            }
            int iO = O();
            this.l = iO;
            if (f0.a(iO) != 0) {
                return this.l;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int C() {
            return O();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public long D() {
            return P();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public boolean E(int i) throws InvalidProtocolBufferException {
            int iB = f0.b(i);
            if (iB == 0) {
                X();
                return true;
            }
            if (iB == 1) {
                V(8);
                return true;
            }
            if (iB == 2) {
                V(O());
                return true;
            }
            if (iB == 3) {
                U();
                a(f0.c(f0.a(i), 4));
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

        public byte I() throws InvalidProtocolBufferException {
            if (this.k == this.i) {
                S(1);
            }
            byte[] bArr = this.h;
            int i = this.k;
            this.k = i + 1;
            return bArr[i];
        }

        public int M() throws InvalidProtocolBufferException {
            int i = this.k;
            if (this.i - i < 4) {
                S(4);
                i = this.k;
            }
            byte[] bArr = this.h;
            this.k = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        public long N() throws InvalidProtocolBufferException {
            int i = this.k;
            if (this.i - i < 8) {
                S(8);
                i = this.k;
            }
            byte[] bArr = this.h;
            this.k = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        public int O() {
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
            return (int) Q();
        }

        public long P() {
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
            return Q();
        }

        long Q() throws InvalidProtocolBufferException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & 127) << i;
                if ((I() & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public void U() throws InvalidProtocolBufferException {
            int iB;
            do {
                iB = B();
                if (iB == 0) {
                    return;
                }
            } while (E(iB));
        }

        public void V(int i) throws InvalidProtocolBufferException {
            int i2 = this.i;
            int i3 = this.k;
            if (i > i2 - i3 || i < 0) {
                W(i);
            } else {
                this.k = i3 + i;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public void a(int i) throws InvalidProtocolBufferException {
            if (this.l != i) {
                throw InvalidProtocolBufferException.b();
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int d() {
            return this.m + this.k;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public boolean e() {
            return this.k == this.i && !a0(1);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public void k(int i) {
            this.n = i;
            R();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int l(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int i2 = i + this.m + this.k;
            int i3 = this.n;
            if (i2 > i3) {
                throw InvalidProtocolBufferException.p();
            }
            this.n = i2;
            R();
            return i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public boolean m() {
            return P() != 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public AbstractC2345g n() {
            int iO = O();
            int i = this.i;
            int i2 = this.k;
            if (iO > i - i2 || iO <= 0) {
                return iO == 0 ? AbstractC2345g.b : H(iO);
            }
            AbstractC2345g abstractC2345gD = AbstractC2345g.D(this.h, i2, iO);
            this.k += iO;
            return abstractC2345gD;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public double o() {
            return Double.longBitsToDouble(N());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int p() {
            return O();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int q() {
            return M();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public long r() {
            return N();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public float s() {
            return Float.intBitsToFloat(M());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int t() {
            return O();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public long u() {
            return P();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int v() {
            return M();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public long w() {
            return N();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public int x() {
            return AbstractC2346h.b(O());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public long y() {
            return AbstractC2346h.c(P());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2346h
        public String z() throws InvalidProtocolBufferException {
            int iO = O();
            if (iO > 0) {
                int i = this.i;
                int i2 = this.k;
                if (iO <= i - i2) {
                    String str = new String(this.h, i2, iO, AbstractC2360w.b);
                    this.k += iO;
                    return str;
                }
            }
            if (iO == 0) {
                return "";
            }
            if (iO > this.i) {
                return new String(J(iO, false), AbstractC2360w.b);
            }
            S(iO);
            String str2 = new String(this.h, this.k, iO, AbstractC2360w.b);
            this.k += iO;
            return str2;
        }

        private c(InputStream inputStream, int i) {
            super();
            this.n = Integer.MAX_VALUE;
            AbstractC2360w.b(inputStream, "input");
            this.g = inputStream;
            this.h = new byte[i];
            this.i = 0;
            this.k = 0;
            this.m = 0;
        }
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static AbstractC2346h f(InputStream inputStream) {
        return g(inputStream, 4096);
    }

    public static AbstractC2346h g(InputStream inputStream, int i) {
        if (i > 0) {
            return inputStream == null ? h(AbstractC2360w.d) : new c(inputStream, i);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static AbstractC2346h h(byte[] bArr) {
        return i(bArr, 0, bArr.length);
    }

    public static AbstractC2346h i(byte[] bArr, int i, int i2) {
        return j(bArr, i, i2, false);
    }

    static AbstractC2346h j(byte[] bArr, int i, int i2, boolean z) {
        b bVar = new b(bArr, i, i2, z);
        try {
            bVar.l(i2);
            return bVar;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract String A();

    public abstract int B();

    public abstract int C();

    public abstract long D();

    public abstract boolean E(int i);

    public abstract void a(int i);

    public abstract int d();

    public abstract boolean e();

    public abstract void k(int i);

    public abstract int l(int i);

    public abstract boolean m();

    public abstract AbstractC2345g n();

    public abstract double o();

    public abstract int p();

    public abstract int q();

    public abstract long r();

    public abstract float s();

    public abstract int t();

    public abstract long u();

    public abstract int v();

    public abstract long w();

    public abstract int x();

    public abstract long y();

    public abstract String z();

    private AbstractC2346h() {
        this.b = f;
        this.c = Integer.MAX_VALUE;
        this.e = false;
    }
}
