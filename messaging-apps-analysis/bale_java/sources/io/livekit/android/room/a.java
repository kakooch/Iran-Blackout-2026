package io.livekit.android.room;

import androidx.recyclerview.widget.RecyclerView;
import io.livekit.android.room.n;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC22183uo1;
import ir.nasim.AbstractC22919w25;
import ir.nasim.AbstractC24126y52;
import ir.nasim.AbstractC25143zo1;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9913am0;
import ir.nasim.C12889fL5;
import ir.nasim.C19938rB7;
import ir.nasim.C23425wt7;
import ir.nasim.C25;
import ir.nasim.C25048ze6;
import ir.nasim.FF5;
import ir.nasim.IF5;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.P17;
import ir.nasim.SA2;
import ir.nasim.UA2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import livekit.org.webrtc.IceCandidate;
import livekit.org.webrtc.MediaConstraints;
import livekit.org.webrtc.PeerConnection;
import livekit.org.webrtc.PeerConnectionFactory;
import livekit.org.webrtc.SessionDescription;

/* loaded from: classes3.dex */
public final class a {
    private final b a;
    private final AbstractC13778go1 b;
    private final C25048ze6 c;
    private final FF5 d;
    private final InterfaceC20315ro1 e;
    private final PeerConnection f;
    private final List g;
    private boolean h;
    private boolean i;
    private Map j;
    private AtomicBoolean k;
    private final UA2 l;

    /* renamed from: io.livekit.android.room.a$a, reason: collision with other inner class name */
    public interface InterfaceC0209a {
        a a(PeerConnection.RTCConfiguration rTCConfiguration, PeerConnection.Observer observer, b bVar);
    }

    public interface b {
        void c(SessionDescription sessionDescription);
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ IceCandidate f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(IceCandidate iceCandidate) {
            super(0);
            this.f = iceCandidate;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf((a.this.q().getRemoteDescription() == null || a.this.h) ? a.this.g.add(this.f) : a.this.q().addIceCandidate(this.f));
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            a.this.k.set(true);
            a.this.q().dispose();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                a aVar = a.this;
                this.b = 1;
                if (aVar.k(this) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return a.this.m(null, this);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ MediaConstraints d;
        final /* synthetic */ a e;
        final /* synthetic */ C12889fL5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(MediaConstraints mediaConstraints, a aVar, C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = mediaConstraints;
            this.e = aVar;
            this.f = c12889fL5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.d, this.e, this.f, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x012f  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws android.javax.sdp.SdpException {
            /*
                Method dump skipped, instructions count: 368
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.a.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class h implements Callable {
        final /* synthetic */ FF5 a;
        final /* synthetic */ a b;
        final /* synthetic */ SA2 c;

        public h(FF5 ff5, a aVar, SA2 sa2) {
            this.a = ff5;
            this.b = aVar;
            this.c = sa2;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            if (this.a.a() || this.b.s()) {
                return null;
            }
            return this.c.invoke();
        }
    }

    static final class i extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return a.this.r(this);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return a.this.q().iceConnectionState();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return a.this.t(this);
        }
    }

    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return AbstractC6392Nk0.a(AbstractC22919w25.d(a.this.q()));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            m mVar = a.this.new m(interfaceC20295rm1);
            mVar.c = obj;
            return mVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MediaConstraints mediaConstraints = (MediaConstraints) this.c;
                if (mediaConstraints != null) {
                    a aVar = a.this;
                    this.b = 1;
                    if (aVar.m(mediaConstraints, this) == objE) {
                        return objE;
                    }
                } else {
                    a aVar2 = a.this;
                    this.b = 2;
                    if (a.n(aVar2, null, this, 1, null) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(MediaConstraints mediaConstraints, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(mediaConstraints, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class n extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        boolean d;
        /* synthetic */ Object e;
        int g;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return a.this.w(null, null, false, this);
        }
    }

    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ a d;
        final /* synthetic */ SessionDescription e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(boolean z, a aVar, SessionDescription sessionDescription, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = aVar;
            this.e = sessionDescription;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new o(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    AbstractC10685c16.b(obj);
                    return (AbstractC24126y52) obj;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return (AbstractC24126y52) obj;
            }
            AbstractC10685c16.b(obj);
            if (this.c) {
                PeerConnection peerConnectionQ = this.d.q();
                SessionDescription sessionDescription = this.e;
                this.b = 1;
                obj = AbstractC22183uo1.d(peerConnectionQ, sessionDescription, this);
                if (obj == objE) {
                    return objE;
                }
                return (AbstractC24126y52) obj;
            }
            PeerConnection peerConnectionQ2 = this.d.q();
            SessionDescription sessionDescription2 = this.e;
            this.b = 2;
            obj = AbstractC22183uo1.c(peerConnectionQ2, sessionDescription2, this);
            if (obj == objE) {
                return objE;
            }
            return (AbstractC24126y52) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ a d;
        final /* synthetic */ SessionDescription e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(boolean z, a aVar, SessionDescription sessionDescription, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = aVar;
            this.e = sessionDescription;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new p(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0) {
                if (i == 1) {
                    AbstractC10685c16.b(obj);
                    return (AbstractC24126y52) obj;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return (AbstractC24126y52) obj;
            }
            AbstractC10685c16.b(obj);
            if (this.c) {
                PeerConnection peerConnectionQ = this.d.q();
                SessionDescription sessionDescription = this.e;
                this.b = 1;
                obj = AbstractC22183uo1.d(peerConnectionQ, sessionDescription, this);
                if (obj == objE) {
                    return objE;
                }
                return (AbstractC24126y52) obj;
            }
            PeerConnection peerConnectionQ2 = this.d.q();
            SessionDescription sessionDescription2 = this.e;
            this.b = 2;
            obj = AbstractC22183uo1.c(peerConnectionQ2, sessionDescription2, this);
            if (obj == objE) {
                return objE;
            }
            return (AbstractC24126y52) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class q extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return a.this.y(null, this);
        }
    }

    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ SessionDescription d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(SessionDescription sessionDescription, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = sessionDescription;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new r(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                PeerConnection peerConnectionQ = a.this.q();
                SessionDescription sessionDescription = this.d;
                this.b = 1;
                obj = AbstractC22183uo1.d(peerConnectionQ, sessionDescription, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            AbstractC24126y52 abstractC24126y52 = (AbstractC24126y52) obj;
            if (abstractC24126y52 instanceof AbstractC24126y52.a) {
                List list = a.this.g;
                a aVar = a.this;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    aVar.q().addIceCandidate((IceCandidate) it.next());
                }
                a.this.g.clear();
                a.this.h = false;
            }
            return abstractC24126y52;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class s extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return a.this.z(this);
        }
    }

    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        t(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new t(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return a.this.q().signalingState();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class u implements Callable {
        final /* synthetic */ FF5 a;
        final /* synthetic */ PeerConnectionFactory b;
        final /* synthetic */ PeerConnection.RTCConfiguration c;
        final /* synthetic */ PeerConnection.Observer d;

        public u(FF5 ff5, PeerConnectionFactory peerConnectionFactory, PeerConnection.RTCConfiguration rTCConfiguration, PeerConnection.Observer observer) {
            this.a = ff5;
            this.b = peerConnectionFactory;
            this.c = rTCConfiguration;
            this.d = observer;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            if (this.a.a()) {
                return null;
            }
            PeerConnection peerConnectionCreatePeerConnection = this.b.createPeerConnection(this.c, this.d);
            if (peerConnectionCreatePeerConnection != null) {
                return peerConnectionCreatePeerConnection;
            }
            throw new IllegalStateException("peer connection creation failed?");
        }
    }

    static final class v extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ PeerConnection.RTCConfiguration f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(PeerConnection.RTCConfiguration rTCConfiguration) {
            super(0);
            this.f = rTCConfiguration;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf(a.this.q().setConfiguration(this.f));
        }
    }

    static final class w extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC14603iB2 c;
        final /* synthetic */ a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(InterfaceC14603iB2 interfaceC14603iB2, a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC14603iB2;
            this.d = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new w(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC14603iB2 interfaceC14603iB2 = this.c;
                PeerConnection peerConnectionQ = this.d.q();
                this.b = 1;
                obj = interfaceC14603iB2.invoke(peerConnectionQ, this);
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
            return ((w) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public a(PeerConnection.RTCConfiguration rTCConfiguration, PeerConnection.Observer observer, b bVar, AbstractC13778go1 abstractC13778go1, PeerConnectionFactory peerConnectionFactory, C25048ze6 c25048ze6, FF5 ff5) throws ExecutionException, InterruptedException {
        Object objCreatePeerConnection;
        AbstractC13042fc3.i(rTCConfiguration, "config");
        AbstractC13042fc3.i(observer, "pcObserver");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(peerConnectionFactory, "connectionFactory");
        AbstractC13042fc3.i(c25048ze6, "sdpFactory");
        AbstractC13042fc3.i(ff5, "rtcThreadToken");
        this.a = bVar;
        this.b = abstractC13778go1;
        this.c = c25048ze6;
        this.d = ff5;
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC20906so1.a(abstractC13778go1.X(P17.b(null, 1, null)));
        this.e = interfaceC20315ro1A;
        if (ff5.a()) {
            objCreatePeerConnection = null;
        } else {
            String name = Thread.currentThread().getName();
            AbstractC13042fc3.h(name, "getName(...)");
            if (AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
                objCreatePeerConnection = peerConnectionFactory.createPeerConnection(rTCConfiguration, observer);
                if (objCreatePeerConnection == null) {
                    throw new IllegalStateException("peer connection creation failed?");
                }
            } else {
                objCreatePeerConnection = IF5.b.submit(new u(ff5, peerConnectionFactory, rTCConfiguration, observer)).get();
            }
        }
        AbstractC13042fc3.f(objCreatePeerConnection);
        this.f = (PeerConnection) objCreatePeerConnection;
        this.g = new ArrayList();
        this.j = new LinkedHashMap();
        this.k = new AtomicBoolean(false);
        this.l = AbstractC25143zo1.a(20L, interfaceC20315ro1A, new m(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(livekit.org.webrtc.MediaConstraints r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.livekit.android.room.a.f
            if (r0 == 0) goto L13
            r0 = r8
            io.livekit.android.room.a$f r0 = (io.livekit.android.room.a.f) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.livekit.android.room.a$f r0 = new io.livekit.android.room.a$f
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.b
            ir.nasim.fL5 r7 = (ir.nasim.C12889fL5) r7
            java.lang.Object r0 = r0.a
            io.livekit.android.room.a r0 = (io.livekit.android.room.a) r0
            ir.nasim.AbstractC10685c16.b(r8)
            goto L6c
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            ir.nasim.AbstractC10685c16.b(r8)
            io.livekit.android.room.a$b r8 = r6.a
            if (r8 != 0) goto L43
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        L43:
            ir.nasim.fL5 r8 = new ir.nasim.fL5
            r8.<init>()
            io.livekit.android.room.a$g r2 = new io.livekit.android.room.a$g
            r4 = 0
            r2.<init>(r7, r6, r8, r4)
            boolean r7 = r6.s()
            if (r7 == 0) goto L56
            r0 = r6
            goto L6d
        L56:
            ir.nasim.FF5 r7 = r6.d
            ir.nasim.C25 r5 = new ir.nasim.C25
            r5.<init>(r6, r2, r4)
            r0.a = r6
            r0.b = r8
            r0.e = r3
            java.lang.Object r7 = ir.nasim.IF5.f(r7, r5, r0)
            if (r7 != r1) goto L6a
            return r1
        L6a:
            r0 = r6
            r7 = r8
        L6c:
            r8 = r7
        L6d:
            java.lang.Object r7 = r8.a
            if (r7 == 0) goto L7b
            io.livekit.android.room.a$b r8 = r0.a
            ir.nasim.AbstractC13042fc3.f(r7)
            livekit.org.webrtc.SessionDescription r7 = (livekit.org.webrtc.SessionDescription) r7
            r8.c(r7)
        L7b:
            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.a.m(livekit.org.webrtc.MediaConstraints, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object n(a aVar, MediaConstraints mediaConstraints, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mediaConstraints = new MediaConstraints();
        }
        return aVar.m(mediaConstraints, interfaceC20295rm1);
    }

    private final Object o(SA2 sa2) {
        if (s()) {
            return null;
        }
        FF5 ff5 = this.d;
        if (ff5.a()) {
            return null;
        }
        String name = Thread.currentThread().getName();
        AbstractC13042fc3.h(name, "getName(...)");
        if (!AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
            return IF5.b.submit(new h(ff5, this, sa2)).get();
        }
        if (s()) {
            return null;
        }
        return sa2.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(livekit.org.webrtc.SessionDescription r20, java.lang.String r21, boolean r22, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            Method dump skipped, instructions count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.a.w(livekit.org.webrtc.SessionDescription, java.lang.String, boolean, ir.nasim.rm1):java.lang.Object");
    }

    static /* synthetic */ Object x(a aVar, SessionDescription sessionDescription, String str, boolean z, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return aVar.w(sessionDescription, str, z, interfaceC20295rm1);
    }

    public final void A(PeerConnection.RTCConfiguration rTCConfiguration) {
        AbstractC13042fc3.i(rTCConfiguration, "config");
        o(new v(rTCConfiguration));
    }

    public final Object B(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        w wVar = new w(interfaceC14603iB2, this, null);
        if (s()) {
            return null;
        }
        return IF5.f(this.d, new C25(this, wVar, null), interfaceC20295rm1);
    }

    public final void j(IceCandidate iceCandidate) {
        AbstractC13042fc3.i(iceCandidate, "candidate");
        o(new c(iceCandidate));
    }

    public final Object k(InterfaceC20295rm1 interfaceC20295rm1) {
        d dVar = new d(null);
        if (s()) {
            return null;
        }
        return IF5.f(this.d, new C25(this, dVar, null), interfaceC20295rm1);
    }

    public final void l() {
        AbstractC9913am0.b(null, new e(null), 1, null);
    }

    public final UA2 p() {
        return this.l;
    }

    public final PeerConnection q() {
        return this.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof io.livekit.android.room.a.i
            if (r0 == 0) goto L13
            r0 = r7
            io.livekit.android.room.a$i r0 = (io.livekit.android.room.a.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            io.livekit.android.room.a$i r0 = new io.livekit.android.room.a$i
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L51
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            io.livekit.android.room.a$j r7 = new io.livekit.android.room.a$j
            r2 = 0
            r7.<init>(r2)
            boolean r4 = r6.s()
            if (r4 == 0) goto L41
            goto L52
        L41:
            ir.nasim.FF5 r4 = r6.d
            ir.nasim.C25 r5 = new ir.nasim.C25
            r5.<init>(r6, r7, r2)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.IF5.f(r4, r5, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r2 = r7
        L52:
            livekit.org.webrtc.PeerConnection$IceConnectionState r2 = (livekit.org.webrtc.PeerConnection.IceConnectionState) r2
            if (r2 != 0) goto L58
            livekit.org.webrtc.PeerConnection$IceConnectionState r2 = livekit.org.webrtc.PeerConnection.IceConnectionState.CLOSED
        L58:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.a.r(ir.nasim.rm1):java.lang.Object");
    }

    public final boolean s() {
        return this.k.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof io.livekit.android.room.a.k
            if (r0 == 0) goto L13
            r0 = r7
            io.livekit.android.room.a$k r0 = (io.livekit.android.room.a.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            io.livekit.android.room.a$k r0 = new io.livekit.android.room.a$k
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L51
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            io.livekit.android.room.a$l r7 = new io.livekit.android.room.a$l
            r2 = 0
            r7.<init>(r2)
            boolean r4 = r6.s()
            if (r4 == 0) goto L41
            goto L52
        L41:
            ir.nasim.FF5 r4 = r6.d
            ir.nasim.C25 r5 = new ir.nasim.C25
            r5.<init>(r6, r7, r2)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.IF5.f(r4, r5, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r2 = r7
        L52:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            if (r2 == 0) goto L5b
            boolean r7 = r2.booleanValue()
            goto L5c
        L5b:
            r7 = 0
        L5c:
            java.lang.Boolean r7 = ir.nasim.AbstractC6392Nk0.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.a.t(ir.nasim.rm1):java.lang.Object");
    }

    public final void u() {
        this.h = true;
    }

    public final void v(String str, C23425wt7 c23425wt7) {
        AbstractC13042fc3.i(str, "cid");
        AbstractC13042fc3.i(c23425wt7, "trackBitrateInfo");
        this.j.put(new n.a(str), c23425wt7);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(livekit.org.webrtc.SessionDescription r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.livekit.android.room.a.q
            if (r0 == 0) goto L13
            r0 = r8
            io.livekit.android.room.a$q r0 = (io.livekit.android.room.a.q) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            io.livekit.android.room.a$q r0 = new io.livekit.android.room.a$q
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.a
            ir.nasim.y52 r7 = (ir.nasim.AbstractC24126y52) r7
            ir.nasim.AbstractC10685c16.b(r8)
            goto L83
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            java.lang.Object r7 = r0.a
            io.livekit.android.room.a r7 = (io.livekit.android.room.a) r7
            ir.nasim.AbstractC10685c16.b(r8)
            goto L65
        L41:
            ir.nasim.AbstractC10685c16.b(r8)
            io.livekit.android.room.a$r r8 = new io.livekit.android.room.a$r
            r8.<init>(r7, r5)
            boolean r7 = r6.s()
            if (r7 == 0) goto L52
            r7 = r6
            r8 = r5
            goto L65
        L52:
            ir.nasim.FF5 r7 = r6.d
            ir.nasim.C25 r2 = new ir.nasim.C25
            r2.<init>(r6, r8, r5)
            r0.a = r6
            r0.d = r4
            java.lang.Object r8 = ir.nasim.IF5.f(r7, r2, r0)
            if (r8 != r1) goto L64
            return r1
        L64:
            r7 = r6
        L65:
            ir.nasim.y52 r8 = (ir.nasim.AbstractC24126y52) r8
            if (r8 != 0) goto L70
            ir.nasim.y52$b r8 = new ir.nasim.y52$b
            java.lang.String r2 = "PCT is closed."
            r8.<init>(r2)
        L70:
            boolean r2 = r7.i
            if (r2 == 0) goto L84
            r2 = 0
            r7.i = r2
            r0.a = r8
            r0.d = r3
            java.lang.Object r7 = n(r7, r5, r0, r4, r5)
            if (r7 != r1) goto L82
            return r1
        L82:
            r7 = r8
        L83:
            r8 = r7
        L84:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.a.y(livekit.org.webrtc.SessionDescription, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof io.livekit.android.room.a.s
            if (r0 == 0) goto L13
            r0 = r7
            io.livekit.android.room.a$s r0 = (io.livekit.android.room.a.s) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            io.livekit.android.room.a$s r0 = new io.livekit.android.room.a$s
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L51
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            io.livekit.android.room.a$t r7 = new io.livekit.android.room.a$t
            r2 = 0
            r7.<init>(r2)
            boolean r4 = r6.s()
            if (r4 == 0) goto L41
            goto L52
        L41:
            ir.nasim.FF5 r4 = r6.d
            ir.nasim.C25 r5 = new ir.nasim.C25
            r5.<init>(r6, r7, r2)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.IF5.f(r4, r5, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            r2 = r7
        L52:
            livekit.org.webrtc.PeerConnection$SignalingState r2 = (livekit.org.webrtc.PeerConnection.SignalingState) r2
            if (r2 != 0) goto L58
            livekit.org.webrtc.PeerConnection$SignalingState r2 = livekit.org.webrtc.PeerConnection.SignalingState.CLOSED
        L58:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.a.z(ir.nasim.rm1):java.lang.Object");
    }
}
