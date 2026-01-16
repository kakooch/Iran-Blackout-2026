package ir.nasim;

import ai.bale.proto.MeetStruct$Call;
import ir.nasim.AbstractC21761u53;
import ir.nasim.AbstractC7031Pz0;
import ir.nasim.InterfaceC9449Zz0;
import java.util.List;

/* loaded from: classes5.dex */
public final class A08 extends AbstractC21707u0 {
    private final C9057Yh4 b;
    private final InterfaceC9173Yu3 c;
    private final InterfaceC9173Yu3 d;
    private final InterfaceC8327Vm4 e;
    private final InterfaceC10040ay6 f;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;
        final /* synthetic */ boolean e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
            this.e = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return A08.this.new a(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return A08.this.M().m(this.d, this.e);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return A08.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return A08.this.M().n(this.d);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A08(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
        this.b = c9057Yh4;
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.x08
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return A08.a0(this.a);
            }
        });
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.y08
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return A08.Z(this.a);
            }
        });
        InterfaceC8327Vm4 interfaceC8327Vm4A = AbstractC11420cy6.a(0, 1, EnumC6162Ml0.DROP_OLDEST);
        this.e = interfaceC8327Vm4A;
        this.f = AbstractC6459Nq2.b(interfaceC8327Vm4A);
    }

    private final C9528a7 F() {
        C9528a7 c9528a7F = C12736f7.n().f("actor/voice_call", C4614Fw5.d(new V6() { // from class: ir.nasim.z08
            @Override // ir.nasim.V6
            public final K6 create() {
                return A08.G(this.a);
            }
        }));
        AbstractC13042fc3.h(c9528a7F, "actorOf(...)");
        return c9528a7F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 G(A08 a08) {
        AbstractC13042fc3.i(a08, "this$0");
        return new C22306v08(a08.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C22902w08 M() {
        return (C22902w08) this.d.getValue();
    }

    private final C9528a7 N() {
        return (C9528a7) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C22902w08 Z(A08 a08) {
        AbstractC13042fc3.i(a08, "this$0");
        return new C22902w08(a08.N());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C9528a7 a0(A08 a08) {
        AbstractC13042fc3.i(a08, "this$0");
        return a08.F();
    }

    public final C6517Nv5 D(long j) {
        return M().j(j);
    }

    public final void H(long j, K04 k04) {
        AbstractC13042fc3.i(k04, "reason");
        M().l(j, k04);
    }

    public final Object I(List list, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.c(), new a(list, z, null), interfaceC20295rm1);
    }

    public final Object J(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.c(), new b(i, null), interfaceC20295rm1);
    }

    public final InterfaceC10040ay6 K() {
        return this.f;
    }

    public final C6517Nv5 L(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return M().o(c11458d25);
    }

    public final C6517Nv5 O(long j, String str) {
        AbstractC13042fc3.i(str, "myName");
        return M().p(j, str);
    }

    public final void P(long j, boolean z) {
        M().q(j, z);
    }

    public final C6517Nv5 Q(AbstractC20556sC7 abstractC20556sC7) {
        AbstractC13042fc3.i(abstractC20556sC7, "update");
        if (abstractC20556sC7 instanceof OC7) {
            this.e.c(new InterfaceC9449Zz0.c(AbstractC20975sv0.a(((OC7) abstractC20556sC7).a()), null));
            return C6517Nv5.l0(C14505i18.a);
        }
        if (abstractC20556sC7 instanceof QC7) {
            if (C8386Vt0.a.n5()) {
                MeetStruct$Call meetStruct$CallA = ((QC7) abstractC20556sC7).a();
                this.e.c(new InterfaceC9449Zz0.e(new AbstractC21761u53.c(meetStruct$CallA.getId(), meetStruct$CallA.getAdminUid(), meetStruct$CallA.getCreateDate(), meetStruct$CallA.getVideo() ? AbstractC7031Pz0.c.b : AbstractC7031Pz0.e.b)));
            } else {
                M().r(abstractC20556sC7);
            }
            return C6517Nv5.l0(C14505i18.a);
        }
        if (abstractC20556sC7 instanceof GC7) {
            if (!C8386Vt0.a.n5()) {
                return M().r(abstractC20556sC7);
            }
            this.e.c(new InterfaceC9449Zz0.d(((GC7) abstractC20556sC7).a()));
            return C6517Nv5.l0(C14505i18.a);
        }
        if (!(abstractC20556sC7 instanceof KC7)) {
            return M().r(abstractC20556sC7);
        }
        KC7 kc7 = (KC7) abstractC20556sC7;
        this.e.c(new InterfaceC9449Zz0.b(kc7.a(), kc7.b()));
        return C6517Nv5.l0(C14505i18.a);
    }

    public final void R(long j) {
        M().s(j);
    }

    public final void S() {
        M().k();
    }

    public final void T() {
        M().t();
    }

    public final void U(long j, String str, boolean z, int i, boolean z2) {
        AbstractC13042fc3.i(str, "opinion");
        M().u(j, str, z, i, z2);
    }

    public final void V(long j) {
        M().v(j);
    }

    public final C6517Nv5 W(C11458d25 c11458d25, EnumC13941h47 enumC13941h47, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(enumC13941h47, "switchType");
        return M().w(c11458d25, enumC13941h47, z);
    }

    public final C6517Nv5 X(C11458d25 c11458d25, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        return M().x(c11458d25, z);
    }

    public final C6517Nv5 Y(List list) {
        AbstractC13042fc3.i(list, "peers");
        return M().y(list);
    }
}
