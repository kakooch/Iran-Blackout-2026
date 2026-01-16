package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallationsException;
import ir.nasim.AbstractC10416ba3;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC23405wr7;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.AbstractC9078Yj7;
import ir.nasim.C17617nG5;
import ir.nasim.C4982Hj7;
import ir.nasim.C5490Jo2;
import ir.nasim.C6690Oo2;
import ir.nasim.C9407Zu3;
import ir.nasim.InterfaceC7875To2;
import ir.nasim.InterfaceC7959Tx5;
import ir.nasim.K03;
import ir.nasim.V45;
import ir.nasim.W45;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class c implements InterfaceC7875To2 {
    private static final Object m = new Object();
    private static final ThreadFactory n = new a();
    private final C5490Jo2 a;
    private final C6690Oo2 b;
    private final V45 c;
    private final h d;
    private final C9407Zu3 e;
    private final C17617nG5 f;
    private final Object g;
    private final ExecutorService h;
    private final ExecutorService i;
    private String j;
    private Set k;
    private final List l;

    class a implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.a.getAndIncrement())));
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[AbstractC23405wr7.b.values().length];
            b = iArr;
            try {
                iArr[AbstractC23405wr7.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[AbstractC23405wr7.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[AbstractC23405wr7.b.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[AbstractC10416ba3.b.values().length];
            a = iArr2;
            try {
                iArr2[AbstractC10416ba3.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AbstractC10416ba3.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    c(final C5490Jo2 c5490Jo2, InterfaceC7959Tx5 interfaceC7959Tx5) {
        this(new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), n), c5490Jo2, new C6690Oo2(c5490Jo2.j(), interfaceC7959Tx5), new V45(c5490Jo2), h.c(), new C9407Zu3(new InterfaceC7959Tx5() { // from class: ir.nasim.Qo2
            @Override // ir.nasim.InterfaceC7959Tx5
            public final Object get() {
                return com.google.firebase.installations.c.y(c5490Jo2);
            }
        }), new C17617nG5());
    }

    private String A(W45 w45) {
        if ((!this.a.l().equals("CHIME_ANDROID_SDK") && !this.a.t()) || !w45.m()) {
            return this.f.a();
        }
        String strF = o().f();
        return TextUtils.isEmpty(strF) ? this.f.a() : strF;
    }

    private W45 B(W45 w45) throws FirebaseInstallationsException {
        AbstractC10416ba3 abstractC10416ba3D = this.b.d(l(), w45.d(), t(), m(), (w45.d() == null || w45.d().length() != 11) ? null : o().i());
        int i = b.a[abstractC10416ba3D.e().ordinal()];
        if (i == 1) {
            return w45.s(abstractC10416ba3D.c(), abstractC10416ba3D.d(), this.d.b(), abstractC10416ba3D.b().c(), abstractC10416ba3D.b().d());
        }
        if (i == 2) {
            return w45.q("BAD CONFIG");
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.a.UNAVAILABLE);
    }

    private void C(Exception exc) {
        synchronized (this.g) {
            try {
                Iterator it = this.l.iterator();
                while (it.hasNext()) {
                    if (((g) it.next()).a(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void D(W45 w45) {
        synchronized (this.g) {
            try {
                Iterator it = this.l.iterator();
                while (it.hasNext()) {
                    if (((g) it.next()).b(w45)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private synchronized void E(String str) {
        this.j = str;
    }

    private synchronized void F(W45 w45, W45 w452) {
        if (this.k.size() != 0 && !TextUtils.equals(w45.d(), w452.d())) {
            Iterator it = this.k.iterator();
            if (it.hasNext()) {
                AbstractC18350oW3.a(it.next());
                w452.d();
                throw null;
            }
        }
    }

    private Task f() {
        C4982Hj7 c4982Hj7 = new C4982Hj7();
        h(new d(this.d, c4982Hj7));
        return c4982Hj7.a();
    }

    private Task g() {
        C4982Hj7 c4982Hj7 = new C4982Hj7();
        h(new e(c4982Hj7));
        return c4982Hj7.a();
    }

    private void h(g gVar) {
        synchronized (this.g) {
            this.l.add(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void v(boolean z) {
        W45 w45B;
        W45 w45R = r();
        try {
            if (w45R.i() || w45R.l()) {
                w45B = B(w45R);
            } else {
                if (!z && !this.d.f(w45R)) {
                    return;
                }
                w45B = k(w45R);
            }
            u(w45B);
            F(w45R, w45B);
            if (w45B.k()) {
                E(w45B.d());
            }
            if (w45B.i()) {
                C(new FirebaseInstallationsException(FirebaseInstallationsException.a.BAD_CONFIG));
            } else if (w45B.j()) {
                C(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
            } else {
                D(w45B);
            }
        } catch (FirebaseInstallationsException e) {
            C(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void x(final boolean z) {
        W45 w45S = s();
        if (z) {
            w45S = w45S.p();
        }
        D(w45S);
        this.i.execute(new Runnable() { // from class: ir.nasim.Ro2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.v(z);
            }
        });
    }

    private W45 k(W45 w45) throws FirebaseInstallationsException {
        AbstractC23405wr7 abstractC23405wr7E = this.b.e(l(), w45.d(), t(), w45.f());
        int i = b.b[abstractC23405wr7E.b().ordinal()];
        if (i == 1) {
            return w45.o(abstractC23405wr7E.c(), abstractC23405wr7E.d(), this.d.b());
        }
        if (i == 2) {
            return w45.q("BAD CONFIG");
        }
        if (i != 3) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.a.UNAVAILABLE);
        }
        E(null);
        return w45.r();
    }

    private synchronized String n() {
        return this.j;
    }

    private K03 o() {
        return (K03) this.e.get();
    }

    public static c p() {
        return q(C5490Jo2.k());
    }

    public static c q(C5490Jo2 c5490Jo2) {
        AbstractC3795Cj5.b(c5490Jo2 != null, "Null is not a valid value of FirebaseApp.");
        return (c) c5490Jo2.i(InterfaceC7875To2.class);
    }

    /* JADX WARN: Finally extract failed */
    private W45 r() {
        W45 w45D;
        synchronized (m) {
            try {
                com.google.firebase.installations.b bVarA = com.google.firebase.installations.b.a(this.a.j(), "generatefid.lock");
                try {
                    w45D = this.c.d();
                    if (bVarA != null) {
                        bVarA.b();
                    }
                } catch (Throwable th) {
                    if (bVarA != null) {
                        bVarA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return w45D;
    }

    /* JADX WARN: Finally extract failed */
    private W45 s() {
        W45 w45D;
        synchronized (m) {
            try {
                com.google.firebase.installations.b bVarA = com.google.firebase.installations.b.a(this.a.j(), "generatefid.lock");
                try {
                    w45D = this.c.d();
                    if (w45D.j()) {
                        w45D = this.c.b(w45D.t(A(w45D)));
                    }
                    if (bVarA != null) {
                        bVarA.b();
                    }
                } catch (Throwable th) {
                    if (bVarA != null) {
                        bVarA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return w45D;
    }

    /* JADX WARN: Finally extract failed */
    private void u(W45 w45) {
        synchronized (m) {
            try {
                com.google.firebase.installations.b bVarA = com.google.firebase.installations.b.a(this.a.j(), "generatefid.lock");
                try {
                    this.c.b(w45);
                    if (bVarA != null) {
                        bVarA.b();
                    }
                } catch (Throwable th) {
                    if (bVarA != null) {
                        bVarA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        x(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K03 y(C5490Jo2 c5490Jo2) {
        return new K03(c5490Jo2);
    }

    private void z() {
        AbstractC3795Cj5.g(m(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AbstractC3795Cj5.g(t(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AbstractC3795Cj5.g(l(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AbstractC3795Cj5.b(h.h(m()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AbstractC3795Cj5.b(h.g(l()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @Override // ir.nasim.InterfaceC7875To2
    public Task a(final boolean z) {
        z();
        Task taskF = f();
        this.h.execute(new Runnable() { // from class: ir.nasim.So2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x(z);
            }
        });
        return taskF;
    }

    @Override // ir.nasim.InterfaceC7875To2
    public Task getId() {
        z();
        String strN = n();
        if (strN != null) {
            return AbstractC9078Yj7.e(strN);
        }
        Task taskG = g();
        this.h.execute(new Runnable() { // from class: ir.nasim.Po2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w();
            }
        });
        return taskG;
    }

    String l() {
        return this.a.m().b();
    }

    String m() {
        return this.a.m().c();
    }

    String t() {
        return this.a.m().e();
    }

    c(ExecutorService executorService, C5490Jo2 c5490Jo2, C6690Oo2 c6690Oo2, V45 v45, h hVar, C9407Zu3 c9407Zu3, C17617nG5 c17617nG5) {
        this.g = new Object();
        this.k = new HashSet();
        this.l = new ArrayList();
        this.a = c5490Jo2;
        this.b = c6690Oo2;
        this.c = v45;
        this.d = hVar;
        this.e = c9407Zu3;
        this.f = c17617nG5;
        this.h = executorService;
        this.i = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), n);
    }
}
