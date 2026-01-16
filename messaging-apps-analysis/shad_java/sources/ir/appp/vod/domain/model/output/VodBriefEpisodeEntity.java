package ir.appp.vod.domain.model.output;

import com.facebook.stetho.websocket.CloseCodes;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetEpisodesOutput.kt */
/* loaded from: classes3.dex */
public final class VodBriefEpisodeEntity {

    @SerializedName("episode_id")
    private final String episodeId;

    @SerializedName("image_url")
    private final String imageUrl;

    @SerializedName("last_position")
    private Long lastPosition;

    @SerializedName("media_duration")
    private final Long mediaDurationSecond;

    @SerializedName("season_title")
    private final String seasonTitle;

    @SerializedName("short_description")
    private final String shortDescription;

    @SerializedName("title")
    private final String title;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VodBriefEpisodeEntity)) {
            return false;
        }
        VodBriefEpisodeEntity vodBriefEpisodeEntity = (VodBriefEpisodeEntity) obj;
        return Intrinsics.areEqual(this.episodeId, vodBriefEpisodeEntity.episodeId) && Intrinsics.areEqual(this.title, vodBriefEpisodeEntity.title) && Intrinsics.areEqual(this.seasonTitle, vodBriefEpisodeEntity.seasonTitle) && Intrinsics.areEqual(this.imageUrl, vodBriefEpisodeEntity.imageUrl) && Intrinsics.areEqual(this.shortDescription, vodBriefEpisodeEntity.shortDescription) && Intrinsics.areEqual(this.mediaDurationSecond, vodBriefEpisodeEntity.mediaDurationSecond) && Intrinsics.areEqual(this.lastPosition, vodBriefEpisodeEntity.lastPosition);
    }

    public int hashCode() {
        int iHashCode = this.episodeId.hashCode() * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.seasonTitle;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imageUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.shortDescription;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l = this.mediaDurationSecond;
        int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.lastPosition;
        return iHashCode6 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        return "VodBriefEpisodeEntity(episodeId=" + this.episodeId + ", title=" + this.title + ", seasonTitle=" + this.seasonTitle + ", imageUrl=" + this.imageUrl + ", shortDescription=" + this.shortDescription + ", mediaDurationSecond=" + this.mediaDurationSecond + ", lastPosition=" + this.lastPosition + ")";
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getShortDescription() {
        return this.shortDescription;
    }

    public final Long getLastPosition() {
        return this.lastPosition;
    }

    public final Long getMediaDuration() {
        Long l = this.mediaDurationSecond;
        if (l == null) {
            return null;
        }
        return Long.valueOf(l.longValue() * CloseCodes.NORMAL_CLOSURE);
    }
}
