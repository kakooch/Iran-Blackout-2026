package ir.nasim;

import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: ir.nasim.rV2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C20113rV2 extends D0 {
    private C20722sV2 j;

    public C20113rV2() {
        super("hvcC");
        this.j = new C20722sV2();
    }

    @Override // ir.nasim.D0
    protected void a(ByteBuffer byteBuffer) {
        this.j.d(byteBuffer);
    }

    @Override // ir.nasim.D0
    protected void b(ByteBuffer byteBuffer) {
        this.j.r(byteBuffer);
    }

    @Override // ir.nasim.D0
    protected long c() {
        return this.j.c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C20722sV2 c20722sV2 = this.j;
        C20722sV2 c20722sV22 = ((C20113rV2) obj).j;
        return c20722sV2 == null ? c20722sV22 == null : c20722sV2.equals(c20722sV22);
    }

    public int hashCode() {
        C20722sV2 c20722sV2 = this.j;
        if (c20722sV2 != null) {
            return c20722sV2.hashCode();
        }
        return 0;
    }

    public List n() {
        return this.j.w;
    }

    public C20722sV2 o() {
        return this.j;
    }
}
