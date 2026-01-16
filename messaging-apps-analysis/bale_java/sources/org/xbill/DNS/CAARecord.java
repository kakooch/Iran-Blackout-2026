package org.xbill.DNS;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public class CAARecord extends Record {
    private int flags;
    private byte[] tag;
    private byte[] value;

    public static class Flags {
        public static final int IssuerCritical = 128;

        private Flags() {
        }
    }

    CAARecord() {
    }

    public int getFlags() {
        return this.flags;
    }

    public String getTag() {
        return Record.byteArrayToString(this.tag, false);
    }

    public String getValue() {
        return Record.byteArrayToString(this.value, false);
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException {
        this.flags = tokenizer.getUInt8();
        try {
            this.tag = Record.byteArrayFromString(tokenizer.getString());
            this.value = Record.byteArrayFromString(tokenizer.getString());
        } catch (TextParseException e) {
            throw tokenizer.exception(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.flags = dNSInput.readU8();
        this.tag = dNSInput.readCountedString();
        this.value = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.flags + Separators.SP + Record.byteArrayToString(this.tag, false) + Separators.SP + Record.byteArrayToString(this.value, true);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU8(this.flags);
        dNSOutput.writeCountedString(this.tag);
        dNSOutput.writeByteArray(this.value);
    }

    public CAARecord(Name name, int i, long j, int i2, String str, String str2) {
        super(name, Type.CAA, i, j);
        this.flags = Record.checkU8("flags", i2);
        try {
            this.tag = Record.byteArrayFromString(str);
            this.value = Record.byteArrayFromString(str2);
        } catch (TextParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
