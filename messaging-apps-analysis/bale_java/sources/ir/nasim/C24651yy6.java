package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.SharedMedia$RequestGetActiveSharedMedia;
import ai.bale.proto.SharedMedia$ResponseGetActiveSharedMedia;
import ir.nasim.Z06;
import ir.nasim.core.modules.profile.entity.ExPeer;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.yy6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C24651yy6 {
    private final C6287Mz a;
    private final InterfaceC14123hO3 b;
    private final AbstractC13778go1 c;

    /* renamed from: ir.nasim.yy6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ExPeer d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ExPeer exPeer, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = exPeer;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24651yy6.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                SharedMedia$RequestGetActiveSharedMedia sharedMedia$RequestGetActiveSharedMedia = (SharedMedia$RequestGetActiveSharedMedia) SharedMedia$RequestGetActiveSharedMedia.newBuilder().A((PeersStruct$ExPeer) C24651yy6.this.b.a(this.d)).a();
                C6287Mz c6287Mz = C24651yy6.this.a;
                AbstractC13042fc3.f(sharedMedia$RequestGetActiveSharedMedia);
                SharedMedia$ResponseGetActiveSharedMedia defaultInstance = SharedMedia$ResponseGetActiveSharedMedia.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.shared_media.v1.SharedMediaService/GetActiveSharedMedia", sharedMedia$RequestGetActiveSharedMedia, defaultInstance);
                this.b = 1;
                obj = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (!(z06 instanceof Z06.b)) {
                if (z06 instanceof Z06.a) {
                    return AbstractC10360bX0.m();
                }
                throw new NoWhenBranchMatchedException();
            }
            List<EnumC11822dc4> activeTabList = ((SharedMedia$ResponseGetActiveSharedMedia) ((Z06.b) z06).a()).getActiveTabList();
            AbstractC13042fc3.h(activeTabList, "getActiveTabList(...)");
            List<EnumC11822dc4> list = activeTabList;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (EnumC11822dc4 enumC11822dc4 : list) {
                arrayList.add(new C3697By6(C19218py6.a.a(enumC11822dc4.name()), enumC11822dc4.getNumber()));
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C24651yy6(C6287Mz c6287Mz, InterfaceC14123hO3 interfaceC14123hO3, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(interfaceC14123hO3, "exPeerToStructExPeerMapper");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = c6287Mz;
        this.b = interfaceC14123hO3;
        this.c = abstractC13778go1;
    }

    public final Object c(ExPeer exPeer, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.c, new a(exPeer, null), interfaceC20295rm1);
    }
}
