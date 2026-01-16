package ir.nasim;

import androidx.datastore.preferences.protobuf.AbstractC1950t;
import ir.nasim.C24513yk5;

/* renamed from: ir.nasim.zk5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C25107zk5 extends AbstractC1950t implements W64 {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    private static final C25107zk5 DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile MW4 PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int bitField0_;
    private int valueCase_ = 0;
    private Object value_;

    /* renamed from: ir.nasim.zk5$a */
    public static final class a extends AbstractC1950t.a implements W64 {
        /* synthetic */ a(AbstractC23333wk5 abstractC23333wk5) {
            this();
        }

        public a r(boolean z) {
            m();
            ((C25107zk5) this.b).V(z);
            return this;
        }

        public a s(double d) {
            m();
            ((C25107zk5) this.b).W(d);
            return this;
        }

        public a t(float f) {
            m();
            ((C25107zk5) this.b).X(f);
            return this;
        }

        public a u(int i) {
            m();
            ((C25107zk5) this.b).Y(i);
            return this;
        }

        public a v(long j) {
            m();
            ((C25107zk5) this.b).Z(j);
            return this;
        }

        public a w(String str) {
            m();
            ((C25107zk5) this.b).a0(str);
            return this;
        }

        public a x(C24513yk5.a aVar) {
            m();
            ((C25107zk5) this.b).b0(aVar);
            return this;
        }

        private a() {
            super(C25107zk5.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: ir.nasim.zk5$b */
    public enum b {
        BOOLEAN(1),
        FLOAT(2),
        INTEGER(3),
        LONG(4),
        STRING(5),
        STRING_SET(6),
        DOUBLE(7),
        VALUE_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b a(int i) {
            switch (i) {
                case 0:
                    return VALUE_NOT_SET;
                case 1:
                    return BOOLEAN;
                case 2:
                    return FLOAT;
                case 3:
                    return INTEGER;
                case 4:
                    return LONG;
                case 5:
                    return STRING;
                case 6:
                    return STRING_SET;
                case 7:
                    return DOUBLE;
                default:
                    return null;
            }
        }
    }

    static {
        C25107zk5 c25107zk5 = new C25107zk5();
        DEFAULT_INSTANCE = c25107zk5;
        AbstractC1950t.A(C25107zk5.class, c25107zk5);
    }

    private C25107zk5() {
    }

    public static C25107zk5 L() {
        return DEFAULT_INSTANCE;
    }

    public static a U() {
        return (a) DEFAULT_INSTANCE.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(boolean z) {
        this.valueCase_ = 1;
        this.value_ = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(double d) {
        this.valueCase_ = 7;
        this.value_ = Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(float f) {
        this.valueCase_ = 2;
        this.value_ = Float.valueOf(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i) {
        this.valueCase_ = 3;
        this.value_ = Integer.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(long j) {
        this.valueCase_ = 4;
        this.value_ = Long.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(String str) {
        str.getClass();
        this.valueCase_ = 5;
        this.value_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(C24513yk5.a aVar) {
        this.value_ = aVar.i();
        this.valueCase_ = 6;
    }

    public boolean K() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public double M() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public float N() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public int O() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public long Q() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public String R() {
        return this.valueCase_ == 5 ? (String) this.value_ : "";
    }

    public C24513yk5 S() {
        return this.valueCase_ == 6 ? (C24513yk5) this.value_ : C24513yk5.G();
    }

    public b T() {
        return b.a(this.valueCase_);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1950t
    protected final Object n(AbstractC1950t.d dVar, Object obj, Object obj2) {
        AbstractC23333wk5 abstractC23333wk5 = null;
        switch (AbstractC23333wk5.a[dVar.ordinal()]) {
            case 1:
                return new C25107zk5();
            case 2:
                return new a(abstractC23333wk5);
            case 3:
                return AbstractC1950t.x(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", C24513yk5.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                MW4 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C25107zk5.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC1950t.b(DEFAULT_INSTANCE);
                                PARSER = bVar;
                            }
                        } finally {
                        }
                    }
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
