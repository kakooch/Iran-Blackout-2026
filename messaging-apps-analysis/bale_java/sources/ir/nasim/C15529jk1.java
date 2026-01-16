package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.i;

/* renamed from: ir.nasim.jk1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C15529jk1 extends OT4 {
    private C20644sM5 h;
    private final UA2 i;

    /* renamed from: ir.nasim.jk1$a */
    public static final class a extends i.f {
        a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(InterfaceC14341hl1 interfaceC14341hl1, InterfaceC14341hl1 interfaceC14341hl12) {
            AbstractC13042fc3.i(interfaceC14341hl1, "oldItem");
            AbstractC13042fc3.i(interfaceC14341hl12, "newItem");
            return AbstractC13042fc3.d(interfaceC14341hl1.b(), interfaceC14341hl12.b());
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(InterfaceC14341hl1 interfaceC14341hl1, InterfaceC14341hl1 interfaceC14341hl12) {
            AbstractC13042fc3.i(interfaceC14341hl1, "oldItem");
            AbstractC13042fc3.i(interfaceC14341hl12, "newItem");
            return AbstractC13042fc3.d(interfaceC14341hl1.b(), interfaceC14341hl12.b());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C15529jk1(C20644sM5 c20644sM5, UA2 ua2) {
        super(new a(), null, null, 6, null);
        AbstractC13042fc3.i(c20644sM5, "matcher");
        AbstractC13042fc3.i(ua2, "onClick");
        this.h = c20644sM5;
        this.i = ua2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C23929xl1 c23929xl1, int i) {
        AbstractC13042fc3.i(c23929xl1, "holder");
        c23929xl1.J0((InterfaceC14341hl1) D(i), false, this.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public C23929xl1 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C23929xl1.A.b(viewGroup, this.i, "");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C23929xl1 c23929xl1) {
        AbstractC13042fc3.i(c23929xl1, "holder");
        c23929xl1.P0();
    }
}
