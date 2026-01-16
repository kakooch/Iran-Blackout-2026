package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.F;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import ir.nasim.AC5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.C4404Ez2;
import ir.nasim.InterfaceC15408jX7;

/* loaded from: classes2.dex */
class u {
    private final r a;
    private final w b;
    private final Fragment c;
    private boolean d = false;
    private int e = -1;

    class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.a.removeOnAttachStateChangeListener(this);
            AbstractC12990fW7.m0(this.a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j.b.values().length];
            a = iArr;
            try {
                iArr[j.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[j.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[j.b.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    u(r rVar, w wVar, Fragment fragment) {
        this.a = rVar;
        this.b = wVar;
        this.c = fragment;
    }

    private boolean l(View view) {
        if (view == this.c.B0) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.c.B0) {
                return true;
            }
        }
        return false;
    }

    void a() {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.c);
        }
        Bundle bundle = this.c.b;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        this.c.n7(bundle2);
        this.a.a(this.c, bundle2, false);
    }

    void b() {
        Fragment fragmentS0 = FragmentManager.s0(this.c.A0);
        Fragment fragmentU5 = this.c.U5();
        if (fragmentS0 != null && !fragmentS0.equals(fragmentU5)) {
            Fragment fragment = this.c;
            C4404Ez2.n(fragment, fragmentS0, fragment.A);
        }
        int iJ = this.b.j(this.c);
        Fragment fragment2 = this.c;
        fragment2.A0.addView(fragment2.B0, iJ);
    }

    void c() {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.c);
        }
        Fragment fragment = this.c;
        Fragment fragment2 = fragment.h;
        u uVarN = null;
        if (fragment2 != null) {
            u uVarN2 = this.b.n(fragment2.f);
            if (uVarN2 == null) {
                throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.h + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.c;
            fragment3.i = fragment3.h.f;
            fragment3.h = null;
            uVarN = uVarN2;
        } else {
            String str = fragment.i;
            if (str != null && (uVarN = this.b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.c + " declared target fragment " + this.c.i + " that does not belong to this FragmentManager!");
            }
        }
        if (uVarN != null) {
            uVarN.m();
        }
        Fragment fragment4 = this.c;
        fragment4.w = fragment4.v.D0();
        Fragment fragment5 = this.c;
        fragment5.y = fragment5.v.G0();
        this.a.g(this.c, false);
        this.c.o7();
        this.a.b(this.c, false);
    }

    int d() {
        Fragment fragment = this.c;
        if (fragment.v == null) {
            return fragment.a;
        }
        int iMin = this.e;
        int i = b.a[fragment.L0.ordinal()];
        if (i != 1) {
            iMin = i != 2 ? i != 3 ? i != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        Fragment fragment2 = this.c;
        if (fragment2.p) {
            if (fragment2.q) {
                iMin = Math.max(this.e, 2);
                View view = this.c.B0;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.e < 4 ? Math.min(iMin, fragment2.a) : Math.min(iMin, 1);
            }
        }
        Fragment fragment3 = this.c;
        if (fragment3.r && fragment3.A0 == null) {
            iMin = Math.min(iMin, 4);
        }
        if (!this.c.l) {
            iMin = Math.min(iMin, 1);
        }
        Fragment fragment4 = this.c;
        ViewGroup viewGroup = fragment4.A0;
        F.d.a aVarS = viewGroup != null ? F.u(viewGroup, fragment4.V5()).s(this) : null;
        if (aVarS == F.d.a.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (aVarS == F.d.a.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment5 = this.c;
            if (fragment5.m) {
                iMin = fragment5.x6() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment6 = this.c;
        if (fragment6.C0 && fragment6.a < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (this.c.n) {
            iMin = Math.max(iMin, 3);
        }
        if (FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + this.c);
        }
        return iMin;
    }

    void e() {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.c);
        }
        Bundle bundle = this.c.b;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        Fragment fragment = this.c;
        if (fragment.J0) {
            fragment.a = 1;
            fragment.W7();
        } else {
            this.a.h(fragment, bundle2, false);
            this.c.r7(bundle2);
            this.a.c(this.c, bundle2, false);
        }
    }

    void f() throws Resources.NotFoundException {
        String resourceName;
        if (this.c.p) {
            return;
        }
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
        }
        Bundle bundle = this.c.b;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater layoutInflaterX7 = this.c.x7(bundle2);
        Fragment fragment = this.c;
        ViewGroup viewGroup2 = fragment.A0;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = fragment.A;
            if (i != 0) {
                if (i == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment.v.y0().h(this.c.A);
                if (viewGroup == null) {
                    Fragment fragment2 = this.c;
                    if (!fragment2.s && !fragment2.r) {
                        try {
                            resourceName = fragment2.b6().getResourceName(this.c.A);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE;
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.c.A) + " (" + resourceName + ") for fragment " + this.c);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    C4404Ez2.m(this.c, viewGroup);
                }
            }
        }
        Fragment fragment3 = this.c;
        fragment3.A0 = viewGroup;
        fragment3.t7(layoutInflaterX7, viewGroup, bundle2);
        if (this.c.B0 != null) {
            if (FragmentManager.Q0(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.c);
            }
            this.c.B0.setSaveFromParentEnabled(false);
            Fragment fragment4 = this.c;
            fragment4.B0.setTag(AC5.fragment_container_view_tag, fragment4);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment5 = this.c;
            if (fragment5.D) {
                fragment5.B0.setVisibility(8);
            }
            if (this.c.B0.isAttachedToWindow()) {
                AbstractC12990fW7.m0(this.c.B0);
            } else {
                View view = this.c.B0;
                view.addOnAttachStateChangeListener(new a(view));
            }
            this.c.K7();
            r rVar = this.a;
            Fragment fragment6 = this.c;
            rVar.m(fragment6, fragment6.B0, bundle2, false);
            int visibility = this.c.B0.getVisibility();
            this.c.h8(this.c.B0.getAlpha());
            Fragment fragment7 = this.c;
            if (fragment7.A0 != null && visibility == 0) {
                View viewFindFocus = fragment7.B0.findFocus();
                if (viewFindFocus != null) {
                    this.c.b8(viewFindFocus);
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.c);
                    }
                }
                this.c.B0.setAlpha(0.0f);
            }
        }
        this.c.a = 2;
    }

    void g() {
        Fragment fragmentF;
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.c);
        }
        Fragment fragment = this.c;
        boolean zIsChangingConfigurations = true;
        boolean z = fragment.m && !fragment.x6();
        if (z) {
            Fragment fragment2 = this.c;
            if (!fragment2.o) {
                this.b.B(fragment2.f, null);
            }
        }
        if (!z && !this.b.p().c1(this.c)) {
            String str = this.c.i;
            if (str != null && (fragmentF = this.b.f(str)) != null && fragmentF.H) {
                this.c.h = fragmentF;
            }
            this.c.a = 0;
            return;
        }
        p pVar = this.c.w;
        if (pVar instanceof InterfaceC15408jX7) {
            zIsChangingConfigurations = this.b.p().Z0();
        } else if (pVar.k() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) pVar.k()).isChangingConfigurations();
        }
        if ((z && !this.c.o) || zIsChangingConfigurations) {
            this.b.p().R0(this.c, false);
        }
        this.c.u7();
        this.a.d(this.c, false);
        for (u uVar : this.b.k()) {
            if (uVar != null) {
                Fragment fragmentK = uVar.k();
                if (this.c.f.equals(fragmentK.i)) {
                    fragmentK.h = this.c;
                    fragmentK.i = null;
                }
            }
        }
        Fragment fragment3 = this.c;
        String str2 = fragment3.i;
        if (str2 != null) {
            fragment3.h = this.b.f(str2);
        }
        this.b.s(this);
    }

    void h() {
        View view;
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.c);
        }
        Fragment fragment = this.c;
        ViewGroup viewGroup = fragment.A0;
        if (viewGroup != null && (view = fragment.B0) != null) {
            viewGroup.removeView(view);
        }
        this.c.v7();
        this.a.n(this.c, false);
        Fragment fragment2 = this.c;
        fragment2.A0 = null;
        fragment2.B0 = null;
        fragment2.N0 = null;
        fragment2.O0.p(null);
        this.c.q = false;
    }

    void i() {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.c);
        }
        this.c.w7();
        this.a.e(this.c, false);
        Fragment fragment = this.c;
        fragment.a = -1;
        fragment.w = null;
        fragment.y = null;
        fragment.v = null;
        if ((!fragment.m || fragment.x6()) && !this.b.p().c1(this.c)) {
            return;
        }
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + this.c);
        }
        this.c.s6();
    }

    void j() {
        Fragment fragment = this.c;
        if (fragment.p && fragment.q && !fragment.t) {
            if (FragmentManager.Q0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.c);
            }
            Bundle bundle = this.c.b;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            Fragment fragment2 = this.c;
            fragment2.t7(fragment2.x7(bundle2), null, bundle2);
            View view = this.c.B0;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.c;
                fragment3.B0.setTag(AC5.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.c;
                if (fragment4.D) {
                    fragment4.B0.setVisibility(8);
                }
                this.c.K7();
                r rVar = this.a;
                Fragment fragment5 = this.c;
                rVar.m(fragment5, fragment5.B0, bundle2, false);
                this.c.a = 2;
            }
        }
    }

    Fragment k() {
        return this.c;
    }

    void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.d) {
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.d = true;
            boolean z = false;
            while (true) {
                int iD = d();
                Fragment fragment = this.c;
                int i = fragment.a;
                if (iD == i) {
                    if (!z && i == -1 && fragment.m && !fragment.x6() && !this.c.o) {
                        if (FragmentManager.Q0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.c);
                        }
                        this.b.p().R0(this.c, true);
                        this.b.s(this);
                        if (FragmentManager.Q0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.c);
                        }
                        this.c.s6();
                    }
                    Fragment fragment2 = this.c;
                    if (fragment2.H0) {
                        if (fragment2.B0 != null && (viewGroup = fragment2.A0) != null) {
                            F fU = F.u(viewGroup, fragment2.V5());
                            if (this.c.D) {
                                fU.k(this);
                            } else {
                                fU.m(this);
                            }
                        }
                        Fragment fragment3 = this.c;
                        FragmentManager fragmentManager = fragment3.v;
                        if (fragmentManager != null) {
                            fragmentManager.O0(fragment3);
                        }
                        Fragment fragment4 = this.c;
                        fragment4.H0 = false;
                        fragment4.W6(fragment4.D);
                        this.c.x.P();
                    }
                    this.d = false;
                    return;
                }
                if (iD <= i) {
                    switch (i - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            if (fragment.o && this.b.q(fragment.f) == null) {
                                this.b.B(this.c.f, r());
                            }
                            g();
                            break;
                        case 1:
                            h();
                            this.c.a = 1;
                            break;
                        case 2:
                            fragment.q = false;
                            fragment.a = 2;
                            break;
                        case 3:
                            if (FragmentManager.Q0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.c);
                            }
                            Fragment fragment5 = this.c;
                            if (fragment5.o) {
                                this.b.B(fragment5.f, r());
                            } else if (fragment5.B0 != null && fragment5.c == null) {
                                s();
                            }
                            Fragment fragment6 = this.c;
                            if (fragment6.B0 != null && (viewGroup2 = fragment6.A0) != null) {
                                F.u(viewGroup2, fragment6.V5()).l(this);
                            }
                            this.c.a = 3;
                            break;
                        case 4:
                            v();
                            break;
                        case 5:
                            fragment.a = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.B0 != null && (viewGroup3 = fragment.A0) != null) {
                                F.u(viewGroup3, fragment.V5()).j(F.d.b.p(this.c.B0.getVisibility()), this);
                            }
                            this.c.a = 4;
                            break;
                        case 5:
                            u();
                            break;
                        case 6:
                            fragment.a = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
                z = true;
            }
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }

    void n() {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.c);
        }
        this.c.C7();
        this.a.f(this.c, false);
    }

    void o(ClassLoader classLoader) {
        Bundle bundle = this.c.b;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (this.c.b.getBundle("savedInstanceState") == null) {
            this.c.b.putBundle("savedInstanceState", new Bundle());
        }
        try {
            Fragment fragment = this.c;
            fragment.c = fragment.b.getSparseParcelableArray("viewState");
            Fragment fragment2 = this.c;
            fragment2.d = fragment2.b.getBundle("viewRegistryState");
            FragmentState fragmentState = (FragmentState) this.c.b.getParcelable("state");
            if (fragmentState != null) {
                Fragment fragment3 = this.c;
                fragment3.i = fragmentState.m;
                fragment3.j = fragmentState.n;
                Boolean bool = fragment3.e;
                if (bool != null) {
                    fragment3.D0 = bool.booleanValue();
                    this.c.e = null;
                } else {
                    fragment3.D0 = fragmentState.o;
                }
            }
            Fragment fragment4 = this.c;
            if (fragment4.D0) {
                return;
            }
            fragment4.C0 = true;
        } catch (BadParcelableException e) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + k(), e);
        }
    }

    void p() {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.c);
        }
        View viewN5 = this.c.N5();
        if (viewN5 != null && l(viewN5)) {
            boolean zRequestFocus = viewN5.requestFocus();
            if (FragmentManager.Q0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(viewN5);
                sb.append(Separators.SP);
                sb.append(zRequestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.c);
                sb.append(" resulting in focused view ");
                sb.append(this.c.B0.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.c.b8(null);
        this.c.G7();
        this.a.i(this.c, false);
        this.b.B(this.c.f, null);
        Fragment fragment = this.c;
        fragment.b = null;
        fragment.c = null;
        fragment.d = null;
    }

    Fragment.SavedState q() {
        if (this.c.a > -1) {
            return new Fragment.SavedState(r());
        }
        return null;
    }

    Bundle r() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        Fragment fragment = this.c;
        if (fragment.a == -1 && (bundle = fragment.b) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new FragmentState(this.c));
        if (this.c.a > -1) {
            Bundle bundle3 = new Bundle();
            this.c.H7(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.a.j(this.c, bundle3, false);
            Bundle bundle4 = new Bundle();
            this.c.Q0.e(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle bundleY0 = this.c.x.Y0();
            if (!bundleY0.isEmpty()) {
                bundle2.putBundle("childFragmentManager", bundleY0);
            }
            if (this.c.B0 != null) {
                s();
            }
            SparseArray<? extends Parcelable> sparseArray = this.c.c;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = this.c.d;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = this.c.g;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    void s() {
        if (this.c.B0 == null) {
            return;
        }
        if (FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.c + " with view " + this.c.B0);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.c.B0.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.c.c = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.c.N0.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.c.d = bundle;
    }

    void t(int i) {
        this.e = i;
    }

    void u() {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.c);
        }
        this.c.I7();
        this.a.k(this.c, false);
    }

    void v() {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.c);
        }
        this.c.J7();
        this.a.l(this.c, false);
    }

    u(r rVar, w wVar, ClassLoader classLoader, o oVar, Bundle bundle) {
        this.a = rVar;
        this.b = wVar;
        Fragment fragmentA = ((FragmentState) bundle.getParcelable("state")).a(oVar, classLoader);
        this.c = fragmentA;
        fragmentA.b = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        fragmentA.a8(bundle2);
        if (FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentA);
        }
    }

    u(r rVar, w wVar, Fragment fragment, Bundle bundle) {
        this.a = rVar;
        this.b = wVar;
        this.c = fragment;
        fragment.c = null;
        fragment.d = null;
        fragment.u = 0;
        fragment.q = false;
        fragment.l = false;
        Fragment fragment2 = fragment.h;
        fragment.i = fragment2 != null ? fragment2.f : null;
        fragment.h = null;
        fragment.b = bundle;
        fragment.g = bundle.getBundle("arguments");
    }
}
