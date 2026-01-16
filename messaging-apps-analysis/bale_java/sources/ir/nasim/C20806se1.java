package ir.nasim;

import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* renamed from: ir.nasim.se1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C20806se1 {
    private final Map a;
    private final boolean b;
    private final List c;

    /* renamed from: ir.nasim.se1$a */
    class a implements InterfaceC17616nG4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            return new TreeSet();
        }
    }

    /* renamed from: ir.nasim.se1$b */
    class b implements InterfaceC17616nG4 {
        b() {
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            return new LinkedHashSet();
        }
    }

    /* renamed from: ir.nasim.se1$c */
    class c implements InterfaceC17616nG4 {
        c() {
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            return new ArrayDeque();
        }
    }

    /* renamed from: ir.nasim.se1$d */
    class d implements InterfaceC17616nG4 {
        d() {
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            return new ArrayList();
        }
    }

    /* renamed from: ir.nasim.se1$e */
    class e implements InterfaceC17616nG4 {
        e() {
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            return new ConcurrentSkipListMap();
        }
    }

    /* renamed from: ir.nasim.se1$f */
    class f implements InterfaceC17616nG4 {
        f() {
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            return new ConcurrentHashMap();
        }
    }

    /* renamed from: ir.nasim.se1$g */
    class g implements InterfaceC17616nG4 {
        g() {
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            return new TreeMap();
        }
    }

    /* renamed from: ir.nasim.se1$h */
    class h implements InterfaceC17616nG4 {
        h() {
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            return new LinkedHashMap();
        }
    }

    /* renamed from: ir.nasim.se1$i */
    class i implements InterfaceC17616nG4 {
        i() {
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            return new C19343qB3();
        }
    }

    /* renamed from: ir.nasim.se1$j */
    class j implements InterfaceC17616nG4 {
        final /* synthetic */ Class a;

        j(Class cls) {
            this.a = cls;
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            try {
                return RB7.a.d(this.a);
            } catch (Exception e) {
                throw new RuntimeException("Unable to create instance of " + this.a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
            }
        }
    }

    /* renamed from: ir.nasim.se1$k */
    class k implements InterfaceC17616nG4 {
        final /* synthetic */ String a;

        k(String str) {
            this.a = str;
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            throw new JsonIOException(this.a);
        }
    }

    /* renamed from: ir.nasim.se1$l */
    class l implements InterfaceC17616nG4 {
        final /* synthetic */ String a;

        l(String str) {
            this.a = str;
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            throw new JsonIOException(this.a);
        }
    }

    /* renamed from: ir.nasim.se1$m */
    class m implements InterfaceC17616nG4 {
        final /* synthetic */ String a;

        m(String str) {
            this.a = str;
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            throw new JsonIOException(this.a);
        }
    }

    /* renamed from: ir.nasim.se1$n */
    class n implements InterfaceC17616nG4 {
        final /* synthetic */ Type a;

        n(Type type) {
            this.a = type;
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            Type type = this.a;
            if (!(type instanceof ParameterizedType)) {
                throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return EnumSet.noneOf((Class) type2);
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.a.toString());
        }
    }

    /* renamed from: ir.nasim.se1$o */
    class o implements InterfaceC17616nG4 {
        final /* synthetic */ Type a;

        o(Type type) {
            this.a = type;
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            Type type = this.a;
            if (!(type instanceof ParameterizedType)) {
                throw new JsonIOException("Invalid EnumMap type: " + this.a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return new EnumMap((Class) type2);
            }
            throw new JsonIOException("Invalid EnumMap type: " + this.a.toString());
        }
    }

    /* renamed from: ir.nasim.se1$p */
    class p implements InterfaceC17616nG4 {
        final /* synthetic */ String a;

        p(String str) {
            this.a = str;
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            throw new JsonIOException(this.a);
        }
    }

    /* renamed from: ir.nasim.se1$q */
    class q implements InterfaceC17616nG4 {
        final /* synthetic */ String a;

        q(String str) {
            this.a = str;
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            throw new JsonIOException(this.a);
        }
    }

    /* renamed from: ir.nasim.se1$r */
    class r implements InterfaceC17616nG4 {
        final /* synthetic */ Constructor a;

        r(Constructor constructor) {
            this.a = constructor;
        }

        @Override // ir.nasim.InterfaceC17616nG4
        public Object a() {
            try {
                return this.a.newInstance(null);
            } catch (IllegalAccessException e) {
                throw AbstractC14107hM5.e(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke constructor '" + AbstractC14107hM5.c(this.a) + "' with no args", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to invoke constructor '" + AbstractC14107hM5.c(this.a) + "' with no args", e3.getCause());
            }
        }
    }

    public C20806se1(Map map, boolean z, List list) {
        this.a = map;
        this.b = z;
        this.c = list;
    }

    static String a(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
    }

    private static InterfaceC17616nG4 c(Class cls, EnumC11646dM5 enumC11646dM5) throws NoSuchMethodException, SecurityException {
        String strM;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            EnumC11646dM5 enumC11646dM52 = EnumC11646dM5.ALLOW;
            if (enumC11646dM5 == enumC11646dM52 || (AbstractC12289eM5.a(declaredConstructor, null) && (enumC11646dM5 != EnumC11646dM5.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (enumC11646dM5 != enumC11646dM52 || (strM = AbstractC14107hM5.m(declaredConstructor)) == null) ? new r(declaredConstructor) : new q(strM);
            }
            return new p("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static InterfaceC17616nG4 d(Type type, Class cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new a() : Set.class.isAssignableFrom(cls) ? new b() : Queue.class.isAssignableFrom(cls) ? new c() : new d();
        }
        if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new e() : ConcurrentMap.class.isAssignableFrom(cls) ? new f() : SortedMap.class.isAssignableFrom(cls) ? new g() : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) ? new i() : new h();
        }
        return null;
    }

    private static InterfaceC17616nG4 e(Type type, Class cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new n(type);
        }
        if (cls == EnumMap.class) {
            return new o(type);
        }
        return null;
    }

    private InterfaceC17616nG4 f(Class cls) {
        if (this.b) {
            return new j(cls);
        }
        return new k("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public InterfaceC17616nG4 b(TypeToken typeToken) throws NoSuchMethodException, SecurityException {
        Type typeD = typeToken.d();
        Class clsC = typeToken.c();
        AbstractC18350oW3.a(this.a.get(typeD));
        AbstractC18350oW3.a(this.a.get(clsC));
        InterfaceC17616nG4 interfaceC17616nG4E = e(typeD, clsC);
        if (interfaceC17616nG4E != null) {
            return interfaceC17616nG4E;
        }
        EnumC11646dM5 enumC11646dM5B = AbstractC12289eM5.b(this.c, clsC);
        InterfaceC17616nG4 interfaceC17616nG4C = c(clsC, enumC11646dM5B);
        if (interfaceC17616nG4C != null) {
            return interfaceC17616nG4C;
        }
        InterfaceC17616nG4 interfaceC17616nG4D = d(typeD, clsC);
        if (interfaceC17616nG4D != null) {
            return interfaceC17616nG4D;
        }
        String strA = a(clsC);
        if (strA != null) {
            return new l(strA);
        }
        if (enumC11646dM5B == EnumC11646dM5.ALLOW) {
            return f(clsC);
        }
        return new m("Unable to create instance of " + clsC + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public String toString() {
        return this.a.toString();
    }
}
