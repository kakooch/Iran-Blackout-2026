package io.sentry;

/* renamed from: io.sentry.h2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3124h2 implements Comparable {
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AbstractC3124h2 abstractC3124h2) {
        return Long.valueOf(p()).compareTo(Long.valueOf(abstractC3124h2.p()));
    }

    public long h(AbstractC3124h2 abstractC3124h2) {
        return p() - abstractC3124h2.p();
    }

    public final boolean i(AbstractC3124h2 abstractC3124h2) {
        return h(abstractC3124h2) > 0;
    }

    public final boolean j(AbstractC3124h2 abstractC3124h2) {
        return h(abstractC3124h2) < 0;
    }

    public long o(AbstractC3124h2 abstractC3124h2) {
        return (abstractC3124h2 == null || compareTo(abstractC3124h2) >= 0) ? p() : abstractC3124h2.p();
    }

    public abstract long p();
}
