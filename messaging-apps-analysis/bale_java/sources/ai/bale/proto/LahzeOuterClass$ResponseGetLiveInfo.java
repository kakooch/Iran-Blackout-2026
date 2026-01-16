package ai.bale.proto;

import ai.bale.proto.LahzeStruct$LiveInfo;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class LahzeOuterClass$ResponseGetLiveInfo extends GeneratedMessageLite implements U64 {
    private static final LahzeOuterClass$ResponseGetLiveInfo DEFAULT_INSTANCE;
    public static final int INFO_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private LahzeStruct$LiveInfo info_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LahzeOuterClass$ResponseGetLiveInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LahzeOuterClass$ResponseGetLiveInfo lahzeOuterClass$ResponseGetLiveInfo = new LahzeOuterClass$ResponseGetLiveInfo();
        DEFAULT_INSTANCE = lahzeOuterClass$ResponseGetLiveInfo;
        GeneratedMessageLite.registerDefaultInstance(LahzeOuterClass$ResponseGetLiveInfo.class, lahzeOuterClass$ResponseGetLiveInfo);
    }

    private LahzeOuterClass$ResponseGetLiveInfo() {
    }

    private void clearInfo() {
        this.info_ = null;
        this.bitField0_ &= -2;
    }

    public static LahzeOuterClass$ResponseGetLiveInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeInfo(LahzeStruct$LiveInfo lahzeStruct$LiveInfo) {
        lahzeStruct$LiveInfo.getClass();
        LahzeStruct$LiveInfo lahzeStruct$LiveInfo2 = this.info_;
        if (lahzeStruct$LiveInfo2 == null || lahzeStruct$LiveInfo2 == LahzeStruct$LiveInfo.getDefaultInstance()) {
            this.info_ = lahzeStruct$LiveInfo;
        } else {
            this.info_ = (LahzeStruct$LiveInfo) ((LahzeStruct$LiveInfo.a) LahzeStruct$LiveInfo.newBuilder(this.info_).v(lahzeStruct$LiveInfo)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LahzeOuterClass$ResponseGetLiveInfo parseDelimitedFrom(InputStream inputStream) {
        return (LahzeOuterClass$ResponseGetLiveInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeOuterClass$ResponseGetLiveInfo parseFrom(ByteBuffer byteBuffer) {
        return (LahzeOuterClass$ResponseGetLiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setInfo(LahzeStruct$LiveInfo lahzeStruct$LiveInfo) {
        lahzeStruct$LiveInfo.getClass();
        this.info_ = lahzeStruct$LiveInfo;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1903w0.a[gVar.ordinal()]) {
            case 1:
                return new LahzeOuterClass$ResponseGetLiveInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "info_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LahzeOuterClass$ResponseGetLiveInfo.class) {
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

    public LahzeStruct$LiveInfo getInfo() {
        LahzeStruct$LiveInfo lahzeStruct$LiveInfo = this.info_;
        return lahzeStruct$LiveInfo == null ? LahzeStruct$LiveInfo.getDefaultInstance() : lahzeStruct$LiveInfo;
    }

    public boolean hasInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(LahzeOuterClass$ResponseGetLiveInfo lahzeOuterClass$ResponseGetLiveInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(lahzeOuterClass$ResponseGetLiveInfo);
    }

    public static LahzeOuterClass$ResponseGetLiveInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeOuterClass$ResponseGetLiveInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeOuterClass$ResponseGetLiveInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LahzeOuterClass$ResponseGetLiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LahzeOuterClass$ResponseGetLiveInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LahzeOuterClass$ResponseGetLiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LahzeOuterClass$ResponseGetLiveInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LahzeOuterClass$ResponseGetLiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LahzeOuterClass$ResponseGetLiveInfo parseFrom(byte[] bArr) {
        return (LahzeOuterClass$ResponseGetLiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LahzeOuterClass$ResponseGetLiveInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LahzeOuterClass$ResponseGetLiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LahzeOuterClass$ResponseGetLiveInfo parseFrom(InputStream inputStream) {
        return (LahzeOuterClass$ResponseGetLiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeOuterClass$ResponseGetLiveInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeOuterClass$ResponseGetLiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeOuterClass$ResponseGetLiveInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LahzeOuterClass$ResponseGetLiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LahzeOuterClass$ResponseGetLiveInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LahzeOuterClass$ResponseGetLiveInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
