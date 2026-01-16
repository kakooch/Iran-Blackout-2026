package org.xbill.DNS;

import android.gov.nist.core.Separators;
import ir.nasim.OI3;
import ir.nasim.RI3;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.function.Supplier;
import lombok.Generated;
import org.xbill.DNS.Tokenizer;
import org.xbill.DNS.utils.base16;

/* loaded from: classes8.dex */
public abstract class Record implements Cloneable, Comparable<Record>, Serializable {
    private static final DecimalFormat byteFormat;

    @Generated
    private static final OI3 log = RI3.i(Record.class);
    protected int dclass;
    protected Name name;
    protected long ttl;
    protected int type;

    private static class RecordSerializationProxy implements Serializable {
        private static final long serialVersionUID = 1434159920070152561L;
        private final boolean isEmpty;
        private final byte[] wireData;

        RecordSerializationProxy(Record record) {
            boolean z = record instanceof EmptyRecord;
            this.isEmpty = z;
            this.wireData = record.toWire(!z ? 1 : 0);
        }

        protected Object readResolve() throws InvalidObjectException {
            try {
                return Record.fromWire(this.wireData, !this.isEmpty ? 1 : 0);
            } catch (IOException e) {
                throw new InvalidObjectException(e.getMessage());
            }
        }
    }

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        byteFormat = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    protected Record() {
    }

    protected static byte[] byteArrayFromString(String str) throws TextParseException {
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            if (b == 92) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i = 0;
                boolean z = false;
                int i2 = 0;
                for (byte b2 : bytes) {
                    if (z) {
                        if (b2 >= 48 && b2 <= 57) {
                            i++;
                            i2 = (i2 * 10) + (b2 - 48);
                            if (i2 > 255) {
                                throw new TextParseException("bad escape");
                            }
                            if (i >= 3) {
                                b2 = (byte) i2;
                            }
                        } else if (i > 0) {
                            throw new TextParseException("bad escape");
                        }
                        byteArrayOutputStream.write(b2);
                        z = false;
                    } else if (b2 == 92) {
                        z = true;
                        i = 0;
                        i2 = 0;
                    } else {
                        byteArrayOutputStream.write(b2);
                    }
                }
                if (i > 0 && i < 3) {
                    throw new TextParseException("bad escape");
                }
                if (byteArrayOutputStream.toByteArray().length <= 255) {
                    return byteArrayOutputStream.toByteArray();
                }
                throw new TextParseException("text string too long");
            }
        }
        if (bytes.length <= 255) {
            return bytes;
        }
        throw new TextParseException("text string too long");
    }

    protected static String byteArrayToString(byte[] bArr, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append('\"');
        }
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 32 || i >= 127) {
                sb.append('\\');
                sb.append(byteFormat.format(i));
            } else if (i == 34 || i == 92) {
                sb.append('\\');
                sb.append((char) i);
            } else {
                sb.append((char) i);
            }
        }
        if (z) {
            sb.append('\"');
        }
        return sb.toString();
    }

    static byte[] checkByteArrayLength(String str, byte[] bArr, int i) {
        if (bArr.length <= 65535) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        throw new IllegalArgumentException(Separators.DOUBLE_QUOTE + str + "\" array must have no more than " + i + " elements");
    }

    static Name checkName(String str, Name name) {
        if (name.isAbsolute()) {
            return name;
        }
        throw new RelativeNameException(Separators.QUOTE + name + "' on field " + str + " is not an absolute name");
    }

    static int checkU16(String str, int i) {
        if (Utils.isUInt16(i)) {
            return i;
        }
        throw new IllegalArgumentException(Separators.DOUBLE_QUOTE + str + "\" " + i + " must be an unsigned 16 bit value");
    }

    static long checkU32(String str, long j) {
        if (Utils.isUInt32(j)) {
            return j;
        }
        throw new IllegalArgumentException(Separators.DOUBLE_QUOTE + str + "\" " + j + " must be an unsigned 32 bit value");
    }

    static int checkU8(String str, int i) {
        if (Utils.isUInt8(i)) {
            return i;
        }
        throw new IllegalArgumentException(Separators.DOUBLE_QUOTE + str + "\" " + i + " must be an unsigned 8 bit value");
    }

    public static Record fromString(Name name, int i, int i2, long j, Tokenizer tokenizer, Name name2) throws TextParseException {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        Type.check(i);
        DClass.check(i2);
        TTL.check(j);
        Tokenizer.Token token = tokenizer.get();
        if (token.type() == 3 && token.value().equals("\\#")) {
            int uInt16 = tokenizer.getUInt16();
            byte[] hex = tokenizer.getHex();
            if (hex == null) {
                hex = new byte[0];
            }
            if (uInt16 == hex.length) {
                return newRecord(name, i, i2, j, uInt16, new DNSInput(hex));
            }
            throw tokenizer.exception("invalid unknown RR encoding: length mismatch");
        }
        tokenizer.unget();
        Record emptyRecord = getEmptyRecord(name, i, i2, j, true);
        emptyRecord.rdataFromString(tokenizer, name2);
        Tokenizer.Token token2 = tokenizer.get();
        if (token2.type() == 1 || token2.type() == 0) {
            return emptyRecord;
        }
        throw tokenizer.exception("unexpected tokens at end of record (wanted EOL/EOF, got " + token2 + Separators.RPAREN);
    }

    static Record fromWire(DNSInput dNSInput, int i, boolean z) {
        Name name = new Name(dNSInput);
        int u16 = dNSInput.readU16();
        int u162 = dNSInput.readU16();
        if (i == 0) {
            return newRecord(name, u16, u162);
        }
        long u32 = dNSInput.readU32();
        int u163 = dNSInput.readU16();
        return (u163 == 0 && z && (i == 1 || i == 2)) ? newRecord(name, u16, u162, u32) : newRecord(name, u16, u162, u32, u163, dNSInput);
    }

    private static Record getEmptyRecord(Name name, int i, int i2, long j, boolean z) {
        Record emptyRecord;
        if (z) {
            Supplier<Record> factory = Type.getFactory(i);
            emptyRecord = factory != null ? factory.get() : new UNKRecord();
        } else {
            emptyRecord = new EmptyRecord();
        }
        emptyRecord.name = name;
        emptyRecord.type = i;
        emptyRecord.dclass = i2;
        emptyRecord.ttl = j;
        return emptyRecord;
    }

    private static Record newRecord(Name name, int i, int i2, long j, int i3, DNSInput dNSInput) throws WireParseException {
        Record emptyRecord = getEmptyRecord(name, i, i2, j, dNSInput != null);
        if (dNSInput != null) {
            if (dNSInput.remaining() < i3) {
                throw new WireParseException("truncated record");
            }
            dNSInput.setActive(i3);
            emptyRecord.rrFromWire(dNSInput);
            if (dNSInput.remaining() > 0) {
                throw new WireParseException("invalid record length");
            }
            dNSInput.clearActive();
        }
        return emptyRecord;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use RecordSerializationProxy");
    }

    private void toWireCanonical(DNSOutput dNSOutput, boolean z) {
        this.name.toWireCanonical(dNSOutput);
        dNSOutput.writeU16(this.type);
        dNSOutput.writeU16(this.dclass);
        if (z) {
            dNSOutput.writeU32(0L);
        } else {
            dNSOutput.writeU32(this.ttl);
        }
        int iCurrent = dNSOutput.current();
        dNSOutput.writeU16(0);
        rrToWire(dNSOutput, null, true);
        dNSOutput.writeU16At((dNSOutput.current() - iCurrent) - 2, iCurrent);
    }

    protected static String unknownToString(byte[] bArr) {
        return "\\# " + bArr.length + Separators.SP + base16.toString(bArr);
    }

    Record cloneRecord() {
        try {
            return (Record) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Record)) {
            return false;
        }
        Record record = (Record) obj;
        if (this.type == record.type && this.dclass == record.dclass && this.name.equals(record.name)) {
            return Arrays.equals(rdataToWireCanonical(), record.rdataToWireCanonical());
        }
        return false;
    }

    public Name getAdditionalName() {
        return null;
    }

    public int getDClass() {
        return this.dclass;
    }

    public Name getName() {
        return this.name;
    }

    public int getRRsetType() {
        return this.type;
    }

    public long getTTL() {
        return this.ttl;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        int i = 0;
        for (byte b : toWireCanonical(true)) {
            i += (i << 3) + (b & 255);
        }
        return i;
    }

    protected abstract void rdataFromString(Tokenizer tokenizer, Name name);

    public String rdataToString() {
        return rrToString();
    }

    public byte[] rdataToWireCanonical() {
        DNSOutput dNSOutput = new DNSOutput();
        rrToWire(dNSOutput, null, true);
        return dNSOutput.toByteArray();
    }

    protected abstract void rrFromWire(DNSInput dNSInput);

    protected abstract String rrToString();

    protected abstract void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z);

    public boolean sameRRset(Record record) {
        return getRRsetType() == record.getRRsetType() && this.dclass == record.dclass && this.name.equals(record.name);
    }

    void setTTL(long j) {
        this.ttl = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        if (sb.length() < 8) {
            sb.append(Separators.HT);
        }
        if (sb.length() < 16) {
            sb.append(Separators.HT);
        }
        sb.append(Separators.HT);
        if (Options.check("BINDTTL")) {
            sb.append(TTL.format(this.ttl));
        } else {
            sb.append(this.ttl);
        }
        sb.append(Separators.HT);
        if (this.dclass != 1 || !Options.check("noPrintIN")) {
            sb.append(DClass.string(this.dclass));
            sb.append(Separators.HT);
        }
        sb.append(Type.string(this.type));
        String strRrToString = rrToString();
        if (!strRrToString.isEmpty()) {
            sb.append(Separators.HT);
            sb.append(strRrToString);
        }
        return sb.toString();
    }

    void toWire(DNSOutput dNSOutput, int i, Compression compression) {
        this.name.toWire(dNSOutput, compression);
        dNSOutput.writeU16(this.type);
        dNSOutput.writeU16(this.dclass);
        if (i == 0) {
            return;
        }
        dNSOutput.writeU32(this.ttl);
        int iCurrent = dNSOutput.current();
        dNSOutput.writeU16(0);
        rrToWire(dNSOutput, compression, false);
        dNSOutput.writeU16At((dNSOutput.current() - iCurrent) - 2, iCurrent);
    }

    Record withDClass(int i, long j) {
        Record recordCloneRecord = cloneRecord();
        recordCloneRecord.dclass = i;
        recordCloneRecord.ttl = j;
        return recordCloneRecord;
    }

    public Record withName(Name name) {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        Record recordCloneRecord = cloneRecord();
        recordCloneRecord.name = name;
        return recordCloneRecord;
    }

    Object writeReplace() {
        log.z("Creating proxy object for serialization");
        return new RecordSerializationProxy(this);
    }

    protected Record(Name name, int i, int i2, long j) {
        if (!name.isAbsolute()) {
            throw new RelativeNameException(name);
        }
        Type.check(i);
        DClass.check(i2);
        TTL.check(j);
        this.name = name;
        this.type = i;
        this.dclass = i2;
        this.ttl = j;
    }

    @Override // java.lang.Comparable
    public int compareTo(Record record) {
        if (this == record) {
            return 0;
        }
        int iCompareTo = this.name.compareTo(record.name);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i = this.dclass - record.dclass;
        if (i != 0) {
            return i;
        }
        int i2 = this.type - record.type;
        if (i2 != 0) {
            return i2;
        }
        byte[] bArrRdataToWireCanonical = rdataToWireCanonical();
        byte[] bArrRdataToWireCanonical2 = record.rdataToWireCanonical();
        int iMin = Math.min(bArrRdataToWireCanonical.length, bArrRdataToWireCanonical2.length);
        for (int i3 = 0; i3 < iMin; i3++) {
            byte b = bArrRdataToWireCanonical[i3];
            byte b2 = bArrRdataToWireCanonical2[i3];
            if (b != b2) {
                return (b & 255) - (b2 & 255);
            }
        }
        return bArrRdataToWireCanonical.length - bArrRdataToWireCanonical2.length;
    }

    public boolean sameRRset(RRset rRset) {
        return getRRsetType() == rRset.getType() && this.dclass == rRset.getDClass() && this.name.equals(rRset.getName());
    }

    static Record fromWire(DNSInput dNSInput, int i) {
        return fromWire(dNSInput, i, false);
    }

    public static Record newRecord(Name name, int i, int i2, long j, int i3, byte[] bArr) {
        if (name.isAbsolute()) {
            Type.check(i);
            DClass.check(i2);
            TTL.check(j);
            try {
                return newRecord(name, i, i2, j, i3, bArr != null ? new DNSInput(bArr) : null);
            } catch (IOException unused) {
                return null;
            }
        }
        throw new RelativeNameException(name);
    }

    public static Record fromWire(byte[] bArr, int i) {
        return fromWire(new DNSInput(bArr), i, false);
    }

    public byte[] toWire(int i) {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput, i, null);
        return dNSOutput.toByteArray();
    }

    private byte[] toWireCanonical(boolean z) {
        DNSOutput dNSOutput = new DNSOutput();
        toWireCanonical(dNSOutput, z);
        return dNSOutput.toByteArray();
    }

    public byte[] toWireCanonical() {
        return toWireCanonical(false);
    }

    public static Record newRecord(Name name, int i, int i2, long j, byte[] bArr) {
        return newRecord(name, i, i2, j, bArr.length, bArr);
    }

    public static Record newRecord(Name name, int i, int i2, long j) {
        if (name.isAbsolute()) {
            Type.check(i);
            DClass.check(i2);
            TTL.check(j);
            return getEmptyRecord(name, i, i2, j, false);
        }
        throw new RelativeNameException(name);
    }

    public static Record fromString(Name name, int i, int i2, long j, String str, Name name2) {
        return fromString(name, i, i2, j, new Tokenizer(str), name2);
    }

    public static Record newRecord(Name name, int i, int i2) {
        return newRecord(name, i, i2, 0L);
    }
}
