package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;

/* renamed from: ir.nasim.nJ5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C17644nJ5 extends androidx.recyclerview.widget.q {
    private final InterfaceC14603iB2 f;

    /* renamed from: ir.nasim.nJ5$a */
    private static final class a extends i.f {
        public static final a a = new a();

        private a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(C19938rB7 c19938rB7, C19938rB7 c19938rB72) {
            AbstractC13042fc3.i(c19938rB7, "oldItem");
            AbstractC13042fc3.i(c19938rB72, "newItem");
            return true;
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(C19938rB7 c19938rB7, C19938rB7 c19938rB72) {
            AbstractC13042fc3.i(c19938rB7, "oldItem");
            AbstractC13042fc3.i(c19938rB72, "newItem");
            return true;
        }
    }

    /* renamed from: ir.nasim.nJ5$b */
    public static final class b extends RecyclerView.C {
        public static final int v = ComposeView.k;
        private final ComposeView u;

        /* renamed from: ir.nasim.nJ5$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC14603iB2 a;

            a(InterfaceC14603iB2 interfaceC14603iB2) {
                this.a = interfaceC14603iB2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    this.a.invoke(interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ComposeView composeView) {
            super(composeView);
            AbstractC13042fc3.i(composeView, "composeView");
            this.u = composeView;
        }

        public final void C0(InterfaceC14603iB2 interfaceC14603iB2) {
            AbstractC13042fc3.i(interfaceC14603iB2, "content");
            this.u.setContent(AbstractC19242q11.c(-574139315, true, new a(interfaceC14603iB2)));
        }

        public final void a() {
            this.u.h();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17644nJ5(InterfaceC14603iB2 interfaceC14603iB2) {
        super(a.a);
        AbstractC13042fc3.i(interfaceC14603iB2, "content");
        this.f = interfaceC14603iB2;
        C(AbstractC9766aX0.e(C19938rB7.a));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i) {
        AbstractC13042fc3.i(bVar, "holder");
        bVar.C0(this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        return new b(composeView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(b bVar) {
        AbstractC13042fc3.i(bVar, "holder");
        bVar.a();
    }
}
