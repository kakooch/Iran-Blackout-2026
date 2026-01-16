package org.xbill.DNS;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public class SRVRecord extends Record {
    private int port;
    private int priority;
    private Name target;
    private int weight;

    SRVRecord() {
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return this.target;
    }

    public int getPort() {
        return this.port;
    }

    public int getPriority() {
        return this.priority;
    }

    public Name getTarget() {
        return this.target;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) {
        this.priority = tokenizer.getUInt16();
        this.weight = tokenizer.getUInt16();
        this.port = tokenizer.getUInt16();
        this.target = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.priority = dNSInput.readU16();
        this.weight = dNSInput.readU16();
        this.port = dNSInput.readU16();
        this.target = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.priority + Separators.SP + this.weight + Separators.SP + this.port + Separators.SP + this.target;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.priority);
        dNSOutput.writeU16(this.weight);
        dNSOutput.writeU16(this.port);
        this.target.toWire(dNSOutput, null, z);
    }

    public SRVRecord(Name name, int i, long j, int i2, int i3, int i4, Name name2) {
        super(name, 33, i, j);
        this.priority = Record.checkU16("priority", i2);
        this.weight = Record.checkU16("weight", i3);
        this.port = Record.checkU16("port", i4);
        this.target = Record.checkName("target", name2);
    }
}
