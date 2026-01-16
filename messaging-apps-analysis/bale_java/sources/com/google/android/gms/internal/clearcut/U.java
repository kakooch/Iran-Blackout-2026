package com.google.android.gms.internal.clearcut;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC20302rm8;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
abstract class U {
    static String a(InterfaceC20302rm8 interfaceC20302rm8, String str) throws SecurityException {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        b(interfaceC20302rm8, sb, 0);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void b(ir.nasim.InterfaceC20302rm8 r18, java.lang.StringBuilder r19, int r20) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 623
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.U.b(ir.nasim.rm8, java.lang.StringBuilder, int):void");
    }

    static final void c(StringBuilder sb, int i, String str, Object obj) throws SecurityException {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                c(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                c(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(i0.a(AbstractC2081f.L((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC2081f) {
            sb.append(": \"");
            sb.append(i0.a((AbstractC2081f) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC2101z) {
            sb.append(" {");
            b((AbstractC2101z) obj, sb, i + 2);
            sb.append(Separators.RETURN);
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj.toString());
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i4 = i + 2;
        c(sb, i4, "key", entry.getKey());
        c(sb, i4, "value", entry.getValue());
        sb.append(Separators.RETURN);
        while (i2 < i) {
            sb.append(' ');
            i2++;
        }
        sb.append("}");
    }

    private static final String d(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }
}
