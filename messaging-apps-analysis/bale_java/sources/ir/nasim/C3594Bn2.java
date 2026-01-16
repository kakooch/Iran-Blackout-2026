package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import ir.nasim.InterfaceC17445my6;

/* renamed from: ir.nasim.Bn2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3594Bn2 extends AbstractC15672jy6 {
    private final UA2 l;

    public /* synthetic */ C3594Bn2(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, UA2 ua22, UA2 ua23, int i, ED1 ed1) {
        this(interfaceC10258bL6, (i & 2) != 0 ? AbstractC20906so1.a(C12366eV1.c()) : interfaceC20315ro1, ua2, ua22, ua23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X(C3594Bn2 c3594Bn2, int i, boolean z) {
        AbstractC13042fc3.i(c3594Bn2, "this$0");
        c3594Bn2.O().invoke(Boolean.valueOf(z));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC17445my6.c Y(C3594Bn2 c3594Bn2, int i) {
        AbstractC13042fc3.i(c3594Bn2, "this$0");
        InterfaceC17445my6.c cVar = (InterfaceC17445my6.c) c3594Bn2.D(i);
        if (((Boolean) c3594Bn2.R().getValue()).booleanValue()) {
            if (cVar != null) {
                cVar.c(!cVar.a());
            }
            if (cVar != null) {
                c3594Bn2.P().invoke(cVar);
            }
        }
        return cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C9100Ym2 c9100Ym2, int i) {
        InterfaceC17445my6.c cVar;
        AbstractC13042fc3.i(c9100Ym2, "holder");
        InterfaceC17445my6 interfaceC17445my6 = (InterfaceC17445my6) D(i);
        long jH = -1;
        if (i > 0 && (cVar = (InterfaceC17445my6.c) D(i - 1)) != null) {
            jH = cVar.h();
        }
        c9100Ym2.M0(interfaceC17445my6, jH);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public C9100Ym2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C20418ry6 c20418ry6C = C20418ry6.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c20418ry6C, "inflate(...)");
        return new C9100Ym2(c20418ry6C, R(), new InterfaceC14603iB2() { // from class: ir.nasim.zn2
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C3594Bn2.X(this.a, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        }, this.l, new UA2() { // from class: ir.nasim.An2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C3594Bn2.Y(this.a, ((Integer) obj).intValue());
            }
        }, Q());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3594Bn2(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, UA2 ua22, UA2 ua23) {
        super(interfaceC20315ro1, ua2, ua22, interfaceC10258bL6);
        AbstractC13042fc3.i(interfaceC10258bL6, "isSelectedMode");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(ua2, "changeSelectedMode");
        AbstractC13042fc3.i(ua22, "onItemSelectChange");
        AbstractC13042fc3.i(ua23, "openFile");
        this.l = ua23;
    }
}
