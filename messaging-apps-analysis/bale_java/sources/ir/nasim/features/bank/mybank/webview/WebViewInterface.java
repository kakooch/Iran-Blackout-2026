package ir.nasim.features.bank.mybank.webview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.reflect.TypeToken;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C11458d25;
import ir.nasim.C14486i0;
import ir.nasim.C14733iO2;
import ir.nasim.C17213mb2;
import ir.nasim.C18987pb3;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C21231tK7;
import ir.nasim.C22055ub3;
import ir.nasim.C22186uo4;
import ir.nasim.C4100Dr4;
import ir.nasim.C5721Ko;
import ir.nasim.C5735Kp4;
import ir.nasim.C6517Nv5;
import ir.nasim.C8386Vt0;
import ir.nasim.C92;
import ir.nasim.E88;
import ir.nasim.ED1;
import ir.nasim.EnumC5360Iz7;
import ir.nasim.InterfaceC17569nB2;
import ir.nasim.InterfaceC17936no4;
import ir.nasim.InterfaceC21596to4;
import ir.nasim.InterfaceC21767u6;
import ir.nasim.InterfaceC22386v88;
import ir.nasim.InterfaceC24152y78;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC5417Jg1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9644aJ4;
import ir.nasim.J44;
import ir.nasim.KS2;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.core.modules.banking.entity.MyBankData;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.entity.ServiceItemMenuItemEntity;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.features.bank.mybank.webview.WebViewInterface;
import ir.nasim.features.root.RootActivity;
import ir.nasim.features.scanner.SimpleScannerActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class WebViewInterface implements InterfaceC21596to4, InterfaceC21767u6 {
    private final WebView a;
    private final Context b;
    private FragmentActivity c;
    private C14486i0 d;
    private J44 e;
    private final InterfaceC22386v88 f;
    private final UA2 g;
    private InterfaceC17936no4 h;
    private InterfaceC5417Jg1 i;
    private final String j;
    private String k;
    private String l;
    private String m;
    private a n;
    private final InterfaceC9173Yu3 o;

    public interface a {
        void a();
    }

    public static final class b implements InterfaceC9644aJ4 {
        final /* synthetic */ String b;

        b(String str) {
            this.b = str;
        }

        @Override // ir.nasim.InterfaceC9644aJ4
        public void a(ArrayList arrayList) {
            AbstractC13042fc3.i(arrayList, "phones");
            WebViewInterface.this.q0(this.b, arrayList.toString());
        }
    }

    public WebViewInterface(WebView webView, Context context, FragmentActivity fragmentActivity, C14486i0 c14486i0, J44 j44, InterfaceC22386v88 interfaceC22386v88, UA2 ua2) {
        AbstractC13042fc3.i(webView, "webView");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(fragmentActivity, "activity");
        this.a = webView;
        this.b = context;
        this.c = fragmentActivity;
        this.d = c14486i0;
        this.e = j44;
        this.f = interfaceC22386v88;
        this.g = ua2;
        this.j = "WEBVIEW";
        this.o = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.V78
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return WebViewInterface.x0(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(WebViewInterface webViewInterface) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        try {
            C14486i0 c14486i0 = webViewInterface.d;
            if (c14486i0 != null) {
                c14486i0.g();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(WebViewInterface webViewInterface) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        try {
            webViewInterface.c.onBackPressed();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(final WebViewInterface webViewInterface, final String str) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        AbstractC5969Lp4.d().o2().w().g().h0(new InterfaceC17569nB2() { // from class: ir.nasim.g88
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return WebViewInterface.K(this.a, str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K(WebViewInterface webViewInterface, String str, String str2) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        webViewInterface.q0(str, str2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(WebViewInterface webViewInterface, String str) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        webViewInterface.q0(str, String.valueOf(C5721Ko.a.h()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(WebViewInterface webViewInterface, String str) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        webViewInterface.q0(str, C5721Ko.a.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(WebViewInterface webViewInterface, String str) {
        Resources resources;
        Configuration configuration;
        AbstractC13042fc3.i(webViewInterface, "this$0");
        Context context = webViewInterface.b;
        Integer numValueOf = (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? null : Integer.valueOf(configuration.uiMode);
        if (numValueOf == null || (numValueOf.intValue() & 48) != 32) {
            webViewInterface.q0(str, "light");
        } else {
            webViewInterface.q0(str, "night");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(WebViewInterface webViewInterface, String str) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        J44 j44 = webViewInterface.e;
        if (j44 == null) {
            webViewInterface.q0(str, StringUtils.UNDEFINED);
            return;
        }
        String strValueOf = String.valueOf(j44 != null ? Long.valueOf(j44.i()) : null);
        J44 j442 = webViewInterface.e;
        String strValueOf2 = String.valueOf(j442 != null ? Long.valueOf(j442.h()) : null);
        J44 j443 = webViewInterface.e;
        String strValueOf3 = String.valueOf(j443 != null ? Integer.valueOf(j443.U()) : null);
        J44 j444 = webViewInterface.e;
        String strValueOf4 = String.valueOf(j444 != null ? j444.Y() : null);
        J44 j445 = webViewInterface.e;
        String strValueOf5 = String.valueOf(j445 != null ? Long.valueOf(j445.W()) : null);
        J44 j446 = webViewInterface.e;
        String strValueOf6 = String.valueOf(j446 != null ? Integer.valueOf(j446.G()) : null);
        J44 j447 = webViewInterface.e;
        String strValueOf7 = String.valueOf(j447 != null ? j447.J() : null);
        J44 j448 = webViewInterface.e;
        String strValueOf8 = String.valueOf(j448 != null ? j448.T() : null);
        J44 j449 = webViewInterface.e;
        webViewInterface.q0(str, strValueOf, strValueOf2, strValueOf3, strValueOf4, strValueOf5, strValueOf6, strValueOf7, strValueOf8, String.valueOf(j449 != null ? Boolean.valueOf(j449.K()) : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(long j, final WebViewInterface webViewInterface, final String str) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        AbstractC5969Lp4.b().k(j).m0(new InterfaceC24449ye1() { // from class: ir.nasim.h88
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                WebViewInterface.Q(this.a, str, (C14733iO2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(WebViewInterface webViewInterface, String str, C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        webViewInterface.q0(str, ((Integer) c14733iO2.u().b()).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(WebViewInterface webViewInterface, String str) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        if (!C8386Vt0.a.h9()) {
            webViewInterface.r0(str);
            return;
        }
        E88 e88T0 = webViewInterface.t0();
        String strA = e88T0 != null ? e88T0.a() : null;
        if (strA == null || AbstractC13042fc3.d(strA, "")) {
            webViewInterface.r0(str);
        } else {
            webViewInterface.q0(str, strA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(WebViewInterface webViewInterface, String str) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        webViewInterface.q0(str, String.valueOf(AbstractC5969Lp4.f()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(WebViewInterface webViewInterface, String str) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        J44 j44 = webViewInterface.e;
        if (j44 == null) {
            webViewInterface.q0(str, StringUtils.UNDEFINED);
            return;
        }
        String strValueOf = String.valueOf(j44 != null ? Long.valueOf(j44.i()) : null);
        J44 j442 = webViewInterface.e;
        String strValueOf2 = String.valueOf(j442 != null ? Long.valueOf(j442.h()) : null);
        J44 j443 = webViewInterface.e;
        webViewInterface.q0(str, strValueOf, strValueOf2, String.valueOf(j443 != null ? Integer.valueOf(j443.U()) : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(WebViewInterface webViewInterface, String str) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        C11458d25 c11458d25H = C5735Kp4.w().h();
        if (c11458d25H != null) {
            webViewInterface.q0(str, String.valueOf(c11458d25H.z()), String.valueOf(c11458d25H.getPeerId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(final WebViewInterface webViewInterface, final String str) {
        C6517Nv5 c6517Nv5H0;
        AbstractC13042fc3.i(webViewInterface, "this$0");
        final C11458d25 c11458d25H = C5735Kp4.w().h();
        if (c11458d25H != null) {
            if (c11458d25H.z()) {
                c6517Nv5H0 = AbstractC5969Lp4.b().k(c11458d25H.getPeerId()).h0(new InterfaceC17569nB2() { // from class: ir.nasim.i88
                    @Override // ir.nasim.InterfaceC17569nB2
                    public final Object apply(Object obj) {
                        return WebViewInterface.W(c11458d25H, (C14733iO2) obj);
                    }
                });
                AbstractC13042fc3.f(c6517Nv5H0);
            } else {
                c6517Nv5H0 = AbstractC5969Lp4.g().k(c11458d25H.getPeerId()).h0(new InterfaceC17569nB2() { // from class: ir.nasim.j88
                    @Override // ir.nasim.InterfaceC17569nB2
                    public final Object apply(Object obj) {
                        return WebViewInterface.X(c11458d25H, (C21231tK7) obj);
                    }
                });
                AbstractC13042fc3.f(c6517Nv5H0);
            }
            c6517Nv5H0.m0(new InterfaceC24449ye1() { // from class: ir.nasim.k88
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    WebViewInterface.Z(this.a, str, (String[]) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.m88
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    WebViewInterface.a0((Exception) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final String[] W(C11458d25 c11458d25, C14733iO2 c14733iO2) {
        return new String[]{String.valueOf(c11458d25.z()), String.valueOf(c11458d25.getPeerId()), ((Integer) c14733iO2.u().b()).toString(), c14733iO2.v().b()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final String[] X(C11458d25 c11458d25, C21231tK7 c21231tK7) {
        return new String[]{String.valueOf(c11458d25.z()), String.valueOf(c11458d25.getPeerId()), "-1", c21231tK7.r().b()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(WebViewInterface webViewInterface, String str, String[] strArr) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        webViewInterface.q0(str, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Exception exc) {
        C19406qI3.d("WEBVIEW", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(WebViewInterface webViewInterface) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        webViewInterface.f2(webViewInterface.b, webViewInterface.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(WebViewInterface webViewInterface) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        webViewInterface.P1(webViewInterface.b, webViewInterface.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(WebViewInterface webViewInterface) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        webViewInterface.e4(webViewInterface.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(String str, WebViewInterface webViewInterface) {
        AbstractC13042fc3.i(str, "$menuItemsJson");
        AbstractC13042fc3.i(webViewInterface, "this$0");
        try {
            Object objL = new KS2().l(str, new TypeToken<List<? extends ServiceItemMenuItemEntity>>() { // from class: ir.nasim.features.bank.mybank.webview.WebViewInterface$OPEN_DIGITAL_RIAL_MENU$1$type$1
            }.d());
            AbstractC13042fc3.h(objL, "fromJson(...)");
            List list = (List) objL;
            if (list.isEmpty()) {
                return;
            }
            FragmentActivity fragmentActivity = webViewInterface.c;
            AbstractC13042fc3.g(fragmentActivity, "null cannot be cast to non-null type ir.nasim.designsystem.base.activity.BaseActivity");
            BaseActivity baseActivity = (BaseActivity) fragmentActivity;
            List<ServiceItemMenuItemEntity> list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            for (ServiceItemMenuItemEntity serviceItemMenuItemEntity : list2) {
                int id = serviceItemMenuItemEntity.getId();
                String title = serviceItemMenuItemEntity.getTitle();
                String icon = serviceItemMenuItemEntity.getIcon();
                int action = serviceItemMenuItemEntity.getAction();
                arrayList.add(new MyBankData.Item(id, title, null, icon, null, false, false, Integer.valueOf(action), new MyBankData.Payload(serviceItemMenuItemEntity.getUrl(), null, null, null, false, null, 16, null), 0, 0, false, null, false, 15968, null));
            }
            webViewInterface.d2(baseActivity, new C22186uo4("", null, null, null, null, null, false, false, null, false, null, null, null, new MyBankData.Payload(null, null, null, null, false, arrayList, 16, null), null, 24566, null));
        } catch (Exception e) {
            C19406qI3.d(webViewInterface.j, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(String str, WebViewInterface webViewInterface) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        C18987pb3.a.k0(intent, webViewInterface.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(String str, WebViewInterface webViewInterface) {
        AbstractC13042fc3.i(str, "$token");
        AbstractC13042fc3.i(webViewInterface, "this$0");
        C22055ub3.a.o("https://sadad.shaparak.ir/VPG/Purchase?Token=" + str, webViewInterface.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(boolean z, int i, WebViewInterface webViewInterface) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        C11458d25 c11458d25E = z ? C11458d25.E(i) : C11458d25.y(i);
        AbstractC13042fc3.f(c11458d25E);
        webViewInterface.s4(c11458d25E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(WebViewInterface webViewInterface) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        webViewInterface.m4();
        C17213mb2.j("open_pfm_from_my_bank");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(WebViewInterface webViewInterface, String str) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        Context context = webViewInterface.b;
        Uri uri = Uri.parse(str);
        AbstractC13042fc3.h(uri, "parse(...)");
        aVar.A(context, uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(WebViewInterface webViewInterface, String str) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        AbstractC13042fc3.i(str, "$url");
        Context context = webViewInterface.b;
        FragmentActivity fragmentActivity = webViewInterface.c;
        AbstractC13042fc3.g(fragmentActivity, "null cannot be cast to non-null type ir.nasim.designsystem.base.activity.BaseActivity");
        webViewInterface.f0(context, (BaseActivity) fragmentActivity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(WebViewInterface webViewInterface, String str) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        InterfaceC5417Jg1 interfaceC5417Jg1 = webViewInterface.i;
        if (interfaceC5417Jg1 != null) {
            interfaceC5417Jg1.e(webViewInterface.new b(str));
        }
    }

    private final String p0(String str, String... strArr) {
        if (strArr.length == 0) {
            return str + "();";
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            arrayList.add(Separators.QUOTE + AbstractC20153rZ6.M(str2, Separators.QUOTE, "\\'", false, 4, null) + Separators.QUOTE);
        }
        return str + Separators.LPAREN + AbstractC15401jX0.A0(arrayList, null, null, null, 0, null, null, 63, null) + ");";
    }

    private final void r0(final String str) {
        boolean zA = C4100Dr4.a(this.b);
        String strO = AbstractC5969Lp4.d().o2().w().o();
        if (strO == null || AbstractC13042fc3.d(strO, "") || zA) {
            AbstractC5969Lp4.d().o2().w().g().h0(new InterfaceC17569nB2() { // from class: ir.nasim.n88
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return WebViewInterface.s0(this.a, str, (String) obj);
                }
            });
        } else {
            q0(str, strO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s0(WebViewInterface webViewInterface, String str, String str2) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        webViewInterface.q0(str, str2);
        return C19938rB7.a;
    }

    private final E88 t0() {
        return (E88) this.o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final E88 x0(WebViewInterface webViewInterface) {
        AbstractC13042fc3.i(webViewInterface, "this$0");
        try {
            return ((InterfaceC24152y78) C92.a(C5721Ko.a.d(), InterfaceC24152y78.class)).C();
        } catch (Exception e) {
            C19406qI3.c(webViewInterface.j, "Failed to initialize WebViewRepository", e);
            return null;
        }
    }

    @JavascriptInterface
    public final void AUTHORIZE_USER(String str) {
        UA2 ua2 = this.g;
        if (ua2 != null) {
            ua2.invoke(str);
        }
    }

    @JavascriptInterface
    public final void CLOSE_BOTTOMSHEET() {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.b88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.H(this.a);
            }
        });
    }

    @JavascriptInterface
    public final void CLOSE_FRAGMENT() {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.R78
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.I(this.a);
            }
        });
    }

    @JavascriptInterface
    public void FINISHED_LOADING_CALLBACK() {
        InterfaceC22386v88 interfaceC22386v88 = this.f;
        if (interfaceC22386v88 != null) {
            interfaceC22386v88.K();
        }
    }

    @JavascriptInterface
    public final void FORCE_GET_JWT_TOKEN(final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.o88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.J(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final void GET_APP_VERSION_CODE(final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.u88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.L(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final void GET_APP_VERSION_NAME(final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.Q78
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.M(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final void GET_CURRENT_THEME(final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.X78
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.N(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final void GET_FULL_MESSAGE(final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.W78
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.O(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final void GET_GROUP_MEMBER_COUNT(final long j, final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.f88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.P(j, this, str);
            }
        });
    }

    @JavascriptInterface
    public final void GET_JWT_TOKEN(final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.c88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.R(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final void GET_ME(final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.s88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.S(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final void GET_MESSAGE(final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.Y78
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.T(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final void GET_PEER(final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.a88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.U(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final void GET_PEER_INFO(final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.T78
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.V(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final boolean IS_CONNECTED_TO_NETWORK() {
        return C4100Dr4.a(this.b);
    }

    @JavascriptInterface
    public final void OPEN_CARD_BALANCE() {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.S78
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.b0(this.a);
            }
        });
    }

    @JavascriptInterface
    public final void OPEN_CARD_STATEMENT() {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.t88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.c0(this.a);
            }
        });
    }

    @JavascriptInterface
    public final void OPEN_CARD_TO_CARD() {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.U78
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.d0(this.a);
            }
        });
    }

    @JavascriptInterface
    public final void OPEN_DIGITAL_RIAL_MENU(final String str) {
        AbstractC13042fc3.i(str, "menuItemsJson");
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.r88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.e0(str, this);
            }
        });
    }

    @JavascriptInterface
    public final void OPEN_MESSAGE(final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.Z78
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.h0(str, this);
            }
        });
    }

    @JavascriptInterface
    public final void OPEN_PAY_WEB_VIEW(final String str) {
        AbstractC13042fc3.i(str, "token");
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.q88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.i0(str, this);
            }
        });
    }

    @JavascriptInterface
    public final void OPEN_PEER(final int i, final boolean z) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.p88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.j0(z, i, this);
            }
        });
    }

    @JavascriptInterface
    public final void OPEN_PFM() {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.e88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.l0(this.a);
            }
        });
    }

    @JavascriptInterface
    public final void OPEN_QR_CODE_SCANNER(String str, String str2) {
        this.l = str;
        this.m = str2;
        Intent intent = new Intent(this.c, (Class<?>) SimpleScannerActivity.class);
        FragmentActivity fragmentActivity = this.c;
        if (fragmentActivity instanceof RootActivity) {
            AbstractC13042fc3.g(fragmentActivity, "null cannot be cast to non-null type ir.nasim.features.root.RootActivity");
            ((RootActivity) fragmentActivity).b5(this);
            this.c.startActivityForResult(intent, 13781);
        }
    }

    @JavascriptInterface
    public final void OPEN_URL(final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.P78
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.m0(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final void OPEN_WEBVIEW_BOTTOMSHEET(final String str) {
        AbstractC13042fc3.i(str, "url");
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.l88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.n0(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final void SELECT_CONTACT(final String str) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.d88
            @Override // java.lang.Runnable
            public final void run() {
                WebViewInterface.o0(this.a, str);
            }
        });
    }

    @JavascriptInterface
    public final void SEND_EVENT(String str) {
        AbstractC13042fc3.i(str, "eventName");
        C17213mb2.j(str);
    }

    @JavascriptInterface
    public final void SEND_SMS(String str, String str2) {
        AbstractC13042fc3.i(str, "phoneNumbers");
        AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", str2);
        if (intent.resolveActivity(this.b.getPackageManager()) != null) {
            this.b.startActivity(intent);
        }
    }

    @JavascriptInterface
    public final void SET_RELOAD_LISTENER(String str) {
        AbstractC13042fc3.i(str, "listener");
        this.k = str;
    }

    @JavascriptInterface
    public final void SHARE(String str) {
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        this.b.startActivity(intent);
    }

    @JavascriptInterface
    public final void START_GIFT_TYPING() {
        C11458d25 c11458d25H = C5735Kp4.w().h();
        if (c11458d25H != null) {
            AbstractC5969Lp4.e().U().E(c11458d25H, EnumC5360Iz7.n, 10, null);
        }
    }

    @JavascriptInterface
    public final void START_HTML_LOADING_CALLBACK() {
        InterfaceC22386v88 interfaceC22386v88 = this.f;
        if (interfaceC22386v88 != null) {
            interfaceC22386v88.X3();
        }
    }

    @JavascriptInterface
    public final void STOP_GIFT_TYPING() {
        if (C5735Kp4.w().h() != null) {
            AbstractC5969Lp4.e().U().F(C5735Kp4.w().h(), EnumC5360Iz7.n);
        }
    }

    @JavascriptInterface
    public final void TRY_AGAIN_ON_OFFLINE() {
        a aVar = this.n;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // ir.nasim.InterfaceC21767u6
    public void c(int i, int i2, Intent intent) {
        String str;
        if (i == 13781) {
            if (i2 == -1 && intent != null) {
                String stringExtra = intent.getStringExtra("scanResult");
                if (stringExtra != null) {
                    q0(this.l, stringExtra);
                }
                if (intent.getBooleanExtra("exitFromSimpleActivity", false) && (str = this.m) != null) {
                    q0(str, new String[0]);
                }
            }
            FragmentActivity fragmentActivity = this.c;
            if (fragmentActivity instanceof RootActivity) {
                AbstractC13042fc3.g(fragmentActivity, "null cannot be cast to non-null type ir.nasim.features.root.RootActivity");
                ((RootActivity) fragmentActivity).b5(null);
            }
        }
    }

    protected final void q0(String str, String... strArr) {
        AbstractC13042fc3.i(strArr, "args");
        this.a.evaluateJavascript(p0(str, (String[]) Arrays.copyOf(strArr, strArr.length)), null);
    }

    public final void u0(InterfaceC5417Jg1 interfaceC5417Jg1) {
        this.i = interfaceC5417Jg1;
    }

    public final void v0(InterfaceC17936no4 interfaceC17936no4) {
        this.h = interfaceC17936no4;
    }

    public final void w0(a aVar) {
        AbstractC13042fc3.i(aVar, "retryClickListener");
        this.n = aVar;
    }

    @JavascriptInterface
    public final void SEND_EVENT(String str, String str2, String str3) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(str2, "key");
        AbstractC13042fc3.i(str3, "value");
        C17213mb2.l(str, str2, str3);
    }

    @JavascriptInterface
    public final void SEND_EVENT(String str, String str2, int i) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(str2, "key");
        C17213mb2.k(str, str2, Integer.valueOf(i));
    }

    @JavascriptInterface
    public final void SEND_EVENT(String str, Map<String, String> map) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(map, "data");
        C17213mb2.m(str, map);
    }

    public /* synthetic */ WebViewInterface(WebView webView, Context context, FragmentActivity fragmentActivity, C14486i0 c14486i0, J44 j44, InterfaceC22386v88 interfaceC22386v88, UA2 ua2, int i, ED1 ed1) {
        this(webView, context, fragmentActivity, (i & 8) != 0 ? null : c14486i0, (i & 16) != 0 ? null : j44, (i & 32) != 0 ? null : interfaceC22386v88, (i & 64) != 0 ? null : ua2);
    }
}
