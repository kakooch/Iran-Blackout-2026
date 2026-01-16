package ir.nasim;

import android.graphics.drawable.Drawable;
import coil.memory.MemoryCache;

/* loaded from: classes2.dex */
public final class I07 extends Y23 {
    private final Drawable a;
    private final W23 b;
    private final EnumC21699tz1 c;
    private final MemoryCache.Key d;
    private final String e;
    private final boolean f;
    private final boolean g;

    public I07(Drawable drawable, W23 w23, EnumC21699tz1 enumC21699tz1, MemoryCache.Key key, String str, boolean z, boolean z2) {
        super(null);
        this.a = drawable;
        this.b = w23;
        this.c = enumC21699tz1;
        this.d = key;
        this.e = str;
        this.f = z;
        this.g = z2;
    }

    @Override // ir.nasim.Y23
    public Drawable a() {
        return this.a;
    }

    @Override // ir.nasim.Y23
    public W23 b() {
        return this.b;
    }

    public final EnumC21699tz1 c() {
        return this.c;
    }

    public final boolean d() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof I07) {
            I07 i07 = (I07) obj;
            if (AbstractC13042fc3.d(a(), i07.a()) && AbstractC13042fc3.d(b(), i07.b()) && this.c == i07.c && AbstractC13042fc3.d(this.d, i07.d) && AbstractC13042fc3.d(this.e, i07.e) && this.f == i07.f && this.g == i07.g) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((a().hashCode() * 31) + b().hashCode()) * 31) + this.c.hashCode()) * 31;
        MemoryCache.Key key = this.d;
        int iHashCode2 = (iHashCode + (key != null ? key.hashCode() : 0)) * 31;
        String str = this.e;
        return ((((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.f)) * 31) + Boolean.hashCode(this.g);
    }
}
