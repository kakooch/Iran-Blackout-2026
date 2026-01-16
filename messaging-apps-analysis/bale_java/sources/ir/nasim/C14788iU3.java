package ir.nasim;

import ai.bale.proto.MarketOuterClass$ResponseGetCategories;
import ai.bale.proto.MarketOuterClass$ResponseGetCategoryProducts;
import ai.bale.proto.MarketOuterClass$ResponseGetOnboardingStatus;
import ai.bale.proto.MarketStruct$MarketCategory;
import ir.nasim.C14788iU3;
import ir.nasim.core.modules.market.model.Action;
import ir.nasim.core.modules.market.model.GetMarketDataResponse;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.core.modules.market.model.MarketMenu;
import ir.nasim.core.modules.market.model.MarketMenuItem;
import ir.nasim.core.modules.market.model.MarketProductItem;
import ir.nasim.core.modules.market.model.MarketSection;
import ir.nasim.core.modules.market.model.MarketSlideItem;
import ir.nasim.core.modules.market.model.MarketSlider;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.iU3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C14788iU3 extends VW7 implements InterfaceC10952cU3 {
    public static final a g = new a(null);
    public static final int h = 8;
    private static int i;
    private final QQ3 b;
    private final UG7 c;
    private final SettingsModule d;
    private final EP5 e;
    private boolean f;

    /* renamed from: ir.nasim.iU3$a */
    public static final class a {
        private a() {
        }

        public final GetMarketDataResponse a(GetMarketDataResponse getMarketDataResponse) {
            AbstractC13042fc3.i(getMarketDataResponse, "data");
            ArrayList<MarketSlideItem> arrayList = new ArrayList<>();
            for (MarketSlideItem marketSlideItem : getMarketDataResponse.getSlider().getSlides()) {
                if (marketSlideItem.canUseForThisVersionApp()) {
                    arrayList.add(marketSlideItem);
                }
            }
            getMarketDataResponse.getSlider().setSlides(arrayList);
            ArrayList<MarketMenuItem> arrayList2 = new ArrayList<>();
            for (MarketMenuItem marketMenuItem : getMarketDataResponse.getMenu().getItems()) {
                if (marketMenuItem.canUseForThisVersionApp()) {
                    arrayList2.add(marketMenuItem);
                }
            }
            getMarketDataResponse.getMenu().setItems(arrayList2);
            for (MarketSection marketSection : getMarketDataResponse.getMarketRows()) {
                ArrayList<MarketItem> arrayList3 = new ArrayList<>();
                for (MarketItem marketItem : marketSection.getItems()) {
                    if (marketItem.canUseForThisVersionApp()) {
                        arrayList3.add(marketItem);
                    }
                }
                marketSection.setItems(arrayList3);
            }
            for (MarketSection marketSection2 : getMarketDataResponse.getMarketRows()) {
                ArrayList<MarketProductItem> arrayList4 = new ArrayList<>();
                ArrayList<MarketProductItem> products = marketSection2.getProducts();
                if (products != null) {
                    for (MarketProductItem marketProductItem : products) {
                        if (marketProductItem.canUseForThisVersionApp()) {
                            arrayList4.add(marketProductItem);
                        }
                    }
                }
                marketSection2.setProducts(arrayList4);
            }
            return getMarketDataResponse;
        }

        public final int b() {
            return C14788iU3.i;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.iU3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ MarketOuterClass$ResponseGetCategories d;
        final /* synthetic */ int e;
        final /* synthetic */ boolean f;
        final /* synthetic */ C20298rm4 g;

        /* renamed from: ir.nasim.iU3$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C14788iU3 c;
            final /* synthetic */ ArrayList d;
            final /* synthetic */ C20298rm4 e;
            final /* synthetic */ GetMarketDataResponse f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14788iU3 c14788iU3, ArrayList arrayList, C20298rm4 c20298rm4, GetMarketDataResponse getMarketDataResponse, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c14788iU3;
                this.d = arrayList;
                this.e = c20298rm4;
                this.f = getMarketDataResponse;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.d1(this.d, this.e, this.f);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MarketOuterClass$ResponseGetCategories marketOuterClass$ResponseGetCategories, int i, boolean z, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = marketOuterClass$ResponseGetCategories;
            this.e = i;
            this.f = z;
            this.g = c20298rm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14788iU3.this.new b(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ArrayList arrayListA = MarketSlideItem.INSTANCE.a(C14788iU3.this.d.Y2());
            if (arrayListA == null) {
                arrayListA = new ArrayList();
            }
            MarketMenu marketMenu = new MarketMenu(new ArrayList(), "");
            MarketSection.Companion companion = MarketSection.INSTANCE;
            List<MarketStruct$MarketCategory> categoriesList = this.d.getCategoriesList();
            AbstractC13042fc3.h(categoriesList, "getCategoriesList(...)");
            GetMarketDataResponse getMarketDataResponse = new GetMarketDataResponse(this.d.getVersion().getValue(), marketMenu, new MarketSlider(arrayListA), companion.b(categoriesList));
            String jsonString = getMarketDataResponse.toJsonString();
            if (jsonString != null) {
                MarketOuterClass$ResponseGetCategories marketOuterClass$ResponseGetCategories = this.d;
                int i = this.e;
                boolean z = this.f;
                C14788iU3 c14788iU3 = C14788iU3.this;
                C20298rm4 c20298rm4 = this.g;
                boolean z2 = marketOuterClass$ResponseGetCategories.getVersion().getValue() > i || z;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (MarketSection marketSection : getMarketDataResponse.getMarketRows()) {
                    if (marketSection.getCategoryType() == EnumC21325tT3.CategoryItemsType_PRODUCT_ONLY.getNumber() || marketSection.getCategoryType() == EnumC21325tT3.CategoryItemsType_FOR_YOU_PRODUCT_ONLY.getNumber()) {
                        arrayList.add(AbstractC6392Nk0.d(marketSection.getId()));
                    } else if (marketSection.getCategoryType() != EnumC21325tT3.CategoryItemsType_MARKET_ONLY.getNumber()) {
                        arrayList2.add(marketSection);
                    }
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    getMarketDataResponse.getMarketRows().remove((MarketSection) it.next());
                }
                if (z2) {
                    if (!arrayList.isEmpty()) {
                        AbstractC10533bm0.d(AbstractC9773aX7.a(c14788iU3), C12366eV1.c(), null, new a(c14788iU3, arrayList, c20298rm4, getMarketDataResponse, null), 2, null);
                    } else {
                        c14788iU3.b.F(jsonString, getMarketDataResponse.getVersion());
                        c20298rm4.n(new C5354Iz1(C14788iU3.g.a(getMarketDataResponse)));
                    }
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.iU3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C20298rm4 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c20298rm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C14788iU3.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            ArrayList<MarketProductItem> products;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC3570Bk5 interfaceC3570Bk5P = C7183Qq.p();
            C5721Ko c5721Ko = C5721Ko.a;
            if (!interfaceC3570Bk5P.h("mCacheSolver_" + c5721Ko.h(), false)) {
                C14788iU3.this.b.Z();
                C7183Qq.p().g("mCacheSolver_" + c5721Ko.h(), true);
                this.d.n(new C5354Iz1((Throwable) null));
            }
            GetMarketDataResponse getMarketDataResponseL = C14788iU3.this.b.L();
            if (getMarketDataResponseL != null) {
                ArrayList arrayListA = MarketSlideItem.INSTANCE.a(C14788iU3.this.d.Y2());
                if (arrayListA != null) {
                    getMarketDataResponseL.getSlider().setSlides(arrayListA);
                }
                MarketMenu marketMenuA = MarketMenu.INSTANCE.a(C14788iU3.this.d.e3());
                if (marketMenuA != null) {
                    getMarketDataResponseL.setMenu(marketMenuA);
                }
                if ((!getMarketDataResponseL.getMarketRows().get(0).getItems().isEmpty()) || ((products = getMarketDataResponseL.getMarketRows().get(0).getProducts()) != null && (!products.isEmpty()))) {
                    this.d.n(new C5354Iz1(C14788iU3.g.a(getMarketDataResponseL)));
                } else {
                    C14788iU3.this.b.Z();
                    this.d.n(new C5354Iz1((Throwable) null));
                }
            } else {
                this.d.n(new C5354Iz1((Throwable) null));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.iU3$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ GetMarketDataResponse c;
        final /* synthetic */ C14788iU3 d;
        final /* synthetic */ C20298rm4 e;

        /* renamed from: ir.nasim.iU3$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C14788iU3 c;
            final /* synthetic */ ArrayList d;
            final /* synthetic */ C20298rm4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C14788iU3 c14788iU3, ArrayList arrayList, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c14788iU3;
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
                C6517Nv5 c6517Nv5M0 = c6517Nv5S0.m0(new InterfaceC24449ye1() { // from class: ir.nasim.jU3
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj2) {
                        C14788iU3.d.a.z(c20298rm4, (C14505i18) obj2);
                    }
                });
                final C20298rm4 c20298rm42 = this.e;
                c6517Nv5M0.E(new InterfaceC24449ye1() { // from class: ir.nasim.kU3
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj2) {
                        C14788iU3.d.a.D(c20298rm42, (Exception) obj2);
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
        d(GetMarketDataResponse getMarketDataResponse, C14788iU3 c14788iU3, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = getMarketDataResponse;
            this.d = c14788iU3;
            this.e = c20298rm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Long id;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = this.c.getSlider().getSlides().iterator();
            while (it.hasNext()) {
                Action action = ((MarketSlideItem) it.next()).getAction();
                if (action != null && (id = action.getId()) != null) {
                    arrayList.add(new C25238zy((int) id.longValue(), 0L));
                }
            }
            for (MarketSection marketSection : this.c.getMarketRows()) {
                Iterator<T> it2 = marketSection.getItems().iterator();
                while (it2.hasNext()) {
                    arrayList.add(new C25238zy((int) ((MarketItem) it2.next()).getId(), 0L));
                }
                ArrayList<MarketProductItem> products = marketSection.getProducts();
                if (products != null) {
                    for (MarketProductItem marketProductItem : products) {
                        if (marketProductItem.getPost().getGroupId() != null) {
                            Integer groupId = marketProductItem.getPost().getGroupId();
                            AbstractC13042fc3.f(groupId);
                            arrayList.add(new C25238zy(groupId.intValue(), 0L));
                        }
                    }
                }
            }
            AbstractC10533bm0.d(AbstractC9773aX7.a(this.d), C12366eV1.c(), null, new a(this.d, arrayList, this.e, null), 2, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C14788iU3(QQ3 qq3, UG7 ug7, SettingsModule settingsModule, EP5 ep5) {
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
    public static final void a1(C14788iU3 c14788iU3, int i2, boolean z, C20298rm4 c20298rm4, MarketOuterClass$ResponseGetCategories marketOuterClass$ResponseGetCategories) {
        AbstractC13042fc3.i(c14788iU3, "this$0");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        AbstractC10533bm0.d(AbstractC9773aX7.a(c14788iU3), C12366eV1.b(), null, c14788iU3.new b(marketOuterClass$ResponseGetCategories, i2, z, c20298rm4, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1(final ArrayList arrayList, final C20298rm4 c20298rm4, final GetMarketDataResponse getMarketDataResponse) {
        QQ3 qq3 = this.b;
        Object obj = arrayList.get(0);
        AbstractC13042fc3.h(obj, "get(...)");
        qq3.R(((Number) obj).intValue(), 4, 0).m0(new InterfaceC24449ye1() { // from class: ir.nasim.gU3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj2) {
                C14788iU3.e1(getMarketDataResponse, arrayList, this, c20298rm4, (MarketOuterClass$ResponseGetCategoryProducts) obj2);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.hU3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj2) {
                C14788iU3.f1(c20298rm4, (Exception) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(GetMarketDataResponse getMarketDataResponse, ArrayList arrayList, C14788iU3 c14788iU3, C20298rm4 c20298rm4, MarketOuterClass$ResponseGetCategoryProducts marketOuterClass$ResponseGetCategoryProducts) {
        AbstractC13042fc3.i(getMarketDataResponse, "$data");
        AbstractC13042fc3.i(arrayList, "$productRowIds");
        AbstractC13042fc3.i(c14788iU3, "this$0");
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        for (MarketSection marketSection : getMarketDataResponse.getMarketRows()) {
            int id = marketSection.getId();
            Integer num = (Integer) arrayList.get(0);
            if (num != null && id == num.intValue()) {
                MarketProductItem.Companion companion = MarketProductItem.INSTANCE;
                List productsList = marketOuterClass$ResponseGetCategoryProducts.getProductsList();
                AbstractC13042fc3.h(productsList, "getProductsList(...)");
                marketSection.setProducts(companion.b(productsList));
            }
        }
        arrayList.remove(0);
        if (!arrayList.isEmpty()) {
            c14788iU3.d1(arrayList, c20298rm4, getMarketDataResponse);
            return;
        }
        QQ3 qq3 = c14788iU3.b;
        String jsonString = getMarketDataResponse.toJsonString();
        AbstractC13042fc3.f(jsonString);
        qq3.F(jsonString, getMarketDataResponse.getVersion());
        c20298rm4.n(new C5354Iz1(getMarketDataResponse));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(C20298rm4 c20298rm4, C14788iU3 c14788iU3, MarketOuterClass$ResponseGetOnboardingStatus marketOuterClass$ResponseGetOnboardingStatus) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        AbstractC13042fc3.i(c14788iU3, "this$0");
        if (marketOuterClass$ResponseGetOnboardingStatus.getStatus().getNumber() == 0) {
            c20298rm4.n(Boolean.TRUE);
        } else {
            c20298rm4.n(Boolean.FALSE);
            c14788iU3.b.H(marketOuterClass$ResponseGetOnboardingStatus.getStatus().getNumber());
        }
    }

    public androidx.lifecycle.r c1() {
        C20298rm4 c20298rm4 = new C20298rm4();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new c(c20298rm4, null), 2, null);
        return c20298rm4;
    }

    @Override // ir.nasim.InterfaceC10952cU3
    public androidx.lifecycle.r d0(int i2, int i3, int i4, boolean z, final boolean z2) {
        final int iN = this.b.N();
        final C20298rm4 c20298rm4 = new C20298rm4();
        QQ3.P(this.b, i2, i3, iN, false, 8, null).m0(new InterfaceC24449ye1() { // from class: ir.nasim.dU3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C14788iU3.a1(this.a, iN, z2, c20298rm4, (MarketOuterClass$ResponseGetCategories) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.eU3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C14788iU3.b1(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }

    public final boolean g1() {
        return this.f;
    }

    public androidx.lifecycle.r h1(GetMarketDataResponse getMarketDataResponse) {
        AbstractC13042fc3.i(getMarketDataResponse, "data");
        C20298rm4 c20298rm4 = new C20298rm4();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new d(getMarketDataResponse, this, c20298rm4, null), 2, null);
        return c20298rm4;
    }

    public final void i1() {
        int i2 = C7183Qq.p().getInt("counter_of_show_market_fragment", 0) + 1;
        C7183Qq.p().putInt("counter_of_show_market_fragment", i2);
        i = i2;
    }

    public final void j1(String str, int i2, OP5 op5) {
        AbstractC13042fc3.i(str, "reason");
        AbstractC13042fc3.i(op5, "reportType");
        this.e.b(new ExPeer(ExPeerType.CHANNEL, i2), str, op5, P25.c);
    }

    public final void k1(boolean z) {
        this.f = z;
    }

    public androidx.lifecycle.r l1() {
        final C20298rm4 c20298rm4 = new C20298rm4();
        if (this.b.M() > 0) {
            c20298rm4.n(Boolean.FALSE);
        } else {
            this.b.V().m0(new InterfaceC24449ye1() { // from class: ir.nasim.fU3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C14788iU3.m1(c20298rm4, this, (MarketOuterClass$ResponseGetOnboardingStatus) obj);
                }
            });
        }
        return c20298rm4;
    }

    public boolean o1() {
        return false;
    }

    public final boolean p1() {
        return this.b.M() > 0;
    }
}
