package ir.nasim;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: ir.nasim.Yi4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C9066Yi4 {
    private final C7350Ri4 a;
    private final List b;
    private final Integer c;

    /* renamed from: ir.nasim.Yi4$b */
    public static final class b {
        private ArrayList a = new ArrayList();
        private C7350Ri4 b = C7350Ri4.b;
        private Integer c = null;

        private boolean c(int i) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                if (((c) it.next()).a() == i) {
                    return true;
                }
            }
            return false;
        }

        public b a(C5959Lo3 c5959Lo3, int i, String str, String str2) {
            ArrayList arrayList = this.a;
            if (arrayList == null) {
                throw new IllegalStateException("addEntry cannot be called after build()");
            }
            arrayList.add(new c(c5959Lo3, i, str, str2));
            return this;
        }

        public C9066Yi4 b() throws GeneralSecurityException {
            if (this.a == null) {
                throw new IllegalStateException("cannot call build() twice");
            }
            Integer num = this.c;
            if (num != null && !c(num.intValue())) {
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            C9066Yi4 c9066Yi4 = new C9066Yi4(this.b, Collections.unmodifiableList(this.a), this.c);
            this.a = null;
            return c9066Yi4;
        }

        public b d(C7350Ri4 c7350Ri4) {
            if (this.a == null) {
                throw new IllegalStateException("setAnnotations cannot be called after build()");
            }
            this.b = c7350Ri4;
            return this;
        }

        public b e(int i) {
            if (this.a == null) {
                throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
            }
            this.c = Integer.valueOf(i);
            return this;
        }
    }

    /* renamed from: ir.nasim.Yi4$c */
    public static final class c {
        private final C5959Lo3 a;
        private final int b;
        private final String c;
        private final String d;

        public int a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b && this.c.equals(cVar.c) && this.d.equals(cVar.d);
        }

        public int hashCode() {
            return Objects.hash(this.a, Integer.valueOf(this.b), this.c, this.d);
        }

        public String toString() {
            return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", this.a, Integer.valueOf(this.b), this.c, this.d);
        }

        private c(C5959Lo3 c5959Lo3, int i, String str, String str2) {
            this.a = c5959Lo3;
            this.b = i;
            this.c = str;
            this.d = str2;
        }
    }

    public static b a() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C9066Yi4)) {
            return false;
        }
        C9066Yi4 c9066Yi4 = (C9066Yi4) obj;
        return this.a.equals(c9066Yi4.a) && this.b.equals(c9066Yi4.b) && Objects.equals(this.c, c9066Yi4.c);
    }

    public int hashCode() {
        return Objects.hash(this.a, this.b);
    }

    public String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", this.a, this.b, this.c);
    }

    private C9066Yi4(C7350Ri4 c7350Ri4, List list, Integer num) {
        this.a = c7350Ri4;
        this.b = list;
        this.c = num;
    }
}
