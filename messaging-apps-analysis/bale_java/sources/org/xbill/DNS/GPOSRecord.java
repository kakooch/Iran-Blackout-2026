package org.xbill.DNS;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public class GPOSRecord extends Record {
    private byte[] altitude;
    private byte[] latitude;
    private byte[] longitude;

    GPOSRecord() {
    }

    private void validate(double d, double d2) {
        if (d < -90.0d || d > 90.0d) {
            throw new IllegalArgumentException("illegal longitude " + d);
        }
        if (d2 < -180.0d || d2 > 180.0d) {
            throw new IllegalArgumentException("illegal latitude " + d2);
        }
    }

    public double getAltitude() {
        return Double.parseDouble(getAltitudeString());
    }

    public String getAltitudeString() {
        return Record.byteArrayToString(this.altitude, false);
    }

    public double getLatitude() {
        return Double.parseDouble(getLatitudeString());
    }

    public String getLatitudeString() {
        return Record.byteArrayToString(this.latitude, false);
    }

    public double getLongitude() {
        return Double.parseDouble(getLongitudeString());
    }

    public String getLongitudeString() {
        return Record.byteArrayToString(this.longitude, false);
    }

    @Override // org.xbill.DNS.Record
    protected void rdataFromString(Tokenizer tokenizer, Name name) throws TextParseException, WireParseException {
        try {
            this.longitude = Record.byteArrayFromString(tokenizer.getString());
            this.latitude = Record.byteArrayFromString(tokenizer.getString());
            this.altitude = Record.byteArrayFromString(tokenizer.getString());
            try {
                validate(getLongitude(), getLatitude());
            } catch (IllegalArgumentException e) {
                throw new WireParseException(e.getMessage());
            }
        } catch (TextParseException e2) {
            throw tokenizer.exception(e2.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected void rrFromWire(DNSInput dNSInput) throws WireParseException {
        this.longitude = dNSInput.readCountedString();
        this.latitude = dNSInput.readCountedString();
        this.altitude = dNSInput.readCountedString();
        try {
            validate(getLongitude(), getLatitude());
        } catch (IllegalArgumentException e) {
            throw new WireParseException(e.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    protected String rrToString() {
        return Record.byteArrayToString(this.longitude, true) + Separators.SP + Record.byteArrayToString(this.latitude, true) + Separators.SP + Record.byteArrayToString(this.altitude, true);
    }

    @Override // org.xbill.DNS.Record
    protected void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeCountedString(this.longitude);
        dNSOutput.writeCountedString(this.latitude);
        dNSOutput.writeCountedString(this.altitude);
    }

    public GPOSRecord(Name name, int i, long j, double d, double d2, double d3) {
        super(name, 27, i, j);
        validate(d, d2);
        this.longitude = Double.toString(d).getBytes();
        this.latitude = Double.toString(d2).getBytes();
        this.altitude = Double.toString(d3).getBytes();
    }

    public GPOSRecord(Name name, int i, long j, String str, String str2, String str3) {
        super(name, 27, i, j);
        try {
            this.longitude = Record.byteArrayFromString(str);
            this.latitude = Record.byteArrayFromString(str2);
            validate(getLongitude(), getLatitude());
            this.altitude = Record.byteArrayFromString(str3);
        } catch (TextParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
