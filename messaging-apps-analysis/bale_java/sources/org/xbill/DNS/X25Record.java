package org.xbill.DNS;

/* loaded from: classes8.dex */
public class X25Record extends Record {
    private byte[] address;

    X25Record() {
    }

    private static byte[] checkAndConvertAddress(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isDigit(cCharAt)) {
                return null;
            }
            bArr[i] = (byte) cCharAt;
        }
        return bArr;
    }

    public String getAddress() {
        return Record.byteArrayToString(this.address, false);
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException {
        String string = tokenizer.getString();
        byte[] bArrCheckAndConvertAddress = checkAndConvertAddress(string);
        this.address = bArrCheckAndConvertAddress;
        if (bArrCheckAndConvertAddress != null) {
            return;
        }
        throw tokenizer.exception("invalid PSDN address " + string);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.address = dNSInput.readCountedString();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return Record.byteArrayToString(this.address, true);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeCountedString(this.address);
    }

    public X25Record(Name name, int i, long j, String str) {
        super(name, 19, i, j);
        byte[] bArrCheckAndConvertAddress = checkAndConvertAddress(str);
        this.address = bArrCheckAndConvertAddress;
        if (bArrCheckAndConvertAddress != null) {
            return;
        }
        throw new IllegalArgumentException("invalid PSDN address " + str);
    }
}
