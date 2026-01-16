package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public abstract class i {
    public static final byte[] a;
    public static final ByteBuffer b;

    public interface a {
        int getNumber();
    }

    public interface b {
        a a(int i);
    }

    static {
        byte[] bArr = new byte[0];
        a = bArr;
        b = ByteBuffer.wrap(bArr);
    }

    public static boolean a(byte[] bArr) {
        return o.e(bArr);
    }

    public static String b(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }
}
