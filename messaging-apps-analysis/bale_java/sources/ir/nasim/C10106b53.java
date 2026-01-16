package ir.nasim;

import ai.bale.proto.ConfigsOuterClass$RequestGetInAppUpdate;
import ai.bale.proto.ConfigsOuterClass$ResponseGetInAppUpdate;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.Z06;
import ir.nasim.core.network.RpcException;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.b53, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10106b53 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final C6287Mz a;
    private final AbstractC13778go1 b;

    /* renamed from: ir.nasim.b53$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.b53$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ com.google.protobuf.P d;
        final /* synthetic */ com.google.protobuf.P e;
        final /* synthetic */ C10106b53 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, com.google.protobuf.P p, com.google.protobuf.P p2, C10106b53 c10106b53, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = p;
            this.e = p2;
            this.f = c10106b53;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C22871vx5 c22871vx5 = new C22871vx5(this.c, this.d, this.e);
                C6287Mz c6287Mz = this.f.a;
                this.b = 1;
                obj = AbstractC6547Nz.c(c6287Mz, c22871vx5, (2 & 2) != 0 ? 16500L : 0L, 16500, 2, 2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.b53$c */
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
            Object objD = C10106b53.this.d(this);
            return objD == AbstractC14862ic3.e() ? objD : C9475a16.a(objD);
        }
    }

    /* renamed from: ir.nasim.b53$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C10106b53.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objB;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ConfigsOuterClass$RequestGetInAppUpdate configsOuterClass$RequestGetInAppUpdate = (ConfigsOuterClass$RequestGetInAppUpdate) ConfigsOuterClass$RequestGetInAppUpdate.newBuilder().a();
                C10106b53 c10106b53 = C10106b53.this;
                AbstractC13042fc3.f(configsOuterClass$RequestGetInAppUpdate);
                ConfigsOuterClass$ResponseGetInAppUpdate defaultInstance = ConfigsOuterClass$ResponseGetInAppUpdate.getDefaultInstance();
                AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
                this.b = 1;
                obj = c10106b53.c("/bale.v1.Configs/GetInAppUpdate", configsOuterClass$RequestGetInAppUpdate, defaultInstance, this);
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
                ConfigsOuterClass$ResponseGetInAppUpdate configsOuterClass$ResponseGetInAppUpdate = (ConfigsOuterClass$ResponseGetInAppUpdate) ((Z06.b) z06).a();
                C19406qI3.a("inAppUpdate", "get InAppUpdateInfo successful", new Object[0]);
                objB = C9475a16.b(configsOuterClass$ResponseGetInAppUpdate);
            }
            Throwable thE = C9475a16.e(objB);
            if (thE != null) {
                C19406qI3.c("inAppUpdate", "get InAppUpdateInfo failed", thE);
            }
            return C9475a16.a(objB);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C10106b53(C6287Mz c6287Mz, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c6287Mz, "apiGateway");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = c6287Mz;
        this.b = abstractC13778go1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object c(String str, com.google.protobuf.P p, com.google.protobuf.P p2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new b(str, p, p2, this, null), interfaceC20295rm1);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.C10106b53.c
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.b53$c r0 = (ir.nasim.C10106b53.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.b53$c r0 = new ir.nasim.b53$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.go1 r6 = r5.b
            ir.nasim.b53$d r2 = new ir.nasim.b53$d
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r6 = ir.nasim.AbstractC9323Zl0.g(r6, r2, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
            java.lang.Object r6 = r6.l()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C10106b53.d(ir.nasim.rm1):java.lang.Object");
    }
}
