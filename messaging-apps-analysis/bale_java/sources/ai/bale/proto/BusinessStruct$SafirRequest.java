package ai.bale.proto;

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

/* loaded from: classes9.dex */
public final class BusinessStruct$SafirRequest extends GeneratedMessageLite implements U64 {
    public static final int BOT_ID_FIELD_NUMBER = 1;
    public static final int BOT_TOKEN_FIELD_NUMBER = 4;
    private static final BusinessStruct$SafirRequest DEFAULT_INSTANCE;
    public static final int OFFICIAL_LETTER_FILE_LOCATION_FIELD_NUMBER = 3;
    public static final int OWNER_NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 5;
    public static final int REQ_TAG_FIELD_NUMBER = 6;
    private int bitField0_;
    private int botId_;
    private FilesStruct$FileLocation officialLetterFileLocation_;
    private String ownerName_ = "";
    private String botToken_ = "";
    private String reason_ = "";
    private String reqTag_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessStruct$SafirRequest.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessStruct$SafirRequest businessStruct$SafirRequest = new BusinessStruct$SafirRequest();
        DEFAULT_INSTANCE = businessStruct$SafirRequest;
        GeneratedMessageLite.registerDefaultInstance(BusinessStruct$SafirRequest.class, businessStruct$SafirRequest);
    }

    private BusinessStruct$SafirRequest() {
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearBotToken() {
        this.botToken_ = getDefaultInstance().getBotToken();
    }

    private void clearOfficialLetterFileLocation() {
        this.officialLetterFileLocation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOwnerName() {
        this.ownerName_ = getDefaultInstance().getOwnerName();
    }

    private void clearReason() {
        this.reason_ = getDefaultInstance().getReason();
    }

    private void clearReqTag() {
        this.reqTag_ = getDefaultInstance().getReqTag();
    }

    public static BusinessStruct$SafirRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOfficialLetterFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.officialLetterFileLocation_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.officialLetterFileLocation_ = filesStruct$FileLocation;
        } else {
            this.officialLetterFileLocation_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.officialLetterFileLocation_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessStruct$SafirRequest parseDelimitedFrom(InputStream inputStream) {
        return (BusinessStruct$SafirRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$SafirRequest parseFrom(ByteBuffer byteBuffer) {
        return (BusinessStruct$SafirRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    private void setBotToken(String str) {
        str.getClass();
        this.botToken_ = str;
    }

    private void setBotTokenBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.botToken_ = abstractC2383g.f0();
    }

    private void setOfficialLetterFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.officialLetterFileLocation_ = filesStruct$FileLocation;
        this.bitField0_ |= 1;
    }

    private void setOwnerName(String str) {
        str.getClass();
        this.ownerName_ = str;
    }

    private void setOwnerNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.ownerName_ = abstractC2383g.f0();
    }

    private void setReason(String str) {
        str.getClass();
        this.reason_ = str;
    }

    private void setReasonBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reason_ = abstractC2383g.f0();
    }

    private void setReqTag(String str) {
        str.getClass();
        this.reqTag_ = str;
    }

    private void setReqTagBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.reqTag_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1899v.a[gVar.ordinal()]) {
            case 1:
                return new BusinessStruct$SafirRequest();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003ဉ\u0000\u0004Ȉ\u0005Ȉ\u0006Ȉ", new Object[]{"bitField0_", "botId_", "ownerName_", "officialLetterFileLocation_", "botToken_", "reason_", "reqTag_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessStruct$SafirRequest.class) {
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

    public int getBotId() {
        return this.botId_;
    }

    public String getBotToken() {
        return this.botToken_;
    }

    public AbstractC2383g getBotTokenBytes() {
        return AbstractC2383g.N(this.botToken_);
    }

    public FilesStruct$FileLocation getOfficialLetterFileLocation() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.officialLetterFileLocation_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public String getOwnerName() {
        return this.ownerName_;
    }

    public AbstractC2383g getOwnerNameBytes() {
        return AbstractC2383g.N(this.ownerName_);
    }

    public String getReason() {
        return this.reason_;
    }

    public AbstractC2383g getReasonBytes() {
        return AbstractC2383g.N(this.reason_);
    }

    public String getReqTag() {
        return this.reqTag_;
    }

    public AbstractC2383g getReqTagBytes() {
        return AbstractC2383g.N(this.reqTag_);
    }

    public boolean hasOfficialLetterFileLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BusinessStruct$SafirRequest businessStruct$SafirRequest) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessStruct$SafirRequest);
    }

    public static BusinessStruct$SafirRequest parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$SafirRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$SafirRequest parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessStruct$SafirRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessStruct$SafirRequest parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessStruct$SafirRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BusinessStruct$SafirRequest parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessStruct$SafirRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessStruct$SafirRequest parseFrom(byte[] bArr) {
        return (BusinessStruct$SafirRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessStruct$SafirRequest parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessStruct$SafirRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessStruct$SafirRequest parseFrom(InputStream inputStream) {
        return (BusinessStruct$SafirRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$SafirRequest parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$SafirRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$SafirRequest parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessStruct$SafirRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessStruct$SafirRequest parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessStruct$SafirRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
