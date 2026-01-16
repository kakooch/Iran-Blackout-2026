package com.google.common.collect;

import java.util.Map;

/* loaded from: classes3.dex */
public interface BiMap<K, V> extends Map<K, V> {
    BiMap<V, K> inverse();
}
