package ir.nasim;

import android.gov.nist.core.Separators;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

/* loaded from: classes8.dex */
public final class U68 extends C24974zX {
    public static final a d = new a(null);
    public static final int e = 8;
    private final WeakReference c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public U68(V68 v68) {
        AbstractC13042fc3.i(v68, "delegate");
        this.c = new WeakReference(v68);
    }

    @Override // ir.nasim.C24974zX, android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        V68 v68;
        CharSequence description;
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        String string = null;
        C19406qI3.a("WEBAPP_WEB_VIEW_CLIENT", "onReceivedError: " + (webResourceError != null ? Integer.valueOf(webResourceError.getErrorCode()) : null) + Separators.SP + ((Object) (webResourceError != null ? webResourceError.getDescription() : null)), new Object[0]);
        if ((webResourceRequest == null || webResourceRequest.isForMainFrame()) && (v68 = (V68) this.c.get()) != null) {
            if (webResourceError != null && (description = webResourceError.getDescription()) != null) {
                string = description.toString();
            }
            v68.w0(string);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        V68 v68;
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        C19406qI3.a("WEBAPP_WEB_VIEW_CLIENT", "onReceivedHttpError: statusCode=" + (webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null) + " request=" + (webResourceRequest != null ? webResourceRequest.getUrl() : null), new Object[0]);
        if ((webResourceRequest == null || webResourceRequest.isForMainFrame()) && webResourceResponse != null && TextUtils.isEmpty(webResourceResponse.getMimeType()) && (v68 = (V68) this.c.get()) != null) {
            v68.w0(webResourceResponse.getReasonPhrase());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        C19406qI3.a("WEBAPP_WEB_VIEW_CLIENT", "onReceivedSslError: error=" + sslError + " url=" + (sslError != null ? sslError.getUrl() : null), new Object[0]);
        if (sslErrorHandler != null) {
            sslErrorHandler.cancel();
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }
}
