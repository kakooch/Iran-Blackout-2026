package org.xbill.DNS.lookup;

import org.xbill.DNS.Name;

/* loaded from: classes8.dex */
public class NoSuchDomainException extends LookupFailedException {
    public NoSuchDomainException(Name name, int i) {
        this(name, i, false);
    }

    NoSuchDomainException(Name name, int i, boolean z) {
        super(null, null, name, i, z);
    }
}
