package kotlinx.coroutines;

/* compiled from: DefaultExecutor.kt */
/* loaded from: classes4.dex */
public final class DefaultExecutorKt {
    private static final Delay DefaultDelay = DefaultExecutor.INSTANCE;

    public static final Delay getDefaultDelay() {
        return DefaultDelay;
    }
}
