package org.xbill.DNS.lookup;

/* loaded from: classes8.dex */
public class InvalidZoneDataException extends LookupFailedException {
    InvalidZoneDataException(String str, Throwable th) {
        super(str, th);
    }

    public InvalidZoneDataException(String str) {
        super(str);
    }
}
