package androidx.recyclerview.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class f extends RecyclerView.h {
    private final g d;

    public static final class a {
        public static final a c = new a(true, b.NO_STABLE_IDS);
        public final boolean a;
        public final b b;

        /* renamed from: androidx.recyclerview.widget.f$a$a, reason: collision with other inner class name */
        public static final class C0112a {
            private boolean a;
            private b b;

            public C0112a() {
                a aVar = a.c;
                this.a = aVar.a;
                this.b = aVar.b;
            }

            public a a() {
                return new a(this.a, this.b);
            }

            public C0112a b(boolean z) {
                this.a = z;
                return this;
            }
        }

        public enum b {
            NO_STABLE_IDS,
            ISOLATED_STABLE_IDS,
            SHARED_STABLE_IDS
        }

        a(boolean z, b bVar) {
            this.a = z;
            this.b = bVar;
        }
    }

    public f(RecyclerView.h... hVarArr) {
        this(a.c, hVarArr);
    }

    public boolean A(RecyclerView.h hVar) {
        return this.d.h(hVar);
    }

    public List B() {
        return Collections.unmodifiableList(this.d.n());
    }

    void C(RecyclerView.h.a aVar) {
        super.setStateRestorationPolicy(aVar);
    }

    public boolean D(RecyclerView.h hVar) {
        return this.d.F(hVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int findRelativeAdapterPositionIn(RecyclerView.h hVar, RecyclerView.C c, int i) {
        return this.d.q(hVar, c, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.r();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i) {
        return this.d.o(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        return this.d.p(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.d.w(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c, int i) {
        this.d.x(c, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.d.y(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.d.z(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public boolean onFailedToRecycleView(RecyclerView.C c) {
        return this.d.A(c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewAttachedToWindow(RecyclerView.C c) {
        this.d.B(c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewDetachedFromWindow(RecyclerView.C c) {
        this.d.C(c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewRecycled(RecyclerView.C c) {
        this.d.D(c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void setStateRestorationPolicy(RecyclerView.h.a aVar) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }

    public boolean z(int i, RecyclerView.h hVar) {
        return this.d.g(i, hVar);
    }

    public f(a aVar, RecyclerView.h... hVarArr) {
        this(aVar, Arrays.asList(hVarArr));
    }

    public f(List list) {
        this(a.c, list);
    }

    public f(a aVar, List list) {
        this.d = new g(this, aVar);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            A((RecyclerView.h) it.next());
        }
        super.setHasStableIds(this.d.t());
    }
}
