package ir.nasim;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* renamed from: ir.nasim.wq6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C23394wq6 extends T1 {
    protected boolean a;
    private ByteArrayOutputStream b;
    private DataOutputStream c;
    private ByteArrayInputStream d;
    private DataInputStream e;
    private boolean f;
    private int g;

    public C23394wq6(int i) {
        this.a = true;
        this.f = false;
        this.b = new ByteArrayOutputStream(i);
        this.c = new DataOutputStream(this.b);
    }

    private void r(int i, DataOutputStream dataOutputStream) throws IOException {
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                dataOutputStream.write(i >> (i2 * 8));
            } catch (Exception e) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("write int32 error");
                    AbstractC6403Nl2.d(e);
                    return;
                }
                return;
            }
        }
    }

    private void s(long j, DataOutputStream dataOutputStream) throws IOException {
        for (int i = 0; i < 8; i++) {
            try {
                dataOutputStream.write((int) (j >> (i * 8)));
            } catch (Exception e) {
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("write int64 error");
                    AbstractC6403Nl2.d(e);
                    return;
                }
                return;
            }
        }
    }

    @Override // ir.nasim.T1
    public boolean a(boolean z) {
        int iE = e(z);
        if (iE == -1720552011) {
            return true;
        }
        if (iE == -1132882121) {
            return false;
        }
        if (z) {
            throw new RuntimeException("Not bool value!");
        }
        if (AbstractC8814Xl0.b) {
            AbstractC6403Nl2.b("Not bool value!");
        }
        return false;
    }

    @Override // ir.nasim.T1
    public byte b(boolean z) throws IOException {
        try {
            byte b = this.e.readByte();
            this.g++;
            return b;
        } catch (Exception e) {
            if (z) {
                throw new RuntimeException("read byte error", e);
            }
            if (!AbstractC8814Xl0.b) {
                return (byte) 0;
            }
            AbstractC6403Nl2.b("read byte error");
            AbstractC6403Nl2.d(e);
            return (byte) 0;
        }
    }

    @Override // ir.nasim.T1
    public byte[] c(boolean z) throws IOException {
        int i;
        try {
            int i2 = this.e.read();
            this.g++;
            if (i2 >= 254) {
                i2 = this.e.read() | (this.e.read() << 8) | (this.e.read() << 16);
                this.g += 3;
                i = 4;
            } else {
                i = 1;
            }
            byte[] bArr = new byte[i2];
            this.e.read(bArr);
            this.g++;
            while ((i2 + i) % 4 != 0) {
                this.e.read();
                this.g++;
                i++;
            }
            return bArr;
        } catch (Exception e) {
            if (z) {
                throw new RuntimeException("read byte array error", e);
            }
            if (!AbstractC8814Xl0.b) {
                return null;
            }
            AbstractC6403Nl2.b("read byte array error");
            AbstractC6403Nl2.d(e);
            return null;
        }
    }

    @Override // ir.nasim.T1
    public double d(boolean z) {
        try {
            return Double.longBitsToDouble(f(z));
        } catch (Exception e) {
            if (z) {
                throw new RuntimeException("read double error", e);
            }
            if (!AbstractC8814Xl0.b) {
                return 0.0d;
            }
            AbstractC6403Nl2.b("read double error");
            AbstractC6403Nl2.d(e);
            return 0.0d;
        }
    }

    @Override // ir.nasim.T1
    public int e(boolean z) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                i |= this.e.read() << (i2 * 8);
                this.g++;
            } catch (Exception e) {
                if (z) {
                    throw new RuntimeException("read int32 error", e);
                }
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("read int32 error");
                    AbstractC6403Nl2.d(e);
                }
                return 0;
            }
        }
        return i;
    }

    @Override // ir.nasim.T1
    public long f(boolean z) {
        long j = 0;
        for (int i = 0; i < 8; i++) {
            try {
                j |= this.e.read() << (i * 8);
                this.g++;
            } catch (Exception e) {
                if (z) {
                    throw new RuntimeException("read int64 error", e);
                }
                if (AbstractC8814Xl0.b) {
                    AbstractC6403Nl2.b("read int64 error");
                    AbstractC6403Nl2.d(e);
                }
                return 0L;
            }
        }
        return j;
    }

    @Override // ir.nasim.T1
    public String g(boolean z) throws IOException {
        int i;
        try {
            int i2 = this.e.read();
            this.g++;
            if (i2 >= 254) {
                i2 = this.e.read() | (this.e.read() << 8) | (this.e.read() << 16);
                this.g += 3;
                i = 4;
            } else {
                i = 1;
            }
            byte[] bArr = new byte[i2];
            this.e.read(bArr);
            this.g++;
            while ((i2 + i) % 4 != 0) {
                this.e.read();
                this.g++;
                i++;
            }
            return new String(bArr, "UTF-8");
        } catch (Exception e) {
            if (z) {
                throw new RuntimeException("read string error", e);
            }
            if (!AbstractC8814Xl0.b) {
                return null;
            }
            AbstractC6403Nl2.b("read string error");
            AbstractC6403Nl2.d(e);
            return null;
        }
    }

    @Override // ir.nasim.T1
    public int h() {
        try {
            return this.e.available();
        } catch (Exception unused) {
            return Integer.MAX_VALUE;
        }
    }

    @Override // ir.nasim.T1
    public void i(boolean z) throws IOException {
        if (this.f) {
            this.g += 4;
        } else if (z) {
            m(-1720552011);
        } else {
            m(-1132882121);
        }
    }

    @Override // ir.nasim.T1
    public void j(byte b) throws IOException {
        try {
            if (this.f) {
                this.g++;
            } else {
                this.c.writeByte(b);
            }
        } catch (Exception e) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("write byte error");
                AbstractC6403Nl2.d(e);
            }
        }
    }

    @Override // ir.nasim.T1
    public void k(byte[] bArr) throws IOException {
        try {
            if (bArr.length <= 253) {
                if (this.f) {
                    this.g++;
                } else {
                    this.c.write(bArr.length);
                }
            } else if (this.f) {
                this.g += 4;
            } else {
                this.c.write(254);
                this.c.write(bArr.length);
                this.c.write(bArr.length >> 8);
                this.c.write(bArr.length >> 16);
            }
            if (this.f) {
                this.g += bArr.length;
            } else {
                this.c.write(bArr);
            }
            for (int i = bArr.length <= 253 ? 1 : 4; (bArr.length + i) % 4 != 0; i++) {
                if (this.f) {
                    this.g++;
                } else {
                    this.c.write(0);
                }
            }
        } catch (Exception e) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("write byte array error");
                AbstractC6403Nl2.d(e);
            }
        }
    }

    @Override // ir.nasim.T1
    public void l(double d) {
        try {
            n(Double.doubleToRawLongBits(d));
        } catch (Exception e) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("write double error");
                AbstractC6403Nl2.d(e);
            }
        }
    }

    @Override // ir.nasim.T1
    public void m(int i) throws IOException {
        if (this.f) {
            this.g += 4;
        } else {
            r(i, this.c);
        }
    }

    @Override // ir.nasim.T1
    public void n(long j) throws IOException {
        if (this.f) {
            this.g += 8;
        } else {
            s(j, this.c);
        }
    }

    @Override // ir.nasim.T1
    public void o(String str) {
        try {
            k(str.getBytes("UTF-8"));
        } catch (Exception e) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("write string error");
                AbstractC6403Nl2.d(e);
            }
        }
    }

    public void p() throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = this.d;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
                this.d = null;
            }
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
        try {
            DataInputStream dataInputStream = this.e;
            if (dataInputStream != null) {
                dataInputStream.close();
                this.e = null;
            }
        } catch (Exception e2) {
            AbstractC6403Nl2.d(e2);
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = this.b;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
                this.b = null;
            }
        } catch (Exception e3) {
            AbstractC6403Nl2.d(e3);
        }
        try {
            DataOutputStream dataOutputStream = this.c;
            if (dataOutputStream != null) {
                dataOutputStream.close();
                this.c = null;
            }
        } catch (Exception e4) {
            AbstractC6403Nl2.d(e4);
        }
    }

    public byte[] q() {
        return this.b.toByteArray();
    }

    public C23394wq6(byte[] bArr) {
        this.f = false;
        this.a = false;
        this.d = new ByteArrayInputStream(bArr);
        this.e = new DataInputStream(this.d);
        this.g = 0;
    }
}
