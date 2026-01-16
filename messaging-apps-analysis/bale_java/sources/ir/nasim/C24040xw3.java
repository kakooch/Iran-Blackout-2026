package ir.nasim;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.xw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C24040xw3 implements InterfaceC23450ww3, InterfaceC12377eW3 {
    private final C19197pw3 a;
    private final UZ6 b;
    private final InterfaceC20397rw3 c;
    private final C16734lm4 d = AbstractC21388ta3.c();

    public C24040xw3(C19197pw3 c19197pw3, UZ6 uz6) {
        this.a = c19197pw3;
        this.b = uz6;
        this.c = (InterfaceC20397rw3) c19197pw3.d().invoke();
    }

    @Override // ir.nasim.WH1
    public int A1(long j) {
        return this.b.A1(j);
    }

    @Override // ir.nasim.WH1
    public int B0(float f) {
        return this.b.B0(f);
    }

    @Override // ir.nasim.InterfaceC23450ww3, ir.nasim.WH1
    public float D(int i) {
        return this.b.D(i);
    }

    @Override // ir.nasim.InterfaceC12377eW3
    public InterfaceC11734dW3 E0(int i, int i2, Map map, UA2 ua2, UA2 ua22) {
        return this.b.E0(i, i2, map, ua2, ua22);
    }

    @Override // ir.nasim.WH1
    public float I0(long j) {
        return this.b.I0(j);
    }

    @Override // ir.nasim.WH1
    public long I1(long j) {
        return this.b.I1(j);
    }

    @Override // ir.nasim.InterfaceC12377eW3
    public InterfaceC11734dW3 P1(int i, int i2, Map map, UA2 ua2) {
        return this.b.P1(i, i2, map, ua2);
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public long T(float f) {
        return this.b.T(f);
    }

    @Override // ir.nasim.WH1
    public long U(long j) {
        return this.b.U(j);
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float Y(long j) {
        return this.b.Y(j);
    }

    @Override // ir.nasim.WH1
    public float getDensity() {
        return this.b.getDensity();
    }

    @Override // ir.nasim.InterfaceC10436bc3
    public EnumC12613eu3 getLayoutDirection() {
        return this.b.getLayoutDirection();
    }

    @Override // ir.nasim.WH1
    public long j0(float f) {
        return this.b.j0(f);
    }

    @Override // ir.nasim.InterfaceC23450ww3
    public List n0(int i, long j) {
        List list = (List) this.d.b(i);
        if (list != null) {
            return list;
        }
        Object objD = this.c.d(i);
        List listL0 = this.b.L0(objD, this.a.b(i, objD, this.c.f(i)));
        int size = listL0.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((ZV3) listL0.get(i2)).l0(j));
        }
        this.d.r(i, arrayList);
        return arrayList;
    }

    @Override // ir.nasim.WH1
    public float o1(float f) {
        return this.b.o1(f);
    }

    @Override // ir.nasim.InterfaceC10436bc3
    public boolean s0() {
        return this.b.s0();
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float t1() {
        return this.b.t1();
    }

    @Override // ir.nasim.WH1
    public float w1(float f) {
        return this.b.w1(f);
    }
}
