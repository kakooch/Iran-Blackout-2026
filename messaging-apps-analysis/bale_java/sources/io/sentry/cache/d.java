package io.sentry.cache;

import io.sentry.C3155n3;
import io.sentry.InterfaceC3176q0;
import io.sentry.Y2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
abstract class d {
    private static final Charset a = Charset.forName("UTF-8");

    static void a(C3155n3 c3155n3, String str, String str2) {
        File fileB = b(c3155n3, str);
        if (fileB == null) {
            c3155n3.getLogger().c(Y2.INFO, "Cache dir is not set, cannot delete from scope cache", new Object[0]);
            return;
        }
        File file = new File(fileB, str2);
        c3155n3.getLogger().c(Y2.DEBUG, "Deleting %s from scope cache", str2);
        if (file.delete()) {
            return;
        }
        c3155n3.getLogger().c(Y2.INFO, "Failed to delete: %s", file.getAbsolutePath());
    }

    static File b(C3155n3 c3155n3, String str) {
        String cacheDirPath = c3155n3.getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        File file = new File(cacheDirPath, str);
        file.mkdirs();
        return file;
    }

    static Object c(C3155n3 c3155n3, String str, String str2, Class cls, InterfaceC3176q0 interfaceC3176q0) {
        File fileB = b(c3155n3, str);
        if (fileB == null) {
            c3155n3.getLogger().c(Y2.INFO, "Cache dir is not set, cannot read from scope cache", new Object[0]);
            return null;
        }
        File file = new File(fileB, str2);
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), a));
                try {
                    if (interfaceC3176q0 == null) {
                        Object objC = c3155n3.getSerializer().c(bufferedReader, cls);
                        bufferedReader.close();
                        return objC;
                    }
                    Object objE = c3155n3.getSerializer().e(bufferedReader, cls, interfaceC3176q0);
                    bufferedReader.close();
                    return objE;
                } finally {
                }
            } catch (Throwable th) {
                c3155n3.getLogger().a(Y2.ERROR, th, "Error reading entity from scope cache: %s", str2);
            }
        } else {
            c3155n3.getLogger().c(Y2.DEBUG, "No entry stored for %s", str2);
        }
        return null;
    }

    static void d(C3155n3 c3155n3, Object obj, String str, String str2) {
        File fileB = b(c3155n3, str);
        if (fileB == null) {
            c3155n3.getLogger().c(Y2.INFO, "Cache dir is not set, cannot store in scope cache", new Object[0]);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(fileB, str2));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, a));
                try {
                    c3155n3.getSerializer().a(obj, bufferedWriter);
                    bufferedWriter.close();
                    fileOutputStream.close();
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            c3155n3.getLogger().a(Y2.ERROR, th, "Error persisting entity: %s", str2);
        }
    }
}
