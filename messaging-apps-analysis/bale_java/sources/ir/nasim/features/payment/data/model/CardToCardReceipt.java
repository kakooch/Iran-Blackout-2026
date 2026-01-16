package ir.nasim.features.payment.data.model;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000eH×\u0001¢\u0006\u0004\b\u0017\u0010\u0014J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H×\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b\"\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b$\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b\u001d\u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b \u0010\u0016¨\u0006%"}, d2 = {"Lir/nasim/features/payment/data/model/CardToCardReceipt;", "Landroid/os/Parcelable;", "", "traceNumber", "moneyAmount", "srcCard", "destCard", "destName", "date", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "g", "b", "e", "c", "f", "d", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final /* data */ class CardToCardReceipt implements Parcelable {
    public static final Parcelable.Creator<CardToCardReceipt> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final String traceNumber;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final String moneyAmount;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final String srcCard;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final String destCard;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final String destName;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private final String date;

    /* renamed from: g, reason: from kotlin metadata and from toString */
    private final String description;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CardToCardReceipt createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new CardToCardReceipt(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CardToCardReceipt[] newArray(int i) {
            return new CardToCardReceipt[i];
        }
    }

    public CardToCardReceipt(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AbstractC13042fc3.i(str, "traceNumber");
        AbstractC13042fc3.i(str2, "moneyAmount");
        AbstractC13042fc3.i(str3, "srcCard");
        AbstractC13042fc3.i(str4, "destCard");
        AbstractC13042fc3.i(str5, "destName");
        AbstractC13042fc3.i(str6, "date");
        this.traceNumber = str;
        this.moneyAmount = str2;
        this.srcCard = str3;
        this.destCard = str4;
        this.destName = str5;
        this.date = str6;
        this.description = str7;
    }

    /* renamed from: a, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: b, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: c, reason: from getter */
    public final String getDestCard() {
        return this.destCard;
    }

    /* renamed from: d, reason: from getter */
    public final String getDestName() {
        return this.destName;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getMoneyAmount() {
        return this.moneyAmount;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardToCardReceipt)) {
            return false;
        }
        CardToCardReceipt cardToCardReceipt = (CardToCardReceipt) other;
        return AbstractC13042fc3.d(this.traceNumber, cardToCardReceipt.traceNumber) && AbstractC13042fc3.d(this.moneyAmount, cardToCardReceipt.moneyAmount) && AbstractC13042fc3.d(this.srcCard, cardToCardReceipt.srcCard) && AbstractC13042fc3.d(this.destCard, cardToCardReceipt.destCard) && AbstractC13042fc3.d(this.destName, cardToCardReceipt.destName) && AbstractC13042fc3.d(this.date, cardToCardReceipt.date) && AbstractC13042fc3.d(this.description, cardToCardReceipt.description);
    }

    /* renamed from: f, reason: from getter */
    public final String getSrcCard() {
        return this.srcCard;
    }

    /* renamed from: g, reason: from getter */
    public final String getTraceNumber() {
        return this.traceNumber;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.traceNumber.hashCode() * 31) + this.moneyAmount.hashCode()) * 31) + this.srcCard.hashCode()) * 31) + this.destCard.hashCode()) * 31) + this.destName.hashCode()) * 31) + this.date.hashCode()) * 31;
        String str = this.description;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "CardToCardReceipt(traceNumber=" + this.traceNumber + ", moneyAmount=" + this.moneyAmount + ", srcCard=" + this.srcCard + ", destCard=" + this.destCard + ", destName=" + this.destName + ", date=" + this.date + ", description=" + this.description + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeString(this.traceNumber);
        dest.writeString(this.moneyAmount);
        dest.writeString(this.srcCard);
        dest.writeString(this.destCard);
        dest.writeString(this.destName);
        dest.writeString(this.date);
        dest.writeString(this.description);
    }
}
