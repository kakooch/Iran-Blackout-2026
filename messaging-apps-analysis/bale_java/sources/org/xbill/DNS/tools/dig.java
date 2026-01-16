package org.xbill.DNS.tools;

import java.io.PrintStream;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;

/* loaded from: classes8.dex */
public class dig {
    static int dclass = 1;
    static Name name = null;
    static int type = 1;

    static void doQuery(Message message, long j) {
        PrintStream printStream = System.out;
        printStream.println("; dnsjava dig");
        printStream.println(message);
        printStream.println(";; Query time: " + j + " ms");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void main(java.lang.String[] r10) throws org.xbill.DNS.WireParseException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.tools.dig.main(java.lang.String[]):void");
    }

    static void usage() {
        PrintStream printStream = System.out;
        printStream.println("; dnsjava dig");
        printStream.println("Usage: dig [@server] name [<type>] [<class>] [options]");
        System.exit(0);
    }
}
