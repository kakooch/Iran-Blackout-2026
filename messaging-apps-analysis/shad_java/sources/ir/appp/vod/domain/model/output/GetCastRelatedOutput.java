package ir.appp.vod.domain.model.output;

import com.google.gson.annotations.SerializedName;
import ir.appp.vod.domain.model.VodBriefMediaEntity;
import java.util.List;

/* compiled from: GetCastRelatedOutput.kt */
/* loaded from: classes3.dex */
public final class GetCastRelatedOutput {

    @SerializedName("has_continue")
    private final Boolean hasContinue;

    @SerializedName("next_start_id")
    private final String nextStartId;

    @SerializedName("medias")
    private final List<VodBriefMediaEntity> relatedMedia;

    public final List<VodBriefMediaEntity> getRelatedMedia() {
        return this.relatedMedia;
    }

    public final String getNextStartId() {
        return this.nextStartId;
    }

    public final Boolean getHasContinue() {
        return this.hasContinue;
    }
}
