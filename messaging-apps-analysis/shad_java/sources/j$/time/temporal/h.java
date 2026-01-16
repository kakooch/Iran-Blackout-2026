package j$.time.temporal;

/* loaded from: classes2.dex */
enum h implements v {
    WEEK_BASED_YEARS("WeekBasedYears", j$.time.e.c(31556952)),
    QUARTER_YEARS("QuarterYears", j$.time.e.c(7889238));

    private final String a;

    h(String str, j$.time.e eVar) {
        this.a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.a;
    }
}
