package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.zk6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C25108zk6 {
    private final C12842fG3 a;
    private final long b;
    private final C11458d25 c;
    private final ExPeerType d;
    private final long e;

    /* renamed from: ir.nasim.zk6$a */
    public interface a {
        C25108zk6 a(long j, C11458d25 c11458d25, ExPeerType exPeerType, long j2);
    }

    /* renamed from: ir.nasim.zk6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C25108zk6.this.new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C12842fG3 c12842fG3 = C25108zk6.this.a;
                long j = C25108zk6.this.b;
                C11458d25 c11458d25 = C25108zk6.this.c;
                ExPeerType exPeerType = C25108zk6.this.d;
                long j2 = C25108zk6.this.e;
                int i2 = this.d;
                int i3 = this.e;
                this.b = 1;
                obj = c12842fG3.d(j, c11458d25, exPeerType, j2, i2, i3, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            XV4 xv4 = (XV4) obj;
            return xv4 == null ? AbstractC4616Fw7.a(AbstractC10360bX0.m(), AbstractC6392Nk0.d(0)) : xv4;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C25108zk6(C12842fG3 c12842fG3, long j, C11458d25 c11458d25, ExPeerType exPeerType, long j2) {
        AbstractC13042fc3.i(c12842fG3, "loadSeenListRepository");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, "exPeer");
        this.a = c12842fG3;
        this.b = j;
        this.c = c11458d25;
        this.d = exPeerType;
        this.e = j2;
    }

    public Object f(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new b(i2, i, null), interfaceC20295rm1);
    }
}
