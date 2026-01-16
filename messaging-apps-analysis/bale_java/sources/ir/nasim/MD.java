package ir.nasim;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public final class MD extends C24380yX {
    private final Activity b;
    private final WeakReference c;
    private View d;
    private WebChromeClient.CustomViewCallback e;
    private int f;

    public MD(Activity activity, ND nd) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(nd, "delegate");
        this.b = activity;
        this.c = new WeakReference(nd);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        ND nd = (ND) this.c.get();
        if (nd != null) {
            nd.W3(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        if (Build.VERSION.SDK_INT < 30) {
            super.onHideCustomView();
            return;
        }
        if (this.d == null) {
            return;
        }
        View decorView = this.b.getWindow().getDecorView();
        AbstractC13042fc3.g(decorView, "null cannot be cast to non-null type android.widget.FrameLayout");
        ((FrameLayout) decorView).removeView(this.d);
        this.d = null;
        WindowInsetsController insetsController = this.b.getWindow().getInsetsController();
        if (insetsController != null) {
            insetsController.show(WindowInsets.Type.systemBars());
        }
        this.b.setRequestedOrientation(this.f);
        WebChromeClient.CustomViewCallback customViewCallback = this.e;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        this.e = null;
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        AbstractC13042fc3.i(permissionRequest, "request");
        ND nd = (ND) this.c.get();
        if (nd != null) {
            nd.b3(permissionRequest);
        }
    }

    @Override // ir.nasim.C24380yX, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        ND nd = (ND) this.c.get();
        if (nd != null) {
            nd.F4(i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (Build.VERSION.SDK_INT < 30) {
            super.onShowCustomView(view, customViewCallback);
            return;
        }
        if (this.d != null) {
            onHideCustomView();
            return;
        }
        this.d = view;
        this.e = customViewCallback;
        View decorView = this.b.getWindow().getDecorView();
        AbstractC13042fc3.g(decorView, "null cannot be cast to non-null type android.widget.FrameLayout");
        ((FrameLayout) decorView).addView(this.d, new FrameLayout.LayoutParams(-1, -1));
        this.f = this.b.getRequestedOrientation();
        WindowInsetsController insetsController = this.b.getWindow().getInsetsController();
        if (insetsController != null) {
            insetsController.hide(WindowInsets.Type.systemBars());
            insetsController.setSystemBarsBehavior(2);
        }
        this.b.setRequestedOrientation(0);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        ND nd;
        if (valueCallback == null || (nd = (ND) this.c.get()) == null) {
            return true;
        }
        nd.I2(valueCallback, fileChooserParams);
        return true;
    }
}
