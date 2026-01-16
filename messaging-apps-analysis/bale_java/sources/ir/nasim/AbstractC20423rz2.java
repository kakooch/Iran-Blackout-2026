package ir.nasim;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Iterator;

/* renamed from: ir.nasim.rz2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC20423rz2 extends RecyclerView.h implements InterfaceC18845pL6 {
    final androidx.lifecycle.j d;
    final FragmentManager e;
    final C21892uJ3 f;
    private final C21892uJ3 g;
    private final C21892uJ3 h;
    private g i;
    boolean j;
    private boolean k;

    /* renamed from: ir.nasim.rz2$a */
    class a implements View.OnLayoutChangeListener {
        final /* synthetic */ FrameLayout a;
        final /* synthetic */ C6290Mz2 b;

        a(FrameLayout frameLayout, C6290Mz2 c6290Mz2) {
            this.a = frameLayout;
            this.b = c6290Mz2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.a.getParent() != null) {
                this.a.removeOnLayoutChangeListener(this);
                AbstractC20423rz2.this.O(this.b);
            }
        }
    }

    /* renamed from: ir.nasim.rz2$b */
    class b implements androidx.lifecycle.n {
        final /* synthetic */ C6290Mz2 a;

        b(C6290Mz2 c6290Mz2) {
            this.a = c6290Mz2;
        }

        @Override // androidx.lifecycle.n
        public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
            if (AbstractC20423rz2.this.S()) {
                return;
            }
            interfaceC18633oz3.getLifecycle().d(this);
            if (AbstractC12990fW7.S(this.a.D0())) {
                AbstractC20423rz2.this.O(this.a);
            }
        }
    }

    /* renamed from: ir.nasim.rz2$c */
    class c extends FragmentManager.l {
        final /* synthetic */ Fragment a;
        final /* synthetic */ FrameLayout b;

        c(Fragment fragment, FrameLayout frameLayout) {
            this.a = fragment;
            this.b = frameLayout;
        }

        @Override // androidx.fragment.app.FragmentManager.l
        public void m(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
            if (fragment == this.a) {
                fragmentManager.O1(this);
                AbstractC20423rz2.this.z(view, this.b);
            }
        }
    }

    /* renamed from: ir.nasim.rz2$d */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC20423rz2 abstractC20423rz2 = AbstractC20423rz2.this;
            abstractC20423rz2.j = false;
            abstractC20423rz2.E();
        }
    }

    /* renamed from: ir.nasim.rz2$e */
    class e implements androidx.lifecycle.n {
        final /* synthetic */ Handler a;
        final /* synthetic */ Runnable b;

        e(Handler handler, Runnable runnable) {
            this.a = handler;
            this.b = runnable;
        }

        @Override // androidx.lifecycle.n
        public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
            if (aVar == j.a.ON_DESTROY) {
                this.a.removeCallbacks(this.b);
                interfaceC18633oz3.getLifecycle().d(this);
            }
        }
    }

    /* renamed from: ir.nasim.rz2$f */
    private static abstract class f extends RecyclerView.j {
        private f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public abstract void a();

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void b(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void c(int i, int i2, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void d(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void e(int i, int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public final void f(int i, int i2) {
            a();
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* renamed from: ir.nasim.rz2$g */
    class g {
        private ViewPager2.i a;
        private RecyclerView.j b;
        private androidx.lifecycle.n c;
        private ViewPager2 d;
        private long e = -1;

        /* renamed from: ir.nasim.rz2$g$a */
        class a extends ViewPager2.i {
            a() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void a(int i) {
                g.this.d(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void c(int i) {
                g.this.d(false);
            }
        }

        /* renamed from: ir.nasim.rz2$g$b */
        class b extends f {
            b() {
                super(null);
            }

            @Override // ir.nasim.AbstractC20423rz2.f, androidx.recyclerview.widget.RecyclerView.j
            public void a() {
                g.this.d(true);
            }
        }

        /* renamed from: ir.nasim.rz2$g$c */
        class c implements androidx.lifecycle.n {
            c() {
            }

            @Override // androidx.lifecycle.n
            public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
                g.this.d(false);
            }
        }

        g() {
        }

        private ViewPager2 a(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        void b(RecyclerView recyclerView) {
            this.d = a(recyclerView);
            a aVar = new a();
            this.a = aVar;
            this.d.k(aVar);
            b bVar = new b();
            this.b = bVar;
            AbstractC20423rz2.this.registerAdapterDataObserver(bVar);
            c cVar = new c();
            this.c = cVar;
            AbstractC20423rz2.this.d.a(cVar);
        }

        void c(RecyclerView recyclerView) {
            a(recyclerView).r(this.a);
            AbstractC20423rz2.this.unregisterAdapterDataObserver(this.b);
            AbstractC20423rz2.this.d.d(this.c);
            this.d = null;
        }

        void d(boolean z) {
            int currentItem;
            Fragment fragment;
            if (AbstractC20423rz2.this.S() || this.d.getScrollState() != 0 || AbstractC20423rz2.this.f.i() || AbstractC20423rz2.this.getItemCount() == 0 || (currentItem = this.d.getCurrentItem()) >= AbstractC20423rz2.this.getItemCount()) {
                return;
            }
            long itemId = AbstractC20423rz2.this.getItemId(currentItem);
            if ((itemId != this.e || z) && (fragment = (Fragment) AbstractC20423rz2.this.f.f(itemId)) != null && fragment.u6()) {
                this.e = itemId;
                androidx.fragment.app.x xVarS = AbstractC20423rz2.this.e.s();
                Fragment fragment2 = null;
                for (int i = 0; i < AbstractC20423rz2.this.f.o(); i++) {
                    long jK = AbstractC20423rz2.this.f.k(i);
                    Fragment fragment3 = (Fragment) AbstractC20423rz2.this.f.p(i);
                    if (fragment3.u6()) {
                        if (jK != this.e) {
                            xVarS.u(fragment3, j.b.STARTED);
                        } else {
                            fragment2 = fragment3;
                        }
                        fragment3.e8(jK == this.e);
                    }
                }
                if (fragment2 != null) {
                    xVarS.u(fragment2, j.b.RESUMED);
                }
                if (xVarS.o()) {
                    return;
                }
                xVarS.j();
            }
        }
    }

    public AbstractC20423rz2(FragmentActivity fragmentActivity) {
        this(fragmentActivity.B0(), fragmentActivity.getLifecycle());
    }

    private static String C(String str, long j) {
        return str + j;
    }

    private void D(int i) {
        long itemId = getItemId(i);
        if (this.f.e(itemId)) {
            return;
        }
        Fragment fragmentB = B(i);
        fragmentB.d8((Fragment.SavedState) this.g.f(itemId));
        this.f.l(itemId, fragmentB);
    }

    private boolean F(long j) {
        View viewO6;
        if (this.h.e(j)) {
            return true;
        }
        Fragment fragment = (Fragment) this.f.f(j);
        return (fragment == null || (viewO6 = fragment.o6()) == null || viewO6.getParent() == null) ? false : true;
    }

    private static boolean G(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private Long H(int i) {
        Long lValueOf = null;
        for (int i2 = 0; i2 < this.h.o(); i2++) {
            if (((Integer) this.h.p(i2)).intValue() == i) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(this.h.k(i2));
            }
        }
        return lValueOf;
    }

    private static long N(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void P(long j) {
        ViewParent parent;
        Fragment fragment = (Fragment) this.f.f(j);
        if (fragment == null) {
            return;
        }
        if (fragment.o6() != null && (parent = fragment.o6().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!A(j)) {
            this.g.m(j);
        }
        if (!fragment.u6()) {
            this.f.m(j);
            return;
        }
        if (S()) {
            this.k = true;
            return;
        }
        if (fragment.u6() && A(j)) {
            this.g.l(j, this.e.D1(fragment));
        }
        this.e.s().p(fragment).j();
        this.f.m(j);
    }

    private void Q() {
        Handler handler = new Handler(Looper.getMainLooper());
        d dVar = new d();
        this.d.a(new e(handler, dVar));
        handler.postDelayed(dVar, 10000L);
    }

    private void R(Fragment fragment, FrameLayout frameLayout) {
        this.e.t1(new c(fragment, frameLayout), false);
    }

    public boolean A(long j) {
        return j >= 0 && j < ((long) getItemCount());
    }

    public abstract Fragment B(int i);

    void E() {
        if (!this.k || S()) {
            return;
        }
        PJ pj = new PJ();
        for (int i = 0; i < this.f.o(); i++) {
            long jK = this.f.k(i);
            if (!A(jK)) {
                pj.add(Long.valueOf(jK));
                this.h.m(jK);
            }
        }
        if (!this.j) {
            this.k = false;
            for (int i2 = 0; i2 < this.f.o(); i2++) {
                long jK2 = this.f.k(i2);
                if (!F(jK2)) {
                    pj.add(Long.valueOf(jK2));
                }
            }
        }
        Iterator it = pj.iterator();
        while (it.hasNext()) {
            P(((Long) it.next()).longValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(C6290Mz2 c6290Mz2, int i) {
        long jL = c6290Mz2.L();
        int id = c6290Mz2.D0().getId();
        Long lH = H(id);
        if (lH != null && lH.longValue() != jL) {
            P(lH.longValue());
            this.h.m(lH.longValue());
        }
        this.h.l(jL, Integer.valueOf(id));
        D(i);
        FrameLayout frameLayoutD0 = c6290Mz2.D0();
        if (AbstractC12990fW7.S(frameLayoutD0)) {
            if (frameLayoutD0.getParent() != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            frameLayoutD0.addOnLayoutChangeListener(new a(frameLayoutD0, c6290Mz2));
        }
        E();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public final C6290Mz2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return C6290Mz2.C0(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public final boolean onFailedToRecycleView(C6290Mz2 c6290Mz2) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public final void onViewAttachedToWindow(C6290Mz2 c6290Mz2) {
        O(c6290Mz2);
        E();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public final void onViewRecycled(C6290Mz2 c6290Mz2) {
        Long lH = H(c6290Mz2.D0().getId());
        if (lH != null) {
            P(lH.longValue());
            this.h.m(lH.longValue());
        }
    }

    void O(C6290Mz2 c6290Mz2) {
        Fragment fragment = (Fragment) this.f.f(c6290Mz2.L());
        if (fragment == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayoutD0 = c6290Mz2.D0();
        View viewO6 = fragment.o6();
        if (!fragment.u6() && viewO6 != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (fragment.u6() && viewO6 == null) {
            R(fragment, frameLayoutD0);
            return;
        }
        if (fragment.u6() && viewO6.getParent() != null) {
            if (viewO6.getParent() != frameLayoutD0) {
                z(viewO6, frameLayoutD0);
                return;
            }
            return;
        }
        if (fragment.u6()) {
            z(viewO6, frameLayoutD0);
            return;
        }
        if (S()) {
            if (this.e.P0()) {
                return;
            }
            this.d.a(new b(c6290Mz2));
            return;
        }
        R(fragment, frameLayoutD0);
        this.e.s().e(fragment, "f" + c6290Mz2.L()).u(fragment, j.b.STARTED).j();
        this.i.d(false);
    }

    boolean S() {
        return this.e.X0();
    }

    @Override // ir.nasim.InterfaceC18845pL6
    public final Parcelable b() {
        Bundle bundle = new Bundle(this.f.o() + this.g.o());
        for (int i = 0; i < this.f.o(); i++) {
            long jK = this.f.k(i);
            Fragment fragment = (Fragment) this.f.f(jK);
            if (fragment != null && fragment.u6()) {
                this.e.s1(bundle, C("f#", jK), fragment);
            }
        }
        for (int i2 = 0; i2 < this.g.o(); i2++) {
            long jK2 = this.g.k(i2);
            if (A(jK2)) {
                bundle.putParcelable(C("s#", jK2), (Parcelable) this.g.f(jK2));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        AbstractC4980Hj5.a(this.i == null);
        g gVar = new g();
        this.i = gVar;
        gVar.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.i.c(recyclerView);
        this.i = null;
    }

    @Override // ir.nasim.InterfaceC18845pL6
    public final void p(Parcelable parcelable) {
        if (!this.g.i() || !this.f.i()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (G(str, "f#")) {
                this.f.l(N(str, "f#"), this.e.z0(bundle, str));
            } else {
                if (!G(str, "s#")) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                long jN = N(str, "s#");
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (A(jN)) {
                    this.g.l(jN, savedState);
                }
            }
        }
        if (this.f.i()) {
            return;
        }
        this.k = true;
        this.j = true;
        E();
        Q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    void z(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public AbstractC20423rz2(Fragment fragment) {
        this(fragment.F5(), fragment.getLifecycle());
    }

    public AbstractC20423rz2(FragmentManager fragmentManager, androidx.lifecycle.j jVar) {
        this.f = new C21892uJ3();
        this.g = new C21892uJ3();
        this.h = new C21892uJ3();
        this.j = false;
        this.k = false;
        this.e = fragmentManager;
        this.d = jVar;
        super.setHasStableIds(true);
    }
}
