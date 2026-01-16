package ir.nasim;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.rpc.Status;
import ir.nasim.core.network.RpcException;

/* renamed from: ir.nasim.Ng4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC6360Ng4 extends AbstractC17647nK implements InterfaceC3817Cm0 {
    private final InterfaceC7803Tg4 k;
    private InterfaceC3817Cm0 l;

    /* renamed from: ir.nasim.Ng4$a */
    class a implements O66 {
        final /* synthetic */ long a;
        final /* synthetic */ O66 b;

        /* renamed from: ir.nasim.Ng4$a$a, reason: collision with other inner class name */
        class RunnableC0535a implements Runnable {
            final /* synthetic */ AbstractC10365bX5 a;

            RunnableC0535a(AbstractC10365bX5 abstractC10365bX5) {
                this.a = abstractC10365bX5;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.r(a.this.a);
                a.this.b.a(this.a);
            }

            public String toString() {
                return "Response {" + this.a + "}";
            }
        }

        /* renamed from: ir.nasim.Ng4$a$b */
        class b implements Runnable {
            final /* synthetic */ RpcException a;

            b(RpcException rpcException) {
                this.a = rpcException;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.b(this.a);
            }

            public String toString() {
                return "Error {" + this.a + "}";
            }
        }

        a(long j, O66 o66) {
            this.a = j;
            this.b = o66;
        }

        @Override // ir.nasim.O66
        public void b(RpcException rpcException) {
            AbstractC6360Ng4.this.r().d(new b(rpcException));
        }

        @Override // ir.nasim.O66
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC10365bX5 abstractC10365bX5) {
            AbstractC6360Ng4.this.r().d(new RunnableC0535a(abstractC10365bX5));
        }
    }

    /* renamed from: ir.nasim.Ng4$c */
    class c implements O66 {
        final /* synthetic */ C22871vx5 a;
        final /* synthetic */ O66 b;

        c(C22871vx5 c22871vx5, O66 o66) {
            this.a = c22871vx5;
            this.b = o66;
        }

        @Override // ir.nasim.O66
        public void b(RpcException rpcException) {
            this.b.b(rpcException);
        }

        @Override // ir.nasim.O66
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(C15100j06 c15100j06) {
            try {
                this.b.a((com.google.protobuf.P) this.a.c().getParserForType().a(c15100j06.u()));
            } catch (InvalidProtocolBufferException e) {
                this.b.b(new RpcException(e.getMessage(), -1, e.getMessage(), false));
            }
        }
    }

    /* renamed from: ir.nasim.Ng4$d */
    class d implements O66 {
        final /* synthetic */ C7234Qv5 a;

        d(C7234Qv5 c7234Qv5) {
            this.a = c7234Qv5;
        }

        @Override // ir.nasim.O66
        public void b(RpcException rpcException) {
            this.a.a(rpcException);
        }

        @Override // ir.nasim.O66
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC10365bX5 abstractC10365bX5) {
            this.a.b(abstractC10365bX5);
        }
    }

    /* renamed from: ir.nasim.Ng4$e */
    class e implements O66 {
        final /* synthetic */ C22871vx5 a;
        final /* synthetic */ C7234Qv5 b;

        e(C22871vx5 c22871vx5, C7234Qv5 c7234Qv5) {
            this.a = c22871vx5;
            this.b = c7234Qv5;
        }

        @Override // ir.nasim.O66
        public void b(RpcException rpcException) {
            this.b.a(rpcException);
        }

        @Override // ir.nasim.O66
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(C15100j06 c15100j06) {
            if (c15100j06.u().length > 0) {
                try {
                    this.b.b((com.google.protobuf.P) this.a.c().getParserForType().a(c15100j06.u()));
                    return;
                } catch (InvalidProtocolBufferException e) {
                    C19406qI3.d("ModuleActor", e);
                    return;
                }
            }
            if (c15100j06.w().length <= 0) {
                this.b.b(this.a.c());
                return;
            }
            try {
                Status from = Status.parseFrom(c15100j06.w());
                this.b.a(new RpcException(from.getMessage(), from.getCode(), from.getMessage(), false));
            } catch (InvalidProtocolBufferException e2) {
                C19406qI3.d("ModuleActor", e2);
            }
        }
    }

    public AbstractC6360Ng4(InterfaceC7803Tg4 interfaceC7803Tg4) {
        this.k = interfaceC7803Tg4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(TP5 tp5, long j, long j2, C7234Qv5 c7234Qv5) {
        this.k.b().j(tp5, new d(c7234Qv5), j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(C22871vx5 c22871vx5, long j, C7234Qv5 c7234Qv5) {
        this.k.b().h(c22871vx5, new e(c22871vx5, c7234Qv5), j, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(final AbstractC18385oa2 abstractC18385oa2) {
        r().c(new Runnable() { // from class: ir.nasim.Lg4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.T(abstractC18385oa2);
            }
        });
    }

    private void c0() {
        if (this.l != null) {
            this.k.a().i(this.l);
        }
    }

    public C6517Nv5 L(C22871vx5 c22871vx5) {
        return M(c22871vx5, 16500L);
    }

    public C6517Nv5 M(final C22871vx5 c22871vx5, final long j) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Mg4
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.S(c22871vx5, j, c7234Qv5);
            }
        });
    }

    public C6517Nv5 N(TP5 tp5) {
        return P(tp5, 0L, -1L);
    }

    public C6517Nv5 O(TP5 tp5, long j) {
        return P(tp5, j, -1L);
    }

    public C6517Nv5 P(final TP5 tp5, final long j, final long j2) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Kg4
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.R(tp5, j, j2, c7234Qv5);
            }
        });
    }

    public void Q(long j) {
        this.k.b().a(j);
    }

    public InterfaceC3570Bk5 W() {
        return this.k.c();
    }

    public long X(C22871vx5 c22871vx5) {
        return this.k.b().h(c22871vx5, new b(), 0L, -1L);
    }

    public long Y(C22871vx5 c22871vx5, O66 o66, Long l) {
        return this.k.b().h(c22871vx5, new c(c22871vx5, o66), 16500L, l.longValue());
    }

    public long Z(TP5 tp5, O66 o66) {
        return a0(tp5, o66, -1L, 0);
    }

    public long a0(TP5 tp5, O66 o66, long j, int i) {
        return this.k.b().j(tp5, new a(j, o66), i, j);
    }

    public void b0(String str) {
        if (this.l == null) {
            this.l = new InterfaceC3817Cm0() { // from class: ir.nasim.Jg4
                @Override // ir.nasim.InterfaceC3817Cm0
                /* renamed from: g */
                public final void T(AbstractC18385oa2 abstractC18385oa2) {
                    this.a.U(abstractC18385oa2);
                }
            };
        }
        this.k.a().h(this.l, str);
    }

    @Override // ir.nasim.InterfaceC3817Cm0
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void T(AbstractC18385oa2 abstractC18385oa2) {
        if (abstractC18385oa2 instanceof C11963dq6) {
            V();
        }
    }

    @Override // ir.nasim.K6
    public void n() {
        super.n();
        c0();
    }

    public void V() {
    }

    /* renamed from: ir.nasim.Ng4$b */
    class b implements O66 {
        b() {
        }

        @Override // ir.nasim.O66
        public void b(RpcException rpcException) {
        }

        @Override // ir.nasim.O66
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC10365bX5 abstractC10365bX5) {
        }
    }
}
