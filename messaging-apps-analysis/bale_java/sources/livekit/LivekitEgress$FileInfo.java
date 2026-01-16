package livekit;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19961rE3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class LivekitEgress$FileInfo extends GeneratedMessageLite implements InterfaceC19961rE3 {
    private static final LivekitEgress$FileInfo DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 6;
    public static final int ENDED_AT_FIELD_NUMBER = 3;
    public static final int FILENAME_FIELD_NUMBER = 1;
    public static final int LOCATION_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int SIZE_FIELD_NUMBER = 4;
    public static final int STARTED_AT_FIELD_NUMBER = 2;
    private long duration_;
    private long endedAt_;
    private String filename_ = "";
    private String location_ = "";
    private long size_;
    private long startedAt_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC19961rE3 {
        /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
            super(LivekitEgress$FileInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        LivekitEgress$FileInfo livekitEgress$FileInfo = new LivekitEgress$FileInfo();
        DEFAULT_INSTANCE = livekitEgress$FileInfo;
        GeneratedMessageLite.registerDefaultInstance(LivekitEgress$FileInfo.class, livekitEgress$FileInfo);
    }

    private LivekitEgress$FileInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDuration() {
        this.duration_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndedAt() {
        this.endedAt_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFilename() {
        this.filename_ = getDefaultInstance().getFilename();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLocation() {
        this.location_ = getDefaultInstance().getLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSize() {
        this.size_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStartedAt() {
        this.startedAt_ = 0L;
    }

    public static LivekitEgress$FileInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LivekitEgress$FileInfo parseDelimitedFrom(InputStream inputStream) {
        return (LivekitEgress$FileInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$FileInfo parseFrom(ByteBuffer byteBuffer) {
        return (LivekitEgress$FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDuration(long j) {
        this.duration_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndedAt(long j) {
        this.endedAt_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilename(String str) {
        str.getClass();
        this.filename_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFilenameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.filename_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocation(String str) {
        str.getClass();
        this.location_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocationBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.location_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSize(long j) {
        this.size_ = j;
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
                return new LivekitEgress$FileInfo();
            case 2:
                return new a(fVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\u0002\u0004\u0002\u0005Ȉ\u0006\u0002", new Object[]{"filename_", "startedAt_", "endedAt_", "size_", "location_", "duration_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LivekitEgress$FileInfo.class) {
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

    public long getDuration() {
        return this.duration_;
    }

    public long getEndedAt() {
        return this.endedAt_;
    }

    public String getFilename() {
        return this.filename_;
    }

    public AbstractC2383g getFilenameBytes() {
        return AbstractC2383g.N(this.filename_);
    }

    public String getLocation() {
        return this.location_;
    }

    public AbstractC2383g getLocationBytes() {
        return AbstractC2383g.N(this.location_);
    }

    public long getSize() {
        return this.size_;
    }

    public long getStartedAt() {
        return this.startedAt_;
    }

    public static a newBuilder(LivekitEgress$FileInfo livekitEgress$FileInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(livekitEgress$FileInfo);
    }

    public static LivekitEgress$FileInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$FileInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$FileInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LivekitEgress$FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LivekitEgress$FileInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (LivekitEgress$FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static LivekitEgress$FileInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LivekitEgress$FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LivekitEgress$FileInfo parseFrom(byte[] bArr) {
        return (LivekitEgress$FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LivekitEgress$FileInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (LivekitEgress$FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LivekitEgress$FileInfo parseFrom(InputStream inputStream) {
        return (LivekitEgress$FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LivekitEgress$FileInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LivekitEgress$FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LivekitEgress$FileInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (LivekitEgress$FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LivekitEgress$FileInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LivekitEgress$FileInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
