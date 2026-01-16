package ir.nasim;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class X06 {
    private final String a;
    private final byte[] b;
    private final int c;
    private C12092e16[] d;
    private final EnumC9549a90 e;
    private Map f;
    private final long g;

    public X06(String str, byte[] bArr, C12092e16[] c12092e16Arr, EnumC9549a90 enumC9549a90) {
        this(str, bArr, c12092e16Arr, enumC9549a90, System.currentTimeMillis());
    }

    public void a(C12092e16[] c12092e16Arr) {
        C12092e16[] c12092e16Arr2 = this.d;
        if (c12092e16Arr2 == null) {
            this.d = c12092e16Arr;
            return;
        }
        if (c12092e16Arr == null || c12092e16Arr.length <= 0) {
            return;
        }
        C12092e16[] c12092e16Arr3 = new C12092e16[c12092e16Arr2.length + c12092e16Arr.length];
        System.arraycopy(c12092e16Arr2, 0, c12092e16Arr3, 0, c12092e16Arr2.length);
        System.arraycopy(c12092e16Arr, 0, c12092e16Arr3, c12092e16Arr2.length, c12092e16Arr.length);
        this.d = c12092e16Arr3;
    }

    public EnumC9549a90 b() {
        return this.e;
    }

    public byte[] c() {
        return this.b;
    }

    public Map d() {
        return this.f;
    }

    public C12092e16[] e() {
        return this.d;
    }

    public String f() {
        return this.a;
    }

    public void g(Map map) {
        if (map != null) {
            Map map2 = this.f;
            if (map2 == null) {
                this.f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(EnumC11449d16 enumC11449d16, Object obj) {
        if (this.f == null) {
            this.f = new EnumMap(EnumC11449d16.class);
        }
        this.f.put(enumC11449d16, obj);
    }

    public String toString() {
        return this.a;
    }

    public X06(String str, byte[] bArr, C12092e16[] c12092e16Arr, EnumC9549a90 enumC9549a90, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, c12092e16Arr, enumC9549a90, j);
    }

    public X06(String str, byte[] bArr, int i, C12092e16[] c12092e16Arr, EnumC9549a90 enumC9549a90, long j) {
        this.a = str;
        this.b = bArr;
        this.c = i;
        this.d = c12092e16Arr;
        this.e = enumC9549a90;
        this.f = null;
        this.g = j;
    }
}
