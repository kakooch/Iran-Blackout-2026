package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2358u;
import com.google.crypto.tink.shaded.protobuf.AbstractC2360w;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.I;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.Hp3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5032Hp3 extends AbstractC2358u implements T64 {
    private static final C5032Hp3 DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile JW4 PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    private AbstractC2360w.d key_ = AbstractC2358u.r();
    private int primaryKeyId_;

    /* renamed from: ir.nasim.Hp3$a */
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

    /* renamed from: ir.nasim.Hp3$b */
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
            ((C5032Hp3) this.b).U(cVar);
            return this;
        }

        public c q(int i) {
            return ((C5032Hp3) this.b).W(i);
        }

        public int r() {
            return ((C5032Hp3) this.b).X();
        }

        public List s() {
            return Collections.unmodifiableList(((C5032Hp3) this.b).Y());
        }

        public b t(int i) {
            i();
            ((C5032Hp3) this.b).d0(i);
            return this;
        }

        private b() {
            super(C5032Hp3.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: ir.nasim.Hp3$c */
    public static final class c extends AbstractC2358u implements T64 {
        private static final c DEFAULT_INSTANCE;
        public static final int KEY_DATA_FIELD_NUMBER = 1;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        private static volatile JW4 PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        private C20317ro3 keyData_;
        private int keyId_;
        private int outputPrefixType_;
        private int status_;

        /* renamed from: ir.nasim.Hp3$c$a */
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

            public a p(C20317ro3 c20317ro3) {
                i();
                ((c) this.b).c0(c20317ro3);
                return this;
            }

            public a q(int i) {
                i();
                ((c) this.b).d0(i);
                return this;
            }

            public a r(FN4 fn4) {
                i();
                ((c) this.b).e0(fn4);
                return this;
            }

            public a s(EnumC6192Mo3 enumC6192Mo3) {
                i();
                ((c) this.b).f0(enumC6192Mo3);
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

        public static a b0() {
            return (a) DEFAULT_INSTANCE.n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c0(C20317ro3 c20317ro3) {
            c20317ro3.getClass();
            this.keyData_ = c20317ro3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d0(int i) {
            this.keyId_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e0(FN4 fn4) {
            this.outputPrefixType_ = fn4.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f0(EnumC6192Mo3 enumC6192Mo3) {
            this.status_ = enumC6192Mo3.getNumber();
        }

        public C20317ro3 W() {
            C20317ro3 c20317ro3 = this.keyData_;
            return c20317ro3 == null ? C20317ro3.V() : c20317ro3;
        }

        public int X() {
            return this.keyId_;
        }

        public FN4 Y() {
            FN4 fn4A = FN4.a(this.outputPrefixType_);
            return fn4A == null ? FN4.UNRECOGNIZED : fn4A;
        }

        public EnumC6192Mo3 Z() {
            EnumC6192Mo3 enumC6192Mo3A = EnumC6192Mo3.a(this.status_);
            return enumC6192Mo3A == null ? EnumC6192Mo3.UNRECOGNIZED : enumC6192Mo3A;
        }

        public boolean a0() {
            return this.keyData_ != null;
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
                    return AbstractC2358u.F(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
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
        C5032Hp3 c5032Hp3 = new C5032Hp3();
        DEFAULT_INSTANCE = c5032Hp3;
        AbstractC2358u.N(C5032Hp3.class, c5032Hp3);
    }

    private C5032Hp3() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(c cVar) {
        cVar.getClass();
        V();
        this.key_.add(cVar);
    }

    private void V() {
        AbstractC2360w.d dVar = this.key_;
        if (dVar.u()) {
            return;
        }
        this.key_ = AbstractC2358u.D(dVar);
    }

    public static b a0() {
        return (b) DEFAULT_INSTANCE.n();
    }

    public static C5032Hp3 b0(InputStream inputStream, C2352n c2352n) {
        return (C5032Hp3) AbstractC2358u.I(DEFAULT_INSTANCE, inputStream, c2352n);
    }

    public static C5032Hp3 c0(byte[] bArr, C2352n c2352n) {
        return (C5032Hp3) AbstractC2358u.J(DEFAULT_INSTANCE, bArr, c2352n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(int i) {
        this.primaryKeyId_ = i;
    }

    public c W(int i) {
        return (c) this.key_.get(i);
    }

    public int X() {
        return this.key_.size();
    }

    public List Y() {
        return this.key_;
    }

    public int Z() {
        return this.primaryKeyId_;
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
                return new C5032Hp3();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC2358u.F(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", c.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                JW4 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C5032Hp3.class) {
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
