package ir.nasim;

/* renamed from: ir.nasim.o74, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC18123o74 {
    public static final boolean a(C17532n74 c17532n74, C17532n74 c17532n742) {
        if (c17532n74 == null && c17532n742 == null) {
            return true;
        }
        if (c17532n74 == null || c17532n742 == null) {
            return false;
        }
        return c17532n742.E() == c17532n74.E() && c17532n742.G() == c17532n74.G() && AbstractC13042fc3.d(c17532n742.z(), c17532n74.z()) && c17532n742.y() == c17532n74.y() && AbstractC13042fc3.d(c17532n742.w(), c17532n74.w());
    }
}
