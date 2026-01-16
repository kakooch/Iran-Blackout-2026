package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import ir.nasim.C19034pg0;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.pg0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C19034pg0 {
    private static c A;
    private static boolean u;
    static volatile boolean w;
    private static ThreadPoolExecutor y;
    private static int z;
    private final e a;
    String b;
    int c;
    int d;
    final boolean f;
    byte[] g;
    private int i;
    boolean j;
    volatile boolean k;
    int l;
    final File m;
    private int n;
    volatile boolean q;
    volatile boolean r;
    RandomAccessFile s;
    BitmapFactory.Options t;
    static ConcurrentHashMap v = new ConcurrentHashMap();
    private static final int x = Utilities.d(Runtime.getRuntime().availableProcessors() - 2, 6, 1);
    ArrayList e = new ArrayList();
    private final Object h = new Object();
    public AtomicBoolean o = new AtomicBoolean(false);
    private Runnable p = new a();

    /* renamed from: ir.nasim.pg0$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (Thread thread : C19034pg0.v.keySet()) {
                if (!thread.isAlive()) {
                    C19034pg0.v.remove(thread);
                }
            }
            if (C19034pg0.v.isEmpty()) {
                C19034pg0.w = false;
            } else {
                AbstractC21455b.n1(C19034pg0.this.p, 5000L);
            }
        }
    }

    /* renamed from: ir.nasim.pg0$b */
    class b {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.pg0$c */
    static class c {
        Y33[] a;
        private Bitmap[] b;
        private int c;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(Bitmap bitmap) {
            try {
                bitmap.recycle();
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(ArrayList arrayList) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Bitmap) it.next()).recycle();
            }
        }

        void d(int i, int i2) {
            int i3 = (i2 << 16) + i;
            boolean z = this.c != i3;
            this.c = i3;
            for (int i4 = 0; i4 < C19034pg0.x; i4++) {
                if (z || this.b[i4] == null) {
                    final Bitmap bitmap = this.b[i4];
                    if (bitmap != null) {
                        Utilities.e.i(new Runnable() { // from class: ir.nasim.qg0
                            @Override // java.lang.Runnable
                            public final void run() {
                                C19034pg0.c.e(bitmap);
                            }
                        });
                    }
                    this.b[i4] = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                }
                Y33[] y33Arr = this.a;
                if (y33Arr[i4] == null) {
                    y33Arr[i4] = new Y33(i2 * i * 2);
                }
            }
        }

        void g() {
            final ArrayList arrayList = null;
            for (int i = 0; i < C19034pg0.x; i++) {
                if (this.b[i] != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(this.b[i]);
                }
                this.b[i] = null;
                this.a[i] = null;
            }
            if (arrayList.isEmpty()) {
                return;
            }
            Utilities.e.i(new Runnable() { // from class: ir.nasim.rg0
                @Override // java.lang.Runnable
                public final void run() {
                    C19034pg0.c.f(arrayList);
                }
            });
        }

        private c() {
            this.a = new Y33[C19034pg0.x];
            this.b = new Bitmap[C19034pg0.x];
        }
    }

    /* renamed from: ir.nasim.pg0$d */
    public static class d {
        public int a = 100;
        public boolean b = false;
        public boolean c;
    }

    /* renamed from: ir.nasim.pg0$e */
    public interface e {
        int a(Bitmap bitmap);

        void b();

        void c();
    }

    /* renamed from: ir.nasim.pg0$f */
    private class f {
        final int a;
        int b;
        int c;

        private f(int i) {
            this.a = i;
        }
    }

    /* renamed from: ir.nasim.pg0$g */
    public static class g {
        public int a;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0105 -> B:68:0x0134). Please report as a decompilation issue!!! */
    public C19034pg0(File file, e eVar, d dVar, int i, int i2, boolean z2) throws IOException {
        RandomAccessFile randomAccessFile;
        Throwable th;
        this.a = eVar;
        this.c = i;
        this.d = i2;
        this.l = dVar.a;
        this.b = file.getName();
        if (y == null) {
            int i3 = x;
            y = new ThreadPoolExecutor(i3, i3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
        File file2 = new File(C4278El2.q(4), "acache");
        if (!u) {
            file2.mkdir();
            u = true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append("_");
        sb.append(i);
        sb.append("_");
        sb.append(i2);
        sb.append(z2 ? "_nolimit" : Separators.SP);
        sb.append(".pcache2");
        File file3 = new File(file2, sb.toString());
        this.m = file3;
        this.f = i < AbstractC21455b.F(60.0f) && i2 < AbstractC21455b.F(60.0f);
        if (AbstractC8662Wx6.h() < 2) {
            this.k = false;
            this.q = false;
            return;
        }
        this.k = file3.exists();
        if (this.k) {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file3, "r");
                    try {
                        this.q = randomAccessFile.readBoolean();
                        if (this.q && this.e.isEmpty()) {
                            randomAccessFile.seek(randomAccessFile.readInt());
                            int i4 = randomAccessFile.readInt();
                            i(randomAccessFile, i4 > 10000 ? 0 : i4);
                            if (this.e.size() == 0) {
                                this.q = false;
                                this.k = false;
                                file3.delete();
                            } else {
                                if (this.s != randomAccessFile) {
                                    f();
                                }
                                this.s = randomAccessFile;
                            }
                        }
                        if (this.s != randomAccessFile) {
                            randomAccessFile.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            this.m.delete();
                            this.k = false;
                            if (this.s != randomAccessFile && randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                        } catch (Throwable th3) {
                            try {
                                if (this.s != randomAccessFile && randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th3;
                        }
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Throwable th4) {
                randomAccessFile = null;
                th = th4;
            }
        }
    }

    private void f() throws IOException {
        RandomAccessFile randomAccessFile = this.s;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void h() {
        int i = z - 1;
        z = i;
        if (i <= 0) {
            z = 0;
            RLottieDrawable.w1.i(new Runnable() { // from class: ir.nasim.ng0
                @Override // java.lang.Runnable
                public final void run() {
                    C19034pg0.p();
                }
            });
        }
    }

    private void i(RandomAccessFile randomAccessFile, int i) throws IOException {
        if (i == 0) {
            return;
        }
        byte[] bArr = new byte[i * 8];
        randomAccessFile.read(bArr);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        for (int i2 = 0; i2 < i; i2++) {
            f fVar = new f(i2);
            fVar.c = byteBufferWrap.getInt();
            fVar.b = byteBufferWrap.getInt();
            this.e.add(fVar);
        }
    }

    private byte[] j(f fVar) {
        boolean z2 = this.f && Thread.currentThread().getName().startsWith("DispatchQueuePoolThreadSafety_");
        byte[] bArr = z2 ? (byte[]) v.get(Thread.currentThread()) : this.g;
        if (bArr == null || bArr.length < fVar.b) {
            bArr = new byte[(int) (fVar.b * 1.3f)];
            if (z2) {
                v.put(Thread.currentThread(), bArr);
                if (!w) {
                    w = true;
                    AbstractC21455b.n1(this.p, 5000L);
                }
            } else {
                this.g = bArr;
            }
        }
        return bArr;
    }

    public static void n() {
        z++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(AtomicBoolean atomicBoolean, Bitmap[] bitmapArr, int i, Y33[] y33Arr, int i2, RandomAccessFile randomAccessFile, ArrayList arrayList, CountDownLatch[] countDownLatchArr) {
        if (this.o.get() || atomicBoolean.get()) {
            return;
        }
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.WEBP;
        if (Build.VERSION.SDK_INT <= 28) {
            compressFormat = Bitmap.CompressFormat.PNG;
        }
        bitmapArr[i].compress(compressFormat, this.l, y33Arr[i]);
        int i3 = y33Arr[i].b;
        try {
            synchronized (this.h) {
                f fVar = new f(i2);
                fVar.c = (int) randomAccessFile.length();
                arrayList.add(fVar);
                randomAccessFile.write(y33Arr[i].a, 0, i3);
                fVar.b = i3;
                y33Arr[i].reset();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            try {
                randomAccessFile.close();
            } catch (Exception unused) {
            } catch (Throwable th) {
                atomicBoolean.set(true);
                throw th;
            }
            atomicBoolean.set(true);
        }
        countDownLatchArr[i].countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p() {
        c cVar = A;
        if (cVar != null) {
            cVar.g();
            A = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01fb, code lost:
    
        r22.close();
        r24.a.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e5, code lost:
    
        r13 = r5;
        r20 = r7;
        r22 = r9;
        r23 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01d4, code lost:
    
        if (ir.nasim.AbstractC8814Xl0.a == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01d6, code lost:
    
        ir.nasim.AbstractC6403Nl2.a("cancelled cache generation");
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01db, code lost:
    
        r13.set(true);
        r10 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01e2, code lost:
    
        if (r10 >= ir.nasim.C19034pg0.x) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01e4, code lost:
    
        r0 = r20[r10];
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01e6, code lost:
    
        if (r0 == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e8, code lost:
    
        r0.await();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ec, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01ee, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0093 A[Catch: all -> 0x0058, Exception -> 0x005b, IOException -> 0x005e, FileNotFoundException -> 0x0061, TryCatch #11 {IOException -> 0x005e, blocks: (B:3:0x0002, B:17:0x004b, B:34:0x0071, B:40:0x007f, B:44:0x0086, B:46:0x0093, B:47:0x009a, B:48:0x00ca, B:50:0x00ce, B:55:0x00d7, B:57:0x00df, B:60:0x00ee, B:63:0x00f9, B:65:0x00fd, B:67:0x0101, B:72:0x010a, B:71:0x0107, B:73:0x010d, B:74:0x0126, B:76:0x012c, B:77:0x0149, B:79:0x0189, B:84:0x01d2, B:86:0x01d6, B:87:0x01db, B:88:0x01e0, B:90:0x01e4, B:92:0x01e8, B:97:0x01f1, B:96:0x01ee, B:101:0x01fb, B:54:0x00d4), top: B:127:0x0002, outer: #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g() {
        /*
            Method dump skipped, instructions count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19034pg0.g():void");
    }

    public int k(int i, Bitmap bitmap) throws IOException {
        RandomAccessFile randomAccessFile;
        if (this.j) {
            return -1;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            if (!this.q && !this.k) {
                return -1;
            }
            if (!this.q || (randomAccessFile = this.s) == null) {
                randomAccessFile = new RandomAccessFile(this.m, "r");
                try {
                    this.q = randomAccessFile.readBoolean();
                    if (this.q && this.e.isEmpty()) {
                        randomAccessFile.seek(randomAccessFile.readInt());
                        i(randomAccessFile, randomAccessFile.readInt());
                    }
                    if (this.e.size() == 0) {
                        this.q = false;
                    }
                    if (!this.q) {
                        randomAccessFile.close();
                        return -1;
                    }
                } catch (FileNotFoundException unused) {
                    randomAccessFile2 = randomAccessFile;
                    if (this.j && randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return -1;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    AbstractC6403Nl2.e(th, false);
                    int i2 = this.n + 1;
                    this.n = i2;
                    if (i2 > 10) {
                        this.j = true;
                    }
                    if (this.j) {
                        randomAccessFile2.close();
                    }
                    return -1;
                }
            }
            if (this.e.size() == 0) {
                return -1;
            }
            f fVar = (f) this.e.get(Utilities.d(i, this.e.size() - 1, 0));
            randomAccessFile.seek(fVar.c);
            byte[] bArrJ = j(fVar);
            randomAccessFile.readFully(bArrJ, 0, fVar.b);
            if (this.r) {
                this.s = null;
                randomAccessFile.close();
            } else {
                if (this.s != randomAccessFile) {
                    f();
                }
                this.s = randomAccessFile;
            }
            if (this.t == null) {
                this.t = new BitmapFactory.Options();
            }
            BitmapFactory.Options options = this.t;
            options.inBitmap = bitmap;
            BitmapFactory.decodeByteArray(bArrJ, 0, fVar.b, options);
            this.t.inBitmap = null;
            return 0;
        } catch (FileNotFoundException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public int l(Bitmap bitmap, g gVar) throws IOException {
        int iK = k(this.i, bitmap);
        gVar.a = this.i;
        if (this.q && !this.e.isEmpty()) {
            int i = this.i + 1;
            this.i = i;
            if (i >= this.e.size()) {
                this.i = 0;
            }
        }
        return iK;
    }

    public int m() {
        return this.e.size();
    }

    public boolean q() {
        return (this.q && this.k) ? false : true;
    }

    public void r() throws IOException {
        RandomAccessFile randomAccessFile = this.s;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.s = null;
        }
        this.r = true;
    }

    public void e() {
    }
}
