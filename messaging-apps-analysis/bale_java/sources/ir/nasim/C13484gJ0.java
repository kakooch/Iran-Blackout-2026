package ir.nasim;

import ai.bale.proto.KifpoolOuterClass$ResponseGetMyKifpools;
import ai.bale.proto.KifpoolStruct$Kifpool;
import android.content.Context;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC20864sk;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.gJ0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13484gJ0 extends VW7 {
    public static final a k = new a(null);
    public static final int l = 8;
    private final InterfaceC11621dJ7 b;
    private final Context c;
    private final BankingModule d;
    private final SettingsModule e;
    private final InterfaceC9336Zm4 f;
    private final InterfaceC9336Zm4 g;
    private final InterfaceC9336Zm4 h;
    private final InterfaceC9336Zm4 i;
    private String j;

    /* renamed from: ir.nasim.gJ0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.gJ0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13484gJ0.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objD;
            Object value2;
            Object value3;
            Object value4;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C13484gJ0.this.g;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, AbstractC20864sk.c.a));
                C6517Nv5 c6517Nv5G1 = C13484gJ0.this.d.G1();
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5G1, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            C13484gJ0 c13484gJ0 = C13484gJ0.this;
            Throwable thE = C9475a16.e(objD);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = c13484gJ0.g;
                do {
                    value4 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value4, new AbstractC20864sk.a(thE)));
            }
            C13484gJ0 c13484gJ02 = C13484gJ0.this;
            if (C9475a16.j(objD)) {
                List<KifpoolStruct$Kifpool> myWalletsList = ((KifpoolOuterClass$ResponseGetMyKifpools) objD).getMyWalletsList();
                AbstractC13042fc3.f(myWalletsList);
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : myWalletsList) {
                    if (!((KifpoolStruct$Kifpool) obj2).getIsMerchant()) {
                        arrayList.add(obj2);
                    }
                }
                int size = arrayList.size();
                long balance = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    KifpoolStruct$Kifpool kifpoolStruct$Kifpool = (KifpoolStruct$Kifpool) arrayList.get(i2);
                    if (kifpoolStruct$Kifpool.getBalance() > balance) {
                        balance = kifpoolStruct$Kifpool.getBalance();
                    }
                }
                InterfaceC9336Zm4 interfaceC9336Zm43 = c13484gJ02.g;
                do {
                    value3 = interfaceC9336Zm43.getValue();
                } while (!interfaceC9336Zm43.f(value3, new AbstractC20864sk.d(balance, c13484gJ02.e.U3() < balance)));
            }
            C13484gJ0 c13484gJ03 = C13484gJ0.this;
            if (C9475a16.e(objD) != null) {
                InterfaceC9336Zm4 interfaceC9336Zm44 = c13484gJ03.g;
                do {
                    value2 = interfaceC9336Zm44.getValue();
                } while (!interfaceC9336Zm44.f(value2, new AbstractC20864sk.d(-1L, false)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gJ0$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13484gJ0.this.new c(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objL;
            Object value2;
            C13967h73 c13967h73;
            boolean z;
            String string;
            Object value3;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C13484gJ0.this.h;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C13967h73.b((C13967h73) value, true, null, null, null, 14, null)));
                InterfaceC11621dJ7 interfaceC11621dJ7 = C13484gJ0.this.b;
                long j = this.d;
                this.b = 1;
                Object objH = interfaceC11621dJ7.h(j, this);
                if (objH == objE) {
                    return objE;
                }
                objL = objH;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objL = ((C9475a16) obj).l();
            }
            C13484gJ0 c13484gJ0 = C13484gJ0.this;
            SA2 sa2 = this.e;
            long j2 = this.d;
            if (C9475a16.j(objL)) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = c13484gJ0.h;
                do {
                    value3 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value3, C13967h73.b((C13967h73) value3, false, null, null, null, 14, null)));
                InterfaceC9336Zm4 interfaceC9336Zm43 = c13484gJ0.i;
                while (true) {
                    Object value4 = interfaceC9336Zm43.getValue();
                    C23726xP7 c23726xP7 = (C23726xP7) value4;
                    String string2 = c13484gJ0.c.getString(QD5.validate_phone_number_title, c13484gJ0.a1());
                    AbstractC13042fc3.h(string2, "getString(...)");
                    InterfaceC9336Zm4 interfaceC9336Zm44 = interfaceC9336Zm43;
                    long j3 = j2;
                    if (interfaceC9336Zm44.f(value4, c23726xP7.a((78 & 1) != 0 ? c23726xP7.a : string2, (78 & 2) != 0 ? c23726xP7.b : false, (78 & 4) != 0 ? c23726xP7.c : null, (78 & 8) != 0 ? c23726xP7.d : null, (78 & 16) != 0 ? c23726xP7.e : 50000L, (78 & 32) != 0 ? c23726xP7.f : j2, (78 & 64) != 0 ? c23726xP7.g : false))) {
                        break;
                    }
                    interfaceC9336Zm43 = interfaceC9336Zm44;
                    j2 = j3;
                }
                sa2.invoke();
            }
            C13484gJ0 c13484gJ02 = C13484gJ0.this;
            Throwable thE = C9475a16.e(objL);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm45 = c13484gJ02.h;
                do {
                    value2 = interfaceC9336Zm45.getValue();
                    c13967h73 = (C13967h73) value2;
                    String message = thE.getMessage();
                    if (message != null) {
                        z = true;
                        if (AbstractC20762sZ6.X(message, "USER_ALREADY_EXISTS", false, 2, null)) {
                            string = c13484gJ02.c.getString(AbstractC12217eE5.auth_error_user_exist);
                        }
                    } else {
                        z = true;
                    }
                    String message2 = thE.getMessage();
                    string = (message2 == null || AbstractC20762sZ6.X(message2, "PHONE_NUMBER_INVALID", false, 2, null) != z) ? c13484gJ02.c.getString(AbstractC12217eE5.auth_error_unknown) : c13484gJ02.c.getString(AbstractC12217eE5.auth_error_phone_number_invalid);
                } while (!interfaceC9336Zm45.f(value2, C13967h73.b(c13967h73, false, string, null, null, 12, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gJ0$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.f = str;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13484gJ0.this.new d(this.f, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instructions count: 313
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13484gJ0.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C13484gJ0(InterfaceC11621dJ7 interfaceC11621dJ7, Context context, BankingModule bankingModule, SettingsModule settingsModule) {
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = interfaceC11621dJ7;
        this.c = context;
        this.d = bankingModule;
        this.e = settingsModule;
        this.f = AbstractC12281eL6.a("");
        this.g = AbstractC12281eL6.a(AbstractC20864sk.b.a);
        this.h = AbstractC12281eL6.a(new C13967h73(false, null, null, null, 15, null));
        this.i = AbstractC12281eL6.a(new C23726xP7(null, false, null, null, 0L, 0L, false, 127, null));
        this.j = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a1() {
        if (AbstractC13042fc3.d(AbstractC12152e76.b(((C13967h73) Z0().getValue()).d().c()), AbstractC12152e76.b("98"))) {
            return AbstractC12152e76.b("0") + AbstractC20762sZ6.C0(((C13967h73) Z0().getValue()).d().f(), AbstractC12152e76.b("0"));
        }
        return ((C13967h73) Z0().getValue()).d().c() + AbstractC20762sZ6.C0(((C13967h73) Z0().getValue()).d().f(), AbstractC12152e76.b("0"));
    }

    public static /* synthetic */ InterfaceC13730gj3 g1(C13484gJ0 c13484gJ0, long j, SA2 sa2, int i, Object obj) {
        if ((i & 2) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.fJ0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C13484gJ0.h1();
                }
            };
        }
        return c13484gJ0.f1(j, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h1() {
        return C19938rB7.a;
    }

    public final InterfaceC10258bL6 Z0() {
        return AbstractC6459Nq2.c(this.h);
    }

    public final InterfaceC10258bL6 b1() {
        return AbstractC6459Nq2.c(this.f);
    }

    public final InterfaceC10258bL6 c1() {
        return AbstractC6459Nq2.c(this.i);
    }

    public final InterfaceC13730gj3 d1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(null), 3, null);
    }

    public final InterfaceC10258bL6 e1() {
        return AbstractC6459Nq2.c(this.g);
    }

    public final InterfaceC13730gj3 f1(long j, SA2 sa2) {
        AbstractC13042fc3.i(sa2, "onSuccess");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(j, sa2, null), 3, null);
    }

    public final void i1() {
        Object value;
        C23726xP7 c23726xP7;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
            c23726xP7 = (C23726xP7) value;
        } while (!interfaceC9336Zm4.f(value, c23726xP7.a((78 & 1) != 0 ? c23726xP7.a : null, (78 & 2) != 0 ? c23726xP7.b : false, (78 & 4) != 0 ? c23726xP7.c : null, (78 & 8) != 0 ? c23726xP7.d : null, (78 & 16) != 0 ? c23726xP7.e : 0L, (78 & 32) != 0 ? c23726xP7.f : 0L, (78 & 64) != 0 ? c23726xP7.g : false)));
    }

    public final void j1() {
        Object value;
        C23726xP7 c23726xP7;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
            c23726xP7 = (C23726xP7) value;
        } while (!interfaceC9336Zm4.f(value, c23726xP7.a((78 & 1) != 0 ? c23726xP7.a : null, (78 & 2) != 0 ? c23726xP7.b : false, (78 & 4) != 0 ? c23726xP7.c : null, (78 & 8) != 0 ? c23726xP7.d : null, (78 & 16) != 0 ? c23726xP7.e : c23726xP7.e() - AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, (78 & 32) != 0 ? c23726xP7.f : 0L, (78 & 64) != 0 ? c23726xP7.g : false)));
    }

    public final void k1(String str, String str2, String str3) {
        Object value;
        C13967h73 c13967h73;
        AbstractC13042fc3.i(str, "countryCode");
        AbstractC13042fc3.i(str2, "countryName");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            c13967h73 = (C13967h73) value;
        } while (!interfaceC9336Zm4.f(value, C13967h73.b(c13967h73, false, null, null, V75.b(c13967h73.d(), str, str2, null, str3, 4, null), 7, null)));
    }

    public final void l1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "query");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, str));
    }

    public final void m1(String str) {
        Object value;
        C13967h73 c13967h73;
        AbstractC13042fc3.i(str, "phoneNumber");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
            c13967h73 = (C13967h73) value;
        } while (!interfaceC9336Zm4.f(value, C13967h73.b(c13967h73, false, null, null, V75.b(c13967h73.d(), null, null, AbstractC12152e76.b(ZY6.a(str)), null, 11, null), 5, null)));
    }

    public final void o1(String str) {
        Object value;
        C23726xP7 c23726xP7;
        AbstractC13042fc3.i(str, "code");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.i;
        do {
            value = interfaceC9336Zm4.getValue();
            c23726xP7 = (C23726xP7) value;
            if (str.length() == 5 && !AbstractC13042fc3.d(GY6.b(this.j), GY6.b(str))) {
                p1(GY6.b(AbstractC20762sZ6.n1(str).toString()));
                this.j = str;
            }
        } while (!interfaceC9336Zm4.f(value, c23726xP7.a((78 & 1) != 0 ? c23726xP7.a : null, (78 & 2) != 0 ? c23726xP7.b : false, (78 & 4) != 0 ? c23726xP7.c : null, (78 & 8) != 0 ? c23726xP7.d : AbstractC12152e76.b(ZY6.a(str)), (78 & 16) != 0 ? c23726xP7.e : 0L, (78 & 32) != 0 ? c23726xP7.f : 0L, (78 & 64) != 0 ? c23726xP7.g : false)));
    }

    public final InterfaceC13730gj3 p1(String str) {
        AbstractC13042fc3.i(str, "code");
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(str, null), 3, null);
    }
}
