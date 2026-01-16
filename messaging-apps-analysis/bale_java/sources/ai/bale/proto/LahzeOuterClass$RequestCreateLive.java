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
public final class LahzeOuterClass$RequestCreateLive extends GeneratedMessageLite implements U64 {
    private static final LahzeOuterClass$RequestCreateLive DEFAULT_INSTANCE;
    public static final int GROUP_ID_FIELD_NUMBER = 1;
    public static final int MAIN_MESSAGE_DATE_FIELD_NUMBER = 3;
    public static final int MAIN_MESSAGE_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int groupId_;
    private long mainMessageDate_;
    private long mainMessageId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LahzeOuterClass$RequestCreateLive.DEFAULT_INSTANCE);
        }
    }

    static {
        LahzeOuterClass$RequestCreateLive lahzeOuterClass$RequestCreateLive = new LahzeOuterClass$RequestCreateLive();
        DEFAULT_INSTANCE = lahzeOuterClass$RequestCreateLive;
        GeneratedMessageLite.registerDefaultInstance(LahzeOuterClass$RequestCreateLive.class, lahzeOuterClass$RequestCreateLive);
    }

    private LahzeOuterClass$RequestCreateLive() {
    }

    private void clearGroupId() {
        this.groupId_ = 0;
    }

    private void clearMainMessageDate() {
        this.mainMessageDate_ = 0L;
    }

    private void clearMainMessageId() {
        this.mainMessageId_ = 0L;
    }

    public static LahzeOuterClass$RequestCreateLive getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LahzeOuterClass$RequestCreateLive parseDelimitedFrom(InputStream inputStream) {
        return (LahzeOuterClass$RequestCreateLive) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeOuterClass$RequestCreateLive parseFrom(ByteBuffer byteBuffer) {
        return (LahzeOuterClass$RequestCreateLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGroupId(int i) {
        this.groupId_ = i;
    }

    private void setMainMessageDate(long j) {
        this.mainMessageDate_ = j;
    }

    private void setMainMessageId(long j) {
        this.mainMessageId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1903w0.a[gVar.ordinal()]) {
            case 1:
                return new LahzeOuterClass$RequestCreateLive();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002", new Object[]{"groupId_", "mainMessageId_", "mainMessageDate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LahzeOuterClass$RequestCreateLive.class) {
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

    public int getGroupId() {
        return this.groupId_;
    }

    public long getMainMessageDate() {
        return this.mainMessageDate_;
    }

    public long getMainMessageId() {
        return this.mainMessageId_;
    }

    public static a newBuilder(LahzeOuterClass$RequestCreateLive lahzeOuterClass$RequestCreateLive) {
        return (a) DEFAULT_INSTANCE.createBuilder(lahzeOuterClass$RequestCreateLive);
    }

    public static LahzeOuterClass$RequestCreateLive parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeOuterClass$RequestCreateLive) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeOuterClass$RequestCreateLive parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LahzeOuterClass$RequestCreateLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LahzeOuterClass$RequestCreateLive parseFrom(AbstractC2383g abstractC2383g) {
        return (LahzeOuterClass$RequestCreateLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LahzeOuterClass$RequestCreateLive parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LahzeOuterClass$RequestCreateLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LahzeOuterClass$RequestCreateLive parseFrom(byte[] bArr) {
        return (LahzeOuterClass$RequestCreateLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LahzeOuterClass$RequestCreateLive parseFrom(byte[] bArr, C2394s c2394s) {
        return (LahzeOuterClass$RequestCreateLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LahzeOuterClass$RequestCreateLive parseFrom(InputStream inputStream) {
        return (LahzeOuterClass$RequestCreateLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeOuterClass$RequestCreateLive parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeOuterClass$RequestCreateLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeOuterClass$RequestCreateLive parseFrom(AbstractC2384h abstractC2384h) {
        return (LahzeOuterClass$RequestCreateLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LahzeOuterClass$RequestCreateLive parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LahzeOuterClass$RequestCreateLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
