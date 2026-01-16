package org.xbill.DNS;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ims.ParameterNamesIms;
import org.xbill.DNS.utils.base16;

/* loaded from: classes8.dex */
public class DLVRecord extends Record {

    @Deprecated
    public static final int SHA1_DIGEST_ID = 1;

    @Deprecated
    public static final int SHA256_DIGEST_ID = 2;
    private int alg;
    private byte[] digest;
    private int digestid;
    private int footprint;

    DLVRecord() {
    }

    public int getAlgorithm() {
        return this.alg;
    }

    public byte[] getDigest() {
        return this.digest;
    }

    public int getDigestID() {
        return this.digestid;
    }

    public int getFootprint() {
        return this.footprint;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) {
        this.footprint = tokenizer.getUInt16();
        this.alg = tokenizer.getUInt8();
        this.digestid = tokenizer.getUInt8();
        this.digest = tokenizer.getHex(true);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.footprint = dNSInput.readU16();
        this.alg = dNSInput.readU8();
        this.digestid = dNSInput.readU8();
        this.digest = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.footprint);
        sb.append(Separators.SP);
        sb.append(this.alg);
        sb.append(Separators.SP);
        sb.append(this.digestid);
        if (this.digest != null) {
            sb.append(Separators.SP);
            sb.append(base16.toString(this.digest));
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.footprint);
        dNSOutput.writeU8(this.alg);
        dNSOutput.writeU8(this.digestid);
        byte[] bArr = this.digest;
        if (bArr != null) {
            dNSOutput.writeByteArray(bArr);
        }
    }

    public DLVRecord(Name name, int i, long j, int i2, int i3, int i4, byte[] bArr) {
        super(name, Type.DLV, i, j);
        this.footprint = Record.checkU16("footprint", i2);
        this.alg = Record.checkU8(ParameterNamesIms.ALG, i3);
        this.digestid = Record.checkU8("digestid", i4);
        this.digest = bArr;
    }
}
