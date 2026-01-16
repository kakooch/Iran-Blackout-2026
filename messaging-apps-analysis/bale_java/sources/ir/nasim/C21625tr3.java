package ir.nasim;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.tr3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21625tr3 {
    private final a a;
    private final C6404Nl3 b;
    private final C4513Fl3 c;
    private final String[] d;
    private final String[] e;
    private final String[] f;
    private final String g;
    private final int h;
    private final String i;

    /* renamed from: ir.nasim.tr3$a */
    public enum a {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);

        public static final C1605a b = new C1605a(null);
        private static final Map c;
        private final int a;

        /* renamed from: ir.nasim.tr3$a$a, reason: collision with other inner class name */
        public static final class C1605a {
            private C1605a() {
            }

            public final a a(int i) {
                a aVar = (a) a.c.get(Integer.valueOf(i));
                return aVar == null ? a.UNKNOWN : aVar;
            }

            public /* synthetic */ C1605a(ED1 ed1) {
                this();
            }
        }

        static {
            a[] aVarArrValuesCustom = valuesCustom();
            LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(aVarArrValuesCustom.length), 16));
            for (a aVar : aVarArrValuesCustom) {
                linkedHashMap.put(Integer.valueOf(aVar.p()), aVar);
            }
            c = linkedHashMap;
        }

        a(int i) {
            this.a = i;
        }

        public static final a j(int i) {
            return b.a(i);
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }

        public final int p() {
            return this.a;
        }
    }

    public C21625tr3(a aVar, C6404Nl3 c6404Nl3, C4513Fl3 c4513Fl3, String[] strArr, String[] strArr2, String[] strArr3, String str, int i, String str2) {
        AbstractC13042fc3.i(aVar, "kind");
        AbstractC13042fc3.i(c6404Nl3, "metadataVersion");
        AbstractC13042fc3.i(c4513Fl3, "bytecodeVersion");
        this.a = aVar;
        this.b = c6404Nl3;
        this.c = c4513Fl3;
        this.d = strArr;
        this.e = strArr2;
        this.f = strArr3;
        this.g = str;
        this.h = i;
        this.i = str2;
    }

    private final boolean h(int i, int i2) {
        return (i & i2) != 0;
    }

    public final String[] a() {
        return this.d;
    }

    public final String[] b() {
        return this.e;
    }

    public final a c() {
        return this.a;
    }

    public final C6404Nl3 d() {
        return this.b;
    }

    public final String e() {
        String str = this.g;
        if (c() == a.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final List f() {
        String[] strArr = this.d;
        if (c() != a.MULTIFILE_CLASS) {
            strArr = null;
        }
        List listD = strArr != null ? AbstractC9648aK.d(strArr) : null;
        return listD != null ? listD : AbstractC10360bX0.m();
    }

    public final String[] g() {
        return this.f;
    }

    public final boolean i() {
        return h(this.h, 2);
    }

    public final boolean j() {
        return h(this.h, 64) && !h(this.h, 32);
    }

    public final boolean k() {
        return h(this.h, 16) && !h(this.h, 32);
    }

    public String toString() {
        return this.a + " version=" + this.b;
    }
}
