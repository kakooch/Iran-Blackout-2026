package ir.nasim.features.payment.data.model;

import ai.bale.proto.CollectionsStruct$BooleanValue;
import ai.bale.proto.SapStruct$CardExpirationDate;
import ai.bale.proto.SapStruct$CardInfo;
import ai.bale.proto.SapStruct$DestinationCard;
import ai.bale.proto.SapStruct$UserCard;
import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C10410bZ6;
import ir.nasim.C19406qI3;
import ir.nasim.C20481s50;
import ir.nasim.ED1;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.ZY6;
import ir.nasim.features.payment.data.response.Bank;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b3\b\u0087\b\u0018\u0000 R2\u00020\u0001:\u0002STB{\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0014J\u001a\u0010\u001a\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0096\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0005H\u0007¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0007¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u0014J\u0010\u0010(\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u0014J\u0012\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b)\u0010*J\u0012\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b+\u0010*J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u0014J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\u0014J\u0010\u0010.\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b2\u0010/J\u0010\u00103\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b3\u0010/J\u0010\u00104\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b4\u0010/J\u0088\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\nHÇ\u0001¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b7\u0010\u0014J\u0010\u00108\u001a\u00020\u0005H×\u0001¢\u0006\u0004\b8\u0010&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u00109\u001a\u0004\b:\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u00109\u001a\u0004\b;\u0010\u0014R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010<\u001a\u0004\b=\u0010*\"\u0004\b>\u0010?R$\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010<\u001a\u0004\b@\u0010*\"\u0004\bA\u0010?R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u00109\u001a\u0004\bB\u0010\u0014\"\u0004\bC\u0010DR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u00109\u001a\u0004\bE\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010F\u001a\u0004\b\u000b\u0010/R\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010G\u001a\u0004\bH\u00101R\"\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010F\u001a\u0004\b\u000e\u0010/\"\u0004\bI\u0010JR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010F\u001a\u0004\b\u000f\u0010/\"\u0004\bK\u0010JR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010F\u001a\u0004\b\u0010\u0010/\"\u0004\bL\u0010JR$\u0010M\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010\u001e\"\u0004\bP\u0010Q¨\u0006U"}, d2 = {"Lir/nasim/features/payment/data/model/BankCreditCard;", "Landroid/os/Parcelable;", "", "id", "number", "", "expirationMonth", "expirationYear", "cvv2", "ownerName", "", "isSavedInServerSide", "Lir/nasim/features/payment/data/model/BankCreditCard$c;", "type", "isDefault", "isShaparkMigrationNeed", "isEnrolled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLir/nasim/features/payment/data/model/BankCreditCard$c;ZZZ)V", "getSpacedNumber", "()Ljava/lang/String;", "getRealExpirationMonth", "getRealExpirationYear", "getRealFullExpirationDate", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/features/payment/data/response/Bank;", "getBank", "()Lir/nasim/features/payment/data/response/Bank;", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "component5", "component6", "component7", "()Z", "component8", "()Lir/nasim/features/payment/data/model/BankCreditCard$c;", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLir/nasim/features/payment/data/model/BankCreditCard$c;ZZZ)Lir/nasim/features/payment/data/model/BankCreditCard;", "toString", "hashCode", "Ljava/lang/String;", "getId", "getNumber", "Ljava/lang/Integer;", "getExpirationMonth", "setExpirationMonth", "(Ljava/lang/Integer;)V", "getExpirationYear", "setExpirationYear", "getCvv2", "setCvv2", "(Ljava/lang/String;)V", "getOwnerName", "Z", "Lir/nasim/features/payment/data/model/BankCreditCard$c;", "getType", "setDefault", "(Z)V", "setShaparkMigrationNeed", "setEnrolled", "mBank", "Lir/nasim/features/payment/data/response/Bank;", "getMBank", "setMBank", "(Lir/nasim/features/payment/data/response/Bank;)V", "Companion", "a", "c", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes6.dex */
public final /* data */ class BankCreditCard implements Parcelable {
    public static final String DESTINATION_MIGRATED_DONE = "newCardManagementMigratedDone_DESTIONATION";
    public static final String SOURCE_MIGRATED_DONE = "newCardManagementMigratedDone";
    public static final String STORAGE_PREFIX = "CreditCard_";

    @InterfaceC23984xq6("cvv2")
    private String cvv2;

    @InterfaceC23984xq6("expirationMonth")
    private Integer expirationMonth;

    @InterfaceC23984xq6("expirationYear")
    private Integer expirationYear;

    @InterfaceC23984xq6("id")
    private final String id;

    @InterfaceC23984xq6("isDefault")
    private boolean isDefault;

    @InterfaceC23984xq6("isEnrolled")
    private boolean isEnrolled;

    @InterfaceC23984xq6("isSavedInServerSide")
    private final boolean isSavedInServerSide;

    @InterfaceC23984xq6("isShaparkMigrationNeed")
    private boolean isShaparkMigrationNeed;
    private Bank mBank;

    @InterfaceC23984xq6("number")
    private final String number;

    @InterfaceC23984xq6("ownerName")
    private final String ownerName;

    @InterfaceC23984xq6("type")
    private final c type;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    public static final Parcelable.Creator<BankCreditCard> CREATOR = new b();

    /* renamed from: ir.nasim.features.payment.data.model.BankCreditCard$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final List a(List list) {
            AbstractC13042fc3.i(list, "list");
            ArrayList arrayList = new ArrayList();
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    BankCreditCard bankCreditCard = (BankCreditCard) it.next();
                    String id = bankCreditCard.getId();
                    if (id == null) {
                        id = "-1";
                    }
                    String ownerName = bankCreditCard.getOwnerName();
                    if (ownerName == null) {
                        ownerName = "";
                    }
                    GeneratedMessageLite generatedMessageLiteA = SapStruct$DestinationCard.newBuilder().B(id).C(bankCreditCard.getNumber()).A(ownerName).a();
                    AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
                    arrayList.add(generatedMessageLiteA);
                }
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
            return arrayList;
        }

        public final ArrayList b(List list) {
            AbstractC13042fc3.i(list, "list");
            ArrayList arrayList = new ArrayList();
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    SapStruct$DestinationCard sapStruct$DestinationCard = (SapStruct$DestinationCard) it.next();
                    String id = sapStruct$DestinationCard.getId();
                    String number = sapStruct$DestinationCard.getNumber();
                    AbstractC13042fc3.h(number, "getNumber(...)");
                    arrayList.add(new BankCreditCard(id, number, null, null, null, sapStruct$DestinationCard.getHolderName(), true, c.b, false, false, false, 1820, null));
                }
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
            return arrayList;
        }

        public final List c(ArrayList arrayList) {
            AbstractC13042fc3.i(arrayList, "list");
            ArrayList arrayList2 = new ArrayList();
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    BankCreditCard bankCreditCard = (BankCreditCard) it.next();
                    SapStruct$CardInfo.a aVarC = SapStruct$CardInfo.newBuilder().C(bankCreditCard.getNumber());
                    Integer expirationMonth = bankCreditCard.getExpirationMonth();
                    Integer expirationYear = bankCreditCard.getExpirationYear();
                    if (expirationMonth != null && expirationYear != null) {
                        aVarC.B((SapStruct$CardExpirationDate) SapStruct$CardExpirationDate.newBuilder().A(expirationMonth.intValue()).B(expirationYear.intValue()).a());
                    }
                    arrayList2.add(aVarC.a());
                }
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
            return arrayList2;
        }

        public final ArrayList d(List list) {
            AbstractC13042fc3.i(list, "list");
            C10410bZ6 c10410bZ6L = AbstractC5969Lp4.c().l();
            String str = c10410bZ6L != null ? (String) c10410bZ6L.b() : null;
            ArrayList arrayList = new ArrayList();
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    SapStruct$UserCard sapStruct$UserCard = (SapStruct$UserCard) it.next();
                    String cardId = sapStruct$UserCard.getCardId();
                    SapStruct$CardInfo cardInfo = sapStruct$UserCard.getCardInfo();
                    AbstractC13042fc3.f(cardInfo);
                    String cardNumber = cardInfo.getCardNumber();
                    AbstractC13042fc3.h(cardNumber, "getCardNumber(...)");
                    SapStruct$CardInfo cardInfo2 = sapStruct$UserCard.getCardInfo();
                    AbstractC13042fc3.f(cardInfo2);
                    SapStruct$CardExpirationDate cardExpDate = cardInfo2.getCardExpDate();
                    Integer numValueOf = cardExpDate != null ? Integer.valueOf(cardExpDate.getCardExpirationMonth()) : null;
                    SapStruct$CardInfo cardInfo3 = sapStruct$UserCard.getCardInfo();
                    AbstractC13042fc3.f(cardInfo3);
                    SapStruct$CardExpirationDate cardExpDate2 = cardInfo3.getCardExpDate();
                    Integer numValueOf2 = cardExpDate2 != null ? Integer.valueOf(cardExpDate2.getCardExpirationYear()) : null;
                    SapStruct$CardInfo cardInfo4 = sapStruct$UserCard.getCardInfo();
                    AbstractC13042fc3.f(cardInfo4);
                    boolean zD = AbstractC13042fc3.d(str, cardInfo4.getCardNumber());
                    c cVar = c.a;
                    CollectionsStruct$BooleanValue isEnrolled = sapStruct$UserCard.getIsEnrolled();
                    arrayList.add(new BankCreditCard(cardId, cardNumber, numValueOf, numValueOf2, null, null, true, cVar, zD, false, isEnrolled != null && isEnrolled.getValue(), 560, null));
                }
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
            }
            return arrayList;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BankCreditCard createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new BankCreditCard(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() != 0, c.valueOf(parcel.readString()), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final BankCreditCard[] newArray(int i) {
            return new BankCreditCard[i];
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class c {
        public static final c a = new c("SOURCE", 0);
        public static final c b = new c("DESTINATION", 1);
        private static final /* synthetic */ c[] c;
        private static final /* synthetic */ F92 d;

        static {
            c[] cVarArrA = a();
            c = cVarArrA;
            d = G92.a(cVarArrA);
        }

        private c(String str, int i) {
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{a, b};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) c.clone();
        }
    }

    public BankCreditCard(String str, String str2, Integer num, Integer num2, String str3, String str4, boolean z, c cVar, boolean z2, boolean z3, boolean z4) {
        AbstractC13042fc3.i(str2, "number");
        AbstractC13042fc3.i(cVar, "type");
        this.id = str;
        this.number = str2;
        this.expirationMonth = num;
        this.expirationYear = num2;
        this.cvv2 = str3;
        this.ownerName = str4;
        this.isSavedInServerSide = z;
        this.type = cVar;
        this.isDefault = z2;
        this.isShaparkMigrationNeed = z3;
        this.isEnrolled = z4;
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsShaparkMigrationNeed() {
        return this.isShaparkMigrationNeed;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsEnrolled() {
        return this.isEnrolled;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNumber() {
        return this.number;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getExpirationMonth() {
        return this.expirationMonth;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getExpirationYear() {
        return this.expirationYear;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCvv2() {
        return this.cvv2;
    }

    /* renamed from: component6, reason: from getter */
    public final String getOwnerName() {
        return this.ownerName;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsSavedInServerSide() {
        return this.isSavedInServerSide;
    }

    /* renamed from: component8, reason: from getter */
    public final c getType() {
        return this.type;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    public final BankCreditCard copy(String id, String number, Integer expirationMonth, Integer expirationYear, String cvv2, String ownerName, boolean isSavedInServerSide, c type, boolean isDefault, boolean isShaparkMigrationNeed, boolean isEnrolled) {
        AbstractC13042fc3.i(number, "number");
        AbstractC13042fc3.i(type, "type");
        return new BankCreditCard(id, number, expirationMonth, expirationYear, cvv2, ownerName, isSavedInServerSide, type, isDefault, isShaparkMigrationNeed, isEnrolled);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof BankCreditCard)) {
            return false;
        }
        BankCreditCard bankCreditCard = (BankCreditCard) other;
        return AbstractC13042fc3.d(bankCreditCard.id, this.id) && AbstractC13042fc3.d(bankCreditCard.number, this.number);
    }

    public final Bank getBank() {
        if (this.mBank == null) {
            C20481s50 c20481s50 = C20481s50.a;
            String strSubstring = ZY6.a(this.number).substring(0, 6);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            this.mBank = c20481s50.c(strSubstring);
        }
        return this.mBank;
    }

    public final String getCvv2() {
        return this.cvv2;
    }

    public final Integer getExpirationMonth() {
        return this.expirationMonth;
    }

    public final Integer getExpirationYear() {
        return this.expirationYear;
    }

    public final String getId() {
        return this.id;
    }

    public final Bank getMBank() {
        return this.mBank;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public final String getRealExpirationMonth() {
        Integer num = this.expirationMonth;
        if (num == null) {
            return null;
        }
        AbstractC13042fc3.f(num);
        if (num.intValue() >= 10) {
            return String.valueOf(this.expirationMonth);
        }
        return "0" + this.expirationMonth;
    }

    public final String getRealExpirationYear() {
        Integer num = this.expirationYear;
        if (num == null) {
            return null;
        }
        AbstractC13042fc3.f(num);
        if (num.intValue() >= 10) {
            return String.valueOf(this.expirationYear);
        }
        return "0" + this.expirationYear;
    }

    public final String getRealFullExpirationDate() {
        if (this.expirationYear == null || this.expirationMonth == null) {
            return null;
        }
        return getRealExpirationYear() + getRealExpirationMonth();
    }

    public final String getSpacedNumber() {
        String strSubstring = this.number.substring(0, 4);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        String strSubstring2 = this.number.substring(4, 8);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        String strSubstring3 = this.number.substring(8, 12);
        AbstractC13042fc3.h(strSubstring3, "substring(...)");
        String strSubstring4 = this.number.substring(12, 16);
        AbstractC13042fc3.h(strSubstring4, "substring(...)");
        return strSubstring + Separators.SP + strSubstring2 + Separators.SP + strSubstring3 + Separators.SP + strSubstring4;
    }

    public final c getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.number.hashCode()) * 31;
        Integer num = this.expirationMonth;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.expirationYear;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.cvv2;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ownerName;
        return ((((((((((iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31) + Boolean.hashCode(this.isSavedInServerSide)) * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.isDefault)) * 31) + Boolean.hashCode(this.isShaparkMigrationNeed)) * 31) + Boolean.hashCode(this.isEnrolled);
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final boolean isEnrolled() {
        return this.isEnrolled;
    }

    public final boolean isSavedInServerSide() {
        return this.isSavedInServerSide;
    }

    public final boolean isShaparkMigrationNeed() {
        return this.isShaparkMigrationNeed;
    }

    public final void setCvv2(String str) {
        this.cvv2 = str;
    }

    public final void setDefault(boolean z) {
        this.isDefault = z;
    }

    public final void setEnrolled(boolean z) {
        this.isEnrolled = z;
    }

    public final void setExpirationMonth(Integer num) {
        this.expirationMonth = num;
    }

    public final void setExpirationYear(Integer num) {
        this.expirationYear = num;
    }

    public final void setMBank(Bank bank) {
        this.mBank = bank;
    }

    public final void setShaparkMigrationNeed(boolean z) {
        this.isShaparkMigrationNeed = z;
    }

    public String toString() {
        return "BankCreditCard(id=" + this.id + ", number=" + this.number + ", expirationMonth=" + this.expirationMonth + ", expirationYear=" + this.expirationYear + ", cvv2=" + this.cvv2 + ", ownerName=" + this.ownerName + ", isSavedInServerSide=" + this.isSavedInServerSide + ", type=" + this.type + ", isDefault=" + this.isDefault + ", isShaparkMigrationNeed=" + this.isShaparkMigrationNeed + ", isEnrolled=" + this.isEnrolled + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.number);
        Integer num = this.expirationMonth;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.expirationYear;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeString(this.cvv2);
        dest.writeString(this.ownerName);
        dest.writeInt(this.isSavedInServerSide ? 1 : 0);
        dest.writeString(this.type.name());
        dest.writeInt(this.isDefault ? 1 : 0);
        dest.writeInt(this.isShaparkMigrationNeed ? 1 : 0);
        dest.writeInt(this.isEnrolled ? 1 : 0);
    }

    public /* synthetic */ BankCreditCard(String str, String str2, Integer num, Integer num2, String str3, String str4, boolean z, c cVar, boolean z2, boolean z3, boolean z4, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : str, str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? false : z, cVar, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? false : z3, (i & 1024) != 0 ? false : z4);
    }
}
