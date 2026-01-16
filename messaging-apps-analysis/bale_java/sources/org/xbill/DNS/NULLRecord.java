package org.xbill.DNS;

/* loaded from: classes8.dex */
public class NULLRecord extends Record {
    private byte[] data;

    NULLRecord() {
    }

    public byte[] getData() {
        return this.data;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException {
        throw tokenizer.exception("no defined text format for NULL records");
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

    public NULLRecord(Name name, int i, long j, byte[] bArr) {
        super(name, 10, i, j);
        if (bArr.length > 65535) {
            throw new IllegalArgumentException("data must be <65536 bytes");
        }
        this.data = bArr;
    }
}
