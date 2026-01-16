package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.net.Uri;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class apk {
    private final String a = "ad.doubleclick.net";
    private final String[] b = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private final apd c;

    public apk(apd apdVar) {
        this.c = apdVar;
    }

    private final Uri d(Uri uri, Context context) throws apl {
        boolean zEquals;
        uri.getClass();
        try {
            try {
                zEquals = uri.getHost().equals(this.a);
            } catch (NullPointerException unused) {
                zEquals = false;
            }
            if (zEquals) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new apl("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new apl("Query parameter already exists: ms");
            }
            String strA = this.c.a(context);
            if (!zEquals) {
                String string = uri.toString();
                int iIndexOf = string.indexOf("&adurl");
                if (iIndexOf == -1) {
                    iIndexOf = string.indexOf("?adurl");
                }
                if (iIndexOf == -1) {
                    return uri.buildUpon().appendQueryParameter("ms", strA).build();
                }
                int i = iIndexOf + 1;
                return Uri.parse(string.substring(0, i) + "ms=" + strA + "&" + string.substring(i));
            }
            String string2 = uri.toString();
            int iIndexOf2 = string2.indexOf(";adurl");
            if (iIndexOf2 != -1) {
                int i2 = iIndexOf2 + 1;
                return Uri.parse(string2.substring(0, i2) + "dc_ms=" + strA + ";" + string2.substring(i2));
            }
            String encodedPath = uri.getEncodedPath();
            int iIndexOf3 = string2.indexOf(encodedPath);
            return Uri.parse(string2.substring(0, encodedPath.length() + iIndexOf3) + ";dc_ms=" + strA + ";" + string2.substring(iIndexOf3 + encodedPath.length()));
        } catch (UnsupportedOperationException unused2) {
            throw new apl("Provided Uri is not in a valid state");
        }
    }

    public final boolean a(Uri uri) {
        uri.getClass();
        try {
            String host = uri.getHost();
            String[] strArr = this.b;
            for (int i = 0; i < 3; i++) {
                if (host.endsWith(strArr[i])) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    public final apd b() {
        return this.c;
    }

    public final Uri c(Uri uri, Context context) throws apl {
        return d(uri, context);
    }
}
