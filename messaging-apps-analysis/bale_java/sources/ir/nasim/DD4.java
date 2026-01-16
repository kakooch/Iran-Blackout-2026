package ir.nasim;

import android.gov.nist.core.Separators;
import android.net.Uri;

/* loaded from: classes5.dex */
public final class DD4 {
    private String a;
    private Uri b;
    private String c;

    public DD4(String str, Uri uri, String str2) {
        this.a = str;
        this.b = uri;
        this.c = str2;
    }

    public final String a() {
        return this.c;
    }

    public final Uri b() {
        return this.b;
    }

    public final String c() {
        return this.a;
    }

    public final void d(String str) {
        this.c = str;
    }

    public final void e(Uri uri) {
        this.b = uri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DD4)) {
            return false;
        }
        DD4 dd4 = (DD4) obj;
        return AbstractC13042fc3.d(this.a, dd4.a) && AbstractC13042fc3.d(this.b, dd4.b) && AbstractC13042fc3.d(this.c, dd4.c);
    }

    public final void f(String str) {
        this.a = str;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Uri uri = this.b;
        int iHashCode2 = (iHashCode + (uri == null ? 0 : uri.hashCode())) * 31;
        String str2 = this.c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "NotificationModel(text=" + this.a + ", dataUri=" + this.b + ", dataMimeType=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ DD4(String str, Uri uri, String str2, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : uri, (i & 4) != 0 ? null : str2);
    }
}
