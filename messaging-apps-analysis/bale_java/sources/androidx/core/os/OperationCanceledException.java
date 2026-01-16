package androidx.core.os;

import ir.nasim.FG4;

/* loaded from: classes2.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String str) {
        super(FG4.e(str, "The operation has been canceled."));
    }
}
