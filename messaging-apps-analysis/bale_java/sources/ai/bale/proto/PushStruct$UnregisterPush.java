package ai.bale.proto;

import ai.bale.proto.PushStruct$APNUnregister;
import ai.bale.proto.PushStruct$FirebaseUnregister;
import ai.bale.proto.PushStruct$WebUnregister;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PushStruct$UnregisterPush extends GeneratedMessageLite implements U64 {
    public static final int APN_UNREGISTER_FIELD_NUMBER = 3;
    private static final PushStruct$UnregisterPush DEFAULT_INSTANCE;
    public static final int FIREBASE_REGISTER_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int WEB_REGISTER_FIELD_NUMBER = 1;
    private int traitCase_ = 0;
    private Object trait_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushStruct$UnregisterPush.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        WEB_REGISTER(1),
        FIREBASE_REGISTER(2),
        APN_UNREGISTER(3),
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
            return APN_UNREGISTER;
        }
    }

    static {
        PushStruct$UnregisterPush pushStruct$UnregisterPush = new PushStruct$UnregisterPush();
        DEFAULT_INSTANCE = pushStruct$UnregisterPush;
        GeneratedMessageLite.registerDefaultInstance(PushStruct$UnregisterPush.class, pushStruct$UnregisterPush);
    }

    private PushStruct$UnregisterPush() {
    }

    private void clearApnUnregister() {
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

    public static PushStruct$UnregisterPush getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeApnUnregister(PushStruct$APNUnregister pushStruct$APNUnregister) {
        pushStruct$APNUnregister.getClass();
        if (this.traitCase_ != 3 || this.trait_ == PushStruct$APNUnregister.getDefaultInstance()) {
            this.trait_ = pushStruct$APNUnregister;
        } else {
            this.trait_ = ((PushStruct$APNUnregister.a) PushStruct$APNUnregister.newBuilder((PushStruct$APNUnregister) this.trait_).v(pushStruct$APNUnregister)).j();
        }
        this.traitCase_ = 3;
    }

    private void mergeFirebaseRegister(PushStruct$FirebaseUnregister pushStruct$FirebaseUnregister) {
        pushStruct$FirebaseUnregister.getClass();
        if (this.traitCase_ != 2 || this.trait_ == PushStruct$FirebaseUnregister.getDefaultInstance()) {
            this.trait_ = pushStruct$FirebaseUnregister;
        } else {
            this.trait_ = ((PushStruct$FirebaseUnregister.a) PushStruct$FirebaseUnregister.newBuilder((PushStruct$FirebaseUnregister) this.trait_).v(pushStruct$FirebaseUnregister)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeWebRegister(PushStruct$WebUnregister pushStruct$WebUnregister) {
        pushStruct$WebUnregister.getClass();
        if (this.traitCase_ != 1 || this.trait_ == PushStruct$WebUnregister.getDefaultInstance()) {
            this.trait_ = pushStruct$WebUnregister;
        } else {
            this.trait_ = ((PushStruct$WebUnregister.a) PushStruct$WebUnregister.newBuilder((PushStruct$WebUnregister) this.trait_).v(pushStruct$WebUnregister)).j();
        }
        this.traitCase_ = 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushStruct$UnregisterPush parseDelimitedFrom(InputStream inputStream) {
        return (PushStruct$UnregisterPush) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$UnregisterPush parseFrom(ByteBuffer byteBuffer) {
        return (PushStruct$UnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setApnUnregister(PushStruct$APNUnregister pushStruct$APNUnregister) {
        pushStruct$APNUnregister.getClass();
        this.trait_ = pushStruct$APNUnregister;
        this.traitCase_ = 3;
    }

    private void setFirebaseRegister(PushStruct$FirebaseUnregister pushStruct$FirebaseUnregister) {
        pushStruct$FirebaseUnregister.getClass();
        this.trait_ = pushStruct$FirebaseUnregister;
        this.traitCase_ = 2;
    }

    private void setWebRegister(PushStruct$WebUnregister pushStruct$WebUnregister) {
        pushStruct$WebUnregister.getClass();
        this.trait_ = pushStruct$WebUnregister;
        this.traitCase_ = 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1881o1.a[gVar.ordinal()]) {
            case 1:
                return new PushStruct$UnregisterPush();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"trait_", "traitCase_", PushStruct$WebUnregister.class, PushStruct$FirebaseUnregister.class, PushStruct$APNUnregister.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushStruct$UnregisterPush.class) {
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

    public PushStruct$APNUnregister getApnUnregister() {
        return this.traitCase_ == 3 ? (PushStruct$APNUnregister) this.trait_ : PushStruct$APNUnregister.getDefaultInstance();
    }

    public PushStruct$FirebaseUnregister getFirebaseRegister() {
        return this.traitCase_ == 2 ? (PushStruct$FirebaseUnregister) this.trait_ : PushStruct$FirebaseUnregister.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public PushStruct$WebUnregister getWebRegister() {
        return this.traitCase_ == 1 ? (PushStruct$WebUnregister) this.trait_ : PushStruct$WebUnregister.getDefaultInstance();
    }

    public boolean hasApnUnregister() {
        return this.traitCase_ == 3;
    }

    public boolean hasFirebaseRegister() {
        return this.traitCase_ == 2;
    }

    public boolean hasWebRegister() {
        return this.traitCase_ == 1;
    }

    public static a newBuilder(PushStruct$UnregisterPush pushStruct$UnregisterPush) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushStruct$UnregisterPush);
    }

    public static PushStruct$UnregisterPush parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$UnregisterPush) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$UnregisterPush parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushStruct$UnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushStruct$UnregisterPush parseFrom(AbstractC2383g abstractC2383g) {
        return (PushStruct$UnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushStruct$UnregisterPush parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushStruct$UnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushStruct$UnregisterPush parseFrom(byte[] bArr) {
        return (PushStruct$UnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushStruct$UnregisterPush parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushStruct$UnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushStruct$UnregisterPush parseFrom(InputStream inputStream) {
        return (PushStruct$UnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushStruct$UnregisterPush parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushStruct$UnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushStruct$UnregisterPush parseFrom(AbstractC2384h abstractC2384h) {
        return (PushStruct$UnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushStruct$UnregisterPush parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushStruct$UnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
