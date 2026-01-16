package io.appmetrica.analytics.coreutils.internal.io;

import ir.nasim.AbstractC7873To0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/io/GZIPUtils;", "", "", "input", "gzipBytes", "unGzipBytes", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class GZIPUtils {
    public static final GZIPUtils INSTANCE = new GZIPUtils();

    private GZIPUtils() {
    }

    public static final byte[] gzipBytes(byte[] input) throws Throwable {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byteArray = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (input != null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = null;
            }
            try {
                gZIPOutputStream.write(input);
                gZIPOutputStream.finish();
                byteArray = byteArrayOutputStream.toByteArray();
                CloseableUtilsKt.closeSafely(gZIPOutputStream);
                CloseableUtilsKt.closeSafely(byteArrayOutputStream);
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                CloseableUtilsKt.closeSafely(gZIPOutputStream);
                CloseableUtilsKt.closeSafely(byteArrayOutputStream2);
                throw th;
            }
        }
        return byteArray;
    }

    public static final byte[] unGzipBytes(byte[] input) throws Throwable {
        Throwable th;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        byte[] bArrC = null;
        ByteArrayInputStream byteArrayInputStream2 = null;
        if (input != null) {
            try {
                ByteArrayInputStream byteArrayInputStream3 = new ByteArrayInputStream(input);
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream3);
                    try {
                        bArrC = AbstractC7873To0.c(gZIPInputStream);
                        CloseableUtilsKt.closeSafely(gZIPInputStream);
                        CloseableUtilsKt.closeSafely(byteArrayInputStream3);
                    } catch (Throwable th2) {
                        byteArrayInputStream = byteArrayInputStream3;
                        th = th2;
                        byteArrayInputStream2 = byteArrayInputStream;
                        CloseableUtilsKt.closeSafely(gZIPInputStream);
                        CloseableUtilsKt.closeSafely(byteArrayInputStream2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    byteArrayInputStream = byteArrayInputStream3;
                    th = th3;
                    gZIPInputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                gZIPInputStream = null;
            }
        }
        return bArrC;
    }
}
