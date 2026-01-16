package ir.nasim.data.model.story;

import android.gov.nist.core.Separators;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0010J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u0012R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lir/nasim/data/model/story/CachedVideos;", "Landroid/os/Parcelable;", "", "cacheKey", "", "expireTimestamp", "<init>", "(Ljava/lang/String;J)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "J", "()J", "c", "(J)V", "data_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class CachedVideos implements Parcelable {
    public static final Parcelable.Creator<CachedVideos> CREATOR = new a();

    /* renamed from: a, reason: from kotlin metadata and from toString */
    private final String cacheKey;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    private long expireTimestamp;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CachedVideos createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new CachedVideos(parcel.readString(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CachedVideos[] newArray(int i) {
            return new CachedVideos[i];
        }
    }

    public CachedVideos(String str, long j) {
        AbstractC13042fc3.i(str, "cacheKey");
        this.cacheKey = str;
        this.expireTimestamp = j;
    }

    /* renamed from: a, reason: from getter */
    public final String getCacheKey() {
        return this.cacheKey;
    }

    /* renamed from: b, reason: from getter */
    public final long getExpireTimestamp() {
        return this.expireTimestamp;
    }

    public final void c(long j) {
        this.expireTimestamp = j;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CachedVideos)) {
            return false;
        }
        CachedVideos cachedVideos = (CachedVideos) other;
        return AbstractC13042fc3.d(this.cacheKey, cachedVideos.cacheKey) && this.expireTimestamp == cachedVideos.expireTimestamp;
    }

    public int hashCode() {
        return (this.cacheKey.hashCode() * 31) + Long.hashCode(this.expireTimestamp);
    }

    public String toString() {
        return "CachedVideos(cacheKey=" + this.cacheKey + ", expireTimestamp=" + this.expireTimestamp + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        dest.writeString(this.cacheKey);
        dest.writeLong(this.expireTimestamp);
    }
}
