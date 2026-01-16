package ir.nasim;

import ir.nasim.C13760gm3;
import ir.nasim.C24740z76;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.iN7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14729iN7 {
    private static final C9424Zw2 a = new C9424Zw2("kotlin.jvm.JvmStatic");

    public static final C17324mm3 a(Object obj) {
        C17324mm3 c17324mm3 = (C17324mm3) (!(obj instanceof C17324mm3) ? null : obj);
        if (c17324mm3 != null) {
            return c17324mm3;
        }
        if (!(obj instanceof DB2)) {
            obj = null;
        }
        DB2 db2 = (DB2) obj;
        InterfaceC9916am3 interfaceC9916am3Compute = db2 != null ? db2.compute() : null;
        return (C17324mm3) (interfaceC9916am3Compute instanceof C17324mm3 ? interfaceC9916am3Compute : null);
    }

    public static final AbstractC5473Jm3 b(Object obj) {
        AbstractC5473Jm3 abstractC5473Jm3 = (AbstractC5473Jm3) (!(obj instanceof AbstractC5473Jm3) ? null : obj);
        if (abstractC5473Jm3 != null) {
            return abstractC5473Jm3;
        }
        if (!(obj instanceof AbstractC3912Cw5)) {
            obj = null;
        }
        AbstractC3912Cw5 abstractC3912Cw5 = (AbstractC3912Cw5) obj;
        InterfaceC9916am3 interfaceC9916am3Compute = abstractC3912Cw5 != null ? abstractC3912Cw5.compute() : null;
        return (AbstractC5473Jm3) (interfaceC9916am3Compute instanceof AbstractC5473Jm3 ? interfaceC9916am3Compute : null);
    }

    public static final List c(InterfaceC10612bu interfaceC10612bu) {
        Annotation annotationL;
        AbstractC13042fc3.i(interfaceC10612bu, "$this$computeAnnotations");
        InterfaceC4356Eu<InterfaceC21651tu> annotations = interfaceC10612bu.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (InterfaceC21651tu interfaceC21651tu : annotations) {
            JH6 jh6I = interfaceC21651tu.i();
            if (jh6I instanceof C20635sL5) {
                annotationL = ((C20635sL5) jh6I).d();
            } else if (jh6I instanceof C24740z76.a) {
                IL5 il5C = ((C24740z76.a) jh6I).c();
                if (!(il5C instanceof C22502vL5)) {
                    il5C = null;
                }
                C22502vL5 c22502vL5 = (C22502vL5) il5C;
                annotationL = c22502vL5 != null ? c22502vL5.R() : null;
            } else {
                annotationL = l(interfaceC21651tu);
            }
            if (annotationL != null) {
                arrayList.add(annotationL);
            }
        }
        return arrayList;
    }

    public static final Object d(Type type) {
        AbstractC13042fc3.i(type, "type");
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return null;
        }
        if (AbstractC13042fc3.d(type, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (AbstractC13042fc3.d(type, Character.TYPE)) {
            return Character.valueOf((char) 0);
        }
        if (AbstractC13042fc3.d(type, Byte.TYPE)) {
            return Byte.valueOf((byte) 0);
        }
        if (AbstractC13042fc3.d(type, Short.TYPE)) {
            return Short.valueOf((short) 0);
        }
        if (AbstractC13042fc3.d(type, Integer.TYPE)) {
            return 0;
        }
        if (AbstractC13042fc3.d(type, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (AbstractC13042fc3.d(type, Long.TYPE)) {
            return 0L;
        }
        if (AbstractC13042fc3.d(type, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (AbstractC13042fc3.d(type, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException("Unknown primitive: " + type);
    }

    public static final InterfaceC14592iA0 e(Class cls, kotlin.reflect.jvm.internal.impl.protobuf.l lVar, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, AbstractC7310Re0 abstractC7310Re0, InterfaceC14603iB2 interfaceC14603iB2) {
        List listJ0;
        AbstractC13042fc3.i(cls, "moduleAnchor");
        AbstractC13042fc3.i(lVar, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        AbstractC13042fc3.i(abstractC7310Re0, "metadataVersion");
        AbstractC13042fc3.i(interfaceC14603iB2, "createDescriptor");
        C23560x76 c23560x76A = AbstractC7098Qg4.a(cls);
        if (lVar instanceof C7950Tw5) {
            listJ0 = ((C7950Tw5) lVar).i0();
        } else {
            if (!(lVar instanceof C9193Yw5)) {
                throw new IllegalStateException(("Unsupported message: " + lVar).toString());
            }
            listJ0 = ((C9193Yw5) lVar).j0();
        }
        List list = listJ0;
        TI1 ti1A = c23560x76A.a();
        InterfaceC8507Wg4 interfaceC8507Wg4B = c23560x76A.b();
        C10938cS7 c10938cS7B = C10938cS7.b.b();
        AbstractC13042fc3.h(list, "typeParameters");
        return (InterfaceC14592iA0) interfaceC14603iB2.invoke(new C21732u24(new WI1(ti1A, interfaceC6692Oo4, interfaceC8507Wg4B, c7029Py7, c10938cS7B, abstractC7310Re0, null, null, list)), lVar);
    }

    public static final ZI5 f(InterfaceC14592iA0 interfaceC14592iA0) {
        AbstractC13042fc3.i(interfaceC14592iA0, "$this$instanceReceiverParameter");
        if (interfaceC14592iA0.N() == null) {
            return null;
        }
        InterfaceC12795fB1 interfaceC12795fB1B = interfaceC14592iA0.b();
        if (interfaceC12795fB1B != null) {
            return ((InterfaceC21331tU0) interfaceC12795fB1B).H0();
        }
        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }

    public static final C9424Zw2 g() {
        return a;
    }

    public static final boolean h(InterfaceC5941Lm3 interfaceC5941Lm3) {
        AbstractC4099Dr3 abstractC4099Dr3I;
        AbstractC13042fc3.i(interfaceC5941Lm3, "$this$isInlineClassType");
        if (!(interfaceC5941Lm3 instanceof C6673Om3)) {
            interfaceC5941Lm3 = null;
        }
        C6673Om3 c6673Om3 = (C6673Om3) interfaceC5941Lm3;
        return (c6673Om3 == null || (abstractC4099Dr3I = c6673Om3.i()) == null || !R73.c(abstractC4099Dr3I)) ? false : true;
    }

    private static final Class i(ClassLoader classLoader, C24948zU0 c24948zU0, int i) {
        C5203Ii3 c5203Ii3 = C5203Ii3.a;
        C10027ax2 c10027ax2J = c24948zU0.b().j();
        AbstractC13042fc3.h(c10027ax2J, "kotlinClassId.asSingleFqName().toUnsafe()");
        C24948zU0 c24948zU0O = c5203Ii3.o(c10027ax2J);
        if (c24948zU0O != null) {
            c24948zU0 = c24948zU0O;
        }
        String strB = c24948zU0.h().b();
        AbstractC13042fc3.h(strB, "javaClassId.packageFqName.asString()");
        String strB2 = c24948zU0.i().b();
        AbstractC13042fc3.h(strB2, "javaClassId.relativeClassName.asString()");
        return j(classLoader, strB, strB2, i);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private static final Class j(ClassLoader classLoader, String str, String str2, int i) {
        if (AbstractC13042fc3.d(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        String str3 = str + '.' + AbstractC20153rZ6.L(str2, '.', '$', false, 4, null);
        if (i > 0) {
            str3 = AbstractC20153rZ6.I("[", i) + 'L' + str3 + ';';
        }
        return EL5.a(classLoader, str3);
    }

    static /* synthetic */ Class k(ClassLoader classLoader, C24948zU0 c24948zU0, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return i(classLoader, c24948zU0, i);
    }

    private static final Annotation l(InterfaceC21651tu interfaceC21651tu) {
        InterfaceC21331tU0 interfaceC21331tU0F = PI1.f(interfaceC21651tu);
        Class clsM = interfaceC21331tU0F != null ? m(interfaceC21331tU0F) : null;
        if (!(clsM instanceof Class)) {
            clsM = null;
        }
        if (clsM == null) {
            return null;
        }
        Set<Map.Entry> setEntrySet = interfaceC21651tu.j().entrySet();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : setEntrySet) {
            C6432No4 c6432No4 = (C6432No4) entry.getKey();
            AbstractC7068Qd1 abstractC7068Qd1 = (AbstractC7068Qd1) entry.getValue();
            ClassLoader classLoader = clsM.getClassLoader();
            AbstractC13042fc3.h(classLoader, "annotationClass.classLoader");
            Object objO = o(abstractC7068Qd1, classLoader);
            XV4 xv4A = objO != null ? AbstractC4616Fw7.a(c6432No4.h(), objO) : null;
            if (xv4A != null) {
                arrayList.add(xv4A);
            }
        }
        return (Annotation) AbstractC20373ru.d(clsM, AbstractC20051rO3.w(arrayList), null, 4, null);
    }

    public static final Class m(InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC21331tU0, "$this$toJavaClass");
        JH6 jh6I = interfaceC21331tU0.i();
        AbstractC13042fc3.h(jh6I, "source");
        if (jh6I instanceof C23991xr3) {
            InterfaceC22805vr3 interfaceC22805vr3D = ((C23991xr3) jh6I).d();
            if (interfaceC22805vr3D != null) {
                return ((WL5) interfaceC22805vr3D).d();
            }
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
        }
        if (jh6I instanceof C24740z76.a) {
            IL5 il5C = ((C24740z76.a) jh6I).c();
            if (il5C != null) {
                return ((CL5) il5C).r();
            }
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
        }
        C24948zU0 c24948zU0H = PI1.h(interfaceC21331tU0);
        if (c24948zU0H != null) {
            return i(AbstractC21912uL5.g(interfaceC21331tU0.getClass()), c24948zU0H, 0);
        }
        return null;
    }

    public static final EnumC8560Wm3 n(RI1 ri1) {
        AbstractC13042fc3.i(ri1, "$this$toKVisibility");
        if (AbstractC13042fc3.d(ri1, QI1.e)) {
            return EnumC8560Wm3.a;
        }
        if (AbstractC13042fc3.d(ri1, QI1.c)) {
            return EnumC8560Wm3.b;
        }
        if (AbstractC13042fc3.d(ri1, QI1.d)) {
            return EnumC8560Wm3.c;
        }
        if (AbstractC13042fc3.d(ri1, QI1.a) || AbstractC13042fc3.d(ri1, QI1.b)) {
            return EnumC8560Wm3.d;
        }
        return null;
    }

    private static final Object o(AbstractC7068Qd1 abstractC7068Qd1, ClassLoader classLoader) {
        if (abstractC7068Qd1 instanceof C4122Du) {
            return l((InterfaceC21651tu) ((C4122Du) abstractC7068Qd1).b());
        }
        if (abstractC7068Qd1 instanceof WJ) {
            Iterable iterable = (Iterable) ((WJ) abstractC7068Qd1).b();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(o((AbstractC7068Qd1) it.next(), classLoader));
            }
            Object[] array = arrayList.toArray(new Object[0]);
            if (array != null) {
                return array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        if (abstractC7068Qd1 instanceof N92) {
            XV4 xv4 = (XV4) ((N92) abstractC7068Qd1).b();
            C24948zU0 c24948zU0 = (C24948zU0) xv4.a();
            C6432No4 c6432No4 = (C6432No4) xv4.b();
            Class clsK = k(classLoader, c24948zU0, 0, 4, null);
            if (clsK != null) {
                return AbstractC12300eN7.a(clsK, c6432No4.h());
            }
        } else if (abstractC7068Qd1 instanceof C13760gm3) {
            C13760gm3.b bVar = (C13760gm3.b) ((C13760gm3) abstractC7068Qd1).b();
            if (bVar instanceof C13760gm3.b.C1259b) {
                C13760gm3.b.C1259b c1259b = (C13760gm3.b.C1259b) bVar;
                return i(classLoader, c1259b.b(), c1259b.a());
            }
            if (!(bVar instanceof C13760gm3.b.a)) {
                throw new NoWhenBranchMatchedException();
            }
            MU0 mu0D = ((C13760gm3.b.a) bVar).a().K0().t();
            if (!(mu0D instanceof InterfaceC21331tU0)) {
                mu0D = null;
            }
            InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) mu0D;
            if (interfaceC21331tU0 != null) {
                return m(interfaceC21331tU0);
            }
        } else if (!(abstractC7068Qd1 instanceof AbstractC15430ja2) && !(abstractC7068Qd1 instanceof C12834fF4)) {
            return abstractC7068Qd1.b();
        }
        return null;
    }
}
