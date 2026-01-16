package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.ke1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C16060ke1 extends AbstractC15458jd0 {
    private final Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C16060ke1(Object obj, int i, List list) {
        super(list, i);
        AbstractC13042fc3.i(obj, "id");
        AbstractC13042fc3.i(list, "tasks");
        this.c = obj;
    }

    @Override // ir.nasim.AbstractC15458jd0
    public C13060fe1 c(TK6 tk6) {
        AbstractC13042fc3.i(tk6, "state");
        C13060fe1 c13060fe1C = tk6.c(this.c);
        AbstractC13042fc3.h(c13060fe1C, "state.constraints(id)");
        return c13060fe1C;
    }
}
