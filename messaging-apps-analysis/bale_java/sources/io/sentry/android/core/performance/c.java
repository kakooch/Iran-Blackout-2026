package io.sentry.android.core.performance;

/* loaded from: classes3.dex */
public class c implements Comparable {
    private final i a = new i();
    private final i b = new i();

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        int iCompare = Long.compare(this.a.t(), cVar.a.t());
        return iCompare == 0 ? Long.compare(this.b.t(), cVar.b.t()) : iCompare;
    }

    public final i h() {
        return this.a;
    }

    public final i i() {
        return this.b;
    }
}
