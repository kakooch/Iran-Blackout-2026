package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.pe0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C19014pe0 {
    private final String a;
    private final String b;
    private final String c;
    private final String d;

    public C19014pe0(String str, String str2, String str3, String str4, boolean z) {
        this.a = str;
        this.b = str2;
        if (z) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str3.length(); i++) {
                sb.append(str3.charAt(i));
                if (i % 2 == 1 && i < 5) {
                    sb.append(Separators.SLASH);
                }
            }
            this.c = sb.toString();
        } else {
            this.c = str3;
        }
        this.d = str4;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.a;
    }
}
