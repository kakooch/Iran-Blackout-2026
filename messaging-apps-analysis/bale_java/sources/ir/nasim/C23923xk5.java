package ir.nasim;

import androidx.datastore.preferences.protobuf.AbstractC1950t;
import androidx.datastore.preferences.protobuf.g0;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* renamed from: ir.nasim.xk5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23923xk5 extends AbstractC1950t implements W64 {
    private static final C23923xk5 DEFAULT_INSTANCE;
    private static volatile MW4 PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private androidx.datastore.preferences.protobuf.C preferences_ = androidx.datastore.preferences.protobuf.C.e();

    /* renamed from: ir.nasim.xk5$a */
    public static final class a extends AbstractC1950t.a implements W64 {
        /* synthetic */ a(AbstractC23333wk5 abstractC23333wk5) {
            this();
        }

        public a r(String str, C25107zk5 c25107zk5) {
            str.getClass();
            c25107zk5.getClass();
            m();
            ((C23923xk5) this.b).E().put(str, c25107zk5);
            return this;
        }

        private a() {
            super(C23923xk5.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: ir.nasim.xk5$b */
    private static final class b {
        static final androidx.datastore.preferences.protobuf.B a = androidx.datastore.preferences.protobuf.B.d(g0.b.k, "", g0.b.m, C25107zk5.L());
    }

    static {
        C23923xk5 c23923xk5 = new C23923xk5();
        DEFAULT_INSTANCE = c23923xk5;
        AbstractC1950t.A(C23923xk5.class, c23923xk5);
    }

    private C23923xk5() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map E() {
        return G();
    }

    private androidx.datastore.preferences.protobuf.C G() {
        if (!this.preferences_.n()) {
            this.preferences_ = this.preferences_.s();
        }
        return this.preferences_;
    }

    private androidx.datastore.preferences.protobuf.C H() {
        return this.preferences_;
    }

    public static a I() {
        return (a) DEFAULT_INSTANCE.k();
    }

    public static C23923xk5 J(InputStream inputStream) {
        return (C23923xk5) AbstractC1950t.y(DEFAULT_INSTANCE, inputStream);
    }

    public Map F() {
        return Collections.unmodifiableMap(H());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1950t
    protected final Object n(AbstractC1950t.d dVar, Object obj, Object obj2) {
        AbstractC23333wk5 abstractC23333wk5 = null;
        switch (AbstractC23333wk5.a[dVar.ordinal()]) {
            case 1:
                return new C23923xk5();
            case 2:
                return new a(abstractC23333wk5);
            case 3:
                return AbstractC1950t.x(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                MW4 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C23923xk5.class) {
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
