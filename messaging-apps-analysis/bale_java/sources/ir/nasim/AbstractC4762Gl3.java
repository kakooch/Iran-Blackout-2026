package ir.nasim;

import java.lang.annotation.Annotation;

/* renamed from: ir.nasim.Gl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC4762Gl3 {
    public static final InterfaceC11299cm3 a(Annotation annotation) {
        AbstractC13042fc3.i(annotation, "<this>");
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        AbstractC13042fc3.h(clsAnnotationType, "annotationType(...)");
        InterfaceC11299cm3 interfaceC11299cm3E = e(clsAnnotationType);
        AbstractC13042fc3.g(interfaceC11299cm3E, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return interfaceC11299cm3E;
    }

    public static final Class b(InterfaceC11299cm3 interfaceC11299cm3) {
        AbstractC13042fc3.i(interfaceC11299cm3, "<this>");
        Class clsE = ((InterfaceC17738nU0) interfaceC11299cm3).e();
        AbstractC13042fc3.g(clsE, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return clsE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class c(InterfaceC11299cm3 interfaceC11299cm3) {
        AbstractC13042fc3.i(interfaceC11299cm3, "<this>");
        Class clsE = ((InterfaceC17738nU0) interfaceC11299cm3).e();
        if (!clsE.isPrimitive()) {
            AbstractC13042fc3.g(clsE, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return clsE;
        }
        String name = clsE.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    clsE = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    clsE = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    clsE = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    clsE = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    clsE = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    clsE = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    clsE = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    clsE = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    clsE = Short.class;
                    break;
                }
                break;
        }
        AbstractC13042fc3.g(clsE, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return clsE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final Class d(InterfaceC11299cm3 interfaceC11299cm3) {
        AbstractC13042fc3.i(interfaceC11299cm3, "<this>");
        Class clsE = ((InterfaceC17738nU0) interfaceC11299cm3).e();
        if (clsE.isPrimitive()) {
            AbstractC13042fc3.g(clsE, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return clsE;
        }
        String name = clsE.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    public static final InterfaceC11299cm3 e(Class cls) {
        AbstractC13042fc3.i(cls, "<this>");
        return AbstractC10882cM5.b(cls);
    }
}
