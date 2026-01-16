package ir.nasim;

import android.content.Context;
import android.gov.nist.javax.sip.clientauthutils.DigestServerAuthenticationHelper;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
public final class P76 implements InterfaceC22972w78 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final Context a;
    private final String b;
    private final MessageDigest c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public P76(Context context, String str) throws NoSuchAlgorithmException {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "host");
        this.a = context;
        this.b = str;
        MessageDigest messageDigest = MessageDigest.getInstance(DigestServerAuthenticationHelper.DEFAULT_ALGORITHM);
        AbstractC13042fc3.h(messageDigest, "getInstance(...)");
        this.c = messageDigest;
    }

    private final WebResourceResponse c(final String str, final String str2, final WebResourceRequest webResourceRequest) {
        final OB2 ob2 = new OB2();
        try {
            C9248Zc6 c9248Zc6H = new C9248Zc6(new C5152Ic6(new Runnable() { // from class: ir.nasim.O76
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    P76.d(this.a, str, webResourceRequest, ob2, str2);
                }
            })).h(EnumC11723dV1.IO);
            AbstractC13042fc3.h(c9248Zc6H, "subscribeOn(...)");
            SZ.e(c9248Zc6H);
            String strF = f(str);
            if (strF != null) {
                return new WebResourceResponse(strF, "UTF-8", ob2);
            }
            C19406qI3.b("SPACacheHandler", "mimeType for " + str + " is null in cacheResponse");
            return null;
        } catch (IOException e2) {
            C19406qI3.c("SPACacheHandler", "error on download " + str, e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(P76 p76, String str, WebResourceRequest webResourceRequest, OB2 ob2, String str2) throws IOException {
        AbstractC13042fc3.i(p76, "this$0");
        AbstractC13042fc3.i(str, "$resourceURL");
        AbstractC13042fc3.i(webResourceRequest, "$request");
        AbstractC13042fc3.i(ob2, "$stream");
        AbstractC13042fc3.i(str2, "$resourceHashOnServer");
        File fileH = p76.h(p76.i(str));
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
        C19406qI3.a("SPACacheHandler", "downloaded " + str + " cacheFileName = " + p76.i(str), new Object[0]);
    }

    private final boolean e(String str) {
        return !AbstractC20762sZ6.n0(O78.a.h(str));
    }

    private final String f(String str) {
        return URLConnection.guessContentTypeFromName(str);
    }

    private final WebResourceResponse g(String str) {
        File fileH = h(i(str));
        if (!fileH.exists()) {
            return null;
        }
        String strF = f(str);
        if (strF != null) {
            return new WebResourceResponse(strF, "UTF-8", new FileInputStream(fileH));
        }
        C19406qI3.b("SPACacheHandler", "mime type is null for resourceURL " + str);
        return null;
    }

    private final File h(String str) {
        return new File(this.a.getFilesDir(), str);
    }

    private final String i(String str) {
        MessageDigest messageDigest = this.c;
        byte[] bytes = str.getBytes(C12275eL0.b);
        AbstractC13042fc3.h(bytes, "getBytes(...)");
        String string = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
        AbstractC13042fc3.h(string, "toString(...)");
        return AbstractC20762sZ6.w0(string, 32, '0');
    }

    private final String j(String str) {
        return this.b + str;
    }

    private final boolean k(String str) {
        Iterator it = AbstractC10360bX0.p(new C20644sM5("^/_"), new C20644sM5("/[^/?]+\\.[^/]+$")).iterator();
        while (it.hasNext()) {
            if (((C20644sM5) it.next()).a(str)) {
                return false;
            }
        }
        return true;
    }

    @Override // ir.nasim.InterfaceC22972w78
    public WebResourceResponse a(WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null) {
            return null;
        }
        Uri url = webResourceRequest.getUrl();
        if (!AbstractC13042fc3.d(url.getHost(), Uri.parse(this.b).getHost())) {
            return null;
        }
        String path = url.getPath();
        if (path == null || k(path)) {
            path = "/index.html";
        }
        String strJ = j(path);
        O78 o78 = O78.a;
        String strH = o78.h(strJ);
        String strG = o78.g(strJ);
        if (AbstractC13042fc3.d(strH, "") || !AbstractC13042fc3.d(strH, strG)) {
            if (e(strJ)) {
                return c(strJ, strH, webResourceRequest);
            }
            return null;
        }
        C19406qI3.a("SPACacheHandler", "handleCache: request for " + url + " was served with resource " + strJ + " from cache.", new Object[0]);
        return g(strJ);
    }
}
