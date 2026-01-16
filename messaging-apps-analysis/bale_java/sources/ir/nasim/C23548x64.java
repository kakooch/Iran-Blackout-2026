package ir.nasim;

import ai.bale.proto.MessagingOuterClass$RequestDeleteMessage;
import ai.bale.proto.MessagingStruct$MessagesDeleteDates;
import ai.bale.proto.Misc$ResponseSeq;
import com.google.protobuf.BoolValue;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: ir.nasim.x64, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23548x64 extends AbstractC6360Ng4 {
    private final C9057Yh4 m;
    private final InterfaceC9173Yu3 n;
    private JH1 o;

    /* renamed from: ir.nasim.x64$a */
    public static final class a {
        private final C11458d25 a;
        private final List b;
        private final List c;
        private final boolean d;

        public a(C11458d25 c11458d25, List list, List list2, boolean z) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(list, "rids");
            AbstractC13042fc3.i(list2, "dates");
            this.a = c11458d25;
            this.b = list;
            this.c = list2;
            this.d = z;
        }

        public final List a() {
            return this.c;
        }

        public final C11458d25 b() {
            return this.a;
        }

        public final List c() {
            return this.b;
        }

        public final boolean d() {
            return this.d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C23548x64(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.n = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.w64
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C23548x64.f0(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OK f0(C23548x64 c23548x64) {
        AbstractC13042fc3.i(c23548x64, "this$0");
        return c23548x64.m.T().C();
    }

    private final InterfaceC8344Vo3 g0() {
        Object value = this.n.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (InterfaceC8344Vo3) value;
    }

    private final void h0() {
        JH1 jh1;
        try {
            C9863ah0 c9863ah0 = (C9863ah0) g0().d(17L);
            jh1 = c9863ah0 != null ? JH1.q(c9863ah0.q()) : new JH1();
        } catch (IOException e) {
            C19406qI3.c("MessageDeleteActor", "initDeleteStorage", e);
            jh1 = new JH1();
        }
        this.o = jh1;
    }

    private final void i0(C11458d25 c11458d25, List list, List list2, boolean z) {
        JH1 jh1 = this.o;
        if (jh1 == null) {
            AbstractC13042fc3.y("deleteStorage");
            jh1 = null;
        }
        HashMap mapR = jh1.r();
        if (!mapR.containsKey(c11458d25)) {
            AbstractC13042fc3.f(mapR);
            mapR.put(c11458d25, new WG1(c11458d25, new ArrayList(), new ArrayList(), z));
        }
        WG1 wg1 = (WG1) mapR.get(c11458d25);
        if (wg1 != null) {
            wg1.s().addAll(list);
            wg1.q().addAll(list2);
        }
        l0();
        j0(c11458d25, list, list2, z);
    }

    private final void j0(final C11458d25 c11458d25, final List list, List list2, boolean z) {
        C17557nA c17557nAN = this.m.n(c11458d25);
        MessagingOuterClass$RequestDeleteMessage.a aVarNewBuilder = MessagingOuterClass$RequestDeleteMessage.newBuilder();
        C18732p92 c18732p92 = C18732p92.a;
        AbstractC13042fc3.f(c17557nAN);
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.D(c18732p92.y1(c17557nAN)).A(list).B((MessagingStruct$MessagesDeleteDates) MessagingStruct$MessagesDeleteDates.newBuilder().A(list2).a()).C(BoolValue.of(z)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        L(new C22871vx5("/bale.messaging.v2.Messaging/DeleteMessage", generatedMessageLiteA, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.v64
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C23548x64.k0(this.a, c11458d25, list, (Misc$ResponseSeq) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(C23548x64 c23548x64, C11458d25 c11458d25, List list, Misc$ResponseSeq misc$ResponseSeq) {
        List listS;
        AbstractC13042fc3.i(c23548x64, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(list, "$rids");
        JH1 jh1 = c23548x64.o;
        JH1 jh12 = null;
        if (jh1 == null) {
            AbstractC13042fc3.y("deleteStorage");
            jh1 = null;
        }
        if (jh1.r().containsKey(c11458d25)) {
            JH1 jh13 = c23548x64.o;
            if (jh13 == null) {
                AbstractC13042fc3.y("deleteStorage");
            } else {
                jh12 = jh13;
            }
            WG1 wg1 = (WG1) jh12.r().get(c11458d25);
            if (wg1 != null && (listS = wg1.s()) != null) {
                listS.removeAll(list);
            }
            c23548x64.l0();
        }
    }

    private final void l0() {
        InterfaceC8344Vo3 interfaceC8344Vo3G0 = g0();
        JH1 jh1 = this.o;
        if (jh1 == null) {
            AbstractC13042fc3.y("deleteStorage");
            jh1 = null;
        }
        interfaceC8344Vo3G0.e(new C9863ah0(17L, jh1.toByteArray()));
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        JH1 jh1 = this.o;
        if (jh1 == null) {
            AbstractC13042fc3.y("deleteStorage");
            jh1 = null;
        }
        HashMap mapR = jh1.r();
        for (C11458d25 c11458d25 : mapR.keySet()) {
            WG1 wg1 = (WG1) mapR.get(c11458d25);
            if (wg1 != null) {
                AbstractC13042fc3.h(wg1.s(), "getRids(...)");
                if (!r4.isEmpty()) {
                    AbstractC13042fc3.f(c11458d25);
                    List listS = wg1.s();
                    AbstractC13042fc3.h(listS, "getRids(...)");
                    List listQ = wg1.q();
                    AbstractC13042fc3.h(listQ, "getDates(...)");
                    j0(c11458d25, listS, listQ, wg1.u());
                }
            }
        }
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (!(obj instanceof a)) {
            super.m(obj);
        } else {
            a aVar = (a) obj;
            i0(aVar.b(), aVar.c(), aVar.a(), aVar.d());
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        h0();
        b0("sequences_synced");
    }
}
