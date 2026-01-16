package io.livekit.android.room.participant;

import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import io.livekit.android.events.RoomEvent;
import io.livekit.android.room.participant.c;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10404bZ0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC21649tt7;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC24042xw5;
import ir.nasim.AbstractC25199zt7;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC4838Gt7;
import ir.nasim.AbstractC5474Jm4;
import ir.nasim.AbstractC5508Jq2;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C10874cL6;
import ir.nasim.C19938rB7;
import ir.nasim.C25226zw5;
import ir.nasim.C5942Lm4;
import ir.nasim.C9080Yk0;
import ir.nasim.C9927an4;
import ir.nasim.ED1;
import ir.nasim.EnumC22663vd1;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16587lX4;
import ir.nasim.InterfaceC16863lz6;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC5932Ll3;
import ir.nasim.InterfaceC7983Ua2;
import ir.nasim.ON3;
import ir.nasim.P17;
import ir.nasim.SA2;
import ir.nasim.XV4;
import ir.nasim.ZW4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.serialization.KSerializer;
import livekit.LivekitModels$ParticipantInfo;
import livekit.LivekitModels$ParticipantPermission;

/* loaded from: classes3.dex */
public abstract class Participant {
    static final /* synthetic */ InterfaceC5239Im3[] z = {AbstractC10882cM5.f(new C5942Lm4(Participant.class, "participantInfo", "getParticipantInfo()Llivekit/LivekitModels$ParticipantInfo;", 0)), AbstractC10882cM5.f(new C5942Lm4(Participant.class, "identity", "getIdentity-4WamZwg()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(Participant.class, "state", "getState()Lio/livekit/android/room/participant/Participant$State;", 0)), AbstractC10882cM5.f(new C5942Lm4(Participant.class, "audioLevel", "getAudioLevel()F", 0)), AbstractC10882cM5.f(new C5942Lm4(Participant.class, "isSpeaking", "isSpeaking()Z", 0)), AbstractC10882cM5.f(new C5942Lm4(Participant.class, "name", "getName()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(Participant.class, "metadata", "getMetadata()Ljava/lang/String;", 0)), AbstractC10882cM5.f(new C5942Lm4(Participant.class, "attributes", "getAttributes()Ljava/util/Map;", 0)), AbstractC10882cM5.f(new C5942Lm4(Participant.class, "permissions", "getPermissions()Lio/livekit/android/room/participant/ParticipantPermission;", 0)), AbstractC10882cM5.f(new C5942Lm4(Participant.class, "connectionQuality", "getConnectionQuality()Lio/livekit/android/room/participant/ConnectionQuality;", 0)), AbstractC10882cM5.f(new C5942Lm4(Participant.class, "lastSpokeAt", "getLastSpokeAt()Ljava/lang/Long;", 0)), AbstractC10882cM5.f(new C5942Lm4(Participant.class, "kind", "getKind()Lio/livekit/android/room/participant/Participant$Kind;", 0)), AbstractC10882cM5.f(new C5942Lm4(Participant.class, "trackPublications", "getTrackPublications()Ljava/util/Map;", 0)), AbstractC10882cM5.i(new C25226zw5(Participant.class, "audioTrackPublications", "getAudioTrackPublications()Ljava/util/List;", 0)), AbstractC10882cM5.i(new C25226zw5(Participant.class, "videoTrackPublications", "getVideoTrackPublications()Ljava/util/List;", 0)), AbstractC10882cM5.i(new C25226zw5(Participant.class, "isMicrophoneEnabled", "isMicrophoneEnabled()Z", 0)), AbstractC10882cM5.i(new C25226zw5(Participant.class, "isCameraEnabled", "isCameraEnabled()Z", 0)), AbstractC10882cM5.i(new C25226zw5(Participant.class, "isScreenShareEnabled", "isScreenShareEnabled()Z", 0))};
    private String a;
    private final AbstractC13778go1 b;
    private final InterfaceC20315ro1 c;
    private InterfaceC20315ro1 d;
    private final C9080Yk0 e;
    private final InterfaceC7983Ua2 f;
    private final C9927an4 g;
    private final C9927an4 h;
    private final C9927an4 i;
    private final C9927an4 j;
    private final C9927an4 k;
    private final C9927an4 l;
    private final C9927an4 m;
    private final C9927an4 n;
    private final C9927an4 o;
    private final C9927an4 p;
    private final C9927an4 q;
    private final C9927an4 r;
    private InterfaceC16587lX4 s;
    private final C9927an4 t;
    private final C10874cL6 u;
    private final C10874cL6 v;
    private final C10874cL6 w;
    private final C10874cL6 x;
    private final C10874cL6 y;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00122\u00020\u0001:\u0002\u0013\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0014"}, d2 = {"Lio/livekit/android/room/participant/Participant$Identity;", "", "", "value", "b", "(Ljava/lang/String;)Ljava/lang/String;", "f", "", "e", "(Ljava/lang/String;)I", "other", "", "c", "(Ljava/lang/String;Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "$serializer", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    @InterfaceC5932Ll3
    public static final class Identity {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: from kotlin metadata */
        private final String value;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lio/livekit/android/room/participant/Participant$Identity$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/livekit/android/room/participant/Participant$Identity;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer serializer() {
                return Participant$Identity$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        private /* synthetic */ Identity(String str) {
            this.value = str;
        }

        public static final /* synthetic */ Identity a(String str) {
            return new Identity(str);
        }

        public static String b(String str) {
            AbstractC13042fc3.i(str, "value");
            return str;
        }

        public static boolean c(String str, Object obj) {
            return (obj instanceof Identity) && AbstractC13042fc3.d(str, ((Identity) obj).getValue());
        }

        public static final boolean d(String str, String str2) {
            return AbstractC13042fc3.d(str, str2);
        }

        public static int e(String str) {
            return str.hashCode();
        }

        public static String f(String str) {
            return "Identity(value=" + str + ')';
        }

        public boolean equals(Object obj) {
            return c(this.value, obj);
        }

        /* renamed from: g, reason: from getter */
        public final /* synthetic */ String getValue() {
            return this.value;
        }

        public int hashCode() {
            return e(this.value);
        }

        public String toString() {
            return f(this.value);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 \u00122\u00020\u0001:\u0002\u0013\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0014"}, d2 = {"Lio/livekit/android/room/participant/Participant$Sid;", "", "", "value", "b", "(Ljava/lang/String;)Ljava/lang/String;", "f", "", "e", "(Ljava/lang/String;)I", "other", "", "c", "(Ljava/lang/String;Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "$serializer", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
    @InterfaceC5932Ll3
    public static final class Sid {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: from kotlin metadata */
        private final String value;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lio/livekit/android/room/participant/Participant$Sid$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/livekit/android/room/participant/Participant$Sid;", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer serializer() {
                return Participant$Sid$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        private /* synthetic */ Sid(String str) {
            this.value = str;
        }

        public static final /* synthetic */ Sid a(String str) {
            return new Sid(str);
        }

        public static String b(String str) {
            AbstractC13042fc3.i(str, "value");
            return str;
        }

        public static boolean c(String str, Object obj) {
            return (obj instanceof Sid) && AbstractC13042fc3.d(str, ((Sid) obj).getValue());
        }

        public static final boolean d(String str, String str2) {
            return AbstractC13042fc3.d(str, str2);
        }

        public static int e(String str) {
            return str.hashCode();
        }

        public static String f(String str) {
            return "Sid(value=" + str + ')';
        }

        public boolean equals(Object obj) {
            return c(this.value, obj);
        }

        /* renamed from: g, reason: from getter */
        public final /* synthetic */ String getValue() {
            return this.value;
        }

        public int hashCode() {
            return e(this.value);
        }

        public String toString() {
            return f(this.value);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {
        public static final C0214a Companion;
        public static final a a = new a("AGENT", 0);
        public static final a b = new a("STANDARD", 1);
        public static final a c = new a("INGRESS", 2);
        public static final a d = new a("EGRESS", 3);
        public static final a e = new a("SIP", 4);
        public static final a f = new a("UNKNOWN", 5);
        private static final /* synthetic */ a[] g;
        private static final /* synthetic */ F92 h;

        /* renamed from: io.livekit.android.room.participant.Participant$a$a, reason: collision with other inner class name */
        public static final class C0214a {

            /* renamed from: io.livekit.android.room.participant.Participant$a$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0215a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[LivekitModels$ParticipantInfo.d.values().length];
                    try {
                        iArr[LivekitModels$ParticipantInfo.d.AGENT.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LivekitModels$ParticipantInfo.d.STANDARD.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[LivekitModels$ParticipantInfo.d.INGRESS.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[LivekitModels$ParticipantInfo.d.EGRESS.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[LivekitModels$ParticipantInfo.d.SIP.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[LivekitModels$ParticipantInfo.d.UNRECOGNIZED.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    a = iArr;
                }
            }

            private C0214a() {
            }

            public final a a(LivekitModels$ParticipantInfo.d dVar) {
                AbstractC13042fc3.i(dVar, "proto");
                switch (C0215a.a[dVar.ordinal()]) {
                    case 1:
                        return a.a;
                    case 2:
                        return a.b;
                    case 3:
                        return a.c;
                    case 4:
                        return a.d;
                    case 5:
                        return a.e;
                    case 6:
                        return a.f;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }

            public /* synthetic */ C0214a(ED1 ed1) {
                this();
            }
        }

        static {
            a[] aVarArrA = a();
            g = aVarArrA;
            h = G92.a(aVarArrA);
            Companion = new C0214a(null);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c, d, e, f};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) g.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class b {
        public static final a Companion;
        public static final b a = new b("JOINING", 0);
        public static final b b = new b("JOINED", 1);
        public static final b c = new b("ACTIVE", 2);
        public static final b d = new b("DISCONNECTED", 3);
        public static final b e = new b("UNKNOWN", 4);
        private static final /* synthetic */ b[] f;
        private static final /* synthetic */ F92 g;

        public static final class a {

            /* renamed from: io.livekit.android.room.participant.Participant$b$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0216a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[LivekitModels$ParticipantInfo.f.values().length];
                    try {
                        iArr[LivekitModels$ParticipantInfo.f.JOINING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LivekitModels$ParticipantInfo.f.JOINED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[LivekitModels$ParticipantInfo.f.ACTIVE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[LivekitModels$ParticipantInfo.f.DISCONNECTED.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[LivekitModels$ParticipantInfo.f.UNRECOGNIZED.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    a = iArr;
                }
            }

            private a() {
            }

            public final b a(LivekitModels$ParticipantInfo.f fVar) {
                AbstractC13042fc3.i(fVar, "proto");
                int i = C0216a.a[fVar.ordinal()];
                if (i == 1) {
                    return b.a;
                }
                if (i == 2) {
                    return b.b;
                }
                if (i == 3) {
                    return b.c;
                }
                if (i == 4) {
                    return b.d;
                }
                if (i == 5) {
                    return b.e;
                }
                throw new NoWhenBranchMatchedException();
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        static {
            b[] bVarArrA = a();
            f = bVarArrA;
            g = G92.a(bVarArrA);
            Companion = new a(null);
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

    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        c() {
            super(2);
        }

        public final void a(Map map, Map map2) {
            AbstractC13042fc3.i(map, "newAttributes");
            AbstractC13042fc3.i(map2, "oldAttributes");
            if (AbstractC13042fc3.d(map, map2)) {
                return;
            }
            Map mapA = ON3.a(map, map2, "");
            if (!mapA.isEmpty()) {
                Participant.this.f().b(new ZW4.a(Participant.this, mapA, map2), Participant.this.n());
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((Map) obj, (Map) obj2);
            return C19938rB7.a;
        }
    }

    static final class h extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        h() {
            super(2);
        }

        public final void a(boolean z, boolean z2) {
            if (z != z2) {
                InterfaceC16587lX4 interfaceC16587lX4I = Participant.this.i();
                if (interfaceC16587lX4I != null) {
                    interfaceC16587lX4I.q(Participant.this);
                }
                Participant.this.f().b(new ZW4.j(Participant.this, z), Participant.this.n());
                if (z) {
                    Participant.this.H(Long.valueOf(new Date().getTime()));
                }
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
            return C19938rB7.a;
        }
    }

    public static final class i extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;

        public i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                XV4 xv4 = (XV4) this.d;
                AbstractC4838Gt7 abstractC4838Gt7 = (AbstractC4838Gt7) xv4.a();
                AbstractC21649tt7 abstractC21649tt7 = (AbstractC21649tt7) xv4.b();
                InterfaceC4557Fq2 interfaceC4557Fq2T = abstractC4838Gt7 == null ? AbstractC6459Nq2.T(AbstractC4616Fw7.a(AbstractC6392Nk0.a(false), abstractC21649tt7)) : new l(AbstractC5508Jq2.e(new AbstractC5474Jm4(abstractC4838Gt7) { // from class: io.livekit.android.room.participant.Participant.k
                    @Override // ir.nasim.InterfaceC3820Cm3
                    public Object get() {
                        return Boolean.valueOf(((AbstractC4838Gt7) this.receiver).b());
                    }
                }), abstractC21649tt7);
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2T, this) == objE) {
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

    public static final class j implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: io.livekit.android.room.participant.Participant$j$a$a, reason: collision with other inner class name */
            public static final class C0217a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0217a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof io.livekit.android.room.participant.Participant.j.a.C0217a
                    if (r0 == 0) goto L13
                    r0 = r6
                    io.livekit.android.room.participant.Participant$j$a$a r0 = (io.livekit.android.room.participant.Participant.j.a.C0217a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    io.livekit.android.room.participant.Participant$j$a$a r0 = new io.livekit.android.room.participant.Participant$j$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L5c
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.XV4 r5 = (ir.nasim.XV4) r5
                    java.lang.Object r2 = r5.a()
                    java.lang.Boolean r2 = (java.lang.Boolean) r2
                    boolean r2 = r2.booleanValue()
                    java.lang.Object r5 = r5.b()
                    ir.nasim.tt7 r5 = (ir.nasim.AbstractC21649tt7) r5
                    if (r2 != 0) goto L4e
                    if (r5 == 0) goto L4e
                    r5 = r3
                    goto L4f
                L4e:
                    r5 = 0
                L4f:
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L5c
                    return r1
                L5c:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.Participant.j.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public j(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public static final class l implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ AbstractC21649tt7 b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ AbstractC21649tt7 b;

            /* renamed from: io.livekit.android.room.participant.Participant$l$a$a, reason: collision with other inner class name */
            public static final class C0218a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0218a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, AbstractC21649tt7 abstractC21649tt7) {
                this.a = interfaceC4806Gq2;
                this.b = abstractC21649tt7;
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
                    boolean r0 = r6 instanceof io.livekit.android.room.participant.Participant.l.a.C0218a
                    if (r0 == 0) goto L13
                    r0 = r6
                    io.livekit.android.room.participant.Participant$l$a$a r0 = (io.livekit.android.room.participant.Participant.l.a.C0218a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    io.livekit.android.room.participant.Participant$l$a$a r0 = new io.livekit.android.room.participant.Participant$l$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L4f
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    java.lang.Boolean r5 = (java.lang.Boolean) r5
                    boolean r5 = r5.booleanValue()
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    ir.nasim.tt7 r2 = r4.b
                    ir.nasim.XV4 r5 = ir.nasim.AbstractC4616Fw7.a(r5, r2)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L4f
                    return r1
                L4f:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.Participant.l.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public l(InterfaceC4557Fq2 interfaceC4557Fq2, AbstractC21649tt7 abstractC21649tt7) {
            this.a = interfaceC4557Fq2;
            this.b = abstractC21649tt7;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static final class m extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        m() {
            super(2);
        }

        public final void a(String str, String str2) {
            if (AbstractC13042fc3.d(str, str2)) {
                return;
            }
            InterfaceC16587lX4 interfaceC16587lX4I = Participant.this.i();
            if (interfaceC16587lX4I != null) {
                interfaceC16587lX4I.v(Participant.this, str2);
            }
            Participant.this.f().b(new ZW4.g(Participant.this, str2), Participant.this.n());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((String) obj, (String) obj2);
            return C19938rB7.a;
        }
    }

    static final class n extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        n() {
            super(2);
        }

        public final void a(String str, String str2) {
            if (AbstractC13042fc3.d(str, str2)) {
                return;
            }
            Participant.this.f().b(new ZW4.h(Participant.this, str), Participant.this.n());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((String) obj, (String) obj2);
            return C19938rB7.a;
        }
    }

    static final class o extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        o() {
            super(2);
        }

        public final void a(io.livekit.android.room.participant.c cVar, io.livekit.android.room.participant.c cVar2) {
            if (AbstractC13042fc3.d(cVar, cVar2)) {
                return;
            }
            Participant.this.f().b(new ZW4.i(Participant.this, cVar, cVar2), Participant.this.n());
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((io.livekit.android.room.participant.c) obj, (io.livekit.android.room.participant.c) obj2);
            return C19938rB7.a;
        }
    }

    public static final class p implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: io.livekit.android.room.participant.Participant$p$a$a, reason: collision with other inner class name */
            public static final class C0219a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0219a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof io.livekit.android.room.participant.Participant.p.a.C0219a
                    if (r0 == 0) goto L13
                    r0 = r9
                    io.livekit.android.room.participant.Participant$p$a$a r0 = (io.livekit.android.room.participant.Participant.p.a.C0219a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    io.livekit.android.room.participant.Participant$p$a$a r0 = new io.livekit.android.room.participant.Participant$p$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L74
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.util.Map r8 = (java.util.Map) r8
                    java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
                    r2.<init>()
                    java.util.Set r8 = r8.entrySet()
                    java.util.Iterator r8 = r8.iterator()
                L45:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L6b
                    java.lang.Object r4 = r8.next()
                    java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                    java.lang.Object r5 = r4.getValue()
                    ir.nasim.Gt7 r5 = (ir.nasim.AbstractC4838Gt7) r5
                    ir.nasim.tt7$f r5 = r5.a()
                    ir.nasim.tt7$f r6 = ir.nasim.AbstractC21649tt7.f.b
                    if (r5 != r6) goto L45
                    java.lang.Object r5 = r4.getKey()
                    java.lang.Object r4 = r4.getValue()
                    r2.put(r5, r4)
                    goto L45
                L6b:
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r2, r0)
                    if (r8 != r1) goto L74
                    return r1
                L74:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.Participant.p.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public p(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public static final class q implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: io.livekit.android.room.participant.Participant$q$a$a, reason: collision with other inner class name */
            public static final class C0220a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0220a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof io.livekit.android.room.participant.Participant.q.a.C0220a
                    if (r0 == 0) goto L13
                    r0 = r9
                    io.livekit.android.room.participant.Participant$q$a$a r0 = (io.livekit.android.room.participant.Participant.q.a.C0220a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    io.livekit.android.room.participant.Participant$q$a$a r0 = new io.livekit.android.room.participant.Participant$q$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L74
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.util.Map r8 = (java.util.Map) r8
                    java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
                    r2.<init>()
                    java.util.Set r8 = r8.entrySet()
                    java.util.Iterator r8 = r8.iterator()
                L45:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L6b
                    java.lang.Object r4 = r8.next()
                    java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                    java.lang.Object r5 = r4.getValue()
                    ir.nasim.Gt7 r5 = (ir.nasim.AbstractC4838Gt7) r5
                    ir.nasim.tt7$f r5 = r5.a()
                    ir.nasim.tt7$f r6 = ir.nasim.AbstractC21649tt7.f.c
                    if (r5 != r6) goto L45
                    java.lang.Object r5 = r4.getKey()
                    java.lang.Object r4 = r4.getValue()
                    r2.put(r5, r4)
                    goto L45
                L6b:
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r2, r0)
                    if (r8 != r1) goto L74
                    return r1
                L74:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.Participant.q.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public q(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public static final class r implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: io.livekit.android.room.participant.Participant$r$a$a, reason: collision with other inner class name */
            public static final class C0221a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0221a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof io.livekit.android.room.participant.Participant.r.a.C0221a
                    if (r0 == 0) goto L13
                    r0 = r9
                    io.livekit.android.room.participant.Participant$r$a$a r0 = (io.livekit.android.room.participant.Participant.r.a.C0221a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    io.livekit.android.room.participant.Participant$r$a$a r0 = new io.livekit.android.room.participant.Participant$r$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L6d
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.util.List r8 = (java.util.List) r8
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    java.util.Iterator r8 = r8.iterator()
                L3e:
                    boolean r2 = r8.hasNext()
                    r4 = 0
                    if (r2 == 0) goto L5b
                    java.lang.Object r2 = r8.next()
                    r5 = r2
                    ir.nasim.XV4 r5 = (ir.nasim.XV4) r5
                    java.lang.Object r5 = r5.a()
                    ir.nasim.Gt7 r5 = (ir.nasim.AbstractC4838Gt7) r5
                    ir.nasim.tt7$g r5 = r5.f()
                    ir.nasim.tt7$g r6 = ir.nasim.AbstractC21649tt7.g.c
                    if (r5 != r6) goto L3e
                    goto L5c
                L5b:
                    r2 = r4
                L5c:
                    ir.nasim.XV4 r2 = (ir.nasim.XV4) r2
                    if (r2 != 0) goto L64
                    ir.nasim.XV4 r2 = ir.nasim.AbstractC4616Fw7.a(r4, r4)
                L64:
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r2, r0)
                    if (r8 != r1) goto L6d
                    return r1
                L6d:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.Participant.r.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public r(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public static final class s implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: io.livekit.android.room.participant.Participant$s$a$a, reason: collision with other inner class name */
            public static final class C0222a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0222a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof io.livekit.android.room.participant.Participant.s.a.C0222a
                    if (r0 == 0) goto L13
                    r0 = r9
                    io.livekit.android.room.participant.Participant$s$a$a r0 = (io.livekit.android.room.participant.Participant.s.a.C0222a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    io.livekit.android.room.participant.Participant$s$a$a r0 = new io.livekit.android.room.participant.Participant$s$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L6d
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.util.List r8 = (java.util.List) r8
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    java.util.Iterator r8 = r8.iterator()
                L3e:
                    boolean r2 = r8.hasNext()
                    r4 = 0
                    if (r2 == 0) goto L5b
                    java.lang.Object r2 = r8.next()
                    r5 = r2
                    ir.nasim.XV4 r5 = (ir.nasim.XV4) r5
                    java.lang.Object r5 = r5.a()
                    ir.nasim.Gt7 r5 = (ir.nasim.AbstractC4838Gt7) r5
                    ir.nasim.tt7$g r5 = r5.f()
                    ir.nasim.tt7$g r6 = ir.nasim.AbstractC21649tt7.g.b
                    if (r5 != r6) goto L3e
                    goto L5c
                L5b:
                    r2 = r4
                L5c:
                    ir.nasim.XV4 r2 = (ir.nasim.XV4) r2
                    if (r2 != 0) goto L64
                    ir.nasim.XV4 r2 = ir.nasim.AbstractC4616Fw7.a(r4, r4)
                L64:
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r2, r0)
                    if (r8 != r1) goto L6d
                    return r1
                L6d:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.Participant.s.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public s(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public static final class t implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: io.livekit.android.room.participant.Participant$t$a$a, reason: collision with other inner class name */
            public static final class C0223a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0223a(InterfaceC20295rm1 interfaceC20295rm1) {
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
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof io.livekit.android.room.participant.Participant.t.a.C0223a
                    if (r0 == 0) goto L13
                    r0 = r9
                    io.livekit.android.room.participant.Participant$t$a$a r0 = (io.livekit.android.room.participant.Participant.t.a.C0223a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    io.livekit.android.room.participant.Participant$t$a$a r0 = new io.livekit.android.room.participant.Participant$t$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L6d
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.util.List r8 = (java.util.List) r8
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    java.util.Iterator r8 = r8.iterator()
                L3e:
                    boolean r2 = r8.hasNext()
                    r4 = 0
                    if (r2 == 0) goto L5b
                    java.lang.Object r2 = r8.next()
                    r5 = r2
                    ir.nasim.XV4 r5 = (ir.nasim.XV4) r5
                    java.lang.Object r5 = r5.a()
                    ir.nasim.Gt7 r5 = (ir.nasim.AbstractC4838Gt7) r5
                    ir.nasim.tt7$g r5 = r5.f()
                    ir.nasim.tt7$g r6 = ir.nasim.AbstractC21649tt7.g.d
                    if (r5 != r6) goto L3e
                    goto L5c
                L5b:
                    r2 = r4
                L5c:
                    ir.nasim.XV4 r2 = (ir.nasim.XV4) r2
                    if (r2 != 0) goto L64
                    ir.nasim.XV4 r2 = ir.nasim.AbstractC4616Fw7.a(r4, r4)
                L64:
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r2, r0)
                    if (r8 != r1) goto L6d
                    return r1
                L6d:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.Participant.t.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public t(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static final class u extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        u() {
            super(2);
        }

        public final void a(b bVar, b bVar2) {
            AbstractC13042fc3.i(bVar, "newState");
            AbstractC13042fc3.i(bVar2, "oldState");
            if (bVar != bVar2) {
                Participant.this.f().b(new ZW4.k(Participant.this, bVar, bVar2), Participant.this.n());
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((b) obj, (b) obj2);
            return C19938rB7.a;
        }
    }

    public static final class v extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;

        public v(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4557Fq2 xVar;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                Map map = (Map) this.d;
                if (map.isEmpty()) {
                    xVar = AbstractC6459Nq2.T(AbstractC10360bX0.m());
                } else {
                    Collection<AbstractC4838Gt7> collectionValues = map.values();
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collectionValues, 10));
                    for (AbstractC4838Gt7 abstractC4838Gt7 : collectionValues) {
                        arrayList.add(new y(AbstractC5508Jq2.e(new AbstractC5474Jm4(abstractC4838Gt7) { // from class: io.livekit.android.room.participant.Participant.w
                            @Override // ir.nasim.InterfaceC3820Cm3
                            public Object get() {
                                return ((AbstractC4838Gt7) this.receiver).h();
                            }
                        }), abstractC4838Gt7));
                    }
                    Object[] array = AbstractC15401jX0.m1(arrayList).toArray(new InterfaceC4557Fq2[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    }
                    xVar = new x((InterfaceC4557Fq2[]) array);
                }
                this.b = 1;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, xVar, this) == objE) {
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
            v vVar = new v(interfaceC20295rm1);
            vVar.c = interfaceC4806Gq2;
            vVar.d = obj;
            return vVar.invokeSuspend(C19938rB7.a);
        }
    }

    public static final class x implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2[] a;

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
                return new XV4[this.e.length];
            }
        }

        public static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;

            public b(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    List listF1 = AbstractC10242bK.f1((XV4[]) ((Object[]) this.d));
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
                b bVar = new b(interfaceC20295rm1);
                bVar.c = interfaceC4806Gq2;
                bVar.d = objArr;
                return bVar.invokeSuspend(C19938rB7.a);
            }
        }

        public x(InterfaceC4557Fq2[] interfaceC4557Fq2Arr) {
            this.a = interfaceC4557Fq2Arr;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            InterfaceC4557Fq2[] interfaceC4557Fq2Arr = this.a;
            Object objA = AbstractC10404bZ0.a(interfaceC4806Gq2, interfaceC4557Fq2Arr, new a(interfaceC4557Fq2Arr), new b(null), interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
    }

    public static final class y implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ AbstractC4838Gt7 b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ AbstractC4838Gt7 b;

            /* renamed from: io.livekit.android.room.participant.Participant$y$a$a, reason: collision with other inner class name */
            public static final class C0224a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0224a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, AbstractC4838Gt7 abstractC4838Gt7) {
                this.a = interfaceC4806Gq2;
                this.b = abstractC4838Gt7;
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
                    boolean r0 = r6 instanceof io.livekit.android.room.participant.Participant.y.a.C0224a
                    if (r0 == 0) goto L13
                    r0 = r6
                    io.livekit.android.room.participant.Participant$y$a$a r0 = (io.livekit.android.room.participant.Participant.y.a.C0224a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    io.livekit.android.room.participant.Participant$y$a$a r0 = new io.livekit.android.room.participant.Participant$y$a$a
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
                    ir.nasim.tt7 r5 = (ir.nasim.AbstractC21649tt7) r5
                    ir.nasim.Gt7 r5 = r4.b
                    ir.nasim.tt7 r2 = r5.h()
                    ir.nasim.XV4 r5 = ir.nasim.AbstractC4616Fw7.a(r5, r2)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L4b
                    return r1
                L4b:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.Participant.y.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public y(InterfaceC4557Fq2 interfaceC4557Fq2, AbstractC4838Gt7 abstractC4838Gt7) {
            this.a = interfaceC4557Fq2;
            this.b = abstractC4838Gt7;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public /* synthetic */ Participant(String str, String str2, AbstractC13778go1 abstractC13778go1, ED1 ed1) {
        this(str, str2, abstractC13778go1);
    }

    private final void K(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        this.g.i(this, z[0], livekitModels$ParticipantInfo);
    }

    private final InterfaceC4557Fq2 P(InterfaceC4557Fq2 interfaceC4557Fq2) {
        return AbstractC6459Nq2.s0(interfaceC4557Fq2, new v(null));
    }

    private final InterfaceC20315ro1 b() {
        return AbstractC20906so1.a(this.b.X(P17.b(null, 1, null)));
    }

    private final InterfaceC4557Fq2 v(InterfaceC4557Fq2 interfaceC4557Fq2) {
        return new j(AbstractC6459Nq2.s0(interfaceC4557Fq2, new i(null)));
    }

    public final void A() {
        if (AbstractC20906so1.g(this.d)) {
            return;
        }
        this.d = b();
    }

    public final void B(Map map) {
        AbstractC13042fc3.i(map, "<set-?>");
        this.n.i(this, z[7], map);
    }

    public final void C(float f2) {
        this.j.i(this, z[3], Float.valueOf(f2));
    }

    public final void D(EnumC22663vd1 enumC22663vd1) {
        AbstractC13042fc3.i(enumC22663vd1, "<set-?>");
        this.p.i(this, z[9], enumC22663vd1);
    }

    public final void E(String str) {
        this.h.i(this, z[1], str != null ? Identity.a(str) : null);
    }

    public final void F(InterfaceC16587lX4 interfaceC16587lX4) {
        this.s = interfaceC16587lX4;
    }

    public final void G(a aVar) {
        AbstractC13042fc3.i(aVar, "<set-?>");
        this.r.i(this, z[11], aVar);
    }

    public final void H(Long l2) {
        this.q.i(this, z[10], l2);
    }

    public final void I(String str) {
        this.m.i(this, z[6], str);
    }

    public final void J(String str) {
        this.l.i(this, z[5], str);
    }

    public final void L(io.livekit.android.room.participant.c cVar) {
        this.o.i(this, z[8], cVar);
    }

    public final void M(boolean z2) {
        this.k.i(this, z[4], Boolean.valueOf(z2));
    }

    public final void N(b bVar) {
        AbstractC13042fc3.i(bVar, "<set-?>");
        this.i.i(this, z[2], bVar);
    }

    protected final void O(Map map) {
        AbstractC13042fc3.i(map, "<set-?>");
        this.t.i(this, z[12], map);
    }

    public void Q(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        AbstractC13042fc3.i(livekitModels$ParticipantInfo, ParameterNames.INFO);
        String sid = livekitModels$ParticipantInfo.getSid();
        AbstractC13042fc3.h(sid, "getSid(...)");
        this.a = Sid.b(sid);
        String identity = livekitModels$ParticipantInfo.getIdentity();
        AbstractC13042fc3.h(identity, "getIdentity(...)");
        E(Identity.b(identity));
        K(livekitModels$ParticipantInfo);
        I(livekitModels$ParticipantInfo.getMetadata());
        J(livekitModels$ParticipantInfo.getName());
        a.C0214a c0214a = a.Companion;
        LivekitModels$ParticipantInfo.d kind = livekitModels$ParticipantInfo.getKind();
        AbstractC13042fc3.h(kind, "getKind(...)");
        G(c0214a.a(kind));
        if (livekitModels$ParticipantInfo.hasPermission()) {
            c.a aVar = io.livekit.android.room.participant.c.Companion;
            LivekitModels$ParticipantPermission permission = livekitModels$ParticipantInfo.getPermission();
            AbstractC13042fc3.h(permission, "getPermission(...)");
            L(aVar.a(permission));
        }
        Map<String, String> attributesMap = livekitModels$ParticipantInfo.getAttributesMap();
        AbstractC13042fc3.h(attributesMap, "getAttributesMap(...)");
        B(attributesMap);
        b.a aVar2 = b.Companion;
        LivekitModels$ParticipantInfo.f state = livekitModels$ParticipantInfo.getState();
        AbstractC13042fc3.h(state, "getState(...)");
        N(aVar2.a(state));
    }

    public final void a(AbstractC4838Gt7 abstractC4838Gt7) {
        AbstractC13042fc3.i(abstractC4838Gt7, "publication");
        AbstractC21649tt7 abstractC21649tt7H = abstractC4838Gt7.h();
        if (abstractC21649tt7H != null) {
            abstractC21649tt7H.m(abstractC4838Gt7.e());
        }
        Map mapA = AbstractC20051rO3.A(r());
        mapA.put(abstractC4838Gt7.e(), abstractC4838Gt7);
        O(mapA);
    }

    public void c() {
        AbstractC20906so1.d(this.d, null, 1, null);
        this.a = Sid.b("");
        J(null);
        E(null);
        I(null);
        K(null);
        L(null);
        D(EnumC22663vd1.d);
    }

    public final float d() {
        return ((Number) this.j.h(this, z[3])).floatValue();
    }

    public final List e() {
        return (List) this.u.h(this, z[13]);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type io.livekit.android.room.participant.Participant");
        return Sid.d(this.a, ((Participant) obj).a);
    }

    protected final C9080Yk0 f() {
        return this.e;
    }

    public final InterfaceC7983Ua2 g() {
        return this.f;
    }

    public final String h() {
        Identity identity = (Identity) this.h.h(this, z[1]);
        if (identity != null) {
            return identity.getValue();
        }
        return null;
    }

    public int hashCode() {
        return Sid.e(this.a);
    }

    public final InterfaceC16587lX4 i() {
        return this.s;
    }

    public final Long j() {
        LivekitModels$ParticipantInfo livekitModels$ParticipantInfoL = l();
        if (livekitModels$ParticipantInfoL != null) {
            return Long.valueOf(livekitModels$ParticipantInfoL.getJoinedAt() * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
        }
        return null;
    }

    public final String k() {
        return (String) this.l.h(this, z[5]);
    }

    public final LivekitModels$ParticipantInfo l() {
        return (LivekitModels$ParticipantInfo) this.g.h(this, z[0]);
    }

    public final io.livekit.android.room.participant.c m() {
        return (io.livekit.android.room.participant.c) this.o.h(this, z[8]);
    }

    protected final InterfaceC20315ro1 n() {
        return this.d;
    }

    public final String o() {
        return this.a;
    }

    public final b p() {
        return (b) this.i.h(this, z[2]);
    }

    public AbstractC4838Gt7 q(AbstractC21649tt7.g gVar) {
        AbstractC13042fc3.i(gVar, "source");
        if (gVar == AbstractC21649tt7.g.a) {
            return null;
        }
        Iterator it = r().entrySet().iterator();
        while (it.hasNext()) {
            AbstractC4838Gt7 abstractC4838Gt7 = (AbstractC4838Gt7) ((Map.Entry) it.next()).getValue();
            if (abstractC4838Gt7.f() == gVar) {
                return abstractC4838Gt7;
            }
            if (abstractC4838Gt7.f() == AbstractC21649tt7.g.a) {
                if (gVar == AbstractC21649tt7.g.c && abstractC4838Gt7.a() == AbstractC21649tt7.f.b) {
                    return abstractC4838Gt7;
                }
                if (gVar == AbstractC21649tt7.g.b && abstractC4838Gt7.a() == AbstractC21649tt7.f.c && !AbstractC13042fc3.d(abstractC4838Gt7.c(), "screen")) {
                    return abstractC4838Gt7;
                }
                if (gVar == AbstractC21649tt7.g.d && abstractC4838Gt7.a() == AbstractC21649tt7.f.c && AbstractC13042fc3.d(abstractC4838Gt7.c(), "screen")) {
                    return abstractC4838Gt7;
                }
            }
        }
        return null;
    }

    public final Map r() {
        return (Map) this.t.h(this, z[12]);
    }

    public final List s() {
        return (List) this.v.h(this, z[14]);
    }

    public final boolean t() {
        return ((Boolean) this.x.h(this, z[16])).booleanValue();
    }

    public final boolean u() {
        return ((Boolean) this.k.h(this, z[4])).booleanValue();
    }

    public final void w(AbstractC4838Gt7 abstractC4838Gt7) {
        AbstractC13042fc3.i(abstractC4838Gt7, "trackPublication");
        InterfaceC16587lX4 interfaceC16587lX4 = this.s;
        if (interfaceC16587lX4 != null) {
            interfaceC16587lX4.B(abstractC4838Gt7, this);
        }
        this.e.b(new ZW4.l(this, abstractC4838Gt7), this.d);
    }

    public final void x(AbstractC25199zt7.a aVar) {
        AbstractC13042fc3.i(aVar, "trackEvent");
        AbstractC4838Gt7 abstractC4838Gt7 = (AbstractC4838Gt7) r().get(aVar.getTrack().i());
        if (abstractC4838Gt7 == null) {
            return;
        }
        this.e.b(new ZW4.n(this, abstractC4838Gt7, aVar.getStreamState()), this.d);
    }

    public final void y(AbstractC4838Gt7 abstractC4838Gt7) {
        AbstractC13042fc3.i(abstractC4838Gt7, "trackPublication");
        InterfaceC16587lX4 interfaceC16587lX4 = this.s;
        if (interfaceC16587lX4 != null) {
            interfaceC16587lX4.u(abstractC4838Gt7, this);
        }
        this.e.b(new ZW4.r(this, abstractC4838Gt7), this.d);
    }

    public final void z(RoomEvent.TranscriptionReceived transcriptionReceived) {
        AbstractC13042fc3.i(transcriptionReceived, "transcription");
        if (AbstractC13042fc3.d(transcriptionReceived.getParticipant(), this)) {
            this.e.b(new ZW4.u(this, transcriptionReceived.getTranscriptionSegments(), transcriptionReceived.getPublication()), this.d);
        }
    }

    private Participant(String str, String str2, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(str, "sid");
        AbstractC13042fc3.i(abstractC13778go1, "coroutineDispatcher");
        this.a = str;
        this.b = abstractC13778go1;
        InterfaceC20315ro1 interfaceC20315ro1B = b();
        this.c = interfaceC20315ro1B;
        this.d = b();
        C9080Yk0 c9080Yk0 = new C9080Yk0();
        this.e = c9080Yk0;
        this.f = c9080Yk0.e();
        this.g = AbstractC5508Jq2.c(null, null, 2, null);
        this.h = AbstractC5508Jq2.c(str2 != null ? Identity.a(str2) : null, null, 2, null);
        this.i = AbstractC5508Jq2.a(b.e, new u());
        this.j = AbstractC5508Jq2.c(Float.valueOf(0.0f), null, 2, null);
        Boolean bool = Boolean.FALSE;
        this.k = AbstractC5508Jq2.a(bool, new h());
        this.l = AbstractC5508Jq2.a(null, new n());
        this.m = AbstractC5508Jq2.a(null, new m());
        this.n = AbstractC5508Jq2.a(AbstractC20051rO3.k(), new c());
        this.o = AbstractC5508Jq2.a(null, new o());
        this.p = AbstractC5508Jq2.c(EnumC22663vd1.d, null, 2, null);
        this.q = AbstractC5508Jq2.c(null, null, 2, null);
        this.r = AbstractC5508Jq2.c(a.f, null, 2, null);
        this.t = AbstractC5508Jq2.c(AbstractC20051rO3.k(), null, 2, null);
        InterfaceC4557Fq2 interfaceC4557Fq2P = P(new p(AbstractC5508Jq2.e(new AbstractC24042xw5(this) { // from class: io.livekit.android.room.participant.Participant.d
            @Override // ir.nasim.InterfaceC3820Cm3
            public Object get() {
                return ((Participant) this.receiver).r();
            }
        })));
        InterfaceC16863lz6.a aVar = InterfaceC16863lz6.a;
        this.u = AbstractC5508Jq2.b(AbstractC6459Nq2.o0(interfaceC4557Fq2P, interfaceC20315ro1B, aVar.c(), AbstractC10360bX0.m()));
        this.v = AbstractC5508Jq2.b(AbstractC6459Nq2.o0(P(new q(AbstractC5508Jq2.e(new AbstractC24042xw5(this) { // from class: io.livekit.android.room.participant.Participant.z
            @Override // ir.nasim.InterfaceC3820Cm3
            public Object get() {
                return ((Participant) this.receiver).r();
            }
        }))), interfaceC20315ro1B, aVar.c(), AbstractC10360bX0.m()));
        this.w = AbstractC5508Jq2.b(AbstractC6459Nq2.o0(v(new r(AbstractC5508Jq2.e(new AbstractC24042xw5(this) { // from class: io.livekit.android.room.participant.Participant.f
            @Override // ir.nasim.InterfaceC3820Cm3
            public Object get() {
                return ((Participant) this.receiver).e();
            }
        }))), interfaceC20315ro1B, aVar.c(), bool));
        this.x = AbstractC5508Jq2.b(AbstractC6459Nq2.o0(v(new s(AbstractC5508Jq2.e(new AbstractC24042xw5(this) { // from class: io.livekit.android.room.participant.Participant.e
            @Override // ir.nasim.InterfaceC3820Cm3
            public Object get() {
                return ((Participant) this.receiver).s();
            }
        }))), interfaceC20315ro1B, aVar.c(), bool));
        this.y = AbstractC5508Jq2.b(AbstractC6459Nq2.o0(v(new t(AbstractC5508Jq2.e(new AbstractC24042xw5(this) { // from class: io.livekit.android.room.participant.Participant.g
            @Override // ir.nasim.InterfaceC3820Cm3
            public Object get() {
                return ((Participant) this.receiver).s();
            }
        }))), interfaceC20315ro1B, aVar.c(), bool));
    }
}
