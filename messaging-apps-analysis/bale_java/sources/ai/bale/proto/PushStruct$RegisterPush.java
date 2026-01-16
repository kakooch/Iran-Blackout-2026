package ai.bale.proto;

import ai.bale.proto.PushStruct$APNRegister;
import ai.bale.proto.PushStruct$FirebaseRegister;
import ai.bale.proto.PushStruct$WebRegister;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PushStruct$RegisterPush extends GeneratedMessageLite implements U64 {
    public static final int APN_REGISTER_FIELD_NUMBER = 3;
    private static final PushStruct$RegisterPush DEFAULT_INSTANCE;
    public static final int FIREBASE_REGISTER_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int WEB_REGISTER_FIELD_NUMBER = 1;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PushStruct$FirebaseRegister pushStruct$FirebaseRegister) {
            q();
            ((PushStruct$RegisterPush) this.b).setFirebaseRegister(pushStruct$FirebaseRegister);
            return this;
        }

        private a() {
            super(PushStruct$RegisterPush.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        WEB_REGISTER(1),
        FIREBASE_REGISTER(2),
        APN_REGISTER(3),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return WEB_REGISTER;
            }
            if (i == 2) {
                return FIREBASE_REGISTER;
            }
            if (i != 3) {
                return null;
            }
            return APN_REGISTER;
        }
    }

    static {
        PushStruct$RegisterPush pushStruct$RegisterPush = new PushStruct$RegisterPush();
        DEFAULT_INSTANCE = pushStruct$RegisterPush;
        GeneratedMessageLite.registerDefaultInstance(PushStruct$RegisterPush.class, pushStruct$RegisterPush);
    }

    private PushStruct$RegisterPush() {
    }

    private void clearApnRegister() {
        if (this.traitCase_ == 3) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearFirebaseRegister() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    private void clearWebRegister() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    public static PushStruct$RegisterPush getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeApnRegister(PushStruct$APNRegister pushStruct$APNRegister) {
        pushStruct$APNRegister.getClass();
        if (this.traitCase_ != 3 || this.trait_ == PushStruct$APNRegister.getDefaultInstance()) {
            this.trait_ = pushStruct$APNRegister;
        } else {
            this.trait_ = ((PushStruct$APNRegister.a) PushStruct$APNRegister.newBuilder((PushStruct$APNRegister) this.trait_).v(pushStruct$APNRegister)).j();
        }
        this.traitCase_ = 3;
    }

    private void mergeFirebaseRegister(PushStruct$FirebaseRegister pushStruct$FirebaseRegister) {
        pushStruct$FirebaseRegister.getClass();
        if (this.traitCase_ != 2 || this.trait_ == PushStruct$FirebaseRegister.getDefaultInstance()) {
            this.trait_ = pushStruct$FirebaseRegister;
        } else {
            this.trait_ = ((PushStruct$FirebaseRegister.a) PushStruct$FirebaseRegister.newBuilder((PushStruct$FirebaseRegister) this.trait_).v(pushStruct$FirebaseRegister)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeWebRegister(PushStruct$WebRegister pushStruct$WebRegister) {
        pushStruct$WebRegister.getClass();
        if (this.traitCase_ != 1 || this.trait_ == PushStruct$WebRegister.getDefaultInstance()) {
            this.trait_ = pushStruct$WebRegister;
        } else {
            this.trait_ = ((PushStruct$WebRegister.a) PushStruct$WebRegister.newBuilder((PushStruct$WebRegister) this.trait_).v(pushStruct$WebRegister)).j();
        }
        this.traitCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushStruct$RegisterPush parseDelimitedFrom(InputStream inputStream) {
        return (PushStruct$RegisterPush) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$RegisterPush parseFrom(ByteBuffer byteBuffer) {
        return (PushStruct$RegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setApnRegister(PushStruct$APNRegister pushStruct$APNRegister) {
        pushStruct$APNRegister.getClass();
        this.trait_ = pushStruct$APNRegister;
        this.traitCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFirebaseRegister(PushStruct$FirebaseRegister pushStruct$FirebaseRegister) {
        pushStruct$FirebaseRegister.getClass();
        this.trait_ = pushStruct$FirebaseRegister;
        this.traitCase_ = 2;
    }

    private void setWebRegister(PushStruct$WebRegister pushStruct$WebRegister) {
        pushStruct$WebRegister.getClass();
        this.trait_ = pushStruct$WebRegister;
        this.traitCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1881o1.a[gVar.ordinal()]) {
            case 1:
                return new PushStruct$RegisterPush();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"trait_", "traitCase_", PushStruct$WebRegister.class, PushStruct$FirebaseRegister.class, PushStruct$APNRegister.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushStruct$RegisterPush.class) {
                        try {
                            cVar = PARSER;
                            if (cVar == null) {
                                cVar = new GeneratedMessageLite.c(DEFAULT_INSTANCE);
                                PARSER = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return cVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public PushStruct$APNRegister getApnRegister() {
        return this.traitCase_ == 3 ? (PushStruct$APNRegister) this.trait_ : PushStruct$APNRegister.getDefaultInstance();
    }

    public PushStruct$FirebaseRegister getFirebaseRegister() {
        return this.traitCase_ == 2 ? (PushStruct$FirebaseRegister) this.trait_ : PushStruct$FirebaseRegister.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public PushStruct$WebRegister getWebRegister() {
        return this.traitCase_ == 1 ? (PushStruct$WebRegister) this.trait_ : PushStruct$WebRegister.getDefaultInstance();
    }

    public boolean hasApnRegister() {
        return this.traitCase_ == 3;
    }

    public boolean hasFirebaseRegister() {
        return this.traitCase_ == 2;
    }

    public boolean hasWebRegister() {
        return this.traitCase_ == 1;
    }

    public static a newBuilder(PushStruct$RegisterPush pushStruct$RegisterPush) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushStruct$RegisterPush);
    }

    public static PushStruct$RegisterPush parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$RegisterPush) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$RegisterPush parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushStruct$RegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushStruct$RegisterPush parseFrom(AbstractC2383g abstractC2383g) {
        return (PushStruct$RegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushStruct$RegisterPush parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushStruct$RegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushStruct$RegisterPush parseFrom(byte[] bArr) {
        return (PushStruct$RegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushStruct$RegisterPush parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushStruct$RegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushStruct$RegisterPush parseFrom(InputStream inputStream) {
        return (PushStruct$RegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$RegisterPush parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$RegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$RegisterPush parseFrom(AbstractC2384h abstractC2384h) {
        return (PushStruct$RegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushStruct$RegisterPush parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushStruct$RegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
