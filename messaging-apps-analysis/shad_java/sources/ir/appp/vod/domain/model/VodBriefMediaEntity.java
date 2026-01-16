package ir.appp.vod.domain.model;

import com.google.gson.annotations.SerializedName;
import ir.appp.vod.domain.model.output.VodMediaEntity;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VodBriefEpisodeEntity.kt */
/* loaded from: classes3.dex */
public final class VodBriefMediaEntity {

    @SerializedName("caption")
    private final String caption;

    @SerializedName("image_url")
    private final String imageUrl;

    @SerializedName("media_id")
    private final String mediaId;

    @SerializedName("media_type")
    private final VodMediaEntity.MediaType mediaType;

    @SerializedName("seasons")
    private final Long seasons;

    @SerializedName("short_description")
    private final String shortDescription;

    @SerializedName("title")
    private final String title;

    @SerializedName("year")
    private final Long year;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VodBriefMediaEntity)) {
            return false;
        }
        VodBriefMediaEntity vodBriefMediaEntity = (VodBriefMediaEntity) obj;
        return Intrinsics.areEqual(this.mediaId, vodBriefMediaEntity.mediaId) && this.mediaType == vodBriefMediaEntity.mediaType && Intrinsics.areEqual(this.title, vodBriefMediaEntity.title) && Intrinsics.areEqual(this.shortDescription, vodBriefMediaEntity.shortDescription) && Intrinsics.areEqual(this.year, vodBriefMediaEntity.year) && Intrinsics.areEqual(this.seasons, vodBriefMediaEntity.seasons) && Intrinsics.areEqual(this.caption, vodBriefMediaEntity.caption) && Intrinsics.areEqual(this.imageUrl, vodBriefMediaEntity.imageUrl);
    }

    public int hashCode() {
        int iHashCode = this.mediaId.hashCode() * 31;
        VodMediaEntity.MediaType mediaType = this.mediaType;
        int iHashCode2 = (iHashCode + (mediaType == null ? 0 : mediaType.hashCode())) * 31;
        String str = this.title;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.shortDescription;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.year;
        int iHashCode5 = (iHashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.seasons;
        int iHashCode6 = (iHashCode5 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str3 = this.caption;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.imageUrl;
        return iHashCode7 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "VodBriefMediaEntity(mediaId=" + this.mediaId + ", mediaType=" + this.mediaType + ", title=" + this.title + ", shortDescription=" + this.shortDescription + ", year=" + this.year + ", seasons=" + this.seasons + ", caption=" + this.caption + ", imageUrl=" + this.imageUrl + ")";
    }

    public final String getMediaId() {
        return this.mediaId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getShortDescription() {
        return this.shortDescription;
    }

    public final Long getYear() {
        return this.year;
    }

    public final Long getSeasons() {
        return this.seasons;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }
}
