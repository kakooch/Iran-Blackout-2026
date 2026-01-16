package ir.nasim;

import ai.bale.proto.AppzarOuterClass$RequestGetMenuButton;
import ai.bale.proto.AppzarOuterClass$RequestGetMiniAppUrl;
import ai.bale.proto.AppzarOuterClass$RequestInvokeCustomMethod;
import ai.bale.proto.AppzarOuterClass$ResponseGetMenuButton;
import ai.bale.proto.AppzarOuterClass$ResponseInvokeCustomMethod;
import ai.bale.proto.AppzarStruct$BotMenuButton;
import ai.bale.proto.AppzarStruct$DirectLinkMiniAppParams;
import ai.bale.proto.AppzarStruct$KeyboardButtonMiniAppParams;
import ai.bale.proto.AppzarStruct$MainMiniAppParams;
import ai.bale.proto.AppzarStruct$MenuButtonMiniAppParams;
import ai.bale.proto.AppzarStruct$MiniAppThemeParams;
import ai.bale.proto.KetfOuterClass$RequestSendMiniAppData;
import ai.bale.proto.KetfOuterClass$ResponseSendMiniAppData;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.StringValue;
import ir.nasim.C9475a16;
import ir.nasim.T68;
import ir.nasim.Z06;
import ir.nasim.core.network.RpcException;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.w68, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22962w68 implements InterfaceC22366v68 {
    public static final a k = new a(null);
    private final InterfaceC16847ly a;
    private final InterfaceC14123hO3 b;
    private final InterfaceC14123hO3 c;
    private final InterfaceC14123hO3 d;
    private final InterfaceC14123hO3 e;
    private final InterfaceC14123hO3 f;
    private final InterfaceC14123hO3 g;
    private final InterfaceC14123hO3 h;
    private final InterfaceC14123hO3 i;
    private final AbstractC13778go1 j;

    /* renamed from: ir.nasim.w68$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.w68$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            Object objP = C22962w68.this.p(null, this);
            return objP == AbstractC14862ic3.e() ? objP : C9475a16.a(objP);
        }
    }

    /* renamed from: ir.nasim.w68$c */
    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objF = C22962w68.this.f(null, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    /* renamed from: ir.nasim.w68$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ T68.d d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(T68.d dVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = dVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22962w68.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objP;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AppzarOuterClass$RequestGetMiniAppUrl appzarOuterClass$RequestGetMiniAppUrl = (AppzarOuterClass$RequestGetMiniAppUrl) C22962w68.this.q(this.d).C((AppzarStruct$KeyboardButtonMiniAppParams) C22962w68.this.g.a(this.d)).a();
                C22962w68 c22962w68 = C22962w68.this;
                AbstractC13042fc3.f(appzarOuterClass$RequestGetMiniAppUrl);
                this.b = 1;
                objP = c22962w68.p(appzarOuterClass$RequestGetMiniAppUrl, this);
                if (objP == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objP = ((C9475a16) obj).l();
            }
            return C9475a16.a(objP);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.w68$e */
    static final class e extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objB = C22962w68.this.b(null, this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    /* renamed from: ir.nasim.w68$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ T68.b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(T68.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22962w68.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objP;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AppzarOuterClass$RequestGetMiniAppUrl appzarOuterClass$RequestGetMiniAppUrl = (AppzarOuterClass$RequestGetMiniAppUrl) C22962w68.this.q(this.d).D((AppzarStruct$MainMiniAppParams) C22962w68.this.f.a(this.d)).a();
                C22962w68 c22962w68 = C22962w68.this;
                AbstractC13042fc3.f(appzarOuterClass$RequestGetMiniAppUrl);
                this.b = 1;
                objP = c22962w68.p(appzarOuterClass$RequestGetMiniAppUrl, this);
                if (objP == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objP = ((C9475a16) obj).l();
            }
            return C9475a16.a(objP);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.w68$g */
    static final class g extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objG = C22962w68.this.g(0, this);
            return objG == AbstractC14862ic3.e() ? objG : C9475a16.a(objG);
        }
    }

    /* renamed from: ir.nasim.w68$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ C22962w68 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(int i, C22962w68 c22962w68, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = c22962w68;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AppzarOuterClass$RequestGetMenuButton appzarOuterClass$RequestGetMenuButton = (AppzarOuterClass$RequestGetMenuButton) AppzarOuterClass$RequestGetMenuButton.newBuilder().A(this.c).a();
                AbstractC13042fc3.f(appzarOuterClass$RequestGetMenuButton);
                AppzarOuterClass$ResponseGetMenuButton defaultInstance = AppzarOuterClass$ResponseGetMenuButton.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.appzar.v1.Appzar/GetMenuButton", appzarOuterClass$RequestGetMenuButton, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = this.d.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
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
            C22962w68 c22962w68 = this.d;
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                AppzarOuterClass$ResponseGetMenuButton appzarOuterClass$ResponseGetMenuButton = (AppzarOuterClass$ResponseGetMenuButton) ((Z06.b) z06).a();
                InterfaceC14123hO3 interfaceC14123hO3 = c22962w68.b;
                AppzarStruct$BotMenuButton menuButton = appzarOuterClass$ResponseGetMenuButton.getMenuButton();
                AbstractC13042fc3.h(menuButton, "getMenuButton(...)");
                objB = C9475a16.b((AbstractC15729k44) interfaceC14123hO3.a(menuButton));
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.w68$i */
    static final class i extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objE = C22962w68.this.e(null, this);
            return objE == AbstractC14862ic3.e() ? objE : C9475a16.a(objE);
        }
    }

    /* renamed from: ir.nasim.w68$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ T68.c d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(T68.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = cVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22962w68.this.new j(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objP;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AppzarOuterClass$RequestGetMiniAppUrl appzarOuterClass$RequestGetMiniAppUrl = (AppzarOuterClass$RequestGetMiniAppUrl) C22962w68.this.q(this.d).E((AppzarStruct$MenuButtonMiniAppParams) C22962w68.this.e.a(this.d)).a();
                C22962w68 c22962w68 = C22962w68.this;
                AbstractC13042fc3.f(appzarOuterClass$RequestGetMiniAppUrl);
                this.b = 1;
                objP = c22962w68.p(appzarOuterClass$RequestGetMiniAppUrl, this);
                if (objP == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objP = ((C9475a16) obj).l();
            }
            return C9475a16.a(objP);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.w68$k */
    static final class k extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objD = C22962w68.this.d(null, this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    /* renamed from: ir.nasim.w68$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ T68.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(T68.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = aVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22962w68.this.new l(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objP;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AppzarOuterClass$RequestGetMiniAppUrl appzarOuterClass$RequestGetMiniAppUrl = (AppzarOuterClass$RequestGetMiniAppUrl) C22962w68.this.q(this.d).B((AppzarStruct$DirectLinkMiniAppParams) C22962w68.this.h.a(this.d)).a();
                C22962w68 c22962w68 = C22962w68.this;
                AbstractC13042fc3.f(appzarOuterClass$RequestGetMiniAppUrl);
                this.b = 1;
                objP = c22962w68.p(appzarOuterClass$RequestGetMiniAppUrl, this);
                if (objP == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objP = ((C9475a16) obj).l();
            }
            return C9475a16.a(objP);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.w68$m */
    static final class m extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA = C22962w68.this.a(0, null, null, this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.w68$n */
    static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ C22962w68 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(int i, String str, String str2, C22962w68 c22962w68, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = str;
            this.e = str2;
            this.f = c22962w68;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new n(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AppzarOuterClass$RequestInvokeCustomMethod appzarOuterClass$RequestInvokeCustomMethod = (AppzarOuterClass$RequestInvokeCustomMethod) AppzarOuterClass$RequestInvokeCustomMethod.newBuilder().A(this.c).B(this.d).C(this.e).a();
                AbstractC13042fc3.f(appzarOuterClass$RequestInvokeCustomMethod);
                AppzarOuterClass$ResponseInvokeCustomMethod defaultInstance = AppzarOuterClass$ResponseInvokeCustomMethod.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.appzar.v1.Appzar/InvokeCustomMethod", appzarOuterClass$RequestInvokeCustomMethod, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = this.f.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
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
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(((AppzarOuterClass$ResponseInvokeCustomMethod) ((Z06.b) z06).a()).getData());
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.w68$o */
    static final class o extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objC = C22962w68.this.c(0, null, null, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    /* renamed from: ir.nasim.w68$p */
    static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ C22962w68 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(int i, String str, String str2, C22962w68 c22962w68, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = i;
            this.d = str;
            this.e = str2;
            this.f = c22962w68;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new p(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                KetfOuterClass$RequestSendMiniAppData.a aVarB = KetfOuterClass$RequestSendMiniAppData.newBuilder().A(this.c).B((StringValue) StringValue.newBuilder().A(this.d).a());
                StringValue.b bVarNewBuilder = StringValue.newBuilder();
                String str = this.e;
                if (str == null) {
                    str = "";
                }
                KetfOuterClass$RequestSendMiniAppData ketfOuterClass$RequestSendMiniAppData = (KetfOuterClass$RequestSendMiniAppData) aVarB.C((StringValue) bVarNewBuilder.A(str).a()).a();
                AbstractC13042fc3.f(ketfOuterClass$RequestSendMiniAppData);
                KetfOuterClass$ResponseSendMiniAppData defaultInstance = KetfOuterClass$ResponseSendMiniAppData.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.ketf.v1.Ketf/SendMiniAppData", ketfOuterClass$RequestSendMiniAppData, defaultInstance);
                InterfaceC16847ly interfaceC16847ly = this.f.a;
                this.b = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
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
            if (z06 instanceof Z06.a) {
                RpcException rpcExceptionA = ((Z06.a) z06).a();
                C9475a16.a aVar = C9475a16.b;
                objB = C9475a16.b(AbstractC10685c16.a(rpcExceptionA));
            } else {
                if (!(z06 instanceof Z06.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                C9475a16.a aVar2 = C9475a16.b;
                objB = C9475a16.b(C19938rB7.a);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C22962w68(InterfaceC16847ly interfaceC16847ly, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC14123hO3 interfaceC14123hO32, InterfaceC14123hO3 interfaceC14123hO33, InterfaceC14123hO3 interfaceC14123hO34, InterfaceC14123hO3 interfaceC14123hO35, InterfaceC14123hO3 interfaceC14123hO36, InterfaceC14123hO3 interfaceC14123hO37, InterfaceC14123hO3 interfaceC14123hO38, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC16847ly, "apiGateWay");
        AbstractC13042fc3.i(interfaceC14123hO3, "apiMenuButtonToMenuButton");
        AbstractC13042fc3.i(interfaceC14123hO32, "webAppScreenModeToApiWebAppScreenMode");
        AbstractC13042fc3.i(interfaceC14123hO33, "webAppThemeParamsToApiWebAppThemeParams");
        AbstractC13042fc3.i(interfaceC14123hO34, "webAppMenuRequestToApiWebAppMenuRequest");
        AbstractC13042fc3.i(interfaceC14123hO35, "webAppMainRequestToApiWebAppMainRequest");
        AbstractC13042fc3.i(interfaceC14123hO36, "webAppLinkRequestToApiWebAppKeyboardButtonRequest");
        AbstractC13042fc3.i(interfaceC14123hO37, "webAppLinkRequestToApiWebAppDirectLinkButtonRequest");
        AbstractC13042fc3.i(interfaceC14123hO38, "apiWebAppUrlToWebAppUrl");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = interfaceC16847ly;
        this.b = interfaceC14123hO3;
        this.c = interfaceC14123hO32;
        this.d = interfaceC14123hO33;
        this.e = interfaceC14123hO34;
        this.f = interfaceC14123hO35;
        this.g = interfaceC14123hO36;
        this.h = interfaceC14123hO37;
        this.i = interfaceC14123hO38;
        this.j = abstractC13778go1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(ai.bale.proto.AppzarOuterClass$RequestGetMiniAppUrl r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C22962w68.b
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.w68$b r0 = (ir.nasim.C22962w68.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.d = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.w68$b r0 = new ir.nasim.w68$b
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.d
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r10 = r6.a
            ir.nasim.w68 r10 = (ir.nasim.C22962w68) r10
            ir.nasim.AbstractC10685c16.b(r11)
            goto L5e
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.vx5 r11 = new ir.nasim.vx5
            ai.bale.proto.AppzarOuterClass$ResponseGetMiniAppUrl r1 = ai.bale.proto.AppzarOuterClass$ResponseGetMiniAppUrl.getDefaultInstance()
            java.lang.String r3 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            java.lang.String r3 = "/bale.appzar.v1.Appzar/GetMiniAppUrl"
            r11.<init>(r3, r10, r1)
            ir.nasim.ly r1 = r9.a
            r6.a = r9
            r6.d = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r11
            java.lang.Object r11 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r11 != r0) goto L5d
            return r0
        L5d:
            r10 = r9
        L5e:
            ir.nasim.Z06 r11 = (ir.nasim.Z06) r11
            boolean r0 = r11 instanceof ir.nasim.Z06.a
            if (r0 == 0) goto L75
            ir.nasim.Z06$a r11 = (ir.nasim.Z06.a) r11
            ir.nasim.core.network.RpcException r10 = r11.a()
            ir.nasim.a16$a r11 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto L92
        L75:
            boolean r0 = r11 instanceof ir.nasim.Z06.b
            if (r0 == 0) goto L93
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r11 = (ir.nasim.Z06.b) r11
            com.google.protobuf.P r11 = r11.a()
            ai.bale.proto.AppzarOuterClass$ResponseGetMiniAppUrl r11 = (ai.bale.proto.AppzarOuterClass$ResponseGetMiniAppUrl) r11
            ir.nasim.hO3 r10 = r10.i
            ir.nasim.AbstractC13042fc3.f(r11)
            java.lang.Object r10 = r10.a(r11)
            ir.nasim.S68 r10 = (ir.nasim.S68) r10
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        L92:
            return r10
        L93:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22962w68.p(ai.bale.proto.AppzarOuterClass$RequestGetMiniAppUrl, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppzarOuterClass$RequestGetMiniAppUrl.a q(T68 t68) {
        AppzarOuterClass$RequestGetMiniAppUrl.a aVarG = AppzarOuterClass$RequestGetMiniAppUrl.newBuilder().A(t68.a()).F((CG) this.c.a(t68.b())).G((AppzarStruct$MiniAppThemeParams) this.d.a(t68.c()));
        AbstractC13042fc3.h(aVarG, "setThemeParams(...)");
        return aVarG;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC22366v68
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(int r11, java.lang.String r12, java.lang.String r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof ir.nasim.C22962w68.m
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.w68$m r0 = (ir.nasim.C22962w68.m) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.w68$m r0 = new ir.nasim.w68$m
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r14)
            goto L4a
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.go1 r14 = r10.j
            ir.nasim.w68$n r2 = new ir.nasim.w68$n
            r9 = 0
            r4 = r2
            r5 = r11
            r6 = r12
            r7 = r13
            r8 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            r0.c = r3
            java.lang.Object r14 = ir.nasim.AbstractC9323Zl0.g(r14, r2, r0)
            if (r14 != r1) goto L4a
            return r1
        L4a:
            ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
            java.lang.Object r11 = r14.l()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22962w68.a(int, java.lang.String, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC22366v68
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.T68.b r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C22962w68.e
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.w68$e r0 = (ir.nasim.C22962w68.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.w68$e r0 = new ir.nasim.w68$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.j
            ir.nasim.w68$f r2 = new ir.nasim.w68$f
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22962w68.b(ir.nasim.T68$b, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC22366v68
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(int r11, java.lang.String r12, java.lang.String r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof ir.nasim.C22962w68.o
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.w68$o r0 = (ir.nasim.C22962w68.o) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.w68$o r0 = new ir.nasim.w68$o
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r14)
            goto L4a
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.go1 r14 = r10.j
            ir.nasim.w68$p r2 = new ir.nasim.w68$p
            r9 = 0
            r4 = r2
            r5 = r11
            r6 = r12
            r7 = r13
            r8 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            r0.c = r3
            java.lang.Object r14 = ir.nasim.AbstractC9323Zl0.g(r14, r2, r0)
            if (r14 != r1) goto L4a
            return r1
        L4a:
            ir.nasim.a16 r14 = (ir.nasim.C9475a16) r14
            java.lang.Object r11 = r14.l()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22962w68.c(int, java.lang.String, java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC22366v68
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(ir.nasim.T68.a r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C22962w68.k
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.w68$k r0 = (ir.nasim.C22962w68.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.w68$k r0 = new ir.nasim.w68$k
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.j
            ir.nasim.w68$l r2 = new ir.nasim.w68$l
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22962w68.d(ir.nasim.T68$a, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC22366v68
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(ir.nasim.T68.c r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C22962w68.i
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.w68$i r0 = (ir.nasim.C22962w68.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.w68$i r0 = new ir.nasim.w68$i
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.j
            ir.nasim.w68$j r2 = new ir.nasim.w68$j
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22962w68.e(ir.nasim.T68$c, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC22366v68
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(ir.nasim.T68.d r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C22962w68.c
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.w68$c r0 = (ir.nasim.C22962w68.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.w68$c r0 = new ir.nasim.w68$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.j
            ir.nasim.w68$d r2 = new ir.nasim.w68$d
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22962w68.f(ir.nasim.T68$d, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC22366v68
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.C22962w68.g
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.w68$g r0 = (ir.nasim.C22962w68.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.w68$g r0 = new ir.nasim.w68$g
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.go1 r7 = r5.j
            ir.nasim.w68$h r2 = new ir.nasim.w68$h
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.c = r3
            java.lang.Object r7 = ir.nasim.AbstractC9323Zl0.g(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r7 = (ir.nasim.C9475a16) r7
            java.lang.Object r6 = r7.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22962w68.g(int, ir.nasim.rm1):java.lang.Object");
    }
}
