package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.fq7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13213fq7 {
    private static Runnable c;
    private static long f;
    public static final C13213fq7 a = new C13213fq7();
    private static Map b = new LinkedHashMap();
    private static int d = -1;
    private static long e = -1;
    public static final int g = 8;

    /* renamed from: ir.nasim.fq7$a */
    public static final class a extends HashMap {
        a(ExPeerType exPeerType, int i, long j, int i2, boolean z) {
            put("peer_type", exPeerType.name());
            put("peer_id", Integer.valueOf(i));
            put("duration_seconds", Long.valueOf(j));
            put("unread_count", Integer.valueOf(i2));
            put("is_comment", Boolean.valueOf(z));
        }

        public /* bridge */ boolean b(String str) {
            return super.containsKey(str);
        }

        public /* bridge */ Object c(String str) {
            return super.get(str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        public /* bridge */ Set d() {
            return super.entrySet();
        }

        public /* bridge */ Set e() {
            return super.keySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set entrySet() {
            return d();
        }

        public /* bridge */ Object f(String str, Object obj) {
            return super.getOrDefault(str, obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object get(Object obj) {
            if (obj instanceof String) {
                return c((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : f((String) obj, obj2);
        }

        public /* bridge */ int k() {
            return super.size();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set keySet() {
            return e();
        }

        public /* bridge */ Collection l() {
            return super.values();
        }

        public /* bridge */ Object n(String str) {
            return super.remove(str);
        }

        public /* bridge */ boolean p(String str, Object obj) {
            return super.remove(str, obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Object remove(Object obj) {
            if (obj instanceof String) {
                return n((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return k();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection values() {
            return l();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && obj2 != null) {
                return p((String) obj, obj2);
            }
            return false;
        }
    }

    private C13213fq7() {
    }

    private final void c(long j) {
        if (b.isEmpty()) {
            d = -1;
        } else {
            Map map = b;
            LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC19460qO3.f(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), Long.valueOf(((Number) entry.getValue()).longValue() > 0 ? ((Number) entry.getValue()).longValue() + f + (System.currentTimeMillis() - j) : ((Number) entry.getValue()).longValue()));
            }
            b = AbstractC20051rO3.A(linkedHashMap);
        }
        f = 0L;
    }

    public static final boolean d(int i) {
        boolean z;
        Long l = (Long) b.get(Integer.valueOf(i));
        if (l == null || l.longValue() <= 0) {
            b.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
            d = i;
            z = true;
        } else {
            z = false;
        }
        if (e > 0) {
            f += System.currentTimeMillis() - e;
        }
        e = -1L;
        return z;
    }

    public static final void e(String str, ExPeerType exPeerType, int i, int i2, boolean z) {
        AbstractC13042fc3.i(str, "eventName");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        Long l = (Long) b.get(Integer.valueOf(i));
        if (l == null || l.longValue() <= 0) {
            return;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() - l.longValue()) / 1000;
        b.remove(Integer.valueOf(i));
        if (jCurrentTimeMillis <= 0) {
            a.c(l.longValue());
        } else {
            C3343Am.i(str, new a(exPeerType, i, jCurrentTimeMillis, i2, z));
            a.c(l.longValue());
        }
    }

    public static /* synthetic */ void f(String str, ExPeerType exPeerType, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z = false;
        }
        e(str, exPeerType, i, i2, z);
    }

    public static final void g(int i) {
        d = i;
        b.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        if (d > 0 && (!b.isEmpty())) {
            C15225jD4.b().c(C15225jD4.o, Integer.valueOf(d));
            e = System.currentTimeMillis();
        }
        c = null;
    }

    public final void b() {
        if (c != null) {
            AbstractC7426Rr.a.d(c);
            c = null;
        }
    }

    public final void h() {
        if (b.isEmpty()) {
            return;
        }
        c = new Runnable() { // from class: ir.nasim.eq7
            @Override // java.lang.Runnable
            public final void run() {
                C13213fq7.i();
            }
        };
        AbstractC7426Rr.a.G(c, 2000L);
    }
}
