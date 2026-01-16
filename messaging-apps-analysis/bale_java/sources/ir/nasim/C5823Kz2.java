package ir.nasim;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: ir.nasim.Kz2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C5823Kz2 extends AbstractC22887vz3 {
    private final boolean f;
    private FragmentManager.l g;
    private Reference h;

    /* renamed from: ir.nasim.Kz2$a */
    private final class a extends FragmentManager.l {
        private Reference a;
        final /* synthetic */ C5823Kz2 b;

        public a(C5823Kz2 c5823Kz2, Fragment fragment) {
            AbstractC13042fc3.i(c5823Kz2, "this$0");
            AbstractC13042fc3.i(fragment, "fragment");
            this.b = c5823Kz2;
            this.a = new WeakReference(fragment);
        }

        @Override // androidx.fragment.app.FragmentManager.l
        public void d(FragmentManager fragmentManager, Fragment fragment) {
            AbstractC13042fc3.i(fragmentManager, "fm");
            AbstractC13042fc3.i(fragment, "f");
            if (this.a.get() == fragment) {
                this.b.h();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5823Kz2(boolean z, UA2 ua2, UA2 ua22) {
        super(ua2, ua22);
        AbstractC13042fc3.i(ua2, "viewBinder");
        AbstractC13042fc3.i(ua22, "onViewDestroyed");
        this.f = z;
    }

    private final void o(Fragment fragment) {
        if (this.g != null) {
            return;
        }
        FragmentManager fragmentManagerV5 = fragment.V5();
        this.h = new WeakReference(fragmentManagerV5);
        AbstractC13042fc3.h(fragmentManagerV5, "fragment.parentFragmentM…akReference(fm)\n        }");
        a aVar = new a(this, fragment);
        fragmentManagerV5.t1(aVar, false);
        C19938rB7 c19938rB7 = C19938rB7.a;
        this.g = aVar;
    }

    @Override // ir.nasim.AbstractC22887vz3
    public void d() {
        FragmentManager fragmentManager;
        FragmentManager.l lVar;
        super.d();
        Reference reference = this.h;
        if (reference != null && (fragmentManager = (FragmentManager) reference.get()) != null && (lVar = this.g) != null) {
            fragmentManager.O1(lVar);
        }
        this.h = null;
        this.g = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC22887vz3
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public InterfaceC18633oz3 e(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "thisRef");
        try {
            InterfaceC18633oz3 interfaceC18633oz3P6 = fragment.p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "thisRef.viewLifecycleOwner");
            return interfaceC18633oz3P6;
        } catch (IllegalStateException unused) {
            throw new IllegalStateException("Fragment doesn't have view associated with it or the view has been destroyed".toString());
        }
    }

    @Override // ir.nasim.AbstractC22887vz3
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public InterfaceC9764aW7 a(Fragment fragment, InterfaceC5239Im3 interfaceC5239Im3) {
        AbstractC13042fc3.i(fragment, "thisRef");
        AbstractC13042fc3.i(interfaceC5239Im3, "property");
        InterfaceC9764aW7 interfaceC9764aW7A = super.a(fragment, interfaceC5239Im3);
        o(fragment);
        return interfaceC9764aW7A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC22887vz3
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public boolean g(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "thisRef");
        if (!this.f) {
            return true;
        }
        if (!fragment.u6() || fragment.v6()) {
            return false;
        }
        return !(fragment instanceof androidx.fragment.app.l) ? fragment.o6() != null : super.g(fragment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC22887vz3
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public String k(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "thisRef");
        return !fragment.u6() ? "Fragment's view can't be accessed. Fragment isn't added" : fragment.v6() ? "Fragment's view can't be accessed. Fragment is detached" : ((fragment instanceof androidx.fragment.app.l) || fragment.o6() != null) ? super.k(fragment) : "Fragment's view can't be accessed. Fragment's view is null. Maybe you try to access view before onViewCreated() or after onDestroyView(). Add check `if (view != null)` before call ViewBinding";
    }
}
