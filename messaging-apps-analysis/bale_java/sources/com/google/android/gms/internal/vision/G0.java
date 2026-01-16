package com.google.android.gms.internal.vision;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC18561or8;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
abstract class G0 {
    static String a(InterfaceC18561or8 interfaceC18561or8, String str) throws SecurityException {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        c(interfaceC18561or8, sb, 0);
        return sb.toString();
    }

    private static final String b(String str) {
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

    /* JADX WARN: Removed duplicated region for block: B:84:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void c(ir.nasim.InterfaceC18561or8 r13, java.lang.StringBuilder r14, int r15) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.G0.c(ir.nasim.or8, java.lang.StringBuilder, int):void");
    }

    static final void d(StringBuilder sb, int i, String str, Object obj) throws SecurityException {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                d(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                d(sb, i, str, (Map.Entry) it2.next());
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
            sb.append(c1.a(K.D((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof K) {
            sb.append(": \"");
            sb.append(c1.a((K) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC2178j0) {
            sb.append(" {");
            c((AbstractC2178j0) obj, sb, i + 2);
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
        d(sb, i4, "key", entry.getKey());
        d(sb, i4, "value", entry.getValue());
        sb.append(Separators.RETURN);
        while (i2 < i) {
            sb.append(' ');
            i2++;
        }
        sb.append("}");
    }
}
