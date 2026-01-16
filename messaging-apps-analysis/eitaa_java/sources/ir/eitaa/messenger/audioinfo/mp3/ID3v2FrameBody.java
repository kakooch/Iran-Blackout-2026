package ir.eitaa.messenger.audioinfo.mp3;

import ir.eitaa.messenger.audioinfo.util.RangeInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class ID3v2FrameBody {
    static final ThreadLocal<Buffer> textBuffer = new ThreadLocal<Buffer>() { // from class: ir.eitaa.messenger.audioinfo.mp3.ID3v2FrameBody.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Buffer initialValue() {
            return new Buffer(Factory.DEVICE_HAS_CRAPPY_AAUDIO);
        }
    };
    private final ID3v2DataInput data;
    private final ID3v2FrameHeader frameHeader;
    private final RangeInputStream input;
    private final ID3v2TagHeader tagHeader;

    static final class Buffer {
        byte[] bytes;

        Buffer(int initialLength) {
            this.bytes = new byte[initialLength];
        }

        byte[] bytes(int minLength) {
            byte[] bArr = this.bytes;
            if (minLength > bArr.length) {
                int length = bArr.length;
                do {
                    length *= 2;
                } while (minLength > length);
                this.bytes = new byte[length];
            }
            return this.bytes;
        }
    }

    ID3v2FrameBody(InputStream delegate, long position, int dataLength, ID3v2TagHeader tagHeader, ID3v2FrameHeader frameHeader) throws IOException {
        RangeInputStream rangeInputStream = new RangeInputStream(delegate, position, dataLength);
        this.input = rangeInputStream;
        this.data = new ID3v2DataInput(rangeInputStream);
        this.tagHeader = tagHeader;
        this.frameHeader = frameHeader;
    }

    public ID3v2DataInput getData() {
        return this.data;
    }

    public long getPosition() {
        return this.input.getPosition();
    }

    public long getRemainingLength() {
        return this.input.getRemainingLength();
    }

    public ID3v2TagHeader getTagHeader() {
        return this.tagHeader;
    }

    public ID3v2FrameHeader getFrameHeader() {
        return this.frameHeader;
    }

    private String extractString(byte[] bytes, int offset, int length, ID3v2Encoding encoding, boolean searchZeros) {
        if (searchZeros) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i < length) {
                    int i3 = offset + i;
                    if (bytes[i3] != 0 || (encoding == ID3v2Encoding.UTF_16 && i2 == 0 && i3 % 2 != 0)) {
                        i2 = 0;
                    } else {
                        i2++;
                        if (i2 == encoding.getZeroBytes()) {
                            length = (i + 1) - encoding.getZeroBytes();
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        try {
            String str = new String(bytes, offset, length, encoding.getCharset().name());
            return (str.length() <= 0 || str.charAt(0) != 65279) ? str : str.substring(1);
        } catch (Exception unused) {
            return "";
        }
    }

    public String readZeroTerminatedString(int maxLength, ID3v2Encoding encoding) throws ID3v2Exception, IOException {
        int iMin = Math.min(maxLength, (int) getRemainingLength());
        byte[] bArrBytes = textBuffer.get().bytes(iMin);
        int i = 0;
        for (int i2 = 0; i2 < iMin; i2++) {
            byte b = this.data.readByte();
            bArrBytes[i2] = b;
            if (b != 0 || (encoding == ID3v2Encoding.UTF_16 && i == 0 && i2 % 2 != 0)) {
                i = 0;
            } else {
                i++;
                if (i == encoding.getZeroBytes()) {
                    return extractString(bArrBytes, 0, (i2 + 1) - encoding.getZeroBytes(), encoding, false);
                }
            }
        }
        throw new ID3v2Exception("Could not read zero-termiated string");
    }

    public String readFixedLengthString(int length, ID3v2Encoding encoding) throws ID3v2Exception, IOException {
        if (length > getRemainingLength()) {
            throw new ID3v2Exception("Could not read fixed-length string of length: " + length);
        }
        byte[] bArrBytes = textBuffer.get().bytes(length);
        this.data.readFully(bArrBytes, 0, length);
        return extractString(bArrBytes, 0, length, encoding, true);
    }

    public ID3v2Encoding readEncoding() throws ID3v2Exception, IOException {
        byte b = this.data.readByte();
        if (b == 0) {
            return ID3v2Encoding.ISO_8859_1;
        }
        if (b == 1) {
            return ID3v2Encoding.UTF_16;
        }
        if (b == 2) {
            return ID3v2Encoding.UTF_16BE;
        }
        if (b == 3) {
            return ID3v2Encoding.UTF_8;
        }
        throw new ID3v2Exception("Invalid encoding: " + ((int) b));
    }

    public String toString() {
        return "id3v2frame[pos=" + getPosition() + ", " + getRemainingLength() + " left]";
    }
}
