package ir.nasim;

/* renamed from: ir.nasim.ql2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public enum EnumC19677ql2 {
    JSON(".json"),
    ZIP(".zip"),
    GZIP(".gz");

    public final String a;

    EnumC19677ql2(String str) {
        this.a = str;
    }

    public String j() {
        return ".temp" + this.a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.a;
    }
}
