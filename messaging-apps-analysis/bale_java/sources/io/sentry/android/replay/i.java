package io.sentry.android.replay;

import ir.nasim.AbstractC13042fc3;
import java.io.File;

/* loaded from: classes3.dex */
public final class i {
    private final File a;
    private final long b;
    private final String c;

    public i(File file, long j, String str) {
        AbstractC13042fc3.i(file, "screenshot");
        this.a = file;
        this.b = j;
        this.c = str;
    }

    public final String a() {
        return this.c;
    }

    public final File b() {
        return this.a;
    }

    public final long c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return AbstractC13042fc3.d(this.a, iVar.a) && this.b == iVar.b && AbstractC13042fc3.d(this.c, iVar.c);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31;
        String str = this.c;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ReplayFrame(screenshot=" + this.a + ", timestamp=" + this.b + ", screen=" + this.c + ')';
    }
}
