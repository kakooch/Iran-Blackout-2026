package ir.nasim;

import androidx.room.d;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.fp7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13203fp7 extends d.c {
    private final SA2 b;
    private final AtomicBoolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13203fp7(String[] strArr, SA2 sa2) {
        super(strArr);
        AbstractC13042fc3.i(strArr, "tables");
        AbstractC13042fc3.i(sa2, "onInvalidated");
        this.b = sa2;
        this.c = new AtomicBoolean(false);
    }

    @Override // androidx.room.d.c
    public void c(Set set) {
        AbstractC13042fc3.i(set, "tables");
        this.b.invoke();
    }

    public final void d(D26 d26) {
        AbstractC13042fc3.i(d26, "db");
        if (this.c.compareAndSet(false, true)) {
            d26.n().d(this);
        }
    }
}
