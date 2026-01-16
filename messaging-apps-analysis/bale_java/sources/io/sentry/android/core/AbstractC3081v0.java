package io.sentry.android.core;

import android.content.Context;
import io.sentry.A3;
import io.sentry.InterfaceC3102d0;
import io.sentry.util.C3202a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

/* renamed from: io.sentry.android.core.v0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC3081v0 {
    static String a;
    private static final Charset b = Charset.forName("UTF-8");
    protected static final C3202a c = new C3202a();

    public static String a(Context context) {
        InterfaceC3102d0 interfaceC3102d0A = c.a();
        try {
            if (a == null) {
                File file = new File(context.getFilesDir(), "INSTALLATION");
                try {
                    if (!file.exists()) {
                        String strC = c(file);
                        a = strC;
                        if (interfaceC3102d0A != null) {
                            interfaceC3102d0A.close();
                        }
                        return strC;
                    }
                    a = b(file);
                } catch (Throwable th) {
                    throw new RuntimeException(th);
                }
            }
            String str = a;
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            return str;
        } catch (Throwable th2) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    static String b(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            byte[] bArr = new byte[(int) randomAccessFile.length()];
            randomAccessFile.readFully(bArr);
            String str = new String(bArr, b);
            randomAccessFile.close();
            return str;
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    static String c(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            String strA = A3.a();
            fileOutputStream.write(strA.getBytes(b));
            fileOutputStream.flush();
            fileOutputStream.close();
            return strA;
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
