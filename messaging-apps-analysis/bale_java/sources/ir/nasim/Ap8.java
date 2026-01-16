package ir.nasim;

import android.net.Uri;

/* loaded from: classes3.dex */
public abstract class Ap8 {
    private static final KJ a = new KJ();

    public static synchronized Uri a(String str) {
        KJ kj = a;
        Uri uri = (Uri) kj.get("com.google.android.gms.measurement");
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
        kj.put("com.google.android.gms.measurement", uri2);
        return uri2;
    }
}
