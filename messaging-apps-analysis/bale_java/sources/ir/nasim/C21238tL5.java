package ir.nasim;

import ir.nasim.InterfaceC22805vr3;
import ir.nasim.PJ6;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: ir.nasim.tL5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C21238tL5 {
    public static final C21238tL5 a = new C21238tL5();

    private C21238tL5() {
    }

    private final BU0 a(Class cls) {
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
            AbstractC13042fc3.h(cls, "currentClass.componentType");
        }
        if (!cls.isPrimitive()) {
            C24948zU0 c24948zU0B = AbstractC21912uL5.b(cls);
            C5203Ii3 c5203Ii3 = C5203Ii3.a;
            C9424Zw2 c9424Zw2B = c24948zU0B.b();
            AbstractC13042fc3.h(c9424Zw2B, "javaClassId.asSingleFqName()");
            C24948zU0 c24948zU0N = c5203Ii3.n(c9424Zw2B);
            if (c24948zU0N != null) {
                c24948zU0B = c24948zU0N;
            }
            return new BU0(c24948zU0B, i);
        }
        if (AbstractC13042fc3.d(cls, Void.TYPE)) {
            C24948zU0 c24948zU0M = C24948zU0.m(PJ6.a.f.l());
            AbstractC13042fc3.h(c24948zU0M, "topLevel(StandardNames.FqNames.unit.toSafe())");
            return new BU0(c24948zU0M, i);
        }
        EnumC4809Gq5 enumC4809Gq5S = EnumC7376Rl3.p(cls.getName()).s();
        AbstractC13042fc3.h(enumC4809Gq5S, "get(currentClass.name).primitiveType");
        if (i > 0) {
            C24948zU0 c24948zU0M2 = C24948zU0.m(enumC4809Gq5S.a());
            AbstractC13042fc3.h(c24948zU0M2, "topLevel(primitiveType.arrayTypeFqName)");
            return new BU0(c24948zU0M2, i - 1);
        }
        C24948zU0 c24948zU0M3 = C24948zU0.m(enumC4809Gq5S.p());
        AbstractC13042fc3.h(c24948zU0M3, "topLevel(primitiveType.typeFqName)");
        return new BU0(c24948zU0M3, i);
    }

    private final void c(Class cls, InterfaceC22805vr3.d dVar) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Constructor<?>[] constructorArr;
        int i;
        int i2;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        AbstractC13042fc3.h(declaredConstructors, "klass.declaredConstructors");
        int length = declaredConstructors.length;
        int i3 = 0;
        while (i3 < length) {
            Constructor<?> constructor = declaredConstructors[i3];
            int i4 = i3 + 1;
            C6432No4 c6432No4S = C6432No4.s("<init>");
            AbstractC13042fc3.h(c6432No4S, "special(\"<init>\")");
            C21158tC6 c21158tC6 = C21158tC6.a;
            AbstractC13042fc3.h(constructor, "constructor");
            InterfaceC22805vr3.e eVarA = dVar.a(c6432No4S, c21158tC6.a(constructor));
            if (eVarA == null) {
                constructorArr = declaredConstructors;
                i = length;
                i2 = i4;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                AbstractC13042fc3.h(declaredAnnotations, "constructor.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i5 = 0;
                while (i5 < length2) {
                    Annotation annotation = declaredAnnotations[i5];
                    i5++;
                    AbstractC13042fc3.h(annotation, "annotation");
                    f(eVarA, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                AbstractC13042fc3.h(parameterAnnotations, "parameterAnnotations");
                if (!(parameterAnnotations.length == 0)) {
                    int length3 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length4 = parameterAnnotations.length;
                    int i6 = 0;
                    while (i6 < length4) {
                        Annotation[] annotationArr = parameterAnnotations[i6];
                        int i7 = i6 + 1;
                        AbstractC13042fc3.h(annotationArr, "annotations");
                        int length5 = annotationArr.length;
                        int i8 = 0;
                        while (i8 < length5) {
                            Annotation annotation2 = annotationArr[i8];
                            i8++;
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            Class clsB = AbstractC4762Gl3.b(AbstractC4762Gl3.a(annotation2));
                            int i9 = length;
                            int i10 = i4;
                            C24948zU0 c24948zU0B = AbstractC21912uL5.b(clsB);
                            int i11 = length3;
                            AbstractC13042fc3.h(annotation2, "annotation");
                            InterfaceC22805vr3.a aVarB = eVarA.b(i6 + length3, c24948zU0B, new C20635sL5(annotation2));
                            if (aVarB != null) {
                                h(aVarB, annotation2, clsB);
                            }
                            length = i9;
                            declaredConstructors = constructorArr2;
                            i4 = i10;
                            length3 = i11;
                        }
                        i6 = i7;
                    }
                }
                constructorArr = declaredConstructors;
                i = length;
                i2 = i4;
                eVarA.a();
            }
            length = i;
            declaredConstructors = constructorArr;
            i3 = i2;
        }
    }

    private final void d(Class cls, InterfaceC22805vr3.d dVar) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Field[] declaredFields = cls.getDeclaredFields();
        AbstractC13042fc3.h(declaredFields, "klass.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            i++;
            C6432No4 c6432No4P = C6432No4.p(field.getName());
            AbstractC13042fc3.h(c6432No4P, "identifier(field.name)");
            C21158tC6 c21158tC6 = C21158tC6.a;
            AbstractC13042fc3.h(field, "field");
            InterfaceC22805vr3.c cVarB = dVar.b(c6432No4P, c21158tC6.b(field), null);
            if (cVarB != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                AbstractC13042fc3.h(declaredAnnotations, "field.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i2 = 0;
                while (i2 < length2) {
                    Annotation annotation = declaredAnnotations[i2];
                    i2++;
                    AbstractC13042fc3.h(annotation, "annotation");
                    f(cVarB, annotation);
                }
                cVarB.a();
            }
        }
    }

    private final void e(Class cls, InterfaceC22805vr3.d dVar) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method[] methodArr;
        int i;
        Method[] declaredMethods = cls.getDeclaredMethods();
        AbstractC13042fc3.h(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i2 = 0;
        while (i2 < length) {
            Method method = declaredMethods[i2];
            i2++;
            C6432No4 c6432No4P = C6432No4.p(method.getName());
            AbstractC13042fc3.h(c6432No4P, "identifier(method.name)");
            C21158tC6 c21158tC6 = C21158tC6.a;
            AbstractC13042fc3.h(method, "method");
            InterfaceC22805vr3.e eVarA = dVar.a(c6432No4P, c21158tC6.c(method));
            if (eVarA == null) {
                methodArr = declaredMethods;
                i = length;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                AbstractC13042fc3.h(declaredAnnotations, "method.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i3 = 0;
                while (i3 < length2) {
                    Annotation annotation = declaredAnnotations[i3];
                    i3++;
                    AbstractC13042fc3.h(annotation, "annotation");
                    f(eVarA, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                AbstractC13042fc3.h(parameterAnnotations, "method.parameterAnnotations");
                Annotation[][] annotationArr = parameterAnnotations;
                int length3 = annotationArr.length;
                int i4 = 0;
                while (i4 < length3) {
                    Annotation[] annotationArr2 = annotationArr[i4];
                    int i5 = i4 + 1;
                    AbstractC13042fc3.h(annotationArr2, "annotations");
                    int length4 = annotationArr2.length;
                    int i6 = 0;
                    while (i6 < length4) {
                        Annotation annotation2 = annotationArr2[i6];
                        i6++;
                        Class clsB = AbstractC4762Gl3.b(AbstractC4762Gl3.a(annotation2));
                        Method[] methodArr2 = declaredMethods;
                        C24948zU0 c24948zU0B = AbstractC21912uL5.b(clsB);
                        int i7 = length;
                        AbstractC13042fc3.h(annotation2, "annotation");
                        InterfaceC22805vr3.a aVarB = eVarA.b(i4, c24948zU0B, new C20635sL5(annotation2));
                        if (aVarB != null) {
                            h(aVarB, annotation2, clsB);
                        }
                        declaredMethods = methodArr2;
                        length = i7;
                    }
                    i4 = i5;
                }
                methodArr = declaredMethods;
                i = length;
                eVarA.a();
            }
            declaredMethods = methodArr;
            length = i;
        }
    }

    private final void f(InterfaceC22805vr3.c cVar, Annotation annotation) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class clsB = AbstractC4762Gl3.b(AbstractC4762Gl3.a(annotation));
        InterfaceC22805vr3.a aVarC = cVar.c(AbstractC21912uL5.b(clsB), new C20635sL5(annotation));
        if (aVarC == null) {
            return;
        }
        h(aVarC, annotation, clsB);
    }

    private final void g(InterfaceC22805vr3.a aVar, C6432No4 c6432No4, Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> enclosingClass = obj.getClass();
        if (AbstractC13042fc3.d(enclosingClass, Class.class)) {
            aVar.d(c6432No4, a((Class) obj));
            return;
        }
        if (ZL5.a.contains(enclosingClass)) {
            aVar.f(c6432No4, obj);
            return;
        }
        if (AbstractC21912uL5.i(enclosingClass)) {
            if (!enclosingClass.isEnum()) {
                enclosingClass = enclosingClass.getEnclosingClass();
            }
            AbstractC13042fc3.h(enclosingClass, "if (clazz.isEnum) clazz else clazz.enclosingClass");
            C24948zU0 c24948zU0B = AbstractC21912uL5.b(enclosingClass);
            C6432No4 c6432No4P = C6432No4.p(((Enum) obj).name());
            AbstractC13042fc3.h(c6432No4P, "identifier((value as Enum<*>).name)");
            aVar.c(c6432No4, c24948zU0B, c6432No4P);
            return;
        }
        if (Annotation.class.isAssignableFrom(enclosingClass)) {
            Class<?>[] interfaces = enclosingClass.getInterfaces();
            AbstractC13042fc3.h(interfaces, "clazz.interfaces");
            Class cls = (Class) AbstractC10242bK.N0(interfaces);
            AbstractC13042fc3.h(cls, "annotationClass");
            InterfaceC22805vr3.a aVarB = aVar.b(c6432No4, AbstractC21912uL5.b(cls));
            if (aVarB == null) {
                return;
            }
            h(aVarB, (Annotation) obj, cls);
            return;
        }
        if (!enclosingClass.isArray()) {
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + obj);
        }
        InterfaceC22805vr3.b bVarE = aVar.e(c6432No4);
        if (bVarE == null) {
            return;
        }
        Class<?> componentType = enclosingClass.getComponentType();
        int i = 0;
        if (componentType.isEnum()) {
            AbstractC13042fc3.h(componentType, "componentType");
            C24948zU0 c24948zU0B2 = AbstractC21912uL5.b(componentType);
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            while (i < length) {
                Object obj2 = objArr[i];
                i++;
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Enum<*>");
                }
                C6432No4 c6432No4P2 = C6432No4.p(((Enum) obj2).name());
                AbstractC13042fc3.h(c6432No4P2, "identifier((element as Enum<*>).name)");
                bVarE.d(c24948zU0B2, c6432No4P2);
            }
        } else if (AbstractC13042fc3.d(componentType, Class.class)) {
            Object[] objArr2 = (Object[]) obj;
            int length2 = objArr2.length;
            while (i < length2) {
                Object obj3 = objArr2[i];
                i++;
                if (obj3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
                }
                bVarE.b(a((Class) obj3));
            }
        } else {
            Object[] objArr3 = (Object[]) obj;
            int length3 = objArr3.length;
            while (i < length3) {
                Object obj4 = objArr3[i];
                i++;
                bVarE.c(obj4);
            }
        }
        bVarE.a();
    }

    private final void h(InterfaceC22805vr3.a aVar, Annotation annotation, Class cls) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method[] declaredMethods = cls.getDeclaredMethods();
        AbstractC13042fc3.h(declaredMethods, "annotationType.declaredMethods");
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            i++;
            try {
                Object objInvoke = method.invoke(annotation, null);
                AbstractC13042fc3.f(objInvoke);
                C6432No4 c6432No4P = C6432No4.p(method.getName());
                AbstractC13042fc3.h(c6432No4P, "identifier(method.name)");
                g(aVar, c6432No4P, objInvoke);
            } catch (IllegalAccessException unused) {
            }
        }
        aVar.a();
    }

    public final void b(Class cls, InterfaceC22805vr3.c cVar) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        AbstractC13042fc3.i(cls, "klass");
        AbstractC13042fc3.i(cVar, "visitor");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        AbstractC13042fc3.h(declaredAnnotations, "klass.declaredAnnotations");
        int length = declaredAnnotations.length;
        int i = 0;
        while (i < length) {
            Annotation annotation = declaredAnnotations[i];
            i++;
            AbstractC13042fc3.h(annotation, "annotation");
            f(cVar, annotation);
        }
        cVar.a();
    }

    public final void i(Class cls, InterfaceC22805vr3.d dVar) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        AbstractC13042fc3.i(cls, "klass");
        AbstractC13042fc3.i(dVar, "memberVisitor");
        e(cls, dVar);
        c(cls, dVar);
        d(cls, dVar);
    }
}
