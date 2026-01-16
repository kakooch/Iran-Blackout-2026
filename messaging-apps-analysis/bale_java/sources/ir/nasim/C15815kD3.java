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
import ir.nasim.AbstractC5270Ip7;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.core.modules.settings.entity.CallRemoteConfig;
import ir.nasim.core.modules.settings.entity.VideoConfig;
import ir.nasim.core.modules.settings.entity.VoiceConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.RTCStatsCollectorCallback;
import okhttp3.OkHttpClient;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.kD3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15815kD3 implements InterfaceC24937zS7 {
    public static final b w = new b(null);
    public static final int x = 8;
    private final A08 a;
    private final SettingsModule b;
    private final Y08 c;
    private final C17536n78 d;
    private final InterfaceC20315ro1 e;
    private final Context f;
    private final C9728aS7 g;
    private final OkHttpClient h;
    private BV7 i;
    private boolean j;
    private boolean k;
    private boolean l;
    private M26 m;
    private final InterfaceC9336Zm4 n;
    private InterfaceC13730gj3 o;
    private InterfaceC13730gj3 p;
    private D27 q;
    private final InterfaceC9173Yu3 r;
    private InterfaceC9336Zm4 s;
    private final InterfaceC9336Zm4 t;
    private String u;
    private String v;

    /* renamed from: ir.nasim.kD3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.kD3$a$a, reason: collision with other inner class name */
        static final class C1329a implements UA2 {
            final /* synthetic */ RoomEvent a;
            final /* synthetic */ String b;

            C1329a(RoomEvent roomEvent, String str) {
                this.a = roomEvent;
                this.b = str;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "it");
                return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : ((RoomEvent.TrackSubscribed) this.a).getPublication().e(), (32735 & 8192) != 0 ? m26.n : this.b, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.kD3$a$b */
        static final class b implements UA2 {
            final /* synthetic */ List a;

            b(List list) {
                this.a = list;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "participant");
                return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : this.a.contains(m26.j()), (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.kD3$a$c */
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

        /* renamed from: ir.nasim.kD3$a$d */
        static final class d implements UA2 {
            public static final d a = new d();

            d() {
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "it");
                return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.kD3$a$e */
        static final class e implements UA2 {
            final /* synthetic */ RoomEvent a;
            final /* synthetic */ String b;

            e(RoomEvent roomEvent, String str) {
                this.a = roomEvent;
                this.b = str;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "it");
                return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : ((RoomEvent.TrackSubscribed) this.a).getPublication().e(), (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : this.b, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.kD3$a$f */
        static final class f implements UA2 {
            final /* synthetic */ RoomEvent a;

            f(RoomEvent roomEvent) {
                this.a = roomEvent;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "it");
                return m26.a((32735 & 1) != 0 ? m26.a : ((RoomEvent.TrackMuted) this.a).getPublication().b(), (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.kD3$a$g */
        static final class g implements UA2 {
            final /* synthetic */ RoomEvent a;

            g(RoomEvent roomEvent) {
                this.a = roomEvent;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "it");
                return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : ((RoomEvent.TrackMuted) this.a).getPublication().b(), (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.kD3$a$h */
        static final class h implements UA2 {
            final /* synthetic */ RoomEvent a;

            h(RoomEvent roomEvent) {
                this.a = roomEvent;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "it");
                return m26.a((32735 & 1) != 0 ? m26.a : ((RoomEvent.TrackUnmuted) this.a).getPublication().b(), (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.kD3$a$i */
        static final class i implements UA2 {
            final /* synthetic */ RoomEvent a;

            i(RoomEvent roomEvent) {
                this.a = roomEvent;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "it");
                return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : ((RoomEvent.TrackUnmuted) this.a).getPublication().b(), (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.kD3$a$j */
        static final class j implements UA2 {
            final /* synthetic */ EnumC23259wd1 a;

            j(EnumC23259wd1 enumC23259wd1) {
                this.a = enumC23259wd1;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "it");
                return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : this.a, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.kD3$a$k */
        static final class k implements UA2 {
            final /* synthetic */ EnumC23259wd1 a;

            k(EnumC23259wd1 enumC23259wd1) {
                this.a = enumC23259wd1;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "it");
                return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : this.a, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.kD3$a$l */
        static final class l implements UA2 {
            final /* synthetic */ List a;

            l(List list) {
                this.a = list;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final M26 invoke(M26 m26) {
                AbstractC13042fc3.i(m26, "localParticipant");
                return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : this.a.contains(m26.j()), (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
            }
        }

        /* renamed from: ir.nasim.kD3$a$m */
        public /* synthetic */ class m {
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

        /* renamed from: ir.nasim.kD3$a$n */
        public static final class n implements InterfaceC4806Gq2 {
            final /* synthetic */ C15815kD3 a;

            public n(C15815kD3 c15815kD3) {
                this.a = c15815kD3;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                BV7 bv7;
                EnumC23259wd1 enumC23259wd1;
                String strH;
                RoomEvent roomEvent = (RoomEvent) obj;
                boolean z = roomEvent instanceof RoomEvent.ActiveSpeakersChanged;
                if (!z) {
                    C19406qI3.a("LiveKitCall", "the event is " + roomEvent.getClass().getName(), new Object[0]);
                }
                if (roomEvent instanceof RoomEvent.Reconnected) {
                    if (this.a.j) {
                        this.a.j = false;
                        this.a.c.e();
                        C19406qI3.a("LiveKitCall", "Reconnected", new Object[0]);
                    }
                } else if (roomEvent instanceof RoomEvent.Reconnecting) {
                    this.a.j = true;
                    this.a.c.j();
                    C19406qI3.a("LiveKitCall", "Reconnecting", new Object[0]);
                } else if (roomEvent instanceof RoomEvent.TrackSubscribed) {
                    if (this.a.j) {
                        this.a.j = false;
                        this.a.c.e();
                    }
                    RoomEvent.TrackSubscribed trackSubscribed = (RoomEvent.TrackSubscribed) roomEvent;
                    AbstractC21649tt7 abstractC21649tt7H = trackSubscribed.getPublication().h();
                    if (abstractC21649tt7H instanceof EV7) {
                        String strH2 = trackSubscribed.getParticipant().h();
                        if (strH2 != null) {
                            String value = Participant.Identity.a(strH2).getValue();
                            this.a.r0(value, (EV7) abstractC21649tt7H, trackSubscribed.getPublication().f(), trackSubscribed.getPublication().b());
                            if (trackSubscribed.getPublication().f() == AbstractC21649tt7.g.b) {
                                this.a.g0(trackSubscribed.getParticipant().h(), new C1329a(roomEvent, value));
                            }
                        }
                    } else if ((abstractC21649tt7H instanceof AbstractC23128wP) && (strH = trackSubscribed.getParticipant().h()) != null) {
                        this.a.g0(trackSubscribed.getParticipant().h(), new e(roomEvent, Participant.Identity.a(strH).getValue()));
                    }
                } else if (roomEvent instanceof RoomEvent.TrackMuted) {
                    RoomEvent.TrackMuted trackMuted = (RoomEvent.TrackMuted) roomEvent;
                    if (trackMuted.getPublication().a() == AbstractC21649tt7.f.b) {
                        this.a.g0(trackMuted.getParticipant().h(), new f(roomEvent));
                    } else if (trackMuted.getPublication().a() == AbstractC21649tt7.f.c) {
                        this.a.g0(trackMuted.getParticipant().h(), new g(roomEvent));
                    }
                } else if (roomEvent instanceof RoomEvent.TrackUnmuted) {
                    RoomEvent.TrackUnmuted trackUnmuted = (RoomEvent.TrackUnmuted) roomEvent;
                    if (trackUnmuted.getPublication().a() == AbstractC21649tt7.f.b) {
                        this.a.g0(trackUnmuted.getParticipant().h(), new h(roomEvent));
                    } else if (trackUnmuted.getPublication().a() == AbstractC21649tt7.f.c) {
                        this.a.g0(trackUnmuted.getParticipant().h(), new i(roomEvent));
                    }
                } else {
                    if (roomEvent instanceof RoomEvent.ConnectionQualityChanged) {
                        RoomEvent.ConnectionQualityChanged connectionQualityChanged = (RoomEvent.ConnectionQualityChanged) roomEvent;
                        String strH3 = connectionQualityChanged.getParticipant().h();
                        String str = strH3 != null ? strH3 : null;
                        C19406qI3.a("LiveKitCall", "participant " + Participant.Sid.f(connectionQualityChanged.getParticipant().o()) + " => is local " + Participant.Sid.d(connectionQualityChanged.getParticipant().o(), this.a.n0().B0().o()) + " and connection quality is " + connectionQualityChanged.getQuality(), new Object[0]);
                        int i = m.a[connectionQualityChanged.getQuality().ordinal()];
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
                        if (AbstractC13042fc3.d(str, ((M26) this.a.t.getValue()).j())) {
                            this.a.f0(new j(enumC23259wd1));
                        } else {
                            this.a.g0(connectionQualityChanged.getParticipant().h(), new k(enumC23259wd1));
                        }
                    } else if (z) {
                        List<Participant> speakers = ((RoomEvent.ActiveSpeakersChanged) roomEvent).getSpeakers();
                        ArrayList arrayList = new ArrayList();
                        Iterator<T> it = speakers.iterator();
                        while (it.hasNext()) {
                            String strH4 = ((Participant) it.next()).h();
                            if (strH4 == null) {
                                strH4 = null;
                            }
                            if (strH4 != null) {
                                arrayList.add(strH4);
                            }
                        }
                        this.a.f0(new l(arrayList));
                        this.a.e0(new b(arrayList));
                    } else if (roomEvent instanceof RoomEvent.TrackUnpublished) {
                        RoomEvent.TrackUnpublished trackUnpublished = (RoomEvent.TrackUnpublished) roomEvent;
                        if (trackUnpublished.getPublication().f() == AbstractC21649tt7.g.d) {
                            this.a.g0(trackUnpublished.getParticipant().h(), c.a);
                            this.a.f0(d.a);
                        }
                    } else if ((roomEvent instanceof RoomEvent.RecordingStatusChanged) && (bv7 = this.a.i) != null) {
                        bv7.d(this.a.n0().Y0());
                    }
                }
                return C19938rB7.a;
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15815kD3.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i2 = this.b;
            if (i2 == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC7983Ua2 interfaceC7983Ua2A0 = C15815kD3.this.n0().A0();
                C15815kD3 c15815kD3 = C15815kD3.this;
                InterfaceC10040ay6 interfaceC10040ay6A = interfaceC7983Ua2A0.a();
                n nVar = new n(c15815kD3);
                this.b = 1;
                if (interfaceC10040ay6A.b(nVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i2 != 1) {
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

    /* renamed from: ir.nasim.kD3$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.kD3$c */
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

    /* renamed from: ir.nasim.kD3$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15815kD3.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C15815kD3.this.s;
                this.b = 1;
                obj = AbstractC6459Nq2.I(interfaceC9336Zm4, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Set set = (Set) obj;
            if (set != null) {
                Set set2 = set;
                ArrayList<InterfaceC9336Zm4> arrayList = new ArrayList(AbstractC10976cX0.x(set2, 10));
                Iterator it = set2.iterator();
                while (it.hasNext()) {
                    arrayList.add((InterfaceC9336Zm4) ((XV4) it.next()).f());
                }
                UA2 ua2 = this.d;
                for (InterfaceC9336Zm4 interfaceC9336Zm42 : arrayList) {
                    do {
                        value = interfaceC9336Zm42.getValue();
                    } while (!interfaceC9336Zm42.f(value, ua2.invoke(value)));
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ UA2 d;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(UA2 ua2, String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = ua2;
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15815kD3.this.new e(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            InterfaceC9336Zm4 interfaceC9336Zm4;
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm42 = C15815kD3.this.s;
                this.b = 1;
                obj = AbstractC6459Nq2.I(interfaceC9336Zm42, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Set set = (Set) obj;
            if (set != null) {
                String str = this.e;
                Iterator it = set.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (AbstractC13042fc3.d(((XV4) next).e(), str != null ? str : null)) {
                        obj2 = next;
                        break;
                    }
                }
                XV4 xv4 = (XV4) obj2;
                if (xv4 != null && (interfaceC9336Zm4 = (InterfaceC9336Zm4) xv4.f()) != null) {
                    UA2 ua2 = this.d;
                    do {
                        value = interfaceC9336Zm4.getValue();
                    } while (!interfaceC9336Zm4.f(value, ua2.invoke(value)));
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C22464vH3 c;
        final /* synthetic */ EnumC23021wD0 d;
        final /* synthetic */ C15815kD3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C22464vH3 c22464vH3, EnumC23021wD0 enumC23021wD0, C15815kD3 c15815kD3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c22464vH3;
            this.d = enumC23021wD0;
            this.e = c15815kD3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, this.e, interfaceC20295rm1);
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
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.e.n;
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15815kD3.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            try {
                C15815kD3.this.n0().p0();
            } catch (Exception e) {
                C19406qI3.a("LiveKitCall", "declineCall, call disconnect exception: " + e, new Object[0]);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15815kD3.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C15815kD3.this.A0();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.kD3$i$a */
        public static final class a implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.kD3$i$a$a, reason: collision with other inner class name */
            public static final class C1330a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.kD3$i$a$a$a, reason: collision with other inner class name */
                public static final class C1331a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1331a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C1330a.this.a(null, this);
                    }
                }

                public C1330a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                        boolean r0 = r7 instanceof ir.nasim.C15815kD3.i.a.C1330a.C1331a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.kD3$i$a$a$a r0 = (ir.nasim.C15815kD3.i.a.C1330a.C1331a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.kD3$i$a$a$a r0 = new ir.nasim.kD3$i$a$a$a
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
                        java.util.Set r6 = (java.util.Set) r6
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
                        java.lang.Object r4 = r4.f()
                        ir.nasim.Zm4 r4 = (ir.nasim.InterfaceC9336Zm4) r4
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
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15815kD3.i.a.C1330a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C1330a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15815kD3.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            BV7 bv7 = C15815kD3.this.i;
            if (bv7 != null) {
                bv7.b(C15815kD3.this.t);
            }
            BV7 bv72 = C15815kD3.this.i;
            if (bv72 != null) {
                bv72.c(new a(C15815kD3.this.s));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
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

        /* renamed from: ir.nasim.kD3$j$a */
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
        j(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2, InterfaceC20295rm1 interfaceC20295rm1) {
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
            return C15815kD3.this.new j(this.j, this.k, this.l, this.m, this.n, this.o, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:57:0x0161 A[Catch: Exception -> 0x0025, TryCatch #0 {Exception -> 0x0025, blocks: (B:7:0x0020, B:53:0x0148, B:54:0x014c, B:58:0x0166, B:60:0x0194, B:57:0x0161, B:14:0x0042, B:46:0x0123, B:48:0x0128, B:17:0x004c, B:19:0x0063, B:38:0x00c6, B:40:0x00e9, B:42:0x00f8, B:41:0x00f1, B:20:0x0074, B:22:0x0093, B:24:0x0099, B:26:0x009f, B:28:0x00a9, B:30:0x00ad, B:32:0x00b3, B:34:0x00b9, B:36:0x00c3), top: B:65:0x000a }] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r36) {
            /*
                Method dump skipped, instructions count: 451
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15815kD3.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15815kD3.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                io.livekit.android.room.participant.a aVarB0 = C15815kD3.this.n0().B0();
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
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.kD3$l$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C15815kD3 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C15815kD3 c15815kD3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c15815kD3;
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

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15815kD3.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6E = AbstractC5508Jq2.e(new AbstractC24042xw5(C15815kD3.this.n0()) { // from class: ir.nasim.kD3.l.a
                    @Override // ir.nasim.InterfaceC3820Cm3
                    public Object get() {
                        return ((Room) this.receiver).O0();
                    }
                });
                b bVar = new b(C15815kD3.this, null);
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
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ C15815kD3 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(boolean z, C15815kD3 c15815kD3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = c15815kD3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new m(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            M26 m26;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19406qI3.a("LiveKitCall", "mute audio => status " + this.c, new Object[0]);
                if (this.d.k) {
                    io.livekit.android.room.participant.a aVarB0 = this.d.n0().B0();
                    boolean z = !this.c;
                    this.b = 1;
                    if (aVarB0.a1(z, this) == objE) {
                        return objE;
                    }
                } else {
                    C19406qI3.a("LiveKitCall", "mute audio user not connected to the room", new Object[0]);
                    C15815kD3 c15815kD3 = this.d;
                    M26 m262 = c15815kD3.m;
                    c15815kD3.m = m262.a((32735 & 1) != 0 ? m262.a : this.c, (32735 & 2) != 0 ? m262.b : false, (32735 & 4) != 0 ? m262.c : false, (32735 & 8) != 0 ? m262.d : false, (32735 & 16) != 0 ? m262.e : null, (32735 & 32) != 0 ? m262.f : null, (32735 & 64) != 0 ? m262.g : null, (32735 & 128) != 0 ? m262.h : null, (32735 & 256) != 0 ? m262.i : null, (32735 & 512) != 0 ? m262.j : false, (32735 & 1024) != 0 ? m262.k : null, (32735 & 2048) != 0 ? m262.l : null, (32735 & 4096) != 0 ? m262.m : null, (32735 & 8192) != 0 ? m262.n : null, (32735 & 16384) != 0 ? m262.o : null);
                    InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.t;
                    C15815kD3 c15815kD32 = this.d;
                    do {
                        value = interfaceC9336Zm4.getValue();
                        m26 = (M26) value;
                    } while (!interfaceC9336Zm4.f(value, m26.a((32735 & 1) != 0 ? m26.a : c15815kD32.m.s(), (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null)));
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
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15815kD3.this.new n(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                io.livekit.android.room.participant.a aVarB0 = C15815kD3.this.n0().B0();
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
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$o */
    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.kD3$o$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C15815kD3 c;

            /* renamed from: ir.nasim.kD3$o$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C15815kD3 d;

                /* renamed from: ir.nasim.kD3$o$a$b$b, reason: collision with other inner class name */
                static final class C1334b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ boolean c;
                    final /* synthetic */ C15815kD3 d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1334b(C15815kD3 c15815kD3, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = c15815kD3;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1334b c1334b = new C1334b(this.d, interfaceC20295rm1);
                        c1334b.c = ((Boolean) obj).booleanValue();
                        return c1334b;
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
                        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.t;
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
                        return ((C1334b) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(C15815kD3 c15815kD3, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c15815kD3;
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
                        InterfaceC10258bL6 interfaceC10258bL6E = AbstractC5508Jq2.e(new AbstractC24042xw5((AbstractC4838Gt7) this.c) { // from class: ir.nasim.kD3.o.a.b.a
                            @Override // ir.nasim.InterfaceC3820Cm3
                            public Object get() {
                                return Boolean.valueOf(((AbstractC4838Gt7) this.receiver).b());
                            }
                        });
                        C1334b c1334b = new C1334b(this.d, null);
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC10258bL6E, c1334b, this) == objE) {
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

            /* renamed from: ir.nasim.kD3$o$a$c */
            public static final class c implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.kD3$o$a$c$a, reason: collision with other inner class name */
                public static final class C1335a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.kD3$o$a$c$a$a, reason: collision with other inner class name */
                    public static final class C1336a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1336a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1335a.this.a(null, this);
                        }
                    }

                    public C1335a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                            boolean r0 = r6 instanceof ir.nasim.C15815kD3.o.a.c.C1335a.C1336a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.kD3$o$a$c$a$a r0 = (ir.nasim.C15815kD3.o.a.c.C1335a.C1336a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.kD3$o$a$c$a$a r0 = new ir.nasim.kD3$o$a$c$a$a
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
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15815kD3.o.a.c.C1335a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1335a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.kD3$o$a$d */
            public static final class d implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.kD3$o$a$d$a, reason: collision with other inner class name */
                public static final class C1337a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.kD3$o$a$d$a$a, reason: collision with other inner class name */
                    public static final class C1338a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1338a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1337a.this.a(null, this);
                        }
                    }

                    public C1337a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                            boolean r0 = r7 instanceof ir.nasim.C15815kD3.o.a.d.C1337a.C1338a
                            if (r0 == 0) goto L13
                            r0 = r7
                            ir.nasim.kD3$o$a$d$a$a r0 = (ir.nasim.C15815kD3.o.a.d.C1337a.C1338a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.kD3$o$a$d$a$a r0 = new ir.nasim.kD3$o$a$d$a$a
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
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15815kD3.o.a.d.C1337a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1337a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.kD3$o$a$e */
            public static final class e implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.kD3$o$a$e$a, reason: collision with other inner class name */
                public static final class C1339a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.kD3$o$a$e$a$a, reason: collision with other inner class name */
                    public static final class C1340a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1340a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1339a.this.a(null, this);
                        }
                    }

                    public C1339a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                            boolean r0 = r6 instanceof ir.nasim.C15815kD3.o.a.e.C1339a.C1340a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.kD3$o$a$e$a$a r0 = (ir.nasim.C15815kD3.o.a.e.C1339a.C1340a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.kD3$o$a$e$a$a r0 = new ir.nasim.kD3$o$a$e$a$a
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
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15815kD3.o.a.e.C1339a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public e(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1339a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C15815kD3 c15815kD3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c15815kD3;
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
                    e eVar = new e(new c(new d(AbstractC5508Jq2.e(new AbstractC24042xw5(this.c.n0().B0()) { // from class: ir.nasim.kD3.o.a.a
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

        /* renamed from: ir.nasim.kD3$o$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ C15815kD3 d;

            /* renamed from: ir.nasim.kD3$o$b$b, reason: collision with other inner class name */
            static final class C1341b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ InterfaceC20315ro1 d;
                final /* synthetic */ C15815kD3 e;

                /* renamed from: ir.nasim.kD3$o$b$b$a */
                static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ List c;
                    final /* synthetic */ C15815kD3 d;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    a(List list, C15815kD3 c15815kD3, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = list;
                        this.d = c15815kD3;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new a(this.c, this.d, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object next;
                        Object value;
                        M26 m26;
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        Iterator it = this.c.iterator();
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
                        if (((AbstractC4838Gt7) next) == null) {
                            return C19938rB7.a;
                        }
                        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.t;
                        do {
                            value = interfaceC9336Zm4.getValue();
                            m26 = (M26) value;
                        } while (!interfaceC9336Zm4.f(value, m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : false, (32735 & 8) != 0 ? m26.d : !((Boolean) new AbstractC24042xw5
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:836)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:97)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:878)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:345)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:97)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:878)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                            	at jadx.core.codegen.InsnGen.oneArgInsn(InsnGen.java:689)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:362)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.makeTernary(InsnGen.java:1189)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:536)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.ConditionGen.wrap(ConditionGen.java:95)
                            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:123)
                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:219)
                            	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:298)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:277)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:410)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                            */
                        /*
                            this = this;
                            r0 = r22
                            ir.nasim.AbstractC13660gc3.e()
                            int r1 = r0.b
                            if (r1 != 0) goto L73
                            ir.nasim.AbstractC10685c16.b(r23)
                            java.util.List r1 = r0.c
                            java.lang.Iterable r1 = (java.lang.Iterable) r1
                            java.util.Iterator r1 = r1.iterator()
                        L14:
                            boolean r2 = r1.hasNext()
                            if (r2 == 0) goto L2a
                            java.lang.Object r2 = r1.next()
                            r3 = r2
                            ir.nasim.Gt7 r3 = (ir.nasim.AbstractC4838Gt7) r3
                            ir.nasim.tt7$g r3 = r3.f()
                            ir.nasim.tt7$g r4 = ir.nasim.AbstractC21649tt7.g.d
                            if (r3 != r4) goto L14
                            goto L2b
                        L2a:
                            r2 = 0
                        L2b:
                            ir.nasim.Gt7 r2 = (ir.nasim.AbstractC4838Gt7) r2
                            if (r2 != 0) goto L32
                            ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
                            return r1
                        L32:
                            ir.nasim.kD3 r1 = r0.d
                            ir.nasim.Zm4 r1 = ir.nasim.C15815kD3.K(r1)
                        L38:
                            java.lang.Object r3 = r1.getValue()
                            r4 = r3
                            ir.nasim.M26 r4 = (ir.nasim.M26) r4
                            ir.nasim.kD3$o$b$b$a$a r5 = new ir.nasim.kD3$o$b$b$a$a
                            r5.<init>(r2)
                            java.lang.Object r5 = r5.get()
                            java.lang.Boolean r5 = (java.lang.Boolean) r5
                            boolean r5 = r5.booleanValue()
                            r8 = r5 ^ 1
                            r20 = 32759(0x7ff7, float:4.5905E-41)
                            r21 = 0
                            r5 = 0
                            r6 = 0
                            r7 = 0
                            r9 = 0
                            r10 = 0
                            r11 = 0
                            r12 = 0
                            r13 = 0
                            r14 = 0
                            r15 = 0
                            r16 = 0
                            r17 = 0
                            r18 = 0
                            r19 = 0
                            ir.nasim.M26 r4 = ir.nasim.M26.b(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
                            boolean r3 = r1.f(r3, r4)
                            if (r3 == 0) goto L38
                            ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
                            return r1
                        L73:
                            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                            r1.<init>(r2)
                            throw r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15815kD3.o.b.C1341b.a.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.kD3$o$b$b$b, reason: collision with other inner class name */
                static final class C1343b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ List c;
                    final /* synthetic */ C15815kD3 d;

                    /* renamed from: ir.nasim.kD3$o$b$b$b$b, reason: collision with other inner class name */
                    static final class C1344b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                        int b;
                        /* synthetic */ boolean c;
                        final /* synthetic */ C15815kD3 d;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C1344b(C15815kD3 c15815kD3, InterfaceC20295rm1 interfaceC20295rm1) {
                            super(2, interfaceC20295rm1);
                            this.d = c15815kD3;
                        }

                        @Override // ir.nasim.E90
                        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                            C1344b c1344b = new C1344b(this.d, interfaceC20295rm1);
                            c1344b.c = ((Boolean) obj).booleanValue();
                            return c1344b;
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
                            InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.t;
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
                            return ((C1344b) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1343b(List list, C15815kD3 c15815kD3, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = list;
                        this.d = c15815kD3;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C1343b(this.c, this.d, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object next;
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            Iterator it = this.c.iterator();
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
                            InterfaceC10258bL6 interfaceC10258bL6E = AbstractC5508Jq2.e(new AbstractC24042xw5(abstractC4838Gt7) { // from class: ir.nasim.kD3.o.b.b.b.a
                                @Override // ir.nasim.InterfaceC3820Cm3
                                public Object get() {
                                    return Boolean.valueOf(((AbstractC4838Gt7) this.receiver).b());
                                }
                            });
                            C1344b c1344b = new C1344b(this.d, null);
                            this.b = 1;
                            if (AbstractC6459Nq2.l(interfaceC10258bL6E, c1344b, this) == objE) {
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
                        return ((C1343b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1341b(InterfaceC20315ro1 interfaceC20315ro1, C15815kD3 c15815kD3, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = interfaceC20315ro1;
                    this.e = c15815kD3;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1341b c1341b = new C1341b(this.d, this.e, interfaceC20295rm1);
                    c1341b.c = obj;
                    return c1341b;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    List list = (List) this.c;
                    AbstractC10533bm0.d(this.d, null, null, new a(list, this.e, null), 3, null);
                    AbstractC10533bm0.d(this.d, null, null, new C1343b(list, this.e, null), 3, null);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1341b) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.kD3$o$b$c */
            public static final class c implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.kD3$o$b$c$a */
                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.kD3$o$b$c$a$a, reason: collision with other inner class name */
                    public static final class C1345a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1345a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                            boolean r0 = r6 instanceof ir.nasim.C15815kD3.o.b.c.a.C1345a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.kD3$o$b$c$a$a r0 = (ir.nasim.C15815kD3.o.b.c.a.C1345a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.kD3$o$b$c$a$a r0 = new ir.nasim.kD3$o$b$c$a$a
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
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15815kD3.o.b.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

            /* renamed from: ir.nasim.kD3$o$b$d */
            public static final class d implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.kD3$o$b$d$a */
                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.kD3$o$b$d$a$a, reason: collision with other inner class name */
                    public static final class C1346a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1346a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                            boolean r0 = r7 instanceof ir.nasim.C15815kD3.o.b.d.a.C1346a
                            if (r0 == 0) goto L13
                            r0 = r7
                            ir.nasim.kD3$o$b$d$a$a r0 = (ir.nasim.C15815kD3.o.b.d.a.C1346a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.kD3$o$b$d$a$a r0 = new ir.nasim.kD3$o$b$d$a$a
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
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15815kD3.o.b.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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
            b(C15815kD3 c15815kD3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c15815kD3;
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
                    InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    c cVar = new c(new d(AbstractC5508Jq2.e(new AbstractC24042xw5(this.d.n0().B0()) { // from class: ir.nasim.kD3.o.b.a
                        @Override // ir.nasim.InterfaceC3820Cm3
                        public Object get() {
                            return ((io.livekit.android.room.participant.a) this.receiver).s();
                        }
                    })));
                    C1341b c1341b = new C1341b(interfaceC20315ro1, this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(cVar, c1341b, this) == objE) {
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

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            o oVar = C15815kD3.this.new o(interfaceC20295rm1);
            oVar.c = obj;
            return oVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(C15815kD3.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(C15815kD3.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$p */
    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.kD3$p$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C15815kD3 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C15815kD3 c15815kD3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c15815kD3;
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
                D27 d27 = this.d.q;
                if (d27 == null) {
                    return C19938rB7.a;
                }
                Room roomN0 = this.d.n0();
                AbstractC21649tt7.g gVarF = abstractC4838Gt7.f();
                Context context = this.d.f;
                boolean zFb = C8386Vt0.a.Fb();
                InterfaceC11299cm3 interfaceC11299cm3B = AbstractC10882cM5.b(AbstractC22594vV7.b.class);
                if (AbstractC13042fc3.d(interfaceC11299cm3B, AbstractC10882cM5.b(AbstractC22594vV7.b.class))) {
                    bVar = new AbstractC22594vV7.b(roomN0, ev7, gVarF, d27.a(), zFb);
                } else {
                    if (!AbstractC13042fc3.d(interfaceC11299cm3B, AbstractC10882cM5.b(AbstractC22594vV7.a.class))) {
                        throw new IllegalArgumentException("Unsupported type " + AbstractC10882cM5.b(AbstractC22594vV7.b.class));
                    }
                    bVar = (AbstractC22594vV7.b) new AbstractC22594vV7.a(roomN0, ev7, context, d27.a());
                }
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.t;
                do {
                    value = interfaceC9336Zm4.getValue();
                    m26 = (M26) value;
                } while (!interfaceC9336Zm4.f(value, m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : true, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null)));
                if (abstractC4838Gt7.f() == AbstractC21649tt7.g.d) {
                    InterfaceC9336Zm4 interfaceC9336Zm42 = this.d.t;
                    do {
                        value3 = interfaceC9336Zm42.getValue();
                        m263 = (M26) value3;
                    } while (!interfaceC9336Zm42.f(value3, m263.a((32735 & 1) != 0 ? m263.a : false, (32735 & 2) != 0 ? m263.b : false, (32735 & 4) != 0 ? m263.c : false, (32735 & 8) != 0 ? m263.d : true, (32735 & 16) != 0 ? m263.e : null, (32735 & 32) != 0 ? m263.f : null, (32735 & 64) != 0 ? m263.g : null, (32735 & 128) != 0 ? m263.h : null, (32735 & 256) != 0 ? m263.i : C24964zV7.a.a(bVar), (32735 & 512) != 0 ? m263.j : false, (32735 & 1024) != 0 ? m263.k : null, (32735 & 2048) != 0 ? m263.l : null, (32735 & 4096) != 0 ? m263.m : null, (32735 & 8192) != 0 ? m263.n : null, (32735 & 16384) != 0 ? m263.o : null)));
                } else if (abstractC4838Gt7.f() == AbstractC21649tt7.g.b) {
                    InterfaceC9336Zm4 interfaceC9336Zm43 = this.d.t;
                    do {
                        value2 = interfaceC9336Zm43.getValue();
                        m262 = (M26) value2;
                    } while (!interfaceC9336Zm43.f(value2, m262.a((32735 & 1) != 0 ? m262.a : false, (32735 & 2) != 0 ? m262.b : false, (32735 & 4) != 0 ? m262.c : false, (32735 & 8) != 0 ? m262.d : false, (32735 & 16) != 0 ? m262.e : null, (32735 & 32) != 0 ? m262.f : null, (32735 & 64) != 0 ? m262.g : null, (32735 & 128) != 0 ? m262.h : C24964zV7.a.a(bVar), (32735 & 256) != 0 ? m262.i : null, (32735 & 512) != 0 ? m262.j : false, (32735 & 1024) != 0 ? m262.k : null, (32735 & 2048) != 0 ? m262.l : null, (32735 & 4096) != 0 ? m262.m : null, (32735 & 8192) != 0 ? m262.n : null, (32735 & 16384) != 0 ? m262.o : null)));
                }
                bVar.o(this.d.n);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.kD3$p$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.kD3$p$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.kD3$p$c$a$a, reason: collision with other inner class name */
                public static final class C1347a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1347a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r7 instanceof ir.nasim.C15815kD3.p.c.a.C1347a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.kD3$p$c$a$a r0 = (ir.nasim.C15815kD3.p.c.a.C1347a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.kD3$p$c$a$a r0 = new ir.nasim.kD3$p$c$a$a
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
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15815kD3.p.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15815kD3.this.new p(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                c cVar = new c(AbstractC5508Jq2.e(new AbstractC24042xw5(C15815kD3.this.n0().B0()) { // from class: ir.nasim.kD3.p.a
                    @Override // ir.nasim.InterfaceC3820Cm3
                    public Object get() {
                        return ((io.livekit.android.room.participant.a) this.receiver).s();
                    }
                }));
                b bVar = new b(C15815kD3.this, null);
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
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$q */
    static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.kD3$q$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C15815kD3 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C15815kD3 c15815kD3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c15815kD3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                List list = (List) this.c;
                if (!this.d.l && (!list.isEmpty())) {
                    if (C8386Vt0.a.k8()) {
                        this.d.z0();
                    } else {
                        this.d.q0();
                    }
                }
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.s;
                do {
                    value = interfaceC9336Zm4.getValue();
                    C19406qI3.a("LiveKitCall", "update remote participants: " + list, new Object[0]);
                } while (!interfaceC9336Zm4.f(value, AbstractC15401jX0.r1(list)));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.kD3$q$c */
        public static final class c implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;
            final /* synthetic */ C15815kD3 b;

            /* renamed from: ir.nasim.kD3$q$c$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;
                final /* synthetic */ C15815kD3 b;

                /* renamed from: ir.nasim.kD3$q$c$a$a, reason: collision with other inner class name */
                public static final class C1348a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1348a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2, C15815kD3 c15815kD3) {
                    this.a = interfaceC4806Gq2;
                    this.b = c15815kD3;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r32, ir.nasim.InterfaceC20295rm1 r33) {
                    /*
                        Method dump skipped, instructions count: 303
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15815kD3.q.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public c(InterfaceC4557Fq2 interfaceC4557Fq2, C15815kD3 c15815kD3) {
                this.a = interfaceC4557Fq2;
                this.b = c15815kD3;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        q(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15815kD3.this.new q(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                c cVar = new c(AbstractC5508Jq2.e(new AbstractC24042xw5(C15815kD3.this.n0()) { // from class: ir.nasim.kD3.q.a
                    @Override // ir.nasim.InterfaceC3820Cm3
                    public Object get() {
                        return ((Room) this.receiver).L0();
                    }
                }), C15815kD3.this);
                b bVar = new b(C15815kD3.this, null);
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
            return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.kD3$r$a */
        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            /* synthetic */ Object c;
            /* synthetic */ Object d;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                Participant.b bVar = (Participant.b) this.c;
                Participant.b bVar2 = (Participant.b) this.d;
                Participant.b bVar3 = Participant.b.c;
                return AbstractC6392Nk0.a(bVar == bVar3 && bVar2 == bVar3);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(Participant.b bVar, Participant.b bVar2, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(interfaceC20295rm1);
                aVar.c = bVar;
                aVar.d = bVar2;
                return aVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.kD3$r$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.kD3$r$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.kD3$r$b$a$a, reason: collision with other inner class name */
                public static final class C1349a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1349a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r6 instanceof ir.nasim.C15815kD3.r.b.a.C1349a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.kD3$r$b$a$a r0 = (ir.nasim.C15815kD3.r.b.a.C1349a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.kD3$r$b$a$a r0 = new ir.nasim.kD3$r$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L48
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        r2 = r5
                        java.lang.Boolean r2 = (java.lang.Boolean) r2
                        boolean r2 = r2.booleanValue()
                        if (r2 == 0) goto L48
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L48
                        return r1
                    L48:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15815kD3.r.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.kD3$r$c */
        public static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;

            public c(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    InterfaceC10258bL6 interfaceC10258bL6E = AbstractC5508Jq2.e(new AbstractC5474Jm4((io.livekit.android.room.participant.d) this.d) { // from class: ir.nasim.kD3.r.g
                        @Override // ir.nasim.InterfaceC3820Cm3
                        public Object get() {
                            return ((io.livekit.android.room.participant.d) this.receiver).p();
                        }
                    });
                    this.b = 1;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC10258bL6E, this) == objE) {
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
                c cVar = new c(interfaceC20295rm1);
                cVar.c = interfaceC4806Gq2;
                cVar.d = obj;
                return cVar.invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.kD3$r$d */
        public static final class d implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.kD3$r$d$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.kD3$r$d$a$a, reason: collision with other inner class name */
                public static final class C1350a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1350a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r6 instanceof ir.nasim.C15815kD3.r.d.a.C1350a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.kD3$r$d$a$a r0 = (ir.nasim.C15815kD3.r.d.a.C1350a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.kD3$r$d$a$a r0 = new ir.nasim.kD3$r$d$a$a
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
                        java.util.Map r5 = (java.util.Map) r5
                        java.util.Collection r5 = r5.values()
                        java.lang.Iterable r5 = (java.lang.Iterable) r5
                        java.lang.Object r5 = ir.nasim.ZW0.r0(r5)
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L4b
                        return r1
                    L4b:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15815kD3.r.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15815kD3.this.new r(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(AbstractC6459Nq2.p(AbstractC5508Jq2.e(new AbstractC5474Jm4(C15815kD3.this.n0().B0()) { // from class: ir.nasim.kD3.r.e
                    @Override // ir.nasim.InterfaceC3820Cm3
                    public Object get() {
                        return ((io.livekit.android.room.participant.a) this.receiver).p();
                    }
                }), AbstractC6459Nq2.s0(AbstractC6459Nq2.F(new d(AbstractC5508Jq2.e(new AbstractC24042xw5(C15815kD3.this.n0()) { // from class: ir.nasim.kD3.r.f
                    @Override // ir.nasim.InterfaceC3820Cm3
                    public Object get() {
                        return ((Room) this.receiver).L0();
                    }
                }))), new c(null)), new a(null)));
                this.b = 1;
                obj = AbstractC6459Nq2.G(bVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C15815kD3 c15815kD3 = C15815kD3.this;
            ((Boolean) obj).booleanValue();
            c15815kD3.q0();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$s */
    /* synthetic */ class s extends EB2 implements UA2 {
        s(Object obj) {
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

    /* renamed from: ir.nasim.kD3$t */
    /* synthetic */ class t extends EB2 implements UA2 {
        t(Object obj) {
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

    /* renamed from: ir.nasim.kD3$u */
    static final class u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ io.livekit.android.room.participant.a c;
        final /* synthetic */ Intent d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        u(io.livekit.android.room.participant.a aVar, Intent intent, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = aVar;
            this.d = intent;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new u(this.c, this.d, interfaceC20295rm1);
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
            return ((u) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.kD3$v */
    static final class v extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ io.livekit.android.room.participant.a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        v(io.livekit.android.room.participant.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new v(this.c, interfaceC20295rm1);
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
            return ((v) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C15815kD3(A08 a08, SettingsModule settingsModule, Y08 y08, C17536n78 c17536n78, InterfaceC20315ro1 interfaceC20315ro1, Context context, C9728aS7 c9728aS7, OkHttpClient okHttpClient) {
        AbstractC13042fc3.i(a08, "voiceCallModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(y08, "voiceSwitchCallback");
        AbstractC13042fc3.i(c17536n78, "webRTCMetricLogger");
        AbstractC13042fc3.i(interfaceC20315ro1, "serviceScope");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c9728aS7, "versionCodeNumber");
        AbstractC13042fc3.i(okHttpClient, "okHttpClient");
        this.a = a08;
        this.b = settingsModule;
        this.c = y08;
        this.d = c17536n78;
        this.e = interfaceC20315ro1;
        this.f = context;
        this.g = c9728aS7;
        this.h = okHttpClient;
        this.m = new M26(false, false, false, false, null, null, null, null, null, false, null, null, null, null, null, 32767, null);
        this.n = AbstractC12281eL6.a(Boolean.TRUE);
        this.r = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.YC3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15815kD3.B0(this.a);
            }
        });
        this.s = AbstractC12281eL6.a(AbstractC4597Fu6.d());
        this.t = AbstractC12281eL6.a(new M26(false, false, false, false, String.valueOf(AbstractC5969Lp4.f()), null, null, null, null, false, null, null, null, null, null, 32751, null));
        this.q = new D27(interfaceC20315ro1);
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(null), 3, null);
        x0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0() {
        this.d.g(new s(n0()));
        this.d.h(new t(n0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Room B0(C15815kD3 c15815kD3) {
        AbstractC13042fc3.i(c15815kD3, "this$0");
        Room roomA = UC3.a.a(C5721Ko.a.d(), (2 & 2) != 0 ? new K26(false, false, null, null, null, null, null, null, null, 511, null) : null, (2 & 4) != 0 ? new XC3(null, null, null, null, null, null, 63, null) : new XC3(c15815kD3.h, null, null, new WN(null, new AA4(), null, null, false, null, 61, null), null, null, 54, null));
        if (C8386Vt0.a.Oa()) {
            roomA.k1(TJ5.b);
        }
        UC3.d(UI3.a);
        List listN = AbstractC5270Ip7.a.n();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listN) {
            if (obj instanceof AbstractC5270Ip7.a) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            AbstractC5270Ip7.a.q((AbstractC5270Ip7.a) it.next());
        }
        return roomA;
    }

    private final void C0(C11458d25 c11458d25, final boolean z) {
        if (c11458d25.z()) {
            this.a.X(new C11458d25(W25.b, c11458d25.getPeerId()), z).m0(new InterfaceC24449ye1() { // from class: ir.nasim.fD3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C15815kD3.D0(this.a, z, (MeetOuterClass$ResponseStartGroupCall) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.gD3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C15815kD3.E0(this.a, (Exception) obj);
                }
            });
        } else {
            this.a.W(c11458d25, EnumC13941h47.a, z).m0(new InterfaceC24449ye1() { // from class: ir.nasim.hD3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C15815kD3.F0(this.a, z, (MeetOuterClass$ResponseCall) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.iD3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C15815kD3.G0(this.a, (Exception) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(C15815kD3 c15815kD3, MeetOuterClass$ResponseCall meetOuterClass$ResponseCall) {
        AbstractC13042fc3.i(c15815kD3, "this$0");
        c15815kD3.u = meetOuterClass$ResponseCall.getCall().getUrl().getValue();
        c15815kD3.v = meetOuterClass$ResponseCall.getCall().getToken();
        String value = meetOuterClass$ResponseCall.getCall().getUrl().getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        String token = meetOuterClass$ResponseCall.getCall().getToken();
        AbstractC13042fc3.h(token, "getToken(...)");
        j0(c15815kD3, value, token, false, false, false, false, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(C15815kD3 c15815kD3, boolean z, MeetOuterClass$ResponseStartGroupCall meetOuterClass$ResponseStartGroupCall) {
        AbstractC13042fc3.i(c15815kD3, "this$0");
        c15815kD3.c.b(meetOuterClass$ResponseStartGroupCall.getGroupCall().getId());
        String text = meetOuterClass$ResponseStartGroupCall.getGroupCall().getUrl().getText();
        AbstractC13042fc3.h(text, "getText(...)");
        String token = meetOuterClass$ResponseStartGroupCall.getGroupCall().getToken();
        AbstractC13042fc3.h(token, "getToken(...)");
        j0(c15815kD3, text, token, false, !z, false, false, 52, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C15815kD3 c15815kD3, Exception exc) {
        AbstractC13042fc3.i(c15815kD3, "this$0");
        Y08 y08 = c15815kD3.c;
        AbstractC13042fc3.f(exc);
        y08.g(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(C15815kD3 c15815kD3, boolean z, MeetOuterClass$ResponseCall meetOuterClass$ResponseCall) {
        AbstractC13042fc3.i(c15815kD3, "this$0");
        c15815kD3.c.b(meetOuterClass$ResponseCall.getCall().getId());
        MeetStruct$Call call = meetOuterClass$ResponseCall.getCall();
        AbstractC13042fc3.f(call);
        String value = call.getUrl().getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        MeetStruct$Call call2 = meetOuterClass$ResponseCall.getCall();
        AbstractC13042fc3.f(call2);
        String token = call2.getToken();
        AbstractC13042fc3.f(token);
        j0(c15815kD3, value, token, false, !z, meetOuterClass$ResponseCall.getIsStream().getValue(), false, 36, null);
        BV7 bv7 = c15815kD3.i;
        if (bv7 != null) {
            bv7.a(meetOuterClass$ResponseCall.getIsStream().getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(C15815kD3 c15815kD3, Exception exc) {
        AbstractC13042fc3.i(c15815kD3, "this$0");
        Y08 y08 = c15815kD3.c;
        AbstractC13042fc3.f(exc);
        y08.g(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(C15815kD3 c15815kD3, MeetOuterClass$ResponseStartGroupCall meetOuterClass$ResponseStartGroupCall) {
        AbstractC13042fc3.i(c15815kD3, "this$0");
        c15815kD3.c.b(meetOuterClass$ResponseStartGroupCall.getGroupCall().getId());
        String text = meetOuterClass$ResponseStartGroupCall.getGroupCall().getUrl().getText();
        AbstractC13042fc3.h(text, "getText(...)");
        String token = meetOuterClass$ResponseStartGroupCall.getGroupCall().getToken();
        AbstractC13042fc3.h(token, "getToken(...)");
        j0(c15815kD3, text, token, false, false, false, false, 60, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(C15815kD3 c15815kD3, Exception exc) {
        AbstractC13042fc3.i(c15815kD3, "this$0");
        Y08 y08 = c15815kD3.c;
        AbstractC13042fc3.f(exc);
        y08.g(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 e0(UA2 ua2) {
        return AbstractC10533bm0.d(this.e, null, null, new d(ua2, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(UA2 ua2) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.t;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, ua2.invoke(value)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC13730gj3 g0(String str, UA2 ua2) {
        return AbstractC10533bm0.d(this.e, null, null, new e(ua2, str, null), 3, null);
    }

    private final void h0() {
        AbstractC10533bm0.d(this.e, null, null, new g(null), 3, null);
    }

    private final void i0(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        if (C5505Jq.G() && C5505Jq.H()) {
            AbstractC10533bm0.d(this.e, null, null, new h(null), 3, null);
            AbstractC10533bm0.d(this.e, null, null, new i(null), 3, null);
            AbstractC10533bm0.d(this.e, null, null, new j(z3, z, z2, z4, str, str2, null), 3, null);
        }
    }

    static /* synthetic */ void j0(C15815kD3 c15815kD3, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        c15815kD3.i0(str, str2, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? true : z2, (i2 & 16) != 0 ? false : z3, (i2 & 32) != 0 ? true : z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final K26 k0(boolean z) {
        return new K26(true, true, null, null, new C23060wH3(false, null, z ? EnumC23021wD0.a : EnumC23021wD0.b, null, 11, null), m0(), p0(), null, o0(), WKSRecord.Service.EMFIS_DATA, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final K26 l0(boolean z) {
        Object next;
        K26 k26;
        C22279uy0 c22279uy0P3 = this.b.p3();
        if (c22279uy0P3 == null) {
            return new K26(false, false, null, null, new C23060wH3(false, null, z ? EnumC23021wD0.a : EnumC23021wD0.b, null, 11, null), null, null, null, null, 495, null);
        }
        Set setEntrySet = c22279uy0P3.a().entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (((Number) ((Map.Entry) obj).getKey()).longValue() <= this.g.a()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long jLongValue = ((Number) ((Map.Entry) next).getKey()).longValue();
                do {
                    Object next2 = it.next();
                    long jLongValue2 = ((Number) ((Map.Entry) next2).getKey()).longValue();
                    if (jLongValue < jLongValue2) {
                        next = next2;
                        jLongValue = jLongValue2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry == null || (k26 = (K26) entry.getValue()) == null) {
            k26 = (K26) AbstractC15401jX0.p0(c22279uy0P3.a().values());
        }
        K26 k262 = k26;
        C19406qI3.a("LiveKitCall", "the config is " + k262, new Object[0]);
        C23060wH3 c23060wH3J = k262.j();
        return K26.b(k262, false, false, null, null, c23060wH3J != null ? C23060wH3.b(c23060wH3J, false, null, z ? EnumC23021wD0.a : EnumC23021wD0.b, null, 11, null) : null, null, null, null, null, 495, null);
    }

    private final C23718xP m0() {
        VoiceConfig voiceConfig;
        CallRemoteConfig callRemoteConfigQ0 = this.b.Q0();
        return new C23718xP((callRemoteConfigQ0 == null || (voiceConfig = callRemoteConfigQ0.getVoiceConfig()) == null) ? null : voiceConfig.getAudioBitrate(), false, false, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Room n0() {
        return (Room) this.r.getValue();
    }

    private final FV7 o0() {
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

    private final FV7 p0() {
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
    public final void q0() {
        this.c.h();
        this.l = true;
        AbstractC10533bm0.d(this.e, null, null, new l(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(String str, EV7 ev7, AbstractC21649tt7.g gVar, final boolean z) {
        final AbstractC22594vV7.b bVar;
        D27 d27 = this.q;
        if (d27 != null) {
            Room roomN0 = n0();
            Context context = this.f;
            boolean zFb = C8386Vt0.a.Fb();
            InterfaceC11299cm3 interfaceC11299cm3B = AbstractC10882cM5.b(AbstractC22594vV7.b.class);
            if (AbstractC13042fc3.d(interfaceC11299cm3B, AbstractC10882cM5.b(AbstractC22594vV7.b.class))) {
                bVar = new AbstractC22594vV7.b(roomN0, ev7, gVar, d27.a(), zFb);
            } else {
                if (!AbstractC13042fc3.d(interfaceC11299cm3B, AbstractC10882cM5.b(AbstractC22594vV7.a.class))) {
                    throw new IllegalArgumentException("Unsupported type " + AbstractC10882cM5.b(AbstractC22594vV7.b.class));
                }
                bVar = (AbstractC22594vV7.b) new AbstractC22594vV7.a(roomN0, ev7, context, d27.a());
            }
            if (gVar == AbstractC21649tt7.g.d) {
                g0(str, new UA2() { // from class: ir.nasim.ZC3
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C15815kD3.s0(bVar, (M26) obj);
                    }
                });
            } else if (gVar == AbstractC21649tt7.g.b) {
                g0(str, new UA2() { // from class: ir.nasim.aD3
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C15815kD3.t0(bVar, z, (M26) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M26 s0(AbstractC22594vV7.b bVar, M26 m26) {
        AbstractC13042fc3.i(bVar, "$remoteVideoSurface");
        AbstractC13042fc3.i(m26, "it");
        return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : false, (32735 & 4) != 0 ? m26.c : true, (32735 & 8) != 0 ? m26.d : true, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : null, (32735 & 256) != 0 ? m26.i : C24964zV7.a.a(bVar), (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final M26 t0(AbstractC22594vV7.b bVar, boolean z, M26 m26) {
        AbstractC13042fc3.i(bVar, "$remoteVideoSurface");
        AbstractC13042fc3.i(m26, "it");
        return m26.a((32735 & 1) != 0 ? m26.a : false, (32735 & 2) != 0 ? m26.b : z, (32735 & 4) != 0 ? m26.c : true, (32735 & 8) != 0 ? m26.d : false, (32735 & 16) != 0 ? m26.e : null, (32735 & 32) != 0 ? m26.f : null, (32735 & 64) != 0 ? m26.g : null, (32735 & 128) != 0 ? m26.h : C24964zV7.a.a(bVar), (32735 & 256) != 0 ? m26.i : null, (32735 & 512) != 0 ? m26.j : false, (32735 & 1024) != 0 ? m26.k : null, (32735 & 2048) != 0 ? m26.l : null, (32735 & 4096) != 0 ? m26.m : null, (32735 & 8192) != 0 ? m26.n : null, (32735 & 16384) != 0 ? m26.o : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(C15815kD3 c15815kD3, boolean z, boolean z2, boolean z3, MeetOuterClass$ResponseJoinGroupCall meetOuterClass$ResponseJoinGroupCall) {
        AbstractC13042fc3.i(c15815kD3, "this$0");
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
        c15815kD3.u = meetOuterClass$ResponseJoinGroupCall.getGroupCall().getUrl().getText();
        c15815kD3.v = meetOuterClass$ResponseJoinGroupCall.getGroupCall().getToken();
        c15815kD3.c.c(new C22376v78(arrayList2));
        String text = meetOuterClass$ResponseJoinGroupCall.getGroupCall().getUrl().getText();
        AbstractC13042fc3.h(text, "getText(...)");
        String token = meetOuterClass$ResponseJoinGroupCall.getGroupCall().getToken();
        AbstractC13042fc3.h(token, "getToken(...)");
        j0(c15815kD3, text, token, z, z2, false, z3, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(C15815kD3 c15815kD3, Exception exc) {
        AbstractC13042fc3.i(c15815kD3, "this$0");
        Y08 y08 = c15815kD3.c;
        AbstractC13042fc3.f(exc);
        y08.d(exc);
    }

    private final InterfaceC13730gj3 x0() {
        return AbstractC10533bm0.d(this.e, null, null, new p(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0() {
        AbstractC10533bm0.d(this.e, null, null, new q(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0() {
        AbstractC10533bm0.d(this.e, null, null, new r(null), 3, null);
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void a(Intent intent) {
        AbstractC13042fc3.i(intent, "mediaProjectionPermissionResultData");
        AbstractC10533bm0.d(this.e, C12366eV1.c(), null, new u(n0().B0(), intent, null), 2, null);
    }

    @Override // ir.nasim.C08
    public void b(long j2, boolean z) {
        h0();
        this.a.P(j2, z);
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void c(BV7 bv7) {
        AbstractC13042fc3.i(bv7, "videoSwitchCallback");
        this.i = bv7;
    }

    @Override // ir.nasim.C08
    public void d(List list) {
        AbstractC13042fc3.i(list, "peers");
        this.a.Y(list).m0(new InterfaceC24449ye1() { // from class: ir.nasim.dD3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C15815kD3.H0(this.a, (MeetOuterClass$ResponseStartGroupCall) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.eD3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C15815kD3.I0(this.a, (Exception) obj);
            }
        });
    }

    @Override // ir.nasim.C08
    public void e(long j2, K04 k04) {
        AbstractC13042fc3.i(k04, "reason");
        h0();
        this.a.H(j2, k04);
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void f(boolean z) {
        InterfaceC13730gj3 interfaceC13730gj3 = this.p;
        if (interfaceC13730gj3 == null || interfaceC13730gj3.p()) {
            this.p = AbstractC10533bm0.d(this.e, null, null, new n(z, null), 3, null);
        }
    }

    @Override // ir.nasim.C08
    public void h(boolean z) {
        AbstractC10533bm0.d(this.e, null, null, new m(z, this, null), 3, null);
    }

    @Override // ir.nasim.C08
    public void i(long j2, String str, final boolean z, final boolean z2, final boolean z3) {
        AbstractC13042fc3.i(str, "myName");
        this.a.O(j2, str).m0(new InterfaceC24449ye1() { // from class: ir.nasim.bD3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C15815kD3.u0(this.a, z, z2, z3, (MeetOuterClass$ResponseJoinGroupCall) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.cD3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C15815kD3.v0(this.a, (Exception) obj);
            }
        });
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void j(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        C0(c11458d25, true);
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
            j0(this, str3, str2, false, false, false, false, 60, null);
        }
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void l() {
        AbstractC10533bm0.d(this.e, null, null, new k(null), 3, null);
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void m() {
        AbstractC10533bm0.d(this.e, C12366eV1.c(), null, new v(n0().B0(), null), 2, null);
    }

    @Override // ir.nasim.InterfaceC24937zS7
    public void n() {
        C23060wH3 c23060wH3;
        InterfaceC13730gj3 interfaceC13730gj3 = this.o;
        if (interfaceC13730gj3 == null || interfaceC13730gj3.p()) {
            List listS = n0().B0().s();
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
            this.o = AbstractC10533bm0.d(this.e, null, null, new f(c22464vH3, c23060wH3.e(), this, null), 3, null);
        }
    }

    @Override // ir.nasim.C08
    public void o(long j2) {
        this.a.D(j2).m0(new InterfaceC24449ye1() { // from class: ir.nasim.jD3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C15815kD3.D(this.a, (MeetOuterClass$ResponseCall) obj);
            }
        });
    }

    @Override // ir.nasim.C08
    public void onDestroy() {
        h0();
        this.u = null;
        this.v = null;
    }

    @Override // ir.nasim.C08
    public void p(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        C0(c11458d25, false);
    }

    @Override // ir.nasim.C08
    public void q(long j2) {
        this.a.R(j2);
    }

    public final InterfaceC13730gj3 w0() {
        return AbstractC10533bm0.d(this.e, null, null, new o(null), 3, null);
    }
}
