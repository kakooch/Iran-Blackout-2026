package ir.nasim;

/* renamed from: ir.nasim.We2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC8487We2 {

    /* renamed from: ir.nasim.We2$a */
    public enum a {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH
    }

    /* renamed from: ir.nasim.We2$b */
    public enum b {
        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN
    }

    b a(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02, InterfaceC21331tU0 interfaceC21331tU0);

    a b();
}
