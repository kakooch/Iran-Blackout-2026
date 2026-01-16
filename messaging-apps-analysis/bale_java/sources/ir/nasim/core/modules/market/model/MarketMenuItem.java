package ir.nasim.core.modules.market.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import com.google.gson.JsonParseException;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C5721Ko;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.KB5;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0002H\u0007¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010!J\u0012\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b'\u0010(J\u0012\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b)\u0010(J\u0012\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b*\u0010(J\u0010\u0010+\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b+\u0010\u001aJ\u0010\u0010,\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b,\u0010(J\u0010\u0010-\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b-\u0010!J\u0010\u0010.\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b.\u0010!J~\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\bH×\u0001¢\u0006\u0004\b1\u0010(J\u0010\u00102\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b2\u0010!J\u001a\u00105\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103H×\u0003¢\u0006\u0004\b5\u00106R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u00107\u001a\u0004\b8\u0010!R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u00109\u001a\u0004\b:\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010;\u001a\u0004\b<\u0010&R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010=\u001a\u0004\b>\u0010(R\u001c\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010=\u001a\u0004\b?\u0010(R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010=\u001a\u0004\b@\u0010(R\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010A\u001a\u0004\b\r\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010=\u001a\u0004\bB\u0010(R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u00107\u001a\u0004\bC\u0010!\"\u0004\bD\u0010ER\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u00107\u001a\u0004\bF\u0010!\"\u0004\bG\u0010E¨\u0006H"}, d2 = {"Lir/nasim/core/modules/market/model/MarketMenuItem;", "Landroid/os/Parcelable;", "", "id", "Lir/nasim/core/modules/market/model/Action;", "action", "Lir/nasim/core/modules/market/model/MarketDialog;", "dialog", "", "badge", "drawableId", "drawableUrl", "", "isDisable", "title", "minAppVersion", "maxAppVersion", "<init>", "(ILir/nasim/core/modules/market/model/Action;Lir/nasim/core/modules/market/model/MarketDialog;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;II)V", "Lir/nasim/rB7;", "validate", "()V", "getDrawableIdResource", "()Ljava/lang/Integer;", "getDialogDrawableIdResource", "canUseForThisVersionApp", "()Z", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Lir/nasim/core/modules/market/model/Action;", "component3", "()Lir/nasim/core/modules/market/model/MarketDialog;", "component4", "()Ljava/lang/String;", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(ILir/nasim/core/modules/market/model/Action;Lir/nasim/core/modules/market/model/MarketDialog;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;II)Lir/nasim/core/modules/market/model/MarketMenuItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "getId", "Lir/nasim/core/modules/market/model/Action;", "getAction", "Lir/nasim/core/modules/market/model/MarketDialog;", "getDialog", "Ljava/lang/String;", "getBadge", "getDrawableId", "getDrawableUrl", "Z", "getTitle", "getMinAppVersion", "setMinAppVersion", "(I)V", "getMaxAppVersion", "setMaxAppVersion", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class MarketMenuItem implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<MarketMenuItem> CREATOR = new a();

    @InterfaceC23984xq6("action")
    private final Action action;

    @InterfaceC23984xq6("badge")
    private final String badge;

    @InterfaceC23984xq6("dialog")
    private final MarketDialog dialog;

    @InterfaceC23984xq6("drawableId")
    private final String drawableId;

    @InterfaceC23984xq6("drawableUrl")
    private final String drawableUrl;

    @InterfaceC23984xq6("id")
    private final int id;

    @InterfaceC23984xq6("isDisable")
    private final boolean isDisable;

    @InterfaceC23984xq6("maxAppVersion")
    private int maxAppVersion;

    @InterfaceC23984xq6("minAppVersion")
    private int minAppVersion;

    @InterfaceC23984xq6("title")
    private final String title;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MarketMenuItem createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new MarketMenuItem(parcel.readInt(), parcel.readInt() == 0 ? null : Action.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? MarketDialog.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MarketMenuItem[] newArray(int i) {
            return new MarketMenuItem[i];
        }
    }

    public MarketMenuItem(int i, Action action, MarketDialog marketDialog, String str, String str2, String str3, boolean z, String str4, int i2, int i3) {
        AbstractC13042fc3.i(str4, "title");
        this.id = i;
        this.action = action;
        this.dialog = marketDialog;
        this.badge = str;
        this.drawableId = str2;
        this.drawableUrl = str3;
        this.isDisable = z;
        this.title = str4;
        this.minAppVersion = i2;
        this.maxAppVersion = i3;
    }

    public final boolean canUseForThisVersionApp() {
        int i = this.minAppVersion;
        boolean z = i == 0 || (i != 0 && i <= C5721Ko.a.h());
        int i2 = this.maxAppVersion;
        return z && (i2 == 0 || (i2 != 0 && i2 >= C5721Ko.a.h()));
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final int getMaxAppVersion() {
        return this.maxAppVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final Action getAction() {
        return this.action;
    }

    /* renamed from: component3, reason: from getter */
    public final MarketDialog getDialog() {
        return this.dialog;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBadge() {
        return this.badge;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDrawableId() {
        return this.drawableId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDrawableUrl() {
        return this.drawableUrl;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsDisable() {
        return this.isDisable;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component9, reason: from getter */
    public final int getMinAppVersion() {
        return this.minAppVersion;
    }

    public final MarketMenuItem copy(int id, Action action, MarketDialog dialog, String badge, String drawableId, String drawableUrl, boolean isDisable, String title, int minAppVersion, int maxAppVersion) {
        AbstractC13042fc3.i(title, "title");
        return new MarketMenuItem(id, action, dialog, badge, drawableId, drawableUrl, isDisable, title, minAppVersion, maxAppVersion);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketMenuItem)) {
            return false;
        }
        MarketMenuItem marketMenuItem = (MarketMenuItem) other;
        return this.id == marketMenuItem.id && AbstractC13042fc3.d(this.action, marketMenuItem.action) && AbstractC13042fc3.d(this.dialog, marketMenuItem.dialog) && AbstractC13042fc3.d(this.badge, marketMenuItem.badge) && AbstractC13042fc3.d(this.drawableId, marketMenuItem.drawableId) && AbstractC13042fc3.d(this.drawableUrl, marketMenuItem.drawableUrl) && this.isDisable == marketMenuItem.isDisable && AbstractC13042fc3.d(this.title, marketMenuItem.title) && this.minAppVersion == marketMenuItem.minAppVersion && this.maxAppVersion == marketMenuItem.maxAppVersion;
    }

    public final Action getAction() {
        return this.action;
    }

    public final String getBadge() {
        return this.badge;
    }

    public final MarketDialog getDialog() {
        return this.dialog;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final Integer getDialogDrawableIdResource() {
        String str = this.drawableId;
        if (str != null) {
            switch (str.hashCode()) {
                case -2085937953:
                    if (str.equals("create_market")) {
                        return Integer.valueOf(KB5.market_menu_create_market_dialog);
                    }
                    break;
                case -563990934:
                    if (str.equals("credit_ads")) {
                        return Integer.valueOf(KB5.market_menu_credit_ads_dialog);
                    }
                    break;
                case 96432:
                    if (str.equals(SearchSuggestion.ADS_ICON)) {
                        return Integer.valueOf(KB5.market_menu_adds_dialog);
                    }
                    break;
                case 3202695:
                    if (str.equals("hint")) {
                        return Integer.valueOf(KB5.market_menu_hint_dialog);
                    }
                    break;
                case 3327216:
                    if (str.equals("loan")) {
                        return Integer.valueOf(KB5.market_menu_loan_dialog);
                    }
                    break;
                case 109264530:
                    if (str.equals("score")) {
                        return Integer.valueOf(KB5.market_menu_score_dialog);
                    }
                    break;
                case 881381098:
                    if (str.equals("create_invoice")) {
                        return Integer.valueOf(KB5.market_menu_create_invoice_dialog);
                    }
                    break;
            }
        }
        return null;
    }

    public final String getDrawableId() {
        return this.drawableId;
    }

    public final Integer getDrawableIdResource() {
        if (this.isDisable) {
            String str = this.drawableId;
            if (str == null) {
                return null;
            }
            switch (str.hashCode()) {
                case -2085937953:
                    if (str.equals("create_market")) {
                        return Integer.valueOf(KB5.market_menu_create_market_disabled);
                    }
                    return null;
                case -1684212218:
                    if (str.equals("widespread")) {
                        return Integer.valueOf(KB5.market_menu_widespread_disabled);
                    }
                    return null;
                case -563990934:
                    if (str.equals("credit_ads")) {
                        return Integer.valueOf(KB5.market_menu_credit_ads_disabled);
                    }
                    return null;
                case 96432:
                    if (str.equals(SearchSuggestion.ADS_ICON)) {
                        return Integer.valueOf(KB5.market_menu_adds_disabled);
                    }
                    return null;
                case 3202695:
                    if (str.equals("hint")) {
                        return Integer.valueOf(KB5.market_menu_hint_disabled);
                    }
                    return null;
                case 3327216:
                    if (str.equals("loan")) {
                        return Integer.valueOf(KB5.market_menu_loan_disabled);
                    }
                    return null;
                case 109264530:
                    if (str.equals("score")) {
                        return Integer.valueOf(KB5.market_menu_score_disabled);
                    }
                    return null;
                case 881381098:
                    if (str.equals("create_invoice")) {
                        return Integer.valueOf(KB5.market_menu_create_invoice_disabled);
                    }
                    return null;
                default:
                    return null;
            }
        }
        String str2 = this.drawableId;
        if (str2 == null) {
            return null;
        }
        switch (str2.hashCode()) {
            case -2085937953:
                if (str2.equals("create_market")) {
                    return Integer.valueOf(KB5.market_menu_create_market);
                }
                return null;
            case -1684212218:
                if (str2.equals("widespread")) {
                    return Integer.valueOf(KB5.market_menu_widespread);
                }
                return null;
            case -563990934:
                if (str2.equals("credit_ads")) {
                    return Integer.valueOf(KB5.market_menu_credit_ads);
                }
                return null;
            case 96432:
                if (str2.equals(SearchSuggestion.ADS_ICON)) {
                    return Integer.valueOf(KB5.market_menu_adds);
                }
                return null;
            case 3202695:
                if (str2.equals("hint")) {
                    return Integer.valueOf(KB5.market_menu_hint);
                }
                return null;
            case 3327216:
                if (str2.equals("loan")) {
                    return Integer.valueOf(KB5.market_menu_loan);
                }
                return null;
            case 109264530:
                if (str2.equals("score")) {
                    return Integer.valueOf(KB5.market_menu_score);
                }
                return null;
            case 881381098:
                if (str2.equals("create_invoice")) {
                    return Integer.valueOf(KB5.market_menu_create_invoice);
                }
                return null;
            default:
                return null;
        }
    }

    public final String getDrawableUrl() {
        return this.drawableUrl;
    }

    public final int getId() {
        return this.id;
    }

    public final int getMaxAppVersion() {
        return this.maxAppVersion;
    }

    public final int getMinAppVersion() {
        return this.minAppVersion;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id) * 31;
        Action action = this.action;
        int iHashCode2 = (iHashCode + (action == null ? 0 : action.hashCode())) * 31;
        MarketDialog marketDialog = this.dialog;
        int iHashCode3 = (iHashCode2 + (marketDialog == null ? 0 : marketDialog.hashCode())) * 31;
        String str = this.badge;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.drawableId;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.drawableUrl;
        return ((((((((iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31) + Boolean.hashCode(this.isDisable)) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.minAppVersion)) * 31) + Integer.hashCode(this.maxAppVersion);
    }

    public final boolean isDisable() {
        return this.isDisable;
    }

    public final void setMaxAppVersion(int i) {
        this.maxAppVersion = i;
    }

    public final void setMinAppVersion(int i) {
        this.minAppVersion = i;
    }

    public String toString() {
        return "MarketMenuItem(id=" + this.id + ", action=" + this.action + ", dialog=" + this.dialog + ", badge=" + this.badge + ", drawableId=" + this.drawableId + ", drawableUrl=" + this.drawableUrl + ", isDisable=" + this.isDisable + ", title=" + this.title + ", minAppVersion=" + this.minAppVersion + ", maxAppVersion=" + this.maxAppVersion + Separators.RPAREN;
    }

    public final void validate() {
        if (this.title == null) {
            throw new JsonParseException("'title' is null!");
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
        Action action = this.action;
        if (action == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            action.writeToParcel(dest, flags);
        }
        MarketDialog marketDialog = this.dialog;
        if (marketDialog == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            marketDialog.writeToParcel(dest, flags);
        }
        dest.writeString(this.badge);
        dest.writeString(this.drawableId);
        dest.writeString(this.drawableUrl);
        dest.writeInt(this.isDisable ? 1 : 0);
        dest.writeString(this.title);
        dest.writeInt(this.minAppVersion);
        dest.writeInt(this.maxAppVersion);
    }

    public /* synthetic */ MarketMenuItem(int i, Action action, MarketDialog marketDialog, String str, String str2, String str3, boolean z, String str4, int i2, int i3, int i4, ED1 ed1) {
        this((i4 & 1) != 0 ? -1 : i, action, marketDialog, str, str2, str3, z, str4, (i4 & 256) != 0 ? C5721Ko.a.h() : i2, (i4 & 512) != 0 ? C5721Ko.a.h() : i3);
    }
}
