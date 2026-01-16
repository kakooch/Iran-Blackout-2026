package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.PermissionRequest;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.toolbar.ToolbarMaker;
import ir.resaneh1.iptv.toolbar.ToolbarTextView;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class InlineWebviewFragment extends PresenterFragment {
    private boolean canAccessCamera;
    private boolean canAccessFile;
    private boolean canAccessMicro;
    private FrameLayout container;
    private String currentlyLoadingUrl;
    private final Link.InlineOpenUrlObject inlineOpenUrlObject;
    private boolean isErrorHappened;
    public boolean isFirstPage;
    private PermissionRequest lastRequest;
    private String mCameraPhotoPath;
    private ValueCallback<Uri[]> mFilePathCallback;
    WebView webView;
    private boolean withHandleAccess;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.web_fragment;
    }

    public InlineWebviewFragment(Link.InlineOpenUrlObject inlineOpenUrlObject, boolean z) {
        this.canAccessFile = false;
        this.canAccessCamera = false;
        this.withHandleAccess = false;
        this.canAccessMicro = false;
        this.swipeBackEnabled = false;
        this.inlineOpenUrlObject = inlineOpenUrlObject;
        this.withHandleAccess = z;
        if (z) {
            this.canAccessFile = inlineOpenUrlObject.allow_access_file;
            this.canAccessCamera = inlineOpenUrlObject.allow_access_camera;
            this.canAccessMicro = inlineOpenUrlObject.allow_access_microphone || MyLog.isDebugAble;
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.webView = (WebView) findViewById(R.id.webView);
        this.container = (FrameLayout) findViewById(R.id.webViewContainer);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        this.progressBar.setVisibility(4);
        if (this.isFirstPage) {
            this.toolbarMaker.setToolbarForHomeFragment(false, false);
            Link.InlineOpenUrlObject inlineOpenUrlObject = this.inlineOpenUrlObject;
            if (inlineOpenUrlObject != null && inlineOpenUrlObject.internal_back_enable) {
                View viewCreateView = this.toolbarMaker.toolbarImageView.createView((Activity) this.mContext, R.drawable.arrow_back_grey, Integer.valueOf(Theme.getColor(Theme.key_actionBarDefaultIcon)));
                viewCreateView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InlineWebviewFragment.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        InlineWebviewFragment.this.onBackPressed();
                    }
                });
                this.toolbarMaker.addViewToRightLayout(viewCreateView);
            }
        } else {
            Link.InlineOpenUrlObject inlineOpenUrlObject2 = this.inlineOpenUrlObject;
            String str = BuildConfig.FLAVOR;
            if (inlineOpenUrlObject2 != null && inlineOpenUrlObject2.internal_back_enable) {
                this.toolbarMaker.clearToolbar();
                View viewCreateView2 = this.toolbarMaker.toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_close_grey, Integer.valueOf(Theme.getColor(Theme.key_actionBarDefaultIcon)));
                ToolbarTextView toolbarTextView = this.toolbarMaker.toolbarTextView;
                Activity activity = (Activity) this.mContext;
                if (this.inlineOpenUrlObject.title != null) {
                    str = this.inlineOpenUrlObject.title + BuildConfig.FLAVOR;
                }
                View viewCreateView3 = toolbarTextView.createView(activity, str);
                this.toolbarMaker.toolbarTextView.textView.setTextColor(Theme.getColor(Theme.key_actionBarDefaultTitle));
                viewCreateView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InlineWebviewFragment.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        InlineWebviewFragment.this.finishFragment();
                    }
                });
                this.toolbarMaker.addViewToRightLayout(viewCreateView2);
                this.toolbarMaker.addViewToRightLayout(viewCreateView3);
                Toolbar toolbar = this.toolbarMaker.toolbar;
                if (toolbar != null) {
                    toolbar.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
                }
            } else {
                ToolbarMaker toolbarMaker = this.toolbarMaker;
                Activity activity2 = (Activity) this.mContext;
                if (inlineOpenUrlObject2 != null && inlineOpenUrlObject2.title != null) {
                    str = this.inlineOpenUrlObject.title + BuildConfig.FLAVOR;
                }
                toolbarMaker.setToolbarWithBackButtonAndTextGrey(activity2, str);
            }
        }
        this.webView = (WebView) findViewById(R.id.webView);
        this.progressBar = findViewById(R.id.progressBar);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.getSettings().setAllowContentAccess(false);
        this.webView.getSettings().setAllowFileAccess(this.canAccessFile);
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
        this.webView.setDownloadListener(new DownloadListener() { // from class: ir.resaneh1.iptv.fragment.InlineWebviewFragment.3
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                boolean z;
                if (InlineWebviewFragment.this.withHandleAccess && InlineWebviewFragment.this.inlineOpenUrlObject.allow_access_file) {
                    if (InlineWebviewFragment.this.inlineOpenUrlObject.download_allowed_hosts == null || InlineWebviewFragment.this.inlineOpenUrlObject.download_allowed_hosts.size() == 0) {
                        z = true;
                        break;
                    }
                    try {
                        Iterator<String> it = InlineWebviewFragment.this.inlineOpenUrlObject.download_allowed_hosts.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (!next.equals("*") && !str2.equals(next)) {
                                if (str2.startsWith(next)) {
                                    char cCharAt = str2.substring(next.length()).charAt(0);
                                    if (cCharAt < '0' || cCharAt > '9') {
                                        if (cCharAt < 'a' || cCharAt > 'z') {
                                            if (cCharAt < 'A' || cCharAt > 'Z') {
                                            }
                                        }
                                    }
                                }
                            }
                            z = true;
                        }
                    } catch (Exception unused) {
                    }
                    z = false;
                    if (z) {
                        try {
                            str4 = new String(Base64.decode(str4, 0));
                        } catch (Exception unused2) {
                        }
                        try {
                            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str2));
                            request.setDescription(str4);
                            request.setTitle(URLUtil.guessFileName(str2, str4, str5));
                            request.allowScanningByMediaScanner();
                            request.setNotificationVisibility(1);
                            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(str2, str4, str5));
                            ((DownloadManager) InlineWebviewFragment.this.getContext().getSystemService("download")).enqueue(request);
                        } catch (Exception unused3) {
                        }
                    }
                }
            }
        });
        this.webView.setWebViewClient(new WebViewClient() { // from class: ir.resaneh1.iptv.fragment.InlineWebviewFragment.4
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                return false;
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                super.onPageStarted(webView, str2, bitmap);
                InlineWebviewFragment.this.progressBar.setVisibility(0);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                super.onPageFinished(webView, str2);
                InlineWebviewFragment.this.progressBar.setVisibility(4);
                if (!InlineWebviewFragment.this.isErrorHappened) {
                    InlineWebviewFragment.this.webView.setVisibility(0);
                }
                InlineWebviewFragment.this.isErrorHappened = false;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str2, String str3) {
                super.onReceivedError(webView, i, str2, str3);
                try {
                    if (!str3.equals(InlineWebviewFragment.this.currentlyLoadingUrl)) {
                        if (!str3.equals(InlineWebviewFragment.this.currentlyLoadingUrl + "/")) {
                            return;
                        }
                    }
                    InlineWebviewFragment.this.handleError();
                } catch (Exception unused) {
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                try {
                    if (Build.VERSION.SDK_INT < 21 || !webResourceRequest.getUrl().toString().equals(InlineWebviewFragment.this.currentlyLoadingUrl) || webResourceResponse.getStatusCode() < 400 || webResourceResponse.getStatusCode() >= 600) {
                        return;
                    }
                    InlineWebviewFragment.this.handleError();
                } catch (Exception unused) {
                }
            }
        });
        this.webView.setWebChromeClient(new MyWebChromeClient());
        String str2 = this.inlineOpenUrlObject.url;
        this.currentlyLoadingUrl = str2;
        this.webView.loadUrl(str2);
    }

    public boolean hasPermission(String str) {
        return Build.VERSION.SDK_INT < 23 || ApplicationLoader.applicationActivity.checkSelfPermission(str) == 0;
    }

    public boolean requestCameraPermission() {
        if (hasPermission("android.permission.CAMERA")) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.CAMERA");
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        getParentActivity().requestPermissions(strArr, 11);
        return false;
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResultFragment(int r3, int r4, android.content.Intent r5) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto L44
            r0 = 1
            if (r3 != r0) goto L41
            android.webkit.ValueCallback<android.net.Uri[]> r1 = r2.mFilePathCallback
            if (r1 != 0) goto Le
            goto L41
        Le:
            r3 = -1
            r1 = 0
            if (r4 != r3) goto L38
            r3 = 0
            if (r5 == 0) goto L2b
            java.lang.String r4 = r5.getDataString()
            if (r4 != 0) goto L1c
            goto L2b
        L1c:
            java.lang.String r4 = r5.getDataString()
            if (r4 == 0) goto L38
            android.net.Uri[] r5 = new android.net.Uri[r0]
            android.net.Uri r4 = android.net.Uri.parse(r4)
            r5[r3] = r4
            goto L39
        L2b:
            java.lang.String r4 = r2.mCameraPhotoPath
            if (r4 == 0) goto L38
            android.net.Uri[] r5 = new android.net.Uri[r0]
            android.net.Uri r4 = android.net.Uri.parse(r4)
            r5[r3] = r4
            goto L39
        L38:
            r5 = r1
        L39:
            android.webkit.ValueCallback<android.net.Uri[]> r3 = r2.mFilePathCallback
            r3.onReceiveValue(r5)
            r2.mFilePathCallback = r1
            goto L44
        L41:
            super.onActivityResultFragment(r3, r4, r5)
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.InlineWebviewFragment.onActivityResultFragment(int, int, android.content.Intent):void");
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        if (this.withHandleAccess) {
            if (i == 11) {
                PermissionRequest permissionRequest = this.lastRequest;
                if (permissionRequest == null || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                permissionRequest.grant(permissionRequest.getResources());
                return;
            }
            super.onRequestPermissionsResultFragment(i, strArr, iArr);
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        WebView webView;
        Link.InlineOpenUrlObject inlineOpenUrlObject = this.inlineOpenUrlObject;
        if (inlineOpenUrlObject != null && inlineOpenUrlObject.internal_back_enable && (webView = this.webView) != null && webView.canGoBack()) {
            this.webView.goBack();
            return false;
        }
        return super.onBackPressed();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        this.webView.destroy();
    }

    private class MyWebChromeClient extends WebChromeClient {
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;

        private MyWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
            InlineWebviewFragment.this.container.addView(view, LayoutHelper.createFrame(-2, -2, 8388693));
            this.mCustomView = view;
            this.mCustomViewCallback = customViewCallback;
            InlineWebviewFragment.this.container.setVisibility(8);
            InlineWebviewFragment.this.container.setVisibility(0);
            InlineWebviewFragment.this.container.bringToFront();
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            super.onHideCustomView();
            View view = this.mCustomView;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
            InlineWebviewFragment.this.container.removeView(this.mCustomView);
            this.mCustomView = null;
            InlineWebviewFragment.this.container.setVisibility(8);
            this.mCustomViewCallback.onCustomViewHidden();
            InlineWebviewFragment.this.container.setVisibility(0);
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            int i;
            if (InlineWebviewFragment.this.withHandleAccess) {
                if ((InlineWebviewFragment.this.canAccessCamera || InlineWebviewFragment.this.canAccessMicro) && (i = Build.VERSION.SDK_INT) >= 21) {
                    if (i >= 23) {
                        String[] resources = permissionRequest.getResources();
                        ArrayList arrayList = new ArrayList();
                        if (resources.length > 0) {
                            for (String str : resources) {
                                if (str.equals("android.webkit.resource.VIDEO_CAPTURE") && InlineWebviewFragment.this.canAccessCamera) {
                                    if (ContextCompat.checkSelfPermission(InlineWebviewFragment.this.mContext, "android.permission.CAMERA") != 0) {
                                        arrayList.add("android.permission.CAMERA");
                                    }
                                } else if (str.equals("android.webkit.resource.AUDIO_CAPTURE") && ContextCompat.checkSelfPermission(InlineWebviewFragment.this.mContext, "android.permission.RECORD_AUDIO") != 0) {
                                    arrayList.add("android.permission.RECORD_AUDIO");
                                }
                            }
                            if (arrayList.size() > 0) {
                                InlineWebviewFragment.this.lastRequest = permissionRequest;
                                InlineWebviewFragment.this.getParentActivity().requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 11);
                                return;
                            }
                        }
                    }
                    permissionRequest.grant(permissionRequest.getResources());
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (InlineWebviewFragment.this.canAccessFile && InlineWebviewFragment.this.canAccessCamera) {
                return openFileChooserImplForAndroid5(valueCallback, fileChooserParams);
            }
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00fb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean openFileChooserImplForAndroid5(android.webkit.ValueCallback<android.net.Uri[]> r9, android.webkit.WebChromeClient.FileChooserParams r10) {
            /*
                Method dump skipped, instructions count: 275
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.InlineWebviewFragment.MyWebChromeClient.openFileChooserImplForAndroid5(android.webkit.ValueCallback, android.webkit.WebChromeClient$FileChooserParams):boolean");
        }
    }
}
