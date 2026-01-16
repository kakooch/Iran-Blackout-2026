package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC21173tE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitEgress$ImagesInfo extends GeneratedMessageLite implements InterfaceC21173tE3 {
    private static final LivekitEgress$ImagesInfo DEFAULT_INSTANCE;
    public static final int ENDED_AT_FIELD_NUMBER = 3;
    public static final int FILENAME_PREFIX_FIELD_NUMBER = 4;
    public static final int IMAGE_COUNT_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int STARTED_AT_FIELD_NUMBER = 2;
    private long endedAt_;
    private String filenamePrefix_ = "";
    private long imageCount_;
    private long startedAt_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC21173tE3 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$ImagesInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$ImagesInfo livekitEgress$ImagesInfo = new LivekitEgress$ImagesInfo();
        DEFAULT_INSTANCE = livekitEgress$ImagesInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$ImagesInfo.class, livekitEgress$ImagesInfo);
    }

    private LivekitEgress$ImagesInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndedAt() {
        this.endedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFilenamePrefix() {
        this.filenamePrefix_ = getDefaultInstance().getFilenamePrefix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearImageCount() {
        this.imageCount_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartedAt() {
        this.startedAt_ = 0L;
    }

    public static LivekitEgress$ImagesInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$ImagesInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$ImagesInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$ImagesInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$ImagesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndedAt(long j) {
        this.endedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilenamePrefix(String str) {
        str.getClass();
        this.filenamePrefix_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilenamePrefixBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.filenamePrefix_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageCount(long j) {
        this.imageCount_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStartedAt(long j) {
        this.startedAt_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        f fVar = null;
        switch (f.a[gVar.ordinal()]) {
            case 1:
                return new LivekitEgress$ImagesInfo();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0002\u0003\u0002\u0004Ȉ", new Object[]{"imageCount_", "startedAt_", "endedAt_", "filenamePrefix_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$ImagesInfo.class) {
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

    public long getEndedAt() {
        return this.endedAt_;
    }

    public String getFilenamePrefix() {
        return this.filenamePrefix_;
    }

    public AbstractC2383g getFilenamePrefixBytes() {
        return AbstractC2383g.N(this.filenamePrefix_);
    }

    public long getImageCount() {
        return this.imageCount_;
    }

    public long getStartedAt() {
        return this.startedAt_;
    }

    public static a newBuilder(LivekitEgress$ImagesInfo livekitEgress$ImagesInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$ImagesInfo);
    }

    public static LivekitEgress$ImagesInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$ImagesInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$ImagesInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$ImagesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$ImagesInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$ImagesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$ImagesInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$ImagesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$ImagesInfo parseFrom(byte[] bArr) {
        return (LivekitEgress$ImagesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$ImagesInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$ImagesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$ImagesInfo parseFrom(InputStream inputStream) {
        return (LivekitEgress$ImagesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$ImagesInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$ImagesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$ImagesInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$ImagesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$ImagesInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$ImagesInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
