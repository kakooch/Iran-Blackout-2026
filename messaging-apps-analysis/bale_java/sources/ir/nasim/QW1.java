package ir.nasim;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

/* loaded from: classes2.dex */
public abstract class QW1 {
    public static boolean a(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }
}
