package ir.nasim.core.modules.market.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC17026mG5;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C17132mS3;
import ir.nasim.C19406qI3;
import ir.nasim.ED1;
import ir.nasim.EnumC4716Gg2;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.KS2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0001>B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00160\bj\b\u0012\u0004\u0012\u00020\u0016`\n¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0010\u0010!\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b#\u0010$J \u0010%\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003¢\u0006\u0004\b%\u0010\u0018JH\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÇ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0013H×\u0001¢\u0006\u0004\b(\u0010\u0015J\u0010\u0010)\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b)\u0010\u001fJ\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010\u0016H×\u0003¢\u0006\u0004\b,\u0010-R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u00101R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u00102\u001a\u0004\b3\u0010\"\"\u0004\b4\u00105R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u00106\u001a\u0004\b7\u0010$\"\u0004\b8\u00109R2\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010:\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u0010¨\u0006?"}, d2 = {"Lir/nasim/core/modules/market/model/GetMarketDataResponse;", "Landroid/os/Parcelable;", "", ParameterNames.VERSION, "Lir/nasim/core/modules/market/model/MarketMenu;", "menu", "Lir/nasim/core/modules/market/model/MarketSlider;", "slider", "Ljava/util/ArrayList;", "Lir/nasim/core/modules/market/model/MarketSection;", "Lkotlin/collections/ArrayList;", "marketRows", "<init>", "(ILir/nasim/core/modules/market/model/MarketMenu;Lir/nasim/core/modules/market/model/MarketSlider;Ljava/util/ArrayList;)V", "Lir/nasim/rB7;", "makeItemsShuffled", "(Ljava/util/ArrayList;)V", "validate", "()V", "", "toJsonString", "()Ljava/lang/String;", "", "getStructuredData", "()Ljava/util/ArrayList;", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Lir/nasim/core/modules/market/model/MarketMenu;", "component3", "()Lir/nasim/core/modules/market/model/MarketSlider;", "component4", "copy", "(ILir/nasim/core/modules/market/model/MarketMenu;Lir/nasim/core/modules/market/model/MarketSlider;Ljava/util/ArrayList;)Lir/nasim/core/modules/market/model/GetMarketDataResponse;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "getVersion", "setVersion", "(I)V", "Lir/nasim/core/modules/market/model/MarketMenu;", "getMenu", "setMenu", "(Lir/nasim/core/modules/market/model/MarketMenu;)V", "Lir/nasim/core/modules/market/model/MarketSlider;", "getSlider", "setSlider", "(Lir/nasim/core/modules/market/model/MarketSlider;)V", "Ljava/util/ArrayList;", "getMarketRows", "setMarketRows", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class GetMarketDataResponse implements Parcelable {

    @InterfaceC23984xq6("rows")
    private ArrayList<MarketSection> marketRows;

    @InterfaceC23984xq6("menu")
    private MarketMenu menu;

    @InterfaceC23984xq6("slider")
    private MarketSlider slider;

    @InterfaceC23984xq6(ParameterNames.VERSION)
    private int version;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    public static final Parcelable.Creator<GetMarketDataResponse> CREATOR = new b();

    /* renamed from: ir.nasim.core.modules.market.model.GetMarketDataResponse$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final GetMarketDataResponse a(String str) {
            AbstractC13042fc3.i(str, "json");
            try {
                GetMarketDataResponse getMarketDataResponse = (GetMarketDataResponse) new KS2().k(str, GetMarketDataResponse.class);
                getMarketDataResponse.validate();
                return getMarketDataResponse;
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
                return null;
            }
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GetMarketDataResponse createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            int i = parcel.readInt();
            MarketMenu marketMenuCreateFromParcel = MarketMenu.CREATOR.createFromParcel(parcel);
            MarketSlider marketSliderCreateFromParcel = MarketSlider.CREATOR.createFromParcel(parcel);
            int i2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList.add(MarketSection.CREATOR.createFromParcel(parcel));
            }
            return new GetMarketDataResponse(i, marketMenuCreateFromParcel, marketSliderCreateFromParcel, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final GetMarketDataResponse[] newArray(int i) {
            return new GetMarketDataResponse[i];
        }
    }

    public GetMarketDataResponse(int i, MarketMenu marketMenu, MarketSlider marketSlider, ArrayList<MarketSection> arrayList) {
        AbstractC13042fc3.i(marketMenu, "menu");
        AbstractC13042fc3.i(marketSlider, "slider");
        AbstractC13042fc3.i(arrayList, "marketRows");
        this.version = i;
        this.menu = marketMenu;
        this.slider = marketSlider;
        this.marketRows = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetMarketDataResponse copy$default(GetMarketDataResponse getMarketDataResponse, int i, MarketMenu marketMenu, MarketSlider marketSlider, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = getMarketDataResponse.version;
        }
        if ((i2 & 2) != 0) {
            marketMenu = getMarketDataResponse.menu;
        }
        if ((i2 & 4) != 0) {
            marketSlider = getMarketDataResponse.slider;
        }
        if ((i2 & 8) != 0) {
            arrayList = getMarketDataResponse.marketRows;
        }
        return getMarketDataResponse.copy(i, marketMenu, marketSlider, arrayList);
    }

    private final void makeItemsShuffled(ArrayList<MarketSection> marketRows) {
        int iZ2 = AbstractC5969Lp4.e().S().Z2();
        for (MarketSection marketSection : marketRows) {
            if (!marketSection.getItems().isEmpty()) {
                if (marketSection.getItems().size() > iZ2) {
                    ArrayList<MarketItem> items = marketSection.getItems();
                    while (items.size() > iZ2) {
                        items.remove(AbstractC23053wG5.t(AbstractC23053wG5.y(0, items.size()), AbstractC17026mG5.a));
                    }
                    Collections.shuffle(items);
                } else {
                    Collections.shuffle(marketSection.getItems());
                }
            }
        }
    }

    /* renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component2, reason: from getter */
    public final MarketMenu getMenu() {
        return this.menu;
    }

    /* renamed from: component3, reason: from getter */
    public final MarketSlider getSlider() {
        return this.slider;
    }

    public final ArrayList<MarketSection> component4() {
        return this.marketRows;
    }

    public final GetMarketDataResponse copy(int version, MarketMenu menu, MarketSlider slider, ArrayList<MarketSection> marketRows) {
        AbstractC13042fc3.i(menu, "menu");
        AbstractC13042fc3.i(slider, "slider");
        AbstractC13042fc3.i(marketRows, "marketRows");
        return new GetMarketDataResponse(version, menu, slider, marketRows);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetMarketDataResponse)) {
            return false;
        }
        GetMarketDataResponse getMarketDataResponse = (GetMarketDataResponse) other;
        return this.version == getMarketDataResponse.version && AbstractC13042fc3.d(this.menu, getMarketDataResponse.menu) && AbstractC13042fc3.d(this.slider, getMarketDataResponse.slider) && AbstractC13042fc3.d(this.marketRows, getMarketDataResponse.marketRows);
    }

    public final ArrayList<MarketSection> getMarketRows() {
        return this.marketRows;
    }

    public final MarketMenu getMenu() {
        return this.menu;
    }

    public final MarketSlider getSlider() {
        return this.slider;
    }

    public final ArrayList<Object> getStructuredData() {
        boolean zB5 = AbstractC5969Lp4.e().S().B5(EnumC4716Gg2.G);
        ArrayList<MarketSection> arrayList = new ArrayList<>();
        arrayList.addAll(this.marketRows);
        if (zB5) {
            makeItemsShuffled(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        for (MarketSection marketSection : arrayList) {
            if (marketSection.isPinned()) {
                arrayList2.add(marketSection);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.remove((MarketSection) it.next());
        }
        ArrayList<Object> arrayList3 = new ArrayList<>();
        int i = 0;
        if (AbstractC5969Lp4.e().S().B5(EnumC4716Gg2.H)) {
            arrayList3.add(new C17132mS3(0));
        }
        arrayList3.add(this.menu);
        arrayList3.addAll(arrayList2);
        arrayList3.add(this.slider);
        if (zB5) {
            Collections.shuffle(arrayList);
        }
        arrayList3.addAll(arrayList);
        for (Object obj : arrayList3) {
            if (obj instanceof MarketSection) {
                ((MarketSection) obj).setPosition(i);
                i++;
            }
        }
        return arrayList3;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.version) * 31) + this.menu.hashCode()) * 31) + this.slider.hashCode()) * 31) + this.marketRows.hashCode();
    }

    public final void setMarketRows(ArrayList<MarketSection> arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.marketRows = arrayList;
    }

    public final void setMenu(MarketMenu marketMenu) {
        AbstractC13042fc3.i(marketMenu, "<set-?>");
        this.menu = marketMenu;
    }

    public final void setSlider(MarketSlider marketSlider) {
        AbstractC13042fc3.i(marketSlider, "<set-?>");
        this.slider = marketSlider;
    }

    public final void setVersion(int i) {
        this.version = i;
    }

    public final String toJsonString() {
        try {
            return new KS2().t(this);
        } catch (Exception unused) {
            return null;
        }
    }

    public String toString() {
        return "GetMarketDataResponse(version=" + this.version + ", menu=" + this.menu + ", slider=" + this.slider + ", marketRows=" + this.marketRows + Separators.RPAREN;
    }

    public final void validate() {
        this.menu.validate();
        this.slider.validate();
        Iterator<T> it = this.marketRows.iterator();
        while (it.hasNext()) {
            ((MarketSection) it.next()).validate();
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeInt(this.version);
        this.menu.writeToParcel(dest, flags);
        this.slider.writeToParcel(dest, flags);
        ArrayList<MarketSection> arrayList = this.marketRows;
        dest.writeInt(arrayList.size());
        Iterator<MarketSection> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
    }
}
