package ir.nasim.jaryan.discover.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC23984xq6;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0011J4\u0010\u0015\u001a\u00020\u00002\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÇ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H×\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH×\u0003¢\u0006\u0004\b\u001e\u0010\u001fR2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010#R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lir/nasim/jaryan/discover/model/BannerSection;", "Landroid/os/Parcelable;", "Ljava/util/ArrayList;", "Lir/nasim/jaryan/discover/model/BannerItem;", "Lkotlin/collections/ArrayList;", "items", "", "id", "<init>", "(Ljava/util/ArrayList;I)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/ArrayList;", "component2", "copy", "(Ljava/util/ArrayList;I)Lir/nasim/jaryan/discover/model/BannerSection;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/ArrayList;", "getItems", "setItems", "(Ljava/util/ArrayList;)V", TokenNames.I, "getId", "setId", "(I)V", "jaryan_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes6.dex */
public final /* data */ class BannerSection implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<BannerSection> CREATOR = new a();

    @InterfaceC23984xq6("id")
    private int id;

    @InterfaceC23984xq6("items")
    private ArrayList<BannerItem> items;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BannerSection createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(BannerItem.CREATOR.createFromParcel(parcel));
            }
            return new BannerSection(arrayList, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final BannerSection[] newArray(int i) {
            return new BannerSection[i];
        }
    }

    public BannerSection(ArrayList<BannerItem> arrayList, int i) {
        AbstractC13042fc3.i(arrayList, "items");
        this.items = arrayList;
        this.id = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BannerSection copy$default(BannerSection bannerSection, ArrayList arrayList, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = bannerSection.items;
        }
        if ((i2 & 2) != 0) {
            i = bannerSection.id;
        }
        return bannerSection.copy(arrayList, i);
    }

    public final ArrayList<BannerItem> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final BannerSection copy(ArrayList<BannerItem> items, int id) {
        AbstractC13042fc3.i(items, "items");
        return new BannerSection(items, id);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BannerSection)) {
            return false;
        }
        BannerSection bannerSection = (BannerSection) other;
        return AbstractC13042fc3.d(this.items, bannerSection.items) && this.id == bannerSection.id;
    }

    public final int getId() {
        return this.id;
    }

    public final ArrayList<BannerItem> getItems() {
        return this.items;
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + Integer.hashCode(this.id);
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setItems(ArrayList<BannerItem> arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.items = arrayList;
    }

    public String toString() {
        return "BannerSection(items=" + this.items + ", id=" + this.id + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        ArrayList<BannerItem> arrayList = this.items;
        dest.writeInt(arrayList.size());
        Iterator<BannerItem> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        dest.writeInt(this.id);
    }
}
