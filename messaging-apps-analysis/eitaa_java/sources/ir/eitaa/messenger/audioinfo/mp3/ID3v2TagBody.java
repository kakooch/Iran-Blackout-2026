package ir.eitaa.messenger.audioinfo.mp3;

import ir.eitaa.messenger.audioinfo.util.RangeInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;

/* loaded from: classes.dex */
public class ID3v2TagBody {
    private final ID3v2DataInput data;
    private final RangeInputStream input;
    private final ID3v2TagHeader tagHeader;

    ID3v2TagBody(InputStream delegate, long position, int length, ID3v2TagHeader tagHeader) throws IOException {
        RangeInputStream rangeInputStream = new RangeInputStream(delegate, position, length);
        this.input = rangeInputStream;
        this.data = new ID3v2DataInput(rangeInputStream);
        this.tagHeader = tagHeader;
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

    public ID3v2FrameBody frameBody(ID3v2FrameHeader frameHeader) throws ID3v2Exception, IOException {
        int dataLengthIndicator;
        InputStream inflaterInputStream;
        int bodySize = frameHeader.getBodySize();
        InputStream byteArrayInputStream = this.input;
        if (frameHeader.isUnsynchronization()) {
            byte[] fully = this.data.readFully(frameHeader.getBodySize());
            int length = fully.length;
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < length; i2++) {
                byte b = fully[i2];
                if (!z || b != 0) {
                    fully[i] = b;
                    i++;
                }
                z = b == -1;
            }
            byteArrayInputStream = new ByteArrayInputStream(fully, 0, i);
            bodySize = i;
        }
        if (frameHeader.isEncryption()) {
            throw new ID3v2Exception("Frame encryption is not supported");
        }
        if (frameHeader.isCompression()) {
            dataLengthIndicator = frameHeader.getDataLengthIndicator();
            inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        } else {
            dataLengthIndicator = bodySize;
            inflaterInputStream = byteArrayInputStream;
        }
        return new ID3v2FrameBody(inflaterInputStream, frameHeader.getHeaderSize(), dataLengthIndicator, this.tagHeader, frameHeader);
    }

    public String toString() {
        return "id3v2tag[pos=" + getPosition() + ", " + getRemainingLength() + " left]";
    }
}
