package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.jy6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC15672jy6 extends OT4 {
    private final InterfaceC20315ro1 h;
    private final UA2 i;
    private final UA2 j;
    private final InterfaceC10258bL6 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC15672jy6(InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, UA2 ua22, InterfaceC10258bL6 interfaceC10258bL6) {
        super(new C19809qy6(), null, null, 6, null);
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(ua2, "changeSelectedMode");
        AbstractC13042fc3.i(ua22, "onItemSelectChange");
        AbstractC13042fc3.i(interfaceC10258bL6, "isSelectedMode");
        this.h = interfaceC20315ro1;
        this.i = ua2;
        this.j = ua22;
        this.k = interfaceC10258bL6;
    }

    public final UA2 O() {
        return this.i;
    }

    public final UA2 P() {
        return this.j;
    }

    public final InterfaceC20315ro1 Q() {
        return this.h;
    }

    public final InterfaceC10258bL6 R() {
        return this.k;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(AbstractC5350Iy6 abstractC5350Iy6) {
        AbstractC13042fc3.i(abstractC5350Iy6, "holder");
        abstractC5350Iy6.f1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        AbstractC20906so1.d(this.h, null, 1, null);
    }
}
