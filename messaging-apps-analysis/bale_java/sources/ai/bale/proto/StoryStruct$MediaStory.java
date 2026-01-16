package ai.bale.proto;

import ai.bale.proto.FilesStruct$FastThumb;
import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.StoryStruct$VideoStory;
import ai.bale.proto.StoryStruct$Widget;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC24360yU6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryStruct$MediaStory extends GeneratedMessageLite implements InterfaceC24360yU6 {
    private static final StoryStruct$MediaStory DEFAULT_INSTANCE;
    public static final int FAST_THUMB_FIELD_NUMBER = 2;
    public static final int FILE_LOCATION_FIELD_NUMBER = 1;
    public static final int FILE_SIZE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int VIDEO_FIELD_NUMBER = 4;
    public static final int WIDGET_FIELD_NUMBER = 5;
    private int bitField0_;
    private FilesStruct$FastThumb fastThumb_;
    private FilesStruct$FileLocation fileLocation_;
    private long fileSize_;
    private StoryStruct$VideoStory video_;
    private B.j widget_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements InterfaceC24360yU6 {
        public a A(StoryStruct$Widget.a aVar) {
            q();
            ((StoryStruct$MediaStory) this.b).addWidget((StoryStruct$Widget) aVar.a());
            return this;
        }

        public a B(StoryStruct$Widget storyStruct$Widget) {
            q();
            ((StoryStruct$MediaStory) this.b).addWidget(storyStruct$Widget);
            return this;
        }

        public a C(FilesStruct$FastThumb filesStruct$FastThumb) {
            q();
            ((StoryStruct$MediaStory) this.b).setFastThumb(filesStruct$FastThumb);
            return this;
        }

        public a D(FilesStruct$FileLocation.a aVar) {
            q();
            ((StoryStruct$MediaStory) this.b).setFileLocation((FilesStruct$FileLocation) aVar.a());
            return this;
        }

        public a E(long j) {
            q();
            ((StoryStruct$MediaStory) this.b).setFileSize(j);
            return this;
        }

        public a F(StoryStruct$VideoStory storyStruct$VideoStory) {
            q();
            ((StoryStruct$MediaStory) this.b).setVideo(storyStruct$VideoStory);
            return this;
        }

        private a() {
            super(StoryStruct$MediaStory.DEFAULT_INSTANCE);
        }
    }

    static {
        StoryStruct$MediaStory storyStruct$MediaStory = new StoryStruct$MediaStory();
        DEFAULT_INSTANCE = storyStruct$MediaStory;
        GeneratedMessageLite.registerDefaultInstance(StoryStruct$MediaStory.class, storyStruct$MediaStory);
    }

    private StoryStruct$MediaStory() {
    }

    private void addAllWidget(Iterable<? extends StoryStruct$Widget> iterable) {
        ensureWidgetIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.widget_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWidget(StoryStruct$Widget storyStruct$Widget) {
        storyStruct$Widget.getClass();
        ensureWidgetIsMutable();
        this.widget_.add(storyStruct$Widget);
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

    private void clearVideo() {
        this.video_ = null;
        this.bitField0_ &= -5;
    }

    private void clearWidget() {
        this.widget_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureWidgetIsMutable() {
        B.j jVar = this.widget_;
        if (jVar.u()) {
            return;
        }
        this.widget_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static StoryStruct$MediaStory getDefaultInstance() {
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

    private void mergeVideo(StoryStruct$VideoStory storyStruct$VideoStory) {
        storyStruct$VideoStory.getClass();
        StoryStruct$VideoStory storyStruct$VideoStory2 = this.video_;
        if (storyStruct$VideoStory2 == null || storyStruct$VideoStory2 == StoryStruct$VideoStory.getDefaultInstance()) {
            this.video_ = storyStruct$VideoStory;
        } else {
            this.video_ = (StoryStruct$VideoStory) ((StoryStruct$VideoStory.a) StoryStruct$VideoStory.newBuilder(this.video_).v(storyStruct$VideoStory)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryStruct$MediaStory parseDelimitedFrom(InputStream inputStream) {
        return (StoryStruct$MediaStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$MediaStory parseFrom(ByteBuffer byteBuffer) {
        return (StoryStruct$MediaStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeWidget(int i) {
        ensureWidgetIsMutable();
        this.widget_.remove(i);
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
    public void setVideo(StoryStruct$VideoStory storyStruct$VideoStory) {
        storyStruct$VideoStory.getClass();
        this.video_ = storyStruct$VideoStory;
        this.bitField0_ |= 4;
    }

    private void setWidget(int i, StoryStruct$Widget storyStruct$Widget) {
        storyStruct$Widget.getClass();
        ensureWidgetIsMutable();
        this.widget_.set(i, storyStruct$Widget);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (d2.a[gVar.ordinal()]) {
            case 1:
                return new StoryStruct$MediaStory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u0002\u0004ဉ\u0002\u0005\u001b", new Object[]{"bitField0_", "fileLocation_", "fastThumb_", "fileSize_", "video_", "widget_", StoryStruct$Widget.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryStruct$MediaStory.class) {
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

    public StoryStruct$VideoStory getVideo() {
        StoryStruct$VideoStory storyStruct$VideoStory = this.video_;
        return storyStruct$VideoStory == null ? StoryStruct$VideoStory.getDefaultInstance() : storyStruct$VideoStory;
    }

    public StoryStruct$Widget getWidget(int i) {
        return (StoryStruct$Widget) this.widget_.get(i);
    }

    public int getWidgetCount() {
        return this.widget_.size();
    }

    public List<StoryStruct$Widget> getWidgetList() {
        return this.widget_;
    }

    public f2 getWidgetOrBuilder(int i) {
        return (f2) this.widget_.get(i);
    }

    public List<? extends f2> getWidgetOrBuilderList() {
        return this.widget_;
    }

    public boolean hasFastThumb() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasFileLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasVideo() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(StoryStruct$MediaStory storyStruct$MediaStory) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyStruct$MediaStory);
    }

    public static StoryStruct$MediaStory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$MediaStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$MediaStory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryStruct$MediaStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryStruct$MediaStory parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryStruct$MediaStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addWidget(int i, StoryStruct$Widget storyStruct$Widget) {
        storyStruct$Widget.getClass();
        ensureWidgetIsMutable();
        this.widget_.add(i, storyStruct$Widget);
    }

    public static StoryStruct$MediaStory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryStruct$MediaStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryStruct$MediaStory parseFrom(byte[] bArr) {
        return (StoryStruct$MediaStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryStruct$MediaStory parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryStruct$MediaStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryStruct$MediaStory parseFrom(InputStream inputStream) {
        return (StoryStruct$MediaStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryStruct$MediaStory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryStruct$MediaStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryStruct$MediaStory parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryStruct$MediaStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryStruct$MediaStory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryStruct$MediaStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
