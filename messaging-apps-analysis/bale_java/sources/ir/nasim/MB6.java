package ir.nasim;

import android.app.Activity;
import android.content.Context;
import androidx.window.layout.SidecarCompat;
import ir.nasim.InterfaceC5868Le2;
import ir.nasim.MB6;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public final class MB6 implements InterfaceC18147o98 {
    private static volatile MB6 d;
    private InterfaceC5868Le2 a;
    private final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public static final a c = new a(null);
    private static final ReentrantLock e = new ReentrantLock();

    public static final class a {
        private a() {
        }

        public final MB6 a(Context context) {
            AbstractC13042fc3.i(context, "context");
            if (MB6.d == null) {
                ReentrantLock reentrantLock = MB6.e;
                reentrantLock.lock();
                try {
                    if (MB6.d == null) {
                        MB6.d = new MB6(MB6.c.b(context));
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            MB6 mb6 = MB6.d;
            AbstractC13042fc3.f(mb6);
            return mb6;
        }

        public final InterfaceC5868Le2 b(Context context) {
            AbstractC13042fc3.i(context, "context");
            try {
                if (!c(SidecarCompat.f.c())) {
                    return null;
                }
                SidecarCompat sidecarCompat = new SidecarCompat(context);
                if (sidecarCompat.l()) {
                    return sidecarCompat;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final boolean c(VR7 vr7) {
            return vr7 != null && vr7.compareTo(VR7.f.a()) >= 0;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public final class b implements InterfaceC5868Le2.a {
        final /* synthetic */ MB6 a;

        public b(MB6 mb6) {
            AbstractC13042fc3.i(mb6, "this$0");
            this.a = mb6;
        }

        @Override // ir.nasim.InterfaceC5868Le2.a
        public void a(Activity activity, C25010za8 c25010za8) {
            AbstractC13042fc3.i(activity, "activity");
            AbstractC13042fc3.i(c25010za8, "newLayout");
            Iterator it = this.a.h().iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (AbstractC13042fc3.d(cVar.d(), activity)) {
                    cVar.b(c25010za8);
                }
            }
        }
    }

    public static final class c {
        private final Activity a;
        private final Executor b;
        private final InterfaceC25043ze1 c;
        private C25010za8 d;

        public c(Activity activity, Executor executor, InterfaceC25043ze1 interfaceC25043ze1) {
            AbstractC13042fc3.i(activity, "activity");
            AbstractC13042fc3.i(executor, "executor");
            AbstractC13042fc3.i(interfaceC25043ze1, "callback");
            this.a = activity;
            this.b = executor;
            this.c = interfaceC25043ze1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(c cVar, C25010za8 c25010za8) {
            AbstractC13042fc3.i(cVar, "this$0");
            AbstractC13042fc3.i(c25010za8, "$newLayoutInfo");
            cVar.c.accept(c25010za8);
        }

        public final void b(final C25010za8 c25010za8) {
            AbstractC13042fc3.i(c25010za8, "newLayoutInfo");
            this.d = c25010za8;
            this.b.execute(new Runnable() { // from class: ir.nasim.NB6
                @Override // java.lang.Runnable
                public final void run() {
                    MB6.c.c(this.a, c25010za8);
                }
            });
        }

        public final Activity d() {
            return this.a;
        }

        public final InterfaceC25043ze1 e() {
            return this.c;
        }

        public final C25010za8 f() {
            return this.d;
        }
    }

    public MB6(InterfaceC5868Le2 interfaceC5868Le2) {
        this.a = interfaceC5868Le2;
        InterfaceC5868Le2 interfaceC5868Le22 = this.a;
        if (interfaceC5868Le22 == null) {
            return;
        }
        interfaceC5868Le22.c(new b(this));
    }

    private final void f(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.b;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (AbstractC13042fc3.d(((c) it.next()).d(), activity)) {
                    return;
                }
            }
        }
        InterfaceC5868Le2 interfaceC5868Le2 = this.a;
        if (interfaceC5868Le2 == null) {
            return;
        }
        interfaceC5868Le2.b(activity);
    }

    private final boolean i(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.b;
        if ((copyOnWriteArrayList instanceof Collection) && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (AbstractC13042fc3.d(((c) it.next()).d(), activity)) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC18147o98
    public void a(InterfaceC25043ze1 interfaceC25043ze1) {
        AbstractC13042fc3.i(interfaceC25043ze1, "callback");
        synchronized (e) {
            try {
                if (g() == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = h().iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.e() == interfaceC25043ze1) {
                        AbstractC13042fc3.h(cVar, "callbackWrapper");
                        arrayList.add(cVar);
                    }
                }
                h().removeAll(arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    f(((c) it2.next()).d());
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.InterfaceC18147o98
    public void b(Activity activity, Executor executor, InterfaceC25043ze1 interfaceC25043ze1) {
        C25010za8 c25010za8F;
        Object next;
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(executor, "executor");
        AbstractC13042fc3.i(interfaceC25043ze1, "callback");
        ReentrantLock reentrantLock = e;
        reentrantLock.lock();
        try {
            InterfaceC5868Le2 interfaceC5868Le2G = g();
            if (interfaceC5868Le2G == null) {
                interfaceC25043ze1.accept(new C25010za8(AbstractC10360bX0.m()));
                return;
            }
            boolean zI = i(activity);
            c cVar = new c(activity, executor, interfaceC25043ze1);
            h().add(cVar);
            if (zI) {
                Iterator it = h().iterator();
                while (true) {
                    c25010za8F = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (AbstractC13042fc3.d(activity, ((c) next).d())) {
                            break;
                        }
                    }
                }
                c cVar2 = (c) next;
                if (cVar2 != null) {
                    c25010za8F = cVar2.f();
                }
                if (c25010za8F != null) {
                    cVar.b(c25010za8F);
                }
            } else {
                interfaceC5868Le2G.a(activity);
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final InterfaceC5868Le2 g() {
        return this.a;
    }

    public final CopyOnWriteArrayList h() {
        return this.b;
    }
}
