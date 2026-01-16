package ir.nasim;

/* renamed from: ir.nasim.Mp4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6202Mp4 {
    private Boolean a = Boolean.valueOf(C5495Jo7.a.J2());
    private int[] b;

    public C6202Mp4() {
        b();
    }

    private void b() {
        if (C5495Jo7.a.J2()) {
            this.b = new int[]{KB5.dark_pattern};
        } else {
            this.b = new int[]{KB5.bg_00, KB5.bg_01, KB5.bg_02, KB5.bg_03, KB5.bg_04, KB5.bg_05, KB5.bg_06, KB5.bg_07, KB5.bg_08, KB5.bg_09};
        }
    }

    public int[] a() {
        boolean zBooleanValue = this.a.booleanValue();
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        if (zBooleanValue != c5495Jo7.J2()) {
            b();
            this.a = Boolean.valueOf(c5495Jo7.J2());
        }
        return this.b;
    }
}
