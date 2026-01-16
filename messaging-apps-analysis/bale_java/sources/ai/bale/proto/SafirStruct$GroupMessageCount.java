package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.N96;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SafirStruct$GroupMessageCount extends GeneratedMessageLite implements N96 {
    public static final int COUNT_FIELD_NUMBER = 1;
    private static final SafirStruct$GroupMessageCount DEFAULT_INSTANCE;
    public static final int GROUP_TIME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private long count_;
    private long groupTime_;

    public static final class a extends GeneratedMessageLite.b implements N96 {
        private a() {
            super(SafirStruct$GroupMessageCount.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirStruct$GroupMessageCount safirStruct$GroupMessageCount = new SafirStruct$GroupMessageCount();
        DEFAULT_INSTANCE = safirStruct$GroupMessageCount;
        GeneratedMessageLite.registerDefaultInstance(SafirStruct$GroupMessageCount.class, safirStruct$GroupMessageCount);
    }

    private SafirStruct$GroupMessageCount() {
    }

    private void clearCount() {
        this.count_ = 0L;
    }

    private void clearGroupTime() {
        this.groupTime_ = 0L;
    }

    public static SafirStruct$GroupMessageCount getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirStruct$GroupMessageCount parseDelimitedFrom(InputStream inputStream) {
        return (SafirStruct$GroupMessageCount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$GroupMessageCount parseFrom(ByteBuffer byteBuffer) {
        return (SafirStruct$GroupMessageCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCount(long j) {
        this.count_ = j;
    }

    private void setGroupTime(long j) {
        this.groupTime_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G1.a[gVar.ordinal()]) {
            case 1:
                return new SafirStruct$GroupMessageCount();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0002", new Object[]{"count_", "groupTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirStruct$GroupMessageCount.class) {
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

    public long getCount() {
        return this.count_;
    }

    public long getGroupTime() {
        return this.groupTime_;
    }

    public static a newBuilder(SafirStruct$GroupMessageCount safirStruct$GroupMessageCount) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirStruct$GroupMessageCount);
    }

    public static SafirStruct$GroupMessageCount parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$GroupMessageCount) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$GroupMessageCount parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirStruct$GroupMessageCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirStruct$GroupMessageCount parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirStruct$GroupMessageCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirStruct$GroupMessageCount parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirStruct$GroupMessageCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirStruct$GroupMessageCount parseFrom(byte[] bArr) {
        return (SafirStruct$GroupMessageCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirStruct$GroupMessageCount parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirStruct$GroupMessageCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirStruct$GroupMessageCount parseFrom(InputStream inputStream) {
        return (SafirStruct$GroupMessageCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$GroupMessageCount parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$GroupMessageCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$GroupMessageCount parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirStruct$GroupMessageCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirStruct$GroupMessageCount parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirStruct$GroupMessageCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
