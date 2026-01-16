package ir.nasim;

import java.util.concurrent.ExecutorService;

/* renamed from: ir.nasim.To, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC7872To implements InterfaceC10343bV1 {
    private final InterfaceC9173Yu3 a = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.So
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return AbstractC7872To.c();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExecutorService c() {
        return SZ.m("S_ADP_dispatch", 0, 0L, false, 14, null);
    }

    private final ExecutorService d() {
        return (ExecutorService) this.a.getValue();
    }

    @Override // ir.nasim.InterfaceC10343bV1
    public void a(Runnable runnable) {
        AbstractC13042fc3.i(runnable, "runnable");
        d().execute(runnable);
    }
}
