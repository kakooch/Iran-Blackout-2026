package org.xbill.DNS;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public class RPRecord extends Record {
    private Name mailbox;
    private Name textDomain;

    RPRecord() {
    }

    public Name getMailbox() {
        return this.mailbox;
    }

    public Name getTextDomain() {
        return this.textDomain;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) {
        this.mailbox = tokenizer.getName(name);
        this.textDomain = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.mailbox = new Name(dNSInput);
        this.textDomain = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.mailbox + Separators.SP + this.textDomain;
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.mailbox.toWire(dNSOutput, null, z);
        this.textDomain.toWire(dNSOutput, null, z);
    }

    public RPRecord(Name name, int i, long j, Name name2, Name name3) {
        super(name, 17, i, j);
        this.mailbox = Record.checkName("mailbox", name2);
        this.textDomain = Record.checkName("textDomain", name3);
    }
}
