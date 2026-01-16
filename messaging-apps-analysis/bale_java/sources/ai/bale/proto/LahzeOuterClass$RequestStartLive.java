package ai.bale.proto;

import ai.bale.proto.LahzeStruct$LiveMessageRequirements;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class LahzeOuterClass$RequestStartLive extends GeneratedMessageLite implements U64 {
    private static final LahzeOuterClass$RequestStartLive DEFAULT_INSTANCE;
    public static final int IS_PREVIEW_FIELD_NUMBER = 2;
    public static final int KEY_FIELD_NUMBER = 1;
    public static final int LIVE_MESSAGE_REQUIREMENTS_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private boolean isPreview_;
    private long key_;
    private LahzeStruct$LiveMessageRequirements liveMessageRequirements_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LahzeOuterClass$RequestStartLive.DEFAULT_INSTANCE);
        }
    }

    static {
        LahzeOuterClass$RequestStartLive lahzeOuterClass$RequestStartLive = new LahzeOuterClass$RequestStartLive();
        DEFAULT_INSTANCE = lahzeOuterClass$RequestStartLive;
        GeneratedMessageLite.registerDefaultInstance(LahzeOuterClass$RequestStartLive.class, lahzeOuterClass$RequestStartLive);
    }

    private LahzeOuterClass$RequestStartLive() {
    }

    private void clearIsPreview() {
        this.isPreview_ = false;
    }

    private void clearKey() {
        this.key_ = 0L;
    }

    private void clearLiveMessageRequirements() {
        this.liveMessageRequirements_ = null;
        this.bitField0_ &= -2;
    }

    public static LahzeOuterClass$RequestStartLive getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLiveMessageRequirements(LahzeStruct$LiveMessageRequirements lahzeStruct$LiveMessageRequirements) {
        lahzeStruct$LiveMessageRequirements.getClass();
        LahzeStruct$LiveMessageRequirements lahzeStruct$LiveMessageRequirements2 = this.liveMessageRequirements_;
        if (lahzeStruct$LiveMessageRequirements2 == null || lahzeStruct$LiveMessageRequirements2 == LahzeStruct$LiveMessageRequirements.getDefaultInstance()) {
            this.liveMessageRequirements_ = lahzeStruct$LiveMessageRequirements;
        } else {
            this.liveMessageRequirements_ = (LahzeStruct$LiveMessageRequirements) ((LahzeStruct$LiveMessageRequirements.a) LahzeStruct$LiveMessageRequirements.newBuilder(this.liveMessageRequirements_).v(lahzeStruct$LiveMessageRequirements)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LahzeOuterClass$RequestStartLive parseDelimitedFrom(InputStream inputStream) {
        return (LahzeOuterClass$RequestStartLive) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeOuterClass$RequestStartLive parseFrom(ByteBuffer byteBuffer) {
        return (LahzeOuterClass$RequestStartLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setIsPreview(boolean z) {
        this.isPreview_ = z;
    }

    private void setKey(long j) {
        this.key_ = j;
    }

    private void setLiveMessageRequirements(LahzeStruct$LiveMessageRequirements lahzeStruct$LiveMessageRequirements) {
        lahzeStruct$LiveMessageRequirements.getClass();
        this.liveMessageRequirements_ = lahzeStruct$LiveMessageRequirements;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1903w0.a[gVar.ordinal()]) {
            case 1:
                return new LahzeOuterClass$RequestStartLive();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0007\u0003ဉ\u0000", new Object[]{"bitField0_", "key_", "isPreview_", "liveMessageRequirements_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LahzeOuterClass$RequestStartLive.class) {
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

    public boolean getIsPreview() {
        return this.isPreview_;
    }

    public long getKey() {
        return this.key_;
    }

    public LahzeStruct$LiveMessageRequirements getLiveMessageRequirements() {
        LahzeStruct$LiveMessageRequirements lahzeStruct$LiveMessageRequirements = this.liveMessageRequirements_;
        return lahzeStruct$LiveMessageRequirements == null ? LahzeStruct$LiveMessageRequirements.getDefaultInstance() : lahzeStruct$LiveMessageRequirements;
    }

    public boolean hasLiveMessageRequirements() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(LahzeOuterClass$RequestStartLive lahzeOuterClass$RequestStartLive) {
        return (a) DEFAULT_INSTANCE.createBuilder(lahzeOuterClass$RequestStartLive);
    }

    public static LahzeOuterClass$RequestStartLive parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeOuterClass$RequestStartLive) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeOuterClass$RequestStartLive parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LahzeOuterClass$RequestStartLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LahzeOuterClass$RequestStartLive parseFrom(AbstractC2383g abstractC2383g) {
        return (LahzeOuterClass$RequestStartLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LahzeOuterClass$RequestStartLive parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LahzeOuterClass$RequestStartLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LahzeOuterClass$RequestStartLive parseFrom(byte[] bArr) {
        return (LahzeOuterClass$RequestStartLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LahzeOuterClass$RequestStartLive parseFrom(byte[] bArr, C2394s c2394s) {
        return (LahzeOuterClass$RequestStartLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LahzeOuterClass$RequestStartLive parseFrom(InputStream inputStream) {
        return (LahzeOuterClass$RequestStartLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeOuterClass$RequestStartLive parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeOuterClass$RequestStartLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeOuterClass$RequestStartLive parseFrom(AbstractC2384h abstractC2384h) {
        return (LahzeOuterClass$RequestStartLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LahzeOuterClass$RequestStartLive parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LahzeOuterClass$RequestStartLive) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
