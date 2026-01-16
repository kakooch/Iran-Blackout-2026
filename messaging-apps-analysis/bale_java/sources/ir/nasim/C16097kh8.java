package ir.nasim;

import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.kh8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C16097kh8 {
    private String a;
    private final long b;
    private final Map c;

    public C16097kh8(String str, long j, Map map) {
        this.a = str;
        this.b = j;
        HashMap map2 = new HashMap();
        this.c = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }

    public final long a() {
        return this.b;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C16097kh8 clone() {
        return new C16097kh8(this.a, this.b, new HashMap(this.c));
    }

    public final Object c(String str) {
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        return null;
    }

    public final String d() {
        return this.a;
    }

    public final Map e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16097kh8)) {
            return false;
        }
        C16097kh8 c16097kh8 = (C16097kh8) obj;
        if (this.b == c16097kh8.b && this.a.equals(c16097kh8.a)) {
            return this.c.equals(c16097kh8.c);
        }
        return false;
    }

    public final void f(String str) {
        this.a = str;
    }

    public final void g(String str, Object obj) {
        if (obj == null) {
            this.c.remove(str);
        } else {
            this.c.put(str, obj);
        }
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode();
        long j = this.b;
        return (((iHashCode * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "Event{name='" + this.a + "', timestamp=" + this.b + ", params=" + this.c.toString() + "}";
    }
}
