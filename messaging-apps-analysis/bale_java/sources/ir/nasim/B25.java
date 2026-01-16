package ir.nasim;

import livekit.org.webrtc.PeerConnection;

/* loaded from: classes3.dex */
public abstract class B25 {

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(!AbstractC22919w25.c((PeerConnection.PeerConnectionState) this.c));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(PeerConnection.PeerConnectionState peerConnectionState, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(peerConnectionState, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(A25 a25, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objK = AbstractC6459Nq2.k(AbstractC6459Nq2.q0(AbstractC5508Jq2.e(new AbstractC24042xw5(a25) { // from class: ir.nasim.B25.a
            @Override // ir.nasim.InterfaceC3820Cm3
            public Object get() {
                return ((A25) this.receiver).a();
            }
        }), new b(null)), interfaceC20295rm1);
        return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
    }
}
