package ai.bale.proto;

import ai.bale.proto.BankStruct$BotBankiAccessService;
import ai.bale.proto.PeersStruct$Peer;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class BankOuterClass$UpdateRequestLogin extends GeneratedMessageLite implements U64 {
    public static final int BOT_FIELD_NUMBER = 1;
    private static final BankOuterClass$UpdateRequestLogin DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SERVICE_FIELD_NUMBER = 3;
    private int bitField0_;
    private PeersStruct$Peer bot_;
    private BankStruct$BotBankiAccessService service_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(BankOuterClass$UpdateRequestLogin.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$UpdateRequestLogin bankOuterClass$UpdateRequestLogin = new BankOuterClass$UpdateRequestLogin();
        DEFAULT_INSTANCE = bankOuterClass$UpdateRequestLogin;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$UpdateRequestLogin.class, bankOuterClass$UpdateRequestLogin);
    }

    private BankOuterClass$UpdateRequestLogin() {
    }

    private void clearBot() {
        this.bot_ = null;
        this.bitField0_ &= -2;
    }

    private void clearService() {
        this.service_ = null;
        this.bitField0_ &= -3;
    }

    public static BankOuterClass$UpdateRequestLogin getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBot(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        PeersStruct$Peer peersStruct$Peer2 = this.bot_;
        if (peersStruct$Peer2 == null || peersStruct$Peer2 == PeersStruct$Peer.getDefaultInstance()) {
            this.bot_ = peersStruct$Peer;
        } else {
            this.bot_ = (PeersStruct$Peer) ((PeersStruct$Peer.a) PeersStruct$Peer.newBuilder(this.bot_).v(peersStruct$Peer)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeService(BankStruct$BotBankiAccessService bankStruct$BotBankiAccessService) {
        bankStruct$BotBankiAccessService.getClass();
        BankStruct$BotBankiAccessService bankStruct$BotBankiAccessService2 = this.service_;
        if (bankStruct$BotBankiAccessService2 == null || bankStruct$BotBankiAccessService2 == BankStruct$BotBankiAccessService.getDefaultInstance()) {
            this.service_ = bankStruct$BotBankiAccessService;
        } else {
            this.service_ = (BankStruct$BotBankiAccessService) ((BankStruct$BotBankiAccessService.a) BankStruct$BotBankiAccessService.newBuilder(this.service_).v(bankStruct$BotBankiAccessService)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$UpdateRequestLogin parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$UpdateRequestLogin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$UpdateRequestLogin parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$UpdateRequestLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBot(PeersStruct$Peer peersStruct$Peer) {
        peersStruct$Peer.getClass();
        this.bot_ = peersStruct$Peer;
        this.bitField0_ |= 1;
    }

    private void setService(BankStruct$BotBankiAccessService bankStruct$BotBankiAccessService) {
        bankStruct$BotBankiAccessService.getClass();
        this.service_ = bankStruct$BotBankiAccessService;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$UpdateRequestLogin();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "bot_", "service_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$UpdateRequestLogin.class) {
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

    public PeersStruct$Peer getBot() {
        PeersStruct$Peer peersStruct$Peer = this.bot_;
        return peersStruct$Peer == null ? PeersStruct$Peer.getDefaultInstance() : peersStruct$Peer;
    }

    public BankStruct$BotBankiAccessService getService() {
        BankStruct$BotBankiAccessService bankStruct$BotBankiAccessService = this.service_;
        return bankStruct$BotBankiAccessService == null ? BankStruct$BotBankiAccessService.getDefaultInstance() : bankStruct$BotBankiAccessService;
    }

    public boolean hasBot() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasService() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(BankOuterClass$UpdateRequestLogin bankOuterClass$UpdateRequestLogin) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$UpdateRequestLogin);
    }

    public static BankOuterClass$UpdateRequestLogin parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$UpdateRequestLogin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$UpdateRequestLogin parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$UpdateRequestLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$UpdateRequestLogin parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$UpdateRequestLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$UpdateRequestLogin parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$UpdateRequestLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$UpdateRequestLogin parseFrom(byte[] bArr) {
        return (BankOuterClass$UpdateRequestLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$UpdateRequestLogin parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$UpdateRequestLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$UpdateRequestLogin parseFrom(InputStream inputStream) {
        return (BankOuterClass$UpdateRequestLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$UpdateRequestLogin parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$UpdateRequestLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$UpdateRequestLogin parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$UpdateRequestLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$UpdateRequestLogin parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$UpdateRequestLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
