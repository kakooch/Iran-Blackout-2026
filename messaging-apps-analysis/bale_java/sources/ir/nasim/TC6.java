package ir.nasim;

/* loaded from: classes2.dex */
public final class TC6 implements InterfaceC14514i27 {
    public static final a c = new a(null);
    private final String a;
    private final Object[] b;

    public static final class a {
        private a() {
        }

        private final void a(InterfaceC13921h27 interfaceC13921h27, int i, Object obj) {
            if (obj == null) {
                interfaceC13921h27.y1(i);
                return;
            }
            if (obj instanceof byte[]) {
                interfaceC13921h27.n1(i, (byte[]) obj);
                return;
            }
            if (obj instanceof Float) {
                interfaceC13921h27.Y(i, ((Number) obj).floatValue());
                return;
            }
            if (obj instanceof Double) {
                interfaceC13921h27.Y(i, ((Number) obj).doubleValue());
                return;
            }
            if (obj instanceof Long) {
                interfaceC13921h27.k1(i, ((Number) obj).longValue());
                return;
            }
            if (obj instanceof Integer) {
                interfaceC13921h27.k1(i, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Short) {
                interfaceC13921h27.k1(i, ((Number) obj).shortValue());
                return;
            }
            if (obj instanceof Byte) {
                interfaceC13921h27.k1(i, ((Number) obj).byteValue());
                return;
            }
            if (obj instanceof String) {
                interfaceC13921h27.U0(i, (String) obj);
                return;
            }
            if (obj instanceof Boolean) {
                interfaceC13921h27.k1(i, ((Boolean) obj).booleanValue() ? 1L : 0L);
                return;
            }
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }

        public final void b(InterfaceC13921h27 interfaceC13921h27, Object[] objArr) {
            AbstractC13042fc3.i(interfaceC13921h27, "statement");
            if (objArr == null) {
                return;
            }
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object obj = objArr[i];
                i++;
                a(interfaceC13921h27, i, obj);
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public TC6(String str, Object[] objArr) {
        AbstractC13042fc3.i(str, "query");
        this.a = str;
        this.b = objArr;
    }

    @Override // ir.nasim.InterfaceC14514i27
    public String a() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC14514i27
    public void b(InterfaceC13921h27 interfaceC13921h27) {
        AbstractC13042fc3.i(interfaceC13921h27, "statement");
        c.b(interfaceC13921h27, this.b);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TC6(String str) {
        this(str, null);
        AbstractC13042fc3.i(str, "query");
    }
}
