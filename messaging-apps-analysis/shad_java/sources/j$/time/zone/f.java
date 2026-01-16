package j$.time.zone;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TimeZone;

/* loaded from: classes2.dex */
final class f extends g {
    private final Set c;

    f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : TimeZone.getAvailableIDs()) {
            linkedHashSet.add(str);
        }
        this.c = Collections.unmodifiableSet(linkedHashSet);
    }

    @Override // j$.time.zone.g
    protected c b(String str, boolean z) {
        if (this.c.contains(str)) {
            return new c(TimeZone.getTimeZone(str));
        }
        throw new d("Not a built-in time zone: " + str);
    }

    @Override // j$.time.zone.g
    protected Set c() {
        return this.c;
    }
}
