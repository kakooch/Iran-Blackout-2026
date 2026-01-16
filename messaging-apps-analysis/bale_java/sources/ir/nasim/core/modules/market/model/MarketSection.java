package ir.nasim.core.modules.market.model;

import ai.bale.proto.MarketStruct$MarketCategory;
import ai.bale.proto.MarketStruct$MarketItem;
import ai.bale.proto.MarketStruct$MarketMenuItemDialog;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19406qI3;
import ir.nasim.ED1;
import ir.nasim.EnumC21325tT3;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.KB5;
import ir.nasim.KS2;
import ir.nasim.core.modules.market.model.MarketDialog;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u001c\b\u0087\b\u0018\u0000 O2\u00020\u0001:\u0001PB{\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0002H\u0007¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0002H\u0007¢\u0006\u0004\b%\u0010\u001cJ\u0010\u0010&\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u001cJ\u0010\u0010'\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b'\u0010\u001fJ \u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003¢\u0006\u0004\b(\u0010)J$\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\bHÆ\u0003¢\u0006\u0004\b*\u0010)J\u0010\u0010+\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b+\u0010\u001fJ\u0012\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\u001cJ\u0010\u0010/\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b/\u0010\u0016J\u0010\u00100\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b0\u0010\u001cJ\u0090\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\b2\b\b\u0002\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b3\u0010\u001fJ\u0010\u00104\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b4\u0010\u001cJ\u001a\u00107\u001a\u00020\u00102\b\u00106\u001a\u0004\u0018\u000105H×\u0003¢\u0006\u0004\b7\u00108R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u00109\u001a\u0004\b:\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010;\u001a\u0004\b<\u0010\u001fR2\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010=\u001a\u0004\b>\u0010)\"\u0004\b?\u0010@R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010=\u001a\u0004\bA\u0010)\"\u0004\bB\u0010@R\u001a\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010;\u001a\u0004\bC\u0010\u001fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010D\u001a\u0004\bE\u0010-R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u00109\u001a\u0004\bF\u0010\u001c\"\u0004\bG\u0010HR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010I\u001a\u0004\b\u0011\u0010\u0016R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u00109\u001a\u0004\bJ\u0010\u001cR(\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\bK\u00109\u0012\u0004\bN\u0010\u0019\u001a\u0004\bL\u0010\u001c\"\u0004\bM\u0010H¨\u0006Q"}, d2 = {"Lir/nasim/core/modules/market/model/MarketSection;", "Landroid/os/Parcelable;", "", "id", "", "drawableId", "Ljava/util/ArrayList;", "Lir/nasim/core/modules/market/model/MarketItem;", "Lkotlin/collections/ArrayList;", "items", "Lir/nasim/core/modules/market/model/MarketProductItem;", "products", "title", "Lir/nasim/core/modules/market/model/MarketDialog;", "dialog", "displayCount", "", DialogEntity.COLUMN_IS_PINNED, "categoryType", "<init>", "(ILjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Lir/nasim/core/modules/market/model/MarketDialog;IZI)V", "isProduct", "()Z", "Lir/nasim/rB7;", "validate", "()V", "shoudApplyTintOnDrawable", "getDrawableIdResource", "()I", "getDialogDrawableIdResource", "toJson", "()Ljava/lang/String;", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "component1", "component2", "component3", "()Ljava/util/ArrayList;", "component4", "component5", "component6", "()Lir/nasim/core/modules/market/model/MarketDialog;", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Lir/nasim/core/modules/market/model/MarketDialog;IZI)Lir/nasim/core/modules/market/model/MarketSection;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "getId", "Ljava/lang/String;", "getDrawableId", "Ljava/util/ArrayList;", "getItems", "setItems", "(Ljava/util/ArrayList;)V", "getProducts", "setProducts", "getTitle", "Lir/nasim/core/modules/market/model/MarketDialog;", "getDialog", "getDisplayCount", "setDisplayCount", "(I)V", "Z", "getCategoryType", "position", "getPosition", "setPosition", "getPosition$annotations", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class MarketSection implements Parcelable {

    @InterfaceC23984xq6("categoryType")
    private final int categoryType;

    @InterfaceC23984xq6("dialog")
    private final MarketDialog dialog;

    @InterfaceC23984xq6("displayCount")
    private int displayCount;

    @InterfaceC23984xq6("drawableId")
    private final String drawableId;

    @InterfaceC23984xq6("id")
    private final int id;

    @InterfaceC23984xq6(DialogEntity.COLUMN_IS_PINNED)
    private final boolean isPinned;

    @InterfaceC23984xq6("markets")
    private ArrayList<MarketItem> items;
    private int position;

    @InterfaceC23984xq6("products")
    private ArrayList<MarketProductItem> products;

    @InterfaceC23984xq6("title")
    private final String title;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    public static final Parcelable.Creator<MarketSection> CREATOR = new b();

    /* renamed from: ir.nasim.core.modules.market.model.MarketSection$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private final int c(String str) {
            switch (str.hashCode()) {
                case -1984471071:
                    if (str.equals("kitchen_appliances")) {
                        return KB5.market_category_kitchen_appliances;
                    }
                    break;
                case -1952617082:
                    if (str.equals("male_fashion")) {
                        return KB5.market_category_male_fashion;
                    }
                    break;
                case -1875437388:
                    if (str.equals("girls_day")) {
                        return KB5.girlsday;
                    }
                    break;
                case -1548921915:
                    if (str.equals("female_fashion")) {
                        return KB5.market_category_female_fashion;
                    }
                    break;
                case -1393028996:
                    if (str.equals("beauty")) {
                        return KB5.market_category_beauty;
                    }
                    break;
                case -1284806001:
                    if (str.equals("gifting_day")) {
                        return KB5.giftingday;
                    }
                    break;
                case -1281653412:
                    if (str.equals("father")) {
                        return KB5.market_category_male;
                    }
                    break;
                case -1077469768:
                    if (str.equals("fashion")) {
                        return KB5.market_category_fashion;
                    }
                    break;
                case -1006804125:
                    if (str.equals("others")) {
                        return KB5.saier;
                    }
                    break;
                case -934918565:
                    if (str.equals("recent")) {
                        return KB5.market_category_recent;
                    }
                    break;
                case -874203338:
                    if (str.equals("teens_day")) {
                        return KB5.teensday;
                    }
                    break;
                case -779699159:
                    if (str.equals("wrench")) {
                        return KB5.market_category_wrench;
                    }
                    break;
                case -749237858:
                    if (str.equals("arbaeen")) {
                        return KB5.arbaeen_category;
                    }
                    break;
                case -678927291:
                    if (str.equals("percent")) {
                        return KB5.market_category_percent_dialog;
                    }
                    break;
                case -332723285:
                    if (str.equals("basalam")) {
                        return KB5.market_category_basalam_dialog;
                    }
                    break;
                case -290756696:
                    if (str.equals("education")) {
                        return KB5.market_category_education;
                    }
                    break;
                case 3714:
                    if (str.equals("tv")) {
                        return KB5.drawable_market_suggestion_tv;
                    }
                    break;
                case 96432:
                    if (str.equals(SearchSuggestion.ADS_ICON)) {
                        return KB5.drawable_market_suggestion_ads;
                    }
                    break;
                case 96867:
                    if (str.equals("art")) {
                        return KB5.market_category_art;
                    }
                    break;
                case 3148894:
                    if (str.equals("food")) {
                        return KB5.market_category_food;
                    }
                    break;
                case 3357441:
                    if (str.equals("moon")) {
                        return KB5.market_category_moon;
                    }
                    break;
                case 3540562:
                    if (str.equals("star")) {
                        return KB5.market_category_star_dialog;
                    }
                    break;
                case 3566293:
                    if (str.equals("toys")) {
                        return KB5.market_category_toys;
                    }
                    break;
                case 9085660:
                    if (str.equals("sports_day")) {
                        return KB5.sportsday;
                    }
                    break;
                case 50511102:
                    if (str.equals(SearchSuggestion.CATEGORY_ICON)) {
                        return KB5.drawable_market_suggestion_category;
                    }
                    break;
                case 93921962:
                    if (str.equals("books")) {
                        return KB5.market_category_books;
                    }
                    break;
                case 99151942:
                    if (str.equals("heart")) {
                        return KB5.market_category_heart_dialog;
                    }
                    break;
                case 103160278:
                    if (str.equals("lorry")) {
                        return KB5.market_category_lorry_dialog;
                    }
                    break;
                case 109251077:
                    if (str.equals("scarf")) {
                        return KB5.market_category_female;
                    }
                    break;
                case 114742753:
                    if (str.equals("yalda")) {
                        return KB5.market_category_yalda;
                    }
                    break;
                case 264780785:
                    if (str.equals("bag_shoes")) {
                        return KB5.market_category_bag_shoes;
                    }
                    break;
                case 837543733:
                    if (str.equals("personal_stuff")) {
                        return KB5.market_category_personal_stuff;
                    }
                    break;
                case 841760710:
                    if (str.equals("home_appliances")) {
                        return KB5.market_category_home_appliances;
                    }
                    break;
                case 899247050:
                    if (str.equals("purchase_notifDay")) {
                        return KB5.purchasenotifday;
                    }
                    break;
                case 949714355:
                    if (str.equals("men_day")) {
                        return KB5.menday;
                    }
                    break;
                case 1304596865:
                    if (str.equals("autumn_festival")) {
                        return KB5.autumnfestival;
                    }
                    break;
                case 1379209310:
                    if (str.equals("services")) {
                        return KB5.khadamat;
                    }
                    break;
                case 1660481048:
                    if (str.equals("digital")) {
                        return KB5.market_category_digital;
                    }
                    break;
            }
            return KB5.saier;
        }

        public final MarketSection a(MarketStruct$MarketCategory marketStruct$MarketCategory) {
            AbstractC13042fc3.i(marketStruct$MarketCategory, "response");
            int id = marketStruct$MarketCategory.getId();
            String drawableId = marketStruct$MarketCategory.getDrawableId();
            AbstractC13042fc3.h(drawableId, "getDrawableId(...)");
            MarketItem.Companion companion = MarketItem.INSTANCE;
            List<MarketStruct$MarketItem> marketsList = marketStruct$MarketCategory.getMarketsList();
            AbstractC13042fc3.h(marketsList, "getMarketsList(...)");
            ArrayList arrayListB = companion.b(marketsList);
            String title = marketStruct$MarketCategory.getTitle();
            AbstractC13042fc3.h(title, "getTitle(...)");
            MarketDialog.Companion companion2 = MarketDialog.INSTANCE;
            MarketStruct$MarketMenuItemDialog dialog = marketStruct$MarketCategory.getDialog();
            AbstractC13042fc3.h(dialog, "getDialog(...)");
            return new MarketSection(id, drawableId, arrayListB, null, title, companion2.a(dialog), marketStruct$MarketCategory.getMarketsCount(), marketStruct$MarketCategory.getPinned().getValue(), marketStruct$MarketCategory.getCategoryItemsType().ordinal());
        }

        public final ArrayList b(List list) {
            AbstractC13042fc3.i(list, "response");
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(MarketSection.INSTANCE.a((MarketStruct$MarketCategory) it.next()));
            }
            return arrayList;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final int d(String str) {
            AbstractC13042fc3.i(str, "drawableId");
            switch (str.hashCode()) {
                case -1984471071:
                    if (str.equals("kitchen_appliances")) {
                        return KB5.market_category_kitchen_appliances;
                    }
                    break;
                case -1952617082:
                    if (str.equals("male_fashion")) {
                        return KB5.market_category_male_fashion;
                    }
                    break;
                case -1548921915:
                    if (str.equals("female_fashion")) {
                        return KB5.market_category_female_fashion;
                    }
                    break;
                case -1393028996:
                    if (str.equals("beauty")) {
                        return KB5.market_category_beauty;
                    }
                    break;
                case -1281653412:
                    if (str.equals("father")) {
                        return KB5.market_category_male;
                    }
                    break;
                case -1077469768:
                    if (str.equals("fashion")) {
                        return KB5.market_category_fashion;
                    }
                    break;
                case -1006804125:
                    if (str.equals("others")) {
                        return KB5.saier;
                    }
                    break;
                case -934918565:
                    if (str.equals("recent")) {
                        return KB5.market_category_recent;
                    }
                    break;
                case -779699159:
                    if (str.equals("wrench")) {
                        return KB5.market_category_wrench;
                    }
                    break;
                case -749237858:
                    if (str.equals("arbaeen")) {
                        return KB5.arbaeen_category;
                    }
                    break;
                case -678927291:
                    if (str.equals("percent")) {
                        return KB5.market_category_percent;
                    }
                    break;
                case -332723285:
                    if (str.equals("basalam")) {
                        return KB5.market_category_basalam;
                    }
                    break;
                case -290756696:
                    if (str.equals("education")) {
                        return KB5.market_category_education;
                    }
                    break;
                case 96867:
                    if (str.equals("art")) {
                        return KB5.market_category_art;
                    }
                    break;
                case 3148894:
                    if (str.equals("food")) {
                        return KB5.market_category_food;
                    }
                    break;
                case 3357441:
                    if (str.equals("moon")) {
                        return KB5.market_category_moon;
                    }
                    break;
                case 3540562:
                    if (str.equals("star")) {
                        return KB5.market_category_star;
                    }
                    break;
                case 3566293:
                    if (str.equals("toys")) {
                        return KB5.market_category_toys;
                    }
                    break;
                case 93921962:
                    if (str.equals("books")) {
                        return KB5.market_category_books;
                    }
                    break;
                case 99151942:
                    if (str.equals("heart")) {
                        return KB5.market_category_heart;
                    }
                    break;
                case 103160278:
                    if (str.equals("lorry")) {
                        return KB5.market_category_lorry;
                    }
                    break;
                case 109251077:
                    if (str.equals("scarf")) {
                        return KB5.market_category_female;
                    }
                    break;
                case 114742753:
                    if (str.equals("yalda")) {
                        return KB5.market_category_yalda;
                    }
                    break;
                case 264780785:
                    if (str.equals("bag_shoes")) {
                        return KB5.market_category_bag_shoes;
                    }
                    break;
                case 837543733:
                    if (str.equals("personal_stuff")) {
                        return KB5.market_category_personal_stuff;
                    }
                    break;
                case 841760710:
                    if (str.equals("home_appliances")) {
                        return KB5.market_category_home_appliances;
                    }
                    break;
                case 1379209310:
                    if (str.equals("services")) {
                        return KB5.khadamat;
                    }
                    break;
                case 1660481048:
                    if (str.equals("digital")) {
                        return KB5.market_category_digital;
                    }
                    break;
            }
            return c(str);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MarketSection createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            AbstractC13042fc3.i(parcel, "parcel");
            int i = parcel.readInt();
            String string = parcel.readString();
            int i2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                arrayList2.add(MarketItem.CREATOR.createFromParcel(parcel));
            }
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i4 = parcel.readInt();
                arrayList = new ArrayList(i4);
                for (int i5 = 0; i5 != i4; i5++) {
                    arrayList.add(MarketProductItem.CREATOR.createFromParcel(parcel));
                }
            }
            return new MarketSection(i, string, arrayList2, arrayList, parcel.readString(), parcel.readInt() != 0 ? MarketDialog.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MarketSection[] newArray(int i) {
            return new MarketSection[i];
        }
    }

    public MarketSection(int i, String str, ArrayList<MarketItem> arrayList, ArrayList<MarketProductItem> arrayList2, String str2, MarketDialog marketDialog, int i2, boolean z, int i3) {
        AbstractC13042fc3.i(str, "drawableId");
        AbstractC13042fc3.i(arrayList, "items");
        AbstractC13042fc3.i(str2, "title");
        this.id = i;
        this.drawableId = str;
        this.items = arrayList;
        this.products = arrayList2;
        this.title = str2;
        this.dialog = marketDialog;
        this.displayCount = i2;
        this.isPinned = z;
        this.categoryType = i3;
        this.position = -1;
    }

    public static /* synthetic */ void getPosition$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDrawableId() {
        return this.drawableId;
    }

    public final ArrayList<MarketItem> component3() {
        return this.items;
    }

    public final ArrayList<MarketProductItem> component4() {
        return this.products;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component6, reason: from getter */
    public final MarketDialog getDialog() {
        return this.dialog;
    }

    /* renamed from: component7, reason: from getter */
    public final int getDisplayCount() {
        return this.displayCount;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsPinned() {
        return this.isPinned;
    }

    /* renamed from: component9, reason: from getter */
    public final int getCategoryType() {
        return this.categoryType;
    }

    public final MarketSection copy(int id, String drawableId, ArrayList<MarketItem> items, ArrayList<MarketProductItem> products, String title, MarketDialog dialog, int displayCount, boolean isPinned, int categoryType) {
        AbstractC13042fc3.i(drawableId, "drawableId");
        AbstractC13042fc3.i(items, "items");
        AbstractC13042fc3.i(title, "title");
        return new MarketSection(id, drawableId, items, products, title, dialog, displayCount, isPinned, categoryType);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketSection)) {
            return false;
        }
        MarketSection marketSection = (MarketSection) other;
        return this.id == marketSection.id && AbstractC13042fc3.d(this.drawableId, marketSection.drawableId) && AbstractC13042fc3.d(this.items, marketSection.items) && AbstractC13042fc3.d(this.products, marketSection.products) && AbstractC13042fc3.d(this.title, marketSection.title) && AbstractC13042fc3.d(this.dialog, marketSection.dialog) && this.displayCount == marketSection.displayCount && this.isPinned == marketSection.isPinned && this.categoryType == marketSection.categoryType;
    }

    public final int getCategoryType() {
        return this.categoryType;
    }

    public final MarketDialog getDialog() {
        return this.dialog;
    }

    public final int getDialogDrawableIdResource() {
        return INSTANCE.d(this.drawableId);
    }

    public final int getDisplayCount() {
        return this.displayCount;
    }

    public final String getDrawableId() {
        return this.drawableId;
    }

    public final int getDrawableIdResource() {
        return INSTANCE.d(this.drawableId);
    }

    public final int getId() {
        return this.id;
    }

    public final ArrayList<MarketItem> getItems() {
        return this.items;
    }

    public final int getPosition() {
        return this.position;
    }

    public final ArrayList<MarketProductItem> getProducts() {
        return this.products;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.id) * 31) + this.drawableId.hashCode()) * 31) + this.items.hashCode()) * 31;
        ArrayList<MarketProductItem> arrayList = this.products;
        int iHashCode2 = (((iHashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31) + this.title.hashCode()) * 31;
        MarketDialog marketDialog = this.dialog;
        return ((((((iHashCode2 + (marketDialog != null ? marketDialog.hashCode() : 0)) * 31) + Integer.hashCode(this.displayCount)) * 31) + Boolean.hashCode(this.isPinned)) * 31) + Integer.hashCode(this.categoryType);
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final boolean isProduct() {
        ArrayList<MarketProductItem> arrayList;
        return ((this.categoryType != EnumC21325tT3.CategoryItemsType_PRODUCT_ONLY.getNumber() && this.categoryType != EnumC21325tT3.CategoryItemsType_FOR_YOU_PRODUCT_ONLY.getNumber()) || (arrayList = this.products) == null || arrayList.isEmpty()) ? false : true;
    }

    public final void setDisplayCount(int i) {
        this.displayCount = i;
    }

    public final void setItems(ArrayList<MarketItem> arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.items = arrayList;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setProducts(ArrayList<MarketProductItem> arrayList) {
        this.products = arrayList;
    }

    public final boolean shoudApplyTintOnDrawable() {
        return getDrawableIdResource() != KB5.market_category_basalam;
    }

    public final String toJson() {
        try {
            return new KS2().t(this);
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
            return null;
        }
    }

    public String toString() {
        return "MarketSection(id=" + this.id + ", drawableId=" + this.drawableId + ", items=" + this.items + ", products=" + this.products + ", title=" + this.title + ", dialog=" + this.dialog + ", displayCount=" + this.displayCount + ", isPinned=" + this.isPinned + ", categoryType=" + this.categoryType + Separators.RPAREN;
    }

    public final void validate() {
        Iterator<T> it = this.items.iterator();
        while (it.hasNext()) {
            ((MarketItem) it.next()).validate();
        }
        ArrayList<MarketProductItem> arrayList = this.products;
        if (arrayList != null) {
            Iterator<T> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((MarketProductItem) it2.next()).validate();
            }
        }
        MarketDialog marketDialog = this.dialog;
        if (marketDialog != null) {
            marketDialog.validate();
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeInt(this.id);
        dest.writeString(this.drawableId);
        ArrayList<MarketItem> arrayList = this.items;
        dest.writeInt(arrayList.size());
        Iterator<MarketItem> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        ArrayList<MarketProductItem> arrayList2 = this.products;
        if (arrayList2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList2.size());
            Iterator<MarketProductItem> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.title);
        MarketDialog marketDialog = this.dialog;
        if (marketDialog == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            marketDialog.writeToParcel(dest, flags);
        }
        dest.writeInt(this.displayCount);
        dest.writeInt(this.isPinned ? 1 : 0);
        dest.writeInt(this.categoryType);
    }

    public /* synthetic */ MarketSection(int i, String str, ArrayList arrayList, ArrayList arrayList2, String str2, MarketDialog marketDialog, int i2, boolean z, int i3, int i4, ED1 ed1) {
        this(i, str, arrayList, arrayList2, str2, (i4 & 32) != 0 ? null : marketDialog, (i4 & 64) != 0 ? -1 : i2, (i4 & 128) != 0 ? false : z, i3);
    }
}
