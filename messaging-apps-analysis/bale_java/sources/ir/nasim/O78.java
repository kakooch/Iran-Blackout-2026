package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* loaded from: classes5.dex */
public final class O78 {
    private static OK b;
    private static boolean d;
    public static final O78 a = new O78();
    private static L78 c = new L78();
    public static final int e = 8;

    private O78() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final String str, final String str2, final C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(str, "$HashesEndpoint");
        AbstractC13042fc3.i(str2, "$host");
        AbstractC13042fc3.i(c7234Qv5, "resolver");
        L78 l78 = c;
        AbstractC13042fc3.f(l78);
        if (!l78.s()) {
            a.k();
        }
        if (d) {
            c7234Qv5.b(Boolean.TRUE);
            return;
        }
        C9248Zc6 c9248Zc6H = new C9248Zc6(new C5152Ic6(new Runnable() { // from class: ir.nasim.N78
            @Override // java.lang.Runnable
            public final void run() {
                O78.f(str, str2, c7234Qv5);
            }
        })).h(EnumC11723dV1.IO);
        AbstractC13042fc3.h(c9248Zc6H, "subscribeOn(...)");
        SZ.e(c9248Zc6H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String str, String str2, C7234Qv5 c7234Qv5) {
        AbstractC13042fc3.i(str, "$HashesEndpoint");
        AbstractC13042fc3.i(str2, "$host");
        AbstractC13042fc3.i(c7234Qv5, "$resolver");
        try {
            C19231q00 c19231q00 = new C19231q00(new String(a.c(str), C12275eL0.b));
            L78 l78 = c;
            AbstractC13042fc3.f(l78);
            l78.r().clear();
            for (String str3 : c19231q00.r()) {
                String strO = c19231q00.o(str3, "");
                L78 l782 = c;
                AbstractC13042fc3.f(l782);
                HashMap mapR = l782.r();
                AbstractC13042fc3.h(mapR, "getServerHashes(...)");
                mapR.put(str2 + Separators.SLASH + str3, strO);
            }
            a.k();
            d = true;
            c7234Qv5.b(Boolean.TRUE);
        } catch (Exception e2) {
            c7234Qv5.b(Boolean.FALSE);
            C19406qI3.d("WebViewHashes", e2);
        }
    }

    private final void k() {
        try {
            if (b != null) {
                L78 l78 = c;
                AbstractC13042fc3.f(l78);
                l78.u(true);
                OK ok = b;
                AbstractC13042fc3.f(ok);
                L78 l782 = c;
                AbstractC13042fc3.f(l782);
                ok.e(new C9863ah0(8L, l782.toByteArray()));
            } else {
                C19406qI3.j("WebViewHashes", "error in saveWebViewHashStorage, context is empty or blobEngine not exists", new Object[0]);
            }
        } catch (Exception e2) {
            C19406qI3.c("WebViewHashes", "error in saveWebViewHashStorage", e2);
        }
    }

    public final byte[] c(String str) throws IOException {
        int length;
        AbstractC13042fc3.i(str, "url");
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        AbstractC13042fc3.h(uRLConnectionOpenConnection, "openConnection(...)");
        uRLConnectionOpenConnection.connect();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(uRLConnectionOpenConnection.getInputStream());
        int contentLength = uRLConnectionOpenConnection.getContentLength();
        int i = 0;
        if (contentLength > 0) {
            byte[] bArr = new byte[contentLength];
            while (i < contentLength) {
                int i2 = bufferedInputStream.read(bArr, i, contentLength - i);
                if (i2 > 0) {
                    i += i2;
                }
            }
            bufferedInputStream.close();
            return bArr;
        }
        byte[] bArr2 = new byte[1024];
        byte[] bArr3 = null;
        int i3 = 0;
        while (i3 >= 0) {
            i3 = bufferedInputStream.read(bArr2, 0, 1024);
            if (i3 > 0) {
                byte[] bArr4 = bArr3 == null ? new byte[i3] : new byte[bArr3.length + i3];
                if (bArr3 != null) {
                    length = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr4, 0, length);
                } else {
                    length = 0;
                }
                System.arraycopy(bArr2, 0, bArr4, length, i3);
                bArr3 = bArr4;
            }
        }
        bufferedInputStream.close();
        AbstractC13042fc3.f(bArr3);
        return bArr3;
    }

    public final C6517Nv5 d(final String str) {
        AbstractC13042fc3.i(str, "host");
        final String str2 = str + "/hashes.json";
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.M78
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                O78.e(str2, str, c7234Qv5);
            }
        });
    }

    public final String g(String str) {
        L78 l78 = c;
        if (l78 != null) {
            AbstractC13042fc3.f(l78);
            if (l78.q() != null) {
                L78 l782 = c;
                AbstractC13042fc3.f(l782);
                if (l782.q().containsKey(str)) {
                    L78 l783 = c;
                    AbstractC13042fc3.f(l783);
                    return (String) l783.q().get(str);
                }
            }
        }
        return "";
    }

    public final String h(String str) {
        L78 l78 = c;
        if (l78 != null) {
            AbstractC13042fc3.f(l78);
            if (l78.r() != null) {
                L78 l782 = c;
                AbstractC13042fc3.f(l782);
                if (l782.r().containsKey(str)) {
                    L78 l783 = c;
                    AbstractC13042fc3.f(l783);
                    Object obj = l783.r().get(str);
                    AbstractC13042fc3.f(obj);
                    return (String) obj;
                }
            }
        }
        return "";
    }

    public final void i(OK ok) {
        C9863ah0 c9863ah0;
        AbstractC13042fc3.i(ok, "blobEngine");
        b = ok;
        L78 l78 = c;
        AbstractC13042fc3.f(l78);
        if (l78.s() || (c9863ah0 = (C9863ah0) ok.n(8L)) == null) {
            return;
        }
        l(c9863ah0.q());
    }

    public final void j(String str, String str2) {
        L78 l78 = c;
        AbstractC13042fc3.f(l78);
        HashMap mapQ = l78.q();
        AbstractC13042fc3.h(mapQ, "getClientHashes(...)");
        mapQ.put(str, str2);
        k();
    }

    public final void l(byte[] bArr) {
        if (bArr != null) {
            try {
                c = new L78(bArr);
            } catch (Exception e2) {
                C19406qI3.c("WebViewHashes", "error on load of webview hash", e2);
            }
        }
    }
}
