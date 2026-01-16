package kotlinx.coroutines.internal;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes4.dex */
public final class LockFreeLinkedListKt {
    private static final Object CONDITION_FALSE = new Symbol("CONDITION_FALSE");

    static {
        new Symbol("LIST_EMPTY");
    }

    public static final Object getCONDITION_FALSE() {
        return CONDITION_FALSE;
    }

    public static final LockFreeLinkedListNode unwrap(Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Removed removed = (Removed) (!(obj instanceof Removed) ? null : obj);
        if (removed != null && (lockFreeLinkedListNode = removed.ref) != null) {
            return lockFreeLinkedListNode;
        }
        if (obj != null) {
            return (LockFreeLinkedListNode) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
}
