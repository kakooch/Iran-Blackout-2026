package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2358u;
import com.google.crypto.tink.shaded.protobuf.AbstractC2360w;
import com.google.crypto.tink.shaded.protobuf.I;

/* renamed from: ir.nasim.Jp3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5500Jp3 extends AbstractC2358u implements T64 {
    private static final C5500Jp3 DEFAULT_INSTANCE;
    public static final int KEY_INFO_FIELD_NUMBER = 2;
    private static volatile JW4 PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private AbstractC2360w.d keyInfo_ = AbstractC2358u.r();
    private int primaryKeyId_;

    /* renamed from: ir.nasim.Jp3$a */
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

    /* renamed from: ir.nasim.Jp3$b */
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

        public b p(c cVar) {
            i();
            ((C5500Jp3) this.b).U(cVar);
            return this;
        }

        public b q(int i) {
            i();
            ((C5500Jp3) this.b).Y(i);
            return this;
        }

        private b() {
            super(C5500Jp3.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: ir.nasim.Jp3$c */
    public static final class c extends AbstractC2358u implements T64 {
        private static final c DEFAULT_INSTANCE;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile JW4 PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        public static final int TYPE_URL_FIELD_NUMBER = 1;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;
        private String typeUrl_ = "";

        /* renamed from: ir.nasim.Jp3$c$a */
        public static final class a extends AbstractC2358u.a implements T64 {
            /* synthetic */ a(a aVar) {
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

            public a p(int i) {
                i();
                ((c) this.b).Y(i);
                return this;
            }

            public a q(FN4 fn4) {
                i();
                ((c) this.b).Z(fn4);
                return this;
            }

            public a r(EnumC6192Mo3 enumC6192Mo3) {
                i();
                ((c) this.b).a0(enumC6192Mo3);
                return this;
            }

            public a s(String str) {
                i();
                ((c) this.b).b0(str);
                return this;
            }

            private a() {
                super(c.DEFAULT_INSTANCE);
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            AbstractC2358u.N(c.class, cVar);
        }

        private c() {
        }

        public static a X() {
            return (a) DEFAULT_INSTANCE.n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Y(int i) {
            this.keyId_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void Z(FN4 fn4) {
            this.outputPrefixType_ = fn4.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a0(EnumC6192Mo3 enumC6192Mo3) {
            this.status_ = enumC6192Mo3.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b0(String str) {
            str.getClass();
            this.typeUrl_ = str;
        }

        public int W() {
            return this.keyId_;
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
                    return new c();
                case 2:
                    return new a(aVar);
                case 3:
                    return AbstractC2358u.F(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"typeUrl_", "status_", "keyId_", "outputPrefixType_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    JW4 bVar = PARSER;
                    if (bVar == null) {
                        synchronized (c.class) {
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

    static {
        C5500Jp3 c5500Jp3 = new C5500Jp3();
        DEFAULT_INSTANCE = c5500Jp3;
        AbstractC2358u.N(C5500Jp3.class, c5500Jp3);
    }

    private C5500Jp3() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(c cVar) {
        cVar.getClass();
        V();
        this.keyInfo_.add(cVar);
    }

    private void V() {
        AbstractC2360w.d dVar = this.keyInfo_;
        if (dVar.u()) {
            return;
        }
        this.keyInfo_ = AbstractC2358u.D(dVar);
    }

    public static b X() {
        return (b) DEFAULT_INSTANCE.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i) {
        this.primaryKeyId_ = i;
    }

    public c W(int i) {
        return (c) this.keyInfo_.get(i);
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
                return new C5500Jp3();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC2358u.F(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "keyInfo_", c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                JW4 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C5500Jp3.class) {
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
