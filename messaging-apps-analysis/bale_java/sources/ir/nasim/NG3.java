package ir.nasim;

/* loaded from: classes5.dex */
public final class NG3 extends AbstractC19230q0 {
    private static final a d = new a(null);
    public static final int e = 8;
    public EnumC18494ol1 a;
    public String b;
    private int c;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public NG3() {
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        y(EnumC18494ol1.j(c19084pl0.h(1, EnumC18494ol1.UNKNOWN_CONTENT.p())));
        z(c19084pl0.s(2, ""));
        this.c = c19084pl0.h(3, 0);
    }

    public final EnumC18494ol1 s() {
        EnumC18494ol1 enumC18494ol1 = this.a;
        if (enumC18494ol1 != null) {
            return enumC18494ol1;
        }
        AbstractC13042fc3.y("contentType");
        return null;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        c19675ql0.f(1, s().p());
        c19675ql0.o(2, u());
        c19675ql0.f(3, this.c);
    }

    public final String u() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        AbstractC13042fc3.y("dialogText");
        return null;
    }

    public final int w() {
        return this.c;
    }

    public final void y(EnumC18494ol1 enumC18494ol1) {
        AbstractC13042fc3.i(enumC18494ol1, "<set-?>");
        this.a = enumC18494ol1;
    }

    public final void z(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.b = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NG3(EnumC18494ol1 enumC18494ol1, String str, int i) {
        this();
        AbstractC13042fc3.i(enumC18494ol1, "contentType");
        AbstractC13042fc3.i(str, "dialogText");
        y(enumC18494ol1);
        z(str);
        this.c = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NG3(byte[] bArr) {
        this();
        AbstractC13042fc3.i(bArr, "data");
        load(bArr);
    }
}
