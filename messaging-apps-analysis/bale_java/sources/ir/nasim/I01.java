package ir.nasim;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final class I01 {
    private final String a;
    private final Set b;
    private final Set c;
    private final int d;
    private final int e;
    private final Y01 f;
    private final Set g;

    public static class b {
        private String a;
        private final Set b;
        private final Set c;
        private int d;
        private int e;
        private Y01 f;
        private Set g;

        /* JADX INFO: Access modifiers changed from: private */
        public b g() {
            this.e = 1;
            return this;
        }

        private b i(int i) {
            AbstractC4263Ej5.d(this.d == 0, "Instantiation type has already been set.");
            this.d = i;
            return this;
        }

        private void j(Class cls) {
            AbstractC4263Ej5.a(!this.b.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b b(C10226bI1 c10226bI1) {
            AbstractC4263Ej5.c(c10226bI1, "Null dependency");
            j(c10226bI1.b());
            this.c.add(c10226bI1);
            return this;
        }

        public b c() {
            return i(1);
        }

        public I01 d() {
            AbstractC4263Ej5.d(this.f != null, "Missing required property: factory.");
            return new I01(this.a, new HashSet(this.b), new HashSet(this.c), this.d, this.e, this.f, this.g);
        }

        public b e() {
            return i(2);
        }

        public b f(Y01 y01) {
            this.f = (Y01) AbstractC4263Ej5.c(y01, "Null factory");
            return this;
        }

        public b h(String str) {
            this.a = str;
            return this;
        }

        private b(Class cls, Class... clsArr) {
            this.a = null;
            HashSet hashSet = new HashSet();
            this.b = hashSet;
            this.c = new HashSet();
            this.d = 0;
            this.e = 0;
            this.g = new HashSet();
            AbstractC4263Ej5.c(cls, "Null interface");
            hashSet.add(cls);
            for (Class cls2 : clsArr) {
                AbstractC4263Ej5.c(cls2, "Null interface");
            }
            Collections.addAll(this.b, clsArr);
        }
    }

    public static b c(Class cls) {
        return new b(cls, new Class[0]);
    }

    public static b d(Class cls, Class... clsArr) {
        return new b(cls, clsArr);
    }

    public static I01 j(final Object obj, Class cls) {
        return k(cls).f(new Y01() { // from class: ir.nasim.G01
            @Override // ir.nasim.Y01
            public final Object a(S01 s01) {
                return I01.o(obj, s01);
            }
        }).d();
    }

    public static b k(Class cls) {
        return c(cls).g();
    }

    public static I01 q(final Object obj, Class cls, Class... clsArr) {
        return d(cls, clsArr).f(new Y01() { // from class: ir.nasim.H01
            @Override // ir.nasim.Y01
            public final Object a(S01 s01) {
                return I01.p(obj, s01);
            }
        }).d();
    }

    public Set e() {
        return this.c;
    }

    public Y01 f() {
        return this.f;
    }

    public String g() {
        return this.a;
    }

    public Set h() {
        return this.b;
    }

    public Set i() {
        return this.g;
    }

    public boolean l() {
        return this.d == 1;
    }

    public boolean m() {
        return this.d == 2;
    }

    public boolean n() {
        return this.e == 0;
    }

    public I01 r(Y01 y01) {
        return new I01(this.a, this.b, this.c, this.d, this.e, y01, this.g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.b.toArray()) + ">{" + this.d + ", type=" + this.e + ", deps=" + Arrays.toString(this.c.toArray()) + "}";
    }

    private I01(String str, Set set, Set set2, int i, int i2, Y01 y01, Set set3) {
        this.a = str;
        this.b = Collections.unmodifiableSet(set);
        this.c = Collections.unmodifiableSet(set2);
        this.d = i;
        this.e = i2;
        this.f = y01;
        this.g = Collections.unmodifiableSet(set3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object o(Object obj, S01 s01) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object p(Object obj, S01 s01) {
        return obj;
    }
}
