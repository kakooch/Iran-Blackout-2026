package io.livekit.android.room;

import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.GeneratedMessageLite;
import io.livekit.android.room.RegionSettings;
import io.livekit.android.room.RoomException;
import io.livekit.android.room.a;
import io.livekit.android.room.l;
import io.livekit.android.room.track.TrackException;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14044hF5;
import ir.nasim.AbstractC14251hc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20899sn4;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC22183uo1;
import ir.nasim.AbstractC22919w25;
import ir.nasim.AbstractC24042xw5;
import ir.nasim.AbstractC24126y52;
import ir.nasim.AbstractC24716z52;
import ir.nasim.AbstractC3860Cq7;
import ir.nasim.AbstractC5270Ip7;
import ir.nasim.AbstractC5508Jq2;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9167Yt6;
import ir.nasim.AbstractC9913am0;
import ir.nasim.B25;
import ir.nasim.C12889fL5;
import ir.nasim.C13294fz1;
import ir.nasim.C13885gz1;
import ir.nasim.C14870id1;
import ir.nasim.C19938rB7;
import ir.nasim.C23425wt7;
import ir.nasim.C5675Ki7;
import ir.nasim.C5942Lm4;
import ir.nasim.C7257Qy1;
import ir.nasim.C9475a16;
import ir.nasim.C9927an4;
import ir.nasim.DV;
import ir.nasim.ED1;
import ir.nasim.EnumC10201bF3;
import ir.nasim.EnumC17606nF3;
import ir.nasim.EnumC24439yd1;
import ir.nasim.F26;
import ir.nasim.F92;
import ir.nasim.FF5;
import ir.nasim.G92;
import ir.nasim.IE0;
import ir.nasim.IF5;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC19699qn4;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.K26;
import ir.nasim.OE3;
import ir.nasim.P17;
import ir.nasim.Q12;
import ir.nasim.T12;
import ir.nasim.TJ5;
import ir.nasim.UA2;
import ir.nasim.UI3;
import ir.nasim.UT1;
import ir.nasim.VV0;
import ir.nasim.W12;
import ir.nasim.WA1;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import livekit.LivekitModels$ClientConfiguration;
import livekit.LivekitModels$DataPacket;
import livekit.LivekitModels$Room;
import livekit.LivekitModels$SpeakerInfo;
import livekit.LivekitModels$Transcription;
import livekit.LivekitModels$UserPacket;
import livekit.LivekitRtc$AddTrackRequest;
import livekit.LivekitRtc$DataChannelInfo;
import livekit.LivekitRtc$DataChannelReceiveState;
import livekit.LivekitRtc$ICEServer;
import livekit.LivekitRtc$JoinResponse;
import livekit.LivekitRtc$LeaveRequest;
import livekit.LivekitRtc$ReconnectResponse;
import livekit.LivekitRtc$RegionSettings;
import livekit.LivekitRtc$SessionDescription;
import livekit.LivekitRtc$SubscribedQualityUpdate;
import livekit.LivekitRtc$SubscriptionPermissionUpdate;
import livekit.LivekitRtc$SyncState;
import livekit.LivekitRtc$TrackPublishedResponse;
import livekit.LivekitRtc$TrackSubscribed;
import livekit.LivekitRtc$TrackUnpublishedResponse;
import livekit.LivekitRtc$UpdateSubscription;
import livekit.org.webrtc.DataChannel;
import livekit.org.webrtc.IceCandidate;
import livekit.org.webrtc.MediaConstraints;
import livekit.org.webrtc.MediaStream;
import livekit.org.webrtc.MediaStreamTrack;
import livekit.org.webrtc.PeerConnection;
import livekit.org.webrtc.RTCStatsCollectorCallback;
import livekit.org.webrtc.RtpReceiver;
import livekit.org.webrtc.RtpSender;
import livekit.org.webrtc.RtpTransceiver;
import livekit.org.webrtc.SessionDescription;

/* loaded from: classes3.dex */
public final class f implements l.b {
    private static final long N;
    private static final long O;
    private static final MediaConstraints P;
    private C7257Qy1 A;
    private C7257Qy1 B;
    private C7257Qy1 C;
    private final Object D;
    private int E;
    private final C13294fz1 F;
    private final C5675Ki7 G;
    private boolean H;
    private boolean I;
    private boolean J;
    private VV0 K;
    private InterfaceC19699qn4 L;
    private final io.livekit.android.room.l a;
    private final a.InterfaceC0209a b;
    private final AbstractC13778go1 c;
    private final FF5 d;
    private d e;
    private final C9927an4 f;
    private TJ5 g;
    private InterfaceC13730gj3 h;
    private boolean i;
    private final Map j;
    private io.livekit.android.room.h k;
    private String l;
    private String m;
    private C14870id1 n;
    private K26 o;
    private String p;
    private final io.livekit.android.room.e q;
    private final io.livekit.android.room.m r;
    private a s;
    private a t;
    private DataChannel u;
    private DataChannel v;
    private DataChannel w;
    private DataChannel x;
    private C7257Qy1 y;
    private InterfaceC13730gj3 z;
    static final /* synthetic */ InterfaceC5239Im3[] M = {AbstractC10882cM5.f(new C5942Lm4(f.class, "connectionState", "getConnectionState()Lio/livekit/android/room/ConnectionState;", 0))};
    public static final C3029a Companion = new C3029a(null);

    static final class A extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        A(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            Object objM0 = f.this.M0(null, this);
            return objM0 == AbstractC14862ic3.e() ? objM0 : C9475a16.a(objM0);
        }
    }

    static final class B extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C12889fL5 d;
        final /* synthetic */ C12889fL5 e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ C12889fL5 d;
            final /* synthetic */ C12889fL5 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12889fL5 c12889fL5, C12889fL5 c12889fL52, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12889fL5;
                this.e = c12889fL52;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                PeerConnection peerConnection = (PeerConnection) this.c;
                C12889fL5 c12889fL5 = this.d;
                SessionDescription localDescription = peerConnection.getLocalDescription();
                c12889fL5.a = localDescription != null ? AbstractC9167Yt6.a(localDescription) : null;
                C12889fL5 c12889fL52 = this.e;
                SessionDescription remoteDescription = peerConnection.getRemoteDescription();
                c12889fL52.a = remoteDescription != null ? AbstractC9167Yt6.a(remoteDescription) : null;
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(PeerConnection peerConnection, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(peerConnection, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        B(C12889fL5 c12889fL5, C12889fL5 c12889fL52, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12889fL5;
            this.e = c12889fL52;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new B(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                io.livekit.android.room.a aVar = f.this.t;
                if (aVar == null) {
                    return null;
                }
                a aVar2 = new a(this.d, this.e, null);
                this.b = 1;
                obj = aVar.B(aVar2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return (C19938rB7) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((B) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: io.livekit.android.room.f$a, reason: case insensitive filesystem */
    public static final class C3029a {
        private C3029a() {
        }

        public /* synthetic */ C3029a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: io.livekit.android.room.f$b, reason: case insensitive filesystem */
    private final class C3030b implements DataChannel.Observer {
        private final DataChannel a;
        final /* synthetic */ f b;

        public C3030b(f fVar, DataChannel dataChannel) {
            AbstractC13042fc3.i(dataChannel, "dataChannel");
            this.b = fVar;
            this.a = dataChannel;
        }

        @Override // livekit.org.webrtc.DataChannel.Observer
        public void onBufferedAmountChange(long j) {
            this.b.F0(this.a, j);
        }

        @Override // livekit.org.webrtc.DataChannel.Observer
        public void onMessage(DataChannel.Buffer buffer) {
            AbstractC13042fc3.i(buffer, "p0");
            this.b.G0(this.a, buffer);
        }

        @Override // livekit.org.webrtc.DataChannel.Observer
        public void onStateChange() {
            this.b.H0(this.a);
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ F92 a = G92.a(LivekitModels$DataPacket.b.values());
    }

    public interface d {

        public static final class a {
            public static void a(d dVar) {
            }

            public static void b(d dVar) {
            }
        }

        void D(List list);

        void H();

        void I(Throwable th);

        void J();

        void K(List list);

        void L(LivekitModels$DataPacket livekitModels$DataPacket);

        void M(LivekitModels$DataPacket livekitModels$DataPacket);

        void N();

        void P();

        void b(List list);

        void d(LivekitModels$Room livekitModels$Room);

        void e(LivekitRtc$TrackUnpublishedResponse livekitRtc$TrackUnpublishedResponse);

        void f(List list);

        void g(String str, boolean z);

        void h(LivekitRtc$SubscriptionPermissionUpdate livekitRtc$SubscriptionPermissionUpdate);

        void i(List list);

        void j(LivekitRtc$TrackSubscribed livekitRtc$TrackSubscribed);

        void k(LivekitRtc$SubscribedQualityUpdate livekitRtc$SubscribedQualityUpdate);

        void l(boolean z);

        void m(UT1 ut1);

        void n(LivekitModels$Transcription livekitModels$Transcription);

        void o(LivekitRtc$JoinResponse livekitRtc$JoinResponse);

        void p(RtpReceiver rtpReceiver, MediaStreamTrack mediaStreamTrack, MediaStream[] mediaStreamArr);

        void s();

        void t();

        void x(LivekitModels$UserPacket livekitModels$UserPacket, LivekitModels$DataPacket.b bVar);

        Object y(boolean z, InterfaceC20295rm1 interfaceC20295rm1);
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[LivekitModels$DataPacket.b.values().length];
            try {
                iArr[LivekitModels$DataPacket.b.RELIABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LivekitModels$DataPacket.b.LOSSY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LivekitModels$DataPacket.b.UNRECOGNIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC17606nF3.values().length];
            try {
                iArr2[EnumC17606nF3.PUBLISHER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[EnumC17606nF3.SUBSCRIBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
            int[] iArr3 = new int[LivekitModels$DataPacket.c.values().length];
            try {
                iArr3[LivekitModels$DataPacket.c.SPEAKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[LivekitModels$DataPacket.c.USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[LivekitModels$DataPacket.c.SIP_DTMF.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[LivekitModels$DataPacket.c.TRANSCRIPTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[LivekitModels$DataPacket.c.METRICS.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[LivekitModels$DataPacket.c.CHAT_MESSAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[LivekitModels$DataPacket.c.RPC_REQUEST.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[LivekitModels$DataPacket.c.RPC_ACK.ordinal()] = 8;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[LivekitModels$DataPacket.c.RPC_RESPONSE.ordinal()] = 9;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[LivekitModels$DataPacket.c.VALUE_NOT_SET.ordinal()] = 10;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[LivekitModels$DataPacket.c.STREAM_HEADER.ordinal()] = 11;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[LivekitModels$DataPacket.c.STREAM_CHUNK.ordinal()] = 12;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[LivekitModels$DataPacket.c.STREAM_TRAILER.ordinal()] = 13;
            } catch (NoSuchFieldError unused18) {
            }
            c = iArr3;
        }
    }

    /* renamed from: io.livekit.android.room.f$f, reason: collision with other inner class name */
    static final class C0210f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        int h;
        final /* synthetic */ String j;
        final /* synthetic */ String k;
        final /* synthetic */ EnumC10201bF3 l;
        final /* synthetic */ String m;
        final /* synthetic */ LivekitRtc$AddTrackRequest.b n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0210f(String str, String str2, EnumC10201bF3 enumC10201bF3, String str3, LivekitRtc$AddTrackRequest.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.j = str;
            this.k = str2;
            this.l = enumC10201bF3;
            this.m = str3;
            this.n = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new C0210f(this.j, this.k, this.l, this.m, this.n, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.h;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                f fVar = f.this;
                String str = this.j;
                String str2 = this.k;
                EnumC10201bF3 enumC10201bF3 = this.l;
                String str3 = this.m;
                LivekitRtc$AddTrackRequest.b bVar = this.n;
                this.b = fVar;
                this.c = str;
                this.d = str2;
                this.e = enumC10201bF3;
                this.f = str3;
                this.g = bVar;
                this.h = 1;
                IE0 ie0 = new IE0(AbstractC14251hc3.c(this), 1);
                ie0.w();
                synchronized (fVar.j) {
                    fVar.j.put(str, ie0);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
                fVar.s0().A(str, str2, enumC10201bF3, str3, bVar);
                obj = ie0.t();
                if (obj == AbstractC14862ic3.e()) {
                    WA1.c(this);
                }
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
            return ((C0210f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class g implements Callable {
        final /* synthetic */ FF5 a;
        final /* synthetic */ f b;

        public g(FF5 ff5, f fVar) {
            this.a = ff5;
            this.b = fVar;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            if (this.a.a()) {
                return null;
            }
            AbstractC9913am0.b(null, this.b.new h(null), 1, null);
            return C19938rB7.a;
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC19699qn4 interfaceC19699qn4;
            f fVar;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC19699qn4 = f.this.L;
                f fVar2 = f.this;
                this.b = interfaceC19699qn4;
                this.c = fVar2;
                this.d = 1;
                if (interfaceC19699qn4.a(null, this) == objE) {
                    return objE;
                }
                fVar = fVar2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                fVar = (f) this.c;
                interfaceC19699qn4 = (InterfaceC19699qn4) this.b;
                AbstractC10685c16.b(obj);
            }
            try {
                fVar.q.g(null);
                fVar.r.g(null);
                a aVarV0 = fVar.v0();
                if (aVarV0 != null) {
                    aVarV0.l();
                }
                fVar.R0(null);
                a aVar = fVar.t;
                if (aVar != null) {
                    aVar.l();
                }
                fVar.t = null;
                InterfaceC13730gj3 interfaceC13730gj3 = fVar.z;
                if (interfaceC13730gj3 != null) {
                    InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                }
                fVar.z = null;
                C7257Qy1 c7257Qy1 = fVar.y;
                if (c7257Qy1 != null) {
                    c7257Qy1.a();
                }
                fVar.y = null;
                fVar.u = null;
                C7257Qy1 c7257Qy12 = fVar.A;
                if (c7257Qy12 != null) {
                    c7257Qy12.a();
                }
                fVar.A = null;
                fVar.v = null;
                C7257Qy1 c7257Qy13 = fVar.B;
                if (c7257Qy13 != null) {
                    c7257Qy13.a();
                }
                fVar.B = null;
                fVar.w = null;
                C7257Qy1 c7257Qy14 = fVar.C;
                if (c7257Qy14 != null) {
                    c7257Qy14.a();
                }
                fVar.C = null;
                fVar.x = null;
                fVar.H = false;
                C19938rB7 c19938rB7 = C19938rB7.a;
                interfaceC19699qn4.e(null);
                return C19938rB7.a;
            } catch (Throwable th) {
                interfaceC19699qn4.e(null);
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        private /* synthetic */ Object h;
        final /* synthetic */ LivekitRtc$JoinResponse j;
        final /* synthetic */ C14870id1 k;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ f e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f fVar) {
                super(1);
                this.e = fVar;
            }

            public final void a(DataChannel dataChannel) {
                AbstractC13042fc3.i(dataChannel, "dataChannel");
                String strLabel = dataChannel.label();
                if (AbstractC13042fc3.d(strLabel, "_reliable")) {
                    this.e.v = dataChannel;
                } else if (!AbstractC13042fc3.d(strLabel, "_lossy")) {
                    return;
                } else {
                    this.e.x = dataChannel;
                }
                dataChannel.registerObserver(new C3030b(this.e, dataChannel));
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((DataChannel) obj);
                return C19938rB7.a;
            }
        }

        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ f e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(f fVar) {
                super(1);
                this.e = fVar;
            }

            public final void a(PeerConnection.PeerConnectionState peerConnectionState) {
                AbstractC13042fc3.i(peerConnectionState, "newState");
                if (AbstractC22919w25.e(peerConnectionState)) {
                    this.e.I0();
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((PeerConnection.PeerConnectionState) obj);
                return C19938rB7.a;
            }
        }

        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ DataChannel.Init d;
            final /* synthetic */ f e;

            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C7257Qy1 c;
                final /* synthetic */ f d;

                static final class b implements InterfaceC4806Gq2 {
                    final /* synthetic */ f a;

                    b(f fVar) {
                        this.a = fVar;
                    }

                    @Override // ir.nasim.InterfaceC4806Gq2
                    public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return b(((Number) obj).longValue(), interfaceC20295rm1);
                    }

                    public final Object b(long j, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object obj = this.a.D;
                        f fVar = this.a;
                        synchronized (obj) {
                            fVar.F.f(j);
                        }
                        return C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(C7257Qy1 c7257Qy1, f fVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c7257Qy1;
                    this.d = fVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC10258bL6 interfaceC10258bL6E = AbstractC5508Jq2.e(new AbstractC24042xw5(this.c) { // from class: io.livekit.android.room.f.i.c.a.a
                            @Override // ir.nasim.InterfaceC3820Cm3
                            public Object get() {
                                return Long.valueOf(((C7257Qy1) this.receiver).b());
                            }
                        });
                        b bVar = new b(this.d);
                        this.b = 1;
                        if (interfaceC10258bL6E.b(bVar, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    throw new KotlinNothingValueException();
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(DataChannel.Init init, f fVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = init;
                this.e = fVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(this.d, this.e, interfaceC20295rm1);
                cVar.c = obj;
                return cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                DataChannel dataChannelCreateDataChannel = ((PeerConnection) this.c).createDataChannel("_reliable", this.d);
                f fVar = this.e;
                AbstractC13042fc3.f(dataChannelCreateDataChannel);
                C7257Qy1 c7257Qy1 = new C7257Qy1(dataChannelCreateDataChannel, new C3030b(fVar, dataChannelCreateDataChannel), fVar.d);
                fVar.y = c7257Qy1;
                dataChannelCreateDataChannel.registerObserver(c7257Qy1);
                InterfaceC13730gj3 interfaceC13730gj3 = fVar.z;
                if (interfaceC13730gj3 != null) {
                    InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                }
                fVar.z = AbstractC10533bm0.d(fVar.K, null, null, new a(c7257Qy1, fVar, null), 3, null);
                return dataChannelCreateDataChannel;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(PeerConnection peerConnection, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(peerConnection, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ DataChannel.Init d;
            final /* synthetic */ f e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(DataChannel.Init init, f fVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = init;
                this.e = fVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                d dVar = new d(this.d, this.e, interfaceC20295rm1);
                dVar.c = obj;
                return dVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                DataChannel dataChannelCreateDataChannel = ((PeerConnection) this.c).createDataChannel("_lossy", this.d);
                f fVar = this.e;
                AbstractC13042fc3.f(dataChannelCreateDataChannel);
                fVar.B = new C7257Qy1(dataChannelCreateDataChannel, new C3030b(fVar, dataChannelCreateDataChannel), fVar.d);
                dataChannelCreateDataChannel.registerObserver(fVar.B);
                return dataChannelCreateDataChannel;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(PeerConnection peerConnection, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((d) create(peerConnection, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class e extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ f e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(f fVar) {
                super(1);
                this.e = fVar;
            }

            public final void a(PeerConnection.PeerConnectionState peerConnectionState) {
                AbstractC13042fc3.i(peerConnectionState, "newState");
                AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.k(null, "onIceConnection new state: " + peerConnectionState, new Object[0]);
                }
                if (AbstractC22919w25.c(peerConnectionState)) {
                    this.e.P0(EnumC24439yd1.b);
                } else if (AbstractC22919w25.e(peerConnectionState)) {
                    this.e.P0(EnumC24439yd1.c);
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((PeerConnection.PeerConnectionState) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(LivekitRtc$JoinResponse livekitRtc$JoinResponse, C14870id1 c14870id1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.j = livekitRtc$JoinResponse;
            this.k = c14870id1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = f.this.new i(this.j, this.k, interfaceC20295rm1);
            iVar.h = obj;
            return iVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:63:0x014c A[Catch: all -> 0x007f, TRY_LEAVE, TryCatch #3 {all -> 0x007f, blocks: (B:27:0x007a, B:61:0x0133, B:63:0x014c), top: B:101:0x007a }] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x016a  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0188 A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:91:0x021c, B:82:0x01e4, B:84:0x01fa, B:22:0x005d, B:69:0x016e, B:71:0x0188, B:73:0x01af, B:75:0x01bf, B:72:0x01a8), top: B:96:0x005d }] */
        /* JADX WARN: Removed duplicated region for block: B:72:0x01a8 A[Catch: all -> 0x0062, TryCatch #0 {all -> 0x0062, blocks: (B:91:0x021c, B:82:0x01e4, B:84:0x01fa, B:22:0x005d, B:69:0x016e, B:71:0x0188, B:73:0x01af, B:75:0x01bf, B:72:0x01a8), top: B:96:0x005d }] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01bf A[Catch: all -> 0x0062, TRY_LEAVE, TryCatch #0 {all -> 0x0062, blocks: (B:91:0x021c, B:82:0x01e4, B:84:0x01fa, B:22:0x005d, B:69:0x016e, B:71:0x0188, B:73:0x01af, B:75:0x01bf, B:72:0x01a8), top: B:96:0x005d }] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x01e2  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01fa A[Catch: all -> 0x0062, TRY_LEAVE, TryCatch #0 {all -> 0x0062, blocks: (B:91:0x021c, B:82:0x01e4, B:84:0x01fa, B:22:0x005d, B:69:0x016e, B:71:0x0188, B:73:0x01af, B:75:0x01bf, B:72:0x01a8), top: B:96:0x005d }] */
        /* JADX WARN: Removed duplicated region for block: B:90:0x021b  */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [ir.nasim.qn4] */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v7 */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 555
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.f.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC8614Ws3 implements InterfaceC14603iB2 {

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC24439yd1.values().length];
                try {
                    iArr[EnumC24439yd1.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC24439yd1.c.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        j() {
            super(2);
        }

        public final void a(EnumC24439yd1 enumC24439yd1, EnumC24439yd1 enumC24439yd12) {
            d dVarU0;
            AbstractC13042fc3.i(enumC24439yd1, "newVal");
            AbstractC13042fc3.i(enumC24439yd12, "oldVal");
            if (enumC24439yd1 == enumC24439yd12) {
                return;
            }
            int i = a.a[enumC24439yd1.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.d(null, "primary ICE disconnected", new Object[0]);
                }
                if (enumC24439yd12 == EnumC24439yd1.b) {
                    f.this.I0();
                    return;
                }
                return;
            }
            if (enumC24439yd12 == EnumC24439yd1.c || enumC24439yd12 == EnumC24439yd1.a) {
                AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
                if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.d(null, "primary ICE connected", new Object[0]);
                }
                d dVarU02 = f.this.u0();
                if (dVarU02 != null) {
                    dVarU02.s();
                    return;
                }
                return;
            }
            if (enumC24439yd12 != EnumC24439yd1.d) {
                if (enumC24439yd12 != EnumC24439yd1.e || (dVarU0 = f.this.u0()) == null) {
                    return;
                }
                dVarU0.t();
                return;
            }
            AbstractC6718Or3.a aVar3 = AbstractC6718Or3.Companion;
            if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.d(null, "primary ICE reconnected", new Object[0]);
            }
            d dVarU03 = f.this.u0();
            if (dVarU03 != null) {
                dVarU03.N();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((EnumC24439yd1) obj, (EnumC24439yd1) obj2);
            return C19938rB7.a;
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ MediaStreamTrack d;
        final /* synthetic */ RtpTransceiver.RtpTransceiverInit e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(MediaStreamTrack mediaStreamTrack, RtpTransceiver.RtpTransceiverInit rtpTransceiverInit, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = mediaStreamTrack;
            this.e = rtpTransceiverInit;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            k kVar = new k(this.d, this.e, interfaceC20295rm1);
            kVar.c = obj;
            return kVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return ((PeerConnection) this.c).addTransceiver(this.d, this.e);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(PeerConnection peerConnection, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(peerConnection, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class l extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ io.livekit.android.room.a e;
        final /* synthetic */ RtpSender f;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ io.livekit.android.room.a c;
            final /* synthetic */ RTCStatsCollectorCallback d;
            final /* synthetic */ RtpSender e;

            /* renamed from: io.livekit.android.room.f$l$a$a, reason: collision with other inner class name */
            static final class C0212a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                private /* synthetic */ Object c;
                final /* synthetic */ RtpSender d;
                final /* synthetic */ RTCStatsCollectorCallback e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0212a(RtpSender rtpSender, RTCStatsCollectorCallback rTCStatsCollectorCallback, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = rtpSender;
                    this.e = rTCStatsCollectorCallback;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0212a c0212a = new C0212a(this.d, this.e, interfaceC20295rm1);
                    c0212a.c = obj;
                    return c0212a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    ((PeerConnection) this.c).getStats(this.d, this.e);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(PeerConnection peerConnection, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0212a) create(peerConnection, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(io.livekit.android.room.a aVar, RTCStatsCollectorCallback rTCStatsCollectorCallback, RtpSender rtpSender, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = aVar;
                this.d = rTCStatsCollectorCallback;
                this.e = rtpSender;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r6.b
                    r2 = 1
                    if (r1 == 0) goto L17
                    if (r1 != r2) goto Lf
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L31
                Lf:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L17:
                    ir.nasim.AbstractC10685c16.b(r7)
                    io.livekit.android.room.a r7 = r6.c
                    r1 = 0
                    if (r7 == 0) goto L34
                    io.livekit.android.room.f$l$a$a r3 = new io.livekit.android.room.f$l$a$a
                    livekit.org.webrtc.RtpSender r4 = r6.e
                    livekit.org.webrtc.RTCStatsCollectorCallback r5 = r6.d
                    r3.<init>(r4, r5, r1)
                    r6.b = r2
                    java.lang.Object r7 = r7.B(r3, r6)
                    if (r7 != r0) goto L31
                    return r0
                L31:
                    r1 = r7
                    ir.nasim.rB7 r1 = (ir.nasim.C19938rB7) r1
                L34:
                    if (r1 != 0) goto L46
                    livekit.org.webrtc.RTCStatsCollectorCallback r7 = r6.d
                    livekit.org.webrtc.RTCStatsReport r0 = new livekit.org.webrtc.RTCStatsReport
                    r1 = 0
                    java.util.Map r3 = ir.nasim.AbstractC18278oO3.k()
                    r0.<init>(r1, r3)
                    r7.onStatsDelivered(r0)
                L46:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.f.l.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(io.livekit.android.room.a aVar, RtpSender rtpSender) {
            super(1);
            this.e = aVar;
            this.f = rtpSender;
        }

        public final void a(RTCStatsCollectorCallback rTCStatsCollectorCallback) {
            AbstractC13042fc3.i(rTCStatsCollectorCallback, "statsCallback");
            AbstractC9913am0.b(null, new a(this.e, rTCStatsCollectorCallback, this.f, null), 1, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((RTCStatsCollectorCallback) obj);
            return C19938rB7.a;
        }
    }

    static final class m extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ io.livekit.android.room.a e;
        final /* synthetic */ RtpReceiver f;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ io.livekit.android.room.a c;
            final /* synthetic */ RTCStatsCollectorCallback d;
            final /* synthetic */ RtpReceiver e;

            /* renamed from: io.livekit.android.room.f$m$a$a, reason: collision with other inner class name */
            static final class C0213a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                private /* synthetic */ Object c;
                final /* synthetic */ RtpReceiver d;
                final /* synthetic */ RTCStatsCollectorCallback e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0213a(RtpReceiver rtpReceiver, RTCStatsCollectorCallback rTCStatsCollectorCallback, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = rtpReceiver;
                    this.e = rTCStatsCollectorCallback;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0213a c0213a = new C0213a(this.d, this.e, interfaceC20295rm1);
                    c0213a.c = obj;
                    return c0213a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    ((PeerConnection) this.c).getStats(this.d, this.e);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(PeerConnection peerConnection, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0213a) create(peerConnection, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(io.livekit.android.room.a aVar, RTCStatsCollectorCallback rTCStatsCollectorCallback, RtpReceiver rtpReceiver, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = aVar;
                this.d = rTCStatsCollectorCallback;
                this.e = rtpReceiver;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r6.b
                    r2 = 1
                    if (r1 == 0) goto L17
                    if (r1 != r2) goto Lf
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L31
                Lf:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L17:
                    ir.nasim.AbstractC10685c16.b(r7)
                    io.livekit.android.room.a r7 = r6.c
                    r1 = 0
                    if (r7 == 0) goto L34
                    io.livekit.android.room.f$m$a$a r3 = new io.livekit.android.room.f$m$a$a
                    livekit.org.webrtc.RtpReceiver r4 = r6.e
                    livekit.org.webrtc.RTCStatsCollectorCallback r5 = r6.d
                    r3.<init>(r4, r5, r1)
                    r6.b = r2
                    java.lang.Object r7 = r7.B(r3, r6)
                    if (r7 != r0) goto L31
                    return r0
                L31:
                    r1 = r7
                    ir.nasim.rB7 r1 = (ir.nasim.C19938rB7) r1
                L34:
                    if (r1 != 0) goto L46
                    livekit.org.webrtc.RTCStatsCollectorCallback r7 = r6.d
                    livekit.org.webrtc.RTCStatsReport r0 = new livekit.org.webrtc.RTCStatsReport
                    r1 = 0
                    java.util.Map r3 = ir.nasim.AbstractC18278oO3.k()
                    r0.<init>(r1, r3)
                    r7.onStatsDelivered(r0)
                L46:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.f.m.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(io.livekit.android.room.a aVar, RtpReceiver rtpReceiver) {
            super(1);
            this.e = aVar;
            this.f = rtpReceiver;
        }

        public final void a(RTCStatsCollectorCallback rTCStatsCollectorCallback) {
            AbstractC13042fc3.i(rTCStatsCollectorCallback, "statsCallback");
            AbstractC9913am0.b(null, new a(this.e, rTCStatsCollectorCallback, this.f, null), 1, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((RTCStatsCollectorCallback) obj);
            return C19938rB7.a;
        }
    }

    static final class n extends AbstractC22163um1 {
        Object a;
        Object b;
        long c;
        /* synthetic */ Object d;
        int f;

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return f.this.r0(null, this);
        }
    }

    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ RTCStatsCollectorCallback d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ RTCStatsCollectorCallback d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(RTCStatsCollectorCallback rTCStatsCollectorCallback, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = rTCStatsCollectorCallback;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((PeerConnection) this.c).getStats(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(PeerConnection peerConnection, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(peerConnection, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(RTCStatsCollectorCallback rTCStatsCollectorCallback, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = rTCStatsCollectorCallback;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new o(this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r5.b
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                ir.nasim.AbstractC10685c16.b(r6)
                goto L33
            Lf:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L17:
                ir.nasim.AbstractC10685c16.b(r6)
                io.livekit.android.room.f r6 = io.livekit.android.room.f.this
                io.livekit.android.room.a r6 = r6.v0()
                r1 = 0
                if (r6 == 0) goto L36
                io.livekit.android.room.f$o$a r3 = new io.livekit.android.room.f$o$a
                livekit.org.webrtc.RTCStatsCollectorCallback r4 = r5.d
                r3.<init>(r4, r1)
                r5.b = r2
                java.lang.Object r6 = r6.B(r3, r5)
                if (r6 != r0) goto L33
                return r0
            L33:
                r1 = r6
                ir.nasim.rB7 r1 = (ir.nasim.C19938rB7) r1
            L36:
                if (r1 != 0) goto L48
                livekit.org.webrtc.RTCStatsCollectorCallback r6 = r5.d
                livekit.org.webrtc.RTCStatsReport r0 = new livekit.org.webrtc.RTCStatsReport
                r1 = 0
                java.util.Map r3 = ir.nasim.AbstractC18278oO3.k()
                r0.<init>(r1, r3)
                r6.onStatsDelivered(r0)
            L48:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.f.o.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ RTCStatsCollectorCallback d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ RTCStatsCollectorCallback d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(RTCStatsCollectorCallback rTCStatsCollectorCallback, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = rTCStatsCollectorCallback;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((PeerConnection) this.c).getStats(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(PeerConnection peerConnection, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(peerConnection, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(RTCStatsCollectorCallback rTCStatsCollectorCallback, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = rTCStatsCollectorCallback;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new p(this.d, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r5.b
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                ir.nasim.AbstractC10685c16.b(r6)
                goto L33
            Lf:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L17:
                ir.nasim.AbstractC10685c16.b(r6)
                io.livekit.android.room.f r6 = io.livekit.android.room.f.this
                io.livekit.android.room.a r6 = io.livekit.android.room.f.P(r6)
                r1 = 0
                if (r6 == 0) goto L36
                io.livekit.android.room.f$p$a r3 = new io.livekit.android.room.f$p$a
                livekit.org.webrtc.RTCStatsCollectorCallback r4 = r5.d
                r3.<init>(r4, r1)
                r5.b = r2
                java.lang.Object r6 = r6.B(r3, r5)
                if (r6 != r0) goto L33
                return r0
            L33:
                r1 = r6
                ir.nasim.rB7 r1 = (ir.nasim.C19938rB7) r1
            L36:
                if (r1 != 0) goto L48
                livekit.org.webrtc.RTCStatsCollectorCallback r6 = r5.d
                livekit.org.webrtc.RTCStatsReport r0 = new livekit.org.webrtc.RTCStatsReport
                r1 = 0
                java.util.Map r3 = ir.nasim.AbstractC18278oO3.k()
                r0.<init>(r1, r3)
                r6.onStatsDelivered(r0)
            L48:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.f.p.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ C14870id1 g;
        final /* synthetic */ K26 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(String str, String str2, C14870id1 c14870id1, K26 k26, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = str;
            this.f = str2;
            this.g = c14870id1;
            this.h = k26;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            q qVar = f.this.new q(this.e, this.f, this.g, this.h, interfaceC20295rm1);
            qVar.c = obj;
            return qVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r10.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L27
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r0 = r10.c
                livekit.LivekitRtc$JoinResponse r0 = (livekit.LivekitRtc$JoinResponse) r0
                ir.nasim.AbstractC10685c16.b(r11)
                goto L94
            L17:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1f:
                java.lang.Object r1 = r10.c
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                ir.nasim.AbstractC10685c16.b(r11)
                goto L5a
            L27:
                ir.nasim.AbstractC10685c16.b(r11)
                java.lang.Object r11 = r10.c
                r1 = r11
                ir.nasim.ro1 r1 = (ir.nasim.InterfaceC20315ro1) r1
                io.livekit.android.room.f r11 = io.livekit.android.room.f.this
                ir.nasim.yd1 r11 = r11.t0()
                ir.nasim.yd1 r4 = ir.nasim.EnumC24439yd1.c
                if (r11 != r4) goto L40
                io.livekit.android.room.f r11 = io.livekit.android.room.f.this
                ir.nasim.yd1 r4 = ir.nasim.EnumC24439yd1.a
                r11.P0(r4)
            L40:
                io.livekit.android.room.f r11 = io.livekit.android.room.f.this
                io.livekit.android.room.l r4 = r11.s0()
                java.lang.String r5 = r10.e
                java.lang.String r6 = r10.f
                ir.nasim.id1 r7 = r10.g
                ir.nasim.K26 r8 = r10.h
                r10.c = r1
                r10.b = r3
                r9 = r10
                java.lang.Object r11 = r4.v(r5, r6, r7, r8, r9)
                if (r11 != r0) goto L5a
                return r0
            L5a:
                livekit.LivekitRtc$JoinResponse r11 = (livekit.LivekitRtc$JoinResponse) r11
                ir.nasim.AbstractC20906so1.f(r1)
                io.livekit.android.room.f r1 = io.livekit.android.room.f.this
                io.livekit.android.room.f$d r1 = r1.u0()
                if (r1 == 0) goto L6a
                r1.o(r11)
            L6a:
                io.livekit.android.room.f r1 = io.livekit.android.room.f.this
                r3 = 0
                io.livekit.android.room.f.U(r1, r3)
                io.livekit.android.room.f r1 = io.livekit.android.room.f.this
                io.livekit.android.room.f$d r1 = r1.u0()
                if (r1 == 0) goto L7b
                r1.l(r3)
            L7b:
                io.livekit.android.room.f r1 = io.livekit.android.room.f.this
                boolean r3 = r11.getSubscriberPrimary()
                io.livekit.android.room.f.h0(r1, r3)
                io.livekit.android.room.f r1 = io.livekit.android.room.f.this
                ir.nasim.id1 r3 = r10.g
                r10.c = r11
                r10.b = r2
                java.lang.Object r1 = io.livekit.android.room.f.u(r1, r11, r3, r10)
                if (r1 != r0) goto L93
                return r0
            L93:
                r0 = r11
            L94:
                io.livekit.android.room.f r11 = io.livekit.android.room.f.this
                boolean r11 = io.livekit.android.room.f.S(r11)
                if (r11 == 0) goto La2
                boolean r11 = r0.getFastPublish()
                if (r11 == 0) goto La7
            La2:
                io.livekit.android.room.f r11 = io.livekit.android.room.f.this
                r11.E0()
            La7:
                io.livekit.android.room.f r11 = io.livekit.android.room.f.this
                io.livekit.android.room.l r11 = r11.s0()
                r11.x()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.f.q.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new r(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            UA2 ua2P;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            a aVarV0 = f.this.v0();
            if (aVarV0 != null && (ua2P = aVarV0.p()) != null) {
                ua2P.invoke(f.this.w0());
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ SessionDescription d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(SessionDescription sessionDescription, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = sessionDescription;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new s(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC24126y52 abstractC24126y52;
            AbstractC24126y52 abstractC24126y52A;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                SessionDescription sessionDescription = this.d;
                if (UI3.c.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.g(null, sessionDescription.toString(), new Object[0]);
                }
                a aVarV0 = f.this.v0();
                if (aVarV0 == null) {
                    abstractC24126y52 = null;
                    abstractC24126y52A = AbstractC24716z52.a(abstractC24126y52);
                    if (!(abstractC24126y52A instanceof AbstractC24126y52.a) && (abstractC24126y52A instanceof AbstractC24126y52.b)) {
                        AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
                        if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                            AbstractC5270Ip7.e(null, "error setting remote description for answer: " + ((String) ((AbstractC24126y52.b) abstractC24126y52A).a()) + ' ', new Object[0]);
                        }
                    }
                    return C19938rB7.a;
                }
                SessionDescription sessionDescription2 = this.d;
                this.b = 1;
                obj = aVarV0.y(sessionDescription2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            abstractC24126y52 = (AbstractC24126y52) obj;
            abstractC24126y52A = AbstractC24716z52.a(abstractC24126y52);
            if (!(abstractC24126y52A instanceof AbstractC24126y52.a)) {
                AbstractC6718Or3.a aVar22 = AbstractC6718Or3.Companion;
                if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) >= 0) {
                    AbstractC5270Ip7.e(null, "error setting remote description for answer: " + ((String) ((AbstractC24126y52.b) abstractC24126y52A).a()) + ' ', new Object[0]);
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        t(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new t(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                a aVarV0 = f.this.v0();
                if (aVarV0 == null) {
                    return null;
                }
                this.b = 1;
                obj = aVarV0.z(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return (PeerConnection.SignalingState) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ SessionDescription e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ SessionDescription d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SessionDescription sessionDescription, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = sessionDescription;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    PeerConnection peerConnection = (PeerConnection) this.c;
                    SessionDescription sessionDescription = this.d;
                    this.b = 1;
                    obj = AbstractC22183uo1.c(peerConnection, sessionDescription, this);
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
            public final Object invoke(PeerConnection peerConnection, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(peerConnection, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;

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
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    PeerConnection peerConnection = (PeerConnection) this.c;
                    MediaConstraints mediaConstraints = new MediaConstraints();
                    this.b = 1;
                    obj = AbstractC22183uo1.a(peerConnection, mediaConstraints, this);
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
            public final Object invoke(PeerConnection peerConnection, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(peerConnection, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(SessionDescription sessionDescription, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = sessionDescription;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            u uVar = f.this.new u(this.e, interfaceC20295rm1);
            uVar.c = obj;
            return uVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0141  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0150  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instructions count: 401
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.f.u.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((u) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class v extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        v(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new v(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                a aVarV0 = f.this.v0();
                if (aVarV0 == null) {
                    return null;
                }
                this.b = 1;
                obj = aVarV0.z(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return (PeerConnection.SignalingState) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((v) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class w extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC13730gj3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(InterfaceC13730gj3 interfaceC13730gj3) {
            super(1);
            this.f = interfaceC13730gj3;
        }

        public final void a(Throwable th) {
            if (AbstractC13042fc3.d(f.this.h, this.f)) {
                f.this.h = null;
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    static final class x extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        int d;
        int e;
        int f;
        long g;
        int h;
        private /* synthetic */ Object i;
        final /* synthetic */ C12889fL5 j;
        final /* synthetic */ f k;
        final /* synthetic */ boolean l;
        final /* synthetic */ String m;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ f c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f fVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = fVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    io.livekit.android.room.e eVar = this.c.q;
                    this.b = 1;
                    if (B25.a(eVar, this) == objE) {
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

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C12889fL5 c;
            final /* synthetic */ InterfaceC13730gj3 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C12889fL5 c12889fL5, InterfaceC13730gj3 interfaceC13730gj3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c12889fL5;
                this.d = interfaceC13730gj3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    List listR = AbstractC10360bX0.r(this.c.a, this.d);
                    this.b = 1;
                    if (DV.c(listR, this) == objE) {
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

        public /* synthetic */ class c {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[TJ5.values().length];
                try {
                    iArr[TJ5.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TJ5.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TJ5.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ f c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(f fVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = fVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new d(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    io.livekit.android.room.m mVar = this.c.r;
                    this.b = 1;
                    if (B25.a(mVar, this) == objE) {
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
                return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        x(C12889fL5 c12889fL5, f fVar, boolean z, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.j = c12889fL5;
            this.k = fVar;
            this.l = z;
            this.m = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            x xVar = new x(this.j, this.k, this.l, this.m, interfaceC20295rm1);
            xVar.i = obj;
            return xVar;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(12:141|(3:143|(1:145)|146)|147|(1:151)|152|(1:154)|281|155|156|267|157|(1:159)(14:160|277|161|(6:279|163|(1:165)|168|(1:170)|171)(1:173)|174|175|(1:179)|180|(1:182)|183|(1:185)|186|187|(0)(0))) */
        /* JADX WARN: Can't wrap try/catch for region: R(16:94|(1:98)|(3:100|(1:102)|103)|104|273|105|(2:285|107)|112|283|113|(2:265|115)|119|120|269|121|(1:123)(4:124|125|187|(2:189|(1:193))(4:194|(1:196)|197|(1:199)(3:200|201|(5:208|(9:210|(2:212|(4:214|(1:216)|217|(1:219)(1:220))(0))|(2:225|(1:227))|228|(1:230)|231|(5:233|(1:235)(1:236)|237|(1:239)|240)|241|242)|223|243|(6:246|139|140|259|30|(0)))(2:203|(1:207)))))) */
        /* JADX WARN: Code restructure failed: missing block: B:126:0x02fa, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:127:0x02fb, code lost:
        
            r1 = r9;
            r2 = r10;
            r5 = r12;
            r6 = r13;
            r4 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x0301, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x0306, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:221:0x052d, code lost:
        
            if (r9 == false) goto L223;
         */
        /* JADX WARN: Code restructure failed: missing block: B:249:0x059b, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:250:0x059c, code lost:
        
            r1 = r19;
            r6 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:251:0x059f, code lost:
        
            r2 = r10;
            r5 = r12;
            r10 = r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:252:0x05a3, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:253:0x05a4, code lost:
        
            r6 = r15;
            r1 = r19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:258:0x05be, code lost:
        
            r11 = 0;
            ir.nasim.AbstractC5270Ip7.l(r0, r14, new java.lang.Object[0]);
         */
        /* JADX WARN: Code restructure failed: missing block: B:289:0x052d, code lost:
        
            r9 = false;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:134:0x0319, B:137:0x0328], limit reached: 284 */
        /* JADX WARN: Path cross not found for [B:137:0x0328, B:134:0x0319], limit reached: 284 */
        /* JADX WARN: Path cross not found for [B:139:0x032f, B:256:0x05b8], limit reached: 284 */
        /* JADX WARN: Path cross not found for [B:256:0x05b8, B:139:0x032f], limit reached: 284 */
        /* JADX WARN: Removed duplicated region for block: B:134:0x0319  */
        /* JADX WARN: Removed duplicated region for block: B:141:0x0333  */
        /* JADX WARN: Removed duplicated region for block: B:173:0x03ef  */
        /* JADX WARN: Removed duplicated region for block: B:182:0x0420  */
        /* JADX WARN: Removed duplicated region for block: B:185:0x042e  */
        /* JADX WARN: Removed duplicated region for block: B:189:0x0441  */
        /* JADX WARN: Removed duplicated region for block: B:194:0x0462  */
        /* JADX WARN: Removed duplicated region for block: B:203:0x04d0  */
        /* JADX WARN: Removed duplicated region for block: B:208:0x04ef  */
        /* JADX WARN: Removed duplicated region for block: B:219:0x052a  */
        /* JADX WARN: Removed duplicated region for block: B:220:0x052c  */
        /* JADX WARN: Removed duplicated region for block: B:230:0x0554  */
        /* JADX WARN: Removed duplicated region for block: B:233:0x056a  */
        /* JADX WARN: Removed duplicated region for block: B:256:0x05b8  */
        /* JADX WARN: Removed duplicated region for block: B:262:0x05e1  */
        /* JADX WARN: Removed duplicated region for block: B:279:0x03b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x017b  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0198  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x020b  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x021c  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x022d  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0247  */
        /* JADX WARN: Type inference failed for: r1v23, types: [java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r6v35, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v37 */
        /* JADX WARN: Type inference failed for: r6v84 */
        /* JADX WARN: Type inference failed for: r6v85 */
        /* JADX WARN: Type inference failed for: r6v88 */
        /* JADX WARN: Type inference failed for: r6v89 */
        /* JADX WARN: Type inference failed for: r6v90 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:209:0x04f7 -> B:223:0x0530). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:215:0x051e -> B:217:0x0521). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:255:0x05b6 -> B:139:0x032f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:257:0x05bc -> B:139:0x032f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:258:0x05be -> B:140:0x0330). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r33) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 1540
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.f.x.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((x) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class y extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ MediaStreamTrack d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ MediaStreamTrack d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(MediaStreamTrack mediaStreamTrack, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = mediaStreamTrack;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                PeerConnection peerConnection = (PeerConnection) this.c;
                for (RtpSender rtpSender : peerConnection.getSenders()) {
                    MediaStreamTrack mediaStreamTrackTrack = rtpSender.track();
                    if (mediaStreamTrackTrack != null && AbstractC13042fc3.d(mediaStreamTrackTrack.id(), this.d.id())) {
                        peerConnection.removeTrack(rtpSender);
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(PeerConnection peerConnection, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(peerConnection, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        y(MediaStreamTrack mediaStreamTrack, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = mediaStreamTrack;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return f.this.new y(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                io.livekit.android.room.a aVarV0 = f.this.v0();
                if (aVarV0 == null) {
                    return null;
                }
                a aVar = new a(this.d, null);
                this.b = 1;
                obj = aVarV0.B(aVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return (C19938rB7) obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((y) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class z extends AbstractC22163um1 {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        z(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            Object objL0 = f.this.L0(0, this);
            return objL0 == AbstractC14862ic3.e() ? objL0 : C9475a16.a(objL0);
        }
    }

    static {
        Q12.a aVar = Q12.b;
        N = T12.s(30, W12.e);
        O = 2621440L;
        MediaConstraints mediaConstraints = new MediaConstraints();
        mediaConstraints.optional.add(new MediaConstraints.KeyValuePair("DtlsSrtpKeyAgreement", "true"));
        P = mediaConstraints;
    }

    public f(io.livekit.android.room.l lVar, a.InterfaceC0209a interfaceC0209a, AbstractC13778go1 abstractC13778go1, FF5 ff5) {
        AbstractC13042fc3.i(lVar, "client");
        AbstractC13042fc3.i(interfaceC0209a, "pctFactory");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(ff5, "rtcThreadToken");
        this.a = lVar;
        this.b = interfaceC0209a;
        this.c = abstractC13778go1;
        this.d = ff5;
        this.f = AbstractC5508Jq2.a(EnumC24439yd1.c, new j());
        this.g = TJ5.a;
        this.j = new LinkedHashMap();
        this.q = new io.livekit.android.room.e(this, lVar, ff5);
        this.r = new io.livekit.android.room.m(this, lVar, ff5);
        this.D = new Object();
        this.E = 1;
        this.F = new C13294fz1(O);
        this.G = new C5675Ki7(N, null, 2, null);
        this.I = true;
        this.K = new VV0(P17.b(null, 1, null).X(abstractC13778go1));
        this.L = AbstractC20899sn4.b(false, 1, null);
        lVar.M(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PeerConnection.RTCConfiguration D0(AbstractC24126y52 abstractC24126y52, C14870id1 c14870id1) {
        List<LivekitRtc$ICEServer> iceServersList;
        PeerConnection.RTCConfiguration rTCConfiguration;
        ArrayList arrayList = new ArrayList();
        boolean z2 = abstractC24126y52 instanceof AbstractC24126y52.a;
        if (z2) {
            iceServersList = ((LivekitRtc$JoinResponse) ((AbstractC24126y52.a) abstractC24126y52).a()).getIceServersList();
        } else {
            if (!(abstractC24126y52 instanceof AbstractC24126y52.b)) {
                throw new NoWhenBranchMatchedException();
            }
            iceServersList = ((LivekitRtc$ReconnectResponse) ((AbstractC24126y52.b) abstractC24126y52).a()).getIceServersList();
        }
        for (LivekitRtc$ICEServer livekitRtc$ICEServer : iceServersList) {
            AbstractC13042fc3.f(livekitRtc$ICEServer);
            arrayList.add(AbstractC14044hF5.a(livekitRtc$ICEServer));
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(io.livekit.android.room.l.Companion.b());
        }
        PeerConnection.RTCConfiguration rTCConfigurationI = c14870id1.i();
        if (rTCConfigurationI == null || (rTCConfiguration = AbstractC22919w25.a(rTCConfigurationI)) == null) {
            rTCConfiguration = new PeerConnection.RTCConfiguration(arrayList);
            rTCConfiguration.sdpSemantics = PeerConnection.SdpSemantics.UNIFIED_PLAN;
            rTCConfiguration.continualGatheringPolicy = PeerConnection.ContinualGatheringPolicy.GATHER_CONTINUALLY;
        } else {
            List<PeerConnection.IceServer> list = rTCConfiguration.iceServers;
            AbstractC13042fc3.h(list, "iceServers");
            List<PeerConnection.IceServer> listP1 = AbstractC15401jX0.p1(list);
            List<PeerConnection.IceServer> listE = c14870id1.e();
            if (listE != null) {
                for (PeerConnection.IceServer iceServer : listE) {
                    if (!listP1.contains(iceServer)) {
                        listP1.add(iceServer);
                    }
                }
            }
            if (listP1.isEmpty()) {
                List<PeerConnection.IceServer> list2 = rTCConfiguration.iceServers;
                AbstractC13042fc3.h(list2, "iceServers");
                for (PeerConnection.IceServer iceServer2 : list2) {
                    if (!listP1.contains(iceServer2)) {
                        listP1.add(iceServer2);
                    }
                }
            }
            rTCConfiguration.iceServers = listP1;
        }
        LivekitModels$ClientConfiguration clientConfiguration = null;
        if (z2) {
            AbstractC24126y52.a aVar = (AbstractC24126y52.a) abstractC24126y52;
            if (((LivekitRtc$JoinResponse) aVar.a()).hasClientConfiguration()) {
                clientConfiguration = ((LivekitRtc$JoinResponse) aVar.a()).getClientConfiguration();
            }
        } else {
            if (!(abstractC24126y52 instanceof AbstractC24126y52.b)) {
                throw new NoWhenBranchMatchedException();
            }
            AbstractC24126y52.b bVar = (AbstractC24126y52.b) abstractC24126y52;
            if (((LivekitRtc$ReconnectResponse) bVar.a()).hasClientConfiguration()) {
                clientConfiguration = ((LivekitRtc$ReconnectResponse) bVar.a()).getClientConfiguration();
            }
        }
        if (clientConfiguration != null && clientConfiguration.getForceRelay() == OE3.ENABLED) {
            rTCConfiguration.iceTransportsType = PeerConnection.IceTransportsType.RELAY;
        }
        return rTCConfiguration;
    }

    private static final Object N0(f fVar, LivekitModels$DataPacket livekitModels$DataPacket) throws RoomException.ConnectException {
        try {
            LivekitModels$DataPacket.b kind = livekitModels$DataPacket.getKind();
            LivekitModels$DataPacket.b bVar = LivekitModels$DataPacket.b.RELIABLE;
            if (kind == bVar) {
                GeneratedMessageLite generatedMessageLiteA = ((LivekitModels$DataPacket.a) livekitModels$DataPacket.toBuilder()).F(fVar.E).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                livekitModels$DataPacket = (LivekitModels$DataPacket) generatedMessageLiteA;
                fVar.E++;
            }
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(livekitModels$DataPacket.toByteArray());
            if (livekitModels$DataPacket.getKind() == bVar) {
                C13294fz1 c13294fz1 = fVar.F;
                AbstractC13042fc3.f(byteBufferWrap);
                c13294fz1.e(new C13885gz1(byteBufferWrap, livekitModels$DataPacket.getSequence()));
                if (fVar.t0() == EnumC24439yd1.d) {
                    C9475a16.a aVar = C9475a16.b;
                    return C9475a16.b(C19938rB7.a);
                }
            }
            DataChannel.Buffer buffer = new DataChannel.Buffer(byteBufferWrap, true);
            LivekitModels$DataPacket.b kind2 = livekitModels$DataPacket.getKind();
            AbstractC13042fc3.h(kind2, "getKind(...)");
            DataChannel dataChannelQ0 = fVar.q0(kind2);
            if (dataChannelQ0 != null) {
                dataChannelQ0.send(buffer);
                C9475a16.a aVar2 = C9475a16.b;
                return C9475a16.b(C19938rB7.a);
            }
            throw new RoomException.ConnectException("channel not established for " + livekitModels$DataPacket.getKind().name(), null, 2, null);
        } catch (Exception e2) {
            C9475a16.a aVar3 = C9475a16.b;
            return C9475a16.b(AbstractC10685c16.a(e2));
        }
    }

    public static /* synthetic */ void k0(f fVar, String str, int i2, Object obj) throws ExecutionException, InterruptedException {
        if ((i2 & 1) != 0) {
            str = "Normal Closure";
        }
        fVar.j0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(String str) throws ExecutionException, InterruptedException {
        FF5 ff5 = this.d;
        if (!ff5.a()) {
            String name = Thread.currentThread().getName();
            AbstractC13042fc3.h(name, "getName(...)");
            if (AbstractC20153rZ6.S(name, "LK_RTC_THREAD", false, 2, null)) {
                AbstractC9913am0.b(null, new h(null), 1, null);
            } else {
                IF5.b.submit(new g(ff5, this)).get();
            }
        }
        io.livekit.android.room.l.n(this.a, 0, str, false, 5, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m0(LivekitRtc$JoinResponse livekitRtc$JoinResponse, C14870id1 c14870id1, InterfaceC20295rm1 interfaceC20295rm1) {
        return IF5.f(this.d, new i(livekitRtc$JoinResponse, c14870id1, null), interfaceC20295rm1);
    }

    private final DataChannel q0(LivekitModels$DataPacket.b bVar) {
        int i2 = e.a[bVar.ordinal()];
        if (i2 == 1) {
            return this.u;
        }
        if (i2 == 2) {
            return this.w;
        }
        if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException("Unknown data packet kind!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0120 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x011e -> B:54:0x00dd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r0(livekit.LivekitModels$DataPacket.b r17, ir.nasim.InterfaceC20295rm1 r18) throws io.livekit.android.room.RoomException.ConnectException {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.f.r0(livekit.LivekitModels$DataPacket$b, ir.nasim.rm1):java.lang.Object");
    }

    private final void s() {
        synchronized (this.j) {
            try {
                for (InterfaceC20295rm1 interfaceC20295rm1 : this.j.values()) {
                    C9475a16.a aVar = C9475a16.b;
                    interfaceC20295rm1.resumeWith(C9475a16.b(AbstractC10685c16.a(new TrackException.PublishException("pending track aborted", null, 2, null))));
                }
                this.j.clear();
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MediaConstraints w0() {
        MediaConstraints mediaConstraints = new MediaConstraints();
        List<MediaConstraints.KeyValuePair> list = mediaConstraints.mandatory;
        list.add(new MediaConstraints.KeyValuePair("OfferToReceiveAudio", "false"));
        list.add(new MediaConstraints.KeyValuePair("OfferToReceiveVideo", "false"));
        if (t0() == EnumC24439yd1.d || t0() == EnumC24439yd1.e) {
            list.add(new MediaConstraints.KeyValuePair("IceRestart", "true"));
        }
        return mediaConstraints;
    }

    public final void A0(RTCStatsCollectorCallback rTCStatsCollectorCallback) {
        AbstractC13042fc3.i(rTCStatsCollectorCallback, "callback");
        AbstractC9913am0.b(null, new p(rTCStatsCollectorCallback, null), 1, null);
    }

    public final Object B0(String str, String str2, C14870id1 c14870id1, K26 k26, InterfaceC20295rm1 interfaceC20295rm1) {
        this.K.close();
        this.K = new VV0(P17.b(null, 1, null).X(this.c));
        this.l = str;
        this.m = str2;
        this.n = c14870id1;
        this.o = k26;
        return C0(str, str2, c14870id1, k26, interfaceC20295rm1);
    }

    public final Object C0(String str, String str2, C14870id1 c14870id1, K26 k26, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new q(str, str2, c14870id1, k26, null), interfaceC20295rm1);
    }

    public final void E0() {
        if (this.a.u()) {
            this.J = true;
            AbstractC10533bm0.d(this.K, null, null, new r(null), 3, null);
        }
    }

    public final void F0(DataChannel dataChannel, long j2) {
        AbstractC13042fc3.i(dataChannel, "dataChannel");
    }

    public final void G0(DataChannel dataChannel, DataChannel.Buffer buffer) {
        AbstractC13042fc3.i(dataChannel, "dataChannel");
        if (buffer == null) {
            return;
        }
        LivekitModels$DataPacket from = LivekitModels$DataPacket.parseFrom(AbstractC2383g.D(buffer.data));
        if (from.getSequence() > 0) {
            String participantSid = from.getParticipantSid();
            AbstractC13042fc3.h(participantSid, "getParticipantSid(...)");
            if (participantSid.length() > 0) {
                synchronized (this.D) {
                    Integer num = (Integer) this.G.get(from.getParticipantSid());
                    if (num != null && from.getSequence() <= num.intValue()) {
                        return;
                    }
                    C5675Ki7 c5675Ki7 = this.G;
                    String participantSid2 = from.getParticipantSid();
                    AbstractC13042fc3.h(participantSid2, "getParticipantSid(...)");
                    c5675Ki7.put(participantSid2, Integer.valueOf(from.getSequence()));
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
            }
        }
        LivekitModels$DataPacket.c valueCase = from.getValueCase();
        int i2 = valueCase == null ? -1 : e.c[valueCase.ordinal()];
        if (i2 != -1) {
            if (i2 == 4) {
                d dVar = this.e;
                if (dVar != null) {
                    LivekitModels$Transcription transcription = from.getTranscription();
                    AbstractC13042fc3.h(transcription, "getTranscription(...)");
                    dVar.n(transcription);
                    return;
                }
                return;
            }
            if (i2 == 1) {
                d dVar2 = this.e;
                if (dVar2 != null) {
                    List<LivekitModels$SpeakerInfo> speakersList = from.getSpeaker().getSpeakersList();
                    AbstractC13042fc3.h(speakersList, "getSpeakersList(...)");
                    dVar2.K(speakersList);
                    return;
                }
                return;
            }
            if (i2 == 2) {
                d dVar3 = this.e;
                if (dVar3 != null) {
                    LivekitModels$UserPacket user = from.getUser();
                    AbstractC13042fc3.h(user, "getUser(...)");
                    LivekitModels$DataPacket.b kind = from.getKind();
                    AbstractC13042fc3.h(kind, "getKind(...)");
                    dVar3.x(user, kind);
                    return;
                }
                return;
            }
            switch (i2) {
                case 7:
                case 8:
                case 9:
                    d dVar4 = this.e;
                    if (dVar4 != null) {
                        AbstractC13042fc3.f(from);
                        dVar4.M(from);
                        return;
                    }
                    return;
                case 10:
                    break;
                case 11:
                case 12:
                case 13:
                    d dVar5 = this.e;
                    if (dVar5 != null) {
                        AbstractC13042fc3.f(from);
                        dVar5.L(from);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
            return;
        }
        AbstractC5270Ip7.k(null, "invalid value for data packet", new Object[0]);
    }

    public final void H0(DataChannel dataChannel) {
        AbstractC13042fc3.i(dataChannel, "dataChannel");
    }

    public final synchronized void I0() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.h;
        if (interfaceC13730gj3 != null && interfaceC13730gj3.b()) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.d(null, "Reconnection is already in progress", new Object[0]);
            }
            return;
        }
        if (this.I) {
            AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
            if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.d(null, "Skip reconnection - engine is closed", new Object[0]);
            }
            return;
        }
        C12889fL5 c12889fL5 = new C12889fL5();
        String str = this.l;
        c12889fL5.a = str;
        String str2 = this.m;
        if (str != null && str2 != null) {
            boolean z2 = this.i;
            this.i = false;
            InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(this.K, null, null, new x(c12889fL5, this, z2, str2, null), 3, null);
            this.h = interfaceC13730gj3D;
            interfaceC13730gj3D.s(new w(interfaceC13730gj3D));
            return;
        }
        AbstractC6718Or3.a aVar3 = AbstractC6718Or3.Companion;
        if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.l(null, "couldn't reconnect, no url or no token", new Object[0]);
        }
    }

    public final void J0(String str, C23425wt7 c23425wt7) {
        AbstractC13042fc3.i(str, "cid");
        AbstractC13042fc3.i(c23425wt7, "trackBitrateInfo");
        a aVar = this.s;
        if (aVar != null) {
            aVar.v(str, c23425wt7);
        }
    }

    public final void K0(MediaStreamTrack mediaStreamTrack) {
        AbstractC13042fc3.i(mediaStreamTrack, "rtcTrack");
        AbstractC9913am0.b(null, new y(mediaStreamTrack, null), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L0(int r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.livekit.android.room.f.z
            if (r0 == 0) goto L13
            r0 = r6
            io.livekit.android.room.f$z r0 = (io.livekit.android.room.f.z) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.livekit.android.room.f$z r0 = new io.livekit.android.room.f$z
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            int r5 = r0.b
            java.lang.Object r0 = r0.a
            io.livekit.android.room.f r0 = (io.livekit.android.room.f) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r6)
            livekit.LivekitModels$DataPacket$b r6 = livekit.LivekitModels$DataPacket.b.RELIABLE
            r0.a = r4
            r0.b = r5
            r0.e = r3
            java.lang.Object r6 = r4.r0(r6, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            r0 = r4
        L4a:
            livekit.LivekitModels$DataPacket$b r6 = livekit.LivekitModels$DataPacket.b.RELIABLE
            livekit.org.webrtc.DataChannel r6 = r0.q0(r6)
            if (r6 != 0) goto L64
            ir.nasim.a16$a r5 = ir.nasim.C9475a16.b
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "reliable channel not established!"
            r5.<init>(r6)
            java.lang.Object r5 = ir.nasim.AbstractC10685c16.a(r5)
            java.lang.Object r5 = ir.nasim.C9475a16.b(r5)
            return r5
        L64:
            java.lang.Object r1 = r0.D
            monitor-enter(r1)
            ir.nasim.fz1 r2 = r0.F     // Catch: java.lang.Throwable -> L91
            r2.d(r5)     // Catch: java.lang.Throwable -> L91
            ir.nasim.fz1 r5 = r0.F     // Catch: java.lang.Throwable -> L91
            java.util.List r5 = r5.c()     // Catch: java.lang.Throwable -> L91
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> L91
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L91
        L78:
            boolean r0 = r5.hasNext()     // Catch: java.lang.Throwable -> L91
            if (r0 == 0) goto L93
            java.lang.Object r0 = r5.next()     // Catch: java.lang.Throwable -> L91
            ir.nasim.gz1 r0 = (ir.nasim.C13885gz1) r0     // Catch: java.lang.Throwable -> L91
            livekit.org.webrtc.DataChannel$Buffer r2 = new livekit.org.webrtc.DataChannel$Buffer     // Catch: java.lang.Throwable -> L91
            java.nio.ByteBuffer r0 = r0.a()     // Catch: java.lang.Throwable -> L91
            r2.<init>(r0, r3)     // Catch: java.lang.Throwable -> L91
            r6.send(r2)     // Catch: java.lang.Throwable -> L91
            goto L78
        L91:
            r5 = move-exception
            goto L9f
        L93:
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L91
            monitor-exit(r1)
            ir.nasim.a16$a r5 = ir.nasim.C9475a16.b
            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
            java.lang.Object r5 = ir.nasim.C9475a16.b(r5)
            return r5
        L9f:
            monitor-exit(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.f.L0(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object M0(livekit.LivekitModels$DataPacket r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.livekit.android.room.f.A
            if (r0 == 0) goto L13
            r0 = r6
            io.livekit.android.room.f$A r0 = (io.livekit.android.room.f.A) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            io.livekit.android.room.f$A r0 = new io.livekit.android.room.f$A
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.b
            livekit.LivekitModels$DataPacket r5 = (livekit.LivekitModels$DataPacket) r5
            java.lang.Object r0 = r0.a
            io.livekit.android.room.f r0 = (io.livekit.android.room.f) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L53
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            ir.nasim.AbstractC10685c16.b(r6)
            livekit.LivekitModels$DataPacket$b r6 = r5.getKind()
            java.lang.String r2 = "getKind(...)"
            ir.nasim.AbstractC13042fc3.h(r6, r2)
            r0.a = r4
            r0.b = r5
            r0.e = r3
            java.lang.Object r6 = r4.r0(r6, r0)
            if (r6 != r1) goto L52
            return r1
        L52:
            r0 = r4
        L53:
            livekit.LivekitModels$DataPacket$b r6 = r5.getKind()
            livekit.LivekitModels$DataPacket$b r1 = livekit.LivekitModels$DataPacket.b.RELIABLE
            if (r6 != r1) goto L67
            java.lang.Object r6 = r0.D
            monitor-enter(r6)
            java.lang.Object r5 = N0(r0, r5)     // Catch: java.lang.Throwable -> L64
            monitor-exit(r6)
            return r5
        L64:
            r5 = move-exception
            monitor-exit(r6)
            throw r5
        L67:
            java.lang.Object r5 = N0(r0, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.f.M0(livekit.LivekitModels$DataPacket, ir.nasim.rm1):java.lang.Object");
    }

    public final void O0(LivekitRtc$UpdateSubscription livekitRtc$UpdateSubscription, List list) {
        AbstractC13042fc3.i(livekitRtc$UpdateSubscription, "subscription");
        AbstractC13042fc3.i(list, "publishedTracks");
        C12889fL5 c12889fL5 = new C12889fL5();
        C12889fL5 c12889fL52 = new C12889fL5();
        AbstractC9913am0.b(null, new B(c12889fL5, c12889fL52, null), 1, null);
        F92 f92 = c.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : f92) {
            if (((LivekitModels$DataPacket.b) obj) != LivekitModels$DataPacket.b.UNRECOGNIZED) {
                arrayList.add(obj);
            }
        }
        ArrayList<DataChannel> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            DataChannel dataChannelQ0 = q0((LivekitModels$DataPacket.b) it.next());
            if (dataChannelQ0 != null) {
                arrayList2.add(dataChannelQ0);
            }
        }
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(arrayList2, 10));
        for (DataChannel dataChannel : arrayList2) {
            arrayList3.add((LivekitRtc$DataChannelInfo) LivekitRtc$DataChannelInfo.newBuilder().A(dataChannel.id()).B(dataChannel.label()).a());
        }
        C5675Ki7 c5675Ki7 = this.G;
        ArrayList arrayList4 = new ArrayList(c5675Ki7.size());
        for (Map.Entry entry : c5675Ki7.entrySet()) {
            String str = (String) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            LivekitRtc$DataChannelReceiveState.a aVarNewBuilder = LivekitRtc$DataChannelReceiveState.newBuilder();
            aVarNewBuilder.B(str);
            aVarNewBuilder.A(iIntValue);
            arrayList4.add((LivekitRtc$DataChannelReceiveState) aVarNewBuilder.a());
        }
        LivekitRtc$SyncState.a aVarNewBuilder2 = LivekitRtc$SyncState.newBuilder();
        Object obj2 = c12889fL5.a;
        if (obj2 != null) {
            aVarNewBuilder2.D((LivekitRtc$SessionDescription) obj2);
        }
        Object obj3 = c12889fL52.a;
        if (obj3 != null) {
            aVarNewBuilder2.E((LivekitRtc$SessionDescription) obj3);
        }
        aVarNewBuilder2.F(livekitRtc$UpdateSubscription);
        aVarNewBuilder2.C(list);
        aVarNewBuilder2.A(arrayList3);
        aVarNewBuilder2.B(arrayList4);
        LivekitRtc$SyncState livekitRtc$SyncState = (LivekitRtc$SyncState) aVarNewBuilder2.a();
        io.livekit.android.room.l lVar = this.a;
        AbstractC13042fc3.f(livekitRtc$SyncState);
        lVar.J(livekitRtc$SyncState);
    }

    public final void P0(EnumC24439yd1 enumC24439yd1) {
        AbstractC13042fc3.i(enumC24439yd1, "<set-?>");
        this.f.i(this, M[0], enumC24439yd1);
    }

    public final void Q0(d dVar) {
        this.e = dVar;
    }

    public final void R0(a aVar) {
        this.s = aVar;
    }

    public final void S0(TJ5 tj5) {
        AbstractC13042fc3.i(tj5, "<set-?>");
        this.g = tj5;
    }

    public final void T0(io.livekit.android.room.h hVar) {
        this.k = hVar;
    }

    public final void U0(String str, Collection collection) {
        AbstractC13042fc3.i(str, "sid");
        AbstractC13042fc3.i(collection, "features");
        this.a.K(str, collection);
    }

    public final void V0(String str, boolean z2) {
        AbstractC13042fc3.i(str, "sid");
        this.a.E(str, z2);
    }

    @Override // io.livekit.android.room.l.b
    public void a(Throwable th) {
        d dVar;
        AbstractC13042fc3.i(th, "error");
        if (t0() != EnumC24439yd1.a || (dVar = this.e) == null) {
            return;
        }
        dVar.I(th);
    }

    @Override // io.livekit.android.room.l.b
    public void b(List list) {
        AbstractC13042fc3.i(list, "streamStates");
        d dVar = this.e;
        if (dVar != null) {
            dVar.b(list);
        }
    }

    @Override // io.livekit.android.room.l.b
    public void c(SessionDescription sessionDescription) {
        AbstractC13042fc3.i(sessionDescription, "sessionDescription");
        PeerConnection.SignalingState signalingState = (PeerConnection.SignalingState) AbstractC9913am0.b(null, new v(null), 1, null);
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.k(null, "received server offer: " + sessionDescription.type + ", " + signalingState, new Object[0]);
        }
        AbstractC10533bm0.d(this.K, null, null, new u(sessionDescription, null), 3, null);
    }

    @Override // io.livekit.android.room.l.b
    public void d(LivekitModels$Room livekitModels$Room) {
        AbstractC13042fc3.i(livekitModels$Room, "update");
        d dVar = this.e;
        if (dVar != null) {
            dVar.d(livekitModels$Room);
        }
    }

    @Override // io.livekit.android.room.l.b
    public void e(LivekitRtc$TrackUnpublishedResponse livekitRtc$TrackUnpublishedResponse) {
        AbstractC13042fc3.i(livekitRtc$TrackUnpublishedResponse, "trackUnpublished");
        d dVar = this.e;
        if (dVar != null) {
            dVar.e(livekitRtc$TrackUnpublishedResponse);
        }
    }

    @Override // io.livekit.android.room.l.b
    public void f(List list) {
        AbstractC13042fc3.i(list, "updates");
        d dVar = this.e;
        if (dVar != null) {
            dVar.f(list);
        }
    }

    @Override // io.livekit.android.room.l.b
    public void g(String str, boolean z2) {
        AbstractC13042fc3.i(str, "trackSid");
        d dVar = this.e;
        if (dVar != null) {
            dVar.g(str, z2);
        }
    }

    @Override // io.livekit.android.room.l.b
    public void h(LivekitRtc$SubscriptionPermissionUpdate livekitRtc$SubscriptionPermissionUpdate) {
        AbstractC13042fc3.i(livekitRtc$SubscriptionPermissionUpdate, "subscriptionPermissionUpdate");
        d dVar = this.e;
        if (dVar != null) {
            dVar.h(livekitRtc$SubscriptionPermissionUpdate);
        }
    }

    @Override // io.livekit.android.room.l.b
    public void i(List list) {
        AbstractC13042fc3.i(list, "speakers");
        d dVar = this.e;
        if (dVar != null) {
            dVar.i(list);
        }
    }

    public final Object i0(String str, String str2, EnumC10201bF3 enumC10201bF3, String str3, LivekitRtc$AddTrackRequest.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
        synchronized (this.j) {
            if (this.j.get(str) != null) {
                throw new TrackException.DuplicateTrackException("Track with same ID " + str + " has already been published!", null, 2, null);
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
        Q12.a aVar = Q12.b;
        return AbstractC3860Cq7.d(T12.s(20, W12.e), new C0210f(str, str2, enumC10201bF3, str3, bVar, null), interfaceC20295rm1);
    }

    @Override // io.livekit.android.room.l.b
    public void j(LivekitRtc$TrackSubscribed livekitRtc$TrackSubscribed) {
        AbstractC13042fc3.i(livekitRtc$TrackSubscribed, "trackSubscribed");
        d dVar = this.e;
        if (dVar != null) {
            dVar.j(livekitRtc$TrackSubscribed);
        }
    }

    public final void j0(String str) throws ExecutionException, InterruptedException {
        AbstractC13042fc3.i(str, "reason");
        if (this.I) {
            return;
        }
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.k(null, "Close - " + str, new Object[0]);
        }
        this.I = true;
        InterfaceC13730gj3 interfaceC13730gj3 = this.h;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.h = null;
        this.K.close();
        this.J = false;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.k = null;
        s();
        l0(str);
        P0(EnumC24439yd1.c);
        synchronized (this.D) {
            this.E = 1;
            this.F.a();
            this.G.clear();
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    @Override // io.livekit.android.room.l.b
    public void k(LivekitRtc$SubscribedQualityUpdate livekitRtc$SubscribedQualityUpdate) {
        AbstractC13042fc3.i(livekitRtc$SubscribedQualityUpdate, "subscribedQualityUpdate");
        d dVar = this.e;
        if (dVar != null) {
            dVar.k(livekitRtc$SubscribedQualityUpdate);
        }
    }

    @Override // io.livekit.android.room.l.b
    public void l(LivekitRtc$LeaveRequest livekitRtc$LeaveRequest) throws ExecutionException, InterruptedException {
        io.livekit.android.room.h hVar;
        AbstractC13042fc3.i(livekitRtc$LeaveRequest, "leave");
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.d(null, "leave request received: reason = " + livekitRtc$LeaveRequest.getReason().name(), new Object[0]);
        }
        s();
        if (livekitRtc$LeaveRequest.hasRegions() && (hVar = this.k) != null) {
            RegionSettings.Companion companion = RegionSettings.INSTANCE;
            LivekitRtc$RegionSettings regions = livekitRtc$LeaveRequest.getRegions();
            AbstractC13042fc3.h(regions, "getRegions(...)");
            hVar.j(companion.a(regions));
        }
        if (livekitRtc$LeaveRequest.getAction() == LivekitRtc$LeaveRequest.a.RESUME) {
            this.i = false;
            return;
        }
        if (livekitRtc$LeaveRequest.getAction() == LivekitRtc$LeaveRequest.a.RECONNECT || livekitRtc$LeaveRequest.getCanReconnect()) {
            this.i = true;
            return;
        }
        k0(this, null, 1, null);
        UT1 ut1A = F26.a(livekitRtc$LeaveRequest.getReason());
        d dVar = this.e;
        if (dVar != null) {
            dVar.m(ut1A);
        }
    }

    @Override // io.livekit.android.room.l.b
    public void m(String str) {
        AbstractC13042fc3.i(str, "token");
        this.m = str;
        io.livekit.android.room.h hVar = this.k;
        if (hVar == null) {
            return;
        }
        hVar.k(str);
    }

    @Override // io.livekit.android.room.l.b
    public void n(LivekitRtc$TrackPublishedResponse livekitRtc$TrackPublishedResponse) {
        InterfaceC20295rm1 interfaceC20295rm1;
        AbstractC13042fc3.i(livekitRtc$TrackPublishedResponse, "response");
        String cid = livekitRtc$TrackPublishedResponse.getCid();
        if (cid == null) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.e(null, "local track published with null cid?", new Object[0]);
            return;
        }
        if (livekitRtc$TrackPublishedResponse.getTrack() == null) {
            AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
            if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.d(null, "local track published with null track info?", new Object[0]);
            }
        }
        AbstractC6718Or3.a aVar3 = AbstractC6718Or3.Companion;
        UI3 ui3 = UI3.a;
        AbstractC6718Or3.a aVar4 = AbstractC6718Or3.Companion;
        if (ui3.compareTo(aVar4.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.k(null, "local track published " + cid, new Object[0]);
        }
        synchronized (this.j) {
            interfaceC20295rm1 = (InterfaceC20295rm1) this.j.remove(cid);
        }
        if (interfaceC20295rm1 != null) {
            C9475a16.a aVar5 = C9475a16.b;
            interfaceC20295rm1.resumeWith(C9475a16.b(livekitRtc$TrackPublishedResponse.getTrack()));
        } else {
            if (UI3.b.compareTo(aVar4.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.d(null, "missing track resolver for: " + cid, new Object[0]);
        }
    }

    public final Object n0(MediaStreamTrack mediaStreamTrack, RtpTransceiver.RtpTransceiverInit rtpTransceiverInit, InterfaceC20295rm1 interfaceC20295rm1) {
        a aVar = this.s;
        if (aVar != null) {
            return aVar.B(new k(mediaStreamTrack, rtpTransceiverInit, null), interfaceC20295rm1);
        }
        return null;
    }

    @Override // io.livekit.android.room.l.b
    public void o(IceCandidate iceCandidate, EnumC17606nF3 enumC17606nF3) {
        C19938rB7 c19938rB7;
        C19938rB7 c19938rB72;
        AbstractC13042fc3.i(iceCandidate, "candidate");
        AbstractC13042fc3.i(enumC17606nF3, "target");
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        UI3 ui3 = UI3.a;
        AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
        if (ui3.compareTo(aVar2.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.k(null, "received ice candidate from peer: " + iceCandidate + ", " + enumC17606nF3, new Object[0]);
        }
        int i2 = e.b[enumC17606nF3.ordinal()];
        if (i2 == 1) {
            a aVar3 = this.s;
            if (aVar3 != null) {
                aVar3.j(iceCandidate);
                c19938rB7 = C19938rB7.a;
            } else {
                c19938rB7 = null;
            }
            if (c19938rB7 != null || UI3.d.compareTo(aVar2.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "received candidate for publisher when we don't have one. ignoring.", new Object[0]);
            return;
        }
        if (i2 != 2) {
            if (UI3.c.compareTo(aVar2.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.g(null, "unknown ice candidate target?", new Object[0]);
            return;
        }
        a aVar4 = this.t;
        if (aVar4 != null) {
            aVar4.j(iceCandidate);
            c19938rB72 = C19938rB7.a;
        } else {
            c19938rB72 = null;
        }
        if (c19938rB72 != null || UI3.d.compareTo(aVar2.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
            return;
        }
        AbstractC5270Ip7.l(null, "received candidate for subscriber when we don't have one. ignoring.", new Object[0]);
    }

    public final UA2 o0(RtpReceiver rtpReceiver) {
        AbstractC13042fc3.i(rtpReceiver, "receiver");
        return new m(this.t, rtpReceiver);
    }

    @Override // io.livekit.android.room.l.b
    public void p(String str, int i2) {
        AbstractC13042fc3.i(str, "reason");
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.c.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.g(null, "received close event: " + str + ", code: " + i2, new Object[0]);
        }
        s();
        I0();
    }

    public final UA2 p0(RtpSender rtpSender) {
        AbstractC13042fc3.i(rtpSender, "sender");
        return new l(this.s, rtpSender);
    }

    @Override // io.livekit.android.room.l.b
    public void q(List list) {
        AbstractC13042fc3.i(list, "updates");
        d dVar = this.e;
        if (dVar != null) {
            dVar.D(list);
        }
    }

    @Override // io.livekit.android.room.l.b
    public void r(SessionDescription sessionDescription) {
        AbstractC13042fc3.i(sessionDescription, "sessionDescription");
        PeerConnection.SignalingState signalingState = (PeerConnection.SignalingState) AbstractC9913am0.b(null, new t(null), 1, null);
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.k(null, "received server answer: " + sessionDescription.type + ", " + signalingState, new Object[0]);
        }
        AbstractC10533bm0.d(this.K, null, null, new s(sessionDescription, null), 3, null);
    }

    public final io.livekit.android.room.l s0() {
        return this.a;
    }

    public final EnumC24439yd1 t0() {
        return (EnumC24439yd1) this.f.h(this, M[0]);
    }

    public final d u0() {
        return this.e;
    }

    public final a v0() {
        return this.s;
    }

    public final void x0(RTCStatsCollectorCallback rTCStatsCollectorCallback) {
        AbstractC13042fc3.i(rTCStatsCollectorCallback, "callback");
        AbstractC9913am0.b(null, new o(rTCStatsCollectorCallback, null), 1, null);
    }

    public final TJ5 y0() {
        return this.g;
    }

    public final io.livekit.android.room.h z0() {
        return this.k;
    }
}
