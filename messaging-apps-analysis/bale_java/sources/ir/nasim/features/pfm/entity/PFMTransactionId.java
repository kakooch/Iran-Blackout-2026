package ir.nasim.features.pfm.entity;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.EnumC18897pR4;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H×\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\fH×\u0001¢\u0006\u0004\b\u0016\u0010\u0012J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H×\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b\u001f\u0010\u001eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#¨\u0006$"}, d2 = {"Lir/nasim/features/pfm/entity/PFMTransactionId;", "Landroid/os/Parcelable;", "", "accountNumber", DialogEntity.COLUMN_RID, "date", "Lir/nasim/pR4;", "type", "<init>", "(JJJLir/nasim/pR4;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "J", "()J", "b", "c", "d", "Lir/nasim/pR4;", "()Lir/nasim/pR4;", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final /* data */ class PFMTransactionId implements Parcelable {
    public static final Parcelable.Creator<PFMTransactionId> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final long accountNumber;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final long rid;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final long date;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final EnumC18897pR4 type;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PFMTransactionId createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new PFMTransactionId(parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readInt() == 0 ? null : EnumC18897pR4.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PFMTransactionId[] newArray(int i) {
            return new PFMTransactionId[i];
        }
    }

    public PFMTransactionId(long j, long j2, long j3, EnumC18897pR4 enumC18897pR4) {
        this.accountNumber = j;
        this.rid = j2;
        this.date = j3;
        this.type = enumC18897pR4;
    }

    /* renamed from: a, reason: from getter */
    public final long getAccountNumber() {
        return this.accountNumber;
    }

    /* renamed from: b, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* renamed from: c, reason: from getter */
    public final long getRid() {
        return this.rid;
    }

    /* renamed from: d, reason: from getter */
    public final EnumC18897pR4 getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PFMTransactionId)) {
            return false;
        }
        PFMTransactionId pFMTransactionId = (PFMTransactionId) other;
        return this.accountNumber == pFMTransactionId.accountNumber && this.rid == pFMTransactionId.rid && this.date == pFMTransactionId.date && this.type == pFMTransactionId.type;
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.accountNumber) * 31) + Long.hashCode(this.rid)) * 31) + Long.hashCode(this.date)) * 31;
        EnumC18897pR4 enumC18897pR4 = this.type;
        return iHashCode + (enumC18897pR4 == null ? 0 : enumC18897pR4.hashCode());
    }

    public String toString() {
        return "PFMTransactionId(accountNumber=" + this.accountNumber + ", rid=" + this.rid + ", date=" + this.date + ", type=" + this.type + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeLong(this.accountNumber);
        dest.writeLong(this.rid);
        dest.writeLong(this.date);
        EnumC18897pR4 enumC18897pR4 = this.type;
        if (enumC18897pR4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(enumC18897pR4.name());
        }
    }
}
