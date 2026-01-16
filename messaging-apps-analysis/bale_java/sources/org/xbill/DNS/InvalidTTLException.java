package org.xbill.DNS;

/* loaded from: classes8.dex */
public class InvalidTTLException extends IllegalArgumentException {
    public InvalidTTLException(long j) {
        super("Invalid DNS TTL: " + j);
    }
}
