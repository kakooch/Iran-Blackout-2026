package ir.nasim;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.yh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C24486yh8 implements Eh8 {
    private final CountDownLatch a = new CountDownLatch(1);

    /* synthetic */ C24486yh8(AbstractC22710vh8 abstractC22710vh8) {
    }

    @Override // ir.nasim.InterfaceC14681iJ4
    public final void a(Exception exc) {
        this.a.countDown();
    }

    public final void b() throws InterruptedException {
        this.a.await();
    }

    @Override // ir.nasim.VI4
    public final void c() {
        this.a.countDown();
    }

    public final boolean d(long j, TimeUnit timeUnit) {
        return this.a.await(j, timeUnit);
    }

    @Override // ir.nasim.InterfaceC13497gK4
    public final void onSuccess(Object obj) {
        this.a.countDown();
    }
}
