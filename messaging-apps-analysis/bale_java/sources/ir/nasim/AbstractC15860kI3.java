package ir.nasim;

/* renamed from: ir.nasim.kI3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC15860kI3 {
    private static final Object a = new C14539i47("CONDITION_FALSE");

    public static final Object a() {
        return a;
    }

    public static final C16451lI3 b(Object obj) {
        C16451lI3 c16451lI3;
        MN5 mn5 = obj instanceof MN5 ? (MN5) obj : null;
        if (mn5 != null && (c16451lI3 = mn5.a) != null) {
            return c16451lI3;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (C16451lI3) obj;
    }
}
