package ir.nasim;

import java.util.Date;

/* loaded from: classes6.dex */
public class I45 implements S45 {
    private D45 a = new D45();

    private String j() {
        return this.a.m();
    }

    private String k() {
        return this.a.M();
    }

    @Override // ir.nasim.S45
    public void a(Long l) {
        this.a = new D45(l);
    }

    @Override // ir.nasim.S45
    public int b() {
        return this.a.A();
    }

    @Override // ir.nasim.S45
    public void c(int i, int i2, int i3) {
        try {
            this.a.V(i);
            this.a.U(i2);
            this.a.T(i3);
        } catch (Exception e) {
            C19406qI3.d("PersianDateImpl", e);
        }
    }

    @Override // ir.nasim.S45
    public D45 d() {
        return this.a;
    }

    @Override // ir.nasim.S45
    public int e() {
        return this.a.B();
    }

    @Override // ir.nasim.S45
    public void f(Date date) {
        this.a = new D45(date);
    }

    @Override // ir.nasim.S45
    public Date g() {
        return this.a.W();
    }

    @Override // ir.nasim.S45
    public long getTimestamp() {
        return this.a.E().longValue();
    }

    @Override // ir.nasim.S45
    public String h() {
        return j() + "  " + b() + "  " + k() + "  " + i();
    }

    @Override // ir.nasim.S45
    public int i() {
        return this.a.C();
    }
}
