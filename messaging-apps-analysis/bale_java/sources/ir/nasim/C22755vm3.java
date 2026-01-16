package ir.nasim;

import ir.nasim.AbstractC10266bM5;
import ir.nasim.AbstractC5473Jm3;
import kotlin.reflect.full.IllegalCallableAccessException;

/* renamed from: ir.nasim.vm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22755vm3 extends C4522Fm3 implements InterfaceC22165um3 {
    private final AbstractC10266bM5.b o;

    /* renamed from: ir.nasim.vm3$a */
    public static final class a extends AbstractC5473Jm3.d implements InterfaceC16733lm3, InterfaceC14603iB2 {
        private final C22755vm3 h;

        public a(C22755vm3 c22755vm3) {
            AbstractC13042fc3.i(c22755vm3, "property");
            this.h = c22755vm3;
        }

        @Override // ir.nasim.AbstractC5473Jm3.a
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public C22755vm3 E() {
            return this.h;
        }

        public void H(Object obj, Object obj2) throws IllegalCallableAccessException {
            E().M(obj, obj2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IllegalCallableAccessException {
            H(obj, obj2);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vm3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(C22755vm3.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22755vm3(AbstractC16142km3 abstractC16142km3, String str, String str2, Object obj) {
        super(abstractC16142km3, str, str2, obj);
        AbstractC13042fc3.i(abstractC16142km3, "container");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "signature");
        AbstractC10266bM5.b bVarB = AbstractC10266bM5.b(new b());
        AbstractC13042fc3.h(bVarB, "ReflectProperties.lazy { Setter(this) }");
        this.o = bVarB;
    }

    public a L() {
        Object objInvoke = this.o.invoke();
        AbstractC13042fc3.h(objInvoke, "_setter()");
        return (a) objInvoke;
    }

    public void M(Object obj, Object obj2) throws IllegalCallableAccessException {
        L().call(obj, obj2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C22755vm3(AbstractC16142km3 abstractC16142km3, InterfaceC20989sw5 interfaceC20989sw5) {
        super(abstractC16142km3, interfaceC20989sw5);
        AbstractC13042fc3.i(abstractC16142km3, "container");
        AbstractC13042fc3.i(interfaceC20989sw5, "descriptor");
        AbstractC10266bM5.b bVarB = AbstractC10266bM5.b(new b());
        AbstractC13042fc3.h(bVarB, "ReflectProperties.lazy { Setter(this) }");
        this.o = bVarB;
    }
}
