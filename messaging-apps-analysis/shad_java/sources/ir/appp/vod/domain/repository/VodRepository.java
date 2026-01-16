package ir.appp.vod.domain.repository;

import ir.appp.common.domain.model.BaseResponse;
import ir.appp.vod.domain.model.output.GetCastRelatedOutput;
import ir.appp.vod.domain.model.output.GetEpisodesOutput;
import ir.appp.vod.domain.model.output.GetRelatedOutput;
import ir.appp.vod.domain.model.output.VodMediaEntity;
import ir.appp.vod.domain.model.output.VodMediaEntityOutput;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* compiled from: VodRepository.kt */
/* loaded from: classes3.dex */
public interface VodRepository {
    Object actionOnMedia(String str, VodMediaEntity.LikeStatus likeStatus, Continuation<? super Flow<? extends BaseResponse<? extends Object>>> continuation);

    Object getCastMedias(String str, String str2, Continuation<? super Flow<? extends BaseResponse<GetCastRelatedOutput>>> continuation);

    Object getEpisodes(String str, String str2, Continuation<? super Flow<? extends BaseResponse<GetEpisodesOutput>>> continuation);

    Object getMedia(String str, Continuation<? super Flow<? extends BaseResponse<VodMediaEntityOutput>>> continuation);

    Object getRelated(String str, String str2, Continuation<? super Flow<? extends BaseResponse<GetRelatedOutput>>> continuation);
}
