package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;

/* loaded from: classes8.dex */
public class UninitializedMessageException extends RuntimeException {
    private final List a;

    public UninitializedMessageException(l lVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.a = null;
    }

    public InvalidProtocolBufferException a() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
