package org.acra.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.acra.ACRA;

/* loaded from: classes.dex */
public final class IOUtils {
    public static void safeClose(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void deleteFile(File file) {
        if (file.delete()) {
            return;
        }
        ACRA.log.w(ACRA.LOG_TAG, "Could not delete file: " + file);
    }

    public static void writeStringToFile(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
        } finally {
            safeClose(outputStreamWriter);
        }
    }
}
