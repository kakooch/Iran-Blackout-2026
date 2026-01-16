package ir.nasim;

import ai.bale.proto.RamzOuterClass$RequestCheckPassword;
import ai.bale.proto.RamzOuterClass$RequestCheckPasswordSet;
import ai.bale.proto.RamzOuterClass$RequestDeletePassword;
import ai.bale.proto.RamzOuterClass$RequestForgetPassword;
import ai.bale.proto.RamzOuterClass$RequestSendOtp;
import ai.bale.proto.RamzOuterClass$RequestSetPassword;
import ai.bale.proto.RamzOuterClass$RequestValidateOTP;
import ai.bale.proto.RamzOuterClass$ResponseCheckPassword;
import ai.bale.proto.RamzOuterClass$ResponseCheckPasswordSet;
import ai.bale.proto.RamzOuterClass$ResponseDeletePassword;
import ai.bale.proto.RamzOuterClass$ResponseForgetPassword;
import ai.bale.proto.RamzOuterClass$ResponseSendOtp;
import ai.bale.proto.RamzOuterClass$ResponseSetPassword;
import ai.bale.proto.RamzOuterClass$ResponseValidateOTP;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.QR;
import ir.nasim.Z06;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class MR {
    private static final a d = new a(null);
    private final InterfaceC16847ly a;
    private final AbstractC13778go1 b;
    private final InterfaceC14123hO3 c;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ int d;
        final /* synthetic */ EnumC14053hG5 e;
        final /* synthetic */ MR f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, EnumC14053hG5 enumC14053hG5, MR mr, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = enumC14053hG5;
            this.f = mr;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            MR mr;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = RamzOuterClass$RequestValidateOTP.newBuilder().A(this.d).B(this.e).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                RamzOuterClass$ResponseValidateOTP defaultInstance = RamzOuterClass$ResponseValidateOTP.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.ramz.v1.Ramz/ValidateOTP", generatedMessageLiteA, defaultInstance);
                MR mr2 = this.f;
                InterfaceC16847ly interfaceC16847ly = mr2.a;
                this.b = mr2;
                this.c = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
                mr = mr2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mr = (MR) this.b;
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                return new QR.c(C19938rB7.a);
            }
            if (z06 instanceof Z06.a) {
                return new QR.b((InterfaceC18892pR) mr.c.a(((Z06.a) z06).a()));
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MR.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            MR mr;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                RamzOuterClass$RequestCheckPasswordSet defaultInstance = RamzOuterClass$RequestCheckPasswordSet.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                RamzOuterClass$ResponseCheckPasswordSet defaultInstance2 = RamzOuterClass$ResponseCheckPasswordSet.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.ramz.v1.Ramz/CheckPasswordSet", defaultInstance, defaultInstance2);
                MR mr2 = MR.this;
                InterfaceC16847ly interfaceC16847ly = mr2.a;
                this.b = mr2;
                this.c = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
                mr = mr2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mr = (MR) this.b;
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                RamzOuterClass$ResponseCheckPasswordSet ramzOuterClass$ResponseCheckPasswordSet = (RamzOuterClass$ResponseCheckPasswordSet) ((Z06.b) z06).a();
                return new QR.c(new C19493qS0(ramzOuterClass$ResponseCheckPasswordSet.getHasSet(), ramzOuterClass$ResponseCheckPasswordSet.getIsSessionAuthorized()));
            }
            if (z06 instanceof Z06.a) {
                return new QR.b((InterfaceC18892pR) mr.c.a(((Z06.a) z06).a()));
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ String d;
        final /* synthetic */ EnumC14053hG5 e;
        final /* synthetic */ MR f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, EnumC14053hG5 enumC14053hG5, MR mr, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = enumC14053hG5;
            this.f = mr;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            MR mr;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = RamzOuterClass$RequestCheckPassword.newBuilder().A(this.d).B(this.e).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                RamzOuterClass$ResponseCheckPassword defaultInstance = RamzOuterClass$ResponseCheckPassword.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.ramz.v1.Ramz/CheckPassword", generatedMessageLiteA, defaultInstance);
                MR mr2 = this.f;
                InterfaceC16847ly interfaceC16847ly = mr2.a;
                this.b = mr2;
                this.c = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
                mr = mr2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mr = (MR) this.b;
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                return new QR.c(((RamzOuterClass$ResponseCheckPassword) ((Z06.b) z06).a()).getToken());
            }
            if (z06 instanceof Z06.a) {
                return new QR.b((InterfaceC18892pR) mr.c.a(((Z06.a) z06).a()));
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ int d;
        final /* synthetic */ MR e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(int i, MR mr, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = mr;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            MR mr;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = RamzOuterClass$RequestDeletePassword.newBuilder().A(this.d).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                RamzOuterClass$ResponseDeletePassword defaultInstance = RamzOuterClass$ResponseDeletePassword.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.ramz.v1.Ramz/DeletePassword", generatedMessageLiteA, defaultInstance);
                MR mr2 = this.e;
                InterfaceC16847ly interfaceC16847ly = mr2.a;
                this.b = mr2;
                this.c = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
                mr = mr2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mr = (MR) this.b;
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                return new QR.c(C19938rB7.a);
            }
            if (z06 instanceof Z06.a) {
                return new QR.b((InterfaceC18892pR) mr.c.a(((Z06.a) z06).a()));
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MR.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            MR mr;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                RamzOuterClass$RequestForgetPassword defaultInstance = RamzOuterClass$RequestForgetPassword.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                RamzOuterClass$ResponseForgetPassword defaultInstance2 = RamzOuterClass$ResponseForgetPassword.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.ramz.v1.Ramz/ForgetPassword", defaultInstance, defaultInstance2);
                MR mr2 = MR.this;
                InterfaceC16847ly interfaceC16847ly = mr2.a;
                this.b = mr2;
                this.c = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
                mr = mr2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mr = (MR) this.b;
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                return new QR.c(C19938rB7.a);
            }
            if (z06 instanceof Z06.a) {
                return new QR.b((InterfaceC18892pR) mr.c.a(((Z06.a) z06).a()));
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return MR.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            MR mr;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                RamzOuterClass$RequestSendOtp defaultInstance = RamzOuterClass$RequestSendOtp.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                RamzOuterClass$ResponseSendOtp defaultInstance2 = RamzOuterClass$ResponseSendOtp.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance2, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.ramz.v1.Ramz/SendOTP", defaultInstance, defaultInstance2);
                MR mr2 = MR.this;
                InterfaceC16847ly interfaceC16847ly = mr2.a;
                this.b = mr2;
                this.c = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
                mr = mr2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mr = (MR) this.b;
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                return new QR.c(C19938rB7.a);
            }
            if (z06 instanceof Z06.a) {
                return new QR.b((InterfaceC18892pR) mr.c.a(((Z06.a) z06).a()));
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ String d;
        final /* synthetic */ MR e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, MR mr, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = mr;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            MR mr;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                GeneratedMessageLite generatedMessageLiteA = RamzOuterClass$RequestSetPassword.newBuilder().A(this.d).a();
                AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                RamzOuterClass$ResponseSetPassword defaultInstance = RamzOuterClass$ResponseSetPassword.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                C22871vx5 c22871vx5 = new C22871vx5("/bale.ramz.v1.Ramz/SetPassword", generatedMessageLiteA, defaultInstance);
                MR mr2 = this.e;
                InterfaceC16847ly interfaceC16847ly = mr2.a;
                this.b = mr2;
                this.c = 1;
                obj = InterfaceC16847ly.c(interfaceC16847ly, c22871vx5, 0L, null, this, 6, null);
                if (obj == objE) {
                    return objE;
                }
                mr = mr2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mr = (MR) this.b;
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                return new QR.c(C19938rB7.a);
            }
            if (z06 instanceof Z06.a) {
                return new QR.b((InterfaceC18892pR) mr.c.a(((Z06.a) z06).a()));
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public MR(InterfaceC16847ly interfaceC16847ly, AbstractC13778go1 abstractC13778go1, InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(interfaceC16847ly, "apiGateway");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC14123hO3, "rpcExceptionToAuthenticatorErrorMapper");
        this.a = interfaceC16847ly;
        this.b = abstractC13778go1;
        this.c = interfaceC14123hO3;
    }

    public final Object c(int i, EnumC14053hG5 enumC14053hG5, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new b(i, enumC14053hG5, this, null), interfaceC20295rm1);
    }

    public final Object d(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new c(null), interfaceC20295rm1);
    }

    public final Object e(String str, EnumC14053hG5 enumC14053hG5, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new d(str, enumC14053hG5, this, null), interfaceC20295rm1);
    }

    public final Object f(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new e(i, this, null), interfaceC20295rm1);
    }

    public final Object g(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new f(null), interfaceC20295rm1);
    }

    public final Object h(InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new g(null), interfaceC20295rm1);
    }

    public final Object i(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new h(str, this, null), interfaceC20295rm1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MR(InterfaceC16847ly interfaceC16847ly, AbstractC13778go1 abstractC13778go1) {
        this(interfaceC16847ly, abstractC13778go1, T66.a);
        AbstractC13042fc3.i(interfaceC16847ly, "apiGateway");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
    }
}
