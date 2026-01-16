package ir.nasim.features.payment.data.model;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\fH×\u0001¢\u0006\u0004\b\u0015\u0010\u0012J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H×\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010\u0014R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b\u001a\u0010\u0014R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001f\u001a\u0004\b \u0010\u0014¨\u0006!"}, d2 = {"Lir/nasim/features/payment/data/model/StatementItem;", "Landroid/os/Parcelable;", "", "isDeposit", "", "date", "amount", "description", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Z", "d", "()Z", "b", "Ljava/lang/String;", "c", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final /* data */ class StatementItem implements Parcelable {
    public static final Parcelable.Creator<StatementItem> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final boolean isDeposit;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final String date;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final String amount;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final String description;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final StatementItem createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new StatementItem(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final StatementItem[] newArray(int i) {
            return new StatementItem[i];
        }
    }

    public StatementItem(boolean z, String str, String str2, String str3) {
        this.isDeposit = z;
        this.date = str;
        this.amount = str2;
        this.description = str3;
    }

    /* renamed from: a, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: b, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsDeposit() {
        return this.isDeposit;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatementItem)) {
            return false;
        }
        StatementItem statementItem = (StatementItem) other;
        return this.isDeposit == statementItem.isDeposit && AbstractC13042fc3.d(this.date, statementItem.date) && AbstractC13042fc3.d(this.amount, statementItem.amount) && AbstractC13042fc3.d(this.description, statementItem.description);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isDeposit) * 31;
        String str = this.date;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.amount;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "StatementItem(isDeposit=" + this.isDeposit + ", date=" + this.date + ", amount=" + this.amount + ", description=" + this.description + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeInt(this.isDeposit ? 1 : 0);
        dest.writeString(this.date);
        dest.writeString(this.amount);
        dest.writeString(this.description);
    }
}
