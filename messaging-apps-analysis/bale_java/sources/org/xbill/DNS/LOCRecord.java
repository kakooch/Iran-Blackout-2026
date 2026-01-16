package org.xbill.DNS;

import android.gov.nist.core.Separators;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.xbill.DNS.Tokenizer;

/* loaded from: classes8.dex */
public class LOCRecord extends Record {
    private static final NumberFormat w2;
    private static final NumberFormat w3;
    private long altitude;
    private long hPrecision;
    private long latitude;
    private long longitude;
    private long size;
    private long vPrecision;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        w2 = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(2);
        DecimalFormat decimalFormat2 = new DecimalFormat();
        w3 = decimalFormat2;
        decimalFormat2.setMinimumIntegerDigits(3);
    }

    LOCRecord() {
    }

    private long parseDouble(Tokenizer tokenizer, String str, boolean z, long j, long j2, long j3) throws TextParseException {
        Tokenizer.Token token = tokenizer.get();
        if (token.isEOL()) {
            if (!z) {
                tokenizer.unget();
                return j3;
            }
            throw tokenizer.exception("Invalid LOC " + str);
        }
        String strValue = token.value();
        if (strValue.length() > 1 && strValue.charAt(strValue.length() - 1) == 'm') {
            strValue = strValue.substring(0, strValue.length() - 1);
        }
        try {
            long fixedPoint = (long) (parseFixedPoint(strValue) * 100.0d);
            if (fixedPoint >= j && fixedPoint <= j2) {
                return fixedPoint;
            }
            throw tokenizer.exception("Invalid LOC " + str);
        } catch (NumberFormatException unused) {
            throw tokenizer.exception("Invalid LOC " + str);
        }
    }

    private double parseFixedPoint(String str) {
        if (str.matches("^-?\\d+$")) {
            return Integer.parseInt(str);
        }
        if (!str.matches("^-?\\d+\\.\\d*$")) {
            throw new NumberFormatException();
        }
        String[] strArrSplit = str.split("\\.");
        double d = Integer.parseInt(strArrSplit[0]);
        double d2 = Integer.parseInt(strArrSplit[1]);
        if (d < 0.0d) {
            d2 *= -1.0d;
        }
        return d + (d2 / Math.pow(10.0d, strArrSplit[1].length()));
    }

    private static long parseLOCformat(int i) throws WireParseException {
        long j = i >> 4;
        int i2 = i & 15;
        if (j > 9 || i2 > 9) {
            throw new WireParseException("Invalid LOC Encoding");
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return j;
            }
            j *= 10;
            i2 = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long parsePosition(org.xbill.DNS.Tokenizer r18, java.lang.String r19) throws org.xbill.DNS.TextParseException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.LOCRecord.parsePosition(org.xbill.DNS.Tokenizer, java.lang.String):long");
    }

    private String positionToString(long j, char c, char c2) {
        StringBuilder sb = new StringBuilder();
        long j2 = j - 2147483648L;
        if (j2 < 0) {
            j2 = -j2;
            c = c2;
        }
        sb.append(j2 / 3600000);
        long j3 = j2 % 3600000;
        sb.append(Separators.SP);
        sb.append(j3 / 60000);
        sb.append(Separators.SP);
        renderFixedPoint(sb, w3, j3 % 60000, 1000L);
        sb.append(Separators.SP);
        sb.append(c);
        return sb.toString();
    }

    private void renderFixedPoint(StringBuilder sb, NumberFormat numberFormat, long j, long j2) {
        sb.append(j / j2);
        long j3 = j % j2;
        if (j3 != 0) {
            sb.append(Separators.DOT);
            sb.append(numberFormat.format(j3));
        }
    }

    private int toLOCformat(long j) {
        byte b = 0;
        while (j > 9) {
            b = (byte) (b + 1);
            j /= 10;
        }
        return (int) ((j << 4) + (b & 255));
    }

    public double getAltitude() {
        return (this.altitude - 10000000) / 100.0d;
    }

    public double getHPrecision() {
        return this.hPrecision / 100.0d;
    }

    public double getLatitude() {
        return (this.latitude - 2147483648L) / 3600000.0d;
    }

    public double getLongitude() {
        return (this.longitude - 2147483648L) / 3600000.0d;
    }

    public double getSize() {
        return this.size / 100.0d;
    }

    public double getVPrecision() {
        return this.vPrecision / 100.0d;
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) {
        this.latitude = parsePosition(tokenizer, "latitude");
        this.longitude = parsePosition(tokenizer, "longitude");
        this.altitude = parseDouble(tokenizer, "altitude", true, -10000000L, 4284967295L, 0L) + 10000000;
        this.size = parseDouble(tokenizer, "size", false, 0L, 9000000000L, 100L);
        this.hPrecision = parseDouble(tokenizer, "horizontal precision", false, 0L, 9000000000L, 1000000L);
        this.vPrecision = parseDouble(tokenizer, "vertical precision", false, 0L, 9000000000L, 1000L);
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws WireParseException {
        if (dNSInput.readU8() != 0) {
            throw new WireParseException("Invalid LOC version");
        }
        this.size = parseLOCformat(dNSInput.readU8());
        this.hPrecision = parseLOCformat(dNSInput.readU8());
        this.vPrecision = parseLOCformat(dNSInput.readU8());
        this.latitude = dNSInput.readU32();
        this.longitude = dNSInput.readU32();
        this.altitude = dNSInput.readU32();
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(positionToString(this.latitude, 'N', 'S'));
        sb.append(Separators.SP);
        sb.append(positionToString(this.longitude, 'E', 'W'));
        sb.append(Separators.SP);
        NumberFormat numberFormat = w2;
        renderFixedPoint(sb, numberFormat, this.altitude - 10000000, 100L);
        sb.append("m ");
        renderFixedPoint(sb, numberFormat, this.size, 100L);
        sb.append("m ");
        renderFixedPoint(sb, numberFormat, this.hPrecision, 100L);
        sb.append("m ");
        renderFixedPoint(sb, numberFormat, this.vPrecision, 100L);
        sb.append("m");
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU8(0);
        dNSOutput.writeU8(toLOCformat(this.size));
        dNSOutput.writeU8(toLOCformat(this.hPrecision));
        dNSOutput.writeU8(toLOCformat(this.vPrecision));
        dNSOutput.writeU32(this.latitude);
        dNSOutput.writeU32(this.longitude);
        dNSOutput.writeU32(this.altitude);
    }

    public LOCRecord(Name name, int i, long j, double d, double d2, double d3, double d4, double d5, double d6) {
        super(name, 29, i, j);
        this.latitude = (long) ((d * 3600.0d * 1000.0d) + 2.147483648E9d);
        this.longitude = (long) ((3600.0d * d2 * 1000.0d) + 2.147483648E9d);
        this.altitude = (long) ((d3 + 100000.0d) * 100.0d);
        this.size = (long) (d4 * 100.0d);
        this.hPrecision = (long) (d5 * 100.0d);
        this.vPrecision = (long) (d6 * 100.0d);
    }
}
