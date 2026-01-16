package ir.nasim;

/* renamed from: ir.nasim.Uy3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC8200Uy3 {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");

    private int a;
    private String b;

    EnumC8200Uy3(int i, String str) {
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
