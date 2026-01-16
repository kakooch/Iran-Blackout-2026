package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.AbstractC2360w;

/* renamed from: com.google.crypto.tink.shaded.protobuf.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2343e {

    /* renamed from: com.google.crypto.tink.shaded.protobuf.e$a */
    static final class a {
        public int a;
        public long b;
        public Object c;
        public final C2352n d;

        a(C2352n c2352n) {
            c2352n.getClass();
            this.d = c2352n;
        }
    }

    static int A(int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) {
        AbstractC2363z abstractC2363z = (AbstractC2363z) dVar;
        int iK = K(bArr, i2, aVar);
        abstractC2363z.l1(AbstractC2346h.c(aVar.b));
        while (iK < i3) {
            int iH = H(bArr, iK, aVar);
            if (i != aVar.a) {
                break;
            }
            iK = K(bArr, iH, aVar);
            abstractC2363z.l1(AbstractC2346h.c(aVar.b));
        }
        return iK;
    }

    static int B(byte[] bArr, int i, a aVar) throws InvalidProtocolBufferException {
        int iH = H(bArr, i, aVar);
        int i2 = aVar.a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i2 == 0) {
            aVar.c = "";
            return iH;
        }
        aVar.c = new String(bArr, iH, i2, AbstractC2360w.b);
        return iH + i2;
    }

    static int C(int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) throws InvalidProtocolBufferException {
        int iH = H(bArr, i2, aVar);
        int i4 = aVar.a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i4 == 0) {
            dVar.add("");
        } else {
            dVar.add(new String(bArr, iH, i4, AbstractC2360w.b));
            iH += i4;
        }
        while (iH < i3) {
            int iH2 = H(bArr, iH, aVar);
            if (i != aVar.a) {
                break;
            }
            iH = H(bArr, iH2, aVar);
            int i5 = aVar.a;
            if (i5 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i5 == 0) {
                dVar.add("");
            } else {
                dVar.add(new String(bArr, iH, i5, AbstractC2360w.b));
                iH += i5;
            }
        }
        return iH;
    }

    static int D(int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) throws InvalidProtocolBufferException {
        int iH = H(bArr, i2, aVar);
        int i4 = aVar.a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i4 == 0) {
            dVar.add("");
        } else {
            int i5 = iH + i4;
            if (!e0.n(bArr, iH, i5)) {
                throw InvalidProtocolBufferException.d();
            }
            dVar.add(new String(bArr, iH, i4, AbstractC2360w.b));
            iH = i5;
        }
        while (iH < i3) {
            int iH2 = H(bArr, iH, aVar);
            if (i != aVar.a) {
                break;
            }
            iH = H(bArr, iH2, aVar);
            int i6 = aVar.a;
            if (i6 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i6 == 0) {
                dVar.add("");
            } else {
                int i7 = iH + i6;
                if (!e0.n(bArr, iH, i7)) {
                    throw InvalidProtocolBufferException.d();
                }
                dVar.add(new String(bArr, iH, i6, AbstractC2360w.b));
                iH = i7;
            }
        }
        return iH;
    }

    static int E(byte[] bArr, int i, a aVar) throws InvalidProtocolBufferException {
        int iH = H(bArr, i, aVar);
        int i2 = aVar.a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i2 == 0) {
            aVar.c = "";
            return iH;
        }
        aVar.c = e0.e(bArr, iH, i2);
        return iH + i2;
    }

    static int F(int i, byte[] bArr, int i2, int i3, b0 b0Var, a aVar) throws InvalidProtocolBufferException {
        if (f0.a(i) == 0) {
            throw InvalidProtocolBufferException.c();
        }
        int iB = f0.b(i);
        if (iB == 0) {
            int iK = K(bArr, i2, aVar);
            b0Var.n(i, Long.valueOf(aVar.b));
            return iK;
        }
        if (iB == 1) {
            b0Var.n(i, Long.valueOf(i(bArr, i2)));
            return i2 + 8;
        }
        if (iB == 2) {
            int iH = H(bArr, i2, aVar);
            int i4 = aVar.a;
            if (i4 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i4 > bArr.length - iH) {
                throw InvalidProtocolBufferException.p();
            }
            if (i4 == 0) {
                b0Var.n(i, AbstractC2345g.b);
            } else {
                b0Var.n(i, AbstractC2345g.D(bArr, iH, i4));
            }
            return iH + i4;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw InvalidProtocolBufferException.c();
            }
            b0Var.n(i, Integer.valueOf(g(bArr, i2)));
            return i2 + 4;
        }
        b0 b0VarK = b0.k();
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iH2 = H(bArr, i2, aVar);
            int i7 = aVar.a;
            if (i7 == i5) {
                i6 = i7;
                i2 = iH2;
                break;
            }
            i6 = i7;
            i2 = F(i7, bArr, iH2, i3, b0VarK, aVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw InvalidProtocolBufferException.j();
        }
        b0Var.n(i, b0VarK);
        return i2;
    }

    static int G(int i, byte[] bArr, int i2, a aVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            aVar.a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            aVar.a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            aVar.a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            aVar.a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                aVar.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int H(byte[] bArr, int i, a aVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return G(b, bArr, i2, aVar);
        }
        aVar.a = b;
        return i2;
    }

    static int I(int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) {
        AbstractC2359v abstractC2359v = (AbstractC2359v) dVar;
        int iH = H(bArr, i2, aVar);
        abstractC2359v.b1(aVar.a);
        while (iH < i3) {
            int iH2 = H(bArr, iH, aVar);
            if (i != aVar.a) {
                break;
            }
            iH = H(bArr, iH2, aVar);
            abstractC2359v.b1(aVar.a);
        }
        return iH;
    }

    static int J(long j, byte[] bArr, int i, a aVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        long j2 = (j & 127) | ((b & 127) << 7);
        int i3 = 7;
        while (b < 0) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            i3 += 7;
            j2 |= (b2 & 127) << i3;
            i2 = i4;
            b = b2;
        }
        aVar.b = j2;
        return i2;
    }

    static int K(byte[] bArr, int i, a aVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j < 0) {
            return J(j, bArr, i2, aVar);
        }
        aVar.b = j;
        return i2;
    }

    static int L(int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) {
        AbstractC2363z abstractC2363z = (AbstractC2363z) dVar;
        int iK = K(bArr, i2, aVar);
        abstractC2363z.l1(aVar.b);
        while (iK < i3) {
            int iH = H(bArr, iK, aVar);
            if (i != aVar.a) {
                break;
            }
            iK = K(bArr, iH, aVar);
            abstractC2363z.l1(aVar.b);
        }
        return iK;
    }

    static int M(Object obj, V v, byte[] bArr, int i, int i2, int i3, a aVar) {
        int iF0 = ((K) v).f0(obj, bArr, i, i2, i3, aVar);
        aVar.c = obj;
        return iF0;
    }

    static int N(Object obj, V v, byte[] bArr, int i, int i2, a aVar) throws InvalidProtocolBufferException {
        int iG = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iG = G(i3, bArr, iG, aVar);
            i3 = aVar.a;
        }
        int i4 = iG;
        if (i3 < 0 || i3 > i2 - i4) {
            throw InvalidProtocolBufferException.p();
        }
        int i5 = i3 + i4;
        v.h(obj, bArr, i4, i5, aVar);
        aVar.c = obj;
        return i5;
    }

    static int a(int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) {
        AbstractC2344f abstractC2344f = (AbstractC2344f) dVar;
        int iK = K(bArr, i2, aVar);
        abstractC2344f.h(aVar.b != 0);
        while (iK < i3) {
            int iH = H(bArr, iK, aVar);
            if (i != aVar.a) {
                break;
            }
            iK = K(bArr, iH, aVar);
            abstractC2344f.h(aVar.b != 0);
        }
        return iK;
    }

    static int b(byte[] bArr, int i, a aVar) throws InvalidProtocolBufferException {
        int iH = H(bArr, i, aVar);
        int i2 = aVar.a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i2 > bArr.length - iH) {
            throw InvalidProtocolBufferException.p();
        }
        if (i2 == 0) {
            aVar.c = AbstractC2345g.b;
            return iH;
        }
        aVar.c = AbstractC2345g.D(bArr, iH, i2);
        return iH + i2;
    }

    static int c(int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) throws InvalidProtocolBufferException {
        int iH = H(bArr, i2, aVar);
        int i4 = aVar.a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i4 > bArr.length - iH) {
            throw InvalidProtocolBufferException.p();
        }
        if (i4 == 0) {
            dVar.add(AbstractC2345g.b);
        } else {
            dVar.add(AbstractC2345g.D(bArr, iH, i4));
            iH += i4;
        }
        while (iH < i3) {
            int iH2 = H(bArr, iH, aVar);
            if (i != aVar.a) {
                break;
            }
            iH = H(bArr, iH2, aVar);
            int i5 = aVar.a;
            if (i5 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i5 > bArr.length - iH) {
                throw InvalidProtocolBufferException.p();
            }
            if (i5 == 0) {
                dVar.add(AbstractC2345g.b);
            } else {
                dVar.add(AbstractC2345g.D(bArr, iH, i5));
                iH += i5;
            }
        }
        return iH;
    }

    static double d(byte[] bArr, int i) {
        return Double.longBitsToDouble(i(bArr, i));
    }

    static int e(int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) {
        AbstractC2349k abstractC2349k = (AbstractC2349k) dVar;
        abstractC2349k.s1(d(bArr, i2));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int iH = H(bArr, i4, aVar);
            if (i != aVar.a) {
                break;
            }
            abstractC2349k.s1(d(bArr, iH));
            i4 = iH + 8;
        }
        return i4;
    }

    static int f(int i, byte[] bArr, int i2, int i3, Object obj, I i4, a0 a0Var, a aVar) {
        aVar.d.a(i4, i >>> 3);
        return F(i, bArr, i2, i3, K.v(obj), aVar);
    }

    static int g(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static int h(int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) {
        AbstractC2359v abstractC2359v = (AbstractC2359v) dVar;
        abstractC2359v.b1(g(bArr, i2));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int iH = H(bArr, i4, aVar);
            if (i != aVar.a) {
                break;
            }
            abstractC2359v.b1(g(bArr, iH));
            i4 = iH + 4;
        }
        return i4;
    }

    static long i(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    static int j(int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) {
        AbstractC2363z abstractC2363z = (AbstractC2363z) dVar;
        abstractC2363z.l1(i(bArr, i2));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int iH = H(bArr, i4, aVar);
            if (i != aVar.a) {
                break;
            }
            abstractC2363z.l1(i(bArr, iH));
            i4 = iH + 8;
        }
        return i4;
    }

    static float k(byte[] bArr, int i) {
        return Float.intBitsToFloat(g(bArr, i));
    }

    static int l(int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) {
        AbstractC2356s abstractC2356s = (AbstractC2356s) dVar;
        abstractC2356s.M(k(bArr, i2));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int iH = H(bArr, i4, aVar);
            if (i != aVar.a) {
                break;
            }
            abstractC2356s.M(k(bArr, iH));
            i4 = iH + 4;
        }
        return i4;
    }

    static int m(V v, byte[] bArr, int i, int i2, int i3, a aVar) {
        Object objD = v.d();
        int iM = M(objD, v, bArr, i, i2, i3, aVar);
        v.e(objD);
        aVar.c = objD;
        return iM;
    }

    static int n(V v, int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) {
        int i4 = (i & (-8)) | 4;
        int iM = m(v, bArr, i2, i3, i4, aVar);
        dVar.add(aVar.c);
        while (iM < i3) {
            int iH = H(bArr, iM, aVar);
            if (i != aVar.a) {
                break;
            }
            iM = m(v, bArr, iH, i3, i4, aVar);
            dVar.add(aVar.c);
        }
        return iM;
    }

    static int o(V v, byte[] bArr, int i, int i2, a aVar) throws InvalidProtocolBufferException {
        Object objD = v.d();
        int iN = N(objD, v, bArr, i, i2, aVar);
        v.e(objD);
        aVar.c = objD;
        return iN;
    }

    static int p(V v, int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) throws InvalidProtocolBufferException {
        int iO = o(v, bArr, i2, i3, aVar);
        dVar.add(aVar.c);
        while (iO < i3) {
            int iH = H(bArr, iO, aVar);
            if (i != aVar.a) {
                break;
            }
            iO = o(v, bArr, iH, i3, aVar);
            dVar.add(aVar.c);
        }
        return iO;
    }

    static int q(byte[] bArr, int i, AbstractC2360w.d dVar, a aVar) throws InvalidProtocolBufferException {
        AbstractC2344f abstractC2344f = (AbstractC2344f) dVar;
        int iH = H(bArr, i, aVar);
        int i2 = aVar.a + iH;
        while (iH < i2) {
            iH = K(bArr, iH, aVar);
            abstractC2344f.h(aVar.b != 0);
        }
        if (iH == i2) {
            return iH;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int r(byte[] bArr, int i, AbstractC2360w.d dVar, a aVar) throws InvalidProtocolBufferException {
        AbstractC2349k abstractC2349k = (AbstractC2349k) dVar;
        int iH = H(bArr, i, aVar);
        int i2 = aVar.a + iH;
        while (iH < i2) {
            abstractC2349k.s1(d(bArr, iH));
            iH += 8;
        }
        if (iH == i2) {
            return iH;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int s(byte[] bArr, int i, AbstractC2360w.d dVar, a aVar) throws InvalidProtocolBufferException {
        AbstractC2359v abstractC2359v = (AbstractC2359v) dVar;
        int iH = H(bArr, i, aVar);
        int i2 = aVar.a + iH;
        while (iH < i2) {
            abstractC2359v.b1(g(bArr, iH));
            iH += 4;
        }
        if (iH == i2) {
            return iH;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int t(byte[] bArr, int i, AbstractC2360w.d dVar, a aVar) throws InvalidProtocolBufferException {
        AbstractC2363z abstractC2363z = (AbstractC2363z) dVar;
        int iH = H(bArr, i, aVar);
        int i2 = aVar.a + iH;
        while (iH < i2) {
            abstractC2363z.l1(i(bArr, iH));
            iH += 8;
        }
        if (iH == i2) {
            return iH;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int u(byte[] bArr, int i, AbstractC2360w.d dVar, a aVar) throws InvalidProtocolBufferException {
        AbstractC2356s abstractC2356s = (AbstractC2356s) dVar;
        int iH = H(bArr, i, aVar);
        int i2 = aVar.a + iH;
        while (iH < i2) {
            abstractC2356s.M(k(bArr, iH));
            iH += 4;
        }
        if (iH == i2) {
            return iH;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int v(byte[] bArr, int i, AbstractC2360w.d dVar, a aVar) throws InvalidProtocolBufferException {
        AbstractC2359v abstractC2359v = (AbstractC2359v) dVar;
        int iH = H(bArr, i, aVar);
        int i2 = aVar.a + iH;
        while (iH < i2) {
            iH = H(bArr, iH, aVar);
            abstractC2359v.b1(AbstractC2346h.b(aVar.a));
        }
        if (iH == i2) {
            return iH;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int w(byte[] bArr, int i, AbstractC2360w.d dVar, a aVar) throws InvalidProtocolBufferException {
        AbstractC2363z abstractC2363z = (AbstractC2363z) dVar;
        int iH = H(bArr, i, aVar);
        int i2 = aVar.a + iH;
        while (iH < i2) {
            iH = K(bArr, iH, aVar);
            abstractC2363z.l1(AbstractC2346h.c(aVar.b));
        }
        if (iH == i2) {
            return iH;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int x(byte[] bArr, int i, AbstractC2360w.d dVar, a aVar) throws InvalidProtocolBufferException {
        AbstractC2359v abstractC2359v = (AbstractC2359v) dVar;
        int iH = H(bArr, i, aVar);
        int i2 = aVar.a + iH;
        while (iH < i2) {
            iH = H(bArr, iH, aVar);
            abstractC2359v.b1(aVar.a);
        }
        if (iH == i2) {
            return iH;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int y(byte[] bArr, int i, AbstractC2360w.d dVar, a aVar) throws InvalidProtocolBufferException {
        AbstractC2363z abstractC2363z = (AbstractC2363z) dVar;
        int iH = H(bArr, i, aVar);
        int i2 = aVar.a + iH;
        while (iH < i2) {
            iH = K(bArr, iH, aVar);
            abstractC2363z.l1(aVar.b);
        }
        if (iH == i2) {
            return iH;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int z(int i, byte[] bArr, int i2, int i3, AbstractC2360w.d dVar, a aVar) {
        AbstractC2359v abstractC2359v = (AbstractC2359v) dVar;
        int iH = H(bArr, i2, aVar);
        abstractC2359v.b1(AbstractC2346h.b(aVar.a));
        while (iH < i3) {
            int iH2 = H(bArr, iH, aVar);
            if (i != aVar.a) {
                break;
            }
            iH = H(bArr, iH2, aVar);
            abstractC2359v.b1(AbstractC2346h.b(aVar.a));
        }
        return iH;
    }
}
