package ir.nasim;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SyncFailedException;

/* loaded from: classes2.dex */
public class PL {
    private final File a;
    private final File b;
    private final File c;

    public PL(File file) {
        this.a = file;
        this.b = new File(file.getPath() + ".new");
        this.c = new File(file.getPath() + ".bak");
    }

    private static void d(File file, File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            Log.e("AtomicFile", "Failed to delete file which is a directory " + file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        Log.e("AtomicFile", "Failed to rename " + file + " to " + file2);
    }

    private static boolean f(FileOutputStream fileOutputStream) throws SyncFailedException {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void a(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream == null) {
            return;
        }
        if (!f(fileOutputStream)) {
            Log.e("AtomicFile", "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            Log.e("AtomicFile", "Failed to close file output stream", e);
        }
        if (this.b.delete()) {
            return;
        }
        Log.e("AtomicFile", "Failed to delete new file " + this.b);
    }

    public void b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream == null) {
            return;
        }
        if (!f(fileOutputStream)) {
            Log.e("AtomicFile", "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            Log.e("AtomicFile", "Failed to close file output stream", e);
        }
        d(this.b, this.a);
    }

    public File c() {
        return this.a;
    }

    public FileOutputStream e() throws IOException {
        if (this.c.exists()) {
            d(this.c, this.a);
        }
        try {
            return new FileOutputStream(this.b);
        } catch (FileNotFoundException unused) {
            if (!this.b.getParentFile().mkdirs()) {
                throw new IOException("Failed to create directory for " + this.b);
            }
            try {
                return new FileOutputStream(this.b);
            } catch (FileNotFoundException e) {
                throw new IOException("Failed to create new file " + this.b, e);
            }
        }
    }
}
