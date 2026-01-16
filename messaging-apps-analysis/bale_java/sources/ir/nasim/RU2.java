package ir.nasim;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class RU2 extends RecyclerView.h {
    public static final a j = new a(null);
    public static final int k = 8;
    private RecyclerView.h d;
    private final List e;
    private final List f;
    private final Map g;
    private boolean h;
    private final RecyclerView.j i;

    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View b(View view) {
            if (view.getParent() != null) {
                ViewParent parent = view.getParent();
                AbstractC13042fc3.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(view);
            }
            FrameLayout frameLayout = new FrameLayout(view.getContext());
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            frameLayout.addView(view);
            return frameLayout;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private static final class b extends AbstractC9995au {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(RU2.j.b(view));
            AbstractC13042fc3.i(view, "itemView");
        }
    }

    public static final class c extends RecyclerView.j {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void a() {
            super.a();
            try {
                RU2.this.notifyDataSetChanged();
            } catch (IllegalStateException e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void c(int i, int i2, Object obj) {
            super.c(i, i2, obj);
            RU2 ru2 = RU2.this;
            ru2.notifyItemRangeChanged(i + ru2.F(), i2, obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void d(int i, int i2) {
            super.d(i, i2);
            RU2 ru2 = RU2.this;
            ru2.notifyItemRangeInserted(i + ru2.F(), i2);
            RU2.this.C();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void e(int i, int i2, int i3) {
            super.e(i, i2, i3);
            int iF = RU2.this.F();
            for (int i4 = 0; i4 < i3; i4++) {
                RU2.this.notifyItemMoved(i + iF + i4, i2 + iF + i4);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void f(int i, int i2) {
            super.f(i, i2);
            RU2 ru2 = RU2.this;
            ru2.notifyItemRangeRemoved(i + ru2.F(), i2);
            RU2.this.C();
        }
    }

    public RU2(RecyclerView.h hVar) {
        AbstractC13042fc3.i(hVar, "adapter");
        this.i = new c();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new HashMap();
        J(hVar);
        setHasStableIds(hVar.hasStableIds());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        if (this.h) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setVisibility(0);
            }
            return;
        }
        RecyclerView.h hVar = this.d;
        if (hVar != null) {
            int itemCount = hVar.getItemCount();
            Iterator it2 = this.e.iterator();
            while (it2.hasNext()) {
                ((View) it2.next()).setVisibility(itemCount < 1 ? 8 : 0);
            }
        }
    }

    private final int D() {
        Map map = this.g;
        RecyclerView.h hVar = this.d;
        AbstractC13042fc3.f(hVar);
        Object obj = map.get(hVar.getClass());
        AbstractC13042fc3.f(obj);
        return ((Number) obj).intValue();
    }

    private final void H(Class cls) {
        this.g.put(cls, Integer.valueOf((r0.size() * 100) - 2147483628));
    }

    private final void J(RecyclerView.h hVar) {
        RecyclerView.h hVar2 = this.d;
        if (hVar2 != null) {
            AbstractC13042fc3.f(hVar2);
            hVar2.unregisterAdapterDataObserver(this.i);
        }
        Class<?> cls = hVar.getClass();
        if (!this.g.containsKey(cls)) {
            H(cls);
        }
        hVar.registerAdapterDataObserver(this.i);
        this.d = hVar;
    }

    public final void A(View view) {
        AbstractC13042fc3.i(view, "view");
        if (this.f.contains(view)) {
            return;
        }
        this.f.add(view);
        notifyDataSetChanged();
    }

    public final void B(View view) {
        AbstractC13042fc3.i(view, "view");
        this.e.add(view);
        notifyDataSetChanged();
    }

    public final int E() {
        return this.f.size();
    }

    public final int F() {
        return this.e.size();
    }

    public final int G() {
        RecyclerView.h hVar = this.d;
        if (hVar != null) {
            return hVar.getItemCount();
        }
        return 0;
    }

    public final void I(boolean z) {
        this.h = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return F() + E() + G();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i) {
        int iF = F();
        if (i < iF) {
            return i - Long.MIN_VALUE;
        }
        RecyclerView.h hVar = this.d;
        if (hVar == null) {
            return -1L;
        }
        return i < iF + hVar.getItemCount() ? hVar.getItemId(i - iF) : Long.MAX_VALUE - ((i - iF) - r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        int iF = F();
        if (i < iF) {
            return i + RecyclerView.UNDEFINED_DURATION;
        }
        RecyclerView.h hVar = this.d;
        if (hVar == null) {
            return -1;
        }
        int itemCount = hVar.getItemCount();
        if (i >= iF + itemCount) {
            return ((i - 2147483638) - iF) - itemCount;
        }
        return hVar.getItemViewType(i - iF) + D();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c2, int i) {
        AbstractC13042fc3.i(c2, "viewHolder");
        int iF = F();
        RecyclerView.h hVar = this.d;
        if (hVar == null) {
            return;
        }
        if (i >= iF && i < hVar.getItemCount() + iF) {
            hVar.onBindViewHolder(c2, i - iF);
        }
        C();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "viewGroup");
        if (i < F() + RecyclerView.UNDEFINED_DURATION) {
            return new b((View) this.e.get(i - RecyclerView.UNDEFINED_DURATION));
        }
        if (i < E() - 2147483638) {
            return new b((View) this.f.get(i - (-2147483638)));
        }
        RecyclerView.h hVar = this.d;
        AbstractC13042fc3.f(hVar);
        RecyclerView.C cOnCreateViewHolder = hVar.onCreateViewHolder(viewGroup, i - D());
        AbstractC13042fc3.f(cOnCreateViewHolder);
        return cOnCreateViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewRecycled(RecyclerView.C c2) {
        AbstractC13042fc3.i(c2, "viewHolder");
        if (!(c2 instanceof b)) {
            RecyclerView.h hVar = this.d;
            if (!(hVar instanceof RecyclerView.h)) {
                hVar = null;
            }
            if (hVar != null) {
                hVar.onViewRecycled(c2);
            }
        }
        C();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c2, int i, List list) {
        AbstractC13042fc3.i(c2, "holder");
        AbstractC13042fc3.i(list, "payloads");
        if (list.isEmpty()) {
            super.onBindViewHolder(c2, i, list);
            return;
        }
        int iF = F();
        RecyclerView.h hVar = this.d;
        if (hVar == null) {
            return;
        }
        if (i >= iF && i < hVar.getItemCount() + iF) {
            hVar.onBindViewHolder(c2, i - iF, list);
        }
        C();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RU2(RecyclerView.h hVar, boolean z) {
        this(hVar);
        AbstractC13042fc3.i(hVar, "adapter");
        this.h = z;
    }
}
