package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.i;

/* renamed from: ir.nasim.uj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22134uj2 extends androidx.recyclerview.widget.q {
    public static final b g = new b(null);
    public static final int h = 8;
    private static final i.f i = new a();
    private final InterfaceC11890dj2 f;

    /* renamed from: ir.nasim.uj2$a */
    public static final class a extends i.f {
        a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(C15759k74 c15759k74, C15759k74 c15759k742) {
            AbstractC13042fc3.i(c15759k74, "oldItem");
            AbstractC13042fc3.i(c15759k742, "newItem");
            return AbstractC13042fc3.d(c15759k74, c15759k742);
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(C15759k74 c15759k74, C15759k74 c15759k742) {
            AbstractC13042fc3.i(c15759k74, "oldItem");
            AbstractC13042fc3.i(c15759k742, "newItem");
            return AbstractC13042fc3.d(c15759k74, c15759k742);
        }
    }

    /* renamed from: ir.nasim.uj2$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22134uj2(InterfaceC11890dj2 interfaceC11890dj2) {
        super(i);
        AbstractC13042fc3.i(interfaceC11890dj2, "feedHolderListener");
        this.f = interfaceC11890dj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C23320wj2 c23320wj2, int i2) {
        AbstractC13042fc3.i(c23320wj2, "holder");
        C15759k74 c15759k74 = (C15759k74) A(i2);
        if (c15759k74 == null) {
            return;
        }
        c23320wj2.D0(c15759k74);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public C23320wj2 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C23320wj2.w.a(viewGroup, this.f);
    }
}
