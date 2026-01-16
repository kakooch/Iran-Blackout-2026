package ir.nasim;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: ir.nasim.zq8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C25170zq8 implements Er8 {
    final /* synthetic */ Set a;
    final /* synthetic */ Su8 b;
    final /* synthetic */ ZipFile c;

    C25170zq8(C25190zs8 c25190zs8, Set set, Su8 su8, ZipFile zipFile) {
        this.a = set;
        this.b = su8;
        this.c = zipFile;
    }

    @Override // ir.nasim.Er8
    public final void a(Wr8 wr8, File file, boolean z) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        this.a.add(file);
        if (z) {
            return;
        }
        Log.i("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", this.b.b(), wr8.a, this.b.a().getAbsolutePath(), wr8.b.getName(), file.getAbsolutePath()));
        ZipFile zipFile = this.c;
        ZipEntry zipEntry = wr8.b;
        byte[] bArr = new byte[4096];
        if (file.exists()) {
            file.delete();
        }
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                Rm8.m(file);
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i <= 0) {
                        fileOutputStream.close();
                        inputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } finally {
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                }
            }
            throw th;
        }
    }
}
