package ir.nasim;

import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import ai.bale.proto.PeersStruct$UserOutPeer;
import ai.bale.proto.PresenceOuterClass$RequestGetGroupOnlineCount;
import ai.bale.proto.PresenceOuterClass$RequestSubscribeToOnline;
import ai.bale.proto.PresenceOuterClass$ResponseGetGroupOnlineCount;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C11942do5;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.do5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11942do5 extends AbstractC6360Ng4 {
    public static final a p = new a(null);
    public static final int q = 8;
    private final C9057Yh4 m;
    private final HashMap n;
    private InterfaceC4308Eo5 o;

    /* renamed from: ir.nasim.do5$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final K6 c(C9057Yh4 c9057Yh4) {
            AbstractC13042fc3.i(c9057Yh4, "$context");
            return new C11942do5(c9057Yh4);
        }

        public final C9528a7 b(final C9057Yh4 c9057Yh4) {
            AbstractC13042fc3.i(c9057Yh4, "context");
            C9528a7 c9528a7E = C12736f7.n().e("actor/presence", new V6() { // from class: ir.nasim.co5
                @Override // ir.nasim.V6
                public final K6 create() {
                    return C11942do5.a.c(c9057Yh4);
                }
            }, true);
            AbstractC13042fc3.h(c9528a7E, "actorOf(...)");
            return c9528a7E;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.do5$b */
    public static final class b {
        private final ArrayList a;

        public b(ArrayList arrayList) {
            AbstractC13042fc3.i(arrayList, "uIds");
            this.a = arrayList;
        }

        public final ArrayList a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.do5$c */
    public static final class c {
        private final C11458d25 a;

        public c(C11458d25 c11458d25) {
            AbstractC13042fc3.i(c11458d25, "peer");
            this.a = c11458d25;
        }

        public final C11458d25 a() {
            return this.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11942do5(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.n = new HashMap();
    }

    private final synchronized void h0(List list) {
        try {
            C19406qI3.a("PresenceActor", "handleGetUsersPresence size: " + list.size(), new Object[0]);
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                Long l = (Long) this.n.get(Integer.valueOf(iIntValue));
                if (l == null || AbstractC20507s76.p() - l.longValue() >= 3600000) {
                    this.n.put(Integer.valueOf(iIntValue), Long.valueOf(AbstractC20507s76.p()));
                    arrayList.add(Integer.valueOf(iIntValue));
                }
            }
            InterfaceC4308Eo5 interfaceC4308Eo5 = this.o;
            if (interfaceC4308Eo5 == null) {
                AbstractC13042fc3.y("presenceRepository");
                interfaceC4308Eo5 = null;
            }
            interfaceC4308Eo5.i(arrayList);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void i0(C18074o25 c18074o25) {
        if (c18074o25.b() == ExPeerType.BOT || c18074o25.b() == ExPeerType.CHANNEL) {
            return;
        }
        r().d(new c(c18074o25.c()));
    }

    private final void j0(F25 f25) {
        if (f25.b() == ExPeerType.BOT || f25.b() == ExPeerType.CHANNEL) {
            return;
        }
        r().d(new c(f25.c()));
    }

    private final synchronized void k0(final C11458d25 c11458d25) {
        try {
            if (c11458d25.z()) {
                GeneratedMessageLite generatedMessageLiteA = PresenceOuterClass$RequestGetGroupOnlineCount.newBuilder().A((PeersStruct$GroupOutPeer) PeersStruct$GroupOutPeer.newBuilder().B(c11458d25.getPeerId()).a()).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                PresenceOuterClass$ResponseGetGroupOnlineCount defaultInstance = PresenceOuterClass$ResponseGetGroupOnlineCount.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                L(new C22871vx5("/bale.presence.v1.Presence/GetGroupOnlineCount", generatedMessageLiteA, defaultInstance)).E(new InterfaceC24449ye1() { // from class: ir.nasim.Yn5
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        C11942do5.l0((Exception) obj);
                    }
                }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Zn5
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        C11942do5.m0(this.a, c11458d25, (PresenceOuterClass$ResponseGetGroupOnlineCount) obj);
                    }
                });
            } else {
                GeneratedMessageLite generatedMessageLiteA2 = PresenceOuterClass$RequestSubscribeToOnline.newBuilder().B((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B(c11458d25.getPeerId()).a()).a();
                AbstractC13042fc3.h(generatedMessageLiteA2, "build(...)");
                Misc$ResponseVoid defaultInstance2 = Misc$ResponseVoid.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
                L(new C22871vx5("/bale.presence.v1.Presence/SubscribeToOnline", generatedMessageLiteA2, defaultInstance2)).E(new InterfaceC24449ye1() { // from class: ir.nasim.ao5
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        C11942do5.o0((Exception) obj);
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Exception exc) {
        C19406qI3.c("PresenceActor", "handleSubscribe", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(C11942do5 c11942do5, C11458d25 c11458d25, final PresenceOuterClass$ResponseGetGroupOnlineCount presenceOuterClass$ResponseGetGroupOnlineCount) {
        AbstractC13042fc3.i(c11942do5, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(presenceOuterClass$ResponseGetGroupOnlineCount, "r");
        C19406qI3.a("PresenceActor", ">>> group online count: " + presenceOuterClass$ResponseGetGroupOnlineCount.getCount(), new Object[0]);
        final C14733iO2 c14733iO2 = (C14733iO2) c11942do5.m.E().Y1().n((long) c11458d25.getPeerId());
        if (c14733iO2 != null) {
            AbstractC20507s76.D(new Runnable() { // from class: ir.nasim.bo5
                @Override // java.lang.Runnable
                public final void run() {
                    C11942do5.n0(c14733iO2, presenceOuterClass$ResponseGetGroupOnlineCount);
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(C14733iO2 c14733iO2, PresenceOuterClass$ResponseGetGroupOnlineCount presenceOuterClass$ResponseGetGroupOnlineCount) {
        AbstractC13042fc3.i(presenceOuterClass$ResponseGetGroupOnlineCount, "$r");
        c14733iO2.C().i(Integer.valueOf(presenceOuterClass$ResponseGetGroupOnlineCount.getCount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(Exception exc) {
        C19406qI3.c("PresenceActor", "handleSubscribe", exc);
    }

    @Override // ir.nasim.AbstractC6360Ng4, ir.nasim.InterfaceC3817Cm0
    /* renamed from: g */
    public void T(AbstractC18385oa2 abstractC18385oa2) {
        AbstractC13042fc3.i(abstractC18385oa2, "event");
        if (abstractC18385oa2 instanceof C18074o25) {
            i0((C18074o25) abstractC18385oa2);
        } else if (abstractC18385oa2 instanceof F25) {
            j0((F25) abstractC18385oa2);
        } else if (abstractC18385oa2 instanceof C13531gO2) {
            r().d(new b(((C13531gO2) abstractC18385oa2).b()));
        }
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof c) {
            k0(((c) obj).a());
        } else if (obj instanceof b) {
            h0(((b) obj).a());
        } else {
            super.m(obj);
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        this.m.a().h(this, "peer_chat_opened");
        this.m.a().h(this, "peer_info_opened");
        this.m.a().h(this, "group_visible");
        this.o = ((InterfaceC13191fo5) I22.a(C5721Ko.a.d(), InterfaceC13191fo5.class)).V0();
    }
}
