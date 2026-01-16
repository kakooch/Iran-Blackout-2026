package io.livekit.android.room.participant;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.livekit.android.room.l;
import io.livekit.android.room.participant.Participant;
import io.livekit.android.room.track.TrackException;
import ir.nasim.AN5;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC21649tt7;
import ir.nasim.AbstractC5270Ip7;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.C11655dN5;
import ir.nasim.C19938rB7;
import ir.nasim.CN5;
import ir.nasim.ED1;
import ir.nasim.HG1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC16587lX4;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.P17;
import ir.nasim.UA2;
import ir.nasim.UI3;
import ir.nasim.VV0;
import ir.nasim.ZW4;
import java.util.Map;
import livekit.LivekitModels$ParticipantInfo;
import livekit.LivekitRtc$SubscriptionPermissionUpdate;
import livekit.org.webrtc.AudioTrack;
import livekit.org.webrtc.MediaStreamTrack;
import livekit.org.webrtc.RtpReceiver;
import livekit.org.webrtc.VideoTrack;

/* loaded from: classes3.dex */
public final class d extends Participant {
    private final l A;
    private final AbstractC13778go1 B;
    private final C11655dN5.a C;
    private final CN5.a D;
    private final VV0 E;

    public interface a {
        d a(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo);
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ MediaStreamTrack d;
        final /* synthetic */ String e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ RtpReceiver g;
        final /* synthetic */ boolean h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MediaStreamTrack mediaStreamTrack, String str, UA2 ua2, RtpReceiver rtpReceiver, boolean z, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = mediaStreamTrack;
            this.e = str;
            this.f = ua2;
            this.g = rtpReceiver;
            this.h = z;
            this.i = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return d.this.new b(this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws TrackException.InvalidTrackTypeException {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(150L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            d.this.R(this.d, this.e, this.f, this.g, this.h, this.i - 1);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ d(String str, String str2, l lVar, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, C11655dN5.a aVar, CN5.a aVar2, ED1 ed1) {
        this(str, str2, lVar, abstractC13778go1, abstractC13778go12, aVar, aVar2);
    }

    public static /* synthetic */ void S(d dVar, MediaStreamTrack mediaStreamTrack, String str, UA2 ua2, RtpReceiver rtpReceiver, boolean z, int i, int i2, Object obj) throws TrackException.InvalidTrackTypeException {
        if ((i2 & 16) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 32) != 0) {
            i = 20;
        }
        dVar.R(mediaStreamTrack, str, ua2, rtpReceiver, z2, i);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r10v0 ??, still in use, count: 2, list:
          (r10v0 ?? I:java.lang.Object) from 0x0043: INVOKE (r1v0 ?? I:java.util.Map), (r2v4 ?? I:java.lang.Object), (r10v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:68)
          (r10v0 ?? I:ir.nasim.Gt7) from 0x0046: INVOKE (r11v0 'this' ?? I:io.livekit.android.room.participant.Participant A[IMMUTABLE_TYPE, THIS]), (r10v0 ?? I:ir.nasim.Gt7) VIRTUAL call: io.livekit.android.room.participant.Participant.a(ir.nasim.Gt7):void A[MD:(ir.nasim.Gt7):void (m)] (LINE:71)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @Override // io.livekit.android.room.participant.Participant
    public void Q(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r10v0 ??, still in use, count: 2, list:
          (r10v0 ?? I:java.lang.Object) from 0x0043: INVOKE (r1v0 ?? I:java.util.Map), (r2v4 ?? I:java.lang.Object), (r10v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:68)
          (r10v0 ?? I:ir.nasim.Gt7) from 0x0046: INVOKE (r11v0 'this' ?? I:io.livekit.android.room.participant.Participant A[IMMUTABLE_TYPE, THIS]), (r10v0 ?? I:ir.nasim.Gt7) VIRTUAL call: io.livekit.android.room.participant.Participant.a(ir.nasim.Gt7):void A[MD:(ir.nasim.Gt7):void (m)] (LINE:71)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r12v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    public final void R(MediaStreamTrack mediaStreamTrack, String str, UA2 ua2, RtpReceiver rtpReceiver, boolean z, int i) throws TrackException.InvalidTrackTypeException {
        AbstractC21649tt7 abstractC21649tt7A;
        AbstractC13042fc3.i(mediaStreamTrack, "mediaTrack");
        AbstractC13042fc3.i(str, "sid");
        AbstractC13042fc3.i(ua2, "statsGetter");
        AbstractC13042fc3.i(rtpReceiver, "receiver");
        AN5 an5U = U(str);
        if (an5U != null) {
            String strKind = mediaStreamTrack.kind();
            if (AbstractC13042fc3.d(strKind, MediaStreamTrack.AUDIO_TRACK_KIND)) {
                abstractC21649tt7A = this.C.a("", (AudioTrack) mediaStreamTrack, rtpReceiver);
            } else {
                if (!AbstractC13042fc3.d(strKind, MediaStreamTrack.VIDEO_TRACK_KIND)) {
                    throw new TrackException.InvalidTrackTypeException("invalid track type: " + strKind, null, 2, null);
                }
                abstractC21649tt7A = this.D.a("", (VideoTrack) mediaStreamTrack, z, rtpReceiver);
            }
            abstractC21649tt7A.n(ua2);
            an5U.l(abstractC21649tt7A);
            an5U.x(true);
            abstractC21649tt7A.l(an5U.c());
            abstractC21649tt7A.m(an5U.e());
            a(an5U);
            abstractC21649tt7A.p();
            InterfaceC16587lX4 interfaceC16587lX4I = i();
            if (interfaceC16587lX4I != null) {
                interfaceC16587lX4I.O(abstractC21649tt7A, an5U, this);
            }
            f().b(new ZW4.o(this, abstractC21649tt7A, an5U), n());
            return;
        }
        if (i != 0) {
            AbstractC10533bm0.d(this.E, null, null, new b(mediaStreamTrack, str, ua2, rtpReceiver, z, i, null), 3, null);
            return;
        }
        String str2 = "Could not find published track with sid: " + str;
        TrackException.InvalidTrackStateException invalidTrackStateException = new TrackException.InvalidTrackStateException(str2, null, 2, null);
        AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
        if (UI3.e.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
            AbstractC5270Ip7.e(null, "remote participant " + ((Object) Participant.Sid.f(o())) + " --- " + str2, new Object[0]);
        }
        InterfaceC16587lX4 interfaceC16587lX4I2 = i();
        if (interfaceC16587lX4I2 != null) {
            interfaceC16587lX4I2.w(str, invalidTrackStateException, this);
        }
        f().b(new ZW4.p(this, str, invalidTrackStateException), n());
    }

    public final l T() {
        return this.A;
    }

    public final AN5 U(String str) {
        AbstractC13042fc3.i(str, "sid");
        Object obj = r().get(str);
        if (obj instanceof AN5) {
            return (AN5) obj;
        }
        return null;
    }

    public final void V(byte[] bArr, String str) {
        AbstractC13042fc3.i(bArr, "data");
        f().b(new ZW4.b(this, bArr, str), n());
    }

    public final void W(LivekitRtc$SubscriptionPermissionUpdate livekitRtc$SubscriptionPermissionUpdate) {
        AbstractC13042fc3.i(livekitRtc$SubscriptionPermissionUpdate, "subscriptionPermissionUpdate");
        Object obj = r().get(livekitRtc$SubscriptionPermissionUpdate.getTrackSid());
        AN5 an5 = obj instanceof AN5 ? (AN5) obj : null;
        if (an5 == null || an5.s() == livekitRtc$SubscriptionPermissionUpdate.getAllowed()) {
            return;
        }
        an5.x(livekitRtc$SubscriptionPermissionUpdate.getAllowed());
        f().b(new ZW4.q(this, an5, an5.s()), this.E);
    }

    public final void X(String str, boolean z) {
        AbstractC13042fc3.i(str, "trackSid");
        Object obj = r().get(str);
        AN5 an5 = obj instanceof AN5 ? (AN5) obj : null;
        if (an5 == null) {
            return;
        }
        Map mapA = AbstractC20051rO3.A(r());
        mapA.remove(str);
        O(mapA);
        AbstractC21649tt7 abstractC21649tt7H = an5.h();
        if (abstractC21649tt7H != null) {
            try {
                abstractC21649tt7H.q();
            } catch (Exception unused) {
            }
            InterfaceC16587lX4 interfaceC16587lX4I = i();
            if (interfaceC16587lX4I != null) {
                interfaceC16587lX4I.C(abstractC21649tt7H, an5, this);
            }
            f().b(new ZW4.t(this, abstractC21649tt7H, an5), n());
        }
        if (z) {
            InterfaceC16587lX4 interfaceC16587lX4I2 = i();
            if (interfaceC16587lX4I2 != null) {
                interfaceC16587lX4I2.F(an5, this);
            }
            f().b(new ZW4.s(this, an5), n());
        }
        an5.l(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private d(String str, String str2, l lVar, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, C11655dN5.a aVar, CN5.a aVar2) {
        super(str, str2, abstractC13778go12, null);
        AbstractC13042fc3.i(str, "sid");
        AbstractC13042fc3.i(lVar, "signalClient");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "defaultDispatcher");
        AbstractC13042fc3.i(aVar, "audioTrackFactory");
        AbstractC13042fc3.i(aVar2, "videoTrackFactory");
        this.A = lVar;
        this.B = abstractC13778go1;
        this.C = aVar;
        this.D = aVar2;
        this.E = new VV0(abstractC13778go12.X(P17.b(null, 1, null)));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public d(LivekitModels$ParticipantInfo livekitModels$ParticipantInfo, l lVar, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, C11655dN5.a aVar, CN5.a aVar2) {
        AbstractC13042fc3.i(livekitModels$ParticipantInfo, ParameterNames.INFO);
        AbstractC13042fc3.i(lVar, "signalClient");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(abstractC13778go12, "defaultDispatcher");
        AbstractC13042fc3.i(aVar, "audioTrackFactory");
        AbstractC13042fc3.i(aVar2, "videoTrackFactory");
        String sid = livekitModels$ParticipantInfo.getSid();
        AbstractC13042fc3.h(sid, "getSid(...)");
        String strB = Participant.Sid.b(sid);
        String identity = livekitModels$ParticipantInfo.getIdentity();
        AbstractC13042fc3.h(identity, "getIdentity(...)");
        this(strB, Participant.Identity.b(identity), lVar, abstractC13778go1, abstractC13778go12, aVar, aVar2, null);
        super.Q(livekitModels$ParticipantInfo);
    }
}
