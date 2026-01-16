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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0014J\u0010\u0010\u001a\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0014JH\u0010\u001b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÇ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u001d\u0010\u0018J\u0010\u0010\u001e\u001a\u00020\bH×\u0001¢\u0006\u0004\b\u001e\u0010\u0014J\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fH×\u0003¢\u0006\u0004\b\"\u0010#R2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010'R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010\u0018R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b+\u0010\u0014R\"\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010*\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lir/nasim/jaryan/discover/model/PeerSection;", "Landroid/os/Parcelable;", "Ljava/util/ArrayList;", "Lir/nasim/jaryan/discover/model/PeerItem;", "Lkotlin/collections/ArrayList;", "items", "", "title", "", "itemsCount", "id", "<init>", "(Ljava/util/ArrayList;Ljava/lang/String;II)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/util/ArrayList;", "component2", "()Ljava/lang/String;", "component3", "component4", "copy", "(Ljava/util/ArrayList;Ljava/lang/String;II)Lir/nasim/jaryan/discover/model/PeerSection;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/ArrayList;", "getItems", "setItems", "(Ljava/util/ArrayList;)V", "Ljava/lang/String;", "getTitle", TokenNames.I, "getItemsCount", "getId", "setId", "(I)V", "jaryan_release"}, k = 1, mv = {2, 0, 0})
@KeepName
/* loaded from: classes6.dex */
public final /* data */ class PeerSection implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PeerSection> CREATOR = new a();

    @InterfaceC23984xq6("id")
    private int id;

    @InterfaceC23984xq6("items")
    private ArrayList<PeerItem> items;

    @InterfaceC23984xq6("itemsCount")
    private final int itemsCount;

    @InterfaceC23984xq6("title")
    private final String title;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PeerSection createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(PeerItem.CREATOR.createFromParcel(parcel));
            }
            return new PeerSection(arrayList, parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PeerSection[] newArray(int i) {
            return new PeerSection[i];
        }
    }

    public PeerSection(ArrayList<PeerItem> arrayList, String str, int i, int i2) {
        AbstractC13042fc3.i(arrayList, "items");
        AbstractC13042fc3.i(str, "title");
        this.items = arrayList;
        this.title = str;
        this.itemsCount = i;
        this.id = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PeerSection copy$default(PeerSection peerSection, ArrayList arrayList, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = peerSection.items;
        }
        if ((i3 & 2) != 0) {
            str = peerSection.title;
        }
        if ((i3 & 4) != 0) {
            i = peerSection.itemsCount;
        }
        if ((i3 & 8) != 0) {
            i2 = peerSection.id;
        }
        return peerSection.copy(arrayList, str, i, i2);
    }

    public final ArrayList<PeerItem> component1() {
        return this.items;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final int getItemsCount() {
        return this.itemsCount;
    }

    /* renamed from: component4, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final PeerSection copy(ArrayList<PeerItem> items, String title, int itemsCount, int id) {
        AbstractC13042fc3.i(items, "items");
        AbstractC13042fc3.i(title, "title");
        return new PeerSection(items, title, itemsCount, id);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PeerSection)) {
            return false;
        }
        PeerSection peerSection = (PeerSection) other;
        return AbstractC13042fc3.d(this.items, peerSection.items) && AbstractC13042fc3.d(this.title, peerSection.title) && this.itemsCount == peerSection.itemsCount && this.id == peerSection.id;
    }

    public final int getId() {
        return this.id;
    }

    public final ArrayList<PeerItem> getItems() {
        return this.items;
    }

    public final int getItemsCount() {
        return this.itemsCount;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.items.hashCode() * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.itemsCount)) * 31) + Integer.hashCode(this.id);
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setItems(ArrayList<PeerItem> arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.items = arrayList;
    }

    public String toString() {
        return "PeerSection(items=" + this.items + ", title=" + this.title + ", itemsCount=" + this.itemsCount + ", id=" + this.id + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        ArrayList<PeerItem> arrayList = this.items;
        dest.writeInt(arrayList.size());
        Iterator<PeerItem> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        dest.writeString(this.title);
        dest.writeInt(this.itemsCount);
        dest.writeInt(this.id);
    }
}
