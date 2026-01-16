package ir.eitaa.ui.Components;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Build;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BringAppForegroundService;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.ui.PhotoViewer;

/* loaded from: classes3.dex */
public class PhotoViewerWebView extends FrameLayout {
    private int currentAccount;
    private TLRPC$WebPage currentWebpage;
    private boolean isYouTube;
    private View pipItem;
    private PipVideoView pipVideoView;
    private float playbackSpeed;
    private RadialProgressView progressBar;
    private View progressBarBlackBackground;
    private boolean setPlaybackSpeed;
    private WebView webView;

    protected void drawBlackBackground(Canvas canvas, int w, int h) {
    }

    protected void processTouch(MotionEvent event) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    class YoutubeProxy {
        private YoutubeProxy() {
        }

        @JavascriptInterface
        public void postEvent(final String eventName, final String eventData) {
            if ("loaded".equals(eventName)) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PhotoViewerWebView$YoutubeProxy$jNlKUO2mYWe3tQ05ahvwkJzP6RM
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$postEvent$0$PhotoViewerWebView$YoutubeProxy();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$postEvent$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$postEvent$0$PhotoViewerWebView$YoutubeProxy() {
            PhotoViewerWebView.this.progressBar.setVisibility(4);
            PhotoViewerWebView.this.progressBarBlackBackground.setVisibility(4);
            if (PhotoViewerWebView.this.setPlaybackSpeed) {
                PhotoViewerWebView.this.setPlaybackSpeed = false;
                PhotoViewerWebView photoViewerWebView = PhotoViewerWebView.this;
                photoViewerWebView.setPlaybackSpeed(photoViewerWebView.playbackSpeed);
            }
            PhotoViewerWebView.this.pipItem.setEnabled(true);
            PhotoViewerWebView.this.pipItem.setAlpha(1.0f);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public PhotoViewerWebView(Context context, View pip) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.pipItem = pip;
        WebView webView = new WebView(context) { // from class: ir.eitaa.ui.Components.PhotoViewerWebView.1
            @Override // android.webkit.WebView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                PhotoViewerWebView.this.processTouch(event);
                return super.onTouchEvent(event);
            }
        };
        this.webView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            this.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        if (i >= 21) {
            this.webView.getSettings().setMixedContentMode(0);
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.webView, true);
        }
        this.webView.setWebViewClient(new WebViewClient() { // from class: ir.eitaa.ui.Components.PhotoViewerWebView.2
            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (!PhotoViewerWebView.this.isYouTube || Build.VERSION.SDK_INT < 17) {
                    PhotoViewerWebView.this.progressBar.setVisibility(4);
                    PhotoViewerWebView.this.progressBarBlackBackground.setVisibility(4);
                    PhotoViewerWebView.this.pipItem.setEnabled(true);
                    PhotoViewerWebView.this.pipItem.setAlpha(1.0f);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (PhotoViewerWebView.this.isYouTube) {
                    Browser.openUrl(view.getContext(), url);
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        addView(this.webView, LayoutHelper.createFrame(-1, -1, 51));
        View view = new View(context) { // from class: ir.eitaa.ui.Components.PhotoViewerWebView.3
            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                PhotoViewerWebView.this.drawBlackBackground(canvas, getMeasuredWidth(), getMeasuredHeight());
            }
        };
        this.progressBarBlackBackground = view;
        view.setBackgroundColor(-16777216);
        this.progressBarBlackBackground.setVisibility(4);
        addView(this.progressBarBlackBackground, LayoutHelper.createFrame(-1, -1.0f));
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.progressBar = radialProgressView;
        radialProgressView.setVisibility(4);
        addView(this.progressBar, LayoutHelper.createFrame(-2, -2, 17));
    }

    private void runJsCode(String code) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.webView.evaluateJavascript(code, null);
            return;
        }
        try {
            this.webView.loadUrl("javascript:" + code);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.webView.getParent() == this) {
            TLRPC$WebPage tLRPC$WebPage = this.currentWebpage;
            int i = tLRPC$WebPage.embed_width;
            if (i == 0) {
                i = 100;
            }
            int i2 = tLRPC$WebPage.embed_height;
            int i3 = i2 != 0 ? i2 : 100;
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            float f = i;
            float f2 = i3;
            float fMin = Math.min(size / f, size2 / f2);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.webView.getLayoutParams();
            int i4 = (int) (f * fMin);
            layoutParams.width = i4;
            int i5 = (int) (f2 * fMin);
            layoutParams.height = i5;
            layoutParams.topMargin = (size2 - i5) / 2;
            layoutParams.leftMargin = (size - i4) / 2;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public boolean isLoaded() {
        return this.progressBar.getVisibility() != 0;
    }

    public PipVideoView openInPip() {
        int i;
        boolean z = this.isYouTube && "inapp".equals(MessagesController.getInstance(this.currentAccount).youtubePipType);
        if ((!z && !checkInlinePermissions()) || this.progressBar.getVisibility() == 0) {
            return null;
        }
        PipVideoView pipVideoView = new PipVideoView(z);
        this.pipVideoView = pipVideoView;
        Activity activity = (Activity) getContext();
        PhotoViewer photoViewer = PhotoViewer.getInstance();
        TLRPC$WebPage tLRPC$WebPage = this.currentWebpage;
        int i2 = tLRPC$WebPage.embed_width;
        pipVideoView.show(activity, photoViewer, (i2 == 0 || (i = tLRPC$WebPage.embed_height) == 0) ? 1.0f : i2 / i, 0, this.webView);
        return this.pipVideoView;
    }

    public void setPlaybackSpeed(float speed) {
        this.playbackSpeed = speed;
        if (this.progressBar.getVisibility() != 0) {
            if (this.isYouTube) {
                runJsCode("setPlaybackSpeed(" + speed + ");");
                return;
            }
            return;
        }
        this.setPlaybackSpeed = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0087  */
    @android.annotation.SuppressLint({"AddJavascriptInterface"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void init(int r12, ir.eitaa.tgnet.TLRPC$WebPage r13) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.PhotoViewerWebView.init(int, ir.eitaa.tgnet.TLRPC$WebPage):void");
    }

    public boolean checkInlinePermissions() {
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(getContext())) {
            return true;
        }
        AlertsCreator.createDrawOverlayPermissionDialog((Activity) getContext(), null);
        return false;
    }

    public void exitFromPip() {
        if (this.webView == null || this.pipVideoView == null) {
            return;
        }
        if (ApplicationLoader.mainInterfacePaused) {
            try {
                getContext().startService(new Intent(ApplicationLoader.applicationContext, (Class<?>) BringAppForegroundService.class));
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        ViewGroup viewGroup = (ViewGroup) this.webView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.webView);
        }
        addView(this.webView, 0, LayoutHelper.createFrame(-1, -1, 51));
        this.pipVideoView.close();
        this.pipVideoView = null;
    }

    public void release() {
        this.webView.stopLoading();
        this.webView.loadUrl("about:blank");
        this.webView.destroy();
    }
}
