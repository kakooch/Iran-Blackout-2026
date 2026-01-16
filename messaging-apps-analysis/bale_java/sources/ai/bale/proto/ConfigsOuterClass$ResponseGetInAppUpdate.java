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
public final class ConfigsOuterClass$ResponseGetInAppUpdate extends GeneratedMessageLite implements U64 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 2;
    private static final ConfigsOuterClass$ResponseGetInAppUpdate DEFAULT_INSTANCE;
    public static final int FILE_ID_FIELD_NUMBER = 1;
    public static final int FILE_SIZE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER;
    private long accessHash_;
    private long fileId_;
    private int fileSize_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(ConfigsOuterClass$ResponseGetInAppUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        ConfigsOuterClass$ResponseGetInAppUpdate configsOuterClass$ResponseGetInAppUpdate = new ConfigsOuterClass$ResponseGetInAppUpdate();
        DEFAULT_INSTANCE = configsOuterClass$ResponseGetInAppUpdate;
        GeneratedMessageLite.registerDefaultInstance(ConfigsOuterClass$ResponseGetInAppUpdate.class, configsOuterClass$ResponseGetInAppUpdate);
    }

    private ConfigsOuterClass$ResponseGetInAppUpdate() {
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearFileId() {
        this.fileId_ = 0L;
    }

    private void clearFileSize() {
        this.fileSize_ = 0;
    }

    public static ConfigsOuterClass$ResponseGetInAppUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static ConfigsOuterClass$ResponseGetInAppUpdate parseDelimitedFrom(InputStream inputStream) {
        return (ConfigsOuterClass$ResponseGetInAppUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsOuterClass$ResponseGetInAppUpdate parseFrom(ByteBuffer byteBuffer) {
        return (ConfigsOuterClass$ResponseGetInAppUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    private void setFileId(long j) {
        this.fileId_ = j;
    }

    private void setFileSize(int i) {
        this.fileSize_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (F.a[gVar.ordinal()]) {
            case 1:
                return new ConfigsOuterClass$ResponseGetInAppUpdate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0004", new Object[]{"fileId_", "accessHash_", "fileSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (ConfigsOuterClass$ResponseGetInAppUpdate.class) {
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

    public long getAccessHash() {
        return this.accessHash_;
    }

    public long getFileId() {
        return this.fileId_;
    }

    public int getFileSize() {
        return this.fileSize_;
    }

    public static a newBuilder(ConfigsOuterClass$ResponseGetInAppUpdate configsOuterClass$ResponseGetInAppUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(configsOuterClass$ResponseGetInAppUpdate);
    }

    public static ConfigsOuterClass$ResponseGetInAppUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsOuterClass$ResponseGetInAppUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsOuterClass$ResponseGetInAppUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (ConfigsOuterClass$ResponseGetInAppUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static ConfigsOuterClass$ResponseGetInAppUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (ConfigsOuterClass$ResponseGetInAppUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static ConfigsOuterClass$ResponseGetInAppUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (ConfigsOuterClass$ResponseGetInAppUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static ConfigsOuterClass$ResponseGetInAppUpdate parseFrom(byte[] bArr) {
        return (ConfigsOuterClass$ResponseGetInAppUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ConfigsOuterClass$ResponseGetInAppUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (ConfigsOuterClass$ResponseGetInAppUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static ConfigsOuterClass$ResponseGetInAppUpdate parseFrom(InputStream inputStream) {
        return (ConfigsOuterClass$ResponseGetInAppUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigsOuterClass$ResponseGetInAppUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (ConfigsOuterClass$ResponseGetInAppUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static ConfigsOuterClass$ResponseGetInAppUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (ConfigsOuterClass$ResponseGetInAppUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static ConfigsOuterClass$ResponseGetInAppUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (ConfigsOuterClass$ResponseGetInAppUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
