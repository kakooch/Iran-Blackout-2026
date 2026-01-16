package j$.time.temporal;

/* loaded from: classes2.dex */
public enum b implements v {
    NANOS("Nanos", j$.time.e.b(1)),
    MICROS("Micros", j$.time.e.b(1000)),
    MILLIS("Millis", j$.time.e.b(1000000)),
    SECONDS("Seconds", j$.time.e.c(1)),
    MINUTES("Minutes", j$.time.e.c(60)),
    HOURS("Hours", j$.time.e.c(3600)),
    HALF_DAYS("HalfDays", j$.time.e.c(43200)),
    DAYS("Days", j$.time.e.c(86400)),
    WEEKS("Weeks", j$.time.e.c(604800)),
    MONTHS("Months", j$.time.e.c(2629746)),
    YEARS("Years", j$.time.e.c(31556952)),
    DECADES("Decades", j$.time.e.c(315569520)),
    CENTURIES("Centuries", j$.time.e.c(3155695200L)),
    MILLENNIA("Millennia", j$.time.e.c(31556952000L)),
    ERAS("Eras", j$.time.e.c(31556952000000000L)),
    FOREVER("Forever", j$.time.e.d(Long.MAX_VALUE, 999999999));

    private final String a;

    b(String str, j$.time.e eVar) {
        this.a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.a;
    }
}
