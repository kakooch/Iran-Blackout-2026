package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class FullSegmentEncryptionKeyCache {
    private final LinkedHashMap<Uri, byte[]> backingMap;

    public FullSegmentEncryptionKeyCache(int maxSize) {
        this.backingMap = new AnonymousClass1(maxSize + 1, 1.0f, false, maxSize);
    }

    /* renamed from: com.google.android.exoplayer2.source.hls.FullSegmentEncryptionKeyCache$1, reason: invalid class name */
    class AnonymousClass1 extends LinkedHashMap<Uri, byte[]> implements Map {
        final /* synthetic */ int val$maxSize;

        @Override // j$.util.Map
        public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
            return Map.CC.$default$compute(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
            return Map.CC.$default$computeIfAbsent(this, obj, function);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
            return Map.CC.$default$computeIfPresent(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ void forEach(BiConsumer biConsumer) {
            Map.CC.$default$forEach(this, biConsumer);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return Map.CC.$default$getOrDefault(this, obj, obj2);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
            return Map.CC.$default$merge(this, obj, obj2, biFunction);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
            return Map.CC.$default$putIfAbsent(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ boolean remove(Object obj, Object obj2) {
            return Map.CC.$default$remove(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ Object replace(Object obj, Object obj2) {
            return Map.CC.$default$replace(this, obj, obj2);
        }

        @Override // java.util.HashMap, java.util.Map, j$.util.Map
        public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
            return Map.CC.$default$replace(this, obj, obj2, obj3);
        }

        @Override // j$.util.Map
        public /* synthetic */ void replaceAll(BiFunction biFunction) {
            Map.CC.$default$replaceAll(this, biFunction);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int initialCapacity, float loadFactor, boolean accessOrder, final int val$maxSize) {
            super(initialCapacity, loadFactor, accessOrder);
            this.val$maxSize = val$maxSize;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Uri, byte[]> eldest) {
            return size() > this.val$maxSize;
        }
    }

    public byte[] get(Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.backingMap.get(uri);
    }

    public byte[] put(Uri uri, byte[] encryptionKey) {
        return this.backingMap.put((Uri) Assertions.checkNotNull(uri), (byte[]) Assertions.checkNotNull(encryptionKey));
    }

    public byte[] remove(Uri uri) {
        return this.backingMap.remove(Assertions.checkNotNull(uri));
    }
}
