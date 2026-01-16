package j$.util;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.wrappers.C0295q;
import j$.wrappers.C0296s;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public class DesugarCollections {
    public static final Class a;
    static final Class b;
    private static final Field c;
    private static final Field d;
    private static final Constructor e;
    private static final Constructor f;

    static {
        Field declaredField;
        Field declaredField2;
        Constructor<?> declaredConstructor;
        Class<?> cls = Collections.synchronizedCollection(new ArrayList()).getClass();
        a = cls;
        b = Collections.synchronizedList(new LinkedList()).getClass();
        Constructor<?> declaredConstructor2 = null;
        try {
            declaredField = cls.getDeclaredField("mutex");
        } catch (NoSuchFieldException unused) {
            declaredField = null;
        }
        c = declaredField;
        if (declaredField != null) {
            declaredField.setAccessible(true);
        }
        try {
            declaredField2 = cls.getDeclaredField("c");
        } catch (NoSuchFieldException unused2) {
            declaredField2 = null;
        }
        d = declaredField2;
        if (declaredField2 != null) {
            declaredField2.setAccessible(true);
        }
        try {
            declaredConstructor = Collections.synchronizedSet(new HashSet()).getClass().getDeclaredConstructor(Set.class, Object.class);
        } catch (NoSuchMethodException unused3) {
            declaredConstructor = null;
        }
        f = declaredConstructor;
        if (declaredConstructor != null) {
            declaredConstructor.setAccessible(true);
        }
        try {
            declaredConstructor2 = cls.getDeclaredConstructor(Collection.class, Object.class);
        } catch (NoSuchMethodException unused4) {
        }
        e = declaredConstructor2;
        if (declaredConstructor2 != null) {
            declaredConstructor2.setAccessible(true);
        }
    }

    public static void c(Iterable iterable, Consumer consumer) throws IllegalAccessException, IllegalArgumentException {
        Field field = c;
        if (field == null) {
            try {
                AbstractC0102a.v((Collection) d.get(iterable), consumer);
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized collection forEach fall-back.", e2);
            }
        } else {
            try {
                synchronized (field.get(iterable)) {
                    AbstractC0102a.v((Collection) d.get(iterable), consumer);
                }
            } catch (IllegalAccessException e3) {
                throw new Error("Runtime illegal access in synchronized collection forEach.", e3);
            }
        }
    }

    static boolean d(Collection collection, j$.util.function.y yVar) {
        boolean zL;
        Field field = c;
        if (field == null) {
            try {
                Collection collection2 = (Collection) d.get(collection);
                return collection2 instanceof InterfaceC0103b ? ((InterfaceC0103b) collection2).l(yVar) : AbstractC0102a.h(collection2, yVar);
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized collection removeIf fall-back.", e2);
            }
        }
        try {
            synchronized (field.get(collection)) {
                Collection collection3 = (Collection) d.get(collection);
                zL = collection3 instanceof InterfaceC0103b ? ((InterfaceC0103b) collection3).l(yVar) : AbstractC0102a.h(collection3, yVar);
            }
            return zL;
        } catch (IllegalAccessException e3) {
            throw new Error("Runtime illegal access in synchronized collection removeIf.", e3);
        }
    }

    static void e(List list, Comparator comparator) throws IllegalAccessException, IllegalArgumentException {
        Field field = c;
        if (field == null) {
            try {
                List$EL.sort((List) d.get(list), comparator);
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized collection sort fall-back.", e2);
            }
        } else {
            try {
                synchronized (field.get(list)) {
                    List$EL.sort((List) d.get(list), comparator);
                }
            } catch (IllegalAccessException e3) {
                throw new Error("Runtime illegal access in synchronized list sort.", e3);
            }
        }
    }

    public static <K, V> java.util.Map<K, V> synchronizedMap(java.util.Map<K, V> map) {
        return new a(map);
    }

    private static class a implements java.util.Map, Serializable, Map {
        private final java.util.Map a;
        final Object b;
        private transient Set c;
        private transient Set d;
        private transient Collection e;

        a(java.util.Map map) {
            map.getClass();
            this.a = map;
            this.b = this;
        }

        private Set a(Set set, Object obj) {
            if (DesugarCollections.f == null) {
                return Collections.synchronizedSet(set);
            }
            try {
                return (Set) DesugarCollections.f.newInstance(set, obj);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                throw new Error("Unable to instantiate a synchronized list.", e);
            }
        }

        @Override // java.util.Map, j$.util.Map
        public void clear() {
            synchronized (this.b) {
                this.a.clear();
            }
        }

        @Override // j$.util.Map
        public Object compute(Object obj, BiFunction biFunction) {
            Object obj$default$compute;
            Object objApply;
            synchronized (this.b) {
                try {
                    java.util.Map map = this.a;
                    if (map instanceof Map) {
                        obj$default$compute = ((Map) map).compute(obj, biFunction);
                    } else if (map instanceof ConcurrentMap) {
                        ConcurrentMap concurrentMap = (ConcurrentMap) map;
                        biFunction.getClass();
                        loop0: while (true) {
                            Object objPutIfAbsent = concurrentMap.get(obj);
                            while (true) {
                                objApply = biFunction.apply(obj, objPutIfAbsent);
                                if (objApply == null) {
                                    objApply = null;
                                    if (objPutIfAbsent == null && !concurrentMap.containsKey(obj)) {
                                        break;
                                    }
                                    if (concurrentMap.remove(obj, objPutIfAbsent)) {
                                        break;
                                    }
                                } else if (objPutIfAbsent == null) {
                                    objPutIfAbsent = concurrentMap.putIfAbsent(obj, objApply);
                                    if (objPutIfAbsent == null) {
                                        break loop0;
                                    }
                                } else if (concurrentMap.replace(obj, objPutIfAbsent, objApply)) {
                                    break;
                                }
                            }
                        }
                        obj$default$compute = objApply;
                    } else {
                        obj$default$compute = Map.CC.$default$compute(map, obj, biFunction);
                    }
                } finally {
                }
            }
            return obj$default$compute;
        }

        @Override // java.util.Map
        public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
            return compute(obj, C0296s.a(biFunction));
        }

        @Override // j$.util.Map
        public Object computeIfAbsent(Object obj, Function function) {
            Object objComputeIfAbsent;
            synchronized (this.b) {
                objComputeIfAbsent = Map.EL.computeIfAbsent(this.a, obj, function);
            }
            return objComputeIfAbsent;
        }

        @Override // java.util.Map
        public Object computeIfAbsent(Object obj, java.util.function.Function function) {
            Object objComputeIfAbsent;
            Function functionA = j$.wrappers.L.a(function);
            synchronized (this.b) {
                objComputeIfAbsent = Map.EL.computeIfAbsent(this.a, obj, functionA);
            }
            return objComputeIfAbsent;
        }

        @Override // j$.util.Map
        public Object computeIfPresent(Object obj, BiFunction biFunction) {
            Object obj$default$computeIfPresent;
            synchronized (this.b) {
                try {
                    java.util.Map map = this.a;
                    if (map instanceof Map) {
                        obj$default$computeIfPresent = ((Map) map).computeIfPresent(obj, biFunction);
                    } else if (map instanceof ConcurrentMap) {
                        ConcurrentMap concurrentMap = (ConcurrentMap) map;
                        biFunction.getClass();
                        while (true) {
                            Object obj2 = concurrentMap.get(obj);
                            if (obj2 == null) {
                                obj$default$computeIfPresent = obj2;
                                break;
                            }
                            Object objApply = biFunction.apply(obj, obj2);
                            if (objApply != null) {
                                if (concurrentMap.replace(obj, obj2, objApply)) {
                                    obj$default$computeIfPresent = objApply;
                                    break;
                                }
                            } else if (concurrentMap.remove(obj, obj2)) {
                                obj$default$computeIfPresent = null;
                                break;
                            }
                        }
                    } else {
                        obj$default$computeIfPresent = Map.CC.$default$computeIfPresent(map, obj, biFunction);
                    }
                } finally {
                }
            }
            return obj$default$computeIfPresent;
        }

        @Override // java.util.Map
        public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
            return computeIfPresent(obj, C0296s.a(biFunction));
        }

        @Override // java.util.Map, j$.util.Map
        public boolean containsKey(Object obj) {
            boolean zContainsKey;
            synchronized (this.b) {
                zContainsKey = this.a.containsKey(obj);
            }
            return zContainsKey;
        }

        @Override // java.util.Map, j$.util.Map
        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.b) {
                zContainsValue = this.a.containsValue(obj);
            }
            return zContainsValue;
        }

        @Override // java.util.Map, j$.util.Map
        public Set entrySet() {
            Set set;
            synchronized (this.b) {
                if (this.d == null) {
                    this.d = a(this.a.entrySet(), this.b);
                }
                set = this.d;
            }
            return set;
        }

        @Override // java.util.Map, j$.util.Map
        public boolean equals(Object obj) {
            boolean zEquals;
            if (this == obj) {
                return true;
            }
            synchronized (this.b) {
                zEquals = this.a.equals(obj);
            }
            return zEquals;
        }

        @Override // j$.util.Map
        public void forEach(BiConsumer biConsumer) {
            synchronized (this.b) {
                try {
                    java.util.Map map = this.a;
                    if (map instanceof Map) {
                        ((Map) map).forEach(biConsumer);
                    } else if (map instanceof ConcurrentMap) {
                        j$.lang.d.a((ConcurrentMap) map, biConsumer);
                    } else {
                        Map.CC.$default$forEach(map, biConsumer);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.Map
        public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
            forEach(C0295q.b(biConsumer));
        }

        @Override // java.util.Map, j$.util.Map
        public Object get(Object obj) {
            Object obj2;
            synchronized (this.b) {
                obj2 = this.a.get(obj);
            }
            return obj2;
        }

        @Override // java.util.Map, j$.util.Map
        public Object getOrDefault(Object obj, Object obj2) {
            Object orDefault;
            synchronized (this.b) {
                orDefault = Map.EL.getOrDefault(this.a, obj, obj2);
            }
            return orDefault;
        }

        @Override // java.util.Map, j$.util.Map
        public int hashCode() {
            int iHashCode;
            synchronized (this.b) {
                iHashCode = this.a.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Map, j$.util.Map
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.b) {
                zIsEmpty = this.a.isEmpty();
            }
            return zIsEmpty;
        }

        @Override // java.util.Map, j$.util.Map
        public Set keySet() {
            Set set;
            synchronized (this.b) {
                if (this.c == null) {
                    this.c = a(this.a.keySet(), this.b);
                }
                set = this.c;
            }
            return set;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        
            r3 = r7.apply(r2, r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
        
            if (r3 == null) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        
            if (r1.replace(r5, r2, r3) == false) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        
            r6 = r3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
        
            if (r1.remove(r5, r2) == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
        
            r6 = null;
         */
        @Override // j$.util.Map
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object merge(java.lang.Object r5, java.lang.Object r6, j$.util.function.BiFunction r7) {
            /*
                r4 = this;
                java.lang.Object r0 = r4.b
                monitor-enter(r0)
                java.util.Map r1 = r4.a     // Catch: java.lang.Throwable -> L30
                boolean r2 = r1 instanceof j$.util.Map     // Catch: java.lang.Throwable -> L30
                if (r2 == 0) goto L10
                j$.util.Map r1 = (j$.util.Map) r1     // Catch: java.lang.Throwable -> L30
                java.lang.Object r5 = r1.merge(r5, r6, r7)     // Catch: java.lang.Throwable -> L30
                goto L46
            L10:
                boolean r2 = r1 instanceof java.util.concurrent.ConcurrentMap     // Catch: java.lang.Throwable -> L30
                if (r2 == 0) goto L42
                java.util.concurrent.ConcurrentMap r1 = (java.util.concurrent.ConcurrentMap) r1     // Catch: java.lang.Throwable -> L30
                r7.getClass()     // Catch: java.lang.Throwable -> L30
                r6.getClass()     // Catch: java.lang.Throwable -> L30
            L1c:
                java.lang.Object r2 = r1.get(r5)     // Catch: java.lang.Throwable -> L30
            L20:
                if (r2 == 0) goto L3a
                java.lang.Object r3 = r7.apply(r2, r6)     // Catch: java.lang.Throwable -> L30
                if (r3 == 0) goto L32
                boolean r2 = r1.replace(r5, r2, r3)     // Catch: java.lang.Throwable -> L30
                if (r2 == 0) goto L1c
                r6 = r3
                goto L40
            L30:
                r5 = move-exception
                goto L48
            L32:
                boolean r2 = r1.remove(r5, r2)     // Catch: java.lang.Throwable -> L30
                if (r2 == 0) goto L1c
                r6 = 0
                goto L40
            L3a:
                java.lang.Object r2 = r1.putIfAbsent(r5, r6)     // Catch: java.lang.Throwable -> L30
                if (r2 != 0) goto L20
            L40:
                r5 = r6
                goto L46
            L42:
                java.lang.Object r5 = j$.util.Map.CC.$default$merge(r1, r5, r6, r7)     // Catch: java.lang.Throwable -> L30
            L46:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L30
                return r5
            L48:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L30
                goto L4b
            L4a:
                throw r5
            L4b:
                goto L4a
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.DesugarCollections.a.merge(java.lang.Object, java.lang.Object, j$.util.function.BiFunction):java.lang.Object");
        }

        @Override // java.util.Map
        public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
            return merge(obj, obj2, C0296s.a(biFunction));
        }

        @Override // java.util.Map, j$.util.Map
        public Object put(Object obj, Object obj2) {
            Object objPut;
            synchronized (this.b) {
                objPut = this.a.put(obj, obj2);
            }
            return objPut;
        }

        @Override // java.util.Map, j$.util.Map
        public void putAll(java.util.Map map) {
            synchronized (this.b) {
                this.a.putAll(map);
            }
        }

        @Override // java.util.Map, j$.util.Map
        public Object putIfAbsent(Object obj, Object obj2) {
            Object objA;
            synchronized (this.b) {
                objA = Map.EL.a(this.a, obj, obj2);
            }
            return objA;
        }

        @Override // java.util.Map, j$.util.Map
        public Object remove(Object obj) {
            Object objRemove;
            synchronized (this.b) {
                objRemove = this.a.remove(obj);
            }
            return objRemove;
        }

        @Override // java.util.Map, j$.util.Map
        public boolean remove(Object obj, Object obj2) {
            boolean zRemove;
            synchronized (this.b) {
                try {
                    java.util.Map map = this.a;
                    zRemove = map instanceof Map ? ((Map) map).remove(obj, obj2) : Map.CC.$default$remove(map, obj, obj2);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zRemove;
        }

        @Override // java.util.Map, j$.util.Map
        public Object replace(Object obj, Object obj2) {
            Object objReplace;
            synchronized (this.b) {
                try {
                    java.util.Map map = this.a;
                    objReplace = map instanceof Map ? ((Map) map).replace(obj, obj2) : Map.CC.$default$replace(map, obj, obj2);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return objReplace;
        }

        @Override // j$.util.Map
        public void replaceAll(BiFunction biFunction) {
            synchronized (this.b) {
                try {
                    java.util.Map map = this.a;
                    if (map instanceof Map) {
                        ((Map) map).replaceAll(biFunction);
                    } else if (map instanceof ConcurrentMap) {
                        ConcurrentMap concurrentMap = (ConcurrentMap) map;
                        biFunction.getClass();
                        j$.util.concurrent.a aVar = new j$.util.concurrent.a(concurrentMap, biFunction);
                        if (concurrentMap instanceof j$.util.concurrent.b) {
                            ((j$.util.concurrent.b) concurrentMap).forEach(aVar);
                        } else {
                            j$.lang.d.a(concurrentMap, aVar);
                        }
                    } else {
                        Map.CC.$default$replaceAll(map, biFunction);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.Map
        public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
            replaceAll(C0296s.a(biFunction));
        }

        @Override // java.util.Map, j$.util.Map
        public int size() {
            int size;
            synchronized (this.b) {
                size = this.a.size();
            }
            return size;
        }

        public String toString() {
            String string;
            synchronized (this.b) {
                string = this.a.toString();
            }
            return string;
        }

        @Override // java.util.Map, j$.util.Map
        public Collection values() {
            Collection collection;
            Collection collectionSynchronizedCollection;
            synchronized (this.b) {
                try {
                    if (this.e == null) {
                        Collection collectionValues = this.a.values();
                        Object obj = this.b;
                        if (DesugarCollections.e == null) {
                            collectionSynchronizedCollection = Collections.synchronizedCollection(collectionValues);
                        } else {
                            try {
                                collectionSynchronizedCollection = (Collection) DesugarCollections.e.newInstance(collectionValues, obj);
                            } catch (IllegalAccessException e) {
                                e = e;
                                throw new Error("Unable to instantiate a synchronized list.", e);
                            } catch (InstantiationException e2) {
                                e = e2;
                                throw new Error("Unable to instantiate a synchronized list.", e);
                            } catch (InvocationTargetException e3) {
                                e = e3;
                                throw new Error("Unable to instantiate a synchronized list.", e);
                            }
                        }
                        this.e = collectionSynchronizedCollection;
                    }
                    collection = this.e;
                } finally {
                }
            }
            return collection;
        }

        @Override // java.util.Map, j$.util.Map
        public boolean replace(Object obj, Object obj2, Object obj3) {
            boolean zReplace;
            synchronized (this.b) {
                try {
                    java.util.Map map = this.a;
                    zReplace = map instanceof Map ? ((Map) map).replace(obj, obj2, obj3) : Map.CC.$default$replace(map, obj, obj2, obj3);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zReplace;
        }
    }
}
