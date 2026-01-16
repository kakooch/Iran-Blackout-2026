package ir.nasim.core.modules.market.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lir/nasim/core/modules/market/model/MarketItemMore;", "Landroid/os/Parcelable;", "Lir/nasim/core/modules/market/model/MarketSection;", "row", "<init>", "(Lir/nasim/core/modules/market/model/MarketSection;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lir/nasim/core/modules/market/model/MarketSection;", "getRow", "()Lir/nasim/core/modules/market/model/MarketSection;", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final class MarketItemMore implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<MarketItemMore> CREATOR = new a();
    private final MarketSection row;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MarketItemMore createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new MarketItemMore(MarketSection.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MarketItemMore[] newArray(int i) {
            return new MarketItemMore[i];
        }
    }

    public MarketItemMore(MarketSection marketSection) {
        AbstractC13042fc3.i(marketSection, "row");
        this.row = marketSection;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final MarketSection getRow() {
        return this.row;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        this.row.writeToParcel(dest, flags);
    }
}
