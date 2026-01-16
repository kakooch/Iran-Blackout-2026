package ir.nasim;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import okhttp3.HttpUrl;

/* renamed from: ir.nasim.vz7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC22891vz7 {

    /* renamed from: ir.nasim.vz7$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC8326Vm3.values().length];
            try {
                iArr[EnumC8326Vm3.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC8326Vm3.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC8326Vm3.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.vz7$b */
    /* synthetic */ class b extends EB2 implements UA2 {
        public static final b a = new b();

        b() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Class invoke(Class cls) {
            AbstractC13042fc3.i(cls, "p0");
            return cls.getComponentType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type c(InterfaceC5941Lm3 interfaceC5941Lm3, boolean z) {
        InterfaceC14961im3 interfaceC14961im3A = interfaceC5941Lm3.a();
        if (interfaceC14961im3A instanceof InterfaceC6907Pm3) {
            return new C7970Ty7((InterfaceC6907Pm3) interfaceC14961im3A);
        }
        if (!(interfaceC14961im3A instanceof InterfaceC11299cm3)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + interfaceC5941Lm3);
        }
        InterfaceC11299cm3 interfaceC11299cm3 = (InterfaceC11299cm3) interfaceC14961im3A;
        Class clsC = z ? AbstractC4762Gl3.c(interfaceC11299cm3) : AbstractC4762Gl3.b(interfaceC11299cm3);
        List listD = interfaceC5941Lm3.d();
        if (listD.isEmpty()) {
            return clsC;
        }
        if (!clsC.isArray()) {
            return e(clsC, listD);
        }
        if (clsC.getComponentType().isPrimitive()) {
            return clsC;
        }
        C7858Tm3 c7858Tm3 = (C7858Tm3) AbstractC15401jX0.X0(listD);
        if (c7858Tm3 == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + interfaceC5941Lm3);
        }
        EnumC8326Vm3 enumC8326Vm3A = c7858Tm3.a();
        InterfaceC5941Lm3 interfaceC5941Lm3B = c7858Tm3.b();
        int i = enumC8326Vm3A == null ? -1 : a.a[enumC8326Vm3A.ordinal()];
        if (i == -1 || i == 1) {
            return clsC;
        }
        if (i != 2 && i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        AbstractC13042fc3.f(interfaceC5941Lm3B);
        Type typeD = d(interfaceC5941Lm3B, false, 1, null);
        return typeD instanceof Class ? clsC : new QE2(typeD);
    }

    static /* synthetic */ Type d(InterfaceC5941Lm3 interfaceC5941Lm3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return c(interfaceC5941Lm3, z);
    }

    private static final Type e(Class cls, List list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(g((C7858Tm3) it.next()));
            }
            return new C18942pW4(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            List list3 = list;
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list3, 10));
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(g((C7858Tm3) it2.next()));
            }
            return new C18942pW4(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeE = e(declaringClass, list.subList(length, list.size()));
        List listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(listSubList, 10));
        Iterator it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(g((C7858Tm3) it3.next()));
        }
        return new C18942pW4(cls, typeE, arrayList3);
    }

    public static final Type f(InterfaceC5941Lm3 interfaceC5941Lm3) {
        Type typeB;
        AbstractC13042fc3.i(interfaceC5941Lm3, "<this>");
        return (!(interfaceC5941Lm3 instanceof InterfaceC6174Mm3) || (typeB = ((InterfaceC6174Mm3) interfaceC5941Lm3).b()) == null) ? d(interfaceC5941Lm3, false, 1, null) : typeB;
    }

    private static final Type g(C7858Tm3 c7858Tm3) {
        EnumC8326Vm3 enumC8326Vm3D = c7858Tm3.d();
        if (enumC8326Vm3D == null) {
            return C16374l98.c.a();
        }
        InterfaceC5941Lm3 interfaceC5941Lm3C = c7858Tm3.c();
        AbstractC13042fc3.f(interfaceC5941Lm3C);
        int i = a.a[enumC8326Vm3D.ordinal()];
        if (i == 1) {
            return new C16374l98(null, c(interfaceC5941Lm3C, true));
        }
        if (i == 2) {
            return c(interfaceC5941Lm3C, true);
        }
        if (i == 3) {
            return new C16374l98(c(interfaceC5941Lm3C, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h(Type type) {
        String name;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            InterfaceC23384wp6 interfaceC23384wp6J = AbstractC9962aq6.j(type, b.a);
            name = ((Class) AbstractC11342cq6.B(interfaceC23384wp6J)).getName() + AbstractC20153rZ6.I(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, AbstractC11342cq6.n(interfaceC23384wp6J));
        } else {
            name = cls.getName();
        }
        AbstractC13042fc3.f(name);
        return name;
    }
}
