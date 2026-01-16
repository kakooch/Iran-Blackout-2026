package j$.time;

import java.io.Serializable;

/* loaded from: classes2.dex */
final class n extends l implements Serializable {
    private final String b;
    private final transient j$.time.zone.c c;

    n(String str, j$.time.zone.c cVar) {
        this.b = str;
        this.c = cVar;
    }

    static n y(String str, boolean z) {
        int length = str.length();
        if (length < 2) {
            throw new c("Invalid ID for region-based ZoneId, invalid format: " + str);
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt != '/' || i == 0) && ((cCharAt < '0' || cCharAt > '9' || i == 0) && ((cCharAt != '~' || i == 0) && ((cCharAt != '.' || i == 0) && ((cCharAt != '_' || i == 0) && ((cCharAt != '+' || i == 0) && (cCharAt != '-' || i == 0))))))))) {
                throw new c("Invalid ID for region-based ZoneId, invalid format: " + str);
            }
        }
        j$.time.zone.c cVarA = null;
        try {
            cVarA = j$.time.zone.e.a(str, true);
        } catch (j$.time.zone.d e) {
            if (z) {
                throw e;
            }
        }
        return new n(str, cVarA);
    }

    @Override // j$.time.l
    public String g() {
        return this.b;
    }

    @Override // j$.time.l
    public j$.time.zone.c t() {
        j$.time.zone.c cVar = this.c;
        return cVar != null ? cVar : j$.time.zone.e.a(this.b, false);
    }
}
