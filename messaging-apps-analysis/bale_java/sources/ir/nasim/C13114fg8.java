package ir.nasim;

import android.content.Context;
import android.util.Log;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.fg8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C13114fg8 extends AbstractC24272yL implements PB6 {
    private final Semaphore o;
    private final Set p;

    public C13114fg8(Context context, Set set) {
        super(context);
        this.o = new Semaphore(0);
        this.p = set;
    }

    @Override // ir.nasim.AbstractC24272yL
    public final /* bridge */ /* synthetic */ Object A() throws InterruptedException {
        Iterator it = this.p.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((com.google.android.gms.common.api.c) it.next()).d(this)) {
                i++;
            }
        }
        try {
            this.o.tryAcquire(i, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // ir.nasim.AbstractC22455vG3
    protected final void o() {
        this.o.drainPermits();
        h();
    }
}
