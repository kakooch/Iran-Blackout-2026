package ir.nasim.features.call.service;

import android.app.Notification;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10404bZ0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC7031Pz0;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.BV7;
import ir.nasim.C08;
import ir.nasim.C11458d25;
import ir.nasim.C17448mz0;
import ir.nasim.C18039nz0;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C21250tN;
import ir.nasim.C5335Ix0;
import ir.nasim.C8942Xx0;
import ir.nasim.EnumC13941h47;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC24937zS7;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC9336Zm4;
import ir.nasim.M26;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.features.call.service.VideoCallService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 72\u00020\u0001:\u00018B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0017\u001a\u00020\u00062\u0018\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00130\u00140\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001eH\u0002¢\u0006\u0004\b#\u0010!J'\u0010)\u001a\u00020(2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+H\u0014¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0006H\u0014¢\u0006\u0004\b/\u0010\u0003J\u0017\u00100\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u0010\bR\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00102¨\u00069"}, d2 = {"Lir/nasim/features/call/service/VideoCallService;", "Lir/nasim/features/call/service/CallService;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Lir/nasim/rB7;", "o2", "(Landroid/content/Intent;)V", "t2", "Lir/nasim/Xx0;", "callPeer", "r2", "(Lir/nasim/Xx0;)V", "p2", "Lir/nasim/d25;", "peer", "v2", "(Lir/nasim/d25;)V", "Lir/nasim/Fq2;", "", "Lir/nasim/M26;", "roomParticipantsFlow", "n2", "(Lir/nasim/Fq2;)V", "m2", "g2", "w2", "f2", "()Lir/nasim/rB7;", "", "isRecording", "l2", "(Z)V", "isStream", "k2", "Lir/nasim/h47;", "switchType", "Lir/nasim/ro1;", "serviceScope", "Lir/nasim/C08;", "k0", "(Lir/nasim/h47;Landroid/content/Intent;Lir/nasim/ro1;)Lir/nasim/C08;", "Lir/nasim/mz0$a;", "callState", "G0", "(Lir/nasim/mz0$a;)V", "n0", "K0", "Lir/nasim/zS7;", "Z", "Lir/nasim/zS7;", "videoCallSwitch", "z0", "isVideoResumed", "A0", "b", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class VideoCallService extends CallService {
    public static final int B0 = 8;

    /* renamed from: Z, reason: from kotlin metadata */
    private InterfaceC24937zS7 videoCallSwitch;

    /* renamed from: z0, reason: from kotlin metadata */
    private boolean isVideoResumed;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a, reason: collision with other inner class name */
        static final class C1135a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC20315ro1 d;

            /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$a, reason: collision with other inner class name */
            static final class C1136a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C17448mz0 c;

                /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$a$a, reason: collision with other inner class name */
                static final class C1137a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ Object c;

                    C1137a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1137a c1137a = new C1137a(interfaceC20295rm1);
                        c1137a.c = obj;
                        return c1137a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object value;
                        C17448mz0 c17448mz0;
                        AbstractC14862ic3.e();
                        if (this.b != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        M26 m26 = (M26) this.c;
                        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
                        do {
                            value = interfaceC9336Zm4H.getValue();
                            c17448mz0 = (C17448mz0) value;
                        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : null, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : m26.q(), (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(M26 m26, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1137a) create(m26, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$a$b */
                public static final class b implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$a$b$a, reason: collision with other inner class name */
                    public static final class C1138a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$a$b$a$a, reason: collision with other inner class name */
                        public static final class C1139a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1139a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1138a.this.a(null, this);
                            }
                        }

                        public C1138a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                                boolean r0 = r6 instanceof ir.nasim.features.call.service.VideoCallService.a.C1135a.C1136a.b.C1138a.C1139a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.features.call.service.VideoCallService$a$a$a$b$a$a r0 = (ir.nasim.features.call.service.VideoCallService.a.C1135a.C1136a.b.C1138a.C1139a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.features.call.service.VideoCallService$a$a$a$b$a$a r0 = new ir.nasim.features.call.service.VideoCallService$a$a$a$b$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L55
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                r2 = r5
                                ir.nasim.M26 r2 = (ir.nasim.M26) r2
                                ir.nasim.nz0 r2 = ir.nasim.C18039nz0.a
                                ir.nasim.Zm4 r2 = r2.h()
                                java.lang.Object r2 = r2.getValue()
                                ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
                                boolean r2 = r2.s()
                                r2 = r2 ^ r3
                                if (r2 == 0) goto L55
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L55
                                return r1
                            L55:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.VideoCallService.a.C1135a.C1136a.b.C1138a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1138a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1136a(C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c17448mz0;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1136a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2H = this.c.h();
                        if (interfaceC4557Fq2H != null) {
                            b bVar = new b(interfaceC4557Fq2H);
                            C1137a c1137a = new C1137a(null);
                            this.b = 1;
                            if (AbstractC6459Nq2.l(bVar, c1137a, this) == objE) {
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
                    return ((C1136a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C17448mz0 c;

                /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$a, reason: collision with other inner class name */
                static final class C1140a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    /* synthetic */ Object c;

                    /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$a$a, reason: collision with other inner class name */
                    static final class C1141a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                        int b;
                        /* synthetic */ Object c;

                        C1141a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(2, interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                            C1141a c1141a = new C1141a(interfaceC20295rm1);
                            c1141a.c = obj;
                            return c1141a;
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            boolean z;
                            Object value;
                            C17448mz0 c17448mz0;
                            AbstractC14862ic3.e();
                            if (this.b != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                            List list = (List) this.c;
                            if ((list instanceof Collection) && list.isEmpty()) {
                                z = false;
                            } else {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    if (((Boolean) it.next()).booleanValue()) {
                                        z = true;
                                        break;
                                    }
                                }
                                z = false;
                            }
                            C19406qI3.a("VideoCallService", "roomParticipants " + z, new Object[0]);
                            InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
                            do {
                                value = interfaceC9336Zm4H.getValue();
                                c17448mz0 = (C17448mz0) value;
                            } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : null, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : z, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
                            return C19938rB7.a;
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        /* renamed from: n, reason: merged with bridge method [inline-methods] */
                        public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                            return ((C1141a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                        }
                    }

                    /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$a$b, reason: collision with other inner class name */
                    public static final class C1142b implements InterfaceC4557Fq2 {
                        final /* synthetic */ InterfaceC4557Fq2[] a;

                        /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$a$b$a, reason: collision with other inner class name */
                        static final class C1143a extends AbstractC8614Ws3 implements SA2 {
                            final /* synthetic */ InterfaceC4557Fq2[] e;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public C1143a(InterfaceC4557Fq2[] interfaceC4557Fq2Arr) {
                                super(0);
                                this.e = interfaceC4557Fq2Arr;
                            }

                            @Override // ir.nasim.SA2
                            /* renamed from: a, reason: merged with bridge method [inline-methods] */
                            public final Object[] invoke() {
                                return new Boolean[this.e.length];
                            }
                        }

                        /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$a$b$b, reason: collision with other inner class name */
                        public static final class C1144b extends AbstractC19859r37 implements InterfaceC15796kB2 {
                            int b;
                            private /* synthetic */ Object c;
                            /* synthetic */ Object d;

                            public C1144b(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(3, interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                Object objE = AbstractC14862ic3.e();
                                int i = this.b;
                                if (i == 0) {
                                    AbstractC10685c16.b(obj);
                                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                                    Boolean[] boolArr = (Boolean[]) ((Object[]) this.d);
                                    ArrayList arrayList = new ArrayList(boolArr.length);
                                    for (Boolean bool : boolArr) {
                                        arrayList.add(AbstractC6392Nk0.a(bool.booleanValue()));
                                    }
                                    this.b = 1;
                                    if (interfaceC4806Gq2.a(arrayList, this) == objE) {
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
                                C1144b c1144b = new C1144b(interfaceC20295rm1);
                                c1144b.c = interfaceC4806Gq2;
                                c1144b.d = objArr;
                                return c1144b.invokeSuspend(C19938rB7.a);
                            }
                        }

                        public C1142b(InterfaceC4557Fq2[] interfaceC4557Fq2Arr) {
                            this.a = interfaceC4557Fq2Arr;
                        }

                        @Override // ir.nasim.InterfaceC4557Fq2
                        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                            InterfaceC4557Fq2[] interfaceC4557Fq2Arr = this.a;
                            Object objA = AbstractC10404bZ0.a(interfaceC4806Gq2, interfaceC4557Fq2Arr, new C1143a(interfaceC4557Fq2Arr), new C1144b(null), interfaceC20295rm1);
                            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
                        }
                    }

                    /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$a$c */
                    public static final class c implements InterfaceC4557Fq2 {
                        final /* synthetic */ InterfaceC4557Fq2 a;

                        /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$a$c$a, reason: collision with other inner class name */
                        public static final class C1145a implements InterfaceC4806Gq2 {
                            final /* synthetic */ InterfaceC4806Gq2 a;

                            /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$a$c$a$a, reason: collision with other inner class name */
                            public static final class C1146a extends AbstractC22163um1 {
                                /* synthetic */ Object a;
                                int b;

                                public C1146a(InterfaceC20295rm1 interfaceC20295rm1) {
                                    super(interfaceC20295rm1);
                                }

                                @Override // ir.nasim.E90
                                public final Object invokeSuspend(Object obj) {
                                    this.a = obj;
                                    this.b |= RecyclerView.UNDEFINED_DURATION;
                                    return C1145a.this.a(null, this);
                                }
                            }

                            public C1145a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                                    boolean r0 = r6 instanceof ir.nasim.features.call.service.VideoCallService.a.C1135a.b.C1140a.c.C1145a.C1146a
                                    if (r0 == 0) goto L13
                                    r0 = r6
                                    ir.nasim.features.call.service.VideoCallService$a$a$b$a$c$a$a r0 = (ir.nasim.features.call.service.VideoCallService.a.C1135a.b.C1140a.c.C1145a.C1146a) r0
                                    int r1 = r0.b
                                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                    r3 = r1 & r2
                                    if (r3 == 0) goto L13
                                    int r1 = r1 - r2
                                    r0.b = r1
                                    goto L18
                                L13:
                                    ir.nasim.features.call.service.VideoCallService$a$a$b$a$c$a$a r0 = new ir.nasim.features.call.service.VideoCallService$a$a$b$a$c$a$a
                                    r0.<init>(r6)
                                L18:
                                    java.lang.Object r6 = r0.a
                                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                    int r2 = r0.b
                                    r3 = 1
                                    if (r2 == 0) goto L31
                                    if (r2 != r3) goto L29
                                    ir.nasim.AbstractC10685c16.b(r6)
                                    goto L55
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
                                    ir.nasim.nz0 r2 = ir.nasim.C18039nz0.a
                                    ir.nasim.Zm4 r2 = r2.h()
                                    java.lang.Object r2 = r2.getValue()
                                    ir.nasim.mz0 r2 = (ir.nasim.C17448mz0) r2
                                    boolean r2 = r2.s()
                                    r2 = r2 ^ r3
                                    if (r2 == 0) goto L55
                                    r0.b = r3
                                    java.lang.Object r5 = r6.a(r5, r0)
                                    if (r5 != r1) goto L55
                                    return r1
                                L55:
                                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                    return r5
                                */
                                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.VideoCallService.a.C1135a.b.C1140a.c.C1145a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                            }
                        }

                        public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                            this.a = interfaceC4557Fq2;
                        }

                        @Override // ir.nasim.InterfaceC4557Fq2
                        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                            Object objB = this.a.b(new C1145a(interfaceC4806Gq2), interfaceC20295rm1);
                            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                        }
                    }

                    C1140a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C1140a c1140a = new C1140a(interfaceC20295rm1);
                        c1140a.c = obj;
                        return c1140a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            c cVar = new c(new C1142b((InterfaceC4557Fq2[]) AbstractC15401jX0.m1((List) this.c).toArray(new InterfaceC4557Fq2[0])));
                            C1141a c1141a = new C1141a(null);
                            this.b = 1;
                            if (AbstractC6459Nq2.l(cVar, c1141a, this) == objE) {
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
                        return ((C1140a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$b, reason: collision with other inner class name */
                public static final class C1147b implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$b$a, reason: collision with other inner class name */
                    public static final class C1148a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$b$a$a, reason: collision with other inner class name */
                        public static final class C1149a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1149a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1148a.this.a(null, this);
                            }
                        }

                        public C1148a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                            this.a = interfaceC4806Gq2;
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
                                boolean r0 = r8 instanceof ir.nasim.features.call.service.VideoCallService.a.C1135a.b.C1147b.C1148a.C1149a
                                if (r0 == 0) goto L13
                                r0 = r8
                                ir.nasim.features.call.service.VideoCallService$a$a$b$b$a$a r0 = (ir.nasim.features.call.service.VideoCallService.a.C1135a.b.C1147b.C1148a.C1149a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.features.call.service.VideoCallService$a$a$b$b$a$a r0 = new ir.nasim.features.call.service.VideoCallService$a$a$b$b$a$a
                                r0.<init>(r8)
                            L18:
                                java.lang.Object r8 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r8)
                                goto L67
                            L29:
                                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                                r7.<init>(r8)
                                throw r7
                            L31:
                                ir.nasim.AbstractC10685c16.b(r8)
                                ir.nasim.Gq2 r8 = r6.a
                                java.util.List r7 = (java.util.List) r7
                                java.lang.Iterable r7 = (java.lang.Iterable) r7
                                java.util.ArrayList r2 = new java.util.ArrayList
                                r4 = 10
                                int r4 = ir.nasim.ZW0.x(r7, r4)
                                r2.<init>(r4)
                                java.util.Iterator r7 = r7.iterator()
                            L49:
                                boolean r4 = r7.hasNext()
                                if (r4 == 0) goto L5e
                                java.lang.Object r4 = r7.next()
                                ir.nasim.Fq2 r4 = (ir.nasim.InterfaceC4557Fq2) r4
                                ir.nasim.features.call.service.VideoCallService$a$a$b$c r5 = new ir.nasim.features.call.service.VideoCallService$a$a$b$c
                                r5.<init>(r4)
                                r2.add(r5)
                                goto L49
                            L5e:
                                r0.b = r3
                                java.lang.Object r7 = r8.a(r2, r0)
                                if (r7 != r1) goto L67
                                return r1
                            L67:
                                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                                return r7
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.VideoCallService.a.C1135a.b.C1147b.C1148a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public C1147b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1148a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$c */
                public static final class c implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$c$a, reason: collision with other inner class name */
                    public static final class C1150a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.features.call.service.VideoCallService$a$a$b$c$a$a, reason: collision with other inner class name */
                        public static final class C1151a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1151a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1150a.this.a(null, this);
                            }
                        }

                        public C1150a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                                boolean r0 = r6 instanceof ir.nasim.features.call.service.VideoCallService.a.C1135a.b.c.C1150a.C1151a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.features.call.service.VideoCallService$a$a$b$c$a$a r0 = (ir.nasim.features.call.service.VideoCallService.a.C1135a.b.c.C1150a.C1151a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.features.call.service.VideoCallService$a$a$b$c$a$a r0 = new ir.nasim.features.call.service.VideoCallService$a$a$b$c$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L49
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.M26 r5 = (ir.nasim.M26) r5
                                boolean r5 = r5.m()
                                java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L49
                                return r1
                            L49:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.VideoCallService.a.C1135a.b.c.C1150a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public c(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1150a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c17448mz0;
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
                        InterfaceC4557Fq2 interfaceC4557Fq2K = this.c.k();
                        if (interfaceC4557Fq2K != null) {
                            C1147b c1147b = new C1147b(interfaceC4557Fq2K);
                            C1140a c1140a = new C1140a(null);
                            this.b = 1;
                            if (AbstractC6459Nq2.l(c1147b, c1140a, this) == objE) {
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
                    return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1135a(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC20315ro1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1135a c1135a = new C1135a(this.d, interfaceC20295rm1);
                c1135a.c = obj;
                return c1135a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C17448mz0 c17448mz0 = (C17448mz0) this.c;
                AbstractC10533bm0.d(this.d, null, null, new C1136a(c17448mz0, null), 3, null);
                AbstractC10533bm0.d(this.d, null, null, new b(c17448mz0, null), 3, null);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C17448mz0 c17448mz0, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1135a) create(c17448mz0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
                C1135a c1135a = new C1135a(interfaceC20315ro1, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC9336Zm4H, c1135a, this) == objE) {
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

    public static final class c implements BV7 {
        c() {
        }

        @Override // ir.nasim.BV7
        public void a(boolean z) {
            VideoCallService.this.k2(z);
        }

        @Override // ir.nasim.BV7
        public void b(InterfaceC4557Fq2 interfaceC4557Fq2) {
            AbstractC13042fc3.i(interfaceC4557Fq2, "participants");
            VideoCallService.this.m2(interfaceC4557Fq2);
        }

        @Override // ir.nasim.BV7
        public void c(InterfaceC4557Fq2 interfaceC4557Fq2) {
            AbstractC13042fc3.i(interfaceC4557Fq2, "participants");
            VideoCallService.this.n2(interfaceC4557Fq2);
        }

        @Override // ir.nasim.BV7
        public void d(boolean z) {
            VideoCallService.this.l2(z);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return VideoCallService.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (((C17448mz0) C18039nz0.a.h().getValue()).e() != C17448mz0.a.n && VideoCallService.this.isVideoResumed) {
                VideoCallService.this.isVideoResumed = false;
                VideoCallService.this.w2();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return VideoCallService.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4557Fq2 interfaceC4557Fq2H;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C18039nz0 c18039nz0 = C18039nz0.a;
                if (((C17448mz0) c18039nz0.h().getValue()).e() != C17448mz0.a.n && (interfaceC4557Fq2H = ((C17448mz0) c18039nz0.h().getValue()).h()) != null) {
                    this.b = 1;
                    obj = AbstractC6459Nq2.G(interfaceC4557Fq2H, this);
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
            M26 m26 = (M26) obj;
            if (m26 != null && m26.m()) {
                VideoCallService.this.w2();
                VideoCallService.this.isVideoResumed = true;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        public static final class a implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.features.call.service.VideoCallService$f$a$a, reason: collision with other inner class name */
            public static final class C1152a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.features.call.service.VideoCallService$f$a$a$a, reason: collision with other inner class name */
                public static final class C1153a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1153a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return C1152a.this.a(null, this);
                    }
                }

                public C1152a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                        boolean r0 = r6 instanceof ir.nasim.features.call.service.VideoCallService.f.a.C1152a.C1153a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.features.call.service.VideoCallService$f$a$a$a r0 = (ir.nasim.features.call.service.VideoCallService.f.a.C1152a.C1153a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.features.call.service.VideoCallService$f$a$a$a r0 = new ir.nasim.features.call.service.VideoCallService$f$a$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.M26 r5 = (ir.nasim.M26) r5
                        boolean r5 = r5.r()
                        java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.VideoCallService.f.a.C1152a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new C1152a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return VideoCallService.this.new f(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r4.b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ir.nasim.AbstractC10685c16.b(r5)
                goto L46
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                ir.nasim.AbstractC10685c16.b(r5)
                goto L30
            L1e:
                ir.nasim.AbstractC10685c16.b(r5)
                ir.nasim.nz0 r5 = ir.nasim.C18039nz0.a
                ir.nasim.Zm4 r5 = r5.h()
                r4.b = r3
                java.lang.Object r5 = ir.nasim.AbstractC6459Nq2.G(r5, r4)
                if (r5 != r0) goto L30
                return r0
            L30:
                ir.nasim.mz0 r5 = (ir.nasim.C17448mz0) r5
                ir.nasim.Fq2 r5 = r5.h()
                if (r5 == 0) goto L4d
                ir.nasim.features.call.service.VideoCallService$f$a r1 = new ir.nasim.features.call.service.VideoCallService$f$a
                r1.<init>(r5)
                r4.b = r2
                java.lang.Object r5 = ir.nasim.AbstractC6459Nq2.G(r1, r4)
                if (r5 != r0) goto L46
                return r0
            L46:
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                goto L4e
            L4d:
                r5 = 0
            L4e:
                ir.nasim.features.call.service.VideoCallService r0 = ir.nasim.features.call.service.VideoCallService.this
                ir.nasim.zS7 r0 = ir.nasim.features.call.service.VideoCallService.X1(r0)
                if (r0 == 0) goto L5a
                r5 = r5 ^ r3
                r0.f(r5)
            L5a:
                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.call.service.VideoCallService.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public VideoCallService() {
        AbstractC10533bm0.d(getServiceScope(), null, null, new a(null), 3, null);
    }

    private final C19938rB7 f2() {
        InterfaceC24937zS7 interfaceC24937zS7 = this.videoCallSwitch;
        if (interfaceC24937zS7 == null) {
            return null;
        }
        interfaceC24937zS7.n();
        return C19938rB7.a;
    }

    private final void g2() {
        InterfaceC24937zS7 interfaceC24937zS7 = this.videoCallSwitch;
        if (interfaceC24937zS7 != null) {
            interfaceC24937zS7.l();
        }
        C21250tN audioDeviceSelector = getAudioDeviceSelector();
        if (audioDeviceSelector != null) {
            audioDeviceSelector.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h2(VideoCallService videoCallService, C8942Xx0 c8942Xx0) {
        AbstractC13042fc3.i(videoCallService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        videoCallService.p2(c8942Xx0);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i2(VideoCallService videoCallService, C8942Xx0 c8942Xx0) {
        AbstractC13042fc3.i(videoCallService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        videoCallService.r2(c8942Xx0);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j2(VideoCallService videoCallService, C8942Xx0 c8942Xx0) {
        AbstractC13042fc3.i(videoCallService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        videoCallService.r2(c8942Xx0);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k2(boolean isStream) {
        Object value;
        C17448mz0 c17448mz0;
        AbstractC7031Pz0 abstractC7031Pz0F;
        if (isStream) {
            InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
            do {
                value = interfaceC9336Zm4H.getValue();
                c17448mz0 = (C17448mz0) value;
                abstractC7031Pz0F = c17448mz0.f();
            } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : abstractC7031Pz0F instanceof AbstractC7031Pz0.k ? ((AbstractC7031Pz0.k) c17448mz0.f()).c(true) : abstractC7031Pz0F instanceof AbstractC7031Pz0.i ? ((AbstractC7031Pz0.i) c17448mz0.f()).c(true) : c17448mz0.f(), (4091 & 8) != 0 ? c17448mz0.d : null, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l2(boolean isRecording) {
        Object value;
        C17448mz0 c17448mz0;
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : null, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : isRecording)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m2(InterfaceC4557Fq2 roomParticipantsFlow) {
        Object value;
        C17448mz0 c17448mz0;
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : null, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : roomParticipantsFlow, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n2(InterfaceC4557Fq2 roomParticipantsFlow) {
        Object value;
        C17448mz0 c17448mz0;
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : null, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : roomParticipantsFlow, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
    }

    private final void o2(Intent intent) {
        u1(intent);
        AbstractC13042fc3.f(((C17448mz0) C18039nz0.a.d().getValue()).d());
        C11458d25 c11458d25R = C11458d25.r(r3.b());
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        v2(c11458d25R);
    }

    private final void p2(C8942Xx0 callPeer) {
        startForeground(202, C5335Ix0.a.A(this, callPeer, t0(), true, new UA2() { // from class: ir.nasim.wS7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return VideoCallService.q2(this.a, (Notification) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q2(VideoCallService videoCallService, Notification notification) {
        AbstractC13042fc3.i(videoCallService, "this$0");
        AbstractC13042fc3.i(notification, "it");
        videoCallService.startForeground(202, notification);
        return C19938rB7.a;
    }

    private final void r2(C8942Xx0 callPeer) {
        startForeground(203, C5335Ix0.a.F(this, callPeer, true, new UA2() { // from class: ir.nasim.xS7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return VideoCallService.s2(this.a, (Notification) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s2(VideoCallService videoCallService, Notification notification) {
        AbstractC13042fc3.i(videoCallService, "this$0");
        AbstractC13042fc3.i(notification, "it");
        videoCallService.startForeground(203, notification);
        return C19938rB7.a;
    }

    private final void t2(Intent intent) {
        r1(intent, new AbstractC7031Pz0.i(false, 1, null), new UA2() { // from class: ir.nasim.yS7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return VideoCallService.u2(this.a, (C8942Xx0) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u2(VideoCallService videoCallService, C8942Xx0 c8942Xx0) {
        AbstractC13042fc3.i(videoCallService, "this$0");
        AbstractC13042fc3.i(c8942Xx0, "callPeer");
        videoCallService.r2(c8942Xx0);
        C11458d25 c11458d25R = C11458d25.r(c8942Xx0.b());
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        videoCallService.v2(c11458d25R);
        return C19938rB7.a;
    }

    private final void v2(C11458d25 peer) {
        InterfaceC24937zS7 interfaceC24937zS7 = this.videoCallSwitch;
        if (interfaceC24937zS7 != null) {
            interfaceC24937zS7.j(peer);
        }
        C21250tN audioDeviceSelector = getAudioDeviceSelector();
        if (audioDeviceSelector != null) {
            audioDeviceSelector.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w2() {
        AbstractC10533bm0.d(getServiceScope(), null, null, new f(null), 3, null);
    }

    @Override // ir.nasim.features.call.service.CallService
    protected void G0(C17448mz0.a callState) {
        Object value;
        C17448mz0 c17448mz0;
        AbstractC13042fc3.i(callState, "callState");
        InterfaceC9336Zm4 interfaceC9336Zm4H = C18039nz0.a.h();
        do {
            value = interfaceC9336Zm4H.getValue();
            c17448mz0 = (C17448mz0) value;
        } while (!interfaceC9336Zm4H.f(value, c17448mz0.a((4091 & 1) != 0 ? c17448mz0.a : null, (4091 & 2) != 0 ? c17448mz0.b : 0L, (4091 & 4) != 0 ? c17448mz0.c : null, (4091 & 8) != 0 ? c17448mz0.d : callState, (4091 & 16) != 0 ? c17448mz0.e : null, (4091 & 32) != 0 ? c17448mz0.f : null, (4091 & 64) != 0 ? c17448mz0.g : null, (4091 & 128) != 0 ? c17448mz0.h : false, (4091 & 256) != 0 ? c17448mz0.i : null, (4091 & 512) != 0 ? c17448mz0.j : null, (4091 & 1024) != 0 ? c17448mz0.k : null, (4091 & 2048) != 0 ? c17448mz0.l : false)));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // ir.nasim.features.call.service.CallService
    public void K0(Intent intent) throws Exception {
        InterfaceC24937zS7 interfaceC24937zS7;
        AbstractC13042fc3.i(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -1784260441:
                    if (action.equals("activity_resumed")) {
                        AbstractC10533bm0.d(getServiceScope(), null, null, new d(null), 3, null);
                        return;
                    }
                    break;
                case -1342034241:
                    if (action.equals("enable_video")) {
                        g2();
                        return;
                    }
                    break;
                case -1302976876:
                    if (action.equals("change_camera")) {
                        f2();
                        return;
                    }
                    break;
                case -1036165326:
                    if (action.equals("activity_stop")) {
                        AbstractC10533bm0.d(getServiceScope(), null, null, new e(null), 3, null);
                        return;
                    }
                    break;
                case -123217294:
                    if (action.equals("ACTION_START_SHARE_SCREEN")) {
                        Intent intent2 = (Intent) intent.getParcelableExtra("EXTRA_SHARE_SCREEN_INTENT");
                        if (intent2 == null || (interfaceC24937zS7 = this.videoCallSwitch) == null) {
                            return;
                        }
                        interfaceC24937zS7.a(intent2);
                        return;
                    }
                    break;
                case -121819751:
                    if (action.equals("retry_video_call")) {
                        o2(intent);
                        return;
                    }
                    break;
                case 279395106:
                    if (action.equals("incoming_video")) {
                        InterfaceC13730gj3 stopCallServiceJob = getStopCallServiceJob();
                        if (stopCallServiceJob != null) {
                            InterfaceC13730gj3.a.a(stopCallServiceJob, null, 1, null);
                        }
                        I0(intent, AbstractC7031Pz0.c.b, new UA2() { // from class: ir.nasim.tS7
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return VideoCallService.h2(this.a, (C8942Xx0) obj);
                            }
                        });
                        return;
                    }
                    break;
                case 876352415:
                    if (action.equals("start_video_call")) {
                        InterfaceC13730gj3 stopCallServiceJob2 = getStopCallServiceJob();
                        if (stopCallServiceJob2 != null) {
                            InterfaceC13730gj3.a.a(stopCallServiceJob2, null, 1, null);
                        }
                        t2(intent);
                        return;
                    }
                    break;
                case 1072244419:
                    if (action.equals("answer_video_call")) {
                        r(true, new UA2() { // from class: ir.nasim.uS7
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return VideoCallService.i2(this.a, (C8942Xx0) obj);
                            }
                        });
                        return;
                    }
                    break;
                case 1300720704:
                    if (action.equals("ACTION_STOP_SHARE_SCREEN")) {
                        InterfaceC24937zS7 interfaceC24937zS72 = this.videoCallSwitch;
                        if (interfaceC24937zS72 != null) {
                            interfaceC24937zS72.m();
                            return;
                        }
                        return;
                    }
                    break;
                case 1882746249:
                    if (action.equals("accept_video_from_activity")) {
                        r(false, new UA2() { // from class: ir.nasim.vS7
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return VideoCallService.j2(this.a, (C8942Xx0) obj);
                            }
                        });
                        return;
                    }
                    break;
                case 1939168880:
                    if (action.equals("toggle_camera")) {
                        w2();
                        return;
                    }
                    break;
            }
        }
        super.K0(intent);
    }

    @Override // ir.nasim.features.call.service.CallService
    public C08 k0(EnumC13941h47 switchType, Intent intent, InterfaceC20315ro1 serviceScope) {
        AbstractC13042fc3.i(switchType, "switchType");
        AbstractC13042fc3.i(intent, "intent");
        AbstractC13042fc3.i(serviceScope, "serviceScope");
        C08 c08K0 = super.k0(switchType, intent, serviceScope);
        AbstractC13042fc3.g(c08K0, "null cannot be cast to non-null type ir.nasim.features.call.callswitch.VideoCallSwitch");
        InterfaceC24937zS7 interfaceC24937zS7 = (InterfaceC24937zS7) c08K0;
        this.videoCallSwitch = interfaceC24937zS7;
        interfaceC24937zS7.c(new c());
        return c08K0;
    }

    @Override // ir.nasim.features.call.service.CallService
    protected void n0() {
        super.n0();
        this.videoCallSwitch = null;
    }
}
