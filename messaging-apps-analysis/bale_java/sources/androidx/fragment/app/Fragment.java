package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import ir.nasim.AbstractC15744k6;
import ir.nasim.AbstractC16222ku3;
import ir.nasim.AbstractC18108o6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC22357v6;
import ir.nasim.AbstractC23051wG3;
import ir.nasim.AbstractC24133y6;
import ir.nasim.AbstractC6771Ox2;
import ir.nasim.AbstractC9203Yx6;
import ir.nasim.B6;
import ir.nasim.C13170fm4;
import ir.nasim.C14819iX7;
import ir.nasim.C20298rm4;
import ir.nasim.C4404Ez2;
import ir.nasim.C7289Rb6;
import ir.nasim.C7523Sb6;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC17517n6;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC21819uB2;
import ir.nasim.InterfaceC7760Tb6;
import ir.nasim.VX7;
import ir.nasim.XX7;
import ir.nasim.YX7;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC18633oz3, InterfaceC15408jX7, androidx.lifecycle.h, InterfaceC7760Tb6 {
    static final Object V0 = new Object();
    int A;
    ViewGroup A0;
    String B;
    View B0;
    boolean C0;
    boolean D;
    boolean D0;
    j E0;
    Handler F0;
    boolean G;
    Runnable G0;
    boolean H;
    boolean H0;
    LayoutInflater I0;
    boolean J;
    boolean J0;
    public String K0;
    j.b L0;
    androidx.lifecycle.p M0;
    B N0;
    C20298rm4 O0;
    G.c P0;
    C7523Sb6 Q0;
    private int R0;
    private final AtomicInteger S0;
    private final ArrayList T0;
    private final k U0;
    boolean Y;
    boolean Z;
    int a;
    Bundle b;
    SparseArray c;
    Bundle d;
    Boolean e;
    String f;
    Bundle g;
    Fragment h;
    String i;
    int j;
    private Boolean k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    int u;
    FragmentManager v;
    p w;
    FragmentManager x;
    Fragment y;
    int z;
    private boolean z0;

    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    class a extends AbstractC22357v6 {
        final /* synthetic */ AtomicReference a;
        final /* synthetic */ AbstractC18108o6 b;

        a(AtomicReference atomicReference, AbstractC18108o6 abstractC18108o6) {
            this.a = atomicReference;
            this.b = abstractC18108o6;
        }

        @Override // ir.nasim.AbstractC22357v6
        public void b(Object obj, AbstractC15744k6 abstractC15744k6) {
            AbstractC22357v6 abstractC22357v6 = (AbstractC22357v6) this.a.get();
            if (abstractC22357v6 == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            abstractC22357v6.b(obj, abstractC15744k6);
        }

        @Override // ir.nasim.AbstractC22357v6
        public void c() {
            AbstractC22357v6 abstractC22357v6 = (AbstractC22357v6) this.a.getAndSet(null);
            if (abstractC22357v6 != null) {
                abstractC22357v6.c();
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.q8();
        }
    }

    class c extends k {
        c() {
            super(null);
        }

        @Override // androidx.fragment.app.Fragment.k
        void a() {
            Fragment.this.Q0.c();
            androidx.lifecycle.B.c(Fragment.this);
            Bundle bundle = Fragment.this.b;
            Fragment.this.Q0.d(bundle != null ? bundle.getBundle("registryState") : null);
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.u5(false);
        }
    }

    class e implements Runnable {
        final /* synthetic */ F a;

        e(F f) {
            this.a = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.y()) {
                this.a.n();
            }
        }
    }

    class f extends AbstractC6771Ox2 {
        f() {
        }

        @Override // ir.nasim.AbstractC6771Ox2
        public View h(int i) {
            View view = Fragment.this.B0;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        @Override // ir.nasim.AbstractC6771Ox2
        public boolean i() {
            return Fragment.this.B0 != null;
        }
    }

    class g implements androidx.lifecycle.n {
        g() {
        }

        @Override // androidx.lifecycle.n
        public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
            View view;
            if (aVar != j.a.ON_STOP || (view = Fragment.this.B0) == null) {
                return;
            }
            view.cancelPendingInputEvents();
        }
    }

    class h implements InterfaceC21819uB2 {
        h() {
        }

        @Override // ir.nasim.InterfaceC21819uB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC24133y6 apply(Void r3) {
            Fragment fragment = Fragment.this;
            Object obj = fragment.w;
            return obj instanceof B6 ? ((B6) obj).getActivityResultRegistry() : fragment.Q7().getActivityResultRegistry();
        }
    }

    class i extends k {
        final /* synthetic */ InterfaceC21819uB2 a;
        final /* synthetic */ AtomicReference b;
        final /* synthetic */ AbstractC18108o6 c;
        final /* synthetic */ InterfaceC17517n6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(InterfaceC21819uB2 interfaceC21819uB2, AtomicReference atomicReference, AbstractC18108o6 abstractC18108o6, InterfaceC17517n6 interfaceC17517n6) {
            super(null);
            this.a = interfaceC21819uB2;
            this.b = atomicReference;
            this.c = abstractC18108o6;
            this.d = interfaceC17517n6;
        }

        @Override // androidx.fragment.app.Fragment.k
        void a() {
            String strZ5 = Fragment.this.z5();
            this.b.set(((AbstractC24133y6) this.a.apply(null)).m(strZ5, Fragment.this, this.c, this.d));
        }
    }

    static class j {
        View a;
        boolean b;
        int c;
        int d;
        int e;
        int f;
        int g;
        ArrayList h;
        ArrayList i;
        Object j = null;
        Object k;
        Object l;
        Object m;
        Object n;
        Object o;
        Boolean p;
        Boolean q;
        AbstractC9203Yx6 r;
        AbstractC9203Yx6 s;
        float t;
        View u;
        boolean v;

        j() {
            Object obj = Fragment.V0;
            this.k = obj;
            this.l = null;
            this.m = obj;
            this.n = null;
            this.o = obj;
            this.r = null;
            this.s = null;
            this.t = 1.0f;
            this.u = null;
        }
    }

    private static abstract class k {
        private k() {
        }

        abstract void a();

        /* synthetic */ k(b bVar) {
            this();
        }
    }

    public Fragment() {
        this.a = -1;
        this.f = UUID.randomUUID().toString();
        this.i = null;
        this.k = null;
        this.x = new s();
        this.Z = true;
        this.D0 = true;
        this.G0 = new b();
        this.L0 = j.b.RESUMED;
        this.O0 = new C20298rm4();
        this.S0 = new AtomicInteger();
        this.T0 = new ArrayList();
        this.U0 = new c();
        r6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E6() {
        this.N0.d(this.d);
        this.d = null;
    }

    private AbstractC22357v6 M7(AbstractC18108o6 abstractC18108o6, InterfaceC21819uB2 interfaceC21819uB2, InterfaceC17517n6 interfaceC17517n6) {
        if (this.a <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            O7(new i(interfaceC21819uB2, atomicReference, abstractC18108o6, interfaceC17517n6));
            return new a(atomicReference, abstractC18108o6);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void O7(k kVar) {
        if (this.a >= 0) {
            kVar.a();
        } else {
            this.T0.add(kVar);
        }
    }

    private int S5() {
        j.b bVar = this.L0;
        return (bVar == j.b.INITIALIZED || this.y == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.y.S5());
    }

    private void X7() {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.B0 != null) {
            Bundle bundle = this.b;
            Y7(bundle != null ? bundle.getBundle("savedInstanceState") : null);
        }
        this.b = null;
    }

    private Fragment l6(boolean z) {
        String str;
        if (z) {
            C4404Ez2.i(this);
        }
        Fragment fragment = this.h;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.v;
        if (fragmentManager == null || (str = this.i) == null) {
            return null;
        }
        return fragmentManager.m0(str);
    }

    private void r6() {
        this.M0 = new androidx.lifecycle.p(this);
        this.Q0 = C7523Sb6.a(this);
        this.P0 = null;
        if (this.T0.contains(this.U0)) {
            return;
        }
        O7(this.U0);
    }

    public static Fragment t6(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) o.d(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.a8(bundle);
            }
            return fragment;
        } catch (IllegalAccessException e2) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (java.lang.InstantiationException e3) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    private j x5() {
        if (this.E0 == null) {
            this.E0 = new j();
        }
        return this.E0;
    }

    public final FragmentActivity A5() {
        p pVar = this.w;
        if (pVar == null) {
            return null;
        }
        return (FragmentActivity) pVar.j();
    }

    public final boolean A6() {
        return this.m;
    }

    boolean A7(MenuItem menuItem) {
        if (this.D) {
            return false;
        }
        if (this.Y && this.Z && a7(menuItem)) {
            return true;
        }
        return this.x.Q(menuItem);
    }

    public boolean B5() {
        Boolean bool;
        j jVar = this.E0;
        if (jVar == null || (bool = jVar.q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final boolean B6() {
        return this.a >= 7;
    }

    void B7(Menu menu) {
        if (this.D) {
            return;
        }
        if (this.Y && this.Z) {
            b7(menu);
        }
        this.x.R(menu);
    }

    public boolean C5() {
        Boolean bool;
        j jVar = this.E0;
        if (jVar == null || (bool = jVar.p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final boolean C6() {
        FragmentManager fragmentManager = this.v;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.X0();
    }

    void C7() {
        this.x.T();
        if (this.B0 != null) {
            this.N0.a(j.a.ON_PAUSE);
        }
        this.M0.i(j.a.ON_PAUSE);
        this.a = 6;
        this.z0 = false;
        c7();
        if (this.z0) {
            return;
        }
        throw new H("Fragment " + this + " did not call through to super.onPause()");
    }

    View D5() {
        j jVar = this.E0;
        if (jVar == null) {
            return null;
        }
        return jVar.a;
    }

    public final boolean D6() {
        View view;
        return (!u6() || w6() || (view = this.B0) == null || view.getWindowToken() == null || this.B0.getVisibility() != 0) ? false : true;
    }

    void D7(boolean z) {
        d7(z);
    }

    public final Bundle E5() {
        return this.g;
    }

    boolean E7(Menu menu) {
        boolean z = false;
        if (this.D) {
            return false;
        }
        if (this.Y && this.Z) {
            e7(menu);
            z = true;
        }
        return z | this.x.V(menu);
    }

    public final FragmentManager F5() {
        if (this.w != null) {
            return this.x;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    void F6() {
        this.x.h1();
    }

    void F7() {
        boolean zV0 = this.v.V0(this);
        Boolean bool = this.k;
        if (bool == null || bool.booleanValue() != zV0) {
            this.k = Boolean.valueOf(zV0);
            f7(zV0);
            this.x.W();
        }
    }

    public Context G5() {
        p pVar = this.w;
        if (pVar == null) {
            return null;
        }
        return pVar.k();
    }

    public void G6(Bundle bundle) {
        this.z0 = true;
    }

    void G7() {
        this.x.h1();
        this.x.h0(true);
        this.a = 7;
        this.z0 = false;
        h7();
        if (!this.z0) {
            throw new H("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.p pVar = this.M0;
        j.a aVar = j.a.ON_RESUME;
        pVar.i(aVar);
        if (this.B0 != null) {
            this.N0.a(aVar);
        }
        this.x.X();
    }

    int H5() {
        j jVar = this.E0;
        if (jVar == null) {
            return 0;
        }
        return jVar.c;
    }

    public void H6(int i2, int i3, Intent intent) {
        if (FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent);
        }
    }

    void H7(Bundle bundle) {
        i7(bundle);
    }

    public Object I5() {
        j jVar = this.E0;
        if (jVar == null) {
            return null;
        }
        return jVar.j;
    }

    public void I6(Activity activity) {
        this.z0 = true;
    }

    void I7() {
        this.x.h1();
        this.x.h0(true);
        this.a = 5;
        this.z0 = false;
        j7();
        if (!this.z0) {
            throw new H("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.p pVar = this.M0;
        j.a aVar = j.a.ON_START;
        pVar.i(aVar);
        if (this.B0 != null) {
            this.N0.a(aVar);
        }
        this.x.Y();
    }

    AbstractC9203Yx6 J5() {
        j jVar = this.E0;
        if (jVar == null) {
            return null;
        }
        return jVar.r;
    }

    public void J6(Context context) {
        this.z0 = true;
        p pVar = this.w;
        Activity activityJ = pVar == null ? null : pVar.j();
        if (activityJ != null) {
            this.z0 = false;
            I6(activityJ);
        }
    }

    void J7() {
        this.x.a0();
        if (this.B0 != null) {
            this.N0.a(j.a.ON_STOP);
        }
        this.M0.i(j.a.ON_STOP);
        this.a = 4;
        this.z0 = false;
        k7();
        if (this.z0) {
            return;
        }
        throw new H("Fragment " + this + " did not call through to super.onStop()");
    }

    int K5() {
        j jVar = this.E0;
        if (jVar == null) {
            return 0;
        }
        return jVar.d;
    }

    public void K6(Fragment fragment) {
    }

    void K7() {
        Bundle bundle = this.b;
        l7(this.B0, bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.x.b0();
    }

    public Object L5() {
        j jVar = this.E0;
        if (jVar == null) {
            return null;
        }
        return jVar.l;
    }

    public boolean L6(MenuItem menuItem) {
        return false;
    }

    public final void L7(long j2, TimeUnit timeUnit) {
        x5().v = true;
        Handler handler = this.F0;
        if (handler != null) {
            handler.removeCallbacks(this.G0);
        }
        FragmentManager fragmentManager = this.v;
        if (fragmentManager != null) {
            this.F0 = fragmentManager.D0().n();
        } else {
            this.F0 = new Handler(Looper.getMainLooper());
        }
        this.F0.removeCallbacks(this.G0);
        this.F0.postDelayed(this.G0, timeUnit.toMillis(j2));
    }

    AbstractC9203Yx6 M5() {
        j jVar = this.E0;
        if (jVar == null) {
            return null;
        }
        return jVar.s;
    }

    public void M6(Bundle bundle) {
        this.z0 = true;
        W7();
        if (this.x.W0(1)) {
            return;
        }
        this.x.I();
    }

    View N5() {
        j jVar = this.E0;
        if (jVar == null) {
            return null;
        }
        return jVar.u;
    }

    public Animation N6(int i2, boolean z, int i3) {
        return null;
    }

    public final AbstractC22357v6 N7(AbstractC18108o6 abstractC18108o6, InterfaceC17517n6 interfaceC17517n6) {
        return M7(abstractC18108o6, new h(), interfaceC17517n6);
    }

    public final FragmentManager O5() {
        return this.v;
    }

    public Animator O6(int i2, boolean z, int i3) {
        return null;
    }

    public final Object P5() {
        p pVar = this.w;
        if (pVar == null) {
            return null;
        }
        return pVar.q();
    }

    public void P6(Menu menu, MenuInflater menuInflater) {
    }

    public final void P7(String[] strArr, int i2) {
        if (this.w != null) {
            V5().e1(this, strArr, i2);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final LayoutInflater Q5() {
        LayoutInflater layoutInflater = this.I0;
        return layoutInflater == null ? x7(null) : layoutInflater;
    }

    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.R0;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    public final FragmentActivity Q7() {
        FragmentActivity fragmentActivityA5 = A5();
        if (fragmentActivityA5 != null) {
            return fragmentActivityA5;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public LayoutInflater R5(Bundle bundle) {
        p pVar = this.w;
        if (pVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterR = pVar.r();
        AbstractC16222ku3.a(layoutInflaterR, this.x.E0());
        return layoutInflaterR;
    }

    public void R6() {
        this.z0 = true;
    }

    public final Bundle R7() {
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            return bundleE5;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    public void S6() {
    }

    public final Context S7() {
        Context contextG5 = G5();
        if (contextG5 != null) {
            return contextG5;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    int T5() {
        j jVar = this.E0;
        if (jVar == null) {
            return 0;
        }
        return jVar.g;
    }

    public void T6() {
        this.z0 = true;
    }

    public final FragmentManager T7() {
        return V5();
    }

    public final Fragment U5() {
        return this.y;
    }

    public void U6() {
        this.z0 = true;
    }

    public final Fragment U7() {
        Fragment fragmentU5 = U5();
        if (fragmentU5 != null) {
            return fragmentU5;
        }
        if (G5() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + G5());
    }

    public final FragmentManager V5() {
        FragmentManager fragmentManager = this.v;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public LayoutInflater V6(Bundle bundle) {
        return R5(bundle);
    }

    public final View V7() {
        View viewO6 = o6();
        if (viewO6 != null) {
            return viewO6;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    boolean W5() {
        j jVar = this.E0;
        if (jVar == null) {
            return false;
        }
        return jVar.b;
    }

    public void W6(boolean z) {
    }

    void W7() {
        Bundle bundle;
        Bundle bundle2 = this.b;
        if (bundle2 == null || (bundle = bundle2.getBundle("childFragmentManager")) == null) {
            return;
        }
        this.x.A1(bundle);
        this.x.I();
    }

    int X5() {
        j jVar = this.E0;
        if (jVar == null) {
            return 0;
        }
        return jVar.e;
    }

    public void X6(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.z0 = true;
    }

    int Y5() {
        j jVar = this.E0;
        if (jVar == null) {
            return 0;
        }
        return jVar.f;
    }

    public void Y6(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.z0 = true;
        p pVar = this.w;
        Activity activityJ = pVar == null ? null : pVar.j();
        if (activityJ != null) {
            this.z0 = false;
            X6(activityJ, attributeSet, bundle);
        }
    }

    final void Y7(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.c;
        if (sparseArray != null) {
            this.B0.restoreHierarchyState(sparseArray);
            this.c = null;
        }
        this.z0 = false;
        m7(bundle);
        if (this.z0) {
            if (this.B0 != null) {
                this.N0.a(j.a.ON_CREATE);
            }
        } else {
            throw new H("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    float Z5() {
        j jVar = this.E0;
        if (jVar == null) {
            return 1.0f;
        }
        return jVar.t;
    }

    public void Z6(boolean z) {
    }

    void Z7(int i2, int i3, int i4, int i5) {
        if (this.E0 == null && i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return;
        }
        x5().c = i2;
        x5().d = i3;
        x5().e = i4;
        x5().f = i5;
    }

    public Object a6() {
        j jVar = this.E0;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.m;
        return obj == V0 ? L5() : obj;
    }

    public boolean a7(MenuItem menuItem) {
        return false;
    }

    public void a8(Bundle bundle) {
        if (this.v != null && C6()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.g = bundle;
    }

    public final Resources b6() {
        return S7().getResources();
    }

    public void b7(Menu menu) {
    }

    void b8(View view) {
        x5().u = view;
    }

    public Object c6() {
        j jVar = this.E0;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.k;
        return obj == V0 ? I5() : obj;
    }

    public void c7() {
        this.z0 = true;
    }

    public void c8(boolean z) {
        if (this.Y != z) {
            this.Y = z;
            if (!u6() || w6()) {
                return;
            }
            this.w.x();
        }
    }

    @Override // ir.nasim.InterfaceC15408jX7
    public C14819iX7 d1() {
        if (this.v == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (S5() != j.b.INITIALIZED.ordinal()) {
            return this.v.L0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public Object d6() {
        j jVar = this.E0;
        if (jVar == null) {
            return null;
        }
        return jVar.n;
    }

    public void d7(boolean z) {
    }

    public void d8(SavedState savedState) {
        Bundle bundle;
        if (this.v != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (savedState == null || (bundle = savedState.a) == null) {
            bundle = null;
        }
        this.b = bundle;
    }

    public Object e6() {
        j jVar = this.E0;
        if (jVar == null) {
            return null;
        }
        Object obj = jVar.o;
        return obj == V0 ? d6() : obj;
    }

    public void e7(Menu menu) {
    }

    public void e8(boolean z) {
        if (this.Z != z) {
            this.Z = z;
            if (this.Y && u6() && !w6()) {
                this.w.x();
            }
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    ArrayList f6() {
        ArrayList arrayList;
        j jVar = this.E0;
        return (jVar == null || (arrayList = jVar.h) == null) ? new ArrayList() : arrayList;
    }

    public void f7(boolean z) {
    }

    void f8(int i2) {
        if (this.E0 == null && i2 == 0) {
            return;
        }
        x5();
        this.E0.g = i2;
    }

    ArrayList g6() {
        ArrayList arrayList;
        j jVar = this.E0;
        return (jVar == null || (arrayList = jVar.i) == null) ? new ArrayList() : arrayList;
    }

    public void g7(int i2, String[] strArr, int[] iArr) {
    }

    void g8(boolean z) {
        if (this.E0 == null) {
            return;
        }
        x5().b = z;
    }

    @Override // ir.nasim.InterfaceC18633oz3
    public androidx.lifecycle.j getLifecycle() {
        return this.M0;
    }

    public final String h6(int i2) {
        return b6().getString(i2);
    }

    public void h7() {
        this.z0 = true;
    }

    void h8(float f2) {
        x5().t = f2;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String i6(int i2, Object... objArr) {
        return b6().getString(i2, objArr);
    }

    public void i7(Bundle bundle) {
    }

    public void i8(boolean z) {
        C4404Ez2.j(this);
        this.H = z;
        FragmentManager fragmentManager = this.v;
        if (fragmentManager == null) {
            this.J = true;
        } else if (z) {
            fragmentManager.o(this);
        } else {
            fragmentManager.y1(this);
        }
    }

    public final String j6() {
        return this.B;
    }

    public void j7() {
        this.z0 = true;
    }

    void j8(ArrayList arrayList, ArrayList arrayList2) {
        x5();
        j jVar = this.E0;
        jVar.h = arrayList;
        jVar.i = arrayList2;
    }

    public final Fragment k6() {
        return l6(true);
    }

    public void k7() {
        this.z0 = true;
    }

    public void k8(Fragment fragment, int i2) {
        if (fragment != null) {
            C4404Ez2.k(this, fragment, i2);
        }
        FragmentManager fragmentManager = this.v;
        FragmentManager fragmentManager2 = fragment != null ? fragment.v : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment fragmentL6 = fragment; fragmentL6 != null; fragmentL6 = fragmentL6.l6(false)) {
            if (fragmentL6.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.i = null;
            this.h = null;
        } else if (this.v == null || fragment.v == null) {
            this.i = null;
            this.h = fragment;
        } else {
            this.i = fragment.f;
            this.h = null;
        }
        this.j = i2;
    }

    public void l7(View view, Bundle bundle) {
    }

    public void l8(boolean z) {
        C4404Ez2.l(this, z);
        if (!this.D0 && z && this.a < 5 && this.v != null && u6() && this.J0) {
            FragmentManager fragmentManager = this.v;
            fragmentManager.j1(fragmentManager.C(this));
        }
        this.D0 = z;
        this.C0 = this.a < 5 && !z;
        if (this.b != null) {
            this.e = Boolean.valueOf(z);
        }
    }

    public final int m6() {
        C4404Ez2.h(this);
        return this.j;
    }

    public void m7(Bundle bundle) {
        this.z0 = true;
    }

    public boolean m8(String str) {
        p pVar = this.w;
        if (pVar != null) {
            return pVar.u(str);
        }
        return false;
    }

    @Override // androidx.lifecycle.h
    public G.c n3() {
        Application application;
        if (this.v == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.P0 == null) {
            Context applicationContext = S7().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && FragmentManager.Q0(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + S7().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.P0 = new androidx.lifecycle.C(application, this, E5());
        }
        return this.P0;
    }

    public final CharSequence n6(int i2) {
        return b6().getText(i2);
    }

    void n7(Bundle bundle) {
        this.x.h1();
        this.a = 3;
        this.z0 = false;
        G6(bundle);
        if (this.z0) {
            X7();
            this.x.E();
        } else {
            throw new H("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public void n8(Intent intent) {
        o8(intent, null);
    }

    public View o6() {
        return this.B0;
    }

    void o7() {
        Iterator it = this.T0.iterator();
        while (it.hasNext()) {
            ((k) it.next()).a();
        }
        this.T0.clear();
        this.x.q(this.w, v5(), this);
        this.a = 0;
        this.z0 = false;
        J6(this.w.k());
        if (this.z0) {
            this.v.O(this);
            this.x.F();
        } else {
            throw new H("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    public void o8(Intent intent, Bundle bundle) {
        p pVar = this.w;
        if (pVar != null) {
            pVar.v(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.z0 = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Q7().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.z0 = true;
    }

    @Override // androidx.lifecycle.h
    public AbstractC20375ru1 p3() {
        Application application;
        Context applicationContext = S7().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + S7().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        C13170fm4 c13170fm4 = new C13170fm4();
        if (application != null) {
            c13170fm4.c(G.a.h, application);
        }
        c13170fm4.c(androidx.lifecycle.B.a, this);
        c13170fm4.c(androidx.lifecycle.B.b, this);
        if (E5() != null) {
            c13170fm4.c(androidx.lifecycle.B.c, E5());
        }
        return c13170fm4;
    }

    public InterfaceC18633oz3 p6() {
        B b2 = this.N0;
        if (b2 != null) {
            return b2;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner for " + this + " when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    void p7(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public void p8(Intent intent, int i2, Bundle bundle) {
        if (this.w != null) {
            V5().f1(this, intent, i2, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public androidx.lifecycle.r q6() {
        return this.O0;
    }

    boolean q7(MenuItem menuItem) {
        if (this.D) {
            return false;
        }
        if (L6(menuItem)) {
            return true;
        }
        return this.x.H(menuItem);
    }

    public void q8() {
        if (this.E0 == null || !x5().v) {
            return;
        }
        if (this.w == null) {
            x5().v = false;
        } else if (Looper.myLooper() != this.w.n().getLooper()) {
            this.w.n().postAtFrontOfQueue(new d());
        } else {
            u5(true);
        }
    }

    void r7(Bundle bundle) {
        this.x.h1();
        this.a = 1;
        this.z0 = false;
        this.M0.a(new g());
        M6(bundle);
        this.J0 = true;
        if (this.z0) {
            this.M0.i(j.a.ON_CREATE);
            return;
        }
        throw new H("Fragment " + this + " did not call through to super.onCreate()");
    }

    void s6() {
        r6();
        this.K0 = this.f;
        this.f = UUID.randomUUID().toString();
        this.l = false;
        this.m = false;
        this.p = false;
        this.q = false;
        this.s = false;
        this.u = 0;
        this.v = null;
        this.x = new s();
        this.w = null;
        this.z = 0;
        this.A = 0;
        this.B = null;
        this.D = false;
        this.G = false;
    }

    boolean s7(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.D) {
            return false;
        }
        if (this.Y && this.Z) {
            P6(menu, menuInflater);
            z = true;
        }
        return z | this.x.J(menu, menuInflater);
    }

    public void startActivityForResult(Intent intent, int i2) {
        p8(intent, i2, null);
    }

    void t7(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.x.h1();
        this.t = true;
        this.N0 = new B(this, d1(), new Runnable() { // from class: ir.nasim.dx2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.E6();
            }
        });
        View viewQ6 = Q6(layoutInflater, viewGroup, bundle);
        this.B0 = viewQ6;
        if (viewQ6 == null) {
            if (this.N0.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.N0 = null;
            return;
        }
        this.N0.b();
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.B0 + " for Fragment " + this);
        }
        VX7.b(this.B0, this.N0);
        YX7.b(this.B0, this.N0);
        XX7.b(this.B0, this.N0);
        this.O0.p(this.N0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f);
        if (this.z != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.z));
        }
        if (this.B != null) {
            sb.append(" tag=");
            sb.append(this.B);
        }
        sb.append(Separators.RPAREN);
        return sb.toString();
    }

    void u5(boolean z) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        j jVar = this.E0;
        if (jVar != null) {
            jVar.v = false;
        }
        if (this.B0 == null || (viewGroup = this.A0) == null || (fragmentManager = this.v) == null) {
            return;
        }
        F fU = F.u(viewGroup, fragmentManager);
        fU.z();
        if (z) {
            this.w.n().post(new e(fU));
        } else {
            fU.n();
        }
        Handler handler = this.F0;
        if (handler != null) {
            handler.removeCallbacks(this.G0);
            this.F0 = null;
        }
    }

    public final boolean u6() {
        return this.w != null && this.l;
    }

    void u7() {
        this.x.K();
        this.M0.i(j.a.ON_DESTROY);
        this.a = 0;
        this.z0 = false;
        this.J0 = false;
        R6();
        if (this.z0) {
            return;
        }
        throw new H("Fragment " + this + " did not call through to super.onDestroy()");
    }

    @Override // ir.nasim.InterfaceC7760Tb6
    public final C7289Rb6 v1() {
        return this.Q0.b();
    }

    AbstractC6771Ox2 v5() {
        return new f();
    }

    public final boolean v6() {
        return this.G;
    }

    void v7() {
        this.x.L();
        if (this.B0 != null && this.N0.getLifecycle().b().j(j.b.CREATED)) {
            this.N0.a(j.a.ON_DESTROY);
        }
        this.a = 1;
        this.z0 = false;
        T6();
        if (this.z0) {
            AbstractC23051wG3.b(this).d();
            this.t = false;
        } else {
            throw new H("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void w5(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.z));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.A));
        printWriter.print(" mTag=");
        printWriter.println(this.B);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.a);
        printWriter.print(" mWho=");
        printWriter.print(this.f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.u);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.p);
        printWriter.print(" mInLayout=");
        printWriter.println(this.q);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.D);
        printWriter.print(" mDetached=");
        printWriter.print(this.G);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.Z);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.Y);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.H);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.D0);
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.v);
        }
        if (this.w != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.w);
        }
        if (this.y != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.y);
        }
        if (this.g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.g);
        }
        if (this.b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.b);
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.c);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.d);
        }
        Fragment fragmentL6 = l6(false);
        if (fragmentL6 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(fragmentL6);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.j);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(W5());
        if (H5() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(H5());
        }
        if (K5() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(K5());
        }
        if (X5() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(X5());
        }
        if (Y5() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(Y5());
        }
        if (this.A0 != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.A0);
        }
        if (this.B0 != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.B0);
        }
        if (D5() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(D5());
        }
        if (G5() != null) {
            AbstractC23051wG3.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.x + ":");
        this.x.d0(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean w6() {
        FragmentManager fragmentManager;
        return this.D || ((fragmentManager = this.v) != null && fragmentManager.T0(this.y));
    }

    void w7() {
        this.a = -1;
        this.z0 = false;
        U6();
        this.I0 = null;
        if (this.z0) {
            if (this.x.P0()) {
                return;
            }
            this.x.K();
            this.x = new s();
            return;
        }
        throw new H("Fragment " + this + " did not call through to super.onDetach()");
    }

    final boolean x6() {
        return this.u > 0;
    }

    LayoutInflater x7(Bundle bundle) {
        LayoutInflater layoutInflaterV6 = V6(bundle);
        this.I0 = layoutInflaterV6;
        return layoutInflaterV6;
    }

    Fragment y5(String str) {
        return str.equals(this.f) ? this : this.x.q0(str);
    }

    public final boolean y6() {
        FragmentManager fragmentManager;
        return this.Z && ((fragmentManager = this.v) == null || fragmentManager.U0(this.y));
    }

    void y7() {
        onLowMemory();
    }

    String z5() {
        return "fragment_" + this.f + "_rq#" + this.S0.getAndIncrement();
    }

    boolean z6() {
        j jVar = this.E0;
        if (jVar == null) {
            return false;
        }
        return jVar.v;
    }

    void z7(boolean z) {
        Z6(z);
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        final Bundle a;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Bundle bundle) {
            this.a = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.a);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.a = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }
    }

    public Fragment(int i2) {
        this();
        this.R0 = i2;
    }
}
