package org.xbill.DNS;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ims.ParameterNamesIms;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import org.xbill.DNS.utils.base64;

/* loaded from: classes8.dex */
public class TSIGRecord extends Record {
    private Name alg;
    private int error;
    private Duration fudge;
    private int originalID;
    private byte[] other;
    private byte[] signature;
    private Instant timeSigned;

    TSIGRecord() {
    }

    public Name getAlgorithm() {
        return this.alg;
    }

    public int getError() {
        return this.error;
    }

    public Duration getFudge() {
        return this.fudge;
    }

    public int getOriginalID() {
        return this.originalID;
    }

    public byte[] getOther() {
        return this.other;
    }

    public byte[] getSignature() {
        return this.signature;
    }

    public Instant getTimeSigned() {
        return this.timeSigned;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException {
        throw tokenizer.exception("no text format defined for TSIG");
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws WireParseException {
        this.alg = new Name(dNSInput);
        this.timeSigned = Instant.ofEpochSecond((dNSInput.readU16() << 32) + dNSInput.readU32());
        this.fudge = Duration.ofSeconds(dNSInput.readU16());
        this.signature = dNSInput.readByteArray(dNSInput.readU16());
        this.originalID = dNSInput.readU16();
        this.error = dNSInput.readU16();
        int u16 = dNSInput.readU16();
        if (u16 > 0) {
            this.other = dNSInput.readByteArray(u16);
        } else {
            this.other = null;
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.alg);
        sb.append(Separators.SP);
        if (Options.multiline()) {
            sb.append("(\n\t");
        }
        sb.append(this.timeSigned.getEpochSecond());
        sb.append(Separators.SP);
        sb.append((int) this.fudge.getSeconds());
        sb.append(Separators.SP);
        sb.append(this.signature.length);
        if (Options.multiline()) {
            sb.append(Separators.RETURN);
            sb.append(base64.formatString(this.signature, 64, Separators.HT, false));
        } else {
            sb.append(Separators.SP);
            sb.append(base64.toString(this.signature));
        }
        sb.append(Separators.SP);
        sb.append(Rcode.TSIGstring(this.error));
        sb.append(Separators.SP);
        byte[] bArr = this.other;
        if (bArr == null) {
            sb.append(0);
        } else {
            sb.append(bArr.length);
            if (Options.multiline()) {
                sb.append("\n\n\n\t");
            } else {
                sb.append(Separators.SP);
            }
            if (this.error == 18) {
                if (this.other.length != 6) {
                    sb.append("<invalid BADTIME other data>");
                } else {
                    sb.append("<server time: ");
                    sb.append(Instant.ofEpochSecond(((r1[0] & 255) << 40) + ((r1[1] & 255) << 32) + ((r1[2] & 255) << 24) + ((r1[3] & 255) << 16) + ((r1[4] & 255) << 8) + (r1[5] & 255)));
                    sb.append(Separators.GREATER_THAN);
                }
            } else {
                sb.append(Separators.LESS_THAN);
                sb.append(base64.toString(this.other));
                sb.append(Separators.GREATER_THAN);
            }
        }
        if (Options.multiline()) {
            sb.append(" )");
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.alg.toWire(dNSOutput, null, z);
        long epochSecond = this.timeSigned.getEpochSecond();
        dNSOutput.writeU16((int) (epochSecond >> 32));
        dNSOutput.writeU32(epochSecond & 4294967295L);
        dNSOutput.writeU16((int) this.fudge.getSeconds());
        dNSOutput.writeU16(this.signature.length);
        dNSOutput.writeByteArray(this.signature);
        dNSOutput.writeU16(this.originalID);
        dNSOutput.writeU16(this.error);
        byte[] bArr = this.other;
        if (bArr == null) {
            dNSOutput.writeU16(0);
        } else {
            dNSOutput.writeU16(bArr.length);
            dNSOutput.writeByteArray(this.other);
        }
    }

    @Deprecated
    public TSIGRecord(Name name, int i, long j, Name name2, Date date, int i2, byte[] bArr, int i3, int i4, byte[] bArr2) {
        this(name, i, j, name2, date.toInstant(), Duration.ofSeconds(i2), bArr, i3, i4, bArr2);
    }

    public TSIGRecord(Name name, int i, long j, Name name2, Instant instant, Duration duration, byte[] bArr, int i2, int i3, byte[] bArr2) {
        super(name, Type.TSIG, i, j);
        this.alg = Record.checkName(ParameterNamesIms.ALG, name2);
        this.timeSigned = instant;
        Record.checkU16("fudge", (int) duration.getSeconds());
        this.fudge = duration;
        this.signature = bArr;
        this.originalID = Record.checkU16("originalID", i2);
        this.error = Record.checkU16("error", i3);
        this.other = bArr2;
    }
}
