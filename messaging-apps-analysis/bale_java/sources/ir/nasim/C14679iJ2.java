package ir.nasim;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.j;

/* renamed from: ir.nasim.iJ2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14679iJ2 extends androidx.lifecycle.j {
    public static final C14679iJ2 b = new C14679iJ2();
    private static final a c = new a();

    /* renamed from: ir.nasim.iJ2$a */
    public static final class a implements InterfaceC18633oz3 {
        a() {
        }

        @Override // ir.nasim.InterfaceC18633oz3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C14679iJ2 getLifecycle() {
            return C14679iJ2.b;
        }
    }

    private C14679iJ2() {
    }

    @Override // androidx.lifecycle.j
    public void a(InterfaceC18042nz3 interfaceC18042nz3) {
        if (!(interfaceC18042nz3 instanceof DefaultLifecycleObserver)) {
            throw new IllegalArgumentException((interfaceC18042nz3 + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
        }
        DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) interfaceC18042nz3;
        a aVar = c;
        defaultLifecycleObserver.onCreate(aVar);
        defaultLifecycleObserver.onStart(aVar);
        defaultLifecycleObserver.onResume(aVar);
    }

    @Override // androidx.lifecycle.j
    public j.b b() {
        return j.b.RESUMED;
    }

    public String toString() {
        return "coil.request.GlobalLifecycle";
    }

    @Override // androidx.lifecycle.j
    public void d(InterfaceC18042nz3 interfaceC18042nz3) {
    }
}
