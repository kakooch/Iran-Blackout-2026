package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.Bitmap;

/* renamed from: ir.nasim.Wl4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8552Wl4 extends VL {
    private String e;
    private T74 f;
    private String g;
    private String h;
    private final long i;
    private Bitmap j;
    private final J44 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8552Wl4(String str, T74 t74, String str2, String str3, long j, Bitmap bitmap, J44 j44) {
        super(str, t74, j44, j, null);
        AbstractC13042fc3.i(str, "filePath");
        AbstractC13042fc3.i(t74, "messageId");
        AbstractC13042fc3.i(str2, "artistName");
        AbstractC13042fc3.i(str3, "trackName");
        this.e = str;
        this.f = t74;
        this.g = str2;
        this.h = str3;
        this.i = j;
        this.j = bitmap;
        this.k = j44;
    }

    @Override // ir.nasim.VL
    public J44 a() {
        return this.k;
    }

    @Override // ir.nasim.VL
    public long b() {
        return this.i;
    }

    @Override // ir.nasim.VL
    public String c() {
        return this.e;
    }

    @Override // ir.nasim.VL
    public T74 d() {
        return this.f;
    }

    @Override // ir.nasim.VL
    public void e(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.e = str;
    }

    @Override // ir.nasim.VL
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final C8552Wl4 f(String str, T74 t74, String str2, String str3, long j, Bitmap bitmap, J44 j44) {
        AbstractC13042fc3.i(str, "filePath");
        AbstractC13042fc3.i(t74, "messageId");
        AbstractC13042fc3.i(str2, "artistName");
        AbstractC13042fc3.i(str3, "trackName");
        return new C8552Wl4(str, t74, str2, str3, j, bitmap, j44);
    }

    public final String h() {
        return this.g;
    }

    @Override // ir.nasim.VL
    public int hashCode() {
        return super.hashCode();
    }

    public final Bitmap i() {
        return this.j;
    }

    public final String j() {
        return this.h;
    }

    public final void k(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.g = str;
    }

    public final void l(Bitmap bitmap) {
        this.j = bitmap;
    }

    public final void m(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.h = str;
    }

    public String toString() {
        return "Music(filePath=" + this.e + ", messageId=" + this.f + ", artistName=" + this.g + ", trackName=" + this.h + ", duration=" + this.i + ", cover=" + this.j + ", currentMessage=" + this.k + Separators.RPAREN;
    }
}
