package ir.nasim.features.payment.data.model;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u0016\u0010\u0013J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H×\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001f¨\u0006 "}, d2 = {"Lir/nasim/features/payment/data/model/SelectableOption;", "Landroid/os/Parcelable;", "", "title", "", "longValue", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "", "c", "()Z", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "Ljava/lang/Long;", "()Ljava/lang/Long;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final /* data */ class SelectableOption implements Parcelable {
    public static final Parcelable.Creator<SelectableOption> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final String title;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final Long longValue;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SelectableOption createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new SelectableOption(parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SelectableOption[] newArray(int i) {
            return new SelectableOption[i];
        }
    }

    public SelectableOption(String str, Long l) {
        AbstractC13042fc3.i(str, "title");
        this.title = str;
        this.longValue = l;
    }

    /* renamed from: a, reason: from getter */
    public final Long getLongValue() {
        return this.longValue;
    }

    /* renamed from: b, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final boolean c() {
        return this.longValue != null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectableOption)) {
            return false;
        }
        SelectableOption selectableOption = (SelectableOption) other;
        return AbstractC13042fc3.d(this.title, selectableOption.title) && AbstractC13042fc3.d(this.longValue, selectableOption.longValue);
    }

    public int hashCode() {
        int iHashCode = this.title.hashCode() * 31;
        Long l = this.longValue;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "SelectableOption(title=" + this.title + ", longValue=" + this.longValue + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeString(this.title);
        Long l = this.longValue;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
    }
}
