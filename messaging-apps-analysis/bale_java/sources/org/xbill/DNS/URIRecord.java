package org.xbill.DNS;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public class URIRecord extends Record {
    private int priority;
    private byte[] target;
    private int weight;

    URIRecord() {
        this.target = new byte[0];
    }

    public int getPriority() {
        return this.priority;
    }

    public String getTarget() {
        return Record.byteArrayToString(this.target, false);
    }

    public int getWeight() {
        return this.weight;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException {
        this.priority = tokenizer.getUInt16();
        this.weight = tokenizer.getUInt16();
        try {
            this.target = Record.byteArrayFromString(tokenizer.getString());
        } catch (TextParseException e) {
            throw tokenizer.exception(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.priority = dNSInput.readU16();
        this.weight = dNSInput.readU16();
        this.target = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.priority + Separators.SP + this.weight + Separators.SP + Record.byteArrayToString(this.target, true);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.priority);
        dNSOutput.writeU16(this.weight);
        dNSOutput.writeByteArray(this.target);
    }

    public URIRecord(Name name, int i, long j, int i2, int i3, String str) {
        super(name, 256, i, j);
        this.priority = Record.checkU16("priority", i2);
        this.weight = Record.checkU16("weight", i3);
        try {
            this.target = Record.byteArrayFromString(str);
        } catch (TextParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
