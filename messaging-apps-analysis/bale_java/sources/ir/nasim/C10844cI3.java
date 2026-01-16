package ir.nasim;

import android.content.Context;
import java.util.Objects;

/* renamed from: ir.nasim.cI3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C10844cI3 extends AbstractC17457n0 {
    private double c;
    private double d;
    private String e;
    private String f;
    private String g;

    public C10844cI3(C11909dl1 c11909dl1) {
        super(c11909dl1);
        this.g = ((C8664Wy) c11909dl1.c()).u();
        C19231q00 c19231q00 = new C19231q00(new C19231q00(this.g).g("data").o().L("location").o());
        this.c = c19231q00.j("latitude", 0.0d);
        this.d = c19231q00.j("longitude", 0.0d);
        this.e = c19231q00.o("street", "");
        this.f = c19231q00.o("place", "");
    }

    public static C10844cI3 r(double d, double d2, String str, String str2) {
        try {
            C19231q00 c19231q00 = new C19231q00();
            c19231q00.f("dataType", "location");
            C19231q00 c19231q002 = new C19231q00();
            c19231q002.e("latitude", Double.valueOf(d2));
            c19231q002.e("longitude", Double.valueOf(d));
            if (str != null) {
                c19231q002.f("street", str);
            }
            if (str2 != null) {
                c19231q002.f("place", str2);
            }
            C19231q00 c19231q003 = new C19231q00();
            c19231q003.d("location", c19231q002.l());
            c19231q00.d("data", c19231q003.l());
            return new C10844cI3(new C11909dl1(new C8664Wy(c19231q00.toString())));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return context.getString(AbstractC12217eE5.message_holder_content_location);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C10844cI3 c10844cI3 = (C10844cI3) obj;
        return Double.compare(this.c, c10844cI3.c) == 0 && Double.compare(this.d, c10844cI3.d) == 0 && Objects.equals(this.e, c10844cI3.e) && Objects.equals(this.f, c10844cI3.f) && Objects.equals(this.g, c10844cI3.g);
    }

    public int hashCode() {
        return Objects.hash(Double.valueOf(this.c), Double.valueOf(this.d), this.e, this.f, this.g);
    }

    @Override // ir.nasim.AbstractC17457n0
    public String j(Context context) {
        return context.getString(AbstractC12217eE5.media_location);
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }

    public double s() {
        return this.c;
    }

    public double t() {
        return this.d;
    }

    public String u() {
        return this.g;
    }

    public String v() {
        return this.e;
    }
}
