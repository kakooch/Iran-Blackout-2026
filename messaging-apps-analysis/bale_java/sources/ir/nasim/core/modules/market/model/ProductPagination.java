package ir.nasim.core.modules.market.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19406qI3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.KS2;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000fJ$\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÇ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015H×\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0018\u0010\u000fJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H×\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u000f¨\u0006$"}, d2 = {"Lir/nasim/core/modules/market/model/ProductPagination;", "Landroid/os/Parcelable;", "", "date", "", "page", "<init>", "(JI)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()J", "component2", "copy", "(JI)Lir/nasim/core/modules/market/model/ProductPagination;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getDate", TokenNames.I, "getPage", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class ProductPagination implements Parcelable {
    public static final int $stable = 0;

    @InterfaceC23984xq6("date")
    private final long date;

    @InterfaceC23984xq6("page")
    private final int page;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<ProductPagination> CREATOR = new b();

    /* renamed from: ir.nasim.core.modules.market.model.ProductPagination$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final ProductPagination a(String str) {
            AbstractC13042fc3.i(str, "json");
            try {
                return (ProductPagination) new KS2().k(str, ProductPagination.class);
            } catch (Exception e) {
                C19406qI3.b("ProductPagination", "Error: " + e.getMessage());
                return null;
            }
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ProductPagination createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new ProductPagination(parcel.readLong(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ProductPagination[] newArray(int i) {
            return new ProductPagination[i];
        }
    }

    public ProductPagination(long j, int i) {
        this.date = j;
        this.page = i;
    }

    public static /* synthetic */ ProductPagination copy$default(ProductPagination productPagination, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = productPagination.date;
        }
        if ((i2 & 2) != 0) {
            i = productPagination.page;
        }
        return productPagination.copy(j, i);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    public final ProductPagination copy(long date, int page) {
        return new ProductPagination(date, page);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductPagination)) {
            return false;
        }
        ProductPagination productPagination = (ProductPagination) other;
        return this.date == productPagination.date && this.page == productPagination.page;
    }

    public final long getDate() {
        return this.date;
    }

    public final int getPage() {
        return this.page;
    }

    public int hashCode() {
        return (Long.hashCode(this.date) * 31) + Integer.hashCode(this.page);
    }

    public String toString() {
        return "ProductPagination(date=" + this.date + ", page=" + this.page + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeLong(this.date);
        dest.writeInt(this.page);
    }
}
