package ir.nasim.features.pfm.entity;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.EnumC18897pR4;
import ir.nasim.features.pfm.tags.PFMTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0017H\u0007¢\u0006\u0004\b \u0010\u0019J\u0010\u0010!\u001a\u00020\u0005H×\u0001¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010,\u001a\u0004\b)\u0010\"\"\u0004\b-\u0010.R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010$\u001a\u0004\b#\u0010&\"\u0004\b6\u0010(R$\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010,\u001a\u0004\b5\u0010\"\"\u0004\b8\u0010.R(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010,\u001a\u0004\b7\u0010\"\"\u0004\b>\u0010.R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010?\u001a\u0004\b/\u0010@\"\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lir/nasim/features/pfm/entity/PFMTransaction;", "Landroid/os/Parcelable;", "", "id", "date", "", "amount", "Lir/nasim/pR4;", "transactionType", "accountNumber", "description", "", "Lir/nasim/features/pfm/tags/PFMTag;", "labels", "detail", "dateTimeStamp", "<init>", "(JJLjava/lang/String;Lir/nasim/pR4;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "toString", "()Ljava/lang/String;", "a", "J", "g", "()J", "setId", "(J)V", "b", "c", "setDate", "Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "d", "Lir/nasim/pR4;", "i", "()Lir/nasim/pR4;", "setTransactionType", "(Lir/nasim/pR4;)V", "e", "setAccountNumber", "f", "setDescription", "Ljava/util/List;", "h", "()Ljava/util/List;", "k", "(Ljava/util/List;)V", "j", "Ljava/lang/Long;", "()Ljava/lang/Long;", "setDateTimeStamp", "(Ljava/lang/Long;)V", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final /* data */ class PFMTransaction implements Parcelable {
    public static final Parcelable.Creator<PFMTransaction> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private long id;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private long date;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private String amount;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private EnumC18897pR4 transactionType;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private long accountNumber;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private String description;

    /* renamed from: g, reason: from kotlin metadata and from toString */
    private List labels;

    /* renamed from: h, reason: from kotlin metadata and from toString */
    private String detail;

    /* renamed from: i, reason: from kotlin metadata and from toString */
    private Long dateTimeStamp;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PFMTransaction createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            String string = parcel.readString();
            EnumC18897pR4 enumC18897pR4ValueOf = parcel.readInt() == 0 ? null : EnumC18897pR4.valueOf(parcel.readString());
            long j3 = parcel.readLong();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(PFMTag.CREATOR.createFromParcel(parcel));
            }
            return new PFMTransaction(j, j2, string, enumC18897pR4ValueOf, j3, string2, arrayList, parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PFMTransaction[] newArray(int i) {
            return new PFMTransaction[i];
        }
    }

    public PFMTransaction(long j, long j2, String str, EnumC18897pR4 enumC18897pR4, long j3, String str2, List list, String str3, Long l) {
        AbstractC13042fc3.i(str, "amount");
        AbstractC13042fc3.i(list, "labels");
        AbstractC13042fc3.i(str3, "detail");
        this.id = j;
        this.date = j2;
        this.amount = str;
        this.transactionType = enumC18897pR4;
        this.accountNumber = j3;
        this.description = str2;
        this.labels = list;
        this.detail = str3;
        this.dateTimeStamp = l;
    }

    /* renamed from: a, reason: from getter */
    public final long getAccountNumber() {
        return this.accountNumber;
    }

    /* renamed from: b, reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: c, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* renamed from: d, reason: from getter */
    public final Long getDateTimeStamp() {
        return this.dateTimeStamp;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public boolean equals(Object other) {
        if (!(other instanceof PFMTransaction)) {
            return false;
        }
        PFMTransaction pFMTransaction = (PFMTransaction) other;
        return this.id == pFMTransaction.id && AbstractC13042fc3.d(this.amount, pFMTransaction.amount);
    }

    /* renamed from: f, reason: from getter */
    public final String getDetail() {
        return this.detail;
    }

    /* renamed from: g, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: h, reason: from getter */
    public final List getLabels() {
        return this.labels;
    }

    public int hashCode() {
        return (int) (this.id % Integer.MAX_VALUE);
    }

    /* renamed from: i, reason: from getter */
    public final EnumC18897pR4 getTransactionType() {
        return this.transactionType;
    }

    public final void j(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.detail = str;
    }

    public final void k(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.labels = list;
    }

    public String toString() {
        return "PFMTransaction(id=" + this.id + ", date=" + this.date + ", amount=" + this.amount + ", transactionType=" + this.transactionType + ", accountNumber=" + this.accountNumber + ", description=" + this.description + ", labels=" + this.labels + ", detail=" + this.detail + ", dateTimeStamp=" + this.dateTimeStamp + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeLong(this.id);
        dest.writeLong(this.date);
        dest.writeString(this.amount);
        EnumC18897pR4 enumC18897pR4 = this.transactionType;
        if (enumC18897pR4 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(enumC18897pR4.name());
        }
        dest.writeLong(this.accountNumber);
        dest.writeString(this.description);
        List list = this.labels;
        dest.writeInt(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PFMTag) it.next()).writeToParcel(dest, flags);
        }
        dest.writeString(this.detail);
        Long l = this.dateTimeStamp;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
    }

    public /* synthetic */ PFMTransaction(long j, long j2, String str, EnumC18897pR4 enumC18897pR4, long j3, String str2, List list, String str3, Long l, int i, ED1 ed1) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? null : enumC18897pR4, (i & 16) != 0 ? 0L : j3, (i & 32) == 0 ? str2 : null, (i & 64) != 0 ? new ArrayList() : list, (i & 128) == 0 ? str3 : "", (i & 256) != 0 ? 0L : l);
    }
}
