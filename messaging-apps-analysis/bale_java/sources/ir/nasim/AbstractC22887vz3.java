package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.j;

/* renamed from: ir.nasim.vz3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22887vz3 implements InterfaceC10358bW7 {
    private static final b d = new b(null);
    private static final Handler e = new Handler(Looper.getMainLooper());
    private final UA2 a;
    private final UA2 b;
    private InterfaceC9764aW7 c;

    /* renamed from: ir.nasim.vz3$a */
    private static final class a implements DefaultLifecycleObserver {
        private final AbstractC22887vz3 a;

        public a(AbstractC22887vz3 abstractC22887vz3) {
            AbstractC13042fc3.i(abstractC22887vz3, "property");
            this.a = abstractC22887vz3;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onCreate(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onDestroy(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
            this.a.h();
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onPause(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onResume(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStart(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStop(InterfaceC18633oz3 interfaceC18633oz3) {
            AbstractC13042fc3.i(interfaceC18633oz3, "owner");
        }
    }

    /* renamed from: ir.nasim.vz3$b */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public AbstractC22887vz3(UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(ua2, "viewBinder");
        AbstractC13042fc3.i(ua22, "onViewDestroyed");
        this.a = ua2;
        this.b = ua22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AbstractC22887vz3 abstractC22887vz3) {
        AbstractC13042fc3.i(abstractC22887vz3, "this$0");
        abstractC22887vz3.d();
    }

    private final void j(Object obj) {
        androidx.lifecycle.j lifecycle = e(obj).getLifecycle();
        AbstractC13042fc3.h(lifecycle, "getLifecycleOwner(thisRef).lifecycle");
        if (lifecycle.b() == j.b.DESTROYED) {
            throw new IllegalStateException("Access to viewBinding after Lifecycle is destroyed or hasn't created yet. The instance of viewBinding will be not cached.".toString());
        }
    }

    public void d() {
        AbstractC20046rN7.a();
        InterfaceC9764aW7 interfaceC9764aW7 = this.c;
        this.c = null;
        if (interfaceC9764aW7 != null) {
            this.b.invoke(interfaceC9764aW7);
        }
    }

    protected abstract InterfaceC18633oz3 e(Object obj);

    @Override // ir.nasim.InterfaceC23661xI5
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterfaceC9764aW7 a(Object obj, InterfaceC5239Im3 interfaceC5239Im3) {
        AbstractC13042fc3.i(obj, "thisRef");
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        AbstractC20046rN7.b("access to ViewBinding from non UI (Main) thread");
        InterfaceC9764aW7 interfaceC9764aW7 = this.c;
        if (interfaceC9764aW7 != null) {
            return interfaceC9764aW7;
        }
        if (!g(obj)) {
            throw new IllegalStateException(k(obj).toString());
        }
        if (C10974cW7.a.a()) {
            j(obj);
        }
        androidx.lifecycle.j lifecycle = e(obj).getLifecycle();
        AbstractC13042fc3.h(lifecycle, "getLifecycleOwner(thisRef).lifecycle");
        if (lifecycle.b() == j.b.DESTROYED) {
            this.c = null;
            Log.w("ViewBindingProperty", "Access to viewBinding after Lifecycle is destroyed or hasn't created yet. The instance of viewBinding will be not cached.");
            return (InterfaceC9764aW7) this.a.invoke(obj);
        }
        InterfaceC9764aW7 interfaceC9764aW72 = (InterfaceC9764aW7) this.a.invoke(obj);
        lifecycle.a(new a(this));
        this.c = interfaceC9764aW72;
        return interfaceC9764aW72;
    }

    protected boolean g(Object obj) {
        AbstractC13042fc3.i(obj, "thisRef");
        return true;
    }

    public final void h() {
        if (e.post(new Runnable() { // from class: ir.nasim.uz3
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC22887vz3.i(this.a);
            }
        })) {
            return;
        }
        d();
    }

    protected String k(Object obj) {
        AbstractC13042fc3.i(obj, "thisRef");
        return "Host view isn't ready. LifecycleViewBindingProperty.isViewInitialized return false";
    }
}
