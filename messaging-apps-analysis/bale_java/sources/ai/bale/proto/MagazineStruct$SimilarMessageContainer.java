package ai.bale.proto;

import ai.bale.proto.MagazineStruct$FeedMessageContainer;
import ai.bale.proto.MagazineStruct$SimilarMessageParentId;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EM3;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MagazineStruct$SimilarMessageContainer extends GeneratedMessageLite implements EM3 {
    private static final MagazineStruct$SimilarMessageContainer DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 1;
    public static final int PARENT_ID_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private MagazineStruct$FeedMessageContainer message_;
    private MagazineStruct$SimilarMessageParentId parentId_;

    public static final class a extends GeneratedMessageLite.b implements EM3 {
        private a() {
            super(MagazineStruct$SimilarMessageContainer.DEFAULT_INSTANCE);
        }
    }

    static {
        MagazineStruct$SimilarMessageContainer magazineStruct$SimilarMessageContainer = new MagazineStruct$SimilarMessageContainer();
        DEFAULT_INSTANCE = magazineStruct$SimilarMessageContainer;
        GeneratedMessageLite.registerDefaultInstance(MagazineStruct$SimilarMessageContainer.class, magazineStruct$SimilarMessageContainer);
    }

    private MagazineStruct$SimilarMessageContainer() {
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    private void clearParentId() {
        this.parentId_ = null;
        this.bitField0_ &= -3;
    }

    public static MagazineStruct$SimilarMessageContainer getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeMessage(MagazineStruct$FeedMessageContainer magazineStruct$FeedMessageContainer) {
        magazineStruct$FeedMessageContainer.getClass();
        MagazineStruct$FeedMessageContainer magazineStruct$FeedMessageContainer2 = this.message_;
        if (magazineStruct$FeedMessageContainer2 == null || magazineStruct$FeedMessageContainer2 == MagazineStruct$FeedMessageContainer.getDefaultInstance()) {
            this.message_ = magazineStruct$FeedMessageContainer;
        } else {
            this.message_ = (MagazineStruct$FeedMessageContainer) ((MagazineStruct$FeedMessageContainer.a) MagazineStruct$FeedMessageContainer.newBuilder(this.message_).v(magazineStruct$FeedMessageContainer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeParentId(MagazineStruct$SimilarMessageParentId magazineStruct$SimilarMessageParentId) {
        magazineStruct$SimilarMessageParentId.getClass();
        MagazineStruct$SimilarMessageParentId magazineStruct$SimilarMessageParentId2 = this.parentId_;
        if (magazineStruct$SimilarMessageParentId2 == null || magazineStruct$SimilarMessageParentId2 == MagazineStruct$SimilarMessageParentId.getDefaultInstance()) {
            this.parentId_ = magazineStruct$SimilarMessageParentId;
        } else {
            this.parentId_ = (MagazineStruct$SimilarMessageParentId) ((MagazineStruct$SimilarMessageParentId.a) MagazineStruct$SimilarMessageParentId.newBuilder(this.parentId_).v(magazineStruct$SimilarMessageParentId)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MagazineStruct$SimilarMessageContainer parseDelimitedFrom(InputStream inputStream) {
        return (MagazineStruct$SimilarMessageContainer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$SimilarMessageContainer parseFrom(ByteBuffer byteBuffer) {
        return (MagazineStruct$SimilarMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMessage(MagazineStruct$FeedMessageContainer magazineStruct$FeedMessageContainer) {
        magazineStruct$FeedMessageContainer.getClass();
        this.message_ = magazineStruct$FeedMessageContainer;
        this.bitField0_ |= 1;
    }

    private void setParentId(MagazineStruct$SimilarMessageParentId magazineStruct$SimilarMessageParentId) {
        magazineStruct$SimilarMessageParentId.getClass();
        this.parentId_ = magazineStruct$SimilarMessageParentId;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (B0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineStruct$SimilarMessageContainer();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "message_", "parentId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineStruct$SimilarMessageContainer.class) {
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

    public MagazineStruct$FeedMessageContainer getMessage() {
        MagazineStruct$FeedMessageContainer magazineStruct$FeedMessageContainer = this.message_;
        return magazineStruct$FeedMessageContainer == null ? MagazineStruct$FeedMessageContainer.getDefaultInstance() : magazineStruct$FeedMessageContainer;
    }

    public MagazineStruct$SimilarMessageParentId getParentId() {
        MagazineStruct$SimilarMessageParentId magazineStruct$SimilarMessageParentId = this.parentId_;
        return magazineStruct$SimilarMessageParentId == null ? MagazineStruct$SimilarMessageParentId.getDefaultInstance() : magazineStruct$SimilarMessageParentId;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasParentId() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(MagazineStruct$SimilarMessageContainer magazineStruct$SimilarMessageContainer) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineStruct$SimilarMessageContainer);
    }

    public static MagazineStruct$SimilarMessageContainer parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$SimilarMessageContainer) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$SimilarMessageContainer parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineStruct$SimilarMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineStruct$SimilarMessageContainer parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineStruct$SimilarMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MagazineStruct$SimilarMessageContainer parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineStruct$SimilarMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineStruct$SimilarMessageContainer parseFrom(byte[] bArr) {
        return (MagazineStruct$SimilarMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineStruct$SimilarMessageContainer parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineStruct$SimilarMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineStruct$SimilarMessageContainer parseFrom(InputStream inputStream) {
        return (MagazineStruct$SimilarMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineStruct$SimilarMessageContainer parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineStruct$SimilarMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineStruct$SimilarMessageContainer parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineStruct$SimilarMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineStruct$SimilarMessageContainer parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineStruct$SimilarMessageContainer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
