package ir.nasim;

import com.google.firebase.encoders.EncodingException;
import ir.nasim.InterfaceC4155Dx5;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.Hx5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C5106Hx5 implements InterfaceC19980rG4 {
    private static final Charset f = Charset.forName("UTF-8");
    private static final C24510yk2 g = C24510yk2.a("key").b(LL.b().c(1).a()).a();
    private static final C24510yk2 h = C24510yk2.a("value").b(LL.b().c(2).a()).a();
    private static final InterfaceC19389qG4 i = new InterfaceC19389qG4() { // from class: ir.nasim.Gx5
        @Override // ir.nasim.InterfaceC19389qG4
        public final void a(Object obj, Object obj2) {
            C5106Hx5.t((Map.Entry) obj, (InterfaceC19980rG4) obj2);
        }
    };
    private OutputStream a;
    private final Map b;
    private final Map c;
    private final InterfaceC19389qG4 d;
    private final C5808Kx5 e = new C5808Kx5(this);

    /* renamed from: ir.nasim.Hx5$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[InterfaceC4155Dx5.a.values().length];
            a = iArr;
            try {
                iArr[InterfaceC4155Dx5.a.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[InterfaceC4155Dx5.a.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[InterfaceC4155Dx5.a.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    C5106Hx5(OutputStream outputStream, Map map, Map map2, InterfaceC19389qG4 interfaceC19389qG4) {
        this.a = outputStream;
        this.b = map;
        this.c = map2;
        this.d = interfaceC19389qG4;
    }

    private static ByteBuffer m(int i2) {
        return ByteBuffer.allocate(i2).order(ByteOrder.LITTLE_ENDIAN);
    }

    private long n(InterfaceC19389qG4 interfaceC19389qG4, Object obj) throws IOException {
        C7025Py3 c7025Py3 = new C7025Py3();
        try {
            OutputStream outputStream = this.a;
            this.a = c7025Py3;
            try {
                interfaceC19389qG4.a(obj, this);
                this.a = outputStream;
                long jA = c7025Py3.a();
                c7025Py3.close();
                return jA;
            } catch (Throwable th) {
                this.a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                c7025Py3.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    private C5106Hx5 o(InterfaceC19389qG4 interfaceC19389qG4, C24510yk2 c24510yk2, Object obj, boolean z) throws IOException {
        long jN = n(interfaceC19389qG4, obj);
        if (z && jN == 0) {
            return this;
        }
        u((s(c24510yk2) << 3) | 2);
        v(jN);
        interfaceC19389qG4.a(obj, this);
        return this;
    }

    private C5106Hx5 p(InterfaceC17118mQ7 interfaceC17118mQ7, C24510yk2 c24510yk2, Object obj, boolean z) {
        this.e.b(c24510yk2, z);
        interfaceC17118mQ7.a(obj, this.e);
        return this;
    }

    private static InterfaceC4155Dx5 r(C24510yk2 c24510yk2) {
        InterfaceC4155Dx5 interfaceC4155Dx5 = (InterfaceC4155Dx5) c24510yk2.c(InterfaceC4155Dx5.class);
        if (interfaceC4155Dx5 != null) {
            return interfaceC4155Dx5;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static int s(C24510yk2 c24510yk2) {
        InterfaceC4155Dx5 interfaceC4155Dx5 = (InterfaceC4155Dx5) c24510yk2.c(InterfaceC4155Dx5.class);
        if (interfaceC4155Dx5 != null) {
            return interfaceC4155Dx5.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(Map.Entry entry, InterfaceC19980rG4 interfaceC19980rG4) {
        interfaceC19980rG4.c(g, entry.getKey());
        interfaceC19980rG4.c(h, entry.getValue());
    }

    private void u(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            this.a.write((i2 & 127) | 128);
            i2 >>>= 7;
        }
        this.a.write(i2 & 127);
    }

    private void v(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.a.write((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.a.write(((int) j) & 127);
    }

    @Override // ir.nasim.InterfaceC19980rG4
    public InterfaceC19980rG4 c(C24510yk2 c24510yk2, Object obj) {
        return g(c24510yk2, obj, true);
    }

    InterfaceC19980rG4 e(C24510yk2 c24510yk2, double d, boolean z) throws IOException {
        if (z && d == 0.0d) {
            return this;
        }
        u((s(c24510yk2) << 3) | 1);
        this.a.write(m(8).putDouble(d).array());
        return this;
    }

    InterfaceC19980rG4 f(C24510yk2 c24510yk2, float f2, boolean z) throws IOException {
        if (z && f2 == 0.0f) {
            return this;
        }
        u((s(c24510yk2) << 3) | 5);
        this.a.write(m(4).putFloat(f2).array());
        return this;
    }

    InterfaceC19980rG4 g(C24510yk2 c24510yk2, Object obj, boolean z) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            u((s(c24510yk2) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f);
            u(bytes.length);
            this.a.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                g(c24510yk2, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                o(i, c24510yk2, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            return e(c24510yk2, ((Double) obj).doubleValue(), z);
        }
        if (obj instanceof Float) {
            return f(c24510yk2, ((Float) obj).floatValue(), z);
        }
        if (obj instanceof Number) {
            return k(c24510yk2, ((Number) obj).longValue(), z);
        }
        if (obj instanceof Boolean) {
            return l(c24510yk2, ((Boolean) obj).booleanValue(), z);
        }
        if (!(obj instanceof byte[])) {
            InterfaceC19389qG4 interfaceC19389qG4 = (InterfaceC19389qG4) this.b.get(obj.getClass());
            if (interfaceC19389qG4 != null) {
                return o(interfaceC19389qG4, c24510yk2, obj, z);
            }
            InterfaceC17118mQ7 interfaceC17118mQ7 = (InterfaceC17118mQ7) this.c.get(obj.getClass());
            return interfaceC17118mQ7 != null ? p(interfaceC17118mQ7, c24510yk2, obj, z) : obj instanceof InterfaceC18026nx5 ? a(c24510yk2, ((InterfaceC18026nx5) obj).getNumber()) : obj instanceof Enum ? a(c24510yk2, ((Enum) obj).ordinal()) : o(this.d, c24510yk2, obj, z);
        }
        byte[] bArr = (byte[]) obj;
        if (z && bArr.length == 0) {
            return this;
        }
        u((s(c24510yk2) << 3) | 2);
        u(bArr.length);
        this.a.write(bArr);
        return this;
    }

    @Override // ir.nasim.InterfaceC19980rG4
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C5106Hx5 a(C24510yk2 c24510yk2, int i2) {
        return i(c24510yk2, i2, true);
    }

    C5106Hx5 i(C24510yk2 c24510yk2, int i2, boolean z) throws IOException {
        if (z && i2 == 0) {
            return this;
        }
        InterfaceC4155Dx5 interfaceC4155Dx5R = r(c24510yk2);
        int i3 = a.a[interfaceC4155Dx5R.intEncoding().ordinal()];
        if (i3 == 1) {
            u(interfaceC4155Dx5R.tag() << 3);
            u(i2);
        } else if (i3 == 2) {
            u(interfaceC4155Dx5R.tag() << 3);
            u((i2 << 1) ^ (i2 >> 31));
        } else if (i3 == 3) {
            u((interfaceC4155Dx5R.tag() << 3) | 5);
            this.a.write(m(4).putInt(i2).array());
        }
        return this;
    }

    @Override // ir.nasim.InterfaceC19980rG4
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C5106Hx5 b(C24510yk2 c24510yk2, long j) {
        return k(c24510yk2, j, true);
    }

    C5106Hx5 k(C24510yk2 c24510yk2, long j, boolean z) throws IOException {
        if (z && j == 0) {
            return this;
        }
        InterfaceC4155Dx5 interfaceC4155Dx5R = r(c24510yk2);
        int i2 = a.a[interfaceC4155Dx5R.intEncoding().ordinal()];
        if (i2 == 1) {
            u(interfaceC4155Dx5R.tag() << 3);
            v(j);
        } else if (i2 == 2) {
            u(interfaceC4155Dx5R.tag() << 3);
            v((j >> 63) ^ (j << 1));
        } else if (i2 == 3) {
            u((interfaceC4155Dx5R.tag() << 3) | 1);
            this.a.write(m(8).putLong(j).array());
        }
        return this;
    }

    C5106Hx5 l(C24510yk2 c24510yk2, boolean z, boolean z2) {
        return i(c24510yk2, z ? 1 : 0, z2);
    }

    C5106Hx5 q(Object obj) {
        if (obj == null) {
            return this;
        }
        InterfaceC19389qG4 interfaceC19389qG4 = (InterfaceC19389qG4) this.b.get(obj.getClass());
        if (interfaceC19389qG4 != null) {
            interfaceC19389qG4.a(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }
}
