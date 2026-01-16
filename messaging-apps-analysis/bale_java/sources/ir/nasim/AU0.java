package ir.nasim;

/* loaded from: classes8.dex */
public enum AU0 {
    CLASS,
    INTERFACE,
    ENUM_CLASS,
    ENUM_ENTRY,
    ANNOTATION_CLASS,
    OBJECT;

    public boolean a() {
        return this == OBJECT || this == ENUM_ENTRY;
    }
}
