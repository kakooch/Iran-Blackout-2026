package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Tv5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC7941Tv5 {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 c(List list, Object obj) {
        return e(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C4382Ew7 d(List list) {
        return new C4382Ew7(list.get(0), list.get(1));
    }

    public static C6517Nv5 e(final List list) {
        return list.size() == 0 ? C6517Nv5.l0(null) : ((C6517Nv5) ((S17) list.remove(0)).get()).H(new InterfaceC17569nB2() { // from class: ir.nasim.Sv5
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return AbstractC7941Tv5.c(list, obj);
            }
        });
    }

    public static C6517Nv5 f(C6517Nv5 c6517Nv5, C6517Nv5 c6517Nv52) {
        return C16835lw5.L(c6517Nv5, c6517Nv52).M().h0(new InterfaceC17569nB2() { // from class: ir.nasim.Rv5
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return AbstractC7941Tv5.d((List) obj);
            }
        });
    }
}
