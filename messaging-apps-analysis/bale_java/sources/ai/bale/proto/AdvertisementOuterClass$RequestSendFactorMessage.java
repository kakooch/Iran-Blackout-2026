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

/* loaded from: classes8.dex */
public final class AdvertisementOuterClass$RequestSendFactorMessage extends GeneratedMessageLite implements U64 {
    public static final int CHANNEL_ID_FIELD_NUMBER = 1;
    private static final AdvertisementOuterClass$RequestSendFactorMessage DEFAULT_INSTANCE;
    public static final int FILE_ID_FIELD_NUMBER = 3;
    public static final int FILE_NAME_FIELD_NUMBER = 4;
    public static final int MESSAGE_TEXT_FIELD_NUMBER = 2;
    public static final int MONTH_FIELD_NUMBER = 6;
    private static volatile KW4 PARSER = null;
    public static final int YEAR_FIELD_NUMBER = 5;
    private int channelId_;
    private long fileId_;
    private int month_;
    private int year_;
    private String messageText_ = "";
    private String fileName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestSendFactorMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestSendFactorMessage advertisementOuterClass$RequestSendFactorMessage = new AdvertisementOuterClass$RequestSendFactorMessage();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestSendFactorMessage;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestSendFactorMessage.class, advertisementOuterClass$RequestSendFactorMessage);
    }

    private AdvertisementOuterClass$RequestSendFactorMessage() {
    }

    private void clearChannelId() {
        this.channelId_ = 0;
    }

    private void clearFileId() {
        this.fileId_ = 0L;
    }

    private void clearFileName() {
        this.fileName_ = getDefaultInstance().getFileName();
    }

    private void clearMessageText() {
        this.messageText_ = getDefaultInstance().getMessageText();
    }

    private void clearMonth() {
        this.month_ = 0;
    }

    private void clearYear() {
        this.year_ = 0;
    }

    public static AdvertisementOuterClass$RequestSendFactorMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestSendFactorMessage parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSendFactorMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSendFactorMessage parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestSendFactorMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setChannelId(int i) {
        this.channelId_ = i;
    }

    private void setFileId(long j) {
        this.fileId_ = j;
    }

    private void setFileName(String str) {
        str.getClass();
        this.fileName_ = str;
    }

    private void setFileNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.fileName_ = abstractC2383g.f0();
    }

    private void setMessageText(String str) {
        str.getClass();
        this.messageText_ = str;
    }

    private void setMessageTextBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.messageText_ = abstractC2383g.f0();
    }

    private void setMonth(int i) {
        this.month_ = i;
    }

    private void setYear(int i) {
        this.year_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestSendFactorMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003\u0002\u0004Ȉ\u0005\u0004\u0006\u0004", new Object[]{"channelId_", "messageText_", "fileId_", "fileName_", "year_", "month_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestSendFactorMessage.class) {
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

    public int getChannelId() {
        return this.channelId_;
    }

    public long getFileId() {
        return this.fileId_;
    }

    public String getFileName() {
        return this.fileName_;
    }

    public AbstractC2383g getFileNameBytes() {
        return AbstractC2383g.N(this.fileName_);
    }

    public String getMessageText() {
        return this.messageText_;
    }

    public AbstractC2383g getMessageTextBytes() {
        return AbstractC2383g.N(this.messageText_);
    }

    public int getMonth() {
        return this.month_;
    }

    public int getYear() {
        return this.year_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestSendFactorMessage advertisementOuterClass$RequestSendFactorMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestSendFactorMessage);
    }

    public static AdvertisementOuterClass$RequestSendFactorMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSendFactorMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSendFactorMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSendFactorMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestSendFactorMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestSendFactorMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestSendFactorMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSendFactorMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestSendFactorMessage parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestSendFactorMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestSendFactorMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSendFactorMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestSendFactorMessage parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSendFactorMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSendFactorMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSendFactorMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSendFactorMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestSendFactorMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestSendFactorMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSendFactorMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
