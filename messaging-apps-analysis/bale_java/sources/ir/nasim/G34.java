package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import ir.nasim.C10087b34;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public final class G34 extends OT4 {
    private final InterfaceC14603iB2 h;
    private final InterfaceC20315ro1 i;
    private final C10087b34 j;
    private final Map k;

    public static final class a extends i.f {
        a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(Q14 q14, Q14 q142) {
            AbstractC13042fc3.i(q14, "oldItem");
            AbstractC13042fc3.i(q142, "newItem");
            return q14.j() == q142.j() && q14.l() == q142.l() && q14.f() == q142.f() && AbstractC13042fc3.d(q14.g(), q142.g());
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(Q14 q14, Q14 q142) {
            AbstractC13042fc3.i(q14, "oldItem");
            AbstractC13042fc3.i(q142, "newItem");
            return q14.f() == q142.f();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G34(InterfaceC14603iB2 interfaceC14603iB2, C10087b34.a aVar) {
        super(new a(), null, null, 6, null);
        AbstractC13042fc3.i(interfaceC14603iB2, "onUserClick");
        AbstractC13042fc3.i(aVar, "memberStateBinderFactory");
        this.h = interfaceC14603iB2;
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC20906so1.a(C12366eV1.c());
        this.i = interfaceC20315ro1A;
        this.j = aVar.a(interfaceC20315ro1A);
        this.k = new LinkedHashMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C12701f34 c12701f34, int i) {
        AbstractC13042fc3.i(c12701f34, "holder");
        Q14 q14 = (Q14) D(i);
        c12701f34.J0(q14);
        if (q14 != null) {
            C10087b34.b bVar = (C10087b34.b) this.k.get(Integer.valueOf(q14.f()));
            if (bVar != null) {
                this.j.s(bVar);
            }
            if (q14.k()) {
                return;
            }
            C13337g34 c13337g34 = new C13337g34(q14.f(), c12701f34);
            this.j.p(c13337g34);
            this.k.put(Integer.valueOf(q14.f()), c13337g34);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public C12701f34 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        return new C12701f34(new ComposeView(context, null, 0, 6, null), this.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(C12701f34 c12701f34) {
        C10087b34.b bVar;
        AbstractC13042fc3.i(c12701f34, "holder");
        Q14 q14P0 = c12701f34.P0();
        if (q14P0 != null && (bVar = (C10087b34.b) this.k.get(Integer.valueOf(q14P0.f()))) != null) {
            this.j.s(bVar);
        }
        c12701f34.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.j.q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.j.r();
        AbstractC20906so1.d(this.i, null, 1, null);
    }
}
