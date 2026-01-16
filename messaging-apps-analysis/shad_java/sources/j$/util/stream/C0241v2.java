package j$.util.stream;

/* renamed from: j$.util.stream.v2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C0241v2 extends AbstractC0246w2 {
    public final /* synthetic */ int c;
    private final Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0241v2(InterfaceC0260z1 interfaceC0260z1, Object obj, int i) {
        super(interfaceC0260z1, i);
        this.c = 0;
        this.d = obj;
    }

    @Override // j$.util.stream.AbstractC0246w2
    void a() {
        switch (this.c) {
            case 0:
                ((InterfaceC0260z1) this.a).e(this.d, this.b);
                break;
            default:
                this.a.j((Object[]) this.d, this.b);
                break;
        }
    }

    @Override // j$.util.stream.AbstractC0246w2
    AbstractC0246w2 b(int i, int i2) {
        switch (this.c) {
            case 0:
                return new C0241v2(this, ((InterfaceC0260z1) this.a).c(i), i2);
            default:
                return new C0241v2(this, this.a.c(i), i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0241v2(InterfaceC0260z1 interfaceC0260z1, Object obj, int i, B1 b1) {
        this(interfaceC0260z1, obj, i);
        this.c = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0241v2(A1 a1, Object[] objArr, int i, B1 b1) {
        super(a1, i);
        this.c = 1;
        this.c = 1;
        this.d = objArr;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0241v2(C0241v2 c0241v2, InterfaceC0260z1 interfaceC0260z1, int i) {
        super(c0241v2, interfaceC0260z1, i);
        this.c = 0;
        this.d = c0241v2.d;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0241v2(C0241v2 c0241v2, A1 a1, int i) {
        super(c0241v2, a1, i);
        this.c = 1;
        this.d = (Object[]) c0241v2.d;
    }
}
