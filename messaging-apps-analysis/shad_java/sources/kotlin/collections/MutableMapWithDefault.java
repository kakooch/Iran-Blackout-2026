package kotlin.collections;

import java.util.Map;

/* compiled from: MapWithDefault.kt */
/* loaded from: classes4.dex */
interface MutableMapWithDefault<K, V> extends Map<K, V>, MapWithDefault<K, V> {
    Map<K, V> getMap();
}
