package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import ir.nasim.AbstractC11453d20;
import ir.nasim.V10;
import ir.nasim.core.network.sslpinning.SecureWebView;
import java.util.Map;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.d20, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC11453d20 {

    /* renamed from: ir.nasim.d20$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C13323g20 c;
        final /* synthetic */ InterfaceC9102Ym4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C13323g20 c13323g20, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c13323g20;
            this.d = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C13323g20 c13323g20 = this.c;
                WebView webViewM = AbstractC11453d20.m(this.d);
                if (webViewM == null) {
                    return C19938rB7.a;
                }
                this.b = 1;
                if (c13323g20.c(webViewM, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.d20$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC9102Ym4 c;
        final /* synthetic */ C13914h20 d;
        final /* synthetic */ C9663aL5 e;

        /* renamed from: ir.nasim.d20$b$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC9102Ym4 a;

            a(InterfaceC9102Ym4 interfaceC9102Ym4) {
                this.a = interfaceC9102Ym4;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(V10 v10, InterfaceC20295rm1 interfaceC20295rm1) {
                if (!(v10 instanceof V10.a)) {
                    throw new IllegalStateException();
                }
                WebView webViewM = AbstractC11453d20.m(this.a);
                if (webViewM != null) {
                    V10.a aVar = (V10.a) v10;
                    webViewM.loadUrl(aVar.b(), aVar.a());
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC9102Ym4 interfaceC9102Ym4, C13914h20 c13914h20, C9663aL5 c9663aL5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC9102Ym4;
            this.d = c13914h20;
            this.e = c9663aL5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final V10 y(C13914h20 c13914h20) {
            return c13914h20.a();
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (AbstractC11453d20.m(this.c) == null) {
                    return C19938rB7.a;
                }
                final C13914h20 c13914h20 = this.d;
                InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC10222bH6.r(new SA2() { // from class: ir.nasim.e20
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC11453d20.b.y(c13914h20);
                    }
                });
                C9663aL5 c9663aL5 = this.e;
                boolean z = c9663aL5.a;
                c9663aL5.a = false;
                if (!(!z)) {
                    interfaceC4557Fq2R = null;
                }
                if (interfaceC4557Fq2R != null) {
                    a aVar = new a(this.c);
                    this.b = 1;
                    if (interfaceC4557Fq2R.b(aVar, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.d20$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ UA2 a;
        final /* synthetic */ UA2 b;
        final /* synthetic */ C24380yX c;
        final /* synthetic */ C24974zX d;
        final /* synthetic */ InterfaceC9102Ym4 e;

        c(UA2 ua2, UA2 ua22, C24380yX c24380yX, C24974zX c24974zX, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = ua2;
            this.b = ua22;
            this.c = c24380yX;
            this.d = c24974zX;
            this.e = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FrameLayout c(UA2 ua2, int i, int i2, UA2 ua22, C24380yX c24380yX, C24974zX c24974zX, InterfaceC9102Ym4 interfaceC9102Ym4, Context context) {
            WebView secureWebView;
            AbstractC13042fc3.i(interfaceC9102Ym4, "$webView$delegate");
            AbstractC13042fc3.i(context, "context");
            if (ua2 == null || (secureWebView = (WebView) ua2.invoke(context)) == null) {
                secureWebView = new SecureWebView(context, null, 0, 0, 14, null);
            }
            ua22.invoke(secureWebView);
            secureWebView.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            secureWebView.setWebChromeClient(c24380yX);
            secureWebView.setWebViewClient(c24974zX);
            AbstractC11453d20.n(interfaceC9102Ym4, secureWebView);
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            frameLayout.addView(secureWebView);
            return frameLayout;
        }

        public final void b(InterfaceC5920Lk0 interfaceC5920Lk0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC5920Lk0, "$this$BoxWithConstraints");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.V(interfaceC5920Lk0) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            final int i2 = C17833ne1.j(interfaceC5920Lk0.d()) ? -1 : -2;
            final int i3 = C17833ne1.i(interfaceC5920Lk0.d()) ? -1 : -2;
            interfaceC22053ub1.W(1411095521);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b) | interfaceC22053ub1.e(i2) | interfaceC22053ub1.e(i3) | interfaceC22053ub1.D(this.c) | interfaceC22053ub1.D(this.d);
            final UA2 ua2 = this.a;
            final UA2 ua22 = this.b;
            final C24380yX c24380yX = this.c;
            final C24974zX c24974zX = this.d;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.e;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.f20
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC11453d20.c.c(ua2, i2, i3, ua22, c24380yX, c24974zX, interfaceC9102Ym4, (Context) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC11355cs.a((UA2) objB, null, null, interfaceC22053ub1, 0, 6);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC5920Lk0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.d20$d */
    public static final class d implements KV1 {
        final /* synthetic */ WebView a;
        final /* synthetic */ InterfaceC9664aL6 b;

        public d(WebView webView, InterfaceC9664aL6 interfaceC9664aL6) {
            this.a = webView;
            this.b = interfaceC9664aL6;
        }

        @Override // ir.nasim.KV1
        public void dispose() {
            AbstractC11453d20.i(this.b).invoke(this.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:212:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(final ir.nasim.C13914h20 r22, androidx.compose.ui.e r23, boolean r24, ir.nasim.C13323g20 r25, ir.nasim.UA2 r26, ir.nasim.UA2 r27, ir.nasim.C24974zX r28, ir.nasim.C24380yX r29, ir.nasim.UA2 r30, final boolean r31, ir.nasim.InterfaceC22053ub1 r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 957
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC11453d20.f(ir.nasim.h20, androidx.compose.ui.e, boolean, ir.nasim.g20, ir.nasim.UA2, ir.nasim.UA2, ir.nasim.zX, ir.nasim.yX, ir.nasim.UA2, boolean, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(WebView webView) {
        AbstractC13042fc3.i(webView, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$webView$delegate");
        WebView webViewM = m(interfaceC9102Ym4);
        if (webViewM != null) {
            webViewM.goBack();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UA2 i(InterfaceC9664aL6 interfaceC9664aL6) {
        return (UA2) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KV1 j(WebView webView, InterfaceC9664aL6 interfaceC9664aL6, LV1 lv1) {
        AbstractC13042fc3.i(webView, "$it");
        AbstractC13042fc3.i(interfaceC9664aL6, "$currentOnDispose$delegate");
        AbstractC13042fc3.i(lv1, "$this$DisposableEffect");
        return new d(webView, interfaceC9664aL6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(C13914h20 c13914h20, androidx.compose.ui.e eVar, boolean z, C13323g20 c13323g20, UA2 ua2, UA2 ua22, C24974zX c24974zX, C24380yX c24380yX, UA2 ua23, boolean z2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c13914h20, "$state");
        f(c13914h20, eVar, z, c13323g20, ua2, ua22, c24974zX, c24380yX, ua23, z2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(WebView webView) {
        AbstractC13042fc3.i(webView, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView m(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (WebView) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(InterfaceC9102Ym4 interfaceC9102Ym4, WebView webView) {
        interfaceC9102Ym4.setValue(webView);
    }

    public static final C13914h20 r(String str, Map map, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        AbstractC13042fc3.i(str, "url");
        interfaceC22053ub1.W(943237936);
        if ((i2 & 2) != 0) {
            map = AbstractC20051rO3.k();
        }
        interfaceC22053ub1.W(-2137187467);
        Object objB = interfaceC22053ub1.B();
        if (objB == InterfaceC22053ub1.a.a()) {
            objB = new C13914h20(new V10.a(str, map));
            interfaceC22053ub1.s(objB);
        }
        C13914h20 c13914h20 = (C13914h20) objB;
        interfaceC22053ub1.Q();
        c13914h20.d(new V10.a(str, map));
        interfaceC22053ub1.Q();
        return c13914h20;
    }

    public static final C13323g20 s(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        interfaceC22053ub1.W(-1067277485);
        if ((i2 & 1) != 0) {
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1);
                interfaceC22053ub1.s(objB);
            }
            interfaceC20315ro1 = (InterfaceC20315ro1) objB;
        }
        interfaceC22053ub1.W(-94602348);
        boolean zV = interfaceC22053ub1.V(interfaceC20315ro1);
        Object objB2 = interfaceC22053ub1.B();
        if (zV || objB2 == InterfaceC22053ub1.a.a()) {
            objB2 = new C13323g20(interfaceC20315ro1);
            interfaceC22053ub1.s(objB2);
        }
        C13323g20 c13323g20 = (C13323g20) objB2;
        interfaceC22053ub1.Q();
        interfaceC22053ub1.Q();
        return c13323g20;
    }
}
