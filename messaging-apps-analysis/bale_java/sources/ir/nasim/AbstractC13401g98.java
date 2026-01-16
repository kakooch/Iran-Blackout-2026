package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.g98, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13401g98 extends C16651le1 {
    public ArrayList V0;

    public AbstractC13401g98() {
        this.V0 = new ArrayList();
    }

    public void a(C16651le1 c16651le1) {
        this.V0.add(c16651le1);
        if (c16651le1.N() != null) {
            ((AbstractC13401g98) c16651le1.N()).s1(c16651le1);
        }
        c16651le1.b1(this);
    }

    public ArrayList q1() {
        return this.V0;
    }

    public abstract void r1();

    public void s1(C16651le1 c16651le1) {
        this.V0.remove(c16651le1);
        c16651le1.u0();
    }

    public void t1() {
        this.V0.clear();
    }

    @Override // ir.nasim.C16651le1
    public void u0() {
        this.V0.clear();
        super.u0();
    }

    @Override // ir.nasim.C16651le1
    public void y0(C13196fp0 c13196fp0) {
        super.y0(c13196fp0);
        int size = this.V0.size();
        for (int i = 0; i < size; i++) {
            ((C16651le1) this.V0.get(i)).y0(c13196fp0);
        }
    }

    public AbstractC13401g98(int i, int i2) {
        super(i, i2);
        this.V0 = new ArrayList();
    }
}
