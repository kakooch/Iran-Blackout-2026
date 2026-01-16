package ir.nasim;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;

/* renamed from: ir.nasim.ty3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC21692ty3 {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final android.view.inputmethod.CursorAnchorInfo.Builder a(android.view.inputmethod.CursorAnchorInfo.Builder r17, int r18, int r19, ir.nasim.InterfaceC11600dH4 r20, ir.nasim.C13774gn7 r21, ir.nasim.CK5 r22) {
        /*
            r0 = r19
            r1 = r20
            r2 = r18
            r3 = r22
            int r4 = r1.b(r2)
            int r5 = r1.b(r0)
            int r6 = r5 - r4
            int r6 = r6 * 4
            float[] r6 = new float[r6]
            ir.nasim.yl4 r7 = r21.w()
            long r8 = ir.nasim.AbstractC4535Fn7.b(r4, r5)
            r5 = 0
            r7.a(r8, r6, r5)
        L22:
            if (r2 >= r0) goto L8e
            int r5 = r1.b(r2)
            int r7 = r5 - r4
            int r7 = r7 * 4
            ir.nasim.CK5 r8 = new ir.nasim.CK5
            r9 = r6[r7]
            int r10 = r7 + 1
            r10 = r6[r10]
            int r11 = r7 + 2
            r11 = r6[r11]
            int r7 = r7 + 3
            r7 = r6[r7]
            r8.<init>(r9, r10, r11, r7)
            boolean r7 = r3.q(r8)
            float r9 = r8.i()
            float r10 = r8.l()
            boolean r9 = c(r3, r9, r10)
            if (r9 == 0) goto L63
            float r9 = r8.j()
            float r10 = r8.e()
            boolean r9 = c(r3, r9, r10)
            if (r9 != 0) goto L60
            goto L63
        L60:
            r9 = r21
            goto L66
        L63:
            r7 = r7 | 2
            goto L60
        L66:
            ir.nasim.AW5 r5 = r9.c(r5)
            ir.nasim.AW5 r10 = ir.nasim.AW5.b
            if (r5 != r10) goto L73
            r5 = r7 | 4
            r16 = r5
            goto L75
        L73:
            r16 = r7
        L75:
            float r12 = r8.i()
            float r13 = r8.l()
            float r14 = r8.j()
            float r15 = r8.e()
            r10 = r17
            r11 = r2
            r10.addCharacterBounds(r11, r12, r13, r14, r15, r16)
            int r2 = r2 + 1
            goto L22
        L8e:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC21692ty3.a(android.view.inputmethod.CursorAnchorInfo$Builder, int, int, ir.nasim.dH4, ir.nasim.gn7, ir.nasim.CK5):android.view.inputmethod.CursorAnchorInfo$Builder");
    }

    public static final CursorAnchorInfo b(CursorAnchorInfo.Builder builder, C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4, C13774gn7 c13774gn7, Matrix matrix, CK5 ck5, CK5 ck52, boolean z, boolean z2, boolean z3, boolean z4) {
        builder.reset();
        builder.setMatrix(matrix);
        int iL = C4301En7.l(c23945xm7.g());
        builder.setSelectionRange(iL, C4301En7.k(c23945xm7.g()));
        if (z) {
            d(builder, iL, interfaceC11600dH4, c13774gn7, ck5);
        }
        if (z2) {
            C4301En7 c4301En7F = c23945xm7.f();
            int iL2 = c4301En7F != null ? C4301En7.l(c4301En7F.r()) : -1;
            C4301En7 c4301En7F2 = c23945xm7.f();
            int iK = c4301En7F2 != null ? C4301En7.k(c4301En7F2.r()) : -1;
            if (iL2 >= 0 && iL2 < iK) {
                builder.setComposingText(iL2, c23945xm7.h().subSequence(iL2, iK));
                a(builder, iL2, iK, interfaceC11600dH4, c13774gn7, ck5);
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 && z3) {
            C25222zw1.a(builder, ck52);
        }
        if (i >= 34 && z4) {
            C3908Cw1.a(builder, c13774gn7, ck5);
        }
        return builder.build();
    }

    public static final boolean c(CK5 ck5, float f, float f2) {
        float fI = ck5.i();
        if (f <= ck5.j() && fI <= f) {
            float fL = ck5.l();
            if (f2 <= ck5.e() && fL <= f2) {
                return true;
            }
        }
        return false;
    }

    private static final CursorAnchorInfo.Builder d(CursorAnchorInfo.Builder builder, int i, InterfaceC11600dH4 interfaceC11600dH4, C13774gn7 c13774gn7, CK5 ck5) {
        if (i < 0) {
            return builder;
        }
        int iB = interfaceC11600dH4.b(i);
        CK5 ck5E = c13774gn7.e(iB);
        float fL = AbstractC23053wG5.l(ck5E.i(), 0.0f, (int) (c13774gn7.B() >> 32));
        boolean zC = c(ck5, fL, ck5E.l());
        boolean zC2 = c(ck5, fL, ck5E.e());
        boolean z = c13774gn7.c(iB) == AW5.b;
        int i2 = (zC || zC2) ? 1 : 0;
        if (!zC || !zC2) {
            i2 |= 2;
        }
        builder.setInsertionMarkerLocation(fL, ck5E.l(), ck5E.e(), ck5E.e(), z ? i2 | 4 : i2);
        return builder;
    }
}
