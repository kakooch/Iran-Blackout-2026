package ir.nasim;

import ai.bale.proto.GarsonOuterClass$RequestGetServices;
import ai.bale.proto.GarsonOuterClass$ResponseGetServices;
import androidx.recyclerview.widget.RecyclerView;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.C9475a16;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.features.payment.data.model.BankCreditCard;
import java.util.List;

/* renamed from: ir.nasim.st6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20961st6 {
    public static final a c = new a(null);
    public static final int d = BankingModule.m | C6287Mz.e;
    private final C6287Mz a;
    private final BankingModule b;

    /* renamed from: ir.nasim.st6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.st6$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objA = C20961st6.this.a(this);
            return objA == AbstractC14862ic3.e() ? objA : C9475a16.a(objA);
        }
    }

    /* renamed from: ir.nasim.st6$c */
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
            Object objB = C20961st6.this.b(this);
            return objB == AbstractC14862ic3.e() ? objB : C9475a16.a(objB);
        }
    }

    /* renamed from: ir.nasim.st6$d */
    static final class d extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objC = C20961st6.this.c(null, this);
            return objC == AbstractC14862ic3.e() ? objC : C9475a16.a(objC);
        }
    }

    /* renamed from: ir.nasim.st6$e */
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
            Object objF = C20961st6.this.f(this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    public C20961st6(C6287Mz c6287Mz, BankingModule bankingModule) {
        AbstractC13042fc3.i(c6287Mz, "apiModule");
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        this.a = c6287Mz;
        this.b = bankingModule;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C20961st6.b
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.st6$b r0 = (ir.nasim.C20961st6.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.st6$b r0 = new ir.nasim.st6$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
            java.lang.Object r5 = r5.l()
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.core.modules.banking.BankingModule r5 = r4.b
            ir.nasim.Nv5 r5 = r5.R1()
            r0.c = r3
            r2 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20961st6.a(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof ir.nasim.C20961st6.c
            if (r0 == 0) goto L14
            r0 = r10
            ir.nasim.st6$c r0 = (ir.nasim.C20961st6.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.st6$c r0 = new ir.nasim.st6$c
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r10)
            goto L64
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L33:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.vx5 r10 = new ir.nasim.vx5
            ai.bale.proto.Balebank$RequestGetBalance$a r1 = ai.bale.proto.Balebank$RequestGetBalance.newBuilder()
            com.google.protobuf.GeneratedMessageLite r1 = r1.a()
            java.lang.String r3 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            ai.bale.proto.Balebank$ResponseGetBalance r3 = ai.bale.proto.Balebank$ResponseGetBalance.getDefaultInstance()
            java.lang.String r4 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            java.lang.String r4 = "/bale.balebank.v1.GoldWallet/GetBalance"
            r10.<init>(r4, r1, r3)
            ir.nasim.Mz r1 = r9.a
            r6.c = r2
            r3 = 16500(0x4074, double:8.152E-320)
            r5 = 0
            r7 = 4
            r8 = 0
            r2 = r10
            java.lang.Object r10 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r10 != r0) goto L64
            return r0
        L64:
            ir.nasim.Z06 r10 = (ir.nasim.Z06) r10
            boolean r0 = r10 instanceof ir.nasim.Z06.a
            if (r0 == 0) goto L7b
            ir.nasim.Z06$a r10 = (ir.nasim.Z06.a) r10
            ir.nasim.core.network.RpcException r10 = r10.a()
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            java.lang.Object r10 = ir.nasim.AbstractC10685c16.a(r10)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
            goto L95
        L7b:
            boolean r0 = r10 instanceof ir.nasim.Z06.b
            if (r0 == 0) goto L96
            ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r10 = (ir.nasim.Z06.b) r10
            com.google.protobuf.P r10 = r10.a()
            ai.bale.proto.Balebank$ResponseGetBalance r10 = (ai.bale.proto.Balebank$ResponseGetBalance) r10
            long r0 = r10.getBalance()
            java.lang.Long r10 = ir.nasim.AbstractC6392Nk0.e(r0)
            java.lang.Object r10 = ir.nasim.C9475a16.b(r10)
        L95:
            return r10
        L96:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20961st6.b(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ir.nasim.C20961st6.d
            if (r0 == 0) goto L14
            r0 = r9
            ir.nasim.st6$d r0 = (ir.nasim.C20961st6.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.st6$d r0 = new ir.nasim.st6$d
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            ir.nasim.AbstractC10685c16.b(r9)
            goto L66
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.vx5 r9 = new ir.nasim.vx5
            ai.bale.proto.Balebank$RequestGetBalance$a r1 = ai.bale.proto.Balebank$RequestGetBalance.newBuilder()
            com.google.protobuf.GeneratedMessageLite r1 = r1.a()
            java.lang.String r3 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            ai.bale.proto.Balebank$ResponseGetBalance r3 = ai.bale.proto.Balebank$ResponseGetBalance.getDefaultInstance()
            java.lang.String r4 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            java.lang.String r4 = "/bale.balebank.v1.GoldWallet/GetBalance"
            r9.<init>(r4, r1, r3)
            ir.nasim.ka r5 = new ir.nasim.ka
            r5.<init>(r8)
            ir.nasim.Mz r1 = r7.a
            r6.c = r2
            r3 = 16500(0x4074, double:8.152E-320)
            r2 = r9
            java.lang.Object r9 = r1.j(r2, r3, r5, r6)
            if (r9 != r0) goto L66
            return r0
        L66:
            ir.nasim.Z06 r9 = (ir.nasim.Z06) r9
            boolean r8 = r9 instanceof ir.nasim.Z06.a
            if (r8 == 0) goto L7d
            ir.nasim.Z06$a r9 = (ir.nasim.Z06.a) r9
            ir.nasim.core.network.RpcException r8 = r9.a()
            ir.nasim.a16$a r9 = ir.nasim.C9475a16.b
            java.lang.Object r8 = ir.nasim.AbstractC10685c16.a(r8)
            java.lang.Object r8 = ir.nasim.C9475a16.b(r8)
            goto L97
        L7d:
            boolean r8 = r9 instanceof ir.nasim.Z06.b
            if (r8 == 0) goto L98
            ir.nasim.a16$a r8 = ir.nasim.C9475a16.b
            ir.nasim.Z06$b r9 = (ir.nasim.Z06.b) r9
            com.google.protobuf.P r8 = r9.a()
            ai.bale.proto.Balebank$ResponseGetBalance r8 = (ai.bale.proto.Balebank$ResponseGetBalance) r8
            long r8 = r8.getBalance()
            java.lang.Long r8 = ir.nasim.AbstractC6392Nk0.e(r8)
            java.lang.Object r8 = ir.nasim.C9475a16.b(r8)
        L97:
            return r8
        L98:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20961st6.c(java.lang.String, ir.nasim.rm1):java.lang.Object");
    }

    public final Object d() {
        C9475a16.a aVar = C9475a16.b;
        return C9475a16.b(this.b.Z1(BankCreditCard.c.a));
    }

    public final Object e(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        GeneratedMessageLite generatedMessageLiteA = GarsonOuterClass$RequestGetServices.newBuilder().A(i).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        GarsonOuterClass$ResponseGetServices defaultInstance = GarsonOuterClass$ResponseGetServices.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        return InterfaceC16847ly.c(this.a, new C22871vx5("/bale.garson.v1.Garson/GetServices", generatedMessageLiteA, defaultInstance), 16500L, null, interfaceC20295rm1, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(ir.nasim.InterfaceC20295rm1 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ir.nasim.C20961st6.e
            if (r0 == 0) goto L13
            r0 = r5
            ir.nasim.st6$e r0 = (ir.nasim.C20961st6.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.st6$e r0 = new ir.nasim.st6$e
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.a16 r5 = (ir.nasim.C9475a16) r5
            java.lang.Object r5 = r5.l()
            goto L4a
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            ir.nasim.AbstractC10685c16.b(r5)
            ir.nasim.core.modules.banking.BankingModule r5 = r4.b
            ir.nasim.Nv5 r5 = r5.G1()
            r0.c = r3
            r2 = 0
            java.lang.Object r5 = ir.nasim.AbstractC6756Ov5.d(r5, r2, r0, r3, r2)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20961st6.f(ir.nasim.rm1):java.lang.Object");
    }

    public final void g(List list) {
        AbstractC13042fc3.i(list, "bankCreditCards");
        this.b.L2(list, BankCreditCard.c.a);
    }
}
