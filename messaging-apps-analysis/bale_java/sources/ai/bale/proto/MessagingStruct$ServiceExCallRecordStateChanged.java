package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MessagingStruct$ServiceExCallRecordStateChanged extends GeneratedMessageLite implements U64 {
    private static final MessagingStruct$ServiceExCallRecordStateChanged DEFAULT_INSTANCE;
    public static final int IS_STARTED_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int STARTER_USER_ID_FIELD_NUMBER = 1;
    private boolean isStarted_;
    private int starterUserId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MessagingStruct$ServiceExCallRecordStateChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        MessagingStruct$ServiceExCallRecordStateChanged messagingStruct$ServiceExCallRecordStateChanged = new MessagingStruct$ServiceExCallRecordStateChanged();
        DEFAULT_INSTANCE = messagingStruct$ServiceExCallRecordStateChanged;
        GeneratedMessageLite.registerDefaultInstance(MessagingStruct$ServiceExCallRecordStateChanged.class, messagingStruct$ServiceExCallRecordStateChanged);
    }

    private MessagingStruct$ServiceExCallRecordStateChanged() {
    }

    private void clearIsStarted() {
        this.isStarted_ = false;
    }

    private void clearStarterUserId() {
        this.starterUserId_ = 0;
    }

    public static MessagingStruct$ServiceExCallRecordStateChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MessagingStruct$ServiceExCallRecordStateChanged parseDelimitedFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExCallRecordStateChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExCallRecordStateChanged parseFrom(ByteBuffer byteBuffer) {
        return (MessagingStruct$ServiceExCallRecordStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsStarted(boolean z) {
        this.isStarted_ = z;
    }

    private void setStarterUserId(int i) {
        this.starterUserId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (L0.a[gVar.ordinal()]) {
            case 1:
                return new MessagingStruct$ServiceExCallRecordStateChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0007", new Object[]{"starterUserId_", "isStarted_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MessagingStruct$ServiceExCallRecordStateChanged.class) {
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

    public boolean getIsStarted() {
        return this.isStarted_;
    }

    public int getStarterUserId() {
        return this.starterUserId_;
    }

    public static a newBuilder(MessagingStruct$ServiceExCallRecordStateChanged messagingStruct$ServiceExCallRecordStateChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(messagingStruct$ServiceExCallRecordStateChanged);
    }

    public static MessagingStruct$ServiceExCallRecordStateChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExCallRecordStateChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExCallRecordStateChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MessagingStruct$ServiceExCallRecordStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MessagingStruct$ServiceExCallRecordStateChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (MessagingStruct$ServiceExCallRecordStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MessagingStruct$ServiceExCallRecordStateChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MessagingStruct$ServiceExCallRecordStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MessagingStruct$ServiceExCallRecordStateChanged parseFrom(byte[] bArr) {
        return (MessagingStruct$ServiceExCallRecordStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MessagingStruct$ServiceExCallRecordStateChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (MessagingStruct$ServiceExCallRecordStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MessagingStruct$ServiceExCallRecordStateChanged parseFrom(InputStream inputStream) {
        return (MessagingStruct$ServiceExCallRecordStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MessagingStruct$ServiceExCallRecordStateChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MessagingStruct$ServiceExCallRecordStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MessagingStruct$ServiceExCallRecordStateChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (MessagingStruct$ServiceExCallRecordStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MessagingStruct$ServiceExCallRecordStateChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MessagingStruct$ServiceExCallRecordStateChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
