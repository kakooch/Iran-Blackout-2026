package kotlinx.coroutines;

import defpackage.C$$ServiceLoaderMethods;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* loaded from: classes3.dex */
public final class CoroutineExceptionHandlerImplKt {
    private static final List<CoroutineExceptionHandler> handlers = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.asSequence(C$$ServiceLoaderMethods.$load$79672()));

    public static final void handleCoroutineExceptionImpl(CoroutineContext coroutineContext, Throwable th) {
        Iterator<CoroutineExceptionHandler> it = handlers.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(coroutineContext, th);
            } catch (Throwable th2) {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, CoroutineExceptionHandlerKt.handlerException(th, th2));
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        try {
            Result.Companion companion = Result.Companion;
            ExceptionsKt__ExceptionsKt.addSuppressed(th, new DiagnosticCoroutineContextException(coroutineContext));
            Result.m35constructorimpl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.Companion;
            Result.m35constructorimpl(ResultKt.createFailure(th3));
        }
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}
