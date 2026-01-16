package io.sentry;

import java.util.Date;

/* renamed from: io.sentry.f3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3115f3 extends AbstractC3124h2 {
    private final Date a;
    private final long b;

    public C3115f3() {
        this(AbstractC3141l.d(), System.nanoTime());
    }

    private long q(C3115f3 c3115f3, C3115f3 c3115f32) {
        return c3115f3.p() + (c3115f32.b - c3115f3.b);
    }

    @Override // io.sentry.AbstractC3124h2, java.lang.Comparable
    /* renamed from: a */
    public int compareTo(AbstractC3124h2 abstractC3124h2) {
        if (!(abstractC3124h2 instanceof C3115f3)) {
            return super.compareTo(abstractC3124h2);
        }
        C3115f3 c3115f3 = (C3115f3) abstractC3124h2;
        long time = this.a.getTime();
        long time2 = c3115f3.a.getTime();
        return time == time2 ? Long.valueOf(this.b).compareTo(Long.valueOf(c3115f3.b)) : Long.valueOf(time).compareTo(Long.valueOf(time2));
    }

    @Override // io.sentry.AbstractC3124h2
    public long h(AbstractC3124h2 abstractC3124h2) {
        return abstractC3124h2 instanceof C3115f3 ? this.b - ((C3115f3) abstractC3124h2).b : super.h(abstractC3124h2);
    }

    @Override // io.sentry.AbstractC3124h2
    public long o(AbstractC3124h2 abstractC3124h2) {
        if (abstractC3124h2 == null || !(abstractC3124h2 instanceof C3115f3)) {
            return super.o(abstractC3124h2);
        }
        C3115f3 c3115f3 = (C3115f3) abstractC3124h2;
        return compareTo(abstractC3124h2) < 0 ? q(this, c3115f3) : q(c3115f3, this);
    }

    @Override // io.sentry.AbstractC3124h2
    public long p() {
        return AbstractC3141l.a(this.a);
    }

    public C3115f3(Date date, long j) {
        this.a = date;
        this.b = j;
    }
}
