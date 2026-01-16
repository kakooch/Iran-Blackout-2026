package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2345g;
import com.google.crypto.tink.shaded.protobuf.AbstractC2358u;
import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.I;
import java.io.InputStream;

/* renamed from: ir.nasim.h82, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C13976h82 extends AbstractC2358u implements T64 {
    private static final C13976h82 DEFAULT_INSTANCE;
    public static final int ENCRYPTED_KEYSET_FIELD_NUMBER = 2;
    public static final int KEYSET_INFO_FIELD_NUMBER = 3;
    private static volatile JW4 PARSER;
    private AbstractC2345g encryptedKeyset_ = AbstractC2345g.b;
    private C5500Jp3 keysetInfo_;

    /* renamed from: ir.nasim.h82$a */
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

    /* renamed from: ir.nasim.h82$b */
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
            ((C13976h82) this.b).X(abstractC2345g);
            return this;
        }

        public b q(C5500Jp3 c5500Jp3) {
            i();
            ((C13976h82) this.b).Y(c5500Jp3);
            return this;
        }

        private b() {
            super(C13976h82.DEFAULT_INSTANCE);
        }
    }

    static {
        C13976h82 c13976h82 = new C13976h82();
        DEFAULT_INSTANCE = c13976h82;
        AbstractC2358u.N(C13976h82.class, c13976h82);
    }

    private C13976h82() {
    }

    public static b V() {
        return (b) DEFAULT_INSTANCE.n();
    }

    public static C13976h82 W(InputStream inputStream, C2352n c2352n) {
        return (C13976h82) AbstractC2358u.I(DEFAULT_INSTANCE, inputStream, c2352n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(AbstractC2345g abstractC2345g) {
        abstractC2345g.getClass();
        this.encryptedKeyset_ = abstractC2345g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(C5500Jp3 c5500Jp3) {
        c5500Jp3.getClass();
        this.keysetInfo_ = c5500Jp3;
    }

    public AbstractC2345g U() {
        return this.encryptedKeyset_;
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
                return new C13976h82();
            case 2:
                return new b(aVar);
            case 3:
                return AbstractC2358u.F(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"encryptedKeyset_", "keysetInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                JW4 bVar = PARSER;
                if (bVar == null) {
                    synchronized (C13976h82.class) {
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
