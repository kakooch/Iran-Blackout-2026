package ai.bale.proto;

import ai.bale.proto.PeersStruct$UserOutPeer;
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
public final class BankOuterClass$RequestGrantBankiAccess extends GeneratedMessageLite implements U64 {
    public static final int BOT_FIELD_NUMBER = 1;
    private static final BankOuterClass$RequestGrantBankiAccess DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SERVICE_KEY_FIELD_NUMBER = 2;
    private int bitField0_;
    private PeersStruct$UserOutPeer bot_;
    private String serviceKey_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(PeersStruct$UserOutPeer.a aVar) {
            q();
            ((BankOuterClass$RequestGrantBankiAccess) this.b).setBot((PeersStruct$UserOutPeer) aVar.a());
            return this;
        }

        public a B(String str) {
            q();
            ((BankOuterClass$RequestGrantBankiAccess) this.b).setServiceKey(str);
            return this;
        }

        private a() {
            super(BankOuterClass$RequestGrantBankiAccess.DEFAULT_INSTANCE);
        }
    }

    static {
        BankOuterClass$RequestGrantBankiAccess bankOuterClass$RequestGrantBankiAccess = new BankOuterClass$RequestGrantBankiAccess();
        DEFAULT_INSTANCE = bankOuterClass$RequestGrantBankiAccess;
        GeneratedMessageLite.registerDefaultInstance(BankOuterClass$RequestGrantBankiAccess.class, bankOuterClass$RequestGrantBankiAccess);
    }

    private BankOuterClass$RequestGrantBankiAccess() {
    }

    private void clearBot() {
        this.bot_ = null;
        this.bitField0_ &= -2;
    }

    private void clearServiceKey() {
        this.serviceKey_ = getDefaultInstance().getServiceKey();
    }

    public static BankOuterClass$RequestGrantBankiAccess getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBot(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        PeersStruct$UserOutPeer peersStruct$UserOutPeer2 = this.bot_;
        if (peersStruct$UserOutPeer2 == null || peersStruct$UserOutPeer2 == PeersStruct$UserOutPeer.getDefaultInstance()) {
            this.bot_ = peersStruct$UserOutPeer;
        } else {
            this.bot_ = (PeersStruct$UserOutPeer) ((PeersStruct$UserOutPeer.a) PeersStruct$UserOutPeer.newBuilder(this.bot_).v(peersStruct$UserOutPeer)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static BankOuterClass$RequestGrantBankiAccess parseDelimitedFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGrantBankiAccess) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGrantBankiAccess parseFrom(ByteBuffer byteBuffer) {
        return (BankOuterClass$RequestGrantBankiAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBot(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        this.bot_ = peersStruct$UserOutPeer;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceKey(String str) {
        str.getClass();
        this.serviceKey_ = str;
    }

    private void setServiceKeyBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.serviceKey_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1876n.a[gVar.ordinal()]) {
            case 1:
                return new BankOuterClass$RequestGrantBankiAccess();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ", new Object[]{"bitField0_", "bot_", "serviceKey_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (BankOuterClass$RequestGrantBankiAccess.class) {
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

    public PeersStruct$UserOutPeer getBot() {
        PeersStruct$UserOutPeer peersStruct$UserOutPeer = this.bot_;
        return peersStruct$UserOutPeer == null ? PeersStruct$UserOutPeer.getDefaultInstance() : peersStruct$UserOutPeer;
    }

    public String getServiceKey() {
        return this.serviceKey_;
    }

    public AbstractC2383g getServiceKeyBytes() {
        return AbstractC2383g.N(this.serviceKey_);
    }

    public boolean hasBot() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(BankOuterClass$RequestGrantBankiAccess bankOuterClass$RequestGrantBankiAccess) {
        return (a) DEFAULT_INSTANCE.createBuilder(bankOuterClass$RequestGrantBankiAccess);
    }

    public static BankOuterClass$RequestGrantBankiAccess parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGrantBankiAccess) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGrantBankiAccess parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (BankOuterClass$RequestGrantBankiAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static BankOuterClass$RequestGrantBankiAccess parseFrom(AbstractC2383g abstractC2383g) {
        return (BankOuterClass$RequestGrantBankiAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static BankOuterClass$RequestGrantBankiAccess parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (BankOuterClass$RequestGrantBankiAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static BankOuterClass$RequestGrantBankiAccess parseFrom(byte[] bArr) {
        return (BankOuterClass$RequestGrantBankiAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BankOuterClass$RequestGrantBankiAccess parseFrom(byte[] bArr, C2394s c2394s) {
        return (BankOuterClass$RequestGrantBankiAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static BankOuterClass$RequestGrantBankiAccess parseFrom(InputStream inputStream) {
        return (BankOuterClass$RequestGrantBankiAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BankOuterClass$RequestGrantBankiAccess parseFrom(InputStream inputStream, C2394s c2394s) {
        return (BankOuterClass$RequestGrantBankiAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static BankOuterClass$RequestGrantBankiAccess parseFrom(AbstractC2384h abstractC2384h) {
        return (BankOuterClass$RequestGrantBankiAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static BankOuterClass$RequestGrantBankiAccess parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (BankOuterClass$RequestGrantBankiAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
