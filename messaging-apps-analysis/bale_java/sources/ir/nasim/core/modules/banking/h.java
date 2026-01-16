package ir.nasim.core.modules.banking;

/* loaded from: classes5.dex */
public class h extends j {
    private Long c;
    private Long d;

    h(String str, String str2, String str3) {
        super(str);
        if (this.b) {
            try {
                this.d = Long.valueOf(str3);
            } catch (NumberFormatException unused) {
            }
            try {
                this.c = Long.valueOf(str2);
            } catch (NumberFormatException unused2) {
                Long l = this.d;
                this.c = Long.valueOf(l == null ? -1L : l.longValue());
                this.b = false;
                this.a = "CurrentBalanceAmount is NULL";
            }
        }
    }

    public Long c() {
        return this.d;
    }

    public Long d() {
        return this.c;
    }
}
