package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.os.Build;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes8.dex */
public abstract class X48 {

    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ float b;
        final /* synthetic */ long c;

        a(androidx.compose.ui.e eVar, float f, long j) {
            this.a = eVar;
            this.b = f;
            this.c = j;
        }

        public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            androidx.compose.foundation.layout.f.a(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(this.a, 0.0f, 1, null), this.b), this.c, null, 2, null), interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ M46 a;
        final /* synthetic */ InterfaceC9102Ym4 b;
        final /* synthetic */ InterfaceC9664aL6 c;
        final /* synthetic */ R68 d;
        final /* synthetic */ C3869Cr7 e;
        final /* synthetic */ WebView f;
        final /* synthetic */ C13323g20 g;
        final /* synthetic */ C24974zX h;
        final /* synthetic */ C24380yX i;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC9664aL6 a;
            final /* synthetic */ R68 b;
            final /* synthetic */ C3869Cr7 c;
            final /* synthetic */ WebView d;
            final /* synthetic */ C13323g20 e;
            final /* synthetic */ C24974zX f;
            final /* synthetic */ C24380yX g;

            a(InterfaceC9664aL6 interfaceC9664aL6, R68 r68, C3869Cr7 c3869Cr7, WebView webView, C13323g20 c13323g20, C24974zX c24974zX, C24380yX c24380yX) {
                this.a = interfaceC9664aL6;
                this.b = r68;
                this.c = c3869Cr7;
                this.d = webView;
                this.e = c13323g20;
                this.f = c24974zX;
                this.g = c24380yX;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                e.a aVar = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarC = androidx.compose.foundation.layout.t.c(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), X48.B(this.a));
                R68 r68 = this.b;
                C3869Cr7 c3869Cr7 = this.c;
                WebView webView = this.d;
                C13323g20 c13323g20 = this.e;
                C24974zX c24974zX = this.f;
                C24380yX c24380yX = this.g;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
                InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar2.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(60));
                int i2 = C22132uj0.c;
                M68.J(eVarI, r68, c3869Cr7, interfaceC22053ub1, (i2 << 3) | 6, 0);
                MY2.b(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), null, 0L, interfaceC22053ub1, 6, 6);
                X48.D(webView, r68, c13323g20, c24974zX, c24380yX, c3869Cr7.e(), null, interfaceC22053ub1, i2 << 3, 64);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(M46 m46, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9664aL6 interfaceC9664aL6, R68 r68, C3869Cr7 c3869Cr7, WebView webView, C13323g20 c13323g20, C24974zX c24974zX, C24380yX c24380yX) {
            this.a = m46;
            this.b = interfaceC9102Ym4;
            this.c = interfaceC9664aL6;
            this.d = r68;
            this.e = c3869Cr7;
            this.f = webView;
            this.g = c13323g20;
            this.h = c24974zX;
            this.i = c24380yX;
        }

        public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            E27.a(AbstractC22640va8.c(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null)), this.a, X48.C(this.b), X48.C(this.b), null, 0.0f, AbstractC19242q11.e(943849139, true, new a(this.c, this.d, this.e, this.f, this.g, this.h, this.i), interfaceC22053ub1, 54), interfaceC22053ub1, 1572864, 48);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC23552x68.values().length];
            try {
                iArr[EnumC23552x68.d.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC23552x68.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC23552x68.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(WebView webView, R68 r68, boolean z, C3869Cr7 c3869Cr7, C13323g20 c13323g20, C24974zX c24974zX, C24380yX c24380yX, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(webView, "$webView");
        AbstractC13042fc3.i(r68, "$state");
        AbstractC13042fc3.i(c3869Cr7, "$toolbarCallBack");
        AbstractC13042fc3.i(c13323g20, "$webAppNavigator");
        AbstractC13042fc3.i(c24974zX, "$webAppClient");
        AbstractC13042fc3.i(c24380yX, "$webAppChromeClient");
        w(webView, r68, z, c3869Cr7, c13323g20, c24974zX, c24380yX, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float B(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long C(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((C24381yX0) interfaceC9102Ym4.getValue()).y();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void D(final android.webkit.WebView r19, final ir.nasim.R68 r20, final ir.nasim.C13323g20 r21, final ir.nasim.C24974zX r22, final ir.nasim.C24380yX r23, final ir.nasim.SA2 r24, androidx.compose.ui.e r25, ir.nasim.InterfaceC22053ub1 r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 579
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.X48.D(android.webkit.WebView, ir.nasim.R68, ir.nasim.g20, ir.nasim.zX, ir.nasim.yX, ir.nasim.SA2, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(WebView webView, R68 r68, C13323g20 c13323g20, C24974zX c24974zX, C24380yX c24380yX, SA2 sa2, androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(webView, "$webView");
        AbstractC13042fc3.i(r68, "$state");
        AbstractC13042fc3.i(c13323g20, "$webAppNavigator");
        AbstractC13042fc3.i(c24974zX, "$webAppClient");
        AbstractC13042fc3.i(c24380yX, "$webAppChromeClient");
        AbstractC13042fc3.i(sa2, "$reloadWebApp");
        D(webView, r68, c13323g20, c24974zX, c24380yX, sa2, eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void F(final android.webkit.WebView r21, final java.lang.String r22, androidx.compose.ui.e r23, final ir.nasim.C13323g20 r24, final ir.nasim.C24974zX r25, final ir.nasim.C24380yX r26, ir.nasim.InterfaceC22053ub1 r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.X48.F(android.webkit.WebView, java.lang.String, androidx.compose.ui.e, ir.nasim.g20, ir.nasim.zX, ir.nasim.yX, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G(WebView webView) {
        AbstractC13042fc3.i(webView, "webView");
        webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView H(WebView webView, Context context) {
        AbstractC13042fc3.i(webView, "$webViewInstance");
        AbstractC13042fc3.i(context, "it");
        ViewParent parent = webView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(webView);
        }
        return webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I(WebView webView, String str, androidx.compose.ui.e eVar, C13323g20 c13323g20, C24974zX c24974zX, C24380yX c24380yX, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(webView, "$webViewInstance");
        AbstractC13042fc3.i(str, "$url");
        AbstractC13042fc3.i(c13323g20, "$navigator");
        AbstractC13042fc3.i(c24974zX, "$client");
        AbstractC13042fc3.i(c24380yX, "$chromeClient");
        F(webView, str, eVar, c13323g20, c24974zX, c24380yX, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    private static final float L(EnumC23552x68 enumC23552x68) {
        int i = c.a[enumC23552x68.ordinal()];
        if (i == 1) {
            return 0.6f;
        }
        if (i == 2 || i == 3) {
            return 1.0f;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final float M(EnumC23552x68 enumC23552x68) {
        int i = c.a[enumC23552x68.ordinal()];
        if (i == 1) {
            return 20.0f;
        }
        if (i == 2 || i == 3) {
            return 0.0f;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String N() {
        String strR = AbstractC20507s76.r();
        AbstractC13042fc3.h(strR, "getVersion(...)");
        return "Bale-Android/" + AbstractC20153rZ6.M(strR, "-", "", false, 4, null) + " (" + Build.MANUFACTURER + Separators.SP + Build.MODEL + "; Android " + Build.VERSION.RELEASE + "; SDK " + Build.VERSION.SDK_INT + "; HIGH" + Separators.RPAREN;
    }

    public static final void n(final String str, SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        e.a aVar;
        G10 g10;
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub13;
        final SA2 sa22;
        AbstractC13042fc3.i(sa2, "reloadWebApp");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2073052794);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        int i4 = i2;
        if ((i4 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub13 = interfaceC22053ub1J;
            sa22 = sa2;
        } else {
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarG = AbstractC8014Ud6.g(androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null), AbstractC8014Ud6.c(0, interfaceC22053ub1J, 0, 1), false, null, false, 14, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.b(), InterfaceC12529em.a.g(), interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarG);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            G10 g102 = G10.a;
            int i5 = G10.b;
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar2, g102.c(interfaceC22053ub1J, i5).b().e()), interfaceC22053ub1J, 0);
            boolean z = true;
            AbstractC11456d23.b(FV4.c(AB5.mini_app_load_error, interfaceC22053ub1J, 0), null, androidx.compose.foundation.layout.t.i(aVar2, C17784nZ1.q(SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER)), null, null, 0.0f, null, interfaceC22053ub1J, 432, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar2, g102.c(interfaceC22053ub1J, i5).b().j()), interfaceC22053ub1J, 0);
            AbstractC9339Zm7.b(UY6.c(WD5.webapp_page_failed_to_load_title, interfaceC22053ub1J, 0), null, g102.a(interfaceC22053ub1J, i5).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g102.d(interfaceC22053ub1J, i5).k(), interfaceC22053ub1J, 0, 0, 65530);
            interfaceC22053ub1J.W(-116569026);
            if (str == null) {
                aVar = aVar2;
                g10 = g102;
                i3 = i5;
                interfaceC22053ub12 = interfaceC22053ub1J;
            } else {
                ZH6.a(androidx.compose.foundation.layout.t.i(aVar2, g102.c(interfaceC22053ub1J, i5).b().u()), interfaceC22053ub1J, 0);
                aVar = aVar2;
                g10 = g102;
                i3 = i5;
                interfaceC22053ub12 = interfaceC22053ub1J;
                AbstractC9339Zm7.b(str, null, g102.a(interfaceC22053ub1J, i5).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g102.d(interfaceC22053ub1J, i5).c(), interfaceC22053ub12, i4 & 14, 0, 65530);
            }
            interfaceC22053ub12.Q();
            interfaceC22053ub13 = interfaceC22053ub12;
            G10 g103 = g10;
            int i6 = i3;
            e.a aVar4 = aVar;
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar4, g103.c(interfaceC22053ub13, i6).b().e()), interfaceC22053ub13, 0);
            InterfaceC19114po0.b.a aVar5 = InterfaceC19114po0.b.a.a;
            String strC = UY6.c(WD5.try_again, interfaceC22053ub13, 0);
            interfaceC22053ub13.W(-116556079);
            if ((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) != 32) {
                z = false;
            }
            Object objB = interfaceC22053ub13.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                sa22 = sa2;
                objB = new SA2() { // from class: ir.nasim.T48
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return X48.o(sa22);
                    }
                };
                interfaceC22053ub13.s(objB);
            } else {
                sa22 = sa2;
            }
            interfaceC22053ub13.Q();
            AbstractC17932no0.A((SA2) objB, aVar5, strC, null, null, null, interfaceC22053ub13, (InterfaceC19114po0.b.a.b << 3) | 24576, 40);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar4, g103.c(interfaceC22053ub13, i6).b().l()), interfaceC22053ub13, 0);
            interfaceC22053ub13.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub13.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.U48
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return X48.p(str, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$reloadWebApp");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(String str, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$reloadWebApp");
        n(str, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void q(final int i, final androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        int i4;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-868471128);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (interfaceC22053ub1J.e(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i5 = i3 & 2;
        if (i5 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.V(eVar) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (i5 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            G10 g10 = G10.a;
            int i6 = G10.b;
            AbstractC10011av5.g(i / 100.0f, eVar, g10.a(interfaceC22053ub1J, i6).I(), g10.a(interfaceC22053ub1J, i6).E(), AbstractC24405yZ6.a.b(), interfaceC22053ub1J, i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.V48
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return X48.r(i, eVar, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(int i, androidx.compose.ui.e eVar, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        q(i, eVar, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    private static final void s(final int i, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(576761264);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.e(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            CG3.j(androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), G10.a.a(interfaceC22053ub1J, G10.b).A(), interfaceC22053ub1J, 6, 0);
            float f = 8;
            q(i, androidx.compose.foundation.layout.q.j(androidx.compose.foundation.layout.t.h(hVar.h(aVar, aVar2.b()), 0.0f, 1, null), C17784nZ1.q(f), C17784nZ1.q(f)), interfaceC22053ub1J, i3 & 14, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.S48
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return X48.t(i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        s(i, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void u(final boolean r16, final long r17, androidx.compose.ui.e r19, ir.nasim.InterfaceC22053ub1 r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.X48.u(boolean, long, androidx.compose.ui.e, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(boolean z, long j, androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        u(z, j, eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void w(final WebView webView, final R68 r68, final boolean z, final C3869Cr7 c3869Cr7, final C13323g20 c13323g20, final C24974zX c24974zX, final C24380yX c24380yX, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        Object obj;
        e.a aVar;
        int i3;
        InterfaceC4788Go2 interfaceC4788Go2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(webView, "webView");
        AbstractC13042fc3.i(r68, "state");
        AbstractC13042fc3.i(c3869Cr7, "toolbarCallBack");
        AbstractC13042fc3.i(c13323g20, "webAppNavigator");
        AbstractC13042fc3.i(c24974zX, "webAppClient");
        AbstractC13042fc3.i(c24380yX, "webAppChromeClient");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1136932377);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(webView) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(r68) : interfaceC22053ub1J.D(r68) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(c3869Cr7) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.V(c13323g20) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(c24974zX) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(c24380yX) ? 1048576 : 524288;
        }
        int i4 = i2;
        if ((599187 & i4) == 599186 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            EnumC23552x68 enumC23552x68J = r68.j();
            interfaceC22053ub1J.W(-145743055);
            boolean zV = interfaceC22053ub1J.V(enumC23552x68J);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = N46.f(C17784nZ1.q(M(r68.j())), C17784nZ1.q(M(r68.j())), 0.0f, 0.0f, 12, null);
                interfaceC22053ub1J.s(objB);
            }
            M46 m46 = (M46) objB;
            interfaceC22053ub1J.Q();
            EnumC23552x68 enumC23552x68J2 = r68.j();
            interfaceC22053ub1J.W(-145735471);
            boolean zV2 = interfaceC22053ub1J.V(enumC23552x68J2);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = Float.valueOf(L(r68.j()));
                interfaceC22053ub1J.s(objB2);
            }
            float fFloatValue = ((Number) objB2).floatValue();
            interfaceC22053ub1J.Q();
            InterfaceC9664aL6 interfaceC9664aL6D = AbstractC4572Fs.d(fFloatValue, AbstractC5999Lt.l(300, 0, null, 6, null), 0.0f, null, null, interfaceC22053ub1J, 48, 28);
            G10 g10 = G10.a;
            int i5 = G10.b;
            long jA = g10.a(interfaceC22053ub1J, i5).A();
            Integer numP = r68.p();
            interfaceC22053ub1J.W(-145725811);
            boolean zV3 = interfaceC22053ub1J.V(numP);
            Object objB3 = interfaceC22053ub1J.B();
            if (zV3 || objB3 == InterfaceC22053ub1.a.a()) {
                Integer numP2 = r68.p();
                if (numP2 != null) {
                    jA = DX0.b(numP2.intValue());
                }
                obj = null;
                objB3 = AbstractC13472gH6.d(C24381yX0.k(jA), null, 2, null);
                interfaceC22053ub1J.s(objB3);
            } else {
                obj = null;
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB3;
            interfaceC22053ub1J.Q();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, obj);
            InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
            InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar4.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar4.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC22053ub1J.W(-1624029696);
            if (r68.j() != EnumC23552x68.d) {
                androidx.compose.ui.e eVarH = hVar.h(aVar2, aVar3.m());
                interfaceC22053ub1J.W(-1624022994);
                long jQ = r68.p() == null ? g10.a(interfaceC22053ub1J, i5).q() : C(interfaceC9102Ym4);
                interfaceC22053ub1J.Q();
                aVar = aVar2;
                i3 = i4;
                interfaceC4788Go2 = null;
                u(z, jQ, eVarH, interfaceC22053ub1J, (i4 >> 6) & 14, 0);
            } else {
                aVar = aVar2;
                i3 = i4;
                interfaceC4788Go2 = null;
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarC = AbstractC22640va8.c(androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, interfaceC4788Go2));
            InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC);
            SA2 sa2A2 = aVar4.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G2, aVar4.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar4.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar4.f());
            long jO = C24381yX0.o(C15977kV3.a.a(interfaceC22053ub1J, C15977kV3.b).i(), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
            interfaceC22053ub1J.W(-1120007935);
            boolean z2 = (i3 & 7168) == 2048;
            Object objB4 = interfaceC22053ub1J.B();
            if (z2 || objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new SA2() { // from class: ir.nasim.W48
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return X48.z(c3869Cr7);
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            AbstractC23457wx1.e(jO, (SA2) objB4, z, interfaceC22053ub1J, i3 & 896);
            interfaceC22053ub1J.u();
            androidx.compose.ui.e eVarH2 = hVar.h(aVar, aVar3.b());
            interfaceC22053ub1J.W(-1624004902);
            Object objB5 = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar5 = InterfaceC22053ub1.a;
            if (objB5 == aVar5.a()) {
                objB5 = new UA2() { // from class: ir.nasim.L48
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return Integer.valueOf(X48.x(((Integer) obj2).intValue()));
                    }
                };
                interfaceC22053ub1J.s(objB5);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.animation.h hVarD = androidx.compose.animation.f.D(interfaceC4788Go2, (UA2) objB5, 1, interfaceC4788Go2);
            interfaceC22053ub1J.W(-1624002182);
            Object objB6 = interfaceC22053ub1J.B();
            if (objB6 == aVar5.a()) {
                objB6 = new UA2() { // from class: ir.nasim.M48
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return Integer.valueOf(X48.y(((Integer) obj2).intValue()));
                    }
                };
                interfaceC22053ub1J.s(objB6);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.animation.j jVarI = androidx.compose.animation.f.I(interfaceC4788Go2, (UA2) objB6, 1, interfaceC4788Go2);
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC22231ut.f(z, eVarH2, hVarD, jVarI, null, AbstractC19242q11.e(44545143, true, new b(m46, interfaceC9102Ym4, interfaceC9664aL6D, r68, c3869Cr7, webView, c13323g20, c24974zX, c24380yX), interfaceC22053ub12, 54), interfaceC22053ub12, ((i3 >> 6) & 14) | 200064, 16);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.N48
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj2, Object obj3) {
                    return X48.A(webView, r68, z, c3869Cr7, c13323g20, c24974zX, c24380yX, i, (InterfaceC22053ub1) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(C3869Cr7 c3869Cr7) {
        AbstractC13042fc3.i(c3869Cr7, "$toolbarCallBack");
        c3869Cr7.c().invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int x(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int y(int i) {
        return i;
    }
}
