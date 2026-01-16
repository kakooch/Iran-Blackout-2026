package ir.nasim;

/* renamed from: ir.nasim.Wt0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8620Wt0 extends KJ {
    private int g;

    @Override // ir.nasim.C24792zC6, java.util.Map
    public void clear() {
        this.g = 0;
        super.clear();
    }

    @Override // ir.nasim.C24792zC6
    public void h(C24792zC6 c24792zC6) {
        this.g = 0;
        super.h(c24792zC6);
    }

    @Override // ir.nasim.C24792zC6, java.util.Map
    public int hashCode() {
        if (this.g == 0) {
            this.g = super.hashCode();
        }
        return this.g;
    }

    @Override // ir.nasim.C24792zC6
    public Object i(int i) {
        this.g = 0;
        return super.i(i);
    }

    @Override // ir.nasim.C24792zC6
    public Object j(int i, Object obj) {
        this.g = 0;
        return super.j(i, obj);
    }

    @Override // ir.nasim.C24792zC6, java.util.Map
    public Object put(Object obj, Object obj2) {
        this.g = 0;
        return super.put(obj, obj2);
    }
}
