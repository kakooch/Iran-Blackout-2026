package org.xbill.DNS;

/* loaded from: classes8.dex */
public class UNKRecord extends Record {
    private byte[] data;

    UNKRecord() {
    }

    public byte[] getData() {
        return this.data;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException {
        throw tokenizer.exception("invalid unknown RR encoding");
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.data = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return Record.unknownToString(this.data);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeByteArray(this.data);
    }
}
