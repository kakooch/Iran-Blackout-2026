package ir.nasim;

import java.util.Map;

/* renamed from: ir.nasim.kj7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16116kj7 {
    public static final a b = new a(null);
    public static final C16116kj7 c = new C16116kj7(AbstractC20051rO3.k());
    private final Map a;

    /* renamed from: ir.nasim.kj7$a */
    public static final class a {
        private a() {
        }

        public final C16116kj7 a(Map map) {
            return new C16116kj7(AbstractC12074e.b(map), null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C16116kj7(Map map, ED1 ed1) {
        this(map);
    }

    public final Map a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C16116kj7) && AbstractC13042fc3.d(this.a, ((C16116kj7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "Tags(tags=" + this.a + ')';
    }

    private C16116kj7(Map map) {
        this.a = map;
    }
}
