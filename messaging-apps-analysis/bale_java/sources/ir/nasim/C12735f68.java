package ir.nasim;

import android.gov.nist.core.Separators;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* renamed from: ir.nasim.f68, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12735f68 {
    private final WebView a;
    private final C14486i0 b;
    private final J44 c;
    private final SA2 d;

    public C12735f68(WebView webView, C14486i0 c14486i0, J44 j44, SA2 sa2) {
        AbstractC13042fc3.i(webView, "webView");
        AbstractC13042fc3.i(j44, "currentMessage");
        AbstractC13042fc3.i(sa2, "requestLocationPermission");
        this.a = webView;
        this.b = c14486i0;
        this.c = j44;
        this.d = sa2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i, final C12735f68 c12735f68, final String str, final String str2) {
        AbstractC13042fc3.i(c12735f68, "this$0");
        AbstractC13042fc3.i(str, "$successCallback");
        AbstractC13042fc3.i(str2, "$failureCallback");
        C11458d25 currentPeer = C5735Kp4.w().k().getCurrentPeer();
        if (currentPeer == null) {
            C19406qI3.b("WebAppInterface", "GET_CONTEXT: currentPeer is null!");
        } else {
            AbstractC5969Lp4.d().j0(currentPeer.getPeerId(), i).m0(new InterfaceC24449ye1() { // from class: ir.nasim.a68
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C12735f68.i(this.a, str, (String) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.b68
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C12735f68.j(this.a, str2, (Exception) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(C12735f68 c12735f68, String str, String str2) {
        AbstractC13042fc3.i(c12735f68, "this$0");
        AbstractC13042fc3.i(str, "$successCallback");
        AbstractC13042fc3.i(str2, "userData");
        c12735f68.a.evaluateJavascript(str + Separators.LPAREN + str2 + ");", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(C12735f68 c12735f68, String str, Exception exc) {
        AbstractC13042fc3.i(c12735f68, "this$0");
        AbstractC13042fc3.i(str, "$failureCallback");
        AbstractC13042fc3.i(exc, "e");
        String message = AbstractC13042fc3.d(exc.getMessage(), "WRONG_BOT_USER_ID") ? exc.getMessage() : "GET_USER_CONTEXT_FAILED";
        c12735f68.a.evaluateJavascript(str + Separators.LPAREN + message + ");", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(C12735f68 c12735f68, String str) {
        AbstractC13042fc3.i(c12735f68, "this$0");
        AbstractC13042fc3.i(str, "$callbackSuccess");
        c12735f68.a.evaluateJavascript(str + Separators.LPAREN + "{ok:true});", null);
        C14486i0 c14486i0 = c12735f68.b;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final C12735f68 c12735f68, String str, final String str2, final String str3) {
        AbstractC13042fc3.i(c12735f68, "this$0");
        AbstractC13042fc3.i(str2, "$successCallback");
        AbstractC13042fc3.i(str3, "$failureCallback");
        C11458d25 currentPeer = C5735Kp4.w().k().getCurrentPeer();
        if (currentPeer == null) {
            C19406qI3.b("WebAppInterface", "SEND_DATA: currentPeer is null!");
        } else {
            AbstractC5969Lp4.d().C1(currentPeer, c12735f68.c.i(), c12735f68.c.h(), str).m0(new InterfaceC24449ye1() { // from class: ir.nasim.c68
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C12735f68.m(this.a, str2, (C14505i18) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.d68
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C12735f68.n(this.a, str3, (Exception) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(C12735f68 c12735f68, String str, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c12735f68, "this$0");
        AbstractC13042fc3.i(str, "$successCallback");
        c12735f68.a.evaluateJavascript(str + Separators.LPAREN + "{ok:true});", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(C12735f68 c12735f68, String str, Exception exc) {
        AbstractC13042fc3.i(c12735f68, "this$0");
        AbstractC13042fc3.i(str, "$failureCallback");
        c12735f68.a.evaluateJavascript(str + Separators.LPAREN + "{ok:false});", null);
    }

    @JavascriptInterface
    public final void GET_CONTEXT(final String str, final String str2, final int i) {
        AbstractC13042fc3.i(str, "successCallback");
        AbstractC13042fc3.i(str2, "failureCallback");
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.Y58
            @Override // java.lang.Runnable
            public final void run() {
                C12735f68.h(i, this, str, str2);
            }
        });
    }

    @JavascriptInterface
    public final void REQUEST_COLSE_BROWSER(final String str, String str2) {
        AbstractC13042fc3.i(str, "callbackSuccess");
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.Z58
            @Override // java.lang.Runnable
            public final void run() {
                C12735f68.k(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final void SEND_DATA(final String str, final String str2, final String str3) {
        AbstractC13042fc3.i(str, "successCallback");
        AbstractC13042fc3.i(str2, "failureCallback");
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.X58
            @Override // java.lang.Runnable
            public final void run() {
                C12735f68.l(this.a, str3, str, str2);
            }
        });
    }

    @JavascriptInterface
    public final void showLocation(String str) {
        this.d.invoke();
    }
}
