package ir.nasim;

import java.util.Set;

/* renamed from: ir.nasim.Gq5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC4809Gq5 {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");

    public static final a e;
    public static final Set f;
    private final C6432No4 a;
    private final C6432No4 b;
    private final InterfaceC9173Yu3 c;
    private final InterfaceC9173Yu3 d;

    /* renamed from: ir.nasim.Gq5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Gq5$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C9424Zw2 invoke() {
            C9424Zw2 c9424Zw2C = PJ6.m.c(EnumC4809Gq5.this.j());
            AbstractC13042fc3.h(c9424Zw2C, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
            return c9424Zw2C;
        }
    }

    /* renamed from: ir.nasim.Gq5$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C9424Zw2 invoke() {
            C9424Zw2 c9424Zw2C = PJ6.m.c(EnumC4809Gq5.this.q());
            AbstractC13042fc3.h(c9424Zw2C, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
            return c9424Zw2C;
        }
    }

    static {
        EnumC4809Gq5 enumC4809Gq5 = CHAR;
        EnumC4809Gq5 enumC4809Gq52 = BYTE;
        EnumC4809Gq5 enumC4809Gq53 = SHORT;
        EnumC4809Gq5 enumC4809Gq54 = INT;
        EnumC4809Gq5 enumC4809Gq55 = FLOAT;
        EnumC4809Gq5 enumC4809Gq56 = LONG;
        EnumC4809Gq5 enumC4809Gq57 = DOUBLE;
        e = new a(null);
        f = AbstractC4597Fu6.i(enumC4809Gq5, enumC4809Gq52, enumC4809Gq53, enumC4809Gq54, enumC4809Gq55, enumC4809Gq56, enumC4809Gq57);
    }

    EnumC4809Gq5(String str) {
        C6432No4 c6432No4P = C6432No4.p(str);
        AbstractC13042fc3.h(c6432No4P, "identifier(typeName)");
        this.a = c6432No4P;
        C6432No4 c6432No4P2 = C6432No4.p(AbstractC13042fc3.q(str, "Array"));
        AbstractC13042fc3.h(c6432No4P2, "identifier(\"${typeName}Array\")");
        this.b = c6432No4P2;
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.b;
        this.c = AbstractC13269fw3.b(enumC4870Gx3, new c());
        this.d = AbstractC13269fw3.b(enumC4870Gx3, new b());
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC4809Gq5[] valuesCustom() {
        EnumC4809Gq5[] enumC4809Gq5ArrValuesCustom = values();
        EnumC4809Gq5[] enumC4809Gq5Arr = new EnumC4809Gq5[enumC4809Gq5ArrValuesCustom.length];
        System.arraycopy(enumC4809Gq5ArrValuesCustom, 0, enumC4809Gq5Arr, 0, enumC4809Gq5ArrValuesCustom.length);
        return enumC4809Gq5Arr;
    }

    public final C9424Zw2 a() {
        return (C9424Zw2) this.d.getValue();
    }

    public final C6432No4 j() {
        return this.b;
    }

    public final C9424Zw2 p() {
        return (C9424Zw2) this.c.getValue();
    }

    public final C6432No4 q() {
        return this.a;
    }
}
