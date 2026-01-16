package ir.nasim.features.payment.view.activity;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC24494yi6;
import ir.nasim.C10694c25;
import ir.nasim.C11458d25;
import ir.nasim.C19406qI3;
import ir.nasim.C4892Gz7;
import ir.nasim.C5495Jo7;
import ir.nasim.C5735Kp4;
import ir.nasim.EnumC5360Iz7;
import ir.nasim.H6;
import ir.nasim.PH3;
import ir.nasim.TU3;
import ir.nasim.features.payment.view.activity.WebViewPaymentActivity;
import ir.nasim.features.root.RootActivity;
import java.net.URL;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 82\u00020\u0001:\u00019B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0004H\u0014¢\u0006\u0004\b!\u0010\u0003R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00107\u001a\u0002008\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006:"}, d2 = {"Lir/nasim/features/payment/view/activity/WebViewPaymentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Lir/nasim/rB7;", "J1", "y1", "E1", "I1", "", "z1", "()I", "H1", "", "url", "Landroid/text/SpannableString;", "B1", "(Ljava/lang/String;)Landroid/text/SpannableString;", "C1", "K1", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "base", "attachBaseContext", "(Landroid/content/Context;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onBackPressed", "onDestroy", "Z", "Ljava/lang/String;", "Lir/nasim/TU3;", "z0", "Lir/nasim/TU3;", "dialog", "Landroidx/appcompat/app/a;", "A0", "Landroidx/appcompat/app/a;", "alertDialog", "Lir/nasim/H6;", "B0", "Lir/nasim/H6;", "binding", "Lir/nasim/Gz7;", "C0", "Lir/nasim/Gz7;", "A1", "()Lir/nasim/Gz7;", "setTypingModule", "(Lir/nasim/Gz7;)V", "typingModule", "D0", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class WebViewPaymentActivity extends Hilt_WebViewPaymentActivity {
    public static final int E0 = 8;

    /* renamed from: A0, reason: from kotlin metadata */
    private a alertDialog;

    /* renamed from: B0, reason: from kotlin metadata */
    private H6 binding;

    /* renamed from: C0, reason: from kotlin metadata */
    public C4892Gz7 typingModule;

    /* renamed from: Z, reason: from kotlin metadata */
    private String url;

    /* renamed from: z0, reason: from kotlin metadata */
    private TU3 dialog;

    public static final class b extends WebChromeClient {
        b() {
        }
    }

    public static final class c extends AbstractC24494yi6 {
        c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            AbstractC13042fc3.i(webView, "view");
            AbstractC13042fc3.i(str, "url");
            H6 h6 = null;
            if (AbstractC20762sZ6.X(str, "wallet/return?service=gift-packet", false, 2, null)) {
                WebViewPaymentActivity.this.K1();
            }
            H6 h62 = WebViewPaymentActivity.this.binding;
            if (h62 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                h6 = h62;
            }
            h6.f.setText(WebViewPaymentActivity.this.B1(str));
        }

        @Override // ir.nasim.AbstractC24494yi6, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return false;
            }
            if (!AbstractC20762sZ6.V(str, "intent:#Intent;package=ir.nasim;action=bale.ai.payment;", false)) {
                H6 h6 = WebViewPaymentActivity.this.binding;
                if (h6 == null) {
                    AbstractC13042fc3.y("binding");
                    h6 = null;
                }
                h6.f.setText(WebViewPaymentActivity.this.B1(str));
                return false;
            }
            Intent intent = new Intent(WebViewPaymentActivity.this, (Class<?>) RootActivity.class);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            WebViewPaymentActivity.this.startActivity(intent);
            if (WebViewPaymentActivity.this.alertDialog != null) {
                a aVar = WebViewPaymentActivity.this.alertDialog;
                AbstractC13042fc3.f(aVar);
                if (aVar.isShowing()) {
                    try {
                        a aVar2 = WebViewPaymentActivity.this.alertDialog;
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    } catch (Exception e) {
                        C19406qI3.d("NON_FATAL_EXCEPTION", e);
                    }
                }
            }
            WebViewPaymentActivity.this.finish();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpannableString B1(String url) {
        URL url2 = new URL(url);
        String str = url2.getProtocol() + "://" + url2.getAuthority();
        SpannableString spannableString = new SpannableString(str + url2.getPath());
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF161C4E")), 0, str.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF7075A0")), str.length() + 1, spannableString.length(), 33);
        return spannableString;
    }

    private final void C1() {
        this.dialog = new TU3(this).e(AbstractC12217eE5.do_you_want_stop_payment_operation).setNegativeButton(AbstractC12217eE5.dialog_no, null).setPositiveButton(AbstractC12217eE5.dialog_yes, new DialogInterface.OnClickListener() { // from class: ir.nasim.z88
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                WebViewPaymentActivity.D1(this.a, dialogInterface, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(WebViewPaymentActivity webViewPaymentActivity, DialogInterface dialogInterface, int i) {
        AbstractC13042fc3.i(webViewPaymentActivity, "this$0");
        webViewPaymentActivity.K1();
        dialogInterface.dismiss();
        webViewPaymentActivity.finish();
    }

    private final void E1() {
        I1();
        H6 h6 = this.binding;
        H6 h62 = null;
        if (h6 == null) {
            AbstractC13042fc3.y("binding");
            h6 = null;
        }
        h6.f.setMovementMethod(new ScrollingMovementMethod());
        H6 h63 = this.binding;
        if (h63 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            h62 = h63;
        }
        h62.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.A88
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewPaymentActivity.F1(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(WebViewPaymentActivity webViewPaymentActivity, View view) {
        AbstractC13042fc3.i(webViewPaymentActivity, "this$0");
        TU3 tu3 = webViewPaymentActivity.dialog;
        if (tu3 == null) {
            AbstractC13042fc3.y("dialog");
            tu3 = null;
        }
        webViewPaymentActivity.alertDialog = tu3.k();
    }

    private final void H1() {
        H6 h6 = this.binding;
        H6 h62 = null;
        if (h6 == null) {
            AbstractC13042fc3.y("binding");
            h6 = null;
        }
        h6.g.getSettings().setJavaScriptEnabled(true);
        H6 h63 = this.binding;
        if (h63 == null) {
            AbstractC13042fc3.y("binding");
            h63 = null;
        }
        h63.g.getSettings().setAllowFileAccess(true);
        H6 h64 = this.binding;
        if (h64 == null) {
            AbstractC13042fc3.y("binding");
            h64 = null;
        }
        h64.g.setLongClickable(false);
        H6 h65 = this.binding;
        if (h65 == null) {
            AbstractC13042fc3.y("binding");
            h65 = null;
        }
        h65.g.setWebChromeClient(new b());
        H6 h66 = this.binding;
        if (h66 == null) {
            AbstractC13042fc3.y("binding");
            h66 = null;
        }
        WebView webView = h66.g;
        Context baseContext = getBaseContext();
        AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
        webView.addJavascriptInterface(new C10694c25(this, baseContext), "BalePayment");
        H6 h67 = this.binding;
        if (h67 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            h62 = h67;
        }
        h62.g.setWebViewClient(new c());
    }

    private final void I1() {
        H6 h6 = this.binding;
        H6 h62 = null;
        if (h6 == null) {
            AbstractC13042fc3.y("binding");
            h6 = null;
        }
        ViewGroup.LayoutParams layoutParams = h6.e.getLayoutParams();
        AbstractC13042fc3.h(layoutParams, "getLayoutParams(...)");
        layoutParams.height = z1();
        H6 h63 = this.binding;
        if (h63 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            h62 = h63;
        }
        h62.e.setLayoutParams(layoutParams);
    }

    private final void J1() {
        if (C5495Jo7.a.J2()) {
            return;
        }
        getWindow().setStatusBarColor(getResources().getColor(R.color.black, getTheme()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1() {
        C11458d25 c11458d25H = C5735Kp4.w().h();
        if (c11458d25H != null) {
            A1().F(c11458d25H, EnumC5360Iz7.n);
        }
    }

    private final void y1() {
        Bundle extras = getIntent().getExtras();
        if (extras == null || !getIntent().hasExtra("url_param")) {
            return;
        }
        this.url = extras.getString("url_param");
    }

    private final int z1() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", ConstantDeviceInfo.APP_PLATFORM);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final C4892Gz7 A1() {
        C4892Gz7 c4892Gz7 = this.typingModule;
        if (c4892Gz7 != null) {
            return c4892Gz7;
        }
        AbstractC13042fc3.y("typingModule");
        return null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        AbstractC13042fc3.i(base, "base");
        super.attachBaseContext(PH3.h(base));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        TU3 tu3 = this.dialog;
        if (tu3 == null) {
            AbstractC13042fc3.y("dialog");
            tu3 = null;
        }
        this.alertDialog = tu3.k();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        PH3.h(this);
    }

    @Override // ir.nasim.features.payment.view.activity.Hilt_WebViewPaymentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(8192);
        }
        this.binding = H6.c(getLayoutInflater());
        J1();
        H6 h6 = this.binding;
        H6 h62 = null;
        if (h6 == null) {
            AbstractC13042fc3.y("binding");
            h6 = null;
        }
        setContentView(h6.getRoot());
        y1();
        if (this.url != null) {
            HashMap map = new HashMap();
            map.put("Referer", "https://tooshle.bale.ai");
            H6 h63 = this.binding;
            if (h63 == null) {
                AbstractC13042fc3.y("binding");
                h63 = null;
            }
            WebView webView = h63.g;
            String str = this.url;
            AbstractC13042fc3.f(str);
            webView.loadUrl(str, map);
            H6 h64 = this.binding;
            if (h64 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                h62 = h64;
            }
            TextView textView = h62.f;
            String str2 = this.url;
            AbstractC13042fc3.f(str2);
            textView.setText(B1(str2));
        } else {
            K1();
            finish();
        }
        E1();
        H1();
        C1();
    }

    @Override // ir.nasim.features.payment.view.activity.Hilt_WebViewPaymentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(8192);
        }
    }
}
