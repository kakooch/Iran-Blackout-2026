package ir.nasim;

/* loaded from: classes2.dex */
public enum Ta8 {
    ENQUEUED,
    RUNNING,
    SUCCEEDED,
    FAILED,
    BLOCKED,
    CANCELLED;

    public boolean a() {
        return this == SUCCEEDED || this == FAILED || this == CANCELLED;
    }
}
