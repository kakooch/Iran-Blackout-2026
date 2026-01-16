package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Property;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.arch.core.util.Function;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BringAppForegroundService;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.WebPlayerView;
import ir.eitaa.ui.LaunchActivity;
import ir.eitaa.ui.PhotoViewer;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class EmbedBottomSheet extends BottomSheet implements Pipable {

    @SuppressLint({"StaticFieldLeak"})
    private static EmbedBottomSheet instance;
    private boolean animationInProgress;
    private boolean canDismissWithTouchOutside;
    private FrameLayout containerLayout;
    private TextView copyTextButton;
    private View customView;
    private WebChromeClient.CustomViewCallback customViewCallback;
    private String embedUrl;
    private FrameLayout fullscreenVideoContainer;
    private boolean fullscreenedByButton;
    private boolean hasDescription;
    private int height;
    private LinearLayout imageButtonsContainer;
    private boolean isYouTube;
    private int lastOrientation;
    private DialogInterface.OnShowListener onShowListener;
    private String openUrl;
    private OrientationEventListener orientationEventListener;
    private Activity parentActivity;
    private ImageView pipButton;
    private PipVideoView pipVideoView;
    private int[] position;
    private int prevOrientation;
    private RadialProgressView progressBar;
    private View progressBarBlackBackground;
    private int seekTimeOverride;
    private WebPlayerView videoView;
    private int waitingForDraw;
    private boolean wasInLandscape;
    private WebView webView;
    private int width;
    private final String youtubeFrame;

    static /* synthetic */ boolean lambda$new$0(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ boolean lambda$new$1(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class YoutubeProxy {
        private YoutubeProxy() {
        }

        @JavascriptInterface
        public void postEvent(final String eventName, final String eventData) {
            if ("loaded".equals(eventName)) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmbedBottomSheet$YoutubeProxy$zVg4-3xAHcvlH4PHpjpuujSBpqk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$postEvent$0$EmbedBottomSheet$YoutubeProxy();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$postEvent$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$postEvent$0$EmbedBottomSheet$YoutubeProxy() {
            EmbedBottomSheet.this.progressBar.setVisibility(4);
            EmbedBottomSheet.this.progressBarBlackBackground.setVisibility(4);
            EmbedBottomSheet.this.pipButton.setEnabled(true);
            EmbedBottomSheet.this.pipButton.setAlpha(1.0f);
        }
    }

    public static void show(Activity activity, MessageObject message, PhotoViewer.PhotoViewerProvider photoViewerProvider, String title, String description, String originalUrl, final String url, int w, int h, boolean keyboardVisible) {
        show(activity, message, photoViewerProvider, title, description, originalUrl, url, w, h, -1, keyboardVisible);
    }

    public static void show(Activity activity, MessageObject message, PhotoViewer.PhotoViewerProvider photoViewerProvider, String title, String description, String originalUrl, final String url, int w, int h, int seekTime, boolean keyboardVisible) {
        TLRPC$MessageMedia tLRPC$MessageMedia;
        EmbedBottomSheet embedBottomSheet = instance;
        if (embedBottomSheet != null) {
            embedBottomSheet.destroy();
        }
        if (((message == null || (tLRPC$MessageMedia = message.messageOwner.media) == null || tLRPC$MessageMedia.webpage == null) ? null : WebPlayerView.getYouTubeVideoId(url)) != null) {
            PhotoViewer.getInstance().setParentActivity(activity);
            PhotoViewer.getInstance().openPhoto(message, seekTime, null, 0L, 0L, photoViewerProvider);
        } else {
            EmbedBottomSheet embedBottomSheet2 = new EmbedBottomSheet(activity, title, description, originalUrl, url, w, h, seekTime);
            embedBottomSheet2.setCalcMandatoryInsets(keyboardVisible);
            embedBottomSheet2.show();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private EmbedBottomSheet(Context context, String title, String description, String originalUrl, final String url, int w, int h, int seekTime) {
        super(context, false);
        this.canDismissWithTouchOutside = true;
        this.position = new int[2];
        this.lastOrientation = -1;
        this.prevOrientation = -2;
        this.youtubeFrame = "<!DOCTYPE html><html><head><style>body { margin: 0; width:100%%; height:100%%;  background-color:#000; }html { width:100%%; height:100%%; background-color:#000; }.embed-container iframe,.embed-container object,   .embed-container embed {       position: absolute;       top: 0;       left: 0;       width: 100%% !important;       height: 100%% !important;   }   </style></head><body>   <div class=\"embed-container\">       <div id=\"player\"></div>   </div>   <script src=\"https://www.youtube.com/iframe_api\"></script>   <script>   var player;   var observer;   var videoEl;   var playing;   var posted = false;   YT.ready(function() {       player = new YT.Player(\"player\", {                              \"width\" : \"100%%\",                              \"events\" : {                              \"onReady\" : \"onReady\",                              \"onError\" : \"onError\",                              \"onStateChange\" : \"onStateChange\",                              },                              \"videoId\" : \"%1$s\",                              \"height\" : \"100%%\",                              \"playerVars\" : {                              \"start\" : %2$d,                              \"rel\" : 1,                              \"showinfo\" : 0,                              \"modestbranding\" : 0,                              \"iv_load_policy\" : 3,                              \"autohide\" : 1,                              \"autoplay\" : 1,                              \"cc_load_policy\" : 1,                              \"playsinline\" : 1,                              \"controls\" : 1                              }                            });        player.setSize(window.innerWidth, window.innerHeight);    });    function hideControls() {        playing = !videoEl.paused;       videoEl.controls = 0;       observer.observe(videoEl, {attributes: true});    }    function showControls() {        playing = !videoEl.paused;       observer.disconnect();       videoEl.controls = 1;    }    function onError(event) {       if (!posted) {            if (window.YoutubeProxy !== undefined) {                   YoutubeProxy.postEvent(\"loaded\", null);             }            posted = true;       }    }    function onStateChange(event) {       if (event.data == YT.PlayerState.PLAYING && !posted) {            if (window.YoutubeProxy !== undefined) {                   YoutubeProxy.postEvent(\"loaded\", null);             }            posted = true;       }    }    function onReady(event) {       player.playVideo();    }    window.onresize = function() {       player.setSize(window.innerWidth, window.innerHeight);       player.playVideo();    }    </script></body></html>";
        this.onShowListener = new DialogInterface.OnShowListener() { // from class: ir.eitaa.ui.Components.EmbedBottomSheet.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialog) {
                if (EmbedBottomSheet.this.pipVideoView == null || !EmbedBottomSheet.this.videoView.isInline()) {
                    return;
                }
                EmbedBottomSheet.this.videoView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.Components.EmbedBottomSheet.1.1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        EmbedBottomSheet.this.videoView.getViewTreeObserver().removeOnPreDrawListener(this);
                        return true;
                    }
                });
            }
        };
        this.fullWidth = true;
        setApplyTopPadding(false);
        setApplyBottomPadding(false);
        this.seekTimeOverride = seekTime;
        if (context instanceof Activity) {
            this.parentActivity = (Activity) context;
        }
        if (url.toLowerCase().contains("?eitaafly") || url.toLowerCase().contains("&eitaafly")) {
            this.canDismissWithTouchOutside = false;
        } else {
            this.canDismissWithTouchOutside = true;
        }
        this.embedUrl = url;
        this.hasDescription = description != null && description.length() > 0;
        this.openUrl = originalUrl;
        this.width = w;
        this.height = h;
        if (w == 0 || h == 0) {
            android.graphics.Point point = AndroidUtilities.displaySize;
            this.width = point.x;
            this.height = point.y / 2;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.fullscreenVideoContainer = frameLayout;
        frameLayout.setKeepScreenOn(true);
        this.fullscreenVideoContainer.setBackgroundColor(-16777216);
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            this.fullscreenVideoContainer.setFitsSystemWindows(true);
        }
        this.fullscreenVideoContainer.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmbedBottomSheet$MnWjKzJyhglq-nfIlsTGPE4yzcI
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return EmbedBottomSheet.lambda$new$0(view, motionEvent);
            }
        });
        this.container.addView(this.fullscreenVideoContainer, LayoutHelper.createFrame(-1, -1.0f));
        this.fullscreenVideoContainer.setVisibility(4);
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.EmbedBottomSheet.2
            @Override // android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                try {
                    if ((EmbedBottomSheet.this.pipVideoView == null || EmbedBottomSheet.this.webView.getVisibility() != 0) && EmbedBottomSheet.this.webView.getParent() != null) {
                        removeView(EmbedBottomSheet.this.webView);
                        EmbedBottomSheet.this.webView.stopLoading();
                        EmbedBottomSheet.this.webView.loadUrl("about:blank");
                        EmbedBottomSheet.this.webView.destroy();
                    }
                    if (EmbedBottomSheet.this.videoView.isInline() || EmbedBottomSheet.this.pipVideoView != null) {
                        return;
                    }
                    if (EmbedBottomSheet.instance == EmbedBottomSheet.this) {
                        EmbedBottomSheet unused = EmbedBottomSheet.instance = null;
                    }
                    EmbedBottomSheet.this.videoView.destroy();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(((int) Math.min(EmbedBottomSheet.this.height / (EmbedBottomSheet.this.width / View.MeasureSpec.getSize(widthMeasureSpec)), AndroidUtilities.displaySize.y / 2)) + AndroidUtilities.dp((EmbedBottomSheet.this.hasDescription ? 22 : 0) + 84) + 1, 1073741824));
            }
        };
        this.containerLayout = frameLayout2;
        frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmbedBottomSheet$tRI2zwXgkIEYNDdmsqme4U6RJJU
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return EmbedBottomSheet.lambda$new$1(view, motionEvent);
            }
        });
        setCustomView(this.containerLayout);
        WebView webView = new WebView(context) { // from class: ir.eitaa.ui.Components.EmbedBottomSheet.3
            @Override // android.webkit.WebView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                boolean zOnTouchEvent = super.onTouchEvent(event);
                if (zOnTouchEvent) {
                    if (event.getAction() == 1) {
                        EmbedBottomSheet.this.setDisableScroll(false);
                    } else {
                        EmbedBottomSheet.this.setDisableScroll(true);
                    }
                }
                return zOnTouchEvent;
            }
        };
        this.webView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        if (i >= 17) {
            this.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        if (i >= 21) {
            this.webView.getSettings().setMixedContentMode(0);
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.webView, true);
        }
        this.webView.setWebChromeClient(new WebChromeClient() { // from class: ir.eitaa.ui.Components.EmbedBottomSheet.4
            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
                onShowCustomView(view, callback);
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                if (EmbedBottomSheet.this.customView != null || EmbedBottomSheet.this.pipVideoView != null) {
                    callback.onCustomViewHidden();
                    return;
                }
                EmbedBottomSheet.this.exitFromPip();
                EmbedBottomSheet.this.customView = view;
                EmbedBottomSheet.this.getSheetContainer().setVisibility(4);
                EmbedBottomSheet.this.fullscreenVideoContainer.setVisibility(0);
                EmbedBottomSheet.this.fullscreenVideoContainer.addView(view, LayoutHelper.createFrame(-1, -1.0f));
                EmbedBottomSheet.this.customViewCallback = callback;
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                super.onHideCustomView();
                if (EmbedBottomSheet.this.customView == null) {
                    return;
                }
                EmbedBottomSheet.this.getSheetContainer().setVisibility(0);
                EmbedBottomSheet.this.fullscreenVideoContainer.setVisibility(4);
                EmbedBottomSheet.this.fullscreenVideoContainer.removeView(EmbedBottomSheet.this.customView);
                if (EmbedBottomSheet.this.customViewCallback != null && !EmbedBottomSheet.this.customViewCallback.getClass().getName().contains(".chromium.")) {
                    EmbedBottomSheet.this.customViewCallback.onCustomViewHidden();
                }
                EmbedBottomSheet.this.customView = null;
            }
        });
        this.webView.setWebViewClient(new WebViewClient() { // from class: ir.eitaa.ui.Components.EmbedBottomSheet.5
            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url2) {
                super.onLoadResource(view, url2);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url2) {
                super.onPageFinished(view, url2);
                if (!EmbedBottomSheet.this.isYouTube || Build.VERSION.SDK_INT < 17) {
                    EmbedBottomSheet.this.progressBar.setVisibility(4);
                    EmbedBottomSheet.this.progressBarBlackBackground.setVisibility(4);
                    EmbedBottomSheet.this.pipButton.setEnabled(true);
                    EmbedBottomSheet.this.pipButton.setAlpha(1.0f);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url2) {
                if (EmbedBottomSheet.this.isYouTube) {
                    Browser.openUrl(view.getContext(), url2);
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url2);
            }
        });
        this.containerLayout.addView(this.webView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, (this.hasDescription ? 22 : 0) + 48));
        WebPlayerView webPlayerView = new WebPlayerView(context, true, false, new WebPlayerView.WebPlayerViewDelegate() { // from class: ir.eitaa.ui.Components.EmbedBottomSheet.6
            @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
            public void onSharePressed() {
            }

            @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
            public void onVideoSizeChanged(float aspectRatio, int rotation) {
            }

            @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
            public void onInitFailed() {
                EmbedBottomSheet.this.webView.setVisibility(0);
                EmbedBottomSheet.this.imageButtonsContainer.setVisibility(0);
                EmbedBottomSheet.this.copyTextButton.setVisibility(4);
                EmbedBottomSheet.this.webView.setKeepScreenOn(true);
                EmbedBottomSheet.this.videoView.setVisibility(4);
                EmbedBottomSheet.this.videoView.getControlsView().setVisibility(4);
                EmbedBottomSheet.this.videoView.getTextureView().setVisibility(4);
                if (EmbedBottomSheet.this.videoView.getTextureImageView() != null) {
                    EmbedBottomSheet.this.videoView.getTextureImageView().setVisibility(4);
                }
                EmbedBottomSheet.this.videoView.loadVideo(null, null, null, null, false);
                HashMap map = new HashMap();
                map.put("Referer", "eitaa.org");
                try {
                    EmbedBottomSheet.this.webView.loadUrl(EmbedBottomSheet.this.embedUrl, map);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }

            @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
            public TextureView onSwitchToFullscreen(View controlsView, boolean fullscreen, float aspectRatio, int rotation, boolean byButton) {
                if (fullscreen) {
                    EmbedBottomSheet.this.fullscreenVideoContainer.setVisibility(0);
                    EmbedBottomSheet.this.fullscreenVideoContainer.setAlpha(1.0f);
                    EmbedBottomSheet.this.fullscreenVideoContainer.addView(EmbedBottomSheet.this.videoView.getAspectRatioView());
                    EmbedBottomSheet.this.wasInLandscape = false;
                    EmbedBottomSheet.this.fullscreenedByButton = byButton;
                    if (EmbedBottomSheet.this.parentActivity == null) {
                        return null;
                    }
                    try {
                        EmbedBottomSheet embedBottomSheet = EmbedBottomSheet.this;
                        embedBottomSheet.prevOrientation = embedBottomSheet.parentActivity.getRequestedOrientation();
                        if (byButton) {
                            if (((WindowManager) EmbedBottomSheet.this.parentActivity.getSystemService("window")).getDefaultDisplay().getRotation() == 3) {
                                EmbedBottomSheet.this.parentActivity.setRequestedOrientation(8);
                            } else {
                                EmbedBottomSheet.this.parentActivity.setRequestedOrientation(0);
                            }
                        }
                        ((BottomSheet) EmbedBottomSheet.this).containerView.setSystemUiVisibility(1028);
                        return null;
                    } catch (Exception e) {
                        FileLog.e(e);
                        return null;
                    }
                }
                EmbedBottomSheet.this.fullscreenVideoContainer.setVisibility(4);
                EmbedBottomSheet.this.fullscreenedByButton = false;
                if (EmbedBottomSheet.this.parentActivity == null) {
                    return null;
                }
                try {
                    ((BottomSheet) EmbedBottomSheet.this).containerView.setSystemUiVisibility(0);
                    EmbedBottomSheet.this.parentActivity.setRequestedOrientation(EmbedBottomSheet.this.prevOrientation);
                    return null;
                } catch (Exception e2) {
                    FileLog.e(e2);
                    return null;
                }
            }

            @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
            public void onInlineSurfaceTextureReady() {
                if (EmbedBottomSheet.this.videoView.isInline()) {
                    EmbedBottomSheet.this.dismissInternal();
                }
            }

            @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
            public void prepareToSwitchInlineMode(boolean inline, final Runnable switchInlineModeRunnable, float aspectRatio, boolean animated) {
                if (inline) {
                    if (EmbedBottomSheet.this.parentActivity != null) {
                        try {
                            ((BottomSheet) EmbedBottomSheet.this).containerView.setSystemUiVisibility(0);
                            if (EmbedBottomSheet.this.prevOrientation != -2) {
                                EmbedBottomSheet.this.parentActivity.setRequestedOrientation(EmbedBottomSheet.this.prevOrientation);
                            }
                        } catch (Exception e) {
                            FileLog.e(e);
                        }
                    }
                    if (EmbedBottomSheet.this.fullscreenVideoContainer.getVisibility() == 0) {
                        ((BottomSheet) EmbedBottomSheet.this).containerView.setTranslationY(((BottomSheet) EmbedBottomSheet.this).containerView.getMeasuredHeight() + AndroidUtilities.dp(10.0f));
                        ((BottomSheet) EmbedBottomSheet.this).backDrawable.setAlpha(0);
                    }
                    EmbedBottomSheet.this.setOnShowListener(null);
                    if (animated) {
                        TextureView textureView = EmbedBottomSheet.this.videoView.getTextureView();
                        View controlsView = EmbedBottomSheet.this.videoView.getControlsView();
                        ImageView textureImageView = EmbedBottomSheet.this.videoView.getTextureImageView();
                        Rect pipRect = PipVideoView.getPipRect(aspectRatio);
                        float width = pipRect.width / textureView.getWidth();
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(ObjectAnimator.ofFloat(textureImageView, (Property<ImageView, Float>) View.SCALE_X, width), ObjectAnimator.ofFloat(textureImageView, (Property<ImageView, Float>) View.SCALE_Y, width), ObjectAnimator.ofFloat(textureImageView, (Property<ImageView, Float>) View.TRANSLATION_X, pipRect.x), ObjectAnimator.ofFloat(textureImageView, (Property<ImageView, Float>) View.TRANSLATION_Y, pipRect.y), ObjectAnimator.ofFloat(textureView, (Property<TextureView, Float>) View.SCALE_X, width), ObjectAnimator.ofFloat(textureView, (Property<TextureView, Float>) View.SCALE_Y, width), ObjectAnimator.ofFloat(textureView, (Property<TextureView, Float>) View.TRANSLATION_X, pipRect.x), ObjectAnimator.ofFloat(textureView, (Property<TextureView, Float>) View.TRANSLATION_Y, pipRect.y), ObjectAnimator.ofFloat(((BottomSheet) EmbedBottomSheet.this).containerView, (Property<ViewGroup, Float>) View.TRANSLATION_Y, ((BottomSheet) EmbedBottomSheet.this).containerView.getMeasuredHeight() + AndroidUtilities.dp(10.0f)), ObjectAnimator.ofInt(((BottomSheet) EmbedBottomSheet.this).backDrawable, AnimationProperties.COLOR_DRAWABLE_ALPHA, 0), ObjectAnimator.ofFloat(EmbedBottomSheet.this.fullscreenVideoContainer, (Property<FrameLayout, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(controlsView, (Property<View, Float>) View.ALPHA, 0.0f));
                        animatorSet.setInterpolator(new DecelerateInterpolator());
                        animatorSet.setDuration(250L);
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.EmbedBottomSheet.6.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                if (EmbedBottomSheet.this.fullscreenVideoContainer.getVisibility() == 0) {
                                    EmbedBottomSheet.this.fullscreenVideoContainer.setAlpha(1.0f);
                                    EmbedBottomSheet.this.fullscreenVideoContainer.setVisibility(4);
                                }
                                switchInlineModeRunnable.run();
                            }
                        });
                        animatorSet.start();
                        return;
                    }
                    if (EmbedBottomSheet.this.fullscreenVideoContainer.getVisibility() == 0) {
                        EmbedBottomSheet.this.fullscreenVideoContainer.setAlpha(1.0f);
                        EmbedBottomSheet.this.fullscreenVideoContainer.setVisibility(4);
                    }
                    switchInlineModeRunnable.run();
                    EmbedBottomSheet.this.dismissInternal();
                    return;
                }
                if (ApplicationLoader.mainInterfacePaused) {
                    try {
                        EmbedBottomSheet.this.parentActivity.startService(new Intent(ApplicationLoader.applicationContext, (Class<?>) BringAppForegroundService.class));
                    } catch (Throwable th) {
                        FileLog.e(th);
                    }
                }
                if (!animated) {
                    EmbedBottomSheet.this.pipVideoView.close();
                    EmbedBottomSheet.this.pipVideoView = null;
                } else {
                    EmbedBottomSheet embedBottomSheet = EmbedBottomSheet.this;
                    embedBottomSheet.setOnShowListener(embedBottomSheet.onShowListener);
                    Rect pipRect2 = PipVideoView.getPipRect(aspectRatio);
                    TextureView textureView2 = EmbedBottomSheet.this.videoView.getTextureView();
                    ImageView textureImageView2 = EmbedBottomSheet.this.videoView.getTextureImageView();
                    float f = pipRect2.width / textureView2.getLayoutParams().width;
                    textureImageView2.setScaleX(f);
                    textureImageView2.setScaleY(f);
                    textureImageView2.setTranslationX(pipRect2.x);
                    textureImageView2.setTranslationY(pipRect2.y);
                    textureView2.setScaleX(f);
                    textureView2.setScaleY(f);
                    textureView2.setTranslationX(pipRect2.x);
                    textureView2.setTranslationY(pipRect2.y);
                }
                EmbedBottomSheet.this.setShowWithoutAnimation(true);
                EmbedBottomSheet.this.show();
                if (animated) {
                    EmbedBottomSheet.this.waitingForDraw = 4;
                    ((BottomSheet) EmbedBottomSheet.this).backDrawable.setAlpha(1);
                    ((BottomSheet) EmbedBottomSheet.this).containerView.setTranslationY(((BottomSheet) EmbedBottomSheet.this).containerView.getMeasuredHeight() + AndroidUtilities.dp(10.0f));
                }
            }

            @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
            public TextureView onSwitchInlineMode(View controlsView, boolean inline, float aspectRatio, int rotation, boolean animated) {
                if (inline) {
                    controlsView.setTranslationY(0.0f);
                    EmbedBottomSheet.this.pipVideoView = new PipVideoView(false);
                    return EmbedBottomSheet.this.pipVideoView.show(EmbedBottomSheet.this.parentActivity, EmbedBottomSheet.this, controlsView, aspectRatio, rotation, null);
                }
                if (animated) {
                    EmbedBottomSheet.this.animationInProgress = true;
                    EmbedBottomSheet.this.videoView.getAspectRatioView().getLocationInWindow(EmbedBottomSheet.this.position);
                    int[] iArr = EmbedBottomSheet.this.position;
                    iArr[0] = iArr[0] - EmbedBottomSheet.this.getLeftInset();
                    EmbedBottomSheet.this.position[1] = (int) (r8[1] - ((BottomSheet) EmbedBottomSheet.this).containerView.getTranslationY());
                    TextureView textureView = EmbedBottomSheet.this.videoView.getTextureView();
                    ImageView textureImageView = EmbedBottomSheet.this.videoView.getTextureImageView();
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ObjectAnimator.ofFloat(textureImageView, (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(textureImageView, (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(textureImageView, (Property<ImageView, Float>) View.TRANSLATION_X, EmbedBottomSheet.this.position[0]), ObjectAnimator.ofFloat(textureImageView, (Property<ImageView, Float>) View.TRANSLATION_Y, EmbedBottomSheet.this.position[1]), ObjectAnimator.ofFloat(textureView, (Property<TextureView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(textureView, (Property<TextureView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(textureView, (Property<TextureView, Float>) View.TRANSLATION_X, EmbedBottomSheet.this.position[0]), ObjectAnimator.ofFloat(textureView, (Property<TextureView, Float>) View.TRANSLATION_Y, EmbedBottomSheet.this.position[1]), ObjectAnimator.ofFloat(((BottomSheet) EmbedBottomSheet.this).containerView, (Property<ViewGroup, Float>) View.TRANSLATION_Y, 0.0f), ObjectAnimator.ofInt(((BottomSheet) EmbedBottomSheet.this).backDrawable, AnimationProperties.COLOR_DRAWABLE_ALPHA, 51));
                    animatorSet.setInterpolator(new DecelerateInterpolator());
                    animatorSet.setDuration(250L);
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.EmbedBottomSheet.6.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            EmbedBottomSheet.this.animationInProgress = false;
                        }
                    });
                    animatorSet.start();
                    return null;
                }
                ((BottomSheet) EmbedBottomSheet.this).containerView.setTranslationY(0.0f);
                return null;
            }

            @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
            public void onPlayStateChanged(WebPlayerView playerView, boolean playing) {
                if (playing) {
                    try {
                        EmbedBottomSheet.this.parentActivity.getWindow().addFlags(128);
                        return;
                    } catch (Exception e) {
                        FileLog.e(e);
                        return;
                    }
                }
                try {
                    EmbedBottomSheet.this.parentActivity.getWindow().clearFlags(128);
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }

            @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
            public boolean checkInlinePermissions() {
                return EmbedBottomSheet.this.checkInlinePermissions();
            }

            @Override // ir.eitaa.ui.Components.WebPlayerView.WebPlayerViewDelegate
            public ViewGroup getTextureViewContainer() {
                return ((BottomSheet) EmbedBottomSheet.this).container;
            }
        });
        this.videoView = webPlayerView;
        webPlayerView.setVisibility(4);
        this.containerLayout.addView(this.videoView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, ((this.hasDescription ? 22 : 0) + 84) - 10));
        View view = new View(context);
        this.progressBarBlackBackground = view;
        view.setBackgroundColor(-16777216);
        this.progressBarBlackBackground.setVisibility(4);
        this.containerLayout.addView(this.progressBarBlackBackground, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, (this.hasDescription ? 22 : 0) + 84));
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.progressBar = radialProgressView;
        radialProgressView.setVisibility(4);
        this.containerLayout.addView(this.progressBar, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, 0.0f, 0.0f, ((this.hasDescription ? 22 : 0) + 84) / 2));
        if (this.hasDescription) {
            TextView textView = new TextView(context);
            textView.setTextSize(1, 16.0f);
            textView.setTextColor(Theme.getColor("dialogTextBlack"));
            textView.setText(description);
            textView.setSingleLine(true);
            textView.setTypeface(AndroidUtilities.getFontFamily(true));
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
            this.containerLayout.addView(textView, LayoutHelper.createFrame(-1, -2.0f, 83, 0.0f, 0.0f, 0.0f, 77.0f));
        }
        if (this.hasDescription) {
            TextView textView2 = new TextView(context);
            textView2.setTextSize(1, 14.0f);
            textView2.setTextColor(Theme.getColor("dialogTextGray"));
            textView2.setText(title);
            textView2.setSingleLine(true);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
            this.containerLayout.addView(textView2, LayoutHelper.createFrame(-1, -2.0f, 83, 0.0f, 0.0f, 0.0f, 57.0f));
        }
        View view2 = new View(context);
        view2.setBackgroundColor(Theme.getColor("dialogGrayLine"));
        this.containerLayout.addView(view2, new FrameLayout.LayoutParams(-1, 1, 83));
        ((FrameLayout.LayoutParams) view2.getLayoutParams()).bottomMargin = AndroidUtilities.dp(48.0f);
        FrameLayout frameLayout3 = new FrameLayout(context);
        frameLayout3.setBackgroundColor(Theme.getColor("dialogBackground"));
        this.containerLayout.addView(frameLayout3, LayoutHelper.createFrame(-1, 48, 83));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setWeightSum(1.0f);
        frameLayout3.addView(linearLayout, LayoutHelper.createFrame(-2, -1, 53));
        TextView textView3 = new TextView(context);
        textView3.setTextSize(1, 14.0f);
        textView3.setTextColor(Theme.getColor("dialogTextBlue4"));
        textView3.setGravity(17);
        textView3.setSingleLine(true);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("dialogButtonSelector"), 0));
        textView3.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        textView3.setText(LocaleController.getString("Close", R.string.Close).toUpperCase());
        textView3.setTypeface(AndroidUtilities.getFontFamily(true));
        frameLayout3.addView(textView3, LayoutHelper.createLinear(-2, -1, 51));
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmbedBottomSheet$yCLfDRIGPk0y6F75yDoIfrnIwc4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$2$EmbedBottomSheet(view3);
            }
        });
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.imageButtonsContainer = linearLayout2;
        linearLayout2.setVisibility(4);
        frameLayout3.addView(this.imageButtonsContainer, LayoutHelper.createFrame(-2, -1, 17));
        ImageView imageView = new ImageView(context);
        this.pipButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.pipButton.setImageResource(R.drawable.video_pip);
        this.pipButton.setContentDescription(LocaleController.getString("AccDescrPipMode", R.string.AccDescrPipMode));
        this.pipButton.setEnabled(false);
        this.pipButton.setAlpha(0.5f);
        this.pipButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("dialogTextBlue4"), PorterDuff.Mode.MULTIPLY));
        this.pipButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("dialogButtonSelector"), 0));
        this.imageButtonsContainer.addView(this.pipButton, LayoutHelper.createFrame(48, 48.0f, 51, 0.0f, 0.0f, 4.0f, 0.0f));
        this.pipButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmbedBottomSheet$aWVVPBNlK__7UbM7mfPiQQOq9g8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$3$EmbedBottomSheet(view3);
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmbedBottomSheet$zE7Q9wYpyDIBI01GW41dN_zxovs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$4$EmbedBottomSheet(view3);
            }
        };
        ImageView imageView2 = new ImageView(context);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        imageView2.setImageResource(R.drawable.video_copy);
        imageView2.setContentDescription(LocaleController.getString("CopyLink", R.string.CopyLink));
        imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor("dialogTextBlue4"), PorterDuff.Mode.MULTIPLY));
        imageView2.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("dialogButtonSelector"), 0));
        this.imageButtonsContainer.addView(imageView2, LayoutHelper.createFrame(48, 48, 51));
        imageView2.setOnClickListener(onClickListener);
        TextView textView4 = new TextView(context);
        this.copyTextButton = textView4;
        textView4.setTextSize(1, 14.0f);
        this.copyTextButton.setTextColor(Theme.getColor("dialogTextBlue4"));
        this.copyTextButton.setGravity(17);
        this.copyTextButton.setSingleLine(true);
        this.copyTextButton.setEllipsize(TextUtils.TruncateAt.END);
        this.copyTextButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("dialogButtonSelector"), 0));
        this.copyTextButton.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        this.copyTextButton.setText(LocaleController.getString("Copy", R.string.Copy).toUpperCase());
        this.copyTextButton.setTypeface(AndroidUtilities.getFontFamily(true));
        linearLayout.addView(this.copyTextButton, LayoutHelper.createFrame(-2, -1, 51));
        this.copyTextButton.setOnClickListener(onClickListener);
        TextView textView5 = new TextView(context);
        textView5.setTextSize(1, 14.0f);
        textView5.setTextColor(Theme.getColor("dialogTextBlue4"));
        textView5.setGravity(17);
        textView5.setSingleLine(true);
        textView5.setEllipsize(TextUtils.TruncateAt.END);
        textView5.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("dialogButtonSelector"), 0));
        textView5.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        textView5.setText(LocaleController.getString("OpenInBrowser", R.string.OpenInBrowser).toUpperCase());
        textView5.setTypeface(AndroidUtilities.getFontFamily(true));
        linearLayout.addView(textView5, LayoutHelper.createFrame(-2, -1, 51));
        textView5.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$EmbedBottomSheet$p4_URadV4SNQ5MmGuxQ45XYFo28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$5$EmbedBottomSheet(view3);
            }
        });
        final boolean z = this.videoView.canHandleUrl(this.embedUrl) || this.videoView.canHandleUrl(originalUrl);
        this.videoView.setVisibility(z ? 0 : 4);
        if (z) {
            this.videoView.willHandle();
        }
        setDelegate(new BottomSheet.BottomSheetDelegate() { // from class: ir.eitaa.ui.Components.EmbedBottomSheet.8
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:37:0x016e  */
            @Override // ir.eitaa.ui.ActionBar.BottomSheet.BottomSheetDelegate, ir.eitaa.ui.ActionBar.BottomSheet.BottomSheetDelegateInterface
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onOpenAnimationEnd() {
                /*
                    Method dump skipped, instructions count: 425
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.EmbedBottomSheet.AnonymousClass8.onOpenAnimationEnd():void");
            }

            @Override // ir.eitaa.ui.ActionBar.BottomSheet.BottomSheetDelegateInterface
            public boolean canDismiss() {
                if (EmbedBottomSheet.this.videoView.isInFullscreen()) {
                    EmbedBottomSheet.this.videoView.exitFullscreen();
                    return false;
                }
                try {
                    EmbedBottomSheet.this.parentActivity.getWindow().clearFlags(128);
                    return true;
                } catch (Exception e) {
                    FileLog.e(e);
                    return true;
                }
            }
        });
        this.orientationEventListener = new OrientationEventListener(ApplicationLoader.applicationContext) { // from class: ir.eitaa.ui.Components.EmbedBottomSheet.9
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                if (EmbedBottomSheet.this.orientationEventListener != null && EmbedBottomSheet.this.videoView.getVisibility() == 0 && EmbedBottomSheet.this.parentActivity != null && EmbedBottomSheet.this.videoView.isInFullscreen() && EmbedBottomSheet.this.fullscreenedByButton) {
                    if (orientation < 240 || orientation > 300) {
                        if (!EmbedBottomSheet.this.wasInLandscape || orientation <= 0) {
                            return;
                        }
                        if (orientation >= 330 || orientation <= 30) {
                            EmbedBottomSheet.this.parentActivity.setRequestedOrientation(EmbedBottomSheet.this.prevOrientation);
                            EmbedBottomSheet.this.fullscreenedByButton = false;
                            EmbedBottomSheet.this.wasInLandscape = false;
                            return;
                        }
                        return;
                    }
                    EmbedBottomSheet.this.wasInLandscape = true;
                }
            }
        };
        String youTubeVideoId = WebPlayerView.getYouTubeVideoId(this.embedUrl);
        if (youTubeVideoId != null || !z) {
            this.progressBar.setVisibility(0);
            this.webView.setVisibility(0);
            this.imageButtonsContainer.setVisibility(0);
            if (youTubeVideoId != null) {
                this.progressBarBlackBackground.setVisibility(0);
            }
            this.copyTextButton.setVisibility(4);
            this.webView.setKeepScreenOn(true);
            this.videoView.setVisibility(4);
            this.videoView.getControlsView().setVisibility(4);
            this.videoView.getTextureView().setVisibility(4);
            if (this.videoView.getTextureImageView() != null) {
                this.videoView.getTextureImageView().setVisibility(4);
            }
            if (youTubeVideoId != null && "disabled".equals(MessagesController.getInstance(this.currentAccount).youtubePipType)) {
                this.pipButton.setVisibility(8);
            }
        }
        if (this.orientationEventListener.canDetectOrientation()) {
            this.orientationEventListener.enable();
        } else {
            this.orientationEventListener.disable();
            this.orientationEventListener = null;
        }
        instance = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$EmbedBottomSheet(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$EmbedBottomSheet(View view) {
        int i;
        boolean z = this.isYouTube && "inapp".equals(MessagesController.getInstance(this.currentAccount).youtubePipType);
        if ((z || checkInlinePermissions()) && this.progressBar.getVisibility() != 0) {
            PipVideoView pipVideoView = new PipVideoView(z);
            this.pipVideoView = pipVideoView;
            Activity activity = this.parentActivity;
            int i2 = this.width;
            pipVideoView.show(activity, this, null, (i2 == 0 || (i = this.height) == 0) ? 1.0f : i2 / i, 0, this.webView);
            if (this.isYouTube) {
                runJsCode("hideControls();");
            }
            this.containerView.setTranslationY(0.0f);
            dismissInternal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$EmbedBottomSheet(View view) {
        try {
            ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", this.openUrl));
        } catch (Exception e) {
            FileLog.e(e);
        }
        Activity activity = this.parentActivity;
        if (activity instanceof LaunchActivity) {
            ((LaunchActivity) activity).showBulletin(new Function() { // from class: ir.eitaa.ui.Components.-$$Lambda$DU5UGQHXMHRCeCs0-cfa5dDHYik
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((BulletinFactory) obj).createCopyLinkBulletin();
                }
            });
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$5$EmbedBottomSheet(View view) {
        Browser.openUrl(this.parentActivity, this.openUrl);
        dismiss();
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

    public boolean checkInlinePermissions() {
        Activity activity = this.parentActivity;
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(activity)) {
            return true;
        }
        AlertsCreator.createDrawOverlayPermissionDialog(this.parentActivity, null).show();
        return false;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return (this.videoView.getVisibility() == 0 && this.videoView.isInFullscreen()) ? false : true;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void onConfigurationChanged(Configuration newConfig) {
        if (this.videoView.getVisibility() == 0 && this.videoView.isInitied() && !this.videoView.isInline()) {
            if (newConfig.orientation == 2) {
                if (!this.videoView.isInFullscreen()) {
                    this.videoView.enterFullscreen();
                }
            } else if (this.videoView.isInFullscreen()) {
                this.videoView.exitFullscreen();
            }
        }
        PipVideoView pipVideoView = this.pipVideoView;
        if (pipVideoView != null) {
            pipVideoView.onConfigurationChanged();
        }
    }

    @Override // ir.eitaa.ui.Components.Pipable
    public void destroy() {
        WebView webView = this.webView;
        if (webView != null && webView.getVisibility() == 0) {
            this.containerLayout.removeView(this.webView);
            this.webView.stopLoading();
            this.webView.loadUrl("about:blank");
            this.webView.destroy();
        }
        PipVideoView pipVideoView = this.pipVideoView;
        if (pipVideoView != null) {
            pipVideoView.close();
            this.pipVideoView = null;
        }
        WebPlayerView webPlayerView = this.videoView;
        if (webPlayerView != null) {
            webPlayerView.destroy();
        }
        instance = null;
        dismissInternal();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        super.dismissInternal();
        OrientationEventListener orientationEventListener = this.orientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.orientationEventListener = null;
        }
    }

    @Override // ir.eitaa.ui.Components.Pipable
    public void exitFromPip() {
        if (this.webView == null || this.pipVideoView == null) {
            return;
        }
        if (ApplicationLoader.mainInterfacePaused) {
            try {
                this.parentActivity.startService(new Intent(ApplicationLoader.applicationContext, (Class<?>) BringAppForegroundService.class));
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        if (this.isYouTube) {
            runJsCode("showControls();");
        }
        ViewGroup viewGroup = (ViewGroup) this.webView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.webView);
        }
        this.containerLayout.addView(this.webView, 0, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, (this.hasDescription ? 22 : 0) + 84));
        setShowWithoutAnimation(true);
        show();
        this.pipVideoView.close();
        this.pipVideoView = null;
    }

    public static EmbedBottomSheet getInstance() {
        return instance;
    }

    public void updateTextureViewPosition() {
        this.videoView.getAspectRatioView().getLocationInWindow(this.position);
        int[] iArr = this.position;
        iArr[0] = iArr[0] - getLeftInset();
        if (!this.videoView.isInline() && !this.animationInProgress) {
            TextureView textureView = this.videoView.getTextureView();
            textureView.setTranslationX(this.position[0]);
            textureView.setTranslationY(this.position[1]);
            ImageView textureImageView = this.videoView.getTextureImageView();
            if (textureImageView != null) {
                textureImageView.setTranslationX(this.position[0]);
                textureImageView.setTranslationY(this.position[1]);
            }
        }
        View controlsView = this.videoView.getControlsView();
        if (controlsView.getParent() == this.container) {
            controlsView.setTranslationY(this.position[1]);
        } else {
            controlsView.setTranslationY(0.0f);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithTouchOutside() {
        return this.canDismissWithTouchOutside && this.fullscreenVideoContainer.getVisibility() != 0;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected void onContainerTranslationYChanged(float translationY) {
        updateTextureViewPosition();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean onCustomMeasure(View view, int width, int height) {
        if (view == this.videoView.getControlsView()) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = this.videoView.getMeasuredWidth();
            layoutParams.height = this.videoView.getAspectRatioView().getMeasuredHeight() + (this.videoView.isInFullscreen() ? 0 : AndroidUtilities.dp(10.0f));
        }
        return false;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean onCustomLayout(View view, int left, int top, int right, int bottom) {
        if (view != this.videoView.getControlsView()) {
            return false;
        }
        updateTextureViewPosition();
        return false;
    }

    public void pause() {
        WebPlayerView webPlayerView = this.videoView;
        if (webPlayerView == null || !webPlayerView.isInitied()) {
            return;
        }
        this.videoView.pause();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void onContainerDraw(Canvas canvas) {
        int i = this.waitingForDraw;
        if (i != 0) {
            int i2 = i - 1;
            this.waitingForDraw = i2;
            if (i2 == 0) {
                this.videoView.updateTextureImageView();
                this.pipVideoView.close();
                this.pipVideoView = null;
                return;
            }
            this.container.invalidate();
        }
    }
}
