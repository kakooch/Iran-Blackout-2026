package ir.appp.vod.domain.model.output;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: GetEpisodesOutput.kt */
/* loaded from: classes3.dex */
public final class GetEpisodesOutput {

    @SerializedName("episodes")
    private final List<VodBriefEpisodeEntity> episodes;

    public final List<VodBriefEpisodeEntity> getEpisodes() {
        return this.episodes;
    }
}
