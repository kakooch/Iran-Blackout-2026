package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.lifecycle.j;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10721c52;
import ir.nasim.AbstractC11024cc1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19810qy7;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC22421vC5;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.C6558Oa1;
import ir.nasim.C7252Qx5;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC6806Pb1;
import ir.nasim.S93;
import ir.nasim.UA2;
import java.util.Set;

/* loaded from: classes2.dex */
final class z implements InterfaceC6806Pb1, androidx.lifecycle.n {
    private final AndroidComposeView a;
    private final InterfaceC6806Pb1 b;
    private boolean c;
    private androidx.lifecycle.j d;
    private InterfaceC14603iB2 e = C6558Oa1.a.a();

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC14603iB2 f;

        /* renamed from: androidx.compose.ui.platform.z$a$a, reason: collision with other inner class name */
        static final class C0068a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ z e;
            final /* synthetic */ InterfaceC14603iB2 f;

            /* renamed from: androidx.compose.ui.platform.z$a$a$a, reason: collision with other inner class name */
            static final class C0069a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ z c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0069a(z zVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = zVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0069a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        AndroidComposeView androidComposeViewE = this.c.E();
                        this.b = 1;
                        if (androidComposeViewE.m0(this) == objE) {
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
                    return ((C0069a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: androidx.compose.ui.platform.z$a$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ z c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(z zVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = zVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new b(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        AndroidComposeView androidComposeViewE = this.c.E();
                        this.b = 1;
                        if (androidComposeViewE.n0(this) == objE) {
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

            /* renamed from: androidx.compose.ui.platform.z$a$a$c */
            static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
                final /* synthetic */ z e;
                final /* synthetic */ InterfaceC14603iB2 f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(z zVar, InterfaceC14603iB2 interfaceC14603iB2) {
                    super(2);
                    this.e = zVar;
                    this.f = interfaceC14603iB2;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.Q(-1193460702, i, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous>.<anonymous> (Wrapper.android.kt:139)");
                    }
                    AndroidCompositionLocals_androidKt.a(this.e.E(), this.f, interfaceC22053ub1, 0);
                    if (AbstractC5138Ib1.I()) {
                        AbstractC5138Ib1.P();
                    }
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0068a(z zVar, InterfaceC14603iB2 interfaceC14603iB2) {
                super(2);
                this.e = zVar;
                this.f = interfaceC14603iB2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-2000640158, i, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:123)");
                }
                Object tag = this.e.E().getTag(AbstractC22421vC5.inspection_slot_table_set);
                Set set = AbstractC19810qy7.q(tag) ? (Set) tag : null;
                if (set == null) {
                    Object parent = this.e.E().getParent();
                    View view = parent instanceof View ? (View) parent : null;
                    Object tag2 = view != null ? view.getTag(AbstractC22421vC5.inspection_slot_table_set) : null;
                    set = AbstractC19810qy7.q(tag2) ? (Set) tag2 : null;
                }
                if (set != null) {
                    set.add(interfaceC22053ub1.C());
                    interfaceC22053ub1.x();
                }
                AndroidComposeView androidComposeViewE = this.e.E();
                boolean zD = interfaceC22053ub1.D(this.e);
                z zVar = this.e;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new C0069a(zVar, null);
                    interfaceC22053ub1.s(objB);
                }
                AbstractC10721c52.e(androidComposeViewE, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
                AndroidComposeView androidComposeViewE2 = this.e.E();
                boolean zD2 = interfaceC22053ub1.D(this.e);
                z zVar2 = this.e;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new b(zVar2, null);
                    interfaceC22053ub1.s(objB2);
                }
                AbstractC10721c52.e(androidComposeViewE2, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
                AbstractC11024cc1.a(S93.a().d(set), AbstractC19242q11.e(-1193460702, true, new c(this.e, this.f), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2) {
            super(1);
            this.f = interfaceC14603iB2;
        }

        public final void a(AndroidComposeView.C1928b c1928b) {
            if (z.this.c) {
                return;
            }
            androidx.lifecycle.j lifecycle = c1928b.a().getLifecycle();
            z.this.e = this.f;
            if (z.this.d == null) {
                z.this.d = lifecycle;
                lifecycle.a(z.this);
            } else if (lifecycle.b().j(j.b.CREATED)) {
                z.this.D().l(AbstractC19242q11.c(-2000640158, true, new C0068a(z.this, this.f)));
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AndroidComposeView.C1928b) obj);
            return C19938rB7.a;
        }
    }

    public z(AndroidComposeView androidComposeView, InterfaceC6806Pb1 interfaceC6806Pb1) {
        this.a = androidComposeView;
        this.b = interfaceC6806Pb1;
    }

    public final InterfaceC6806Pb1 D() {
        return this.b;
    }

    public final AndroidComposeView E() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC6806Pb1
    public void dispose() {
        if (!this.c) {
            this.c = true;
            this.a.getView().setTag(AbstractC22421vC5.wrapped_composition_tag, null);
            androidx.lifecycle.j jVar = this.d;
            if (jVar != null) {
                jVar.d(this);
            }
        }
        this.b.dispose();
    }

    @Override // ir.nasim.InterfaceC6806Pb1
    public void l(InterfaceC14603iB2 interfaceC14603iB2) {
        this.a.setOnViewTreeOwnersAvailable(new a(interfaceC14603iB2));
    }

    @Override // androidx.lifecycle.n
    public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
        if (aVar == j.a.ON_DESTROY) {
            dispose();
        } else {
            if (aVar != j.a.ON_CREATE || this.c) {
                return;
            }
            l(this.e);
        }
    }
}
