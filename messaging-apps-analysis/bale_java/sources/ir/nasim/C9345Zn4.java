package ir.nasim;

import ai.bale.mxb.Mxb$RequestRegisterToMXB;
import ai.bale.mxb.Mxb$RequestSearchPuppetUsers;
import ai.bale.mxb.Mxb$RequestUnregisterToMXB;
import ai.bale.mxb.Mxb$ResponseRegisterToMXB;
import ai.bale.mxb.Mxb$ResponseSearchPuppetUsers;
import ai.bale.mxb.Mxb$ResponseUnregisterToMXB;
import ai.bale.proto.UsersStruct$PuppetGroup;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.core.network.RpcException;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Zn4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C9345Zn4 extends AbstractC6360Ng4 {
    public static final a p = new a(null);
    public static final int q = 8;
    private final C9057Yh4 m;
    private final InterfaceC9173Yu3 n;
    private final InterfaceC9173Yu3 o;

    /* renamed from: ir.nasim.Zn4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Zn4$b */
    public static final class b implements InterfaceC15283jK {
    }

    /* renamed from: ir.nasim.Zn4$c */
    public static final class c implements InterfaceC15283jK {
        private final String a;

        public c(String str) {
            AbstractC13042fc3.i(str, "query");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Zn4$d */
    public static final class d implements InterfaceC15283jK {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9345Zn4(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.n = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Rn4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C9345Zn4.o0();
            }
        });
        this.o = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Sn4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C9345Zn4.n0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(Exception exc) {
        AbstractC13042fc3.i(exc, "error");
        C19406qI3.j("MxpActor", "unregisterToMXB error: " + exc.getMessage(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14600iB n0() {
        return new C14600iB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15793kB o0() {
        return new C15793kB();
    }

    private final C14600iB p0() {
        return (C14600iB) this.o.getValue();
    }

    private final C6517Nv5 q0() {
        Mxb$RequestRegisterToMXB defaultInstance = Mxb$RequestRegisterToMXB.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        Mxb$ResponseRegisterToMXB defaultInstance2 = Mxb$ResponseRegisterToMXB.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/ai.bale.mxb.MXB/RegisterToMXB", defaultInstance, defaultInstance2)).H(new InterfaceC17569nB2() { // from class: ir.nasim.Vn4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C9345Zn4.r0((Mxb$ResponseRegisterToMXB) obj);
            }
        }).G(new InterfaceC17569nB2() { // from class: ir.nasim.Wn4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C9345Zn4.s0((Exception) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Xn4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C9345Zn4.t0(this.a, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Yn4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C9345Zn4.u0((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 r0(Mxb$ResponseRegisterToMXB mxb$ResponseRegisterToMXB) {
        return C6517Nv5.l0(C14505i18.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 s0(Exception exc) {
        return ((exc instanceof RpcException) && AbstractC13042fc3.d("user already exists", ((RpcException) exc).getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String())) ? C6517Nv5.l0(C14505i18.a) : C6517Nv5.F(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(C9345Zn4 c9345Zn4, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c9345Zn4, "this$0");
        c9345Zn4.m.S().p7(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(Exception exc) {
        AbstractC13042fc3.i(exc, "error");
        C19406qI3.j("MxpActor", "registerToMXB error: " + exc.getMessage(), new Object[0]);
    }

    private final C6517Nv5 v0(String str) {
        GeneratedMessageLite generatedMessageLiteA = Mxb$RequestSearchPuppetUsers.newBuilder().A(str).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Mxb$ResponseSearchPuppetUsers defaultInstance = Mxb$ResponseSearchPuppetUsers.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/ai.bale.mxb.MXB/SearchPuppetUsers", generatedMessageLiteA, defaultInstance)).H(new InterfaceC17569nB2() { // from class: ir.nasim.Tn4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C9345Zn4.w0(this.a, (Mxb$ResponseSearchPuppetUsers) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Un4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C9345Zn4.x0((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 w0(C9345Zn4 c9345Zn4, Mxb$ResponseSearchPuppetUsers mxb$ResponseSearchPuppetUsers) {
        ArrayList arrayList;
        List<UsersStruct$PuppetGroup> puppetGroupsList;
        AbstractC13042fc3.i(c9345Zn4, "this$0");
        if (mxb$ResponseSearchPuppetUsers == null || (puppetGroupsList = mxb$ResponseSearchPuppetUsers.getPuppetGroupsList()) == null) {
            arrayList = null;
        } else {
            List<UsersStruct$PuppetGroup> list = puppetGroupsList;
            C14600iB c14600iBP0 = c9345Zn4.p0();
            arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(c14600iBP0.a((UsersStruct$PuppetGroup) it.next()));
            }
        }
        return C6517Nv5.l0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(Exception exc) {
        AbstractC13042fc3.i(exc, "error");
        C19406qI3.j("MxpActor", "searchPuppetUsers error: " + exc.getMessage(), new Object[0]);
    }

    private final C6517Nv5 y0() {
        Mxb$RequestUnregisterToMXB defaultInstance = Mxb$RequestUnregisterToMXB.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        Mxb$ResponseUnregisterToMXB defaultInstance2 = Mxb$ResponseUnregisterToMXB.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/ai.bale.mxb.MXB/UnregisterToMXB", defaultInstance, defaultInstance2)).H(new InterfaceC17569nB2() { // from class: ir.nasim.Pn4
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C9345Zn4.z0(this.a, (Mxb$ResponseUnregisterToMXB) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Qn4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C9345Zn4.A0((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 z0(C9345Zn4 c9345Zn4, Mxb$ResponseUnregisterToMXB mxb$ResponseUnregisterToMXB) {
        AbstractC13042fc3.i(c9345Zn4, "this$0");
        c9345Zn4.m.S().p7(false);
        return C6517Nv5.l0(C14505i18.a);
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof b) {
            return q0();
        }
        if (obj instanceof d) {
            return y0();
        }
        if (obj instanceof c) {
            return v0(((c) obj).a());
        }
        C6517Nv5 c6517Nv5G = super.G(obj);
        AbstractC13042fc3.h(c6517Nv5G, "onAsk(...)");
        return c6517Nv5G;
    }
}
