package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$BooleanRef;

/* compiled from: Collect.kt */
/* loaded from: classes4.dex */
public final class StartedLazily$command$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Integer> {
    final /* synthetic */ Ref$BooleanRef $started$inlined;
    final /* synthetic */ FlowCollector $this_flow$inlined;

    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1", f = "SharingStarted.kt", l = {135}, m = "emit")
    /* renamed from: kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StartedLazily$command$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public StartedLazily$command$1$invokeSuspend$$inlined$collect$1(FlowCollector flowCollector, Ref$BooleanRef ref$BooleanRef) {
        this.$this_flow$inlined = flowCollector;
        this.$started$inlined = ref$BooleanRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object emit(java.lang.Integer r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1$1 r0 = (kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1$1 r0 = new kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$2
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1 r6 = (kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L62
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            if (r7 <= 0) goto L62
            kotlin.jvm.internal.Ref$BooleanRef r2 = r5.$started$inlined
            boolean r4 = r2.element
            if (r4 != 0) goto L62
            r2.element = r3
            kotlinx.coroutines.flow.FlowCollector r2 = r5.$this_flow$inlined
            kotlinx.coroutines.flow.SharingCommand r4 = kotlinx.coroutines.flow.SharingCommand.START
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r0
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r6 = r2.emit(r4, r0)
            if (r6 != r1) goto L62
            return r1
        L62:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
