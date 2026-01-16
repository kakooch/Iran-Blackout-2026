package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* compiled from: Transform.kt */
/* loaded from: classes4.dex */
final /* synthetic */ class FlowKt__TransformKt {
    public static final <T> Flow<T> onEach(final Flow<? extends T> flow, final Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            /* compiled from: Collect.kt */
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements FlowCollector<T> {
                final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
                final /* synthetic */ FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 this$0;

                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {134, 135}, m = "emit")
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1) {
                    this.$this_unsafeFlow$inlined = flowCollector;
                    this.this$0 = flowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
                    /*
                        r9 = this;
                        boolean r0 = r11 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r11
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r11)
                    L18:
                        java.lang.Object r11 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L5e
                        if (r2 == r4) goto L44
                        if (r2 != r3) goto L3c
                        java.lang.Object r10 = r0.L$6
                        kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
                        java.lang.Object r10 = r0.L$4
                        kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                        java.lang.Object r10 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r10 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r10
                        java.lang.Object r10 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2 r10 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2) r10
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto La4
                    L3c:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L44:
                        java.lang.Object r10 = r0.L$6
                        kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
                        java.lang.Object r2 = r0.L$5
                        java.lang.Object r4 = r0.L$4
                        kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                        java.lang.Object r5 = r0.L$3
                        java.lang.Object r6 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r6
                        java.lang.Object r7 = r0.L$1
                        java.lang.Object r8 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2 r8 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2) r8
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L8d
                    L5e:
                        kotlin.ResultKt.throwOnFailure(r11)
                        kotlinx.coroutines.flow.FlowCollector r11 = r9.$this_unsafeFlow$inlined
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 r2 = r9.this$0
                        kotlin.jvm.functions.Function2 r2 = r2
                        r0.L$0 = r9
                        r0.L$1 = r10
                        r0.L$2 = r0
                        r0.L$3 = r10
                        r0.L$4 = r0
                        r0.L$5 = r10
                        r0.L$6 = r11
                        r0.label = r4
                        r4 = 6
                        kotlin.jvm.internal.InlineMarker.mark(r4)
                        java.lang.Object r2 = r2.invoke(r10, r0)
                        r4 = 7
                        kotlin.jvm.internal.InlineMarker.mark(r4)
                        if (r2 != r1) goto L86
                        return r1
                    L86:
                        r8 = r9
                        r2 = r10
                        r5 = r2
                        r7 = r5
                        r10 = r11
                        r4 = r0
                        r6 = r4
                    L8d:
                        r0.L$0 = r8
                        r0.L$1 = r7
                        r0.L$2 = r6
                        r0.L$3 = r5
                        r0.L$4 = r4
                        r0.L$5 = r2
                        r0.L$6 = r10
                        r0.label = r3
                        java.lang.Object r10 = r10.emit(r2, r0)
                        if (r10 != r1) goto La4
                        return r1
                    La4:
                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, this), continuation);
                return objCollect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }
}
