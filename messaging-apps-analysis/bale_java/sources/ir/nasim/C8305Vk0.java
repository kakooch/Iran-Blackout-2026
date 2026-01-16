package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC13042fc3;

/* renamed from: ir.nasim.Vk0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8305Vk0 extends e.c implements InterfaceC6886Pk0, InterfaceC9398Zt3 {
    private InterfaceC8071Uk0 o;
    private final boolean p;
    private boolean q;

    /* renamed from: ir.nasim.Vk0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC11379cu3 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ SA2 g;

        /* renamed from: ir.nasim.Vk0$a$a, reason: collision with other inner class name */
        static final class C0713a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C8305Vk0 c;
            final /* synthetic */ InterfaceC11379cu3 d;
            final /* synthetic */ SA2 e;

            /* renamed from: ir.nasim.Vk0$a$a$a, reason: collision with other inner class name */
            /* synthetic */ class C0714a extends EB2 implements SA2 {
                final /* synthetic */ C8305Vk0 a;
                final /* synthetic */ InterfaceC11379cu3 b;
                final /* synthetic */ SA2 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0714a(C8305Vk0 c8305Vk0, InterfaceC11379cu3 interfaceC11379cu3, SA2 sa2) {
                    super(0, AbstractC13042fc3.a.class, "localRect", "bringIntoView$localRect(Landroidx/compose/foundation/relocation/BringIntoViewResponderNode;Landroidx/compose/ui/layout/LayoutCoordinates;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/geometry/Rect;", 0);
                    this.a = c8305Vk0;
                    this.b = interfaceC11379cu3;
                    this.c = sa2;
                }

                @Override // ir.nasim.SA2
                /* renamed from: y, reason: merged with bridge method [inline-methods] */
                public final CK5 invoke() {
                    return C8305Vk0.w2(this.a, this.b, this.c);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0713a(C8305Vk0 c8305Vk0, InterfaceC11379cu3 interfaceC11379cu3, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c8305Vk0;
                this.d = interfaceC11379cu3;
                this.e = sa2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0713a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC8071Uk0 interfaceC8071Uk0X2 = this.c.x2();
                    C0714a c0714a = new C0714a(this.c, this.d, this.e);
                    this.b = 1;
                    if (interfaceC8071Uk0X2.F0(c0714a, this) == objE) {
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
                return ((C0713a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Vk0$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C8305Vk0 c;
            final /* synthetic */ SA2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C8305Vk0 c8305Vk0, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c8305Vk0;
                this.d = sa2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C8305Vk0 c8305Vk0 = this.c;
                    SA2 sa2 = this.d;
                    this.b = 1;
                    if (AbstractC7130Qk0.a(c8305Vk0, sa2, this) == objE) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC11379cu3 interfaceC11379cu3, SA2 sa2, SA2 sa22, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC11379cu3;
            this.f = sa2;
            this.g = sa22;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C8305Vk0.this.new a(this.e, this.f, this.g, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C0713a(C8305Vk0.this, this.e, this.f, null), 3, null);
            return AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(C8305Vk0.this, this.g, null), 3, null);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Vk0$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC11379cu3 f;
        final /* synthetic */ SA2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC11379cu3 interfaceC11379cu3, SA2 sa2) {
            super(0);
            this.f = interfaceC11379cu3;
            this.g = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CK5 invoke() {
            CK5 ck5W2 = C8305Vk0.w2(C8305Vk0.this, this.f, this.g);
            if (ck5W2 != null) {
                return C8305Vk0.this.x2().Z(ck5W2);
            }
            return null;
        }
    }

    public C8305Vk0(InterfaceC8071Uk0 interfaceC8071Uk0) {
        this.o = interfaceC8071Uk0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CK5 w2(C8305Vk0 c8305Vk0, InterfaceC11379cu3 interfaceC11379cu3, SA2 sa2) {
        CK5 ck5;
        if (!c8305Vk0.b2() || !c8305Vk0.q) {
            return null;
        }
        InterfaceC11379cu3 interfaceC11379cu3M = KG1.m(c8305Vk0);
        if (!interfaceC11379cu3.b()) {
            interfaceC11379cu3 = null;
        }
        if (interfaceC11379cu3 == null || (ck5 = (CK5) sa2.invoke()) == null) {
            return null;
        }
        return AbstractC7837Tk0.b(interfaceC11379cu3M, interfaceC11379cu3, ck5);
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return this.p;
    }

    @Override // ir.nasim.InterfaceC9398Zt3
    public void l0(InterfaceC11379cu3 interfaceC11379cu3) {
        this.q = true;
    }

    @Override // ir.nasim.InterfaceC6886Pk0
    public Object q1(InterfaceC11379cu3 interfaceC11379cu3, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new a(interfaceC11379cu3, sa2, new b(interfaceC11379cu3, sa2), null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    public final InterfaceC8071Uk0 x2() {
        return this.o;
    }
}
