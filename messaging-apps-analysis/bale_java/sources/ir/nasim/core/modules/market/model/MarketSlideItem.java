package ir.nasim.core.modules.market.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import com.google.gson.JsonParseException;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.C19406qI3;
import ir.nasim.C5721Ko;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.KS2;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0001;BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b \u0010\u000fJ\u0012\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u001cJ\u0010\u0010$\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001cJP\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b'\u0010\u000fJ\u0010\u0010(\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b(\u0010\u001cJ\u001a\u0010+\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010)H×\u0003¢\u0006\u0004\b+\u0010,R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010/\u001a\u0004\b0\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u00101\u001a\u0004\b2\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u00103\u001a\u0004\b4\u0010\"R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010-\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u00107R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010-\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u00107¨\u0006<"}, d2 = {"Lir/nasim/core/modules/market/model/MarketSlideItem;", "Landroid/os/Parcelable;", "", "id", "Lir/nasim/core/modules/market/model/Action;", "action", "", "imageUrl", "Lir/nasim/core/modules/market/model/MarketDialog;", "dialog", "minAppVersion", "maxAppVersion", "<init>", "(ILir/nasim/core/modules/market/model/Action;Ljava/lang/String;Lir/nasim/core/modules/market/model/MarketDialog;II)V", "getUrlPathOnly", "()Ljava/lang/String;", "Lir/nasim/rB7;", "validate", "()V", "", "canUseForThisVersionApp", "()Z", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Lir/nasim/core/modules/market/model/Action;", "component3", "component4", "()Lir/nasim/core/modules/market/model/MarketDialog;", "component5", "component6", "copy", "(ILir/nasim/core/modules/market/model/Action;Ljava/lang/String;Lir/nasim/core/modules/market/model/MarketDialog;II)Lir/nasim/core/modules/market/model/MarketSlideItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "getId", "Lir/nasim/core/modules/market/model/Action;", "getAction", "Ljava/lang/String;", "getImageUrl", "Lir/nasim/core/modules/market/model/MarketDialog;", "getDialog", "getMinAppVersion", "setMinAppVersion", "(I)V", "getMaxAppVersion", "setMaxAppVersion", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class MarketSlideItem implements Parcelable {

    @InterfaceC23984xq6("action")
    private final Action action;

    @InterfaceC23984xq6("dialog")
    private final MarketDialog dialog;

    @InterfaceC23984xq6("id")
    private final int id;

    @InterfaceC23984xq6("imageUrl")
    private final String imageUrl;

    @InterfaceC23984xq6("maxAppVersion")
    private int maxAppVersion;

    @InterfaceC23984xq6("minAppVersion")
    private int minAppVersion;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    public static final Parcelable.Creator<MarketSlideItem> CREATOR = new b();

    /* renamed from: ir.nasim.core.modules.market.model.MarketSlideItem$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final ArrayList a(String str) {
            AbstractC13042fc3.i(str, "json");
            try {
                Object objK = new KS2().k(str, MarketSlideItem[].class);
                AbstractC13042fc3.h(objK, "fromJson(...)");
                List listF1 = AbstractC10242bK.f1((Object[]) objK);
                Iterator it = listF1.iterator();
                while (it.hasNext()) {
                    ((MarketSlideItem) it.next()).validate();
                }
                return new ArrayList(listF1);
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
        public final MarketSlideItem createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new MarketSlideItem(parcel.readInt(), parcel.readInt() == 0 ? null : Action.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() != 0 ? MarketDialog.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MarketSlideItem[] newArray(int i) {
            return new MarketSlideItem[i];
        }
    }

    public MarketSlideItem(int i, Action action, String str, MarketDialog marketDialog, int i2, int i3) {
        AbstractC13042fc3.i(str, "imageUrl");
        this.id = i;
        this.action = action;
        this.imageUrl = str;
        this.dialog = marketDialog;
        this.minAppVersion = i2;
        this.maxAppVersion = i3;
    }

    public static /* synthetic */ MarketSlideItem copy$default(MarketSlideItem marketSlideItem, int i, Action action, String str, MarketDialog marketDialog, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = marketSlideItem.id;
        }
        if ((i4 & 2) != 0) {
            action = marketSlideItem.action;
        }
        Action action2 = action;
        if ((i4 & 4) != 0) {
            str = marketSlideItem.imageUrl;
        }
        String str2 = str;
        if ((i4 & 8) != 0) {
            marketDialog = marketSlideItem.dialog;
        }
        MarketDialog marketDialog2 = marketDialog;
        if ((i4 & 16) != 0) {
            i2 = marketSlideItem.minAppVersion;
        }
        int i5 = i2;
        if ((i4 & 32) != 0) {
            i3 = marketSlideItem.maxAppVersion;
        }
        return marketSlideItem.copy(i, action2, str2, marketDialog2, i5, i3);
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

    /* renamed from: component2, reason: from getter */
    public final Action getAction() {
        return this.action;
    }

    /* renamed from: component3, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final MarketDialog getDialog() {
        return this.dialog;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMinAppVersion() {
        return this.minAppVersion;
    }

    /* renamed from: component6, reason: from getter */
    public final int getMaxAppVersion() {
        return this.maxAppVersion;
    }

    public final MarketSlideItem copy(int id, Action action, String imageUrl, MarketDialog dialog, int minAppVersion, int maxAppVersion) {
        AbstractC13042fc3.i(imageUrl, "imageUrl");
        return new MarketSlideItem(id, action, imageUrl, dialog, minAppVersion, maxAppVersion);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketSlideItem)) {
            return false;
        }
        MarketSlideItem marketSlideItem = (MarketSlideItem) other;
        return this.id == marketSlideItem.id && AbstractC13042fc3.d(this.action, marketSlideItem.action) && AbstractC13042fc3.d(this.imageUrl, marketSlideItem.imageUrl) && AbstractC13042fc3.d(this.dialog, marketSlideItem.dialog) && this.minAppVersion == marketSlideItem.minAppVersion && this.maxAppVersion == marketSlideItem.maxAppVersion;
    }

    public final Action getAction() {
        return this.action;
    }

    public final MarketDialog getDialog() {
        return this.dialog;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final int getMaxAppVersion() {
        return this.maxAppVersion;
    }

    public final int getMinAppVersion() {
        return this.minAppVersion;
    }

    public final String getUrlPathOnly() {
        Action action = this.action;
        if ((action != null ? action.getUrl() : null) == null) {
            return null;
        }
        URI uri = new URI(this.action.getUrl());
        String str = "";
        if (uri.getPath() != null) {
            AbstractC13042fc3.h(uri.getPath(), "getPath(...)");
            if (!AbstractC20762sZ6.n0(r1)) {
                String path = uri.getPath();
                AbstractC13042fc3.h(path, "getPath(...)");
                if (path.length() > 0) {
                    str = "" + uri.getPath();
                }
            }
        }
        if (uri.getQuery() != null) {
            AbstractC13042fc3.h(uri.getQuery(), "getQuery(...)");
            if (!AbstractC20762sZ6.n0(r1)) {
                String query = uri.getQuery();
                AbstractC13042fc3.h(query, "getQuery(...)");
                if (query.length() > 0) {
                    return str + Separators.QUESTION + uri.getQuery();
                }
            }
        }
        return str;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id) * 31;
        Action action = this.action;
        int iHashCode2 = (((iHashCode + (action == null ? 0 : action.hashCode())) * 31) + this.imageUrl.hashCode()) * 31;
        MarketDialog marketDialog = this.dialog;
        return ((((iHashCode2 + (marketDialog != null ? marketDialog.hashCode() : 0)) * 31) + Integer.hashCode(this.minAppVersion)) * 31) + Integer.hashCode(this.maxAppVersion);
    }

    public final void setMaxAppVersion(int i) {
        this.maxAppVersion = i;
    }

    public final void setMinAppVersion(int i) {
        this.minAppVersion = i;
    }

    public String toString() {
        return "MarketSlideItem(id=" + this.id + ", action=" + this.action + ", imageUrl=" + this.imageUrl + ", dialog=" + this.dialog + ", minAppVersion=" + this.minAppVersion + ", maxAppVersion=" + this.maxAppVersion + Separators.RPAREN;
    }

    public final void validate() {
        Action action = this.action;
        if (action != null) {
            action.validate();
        }
        if (this.imageUrl == null) {
            throw new JsonParseException("'imageUrl' is null!");
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
        dest.writeString(this.imageUrl);
        MarketDialog marketDialog = this.dialog;
        if (marketDialog == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            marketDialog.writeToParcel(dest, flags);
        }
        dest.writeInt(this.minAppVersion);
        dest.writeInt(this.maxAppVersion);
    }

    public /* synthetic */ MarketSlideItem(int i, Action action, String str, MarketDialog marketDialog, int i2, int i3, int i4, ED1 ed1) {
        this((i4 & 1) != 0 ? -1 : i, action, str, marketDialog, (i4 & 16) != 0 ? C5721Ko.a.h() : i2, (i4 & 32) != 0 ? C5721Ko.a.h() : i3);
    }
}
