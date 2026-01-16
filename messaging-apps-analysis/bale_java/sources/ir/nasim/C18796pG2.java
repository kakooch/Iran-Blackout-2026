package ir.nasim;

import ai.bale.mxb.Mxb$RequestGetUserPuppets;
import ai.bale.mxb.Mxb$ResponseGetUserPuppets;
import ai.bale.proto.UsersStruct$PuppetUser;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.Z06;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.pG2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18796pG2 {
    private final C6287Mz a;
    private final AbstractC13778go1 b;
    private final InterfaceC9173Yu3 c;

    /* renamed from: ir.nasim.pG2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C18796pG2.this.new a(this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C18796pG2 c18796pG2;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Long lQ = AbstractC19562qZ6.q(C18796pG2.this.h(this.e));
                if (lQ == null) {
                    return AbstractC10360bX0.m();
                }
                GeneratedMessageLite generatedMessageLiteA = Mxb$RequestGetUserPuppets.newBuilder().A(lQ.longValue()).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                Mxb$ResponseGetUserPuppets defaultInstance = Mxb$ResponseGetUserPuppets.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/ai.bale.mxb.MXB/GetUserPuppets", generatedMessageLiteA, defaultInstance);
                C18796pG2 c18796pG22 = C18796pG2.this;
                C6287Mz c6287Mz = c18796pG22.a;
                this.b = c18796pG22;
                this.c = 1;
                Object objC = InterfaceC16847ly.c(c6287Mz, c22871vx5, 0L, null, this, 6, null);
                if (objC == objE) {
                    return objE;
                }
                c18796pG2 = c18796pG22;
                obj = objC;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c18796pG2 = (C18796pG2) this.b;
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (!(z06 instanceof Z06.b)) {
                if (z06 instanceof Z06.a) {
                    return AbstractC10360bX0.m();
                }
                throw new NoWhenBranchMatchedException();
            }
            List<UsersStruct$PuppetUser> puppetUsersList = ((Mxb$ResponseGetUserPuppets) ((Z06.b) z06).a()).getPuppetUsersList();
            AbstractC13042fc3.h(puppetUsersList, "getPuppetUsersList(...)");
            List<UsersStruct$PuppetUser> list = puppetUsersList;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (UsersStruct$PuppetUser usersStruct$PuppetUser : list) {
                C15793kB c15793kBF = c18796pG2.f();
                AbstractC13042fc3.f(usersStruct$PuppetUser);
                arrayList.add(c15793kBF.a(usersStruct$PuppetUser));
            }
            return arrayList;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C18796pG2(C6287Mz c6287Mz, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = c6287Mz;
        this.b = abstractC13778go1;
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.oG2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C18796pG2.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15793kB e() {
        return new C15793kB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C15793kB f() {
        return (C15793kB) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h(String str) {
        return AbstractC20153rZ6.S(str, "0", false, 2, null) ? AbstractC20153rZ6.O(str, "0", "98", false, 4, null) : AbstractC20153rZ6.S(str, GY6.a("0"), false, 2, null) ? AbstractC20153rZ6.O(str, GY6.a("0"), GY6.a("98"), false, 4, null) : str;
    }

    public final Object g(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new a(str, null), interfaceC20295rm1);
    }
}
