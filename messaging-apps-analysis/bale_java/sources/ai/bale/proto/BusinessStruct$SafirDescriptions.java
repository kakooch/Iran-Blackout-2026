package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import ir.nasim.Y96;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class BusinessStruct$SafirDescriptions extends GeneratedMessageLite implements U64 {
    public static final int BOT_ID_FIELD_NUMBER = 1;
    public static final int CREDIT_DETAILS_FIELD_NUMBER = 2;
    private static final BusinessStruct$SafirDescriptions DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private int botId_;
    private B.j creditDetails_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BusinessStruct$SafirDescriptions.DEFAULT_INSTANCE);
        }
    }

    static {
        BusinessStruct$SafirDescriptions businessStruct$SafirDescriptions = new BusinessStruct$SafirDescriptions();
        DEFAULT_INSTANCE = businessStruct$SafirDescriptions;
        GeneratedMessageLite.registerDefaultInstance(BusinessStruct$SafirDescriptions.class, businessStruct$SafirDescriptions);
    }

    private BusinessStruct$SafirDescriptions() {
    }

    private void addAllCreditDetails(Iterable<? extends SafirStruct$SafirCreditDetails> iterable) {
        ensureCreditDetailsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.creditDetails_);
    }

    private void addCreditDetails(SafirStruct$SafirCreditDetails safirStruct$SafirCreditDetails) {
        safirStruct$SafirCreditDetails.getClass();
        ensureCreditDetailsIsMutable();
        this.creditDetails_.add(safirStruct$SafirCreditDetails);
    }

    private void clearBotId() {
        this.botId_ = 0;
    }

    private void clearCreditDetails() {
        this.creditDetails_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureCreditDetailsIsMutable() {
        B.j jVar = this.creditDetails_;
        if (jVar.u()) {
            return;
        }
        this.creditDetails_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static BusinessStruct$SafirDescriptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BusinessStruct$SafirDescriptions parseDelimitedFrom(InputStream inputStream) {
        return (BusinessStruct$SafirDescriptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$SafirDescriptions parseFrom(ByteBuffer byteBuffer) {
        return (BusinessStruct$SafirDescriptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCreditDetails(int i) {
        ensureCreditDetailsIsMutable();
        this.creditDetails_.remove(i);
    }

    private void setBotId(int i) {
        this.botId_ = i;
    }

    private void setCreditDetails(int i, SafirStruct$SafirCreditDetails safirStruct$SafirCreditDetails) {
        safirStruct$SafirCreditDetails.getClass();
        ensureCreditDetailsIsMutable();
        this.creditDetails_.set(i, safirStruct$SafirCreditDetails);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1899v.a[gVar.ordinal()]) {
            case 1:
                return new BusinessStruct$SafirDescriptions();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0002\u001b", new Object[]{"botId_", "creditDetails_", SafirStruct$SafirCreditDetails.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BusinessStruct$SafirDescriptions.class) {
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

    public SafirStruct$SafirCreditDetails getCreditDetails(int i) {
        return (SafirStruct$SafirCreditDetails) this.creditDetails_.get(i);
    }

    public int getCreditDetailsCount() {
        return this.creditDetails_.size();
    }

    public List<SafirStruct$SafirCreditDetails> getCreditDetailsList() {
        return this.creditDetails_;
    }

    public Y96 getCreditDetailsOrBuilder(int i) {
        return (Y96) this.creditDetails_.get(i);
    }

    public List<? extends Y96> getCreditDetailsOrBuilderList() {
        return this.creditDetails_;
    }

    public static a newBuilder(BusinessStruct$SafirDescriptions businessStruct$SafirDescriptions) {
        return (a) DEFAULT_INSTANCE.createBuilder(businessStruct$SafirDescriptions);
    }

    public static BusinessStruct$SafirDescriptions parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$SafirDescriptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$SafirDescriptions parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BusinessStruct$SafirDescriptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BusinessStruct$SafirDescriptions parseFrom(AbstractC2383g abstractC2383g) {
        return (BusinessStruct$SafirDescriptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addCreditDetails(int i, SafirStruct$SafirCreditDetails safirStruct$SafirCreditDetails) {
        safirStruct$SafirCreditDetails.getClass();
        ensureCreditDetailsIsMutable();
        this.creditDetails_.add(i, safirStruct$SafirCreditDetails);
    }

    public static BusinessStruct$SafirDescriptions parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BusinessStruct$SafirDescriptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BusinessStruct$SafirDescriptions parseFrom(byte[] bArr) {
        return (BusinessStruct$SafirDescriptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BusinessStruct$SafirDescriptions parseFrom(byte[] bArr, C2394s c2394s) {
        return (BusinessStruct$SafirDescriptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BusinessStruct$SafirDescriptions parseFrom(InputStream inputStream) {
        return (BusinessStruct$SafirDescriptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BusinessStruct$SafirDescriptions parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BusinessStruct$SafirDescriptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BusinessStruct$SafirDescriptions parseFrom(AbstractC2384h abstractC2384h) {
        return (BusinessStruct$SafirDescriptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BusinessStruct$SafirDescriptions parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BusinessStruct$SafirDescriptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
