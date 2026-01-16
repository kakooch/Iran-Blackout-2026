package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.transition.Transition;
import ir.nasim.QE0;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.transition.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1981d extends androidx.fragment.app.A {

    /* renamed from: androidx.transition.d$a */
    class a extends Transition.e {
        final /* synthetic */ Rect a;

        a(Rect rect) {
            this.a = rect;
        }

        @Override // androidx.transition.Transition.e
        public Rect a(Transition transition) {
            return this.a;
        }
    }

    /* renamed from: androidx.transition.d$b */
    class b implements Transition.f {
        final /* synthetic */ View a;
        final /* synthetic */ ArrayList b;

        b(View view, ArrayList arrayList) {
            this.a = view;
            this.b = arrayList;
        }

        @Override // androidx.transition.Transition.f
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.f
        public void b(Transition transition) {
            transition.W(this);
            transition.b(this);
        }

        @Override // androidx.transition.Transition.f
        public void c(Transition transition) {
        }

        @Override // androidx.transition.Transition.f
        public void d(Transition transition) {
            transition.W(this);
            this.a.setVisibility(8);
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.b.get(i)).setVisibility(0);
            }
        }

        @Override // androidx.transition.Transition.f
        public void e(Transition transition) {
        }
    }

    /* renamed from: androidx.transition.d$c */
    class c extends q {
        final /* synthetic */ Object a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ Object c;
        final /* synthetic */ ArrayList d;
        final /* synthetic */ Object e;
        final /* synthetic */ ArrayList f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.a = obj;
            this.b = arrayList;
            this.c = obj2;
            this.d = arrayList2;
            this.e = obj3;
            this.f = arrayList3;
        }

        @Override // androidx.transition.q, androidx.transition.Transition.f
        public void b(Transition transition) {
            Object obj = this.a;
            if (obj != null) {
                C1981d.this.D(obj, this.b, null);
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                C1981d.this.D(obj2, this.d, null);
            }
            Object obj3 = this.e;
            if (obj3 != null) {
                C1981d.this.D(obj3, this.f, null);
            }
        }

        @Override // androidx.transition.Transition.f
        public void d(Transition transition) {
            transition.W(this);
        }
    }

    /* renamed from: androidx.transition.d$d, reason: collision with other inner class name */
    class C0131d implements QE0.a {
        final /* synthetic */ Transition a;

        C0131d(Transition transition) {
            this.a = transition;
        }

        @Override // ir.nasim.QE0.a
        public void onCancel() {
            this.a.cancel();
        }
    }

    /* renamed from: androidx.transition.d$e */
    class e implements Transition.f {
        final /* synthetic */ Runnable a;

        e(Runnable runnable) {
            this.a = runnable;
        }

        @Override // androidx.transition.Transition.f
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.f
        public void b(Transition transition) {
        }

        @Override // androidx.transition.Transition.f
        public void c(Transition transition) {
        }

        @Override // androidx.transition.Transition.f
        public void d(Transition transition) {
            this.a.run();
        }

        @Override // androidx.transition.Transition.f
        public void e(Transition transition) {
        }
    }

    /* renamed from: androidx.transition.d$f */
    class f extends Transition.e {
        final /* synthetic */ Rect a;

        f(Rect rect) {
            this.a = rect;
        }

        @Override // androidx.transition.Transition.e
        public Rect a(Transition transition) {
            Rect rect = this.a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.a;
        }
    }

    private static boolean C(Transition transition) {
        return (androidx.fragment.app.A.l(transition.C()) && androidx.fragment.app.A.l(transition.D()) && androidx.fragment.app.A.l(transition.E())) ? false : true;
    }

    @Override // androidx.fragment.app.A
    public void A(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.F().clear();
            transitionSet.F().addAll(arrayList2);
            D(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.A
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.n0((Transition) obj);
        return transitionSet;
    }

    public void D(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int iQ0 = transitionSet.q0();
            while (i < iQ0) {
                D(transitionSet.p0(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (C(transition)) {
            return;
        }
        List listF = transition.F();
        if (listF.size() == arrayList.size() && listF.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                transition.c((View) arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.X((View) arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.A
    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).c(view);
        }
    }

    @Override // androidx.fragment.app.A
    public void b(Object obj, ArrayList arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int iQ0 = transitionSet.q0();
            while (i < iQ0) {
                b(transitionSet.p0(i), arrayList);
                i++;
            }
            return;
        }
        if (C(transition) || !androidx.fragment.app.A.l(transition.F())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            transition.c((View) arrayList.get(i));
            i++;
        }
    }

    @Override // androidx.fragment.app.A
    public void e(ViewGroup viewGroup, Object obj) {
        r.a(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.A
    public boolean g(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.A
    public Object h(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.A
    public Object o(Object obj, Object obj2, Object obj3) {
        Transition transitionW0 = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (transitionW0 != null && transition != null) {
            transitionW0 = new TransitionSet().n0(transitionW0).n0(transition).w0(1);
        } else if (transitionW0 == null) {
            transitionW0 = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return transitionW0;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transitionW0 != null) {
            transitionSet.n0(transitionW0);
        }
        transitionSet.n0(transition2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.A
    public Object p(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.n0((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.n0((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.n0((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.A
    public void r(Object obj, View view, ArrayList arrayList) {
        ((Transition) obj).b(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.A
    public void s(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((Transition) obj).b(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.A
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).c0(new f(rect));
        }
    }

    @Override // androidx.fragment.app.A
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((Transition) obj).c0(new a(rect));
        }
    }

    @Override // androidx.fragment.app.A
    public void w(Fragment fragment, Object obj, QE0 qe0, Runnable runnable) {
        Transition transition = (Transition) obj;
        qe0.c(new C0131d(transition));
        transition.b(new e(runnable));
    }

    @Override // androidx.fragment.app.A
    public void z(Object obj, View view, ArrayList arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List listF = transitionSet.F();
        listF.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            androidx.fragment.app.A.f(listF, (View) arrayList.get(i));
        }
        listF.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }
}
