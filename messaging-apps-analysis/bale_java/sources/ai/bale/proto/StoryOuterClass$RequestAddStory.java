package ai.bale.proto;

import ai.bale.proto.StoryStruct$MediaStory;
import ai.bale.proto.StoryStruct$TextStory;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC21337tU6;
import ir.nasim.KU6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryOuterClass$RequestAddStory extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$RequestAddStory DEFAULT_INSTANCE;
    public static final int EXCEPTION_TYPE_FIELD_NUMBER = 12;
    public static final int EXPIRATION_TYPE_FIELD_NUMBER = 11;
    public static final int MEDIASTORY_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int TAG_IDS_FIELD_NUMBER = 10;
    public static final int TEXTSTORY_FIELD_NUMBER = 2;
    private int exceptionType_;
    private int expirationType_;
    private Object trait_;
    private int traitCase_ = 0;
    private int tagIdsMemoizedSerializedSize = -1;
    private B.g tagIds_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((StoryOuterClass$RequestAddStory) this.b).addTagIds(i);
            return this;
        }

        public a B(EnumC21337tU6 enumC21337tU6) {
            q();
            ((StoryOuterClass$RequestAddStory) this.b).setExceptionType(enumC21337tU6);
            return this;
        }

        public a C(StoryStruct$MediaStory storyStruct$MediaStory) {
            q();
            ((StoryOuterClass$RequestAddStory) this.b).setMediaStory(storyStruct$MediaStory);
            return this;
        }

        public a D(StoryStruct$TextStory storyStruct$TextStory) {
            q();
            ((StoryOuterClass$RequestAddStory) this.b).setTextStory(storyStruct$TextStory);
            return this;
        }

        private a() {
            super(StoryOuterClass$RequestAddStory.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        MEDIASTORY(1),
        TEXTSTORY(2),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 1) {
                return MEDIASTORY;
            }
            if (i != 2) {
                return null;
            }
            return TEXTSTORY;
        }
    }

    static {
        StoryOuterClass$RequestAddStory storyOuterClass$RequestAddStory = new StoryOuterClass$RequestAddStory();
        DEFAULT_INSTANCE = storyOuterClass$RequestAddStory;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$RequestAddStory.class, storyOuterClass$RequestAddStory);
    }

    private StoryOuterClass$RequestAddStory() {
    }

    private void addAllTagIds(Iterable<? extends Integer> iterable) {
        ensureTagIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.tagIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTagIds(int i) {
        ensureTagIdsIsMutable();
        this.tagIds_.b1(i);
    }

    private void clearExceptionType() {
        this.exceptionType_ = 0;
    }

    private void clearExpirationType() {
        this.expirationType_ = 0;
    }

    private void clearMediaStory() {
        if (this.traitCase_ == 1) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTagIds() {
        this.tagIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearTextStory() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTrait() {
        this.traitCase_ = 0;
        this.trait_ = null;
    }

    private void ensureTagIdsIsMutable() {
        B.g gVar = this.tagIds_;
        if (gVar.u()) {
            return;
        }
        this.tagIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static StoryOuterClass$RequestAddStory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMediaStory(StoryStruct$MediaStory storyStruct$MediaStory) {
        storyStruct$MediaStory.getClass();
        if (this.traitCase_ != 1 || this.trait_ == StoryStruct$MediaStory.getDefaultInstance()) {
            this.trait_ = storyStruct$MediaStory;
        } else {
            this.trait_ = ((StoryStruct$MediaStory.a) StoryStruct$MediaStory.newBuilder((StoryStruct$MediaStory) this.trait_).v(storyStruct$MediaStory)).j();
        }
        this.traitCase_ = 1;
    }

    private void mergeTextStory(StoryStruct$TextStory storyStruct$TextStory) {
        storyStruct$TextStory.getClass();
        if (this.traitCase_ != 2 || this.trait_ == StoryStruct$TextStory.getDefaultInstance()) {
            this.trait_ = storyStruct$TextStory;
        } else {
            this.trait_ = ((StoryStruct$TextStory.a) StoryStruct$TextStory.newBuilder((StoryStruct$TextStory) this.trait_).v(storyStruct$TextStory)).j();
        }
        this.traitCase_ = 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$RequestAddStory parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestAddStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestAddStory parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$RequestAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExceptionType(EnumC21337tU6 enumC21337tU6) {
        this.exceptionType_ = enumC21337tU6.getNumber();
    }

    private void setExceptionTypeValue(int i) {
        this.exceptionType_ = i;
    }

    private void setExpirationType(KU6 ku6) {
        this.expirationType_ = ku6.getNumber();
    }

    private void setExpirationTypeValue(int i) {
        this.expirationType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaStory(StoryStruct$MediaStory storyStruct$MediaStory) {
        storyStruct$MediaStory.getClass();
        this.trait_ = storyStruct$MediaStory;
        this.traitCase_ = 1;
    }

    private void setTagIds(int i, int i2) {
        ensureTagIdsIsMutable();
        this.tagIds_.U(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextStory(StoryStruct$TextStory storyStruct$TextStory) {
        storyStruct$TextStory.getClass();
        this.trait_ = storyStruct$TextStory;
        this.traitCase_ = 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$RequestAddStory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0001\f\u0005\u0000\u0001\u0000\u0001<\u0000\u0002<\u0000\n'\u000b\f\f\f", new Object[]{"trait_", "traitCase_", StoryStruct$MediaStory.class, StoryStruct$TextStory.class, "tagIds_", "expirationType_", "exceptionType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$RequestAddStory.class) {
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

    public EnumC21337tU6 getExceptionType() {
        EnumC21337tU6 enumC21337tU6J = EnumC21337tU6.j(this.exceptionType_);
        return enumC21337tU6J == null ? EnumC21337tU6.UNRECOGNIZED : enumC21337tU6J;
    }

    public int getExceptionTypeValue() {
        return this.exceptionType_;
    }

    public KU6 getExpirationType() {
        KU6 ku6J = KU6.j(this.expirationType_);
        return ku6J == null ? KU6.UNRECOGNIZED : ku6J;
    }

    public int getExpirationTypeValue() {
        return this.expirationType_;
    }

    public StoryStruct$MediaStory getMediaStory() {
        return this.traitCase_ == 1 ? (StoryStruct$MediaStory) this.trait_ : StoryStruct$MediaStory.getDefaultInstance();
    }

    public int getTagIds(int i) {
        return this.tagIds_.getInt(i);
    }

    public int getTagIdsCount() {
        return this.tagIds_.size();
    }

    public List<Integer> getTagIdsList() {
        return this.tagIds_;
    }

    public StoryStruct$TextStory getTextStory() {
        return this.traitCase_ == 2 ? (StoryStruct$TextStory) this.trait_ : StoryStruct$TextStory.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasMediaStory() {
        return this.traitCase_ == 1;
    }

    public boolean hasTextStory() {
        return this.traitCase_ == 2;
    }

    public static a newBuilder(StoryOuterClass$RequestAddStory storyOuterClass$RequestAddStory) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$RequestAddStory);
    }

    public static StoryOuterClass$RequestAddStory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestAddStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestAddStory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$RequestAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$RequestAddStory parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$RequestAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$RequestAddStory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$RequestAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$RequestAddStory parseFrom(byte[] bArr) {
        return (StoryOuterClass$RequestAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$RequestAddStory parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$RequestAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$RequestAddStory parseFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestAddStory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestAddStory parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$RequestAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$RequestAddStory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$RequestAddStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
