package ir.appp.vod.ui.activity.relatedMovieList;

import android.os.Bundle;
import ir.appp.common.domain.model.BaseResponse;
import ir.appp.vod.domain.model.output.GetCastRelatedOutput;
import ir.appp.vod.domain.repository.VodRepository;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;

/* compiled from: VodRelatedMediaViewModel.kt */
@DebugMetadata(c = "ir.appp.vod.ui.activity.relatedMovieList.VodRelatedMediaViewModel$castMediaUseCase$1", f = "VodRelatedMediaViewModel.kt", l = {23}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class VodRelatedMediaViewModel$castMediaUseCase$1 extends SuspendLambda implements Function3<String, Bundle, Continuation<? super Flow<? extends BaseResponse<? extends GetCastRelatedOutput>>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VodRelatedMediaViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VodRelatedMediaViewModel$castMediaUseCase$1(VodRelatedMediaViewModel vodRelatedMediaViewModel, Continuation<? super VodRelatedMediaViewModel$castMediaUseCase$1> continuation) {
        super(3, continuation);
        this.this$0 = vodRelatedMediaViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(String str, Bundle bundle, Continuation<? super Flow<? extends BaseResponse<? extends GetCastRelatedOutput>>> continuation) {
        return invoke2(str, bundle, (Continuation<? super Flow<? extends BaseResponse<GetCastRelatedOutput>>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, Bundle bundle, Continuation<? super Flow<? extends BaseResponse<GetCastRelatedOutput>>> continuation) {
        VodRelatedMediaViewModel$castMediaUseCase$1 vodRelatedMediaViewModel$castMediaUseCase$1 = new VodRelatedMediaViewModel$castMediaUseCase$1(this.this$0, continuation);
        vodRelatedMediaViewModel$castMediaUseCase$1.L$0 = str;
        return vodRelatedMediaViewModel$castMediaUseCase$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            VodRepository vodRepository = this.this$0.repository;
            String str2 = this.this$0.id;
            this.label = 1;
            obj = vodRepository.getCastMedias(str2, str, this);
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
