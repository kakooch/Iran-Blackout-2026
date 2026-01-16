package ir.nasim;

/* loaded from: classes2.dex */
final class NY2 {
    private final C10550bn7 a;
    private int b = -1;
    private float c;

    public NY2(C10550bn7 c10550bn7) {
        this.a = c10550bn7;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final float a(int r6, boolean r7, boolean r8, boolean r9) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L1f
            ir.nasim.bn7 r2 = r5.a
            android.text.Layout r2 = r2.i()
            int r2 = ir.nasim.AbstractC10616bu3.a(r2, r6, r7)
            ir.nasim.bn7 r3 = r5.a
            int r3 = r3.v(r2)
            ir.nasim.bn7 r4 = r5.a
            int r2 = r4.p(r2)
            if (r6 == r3) goto L21
            if (r6 != r2) goto L1f
            goto L21
        L1f:
            r2 = r1
            goto L22
        L21:
            r2 = r0
        L22:
            int r3 = r6 * 4
            if (r9 == 0) goto L2a
            if (r2 == 0) goto L2f
            r0 = r1
            goto L2f
        L2a:
            if (r2 == 0) goto L2e
            r0 = 2
            goto L2f
        L2e:
            r0 = 3
        L2f:
            int r3 = r3 + r0
            int r0 = r5.b
            if (r0 != r3) goto L37
            float r6 = r5.c
            return r6
        L37:
            if (r9 == 0) goto L40
            ir.nasim.bn7 r9 = r5.a
            float r6 = r9.A(r6, r7)
            goto L46
        L40:
            ir.nasim.bn7 r9 = r5.a
            float r6 = r9.D(r6, r7)
        L46:
            if (r8 == 0) goto L4c
            r5.b = r3
            r5.c = r6
        L4c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.NY2.a(int, boolean, boolean, boolean):float");
    }

    public final float b(int i) {
        return a(i, false, false, true);
    }

    public final float c(int i) {
        return a(i, true, true, true);
    }

    public final float d(int i) {
        return a(i, false, false, false);
    }

    public final float e(int i) {
        return a(i, true, true, false);
    }
}
