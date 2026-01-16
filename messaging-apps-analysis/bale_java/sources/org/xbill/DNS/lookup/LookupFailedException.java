package org.xbill.DNS.lookup;

import android.gov.nist.core.Separators;
import lombok.Generated;
import org.xbill.DNS.Name;
import org.xbill.DNS.Type;

/* loaded from: classes8.dex */
public class LookupFailedException extends RuntimeException {
    private final boolean isAuthenticated;
    private final Name name;
    private final int type;

    public LookupFailedException() {
        this(null, null, null, 0, false);
    }

    public Name getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    @Generated
    boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    public LookupFailedException(String str) {
        this(str, null, null, 0, false);
    }

    LookupFailedException(String str, Throwable th) {
        this(str, th, null, 0, false);
    }

    public LookupFailedException(Name name, int i) {
        this("Lookup for " + name + Separators.SLASH + Type.string(i) + " failed", name, i);
    }

    public LookupFailedException(String str, Name name, int i) {
        this(str, null, name, i, false);
    }

    LookupFailedException(String str, Throwable th, Name name, int i, boolean z) {
        super(str, th);
        this.name = name;
        this.type = i;
        this.isAuthenticated = z;
    }
}
