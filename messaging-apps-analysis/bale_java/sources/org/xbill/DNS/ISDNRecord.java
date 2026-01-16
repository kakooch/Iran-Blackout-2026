package org.xbill.DNS;

import android.gov.nist.core.Separators;
import org.xbill.DNS.Tokenizer;

/* loaded from: classes8.dex */
public class ISDNRecord extends Record {
    private byte[] address;
    private byte[] subAddress;

    ISDNRecord() {
    }

    public String getAddress() {
        return Record.byteArrayToString(this.address, false);
    }

    public String getSubAddress() {
        byte[] bArr = this.subAddress;
        if (bArr == null) {
            return null;
        }
        return Record.byteArrayToString(bArr, false);
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException {
        try {
            this.address = Record.byteArrayFromString(tokenizer.getString());
            Tokenizer.Token token = tokenizer.get();
            if (token.isString()) {
                this.subAddress = Record.byteArrayFromString(token.value());
            } else {
                tokenizer.unget();
            }
        } catch (TextParseException e) {
            throw tokenizer.exception(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.address = dNSInput.readCountedString();
        if (dNSInput.remaining() > 0) {
            this.subAddress = dNSInput.readCountedString();
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Record.byteArrayToString(this.address, true));
        if (this.subAddress != null) {
            sb.append(Separators.SP);
            sb.append(Record.byteArrayToString(this.subAddress, true));
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeCountedString(this.address);
        byte[] bArr = this.subAddress;
        if (bArr != null) {
            dNSOutput.writeCountedString(bArr);
        }
    }

    public ISDNRecord(Name name, int i, long j, String str, String str2) {
        super(name, 20, i, j);
        try {
            this.address = Record.byteArrayFromString(str);
            if (str2 != null) {
                this.subAddress = Record.byteArrayFromString(str2);
            }
        } catch (TextParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
