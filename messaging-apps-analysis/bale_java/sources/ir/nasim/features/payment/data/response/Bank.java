package ir.nasim.features.payment.data.response;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C20481s50;
import ir.nasim.InterfaceC23984xq6;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0015J\u0010\u0010\u0019\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0015J\u0010\u0010\u001a\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJR\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÇ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0003H×\u0001¢\u0006\u0004\b!\u0010\u001bJ\u0010\u0010\"\u001a\u00020\u0005H×\u0001¢\u0006\u0004\b\"\u0010\u0015J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#H×\u0003¢\u0006\u0004\b&\u0010'R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010(\u001a\u0004\b)\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b+\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b,\u0010\u0015R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010-\u001a\u0004\b.\u0010\u001bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010/\u001a\u0004\b0\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010/\u001a\u0004\b1\u0010\u001dR*\u00102\u001a\u0004\u0018\u00010\u00058F@\u0006X\u0086\u000e¢\u0006\u0018\n\u0004\b2\u00103\u0012\u0004\b8\u00109\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006:"}, d2 = {"Lir/nasim/features/payment/data/response/Bank;", "Landroid/os/Parcelable;", "", "", "cardNumberPattern", "", "minimumAmount", "maximumAmount", "name", "Lir/nasim/features/payment/data/response/Status;", "sourceStatus", "destinationStatus", "<init>", "(Ljava/util/List;IILjava/lang/String;Lir/nasim/features/payment/data/response/Status;Lir/nasim/features/payment/data/response/Status;)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/List;", "component2", "component3", "component4", "()Ljava/lang/String;", "component5", "()Lir/nasim/features/payment/data/response/Status;", "component6", "copy", "(Ljava/util/List;IILjava/lang/String;Lir/nasim/features/payment/data/response/Status;Lir/nasim/features/payment/data/response/Status;)Lir/nasim/features/payment/data/response/Bank;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getCardNumberPattern", TokenNames.I, "getMinimumAmount", "getMaximumAmount", "Ljava/lang/String;", "getName", "Lir/nasim/features/payment/data/response/Status;", "getSourceStatus", "getDestinationStatus", "drawableId", "Ljava/lang/Integer;", "getDrawableId", "()Ljava/lang/Integer;", "setDrawableId", "(Ljava/lang/Integer;)V", "getDrawableId$annotations", "()V", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes6.dex */
public final /* data */ class Bank implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<Bank> CREATOR = new a();

    @InterfaceC23984xq6("CardNumberPattern")
    private final List<String> cardNumberPattern;

    @InterfaceC23984xq6("DestinationStatus")
    private final Status destinationStatus;
    private Integer drawableId;

    @InterfaceC23984xq6("MaximumAmount")
    private final int maximumAmount;

    @InterfaceC23984xq6("MinimumAmount")
    private final int minimumAmount;

    @InterfaceC23984xq6("Name")
    private final String name;

    @InterfaceC23984xq6("SourceStatus")
    private final Status sourceStatus;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Bank createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            String string = parcel.readString();
            Parcelable.Creator<Status> creator = Status.CREATOR;
            return new Bank(arrayListCreateStringArrayList, i, i2, string, creator.createFromParcel(parcel), creator.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Bank[] newArray(int i) {
            return new Bank[i];
        }
    }

    public Bank(List<String> list, int i, int i2, String str, Status status, Status status2) {
        AbstractC13042fc3.i(list, "cardNumberPattern");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(status, "sourceStatus");
        AbstractC13042fc3.i(status2, "destinationStatus");
        this.cardNumberPattern = list;
        this.minimumAmount = i;
        this.maximumAmount = i2;
        this.name = str;
        this.sourceStatus = status;
        this.destinationStatus = status2;
    }

    public static /* synthetic */ Bank copy$default(Bank bank, List list, int i, int i2, String str, Status status, Status status2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = bank.cardNumberPattern;
        }
        if ((i3 & 2) != 0) {
            i = bank.minimumAmount;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = bank.maximumAmount;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            str = bank.name;
        }
        String str2 = str;
        if ((i3 & 16) != 0) {
            status = bank.sourceStatus;
        }
        Status status3 = status;
        if ((i3 & 32) != 0) {
            status2 = bank.destinationStatus;
        }
        return bank.copy(list, i4, i5, str2, status3, status2);
    }

    public static /* synthetic */ void getDrawableId$annotations() {
    }

    public final List<String> component1() {
        return this.cardNumberPattern;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMinimumAmount() {
        return this.minimumAmount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMaximumAmount() {
        return this.maximumAmount;
    }

    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component5, reason: from getter */
    public final Status getSourceStatus() {
        return this.sourceStatus;
    }

    /* renamed from: component6, reason: from getter */
    public final Status getDestinationStatus() {
        return this.destinationStatus;
    }

    public final Bank copy(List<String> cardNumberPattern, int minimumAmount, int maximumAmount, String name, Status sourceStatus, Status destinationStatus) {
        AbstractC13042fc3.i(cardNumberPattern, "cardNumberPattern");
        AbstractC13042fc3.i(name, "name");
        AbstractC13042fc3.i(sourceStatus, "sourceStatus");
        AbstractC13042fc3.i(destinationStatus, "destinationStatus");
        return new Bank(cardNumberPattern, minimumAmount, maximumAmount, name, sourceStatus, destinationStatus);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Bank)) {
            return false;
        }
        Bank bank = (Bank) other;
        return AbstractC13042fc3.d(this.cardNumberPattern, bank.cardNumberPattern) && this.minimumAmount == bank.minimumAmount && this.maximumAmount == bank.maximumAmount && AbstractC13042fc3.d(this.name, bank.name) && AbstractC13042fc3.d(this.sourceStatus, bank.sourceStatus) && AbstractC13042fc3.d(this.destinationStatus, bank.destinationStatus);
    }

    public final List<String> getCardNumberPattern() {
        return this.cardNumberPattern;
    }

    public final Status getDestinationStatus() {
        return this.destinationStatus;
    }

    public final Integer getDrawableId() {
        Integer num = this.drawableId;
        if (num != null) {
            return num;
        }
        C20481s50 c20481s50 = C20481s50.a;
        this.drawableId = c20481s50.e(this.cardNumberPattern);
        return c20481s50.e(this.cardNumberPattern);
    }

    public final int getMaximumAmount() {
        return this.maximumAmount;
    }

    public final int getMinimumAmount() {
        return this.minimumAmount;
    }

    public final String getName() {
        return this.name;
    }

    public final Status getSourceStatus() {
        return this.sourceStatus;
    }

    public int hashCode() {
        return (((((((((this.cardNumberPattern.hashCode() * 31) + Integer.hashCode(this.minimumAmount)) * 31) + Integer.hashCode(this.maximumAmount)) * 31) + this.name.hashCode()) * 31) + this.sourceStatus.hashCode()) * 31) + this.destinationStatus.hashCode();
    }

    public final void setDrawableId(Integer num) {
        this.drawableId = num;
    }

    public String toString() {
        return "Bank(cardNumberPattern=" + this.cardNumberPattern + ", minimumAmount=" + this.minimumAmount + ", maximumAmount=" + this.maximumAmount + ", name=" + this.name + ", sourceStatus=" + this.sourceStatus + ", destinationStatus=" + this.destinationStatus + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeStringList(this.cardNumberPattern);
        dest.writeInt(this.minimumAmount);
        dest.writeInt(this.maximumAmount);
        dest.writeString(this.name);
        this.sourceStatus.writeToParcel(dest, flags);
        this.destinationStatus.writeToParcel(dest, flags);
    }
}
