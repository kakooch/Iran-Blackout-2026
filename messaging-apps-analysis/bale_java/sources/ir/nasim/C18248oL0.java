package ir.nasim;

import ai.bale.proto.MessagingOuterClass$RequestDeleteChat;
import ai.bale.proto.Misc$ResponseSeq;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.IOException;
import java.util.HashMap;

/* renamed from: ir.nasim.oL0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18248oL0 extends AbstractC6360Ng4 {
    public static final a p = new a(null);
    public static final int q = 8;
    private final C9057Yh4 m;
    private final InterfaceC8344Vo3 n;
    private C21872uH1 o;

    /* renamed from: ir.nasim.oL0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.oL0$b */
    public static final class b implements InterfaceC15283jK {
        private final C11458d25 a;

        public b(C11458d25 c11458d25) {
            AbstractC13042fc3.i(c11458d25, "peer");
            this.a = c11458d25;
        }

        public final C11458d25 a() {
            return this.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C18248oL0(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.n = c9057Yh4.T().C();
        b0("sequences_synced");
    }

    private final C6517Nv5 f0(final C11458d25 c11458d25) {
        this.m.G().T0().E(new C9593aD7(c11458d25));
        GeneratedMessageLite generatedMessageLiteA = MessagingOuterClass$RequestDeleteChat.newBuilder().A(this.m.p(c11458d25)).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5H = M(new C22871vx5("/bale.messaging.v2.Messaging/DeleteChat", generatedMessageLiteA, defaultInstance), 0L).H(new InterfaceC17569nB2() { // from class: ir.nasim.nL0
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C18248oL0.g0(this.a, c11458d25, (Misc$ResponseSeq) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 g0(C18248oL0 c18248oL0, C11458d25 c11458d25, Misc$ResponseSeq misc$ResponseSeq) {
        AbstractC13042fc3.i(c18248oL0, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        C21872uH1 c21872uH1 = c18248oL0.o;
        C21872uH1 c21872uH12 = null;
        if (c21872uH1 == null) {
            AbstractC13042fc3.y("deleteStorage");
            c21872uH1 = null;
        }
        if (c21872uH1.r().containsKey(c11458d25)) {
            C21872uH1 c21872uH13 = c18248oL0.o;
            if (c21872uH13 == null) {
                AbstractC13042fc3.y("deleteStorage");
            } else {
                c21872uH12 = c21872uH13;
            }
            c21872uH12.r().remove(c11458d25);
            c18248oL0.h0();
        }
        return C6517Nv5.l0(C14505i18.a);
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof b) {
            return e0(((b) obj).a());
        }
        C6517Nv5 c6517Nv5G = super.G(obj);
        AbstractC13042fc3.f(c6517Nv5G);
        return c6517Nv5G;
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        C21872uH1 c21872uH1 = this.o;
        if (c21872uH1 == null) {
            AbstractC13042fc3.y("deleteStorage");
            c21872uH1 = null;
        }
        for (C11458d25 c11458d25 : c21872uH1.r().keySet()) {
            AbstractC13042fc3.f(c11458d25);
            f0(c11458d25);
        }
    }

    public final C6517Nv5 e0(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "peer");
        C21872uH1 c21872uH1 = this.o;
        C21872uH1 c21872uH12 = null;
        if (c21872uH1 == null) {
            AbstractC13042fc3.y("deleteStorage");
            c21872uH1 = null;
        }
        if (!c21872uH1.r().containsKey(c11458d25)) {
            C21872uH1 c21872uH13 = this.o;
            if (c21872uH13 == null) {
                AbstractC13042fc3.y("deleteStorage");
            } else {
                c21872uH12 = c21872uH13;
            }
            HashMap mapR = c21872uH12.r();
            AbstractC13042fc3.h(mapR, "getPendingDeletions(...)");
            mapR.put(c11458d25, new C21198tH1(c11458d25));
        }
        h0();
        return f0(c11458d25);
    }

    public final void h0() {
        InterfaceC8344Vo3 interfaceC8344Vo3 = this.n;
        C21872uH1 c21872uH1 = this.o;
        if (c21872uH1 == null) {
            AbstractC13042fc3.y("deleteStorage");
            c21872uH1 = null;
        }
        interfaceC8344Vo3.e(new C9863ah0(20L, c21872uH1.toByteArray()));
    }

    @Override // ir.nasim.K6
    public void o() {
        String name;
        super.o();
        C9863ah0 c9863ah0 = (C9863ah0) this.n.d(20L);
        if (c9863ah0 != null) {
            try {
                this.o = C21872uH1.q(c9863ah0.q());
            } catch (IOException e) {
                if (C18248oL0.class.isAnonymousClass()) {
                    name = C18248oL0.class.getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = C18248oL0.class.getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.c(name, "preStart(readFromBytes)", e);
            }
        }
        if (this.o == null) {
            this.o = new C21872uH1();
        }
    }
}
