package androidx.datastore.preferences.protobuf;

import java.util.List;

/* loaded from: classes2.dex */
public class UninitializedMessageException extends RuntimeException {
    private final List a;

    public UninitializedMessageException(I i) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.a = null;
    }

    public InvalidProtocolBufferException a() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
