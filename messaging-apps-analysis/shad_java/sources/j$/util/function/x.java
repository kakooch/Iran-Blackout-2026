package j$.util.function;

/* loaded from: classes2.dex */
public final /* synthetic */ class x implements y {
    public final /* synthetic */ int a;
    public final /* synthetic */ y b;
    public final /* synthetic */ y c;

    public /* synthetic */ x(y yVar, y yVar2, int i) {
        this.a = i;
        if (i != 1) {
            this.b = yVar;
            this.c = yVar2;
        } else {
            this.b = yVar;
            this.c = yVar2;
        }
    }

    @Override // j$.util.function.y
    public y a(y yVar) {
        int i = 1;
        switch (this.a) {
            case 0:
                yVar.getClass();
                break;
            default:
                yVar.getClass();
                break;
        }
        return new x(this, yVar, i);
    }

    @Override // j$.util.function.y
    public y b(y yVar) {
        int i = 0;
        switch (this.a) {
            case 0:
                yVar.getClass();
                break;
            default:
                yVar.getClass();
                break;
        }
        return new x(this, yVar, i);
    }

    @Override // j$.util.function.y
    public y negate() {
        switch (this.a) {
        }
        return new C0108a(this);
    }

    @Override // j$.util.function.y
    public final boolean test(Object obj) {
        switch (this.a) {
            case 0:
                return j$.lang.d.b(this.b, this.c, obj);
            default:
                return this.b.test(obj) || this.c.test(obj);
        }
    }
}
