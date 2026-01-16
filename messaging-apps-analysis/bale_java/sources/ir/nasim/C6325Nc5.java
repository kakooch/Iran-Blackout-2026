package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import ir.nasim.InterfaceC17445my6;

/* renamed from: ir.nasim.Nc5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C6325Nc5 extends AbstractC15672jy6 {
    private final UA2 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6325Nc5(InterfaceC10258bL6 interfaceC10258bL6, UA2 ua2, InterfaceC20315ro1 interfaceC20315ro1, UA2 ua22, UA2 ua23) {
        super(interfaceC20315ro1, ua22, ua23, interfaceC10258bL6);
        AbstractC13042fc3.i(interfaceC10258bL6, "isSelectedMode");
        AbstractC13042fc3.i(ua2, "openMediaCallback");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(ua22, "changeSelectedMode");
        AbstractC13042fc3.i(ua23, "onItemSelectChange");
        this.l = ua2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X(C6325Nc5 c6325Nc5, int i, boolean z) {
        AbstractC13042fc3.i(c6325Nc5, "this$0");
        c6325Nc5.O().invoke(Boolean.valueOf(z));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC17445my6.d Y(C6325Nc5 c6325Nc5, int i) {
        AbstractC13042fc3.i(c6325Nc5, "this$0");
        InterfaceC17445my6.d dVar = (InterfaceC17445my6.d) c6325Nc5.D(i);
        if (((Boolean) c6325Nc5.R().getValue()).booleanValue()) {
            if (dVar != null) {
                dVar.c(!dVar.a());
            }
            if (dVar != null) {
                c6325Nc5.P().invoke(dVar);
            }
        }
        return dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(Q95 q95, int i) {
        AbstractC13042fc3.i(q95, "holder");
        q95.L0((InterfaceC17445my6) D(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public Q95 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C22881vy6 c22881vy6C = C22881vy6.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c22881vy6C, "inflate(...)");
        return new Q95(c22881vy6C, R(), new InterfaceC14603iB2() { // from class: ir.nasim.Lc5
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C6325Nc5.X(this.a, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        }, this.l, Q(), new UA2() { // from class: ir.nasim.Mc5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C6325Nc5.Y(this.a, ((Integer) obj).intValue());
            }
        });
    }
}
