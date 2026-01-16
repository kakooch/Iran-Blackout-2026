package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Rd1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7302Rd1 {
    public static final C7302Rd1 a = new C7302Rd1();

    /* renamed from: ir.nasim.Rd1$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC4099Dr3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC4099Dr3 abstractC4099Dr3) {
            super(1);
            this.e = abstractC4099Dr3;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke(InterfaceC8507Wg4 interfaceC8507Wg4) {
            AbstractC13042fc3.i(interfaceC8507Wg4, "it");
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Rd1$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ EnumC4809Gq5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(EnumC4809Gq5 enumC4809Gq5) {
            super(1);
            this.e = enumC4809Gq5;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke(InterfaceC8507Wg4 interfaceC8507Wg4) {
            AbstractC13042fc3.i(interfaceC8507Wg4, "module");
            XC6 xc6N = interfaceC8507Wg4.n().N(this.e);
            AbstractC13042fc3.h(xc6N, "module.builtIns.getPrimitiveArrayKotlinType(componentType)");
            return xc6N;
        }
    }

    private C7302Rd1() {
    }

    private final WJ b(List list, EnumC4809Gq5 enumC4809Gq5) {
        List listM1 = AbstractC15401jX0.m1(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            AbstractC7068Qd1 abstractC7068Qd1C = c(it.next());
            if (abstractC7068Qd1C != null) {
                arrayList.add(abstractC7068Qd1C);
            }
        }
        return new WJ(arrayList, new b(enumC4809Gq5));
    }

    public final WJ a(List list, AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(list, "value");
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
        return new WJ(list, new a(abstractC4099Dr3));
    }

    public final AbstractC7068Qd1 c(Object obj) {
        if (obj instanceof Byte) {
            return new C8341Vo0(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new C5359Iz6(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new C6066Ma3(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new C24258yJ3(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new C14084hK0(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new C18545oq2(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new C17175mX1(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new C8278Vh0(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new C9790aZ6((String) obj);
        }
        if (obj instanceof byte[]) {
            return b(AbstractC10242bK.Z0((byte[]) obj), EnumC4809Gq5.BYTE);
        }
        if (obj instanceof short[]) {
            return b(AbstractC10242bK.g1((short[]) obj), EnumC4809Gq5.SHORT);
        }
        if (obj instanceof int[]) {
            return b(AbstractC10242bK.d1((int[]) obj), EnumC4809Gq5.INT);
        }
        if (obj instanceof long[]) {
            return b(AbstractC10242bK.e1((long[]) obj), EnumC4809Gq5.LONG);
        }
        if (obj instanceof char[]) {
            return b(AbstractC10242bK.a1((char[]) obj), EnumC4809Gq5.CHAR);
        }
        if (obj instanceof float[]) {
            return b(AbstractC10242bK.c1((float[]) obj), EnumC4809Gq5.FLOAT);
        }
        if (obj instanceof double[]) {
            return b(AbstractC10242bK.b1((double[]) obj), EnumC4809Gq5.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return b(AbstractC10242bK.h1((boolean[]) obj), EnumC4809Gq5.BOOLEAN);
        }
        if (obj == null) {
            return new C12834fF4();
        }
        return null;
    }
}
