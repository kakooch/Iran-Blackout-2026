package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import ir.nasim.InterfaceC17445my6;

/* renamed from: ir.nasim.h18, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13912h18 extends AbstractC15672jy6 {
    private final C11458d25 l;

    public /* synthetic */ C13912h18(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, UA2 ua22, C11458d25 c11458d25, int i, ED1 ed1) {
        this(interfaceC10258bL6, (i & 2) != 0 ? AbstractC20906so1.a(C12366eV1.c()) : interfaceC20315ro1, ua2, ua22, c11458d25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X(C13912h18 c13912h18, int i, boolean z) {
        AbstractC13042fc3.i(c13912h18, "this$0");
        c13912h18.O().invoke(Boolean.valueOf(z));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC17445my6.f Y(C13912h18 c13912h18, int i) {
        AbstractC13042fc3.i(c13912h18, "this$0");
        InterfaceC17445my6.f fVar = (InterfaceC17445my6.f) c13912h18.D(i);
        if (((Boolean) c13912h18.R().getValue()).booleanValue()) {
            if (fVar != null) {
                fVar.c(!fVar.a());
            }
            if (fVar != null) {
                c13912h18.P().invoke(fVar);
            }
        }
        return fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C12094e18 c12094e18, int i) {
        InterfaceC17445my6.f fVar;
        AbstractC13042fc3.i(c12094e18, "holder");
        InterfaceC17445my6.f fVar2 = (InterfaceC17445my6.f) D(i);
        long jH = -1;
        if (i > 0 && (fVar = (InterfaceC17445my6.f) D(i - 1)) != null) {
            jH = fVar.h();
        }
        c12094e18.q1(fVar2, jH);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public C12094e18 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C10049az6 c10049az6C = C10049az6.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c10049az6C, "inflate(...)");
        return new C12094e18(c10049az6C, R(), new InterfaceC14603iB2() { // from class: ir.nasim.f18
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C13912h18.X(this.a, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue());
            }
        }, new UA2() { // from class: ir.nasim.g18
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C13912h18.Y(this.a, ((Integer) obj).intValue());
            }
        }, Q(), this.l);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13912h18(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC20315ro1 interfaceC20315ro1, UA2 ua2, UA2 ua22, C11458d25 c11458d25) {
        super(interfaceC20315ro1, ua2, ua22, interfaceC10258bL6);
        AbstractC13042fc3.i(interfaceC10258bL6, "isSelectedMode");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(ua2, "changeSelectedMode");
        AbstractC13042fc3.i(ua22, "onItemSelectChange");
        AbstractC13042fc3.i(c11458d25, "peer");
        this.l = c11458d25;
    }
}
