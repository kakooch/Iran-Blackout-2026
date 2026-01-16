package ir.nasim;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.j;
import ir.nasim.C23660xI4;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* renamed from: ir.nasim.xI4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C23660xI4 {
    private final Runnable a;
    private final InterfaceC25043ze1 b;
    private final BJ c;
    private AbstractC23070wI4 d;
    private OnBackInvokedCallback e;
    private OnBackInvokedDispatcher f;
    private boolean g;
    private boolean h;

    /* renamed from: ir.nasim.xI4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(TV tv) {
            AbstractC13042fc3.i(tv, "backEvent");
            C23660xI4.this.n(tv);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((TV) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xI4$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final void a(TV tv) {
            AbstractC13042fc3.i(tv, "backEvent");
            C23660xI4.this.m(tv);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((TV) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xI4$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        public final void a() {
            C23660xI4.this.l();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xI4$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        public final void a() {
            C23660xI4.this.k();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xI4$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        public final void a() {
            C23660xI4.this.l();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xI4$f */
    public static final class f {
        public static final f a = new f();

        private f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onBackInvoked");
            sa2.invoke();
        }

        public final OnBackInvokedCallback b(final SA2 sa2) {
            AbstractC13042fc3.i(sa2, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: ir.nasim.yI4
                public final void onBackInvoked() {
                    C23660xI4.f.c(sa2);
                }
            };
        }

        public final void d(Object obj, int i, Object obj2) {
            AbstractC13042fc3.i(obj, "dispatcher");
            AbstractC13042fc3.i(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) obj2);
        }

        public final void e(Object obj, Object obj2) {
            AbstractC13042fc3.i(obj, "dispatcher");
            AbstractC13042fc3.i(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* renamed from: ir.nasim.xI4$g */
    public static final class g {
        public static final g a = new g();

        /* renamed from: ir.nasim.xI4$g$a */
        public static final class a implements OnBackAnimationCallback {
            final /* synthetic */ UA2 a;
            final /* synthetic */ UA2 b;
            final /* synthetic */ SA2 c;
            final /* synthetic */ SA2 d;

            a(UA2 ua2, UA2 ua22, SA2 sa2, SA2 sa22) {
                this.a = ua2;
                this.b = ua22;
                this.c = sa2;
                this.d = sa22;
            }

            public void onBackCancelled() {
                this.d.invoke();
            }

            public void onBackInvoked() {
                this.c.invoke();
            }

            public void onBackProgressed(BackEvent backEvent) {
                AbstractC13042fc3.i(backEvent, "backEvent");
                this.b.invoke(new TV(backEvent));
            }

            public void onBackStarted(BackEvent backEvent) {
                AbstractC13042fc3.i(backEvent, "backEvent");
                this.a.invoke(new TV(backEvent));
            }
        }

        private g() {
        }

        public final OnBackInvokedCallback a(UA2 ua2, UA2 ua22, SA2 sa2, SA2 sa22) {
            AbstractC13042fc3.i(ua2, "onBackStarted");
            AbstractC13042fc3.i(ua22, "onBackProgressed");
            AbstractC13042fc3.i(sa2, "onBackInvoked");
            AbstractC13042fc3.i(sa22, "onBackCancelled");
            return new a(ua2, ua22, sa2, sa22);
        }
    }

    /* renamed from: ir.nasim.xI4$h */
    private final class h implements androidx.lifecycle.n, GE0 {
        private final androidx.lifecycle.j a;
        private final AbstractC23070wI4 b;
        private GE0 c;
        final /* synthetic */ C23660xI4 d;

        public h(C23660xI4 c23660xI4, androidx.lifecycle.j jVar, AbstractC23070wI4 abstractC23070wI4) {
            AbstractC13042fc3.i(jVar, "lifecycle");
            AbstractC13042fc3.i(abstractC23070wI4, "onBackPressedCallback");
            this.d = c23660xI4;
            this.a = jVar;
            this.b = abstractC23070wI4;
            jVar.a(this);
        }

        @Override // ir.nasim.GE0
        public void cancel() {
            this.a.d(this);
            this.b.i(this);
            GE0 ge0 = this.c;
            if (ge0 != null) {
                ge0.cancel();
            }
            this.c = null;
        }

        @Override // androidx.lifecycle.n
        public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
            AbstractC13042fc3.i(interfaceC18633oz3, "source");
            AbstractC13042fc3.i(aVar, "event");
            if (aVar == j.a.ON_START) {
                this.c = this.d.j(this.b);
                return;
            }
            if (aVar != j.a.ON_STOP) {
                if (aVar == j.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                GE0 ge0 = this.c;
                if (ge0 != null) {
                    ge0.cancel();
                }
            }
        }
    }

    /* renamed from: ir.nasim.xI4$i */
    private final class i implements GE0 {
        private final AbstractC23070wI4 a;
        final /* synthetic */ C23660xI4 b;

        public i(C23660xI4 c23660xI4, AbstractC23070wI4 abstractC23070wI4) {
            AbstractC13042fc3.i(abstractC23070wI4, "onBackPressedCallback");
            this.b = c23660xI4;
            this.a = abstractC23070wI4;
        }

        @Override // ir.nasim.GE0
        public void cancel() {
            this.b.c.remove(this.a);
            if (AbstractC13042fc3.d(this.b.d, this.a)) {
                this.a.c();
                this.b.d = null;
            }
            this.a.i(this);
            SA2 sa2B = this.a.b();
            if (sa2B != null) {
                sa2B.invoke();
            }
            this.a.k(null);
        }
    }

    /* renamed from: ir.nasim.xI4$j */
    /* synthetic */ class j extends EB2 implements SA2 {
        j(Object obj) {
            super(0, obj, C23660xI4.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C23660xI4) this.receiver).q();
        }
    }

    /* renamed from: ir.nasim.xI4$k */
    /* synthetic */ class k extends EB2 implements SA2 {
        k(Object obj) {
            super(0, obj, C23660xI4.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C23660xI4) this.receiver).q();
        }
    }

    public C23660xI4(Runnable runnable, InterfaceC25043ze1 interfaceC25043ze1) {
        this.a = runnable;
        this.b = interfaceC25043ze1;
        this.c = new BJ();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            this.e = i2 >= 34 ? g.a.a(new a(), new b(), new c(), new d()) : f.a.b(new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void k() {
        AbstractC23070wI4 abstractC23070wI4Previous;
        AbstractC23070wI4 abstractC23070wI4 = this.d;
        if (abstractC23070wI4 == null) {
            BJ bj = this.c;
            ListIterator listIterator = bj.listIterator(bj.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    abstractC23070wI4Previous = 0;
                    break;
                } else {
                    abstractC23070wI4Previous = listIterator.previous();
                    if (((AbstractC23070wI4) abstractC23070wI4Previous).g()) {
                        break;
                    }
                }
            }
            abstractC23070wI4 = abstractC23070wI4Previous;
        }
        this.d = null;
        if (abstractC23070wI4 != null) {
            abstractC23070wI4.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    public final void m(TV tv) {
        AbstractC23070wI4 abstractC23070wI4Previous;
        AbstractC23070wI4 abstractC23070wI4 = this.d;
        if (abstractC23070wI4 == null) {
            BJ bj = this.c;
            ListIterator listIterator = bj.listIterator(bj.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    abstractC23070wI4Previous = 0;
                    break;
                } else {
                    abstractC23070wI4Previous = listIterator.previous();
                    if (((AbstractC23070wI4) abstractC23070wI4Previous).g()) {
                        break;
                    }
                }
            }
            abstractC23070wI4 = abstractC23070wI4Previous;
        }
        if (abstractC23070wI4 != null) {
            abstractC23070wI4.e(tv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(TV tv) {
        Object objPrevious;
        BJ bj = this.c;
        ListIterator<E> listIterator = bj.listIterator(bj.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((AbstractC23070wI4) objPrevious).g()) {
                    break;
                }
            }
        }
        AbstractC23070wI4 abstractC23070wI4 = (AbstractC23070wI4) objPrevious;
        if (this.d != null) {
            k();
        }
        this.d = abstractC23070wI4;
        if (abstractC23070wI4 != null) {
            abstractC23070wI4.f(tv);
        }
    }

    private final void p(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f;
        OnBackInvokedCallback onBackInvokedCallback = this.e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z && !this.g) {
            f.a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.g = true;
        } else {
            if (z || !this.g) {
                return;
            }
            f.a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        boolean z = this.h;
        BJ bj = this.c;
        boolean z2 = false;
        if (!(bj instanceof Collection) || !bj.isEmpty()) {
            Iterator<E> it = bj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((AbstractC23070wI4) it.next()).g()) {
                    z2 = true;
                    break;
                }
            }
        }
        this.h = z2;
        if (z2 != z) {
            InterfaceC25043ze1 interfaceC25043ze1 = this.b;
            if (interfaceC25043ze1 != null) {
                interfaceC25043ze1.accept(Boolean.valueOf(z2));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                p(z2);
            }
        }
    }

    public final void h(InterfaceC18633oz3 interfaceC18633oz3, AbstractC23070wI4 abstractC23070wI4) {
        AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        AbstractC13042fc3.i(abstractC23070wI4, "onBackPressedCallback");
        androidx.lifecycle.j lifecycle = interfaceC18633oz3.getLifecycle();
        if (lifecycle.b() == j.b.DESTROYED) {
            return;
        }
        abstractC23070wI4.a(new h(this, lifecycle, abstractC23070wI4));
        q();
        abstractC23070wI4.k(new j(this));
    }

    public final void i(AbstractC23070wI4 abstractC23070wI4) {
        AbstractC13042fc3.i(abstractC23070wI4, "onBackPressedCallback");
        j(abstractC23070wI4);
    }

    public final GE0 j(AbstractC23070wI4 abstractC23070wI4) {
        AbstractC13042fc3.i(abstractC23070wI4, "onBackPressedCallback");
        this.c.add(abstractC23070wI4);
        i iVar = new i(this, abstractC23070wI4);
        abstractC23070wI4.a(iVar);
        q();
        abstractC23070wI4.k(new k(this));
        return iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void l() {
        AbstractC23070wI4 abstractC23070wI4Previous;
        AbstractC23070wI4 abstractC23070wI4 = this.d;
        if (abstractC23070wI4 == null) {
            BJ bj = this.c;
            ListIterator listIterator = bj.listIterator(bj.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    abstractC23070wI4Previous = 0;
                    break;
                } else {
                    abstractC23070wI4Previous = listIterator.previous();
                    if (((AbstractC23070wI4) abstractC23070wI4Previous).g()) {
                        break;
                    }
                }
            }
            abstractC23070wI4 = abstractC23070wI4Previous;
        }
        this.d = null;
        if (abstractC23070wI4 != null) {
            abstractC23070wI4.d();
            return;
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void o(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        AbstractC13042fc3.i(onBackInvokedDispatcher, "invoker");
        this.f = onBackInvokedDispatcher;
        p(this.h);
    }

    public /* synthetic */ C23660xI4(Runnable runnable, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? null : runnable);
    }

    public C23660xI4(Runnable runnable) {
        this(runnable, null);
    }
}
