package j$.time.format;

/* loaded from: classes2.dex */
enum l implements g {
    SENSITIVE,
    INSENSITIVE,
    STRICT,
    LENIENT;

    @Override // j$.time.format.g
    public boolean a(q qVar, StringBuilder sb) {
        return true;
    }

    @Override // java.lang.Enum
    public String toString() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return "ParseCaseSensitive(true)";
        }
        if (iOrdinal == 1) {
            return "ParseCaseSensitive(false)";
        }
        if (iOrdinal == 2) {
            return "ParseStrict(true)";
        }
        if (iOrdinal == 3) {
            return "ParseStrict(false)";
        }
        throw new IllegalStateException("Unreachable");
    }
}
