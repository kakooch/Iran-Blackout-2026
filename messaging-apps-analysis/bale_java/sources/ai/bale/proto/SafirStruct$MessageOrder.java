package ai.bale.proto;

import ai.bale.proto.FilesStruct$FileLocation;
import ai.bale.proto.MessagingStruct$Message;
import ai.bale.proto.SafirStruct$MessageOrderReport;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.P96;
import ir.nasim.R96;
import ir.nasim.S96;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SafirStruct$MessageOrder extends GeneratedMessageLite implements P96 {
    public static final int AMOUNT_FIELD_NUMBER = 9;
    public static final int BOT_ID_FIELD_NUMBER = 8;
    public static final int CREATED_AT_FIELD_NUMBER = 2;
    private static final SafirStruct$MessageOrder DEFAULT_INSTANCE;
    public static final int FAILED_PHONE_NUMBERS_FILE_LOC_FIELD_NUMBER = 11;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int MESSAGE_FIELD_NUMBER = 6;
    public static final int MESSAGE_TYPE_FIELD_NUMBER = 5;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_NUMBERS_FILE_LOCATION_FIELD_NUMBER = 7;
    public static final int REPORT_FIELD_NUMBER = 10;
    public static final int STATUS_FIELD_NUMBER = 3;
    public static final int TARIFF_FIELD_NUMBER = 4;
    private long amount_;
    private int bitField0_;
    private int botId_;
    private long createdAt_;
    private FilesStruct$FileLocation failedPhoneNumbersFileLoc_;
    private String id_ = "";
    private int messageType_;
    private MessagingStruct$Message message_;
    private FilesStruct$FileLocation phoneNumbersFileLocation_;
    private SafirStruct$MessageOrderReport report_;
    private int status_;
    private int tariff_;

    public static final class a extends GeneratedMessageLite.b implements P96 {
        private a() {
            super(SafirStruct$MessageOrder.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirStruct$MessageOrder safirStruct$MessageOrder = new SafirStruct$MessageOrder();
        DEFAULT_INSTANCE = safirStruct$MessageOrder;
        GeneratedMessageLite.registerDefaultInstance(SafirStruct$MessageOrder.class, safirStruct$MessageOrder);
    }

    private SafirStruct$MessageOrder() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearFailedPhoneNumbersFileLoc() {
        this.failedPhoneNumbersFileLoc_ = null;
        this.bitField0_ &= -9;
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearMessage() {
        this.message_ = null;
        this.bitField0_ &= -2;
    }

    private void clearMessageType() {
        this.messageType_ = 0;
    }

    private void clearPhoneNumbersFileLocation() {
        this.phoneNumbersFileLocation_ = null;
        this.bitField0_ &= -3;
    }

    private void clearReport() {
        this.report_ = null;
        this.bitField0_ &= -5;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearTariff() {
        this.tariff_ = 0;
    }

    public static SafirStruct$MessageOrder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFailedPhoneNumbersFileLoc(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.failedPhoneNumbersFileLoc_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.failedPhoneNumbersFileLoc_ = filesStruct$FileLocation;
        } else {
            this.failedPhoneNumbersFileLoc_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.failedPhoneNumbersFileLoc_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 8;
    }

    private void mergeMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        MessagingStruct$Message messagingStruct$Message2 = this.message_;
        if (messagingStruct$Message2 == null || messagingStruct$Message2 == MessagingStruct$Message.getDefaultInstance()) {
            this.message_ = messagingStruct$Message;
        } else {
            this.message_ = (MessagingStruct$Message) ((MessagingStruct$Message.a) MessagingStruct$Message.newBuilder(this.message_).v(messagingStruct$Message)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergePhoneNumbersFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        FilesStruct$FileLocation filesStruct$FileLocation2 = this.phoneNumbersFileLocation_;
        if (filesStruct$FileLocation2 == null || filesStruct$FileLocation2 == FilesStruct$FileLocation.getDefaultInstance()) {
            this.phoneNumbersFileLocation_ = filesStruct$FileLocation;
        } else {
            this.phoneNumbersFileLocation_ = (FilesStruct$FileLocation) ((FilesStruct$FileLocation.a) FilesStruct$FileLocation.newBuilder(this.phoneNumbersFileLocation_).v(filesStruct$FileLocation)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeReport(SafirStruct$MessageOrderReport safirStruct$MessageOrderReport) {
        safirStruct$MessageOrderReport.getClass();
        SafirStruct$MessageOrderReport safirStruct$MessageOrderReport2 = this.report_;
        if (safirStruct$MessageOrderReport2 == null || safirStruct$MessageOrderReport2 == SafirStruct$MessageOrderReport.getDefaultInstance()) {
            this.report_ = safirStruct$MessageOrderReport;
        } else {
            this.report_ = (SafirStruct$MessageOrderReport) ((SafirStruct$MessageOrderReport.a) SafirStruct$MessageOrderReport.newBuilder(this.report_).v(safirStruct$MessageOrderReport)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirStruct$MessageOrder parseDelimitedFrom(InputStream inputStream) {
        return (SafirStruct$MessageOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$MessageOrder parseFrom(ByteBuffer byteBuffer) {
        return (SafirStruct$MessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setFailedPhoneNumbersFileLoc(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.failedPhoneNumbersFileLoc_ = filesStruct$FileLocation;
        this.bitField0_ |= 8;
    }

    private void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    private void setMessage(MessagingStruct$Message messagingStruct$Message) {
        messagingStruct$Message.getClass();
        this.message_ = messagingStruct$Message;
        this.bitField0_ |= 1;
    }

    private void setMessageType(S96 s96) {
        this.messageType_ = s96.getNumber();
    }

    private void setMessageTypeValue(int i) {
        this.messageType_ = i;
    }

    private void setPhoneNumbersFileLocation(FilesStruct$FileLocation filesStruct$FileLocation) {
        filesStruct$FileLocation.getClass();
        this.phoneNumbersFileLocation_ = filesStruct$FileLocation;
        this.bitField0_ |= 2;
    }

    private void setReport(SafirStruct$MessageOrderReport safirStruct$MessageOrderReport) {
        safirStruct$MessageOrderReport.getClass();
        this.report_ = safirStruct$MessageOrderReport;
        this.bitField0_ |= 4;
    }

    private void setStatus(R96 r96) {
        this.status_ = r96.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    private void setTariff(int i) {
        this.tariff_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G1.a[gVar.ordinal()]) {
            case 1:
                return new SafirStruct$MessageOrder();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003\f\u0004\u0004\u0005\f\u0006ဉ\u0000\u0007ဉ\u0001\b\u0004\t\u0002\nဉ\u0002\u000bဉ\u0003", new Object[]{"bitField0_", "id_", "createdAt_", "status_", "tariff_", "messageType_", "message_", "phoneNumbersFileLocation_", "botId_", "amount_", "report_", "failedPhoneNumbersFileLoc_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirStruct$MessageOrder.class) {
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

    public long getAmount() {
        return this.amount_;
    }

    public int getBotId() {
        return this.botId_;
    }

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public FilesStruct$FileLocation getFailedPhoneNumbersFileLoc() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.failedPhoneNumbersFileLoc_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public MessagingStruct$Message getMessage() {
        MessagingStruct$Message messagingStruct$Message = this.message_;
        return messagingStruct$Message == null ? MessagingStruct$Message.getDefaultInstance() : messagingStruct$Message;
    }

    public S96 getMessageType() {
        S96 s96J = S96.j(this.messageType_);
        return s96J == null ? S96.UNRECOGNIZED : s96J;
    }

    public int getMessageTypeValue() {
        return this.messageType_;
    }

    public FilesStruct$FileLocation getPhoneNumbersFileLocation() {
        FilesStruct$FileLocation filesStruct$FileLocation = this.phoneNumbersFileLocation_;
        return filesStruct$FileLocation == null ? FilesStruct$FileLocation.getDefaultInstance() : filesStruct$FileLocation;
    }

    public SafirStruct$MessageOrderReport getReport() {
        SafirStruct$MessageOrderReport safirStruct$MessageOrderReport = this.report_;
        return safirStruct$MessageOrderReport == null ? SafirStruct$MessageOrderReport.getDefaultInstance() : safirStruct$MessageOrderReport;
    }

    public R96 getStatus() {
        R96 r96J = R96.j(this.status_);
        return r96J == null ? R96.UNRECOGNIZED : r96J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public int getTariff() {
        return this.tariff_;
    }

    public boolean hasFailedPhoneNumbersFileLoc() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPhoneNumbersFileLocation() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasReport() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(SafirStruct$MessageOrder safirStruct$MessageOrder) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirStruct$MessageOrder);
    }

    public static SafirStruct$MessageOrder parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$MessageOrder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$MessageOrder parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirStruct$MessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirStruct$MessageOrder parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirStruct$MessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirStruct$MessageOrder parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirStruct$MessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirStruct$MessageOrder parseFrom(byte[] bArr) {
        return (SafirStruct$MessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirStruct$MessageOrder parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirStruct$MessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirStruct$MessageOrder parseFrom(InputStream inputStream) {
        return (SafirStruct$MessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$MessageOrder parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$MessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$MessageOrder parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirStruct$MessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirStruct$MessageOrder parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirStruct$MessageOrder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
