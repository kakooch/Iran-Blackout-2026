package ir.eitaa.tgnet;

import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class SerializedData extends AbstractSerializedData {
    private DataInputStream in;
    private ByteArrayInputStream inbuf;
    protected boolean isOut;
    private boolean justCalc;
    private int len;
    private DataOutputStream out;
    private ByteArrayOutputStream outbuf;

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public NativeByteBuffer readByteBuffer(boolean exception) {
        return null;
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeByteBuffer(NativeByteBuffer buffer) {
    }

    public SerializedData() {
        this.isOut = true;
        this.justCalc = false;
        this.outbuf = new ByteArrayOutputStream();
        this.out = new DataOutputStream(this.outbuf);
    }

    public SerializedData(boolean calculate) {
        this.isOut = true;
        this.justCalc = false;
        if (!calculate) {
            this.outbuf = new ByteArrayOutputStream();
            this.out = new DataOutputStream(this.outbuf);
        }
        this.justCalc = calculate;
        this.len = 0;
    }

    public SerializedData(int size) {
        this.isOut = true;
        this.justCalc = false;
        this.outbuf = new ByteArrayOutputStream(size);
        this.out = new DataOutputStream(this.outbuf);
    }

    public SerializedData(byte[] data) {
        this.isOut = true;
        this.justCalc = false;
        this.isOut = false;
        this.inbuf = new ByteArrayInputStream(data);
        this.in = new DataInputStream(this.inbuf);
        this.len = 0;
    }

    public void cleanup() {
        try {
            ByteArrayInputStream byteArrayInputStream = this.inbuf;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
                this.inbuf = null;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        try {
            DataInputStream dataInputStream = this.in;
            if (dataInputStream != null) {
                dataInputStream.close();
                this.in = null;
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = this.outbuf;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
                this.outbuf = null;
            }
        } catch (Exception e3) {
            FileLog.e(e3);
        }
        try {
            DataOutputStream dataOutputStream = this.out;
            if (dataOutputStream != null) {
                dataOutputStream.close();
                this.out = null;
            }
        } catch (Exception e4) {
            FileLog.e(e4);
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeInt32(int x) {
        if (!this.justCalc) {
            writeInt32(x, this.out);
        } else {
            this.len += 4;
        }
    }

    private void writeInt32(int x, DataOutputStream out) throws IOException {
        for (int i = 0; i < 4; i++) {
            try {
                out.write(x >> (i * 8));
            } catch (Exception e) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("write int32 error");
                    FileLog.e(e);
                    return;
                }
                return;
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeInt64(long i) {
        if (!this.justCalc) {
            writeInt64(i, this.out);
        } else {
            this.len += 8;
        }
    }

    private void writeInt64(long x, DataOutputStream out) throws IOException {
        for (int i = 0; i < 8; i++) {
            try {
                out.write((int) (x >> (i * 8)));
            } catch (Exception e) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("write int64 error");
                    FileLog.e(e);
                    return;
                }
                return;
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
                this.out.write(b);
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
    public void writeBytes(byte[] b, int offset, int count) throws IOException {
        try {
            if (!this.justCalc) {
                this.out.write(b, offset, count);
            } else {
                this.len += count;
            }
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("write bytes error");
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void writeByte(int i) throws IOException {
        try {
            if (!this.justCalc) {
                this.out.writeByte((byte) i);
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
    public void writeByte(byte b) throws IOException {
        try {
            if (!this.justCalc) {
                this.out.writeByte(b);
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
    public void writeByteArray(byte[] b) {
        try {
            if (b.length <= 253) {
                if (this.justCalc) {
                    this.len++;
                } else {
                    this.out.write(b.length);
                }
            } else if (this.justCalc) {
                this.len += 4;
            } else {
                this.out.write(254);
                this.out.write(b.length);
                this.out.write(b.length >> 8);
                this.out.write(b.length >> 16);
            }
            if (this.justCalc) {
                this.len += b.length;
            } else {
                this.out.write(b);
            }
            for (int i = b.length <= 253 ? 1 : 4; (b.length + i) % 4 != 0; i++) {
                if (this.justCalc) {
                    this.len++;
                } else {
                    this.out.write(0);
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
    public void writeByteArray(byte[] b, int offset, int count) throws IOException {
        try {
            if (count <= 253) {
                if (this.justCalc) {
                    this.len++;
                } else {
                    this.out.write(count);
                }
            } else if (this.justCalc) {
                this.len += 4;
            } else {
                this.out.write(254);
                this.out.write(count);
                this.out.write(count >> 8);
                this.out.write(count >> 16);
            }
            if (this.justCalc) {
                this.len += count;
            } else {
                this.out.write(b, offset, count);
            }
            for (int i = count <= 253 ? 1 : 4; (count + i) % 4 != 0; i++) {
                if (this.justCalc) {
                    this.len++;
                } else {
                    this.out.write(0);
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

    public void writeFloat(float d) {
        try {
            writeInt32(Float.floatToIntBits(d));
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("write float error");
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public int length() {
        if (this.justCalc) {
            return this.len;
        }
        return this.isOut ? this.outbuf.size() : this.inbuf.available();
    }

    public byte[] toByteArray() {
        return this.outbuf.toByteArray();
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void skip(int count) throws IOException {
        if (count == 0) {
            return;
        }
        if (!this.justCalc) {
            DataInputStream dataInputStream = this.in;
            if (dataInputStream != null) {
                try {
                    dataInputStream.skipBytes(count);
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            return;
        }
        this.len += count;
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public int getPosition() {
        return this.len;
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

    public byte readByte(boolean exception) throws IOException {
        try {
            byte b = this.in.readByte();
            this.len++;
            return b;
        } catch (Exception e) {
            if (exception) {
                throw new RuntimeException("read byte error", e);
            }
            if (!BuildVars.LOGS_ENABLED) {
                return (byte) 0;
            }
            FileLog.e("read byte error");
            FileLog.e(e);
            return (byte) 0;
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public void readBytes(byte[] b, boolean exception) throws IOException {
        try {
            this.in.read(b);
            this.len += b.length;
        } catch (Exception e) {
            if (exception) {
                throw new RuntimeException("read bytes error", e);
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("read bytes error");
                FileLog.e(e);
            }
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public byte[] readData(int count, boolean exception) throws IOException {
        byte[] bArr = new byte[count];
        readBytes(bArr, exception);
        return bArr;
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public String readString(boolean exception) throws IOException {
        int i;
        try {
            int i2 = this.in.read();
            this.len++;
            if (i2 >= 254) {
                i2 = this.in.read() | (this.in.read() << 8) | (this.in.read() << 16);
                this.len += 3;
                i = 4;
            } else {
                i = 1;
            }
            byte[] bArr = new byte[i2];
            this.in.read(bArr);
            this.len++;
            while ((i2 + i) % 4 != 0) {
                this.in.read();
                this.len++;
                i++;
            }
            return new String(bArr, "UTF-8");
        } catch (Exception e) {
            if (exception) {
                throw new RuntimeException("read string error", e);
            }
            if (!BuildVars.LOGS_ENABLED) {
                return null;
            }
            FileLog.e("read string error");
            FileLog.e(e);
            return null;
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public byte[] readByteArray(boolean exception) throws IOException {
        int i;
        try {
            int i2 = this.in.read();
            this.len++;
            if (i2 >= 254) {
                i2 = this.in.read() | (this.in.read() << 8) | (this.in.read() << 16);
                this.len += 3;
                i = 4;
            } else {
                i = 1;
            }
            byte[] bArr = new byte[i2];
            this.in.read(bArr);
            this.len++;
            while ((i2 + i) % 4 != 0) {
                this.in.read();
                this.len++;
                i++;
            }
            return bArr;
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

    public float readFloat(boolean exception) {
        try {
            return Float.intBitsToFloat(readInt32(exception));
        } catch (Exception e) {
            if (exception) {
                throw new RuntimeException("read float error", e);
            }
            if (!BuildVars.LOGS_ENABLED) {
                return 0.0f;
            }
            FileLog.e("read float error");
            FileLog.e(e);
            return 0.0f;
        }
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public int readInt32(boolean exception) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                i |= this.in.read() << (i2 * 8);
                this.len++;
            } catch (Exception e) {
                if (exception) {
                    throw new RuntimeException("read int32 error", e);
                }
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("read int32 error");
                    FileLog.e(e);
                }
                return 0;
            }
        }
        return i;
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public long readInt64(boolean exception) {
        long j = 0;
        for (int i = 0; i < 8; i++) {
            try {
                j |= this.in.read() << (i * 8);
                this.len++;
            } catch (Exception e) {
                if (exception) {
                    throw new RuntimeException("read int64 error", e);
                }
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("read int64 error");
                    FileLog.e(e);
                }
                return 0L;
            }
        }
        return j;
    }

    @Override // ir.eitaa.tgnet.AbstractSerializedData
    public int remaining() {
        try {
            return this.in.available();
        } catch (Exception unused) {
            return ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
    }
}
