package ir.nasim;

/* renamed from: ir.nasim.uY7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C22031uY7 {
    UO6 a;
    int b;
    final Runnable c = new Runnable() { // from class: ir.nasim.tY7
        @Override // java.lang.Runnable
        public final void run() {
            this.a.b();
        }
    };

    public C22031uY7(UO6 uo6, int i) {
        this.b = i;
        this.a = uo6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b() {
        this.a.g(C22477vI7.j(this.b).h());
        return false;
    }
}
