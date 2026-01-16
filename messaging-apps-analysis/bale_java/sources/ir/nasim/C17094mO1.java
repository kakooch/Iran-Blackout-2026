package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.mO1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17094mO1 extends RecyclerView.h {
    private final InterfaceC10258bL6 d;
    private final InterfaceC10258bL6 e;
    private final UA2 f;

    /* renamed from: ir.nasim.mO1$a */
    public static final class a extends RecyclerView.C {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ComposeView composeView) {
            super(composeView);
            AbstractC13042fc3.i(composeView, "topSpotItemView");
        }
    }

    /* renamed from: ir.nasim.mO1$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.mO1$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C17094mO1 a;

            a(C17094mO1 c17094mO1) {
                this.a = c17094mO1;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    EO1.i(this.a.d, this.a.e, this.a.f, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(550418626, true, new a(C17094mO1.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public C17094mO1(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC10258bL6, "activeTabStateFlow");
        AbstractC13042fc3.i(interfaceC10258bL62, "uiStateStateFlow");
        AbstractC13042fc3.i(ua2, "handleDialogListTopSpotAction");
        this.d = interfaceC10258bL6;
        this.e = interfaceC10258bL62;
        this.f = ua2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        AbstractC13042fc3.i(aVar, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-1866908771, true, new b()));
        return new a(composeView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return 1;
    }
}
