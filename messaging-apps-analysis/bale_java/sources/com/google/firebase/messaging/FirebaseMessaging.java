package com.google.firebase.messaging;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.v;
import com.google.firebase.messaging.z;
import ir.nasim.AbstractC17203ma2;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.AbstractC7964Ty1;
import ir.nasim.AbstractC9078Yj7;
import ir.nasim.C4982Hj7;
import ir.nasim.C5490Jo2;
import ir.nasim.G07;
import ir.nasim.InterfaceC13497gK4;
import ir.nasim.InterfaceC17465n07;
import ir.nasim.InterfaceC6025Lv7;
import ir.nasim.InterfaceC7276Ra2;
import ir.nasim.InterfaceC7875To2;
import ir.nasim.InterfaceC7959Tx5;
import ir.nasim.InterfaceC8343Vo2;
import ir.nasim.ThreadFactoryC8579Wo4;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class FirebaseMessaging {
    private static final long n = TimeUnit.HOURS.toSeconds(8);
    private static z o;
    static InterfaceC6025Lv7 p;
    static ScheduledExecutorService q;
    private final C5490Jo2 a;
    private final InterfaceC7875To2 b;
    private final Context c;
    private final C2376m d;
    private final v e;
    private final a f;
    private final Executor g;
    private final Executor h;
    private final Executor i;
    private final Task j;
    private final o k;
    private boolean l;
    private final Application.ActivityLifecycleCallbacks m;

    /* JADX INFO: Access modifiers changed from: private */
    class a {
        private final InterfaceC17465n07 a;
        private boolean b;
        private InterfaceC7276Ra2 c;
        private Boolean d;

        a(InterfaceC17465n07 interfaceC17465n07) {
            this.a = interfaceC17465n07;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(AbstractC17203ma2 abstractC17203ma2) {
            if (c()) {
                FirebaseMessaging.this.F();
            }
        }

        private Boolean e() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context contextJ = FirebaseMessaging.this.a.j();
            SharedPreferences sharedPreferences = contextJ.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = contextJ.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(contextJ.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        synchronized void b() {
            try {
                if (this.b) {
                    return;
                }
                Boolean boolE = e();
                this.d = boolE;
                if (boolE == null) {
                    InterfaceC7276Ra2 interfaceC7276Ra2 = new InterfaceC7276Ra2() { // from class: com.google.firebase.messaging.k
                        @Override // ir.nasim.InterfaceC7276Ra2
                        public final void a(AbstractC17203ma2 abstractC17203ma2) {
                            this.a.d(abstractC17203ma2);
                        }
                    };
                    this.c = interfaceC7276Ra2;
                    this.a.a(AbstractC7964Ty1.class, interfaceC7276Ra2);
                }
                this.b = true;
            } catch (Throwable th) {
                throw th;
            }
        }

        synchronized boolean c() {
            Boolean bool;
            try {
                b();
                bool = this.d;
            } catch (Throwable th) {
                throw th;
            }
            return bool != null ? bool.booleanValue() : FirebaseMessaging.this.a.s();
        }
    }

    FirebaseMessaging(C5490Jo2 c5490Jo2, InterfaceC8343Vo2 interfaceC8343Vo2, InterfaceC7959Tx5 interfaceC7959Tx5, InterfaceC7959Tx5 interfaceC7959Tx52, InterfaceC7875To2 interfaceC7875To2, InterfaceC6025Lv7 interfaceC6025Lv7, InterfaceC17465n07 interfaceC17465n07) {
        this(c5490Jo2, interfaceC8343Vo2, interfaceC7959Tx5, interfaceC7959Tx52, interfaceC7875To2, interfaceC6025Lv7, interfaceC17465n07, new o(c5490Jo2.j()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        if (u()) {
            F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(E e) {
        if (u()) {
            e.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        r.c(this.c);
    }

    private synchronized void E() {
        if (!this.l) {
            G(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (H(r())) {
            E();
        }
    }

    @Keep
    static synchronized FirebaseMessaging getInstance(C5490Jo2 c5490Jo2) {
        FirebaseMessaging firebaseMessaging;
        firebaseMessaging = (FirebaseMessaging) c5490Jo2.i(FirebaseMessaging.class);
        AbstractC3795Cj5.k(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }

    public static synchronized FirebaseMessaging n() {
        return getInstance(C5490Jo2.k());
    }

    private static synchronized z o(Context context) {
        try {
            if (o == null) {
                o = new z(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return o;
    }

    private String p() {
        return "[DEFAULT]".equals(this.a.l()) ? "" : this.a.n();
    }

    public static InterfaceC6025Lv7 s() {
        return p;
    }

    private void t(String str) {
        if ("[DEFAULT]".equals(this.a.l())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Invoking onNewToken for app: " + this.a.l());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new C2367d(this.c).i(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task w(final String str, final z.a aVar) {
        return this.d.f().q(this.i, new G07() { // from class: com.google.firebase.messaging.j
            @Override // ir.nasim.G07
            public final Task a(Object obj) {
                return this.a.x(str, aVar, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task x(String str, z.a aVar, String str2) {
        o(this.c).g(p(), str, str2, this.k.a());
        if (aVar == null || !str2.equals(aVar.a)) {
            t(str2);
        }
        return AbstractC9078Yj7.e(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(C4982Hj7 c4982Hj7) {
        try {
            AbstractC9078Yj7.a(this.d.c());
            o(this.c).d(p(), o.c(this.a));
            c4982Hj7.c(null);
        } catch (Exception e) {
            c4982Hj7.b(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(C4982Hj7 c4982Hj7) {
        try {
            c4982Hj7.c(j());
        } catch (Exception e) {
            c4982Hj7.b(e);
        }
    }

    synchronized void D(boolean z) {
        this.l = z;
    }

    synchronized void G(long j) {
        l(new A(this, Math.min(Math.max(30L, 2 * j), n)), j);
        this.l = true;
    }

    boolean H(z.a aVar) {
        return aVar == null || aVar.b(this.k.a());
    }

    String j() throws IOException {
        final z.a aVarR = r();
        if (!H(aVarR)) {
            return aVarR.a;
        }
        final String strC = o.c(this.a);
        try {
            return (String) AbstractC9078Yj7.a(this.e.b(strC, new v.a() { // from class: com.google.firebase.messaging.i
                @Override // com.google.firebase.messaging.v.a
                public final Task start() {
                    return this.a.w(strC, aVarR);
                }
            }));
        } catch (InterruptedException | ExecutionException e) {
            throw new IOException(e);
        }
    }

    public Task k() {
        if (r() == null) {
            return AbstractC9078Yj7.e(null);
        }
        final C4982Hj7 c4982Hj7 = new C4982Hj7();
        AbstractC2368e.e().execute(new Runnable() { // from class: ir.nasim.ap2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.y(c4982Hj7);
            }
        });
        return c4982Hj7.a();
    }

    void l(Runnable runnable, long j) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (q == null) {
                    q = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC8579Wo4("TAG"));
                }
                q.schedule(runnable, j, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    Context m() {
        return this.c;
    }

    public Task q() {
        final C4982Hj7 c4982Hj7 = new C4982Hj7();
        this.g.execute(new Runnable() { // from class: ir.nasim.Zo2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z(c4982Hj7);
            }
        });
        return c4982Hj7.a();
    }

    z.a r() {
        return o(this.c).e(p(), o.c(this.a));
    }

    public boolean u() {
        return this.f.c();
    }

    boolean v() {
        return this.k.g();
    }

    FirebaseMessaging(C5490Jo2 c5490Jo2, InterfaceC8343Vo2 interfaceC8343Vo2, InterfaceC7959Tx5 interfaceC7959Tx5, InterfaceC7959Tx5 interfaceC7959Tx52, InterfaceC7875To2 interfaceC7875To2, InterfaceC6025Lv7 interfaceC6025Lv7, InterfaceC17465n07 interfaceC17465n07, o oVar) {
        this(c5490Jo2, interfaceC8343Vo2, interfaceC7875To2, interfaceC6025Lv7, interfaceC17465n07, oVar, new C2376m(c5490Jo2, oVar, interfaceC7959Tx5, interfaceC7959Tx52, interfaceC7875To2), AbstractC2368e.f(), AbstractC2368e.c(), AbstractC2368e.b());
    }

    FirebaseMessaging(C5490Jo2 c5490Jo2, InterfaceC8343Vo2 interfaceC8343Vo2, InterfaceC7875To2 interfaceC7875To2, InterfaceC6025Lv7 interfaceC6025Lv7, InterfaceC17465n07 interfaceC17465n07, o oVar, C2376m c2376m, Executor executor, Executor executor2, Executor executor3) {
        this.l = false;
        p = interfaceC6025Lv7;
        this.a = c5490Jo2;
        this.b = interfaceC7875To2;
        this.f = new a(interfaceC17465n07);
        Context contextJ = c5490Jo2.j();
        this.c = contextJ;
        C2370g c2370g = new C2370g();
        this.m = c2370g;
        this.k = oVar;
        this.h = executor;
        this.d = c2376m;
        this.e = new v(executor);
        this.g = executor2;
        this.i = executor3;
        Context contextJ2 = c5490Jo2.j();
        if (contextJ2 instanceof Application) {
            ((Application) contextJ2).registerActivityLifecycleCallbacks(c2370g);
        } else {
            Log.w("FirebaseMessaging", "Context " + contextJ2 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (interfaceC8343Vo2 != null) {
            interfaceC8343Vo2.a(new InterfaceC8343Vo2.a() { // from class: ir.nasim.Wo2
            });
        }
        executor2.execute(new Runnable() { // from class: ir.nasim.Xo2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.A();
            }
        });
        Task taskE = E.e(this, oVar, c2376m, contextJ, AbstractC2368e.g());
        this.j = taskE;
        taskE.g(executor2, new InterfaceC13497gK4() { // from class: com.google.firebase.messaging.h
            @Override // ir.nasim.InterfaceC13497gK4
            public final void onSuccess(Object obj) {
                this.a.B((E) obj);
            }
        });
        executor2.execute(new Runnable() { // from class: ir.nasim.Yo2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.C();
            }
        });
    }
}
