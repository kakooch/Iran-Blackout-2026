package ir.nasim;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.rpc.Status;
import ir.nasim.core.network.RpcException;

/* renamed from: ir.nasim.u0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC21707u0 {
    private final InterfaceC7803Tg4 a;

    /* renamed from: ir.nasim.u0$a */
    class a implements O66 {
        final /* synthetic */ C7234Qv5 a;

        a(C7234Qv5 c7234Qv5) {
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

    /* renamed from: ir.nasim.u0$b */
    class b implements O66 {
        final /* synthetic */ C22871vx5 a;
        final /* synthetic */ C7234Qv5 b;

        b(C22871vx5 c22871vx5, C7234Qv5 c7234Qv5) {
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
                    C19406qI3.d("AbsModule", e);
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
                C19406qI3.d("AbsModule", e2);
            }
        }
    }

    public AbstractC21707u0(InterfaceC7803Tg4 interfaceC7803Tg4) {
        this.a = interfaceC7803Tg4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(TP5 tp5, int i, long j, C7234Qv5 c7234Qv5) {
        w(tp5, new a(c7234Qv5), i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(C22871vx5 c22871vx5, long j, C7234Qv5 c7234Qv5) {
        this.a.b().h(c22871vx5, new b(c22871vx5, c7234Qv5), j, -1L);
    }

    public C6517Nv5 q(TP5 tp5) {
        return r(tp5, 16500);
    }

    public C6517Nv5 r(TP5 tp5, int i) {
        return s(tp5, i, -1L);
    }

    public C6517Nv5 s(final TP5 tp5, final int i, final long j) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.t0
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.t(tp5, i, j, c7234Qv5);
            }
        });
    }

    public InterfaceC3570Bk5 v() {
        return this.a.c();
    }

    public long w(TP5 tp5, O66 o66, long j, long j2) {
        return this.a.b().j(tp5, o66, j, j2);
    }

    public C6517Nv5 x(C22871vx5 c22871vx5) {
        return y(c22871vx5, 16500L);
    }

    public C6517Nv5 y(final C22871vx5 c22871vx5, final long j) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.s0
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.u(c22871vx5, j, c7234Qv5);
            }
        });
    }

    public void z(Runnable runnable) {
        AbstractC20507s76.z(runnable);
    }
}
