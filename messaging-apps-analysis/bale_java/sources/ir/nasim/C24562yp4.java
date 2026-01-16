package ir.nasim;

import android.content.Context;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: ir.nasim.yp4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C24562yp4 extends AbstractC17457n0 {
    private byte[] c;
    private byte[] d;
    private byte[] e;
    private int f;

    public C24562yp4(C11909dl1 c11909dl1) {
        super(c11909dl1);
        this.c = ((C8205Uz) c11909dl1.c()).u();
        this.d = ((C8205Uz) c11909dl1.c()).w();
        this.e = ((C8205Uz) c11909dl1.c()).z();
        this.f = ((C8205Uz) c11909dl1.c()).y();
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return InterfaceC25103zk1.e(context);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C24562yp4 c24562yp4 = (C24562yp4) obj;
        return this.f == c24562yp4.f && Objects.deepEquals(this.c, c24562yp4.c) && Objects.deepEquals(this.d, c24562yp4.d) && Objects.deepEquals(this.e, c24562yp4.e);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.c)), Integer.valueOf(Arrays.hashCode(this.d)), Integer.valueOf(Arrays.hashCode(this.e)), Integer.valueOf(this.f));
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }
}
