package ir.nasim;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.zI1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24841zI1 {
    public static final a c;
    private static int d;
    private static final int e;
    private static final int f;
    private static final int g;
    private static final int h;
    private static final int i;
    private static final int j;
    private static final int k;
    private static final int l;
    private static final int m;
    private static final int n;
    public static final C24841zI1 o;
    public static final C24841zI1 p;
    public static final C24841zI1 q;
    public static final C24841zI1 r;
    public static final C24841zI1 s;
    public static final C24841zI1 t;
    public static final C24841zI1 u;
    public static final C24841zI1 v;
    public static final C24841zI1 w;
    public static final C24841zI1 x;
    private static final List y;
    private static final List z;
    private final List a;
    private final int b;

    /* renamed from: ir.nasim.zI1$a */
    public static final class a {

        /* renamed from: ir.nasim.zI1$a$a, reason: collision with other inner class name */
        private static final class C1808a {
            private final int a;
            private final String b;

            public C1808a(int i, String str) {
                AbstractC13042fc3.i(str, "name");
                this.a = i;
                this.b = str;
            }

            public final int a() {
                return this.a;
            }

            public final String b() {
                return this.b;
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int l() {
            int i = C24841zI1.d;
            C24841zI1.d <<= 1;
            return i;
        }

        public final int b() {
            return C24841zI1.k;
        }

        public final int c() {
            return C24841zI1.n;
        }

        public final int d() {
            return C24841zI1.l;
        }

        public final int e() {
            return C24841zI1.i;
        }

        public final int f() {
            return C24841zI1.e;
        }

        public final int g() {
            return C24841zI1.h;
        }

        public final int h() {
            return C24841zI1.f;
        }

        public final int i() {
            return C24841zI1.g;
        }

        public final int j() {
            return C24841zI1.m;
        }

        public final int k() {
            return C24841zI1.j;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        a.C1808a c1808a;
        a.C1808a c1808a2;
        a aVar = new a(null);
        c = aVar;
        d = 1;
        e = aVar.l();
        f = aVar.l();
        g = aVar.l();
        h = aVar.l();
        i = aVar.l();
        j = aVar.l();
        k = aVar.l() - 1;
        l = aVar.f() | aVar.h() | aVar.i();
        m = aVar.h() | aVar.e() | aVar.k();
        n = aVar.e() | aVar.k();
        int i2 = 2;
        o = new C24841zI1(aVar.b(), 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
        p = new C24841zI1(aVar.c(), 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
        q = new C24841zI1(aVar.f(), 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
        r = new C24841zI1(aVar.h(), 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
        s = new C24841zI1(aVar.i(), 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
        t = new C24841zI1(aVar.d(), 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
        u = new C24841zI1(aVar.g(), 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
        v = new C24841zI1(aVar.e(), 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
        w = new C24841zI1(aVar.k(), 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
        x = new C24841zI1(aVar.j(), 0 == true ? 1 : 0, i2, 0 == true ? 1 : 0);
        Field[] fields = C24841zI1.class.getFields();
        AbstractC13042fc3.h(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            C24841zI1 c24841zI1 = obj instanceof C24841zI1 ? (C24841zI1) obj : null;
            if (c24841zI1 != null) {
                int iO = c24841zI1.o();
                String name = field2.getName();
                AbstractC13042fc3.h(name, "field.name");
                c1808a2 = new a.C1808a(iO, name);
            } else {
                c1808a2 = null;
            }
            if (c1808a2 != null) {
                arrayList2.add(c1808a2);
            }
        }
        y = arrayList2;
        Field[] fields2 = C24841zI1.class.getFields();
        AbstractC13042fc3.h(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (AbstractC13042fc3.d(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == ((-iIntValue) & iIntValue)) {
                String name2 = field4.getName();
                AbstractC13042fc3.h(name2, "field.name");
                c1808a = new a.C1808a(iIntValue, name2);
            } else {
                c1808a = null;
            }
            if (c1808a != null) {
                arrayList5.add(c1808a);
            }
        }
        z = arrayList5;
    }

    public C24841zI1(int i2, List list) {
        AbstractC13042fc3.i(list, "excludes");
        this.a = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i2 &= ~((AbstractC24247yI1) it.next()).a();
        }
        this.b = i2;
    }

    public final boolean a(int i2) {
        return (i2 & this.b) != 0;
    }

    public final List n() {
        return this.a;
    }

    public final int o() {
        return this.b;
    }

    public final C24841zI1 p(int i2) {
        int i3 = i2 & this.b;
        if (i3 == 0) {
            return null;
        }
        return new C24841zI1(i3, this.a);
    }

    public String toString() {
        Object next;
        Iterator it = y.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((a.C1808a) next).a() == o()) {
                break;
            }
        }
        a.C1808a c1808a = (a.C1808a) next;
        String strB = c1808a == null ? null : c1808a.b();
        if (strB == null) {
            List<a.C1808a> list = z;
            ArrayList arrayList = new ArrayList();
            for (a.C1808a c1808a2 : list) {
                String strB2 = a(c1808a2.a()) ? c1808a2.b() : null;
                if (strB2 != null) {
                    arrayList.add(strB2);
                }
            }
            strB = AbstractC15401jX0.A0(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + strB + ", " + this.a + ')';
    }

    public /* synthetic */ C24841zI1(int i2, List list, int i3, ED1 ed1) {
        this(i2, (i3 & 2) != 0 ? AbstractC10360bX0.m() : list);
    }
}
