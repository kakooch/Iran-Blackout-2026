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
public final class AdvertisementOuterClass$RequestSendAdminMessage extends GeneratedMessageLite implements U64 {
    private static final AdvertisementOuterClass$RequestSendAdminMessage DEFAULT_INSTANCE;
    public static final int FILE_ID_FIELD_NUMBER = 3;
    public static final int FILE_NAME_FIELD_NUMBER = 4;
    public static final int MESSAGE_TEXT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RECEIVER_FIELD_NUMBER = 1;
    private long fileId_;
    private int receiver_;
    private String messageText_ = "";
    private String fileName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AdvertisementOuterClass$RequestSendAdminMessage.DEFAULT_INSTANCE);
        }
    }

    static {
        AdvertisementOuterClass$RequestSendAdminMessage advertisementOuterClass$RequestSendAdminMessage = new AdvertisementOuterClass$RequestSendAdminMessage();
        DEFAULT_INSTANCE = advertisementOuterClass$RequestSendAdminMessage;
        GeneratedMessageLite.registerDefaultInstance(AdvertisementOuterClass$RequestSendAdminMessage.class, advertisementOuterClass$RequestSendAdminMessage);
    }

    private AdvertisementOuterClass$RequestSendAdminMessage() {
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

    private void clearReceiver() {
        this.receiver_ = 0;
    }

    public static AdvertisementOuterClass$RequestSendAdminMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AdvertisementOuterClass$RequestSendAdminMessage parseDelimitedFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSendAdminMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSendAdminMessage parseFrom(ByteBuffer byteBuffer) {
        return (AdvertisementOuterClass$RequestSendAdminMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    private void setReceiver(int i) {
        this.receiver_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1840b.a[gVar.ordinal()]) {
            case 1:
                return new AdvertisementOuterClass$RequestSendAdminMessage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003\u0002\u0004Ȉ", new Object[]{"receiver_", "messageText_", "fileId_", "fileName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AdvertisementOuterClass$RequestSendAdminMessage.class) {
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

    public int getReceiver() {
        return this.receiver_;
    }

    public static a newBuilder(AdvertisementOuterClass$RequestSendAdminMessage advertisementOuterClass$RequestSendAdminMessage) {
        return (a) DEFAULT_INSTANCE.createBuilder(advertisementOuterClass$RequestSendAdminMessage);
    }

    public static AdvertisementOuterClass$RequestSendAdminMessage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSendAdminMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSendAdminMessage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSendAdminMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AdvertisementOuterClass$RequestSendAdminMessage parseFrom(AbstractC2383g abstractC2383g) {
        return (AdvertisementOuterClass$RequestSendAdminMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AdvertisementOuterClass$RequestSendAdminMessage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSendAdminMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AdvertisementOuterClass$RequestSendAdminMessage parseFrom(byte[] bArr) {
        return (AdvertisementOuterClass$RequestSendAdminMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AdvertisementOuterClass$RequestSendAdminMessage parseFrom(byte[] bArr, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSendAdminMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AdvertisementOuterClass$RequestSendAdminMessage parseFrom(InputStream inputStream) {
        return (AdvertisementOuterClass$RequestSendAdminMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AdvertisementOuterClass$RequestSendAdminMessage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSendAdminMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AdvertisementOuterClass$RequestSendAdminMessage parseFrom(AbstractC2384h abstractC2384h) {
        return (AdvertisementOuterClass$RequestSendAdminMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AdvertisementOuterClass$RequestSendAdminMessage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AdvertisementOuterClass$RequestSendAdminMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
