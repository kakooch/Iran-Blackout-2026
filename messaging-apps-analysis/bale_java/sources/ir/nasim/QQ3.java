package ir.nasim;

import ai.bale.proto.SearchOuterClass$ResponseSearchMarket;
import ai.bale.proto.SearchOuterClass$ResponseSearchProduct;
import com.google.protobuf.AbstractC2383g;
import ir.nasim.C10489bh6;
import ir.nasim.C22698vg6;
import ir.nasim.SO3;
import ir.nasim.core.modules.market.model.GetMarketDataResponse;
import ir.nasim.core.modules.market.model.ProductPagination;

/* loaded from: classes5.dex */
public final class QQ3 extends AbstractC21707u0 {
    public static final a e = new a(null);
    public static final int f = 8;
    private static final String g = "market_onboarding_status_" + C5721Ko.a.h();
    private final C9057Yh4 b;
    private final InterfaceC9173Yu3 c;
    private final InterfaceC9173Yu3 d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQ3(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.NQ3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return QQ3.Y(this.a);
            }
        });
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.OQ3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return QQ3.X(this.a);
            }
        });
    }

    private final C9528a7 I() {
        C9528a7 c9528a7F = C12736f7.n().f("actor/market", C4614Fw5.d(new V6() { // from class: ir.nasim.PQ3
            @Override // ir.nasim.V6
            public final K6 create() {
                return QQ3.J(this.a);
            }
        }));
        AbstractC13042fc3.h(c9528a7F, "actorOf(...)");
        return c9528a7F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 J(QQ3 qq3) {
        AbstractC13042fc3.i(qq3, "this$0");
        return new RO3(qq3.b);
    }

    public static /* synthetic */ C6517Nv5 P(QQ3 qq3, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        if ((i4 & 8) != 0) {
            z = true;
        }
        return qq3.O(i, i2, i3, z);
    }

    private final C9528a7 S() {
        return (C9528a7) this.c.getValue();
    }

    private final SO3 T() {
        return (SO3) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SO3 X(QQ3 qq3) {
        AbstractC13042fc3.i(qq3, "this$0");
        return new SO3(qq3.S());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C9528a7 Y(QQ3 qq3) {
        AbstractC13042fc3.i(qq3, "this$0");
        return qq3.I();
    }

    public static /* synthetic */ C6517Nv5 d0(QQ3 qq3, String str, boolean z, byte[] bArr, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            bArr = null;
        }
        return qq3.c0(str, z, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 e0(SearchOuterClass$ResponseSearchMarket searchOuterClass$ResponseSearchMarket) {
        C22698vg6.a aVar = C22698vg6.d;
        AbstractC13042fc3.f(searchOuterClass$ResponseSearchMarket);
        return C6517Nv5.l0(aVar.a(searchOuterClass$ResponseSearchMarket));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C6517Nv5 g0(SearchOuterClass$ResponseSearchProduct searchOuterClass$ResponseSearchProduct) {
        C10489bh6.a aVar = C10489bh6.d;
        AbstractC13042fc3.f(searchOuterClass$ResponseSearchProduct);
        return C6517Nv5.l0(aVar.a(searchOuterClass$ResponseSearchProduct));
    }

    public final void F(String str, int i) {
        AbstractC13042fc3.i(str, "data");
        C7183Qq.p().putInt("_market_data_version", i);
        C7183Qq.p().putString("_market_data", str);
    }

    public final void G(ProductPagination productPagination) {
        AbstractC13042fc3.i(productPagination, "productPagination");
        C7183Qq.p().putString("more_items_pagination_date", new KS2().t(productPagination));
    }

    public final void H(int i) {
        C7183Qq.p().putInt(g, i);
    }

    public final void K() {
        C7183Qq.p().g("for_you_category_feedback", false);
    }

    public final GetMarketDataResponse L() {
        String strE = C7183Qq.p().e("_market_data");
        if (strE == null) {
            return null;
        }
        try {
            return GetMarketDataResponse.INSTANCE.a(strE);
        } catch (Exception e2) {
            C7183Qq.p().remove("_market_data");
            C7183Qq.p().remove("_market_data_version");
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            return null;
        }
    }

    public final int M() {
        return C7183Qq.p().getInt(g, -1);
    }

    public final int N() {
        return C7183Qq.p().getInt("_market_data_version", 0);
    }

    public final C6517Nv5 O(int i, int i2, int i3, boolean z) {
        return T().j(new SO3.a(i, i2, i3, z));
    }

    public final C6517Nv5 Q(int i, int i2, int i3) {
        return T().k(new SO3.b(i, i2, i3));
    }

    public final C6517Nv5 R(int i, int i2, int i3) {
        return T().l(new SO3.c(i, i2, i3));
    }

    public final ProductPagination U() {
        String string = C7183Qq.p().getString("more_items_pagination_date", null);
        if (string == null) {
            return null;
        }
        return ProductPagination.INSTANCE.a(string);
    }

    public final C6517Nv5 V() {
        return T().m();
    }

    public final String W() {
        return C7183Qq.q(EnumC18608ow5.l).getString("search_suggestion_list_v1", null);
    }

    public final void Z() {
        C7183Qq.p().remove("_market_data");
        C7183Qq.p().remove("_market_data_version");
    }

    public final void a0() {
        C7183Qq.q(EnumC18608ow5.l).remove("search_suggestion_list_v1");
    }

    public final void b0(String str) {
        AbstractC13042fc3.i(str, "data");
        C7183Qq.q(EnumC18608ow5.l).putString("search_suggestion_list_v1", str);
    }

    public final C6517Nv5 c0(String str, boolean z, byte[] bArr) {
        AbstractC13042fc3.i(str, "query");
        C6517Nv5 c6517Nv5H = T().n(new SO3.e(str, z, bArr != null ? AbstractC2383g.F(bArr) : null)).H(new InterfaceC17569nB2() { // from class: ir.nasim.LQ3
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return QQ3.e0((SearchOuterClass$ResponseSearchMarket) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final C6517Nv5 f0(String str, byte[] bArr) {
        AbstractC13042fc3.i(str, "query");
        C6517Nv5 c6517Nv5H = T().o(new SO3.f(str, bArr != null ? AbstractC2383g.F(bArr) : null)).H(new InterfaceC17569nB2() { // from class: ir.nasim.MQ3
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return QQ3.g0((SearchOuterClass$ResponseSearchProduct) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5H, "flatMap(...)");
        return c6517Nv5H;
    }

    public final void h0() {
        C7183Qq.p().g("market_refresh_dialog", false);
    }

    public final C6517Nv5 i0(SO3.g gVar) {
        AbstractC13042fc3.i(gVar, "sendFeedback");
        return T().p(gVar);
    }

    public final C6517Nv5 j0(SO3.h hVar) {
        AbstractC13042fc3.i(hVar, "setOnboardingData");
        return T().q(hVar);
    }

    public final boolean k0() {
        return C7183Qq.p().h("for_you_category_feedback", true);
    }
}
