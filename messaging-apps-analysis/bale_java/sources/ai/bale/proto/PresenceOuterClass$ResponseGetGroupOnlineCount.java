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
public final class PresenceOuterClass$ResponseGetGroupOnlineCount extends GeneratedMessageLite implements U64 {
    public static final int COUNT_FIELD_NUMBER = 1;
    private static final PresenceOuterClass$ResponseGetGroupOnlineCount DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int count_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PresenceOuterClass$ResponseGetGroupOnlineCount.DEFAULT_INSTANCE);
        }
    }

    static {
        PresenceOuterClass$ResponseGetGroupOnlineCount presenceOuterClass$ResponseGetGroupOnlineCount = new PresenceOuterClass$ResponseGetGroupOnlineCount();
        DEFAULT_INSTANCE = presenceOuterClass$ResponseGetGroupOnlineCount;
        GeneratedMessageLite.registerDefaultInstance(PresenceOuterClass$ResponseGetGroupOnlineCount.class, presenceOuterClass$ResponseGetGroupOnlineCount);
    }

    private PresenceOuterClass$ResponseGetGroupOnlineCount() {
    }

    private void clearCount() {
        this.count_ = 0;
    }

    public static PresenceOuterClass$ResponseGetGroupOnlineCount getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PresenceOuterClass$ResponseGetGroupOnlineCount parseDelimitedFrom(InputStream inputStream) {
        return (PresenceOuterClass$ResponseGetGroupOnlineCount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$ResponseGetGroupOnlineCount parseFrom(ByteBuffer byteBuffer) {
        return (PresenceOuterClass$ResponseGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCount(int i) {
        this.count_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1866j1.a[gVar.ordinal()]) {
            case 1:
                return new PresenceOuterClass$ResponseGetGroupOnlineCount();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"count_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PresenceOuterClass$ResponseGetGroupOnlineCount.class) {
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

    public int getCount() {
        return this.count_;
    }

    public static a newBuilder(PresenceOuterClass$ResponseGetGroupOnlineCount presenceOuterClass$ResponseGetGroupOnlineCount) {
        return (a) DEFAULT_INSTANCE.createBuilder(presenceOuterClass$ResponseGetGroupOnlineCount);
    }

    public static PresenceOuterClass$ResponseGetGroupOnlineCount parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$ResponseGetGroupOnlineCount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$ResponseGetGroupOnlineCount parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PresenceOuterClass$ResponseGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PresenceOuterClass$ResponseGetGroupOnlineCount parseFrom(AbstractC2383g abstractC2383g) {
        return (PresenceOuterClass$ResponseGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PresenceOuterClass$ResponseGetGroupOnlineCount parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PresenceOuterClass$ResponseGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PresenceOuterClass$ResponseGetGroupOnlineCount parseFrom(byte[] bArr) {
        return (PresenceOuterClass$ResponseGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PresenceOuterClass$ResponseGetGroupOnlineCount parseFrom(byte[] bArr, C2394s c2394s) {
        return (PresenceOuterClass$ResponseGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PresenceOuterClass$ResponseGetGroupOnlineCount parseFrom(InputStream inputStream) {
        return (PresenceOuterClass$ResponseGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PresenceOuterClass$ResponseGetGroupOnlineCount parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PresenceOuterClass$ResponseGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PresenceOuterClass$ResponseGetGroupOnlineCount parseFrom(AbstractC2384h abstractC2384h) {
        return (PresenceOuterClass$ResponseGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PresenceOuterClass$ResponseGetGroupOnlineCount parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PresenceOuterClass$ResponseGetGroupOnlineCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
