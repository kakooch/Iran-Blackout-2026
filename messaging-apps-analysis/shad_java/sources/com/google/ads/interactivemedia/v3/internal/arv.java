package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Map;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class arv<K, V> extends aqh implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ars<K, ? extends arj<V>> b;

    arv(ars<K, ? extends arj<V>> arsVar) {
        super(null);
        this.b = arsVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqh, com.google.ads.interactivemedia.v3.internal.asa
    public final /* bridge */ /* synthetic */ Map a() {
        return this.b;
    }
}
