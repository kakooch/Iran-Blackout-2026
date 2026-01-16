package org.xbill.DNS;

import android.gov.nist.core.Separators;
import java.util.HashMap;
import java.util.Map;
import lombok.Generated;
import org.xbill.DNS.utils.base16;

/* loaded from: classes8.dex */
public class ZoneMDRecord extends Record {
    private byte[] digest;
    private int hashAlgorithm;
    private int scheme;
    private long serial;

    public static final class Hash {
        public static final int RESERVED = 0;
        public static final int SHA384 = 1;
        public static final int SHA512 = 2;
        private static final Map<Integer, Integer> hashLengths;
        private static final Mnemonic schemes;

        static {
            Mnemonic mnemonic = new Mnemonic("ZONEMD Hash Algorithms", 2);
            schemes = mnemonic;
            HashMap map = new HashMap(2);
            hashLengths = map;
            mnemonic.setMaximum(255);
            mnemonic.setNumericAllowed(true);
            mnemonic.add(0, "RESERVED");
            mnemonic.add(1, "SHA384");
            map.put(1, 48);
            mnemonic.add(2, "SHA512");
            map.put(2, 64);
        }

        @Generated
        private Hash() {
            throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
        }

        public static int hashLength(int i) {
            Integer num = hashLengths.get(Integer.valueOf(i));
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        public static String string(int i) {
            return schemes.getText(i);
        }

        public static int value(String str) {
            return schemes.getValue(str);
        }
    }

    public static final class Scheme {
        public static final int RESERVED = 0;
        public static final int SIMPLE = 1;
        private static final Mnemonic schemes;

        static {
            Mnemonic mnemonic = new Mnemonic("ZONEMD Schemes", 2);
            schemes = mnemonic;
            mnemonic.setMaximum(255);
            mnemonic.setNumericAllowed(true);
            mnemonic.add(0, "RESERVED");
            mnemonic.add(1, "SIMPLE");
        }

        @Generated
        private Scheme() {
            throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
        }

        public static String string(int i) {
            return schemes.getText(i);
        }

        public static int value(String str) {
            return schemes.getValue(str);
        }
    }

    ZoneMDRecord() {
    }

    private String getDigestSizeExceptionMessage(int i, byte[] bArr) {
        int iHashLength = Hash.hashLength(i);
        if (iHashLength == -1 || iHashLength == bArr.length) {
            if (bArr.length >= 12) {
                return null;
            }
            return "Digest size must be at least 12 bytes, got " + bArr.length;
        }
        return "Digest size for " + Hash.string(i) + " be exactly " + Hash.hashLength(i) + " bytes, got " + bArr.length;
    }

    @Generated
    public byte[] getDigest() {
        return this.digest;
    }

    @Generated
    public int getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    @Generated
    public int getScheme() {
        return this.scheme;
    }

    @Generated
    public long getSerial() {
        return this.serial;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException {
        this.serial = tokenizer.getUInt32();
        this.scheme = tokenizer.getUInt8();
        this.hashAlgorithm = tokenizer.getUInt8();
        byte[] hex = tokenizer.getHex(true);
        this.digest = hex;
        String digestSizeExceptionMessage = getDigestSizeExceptionMessage(this.hashAlgorithm, hex);
        if (digestSizeExceptionMessage != null) {
            throw tokenizer.exception(digestSizeExceptionMessage);
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws WireParseException {
        this.serial = dNSInput.readU32();
        this.scheme = dNSInput.readU8();
        this.hashAlgorithm = dNSInput.readU8();
        byte[] byteArray = dNSInput.readByteArray();
        this.digest = byteArray;
        String digestSizeExceptionMessage = getDigestSizeExceptionMessage(this.hashAlgorithm, byteArray);
        if (digestSizeExceptionMessage != null) {
            throw new WireParseException(digestSizeExceptionMessage);
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        String str = this.serial + Separators.SP + this.scheme + Separators.SP + this.hashAlgorithm + Separators.SP;
        if (!Options.multiline()) {
            return str + base16.toString(this.digest);
        }
        return str + Separators.LPAREN + base16.toString(this.digest, 48, Separators.HT, true);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU32(this.serial);
        dNSOutput.writeU8(this.scheme);
        dNSOutput.writeU8(this.hashAlgorithm);
        dNSOutput.writeByteArray(this.digest);
    }

    public ZoneMDRecord(Name name, int i, long j, long j2, int i2, int i3, byte[] bArr) {
        super(name, 63, i, j);
        this.serial = Record.checkU32("serial", j2);
        this.scheme = Record.checkU8("scheme", i2);
        this.hashAlgorithm = Record.checkU8("hashAlgorithm", i3);
        String digestSizeExceptionMessage = getDigestSizeExceptionMessage(i3, bArr);
        if (digestSizeExceptionMessage != null) {
            throw new IllegalArgumentException(digestSizeExceptionMessage);
        }
        this.digest = bArr;
    }
}
