package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KI2;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GiftpacketStruct$GiftReceiver extends GeneratedMessageLite implements KI2 {
    public static final int AMOUNT_FIELD_NUMBER = 2;
    public static final int DATE_FIELD_NUMBER = 3;
    private static final GiftpacketStruct$GiftReceiver DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private long amount_;
    private long date_;
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements KI2 {
        private a() {
            super(GiftpacketStruct$GiftReceiver.DEFAULT_INSTANCE);
        }
    }

    static {
        GiftpacketStruct$GiftReceiver giftpacketStruct$GiftReceiver = new GiftpacketStruct$GiftReceiver();
        DEFAULT_INSTANCE = giftpacketStruct$GiftReceiver;
        GeneratedMessageLite.registerDefaultInstance(GiftpacketStruct$GiftReceiver.class, giftpacketStruct$GiftReceiver);
    }

    private GiftpacketStruct$GiftReceiver() {
    }

    private void clearAmount() {
        this.amount_ = 0L;
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static GiftpacketStruct$GiftReceiver getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GiftpacketStruct$GiftReceiver parseDelimitedFrom(InputStream inputStream) {
        return (GiftpacketStruct$GiftReceiver) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GiftpacketStruct$GiftReceiver parseFrom(ByteBuffer byteBuffer) {
        return (GiftpacketStruct$GiftReceiver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAmount(long j) {
        this.amount_ = j;
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1868k0.a[gVar.ordinal()]) {
            case 1:
                return new GiftpacketStruct$GiftReceiver();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002", new Object[]{"userId_", "amount_", "date_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GiftpacketStruct$GiftReceiver.class) {
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

    public long getDate() {
        return this.date_;
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(GiftpacketStruct$GiftReceiver giftpacketStruct$GiftReceiver) {
        return (a) DEFAULT_INSTANCE.createBuilder(giftpacketStruct$GiftReceiver);
    }

    public static GiftpacketStruct$GiftReceiver parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GiftpacketStruct$GiftReceiver) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GiftpacketStruct$GiftReceiver parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GiftpacketStruct$GiftReceiver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GiftpacketStruct$GiftReceiver parseFrom(AbstractC2383g abstractC2383g) {
        return (GiftpacketStruct$GiftReceiver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GiftpacketStruct$GiftReceiver parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GiftpacketStruct$GiftReceiver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GiftpacketStruct$GiftReceiver parseFrom(byte[] bArr) {
        return (GiftpacketStruct$GiftReceiver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GiftpacketStruct$GiftReceiver parseFrom(byte[] bArr, C2394s c2394s) {
        return (GiftpacketStruct$GiftReceiver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GiftpacketStruct$GiftReceiver parseFrom(InputStream inputStream) {
        return (GiftpacketStruct$GiftReceiver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GiftpacketStruct$GiftReceiver parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GiftpacketStruct$GiftReceiver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GiftpacketStruct$GiftReceiver parseFrom(AbstractC2384h abstractC2384h) {
        return (GiftpacketStruct$GiftReceiver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GiftpacketStruct$GiftReceiver parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GiftpacketStruct$GiftReceiver) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
