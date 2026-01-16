package org.xbill.DNS;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ims.ParameterNamesIms;
import java.security.PublicKey;
import org.xbill.DNS.utils.base64;

/* loaded from: classes8.dex */
abstract class KEYBase extends Record {
    protected int alg;
    protected int flags;
    protected int footprint;
    protected byte[] key;
    protected int proto;
    protected PublicKey publicKey;

    protected KEYBase() {
        this.footprint = -1;
        this.publicKey = null;
    }

    public int getAlgorithm() {
        return this.alg;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getFootprint() {
        int i;
        int i2;
        int i3 = this.footprint;
        if (i3 >= 0) {
            return i3;
        }
        DNSOutput dNSOutput = new DNSOutput();
        int i4 = 0;
        rrToWire(dNSOutput, null, false);
        byte[] byteArray = dNSOutput.toByteArray();
        if (this.alg == 1) {
            int i5 = byteArray[byteArray.length - 3] & 255;
            i2 = byteArray[byteArray.length - 2] & 255;
            i = i5 << 8;
        } else {
            i = 0;
            while (i4 < byteArray.length - 1) {
                i += ((byteArray[i4] & 255) << 8) + (byteArray[i4 + 1] & 255);
                i4 += 2;
            }
            if (i4 < byteArray.length) {
                i += (byteArray[i4] & 255) << 8;
            }
            i2 = (i >> 16) & 65535;
        }
        int i6 = (i + i2) & 65535;
        this.footprint = i6;
        return i6;
    }

    public byte[] getKey() {
        return this.key;
    }

    public int getProtocol() {
        return this.proto;
    }

    public PublicKey getPublicKey() {
        PublicKey publicKey = this.publicKey;
        if (publicKey != null) {
            return publicKey;
        }
        PublicKey publicKey2 = DNSSEC.toPublicKey(this);
        this.publicKey = publicKey2;
        return publicKey2;
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) {
        this.flags = dNSInput.readU16();
        this.proto = dNSInput.readU8();
        this.alg = dNSInput.readU8();
        if (dNSInput.remaining() > 0) {
            this.key = dNSInput.readByteArray();
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.flags);
        sb.append(Separators.SP);
        sb.append(this.proto);
        sb.append(Separators.SP);
        sb.append(this.alg);
        if (this.key != null) {
            if (Options.multiline()) {
                sb.append(" (\n");
                sb.append(base64.formatString(this.key, 64, Separators.HT, true));
                sb.append(" ; key_tag = ");
                sb.append(getFootprint());
            } else {
                sb.append(Separators.SP);
                sb.append(base64.toString(this.key));
            }
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.flags);
        dNSOutput.writeU8(this.proto);
        dNSOutput.writeU8(this.alg);
        byte[] bArr = this.key;
        if (bArr != null) {
            dNSOutput.writeByteArray(bArr);
        }
    }

    protected KEYBase(Name name, int i, int i2, long j, int i3, int i4, int i5, byte[] bArr) {
        super(name, i, i2, j);
        this.footprint = -1;
        this.publicKey = null;
        this.flags = Record.checkU16("flags", i3);
        this.proto = Record.checkU8("proto", i4);
        this.alg = Record.checkU8(ParameterNamesIms.ALG, i5);
        this.key = bArr;
    }
}
