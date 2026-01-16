package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.SerializedData;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messages_getStatsURL;
import ir.eitaa.tgnet.TLRPC$TL_statsURL;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.ContextProgressView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.ShareAlert;
import java.net.URLEncoder;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class WebviewActivity extends BaseFragment {
    private String currentBot;
    private long currentDialogId;
    private String currentGame;
    private MessageObject currentMessageObject;
    private String currentUrl;
    private String linkToCopy;
    private boolean loadStats;
    private ActionBarMenuItem progressItem;
    private ContextProgressView progressView;
    private String short_param;
    private int type;
    public Runnable typingRunnable = new Runnable() { // from class: ir.eitaa.ui.WebviewActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (WebviewActivity.this.currentMessageObject == null || WebviewActivity.this.getParentActivity() == null) {
                return;
            }
            WebviewActivity webviewActivity = WebviewActivity.this;
            if (webviewActivity.typingRunnable == null) {
                return;
            }
            MessagesController.getInstance(((BaseFragment) webviewActivity).currentAccount).sendTyping(WebviewActivity.this.currentMessageObject.getDialogId(), 0, 6, 0);
            AndroidUtilities.runOnUIThread(WebviewActivity.this.typingRunnable, 25000L);
        }
    };
    private WebView webView;

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent event) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class EitaaWebviewProxy {
        private EitaaWebviewProxy() {
        }

        @JavascriptInterface
        public void postEvent(final String eventName, final String eventData) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$WebviewActivity$EitaaWebviewProxy$6U5-_UAyrcWStLYLB-zcQAj4SD4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$postEvent$0$WebviewActivity$EitaaWebviewProxy(eventName);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$postEvent$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$postEvent$0$WebviewActivity$EitaaWebviewProxy(String str) {
            if (WebviewActivity.this.getParentActivity() == null) {
                return;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d(str);
            }
            str.hashCode();
            if (str.equals("share_game")) {
                WebviewActivity.this.currentMessageObject.messageOwner.with_my_score = false;
            } else if (str.equals("share_score")) {
                WebviewActivity.this.currentMessageObject.messageOwner.with_my_score = true;
            }
            WebviewActivity webviewActivity = WebviewActivity.this;
            webviewActivity.showDialog(ShareAlert.createShareAlert(webviewActivity.getParentActivity(), WebviewActivity.this.currentMessageObject, null, false, WebviewActivity.this.linkToCopy, false));
        }
    }

    public WebviewActivity(String url, String botName, String gameName, String startParam, MessageObject messageObject) {
        String str;
        this.currentUrl = url;
        this.currentBot = botName;
        this.currentGame = gameName;
        this.currentMessageObject = messageObject;
        this.short_param = startParam;
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(MessagesController.getInstance(this.currentAccount).linkPrefix);
        sb.append("/");
        sb.append(this.currentBot);
        if (TextUtils.isEmpty(startParam)) {
            str = "";
        } else {
            str = "?game=" + startParam;
        }
        sb.append(str);
        this.linkToCopy = sb.toString();
        this.type = 0;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        AndroidUtilities.cancelRunOnUIThread(this.typingRunnable);
        this.webView.setLayerType(0, null);
        this.typingRunnable = null;
        try {
            ViewParent parent = this.webView.getParent();
            if (parent != null) {
                ((FrameLayout) parent).removeView(this.webView);
            }
            this.webView.stopLoading();
            this.webView.loadUrl("about:blank");
            this.webView.destroy();
            this.webView = null;
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.WebviewActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    WebviewActivity.this.finishFragment();
                    return;
                }
                if (id != 1) {
                    if (id == 2) {
                        WebviewActivity.openGameInBrowser(WebviewActivity.this.currentUrl, WebviewActivity.this.currentMessageObject, WebviewActivity.this.getParentActivity(), WebviewActivity.this.short_param, WebviewActivity.this.currentBot);
                    }
                } else if (WebviewActivity.this.currentMessageObject != null) {
                    WebviewActivity.this.currentMessageObject.messageOwner.with_my_score = false;
                    WebviewActivity webviewActivity = WebviewActivity.this;
                    webviewActivity.showDialog(ShareAlert.createShareAlert(webviewActivity.getParentActivity(), WebviewActivity.this.currentMessageObject, null, false, WebviewActivity.this.linkToCopy, false));
                }
            }
        });
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        this.progressItem = actionBarMenuCreateMenu.addItemWithWidth(1, R.drawable.share, AndroidUtilities.dp(54.0f));
        int i = this.type;
        if (i == 0) {
            actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_other).addSubItem(2, R.drawable.msg_openin, LocaleController.getString("OpenInExternalApp", R.string.OpenInExternalApp));
            this.actionBar.setTitle(this.currentGame);
            this.actionBar.setSubtitle("@" + this.currentBot);
            ContextProgressView contextProgressView = new ContextProgressView(context, 1);
            this.progressView = contextProgressView;
            this.progressItem.addView(contextProgressView, LayoutHelper.createFrame(-1, -1.0f));
            this.progressView.setAlpha(0.0f);
            this.progressView.setScaleX(0.1f);
            this.progressView.setScaleY(0.1f);
            this.progressView.setVisibility(4);
        } else if (i == 1) {
            this.actionBar.setBackgroundColor(Theme.getColor("player_actionBar"));
            this.actionBar.setItemsColor(Theme.getColor("player_actionBarItems"), false);
            this.actionBar.setItemsBackgroundColor(Theme.getColor("player_actionBarSelector"), false);
            this.actionBar.setTitleColor(Theme.getColor("player_actionBarTitle"));
            this.actionBar.setSubtitleColor(Theme.getColor("player_actionBarSubtitle"));
            this.actionBar.setTitle(LocaleController.getString("Statistics", R.string.Statistics));
            ContextProgressView contextProgressView2 = new ContextProgressView(context, 3);
            this.progressView = contextProgressView2;
            this.progressItem.addView(contextProgressView2, LayoutHelper.createFrame(-1, -1.0f));
            this.progressView.setAlpha(1.0f);
            this.progressView.setScaleX(1.0f);
            this.progressView.setScaleY(1.0f);
            this.progressView.setVisibility(0);
            this.progressItem.getContentView().setVisibility(8);
            this.progressItem.setEnabled(false);
        }
        WebView webView = new WebView(context);
        this.webView = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            this.webView.setLayerType(2, null);
        }
        if (i2 >= 21) {
            this.webView.getSettings().setMixedContentMode(0);
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.webView, true);
            if (this.type == 0) {
                this.webView.addJavascriptInterface(new EitaaWebviewProxy(), "EitaaWebviewProxy");
            }
        }
        this.webView.setWebViewClient(new WebViewClient() { // from class: ir.eitaa.ui.WebviewActivity.3
            private boolean isInternalUrl(String url) {
                if (TextUtils.isEmpty(url)) {
                    return false;
                }
                Uri uri = Uri.parse(url);
                if (!"et".equals(uri.getScheme())) {
                    return false;
                }
                if (WebviewActivity.this.type == 1) {
                    try {
                        WebviewActivity.this.reloadStats(Uri.parse(url.replace("et:statsrefresh", "et://eitaa.org")).getQueryParameter("params"));
                    } catch (Throwable th) {
                        FileLog.e(th);
                    }
                } else {
                    WebviewActivity.this.finishFragment(false);
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", uri);
                        intent.setComponent(new ComponentName(ApplicationLoader.applicationContext.getPackageName(), LaunchActivity.class.getName()));
                        intent.putExtra("com.android.browser.application_id", ApplicationLoader.applicationContext.getPackageName());
                        ApplicationLoader.applicationContext.startActivity(intent);
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url) {
                if (isInternalUrl(url)) {
                    return;
                }
                super.onLoadResource(view, url);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return isInternalUrl(url) || super.shouldOverrideUrlLoading(view, url);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (WebviewActivity.this.progressView == null || WebviewActivity.this.progressView.getVisibility() != 0) {
                    return;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                if (WebviewActivity.this.type == 0) {
                    WebviewActivity.this.progressItem.getContentView().setVisibility(0);
                    WebviewActivity.this.progressItem.setEnabled(true);
                    animatorSet.playTogether(ObjectAnimator.ofFloat(WebviewActivity.this.progressView, "scaleX", 1.0f, 0.1f), ObjectAnimator.ofFloat(WebviewActivity.this.progressView, "scaleY", 1.0f, 0.1f), ObjectAnimator.ofFloat(WebviewActivity.this.progressView, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(WebviewActivity.this.progressItem.getContentView(), "scaleX", 0.0f, 1.0f), ObjectAnimator.ofFloat(WebviewActivity.this.progressItem.getContentView(), "scaleY", 0.0f, 1.0f), ObjectAnimator.ofFloat(WebviewActivity.this.progressItem.getContentView(), "alpha", 0.0f, 1.0f));
                } else {
                    animatorSet.playTogether(ObjectAnimator.ofFloat(WebviewActivity.this.progressView, "scaleX", 1.0f, 0.1f), ObjectAnimator.ofFloat(WebviewActivity.this.progressView, "scaleY", 1.0f, 0.1f), ObjectAnimator.ofFloat(WebviewActivity.this.progressView, "alpha", 1.0f, 0.0f));
                }
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.WebviewActivity.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (WebviewActivity.this.type == 1) {
                            WebviewActivity.this.progressItem.setVisibility(8);
                        } else {
                            WebviewActivity.this.progressView.setVisibility(4);
                        }
                    }
                });
                animatorSet.setDuration(150L);
                animatorSet.start();
            }
        });
        frameLayout2.addView(this.webView, LayoutHelper.createFrame(-1, -1.0f));
        return this.fragmentView;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.cancelRunOnUIThread(this.typingRunnable);
        this.typingRunnable.run();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        WebView webView;
        if (!isOpen || backward || (webView = this.webView) == null) {
            return;
        }
        webView.loadUrl(this.currentUrl);
    }

    public static boolean supportWebview() {
        return ("samsung".equals(Build.MANUFACTURER) && "GT-I9500".equals(Build.MODEL)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reloadStats(String params) {
        if (this.loadStats) {
            return;
        }
        this.loadStats = true;
        TLRPC$TL_messages_getStatsURL tLRPC$TL_messages_getStatsURL = new TLRPC$TL_messages_getStatsURL();
        tLRPC$TL_messages_getStatsURL.peer = MessagesController.getInstance(this.currentAccount).getInputPeer(this.currentDialogId);
        if (params == null) {
            params = "";
        }
        tLRPC$TL_messages_getStatsURL.params = params;
        tLRPC$TL_messages_getStatsURL.dark = Theme.getCurrentTheme().isDark();
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_getStatsURL, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$WebviewActivity$U4LDgnnjs0C7G4j4dCnV3JZlZWY
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$reloadStats$1$WebviewActivity(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reloadStats$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$reloadStats$1$WebviewActivity(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$WebviewActivity$jV7MSctKaSzBj9gxfovcu4O2uCc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$reloadStats$0$WebviewActivity(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$reloadStats$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$reloadStats$0$WebviewActivity(TLObject tLObject) {
        this.loadStats = false;
        if (tLObject != null) {
            WebView webView = this.webView;
            String str = ((TLRPC$TL_statsURL) tLObject).url;
            this.currentUrl = str;
            webView.loadUrl(str);
        }
    }

    public static void openGameInBrowser(String urlStr, MessageObject messageObject, Activity parentActivity, String short_name, String username) {
        String str;
        String str2 = "";
        try {
            SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("botshare", 0);
            String string = sharedPreferences.getString("" + messageObject.getId(), null);
            StringBuilder sb = new StringBuilder(string != null ? string : "");
            StringBuilder sb2 = new StringBuilder("tgShareScoreUrl=" + URLEncoder.encode("tgb://share_game_score?hash=", "UTF-8"));
            if (string == null) {
                char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
                for (int i = 0; i < 20; i++) {
                    sb.append(charArray[Utilities.random.nextInt(charArray.length)]);
                }
            }
            sb2.append((CharSequence) sb);
            int iIndexOf = urlStr.indexOf(35);
            if (iIndexOf < 0) {
                str = urlStr + "#" + ((Object) sb2);
            } else {
                String strSubstring = urlStr.substring(iIndexOf + 1);
                if (strSubstring.indexOf(61) >= 0 || strSubstring.indexOf(63) >= 0) {
                    str = urlStr + "&" + ((Object) sb2);
                } else if (strSubstring.length() > 0) {
                    str = urlStr + "?" + ((Object) sb2);
                } else {
                    str = urlStr + ((Object) sb2);
                }
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt(((Object) sb) + "_date", (int) (System.currentTimeMillis() / 1000));
            SerializedData serializedData = new SerializedData(messageObject.messageOwner.getObjectSize());
            messageObject.messageOwner.serializeToStream(serializedData);
            editorEdit.putString(((Object) sb) + "_m", Utilities.bytesToHex(serializedData.toByteArray()));
            String str3 = ((Object) sb) + "_link";
            StringBuilder sb3 = new StringBuilder();
            sb3.append("https://");
            sb3.append(MessagesController.getInstance(messageObject.currentAccount).linkPrefix);
            sb3.append("/");
            sb3.append(username);
            if (!TextUtils.isEmpty(short_name)) {
                str2 = "?game=" + short_name;
            }
            sb3.append(str2);
            editorEdit.putString(str3, sb3.toString());
            editorEdit.commit();
            Browser.openUrl((Context) parentActivity, str, false);
            serializedData.cleanup();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        if (this.type == 0) {
            arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, "actionBarDefaultSubmenuBackground"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, "actionBarDefaultSubmenuItem"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM | ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "actionBarDefaultSubmenuItemIcon"));
            arrayList.add(new ThemeDescription(this.progressView, 0, null, null, null, null, "contextProgressInner2"));
            arrayList.add(new ThemeDescription(this.progressView, 0, null, null, null, null, "contextProgressOuter2"));
        } else {
            arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "player_actionBar"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "player_actionBarItems"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "player_actionBarTitle"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBTITLECOLOR, null, null, null, null, "player_actionBarTitle"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "player_actionBarSelector"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, "actionBarDefaultSubmenuBackground"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, "actionBarDefaultSubmenuItem"));
            arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, "actionBarDefaultSubmenuItemIcon"));
            arrayList.add(new ThemeDescription(this.progressView, 0, null, null, null, null, "contextProgressInner4"));
            arrayList.add(new ThemeDescription(this.progressView, 0, null, null, null, null, "contextProgressOuter4"));
        }
        return arrayList;
    }
}
