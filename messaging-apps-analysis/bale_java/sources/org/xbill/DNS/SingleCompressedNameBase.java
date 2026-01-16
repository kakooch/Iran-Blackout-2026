package org.xbill.DNS;

/* loaded from: classes8.dex */
abstract class SingleCompressedNameBase extends SingleNameBase {
    protected SingleCompressedNameBase() {
    }

    @Override // org.xbill.DNS.SingleNameBase, org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.singleName.toWire(dNSOutput, compression, z);
    }

    protected SingleCompressedNameBase(Name name, int i, int i2, long j, Name name2, String str) {
        super(name, i, i2, j, name2, str);
    }
}
