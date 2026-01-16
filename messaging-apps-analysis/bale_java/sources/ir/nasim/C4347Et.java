package ir.nasim;

/* renamed from: ir.nasim.Et, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C4347Et {
    int a;
    int b;
    int c;
    final int[] d;

    public C4347Et() {
        this(null);
    }

    public void a() {
        int i = C22477vI7.f;
        if (this.a != i) {
            ir.nasim.tgwidgets.editor.messenger.E.k(i).q(this.b);
            this.b = -1;
            this.a = i;
        }
        this.b = ir.nasim.tgwidgets.editor.messenger.E.k(i).w(this.b, this.d);
        this.c = ir.nasim.tgwidgets.editor.messenger.E.j().w(this.c, this.d);
    }

    public void b() {
        ir.nasim.tgwidgets.editor.messenger.E.k(this.a).q(this.b);
        ir.nasim.tgwidgets.editor.messenger.E.j().q(this.c);
    }

    public C4347Et(int[] iArr) {
        this.a = C22477vI7.f;
        this.b = -1;
        this.c = -1;
        this.d = iArr;
    }
}
