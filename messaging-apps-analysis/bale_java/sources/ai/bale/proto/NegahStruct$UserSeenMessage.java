package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22206uq4;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class NegahStruct$UserSeenMessage extends GeneratedMessageLite implements InterfaceC22206uq4 {
    private static final NegahStruct$UserSeenMessage DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC22206uq4 {
        private a() {
            super(NegahStruct$UserSeenMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        NegahStruct$UserSeenMessage negahStruct$UserSeenMessage = new NegahStruct$UserSeenMessage();
        DEFAULT_INSTANCE = negahStruct$UserSeenMessage;
        GeneratedMessageLite.registerDefaultInstance(NegahStruct$UserSeenMessage.class, negahStruct$UserSeenMessage);
    }

    private NegahStruct$UserSeenMessage() {
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static NegahStruct$UserSeenMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static NegahStruct$UserSeenMessage parseDelimitedFrom(InputStream inputStream) {
        return (NegahStruct$UserSeenMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NegahStruct$UserSeenMessage parseFrom(ByteBuffer byteBuffer) {
        return (NegahStruct$UserSeenMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (T0.a[gVar.ordinal()]) {
            case 1:
                return new NegahStruct$UserSeenMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"userId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (NegahStruct$UserSeenMessage.class) {
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

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(NegahStruct$UserSeenMessage negahStruct$UserSeenMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(negahStruct$UserSeenMessage);
    }

    public static NegahStruct$UserSeenMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (NegahStruct$UserSeenMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static NegahStruct$UserSeenMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (NegahStruct$UserSeenMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static NegahStruct$UserSeenMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (NegahStruct$UserSeenMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static NegahStruct$UserSeenMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (NegahStruct$UserSeenMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static NegahStruct$UserSeenMessage parseFrom(byte[] bArr) {
        return (NegahStruct$UserSeenMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NegahStruct$UserSeenMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (NegahStruct$UserSeenMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static NegahStruct$UserSeenMessage parseFrom(InputStream inputStream) {
        return (NegahStruct$UserSeenMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NegahStruct$UserSeenMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (NegahStruct$UserSeenMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static NegahStruct$UserSeenMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (NegahStruct$UserSeenMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static NegahStruct$UserSeenMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (NegahStruct$UserSeenMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
