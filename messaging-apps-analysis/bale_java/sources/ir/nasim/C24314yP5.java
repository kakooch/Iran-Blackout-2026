package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeer;
import java.util.List;

/* renamed from: ir.nasim.yP5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24314yP5 {
    private final AbstractC13778go1 a;
    private final FP5 b;

    public C24314yP5(AbstractC13778go1 abstractC13778go1, FP5 fp5) {
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(fp5, "reportRepository");
        this.a = abstractC13778go1;
        this.b = fp5;
    }

    public final InterfaceC4557Fq2 a(ExPeer exPeer, String str, OP5 op5, List list) {
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(str, "description");
        AbstractC13042fc3.i(op5, "reportType");
        AbstractC13042fc3.i(list, "messageIds");
        return AbstractC6459Nq2.V(this.b.c(exPeer, str, op5, list), this.a);
    }
}
