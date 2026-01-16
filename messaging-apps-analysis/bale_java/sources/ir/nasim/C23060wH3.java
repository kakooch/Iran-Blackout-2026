package ir.nasim;

/* renamed from: ir.nasim.wH3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23060wH3 {
    private final boolean a;
    private final String b;
    private final EnumC23021wD0 c;
    private final AS7 d;

    public C23060wH3(boolean z, String str, EnumC23021wD0 enumC23021wD0, AS7 as7) {
        AbstractC13042fc3.i(as7, "captureParams");
        this.a = z;
        this.b = str;
        this.c = enumC23021wD0;
        this.d = as7;
    }

    public static /* synthetic */ C23060wH3 b(C23060wH3 c23060wH3, boolean z, String str, EnumC23021wD0 enumC23021wD0, AS7 as7, int i, Object obj) {
        if ((i & 1) != 0) {
            z = c23060wH3.a;
        }
        if ((i & 2) != 0) {
            str = c23060wH3.b;
        }
        if ((i & 4) != 0) {
            enumC23021wD0 = c23060wH3.c;
        }
        if ((i & 8) != 0) {
            as7 = c23060wH3.d;
        }
        return c23060wH3.a(z, str, enumC23021wD0, as7);
    }

    public final C23060wH3 a(boolean z, String str, EnumC23021wD0 enumC23021wD0, AS7 as7) {
        AbstractC13042fc3.i(as7, "captureParams");
        return new C23060wH3(z, str, enumC23021wD0, as7);
    }

    public final AS7 c() {
        return this.d;
    }

    public final String d() {
        return this.b;
    }

    public final EnumC23021wD0 e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23060wH3)) {
            return false;
        }
        C23060wH3 c23060wH3 = (C23060wH3) obj;
        return this.a == c23060wH3.a && AbstractC13042fc3.d(this.b, c23060wH3.b) && this.c == c23060wH3.c && AbstractC13042fc3.d(this.d, c23060wH3.d);
    }

    public final boolean f() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.a) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        EnumC23021wD0 enumC23021wD0 = this.c;
        return ((iHashCode2 + (enumC23021wD0 != null ? enumC23021wD0.hashCode() : 0)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "LocalVideoTrackOptions(isScreencast=" + this.a + ", deviceId=" + this.b + ", position=" + this.c + ", captureParams=" + this.d + ')';
    }

    public /* synthetic */ C23060wH3(boolean z, String str, EnumC23021wD0 enumC23021wD0, AS7 as7, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? EnumC23021wD0.a : enumC23021wD0, (i & 8) != 0 ? EnumC17154mU7.h.a() : as7);
    }
}
