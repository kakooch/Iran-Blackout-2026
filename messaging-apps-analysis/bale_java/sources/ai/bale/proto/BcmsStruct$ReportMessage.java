package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11838de0;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BcmsStruct$ReportMessage extends GeneratedMessageLite implements InterfaceC11838de0 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 7;
    private static final BcmsStruct$ReportMessage DEFAULT_INSTANCE;
    public static final int FILE_ID_FIELD_NUMBER = 6;
    public static final int FILE_MIME_FIELD_NUMBER = 8;
    public static final int FILE_SIZE_FIELD_NUMBER = 9;
    public static final int FORWARD_FROM_ID_FIELD_NUMBER = 2;
    public static final int FORWARD_FROM_USER_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int RID_FIELD_NUMBER = 5;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private long accessHash_;
    private long fileId_;
    private String fileMime_ = "";
    private float fileSize_;
    private long forwardFromId_;
    private boolean forwardFromUser_;
    private long rid_;
    private long timestamp_;
    private long userId_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC11838de0 {
        private a() {
            super(BcmsStruct$ReportMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        BcmsStruct$ReportMessage bcmsStruct$ReportMessage = new BcmsStruct$ReportMessage();
        DEFAULT_INSTANCE = bcmsStruct$ReportMessage;
        GeneratedMessageLite.registerDefaultInstance(BcmsStruct$ReportMessage.class, bcmsStruct$ReportMessage);
    }

    private BcmsStruct$ReportMessage() {
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearFileId() {
        this.fileId_ = 0L;
    }

    private void clearFileMime() {
        this.fileMime_ = getDefaultInstance().getFileMime();
    }

    private void clearFileSize() {
        this.fileSize_ = 0.0f;
    }

    private void clearForwardFromId() {
        this.forwardFromId_ = 0L;
    }

    private void clearForwardFromUser() {
        this.forwardFromUser_ = false;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearTimestamp() {
        this.timestamp_ = 0L;
    }

    private void clearUserId() {
        this.userId_ = 0L;
    }

    public static BcmsStruct$ReportMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BcmsStruct$ReportMessage parseDelimitedFrom(InputStream inputStream) {
        return (BcmsStruct$ReportMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BcmsStruct$ReportMessage parseFrom(ByteBuffer byteBuffer) {
        return (BcmsStruct$ReportMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    private void setFileId(long j) {
        this.fileId_ = j;
    }

    private void setFileMime(String str) {
        str.getClass();
        this.fileMime_ = str;
    }

    private void setFileMimeBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fileMime_ = abstractC2383g.f0();
    }

    private void setFileSize(float f) {
        this.fileSize_ = f;
    }

    private void setForwardFromId(long j) {
        this.forwardFromId_ = j;
    }

    private void setForwardFromUser(boolean z) {
        this.forwardFromUser_ = z;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    private void setTimestamp(long j) {
        this.timestamp_ = j;
    }

    private void setUserId(long j) {
        this.userId_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1885q.a[gVar.ordinal()]) {
            case 1:
                return new BcmsStruct$ReportMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001\u0003\u0002\u0003\u0003\u0007\u0004\u0003\u0005\u0002\u0006\u0002\u0007\u0003\bȈ\t\u0001", new Object[]{"userId_", "forwardFromId_", "forwardFromUser_", "timestamp_", "rid_", "fileId_", "accessHash_", "fileMime_", "fileSize_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BcmsStruct$ReportMessage.class) {
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

    public long getAccessHash() {
        return this.accessHash_;
    }

    public long getFileId() {
        return this.fileId_;
    }

    public String getFileMime() {
        return this.fileMime_;
    }

    public AbstractC2383g getFileMimeBytes() {
        return AbstractC2383g.N(this.fileMime_);
    }

    public float getFileSize() {
        return this.fileSize_;
    }

    public long getForwardFromId() {
        return this.forwardFromId_;
    }

    public boolean getForwardFromUser() {
        return this.forwardFromUser_;
    }

    public long getRid() {
        return this.rid_;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public long getUserId() {
        return this.userId_;
    }

    public static a newBuilder(BcmsStruct$ReportMessage bcmsStruct$ReportMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(bcmsStruct$ReportMessage);
    }

    public static BcmsStruct$ReportMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BcmsStruct$ReportMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BcmsStruct$ReportMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BcmsStruct$ReportMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BcmsStruct$ReportMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (BcmsStruct$ReportMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BcmsStruct$ReportMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BcmsStruct$ReportMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BcmsStruct$ReportMessage parseFrom(byte[] bArr) {
        return (BcmsStruct$ReportMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BcmsStruct$ReportMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (BcmsStruct$ReportMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BcmsStruct$ReportMessage parseFrom(InputStream inputStream) {
        return (BcmsStruct$ReportMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BcmsStruct$ReportMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BcmsStruct$ReportMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BcmsStruct$ReportMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (BcmsStruct$ReportMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BcmsStruct$ReportMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BcmsStruct$ReportMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
