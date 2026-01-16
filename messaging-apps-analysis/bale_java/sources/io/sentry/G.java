package io.sentry;

import java.util.Objects;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class G {
    private final String a;
    private final Pattern b;

    public G(String str) {
        Pattern patternCompile;
        this.a = str;
        try {
            patternCompile = Pattern.compile(str);
        } catch (Throwable unused) {
            Z1.r().e().getLogger().c(Y2.DEBUG, "Only using filter string for String comparison as it could not be parsed as regex: %s", str);
            patternCompile = null;
        }
        this.b = patternCompile;
    }

    public String a() {
        return this.a;
    }

    public boolean b(String str) {
        Pattern pattern = this.b;
        if (pattern == null) {
            return false;
        }
        return pattern.matcher(str).matches();
    }

    public boolean equals(Object obj) {
        if (obj == null || G.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.a, ((G) obj).a);
    }

    public int hashCode() {
        return Objects.hash(this.a);
    }
}
