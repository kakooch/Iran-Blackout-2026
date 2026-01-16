package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.C1959c;
import androidx.fragment.app.F;
import androidx.fragment.app.m;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC23789xW7;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9203Yx6;
import ir.nasim.C12889fL5;
import ir.nasim.C19938rB7;
import ir.nasim.KJ;
import ir.nasim.OK4;
import ir.nasim.QE0;
import ir.nasim.SA2;
import ir.nasim.TV;
import ir.nasim.UA2;
import ir.nasim.XV4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1959c extends F {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.fragment.app.c$a */
    static final class a extends F.b {
        private final b d;

        /* renamed from: androidx.fragment.app.c$a$a, reason: collision with other inner class name */
        public static final class AnimationAnimationListenerC0087a implements Animation.AnimationListener {
            final /* synthetic */ F.d a;
            final /* synthetic */ ViewGroup b;
            final /* synthetic */ View c;
            final /* synthetic */ a d;

            AnimationAnimationListenerC0087a(F.d dVar, ViewGroup viewGroup, View view, a aVar) {
                this.a = dVar;
                this.b = viewGroup;
                this.c = view;
                this.d = aVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(ViewGroup viewGroup, View view, a aVar) {
                AbstractC13042fc3.i(viewGroup, "$container");
                AbstractC13042fc3.i(aVar, "this$0");
                viewGroup.endViewTransition(view);
                aVar.h().a().e(aVar);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AbstractC13042fc3.i(animation, "animation");
                final ViewGroup viewGroup = this.b;
                final View view = this.c;
                final a aVar = this.d;
                viewGroup.post(new Runnable() { // from class: androidx.fragment.app.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        C1959c.a.AnimationAnimationListenerC0087a.b(viewGroup, view, aVar);
                    }
                });
                if (FragmentManager.Q0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.a + " has ended.");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                AbstractC13042fc3.i(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                AbstractC13042fc3.i(animation, "animation");
                if (FragmentManager.Q0(2)) {
                    Log.v("FragmentManager", "Animation from operation " + this.a + " has reached onAnimationStart.");
                }
            }
        }

        public a(b bVar) {
            AbstractC13042fc3.i(bVar, "animationInfo");
            this.d = bVar;
        }

        @Override // androidx.fragment.app.F.b
        public void c(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "container");
            F.d dVarA = this.d.a();
            View view = dVarA.h().B0;
            view.clearAnimation();
            viewGroup.endViewTransition(view);
            this.d.a().e(this);
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Animation from operation " + dVarA + " has been cancelled.");
            }
        }

        @Override // androidx.fragment.app.F.b
        public void d(ViewGroup viewGroup) throws Resources.NotFoundException {
            AbstractC13042fc3.i(viewGroup, "container");
            if (this.d.b()) {
                this.d.a().e(this);
                return;
            }
            Context context = viewGroup.getContext();
            F.d dVarA = this.d.a();
            View view = dVarA.h().B0;
            b bVar = this.d;
            AbstractC13042fc3.h(context, "context");
            m.a aVarC = bVar.c(context);
            if (aVarC == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            Animation animation = aVarC.a;
            if (animation == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            if (dVarA.g() != F.d.b.REMOVED) {
                view.startAnimation(animation);
                this.d.a().e(this);
                return;
            }
            viewGroup.startViewTransition(view);
            m.b bVar2 = new m.b(animation, viewGroup, view);
            bVar2.setAnimationListener(new AnimationAnimationListenerC0087a(dVarA, viewGroup, view, this));
            view.startAnimation(bVar2);
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Animation from operation " + dVarA + " has started.");
            }
        }

        public final b h() {
            return this.d;
        }
    }

    /* renamed from: androidx.fragment.app.c$b */
    private static final class b extends f {
        private final boolean b;
        private boolean c;
        private m.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(F.d dVar, boolean z) {
            super(dVar);
            AbstractC13042fc3.i(dVar, "operation");
            this.b = z;
        }

        public final m.a c(Context context) throws Resources.NotFoundException {
            AbstractC13042fc3.i(context, "context");
            if (this.c) {
                return this.d;
            }
            m.a aVarB = m.b(context, a().h(), a().g() == F.d.b.VISIBLE, this.b);
            this.d = aVarB;
            this.c = true;
            return aVarB;
        }
    }

    /* renamed from: androidx.fragment.app.c$c, reason: collision with other inner class name */
    private static final class C0088c extends F.b {
        private final b d;
        private AnimatorSet e;

        /* renamed from: androidx.fragment.app.c$c$a */
        public static final class a extends AnimatorListenerAdapter {
            final /* synthetic */ ViewGroup a;
            final /* synthetic */ View b;
            final /* synthetic */ boolean c;
            final /* synthetic */ F.d d;
            final /* synthetic */ C0088c e;

            a(ViewGroup viewGroup, View view, boolean z, F.d dVar, C0088c c0088c) {
                this.a = viewGroup;
                this.b = view;
                this.c = z;
                this.d = dVar;
                this.e = c0088c;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AbstractC13042fc3.i(animator, "anim");
                this.a.endViewTransition(this.b);
                if (this.c) {
                    F.d.b bVarG = this.d.g();
                    View view = this.b;
                    AbstractC13042fc3.h(view, "viewToAnimate");
                    bVarG.j(view, this.a);
                }
                this.e.h().a().e(this.e);
                if (FragmentManager.Q0(2)) {
                    Log.v("FragmentManager", "Animator from operation " + this.d + " has ended.");
                }
            }
        }

        public C0088c(b bVar) {
            AbstractC13042fc3.i(bVar, "animatorInfo");
            this.d = bVar;
        }

        @Override // androidx.fragment.app.F.b
        public boolean b() {
            return true;
        }

        @Override // androidx.fragment.app.F.b
        public void c(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "container");
            AnimatorSet animatorSet = this.e;
            if (animatorSet == null) {
                this.d.a().e(this);
                return;
            }
            F.d dVarA = this.d.a();
            if (!dVarA.m()) {
                animatorSet.end();
            } else if (Build.VERSION.SDK_INT >= 26) {
                e.a.a(animatorSet);
            }
            if (FragmentManager.Q0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Animator from operation ");
                sb.append(dVarA);
                sb.append(" has been canceled");
                sb.append(dVarA.m() ? " with seeking." : Separators.DOT);
                sb.append(' ');
                Log.v("FragmentManager", sb.toString());
            }
        }

        @Override // androidx.fragment.app.F.b
        public void d(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "container");
            F.d dVarA = this.d.a();
            AnimatorSet animatorSet = this.e;
            if (animatorSet == null) {
                this.d.a().e(this);
                return;
            }
            animatorSet.start();
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Animator from operation " + dVarA + " has started.");
            }
        }

        @Override // androidx.fragment.app.F.b
        public void e(TV tv, ViewGroup viewGroup) {
            AbstractC13042fc3.i(tv, "backEvent");
            AbstractC13042fc3.i(viewGroup, "container");
            F.d dVarA = this.d.a();
            AnimatorSet animatorSet = this.e;
            if (animatorSet == null) {
                this.d.a().e(this);
                return;
            }
            if (Build.VERSION.SDK_INT < 34 || !dVarA.h().n) {
                return;
            }
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Adding BackProgressCallbacks for Animators to operation " + dVarA);
            }
            long jA = d.a.a(animatorSet);
            long jA2 = (long) (tv.a() * jA);
            if (jA2 == 0) {
                jA2 = 1;
            }
            if (jA2 == jA) {
                jA2 = jA - 1;
            }
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Setting currentPlayTime to " + jA2 + " for Animator " + animatorSet + " on operation " + dVarA);
            }
            e.a.b(animatorSet, jA2);
        }

        @Override // androidx.fragment.app.F.b
        public void f(ViewGroup viewGroup) throws Resources.NotFoundException {
            AbstractC13042fc3.i(viewGroup, "container");
            if (this.d.b()) {
                return;
            }
            Context context = viewGroup.getContext();
            b bVar = this.d;
            AbstractC13042fc3.h(context, "context");
            m.a aVarC = bVar.c(context);
            this.e = aVarC != null ? aVarC.b : null;
            F.d dVarA = this.d.a();
            Fragment fragmentH = dVarA.h();
            boolean z = dVarA.g() == F.d.b.GONE;
            View view = fragmentH.B0;
            viewGroup.startViewTransition(view);
            AnimatorSet animatorSet = this.e;
            if (animatorSet != null) {
                animatorSet.addListener(new a(viewGroup, view, z, dVarA, this));
            }
            AnimatorSet animatorSet2 = this.e;
            if (animatorSet2 != null) {
                animatorSet2.setTarget(view);
            }
        }

        public final b h() {
            return this.d;
        }
    }

    /* renamed from: androidx.fragment.app.c$d */
    public static final class d {
        public static final d a = new d();

        private d() {
        }

        public final long a(AnimatorSet animatorSet) {
            AbstractC13042fc3.i(animatorSet, "animatorSet");
            return animatorSet.getTotalDuration();
        }
    }

    /* renamed from: androidx.fragment.app.c$e */
    public static final class e {
        public static final e a = new e();

        private e() {
        }

        public final void a(AnimatorSet animatorSet) {
            AbstractC13042fc3.i(animatorSet, "animatorSet");
            animatorSet.reverse();
        }

        public final void b(AnimatorSet animatorSet, long j) {
            AbstractC13042fc3.i(animatorSet, "animatorSet");
            animatorSet.setCurrentPlayTime(j);
        }
    }

    /* renamed from: androidx.fragment.app.c$f */
    public static class f {
        private final F.d a;

        public f(F.d dVar) {
            AbstractC13042fc3.i(dVar, "operation");
            this.a = dVar;
        }

        public final F.d a() {
            return this.a;
        }

        public final boolean b() {
            F.d.b bVar;
            View view = this.a.h().B0;
            F.d.b bVarA = view != null ? F.d.b.a.a(view) : null;
            F.d.b bVarG = this.a.g();
            return bVarA == bVarG || !(bVarA == (bVar = F.d.b.VISIBLE) || bVarG == bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.fragment.app.c$g */
    static final class g extends F.b {
        private final List d;
        private final F.d e;
        private final F.d f;
        private final A g;
        private final Object h;
        private final ArrayList i;
        private final ArrayList j;
        private final KJ k;
        private final ArrayList l;
        private final ArrayList m;
        private final KJ n;
        private final KJ o;
        private final boolean p;
        private final QE0 q;
        private Object r;

        /* renamed from: androidx.fragment.app.c$g$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ ViewGroup f;
            final /* synthetic */ Object g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ViewGroup viewGroup, Object obj) {
                super(0);
                this.f = viewGroup;
                this.g = obj;
            }

            public final void a() {
                g.this.v().e(this.f, this.g);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* renamed from: androidx.fragment.app.c$g$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ ViewGroup f;
            final /* synthetic */ Object g;
            final /* synthetic */ C12889fL5 h;

            /* renamed from: androidx.fragment.app.c$g$b$a */
            static final class a extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ g e;
                final /* synthetic */ Object f;
                final /* synthetic */ ViewGroup g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(g gVar, Object obj, ViewGroup viewGroup) {
                    super(0);
                    this.e = gVar;
                    this.f = obj;
                    this.g = viewGroup;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void d(g gVar, ViewGroup viewGroup) {
                    AbstractC13042fc3.i(gVar, "this$0");
                    AbstractC13042fc3.i(viewGroup, "$container");
                    Iterator it = gVar.w().iterator();
                    while (it.hasNext()) {
                        F.d dVarA = ((h) it.next()).a();
                        View viewO6 = dVarA.h().o6();
                        if (viewO6 != null) {
                            dVarA.g().j(viewO6, viewGroup);
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void f(g gVar) {
                    AbstractC13042fc3.i(gVar, "this$0");
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "Transition for all operations has completed");
                    }
                    Iterator it = gVar.w().iterator();
                    while (it.hasNext()) {
                        ((h) it.next()).a().e(gVar);
                    }
                }

                public final void c() {
                    List listW = this.e.w();
                    if (!(listW instanceof Collection) || !listW.isEmpty()) {
                        Iterator it = listW.iterator();
                        while (it.hasNext()) {
                            if (!((h) it.next()).a().m()) {
                                if (FragmentManager.Q0(2)) {
                                    Log.v("FragmentManager", "Completing animating immediately");
                                }
                                QE0 qe0 = new QE0();
                                A aV = this.e.v();
                                Fragment fragmentH = ((h) this.e.w().get(0)).a().h();
                                Object obj = this.f;
                                final g gVar = this.e;
                                aV.w(fragmentH, obj, qe0, new Runnable() { // from class: androidx.fragment.app.k
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        C1959c.g.b.a.f(gVar);
                                    }
                                });
                                qe0.a();
                                return;
                            }
                        }
                    }
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "Animating to start");
                    }
                    A aV2 = this.e.v();
                    Object objS = this.e.s();
                    AbstractC13042fc3.f(objS);
                    final g gVar2 = this.e;
                    final ViewGroup viewGroup = this.g;
                    aV2.d(objS, new Runnable() { // from class: androidx.fragment.app.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            C1959c.g.b.a.d(gVar2, viewGroup);
                        }
                    });
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    c();
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(ViewGroup viewGroup, Object obj, C12889fL5 c12889fL5) {
                super(0);
                this.f = viewGroup;
                this.g = obj;
                this.h = c12889fL5;
            }

            public final void a() {
                g gVar = g.this;
                gVar.C(gVar.v().j(this.f, this.g));
                boolean z = g.this.s() != null;
                Object obj = this.g;
                ViewGroup viewGroup = this.f;
                if (!z) {
                    throw new IllegalStateException(("Unable to start transition " + obj + " for container " + viewGroup + '.').toString());
                }
                this.h.a = new a(g.this, obj, viewGroup);
                if (FragmentManager.Q0(2)) {
                    Log.v("FragmentManager", "Started executing operations from " + g.this.t() + " to " + g.this.u());
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        public g(List list, F.d dVar, F.d dVar2, A a2, Object obj, ArrayList arrayList, ArrayList arrayList2, KJ kj, ArrayList arrayList3, ArrayList arrayList4, KJ kj2, KJ kj3, boolean z) {
            AbstractC13042fc3.i(list, "transitionInfos");
            AbstractC13042fc3.i(a2, "transitionImpl");
            AbstractC13042fc3.i(arrayList, "sharedElementFirstOutViews");
            AbstractC13042fc3.i(arrayList2, "sharedElementLastInViews");
            AbstractC13042fc3.i(kj, "sharedElementNameMapping");
            AbstractC13042fc3.i(arrayList3, "enteringNames");
            AbstractC13042fc3.i(arrayList4, "exitingNames");
            AbstractC13042fc3.i(kj2, "firstOutViews");
            AbstractC13042fc3.i(kj3, "lastInViews");
            this.d = list;
            this.e = dVar;
            this.f = dVar2;
            this.g = a2;
            this.h = obj;
            this.i = arrayList;
            this.j = arrayList2;
            this.k = kj;
            this.l = arrayList3;
            this.m = arrayList4;
            this.n = kj2;
            this.o = kj3;
            this.p = z;
            this.q = new QE0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void A(F.d dVar, g gVar) {
            AbstractC13042fc3.i(dVar, "$operation");
            AbstractC13042fc3.i(gVar, "this$0");
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Transition for operation " + dVar + " has completed");
            }
            dVar.e(gVar);
        }

        private final void B(ArrayList arrayList, ViewGroup viewGroup, SA2 sa2) {
            y.e(arrayList, 4);
            ArrayList arrayListQ = this.g.q(this.j);
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", ">>>>> Beginning transition <<<<<");
                Log.v("FragmentManager", ">>>>> SharedElementFirstOutViews <<<<<");
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    AbstractC13042fc3.h(next, "sharedElementFirstOutViews");
                    View view = (View) next;
                    Log.v("FragmentManager", "View: " + view + " Name: " + AbstractC12990fW7.J(view));
                }
                Log.v("FragmentManager", ">>>>> SharedElementLastInViews <<<<<");
                Iterator it2 = this.j.iterator();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    AbstractC13042fc3.h(next2, "sharedElementLastInViews");
                    View view2 = (View) next2;
                    Log.v("FragmentManager", "View: " + view2 + " Name: " + AbstractC12990fW7.J(view2));
                }
            }
            sa2.invoke();
            this.g.y(viewGroup, this.i, this.j, arrayListQ, this.k);
            y.e(arrayList, 0);
            this.g.A(this.h, this.i, this.j);
        }

        private final void n(ArrayList arrayList, View view) {
            if (!(view instanceof ViewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (AbstractC23789xW7.a(viewGroup)) {
                if (arrayList.contains(view)) {
                    return;
                }
                arrayList.add(view);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    AbstractC13042fc3.h(childAt, "child");
                    n(arrayList, childAt);
                }
            }
        }

        private final XV4 o(ViewGroup viewGroup, F.d dVar, final F.d dVar2) {
            final F.d dVar3 = dVar;
            View view = new View(viewGroup.getContext());
            final Rect rect = new Rect();
            Iterator it = this.d.iterator();
            boolean z = false;
            View view2 = null;
            while (it.hasNext()) {
                if (((h) it.next()).g() && dVar2 != null && dVar3 != null && (!this.k.isEmpty()) && this.h != null) {
                    y.a(dVar.h(), dVar2.h(), this.p, this.n, true);
                    OK4.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            C1959c.g.p(dVar3, dVar2, this);
                        }
                    });
                    this.i.addAll(this.n.values());
                    if (!this.m.isEmpty()) {
                        Object obj = this.m.get(0);
                        AbstractC13042fc3.h(obj, "exitingNames[0]");
                        view2 = (View) this.n.get((String) obj);
                        this.g.v(this.h, view2);
                    }
                    this.j.addAll(this.o.values());
                    if (!this.l.isEmpty()) {
                        Object obj2 = this.l.get(0);
                        AbstractC13042fc3.h(obj2, "enteringNames[0]");
                        final View view3 = (View) this.o.get((String) obj2);
                        if (view3 != null) {
                            final A a2 = this.g;
                            OK4.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.h
                                @Override // java.lang.Runnable
                                public final void run() {
                                    C1959c.g.q(a2, view3, rect);
                                }
                            });
                            z = true;
                        }
                    }
                    this.g.z(this.h, view, this.i);
                    A a3 = this.g;
                    Object obj3 = this.h;
                    a3.s(obj3, null, null, null, null, obj3, this.j);
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = this.d.iterator();
            Object objP = null;
            Object objP2 = null;
            while (it2.hasNext()) {
                h hVar = (h) it2.next();
                F.d dVarA = hVar.a();
                Iterator it3 = it2;
                Object objH = this.g.h(hVar.f());
                if (objH != null) {
                    final ArrayList arrayList2 = new ArrayList();
                    Object obj4 = objP2;
                    View view4 = dVarA.h().B0;
                    Object obj5 = objP;
                    AbstractC13042fc3.h(view4, "operation.fragment.mView");
                    n(arrayList2, view4);
                    if (this.h != null && (dVarA == dVar2 || dVarA == dVar3)) {
                        if (dVarA == dVar2) {
                            arrayList2.removeAll(AbstractC15401jX0.r1(this.i));
                        } else {
                            arrayList2.removeAll(AbstractC15401jX0.r1(this.j));
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        this.g.a(objH, view);
                    } else {
                        this.g.b(objH, arrayList2);
                        this.g.s(objH, objH, arrayList2, null, null, null, null);
                        if (dVarA.g() == F.d.b.GONE) {
                            dVarA.q(false);
                            ArrayList arrayList3 = new ArrayList(arrayList2);
                            arrayList3.remove(dVarA.h().B0);
                            this.g.r(objH, dVarA.h().B0, arrayList3);
                            OK4.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.i
                                @Override // java.lang.Runnable
                                public final void run() {
                                    C1959c.g.r(arrayList2);
                                }
                            });
                        }
                    }
                    if (dVarA.g() == F.d.b.VISIBLE) {
                        arrayList.addAll(arrayList2);
                        if (z) {
                            this.g.u(objH, rect);
                        }
                        if (FragmentManager.Q0(2)) {
                            Log.v("FragmentManager", "Entering Transition: " + objH);
                            Log.v("FragmentManager", ">>>>> EnteringViews <<<<<");
                            Iterator it4 = arrayList2.iterator();
                            while (it4.hasNext()) {
                                Object next = it4.next();
                                AbstractC13042fc3.h(next, "transitioningViews");
                                Log.v("FragmentManager", "View: " + ((View) next));
                            }
                        }
                    } else {
                        this.g.v(objH, view2);
                        if (FragmentManager.Q0(2)) {
                            Log.v("FragmentManager", "Exiting Transition: " + objH);
                            Log.v("FragmentManager", ">>>>> ExitingViews <<<<<");
                            Iterator it5 = arrayList2.iterator();
                            while (it5.hasNext()) {
                                Object next2 = it5.next();
                                AbstractC13042fc3.h(next2, "transitioningViews");
                                Log.v("FragmentManager", "View: " + ((View) next2));
                            }
                        }
                    }
                    if (hVar.h()) {
                        objP = this.g.p(obj5, objH, null);
                        dVar3 = dVar;
                        it2 = it3;
                        objP2 = obj4;
                    } else {
                        objP = obj5;
                        objP2 = this.g.p(obj4, objH, null);
                        dVar3 = dVar;
                        it2 = it3;
                    }
                } else {
                    dVar3 = dVar;
                    it2 = it3;
                }
            }
            Object objO = this.g.o(objP, objP2, this.h);
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Final merged transition: " + objO);
            }
            return new XV4(arrayList, objO);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(F.d dVar, F.d dVar2, g gVar) {
            AbstractC13042fc3.i(gVar, "this$0");
            y.a(dVar.h(), dVar2.h(), gVar.p, gVar.o, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(A a2, View view, Rect rect) {
            AbstractC13042fc3.i(a2, "$impl");
            AbstractC13042fc3.i(rect, "$lastInEpicenterRect");
            a2.k(view, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(ArrayList arrayList) {
            AbstractC13042fc3.i(arrayList, "$transitioningViews");
            y.e(arrayList, 4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(F.d dVar, g gVar) {
            AbstractC13042fc3.i(dVar, "$operation");
            AbstractC13042fc3.i(gVar, "this$0");
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Transition for operation " + dVar + " has completed");
            }
            dVar.e(gVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(C12889fL5 c12889fL5) {
            AbstractC13042fc3.i(c12889fL5, "$seekCancelLambda");
            SA2 sa2 = (SA2) c12889fL5.a;
            if (sa2 != null) {
                sa2.invoke();
            }
        }

        public final void C(Object obj) {
            this.r = obj;
        }

        @Override // androidx.fragment.app.F.b
        public boolean b() {
            Object obj;
            if (this.g.m()) {
                List<h> list = this.d;
                if ((list instanceof Collection) && list.isEmpty()) {
                    obj = this.h;
                    if (obj != null) {
                    }
                    return true;
                }
                for (h hVar : list) {
                    if (Build.VERSION.SDK_INT < 34 || hVar.f() == null || !this.g.n(hVar.f())) {
                        break;
                    }
                }
                obj = this.h;
                if (obj != null || this.g.n(obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.fragment.app.F.b
        public void c(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "container");
            this.q.a();
        }

        @Override // androidx.fragment.app.F.b
        public void d(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "container");
            if (!viewGroup.isLaidOut()) {
                for (h hVar : this.d) {
                    F.d dVarA = hVar.a();
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + viewGroup + " has not been laid out. Completing operation " + dVarA);
                    }
                    hVar.a().e(this);
                }
                return;
            }
            Object obj = this.r;
            if (obj != null) {
                A a2 = this.g;
                AbstractC13042fc3.f(obj);
                a2.c(obj);
                if (FragmentManager.Q0(2)) {
                    Log.v("FragmentManager", "Ending execution of operations from " + this.e + " to " + this.f);
                    return;
                }
                return;
            }
            XV4 xv4O = o(viewGroup, this.f, this.e);
            ArrayList arrayList = (ArrayList) xv4O.a();
            Object objB = xv4O.b();
            List list = this.d;
            ArrayList<F.d> arrayList2 = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(((h) it.next()).a());
            }
            for (final F.d dVar : arrayList2) {
                this.g.w(dVar.h(), objB, this.q, new Runnable() { // from class: androidx.fragment.app.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        C1959c.g.y(dVar, this);
                    }
                });
            }
            B(arrayList, viewGroup, new a(viewGroup, objB));
            if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Completed executing operations from " + this.e + " to " + this.f);
            }
        }

        @Override // androidx.fragment.app.F.b
        public void e(TV tv, ViewGroup viewGroup) {
            AbstractC13042fc3.i(tv, "backEvent");
            AbstractC13042fc3.i(viewGroup, "container");
            Object obj = this.r;
            if (obj != null) {
                this.g.t(obj, tv.a());
            }
        }

        @Override // androidx.fragment.app.F.b
        public void f(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "container");
            if (!viewGroup.isLaidOut()) {
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    F.d dVarA = ((h) it.next()).a();
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Container " + viewGroup + " has not been laid out. Skipping onStart for operation " + dVarA);
                    }
                }
                return;
            }
            if (x() && this.h != null && !b()) {
                Log.i("FragmentManager", "Ignoring shared elements transition " + this.h + " between " + this.e + " and " + this.f + " as neither fragment has set a Transition. In order to run a SharedElementTransition, you must also set either an enter or exit transition on a fragment involved in the transaction. The sharedElementTransition will run after the back gesture has been committed.");
            }
            if (b() && x()) {
                final C12889fL5 c12889fL5 = new C12889fL5();
                XV4 xv4O = o(viewGroup, this.f, this.e);
                ArrayList arrayList = (ArrayList) xv4O.a();
                Object objB = xv4O.b();
                List list = this.d;
                ArrayList<F.d> arrayList2 = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((h) it2.next()).a());
                }
                for (final F.d dVar : arrayList2) {
                    this.g.x(dVar.h(), objB, this.q, new Runnable() { // from class: androidx.fragment.app.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            C1959c.g.z(c12889fL5);
                        }
                    }, new Runnable() { // from class: androidx.fragment.app.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            C1959c.g.A(dVar, this);
                        }
                    });
                }
                B(arrayList, viewGroup, new b(viewGroup, objB, c12889fL5));
            }
        }

        public final Object s() {
            return this.r;
        }

        public final F.d t() {
            return this.e;
        }

        public final F.d u() {
            return this.f;
        }

        public final A v() {
            return this.g;
        }

        public final List w() {
            return this.d;
        }

        public final boolean x() {
            List list = this.d;
            if ((list instanceof Collection) && list.isEmpty()) {
                return true;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!((h) it.next()).a().h().n) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: androidx.fragment.app.c$h */
    private static final class h extends f {
        private final Object b;
        private final boolean c;
        private final Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(F.d dVar, boolean z, boolean z2) {
            Object objC6;
            super(dVar);
            AbstractC13042fc3.i(dVar, "operation");
            F.d.b bVarG = dVar.g();
            F.d.b bVar = F.d.b.VISIBLE;
            if (bVarG == bVar) {
                Fragment fragmentH = dVar.h();
                objC6 = z ? fragmentH.a6() : fragmentH.I5();
            } else {
                Fragment fragmentH2 = dVar.h();
                objC6 = z ? fragmentH2.c6() : fragmentH2.L5();
            }
            this.b = objC6;
            this.c = dVar.g() == bVar ? z ? dVar.h().C5() : dVar.h().B5() : true;
            this.d = z2 ? z ? dVar.h().e6() : dVar.h().d6() : null;
        }

        private final A d(Object obj) {
            if (obj == null) {
                return null;
            }
            A a = y.b;
            if (a != null && a.g(obj)) {
                return a;
            }
            A a2 = y.c;
            if (a2 != null && a2.g(obj)) {
                return a2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + a().h() + " is not a valid framework Transition or AndroidX Transition");
        }

        public final A c() {
            A aD = d(this.b);
            A aD2 = d(this.d);
            if (aD == null || aD2 == null || aD == aD2) {
                return aD == null ? aD2 : aD;
            }
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + a().h() + " returned Transition " + this.b + " which uses a different Transition  type than its shared element transition " + this.d).toString());
        }

        public final Object e() {
            return this.d;
        }

        public final Object f() {
            return this.b;
        }

        public final boolean g() {
            return this.d != null;
        }

        public final boolean h() {
            return this.c;
        }
    }

    /* renamed from: androidx.fragment.app.c$i */
    static final class i extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Collection e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Collection collection) {
            super(1);
            this.e = collection;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Map.Entry entry) {
            AbstractC13042fc3.i(entry, "entry");
            return Boolean.valueOf(AbstractC15401jX0.i0(this.e, AbstractC12990fW7.J((View) entry.getValue())));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1959c(ViewGroup viewGroup) {
        super(viewGroup);
        AbstractC13042fc3.i(viewGroup, "container");
    }

    private final void F(List list) throws Resources.NotFoundException {
        ArrayList<b> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(arrayList2, ((b) it.next()).a().f());
        }
        boolean z = !arrayList2.isEmpty();
        Iterator it2 = list.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            b bVar = (b) it2.next();
            Context context = t().getContext();
            F.d dVarA = bVar.a();
            AbstractC13042fc3.h(context, "context");
            m.a aVarC = bVar.c(context);
            if (aVarC != null) {
                if (aVarC.b == null) {
                    arrayList.add(bVar);
                } else {
                    Fragment fragmentH = dVarA.h();
                    if (!(!dVarA.f().isEmpty())) {
                        if (dVarA.g() == F.d.b.GONE) {
                            dVarA.q(false);
                        }
                        dVarA.b(new C0088c(bVar));
                        z2 = true;
                    } else if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", "Ignoring Animator set on " + fragmentH + " as this Fragment was involved in a Transition.");
                    }
                }
            }
        }
        for (b bVar2 : arrayList) {
            F.d dVarA2 = bVar2.a();
            Fragment fragmentH2 = dVarA2.h();
            if (z) {
                if (FragmentManager.Q0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragmentH2 + " as Animations cannot run alongside Transitions.");
                }
            } else if (!z2) {
                dVarA2.b(new a(bVar2));
            } else if (FragmentManager.Q0(2)) {
                Log.v("FragmentManager", "Ignoring Animation set on " + fragmentH2 + " as Animations cannot run alongside Animators.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(C1959c c1959c, F.d dVar) {
        AbstractC13042fc3.i(c1959c, "this$0");
        AbstractC13042fc3.i(dVar, "$operation");
        c1959c.c(dVar);
    }

    private final void H(List list, boolean z, F.d dVar, F.d dVar2) {
        Object obj;
        A a2;
        ArrayList arrayList;
        ArrayList arrayList2;
        Iterator it;
        ArrayList arrayList3;
        Object obj2;
        String strB;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : list) {
            if (!((h) obj3).b()) {
                arrayList4.add(obj3);
            }
        }
        ArrayList<h> arrayList5 = new ArrayList();
        for (Object obj4 : arrayList4) {
            if (((h) obj4).c() != null) {
                arrayList5.add(obj4);
            }
        }
        A a3 = null;
        for (h hVar : arrayList5) {
            A aC = hVar.c();
            if (a3 != null && aC != a3) {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + hVar.a().h() + " returned Transition " + hVar.f() + " which uses a different Transition type than other Fragments.").toString());
            }
            a3 = aC;
        }
        if (a3 == null) {
            return;
        }
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        KJ kj = new KJ();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        KJ kj2 = new KJ();
        KJ kj3 = new KJ();
        Iterator it2 = arrayList5.iterator();
        ArrayList arrayListG6 = arrayList8;
        ArrayList arrayListF6 = arrayList9;
        loop3: while (true) {
            obj = null;
            while (it2.hasNext()) {
                h hVar2 = (h) it2.next();
                if (!hVar2.g() || dVar == null || dVar2 == null) {
                    a2 = a3;
                    arrayList = arrayList6;
                    arrayList2 = arrayList7;
                    it = it2;
                    arrayList3 = arrayList5;
                } else {
                    Object objB = a3.B(a3.h(hVar2.e()));
                    arrayListF6 = dVar2.h().f6();
                    AbstractC13042fc3.h(arrayListF6, "lastIn.fragment.sharedElementSourceNames");
                    ArrayList arrayListF62 = dVar.h().f6();
                    AbstractC13042fc3.h(arrayListF62, "firstOut.fragment.sharedElementSourceNames");
                    ArrayList arrayListG62 = dVar.h().g6();
                    AbstractC13042fc3.h(arrayListG62, "firstOut.fragment.sharedElementTargetNames");
                    int size = arrayListG62.size();
                    a2 = a3;
                    it = it2;
                    int i2 = 0;
                    while (i2 < size) {
                        int i3 = size;
                        int iIndexOf = arrayListF6.indexOf(arrayListG62.get(i2));
                        if (iIndexOf != -1) {
                            arrayListF6.set(iIndexOf, arrayListF62.get(i2));
                        }
                        i2++;
                        size = i3;
                    }
                    arrayListG6 = dVar2.h().g6();
                    AbstractC13042fc3.h(arrayListG6, "lastIn.fragment.sharedElementTargetNames");
                    XV4 xv4A = !z ? AbstractC4616Fw7.a(dVar.h().M5(), dVar2.h().J5()) : AbstractC4616Fw7.a(dVar.h().J5(), dVar2.h().M5());
                    AbstractC9203Yx6 abstractC9203Yx6 = (AbstractC9203Yx6) xv4A.a();
                    AbstractC9203Yx6 abstractC9203Yx62 = (AbstractC9203Yx6) xv4A.b();
                    int size2 = arrayListF6.size();
                    int i4 = 0;
                    arrayList3 = arrayList5;
                    while (true) {
                        arrayList2 = arrayList7;
                        if (i4 >= size2) {
                            break;
                        }
                        int i5 = size2;
                        Object obj5 = arrayListF6.get(i4);
                        AbstractC13042fc3.h(obj5, "exitingNames[i]");
                        Object obj6 = arrayListG6.get(i4);
                        AbstractC13042fc3.h(obj6, "enteringNames[i]");
                        kj.put((String) obj5, (String) obj6);
                        i4++;
                        arrayList7 = arrayList2;
                        size2 = i5;
                    }
                    if (FragmentManager.Q0(2)) {
                        Log.v("FragmentManager", ">>> entering view names <<<");
                        Iterator it3 = arrayListG6.iterator();
                        while (true) {
                            arrayList = arrayList6;
                            if (!it3.hasNext()) {
                                break;
                            }
                            Iterator it4 = it3;
                            Log.v("FragmentManager", "Name: " + ((String) it3.next()));
                            objB = objB;
                            arrayList6 = arrayList;
                            it3 = it4;
                        }
                        obj2 = objB;
                        Log.v("FragmentManager", ">>> exiting view names <<<");
                        for (Iterator it5 = arrayListF6.iterator(); it5.hasNext(); it5 = it5) {
                            Log.v("FragmentManager", "Name: " + ((String) it5.next()));
                        }
                    } else {
                        obj2 = objB;
                        arrayList = arrayList6;
                    }
                    View view = dVar.h().B0;
                    AbstractC13042fc3.h(view, "firstOut.fragment.mView");
                    I(kj2, view);
                    kj2.p(arrayListF6);
                    if (abstractC9203Yx6 != null) {
                        if (FragmentManager.Q0(2)) {
                            Log.v("FragmentManager", "Executing exit callback for operation " + dVar);
                        }
                        abstractC9203Yx6.e(arrayListF6, kj2);
                        int size3 = arrayListF6.size() - 1;
                        if (size3 >= 0) {
                            while (true) {
                                int i6 = size3 - 1;
                                Object obj7 = arrayListF6.get(size3);
                                AbstractC13042fc3.h(obj7, "exitingNames[i]");
                                Object obj8 = (String) obj7;
                                View view2 = (View) kj2.get(obj8);
                                if (view2 == null) {
                                    kj.remove(obj8);
                                } else if (!AbstractC13042fc3.d(obj8, AbstractC12990fW7.J(view2))) {
                                    kj.put(AbstractC12990fW7.J(view2), (String) kj.remove(obj8));
                                }
                                if (i6 < 0) {
                                    break;
                                } else {
                                    size3 = i6;
                                }
                            }
                        }
                    } else {
                        kj.p(kj2.keySet());
                    }
                    View view3 = dVar2.h().B0;
                    AbstractC13042fc3.h(view3, "lastIn.fragment.mView");
                    I(kj3, view3);
                    kj3.p(arrayListG6);
                    kj3.p(kj.values());
                    if (abstractC9203Yx62 != null) {
                        if (FragmentManager.Q0(2)) {
                            Log.v("FragmentManager", "Executing enter callback for operation " + dVar2);
                        }
                        abstractC9203Yx62.e(arrayListG6, kj3);
                        int size4 = arrayListG6.size() - 1;
                        if (size4 >= 0) {
                            while (true) {
                                int i7 = size4 - 1;
                                Object obj9 = arrayListG6.get(size4);
                                AbstractC13042fc3.h(obj9, "enteringNames[i]");
                                String str = (String) obj9;
                                View view4 = (View) kj3.get(str);
                                if (view4 == null) {
                                    String strB2 = y.b(kj, str);
                                    if (strB2 != null) {
                                        kj.remove(strB2);
                                    }
                                } else if (!AbstractC13042fc3.d(str, AbstractC12990fW7.J(view4)) && (strB = y.b(kj, str)) != null) {
                                    kj.put(strB, AbstractC12990fW7.J(view4));
                                }
                                if (i7 < 0) {
                                    break;
                                } else {
                                    size4 = i7;
                                }
                            }
                        }
                    } else {
                        y.d(kj, kj3);
                    }
                    Collection collectionKeySet = kj.keySet();
                    AbstractC13042fc3.h(collectionKeySet, "sharedElementNameMapping.keys");
                    J(kj2, collectionKeySet);
                    Collection collectionValues = kj.values();
                    AbstractC13042fc3.h(collectionValues, "sharedElementNameMapping.values");
                    J(kj3, collectionValues);
                    if (kj.isEmpty()) {
                        break;
                    } else {
                        obj = obj2;
                    }
                }
                arrayList5 = arrayList3;
                it2 = it;
                a3 = a2;
                arrayList7 = arrayList2;
                arrayList6 = arrayList;
            }
            Log.i("FragmentManager", "Ignoring shared elements transition " + obj2 + " between " + dVar + " and " + dVar2 + " as there are no matching elements in both the entering and exiting fragment. In order to run a SharedElementTransition, both fragments involved must have the element.");
            arrayList.clear();
            arrayList2.clear();
            arrayList5 = arrayList3;
            it2 = it;
            a3 = a2;
            arrayList7 = arrayList2;
            arrayList6 = arrayList;
        }
        A a4 = a3;
        ArrayList arrayList10 = arrayList6;
        ArrayList arrayList11 = arrayList7;
        ArrayList arrayList12 = arrayList5;
        if (obj == null) {
            if (arrayList12.isEmpty()) {
                return;
            }
            Iterator it6 = arrayList12.iterator();
            while (it6.hasNext()) {
                if (((h) it6.next()).f() == null) {
                }
            }
            return;
        }
        g gVar = new g(arrayList12, dVar, dVar2, a4, obj, arrayList10, arrayList11, kj, arrayListG6, arrayListF6, kj2, kj3, z);
        Iterator it7 = arrayList12.iterator();
        while (it7.hasNext()) {
            ((h) it7.next()).a().b(gVar);
        }
    }

    private final void I(Map map, View view) {
        String strJ = AbstractC12990fW7.J(view);
        if (strJ != null) {
            map.put(strJ, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    AbstractC13042fc3.h(childAt, "child");
                    I(map, childAt);
                }
            }
        }
    }

    private final void J(KJ kj, Collection collection) {
        Set setEntrySet = kj.entrySet();
        AbstractC13042fc3.h(setEntrySet, "entries");
        AbstractC13610gX0.P(setEntrySet, new i(collection));
    }

    private final void K(List list) {
        Fragment fragmentH = ((F.d) AbstractC15401jX0.C0(list)).h();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            F.d dVar = (F.d) it.next();
            dVar.h().E0.c = fragmentH.E0.c;
            dVar.h().E0.d = fragmentH.E0.d;
            dVar.h().E0.e = fragmentH.E0.e;
            dVar.h().E0.f = fragmentH.E0.f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00bc  */
    @Override // androidx.fragment.app.F
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(java.util.List r9, boolean r10) throws android.content.res.Resources.NotFoundException {
        /*
            r8 = this;
            java.lang.String r0 = "operations"
            ir.nasim.AbstractC13042fc3.i(r9, r0)
            r0 = r9
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        Lc:
            boolean r1 = r0.hasNext()
            r2 = 0
            java.lang.String r3 = "operation.fragment.mView"
            if (r1 == 0) goto L36
            java.lang.Object r1 = r0.next()
            r4 = r1
            androidx.fragment.app.F$d r4 = (androidx.fragment.app.F.d) r4
            androidx.fragment.app.F$d$b$a r5 = androidx.fragment.app.F.d.b.a
            androidx.fragment.app.Fragment r6 = r4.h()
            android.view.View r6 = r6.B0
            ir.nasim.AbstractC13042fc3.h(r6, r3)
            androidx.fragment.app.F$d$b r5 = r5.a(r6)
            androidx.fragment.app.F$d$b r6 = androidx.fragment.app.F.d.b.VISIBLE
            if (r5 != r6) goto Lc
            androidx.fragment.app.F$d$b r4 = r4.g()
            if (r4 == r6) goto Lc
            goto L37
        L36:
            r1 = r2
        L37:
            androidx.fragment.app.F$d r1 = (androidx.fragment.app.F.d) r1
            int r0 = r9.size()
            java.util.ListIterator r0 = r9.listIterator(r0)
        L41:
            boolean r4 = r0.hasPrevious()
            if (r4 == 0) goto L68
            java.lang.Object r4 = r0.previous()
            r5 = r4
            androidx.fragment.app.F$d r5 = (androidx.fragment.app.F.d) r5
            androidx.fragment.app.F$d$b$a r6 = androidx.fragment.app.F.d.b.a
            androidx.fragment.app.Fragment r7 = r5.h()
            android.view.View r7 = r7.B0
            ir.nasim.AbstractC13042fc3.h(r7, r3)
            androidx.fragment.app.F$d$b r6 = r6.a(r7)
            androidx.fragment.app.F$d$b r7 = androidx.fragment.app.F.d.b.VISIBLE
            if (r6 == r7) goto L41
            androidx.fragment.app.F$d$b r5 = r5.g()
            if (r5 != r7) goto L41
            r2 = r4
        L68:
            androidx.fragment.app.F$d r2 = (androidx.fragment.app.F.d) r2
            r0 = 2
            boolean r0 = androidx.fragment.app.FragmentManager.Q0(r0)
            if (r0 == 0) goto L8f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Executing operations from "
            r0.append(r3)
            r0.append(r1)
            java.lang.String r3 = " to "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "FragmentManager"
            android.util.Log.v(r3, r0)
        L8f:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r8.K(r9)
            java.util.Iterator r9 = r9.iterator()
        La0:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto Ld0
            java.lang.Object r4 = r9.next()
            androidx.fragment.app.F$d r4 = (androidx.fragment.app.F.d) r4
            androidx.fragment.app.c$b r5 = new androidx.fragment.app.c$b
            r5.<init>(r4, r10)
            r0.add(r5)
            androidx.fragment.app.c$h r5 = new androidx.fragment.app.c$h
            r6 = 0
            r7 = 1
            if (r10 == 0) goto Lbe
            if (r4 != r1) goto Lc1
        Lbc:
            r6 = r7
            goto Lc1
        Lbe:
            if (r4 != r2) goto Lc1
            goto Lbc
        Lc1:
            r5.<init>(r4, r10, r6)
            r3.add(r5)
            ir.nasim.ZE1 r5 = new ir.nasim.ZE1
            r5.<init>()
            r4.a(r5)
            goto La0
        Ld0:
            r8.H(r3, r10, r1, r2)
            r8.F(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C1959c.d(java.util.List, boolean):void");
    }
}
