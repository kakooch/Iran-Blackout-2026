package org.xbill.DNS;

import java.security.PublicKey;

/* loaded from: classes8.dex */
public class CDNSKEYRecord extends DNSKEYRecord {
    CDNSKEYRecord() {
    }

    public CDNSKEYRecord(Name name, int i, long j, int i2, int i3, int i4, byte[] bArr) {
        super(name, 60, i, j, i2, i3, i4, bArr);
    }

    public CDNSKEYRecord(Name name, int i, long j, int i2, int i3, int i4, PublicKey publicKey) {
        super(name, 60, i, j, i2, i3, i4, DNSSEC.fromPublicKey(publicKey, i4));
    }
}
