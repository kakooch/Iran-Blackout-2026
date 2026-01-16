package ir.nasim;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.ErrnoException;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;

/* renamed from: ir.nasim.pd2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC19006pd2 {

    /* renamed from: ir.nasim.pd2$a */
    static class a {
        static void a(FileDescriptor fileDescriptor) throws ErrnoException {
            android.system.Os.close(fileDescriptor);
        }

        static FileDescriptor b(FileDescriptor fileDescriptor) {
            return android.system.Os.dup(fileDescriptor);
        }

        static long c(FileDescriptor fileDescriptor, long j, int i) {
            return android.system.Os.lseek(fileDescriptor, j, i);
        }
    }

    /* renamed from: ir.nasim.pd2$b */
    static class b {
        static void a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(mediaDataSource);
        }
    }

    static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    static long[] b(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    static boolean c(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
