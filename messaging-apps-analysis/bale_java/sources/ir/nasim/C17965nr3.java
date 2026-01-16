package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.AbstractC2358u;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.I;

/* renamed from: ir.nasim.nr3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17965nr3 extends AbstractC2358u implements T64 {
    private static final C17965nr3 DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile JW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private C18556or3 params_;
    private int version_;

    /* renamed from: ir.nasim.nr3$a */
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

    /* renamed from: ir.nasim.nr3$b */
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

        public b p(C18556or3 c18556or3) {
            i();
            ((C17965nr3) this.b).Y(c18556or3);
            return this;
        }

        public b q(int i) {
            i();
            ((C17965nr3) this.b).Z(i);
            return this;
        }

        private b() {
            super(C17965nr3.DEFAULT_INSTANCE);
        }
    }

    static {
        C17965nr3 c17965nr3 = new C17965nr3();
        DEFAULT_INSTANCE = c17965nr3;
        AbstractC2358u.N(C17965nr3.class, c17965nr3);
    }

    private C17965nr3() {
    }

    public static b W() {
        return (b) DEFAULT_INSTANCE.n();
    }

    public static C17965nr3 X(AbstractC2345g abstractC2345g, C2352n c2352n) {
        return (C17965nr3) AbstractC2358u.H(DEFAULT_INSTANCE, abstractC2345g, c2352n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(C18556or3 c18556or3) {
        c18556or3.getClass();
        this.params_ = c18556or3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i) {
        this.version_ = i;
    }

    public C18556or3 U() {
        C18556or3 c18556or3 = this.params_;
        return c18556or3 == null ? C18556or3.U() : c18556or3;
    }

    public int V() {
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
                return new C17965nr3();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC2358u.F(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"version_", "params_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                JW4 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C17965nr3.class) {
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
