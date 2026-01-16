package ir.appp.vod.data.source;

import ir.appp.vod.domain.model.output.GetCastRelatedOutput;
import ir.appp.vod.domain.model.output.GetEpisodesOutput;
import ir.appp.vod.domain.model.output.GetRelatedOutput;
import ir.appp.vod.domain.model.output.VodMediaEntity;
import ir.appp.vod.domain.model.output.VodMediaEntityOutput;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: VodDataSource.kt */
/* loaded from: classes3.dex */
public interface VodDataSource {
    Object actionOnMedia(String str, VodMediaEntity.LikeStatus likeStatus, Continuation<? super Flow<? extends Object>> continuation);

    Object getCastMedias(String str, String str2, Continuation<? super Flow<GetCastRelatedOutput>> continuation);

    Object getEpisodes(String str, String str2, Continuation<? super Flow<GetEpisodesOutput>> continuation);

    Object getMedia(String str, Continuation<? super Flow<VodMediaEntityOutput>> continuation);

    Object getRelated(String str, String str2, Continuation<? super Flow<GetRelatedOutput>> continuation);
}
