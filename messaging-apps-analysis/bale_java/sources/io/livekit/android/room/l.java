package io.livekit.android.room;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC11279ck3;
import ir.nasim.AbstractC11420cy6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14073hI7;
import ir.nasim.AbstractC14251hc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC21649tt7;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC22587vV0;
import ir.nasim.AbstractC24126y52;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC5270Ip7;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.AbstractC9167Yt6;
import ir.nasim.C14870id1;
import ir.nasim.C16165ko6;
import ir.nasim.C19938rB7;
import ir.nasim.C9475a16;
import ir.nasim.ED1;
import ir.nasim.EnumC10201bF3;
import ir.nasim.EnumC12833fF3;
import ir.nasim.EnumC17606nF3;
import ir.nasim.EnumC24439yd1;
import ir.nasim.HE0;
import ir.nasim.HG1;
import ir.nasim.IE0;
import ir.nasim.InterfaceC13220fr4;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC8327Vm4;
import ir.nasim.K26;
import ir.nasim.P17;
import ir.nasim.RE3;
import ir.nasim.UI3;
import ir.nasim.VV0;
import ir.nasim.WA1;
import ir.nasim.XV4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.KotlinNothingValueException;
import livekit.LivekitModels$ClientInfo;
import livekit.LivekitModels$Encryption;
import livekit.LivekitModels$ParticipantInfo;
import livekit.LivekitModels$Room;
import livekit.LivekitModels$SpeakerInfo;
import livekit.LivekitRtc$AddTrackRequest;
import livekit.LivekitRtc$ConnectionQualityInfo;
import livekit.LivekitRtc$LeaveRequest;
import livekit.LivekitRtc$MuteTrackRequest;
import livekit.LivekitRtc$Ping;
import livekit.LivekitRtc$SessionDescription;
import livekit.LivekitRtc$SignalRequest;
import livekit.LivekitRtc$SignalResponse;
import livekit.LivekitRtc$StreamStateInfo;
import livekit.LivekitRtc$SubscribedQualityUpdate;
import livekit.LivekitRtc$SubscriptionPermissionUpdate;
import livekit.LivekitRtc$SyncState;
import livekit.LivekitRtc$TrackPublishedResponse;
import livekit.LivekitRtc$TrackSubscribed;
import livekit.LivekitRtc$TrackUnpublishedResponse;
import livekit.LivekitRtc$TrickleRequest;
import livekit.LivekitRtc$UpdateLocalAudioTrack;
import livekit.LivekitRtc$UpdateTrackSettings;
import livekit.org.webrtc.IceCandidate;
import livekit.org.webrtc.PeerConnection;
import livekit.org.webrtc.SessionDescription;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* loaded from: classes3.dex */
public final class l extends WebSocketListener {
    private static final List B;
    private static final List C;
    public static final a Companion;
    private EnumC24439yd1 A;
    private final WebSocket.Factory a;
    private final AbstractC11279ck3 b;
    private final OkHttpClient c;
    private final AbstractC13778go1 d;
    private final InterfaceC13220fr4 e;
    private boolean f;
    private WebSocket g;
    private boolean h;
    private b i;
    private C16165ko6 j;
    private String k;
    private C14870id1 l;
    private K26 m;
    private HE0 n;
    private VV0 o;
    private final InterfaceC8327Vm4 p;
    private final Object q;
    private InterfaceC13730gj3 r;
    private final InterfaceC8327Vm4 s;
    private final Object t;
    private InterfaceC13730gj3 u;
    private InterfaceC13730gj3 v;
    private InterfaceC13730gj3 w;
    private long x;
    private long y;
    private long z;

    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PeerConnection.IceServer c(String str) {
            return PeerConnection.IceServer.builder(str).createIceServer();
        }

        public final List b() {
            return l.C;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public interface b {
        void a(Throwable th);

        void b(List list);

        void c(SessionDescription sessionDescription);

        void d(LivekitModels$Room livekitModels$Room);

        void e(LivekitRtc$TrackUnpublishedResponse livekitRtc$TrackUnpublishedResponse);

        void f(List list);

        void g(String str, boolean z);

        void h(LivekitRtc$SubscriptionPermissionUpdate livekitRtc$SubscriptionPermissionUpdate);

        void i(List list);

        void j(LivekitRtc$TrackSubscribed livekitRtc$TrackSubscribed);

        void k(LivekitRtc$SubscribedQualityUpdate livekitRtc$SubscribedQualityUpdate);

        void l(LivekitRtc$LeaveRequest livekitRtc$LeaveRequest);

        void m(String str);

        void n(LivekitRtc$TrackPublishedResponse livekitRtc$TrackPublishedResponse);

        void o(IceCandidate iceCandidate, EnumC17606nF3 enumC17606nF3);

        void p(String str, int i);

        void q(List list);

        void r(SessionDescription sessionDescription);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LivekitRtc$SignalResponse.b.values().length];
            try {
                iArr[LivekitRtc$SignalResponse.b.ANSWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.OFFER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.TRICKLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.TRACK_SUBSCRIBED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.TRACK_PUBLISHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.SPEAKERS_CHANGED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.JOIN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.LEAVE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.MUTE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.ROOM_UPDATE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.CONNECTION_QUALITY.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.STREAM_STATE_UPDATE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.SUBSCRIBED_QUALITY_UPDATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.SUBSCRIPTION_PERMISSION_UPDATE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.REFRESH_TOKEN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.TRACK_UNPUBLISHED.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.PONG.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.PONG_RESP.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.RECONNECT.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.SUBSCRIPTION_RESPONSE.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.REQUEST_RESPONSE.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.MESSAGE_NOT_SET.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[LivekitRtc$SignalResponse.b.ROOM_MOVED.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            a = iArr;
        }
    }

    static final class d extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return l.this.v(null, null, null, null, this);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ l a;

            a(l lVar) {
                this.a = lVar;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(XV4 xv4, InterfaceC20295rm1 interfaceC20295rm1) {
                WebSocket webSocket = (WebSocket) xv4.a();
                LivekitRtc$SignalResponse livekitRtc$SignalResponse = (LivekitRtc$SignalResponse) xv4.b();
                this.a.s.k();
                this.a.s(webSocket, livekitRtc$SignalResponse);
                return C19938rB7.a;
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return l.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = l.this.s;
                a aVar = new a(l.this);
                this.b = 1;
                if (interfaceC8327Vm4.b(aVar, this) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return l.this.y(null, null, null, this);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return l.this.new g(interfaceC20295rm1);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0028 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:12:0x0029). Please report as a decompilation issue!!! */
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
                goto L29
            Lf:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L17:
                ir.nasim.AbstractC10685c16.b(r6)
            L1a:
                io.livekit.android.room.l r6 = io.livekit.android.room.l.this
                long r3 = io.livekit.android.room.l.c(r6)
                r5.b = r2
                java.lang.Object r6 = ir.nasim.HG1.b(r3, r5)
                if (r6 != r0) goto L29
                return r0
            L29:
                io.livekit.android.room.l r6 = io.livekit.android.room.l.this
                long r3 = r6.G()
                io.livekit.android.room.l r6 = io.livekit.android.room.l.this
                io.livekit.android.room.l.l(r6, r3)
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.l.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return l.this.new h(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long j = l.this.x;
                this.b = 1;
                if (HG1.b(j, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            long j2 = this.d;
            if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.d(null, "Ping timeout reached for ping sent at " + j2 + '.', new Object[0]);
            }
            WebSocket webSocket = l.this.g;
            if (webSocket != null) {
                AbstractC6392Nk0.a(webSocket.close(3000, "Ping timeout"));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ l a;

            a(l lVar) {
                this.a = lVar;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(LivekitRtc$SignalRequest livekitRtc$SignalRequest, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.p.k();
                this.a.I(livekitRtc$SignalRequest);
                return C19938rB7.a;
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return l.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4 = l.this.p;
                a aVar = new a(l.this);
                this.b = 1;
                if (interfaceC8327Vm4.b(aVar, this) == objE) {
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
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static {
        a aVar = new a(null);
        Companion = aVar;
        B = AbstractC10360bX0.p(LivekitRtc$SignalRequest.b.SYNC_STATE, LivekitRtc$SignalRequest.b.TRICKLE, LivekitRtc$SignalRequest.b.OFFER, LivekitRtc$SignalRequest.b.ANSWER, LivekitRtc$SignalRequest.b.SIMULATE, LivekitRtc$SignalRequest.b.LEAVE);
        C = AbstractC10360bX0.p(aVar.c("stun:stun.l.google.com:19302"), aVar.c("stun:stun1.l.google.com:19302"));
    }

    public l(WebSocket.Factory factory, AbstractC11279ck3 abstractC11279ck3, OkHttpClient okHttpClient, AbstractC13778go1 abstractC13778go1, InterfaceC13220fr4 interfaceC13220fr4) {
        AbstractC13042fc3.i(factory, "websocketFactory");
        AbstractC13042fc3.i(abstractC11279ck3, "json");
        AbstractC13042fc3.i(okHttpClient, "okHttpClient");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC13220fr4, "networkInfo");
        this.a = factory;
        this.b = abstractC11279ck3;
        this.c = okHttpClient;
        this.d = abstractC13778go1;
        this.e = interfaceC13220fr4;
        this.p = AbstractC11420cy6.b(Integer.MAX_VALUE, 0, null, 6, null);
        this.q = new Object();
        this.s = AbstractC11420cy6.b(Integer.MAX_VALUE, 0, null, 6, null);
        this.t = new Object();
        this.A = EnumC24439yd1.c;
    }

    private final void H(LivekitRtc$SignalRequest livekitRtc$SignalRequest) {
        if (B.contains(livekitRtc$SignalRequest.getMessageCase())) {
            I(livekitRtc$SignalRequest);
        } else {
            this.p.c(livekitRtc$SignalRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(LivekitRtc$SignalRequest livekitRtc$SignalRequest) {
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        UI3 ui3 = UI3.a;
        AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
        if (ui3.compareTo(aVar2.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.k(null, "sending request: " + livekitRtc$SignalRequest, new Object[0]);
        }
        if (!this.f || this.g == null) {
            if (UI3.d.compareTo(aVar2.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "not connected, could not send request " + livekitRtc$SignalRequest, new Object[0]);
            return;
        }
        ByteString.Companion companion = ByteString.INSTANCE;
        byte[] byteArray = livekitRtc$SignalRequest.toByteArray();
        AbstractC13042fc3.h(byteArray, "toByteArray(...)");
        ByteString byteStringOf$default = ByteString.Companion.of$default(companion, byteArray, 0, 0, 3, null);
        WebSocket webSocket = this.g;
        if ((webSocket != null ? webSocket.send(byteStringOf$default) : false) || UI3.e.compareTo(aVar2.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
            return;
        }
        AbstractC5270Ip7.e(null, "error sending request: " + livekitRtc$SignalRequest, new Object[0]);
    }

    private final void N() {
        VV0 vv0;
        if (this.v != null || this.y == 0) {
            return;
        }
        VV0 vv02 = this.o;
        if (vv02 == null) {
            AbstractC13042fc3.y("coroutineScope");
            vv0 = null;
        } else {
            vv0 = vv02;
        }
        this.v = AbstractC10533bm0.d(vv0, null, null, new g(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(long j) {
        VV0 vv0;
        if (this.w != null) {
            return;
        }
        VV0 vv02 = this.o;
        if (vv02 == null) {
            AbstractC13042fc3.y("coroutineScope");
            vv0 = null;
        } else {
            vv0 = vv02;
        }
        this.w = AbstractC10533bm0.d(vv0, null, null, new h(j, null), 3, null);
    }

    private final void P() {
        if (this.r != null) {
            return;
        }
        synchronized (this.q) {
            try {
                if (this.r == null) {
                    VV0 vv0 = this.o;
                    if (vv0 == null) {
                        AbstractC13042fc3.y("coroutineScope");
                        vv0 = null;
                    }
                    this.r = AbstractC10533bm0.d(vv0, null, null, new i(null), 3, null);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void n(l lVar, int i2, String str, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        }
        if ((i3 & 2) != 0) {
            str = "Normal Closure";
        }
        if ((i3 & 4) != 0) {
            z = true;
        }
        lVar.m(i2, str, z);
    }

    private final Object o(String str, String str2, C14870id1 c14870id1, K26 k26, InterfaceC20295rm1 interfaceC20295rm1) {
        n(this, 0, "Starting new connection", false, 1, null);
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractC14073hI7.b(str));
        sb.append("/rtc");
        LivekitModels$ClientInfo livekitModels$ClientInfoA = AbstractC22587vV0.a();
        AbstractC13042fc3.h(livekitModels$ClientInfoA, "getClientInfo(...)");
        sb.append(p(str2, livekitModels$ClientInfoA, c14870id1, k26));
        String string = sb.toString();
        this.h = c14870id1.h();
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.c.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.g(null, "connecting to " + string, new Object[0]);
        }
        this.o = new VV0(P17.b(null, 1, null).X(this.d));
        this.k = string;
        this.l = c14870id1;
        this.m = k26;
        Request requestBuild = new Request.Builder().url(string).build();
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        this.n = ie0;
        this.g = this.a.newWebSocket(requestBuild, this);
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    private final String p(String str, LivekitModels$ClientInfo livekitModels$ClientInfo, C14870id1 c14870id1, K26 k26) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AbstractC4616Fw7.a("access_token", str));
        arrayList.add(AbstractC4616Fw7.a("protocol", String.valueOf(c14870id1.g().j())));
        if (c14870id1.h()) {
            arrayList.add(AbstractC4616Fw7.a("reconnect", "1"));
            String strF = c14870id1.f();
            if (strF != null) {
                arrayList.add(AbstractC4616Fw7.a("sid", strF));
            }
        }
        arrayList.add(AbstractC4616Fw7.a("auto_subscribe", String.valueOf(c14870id1.d() ? 1 : 0)));
        arrayList.add(AbstractC4616Fw7.a("adaptive_stream", String.valueOf(k26.c() ? 1 : 0)));
        arrayList.add(AbstractC4616Fw7.a("sdk", ConstantDeviceInfo.APP_PLATFORM));
        arrayList.add(AbstractC4616Fw7.a(ParameterNames.VERSION, livekitModels$ClientInfo.getVersion()));
        arrayList.add(AbstractC4616Fw7.a("device_model", livekitModels$ClientInfo.getDeviceModel()));
        arrayList.add(AbstractC4616Fw7.a("os", livekitModels$ClientInfo.getOs()));
        arrayList.add(AbstractC4616Fw7.a(CommonUrlParts.OS_VERSION, livekitModels$ClientInfo.getOsVersion()));
        arrayList.add(AbstractC4616Fw7.a("network", this.e.a().j()));
        String str2 = "";
        int i2 = 0;
        for (Object obj : arrayList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            XV4 xv4 = (XV4) obj;
            str2 = str2 + (i2 == 0 ? Separators.QUESTION : Separators.AND) + ((String) xv4.e()) + '=' + ((String) xv4.f());
            i2 = i3;
        }
        return str2;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final SessionDescription q(LivekitRtc$SessionDescription livekitRtc$SessionDescription) {
        SessionDescription.Type type;
        String type2 = livekitRtc$SessionDescription.getType();
        if (type2 != null) {
            switch (type2.hashCode()) {
                case -1412808770:
                    if (type2.equals("answer")) {
                        type = SessionDescription.Type.ANSWER;
                        return new SessionDescription(type, livekitRtc$SessionDescription.getSdp());
                    }
                    break;
                case -1395375040:
                    if (type2.equals("pranswer")) {
                        type = SessionDescription.Type.PRANSWER;
                        return new SessionDescription(type, livekitRtc$SessionDescription.getSdp());
                    }
                    break;
                case -259719452:
                    if (type2.equals("rollback")) {
                        type = SessionDescription.Type.ROLLBACK;
                        return new SessionDescription(type, livekitRtc$SessionDescription.getSdp());
                    }
                    break;
                case 105650780:
                    if (type2.equals("offer")) {
                        type = SessionDescription.Type.OFFER;
                        return new SessionDescription(type, livekitRtc$SessionDescription.getSdp());
                    }
                    break;
            }
        }
        throw new IllegalArgumentException("invalid RTC SdpType: " + livekitRtc$SessionDescription.getType());
    }

    private final void r(WebSocket webSocket, LivekitRtc$SignalResponse livekitRtc$SignalResponse) {
        if (AbstractC13042fc3.d(webSocket, this.g)) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            UI3 ui3 = UI3.a;
            AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
            if (ui3.compareTo(aVar2.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.k(null, "response: " + livekitRtc$SignalResponse, new Object[0]);
            }
            if (!this.f) {
                if (livekitRtc$SignalResponse.hasJoin()) {
                    this.f = true;
                    P();
                    long pingTimeout = livekitRtc$SignalResponse.getJoin().getPingTimeout();
                    long j = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
                    this.x = pingTimeout * j;
                    this.y = livekitRtc$SignalResponse.getJoin().getPingInterval() * j;
                    N();
                    try {
                        this.j = new C16165ko6(livekitRtc$SignalResponse.getJoin().getServerVersion());
                    } catch (Throwable th) {
                        AbstractC6718Or3.a aVar3 = AbstractC6718Or3.Companion;
                        if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                            AbstractC5270Ip7.l(th, "Thrown while trying to parse server version.", new Object[0]);
                        }
                    }
                    HE0 he0 = this.n;
                    if (he0 != null) {
                        C9475a16.a aVar4 = C9475a16.b;
                        he0.resumeWith(C9475a16.b(new AbstractC24126y52.a(livekitRtc$SignalResponse.getJoin())));
                        return;
                    }
                    return;
                }
                if (livekitRtc$SignalResponse.hasLeave()) {
                    s(webSocket, livekitRtc$SignalResponse);
                    return;
                }
                if (!this.h) {
                    if (UI3.e.compareTo(aVar2.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                        return;
                    }
                    AbstractC5270Ip7.e(null, "Received response while not connected. " + livekitRtc$SignalResponse, new Object[0]);
                    return;
                }
                this.h = false;
                this.f = true;
                N();
                if (livekitRtc$SignalResponse.hasReconnect()) {
                    HE0 he02 = this.n;
                    if (he02 != null) {
                        C9475a16.a aVar5 = C9475a16.b;
                        he02.resumeWith(C9475a16.b(new AbstractC24126y52.b(new AbstractC24126y52.a(livekitRtc$SignalResponse.getReconnect()))));
                        return;
                    }
                    return;
                }
                HE0 he03 = this.n;
                if (he03 != null) {
                    C9475a16.a aVar6 = C9475a16.b;
                    he03.resumeWith(C9475a16.b(new AbstractC24126y52.b(new AbstractC24126y52.b(C19938rB7.a))));
                }
            }
            this.s.c(AbstractC4616Fw7.a(webSocket, livekitRtc$SignalResponse));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(WebSocket webSocket, LivekitRtc$SignalResponse livekitRtc$SignalResponse) {
        b bVar;
        if (!AbstractC13042fc3.d(webSocket, this.g)) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.k(null, "received message from old websocket, discarding.", new Object[0]);
        }
        LivekitRtc$SignalResponse.b messageCase = livekitRtc$SignalResponse.getMessageCase();
        int i2 = messageCase == null ? -1 : c.a[messageCase.ordinal()];
        if (i2 == -1 || i2 == 23) {
            AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
            if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.k(null, "empty messageCase!", new Object[0]);
            return;
        }
        switch (i2) {
            case 1:
                LivekitRtc$SessionDescription answer = livekitRtc$SignalResponse.getAnswer();
                AbstractC13042fc3.h(answer, "getAnswer(...)");
                SessionDescription sessionDescriptionQ = q(answer);
                b bVar2 = this.i;
                if (bVar2 != null) {
                    bVar2.r(sessionDescriptionQ);
                    break;
                }
                break;
            case 2:
                LivekitRtc$SessionDescription offer = livekitRtc$SignalResponse.getOffer();
                AbstractC13042fc3.h(offer, "getOffer(...)");
                SessionDescription sessionDescriptionQ2 = q(offer);
                b bVar3 = this.i;
                if (bVar3 != null) {
                    bVar3.c(sessionDescriptionQ2);
                    break;
                }
                break;
            case 3:
                AbstractC11279ck3 abstractC11279ck3 = this.b;
                String candidateInit = livekitRtc$SignalResponse.getTrickle().getCandidateInit();
                AbstractC13042fc3.h(candidateInit, "getCandidateInit(...)");
                abstractC11279ck3.a();
                IceCandidateJSON iceCandidateJSON = (IceCandidateJSON) abstractC11279ck3.b(IceCandidateJSON.INSTANCE.serializer(), candidateInit);
                IceCandidate iceCandidate = new IceCandidate(iceCandidateJSON.getSdpMid(), iceCandidateJSON.getSdpMLineIndex(), iceCandidateJSON.getCandidate());
                b bVar4 = this.i;
                if (bVar4 != null) {
                    EnumC17606nF3 target = livekitRtc$SignalResponse.getTrickle().getTarget();
                    AbstractC13042fc3.h(target, "getTarget(...)");
                    bVar4.o(iceCandidate, target);
                    break;
                }
                break;
            case 4:
                b bVar5 = this.i;
                if (bVar5 != null) {
                    List<LivekitModels$ParticipantInfo> participantsList = livekitRtc$SignalResponse.getUpdate().getParticipantsList();
                    AbstractC13042fc3.h(participantsList, "getParticipantsList(...)");
                    bVar5.q(participantsList);
                    break;
                }
                break;
            case 5:
                b bVar6 = this.i;
                if (bVar6 != null) {
                    LivekitRtc$TrackSubscribed trackSubscribed = livekitRtc$SignalResponse.getTrackSubscribed();
                    AbstractC13042fc3.h(trackSubscribed, "getTrackSubscribed(...)");
                    bVar6.j(trackSubscribed);
                    break;
                }
                break;
            case 6:
                b bVar7 = this.i;
                if (bVar7 != null) {
                    LivekitRtc$TrackPublishedResponse trackPublished = livekitRtc$SignalResponse.getTrackPublished();
                    AbstractC13042fc3.h(trackPublished, "getTrackPublished(...)");
                    bVar7.n(trackPublished);
                    break;
                }
                break;
            case 7:
                b bVar8 = this.i;
                if (bVar8 != null) {
                    List<LivekitModels$SpeakerInfo> speakersList = livekitRtc$SignalResponse.getSpeakersChanged().getSpeakersList();
                    AbstractC13042fc3.h(speakersList, "getSpeakersList(...)");
                    bVar8.i(speakersList);
                    break;
                }
                break;
            case 8:
                AbstractC6718Or3.a aVar3 = AbstractC6718Or3.Companion;
                if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.d(null, "received unexpected extra join message?", new Object[0]);
                    break;
                }
                break;
            case 9:
                b bVar9 = this.i;
                if (bVar9 != null) {
                    LivekitRtc$LeaveRequest leave = livekitRtc$SignalResponse.getLeave();
                    AbstractC13042fc3.h(leave, "getLeave(...)");
                    bVar9.l(leave);
                    break;
                }
                break;
            case 10:
                b bVar10 = this.i;
                if (bVar10 != null) {
                    String sid = livekitRtc$SignalResponse.getMute().getSid();
                    AbstractC13042fc3.h(sid, "getSid(...)");
                    bVar10.g(sid, livekitRtc$SignalResponse.getMute().getMuted());
                    break;
                }
                break;
            case 11:
                b bVar11 = this.i;
                if (bVar11 != null) {
                    LivekitModels$Room room = livekitRtc$SignalResponse.getRoomUpdate().getRoom();
                    AbstractC13042fc3.h(room, "getRoom(...)");
                    bVar11.d(room);
                    break;
                }
                break;
            case 12:
                b bVar12 = this.i;
                if (bVar12 != null) {
                    List<LivekitRtc$ConnectionQualityInfo> updatesList = livekitRtc$SignalResponse.getConnectionQuality().getUpdatesList();
                    AbstractC13042fc3.h(updatesList, "getUpdatesList(...)");
                    bVar12.f(updatesList);
                    break;
                }
                break;
            case 13:
                b bVar13 = this.i;
                if (bVar13 != null) {
                    List<LivekitRtc$StreamStateInfo> streamStatesList = livekitRtc$SignalResponse.getStreamStateUpdate().getStreamStatesList();
                    AbstractC13042fc3.h(streamStatesList, "getStreamStatesList(...)");
                    bVar13.b(streamStatesList);
                    break;
                }
                break;
            case 14:
                C16165ko6 c16165ko6 = new C16165ko6("0.15.1");
                C16165ko6 c16165ko62 = this.j;
                if ((c16165ko62 != null ? c16165ko62.compareTo(c16165ko6) : 1) > 0 && (bVar = this.i) != null) {
                    LivekitRtc$SubscribedQualityUpdate subscribedQualityUpdate = livekitRtc$SignalResponse.getSubscribedQualityUpdate();
                    AbstractC13042fc3.h(subscribedQualityUpdate, "getSubscribedQualityUpdate(...)");
                    bVar.k(subscribedQualityUpdate);
                    break;
                }
                break;
            case 15:
                b bVar14 = this.i;
                if (bVar14 != null) {
                    LivekitRtc$SubscriptionPermissionUpdate subscriptionPermissionUpdate = livekitRtc$SignalResponse.getSubscriptionPermissionUpdate();
                    AbstractC13042fc3.h(subscriptionPermissionUpdate, "getSubscriptionPermissionUpdate(...)");
                    bVar14.h(subscriptionPermissionUpdate);
                    break;
                }
                break;
            case 16:
                b bVar15 = this.i;
                if (bVar15 != null) {
                    String refreshToken = livekitRtc$SignalResponse.getRefreshToken();
                    AbstractC13042fc3.h(refreshToken, "getRefreshToken(...)");
                    bVar15.m(refreshToken);
                    break;
                }
                break;
            case 17:
                b bVar16 = this.i;
                if (bVar16 != null) {
                    LivekitRtc$TrackUnpublishedResponse trackUnpublished = livekitRtc$SignalResponse.getTrackUnpublished();
                    AbstractC13042fc3.h(trackUnpublished, "getTrackUnpublished(...)");
                    bVar16.e(trackUnpublished);
                    break;
                }
                break;
            case 18:
                z();
                break;
            case 19:
                this.z = new Date().getTime() - livekitRtc$SignalResponse.getPongResp().getLastPingTimestamp();
                z();
                break;
        }
    }

    private final void t(String str, int i2) {
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.k(null, "websocket closed", new Object[0]);
        }
        this.f = false;
        b bVar = this.i;
        if (bVar != null) {
            bVar.p(str, i2);
        }
        this.p.k();
        this.s.k();
        InterfaceC13730gj3 interfaceC13730gj3 = this.v;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        InterfaceC13730gj3 interfaceC13730gj32 = this.w;
        if (interfaceC13730gj32 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj32, null, 1, null);
        }
    }

    private final void z() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.w;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.w = null;
    }

    public final void A(String str, String str2, EnumC10201bF3 enumC10201bF3, String str3, LivekitRtc$AddTrackRequest.b bVar) {
        AbstractC13042fc3.i(str, "cid");
        AbstractC13042fc3.i(str2, "name");
        AbstractC13042fc3.i(enumC10201bF3, "type");
        AbstractC13042fc3.i(bVar, "builder");
        K26 k26 = this.m;
        if (k26 != null) {
            k26.g();
        }
        LivekitModels$Encryption.b bVar2 = LivekitModels$Encryption.b.NONE;
        bVar.F(str);
        bVar.L(str2);
        bVar.Q(enumC10201bF3);
        if (str3 != null) {
            bVar.O(str3);
        } else {
            bVar.D();
        }
        bVar.I(bVar2);
        LivekitRtc$SignalRequest livekitRtc$SignalRequest = (LivekitRtc$SignalRequest) LivekitRtc$SignalRequest.newBuilder().A(bVar).a();
        AbstractC13042fc3.f(livekitRtc$SignalRequest);
        H(livekitRtc$SignalRequest);
    }

    public final void B(SessionDescription sessionDescription) {
        AbstractC13042fc3.i(sessionDescription, "answer");
        LivekitRtc$SignalRequest livekitRtc$SignalRequest = (LivekitRtc$SignalRequest) LivekitRtc$SignalRequest.newBuilder().B(AbstractC9167Yt6.a(sessionDescription)).a();
        AbstractC13042fc3.f(livekitRtc$SignalRequest);
        H(livekitRtc$SignalRequest);
    }

    public final void C(IceCandidate iceCandidate, EnumC17606nF3 enumC17606nF3) {
        AbstractC13042fc3.i(iceCandidate, "candidate");
        AbstractC13042fc3.i(enumC17606nF3, "target");
        String str = iceCandidate.sdp;
        String str2 = iceCandidate.sdpMid;
        int i2 = iceCandidate.sdpMLineIndex;
        AbstractC13042fc3.f(str);
        IceCandidateJSON iceCandidateJSON = new IceCandidateJSON(str, i2, str2);
        LivekitRtc$TrickleRequest.a aVarNewBuilder = LivekitRtc$TrickleRequest.newBuilder();
        AbstractC11279ck3 abstractC11279ck3 = this.b;
        abstractC11279ck3.a();
        LivekitRtc$SignalRequest livekitRtc$SignalRequest = (LivekitRtc$SignalRequest) LivekitRtc$SignalRequest.newBuilder().J((LivekitRtc$TrickleRequest) aVarNewBuilder.A(abstractC11279ck3.c(IceCandidateJSON.INSTANCE.serializer(), iceCandidateJSON)).B(enumC17606nF3).a()).a();
        AbstractC13042fc3.f(livekitRtc$SignalRequest);
        H(livekitRtc$SignalRequest);
    }

    public final void D() {
        LivekitRtc$SignalRequest.a aVarNewBuilder = LivekitRtc$SignalRequest.newBuilder();
        LivekitRtc$LeaveRequest.b bVarNewBuilder = LivekitRtc$LeaveRequest.newBuilder();
        bVarNewBuilder.B(RE3.CLIENT_INITIATED);
        bVarNewBuilder.A(LivekitRtc$LeaveRequest.a.DISCONNECT);
        aVarNewBuilder.C((LivekitRtc$LeaveRequest) bVarNewBuilder.a());
        LivekitRtc$SignalRequest livekitRtc$SignalRequest = (LivekitRtc$SignalRequest) aVarNewBuilder.a();
        AbstractC13042fc3.f(livekitRtc$SignalRequest);
        H(livekitRtc$SignalRequest);
    }

    public final void E(String str, boolean z) {
        AbstractC13042fc3.i(str, "trackSid");
        LivekitRtc$SignalRequest livekitRtc$SignalRequest = (LivekitRtc$SignalRequest) LivekitRtc$SignalRequest.newBuilder().D((LivekitRtc$MuteTrackRequest) LivekitRtc$MuteTrackRequest.newBuilder().B(str).A(z).a()).a();
        AbstractC13042fc3.f(livekitRtc$SignalRequest);
        H(livekitRtc$SignalRequest);
    }

    public final void F(SessionDescription sessionDescription) {
        AbstractC13042fc3.i(sessionDescription, "offer");
        LivekitRtc$SignalRequest livekitRtc$SignalRequest = (LivekitRtc$SignalRequest) LivekitRtc$SignalRequest.newBuilder().E(AbstractC9167Yt6.a(sessionDescription)).a();
        AbstractC13042fc3.f(livekitRtc$SignalRequest);
        H(livekitRtc$SignalRequest);
    }

    public final long G() {
        long time = new Date().getTime();
        LivekitRtc$SignalRequest.a aVarNewBuilder = LivekitRtc$SignalRequest.newBuilder();
        aVarNewBuilder.F(time);
        LivekitRtc$SignalRequest livekitRtc$SignalRequest = (LivekitRtc$SignalRequest) aVarNewBuilder.a();
        AbstractC13042fc3.h(livekitRtc$SignalRequest, "with(...)");
        H(livekitRtc$SignalRequest);
        LivekitRtc$SignalRequest.a aVarNewBuilder2 = LivekitRtc$SignalRequest.newBuilder();
        LivekitRtc$Ping.a aVarNewBuilder3 = LivekitRtc$Ping.newBuilder();
        aVarNewBuilder3.A(this.z);
        aVarNewBuilder3.B(time);
        aVarNewBuilder2.G((LivekitRtc$Ping) aVarNewBuilder3.a());
        LivekitRtc$SignalRequest livekitRtc$SignalRequest2 = (LivekitRtc$SignalRequest) aVarNewBuilder2.a();
        AbstractC13042fc3.h(livekitRtc$SignalRequest2, "with(...)");
        H(livekitRtc$SignalRequest2);
        return time;
    }

    public final void J(LivekitRtc$SyncState livekitRtc$SyncState) {
        AbstractC13042fc3.i(livekitRtc$SyncState, "syncState");
        LivekitRtc$SignalRequest livekitRtc$SignalRequest = (LivekitRtc$SignalRequest) LivekitRtc$SignalRequest.newBuilder().H(livekitRtc$SyncState).a();
        AbstractC13042fc3.f(livekitRtc$SignalRequest);
        H(livekitRtc$SignalRequest);
    }

    public final void K(String str, Collection collection) {
        AbstractC13042fc3.i(str, "trackSid");
        AbstractC13042fc3.i(collection, "features");
        LivekitRtc$SignalRequest.a aVarNewBuilder = LivekitRtc$SignalRequest.newBuilder();
        LivekitRtc$UpdateLocalAudioTrack.b bVarNewBuilder = LivekitRtc$UpdateLocalAudioTrack.newBuilder();
        bVarNewBuilder.B(str);
        bVarNewBuilder.A(collection);
        aVarNewBuilder.K((LivekitRtc$UpdateLocalAudioTrack) bVarNewBuilder.a());
        LivekitRtc$SignalRequest livekitRtc$SignalRequest = (LivekitRtc$SignalRequest) aVarNewBuilder.a();
        AbstractC13042fc3.f(livekitRtc$SignalRequest);
        H(livekitRtc$SignalRequest);
    }

    public final void L(String str, boolean z, AbstractC21649tt7.e eVar, EnumC12833fF3 enumC12833fF3, Integer num) {
        AbstractC13042fc3.i(str, "sid");
        LivekitRtc$UpdateTrackSettings.a aVarB = LivekitRtc$UpdateTrackSettings.newBuilder().A(str).B(z);
        if (eVar != null) {
            aVarB.F(eVar.d());
            aVarB.D(eVar.c());
        } else if (enumC12833fF3 != null) {
            aVarB.E(enumC12833fF3);
        } else {
            aVarB.E(EnumC12833fF3.HIGH);
        }
        if (num != null) {
            aVarB.C(num.intValue());
        }
        LivekitRtc$SignalRequest livekitRtc$SignalRequest = (LivekitRtc$SignalRequest) LivekitRtc$SignalRequest.newBuilder().I(aVarB).a();
        AbstractC13042fc3.f(livekitRtc$SignalRequest);
        H(livekitRtc$SignalRequest);
    }

    public final void M(b bVar) {
        this.i = bVar;
    }

    public final void m(int i2, String str, boolean z) {
        AbstractC13042fc3.i(str, "reason");
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        Exception exc = new Exception();
        if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.k(exc, "Closing SignalClient: code = " + i2 + ", reason = " + str, new Object[0]);
        }
        this.f = false;
        this.h = false;
        VV0 vv0 = this.o;
        if (vv0 != null) {
            if (vv0 == null) {
                AbstractC13042fc3.y("coroutineScope");
                vv0 = null;
            }
            vv0.close();
        }
        InterfaceC13730gj3 interfaceC13730gj3 = this.r;
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.r = null;
        InterfaceC13730gj3 interfaceC13730gj32 = this.u;
        if (interfaceC13730gj32 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj32, null, 1, null);
        }
        this.u = null;
        InterfaceC13730gj3 interfaceC13730gj33 = this.v;
        if (interfaceC13730gj33 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj33, null, 1, null);
        }
        this.v = null;
        InterfaceC13730gj3 interfaceC13730gj34 = this.w;
        if (interfaceC13730gj34 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj34, null, 1, null);
        }
        this.w = null;
        WebSocket webSocket = this.g;
        if (webSocket != null) {
            webSocket.close(i2, str);
        }
        this.g = null;
        HE0 he0 = this.n;
        if (he0 != null) {
            HE0.a.a(he0, null, 1, null);
        }
        this.n = null;
        if (z) {
            this.p.k();
        }
        this.s.k();
        this.k = null;
        this.l = null;
        this.m = null;
        this.j = null;
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int i2, String str) {
        AbstractC13042fc3.i(webSocket, "webSocket");
        AbstractC13042fc3.i(str, "reason");
        if (AbstractC13042fc3.d(webSocket, this.g)) {
            t(str, i2);
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket webSocket, int i2, String str) {
        AbstractC13042fc3.i(webSocket, "webSocket");
        AbstractC13042fc3.i(str, "reason");
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
            return;
        }
        AbstractC5270Ip7.k(null, "websocket closing", new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @Override // okhttp3.WebSocketListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onFailure(okhttp3.WebSocket r10, java.lang.Throwable r11, okhttp3.Response r12) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.l.onFailure(okhttp3.WebSocket, java.lang.Throwable, okhttp3.Response):void");
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, String str) {
        AbstractC13042fc3.i(webSocket, "webSocket");
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        if (AbstractC13042fc3.d(webSocket, this.g)) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "received JSON message, unsupported in this version.", new Object[0]);
        }
    }

    public final boolean u() {
        return this.f;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(java.lang.String r8, java.lang.String r9, ir.nasim.C14870id1 r10, ir.nasim.K26 r11, ir.nasim.InterfaceC20295rm1 r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof io.livekit.android.room.l.d
            if (r0 == 0) goto L14
            r0 = r12
            io.livekit.android.room.l$d r0 = (io.livekit.android.room.l.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            io.livekit.android.room.l$d r0 = new io.livekit.android.room.l$d
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r12)
            goto L44
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            ir.nasim.AbstractC10685c16.b(r12)
            r6.c = r2
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r12 = r1.o(r2, r3, r4, r5, r6)
            if (r12 != r0) goto L44
            return r0
        L44:
            ir.nasim.y52 r12 = (ir.nasim.AbstractC24126y52) r12
            java.lang.String r8 = "null cannot be cast to non-null type io.livekit.android.util.Either.Left<livekit.LivekitRtc.JoinResponse>"
            ir.nasim.AbstractC13042fc3.g(r12, r8)
            ir.nasim.y52$a r12 = (ir.nasim.AbstractC24126y52.a) r12
            java.lang.Object r8 = r12.a()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.l.v(java.lang.String, java.lang.String, ir.nasim.id1, ir.nasim.K26, ir.nasim.rm1):java.lang.Object");
    }

    public final void w() {
        P();
    }

    public final void x() {
        if (this.u != null) {
            return;
        }
        synchronized (this.t) {
            try {
                if (this.u == null) {
                    VV0 vv0 = this.o;
                    if (vv0 == null) {
                        AbstractC13042fc3.y("coroutineScope");
                        vv0 = null;
                    }
                    this.u = AbstractC10533bm0.d(vv0, null, null, new e(null), 3, null);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(java.lang.String r27, java.lang.String r28, java.lang.String r29, ir.nasim.InterfaceC20295rm1 r30) {
        /*
            r26 = this;
            r6 = r26
            r0 = r30
            boolean r1 = r0 instanceof io.livekit.android.room.l.f
            if (r1 == 0) goto L18
            r1 = r0
            io.livekit.android.room.l$f r1 = (io.livekit.android.room.l.f) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L18
            int r2 = r2 - r3
            r1.c = r2
        L16:
            r5 = r1
            goto L1e
        L18:
            io.livekit.android.room.l$f r1 = new io.livekit.android.room.l$f
            r1.<init>(r0)
            goto L16
        L1e:
            java.lang.Object r0 = r5.a
            java.lang.Object r7 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r5.c
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            ir.nasim.AbstractC10685c16.b(r0)
            goto L97
        L2f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L37:
            ir.nasim.AbstractC10685c16.b(r0)
            ir.nasim.id1 r0 = r6.l
            if (r0 != 0) goto L4e
            ir.nasim.id1 r0 = new ir.nasim.id1
            r15 = 63
            r16 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
        L4e:
            r17 = r0
            r24 = 63
            r25 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            ir.nasim.id1 r3 = ir.nasim.C14870id1.b(r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r3.l(r2)
            r0 = r29
            r3.k(r0)
            ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
            ir.nasim.K26 r0 = r6.m
            if (r0 != 0) goto L87
            ir.nasim.K26 r0 = new ir.nasim.K26
            r18 = 511(0x1ff, float:7.16E-43)
            r19 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
        L87:
            r4 = r0
            r5.c = r2
            r0 = r26
            r1 = r27
            r2 = r28
            java.lang.Object r0 = r0.o(r1, r2, r3, r4, r5)
            if (r0 != r7) goto L97
            return r7
        L97:
            ir.nasim.y52 r0 = (ir.nasim.AbstractC24126y52) r0
            java.lang.String r1 = "null cannot be cast to non-null type io.livekit.android.util.Either.Right<io.livekit.android.util.Either<livekit.LivekitRtc.ReconnectResponse, kotlin.Unit>>"
            ir.nasim.AbstractC13042fc3.g(r0, r1)
            ir.nasim.y52$b r0 = (ir.nasim.AbstractC24126y52.b) r0
            java.lang.Object r0 = r0.a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.l.y(java.lang.String, java.lang.String, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, ByteString byteString) {
        AbstractC13042fc3.i(webSocket, "webSocket");
        AbstractC13042fc3.i(byteString, "bytes");
        if (AbstractC13042fc3.d(webSocket, this.g)) {
            LivekitRtc$SignalResponse livekitRtc$SignalResponse = (LivekitRtc$SignalResponse) ((LivekitRtc$SignalResponse.a) LivekitRtc$SignalResponse.newBuilder().k(byteString.toByteArray())).a();
            AbstractC13042fc3.f(livekitRtc$SignalResponse);
            r(webSocket, livekitRtc$SignalResponse);
        }
    }
}
