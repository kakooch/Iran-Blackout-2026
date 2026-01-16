package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import ir.nasim.features.payment.view.activity.WebViewPaymentActivity;

/* renamed from: ir.nasim.c25, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C10694c25 {
    private final WebViewPaymentActivity a;
    private final Context b;
    private final String c;

    public C10694c25(WebViewPaymentActivity webViewPaymentActivity, Context context) {
        AbstractC13042fc3.i(webViewPaymentActivity, "activity");
        AbstractC13042fc3.i(context, "context");
        this.a = webViewPaymentActivity;
        this.b = context;
        this.c = "WEBVIEW";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C10694c25 c10694c25) {
        AbstractC13042fc3.i(c10694c25, "this$0");
        Intent intent = new Intent("bale.ai.payment");
        intent.putExtra("result", true);
        intent.addFlags(268435456);
        c10694c25.b.startActivity(intent);
    }

    @JavascriptInterface
    public final void PAYMENT_SUCCESS() {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.b25
            @Override // java.lang.Runnable
            public final void run() {
                C10694c25.b(this.a);
            }
        });
    }
}
