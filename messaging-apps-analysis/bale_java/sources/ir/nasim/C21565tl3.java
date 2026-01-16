package ir.nasim;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* renamed from: ir.nasim.tl3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C21565tl3 implements InterfaceC19980rG4, InterfaceC17709nQ7 {
    private C21565tl3 a = null;
    private boolean b = true;
    private final JsonWriter c;
    private final Map d;
    private final Map e;
    private final InterfaceC19389qG4 f;
    private final boolean g;

    C21565tl3(Writer writer, Map map, Map map2, InterfaceC19389qG4 interfaceC19389qG4, boolean z) {
        this.c = new JsonWriter(writer);
        this.d = map;
        this.e = map2;
        this.f = interfaceC19389qG4;
        this.g = z;
    }

    private boolean o(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    private C21565tl3 r(String str, Object obj) throws IOException {
        t();
        this.c.name(str);
        if (obj != null) {
            return h(obj, false);
        }
        this.c.nullValue();
        return this;
    }

    private C21565tl3 s(String str, Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        t();
        this.c.name(str);
        return h(obj, false);
    }

    private void t() throws IOException {
        if (!this.b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        C21565tl3 c21565tl3 = this.a;
        if (c21565tl3 != null) {
            c21565tl3.t();
            this.a.b = false;
            this.a = null;
            this.c.endObject();
        }
    }

    @Override // ir.nasim.InterfaceC19980rG4
    public InterfaceC19980rG4 a(C24510yk2 c24510yk2, int i) {
        return j(c24510yk2.b(), i);
    }

    @Override // ir.nasim.InterfaceC19980rG4
    public InterfaceC19980rG4 b(C24510yk2 c24510yk2, long j) {
        return k(c24510yk2.b(), j);
    }

    @Override // ir.nasim.InterfaceC19980rG4
    public InterfaceC19980rG4 c(C24510yk2 c24510yk2, Object obj) {
        return l(c24510yk2.b(), obj);
    }

    public C21565tl3 f(int i) throws IOException {
        t();
        this.c.value(i);
        return this;
    }

    public C21565tl3 g(long j) throws IOException {
        t();
        this.c.value(j);
        return this;
    }

    C21565tl3 h(Object obj, boolean z) {
        if (z && o(obj)) {
            throw new EncodingException(String.format("%s cannot be encoded inline", obj == null ? null : obj.getClass()));
        }
        if (obj == null) {
            this.c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.c.value((Number) obj);
            return this;
        }
        int i = 0;
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    h(it.next(), false);
                }
                this.c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        l((String) key, entry.getValue());
                    } catch (ClassCastException e) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                    }
                }
                this.c.endObject();
                return this;
            }
            InterfaceC19389qG4 interfaceC19389qG4 = (InterfaceC19389qG4) this.d.get(obj.getClass());
            if (interfaceC19389qG4 != null) {
                return q(interfaceC19389qG4, obj, z);
            }
            InterfaceC17118mQ7 interfaceC17118mQ7 = (InterfaceC17118mQ7) this.e.get(obj.getClass());
            if (interfaceC17118mQ7 != null) {
                interfaceC17118mQ7.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return q(this.f, obj, z);
            }
            d(((Enum) obj).name());
            return this;
        }
        if (obj instanceof byte[]) {
            return n((byte[]) obj);
        }
        this.c.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i < length) {
                this.c.value(r6[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                g(jArr[i]);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                this.c.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                this.c.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                h(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                h(obj2, false);
            }
        }
        this.c.endArray();
        return this;
    }

    @Override // ir.nasim.InterfaceC17709nQ7
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C21565tl3 d(String str) throws IOException {
        t();
        this.c.value(str);
        return this;
    }

    public C21565tl3 j(String str, int i) throws IOException {
        t();
        this.c.name(str);
        return f(i);
    }

    public C21565tl3 k(String str, long j) throws IOException {
        t();
        this.c.name(str);
        return g(j);
    }

    public C21565tl3 l(String str, Object obj) {
        return this.g ? s(str, obj) : r(str, obj);
    }

    @Override // ir.nasim.InterfaceC17709nQ7
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C21565tl3 e(boolean z) throws IOException {
        t();
        this.c.value(z);
        return this;
    }

    public C21565tl3 n(byte[] bArr) throws IOException {
        t();
        if (bArr == null) {
            this.c.nullValue();
        } else {
            this.c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    void p() {
        t();
        this.c.flush();
    }

    C21565tl3 q(InterfaceC19389qG4 interfaceC19389qG4, Object obj, boolean z) throws IOException {
        if (!z) {
            this.c.beginObject();
        }
        interfaceC19389qG4.a(obj, this);
        if (!z) {
            this.c.endObject();
        }
        return this;
    }
}
