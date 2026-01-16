package io.livekit.android.room.participant;

import android.content.Context;
import android.content.Intent;
import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.recyclerview.widget.RecyclerView;
import io.livekit.android.room.participant.Participant;
import io.livekit.android.room.track.TrackException;
import io.livekit.android.rpc.RpcError;
import ir.nasim.AS7;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC12743f76;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14812iX0;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC18050o01;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC19460qO3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC20899sn4;
import ir.nasim.AbstractC21649tt7;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC24042xw5;
import ir.nasim.AbstractC4838Gt7;
import ir.nasim.AbstractC4846Gu6;
import ir.nasim.AbstractC5270Ip7;
import ir.nasim.AbstractC5508Jq2;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.C10186bD6;
import ir.nasim.C11540dA7;
import ir.nasim.C11599dH3;
import ir.nasim.C12158e82;
import ir.nasim.C12373eW;
import ir.nasim.C12889fL5;
import ir.nasim.C19938rB7;
import ir.nasim.C19977rG1;
import ir.nasim.C20597sH3;
import ir.nasim.C22464vH3;
import ir.nasim.C22668vd6;
import ir.nasim.C23060wH3;
import ir.nasim.C23718xP;
import ir.nasim.C24308yP;
import ir.nasim.C9475a16;
import ir.nasim.C9737aT7;
import ir.nasim.CS7;
import ir.nasim.EnumC10201bF3;
import ir.nasim.EnumC18040nz1;
import ir.nasim.EnumC24439yd1;
import ir.nasim.EnumC9607aF3;
import ir.nasim.F92;
import ir.nasim.FF5;
import ir.nasim.FV7;
import ir.nasim.GV7;
import ir.nasim.HG3;
import ir.nasim.IG3;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC16587lX4;
import ir.nasim.InterfaceC18336oU7;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC24823zG1;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC5306It7;
import ir.nasim.Q12;
import ir.nasim.SA2;
import ir.nasim.SM4;
import ir.nasim.T12;
import ir.nasim.UA2;
import ir.nasim.UI3;
import ir.nasim.W12;
import ir.nasim.XV4;
import ir.nasim.YG3;
import ir.nasim.ZW4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.KotlinNothingValueException;
import livekit.LivekitModels$Codec;
import livekit.LivekitModels$DataPacket;
import livekit.LivekitModels$ParticipantInfo;
import livekit.LivekitModels$RpcError;
import livekit.LivekitModels$RpcRequest;
import livekit.LivekitModels$RpcResponse;
import livekit.LivekitModels$TrackInfo;
import livekit.LivekitRtc$AddTrackRequest;
import livekit.LivekitRtc$SimulcastCodec;
import livekit.LivekitRtc$SubscribedCodec;
import livekit.LivekitRtc$SubscribedQuality;
import livekit.LivekitRtc$SubscribedQualityUpdate;
import livekit.LivekitRtc$TrackUnpublishedResponse;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.MediaStreamTrack;
import livekit.org.webrtc.PeerConnectionFactory;
import livekit.org.webrtc.RtpParameters;
import livekit.org.webrtc.RtpTransceiver;
import livekit.org.webrtc.VideoProcessor;

/* loaded from: classes3.dex */
public final class a extends Participant implements SM4 {
    private boolean A;
    private final io.livekit.android.room.f B;
    private final PeerConnectionFactory C;
    private final Context D;
    private final EglBase E;
    private final C11599dH3.c F;
    private final C22464vH3.b G;
    private final HG3.b H;
    private final C19977rG1 I;
    private final UA2 J;
    private final SM4 K;
    private List L;
    private final Map M;
    private final Map N;
    private final Map O;
    private final Map P;
    private final Map Q;
    private final List R;
    private HG3 S;
    private C22464vH3 T;

    /* renamed from: io.livekit.android.room.participant.a$a, reason: collision with other inner class name */
    public interface InterfaceC0225a {
        a a(boolean z);
    }

    public interface b {
        void a(AbstractC4838Gt7 abstractC4838Gt7);

        void b(Exception exc);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[AbstractC21649tt7.g.values().length];
            try {
                iArr[AbstractC21649tt7.g.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbstractC21649tt7.g.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AbstractC21649tt7.g.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC18040nz1.values().length];
            try {
                iArr2[EnumC18040nz1.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[EnumC18040nz1.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    public static final class d implements Comparator {
        final /* synthetic */ int a;

        public d(int i) {
            this.a = i;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Double.valueOf(a.f0(this.a, ((InterfaceC18336oU7) obj2).a())), Double.valueOf(a.f0(this.a, ((InterfaceC18336oU7) obj).a())));
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ LivekitModels$DataPacket d;
        final /* synthetic */ LivekitModels$RpcRequest e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(LivekitModels$DataPacket livekitModels$DataPacket, LivekitModels$RpcRequest livekitModels$RpcRequest, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = livekitModels$DataPacket;
            this.e = livekitModels$RpcRequest;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return a.this.new e(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                a aVar = a.this;
                String participantIdentity = this.d.getParticipantIdentity();
                AbstractC13042fc3.h(participantIdentity, "getParticipantIdentity(...)");
                String strB = Participant.Identity.b(participantIdentity);
                String id = this.e.getId();
                AbstractC13042fc3.h(id, "getId(...)");
                String method = this.e.getMethod();
                AbstractC13042fc3.h(method, "getMethod(...)");
                String payload = this.e.getPayload();
                AbstractC13042fc3.h(payload, "getPayload(...)");
                Q12.a aVar2 = Q12.b;
                long jT = T12.t(C11540dA7.h(this.e.getResponseTimeoutMs()) & 4294967295L, W12.d);
                int version = this.e.getVersion();
                this.b = 1;
                if (aVar.A0(strB, id, method, payload, jT, version, this) == objE) {
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
        Object c;
        Object d;
        Object e;
        long f;
        int g;
        /* synthetic */ Object h;
        int j;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= RecyclerView.UNDEFINED_DURATION;
            return a.this.A0(null, null, null, null, 0L, 0, this);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C22464vH3 e;
        final /* synthetic */ RtpTransceiver.RtpTransceiverInit f;
        final /* synthetic */ CS7 g;
        final /* synthetic */ AbstractC4838Gt7 h;
        final /* synthetic */ List i;
        final /* synthetic */ GV7 j;
        final /* synthetic */ C10186bD6 k;
        final /* synthetic */ GV7 l;

        /* renamed from: io.livekit.android.room.participant.a$g$a, reason: collision with other inner class name */
        static final class C0226a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ RtpTransceiver c;
            final /* synthetic */ GV7 d;
            final /* synthetic */ a e;
            final /* synthetic */ C10186bD6 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0226a(RtpTransceiver rtpTransceiver, GV7 gv7, a aVar, C10186bD6 c10186bD6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = rtpTransceiver;
                this.d = gv7;
                this.e = aVar;
                this.f = c10186bD6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0226a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC12743f76.a(this.c, this.d.f(), this.e.J);
                this.f.c(this.c.getSender());
                this.e.p0().E0();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0226a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ a c;
            final /* synthetic */ C10186bD6 d;
            final /* synthetic */ AbstractC4838Gt7 e;
            final /* synthetic */ GV7 f;
            final /* synthetic */ LivekitRtc$AddTrackRequest.b g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(a aVar, C10186bD6 c10186bD6, AbstractC4838Gt7 abstractC4838Gt7, GV7 gv7, LivekitRtc$AddTrackRequest.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = aVar;
                this.d = c10186bD6;
                this.e = abstractC4838Gt7;
                this.f = gv7;
                this.g = bVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    io.livekit.android.room.f fVarP0 = this.c.p0();
                    String strId = this.d.a().id();
                    AbstractC13042fc3.h(strId, "id(...)");
                    String strC = this.e.c();
                    EnumC10201bF3 enumC10201bF3J = this.e.a().j();
                    String strI = this.f.i();
                    LivekitRtc$AddTrackRequest.b bVar = this.g;
                    AbstractC13042fc3.h(bVar, "$trackRequest");
                    this.b = 1;
                    obj = fVarP0.i0(strId, strC, enumC10201bF3J, strI, bVar, this);
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
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C22464vH3 c22464vH3, RtpTransceiver.RtpTransceiverInit rtpTransceiverInit, CS7 cs7, AbstractC4838Gt7 abstractC4838Gt7, List list, GV7 gv7, C10186bD6 c10186bD6, GV7 gv72, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c22464vH3;
            this.f = rtpTransceiverInit;
            this.g = cs7;
            this.h = abstractC4838Gt7;
            this.i = list;
            this.j = gv7;
            this.k = c10186bD6;
            this.l = gv72;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = a.this.new g(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x014b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0162 A[Catch: Exception -> 0x001e, TryCatch #0 {Exception -> 0x001e, blocks: (B:7:0x0017, B:34:0x014c, B:36:0x0162, B:38:0x0168, B:31:0x0141), top: B:47:0x000f }] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 462
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.a.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        /* synthetic */ Object f;
        int h;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return a.this.K0(null, null, null, this);
        }
    }

    static final class i extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C24308yP e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C24308yP c24308yP) {
            super(1);
            this.e = c24308yP;
        }

        public final void a(LivekitRtc$AddTrackRequest.b bVar) {
            EnumC9607aF3 enumC9607aF3P;
            AbstractC13042fc3.i(bVar, "$this$publishTrackImpl");
            bVar.G(!this.e.b());
            bVar.H(!this.e.c());
            bVar.A(this.e.f());
            AbstractC21649tt7.g gVarG = this.e.g();
            if (gVarG == null || (enumC9607aF3P = gVarG.p()) == null) {
                enumC9607aF3P = EnumC9607aF3.MICROPHONE;
            }
            bVar.N(enumC9607aF3P);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((LivekitRtc$AddTrackRequest.b) obj);
            return C19938rB7.a;
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ HG3 c;
        final /* synthetic */ a d;
        final /* synthetic */ C12889fL5 e;
        final /* synthetic */ C24308yP f;

        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ a a;
            final /* synthetic */ C12889fL5 b;
            final /* synthetic */ C24308yP c;

            b(a aVar, C12889fL5 c12889fL5, C24308yP c24308yP) {
                this.a = aVar;
                this.b = c12889fL5;
                this.c = c24308yP;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(Set set, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.p0().U0(((C20597sH3) this.b.a).e(), AbstractC4846Gu6.l(set, this.c.f()));
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(HG3 hg3, a aVar, C12889fL5 c12889fL5, C24308yP c24308yP, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = hg3;
            this.d = aVar;
            this.e = c12889fL5;
            this.f = c24308yP;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new j(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6E = AbstractC5508Jq2.e(new AbstractC24042xw5(this.c) { // from class: io.livekit.android.room.participant.a.j.a
                    @Override // ir.nasim.InterfaceC3820Cm3
                    public Object get() {
                        return ((HG3) this.receiver).u();
                    }
                });
                b bVar = new b(this.d, this.e, this.f);
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
            Object objM0 = a.this.M0(null, null, this);
            return objM0 == AbstractC14862ic3.e() ? objM0 : C9475a16.a(objM0);
        }
    }

    static final class l extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objN0 = a.this.N0(null, null, null, null, this);
            return objN0 == AbstractC14862ic3.e() ? objN0 : C9475a16.a(objN0);
        }
    }

    static final class m extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        /* synthetic */ Object g;
        int i;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RecyclerView.UNDEFINED_DURATION;
            return a.this.O0(null, null, null, null, null, this);
        }
    }

    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C12889fL5 e;
        final /* synthetic */ AbstractC21649tt7 f;
        final /* synthetic */ C12889fL5 g;
        final /* synthetic */ String h;
        final /* synthetic */ LivekitRtc$AddTrackRequest.b i;

        /* renamed from: io.livekit.android.room.participant.a$n$a, reason: collision with other inner class name */
        static final class C0228a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ a c;
            final /* synthetic */ C12889fL5 d;
            final /* synthetic */ AbstractC21649tt7 e;
            final /* synthetic */ C12889fL5 f;
            final /* synthetic */ String g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0228a(a aVar, C12889fL5 c12889fL5, AbstractC21649tt7 abstractC21649tt7, C12889fL5 c12889fL52, String str, b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = aVar;
                this.d = c12889fL5;
                this.e = abstractC21649tt7;
                this.f = c12889fL52;
                this.g = str;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0228a(this.c, this.d, this.e, this.f, this.g, null, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    a aVar = this.c;
                    C12889fL5 c12889fL5 = this.d;
                    AbstractC21649tt7 abstractC21649tt7 = this.e;
                    C12889fL5 c12889fL52 = this.f;
                    String str = this.g;
                    this.b = 1;
                    if (a.P0(aVar, c12889fL5, abstractC21649tt7, c12889fL52, str, null, this) == objE) {
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
                return ((C0228a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ a c;
            final /* synthetic */ String d;
            final /* synthetic */ C12889fL5 e;
            final /* synthetic */ AbstractC21649tt7 f;
            final /* synthetic */ LivekitRtc$AddTrackRequest.b g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(a aVar, String str, C12889fL5 c12889fL5, AbstractC21649tt7 abstractC21649tt7, LivekitRtc$AddTrackRequest.b bVar, b bVar2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = aVar;
                this.d = str;
                this.e = c12889fL5;
                this.f = abstractC21649tt7;
                this.g = bVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, this.e, this.f, this.g, null, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    a aVar = this.c;
                    String str = this.d;
                    C12889fL5 c12889fL5 = this.e;
                    AbstractC21649tt7 abstractC21649tt7 = this.f;
                    LivekitRtc$AddTrackRequest.b bVar = this.g;
                    this.b = 1;
                    obj = a.S0(aVar, str, c12889fL5, abstractC21649tt7, bVar, null, this);
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
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(C12889fL5 c12889fL5, AbstractC21649tt7 abstractC21649tt7, C12889fL5 c12889fL52, String str, b bVar, LivekitRtc$AddTrackRequest.b bVar2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c12889fL5;
            this.f = abstractC21649tt7;
            this.g = c12889fL52;
            this.h = str;
            this.i = bVar2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            n nVar = a.this.new n(this.e, this.f, this.g, this.h, null, this.i, interfaceC20295rm1);
            nVar.c = obj;
            return nVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC24823zG1 interfaceC24823zG1;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(interfaceC20315ro1, null, null, new C0228a(a.this, this.e, this.f, this.g, this.h, null, null), 3, null);
                InterfaceC24823zG1 interfaceC24823zG1B = AbstractC10533bm0.b(interfaceC20315ro1, null, null, new b(a.this, this.h, this.g, this.f, this.i, null, null), 3, null);
                this.c = interfaceC24823zG1B;
                this.b = 1;
                if (interfaceC13730gj3D.k0(this) == objE) {
                    return objE;
                }
                interfaceC24823zG1 = interfaceC24823zG1B;
            } else {
                if (i != 1) {
                    if (i == 2) {
                        AbstractC10685c16.b(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC24823zG1 = (InterfaceC24823zG1) this.c;
                AbstractC10685c16.b(obj);
            }
            this.c = null;
            this.b = 2;
            obj = interfaceC24823zG1.y(this);
            return obj == objE ? objE : obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class o extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        /* synthetic */ Object g;
        int h;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return a.P0(null, null, null, null, null, null, this);
        }
    }

    static final class p extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int e;

        p(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return a.S0(null, null, null, null, null, null, this);
        }
    }

    public static final class q implements Callable {
        final /* synthetic */ FF5 a;
        final /* synthetic */ AbstractC21649tt7 b;
        final /* synthetic */ Object c;

        public q(FF5 ff5, AbstractC21649tt7 abstractC21649tt7, Object obj) {
            this.a = ff5;
            this.b = abstractC21649tt7;
            this.c = obj;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            if (this.a.a()) {
                return null;
            }
            return this.b.j() ? this.c : this.b.h().id();
        }
    }

    static final class r extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return a.this.T0(null, null, null, this);
        }
    }

    static final class s extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C22464vH3 e;
        final /* synthetic */ C12889fL5 f;
        final /* synthetic */ List g;
        final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        s(C22464vH3 c22464vH3, C12889fL5 c12889fL5, List list, String str) {
            super(1);
            this.e = c22464vH3;
            this.f = c12889fL5;
            this.g = list;
            this.h = str;
        }

        public final void a(LivekitRtc$AddTrackRequest.b bVar) {
            EnumC9607aF3 enumC9607aF3P;
            AbstractC13042fc3.i(bVar, "$this$publishTrackImpl");
            bVar.R(this.e.z().d());
            bVar.J(this.e.z().c());
            AbstractC21649tt7.g gVarK = ((GV7) this.f.a).k();
            if (gVarK == null || (enumC9607aF3P = gVarK.p()) == null) {
                enumC9607aF3P = this.e.A().f() ? EnumC9607aF3.SCREEN_SHARE : EnumC9607aF3.CAMERA;
            }
            bVar.N(enumC9607aF3P);
            bVar.B(this.g);
            LivekitRtc$SimulcastCodec.a aVarNewBuilder = LivekitRtc$SimulcastCodec.newBuilder();
            C12889fL5 c12889fL5 = this.f;
            String str = this.h;
            aVarNewBuilder.B(((GV7) c12889fL5.a).f());
            aVarNewBuilder.A(str);
            bVar.C((LivekitRtc$SimulcastCodec) aVarNewBuilder.a());
            C12373eW c12373eWA = ((GV7) this.f.a).a();
            if ((c12373eWA != null ? c12373eWA.a() : null) != null) {
                String strF = ((GV7) this.f.a).f();
                C12373eW c12373eWA2 = ((GV7) this.f.a).a();
                if (AbstractC13042fc3.d(strF, c12373eWA2 != null ? c12373eWA2.a() : null)) {
                    return;
                }
                LivekitRtc$SimulcastCodec.a aVarNewBuilder2 = LivekitRtc$SimulcastCodec.newBuilder();
                C12373eW c12373eWA3 = ((GV7) this.f.a).a();
                AbstractC13042fc3.f(c12373eWA3);
                aVarNewBuilder2.B(c12373eWA3.a());
                aVarNewBuilder2.A("");
                bVar.C((LivekitRtc$SimulcastCodec) aVarNewBuilder2.a());
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((LivekitRtc$AddTrackRequest.b) obj);
            return C19938rB7.a;
        }
    }

    static final class t extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        t(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return a.this.V0(this);
        }
    }

    static final class u extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        u(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objW0 = a.this.W0(null, this);
            return objW0 == AbstractC14862ic3.e() ? objW0 : C9475a16.a(objW0);
        }
    }

    static final class v extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        boolean f;
        /* synthetic */ Object g;
        int i;

        v(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RecyclerView.UNDEFINED_DURATION;
            return a.this.d1(null, false, null, this);
        }
    }

    static final class w extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C22668vd6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        w(C22668vd6 c22668vd6) {
            super(1);
            this.f = c22668vd6;
        }

        public final void a(AbstractC21649tt7 abstractC21649tt7) {
            AbstractC13042fc3.i(abstractC21649tt7, "it");
            a.g1(a.this, abstractC21649tt7, false, 2, null);
            SA2 sa2D = this.f.d();
            if (sa2D != null) {
                sa2D.invoke();
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21649tt7) obj);
            return C19938rB7.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(boolean z, io.livekit.android.room.f fVar, PeerConnectionFactory peerConnectionFactory, Context context, EglBase eglBase, C11599dH3.c cVar, C22464vH3.b bVar, HG3.b bVar2, C19977rG1 c19977rG1, AbstractC13778go1 abstractC13778go1, UA2 ua2, SM4 sm4) {
        super(Participant.Sid.b(""), null, abstractC13778go1, 0 == true ? 1 : 0);
        AbstractC13042fc3.i(fVar, "engine");
        AbstractC13042fc3.i(peerConnectionFactory, "peerConnectionFactory");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(eglBase, "eglBase");
        AbstractC13042fc3.i(cVar, "screencastVideoTrackFactory");
        AbstractC13042fc3.i(bVar, "videoTrackFactory");
        AbstractC13042fc3.i(bVar2, "audioTrackFactory");
        AbstractC13042fc3.i(c19977rG1, "defaultsManager");
        AbstractC13042fc3.i(abstractC13778go1, "coroutineDispatcher");
        AbstractC13042fc3.i(ua2, "capabilitiesGetter");
        AbstractC13042fc3.i(sm4, "outgoingDataStreamManager");
        this.A = z;
        this.B = fVar;
        this.C = peerConnectionFactory;
        this.D = context;
        this.E = eglBase;
        this.F = cVar;
        this.G = bVar;
        this.H = bVar2;
        this.I = c19977rG1;
        this.J = ua2;
        this.K = sm4;
        this.M = new LinkedHashMap();
        this.N = Collections.synchronizedMap(new LinkedHashMap());
        this.O = Collections.synchronizedMap(new LinkedHashMap());
        this.P = Collections.synchronizedMap(new LinkedHashMap());
        F92 f92J = AbstractC21649tt7.g.j();
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(f92J, 10)), 16));
        for (Object obj : f92J) {
            linkedHashMap.put(obj, AbstractC20899sn4.b(false, 1, null));
        }
        this.Q = linkedHashMap;
        this.R = Collections.synchronizedList(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0226 A[Catch: Exception -> 0x006e, TryCatch #0 {Exception -> 0x006e, blocks: (B:19:0x0069, B:72:0x021c, B:74:0x0226, B:76:0x023e, B:78:0x0244), top: B:105:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A0(java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, long r24, int r26, ir.nasim.InterfaceC20295rm1 r27) {
        /*
            Method dump skipped, instructions count: 774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.a.A0(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, int, ir.nasim.rm1):java.lang.Object");
    }

    private final void B0(String str, String str2, RpcError rpcError) {
        AbstractC18350oW3.a(this.P.remove(str));
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
            return;
        }
        AbstractC5270Ip7.e(null, "Response received for unexpected RPC request, id = " + str, new Object[0]);
    }

    private final boolean F0(AbstractC21649tt7.g gVar) {
        io.livekit.android.room.participant.c cVarM = m();
        if (cVarM == null) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.l(null, "No permissions present for publishing track.", new Object[0]);
            }
            return false;
        }
        boolean zA = cVarM.a();
        List listB = cVarM.b();
        boolean zContains = listB.contains(gVar);
        if (zA && (listB.isEmpty() || zContains)) {
            return true;
        }
        AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
        if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.l(null, "insufficient permissions to publish", new Object[0]);
        }
        return false;
    }

    private final void J0(C22464vH3 c22464vH3, CS7 cs7, GV7 gv7) {
        AbstractC4838Gt7 abstractC4838Gt7 = (AbstractC4838Gt7) r().get(c22464vH3.i());
        if (abstractC4838Gt7 == null) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "attempting to publish additional codec for non-published track?!", new Object[0]);
            return;
        }
        XV4 xv4C0 = c0(c22464vH3, cs7, gv7);
        if (xv4C0 == null) {
            AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
            if (UI3.c.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.g(null, "backup codec has been disabled, ignoring request to add additional codec for track", new Object[0]);
            return;
        }
        GV7 gv72 = (GV7) xv4C0.a();
        List list = (List) xv4C0.b();
        C10186bD6 c10186bD6X = c22464vH3.x(cs7, list);
        AbstractC10533bm0.d(n(), null, null, new g(c22464vH3, new RtpTransceiver.RtpTransceiverInit(RtpTransceiver.RtpTransceiverDirection.SEND_ONLY, AbstractC9766aX0.e(o()), list), cs7, abstractC4838Gt7, list, gv72, c10186bD6X, gv7, null), 3, null);
    }

    public static /* synthetic */ Object L0(a aVar, HG3 hg3, C24308yP c24308yP, b bVar, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        return aVar.K0(hg3, (i2 & 2) != 0 ? C24308yP.e(new C24308yP(null, aVar.n0(), null, null, 12, null), null, null, false, false, null, null, aVar.I.g(), 63, null) : c24308yP, (i2 & 4) != 0 ? null : bVar, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object M0(java.lang.String r5, java.lang.String r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof io.livekit.android.room.participant.a.k
            if (r0 == 0) goto L13
            r0 = r7
            io.livekit.android.room.participant.a$k r0 = (io.livekit.android.room.participant.a.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            io.livekit.android.room.participant.a$k r0 = new io.livekit.android.room.participant.a$k
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r5 = r7.l()
            goto L68
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r7)
            livekit.LivekitModels$DataPacket$a r7 = livekit.LivekitModels$DataPacket.newBuilder()
            r7.A(r5)
            livekit.LivekitModels$DataPacket$b r5 = livekit.LivekitModels$DataPacket.b.RELIABLE
            r7.B(r5)
            livekit.LivekitModels$RpcAck$a r5 = livekit.LivekitModels$RpcAck.newBuilder()
            r5.A(r6)
            com.google.protobuf.GeneratedMessageLite r5 = r5.a()
            livekit.LivekitModels$RpcAck r5 = (livekit.LivekitModels$RpcAck) r5
            r7.D(r5)
            com.google.protobuf.GeneratedMessageLite r5 = r7.a()
            livekit.LivekitModels$DataPacket r5 = (livekit.LivekitModels$DataPacket) r5
            ir.nasim.AbstractC13042fc3.f(r5)
            r0.c = r3
            java.lang.Object r5 = r4.W0(r5, r0)
            if (r5 != r1) goto L68
            return r1
        L68:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.a.M0(java.lang.String, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N0(java.lang.String r5, java.lang.String r6, java.lang.String r7, io.livekit.android.rpc.RpcError r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r4 = this;
            boolean r0 = r9 instanceof io.livekit.android.room.participant.a.l
            if (r0 == 0) goto L13
            r0 = r9
            io.livekit.android.room.participant.a$l r0 = (io.livekit.android.room.participant.a.l) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            io.livekit.android.room.participant.a$l r0 = new io.livekit.android.room.participant.a$l
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.a16 r9 = (ir.nasim.C9475a16) r9
            java.lang.Object r5 = r9.l()
            goto L81
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r9)
            int r9 = ir.nasim.CY6.a(r7)
            r2 = 15360(0x3c00, float:2.1524E-41)
            if (r9 > r2) goto L82
            livekit.LivekitModels$DataPacket$a r9 = livekit.LivekitModels$DataPacket.newBuilder()
            r9.A(r5)
            livekit.LivekitModels$DataPacket$b r5 = livekit.LivekitModels$DataPacket.b.RELIABLE
            r9.B(r5)
            livekit.LivekitModels$RpcResponse$a r5 = livekit.LivekitModels$RpcResponse.newBuilder()
            r5.C(r6)
            if (r8 == 0) goto L5f
            livekit.LivekitModels$RpcError r6 = r8.a()
            r5.A(r6)
            goto L66
        L5f:
            if (r7 != 0) goto L63
            java.lang.String r7 = ""
        L63:
            r5.B(r7)
        L66:
            com.google.protobuf.GeneratedMessageLite r5 = r5.a()
            livekit.LivekitModels$RpcResponse r5 = (livekit.LivekitModels$RpcResponse) r5
            r9.E(r5)
            com.google.protobuf.GeneratedMessageLite r5 = r9.a()
            livekit.LivekitModels$DataPacket r5 = (livekit.LivekitModels$DataPacket) r5
            ir.nasim.AbstractC13042fc3.f(r5)
            r0.c = r3
            java.lang.Object r5 = r4.W0(r5, r0)
            if (r5 != r1) goto L81
            return r1
        L81:
            return r5
        L82:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "cannot publish data larger than 15360"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.a.N0(java.lang.String, java.lang.String, java.lang.String, io.livekit.android.rpc.RpcError, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O0(ir.nasim.AbstractC21649tt7 r34, ir.nasim.InterfaceC5306It7 r35, ir.nasim.UA2 r36, java.util.List r37, io.livekit.android.room.participant.a.b r38, ir.nasim.InterfaceC20295rm1 r39) throws io.livekit.android.room.track.TrackException.PublishException {
        /*
            Method dump skipped, instructions count: 801
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.a.O0(ir.nasim.tt7, ir.nasim.It7, ir.nasim.UA2, java.util.List, io.livekit.android.room.participant.a$b, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object P0(io.livekit.android.room.participant.a r13, ir.nasim.C12889fL5 r14, ir.nasim.AbstractC21649tt7 r15, ir.nasim.C12889fL5 r16, java.lang.String r17, io.livekit.android.room.participant.a.b r18, ir.nasim.InterfaceC20295rm1 r19) throws io.livekit.android.room.track.TrackException.PublishException {
        /*
            Method dump skipped, instructions count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.a.P0(io.livekit.android.room.participant.a, ir.nasim.fL5, ir.nasim.tt7, ir.nasim.fL5, java.lang.String, io.livekit.android.room.participant.a$b, ir.nasim.rm1):java.lang.Object");
    }

    private static final void Q0(b bVar, a aVar, AbstractC21649tt7 abstractC21649tt7, TrackException.PublishException publishException, boolean z) {
        if (bVar != null) {
            bVar.b(publishException);
        }
        if (z) {
            aVar.f().b(new ZW4.c(aVar, abstractC21649tt7, publishException), aVar.n());
        }
    }

    static /* synthetic */ void R0(b bVar, a aVar, AbstractC21649tt7 abstractC21649tt7, TrackException.PublishException publishException, boolean z, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = true;
        }
        Q0(bVar, aVar, abstractC21649tt7, publishException, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object S0(io.livekit.android.room.participant.a r9, java.lang.String r10, ir.nasim.C12889fL5 r11, ir.nasim.AbstractC21649tt7 r12, livekit.LivekitRtc$AddTrackRequest.b r13, io.livekit.android.room.participant.a.b r14, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            boolean r0 = r15 instanceof io.livekit.android.room.participant.a.p
            if (r0 == 0) goto L14
            r0 = r15
            io.livekit.android.room.participant.a$p r0 = (io.livekit.android.room.participant.a.p) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.e = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            io.livekit.android.room.participant.a$p r0 = new io.livekit.android.room.participant.a$p
            r0.<init>(r15)
            goto L12
        L1a:
            java.lang.Object r15 = r7.d
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r7.e
            r8 = 0
            r2 = 1
            if (r1 == 0) goto L48
            if (r1 != r2) goto L40
            java.lang.Object r9 = r7.c
            ir.nasim.AbstractC18350oW3.a(r9)
            java.lang.Object r9 = r7.b
            r12 = r9
            ir.nasim.tt7 r12 = (ir.nasim.AbstractC21649tt7) r12
            java.lang.Object r9 = r7.a
            io.livekit.android.room.participant.a r9 = (io.livekit.android.room.participant.a) r9
            ir.nasim.AbstractC10685c16.b(r15)     // Catch: java.lang.Exception -> L3b
            r14 = r8
            goto L89
        L3b:
            r10 = move-exception
            r1 = r9
            r2 = r12
            r0 = r8
            goto L8d
        L40:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L48:
            ir.nasim.AbstractC10685c16.b(r15)
            io.livekit.android.room.f r1 = r9.B     // Catch: java.lang.Exception -> L60
            ir.nasim.AbstractC13042fc3.f(r10)     // Catch: java.lang.Exception -> L60
            java.lang.Object r15 = r11.a     // Catch: java.lang.Exception -> L60
            ir.nasim.It7 r15 = (ir.nasim.InterfaceC5306It7) r15     // Catch: java.lang.Exception -> L60
            java.lang.String r15 = r15.getName()     // Catch: java.lang.Exception -> L60
            if (r15 != 0) goto L5e
            java.lang.String r15 = r12.f()     // Catch: java.lang.Exception -> L60
        L5e:
            r3 = r15
            goto L65
        L60:
            r10 = move-exception
            r1 = r9
            r2 = r12
            r0 = r14
            goto L8d
        L65:
            ir.nasim.tt7$f r15 = r12.e()     // Catch: java.lang.Exception -> L60
            ir.nasim.bF3 r4 = r15.j()     // Catch: java.lang.Exception -> L60
            java.lang.Object r11 = r11.a     // Catch: java.lang.Exception -> L60
            ir.nasim.It7 r11 = (ir.nasim.InterfaceC5306It7) r11     // Catch: java.lang.Exception -> L60
            java.lang.String r5 = r11.i()     // Catch: java.lang.Exception -> L60
            ir.nasim.AbstractC13042fc3.f(r13)     // Catch: java.lang.Exception -> L60
            r7.a = r9     // Catch: java.lang.Exception -> L60
            r7.b = r12     // Catch: java.lang.Exception -> L60
            r7.c = r14     // Catch: java.lang.Exception -> L60
            r7.e = r2     // Catch: java.lang.Exception -> L60
            r2 = r10
            r6 = r13
            java.lang.Object r15 = r1.i0(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L60
            if (r15 != r0) goto L89
            return r0
        L89:
            livekit.LivekitModels$TrackInfo r15 = (livekit.LivekitModels$TrackInfo) r15     // Catch: java.lang.Exception -> L60
            r8 = r15
            goto L9b
        L8d:
            io.livekit.android.room.track.TrackException$PublishException r3 = new io.livekit.android.room.track.TrackException$PublishException
            java.lang.String r9 = "Failed to publish track"
            r3.<init>(r9, r10)
            r5 = 16
            r6 = 0
            r4 = 0
            R0(r0, r1, r2, r3, r4, r5, r6)
        L9b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.a.S0(io.livekit.android.room.participant.a, java.lang.String, ir.nasim.fL5, ir.nasim.tt7, livekit.LivekitRtc$AddTrackRequest$b, io.livekit.android.room.participant.a$b, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ Object U0(a aVar, C22464vH3 c22464vH3, GV7 gv7, b bVar, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            gv7 = new GV7(null, c22464vH3.A().f() ? aVar.u0() : aVar.x0(), null, null, 12, null);
        }
        if ((i2 & 4) != 0) {
            bVar = null;
        }
        return aVar.T0(c22464vH3, gv7, bVar, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object W0(livekit.LivekitModels$DataPacket r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.livekit.android.room.participant.a.u
            if (r0 == 0) goto L13
            r0 = r6
            io.livekit.android.room.participant.a$u r0 = (io.livekit.android.room.participant.a.u) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            io.livekit.android.room.participant.a$u r0 = new io.livekit.android.room.participant.a$u
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r5 = r6.l()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r6)
            io.livekit.android.room.f r6 = r4.B
            r0.c = r3
            java.lang.Object r5 = r6.M0(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            boolean r6 = ir.nasim.C9475a16.g(r5)
            if (r6 == 0) goto L5e
            io.livekit.android.rpc.RpcError$a r6 = io.livekit.android.rpc.RpcError.a.h
            java.lang.Throwable r5 = ir.nasim.C9475a16.e(r5)
            r0 = 0
            io.livekit.android.rpc.RpcError r5 = io.livekit.android.rpc.RpcError.a.p(r6, r0, r5, r3, r0)
            java.lang.Object r5 = ir.nasim.AbstractC10685c16.a(r5)
            java.lang.Object r5 = ir.nasim.C9475a16.b(r5)
        L5e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.a.W0(livekit.LivekitModels$DataPacket, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.XV4 c0(ir.nasim.C22464vH3 r18, ir.nasim.CS7 r19, ir.nasim.GV7 r20) {
        /*
            r17 = this;
            boolean r0 = ir.nasim.YG3.b(r20)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.lang.String r0 = r19.j()
            ir.nasim.eW r2 = r20.a()
            if (r2 == 0) goto L17
            java.lang.String r2 = r2.a()
            goto L18
        L17:
            r2 = r1
        L18:
            boolean r0 = ir.nasim.AbstractC13042fc3.d(r0, r2)
            if (r0 != 0) goto L62
            ir.nasim.Or3$a r0 = ir.nasim.AbstractC6718Or3.Companion
            ir.nasim.UI3 r0 = ir.nasim.UI3.d
            ir.nasim.Or3$a r2 = ir.nasim.AbstractC6718Or3.Companion
            ir.nasim.UI3 r2 = r2.a()
            int r0 = r0.compareTo(r2)
            if (r0 < 0) goto L62
            int r0 = ir.nasim.AbstractC5270Ip7.j()
            if (r0 <= 0) goto L62
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Server requested different codec than specified backup. server: "
            r0.append(r2)
            r2 = r19
            r0.append(r2)
            java.lang.String r3 = ", specified: "
            r0.append(r3)
            ir.nasim.eW r3 = r20.a()
            if (r3 == 0) goto L53
            java.lang.String r3 = r3.a()
            goto L54
        L53:
            r3 = r1
        L54:
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            ir.nasim.AbstractC5270Ip7.l(r1, r0, r3)
            goto L64
        L62:
            r2 = r19
        L64:
            java.lang.String r8 = r19.j()
            ir.nasim.eW r0 = r20.a()
            ir.nasim.AbstractC13042fc3.f(r0)
            ir.nasim.aT7 r6 = r0.b()
            r15 = 1013(0x3f5, float:1.42E-42)
            r16 = 0
            r5 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r4 = r20
            ir.nasim.GV7 r0 = ir.nasim.GV7.j(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            ir.nasim.wH3 r1 = r18.A()
            boolean r1 = r1.f()
            ir.nasim.tt7$e r2 = r18.z()
            r3 = r17
            java.util.List r1 = r3.d0(r1, r2, r0)
            ir.nasim.XV4 r0 = ir.nasim.AbstractC4616Fw7.a(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.a.c0(ir.nasim.vH3, ir.nasim.CS7, ir.nasim.GV7):ir.nasim.XV4");
    }

    public static /* synthetic */ Object c1(a aVar, boolean z, C22668vd6 c22668vd6, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c22668vd6 = null;
        }
        return aVar.b1(z, c22668vd6, interfaceC20295rm1);
    }

    private final List d0(boolean z, AbstractC21649tt7.e eVar, GV7 gv7) {
        int iA = eVar.a();
        int iB = eVar.b();
        C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = gv7.g();
        boolean zD = gv7.d();
        String strC = gv7.c();
        Object obj = c12889fL5.a;
        if ((obj == null && !zD) || iA == 0 || iB == 0) {
            return AbstractC10360bX0.m();
        }
        if (obj == null) {
            c12889fL5.a = C12158e82.a.d(z, iA, iB);
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.d(null, "using video encoding: " + c12889fL5.a, new Object[0]);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (strC != null && io.livekit.android.room.b.c(gv7.f())) {
            RtpParameters.Encoding encodingF = C9737aT7.f((C9737aT7) c12889fL5.a, null, 0.0d, 3, null);
            encodingF.scalabilityMode = strC;
            arrayList.add(encodingF);
            return arrayList;
        }
        if (zD) {
            List listE = gv7.e();
            if (listE == null) {
                listE = C12158e82.a.c(z, iA, iB, (C9737aT7) c12889fL5.a);
            }
            if (listE.isEmpty()) {
                AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
                if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.l(null, "Simulcast is enabled but an empty list was set for simulcastLayers!", new Object[0]);
                }
            }
            int iMax = Math.max(iA, iB);
            int iD = ((C9737aT7) c12889fL5.a).d();
            List listA1 = AbstractC15401jX0.a1(listE, new d(iMax));
            InterfaceC18336oU7 interfaceC18336oU7 = (InterfaceC18336oU7) AbstractC15401jX0.t0(listA1, 0);
            InterfaceC18336oU7 interfaceC18336oU72 = (InterfaceC18336oU7) AbstractC15401jX0.t0(listA1, 1);
            if (iMax >= 480 && interfaceC18336oU7 != null) {
                e0(c12889fL5, arrayList, C9737aT7.b(interfaceC18336oU7.j(), 0, Math.min(interfaceC18336oU7.j().d(), iD), 1, null), f0(iMax, interfaceC18336oU7.a()));
            }
            if (iMax >= 960 && interfaceC18336oU72 != null) {
                e0(c12889fL5, arrayList, C9737aT7.b(interfaceC18336oU72.j(), 0, Math.min(interfaceC18336oU72.j().d(), iD), 1, null), f0(iMax, interfaceC18336oU72.a()));
            }
            e0(c12889fL5, arrayList, (C9737aT7) c12889fL5.a, 1.0d);
        } else {
            arrayList.add(C9737aT7.f((C9737aT7) c12889fL5.a, null, 0.0d, 3, null));
        }
        AbstractC14812iX0.b0(arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c2 A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:17:0x004a, B:73:0x01ba, B:75:0x01c2, B:77:0x01c8, B:78:0x01cb, B:114:0x027d, B:79:0x01d5, B:29:0x0087, B:87:0x0208, B:89:0x0210, B:90:0x0217, B:32:0x0098, B:96:0x0240, B:98:0x0248, B:99:0x024f), top: B:122:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d5 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:17:0x004a, B:73:0x01ba, B:75:0x01c2, B:77:0x01c8, B:78:0x01cb, B:114:0x027d, B:79:0x01d5, B:29:0x0087, B:87:0x0208, B:89:0x0210, B:90:0x0217, B:32:0x0098, B:96:0x0240, B:98:0x0248, B:99:0x024f), top: B:122:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0210 A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:17:0x004a, B:73:0x01ba, B:75:0x01c2, B:77:0x01c8, B:78:0x01cb, B:114:0x027d, B:79:0x01d5, B:29:0x0087, B:87:0x0208, B:89:0x0210, B:90:0x0217, B:32:0x0098, B:96:0x0240, B:98:0x0248, B:99:0x024f), top: B:122:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0217 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:17:0x004a, B:73:0x01ba, B:75:0x01c2, B:77:0x01c8, B:78:0x01cb, B:114:0x027d, B:79:0x01d5, B:29:0x0087, B:87:0x0208, B:89:0x0210, B:90:0x0217, B:32:0x0098, B:96:0x0240, B:98:0x0248, B:99:0x024f), top: B:122:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0248 A[Catch: all -> 0x004f, TryCatch #2 {all -> 0x004f, blocks: (B:17:0x004a, B:73:0x01ba, B:75:0x01c2, B:77:0x01c8, B:78:0x01cb, B:114:0x027d, B:79:0x01d5, B:29:0x0087, B:87:0x0208, B:89:0x0210, B:90:0x0217, B:32:0x0098, B:96:0x0240, B:98:0x0248, B:99:0x024f), top: B:122:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x024f A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:17:0x004a, B:73:0x01ba, B:75:0x01c2, B:77:0x01c8, B:78:0x01cb, B:114:0x027d, B:79:0x01d5, B:29:0x0087, B:87:0x0208, B:89:0x0210, B:90:0x0217, B:32:0x0098, B:96:0x0240, B:98:0x0248, B:99:0x024f), top: B:122:0x002e }] */
    /* JADX WARN: Type inference failed for: r3v28, types: [ir.nasim.qn4] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v5, types: [ir.nasim.qn4] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d1(ir.nasim.AbstractC21649tt7.g r25, boolean r26, ir.nasim.C22668vd6 r27, ir.nasim.InterfaceC20295rm1 r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 653
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.a.d1(ir.nasim.tt7$g, boolean, ir.nasim.vd6, ir.nasim.rm1):java.lang.Object");
    }

    private static final void e0(C12889fL5 c12889fL5, List list, C9737aT7 c9737aT7, double d2) {
        if (d2 < 1.0d) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.l(null, "Discarding encoding with a scale down < 1.0: " + d2 + '.', new Object[0]);
            return;
        }
        if (d2 != 1.0d || c9737aT7 == c12889fL5.a) {
            int size = list.size();
            C12158e82 c12158e82 = C12158e82.a;
            if (size >= c12158e82.e().length) {
                throw new IllegalStateException("Attempting to add more encodings than we have rids for!");
            }
            list.add(c9737aT7.e(c12158e82.e()[list.size()], d2));
            return;
        }
        AbstractC6718Or3.a aVar2 = AbstractC6718Or3.Companion;
        if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
            return;
        }
        AbstractC5270Ip7.l(null, "Discarding duplicate encoding with a scale down == 1.0: " + d2 + '.', new Object[0]);
    }

    static /* synthetic */ Object e1(a aVar, AbstractC21649tt7.g gVar, boolean z, C22668vd6 c22668vd6, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            c22668vd6 = null;
        }
        return aVar.d1(gVar, z, c22668vd6, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double f0(int i2, AS7 as7) {
        return i2 / Math.max(as7.d(), as7.b());
    }

    public static /* synthetic */ void g1(a aVar, AbstractC21649tt7 abstractC21649tt7, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        aVar.f1(abstractC21649tt7, z);
    }

    public static /* synthetic */ HG3 h0(a aVar, String str, IG3 ig3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            ig3 = aVar.m0();
        }
        return aVar.g0(str, ig3);
    }

    public static /* synthetic */ C11599dH3 j0(a aVar, String str, Intent intent, C23060wH3 c23060wH3, VideoProcessor videoProcessor, UA2 ua2, int i2, Object obj) {
        return aVar.i0((i2 & 1) != 0 ? "" : str, intent, (i2 & 4) != 0 ? C23060wH3.b(aVar.t0(), false, null, null, null, 15, null) : c23060wH3, (i2 & 8) != 0 ? null : videoProcessor, ua2);
    }

    public static /* synthetic */ C22464vH3 l0(a aVar, String str, C23060wH3 c23060wH3, VideoProcessor videoProcessor, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            c23060wH3 = C23060wH3.b(aVar.w0(), false, null, null, null, 15, null);
        }
        if ((i2 & 4) != 0) {
            videoProcessor = null;
        }
        return aVar.k0(str, c23060wH3, videoProcessor);
    }

    private final List q0() {
        Collection<AbstractC4838Gt7> collectionValues = r().values();
        ArrayList arrayList = new ArrayList();
        for (AbstractC4838Gt7 abstractC4838Gt7 : collectionValues) {
            C20597sH3 c20597sH3 = abstractC4838Gt7 instanceof C20597sH3 ? (C20597sH3) abstractC4838Gt7 : null;
            if (c20597sH3 != null) {
                arrayList.add(c20597sH3);
            }
        }
        return AbstractC15401jX0.m1(arrayList);
    }

    private final void z0(String str) {
        AbstractC18350oW3.a(this.O.remove(str));
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
            return;
        }
        AbstractC5270Ip7.e(null, "Ack received for unexpected RPC request, id = " + str, new Object[0]);
    }

    public final void C0(LivekitRtc$TrackUnpublishedResponse livekitRtc$TrackUnpublishedResponse) {
        AbstractC13042fc3.i(livekitRtc$TrackUnpublishedResponse, "unpublishedResponse");
        AbstractC4838Gt7 abstractC4838Gt7 = (AbstractC4838Gt7) r().get(livekitRtc$TrackUnpublishedResponse.getTrackSid());
        AbstractC21649tt7 abstractC21649tt7H = abstractC4838Gt7 != null ? abstractC4838Gt7.h() : null;
        if (abstractC21649tt7H != null) {
            g1(this, abstractC21649tt7H, false, 2, null);
            return;
        }
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
            return;
        }
        AbstractC5270Ip7.l(null, "Received unpublished track response for unknown or non-published track: " + livekitRtc$TrackUnpublishedResponse.getTrackSid(), new Object[0]);
    }

    public final void D0(String str) {
        AbstractC13042fc3.i(str, "identity");
        Map map = this.O;
        AbstractC13042fc3.h(map, "pendingAcks");
        synchronized (map) {
            Map map2 = this.O;
            AbstractC13042fc3.h(map2, "pendingAcks");
            Iterator it = map2.entrySet().iterator();
            if (it.hasNext()) {
                AbstractC18350oW3.a(((Map.Entry) it.next()).getValue());
                throw null;
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
        Map map3 = this.P;
        AbstractC13042fc3.h(map3, "pendingResponses");
        synchronized (map3) {
            Map map4 = this.P;
            AbstractC13042fc3.h(map4, "pendingResponses");
            Iterator it2 = map4.entrySet().iterator();
            if (it2.hasNext()) {
                AbstractC18350oW3.a(((Map.Entry) it2.next()).getValue());
                throw null;
            }
        }
    }

    public final void E0(LivekitRtc$SubscribedQualityUpdate livekitRtc$SubscribedQualityUpdate) {
        AbstractC13042fc3.i(livekitRtc$SubscribedQualityUpdate, "subscribedQualityUpdate");
        if (this.A) {
            String trackSid = livekitRtc$SubscribedQualityUpdate.getTrackSid();
            List<LivekitRtc$SubscribedCodec> subscribedCodecsList = livekitRtc$SubscribedQualityUpdate.getSubscribedCodecsList();
            List<LivekitRtc$SubscribedQuality> subscribedQualitiesList = livekitRtc$SubscribedQualityUpdate.getSubscribedQualitiesList();
            Object obj = r().get(trackSid);
            C20597sH3 c20597sH3 = obj instanceof C20597sH3 ? (C20597sH3) obj : null;
            if (c20597sH3 == null) {
                return;
            }
            AbstractC21649tt7 abstractC21649tt7H = c20597sH3.h();
            C22464vH3 c22464vH3 = abstractC21649tt7H instanceof C22464vH3 ? (C22464vH3) abstractC21649tt7H : null;
            if (c22464vH3 == null) {
                return;
            }
            InterfaceC5306It7 interfaceC5306It7N = c20597sH3.n();
            GV7 gv7 = interfaceC5306It7N instanceof GV7 ? (GV7) interfaceC5306It7N : null;
            if (gv7 == null) {
                return;
            }
            AbstractC13042fc3.f(subscribedCodecsList);
            if (!subscribedCodecsList.isEmpty()) {
                for (CS7 cs7 : c22464vH3.D(subscribedCodecsList)) {
                    if (YG3.c(cs7.j())) {
                        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                        if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                            AbstractC5270Ip7.d(null, "publish " + cs7 + " for " + trackSid, new Object[0]);
                        }
                        J0(c22464vH3, cs7, gv7);
                    }
                }
            }
            AbstractC13042fc3.f(subscribedQualitiesList);
            if (!subscribedQualitiesList.isEmpty()) {
                c22464vH3.E(subscribedQualitiesList);
            }
        }
    }

    public final void G0(C20597sH3 c20597sH3) {
        AbstractC13042fc3.i(c20597sH3, "publication");
        if (r().containsKey(c20597sH3.e())) {
            f().b(new ZW4.e(this, c20597sH3), n());
            return;
        }
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
            return;
        }
        AbstractC5270Ip7.l(null, "Could not find local track publication for subscribed event ", new Object[0]);
    }

    public final void H0(String str, boolean z) {
        AbstractC13042fc3.i(str, "trackSid");
        AbstractC4838Gt7 abstractC4838Gt7 = (AbstractC4838Gt7) r().get(str);
        if (abstractC4838Gt7 == null) {
            return;
        }
        abstractC4838Gt7.k(z);
    }

    public final void I0() {
        List<C20597sH3> listM1 = AbstractC15401jX0.m1(q0());
        if (this.L == null) {
            this.L = listM1;
        }
        Map mapA = AbstractC20051rO3.A(r());
        mapA.clear();
        O(mapA);
        for (C20597sH3 c20597sH3 : listM1) {
            InterfaceC16587lX4 interfaceC16587lX4I = i();
            if (interfaceC16587lX4I != null) {
                interfaceC16587lX4I.A(c20597sH3, this);
            }
            f().b(new ZW4.f(this, c20597sH3), n());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object K0(ir.nasim.HG3 r27, ir.nasim.C24308yP r28, io.livekit.android.room.participant.a.b r29, ir.nasim.InterfaceC20295rm1 r30) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.a.K0(ir.nasim.HG3, ir.nasim.yP, io.livekit.android.room.participant.a$b, ir.nasim.rm1):java.lang.Object");
    }

    @Override // io.livekit.android.room.participant.Participant
    public void Q(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo) {
        boolean zB;
        AbstractC13042fc3.i(livekitModels$ParticipantInfo, ParameterNames.INFO);
        super.Q(livekitModels$ParticipantInfo);
        for (LivekitModels$TrackInfo livekitModels$TrackInfo : livekitModels$ParticipantInfo.getTracksList()) {
            Object obj = r().get(livekitModels$TrackInfo.getSid());
            C20597sH3 c20597sH3 = obj instanceof C20597sH3 ? (C20597sH3) obj : null;
            if (c20597sH3 != null && livekitModels$TrackInfo.getMuted() != (zB = c20597sH3.b())) {
                this.B.V0(o(), zB);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object T0(ir.nasim.C22464vH3 r27, ir.nasim.GV7 r28, io.livekit.android.room.participant.a.b r29, ir.nasim.InterfaceC20295rm1 r30) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.a.T0(ir.nasim.vH3, ir.nasim.GV7, io.livekit.android.room.participant.a$b, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00d0 -> B:40:0x00d3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object V0(ir.nasim.InterfaceC20295rm1 r11) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.livekit.android.room.participant.a.V0(ir.nasim.rm1):java.lang.Object");
    }

    public final Object X0(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        return e1(this, AbstractC21649tt7.g.b, z, null, interfaceC20295rm1, 4, null);
    }

    public final void Y0(boolean z) {
        this.A = z;
    }

    public final void Z0(List list) {
        String str;
        AbstractC13042fc3.i(list, "codecs");
        List list2 = this.R;
        AbstractC13042fc3.f(list2);
        synchronized (list2) {
            try {
                this.R.clear();
                List list3 = this.R;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    String mime = ((LivekitModels$Codec) obj).getMime();
                    AbstractC13042fc3.h(mime, "getMime(...)");
                    List listM0 = AbstractC20762sZ6.M0(mime, new char[]{'/'}, false, 0, 6, null);
                    String lowerCase = null;
                    if (!(!listM0.isEmpty())) {
                        listM0 = null;
                    }
                    if (listM0 != null && (str = (String) listM0.get(0)) != null) {
                        lowerCase = str.toLowerCase(Locale.ROOT);
                        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                    }
                    if (AbstractC13042fc3.d(lowerCase, MediaStreamTrack.VIDEO_TRACK_KIND)) {
                        arrayList.add(obj);
                    }
                }
                list3.addAll(arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object a1(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        return e1(this, AbstractC21649tt7.g.c, z, null, interfaceC20295rm1, 4, null);
    }

    public final void b0() {
        for (AbstractC4838Gt7 abstractC4838Gt7 : r().values()) {
            AbstractC21649tt7 abstractC21649tt7H = abstractC4838Gt7.h();
            if (abstractC21649tt7H != null) {
                abstractC21649tt7H.q();
                f1(abstractC21649tt7H, false);
                try {
                    abstractC21649tt7H.a();
                } catch (Exception e2) {
                    AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                    if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                        AbstractC5270Ip7.d(e2, "Exception thrown when cleaning up local participant track " + abstractC4838Gt7 + ':', new Object[0]);
                    }
                }
            }
        }
        HG3 hg3 = this.S;
        if (hg3 != null) {
            hg3.a();
        }
        this.S = null;
        C22464vH3 c22464vH3 = this.T;
        if (c22464vH3 != null) {
            c22464vH3.a();
        }
        this.T = null;
    }

    public final Object b1(boolean z, C22668vd6 c22668vd6, InterfaceC20295rm1 interfaceC20295rm1) {
        return d1(AbstractC21649tt7.g.d, z, c22668vd6, interfaceC20295rm1);
    }

    @Override // io.livekit.android.room.participant.Participant
    public void c() {
        b0();
        this.R.clear();
        super.c();
    }

    public final void f1(AbstractC21649tt7 abstractC21649tt7, boolean z) {
        Object next;
        AbstractC13042fc3.i(abstractC21649tt7, "track");
        Iterator it = q0().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (AbstractC13042fc3.d(((C20597sH3) next).h(), abstractC21649tt7)) {
                    break;
                }
            }
        }
        C20597sH3 c20597sH3 = (C20597sH3) next;
        if (c20597sH3 == null) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.b.compareTo(AbstractC6718Or3.Companion.a()) < 0 || AbstractC5270Ip7.j() <= 0) {
                return;
            }
            AbstractC5270Ip7.d(null, "this track was never published.", new Object[0]);
            return;
        }
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.M.get(c20597sH3);
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            this.M.remove(interfaceC13730gj3);
        }
        String strE = c20597sH3.e();
        Map mapA = AbstractC20051rO3.A(r());
        mapA.remove(strE);
        O(mapA);
        if (this.B.t0() == EnumC24439yd1.b) {
            this.B.K0(abstractC21649tt7.h());
        }
        if (z) {
            abstractC21649tt7.q();
        }
        InterfaceC16587lX4 interfaceC16587lX4I = i();
        if (interfaceC16587lX4I != null) {
            interfaceC16587lX4I.A(c20597sH3, this);
        }
        f().b(new ZW4.f(this, c20597sH3), n());
    }

    public final HG3 g0(String str, IG3 ig3) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(ig3, "options");
        return HG3.Companion.a(this.D, this.C, ig3, this.H, str);
    }

    public final C11599dH3 i0(String str, Intent intent, C23060wH3 c23060wH3, VideoProcessor videoProcessor, UA2 ua2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(intent, "mediaProjectionPermissionResultData");
        AbstractC13042fc3.i(c23060wH3, "options");
        AbstractC13042fc3.i(ua2, "onStop");
        return C11599dH3.Companion.b(intent, this.C, this.D, str, C23060wH3.b(c23060wH3, true, null, null, null, 14, null), this.E, this.F, videoProcessor, ua2);
    }

    public final C22464vH3 k0(String str, C23060wH3 c23060wH3, VideoProcessor videoProcessor) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(c23060wH3, "options");
        return C22464vH3.Companion.a(this.C, this.D, str, c23060wH3, this.E, this.G, videoProcessor);
    }

    public final IG3 m0() {
        return this.I.a();
    }

    public final C23718xP n0() {
        return this.I.b();
    }

    public final boolean o0() {
        return this.A;
    }

    public final io.livekit.android.room.f p0() {
        return this.B;
    }

    public final HG3 r0() {
        HG3 hg3 = this.S;
        if (hg3 != null) {
            return hg3;
        }
        HG3 hg3H0 = h0(this, null, null, 3, null);
        this.S = hg3H0;
        return hg3H0;
    }

    public final C22464vH3 s0() {
        C22464vH3 c22464vH3 = this.T;
        if (c22464vH3 != null) {
            return c22464vH3;
        }
        C22464vH3 c22464vH3L0 = l0(this, null, null, null, 7, null);
        this.T = c22464vH3L0;
        return c22464vH3L0;
    }

    public final C23060wH3 t0() {
        return this.I.c();
    }

    public final FV7 u0() {
        return this.I.d();
    }

    public C20597sH3 v0(AbstractC21649tt7.g gVar) {
        AbstractC13042fc3.i(gVar, "source");
        AbstractC4838Gt7 abstractC4838Gt7Q = super.q(gVar);
        if (abstractC4838Gt7Q instanceof C20597sH3) {
            return (C20597sH3) abstractC4838Gt7Q;
        }
        return null;
    }

    public final C23060wH3 w0() {
        return this.I.e();
    }

    public final FV7 x0() {
        return this.I.f();
    }

    public final void y0(LivekitModels$DataPacket livekitModels$DataPacket) {
        RpcError rpcErrorA;
        AbstractC13042fc3.i(livekitModels$DataPacket, "packet");
        String payload = null;
        if (livekitModels$DataPacket.hasRpcRequest()) {
            AbstractC10533bm0.d(n(), null, null, new e(livekitModels$DataPacket, livekitModels$DataPacket.getRpcRequest(), null), 3, null);
            return;
        }
        if (!livekitModels$DataPacket.hasRpcResponse()) {
            if (livekitModels$DataPacket.hasRpcAck()) {
                String requestId = livekitModels$DataPacket.getRpcAck().getRequestId();
                AbstractC13042fc3.h(requestId, "getRequestId(...)");
                z0(requestId);
                return;
            }
            return;
        }
        LivekitModels$RpcResponse rpcResponse = livekitModels$DataPacket.getRpcResponse();
        if (rpcResponse.hasPayload()) {
            payload = rpcResponse.getPayload();
            rpcErrorA = null;
        } else if (rpcResponse.hasError()) {
            RpcError.Companion companion = RpcError.INSTANCE;
            LivekitModels$RpcError error = rpcResponse.getError();
            AbstractC13042fc3.h(error, "getError(...)");
            rpcErrorA = companion.a(error);
        } else {
            rpcErrorA = null;
        }
        String requestId2 = rpcResponse.getRequestId();
        AbstractC13042fc3.h(requestId2, "getRequestId(...)");
        B0(requestId2, payload, rpcErrorA);
    }
}
