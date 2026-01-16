package ai.bale.proto;

import ai.bale.proto.PushStruct$UnregisterPush;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class PushOuterClass$RequestUnregisterPush extends GeneratedMessageLite implements U64 {
    private static final PushOuterClass$RequestUnregisterPush DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UNREGISTER_FIELD_NUMBER = 1;
    private int bitField0_;
    private PushStruct$UnregisterPush unregister_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PushOuterClass$RequestUnregisterPush.DEFAULT_INSTANCE);
        }
    }

    static {
        PushOuterClass$RequestUnregisterPush pushOuterClass$RequestUnregisterPush = new PushOuterClass$RequestUnregisterPush();
        DEFAULT_INSTANCE = pushOuterClass$RequestUnregisterPush;
        GeneratedMessageLite.registerDefaultInstance(PushOuterClass$RequestUnregisterPush.class, pushOuterClass$RequestUnregisterPush);
    }

    private PushOuterClass$RequestUnregisterPush() {
    }

    private void clearUnregister() {
        this.unregister_ = null;
        this.bitField0_ &= -2;
    }

    public static PushOuterClass$RequestUnregisterPush getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeUnregister(PushStruct$UnregisterPush pushStruct$UnregisterPush) {
        pushStruct$UnregisterPush.getClass();
        PushStruct$UnregisterPush pushStruct$UnregisterPush2 = this.unregister_;
        if (pushStruct$UnregisterPush2 == null || pushStruct$UnregisterPush2 == PushStruct$UnregisterPush.getDefaultInstance()) {
            this.unregister_ = pushStruct$UnregisterPush;
        } else {
            this.unregister_ = (PushStruct$UnregisterPush) ((PushStruct$UnregisterPush.a) PushStruct$UnregisterPush.newBuilder(this.unregister_).v(pushStruct$UnregisterPush)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PushOuterClass$RequestUnregisterPush parseDelimitedFrom(InputStream inputStream) {
        return (PushOuterClass$RequestUnregisterPush) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushOuterClass$RequestUnregisterPush parseFrom(ByteBuffer byteBuffer) {
        return (PushOuterClass$RequestUnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUnregister(PushStruct$UnregisterPush pushStruct$UnregisterPush) {
        pushStruct$UnregisterPush.getClass();
        this.unregister_ = pushStruct$UnregisterPush;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1878n1.a[gVar.ordinal()]) {
            case 1:
                return new PushOuterClass$RequestUnregisterPush();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "unregister_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PushOuterClass$RequestUnregisterPush.class) {
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

    public PushStruct$UnregisterPush getUnregister() {
        PushStruct$UnregisterPush pushStruct$UnregisterPush = this.unregister_;
        return pushStruct$UnregisterPush == null ? PushStruct$UnregisterPush.getDefaultInstance() : pushStruct$UnregisterPush;
    }

    public boolean hasUnregister() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(PushOuterClass$RequestUnregisterPush pushOuterClass$RequestUnregisterPush) {
        return (a) DEFAULT_INSTANCE.createBuilder(pushOuterClass$RequestUnregisterPush);
    }

    public static PushOuterClass$RequestUnregisterPush parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PushOuterClass$RequestUnregisterPush) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushOuterClass$RequestUnregisterPush parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PushOuterClass$RequestUnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PushOuterClass$RequestUnregisterPush parseFrom(AbstractC2383g abstractC2383g) {
        return (PushOuterClass$RequestUnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PushOuterClass$RequestUnregisterPush parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PushOuterClass$RequestUnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PushOuterClass$RequestUnregisterPush parseFrom(byte[] bArr) {
        return (PushOuterClass$RequestUnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PushOuterClass$RequestUnregisterPush parseFrom(byte[] bArr, C2394s c2394s) {
        return (PushOuterClass$RequestUnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PushOuterClass$RequestUnregisterPush parseFrom(InputStream inputStream) {
        return (PushOuterClass$RequestUnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PushOuterClass$RequestUnregisterPush parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PushOuterClass$RequestUnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PushOuterClass$RequestUnregisterPush parseFrom(AbstractC2384h abstractC2384h) {
        return (PushOuterClass$RequestUnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PushOuterClass$RequestUnregisterPush parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PushOuterClass$RequestUnregisterPush) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
