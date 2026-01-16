package ir.nasim.features.payment.data.model;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\fH×\u0001¢\u0006\u0004\b\u0015\u0010\u0012J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H×\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001e\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b\u001f\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001b\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b \u0010\u0014¨\u0006!"}, d2 = {"Lir/nasim/features/payment/data/model/BalanceReceipt;", "Landroid/os/Parcelable;", "", "cardNumber", "bankName", "realBalance", "balance", "wage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "c", "b", "d", "e", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final /* data */ class BalanceReceipt implements Parcelable {
    public static final Parcelable.Creator<BalanceReceipt> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final String cardNumber;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final String bankName;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final String realBalance;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final String balance;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final String wage;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BalanceReceipt createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new BalanceReceipt(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final BalanceReceipt[] newArray(int i) {
            return new BalanceReceipt[i];
        }
    }

    public BalanceReceipt(String str, String str2, String str3, String str4, String str5) {
        AbstractC13042fc3.i(str, "cardNumber");
        AbstractC13042fc3.i(str2, "bankName");
        AbstractC13042fc3.i(str3, "realBalance");
        AbstractC13042fc3.i(str4, "balance");
        AbstractC13042fc3.i(str5, "wage");
        this.cardNumber = str;
        this.bankName = str2;
        this.realBalance = str3;
        this.balance = str4;
        this.wage = str5;
    }

    /* renamed from: a, reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* renamed from: b, reason: from getter */
    public final String getBankName() {
        return this.bankName;
    }

    /* renamed from: c, reason: from getter */
    public final String getCardNumber() {
        return this.cardNumber;
    }

    /* renamed from: d, reason: from getter */
    public final String getRealBalance() {
        return this.realBalance;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final String getWage() {
        return this.wage;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BalanceReceipt)) {
            return false;
        }
        BalanceReceipt balanceReceipt = (BalanceReceipt) other;
        return AbstractC13042fc3.d(this.cardNumber, balanceReceipt.cardNumber) && AbstractC13042fc3.d(this.bankName, balanceReceipt.bankName) && AbstractC13042fc3.d(this.realBalance, balanceReceipt.realBalance) && AbstractC13042fc3.d(this.balance, balanceReceipt.balance) && AbstractC13042fc3.d(this.wage, balanceReceipt.wage);
    }

    public int hashCode() {
        return (((((((this.cardNumber.hashCode() * 31) + this.bankName.hashCode()) * 31) + this.realBalance.hashCode()) * 31) + this.balance.hashCode()) * 31) + this.wage.hashCode();
    }

    public String toString() {
        return "BalanceReceipt(cardNumber=" + this.cardNumber + ", bankName=" + this.bankName + ", realBalance=" + this.realBalance + ", balance=" + this.balance + ", wage=" + this.wage + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeString(this.cardNumber);
        dest.writeString(this.bankName);
        dest.writeString(this.realBalance);
        dest.writeString(this.balance);
        dest.writeString(this.wage);
    }
}
