package org.xbill.DNS;

/* loaded from: classes8.dex */
class EmptyRecord extends Record {
    EmptyRecord() {
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) {
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return "";
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
    }
}
