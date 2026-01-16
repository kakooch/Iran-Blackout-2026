package org.xbill.DNS;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public class MINFORecord extends Record {
    private Name errorAddress;
    private Name responsibleAddress;

    MINFORecord() {
    }

    public Name getErrorAddress() {
        return this.errorAddress;
    }

    public Name getResponsibleAddress() {
        return this.responsibleAddress;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) {
        this.responsibleAddress = tokenizer.getName(name);
        this.errorAddress = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.responsibleAddress = new Name(dNSInput);
        this.errorAddress = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.responsibleAddress + Separators.SP + this.errorAddress;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.responsibleAddress.toWire(dNSOutput, null, z);
        this.errorAddress.toWire(dNSOutput, null, z);
    }

    public MINFORecord(Name name, int i, long j, Name name2, Name name3) {
        super(name, 14, i, j);
        this.responsibleAddress = Record.checkName("responsibleAddress", name2);
        this.errorAddress = Record.checkName("errorAddress", name3);
    }
}
