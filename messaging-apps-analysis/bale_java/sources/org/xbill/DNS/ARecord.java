package org.xbill.DNS;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: classes8.dex */
public class ARecord extends Record {
    private int addr;

    ARecord() {
    }

    private static int fromArray(byte[] bArr) {
        return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }

    private static byte[] toArray(int i) {
        return new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)};
    }

    public InetAddress getAddress() {
        try {
            Name name = this.name;
            return name == null ? InetAddress.getByAddress(toArray(this.addr)) : InetAddress.getByAddress(name.toString(), toArray(this.addr));
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) {
        this.addr = fromArray(tokenizer.getAddressBytes(1));
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.addr = fromArray(dNSInput.readByteArray(4));
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return Address.toDottedQuad(toArray(this.addr));
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU32(this.addr & 4294967295L);
    }

    public ARecord(Name name, int i, long j, InetAddress inetAddress) {
        super(name, 1, i, j);
        if (Address.familyOf(inetAddress) != 1) {
            throw new IllegalArgumentException("invalid IPv4 address");
        }
        this.addr = fromArray(inetAddress.getAddress());
    }

    public ARecord(Name name, int i, long j, byte[] bArr) {
        super(name, 1, i, j);
        if (bArr != null && bArr.length == 4) {
            this.addr = fromArray(bArr);
            return;
        }
        throw new IllegalArgumentException("invalid IPv4 address");
    }
}
