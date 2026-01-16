package ir.appp.vod.data.repository;

import ir.appp.common.domain.error.ErrorHandler;
import ir.appp.vod.data.source.VodDataSource;
import ir.appp.vod.domain.repository.VodRepository;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VodRepositoryImpl.kt */
/* loaded from: classes3.dex */
public final class VodRepositoryImpl implements VodRepository {
    private final ErrorHandler errorHandler;
    private final VodDataSource localDataSource;
    private final VodDataSource remoteDataSource;

    /* compiled from: VodRepositoryImpl.kt */
    @DebugMetadata(c = "ir.appp.vod.data.repository.VodRepositoryImpl", f = "VodRepositoryImpl.kt", l = {66}, m = "actionOnMedia")
    /* renamed from: ir.appp.vod.data.repository.VodRepositoryImpl$actionOnMedia$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VodRepositoryImpl.this.actionOnMedia(null, null, this);
        }
    }

    /* compiled from: VodRepositoryImpl.kt */
    @DebugMetadata(c = "ir.appp.vod.data.repository.VodRepositoryImpl", f = "VodRepositoryImpl.kt", l = {55}, m = "getCastMedias")
    /* renamed from: ir.appp.vod.data.repository.VodRepositoryImpl$getCastMedias$1, reason: invalid class name and case insensitive filesystem */
    static final class C00911 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00911(Continuation<? super C00911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VodRepositoryImpl.this.getCastMedias(null, null, this);
        }
    }

    /* compiled from: VodRepositoryImpl.kt */
    @DebugMetadata(c = "ir.appp.vod.data.repository.VodRepositoryImpl", f = "VodRepositoryImpl.kt", l = {37}, m = "getEpisodes")
    /* renamed from: ir.appp.vod.data.repository.VodRepositoryImpl$getEpisodes$1, reason: invalid class name and case insensitive filesystem */
    static final class C00921 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00921(Continuation<? super C00921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VodRepositoryImpl.this.getEpisodes(null, null, this);
        }
    }

    /* compiled from: VodRepositoryImpl.kt */
    @DebugMetadata(c = "ir.appp.vod.data.repository.VodRepositoryImpl", f = "VodRepositoryImpl.kt", l = {24}, m = "getMedia")
    /* renamed from: ir.appp.vod.data.repository.VodRepositoryImpl$getMedia$1, reason: invalid class name and case insensitive filesystem */
    static final class C00931 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00931(Continuation<? super C00931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VodRepositoryImpl.this.getMedia(null, this);
        }
    }

    /* compiled from: VodRepositoryImpl.kt */
    @DebugMetadata(c = "ir.appp.vod.data.repository.VodRepositoryImpl", f = "VodRepositoryImpl.kt", l = {44}, m = "getRelated")
    /* renamed from: ir.appp.vod.data.repository.VodRepositoryImpl$getRelated$1, reason: invalid class name and case insensitive filesystem */
    static final class C00941 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00941(Continuation<? super C00941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VodRepositoryImpl.this.getRelated(null, null, this);
        }
    }

    public VodRepositoryImpl(VodDataSource remoteDataSource, VodDataSource localDataSource, ErrorHandler errorHandler) {
        Intrinsics.checkNotNullParameter(remoteDataSource, "remoteDataSource");
        Intrinsics.checkNotNullParameter(localDataSource, "localDataSource");
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.errorHandler = errorHandler;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.appp.vod.domain.repository.VodRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getMedia(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.appp.common.domain.model.BaseResponse<ir.appp.vod.domain.model.output.VodMediaEntityOutput>>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ir.appp.vod.data.repository.VodRepositoryImpl.C00931
            if (r0 == 0) goto L13
            r0 = r6
            ir.appp.vod.data.repository.VodRepositoryImpl$getMedia$1 r0 = (ir.appp.vod.data.repository.VodRepositoryImpl.C00931) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ir.appp.vod.data.repository.VodRepositoryImpl$getMedia$1 r0 = new ir.appp.vod.data.repository.VodRepositoryImpl$getMedia$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            ir.appp.vod.data.repository.VodRepositoryImpl r5 = (ir.appp.vod.data.repository.VodRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            ir.appp.vod.data.source.VodDataSource r6 = r4.remoteDataSource
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.getMedia(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
            ir.appp.common.domain.error.ErrorHandler r5 = r5.errorHandler
            kotlinx.coroutines.flow.Flow r5 = ir.appp.common.utils.extentions.FlowExtensionsKt.toResult(r6, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.data.repository.VodRepositoryImpl.getMedia(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.appp.vod.domain.repository.VodRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getEpisodes(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.appp.common.domain.model.BaseResponse<ir.appp.vod.domain.model.output.GetEpisodesOutput>>> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.appp.vod.data.repository.VodRepositoryImpl.C00921
            if (r0 == 0) goto L13
            r0 = r7
            ir.appp.vod.data.repository.VodRepositoryImpl$getEpisodes$1 r0 = (ir.appp.vod.data.repository.VodRepositoryImpl.C00921) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ir.appp.vod.data.repository.VodRepositoryImpl$getEpisodes$1 r0 = new ir.appp.vod.data.repository.VodRepositoryImpl$getEpisodes$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            ir.appp.vod.data.repository.VodRepositoryImpl r5 = (ir.appp.vod.data.repository.VodRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            ir.appp.vod.data.source.VodDataSource r7 = r4.remoteDataSource
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r7.getEpisodes(r5, r6, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            kotlinx.coroutines.flow.Flow r7 = (kotlinx.coroutines.flow.Flow) r7
            ir.appp.common.domain.error.ErrorHandler r5 = r5.errorHandler
            kotlinx.coroutines.flow.Flow r5 = ir.appp.common.utils.extentions.FlowExtensionsKt.toResult(r7, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.data.repository.VodRepositoryImpl.getEpisodes(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.appp.vod.domain.repository.VodRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getRelated(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.appp.common.domain.model.BaseResponse<ir.appp.vod.domain.model.output.GetRelatedOutput>>> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.appp.vod.data.repository.VodRepositoryImpl.C00941
            if (r0 == 0) goto L13
            r0 = r7
            ir.appp.vod.data.repository.VodRepositoryImpl$getRelated$1 r0 = (ir.appp.vod.data.repository.VodRepositoryImpl.C00941) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ir.appp.vod.data.repository.VodRepositoryImpl$getRelated$1 r0 = new ir.appp.vod.data.repository.VodRepositoryImpl$getRelated$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            ir.appp.vod.data.repository.VodRepositoryImpl r5 = (ir.appp.vod.data.repository.VodRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            ir.appp.vod.data.source.VodDataSource r7 = r4.remoteDataSource
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r7.getRelated(r5, r6, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            kotlinx.coroutines.flow.Flow r7 = (kotlinx.coroutines.flow.Flow) r7
            ir.appp.common.domain.error.ErrorHandler r5 = r5.errorHandler
            kotlinx.coroutines.flow.Flow r5 = ir.appp.common.utils.extentions.FlowExtensionsKt.toResult(r7, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.data.repository.VodRepositoryImpl.getRelated(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.appp.vod.domain.repository.VodRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getCastMedias(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.appp.common.domain.model.BaseResponse<ir.appp.vod.domain.model.output.GetCastRelatedOutput>>> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.appp.vod.data.repository.VodRepositoryImpl.C00911
            if (r0 == 0) goto L13
            r0 = r7
            ir.appp.vod.data.repository.VodRepositoryImpl$getCastMedias$1 r0 = (ir.appp.vod.data.repository.VodRepositoryImpl.C00911) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ir.appp.vod.data.repository.VodRepositoryImpl$getCastMedias$1 r0 = new ir.appp.vod.data.repository.VodRepositoryImpl$getCastMedias$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            ir.appp.vod.data.repository.VodRepositoryImpl r5 = (ir.appp.vod.data.repository.VodRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            ir.appp.vod.data.source.VodDataSource r7 = r4.remoteDataSource
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r7.getCastMedias(r5, r6, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            kotlinx.coroutines.flow.Flow r7 = (kotlinx.coroutines.flow.Flow) r7
            ir.appp.common.domain.error.ErrorHandler r5 = r5.errorHandler
            kotlinx.coroutines.flow.Flow r5 = ir.appp.common.utils.extentions.FlowExtensionsKt.toResult(r7, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.data.repository.VodRepositoryImpl.getCastMedias(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.appp.vod.domain.repository.VodRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object actionOnMedia(java.lang.String r5, ir.appp.vod.domain.model.output.VodMediaEntity.LikeStatus r6, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends ir.appp.common.domain.model.BaseResponse<? extends java.lang.Object>>> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ir.appp.vod.data.repository.VodRepositoryImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            ir.appp.vod.data.repository.VodRepositoryImpl$actionOnMedia$1 r0 = (ir.appp.vod.data.repository.VodRepositoryImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            ir.appp.vod.data.repository.VodRepositoryImpl$actionOnMedia$1 r0 = new ir.appp.vod.data.repository.VodRepositoryImpl$actionOnMedia$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            ir.appp.vod.data.repository.VodRepositoryImpl r5 = (ir.appp.vod.data.repository.VodRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            ir.appp.vod.data.source.VodDataSource r7 = r4.remoteDataSource
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r7.actionOnMedia(r5, r6, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            kotlinx.coroutines.flow.Flow r7 = (kotlinx.coroutines.flow.Flow) r7
            ir.appp.common.domain.error.ErrorHandler r5 = r5.errorHandler
            kotlinx.coroutines.flow.Flow r5 = ir.appp.common.utils.extentions.FlowExtensionsKt.toResult(r7, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.vod.data.repository.VodRepositoryImpl.actionOnMedia(java.lang.String, ir.appp.vod.domain.model.output.VodMediaEntity$LikeStatus, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
