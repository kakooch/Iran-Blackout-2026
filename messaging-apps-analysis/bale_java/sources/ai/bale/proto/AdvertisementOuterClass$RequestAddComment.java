package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class AdvertisementOuterClass$RequestAddComment extends GeneratedMessageLite implements U64 {
    public static final int COMMENT_FIELD_NUMBER = 2;
    private static final AdvertisementOuterClass$RequestAddComment DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private String comment_ = "";
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestAddComment.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestAddComment advertisementOuterClass$RequestAddComment = new AdvertisementOuterClass$RequestAddComment();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestAddComment;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestAddComment.class, advertisementOuterClass$RequestAddComment);
    }

    private AdvertisementOuterClass$RequestAddComment() {
    }

    private void clearComment() {
        this.comment_ = getDefaultInstance().getComment();
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static AdvertisementOuterClass$RequestAddComment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestAddComment parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestAddComment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestAddComment parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestAddComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setComment(String str) {
        str.getClass();
        this.comment_ = str;
    }

    private void setCommentBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.comment_ = abstractC2383g.f0();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestAddComment();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"userId_", "comment_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestAddComment.class) {
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

    public String getComment() {
        return this.comment_;
    }

    public AbstractC2383g getCommentBytes() {
        return AbstractC2383g.N(this.comment_);
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestAddComment advertisementOuterClass$RequestAddComment) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestAddComment);
    }

    public static AdvertisementOuterClass$RequestAddComment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddComment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddComment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddComment parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestAddComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestAddComment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddComment parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestAddComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestAddComment parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddComment parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestAddComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestAddComment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestAddComment parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestAddComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestAddComment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestAddComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
