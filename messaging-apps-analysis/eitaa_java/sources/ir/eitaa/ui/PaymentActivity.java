package ir.eitaa.ui;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MrzRecognizer;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.NativeByteBuffer;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$TL_GetPayHash;
import ir.eitaa.tgnet.TLRPC$TL_UserPayHash;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.CameraScanActivity;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RadialProgressView;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class PaymentActivity extends BaseFragment {
    public static Object uploadMessage;
    private Delegate delegate;
    private ActionBarMenuItem exitFromPreviewMode;
    private String hash;
    private String link;
    private int msg_id;
    private TLRPC$Peer peer;
    private RadialProgressView progressBar;
    private boolean showControls;
    private boolean triedAgain;
    private WebView webView;

    public interface Delegate {
        void onLinkCreated(String link);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        return true;
    }

    public PaymentActivity(Bundle args) {
        super(args);
        this.msg_id = 0;
        this.peer = null;
        this.showControls = true;
        this.triedAgain = false;
        this.link = args.getString("link", null);
        this.hash = args.getString("hash", "");
        this.msg_id = args.getInt("msg_id", 0);
        byte[] byteArray = args.getByteArray("peer");
        if (byteArray != null) {
            try {
                NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(byteArray.length);
                nativeByteBuffer.writeBytes(byteArray);
                nativeByteBuffer.position(0);
                this.peer = TLRPC$Peer.TLdeserialize(nativeByteBuffer, nativeByteBuffer.readInt32(false), false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        if (this.showControls) {
            this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        }
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setTitle(LocaleController.getString("EitaaServices", R.string.EitaaServices));
        this.actionBar.setAddToContainer(false);
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        if (this.inPreviewMode) {
            this.exitFromPreviewMode = actionBarMenuCreateMenu.addItem(2, R.drawable.ic_gofullscreen);
            this.actionBar.setBackButtonDrawable(null);
        }
        if (this.showControls) {
            actionBarMenuCreateMenu.addItem(1, R.drawable.ic_close_white).setContentDescription(LocaleController.getString("Exit", R.string.Exit));
        }
        actionBarMenuCreateMenu.addItem(3, R.drawable.ic_barcode).setContentDescription(LocaleController.getString("BarcodeScanner", R.string.BarcodeScanner));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.PaymentActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    if (PaymentActivity.this.webView != null) {
                        PaymentActivity.this.webView.loadUrl("javascript:onBackPressed()");
                        return;
                    }
                    return;
                }
                if (id == 1) {
                    PaymentActivity.this.finishFragment();
                    return;
                }
                if (id == 2) {
                    PaymentActivity.this.movePreviewFragment(AndroidUtilities.dp(61.0f));
                    return;
                }
                if (id == 3) {
                    if (Build.VERSION.SDK_INT >= 23 && PaymentActivity.this.getParentActivity().checkSelfPermission("android.permission.CAMERA") != 0) {
                        PaymentActivity.this.getParentActivity().requestPermissions(new String[]{"android.permission.CAMERA"}, 22);
                        return;
                    }
                    CameraScanActivity cameraScanActivity = new CameraScanActivity(1);
                    cameraScanActivity.isEitaaPay = true;
                    cameraScanActivity.setDelegate(new CameraScanActivity.CameraScanActivityDelegate() { // from class: ir.eitaa.ui.PaymentActivity.1.1
                        @Override // ir.eitaa.ui.CameraScanActivity.CameraScanActivityDelegate
                        public /* synthetic */ void didFindMrzInfo(MrzRecognizer.Result result) {
                            CameraScanActivity.CameraScanActivityDelegate.CC.$default$didFindMrzInfo(this, result);
                        }

                        @Override // ir.eitaa.ui.CameraScanActivity.CameraScanActivityDelegate
                        public void didFindQr(String text) {
                            Browser.openUrl(PaymentActivity.this.getParentActivity(), text);
                        }
                    });
                    PaymentActivity.this.presentFragment(cameraScanActivity);
                }
            }
        });
        this.fragmentView = buildView(context);
        if (MessagesController.getInstance(this.currentAccount).payEnabled) {
            startLoading();
        }
        return this.fragmentView;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void setInPreviewMode(boolean value) {
        super.setInPreviewMode(value);
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            if (value) {
                actionBar.setBackButtonDrawable(null);
            } else {
                actionBar.setBackButtonImage(R.drawable.ic_ab_back);
            }
        }
        ActionBarMenuItem actionBarMenuItem = this.exitFromPreviewMode;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.setVisibility(value ? 0 : 8);
        }
    }

    private View buildView(Context context) {
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.PaymentActivity.2
            /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x009e  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00b2  */
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
                /*
                    r9 = this;
                    int r10 = r9.getChildCount()
                    r0 = 0
                L5:
                    if (r0 >= r10) goto Lcf
                    android.view.View r1 = r9.getChildAt(r0)
                    int r2 = r1.getVisibility()
                    r3 = 8
                    if (r2 != r3) goto L15
                    goto Lcb
                L15:
                    android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
                    android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
                    int r3 = r1.getMeasuredWidth()
                    int r4 = r1.getMeasuredHeight()
                    int r5 = r2.gravity
                    r6 = -1
                    if (r5 != r6) goto L2a
                    r5 = 51
                L2a:
                    r6 = r5 & 7
                    r5 = r5 & 112(0x70, float:1.57E-43)
                    r6 = r6 & 7
                    r7 = 1
                    if (r6 == r7) goto L3e
                    r7 = 5
                    if (r6 == r7) goto L39
                    int r6 = r2.leftMargin
                    goto L49
                L39:
                    int r6 = r13 - r3
                    int r7 = r2.rightMargin
                    goto L48
                L3e:
                    int r6 = r13 - r11
                    int r6 = r6 - r3
                    int r6 = r6 / 2
                    int r7 = r2.leftMargin
                    int r6 = r6 + r7
                    int r7 = r2.rightMargin
                L48:
                    int r6 = r6 - r7
                L49:
                    r7 = 16
                    r8 = 21
                    if (r5 == r7) goto L9e
                    r7 = 48
                    if (r5 == r7) goto L60
                    r7 = 80
                    if (r5 == r7) goto L5a
                    int r2 = r2.topMargin
                    goto Laa
                L5a:
                    int r5 = r14 - r12
                    int r5 = r5 - r4
                    int r2 = r2.bottomMargin
                    goto La8
                L60:
                    int r2 = r2.topMargin
                    int r5 = r9.getPaddingTop()
                    int r2 = r2 + r5
                    ir.eitaa.ui.PaymentActivity r5 = ir.eitaa.ui.PaymentActivity.this
                    ir.eitaa.ui.ActionBar.ActionBar r5 = ir.eitaa.ui.PaymentActivity.access$100(r5)
                    if (r1 == r5) goto L86
                    ir.eitaa.ui.PaymentActivity r5 = ir.eitaa.ui.PaymentActivity.this
                    ir.eitaa.ui.ActionBar.ActionBar r5 = ir.eitaa.ui.PaymentActivity.access$200(r5)
                    int r5 = r5.getVisibility()
                    if (r5 != 0) goto L86
                    ir.eitaa.ui.PaymentActivity r5 = ir.eitaa.ui.PaymentActivity.this
                    ir.eitaa.ui.ActionBar.ActionBar r5 = ir.eitaa.ui.PaymentActivity.access$300(r5)
                    int r5 = r5.getMeasuredHeight()
                    int r2 = r2 + r5
                L86:
                    ir.eitaa.ui.PaymentActivity r5 = ir.eitaa.ui.PaymentActivity.this
                    ir.eitaa.ui.ActionBar.ActionBar r5 = ir.eitaa.ui.PaymentActivity.access$400(r5)
                    if (r1 == r5) goto Laa
                    ir.eitaa.ui.PaymentActivity r5 = ir.eitaa.ui.PaymentActivity.this
                    boolean r5 = ir.eitaa.ui.PaymentActivity.access$500(r5)
                    if (r5 == 0) goto Laa
                    int r5 = android.os.Build.VERSION.SDK_INT
                    if (r5 < r8) goto Laa
                    int r5 = ir.eitaa.messenger.AndroidUtilities.statusBarHeight
                    int r2 = r2 + r5
                    goto Laa
                L9e:
                    int r5 = r14 - r12
                    int r5 = r5 - r4
                    int r5 = r5 / 2
                    int r7 = r2.topMargin
                    int r5 = r5 + r7
                    int r2 = r2.bottomMargin
                La8:
                    int r2 = r5 - r2
                Laa:
                    ir.eitaa.ui.PaymentActivity r5 = ir.eitaa.ui.PaymentActivity.this
                    ir.eitaa.ui.ActionBar.ActionBar r5 = ir.eitaa.ui.PaymentActivity.access$600(r5)
                    if (r1 != r5) goto Lc6
                    ir.eitaa.ui.PaymentActivity r5 = ir.eitaa.ui.PaymentActivity.this
                    boolean r5 = ir.eitaa.ui.PaymentActivity.access$700(r5)
                    if (r5 == 0) goto Lc1
                    int r5 = android.os.Build.VERSION.SDK_INT
                    if (r5 < r8) goto Lc1
                    int r5 = ir.eitaa.messenger.AndroidUtilities.statusBarHeight
                    int r2 = r2 + r5
                Lc1:
                    int r5 = r9.getPaddingTop()
                    int r2 = r2 - r5
                Lc6:
                    int r3 = r3 + r6
                    int r4 = r4 + r2
                    r1.layout(r6, r2, r3, r4)
                Lcb:
                    int r0 = r0 + 1
                    goto L5
                Lcf:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PaymentActivity.AnonymousClass2.onLayout(boolean, int, int, int, int):void");
            }
        };
        WebView webView = new WebView(context);
        this.webView = webView;
        webView.setWebViewClient(new WebViewClient() { // from class: ir.eitaa.ui.PaymentActivity.3
            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                PaymentActivity.this.progressBar.setVisibility(4);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                PaymentActivity.this.stopLoading();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                PaymentActivity.this.stopLoading();
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView view, String address) {
                Uri uri;
                try {
                    uri = Uri.parse(new URL(address).toURI().toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    uri = null;
                    return shouldInterceptRequest(uri);
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                    uri = null;
                    return shouldInterceptRequest(uri);
                }
                return shouldInterceptRequest(uri);
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return shouldInterceptRequest(request.getUrl());
            }

            private Map<String, String> splitQuery(String query) throws UnsupportedEncodingException {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (String str : query.split("&")) {
                    int iIndexOf = str.indexOf("=");
                    linkedHashMap.put(URLDecoder.decode(str.substring(0, iIndexOf), "UTF-8"), URLDecoder.decode(str.substring(iIndexOf + 1), "UTF-8"));
                }
                return linkedHashMap;
            }

            private WebResourceResponse shouldInterceptRequest(Uri uri) {
                Map<String, String> map = new HashMap<>();
                try {
                    map = splitQuery(uri.getQuery());
                } catch (Exception unused) {
                }
                if (uri != null && uri.getHost() != null && !uri.getHost().equals(MessagesController.getInstance(((BaseFragment) PaymentActivity.this).currentAccount).payHost)) {
                    return new WebResourceResponse("text/plain", "utf-8", new ByteArrayInputStream("MN: Access Denied".getBytes()));
                }
                if (map.containsKey("constructor") && "200".equals(map.get("constructor"))) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.PaymentActivity.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PaymentActivity.this.finishFragment(true);
                        }
                    });
                    return null;
                }
                if (!map.containsKey("createdLink")) {
                    return null;
                }
                final String str = map.get("createdLink");
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.PaymentActivity.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PaymentActivity.this.delegate != null) {
                            PaymentActivity.this.delegate.onLinkCreated(str);
                        }
                        PaymentActivity.this.finishFragment(false);
                    }
                });
                return null;
            }
        });
        this.webView.setWebChromeClient(new WebChromeClient() { // from class: ir.eitaa.ui.PaymentActivity.4
            int FILECHOOSER_RESULTCODE = 137217;

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                Object obj = PaymentActivity.uploadMessage;
                if (obj != null) {
                    ((ValueCallback) obj).onReceiveValue(null);
                    PaymentActivity.uploadMessage = null;
                }
                PaymentActivity.uploadMessage = filePathCallback;
                try {
                    PaymentActivity.this.startActivityForResult(fileChooserParams.createIntent(), this.FILECHOOSER_RESULTCODE);
                    return true;
                } catch (ActivityNotFoundException unused) {
                    PaymentActivity.uploadMessage = null;
                    Toast.makeText(PaymentActivity.this.getParentActivity().getApplicationContext(), "Cannot Open File Chooser", 1).show();
                    return false;
                }
            }
        });
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setDomStorageEnabled(true);
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (i >= 21) {
            settings.setMixedContentMode(0);
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.webView, true);
        }
        this.webView.addJavascriptInterface(new WebAppInterface(), "Android");
        frameLayout.addView(this.webView, LayoutHelper.createFrame(-1, -1, 48));
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.progressBar = radialProgressView;
        radialProgressView.setVisibility(4);
        frameLayout.addView(this.progressBar, LayoutHelper.createFrame(-2, -2, 17));
        frameLayout.addView(this.actionBar);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoading() {
        this.progressBar.setVisibility(0);
        if (!TextUtils.isEmpty(this.hash) && !TextUtils.isEmpty(this.link)) {
            try {
                this.webView.postUrl(this.link, ("hash=" + URLEncoder.encode(this.hash, "UTF-8")).getBytes());
                return;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return;
            }
        }
        TLRPC$TL_GetPayHash tLRPC$TL_GetPayHash = new TLRPC$TL_GetPayHash();
        TLRPC$Peer tLRPC$TL_peerUser = this.peer;
        if (tLRPC$TL_peerUser == null) {
            tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        }
        tLRPC$TL_GetPayHash.peer = tLRPC$TL_peerUser;
        tLRPC$TL_GetPayHash.msg_id = this.msg_id;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_GetPayHash, new RequestDelegate() { // from class: ir.eitaa.ui.PaymentActivity.5
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(final TLObject response, final TLRPC$TL_error error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.PaymentActivity.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        String str2;
                        if (error != null) {
                            if (PaymentActivity.this.triedAgain) {
                                PaymentActivity.this.stopLoading();
                                String str3 = "hash=404&user_id=" + UserConfig.getInstance(((BaseFragment) PaymentActivity.this).currentAccount).clientUserId;
                                if (TextUtils.isEmpty(PaymentActivity.this.link)) {
                                    str2 = "https://" + MessagesController.getInstance(((BaseFragment) PaymentActivity.this).currentAccount).payHost;
                                } else {
                                    str2 = PaymentActivity.this.link;
                                }
                                PaymentActivity.this.webView.postUrl(str2, str3.getBytes());
                                return;
                            }
                            PaymentActivity.this.triedAgain = true;
                            PaymentActivity.this.startLoading();
                            return;
                        }
                        try {
                            String str4 = "hash=" + URLEncoder.encode(((TLRPC$TL_UserPayHash) response).hash, "UTF-8");
                            if (TextUtils.isEmpty(PaymentActivity.this.link)) {
                                str = "https://" + MessagesController.getInstance(((BaseFragment) PaymentActivity.this).currentAccount).payHost;
                            } else {
                                str = PaymentActivity.this.link;
                            }
                            PaymentActivity.this.webView.postUrl(str, str4.getBytes());
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                            PaymentActivity.this.stopLoading();
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLoading() {
        this.progressBar.setVisibility(4);
        this.webView.stopLoading();
        this.webView.loadUrl("about:blank");
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        this.webView.requestFocus();
        if (MessagesController.getInstance(this.currentAccount).payEnabled) {
            return;
        }
        finishFragment();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
        LocaleController.getInstance().applyLanguage(LocaleController.getInstance().getCurrentLocaleInfo(), true, false, false, true, this.currentAccount);
        super.onPause();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        stopLoading();
        super.onFragmentDestroy();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        this.webView.loadUrl("javascript:onBackPressed()");
        return false;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void clearViews() {
        super.clearViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    class WebAppInterface {
        private WebAppInterface() {
        }

        @JavascriptInterface
        public void openUrl(final String url, final boolean internalBrowser) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentActivity$WebAppInterface$PWbvrvH4-gUXd56CPm6yTQoCdFw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$openUrl$0$PaymentActivity$WebAppInterface(url, internalBrowser);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$openUrl$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$openUrl$0$PaymentActivity$WebAppInterface(String str, boolean z) {
            Browser.openUrl(PaymentActivity.this.getParentActivity(), Uri.parse(str), z, false, true);
        }

        @JavascriptInterface
        public void close() {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentActivity$WebAppInterface$bGK-vew3zTjrHmVbNGMeM0ZEqWo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$close$1$PaymentActivity$WebAppInterface();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$close$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$close$1$PaymentActivity$WebAppInterface() {
            PaymentActivity.this.finishFragment();
        }
    }
}
