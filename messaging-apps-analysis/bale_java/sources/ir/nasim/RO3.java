package ir.nasim;

import ai.bale.proto.CollectionsStruct$BooleanValue;
import ai.bale.proto.CollectionsStruct$Int32Value;
import ai.bale.proto.CollectionsStruct$StringValue;
import ai.bale.proto.MarketOuterClass$RequestGetCategories;
import ai.bale.proto.MarketOuterClass$RequestGetCategoryMarkets;
import ai.bale.proto.MarketOuterClass$RequestGetCategoryProducts;
import ai.bale.proto.MarketOuterClass$RequestGetOnboardingStatus;
import ai.bale.proto.MarketOuterClass$RequestSetOnboardingData;
import ai.bale.proto.MarketOuterClass$RequestSubmitMarketFeedback;
import ai.bale.proto.MarketOuterClass$ResponseGetCategories;
import ai.bale.proto.MarketOuterClass$ResponseGetCategoryMarkets;
import ai.bale.proto.MarketOuterClass$ResponseGetCategoryProducts;
import ai.bale.proto.MarketOuterClass$ResponseGetOnboardingStatus;
import ai.bale.proto.MarketOuterClass$ResponseSetOnboardingData;
import ai.bale.proto.MarketStruct$MarketPagination;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.SearchOuterClass$RequestSearchMarket;
import ai.bale.proto.SearchOuterClass$RequestSearchProduct;
import ai.bale.proto.SearchOuterClass$ResponseSearchMarket;
import ai.bale.proto.SearchOuterClass$ResponseSearchProduct;
import ai.bale.proto.SearchStruct$SearchPieceText;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.BoolValue;
import com.google.protobuf.BytesValue;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.SO3;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes5.dex */
public final class RO3 extends AbstractC6360Ng4 {
    public static final a m = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RO3(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "moduleContext");
    }

    private final C6517Nv5 d0(SO3.a aVar) {
        CollectionsStruct$Int32Value.a aVarA = CollectionsStruct$Int32Value.newBuilder().A(aVar.c());
        CollectionsStruct$Int32Value.a aVarA2 = CollectionsStruct$Int32Value.newBuilder().A(aVar.d());
        MarketOuterClass$RequestGetCategories marketOuterClass$RequestGetCategories = (MarketOuterClass$RequestGetCategories) MarketOuterClass$RequestGetCategories.newBuilder().A(aVar.a()).C(aVarA).D(aVarA2).B((CollectionsStruct$BooleanValue) CollectionsStruct$BooleanValue.newBuilder().A(aVar.b()).a()).a();
        AbstractC13042fc3.f(marketOuterClass$RequestGetCategories);
        MarketOuterClass$ResponseGetCategories defaultInstance = MarketOuterClass$ResponseGetCategories.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5L = L(new C22871vx5("/bale.market.v1.Market/GetCategoriesList", marketOuterClass$RequestGetCategories, defaultInstance));
        AbstractC13042fc3.h(c6517Nv5L, "api(...)");
        return c6517Nv5L;
    }

    private final C6517Nv5 e0(SO3.b bVar) {
        MarketOuterClass$RequestGetCategoryMarkets marketOuterClass$RequestGetCategoryMarkets = (MarketOuterClass$RequestGetCategoryMarkets) MarketOuterClass$RequestGetCategoryMarkets.newBuilder().A(bVar.a()).B(MarketStruct$MarketPagination.newBuilder().A(bVar.b()).B(bVar.c())).a();
        AbstractC13042fc3.f(marketOuterClass$RequestGetCategoryMarkets);
        MarketOuterClass$ResponseGetCategoryMarkets defaultInstance = MarketOuterClass$ResponseGetCategoryMarkets.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5L = L(new C22871vx5("/bale.market.v1.Market/GetCategoryMarkets", marketOuterClass$RequestGetCategoryMarkets, defaultInstance));
        AbstractC13042fc3.h(c6517Nv5L, "api(...)");
        return c6517Nv5L;
    }

    private final C6517Nv5 f0(SO3.c cVar) {
        MarketOuterClass$RequestGetCategoryProducts marketOuterClass$RequestGetCategoryProducts = (MarketOuterClass$RequestGetCategoryProducts) MarketOuterClass$RequestGetCategoryProducts.newBuilder().A(cVar.a()).B(MarketStruct$MarketPagination.newBuilder().A(cVar.b()).B(cVar.c())).a();
        AbstractC13042fc3.f(marketOuterClass$RequestGetCategoryProducts);
        MarketOuterClass$ResponseGetCategoryProducts defaultInstance = MarketOuterClass$ResponseGetCategoryProducts.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5L = L(new C22871vx5("/bale.market.v1.Market/GetCategoryProducts", marketOuterClass$RequestGetCategoryProducts, defaultInstance));
        AbstractC13042fc3.h(c6517Nv5L, "api(...)");
        return c6517Nv5L;
    }

    private final C6517Nv5 g0() {
        MarketOuterClass$RequestGetOnboardingStatus marketOuterClass$RequestGetOnboardingStatus = (MarketOuterClass$RequestGetOnboardingStatus) MarketOuterClass$RequestGetOnboardingStatus.newBuilder().a();
        AbstractC13042fc3.f(marketOuterClass$RequestGetOnboardingStatus);
        MarketOuterClass$ResponseGetOnboardingStatus defaultInstance = MarketOuterClass$ResponseGetOnboardingStatus.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5L = L(new C22871vx5("/bale.market.v1.Market/GetOnboardingStatus", marketOuterClass$RequestGetOnboardingStatus, defaultInstance));
        AbstractC13042fc3.h(c6517Nv5L, "api(...)");
        return c6517Nv5L;
    }

    private final C6517Nv5 h0(SO3.e eVar) {
        SearchOuterClass$RequestSearchMarket.a aVarNewBuilder = SearchOuterClass$RequestSearchMarket.newBuilder();
        aVarNewBuilder.B((SearchStruct$SearchPieceText) SearchStruct$SearchPieceText.newBuilder().A(eVar.b()).a());
        aVarNewBuilder.C(BoolValue.of(eVar.c()));
        AbstractC2383g abstractC2383gA = eVar.a();
        if (abstractC2383gA != null) {
            aVarNewBuilder.A(BytesValue.of(abstractC2383gA));
        }
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        SearchOuterClass$ResponseSearchMarket defaultInstance = SearchOuterClass$ResponseSearchMarket.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5L = L(new C22871vx5("/bale.search.v1.Search/SearchMarket", generatedMessageLiteA, defaultInstance));
        AbstractC13042fc3.h(c6517Nv5L, "api(...)");
        return c6517Nv5L;
    }

    private final C6517Nv5 i0(SO3.f fVar) {
        SearchOuterClass$RequestSearchProduct.a aVarNewBuilder = SearchOuterClass$RequestSearchProduct.newBuilder();
        aVarNewBuilder.B((SearchStruct$SearchPieceText) SearchStruct$SearchPieceText.newBuilder().A(fVar.b()).a());
        AbstractC2383g abstractC2383gA = fVar.a();
        if (abstractC2383gA != null) {
            aVarNewBuilder.A(BytesValue.of(abstractC2383gA));
        }
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        SearchOuterClass$ResponseSearchProduct defaultInstance = SearchOuterClass$ResponseSearchProduct.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5L = L(new C22871vx5("/bale.search.v1.Search/SearchProduct", generatedMessageLiteA, defaultInstance));
        AbstractC13042fc3.h(c6517Nv5L, "api(...)");
        return c6517Nv5L;
    }

    private final C6517Nv5 j0(SO3.g gVar) {
        MarketOuterClass$RequestSubmitMarketFeedback.a aVarNewBuilder = MarketOuterClass$RequestSubmitMarketFeedback.newBuilder();
        aVarNewBuilder.A((CollectionsStruct$StringValue) CollectionsStruct$StringValue.newBuilder().A(String.valueOf(C5721Ko.a.h())).a());
        aVarNewBuilder.C(gVar.b());
        aVarNewBuilder.B(RT3.j(gVar.b()));
        String strA = gVar.a();
        if (strA != null) {
            aVarNewBuilder.D((CollectionsStruct$StringValue) CollectionsStruct$StringValue.newBuilder().A(strA).a());
        }
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5L = L(new C22871vx5("/bale.market.v1.Market/SubmitMarketFeedback", generatedMessageLiteA, defaultInstance));
        AbstractC13042fc3.h(c6517Nv5L, "api(...)");
        return c6517Nv5L;
    }

    private final C6517Nv5 k0(SO3.h hVar) {
        MarketOuterClass$RequestSetOnboardingData.a aVarNewBuilder = MarketOuterClass$RequestSetOnboardingData.newBuilder();
        aVarNewBuilder.C(BoolValue.of(hVar.c()));
        if (hVar.b() != null) {
            aVarNewBuilder.B(hVar.b());
        } else {
            aVarNewBuilder.B(EnumC10336bU3.UserGender_UNKNOWN);
        }
        ArrayList arrayListA = hVar.a();
        if (arrayListA != null) {
            Iterator it = arrayListA.iterator();
            while (it.hasNext()) {
                aVarNewBuilder.A(((Number) it.next()).intValue());
            }
        }
        GeneratedMessageLite generatedMessageLiteA = aVarNewBuilder.a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        MarketOuterClass$ResponseSetOnboardingData defaultInstance = MarketOuterClass$ResponseSetOnboardingData.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5L = L(new C22871vx5("/bale.market.v1.Market/SetOnboardingData", generatedMessageLiteA, defaultInstance));
        AbstractC13042fc3.h(c6517Nv5L, "api(...)");
        return c6517Nv5L;
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        if (obj instanceof SO3.a) {
            return d0((SO3.a) obj);
        }
        if (obj instanceof SO3.b) {
            return e0((SO3.b) obj);
        }
        if (obj instanceof SO3.c) {
            return f0((SO3.c) obj);
        }
        if (obj instanceof SO3.h) {
            return k0((SO3.h) obj);
        }
        if (obj instanceof SO3.d) {
            return g0();
        }
        if (obj instanceof SO3.e) {
            return h0((SO3.e) obj);
        }
        if (obj instanceof SO3.f) {
            return i0((SO3.f) obj);
        }
        if (obj instanceof SO3.g) {
            return j0((SO3.g) obj);
        }
        C6517Nv5 c6517Nv5G = super.G(obj);
        AbstractC13042fc3.f(c6517Nv5G);
        return c6517Nv5G;
    }
}
