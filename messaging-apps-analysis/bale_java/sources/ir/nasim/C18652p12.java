package ir.nasim;

import ir.nasim.AbstractC11911dl3;

/* renamed from: ir.nasim.p12, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C18652p12 {
    private static final AbstractC11911dl3.a f = AbstractC11911dl3.a.a("ef");
    private static final AbstractC11911dl3.a g = AbstractC11911dl3.a.a("nm", "v");
    private C16789ls a;
    private C17380ms b;
    private C17380ms c;
    private C17380ms d;
    private C17380ms e;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(ir.nasim.AbstractC11911dl3 r6, ir.nasim.C23677xK3 r7) {
        /*
            r5 = this;
            r6.B()
            java.lang.String r0 = ""
        L5:
            boolean r1 = r6.d()
            if (r1 == 0) goto L90
            ir.nasim.dl3$a r1 = ir.nasim.C18652p12.g
            int r1 = r6.l(r1)
            if (r1 == 0) goto L8a
            r2 = 1
            if (r1 == r2) goto L1d
            r6.m()
            r6.R()
            goto L5
        L1d:
            r0.hashCode()
            int r1 = r0.hashCode()
            r3 = 0
            r4 = -1
            switch(r1) {
                case 353103893: goto L55;
                case 397447147: goto L4c;
                case 1041377119: goto L41;
                case 1379387491: goto L36;
                case 1383710113: goto L2b;
                default: goto L29;
            }
        L29:
            r2 = r4
            goto L5f
        L2b:
            java.lang.String r1 = "Softness"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L34
            goto L29
        L34:
            r2 = 4
            goto L5f
        L36:
            java.lang.String r1 = "Shadow Color"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L3f
            goto L29
        L3f:
            r2 = 3
            goto L5f
        L41:
            java.lang.String r1 = "Direction"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L4a
            goto L29
        L4a:
            r2 = 2
            goto L5f
        L4c:
            java.lang.String r1 = "Opacity"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L5f
            goto L29
        L55:
            java.lang.String r1 = "Distance"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L5e
            goto L29
        L5e:
            r2 = r3
        L5f:
            switch(r2) {
                case 0: goto L82;
                case 1: goto L7b;
                case 2: goto L74;
                case 3: goto L6d;
                case 4: goto L66;
                default: goto L62;
            }
        L62:
            r6.R()
            goto L5
        L66:
            ir.nasim.ms r1 = ir.nasim.AbstractC4338Es.e(r6, r7)
            r5.e = r1
            goto L5
        L6d:
            ir.nasim.ls r1 = ir.nasim.AbstractC4338Es.c(r6, r7)
            r5.a = r1
            goto L5
        L74:
            ir.nasim.ms r1 = ir.nasim.AbstractC4338Es.f(r6, r7, r3)
            r5.c = r1
            goto L5
        L7b:
            ir.nasim.ms r1 = ir.nasim.AbstractC4338Es.f(r6, r7, r3)
            r5.b = r1
            goto L5
        L82:
            ir.nasim.ms r1 = ir.nasim.AbstractC4338Es.e(r6, r7)
            r5.d = r1
            goto L5
        L8a:
            java.lang.String r0 = r6.T0()
            goto L5
        L90:
            r6.F()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18652p12.a(ir.nasim.dl3, ir.nasim.xK3):void");
    }

    C18061o12 b(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3) {
        C17380ms c17380ms;
        C17380ms c17380ms2;
        C17380ms c17380ms3;
        C17380ms c17380ms4;
        while (abstractC11911dl3.d()) {
            if (abstractC11911dl3.l(f) != 0) {
                abstractC11911dl3.m();
                abstractC11911dl3.R();
            } else {
                abstractC11911dl3.b();
                while (abstractC11911dl3.d()) {
                    a(abstractC11911dl3, c23677xK3);
                }
                abstractC11911dl3.c();
            }
        }
        C16789ls c16789ls = this.a;
        if (c16789ls == null || (c17380ms = this.b) == null || (c17380ms2 = this.c) == null || (c17380ms3 = this.d) == null || (c17380ms4 = this.e) == null) {
            return null;
        }
        return new C18061o12(c16789ls, c17380ms, c17380ms2, c17380ms3, c17380ms4);
    }
}
