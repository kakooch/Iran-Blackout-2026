package ir.nasim;

import android.content.Context;
import java.util.Objects;

/* renamed from: ir.nasim.Ki4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5672Ki4 extends E50 {
    private final C14517i30 c;
    private final C14517i30 d;
    private final long e;
    private final long f;
    private final long g;
    private final String h;
    private final long i;
    private final Integer j;

    public C5672Ki4(C11909dl1 c11909dl1) {
        super(c11909dl1);
        C12629ew c12629ew = (C12629ew) ((C12038dw) c11909dl1.c()).u();
        this.c = new C14517i30(c12629ew.D());
        this.d = new C14517i30(c12629ew.y());
        this.e = c12629ew.C();
        this.f = c12629ew.F();
        this.g = c12629ew.E();
        this.h = c12629ew.w();
        this.i = c12629ew.z();
        this.j = c12629ew.u();
    }

    @Override // ir.nasim.E50, ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return context.getString(AbstractC12217eE5.message_holder_content_bank_transaction);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C5672Ki4 c5672Ki4 = (C5672Ki4) obj;
        return this.e == c5672Ki4.e && this.f == c5672Ki4.f && this.g == c5672Ki4.g && this.i == c5672Ki4.i && Objects.equals(this.c, c5672Ki4.c) && Objects.equals(this.d, c5672Ki4.d) && Objects.equals(this.h, c5672Ki4.h) && Objects.equals(this.j, c5672Ki4.j);
    }

    public int hashCode() {
        return Objects.hash(this.c, this.d, Long.valueOf(this.e), Long.valueOf(this.f), Long.valueOf(this.g), this.h, Long.valueOf(this.i), this.j);
    }

    public Integer r() {
        return this.j;
    }

    public String s() {
        return this.h;
    }

    public C14517i30 t() {
        return this.d;
    }

    public C14517i30 u() {
        return this.c;
    }

    public long v() {
        return this.g;
    }

    public long w() {
        return this.f;
    }

    public long x() {
        return this.i;
    }

    public long y() {
        return this.e;
    }
}
