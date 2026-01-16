package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12990fW7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class h extends x {
    private static TimeInterpolator s;
    private ArrayList h = new ArrayList();
    private ArrayList i = new ArrayList();
    private ArrayList j = new ArrayList();
    private ArrayList k = new ArrayList();
    ArrayList l = new ArrayList();
    ArrayList m = new ArrayList();
    ArrayList n = new ArrayList();
    ArrayList o = new ArrayList();
    ArrayList p = new ArrayList();
    ArrayList q = new ArrayList();
    ArrayList r = new ArrayList();

    class a implements Runnable {
        final /* synthetic */ ArrayList a;

        a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                h.this.Y(jVar.a, jVar.b, jVar.c, jVar.d, jVar.e);
            }
            this.a.clear();
            h.this.m.remove(this.a);
        }
    }

    class b implements Runnable {
        final /* synthetic */ ArrayList a;

        b(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                h.this.X((i) it.next());
            }
            this.a.clear();
            h.this.n.remove(this.a);
        }
    }

    class c implements Runnable {
        final /* synthetic */ ArrayList a;

        c(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                h.this.W((RecyclerView.C) it.next());
            }
            this.a.clear();
            h.this.l.remove(this.a);
        }
    }

    class d extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.C a;
        final /* synthetic */ ViewPropertyAnimator b;
        final /* synthetic */ View c;

        d(RecyclerView.C c, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = c;
            this.b = viewPropertyAnimator;
            this.c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.setListener(null);
            this.c.setAlpha(1.0f);
            h.this.L(this.a);
            h.this.q.remove(this.a);
            h.this.b0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.M(this.a);
        }
    }

    class e extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.C a;
        final /* synthetic */ View b;
        final /* synthetic */ ViewPropertyAnimator c;

        e(RecyclerView.C c, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = c;
            this.b = view;
            this.c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.c.setListener(null);
            h.this.F(this.a);
            h.this.o.remove(this.a);
            h.this.b0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.G(this.a);
        }
    }

    class f extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.C a;
        final /* synthetic */ int b;
        final /* synthetic */ View c;
        final /* synthetic */ int d;
        final /* synthetic */ ViewPropertyAnimator e;

        f(RecyclerView.C c, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = c;
            this.b = i;
            this.c = view;
            this.d = i2;
            this.e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.b != 0) {
                this.c.setTranslationX(0.0f);
            }
            if (this.d != 0) {
                this.c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.e.setListener(null);
            h.this.J(this.a);
            h.this.p.remove(this.a);
            h.this.b0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.K(this.a);
        }
    }

    class g extends AnimatorListenerAdapter {
        final /* synthetic */ i a;
        final /* synthetic */ ViewPropertyAnimator b;
        final /* synthetic */ View c;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = iVar;
            this.b = viewPropertyAnimator;
            this.c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.setListener(null);
            this.c.setAlpha(1.0f);
            this.c.setTranslationX(0.0f);
            this.c.setTranslationY(0.0f);
            h.this.H(this.a.a, true);
            h.this.r.remove(this.a.a);
            h.this.b0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.I(this.a.a, true);
        }
    }

    /* renamed from: androidx.recyclerview.widget.h$h, reason: collision with other inner class name */
    class C0113h extends AnimatorListenerAdapter {
        final /* synthetic */ i a;
        final /* synthetic */ ViewPropertyAnimator b;
        final /* synthetic */ View c;

        C0113h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = iVar;
            this.b = viewPropertyAnimator;
            this.c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.setListener(null);
            this.c.setAlpha(1.0f);
            this.c.setTranslationX(0.0f);
            this.c.setTranslationY(0.0f);
            h.this.H(this.a.b, false);
            h.this.r.remove(this.a.b);
            h.this.b0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.I(this.a.b, false);
        }
    }

    private static class j {
        public RecyclerView.C a;
        public int b;
        public int c;
        public int d;
        public int e;

        j(RecyclerView.C c, int i, int i2, int i3, int i4) {
            this.a = c;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    private void Z(RecyclerView.C c2) {
        View view = c2.a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.q.add(c2);
        viewPropertyAnimatorAnimate.setDuration(o()).alpha(0.0f).setListener(new d(c2, viewPropertyAnimatorAnimate, view)).start();
    }

    private void c0(List list, RecyclerView.C c2) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = (i) list.get(size);
            if (e0(iVar, c2) && iVar.a == null && iVar.b == null) {
                list.remove(iVar);
            }
        }
    }

    private void d0(i iVar) {
        RecyclerView.C c2 = iVar.a;
        if (c2 != null) {
            e0(iVar, c2);
        }
        RecyclerView.C c3 = iVar.b;
        if (c3 != null) {
            e0(iVar, c3);
        }
    }

    private boolean e0(i iVar, RecyclerView.C c2) {
        boolean z = false;
        if (iVar.b == c2) {
            iVar.b = null;
        } else {
            if (iVar.a != c2) {
                return false;
            }
            iVar.a = null;
            z = true;
        }
        c2.a.setAlpha(1.0f);
        c2.a.setTranslationX(0.0f);
        c2.a.setTranslationY(0.0f);
        H(c2, z);
        return true;
    }

    private void f0(RecyclerView.C c2) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        c2.a.animate().setInterpolator(s);
        j(c2);
    }

    @Override // androidx.recyclerview.widget.x
    public boolean B(RecyclerView.C c2) {
        f0(c2);
        c2.a.setAlpha(0.0f);
        this.i.add(c2);
        return true;
    }

    @Override // androidx.recyclerview.widget.x
    public boolean C(RecyclerView.C c2, RecyclerView.C c3, int i2, int i3, int i4, int i5) {
        if (c2 == c3) {
            return D(c2, i2, i3, i4, i5);
        }
        float translationX = c2.a.getTranslationX();
        float translationY = c2.a.getTranslationY();
        float alpha = c2.a.getAlpha();
        f0(c2);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        c2.a.setTranslationX(translationX);
        c2.a.setTranslationY(translationY);
        c2.a.setAlpha(alpha);
        if (c3 != null) {
            f0(c3);
            c3.a.setTranslationX(-i6);
            c3.a.setTranslationY(-i7);
            c3.a.setAlpha(0.0f);
        }
        this.k.add(new i(c2, c3, i2, i3, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.x
    public boolean D(RecyclerView.C c2, int i2, int i3, int i4, int i5) {
        View view = c2.a;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) c2.a.getTranslationY());
        f0(c2);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            J(c2);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.j.add(new j(c2, translationX, translationY, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.x
    public boolean E(RecyclerView.C c2) {
        f0(c2);
        this.h.add(c2);
        return true;
    }

    void W(RecyclerView.C c2) {
        View view = c2.a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.o.add(c2);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(l()).setListener(new e(c2, view, viewPropertyAnimatorAnimate)).start();
    }

    void X(i iVar) {
        RecyclerView.C c2 = iVar.a;
        View view = c2 == null ? null : c2.a;
        RecyclerView.C c3 = iVar.b;
        View view2 = c3 != null ? c3.a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.r.add(iVar.a);
            duration.translationX(iVar.e - iVar.c);
            duration.translationY(iVar.f - iVar.d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.r.add(iVar.b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new C0113h(iVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    void Y(RecyclerView.C c2, int i2, int i3, int i4, int i5) {
        View view = c2.a;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.p.add(c2);
        viewPropertyAnimatorAnimate.setDuration(n()).setListener(new f(c2, i6, view, i7, viewPropertyAnimatorAnimate)).start();
    }

    void a0(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.C) list.get(size)).a.animate().cancel();
        }
    }

    void b0() {
        if (p()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean g(RecyclerView.C c2, List list) {
        return !list.isEmpty() || super.g(c2, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void j(RecyclerView.C c2) {
        View view = c2.a;
        view.animate().cancel();
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((j) this.j.get(size)).a == c2) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                J(c2);
                this.j.remove(size);
            }
        }
        c0(this.k, c2);
        if (this.h.remove(c2)) {
            view.setAlpha(1.0f);
            L(c2);
        }
        if (this.i.remove(c2)) {
            view.setAlpha(1.0f);
            F(c2);
        }
        for (int size2 = this.n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.n.get(size2);
            c0(arrayList, c2);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        for (int size3 = this.m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((j) arrayList2.get(size4)).a == c2) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    J(c2);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.l.get(size5);
            if (arrayList3.remove(c2)) {
                view.setAlpha(1.0f);
                F(c2);
                if (arrayList3.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
        this.q.remove(c2);
        this.o.remove(c2);
        this.r.remove(c2);
        this.p.remove(c2);
        b0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void k() {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) this.j.get(size);
            View view = jVar.a.a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            J(jVar.a);
            this.j.remove(size);
        }
        for (int size2 = this.h.size() - 1; size2 >= 0; size2--) {
            L((RecyclerView.C) this.h.get(size2));
            this.h.remove(size2);
        }
        int size3 = this.i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.C c2 = (RecyclerView.C) this.i.get(size3);
            c2.a.setAlpha(1.0f);
            F(c2);
            this.i.remove(size3);
        }
        for (int size4 = this.k.size() - 1; size4 >= 0; size4--) {
            d0((i) this.k.get(size4));
        }
        this.k.clear();
        if (p()) {
            for (int size5 = this.m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.a.a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    J(jVar2.a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.C c3 = (RecyclerView.C) arrayList2.get(size8);
                    c3.a.setAlpha(1.0f);
                    F(c3);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    d0((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.n.remove(arrayList3);
                    }
                }
            }
            a0(this.q);
            a0(this.p);
            a0(this.o);
            a0(this.r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean p() {
        return (this.i.isEmpty() && this.k.isEmpty() && this.j.isEmpty() && this.h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void v() {
        boolean z = !this.h.isEmpty();
        boolean z2 = !this.j.isEmpty();
        boolean z3 = !this.k.isEmpty();
        boolean z4 = !this.i.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                Z((RecyclerView.C) it.next());
            }
            this.h.clear();
            if (z2) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.j);
                this.m.add(arrayList);
                this.j.clear();
                a aVar = new a(arrayList);
                if (z) {
                    AbstractC12990fW7.i0(((j) arrayList.get(0)).a.a, aVar, o());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.k);
                this.n.add(arrayList2);
                this.k.clear();
                b bVar = new b(arrayList2);
                if (z) {
                    AbstractC12990fW7.i0(((i) arrayList2.get(0)).a.a, bVar, o());
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.i);
                this.l.add(arrayList3);
                this.i.clear();
                c cVar = new c(arrayList3);
                if (z || z2 || z3) {
                    AbstractC12990fW7.i0(((RecyclerView.C) arrayList3.get(0)).a, cVar, (z ? o() : 0L) + Math.max(z2 ? n() : 0L, z3 ? m() : 0L));
                } else {
                    cVar.run();
                }
            }
        }
    }

    private static class i {
        public RecyclerView.C a;
        public RecyclerView.C b;
        public int c;
        public int d;
        public int e;
        public int f;

        private i(RecyclerView.C c, RecyclerView.C c2) {
            this.a = c;
            this.b = c2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }

        i(RecyclerView.C c, RecyclerView.C c2, int i, int i2, int i3, int i4) {
            this(c, c2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }
    }
}
