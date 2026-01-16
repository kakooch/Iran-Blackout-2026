package ir.nasim;

import ai.bale.proto.MeetOuterClass$ResponseGetOngoingCalls;
import ai.bale.proto.MeetStruct$CallLog;
import ai.bale.proto.PeersStruct$OutExPeer;
import ir.nasim.AbstractC17643nJ4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.k47, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15732k47 {
    private final C22875vy0 a;
    private final C4627Fy0 b;
    private final InterfaceC20315ro1 c;
    private final AbstractC13778go1 d;

    /* renamed from: ir.nasim.k47$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15732k47.this.new a(interfaceC20295rm1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v10, types: [ir.nasim.nJ4$b] */
        /* JADX WARN: Type inference failed for: r5v7, types: [ir.nasim.nJ4$c] */
        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objL;
            AbstractC17643nJ4.a aVar;
            AbstractC17643nJ4.a cVar;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22875vy0 c22875vy0 = C15732k47.this.a;
                this.b = 1;
                Object objE2 = c22875vy0.e(this);
                if (objE2 == objE) {
                    return objE;
                }
                objL = objE2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            if (C9475a16.j(objL)) {
                if (C9475a16.g(objL)) {
                    objL = null;
                }
                MeetOuterClass$ResponseGetOngoingCalls meetOuterClass$ResponseGetOngoingCalls = (MeetOuterClass$ResponseGetOngoingCalls) objL;
                if (meetOuterClass$ResponseGetOngoingCalls != null) {
                    C15732k47 c15732k47 = C15732k47.this;
                    List<MeetStruct$CallLog> callLogsList = meetOuterClass$ResponseGetOngoingCalls.getCallLogsList();
                    AbstractC13042fc3.h(callLogsList, "getCallLogsList(...)");
                    ArrayList arrayList = new ArrayList();
                    for (MeetStruct$CallLog meetStruct$CallLog : callLogsList) {
                        if (meetStruct$CallLog.hasGroupCallLog()) {
                            aVar = new AbstractC17643nJ4.a(meetStruct$CallLog.getCallId().getValue(), meetStruct$CallLog.getPeer().getId(), meetStruct$CallLog.getInitiator().getId(), meetStruct$CallLog.getCreationDate());
                        } else if (meetStruct$CallLog.hasMultiPeerCallLog()) {
                            String link = meetStruct$CallLog.getLink();
                            if (link == null || AbstractC20762sZ6.n0(link)) {
                                long value = meetStruct$CallLog.getCallId().getValue();
                                List<PeersStruct$OutExPeer> peersList = meetStruct$CallLog.getMultiPeerCallLog().getPeersList();
                                AbstractC13042fc3.h(peersList, "getPeersList(...)");
                                List<PeersStruct$OutExPeer> list = peersList;
                                ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list, 10));
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    arrayList2.add(AbstractC6392Nk0.d(((PeersStruct$OutExPeer) it.next()).getId()));
                                }
                                cVar = new AbstractC17643nJ4.c(value, arrayList2);
                            } else {
                                long value2 = meetStruct$CallLog.getCallId().getValue();
                                List<PeersStruct$OutExPeer> peersList2 = meetStruct$CallLog.getMultiPeerCallLog().getPeersList();
                                AbstractC13042fc3.h(peersList2, "getPeersList(...)");
                                List<PeersStruct$OutExPeer> list2 = peersList2;
                                ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(list2, 10));
                                Iterator it2 = list2.iterator();
                                while (it2.hasNext()) {
                                    arrayList3.add(AbstractC6392Nk0.d(((PeersStruct$OutExPeer) it2.next()).getId()));
                                }
                                int id = meetStruct$CallLog.getInitiator().getId();
                                String link2 = meetStruct$CallLog.getLink();
                                AbstractC13042fc3.h(link2, "getLink(...)");
                                cVar = new AbstractC17643nJ4.b(value2, arrayList3, id, link2, meetStruct$CallLog.getTitle(), AbstractC6392Nk0.e(meetStruct$CallLog.getStartDate()));
                            }
                            aVar = cVar;
                        } else {
                            aVar = null;
                        }
                        if (aVar != null) {
                            arrayList.add(aVar);
                        }
                    }
                    List listF = c15732k47.f(arrayList);
                    if (C8386Vt0.U6()) {
                        c15732k47.b.K(listF);
                    }
                    C10263bM2.a.a(listF);
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C15732k47(C22875vy0 c22875vy0, C4627Fy0 c4627Fy0, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c22875vy0, "callRemoteDataSource");
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = c22875vy0;
        this.b = c4627Fy0;
        this.c = interfaceC20315ro1;
        this.d = abstractC13778go1;
    }

    private final boolean e(long j) {
        return this.b.M0(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List f(List list) {
        List list2 = list;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (e(((AbstractC17643nJ4) obj).a())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            if (!e(((AbstractC17643nJ4) obj2).a())) {
                arrayList2.add(obj2);
            }
        }
        return AbstractC15401jX0.R0(arrayList, arrayList2);
    }

    public final InterfaceC13730gj3 d() {
        return AbstractC10533bm0.d(this.c, this.d, null, new a(null), 2, null);
    }
}
