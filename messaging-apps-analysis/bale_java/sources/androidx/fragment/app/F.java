package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import ir.nasim.AC5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.TV;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public abstract class F {
    public static final a g = new a(null);
    private final ViewGroup a;
    private final List b;
    private final List c;
    private boolean d;
    private boolean e;
    private boolean f;

    public static final class a {
        private a() {
        }

        public final F a(ViewGroup viewGroup, FragmentManager fragmentManager) {
            AbstractC13042fc3.i(viewGroup, "container");
            AbstractC13042fc3.i(fragmentManager, "fragmentManager");
            G gI0 = fragmentManager.I0();
            AbstractC13042fc3.h(gI0, "fragmentManager.specialEffectsControllerFactory");
            return b(viewGroup, gI0);
        }

        public final F b(ViewGroup viewGroup, G g) {
            AbstractC13042fc3.i(viewGroup, "container");
            AbstractC13042fc3.i(g, "factory");
            Object tag = viewGroup.getTag(AC5.special_effects_controller_view_tag);
            if (tag instanceof F) {
                return (F) tag;
            }
            F fA = g.a(viewGroup);
            AbstractC13042fc3.h(fA, "factory.createController(container)");
            viewGroup.setTag(AC5.special_effects_controller_view_tag, fA);
            return fA;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static class b {
        private final boolean a;
        private boolean b;
        private boolean c;

        public final void a(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "container");
            if (!this.c) {
                c(viewGroup);
            }
            this.c = true;
        }

        public boolean b() {
            return this.a;
        }

        public abstract void c(ViewGroup viewGroup);

        public abstract void d(ViewGroup viewGroup);

        public void e(TV tv, ViewGroup viewGroup) {
            AbstractC13042fc3.i(tv, "backEvent");
            AbstractC13042fc3.i(viewGroup, "container");
        }

        public void f(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "container");
        }

        public final void g(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "container");
            if (!this.b) {
                f(viewGroup);
            }
            this.b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c extends d {
        private final u l;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(d.b bVar, d.a aVar, u uVar) {
            AbstractC13042fc3.i(bVar, "finalState");
            AbstractC13042fc3.i(aVar, "lifecycleImpact");
            AbstractC13042fc3.i(uVar, "fragmentStateManager");
            Fragment fragmentK = uVar.k();
            AbstractC13042fc3.h(fragmentK, "fragmentStateManager.fragment");
            super(bVar, aVar, fragmentK);
            this.l = uVar;
        }

        @Override // androidx.fragment.app.F.d
        public void d() {
            super.d();
            h().n = false;
            this.l.m();
        }

        @Override // androidx.fragment.app.F.d
        public void p() {
            if (n()) {
                return;
            }
            super.p();
            if (i() != d.a.ADDING) {
                if (i() == d.a.REMOVING) {
                    Fragment fragmentK = this.l.k();
                    AbstractC13042fc3.h(fragmentK, "fragmentStateManager.fragment");
                    View viewV7 = fragmentK.V7();
                    AbstractC13042fc3.h(viewV7, "fragment.requireView()");
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + viewV7.findFocus() + " on view " + viewV7 + " for Fragment " + fragmentK);
                    }
                    viewV7.clearFocus();
                    return;
                }
                return;
            }
            Fragment fragmentK2 = this.l.k();
            AbstractC13042fc3.h(fragmentK2, "fragmentStateManager.fragment");
            View viewFindFocus = fragmentK2.B0.findFocus();
            if (viewFindFocus != null) {
                fragmentK2.b8(viewFindFocus);
                if (FragmentManager.Q0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragmentK2);
                }
            }
            View viewV72 = h().V7();
            AbstractC13042fc3.h(viewV72, "this.fragment.requireView()");
            if (viewV72.getParent() == null) {
                this.l.b();
                viewV72.setAlpha(0.0f);
            }
            if (viewV72.getAlpha() == 0.0f && viewV72.getVisibility() == 0) {
                viewV72.setVisibility(4);
            }
            viewV72.setAlpha(fragmentK2.Z5());
        }
    }

    public static class d {
        private b a;
        private a b;
        private final Fragment c;
        private final List d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private final List j;
        private final List k;

        public enum a {
            NONE,
            ADDING,
            REMOVING
        }

        public enum b {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static final a a = new a(null);

            public static final class a {
                private a() {
                }

                public final b a(View view) {
                    AbstractC13042fc3.i(view, "<this>");
                    return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? b.INVISIBLE : b(view.getVisibility());
                }

                public final b b(int i) {
                    if (i == 0) {
                        return b.VISIBLE;
                    }
                    if (i == 4) {
                        return b.INVISIBLE;
                    }
                    if (i == 8) {
                        return b.GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i);
                }

                public /* synthetic */ a(ED1 ed1) {
                    this();
                }
            }

            /* renamed from: androidx.fragment.app.F$d$b$b, reason: collision with other inner class name */
            public /* synthetic */ class C0086b {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.REMOVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.VISIBLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.GONE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.INVISIBLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    a = iArr;
                }
            }

            public static final b p(int i) {
                return a.b(i);
            }

            public final void j(View view, ViewGroup viewGroup) {
                AbstractC13042fc3.i(view, "view");
                AbstractC13042fc3.i(viewGroup, "container");
                int i = C0086b.a[ordinal()];
                if (i == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup2 != null) {
                        if (FragmentManager.Q0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup2);
                        }
                        viewGroup2.removeView(view);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    ViewParent parent2 = view.getParent();
                    if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                        if (FragmentManager.Q0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + viewGroup);
                        }
                        viewGroup.addView(view);
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i == 3) {
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i != 4) {
                    return;
                }
                if (FragmentManager.Q0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        public /* synthetic */ class c {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ADDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.REMOVING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        public d(b bVar, a aVar, Fragment fragment) {
            AbstractC13042fc3.i(bVar, "finalState");
            AbstractC13042fc3.i(aVar, "lifecycleImpact");
            AbstractC13042fc3.i(fragment, "fragment");
            this.a = bVar;
            this.b = aVar;
            this.c = fragment;
            this.d = new ArrayList();
            this.i = true;
            ArrayList arrayList = new ArrayList();
            this.j = arrayList;
            this.k = arrayList;
        }

        public final void a(Runnable runnable) {
            AbstractC13042fc3.i(runnable, "listener");
            this.d.add(runnable);
        }

        public final void b(b bVar) {
            AbstractC13042fc3.i(bVar, "effect");
            this.j.add(bVar);
        }

        public final void c(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "container");
            this.h = false;
            if (this.e) {
                return;
            }
            this.e = true;
            if (this.j.isEmpty()) {
                d();
                return;
            }
            Iterator it = AbstractC15401jX0.m1(this.k).iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(viewGroup);
            }
        }

        public void d() {
            this.h = false;
            if (this.f) {
                return;
            }
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f = true;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void e(b bVar) {
            AbstractC13042fc3.i(bVar, "effect");
            if (this.j.remove(bVar) && this.j.isEmpty()) {
                d();
            }
        }

        public final List f() {
            return this.k;
        }

        public final b g() {
            return this.a;
        }

        public final Fragment h() {
            return this.c;
        }

        public final a i() {
            return this.b;
        }

        public final boolean j() {
            return this.i;
        }

        public final boolean k() {
            return this.e;
        }

        public final boolean l() {
            return this.f;
        }

        public final boolean m() {
            return this.g;
        }

        public final boolean n() {
            return this.h;
        }

        public final void o(b bVar, a aVar) {
            AbstractC13042fc3.i(bVar, "finalState");
            AbstractC13042fc3.i(aVar, "lifecycleImpact");
            int i = c.a[aVar.ordinal()];
            if (i == 1) {
                if (this.a == b.REMOVED) {
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.b + " to ADDING.");
                    }
                    this.a = b.VISIBLE;
                    this.b = a.ADDING;
                    this.i = true;
                    return;
                }
                return;
            }
            if (i == 2) {
                if (FragmentManager.Q0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> REMOVED. mLifecycleImpact  = " + this.b + " to REMOVING.");
                }
                this.a = b.REMOVED;
                this.b = a.REMOVING;
                this.i = true;
                return;
            }
            if (i == 3 && this.a != b.REMOVED) {
                if (FragmentManager.Q0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.c + " mFinalState = " + this.a + " -> " + bVar + '.');
                }
                this.a = bVar;
            }
        }

        public void p() {
            this.h = true;
        }

        public final void q(boolean z) {
            this.i = z;
        }

        public final void r(boolean z) {
            this.g = z;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + this.a + " lifecycleImpact = " + this.b + " fragment = " + this.c + '}';
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.a.values().length];
            try {
                iArr[d.a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    public F(ViewGroup viewGroup) {
        AbstractC13042fc3.i(viewGroup, "container");
        this.a = viewGroup;
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    private final void B(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((d) list.get(i)).p();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(arrayList, ((d) it.next()).f());
        }
        List listM1 = AbstractC15401jX0.m1(AbstractC15401jX0.r1(arrayList));
        int size2 = listM1.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((b) listM1.get(i2)).g(this.a);
        }
    }

    private final void C() {
        for (d dVar : this.b) {
            if (dVar.i() == d.a.ADDING) {
                View viewV7 = dVar.h().V7();
                AbstractC13042fc3.h(viewV7, "fragment.requireView()");
                dVar.o(d.b.a.b(viewV7.getVisibility()), d.a.NONE);
            }
        }
    }

    private final void g(d.b bVar, d.a aVar, u uVar) {
        synchronized (this.b) {
            try {
                Fragment fragmentK = uVar.k();
                AbstractC13042fc3.h(fragmentK, "fragmentStateManager.fragment");
                d dVarO = o(fragmentK);
                if (dVarO == null) {
                    if (uVar.k().n) {
                        Fragment fragmentK2 = uVar.k();
                        AbstractC13042fc3.h(fragmentK2, "fragmentStateManager.fragment");
                        dVarO = p(fragmentK2);
                    } else {
                        dVarO = null;
                    }
                }
                if (dVarO != null) {
                    dVarO.o(bVar, aVar);
                    return;
                }
                final c cVar = new c(bVar, aVar, uVar);
                this.b.add(cVar);
                cVar.a(new Runnable() { // from class: androidx.fragment.app.D
                    @Override // java.lang.Runnable
                    public final void run() {
                        F.h(this.a, cVar);
                    }
                });
                cVar.a(new Runnable() { // from class: androidx.fragment.app.E
                    @Override // java.lang.Runnable
                    public final void run() {
                        F.i(this.a, cVar);
                    }
                });
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(F f, c cVar) {
        AbstractC13042fc3.i(f, "this$0");
        AbstractC13042fc3.i(cVar, "$operation");
        if (f.b.contains(cVar)) {
            d.b bVarG = cVar.g();
            View view = cVar.h().B0;
            AbstractC13042fc3.h(view, "operation.fragment.mView");
            bVarG.j(view, f.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(F f, c cVar) {
        AbstractC13042fc3.i(f, "this$0");
        AbstractC13042fc3.i(cVar, "$operation");
        f.b.remove(cVar);
        f.c.remove(cVar);
    }

    private final d o(Fragment fragment) {
        Object next;
        Iterator it = this.b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            d dVar = (d) next;
            if (AbstractC13042fc3.d(dVar.h(), fragment) && !dVar.k()) {
                break;
            }
        }
        return (d) next;
    }

    private final d p(Fragment fragment) {
        Object next;
        Iterator it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            d dVar = (d) next;
            if (AbstractC13042fc3.d(dVar.h(), fragment) && !dVar.k()) {
                break;
            }
        }
        return (d) next;
    }

    public static final F u(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return g.a(viewGroup, fragmentManager);
    }

    public static final F v(ViewGroup viewGroup, G g2) {
        return g.b(viewGroup, g2);
    }

    private final boolean w(List list) {
        boolean z;
        List<d> list2 = list;
        loop0: while (true) {
            z = true;
            for (d dVar : list2) {
                if (!dVar.f().isEmpty()) {
                    List listF = dVar.f();
                    if (!(listF instanceof Collection) || !listF.isEmpty()) {
                        Iterator it = listF.iterator();
                        while (it.hasNext()) {
                            if (!((b) it.next()).b()) {
                                break;
                            }
                        }
                    }
                }
                z = false;
            }
            break loop0;
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                AbstractC13610gX0.D(arrayList, ((d) it2.next()).f());
            }
            if (!arrayList.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private final boolean x(List list) {
        Iterator it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!((d) it.next()).h().n) {
                z = false;
            }
        }
        return z;
    }

    public final void A(TV tv) {
        AbstractC13042fc3.i(tv, "backEvent");
        if (FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + tv.a());
        }
        List list = this.c;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(arrayList, ((d) it.next()).f());
        }
        List listM1 = AbstractC15401jX0.m1(AbstractC15401jX0.r1(arrayList));
        int size = listM1.size();
        for (int i = 0; i < size; i++) {
            ((b) listM1.get(i)).e(tv, this.a);
        }
    }

    public final void D(boolean z) {
        this.e = z;
    }

    public final void c(d dVar) {
        AbstractC13042fc3.i(dVar, "operation");
        if (dVar.j()) {
            d.b bVarG = dVar.g();
            View viewV7 = dVar.h().V7();
            AbstractC13042fc3.h(viewV7, "operation.fragment.requireView()");
            bVarG.j(viewV7, this.a);
            dVar.q(false);
        }
    }

    public abstract void d(List list, boolean z);

    public void e(List list) {
        AbstractC13042fc3.i(list, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(arrayList, ((d) it.next()).f());
        }
        List listM1 = AbstractC15401jX0.m1(AbstractC15401jX0.r1(arrayList));
        int size = listM1.size();
        for (int i = 0; i < size; i++) {
            ((b) listM1.get(i)).d(this.a);
        }
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            c((d) list.get(i2));
        }
        List listM12 = AbstractC15401jX0.m1(list);
        int size3 = listM12.size();
        for (int i3 = 0; i3 < size3; i3++) {
            d dVar = (d) listM12.get(i3);
            if (dVar.f().isEmpty()) {
                dVar.d();
            }
        }
    }

    public final void f() {
        if (FragmentManager.Q0(3)) {
            Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
        }
        B(this.c);
        e(this.c);
    }

    public final void j(d.b bVar, u uVar) {
        AbstractC13042fc3.i(bVar, "finalState");
        AbstractC13042fc3.i(uVar, "fragmentStateManager");
        if (FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + uVar.k());
        }
        g(bVar, d.a.ADDING, uVar);
    }

    public final void k(u uVar) {
        AbstractC13042fc3.i(uVar, "fragmentStateManager");
        if (FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + uVar.k());
        }
        g(d.b.GONE, d.a.NONE, uVar);
    }

    public final void l(u uVar) {
        AbstractC13042fc3.i(uVar, "fragmentStateManager");
        if (FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + uVar.k());
        }
        g(d.b.REMOVED, d.a.REMOVING, uVar);
    }

    public final void m(u uVar) {
        AbstractC13042fc3.i(uVar, "fragmentStateManager");
        if (FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + uVar.k());
        }
        g(d.b.VISIBLE, d.a.NONE, uVar);
    }

    public final void n() {
        if (this.f) {
            return;
        }
        if (!this.a.isAttachedToWindow()) {
            q();
            this.e = false;
            return;
        }
        synchronized (this.b) {
            try {
                List<d> listP1 = AbstractC15401jX0.p1(this.c);
                this.c.clear();
                for (d dVar : listP1) {
                    dVar.r((this.b.isEmpty() ^ true) && dVar.h().n);
                }
                for (d dVar2 : listP1) {
                    if (this.d) {
                        if (FragmentManager.Q0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Completing non-seekable operation " + dVar2);
                        }
                        dVar2.d();
                    } else {
                        if (FragmentManager.Q0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + dVar2);
                        }
                        dVar2.c(this.a);
                    }
                    this.d = false;
                    if (!dVar2.l()) {
                        this.c.add(dVar2);
                    }
                }
                if (!this.b.isEmpty()) {
                    C();
                    List listP12 = AbstractC15401jX0.p1(this.b);
                    if (listP12.isEmpty()) {
                        return;
                    }
                    this.b.clear();
                    this.c.addAll(listP12);
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    d(listP12, this.e);
                    boolean zW = w(listP12);
                    boolean zX = x(listP12);
                    this.d = zX && !zW;
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Operation seekable = " + zW + " \ntransition = " + zX);
                    }
                    if (!zX) {
                        B(listP12);
                        e(listP12);
                    } else if (zW) {
                        B(listP12);
                        int size = listP12.size();
                        for (int i = 0; i < size; i++) {
                            c((d) listP12.get(i));
                        }
                    }
                    this.e = false;
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void q() {
        if (FragmentManager.Q0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean zIsAttachedToWindow = this.a.isAttachedToWindow();
        synchronized (this.b) {
            try {
                C();
                B(this.b);
                List<d> listP1 = AbstractC15401jX0.p1(this.c);
                Iterator it = listP1.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).r(false);
                }
                for (d dVar : listP1) {
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.a + " is not attached to window. ") + "Cancelling running operation " + dVar);
                    }
                    dVar.c(this.a);
                }
                List<d> listP12 = AbstractC15401jX0.p1(this.b);
                Iterator it2 = listP12.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).r(false);
                }
                for (d dVar2 : listP12) {
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: " + (zIsAttachedToWindow ? "" : "Container " + this.a + " is not attached to window. ") + "Cancelling pending operation " + dVar2);
                    }
                    dVar2.c(this.a);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r() {
        if (this.f) {
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f = false;
            n();
        }
    }

    public final d.a s(u uVar) {
        AbstractC13042fc3.i(uVar, "fragmentStateManager");
        Fragment fragmentK = uVar.k();
        AbstractC13042fc3.h(fragmentK, "fragmentStateManager.fragment");
        d dVarO = o(fragmentK);
        d.a aVarI = dVarO != null ? dVarO.i() : null;
        d dVarP = p(fragmentK);
        d.a aVarI2 = dVarP != null ? dVarP.i() : null;
        int i = aVarI == null ? -1 : e.a[aVarI.ordinal()];
        return (i == -1 || i == 1) ? aVarI2 : aVarI;
    }

    public final ViewGroup t() {
        return this.a;
    }

    public final boolean y() {
        return !this.b.isEmpty();
    }

    public final void z() {
        Object objPrevious;
        synchronized (this.b) {
            try {
                C();
                List list = this.b;
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        objPrevious = null;
                        break;
                    }
                    objPrevious = listIterator.previous();
                    d dVar = (d) objPrevious;
                    d.b.a aVar = d.b.a;
                    View view = dVar.h().B0;
                    AbstractC13042fc3.h(view, "operation.fragment.mView");
                    d.b bVarA = aVar.a(view);
                    d.b bVarG = dVar.g();
                    d.b bVar = d.b.VISIBLE;
                    if (bVarG == bVar && bVarA != bVar) {
                        break;
                    }
                }
                d dVar2 = (d) objPrevious;
                Fragment fragmentH = dVar2 != null ? dVar2.h() : null;
                this.f = fragmentH != null ? fragmentH.z6() : false;
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
