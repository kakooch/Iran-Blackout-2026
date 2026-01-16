package ir.nasim.core.modules.market.model;

import ai.bale.proto.MarketStruct$MarketItem;
import ai.bale.proto.MarketStruct$Product;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import com.google.gson.JsonParseException;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C5721Ko;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.core.modules.market.model.MarketPost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0001AB[\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\"\u0010!J\u0010\u0010#\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b#\u0010\u001dJ\u0010\u0010$\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b$\u0010\u001dJ$\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fHÆ\u0003¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b'\u0010(Jl\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÇ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b+\u0010!J\u0010\u0010,\u001a\u00020\u0007H×\u0001¢\u0006\u0004\b,\u0010\u001dJ\u001a\u0010/\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010-H×\u0003¢\u0006\u0004\b/\u00100R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u00103\u001a\u0004\b4\u0010!R\u001a\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u00103\u001a\u0004\b5\u0010!R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u00106\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u00109R\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u00106\u001a\u0004\b:\u0010\u001d\"\u0004\b;\u00109R.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010<\u001a\u0004\b=\u0010&R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010>\u001a\u0004\b?\u0010(¨\u0006B"}, d2 = {"Lir/nasim/core/modules/market/model/MarketItem;", "Landroid/os/Parcelable;", "", "id", "", "title", "url", "", "minAppVersion", "maxAppVersion", "Ljava/util/ArrayList;", "Lir/nasim/core/modules/market/model/MarketPost;", "Lkotlin/collections/ArrayList;", "posts", "discount", "<init>", "(JLjava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;Ljava/lang/Integer;)V", "", "canUseForThisVersionApp", "()Z", "Lir/nasim/rB7;", "validate", "()V", "Landroid/os/Parcel;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()J", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "()Ljava/util/ArrayList;", "component7", "()Ljava/lang/Integer;", "copy", "(JLjava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;Ljava/lang/Integer;)Lir/nasim/core/modules/market/model/MarketItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getId", "Ljava/lang/String;", "getTitle", "getUrl", TokenNames.I, "getMinAppVersion", "setMinAppVersion", "(I)V", "getMaxAppVersion", "setMaxAppVersion", "Ljava/util/ArrayList;", "getPosts", "Ljava/lang/Integer;", "getDiscount", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class MarketItem implements Parcelable {

    @InterfaceC23984xq6("discount")
    private final Integer discount;

    @InterfaceC23984xq6("id")
    private final long id;

    @InterfaceC23984xq6("maxAppVersion")
    private int maxAppVersion;

    @InterfaceC23984xq6("minAppVersion")
    private int minAppVersion;

    @InterfaceC23984xq6("posts")
    private final ArrayList<MarketPost> posts;

    @InterfaceC23984xq6("title")
    private final String title;

    @InterfaceC23984xq6("url")
    private final String url;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    public static final Parcelable.Creator<MarketItem> CREATOR = new b();

    /* renamed from: ir.nasim.core.modules.market.model.MarketItem$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final MarketItem a(MarketStruct$MarketItem marketStruct$MarketItem) {
            AbstractC13042fc3.i(marketStruct$MarketItem, "response");
            long id = marketStruct$MarketItem.getId();
            String title = marketStruct$MarketItem.getTitle();
            AbstractC13042fc3.h(title, "getTitle(...)");
            String url = marketStruct$MarketItem.getUrl();
            AbstractC13042fc3.h(url, "getUrl(...)");
            MarketPost.Companion aVar = MarketPost.INSTANCE;
            List<MarketStruct$Product> productsList = marketStruct$MarketItem.getProductsList();
            AbstractC13042fc3.h(productsList, "getProductsList(...)");
            return new MarketItem(id, title, url, 0, 0, aVar.b(productsList), Integer.valueOf(marketStruct$MarketItem.getDiscount()), 24, null);
        }

        public final ArrayList b(List list) {
            AbstractC13042fc3.i(list, "response");
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(MarketItem.INSTANCE.a((MarketStruct$MarketItem) it.next()));
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
        public final MarketItem createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            AbstractC13042fc3.i(parcel, "parcel");
            long j = parcel.readLong();
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i3 = parcel.readInt();
                arrayList = new ArrayList(i3);
                for (int i4 = 0; i4 != i3; i4++) {
                    arrayList.add(MarketPost.CREATOR.createFromParcel(parcel));
                }
            }
            return new MarketItem(j, string, string2, i, i2, arrayList, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MarketItem[] newArray(int i) {
            return new MarketItem[i];
        }
    }

    public MarketItem(long j, String str, String str2, int i, int i2, ArrayList<MarketPost> arrayList, Integer num) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "url");
        this.id = j;
        this.title = str;
        this.url = str2;
        this.minAppVersion = i;
        this.maxAppVersion = i2;
        this.posts = arrayList;
        this.discount = num;
    }

    public final boolean canUseForThisVersionApp() {
        int i = this.minAppVersion;
        boolean z = i == 0 || (i != 0 && i <= C5721Ko.a.h());
        int i2 = this.maxAppVersion;
        return z && (i2 == 0 || (i2 != 0 && i2 >= C5721Ko.a.h()));
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMinAppVersion() {
        return this.minAppVersion;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMaxAppVersion() {
        return this.maxAppVersion;
    }

    public final ArrayList<MarketPost> component6() {
        return this.posts;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getDiscount() {
        return this.discount;
    }

    public final MarketItem copy(long id, String title, String url, int minAppVersion, int maxAppVersion, ArrayList<MarketPost> posts, Integer discount) {
        AbstractC13042fc3.i(title, "title");
        AbstractC13042fc3.i(url, "url");
        return new MarketItem(id, title, url, minAppVersion, maxAppVersion, posts, discount);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketItem)) {
            return false;
        }
        MarketItem marketItem = (MarketItem) other;
        return this.id == marketItem.id && AbstractC13042fc3.d(this.title, marketItem.title) && AbstractC13042fc3.d(this.url, marketItem.url) && this.minAppVersion == marketItem.minAppVersion && this.maxAppVersion == marketItem.maxAppVersion && AbstractC13042fc3.d(this.posts, marketItem.posts) && AbstractC13042fc3.d(this.discount, marketItem.discount);
    }

    public final Integer getDiscount() {
        return this.discount;
    }

    public final long getId() {
        return this.id;
    }

    public final int getMaxAppVersion() {
        return this.maxAppVersion;
    }

    public final int getMinAppVersion() {
        return this.minAppVersion;
    }

    public final ArrayList<MarketPost> getPosts() {
        return this.posts;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = ((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.url.hashCode()) * 31) + Integer.hashCode(this.minAppVersion)) * 31) + Integer.hashCode(this.maxAppVersion)) * 31;
        ArrayList<MarketPost> arrayList = this.posts;
        int iHashCode2 = (iHashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        Integer num = this.discount;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public final void setMaxAppVersion(int i) {
        this.maxAppVersion = i;
    }

    public final void setMinAppVersion(int i) {
        this.minAppVersion = i;
    }

    public String toString() {
        return "MarketItem(id=" + this.id + ", title=" + this.title + ", url=" + this.url + ", minAppVersion=" + this.minAppVersion + ", maxAppVersion=" + this.maxAppVersion + ", posts=" + this.posts + ", discount=" + this.discount + Separators.RPAREN;
    }

    public final void validate() {
        if (this.title == null) {
            throw new JsonParseException("'title' is null!");
        }
        if (this.url == null) {
            throw new JsonParseException("'url' is null!");
        }
        ArrayList<MarketPost> arrayList = this.posts;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((MarketPost) it.next()).validate();
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeLong(this.id);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeInt(this.minAppVersion);
        dest.writeInt(this.maxAppVersion);
        ArrayList<MarketPost> arrayList = this.posts;
        if (arrayList == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(arrayList.size());
            Iterator<MarketPost> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        Integer num = this.discount;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
    }

    public /* synthetic */ MarketItem(long j, String str, String str2, int i, int i2, ArrayList arrayList, Integer num, int i3, ED1 ed1) {
        this(j, str, str2, (i3 & 8) != 0 ? C5721Ko.a.h() : i, (i3 & 16) != 0 ? C5721Ko.a.h() : i2, (i3 & 32) != 0 ? null : arrayList, num);
    }
}
