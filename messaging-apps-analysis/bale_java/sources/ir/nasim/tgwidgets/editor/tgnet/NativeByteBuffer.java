package ir.nasim.tgwidgets.editor.tgnet;

import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.T1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import org.xbill.DNS.Flags;

/* loaded from: classes7.dex */
public class NativeByteBuffer extends T1 {
    private static final ThreadLocal f = new a();
    protected long a;
    public ByteBuffer b;
    private boolean c;
    private int d;
    public boolean e = true;

    class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LinkedList initialValue() {
            return new LinkedList();
        }
    }

    private NativeByteBuffer(int i, boolean z) {
    }

    public static native long native_getFreeBuffer(int i);

    public static native ByteBuffer native_getJavaByteBuffer(long j);

    public static native int native_limit(long j);

    public static native int native_position(long j);

    public static native void native_reuse(long j);

    public static NativeByteBuffer u(long j) {
        if (j == 0) {
            return null;
        }
        NativeByteBuffer nativeByteBuffer = (NativeByteBuffer) ((LinkedList) f.get()).poll();
        if (nativeByteBuffer == null) {
            nativeByteBuffer = new NativeByteBuffer(0, true);
        }
        nativeByteBuffer.a = j;
        nativeByteBuffer.e = false;
        ByteBuffer byteBufferNative_getJavaByteBuffer = native_getJavaByteBuffer(j);
        nativeByteBuffer.b = byteBufferNative_getJavaByteBuffer;
        byteBufferNative_getJavaByteBuffer.limit(native_limit(j));
        int iNative_position = native_position(j);
        if (iNative_position <= nativeByteBuffer.b.limit()) {
            nativeByteBuffer.b.position(iNative_position);
        }
        nativeByteBuffer.b.order(ByteOrder.LITTLE_ENDIAN);
        return nativeByteBuffer;
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
    public byte b(boolean z) {
        try {
            return this.b.get();
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
    public byte[] c(boolean z) {
        int i;
        try {
            int iP = p(this.b.get());
            if (iP >= 254) {
                iP = p(this.b.get()) | (p(this.b.get()) << 8) | (p(this.b.get()) << 16);
                i = 4;
            } else {
                i = 1;
            }
            byte[] bArr = new byte[iP];
            this.b.get(bArr);
            while ((iP + i) % 4 != 0) {
                this.b.get();
                i++;
            }
            return bArr;
        } catch (Exception e) {
            if (z) {
                throw new RuntimeException("read byte array error", e);
            }
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("read byte array error");
                AbstractC6403Nl2.d(e);
            }
            return new byte[0];
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
        try {
            return this.b.getInt();
        } catch (Exception e) {
            if (z) {
                throw new RuntimeException("read int32 error", e);
            }
            if (!AbstractC8814Xl0.b) {
                return 0;
            }
            AbstractC6403Nl2.b("read int32 error");
            AbstractC6403Nl2.d(e);
            return 0;
        }
    }

    @Override // ir.nasim.T1
    public long f(boolean z) {
        try {
            return this.b.getLong();
        } catch (Exception e) {
            if (z) {
                throw new RuntimeException("read int64 error", e);
            }
            if (!AbstractC8814Xl0.b) {
                return 0L;
            }
            AbstractC6403Nl2.b("read int64 error");
            AbstractC6403Nl2.d(e);
            return 0L;
        }
    }

    protected void finalize() throws Throwable {
        if (!this.e) {
            t();
        }
        super.finalize();
    }

    @Override // ir.nasim.T1
    public String g(boolean z) {
        int i;
        int iQ = q();
        try {
            int iP = p(this.b.get());
            if (iP >= 254) {
                iP = p(this.b.get()) | (p(this.b.get()) << 8) | (p(this.b.get()) << 16);
                i = 4;
            } else {
                i = 1;
            }
            byte[] bArr = new byte[iP];
            this.b.get(bArr);
            while ((iP + i) % 4 != 0) {
                this.b.get();
                i++;
            }
            return new String(bArr, "UTF-8");
        } catch (Exception e) {
            if (z) {
                throw new RuntimeException("read string error", e);
            }
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("read string error");
                AbstractC6403Nl2.d(e);
            }
            s(iQ);
            return "";
        }
    }

    @Override // ir.nasim.T1
    public int h() {
        return this.b.remaining();
    }

    @Override // ir.nasim.T1
    public void i(boolean z) {
        if (this.c) {
            this.d += 4;
        } else if (z) {
            m(-1720552011);
        } else {
            m(-1132882121);
        }
    }

    @Override // ir.nasim.T1
    public void j(byte b) {
        try {
            if (this.c) {
                this.d++;
            } else {
                this.b.put(b);
            }
        } catch (Exception e) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("write byte error");
                AbstractC6403Nl2.d(e);
            }
        }
    }

    @Override // ir.nasim.T1
    public void k(byte[] bArr) {
        try {
            if (bArr.length <= 253) {
                if (this.c) {
                    this.d++;
                } else {
                    this.b.put((byte) bArr.length);
                }
            } else if (this.c) {
                this.d += 4;
            } else {
                this.b.put((byte) -2);
                this.b.put((byte) bArr.length);
                this.b.put((byte) (bArr.length >> 8));
                this.b.put((byte) (bArr.length >> 16));
            }
            if (this.c) {
                this.d += bArr.length;
            } else {
                this.b.put(bArr);
            }
            for (int i = bArr.length <= 253 ? 1 : 4; (bArr.length + i) % 4 != 0; i++) {
                if (this.c) {
                    this.d++;
                } else {
                    this.b.put((byte) 0);
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
    public void m(int i) {
        try {
            if (this.c) {
                this.d += 4;
            } else {
                this.b.putInt(i);
            }
        } catch (Exception e) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("write int32 error");
                AbstractC6403Nl2.d(e);
            }
        }
    }

    @Override // ir.nasim.T1
    public void n(long j) {
        try {
            if (this.c) {
                this.d += 8;
            } else {
                this.b.putLong(j);
            }
        } catch (Exception e) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("write int64 error");
                AbstractC6403Nl2.d(e);
            }
        }
    }

    @Override // ir.nasim.T1
    public void o(String str) {
        if (str == null) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("write string null");
                AbstractC6403Nl2.d(new Throwable());
            }
            str = "";
        }
        try {
            k(str.getBytes("UTF-8"));
        } catch (Exception e) {
            if (AbstractC8814Xl0.b) {
                AbstractC6403Nl2.b("write string error");
                AbstractC6403Nl2.d(e);
            }
        }
    }

    public int p(byte b) {
        return b >= 0 ? b : b + Flags.QR;
    }

    public int q() {
        return this.b.position();
    }

    public boolean r() {
        return this.b.hasRemaining();
    }

    public void s(int i) {
        this.b.position(i);
    }

    public void t() {
        if (this.a != 0) {
            ((LinkedList) f.get()).add(this);
            this.e = true;
            native_reuse(this.a);
        }
    }
}
