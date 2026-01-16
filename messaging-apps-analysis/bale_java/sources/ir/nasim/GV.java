package ir.nasim;

/* loaded from: classes3.dex */
public final class GV implements BI5 {
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0085  */
    @Override // ir.nasim.BI5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.nasim.X06 a(ir.nasim.C6338Ne0 r11, java.util.Map r12) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException {
        /*
            r10 = this;
            ir.nasim.AJ1 r0 = new ir.nasim.AJ1
            ir.nasim.Gf0 r11 = r11.a()
            r0.<init>(r11)
            r11 = 0
            r1 = 0
            ir.nasim.FV r11 = r0.a(r11)     // Catch: com.google.zxing.FormatException -> L25 com.google.zxing.NotFoundException -> L28
            ir.nasim.e16[] r2 = r11.b()     // Catch: com.google.zxing.FormatException -> L25 com.google.zxing.NotFoundException -> L28
            ir.nasim.EB1 r3 = new ir.nasim.EB1     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            r3.<init>()     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            ir.nasim.LB1 r11 = r3.c(r11)     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            r3 = r2
            r2 = r1
            r1 = r11
            r11 = r2
            goto L31
        L21:
            r11 = move-exception
            goto L2b
        L23:
            r11 = move-exception
            goto L2f
        L25:
            r11 = move-exception
            r2 = r1
            goto L2b
        L28:
            r11 = move-exception
            r2 = r1
            goto L2f
        L2b:
            r3 = r2
            r2 = r11
            r11 = r1
            goto L31
        L2f:
            r3 = r2
            r2 = r1
        L31:
            if (r1 != 0) goto L45
            r1 = 1
            ir.nasim.FV r0 = r0.a(r1)     // Catch: com.google.zxing.FormatException -> L47 com.google.zxing.NotFoundException -> L49
            ir.nasim.e16[] r3 = r0.b()     // Catch: com.google.zxing.FormatException -> L47 com.google.zxing.NotFoundException -> L49
            ir.nasim.EB1 r1 = new ir.nasim.EB1     // Catch: com.google.zxing.FormatException -> L47 com.google.zxing.NotFoundException -> L49
            r1.<init>()     // Catch: com.google.zxing.FormatException -> L47 com.google.zxing.NotFoundException -> L49
            ir.nasim.LB1 r1 = r1.c(r0)     // Catch: com.google.zxing.FormatException -> L47 com.google.zxing.NotFoundException -> L49
        L45:
            r6 = r3
            goto L51
        L47:
            r12 = move-exception
            goto L4a
        L49:
            r12 = move-exception
        L4a:
            if (r11 != 0) goto L50
            if (r2 == 0) goto L4f
            throw r2
        L4f:
            throw r12
        L50:
            throw r11
        L51:
            if (r12 == 0) goto L5c
            ir.nasim.rB1 r11 = ir.nasim.EnumC19932rB1.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r11 = r12.get(r11)
            ir.nasim.AbstractC18350oW3.a(r11)
        L5c:
            ir.nasim.X06 r11 = new ir.nasim.X06
            java.lang.String r3 = r1.h()
            byte[] r4 = r1.e()
            int r5 = r1.c()
            ir.nasim.a90 r7 = ir.nasim.EnumC9549a90.AZTEC
            long r8 = java.lang.System.currentTimeMillis()
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            java.util.List r12 = r1.a()
            if (r12 == 0) goto L7f
            ir.nasim.d16 r0 = ir.nasim.EnumC11449d16.BYTE_SEGMENTS
            r11.h(r0, r12)
        L7f:
            java.lang.String r12 = r1.b()
            if (r12 == 0) goto L8a
            ir.nasim.d16 r0 = ir.nasim.EnumC11449d16.ERROR_CORRECTION_LEVEL
            r11.h(r0, r12)
        L8a:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.GV.a(ir.nasim.Ne0, java.util.Map):ir.nasim.X06");
    }

    @Override // ir.nasim.BI5
    public void reset() {
    }
}
