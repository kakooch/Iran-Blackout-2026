package ir.appp.vod.domain.model;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VodSeasonReadEntity.kt */
/* loaded from: classes3.dex */
public final class VodSeasonReadEntity {

    @SerializedName("season_id")
    private final String seasonId;

    @SerializedName("season_name")
    private final String seasonName;

    @SerializedName("season_order")
    private final int seasonOrder;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VodSeasonReadEntity)) {
            return false;
        }
        VodSeasonReadEntity vodSeasonReadEntity = (VodSeasonReadEntity) obj;
        return Intrinsics.areEqual(this.seasonId, vodSeasonReadEntity.seasonId) && Intrinsics.areEqual(this.seasonName, vodSeasonReadEntity.seasonName) && this.seasonOrder == vodSeasonReadEntity.seasonOrder;
    }

    public int hashCode() {
        return (((this.seasonId.hashCode() * 31) + this.seasonName.hashCode()) * 31) + this.seasonOrder;
    }

    public String toString() {
        return "VodSeasonReadEntity(seasonId=" + this.seasonId + ", seasonName=" + this.seasonName + ", seasonOrder=" + this.seasonOrder + ")";
    }

    public final String getSeasonId() {
        return this.seasonId;
    }

    public final String getSeasonName() {
        return this.seasonName;
    }
}
