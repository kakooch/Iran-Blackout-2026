package io.livekit.android.room;

import io.livekit.android.room.f;
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
import livekit.org.webrtc.MediaStreamTrack;
import livekit.org.webrtc.PeerConnection;
import livekit.org.webrtc.RtpReceiver;
import livekit.org.webrtc.RtpTransceiver;

/* loaded from: classes3.dex */
public final class m implements PeerConnection.Observer, A25 {
    static final /* synthetic */ InterfaceC5239Im3[] g = {AbstractC10882cM5.f(new C5942Lm4(m.class, "connectionState", "getConnectionState()Llivekit/org/webrtc/PeerConnection$PeerConnectionState;", 0))};
    private final f a;
    private final l b;
    private final FF5 c;
    private UA2 d;
    private UA2 e;
    private final C9927an4 f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MediaStreamTrack.MediaType.values().length];
            try {
                iArr[MediaStreamTrack.MediaType.MEDIA_TYPE_AUDIO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaStreamTrack.MediaType.MEDIA_TYPE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ RtpReceiver e;
        final /* synthetic */ m f;
        final /* synthetic */ MediaStream[] g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(RtpReceiver rtpReceiver, m mVar, MediaStream[] mediaStreamArr) {
            super(0);
            this.e = rtpReceiver;
            this.f = mVar;
            this.g = mediaStreamArr;
        }

        public final void a() {
            MediaStreamTrack mediaStreamTrackTrack = this.e.track();
            if (mediaStreamTrackTrack == null) {
                return;
            }
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            MediaStream[] mediaStreamArr = this.g;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("onAddTrack: ");
                sb.append(mediaStreamTrackTrack.kind());
                sb.append(", ");
                sb.append(mediaStreamTrackTrack.id());
                sb.append(", ");
                String str = "";
                for (MediaStream mediaStream : mediaStreamArr) {
                    str = str + ", " + mediaStream;
                }
                sb.append(str);
                AbstractC5270Ip7.k(null, sb.toString(), new Object[0]);
            }
            f.d dVarU0 = this.f.a.u0();
            if (dVarU0 != null) {
                dVarU0.p(this.e, mediaStreamTrackTrack, this.g);
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ PeerConnection.PeerConnectionState f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(PeerConnection.PeerConnectionState peerConnectionState) {
            super(0);
            this.f = peerConnectionState;
        }

        public final void a() {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            PeerConnection.PeerConnectionState peerConnectionState = this.f;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.k(null, "onConnectionChange new state: " + peerConnectionState, new Object[0]);
            }
            UA2 ua2E = m.this.e();
            if (ua2E != null) {
                ua2E.invoke(this.f);
            }
            m.this.h(this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ DataChannel f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(DataChannel dataChannel) {
            super(0);
            this.f = dataChannel;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19938rB7 invoke() {
            UA2 ua2F = m.this.f();
            if (ua2F == null) {
                return null;
            }
            ua2F.invoke(this.f);
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ IceCandidate f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(IceCandidate iceCandidate) {
            super(0);
            this.f = iceCandidate;
        }

        public final void a() {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            IceCandidate iceCandidate = this.f;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.k(null, "onIceCandidate: " + iceCandidate, new Object[0]);
            }
            m.this.b.C(this.f, EnumC17606nF3.SUBSCRIBER);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public m(f fVar, l lVar, FF5 ff5) {
        AbstractC13042fc3.i(fVar, "engine");
        AbstractC13042fc3.i(lVar, "client");
        AbstractC13042fc3.i(ff5, "rtcThreadToken");
        this.a = fVar;
        this.b = lVar;
        this.c = ff5;
        this.f = AbstractC5508Jq2.c(PeerConnection.PeerConnectionState.NEW, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(PeerConnection.PeerConnectionState peerConnectionState) {
        this.f.i(this, g[0], peerConnectionState);
    }

    @Override // ir.nasim.A25
    public PeerConnection.PeerConnectionState a() {
        return (PeerConnection.PeerConnectionState) this.f.h(this, g[0]);
    }

    public final UA2 e() {
        return this.e;
    }

    public final UA2 f() {
        return this.d;
    }

    public final void g(UA2 ua2) {
        this.e = ua2;
    }

    public final void i(UA2 ua2) {
        this.d = ua2;
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onAddStream(MediaStream mediaStream) {
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onAddTrack(RtpReceiver rtpReceiver, MediaStream[] mediaStreamArr) {
        AbstractC13042fc3.i(rtpReceiver, "receiver");
        AbstractC13042fc3.i(mediaStreamArr, "streams");
        IF5.d(this.c, new b(rtpReceiver, this, mediaStreamArr));
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onConnectionChange(PeerConnection.PeerConnectionState peerConnectionState) {
        AbstractC13042fc3.i(peerConnectionState, "newState");
        IF5.d(this.c, new c(peerConnectionState));
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onDataChannel(DataChannel dataChannel) {
        AbstractC13042fc3.i(dataChannel, "channel");
        IF5.d(this.c, new d(dataChannel));
    }

    @Override // livekit.org.webrtc.PeerConnection.Observer
    public void onIceCandidate(IceCandidate iceCandidate) {
        AbstractC13042fc3.i(iceCandidate, "candidate");
        IF5.d(this.c, new e(iceCandidate));
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
        AbstractC13042fc3.i(rtpTransceiver, "transceiver");
        MediaStreamTrack.MediaType mediaType = rtpTransceiver.getMediaType();
        int i = mediaType == null ? -1 : a.a[mediaType.ordinal()];
        if (i == 1) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.k(null, "peerconn started receiving audio", new Object[0]);
            return;
        }
        if (i == 2) {
            AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.k(null, "peerconn started receiving video", new Object[0]);
            return;
        }
        AbstractC6718Or3.a aVar3 = AbstractC6718Or3.Companion;
        if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
            return;
        }
        AbstractC5270Ip7.d(null, "peerconn started receiving unknown media type: " + rtpTransceiver.getMediaType(), new Object[0]);
    }
}
