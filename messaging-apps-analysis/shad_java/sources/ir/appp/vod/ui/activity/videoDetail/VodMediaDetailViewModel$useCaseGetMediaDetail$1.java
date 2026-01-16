package ir.appp.vod.ui.activity.videoDetail;

import ir.appp.common.domain.model.BaseResponse;
import ir.appp.vod.domain.model.output.VodMediaEntityOutput;
import ir.appp.vod.domain.repository.VodRepository;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;

/* compiled from: VodMediaDetailViewModel.kt */
@DebugMetadata(c = "ir.appp.vod.ui.activity.videoDetail.VodMediaDetailViewModel$useCaseGetMediaDetail$1", f = "VodMediaDetailViewModel.kt", l = {29}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class VodMediaDetailViewModel$useCaseGetMediaDetail$1 extends SuspendLambda implements Function1<Continuation<? super Flow<? extends BaseResponse<? extends VodMediaEntityOutput>>>, Object> {
    int label;
    final /* synthetic */ VodMediaDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VodMediaDetailViewModel$useCaseGetMediaDetail$1(VodMediaDetailViewModel vodMediaDetailViewModel, Continuation<? super VodMediaDetailViewModel$useCaseGetMediaDetail$1> continuation) {
        super(1, continuation);
        this.this$0 = vodMediaDetailViewModel;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new VodMediaDetailViewModel$useCaseGetMediaDetail$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Flow<? extends BaseResponse<? extends VodMediaEntityOutput>>> continuation) {
        return invoke2((Continuation<? super Flow<? extends BaseResponse<VodMediaEntityOutput>>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Flow<? extends BaseResponse<VodMediaEntityOutput>>> continuation) {
        return ((VodMediaDetailViewModel$useCaseGetMediaDetail$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            VodRepository vodRepository = this.this$0.repository;
            String mediaId = this.this$0.briefMedia.getMediaId();
            this.label = 1;
            obj = vodRepository.getMedia(mediaId, this);
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
