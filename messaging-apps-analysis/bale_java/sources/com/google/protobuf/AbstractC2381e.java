package com.google.protobuf;

import com.google.protobuf.B;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.r0;

/* renamed from: com.google.protobuf.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC2381e {

    /* renamed from: com.google.protobuf.e$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r0.b.values().length];
            a = iArr;
            try {
                iArr[r0.b.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r0.b.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r0.b.e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[r0.b.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[r0.b.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[r0.b.o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[r0.b.h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[r0.b.r.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[r0.b.i.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[r0.b.q.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[r0.b.j.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[r0.b.s.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[r0.b.t.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[r0.b.p.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[r0.b.n.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[r0.b.k.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[r0.b.l.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[r0.b.m.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* renamed from: com.google.protobuf.e$b */
    static final class b {
        public int a;
        public long b;
        public Object c;
        public final C2394s d;

        b(C2394s c2394s) {
            c2394s.getClass();
            this.d = c2394s;
        }
    }

    static int A(int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) {
        A a2 = (A) jVar;
        int I = I(bArr, i2, bVar);
        a2.b1(AbstractC2384h.c(bVar.a));
        while (I < i3) {
            int I2 = I(bArr, I, bVar);
            if (i != bVar.a) {
                break;
            }
            I = I(bArr, I2, bVar);
            a2.b1(AbstractC2384h.c(bVar.a));
        }
        return I;
    }

    static int B(int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) {
        G g = (G) jVar;
        int iL = L(bArr, i2, bVar);
        g.l1(AbstractC2384h.d(bVar.b));
        while (iL < i3) {
            int I = I(bArr, iL, bVar);
            if (i != bVar.a) {
                break;
            }
            iL = L(bArr, I, bVar);
            g.l1(AbstractC2384h.d(bVar.b));
        }
        return iL;
    }

    static int C(byte[] bArr, int i, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i, bVar);
        int i2 = bVar.a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i2 == 0) {
            bVar.c = "";
            return I;
        }
        bVar.c = new String(bArr, I, i2, B.b);
        return I + i2;
    }

    static int D(int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i2, bVar);
        int i4 = bVar.a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i4 == 0) {
            jVar.add("");
        } else {
            jVar.add(new String(bArr, I, i4, B.b));
            I += i4;
        }
        while (I < i3) {
            int I2 = I(bArr, I, bVar);
            if (i != bVar.a) {
                break;
            }
            I = I(bArr, I2, bVar);
            int i5 = bVar.a;
            if (i5 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i5 == 0) {
                jVar.add("");
            } else {
                jVar.add(new String(bArr, I, i5, B.b));
                I += i5;
            }
        }
        return I;
    }

    static int E(int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i2, bVar);
        int i4 = bVar.a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i4 == 0) {
            jVar.add("");
        } else {
            int i5 = I + i4;
            if (!p0.t(bArr, I, i5)) {
                throw InvalidProtocolBufferException.d();
            }
            jVar.add(new String(bArr, I, i4, B.b));
            I = i5;
        }
        while (I < i3) {
            int I2 = I(bArr, I, bVar);
            if (i != bVar.a) {
                break;
            }
            I = I(bArr, I2, bVar);
            int i6 = bVar.a;
            if (i6 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i6 == 0) {
                jVar.add("");
            } else {
                int i7 = I + i6;
                if (!p0.t(bArr, I, i7)) {
                    throw InvalidProtocolBufferException.d();
                }
                jVar.add(new String(bArr, I, i6, B.b));
                I = i7;
            }
        }
        return I;
    }

    static int F(byte[] bArr, int i, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i, bVar);
        int i2 = bVar.a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i2 == 0) {
            bVar.c = "";
            return I;
        }
        bVar.c = p0.h(bArr, I, i2);
        return I + i2;
    }

    static int G(int i, byte[] bArr, int i2, int i3, m0 m0Var, b bVar) throws InvalidProtocolBufferException {
        if (r0.a(i) == 0) {
            throw InvalidProtocolBufferException.c();
        }
        int iB = r0.b(i);
        if (iB == 0) {
            int iL = L(bArr, i2, bVar);
            m0Var.r(i, Long.valueOf(bVar.b));
            return iL;
        }
        if (iB == 1) {
            m0Var.r(i, Long.valueOf(j(bArr, i2)));
            return i2 + 8;
        }
        if (iB == 2) {
            int I = I(bArr, i2, bVar);
            int i4 = bVar.a;
            if (i4 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i4 > bArr.length - I) {
                throw InvalidProtocolBufferException.p();
            }
            if (i4 == 0) {
                m0Var.r(i, AbstractC2383g.b);
            } else {
                m0Var.r(i, AbstractC2383g.L(bArr, I, i4));
            }
            return I + i4;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw InvalidProtocolBufferException.c();
            }
            m0Var.r(i, Integer.valueOf(h(bArr, i2)));
            return i2 + 4;
        }
        m0 m0VarO = m0.o();
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int I2 = I(bArr, i2, bVar);
            int i7 = bVar.a;
            if (i7 == i5) {
                i6 = i7;
                i2 = I2;
                break;
            }
            i6 = i7;
            i2 = G(i7, bArr, I2, i3, m0VarO, bVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw InvalidProtocolBufferException.j();
        }
        m0Var.r(i, m0VarO);
        return i2;
    }

    static int H(int i, byte[] bArr, int i2, b bVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            bVar.a = i3 | (b2 << 7);
            return i4;
        }
        int i5 = i3 | ((b2 & 127) << 7);
        int i6 = i2 + 2;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            bVar.a = i5 | (b3 << 14);
            return i6;
        }
        int i7 = i5 | ((b3 & 127) << 14);
        int i8 = i2 + 3;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            bVar.a = i7 | (b4 << 21);
            return i8;
        }
        int i9 = i7 | ((b4 & 127) << 21);
        int i10 = i2 + 4;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            bVar.a = i9 | (b5 << 28);
            return i10;
        }
        int i11 = i9 | ((b5 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                bVar.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int I(byte[] bArr, int i, b bVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return H(b2, bArr, i2, bVar);
        }
        bVar.a = b2;
        return i2;
    }

    static int J(int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) {
        A a2 = (A) jVar;
        int I = I(bArr, i2, bVar);
        a2.b1(bVar.a);
        while (I < i3) {
            int I2 = I(bArr, I, bVar);
            if (i != bVar.a) {
                break;
            }
            I = I(bArr, I2, bVar);
            a2.b1(bVar.a);
        }
        return I;
    }

    static int K(long j, byte[] bArr, int i, b bVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        long j2 = (j & 127) | ((b2 & 127) << 7);
        int i3 = 7;
        while (b2 < 0) {
            int i4 = i2 + 1;
            byte b3 = bArr[i2];
            i3 += 7;
            j2 |= (b3 & 127) << i3;
            i2 = i4;
            b2 = b3;
        }
        bVar.b = j2;
        return i2;
    }

    static int L(byte[] bArr, int i, b bVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j < 0) {
            return K(j, bArr, i2, bVar);
        }
        bVar.b = j;
        return i2;
    }

    static int M(int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) {
        G g = (G) jVar;
        int iL = L(bArr, i2, bVar);
        g.l1(bVar.b);
        while (iL < i3) {
            int I = I(bArr, iL, bVar);
            if (i != bVar.a) {
                break;
            }
            iL = L(bArr, I, bVar);
            g.l1(bVar.b);
        }
        return iL;
    }

    static int N(Object obj, e0 e0Var, byte[] bArr, int i, int i2, int i3, b bVar) {
        int iH0 = ((S) e0Var).h0(obj, bArr, i, i2, i3, bVar);
        bVar.c = obj;
        return iH0;
    }

    static int O(Object obj, e0 e0Var, byte[] bArr, int i, int i2, b bVar) throws InvalidProtocolBufferException {
        int iH = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iH = H(i3, bArr, iH, bVar);
            i3 = bVar.a;
        }
        int i4 = iH;
        if (i3 < 0 || i3 > i2 - i4) {
            throw InvalidProtocolBufferException.p();
        }
        int i5 = i3 + i4;
        e0Var.j(obj, bArr, i4, i5, bVar);
        bVar.c = obj;
        return i5;
    }

    static int P(int i, byte[] bArr, int i2, int i3, b bVar) throws InvalidProtocolBufferException {
        if (r0.a(i) == 0) {
            throw InvalidProtocolBufferException.c();
        }
        int iB = r0.b(i);
        if (iB == 0) {
            return L(bArr, i2, bVar);
        }
        if (iB == 1) {
            return i2 + 8;
        }
        if (iB == 2) {
            return I(bArr, i2, bVar) + bVar.a;
        }
        if (iB != 3) {
            if (iB == 5) {
                return i2 + 4;
            }
            throw InvalidProtocolBufferException.c();
        }
        int i4 = (i & (-8)) | 4;
        int i5 = 0;
        while (i2 < i3) {
            i2 = I(bArr, i2, bVar);
            i5 = bVar.a;
            if (i5 == i4) {
                break;
            }
            i2 = P(i5, bArr, i2, i3, bVar);
        }
        if (i2 > i3 || i5 != i4) {
            throw InvalidProtocolBufferException.j();
        }
        return i2;
    }

    static int a(int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) {
        C2382f c2382f = (C2382f) jVar;
        int iL = L(bArr, i2, bVar);
        c2382f.o(bVar.b != 0);
        while (iL < i3) {
            int I = I(bArr, iL, bVar);
            if (i != bVar.a) {
                break;
            }
            iL = L(bArr, I, bVar);
            c2382f.o(bVar.b != 0);
        }
        return iL;
    }

    static int b(byte[] bArr, int i, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i, bVar);
        int i2 = bVar.a;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i2 > bArr.length - I) {
            throw InvalidProtocolBufferException.p();
        }
        if (i2 == 0) {
            bVar.c = AbstractC2383g.b;
            return I;
        }
        bVar.c = AbstractC2383g.L(bArr, I, i2);
        return I + i2;
    }

    static int c(int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) throws InvalidProtocolBufferException {
        int I = I(bArr, i2, bVar);
        int i4 = bVar.a;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        if (i4 > bArr.length - I) {
            throw InvalidProtocolBufferException.p();
        }
        if (i4 == 0) {
            jVar.add(AbstractC2383g.b);
        } else {
            jVar.add(AbstractC2383g.L(bArr, I, i4));
            I += i4;
        }
        while (I < i3) {
            int I2 = I(bArr, I, bVar);
            if (i != bVar.a) {
                break;
            }
            I = I(bArr, I2, bVar);
            int i5 = bVar.a;
            if (i5 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (i5 > bArr.length - I) {
                throw InvalidProtocolBufferException.p();
            }
            if (i5 == 0) {
                jVar.add(AbstractC2383g.b);
            } else {
                jVar.add(AbstractC2383g.L(bArr, I, i5));
                I += i5;
            }
        }
        return I;
    }

    static double d(byte[] bArr, int i) {
        return Double.longBitsToDouble(j(bArr, i));
    }

    static int e(int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) {
        C2392p c2392p = (C2392p) jVar;
        c2392p.s1(d(bArr, i2));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int I = I(bArr, i4, bVar);
            if (i != bVar.a) {
                break;
            }
            c2392p.s1(d(bArr, I));
            i4 = I + 8;
        }
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static int f(int i, byte[] bArr, int i2, int i3, GeneratedMessageLite.ExtendableMessage extendableMessage, GeneratedMessageLite.f fVar, l0 l0Var, b bVar) throws InvalidProtocolBufferException {
        C2399x c2399x = extendableMessage.extensions;
        int i4 = i >>> 3;
        if (fVar.d.b() && fVar.d.f()) {
            switch (a.a[fVar.d().ordinal()]) {
                case 1:
                    C2392p c2392p = new C2392p();
                    int iS = s(bArr, i2, c2392p, bVar);
                    c2399x.C(fVar.d, c2392p);
                    return iS;
                case 2:
                    C2400y c2400y = new C2400y();
                    int iV = v(bArr, i2, c2400y, bVar);
                    c2399x.C(fVar.d, c2400y);
                    return iV;
                case 3:
                case 4:
                    G g = new G();
                    int iZ = z(bArr, i2, g, bVar);
                    c2399x.C(fVar.d, g);
                    return iZ;
                case 5:
                case 6:
                    A a2 = new A();
                    int iY = y(bArr, i2, a2, bVar);
                    c2399x.C(fVar.d, a2);
                    return iY;
                case 7:
                case 8:
                    G g2 = new G();
                    int iU = u(bArr, i2, g2, bVar);
                    c2399x.C(fVar.d, g2);
                    return iU;
                case 9:
                case 10:
                    A a3 = new A();
                    int iT = t(bArr, i2, a3, bVar);
                    c2399x.C(fVar.d, a3);
                    return iT;
                case 11:
                    C2382f c2382f = new C2382f();
                    int iR = r(bArr, i2, c2382f, bVar);
                    c2399x.C(fVar.d, c2382f);
                    return iR;
                case 12:
                    A a4 = new A();
                    int iW = w(bArr, i2, a4, bVar);
                    c2399x.C(fVar.d, a4);
                    return iW;
                case 13:
                    G g3 = new G();
                    int iX = x(bArr, i2, g3, bVar);
                    c2399x.C(fVar.d, g3);
                    return iX;
                case 14:
                    A a5 = new A();
                    int iY2 = y(bArr, i2, a5, bVar);
                    g0.z(extendableMessage, i4, a5, fVar.d.h(), null, l0Var);
                    c2399x.C(fVar.d, a5);
                    return iY2;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + fVar.d.e());
            }
        }
        Object objValueOf = null;
        if (fVar.d() == r0.b.p) {
            i2 = I(bArr, i2, bVar);
            if (fVar.d.h().a(bVar.a) == null) {
                g0.L(extendableMessage, i4, bVar.a, null, l0Var);
                return i2;
            }
            objValueOf = Integer.valueOf(bVar.a);
        } else {
            switch (a.a[fVar.d().ordinal()]) {
                case 1:
                    objValueOf = Double.valueOf(d(bArr, i2));
                    i2 += 8;
                    break;
                case 2:
                    objValueOf = Float.valueOf(l(bArr, i2));
                    i2 += 4;
                    break;
                case 3:
                case 4:
                    i2 = L(bArr, i2, bVar);
                    objValueOf = Long.valueOf(bVar.b);
                    break;
                case 5:
                case 6:
                    i2 = I(bArr, i2, bVar);
                    objValueOf = Integer.valueOf(bVar.a);
                    break;
                case 7:
                case 8:
                    objValueOf = Long.valueOf(j(bArr, i2));
                    i2 += 8;
                    break;
                case 9:
                case 10:
                    objValueOf = Integer.valueOf(h(bArr, i2));
                    i2 += 4;
                    break;
                case 11:
                    i2 = L(bArr, i2, bVar);
                    objValueOf = Boolean.valueOf(bVar.b != 0);
                    break;
                case 12:
                    i2 = I(bArr, i2, bVar);
                    objValueOf = Integer.valueOf(AbstractC2384h.c(bVar.a));
                    break;
                case 13:
                    i2 = L(bArr, i2, bVar);
                    objValueOf = Long.valueOf(AbstractC2384h.d(bVar.b));
                    break;
                case 14:
                    throw new IllegalStateException("Shouldn't reach here.");
                case 15:
                    i2 = b(bArr, i2, bVar);
                    objValueOf = bVar.c;
                    break;
                case 16:
                    i2 = C(bArr, i2, bVar);
                    objValueOf = bVar.c;
                    break;
                case 17:
                    int i5 = (i4 << 3) | 4;
                    e0 e0VarC = a0.a().c(fVar.e().getClass());
                    if (fVar.g()) {
                        int iN = n(e0VarC, bArr, i2, i3, i5, bVar);
                        c2399x.a(fVar.d, bVar.c);
                        return iN;
                    }
                    Object objI = c2399x.i(fVar.d);
                    if (objI == null) {
                        objI = e0VarC.d();
                        c2399x.C(fVar.d, objI);
                    }
                    return N(objI, e0VarC, bArr, i2, i3, i5, bVar);
                case 18:
                    e0 e0VarC2 = a0.a().c(fVar.e().getClass());
                    if (fVar.g()) {
                        int iP = p(e0VarC2, bArr, i2, i3, bVar);
                        c2399x.a(fVar.d, bVar.c);
                        return iP;
                    }
                    Object objI2 = c2399x.i(fVar.d);
                    if (objI2 == null) {
                        objI2 = e0VarC2.d();
                        c2399x.C(fVar.d, objI2);
                    }
                    return O(objI2, e0VarC2, bArr, i2, i3, bVar);
            }
        }
        if (fVar.g()) {
            c2399x.a(fVar.d, objValueOf);
        } else {
            c2399x.C(fVar.d, objValueOf);
        }
        return i2;
    }

    static int g(int i, byte[] bArr, int i2, int i3, Object obj, P p, l0 l0Var, b bVar) {
        GeneratedMessageLite.f fVarA = bVar.d.a(p, i >>> 3);
        if (fVarA == null) {
            return G(i, bArr, i2, i3, S.x(obj), bVar);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.ensureExtensionsAreMutable();
        return f(i, bArr, i2, i3, extendableMessage, fVarA, l0Var, bVar);
    }

    static int h(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static int i(int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) {
        A a2 = (A) jVar;
        a2.b1(h(bArr, i2));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int I = I(bArr, i4, bVar);
            if (i != bVar.a) {
                break;
            }
            a2.b1(h(bArr, I));
            i4 = I + 4;
        }
        return i4;
    }

    static long j(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    static int k(int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) {
        G g = (G) jVar;
        g.l1(j(bArr, i2));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int I = I(bArr, i4, bVar);
            if (i != bVar.a) {
                break;
            }
            g.l1(j(bArr, I));
            i4 = I + 8;
        }
        return i4;
    }

    static float l(byte[] bArr, int i) {
        return Float.intBitsToFloat(h(bArr, i));
    }

    static int m(int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) {
        C2400y c2400y = (C2400y) jVar;
        c2400y.M(l(bArr, i2));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int I = I(bArr, i4, bVar);
            if (i != bVar.a) {
                break;
            }
            c2400y.M(l(bArr, I));
            i4 = I + 4;
        }
        return i4;
    }

    static int n(e0 e0Var, byte[] bArr, int i, int i2, int i3, b bVar) {
        Object objD = e0Var.d();
        int iN = N(objD, e0Var, bArr, i, i2, i3, bVar);
        e0Var.e(objD);
        bVar.c = objD;
        return iN;
    }

    static int o(e0 e0Var, int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) {
        int i4 = (i & (-8)) | 4;
        int iN = n(e0Var, bArr, i2, i3, i4, bVar);
        jVar.add(bVar.c);
        while (iN < i3) {
            int I = I(bArr, iN, bVar);
            if (i != bVar.a) {
                break;
            }
            iN = n(e0Var, bArr, I, i3, i4, bVar);
            jVar.add(bVar.c);
        }
        return iN;
    }

    static int p(e0 e0Var, byte[] bArr, int i, int i2, b bVar) throws InvalidProtocolBufferException {
        Object objD = e0Var.d();
        int iO = O(objD, e0Var, bArr, i, i2, bVar);
        e0Var.e(objD);
        bVar.c = objD;
        return iO;
    }

    static int q(e0 e0Var, int i, byte[] bArr, int i2, int i3, B.j jVar, b bVar) throws InvalidProtocolBufferException {
        int iP = p(e0Var, bArr, i2, i3, bVar);
        jVar.add(bVar.c);
        while (iP < i3) {
            int I = I(bArr, iP, bVar);
            if (i != bVar.a) {
                break;
            }
            iP = p(e0Var, bArr, I, i3, bVar);
            jVar.add(bVar.c);
        }
        return iP;
    }

    static int r(byte[] bArr, int i, B.j jVar, b bVar) throws InvalidProtocolBufferException {
        C2382f c2382f = (C2382f) jVar;
        int I = I(bArr, i, bVar);
        int i2 = bVar.a + I;
        while (I < i2) {
            I = L(bArr, I, bVar);
            c2382f.o(bVar.b != 0);
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int s(byte[] bArr, int i, B.j jVar, b bVar) throws InvalidProtocolBufferException {
        C2392p c2392p = (C2392p) jVar;
        int I = I(bArr, i, bVar);
        int i2 = bVar.a + I;
        while (I < i2) {
            c2392p.s1(d(bArr, I));
            I += 8;
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int t(byte[] bArr, int i, B.j jVar, b bVar) throws InvalidProtocolBufferException {
        A a2 = (A) jVar;
        int I = I(bArr, i, bVar);
        int i2 = bVar.a + I;
        while (I < i2) {
            a2.b1(h(bArr, I));
            I += 4;
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int u(byte[] bArr, int i, B.j jVar, b bVar) throws InvalidProtocolBufferException {
        G g = (G) jVar;
        int I = I(bArr, i, bVar);
        int i2 = bVar.a + I;
        while (I < i2) {
            g.l1(j(bArr, I));
            I += 8;
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int v(byte[] bArr, int i, B.j jVar, b bVar) throws InvalidProtocolBufferException {
        C2400y c2400y = (C2400y) jVar;
        int I = I(bArr, i, bVar);
        int i2 = bVar.a + I;
        while (I < i2) {
            c2400y.M(l(bArr, I));
            I += 4;
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int w(byte[] bArr, int i, B.j jVar, b bVar) throws InvalidProtocolBufferException {
        A a2 = (A) jVar;
        int I = I(bArr, i, bVar);
        int i2 = bVar.a + I;
        while (I < i2) {
            I = I(bArr, I, bVar);
            a2.b1(AbstractC2384h.c(bVar.a));
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int x(byte[] bArr, int i, B.j jVar, b bVar) throws InvalidProtocolBufferException {
        G g = (G) jVar;
        int I = I(bArr, i, bVar);
        int i2 = bVar.a + I;
        while (I < i2) {
            I = L(bArr, I, bVar);
            g.l1(AbstractC2384h.d(bVar.b));
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int y(byte[] bArr, int i, B.j jVar, b bVar) throws InvalidProtocolBufferException {
        A a2 = (A) jVar;
        int I = I(bArr, i, bVar);
        int i2 = bVar.a + I;
        while (I < i2) {
            I = I(bArr, I, bVar);
            a2.b1(bVar.a);
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.p();
    }

    static int z(byte[] bArr, int i, B.j jVar, b bVar) throws InvalidProtocolBufferException {
        G g = (G) jVar;
        int I = I(bArr, i, bVar);
        int i2 = bVar.a + I;
        while (I < i2) {
            I = L(bArr, I, bVar);
            g.l1(bVar.b);
        }
        if (I == i2) {
            return I;
        }
        throw InvalidProtocolBufferException.p();
    }
}
