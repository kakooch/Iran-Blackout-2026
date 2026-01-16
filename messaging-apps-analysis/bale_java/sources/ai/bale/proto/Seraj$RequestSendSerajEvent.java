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

/* loaded from: classes.dex */
public final class Seraj$RequestSendSerajEvent extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 3;
    private static final Seraj$RequestSendSerajEvent DEFAULT_INSTANCE;
    public static final int EVENT_NAME_FIELD_NUMBER = 1;
    public static final int ITEMS_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private long date_;
    private String eventName_ = "";
    private CollectionsStruct$MapValue items_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Seraj$RequestSendSerajEvent.DEFAULT_INSTANCE);
        }
    }

    static {
        Seraj$RequestSendSerajEvent seraj$RequestSendSerajEvent = new Seraj$RequestSendSerajEvent();
        DEFAULT_INSTANCE = seraj$RequestSendSerajEvent;
        GeneratedMessageLite.registerDefaultInstance(Seraj$RequestSendSerajEvent.class, seraj$RequestSendSerajEvent);
    }

    private Seraj$RequestSendSerajEvent() {
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

    public static Seraj$RequestSendSerajEvent getDefaultInstance() {
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

    public static Seraj$RequestSendSerajEvent parseDelimitedFrom(InputStream inputStream) {
        return (Seraj$RequestSendSerajEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Seraj$RequestSendSerajEvent parseFrom(ByteBuffer byteBuffer) {
        return (Seraj$RequestSendSerajEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setEventName(String str) {
        str.getClass();
        this.eventName_ = str;
    }

    private void setEventNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.eventName_ = abstractC2383g.f0();
    }

    private void setItems(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        this.items_ = collectionsStruct$MapValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (U1.a[gVar.ordinal()]) {
            case 1:
                return new Seraj$RequestSendSerajEvent();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003\u0002", new Object[]{"bitField0_", "eventName_", "items_", "date_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Seraj$RequestSendSerajEvent.class) {
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

    public static a newBuilder(Seraj$RequestSendSerajEvent seraj$RequestSendSerajEvent) {
        return (a) DEFAULT_INSTANCE.createBuilder(seraj$RequestSendSerajEvent);
    }

    public static Seraj$RequestSendSerajEvent parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Seraj$RequestSendSerajEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Seraj$RequestSendSerajEvent parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Seraj$RequestSendSerajEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Seraj$RequestSendSerajEvent parseFrom(AbstractC2383g abstractC2383g) {
        return (Seraj$RequestSendSerajEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Seraj$RequestSendSerajEvent parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Seraj$RequestSendSerajEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Seraj$RequestSendSerajEvent parseFrom(byte[] bArr) {
        return (Seraj$RequestSendSerajEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Seraj$RequestSendSerajEvent parseFrom(byte[] bArr, C2394s c2394s) {
        return (Seraj$RequestSendSerajEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Seraj$RequestSendSerajEvent parseFrom(InputStream inputStream) {
        return (Seraj$RequestSendSerajEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Seraj$RequestSendSerajEvent parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Seraj$RequestSendSerajEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Seraj$RequestSendSerajEvent parseFrom(AbstractC2384h abstractC2384h) {
        return (Seraj$RequestSendSerajEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Seraj$RequestSendSerajEvent parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Seraj$RequestSendSerajEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
