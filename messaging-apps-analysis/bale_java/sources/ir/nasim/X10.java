package ir.nasim;

import android.gov.nist.core.Separators;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;

/* loaded from: classes8.dex */
public final class X10 {
    private final WebResourceRequest a;
    private final WebResourceError b;

    public X10(WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        AbstractC13042fc3.i(webResourceError, "error");
        this.a = webResourceRequest;
        this.b = webResourceError;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X10)) {
            return false;
        }
        X10 x10 = (X10) obj;
        return AbstractC13042fc3.d(this.a, x10.a) && AbstractC13042fc3.d(this.b, x10.b);
    }

    public int hashCode() {
        WebResourceRequest webResourceRequest = this.a;
        return ((webResourceRequest == null ? 0 : webResourceRequest.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "BaleWebAppViewError(request=" + this.a + ", error=" + this.b + Separators.RPAREN;
    }
}
