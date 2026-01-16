package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.AbstractC2358u;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.I;

/* renamed from: ir.nasim.Oo3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6691Oo3 extends AbstractC2358u implements T64 {
    private static final C6691Oo3 DEFAULT_INSTANCE;
    public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 3;
    private static volatile JW4 PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int outputPrefixType_;
    private String typeUrl_ = "";
    private AbstractC2345g value_ = AbstractC2345g.b;

    /* renamed from: ir.nasim.Oo3$a */
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

    /* renamed from: ir.nasim.Oo3$b */
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

        public b p(FN4 fn4) {
            i();
            ((C6691Oo3) this.b).b0(fn4);
            return this;
        }

        public b q(String str) {
            i();
            ((C6691Oo3) this.b).c0(str);
            return this;
        }

        public b r(AbstractC2345g abstractC2345g) {
            i();
            ((C6691Oo3) this.b).d0(abstractC2345g);
            return this;
        }

        private b() {
            super(C6691Oo3.DEFAULT_INSTANCE);
        }
    }

    static {
        C6691Oo3 c6691Oo3 = new C6691Oo3();
        DEFAULT_INSTANCE = c6691Oo3;
        AbstractC2358u.N(C6691Oo3.class, c6691Oo3);
    }

    private C6691Oo3() {
    }

    public static C6691Oo3 V() {
        return DEFAULT_INSTANCE;
    }

    public static b Z() {
        return (b) DEFAULT_INSTANCE.n();
    }

    public static C6691Oo3 a0(byte[] bArr, C2352n c2352n) {
        return (C6691Oo3) AbstractC2358u.J(DEFAULT_INSTANCE, bArr, c2352n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(FN4 fn4) {
        this.outputPrefixType_ = fn4.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(String str) {
        str.getClass();
        this.typeUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(AbstractC2345g abstractC2345g) {
        abstractC2345g.getClass();
        this.value_ = abstractC2345g;
    }

    public FN4 W() {
        FN4 fn4A = FN4.a(this.outputPrefixType_);
        return fn4A == null ? FN4.UNRECOGNIZED : fn4A;
    }

    public String X() {
        return this.typeUrl_;
    }

    public AbstractC2345g Y() {
        return this.value_;
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
                return new C6691Oo3();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC2358u.F(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "outputPrefixType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                JW4 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C6691Oo3.class) {
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
