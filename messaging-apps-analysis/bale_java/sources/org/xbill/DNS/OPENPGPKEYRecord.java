package org.xbill.DNS;

import android.gov.nist.core.Separators;
import org.xbill.DNS.utils.base64;

/* loaded from: classes8.dex */
public class OPENPGPKEYRecord extends Record {
    private byte[] cert;

    OPENPGPKEYRecord() {
    }

    public byte[] getCert() {
        return this.cert;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) {
        this.cert = tokenizer.getBase64();
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.cert = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        if (this.cert != null) {
            if (Options.multiline()) {
                sb.append("(\n");
                sb.append(base64.formatString(this.cert, 64, Separators.HT, true));
            } else {
                sb.append(base64.toString(this.cert));
            }
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeByteArray(this.cert);
    }

    public OPENPGPKEYRecord(Name name, int i, long j, byte[] bArr) {
        super(name, 61, i, j);
        this.cert = bArr;
    }
}
