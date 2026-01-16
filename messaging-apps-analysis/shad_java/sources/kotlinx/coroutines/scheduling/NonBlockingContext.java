package kotlinx.coroutines.scheduling;

/* compiled from: Tasks.kt */
/* loaded from: classes4.dex */
public final class NonBlockingContext implements TaskContext {
    public static final NonBlockingContext INSTANCE = new NonBlockingContext();
    private static final int taskMode = 0;

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
    }

    private NonBlockingContext() {
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return taskMode;
    }
}
