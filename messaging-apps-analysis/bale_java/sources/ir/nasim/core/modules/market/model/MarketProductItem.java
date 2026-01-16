package ir.nasim.core.modules.market.model;

import ai.bale.proto.MarketStruct$Product;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C5721Ko;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0001DBU\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u001f\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\tH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\tH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0017J\u0010\u0010!\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0017J\u0012\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b(\u0010'J\u0010\u0010)\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b)\u0010\u001fJ\u0010\u0010*\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b*\u0010\u001fJj\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tHÇ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b-\u0010\u0017J\u0010\u0010.\u001a\u00020\tH×\u0001¢\u0006\u0004\b.\u0010\u001fJ\u001a\u00101\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u00010/H×\u0003¢\u0006\u0004\b1\u00102R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u00103\u001a\u0004\b4\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u00105\u001a\u0004\b6\u0010\"R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u00103\u001a\u0004\b7\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u00108\u001a\u0004\b9\u0010%R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010:\u001a\u0004\b;\u0010'R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010:\u001a\u0004\b<\u0010'R\"\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010=\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010@R\"\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010=\u001a\u0004\bA\u0010\u001f\"\u0004\bB\u0010@¨\u0006E"}, d2 = {"Lir/nasim/core/modules/market/model/MarketProductItem;", "Landroid/os/Parcelable;", "", "title", "Lir/nasim/core/modules/market/model/MarketPost;", "post", "price", "", "rate", "", "rateCount", "discount", "minAppVersion", "maxAppVersion", "<init>", "(Ljava/lang/String;Lir/nasim/core/modules/market/model/MarketPost;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;II)V", "", "canUseForThisVersionApp", "()Z", "Lir/nasim/rB7;", "validate", "()V", "getUrl", "()Ljava/lang/String;", "getUrlPathOnly", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Lir/nasim/core/modules/market/model/MarketPost;", "component3", "component4", "()Ljava/lang/Float;", "component5", "()Ljava/lang/Integer;", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Lir/nasim/core/modules/market/model/MarketPost;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;II)Lir/nasim/core/modules/market/model/MarketProductItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Lir/nasim/core/modules/market/model/MarketPost;", "getPost", "getPrice", "Ljava/lang/Float;", "getRate", "Ljava/lang/Integer;", "getRateCount", "getDiscount", TokenNames.I, "getMinAppVersion", "setMinAppVersion", "(I)V", "getMaxAppVersion", "setMaxAppVersion", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class MarketProductItem implements Parcelable {

    @InterfaceC23984xq6("discount")
    private final Integer discount;

    @InterfaceC23984xq6("maxAppVersion")
    private int maxAppVersion;
    private int minAppVersion;

    @InterfaceC23984xq6("post")
    private final MarketPost post;

    @InterfaceC23984xq6("price")
    private final String price;

    @InterfaceC23984xq6("rate")
    private final Float rate;

    @InterfaceC23984xq6("rateCount")
    private final Integer rateCount;

    @InterfaceC23984xq6("title")
    private final String title;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    public static final Parcelable.Creator<MarketProductItem> CREATOR = new b();

    /* renamed from: ir.nasim.core.modules.market.model.MarketProductItem$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final ir.nasim.core.modules.market.model.MarketProductItem a(ai.bale.proto.MarketStruct$Product r14) {
            /*
                r13 = this;
                java.lang.String r0 = "response"
                ir.nasim.AbstractC13042fc3.i(r14, r0)
                com.google.protobuf.StringValue r0 = r14.getTitle()
                r1 = 0
                if (r0 == 0) goto L23
                com.google.protobuf.StringValue r0 = r14.getTitle()
                ir.nasim.AbstractC13042fc3.f(r0)
                java.lang.String r0 = r0.getValue()
                if (r0 == 0) goto L23
                com.google.protobuf.StringValue r0 = r14.getTitle()
                java.lang.String r0 = r0.getValue()
                r3 = r0
                goto L24
            L23:
                r3 = r1
            L24:
                com.google.protobuf.Int32Value r0 = r14.getFinalPrice()
                if (r0 == 0) goto L38
                com.google.protobuf.Int32Value r0 = r14.getFinalPrice()
                int r0 = r0.getValue()
                java.lang.String r0 = java.lang.String.valueOf(r0)
                r5 = r0
                goto L39
            L38:
                r5 = r1
            L39:
                com.google.protobuf.StringValue r0 = r14.getScore()
                if (r0 == 0) goto L76
                com.google.protobuf.StringValue r0 = r14.getScore()
                if (r0 == 0) goto L4a
                java.lang.String r0 = r0.getValue()
                goto L4b
            L4a:
                r0 = r1
            L4b:
                if (r0 == 0) goto L76
                com.google.protobuf.StringValue r0 = r14.getScore()
                java.lang.String r0 = r0.getValue()
                java.lang.String r2 = "getValue(...)"
                ir.nasim.AbstractC13042fc3.h(r0, r2)
                int r0 = r0.length()
                if (r0 <= 0) goto L76
                com.google.protobuf.StringValue r0 = r14.getScore()
                if (r0 == 0) goto L76
                java.lang.String r0 = r0.getValue()
                if (r0 == 0) goto L76
                float r0 = java.lang.Float.parseFloat(r0)
                java.lang.Float r0 = java.lang.Float.valueOf(r0)
                r6 = r0
                goto L77
            L76:
                r6 = r1
            L77:
                com.google.protobuf.Int32Value r0 = r14.getNumberOfParticipants()
                if (r0 == 0) goto L8b
                com.google.protobuf.Int32Value r0 = r14.getNumberOfParticipants()
                int r0 = r0.getValue()
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                r7 = r0
                goto L8c
            L8b:
                r7 = r1
            L8c:
                com.google.protobuf.Int32Value r0 = r14.getDiscountPercent()
                if (r0 == 0) goto L9e
                com.google.protobuf.Int32Value r0 = r14.getDiscountPercent()
                int r0 = r0.getValue()
                java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            L9e:
                r8 = r1
                ir.nasim.core.modules.market.model.MarketProductItem r0 = new ir.nasim.core.modules.market.model.MarketProductItem
                ir.nasim.core.modules.market.model.MarketPost$a r1 = ir.nasim.core.modules.market.model.MarketPost.INSTANCE
                ir.nasim.core.modules.market.model.MarketPost r4 = r1.a(r14)
                r11 = 192(0xc0, float:2.69E-43)
                r12 = 0
                r9 = 0
                r10 = 0
                r2 = r0
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.core.modules.market.model.MarketProductItem.Companion.a(ai.bale.proto.MarketStruct$Product):ir.nasim.core.modules.market.model.MarketProductItem");
        }

        public final ArrayList b(List list) {
            AbstractC13042fc3.i(list, "response");
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(MarketProductItem.INSTANCE.a((MarketStruct$Product) it.next()));
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
        public final MarketProductItem createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new MarketProductItem(parcel.readString(), MarketPost.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MarketProductItem[] newArray(int i) {
            return new MarketProductItem[i];
        }
    }

    public MarketProductItem(String str, MarketPost marketPost, String str2, Float f, Integer num, Integer num2, int i, int i2) {
        AbstractC13042fc3.i(marketPost, "post");
        this.title = str;
        this.post = marketPost;
        this.price = str2;
        this.rate = f;
        this.rateCount = num;
        this.discount = num2;
        this.minAppVersion = i;
        this.maxAppVersion = i2;
    }

    public final boolean canUseForThisVersionApp() {
        int i = this.minAppVersion;
        boolean z = i == 0 || (i != 0 && i <= C5721Ko.a.h());
        int i2 = this.maxAppVersion;
        return z && (i2 == 0 || (i2 != 0 && i2 >= C5721Ko.a.h()));
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final MarketPost getPost() {
        return this.post;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    /* renamed from: component4, reason: from getter */
    public final Float getRate() {
        return this.rate;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getRateCount() {
        return this.rateCount;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getDiscount() {
        return this.discount;
    }

    /* renamed from: component7, reason: from getter */
    public final int getMinAppVersion() {
        return this.minAppVersion;
    }

    /* renamed from: component8, reason: from getter */
    public final int getMaxAppVersion() {
        return this.maxAppVersion;
    }

    public final MarketProductItem copy(String title, MarketPost post, String price, Float rate, Integer rateCount, Integer discount, int minAppVersion, int maxAppVersion) {
        AbstractC13042fc3.i(post, "post");
        return new MarketProductItem(title, post, price, rate, rateCount, discount, minAppVersion, maxAppVersion);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketProductItem)) {
            return false;
        }
        MarketProductItem marketProductItem = (MarketProductItem) other;
        return AbstractC13042fc3.d(this.title, marketProductItem.title) && AbstractC13042fc3.d(this.post, marketProductItem.post) && AbstractC13042fc3.d(this.price, marketProductItem.price) && AbstractC13042fc3.d(this.rate, marketProductItem.rate) && AbstractC13042fc3.d(this.rateCount, marketProductItem.rateCount) && AbstractC13042fc3.d(this.discount, marketProductItem.discount) && this.minAppVersion == marketProductItem.minAppVersion && this.maxAppVersion == marketProductItem.maxAppVersion;
    }

    public final Integer getDiscount() {
        return this.discount;
    }

    public final int getMaxAppVersion() {
        return this.maxAppVersion;
    }

    public final int getMinAppVersion() {
        return this.minAppVersion;
    }

    public final MarketPost getPost() {
        return this.post;
    }

    public final String getPrice() {
        return this.price;
    }

    public final Float getRate() {
        return this.rate;
    }

    public final Integer getRateCount() {
        return this.rateCount;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return "https://" + AbstractC5969Lp4.e().S().n1() + "/post/" + this.post.getGroupId() + Separators.SLASH + this.post.getRId() + Separators.SLASH + this.post.getSortDate();
    }

    public final String getUrlPathOnly() {
        return this.post.getGroupId() + Separators.SLASH + this.post.getRId() + Separators.SLASH + this.post.getSortDate();
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.post.hashCode()) * 31;
        String str2 = this.price;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f = this.rate;
        int iHashCode3 = (iHashCode2 + (f == null ? 0 : f.hashCode())) * 31;
        Integer num = this.rateCount;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.discount;
        return ((((iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31) + Integer.hashCode(this.minAppVersion)) * 31) + Integer.hashCode(this.maxAppVersion);
    }

    public final void setMaxAppVersion(int i) {
        this.maxAppVersion = i;
    }

    public final void setMinAppVersion(int i) {
        this.minAppVersion = i;
    }

    public String toString() {
        return "MarketProductItem(title=" + this.title + ", post=" + this.post + ", price=" + this.price + ", rate=" + this.rate + ", rateCount=" + this.rateCount + ", discount=" + this.discount + ", minAppVersion=" + this.minAppVersion + ", maxAppVersion=" + this.maxAppVersion + Separators.RPAREN;
    }

    public final void validate() {
        this.post.validate();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeString(this.title);
        this.post.writeToParcel(dest, flags);
        dest.writeString(this.price);
        Float f = this.rate;
        if (f == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeFloat(f.floatValue());
        }
        Integer num = this.rateCount;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
        Integer num2 = this.discount;
        if (num2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num2.intValue());
        }
        dest.writeInt(this.minAppVersion);
        dest.writeInt(this.maxAppVersion);
    }

    public /* synthetic */ MarketProductItem(String str, MarketPost marketPost, String str2, Float f, Integer num, Integer num2, int i, int i2, int i3, ED1 ed1) {
        this(str, marketPost, str2, f, num, num2, (i3 & 64) != 0 ? C5721Ko.a.h() : i, (i3 & 128) != 0 ? C5721Ko.a.h() : i2);
    }
}
