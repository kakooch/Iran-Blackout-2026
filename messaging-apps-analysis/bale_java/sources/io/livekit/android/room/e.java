package io.livekit.android.room;

import io.livekit.android.room.a;
import ir.nasim.A25;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5270Ip7;
import ir.nasim.AbstractC5508Jq2;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C19938rB7;
import ir.nasim.C5942Lm4;
import ir.nasim.C9927an4;
import ir.nasim.EnumC17606nF3;
import ir.nasim.FF5;
import ir.nasim.IF5;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.UI3;
import livekit.org.webrtc.CandidatePairChangeEvent;
import livekit.org.webrtc.DataChannel;
import livekit.org.webrtc.IceCandidate;
import livekit.org.webrtc.MediaStream;
import livekit.org.webrtc.PeerConnection;
import livekit.org.webrtc.RtpReceiver;
import livekit.org.webrtc.RtpTransceiver;
import livekit.org.webrtc.SessionDescription;

/* loaded from: classes3.dex */
public final class e implements PeerConnection.Observer, a.b, A25 {
    static final /* synthetic */ InterfaceC5239Im3[] f = {AbstractC10882cM5.f(new C5942Lm4(e.class, "connectionState", "getConnectionState()Llivekit/org/webrtc/PeerConnection$PeerConnectionState;", 0))};
    private final f a;
    private final l b;
    private final FF5 c;
    private UA2 d;
    private final C9927an4 e;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ PeerConnection.PeerConnectionState f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(PeerConnection.PeerConnectionState peerConnectionState) {
            super(0);
            this.f = peerConnectionState;
        }

        public final void a() {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            PeerConnection.PeerConnectionState peerConnectionState = this.f;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.k(null, "onConnection new state: " + peerConnectionState, new Object[0]);
            }
            UA2 ua2F = e.this.f();
            if (ua2F != null) {
                ua2F.invoke(this.f);
            }
            e.this.h(this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ IceCandidate e;
        final /* synthetic */ e f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(IceCandidate iceCandidate, e eVar) {
            super(0);
            this.e = iceCandidate;
            this.f = eVar;
        }

        public final void a() {
            IceCandidate iceCandidate = this.e;
            if (iceCandidate == null) {
                return;
            }
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.k(null, "onIceCandidate: " + iceCandidate, new Object[0]);
            }
            this.f.b.C(iceCandidate, EnumC17606nF3.PUBLISHER);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SessionDescription f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(SessionDescription sessionDescription) {
            super(0);
            this.f = sessionDescription;
        }

        public final void a() {
            e.this.b.F(this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        d() {
            super(0);
        }

        public final void a() {
            e.this.a.E0();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public e(f fVar, l lVar, FF5 ff5) {
        AbstractC13042fc3.i(fVar, "engine");
        AbstractC13042fc3.i(lVar, "client");
        AbstractC13042fc3.i(ff5, "rtcThreadToken");
        this.a = fVar;
        this.b = lVar;
        this.c = ff5;
        this.e = AbstractC5508Jq2.c(PeerConnection.PeerConnectionState.NEW, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(PeerConnection.PeerConnectionState peerConnectionState) {
        this.e.i(this, f[0], peerConnectionState);
    }

    @Override // ir.nasim.A25
    public PeerConnection.PeerConnectionState a() {
        return (PeerConnection.PeerConnectionState) this.e.h(this, f[0]);
    }

    @Override // io.livekit.android.room.a.b
    public void c(SessionDescription sessionDescription) {
        AbstractC13042fc3.i(sessionDescription, "sd");
        IF5.d(this.c, new c(sessionDescription));
    }

    public final UA2 f() {
        return this.d;
    }

    public final void g(UA2 ua2) {
        this.d = ua2;
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onAddStream(MediaStream mediaStream) {
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
        AbstractC13042fc3.i(peerConnectionState, "newState");
        IF5.d(this.c, new a(peerConnectionState));
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onDataChannel(DataChannel dataChannel) {
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onIceCandidate(IceCandidate iceCandidate) {
        IF5.d(this.c, new b(iceCandidate, this));
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onIceCandidatesRemoved(IceCandidate[] iceCandidateArr) {
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
            return;
        }
        AbstractC5270Ip7.k(null, "onIceConnection new state: " + iceConnectionState, new Object[0]);
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onIceConnectionReceivingChange(boolean z) {
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onIceGatheringChange(PeerConnection.IceGatheringState iceGatheringState) {
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onRemoveStream(MediaStream mediaStream) {
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onRenegotiationNeeded() {
        IF5.d(this.c, new d());
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onSelectedCandidatePairChanged(CandidatePairChangeEvent candidatePairChangeEvent) {
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onSignalingChange(PeerConnection.SignalingState signalingState) {
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onStandardizedIceConnectionChange(PeerConnection.IceConnectionState iceConnectionState) {
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onTrack(RtpTransceiver rtpTransceiver) {
    }
}
