package ir.nasim;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC6718Or3;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import livekit.org.webrtc.AudioTrack;
import livekit.org.webrtc.AudioTrackSink;
import livekit.org.webrtc.MediaConstraints;
import livekit.org.webrtc.PeerConnectionFactory;
import livekit.org.webrtc.RtpTransceiver;

/* loaded from: classes3.dex */
public final class HG3 extends AbstractC23128wP {
    private final IG3 l;
    private final InterfaceC24893zO m;
    private final AbstractC13778go1 n;
    private final JO o;
    private final QM p;
    private final IO q;
    private final InterfaceC20315ro1 r;
    private RtpTransceiver s;
    private final Set t;
    private final C10874cL6 u;
    static final /* synthetic */ InterfaceC5239Im3[] v = {AbstractC10882cM5.i(new C25226zw5(HG3.class, "features", "getFeatures()Ljava/util/Set;", 0))};
    public static final a Companion = new a(null);

    public static final class a {
        private a() {
        }

        public final HG3 a(Context context, PeerConnectionFactory peerConnectionFactory, IG3 ig3, b bVar, String str) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(peerConnectionFactory, "factory");
            AbstractC13042fc3.i(ig3, "options");
            AbstractC13042fc3.i(bVar, "audioTrackFactory");
            AbstractC13042fc3.i(str, "name");
            if (AbstractC4043Dl1.a(context, "android.permission.RECORD_AUDIO") != 0) {
                AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
                if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                    AbstractC5270Ip7.l(null, "Record audio permissions not granted, microphone recording will not be used.", new Object[0]);
                }
            }
            MediaConstraints mediaConstraints = new MediaConstraints();
            mediaConstraints.optional.addAll(AbstractC10360bX0.p(new MediaConstraints.KeyValuePair("googEchoCancellation", String.valueOf(ig3.b())), new MediaConstraints.KeyValuePair("googAutoGainControl", String.valueOf(ig3.a())), new MediaConstraints.KeyValuePair("googHighpassFilter", String.valueOf(ig3.c())), new MediaConstraints.KeyValuePair("googNoiseSuppression", String.valueOf(ig3.d())), new MediaConstraints.KeyValuePair("googTypingNoiseDetection", String.valueOf(ig3.e()))));
            AudioTrack audioTrackCreateAudioTrack = peerConnectionFactory.createAudioTrack(UUID.randomUUID().toString(), peerConnectionFactory.createAudioSource(mediaConstraints));
            AbstractC13042fc3.f(audioTrackCreateAudioTrack);
            return bVar.a(str, audioTrackCreateAudioTrack, ig3);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public interface b {
        HG3 a(String str, AudioTrack audioTrack, IG3 ig3);
    }

    static final class e extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ boolean d;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC18350oW3.a(this.c);
            return AbstractC4616Fw7.a(null, AbstractC6392Nk0.a(this.d));
        }

        public final Object n(BO bo, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(interfaceC20295rm1);
            eVar.c = bo;
            eVar.d = z;
            return eVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            AbstractC18350oW3.a(obj);
            return n(null, ((Boolean) obj2).booleanValue(), (InterfaceC20295rm1) obj3);
        }
    }

    public static final class f implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ HG3 b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ HG3 b;

            /* renamed from: ir.nasim.HG3$f$a$a, reason: collision with other inner class name */
            public static final class C0398a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0398a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, HG3 hg3) {
                this.a = interfaceC4806Gq2;
                this.b = hg3;
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
                    boolean r0 = r7 instanceof ir.nasim.HG3.f.a.C0398a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.HG3$f$a$a r0 = (ir.nasim.HG3.f.a.C0398a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.HG3$f$a$a r0 = new ir.nasim.HG3$f$a$a
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
                    ir.nasim.XV4 r6 = (ir.nasim.XV4) r6
                    ir.nasim.HG3 r2 = r5.b
                    java.util.Set r2 = ir.nasim.HG3.s(r2)
                    java.lang.Object r4 = r6.a()
                    ir.nasim.AbstractC18350oW3.a(r4)
                    java.lang.Object r6 = r6.b()
                    java.lang.Boolean r6 = (java.lang.Boolean) r6
                    boolean r6 = r6.booleanValue()
                    if (r6 != 0) goto L5f
                    java.lang.String r6 = "krisp_noise_cancellation"
                    r4 = 0
                    boolean r6 = ir.nasim.AbstractC13042fc3.d(r4, r6)
                    if (r6 == 0) goto L5f
                    ir.nasim.ME3 r6 = ir.nasim.ME3.TF_ENHANCED_NOISE_CANCELLATION
                    r2.add(r6)
                L5f:
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r2, r0)
                    if (r6 != r1) goto L68
                    return r1
                L68:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.HG3.f.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public f(InterfaceC4557Fq2 interfaceC4557Fq2, HG3 hg3) {
            this.a = interfaceC4557Fq2;
            this.b = hg3;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HG3(String str, AudioTrack audioTrack, IG3 ig3, InterfaceC24893zO interfaceC24893zO, AbstractC13778go1 abstractC13778go1, JO jo, QM qm, IO io2, FF5 ff5) {
        super(str, audioTrack, ff5);
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(audioTrack, "mediaTrack");
        AbstractC13042fc3.i(ig3, "options");
        AbstractC13042fc3.i(interfaceC24893zO, "audioProcessingController");
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        AbstractC13042fc3.i(jo, "audioRecordSamplesDispatcher");
        AbstractC13042fc3.i(qm, "audioBufferCallbackDispatcher");
        AbstractC13042fc3.i(io2, "audioRecordPrewarmer");
        AbstractC13042fc3.i(ff5, "rtcThreadToken");
        this.l = ig3;
        this.m = interfaceC24893zO;
        this.n = abstractC13778go1;
        this.o = jo;
        this.p = qm;
        this.q = io2;
        InterfaceC20315ro1 interfaceC20315ro1A = AbstractC20906so1.a(abstractC13778go1.X(P17.b(null, 1, null)));
        this.r = interfaceC20315ro1A;
        this.t = new LinkedHashSet();
        this.u = AbstractC5508Jq2.b(AbstractC6459Nq2.o0(new f(AbstractC6459Nq2.p(AbstractC5508Jq2.e(new AbstractC5474Jm4(interfaceC24893zO) { // from class: ir.nasim.HG3.c
            @Override // ir.nasim.InterfaceC3820Cm3
            public Object get() {
                ((InterfaceC24893zO) this.receiver).a();
                return null;
            }
        }), AbstractC5508Jq2.e(new AbstractC5474Jm4(interfaceC24893zO) { // from class: ir.nasim.HG3.d
            @Override // ir.nasim.InterfaceC3820Cm3
            public Object get() {
                return Boolean.valueOf(((InterfaceC24893zO) this.receiver).c());
            }
        }), new e(null)), this), interfaceC20315ro1A, InterfaceC16863lz6.a.c(), AbstractC4597Fu6.d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set t() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (this.l.b()) {
            linkedHashSet.add(ME3.TF_ECHO_CANCELLATION);
        }
        if (this.l.d()) {
            linkedHashSet.add(ME3.TF_NOISE_SUPPRESSION);
        }
        if (this.l.a()) {
            linkedHashSet.add(ME3.TF_AUTO_GAIN_CONTROL);
        }
        return linkedHashSet;
    }

    @Override // ir.nasim.AbstractC21649tt7
    public void a() {
        synchronized (this.t) {
            try {
                for (AudioTrackSink audioTrackSink : this.t) {
                    this.t.remove(audioTrackSink);
                    this.o.b(audioTrackSink);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        super.a();
    }

    public final Set u() {
        return (Set) this.u.h(this, v[0]);
    }

    public final void v() {
        this.q.a();
    }

    public final void w(RtpTransceiver rtpTransceiver) {
        this.s = rtpTransceiver;
    }

    public final void x() {
        this.q.stop();
    }
}
