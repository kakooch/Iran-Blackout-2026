package org.xbill.DNS;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ims.ParameterNamesIms;
import org.xbill.DNS.DNSSEC;
import org.xbill.DNS.utils.base16;

/* loaded from: classes8.dex */
public class DSRecord extends Record {

    @Deprecated
    public static final int GOST3411_DIGEST_ID = 3;

    @Deprecated
    public static final int SHA1_DIGEST_ID = 1;

    @Deprecated
    public static final int SHA256_DIGEST_ID = 2;

    @Deprecated
    public static final int SHA384_DIGEST_ID = 4;
    private int alg;
    private byte[] digest;
    private int digestid;
    private int footprint;

    @Deprecated
    public static class Digest {
        public static final int GOST3411 = 3;
        public static final int SHA1 = 1;
        public static final int SHA256 = 2;
        public static final int SHA384 = 4;

        private Digest() {
        }
    }

    DSRecord() {
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
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException {
        this.footprint = tokenizer.getUInt16();
        this.alg = tokenizer.getUInt8();
        this.digestid = tokenizer.getUInt8();
        this.digest = tokenizer.getHex(true);
        int iAlgLength = DNSSEC.Digest.algLength(this.digestid);
        if (iAlgLength <= -1 || iAlgLength == this.digest.length) {
            return;
        }
        throw tokenizer.exception("Expected " + iAlgLength + " bytes for " + DNSSEC.Digest.string(this.digestid) + ", got " + this.digest.length);
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

    protected DSRecord(Name name, int i, int i2, long j, int i3, int i4, int i5, byte[] bArr) {
        super(name, i, i2, j);
        int iAlgLength = DNSSEC.Digest.algLength(i5);
        if (iAlgLength <= -1 || iAlgLength == bArr.length) {
            this.footprint = Record.checkU16("footprint", i3);
            this.alg = Record.checkU8(ParameterNamesIms.ALG, i4);
            this.digestid = Record.checkU8("digestid", i5);
            this.digest = bArr;
            return;
        }
        throw new IllegalArgumentException("Expected " + iAlgLength + " bytes for " + DNSSEC.Digest.string(i5) + ", got " + bArr.length);
    }

    public DSRecord(Name name, int i, long j, int i2, int i3, int i4, byte[] bArr) {
        this(name, 43, i, j, i2, i3, i4, bArr);
    }

    public DSRecord(Name name, int i, long j, int i2, DNSKEYRecord dNSKEYRecord) {
        this(name, i, j, dNSKEYRecord.getFootprint(), dNSKEYRecord.getAlgorithm(), i2, DNSSEC.generateDSDigest(dNSKEYRecord, i2));
    }
}
