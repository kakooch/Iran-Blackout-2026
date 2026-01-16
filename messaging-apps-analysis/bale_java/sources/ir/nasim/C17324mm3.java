package ir.nasim;

import ir.nasim.AbstractC10266bM5;
import ir.nasim.AbstractC19331qA0;
import ir.nasim.AbstractC5698Kl3;
import ir.nasim.C19764qu;
import ir.nasim.GB2;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.mm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17324mm3 extends AbstractC10536bm3 implements InterfaceC23005wB2, InterfaceC16733lm3, GB2 {
    static final /* synthetic */ InterfaceC5239Im3[] k = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C17324mm3.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C17324mm3.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C17324mm3.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    private final AbstractC10266bM5.a e;
    private final AbstractC10266bM5.b f;
    private final AbstractC10266bM5.b g;
    private final AbstractC16142km3 h;
    private final String i;
    private final Object j;

    /* renamed from: ir.nasim.mm3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC18740pA0 invoke() throws NoSuchMethodException, SecurityException {
            Object objB;
            InterfaceC18740pA0 interfaceC18740pA0J;
            AbstractC5698Kl3 abstractC5698Kl3G = A76.b.g(C17324mm3.this.A());
            if (abstractC5698Kl3G instanceof AbstractC5698Kl3.d) {
                if (C17324mm3.this.B()) {
                    Class clsE = C17324mm3.this.y().e();
                    List parameters = C17324mm3.this.getParameters();
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(parameters, 10));
                    Iterator it = parameters.iterator();
                    while (it.hasNext()) {
                        String name = ((InterfaceC3347Am3) it.next()).getName();
                        AbstractC13042fc3.f(name);
                        arrayList.add(name);
                    }
                    return new C19764qu(clsE, arrayList, C19764qu.a.POSITIONAL_CALL, C19764qu.b.KOTLIN, null, 16, null);
                }
                objB = C17324mm3.this.y().j(((AbstractC5698Kl3.d) abstractC5698Kl3G).b());
            } else if (abstractC5698Kl3G instanceof AbstractC5698Kl3.e) {
                AbstractC5698Kl3.e eVar = (AbstractC5698Kl3.e) abstractC5698Kl3G;
                objB = C17324mm3.this.y().r(eVar.c(), eVar.b());
            } else if (abstractC5698Kl3G instanceof AbstractC5698Kl3.c) {
                objB = ((AbstractC5698Kl3.c) abstractC5698Kl3G).b();
            } else {
                if (!(abstractC5698Kl3G instanceof AbstractC5698Kl3.b)) {
                    if (!(abstractC5698Kl3G instanceof AbstractC5698Kl3.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    List listB = ((AbstractC5698Kl3.a) abstractC5698Kl3G).b();
                    Class clsE2 = C17324mm3.this.y().e();
                    List<Method> list = listB;
                    ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list, 10));
                    for (Method method : list) {
                        AbstractC13042fc3.h(method, "it");
                        arrayList2.add(method.getName());
                    }
                    return new C19764qu(clsE2, arrayList2, C19764qu.a.POSITIONAL_CALL, C19764qu.b.JAVA, listB);
                }
                objB = ((AbstractC5698Kl3.b) abstractC5698Kl3G).b();
            }
            if (objB instanceof Constructor) {
                C17324mm3 c17324mm3 = C17324mm3.this;
                interfaceC18740pA0J = c17324mm3.I((Constructor) objB, c17324mm3.A());
            } else {
                if (!(objB instanceof Method)) {
                    throw new C25175zr3("Could not compute caller for function: " + C17324mm3.this.A() + " (member = " + objB + ')');
                }
                Method method2 = (Method) objB;
                interfaceC18740pA0J = !Modifier.isStatic(method2.getModifiers()) ? C17324mm3.this.J(method2) : C17324mm3.this.A().getAnnotations().z(AbstractC14729iN7.g()) != null ? C17324mm3.this.K(method2) : C17324mm3.this.L(method2);
            }
            return I73.c(interfaceC18740pA0J, C17324mm3.this.A(), false, 2, null);
        }
    }

    /* renamed from: ir.nasim.mm3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x0139  */
        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final ir.nasim.InterfaceC18740pA0 invoke() {
            /*
                Method dump skipped, instructions count: 336
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17324mm3.b.invoke():ir.nasim.pA0");
        }
    }

    /* renamed from: ir.nasim.mm3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.f = str;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AB2 invoke() {
            return C17324mm3.this.y().q(this.f, C17324mm3.this.i);
        }
    }

    /* synthetic */ C17324mm3(AbstractC16142km3 abstractC16142km3, String str, String str2, AB2 ab2, Object obj, int i, ED1 ed1) {
        this(abstractC16142km3, str, str2, ab2, (i & 16) != 0 ? AbstractC15785kA0.NO_RECEIVER : obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC19331qA0 I(Constructor constructor, AB2 ab2) {
        return Q73.f(ab2) ? C() ? new AbstractC19331qA0.a(constructor, M()) : new AbstractC19331qA0.b(constructor) : C() ? new AbstractC19331qA0.c(constructor, M()) : new AbstractC19331qA0.e(constructor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC19331qA0.h J(Method method) {
        return C() ? new AbstractC19331qA0.h.a(method, M()) : new AbstractC19331qA0.h.d(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC19331qA0.h K(Method method) {
        return C() ? new AbstractC19331qA0.h.b(method) : new AbstractC19331qA0.h.e(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC19331qA0.h L(Method method) {
        return C() ? new AbstractC19331qA0.h.c(method, M()) : new AbstractC19331qA0.h.f(method);
    }

    private final Object M() {
        return I73.a(this.j, A());
    }

    @Override // ir.nasim.AbstractC10536bm3
    public boolean C() {
        return !AbstractC13042fc3.d(this.j, AbstractC15785kA0.NO_RECEIVER);
    }

    @Override // ir.nasim.AbstractC10536bm3
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public AB2 D() {
        return (AB2) this.e.b(this, k[0]);
    }

    @Override // ir.nasim.InterfaceC16978mB2
    public Object e(Object obj, Object obj2, Object obj3, Object obj4) {
        return GB2.a.e(this, obj, obj2, obj3, obj4);
    }

    public boolean equals(Object obj) {
        C17324mm3 c17324mm3A = AbstractC14729iN7.a(obj);
        return c17324mm3A != null && AbstractC13042fc3.d(y(), c17324mm3A.y()) && AbstractC13042fc3.d(getName(), c17324mm3A.getName()) && AbstractC13042fc3.d(this.i, c17324mm3A.i) && AbstractC13042fc3.d(this.j, c17324mm3A.j);
    }

    @Override // ir.nasim.InterfaceC23005wB2
    public int getArity() {
        return AbstractC19922rA0.a(x());
    }

    @Override // ir.nasim.InterfaceC9916am3
    public String getName() {
        String strH = A().getName().h();
        AbstractC13042fc3.h(strH, "descriptor.name.asString()");
        return strH;
    }

    public int hashCode() {
        return (((y().hashCode() * 31) + getName().hashCode()) * 31) + this.i.hashCode();
    }

    @Override // ir.nasim.SA2
    public Object invoke() {
        return GB2.a.a(this);
    }

    @Override // ir.nasim.InterfaceC16733lm3
    public boolean isExternal() {
        return A().isExternal();
    }

    @Override // ir.nasim.InterfaceC16733lm3
    public boolean isInfix() {
        return A().isInfix();
    }

    @Override // ir.nasim.InterfaceC16733lm3
    public boolean isInline() {
        return A().isInline();
    }

    @Override // ir.nasim.InterfaceC16733lm3
    public boolean isOperator() {
        return A().isOperator();
    }

    @Override // ir.nasim.InterfaceC16733lm3
    public boolean isSuspend() {
        return A().isSuspend();
    }

    @Override // ir.nasim.InterfaceC19342qB2
    public Object j(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return GB2.a.g(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // ir.nasim.InterfaceC19933rB2
    public Object l(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return GB2.a.h(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // ir.nasim.InterfaceC15796kB2
    public Object q(Object obj, Object obj2, Object obj3) {
        return GB2.a.d(this, obj, obj2, obj3);
    }

    @Override // ir.nasim.WA2
    public Object r(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        return GB2.a.i(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // ir.nasim.InterfaceC18160oB2
    public Object s(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return GB2.a.f(this, obj, obj2, obj3, obj4, obj5);
    }

    public String toString() {
        return C15307jM5.b.d(A());
    }

    @Override // ir.nasim.AbstractC10536bm3
    public InterfaceC18740pA0 x() {
        return (InterfaceC18740pA0) this.f.b(this, k[1]);
    }

    @Override // ir.nasim.AbstractC10536bm3
    public AbstractC16142km3 y() {
        return this.h;
    }

    @Override // ir.nasim.AbstractC10536bm3
    public InterfaceC18740pA0 z() {
        return (InterfaceC18740pA0) this.g.b(this, k[2]);
    }

    private C17324mm3(AbstractC16142km3 abstractC16142km3, String str, String str2, AB2 ab2, Object obj) {
        this.h = abstractC16142km3;
        this.i = str2;
        this.j = obj;
        this.e = AbstractC10266bM5.d(ab2, new c(str));
        this.f = AbstractC10266bM5.b(new a());
        this.g = AbstractC10266bM5.b(new b());
    }

    @Override // ir.nasim.UA2
    public Object invoke(Object obj) {
        return GB2.a.b(this, obj);
    }

    @Override // ir.nasim.InterfaceC14603iB2
    public Object invoke(Object obj, Object obj2) {
        return GB2.a.c(this, obj, obj2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C17324mm3(AbstractC16142km3 abstractC16142km3, String str, String str2, Object obj) {
        this(abstractC16142km3, str, str2, null, obj);
        AbstractC13042fc3.i(abstractC16142km3, "container");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C17324mm3(AbstractC16142km3 abstractC16142km3, AB2 ab2) {
        AbstractC13042fc3.i(abstractC16142km3, "container");
        AbstractC13042fc3.i(ab2, "descriptor");
        String strH = ab2.getName().h();
        AbstractC13042fc3.h(strH, "descriptor.name.asString()");
        this(abstractC16142km3, strH, A76.b.g(ab2).a(), ab2, null, 16, null);
    }
}
