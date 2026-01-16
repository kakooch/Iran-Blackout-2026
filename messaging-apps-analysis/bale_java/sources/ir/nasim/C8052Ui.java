package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.AbstractC2358u;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.I;

/* renamed from: ir.nasim.Ui, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C8052Ui extends AbstractC2358u implements T64 {
    public static final int AES_CTR_KEY_FIELD_NUMBER = 2;
    private static final C8052Ui DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FIELD_NUMBER = 3;
    private static volatile JW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private C12499ej aesCtrKey_;
    private C20749sY2 hmacKey_;
    private int version_;

    /* renamed from: ir.nasim.Ui$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AbstractC2358u.d.values().length];
            a = iArr;
            try {
                iArr[AbstractC2358u.d.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AbstractC2358u.d.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AbstractC2358u.d.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AbstractC2358u.d.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AbstractC2358u.d.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AbstractC2358u.d.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[AbstractC2358u.d.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: ir.nasim.Ui$b */
    public static final class b extends AbstractC2358u.a implements T64 {
        /* synthetic */ b(a aVar) {
            this();
        }

        public /* bridge */ /* synthetic */ Object clone() {
            return super.h();
        }

        @Override // ir.nasim.T64
        public /* bridge */ /* synthetic */ com.google.crypto.tink.shaded.protobuf.I getDefaultInstanceForType() {
            return super.l();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.I.a
        public /* bridge */ /* synthetic */ com.google.crypto.tink.shaded.protobuf.I j() {
            return super.f();
        }

        public b p(C12499ej c12499ej) {
            i();
            ((C8052Ui) this.b).a0(c12499ej);
            return this;
        }

        public b q(C20749sY2 c20749sY2) {
            i();
            ((C8052Ui) this.b).b0(c20749sY2);
            return this;
        }

        public b r(int i) {
            i();
            ((C8052Ui) this.b).c0(i);
            return this;
        }

        private b() {
            super(C8052Ui.DEFAULT_INSTANCE);
        }
    }

    static {
        C8052Ui c8052Ui = new C8052Ui();
        DEFAULT_INSTANCE = c8052Ui;
        AbstractC2358u.N(C8052Ui.class, c8052Ui);
    }

    private C8052Ui() {
    }

    public static b Y() {
        return (b) DEFAULT_INSTANCE.n();
    }

    public static C8052Ui Z(AbstractC2345g abstractC2345g, C2352n c2352n) {
        return (C8052Ui) AbstractC2358u.H(DEFAULT_INSTANCE, abstractC2345g, c2352n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(C12499ej c12499ej) {
        c12499ej.getClass();
        this.aesCtrKey_ = c12499ej;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(C20749sY2 c20749sY2) {
        c20749sY2.getClass();
        this.hmacKey_ = c20749sY2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(int i) {
        this.version_ = i;
    }

    public C12499ej V() {
        C12499ej c12499ej = this.aesCtrKey_;
        return c12499ej == null ? C12499ej.V() : c12499ej;
    }

    public C20749sY2 W() {
        C20749sY2 c20749sY2 = this.hmacKey_;
        return c20749sY2 == null ? C20749sY2.V() : c20749sY2;
    }

    public int X() {
        return this.version_;
    }

    @Override // ir.nasim.T64
    public /* bridge */ /* synthetic */ com.google.crypto.tink.shaded.protobuf.I getDefaultInstanceForType() {
        return super.t();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.I
    public /* bridge */ /* synthetic */ I.a newBuilderForType() {
        return super.E();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC2358u
    protected final Object q(AbstractC2358u.d dVar, Object obj, Object obj2) {
        a aVar = null;
        switch (a.a[dVar.ordinal()]) {
            case 1:
                return new C8052Ui();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC2358u.F(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"version_", "aesCtrKey_", "hmacKey_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                JW4 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C8052Ui.class) {
                        try {
                            bVar = PARSER;
                            if (bVar == null) {
                                bVar = new AbstractC2358u.b(DEFAULT_INSTANCE);
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
