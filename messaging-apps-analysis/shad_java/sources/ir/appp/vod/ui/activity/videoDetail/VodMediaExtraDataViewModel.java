package ir.appp.vod.ui.activity.videoDetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import ir.appp.common.domain.model.BaseResponse;
import ir.appp.common.utils.repositoryBuilder.PagingRepositoryBuilder;
import ir.appp.vod.di.VodAppModule;
import ir.appp.vod.domain.model.VodBriefMediaEntity;
import ir.appp.vod.domain.model.output.GetEpisodesOutput;
import ir.appp.vod.domain.model.output.GetRelatedOutput;
import ir.appp.vod.domain.repository.VodRepository;
import ir.appp.vod.util.VodViewModelExtensionsKt;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: VodMediaExtraDataViewModel.kt */
/* loaded from: classes3.dex */
public final class VodMediaExtraDataViewModel extends ViewModel {
    private final VodBriefMediaEntity briefMedia;
    private PagingRepositoryBuilder<GetRelatedOutput> relatedUseCase;
    private final VodRepository repository;
    private final Map<String, LiveData<BaseResponse<GetEpisodesOutput>>> seasonsMutableLiveDataMap;

    public /* synthetic */ VodMediaExtraDataViewModel(VodRepository vodRepository, VodBriefMediaEntity vodBriefMediaEntity, DefaultConstructorMarker defaultConstructorMarker) {
        this(vodRepository, vodBriefMediaEntity);
    }

    private VodMediaExtraDataViewModel(VodRepository vodRepository, VodBriefMediaEntity vodBriefMediaEntity) {
        this.repository = vodRepository;
        this.briefMedia = vodBriefMediaEntity;
        this.seasonsMutableLiveDataMap = VodViewModelExtensionsKt.lazyMap(this, new Function1<String, MutableLiveData<BaseResponse<? extends GetEpisodesOutput>>>() { // from class: ir.appp.vod.ui.activity.videoDetail.VodMediaExtraDataViewModel$seasonsMutableLiveDataMap$1
            {
                super(1);
            }

            /* compiled from: VodMediaExtraDataViewModel.kt */
            @DebugMetadata(c = "ir.appp.vod.ui.activity.videoDetail.VodMediaExtraDataViewModel$seasonsMutableLiveDataMap$1$1", f = "VodMediaExtraDataViewModel.kt", l = {23}, m = "invokeSuspend")
            /* renamed from: ir.appp.vod.ui.activity.videoDetail.VodMediaExtraDataViewModel$seasonsMutableLiveDataMap$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Flow<? extends BaseResponse<? extends GetEpisodesOutput>>>, Object> {
                final /* synthetic */ String $seasonId;
                int label;
                final /* synthetic */ VodMediaExtraDataViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(VodMediaExtraDataViewModel vodMediaExtraDataViewModel, String str, Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                    this.this$0 = vodMediaExtraDataViewModel;
                    this.$seasonId = str;
                }

                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$seasonId, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Flow<? extends BaseResponse<? extends GetEpisodesOutput>>> continuation) {
                    return invoke2((Continuation<? super Flow<? extends BaseResponse<GetEpisodesOutput>>>) continuation);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(Continuation<? super Flow<? extends BaseResponse<GetEpisodesOutput>>> continuation) {
                    return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        VodRepository vodRepository = this.this$0.repository;
                        String mediaId = this.this$0.briefMedia.getMediaId();
                        String str = this.$seasonId;
                        this.label = 1;
                        obj = vodRepository.getEpisodes(mediaId, str, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return obj;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final MutableLiveData<BaseResponse<GetEpisodesOutput>> invoke(String seasonId) {
                Intrinsics.checkNotNullParameter(seasonId, "seasonId");
                MutableLiveData<BaseResponse<GetEpisodesOutput>> mutableLiveData = new MutableLiveData<>();
                VodMediaExtraDataViewModel vodMediaExtraDataViewModel = this.this$0;
                VodViewModelExtensionsKt.callOnceApi(vodMediaExtraDataViewModel, ViewModelKt.getViewModelScope(vodMediaExtraDataViewModel), mutableLiveData, new AnonymousClass1(this.this$0, seasonId, null));
                return mutableLiveData;
            }
        });
        this.relatedUseCase = new PagingRepositoryBuilder<>(ViewModelKt.getViewModelScope(this), VodAppModule.INSTANCE.provideVodGeneralErrorHandler(), true, "0", null, new VodMediaExtraDataViewModel$relatedUseCase$1(this, null), 16, null);
    }

    public final LiveData<BaseResponse<GetEpisodesOutput>> episodesLiveData(String seasonId) {
        Intrinsics.checkNotNullParameter(seasonId, "seasonId");
        return (LiveData) MapsKt.getValue(this.seasonsMutableLiveDataMap, seasonId);
    }

    public final PagingRepositoryBuilder<GetRelatedOutput> getRelatedUseCase() {
        return this.relatedUseCase;
    }

    /* compiled from: VodMediaExtraDataViewModel.kt */
    public static final class VodMediaExtraDataViewModelFactory extends ViewModelProvider.NewInstanceFactory {
        private final VodBriefMediaEntity briefMedia;

        public VodMediaExtraDataViewModelFactory(VodBriefMediaEntity briefMedia) {
            Intrinsics.checkNotNullParameter(briefMedia, "briefMedia");
            this.briefMedia = briefMedia;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new VodMediaExtraDataViewModel(VodAppModule.INSTANCE.getRepository(), this.briefMedia, null);
        }
    }
}
