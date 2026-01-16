package org.xbill.DNS;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public class PXRecord extends Record {
    private Name map822;
    private Name mapX400;
    private int preference;

    PXRecord() {
    }

    public Name getMap822() {
        return this.map822;
    }

    public Name getMapX400() {
        return this.mapX400;
    }

    public int getPreference() {
        return this.preference;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) {
        this.preference = tokenizer.getUInt16();
        this.map822 = tokenizer.getName(name);
        this.mapX400 = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.preference = dNSInput.readU16();
        this.map822 = new Name(dNSInput);
        this.mapX400 = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.preference + Separators.SP + this.map822 + Separators.SP + this.mapX400;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.preference);
        this.map822.toWire(dNSOutput, null, z);
        this.mapX400.toWire(dNSOutput, null, z);
    }

    public PXRecord(Name name, int i, long j, int i2, Name name2, Name name3) {
        super(name, 26, i, j);
        this.preference = Record.checkU16("preference", i2);
        this.map822 = Record.checkName("map822", name2);
        this.mapX400 = Record.checkName("mapX400", name3);
    }
}
