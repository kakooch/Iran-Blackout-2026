package ir.eitaa.PhoneFormat;

/* loaded from: classes.dex */
public class PhoneRule {
    public int byte8;
    public int flag12;
    public int flag13;
    public String format;
    public boolean hasIntlPrefix;
    public boolean hasTrunkPrefix;
    public int maxLen;
    public int maxVal;
    public int minVal;
    public int otherFlag;
    public int prefixLen;

    /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.String format(java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            r12 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 20
            r0.<init>(r1)
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        Ld:
            java.lang.String r7 = r12.format
            int r7 = r7.length()
            r8 = 1
            if (r2 >= r7) goto L95
            java.lang.String r7 = r12.format
            char r7 = r7.charAt(r2)
            r9 = 35
            if (r7 == r9) goto L79
            r9 = 40
            r10 = 110(0x6e, float:1.54E-43)
            r11 = 99
            if (r7 == r9) goto L3b
            if (r7 == r11) goto L34
            if (r7 == r10) goto L2d
            goto L42
        L2d:
            if (r15 == 0) goto L32
            r0.append(r15)
        L32:
            r5 = 1
            goto L91
        L34:
            if (r14 == 0) goto L39
            r0.append(r14)
        L39:
            r3 = 1
            goto L91
        L3b:
            int r9 = r13.length()
            if (r4 >= r9) goto L42
            r6 = 1
        L42:
            r8 = 32
            if (r7 != r8) goto L5e
            if (r2 <= 0) goto L5e
            java.lang.String r8 = r12.format
            int r9 = r2 + (-1)
            char r8 = r8.charAt(r9)
            if (r8 != r10) goto L54
            if (r15 == 0) goto L91
        L54:
            java.lang.String r8 = r12.format
            char r8 = r8.charAt(r9)
            if (r8 != r11) goto L5e
            if (r14 == 0) goto L91
        L5e:
            int r8 = r13.length()
            r9 = 41
            if (r4 < r8) goto L6a
            if (r6 == 0) goto L91
            if (r7 != r9) goto L91
        L6a:
            java.lang.String r8 = r12.format
            int r10 = r2 + 1
            java.lang.String r8 = r8.substring(r2, r10)
            r0.append(r8)
            if (r7 != r9) goto L91
            r6 = 0
            goto L91
        L79:
            int r7 = r13.length()
            if (r4 >= r7) goto L8a
            int r7 = r4 + 1
            java.lang.String r4 = r13.substring(r4, r7)
            r0.append(r4)
            r4 = r7
            goto L91
        L8a:
            if (r6 == 0) goto L91
            java.lang.String r7 = " "
            r0.append(r7)
        L91:
            int r2 = r2 + 1
            goto Ld
        L95:
            if (r14 == 0) goto La7
            if (r3 != 0) goto La7
            java.lang.Object[] r13 = new java.lang.Object[r8]
            r13[r1] = r14
            java.lang.String r14 = "%s "
            java.lang.String r13 = java.lang.String.format(r14, r13)
            r0.insert(r1, r13)
            goto Lae
        La7:
            if (r15 == 0) goto Lae
            if (r5 != 0) goto Lae
            r0.insert(r1, r15)
        Lae:
            java.lang.String r13 = r0.toString()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.PhoneFormat.PhoneRule.format(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}
