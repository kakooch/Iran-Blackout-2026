package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC11908dl0;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC25089zi7;
import ir.nasim.C22477vI7;
import ir.nasim.FH3;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes7.dex */
public class PhotoViewerWebView extends FrameLayout {
    private int a;
    private PhotoViewer b;
    private LinearLayout c;
    private TextView d;
    private TextView e;
    private WebView f;
    private View g;
    private RadialProgressView h;
    private View i;
    private String j;
    private List k;
    private String l;
    private boolean m;
    private AbstractC25089zi7 n;
    private float o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private float t;
    private boolean u;
    private Runnable v;

    class a extends WebView {
        a(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
            if (w.C0() == this && PhotoViewerWebView.this.g.getVisibility() == 0) {
                canvas.drawColor(-16777216);
                PhotoViewerWebView.this.A(canvas, getWidth(), getHeight());
            }
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            PhotoViewerWebView.this.R(motionEvent);
            return super.onTouchEvent(motionEvent);
        }
    }

    class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (PhotoViewerWebView.this.m) {
                return;
            }
            PhotoViewerWebView.this.h.setVisibility(4);
            PhotoViewerWebView.this.g.setVisibility(4);
            PhotoViewerWebView.this.i.setEnabled(true);
            PhotoViewerWebView.this.i.setAlpha(1.0f);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return null;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!PhotoViewerWebView.this.m) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            AbstractC11908dl0.h(webView.getContext(), str);
            return true;
        }
    }

    class c extends View {
        c(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            PhotoViewerWebView.this.A(canvas, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class d {

        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewerWebView.this.h.setVisibility(8);
            }
        }

        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PhotoViewerWebView.this.g.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(View view) {
            view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(PhotoViewerWebView.this.n.d)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(int i) {
            PhotoViewerWebView.this.e.setVisibility(8);
            PhotoViewerWebView.this.f.setVisibility(8);
            if (PhotoViewerWebView.this.c.getVisibility() == 8) {
                PhotoViewerWebView.this.c.setVisibility(0);
                PhotoViewerWebView.this.c.animate().cancel();
                PhotoViewerWebView.this.c.animate().alpha(1.0f).setDuration(150L).start();
            }
            if (PhotoViewerWebView.this.h.getAlpha() == 1.0f) {
                PhotoViewerWebView.this.h.animate().cancel();
                PhotoViewerWebView.this.h.animate().alpha(0.0f).setDuration(150L).setListener(new a());
            }
            if (PhotoViewerWebView.this.g.getAlpha() == 1.0f) {
                PhotoViewerWebView.this.g.animate().cancel();
                PhotoViewerWebView.this.g.animate().alpha(0.0f).setDuration(150L).setListener(new b());
            }
            if (i == 2) {
                PhotoViewerWebView.this.d.setText(FH3.C(TD5.tgwidget_YouTubeVideoErrorInvalid));
                return;
            }
            if (i == 5) {
                PhotoViewerWebView.this.d.setText(FH3.C(TD5.tgwidget_YouTubeVideoErrorHTML));
                return;
            }
            if (i != 150) {
                if (i == 100) {
                    PhotoViewerWebView.this.d.setText(FH3.C(TD5.tgwidget_YouTubeVideoErrorNotFound));
                    return;
                } else if (i != 101) {
                    return;
                }
            }
            PhotoViewerWebView.this.d.setText(FH3.C(TD5.tgwidget_YouTubeVideoErrorNotAvailableInApp));
            PhotoViewerWebView.this.e.setText(FH3.C(TD5.tgwidget_YouTubeVideoErrorOpenExternal));
            PhotoViewerWebView.this.e.setVisibility(0);
            PhotoViewerWebView.this.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tgwidgets.editor.ui.Components.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.a.f(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h() {
            PhotoViewerWebView.this.h.setVisibility(4);
            if (PhotoViewerWebView.this.p) {
                PhotoViewerWebView.this.p = false;
                PhotoViewerWebView photoViewerWebView = PhotoViewerWebView.this;
                photoViewerWebView.setPlaybackSpeed(photoViewerWebView.o);
            }
            PhotoViewerWebView.this.i.setEnabled(true);
            PhotoViewerWebView.this.i.setAlpha(1.0f);
            if (PhotoViewerWebView.this.b != null) {
                PhotoViewerWebView.this.b.u7();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i() {
            PhotoViewerWebView.this.g.setVisibility(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(boolean z, int i) {
            PhotoViewerWebView.this.b.Qb(z, i);
        }

        @JavascriptInterface
        public void onPlayerError(String str) throws NumberFormatException {
            final int i = Integer.parseInt(str);
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.q
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.g(i);
                }
            });
        }

        @JavascriptInterface
        public void onPlayerLoaded() {
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h();
                }
            });
        }

        @JavascriptInterface
        public void onPlayerNotifyBufferedPosition(float f) {
            PhotoViewerWebView.this.t = f;
        }

        @JavascriptInterface
        public void onPlayerNotifyCurrentPosition(int i) {
            PhotoViewerWebView.this.s = i * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        }

        @JavascriptInterface
        public void onPlayerNotifyDuration(int i) {
            PhotoViewerWebView.this.r = i * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
            if (PhotoViewerWebView.this.j != null) {
                PhotoViewerWebView photoViewerWebView = PhotoViewerWebView.this;
                photoViewerWebView.S(photoViewerWebView.j);
                PhotoViewerWebView.this.j = null;
            }
        }

        @JavascriptInterface
        public void onPlayerStateChange(String str) throws NumberFormatException {
            int i = Integer.parseInt(str);
            boolean z = PhotoViewerWebView.this.q;
            final boolean z2 = false;
            final int i2 = 1;
            PhotoViewerWebView.this.q = i == 1 || i == 3;
            PhotoViewerWebView.this.z(z);
            if (i != 0) {
                if (i == 1) {
                    z2 = true;
                } else if (i != 2) {
                    if (i == 3) {
                        z2 = true;
                        i2 = 2;
                    }
                }
                i2 = 3;
            } else {
                i2 = 4;
            }
            if (i2 == 3 && PhotoViewerWebView.this.g.getVisibility() != 4) {
                AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.i();
                    }
                }, 300L);
            }
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.j(z2, i2);
                }
            });
        }

        private d() {
        }
    }

    public PhotoViewerWebView(PhotoViewer photoViewer, Context context, View view) {
        super(context);
        this.a = C22477vI7.f;
        this.k = new ArrayList();
        this.v = new Runnable() { // from class: ir.nasim.Dc5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.M();
            }
        };
        this.b = photoViewer;
        this.i = view;
        a aVar = new a(context);
        this.f = aVar;
        aVar.getSettings().setJavaScriptEnabled(true);
        this.f.getSettings().setDomStorageEnabled(true);
        this.f.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.f.getSettings().setMixedContentMode(0);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.f, true);
        this.f.setWebViewClient(new b());
        addView(this.f, AbstractC13840gu3.d(-1, -1, 51));
        LinearLayout linearLayout = new LinearLayout(context);
        this.c = linearLayout;
        linearLayout.setOrientation(1);
        this.c.setGravity(17);
        this.c.setVisibility(8);
        addView(this.c, AbstractC13840gu3.d(-2, -2, 17));
        TextView textView = new TextView(context);
        this.d = textView;
        textView.setTextSize(1, 16.0f);
        this.d.setTextColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.h5));
        this.d.setGravity(17);
        this.c.addView(this.d, AbstractC13840gu3.m(-2, -2, 1));
        TextView textView2 = new TextView(context);
        this.e = textView2;
        textView2.setTextSize(1, 16.0f);
        TextView textView3 = this.e;
        int i = ir.nasim.tgwidgets.editor.ui.ActionBar.m.W4;
        textView3.setTextColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(i));
        this.e.setPadding(AbstractC21455b.F(12.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(12.0f), AbstractC21455b.F(8.0f));
        this.e.setBackground(m.e.i(i, 12.0f));
        this.e.setVisibility(8);
        this.c.addView(this.e, AbstractC13840gu3.n(-2, -2, 1, 0, 8, 0, 0));
        c cVar = new c(context);
        this.g = cVar;
        cVar.setBackgroundColor(-16777216);
        this.g.setVisibility(4);
        addView(this.g, AbstractC13840gu3.b(-1, -1.0f));
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.h = radialProgressView;
        radialProgressView.setVisibility(4);
        addView(this.h, AbstractC13840gu3.d(-2, -2, 17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        if (this.m) {
            U("pollPosition();");
        }
        if (this.q) {
            AbstractC21455b.n1(this.v, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(long j, boolean z) {
        U("seekTo(" + Math.round(j / 1000.0f) + ", " + z + ");");
        AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.Cc5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Q();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str) {
        int videoDuration = getVideoDuration() / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        this.k.clear();
        if (videoDuration <= 15) {
            return;
        }
        String[] strArrSplit = str.split("\\|");
        StringBuilder sb = new StringBuilder();
        sb.append(strArrSplit[0].split("\\$")[0]);
        sb.append("2/");
        String string = sb.toString();
        String str2 = strArrSplit[0].split("\\$N")[1];
        String str3 = strArrSplit.length == 3 ? strArrSplit[2].split("M#")[1] : strArrSplit.length == 2 ? strArrSplit[1].split("t#")[1] : strArrSplit[3].split("M#")[1];
        int iCeil = (int) (videoDuration <= 100 ? Math.ceil(videoDuration / 25.0f) : videoDuration <= 250 ? Math.ceil((videoDuration / 2.0f) / 25.0f) : videoDuration <= 500 ? Math.ceil((videoDuration / 4.0f) / 25.0f) : videoDuration <= 1000 ? Math.ceil((videoDuration / 5.0f) / 25.0f) : Math.ceil((videoDuration / 10.0f) / 25.0f));
        for (int i = 0; i < iCeil; i++) {
            this.k.add(String.format(Locale.ROOT, "%sM%d%s&sigh=%s", string, Integer.valueOf(i), str2, str3));
        }
    }

    private void U(String str) {
        this.f.evaluateJavascript(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z) {
        if (!z && this.q) {
            AbstractC21455b.n1(this.v, 500L);
        } else {
            if (!z || this.q) {
                return;
            }
            AbstractC21455b.t(this.v);
        }
    }

    protected void A(Canvas canvas, int i, int i2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String B(int r5) {
        /*
            r4 = this;
            int r0 = r4.getVideoDuration()
            r1 = 1000(0x3e8, float:1.401E-42)
            int r0 = r0 / r1
            r2 = 100
            r3 = 1103626240(0x41c80000, float:25.0)
            if (r0 > r2) goto L11
            float r5 = (float) r5
        Le:
            float r5 = r5 / r3
            int r5 = (int) r5
            goto L38
        L11:
            r2 = 250(0xfa, float:3.5E-43)
            if (r0 > r2) goto L1d
            float r5 = (float) r5
            r0 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r0
            int r5 = (int) r5
            int r5 = r5 / 25
            goto L38
        L1d:
            r2 = 500(0x1f4, float:7.0E-43)
            if (r0 > r2) goto L29
            float r5 = (float) r5
            r0 = 1082130432(0x40800000, float:4.0)
            float r5 = r5 / r0
            int r5 = (int) r5
            int r5 = r5 / 25
            goto L38
        L29:
            if (r0 > r1) goto L33
            float r5 = (float) r5
            r0 = 1084227584(0x40a00000, float:5.0)
            float r5 = r5 / r0
            int r5 = (int) r5
            int r5 = r5 / 25
            goto L38
        L33:
            float r5 = (float) r5
            r0 = 1092616192(0x41200000, float:10.0)
            float r5 = r5 / r0
            goto Le
        L38:
            java.util.List r0 = r4.k
            int r0 = r0.size()
            if (r5 >= r0) goto L49
            java.util.List r0 = r4.k
            java.lang.Object r5 = r0.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            goto L4a
        L49:
            r5 = 0
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.PhotoViewerWebView.B(int):java.lang.String");
    }

    public int C(int i) {
        int iIndexOf = this.k.indexOf(B(i));
        if (iIndexOf == -1) {
            return 0;
        }
        if (iIndexOf != this.k.size() - 1) {
            return 25;
        }
        int videoDuration = getVideoDuration() / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        return Math.min(25, (((int) (videoDuration <= 100 ? Math.ceil(videoDuration) : videoDuration <= 250 ? Math.ceil(videoDuration / 2.0f) : videoDuration <= 500 ? Math.ceil(videoDuration / 4.0f) : videoDuration <= 1000 ? Math.ceil(videoDuration / 5.0f) : Math.ceil(videoDuration / 10.0f))) - ((this.k.size() - 1) * 25)) + 1);
    }

    public int D(int i) {
        int videoDuration = getVideoDuration() / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        return videoDuration <= 100 ? ((int) Math.ceil(i)) % 25 : videoDuration <= 250 ? ((int) Math.ceil(i / 2.0f)) % 25 : videoDuration <= 500 ? ((int) Math.ceil(i / 4.0f)) % 25 : videoDuration <= 1000 ? ((int) Math.ceil(i / 5.0f)) % 25 : ((int) Math.ceil(i / 10.0f)) % 25;
    }

    public boolean E() {
        return !this.k.isEmpty();
    }

    public void F() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void G(int r11, ir.nasim.AbstractC25089zi7 r12) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.PhotoViewerWebView.G(int, ir.nasim.zi7):void");
    }

    public boolean H() {
        return L();
    }

    public boolean I() {
        return false;
    }

    public boolean J() {
        return this.h.getVisibility() != 0;
    }

    public boolean K() {
        return this.q;
    }

    public boolean L() {
        return this.m;
    }

    public boolean O() {
        boolean zI = I();
        if ((!zI && !y()) || this.h.getVisibility() == 0) {
            return false;
        }
        if (w.J0()) {
            w.w0();
            AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.Ac5
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.O();
                }
            }, 300L);
            return true;
        }
        this.g.setVisibility(0);
        Activity activity = (Activity) getContext();
        WebView webView = this.f;
        AbstractC25089zi7 abstractC25089zi7 = this.n;
        if (w.k1(zI, activity, this, webView, abstractC25089zi7.n, abstractC25089zi7.o, false)) {
            w.i1(PhotoViewer.k8());
        }
        return true;
    }

    public void P() {
        if (this.q && H()) {
            U("pauseVideo();");
            this.q = false;
            z(true);
        }
    }

    public void Q() {
        if (this.q || !H()) {
            return;
        }
        U("playVideo();");
        this.q = true;
        z(false);
    }

    protected void R(MotionEvent motionEvent) {
    }

    public void T() {
        this.f.stopLoading();
        this.f.loadUrl("about:blank");
        this.f.destroy();
        this.r = 0;
        this.s = 0;
        AbstractC21455b.t(this.v);
    }

    public void V(long j) {
        W(j, true);
    }

    public void W(final long j, final boolean z) {
        boolean z2 = this.q;
        this.s = (int) j;
        if (z2) {
            P();
        }
        if (z2) {
            AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.Bc5
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.N(j, z);
                }
            }, 100L);
            return;
        }
        U("seekTo(" + Math.round(j / 1000.0f) + ", " + z + ");");
    }

    public void X() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.u) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public float getBufferedPosition() {
        return this.t;
    }

    public int getCurrentPosition() {
        return this.s;
    }

    public int getVideoDuration() {
        return this.r;
    }

    public WebView getWebView() {
        return this.f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f.getParent() == this) {
            AbstractC25089zi7 abstractC25089zi7 = this.n;
            int i3 = abstractC25089zi7.n;
            if (i3 == 0) {
                i3 = 100;
            }
            int i4 = abstractC25089zi7.o;
            int i5 = i4 != 0 ? i4 : 100;
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            float f = i3;
            float f2 = i5;
            float fMin = Math.min(size / f, size2 / f2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f.getLayoutParams();
            int i6 = (int) (f * fMin);
            layoutParams.width = i6;
            int i7 = (int) (f2 * fMin);
            layoutParams.height = i7;
            layoutParams.topMargin = (size2 - i7) / 2;
            layoutParams.leftMargin = (size - i6) / 2;
        }
        super.onMeasure(i, i2);
    }

    public void setPlaybackSpeed(float f) {
        this.o = f;
        if (this.h.getVisibility() == 0) {
            this.p = true;
            return;
        }
        if (this.m) {
            U("setPlaybackSpeed(" + f + ");");
        }
    }

    public void setTouchDisabled(boolean z) {
        this.u = z;
    }

    public boolean y() {
        if (Settings.canDrawOverlays(getContext())) {
            return true;
        }
        AbstractC21462a.d((Activity) getContext(), null);
        return false;
    }
}
