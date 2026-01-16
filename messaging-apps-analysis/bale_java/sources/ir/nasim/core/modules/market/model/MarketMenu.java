package ir.nasim.core.modules.market.model;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepName;
import com.google.gson.JsonParseException;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19406qI3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23984xq6;
import ir.nasim.KS2;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0001)B'\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J4\u0010\u0019\u001a\u00020\u00002\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÇ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u001b\u0010\u0018J\u0010\u0010\u001c\u001a\u00020\u000fH×\u0001¢\u0006\u0004\b\u001c\u0010\u0014J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH×\u0003¢\u0006\u0004\b \u0010!R2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010%R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010\u0018¨\u0006*"}, d2 = {"Lir/nasim/core/modules/market/model/MarketMenu;", "Landroid/os/Parcelable;", "Ljava/util/ArrayList;", "Lir/nasim/core/modules/market/model/MarketMenuItem;", "Lkotlin/collections/ArrayList;", "items", "", "title", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;)V", "Lir/nasim/rB7;", "validate", "()V", "Landroid/os/Parcel;", "dest", "", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/ArrayList;", "component2", "()Ljava/lang/String;", "copy", "(Ljava/util/ArrayList;Ljava/lang/String;)Lir/nasim/core/modules/market/model/MarketMenu;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/ArrayList;", "getItems", "setItems", "(Ljava/util/ArrayList;)V", "Ljava/lang/String;", "getTitle", "Companion", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes5.dex */
public final /* data */ class MarketMenu implements Parcelable {

    @InterfaceC23984xq6("items")
    private ArrayList<MarketMenuItem> items;

    @InterfaceC23984xq6("title")
    private final String title;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    public static final Parcelable.Creator<MarketMenu> CREATOR = new b();

    /* renamed from: ir.nasim.core.modules.market.model.MarketMenu$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final MarketMenu a(String str) {
            AbstractC13042fc3.i(str, "json");
            try {
                MarketMenu marketMenu = (MarketMenu) new KS2().k(str, MarketMenu.class);
                Iterator<T> it = marketMenu.getItems().iterator();
                while (it.hasNext()) {
                    ((MarketMenuItem) it.next()).validate();
                }
                return marketMenu;
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
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
        public final MarketMenu createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(MarketMenuItem.CREATOR.createFromParcel(parcel));
            }
            return new MarketMenu(arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MarketMenu[] newArray(int i) {
            return new MarketMenu[i];
        }
    }

    public MarketMenu(ArrayList<MarketMenuItem> arrayList, String str) {
        AbstractC13042fc3.i(arrayList, "items");
        AbstractC13042fc3.i(str, "title");
        this.items = arrayList;
        this.title = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarketMenu copy$default(MarketMenu marketMenu, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = marketMenu.items;
        }
        if ((i & 2) != 0) {
            str = marketMenu.title;
        }
        return marketMenu.copy(arrayList, str);
    }

    public final ArrayList<MarketMenuItem> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final MarketMenu copy(ArrayList<MarketMenuItem> items, String title) {
        AbstractC13042fc3.i(items, "items");
        AbstractC13042fc3.i(title, "title");
        return new MarketMenu(items, title);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarketMenu)) {
            return false;
        }
        MarketMenu marketMenu = (MarketMenu) other;
        return AbstractC13042fc3.d(this.items, marketMenu.items) && AbstractC13042fc3.d(this.title, marketMenu.title);
    }

    public final ArrayList<MarketMenuItem> getItems() {
        return this.items;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + this.title.hashCode();
    }

    public final void setItems(ArrayList<MarketMenuItem> arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.items = arrayList;
    }

    public String toString() {
        return "MarketMenu(items=" + this.items + ", title=" + this.title + Separators.RPAREN;
    }

    public final void validate() {
        Iterator<T> it = this.items.iterator();
        while (it.hasNext()) {
            ((MarketMenuItem) it.next()).validate();
        }
        if (this.title == null) {
            throw new JsonParseException("'title' is null!");
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        ArrayList<MarketMenuItem> arrayList = this.items;
        dest.writeInt(arrayList.size());
        Iterator<MarketMenuItem> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        dest.writeString(this.title);
    }
}
