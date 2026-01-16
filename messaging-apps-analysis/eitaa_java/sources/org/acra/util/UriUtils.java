package org.acra.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.acra.attachment.AcraContentProvider;

/* loaded from: classes3.dex */
public final class UriUtils {
    public static void copyFromUri(Context context, OutputStream outputStream, Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        try {
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Could not open " + uri.toString());
            }
            byte[] bArr = new byte[8192];
            while (true) {
                int i = inputStreamOpenInputStream.read(bArr);
                if (i > 0) {
                    outputStream.write(bArr, 0, i);
                } else {
                    inputStreamOpenInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th2;
            }
        }
    }

    public static String getFileNameFromUri(Context context, Uri uri) throws FileNotFoundException {
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    return cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        throw new FileNotFoundException("Could not resolve filename of " + uri);
    }

    public static String getMimeType(Context context, Uri uri) {
        String type;
        return (!uri.getScheme().equals("content") || (type = context.getContentResolver().getType(uri)) == null) ? AcraContentProvider.guessMimeType(uri) : type;
    }
}
