package ir.nasim;

import ai.bale.proto.MessagingOuterClass$RequestMessageRead;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PeersStruct$ExPeer;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.Jw1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5561Jw1 extends AbstractC20395rw1 {
    private final C9057Yh4 q;

    /* renamed from: ir.nasim.Jw1$a */
    public static final class a {
        private final C11458d25 a;
        private final long b;

        public a(C11458d25 c11458d25, long j) {
            AbstractC13042fc3.i(c11458d25, "peer");
            this.a = c11458d25;
            this.b = j;
        }

        public final long a() {
            return this.b;
        }

        public final C11458d25 b() {
            return this.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5561Jw1(C9057Yh4 c9057Yh4) {
        super(19L, c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.q = c9057Yh4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(C5561Jw1 c5561Jw1, C11458d25 c11458d25, long j, Misc$ResponseVoid misc$ResponseVoid) {
        AbstractC13042fc3.i(c5561Jw1, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        c5561Jw1.e0(c11458d25, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(C5561Jw1 c5561Jw1, C11458d25 c11458d25, long j, Exception exc) {
        AbstractC13042fc3.i(c5561Jw1, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        c5561Jw1.f0(c11458d25, j);
    }

    @Override // ir.nasim.AbstractC20395rw1
    protected void h0(final C11458d25 c11458d25, final long j) {
        AbstractC13042fc3.i(c11458d25, "peer");
        PeersStruct$ExPeer peersStruct$ExPeerL = this.q.l(c11458d25);
        if (peersStruct$ExPeerL == null) {
            return;
        }
        GeneratedMessageLite generatedMessageLiteA = MessagingOuterClass$RequestMessageRead.newBuilder().B(peersStruct$ExPeerL).A(j).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        L(new C22871vx5("/bale.messaging.v2.Messaging/MessageRead", generatedMessageLiteA, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Hw1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C5561Jw1.l0(this.a, c11458d25, j, (Misc$ResponseVoid) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Iw1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C5561Jw1.m0(this.a, c11458d25, j, (Exception) obj);
            }
        });
    }

    @Override // ir.nasim.AbstractC20395rw1, ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (!(obj instanceof a)) {
            super.m(obj);
        } else {
            a aVar = (a) obj;
            d0(aVar.b(), aVar.a());
        }
    }
}
