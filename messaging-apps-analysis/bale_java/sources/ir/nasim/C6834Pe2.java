package ir.nasim;

import android.app.Activity;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/* renamed from: ir.nasim.Pe2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6834Pe2 implements InterfaceC18147o98 {
    private final WindowLayoutComponent a;
    private final ReentrantLock b;
    private final Map c;
    private final Map d;

    /* renamed from: ir.nasim.Pe2$a */
    private static final class a implements Consumer {
        private final Activity a;
        private final ReentrantLock b;
        private C25010za8 c;
        private final Set d;

        public a(Activity activity) {
            AbstractC13042fc3.i(activity, "activity");
            this.a = activity;
            this.b = new ReentrantLock();
            this.d = new LinkedHashSet();
        }

        @Override // java.util.function.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(WindowLayoutInfo windowLayoutInfo) {
            AbstractC13042fc3.i(windowLayoutInfo, "value");
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                this.c = C8253Ve2.a.b(this.a, windowLayoutInfo);
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    ((InterfaceC25043ze1) it.next()).accept(this.c);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final void b(InterfaceC25043ze1 interfaceC25043ze1) {
            AbstractC13042fc3.i(interfaceC25043ze1, "listener");
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                C25010za8 c25010za8 = this.c;
                if (c25010za8 != null) {
                    interfaceC25043ze1.accept(c25010za8);
                }
                this.d.add(interfaceC25043ze1);
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean c() {
            return this.d.isEmpty();
        }

        public final void d(InterfaceC25043ze1 interfaceC25043ze1) {
            AbstractC13042fc3.i(interfaceC25043ze1, "listener");
            ReentrantLock reentrantLock = this.b;
            reentrantLock.lock();
            try {
                this.d.remove(interfaceC25043ze1);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public C6834Pe2(WindowLayoutComponent windowLayoutComponent) {
        AbstractC13042fc3.i(windowLayoutComponent, "component");
        this.a = windowLayoutComponent;
        this.b = new ReentrantLock();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    @Override // ir.nasim.InterfaceC18147o98
    public void a(InterfaceC25043ze1 interfaceC25043ze1) {
        AbstractC13042fc3.i(interfaceC25043ze1, "callback");
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            Activity activity = (Activity) this.d.get(interfaceC25043ze1);
            if (activity == null) {
                reentrantLock.unlock();
                return;
            }
            a aVar = (a) this.c.get(activity);
            if (aVar == null) {
                reentrantLock.unlock();
                return;
            }
            aVar.d(interfaceC25043ze1);
            if (aVar.c()) {
                this.a.removeWindowLayoutInfoListener(aVar);
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC18147o98
    public void b(Activity activity, Executor executor, InterfaceC25043ze1 interfaceC25043ze1) {
        C19938rB7 c19938rB7;
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(executor, "executor");
        AbstractC13042fc3.i(interfaceC25043ze1, "callback");
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            a aVar = (a) this.c.get(activity);
            if (aVar == null) {
                c19938rB7 = null;
            } else {
                aVar.b(interfaceC25043ze1);
                this.d.put(interfaceC25043ze1, activity);
                c19938rB7 = C19938rB7.a;
            }
            if (c19938rB7 == null) {
                a aVar2 = new a(activity);
                this.c.put(activity, aVar2);
                this.d.put(interfaceC25043ze1, activity);
                aVar2.b(interfaceC25043ze1);
                this.a.addWindowLayoutInfoListener(activity, aVar2);
            }
            C19938rB7 c19938rB72 = C19938rB7.a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
