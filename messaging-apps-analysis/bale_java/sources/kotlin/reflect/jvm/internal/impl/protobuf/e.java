package kotlin.reflect.jvm.internal.impl.protobuf;

import ir.nasim.LW4;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.l;

/* loaded from: classes8.dex */
public final class e {
    private int d;
    private final InputStream f;
    private int g;
    private int k;
    private boolean h = false;
    private int j = Integer.MAX_VALUE;
    private int l = 64;
    private int m = 67108864;
    private final byte[] a = new byte[4096];
    private int c = 0;
    private int e = 0;
    private int i = 0;
    private final boolean b = false;

    private e(InputStream inputStream) {
        this.f = inputStream;
    }

    public static int A(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw InvalidProtocolBufferException.m();
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
                throw InvalidProtocolBufferException.m();
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw InvalidProtocolBufferException.f();
    }

    private void M() {
        int i = this.c + this.d;
        this.c = i;
        int i2 = this.i + i;
        int i3 = this.j;
        if (i2 <= i3) {
            this.d = 0;
            return;
        }
        int i4 = i2 - i3;
        this.d = i4;
        this.c = i - i4;
    }

    private void N(int i) throws InvalidProtocolBufferException {
        if (!S(i)) {
            throw InvalidProtocolBufferException.m();
        }
    }

    private void R(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.g();
        }
        int i2 = this.i;
        int i3 = this.e;
        int i4 = i2 + i3 + i;
        int i5 = this.j;
        if (i4 > i5) {
            Q((i5 - i2) - i3);
            throw InvalidProtocolBufferException.m();
        }
        int i6 = this.c;
        int i7 = i6 - i3;
        this.e = i6;
        N(1);
        while (true) {
            int i8 = i - i7;
            int i9 = this.c;
            if (i8 <= i9) {
                this.e = i8;
                return;
            } else {
                i7 += i9;
                this.e = i9;
                N(1);
            }
        }
    }

    private boolean S(int i) throws IOException {
        int i2 = this.e;
        int i3 = i2 + i;
        int i4 = this.c;
        if (i3 <= i4) {
            StringBuilder sb = new StringBuilder(77);
            sb.append("refillBuffer() called when ");
            sb.append(i);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        if (this.i + i2 + i <= this.j && this.f != null) {
            if (i2 > 0) {
                if (i4 > i2) {
                    byte[] bArr = this.a;
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                this.i += i2;
                this.c -= i2;
                this.e = 0;
            }
            InputStream inputStream = this.f;
            byte[] bArr2 = this.a;
            int i5 = this.c;
            int i6 = inputStream.read(bArr2, i5, bArr2.length - i5);
            if (i6 == 0 || i6 < -1 || i6 > this.a.length) {
                StringBuilder sb2 = new StringBuilder(102);
                sb2.append("InputStream#read(byte[]) returned invalid result: ");
                sb2.append(i6);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            }
            if (i6 > 0) {
                this.c += i6;
                if ((this.i + i) - this.m > 0) {
                    throw InvalidProtocolBufferException.l();
                }
                M();
                if (this.c >= i) {
                    return true;
                }
                return S(i);
            }
        }
        return false;
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long c(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    private void d(int i) throws InvalidProtocolBufferException {
        if (this.c - this.e < i) {
            N(i);
        }
    }

    public static e g(InputStream inputStream) {
        return new e(inputStream);
    }

    private byte[] w(int i) throws InvalidProtocolBufferException {
        if (i <= 0) {
            if (i == 0) {
                return i.a;
            }
            throw InvalidProtocolBufferException.g();
        }
        int i2 = this.i;
        int i3 = this.e;
        int i4 = i2 + i3 + i;
        int i5 = this.j;
        if (i4 > i5) {
            Q((i5 - i2) - i3);
            throw InvalidProtocolBufferException.m();
        }
        if (i < 4096) {
            byte[] bArr = new byte[i];
            int i6 = this.c - i3;
            System.arraycopy(this.a, i3, bArr, 0, i6);
            this.e = this.c;
            int i7 = i - i6;
            d(i7);
            System.arraycopy(this.a, 0, bArr, i6, i7);
            this.e = i7;
            return bArr;
        }
        int i8 = this.c;
        this.i = i2 + i8;
        this.e = 0;
        this.c = 0;
        int length = i8 - i3;
        int i9 = i - length;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i9 > 0) {
            int iMin = Math.min(i9, 4096);
            byte[] bArr2 = new byte[iMin];
            int i10 = 0;
            while (i10 < iMin) {
                InputStream inputStream = this.f;
                int i11 = inputStream == null ? -1 : inputStream.read(bArr2, i10, iMin - i10);
                if (i11 == -1) {
                    throw InvalidProtocolBufferException.m();
                }
                this.i += i11;
                i10 += i11;
            }
            i9 -= iMin;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(this.a, i3, bArr3, 0, length);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
            length += bArr4.length;
        }
        return bArr3;
    }

    public long B() {
        long j;
        long j2;
        long j3;
        int i = this.e;
        int i2 = this.c;
        if (i2 != i) {
            byte[] bArr = this.a;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.e = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                long j4 = (bArr[i3] << 7) ^ b;
                if (j4 >= 0) {
                    int i5 = i + 3;
                    long j5 = j4 ^ (bArr[i4] << 14);
                    if (j5 >= 0) {
                        j3 = 16256;
                    } else {
                        i4 = i + 4;
                        j4 = j5 ^ (bArr[i5] << 21);
                        if (j4 < 0) {
                            j2 = -2080896;
                        } else {
                            i5 = i + 5;
                            j5 = j4 ^ (bArr[i4] << 28);
                            if (j5 >= 0) {
                                j3 = 266354560;
                            } else {
                                i4 = i + 6;
                                j4 = j5 ^ (bArr[i5] << 35);
                                if (j4 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i5 = i + 7;
                                    j5 = j4 ^ (bArr[i4] << 42);
                                    if (j5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i4 = i + 8;
                                        j4 = j5 ^ (bArr[i5] << 49);
                                        if (j4 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i5 = i + 9;
                                            long j6 = (j4 ^ (bArr[i4] << 56)) ^ 71499008037633920L;
                                            if (j6 >= 0) {
                                                j = j6;
                                                i4 = i5;
                                                this.e = i4;
                                                return j;
                                            }
                                            i4 = i + 10;
                                            if (bArr[i5] >= 0) {
                                                j = j6;
                                                this.e = i4;
                                                return j;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    j = j5 ^ j3;
                    i4 = i5;
                    this.e = i4;
                    return j;
                }
                j2 = -128;
                j = j4 ^ j2;
                this.e = i4;
                return j;
            }
        }
        return C();
    }

    long C() throws InvalidProtocolBufferException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & 127) << i;
            if ((v() & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.f();
    }

    public int D() {
        return x();
    }

    public long E() {
        return y();
    }

    public int F() {
        return b(z());
    }

    public long G() {
        return c(B());
    }

    public String H() {
        int iZ = z();
        int i = this.c;
        int i2 = this.e;
        if (iZ > i - i2 || iZ <= 0) {
            return iZ == 0 ? "" : new String(w(iZ), "UTF-8");
        }
        String str = new String(this.a, i2, iZ, "UTF-8");
        this.e += iZ;
        return str;
    }

    public String I() throws InvalidProtocolBufferException {
        byte[] bArrW;
        int iZ = z();
        int i = this.e;
        if (iZ <= this.c - i && iZ > 0) {
            bArrW = this.a;
            this.e = i + iZ;
        } else {
            if (iZ == 0) {
                return "";
            }
            bArrW = w(iZ);
            i = 0;
        }
        if (o.f(bArrW, i, i + iZ)) {
            return new String(bArrW, i, iZ, "UTF-8");
        }
        throw InvalidProtocolBufferException.d();
    }

    public int J() throws InvalidProtocolBufferException {
        if (f()) {
            this.g = 0;
            return 0;
        }
        int iZ = z();
        this.g = iZ;
        if (p.a(iZ) != 0) {
            return this.g;
        }
        throw InvalidProtocolBufferException.c();
    }

    public int K() {
        return z();
    }

    public long L() {
        return B();
    }

    public boolean O(int i, CodedOutputStream codedOutputStream) throws IOException {
        int iB = p.b(i);
        if (iB == 0) {
            long jS = s();
            codedOutputStream.n0(i);
            codedOutputStream.y0(jS);
            return true;
        }
        if (iB == 1) {
            long jY = y();
            codedOutputStream.n0(i);
            codedOutputStream.U(jY);
            return true;
        }
        if (iB == 2) {
            d dVarK = k();
            codedOutputStream.n0(i);
            codedOutputStream.O(dVarK);
            return true;
        }
        if (iB == 3) {
            codedOutputStream.n0(i);
            P(codedOutputStream);
            int iC = p.c(p.a(i), 4);
            a(iC);
            codedOutputStream.n0(iC);
            return true;
        }
        if (iB == 4) {
            return false;
        }
        if (iB != 5) {
            throw InvalidProtocolBufferException.e();
        }
        int iX = x();
        codedOutputStream.n0(i);
        codedOutputStream.T(iX);
        return true;
    }

    public void P(CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
        int iJ;
        do {
            iJ = J();
            if (iJ == 0) {
                return;
            }
        } while (O(iJ, codedOutputStream));
    }

    public void Q(int i) throws InvalidProtocolBufferException {
        int i2 = this.c;
        int i3 = this.e;
        if (i > i2 - i3 || i < 0) {
            R(i);
        } else {
            this.e = i3 + i;
        }
    }

    public void a(int i) throws InvalidProtocolBufferException {
        if (this.g != i) {
            throw InvalidProtocolBufferException.b();
        }
    }

    public int e() {
        int i = this.j;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.i + this.e);
    }

    public boolean f() {
        return this.e == this.c && !S(1);
    }

    public void h(int i) {
        this.j = i;
        M();
    }

    public int i(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.g();
        }
        int i2 = i + this.i + this.e;
        int i3 = this.j;
        if (i2 > i3) {
            throw InvalidProtocolBufferException.m();
        }
        this.j = i2;
        M();
        return i3;
    }

    public boolean j() {
        return B() != 0;
    }

    public d k() {
        int iZ = z();
        int i = this.c;
        int i2 = this.e;
        if (iZ > i - i2 || iZ <= 0) {
            return iZ == 0 ? d.a : new k(w(iZ));
        }
        d cVar = (this.b && this.h) ? new c(this.a, this.e, iZ) : d.o(this.a, i2, iZ);
        this.e += iZ;
        return cVar;
    }

    public double l() {
        return Double.longBitsToDouble(y());
    }

    public int m() {
        return z();
    }

    public int n() {
        return x();
    }

    public long o() {
        return y();
    }

    public float p() {
        return Float.intBitsToFloat(x());
    }

    public void q(int i, l.a aVar, f fVar) throws InvalidProtocolBufferException {
        int i2 = this.k;
        if (i2 >= this.l) {
            throw InvalidProtocolBufferException.j();
        }
        this.k = i2 + 1;
        aVar.d0(this, fVar);
        a(p.c(i, 4));
        this.k--;
    }

    public int r() {
        return z();
    }

    public long s() {
        return B();
    }

    public l t(LW4 lw4, f fVar) throws InvalidProtocolBufferException {
        int iZ = z();
        if (this.k >= this.l) {
            throw InvalidProtocolBufferException.j();
        }
        int i = i(iZ);
        this.k++;
        l lVar = (l) lw4.b(this, fVar);
        a(0);
        this.k--;
        h(i);
        return lVar;
    }

    public void u(l.a aVar, f fVar) throws InvalidProtocolBufferException {
        int iZ = z();
        if (this.k >= this.l) {
            throw InvalidProtocolBufferException.j();
        }
        int i = i(iZ);
        this.k++;
        aVar.d0(this, fVar);
        a(0);
        this.k--;
        h(i);
    }

    public byte v() throws InvalidProtocolBufferException {
        if (this.e == this.c) {
            N(1);
        }
        byte[] bArr = this.a;
        int i = this.e;
        this.e = i + 1;
        return bArr[i];
    }

    public int x() throws InvalidProtocolBufferException {
        int i = this.e;
        if (this.c - i < 4) {
            N(4);
            i = this.e;
        }
        byte[] bArr = this.a;
        this.e = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public long y() throws InvalidProtocolBufferException {
        int i = this.e;
        if (this.c - i < 8) {
            N(8);
            i = this.e;
        }
        byte[] bArr = this.a;
        this.e = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public int z() {
        int i;
        int i2 = this.e;
        int i3 = this.c;
        if (i3 != i2) {
            byte[] bArr = this.a;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.e = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                long j = i6;
                if (j < 0) {
                    i = (int) ((-128) ^ j);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    long j2 = i8;
                    if (j2 >= 0) {
                        i = (int) (16256 ^ j2);
                    } else {
                        int i9 = i2 + 4;
                        long j3 = i8 ^ (bArr[i7] << 21);
                        if (j3 < 0) {
                            i = (int) ((-2080896) ^ j3);
                        } else {
                            i7 = i2 + 5;
                            int i10 = (int) ((r1 ^ (r3 << 28)) ^ 266354560);
                            if (bArr[i9] < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i11 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i11;
                                                    i = i10;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i10;
                            }
                            i = i10;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.e = i5;
                return i;
            }
        }
        return (int) C();
    }
}
