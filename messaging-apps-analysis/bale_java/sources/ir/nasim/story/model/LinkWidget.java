package ir.nasim.story.model;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.InterfaceC23984xq6;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tH×\u0001¢\u0006\u0004\b\u0012\u0010\u000fJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H×\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011¨\u0006\u001b"}, d2 = {"Lir/nasim/story/model/LinkWidget;", "Landroid/os/Parcelable;", "", "link", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final /* data */ class LinkWidget implements Parcelable {
    public static final Parcelable.Creator<LinkWidget> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("link")
    private final String link;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    @InterfaceC23984xq6("title")
    private final String title;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LinkWidget createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new LinkWidget(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final LinkWidget[] newArray(int i) {
            return new LinkWidget[i];
        }
    }

    public LinkWidget(String str, String str2) {
        AbstractC13042fc3.i(str, "link");
        AbstractC13042fc3.i(str2, "title");
        this.link = str;
        this.title = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: b, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkWidget)) {
            return false;
        }
        LinkWidget linkWidget = (LinkWidget) other;
        return AbstractC13042fc3.d(this.link, linkWidget.link) && AbstractC13042fc3.d(this.title, linkWidget.title);
    }

    public int hashCode() {
        return (this.link.hashCode() * 31) + this.title.hashCode();
    }

    public String toString() {
        return "LinkWidget(link=" + this.link + ", title=" + this.title + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeString(this.link);
        dest.writeString(this.title);
    }
}
