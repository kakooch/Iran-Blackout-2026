package com.google.android.gms.tasks;

/* loaded from: classes3.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(Task task) {
        if (!task.o()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excK = task.k();
        return new DuplicateTaskCompletionException("Complete with: ".concat(excK != null ? "failure" : task.p() ? "result ".concat(String.valueOf(task.l())) : task.n() ? "cancellation" : "unknown issue"), excK);
    }
}
