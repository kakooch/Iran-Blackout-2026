package ir.nasim;

/* renamed from: ir.nasim.qQ7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C19482qQ7 extends AbstractC13554gQ7 {
    private Object b;

    public C19482qQ7(String str, Object obj) {
        this.b = obj;
    }

    @Override // ir.nasim.AbstractC13554gQ7
    public Object b() {
        return this.b;
    }

    public boolean i(Object obj) {
        Object obj2 = this.b;
        if (obj2 != null && obj != null && obj.equals(obj2)) {
            return false;
        }
        this.b = obj;
        d(obj);
        return true;
    }

    public boolean j(Object obj) {
        this.b = obj;
        d(obj);
        return true;
    }
}
