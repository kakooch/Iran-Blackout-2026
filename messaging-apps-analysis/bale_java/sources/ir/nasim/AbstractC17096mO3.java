package ir.nasim;

import ir.nasim.AbstractC3895Cu6;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.mO3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC17096mO3 {

    /* renamed from: ir.nasim.mO3$a */
    class a extends AbstractC18009nv7 {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.AbstractC18009nv7
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object a(Map.Entry entry) {
            return entry.getValue();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.mO3$b */
    private static abstract class b implements InterfaceC15205jB2 {
        public static final b a = new a("KEY", 0);
        public static final b b = new C1398b("VALUE", 1);
        private static final /* synthetic */ b[] c = a();

        /* renamed from: ir.nasim.mO3$b$a */
        enum a extends b {
            a(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.InterfaceC15205jB2
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getKey();
            }
        }

        /* renamed from: ir.nasim.mO3$b$b, reason: collision with other inner class name */
        enum C1398b extends b {
            C1398b(String str, int i) {
                super(str, i, null);
            }

            @Override // ir.nasim.InterfaceC15205jB2
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public Object apply(Map.Entry entry) {
                return entry.getValue();
            }
        }

        private b(String str, int i) {
        }

        private static /* synthetic */ b[] a() {
            return new b[]{a, b};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }

        /* synthetic */ b(String str, int i, AbstractC16505lO3 abstractC16505lO3) {
            this(str, i);
        }
    }

    /* renamed from: ir.nasim.mO3$c */
    static abstract class c extends AbstractC3895Cu6.d {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public abstract boolean contains(Object obj);

        abstract Map f();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return f().isEmpty();
        }

        @Override // ir.nasim.AbstractC3895Cu6.d, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) AbstractC4029Dj5.j(collection));
            } catch (UnsupportedOperationException unused) {
                return AbstractC3895Cu6.j(this, collection.iterator());
            }
        }

        @Override // ir.nasim.AbstractC3895Cu6.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) AbstractC4029Dj5.j(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetG = AbstractC3895Cu6.g(collection.size());
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        hashSetG.add(((Map.Entry) obj).getKey());
                    }
                }
                return f().keySet().retainAll(hashSetG);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f().size();
        }
    }

    /* renamed from: ir.nasim.mO3$d */
    static class d extends AbstractC3895Cu6.d {
        final Map a;

        d(Map map) {
            this.a = (Map) AbstractC4029Dj5.j(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return f().containsKey(obj);
        }

        Map f() {
            return this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return f().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f().size();
        }
    }

    /* renamed from: ir.nasim.mO3$e */
    static class e extends AbstractCollection {
        final Map a;

        e(Map map) {
            this.a = (Map) AbstractC4029Dj5.j(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            f().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return f().containsValue(obj);
        }

        final Map f() {
            return this.a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return f().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC17096mO3.k(f().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry entry : f().entrySet()) {
                    if (EG4.a(obj, entry.getValue())) {
                        f().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            try {
                return super.removeAll((Collection) AbstractC4029Dj5.j(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetF = AbstractC3895Cu6.f();
                for (Map.Entry entry : f().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetF.add(entry.getKey());
                    }
                }
                return f().keySet().removeAll(hashSetF);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            try {
                return super.retainAll((Collection) AbstractC4029Dj5.j(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetF = AbstractC3895Cu6.f();
                for (Map.Entry entry : f().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetF.add(entry.getKey());
                    }
                }
                return f().keySet().retainAll(hashSetF);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return f().size();
        }
    }

    /* renamed from: ir.nasim.mO3$f */
    static abstract class f extends AbstractMap {
        private transient Set a;
        private transient Collection b;

        f() {
        }

        abstract Set b();

        Collection c() {
            return new e(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            Set set = this.a;
            if (set != null) {
                return set;
            }
            Set setB = b();
            this.a = setB;
            return setB;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection values() {
            Collection collection = this.b;
            if (collection != null) {
                return collection;
            }
            Collection collectionC = c();
            this.b = collectionC;
            return collectionC;
        }
    }

    static int a(int i) {
        if (i < 3) {
            MW0.b(i, "expectedSize");
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    static boolean b(Map map, Object obj) {
        return AbstractC17855ng3.d(k(map.entrySet().iterator()), obj);
    }

    static boolean c(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static Map.Entry d(Object obj, Object obj2) {
        return new C10096b43(obj, obj2);
    }

    public static IdentityHashMap e() {
        return new IdentityHashMap();
    }

    static boolean f(Map map, Object obj) {
        AbstractC4029Dj5.j(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static Object g(Map map, Object obj) {
        AbstractC4029Dj5.j(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static Object h(Map map, Object obj) {
        AbstractC4029Dj5.j(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static String i(Map map) {
        StringBuilder sbB = XW0.b(map.size());
        sbB.append('{');
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z) {
                sbB.append(", ");
            }
            sbB.append(entry.getKey());
            sbB.append('=');
            sbB.append(entry.getValue());
            z = false;
        }
        sbB.append('}');
        return sbB.toString();
    }

    static InterfaceC15205jB2 j() {
        return b.b;
    }

    static Iterator k(Iterator it) {
        return new a(it);
    }
}
