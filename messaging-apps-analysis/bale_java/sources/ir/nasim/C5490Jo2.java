package ir.nasim;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.internal.ComponentCallbacks2C2057a;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.Jo2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C5490Jo2 {
    private static final Object k = new Object();
    private static final Executor l = new d();
    static final Map m = new KJ();
    private final Context a;
    private final String b;
    private final C11328cp2 c;
    private final C15105j11 d;
    private final C9407Zu3 g;
    private final InterfaceC7959Tx5 h;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final AtomicBoolean f = new AtomicBoolean();
    private final List i = new CopyOnWriteArrayList();
    private final List j = new CopyOnWriteArrayList();

    /* renamed from: ir.nasim.Jo2$b */
    public interface b {
        void a(boolean z);
    }

    /* renamed from: ir.nasim.Jo2$c */
    private static class c implements ComponentCallbacks2C2057a.InterfaceC0172a {
        private static AtomicReference a = new AtomicReference();

        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(Context context) {
            if (AbstractC3993Df5.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (a.get() == null) {
                    c cVar = new c();
                    if (AbstractC16775lq5.a(a, null, cVar)) {
                        ComponentCallbacks2C2057a.c(application);
                        ComponentCallbacks2C2057a.b().a(cVar);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.ComponentCallbacks2C2057a.InterfaceC0172a
        public void a(boolean z) {
            synchronized (C5490Jo2.k) {
                try {
                    Iterator it = new ArrayList(C5490Jo2.m.values()).iterator();
                    while (it.hasNext()) {
                        C5490Jo2 c5490Jo2 = (C5490Jo2) it.next();
                        if (c5490Jo2.e.get()) {
                            c5490Jo2.x(z);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: ir.nasim.Jo2$d */
    private static class d implements Executor {
        private static final Handler a = new Handler(Looper.getMainLooper());

        private d() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.post(runnable);
        }
    }

    /* renamed from: ir.nasim.Jo2$e */
    private static class e extends BroadcastReceiver {
        private static AtomicReference b = new AtomicReference();
        private final Context a;

        public e(Context context) {
            this.a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (b.get() == null) {
                e eVar = new e(context);
                if (AbstractC16775lq5.a(b, null, eVar)) {
                    context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (C5490Jo2.k) {
                try {
                    Iterator it = C5490Jo2.m.values().iterator();
                    while (it.hasNext()) {
                        ((C5490Jo2) it.next()).o();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            c();
        }
    }

    protected C5490Jo2(final Context context, String str, C11328cp2 c11328cp2) {
        this.a = (Context) AbstractC3795Cj5.j(context);
        this.b = AbstractC3795Cj5.f(str);
        this.c = (C11328cp2) AbstractC3795Cj5.j(c11328cp2);
        AbstractC11949dp2.b("Firebase");
        AbstractC11949dp2.b("ComponentDiscovery");
        List listB = X01.c(context, ComponentDiscoveryService.class).b();
        AbstractC11949dp2.a();
        AbstractC11949dp2.b("Runtime");
        C15105j11 c15105j11E = C15105j11.h(l).d(listB).c(new FirebaseCommonRegistrar()).b(I01.q(context, Context.class, new Class[0])).b(I01.q(this, C5490Jo2.class, new Class[0])).b(I01.q(c11328cp2, C11328cp2.class, new Class[0])).g(new C10064b11()).e();
        this.d = c15105j11E;
        AbstractC11949dp2.a();
        this.g = new C9407Zu3(new InterfaceC7959Tx5() { // from class: ir.nasim.Ho2
            @Override // ir.nasim.InterfaceC7959Tx5
            public final Object get() {
                return this.a.u(context);
            }
        });
        this.h = c15105j11E.d(C12822fE1.class);
        g(new b() { // from class: ir.nasim.Io2
            @Override // ir.nasim.C5490Jo2.b
            public final void a(boolean z) {
                this.a.v(z);
            }
        });
        AbstractC11949dp2.a();
    }

    private void h() {
        AbstractC3795Cj5.n(!this.f.get(), "FirebaseApp was deleted");
    }

    public static C5490Jo2 k() {
        C5490Jo2 c5490Jo2;
        synchronized (k) {
            try {
                c5490Jo2 = (C5490Jo2) m.get("[DEFAULT]");
                if (c5490Jo2 == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + AbstractC7666Sr5.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c5490Jo2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!FI7.a(this.a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + l());
            e.b(this.a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + l());
        this.d.k(t());
        ((C12822fE1) this.h.get()).n();
    }

    public static C5490Jo2 p(Context context) {
        synchronized (k) {
            try {
                if (m.containsKey("[DEFAULT]")) {
                    return k();
                }
                C11328cp2 c11328cp2A = C11328cp2.a(context);
                if (c11328cp2A == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return q(context, c11328cp2A);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static C5490Jo2 q(Context context, C11328cp2 c11328cp2) {
        return r(context, c11328cp2, "[DEFAULT]");
    }

    public static C5490Jo2 r(Context context, C11328cp2 c11328cp2, String str) {
        C5490Jo2 c5490Jo2;
        c.c(context);
        String strW = w(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (k) {
            Map map = m;
            AbstractC3795Cj5.n(!map.containsKey(strW), "FirebaseApp name " + strW + " already exists!");
            AbstractC3795Cj5.k(context, "Application context cannot be null.");
            c5490Jo2 = new C5490Jo2(context, strW, c11328cp2);
            map.put(strW, c5490Jo2);
        }
        c5490Jo2.o();
        return c5490Jo2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C7725Sy1 u(Context context) {
        return new C7725Sy1(context, n(), (InterfaceC17444my5) this.d.a(InterfaceC17444my5.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(boolean z) {
        if (z) {
            return;
        }
        ((C12822fE1) this.h.get()).n();
    }

    private static String w(String str) {
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(z);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof C5490Jo2) {
            return this.b.equals(((C5490Jo2) obj).l());
        }
        return false;
    }

    public void g(b bVar) {
        h();
        if (this.e.get() && ComponentCallbacks2C2057a.b().d()) {
            bVar.a(true);
        }
        this.i.add(bVar);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public Object i(Class cls) {
        h();
        return this.d.a(cls);
    }

    public Context j() {
        h();
        return this.a;
    }

    public String l() {
        h();
        return this.b;
    }

    public C11328cp2 m() {
        h();
        return this.c;
    }

    public String n() {
        return AbstractC15184j90.a(l().getBytes(Charset.defaultCharset())) + "+" + AbstractC15184j90.a(m().c().getBytes(Charset.defaultCharset()));
    }

    public boolean s() {
        h();
        return ((C7725Sy1) this.g.get()).b();
    }

    public boolean t() {
        return "[DEFAULT]".equals(l());
    }

    public String toString() {
        return DG4.c(this).a("name", this.b).a("options", this.c).toString();
    }
}
