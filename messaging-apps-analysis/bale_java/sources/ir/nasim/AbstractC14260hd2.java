package ir.nasim;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* renamed from: ir.nasim.hd2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14260hd2 {
    public static final Executor a(AbstractC13778go1 abstractC13778go1) {
        Executor executorC0;
        AbstractC11830dd2 abstractC11830dd2 = abstractC13778go1 instanceof AbstractC11830dd2 ? (AbstractC11830dd2) abstractC13778go1 : null;
        return (abstractC11830dd2 == null || (executorC0 = abstractC11830dd2.C0()) == null) ? new ZU1(abstractC13778go1) : executorC0;
    }

    public static final AbstractC13778go1 b(Executor executor) {
        AbstractC13778go1 abstractC13778go1;
        ZU1 zu1 = executor instanceof ZU1 ? (ZU1) executor : null;
        return (zu1 == null || (abstractC13778go1 = zu1.a) == null) ? new C12442ed2(executor) : abstractC13778go1;
    }

    public static final AbstractC11830dd2 c(ExecutorService executorService) {
        return new C12442ed2(executorService);
    }
}
