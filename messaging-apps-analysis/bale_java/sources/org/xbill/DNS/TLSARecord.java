package org.xbill.DNS;

import android.gov.nist.core.Separators;
import org.xbill.DNS.utils.base16;

/* loaded from: classes8.dex */
public class TLSARecord extends Record {
    private byte[] certificateAssociationData;
    private int certificateUsage;
    private int matchingType;
    private int selector;

    public static class CertificateUsage {
        public static final int CA_CONSTRAINT = 0;
        public static final int DOMAIN_ISSUED_CERTIFICATE = 3;
        public static final int SERVICE_CERTIFICATE_CONSTRAINT = 1;
        public static final int TRUST_ANCHOR_ASSERTION = 2;

        private CertificateUsage() {
        }
    }

    public static class MatchingType {
        public static final int EXACT = 0;
        public static final int SHA256 = 1;
        public static final int SHA512 = 2;

        private MatchingType() {
        }
    }

    public static class Selector {
        public static final int FULL_CERTIFICATE = 0;
        public static final int SUBJECT_PUBLIC_KEY_INFO = 1;

        private Selector() {
        }
    }

    TLSARecord() {
    }

    public final byte[] getCertificateAssociationData() {
        return this.certificateAssociationData;
    }

    public int getCertificateUsage() {
        return this.certificateUsage;
    }

    public int getMatchingType() {
        return this.matchingType;
    }

    public int getSelector() {
        return this.selector;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) {
        this.certificateUsage = tokenizer.getUInt8();
        this.selector = tokenizer.getUInt8();
        this.matchingType = tokenizer.getUInt8();
        this.certificateAssociationData = tokenizer.getHex(true);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws WireParseException {
        this.certificateUsage = dNSInput.readU8();
        this.selector = dNSInput.readU8();
        this.matchingType = dNSInput.readU8();
        byte[] byteArray = dNSInput.readByteArray();
        this.certificateAssociationData = byteArray;
        if (byteArray.length == 0) {
            throw new WireParseException("end of input");
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return this.certificateUsage + Separators.SP + this.selector + Separators.SP + this.matchingType + Separators.SP + base16.toString(this.certificateAssociationData);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU8(this.certificateUsage);
        dNSOutput.writeU8(this.selector);
        dNSOutput.writeU8(this.matchingType);
        dNSOutput.writeByteArray(this.certificateAssociationData);
    }

    protected TLSARecord(Name name, int i, int i2, long j, int i3, int i4, int i5, byte[] bArr) {
        super(name, i, i2, j);
        this.certificateUsage = Record.checkU8("certificateUsage", i3);
        this.selector = Record.checkU8("selector", i4);
        this.matchingType = Record.checkU8("matchingType", i5);
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("certificateAssociationData must not be null or empty");
        }
        this.certificateAssociationData = Record.checkByteArrayLength("certificateAssociationData", bArr, 65535);
    }

    public TLSARecord(Name name, int i, long j, int i2, int i3, int i4, byte[] bArr) {
        this(name, 52, i, j, i2, i3, i4, bArr);
    }
}
