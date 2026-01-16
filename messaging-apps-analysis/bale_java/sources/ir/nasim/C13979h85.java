package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.i;

/* renamed from: ir.nasim.h85, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13979h85 extends OT4 {
    private final UA2 h;

    /* renamed from: ir.nasim.h85$a */
    public static final class a extends i.f {
        a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(InterfaceC7331Rg3 interfaceC7331Rg3, InterfaceC7331Rg3 interfaceC7331Rg32) {
            AbstractC13042fc3.i(interfaceC7331Rg3, "oldItem");
            AbstractC13042fc3.i(interfaceC7331Rg32, "newItem");
            return interfaceC7331Rg3.h() == interfaceC7331Rg32.h() && interfaceC7331Rg3.i() == interfaceC7331Rg32.i() && interfaceC7331Rg3.a() == interfaceC7331Rg32.a();
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(InterfaceC7331Rg3 interfaceC7331Rg3, InterfaceC7331Rg3 interfaceC7331Rg32) {
            AbstractC13042fc3.i(interfaceC7331Rg3, "oldItem");
            AbstractC13042fc3.i(interfaceC7331Rg32, "newItem");
            return interfaceC7331Rg3.h() == interfaceC7331Rg32.h() && interfaceC7331Rg3.i() == interfaceC7331Rg32.i() && interfaceC7331Rg3.a() == interfaceC7331Rg32.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13979h85(UA2 ua2) {
        super(new a(), null, null, 6, null);
        AbstractC13042fc3.i(ua2, "onClick");
        this.h = ua2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C16361l85 c16361l85, int i) {
        AbstractC13042fc3.i(c16361l85, "holder");
        c16361l85.L0((InterfaceC7331Rg3) D(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public C16361l85 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C16361l85.z.a(viewGroup, this.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C16361l85 c16361l85) {
        AbstractC13042fc3.i(c16361l85, "holder");
        c16361l85.S0();
    }
}
