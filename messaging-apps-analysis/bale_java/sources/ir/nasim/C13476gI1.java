package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.gI1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13476gI1 implements InterfaceC10842cI1 {
    AbstractC15192j98 d;
    int f;
    public int g;
    public InterfaceC10842cI1 a = null;
    public boolean b = false;
    public boolean c = false;
    a e = a.UNKNOWN;
    int h = 1;
    GT1 i = null;
    public boolean j = false;
    List k = new ArrayList();
    List l = new ArrayList();

    /* renamed from: ir.nasim.gI1$a */
    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public C13476gI1(AbstractC15192j98 abstractC15192j98) {
        this.d = abstractC15192j98;
    }

    @Override // ir.nasim.InterfaceC10842cI1
    public void a(InterfaceC10842cI1 interfaceC10842cI1) {
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            if (!((C13476gI1) it.next()).j) {
                return;
            }
        }
        this.c = true;
        InterfaceC10842cI1 interfaceC10842cI12 = this.a;
        if (interfaceC10842cI12 != null) {
            interfaceC10842cI12.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        C13476gI1 c13476gI1 = null;
        int i = 0;
        for (C13476gI1 c13476gI12 : this.l) {
            if (!(c13476gI12 instanceof GT1)) {
                i++;
                c13476gI1 = c13476gI12;
            }
        }
        if (c13476gI1 != null && i == 1 && c13476gI1.j) {
            GT1 gt1 = this.i;
            if (gt1 != null) {
                if (!gt1.j) {
                    return;
                } else {
                    this.f = this.h * gt1.g;
                }
            }
            d(c13476gI1.g + this.f);
        }
        InterfaceC10842cI1 interfaceC10842cI13 = this.a;
        if (interfaceC10842cI13 != null) {
            interfaceC10842cI13.a(this);
        }
    }

    public void b(InterfaceC10842cI1 interfaceC10842cI1) {
        this.k.add(interfaceC10842cI1);
        if (this.j) {
            interfaceC10842cI1.a(interfaceC10842cI1);
        }
    }

    public void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        for (InterfaceC10842cI1 interfaceC10842cI1 : this.k) {
            interfaceC10842cI1.a(interfaceC10842cI1);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.v());
        sb.append(":");
        sb.append(this.e);
        sb.append(Separators.LPAREN);
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(Separators.GREATER_THAN);
        return sb.toString();
    }
}
