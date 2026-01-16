package ir.nasim.designsystem.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C12735f68;
import ir.nasim.C14486i0;
import ir.nasim.C6011Lu2;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.J44;
import ir.nasim.S88;
import ir.nasim.SA2;
import ir.nasim.designsystem.webview.WebviewBottomSheet;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB%\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u0019J#\u0010 \u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u001e¢\u0006\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lir/nasim/designsystem/webview/WebviewBottomSheet;", "Landroid/widget/RelativeLayout;", "Lir/nasim/m0;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "d", "()V", "i", "g", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "url", "setUrl", "Lir/nasim/J44;", "currentMessage", "Lkotlin/Function0;", "requestLocationPermission", "e", "(Lir/nasim/J44;Lir/nasim/SA2;)V", "a", "Lir/nasim/i0;", "bottomSheet", "Lir/nasim/S88;", "b", "Lir/nasim/S88;", "getBinding", "()Lir/nasim/S88;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class WebviewBottomSheet extends RelativeLayout implements InterfaceC16866m0 {

    /* renamed from: a, reason: from kotlin metadata */
    private C14486i0 bottomSheet;

    /* renamed from: b, reason: from kotlin metadata */
    private final S88 binding;

    public WebviewBottomSheet(Context context) {
        super(context);
        S88 s88C = S88.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(s88C, "inflate(...)");
        this.binding = s88C;
        if (context != null) {
            d();
        }
    }

    private final void d() {
        i();
        g();
    }

    private final void g() {
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.R88
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebviewBottomSheet.h(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(WebviewBottomSheet webviewBottomSheet, View view) {
        AbstractC13042fc3.i(webviewBottomSheet, "this$0");
        C14486i0 c14486i0 = webviewBottomSheet.bottomSheet;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    private final void i() {
        this.binding.f.setWebViewClient(new WebViewClient());
        this.binding.i.setTypeface(C6011Lu2.i());
    }

    public final void e(J44 currentMessage, SA2 requestLocationPermission) {
        AbstractC13042fc3.i(currentMessage, "currentMessage");
        AbstractC13042fc3.i(requestLocationPermission, "requestLocationPermission");
        WebView webView = this.binding.f;
        WebView webView2 = this.binding.f;
        AbstractC13042fc3.h(webView2, "wbWebview");
        webView.addJavascriptInterface(new C12735f68(webView2, this.bottomSheet, currentMessage, requestLocationPermission), "BaleAndroid");
        this.binding.f.getSettings().setJavaScriptEnabled(true);
    }

    public final S88 getBinding() {
        return this.binding;
    }

    public void setAbolInstance(C14486i0 abol) {
        this.bottomSheet = abol;
    }

    public final void setTitle(String title) {
        AbstractC13042fc3.i(title, "title");
        this.binding.i.setText(title);
    }

    public final void setUrl(String url) {
        AbstractC13042fc3.i(url, "url");
        this.binding.f.loadUrl(url);
    }

    public WebviewBottomSheet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        S88 s88C = S88.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(s88C, "inflate(...)");
        this.binding = s88C;
        if (context != null) {
            d();
        }
    }

    public WebviewBottomSheet(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        S88 s88C = S88.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(s88C, "inflate(...)");
        this.binding = s88C;
        if (context != null) {
            d();
        }
    }
}
