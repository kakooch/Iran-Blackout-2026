package ir.nasim;

import androidx.compose.foundation.gestures.DraggableElement;

/* loaded from: classes.dex */
public abstract class NZ1 {
    private static final InterfaceC15796kB2 a = new a(null);
    private static final InterfaceC15796kB2 b = new b(null);

    static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        public final Object n(InterfaceC20315ro1 interfaceC20315ro1, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(interfaceC20295rm1).invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((InterfaceC20315ro1) obj, ((ZG4) obj2).t(), (InterfaceC20295rm1) obj3);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        public final Object n(InterfaceC20315ro1 interfaceC20315ro1, float f, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(interfaceC20295rm1).invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((InterfaceC20315ro1) obj, ((Number) obj2).floatValue(), (InterfaceC20295rm1) obj3);
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC9664aL6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC9664aL6 interfaceC9664aL6) {
            super(1);
            this.e = interfaceC9664aL6;
        }

        public final void a(float f) {
            ((UA2) this.e.getValue()).invoke(Float.valueOf(f));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).floatValue());
            return C19938rB7.a;
        }
    }

    public static final OZ1 a(UA2 ua2) {
        return new JD1(ua2);
    }

    public static final androidx.compose.ui.e g(androidx.compose.ui.e eVar, OZ1 oz1, EnumC24286yM4 enumC24286yM4, boolean z, InterfaceC18507om4 interfaceC18507om4, boolean z2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC15796kB2 interfaceC15796kB22, boolean z3) {
        return eVar.i(new DraggableElement(oz1, enumC24286yM4, z, interfaceC18507om4, z2, interfaceC15796kB2, interfaceC15796kB22, z3));
    }

    public static final OZ1 i(UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-183245213, i, -1, "androidx.compose.foundation.gestures.rememberDraggableState (Draggable.kt:127)");
        }
        InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(ua2, interfaceC22053ub1, i & 14);
        Object objB = interfaceC22053ub1.B();
        if (objB == InterfaceC22053ub1.a.a()) {
            objB = a(new c(interfaceC9664aL6Q));
            interfaceC22053ub1.s(objB);
        }
        OZ1 oz1 = (OZ1) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return oz1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float j(long j, EnumC24286yM4 enumC24286yM4) {
        return Float.intBitsToFloat((int) (enumC24286yM4 == EnumC24286yM4.a ? j & 4294967295L : j >> 32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float k(long j, EnumC24286yM4 enumC24286yM4) {
        return enumC24286yM4 == EnumC24286yM4.a ? C17718nR7.i(j) : C17718nR7.h(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(long j) {
        return AbstractC18309oR7.a(Float.isNaN(C17718nR7.h(j)) ? 0.0f : C17718nR7.h(j), Float.isNaN(C17718nR7.i(j)) ? 0.0f : C17718nR7.i(j));
    }
}
