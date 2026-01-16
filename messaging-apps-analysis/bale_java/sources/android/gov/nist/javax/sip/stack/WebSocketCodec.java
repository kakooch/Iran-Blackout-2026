package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.Separators;
import android.gov.nist.core.StackLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public class WebSocketCodec {
    private static final byte OPCODE_BINARY = 2;
    private static final byte OPCODE_CLOSE = 8;
    private static final byte OPCODE_CONT = 0;
    private static final byte OPCODE_PING = 9;
    private static final byte OPCODE_PONG = 10;
    private final boolean allowExtensions;
    private boolean closeOpcodeReceived;
    private int fragmentedFramesCount;
    private boolean frameFinalFlag;
    private int frameOpcode;
    private long framePayloadLength;
    private int frameRsv;
    private final boolean maskedPayload;
    private int readIndex;
    private static StackLogger logger = CommonLogger.getLogger(WebSocketCodec.class);
    private static final byte OPCODE_TEXT = 1;
    private static final byte[] trivialMask = {OPCODE_TEXT, OPCODE_TEXT, OPCODE_TEXT, OPCODE_TEXT};
    private byte[] maskingKey = new byte[4];
    private int payloadStartIndex = -1;
    private byte[] decodeBuffer = new byte[2048];
    private int writeIndex = 0;
    private long totalPacketLength = -1;

    public WebSocketCodec(boolean z, boolean z2) {
        this.maskedPayload = z;
        this.allowExtensions = z2;
    }

    public static void applyMask(byte[] bArr, int i, int i2, byte[] bArr2) {
        for (int i3 = 0; i3 < i2 - i; i3++) {
            int i4 = i + i3;
            bArr[i4] = (byte) (bArr[i4] ^ bArr2[i3 % 4]);
        }
    }

    protected static byte[] encode(byte[] bArr, int i, boolean z, boolean z2) {
        return encode(bArr, i, z, z2, OPCODE_TEXT);
    }

    private void protocolChecks() {
        int i;
        int i2 = this.frameOpcode;
        if (i2 > 7) {
            if (!this.frameFinalFlag) {
                protocolViolation("fragmented control frame");
            }
            int i3 = this.frameOpcode;
            if (i3 == 8 || i3 == 9 || i3 == 10) {
                return;
            }
            protocolViolation("control frame using reserved opcode " + this.frameOpcode);
            return;
        }
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            protocolViolation("data frame using reserved opcode " + this.frameOpcode);
        }
        if (this.fragmentedFramesCount == 0 && this.frameOpcode == 0) {
            protocolViolation("received continuation data frame outside fragmented message");
        }
        if (this.fragmentedFramesCount == 0 || (i = this.frameOpcode) == 0 || i == 9) {
            return;
        }
        protocolViolation("received non-continuation data frame while inside fragmented message");
    }

    private void protocolViolation(String str) {
        throw new RuntimeException(str);
    }

    private byte readNextByte() {
        int i = this.readIndex;
        if (i >= this.writeIndex) {
            throw new IllegalStateException();
        }
        byte[] bArr = this.decodeBuffer;
        this.readIndex = i + 1;
        return bArr[i];
    }

    private void unmask(byte[] bArr, int i, int i2) {
        applyMask(bArr, i, i2, this.maskingKey);
    }

    public byte[] decode(InputStream inputStream) throws IOException {
        int i;
        long j;
        do {
            int length = this.decodeBuffer.length - this.writeIndex;
            int iAvailable = inputStream.available();
            if (iAvailable > length - 1) {
                int iMax = Math.max(this.decodeBuffer.length * 2, iAvailable * 4);
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Increasing buffer size from " + this.decodeBuffer.length + " avail " + iAvailable + " newSize " + iMax);
                }
                byte[] bArr = new byte[iMax];
                System.arraycopy(this.decodeBuffer, 0, bArr, 0, this.writeIndex);
                this.decodeBuffer = bArr;
            }
            int i2 = inputStream.read(this.decodeBuffer, this.writeIndex, length);
            if (i2 < 0) {
                i2 = 0;
            }
            this.writeIndex += i2;
        } while (inputStream.available() > 0);
        this.readIndex = 0;
        if (this.writeIndex < 4) {
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Abort decode. Write index is at " + this.writeIndex);
            }
            return null;
        }
        byte nextByte = readNextByte();
        int i3 = 1;
        this.frameFinalFlag = (nextByte & 128) != 0;
        this.frameRsv = (nextByte & 112) >> 4;
        this.frameOpcode = nextByte & 15;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Decoding WebSocket Frame opCode=" + this.frameOpcode);
        }
        if (this.frameOpcode == 8) {
            this.closeOpcodeReceived = true;
        }
        byte nextByte2 = readNextByte();
        boolean z = (nextByte2 & 128) != 0;
        int i4 = nextByte2 & 127;
        if (this.frameRsv != 0 && !this.allowExtensions) {
            protocolViolation("RSV != 0 and no extension negotiated, RSV:" + this.frameRsv);
            return null;
        }
        if (this.maskedPayload && !z) {
            protocolViolation("unmasked client to server frame");
            return null;
        }
        protocolChecks();
        try {
            if (i4 == 126) {
                this.framePayloadLength = ((readNextByte() & 255) << 8) | (readNextByte() & 255);
            } else if (i4 == 127) {
                long nextByte3 = 0;
                for (int i5 = 0; i5 < 8; i5++) {
                    nextByte3 |= (readNextByte() & 255) << ((7 - i5) * 8);
                }
                this.framePayloadLength = nextByte3;
                if (nextByte3 < 65536) {
                    protocolViolation("invalid data frame length (not using minimal length encoding): " + this.framePayloadLength);
                    return null;
                }
            } else {
                this.framePayloadLength = i4;
            }
            if (this.framePayloadLength < 0) {
                protocolViolation("Negative payload size: " + this.framePayloadLength);
            }
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("Decoding WebSocket Frame length=" + this.framePayloadLength);
            }
            if (z) {
                for (int i6 = 0; i6 < 4; i6++) {
                    this.maskingKey[i6] = readNextByte();
                }
            }
            int i7 = this.readIndex;
            this.payloadStartIndex = i7;
            long j2 = this.framePayloadLength;
            long j3 = i7 + j2;
            this.totalPacketLength = j3;
            if (this.writeIndex < j3) {
                if (logger.isLoggingEnabled(32)) {
                    logger.logDebug("Abort decode. Write index is at " + this.writeIndex + " and totalPacketLength is " + this.totalPacketLength);
                }
                return null;
            }
            if (z) {
                unmask(this.decodeBuffer, i7, (int) (i7 + j2));
            }
            long j4 = this.framePayloadLength;
            byte[] bArr2 = new byte[(int) j4];
            System.arraycopy(this.decodeBuffer, this.payloadStartIndex, bArr2, 0, (int) j4);
            while (true) {
                long j5 = i3;
                i = this.writeIndex;
                j = this.totalPacketLength;
                if (j5 >= i - j) {
                    break;
                }
                byte[] bArr3 = this.decodeBuffer;
                bArr3[i3] = bArr3[((int) j) + i3];
                i3++;
            }
            this.writeIndex = (int) (i - j);
            if (logger.isLoggingEnabled(32)) {
                logger.logDebug("writeIndex = " + this.writeIndex + Separators.SP + this.totalPacketLength);
            }
            return bArr2;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public boolean isCloseOpcodeReceived() {
        return this.closeOpcodeReceived;
    }

    protected static byte[] encode(byte[] bArr, int i, boolean z, boolean z2, byte b) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long length = bArr.length;
        if (logger.isLoggingEnabled(32)) {
            logger.logDebug("Encoding WebSocket Frame opCode=" + ((int) b) + " length=" + length);
        }
        int i2 = ((i % 8) << 4) | (z ? 128 : 0) | (b % 128);
        if (length <= 125) {
            byteArrayOutputStream.write(i2);
            int i3 = (byte) length;
            if (z2) {
                i3 |= 128;
            }
            byteArrayOutputStream.write((byte) i3);
        } else if (length <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            byteArrayOutputStream.write(i2);
            byteArrayOutputStream.write(z2 ? 254 : 126);
            byteArrayOutputStream.write((byte) (length >>> 8));
            byteArrayOutputStream.write((byte) length);
        } else {
            byteArrayOutputStream.write(i2);
            byteArrayOutputStream.write(z2 ? 255 : 127);
            for (int i4 = 0; i4 < 8; i4++) {
                byteArrayOutputStream.write((byte) (length >>> ((7 - i4) * 8)));
            }
        }
        if (z2) {
            byte[] bArr2 = trivialMask;
            byteArrayOutputStream.write(bArr2);
            applyMask(bArr, 0, bArr.length, bArr2);
        }
        byteArrayOutputStream.write(bArr);
        return byteArrayOutputStream.toByteArray();
    }
}
