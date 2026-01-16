package ir.nasim;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* loaded from: classes3.dex */
public class DJ1 {
    private final C4705Gf0 a;

    public DJ1(C4705Gf0 c4705Gf0) {
        this.a = c4705Gf0;
    }

    private float b(C12092e16 c12092e16, C12092e16 c12092e162) {
        float fJ = j((int) c12092e16.c(), (int) c12092e16.d(), (int) c12092e162.c(), (int) c12092e162.d());
        float fJ2 = j((int) c12092e162.c(), (int) c12092e162.d(), (int) c12092e16.c(), (int) c12092e16.d());
        return Float.isNaN(fJ) ? fJ2 / 7.0f : Float.isNaN(fJ2) ? fJ / 7.0f : (fJ + fJ2) / 14.0f;
    }

    private static int c(C12092e16 c12092e16, C12092e16 c12092e162, C12092e16 c12092e163, float f) throws NotFoundException {
        int iC = (AbstractC23186wV3.c(C12092e16.b(c12092e16, c12092e162) / f) + AbstractC23186wV3.c(C12092e16.b(c12092e16, c12092e163) / f)) / 2;
        int i = iC + 7;
        int i2 = i & 3;
        if (i2 == 0) {
            return iC + 8;
        }
        if (i2 == 2) {
            return iC + 6;
        }
        if (i2 != 3) {
            return i;
        }
        throw NotFoundException.a();
    }

    private static J65 d(C12092e16 c12092e16, C12092e16 c12092e162, C12092e16 c12092e163, C12092e16 c12092e164, int i) {
        float fC;
        float fD;
        float f;
        float f2 = i - 3.5f;
        if (c12092e164 != null) {
            fC = c12092e164.c();
            fD = c12092e164.d();
            f = f2 - 3.0f;
        } else {
            fC = (c12092e162.c() - c12092e16.c()) + c12092e163.c();
            fD = (c12092e162.d() - c12092e16.d()) + c12092e163.d();
            f = f2;
        }
        return J65.b(3.5f, 3.5f, f2, 3.5f, f, f, 3.5f, f2, c12092e16.c(), c12092e16.d(), c12092e162.c(), c12092e162.d(), fC, fD, c12092e163.c(), c12092e163.d());
    }

    private static C4705Gf0 h(C4705Gf0 c4705Gf0, J65 j65, int i) {
        return AbstractC12277eL2.b().d(c4705Gf0, i, i, j65);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0087, code lost:
    
        if (r15 != r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008f, code lost:
    
        return ir.nasim.AbstractC23186wV3.b(r19, r6, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float i(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = r3
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r4 = r18
            r1 = r19
            r6 = r20
            r5 = r21
            goto L25
        L1d:
            r1 = r18
            r4 = r19
            r5 = r20
            r6 = r21
        L25:
            int r7 = r5 - r1
            int r7 = java.lang.Math.abs(r7)
            int r8 = r6 - r4
            int r8 = java.lang.Math.abs(r8)
            int r9 = -r7
            r10 = 2
            int r9 = r9 / r10
            r11 = -1
            if (r1 >= r5) goto L39
            r12 = r3
            goto L3a
        L39:
            r12 = r11
        L3a:
            if (r4 >= r6) goto L3d
            r11 = r3
        L3d:
            int r5 = r5 + r12
            r13 = r1
            r14 = r4
            r15 = 0
        L41:
            if (r13 == r5) goto L82
            if (r0 == 0) goto L47
            r2 = r14
            goto L48
        L47:
            r2 = r13
        L48:
            if (r0 == 0) goto L4c
            r10 = r13
            goto L4d
        L4c:
            r10 = r14
        L4d:
            if (r15 != r3) goto L57
            r16 = r0
            r0 = r3
            r19 = r5
            r3 = r17
            goto L5e
        L57:
            r3 = r17
            r16 = r0
            r19 = r5
            r0 = 0
        L5e:
            ir.nasim.Gf0 r5 = r3.a
            boolean r2 = r5.e(r2, r10)
            if (r0 != r2) goto L70
            r0 = 2
            if (r15 != r0) goto L6e
            float r0 = ir.nasim.AbstractC23186wV3.b(r13, r14, r1, r4)
            return r0
        L6e:
            int r15 = r15 + 1
        L70:
            int r9 = r9 + r8
            if (r9 <= 0) goto L7a
            if (r14 == r6) goto L78
            int r14 = r14 + r11
            int r9 = r9 - r7
            goto L7a
        L78:
            r0 = 2
            goto L87
        L7a:
            int r13 = r13 + r12
            r5 = r19
            r0 = r16
            r3 = 1
            r10 = 2
            goto L41
        L82:
            r3 = r17
            r19 = r5
            r0 = r10
        L87:
            if (r15 != r0) goto L90
            r5 = r19
            float r0 = ir.nasim.AbstractC23186wV3.b(r5, r6, r1, r4)
            return r0
        L90:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.DJ1.i(int, int, int, int):float");
    }

    private float j(int i, int i2, int i3, int i4) {
        float fM;
        float fI;
        float fI2 = i(i, i2, i3, i4);
        int iM = i - (i3 - i);
        int i5 = 0;
        if (iM < 0) {
            fM = i / (i - iM);
            iM = 0;
        } else if (iM >= this.a.m()) {
            fM = ((this.a.m() - 1) - i) / (iM - i);
            iM = this.a.m() - 1;
        } else {
            fM = 1.0f;
        }
        float f = i2;
        int i6 = (int) (f - ((i4 - i2) * fM));
        if (i6 < 0) {
            fI = f / (i2 - i6);
        } else if (i6 >= this.a.i()) {
            fI = ((this.a.i() - 1) - i2) / (i6 - i2);
            i5 = this.a.i() - 1;
        } else {
            i5 = i6;
            fI = 1.0f;
        }
        return (fI2 + i(i, i2, (int) (i + ((iM - i) * fI)), i5)) - 1.0f;
    }

    protected final float a(C12092e16 c12092e16, C12092e16 c12092e162, C12092e16 c12092e163) {
        return (b(c12092e16, c12092e162) + b(c12092e16, c12092e163)) / 2.0f;
    }

    public final FJ1 e(Map map) {
        if (map != null) {
            AbstractC18350oW3.a(map.get(EnumC19932rB1.NEED_RESULT_POINT_CALLBACK));
        }
        return g(new C25144zo2(this.a, null).f(map));
    }

    protected final C16138km f(float f, int i, int i2, float f2) throws NotFoundException {
        int i3 = (int) (f2 * f);
        int iMax = Math.max(0, i - i3);
        int iMin = Math.min(this.a.m() - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin < f3) {
            throw NotFoundException.a();
        }
        int iMax2 = Math.max(0, i2 - i3);
        int iMin2 = Math.min(this.a.i() - 1, i2 + i3) - iMax2;
        if (iMin2 >= f3) {
            return new C16729lm(this.a, iMax, iMax2, iMin, iMin2, f, null).c();
        }
        throw NotFoundException.a();
    }

    protected final FJ1 g(C3364Ao2 c3364Ao2) throws NotFoundException, FormatException {
        C16138km c16138kmF;
        C23960xo2 c23960xo2B = c3364Ao2.b();
        C23960xo2 c23960xo2C = c3364Ao2.c();
        C23960xo2 c23960xo2A = c3364Ao2.a();
        float fA = a(c23960xo2B, c23960xo2C, c23960xo2A);
        if (fA < 1.0f) {
            throw NotFoundException.a();
        }
        int iC = c(c23960xo2B, c23960xo2C, c23960xo2A, fA);
        YR7 yr7G = YR7.g(iC);
        int iE = yr7G.e() - 7;
        if (yr7G.d().length > 0) {
            float fC = (c23960xo2C.c() - c23960xo2B.c()) + c23960xo2A.c();
            float fD = (c23960xo2C.d() - c23960xo2B.d()) + c23960xo2A.d();
            float f = 1.0f - (3.0f / iE);
            int iC2 = (int) (c23960xo2B.c() + ((fC - c23960xo2B.c()) * f));
            int iD = (int) (c23960xo2B.d() + (f * (fD - c23960xo2B.d())));
            for (int i = 4; i <= 16; i <<= 1) {
                try {
                    c16138kmF = f(fA, iC2, iD, i);
                    break;
                } catch (NotFoundException unused) {
                }
            }
            c16138kmF = null;
        } else {
            c16138kmF = null;
        }
        return new FJ1(h(this.a, d(c23960xo2B, c23960xo2C, c23960xo2A, c16138kmF, iC), iC), c16138kmF == null ? new C12092e16[]{c23960xo2A, c23960xo2B, c23960xo2C} : new C12092e16[]{c23960xo2A, c23960xo2B, c23960xo2C, c16138kmF});
    }
}
