package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ir.nasim.C24366yV3;
import ir.nasim.core.modules.banking.BankingModule;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.payment.data.response.Bank;
import ir.nasim.features.payment.data.response.CardToCardConfig;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Rq1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C7419Rq1 extends VW7 implements InterfaceC5741Kq1 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final BankingModule b;
    private final SettingsModule c;

    /* renamed from: ir.nasim.Rq1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Rq1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ C20298rm4 d;

        /* renamed from: ir.nasim.Rq1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ long c;
            final /* synthetic */ C20298rm4 d;

            /* renamed from: ir.nasim.Rq1$b$a$a, reason: collision with other inner class name */
            public static final class C0601a implements C24366yV3.a {
                final /* synthetic */ C20298rm4 a;

                C0601a(C20298rm4 c20298rm4) {
                    this.a = c20298rm4;
                }

                @Override // ir.nasim.C24366yV3.a
                public void a(ArrayList arrayList) {
                    AbstractC13042fc3.i(arrayList, "factorsList");
                    this.a.n(arrayList);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(long j, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = j;
                this.d = c20298rm4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C24366yV3.a.b(this.c, new C0601a(this.d));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = c20298rm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC13778go1 abstractC13778go1B = C12366eV1.b();
                a aVar = new a(this.c, this.d, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(abstractC13778go1B, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C7419Rq1(BankingModule bankingModule, SettingsModule settingsModule) {
        AbstractC13042fc3.i(bankingModule, "bankingModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = bankingModule;
        this.c = settingsModule;
    }

    private final void W0(List list, C20298rm4 c20298rm4) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            ir.nasim.core.modules.banking.l lVar = (ir.nasim.core.modules.banking.l) obj;
            C20481s50 c20481s50 = C20481s50.a;
            C13466gH0 c13466gH0E = lVar.e();
            AbstractC13042fc3.f(c13466gH0E);
            String name = c13466gH0E.getName();
            AbstractC13042fc3.h(name, "getName(...)");
            String strSubstring = name.substring(0, 6);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            Integer numE = c20481s50.e(AbstractC10360bX0.g(strSubstring));
            if (numE == null) {
                numE = Integer.valueOf(KB5.ic_card_payment_cardunknown_icon_classic);
            }
            int iIntValue = numE.intValue();
            C13466gH0 c13466gH0E2 = lVar.e();
            AbstractC13042fc3.f(c13466gH0E2);
            String name2 = c13466gH0E2.getName();
            AbstractC13042fc3.h(name2, "getName(...)");
            C13466gH0 c13466gH0E3 = lVar.e();
            AbstractC13042fc3.f(c13466gH0E3);
            String name3 = c13466gH0E3.getName();
            AbstractC13042fc3.h(name3, "getName(...)");
            String strE = XY6.e(c20481s50.a(name3));
            C13466gH0 c13466gH0E4 = lVar.e();
            arrayList.add(new H40(lVar, iIntValue, name2, strE, c13466gH0E4 != null ? c13466gH0E4.y() : null, false, false, false, 224, null));
            i = i2;
        }
        b1(arrayList, 0, c20298rm4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(C20298rm4 c20298rm4, List list) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1(Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
        C19406qI3.d("CreateCrowdfundingViewModelImpl", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(C7419Rq1 c7419Rq1, C20298rm4 c20298rm4, List list) {
        AbstractC13042fc3.i(c7419Rq1, "this$0");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        AbstractC13042fc3.f(list);
        if (!list.isEmpty()) {
            c7419Rq1.W0(AbstractC19810qy7.c(list), c20298rm4);
        } else {
            c20298rm4.n(new C5354Iz1(new ArrayList()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
        C19406qI3.d("CreateCrowdfundingViewModelImpl", exc);
    }

    private final void b1(final ArrayList arrayList, final int i, final C20298rm4 c20298rm4) {
        AbstractC20471s40 abstractC20471s40A = ((H40) arrayList.get(i)).a();
        AbstractC13042fc3.g(abstractC20471s40A, "null cannot be cast to non-null type ir.nasim.core.modules.banking.DigitOnlyBankCard");
        this.b.v1(((ir.nasim.core.modules.banking.l) abstractC20471s40A).e()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Pq1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C7419Rq1.c1(arrayList, i, c20298rm4, this, (OG0) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Qq1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C7419Rq1.d1((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(ArrayList arrayList, int i, C20298rm4 c20298rm4, C7419Rq1 c7419Rq1, OG0 og0) {
        AbstractC13042fc3.i(arrayList, "$mList");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        AbstractC13042fc3.i(c7419Rq1, "this$0");
        ((H40) arrayList.get(i)).i(og0.d());
        if (i == arrayList.size() - 1) {
            c20298rm4.n(new C5354Iz1(arrayList));
        } else {
            c7419Rq1.b1(arrayList, i + 1, c20298rm4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(Exception exc) {
        C19406qI3.b("CreateCrowdfundingViewModelImpl", exc.getLocalizedMessage());
    }

    @Override // ir.nasim.InterfaceC5741Kq1
    public void a(long j, long j2, long j3, C16247kx c16247kx) {
        AbstractC13042fc3.i(c16247kx, DialogEntity.COLUMN_MESSAGE);
        BankingModule bankingModule = this.b;
        C11458d25 c11458d25R = C11458d25.r(j);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        bankingModule.o1(c11458d25R, j2, j3, c16247kx);
    }

    @Override // ir.nasim.InterfaceC5741Kq1
    public androidx.lifecycle.r a0(long j) {
        C20298rm4 c20298rm4 = new C20298rm4();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(j, c20298rm4, null), 3, null);
        return c20298rm4;
    }

    @Override // ir.nasim.InterfaceC5741Kq1
    public androidx.lifecycle.r e() {
        C20298rm4 c20298rm4 = new C20298rm4();
        C10410bZ6 c10410bZ6L = AbstractC5969Lp4.c().l();
        c20298rm4.n(c10410bZ6L != null ? (String) c10410bZ6L.b() : null);
        return c20298rm4;
    }

    @Override // ir.nasim.InterfaceC5741Kq1
    public androidx.lifecycle.r getConfig() {
        C20298rm4 c20298rm4 = new C20298rm4();
        CardToCardConfig cardToCardConfig = (CardToCardConfig) new KS2().k(this.c.b1().toString(), CardToCardConfig.class);
        for (Bank bank : cardToCardConfig.getBankList()) {
            Integer numE = C20481s50.a.e(bank.getCardNumberPattern());
            if (numE != null) {
                bank.setDrawableId(numE);
            }
        }
        c20298rm4.n(cardToCardConfig);
        return c20298rm4;
    }

    @Override // ir.nasim.InterfaceC5741Kq1
    public androidx.lifecycle.r h() {
        final C20298rm4 c20298rm4 = new C20298rm4();
        this.b.V1().m0(new InterfaceC24449ye1() { // from class: ir.nasim.Lq1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C7419Rq1.Z0(this.a, c20298rm4, (List) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Mq1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C7419Rq1.a1(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }

    @Override // ir.nasim.InterfaceC5741Kq1
    public void p(Context context, long j, String str, String str2, String str3, String str4, long j2, long j3, long j4, String str5) throws Throwable {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "photoPath");
        AbstractC13042fc3.i(str2, "photoName");
        AbstractC13042fc3.i(str3, "title");
        AbstractC13042fc3.i(str4, "description");
        AbstractC13042fc3.i(str5, "cardNumber");
        Bitmap bitmapDecodeResource = AbstractC13042fc3.d(str2, "empty.jpg") ? BitmapFactory.decodeResource(context.getResources(), KB5.img_crowdfunding_empty) : V13.e(str);
        if (bitmapDecodeResource == null) {
            return;
        }
        Bitmap bitmapO = V13.o(bitmapDecodeResource, 90, 90);
        String strM = C4053Dm2.m("jpg");
        if (strM == null) {
            return;
        }
        V13.f(bitmapDecodeResource, strM);
        C9625aH3 c9625aH3 = new C9625aH3(str2, strM, str3, KN6.r(strM).f(), "image/jpeg", new RG3(new C22694vg2(bitmapO.getWidth(), bitmapO.getHeight(), V13.i(bitmapO))), bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight());
        BankingModule bankingModule = this.b;
        C11458d25 c11458d25R = C11458d25.r(j);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        bankingModule.M2(c11458d25R, c9625aH3, str3, str4, j4, j2, j3, str5);
    }

    @Override // ir.nasim.InterfaceC5741Kq1
    public androidx.lifecycle.r q0(AbstractC20471s40 abstractC20471s40) {
        AbstractC13042fc3.i(abstractC20471s40, "bankCard");
        final C20298rm4 c20298rm4 = new C20298rm4();
        this.b.x2(abstractC20471s40).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Nq1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C7419Rq1.X0(c20298rm4, (List) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.Oq1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C7419Rq1.Y0(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }
}
