package ir.eitaa.tgnet;

import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class NativeByteBuffer extends AbstractSerializedData {
    private static final ThreadLocal<LinkedList<NativeByteBuffer>> addressWrappers = new ThreadLocal<LinkedList<NativeByteBuffer>>() { // from class: ir.eitaa.tgnet.NativeByteBuffer.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public LinkedList<NativeByteBuffer> initialValue() {
            return new LinkedList<>();
        }
    };
    protected long address;
    public ByteBuffer buffer;
    private boolean justCalc;
    private int len;
    public boolean reused = true;

    public static native long native_getFreeBuffer(int length);

    public static native ByteBuffer native_getJavaByteBuffer(long address);

    public static native int native_limit(long address);

    public static native int native_position(long address);

    public static native void native_reuse(long address);

    public int getIntFromByte(byte b) {
        return b >= 0 ? b : b + 256;
    }

    public static NativeByteBuffer wrap(long address) {
        if (address == 0) {
            return null;
        }
        NativeByteBuffer nativeByteBufferPoll = addressWrappers.get().poll();
        if (nativeByteBufferPoll == null) {
            nativeByteBufferPoll = new NativeByteBuffer(0, true);
        }
        nativeByteBufferPoll.address = address;
        nativeByteBufferPoll.reused = false;
        ByteBuffer byteBufferNative_getJavaByteBuffer = native_getJavaByteBuffer(address);
        nativeByteBufferPoll.buffer = byteBufferNative_getJavaByteBuffer;
        byteBufferNative_getJavaByteBuffer.limit(native_limit(address));
        int iNative_position = native_position(address);
        if (iNative_position <= nativeByteBufferPoll.buffer.limit()) {
            nativeByteBufferPoll.buffer.position(iNative_position);
        }
        nativeByteBufferPoll.buffer.order(ByteOrder.LITTLE_ENDIAN);
        return nativeByteBufferPoll;
    }

    private NativeByteBuffer(int address, boolean wrap) {
    }

    public NativeByteBuffer(int size) throws Exception {
        if (size >= 0) {
            long jNative_getFreeBuffer = native_getFreeBuffer(size);
            this.address = jNative_getFreeBuffer;
            if (jNative_getFreeBuffer != 0) {
                ByteBuffer byteBufferNative_getJavaByteBuffer = native_getJavaByteBuffer(jNative_getFreeBuffer);
                this.buffer = byteBufferNative_getJavaByteBuffer;
                byteBufferNative_getJavaByteBuffer.position(0);
                this.buffer.limit(size);
                this.buffer.order(ByteOrder.LITTLE_ENDIAN);
                return;
            }
            return;
        }
        throw new Exception("invalid NativeByteBuffer size");
    }

    public NativeByteBuffer(boolean calculate) {
        this.justCalc = calculate;
    }

    public int position() {
        return this.buffer.position();
    }

    public void position(int position) {
        this.buffer.position(position);
    }

    public int capacity() {
        return this.buffer.capacity();
    }

    public int limit() {
        return this.buffer.limit();
    }

    public void limit(int limit) {
        this.buffer.limit(limit);
    }

    public void put(ByteBuffer buff) {
        this.buffer.put(buff);
    }

    public void rewind() {
        if (this.justCalc) {
            this.len = 0;
        } else {
            this.buffer.rewind();
        }
    }

    public void compact() {
        this.buffer.compact();
    }

    public boolean hasRemaining() {
        return this.buffer.hasRemaining();
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeInt32(int x) {
        try {
            if (!this.justCalc) {
                this.buffer.putInt(x);
            } else {
                this.len += 4;
            }
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("write int32 error");
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeInt64(long x) {
        try {
            if (!this.justCalc) {
                this.buffer.putLong(x);
            } else {
                this.len += 8;
            }
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("write int64 error");
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeBool(boolean value) {
        if (this.justCalc) {
            this.len += 4;
        } else if (value) {
            writeInt32(-1720552011);
        } else {
            writeInt32(-1132882121);
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeBytes(byte[] b) {
        try {
            if (!this.justCalc) {
                this.buffer.put(b);
            } else {
                this.len += b.length;
            }
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("write raw error");
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeBytes(byte[] b, int offset, int count) {
        try {
            if (!this.justCalc) {
                this.buffer.put(b, offset, count);
            } else {
                this.len += count;
            }
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("write raw error");
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeByte(int i) {
        writeByte((byte) i);
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeByte(byte b) {
        try {
            if (!this.justCalc) {
                this.buffer.put(b);
            } else {
                this.len++;
            }
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("write byte error");
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeString(String s) {
        try {
            writeByteArray(s.getBytes("UTF-8"));
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("write string error");
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeByteArray(byte[] b, int offset, int count) {
        try {
            if (count <= 253) {
                if (this.justCalc) {
                    this.len++;
                } else {
                    this.buffer.put((byte) count);
                }
            } else if (this.justCalc) {
                this.len += 4;
            } else {
                this.buffer.put((byte) -2);
                this.buffer.put((byte) count);
                this.buffer.put((byte) (count >> 8));
                this.buffer.put((byte) (count >> 16));
            }
            if (this.justCalc) {
                this.len += count;
            } else {
                this.buffer.put(b, offset, count);
            }
            for (int i = count <= 253 ? 1 : 4; (count + i) % 4 != 0; i++) {
                if (this.justCalc) {
                    this.len++;
                } else {
                    this.buffer.put((byte) 0);
                }
            }
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("write byte array error");
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeByteArray(byte[] b) {
        try {
            if (b.length <= 253) {
                if (this.justCalc) {
                    this.len++;
                } else {
                    this.buffer.put((byte) b.length);
                }
            } else if (this.justCalc) {
                this.len += 4;
            } else {
                this.buffer.put((byte) -2);
                this.buffer.put((byte) b.length);
                this.buffer.put((byte) (b.length >> 8));
                this.buffer.put((byte) (b.length >> 16));
            }
            if (this.justCalc) {
                this.len += b.length;
            } else {
                this.buffer.put(b);
            }
            for (int i = b.length <= 253 ? 1 : 4; (b.length + i) % 4 != 0; i++) {
                if (this.justCalc) {
                    this.len++;
                } else {
                    this.buffer.put((byte) 0);
                }
            }
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("write byte array error");
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeDouble(double d) {
        try {
            writeInt64(Double.doubleToRawLongBits(d));
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("write double error");
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeByteBuffer(NativeByteBuffer b) {
        try {
            int iLimit = b.limit();
            if (iLimit <= 253) {
                if (this.justCalc) {
                    this.len++;
                } else {
                    this.buffer.put((byte) iLimit);
                }
            } else if (this.justCalc) {
                this.len += 4;
            } else {
                this.buffer.put((byte) -2);
                this.buffer.put((byte) iLimit);
                this.buffer.put((byte) (iLimit >> 8));
                this.buffer.put((byte) (iLimit >> 16));
            }
            if (this.justCalc) {
                this.len += iLimit;
            } else {
                b.rewind();
                this.buffer.put(b.buffer);
            }
            for (int i = iLimit <= 253 ? 1 : 4; (iLimit + i) % 4 != 0; i++) {
                if (this.justCalc) {
                    this.len++;
                } else {
                    this.buffer.put((byte) 0);
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void writeBytes(NativeByteBuffer b) {
        if (this.justCalc) {
            this.len += b.limit();
        } else {
            b.rewind();
            this.buffer.put(b.buffer);
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public int length() {
        if (!this.justCalc) {
            return this.buffer.position();
        }
        return this.len;
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void skip(int count) {
        if (count == 0) {
            return;
        }
        if (!this.justCalc) {
            ByteBuffer byteBuffer = this.buffer;
            byteBuffer.position(byteBuffer.position() + count);
        } else {
            this.len += count;
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public int getPosition() {
        return this.buffer.position();
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public int readInt32(boolean exception) {
        try {
            return this.buffer.getInt();
        } catch (Exception e) {
            if (exception) {
                throw new RuntimeException("read int32 error", e);
            }
            if (!BuildVars.LOGS_ENABLED) {
                return 0;
            }
            FileLog.e("read int32 error");
            FileLog.e(e);
            return 0;
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public boolean readBool(boolean exception) {
        int int32 = readInt32(exception);
        if (int32 == -1720552011) {
            return true;
        }
        if (int32 == -1132882121) {
            return false;
        }
        if (exception) {
            throw new RuntimeException("Not bool value!");
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.e("Not bool value!");
        }
        return false;
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public long readInt64(boolean exception) {
        try {
            return this.buffer.getLong();
        } catch (Exception e) {
            if (exception) {
                throw new RuntimeException("read int64 error", e);
            }
            if (!BuildVars.LOGS_ENABLED) {
                return 0L;
            }
            FileLog.e("read int64 error");
            FileLog.e(e);
            return 0L;
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void readBytes(byte[] b, boolean exception) {
        try {
            this.buffer.get(b);
        } catch (Exception e) {
            if (exception) {
                throw new RuntimeException("read raw error", e);
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("read raw error");
                FileLog.e(e);
            }
        }
    }

    public void readBytes(byte[] b, int offset, int count, boolean exception) {
        try {
            this.buffer.get(b, offset, count);
        } catch (Exception e) {
            if (exception) {
                throw new RuntimeException("read raw error", e);
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("read raw error");
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public byte[] readData(int count, boolean exception) {
        byte[] bArr = new byte[count];
        readBytes(bArr, exception);
        return bArr;
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public String readString(boolean exception) {
        int i;
        int position = getPosition();
        try {
            int intFromByte = getIntFromByte(this.buffer.get());
            if (intFromByte >= 254) {
                intFromByte = getIntFromByte(this.buffer.get()) | (getIntFromByte(this.buffer.get()) << 8) | (getIntFromByte(this.buffer.get()) << 16);
                i = 4;
            } else {
                i = 1;
            }
            byte[] bArr = new byte[intFromByte];
            this.buffer.get(bArr);
            while ((intFromByte + i) % 4 != 0) {
                this.buffer.get();
                i++;
            }
            return new String(bArr, "UTF-8");
        } catch (Exception e) {
            if (exception) {
                throw new RuntimeException("read string error", e);
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("read string error");
                FileLog.e(e);
            }
            position(position);
            return "";
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public byte[] readByteArray(boolean exception) {
        int i;
        try {
            int intFromByte = getIntFromByte(this.buffer.get());
            if (intFromByte >= 254) {
                intFromByte = getIntFromByte(this.buffer.get()) | (getIntFromByte(this.buffer.get()) << 8) | (getIntFromByte(this.buffer.get()) << 16);
                i = 4;
            } else {
                i = 1;
            }
            byte[] bArr = new byte[intFromByte];
            this.buffer.get(bArr);
            while ((intFromByte + i) % 4 != 0) {
                this.buffer.get();
                i++;
            }
            return bArr;
        } catch (Exception e) {
            if (exception) {
                throw new RuntimeException("read byte array error", e);
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("read byte array error");
                FileLog.e(e);
            }
            return new byte[0];
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public NativeByteBuffer readByteBuffer(boolean exception) {
        int i;
        try {
            int intFromByte = getIntFromByte(this.buffer.get());
            if (intFromByte >= 254) {
                intFromByte = getIntFromByte(this.buffer.get()) | (getIntFromByte(this.buffer.get()) << 8) | (getIntFromByte(this.buffer.get()) << 16);
                i = 4;
            } else {
                i = 1;
            }
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(intFromByte);
            int iLimit = this.buffer.limit();
            ByteBuffer byteBuffer = this.buffer;
            byteBuffer.limit(byteBuffer.position() + intFromByte);
            nativeByteBuffer.buffer.put(this.buffer);
            this.buffer.limit(iLimit);
            nativeByteBuffer.buffer.position(0);
            while ((intFromByte + i) % 4 != 0) {
                this.buffer.get();
                i++;
            }
            return nativeByteBuffer;
        } catch (Exception e) {
            if (exception) {
                throw new RuntimeException("read byte array error", e);
            }
            if (!BuildVars.LOGS_ENABLED) {
                return null;
            }
            FileLog.e("read byte array error");
            FileLog.e(e);
            return null;
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public double readDouble(boolean exception) {
        try {
            return Double.longBitsToDouble(readInt64(exception));
        } catch (Exception e) {
            if (exception) {
                throw new RuntimeException("read double error", e);
            }
            if (!BuildVars.LOGS_ENABLED) {
                return 0.0d;
            }
            FileLog.e("read double error");
            FileLog.e(e);
            return 0.0d;
        }
    }

    public void reuse() {
        if (this.address != 0) {
            addressWrappers.get().add(this);
            this.reused = true;
            native_reuse(this.address);
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public int remaining() {
        return this.buffer.remaining();
    }
}
