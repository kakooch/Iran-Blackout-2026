package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.livekit.android.room.participant.Participant;
import ir.nasim.AbstractC21649tt7;
import ir.nasim.AbstractC25199zt7;
import ir.nasim.InterfaceC13730gj3;
import kotlin.KotlinNothingValueException;
import livekit.LivekitModels$TrackInfo;
import livekit.org.webrtc.MediaStreamTrack;
import livekit.org.webrtc.VideoTrack;

/* loaded from: classes3.dex */
public final class AN5 extends AbstractC4838Gt7 {
    private final AbstractC13778go1 o;
    private InterfaceC13730gj3 p;
    private boolean q;
    private boolean r;
    private AU7 s;
    private AbstractC21649tt7.e t;
    private Integer u;
    private boolean v;
    private final UA2 w;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return AN5.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AN5.this.w();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(c19938rB7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC21649tt7 c;
        final /* synthetic */ AN5 d;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ AN5 a;

            public a(AN5 an5) {
                this.a = an5;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public final Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                AbstractC25199zt7 abstractC25199zt7 = (AbstractC25199zt7) obj;
                if (abstractC25199zt7 instanceof AbstractC25199zt7.c) {
                    this.a.v(((AbstractC25199zt7.c) abstractC25199zt7).a());
                } else if (abstractC25199zt7 instanceof AbstractC25199zt7.b) {
                    this.a.u(((AbstractC25199zt7.b) abstractC25199zt7).a());
                } else if (abstractC25199zt7 instanceof AbstractC25199zt7.a) {
                    this.a.t((AbstractC25199zt7.a) abstractC25199zt7);
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC21649tt7 abstractC21649tt7, AN5 an5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = abstractC21649tt7;
            this.d = an5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC7983Ua2 interfaceC7983Ua2D = this.c.d();
                AN5 an5 = this.d;
                InterfaceC10040ay6 interfaceC10040ay6A = interfaceC7983Ua2D.a();
                a aVar = new a(an5);
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ AN5(LivekitModels$TrackInfo livekitModels$TrackInfo, AbstractC21649tt7 abstractC21649tt7, io.livekit.android.room.participant.d dVar, AbstractC13778go1 abstractC13778go1, int i, ED1 ed1) {
        this(livekitModels$TrackInfo, (i & 2) != 0 ? null : abstractC21649tt7, dVar, abstractC13778go1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(AbstractC25199zt7.a aVar) {
        Participant participant = (Participant) d().get();
        if (participant != null) {
            participant.x(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(AbstractC21649tt7.e eVar) {
        this.t = eVar;
        AbstractC25143zo1.b(this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(boolean z) {
        this.r = !z;
        AbstractC25143zo1.b(this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        Object obj = d().get();
        io.livekit.android.room.participant.d dVar = obj instanceof io.livekit.android.room.participant.d ? (io.livekit.android.room.participant.d) obj : null;
        if (dVar == null) {
            return;
        }
        AbstractC21649tt7 abstractC21649tt7H = h();
        MediaStreamTrack mediaStreamTrackH = abstractC21649tt7H != null ? abstractC21649tt7H.h() : null;
        if (mediaStreamTrackH instanceof VideoTrack) {
            ((VideoTrack) mediaStreamTrackH).setShouldReceive(!this.r);
        }
        io.livekit.android.room.l lVarT = dVar.T();
        String strE = e();
        boolean z = this.r;
        AbstractC21649tt7.e eVar = this.t;
        AU7 au7 = this.s;
        lVarT.L(strE, z, eVar, au7 != null ? au7.j() : null, this.u);
    }

    @Override // ir.nasim.AbstractC4838Gt7
    public boolean b() {
        return super.b();
    }

    @Override // ir.nasim.AbstractC4838Gt7
    public boolean g() {
        if (this.q || !this.v) {
            return false;
        }
        return super.g();
    }

    @Override // ir.nasim.AbstractC4838Gt7
    public AbstractC21649tt7 h() {
        return super.h();
    }

    @Override // ir.nasim.AbstractC4838Gt7
    public void k(boolean z) {
        if (super.b() == z) {
            return;
        }
        super.k(z);
        Object obj = d().get();
        io.livekit.android.room.participant.d dVar = obj instanceof io.livekit.android.room.participant.d ? (io.livekit.android.room.participant.d) obj : null;
        if (dVar == null) {
            return;
        }
        if (z) {
            dVar.w(this);
        } else {
            dVar.y(this);
        }
    }

    @Override // ir.nasim.AbstractC4838Gt7
    public void l(AbstractC21649tt7 abstractC21649tt7) {
        if (!AbstractC13042fc3.d(abstractC21649tt7, super.h())) {
            InterfaceC13730gj3 interfaceC13730gj3 = this.p;
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
            this.p = null;
        }
        super.l(abstractC21649tt7);
        if (abstractC21649tt7 != null) {
            this.p = AbstractC10533bm0.d(AbstractC20906so1.a(this.o), null, null, new b(abstractC21649tt7, this, null), 3, null);
            if (abstractC21649tt7 instanceof CN5) {
                CN5 cn5 = (CN5) abstractC21649tt7;
                if (cn5.y()) {
                    u(cn5.z());
                    v(cn5.A());
                }
            }
        }
    }

    public final UA2 r() {
        return this.w;
    }

    public final boolean s() {
        return this.v;
    }

    public final void x(boolean z) {
        this.v = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AN5(LivekitModels$TrackInfo livekitModels$TrackInfo, AbstractC21649tt7 abstractC21649tt7, io.livekit.android.room.participant.d dVar, AbstractC13778go1 abstractC13778go1) {
        super(livekitModels$TrackInfo, abstractC21649tt7, dVar);
        AbstractC13042fc3.i(livekitModels$TrackInfo, ParameterNames.INFO);
        AbstractC13042fc3.i(dVar, "participant");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.o = abstractC13778go1;
        this.s = AU7.c;
        this.v = true;
        this.w = AbstractC25143zo1.a(100L, AbstractC20906so1.a(abstractC13778go1), new a(null));
    }
}
