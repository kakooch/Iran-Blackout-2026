package io.sentry;

import android.gov.nist.core.Separators;
import java.net.URI;

/* renamed from: io.sentry.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C3215w {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final URI e;

    C3215w(String str) {
        try {
            io.sentry.util.u.c(str, "The DSN is required.");
            URI uriNormalize = new URI(str).normalize();
            String scheme = uriNormalize.getScheme();
            if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                throw new IllegalArgumentException("Invalid DSN scheme: " + scheme);
            }
            String userInfo = uriNormalize.getUserInfo();
            if (userInfo == null || userInfo.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            String[] strArrSplit = userInfo.split(":", -1);
            String str2 = strArrSplit[0];
            this.d = str2;
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            this.c = strArrSplit.length > 1 ? strArrSplit[1] : null;
            String path = uriNormalize.getPath();
            path = path.endsWith(Separators.SLASH) ? path.substring(0, path.length() - 1) : path;
            int iLastIndexOf = path.lastIndexOf(Separators.SLASH) + 1;
            String strSubstring = path.substring(0, iLastIndexOf);
            if (!strSubstring.endsWith(Separators.SLASH)) {
                strSubstring = strSubstring + Separators.SLASH;
            }
            this.b = strSubstring;
            String strSubstring2 = path.substring(iLastIndexOf);
            this.a = strSubstring2;
            if (strSubstring2.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: A Project Id is required.");
            }
            this.e = new URI(scheme, null, uriNormalize.getHost(), uriNormalize.getPort(), strSubstring + "api/" + strSubstring2, null, null);
        } catch (Throwable th) {
            throw new IllegalArgumentException(th);
        }
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.c;
    }

    URI c() {
        return this.e;
    }
}
