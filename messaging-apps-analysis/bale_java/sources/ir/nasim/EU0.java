package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public final class EU0 implements InterfaceC11299cm3, InterfaceC17738nU0 {
    public static final a b = new a(null);
    private static final Map c;
    private static final HashMap d;
    private static final HashMap e;
    private static final HashMap f;
    private static final Map g;
    private final Class a;

    public static final class a {
        private a() {
        }

        public final String a(Class cls) {
            String str;
            AbstractC13042fc3.i(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str3 = (String) EU0.f.get(cls.getName());
                return str3 == null ? cls.getCanonicalName() : str3;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) EU0.f.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 == null ? "kotlin.Array" : str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
        
            if (r2 == null) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String b(java.lang.Class r7) {
            /*
                r6 = this;
                java.lang.String r0 = "jClass"
                ir.nasim.AbstractC13042fc3.i(r7, r0)
                boolean r0 = r7.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto Le
                goto Lb3
            Le:
                boolean r0 = r7.isLocalClass()
                if (r0 == 0) goto L6a
                java.lang.String r0 = r7.getSimpleName()
                java.lang.reflect.Method r2 = r7.getEnclosingMethod()
                r3 = 2
                r4 = 36
                if (r2 == 0) goto L41
                ir.nasim.AbstractC13042fc3.f(r0)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r2 = r2.getName()
                r5.append(r2)
                r5.append(r4)
                java.lang.String r2 = r5.toString()
                java.lang.String r2 = ir.nasim.AbstractC14836iZ6.Z0(r0, r2, r1, r3, r1)
                if (r2 != 0) goto L3e
                goto L41
            L3e:
                r1 = r2
                goto Lb3
            L41:
                java.lang.reflect.Constructor r7 = r7.getEnclosingConstructor()
                if (r7 == 0) goto L62
                ir.nasim.AbstractC13042fc3.f(r0)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r7 = r7.getName()
                r2.append(r7)
                r2.append(r4)
                java.lang.String r7 = r2.toString()
                java.lang.String r1 = ir.nasim.AbstractC14836iZ6.Z0(r0, r7, r1, r3, r1)
                goto Lb3
            L62:
                ir.nasim.AbstractC13042fc3.f(r0)
                java.lang.String r1 = ir.nasim.AbstractC14836iZ6.Y0(r0, r4, r1, r3, r1)
                goto Lb3
            L6a:
                boolean r0 = r7.isArray()
                if (r0 == 0) goto L9e
                java.lang.Class r7 = r7.getComponentType()
                boolean r0 = r7.isPrimitive()
                java.lang.String r2 = "Array"
                if (r0 == 0) goto L9b
                java.util.Map r0 = ir.nasim.EU0.j()
                java.lang.String r7 = r7.getName()
                java.lang.Object r7 = r0.get(r7)
                java.lang.String r7 = (java.lang.String) r7
                if (r7 == 0) goto L9b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r7)
                r0.append(r2)
                java.lang.String r1 = r0.toString()
            L9b:
                if (r1 != 0) goto Lb3
                goto L3e
            L9e:
                java.util.Map r0 = ir.nasim.EU0.j()
                java.lang.String r1 = r7.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto Lb3
                java.lang.String r1 = r7.getSimpleName()
            Lb3:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EU0.a.b(java.lang.Class):java.lang.String");
        }

        public final boolean c(Object obj, Class cls) {
            AbstractC13042fc3.i(cls, "jClass");
            Map map = EU0.c;
            AbstractC13042fc3.g(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return AbstractC19810qy7.o(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = AbstractC4762Gl3.c(AbstractC4762Gl3.e(cls));
            }
            return cls.isInstance(obj);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        List listP = AbstractC10360bX0.p(SA2.class, UA2.class, InterfaceC14603iB2.class, InterfaceC15796kB2.class, InterfaceC16978mB2.class, InterfaceC18160oB2.class, InterfaceC19342qB2.class, InterfaceC19933rB2.class, InterfaceC20542sB2.class, InterfaceC21145tB2.class, TA2.class, VA2.class, WA2.class, XA2.class, YA2.class, ZA2.class, InterfaceC9570aB2.class, InterfaceC10164bB2.class, InterfaceC10780cB2.class, InterfaceC11544dB2.class, InterfaceC12796fB2.class, InterfaceC13414gB2.class, InterfaceC14005hB2.class);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listP, 10));
        int i = 0;
        for (Object obj : listP) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            arrayList.add(AbstractC4616Fw7.a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        c = AbstractC20051rO3.w(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        d = map;
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        e = map2;
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        AbstractC13042fc3.h(collectionValues, "<get-values>(...)");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            AbstractC13042fc3.f(str);
            sb.append(AbstractC20762sZ6.c1(str, '.', null, 2, null));
            sb.append("CompanionObject");
            XV4 xv4A = AbstractC4616Fw7.a(sb.toString(), str + ".Companion");
            map3.put(xv4A.e(), xv4A.f());
        }
        for (Map.Entry entry : c.entrySet()) {
            map3.put(((Class) entry.getKey()).getName(), "kotlin.Function" + ((Number) entry.getValue()).intValue());
        }
        f = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC19460qO3.f(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), AbstractC20762sZ6.c1((String) entry2.getValue(), '.', null, 2, null));
        }
        g = linkedHashMap;
    }

    public EU0(Class cls) {
        AbstractC13042fc3.i(cls, "jClass");
        this.a = cls;
    }

    @Override // ir.nasim.InterfaceC17738nU0
    public Class e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof EU0) && AbstractC13042fc3.d(AbstractC4762Gl3.c(this), AbstractC4762Gl3.c((InterfaceC11299cm3) obj));
    }

    @Override // ir.nasim.InterfaceC11299cm3
    public int hashCode() {
        return AbstractC4762Gl3.c(this).hashCode();
    }

    @Override // ir.nasim.InterfaceC11299cm3
    public boolean k(Object obj) {
        return b.c(obj, e());
    }

    @Override // ir.nasim.InterfaceC11299cm3
    public String n() {
        return b.a(e());
    }

    @Override // ir.nasim.InterfaceC11299cm3
    public String p() {
        return b.b(e());
    }

    public String toString() {
        return e().toString() + " (Kotlin reflection is not available)";
    }
}
