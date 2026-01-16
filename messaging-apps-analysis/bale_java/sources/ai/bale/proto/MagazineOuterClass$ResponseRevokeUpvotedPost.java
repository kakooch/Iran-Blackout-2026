package ai.bale.proto;

import ai.bale.proto.MagazineStruct$MagazineUpvotes;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class MagazineOuterClass$ResponseRevokeUpvotedPost extends GeneratedMessageLite implements U64 {
    private static final MagazineOuterClass$ResponseRevokeUpvotedPost DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UPVOTES_FIELD_NUMBER = 1;
    private int bitField0_;
    private MagazineStruct$MagazineUpvotes upvotes_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MagazineOuterClass$ResponseRevokeUpvotedPost.DEFAULT_INSTANCE);
        }
    }

    static {
        MagazineOuterClass$ResponseRevokeUpvotedPost magazineOuterClass$ResponseRevokeUpvotedPost = new MagazineOuterClass$ResponseRevokeUpvotedPost();
        DEFAULT_INSTANCE = magazineOuterClass$ResponseRevokeUpvotedPost;
        GeneratedMessageLite.registerDefaultInstance(MagazineOuterClass$ResponseRevokeUpvotedPost.class, magazineOuterClass$ResponseRevokeUpvotedPost);
    }

    private MagazineOuterClass$ResponseRevokeUpvotedPost() {
    }

    private void clearUpvotes() {
        this.upvotes_ = null;
        this.bitField0_ &= -2;
    }

    public static MagazineOuterClass$ResponseRevokeUpvotedPost getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeUpvotes(MagazineStruct$MagazineUpvotes magazineStruct$MagazineUpvotes) {
        magazineStruct$MagazineUpvotes.getClass();
        MagazineStruct$MagazineUpvotes magazineStruct$MagazineUpvotes2 = this.upvotes_;
        if (magazineStruct$MagazineUpvotes2 == null || magazineStruct$MagazineUpvotes2 == MagazineStruct$MagazineUpvotes.getDefaultInstance()) {
            this.upvotes_ = magazineStruct$MagazineUpvotes;
        } else {
            this.upvotes_ = (MagazineStruct$MagazineUpvotes) ((MagazineStruct$MagazineUpvotes.a) MagazineStruct$MagazineUpvotes.newBuilder(this.upvotes_).v(magazineStruct$MagazineUpvotes)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MagazineOuterClass$ResponseRevokeUpvotedPost parseDelimitedFrom(InputStream inputStream) {
        return (MagazineOuterClass$ResponseRevokeUpvotedPost) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$ResponseRevokeUpvotedPost parseFrom(ByteBuffer byteBuffer) {
        return (MagazineOuterClass$ResponseRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUpvotes(MagazineStruct$MagazineUpvotes magazineStruct$MagazineUpvotes) {
        magazineStruct$MagazineUpvotes.getClass();
        this.upvotes_ = magazineStruct$MagazineUpvotes;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineOuterClass$ResponseRevokeUpvotedPost();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "upvotes_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineOuterClass$ResponseRevokeUpvotedPost.class) {
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

    public MagazineStruct$MagazineUpvotes getUpvotes() {
        MagazineStruct$MagazineUpvotes magazineStruct$MagazineUpvotes = this.upvotes_;
        return magazineStruct$MagazineUpvotes == null ? MagazineStruct$MagazineUpvotes.getDefaultInstance() : magazineStruct$MagazineUpvotes;
    }

    public boolean hasUpvotes() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MagazineOuterClass$ResponseRevokeUpvotedPost magazineOuterClass$ResponseRevokeUpvotedPost) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineOuterClass$ResponseRevokeUpvotedPost);
    }

    public static MagazineOuterClass$ResponseRevokeUpvotedPost parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$ResponseRevokeUpvotedPost) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$ResponseRevokeUpvotedPost parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineOuterClass$ResponseRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineOuterClass$ResponseRevokeUpvotedPost parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineOuterClass$ResponseRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static MagazineOuterClass$ResponseRevokeUpvotedPost parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineOuterClass$ResponseRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineOuterClass$ResponseRevokeUpvotedPost parseFrom(byte[] bArr) {
        return (MagazineOuterClass$ResponseRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineOuterClass$ResponseRevokeUpvotedPost parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineOuterClass$ResponseRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineOuterClass$ResponseRevokeUpvotedPost parseFrom(InputStream inputStream) {
        return (MagazineOuterClass$ResponseRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$ResponseRevokeUpvotedPost parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$ResponseRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$ResponseRevokeUpvotedPost parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineOuterClass$ResponseRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineOuterClass$ResponseRevokeUpvotedPost parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineOuterClass$ResponseRevokeUpvotedPost) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
