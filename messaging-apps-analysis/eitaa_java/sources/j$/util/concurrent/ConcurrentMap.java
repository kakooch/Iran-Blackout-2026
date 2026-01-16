package j$.util.concurrent;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;

/* loaded from: classes2.dex */
public interface ConcurrentMap<K, V> extends Map<K, V> {
    @Override // j$.util.Map
    Object compute(Object obj, BiFunction biFunction);

    @Override // j$.util.Map
    Object computeIfAbsent(Object obj, Function function);

    @Override // j$.util.Map
    Object computeIfPresent(Object obj, BiFunction biFunction);

    @Override // j$.util.Map
    void forEach(BiConsumer biConsumer);

    @Override // java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map, java.util.HashMap
    Object getOrDefault(Object obj, Object obj2);

    @Override // j$.util.Map
    Object merge(Object obj, Object obj2, BiFunction biFunction);

    @Override // java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    Object putIfAbsent(Object obj, Object obj2);

    @Override // java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    boolean remove(Object obj, Object obj2);

    @Override // java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    Object replace(Object obj, Object obj2);

    @Override // java.util.concurrent.ConcurrentMap, j$.util.concurrent.ConcurrentMap, j$.util.Map
    boolean replace(Object obj, Object obj2, Object obj3);

    @Override // j$.util.Map
    void replaceAll(BiFunction biFunction);
}
