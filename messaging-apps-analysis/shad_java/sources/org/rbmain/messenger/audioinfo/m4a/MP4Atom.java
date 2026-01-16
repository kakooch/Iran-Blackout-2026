package org.rbmain.messenger.audioinfo.m4a;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import org.rbmain.messenger.audioinfo.util.RangeInputStream;

/* loaded from: classes4.dex */
public class MP4Atom extends MP4Box<RangeInputStream> {
    public MP4Atom(RangeInputStream rangeInputStream, MP4Box<?> mP4Box, String str) {
        super(rangeInputStream, mP4Box, str);
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

    public MP4Atom nextChildUpTo(String str) throws IOException {
        while (getRemaining() > 0) {
            MP4Atom mP4AtomNextChild = nextChild();
            if (mP4AtomNextChild.getType().matches(str)) {
                return mP4AtomNextChild;
            }
        }
        throw new IOException("atom type mismatch, not found: " + str);
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

    public byte[] readBytes(int i) throws IOException {
        byte[] bArr = new byte[i];
        this.data.readFully(bArr);
        return bArr;
    }

    public byte[] readBytes() throws IOException {
        return readBytes((int) getRemaining());
    }

    public BigDecimal readShortFixedPoint() throws IOException {
        return new BigDecimal(String.valueOf((int) this.data.readByte()) + BuildConfig.FLAVOR + String.valueOf(this.data.readUnsignedByte()));
    }

    public BigDecimal readIntegerFixedPoint() throws IOException {
        return new BigDecimal(String.valueOf((int) this.data.readShort()) + BuildConfig.FLAVOR + String.valueOf(this.data.readUnsignedShort()));
    }

    public String readString(int i, String str) throws IOException {
        String str2 = new String(readBytes(i), str);
        int iIndexOf = str2.indexOf(0);
        return iIndexOf < 0 ? str2 : str2.substring(0, iIndexOf);
    }

    public String readString(String str) throws IOException {
        return readString((int) getRemaining(), str);
    }

    public void skip(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int iSkipBytes = this.data.skipBytes(i - i2);
            if (iSkipBytes <= 0) {
                throw new EOFException();
            }
            i2 += iSkipBytes;
        }
    }

    public void skip() throws IOException {
        while (getRemaining() > 0) {
            if (getInput().skip(getRemaining()) == 0) {
                throw new EOFException("Cannot skip atom");
            }
        }
    }

    private StringBuffer appendPath(StringBuffer stringBuffer, MP4Box<?> mP4Box) {
        if (mP4Box.getParent() != null) {
            appendPath(stringBuffer, mP4Box.getParent());
            stringBuffer.append("/");
        }
        stringBuffer.append(mP4Box.getType());
        return stringBuffer;
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
