package ir.resaneh1.iptv.fragment;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import ir.medu.shad.R;
import ir.resaneh1.iptv.dialog.PresenterDialog;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import ir.resaneh1.iptv.toolbar.ToolbarTextView;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class WebFragmentPayment extends PresenterDialog {
    Listener listener;
    String url;
    WebView webView;

    public interface Listener {
        void onCanceled();

        void onFailed();

        void onSuccess();
    }

    @Override // ir.resaneh1.iptv.dialog.PresenterDialog
    public int getLayoutId() {
        return R.layout.web_fragment;
    }

    public WebFragmentPayment(Activity activity, String str, Listener listener) {
        super(activity, android.R.style.Theme.Light.NoTitleBar);
        this.url = str;
        this.listener = listener;
        this.isMatchParent = true;
    }

    @Override // ir.resaneh1.iptv.dialog.PresenterDialog
    protected void findView() {
        super.findView();
        this.webView = (WebView) findViewById(R.id.webView);
    }

    @Override // ir.resaneh1.iptv.dialog.PresenterDialog
    protected void init() {
        super.init();
        this.progressBar.setVisibility(4);
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.toolbar.setBackgroundColor(ApplicationLoader.applicationActivity.getResources().getColor(R.color.grey_100));
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        toolbarImageView.createView(ApplicationLoader.applicationActivity, R.drawable.ic_close_grey);
        toolbarImageView.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.WebFragmentPayment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebFragmentPayment.this.listener.onCanceled();
                WebFragmentPayment.this.dismiss();
            }
        });
        ToolbarTextView toolbarTextView = new ToolbarTextView();
        toolbarTextView.createView(ApplicationLoader.applicationActivity, "پرداخت", R.color.grey_900);
        this.toolbarMaker.addViewToRightLayout(toolbarImageView.view);
        this.toolbarMaker.addViewToRightLayout(toolbarTextView.view);
        this.toolbarMaker.leftLayout.setLayoutTransition(new LayoutTransition());
        this.webView = (WebView) findViewById(R.id.webView);
        this.progressBar = findViewById(R.id.progressBar);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setDomStorageEnabled(false);
        this.webView.getSettings().setAllowContentAccess(false);
        this.webView.getSettings().setAllowFileAccess(false);
        this.webView.getSettings().setAllowFileAccessFromFileURLs(false);
        this.webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        this.webView.getSettings().setLoadWithOverviewMode(false);
        this.webView.getSettings().setUseWideViewPort(false);
        this.webView.getSettings().setDisplayZoomControls(false);
        this.webView.getSettings().setBuiltInZoomControls(false);
        this.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        this.webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        this.webView.setWebViewClient(new WebViewClient() { // from class: ir.resaneh1.iptv.fragment.WebFragmentPayment.2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                MyLog.e("RubikaLogPayment", "url" + str);
                if (str.contains("pissuccessrubika")) {
                    Listener listener = WebFragmentPayment.this.listener;
                    if (listener != null) {
                        listener.onSuccess();
                    }
                    WebFragmentPayment.this.dismiss();
                    return false;
                }
                if (str.contains("pnotsuccessrubika")) {
                    Listener listener2 = WebFragmentPayment.this.listener;
                    if (listener2 != null) {
                        listener2.onFailed();
                    }
                    WebFragmentPayment.this.dismiss();
                    return false;
                }
                if (!str.contains("crubikapayment")) {
                    return false;
                }
                WebFragmentPayment.this.dismiss();
                return false;
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                WebFragmentPayment.this.progressBar.setVisibility(0);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                WebFragmentPayment.this.progressBar.setVisibility(4);
            }
        });
        this.webView.loadUrl(this.url);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.resaneh1.iptv.fragment.WebFragmentPayment.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WebFragmentPayment.this.listener.onCanceled();
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }
}
