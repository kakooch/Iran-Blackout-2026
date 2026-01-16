package androidx.camera.core.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class t {
    private final boolean a;
    private final Set b;
    private final Set c;

    public static class b {
        private boolean a = true;
        private Set b;
        private Set c;

        public t a() {
            return new t(this.a, this.b, this.c);
        }

        public b b(Set set) {
            this.c = new HashSet(set);
            return this;
        }

        public b c(Set set) {
            this.b = new HashSet(set);
            return this;
        }

        public b d(boolean z) {
            this.a = z;
            return this;
        }
    }

    public static t b() {
        return new b().d(true).a();
    }

    public boolean a(Class cls, boolean z) {
        if (this.b.contains(cls)) {
            return true;
        }
        if (this.c.contains(cls)) {
            return false;
        }
        return this.a && z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        t tVar = (t) obj;
        return this.a == tVar.a && Objects.equals(this.b, tVar.b) && Objects.equals(this.c, tVar.c);
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.a), this.b, this.c);
    }

    public String toString() {
        return "QuirkSettings{enabledWhenDeviceHasQuirk=" + this.a + ", forceEnabledQuirks=" + this.b + ", forceDisabledQuirks=" + this.c + '}';
    }

    private t(boolean z, Set set, Set set2) {
        this.a = z;
        this.b = set == null ? Collections.emptySet() : new HashSet(set);
        this.c = set2 == null ? Collections.emptySet() : new HashSet(set2);
    }
}
