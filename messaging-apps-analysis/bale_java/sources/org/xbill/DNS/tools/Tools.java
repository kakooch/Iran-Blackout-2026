package org.xbill.DNS.tools;

/* loaded from: classes8.dex */
public class Tools {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void main(java.lang.String[] r5) throws org.xbill.DNS.WireParseException, java.lang.NumberFormatException {
        /*
            r0 = 1
            if (r5 == 0) goto L83
            int r1 = r5.length
            if (r1 != 0) goto L8
            goto L83
        L8:
            r1 = 0
            r2 = r5[r1]
            int r3 = r5.length
            int r3 = r3 - r0
            java.lang.String[] r3 = new java.lang.String[r3]
            int r4 = r5.length
            int r4 = r4 - r0
            java.lang.System.arraycopy(r5, r0, r3, r1, r4)
            r2.hashCode()
            int r5 = r2.hashCode()
            r4 = -1
            switch(r5) {
                case -1155692273: goto L56;
                case -1097094790: goto L4d;
                case -838846263: goto L42;
                case -314765822: goto L37;
                case 99458: goto L2c;
                case 113974121: goto L21;
                default: goto L1f;
            }
        L1f:
            r0 = r4
            goto L60
        L21:
            java.lang.String r5 = "xfrin"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L2a
            goto L1f
        L2a:
            r0 = 5
            goto L60
        L2c:
            java.lang.String r5 = "dig"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L35
            goto L1f
        L35:
            r0 = 4
            goto L60
        L37:
            java.lang.String r5 = "primary"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L40
            goto L1f
        L40:
            r0 = 3
            goto L60
        L42:
            java.lang.String r5 = "update"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L4b
            goto L1f
        L4b:
            r0 = 2
            goto L60
        L4d:
            java.lang.String r5 = "lookup"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L60
            goto L1f
        L56:
            java.lang.String r5 = "jnamed"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L5f
            goto L1f
        L5f:
            r0 = r1
        L60:
            switch(r0) {
                case 0: goto L7f;
                case 1: goto L7b;
                case 2: goto L77;
                case 3: goto L73;
                case 4: goto L6f;
                case 5: goto L6b;
                default: goto L63;
            }
        L63:
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r0 = "invalid command"
            r5.println(r0)
            goto L82
        L6b:
            org.xbill.DNS.tools.xfrin.main(r3)
            goto L82
        L6f:
            org.xbill.DNS.tools.dig.main(r3)
            goto L82
        L73:
            org.xbill.DNS.tools.primary.main(r3)
            goto L82
        L77:
            org.xbill.DNS.tools.update.main(r3)
            goto L82
        L7b:
            org.xbill.DNS.tools.lookup.main(r3)
            goto L82
        L7f:
            org.xbill.DNS.tools.jnamed.main(r3)
        L82:
            return
        L83:
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.String r1 = "Usage: <command> <options>"
            r5.println(r1)
            java.lang.String r1 = "  Commands:"
            r5.println(r1)
            java.lang.String r1 = "    dig"
            r5.println(r1)
            java.lang.String r1 = "    jnamed"
            r5.println(r1)
            java.lang.String r1 = "    lookup"
            r5.println(r1)
            java.lang.String r1 = "    primary"
            r5.println(r1)
            java.lang.String r1 = "    update"
            r5.println(r1)
            java.lang.String r1 = "    xfrin"
            r5.println(r1)
            java.lang.System.exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.tools.Tools.main(java.lang.String[]):void");
    }
}
