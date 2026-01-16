package ir.nasim;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.lM5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C16489lM5 implements InterfaceC6537Nx7 {
    private final C20806se1 a;
    private final InterfaceC3801Ck2 b;
    private final C8469Wc2 c;
    private final C12513ek3 d;
    private final List e;

    /* renamed from: ir.nasim.lM5$a */
    class a extends c {
        final /* synthetic */ boolean f;
        final /* synthetic */ Method g;
        final /* synthetic */ boolean h;
        final /* synthetic */ AbstractC6277Mx7 i;
        final /* synthetic */ KS2 j;
        final /* synthetic */ TypeToken k;
        final /* synthetic */ boolean l;
        final /* synthetic */ boolean m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Field field, boolean z, boolean z2, boolean z3, Method method, boolean z4, AbstractC6277Mx7 abstractC6277Mx7, KS2 ks2, TypeToken typeToken, boolean z5, boolean z6) {
            super(str, field, z, z2);
            this.f = z3;
            this.g = method;
            this.h = z4;
            this.i = abstractC6277Mx7;
            this.j = ks2;
            this.k = typeToken;
            this.l = z5;
            this.m = z6;
        }

        @Override // ir.nasim.C16489lM5.c
        void a(C12523el3 c12523el3, int i, Object[] objArr) {
            Object objB = this.i.b(c12523el3);
            if (objB != null || !this.l) {
                objArr[i] = objB;
                return;
            }
            throw new JsonParseException("null is not allowed as value for record component '" + this.c + "' of primitive type; at path " + c12523el3.A());
        }

        @Override // ir.nasim.C16489lM5.c
        void b(C12523el3 c12523el3, Object obj) throws IllegalAccessException, IllegalArgumentException {
            Object objB = this.i.b(c12523el3);
            if (objB == null && this.l) {
                return;
            }
            if (this.f) {
                C16489lM5.c(obj, this.b);
            } else if (this.m) {
                throw new JsonIOException("Cannot set value of 'static final' " + AbstractC14107hM5.g(this.b, false));
            }
            this.b.set(obj, objB);
        }

        @Override // ir.nasim.C16489lM5.c
        void c(C22155ul3 c22155ul3, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Object objInvoke;
            if (this.d) {
                if (this.f) {
                    Method method = this.g;
                    if (method == null) {
                        C16489lM5.c(obj, this.b);
                    } else {
                        C16489lM5.c(obj, method);
                    }
                }
                Method method2 = this.g;
                if (method2 != null) {
                    try {
                        objInvoke = method2.invoke(obj, null);
                    } catch (InvocationTargetException e) {
                        throw new JsonIOException("Accessor " + AbstractC14107hM5.g(this.g, false) + " threw exception", e.getCause());
                    }
                } else {
                    objInvoke = this.b.get(obj);
                }
                if (objInvoke == obj) {
                    return;
                }
                c22155ul3.p(this.a);
                (this.h ? this.i : new C6776Ox7(this.j, this.i, this.k.d())).d(c22155ul3, objInvoke);
            }
        }
    }

    /* renamed from: ir.nasim.lM5$b */
    public static abstract class b extends AbstractC6277Mx7 {
        final Map a;

        b(Map map) {
            this.a = map;
        }

        @Override // ir.nasim.AbstractC6277Mx7
        public Object b(C12523el3 c12523el3) throws IOException {
            if (c12523el3.G() == EnumC16723ll3.NULL) {
                c12523el3.u();
                return null;
            }
            Object objE = e();
            try {
                c12523el3.B();
                while (c12523el3.l()) {
                    c cVar = (c) this.a.get(c12523el3.n0());
                    if (cVar == null || !cVar.e) {
                        c12523el3.R();
                    } else {
                        g(objE, c12523el3, cVar);
                    }
                }
                c12523el3.F();
                return f(objE);
            } catch (IllegalAccessException e) {
                throw AbstractC14107hM5.e(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // ir.nasim.AbstractC6277Mx7
        public void d(C22155ul3 c22155ul3, Object obj) throws IOException {
            if (obj == null) {
                c22155ul3.s();
                return;
            }
            c22155ul3.d();
            try {
                Iterator it = this.a.values().iterator();
                while (it.hasNext()) {
                    ((c) it.next()).c(c22155ul3, obj);
                }
                c22155ul3.j();
            } catch (IllegalAccessException e) {
                throw AbstractC14107hM5.e(e);
            }
        }

        abstract Object e();

        abstract Object f(Object obj);

        abstract void g(Object obj, C12523el3 c12523el3, c cVar);
    }

    /* renamed from: ir.nasim.lM5$c */
    static abstract class c {
        final String a;
        final Field b;
        final String c;
        final boolean d;
        final boolean e;

        protected c(String str, Field field, boolean z, boolean z2) {
            this.a = str;
            this.b = field;
            this.c = field.getName();
            this.d = z;
            this.e = z2;
        }

        abstract void a(C12523el3 c12523el3, int i, Object[] objArr);

        abstract void b(C12523el3 c12523el3, Object obj);

        abstract void c(C22155ul3 c22155ul3, Object obj);
    }

    /* renamed from: ir.nasim.lM5$e */
    private static final class e extends b {
        static final Map e = j();
        private final Constructor b;
        private final Object[] c;
        private final Map d;

        e(Class cls, Map map, boolean z) throws SecurityException {
            super(map);
            this.d = new HashMap();
            Constructor constructorI = AbstractC14107hM5.i(cls);
            this.b = constructorI;
            if (z) {
                C16489lM5.c(null, constructorI);
            } else {
                AbstractC14107hM5.l(constructorI);
            }
            String[] strArrJ = AbstractC14107hM5.j(cls);
            for (int i = 0; i < strArrJ.length; i++) {
                this.d.put(strArrJ[i], Integer.valueOf(i));
            }
            Class<?>[] parameterTypes = this.b.getParameterTypes();
            this.c = new Object[parameterTypes.length];
            for (int i2 = 0; i2 < parameterTypes.length; i2++) {
                this.c[i2] = e.get(parameterTypes[i2]);
            }
        }

        private static Map j() {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            return map;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.C16489lM5.b
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Object[] e() {
            return (Object[]) this.c.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.C16489lM5.b
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object f(Object[] objArr) {
            try {
                return this.b.newInstance(objArr);
            } catch (IllegalAccessException e2) {
                throw AbstractC14107hM5.e(e2);
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw new RuntimeException("Failed to invoke constructor '" + AbstractC14107hM5.c(this.b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e4) {
                e = e4;
                throw new RuntimeException("Failed to invoke constructor '" + AbstractC14107hM5.c(this.b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Failed to invoke constructor '" + AbstractC14107hM5.c(this.b) + "' with args " + Arrays.toString(objArr), e5.getCause());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ir.nasim.C16489lM5.b
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(Object[] objArr, C12523el3 c12523el3, c cVar) {
            Integer num = (Integer) this.d.get(cVar.c);
            if (num != null) {
                cVar.a(c12523el3, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + AbstractC14107hM5.c(this.b) + "' for field with name '" + cVar.c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public C16489lM5(C20806se1 c20806se1, InterfaceC3801Ck2 interfaceC3801Ck2, C8469Wc2 c8469Wc2, C12513ek3 c12513ek3, List list) {
        this.a = c20806se1;
        this.b = interfaceC3801Ck2;
        this.c = c8469Wc2;
        this.d = c12513ek3;
        this.e = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void c(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (AbstractC12289eM5.a(accessibleObject, obj)) {
            return;
        }
        throw new JsonIOException(AbstractC14107hM5.g(accessibleObject, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private c d(KS2 ks2, Field field, Method method, String str, TypeToken typeToken, boolean z, boolean z2, boolean z3) {
        boolean zA = AbstractC5511Jq5.a(typeToken.c());
        int modifiers = field.getModifiers();
        boolean z4 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        InterfaceC11901dk3 interfaceC11901dk3 = (InterfaceC11901dk3) field.getAnnotation(InterfaceC11901dk3.class);
        AbstractC6277Mx7 abstractC6277Mx7A = interfaceC11901dk3 != null ? this.d.a(this.a, ks2, typeToken, interfaceC11901dk3) : null;
        boolean z5 = abstractC6277Mx7A != null;
        if (abstractC6277Mx7A == null) {
            abstractC6277Mx7A = ks2.m(typeToken);
        }
        return new a(str, field, z, z2, z3, method, z5, abstractC6277Mx7A, ks2, typeToken, zA, z4);
    }

    private Map e(KS2 ks2, TypeToken typeToken, Class cls, boolean z, boolean z2) throws SecurityException {
        boolean z3;
        Method method;
        int i;
        int i2;
        boolean z4;
        C16489lM5 c16489lM5 = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        TypeToken typeTokenB = typeToken;
        boolean z5 = z;
        Class clsC = cls;
        while (clsC != Object.class) {
            Field[] declaredFields = clsC.getDeclaredFields();
            boolean z6 = true;
            boolean z7 = false;
            if (clsC != cls && declaredFields.length > 0) {
                EnumC11646dM5 enumC11646dM5B = AbstractC12289eM5.b(c16489lM5.e, clsC);
                if (enumC11646dM5B == EnumC11646dM5.BLOCK_ALL) {
                    throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + clsC + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
                z5 = enumC11646dM5B == EnumC11646dM5.BLOCK_INACCESSIBLE;
            }
            boolean z8 = z5;
            int length = declaredFields.length;
            int i3 = 0;
            while (i3 < length) {
                Field field = declaredFields[i3];
                boolean zG = c16489lM5.g(field, z6);
                boolean zG2 = c16489lM5.g(field, z7);
                if (zG || zG2) {
                    c cVar = null;
                    if (!z2) {
                        z3 = zG2;
                        method = null;
                    } else if (Modifier.isStatic(field.getModifiers())) {
                        method = null;
                        z3 = z7;
                    } else {
                        Method methodH = AbstractC14107hM5.h(clsC, field);
                        if (!z8) {
                            AbstractC14107hM5.l(methodH);
                        }
                        if (methodH.getAnnotation(InterfaceC23984xq6.class) != null && field.getAnnotation(InterfaceC23984xq6.class) == null) {
                            throw new JsonIOException("@SerializedName on " + AbstractC14107hM5.g(methodH, z7) + " is not supported");
                        }
                        z3 = zG2;
                        method = methodH;
                    }
                    if (!z8 && method == null) {
                        AbstractC14107hM5.l(field);
                    }
                    Type typeO = AbstractC10051b.o(typeTokenB.d(), clsC, field.getGenericType());
                    List listF = c16489lM5.f(field);
                    int size = listF.size();
                    int i4 = z7;
                    while (i4 < size) {
                        String str = (String) listF.get(i4);
                        boolean z9 = i4 != 0 ? z7 : zG;
                        int i5 = i4;
                        c cVar2 = cVar;
                        int i6 = size;
                        List list = listF;
                        Field field2 = field;
                        int i7 = i3;
                        int i8 = length;
                        boolean z10 = z7;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, d(ks2, field, method, str, TypeToken.b(typeO), z9, z3, z8)) : cVar2;
                        i4 = i5 + 1;
                        zG = z9;
                        i3 = i7;
                        size = i6;
                        listF = list;
                        field = field2;
                        length = i8;
                        z7 = z10;
                    }
                    c cVar3 = cVar;
                    Field field3 = field;
                    i = i3;
                    i2 = length;
                    z4 = z7;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + cVar3.a + "'; conflict is caused by fields " + AbstractC14107hM5.f(cVar3.b) + " and " + AbstractC14107hM5.f(field3));
                    }
                } else {
                    i = i3;
                    i2 = length;
                    z4 = z7;
                }
                i3 = i + 1;
                z6 = true;
                c16489lM5 = this;
                length = i2;
                z7 = z4;
            }
            typeTokenB = TypeToken.b(AbstractC10051b.o(typeTokenB.d(), clsC, clsC.getGenericSuperclass()));
            clsC = typeTokenB.c();
            c16489lM5 = this;
            z5 = z8;
        }
        return linkedHashMap;
    }

    private List f(Field field) {
        InterfaceC23984xq6 interfaceC23984xq6 = (InterfaceC23984xq6) field.getAnnotation(InterfaceC23984xq6.class);
        if (interfaceC23984xq6 == null) {
            return Collections.singletonList(this.b.a(field));
        }
        String strValue = interfaceC23984xq6.value();
        String[] strArrAlternate = interfaceC23984xq6.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        Collections.addAll(arrayList, strArrAlternate);
        return arrayList;
    }

    private boolean g(Field field, boolean z) {
        return (this.c.d(field.getType(), z) || this.c.h(field, z)) ? false : true;
    }

    @Override // ir.nasim.InterfaceC6537Nx7
    public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
        Class clsC = typeToken.c();
        if (!Object.class.isAssignableFrom(clsC)) {
            return null;
        }
        EnumC11646dM5 enumC11646dM5B = AbstractC12289eM5.b(this.e, clsC);
        if (enumC11646dM5B != EnumC11646dM5.BLOCK_ALL) {
            boolean z = enumC11646dM5B == EnumC11646dM5.BLOCK_INACCESSIBLE;
            return AbstractC14107hM5.k(clsC) ? new e(clsC, e(ks2, typeToken, clsC, z, true), z) : new d(this.a.b(typeToken), e(ks2, typeToken, clsC, z, false));
        }
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + clsC + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    /* renamed from: ir.nasim.lM5$d */
    private static final class d extends b {
        private final InterfaceC17616nG4 b;

        d(InterfaceC17616nG4 interfaceC17616nG4, Map map) {
            super(map);
            this.b = interfaceC17616nG4;
        }

        @Override // ir.nasim.C16489lM5.b
        Object e() {
            return this.b.a();
        }

        @Override // ir.nasim.C16489lM5.b
        void g(Object obj, C12523el3 c12523el3, c cVar) {
            cVar.b(c12523el3, obj);
        }

        @Override // ir.nasim.C16489lM5.b
        Object f(Object obj) {
            return obj;
        }
    }
}
