package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import ir.nasim.InterfaceC17445my6;

/* loaded from: classes7.dex */
public final class FP extends AbstractC15672jy6 {
    private final C11458d25 l;

    public /* synthetic */ FP(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, UA2 ua22, C11458d25 c11458d25, int i, ED1 ed1) {
        this(interfaceC10258bL6, (i & 2) != 0 ? AbstractC20906so1.a(C12366eV1.c()) : interfaceC20315ro1, ua2, ua22, c11458d25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X(FP fp, int i, boolean z) {
        AbstractC13042fc3.i(fp, "this$0");
        fp.O().invoke(Boolean.valueOf(z));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC17445my6 Y(FP fp, int i) {
        AbstractC13042fc3.i(fp, "this$0");
        InterfaceC17445my6.a aVar = (InterfaceC17445my6.a) fp.D(i);
        if (((Boolean) fp.R().getValue()).booleanValue()) {
            if (aVar != null) {
                aVar.c(!aVar.a());
            }
            if (aVar != null) {
                fp.P().invoke(aVar);
            }
        }
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(CP cp, int i) {
        InterfaceC17445my6.a aVar;
        AbstractC13042fc3.i(cp, "holder");
        InterfaceC17445my6 interfaceC17445my6 = (InterfaceC17445my6) D(i);
        long jH = -1;
        if (i > 0 && (aVar = (InterfaceC17445my6.a) D(i - 1)) != null) {
            jH = aVar.h();
        }
        cp.M0(interfaceC17445my6, jH);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public CP onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C16263ky6 c16263ky6C = C16263ky6.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c16263ky6C, "inflate(...)");
        return new CP(c16263ky6C, R(), new InterfaceC14603iB2() { // from class: ir.nasim.DP
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return FP.X(this.a, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.EP
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return FP.Y(this.a, ((Integer) obj).intValue());
            }
        }, Q(), this.l);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FP(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, UA2 ua22, C11458d25 c11458d25) {
        super(interfaceC20315ro1, ua2, ua22, interfaceC10258bL6);
        AbstractC13042fc3.i(interfaceC10258bL6, "isSelectedMode");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(ua2, "changeSelectedMode");
        AbstractC13042fc3.i(ua22, "onItemSelectChange");
        AbstractC13042fc3.i(c11458d25, "peer");
        this.l = c11458d25;
    }
}
