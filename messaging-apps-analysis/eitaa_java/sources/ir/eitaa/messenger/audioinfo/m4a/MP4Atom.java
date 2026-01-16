package ir.eitaa.messenger.audioinfo.m4a;

import ir.eitaa.messenger.audioinfo.util.RangeInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public class MP4Atom extends MP4Box<RangeInputStream> {
    public MP4Atom(RangeInputStream input, MP4Box<?> parent, String type) {
        super(input, parent, type);
    }

    public long getLength() {
        return getInput().getPosition() + getInput().getRemainingLength();
    }

    public long getOffset() {
        return getParent().getPosition() - getPosition();
    }

    public long getRemaining() {
        return getInput().getRemainingLength();
    }

    public boolean hasMoreChildren() {
        return (getChild() != null ? getChild().getRemaining() : 0L) < getRemaining();
    }

    public MP4Atom nextChildUpTo(String expectedTypeExpression) throws IOException {
        while (getRemaining() > 0) {
            MP4Atom mP4AtomNextChild = nextChild();
            if (mP4AtomNextChild.getType().matches(expectedTypeExpression)) {
                return mP4AtomNextChild;
            }
        }
        throw new IOException("atom type mismatch, not found: " + expectedTypeExpression);
    }

    public boolean readBoolean() throws IOException {
        return this.data.readBoolean();
    }

    public byte readByte() throws IOException {
        return this.data.readByte();
    }

    public short readShort() throws IOException {
        return this.data.readShort();
    }

    public int readInt() throws IOException {
        return this.data.readInt();
    }

    public long readLong() throws IOException {
        return this.data.readLong();
    }

    public byte[] readBytes(int len) throws IOException {
        byte[] bArr = new byte[len];
        this.data.readFully(bArr);
        return bArr;
    }

    public byte[] readBytes() throws IOException {
        return readBytes((int) getRemaining());
    }

    public BigDecimal readShortFixedPoint() throws IOException {
        return new BigDecimal(String.valueOf((int) this.data.readByte()) + "" + String.valueOf(this.data.readUnsignedByte()));
    }

    public BigDecimal readIntegerFixedPoint() throws IOException {
        return new BigDecimal(String.valueOf((int) this.data.readShort()) + "" + String.valueOf(this.data.readUnsignedShort()));
    }

    public String readString(int len, String enc) throws IOException {
        String str = new String(readBytes(len), enc);
        int iIndexOf = str.indexOf(0);
        return iIndexOf < 0 ? str : str.substring(0, iIndexOf);
    }

    public String readString(String enc) throws IOException {
        return readString((int) getRemaining(), enc);
    }

    public void skip(int len) throws IOException {
        int i = 0;
        while (i < len) {
            int iSkipBytes = this.data.skipBytes(len - i);
            if (iSkipBytes <= 0) {
                throw new EOFException();
            }
            i += iSkipBytes;
        }
    }

    public void skip() throws IOException {
        while (getRemaining() > 0) {
            if (getInput().skip(getRemaining()) == 0) {
                throw new EOFException("Cannot skip atom");
            }
        }
    }

    private StringBuffer appendPath(StringBuffer s, MP4Box<?> box) {
        if (box.getParent() != null) {
            appendPath(s, box.getParent());
            s.append("/");
        }
        s.append(box.getType());
        return s;
    }

    public String getPath() {
        return appendPath(new StringBuffer(), this).toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        appendPath(stringBuffer, this);
        stringBuffer.append("[off=");
        stringBuffer.append(getOffset());
        stringBuffer.append(",pos=");
        stringBuffer.append(getPosition());
        stringBuffer.append(",len=");
        stringBuffer.append(getLength());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
