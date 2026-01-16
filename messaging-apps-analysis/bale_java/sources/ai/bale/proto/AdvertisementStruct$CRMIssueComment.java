package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC19033pg;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class AdvertisementStruct$CRMIssueComment extends GeneratedMessageLite implements InterfaceC19033pg {
    public static final int COMMENT_FIELD_NUMBER = 1;
    public static final int CREATED_AT_FIELD_NUMBER = 2;
    private static final AdvertisementStruct$CRMIssueComment DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int WRITER_PEER_ID_FIELD_NUMBER = 3;
    private String comment_ = "";
    private long createdAt_;
    private int writerPeerId_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC19033pg {
        private a() {
            super(AdvertisementStruct$CRMIssueComment.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementStruct$CRMIssueComment advertisementStruct$CRMIssueComment = new AdvertisementStruct$CRMIssueComment();
        DEFAULT_INSTANCE = advertisementStruct$CRMIssueComment;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementStruct$CRMIssueComment.class, advertisementStruct$CRMIssueComment);
    }

    private AdvertisementStruct$CRMIssueComment() {
    }

    private void clearComment() {
        this.comment_ = getDefaultInstance().getComment();
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearWriterPeerId() {
        this.writerPeerId_ = 0;
    }

    public static AdvertisementStruct$CRMIssueComment getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementStruct$CRMIssueComment parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementStruct$CRMIssueComment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$CRMIssueComment parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementStruct$CRMIssueComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
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

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setWriterPeerId(int i) {
        this.writerPeerId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1843c.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementStruct$CRMIssueComment();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\u0004", new Object[]{"comment_", "createdAt_", "writerPeerId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementStruct$CRMIssueComment.class) {
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

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public int getWriterPeerId() {
        return this.writerPeerId_;
    }

    public static a newBuilder(AdvertisementStruct$CRMIssueComment advertisementStruct$CRMIssueComment) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementStruct$CRMIssueComment);
    }

    public static AdvertisementStruct$CRMIssueComment parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$CRMIssueComment) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$CRMIssueComment parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementStruct$CRMIssueComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementStruct$CRMIssueComment parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementStruct$CRMIssueComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementStruct$CRMIssueComment parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementStruct$CRMIssueComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementStruct$CRMIssueComment parseFrom(byte[] bArr) {
        return (AdvertisementStruct$CRMIssueComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementStruct$CRMIssueComment parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementStruct$CRMIssueComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementStruct$CRMIssueComment parseFrom(InputStream inputStream) {
        return (AdvertisementStruct$CRMIssueComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementStruct$CRMIssueComment parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementStruct$CRMIssueComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementStruct$CRMIssueComment parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementStruct$CRMIssueComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementStruct$CRMIssueComment parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementStruct$CRMIssueComment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
