package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class v extends androidx.viewpager.widget.a {
    private final FragmentManager c;
    private final int d;
    private x e;
    private ArrayList f;
    private ArrayList g;
    private Fragment h;
    private boolean i;

    public v(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.e == null) {
            this.e = this.c.s();
        }
        while (this.f.size() <= i) {
            this.f.add(null);
        }
        this.f.set(i, fragment.u6() ? this.c.D1(fragment) : null);
        this.g.set(i, null);
        this.e.p(fragment);
        if (fragment.equals(this.h)) {
            this.h = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void c(ViewGroup viewGroup) {
        x xVar = this.e;
        if (xVar != null) {
            if (!this.i) {
                try {
                    this.i = true;
                    xVar.k();
                } finally {
                    this.i = false;
                }
            }
            this.e = null;
        }
    }

    @Override // androidx.viewpager.widget.a
    public Object h(ViewGroup viewGroup, int i) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.g.size() > i && (fragment = (Fragment) this.g.get(i)) != null) {
            return fragment;
        }
        if (this.e == null) {
            this.e = this.c.s();
        }
        Fragment fragmentT = t(i);
        if (this.f.size() > i && (savedState = (Fragment.SavedState) this.f.get(i)) != null) {
            fragmentT.d8(savedState);
        }
        while (this.g.size() <= i) {
            this.g.add(null);
        }
        fragmentT.e8(false);
        if (this.d == 0) {
            fragmentT.l8(false);
        }
        this.g.set(i, fragmentT);
        this.e.b(viewGroup.getId(), fragmentT);
        if (this.d == 1) {
            this.e.u(fragmentT, j.b.STARTED);
        }
        return fragmentT;
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object obj) {
        return ((Fragment) obj).o6() == view;
    }

    @Override // androidx.viewpager.widget.a
    public void l(Parcelable parcelable, ClassLoader classLoader) throws NumberFormatException {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f.clear();
            this.g.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int i = Integer.parseInt(str.substring(1));
                    Fragment fragmentZ0 = this.c.z0(bundle, str);
                    if (fragmentZ0 != null) {
                        while (this.g.size() <= i) {
                            this.g.add(null);
                        }
                        fragmentZ0.e8(false);
                        this.g.set(i, fragmentZ0);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable m() {
        Bundle bundle;
        if (this.f.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f.size()];
            this.f.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = (Fragment) this.g.get(i);
            if (fragment != null && fragment.u6()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.c.s1(bundle, "f" + i, fragment);
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager.widget.a
    public void o(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.h;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.e8(false);
                if (this.d == 1) {
                    if (this.e == null) {
                        this.e = this.c.s();
                    }
                    this.e.u(this.h, j.b.STARTED);
                } else {
                    this.h.l8(false);
                }
            }
            fragment.e8(true);
            if (this.d == 1) {
                if (this.e == null) {
                    this.e = this.c.s();
                }
                this.e.u(fragment, j.b.RESUMED);
            } else {
                fragment.l8(true);
            }
            this.h = fragment;
        }
    }

    @Override // androidx.viewpager.widget.a
    public void r(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public abstract Fragment t(int i);

    public v(FragmentManager fragmentManager, int i) {
        this.e = null;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = null;
        this.c = fragmentManager;
        this.d = i;
    }
}
