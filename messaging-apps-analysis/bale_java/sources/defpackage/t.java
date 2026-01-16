package defpackage;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC4326Eq5;
import ir.nasim.C19206px3;
import ir.nasim.DJ0;
import ir.nasim.InterfaceC14354hm4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC17639nJ0;
import ir.nasim.InterfaceC7948Tw3;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.SA2;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class t {
    private final int a;
    private final C19206px3 b;
    private final InterfaceC14603iB2 c;
    private final SA2 d;
    private final InterfaceC9102Ym4 e;
    private final InterfaceC14354hm4 f;
    private final InterfaceC17639nJ0 g;
    private InterfaceC7948Tw3 h;

    public t(int i, C19206px3 c19206px3, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2) {
        AbstractC13042fc3.i(c19206px3, "stateList");
        AbstractC13042fc3.i(interfaceC14603iB2, "onMove");
        this.a = i;
        this.b = c19206px3;
        this.c = interfaceC14603iB2;
        this.d = sa2;
        this.e = AbstractC13472gH6.d(null, null, 2, null);
        this.f = AbstractC4326Eq5.a(0.0f);
        this.g = DJ0.b(0, null, null, 7, null);
    }

    public final float a() {
        return this.f.a();
    }

    public final Integer b() {
        return (Integer) this.e.getValue();
    }

    public final InterfaceC17639nJ0 c() {
        return this.g;
    }

    public final void d(long j) {
        Object next;
        g(a() + Float.intBitsToFloat((int) (j & 4294967295L)));
        Integer numB = b();
        if (numB != null) {
            int iIntValue = numB.intValue();
            InterfaceC7948Tw3 interfaceC7948Tw3 = this.h;
            if (interfaceC7948Tw3 == null) {
                return;
            }
            float offset = interfaceC7948Tw3.getOffset() + a();
            float offset2 = interfaceC7948Tw3.getOffset() + interfaceC7948Tw3.f() + a();
            float f = ((offset2 - offset) / 2) + offset;
            Iterator it = this.b.x().i().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                InterfaceC7948Tw3 interfaceC7948Tw32 = (InterfaceC7948Tw3) next;
                int offset3 = interfaceC7948Tw32.getOffset();
                int offset4 = interfaceC7948Tw32.getOffset() + interfaceC7948Tw32.f();
                int i = (int) f;
                if (offset3 <= i && i <= offset4 && interfaceC7948Tw3.getIndex() != interfaceC7948Tw32.getIndex() && (interfaceC7948Tw32.getContentType() instanceof v)) {
                    break;
                }
            }
            InterfaceC7948Tw3 interfaceC7948Tw33 = (InterfaceC7948Tw3) next;
            if (interfaceC7948Tw33 != null) {
                Object contentType = interfaceC7948Tw33.getContentType();
                AbstractC13042fc3.g(contentType, "null cannot be cast to non-null type <root>.DraggableItem");
                int iA = ((v) contentType).a();
                this.c.invoke(numB, Integer.valueOf(iA));
                h(Integer.valueOf(iA));
                g(a() + (interfaceC7948Tw3.getOffset() - interfaceC7948Tw33.getOffset()));
                this.h = interfaceC7948Tw33;
                return;
            }
            float f2 = offset - this.b.x().f();
            float fD = offset2 - this.b.x().d();
            float fH = f2 < 0.0f ? AbstractC23053wG5.h(f2, 0.0f) : fD > 0.0f ? AbstractC23053wG5.d(fD, 0.0f) : 0.0f;
            if (fH == 0.0f || iIntValue == 0 || iIntValue == this.a - 1) {
                return;
            }
            this.g.h(Float.valueOf(fH));
        }
    }

    public final void e() {
        this.h = null;
        h(null);
        g(0.0f);
        SA2 sa2 = this.d;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    public final void f(long j) {
        Object next;
        Iterator it = this.b.x().i().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            InterfaceC7948Tw3 interfaceC7948Tw3 = (InterfaceC7948Tw3) next;
            int offset = interfaceC7948Tw3.getOffset();
            int offset2 = interfaceC7948Tw3.getOffset() + interfaceC7948Tw3.f();
            int iIntBitsToFloat = (int) Float.intBitsToFloat((int) (4294967295L & j));
            if (offset <= iIntBitsToFloat && iIntBitsToFloat <= offset2) {
                break;
            }
        }
        InterfaceC7948Tw3 interfaceC7948Tw32 = (InterfaceC7948Tw3) next;
        if (interfaceC7948Tw32 != null) {
            Object contentType = interfaceC7948Tw32.getContentType();
            v vVar = contentType instanceof v ? (v) contentType : null;
            if (vVar != null) {
                this.h = interfaceC7948Tw32;
                h(Integer.valueOf(vVar.a()));
            }
        }
    }

    public final void g(float f) {
        this.f.s(f);
    }

    public final void h(Integer num) {
        this.e.setValue(num);
    }
}
