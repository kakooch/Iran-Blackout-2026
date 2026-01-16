package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class AU1 implements Closeable {
    private final File a;
    private final File b;
    private final File c;
    private final File d;
    private final int e;
    private long f;
    private final int g;
    private Writer i;
    private int k;
    private long h = 0;
    private final LinkedHashMap j = new LinkedHashMap(0, 0.75f, true);
    private long l = 0;
    final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    private final Callable n = new a();

    class a implements Callable {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (AU1.this) {
                try {
                    if (AU1.this.i == null) {
                        return null;
                    }
                    AU1.this.U();
                    if (AU1.this.G()) {
                        AU1.this.P();
                        AU1.this.k = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static final class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public final class c {
        private final d a;
        private final boolean[] b;
        private boolean c;

        /* synthetic */ c(AU1 au1, d dVar, a aVar) {
            this(dVar);
        }

        public void a() {
            AU1.this.n(this, false);
        }

        public void b() {
            if (this.c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() {
            AU1.this.n(this, true);
            this.c = true;
        }

        public File f(int i) {
            File fileK;
            synchronized (AU1.this) {
                try {
                    if (this.a.f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.a.e) {
                        this.b[i] = true;
                    }
                    fileK = this.a.k(i);
                    AU1.this.a.mkdirs();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return fileK;
        }

        private c(d dVar) {
            this.a = dVar;
            this.b = dVar.e ? null : new boolean[AU1.this.g];
        }
    }

    private final class d {
        private final String a;
        private final long[] b;
        File[] c;
        File[] d;
        private boolean e;
        private c f;
        private long g;

        /* synthetic */ d(AU1 au1, String str, a aVar) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length != AU1.this.g) {
                throw m(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public File j(int i) {
            return this.c[i];
        }

        public File k(int i) {
            return this.d[i];
        }

        public String l() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        private d(String str) {
            this.a = str;
            this.b = new long[AU1.this.g];
            this.c = new File[AU1.this.g];
            this.d = new File[AU1.this.g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < AU1.this.g; i++) {
                sb.append(i);
                this.c[i] = new File(AU1.this.a, sb.toString());
                sb.append(".tmp");
                this.d[i] = new File(AU1.this.a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    public final class e {
        private final String a;
        private final long b;
        private final long[] c;
        private final File[] d;

        /* synthetic */ e(AU1 au1, String str, long j, File[] fileArr, long[] jArr, a aVar) {
            this(str, j, fileArr, jArr);
        }

        public File a(int i) {
            return this.d[i];
        }

        private e(String str, long j, File[] fileArr, long[] jArr) {
            this.a = str;
            this.b = j;
            this.d = fileArr;
            this.c = jArr;
        }
    }

    private AU1(File file, int i, int i2, long j) {
        this.a = file;
        this.e = i;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.g = i2;
        this.f = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    public static AU1 H(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                T(file2, file3, false);
            }
        }
        AU1 au1 = new AU1(file, i, i2, j);
        if (au1.b.exists()) {
            try {
                au1.K();
                au1.J();
                return au1;
            } catch (IOException e2) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                au1.p();
            }
        }
        file.mkdirs();
        AU1 au12 = new AU1(file, i, i2, j);
        au12.P();
        return au12;
    }

    private void J() throws IOException {
        q(this.c);
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i = 0;
            if (dVar.f == null) {
                while (i < this.g) {
                    this.h += dVar.b[i];
                    i++;
                }
            } else {
                dVar.f = null;
                while (i < this.g) {
                    q(dVar.j(i));
                    q(dVar.k(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private void K() throws IOException {
        C24990zY6 c24990zY6 = new C24990zY6(new FileInputStream(this.b), AbstractC13527gN7.a);
        try {
            String strD = c24990zY6.d();
            String strD2 = c24990zY6.d();
            String strD3 = c24990zY6.d();
            String strD4 = c24990zY6.d();
            String strD5 = c24990zY6.d();
            if (!"libcore.io.DiskLruCache".equals(strD) || !"1".equals(strD2) || !Integer.toString(this.e).equals(strD3) || !Integer.toString(this.g).equals(strD4) || !"".equals(strD5)) {
                throw new IOException("unexpected journal header: [" + strD + ", " + strD2 + ", " + strD4 + ", " + strD5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    M(c24990zY6.d());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (c24990zY6.c()) {
                        P();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), AbstractC13527gN7.a));
                    }
                    AbstractC13527gN7.a(c24990zY6);
                    return;
                }
            }
        } catch (Throwable th) {
            AbstractC13527gN7.a(c24990zY6);
            throw th;
        }
    }

    private void M(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        d dVar = (d) this.j.get(strSubstring);
        a aVar = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, aVar);
            this.j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(Separators.SP);
            dVar.e = true;
            dVar.f = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f = new c(this, dVar, aVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void P() {
        try {
            Writer writer = this.i;
            if (writer != null) {
                m(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), AbstractC13527gN7.a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write(Separators.RETURN);
                bufferedWriter.write("1");
                bufferedWriter.write(Separators.RETURN);
                bufferedWriter.write(Integer.toString(this.e));
                bufferedWriter.write(Separators.RETURN);
                bufferedWriter.write(Integer.toString(this.g));
                bufferedWriter.write(Separators.RETURN);
                bufferedWriter.write(Separators.RETURN);
                for (d dVar : this.j.values()) {
                    if (dVar.f != null) {
                        bufferedWriter.write("DIRTY " + dVar.a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.a + dVar.l() + '\n');
                    }
                }
                m(bufferedWriter);
                if (this.b.exists()) {
                    T(this.b, this.d, true);
                }
                T(this.c, this.b, false);
                this.d.delete();
                this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), AbstractC13527gN7.a));
            } catch (Throwable th) {
                m(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void T(File file, File file2, boolean z) throws IOException {
        if (z) {
            q(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        while (this.h > this.f) {
            S((String) ((Map.Entry) this.j.entrySet().iterator().next()).getKey());
        }
    }

    private void l() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private static void m(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(c cVar, boolean z) {
        d dVar = cVar.a;
        if (dVar.f != cVar) {
            throw new IllegalStateException();
        }
        if (z && !dVar.e) {
            for (int i = 0; i < this.g; i++) {
                if (!cVar.b[i]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!dVar.k(i).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.g; i2++) {
            File fileK = dVar.k(i2);
            if (!z) {
                q(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i2);
                fileK.renameTo(fileJ);
                long j = dVar.b[i2];
                long length = fileJ.length();
                dVar.b[i2] = length;
                this.h = (this.h - j) + length;
            }
        }
        this.k++;
        dVar.f = null;
        if (dVar.e || z) {
            dVar.e = true;
            this.i.append((CharSequence) "CLEAN");
            this.i.append(' ');
            this.i.append((CharSequence) dVar.a);
            this.i.append((CharSequence) dVar.l());
            this.i.append('\n');
            if (z) {
                long j2 = this.l;
                this.l = 1 + j2;
                dVar.g = j2;
            }
        } else {
            this.j.remove(dVar.a);
            this.i.append((CharSequence) "REMOVE");
            this.i.append(' ');
            this.i.append((CharSequence) dVar.a);
            this.i.append('\n');
        }
        y(this.i);
        if (this.h > this.f || G()) {
            this.m.submit(this.n);
        }
    }

    private static void q(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized c u(String str, long j) {
        l();
        d dVar = (d) this.j.get(str);
        a aVar = null;
        if (j != -1 && (dVar == null || dVar.g != j)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, aVar);
            this.j.put(str, dVar);
        } else if (dVar.f != null) {
            return null;
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f = cVar;
        this.i.append((CharSequence) "DIRTY");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        y(this.i);
        return cVar;
    }

    private static void y(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public synchronized boolean S(String str) {
        try {
            l();
            d dVar = (d) this.j.get(str);
            if (dVar != null && dVar.f == null) {
                for (int i = 0; i < this.g; i++) {
                    File fileJ = dVar.j(i);
                    if (fileJ.exists() && !fileJ.delete()) {
                        throw new IOException("failed to delete " + fileJ);
                    }
                    this.h -= dVar.b[i];
                    dVar.b[i] = 0;
                }
                this.k++;
                this.i.append((CharSequence) "REMOVE");
                this.i.append(' ');
                this.i.append((CharSequence) str);
                this.i.append('\n');
                this.j.remove(str);
                if (G()) {
                    this.m.submit(this.n);
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.i == null) {
                return;
            }
            Iterator it = new ArrayList(this.j.values()).iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.f != null) {
                    dVar.f.a();
                }
            }
            U();
            m(this.i);
            this.i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void p() throws IOException {
        close();
        AbstractC13527gN7.b(this.a);
    }

    public c s(String str) {
        return u(str, -1L);
    }

    public synchronized e z(String str) {
        l();
        d dVar = (d) this.j.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.e) {
            return null;
        }
        for (File file : dVar.c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) "READ");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        if (G()) {
            this.m.submit(this.n);
        }
        return new e(this, str, dVar.g, dVar.c, dVar.b, null);
    }
}
