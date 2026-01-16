package ir.nasim;

import ir.nasim.InterfaceC24278yL5;
import ir.nasim.OL5;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public final class CL5 extends IL5 implements InterfaceC24278yL5, OL5, InterfaceC7106Qh3 {
    private final Class a;

    /* synthetic */ class a extends DB2 implements UA2 {
        public static final a a = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "isSynthetic";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(Member.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(y((Member) obj));
        }

        public final boolean y(Member member) {
            AbstractC13042fc3.i(member, "p0");
            return member.isSynthetic();
        }
    }

    /* synthetic */ class b extends DB2 implements UA2 {
        public static final b a = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "<init>";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(HL5.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final HL5 invoke(Constructor constructor) {
            AbstractC13042fc3.i(constructor, "p0");
            return new HL5(constructor);
        }
    }

    /* synthetic */ class c extends DB2 implements UA2 {
        public static final c a = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "isSynthetic";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(Member.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "isSynthetic()Z";
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(y((Member) obj));
        }

        public final boolean y(Member member) {
            AbstractC13042fc3.i(member, "p0");
            return member.isSynthetic();
        }
    }

    /* synthetic */ class d extends DB2 implements UA2 {
        public static final d a = new d();

        d() {
            super(1);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "<init>";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(KL5.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final KL5 invoke(Field field) {
            AbstractC13042fc3.i(field, "p0");
            return new KL5(field);
        }
    }

    static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        e() {
            super(1);
        }

        public final boolean a(Class cls) {
            String simpleName = cls.getSimpleName();
            AbstractC13042fc3.h(simpleName, "it.simpleName");
            return simpleName.length() == 0;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((Class) obj));
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        public static final f e = new f();

        f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C6432No4 invoke(Class cls) {
            String simpleName = cls.getSimpleName();
            if (!C6432No4.r(simpleName)) {
                simpleName = null;
            }
            if (simpleName == null) {
                return null;
            }
            return C6432No4.p(simpleName);
        }
    }

    static final class g extends AbstractC8614Ws3 implements UA2 {
        g() {
            super(1);
        }

        public final boolean a(Method method) {
            if (method.isSynthetic()) {
                return false;
            }
            if (CL5.this.v()) {
                CL5 cl5 = CL5.this;
                AbstractC13042fc3.h(method, "method");
                if (cl5.a0(method)) {
                    return false;
                }
            }
            return true;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((Method) obj));
        }
    }

    /* synthetic */ class h extends DB2 implements UA2 {
        public static final h a = new h();

        h() {
            super(1);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "<init>";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(NL5.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final NL5 invoke(Method method) {
            AbstractC13042fc3.i(method, "p0");
            return new NL5(method);
        }
    }

    public CL5(Class cls) {
        AbstractC13042fc3.i(cls, "klass");
        this.a = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a0(Method method) {
        String name = method.getName();
        if (AbstractC13042fc3.d(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            AbstractC13042fc3.h(parameterTypes, "method.parameterTypes");
            return parameterTypes.length == 0;
        }
        if (AbstractC13042fc3.d(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    public Collection D() {
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public boolean E() {
        return InterfaceC24278yL5.a.c(this);
    }

    @Override // ir.nasim.OL5
    public int J() {
        return this.a.getModifiers();
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    public boolean L() {
        return this.a.isInterface();
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    public EnumC23477wz3 M() {
        return null;
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public C22502vL5 z(C9424Zw2 c9424Zw2) {
        return InterfaceC24278yL5.a.a(this, c9424Zw2);
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public List getAnnotations() {
        return InterfaceC24278yL5.a.b(this);
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public List k() throws SecurityException {
        Constructor<?>[] declaredConstructors = this.a.getDeclaredConstructors();
        AbstractC13042fc3.h(declaredConstructors, "klass.declaredConstructors");
        return AbstractC11342cq6.K(AbstractC11342cq6.C(AbstractC11342cq6.s(AbstractC10242bK.P(declaredConstructors), a.a), b.a));
    }

    @Override // ir.nasim.InterfaceC24278yL5
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public Class r() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public List x() {
        Field[] declaredFields = this.a.getDeclaredFields();
        AbstractC13042fc3.h(declaredFields, "klass.declaredFields");
        return AbstractC11342cq6.K(AbstractC11342cq6.C(AbstractC11342cq6.s(AbstractC10242bK.P(declaredFields), c.a), d.a));
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public List B() {
        Class<?>[] declaredClasses = this.a.getDeclaredClasses();
        AbstractC13042fc3.h(declaredClasses, "klass.declaredClasses");
        return AbstractC11342cq6.K(AbstractC11342cq6.E(AbstractC11342cq6.s(AbstractC10242bK.P(declaredClasses), e.e), f.e));
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public List C() throws SecurityException {
        Method[] declaredMethods = this.a.getDeclaredMethods();
        AbstractC13042fc3.h(declaredMethods, "klass.declaredMethods");
        return AbstractC11342cq6.K(AbstractC11342cq6.C(AbstractC11342cq6.r(AbstractC10242bK.P(declaredMethods), new g()), h.a));
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public CL5 j() {
        Class<?> declaringClass = this.a.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new CL5(declaringClass);
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    public Collection b() {
        Class cls;
        cls = Object.class;
        if (AbstractC13042fc3.d(this.a, cls)) {
            return AbstractC10360bX0.m();
        }
        C15872kJ6 c15872kJ6 = new C15872kJ6(2);
        Object genericSuperclass = this.a.getGenericSuperclass();
        c15872kJ6.a(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.a.getGenericInterfaces();
        AbstractC13042fc3.h(genericInterfaces, "klass.genericInterfaces");
        c15872kJ6.b(genericInterfaces);
        List listP = AbstractC10360bX0.p(c15872kJ6.d(new Type[c15872kJ6.c()]));
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listP, 10));
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            arrayList.add(new GL5((Type) it.next()));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    public C9424Zw2 e() {
        C9424Zw2 c9424Zw2B = AbstractC21912uL5.b(this.a).b();
        AbstractC13042fc3.h(c9424Zw2B, "klass.classId.asSingleFqName()");
        return c9424Zw2B;
    }

    public boolean equals(Object obj) {
        return (obj instanceof CL5) && AbstractC13042fc3.d(this.a, ((CL5) obj).a);
    }

    @Override // ir.nasim.InterfaceC22125ui3
    public C6432No4 getName() {
        C6432No4 c6432No4P = C6432No4.p(this.a.getSimpleName());
        AbstractC13042fc3.h(c6432No4P, "identifier(klass.simpleName)");
        return c6432No4P;
    }

    @Override // ir.nasim.InterfaceC7820Ti3
    public List getTypeParameters() {
        TypeVariable[] typeParameters = this.a.getTypeParameters();
        AbstractC13042fc3.h(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable typeVariable : typeParameters) {
            arrayList.add(new SL5(typeVariable));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC21535ti3
    public GY7 getVisibility() {
        return OL5.a.a(this);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // ir.nasim.InterfaceC21535ti3
    public boolean i() {
        return OL5.a.d(this);
    }

    @Override // ir.nasim.InterfaceC21535ti3
    public boolean isAbstract() {
        return OL5.a.b(this);
    }

    @Override // ir.nasim.InterfaceC21535ti3
    public boolean isFinal() {
        return OL5.a.c(this);
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    public Collection l() {
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    public boolean n() {
        return this.a.isAnnotation();
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    public boolean p() {
        return false;
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    public boolean q() {
        return false;
    }

    public String toString() {
        return CL5.class.getName() + ": " + this.a;
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    public boolean v() {
        return this.a.isEnum();
    }

    @Override // ir.nasim.InterfaceC7106Qh3
    public boolean y() {
        return false;
    }
}
