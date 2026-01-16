package ir.nasim;

import ir.nasim.AbstractC10266bM5;
import ir.nasim.InterfaceC3347Am3;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.full.IllegalCallableAccessException;

/* renamed from: ir.nasim.bm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10536bm3 implements InterfaceC9916am3, InterfaceC7619Sm3 {
    private final AbstractC10266bM5.a a;
    private final AbstractC10266bM5.a b;
    private final AbstractC10266bM5.a c;
    private final AbstractC10266bM5.a d;

    /* renamed from: ir.nasim.bm3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            return AbstractC14729iN7.c(AbstractC10536bm3.this.A());
        }
    }

    /* renamed from: ir.nasim.bm3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {

        /* renamed from: ir.nasim.bm3$b$a */
        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(((InterfaceC3347Am3) obj).getName(), ((InterfaceC3347Am3) obj2).getName());
            }
        }

        /* renamed from: ir.nasim.bm3$b$b, reason: collision with other inner class name */
        static final class C0920b extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ ZI5 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0920b(ZI5 zi5) {
                super(0);
                this.e = zi5;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC17169mW4 invoke() {
                return this.e;
            }
        }

        /* renamed from: ir.nasim.bm3$b$c */
        static final class c extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ ZI5 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(ZI5 zi5) {
                super(0);
                this.e = zi5;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC17169mW4 invoke() {
                return this.e;
            }
        }

        /* renamed from: ir.nasim.bm3$b$d */
        static final class d extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC15194jA0 e;
            final /* synthetic */ int f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(InterfaceC15194jA0 interfaceC15194jA0, int i) {
                super(0);
                this.e = interfaceC15194jA0;
                this.f = i;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC17169mW4 invoke() {
                Object obj = this.e.h().get(this.f);
                AbstractC13042fc3.h(obj, "descriptor.valueParameters[i]");
                return (InterfaceC17169mW4) obj;
            }
        }

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ArrayList invoke() {
            int i;
            InterfaceC15194jA0 interfaceC15194jA0A = AbstractC10536bm3.this.A();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            if (AbstractC10536bm3.this.C()) {
                i = 0;
            } else {
                ZI5 zi5F = AbstractC14729iN7.f(interfaceC15194jA0A);
                if (zi5F != null) {
                    arrayList.add(new C3586Bm3(AbstractC10536bm3.this, 0, InterfaceC3347Am3.a.a, new C0920b(zi5F)));
                    i = 1;
                } else {
                    i = 0;
                }
                ZI5 zi5Q = interfaceC15194jA0A.Q();
                if (zi5Q != null) {
                    arrayList.add(new C3586Bm3(AbstractC10536bm3.this, i, InterfaceC3347Am3.a.b, new c(zi5Q)));
                    i++;
                }
            }
            List listH = interfaceC15194jA0A.h();
            AbstractC13042fc3.h(listH, "descriptor.valueParameters");
            int size = listH.size();
            while (i2 < size) {
                arrayList.add(new C3586Bm3(AbstractC10536bm3.this, i, InterfaceC3347Am3.a.c, new d(interfaceC15194jA0A, i2)));
                i2++;
                i++;
            }
            if (AbstractC10536bm3.this.B() && (interfaceC15194jA0A instanceof InterfaceC6862Ph3) && arrayList.size() > 1) {
                AbstractC12992fX0.B(arrayList, new a());
            }
            arrayList.trimToSize();
            return arrayList;
        }
    }

    /* renamed from: ir.nasim.bm3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {

        /* renamed from: ir.nasim.bm3$c$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            a() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Type invoke() {
                Type typeV = AbstractC10536bm3.this.v();
                return typeV != null ? typeV : AbstractC10536bm3.this.x().getReturnType();
            }
        }

        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C6673Om3 invoke() {
            AbstractC4099Dr3 returnType = AbstractC10536bm3.this.A().getReturnType();
            AbstractC13042fc3.f(returnType);
            AbstractC13042fc3.h(returnType, "descriptor.returnType!!");
            return new C6673Om3(returnType, new a());
        }
    }

    /* renamed from: ir.nasim.bm3$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            List typeParameters = AbstractC10536bm3.this.A().getTypeParameters();
            AbstractC13042fc3.h(typeParameters, "descriptor.typeParameters");
            List<InterfaceC22882vy7> list = typeParameters;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (InterfaceC22882vy7 interfaceC22882vy7 : list) {
                AbstractC10536bm3 abstractC10536bm3 = AbstractC10536bm3.this;
                AbstractC13042fc3.h(interfaceC22882vy7, "descriptor");
                arrayList.add(new C7385Rm3(abstractC10536bm3, interfaceC22882vy7));
            }
            return arrayList;
        }
    }

    public AbstractC10536bm3() {
        AbstractC10266bM5.a aVarC = AbstractC10266bM5.c(new a());
        AbstractC13042fc3.h(aVarC, "ReflectProperties.lazySo…or.computeAnnotations() }");
        this.a = aVarC;
        AbstractC10266bM5.a aVarC2 = AbstractC10266bM5.c(new b());
        AbstractC13042fc3.h(aVarC2, "ReflectProperties.lazySo…ze()\n        result\n    }");
        this.b = aVarC2;
        AbstractC10266bM5.a aVarC3 = AbstractC10266bM5.c(new c());
        AbstractC13042fc3.h(aVarC3, "ReflectProperties.lazySo…eturnType\n        }\n    }");
        this.c = aVarC3;
        AbstractC10266bM5.a aVarC4 = AbstractC10266bM5.c(new d());
        AbstractC13042fc3.h(aVarC4, "ReflectProperties.lazySo…this, descriptor) }\n    }");
        this.d = aVarC4;
    }

    private final Object i(Map map) throws IllegalCallableAccessException, NegativeArraySizeException {
        Object objT;
        List<InterfaceC3347Am3> parameters = getParameters();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(parameters, 10));
        for (InterfaceC3347Am3 interfaceC3347Am3 : parameters) {
            if (map.containsKey(interfaceC3347Am3)) {
                objT = map.get(interfaceC3347Am3);
                if (objT == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + interfaceC3347Am3 + ')');
                }
            } else if (interfaceC3347Am3.w()) {
                objT = null;
            } else {
                if (!interfaceC3347Am3.c()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + interfaceC3347Am3);
                }
                objT = t(interfaceC3347Am3.getType());
            }
            arrayList.add(objT);
        }
        InterfaceC18740pA0 interfaceC18740pA0Z = z();
        if (interfaceC18740pA0Z == null) {
            throw new C25175zr3("This callable does not support a default call: " + A());
        }
        try {
            Object[] array = arrayList.toArray(new Object[0]);
            if (array != null) {
                return interfaceC18740pA0Z.call(array);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    private final Object t(InterfaceC5941Lm3 interfaceC5941Lm3) throws NegativeArraySizeException {
        Class clsB = AbstractC4762Gl3.b(AbstractC8092Um3.b(interfaceC5941Lm3));
        if (clsB.isArray()) {
            Object objNewInstance = Array.newInstance(clsB.getComponentType(), 0);
            AbstractC13042fc3.h(objNewInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return objNewInstance;
        }
        throw new C25175zr3("Cannot instantiate the default empty array of type " + clsB.getSimpleName() + ", because it is not an array type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Type v() {
        Type[] lowerBounds;
        InterfaceC15194jA0 interfaceC15194jA0A = A();
        if (!(interfaceC15194jA0A instanceof AB2)) {
            interfaceC15194jA0A = null;
        }
        AB2 ab2 = (AB2) interfaceC15194jA0A;
        if (ab2 == null || !ab2.isSuspend()) {
            return null;
        }
        Object objF0 = AbstractC15401jX0.F0(x().a());
        if (!(objF0 instanceof ParameterizedType)) {
            objF0 = null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) objF0;
        if (!AbstractC13042fc3.d(parameterizedType != null ? parameterizedType.getRawType() : null, InterfaceC20295rm1.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        AbstractC13042fc3.h(actualTypeArguments, "continuationType.actualTypeArguments");
        Object objN0 = AbstractC10242bK.N0(actualTypeArguments);
        if (!(objN0 instanceof WildcardType)) {
            objN0 = null;
        }
        WildcardType wildcardType = (WildcardType) objN0;
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) AbstractC10242bK.b0(lowerBounds);
    }

    public abstract InterfaceC15194jA0 A();

    protected final boolean B() {
        return AbstractC13042fc3.d(getName(), "<init>") && y().e().isAnnotation();
    }

    public abstract boolean C();

    @Override // ir.nasim.InterfaceC9916am3
    public Object call(Object... objArr) throws IllegalCallableAccessException {
        AbstractC13042fc3.i(objArr, "args");
        try {
            return x().call(objArr);
        } catch (IllegalAccessException e) {
            throw new IllegalCallableAccessException(e);
        }
    }

    @Override // ir.nasim.InterfaceC9916am3
    public Object callBy(Map map) {
        AbstractC13042fc3.i(map, "args");
        return B() ? i(map) : o(map, null);
    }

    @Override // ir.nasim.InterfaceC9326Zl3
    public List getAnnotations() {
        Object objInvoke = this.a.invoke();
        AbstractC13042fc3.h(objInvoke, "_annotations()");
        return (List) objInvoke;
    }

    @Override // ir.nasim.InterfaceC9916am3
    public List getParameters() {
        Object objInvoke = this.b.invoke();
        AbstractC13042fc3.h(objInvoke, "_parameters()");
        return (List) objInvoke;
    }

    @Override // ir.nasim.InterfaceC9916am3
    public InterfaceC5941Lm3 getReturnType() {
        Object objInvoke = this.c.invoke();
        AbstractC13042fc3.h(objInvoke, "_returnType()");
        return (InterfaceC5941Lm3) objInvoke;
    }

    @Override // ir.nasim.InterfaceC9916am3
    public List getTypeParameters() {
        Object objInvoke = this.d.invoke();
        AbstractC13042fc3.h(objInvoke, "_typeParameters()");
        return (List) objInvoke;
    }

    @Override // ir.nasim.InterfaceC9916am3
    public EnumC8560Wm3 getVisibility() {
        RI1 visibility = A().getVisibility();
        AbstractC13042fc3.h(visibility, "descriptor.visibility");
        return AbstractC14729iN7.n(visibility);
    }

    @Override // ir.nasim.InterfaceC9916am3
    public boolean isAbstract() {
        return A().r() == EnumC11067cg4.ABSTRACT;
    }

    @Override // ir.nasim.InterfaceC9916am3
    public boolean isFinal() {
        return A().r() == EnumC11067cg4.FINAL;
    }

    @Override // ir.nasim.InterfaceC9916am3
    public boolean isOpen() {
        return A().r() == EnumC11067cg4.OPEN;
    }

    public final Object o(Map map, InterfaceC20295rm1 interfaceC20295rm1) throws IllegalCallableAccessException {
        AbstractC13042fc3.i(map, "args");
        List parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator it = parameters.iterator();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                if (interfaceC20295rm1 != null) {
                    arrayList.add(interfaceC20295rm1);
                }
                if (!z) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    if (array != null) {
                        return call(Arrays.copyOf(array, array.length));
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                arrayList2.add(Integer.valueOf(i2));
                InterfaceC18740pA0 interfaceC18740pA0Z = z();
                if (interfaceC18740pA0Z == null) {
                    throw new C25175zr3("This callable does not support a default call: " + A());
                }
                arrayList.addAll(arrayList2);
                arrayList.add(null);
                try {
                    Object[] array2 = arrayList.toArray(new Object[0]);
                    if (array2 != null) {
                        return interfaceC18740pA0Z.call(array2);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                } catch (IllegalAccessException e) {
                    throw new IllegalCallableAccessException(e);
                }
            }
            InterfaceC3347Am3 interfaceC3347Am3 = (InterfaceC3347Am3) it.next();
            if (i != 0 && i % 32 == 0) {
                arrayList2.add(Integer.valueOf(i2));
                i2 = 0;
            }
            if (map.containsKey(interfaceC3347Am3)) {
                arrayList.add(map.get(interfaceC3347Am3));
            } else if (interfaceC3347Am3.w()) {
                arrayList.add(AbstractC14729iN7.h(interfaceC3347Am3.getType()) ? null : AbstractC14729iN7.d(VL5.a(interfaceC3347Am3.getType())));
                i2 = (1 << (i % 32)) | i2;
                z = true;
            } else {
                if (!interfaceC3347Am3.c()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + interfaceC3347Am3);
                }
                arrayList.add(t(interfaceC3347Am3.getType()));
            }
            if (interfaceC3347Am3.f() == InterfaceC3347Am3.a.c) {
                i++;
            }
        }
    }

    public abstract InterfaceC18740pA0 x();

    public abstract AbstractC16142km3 y();

    public abstract InterfaceC18740pA0 z();
}
