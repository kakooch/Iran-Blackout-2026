package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$MapValue;
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
public final class FanoosOuterClass$RequestSendFanoos extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 3;
    private static final FanoosOuterClass$RequestSendFanoos DEFAULT_INSTANCE;
    public static final int EVENT_NAME_FIELD_NUMBER = 1;
    public static final int ITEMS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private long date_;
    private String eventName_ = "";
    private CollectionsStruct$MapValue items_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((FanoosOuterClass$RequestSendFanoos) this.b).setDate(j);
            return this;
        }

        public a B(String str) {
            q();
            ((FanoosOuterClass$RequestSendFanoos) this.b).setEventName(str);
            return this;
        }

        public a C(CollectionsStruct$MapValue.a aVar) {
            q();
            ((FanoosOuterClass$RequestSendFanoos) this.b).setItems((CollectionsStruct$MapValue) aVar.a());
            return this;
        }

        private a() {
            super(FanoosOuterClass$RequestSendFanoos.DEFAULT_INSTANCE);
        }
    }

    static {
        FanoosOuterClass$RequestSendFanoos fanoosOuterClass$RequestSendFanoos = new FanoosOuterClass$RequestSendFanoos();
        DEFAULT_INSTANCE = fanoosOuterClass$RequestSendFanoos;
        GeneratedMessageLite.registerDefaultInstance(FanoosOuterClass$RequestSendFanoos.class, fanoosOuterClass$RequestSendFanoos);
    }

    private FanoosOuterClass$RequestSendFanoos() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearEventName() {
        this.eventName_ = getDefaultInstance().getEventName();
    }

    private void clearItems() {
        this.items_ = null;
        this.bitField0_ &= -2;
    }

    public static FanoosOuterClass$RequestSendFanoos getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeItems(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        CollectionsStruct$MapValue collectionsStruct$MapValue2 = this.items_;
        if (collectionsStruct$MapValue2 == null || collectionsStruct$MapValue2 == CollectionsStruct$MapValue.getDefaultInstance()) {
            this.items_ = collectionsStruct$MapValue;
        } else {
            this.items_ = (CollectionsStruct$MapValue) ((CollectionsStruct$MapValue.a) CollectionsStruct$MapValue.newBuilder(this.items_).v(collectionsStruct$MapValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static FanoosOuterClass$RequestSendFanoos parseDelimitedFrom(InputStream inputStream) {
        return (FanoosOuterClass$RequestSendFanoos) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FanoosOuterClass$RequestSendFanoos parseFrom(ByteBuffer byteBuffer) {
        return (FanoosOuterClass$RequestSendFanoos) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(long j) {
        this.date_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventName(String str) {
        str.getClass();
        this.eventName_ = str;
    }

    private void setEventNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.eventName_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItems(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        this.items_ = collectionsStruct$MapValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Z.a[gVar.ordinal()]) {
            case 1:
                return new FanoosOuterClass$RequestSendFanoos();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003\u0002", new Object[]{"bitField0_", "eventName_", "items_", "date_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (FanoosOuterClass$RequestSendFanoos.class) {
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

    public long getDate() {
        return this.date_;
    }

    public String getEventName() {
        return this.eventName_;
    }

    public AbstractC2383g getEventNameBytes() {
        return AbstractC2383g.N(this.eventName_);
    }

    public CollectionsStruct$MapValue getItems() {
        CollectionsStruct$MapValue collectionsStruct$MapValue = this.items_;
        return collectionsStruct$MapValue == null ? CollectionsStruct$MapValue.getDefaultInstance() : collectionsStruct$MapValue;
    }

    public boolean hasItems() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(FanoosOuterClass$RequestSendFanoos fanoosOuterClass$RequestSendFanoos) {
        return (a) DEFAULT_INSTANCE.createBuilder(fanoosOuterClass$RequestSendFanoos);
    }

    public static FanoosOuterClass$RequestSendFanoos parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (FanoosOuterClass$RequestSendFanoos) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FanoosOuterClass$RequestSendFanoos parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (FanoosOuterClass$RequestSendFanoos) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static FanoosOuterClass$RequestSendFanoos parseFrom(AbstractC2383g abstractC2383g) {
        return (FanoosOuterClass$RequestSendFanoos) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static FanoosOuterClass$RequestSendFanoos parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (FanoosOuterClass$RequestSendFanoos) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static FanoosOuterClass$RequestSendFanoos parseFrom(byte[] bArr) {
        return (FanoosOuterClass$RequestSendFanoos) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FanoosOuterClass$RequestSendFanoos parseFrom(byte[] bArr, C2394s c2394s) {
        return (FanoosOuterClass$RequestSendFanoos) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static FanoosOuterClass$RequestSendFanoos parseFrom(InputStream inputStream) {
        return (FanoosOuterClass$RequestSendFanoos) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FanoosOuterClass$RequestSendFanoos parseFrom(InputStream inputStream, C2394s c2394s) {
        return (FanoosOuterClass$RequestSendFanoos) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static FanoosOuterClass$RequestSendFanoos parseFrom(AbstractC2384h abstractC2384h) {
        return (FanoosOuterClass$RequestSendFanoos) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static FanoosOuterClass$RequestSendFanoos parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (FanoosOuterClass$RequestSendFanoos) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
