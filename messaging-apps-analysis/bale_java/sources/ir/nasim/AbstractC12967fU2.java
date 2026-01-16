package ir.nasim;

import android.graphics.PointF;

/* renamed from: ir.nasim.fU2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC12967fU2 {

    /* renamed from: ir.nasim.fU2$a */
    public static final class a implements InterfaceC18081o32 {
        final /* synthetic */ InterfaceC18081o32[] a;

        a(InterfaceC18081o32[] interfaceC18081o32Arr) {
            this.a = interfaceC18081o32Arr;
        }

        @Override // ir.nasim.InterfaceC18081o32
        public void a(M42 m42) {
            for (InterfaceC18081o32 interfaceC18081o32 : this.a) {
                interfaceC18081o32.a(m42);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j(long j, CharSequence charSequence) {
        int iN = C4301En7.n(j);
        int i = C4301En7.i(j);
        int iCodePointBefore = iN > 0 ? Character.codePointBefore(charSequence, iN) : 10;
        int iCodePointAt = i < charSequence.length() ? Character.codePointAt(charSequence, i) : 10;
        if (x(iCodePointBefore) && (w(iCodePointAt) || v(iCodePointAt))) {
            do {
                iN -= Character.charCount(iCodePointBefore);
                if (iN == 0) {
                    break;
                }
                iCodePointBefore = Character.codePointBefore(charSequence, iN);
            } while (x(iCodePointBefore));
            return AbstractC4535Fn7.b(iN, i);
        }
        if (!x(iCodePointAt)) {
            return j;
        }
        if (!w(iCodePointBefore) && !v(iCodePointBefore)) {
            return j;
        }
        do {
            i += Character.charCount(iCodePointAt);
            if (i == charSequence.length()) {
                break;
            }
            iCodePointAt = Character.codePointAt(charSequence, i);
        } while (x(iCodePointAt));
        return AbstractC4535Fn7.b(iN, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC18081o32 k(InterfaceC18081o32... interfaceC18081o32Arr) {
        return new a(interfaceC18081o32Arr);
    }

    private static final long l(long j, long j2) {
        return AbstractC4535Fn7.b(Math.min(C4301En7.n(j), C4301En7.n(j)), Math.max(C4301En7.i(j2), C4301En7.i(j2)));
    }

    private static final int m(C24522yl4 c24522yl4, long j, InterfaceC18354oW7 interfaceC18354oW7) {
        float fH = interfaceC18354oW7 != null ? interfaceC18354oW7.h() : 0.0f;
        int i = (int) (4294967295L & j);
        int iQ = c24522yl4.q(Float.intBitsToFloat(i));
        if (Float.intBitsToFloat(i) >= c24522yl4.v(iQ) - fH && Float.intBitsToFloat(i) <= c24522yl4.l(iQ) + fH) {
            int i2 = (int) (j >> 32);
            if (Float.intBitsToFloat(i2) >= (-fH) && Float.intBitsToFloat(i2) <= c24522yl4.D() + fH) {
                return iQ;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(C6542Ny3 c6542Ny3, long j, InterfaceC18354oW7 interfaceC18354oW7) {
        C13774gn7 c13774gn7F;
        C24522yl4 c24522yl4W;
        C14367hn7 c14367hn7L = c6542Ny3.l();
        if (c14367hn7L == null || (c13774gn7F = c14367hn7L.f()) == null || (c24522yl4W = c13774gn7F.w()) == null) {
            return -1;
        }
        return o(c24522yl4W, j, c6542Ny3.k(), interfaceC18354oW7);
    }

    private static final int o(C24522yl4 c24522yl4, long j, InterfaceC11379cu3 interfaceC11379cu3, InterfaceC18354oW7 interfaceC18354oW7) {
        long jP;
        int iM;
        if (interfaceC11379cu3 == null || (iM = m(c24522yl4, (jP = interfaceC11379cu3.p(j)), interfaceC18354oW7)) == -1) {
            return -1;
        }
        return c24522yl4.x(ZG4.g(jP, 0.0f, (c24522yl4.v(iM) + c24522yl4.l(iM)) / 2.0f, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long p(C13774gn7 c13774gn7, long j, long j2, InterfaceC11379cu3 interfaceC11379cu3, InterfaceC18354oW7 interfaceC18354oW7) {
        if (c13774gn7 == null || interfaceC11379cu3 == null) {
            return C4301En7.b.a();
        }
        long jP = interfaceC11379cu3.p(j);
        long jP2 = interfaceC11379cu3.p(j2);
        int iM = m(c13774gn7.w(), jP, interfaceC18354oW7);
        int iM2 = m(c13774gn7.w(), jP2, interfaceC18354oW7);
        if (iM != -1) {
            if (iM2 != -1) {
                iM = Math.min(iM, iM2);
            }
            iM2 = iM;
        } else if (iM2 == -1) {
            return C4301En7.b.a();
        }
        float fV = (c13774gn7.v(iM2) + c13774gn7.m(iM2)) / 2;
        int i = (int) (jP >> 32);
        int i2 = (int) (jP2 >> 32);
        return c13774gn7.w().C(new CK5(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), fV - 0.1f, Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), fV + 0.1f), AbstractC4058Dm7.a.a(), InterfaceC5243Im7.a.g());
    }

    private static final long q(C24522yl4 c24522yl4, CK5 ck5, InterfaceC11379cu3 interfaceC11379cu3, int i, InterfaceC5243Im7 interfaceC5243Im7) {
        return (c24522yl4 == null || interfaceC11379cu3 == null) ? C4301En7.b.a() : c24522yl4.C(ck5.s(interfaceC11379cu3.p(ZG4.b.c())), i, interfaceC5243Im7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long r(C6542Ny3 c6542Ny3, CK5 ck5, int i, InterfaceC5243Im7 interfaceC5243Im7) {
        C13774gn7 c13774gn7F;
        C14367hn7 c14367hn7L = c6542Ny3.l();
        return q((c14367hn7L == null || (c13774gn7F = c14367hn7L.f()) == null) ? null : c13774gn7F.w(), ck5, c6542Ny3.k(), i, interfaceC5243Im7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long s(C6542Ny3 c6542Ny3, CK5 ck5, CK5 ck52, int i, InterfaceC5243Im7 interfaceC5243Im7) {
        long jR = r(c6542Ny3, ck5, i, interfaceC5243Im7);
        if (C4301En7.h(jR)) {
            return C4301En7.b.a();
        }
        long jR2 = r(c6542Ny3, ck52, i, interfaceC5243Im7);
        return C4301En7.h(jR2) ? C4301En7.b.a() : l(jR, jR2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean t(C13774gn7 c13774gn7, int i) {
        int iQ = c13774gn7.q(i);
        return (i == c13774gn7.u(iQ) || i == C13774gn7.p(c13774gn7, iQ, false, 2, null)) ? c13774gn7.y(i) != c13774gn7.c(i) : c13774gn7.c(i) != c13774gn7.c(i - 1);
    }

    private static final boolean u(int i) {
        int type = Character.getType(i);
        return type == 14 || type == 13 || i == 10;
    }

    private static final boolean v(int i) {
        int type = Character.getType(i);
        return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
    }

    private static final boolean w(int i) {
        return Character.isWhitespace(i) || i == 160;
    }

    private static final boolean x(int i) {
        return w(i) && !u(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long y(CharSequence charSequence, int i) {
        int iCharCount = i;
        while (iCharCount > 0) {
            int iC = HW0.c(charSequence, iCharCount);
            if (!w(iC)) {
                break;
            }
            iCharCount -= Character.charCount(iC);
        }
        while (i < charSequence.length()) {
            int iB = HW0.b(charSequence, i);
            if (!w(iB)) {
                break;
            }
            i += HW0.a(iB);
        }
        return AbstractC4535Fn7.b(iCharCount, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long z(PointF pointF) {
        float f = pointF.x;
        float f2 = pointF.y;
        return ZG4.e((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
    }
}
