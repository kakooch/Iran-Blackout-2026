package ir.nasim;

import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.r90, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC19912r90 implements InterfaceC4104Ds {
    final List a;

    AbstractC19912r90(List list) {
        this.a = list;
    }

    @Override // ir.nasim.InterfaceC4104Ds
    public boolean i() {
        if (this.a.isEmpty()) {
            return true;
        }
        return this.a.size() == 1 && ((C24561yp3) this.a.get(0)).i();
    }

    @Override // ir.nasim.InterfaceC4104Ds
    public List k() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }
}
