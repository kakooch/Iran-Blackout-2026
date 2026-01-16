package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class aqc<T> extends aqa<T> {
    private static final long serialVersionUID = 0;
    private final T a;

    aqc(T t) {
        this.a = t;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqa
    public final T a() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqa
    public final <V> aqa<V> b(apw<? super T, V> apwVar) {
        V vApply = apwVar.apply(this.a);
        aqd.k(vApply, "the Function passed to Optional.transform() must not return null.");
        return new aqc(vApply);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof aqc) {
            return this.a.equals(((aqc) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() + 1502476572;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 13);
        sb.append("Optional.of(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }
}
