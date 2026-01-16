package ir.nasim;

import ai.bale.proto.GroupsOuterClass$RequestGetMutualGroups;
import ai.bale.proto.GroupsOuterClass$ResponseGetMutualGroups;
import ai.bale.proto.PeersStruct$GroupOutPeer;
import ai.bale.proto.PeersStruct$UserOutPeer;
import ir.nasim.Z06;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.xn4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C23952xn4 {
    public static final a e = new a(null);
    public static final int f = 8;
    private final C11458d25 a;
    private final C6287Mz b;
    private final AbstractC13778go1 c;
    private final DM2 d;

    /* renamed from: ir.nasim.xn4$a */
    public static final class a {

        /* renamed from: ir.nasim.xn4$a$a, reason: collision with other inner class name */
        public interface InterfaceC1774a {
            C23952xn4 a(C11458d25 c11458d25);
        }

        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.xn4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C23952xn4.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GroupsOuterClass$RequestGetMutualGroups groupsOuterClass$RequestGetMutualGroups = (GroupsOuterClass$RequestGetMutualGroups) GroupsOuterClass$RequestGetMutualGroups.newBuilder().A((PeersStruct$UserOutPeer) PeersStruct$UserOutPeer.newBuilder().B((int) C23952xn4.this.a.u()).a()).a();
                C6287Mz c6287Mz = C23952xn4.this.b;
                AbstractC13042fc3.f(groupsOuterClass$RequestGetMutualGroups);
                GroupsOuterClass$ResponseGetMutualGroups defaultInstance = GroupsOuterClass$ResponseGetMutualGroups.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.groups.v1.Groups/GetMutualGroups", groupsOuterClass$RequestGetMutualGroups, defaultInstance);
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
                return AbstractC10360bX0.m();
            }
            List<PeersStruct$GroupOutPeer> groupsList = ((GroupsOuterClass$ResponseGetMutualGroups) ((Z06.b) z06).a()).getGroupsList();
            AbstractC13042fc3.h(groupsList, "getGroupsList(...)");
            C23952xn4 c23952xn4 = C23952xn4.this;
            ArrayList arrayList = new ArrayList();
            for (PeersStruct$GroupOutPeer peersStruct$GroupOutPeer : groupsList) {
                DM2 dm2 = c23952xn4.d;
                AbstractC13042fc3.f(peersStruct$GroupOutPeer);
                C21586tn4 c21586tn4A = dm2.a(peersStruct$GroupOutPeer);
                if (c21586tn4A != null) {
                    arrayList.add(c21586tn4A);
                }
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C23952xn4(C11458d25 c11458d25, C6287Mz c6287Mz, AbstractC13778go1 abstractC13778go1, DM2 dm2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(dm2, "mapper");
        this.a = c11458d25;
        this.b = c6287Mz;
        this.c = abstractC13778go1;
        this.d = dm2;
    }

    public final Object d(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.c, new b(null), interfaceC20295rm1);
    }
}
