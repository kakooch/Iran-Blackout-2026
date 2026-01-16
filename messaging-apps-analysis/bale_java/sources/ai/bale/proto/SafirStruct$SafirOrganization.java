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

/* loaded from: classes.dex */
public final class SafirStruct$SafirOrganization extends GeneratedMessageLite implements U64 {
    public static final int API_ACCESS_KEY_FIELD_NUMBER = 4;
    public static final int CREATED_AT_FIELD_NUMBER = 2;
    private static final SafirStruct$SafirOrganization DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int OFFICIAL_LETTER_FILE_LOCATION_FIELD_NUMBER = 6;
    public static final int OWNER_NAME_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PRICE_FIELD_NUMBER = 5;
    private int bitField0_;
    private long createdAt_;
    private int id_;
    private FilesStruct$FileLocation officialLetterFileLocation_;
    private long price_;
    private String ownerName_ = "";
    private String apiAccessKey_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirStruct$SafirOrganization.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirStruct$SafirOrganization safirStruct$SafirOrganization = new SafirStruct$SafirOrganization();
        DEFAULT_INSTANCE = safirStruct$SafirOrganization;
        GeneratedMessageLite.registerDefaultInstance(SafirStruct$SafirOrganization.class, safirStruct$SafirOrganization);
    }

    private SafirStruct$SafirOrganization() {
    }

    private void clearApiAccessKey() {
        this.apiAccessKey_ = getDefaultInstance().getApiAccessKey();
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearId() {
        this.id_ = 0;
    }

    private void clearOfficialLetterFileLocation() {
        this.officialLetterFileLocation_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOwnerName() {
        this.ownerName_ = getDefaultInstance().getOwnerName();
    }

    private void clearPrice() {
        this.price_ = 0L;
    }

    public static SafirStruct$SafirOrganization getDefaultInstance() {
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

    public static SafirStruct$SafirOrganization parseDelimitedFrom(InputStream inputStream) {
        return (SafirStruct$SafirOrganization) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$SafirOrganization parseFrom(ByteBuffer byteBuffer) {
        return (SafirStruct$SafirOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setApiAccessKey(String str) {
        str.getClass();
        this.apiAccessKey_ = str;
    }

    private void setApiAccessKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.apiAccessKey_ = abstractC2383g.f0();
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setId(int i) {
        this.id_ = i;
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

    private void setPrice(long j) {
        this.price_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G1.a[gVar.ordinal()]) {
            case 1:
                return new SafirStruct$SafirOrganization();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005\u0002\u0006ဉ\u0000", new Object[]{"bitField0_", "id_", "createdAt_", "ownerName_", "apiAccessKey_", "price_", "officialLetterFileLocation_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirStruct$SafirOrganization.class) {
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

    public String getApiAccessKey() {
        return this.apiAccessKey_;
    }

    public AbstractC2383g getApiAccessKeyBytes() {
        return AbstractC2383g.N(this.apiAccessKey_);
    }

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public int getId() {
        return this.id_;
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

    public long getPrice() {
        return this.price_;
    }

    public boolean hasOfficialLetterFileLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SafirStruct$SafirOrganization safirStruct$SafirOrganization) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirStruct$SafirOrganization);
    }

    public static SafirStruct$SafirOrganization parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$SafirOrganization) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$SafirOrganization parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirStruct$SafirOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirStruct$SafirOrganization parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirStruct$SafirOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirStruct$SafirOrganization parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirStruct$SafirOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirStruct$SafirOrganization parseFrom(byte[] bArr) {
        return (SafirStruct$SafirOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirStruct$SafirOrganization parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirStruct$SafirOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirStruct$SafirOrganization parseFrom(InputStream inputStream) {
        return (SafirStruct$SafirOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$SafirOrganization parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$SafirOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$SafirOrganization parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirStruct$SafirOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirStruct$SafirOrganization parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirStruct$SafirOrganization) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
