package ir.nasim;

import android.net.Uri;

/* renamed from: ir.nasim.ui8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C22130ui8 {
    private final String a;
    private final Uri b;
    private final String c;
    private final String d;
    private final boolean e;
    private final boolean f;

    public C22130ui8(Uri uri) {
        this(null, uri, "", "", false, false);
    }

    public final Bh8 a(String str, Object obj, InterfaceC20262ri8 interfaceC20262ri8) {
        return Bh8.c(this, str, obj, interfaceC20262ri8);
    }

    public final Bh8 b(String str, String str2) {
        return Bh8.d(this, str, null);
    }

    public final Bh8 e(String str, boolean z) {
        return Bh8.e(this, str, false);
    }

    public final C22130ui8 f(String str) {
        boolean z = this.e;
        if (z) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        return new C22130ui8(this.a, this.b, str, this.d, z, this.f);
    }

    public final C22130ui8 h(String str) {
        return new C22130ui8(this.a, this.b, this.c, str, this.e, this.f);
    }

    private C22130ui8(String str, Uri uri, String str2, String str3, boolean z, boolean z2) {
        this.a = str;
        this.b = uri;
        this.c = str2;
        this.d = str3;
        this.e = z;
        this.f = z2;
    }
}
