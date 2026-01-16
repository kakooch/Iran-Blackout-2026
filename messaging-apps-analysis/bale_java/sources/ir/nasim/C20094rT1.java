package ir.nasim;

/* renamed from: ir.nasim.rT1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C20094rT1 {
    private InterfaceC3570Bk5 a;
    private O92 b;
    private O92 c;
    private O92 d;
    private O92 e;
    private O92 f;

    /* renamed from: ir.nasim.rT1$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[OP1.values().length];
            a = iArr;
            try {
                iArr[OP1.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[OP1.CHANNEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[OP1.PRIVATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[OP1.BOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[OP1.ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public C20094rT1(InterfaceC3570Bk5 interfaceC3570Bk5) {
        this.a = interfaceC3570Bk5;
        String strE = interfaceC3570Bk5.e("app.all_dialogs.stat");
        String strE2 = this.a.e("app.private_dialogs.state");
        String strE3 = this.a.e("app.group_dialogs.state");
        String strE4 = this.a.e("app.channel_dialogs.state");
        String strE5 = this.a.e("app.bot_dialogs.state");
        strE = strE == null ? EnumC12820fE.LOADING.name() : strE;
        strE2 = strE2 == null ? EnumC12820fE.LOADING.name() : strE2;
        strE3 = strE3 == null ? EnumC12820fE.LOADING.name() : strE3;
        strE4 = strE4 == null ? EnumC12820fE.LOADING.name() : strE4;
        strE5 = strE5 == null ? EnumC12820fE.LOADING.name() : strE5;
        this.b = new O92("app.all_dialogs.stat", EnumC12820fE.valueOf(strE));
        this.c = new O92("app.private_dialogs.state", EnumC12820fE.valueOf(strE2));
        this.d = new O92("app.group_dialogs.state", EnumC12820fE.valueOf(strE3));
        this.e = new O92("app.channel_dialogs.state", EnumC12820fE.valueOf(strE4));
        this.f = new O92("app.bot_dialogs.state", EnumC12820fE.valueOf(strE5));
    }

    public O92 a() {
        return this.b;
    }

    public O92 b() {
        return this.f;
    }

    public O92 c() {
        return this.e;
    }

    public O92 d() {
        return this.d;
    }

    public O92 e() {
        return this.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(ir.nasim.OP1 r3, ir.nasim.EnumC12820fE r4) {
        /*
            r2 = this;
            int[] r0 = ir.nasim.C20094rT1.a.a
            int r3 = r3.ordinal()
            r3 = r0[r3]
            r0 = 1
            java.lang.String r1 = ""
            if (r3 == r0) goto L5a
            r0 = 2
            if (r3 == r0) goto L4a
            r0 = 3
            if (r3 == r0) goto L3a
            r0 = 4
            if (r3 == r0) goto L2a
            r0 = 5
            if (r3 == r0) goto L1a
            goto L6a
        L1a:
            ir.nasim.O92 r3 = r2.b
            java.lang.Object r3 = r3.b()
            if (r3 == r4) goto L6a
            ir.nasim.O92 r3 = r2.b
            r3.i(r4)
            java.lang.String r3 = "app.all_dialogs.stat"
            goto L6b
        L2a:
            ir.nasim.O92 r3 = r2.f
            java.lang.Object r3 = r3.b()
            if (r3 == r4) goto L6a
            ir.nasim.O92 r3 = r2.f
            r3.i(r4)
            java.lang.String r3 = "app.bot_dialogs.state"
            goto L6b
        L3a:
            ir.nasim.O92 r3 = r2.c
            java.lang.Object r3 = r3.b()
            if (r3 == r4) goto L6a
            ir.nasim.O92 r3 = r2.c
            r3.i(r4)
            java.lang.String r3 = "app.private_dialogs.state"
            goto L6b
        L4a:
            ir.nasim.O92 r3 = r2.e
            java.lang.Object r3 = r3.b()
            if (r3 == r4) goto L6a
            ir.nasim.O92 r3 = r2.e
            r3.i(r4)
            java.lang.String r3 = "app.channel_dialogs.state"
            goto L6b
        L5a:
            ir.nasim.O92 r3 = r2.d
            java.lang.Object r3 = r3.b()
            if (r3 == r4) goto L6a
            ir.nasim.O92 r3 = r2.d
            r3.i(r4)
            java.lang.String r3 = "app.group_dialogs.state"
            goto L6b
        L6a:
            r3 = r1
        L6b:
            boolean r0 = r3.equals(r1)
            if (r0 != 0) goto L7a
            ir.nasim.Bk5 r0 = r2.a
            java.lang.String r4 = r4.name()
            r0.putString(r3, r4)
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20094rT1.f(ir.nasim.OP1, ir.nasim.fE):void");
    }
}
