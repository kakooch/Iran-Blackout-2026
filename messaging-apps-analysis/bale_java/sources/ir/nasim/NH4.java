package ir.nasim;

import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/* loaded from: classes5.dex */
public final class NH4 implements InterfaceC22972w78 {
    public static final a b = new a(null);
    public static final int c = 8;
    private final Context a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public NH4(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(NH4 nh4, String str, WebResourceRequest webResourceRequest, OB2 ob2, String str2) throws IOException {
        AbstractC13042fc3.i(nh4, "this$0");
        AbstractC13042fc3.i(str, "$resourceUrl");
        AbstractC13042fc3.i(webResourceRequest, "$request");
        AbstractC13042fc3.i(ob2, "$stream");
        AbstractC13042fc3.i(str2, "$serverHash");
        File fileH = nh4.h(str);
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        AbstractC13042fc3.h(uRLConnectionOpenConnection, "openConnection(...)");
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        AbstractC13042fc3.h(requestHeaders, "getRequestHeaders(...)");
        for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
            uRLConnectionOpenConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        uRLConnectionOpenConnection.connect();
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        AbstractC13042fc3.h(inputStream, "getInputStream(...)");
        VZ2.b(inputStream, fileH);
        ob2.a(new FileInputStream(fileH));
        O78.a.j(str, str2);
        C19406qI3.a("WEBVIEW", "downloaded", new Object[0]);
    }

    @Override // ir.nasim.InterfaceC22972w78
    public WebResourceResponse a(WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null) {
            try {
                if (AbstractC13042fc3.d(webResourceRequest.getMethod(), "GET")) {
                    String string = webResourceRequest.getUrl().toString();
                    AbstractC13042fc3.h(string, "toString(...)");
                    O78 o78 = O78.a;
                    String strH = o78.h(string);
                    String strG = o78.g(string);
                    if (f(string) && AbstractC13042fc3.d(strH, strG) && !AbstractC13042fc3.d(strH, "")) {
                        return c(string);
                    }
                    if (i(string)) {
                        return d(string, strH, webResourceRequest);
                    }
                }
            } catch (Exception e) {
                C19406qI3.c("WEBVIEW", "failed to fetch from webview", e);
            }
        }
        return null;
    }

    public final WebResourceResponse c(String str) {
        AbstractC13042fc3.i(str, "resourceUrl");
        return new WebResourceResponse(g(str), "UTF-8", new FileInputStream(h(str)));
    }

    public final WebResourceResponse d(final String str, final String str2, final WebResourceRequest webResourceRequest) {
        AbstractC13042fc3.i(str, "resourceUrl");
        AbstractC13042fc3.i(str2, "serverHash");
        AbstractC13042fc3.i(webResourceRequest, "request");
        final OB2 ob2 = new OB2();
        try {
            C9248Zc6 c9248Zc6H = new C9248Zc6(new C5152Ic6(new Runnable() { // from class: ir.nasim.MH4
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    NH4.e(this.a, str, webResourceRequest, ob2, str2);
                }
            })).h(EnumC11723dV1.IO);
            AbstractC13042fc3.h(c9248Zc6H, "subscribeOn(...)");
            SZ.e(c9248Zc6H);
        } catch (IOException e) {
            C19406qI3.c("WEBVIEW", "error on download", e);
        }
        return new WebResourceResponse(g(str), "UTF-8", ob2);
    }

    public final boolean f(String str) {
        AbstractC13042fc3.i(str, "resourceUrl");
        if (str.length() > 127) {
            return false;
        }
        return h(str).exists();
    }

    public final String g(String str) {
        AbstractC13042fc3.i(str, "resourceUrl");
        String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(str);
        AbstractC13042fc3.h(strGuessContentTypeFromName, "guessContentTypeFromName(...)");
        return strGuessContentTypeFromName;
    }

    public final File h(String str) {
        AbstractC13042fc3.i(str, "resourceUrl");
        return new File(this.a.getFilesDir(), new C20644sM5("[^\\d\\w]+").k(AbstractC20153rZ6.M(AbstractC20153rZ6.M(str, "http://", "", false, 4, null), "https://", "", false, 4, null), "_"));
    }

    public final boolean i(String str) {
        AbstractC13042fc3.i(str, "resourceUrl");
        return !AbstractC13042fc3.d(O78.a.h(str), "");
    }
}
