package ir.nasim;

import ai.bale.proto.MeetOuterClass$ResponseCall;
import ai.bale.proto.MeetOuterClass$ResponseJoinGroupCall;
import ai.bale.proto.MeetOuterClass$ResponseStartGroupCall;
import ai.bale.proto.MeetStruct$Call;
import ai.bale.proto.MeetStruct$PeerState;
import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import io.livekit.android.events.RoomEvent;
import io.livekit.android.room.Room;
import io.livekit.android.room.participant.Participant;
import ir.nasim.AbstractC21649tt7;
import ir.nasim.AbstractC22594vV7;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.modules.settings.entity.CallRemoteConfig;
import ir.nasim.core.modules.settings.entity.VideoConfig;
import ir.nasim.core.modules.settings.entity.VoiceConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.RTCStatsCollectorCallback;
import okhttp3.OkHttpClient;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.wD3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23024wD3 implements InterfaceC24937zS7 {
    public static final b w = new b(null);
    public static final int x = 8;
    private final A08 a;
    private final SettingsModule b;
    private final Y08 c;
    private final C17536n78 d;
    private final InterfaceC20315ro1 e;
    private final Context f;
    private final OkHttpClient g;
    private BV7 h;
    private boolean i;
    private boolean j;
    private boolean k;
    private M26 l;
    private final InterfaceC9336Zm4 m;
    private InterfaceC13730gj3 n;
    private InterfaceC13730gj3 o;
    private D27 p;
    private final InterfaceC9173Yu3 q;
    private InterfaceC9336Zm4 r;
    private final InterfaceC9336Zm4 s;
    private final Map t;
    private String u;
    private String v;

    /* renamed from: ir.nasim.wD3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.wD3$a$a, reason: collision with other inner class name */
        static final class C1736a implements UA2 {
            final /* synthetic */ EnumC23259wd1 a;

            C1736a(EnumC23259wd1 enumC23259wd1) {
                this.a = enumC23259wd1;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "it");
                return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : this.a, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.wD3$a$b */
        static final class b implements UA2 {
            final /* synthetic */ EnumC23259wd1 a;

            b(EnumC23259wd1 enumC23259wd1) {
                this.a = enumC23259wd1;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "it");
                return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : this.a, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.wD3$a$c */
        static final class c implements UA2 {
            public static final c a = new c();

            c() {
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "it");
                return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.wD3$a$d */
        public /* synthetic */ class d {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC22663vd1.values().length];
                try {
                    iArr[EnumC22663vd1.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC22663vd1.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC22663vd1.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[EnumC22663vd1.d.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[EnumC22663vd1.e.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                a = iArr;
            }
        }

        /* renamed from: ir.nasim.wD3$a$e */
        public static final class e implements InterfaceC4806Gq2 {
            final /* synthetic */ C23024wD3 a;

            public e(C23024wD3 c23024wD3) {
                this.a = c23024wD3;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                BV7 bv7;
                EnumC23259wd1 enumC23259wd1;
                RoomEvent roomEvent = (RoomEvent) obj;
                if (!(roomEvent instanceof RoomEvent.ActiveSpeakersChanged)) {
                    C19406qI3.a("LiveKitCall2", "the event is " + roomEvent.getClass().getName(), new Object[0]);
                }
                if (roomEvent instanceof RoomEvent.Reconnected) {
                    if (this.a.i) {
                        this.a.i = false;
                        this.a.c.e();
                        C19406qI3.a("LiveKitCall2", "Reconnected", new Object[0]);
                    }
                } else if (roomEvent instanceof RoomEvent.Reconnecting) {
                    this.a.i = true;
                    this.a.c.j();
                    C19406qI3.a("LiveKitCall2", "Reconnecting", new Object[0]);
                } else if (roomEvent instanceof RoomEvent.TrackSubscribed) {
                    if (this.a.i) {
                        this.a.i = false;
                        this.a.c.e();
                    }
                } else if (roomEvent instanceof RoomEvent.ConnectionQualityChanged) {
                    RoomEvent.ConnectionQualityChanged connectionQualityChanged = (RoomEvent.ConnectionQualityChanged) roomEvent;
                    String strH = connectionQualityChanged.getParticipant().h();
                    if (strH == null) {
                        strH = null;
                    }
                    C19406qI3.a("LiveKitCall2", "participant " + Participant.Sid.f(connectionQualityChanged.getParticipant().o()) + " => is local " + Participant.Sid.d(connectionQualityChanged.getParticipant().o(), this.a.h0().B0().o()) + " and connection quality is " + connectionQualityChanged.getQuality(), new Object[0]);
                    int i = d.a[connectionQualityChanged.getQuality().ordinal()];
                    if (i == 1) {
                        enumC23259wd1 = EnumC23259wd1.a;
                    } else if (i == 2) {
                        enumC23259wd1 = EnumC23259wd1.b;
                    } else if (i == 3) {
                        enumC23259wd1 = EnumC23259wd1.c;
                    } else {
                        if (i != 4 && i != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        enumC23259wd1 = EnumC23259wd1.d;
                    }
                    if (AbstractC13042fc3.d(strH, ((M26) this.a.s.getValue()).j())) {
                        this.a.a0(new C1736a(enumC23259wd1));
                    } else {
                        this.a.b0(connectionQualityChanged.getParticipant().h(), new b(enumC23259wd1));
                    }
                } else if (roomEvent instanceof RoomEvent.TrackUnpublished) {
                    RoomEvent.TrackUnpublished trackUnpublished = (RoomEvent.TrackUnpublished) roomEvent;
                    if (trackUnpublished.getPublication().f() == AbstractC21649tt7.g.d) {
                        this.a.b0(trackUnpublished.getParticipant().h(), c.a);
                    }
                } else if ((roomEvent instanceof RoomEvent.RecordingStatusChanged) && (bv7 = this.a.h) != null) {
                    bv7.d(this.a.h0().Y0());
                }
                return C19938rB7.a;
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23024wD3.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC7983Ua2 interfaceC7983Ua2A0 = C23024wD3.this.h0().A0();
                C23024wD3 c23024wD3 = C23024wD3.this;
                InterfaceC10040ay6 interfaceC10040ay6A = interfaceC7983Ua2A0.a();
                e eVar = new e(c23024wD3);
                this.b = 1;
                if (interfaceC10040ay6A.b(eVar, this) == objE) {
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

    /* renamed from: ir.nasim.wD3$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.wD3$c */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC23021wD0.values().length];
            try {
                iArr[EnumC23021wD0.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC23021wD0.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.wD3$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD3$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C22464vH3 c;
        final /* synthetic */ EnumC23021wD0 d;
        final /* synthetic */ C23024wD3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C22464vH3 c22464vH3, EnumC23021wD0 enumC23021wD0, C23024wD3 c23024wD3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c22464vH3;
            this.d = enumC23021wD0;
            this.e = c23024wD3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C22464vH3.K(this.c, null, this.d, 1, null);
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.e.m;
            EnumC23021wD0 enumC23021wD0 = this.d;
            do {
                value = interfaceC9336Zm4.getValue();
                ((Boolean) value).booleanValue();
            } while (!interfaceC9336Zm4.f(value, AbstractC6392Nk0.a(enumC23021wD0 == EnumC23021wD0.a)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD3$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23024wD3.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                C23024wD3.this.h0().p0();
            } catch (Exception e) {
                C19406qI3.a("LiveKitCall2", "declineCall, call disconnect exception: " + e, new Object[0]);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD3$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23024wD3.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C23024wD3.this.q0();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD3$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23024wD3.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            BV7 bv7 = C23024wD3.this.h;
            if (bv7 != null) {
                bv7.b(C23024wD3.this.s);
            }
            BV7 bv72 = C23024wD3.this.h;
            if (bv72 != null) {
                bv72.c(C23024wD3.this.r);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD3$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        boolean e;
        boolean f;
        boolean g;
        int h;
        final /* synthetic */ boolean j;
        final /* synthetic */ boolean k;
        final /* synthetic */ boolean l;
        final /* synthetic */ boolean m;
        final /* synthetic */ String n;
        final /* synthetic */ String o;

        /* renamed from: ir.nasim.wD3$i$a */
        static final class a extends AbstractC19859r37 implements UA2 {
            int b;
            final /* synthetic */ Room c;
            final /* synthetic */ String d;
            final /* synthetic */ String e;
            final /* synthetic */ C14870id1 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Room room, String str, String str2, C14870id1 c14870id1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(1, interfaceC20295rm1);
                this.c = room;
                this.d = str;
                this.e = str2;
                this.f = c14870id1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Room room = this.c;
                    String str = this.d;
                    String str2 = this.e;
                    C14870id1 c14870id1 = this.f;
                    this.b = 1;
                    obj = room.o0(str, str2, c14870id1, this);
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

            @Override // ir.nasim.UA2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.j = z;
            this.k = z2;
            this.l = z3;
            this.m = z4;
            this.n = str;
            this.o = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(Room room) {
            room.p0();
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23024wD3.this.new i(this.j, this.k, this.l, this.m, this.n, this.o, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x0151 A[Catch: Exception -> 0x0025, TryCatch #0 {Exception -> 0x0025, blocks: (B:7:0x0020, B:49:0x0138, B:50:0x013c, B:54:0x0156, B:56:0x0184, B:53:0x0151, B:14:0x0042, B:42:0x0113, B:44:0x0118, B:17:0x004c, B:19:0x0063, B:38:0x00c6, B:20:0x0074, B:22:0x0093, B:24:0x0099, B:26:0x009f, B:28:0x00a9, B:30:0x00ad, B:32:0x00b3, B:34:0x00b9, B:36:0x00c3), top: B:61:0x000a }] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r36) {
            /*
                Method dump skipped, instructions count: 435
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23024wD3.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD3$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23024wD3.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                io.livekit.android.room.participant.a aVarB0 = C23024wD3.this.h0().B0();
                this.b = 1;
                if (aVarB0.X0(true, this) == objE) {
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

    /* renamed from: ir.nasim.wD3$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.wD3$k$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C23024wD3 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C23024wD3 c23024wD3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c23024wD3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
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
                if (((Room.c) this.c) == Room.c.c) {
                    this.d.c.f();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Room.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(cVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23024wD3.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6E = AbstractC5508Jq2.e(new AbstractC24042xw5(C23024wD3.this.h0()) { // from class: ir.nasim.wD3.k.a
                    @Override // ir.nasim.InterfaceC3820Cm3
                    public Object get() {
                        return ((Room) this.receiver).O0();
                    }
                });
                b bVar = new b(C23024wD3.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6E, bVar, this) == objE) {
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
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD3$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ C23024wD3 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(boolean z, C23024wD3 c23024wD3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = c23024wD3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new l(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            M26 m26;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19406qI3.a("LiveKitCall2", "mute audio => status " + this.c, new Object[0]);
                if (this.d.j) {
                    io.livekit.android.room.participant.a aVarB0 = this.d.h0().B0();
                    boolean z = !this.c;
                    this.b = 1;
                    if (aVarB0.a1(z, this) == objE) {
                        return objE;
                    }
                } else {
                    C19406qI3.a("LiveKitCall2", "mute audio user not connected to the room", new Object[0]);
                    C23024wD3 c23024wD3 = this.d;
                    M26 m262 = c23024wD3.l;
                    c23024wD3.l = m262.a((32735 & 1) != 0 ? m262.a : this.c, (32735 & 2) != 0 ? m262.b : false, (32735 & 4) != 0 ? m262.c : false, (32735 & 8) != 0 ? m262.d : false, (32735 & 16) != 0 ? m262.e : null, (32735 & 32) != 0 ? m262.f : null, (32735 & 64) != 0 ? m262.g : null, (32735 & 128) != 0 ? m262.h : null, (32735 & 256) != 0 ? m262.i : null, (32735 & 512) != 0 ? m262.j : false, (32735 & 1024) != 0 ? m262.k : null, (32735 & 2048) != 0 ? m262.l : null, (32735 & 4096) != 0 ? m262.m : null, (32735 & 8192) != 0 ? m262.n : null, (32735 & 16384) != 0 ? m262.o : null);
                    InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.s;
                    C23024wD3 c23024wD32 = this.d;
                    do {
                        value = interfaceC9336Zm4.getValue();
                        m26 = (M26) value;
                    } while (!interfaceC9336Zm4.f(value, m26.a((32735 & 1) != 0 ? m26.a : c23024wD32.l.s(), (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null)));
                    C19938rB7 c19938rB7 = C19938rB7.a;
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
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD3$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23024wD3.this.new m(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                io.livekit.android.room.participant.a aVarB0 = C23024wD3.this.h0().B0();
                boolean z = !this.d;
                this.b = 1;
                if (aVarB0.X0(z, this) == objE) {
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
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD3$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.wD3$n$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C23024wD3 c;

            /* renamed from: ir.nasim.wD3$n$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C23024wD3 d;

                /* renamed from: ir.nasim.wD3$n$a$b$b, reason: collision with other inner class name */
                static final class C1739b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ boolean c;
                    final /* synthetic */ C23024wD3 d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1739b(C23024wD3 c23024wD3, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = c23024wD3;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1739b c1739b = new C1739b(this.d, interfaceC20295rm1);
                        c1739b.c = ((Boolean) obj).booleanValue();
                        return c1739b;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        boolean z = this.c;
                        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.s;
                        while (true) {
                            Object value = interfaceC9336Zm4.getValue();
                            M26 m26 = (M26) value;
                            InterfaceC9336Zm4 interfaceC9336Zm42 = interfaceC9336Zm4;
                            if (interfaceC9336Zm42.f(value, m26.a((32735 & 1) != 0 ? m26.a : z, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null))) {
                                return C19938rB7.a;
                            }
                            interfaceC9336Zm4 = interfaceC9336Zm42;
                        }
                    }

                    public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1739b) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(C23024wD3 c23024wD3, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c23024wD3;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    b bVar = new b(this.d, interfaceC20295rm1);
                    bVar.c = obj;
                    return bVar;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC10258bL6 interfaceC10258bL6E = AbstractC5508Jq2.e(new AbstractC24042xw5((AbstractC4838Gt7) this.c) { // from class: ir.nasim.wD3.n.a.b.a
                            @Override // ir.nasim.InterfaceC3820Cm3
                            public Object get() {
                                return Boolean.valueOf(((AbstractC4838Gt7) this.receiver).b());
                            }
                        });
                        C1739b c1739b = new C1739b(this.d, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC10258bL6E, c1739b, this) == objE) {
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
                public final Object invoke(AbstractC4838Gt7 abstractC4838Gt7, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((b) create(abstractC4838Gt7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.wD3$n$a$c */
            public static final class c implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.wD3$n$a$c$a, reason: collision with other inner class name */
                public static final class C1740a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.wD3$n$a$c$a$a, reason: collision with other inner class name */
                    public static final class C1741a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1741a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1740a.this.a(null, this);
                        }
                    }

                    public C1740a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.C23024wD3.n.a.c.C1740a.C1741a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.wD3$n$a$c$a$a r0 = (ir.nasim.C23024wD3.n.a.c.C1740a.C1741a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.wD3$n$a$c$a$a r0 = new ir.nasim.wD3$n$a$c$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L4b
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            r2 = r5
                            java.util.List r2 = (java.util.List) r2
                            java.util.Collection r2 = (java.util.Collection) r2
                            boolean r2 = r2.isEmpty()
                            r2 = r2 ^ r3
                            if (r2 == 0) goto L4b
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L4b
                            return r1
                        L4b:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23024wD3.n.a.c.C1740a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1740a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.wD3$n$a$d */
            public static final class d implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.wD3$n$a$d$a, reason: collision with other inner class name */
                public static final class C1742a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.wD3$n$a$d$a$a, reason: collision with other inner class name */
                    public static final class C1743a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1743a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1742a.this.a(null, this);
                        }
                    }

                    public C1742a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof ir.nasim.C23024wD3.n.a.d.C1742a.C1743a
                            if (r0 == 0) goto L13
                            r0 = r7
                            ir.nasim.wD3$n$a$d$a$a r0 = (ir.nasim.C23024wD3.n.a.d.C1742a.C1743a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.wD3$n$a$d$a$a r0 = new ir.nasim.wD3$n$a$d$a$a
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r7)
                            goto L68
                        L29:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L31:
                            ir.nasim.AbstractC10685c16.b(r7)
                            ir.nasim.Gq2 r7 = r5.a
                            java.util.List r6 = (java.util.List) r6
                            java.lang.Iterable r6 = (java.lang.Iterable) r6
                            java.util.ArrayList r2 = new java.util.ArrayList
                            r4 = 10
                            int r4 = ir.nasim.ZW0.x(r6, r4)
                            r2.<init>(r4)
                            java.util.Iterator r6 = r6.iterator()
                        L49:
                            boolean r4 = r6.hasNext()
                            if (r4 == 0) goto L5f
                            java.lang.Object r4 = r6.next()
                            ir.nasim.XV4 r4 = (ir.nasim.XV4) r4
                            java.lang.Object r4 = r4.a()
                            ir.nasim.Gt7 r4 = (ir.nasim.AbstractC4838Gt7) r4
                            r2.add(r4)
                            goto L49
                        L5f:
                            r0.b = r3
                            java.lang.Object r6 = r7.a(r2, r0)
                            if (r6 != r1) goto L68
                            return r1
                        L68:
                            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23024wD3.n.a.d.C1742a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1742a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.wD3$n$a$e */
            public static final class e implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.wD3$n$a$e$a, reason: collision with other inner class name */
                public static final class C1744a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.wD3$n$a$e$a$a, reason: collision with other inner class name */
                    public static final class C1745a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1745a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1744a.this.a(null, this);
                        }
                    }

                    public C1744a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.C23024wD3.n.a.e.C1744a.C1745a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.wD3$n$a$e$a$a r0 = (ir.nasim.C23024wD3.n.a.e.C1744a.C1745a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.wD3$n$a$e$a$a r0 = new ir.nasim.wD3$n$a$e$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L45
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            java.util.List r5 = (java.util.List) r5
                            java.lang.Object r5 = ir.nasim.ZW0.C0(r5)
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L45
                            return r1
                        L45:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23024wD3.n.a.e.C1744a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public e(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1744a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C23024wD3 c23024wD3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c23024wD3;
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
                    e eVar = new e(new c(new d(AbstractC5508Jq2.e(new AbstractC24042xw5(this.c.h0().B0()) { // from class: ir.nasim.wD3.n.a.a
                        @Override // ir.nasim.InterfaceC3820Cm3
                        public Object get() {
                            return ((io.livekit.android.room.participant.a) this.receiver).e();
                        }
                    }))));
                    b bVar = new b(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(eVar, bVar, this) == objE) {
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

        /* renamed from: ir.nasim.wD3$n$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C23024wD3 c;

            /* renamed from: ir.nasim.wD3$n$b$b, reason: collision with other inner class name */
            static final class C1746b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C23024wD3 d;

                /* renamed from: ir.nasim.wD3$n$b$b$b, reason: collision with other inner class name */
                static final class C1747b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ boolean c;
                    final /* synthetic */ C23024wD3 d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1747b(C23024wD3 c23024wD3, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = c23024wD3;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1747b c1747b = new C1747b(this.d, interfaceC20295rm1);
                        c1747b.c = ((Boolean) obj).booleanValue();
                        return c1747b;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        boolean z = this.c;
                        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.s;
                        while (true) {
                            Object value = interfaceC9336Zm4.getValue();
                            M26 m26 = (M26) value;
                            InterfaceC9336Zm4 interfaceC9336Zm42 = interfaceC9336Zm4;
                            if (interfaceC9336Zm42.f(value, m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : z, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null))) {
                                return C19938rB7.a;
                            }
                            interfaceC9336Zm4 = interfaceC9336Zm42;
                        }
                    }

                    public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1747b) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1746b(C23024wD3 c23024wD3, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c23024wD3;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1746b c1746b = new C1746b(this.d, interfaceC20295rm1);
                    c1746b.c = obj;
                    return c1746b;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object next;
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        Iterator it = ((List) this.c).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            if (((AbstractC4838Gt7) next).f() == AbstractC21649tt7.g.b) {
                                break;
                            }
                        }
                        AbstractC4838Gt7 abstractC4838Gt7 = (AbstractC4838Gt7) next;
                        if (abstractC4838Gt7 == null) {
                            return C19938rB7.a;
                        }
                        InterfaceC10258bL6 interfaceC10258bL6E = AbstractC5508Jq2.e(new AbstractC24042xw5(abstractC4838Gt7) { // from class: ir.nasim.wD3.n.b.b.a
                            @Override // ir.nasim.InterfaceC3820Cm3
                            public Object get() {
                                return Boolean.valueOf(((AbstractC4838Gt7) this.receiver).b());
                            }
                        });
                        C1747b c1747b = new C1747b(this.d, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC10258bL6E, c1747b, this) == objE) {
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
                public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1746b) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.wD3$n$b$c */
            public static final class c implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.wD3$n$b$c$a */
                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.wD3$n$b$c$a$a, reason: collision with other inner class name */
                    public static final class C1748a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1748a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return a.this.a(null, this);
                        }
                    }

                    public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.C23024wD3.n.b.c.a.C1748a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.wD3$n$b$c$a$a r0 = (ir.nasim.C23024wD3.n.b.c.a.C1748a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.wD3$n$b$c$a$a r0 = new ir.nasim.wD3$n$b$c$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L4b
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            r2 = r5
                            java.util.List r2 = (java.util.List) r2
                            java.util.Collection r2 = (java.util.Collection) r2
                            boolean r2 = r2.isEmpty()
                            r2 = r2 ^ r3
                            if (r2 == 0) goto L4b
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L4b
                            return r1
                        L4b:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23024wD3.n.b.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.wD3$n$b$d */
            public static final class d implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.wD3$n$b$d$a */
                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.wD3$n$b$d$a$a, reason: collision with other inner class name */
                    public static final class C1749a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1749a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return a.this.a(null, this);
                        }
                    }

                    public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof ir.nasim.C23024wD3.n.b.d.a.C1749a
                            if (r0 == 0) goto L13
                            r0 = r7
                            ir.nasim.wD3$n$b$d$a$a r0 = (ir.nasim.C23024wD3.n.b.d.a.C1749a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.wD3$n$b$d$a$a r0 = new ir.nasim.wD3$n$b$d$a$a
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r7)
                            goto L68
                        L29:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L31:
                            ir.nasim.AbstractC10685c16.b(r7)
                            ir.nasim.Gq2 r7 = r5.a
                            java.util.List r6 = (java.util.List) r6
                            java.lang.Iterable r6 = (java.lang.Iterable) r6
                            java.util.ArrayList r2 = new java.util.ArrayList
                            r4 = 10
                            int r4 = ir.nasim.ZW0.x(r6, r4)
                            r2.<init>(r4)
                            java.util.Iterator r6 = r6.iterator()
                        L49:
                            boolean r4 = r6.hasNext()
                            if (r4 == 0) goto L5f
                            java.lang.Object r4 = r6.next()
                            ir.nasim.XV4 r4 = (ir.nasim.XV4) r4
                            java.lang.Object r4 = r4.a()
                            ir.nasim.Gt7 r4 = (ir.nasim.AbstractC4838Gt7) r4
                            r2.add(r4)
                            goto L49
                        L5f:
                            r0.b = r3
                            java.lang.Object r6 = r7.a(r2, r0)
                            if (r6 != r1) goto L68
                            return r1
                        L68:
                            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23024wD3.n.b.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C23024wD3 c23024wD3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c23024wD3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    c cVar = new c(new d(AbstractC5508Jq2.e(new AbstractC24042xw5(this.c.h0().B0()) { // from class: ir.nasim.wD3.n.b.a
                        @Override // ir.nasim.InterfaceC3820Cm3
                        public Object get() {
                            return ((io.livekit.android.room.participant.a) this.receiver).s();
                        }
                    })));
                    C1746b c1746b = new C1746b(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(cVar, c1746b, this) == objE) {
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

        n(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            n nVar = C23024wD3.this.new n(interfaceC20295rm1);
            nVar.c = obj;
            return nVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(C23024wD3.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(C23024wD3.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD3$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.wD3$o$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C23024wD3 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C23024wD3 c23024wD3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c23024wD3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v14 */
            /* JADX WARN: Type inference failed for: r3v15 */
            /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.Object] */
            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object next;
                AbstractC22594vV7.b bVar;
                Object value;
                M26 m26;
                Object value2;
                M26 m262;
                Object value3;
                M26 m263;
                AbstractC4838Gt7 next2;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                List list = (List) this.c;
                List list2 = list;
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((AbstractC4838Gt7) next).f() == AbstractC21649tt7.g.d) {
                        break;
                    }
                }
                AbstractC4838Gt7 abstractC4838Gt7 = (AbstractC4838Gt7) next;
                if (abstractC4838Gt7 == null) {
                    Iterator it2 = list2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next2 = 0;
                            break;
                        }
                        next2 = it2.next();
                        if (((AbstractC4838Gt7) next2).f() == AbstractC21649tt7.g.b) {
                            break;
                        }
                    }
                    abstractC4838Gt7 = next2;
                    if (abstractC4838Gt7 == null) {
                        abstractC4838Gt7 = (AbstractC4838Gt7) AbstractC15401jX0.s0(list);
                    }
                }
                Object objH = abstractC4838Gt7 != null ? abstractC4838Gt7.h() : null;
                EV7 ev7 = objH instanceof EV7 ? (EV7) objH : null;
                if (ev7 == null) {
                    return C19938rB7.a;
                }
                D27 d27 = this.d.p;
                if (d27 == null) {
                    return C19938rB7.a;
                }
                Room roomH0 = this.d.h0();
                AbstractC21649tt7.g gVarF = abstractC4838Gt7.f();
                Context context = this.d.f;
                boolean zFb = C8386Vt0.a.Fb();
                InterfaceC11299cm3 interfaceC11299cm3B = AbstractC10882cM5.b(AbstractC22594vV7.b.class);
                if (AbstractC13042fc3.d(interfaceC11299cm3B, AbstractC10882cM5.b(AbstractC22594vV7.b.class))) {
                    bVar = new AbstractC22594vV7.b(roomH0, ev7, gVarF, d27.a(), zFb);
                } else {
                    if (!AbstractC13042fc3.d(interfaceC11299cm3B, AbstractC10882cM5.b(AbstractC22594vV7.a.class))) {
                        throw new IllegalArgumentException("Unsupported type " + AbstractC10882cM5.b(AbstractC22594vV7.b.class));
                    }
                    bVar = (AbstractC22594vV7.b) new AbstractC22594vV7.a(roomH0, ev7, context, d27.a());
                }
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.s;
                do {
                    value = interfaceC9336Zm4.getValue();
                    m26 = (M26) value;
                } while (!interfaceC9336Zm4.f(value, m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : true, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null)));
                if (abstractC4838Gt7.f() == AbstractC21649tt7.g.d) {
                    InterfaceC9336Zm4 interfaceC9336Zm42 = this.d.s;
                    do {
                        value3 = interfaceC9336Zm42.getValue();
                        m263 = (M26) value3;
                    } while (!interfaceC9336Zm42.f(value3, m263.a((32735 & 1) != 0 ? m263.a : false, (32735 & 2) != 0 ? m263.b : false, (32735 & 4) != 0 ? m263.c : false, (32735 & 8) != 0 ? m263.d : true, (32735 & 16) != 0 ? m263.e : null, (32735 & 32) != 0 ? m263.f : null, (32735 & 64) != 0 ? m263.g : null, (32735 & 128) != 0 ? m263.h : null, (32735 & 256) != 0 ? m263.i : C24964zV7.a.a(bVar), (32735 & 512) != 0 ? m263.j : false, (32735 & 1024) != 0 ? m263.k : null, (32735 & 2048) != 0 ? m263.l : null, (32735 & 4096) != 0 ? m263.m : null, (32735 & 8192) != 0 ? m263.n : null, (32735 & 16384) != 0 ? m263.o : null)));
                } else if (abstractC4838Gt7.f() == AbstractC21649tt7.g.b) {
                    InterfaceC9336Zm4 interfaceC9336Zm43 = this.d.s;
                    do {
                        value2 = interfaceC9336Zm43.getValue();
                        m262 = (M26) value2;
                    } while (!interfaceC9336Zm43.f(value2, m262.a((32735 & 1) != 0 ? m262.a : false, (32735 & 2) != 0 ? m262.b : false, (32735 & 4) != 0 ? m262.c : false, (32735 & 8) != 0 ? m262.d : false, (32735 & 16) != 0 ? m262.e : null, (32735 & 32) != 0 ? m262.f : null, (32735 & 64) != 0 ? m262.g : null, (32735 & 128) != 0 ? m262.h : C24964zV7.a.a(bVar), (32735 & 256) != 0 ? m262.i : null, (32735 & 512) != 0 ? m262.j : false, (32735 & 1024) != 0 ? m262.k : null, (32735 & 2048) != 0 ? m262.l : null, (32735 & 4096) != 0 ? m262.m : null, (32735 & 8192) != 0 ? m262.n : null, (32735 & 16384) != 0 ? m262.o : null)));
                }
                bVar.o(this.d.m);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.wD3$o$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.wD3$o$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.wD3$o$c$a$a, reason: collision with other inner class name */
                public static final class C1750a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1750a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.C23024wD3.o.c.a.C1750a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.wD3$o$c$a$a r0 = (ir.nasim.C23024wD3.o.c.a.C1750a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.wD3$o$c$a$a r0 = new ir.nasim.wD3$o$c$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L68
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        java.util.List r6 = (java.util.List) r6
                        java.lang.Iterable r6 = (java.lang.Iterable) r6
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r4 = 10
                        int r4 = ir.nasim.ZW0.x(r6, r4)
                        r2.<init>(r4)
                        java.util.Iterator r6 = r6.iterator()
                    L49:
                        boolean r4 = r6.hasNext()
                        if (r4 == 0) goto L5f
                        java.lang.Object r4 = r6.next()
                        ir.nasim.XV4 r4 = (ir.nasim.XV4) r4
                        java.lang.Object r4 = r4.a()
                        ir.nasim.Gt7 r4 = (ir.nasim.AbstractC4838Gt7) r4
                        r2.add(r4)
                        goto L49
                    L5f:
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r2, r0)
                        if (r6 != r1) goto L68
                        return r1
                    L68:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23024wD3.o.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23024wD3.this.new o(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                c cVar = new c(AbstractC5508Jq2.e(new AbstractC24042xw5(C23024wD3.this.h0().B0()) { // from class: ir.nasim.wD3.o.a
                    @Override // ir.nasim.InterfaceC3820Cm3
                    public Object get() {
                        return ((io.livekit.android.room.participant.a) this.receiver).s();
                    }
                }));
                b bVar = new b(C23024wD3.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(cVar, bVar, this) == objE) {
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
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD3$p */
    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.wD3$p$b */
        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ C23024wD3 a;

            /* renamed from: ir.nasim.wD3$p$b$d */
            static final class d extends AbstractC19859r37 implements InterfaceC15796kB2 {
                int b;
                /* synthetic */ boolean c;
                /* synthetic */ Object d;

                d(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(3, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return AbstractC4616Fw7.a((String) this.d, AbstractC6392Nk0.a(this.c));
                }

                public final Object n(boolean z, String str, InterfaceC20295rm1 interfaceC20295rm1) {
                    d dVar = new d(interfaceC20295rm1);
                    dVar.c = z;
                    dVar.d = str;
                    return dVar.invokeSuspend(C19938rB7.a);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    return n(((Boolean) obj).booleanValue(), (String) obj2, (InterfaceC20295rm1) obj3);
                }
            }

            /* renamed from: ir.nasim.wD3$p$b$g */
            static final class g extends AbstractC19859r37 implements InterfaceC16978mB2 {
                int b;
                /* synthetic */ boolean c;
                /* synthetic */ Object d;
                /* synthetic */ Object e;
                final /* synthetic */ M26 f;
                final /* synthetic */ C23024wD3 g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                g(M26 m26, C23024wD3 c23024wD3, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(4, interfaceC20295rm1);
                    this.f = m26;
                    this.g = c23024wD3;
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    return n(((Boolean) obj).booleanValue(), (XV4) obj2, (List) obj3, (InterfaceC20295rm1) obj4);
                }

                /* JADX WARN: Removed duplicated region for block: B:13:0x009e  */
                @Override // ir.nasim.E90
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r32) {
                    /*
                        Method dump skipped, instructions count: 613
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23024wD3.p.b.g.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                public final Object n(boolean z, XV4 xv4, List list, InterfaceC20295rm1 interfaceC20295rm1) {
                    g gVar = new g(this.f, this.g, interfaceC20295rm1);
                    gVar.c = z;
                    gVar.d = xv4;
                    gVar.e = list;
                    return gVar.invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.wD3$p$b$h */
            public static final class h extends AbstractC19859r37 implements InterfaceC15796kB2 {
                int b;
                private /* synthetic */ Object c;
                /* synthetic */ Object d;

                public h(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(3, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    InterfaceC4557Fq2 interfaceC4557Fq2P;
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                        List list = (List) this.d;
                        if (list.isEmpty()) {
                            interfaceC4557Fq2P = AbstractC6459Nq2.T(null);
                        } else {
                            AbstractC4838Gt7 abstractC4838Gt7 = (AbstractC4838Gt7) ((XV4) AbstractC15401jX0.C0(list)).e();
                            interfaceC4557Fq2P = AbstractC6459Nq2.p(AbstractC5508Jq2.e(new AbstractC24042xw5(abstractC4838Gt7) { // from class: ir.nasim.wD3.p.b.c
                                @Override // ir.nasim.InterfaceC3820Cm3
                                public Object get() {
                                    return Boolean.valueOf(((AbstractC4838Gt7) this.receiver).b());
                                }
                            }), AbstractC6459Nq2.T(abstractC4838Gt7.e()), new d(null));
                        }
                        this.b = 1;
                        if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2P, this) == objE) {
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

                @Override // ir.nasim.InterfaceC15796kB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    h hVar = new h(interfaceC20295rm1);
                    hVar.c = interfaceC4806Gq2;
                    hVar.d = obj;
                    return hVar.invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.wD3$p$b$i */
            public static final class i extends AbstractC19859r37 implements InterfaceC15796kB2 {
                int b;
                private /* synthetic */ Object c;
                /* synthetic */ Object d;

                public i(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(3, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    InterfaceC4557Fq2 jVar;
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                        List list = (List) this.d;
                        if (list.isEmpty()) {
                            jVar = AbstractC6459Nq2.T(AbstractC10360bX0.m());
                        } else {
                            List<XV4> list2 = list;
                            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                            for (XV4 xv4 : list2) {
                                AbstractC4838Gt7 abstractC4838Gt7 = (AbstractC4838Gt7) xv4.a();
                                arrayList.add(new k(AbstractC5508Jq2.e(new AbstractC24042xw5(abstractC4838Gt7) { // from class: ir.nasim.wD3.p.b.f
                                    @Override // ir.nasim.InterfaceC3820Cm3
                                    public Object get() {
                                        return Boolean.valueOf(((AbstractC4838Gt7) this.receiver).b());
                                    }
                                }), abstractC4838Gt7, (AbstractC21649tt7) xv4.b()));
                            }
                            jVar = new j((InterfaceC4557Fq2[]) AbstractC15401jX0.m1(arrayList).toArray(new InterfaceC4557Fq2[0]));
                        }
                        this.b = 1;
                        if (AbstractC6459Nq2.A(interfaceC4806Gq2, jVar, this) == objE) {
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

                @Override // ir.nasim.InterfaceC15796kB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    i iVar = new i(interfaceC20295rm1);
                    iVar.c = interfaceC4806Gq2;
                    iVar.d = obj;
                    return iVar.invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.wD3$p$b$j */
            public static final class j implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2[] a;

                /* renamed from: ir.nasim.wD3$p$b$j$a */
                static final class a extends AbstractC8614Ws3 implements SA2 {
                    final /* synthetic */ InterfaceC4557Fq2[] e;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public a(InterfaceC4557Fq2[] interfaceC4557Fq2Arr) {
                        super(0);
                        this.e = interfaceC4557Fq2Arr;
                    }

                    @Override // ir.nasim.SA2
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object[] invoke() {
                        return new C17428mw7[this.e.length];
                    }
                }

                /* renamed from: ir.nasim.wD3$p$b$j$b, reason: collision with other inner class name */
                public static final class C1752b extends AbstractC19859r37 implements InterfaceC15796kB2 {
                    int b;
                    private /* synthetic */ Object c;
                    /* synthetic */ Object d;

                    public C1752b(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(3, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                            List listF1 = AbstractC10242bK.f1((C17428mw7[]) ((Object[]) this.d));
                            this.b = 1;
                            if (interfaceC4806Gq2.a(listF1, this) == objE) {
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

                    @Override // ir.nasim.InterfaceC15796kB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object[] objArr, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1752b c1752b = new C1752b(interfaceC20295rm1);
                        c1752b.c = interfaceC4806Gq2;
                        c1752b.d = objArr;
                        return c1752b.invokeSuspend(C19938rB7.a);
                    }
                }

                public j(InterfaceC4557Fq2[] interfaceC4557Fq2Arr) {
                    this.a = interfaceC4557Fq2Arr;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    InterfaceC4557Fq2[] interfaceC4557Fq2Arr = this.a;
                    Object objA = AbstractC10404bZ0.a(interfaceC4806Gq2, interfaceC4557Fq2Arr, new a(interfaceC4557Fq2Arr), new C1752b(null), interfaceC20295rm1);
                    return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.wD3$p$b$k */
            public static final class k implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;
                final /* synthetic */ AbstractC4838Gt7 b;
                final /* synthetic */ AbstractC21649tt7 c;

                /* renamed from: ir.nasim.wD3$p$b$k$a */
                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;
                    final /* synthetic */ AbstractC4838Gt7 b;
                    final /* synthetic */ AbstractC21649tt7 c;

                    /* renamed from: ir.nasim.wD3$p$b$k$a$a, reason: collision with other inner class name */
                    public static final class C1753a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1753a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return a.this.a(null, this);
                        }
                    }

                    public a(InterfaceC4806Gq2 interfaceC4806Gq2, AbstractC4838Gt7 abstractC4838Gt7, AbstractC21649tt7 abstractC21649tt7) {
                        this.a = interfaceC4806Gq2;
                        this.b = abstractC4838Gt7;
                        this.c = abstractC21649tt7;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                        /*
                            r6 = this;
                            boolean r0 = r8 instanceof ir.nasim.C23024wD3.p.b.k.a.C1753a
                            if (r0 == 0) goto L13
                            r0 = r8
                            ir.nasim.wD3$p$b$k$a$a r0 = (ir.nasim.C23024wD3.p.b.k.a.C1753a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.wD3$p$b$k$a$a r0 = new ir.nasim.wD3$p$b$k$a$a
                            r0.<init>(r8)
                        L18:
                            java.lang.Object r8 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r8)
                            goto L52
                        L29:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r8)
                            throw r7
                        L31:
                            ir.nasim.AbstractC10685c16.b(r8)
                            ir.nasim.Gq2 r8 = r6.a
                            java.lang.Boolean r7 = (java.lang.Boolean) r7
                            boolean r7 = r7.booleanValue()
                            ir.nasim.mw7 r2 = new ir.nasim.mw7
                            ir.nasim.Gt7 r4 = r6.b
                            ir.nasim.tt7 r5 = r6.c
                            java.lang.Boolean r7 = ir.nasim.AbstractC6392Nk0.a(r7)
                            r2.<init>(r4, r5, r7)
                            r0.b = r3
                            java.lang.Object r7 = r8.a(r2, r0)
                            if (r7 != r1) goto L52
                            return r1
                        L52:
                            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C23024wD3.p.b.k.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public k(InterfaceC4557Fq2 interfaceC4557Fq2, AbstractC4838Gt7 abstractC4838Gt7, AbstractC21649tt7 abstractC21649tt7) {
                    this.a = interfaceC4557Fq2;
                    this.b = abstractC4838Gt7;
                    this.c = abstractC21649tt7;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new a(interfaceC4806Gq2, this.b, this.c), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            b(C23024wD3 c23024wD3) {
                this.a = c23024wD3;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(Map map, InterfaceC20295rm1 interfaceC20295rm1) {
                Set setKeySet = map.keySet();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(setKeySet, 10));
                Iterator it = setKeySet.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Participant.Identity) it.next()).getValue());
                }
                Set setR1 = AbstractC15401jX0.r1(arrayList);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                C23024wD3 c23024wD3 = this.a;
                for (Map.Entry entry : map.entrySet()) {
                    String value = ((Participant.Identity) entry.getKey()).getValue();
                    io.livekit.android.room.participant.d dVar = (io.livekit.android.room.participant.d) entry.getValue();
                    InterfaceC10258bL6 interfaceC10258bL6 = (InterfaceC10258bL6) c23024wD3.t.get(value);
                    if (interfaceC10258bL6 != null) {
                        linkedHashMap.put(value, interfaceC10258bL6);
                    } else {
                        M26 m26 = new M26(true, !dVar.t(), false, false, value, null, null, null, null, false, dVar.j(), null, null, value, dVar.k(), 6636, null);
                        linkedHashMap.put(value, AbstractC6459Nq2.o0(AbstractC6459Nq2.o(AbstractC5508Jq2.e(new AbstractC5474Jm4(dVar) { // from class: ir.nasim.wD3.p.b.a
                            @Override // ir.nasim.InterfaceC3820Cm3
                            public Object get() {
                                return Boolean.valueOf(((io.livekit.android.room.participant.d) this.receiver).u());
                            }
                        }), AbstractC6459Nq2.s0(AbstractC5508Jq2.e(new AbstractC24042xw5(dVar) { // from class: ir.nasim.wD3.p.b.b
                            @Override // ir.nasim.InterfaceC3820Cm3
                            public Object get() {
                                return ((io.livekit.android.room.participant.d) this.receiver).e();
                            }
                        }), new h(null)), AbstractC6459Nq2.s0(AbstractC5508Jq2.e(new AbstractC24042xw5(dVar) { // from class: ir.nasim.wD3.p.b.e
                            @Override // ir.nasim.InterfaceC3820Cm3
                            public Object get() {
                                return ((io.livekit.android.room.participant.d) this.receiver).s();
                            }
                        }), new i(null)), new g(m26, c23024wD3, null)), c23024wD3.e, InterfaceC16863lz6.a.c(), m26));
                    }
                }
                if (!this.a.k && (!map.isEmpty())) {
                    this.a.k0();
                }
                Set setKeySet2 = this.a.t.keySet();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : setKeySet2) {
                    if (!setR1.contains((String) obj)) {
                        arrayList2.add(obj);
                    }
                }
                C23024wD3 c23024wD32 = this.a;
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    c23024wD32.t.remove((String) it2.next());
                }
                this.a.t.putAll(linkedHashMap);
                this.a.r.setValue(AbstractC15401jX0.m1(this.a.t.values()));
                return C19938rB7.a;
            }
        }

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23024wD3.this.new p(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6E = AbstractC5508Jq2.e(new AbstractC24042xw5(C23024wD3.this.h0()) { // from class: ir.nasim.wD3.p.a
                    @Override // ir.nasim.InterfaceC3820Cm3
                    public Object get() {
                        return ((Room) this.receiver).L0();
                    }
                });
                b bVar = new b(C23024wD3.this);
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
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD3$q */
    /* synthetic */ class q extends EB2 implements UA2 {
        q(Object obj) {
            super(1, obj, Room.class, "getPublisherRTCStats", "getPublisherRTCStats(Llivekit/org/webrtc/RTCStatsCollectorCallback;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((RTCStatsCollectorCallback) obj);
            return C19938rB7.a;
        }

        public final void y(RTCStatsCollectorCallback rTCStatsCollectorCallback) {
            AbstractC13042fc3.i(rTCStatsCollectorCallback, "p0");
            ((Room) this.receiver).K0(rTCStatsCollectorCallback);
        }
    }

    /* renamed from: ir.nasim.wD3$r */
    /* synthetic */ class r extends EB2 implements UA2 {
        r(Object obj) {
            super(1, obj, Room.class, "getSubscriberRTCStats", "getSubscriberRTCStats(Llivekit/org/webrtc/RTCStatsCollectorCallback;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((RTCStatsCollectorCallback) obj);
            return C19938rB7.a;
        }

        public final void y(RTCStatsCollectorCallback rTCStatsCollectorCallback) {
            AbstractC13042fc3.i(rTCStatsCollectorCallback, "p0");
            ((Room) this.receiver).P0(rTCStatsCollectorCallback);
        }
    }

    /* renamed from: ir.nasim.wD3$s */
    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ io.livekit.android.room.participant.a c;
        final /* synthetic */ Intent d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(io.livekit.android.room.participant.a aVar, Intent intent, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = aVar;
            this.d = intent;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new s(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                io.livekit.android.room.participant.a aVar = this.c;
                C22668vd6 c22668vd6 = new C22668vd6(this.d, null, null, null, 14, null);
                this.b = 1;
                if (aVar.b1(true, c22668vd6, this) == objE) {
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
            return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.wD3$t */
    static final class t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ io.livekit.android.room.participant.a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(io.livekit.android.room.participant.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new t(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                io.livekit.android.room.participant.a aVar = this.c;
                this.b = 1;
                if (io.livekit.android.room.participant.a.c1(aVar, false, null, this, 2, null) == objE) {
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
            return ((t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C23024wD3(A08 a08, SettingsModule settingsModule, Y08 y08, C17536n78 c17536n78, InterfaceC20315ro1 interfaceC20315ro1, Context context, OkHttpClient okHttpClient) {
        AbstractC13042fc3.i(a08, "voiceCallModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(y08, "voiceSwitchCallback");
        AbstractC13042fc3.i(c17536n78, "webRTCMetricLogger");
        AbstractC13042fc3.i(interfaceC20315ro1, "serviceScope");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(okHttpClient, "okHttpClient");
        this.a = a08;
        this.b = settingsModule;
        this.c = y08;
        this.d = c17536n78;
        this.e = interfaceC20315ro1;
        this.f = context;
        this.g = okHttpClient;
        this.l = new M26(false, false, false, false, null, null, null, null, null, false, null, null, null, null, null, 32767, null);
        this.m = AbstractC12281eL6.a(Boolean.TRUE);
        this.q = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.mD3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C23024wD3.r0(this.a);
            }
        });
        this.r = AbstractC12281eL6.a(AbstractC10360bX0.m());
        this.s = AbstractC12281eL6.a(new M26(false, false, false, false, String.valueOf(AbstractC5969Lp4.f()), null, null, null, null, false, null, null, null, null, null, 32751, null));
        this.p = new D27(interfaceC20315ro1);
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(null), 3, null);
        o0();
        this.t = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(C23024wD3 c23024wD3, MeetOuterClass$ResponseCall meetOuterClass$ResponseCall) {
        AbstractC13042fc3.i(c23024wD3, "this$0");
        c23024wD3.u = meetOuterClass$ResponseCall.getCall().getUrl().getValue();
        c23024wD3.v = meetOuterClass$ResponseCall.getCall().getToken();
        String value = meetOuterClass$ResponseCall.getCall().getUrl().getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        String token = meetOuterClass$ResponseCall.getCall().getToken();
        AbstractC13042fc3.h(token, "getToken(...)");
        e0(c23024wD3, value, token, false, false, false, false, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(UA2 ua2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.s;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, ua2.invoke(value)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 b0(String str, UA2 ua2) {
        return AbstractC10533bm0.d(this.e, null, null, new d(null), 3, null);
    }

    private final void c0() {
        AbstractC10533bm0.d(this.e, null, null, new f(null), 3, null);
    }

    private final void d0(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        if (C5505Jq.G() && C5505Jq.H()) {
            AbstractC10533bm0.d(this.e, null, null, new g(null), 3, null);
            AbstractC10533bm0.d(this.e, null, null, new h(null), 3, null);
            AbstractC10533bm0.d(this.e, null, null, new i(z3, z, z2, z4, str, str2, null), 3, null);
        }
    }

    static /* synthetic */ void e0(C23024wD3 c23024wD3, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        c23024wD3.d0(str, str2, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? true : z2, (i2 & 16) != 0 ? false : z3, (i2 & 32) != 0 ? true : z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final K26 f0(boolean z) {
        return new K26(true, true, null, null, new C23060wH3(false, null, z ? EnumC23021wD0.a : EnumC23021wD0.b, null, 11, null), g0(), j0(), null, i0(), WKSRecord.Service.EMFIS_DATA, null);
    }

    private final C23718xP g0() {
        VoiceConfig voiceConfig;
        CallRemoteConfig callRemoteConfigQ0 = this.b.Q0();
        return new C23718xP((callRemoteConfigQ0 == null || (voiceConfig = callRemoteConfigQ0.getVoiceConfig()) == null) ? null : voiceConfig.getAudioBitrate(), false, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Room h0() {
        return (Room) this.q.getValue();
    }

    private final FV7 i0() {
        String videoCodec;
        VideoConfig screenShareVideoConfig;
        VideoConfig screenShareVideoConfig2;
        VideoConfig screenShareVideoConfig3;
        Boolean simulcast;
        VideoConfig screenShareVideoConfig4;
        CallRemoteConfig callRemoteConfigQ0 = this.b.Q0();
        String scalabilityMode = null;
        C9737aT7 c9737aT7 = (((callRemoteConfigQ0 == null || (screenShareVideoConfig4 = callRemoteConfigQ0.getScreenShareVideoConfig()) == null) ? null : screenShareVideoConfig4.getMaxBitrate()) == null || callRemoteConfigQ0.getScreenShareVideoConfig().getMaxFps() == null) ? null : new C9737aT7(callRemoteConfigQ0.getScreenShareVideoConfig().getMaxBitrate().intValue(), callRemoteConfigQ0.getScreenShareVideoConfig().getMaxFps().intValue());
        boolean zBooleanValue = (callRemoteConfigQ0 == null || (screenShareVideoConfig3 = callRemoteConfigQ0.getScreenShareVideoConfig()) == null || (simulcast = screenShareVideoConfig3.getSimulcast()) == null) ? false : simulcast.booleanValue();
        if (callRemoteConfigQ0 == null || (screenShareVideoConfig2 = callRemoteConfigQ0.getScreenShareVideoConfig()) == null || (videoCodec = screenShareVideoConfig2.getVideoCodec()) == null) {
            videoCodec = "vp9";
        }
        String str = videoCodec;
        if (callRemoteConfigQ0 != null && (screenShareVideoConfig = callRemoteConfigQ0.getScreenShareVideoConfig()) != null) {
            scalabilityMode = screenShareVideoConfig.getScalabilityMode();
        }
        return new FV7(c9737aT7, zBooleanValue, str, scalabilityMode, null, null, null, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, null);
    }

    private final FV7 j0() {
        String videoCodec;
        VideoConfig videoConfig;
        VideoConfig videoConfig2;
        VideoConfig videoConfig3;
        Boolean simulcast;
        VideoConfig videoConfig4;
        CallRemoteConfig callRemoteConfigQ0 = this.b.Q0();
        String scalabilityMode = null;
        C9737aT7 c9737aT7 = (((callRemoteConfigQ0 == null || (videoConfig4 = callRemoteConfigQ0.getVideoConfig()) == null) ? null : videoConfig4.getMaxBitrate()) == null || callRemoteConfigQ0.getVideoConfig().getMaxFps() == null) ? null : new C9737aT7(callRemoteConfigQ0.getVideoConfig().getMaxBitrate().intValue(), callRemoteConfigQ0.getVideoConfig().getMaxFps().intValue());
        boolean zBooleanValue = (callRemoteConfigQ0 == null || (videoConfig3 = callRemoteConfigQ0.getVideoConfig()) == null || (simulcast = videoConfig3.getSimulcast()) == null) ? false : simulcast.booleanValue();
        if (callRemoteConfigQ0 == null || (videoConfig2 = callRemoteConfigQ0.getVideoConfig()) == null || (videoCodec = videoConfig2.getVideoCodec()) == null) {
            videoCodec = "vp9";
        }
        String str = videoCodec;
        if (callRemoteConfigQ0 != null && (videoConfig = callRemoteConfigQ0.getVideoConfig()) != null) {
            scalabilityMode = videoConfig.getScalabilityMode();
        }
        return new FV7(c9737aT7, zBooleanValue, str, scalabilityMode, null, null, null, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0() {
        this.c.h();
        this.k = true;
        AbstractC10533bm0.d(this.e, null, null, new k(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(C23024wD3 c23024wD3, boolean z, boolean z2, boolean z3, MeetOuterClass$ResponseJoinGroupCall meetOuterClass$ResponseJoinGroupCall) {
        AbstractC13042fc3.i(c23024wD3, "this$0");
        List<MeetStruct$PeerState> statesList = meetOuterClass$ResponseJoinGroupCall.getStatesList();
        AbstractC13042fc3.h(statesList, "getStatesList(...)");
        ArrayList<MeetStruct$PeerState> arrayList = new ArrayList();
        for (Object obj : statesList) {
            if (((MeetStruct$PeerState) obj).getPeerStateEnum() == EnumC11447d14.PeerStateEnum_INVITED) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(arrayList, 10));
        for (MeetStruct$PeerState meetStruct$PeerState : arrayList) {
            arrayList2.add(new G26(meetStruct$PeerState.getId(), meetStruct$PeerState.getDate()));
        }
        c23024wD3.u = meetOuterClass$ResponseJoinGroupCall.getGroupCall().getUrl().getText();
        c23024wD3.v = meetOuterClass$ResponseJoinGroupCall.getGroupCall().getToken();
        c23024wD3.c.c(new C22376v78(arrayList2));
        String text = meetOuterClass$ResponseJoinGroupCall.getGroupCall().getUrl().getText();
        AbstractC13042fc3.h(text, "getText(...)");
        String token = meetOuterClass$ResponseJoinGroupCall.getGroupCall().getToken();
        AbstractC13042fc3.h(token, "getToken(...)");
        e0(c23024wD3, text, token, z, z2, false, z3, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(C23024wD3 c23024wD3, Exception exc) {
        AbstractC13042fc3.i(c23024wD3, "this$0");
        Y08 y08 = c23024wD3.c;
        AbstractC13042fc3.f(exc);
        y08.d(exc);
    }

    private final InterfaceC13730gj3 o0() {
        return AbstractC10533bm0.d(this.e, null, null, new o(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0() {
        AbstractC10533bm0.d(this.e, null, null, new p(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        this.d.g(new q(h0()));
        this.d.h(new r(h0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Room r0(C23024wD3 c23024wD3) {
        AbstractC13042fc3.i(c23024wD3, "this$0");
        Room roomA = UC3.a.a(C5721Ko.a.d(), (2 & 2) != 0 ? new K26(false, false, null, null, null, null, null, null, null, 511, null) : null, (2 & 4) != 0 ? new XC3(null, null, null, null, null, null, 63, null) : new XC3(c23024wD3.g, null, null, new WN(null, null, null, null, false, null, 63, null), null, null, 54, null));
        if (C8386Vt0.a.Oa()) {
            roomA.k1(TJ5.b);
        }
        return roomA;
    }

    private final void s0(C11458d25 c11458d25, final boolean z) {
        if (c11458d25.z()) {
            this.a.X(new C11458d25(W25.b, c11458d25.getPeerId()), z).m0(new InterfaceC24449ye1() { // from class: ir.nasim.qD3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C23024wD3.u0(this.a, z, (MeetOuterClass$ResponseStartGroupCall) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.rD3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C23024wD3.v0(this.a, (Exception) obj);
                }
            });
        } else {
            this.a.W(c11458d25, EnumC13941h47.a, z).m0(new InterfaceC24449ye1() { // from class: ir.nasim.sD3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C23024wD3.w0(this.a, z, (MeetOuterClass$ResponseCall) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.tD3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C23024wD3.t0(this.a, (Exception) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(C23024wD3 c23024wD3, Exception exc) {
        AbstractC13042fc3.i(c23024wD3, "this$0");
        Y08 y08 = c23024wD3.c;
        AbstractC13042fc3.f(exc);
        y08.g(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(C23024wD3 c23024wD3, boolean z, MeetOuterClass$ResponseStartGroupCall meetOuterClass$ResponseStartGroupCall) {
        AbstractC13042fc3.i(c23024wD3, "this$0");
        c23024wD3.c.b(meetOuterClass$ResponseStartGroupCall.getGroupCall().getId());
        String text = meetOuterClass$ResponseStartGroupCall.getGroupCall().getUrl().getText();
        AbstractC13042fc3.h(text, "getText(...)");
        String token = meetOuterClass$ResponseStartGroupCall.getGroupCall().getToken();
        AbstractC13042fc3.h(token, "getToken(...)");
        e0(c23024wD3, text, token, false, !z, false, false, 52, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(C23024wD3 c23024wD3, Exception exc) {
        AbstractC13042fc3.i(c23024wD3, "this$0");
        Y08 y08 = c23024wD3.c;
        AbstractC13042fc3.f(exc);
        y08.g(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(C23024wD3 c23024wD3, boolean z, MeetOuterClass$ResponseCall meetOuterClass$ResponseCall) {
        AbstractC13042fc3.i(c23024wD3, "this$0");
        c23024wD3.c.b(meetOuterClass$ResponseCall.getCall().getId());
        MeetStruct$Call call = meetOuterClass$ResponseCall.getCall();
        AbstractC13042fc3.f(call);
        String value = call.getUrl().getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        MeetStruct$Call call2 = meetOuterClass$ResponseCall.getCall();
        AbstractC13042fc3.f(call2);
        String token = call2.getToken();
        AbstractC13042fc3.f(token);
        e0(c23024wD3, value, token, false, !z, meetOuterClass$ResponseCall.getIsStream().getValue(), false, 36, null);
        BV7 bv7 = c23024wD3.h;
        if (bv7 != null) {
            bv7.a(meetOuterClass$ResponseCall.getIsStream().getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(C23024wD3 c23024wD3, MeetOuterClass$ResponseStartGroupCall meetOuterClass$ResponseStartGroupCall) {
        AbstractC13042fc3.i(c23024wD3, "this$0");
        c23024wD3.c.b(meetOuterClass$ResponseStartGroupCall.getGroupCall().getId());
        String text = meetOuterClass$ResponseStartGroupCall.getGroupCall().getUrl().getText();
        AbstractC13042fc3.h(text, "getText(...)");
        String token = meetOuterClass$ResponseStartGroupCall.getGroupCall().getToken();
        AbstractC13042fc3.h(token, "getToken(...)");
        e0(c23024wD3, text, token, false, false, false, false, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(C23024wD3 c23024wD3, Exception exc) {
        AbstractC13042fc3.i(c23024wD3, "this$0");
        Y08 y08 = c23024wD3.c;
        AbstractC13042fc3.f(exc);
        y08.g(exc);
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void a(Intent intent) {
        AbstractC13042fc3.i(intent, "mediaProjectionPermissionResultData");
        AbstractC10533bm0.d(this.e, C12366eV1.c(), null, new s(h0().B0(), intent, null), 2, null);
    }

    @Override // ir.nasim.C08
    public void b(long j2, boolean z) {
        c0();
        this.a.P(j2, z);
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void c(BV7 bv7) {
        AbstractC13042fc3.i(bv7, "videoSwitchCallback");
        this.h = bv7;
    }

    @Override // ir.nasim.C08
    public void d(List list) {
        AbstractC13042fc3.i(list, "peers");
        this.a.Y(list).m0(new InterfaceC24449ye1() { // from class: ir.nasim.uD3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C23024wD3.x0(this.a, (MeetOuterClass$ResponseStartGroupCall) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.vD3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C23024wD3.y0(this.a, (Exception) obj);
            }
        });
    }

    @Override // ir.nasim.C08
    public void e(long j2, K04 k04) {
        AbstractC13042fc3.i(k04, "reason");
        c0();
        this.a.H(j2, k04);
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void f(boolean z) {
        InterfaceC13730gj3 interfaceC13730gj3 = this.o;
        if (interfaceC13730gj3 == null || interfaceC13730gj3.p()) {
            this.o = AbstractC10533bm0.d(this.e, null, null, new m(z, null), 3, null);
        }
    }

    @Override // ir.nasim.C08
    public void h(boolean z) {
        AbstractC10533bm0.d(this.e, null, null, new l(z, this, null), 3, null);
    }

    @Override // ir.nasim.C08
    public void i(long j2, String str, final boolean z, final boolean z2, final boolean z3) {
        AbstractC13042fc3.i(str, "myName");
        this.a.O(j2, str).m0(new InterfaceC24449ye1() { // from class: ir.nasim.nD3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C23024wD3.l0(this.a, z, z2, z3, (MeetOuterClass$ResponseJoinGroupCall) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.oD3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C23024wD3.m0(this.a, (Exception) obj);
            }
        });
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void j(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        s0(c11458d25, true);
    }

    @Override // ir.nasim.C08
    public void k(String str) {
        String str2;
        AbstractC13042fc3.i(str, "grantedPermission");
        String str3 = this.u;
        if (str3 == null || (str2 = this.v) == null) {
            return;
        }
        if (AbstractC13042fc3.d(str, "android.permission.RECORD_AUDIO") || AbstractC13042fc3.d(str, "android.permission.READ_PHONE_STATE")) {
            e0(this, str3, str2, false, false, false, false, 60, null);
        }
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void l() {
        AbstractC10533bm0.d(this.e, null, null, new j(null), 3, null);
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void m() {
        AbstractC10533bm0.d(this.e, C12366eV1.c(), null, new t(h0().B0(), null), 2, null);
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void n() {
        C23060wH3 c23060wH3;
        InterfaceC13730gj3 interfaceC13730gj3 = this.n;
        if (interfaceC13730gj3 == null || interfaceC13730gj3.p()) {
            List listS = h0().B0().s();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listS, 10));
            Iterator it = listS.iterator();
            while (it.hasNext()) {
                arrayList.add((AbstractC21649tt7) ((XV4) it.next()).f());
            }
            Object objS0 = AbstractC15401jX0.s0(arrayList);
            C22464vH3 c22464vH3 = objS0 instanceof C22464vH3 ? (C22464vH3) objS0 : null;
            if (c22464vH3 == null) {
                return;
            }
            EnumC23021wD0 enumC23021wD0E = c22464vH3.A().e();
            int i2 = enumC23021wD0E == null ? -1 : c.a[enumC23021wD0E.ordinal()];
            if (i2 == -1) {
                c23060wH3 = new C23060wH3(false, null, null, null, 15, null);
            } else if (i2 == 1) {
                c23060wH3 = new C23060wH3(false, null, EnumC23021wD0.b, null, 11, null);
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                c23060wH3 = new C23060wH3(false, null, EnumC23021wD0.a, null, 11, null);
            }
            this.n = AbstractC10533bm0.d(this.e, null, null, new e(c22464vH3, c23060wH3.e(), this, null), 3, null);
        }
    }

    public final InterfaceC13730gj3 n0() {
        return AbstractC10533bm0.d(this.e, null, null, new n(null), 3, null);
    }

    @Override // ir.nasim.C08
    public void o(long j2) {
        this.a.D(j2).m0(new InterfaceC24449ye1() { // from class: ir.nasim.pD3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C23024wD3.B(this.a, (MeetOuterClass$ResponseCall) obj);
            }
        });
    }

    @Override // ir.nasim.C08
    public void onDestroy() {
        c0();
        this.u = null;
        this.v = null;
    }

    @Override // ir.nasim.C08
    public void p(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        s0(c11458d25, false);
    }

    @Override // ir.nasim.C08
    public void q(long j2) {
        this.a.R(j2);
    }
}
