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

/* loaded from: classes9.dex */
public final class BankStruct$BotBankiAccessService extends GeneratedMessageLite implements U64 {
    private static final BankStruct$BotBankiAccessService DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SERVICE_EN_NAME_FIELD_NUMBER = 3;
    public static final int SERVICE_FA_NAME_FIELD_NUMBER = 2;
    public static final int SERVICE_KEY_FIELD_NUMBER = 1;
    private String serviceKey_ = "";
    private String serviceFaName_ = "";
    private String serviceEnName_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankStruct$BotBankiAccessService.DEFAULT_INSTANCE);
        }
    }

    static {
        BankStruct$BotBankiAccessService bankStruct$BotBankiAccessService = new BankStruct$BotBankiAccessService();
        DEFAULT_INSTANCE = bankStruct$BotBankiAccessService;
        GeneratedMessageLite.registerDefaultInstance(BankStruct$BotBankiAccessService.class, bankStruct$BotBankiAccessService);
    }

    private BankStruct$BotBankiAccessService() {
    }

    private void clearServiceEnName() {
        this.serviceEnName_ = getDefaultInstance().getServiceEnName();
    }

    private void clearServiceFaName() {
        this.serviceFaName_ = getDefaultInstance().getServiceFaName();
    }

    private void clearServiceKey() {
        this.serviceKey_ = getDefaultInstance().getServiceKey();
    }

    public static BankStruct$BotBankiAccessService getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankStruct$BotBankiAccessService parseDelimitedFrom(InputStream inputStream) {
        return (BankStruct$BotBankiAccessService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankStruct$BotBankiAccessService parseFrom(ByteBuffer byteBuffer) {
        return (BankStruct$BotBankiAccessService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setServiceEnName(String str) {
        str.getClass();
        this.serviceEnName_ = str;
    }

    private void setServiceEnNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.serviceEnName_ = abstractC2383g.f0();
    }

    private void setServiceFaName(String str) {
        str.getClass();
        this.serviceFaName_ = str;
    }

    private void setServiceFaNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.serviceFaName_ = abstractC2383g.f0();
    }

    private void setServiceKey(String str) {
        str.getClass();
        this.serviceKey_ = str;
    }

    private void setServiceKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.serviceKey_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1879o.a[gVar.ordinal()]) {
            case 1:
                return new BankStruct$BotBankiAccessService();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"serviceKey_", "serviceFaName_", "serviceEnName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankStruct$BotBankiAccessService.class) {
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

    public String getServiceEnName() {
        return this.serviceEnName_;
    }

    public AbstractC2383g getServiceEnNameBytes() {
        return AbstractC2383g.N(this.serviceEnName_);
    }

    public String getServiceFaName() {
        return this.serviceFaName_;
    }

    public AbstractC2383g getServiceFaNameBytes() {
        return AbstractC2383g.N(this.serviceFaName_);
    }

    public String getServiceKey() {
        return this.serviceKey_;
    }

    public AbstractC2383g getServiceKeyBytes() {
        return AbstractC2383g.N(this.serviceKey_);
    }

    public static a newBuilder(BankStruct$BotBankiAccessService bankStruct$BotBankiAccessService) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankStruct$BotBankiAccessService);
    }

    public static BankStruct$BotBankiAccessService parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankStruct$BotBankiAccessService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankStruct$BotBankiAccessService parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankStruct$BotBankiAccessService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankStruct$BotBankiAccessService parseFrom(AbstractC2383g abstractC2383g) {
        return (BankStruct$BotBankiAccessService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankStruct$BotBankiAccessService parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankStruct$BotBankiAccessService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankStruct$BotBankiAccessService parseFrom(byte[] bArr) {
        return (BankStruct$BotBankiAccessService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankStruct$BotBankiAccessService parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankStruct$BotBankiAccessService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankStruct$BotBankiAccessService parseFrom(InputStream inputStream) {
        return (BankStruct$BotBankiAccessService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankStruct$BotBankiAccessService parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankStruct$BotBankiAccessService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankStruct$BotBankiAccessService parseFrom(AbstractC2384h abstractC2384h) {
        return (BankStruct$BotBankiAccessService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankStruct$BotBankiAccessService parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankStruct$BotBankiAccessService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
