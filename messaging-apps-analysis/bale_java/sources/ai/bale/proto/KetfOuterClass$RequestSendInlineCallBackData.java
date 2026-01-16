package ai.bale.proto;

import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KetfOuterClass$RequestSendInlineCallBackData extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 2;
    private static final KetfOuterClass$RequestSendInlineCallBackData DEFAULT_INSTANCE;
    public static final int HISTORY_MESSAGE_IDENTIFIER_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private StringValue data_;
    private MessagingStruct$HistoryMessageIdentifier historyMessageIdentifier_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KetfOuterClass$RequestSendInlineCallBackData.DEFAULT_INSTANCE);
        }
    }

    static {
        KetfOuterClass$RequestSendInlineCallBackData ketfOuterClass$RequestSendInlineCallBackData = new KetfOuterClass$RequestSendInlineCallBackData();
        DEFAULT_INSTANCE = ketfOuterClass$RequestSendInlineCallBackData;
        GeneratedMessageLite.registerDefaultInstance(KetfOuterClass$RequestSendInlineCallBackData.class, ketfOuterClass$RequestSendInlineCallBackData);
    }

    private KetfOuterClass$RequestSendInlineCallBackData() {
    }

    private void clearData() {
        this.data_ = null;
        this.bitField0_ &= -3;
    }

    private void clearHistoryMessageIdentifier() {
        this.historyMessageIdentifier_ = null;
        this.bitField0_ &= -2;
    }

    public static KetfOuterClass$RequestSendInlineCallBackData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeData(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.data_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.data_ = stringValue;
        } else {
            this.data_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.data_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeHistoryMessageIdentifier(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier2 = this.historyMessageIdentifier_;
        if (messagingStruct$HistoryMessageIdentifier2 == null || messagingStruct$HistoryMessageIdentifier2 == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.historyMessageIdentifier_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.historyMessageIdentifier_ = (MessagingStruct$HistoryMessageIdentifier) ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder(this.historyMessageIdentifier_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KetfOuterClass$RequestSendInlineCallBackData parseDelimitedFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestSendInlineCallBackData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestSendInlineCallBackData parseFrom(ByteBuffer byteBuffer) {
        return (KetfOuterClass$RequestSendInlineCallBackData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(StringValue stringValue) {
        stringValue.getClass();
        this.data_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setHistoryMessageIdentifier(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.historyMessageIdentifier_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1888r0.a[gVar.ordinal()]) {
            case 1:
                return new KetfOuterClass$RequestSendInlineCallBackData();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "historyMessageIdentifier_", "data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KetfOuterClass$RequestSendInlineCallBackData.class) {
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

    public StringValue getData() {
        StringValue stringValue = this.data_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public MessagingStruct$HistoryMessageIdentifier getHistoryMessageIdentifier() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.historyMessageIdentifier_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public boolean hasData() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasHistoryMessageIdentifier() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KetfOuterClass$RequestSendInlineCallBackData ketfOuterClass$RequestSendInlineCallBackData) {
        return (a) DEFAULT_INSTANCE.createBuilder(ketfOuterClass$RequestSendInlineCallBackData);
    }

    public static KetfOuterClass$RequestSendInlineCallBackData parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestSendInlineCallBackData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestSendInlineCallBackData parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KetfOuterClass$RequestSendInlineCallBackData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KetfOuterClass$RequestSendInlineCallBackData parseFrom(AbstractC2383g abstractC2383g) {
        return (KetfOuterClass$RequestSendInlineCallBackData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KetfOuterClass$RequestSendInlineCallBackData parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KetfOuterClass$RequestSendInlineCallBackData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KetfOuterClass$RequestSendInlineCallBackData parseFrom(byte[] bArr) {
        return (KetfOuterClass$RequestSendInlineCallBackData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KetfOuterClass$RequestSendInlineCallBackData parseFrom(byte[] bArr, C2394s c2394s) {
        return (KetfOuterClass$RequestSendInlineCallBackData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KetfOuterClass$RequestSendInlineCallBackData parseFrom(InputStream inputStream) {
        return (KetfOuterClass$RequestSendInlineCallBackData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KetfOuterClass$RequestSendInlineCallBackData parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KetfOuterClass$RequestSendInlineCallBackData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KetfOuterClass$RequestSendInlineCallBackData parseFrom(AbstractC2384h abstractC2384h) {
        return (KetfOuterClass$RequestSendInlineCallBackData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KetfOuterClass$RequestSendInlineCallBackData parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KetfOuterClass$RequestSendInlineCallBackData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
