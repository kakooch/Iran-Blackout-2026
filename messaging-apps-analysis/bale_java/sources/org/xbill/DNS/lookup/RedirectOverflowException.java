package org.xbill.DNS.lookup;

import lombok.Generated;

/* loaded from: classes8.dex */
public class RedirectOverflowException extends LookupFailedException {
    private final int maxRedirects;

    @Deprecated
    public RedirectOverflowException(String str) {
        super(str);
        this.maxRedirects = 0;
    }

    @Generated
    public int getMaxRedirects() {
        return this.maxRedirects;
    }

    public RedirectOverflowException(int i) {
        super("Refusing to follow more than " + i + " redirects");
        this.maxRedirects = i;
    }

    RedirectOverflowException(String str, int i) {
        super(str);
        this.maxRedirects = i;
    }
}
