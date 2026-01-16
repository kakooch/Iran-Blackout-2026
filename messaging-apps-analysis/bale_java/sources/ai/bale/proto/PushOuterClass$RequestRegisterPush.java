package ai.bale.proto;

import ai.bale.proto.PushStruct$RegisterPush;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PushOuterClass$RequestRegisterPush extends GeneratedMessageLite implements U64 {
    private static final PushOuterClass$RequestRegisterPush DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PUSH_VERSION_FIELD_NUMBER = 2;
    public static final int REGISTER_FIELD_NUMBER = 1;
    private int bitField0_;
    private int pushVersion_;
    private PushStruct$RegisterPush register_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((PushOuterClass$RequestRegisterPush) this.b).setPushVersion(i);
            return this;
        }

        public a B(PushStruct$RegisterPush pushStruct$RegisterPush) {
            q();
            ((PushOuterClass$RequestRegisterPush) this.b).setRegister(pushStruct$RegisterPush);
            return this;
        }

        private a() {
            super(PushOuterClass$RequestRegisterPush.DEFAULT_INSTANCE);
        }
    }

    static {
        PushOuterClass$RequestRegisterPush pushOuterClass$RequestRegisterPush = new PushOuterClass$RequestRegisterPush();
        DEFAULT_INSTANCE = pushOuterClass$RequestRegisterPush;
        GeneratedMessageLite.registerDefaultInstance(PushOuterClass$RequestRegisterPush.class, pushOuterClass$RequestRegisterPush);
    }

    private PushOuterClass$RequestRegisterPush() {
    }

    private void clearPushVersion() {
        this.pushVersion_ = 0;
    }

    private void clearRegister() {
        this.register_ = null;
        this.bitField0_ &= -2;
    }

    public static PushOuterClass$RequestRegisterPush getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRegister(PushStruct$RegisterPush pushStruct$RegisterPush) {
        pushStruct$RegisterPush.getClass();
        PushStruct$RegisterPush pushStruct$RegisterPush2 = this.register_;
        if (pushStruct$RegisterPush2 == null || pushStruct$RegisterPush2 == PushStruct$RegisterPush.getDefaultInstance()) {
            this.register_ = pushStruct$RegisterPush;
        } else {
            this.register_ = (PushStruct$RegisterPush) ((PushStruct$RegisterPush.a) PushStruct$RegisterPush.newBuilder(this.register_).v(pushStruct$RegisterPush)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushOuterClass$RequestRegisterPush parseDelimitedFrom(InputStream inputStream) {
        return (PushOuterClass$RequestRegisterPush) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushOuterClass$RequestRegisterPush parseFrom(ByteBuffer byteBuffer) {
        return (PushOuterClass$RequestRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPushVersion(int i) {
        this.pushVersion_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegister(PushStruct$RegisterPush pushStruct$RegisterPush) {
        pushStruct$RegisterPush.getClass();
        this.register_ = pushStruct$RegisterPush;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1878n1.a[gVar.ordinal()]) {
            case 1:
                return new PushOuterClass$RequestRegisterPush();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004", new Object[]{"bitField0_", "register_", "pushVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushOuterClass$RequestRegisterPush.class) {
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

    public int getPushVersion() {
        return this.pushVersion_;
    }

    public PushStruct$RegisterPush getRegister() {
        PushStruct$RegisterPush pushStruct$RegisterPush = this.register_;
        return pushStruct$RegisterPush == null ? PushStruct$RegisterPush.getDefaultInstance() : pushStruct$RegisterPush;
    }

    public boolean hasRegister() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PushOuterClass$RequestRegisterPush pushOuterClass$RequestRegisterPush) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushOuterClass$RequestRegisterPush);
    }

    public static PushOuterClass$RequestRegisterPush parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushOuterClass$RequestRegisterPush) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushOuterClass$RequestRegisterPush parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushOuterClass$RequestRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushOuterClass$RequestRegisterPush parseFrom(AbstractC2383g abstractC2383g) {
        return (PushOuterClass$RequestRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushOuterClass$RequestRegisterPush parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushOuterClass$RequestRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushOuterClass$RequestRegisterPush parseFrom(byte[] bArr) {
        return (PushOuterClass$RequestRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushOuterClass$RequestRegisterPush parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushOuterClass$RequestRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushOuterClass$RequestRegisterPush parseFrom(InputStream inputStream) {
        return (PushOuterClass$RequestRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushOuterClass$RequestRegisterPush parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushOuterClass$RequestRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushOuterClass$RequestRegisterPush parseFrom(AbstractC2384h abstractC2384h) {
        return (PushOuterClass$RequestRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushOuterClass$RequestRegisterPush parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushOuterClass$RequestRegisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
