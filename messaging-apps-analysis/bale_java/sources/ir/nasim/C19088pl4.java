package ir.nasim;

import android.content.Context;
import android.content.SharedPreferences;
import android.gov.nist.core.Separators;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* renamed from: ir.nasim.pl4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C19088pl4 implements Closeable {
    private final File a;
    private final long b;
    private final File c;
    private final RandomAccessFile d;
    private final FileChannel e;
    private final FileLock f;

    /* renamed from: ir.nasim.pl4$a */
    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    /* renamed from: ir.nasim.pl4$b */
    private static class b extends File {
        public long a;

        public b(File file, String str) {
            super(file, str);
            this.a = -1L;
        }
    }

    C19088pl4(File file, File file2) throws Throwable {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + Separators.RPAREN);
        this.a = file;
        this.c = file2;
        this.b = g(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.e = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e) {
                e = e;
                b(this.e);
                throw e;
            } catch (Error e2) {
                e = e2;
                b(this.e);
                throw e;
            } catch (RuntimeException e3) {
                e = e3;
                b(this.e);
                throw e;
            }
        } catch (IOException e4) {
            e = e4;
            b(this.d);
            throw e;
        } catch (Error e5) {
            e = e5;
            b(this.d);
            throw e;
        } catch (RuntimeException e6) {
            e = e6;
            b(this.d);
            throw e;
        }
    }

    private void a() {
        File[] fileArrListFiles = this.c.listFiles(new a());
        if (fileArrListFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.c.getPath() + ").");
            return;
        }
        for (File file : fileArrListFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            }
        }
    }

    private static void b(Closeable closeable) throws IOException {
        try {
            closeable.close();
        } catch (IOException e) {
            Log.w("MultiDex", "Failed to close resource", e);
        }
    }

    private static void c(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i("MultiDex", "Extracting " + fileCreateTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(fileCreateTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int i = inputStream.read(bArr); i != -1; i = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, i);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!fileCreateTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
                }
                Log.i("MultiDex", "Renaming to " + file.getPath());
                if (fileCreateTempFile.renameTo(file)) {
                    b(inputStream);
                    fileCreateTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + Separators.DOUBLE_QUOTE);
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            b(inputStream);
            fileCreateTempFile.delete();
            throw th2;
        }
    }

    private static SharedPreferences d(Context context) {
        return context.getSharedPreferences("multidex.version", 4);
    }

    private static long e(File file) {
        long jLastModified = file.lastModified();
        return jLastModified == -1 ? jLastModified - 1 : jLastModified;
    }

    private static long g(File file) throws IOException {
        long jC = Cc8.c(file);
        return jC == -1 ? jC - 1 : jC;
    }

    private static boolean j(Context context, File file, long j, String str) {
        SharedPreferences sharedPreferencesD = d(context);
        if (sharedPreferencesD.getLong(str + "timestamp", -1L) == e(file)) {
            if (sharedPreferencesD.getLong(str + "crc", -1L) == j) {
                return false;
            }
        }
        return true;
    }

    private List l(Context context, String str) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.a.getName() + ".classes";
        SharedPreferences sharedPreferencesD = d(context);
        int i = sharedPreferencesD.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i + (-1));
        int i2 = 2;
        while (i2 <= i) {
            b bVar = new b(this.c, str2 + i2 + ".zip");
            if (!bVar.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + bVar.getPath() + Separators.QUOTE);
            }
            bVar.a = g(bVar);
            long j = sharedPreferencesD.getLong(str + "dex.crc." + i2, -1L);
            long j2 = sharedPreferencesD.getLong(str + "dex.time." + i2, -1L);
            long jLastModified = bVar.lastModified();
            if (j2 == jLastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = sharedPreferencesD;
                if (j == bVar.a) {
                    arrayList.add(bVar);
                    i2++;
                    sharedPreferencesD = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + bVar + " (key \"" + str + "\"), expected modification time: " + j2 + ", modification time: " + jLastModified + ", expected crc: " + j + ", file crc: " + bVar.a);
        }
        return arrayList;
    }

    private List m() throws IOException {
        boolean z;
        String str = this.a.getName() + ".classes";
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.a);
        try {
            int i = 2;
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            while (entry != null) {
                b bVar = new b(this.c, str + i + ".zip");
                arrayList.add(bVar);
                Log.i("MultiDex", "Extraction is needed for file " + bVar);
                int i2 = 0;
                boolean z2 = false;
                while (i2 < 3 && !z2) {
                    int i3 = i2 + 1;
                    c(zipFile, entry, bVar, str);
                    try {
                        bVar.a = g(bVar);
                        z = true;
                    } catch (IOException e) {
                        Log.w("MultiDex", "Failed to read crc from " + bVar.getAbsolutePath(), e);
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(bVar.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(bVar.length());
                    sb.append(" - crc: ");
                    sb.append(bVar.a);
                    Log.i("MultiDex", sb.toString());
                    if (!z) {
                        bVar.delete();
                        if (bVar.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + bVar.getPath() + Separators.QUOTE);
                        }
                    }
                    z2 = z;
                    i2 = i3;
                }
                if (!z2) {
                    throw new IOException("Could not create zip file " + bVar.getAbsolutePath() + " for secondary dex (" + i + Separators.RPAREN);
                }
                i++;
                entry = zipFile.getEntry("classes" + i + ".dex");
            }
            try {
                zipFile.close();
            } catch (IOException e2) {
                Log.w("MultiDex", "Failed to close resource", e2);
            }
            return arrayList;
        } finally {
        }
    }

    private static void n(Context context, String str, long j, long j2, List list) {
        SharedPreferences.Editor editorEdit = d(context).edit();
        editorEdit.putLong(str + "timestamp", j);
        editorEdit.putLong(str + "crc", j2);
        editorEdit.putInt(str + "dex.number", list.size() + 1);
        Iterator it = list.iterator();
        int i = 2;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            editorEdit.putLong(str + "dex.crc." + i, bVar.a);
            editorEdit.putLong(str + "dex.time." + i, bVar.lastModified());
            i++;
        }
        editorEdit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f.release();
        this.e.close();
        this.d.close();
    }

    List k(Context context, String str, boolean z) throws IOException {
        List listM;
        List listL;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.a.getPath() + ", " + z + ", " + str + Separators.RPAREN);
        if (!this.f.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (!z && !j(context, this.a, this.b, str)) {
            try {
                listL = l(context, str);
            } catch (IOException e) {
                Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e);
                listM = m();
                n(context, str, e(this.a), this.b, listM);
            }
            Log.i("MultiDex", "load found " + listL.size() + " secondary dex files");
            return listL;
        }
        if (z) {
            Log.i("MultiDex", "Forced extraction must be performed.");
        } else {
            Log.i("MultiDex", "Detected that extraction must be performed.");
        }
        listM = m();
        n(context, str, e(this.a), this.b, listM);
        listL = listM;
        Log.i("MultiDex", "load found " + listL.size() + " secondary dex files");
        return listL;
    }
}
