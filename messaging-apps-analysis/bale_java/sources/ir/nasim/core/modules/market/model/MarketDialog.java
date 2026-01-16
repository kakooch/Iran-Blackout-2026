package ir.nasim.core.modules.market.model;

import ai.bale.proto.MarketStruct$MarketMenuItemDialog;
import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import com.google.gson.JsonParseException;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÇ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0017\u0010\u0013J\u0010\u0010\u0018\u001a\u00020\fH×\u0001¢\u0006\u0004\b\u0018\u0010\u0011J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H×\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b \u0010\u0013¨\u0006#"}, d2 = {"Lir/nasim/core/modules/market/model/MarketDialog;", "Landroid/os/Parcelable;", "", "description", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Lir/nasim/rB7;", "validate", "()V", "Landroid/os/Parcel;", "dest", "", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lir/nasim/core/modules/market/model/MarketDialog;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "getTitle", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class MarketDialog implements Parcelable {
    public static final int $stable = 0;

    @InterfaceC23984xq6("description")
    private final String description;

    @InterfaceC23984xq6("title")
    private final String title;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<MarketDialog> CREATOR = new b();

    /* renamed from: ir.nasim.core.modules.market.model.MarketDialog$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final MarketDialog a(MarketStruct$MarketMenuItemDialog marketStruct$MarketMenuItemDialog) {
            String description;
            AbstractC13042fc3.i(marketStruct$MarketMenuItemDialog, "dialog");
            String title = marketStruct$MarketMenuItemDialog.getTitle();
            if ((title == null || title.length() == 0) && ((description = marketStruct$MarketMenuItemDialog.getDescription()) == null || description.length() == 0)) {
                return null;
            }
            String description2 = marketStruct$MarketMenuItemDialog.getDescription();
            AbstractC13042fc3.h(description2, "getDescription(...)");
            String title2 = marketStruct$MarketMenuItemDialog.getTitle();
            AbstractC13042fc3.h(title2, "getTitle(...)");
            return new MarketDialog(description2, title2);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MarketDialog createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new MarketDialog(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MarketDialog[] newArray(int i) {
            return new MarketDialog[i];
        }
    }

    public MarketDialog(String str, String str2) {
        AbstractC13042fc3.i(str, "description");
        AbstractC13042fc3.i(str2, "title");
        this.description = str;
        this.title = str2;
    }

    public static /* synthetic */ MarketDialog copy$default(MarketDialog marketDialog, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = marketDialog.description;
        }
        if ((i & 2) != 0) {
            str2 = marketDialog.title;
        }
        return marketDialog.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final MarketDialog copy(String description, String title) {
        AbstractC13042fc3.i(description, "description");
        AbstractC13042fc3.i(title, "title");
        return new MarketDialog(description, title);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketDialog)) {
            return false;
        }
        MarketDialog marketDialog = (MarketDialog) other;
        return AbstractC13042fc3.d(this.description, marketDialog.description) && AbstractC13042fc3.d(this.title, marketDialog.title);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.description.hashCode() * 31) + this.title.hashCode();
    }

    public String toString() {
        return "MarketDialog(description=" + this.description + ", title=" + this.title + Separators.RPAREN;
    }

    public final void validate() {
        if (this.description == null) {
            throw new JsonParseException("'description' is null!");
        }
        if (this.title == null) {
            throw new JsonParseException("'title' is null!");
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeString(this.description);
        dest.writeString(this.title);
    }
}
