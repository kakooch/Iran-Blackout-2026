package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
class aqh<K, V> implements asa<K, V> {
    aqh() {
    }

    aqh(byte[] bArr) {
        this();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.asa
    public Map<K, Collection<V>> a() {
        throw null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof asa) {
            return a().equals(((asa) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }
}
