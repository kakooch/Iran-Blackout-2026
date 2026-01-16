package ir.appp.vod.data.source.network;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import ir.appp.common.utils.extentions.FlowExtensionsKt;
import ir.appp.vod.data.source.VodDataSource;
import ir.appp.vod.domain.model.input.ActionOnMediaInput;
import ir.appp.vod.domain.model.input.GetCastRelatedInput;
import ir.appp.vod.domain.model.input.GetEpisodesInput;
import ir.appp.vod.domain.model.input.GetMediaInput;
import ir.appp.vod.domain.model.input.GetRelatedInput;
import ir.appp.vod.domain.model.output.GetCastRelatedOutput;
import ir.appp.vod.domain.model.output.GetEpisodesOutput;
import ir.appp.vod.domain.model.output.GetRelatedOutput;
import ir.appp.vod.domain.model.output.VodMediaEntity;
import ir.appp.vod.domain.model.output.VodMediaEntityOutput;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.model.MessangerOutput;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.rbmain.messenger.UserConfig;

/* compiled from: VodNetworkDataSource.kt */
/* loaded from: classes3.dex */
public final class VodNetworkDataSource implements VodDataSource {
    @Override // ir.appp.vod.data.source.VodDataSource
    public Object getMedia(String str, Continuation<? super Flow<VodMediaEntityOutput>> continuation) {
        Observable<R> map = ApiRequestMessangerRx.getInstance(UserConfig.selectedAccount).getMedia(new GetMediaInput(str)).map(new Function() { // from class: ir.appp.vod.data.source.network.VodNetworkDataSource$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return VodNetworkDataSource.m341getMedia$lambda0((MessangerOutput) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "getInstance(UserConfig.s…    it.data\n            }");
        return FlowExtensionsKt.toFlow(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getMedia$lambda-0, reason: not valid java name */
    public static final VodMediaEntityOutput m341getMedia$lambda0(MessangerOutput it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (VodMediaEntityOutput) it.data;
    }

    @Override // ir.appp.vod.data.source.VodDataSource
    public Object getEpisodes(String str, String str2, Continuation<? super Flow<GetEpisodesOutput>> continuation) {
        Observable<R> map = ApiRequestMessangerRx.getInstance(UserConfig.selectedAccount).getEpisodes(new GetEpisodesInput(str, str2)).map(new Function() { // from class: ir.appp.vod.data.source.network.VodNetworkDataSource$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return VodNetworkDataSource.m340getEpisodes$lambda2((MessangerOutput) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "getInstance(UserConfig.s…    it.data\n            }");
        return FlowExtensionsKt.toFlow(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getEpisodes$lambda-2, reason: not valid java name */
    public static final GetEpisodesOutput m340getEpisodes$lambda2(MessangerOutput it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (GetEpisodesOutput) it.data;
    }

    @Override // ir.appp.vod.data.source.VodDataSource
    public Object getRelated(String str, String str2, Continuation<? super Flow<GetRelatedOutput>> continuation) {
        Observable<R> map = ApiRequestMessangerRx.getInstance(UserConfig.selectedAccount).getRelated(new GetRelatedInput(str, str2)).map(new Function() { // from class: ir.appp.vod.data.source.network.VodNetworkDataSource$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return VodNetworkDataSource.m342getRelated$lambda3((MessangerOutput) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "getInstance(UserConfig.s…    it.data\n            }");
        return FlowExtensionsKt.toFlow(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getRelated$lambda-3, reason: not valid java name */
    public static final GetRelatedOutput m342getRelated$lambda3(MessangerOutput it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (GetRelatedOutput) it.data;
    }

    @Override // ir.appp.vod.data.source.VodDataSource
    public Object getCastMedias(String str, String str2, Continuation<? super Flow<GetCastRelatedOutput>> continuation) {
        Observable<R> map = ApiRequestMessangerRx.getInstance(UserConfig.selectedAccount).getCastMedias(new GetCastRelatedInput(str, str2)).map(new Function() { // from class: ir.appp.vod.data.source.network.VodNetworkDataSource$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return VodNetworkDataSource.m339getCastMedias$lambda4((MessangerOutput) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "getInstance(UserConfig.s…    it.data\n            }");
        return FlowExtensionsKt.toFlow(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getCastMedias$lambda-4, reason: not valid java name */
    public static final GetCastRelatedOutput m339getCastMedias$lambda4(MessangerOutput it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (GetCastRelatedOutput) it.data;
    }

    @Override // ir.appp.vod.data.source.VodDataSource
    public Object actionOnMedia(String str, VodMediaEntity.LikeStatus likeStatus, Continuation<? super Flow<? extends Object>> continuation) {
        Completable completableActionOnMedia = ApiRequestMessangerRx.getInstance(UserConfig.selectedAccount).actionOnMedia(new ActionOnMediaInput(str, likeStatus));
        Intrinsics.checkNotNullExpressionValue(completableActionOnMedia, "getInstance(UserConfig.s…iaInput(mediaId, action))");
        return FlowExtensionsKt.toFlow(completableActionOnMedia);
    }
}
