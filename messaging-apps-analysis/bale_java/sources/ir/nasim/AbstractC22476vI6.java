package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.vI6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC22476vI6 {
    public static final a a = new a(null);
    private static final List b;
    private static final List c;
    private static final List d;
    private static final Map e;
    private static final Map f;
    private static final Set g;
    private static final Set h;
    private static final a.C1661a i;
    private static final Map j;
    private static final Map k;
    private static final List l;
    private static final Map m;

    /* renamed from: ir.nasim.vI6$a */
    public static final class a {

        /* renamed from: ir.nasim.vI6$a$a, reason: collision with other inner class name */
        public static final class C1661a {
            private final C6432No4 a;
            private final String b;

            public C1661a(C6432No4 c6432No4, String str) {
                AbstractC13042fc3.i(c6432No4, "name");
                AbstractC13042fc3.i(str, "signature");
                this.a = c6432No4;
                this.b = str;
            }

            public final C6432No4 a() {
                return this.a;
            }

            public final String b() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C1661a)) {
                    return false;
                }
                C1661a c1661a = (C1661a) obj;
                return AbstractC13042fc3.d(this.a, c1661a.a) && AbstractC13042fc3.d(this.b, c1661a.b);
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public String toString() {
                return "NameAndSignature(name=" + this.a + ", signature=" + this.b + ')';
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C1661a k(String str, String str2, String str3, String str4) {
            C6432No4 c6432No4P = C6432No4.p(str2);
            AbstractC13042fc3.h(c6432No4P, "identifier(name)");
            return new C1661a(c6432No4P, C17582nC6.a.k(str, str2 + '(' + str3 + ')' + str4));
        }

        public final List b() {
            return AbstractC22476vI6.c;
        }

        public final Set c() {
            return AbstractC22476vI6.g;
        }

        public final Set d() {
            return AbstractC22476vI6.h;
        }

        public final Map e() {
            return AbstractC22476vI6.m;
        }

        public final List f() {
            return AbstractC22476vI6.l;
        }

        public final C1661a g() {
            return AbstractC22476vI6.i;
        }

        public final Map h() {
            return AbstractC22476vI6.f;
        }

        public final Map i() {
            return AbstractC22476vI6.k;
        }

        public final b j(String str) {
            AbstractC13042fc3.i(str, "builtinSignature");
            return b().contains(str) ? b.ONE_COLLECTION_PARAMETER : ((c) AbstractC20051rO3.l(h(), str)) == c.b ? b.OBJECT_PARAMETER_GENERIC : b.OBJECT_PARAMETER_NON_GENERIC;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.vI6$b */
    public enum b {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);

        private final String a;
        private final boolean b;

        b(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] bVarArrValuesCustom = values();
            b[] bVarArr = new b[bVarArrValuesCustom.length];
            System.arraycopy(bVarArrValuesCustom, 0, bVarArr, 0, bVarArrValuesCustom.length);
            return bVarArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.vI6$c */
    public static final class c {
        public static final c b;
        public static final c c;
        public static final c d;
        public static final c e;
        private static final /* synthetic */ c[] f;
        private final Object a;

        /* renamed from: ir.nasim.vI6$c$a */
        static final class a extends c {
            /* JADX WARN: Illegal instructions before constructor call */
            a(String str, int i) {
                ED1 ed1 = null;
                super(str, i, ed1, ed1);
            }
        }

        static {
            c cVar = new c("NULL", 0, null);
            b = cVar;
            c cVar2 = new c("INDEX", 1, -1);
            c = cVar2;
            c cVar3 = new c("FALSE", 2, Boolean.FALSE);
            d = cVar3;
            a aVar = new a("MAP_GET_OR_DEFAULT", 3);
            e = aVar;
            f = new c[]{cVar, cVar2, cVar3, aVar};
        }

        public /* synthetic */ c(String str, int i, Object obj, ED1 ed1) {
            this(str, i, obj);
        }

        public static c valueOf(String str) {
            AbstractC13042fc3.i(str, "value");
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            c[] cVarArr = f;
            c[] cVarArr2 = new c[cVarArr.length];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, cVarArr.length);
            return cVarArr2;
        }

        private c(String str, int i, Object obj) {
            this.a = obj;
        }
    }

    static {
        Set<String> setI = AbstractC4597Fu6.i("containsAll", "removeAll", "retainAll");
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(setI, 10));
        for (String str : setI) {
            a aVar = a;
            String strQ = EnumC7376Rl3.BOOLEAN.q();
            AbstractC13042fc3.h(strQ, "BOOLEAN.desc");
            arrayList.add(aVar.k("java/util/Collection", str, "Ljava/util/Collection;", strQ));
        }
        b = arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((a.C1661a) it.next()).b());
        }
        c = arrayList3;
        List list = b;
        ArrayList arrayList4 = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((a.C1661a) it2.next()).a().h());
        }
        d = arrayList4;
        C17582nC6 c17582nC6 = C17582nC6.a;
        a aVar2 = a;
        String strI = c17582nC6.i("Collection");
        EnumC7376Rl3 enumC7376Rl3 = EnumC7376Rl3.BOOLEAN;
        String strQ2 = enumC7376Rl3.q();
        AbstractC13042fc3.h(strQ2, "BOOLEAN.desc");
        a.C1661a c1661aK = aVar2.k(strI, "contains", "Ljava/lang/Object;", strQ2);
        c cVar = c.d;
        XV4 xv4A = AbstractC4616Fw7.a(c1661aK, cVar);
        String strI2 = c17582nC6.i("Collection");
        String strQ3 = enumC7376Rl3.q();
        AbstractC13042fc3.h(strQ3, "BOOLEAN.desc");
        XV4 xv4A2 = AbstractC4616Fw7.a(aVar2.k(strI2, "remove", "Ljava/lang/Object;", strQ3), cVar);
        String strI3 = c17582nC6.i("Map");
        String strQ4 = enumC7376Rl3.q();
        AbstractC13042fc3.h(strQ4, "BOOLEAN.desc");
        XV4 xv4A3 = AbstractC4616Fw7.a(aVar2.k(strI3, "containsKey", "Ljava/lang/Object;", strQ4), cVar);
        String strI4 = c17582nC6.i("Map");
        String strQ5 = enumC7376Rl3.q();
        AbstractC13042fc3.h(strQ5, "BOOLEAN.desc");
        XV4 xv4A4 = AbstractC4616Fw7.a(aVar2.k(strI4, "containsValue", "Ljava/lang/Object;", strQ5), cVar);
        String strI5 = c17582nC6.i("Map");
        String strQ6 = enumC7376Rl3.q();
        AbstractC13042fc3.h(strQ6, "BOOLEAN.desc");
        XV4 xv4A5 = AbstractC4616Fw7.a(aVar2.k(strI5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", strQ6), cVar);
        XV4 xv4A6 = AbstractC4616Fw7.a(aVar2.k(c17582nC6.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), c.e);
        a.C1661a c1661aK2 = aVar2.k(c17582nC6.i("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        c cVar2 = c.b;
        XV4 xv4A7 = AbstractC4616Fw7.a(c1661aK2, cVar2);
        XV4 xv4A8 = AbstractC4616Fw7.a(aVar2.k(c17582nC6.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), cVar2);
        String strI6 = c17582nC6.i("List");
        EnumC7376Rl3 enumC7376Rl32 = EnumC7376Rl3.INT;
        String strQ7 = enumC7376Rl32.q();
        AbstractC13042fc3.h(strQ7, "INT.desc");
        a.C1661a c1661aK3 = aVar2.k(strI6, "indexOf", "Ljava/lang/Object;", strQ7);
        c cVar3 = c.c;
        XV4 xv4A9 = AbstractC4616Fw7.a(c1661aK3, cVar3);
        String strI7 = c17582nC6.i("List");
        String strQ8 = enumC7376Rl32.q();
        AbstractC13042fc3.h(strQ8, "INT.desc");
        Map mapN = AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, xv4A4, xv4A5, xv4A6, xv4A7, xv4A8, xv4A9, AbstractC4616Fw7.a(aVar2.k(strI7, "lastIndexOf", "Ljava/lang/Object;", strQ8), cVar3));
        e = mapN;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC19460qO3.f(mapN.size()));
        for (Map.Entry entry : mapN.entrySet()) {
            linkedHashMap.put(((a.C1661a) entry.getKey()).b(), entry.getValue());
        }
        f = linkedHashMap;
        Set setL = AbstractC4846Gu6.l(e.keySet(), b);
        ArrayList arrayList5 = new ArrayList(AbstractC10976cX0.x(setL, 10));
        Iterator it3 = setL.iterator();
        while (it3.hasNext()) {
            arrayList5.add(((a.C1661a) it3.next()).a());
        }
        g = AbstractC15401jX0.r1(arrayList5);
        ArrayList arrayList6 = new ArrayList(AbstractC10976cX0.x(setL, 10));
        Iterator it4 = setL.iterator();
        while (it4.hasNext()) {
            arrayList6.add(((a.C1661a) it4.next()).b());
        }
        h = AbstractC15401jX0.r1(arrayList6);
        a aVar3 = a;
        EnumC7376Rl3 enumC7376Rl33 = EnumC7376Rl3.INT;
        String strQ9 = enumC7376Rl33.q();
        AbstractC13042fc3.h(strQ9, "INT.desc");
        i = aVar3.k("java/util/List", "removeAt", strQ9, "Ljava/lang/Object;");
        C17582nC6 c17582nC62 = C17582nC6.a;
        String strH = c17582nC62.h("Number");
        String strQ10 = EnumC7376Rl3.BYTE.q();
        AbstractC13042fc3.h(strQ10, "BYTE.desc");
        XV4 xv4A10 = AbstractC4616Fw7.a(aVar3.k(strH, "toByte", "", strQ10), C6432No4.p("byteValue"));
        String strH2 = c17582nC62.h("Number");
        String strQ11 = EnumC7376Rl3.SHORT.q();
        AbstractC13042fc3.h(strQ11, "SHORT.desc");
        XV4 xv4A11 = AbstractC4616Fw7.a(aVar3.k(strH2, "toShort", "", strQ11), C6432No4.p("shortValue"));
        String strH3 = c17582nC62.h("Number");
        String strQ12 = enumC7376Rl33.q();
        AbstractC13042fc3.h(strQ12, "INT.desc");
        XV4 xv4A12 = AbstractC4616Fw7.a(aVar3.k(strH3, "toInt", "", strQ12), C6432No4.p("intValue"));
        String strH4 = c17582nC62.h("Number");
        String strQ13 = EnumC7376Rl3.LONG.q();
        AbstractC13042fc3.h(strQ13, "LONG.desc");
        XV4 xv4A13 = AbstractC4616Fw7.a(aVar3.k(strH4, "toLong", "", strQ13), C6432No4.p("longValue"));
        String strH5 = c17582nC62.h("Number");
        String strQ14 = EnumC7376Rl3.FLOAT.q();
        AbstractC13042fc3.h(strQ14, "FLOAT.desc");
        XV4 xv4A14 = AbstractC4616Fw7.a(aVar3.k(strH5, "toFloat", "", strQ14), C6432No4.p("floatValue"));
        String strH6 = c17582nC62.h("Number");
        String strQ15 = EnumC7376Rl3.DOUBLE.q();
        AbstractC13042fc3.h(strQ15, "DOUBLE.desc");
        XV4 xv4A15 = AbstractC4616Fw7.a(aVar3.k(strH6, "toDouble", "", strQ15), C6432No4.p("doubleValue"));
        XV4 xv4A16 = AbstractC4616Fw7.a(aVar3.g(), C6432No4.p("remove"));
        String strH7 = c17582nC62.h("CharSequence");
        String strQ16 = enumC7376Rl33.q();
        AbstractC13042fc3.h(strQ16, "INT.desc");
        String strQ17 = EnumC7376Rl3.CHAR.q();
        AbstractC13042fc3.h(strQ17, "CHAR.desc");
        Map mapN2 = AbstractC20051rO3.n(xv4A10, xv4A11, xv4A12, xv4A13, xv4A14, xv4A15, xv4A16, AbstractC4616Fw7.a(aVar3.k(strH7, "get", strQ16, strQ17), C6432No4.p("charAt")));
        j = mapN2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(AbstractC19460qO3.f(mapN2.size()));
        for (Map.Entry entry2 : mapN2.entrySet()) {
            linkedHashMap2.put(((a.C1661a) entry2.getKey()).b(), entry2.getValue());
        }
        k = linkedHashMap2;
        Set setKeySet = j.keySet();
        ArrayList arrayList7 = new ArrayList(AbstractC10976cX0.x(setKeySet, 10));
        Iterator it5 = setKeySet.iterator();
        while (it5.hasNext()) {
            arrayList7.add(((a.C1661a) it5.next()).a());
        }
        l = arrayList7;
        Set<Map.Entry> setEntrySet = j.entrySet();
        ArrayList<XV4> arrayList8 = new ArrayList(AbstractC10976cX0.x(setEntrySet, 10));
        for (Map.Entry entry3 : setEntrySet) {
            arrayList8.add(new XV4(((a.C1661a) entry3.getKey()).a(), entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (XV4 xv4 : arrayList8) {
            C6432No4 c6432No4 = (C6432No4) xv4.f();
            Object arrayList9 = linkedHashMap3.get(c6432No4);
            if (arrayList9 == null) {
                arrayList9 = new ArrayList();
                linkedHashMap3.put(c6432No4, arrayList9);
            }
            ((List) arrayList9).add((C6432No4) xv4.e());
        }
        m = linkedHashMap3;
    }
}
