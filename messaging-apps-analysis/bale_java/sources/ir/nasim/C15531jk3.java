package ir.nasim;

/* renamed from: ir.nasim.jk3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C15531jk3 {
    private final boolean a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final String g;
    private final boolean h;
    private final boolean i;
    private final String j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private EnumC24354yU0 o;

    public C15531jk3(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, boolean z7, boolean z8, String str2, boolean z9, boolean z10, InterfaceC7840Tk3 interfaceC7840Tk3, boolean z11, boolean z12, EnumC24354yU0 enumC24354yU0) {
        AbstractC13042fc3.i(str, "prettyPrintIndent");
        AbstractC13042fc3.i(str2, "classDiscriminator");
        AbstractC13042fc3.i(enumC24354yU0, "classDiscriminatorMode");
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = z6;
        this.g = str;
        this.h = z7;
        this.i = z8;
        this.j = str2;
        this.k = z9;
        this.l = z10;
        this.m = z11;
        this.n = z12;
        this.o = enumC24354yU0;
    }

    public final boolean a() {
        return this.k;
    }

    public final boolean b() {
        return this.d;
    }

    public final boolean c() {
        return this.n;
    }

    public final String d() {
        return this.j;
    }

    public final EnumC24354yU0 e() {
        return this.o;
    }

    public final boolean f() {
        return this.h;
    }

    public final boolean g() {
        return this.m;
    }

    public final boolean h() {
        return this.a;
    }

    public final boolean i() {
        return this.f;
    }

    public final boolean j() {
        return this.b;
    }

    public final InterfaceC7840Tk3 k() {
        return null;
    }

    public final boolean l() {
        return this.e;
    }

    public final String m() {
        return this.g;
    }

    public final boolean n() {
        return this.l;
    }

    public final boolean o() {
        return this.i;
    }

    public final boolean p() {
        return this.c;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.a + ", ignoreUnknownKeys=" + this.b + ", isLenient=" + this.c + ", allowStructuredMapKeys=" + this.d + ", prettyPrint=" + this.e + ", explicitNulls=" + this.f + ", prettyPrintIndent='" + this.g + "', coerceInputValues=" + this.h + ", useArrayPolymorphism=" + this.i + ", classDiscriminator='" + this.j + "', allowSpecialFloatingPointValues=" + this.k + ", useAlternativeNames=" + this.l + ", namingStrategy=" + ((Object) null) + ", decodeEnumsCaseInsensitive=" + this.m + ", allowTrailingComma=" + this.n + ", classDiscriminatorMode=" + this.o + ')';
    }

    public /* synthetic */ C15531jk3(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, boolean z7, boolean z8, String str2, boolean z9, boolean z10, InterfaceC7840Tk3 interfaceC7840Tk3, boolean z11, boolean z12, EnumC24354yU0 enumC24354yU0, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? true : z6, (i & 64) != 0 ? "    " : str, (i & 128) != 0 ? false : z7, (i & 256) != 0 ? false : z8, (i & 512) != 0 ? "type" : str2, (i & 1024) != 0 ? false : z9, (i & 2048) == 0 ? z10 : true, (i & 4096) != 0 ? null : interfaceC7840Tk3, (i & 8192) != 0 ? false : z11, (i & 16384) != 0 ? false : z12, (i & 32768) != 0 ? EnumC24354yU0.c : enumC24354yU0);
    }
}
