package ir.nasim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.wV0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23183wV0 {
    private static final C23183wV0 e = new a().b();
    private final C19141pq7 a;
    private final List b;
    private final C15277jJ2 c;
    private final String d;

    /* renamed from: ir.nasim.wV0$a */
    public static final class a {
        private C19141pq7 a = null;
        private List b = new ArrayList();
        private C15277jJ2 c = null;
        private String d = "";

        a() {
        }

        public a a(DI3 di3) {
            this.b.add(di3);
            return this;
        }

        public C23183wV0 b() {
            return new C23183wV0(this.a, Collections.unmodifiableList(this.b), this.c, this.d);
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a d(C15277jJ2 c15277jJ2) {
            this.c = c15277jJ2;
            return this;
        }

        public a e(C19141pq7 c19141pq7) {
            this.a = c19141pq7;
            return this;
        }
    }

    C23183wV0(C19141pq7 c19141pq7, List list, C15277jJ2 c15277jJ2, String str) {
        this.a = c19141pq7;
        this.b = list;
        this.c = c15277jJ2;
        this.d = str;
    }

    public static a e() {
        return new a();
    }

    public String a() {
        return this.d;
    }

    public C15277jJ2 b() {
        return this.c;
    }

    public List c() {
        return this.b;
    }

    public C19141pq7 d() {
        return this.a;
    }

    public byte[] f() {
        return AbstractC17435mx5.a(this);
    }
}
