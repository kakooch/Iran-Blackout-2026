package ir.nasim;

import androidx.datastore.preferences.protobuf.AbstractC1932a;
import androidx.datastore.preferences.protobuf.AbstractC1950t;
import androidx.datastore.preferences.protobuf.AbstractC1952v;
import java.util.List;

/* renamed from: ir.nasim.yk5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24513yk5 extends AbstractC1950t implements W64 {
    private static final C24513yk5 DEFAULT_INSTANCE;
    private static volatile MW4 PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private AbstractC1952v.b strings_ = AbstractC1950t.o();

    /* renamed from: ir.nasim.yk5$a */
    public static final class a extends AbstractC1950t.a implements W64 {
        /* synthetic */ a(AbstractC23333wk5 abstractC23333wk5) {
            this();
        }

        public a r(Iterable iterable) {
            m();
            ((C24513yk5) this.b).E(iterable);
            return this;
        }

        private a() {
            super(C24513yk5.DEFAULT_INSTANCE);
        }
    }

    static {
        C24513yk5 c24513yk5 = new C24513yk5();
        DEFAULT_INSTANCE = c24513yk5;
        AbstractC1950t.A(C24513yk5.class, c24513yk5);
    }

    private C24513yk5() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Iterable iterable) {
        F();
        AbstractC1932a.a(iterable, this.strings_);
    }

    private void F() {
        if (this.strings_.u()) {
            return;
        }
        this.strings_ = AbstractC1950t.v(this.strings_);
    }

    public static C24513yk5 G() {
        return DEFAULT_INSTANCE;
    }

    public static a I() {
        return (a) DEFAULT_INSTANCE.k();
    }

    public List H() {
        return this.strings_;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1950t
    protected final Object n(AbstractC1950t.d dVar, Object obj, Object obj2) {
        AbstractC23333wk5 abstractC23333wk5 = null;
        switch (AbstractC23333wk5.a[dVar.ordinal()]) {
            case 1:
                return new C24513yk5();
            case 2:
                return new a(abstractC23333wk5);
            case 3:
                return AbstractC1950t.x(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                MW4 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C24513yk5.class) {
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
