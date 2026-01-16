package ir.nasim.data.model.story;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0016J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b!\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b%\u0010$\u001a\u0004\b)\u0010\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b'\u0010*\u001a\u0004\b+\u0010\u0018R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b#\u0010\u0018R\u0019\u0010\f\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b+\u0010*\u001a\u0004\b\u001f\u0010\u0018¨\u0006,"}, d2 = {"Lir/nasim/data/model/story/PostToStoryData;", "Landroid/os/Parcelable;", "Lir/nasim/data/model/story/PostToStoryOrigin;", "origin", "", "peerId", "", "postId", "postOwnerExPeerTypeValue", "", "postWidgetUrl", "linkWidgetUrl", "linkWidgetTitle", "<init>", "(Lir/nasim/data/model/story/PostToStoryOrigin;IJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lir/nasim/data/model/story/PostToStoryOrigin;", "c", "()Lir/nasim/data/model/story/PostToStoryOrigin;", "b", TokenNames.I, "d", "J", "e", "()J", "f", "Ljava/lang/String;", "g", "data_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class PostToStoryData implements Parcelable {
    public static final Parcelable.Creator<PostToStoryData> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final PostToStoryOrigin origin;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private final int peerId;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    private final long postId;

    /* renamed from: d, reason: from kotlin metadata and from toString */
    private final int postOwnerExPeerTypeValue;

    /* renamed from: e, reason: from kotlin metadata and from toString */
    private final String postWidgetUrl;

    /* renamed from: f, reason: from kotlin metadata and from toString */
    private final String linkWidgetUrl;

    /* renamed from: g, reason: from kotlin metadata and from toString */
    private final String linkWidgetTitle;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PostToStoryData createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new PostToStoryData(PostToStoryOrigin.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PostToStoryData[] newArray(int i) {
            return new PostToStoryData[i];
        }
    }

    public PostToStoryData(PostToStoryOrigin postToStoryOrigin, int i, long j, int i2, String str, String str2, String str3) {
        AbstractC13042fc3.i(postToStoryOrigin, "origin");
        this.origin = postToStoryOrigin;
        this.peerId = i;
        this.postId = j;
        this.postOwnerExPeerTypeValue = i2;
        this.postWidgetUrl = str;
        this.linkWidgetUrl = str2;
        this.linkWidgetTitle = str3;
    }

    /* renamed from: a, reason: from getter */
    public final String getLinkWidgetTitle() {
        return this.linkWidgetTitle;
    }

    /* renamed from: b, reason: from getter */
    public final String getLinkWidgetUrl() {
        return this.linkWidgetUrl;
    }

    /* renamed from: c, reason: from getter */
    public final PostToStoryOrigin getOrigin() {
        return this.origin;
    }

    /* renamed from: d, reason: from getter */
    public final int getPeerId() {
        return this.peerId;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final long getPostId() {
        return this.postId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostToStoryData)) {
            return false;
        }
        PostToStoryData postToStoryData = (PostToStoryData) other;
        return this.origin == postToStoryData.origin && this.peerId == postToStoryData.peerId && this.postId == postToStoryData.postId && this.postOwnerExPeerTypeValue == postToStoryData.postOwnerExPeerTypeValue && AbstractC13042fc3.d(this.postWidgetUrl, postToStoryData.postWidgetUrl) && AbstractC13042fc3.d(this.linkWidgetUrl, postToStoryData.linkWidgetUrl) && AbstractC13042fc3.d(this.linkWidgetTitle, postToStoryData.linkWidgetTitle);
    }

    /* renamed from: f, reason: from getter */
    public final int getPostOwnerExPeerTypeValue() {
        return this.postOwnerExPeerTypeValue;
    }

    /* renamed from: g, reason: from getter */
    public final String getPostWidgetUrl() {
        return this.postWidgetUrl;
    }

    public int hashCode() {
        int iHashCode = ((((((this.origin.hashCode() * 31) + Integer.hashCode(this.peerId)) * 31) + Long.hashCode(this.postId)) * 31) + Integer.hashCode(this.postOwnerExPeerTypeValue)) * 31;
        String str = this.postWidgetUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.linkWidgetUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.linkWidgetTitle;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "PostToStoryData(origin=" + this.origin + ", peerId=" + this.peerId + ", postId=" + this.postId + ", postOwnerExPeerTypeValue=" + this.postOwnerExPeerTypeValue + ", postWidgetUrl=" + this.postWidgetUrl + ", linkWidgetUrl=" + this.linkWidgetUrl + ", linkWidgetTitle=" + this.linkWidgetTitle + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        this.origin.writeToParcel(dest, flags);
        dest.writeInt(this.peerId);
        dest.writeLong(this.postId);
        dest.writeInt(this.postOwnerExPeerTypeValue);
        dest.writeString(this.postWidgetUrl);
        dest.writeString(this.linkWidgetUrl);
        dest.writeString(this.linkWidgetTitle);
    }
}
