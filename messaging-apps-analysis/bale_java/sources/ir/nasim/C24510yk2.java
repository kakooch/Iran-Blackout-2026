package ir.nasim;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.yk2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24510yk2 {
    private final String a;
    private final Map b;

    /* renamed from: ir.nasim.yk2$b */
    public static final class b {
        private final String a;
        private Map b = null;

        b(String str) {
            this.a = str;
        }

        public C24510yk2 a() {
            return new C24510yk2(this.a, this.b == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(this.b)));
        }

        public b b(Annotation annotation) {
            if (this.b == null) {
                this.b = new HashMap();
            }
            this.b.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    public static b a(String str) {
        return new b(str);
    }

    public static C24510yk2 d(String str) {
        return new C24510yk2(str, Collections.emptyMap());
    }

    public String b() {
        return this.a;
    }

    public Annotation c(Class cls) {
        return (Annotation) this.b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24510yk2)) {
            return false;
        }
        C24510yk2 c24510yk2 = (C24510yk2) obj;
        return this.a.equals(c24510yk2.a) && this.b.equals(c24510yk2.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.a + ", properties=" + this.b.values() + "}";
    }

    private C24510yk2(String str, Map map) {
        this.a = str;
        this.b = map;
    }
}
