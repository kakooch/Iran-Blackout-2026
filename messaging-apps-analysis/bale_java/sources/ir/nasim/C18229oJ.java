package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.AbstractC1988b;
import java.util.List;

/* renamed from: ir.nasim.oJ, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18229oJ extends RecyclerView.h {
    private final InterfaceC10258bL6 d;
    private final SA2 e;

    /* renamed from: ir.nasim.oJ$a */
    public static final class a extends RecyclerView.C {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ComposeView composeView) {
            super(composeView);
            AbstractC13042fc3.i(composeView, "archiveItemView");
        }
    }

    /* renamed from: ir.nasim.oJ$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.oJ$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C18229oJ a;

            a(C18229oJ c18229oJ) {
                this.a = c18229oJ;
            }

            private static final List b(InterfaceC9664aL6 interfaceC9664aL6) {
                return (List) interfaceC9664aL6.getValue();
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC1988b.b(b(AbstractC5976Lq2.c(this.a.d, null, null, null, interfaceC22053ub1, 0, 7)), this.a.e, null, interfaceC22053ub1, 0, 4);
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
                M10.f(false, AbstractC19242q11.e(-2117271739, true, new a(C18229oJ.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public C18229oJ(InterfaceC10258bL6 interfaceC10258bL6, SA2 sa2) {
        AbstractC13042fc3.i(interfaceC10258bL6, "archivedDialogNamesStateFlow");
        AbstractC13042fc3.i(sa2, "onArchiveClick");
        this.d = interfaceC10258bL6;
        this.e = sa2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        AbstractC13042fc3.i(aVar, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        composeView.setContent(AbstractC19242q11.c(-1164718752, true, new b()));
        return new a(composeView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return 1;
    }
}
