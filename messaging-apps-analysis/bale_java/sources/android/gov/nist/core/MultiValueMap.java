package android.gov.nist.core;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface MultiValueMap<K, V> extends Map<K, List<V>>, Serializable {
    Object removeKV(K k, V v);
}
