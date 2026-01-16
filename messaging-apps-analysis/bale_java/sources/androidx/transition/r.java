package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.KJ;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class r {
    private static Transition a = new AutoTransition();
    private static ThreadLocal b = new ThreadLocal();
    static ArrayList c = new ArrayList();

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        Transition a;
        ViewGroup b;

        /* renamed from: androidx.transition.r$a$a, reason: collision with other inner class name */
        class C0132a extends q {
            final /* synthetic */ KJ a;

            C0132a(KJ kj) {
                this.a = kj;
            }

            @Override // androidx.transition.Transition.f
            public void d(Transition transition) {
                ((ArrayList) this.a.get(a.this.b)).remove(transition);
                transition.W(this);
            }
        }

        a(Transition transition, ViewGroup viewGroup) {
            this.a = transition;
            this.b = viewGroup;
        }

        private void a() {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!r.c.remove(this.b)) {
                return true;
            }
            KJ kjB = r.b();
            ArrayList arrayList = (ArrayList) kjB.get(this.b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                kjB.put(this.b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.a);
            this.a.b(new C0132a(kjB));
            this.a.n(this.b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).Y(this.b);
                }
            }
            this.a.V(this.b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            r.c.remove(this.b);
            ArrayList arrayList = (ArrayList) r.b().get(this.b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).Y(this.b);
                }
            }
            this.a.o(true);
        }
    }

    public static void a(ViewGroup viewGroup, Transition transition) {
        if (c.contains(viewGroup) || !AbstractC12990fW7.T(viewGroup)) {
            return;
        }
        c.add(viewGroup);
        if (transition == null) {
            transition = a;
        }
        Transition transitionClone = transition.clone();
        d(viewGroup, transitionClone);
        o.b(viewGroup, null);
        c(viewGroup, transitionClone);
    }

    static KJ b() {
        KJ kj;
        WeakReference weakReference = (WeakReference) b.get();
        if (weakReference != null && (kj = (KJ) weakReference.get()) != null) {
            return kj;
        }
        KJ kj2 = new KJ();
        b.set(new WeakReference(kj2));
        return kj2;
    }

    private static void c(ViewGroup viewGroup, Transition transition) {
        if (transition == null || viewGroup == null) {
            return;
        }
        a aVar = new a(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).U(viewGroup);
            }
        }
        if (transition != null) {
            transition.n(viewGroup, true);
        }
        o.a(viewGroup);
    }
}
