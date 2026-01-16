package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.AbstractC2358u;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.I;

/* renamed from: ir.nasim.ej, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12499ej extends AbstractC2358u implements T64 {
    private static final C12499ej DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    private static volatile JW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private AbstractC2345g keyValue_ = AbstractC2345g.b;
    private C14317hj params_;
    private int version_;

    /* renamed from: ir.nasim.ej$a */
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

    /* renamed from: ir.nasim.ej$b */
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

        public b p(AbstractC2345g abstractC2345g) {
            i();
            ((C12499ej) this.b).b0(abstractC2345g);
            return this;
        }

        public b q(C14317hj c14317hj) {
            i();
            ((C12499ej) this.b).c0(c14317hj);
            return this;
        }

        public b r(int i) {
            i();
            ((C12499ej) this.b).d0(i);
            return this;
        }

        private b() {
            super(C12499ej.DEFAULT_INSTANCE);
        }
    }

    static {
        C12499ej c12499ej = new C12499ej();
        DEFAULT_INSTANCE = c12499ej;
        AbstractC2358u.N(C12499ej.class, c12499ej);
    }

    private C12499ej() {
    }

    public static C12499ej V() {
        return DEFAULT_INSTANCE;
    }

    public static b Z() {
        return (b) DEFAULT_INSTANCE.n();
    }

    public static C12499ej a0(AbstractC2345g abstractC2345g, C2352n c2352n) {
        return (C12499ej) AbstractC2358u.H(DEFAULT_INSTANCE, abstractC2345g, c2352n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(AbstractC2345g abstractC2345g) {
        abstractC2345g.getClass();
        this.keyValue_ = abstractC2345g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(C14317hj c14317hj) {
        c14317hj.getClass();
        this.params_ = c14317hj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(int i) {
        this.version_ = i;
    }

    public AbstractC2345g W() {
        return this.keyValue_;
    }

    public C14317hj X() {
        C14317hj c14317hj = this.params_;
        return c14317hj == null ? C14317hj.T() : c14317hj;
    }

    public int Y() {
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
                return new C12499ej();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC2358u.F(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                JW4 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C12499ej.class) {
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
