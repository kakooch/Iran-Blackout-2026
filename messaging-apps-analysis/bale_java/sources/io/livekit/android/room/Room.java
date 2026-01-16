package io.livekit.android.room;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import com.google.protobuf.GeneratedMessageLite;
import io.livekit.android.events.RoomEvent;
import io.livekit.android.renderer.TextureViewRenderer;
import io.livekit.android.room.RoomException;
import io.livekit.android.room.f;
import io.livekit.android.room.h;
import io.livekit.android.room.participant.Participant;
import io.livekit.android.room.participant.a;
import io.livekit.android.room.participant.d;
import io.livekit.android.room.track.TrackException;
import ir.nasim.AN5;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15244jF5;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC18050o01;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC20899sn4;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC21649tt7;
import ir.nasim.AbstractC24096y22;
import ir.nasim.AbstractC24615yu7;
import ir.nasim.AbstractC25143zo1;
import ir.nasim.AbstractC4838Gt7;
import ir.nasim.AbstractC5270Ip7;
import ir.nasim.AbstractC5508Jq2;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9913am0;
import ir.nasim.C12889fL5;
import ir.nasim.C14870id1;
import ir.nasim.C19938rB7;
import ir.nasim.C19977rG1;
import ir.nasim.C20597sH3;
import ir.nasim.C23060wH3;
import ir.nasim.C23718xP;
import ir.nasim.C24025xu7;
import ir.nasim.C5942Lm4;
import ir.nasim.C6952Pr3;
import ir.nasim.C9080Yk0;
import ir.nasim.C9927an4;
import ir.nasim.ED1;
import ir.nasim.EnumC18788pF3;
import ir.nasim.EnumC22663vd1;
import ir.nasim.F53;
import ir.nasim.F92;
import ir.nasim.FV7;
import ir.nasim.G92;
import ir.nasim.H26;
import ir.nasim.IG3;
import ir.nasim.IN;
import ir.nasim.IO;
import ir.nasim.InterfaceC10040ay6;
import ir.nasim.InterfaceC10670c01;
import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14371ho1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC16587lX4;
import ir.nasim.InterfaceC19699qn4;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC24893zO;
import ir.nasim.InterfaceC3503Bd1;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC5932Ll3;
import ir.nasim.InterfaceC6710Oq4;
import ir.nasim.InterfaceC7983Ua2;
import ir.nasim.K26;
import ir.nasim.L0;
import ir.nasim.NV1;
import ir.nasim.QE3;
import ir.nasim.TJ5;
import ir.nasim.UA2;
import ir.nasim.UI3;
import ir.nasim.UT1;
import ir.nasim.XV4;
import ir.nasim.YG3;
import ir.nasim.ZV0;
import ir.nasim.ZW4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import livekit.LivekitModels$Codec;
import livekit.LivekitModels$DataPacket;
import livekit.LivekitModels$DataStream;
import livekit.LivekitModels$ParticipantInfo;
import livekit.LivekitModels$ParticipantTracks;
import livekit.LivekitModels$Room;
import livekit.LivekitModels$SpeakerInfo;
import livekit.LivekitModels$Transcription;
import livekit.LivekitModels$TranscriptionSegment;
import livekit.LivekitModels$UserPacket;
import livekit.LivekitRtc$ConnectionQualityInfo;
import livekit.LivekitRtc$JoinResponse;
import livekit.LivekitRtc$StreamStateInfo;
import livekit.LivekitRtc$SubscribedQualityUpdate;
import livekit.LivekitRtc$SubscriptionPermissionUpdate;
import livekit.LivekitRtc$TrackSubscribed;
import livekit.LivekitRtc$TrackUnpublishedResponse;
import livekit.LivekitRtc$UpdateSubscription;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.MediaStream;
import livekit.org.webrtc.MediaStreamTrack;
import livekit.org.webrtc.RTCStatsCollectorCallback;
import livekit.org.webrtc.RendererCommon;
import livekit.org.webrtc.RtpReceiver;
import livekit.org.webrtc.SurfaceViewRenderer;
import livekit.org.webrtc.audio.AudioDeviceModule;

/* loaded from: classes3.dex */
public final class Room implements f.d, InterfaceC16587lX4, F53 {
    static final /* synthetic */ InterfaceC5239Im3[] O = {AbstractC10882cM5.f(new C5942Lm4(Room.class, "sid", "getSid-CC6JpwI()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(Room.class, "name", "getName()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(Room.class, "state", "getState()Lio/livekit/android/room/Room$State;", 0)), AbstractC10882cM5.f(new C5942Lm4(Room.class, "metadata", "getMetadata()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(Room.class, "isRecording", "isRecording()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(Room.class, "mutableRemoteParticipants", "getMutableRemoteParticipants()Ljava/util/Map;", 0)), AbstractC10882cM5.f(new C5942Lm4(Room.class, "mutableActiveSpeakers", "getMutableActiveSpeakers()Ljava/util/List;", 0))};
    private boolean A;
    private AbstractC24096y22 B;
    private boolean C;
    private final io.livekit.android.room.participant.a D;
    private final C9927an4 E;
    private Map F;
    private final C9927an4 G;
    private boolean H;
    private C14870id1 I;
    private InterfaceC19699qn4 J;
    private io.livekit.android.room.h K;
    private String L;
    private Map M;
    private final InterfaceC6710Oq4 N;
    private final Context a;
    private final io.livekit.android.room.f b;
    private final EglBase c;
    private final C19977rG1 d;
    private final AbstractC13778go1 e;
    private final AbstractC13778go1 f;
    private final IN g;
    private final ZV0 h;
    private final AbstractC24096y22.a i;
    private final InterfaceC10670c01 j;
    private final InterfaceC24893zO k;
    private final C6952Pr3 l;
    private final AudioDeviceModule m;
    private final h.a n;
    private final InterfaceC3503Bd1 o;
    private final IO p;
    private final F53 q;
    private final d.a r;
    private InterfaceC20315ro1 s;
    private final C9080Yk0 t;
    private final InterfaceC7983Ua2 u;
    private final C9927an4 v;
    private final C9927an4 w;
    private final C9927an4 x;
    private final C9927an4 y;
    private final C9927an4 z;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00122\u00020\u0001:\u0002\u0013\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0014"}, d2 = {"Lio/livekit/android/room/Room$Sid;", "", "", "sid", "b", "(Ljava/lang/String;)Ljava/lang/String;", "e", "", "d", "(Ljava/lang/String;)I", "other", "", "c", "(Ljava/lang/String;Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getSid", "()Ljava/lang/String;", "Companion", "$serializer", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    @InterfaceC5932Ll3
    public static final class Sid {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: from kotlin metadata */
        private final String sid;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lio/livekit/android/room/Room$Sid$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/livekit/android/room/Room$Sid;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer serializer() {
                return Room$Sid$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        private /* synthetic */ Sid(String str) {
            this.sid = str;
        }

        public static final /* synthetic */ Sid a(String str) {
            return new Sid(str);
        }

        public static String b(String str) {
            AbstractC13042fc3.i(str, "sid");
            return str;
        }

        public static boolean c(String str, Object obj) {
            return (obj instanceof Sid) && AbstractC13042fc3.d(str, ((Sid) obj).getSid());
        }

        public static int d(String str) {
            return str.hashCode();
        }

        public static String e(String str) {
            return "Sid(sid=" + str + ')';
        }

        public boolean equals(Object obj) {
            return c(this.sid, obj);
        }

        /* renamed from: f, reason: from getter */
        public final /* synthetic */ String getSid() {
            return this.sid;
        }

        public int hashCode() {
            return d(this.sid);
        }

        public String toString() {
            return e(this.sid);
        }
    }

    public interface a {
        Room a(Context context);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class b {
        public static final b a = new b("SPEAKER_UPDATE", 0);
        public static final b b = new b("NODE_FAILURE", 1);
        public static final b c = new b("MIGRATION", 2);
        public static final b d = new b("SERVER_LEAVE", 3);
        public static final b e = new b("SERVER_LEAVE_FULL_RECONNECT", 4);
        private static final /* synthetic */ b[] f;
        private static final /* synthetic */ F92 g;

        static {
            b[] bVarArrA = a();
            f = bVarArrA;
            g = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b, c, d, e};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class c {
        public static final c a = new c("CONNECTING", 0);
        public static final c b = new c("CONNECTED", 1);
        public static final c c = new c("DISCONNECTED", 2);
        public static final c d = new c("RECONNECTING", 3);
        private static final /* synthetic */ c[] e;
        private static final /* synthetic */ F92 f;

        static {
            c[] cVarArrA = a();
            e = cVarArrA;
            f = G92.a(cVarArrA);
        }

        private c(String str, int i) {
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{a, b, c, d};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) e.clone();
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[b.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[b.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
            int[] iArr2 = new int[LivekitModels$DataPacket.c.values().length];
            try {
                iArr2[LivekitModels$DataPacket.c.STREAM_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[LivekitModels$DataPacket.c.STREAM_CHUNK.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[LivekitModels$DataPacket.c.STREAM_TRAILER.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            b = iArr2;
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C12889fL5 c;
        final /* synthetic */ Room d;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ Room a;

            public a(Room room) {
                this.a = room;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                ZW4 zw4 = (ZW4) obj;
                if (zw4 instanceof ZW4.m) {
                    if (this.a.O0() == c.b) {
                        ZW4.m mVar = (ZW4.m) zw4;
                        Object objC = this.a.t.c(new RoomEvent.TrackPublished(this.a, mVar.a(), mVar.getParticipant()), interfaceC20295rm1);
                        if (objC == AbstractC14862ic3.e()) {
                            return objC;
                        }
                    }
                } else if (zw4 instanceof ZW4.n) {
                    ZW4.n nVar = (ZW4.n) zw4;
                    Object objC2 = this.a.t.c(new RoomEvent.TrackStreamStateChanged(this.a, nVar.getTrackPublication(), nVar.getStreamState()), interfaceC20295rm1);
                    if (objC2 == AbstractC14862ic3.e()) {
                        return objC2;
                    }
                } else if (zw4 instanceof ZW4.q) {
                    ZW4.q qVar = (ZW4.q) zw4;
                    Object objC3 = this.a.t.c(new RoomEvent.TrackSubscriptionPermissionChanged(this.a, qVar.getParticipant(), qVar.getTrackPublication(), qVar.getSubscriptionAllowed()), interfaceC20295rm1);
                    if (objC3 == AbstractC14862ic3.e()) {
                        return objC3;
                    }
                } else if (zw4 instanceof ZW4.g) {
                    Room room = this.a;
                    Object objQ0 = room.q0(new RoomEvent.ParticipantMetadataChanged(room, zw4.getParticipant(), ((ZW4.g) zw4).getPrevMetadata()), interfaceC20295rm1);
                    if (objQ0 == AbstractC14862ic3.e()) {
                        return objQ0;
                    }
                } else if (zw4 instanceof ZW4.a) {
                    Room room2 = this.a;
                    Participant participant = zw4.getParticipant();
                    ZW4.a aVar = (ZW4.a) zw4;
                    Object objQ02 = room2.q0(new RoomEvent.ParticipantAttributesChanged(room2, participant, aVar.getChangedAttributes(), aVar.getOldAttributes()), interfaceC20295rm1);
                    if (objQ02 == AbstractC14862ic3.e()) {
                        return objQ02;
                    }
                } else if (zw4 instanceof ZW4.h) {
                    Room room3 = this.a;
                    Object objQ03 = room3.q0(new RoomEvent.ParticipantNameChanged(room3, zw4.getParticipant(), ((ZW4.h) zw4).getName()), interfaceC20295rm1);
                    if (objQ03 == AbstractC14862ic3.e()) {
                        return objQ03;
                    }
                } else if (zw4 instanceof ZW4.i) {
                    C9080Yk0 c9080Yk0 = this.a.t;
                    Room room4 = this.a;
                    Participant participant2 = zw4.getParticipant();
                    ZW4.i iVar = (ZW4.i) zw4;
                    Object objC4 = c9080Yk0.c(new RoomEvent.ParticipantPermissionsChanged(room4, participant2, iVar.getNewPermissions(), iVar.getOldPermissions()), interfaceC20295rm1);
                    if (objC4 == AbstractC14862ic3.e()) {
                        return objC4;
                    }
                } else if (zw4 instanceof ZW4.k) {
                    C9080Yk0 c9080Yk02 = this.a.t;
                    Room room5 = this.a;
                    Participant participant3 = zw4.getParticipant();
                    ZW4.k kVar = (ZW4.k) zw4;
                    Object objC5 = c9080Yk02.c(new RoomEvent.ParticipantStateChanged(room5, participant3, kVar.getNewState(), kVar.getOldState()), interfaceC20295rm1);
                    if (objC5 == AbstractC14862ic3.e()) {
                        return objC5;
                    }
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C12889fL5 c12889fL5, Room room, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c12889fL5;
            this.d = room;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC7983Ua2 interfaceC7983Ua2G = ((io.livekit.android.room.participant.d) this.c.a).g();
                Room room = this.d;
                InterfaceC10040ay6 interfaceC10040ay6A = interfaceC7983Ua2G.a();
                a aVar = new a(room);
                this.b = 1;
                if (interfaceC10040ay6A.b(aVar, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ UT1 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(UT1 ut1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = ut1;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return Room.this.new g(this.g, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x00b4 A[Catch: all -> 0x001e, TryCatch #1 {all -> 0x001e, blocks: (B:7:0x0019, B:31:0x00ae, B:33:0x00b4, B:34:0x00b8), top: B:40:0x0019 }] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r10.e
                java.lang.String r2 = "coroutineScope"
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L3d
                if (r1 == r4) goto L29
                if (r1 != r3) goto L21
                java.lang.Object r0 = r10.c
                io.livekit.android.room.Room r0 = (io.livekit.android.room.Room) r0
                java.lang.Object r1 = r10.b
                ir.nasim.qn4 r1 = (ir.nasim.InterfaceC19699qn4) r1
                ir.nasim.AbstractC10685c16.b(r11)     // Catch: java.lang.Throwable -> L1e
                goto Lae
            L1e:
                r11 = move-exception
                goto Lc3
            L21:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L29:
                java.lang.Object r1 = r10.d
                ir.nasim.UT1 r1 = (ir.nasim.UT1) r1
                java.lang.Object r6 = r10.c
                io.livekit.android.room.Room r6 = (io.livekit.android.room.Room) r6
                java.lang.Object r7 = r10.b
                ir.nasim.qn4 r7 = (ir.nasim.InterfaceC19699qn4) r7
                ir.nasim.AbstractC10685c16.b(r11)
                r11 = r7
                r9 = r6
                r6 = r1
                r1 = r9
                goto L59
            L3d:
                ir.nasim.AbstractC10685c16.b(r11)
                io.livekit.android.room.Room r11 = io.livekit.android.room.Room.this
                ir.nasim.qn4 r11 = io.livekit.android.room.Room.e0(r11)
                io.livekit.android.room.Room r1 = io.livekit.android.room.Room.this
                ir.nasim.UT1 r6 = r10.g
                r10.b = r11
                r10.c = r1
                r10.d = r6
                r10.e = r4
                java.lang.Object r7 = r11.a(r5, r10)
                if (r7 != r0) goto L59
                return r0
            L59:
                io.livekit.android.room.Room$c r7 = r1.O0()     // Catch: java.lang.Throwable -> L67
                io.livekit.android.room.Room$c r8 = io.livekit.android.room.Room.c.c     // Catch: java.lang.Throwable -> L67
                if (r7 != r8) goto L6b
                ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L67
                r11.e(r5)
                return r0
            L67:
                r0 = move-exception
                r1 = r11
                r11 = r0
                goto Lc3
            L6b:
                ir.nasim.Oq4 r7 = io.livekit.android.room.Room.a0(r1)     // Catch: java.lang.Throwable -> L67
                r7.p1()     // Catch: java.lang.Throwable -> L67
                io.livekit.android.room.Room.l0(r1, r8)     // Catch: java.lang.Throwable -> L67
                io.livekit.android.room.Room.Q(r1)     // Catch: java.lang.Throwable -> L67
                io.livekit.android.room.f r7 = r1.z0()     // Catch: java.lang.Throwable -> L67
                io.livekit.android.room.f.k0(r7, r5, r4, r5)     // Catch: java.lang.Throwable -> L67
                io.livekit.android.room.participant.a r7 = r1.B0()     // Catch: java.lang.Throwable -> L67
                r7.c()     // Catch: java.lang.Throwable -> L67
                ir.nasim.Yk0 r7 = io.livekit.android.room.Room.X(r1)     // Catch: java.lang.Throwable -> L67
                io.livekit.android.events.RoomEvent$Disconnected r8 = new io.livekit.android.events.RoomEvent$Disconnected     // Catch: java.lang.Throwable -> L67
                r8.<init>(r1, r5, r6)     // Catch: java.lang.Throwable -> L67
                ir.nasim.ro1 r6 = io.livekit.android.room.Room.U(r1)     // Catch: java.lang.Throwable -> L67
                if (r6 != 0) goto L99
                ir.nasim.AbstractC13042fc3.y(r2)     // Catch: java.lang.Throwable -> L67
                r6 = r5
            L99:
                ir.nasim.gj3 r6 = r7.b(r8, r6)     // Catch: java.lang.Throwable -> L67
                r10.b = r11     // Catch: java.lang.Throwable -> L67
                r10.c = r1     // Catch: java.lang.Throwable -> L67
                r10.d = r5     // Catch: java.lang.Throwable -> L67
                r10.e = r3     // Catch: java.lang.Throwable -> L67
                java.lang.Object r3 = r6.k0(r10)     // Catch: java.lang.Throwable -> L67
                if (r3 != r0) goto Lac
                return r0
            Lac:
                r0 = r1
                r1 = r11
            Lae:
                ir.nasim.ro1 r11 = io.livekit.android.room.Room.U(r0)     // Catch: java.lang.Throwable -> L1e
                if (r11 != 0) goto Lb8
                ir.nasim.AbstractC13042fc3.y(r2)     // Catch: java.lang.Throwable -> L1e
                r11 = r5
            Lb8:
                ir.nasim.AbstractC20906so1.d(r11, r5, r4, r5)     // Catch: java.lang.Throwable -> L1e
                ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L1e
                r1.e(r5)
                ir.nasim.rB7 r11 = ir.nasim.C19938rB7.a
                return r11
            Lc3:
                r1.e(r5)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.Room.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class h implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Float.valueOf(((Participant) obj).d()), Float.valueOf(((Participant) obj2).d()));
        }
    }

    public static final class i extends ConnectivityManager.NetworkCallback {
        i() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            AbstractC13042fc3.i(network, "network");
            if (Room.this.H) {
                AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                if (UI3.c.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.g(null, "network connection available, reconnecting", new Object[0]);
                }
                Room.this.Z0();
                Room.this.H = false;
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            AbstractC13042fc3.i(network, "network");
            Room.this.H = true;
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C20597sH3 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(C20597sH3 c20597sH3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c20597sH3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return Room.this.new j(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Room room = Room.this;
                RoomEvent.LocalTrackSubscribed localTrackSubscribed = new RoomEvent.LocalTrackSubscribed(room, this.d, room.B0());
                this.b = 1;
                if (room.q0(localTrackSubscribed, this) == objE) {
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
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ Room a;

            public a(Room room) {
                this.a = room;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                ZW4 zw4 = (ZW4) obj;
                if (zw4 instanceof ZW4.m) {
                    Room room = this.a;
                    ZW4.m mVar = (ZW4.m) zw4;
                    Object objQ0 = room.q0(new RoomEvent.TrackPublished(room, mVar.a(), mVar.getParticipant()), interfaceC20295rm1);
                    if (objQ0 == AbstractC14862ic3.e()) {
                        return objQ0;
                    }
                } else if (zw4 instanceof ZW4.c) {
                    Room room2 = this.a;
                    ZW4.c cVar = (ZW4.c) zw4;
                    Object objQ02 = room2.q0(new RoomEvent.TrackPublicationFailed(room2, cVar.getTrack(), cVar.getParticipant(), cVar.a()), interfaceC20295rm1);
                    if (objQ02 == AbstractC14862ic3.e()) {
                        return objQ02;
                    }
                } else if (zw4 instanceof ZW4.s) {
                    Room room3 = this.a;
                    ZW4.s sVar = (ZW4.s) zw4;
                    Object objQ03 = room3.q0(new RoomEvent.TrackUnpublished(room3, sVar.a(), sVar.getParticipant()), interfaceC20295rm1);
                    if (objQ03 == AbstractC14862ic3.e()) {
                        return objQ03;
                    }
                } else if (zw4 instanceof ZW4.i) {
                    Room room4 = this.a;
                    Participant participant = zw4.getParticipant();
                    ZW4.i iVar = (ZW4.i) zw4;
                    Object objQ04 = room4.q0(new RoomEvent.ParticipantPermissionsChanged(room4, participant, iVar.getNewPermissions(), iVar.getOldPermissions()), interfaceC20295rm1);
                    if (objQ04 == AbstractC14862ic3.e()) {
                        return objQ04;
                    }
                } else if (zw4 instanceof ZW4.g) {
                    Room room5 = this.a;
                    Object objQ05 = room5.q0(new RoomEvent.ParticipantMetadataChanged(room5, zw4.getParticipant(), ((ZW4.g) zw4).getPrevMetadata()), interfaceC20295rm1);
                    if (objQ05 == AbstractC14862ic3.e()) {
                        return objQ05;
                    }
                } else if (zw4 instanceof ZW4.a) {
                    Room room6 = this.a;
                    Participant participant2 = zw4.getParticipant();
                    ZW4.a aVar = (ZW4.a) zw4;
                    Object objQ06 = room6.q0(new RoomEvent.ParticipantAttributesChanged(room6, participant2, aVar.getChangedAttributes(), aVar.getOldAttributes()), interfaceC20295rm1);
                    if (objQ06 == AbstractC14862ic3.e()) {
                        return objQ06;
                    }
                } else if (zw4 instanceof ZW4.h) {
                    Room room7 = this.a;
                    Object objQ07 = room7.q0(new RoomEvent.ParticipantNameChanged(room7, zw4.getParticipant(), ((ZW4.h) zw4).getName()), interfaceC20295rm1);
                    if (objQ07 == AbstractC14862ic3.e()) {
                        return objQ07;
                    }
                } else if (zw4 instanceof ZW4.k) {
                    Room room8 = this.a;
                    Participant participant3 = zw4.getParticipant();
                    ZW4.k kVar = (ZW4.k) zw4;
                    new RoomEvent.ParticipantStateChanged(room8, participant3, kVar.getNewState(), kVar.getOldState());
                }
                return C19938rB7.a;
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return Room.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC7983Ua2 interfaceC7983Ua2G = Room.this.B0().g();
                Room room = Room.this;
                InterfaceC10040ay6 interfaceC10040ay6A = interfaceC7983Ua2G.a();
                a aVar = new a(room);
                this.b = 1;
                if (interfaceC10040ay6A.b(aVar, this) == objE) {
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
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class l extends AbstractC8614Ws3 implements InterfaceC14603iB2 {

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[c.values().length];
                try {
                    iArr[c.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[c.c.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        l() {
            super(2);
        }

        public final void a(c cVar, c cVar2) {
            AbstractC13042fc3.i(cVar, "new");
            AbstractC13042fc3.i(cVar2, "old");
            if (cVar != cVar2) {
                int i = a.a[cVar.ordinal()];
                if (i == 1) {
                    Room.this.s0().start();
                    Room.this.j.start();
                } else {
                    if (i != 2) {
                        return;
                    }
                    Room.this.s0().stop();
                    Room.this.j.stop();
                    Room.this.p.stop();
                }
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((c) obj, (c) obj2);
            return C19938rB7.a;
        }
    }

    public Room(Context context, io.livekit.android.room.f fVar, EglBase eglBase, a.InterfaceC0225a interfaceC0225a, C19977rG1 c19977rG1, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, IN in, ZV0 zv0, AbstractC24096y22.a aVar, InterfaceC10670c01 interfaceC10670c01, InterfaceC24893zO interfaceC24893zO, C6952Pr3 c6952Pr3, UA2 ua2, AudioDeviceModule audioDeviceModule, h.a aVar2, InterfaceC3503Bd1 interfaceC3503Bd1, IO io2, F53 f53, d.a aVar3) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(fVar, "engine");
        AbstractC13042fc3.i(eglBase, "eglBase");
        AbstractC13042fc3.i(interfaceC0225a, "localParticipantFactory");
        AbstractC13042fc3.i(c19977rG1, "defaultsManager");
        AbstractC13042fc3.i(abstractC13778go1, "defaultDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "ioDispatcher");
        AbstractC13042fc3.i(in, "audioHandler");
        AbstractC13042fc3.i(zv0, "closeableManager");
        AbstractC13042fc3.i(aVar, "e2EEManagerFactory");
        AbstractC13042fc3.i(interfaceC10670c01, "communicationWorkaround");
        AbstractC13042fc3.i(interfaceC24893zO, "audioProcessingController");
        AbstractC13042fc3.i(c6952Pr3, "lkObjects");
        AbstractC13042fc3.i(ua2, "networkCallbackManagerFactory");
        AbstractC13042fc3.i(audioDeviceModule, "audioDeviceModule");
        AbstractC13042fc3.i(aVar2, "regionUrlProviderFactory");
        AbstractC13042fc3.i(interfaceC3503Bd1, "connectionWarmer");
        AbstractC13042fc3.i(io2, "audioRecordPrewarmer");
        AbstractC13042fc3.i(f53, "incomingDataStreamManager");
        AbstractC13042fc3.i(aVar3, "remoteParticipantFactory");
        this.a = context;
        this.b = fVar;
        this.c = eglBase;
        this.d = c19977rG1;
        this.e = abstractC13778go1;
        this.f = abstractC13778go12;
        this.g = in;
        this.h = zv0;
        this.i = aVar;
        this.j = interfaceC10670c01;
        this.k = interfaceC24893zO;
        this.l = c6952Pr3;
        this.m = audioDeviceModule;
        this.n = aVar2;
        this.o = interfaceC3503Bd1;
        this.p = io2;
        this.q = f53;
        this.r = aVar3;
        C9080Yk0 c9080Yk0 = new C9080Yk0();
        this.t = c9080Yk0;
        this.u = c9080Yk0.e();
        fVar.Q0(this);
        this.v = AbstractC5508Jq2.c(null, null, 2, null);
        this.w = AbstractC5508Jq2.c(null, null, 2, null);
        this.x = AbstractC5508Jq2.a(c.c, new l());
        this.y = AbstractC5508Jq2.c(null, null, 2, null);
        this.z = AbstractC5508Jq2.c(Boolean.FALSE, null, 2, null);
        this.A = true;
        io.livekit.android.room.participant.a aVarA = interfaceC0225a.a(false);
        aVarA.F(this);
        this.D = aVarA;
        this.E = AbstractC5508Jq2.c(AbstractC20051rO3.k(), null, 2, null);
        this.F = new LinkedHashMap();
        this.G = AbstractC5508Jq2.c(AbstractC10360bX0.m(), null, 2, null);
        this.I = new C14870id1(false, null, null, false, false, null, 63, null);
        this.J = AbstractC20899sn4.b(false, 1, null);
        this.M = new LinkedHashMap();
        this.N = (InterfaceC6710Oq4) ua2.invoke(new i());
    }

    private final List D0() {
        return (List) this.G.h(this, O[6]);
    }

    private final Map E0() {
        return (Map) this.E.h(this, O[5]);
    }

    private final synchronized io.livekit.android.room.participant.d F0(String str, LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        C12889fL5 c12889fL5 = new C12889fL5();
        Object obj = L0().get(Participant.Identity.a(str));
        c12889fL5.a = obj;
        if (obj != null) {
            return (io.livekit.android.room.participant.d) obj;
        }
        io.livekit.android.room.participant.d dVarA = this.r.a(livekitModels$ParticipantInfo);
        c12889fL5.a = dVarA;
        dVarA.F(this);
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new f(c12889fL5, this, null), 3, null);
        ((io.livekit.android.room.participant.d) c12889fL5.a).Q(livekitModels$ParticipantInfo);
        Map mapA = AbstractC20051rO3.A(E0());
        mapA.put(Participant.Identity.a(str), c12889fL5.a);
        i1(mapA);
        this.F.put(Participant.Sid.a(((io.livekit.android.room.participant.d) c12889fL5.a).o()), Participant.Identity.a(str));
        return (io.livekit.android.room.participant.d) c12889fL5.a;
    }

    private final void S0(List list) {
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        io.livekit.android.room.participant.a aVar = this.D;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LivekitModels$SpeakerInfo livekitModels$SpeakerInfo = (LivekitModels$SpeakerInfo) it.next();
            String sid = livekitModels$SpeakerInfo.getSid();
            AbstractC13042fc3.h(sid, "getSid(...)");
            String strB = Participant.Sid.b(sid);
            linkedHashSet.add(Participant.Sid.a(strB));
            Participant participantJ0 = J0(strB);
            if (participantJ0 != null) {
                participantJ0.C(livekitModels$SpeakerInfo.getLevel());
                participantJ0.M(true);
                arrayList.add(participantJ0);
            }
        }
        if (!linkedHashSet.contains(Participant.Sid.a(aVar.o()))) {
            aVar.C(0.0f);
            aVar.M(false);
        }
        Collection collectionValues = L0().values();
        ArrayList<io.livekit.android.room.participant.d> arrayList2 = new ArrayList();
        for (Object obj : collectionValues) {
            if (!linkedHashSet.contains(Participant.Sid.a(((io.livekit.android.room.participant.d) obj).o()))) {
                arrayList2.add(obj);
            }
        }
        for (io.livekit.android.room.participant.d dVar : arrayList2) {
            dVar.C(0.0f);
            dVar.M(false);
        }
        h1(AbstractC15401jX0.m1(arrayList));
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.ActiveSpeakersChanged activeSpeakersChanged = new RoomEvent.ActiveSpeakersChanged(this, D0());
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(activeSpeakersChanged, interfaceC20315ro1);
    }

    private final void T0(UT1 ut1) {
        if (O0() == c.c) {
            return;
        }
        AbstractC9913am0.b(null, new g(ut1, null), 1, null);
    }

    private final void U0(String str) {
        Map mapA = AbstractC20051rO3.A(E0());
        io.livekit.android.room.participant.d dVar = (io.livekit.android.room.participant.d) mapA.remove(Participant.Identity.a(str));
        if (dVar == null) {
            return;
        }
        Iterator it = AbstractC15401jX0.m1(dVar.r().values()).iterator();
        while (it.hasNext()) {
            dVar.X(((AbstractC4838Gt7) it.next()).e(), true);
        }
        i1(mapA);
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.ParticipantDisconnected participantDisconnected = new RoomEvent.ParticipantDisconnected(this, dVar);
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(participantDisconnected, interfaceC20315ro1);
        this.D.D0(str);
    }

    private final void V0(List list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Participant participant : r0()) {
            linkedHashMap.put(Participant.Sid.a(participant.o()), participant);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LivekitModels$SpeakerInfo livekitModels$SpeakerInfo = (LivekitModels$SpeakerInfo) it.next();
            String sid = livekitModels$SpeakerInfo.getSid();
            AbstractC13042fc3.h(sid, "getSid(...)");
            String strB = Participant.Sid.b(sid);
            Participant participantJ0 = J0(strB);
            if (participantJ0 != null) {
                participantJ0.C(livekitModels$SpeakerInfo.getLevel());
                participantJ0.M(livekitModels$SpeakerInfo.getActive());
                if (livekitModels$SpeakerInfo.getActive()) {
                    linkedHashMap.put(Participant.Sid.a(strB), participantJ0);
                } else {
                    linkedHashMap.remove(Participant.Sid.a(strB));
                }
            }
        }
        h1(AbstractC15401jX0.m1(AbstractC15401jX0.a1(AbstractC15401jX0.m1(linkedHashMap.values()), new h())));
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.ActiveSpeakersChanged activeSpeakersChanged = new RoomEvent.ActiveSpeakersChanged(this, D0());
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(activeSpeakersChanged, interfaceC20315ro1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0() {
        if (O0() == c.d) {
            return;
        }
        this.b.I0();
    }

    private final void a1() {
        boolean zD = this.I.d();
        ArrayList arrayList = new ArrayList();
        for (io.livekit.android.room.participant.d dVar : L0().values()) {
            LivekitModels$ParticipantTracks.a aVarNewBuilder = LivekitModels$ParticipantTracks.newBuilder();
            aVarNewBuilder.C(dVar.o());
            for (AbstractC4838Gt7 abstractC4838Gt7 : dVar.r().values()) {
                AN5 an5 = abstractC4838Gt7 instanceof AN5 ? (AN5) abstractC4838Gt7 : null;
                if (an5 != null && an5.g() != zD) {
                    aVarNewBuilder.A(an5.e());
                }
            }
            if (aVarNewBuilder.B() > 0) {
                GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                arrayList.add(generatedMessageLiteA);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((LivekitModels$ParticipantTracks) it.next()).getTrackSidsList());
        }
        LivekitRtc$UpdateSubscription livekitRtc$UpdateSubscription = (LivekitRtc$UpdateSubscription) LivekitRtc$UpdateSubscription.newBuilder().C(!zD).A(arrayList).B(AbstractC10976cX0.z(arrayList2)).a();
        List listD = YG3.d(this.D);
        io.livekit.android.room.f fVar = this.b;
        AbstractC13042fc3.f(livekitRtc$UpdateSubscription);
        fVar.O0(livekitRtc$UpdateSubscription, listD);
    }

    private final void g1(String str) {
        this.y.i(this, O[3], str);
    }

    private final void h1(List list) {
        this.G.i(this, O[6], list);
    }

    private final void i1(Map map) {
        this.E.i(this, O[5], map);
    }

    private final void j1(String str) {
        this.w.i(this, O[1], str);
    }

    private final void l1(boolean z) {
        this.z.i(this, O[4], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        this.D.b0();
        Iterator it = AbstractC15401jX0.q1(L0().keySet()).iterator();
        while (it.hasNext()) {
            U0(((Participant.Identity) it.next()).getValue());
        }
        p1(null);
        g1(null);
        j1(null);
        l1(false);
        this.F.clear();
        this.q.E();
    }

    private final void p1(String str) {
        this.v.i(this, O[0], str != null ? Sid.a(str) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q0(RoomEvent roomEvent, InterfaceC20295rm1 interfaceC20295rm1) {
        if (O0() != c.b) {
            return C19938rB7.a;
        }
        Object objC = this.t.c(roomEvent, interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(c cVar) {
        this.x.i(this, O[2], cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1() {
        InterfaceC20315ro1 interfaceC20315ro1;
        InterfaceC20315ro1 interfaceC20315ro12 = this.s;
        if (interfaceC20315ro12 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        } else {
            interfaceC20315ro1 = interfaceC20315ro12;
        }
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new k(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final K26 w0() {
        return new K26(this.C, x0(), null, u0(), Q0(), v0(), R0(), M0(), N0());
    }

    @Override // ir.nasim.InterfaceC16587lX4
    public void A(C20597sH3 c20597sH3, io.livekit.android.room.participant.a aVar) {
        AbstractC13042fc3.i(c20597sH3, "publication");
        AbstractC13042fc3.i(aVar, "participant");
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.TrackUnpublished trackUnpublished = new RoomEvent.TrackUnpublished(this, c20597sH3, aVar);
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(trackUnpublished, interfaceC20315ro1);
    }

    public final InterfaceC7983Ua2 A0() {
        return this.u;
    }

    @Override // ir.nasim.InterfaceC16587lX4
    public void B(AbstractC4838Gt7 abstractC4838Gt7, Participant participant) {
        AbstractC13042fc3.i(abstractC4838Gt7, "publication");
        AbstractC13042fc3.i(participant, "participant");
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.TrackMuted trackMuted = new RoomEvent.TrackMuted(this, abstractC4838Gt7, participant);
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(trackMuted, interfaceC20315ro1);
    }

    public final io.livekit.android.room.participant.a B0() {
        return this.D;
    }

    @Override // ir.nasim.InterfaceC16587lX4
    public void C(AbstractC21649tt7 abstractC21649tt7, AN5 an5, io.livekit.android.room.participant.d dVar) {
        AbstractC13042fc3.i(abstractC21649tt7, "track");
        AbstractC13042fc3.i(an5, "publication");
        AbstractC13042fc3.i(dVar, "participant");
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.TrackUnsubscribed trackUnsubscribed = new RoomEvent.TrackUnsubscribed(this, abstractC21649tt7, an5, dVar);
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(trackUnsubscribed, interfaceC20315ro1);
    }

    public final String C0() {
        return (String) this.y.h(this, O[3]);
    }

    @Override // io.livekit.android.room.f.d
    public void D(List list) {
        AbstractC13042fc3.i(list, "updates");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LivekitModels$ParticipantInfo livekitModels$ParticipantInfo = (LivekitModels$ParticipantInfo) it.next();
            String sid = livekitModels$ParticipantInfo.getSid();
            AbstractC13042fc3.h(sid, "getSid(...)");
            String strB = Participant.Sid.b(sid);
            String identity = livekitModels$ParticipantInfo.getIdentity();
            InterfaceC20315ro1 interfaceC20315ro1 = null;
            if (identity == null || AbstractC20762sZ6.n0(identity)) {
                LivekitModels$ParticipantInfo.c cVar = (LivekitModels$ParticipantInfo.c) livekitModels$ParticipantInfo.toBuilder();
                Participant.Identity identity2 = (Participant.Identity) this.F.get(Participant.Sid.a(strB));
                String value = identity2 != null ? identity2.getValue() : null;
                if (value == null) {
                    value = "";
                }
                cVar.A(value);
                livekitModels$ParticipantInfo = (LivekitModels$ParticipantInfo) cVar.a();
                AbstractC13042fc3.h(livekitModels$ParticipantInfo, "with(...)");
            }
            String identity3 = livekitModels$ParticipantInfo.getIdentity();
            AbstractC13042fc3.h(identity3, "getIdentity(...)");
            String strB2 = Participant.Identity.b(identity3);
            String strH = this.D.h();
            if (strH == null ? false : Participant.Identity.d(strH, strB2)) {
                this.D.Q(livekitModels$ParticipantInfo);
            } else {
                boolean z = !L0().containsKey(Participant.Identity.a(strB2));
                if (livekitModels$ParticipantInfo.getState() == LivekitModels$ParticipantInfo.f.DISCONNECTED) {
                    U0(strB2);
                } else {
                    io.livekit.android.room.participant.d dVarF0 = F0(strB2, livekitModels$ParticipantInfo);
                    if (z) {
                        C9080Yk0 c9080Yk0 = this.t;
                        RoomEvent.ParticipantConnected participantConnected = new RoomEvent.ParticipantConnected(this, dVarF0);
                        InterfaceC20315ro1 interfaceC20315ro12 = this.s;
                        if (interfaceC20315ro12 == null) {
                            AbstractC13042fc3.y("coroutineScope");
                        } else {
                            interfaceC20315ro1 = interfaceC20315ro12;
                        }
                        c9080Yk0.b(participantConnected, interfaceC20315ro1);
                    } else {
                        dVarF0.Q(livekitModels$ParticipantInfo);
                        this.F.put(Participant.Sid.a(strB), Participant.Identity.a(strB2));
                    }
                }
            }
        }
    }

    @Override // ir.nasim.F53
    public void E() {
        this.q.E();
    }

    @Override // ir.nasim.InterfaceC16587lX4
    public void F(AN5 an5, io.livekit.android.room.participant.d dVar) {
        AbstractC13042fc3.i(an5, "publication");
        AbstractC13042fc3.i(dVar, "participant");
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.TrackUnpublished trackUnpublished = new RoomEvent.TrackUnpublished(this, an5, dVar);
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(trackUnpublished, interfaceC20315ro1);
    }

    @Override // ir.nasim.InterfaceC16587lX4
    public void G(AN5 an5, io.livekit.android.room.participant.d dVar) {
        InterfaceC16587lX4.a.b(this, an5, dVar);
    }

    public final Participant G0(String str) {
        AbstractC13042fc3.i(str, "identity");
        return H0(Participant.Identity.b(str));
    }

    @Override // io.livekit.android.room.f.d
    public void H() {
        this.D.I0();
        Iterator it = AbstractC15401jX0.q1(L0().keySet()).iterator();
        while (it.hasNext()) {
            U0(((Participant.Identity) it.next()).getValue());
        }
    }

    public final Participant H0(String str) {
        AbstractC13042fc3.i(str, "identity");
        String strH = this.D.h();
        return strH == null ? false : Participant.Identity.d(str, strH) ? this.D : (Participant) L0().get(Participant.Identity.a(str));
    }

    @Override // io.livekit.android.room.f.d
    public void I(Throwable th) {
        AbstractC13042fc3.i(th, "error");
        this.t.f(new RoomEvent.FailedToConnect(this, th));
    }

    public final Participant I0(String str) {
        AbstractC13042fc3.i(str, "sid");
        return J0(Participant.Sid.b(str));
    }

    @Override // io.livekit.android.room.f.d
    public void J() {
        f.d.a.b(this);
    }

    public final Participant J0(String str) {
        AbstractC13042fc3.i(str, "sid");
        return Participant.Sid.d(str, this.D.o()) ? this.D : (Participant) L0().get(this.F.get(Participant.Sid.a(str)));
    }

    @Override // io.livekit.android.room.f.d
    public void K(List list) {
        AbstractC13042fc3.i(list, "speakers");
        S0(list);
    }

    public final void K0(RTCStatsCollectorCallback rTCStatsCollectorCallback) {
        AbstractC13042fc3.i(rTCStatsCollectorCallback, "callback");
        this.b.x0(rTCStatsCollectorCallback);
    }

    @Override // io.livekit.android.room.f.d
    public void L(LivekitModels$DataPacket livekitModels$DataPacket) {
        AbstractC13042fc3.i(livekitModels$DataPacket, "dp");
        LivekitModels$DataPacket.c valueCase = livekitModels$DataPacket.getValueCase();
        int i2 = valueCase == null ? -1 : d.b[valueCase.ordinal()];
        if (i2 == 1) {
            F53 f53 = this.q;
            LivekitModels$DataStream.Header streamHeader = livekitModels$DataPacket.getStreamHeader();
            AbstractC13042fc3.h(streamHeader, "getStreamHeader(...)");
            String participantIdentity = livekitModels$DataPacket.getParticipantIdentity();
            AbstractC13042fc3.h(participantIdentity, "getParticipantIdentity(...)");
            f53.c(streamHeader, Participant.Identity.b(participantIdentity));
            return;
        }
        if (i2 == 2) {
            F53 f532 = this.q;
            LivekitModels$DataStream.Chunk streamChunk = livekitModels$DataPacket.getStreamChunk();
            AbstractC13042fc3.h(streamChunk, "getStreamChunk(...)");
            f532.a(streamChunk);
            return;
        }
        if (i2 != 3) {
            return;
        }
        F53 f533 = this.q;
        LivekitModels$DataStream.Trailer streamTrailer = livekitModels$DataPacket.getStreamTrailer();
        AbstractC13042fc3.h(streamTrailer, "getStreamTrailer(...)");
        f533.r(streamTrailer);
    }

    public final Map L0() {
        return E0();
    }

    @Override // io.livekit.android.room.f.d
    public void M(LivekitModels$DataPacket livekitModels$DataPacket) {
        AbstractC13042fc3.i(livekitModels$DataPacket, "dp");
        this.D.y0(livekitModels$DataPacket);
    }

    public final C23060wH3 M0() {
        return this.d.c();
    }

    @Override // io.livekit.android.room.f.d
    public void N() {
        q1(c.b);
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.Reconnected reconnected = new RoomEvent.Reconnected(this);
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(reconnected, interfaceC20315ro1);
    }

    public final FV7 N0() {
        return this.d.d();
    }

    @Override // ir.nasim.InterfaceC16587lX4
    public void O(AbstractC21649tt7 abstractC21649tt7, AN5 an5, io.livekit.android.room.participant.d dVar) {
        AbstractC13042fc3.i(abstractC21649tt7, "track");
        AbstractC13042fc3.i(an5, "publication");
        AbstractC13042fc3.i(dVar, "participant");
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.TrackSubscribed trackSubscribed = new RoomEvent.TrackSubscribed(this, abstractC21649tt7, an5, dVar);
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(trackSubscribed, interfaceC20315ro1);
    }

    public final c O0() {
        return (c) this.x.h(this, O[2]);
    }

    @Override // io.livekit.android.room.f.d
    public void P() {
        q1(c.d);
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.Reconnecting reconnecting = new RoomEvent.Reconnecting(this);
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(reconnecting, interfaceC20315ro1);
    }

    public final void P0(RTCStatsCollectorCallback rTCStatsCollectorCallback) {
        AbstractC13042fc3.i(rTCStatsCollectorCallback, "callback");
        this.b.A0(rTCStatsCollectorCallback);
    }

    public final C23060wH3 Q0() {
        return this.d.e();
    }

    public final FV7 R0() {
        return this.d.f();
    }

    public final void W0(TextureViewRenderer textureViewRenderer) {
        AbstractC13042fc3.i(textureViewRenderer, "viewRenderer");
        TextureViewRenderer.e(textureViewRenderer, this.c.getEglBaseContext(), null, null, null, 12, null);
        textureViewRenderer.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FIT);
        textureViewRenderer.setEnableHardwareScaler(false);
    }

    public final void X0(SurfaceViewRenderer surfaceViewRenderer) {
        AbstractC13042fc3.i(surfaceViewRenderer, "viewRenderer");
        surfaceViewRenderer.init(this.c.getEglBaseContext(), null);
        surfaceViewRenderer.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FIT);
        surfaceViewRenderer.setEnableHardwareScaler(false);
    }

    public final boolean Y0() {
        return ((Boolean) this.z.h(this, O[4])).booleanValue();
    }

    @Override // ir.nasim.F53
    public void a(LivekitModels$DataStream.Chunk chunk) {
        AbstractC13042fc3.i(chunk, "chunk");
        this.q.a(chunk);
    }

    @Override // io.livekit.android.room.f.d
    public void b(List list) {
        AbstractC4838Gt7 abstractC4838Gt7;
        AbstractC21649tt7 abstractC21649tt7H;
        AbstractC13042fc3.i(list, "streamStates");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LivekitRtc$StreamStateInfo livekitRtc$StreamStateInfo = (LivekitRtc$StreamStateInfo) it.next();
            String participantSid = livekitRtc$StreamStateInfo.getParticipantSid();
            AbstractC13042fc3.h(participantSid, "getParticipantSid(...)");
            Participant participantI0 = I0(participantSid);
            if (participantI0 != null && (abstractC4838Gt7 = (AbstractC4838Gt7) participantI0.r().get(livekitRtc$StreamStateInfo.getTrackSid())) != null && (abstractC21649tt7H = abstractC4838Gt7.h()) != null) {
                AbstractC21649tt7.h.a aVar = AbstractC21649tt7.h.Companion;
                EnumC18788pF3 state = livekitRtc$StreamStateInfo.getState();
                AbstractC13042fc3.h(state, "getState(...)");
                abstractC21649tt7H.o(aVar.a(state));
            }
        }
    }

    public final void b1(IG3 ig3) {
        AbstractC13042fc3.i(ig3, "<set-?>");
        this.d.h(ig3);
    }

    @Override // ir.nasim.F53
    public void c(LivekitModels$DataStream.Header header, String str) {
        AbstractC13042fc3.i(header, "header");
        AbstractC13042fc3.i(str, "fromIdentity");
        this.q.c(header, str);
    }

    public final void c1(C23718xP c23718xP) {
        AbstractC13042fc3.i(c23718xP, "<set-?>");
        this.d.i(c23718xP);
    }

    @Override // io.livekit.android.room.f.d
    public void d(LivekitModels$Room livekitModels$Room) {
        AbstractC13042fc3.i(livekitModels$Room, "update");
        if (livekitModels$Room.getSid() != null) {
            String sid = livekitModels$Room.getSid();
            AbstractC13042fc3.h(sid, "getSid(...)");
            p1(Sid.b(sid));
        }
        String strC0 = C0();
        g1(livekitModels$Room.getMetadata());
        boolean zY0 = Y0();
        l1(livekitModels$Room.getActiveRecording());
        InterfaceC20315ro1 interfaceC20315ro1 = null;
        if (!AbstractC13042fc3.d(strC0, C0())) {
            C9080Yk0 c9080Yk0 = this.t;
            RoomEvent.RoomMetadataChanged roomMetadataChanged = new RoomEvent.RoomMetadataChanged(this, C0(), strC0);
            InterfaceC20315ro1 interfaceC20315ro12 = this.s;
            if (interfaceC20315ro12 == null) {
                AbstractC13042fc3.y("coroutineScope");
                interfaceC20315ro12 = null;
            }
            c9080Yk0.b(roomMetadataChanged, interfaceC20315ro12);
        }
        if (zY0 != Y0()) {
            C9080Yk0 c9080Yk02 = this.t;
            RoomEvent.RecordingStatusChanged recordingStatusChanged = new RoomEvent.RecordingStatusChanged(this, Y0());
            InterfaceC20315ro1 interfaceC20315ro13 = this.s;
            if (interfaceC20315ro13 == null) {
                AbstractC13042fc3.y("coroutineScope");
            } else {
                interfaceC20315ro1 = interfaceC20315ro13;
            }
            c9080Yk02.b(recordingStatusChanged, interfaceC20315ro1);
        }
    }

    public final void d1(boolean z) {
        this.D.Y0(z);
    }

    @Override // io.livekit.android.room.f.d
    public void e(LivekitRtc$TrackUnpublishedResponse livekitRtc$TrackUnpublishedResponse) {
        AbstractC13042fc3.i(livekitRtc$TrackUnpublishedResponse, "trackUnpublished");
        this.D.C0(livekitRtc$TrackUnpublishedResponse);
    }

    @Override // io.livekit.android.room.f.d
    public void f(List list) {
        AbstractC13042fc3.i(list, "updates");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LivekitRtc$ConnectionQualityInfo livekitRtc$ConnectionQualityInfo = (LivekitRtc$ConnectionQualityInfo) it.next();
            EnumC22663vd1.a aVar = EnumC22663vd1.Companion;
            QE3 quality = livekitRtc$ConnectionQualityInfo.getQuality();
            AbstractC13042fc3.h(quality, "getQuality(...)");
            EnumC22663vd1 enumC22663vd1A = aVar.a(quality);
            String participantSid = livekitRtc$ConnectionQualityInfo.getParticipantSid();
            AbstractC13042fc3.h(participantSid, "getParticipantSid(...)");
            Participant participantI0 = I0(participantSid);
            if (participantI0 == null) {
                return;
            }
            participantI0.D(enumC22663vd1A);
            C9080Yk0 c9080Yk0 = this.t;
            RoomEvent.ConnectionQualityChanged connectionQualityChanged = new RoomEvent.ConnectionQualityChanged(this, participantI0, enumC22663vd1A);
            InterfaceC20315ro1 interfaceC20315ro1 = this.s;
            if (interfaceC20315ro1 == null) {
                AbstractC13042fc3.y("coroutineScope");
                interfaceC20315ro1 = null;
            }
            c9080Yk0.b(connectionQualityChanged, interfaceC20315ro1);
        }
    }

    public final void f1(boolean z) {
        this.A = z;
    }

    @Override // io.livekit.android.room.f.d
    public void g(String str, boolean z) {
        AbstractC13042fc3.i(str, "trackSid");
        this.D.H0(str, z);
    }

    @Override // io.livekit.android.room.f.d
    public void h(LivekitRtc$SubscriptionPermissionUpdate livekitRtc$SubscriptionPermissionUpdate) {
        AbstractC13042fc3.i(livekitRtc$SubscriptionPermissionUpdate, "subscriptionPermissionUpdate");
        String participantSid = livekitRtc$SubscriptionPermissionUpdate.getParticipantSid();
        AbstractC13042fc3.h(participantSid, "getParticipantSid(...)");
        Participant participantI0 = I0(participantSid);
        io.livekit.android.room.participant.d dVar = participantI0 instanceof io.livekit.android.room.participant.d ? (io.livekit.android.room.participant.d) participantI0 : null;
        if (dVar == null) {
            return;
        }
        dVar.W(livekitRtc$SubscriptionPermissionUpdate);
    }

    @Override // io.livekit.android.room.f.d
    public void i(List list) {
        AbstractC13042fc3.i(list, "speakers");
        V0(list);
    }

    @Override // io.livekit.android.room.f.d
    public void j(LivekitRtc$TrackSubscribed livekitRtc$TrackSubscribed) {
        InterfaceC20315ro1 interfaceC20315ro1;
        AbstractC13042fc3.i(livekitRtc$TrackSubscribed, "response");
        Object obj = this.D.r().get(livekitRtc$TrackSubscribed.getTrackSid());
        C20597sH3 c20597sH3 = obj instanceof C20597sH3 ? (C20597sH3) obj : null;
        if (c20597sH3 == null) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "Could not find local track publication for subscribed event ", new Object[0]);
            return;
        }
        InterfaceC20315ro1 interfaceC20315ro12 = this.s;
        if (interfaceC20315ro12 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        } else {
            interfaceC20315ro1 = interfaceC20315ro12;
        }
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new j(c20597sH3, null), 3, null);
        this.D.G0(c20597sH3);
    }

    @Override // io.livekit.android.room.f.d
    public void k(LivekitRtc$SubscribedQualityUpdate livekitRtc$SubscribedQualityUpdate) {
        AbstractC13042fc3.i(livekitRtc$SubscribedQualityUpdate, "subscribedQualityUpdate");
        this.D.E0(livekitRtc$SubscribedQualityUpdate);
    }

    public final void k1(TJ5 tj5) {
        AbstractC13042fc3.i(tj5, "reconnectType");
        this.b.S0(tj5);
    }

    @Override // io.livekit.android.room.f.d
    public void l(boolean z) {
        if (z) {
            a1();
        }
    }

    @Override // io.livekit.android.room.f.d
    public void m(UT1 ut1) {
        AbstractC13042fc3.i(ut1, "reason");
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.a.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.k(null, "engine did disconnect: " + ut1, new Object[0]);
        }
        T0(ut1);
    }

    public final void m1(K26 k26) {
        AbstractC13042fc3.i(k26, "options");
        IG3 ig3D = k26.d();
        if (ig3D != null) {
            b1(ig3D);
        }
        C23060wH3 c23060wH3J = k26.j();
        if (c23060wH3J != null) {
            r1(c23060wH3J);
        }
        C23718xP c23718xPE = k26.e();
        if (c23718xPE != null) {
            c1(c23718xPE);
        }
        FV7 fv7K = k26.k();
        if (fv7K != null) {
            s1(fv7K);
        }
        C23060wH3 c23060wH3H = k26.h();
        if (c23060wH3H != null) {
            n1(c23060wH3H);
        }
        FV7 fv7I = k26.i();
        if (fv7I != null) {
            o1(fv7I);
        }
        this.C = k26.c();
        d1(k26.f());
        k26.g();
    }

    @Override // io.livekit.android.room.f.d
    public void n(LivekitModels$Transcription livekitModels$Transcription) {
        Map mapR;
        AbstractC13042fc3.i(livekitModels$Transcription, "transcription");
        AbstractC4838Gt7 abstractC4838Gt7 = null;
        if (livekitModels$Transcription.getSegmentsList().isEmpty()) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.d(null, "Received transcription segments are empty.", new Object[0]);
            return;
        }
        String transcribedParticipantIdentity = livekitModels$Transcription.getTranscribedParticipantIdentity();
        AbstractC13042fc3.h(transcribedParticipantIdentity, "getTranscribedParticipantIdentity(...)");
        Participant participantG0 = G0(transcribedParticipantIdentity);
        if (participantG0 != null && (mapR = participantG0.r()) != null) {
            abstractC4838Gt7 = (AbstractC4838Gt7) mapR.get(livekitModels$Transcription.getTrackId());
        }
        List<LivekitModels$TranscriptionSegment> segmentsList = livekitModels$Transcription.getSegmentsList();
        AbstractC13042fc3.h(segmentsList, "getSegmentsList(...)");
        List<LivekitModels$TranscriptionSegment> list = segmentsList;
        ArrayList<C24025xu7> arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        for (LivekitModels$TranscriptionSegment livekitModels$TranscriptionSegment : list) {
            AbstractC13042fc3.f(livekitModels$TranscriptionSegment);
            Long l2 = (Long) this.M.get(livekitModels$TranscriptionSegment.getId());
            arrayList.add(AbstractC24615yu7.a(livekitModels$TranscriptionSegment, l2 != null ? l2.longValue() : new Date().getTime()));
        }
        for (C24025xu7 c24025xu7 : arrayList) {
            if (c24025xu7.a()) {
                this.M.remove(c24025xu7.c());
            } else {
                this.M.put(c24025xu7.c(), Long.valueOf(c24025xu7.b()));
            }
        }
        RoomEvent.TranscriptionReceived transcriptionReceived = new RoomEvent.TranscriptionReceived(this, arrayList, participantG0, abstractC4838Gt7);
        this.t.f(transcriptionReceived);
        if (participantG0 != null) {
            participantG0.z(transcriptionReceived);
        }
        if (abstractC4838Gt7 != null) {
            abstractC4838Gt7.j(transcriptionReceived);
        }
    }

    public final void n1(C23060wH3 c23060wH3) {
        AbstractC13042fc3.i(c23060wH3, "<set-?>");
        this.d.j(c23060wH3);
    }

    @Override // io.livekit.android.room.f.d
    public void o(LivekitRtc$JoinResponse livekitRtc$JoinResponse) throws RoomException.ConnectException {
        AbstractC13042fc3.i(livekitRtc$JoinResponse, "response");
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.c.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.g(null, "Connected to server, server version: " + livekitRtc$JoinResponse.getServerVersion() + ", client version: 2.20.2", new Object[0]);
        }
        if (livekitRtc$JoinResponse.getRoom().getSid() != null) {
            String sid = livekitRtc$JoinResponse.getRoom().getSid();
            AbstractC13042fc3.h(sid, "getSid(...)");
            p1(Sid.b(sid));
        } else {
            p1(null);
        }
        j1(livekitRtc$JoinResponse.getRoom().getName());
        g1(livekitRtc$JoinResponse.getRoom().getMetadata());
        if (livekitRtc$JoinResponse.getRoom().getActiveRecording() != Y0()) {
            l1(livekitRtc$JoinResponse.getRoom().getActiveRecording());
            C9080Yk0 c9080Yk0 = this.t;
            RoomEvent.RecordingStatusChanged recordingStatusChanged = new RoomEvent.RecordingStatusChanged(this, Y0());
            InterfaceC20315ro1 interfaceC20315ro1 = this.s;
            if (interfaceC20315ro1 == null) {
                AbstractC13042fc3.y("coroutineScope");
                interfaceC20315ro1 = null;
            }
            c9080Yk0.b(recordingStatusChanged, interfaceC20315ro1);
        }
        if (!livekitRtc$JoinResponse.hasParticipant()) {
            throw new RoomException.ConnectException("server didn't return a local participant", null, 2, null);
        }
        io.livekit.android.room.participant.a aVar2 = this.D;
        LivekitModels$ParticipantInfo participant = livekitRtc$JoinResponse.getParticipant();
        AbstractC13042fc3.h(participant, "getParticipant(...)");
        aVar2.Q(participant);
        io.livekit.android.room.participant.a aVar3 = this.D;
        List<LivekitModels$Codec> enabledPublishCodecsList = livekitRtc$JoinResponse.getEnabledPublishCodecsList();
        AbstractC13042fc3.h(enabledPublishCodecsList, "getEnabledPublishCodecsList(...)");
        aVar3.Z0(enabledPublishCodecsList);
        AbstractC13042fc3.h(livekitRtc$JoinResponse.getOtherParticipantsList(), "getOtherParticipantsList(...)");
        if (!r0.isEmpty()) {
            List<LivekitModels$ParticipantInfo> otherParticipantsList = livekitRtc$JoinResponse.getOtherParticipantsList();
            AbstractC13042fc3.h(otherParticipantsList, "getOtherParticipantsList(...)");
            for (LivekitModels$ParticipantInfo livekitModels$ParticipantInfo : otherParticipantsList) {
                String identity = livekitModels$ParticipantInfo.getIdentity();
                AbstractC13042fc3.h(identity, "getIdentity(...)");
                String strB = Participant.Identity.b(identity);
                AbstractC13042fc3.f(livekitModels$ParticipantInfo);
                F0(strB, livekitModels$ParticipantInfo);
            }
        }
    }

    public final Object o0(String str, String str2, C14870id1 c14870id1, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new e(c14870id1, str, str2, null), interfaceC20295rm1);
    }

    public final void o1(FV7 fv7) {
        AbstractC13042fc3.i(fv7, "<set-?>");
        this.d.k(fv7);
    }

    @Override // io.livekit.android.room.f.d
    public void p(RtpReceiver rtpReceiver, MediaStreamTrack mediaStreamTrack, MediaStream[] mediaStreamArr) throws TrackException.InvalidTrackTypeException {
        AbstractC13042fc3.i(rtpReceiver, "receiver");
        AbstractC13042fc3.i(mediaStreamTrack, "track");
        AbstractC13042fc3.i(mediaStreamArr, "streams");
        if (mediaStreamArr.length < 0) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.c.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.g(null, "add track with empty streams?", new Object[0]);
            return;
        }
        String id = ((MediaStream) AbstractC10242bK.b0(mediaStreamArr)).getId();
        AbstractC13042fc3.h(id, "getId(...)");
        XV4 xv4A = H26.a(id);
        Object objA = xv4A.a();
        String str = (String) xv4A.b();
        String strId = mediaStreamTrack.id();
        if (str != null && AbstractC20153rZ6.S(str, "TR", false, 2, null)) {
            strId = str;
        }
        String str2 = (String) objA;
        Participant participantI0 = I0(str2);
        io.livekit.android.room.participant.d dVar = participantI0 instanceof io.livekit.android.room.participant.d ? (io.livekit.android.room.participant.d) participantI0 : null;
        if (dVar != null) {
            UA2 ua2O0 = this.b.o0(rtpReceiver);
            AbstractC13042fc3.f(strId);
            io.livekit.android.room.participant.d.S(dVar, mediaStreamTrack, strId, ua2O0, rtpReceiver, this.C, 0, 32, null);
            return;
        }
        AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
        if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
            return;
        }
        AbstractC5270Ip7.e(null, "Tried to add a track for a participant that is not present. sid: " + str2, new Object[0]);
    }

    public final void p0() {
        if (O0() == c.c) {
            return;
        }
        this.b.s0().D();
        T0(UT1.b);
    }

    @Override // ir.nasim.InterfaceC16587lX4
    public void q(Participant participant) {
        InterfaceC16587lX4.a.a(this, participant);
    }

    @Override // ir.nasim.F53
    public void r(LivekitModels$DataStream.Trailer trailer) {
        AbstractC13042fc3.i(trailer, "trailer");
        this.q.r(trailer);
    }

    public final List r0() {
        return D0();
    }

    public final void r1(C23060wH3 c23060wH3) {
        AbstractC13042fc3.i(c23060wH3, "<set-?>");
        this.d.l(c23060wH3);
    }

    @Override // io.livekit.android.room.f.d
    public void s() {
        q1(c.b);
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.Connected connected = new RoomEvent.Connected(this);
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(connected, interfaceC20315ro1);
    }

    public final IN s0() {
        return this.g;
    }

    public final void s1(FV7 fv7) {
        AbstractC13042fc3.i(fv7, "<set-?>");
        this.d.m(fv7);
    }

    @Override // io.livekit.android.room.f.d
    public void t() {
        f.d.a.a(this);
    }

    public final InterfaceC24893zO t0() {
        return this.k;
    }

    @Override // ir.nasim.InterfaceC16587lX4
    public void u(AbstractC4838Gt7 abstractC4838Gt7, Participant participant) {
        AbstractC13042fc3.i(abstractC4838Gt7, "publication");
        AbstractC13042fc3.i(participant, "participant");
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.TrackUnmuted trackUnmuted = new RoomEvent.TrackUnmuted(this, abstractC4838Gt7, participant);
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(trackUnmuted, interfaceC20315ro1);
    }

    public final IG3 u0() {
        return this.d.a();
    }

    @Override // ir.nasim.InterfaceC16587lX4
    public void v(Participant participant, String str) {
        AbstractC13042fc3.i(participant, "participant");
    }

    public final C23718xP v0() {
        return this.d.b();
    }

    @Override // ir.nasim.InterfaceC16587lX4
    public void w(String str, Exception exc, io.livekit.android.room.participant.d dVar) {
        AbstractC13042fc3.i(str, "sid");
        AbstractC13042fc3.i(exc, "exception");
        AbstractC13042fc3.i(dVar, "participant");
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.TrackSubscriptionFailed trackSubscriptionFailed = new RoomEvent.TrackSubscriptionFailed(this, str, exc, dVar);
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(trackSubscriptionFailed, interfaceC20315ro1);
    }

    @Override // io.livekit.android.room.f.d
    public void x(LivekitModels$UserPacket livekitModels$UserPacket, LivekitModels$DataPacket.b bVar) {
        AbstractC13042fc3.i(livekitModels$UserPacket, "packet");
        AbstractC13042fc3.i(bVar, "kind");
        String participantSid = livekitModels$UserPacket.getParticipantSid();
        AbstractC13042fc3.h(participantSid, "getParticipantSid(...)");
        Participant participantI0 = I0(participantSid);
        InterfaceC20315ro1 interfaceC20315ro1 = null;
        io.livekit.android.room.participant.d dVar = participantI0 instanceof io.livekit.android.room.participant.d ? (io.livekit.android.room.participant.d) participantI0 : null;
        byte[] bArrA0 = livekitModels$UserPacket.getPayload().a0();
        String topic = livekitModels$UserPacket.hasTopic() ? livekitModels$UserPacket.getTopic() : null;
        C9080Yk0 c9080Yk0 = this.t;
        AbstractC13042fc3.f(bArrA0);
        RoomEvent.DataReceived dataReceived = new RoomEvent.DataReceived(this, bArrA0, dVar, topic);
        InterfaceC20315ro1 interfaceC20315ro12 = this.s;
        if (interfaceC20315ro12 == null) {
            AbstractC13042fc3.y("coroutineScope");
        } else {
            interfaceC20315ro1 = interfaceC20315ro12;
        }
        c9080Yk0.b(dataReceived, interfaceC20315ro1);
        if (dVar != null) {
            dVar.V(bArrA0, topic);
        }
    }

    public final boolean x0() {
        return this.D.o0();
    }

    @Override // io.livekit.android.room.f.d
    public Object y(boolean z, InterfaceC20295rm1 interfaceC20295rm1) throws ExecutionException, InterruptedException {
        if (z) {
            Object objV0 = this.D.V0(interfaceC20295rm1);
            return objV0 == AbstractC14862ic3.e() ? objV0 : C19938rB7.a;
        }
        Iterator it = AbstractC15401jX0.m1(L0().values()).iterator();
        while (it.hasNext()) {
            for (AbstractC4838Gt7 abstractC4838Gt7 : AbstractC15401jX0.m1(((io.livekit.android.room.participant.d) it.next()).r().values())) {
                AN5 an5 = abstractC4838Gt7 instanceof AN5 ? (AN5) abstractC4838Gt7 : null;
                if (an5 != null && an5.g()) {
                    AbstractC25143zo1.b(an5.r());
                }
            }
        }
        return C19938rB7.a;
    }

    public final boolean y0() {
        return this.A;
    }

    @Override // ir.nasim.InterfaceC16587lX4
    public void z(C20597sH3 c20597sH3, io.livekit.android.room.participant.a aVar) {
        AbstractC13042fc3.i(c20597sH3, "publication");
        AbstractC13042fc3.i(aVar, "participant");
        C9080Yk0 c9080Yk0 = this.t;
        RoomEvent.TrackPublished trackPublished = new RoomEvent.TrackPublished(this, c20597sH3, aVar);
        InterfaceC20315ro1 interfaceC20315ro1 = this.s;
        if (interfaceC20315ro1 == null) {
            AbstractC13042fc3.y("coroutineScope");
            interfaceC20315ro1 = null;
        }
        c9080Yk0.b(trackPublished, interfaceC20315ro1);
    }

    public final io.livekit.android.room.f z0() {
        return this.b;
    }

    public final void e1(AbstractC24096y22 abstractC24096y22) {
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        private /* synthetic */ Object g;
        final /* synthetic */ C14870id1 i;
        final /* synthetic */ String j;
        final /* synthetic */ String k;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ NV1 e;
            final /* synthetic */ C12889fL5 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(NV1 nv1, C12889fL5 c12889fL5) {
                super(1);
                this.e = nv1;
                this.f = c12889fL5;
            }

            public final void a(Throwable th) {
                this.e.dispose();
                this.f.a = th;
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            Object d;
            Object e;
            int f;
            private /* synthetic */ Object g;
            final /* synthetic */ Room h;
            final /* synthetic */ String i;
            final /* synthetic */ String j;
            final /* synthetic */ C14870id1 k;
            final /* synthetic */ C12889fL5 l;

            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ Room c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(Room room, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = room;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    try {
                    } catch (Exception e) {
                        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                        if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                            AbstractC5270Ip7.l(e, "could not fetch region settings", new Object[0]);
                        }
                    }
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        io.livekit.android.room.h hVar = this.c.K;
                        if (hVar != null) {
                            this.b = 1;
                            obj = hVar.f(this);
                            if (obj == objE) {
                                return objE;
                            }
                        }
                        return C19938rB7.a;
                    }
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: io.livekit.android.room.Room$e$b$b, reason: collision with other inner class name */
            static final class C0208b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ Room c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0208b(Room room, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = room;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0208b(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        if (this.c.y0()) {
                            Room room = this.c;
                            io.livekit.android.room.f fVarZ0 = room.z0();
                            this.b = 1;
                            if (AbstractC15244jF5.c(room, fVarZ0, this) == objE) {
                                return objE;
                            }
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
                    return ((C0208b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Room room, String str, String str2, C14870id1 c14870id1, C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.h = room;
                this.i = str;
                this.j = str2;
                this.k = c14870id1;
                this.l = c12889fL5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.h, this.i, this.j, this.k, this.l, interfaceC20295rm1);
                bVar.g = obj;
                return bVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:56:0x0165  */
            /* JADX WARN: Removed duplicated region for block: B:66:0x0190  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x01cb  */
            /* JADX WARN: Removed duplicated region for block: B:72:0x01cc  */
            /* JADX WARN: Removed duplicated region for block: B:80:0x0216  */
            /* JADX WARN: Removed duplicated region for block: B:83:0x0227  */
            /* JADX WARN: Removed duplicated region for block: B:88:0x025c  */
            /* JADX WARN: Removed duplicated region for block: B:91:0x026a  */
            /* JADX WARN: Removed duplicated region for block: B:92:0x0271  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0180 -> B:62:0x0182). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0187 -> B:64:0x018a). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Exception {
                /*
                    Method dump skipped, instructions count: 643
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.Room.e.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class d extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ InterfaceC13730gj3 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(InterfaceC13730gj3 interfaceC13730gj3) {
                super(1);
                this.e = interfaceC13730gj3;
            }

            public final void a(Throwable th) {
                if (th instanceof CancellationException) {
                    this.e.g((CancellationException) th);
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C14870id1 c14870id1, String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.i = c14870id1;
            this.j = str;
            this.k = str2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = Room.this.new e(this.i, this.j, this.k, interfaceC20295rm1);
            eVar.g = obj;
            return eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:47:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x01a5 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x01a6  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01ad A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01ae  */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v15 */
        /* JADX WARN: Type inference failed for: r5v2, types: [ir.nasim.qn4] */
        /* JADX WARN: Type inference failed for: r5v3 */
        /* JADX WARN: Type inference failed for: r5v6, types: [ir.nasim.qn4] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 447
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.Room.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        public static final class c extends L0 implements InterfaceC14371ho1 {
            public c(InterfaceC14371ho1.a aVar) {
                super(aVar);
            }

            @Override // ir.nasim.InterfaceC14371ho1
            public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
            }
        }
    }
}
