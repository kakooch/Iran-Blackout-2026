package org.xbill.DNS;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public class HINFORecord extends Record {
    private byte[] cpu;
    private byte[] os;

    HINFORecord() {
    }

    public String getCPU() {
        return Record.byteArrayToString(this.cpu, false);
    }

    public String getOS() {
        return Record.byteArrayToString(this.os, false);
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException {
        try {
            this.cpu = Record.byteArrayFromString(tokenizer.getString());
            this.os = Record.byteArrayFromString(tokenizer.getString());
        } catch (TextParseException e) {
            throw tokenizer.exception(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.cpu = dNSInput.readCountedString();
        this.os = dNSInput.readCountedString();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return Record.byteArrayToString(this.cpu, true) + Separators.SP + Record.byteArrayToString(this.os, true);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeCountedString(this.cpu);
        dNSOutput.writeCountedString(this.os);
    }

    public HINFORecord(Name name, int i, long j, String str, String str2) {
        super(name, 13, i, j);
        try {
            this.cpu = Record.byteArrayFromString(str);
            this.os = Record.byteArrayFromString(str2);
        } catch (TextParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
