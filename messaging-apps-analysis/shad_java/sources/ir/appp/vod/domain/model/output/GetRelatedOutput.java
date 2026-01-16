package ir.appp.vod.domain.model.output;

import com.google.gson.annotations.SerializedName;
import ir.appp.vod.domain.model.VodBriefMediaEntity;
import java.util.List;

/* compiled from: GetRelatedOutput.kt */
/* loaded from: classes3.dex */
public final class GetRelatedOutput {

    @SerializedName("related_medias")
    private final List<VodBriefMediaEntity> relatedMedia;

    public final List<VodBriefMediaEntity> getRelatedMedia() {
        return this.relatedMedia;
    }
}
