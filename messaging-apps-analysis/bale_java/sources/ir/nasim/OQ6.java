package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.C9475a16;

/* loaded from: classes7.dex */
public final class OQ6 extends androidx.recyclerview.widget.q {
    private final InterfaceC12270eK4 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OQ6(InterfaceC12270eK4 interfaceC12270eK4) {
        super(new C15935kQ6());
        AbstractC13042fc3.i(interfaceC12270eK4, "listener");
        this.f = interfaceC12270eK4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(NQ6 nq6, int i) {
        Object objB;
        AbstractC13042fc3.i(nq6, "holder");
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b((C12335eR6) A(i));
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        C12335eR6 c12335eR6 = null;
        if (C9475a16.g(objB)) {
            objB = null;
        }
        C12335eR6 c12335eR62 = (C12335eR6) objB;
        if (c12335eR62 != null) {
            nq6.a.setTag(new C5459Jk7(c12335eR62.a().p(), c12335eR62.a().l()));
            c12335eR6 = c12335eR62;
        }
        nq6.O0(c12335eR6, this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public NQ6 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(RC5.view_holder_story, viewGroup, false);
        AbstractC13042fc3.h(viewInflate, "inflate(...)");
        return new NQ6(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(NQ6 nq6) {
        AbstractC13042fc3.i(nq6, "holder");
        super.onViewRecycled(nq6);
        nq6.a();
    }
}
