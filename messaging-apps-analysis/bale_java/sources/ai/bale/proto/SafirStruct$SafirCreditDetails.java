package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.S96;
import ir.nasim.Y96;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SafirStruct$SafirCreditDetails extends GeneratedMessageLite implements Y96 {
    public static final int COUNT_FIELD_NUMBER = 1;
    private static final SafirStruct$SafirCreditDetails DEFAULT_INSTANCE;
    public static final int MESSAGE_TYPE_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int PRICE_FIELD_NUMBER = 2;
    private int count_;
    private int messageType_;
    private long price_;

    public static final class a extends GeneratedMessageLite.b implements Y96 {
        private a() {
            super(SafirStruct$SafirCreditDetails.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirStruct$SafirCreditDetails safirStruct$SafirCreditDetails = new SafirStruct$SafirCreditDetails();
        DEFAULT_INSTANCE = safirStruct$SafirCreditDetails;
        GeneratedMessageLite.registerDefaultInstance(SafirStruct$SafirCreditDetails.class, safirStruct$SafirCreditDetails);
    }

    private SafirStruct$SafirCreditDetails() {
    }

    private void clearCount() {
        this.count_ = 0;
    }

    private void clearMessageType() {
        this.messageType_ = 0;
    }

    private void clearPrice() {
        this.price_ = 0L;
    }

    public static SafirStruct$SafirCreditDetails getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirStruct$SafirCreditDetails parseDelimitedFrom(InputStream inputStream) {
        return (SafirStruct$SafirCreditDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$SafirCreditDetails parseFrom(ByteBuffer byteBuffer) {
        return (SafirStruct$SafirCreditDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCount(int i) {
        this.count_ = i;
    }

    private void setMessageType(S96 s96) {
        this.messageType_ = s96.getNumber();
    }

    private void setMessageTypeValue(int i) {
        this.messageType_ = i;
    }

    private void setPrice(long j) {
        this.price_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (G1.a[gVar.ordinal()]) {
            case 1:
                return new SafirStruct$SafirCreditDetails();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\f", new Object[]{"count_", "price_", "messageType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirStruct$SafirCreditDetails.class) {
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

    public int getCount() {
        return this.count_;
    }

    public S96 getMessageType() {
        S96 s96J = S96.j(this.messageType_);
        return s96J == null ? S96.UNRECOGNIZED : s96J;
    }

    public int getMessageTypeValue() {
        return this.messageType_;
    }

    public long getPrice() {
        return this.price_;
    }

    public static a newBuilder(SafirStruct$SafirCreditDetails safirStruct$SafirCreditDetails) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirStruct$SafirCreditDetails);
    }

    public static SafirStruct$SafirCreditDetails parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$SafirCreditDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$SafirCreditDetails parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirStruct$SafirCreditDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirStruct$SafirCreditDetails parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirStruct$SafirCreditDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirStruct$SafirCreditDetails parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirStruct$SafirCreditDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirStruct$SafirCreditDetails parseFrom(byte[] bArr) {
        return (SafirStruct$SafirCreditDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirStruct$SafirCreditDetails parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirStruct$SafirCreditDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirStruct$SafirCreditDetails parseFrom(InputStream inputStream) {
        return (SafirStruct$SafirCreditDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirStruct$SafirCreditDetails parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirStruct$SafirCreditDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirStruct$SafirCreditDetails parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirStruct$SafirCreditDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirStruct$SafirCreditDetails parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirStruct$SafirCreditDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
