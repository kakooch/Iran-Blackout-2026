package com.google.ads.interactivemedia.v3.internal;

import androidMessenger.proxy.CallProxy$$ExternalSyntheticBackport0;
import java.io.Serializable;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class aup<L, R> implements Map.Entry<L, R>, Comparable<aup<L, R>>, Serializable {
    private static final long serialVersionUID = 4954918890077093841L;

    public static <L, R> aup<L, R> c(L l, R r) {
        return new auo(l, r);
    }

    public abstract L a();

    public abstract R b();

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        aup aupVar = (aup) obj;
        return new aui().a(a(), aupVar.a()).a(b(), aupVar.b()).b();
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (CallProxy$$ExternalSyntheticBackport0.m(a(), entry.getKey()) && CallProxy$$ExternalSyntheticBackport0.m(b(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final L getKey() {
        return a();
    }

    @Override // java.util.Map.Entry
    public final R getValue() {
        return b();
    }

    public final String toString() {
        return "(" + a() + ',' + b() + ')';
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return (a() == null ? 0 : a().hashCode()) ^ (b() != null ? b().hashCode() : 0);
    }
}
