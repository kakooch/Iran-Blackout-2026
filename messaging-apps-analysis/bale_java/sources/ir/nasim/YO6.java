package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes7.dex */
public final class YO6 extends androidx.recyclerview.widget.q {
    public static final a g = new a(null);
    public static final int h = 8;
    private final InterfaceC12270eK4 f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YO6(InterfaceC12270eK4 interfaceC12270eK4) {
        super(new C15935kQ6());
        AbstractC13042fc3.i(interfaceC12270eK4, "listener");
        this.f = interfaceC12270eK4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(PQ6 pq6, int i) {
        AbstractC13042fc3.i(pq6, "holder");
        C12335eR6 c12335eR6 = (C12335eR6) z().get(i);
        pq6.a.setTag(new C5459Jk7(c12335eR6.a().p(), c12335eR6.a().l()));
        AbstractC13042fc3.f(c12335eR6);
        pq6.D0(c12335eR6, this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public ZQ6 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        if (i == 1) {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(RC5.view_holder_story, viewGroup, false);
            AbstractC13042fc3.h(viewInflate, "inflate(...)");
            return new ZQ6(viewInflate);
        }
        if (i != 2) {
            View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(RC5.view_holder_story, viewGroup, false);
            AbstractC13042fc3.h(viewInflate2, "inflate(...)");
            return new ZQ6(viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(RC5.view_holder_story, viewGroup, false);
        AbstractC13042fc3.h(viewInflate3, "inflate(...)");
        return new C5205Ii5(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(PQ6 pq6) {
        AbstractC13042fc3.i(pq6, "holder");
        super.onViewRecycled(pq6);
        if (pq6 instanceof ZQ6) {
            ((ZQ6) pq6).a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        return ((C12335eR6) z().get(i)).b().e() ? 2 : 1;
    }
}
