package ai.bale.proto;

import ai.bale.proto.FilesStruct$FastThumb;
import ai.bale.proto.FilesStruct$FileLocation;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class StoryStruct$VideoStory extends GeneratedMessageLite implements U64 {
    private static final StoryStruct$VideoStory DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 4;
    public static final int FAST_THUMB_FIELD_NUMBER = 2;
    public static final int FILE_LOCATION_FIELD_NUMBER = 1;
    public static final int FILE_SIZE_FIELD_NUMBER = 3;
    public static final int FORMAT_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private float duration_;
    private FilesStruct$FastThumb fastThumb_;
    private FilesStruct$FileLocation fileLocation_;
    private long fileSize_;
    private String format_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(float f) {
            q();
            ((StoryStruct$VideoStory) this.b).setDuration(f);
            return this;
        }

        public a B(FilesStruct$FastThumb filesStruct$FastThumb) {
            q();
            ((StoryStruct$VideoStory) this.b).setFastThumb(filesStruct$FastThumb);
            return this;
        }

        public a C(FilesStruct$FileLocation.a aVar) {
            q();
            ((StoryStruct$VideoStory) this.b).setFileLocation((FilesStruct$FileLocation) aVar.a());
            return this;
        }

        public a D(long j) {
            q();
            ((StoryStruct$VideoStory) this.b).setFileSize(j);
            return this;
        }

        public a E(String str) {
            q();
            ((StoryStruct$VideoStory) this.b).setFormat(str);
            return this;
        }

        private a() {
            super(StoryStruct$VideoStory.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$VideoStory storyStruct$VideoStory = new StoryStruct$VideoStory();
        DEFAULT_INSTANCE = storyStruct$VideoStory;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$VideoStory.class, storyStruct$VideoStory);
    }

    private StoryStruct$VideoStory() {
    }

    private void clearDuration() {
        this.duration_ = 0.0f;
    }

    private void clearFastThumb() {
        this.fastThumb_ = null;
        this.bitField0_ &= -3;
    }

    private void clearFileLocation() {
        this.fileLocation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearFileSize() {
        this.fileSize_ = 0L;
    }

    private void clearFormat() {
        this.format_ = getDefaultInstance().getFormat();
    }

    public static StoryStruct$VideoStory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFastThumb(FilesStruct$FastThumb filesStruct$FastThumb) {
        filesStruct$FastThumb.getClass();
        FilesStruct$FastThumb filesStruct$FastThumb2 = this.fastThumb_;
        if (filesStruct$FastThumb2 == null || filesStruct$FastThumb2 == FilesStruct$FastThumb.getDefaultInstance()) {
            this.fastThumb_ = filesStruct$FastThumb;
        } else {
            this.fastThumb_ = (FilesStruct$FastThumb) ((FilesStruct$FastThumb.a) FilesStruct$FastThumb.newBuilder(this.fastThumb_).v(filesStruct$FastThumb)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.fileLocation_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.fileLocation_ = filesStruct$FileLocation;
        } else {
            this.fileLocation_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.fileLocation_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$VideoStory parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$VideoStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$VideoStory parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$VideoStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDuration(float f) {
        this.duration_ = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFastThumb(FilesStruct$FastThumb filesStruct$FastThumb) {
        filesStruct$FastThumb.getClass();
        this.fastThumb_ = filesStruct$FastThumb;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.fileLocation_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFileSize(long j) {
        this.fileSize_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFormat(String str) {
        str.getClass();
        this.format_ = str;
    }

    private void setFormatBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.format_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$VideoStory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u0002\u0004\u0001\u0005Ȉ", new Object[]{"bitField0_", "fileLocation_", "fastThumb_", "fileSize_", "duration_", "format_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$VideoStory.class) {
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

    public float getDuration() {
        return this.duration_;
    }

    public FilesStruct$FastThumb getFastThumb() {
        FilesStruct$FastThumb filesStruct$FastThumb = this.fastThumb_;
        return filesStruct$FastThumb == null ? FilesStruct$FastThumb.getDefaultInstance() : filesStruct$FastThumb;
    }

    public FilesStruct$FileLocation getFileLocation() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.fileLocation_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public long getFileSize() {
        return this.fileSize_;
    }

    public String getFormat() {
        return this.format_;
    }

    public AbstractC2383g getFormatBytes() {
        return AbstractC2383g.N(this.format_);
    }

    public boolean hasFastThumb() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasFileLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(StoryStruct$VideoStory storyStruct$VideoStory) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$VideoStory);
    }

    public static StoryStruct$VideoStory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$VideoStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$VideoStory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$VideoStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$VideoStory parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$VideoStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryStruct$VideoStory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$VideoStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$VideoStory parseFrom(byte[] bArr) {
        return (StoryStruct$VideoStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$VideoStory parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$VideoStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$VideoStory parseFrom(InputStream inputStream) {
        return (StoryStruct$VideoStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$VideoStory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$VideoStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$VideoStory parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$VideoStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$VideoStory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$VideoStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
