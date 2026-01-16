package io.appmetrica.analytics.impl;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: classes3.dex */
public abstract class Da {
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.io.File r9) throws java.io.IOException {
        /*
            r0 = 0
            if (r9 == 0) goto L7a
            boolean r1 = r9.exists()
            if (r1 != 0) goto Lb
            goto L7a
        Lb:
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L6f
            java.lang.String r2 = "r"
            r1.<init>(r9, r2)     // Catch: java.lang.Throwable -> L47 java.lang.Throwable -> L6f
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch: java.lang.Throwable -> L42 java.lang.Throwable -> L45
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r8 = 1
            r4 = 0
            r3 = r2
            java.nio.channels.FileLock r3 = r3.lock(r4, r6, r8)     // Catch: java.lang.Throwable -> L42 java.lang.Throwable -> L45
            long r4 = r9.length()     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L71
            int r4 = (int) r4     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L71
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L71
            r2.read(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L71
            r4.flip()     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L71
            byte[] r2 = r4.array()     // Catch: java.lang.Throwable -> L40 java.lang.Throwable -> L71
            r9.getAbsolutePath()
            a(r3)
            io.appmetrica.analytics.impl.hn.a(r1)
            goto L7b
        L40:
            r2 = move-exception
            goto L4b
        L42:
            r2 = move-exception
            r3 = r0
            goto L4b
        L45:
            r3 = r0
            goto L71
        L47:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r3 = r1
        L4b:
            io.appmetrica.analytics.impl.ej r4 = io.appmetrica.analytics.impl.Ei.a     // Catch: java.lang.Throwable -> L64
            java.lang.String r5 = "error_during_file_reading"
            r4.getClass()     // Catch: java.lang.Throwable -> L64
            io.appmetrica.analytics.impl.dj r6 = new io.appmetrica.analytics.impl.dj     // Catch: java.lang.Throwable -> L64
            r6.<init>(r5, r2)     // Catch: java.lang.Throwable -> L64
            r4.a(r6)     // Catch: java.lang.Throwable -> L64
            r9.getAbsolutePath()
            a(r3)
            io.appmetrica.analytics.impl.hn.a(r1)
            goto L7a
        L64:
            r0 = move-exception
            r9.getAbsolutePath()
            a(r3)
            io.appmetrica.analytics.impl.hn.a(r1)
            throw r0
        L6f:
            r1 = r0
            r3 = r1
        L71:
            r9.getAbsolutePath()
            a(r3)
            io.appmetrica.analytics.impl.hn.a(r1)
        L7a:
            r2 = r0
        L7b:
            if (r2 == 0) goto L9a
            java.lang.String r0 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L85
            java.lang.String r9 = "UTF-8"
            r0.<init>(r2, r9)     // Catch: java.io.UnsupportedEncodingException -> L85
            goto L9a
        L85:
            r9 = move-exception
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            io.appmetrica.analytics.impl.ej r1 = io.appmetrica.analytics.impl.Ei.a
            r1.getClass()
            io.appmetrica.analytics.impl.dj r2 = new io.appmetrica.analytics.impl.dj
            java.lang.String r3 = "read_share_file_with_unsupported_encoding"
            r2.<init>(r3, r9)
            r1.a(r2)
        L9a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.Da.a(java.io.File):java.lang.String");
    }

    public static void a(FileLock fileLock) throws IOException {
        if (fileLock == null || !fileLock.isValid()) {
            return;
        }
        try {
            fileLock.release();
        } catch (IOException unused) {
        }
    }

    public static void a(String str, FileOutputStream fileOutputStream) throws IOException {
        FileLock fileLockLock = null;
        try {
            FileChannel channel = fileOutputStream.getChannel();
            fileLockLock = channel.lock();
            byte[] bytes = str.getBytes("UTF-8");
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length);
            byteBufferAllocate.put(bytes);
            byteBufferAllocate.flip();
            channel.write(byteBufferAllocate);
            channel.force(true);
        } catch (IOException unused) {
        } finally {
            a(fileLockLock);
            hn.a((Closeable) fileOutputStream);
        }
    }
}
