package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.El, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4275El {
    private final InterfaceC19083pl a;

    /* renamed from: ir.nasim.El$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ XV4 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j, long j2, XV4 xv4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
            this.f = xv4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4275El.this.new a(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19083pl interfaceC19083pl = C4275El.this.a;
                G g = new G(this.d, this.e, ((Number) this.f.e()).longValue(), ((Number) this.f.f()).longValue());
                this.b = 1;
                if (interfaceC19083pl.d(g, this) == objE) {
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

    /* renamed from: ir.nasim.El$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ XV4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j, XV4 xv4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = xv4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4275El.this.new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC19083pl interfaceC19083pl = C4275El.this.a;
                long j = this.d;
                long jLongValue = ((Number) this.e.e()).longValue();
                long jLongValue2 = ((Number) this.e.f()).longValue();
                this.b = 1;
                obj = interfaceC19083pl.c(j, jLongValue, jLongValue2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.El$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ C4275El f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list, long j, long j2, C4275El c4275El, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = j;
            this.e = j2;
            this.f = c4275El;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List<XV4> list = this.c;
                long j = this.d;
                long j2 = this.e;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (XV4 xv4 : list) {
                    arrayList.add(new G(j, j2, ((Number) xv4.e()).longValue(), ((Number) xv4.f()).longValue()));
                    j2 = j2;
                }
                InterfaceC19083pl interfaceC19083pl = this.f.a;
                this.b = 1;
                if (interfaceC19083pl.b(arrayList, this) == objE) {
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

    public C4275El(InterfaceC19083pl interfaceC19083pl) {
        AbstractC13042fc3.i(interfaceC19083pl, "albumIdToMessageIdDao");
        this.a = interfaceC19083pl;
    }

    public final void b(long j, long j2, XV4 xv4) {
        AbstractC13042fc3.i(xv4, "messageRidDate");
        AbstractC9913am0.b(null, new a(j, j2, xv4, null), 1, null);
    }

    public final Long c(long j, XV4 xv4) {
        AbstractC13042fc3.i(xv4, "messageRidDate");
        return (Long) AbstractC9913am0.b(null, new b(j, xv4, null), 1, null);
    }

    public final void d(long j, long j2, List list) {
        AbstractC13042fc3.i(list, "messagesRidDate");
        AbstractC9913am0.b(null, new c(list, j, j2, this, null), 1, null);
    }
}
