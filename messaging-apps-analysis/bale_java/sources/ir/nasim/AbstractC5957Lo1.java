package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.Lo1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5957Lo1 {
    public static final AbstractC13778go1 a(D26 d26) {
        Map mapL = d26.l();
        Object objB = mapL.get("QueryDispatcher");
        if (objB == null) {
            objB = AbstractC14260hd2.b(d26.p());
            mapL.put("QueryDispatcher", objB);
        }
        AbstractC13042fc3.g(objB, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (AbstractC13778go1) objB;
    }

    public static final AbstractC13778go1 b(D26 d26) {
        Map mapL = d26.l();
        Object objB = mapL.get("TransactionDispatcher");
        if (objB == null) {
            objB = AbstractC14260hd2.b(d26.t());
            mapL.put("TransactionDispatcher", objB);
        }
        AbstractC13042fc3.g(objB, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (AbstractC13778go1) objB;
    }
}
