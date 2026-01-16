package ir.nasim;

import android.webkit.WebSettings;
import android.webkit.WebView;
import ir.nasim.AbstractC16344l68;
import ir.nasim.core.model.webapp.WebAppArguments;
import ir.nasim.core.model.webapp.WebAppRestoreState;
import ir.nasim.core.model.webapp.minmize.WebAppKey;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

/* renamed from: ir.nasim.k68, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15753k68 {
    private final LinkedHashMap a = new LinkedHashMap();
    private final InterfaceC9336Zm4 b;
    private final InterfaceC10258bL6 c;

    public C15753k68() {
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(AbstractC16344l68.a.a);
        this.b = interfaceC9336Zm4A;
        this.c = AbstractC6459Nq2.c(interfaceC9336Zm4A);
    }

    private final void c(WebView webView) {
        webView.setWebChromeClient(null);
        webView.stopLoading();
        webView.onPause();
        webView.pauseTimers();
        webView.clearHistory();
        webView.clearCache(true);
        webView.clearFormData();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(false);
        settings.setDomStorageEnabled(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        settings.setGeolocationEnabled(false);
        webView.destroy();
    }

    private final void j() {
        Object value;
        Object value2;
        String webAppName;
        C4226Ef4 c4226Ef4D = d();
        if (c4226Ef4D == null) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.b;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, AbstractC16344l68.a.a));
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.b;
        do {
            value2 = interfaceC9336Zm42.getValue();
            WebAppRestoreState webAppRestoreState = c4226Ef4D.b().getWebAppRestoreState();
            webAppName = webAppRestoreState != null ? webAppRestoreState.getWebAppName() : null;
            if (webAppName == null) {
                webAppName = "";
            }
        } while (!interfaceC9336Zm42.f(value2, new AbstractC16344l68.b(webAppName)));
    }

    public final void a() {
        C4226Ef4 c4226Ef4;
        Set setKeySet = this.a.keySet();
        AbstractC13042fc3.h(setKeySet, "<get-keys>(...)");
        WebAppKey webAppKey = (WebAppKey) AbstractC15401jX0.E0(setKeySet);
        if (webAppKey != null && (c4226Ef4 = (C4226Ef4) this.a.remove(webAppKey)) != null) {
            c(c4226Ef4.c());
        }
        j();
    }

    public final void b(WebAppArguments webAppArguments) {
        AbstractC13042fc3.i(webAppArguments, "webAppArguments");
        WebAppKey webAppKeyF = webAppArguments.f();
        Set setKeySet = this.a.keySet();
        AbstractC13042fc3.h(setKeySet, "<get-keys>(...)");
        WebAppKey webAppKey = (WebAppKey) AbstractC15401jX0.E0(setKeySet);
        C4226Ef4 c4226Ef4 = (C4226Ef4) this.a.remove(webAppKeyF);
        if (c4226Ef4 != null) {
            c(c4226Ef4.c());
            if (AbstractC13042fc3.d(webAppKeyF, webAppKey)) {
                j();
            }
        }
    }

    public final C4226Ef4 d() {
        Collection collectionValues = this.a.values();
        AbstractC13042fc3.h(collectionValues, "<get-values>(...)");
        return (C4226Ef4) AbstractC15401jX0.E0(collectionValues);
    }

    public final InterfaceC10258bL6 e() {
        return this.c;
    }

    public final void f() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.b;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, AbstractC16344l68.a.a));
    }

    public final void g(WebAppArguments webAppArguments, WebView webView, C12144e68 c12144e68, C17637nI7 c17637nI7) {
        Object value;
        String webAppName;
        AbstractC13042fc3.i(webAppArguments, "webAppArguments");
        AbstractC13042fc3.i(webView, "webView");
        AbstractC13042fc3.i(c12144e68, "webViewInterface");
        AbstractC13042fc3.i(c17637nI7, "bot");
        WebAppKey webAppKeyF = webAppArguments.f();
        C4226Ef4 c4226Ef4 = new C4226Ef4(webView, c12144e68, webAppArguments, c17637nI7);
        this.a.put(webAppKeyF, c4226Ef4);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.b;
        do {
            value = interfaceC9336Zm4.getValue();
            WebAppRestoreState webAppRestoreState = c4226Ef4.b().getWebAppRestoreState();
            webAppName = webAppRestoreState != null ? webAppRestoreState.getWebAppName() : null;
            if (webAppName == null) {
                webAppName = "";
            }
        } while (!interfaceC9336Zm4.f(value, new AbstractC16344l68.b(webAppName)));
    }

    public final void h() {
        Object value;
        Object value2;
        C4226Ef4 c4226Ef4D = d();
        if (c4226Ef4D != null) {
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.b;
            do {
                value2 = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value2, new AbstractC16344l68.c(c4226Ef4D.b())));
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.b;
        do {
            value = interfaceC9336Zm42.getValue();
        } while (!interfaceC9336Zm42.f(value, AbstractC16344l68.a.a));
    }

    public final void i() {
        j();
    }
}
