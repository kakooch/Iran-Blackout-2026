package ir.nasim;

import ir.nasim.InterfaceC18740pA0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.qA0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19331qA0 implements InterfaceC18740pA0 {
    public static final d e = new d(null);
    private final List a;
    private final Member b;
    private final Type c;
    private final Class d;

    /* renamed from: ir.nasim.qA0$a */
    public static final class a extends AbstractC19331qA0 implements InterfaceC22142uk0 {
        private final Object f;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(Constructor constructor, Object obj) {
            Object[] objArr;
            AbstractC13042fc3.i(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            AbstractC13042fc3.h(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            AbstractC13042fc3.h(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length <= 2) {
                objArr = new Type[0];
            } else {
                Object[] objArrS = AbstractC9648aK.s(genericParameterTypes, 1, genericParameterTypes.length - 1);
                objArr = objArrS;
                if (objArrS == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            super(constructor, declaringClass, null, (Type[]) objArr, null);
            this.f = obj;
        }

        @Override // ir.nasim.InterfaceC18740pA0
        public Object call(Object[] objArr) {
            AbstractC13042fc3.i(objArr, "args");
            c(objArr);
            Constructor constructor = (Constructor) b();
            C15872kJ6 c15872kJ6 = new C15872kJ6(3);
            c15872kJ6.a(this.f);
            c15872kJ6.b(objArr);
            c15872kJ6.a(null);
            return constructor.newInstance(c15872kJ6.d(new Object[c15872kJ6.c()]));
        }
    }

    /* renamed from: ir.nasim.qA0$b */
    public static final class b extends AbstractC19331qA0 {
        /* JADX WARN: Illegal instructions before constructor call */
        public b(Constructor constructor) {
            Object[] objArr;
            AbstractC13042fc3.i(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            AbstractC13042fc3.h(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            AbstractC13042fc3.h(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length <= 1) {
                objArr = new Type[0];
            } else {
                Object[] objArrS = AbstractC9648aK.s(genericParameterTypes, 0, genericParameterTypes.length - 1);
                objArr = objArrS;
                if (objArrS == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            super(constructor, declaringClass, null, (Type[]) objArr, null);
        }

        @Override // ir.nasim.InterfaceC18740pA0
        public Object call(Object[] objArr) {
            AbstractC13042fc3.i(objArr, "args");
            c(objArr);
            Constructor constructor = (Constructor) b();
            C15872kJ6 c15872kJ6 = new C15872kJ6(2);
            c15872kJ6.b(objArr);
            c15872kJ6.a(null);
            return constructor.newInstance(c15872kJ6.d(new Object[c15872kJ6.c()]));
        }
    }

    /* renamed from: ir.nasim.qA0$c */
    public static final class c extends AbstractC19331qA0 implements InterfaceC22142uk0 {
        private final Object f;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(Constructor constructor, Object obj) {
            AbstractC13042fc3.i(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            AbstractC13042fc3.h(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            AbstractC13042fc3.h(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, null, genericParameterTypes, null);
            this.f = obj;
        }

        @Override // ir.nasim.InterfaceC18740pA0
        public Object call(Object[] objArr) {
            AbstractC13042fc3.i(objArr, "args");
            c(objArr);
            Constructor constructor = (Constructor) b();
            C15872kJ6 c15872kJ6 = new C15872kJ6(2);
            c15872kJ6.a(this.f);
            c15872kJ6.b(objArr);
            return constructor.newInstance(c15872kJ6.d(new Object[c15872kJ6.c()]));
        }
    }

    /* renamed from: ir.nasim.qA0$d */
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.qA0$e */
    public static final class e extends AbstractC19331qA0 {
        /* JADX WARN: Illegal instructions before constructor call */
        public e(Constructor constructor) {
            AbstractC13042fc3.i(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            AbstractC13042fc3.h(declaringClass, "constructor.declaringClass");
            Class declaringClass2 = constructor.getDeclaringClass();
            AbstractC13042fc3.h(declaringClass2, "klass");
            Class<?> declaringClass3 = declaringClass2.getDeclaringClass();
            Class<?> cls = (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) ? null : declaringClass3;
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            AbstractC13042fc3.h(genericParameterTypes, "constructor.genericParameterTypes");
            super(constructor, declaringClass, cls, genericParameterTypes, null);
        }

        @Override // ir.nasim.InterfaceC18740pA0
        public Object call(Object[] objArr) {
            AbstractC13042fc3.i(objArr, "args");
            c(objArr);
            return ((Constructor) b()).newInstance(Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* renamed from: ir.nasim.qA0$f */
    public static abstract class f extends AbstractC19331qA0 {

        /* renamed from: ir.nasim.qA0$f$a */
        public static final class a extends f implements InterfaceC22142uk0 {
            private final Object f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, Object obj) {
                super(field, false, null);
                AbstractC13042fc3.i(field, "field");
                this.f = obj;
            }

            @Override // ir.nasim.AbstractC19331qA0.f, ir.nasim.InterfaceC18740pA0
            public Object call(Object[] objArr) {
                AbstractC13042fc3.i(objArr, "args");
                c(objArr);
                return ((Field) b()).get(this.f);
            }
        }

        /* renamed from: ir.nasim.qA0$f$b */
        public static final class b extends f implements InterfaceC22142uk0 {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field) {
                super(field, false, null);
                AbstractC13042fc3.i(field, "field");
            }
        }

        /* renamed from: ir.nasim.qA0$f$c */
        public static final class c extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field) {
                super(field, true, null);
                AbstractC13042fc3.i(field, "field");
            }
        }

        /* renamed from: ir.nasim.qA0$f$d */
        public static final class d extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field) {
                super(field, true, null);
                AbstractC13042fc3.i(field, "field");
            }

            @Override // ir.nasim.AbstractC19331qA0
            public void c(Object[] objArr) {
                AbstractC13042fc3.i(objArr, "args");
                super.c(objArr);
                d(AbstractC10242bK.e0(objArr));
            }
        }

        /* renamed from: ir.nasim.qA0$f$e */
        public static final class e extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Field field) {
                super(field, false, null);
                AbstractC13042fc3.i(field, "field");
            }
        }

        public /* synthetic */ f(Field field, boolean z, ED1 ed1) {
            this(field, z);
        }

        @Override // ir.nasim.InterfaceC18740pA0
        public Object call(Object[] objArr) {
            AbstractC13042fc3.i(objArr, "args");
            c(objArr);
            return ((Field) b()).get(e() != null ? AbstractC10242bK.b0(objArr) : null);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private f(Field field, boolean z) {
            Type genericType = field.getGenericType();
            AbstractC13042fc3.h(genericType, "field.genericType");
            super(field, genericType, z ? field.getDeclaringClass() : null, new Type[0], null);
        }
    }

    /* renamed from: ir.nasim.qA0$g */
    public static abstract class g extends AbstractC19331qA0 {
        private final boolean f;

        /* renamed from: ir.nasim.qA0$g$a */
        public static final class a extends g implements InterfaceC22142uk0 {
            private final Object g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Field field, boolean z, Object obj) {
                super(field, z, false, null);
                AbstractC13042fc3.i(field, "field");
                this.g = obj;
            }

            @Override // ir.nasim.AbstractC19331qA0.g, ir.nasim.InterfaceC18740pA0
            public Object call(Object[] objArr) throws IllegalAccessException, IllegalArgumentException {
                AbstractC13042fc3.i(objArr, "args");
                c(objArr);
                ((Field) b()).set(this.g, AbstractC10242bK.b0(objArr));
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.qA0$g$b */
        public static final class b extends g implements InterfaceC22142uk0 {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Field field, boolean z) {
                super(field, z, false, null);
                AbstractC13042fc3.i(field, "field");
            }

            @Override // ir.nasim.AbstractC19331qA0.g, ir.nasim.InterfaceC18740pA0
            public Object call(Object[] objArr) throws IllegalAccessException, IllegalArgumentException {
                AbstractC13042fc3.i(objArr, "args");
                c(objArr);
                ((Field) b()).set(null, AbstractC10242bK.E0(objArr));
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.qA0$g$c */
        public static final class c extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(Field field, boolean z) {
                super(field, z, true, null);
                AbstractC13042fc3.i(field, "field");
            }
        }

        /* renamed from: ir.nasim.qA0$g$d */
        public static final class d extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Field field, boolean z) {
                super(field, z, true, null);
                AbstractC13042fc3.i(field, "field");
            }

            @Override // ir.nasim.AbstractC19331qA0.g, ir.nasim.AbstractC19331qA0
            public void c(Object[] objArr) {
                AbstractC13042fc3.i(objArr, "args");
                super.c(objArr);
                d(AbstractC10242bK.e0(objArr));
            }
        }

        /* renamed from: ir.nasim.qA0$g$e */
        public static final class e extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Field field, boolean z) {
                super(field, z, false, null);
                AbstractC13042fc3.i(field, "field");
            }
        }

        public /* synthetic */ g(Field field, boolean z, boolean z2, ED1 ed1) {
            this(field, z, z2);
        }

        @Override // ir.nasim.AbstractC19331qA0
        public void c(Object[] objArr) {
            AbstractC13042fc3.i(objArr, "args");
            super.c(objArr);
            if (this.f && AbstractC10242bK.E0(objArr) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }

        @Override // ir.nasim.InterfaceC18740pA0
        public Object call(Object[] objArr) throws IllegalAccessException, IllegalArgumentException {
            AbstractC13042fc3.i(objArr, "args");
            c(objArr);
            ((Field) b()).set(e() != null ? AbstractC10242bK.b0(objArr) : null, AbstractC10242bK.E0(objArr));
            return C19938rB7.a;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private g(Field field, boolean z, boolean z2) {
            Class cls = Void.TYPE;
            AbstractC13042fc3.h(cls, "Void.TYPE");
            Class<?> declaringClass = z2 ? field.getDeclaringClass() : null;
            Type genericType = field.getGenericType();
            AbstractC13042fc3.h(genericType, "field.genericType");
            super(field, cls, declaringClass, new Type[]{genericType}, null);
            this.f = z;
        }
    }

    /* renamed from: ir.nasim.qA0$h */
    public static abstract class h extends AbstractC19331qA0 {
        private final boolean f;

        /* renamed from: ir.nasim.qA0$h$a */
        public static final class a extends h implements InterfaceC22142uk0 {
            private final Object g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Method method, Object obj) {
                super(method, false, null, 4, null);
                AbstractC13042fc3.i(method, "method");
                this.g = obj;
            }

            @Override // ir.nasim.InterfaceC18740pA0
            public Object call(Object[] objArr) {
                AbstractC13042fc3.i(objArr, "args");
                c(objArr);
                return f(this.g, objArr);
            }
        }

        /* renamed from: ir.nasim.qA0$h$b */
        public static final class b extends h implements InterfaceC22142uk0 {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Method method) {
                super(method, false, null, 4, null);
                AbstractC13042fc3.i(method, "method");
            }

            @Override // ir.nasim.InterfaceC18740pA0
            public Object call(Object[] objArr) {
                AbstractC13042fc3.i(objArr, "args");
                c(objArr);
                return f(null, objArr);
            }
        }

        /* renamed from: ir.nasim.qA0$h$c */
        public static final class c extends h implements InterfaceC22142uk0 {
            private final Object g;

            /* JADX WARN: Illegal instructions before constructor call */
            public c(Method method, Object obj) {
                Object objS;
                AbstractC13042fc3.i(method, "method");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                AbstractC13042fc3.h(genericParameterTypes, "method.genericParameterTypes");
                boolean z = false;
                if (genericParameterTypes.length <= 1) {
                    objS = new Type[0];
                } else {
                    objS = AbstractC9648aK.s(genericParameterTypes, 1, genericParameterTypes.length);
                    if (objS == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                super(method, z, (Type[]) objS, null);
                this.g = obj;
            }

            @Override // ir.nasim.InterfaceC18740pA0
            public Object call(Object[] objArr) {
                AbstractC13042fc3.i(objArr, "args");
                c(objArr);
                C15872kJ6 c15872kJ6 = new C15872kJ6(2);
                c15872kJ6.a(this.g);
                c15872kJ6.b(objArr);
                return f(null, c15872kJ6.d(new Object[c15872kJ6.c()]));
            }
        }

        /* renamed from: ir.nasim.qA0$h$d */
        public static final class d extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Method method) {
                super(method, false, null, 6, null);
                AbstractC13042fc3.i(method, "method");
            }

            @Override // ir.nasim.InterfaceC18740pA0
            public Object call(Object[] objArr) {
                Object[] objArrS;
                AbstractC13042fc3.i(objArr, "args");
                c(objArr);
                Object obj = objArr[0];
                if (objArr.length <= 1) {
                    objArrS = new Object[0];
                } else {
                    objArrS = AbstractC9648aK.s(objArr, 1, objArr.length);
                    if (objArrS == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                return f(obj, objArrS);
            }
        }

        /* renamed from: ir.nasim.qA0$h$e */
        public static final class e extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(Method method) {
                super(method, true, null, 4, null);
                AbstractC13042fc3.i(method, "method");
            }

            @Override // ir.nasim.InterfaceC18740pA0
            public Object call(Object[] objArr) {
                Object[] objArrS;
                AbstractC13042fc3.i(objArr, "args");
                c(objArr);
                d(AbstractC10242bK.e0(objArr));
                if (objArr.length <= 1) {
                    objArrS = new Object[0];
                } else {
                    objArrS = AbstractC9648aK.s(objArr, 1, objArr.length);
                    if (objArrS == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                return f(null, objArrS);
            }
        }

        /* renamed from: ir.nasim.qA0$h$f */
        public static final class f extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(Method method) {
                super(method, false, null, 6, null);
                AbstractC13042fc3.i(method, "method");
            }

            @Override // ir.nasim.InterfaceC18740pA0
            public Object call(Object[] objArr) {
                AbstractC13042fc3.i(objArr, "args");
                c(objArr);
                return f(null, objArr);
            }
        }

        public /* synthetic */ h(Method method, boolean z, Type[] typeArr, ED1 ed1) {
            this(method, z, typeArr);
        }

        protected final Object f(Object obj, Object[] objArr) {
            AbstractC13042fc3.i(objArr, "args");
            return this.f ? C19938rB7.a : ((Method) b()).invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* synthetic */ h(Method method, boolean z, Type[] typeArr, int i, ED1 ed1) {
            z = (i & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z;
            if ((i & 4) != 0) {
                typeArr = method.getGenericParameterTypes();
                AbstractC13042fc3.h(typeArr, "method.genericParameterTypes");
            }
            this(method, z, typeArr);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private h(Method method, boolean z, Type[] typeArr) {
            Type genericReturnType = method.getGenericReturnType();
            AbstractC13042fc3.h(genericReturnType, "method.genericReturnType");
            super(method, genericReturnType, z ? method.getDeclaringClass() : null, typeArr, null);
            this.f = AbstractC13042fc3.d(getReturnType(), Void.TYPE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private AbstractC19331qA0(java.lang.reflect.Member r1, java.lang.reflect.Type r2, java.lang.Class r3, java.lang.reflect.Type[] r4) {
        /*
            r0 = this;
            r0.<init>()
            r0.b = r1
            r0.c = r2
            r0.d = r3
            if (r3 == 0) goto L2a
            ir.nasim.kJ6 r1 = new ir.nasim.kJ6
            r2 = 2
            r1.<init>(r2)
            r1.a(r3)
            r1.b(r4)
            int r2 = r1.c()
            java.lang.reflect.Type[] r2 = new java.lang.reflect.Type[r2]
            java.lang.Object[] r1 = r1.d(r2)
            java.lang.reflect.Type[] r1 = (java.lang.reflect.Type[]) r1
            java.util.List r1 = ir.nasim.ZW0.p(r1)
            if (r1 == 0) goto L2a
            goto L2e
        L2a:
            java.util.List r1 = ir.nasim.XJ.f1(r4)
        L2e:
            r0.a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19331qA0.<init>(java.lang.reflect.Member, java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type[]):void");
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public List a() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public final Member b() {
        return this.b;
    }

    public void c(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "args");
        InterfaceC18740pA0.a.a(this, objArr);
    }

    protected final void d(Object obj) {
        if (obj == null || !this.b.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    public final Class e() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public final Type getReturnType() {
        return this.c;
    }

    public /* synthetic */ AbstractC19331qA0(Member member, Type type, Class cls, Type[] typeArr, ED1 ed1) {
        this(member, type, cls, typeArr);
    }
}
