package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExPeer;
import ai.bale.proto.StoryStruct$MediaStory;
import ai.bale.proto.StoryStruct$TextStory;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KU6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class StoryOuterClass$RequestAddBotStory extends GeneratedMessageLite implements U64 {
    private static final StoryOuterClass$RequestAddBotStory DEFAULT_INSTANCE;
    public static final int EXPIRATION_TYPE_FIELD_NUMBER = 5;
    public static final int EX_PEER_FIELD_NUMBER = 1;
    public static final int MEDIA_STORY_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int TAG_IDS_FIELD_NUMBER = 4;
    public static final int TEXTSTORY_FIELD_NUMBER = 3;
    private int bitField0_;
    private PeersStruct$ExPeer exPeer_;
    private int expirationType_;
    private Object trait_;
    private int traitCase_ = 0;
    private int tagIdsMemoizedSerializedSize = -1;
    private B.g tagIds_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((StoryOuterClass$RequestAddBotStory) this.b).addTagIds(i);
            return this;
        }

        public a B(PeersStruct$ExPeer peersStruct$ExPeer) {
            q();
            ((StoryOuterClass$RequestAddBotStory) this.b).setExPeer(peersStruct$ExPeer);
            return this;
        }

        public a C(StoryStruct$MediaStory storyStruct$MediaStory) {
            q();
            ((StoryOuterClass$RequestAddBotStory) this.b).setMediaStory(storyStruct$MediaStory);
            return this;
        }

        public a D(StoryStruct$TextStory storyStruct$TextStory) {
            q();
            ((StoryOuterClass$RequestAddBotStory) this.b).setTextStory(storyStruct$TextStory);
            return this;
        }

        private a() {
            super(StoryOuterClass$RequestAddBotStory.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        MEDIA_STORY(2),
        TEXTSTORY(3),
        TRAIT_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return TRAIT_NOT_SET;
            }
            if (i == 2) {
                return MEDIA_STORY;
            }
            if (i != 3) {
                return null;
            }
            return TEXTSTORY;
        }
    }

    static {
        StoryOuterClass$RequestAddBotStory storyOuterClass$RequestAddBotStory = new StoryOuterClass$RequestAddBotStory();
        DEFAULT_INSTANCE = storyOuterClass$RequestAddBotStory;
        GeneratedMessageLite.registerDefaultInstance(StoryOuterClass$RequestAddBotStory.class, storyOuterClass$RequestAddBotStory);
    }

    private StoryOuterClass$RequestAddBotStory() {
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

    private void clearExPeer() {
        this.exPeer_ = null;
        this.bitField0_ &= -2;
    }

    private void clearExpirationType() {
        this.expirationType_ = 0;
    }

    private void clearMediaStory() {
        if (this.traitCase_ == 2) {
            this.traitCase_ = 0;
            this.trait_ = null;
        }
    }

    private void clearTagIds() {
        this.tagIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearTextStory() {
        if (this.traitCase_ == 3) {
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

    public static StoryOuterClass$RequestAddBotStory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        PeersStruct$ExPeer peersStruct$ExPeer2 = this.exPeer_;
        if (peersStruct$ExPeer2 == null || peersStruct$ExPeer2 == PeersStruct$ExPeer.getDefaultInstance()) {
            this.exPeer_ = peersStruct$ExPeer;
        } else {
            this.exPeer_ = (PeersStruct$ExPeer) ((PeersStruct$ExPeer.a) PeersStruct$ExPeer.newBuilder(this.exPeer_).v(peersStruct$ExPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeMediaStory(StoryStruct$MediaStory storyStruct$MediaStory) {
        storyStruct$MediaStory.getClass();
        if (this.traitCase_ != 2 || this.trait_ == StoryStruct$MediaStory.getDefaultInstance()) {
            this.trait_ = storyStruct$MediaStory;
        } else {
            this.trait_ = ((StoryStruct$MediaStory.a) StoryStruct$MediaStory.newBuilder((StoryStruct$MediaStory) this.trait_).v(storyStruct$MediaStory)).j();
        }
        this.traitCase_ = 2;
    }

    private void mergeTextStory(StoryStruct$TextStory storyStruct$TextStory) {
        storyStruct$TextStory.getClass();
        if (this.traitCase_ != 3 || this.trait_ == StoryStruct$TextStory.getDefaultInstance()) {
            this.trait_ = storyStruct$TextStory;
        } else {
            this.trait_ = ((StoryStruct$TextStory.a) StoryStruct$TextStory.newBuilder((StoryStruct$TextStory) this.trait_).v(storyStruct$TextStory)).j();
        }
        this.traitCase_ = 3;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static StoryOuterClass$RequestAddBotStory parseDelimitedFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestAddBotStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestAddBotStory parseFrom(ByteBuffer byteBuffer) {
        return (StoryOuterClass$RequestAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExPeer(PeersStruct$ExPeer peersStruct$ExPeer) {
        peersStruct$ExPeer.getClass();
        this.exPeer_ = peersStruct$ExPeer;
        this.bitField0_ |= 1;
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
        this.traitCase_ = 2;
    }

    private void setTagIds(int i, int i2) {
        ensureTagIdsIsMutable();
        this.tagIds_.U(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextStory(StoryStruct$TextStory storyStruct$TextStory) {
        storyStruct$TextStory.getClass();
        this.trait_ = storyStruct$TextStory;
        this.traitCase_ = 3;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c2.a[gVar.ordinal()]) {
            case 1:
                return new StoryOuterClass$RequestAddBotStory();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004'\u0005\f", new Object[]{"trait_", "traitCase_", "bitField0_", "exPeer_", StoryStruct$MediaStory.class, StoryStruct$TextStory.class, "tagIds_", "expirationType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (StoryOuterClass$RequestAddBotStory.class) {
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

    public PeersStruct$ExPeer getExPeer() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer_;
        return peersStruct$ExPeer == null ? PeersStruct$ExPeer.getDefaultInstance() : peersStruct$ExPeer;
    }

    public KU6 getExpirationType() {
        KU6 ku6J = KU6.j(this.expirationType_);
        return ku6J == null ? KU6.UNRECOGNIZED : ku6J;
    }

    public int getExpirationTypeValue() {
        return this.expirationType_;
    }

    public StoryStruct$MediaStory getMediaStory() {
        return this.traitCase_ == 2 ? (StoryStruct$MediaStory) this.trait_ : StoryStruct$MediaStory.getDefaultInstance();
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
        return this.traitCase_ == 3 ? (StoryStruct$TextStory) this.trait_ : StoryStruct$TextStory.getDefaultInstance();
    }

    public b getTraitCase() {
        return b.j(this.traitCase_);
    }

    public boolean hasExPeer() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMediaStory() {
        return this.traitCase_ == 2;
    }

    public boolean hasTextStory() {
        return this.traitCase_ == 3;
    }

    public static a newBuilder(StoryOuterClass$RequestAddBotStory storyOuterClass$RequestAddBotStory) {
        return (a) DEFAULT_INSTANCE.createBuilder(storyOuterClass$RequestAddBotStory);
    }

    public static StoryOuterClass$RequestAddBotStory parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestAddBotStory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestAddBotStory parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (StoryOuterClass$RequestAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static StoryOuterClass$RequestAddBotStory parseFrom(AbstractC2383g abstractC2383g) {
        return (StoryOuterClass$RequestAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static StoryOuterClass$RequestAddBotStory parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (StoryOuterClass$RequestAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static StoryOuterClass$RequestAddBotStory parseFrom(byte[] bArr) {
        return (StoryOuterClass$RequestAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static StoryOuterClass$RequestAddBotStory parseFrom(byte[] bArr, C2394s c2394s) {
        return (StoryOuterClass$RequestAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static StoryOuterClass$RequestAddBotStory parseFrom(InputStream inputStream) {
        return (StoryOuterClass$RequestAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static StoryOuterClass$RequestAddBotStory parseFrom(InputStream inputStream, C2394s c2394s) {
        return (StoryOuterClass$RequestAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static StoryOuterClass$RequestAddBotStory parseFrom(AbstractC2384h abstractC2384h) {
        return (StoryOuterClass$RequestAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static StoryOuterClass$RequestAddBotStory parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (StoryOuterClass$RequestAddBotStory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
