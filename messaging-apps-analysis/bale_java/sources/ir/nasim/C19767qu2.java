package ir.nasim;

import android.gov.nist.core.Separators;
import android.util.Base64;
import java.util.List;

/* renamed from: ir.nasim.qu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19767qu2 {
    private final String a;
    private final String b;
    private final String c;
    private final List d;
    private final int e = 0;
    private final String f;

    public C19767qu2(String str, String str2, String str3, List list) {
        this.a = (String) AbstractC4980Hj5.g(str);
        this.b = (String) AbstractC4980Hj5.g(str2);
        this.c = (String) AbstractC4980Hj5.g(str3);
        this.d = (List) AbstractC4980Hj5.g(list);
        this.f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    String d() {
        return this.f;
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");
        for (int i = 0; i < this.d.size(); i++) {
            sb.append(" [");
            List list = (List) this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                sb.append(Separators.DOUBLE_QUOTE);
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }
}
