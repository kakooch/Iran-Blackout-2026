package ir.nasim.features.bank.mybank.webview.shaparak;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C16859lz2;
import ir.nasim.C19913r91;
import ir.nasim.C19938rB7;
import ir.nasim.C25226zw5;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.GY6;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18060o11;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.MX2;
import ir.nasim.SA2;
import ir.nasim.TA5;
import ir.nasim.UA2;
import ir.nasim.features.bank.mybank.webview.shaparak.a;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 32\u00020\u0001:\u0001\u001dB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010)\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001b\u00102\u001a\u00020-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lir/nasim/features/bank/mybank/webview/shaparak/a;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ha", "ea", "ra", "qa", "oa", "", "cardNumber", "ca", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "a", "()Z", "h1", "Ljava/lang/String;", "da", "()Ljava/lang/String;", "pa", "(Ljava/lang/String;)V", "url", "i1", "ba", "na", "certMessage", "j1", "aa", "ma", "Lir/nasim/lz2;", "k1", "Lir/nasim/bW7;", "Z9", "()Lir/nasim/lz2;", "binding", "l1", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class a extends MX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    public String url;

    /* renamed from: i1, reason: from kotlin metadata */
    private String certMessage;

    /* renamed from: j1, reason: from kotlin metadata */
    public String cardNumber;

    /* renamed from: k1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new e(), AbstractC20046rN7.c());
    static final /* synthetic */ InterfaceC5239Im3[] m1 = {AbstractC10882cM5.i(new C25226zw5(a.class, "binding", "getBinding()Lir/nasim/databinding/FragmentShaparakWebViewBinding;", 0))};

    /* renamed from: l1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int n1 = 8;

    /* renamed from: ir.nasim.features.bank.mybank.webview.shaparak.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final a a(String str, String str2) {
            AbstractC13042fc3.i(str, "cardNumber");
            AbstractC13042fc3.i(str2, "url");
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putString("card_number", str);
            bundle.putString("url", str2);
            aVar.a8(bundle);
            return aVar;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            a.this.na(String.valueOf(webView != null ? webView.getCertificate() : null));
            super.onPageStarted(webView, str, bitmap);
            a.this.Z9().g.setVisibility(8);
            a.this.Z9().k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Uri url;
            if (!CardPaymentActivity.INSTANCE.c(webResourceRequest != null ? webResourceRequest.getUrl() : null)) {
                return false;
            }
            if (AbstractC13042fc3.d((webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.getQueryParameter("key_id"), "null")) {
                a.this.ra();
            } else {
                Intent intent = new Intent(a.this.S7(), (Class<?>) CardPaymentActivity.class);
                intent.setData(webResourceRequest != null ? webResourceRequest.getUrl() : null);
                a.this.n8(intent);
                a.this.Q7().finish();
            }
            return true;
        }
    }

    static final class c implements InterfaceC15796kB2 {

        /* renamed from: ir.nasim.features.bank.mybank.webview.shaparak.a$c$a, reason: collision with other inner class name */
        static final class C1121a implements InterfaceC14603iB2 {
            final /* synthetic */ a a;

            C1121a(a aVar) {
                this.a = aVar;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String certMessage = this.a.getCertMessage();
                AbstractC13042fc3.f(certMessage);
                AbstractC19555qZ.e0(certMessage, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC14603iB2 interfaceC14603iB2C = C19913r91.a.c();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(485461626, true, new C1121a(a.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(1542401741);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.bank.mybank.webview.shaparak.b
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return a.c.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.S(interfaceC14603iB2C, c0905b, interfaceC18060o11E, cVar, null, c1454b, (SA2) objB, AbstractC12217eE5.understand, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.C1454b.b << 15), 16);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class d implements InterfaceC15796kB2 {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, a aVar) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(aVar, "this$0");
            dialog.dismiss();
            aVar.Q7().finish();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            C19913r91 c19913r91 = C19913r91.a;
            InterfaceC14603iB2 interfaceC14603iB2A = c19913r91.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC14603iB2 interfaceC14603iB2B = c19913r91.b();
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            interfaceC22053ub1.W(1183477);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(a.this);
            final a aVar2 = a.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.bank.mybank.webview.shaparak.c
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return a.d.d(dialog, aVar2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = AbstractC12217eE5.contacts_refresh_positive_btn;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(1192258);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.features.bank.mybank.webview.shaparak.d
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return a.d.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, aVar, sa2, i2, c1454b, (SA2) objB2, AbstractC12217eE5.negative_remove_custom_tag, null, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class e extends AbstractC8614Ws3 implements UA2 {
        public e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C16859lz2.a(fragment.V7());
        }
    }

    private final String ca(String cardNumber) {
        String strSubstring = cardNumber.substring(0, 4);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        String strSubstring2 = cardNumber.substring(4, 8);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        String strSubstring3 = cardNumber.substring(8, 12);
        AbstractC13042fc3.h(strSubstring3, "substring(...)");
        String strSubstring4 = cardNumber.substring(12, 16);
        AbstractC13042fc3.h(strSubstring4, "substring(...)");
        return strSubstring + "-" + strSubstring2 + "-" + strSubstring3 + "-" + strSubstring4;
    }

    private final void ea() {
        Z9().k.getSettings().setDomStorageEnabled(true);
        Z9().k.getSettings().setJavaScriptEnabled(true);
        Z9().k.loadUrl(da());
        Z9().k.setWebViewClient(new b());
        Z9().d.setText(ca(GY6.a(aa())));
        Z9().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Sw6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.bank.mybank.webview.shaparak.a.fa(this.a, view);
            }
        });
        Z9().i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Tw6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.bank.mybank.webview.shaparak.a.ga(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fa(a aVar, View view) {
        AbstractC13042fc3.i(aVar, "this$0");
        aVar.ra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(a aVar, View view) {
        AbstractC13042fc3.i(aVar, "this$0");
        aVar.qa();
    }

    private final void ha() {
        Z9().j.getRoot().setVisibility(8);
        Z9().h.setVisibility(8);
        Z9().f.setVisibility(8);
        Z9().e.setVisibility(8);
        Z9().h.setTypeface(C6011Lu2.i());
        TextView textView = Z9().h;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.F2());
        Z9().f.setTypeface(C6011Lu2.i());
        Z9().f.setTextColor(c5495Jo7.E2());
        Z9().e.setTypeface(C6011Lu2.i());
        Z9().e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Uw6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.bank.mybank.webview.shaparak.a.ia(this.a, view);
            }
        });
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        aVar.G(new Runnable() { // from class: ir.nasim.Vw6
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.bank.mybank.webview.shaparak.a.ja(this.a);
            }
        }, 100L);
        aVar.G(new Runnable() { // from class: ir.nasim.Ww6
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.bank.mybank.webview.shaparak.a.ka(this.a);
            }
        }, 1000L);
        aVar.G(new Runnable() { // from class: ir.nasim.Xw6
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.bank.mybank.webview.shaparak.a.la(this.a);
            }
        }, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(a aVar, View view) {
        AbstractC13042fc3.i(aVar, "this$0");
        aVar.Q7().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(a aVar) {
        AbstractC13042fc3.i(aVar, "this$0");
        aVar.Z9().j.getRoot().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ka(a aVar) {
        AbstractC13042fc3.i(aVar, "this$0");
        aVar.Z9().h.setVisibility(0);
        aVar.Z9().f.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(a aVar) {
        AbstractC13042fc3.i(aVar, "this$0");
        if (aVar.h9() || aVar.Z9().k.getVisibility() == 0) {
            return;
        }
        aVar.Z9().j.getRoot().setVisibility(8);
        aVar.Z9().h.setText(AbstractC12217eE5.web_view_error_title);
        TextView textView = aVar.Z9().h;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.D2());
        aVar.Z9().f.setText(AbstractC12217eE5.web_view_error_description);
        aVar.Z9().f.setTextColor(c5495Jo7.C2());
        aVar.Z9().e.setVisibility(0);
    }

    private final void oa() {
        Z9().c.setTypeface(C6011Lu2.i());
        Z9().d.setTypeface(C6011Lu2.i());
        Z9().i.setColorFilter(AbstractC4043Dl1.c(S7(), TA5.color3_2));
        Z9().b.setColorFilter(AbstractC4043Dl1.c(S7(), TA5.color3_2));
    }

    private final void qa() {
        if (this.certMessage == null) {
            return;
        }
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(984477545, true, new c()), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra() {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1555355742, true, new d()), 4, null).show();
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            pa(bundleE5.getString("url", ""));
            ma(bundleE5.getString("card_number", ""));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.inflate(AbstractC12208eD5.fragment_shaparak_web_view, container, false);
    }

    public final C16859lz2 Z9() {
        Object objA = this.binding.a(this, m1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C16859lz2) objA;
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        ra();
        return true;
    }

    public final String aa() {
        String str = this.cardNumber;
        if (str != null) {
            return str;
        }
        AbstractC13042fc3.y("cardNumber");
        return null;
    }

    /* renamed from: ba, reason: from getter */
    public final String getCertMessage() {
        return this.certMessage;
    }

    public final String da() {
        String str = this.url;
        if (str != null) {
            return str;
        }
        AbstractC13042fc3.y("url");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        oa();
        ha();
        ea();
    }

    public final void ma(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.cardNumber = str;
    }

    public final void na(String str) {
        this.certMessage = str;
    }

    public final void pa(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.url = str;
    }
}
