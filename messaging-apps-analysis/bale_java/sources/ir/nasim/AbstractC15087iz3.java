package ir.nasim;

/* renamed from: ir.nasim.iz3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15087iz3 implements InterfaceC20315ro1 {

    /* renamed from: ir.nasim.iz3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AbstractC15087iz3.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                androidx.lifecycle.j jVarA = AbstractC15087iz3.this.a();
                InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                this.b = 1;
                if (androidx.lifecycle.u.a(jVarA, interfaceC14603iB2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.iz3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AbstractC15087iz3.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                androidx.lifecycle.j jVarA = AbstractC15087iz3.this.a();
                InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                this.b = 1;
                if (androidx.lifecycle.u.b(jVarA, interfaceC14603iB2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.iz3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AbstractC15087iz3.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                androidx.lifecycle.j jVarA = AbstractC15087iz3.this.a();
                InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                this.b = 1;
                if (androidx.lifecycle.u.c(jVarA, interfaceC14603iB2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public abstract androidx.lifecycle.j a();

    public final InterfaceC13730gj3 b(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        return AbstractC10533bm0.d(this, null, null, new a(interfaceC14603iB2, null), 3, null);
    }

    public final InterfaceC13730gj3 d(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        return AbstractC10533bm0.d(this, null, null, new b(interfaceC14603iB2, null), 3, null);
    }

    public final InterfaceC13730gj3 e(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        return AbstractC10533bm0.d(this, null, null, new c(interfaceC14603iB2, null), 3, null);
    }
}
