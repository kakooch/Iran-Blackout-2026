package ir.nasim.features.bank.mybank.webview;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC12394eY2;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC17026mG5;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C14819iX7;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C22042ua0;
import ir.nasim.C22420vC4;
import ir.nasim.C23572x88;
import ir.nasim.C24162y88;
import ir.nasim.C25226zw5;
import ir.nasim.C4100Dr4;
import ir.nasim.C5580Jy2;
import ir.nasim.ED1;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC13295fz2;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC17936no4;
import ir.nasim.InterfaceC22386v88;
import ir.nasim.InterfaceC23146wR;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.J44;
import ir.nasim.KR;
import ir.nasim.P88;
import ir.nasim.SA2;
import ir.nasim.TR;
import ir.nasim.UA2;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.bank.mybank.webview.WebViewInterface;
import ir.nasim.features.bank.mybank.webview.a;
import java.net.MalformedURLException;

/* loaded from: classes5.dex */
public final class a extends AbstractC12394eY2 implements InterfaceC17936no4, InterfaceC22386v88 {
    private final InterfaceC9173Yu3 h1;
    public InterfaceC23146wR i1;
    public C23572x88 j1;
    private boolean k1;
    private C24162y88 l1;
    private J44 m1;
    private final InterfaceC10358bW7 n1;
    private String o1;
    private boolean p1;
    private Integer q1;
    static final /* synthetic */ InterfaceC5239Im3[] s1 = {AbstractC10882cM5.i(new C25226zw5(a.class, "binding", "getBinding()Lir/nasim/databinding/FragmentMyBankWebViewCacheBinding;", 0))};
    public static final C1119a r1 = new C1119a(null);
    public static final int t1 = 8;

    /* renamed from: ir.nasim.features.bank.mybank.webview.a$a, reason: collision with other inner class name */
    public static final class C1119a {
        private C1119a() {
        }

        public static /* synthetic */ a b(C1119a c1119a, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            return c1119a.a(str, z);
        }

        public final a a(String str, boolean z) {
            AbstractC13042fc3.i(str, "url");
            a aVar = new a(null);
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("arg_key_secure", z);
            aVar.a8(bundle);
            return aVar;
        }

        public final a c(String str, byte[] bArr, int i, boolean z) {
            AbstractC13042fc3.i(str, "url");
            AbstractC13042fc3.i(bArr, "msg");
            a aVar = new a(null);
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putInt("randomId", i);
            bundle.putBoolean("arg_key_secure", z);
            bundle.putByteArray(DialogEntity.COLUMN_MESSAGE, bArr);
            aVar.a8(bundle);
            return aVar;
        }

        public /* synthetic */ C1119a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements WebViewInterface.a {
        final /* synthetic */ String b;

        b(String str) {
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(a aVar, String str) {
            WebView webViewA;
            C24162y88 c24162y88;
            WebView webViewA2;
            AbstractC13042fc3.i(aVar, "this$0");
            aVar.na().c.getRoot().setVisibility(0);
            aVar.na().b.setVisibility(0);
            aVar.ta(str);
            C24162y88 c24162y882 = aVar.l1;
            if (c24162y882 == null || (webViewA = c24162y882.a()) == null || !webViewA.canGoBack() || (c24162y88 = aVar.l1) == null || (webViewA2 = c24162y88.a()) == null) {
                return;
            }
            webViewA2.goBack();
        }

        @Override // ir.nasim.features.bank.mybank.webview.WebViewInterface.a
        public void a() {
            Context contextS7 = a.this.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            if (!C4100Dr4.a(contextS7)) {
                Toast.makeText(a.this.S7(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
                return;
            }
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            final a aVar2 = a.this;
            final String str = this.b;
            aVar.F(new Runnable() { // from class: ir.nasim.I78
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.c(aVar2, str);
                }
            });
        }
    }

    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C5580Jy2.a(fragment.V7());
        }
    }

    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public /* synthetic */ a(ED1 ed1) {
        this();
    }

    private final void ea(final String str, Long l) {
        pa().S0(l, new SA2() { // from class: ir.nasim.B78
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ir.nasim.features.bank.mybank.webview.a.fa(this.a);
            }
        }, new UA2() { // from class: ir.nasim.C78
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.bank.mybank.webview.a.ga(this.a, ((Boolean) obj).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.D78
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.bank.mybank.webview.a.ha(this.a, (UA2) obj);
            }
        }, new UA2() { // from class: ir.nasim.E78
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.bank.mybank.webview.a.ja(this.a, str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 fa(a aVar) {
        AbstractC13042fc3.i(aVar, "this$0");
        J44 j44 = aVar.m1;
        if (j44 != null) {
            C22042ua0.w9(aVar, InterfaceC23146wR.a(aVar.ma(), "AuthenticationResult_Key", aVar.qa(j44), false, false, null, 28, null), false, null, 6, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ga(a aVar, boolean z) {
        AbstractC13042fc3.i(aVar, "this$0");
        J44 j44 = aVar.m1;
        if (j44 != null) {
            C22042ua0.w9(aVar, InterfaceC23146wR.c(aVar.ma(), "AuthenticationResult_Key", aVar.qa(j44), false, z, null, 20, null), false, null, 6, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ha(a aVar, final UA2 ua2) {
        AbstractC13042fc3.i(aVar, "this$0");
        AbstractC13042fc3.i(ua2, "doOnResult");
        aVar.V5().H1("AuthenticationResult_Key", aVar, new InterfaceC13295fz2() { // from class: ir.nasim.G78
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle) {
                ir.nasim.features.bank.mybank.webview.a.ia(ua2, str, bundle);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(UA2 ua2, String str, Bundle bundle) {
        AbstractC13042fc3.i(ua2, "$doOnResult");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "result");
        ua2.invoke(Boolean.valueOf(bundle.getBoolean("AuthenticationResult_Key", false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ja(a aVar, String str, String str2) {
        WebView webViewA;
        AbstractC13042fc3.i(aVar, "this$0");
        AbstractC13042fc3.i(str, "$callbackName");
        AbstractC13042fc3.i(str2, "token");
        C24162y88 c24162y88 = aVar.l1;
        if (c24162y88 != null && (webViewA = c24162y88.a()) != null) {
            webViewA.evaluateJavascript(str + "('" + str2 + "')", null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(a aVar, String str) {
        AbstractC13042fc3.i(aVar, "this$0");
        AbstractC13042fc3.i(str, "$newUrl");
        if (aVar.u6()) {
            aVar.o1 = str;
            aVar.na().c.getRoot().setVisibility(0);
            aVar.na().b.setVisibility(0);
            aVar.l1 = null;
            aVar.ta(aVar.o1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C5580Jy2 na() {
        Object objA = this.n1.a(this, s1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C5580Jy2) objA;
    }

    private final P88 pa() {
        return (P88) this.h1.getValue();
    }

    private final TR.a qa(J44 j44) {
        return new TR.a(j44.U(), (int) j44.i(), KR.b, pa().T0());
    }

    private final void sa() {
        na().c.getRoot().setVisibility(8);
        na().b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta(String str) {
        WebViewInterface webViewInterfaceB;
        WebViewInterface webViewInterfaceB2;
        try {
            if (this.l1 == null && str != null) {
                C23572x88 c23572x88Ra = ra();
                Context contextS7 = S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                FragmentActivity fragmentActivityQ7 = Q7();
                AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
                this.l1 = c23572x88Ra.D(str, contextS7, fragmentActivityQ7, null, this.m1, null, new SA2() { // from class: ir.nasim.z78
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return ir.nasim.features.bank.mybank.webview.a.ua(this.a);
                    }
                }, new UA2() { // from class: ir.nasim.A78
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return ir.nasim.features.bank.mybank.webview.a.va(this.a, (String) obj);
                    }
                });
            }
            C24162y88 c24162y88 = this.l1;
            if (c24162y88 != null && c24162y88.a().getParent() == null) {
                na().e.addView(c24162y88.a());
            }
            C24162y88 c24162y882 = this.l1;
            if (c24162y882 != null && (webViewInterfaceB2 = c24162y882.b()) != null) {
                webViewInterfaceB2.w0(new b(str));
            }
            C24162y88 c24162y883 = this.l1;
            if (c24162y883 == null || (webViewInterfaceB = c24162y883.b()) == null) {
                return;
            }
            webViewInterfaceB.v0(this);
        } catch (MalformedURLException e2) {
            C19406qI3.b("WebViewFragment", e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ua(a aVar) {
        AbstractC13042fc3.i(aVar, "this$0");
        aVar.xa();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 va(a aVar, String str) {
        AbstractC13042fc3.i(aVar, "this$0");
        if (str == null) {
            str = "";
        }
        J44 j44 = aVar.m1;
        aVar.ea(str, j44 != null ? Long.valueOf(j44.i()) : null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(a aVar) {
        AbstractC13042fc3.i(aVar, "this$0");
        try {
            aVar.na().c.getRoot().setVisibility(8);
            aVar.na().b.setVisibility(8);
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    private final void xa() {
        this.k1 = true;
        try {
            sa();
        } catch (Exception e2) {
            C19406qI3.b("WebViewFragment", e2.getMessage());
        }
    }

    private final void ya(int i) {
        WebView webViewA;
        C24162y88 c24162y88 = this.l1;
        if (c24162y88 == null || (webViewA = c24162y88.a()) == null) {
            return;
        }
        webViewA.evaluateJavascript("showGarsonShortcutOnboarding(" + i + Separators.RPAREN, null);
    }

    @Override // ir.nasim.InterfaceC17936no4
    public void F2(int i) {
    }

    @Override // ir.nasim.InterfaceC17936no4
    public Fragment J0() {
        return this;
    }

    @Override // ir.nasim.InterfaceC22386v88
    public void K() {
        AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.F78
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.bank.mybank.webview.a.wa(this.a);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        FragmentActivity fragmentActivityA5;
        FragmentActivity fragmentActivityA52;
        Window window;
        super.M6(bundle);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.o1 = bundleE5.getString("url");
            this.p1 = bundleE5.getBoolean("arg_key_secure", true);
            byte[] byteArray = bundleE5.getByteArray(DialogEntity.COLUMN_MESSAGE);
            this.m1 = byteArray != null ? J44.v.a(byteArray) : null;
            pa().V0(bundleE5.getInt("randomId", AbstractC17026mG5.a.g(Integer.MAX_VALUE)));
        }
        if (this.p1 && (fragmentActivityA52 = A5()) != null && (window = fragmentActivityA52.getWindow()) != null) {
            window.addFlags(8192);
        }
        if (this.o1 != null || (fragmentActivityA5 = A5()) == null) {
            return;
        }
        fragmentActivityA5.onBackPressed();
        C19938rB7 c19938rB7 = C19938rB7.a;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        ConstraintLayout constraintLayoutB = C5580Jy2.c(layoutInflater, viewGroup, false).getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        return constraintLayoutB;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        Window window;
        FragmentActivity fragmentActivityA5 = A5();
        if (fragmentActivityA5 != null && (window = fragmentActivityA5.getWindow()) != null) {
            window.clearFlags(8192);
        }
        C24162y88 c24162y88 = this.l1;
        if (c24162y88 != null) {
            c24162y88.a().evaluateJavascript("garsonResetScroll()", null);
            na().e.removeView(c24162y88.a());
        }
        super.T6();
    }

    @Override // ir.nasim.InterfaceC22386v88
    public void X3() {
        throw new C22420vC4("An operation is not implemented: Not yet implemented");
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        WebView webViewA;
        WebView webViewA2;
        C24162y88 c24162y88 = this.l1;
        if (c24162y88 == null || (webViewA = c24162y88.a()) == null || !webViewA.canGoBack()) {
            return super.a();
        }
        C24162y88 c24162y882 = this.l1;
        if (c24162y882 == null || (webViewA2 = c24162y882.a()) == null) {
            return true;
        }
        webViewA2.goBack();
        return true;
    }

    public final void ka(final String str) {
        AbstractC13042fc3.i(str, "newUrl");
        if (AbstractC20762sZ6.n0(str)) {
            return;
        }
        try {
            AbstractC7426Rr.a.F(new Runnable() { // from class: ir.nasim.H78
                @Override // java.lang.Runnable
                public final void run() {
                    ir.nasim.features.bank.mybank.webview.a.la(this.a, str);
                }
            });
        } catch (Exception e2) {
            C19406qI3.c("WebViewFragment", "changeUrlAndNotifyPreviousFragment error: " + e2.getMessage(), e2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        ta(this.o1);
        if (this.k1) {
            sa();
        }
        Integer num = this.q1;
        if (num != null) {
            ya(num.intValue());
        }
    }

    public final InterfaceC23146wR ma() {
        InterfaceC23146wR interfaceC23146wR = this.i1;
        if (interfaceC23146wR != null) {
            return interfaceC23146wR;
        }
        AbstractC13042fc3.y("authenticatorNavigator");
        return null;
    }

    @Override // ir.nasim.InterfaceC17936no4
    public void n2(String str) {
        AbstractC13042fc3.i(str, "url");
    }

    public final String oa() {
        return this.o1;
    }

    public final C23572x88 ra() {
        C23572x88 c23572x88 = this.j1;
        if (c23572x88 != null) {
            return c23572x88;
        }
        AbstractC13042fc3.y("webViewModule");
        return null;
    }

    @Override // ir.nasim.InterfaceC17936no4
    public void x1() {
    }

    public final void za(Integer num) {
        this.q1 = num;
    }

    private a() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new d(this)));
        this.h1 = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(P88.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
        this.n1 = AbstractC6056Lz2.f(this, new c(), AbstractC20046rN7.c());
        this.p1 = true;
    }
}
