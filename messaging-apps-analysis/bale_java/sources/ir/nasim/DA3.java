package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.i;

/* loaded from: classes7.dex */
public final class DA3 extends OT4 {
    private final C11458d25 h;
    private final InterfaceC10258bL6 i;
    private final InterfaceC10258bL6 j;
    private final UA2 k;
    private final UA2 l;

    public static final class a extends i.f {
        a() {
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(C9562aA3 c9562aA3, C9562aA3 c9562aA32) {
            AbstractC13042fc3.i(c9562aA3, "oldItem");
            AbstractC13042fc3.i(c9562aA32, "newItem");
            C23345wl7 c23345wl7L = c9562aA3.e().F().l();
            String strV = c23345wl7L != null ? c23345wl7L.v() : null;
            if (strV == null) {
                strV = "";
            }
            C23345wl7 c23345wl7L2 = c9562aA32.e().F().l();
            return AbstractC13042fc3.d(strV, c23345wl7L2 != null ? c23345wl7L2.v() : null);
        }

        @Override // androidx.recyclerview.widget.i.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean b(C9562aA3 c9562aA3, C9562aA3 c9562aA32) {
            AbstractC13042fc3.i(c9562aA3, "oldItem");
            AbstractC13042fc3.i(c9562aA32, "newItem");
            return c9562aA3.f() == c9562aA32.f() && c9562aA3.c() == c9562aA32.c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DA3(C11458d25 c11458d25, InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, UA2 ua2, UA2 ua22) {
        super(new a(), null, null, 6, null);
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(interfaceC10258bL6, "selected");
        AbstractC13042fc3.i(interfaceC10258bL62, "isSelectedMode");
        AbstractC13042fc3.i(ua2, "changeSelectedMode");
        AbstractC13042fc3.i(ua22, "onItemSelectChange");
        this.h = c11458d25;
        this.i = interfaceC10258bL6;
        this.j = interfaceC10258bL62;
        this.k = ua2;
        this.l = ua22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 S(DA3 da3, int i, boolean z) {
        AbstractC13042fc3.i(da3, "this$0");
        da3.k.invoke(Boolean.valueOf(z));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 T(DA3 da3, int i) {
        AbstractC13042fc3.i(da3, "this$0");
        C9562aA3 c9562aA3 = (C9562aA3) da3.D(i);
        if (c9562aA3 != null) {
            da3.l.invoke(c9562aA3);
        }
        return C19938rB7.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C13415gB3 c13415gB3, int i) {
        AbstractC13042fc3.i(c13415gB3, "holder");
        c13415gB3.O0((C9562aA3) D(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public C13415gB3 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        return new C13415gB3(new ComposeView(context, null, 0, 6, null), this.i, this.j, new InterfaceC14603iB2() { // from class: ir.nasim.BA3
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return DA3.S(this.a, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.CA3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return DA3.T(this.a, ((Integer) obj).intValue());
            }
        }, this.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(C13415gB3 c13415gB3) {
        AbstractC13042fc3.i(c13415gB3, "holder");
        c13415gB3.a();
    }
}
