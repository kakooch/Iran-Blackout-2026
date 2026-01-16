package ir.nasim.core.modules.market.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001,B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J:\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007HÇ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u001c\u0010\u0015J\u0010\u0010\u001d\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u001d\u0010\u0012J\u001a\u0010 \u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH×\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010\u0017R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010(\u001a\u0004\b\b\u0010\u0019\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lir/nasim/core/modules/market/model/MarketCategory;", "Landroid/os/Parcelable;", "", "id", "", "title", "drawableId", "", "isSelected", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Z)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Ljava/lang/String;", "component3", "()Ljava/lang/Integer;", "component4", "()Z", "copy", "(ILjava/lang/String;Ljava/lang/Integer;Z)Lir/nasim/core/modules/market/model/MarketCategory;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "getId", "Ljava/lang/String;", "getTitle", "Ljava/lang/Integer;", "getDrawableId", "Z", "setSelected", "(Z)V", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class MarketCategory implements Parcelable {
    public static final int FEMALE_ID = 1;
    public static final int MALE_ID = 0;
    private final Integer drawableId;
    private final int id;
    private boolean isSelected;
    private final String title;
    public static final int $stable = 8;
    public static final Parcelable.Creator<MarketCategory> CREATOR = new b();

    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MarketCategory createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new MarketCategory(parcel.readInt(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MarketCategory[] newArray(int i) {
            return new MarketCategory[i];
        }
    }

    public MarketCategory(int i, String str, Integer num, boolean z) {
        AbstractC13042fc3.i(str, "title");
        this.id = i;
        this.title = str;
        this.drawableId = num;
        this.isSelected = z;
    }

    public static /* synthetic */ MarketCategory copy$default(MarketCategory marketCategory, int i, String str, Integer num, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = marketCategory.id;
        }
        if ((i2 & 2) != 0) {
            str = marketCategory.title;
        }
        if ((i2 & 4) != 0) {
            num = marketCategory.drawableId;
        }
        if ((i2 & 8) != 0) {
            z = marketCategory.isSelected;
        }
        return marketCategory.copy(i, str, num, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getDrawableId() {
        return this.drawableId;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final MarketCategory copy(int id, String title, Integer drawableId, boolean isSelected) {
        AbstractC13042fc3.i(title, "title");
        return new MarketCategory(id, title, drawableId, isSelected);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketCategory)) {
            return false;
        }
        MarketCategory marketCategory = (MarketCategory) other;
        return this.id == marketCategory.id && AbstractC13042fc3.d(this.title, marketCategory.title) && AbstractC13042fc3.d(this.drawableId, marketCategory.drawableId) && this.isSelected == marketCategory.isSelected;
    }

    public final Integer getDrawableId() {
        return this.drawableId;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31;
        Integer num = this.drawableId;
        return ((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.isSelected);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public String toString() {
        return "MarketCategory(id=" + this.id + ", title=" + this.title + ", drawableId=" + this.drawableId + ", isSelected=" + this.isSelected + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        int iIntValue;
        AbstractC13042fc3.i(dest, "dest");
        dest.writeInt(this.id);
        dest.writeString(this.title);
        Integer num = this.drawableId;
        if (num == null) {
            iIntValue = 0;
        } else {
            dest.writeInt(1);
            iIntValue = num.intValue();
        }
        dest.writeInt(iIntValue);
        dest.writeInt(this.isSelected ? 1 : 0);
    }

    public /* synthetic */ MarketCategory(int i, String str, Integer num, boolean z, int i2, ED1 ed1) {
        this(i, str, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? false : z);
    }
}
