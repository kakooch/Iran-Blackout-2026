package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: Share.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", l = {206, 210, 211, 217}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $initialValue;
    final /* synthetic */ MutableSharedFlow $shared;
    final /* synthetic */ SharingStarted $started;
    final /* synthetic */ Flow $upstream;
    Object L$0;
    int label;
    private CoroutineScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__ShareKt$launchSharing$1(SharingStarted sharingStarted, Flow flow, MutableSharedFlow mutableSharedFlow, Object obj, Continuation continuation) {
        super(2, continuation);
        this.$started = sharingStarted;
        this.$upstream = flow;
        this.$shared = mutableSharedFlow;
        this.$initialValue = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt__ShareKt$launchSharing$1 flowKt__ShareKt$launchSharing$1 = new FlowKt__ShareKt$launchSharing$1(this.$started, this.$upstream, this.$shared, this.$initialValue, continuation);
        flowKt__ShareKt$launchSharing$1.p$ = (CoroutineScope) obj;
        return flowKt__ShareKt$launchSharing$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FlowKt__ShareKt$launchSharing$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0078 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2d
            if (r1 == r5) goto L25
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L25
            if (r1 != r2) goto L15
            goto L25
        L15:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1d:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L6a
        L25:
            java.lang.Object r0 = r8.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L99
        L2d:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.CoroutineScope r1 = r8.p$
            kotlinx.coroutines.flow.SharingStarted r9 = r8.$started
            kotlinx.coroutines.flow.SharingStarted$Companion r6 = kotlinx.coroutines.flow.SharingStarted.Companion
            kotlinx.coroutines.flow.SharingStarted r7 = r6.getEagerly()
            if (r9 != r7) goto L4b
            kotlinx.coroutines.flow.Flow r9 = r8.$upstream
            kotlinx.coroutines.flow.MutableSharedFlow r2 = r8.$shared
            r8.L$0 = r1
            r8.label = r5
            java.lang.Object r9 = r9.collect(r2, r8)
            if (r9 != r0) goto L99
            return r0
        L4b:
            kotlinx.coroutines.flow.SharingStarted r9 = r8.$started
            kotlinx.coroutines.flow.SharingStarted r5 = r6.getLazily()
            r6 = 0
            if (r9 != r5) goto L79
            kotlinx.coroutines.flow.MutableSharedFlow r9 = r8.$shared
            kotlinx.coroutines.flow.StateFlow r9 = r9.getSubscriptionCount()
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1 r2 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1
            r2.<init>(r6)
            r8.L$0 = r1
            r8.label = r4
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.first(r9, r2, r8)
            if (r9 != r0) goto L6a
            return r0
        L6a:
            kotlinx.coroutines.flow.Flow r9 = r8.$upstream
            kotlinx.coroutines.flow.MutableSharedFlow r2 = r8.$shared
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r9 = r9.collect(r2, r8)
            if (r9 != r0) goto L99
            return r0
        L79:
            kotlinx.coroutines.flow.SharingStarted r9 = r8.$started
            kotlinx.coroutines.flow.MutableSharedFlow r3 = r8.$shared
            kotlinx.coroutines.flow.StateFlow r3 = r3.getSubscriptionCount()
            kotlinx.coroutines.flow.Flow r9 = r9.command(r3)
            kotlinx.coroutines.flow.Flow r9 = kotlinx.coroutines.flow.FlowKt.distinctUntilChanged(r9)
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 r3 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2
            r3.<init>(r6)
            r8.L$0 = r1
            r8.label = r2
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.collectLatest(r9, r3, r8)
            if (r9 != r0) goto L99
            return r0
        L99:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: Share.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", l = {}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
        int label;
        private int p$0;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            Number number = (Number) obj;
            number.intValue();
            anonymousClass1.p$0 = number.intValue();
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Integer num, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(num, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.p$0 > 0);
        }
    }

    /* compiled from: Share.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", l = {219}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        private SharingCommand p$0;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = FlowKt__ShareKt$launchSharing$1.this.new AnonymousClass2(continuation);
            anonymousClass2.p$0 = (SharingCommand) obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SharingCommand sharingCommand, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(sharingCommand, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharingCommand sharingCommand = this.p$0;
                int i2 = FlowKt.WhenMappings.$EnumSwitchMapping$0[sharingCommand.ordinal()];
                if (i2 == 1) {
                    FlowKt__ShareKt$launchSharing$1 flowKt__ShareKt$launchSharing$1 = FlowKt__ShareKt$launchSharing$1.this;
                    Flow flow = flowKt__ShareKt$launchSharing$1.$upstream;
                    MutableSharedFlow mutableSharedFlow = flowKt__ShareKt$launchSharing$1.$shared;
                    this.L$0 = sharingCommand;
                    this.label = 1;
                    if (flow.collect(mutableSharedFlow, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 == 3) {
                    FlowKt__ShareKt$launchSharing$1 flowKt__ShareKt$launchSharing$12 = FlowKt__ShareKt$launchSharing$1.this;
                    Object obj2 = flowKt__ShareKt$launchSharing$12.$initialValue;
                    if (obj2 == SharedFlowKt.NO_VALUE) {
                        flowKt__ShareKt$launchSharing$12.$shared.resetReplayCache();
                    } else {
                        flowKt__ShareKt$launchSharing$12.$shared.tryEmit(obj2);
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
