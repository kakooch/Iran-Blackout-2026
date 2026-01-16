package ir.appp.vod.ui.activity.videoDetail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import ir.appp.common.domain.model.BaseResponse;
import ir.appp.common.utils.repositoryBuilder.CallOnceRepositoryBuilder;
import ir.appp.vod.di.VodAppModule;
import ir.appp.vod.domain.model.VodBriefMediaEntity;
import ir.appp.vod.domain.model.output.VodMediaEntity;
import ir.appp.vod.domain.model.output.VodMediaEntityOutput;
import ir.appp.vod.domain.repository.VodRepository;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: VodMediaDetailViewModel.kt */
/* loaded from: classes3.dex */
public final class VodMediaDetailViewModel extends ViewModel {
    private MutableLiveData<BaseResponse<Object>> _ratedMutableLiveData;
    private final VodBriefMediaEntity briefMedia;
    private final VodRepository repository;
    private final CallOnceRepositoryBuilder<VodMediaEntityOutput> useCaseGetMediaDetail;
    private CoroutineScope videoRateScope;

    public VodMediaDetailViewModel(VodRepository repository, VodBriefMediaEntity briefMedia) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(briefMedia, "briefMedia");
        this.repository = repository;
        this.briefMedia = briefMedia;
        this.videoRateScope = CoroutineScopeKt.CoroutineScope(JobKt__JobKt.Job$default(null, 1, null).plus(ViewModelKt.getViewModelScope(this).getCoroutineContext()));
        this.useCaseGetMediaDetail = new CallOnceRepositoryBuilder<>(VodAppModule.INSTANCE.provideVodGeneralErrorHandler(), ViewModelKt.getViewModelScope(this), new VodMediaDetailViewModel$useCaseGetMediaDetail$1(this, null));
        this._ratedMutableLiveData = new MutableLiveData<>();
    }

    public final CallOnceRepositoryBuilder<VodMediaEntityOutput> getUseCaseGetMediaDetail() {
        return this.useCaseGetMediaDetail;
    }

    /* compiled from: VodMediaDetailViewModel.kt */
    @DebugMetadata(c = "ir.appp.vod.ui.activity.videoDetail.VodMediaDetailViewModel$rateVideo$1", f = "VodMediaDetailViewModel.kt", l = {39, 54}, m = "invokeSuspend")
    /* renamed from: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailViewModel$rateVideo$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ VodMediaEntity.LikeStatus $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(VodMediaEntity.LikeStatus likeStatus, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$action = likeStatus;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return VodMediaDetailViewModel.this.new AnonymousClass1(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                VodRepository vodRepository = VodMediaDetailViewModel.this.repository;
                String mediaId = VodMediaDetailViewModel.this.briefMedia.getMediaId();
                VodMediaEntity.LikeStatus likeStatus = this.$action;
                this.label = 1;
                obj = vodRepository.actionOnMedia(mediaId, likeStatus, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            final VodMediaDetailViewModel vodMediaDetailViewModel = VodMediaDetailViewModel.this;
            FlowCollector<BaseResponse<? extends Object>> flowCollector = new FlowCollector<BaseResponse<? extends Object>>() { // from class: ir.appp.vod.ui.activity.videoDetail.VodMediaDetailViewModel$rateVideo$1$invokeSuspend$$inlined$collect$1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public Object emit(BaseResponse<? extends Object> baseResponse, Continuation continuation) {
                    vodMediaDetailViewModel._ratedMutableLiveData.setValue(baseResponse);
                    return Unit.INSTANCE;
                }
            };
            this.label = 2;
            if (((Flow) obj).collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    public final void rateVideo(VodMediaEntity.LikeStatus action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt__Builders_commonKt.launch$default(this.videoRateScope, null, null, new AnonymousClass1(action, null), 3, null);
    }

    /* compiled from: VodMediaDetailViewModel.kt */
    public static final class VodMediaDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {
        private final VodBriefMediaEntity briefMedia;

        public VodMediaDetailViewModelFactory(VodBriefMediaEntity briefMedia) {
            Intrinsics.checkNotNullParameter(briefMedia, "briefMedia");
            this.briefMedia = briefMedia;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new VodMediaDetailViewModel(VodAppModule.INSTANCE.getRepository(), this.briefMedia);
        }
    }
}
