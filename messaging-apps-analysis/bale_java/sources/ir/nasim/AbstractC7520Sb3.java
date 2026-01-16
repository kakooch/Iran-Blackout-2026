package ir.nasim;

import ir.nasim.AbstractC19331qA0;
import ir.nasim.InterfaceC18740pA0;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.Sb3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7520Sb3 implements InterfaceC18740pA0 {
    private final Type a;
    private final Method b;
    private final List c;

    /* renamed from: ir.nasim.Sb3$a */
    public static final class a extends AbstractC7520Sb3 implements InterfaceC22142uk0 {
        private final Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Method method, Object obj) {
            super(method, AbstractC10360bX0.m(), null);
            AbstractC13042fc3.i(method, "unboxMethod");
            this.d = obj;
        }

        @Override // ir.nasim.InterfaceC18740pA0
        public Object call(Object[] objArr) {
            AbstractC13042fc3.i(objArr, "args");
            d(objArr);
            return c(this.d, objArr);
        }
    }

    /* renamed from: ir.nasim.Sb3$b */
    public static final class b extends AbstractC7520Sb3 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Method method) {
            super(method, AbstractC9766aX0.e(method.getDeclaringClass()), null);
            AbstractC13042fc3.i(method, "unboxMethod");
        }

        @Override // ir.nasim.InterfaceC18740pA0
        public Object call(Object[] objArr) {
            Object[] objArrS;
            AbstractC13042fc3.i(objArr, "args");
            d(objArr);
            Object obj = objArr[0];
            AbstractC19331qA0.d dVar = AbstractC19331qA0.e;
            if (objArr.length <= 1) {
                objArrS = new Object[0];
            } else {
                objArrS = AbstractC9648aK.s(objArr, 1, objArr.length);
                if (objArrS == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            return c(obj, objArrS);
        }
    }

    private AbstractC7520Sb3(Method method, List list) {
        this.b = method;
        this.c = list;
        Class<?> returnType = method.getReturnType();
        AbstractC13042fc3.h(returnType, "unboxMethod.returnType");
        this.a = returnType;
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public final List a() {
        return this.c;
    }

    protected final Object c(Object obj, Object[] objArr) {
        AbstractC13042fc3.i(objArr, "args");
        return this.b.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public void d(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "args");
        InterfaceC18740pA0.a.a(this, objArr);
    }

    @Override // ir.nasim.InterfaceC18740pA0
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Method b() {
        return null;
    }

    @Override // ir.nasim.InterfaceC18740pA0
    public final Type getReturnType() {
        return this.a;
    }

    public /* synthetic */ AbstractC7520Sb3(Method method, List list, ED1 ed1) {
        this(method, list);
    }
}
