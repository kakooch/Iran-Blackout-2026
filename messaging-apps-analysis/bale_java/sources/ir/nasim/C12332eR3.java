package ir.nasim;

import ai.bale.proto.MarketOuterClass$ResponseGetCategoryMarkets;
import ai.bale.proto.MarketOuterClass$ResponseGetCategoryProducts;
import ai.bale.proto.MarketStruct$MarketItem;
import ai.bale.proto.MarketStruct$Product;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C12332eR3;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.core.modules.market.model.MarketProductItem;
import ir.nasim.core.modules.market.model.ProductPagination;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.eR3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C12332eR3 extends VW7 implements XQ3 {
    private final QQ3 b;
    private final UG7 c;
    private final SettingsModule d;
    private final EP5 e;

    /* renamed from: ir.nasim.eR3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ArrayList c;
        final /* synthetic */ C12332eR3 d;
        final /* synthetic */ C20298rm4 e;

        /* renamed from: ir.nasim.eR3$a$a, reason: collision with other inner class name */
        static final class C1051a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C12332eR3 c;
            final /* synthetic */ ArrayList d;
            final /* synthetic */ C20298rm4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1051a(C12332eR3 c12332eR3, ArrayList arrayList, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c12332eR3;
                this.d = arrayList;
                this.e = c20298rm4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void D(C20298rm4 c20298rm4, Exception exc) {
                c20298rm4.n(new C5354Iz1((Throwable) exc));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void z(C20298rm4 c20298rm4, C14505i18 c14505i18) {
                c20298rm4.n(new C5354Iz1(Boolean.TRUE));
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1051a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5S0 = this.c.c.s0(new ArrayList(), this.d);
                final C20298rm4 c20298rm4 = this.e;
                C6517Nv5 c6517Nv5M0 = c6517Nv5S0.m0(new InterfaceC24449ye1() { // from class: ir.nasim.cR3
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj2) {
                        C12332eR3.a.C1051a.z(c20298rm4, (C14505i18) obj2);
                    }
                });
                final C20298rm4 c20298rm42 = this.e;
                c6517Nv5M0.E(new InterfaceC24449ye1() { // from class: ir.nasim.dR3
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj2) {
                        C12332eR3.a.C1051a.D(c20298rm42, (Exception) obj2);
                    }
                });
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1051a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ArrayList arrayList, C12332eR3 c12332eR3, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = arrayList;
            this.d = c12332eR3;
            this.e = c20298rm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                arrayList.add(new C25238zy((int) ((MarketItem) it.next()).getId(), 0L));
            }
            AbstractC10533bm0.d(AbstractC9773aX7.a(this.d), C12366eV1.c(), null, new C1051a(this.d, arrayList, this.e, null), 2, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.eR3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ArrayList c;
        final /* synthetic */ C12332eR3 d;
        final /* synthetic */ C20298rm4 e;

        /* renamed from: ir.nasim.eR3$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C12332eR3 c;
            final /* synthetic */ ArrayList d;
            final /* synthetic */ C20298rm4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12332eR3 c12332eR3, ArrayList arrayList, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c12332eR3;
                this.d = arrayList;
                this.e = c20298rm4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void D(C20298rm4 c20298rm4, Exception exc) {
                c20298rm4.n(new C5354Iz1((Throwable) exc));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void z(C20298rm4 c20298rm4, C14505i18 c14505i18) {
                c20298rm4.n(new C5354Iz1(Boolean.TRUE));
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5S0 = this.c.c.s0(new ArrayList(), this.d);
                final C20298rm4 c20298rm4 = this.e;
                C6517Nv5 c6517Nv5M0 = c6517Nv5S0.m0(new InterfaceC24449ye1() { // from class: ir.nasim.fR3
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj2) {
                        C12332eR3.b.a.z(c20298rm4, (C14505i18) obj2);
                    }
                });
                final C20298rm4 c20298rm42 = this.e;
                c6517Nv5M0.E(new InterfaceC24449ye1() { // from class: ir.nasim.gR3
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj2) {
                        C12332eR3.b.a.D(c20298rm42, (Exception) obj2);
                    }
                });
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ArrayList arrayList, C12332eR3 c12332eR3, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = arrayList;
            this.d = c12332eR3;
            this.e = c20298rm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ArrayList arrayList = new ArrayList();
            for (MarketProductItem marketProductItem : this.c) {
                if (marketProductItem.getPost().getGroupId() != null) {
                    Integer groupId = marketProductItem.getPost().getGroupId();
                    AbstractC13042fc3.f(groupId);
                    arrayList.add(new C25238zy(groupId.intValue(), 0L));
                }
            }
            AbstractC10533bm0.d(AbstractC9773aX7.a(this.d), C12366eV1.c(), null, new a(this.d, arrayList, this.e, null), 2, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C12332eR3(QQ3 qq3, UG7 ug7, SettingsModule settingsModule, EP5 ep5) {
        AbstractC13042fc3.i(qq3, "marketModule");
        AbstractC13042fc3.i(ug7, "updatesModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(ep5, "reportPeerUseCase");
        this.b = qq3;
        this.c = ug7;
        this.d = settingsModule;
        this.e = ep5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(C12332eR3 c12332eR3, C20298rm4 c20298rm4, MarketOuterClass$ResponseGetCategoryMarkets marketOuterClass$ResponseGetCategoryMarkets) {
        AbstractC13042fc3.i(c12332eR3, "this$0");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        MarketItem.Companion companion = MarketItem.INSTANCE;
        List<MarketStruct$MarketItem> marketsList = marketOuterClass$ResponseGetCategoryMarkets.getMarketsList();
        AbstractC13042fc3.h(marketsList, "getMarketsList(...)");
        ArrayList arrayListB = companion.b(marketsList);
        if (c12332eR3.d.B5(EnumC4716Gg2.G)) {
            Collections.shuffle(arrayListB);
        }
        c20298rm4.n(new C5354Iz1(arrayListB));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(C20298rm4 c20298rm4, MarketOuterClass$ResponseGetCategoryProducts marketOuterClass$ResponseGetCategoryProducts) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        MarketProductItem.Companion companion = MarketProductItem.INSTANCE;
        List<MarketStruct$Product> productsList = marketOuterClass$ResponseGetCategoryProducts.getProductsList();
        AbstractC13042fc3.h(productsList, "getProductsList(...)");
        c20298rm4.n(new C5354Iz1(companion.b(productsList)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    public void V0() {
        this.b.K();
    }

    public androidx.lifecycle.r W0(int i, int i2, int i3) {
        final C20298rm4 c20298rm4 = new C20298rm4();
        this.b.Q(i, i2, i3).m0(new InterfaceC24449ye1() { // from class: ir.nasim.aR3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C12332eR3.X0(this.a, c20298rm4, (MarketOuterClass$ResponseGetCategoryMarkets) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.bR3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C12332eR3.Y0(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }

    public androidx.lifecycle.r Z0(int i, int i2, int i3) {
        final C20298rm4 c20298rm4 = new C20298rm4();
        this.b.R(i, i2, i3).m0(new InterfaceC24449ye1() { // from class: ir.nasim.YQ3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C12332eR3.a1(c20298rm4, (MarketOuterClass$ResponseGetCategoryProducts) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.ZQ3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C12332eR3.b1(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }

    public int c1() {
        ProductPagination productPaginationU;
        if (!this.d.B5(EnumC4716Gg2.J) || (productPaginationU = this.b.U()) == null) {
            return 0;
        }
        long j = 60;
        if ((((System.currentTimeMillis() - productPaginationU.getDate()) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) / j) / j >= this.d.a3()) {
            return 0;
        }
        return productPaginationU.getPage();
    }

    public androidx.lifecycle.r d1(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "list");
        C20298rm4 c20298rm4 = new C20298rm4();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new a(arrayList, this, c20298rm4, null), 2, null);
        return c20298rm4;
    }

    public androidx.lifecycle.r e1(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "list");
        C20298rm4 c20298rm4 = new C20298rm4();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new b(arrayList, this, c20298rm4, null), 2, null);
        return c20298rm4;
    }

    @Override // ir.nasim.XQ3
    public void f0(int i, boolean z) {
        if (this.d.B5(EnumC4716Gg2.J)) {
            ProductPagination productPaginationU = this.b.U();
            if (z || productPaginationU == null) {
                this.b.G(new ProductPagination(System.currentTimeMillis(), i));
            } else {
                this.b.G(new ProductPagination(productPaginationU.getDate(), i));
            }
        }
    }

    public final void f1(String str, int i, OP5 op5) {
        AbstractC13042fc3.i(str, "reason");
        AbstractC13042fc3.i(op5, "reportType");
        this.e.b(new ExPeer(ExPeerType.CHANNEL, i), str, op5, P25.c);
    }

    public boolean g1() {
        return this.b.k0();
    }
}
