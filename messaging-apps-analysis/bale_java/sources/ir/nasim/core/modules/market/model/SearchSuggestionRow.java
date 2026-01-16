package ir.nasim.core.modules.market.model;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J4\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007HÇ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u001c\u0010\u0015J\u0010\u0010\u001d\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u001d\u0010\u0013J\u001a\u0010 \u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH×\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0015R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010\u0017R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b'\u0010\u0019¨\u0006("}, d2 = {"Lir/nasim/core/modules/market/model/SearchSuggestionRow;", "Landroid/os/Parcelable;", "", "title", "", "Lir/nasim/core/modules/market/model/SearchSuggestion;", "items", "", "shouldShowDeleteAction", "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/List;", "component3", "()Z", "copy", "(Ljava/lang/String;Ljava/util/List;Z)Lir/nasim/core/modules/market/model/SearchSuggestionRow;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getItems", "Z", "getShouldShowDeleteAction", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class SearchSuggestionRow implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<SearchSuggestionRow> CREATOR = new a();
    private final List<SearchSuggestion> items;
    private final boolean shouldShowDeleteAction;
    private final String title;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SearchSuggestionRow createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(SearchSuggestion.CREATOR.createFromParcel(parcel));
            }
            return new SearchSuggestionRow(string, arrayList, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SearchSuggestionRow[] newArray(int i) {
            return new SearchSuggestionRow[i];
        }
    }

    public SearchSuggestionRow(String str, List<SearchSuggestion> list, boolean z) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(list, "items");
        this.title = str;
        this.items = list;
        this.shouldShowDeleteAction = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchSuggestionRow copy$default(SearchSuggestionRow searchSuggestionRow, String str, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchSuggestionRow.title;
        }
        if ((i & 2) != 0) {
            list = searchSuggestionRow.items;
        }
        if ((i & 4) != 0) {
            z = searchSuggestionRow.shouldShowDeleteAction;
        }
        return searchSuggestionRow.copy(str, list, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final List<SearchSuggestion> component2() {
        return this.items;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getShouldShowDeleteAction() {
        return this.shouldShowDeleteAction;
    }

    public final SearchSuggestionRow copy(String title, List<SearchSuggestion> items, boolean shouldShowDeleteAction) {
        AbstractC13042fc3.i(title, "title");
        AbstractC13042fc3.i(items, "items");
        return new SearchSuggestionRow(title, items, shouldShowDeleteAction);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchSuggestionRow)) {
            return false;
        }
        SearchSuggestionRow searchSuggestionRow = (SearchSuggestionRow) other;
        return AbstractC13042fc3.d(this.title, searchSuggestionRow.title) && AbstractC13042fc3.d(this.items, searchSuggestionRow.items) && this.shouldShowDeleteAction == searchSuggestionRow.shouldShowDeleteAction;
    }

    public final List<SearchSuggestion> getItems() {
        return this.items;
    }

    public final boolean getShouldShowDeleteAction() {
        return this.shouldShowDeleteAction;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.items.hashCode()) * 31) + Boolean.hashCode(this.shouldShowDeleteAction);
    }

    public String toString() {
        return "SearchSuggestionRow(title=" + this.title + ", items=" + this.items + ", shouldShowDeleteAction=" + this.shouldShowDeleteAction + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeString(this.title);
        List<SearchSuggestion> list = this.items;
        dest.writeInt(list.size());
        Iterator<SearchSuggestion> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        dest.writeInt(this.shouldShowDeleteAction ? 1 : 0);
    }

    public /* synthetic */ SearchSuggestionRow(String str, List list, boolean z, int i, ED1 ed1) {
        this(str, list, (i & 4) != 0 ? false : z);
    }
}
