package ir.nasim;

import android.gov.nist.core.Separators;
import android.webkit.WebView;
import ir.nasim.core.model.webapp.WebAppArguments;

/* renamed from: ir.nasim.Ef4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4226Ef4 {
    private final WebView a;
    private final C12144e68 b;
    private final WebAppArguments c;
    private final C17637nI7 d;

    public C4226Ef4(WebView webView, C12144e68 c12144e68, WebAppArguments webAppArguments, C17637nI7 c17637nI7) {
        AbstractC13042fc3.i(webView, "webView");
        AbstractC13042fc3.i(c12144e68, "webViewInterface");
        AbstractC13042fc3.i(webAppArguments, "webAppArguments");
        AbstractC13042fc3.i(c17637nI7, "bot");
        this.a = webView;
        this.b = c12144e68;
        this.c = webAppArguments;
        this.d = c17637nI7;
    }

    public final C17637nI7 a() {
        return this.d;
    }

    public final WebAppArguments b() {
        return this.c;
    }

    public final WebView c() {
        return this.a;
    }

    public final C12144e68 d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4226Ef4)) {
            return false;
        }
        C4226Ef4 c4226Ef4 = (C4226Ef4) obj;
        return AbstractC13042fc3.d(this.a, c4226Ef4.a) && AbstractC13042fc3.d(this.b, c4226Ef4.b) && AbstractC13042fc3.d(this.c, c4226Ef4.c) && AbstractC13042fc3.d(this.d, c4226Ef4.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "MinimizedWebApp(webView=" + this.a + ", webViewInterface=" + this.b + ", webAppArguments=" + this.c + ", bot=" + this.d + Separators.RPAREN;
    }
}
