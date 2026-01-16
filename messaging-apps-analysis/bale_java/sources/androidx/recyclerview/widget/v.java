package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.C22317v2;
import ir.nasim.X2;
import ir.nasim.Y2;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class v extends C22317v2 {
    final RecyclerView d;
    private final a e;

    public static class a extends C22317v2 {
        final v d;
        private Map e = new WeakHashMap();

        public a(v vVar) {
            this.d = vVar;
        }

        @Override // ir.nasim.C22317v2
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            C22317v2 c22317v2 = (C22317v2) this.e.get(view);
            return c22317v2 != null ? c22317v2.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // ir.nasim.C22317v2
        public Y2 b(View view) {
            C22317v2 c22317v2 = (C22317v2) this.e.get(view);
            return c22317v2 != null ? c22317v2.b(view) : super.b(view);
        }

        @Override // ir.nasim.C22317v2
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            C22317v2 c22317v2 = (C22317v2) this.e.get(view);
            if (c22317v2 != null) {
                c22317v2.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            if (this.d.o() || this.d.d.getLayoutManager() == null) {
                super.g(view, x2);
                return;
            }
            this.d.d.getLayoutManager().R0(view, x2);
            C22317v2 c22317v2 = (C22317v2) this.e.get(view);
            if (c22317v2 != null) {
                c22317v2.g(view, x2);
            } else {
                super.g(view, x2);
            }
        }

        @Override // ir.nasim.C22317v2
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            C22317v2 c22317v2 = (C22317v2) this.e.get(view);
            if (c22317v2 != null) {
                c22317v2.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // ir.nasim.C22317v2
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            C22317v2 c22317v2 = (C22317v2) this.e.get(viewGroup);
            return c22317v2 != null ? c22317v2.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // ir.nasim.C22317v2
        public boolean j(View view, int i, Bundle bundle) {
            if (this.d.o() || this.d.d.getLayoutManager() == null) {
                return super.j(view, i, bundle);
            }
            C22317v2 c22317v2 = (C22317v2) this.e.get(view);
            if (c22317v2 != null) {
                if (c22317v2.j(view, i, bundle)) {
                    return true;
                }
            } else if (super.j(view, i, bundle)) {
                return true;
            }
            return this.d.d.getLayoutManager().l1(view, i, bundle);
        }

        @Override // ir.nasim.C22317v2
        public void l(View view, int i) {
            C22317v2 c22317v2 = (C22317v2) this.e.get(view);
            if (c22317v2 != null) {
                c22317v2.l(view, i);
            } else {
                super.l(view, i);
            }
        }

        @Override // ir.nasim.C22317v2
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            C22317v2 c22317v2 = (C22317v2) this.e.get(view);
            if (c22317v2 != null) {
                c22317v2.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        C22317v2 n(View view) {
            return (C22317v2) this.e.remove(view);
        }

        void o(View view) {
            C22317v2 c22317v2L = AbstractC12990fW7.l(view);
            if (c22317v2L == null || c22317v2L == this) {
                return;
            }
            this.e.put(view, c22317v2L);
        }
    }

    public v(RecyclerView recyclerView) {
        this.d = recyclerView;
        C22317v2 c22317v2N = n();
        if (c22317v2N == null || !(c22317v2N instanceof a)) {
            this.e = new a(this);
        } else {
            this.e = (a) c22317v2N;
        }
    }

    @Override // ir.nasim.C22317v2
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().N0(accessibilityEvent);
        }
    }

    @Override // ir.nasim.C22317v2
    public void g(View view, X2 x2) {
        super.g(view, x2);
        if (o() || this.d.getLayoutManager() == null) {
            return;
        }
        this.d.getLayoutManager().Q0(x2);
    }

    @Override // ir.nasim.C22317v2
    public boolean j(View view, int i, Bundle bundle) {
        if (super.j(view, i, bundle)) {
            return true;
        }
        if (o() || this.d.getLayoutManager() == null) {
            return false;
        }
        return this.d.getLayoutManager().j1(i, bundle);
    }

    public C22317v2 n() {
        return this.e;
    }

    boolean o() {
        return this.d.hasPendingAdapterUpdates();
    }
}
