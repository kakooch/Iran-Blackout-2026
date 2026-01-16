package org.xbill.DNS.lookup;

/* loaded from: classes8.dex */
public class RedirectLoopException extends RedirectOverflowException {
    public RedirectLoopException(int i) {
        super("Detected a redirect loop", i);
    }
}
