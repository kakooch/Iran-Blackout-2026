package androidx.sharetarget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import androidx.sharetarget.c;
import ir.nasim.C15791kA6;
import ir.nasim.C24971zW5;
import ir.nasim.EA6;
import ir.nasim.InterfaceFutureC15215jC3;
import ir.nasim.KJ;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ShortcutInfoCompatSaverImpl extends EA6 {
    private static final Object h = new Object();
    private static volatile ShortcutInfoCompatSaverImpl i;
    final Context a;
    final Map b = new KJ();
    final Map c = new KJ();
    final ExecutorService d;
    private final ExecutorService e;
    final File f;
    final File g;

    class a implements Runnable {
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException, IOException, IllegalArgumentException {
            ShortcutInfoCompatSaverImpl.this.h(this.a);
            androidx.sharetarget.c.f(this.a, ShortcutInfoCompatSaverImpl.this.f);
        }
    }

    class b implements Runnable {
        final /* synthetic */ InterfaceFutureC15215jC3 a;
        final /* synthetic */ C24971zW5 b;

        b(InterfaceFutureC15215jC3 interfaceFutureC15215jC3, C24971zW5 c24971zW5) {
            this.a = interfaceFutureC15215jC3;
            this.b = c24971zW5;
        }

        @Override // java.lang.Runnable
        public void run() throws ExecutionException, InterruptedException {
            try {
                this.a.get();
                this.b.o(null);
            } catch (Exception e) {
                this.b.p(e);
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ File a;

        c(File file) {
            this.a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ShortcutInfoCompatSaverImpl.i(this.a);
                ShortcutInfoCompatSaverImpl.i(ShortcutInfoCompatSaverImpl.this.g);
                ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl = ShortcutInfoCompatSaverImpl.this;
                shortcutInfoCompatSaverImpl.b.putAll(androidx.sharetarget.c.b(shortcutInfoCompatSaverImpl.f, shortcutInfoCompatSaverImpl.a));
                ShortcutInfoCompatSaverImpl.this.h(new ArrayList(ShortcutInfoCompatSaverImpl.this.b.values()));
            } catch (Exception e) {
                Log.w("ShortcutInfoCompatSaver", "ShortcutInfoCompatSaver started with an exceptions ", e);
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ C24971zW5 b;

        d(List list, C24971zW5 c24971zW5) {
            this.a = list;
            this.b = c24971zW5;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (String str : this.a) {
                ShortcutInfoCompatSaverImpl.this.b.remove(str);
                InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = (InterfaceFutureC15215jC3) ShortcutInfoCompatSaverImpl.this.c.remove(str);
                if (interfaceFutureC15215jC3 != null) {
                    interfaceFutureC15215jC3.cancel(false);
                }
            }
            ShortcutInfoCompatSaverImpl.this.o(this.b);
        }
    }

    class e implements Runnable {
        final /* synthetic */ C24971zW5 a;

        e(C24971zW5 c24971zW5) {
            this.a = c24971zW5;
        }

        @Override // java.lang.Runnable
        public void run() {
            ShortcutInfoCompatSaverImpl.this.b.clear();
            Iterator it = ShortcutInfoCompatSaverImpl.this.c.values().iterator();
            while (it.hasNext()) {
                ((InterfaceFutureC15215jC3) it.next()).cancel(false);
            }
            ShortcutInfoCompatSaverImpl.this.c.clear();
            ShortcutInfoCompatSaverImpl.this.o(this.a);
        }
    }

    class f implements Callable {
        f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList call() {
            ArrayList arrayList = new ArrayList();
            Iterator it = ShortcutInfoCompatSaverImpl.this.b.values().iterator();
            while (it.hasNext()) {
                arrayList.add(new C15791kA6.b(((c.a) it.next()).c).a());
            }
            return arrayList;
        }
    }

    class g implements Callable {
        final /* synthetic */ String a;

        g(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c.a call() {
            return (c.a) ShortcutInfoCompatSaverImpl.this.b.get(this.a);
        }
    }

    class h implements Callable {
        final /* synthetic */ c.a a;

        h(c.a aVar) {
            this.a = aVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap call() {
            return BitmapFactory.decodeFile(this.a.b);
        }
    }

    class i implements Runnable {
        final /* synthetic */ List a;
        final /* synthetic */ C24971zW5 b;

        class a implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ InterfaceFutureC15215jC3 b;

            a(String str, InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
                this.a = str;
                this.b = interfaceFutureC15215jC3;
            }

            @Override // java.lang.Runnable
            public void run() throws ExecutionException, InterruptedException {
                ShortcutInfoCompatSaverImpl.this.c.remove(this.a);
                if (this.b.isCancelled()) {
                    return;
                }
                try {
                    this.b.get();
                } catch (Exception e) {
                    i.this.b.p(e);
                }
            }
        }

        i(List list, C24971zW5 c24971zW5) {
            this.a = list;
            this.b = c24971zW5;
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            for (C15791kA6 c15791kA6 : this.a) {
                Set setC = c15791kA6.c();
                if (setC != null && !setC.isEmpty()) {
                    c.a aVarF = ShortcutInfoCompatSaverImpl.this.f(c15791kA6);
                    Bitmap bitmapN = aVarF.b != null ? c15791kA6.e().n() : null;
                    String strF = c15791kA6.f();
                    ShortcutInfoCompatSaverImpl.this.b.put(strF, aVarF);
                    if (bitmapN != null) {
                        InterfaceFutureC15215jC3 interfaceFutureC15215jC3N = ShortcutInfoCompatSaverImpl.this.n(bitmapN, aVarF.b);
                        InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = (InterfaceFutureC15215jC3) ShortcutInfoCompatSaverImpl.this.c.put(strF, interfaceFutureC15215jC3N);
                        if (interfaceFutureC15215jC3 != null) {
                            interfaceFutureC15215jC3.cancel(false);
                        }
                        interfaceFutureC15215jC3N.j(new a(strF, interfaceFutureC15215jC3N), ShortcutInfoCompatSaverImpl.this.d);
                    }
                }
            }
            ShortcutInfoCompatSaverImpl.this.o(this.b);
        }
    }

    class j implements Runnable {
        final /* synthetic */ Bitmap a;
        final /* synthetic */ String b;

        j(Bitmap bitmap, String str) {
            this.a = bitmap;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            ShortcutInfoCompatSaverImpl.this.m(this.a, this.b);
        }
    }

    class k implements Runnable {
        final /* synthetic */ C24971zW5 a;
        final /* synthetic */ Runnable b;

        k(C24971zW5 c24971zW5, Runnable runnable) {
            this.a = c24971zW5;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.isCancelled()) {
                return;
            }
            try {
                this.b.run();
                this.a.o(null);
            } catch (Exception e) {
                this.a.p(e);
            }
        }
    }

    ShortcutInfoCompatSaverImpl(Context context, ExecutorService executorService, ExecutorService executorService2) {
        this.a = context.getApplicationContext();
        this.d = executorService;
        this.e = executorService2;
        File file = new File(context.getFilesDir(), "ShortcutInfoCompatSaver_share_targets");
        this.g = new File(file, "ShortcutInfoCompatSaver_share_targets_bitmaps");
        this.f = new File(file, "targets.xml");
        executorService.submit(new c(file));
    }

    static ExecutorService g() {
        return new ThreadPoolExecutor(0, 1, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static ShortcutInfoCompatSaverImpl getInstance(Context context) {
        if (i == null) {
            synchronized (h) {
                try {
                    if (i == null) {
                        i = new ShortcutInfoCompatSaverImpl(context, g(), g());
                    }
                } finally {
                }
            }
        }
        return i;
    }

    static boolean i(File file) {
        if (file.exists() && !file.isDirectory() && !file.delete()) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    private InterfaceFutureC15215jC3 p(Runnable runnable) {
        C24971zW5 c24971zW5R = C24971zW5.r();
        this.e.submit(new k(c24971zW5R, runnable));
        return c24971zW5R;
    }

    @Override // ir.nasim.EA6
    public List b() {
        return (List) this.d.submit(new f()).get();
    }

    @Override // ir.nasim.EA6
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public InterfaceFutureC15215jC3 a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new C15791kA6.b((C15791kA6) it.next()).a());
        }
        C24971zW5 c24971zW5R = C24971zW5.r();
        this.d.submit(new i(arrayList, c24971zW5R));
        return c24971zW5R;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.sharetarget.c.a f(ir.nasim.C15791kA6 r5) throws android.content.res.Resources.NotFoundException {
        /*
            r4 = this;
            androidx.core.graphics.drawable.IconCompat r0 = r5.e()
            r1 = 0
            if (r0 == 0) goto L3b
            int r2 = r0.q()
            r3 = 1
            if (r2 == r3) goto L25
            r3 = 2
            if (r2 == r3) goto L15
            r0 = 5
            if (r2 == r0) goto L25
            goto L3b
        L15:
            android.content.Context r2 = r4.a
            android.content.res.Resources r2 = r2.getResources()
            int r0 = r0.o()
            java.lang.String r0 = r2.getResourceName(r0)
            r2 = r1
            goto L3d
        L25:
            java.io.File r0 = new java.io.File
            java.io.File r2 = r4.g
            java.util.UUID r3 = java.util.UUID.randomUUID()
            java.lang.String r3 = r3.toString()
            r0.<init>(r2, r3)
            java.lang.String r0 = r0.getAbsolutePath()
            r2 = r0
            r0 = r1
            goto L3d
        L3b:
            r0 = r1
            r2 = r0
        L3d:
            ir.nasim.kA6$b r3 = new ir.nasim.kA6$b
            r3.<init>(r5)
            ir.nasim.kA6$b r5 = r3.e(r1)
            ir.nasim.kA6 r5 = r5.a()
            androidx.sharetarget.c$a r1 = new androidx.sharetarget.c$a
            r1.<init>(r5, r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.sharetarget.ShortcutInfoCompatSaverImpl.f(ir.nasim.kA6):androidx.sharetarget.c$a");
    }

    void h(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            c.a aVar = (c.a) it.next();
            if (!TextUtils.isEmpty(aVar.b)) {
                arrayList.add(aVar.b);
            }
        }
        for (File file : this.g.listFiles()) {
            if (!arrayList.contains(file.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public IconCompat j(String str) {
        int identifier;
        Bitmap bitmap;
        c.a aVar = (c.a) this.d.submit(new g(str)).get();
        if (aVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(aVar.a)) {
            try {
                identifier = this.a.getResources().getIdentifier(aVar.a, null, null);
            } catch (Exception unused) {
                identifier = 0;
            }
            if (identifier != 0) {
                return IconCompat.l(this.a, identifier);
            }
        }
        if (TextUtils.isEmpty(aVar.b) || (bitmap = (Bitmap) this.e.submit(new h(aVar)).get()) == null) {
            return null;
        }
        return IconCompat.i(bitmap);
    }

    @Override // ir.nasim.EA6
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public InterfaceFutureC15215jC3 c() {
        C24971zW5 c24971zW5R = C24971zW5.r();
        this.d.submit(new e(c24971zW5R));
        return c24971zW5R;
    }

    @Override // ir.nasim.EA6
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public InterfaceFutureC15215jC3 d(List list) {
        ArrayList arrayList = new ArrayList(list);
        C24971zW5 c24971zW5R = C24971zW5.r();
        this.d.submit(new d(arrayList, c24971zW5R));
        return c24971zW5R;
    }

    void m(Bitmap bitmap, String str) throws IOException {
        if (bitmap == null) {
            throw new IllegalArgumentException("bitmap is null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("path is empty");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            try {
                if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
                    fileOutputStream.close();
                    return;
                }
                Log.wtf("ShortcutInfoCompatSaver", "Unable to compress bitmap");
                throw new RuntimeException("Unable to compress bitmap for saving " + str);
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | OutOfMemoryError | RuntimeException e2) {
            Log.wtf("ShortcutInfoCompatSaver", "Unable to write bitmap to file", e2);
            throw new RuntimeException("Unable to write bitmap to file " + str, e2);
        }
    }

    InterfaceFutureC15215jC3 n(Bitmap bitmap, String str) {
        return p(new j(bitmap, str));
    }

    void o(C24971zW5 c24971zW5) {
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3P = p(new a(new ArrayList(this.b.values())));
        interfaceFutureC15215jC3P.j(new b(interfaceFutureC15215jC3P, c24971zW5), this.d);
    }
}
