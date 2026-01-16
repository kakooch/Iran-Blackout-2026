package ir.resaneh1.iptv.fragment;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidMessenger.utilites.BotButtonHandler;
import androidMessenger.utilites.MessageConverter;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.MiniFunctionModels;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.appUpdate.UpdateUtils;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GoToChatInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.WebAppChangeUserTokenInput;
import ir.resaneh1.iptv.model.WebAppChangeUserTokenOutput;
import ir.resaneh1.iptv.model.WebAppClientActionOutput;
import ir.resaneh1.iptv.model.WebAppClientResponseInput;
import ir.resaneh1.iptv.model.WebAppMiniFunctionObject;
import ir.resaneh1.iptv.model.WebAppObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CombinedDrawable;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class WebAppFragment extends PresenterFragment {
    private ImageView closeImageView;
    private String currentlyLoadingUrl;
    private boolean isErrorHappened;
    WebAppObject webAppObject;
    WebView webView;
    private boolean canGoBack = true;
    private boolean goBackNow = false;
    private boolean isPaused = false;
    Runnable backPressRunnable = new Runnable() { // from class: ir.resaneh1.iptv.fragment.WebAppFragment.5
        @Override // java.lang.Runnable
        public void run() {
            if (ApplicationLoader.applicationActivity == null || !WebAppFragment.this.canGoBack) {
                return;
            }
            WebAppFragment.this.goBackNow = true;
            MyLog.e("LogStopGoBack", "CanGoBack");
            ApplicationLoader.applicationActivity.onBackPressed();
        }
    };

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.web_fragment;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, int i2, Intent intent) {
    }

    public WebAppFragment(WebAppObject webAppObject) {
        this.swipeBackEnabled = false;
        this.webAppObject = webAppObject;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.webView = (WebView) findViewById(R.id.webView);
        this.closeImageView = (ImageView) findViewById(R.id.imageViewClose);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void toggleFullscreenSwitch(boolean z) {
        int i = Build.VERSION.SDK_INT;
        WindowManager.LayoutParams attributes = ((Activity) getContext()).getWindow().getAttributes();
        if (!z) {
            ((Activity) getContext()).getWindow().getDecorView().setSystemUiVisibility(0);
            attributes.flags &= -1025;
            ((Activity) getContext()).getWindow().setAttributes(attributes);
        } else {
            if (i >= 19) {
                ((Activity) getContext()).getWindow().getDecorView().setSystemUiVisibility(5382);
                return;
            }
            ((Activity) getContext()).getWindow().getDecorView().setSystemUiVisibility(2);
            attributes.flags |= 1024;
            ((Activity) getContext()).getWindow().setAttributes(attributes);
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        this.progressBar.setVisibility(4);
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, this.webAppObject.title);
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        View viewCreateView = toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_close_grey);
        this.toolbarMaker.addViewToLeftLayout(viewCreateView);
        toolbarImageView.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_actionBarDefaultIcon), PorterDuff.Mode.SRC_ATOP));
        viewCreateView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.WebAppFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebAppFragment.this.goBackNow = true;
                if (ApplicationLoader.applicationActivity != null) {
                    ApplicationLoader.applicationActivity.onBackPressed();
                }
            }
        });
        WebAppObject.Properties properties = this.webAppObject.properties;
        if (properties != null && properties.is_fullscreen) {
            Window window = ((Activity) getContext()).getWindow();
            window.setFlags(134217728, 134217728);
            window.setFlags(ConnectionsManager.FileTypeFile, ConnectionsManager.FileTypeFile);
            toggleFullscreenSwitch(true);
            findViewById(R.id.toolbarFrame).setVisibility(8);
            this.closeImageView.setVisibility(0);
            this.closeImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.WebAppFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WebAppFragment.this.goBackNow = true;
                    if (ApplicationLoader.applicationActivity != null) {
                        ApplicationLoader.applicationActivity.onBackPressed();
                    }
                }
            });
            Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(36.0f), Theme.getColor(Theme.key_profile_actionBackground), Theme.getColor(Theme.key_profile_actionPressedBackground));
            int i = Build.VERSION.SDK_INT;
            if (i < 21) {
                Drawable drawableMutate = getContext().getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
                drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
                CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
                combinedDrawable.setIconSize(AndroidUtilities.dp(36.0f), AndroidUtilities.dp(36.0f));
                drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
            }
            if (i >= 21) {
                StateListAnimator stateListAnimator = new StateListAnimator();
                int[] iArr = {android.R.attr.state_pressed};
                ImageView imageView = this.closeImageView;
                Property property = View.TRANSLATION_Z;
                stateListAnimator.addState(iArr, ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
                stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.closeImageView, (Property<ImageView, Float>) property, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
                this.closeImageView.setStateListAnimator(stateListAnimator);
                this.closeImageView.setOutlineProvider(new ViewOutlineProvider(this) { // from class: ir.resaneh1.iptv.fragment.WebAppFragment.3
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setOval(0, 0, AndroidUtilities.dp(36.0f), AndroidUtilities.dp(36.0f));
                    }
                });
            }
            this.closeImageView.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
            this.closeImageView.setScaleType(ImageView.ScaleType.CENTER);
            this.closeImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_profile_actionIcon), PorterDuff.Mode.MULTIPLY));
        }
        this.webView = (WebView) findViewById(R.id.webView);
        this.progressBar = findViewById(R.id.progressBar);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(false);
        this.webView.getSettings().setAllowContentAccess(false);
        this.webView.getSettings().setAllowFileAccess(false);
        this.webView.getSettings().setAllowFileAccessFromFileURLs(false);
        this.webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        if (Build.VERSION.SDK_INT >= 17) {
            this.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        this.webView.getSettings().setLoadWithOverviewMode(false);
        this.webView.getSettings().setUseWideViewPort(false);
        this.webView.getSettings().setDisplayZoomControls(false);
        this.webView.getSettings().setBuiltInZoomControls(false);
        this.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        this.webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        this.webView.addJavascriptInterface(new WebViewJavaScriptInterface(ApplicationLoader.applicationContext), "androidApp");
        this.webView.setWebViewClient(new WebViewClient() { // from class: ir.resaneh1.iptv.fragment.WebAppFragment.4
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                char cCharAt;
                try {
                    Iterator<String> it = WebAppFragment.this.webAppObject.allowed_hosts.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (next.equals("*")) {
                            WebAppFragment.this.currentlyLoadingUrl = str;
                            return false;
                        }
                        if (str.equals(next)) {
                            WebAppFragment.this.currentlyLoadingUrl = str;
                            return false;
                        }
                        if (str.startsWith(next) && ((cCharAt = str.substring(next.length()).charAt(0)) < '0' || cCharAt > '9')) {
                            if (cCharAt < 'a' || cCharAt > 'z') {
                                if (cCharAt < 'A' || cCharAt > 'Z') {
                                    WebAppFragment.this.currentlyLoadingUrl = str;
                                    return false;
                                }
                            }
                        }
                    }
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                WebAppFragment.this.progressBar.setVisibility(0);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                WebAppFragment.this.progressBar.setVisibility(4);
                if (!WebAppFragment.this.isErrorHappened) {
                    WebAppFragment.this.webView.setVisibility(0);
                }
                WebAppFragment.this.isErrorHappened = false;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
                try {
                    if (!str2.equals(WebAppFragment.this.currentlyLoadingUrl)) {
                        if (!str2.equals(WebAppFragment.this.currentlyLoadingUrl + "/")) {
                            return;
                        }
                    }
                    WebAppFragment.this.handleError();
                } catch (Exception unused) {
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                try {
                    if (Build.VERSION.SDK_INT < 21 || !webResourceRequest.getUrl().toString().equals(WebAppFragment.this.currentlyLoadingUrl) || webResourceResponse.getStatusCode() < 400 || webResourceResponse.getStatusCode() >= 600) {
                        return;
                    }
                    WebAppFragment.this.handleError();
                } catch (Exception unused) {
                }
            }
        });
        String str = this.webAppObject.app_url;
        this.currentlyLoadingUrl = str;
        this.webView.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleError() {
        this.isErrorHappened = true;
        this.webView.setVisibility(4);
        this.progressBar.setVisibility(4);
        showRetryLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.resaneh1.iptv.PresenterFragment
    public void showRetryLayout() {
        super.showRetryLayout();
        this.progressBar.setVisibility(4);
        this.webView.setVisibility(4);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
        this.isErrorHappened = false;
        this.webView.reload();
    }

    public class WebViewJavaScriptInterface {
        public WebViewJavaScriptInterface(Context context) {
        }

        @JavascriptInterface
        public String clientAction(String str) {
            if (WebAppFragment.this.isPaused) {
                WebAppClientActionOutput webAppClientActionOutput = new WebAppClientActionOutput();
                webAppClientActionOutput.status = WebAppClientActionOutput.Status.Error;
                return ApplicationLoader.getGson().toJson(webAppClientActionOutput);
            }
            final WebAppMiniFunctionObject webAppMiniFunctionObject = (WebAppMiniFunctionObject) ApplicationLoader.getGson().fromJson(str, WebAppMiniFunctionObject.class);
            WebAppClientActionOutput webAppClientActionOutput2 = new WebAppClientActionOutput();
            MiniFunctionModels.ButtonType buttonType = webAppMiniFunctionObject.type;
            if (buttonType == null) {
                webAppClientActionOutput2.status = WebAppClientActionOutput.Status.NotSupported;
                return ApplicationLoader.getGson().toJson(webAppClientActionOutput2);
            }
            ArrayList<MiniFunctionModels.ButtonType> arrayList = WebAppFragment.this.webAppObject.function_types;
            if (arrayList == null || !arrayList.contains(buttonType)) {
                webAppClientActionOutput2.status = WebAppClientActionOutput.Status.NotAllowed;
                return ApplicationLoader.getGson().toJson(webAppClientActionOutput2);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.WebAppFragment.WebViewJavaScriptInterface.1
                @Override // java.lang.Runnable
                public void run() {
                    BotButtonHandler.handleButtonClick(WebAppFragment.this, 0L, webAppMiniFunctionObject, null, new BotButtonHandler.Delegate() { // from class: ir.resaneh1.iptv.fragment.WebAppFragment.WebViewJavaScriptInterface.1.1
                        boolean isDoneCalled = false;

                        @Override // androidMessenger.utilites.BotButtonHandler.Delegate
                        public void notSupported() {
                        }

                        @Override // androidMessenger.utilites.BotButtonHandler.Delegate
                        public void uploadFileDone(String str2, String str3) {
                        }

                        @Override // androidMessenger.utilites.BotButtonHandler.Delegate
                        public void done(String str2, ArrayList<String> arrayList2) {
                            if (this.isDoneCalled) {
                                return;
                            }
                            this.isDoneCalled = true;
                            WebAppClientResponseInput webAppClientResponseInput = new WebAppClientResponseInput();
                            webAppClientResponseInput.text = str2;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            webAppClientResponseInput.track_id = webAppMiniFunctionObject.track_id;
                            WebAppFragment.this.clientResponse(webAppClientResponseInput);
                        }

                        @Override // androidMessenger.utilites.BotButtonHandler.Delegate
                        public void onLocationSelected(TLRPC$MessageMedia tLRPC$MessageMedia) {
                            if (this.isDoneCalled) {
                                return;
                            }
                            this.isDoneCalled = true;
                            LocationObject locationObjectConvertMediaToLocationObject = MessageConverter.convertMediaToLocationObject(tLRPC$MessageMedia);
                            WebAppClientResponseInput webAppClientResponseInput = new WebAppClientResponseInput();
                            webAppClientResponseInput.text = locationObjectConvertMediaToLocationObject.latitude + "," + locationObjectConvertMediaToLocationObject.longitude;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            webAppClientResponseInput.track_id = webAppMiniFunctionObject.track_id;
                            WebAppFragment.this.clientResponse(webAppClientResponseInput);
                        }
                    });
                }
            });
            webAppClientActionOutput2.status = WebAppClientActionOutput.Status.Done;
            return ApplicationLoader.getGson().toJson(webAppClientActionOutput2);
        }

        @JavascriptInterface
        public String getUserToken() {
            return WebAppFragment.this.webAppObject.user_token;
        }

        @JavascriptInterface
        public void stopGoBack() {
            WebAppFragment.this.canGoBack = false;
            MyLog.e("LogStopGoBack", "StopGoBack");
        }

        @JavascriptInterface
        public String getClientVersion() {
            return "{\"platform\":\"Android\",\"version\":\"" + UpdateUtils.getAppVersion(ApplicationLoader.applicationContext) + "\"}";
        }

        @JavascriptInterface
        public String getStartValue() {
            return "{\"start_value\":\"" + WebAppFragment.this.webAppObject.start_value + "\"}";
        }

        @JavascriptInterface
        public void closeApp() {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.WebAppFragment.WebViewJavaScriptInterface.2
                @Override // java.lang.Runnable
                public void run() {
                    WebAppFragment.this.canGoBack = true;
                    WebAppFragment.this.goBackNow = true;
                    if (ApplicationLoader.applicationActivity != null) {
                        ApplicationLoader.applicationActivity.onBackPressed();
                    }
                }
            });
        }

        @JavascriptInterface
        public void stopProgressView() {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.WebAppFragment.WebViewJavaScriptInterface.3
                @Override // java.lang.Runnable
                public void run() {
                    WebAppFragment.this.progressBar.setVisibility(4);
                }
            });
        }

        @JavascriptInterface
        public void goToChat(final String str) {
            AndroidUtilities.runOnUIThread(new Runnable(this) { // from class: ir.resaneh1.iptv.fragment.WebAppFragment.WebViewJavaScriptInterface.4
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    GoToChatInput goToChatInput = (GoToChatInput) ApplicationLoader.getGson().fromJson(str, GoToChatInput.class);
                    if (ApplicationLoader.applicationActivity == null || (str2 = goToChatInput.username) == null || str2.isEmpty()) {
                        return;
                    }
                    new MainClickHandler().onMessengerUsernameClicked(goToChatInput.username);
                }
            });
        }

        @JavascriptInterface
        public void requestChangeUserToken() {
            WebAppChangeUserTokenInput webAppChangeUserTokenInput = new WebAppChangeUserTokenInput();
            WebAppFragment webAppFragment = WebAppFragment.this;
            webAppChangeUserTokenInput.app_id = webAppFragment.webAppObject.app_id;
            ApiRequestMessanger.getInstance(((BaseFragment) webAppFragment).currentAccount).webAppChangeUserToken(webAppChangeUserTokenInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.WebAppFragment.WebViewJavaScriptInterface.5
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    WebAppFragment webAppFragment2 = WebAppFragment.this;
                    WebAppObject webAppObject = webAppFragment2.webAppObject;
                    String str = ((WebAppChangeUserTokenOutput) obj).user_token;
                    webAppObject.user_token = str;
                    webAppFragment2.clientChangeUserToken(str);
                }
            });
        }
    }

    void clientResponse(WebAppClientResponseInput webAppClientResponseInput) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.webView.evaluateJavascript("clientResponse('" + ApplicationLoader.getGson().toJson(webAppClientResponseInput) + "');", null);
            return;
        }
        this.webView.loadUrl("javascript:clientResponse('" + ApplicationLoader.getGson().toJson(webAppClientResponseInput) + "');");
    }

    void clientGoBack() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.webView.evaluateJavascript("goBack();", null);
        } else {
            this.webView.loadUrl("javascript:goBack();");
        }
    }

    void clientChangeUserToken(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.webView.evaluateJavascript("getNewToken('" + str + "');", null);
            return;
        }
        this.webView.loadUrl("javascript:getNewToken('" + str + "');");
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        MyLog.e("LogStopGoBack", "OnBackPressed");
        if (this.goBackNow) {
            return super.onBackPressed();
        }
        clientGoBack();
        this.canGoBack = true;
        AndroidUtilities.cancelRunOnUIThread(this.backPressRunnable);
        AndroidUtilities.runOnUIThread(this.backPressRunnable, 300L);
        return false;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        this.isPaused = true;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        WebAppObject.Properties properties = this.webAppObject.properties;
        if (properties != null && properties.is_fullscreen) {
            toggleFullscreenSwitch(true);
        }
        this.isPaused = false;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        try {
            WebAppObject.Properties properties = this.webAppObject.properties;
            if (properties != null && properties.is_fullscreen) {
                toggleFullscreenSwitch(false);
                Window window = ((Activity) getContext()).getWindow();
                window.clearFlags(134217728);
                window.clearFlags(ConnectionsManager.FileTypeFile);
                toggleFullscreenSwitch(false);
                if (ApplicationLoader.applicationActivity != null) {
                    ApplicationLoader.applicationActivity.applyTheme();
                }
            }
        } catch (Exception unused) {
        }
        this.webView.destroy();
    }
}
