package j$.time.temporal;

/* loaded from: classes2.dex */
public enum i implements o {
    NANOS("Nanos", j$.time.e.j(1)),
    MICROS("Micros", j$.time.e.j(1000)),
    MILLIS("Millis", j$.time.e.j(1000000)),
    SECONDS("Seconds", j$.time.e.l(1)),
    MINUTES("Minutes", j$.time.e.l(60)),
    HOURS("Hours", j$.time.e.l(3600)),
    HALF_DAYS("HalfDays", j$.time.e.l(43200)),
    DAYS("Days", j$.time.e.l(86400)),
    WEEKS("Weeks", j$.time.e.l(604800)),
    MONTHS("Months", j$.time.e.l(2629746)),
    YEARS("Years", j$.time.e.l(31556952)),
    DECADES("Decades", j$.time.e.l(315569520)),
    CENTURIES("Centuries", j$.time.e.l(3155695200L)),
    MILLENNIA("Millennia", j$.time.e.l(31556952000L)),
    ERAS("Eras", j$.time.e.l(31556952000000000L)),
    FOREVER("Forever", j$.time.e.n(Long.MAX_VALUE, 999999999));

    private final String b;

    i(String str, j$.time.e eVar) {
        this.b = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}
