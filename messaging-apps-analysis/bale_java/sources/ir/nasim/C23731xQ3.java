package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C12950fS3;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.core.modules.market.model.MarketItemMore;
import ir.nasim.core.modules.market.model.MarketProductItem;
import ir.nasim.core.modules.market.model.MarketSection;
import java.util.ArrayList;
import okhttp3.internal.ws.WebSocketProtocol;

/* renamed from: ir.nasim.xQ3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23731xQ3 extends RecyclerView.h {
    public static final a m = new a(null);
    public static final int n = 8;
    private final MarketSection d;
    private final int e;
    private final boolean f;
    private final UA2 g;
    private final UA2 h;
    private b i;
    private c j;
    private ArrayList k;
    private C12950fS3.b l;

    /* renamed from: ir.nasim.xQ3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.xQ3$b */
    public interface b {
        void C(MarketItem marketItem, MarketSection marketSection);

        void k(MarketProductItem marketProductItem, MarketSection marketSection);
    }

    /* renamed from: ir.nasim.xQ3$c */
    public interface c {
        void x(MarketItemMore marketItemMore, MarketSection marketSection);
    }

    /* renamed from: ir.nasim.xQ3$d */
    public static final class d implements C12950fS3.b {
        d() {
        }

        @Override // ir.nasim.C12950fS3.b
        public void x2(Object obj) {
            AbstractC13042fc3.i(obj, "item");
        }
    }

    public C23731xQ3(MarketSection marketSection, int i, boolean z, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(marketSection, "row");
        AbstractC13042fc3.i(ua2, "bindItem");
        AbstractC13042fc3.i(ua22, "unbindItem");
        this.d = marketSection;
        this.e = i;
        this.f = z;
        this.g = ua2;
        this.h = ua22;
        this.k = new ArrayList();
        this.l = new d();
    }

    public final void A(b bVar) {
        this.i = bVar;
    }

    public final void B(C12950fS3.b bVar) {
        AbstractC13042fc3.i(bVar, "<set-?>");
        this.l = bVar;
    }

    public final void C(c cVar) {
        this.j = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.k.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        Object obj = this.k.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        if ((obj instanceof MarketItem) || (obj instanceof MarketProductItem)) {
            return this.e;
        }
        if (!(obj instanceof MarketItemMore)) {
            return AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        }
        int categoryType = ((MarketItemMore) obj).getRow().getCategoryType();
        if (categoryType == EnumC21325tT3.CategoryItemsType_PRODUCT_ONLY.getNumber()) {
            return WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY;
        }
        if (categoryType == EnumC21325tT3.CategoryItemsType_FOR_YOU_PRODUCT_ONLY.getNumber()) {
            return 1002;
        }
        return AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c2, int i) {
        AbstractC13042fc3.i(c2, "holder");
        int itemViewType = getItemViewType(i);
        switch (itemViewType) {
            case 0:
                Object obj = this.k.get(i);
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketItem");
                ((GQ3) c2).H0((MarketItem) obj, this.d);
                break;
            case 1:
                DQ3 dq3 = (DQ3) c2;
                Object obj2 = this.k.get(i);
                AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketItem");
                dq3.M0((MarketItem) obj2, this.d, this.f && i == 0);
                break;
            case 2:
                Object obj3 = this.k.get(i);
                AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketItem");
                ((AQ3) c2).L0((MarketItem) obj3, this.d);
                break;
            case 3:
                Object obj4 = this.k.get(i);
                AbstractC13042fc3.g(obj4, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketProductItem");
                ((YO3) c2).J0((MarketProductItem) obj4, this.d);
                break;
            case 4:
                Object obj5 = this.k.get(i);
                AbstractC13042fc3.g(obj5, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketProductItem");
                ((VO3) c2).J0((MarketProductItem) obj5, this.d);
                break;
            case 5:
                Object obj6 = this.k.get(i);
                AbstractC13042fc3.g(obj6, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketProductItem");
                ((C12314eP3) c2).J0((MarketProductItem) obj6, this.d);
                break;
            case 6:
                Object obj7 = this.k.get(i);
                AbstractC13042fc3.g(obj7, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketProductItem");
                ((C10291bP3) c2).J0((MarketProductItem) obj7, this.d);
                break;
            default:
                switch (itemViewType) {
                    case AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT /* 1000 */:
                        Object obj8 = this.k.get(i);
                        AbstractC13042fc3.g(obj8, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketItemMore");
                        ((WQ3) c2).E0((MarketItemMore) obj8, this.d);
                        break;
                    case WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY /* 1001 */:
                        Object obj9 = this.k.get(i);
                        AbstractC13042fc3.g(obj9, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketItemMore");
                        ((UQ3) c2).E0((MarketItemMore) obj9, this.d);
                        break;
                    case 1002:
                        Object obj10 = this.k.get(i);
                        AbstractC13042fc3.g(obj10, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketItemMore");
                        ((SQ3) c2).E0((MarketItemMore) obj10, this.d);
                        break;
                }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        switch (i) {
            case 0:
                return GQ3.D.a(viewGroup, this.i, this.l, this.g, this.h);
            case 1:
                return DQ3.Z.a(viewGroup, this.i, this.l, this.g, this.h);
            case 2:
                return AQ3.J.a(viewGroup, this.i, this.l, this.g, this.h);
            case 3:
                return YO3.G.a(viewGroup, this.i, this.l, this.g, this.h);
            case 4:
                return VO3.G.a(viewGroup, this.i, this.l, this.g, this.h);
            case 5:
                return C12314eP3.G.a(viewGroup, this.i, this.l, this.g, this.h);
            case 6:
                return C10291bP3.G.a(viewGroup, this.i, this.l, this.g, this.h);
            default:
                switch (i) {
                    case AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT /* 1000 */:
                        return WQ3.x.a(viewGroup, this.j);
                    case WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY /* 1001 */:
                        return UQ3.x.a(viewGroup, this.j);
                    case 1002:
                        return SQ3.x.a(viewGroup, this.j);
                    default:
                        return WQ3.x.a(viewGroup, this.j);
                }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewRecycled(RecyclerView.C c2) {
        AbstractC13042fc3.i(c2, "holder");
        super.onViewRecycled(c2);
        if (c2 instanceof GQ3) {
            ((GQ3) c2).a();
            return;
        }
        if (c2 instanceof DQ3) {
            ((DQ3) c2).a();
            return;
        }
        if (c2 instanceof AQ3) {
            ((AQ3) c2).a();
        } else if (c2 instanceof C12314eP3) {
            ((C12314eP3) c2).a();
        } else if (c2 instanceof C10291bP3) {
            ((C10291bP3) c2).a();
        }
    }

    public final ArrayList z() {
        return this.k;
    }
}
