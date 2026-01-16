package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.MessagingStruct$HistoryMessageIdentifier;
import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WalletOuterClass$RequestPayMoneyRequestByWallet extends GeneratedMessageLite implements U64 {
    public static final int AMOUNT_FIELD_NUMBER = 3;
    private static final WalletOuterClass$RequestPayMoneyRequestByWallet DEFAULT_INSTANCE;
    public static final int MSG_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int REGARDING_FIELD_NUMBER = 4;
    public static final int SOURCE_WALLET_ID_FIELD_NUMBER = 1;
    private CollectionsStruct$Int64Value amount_;
    private int bitField0_;
    private MessagingStruct$HistoryMessageIdentifier msg_;
    private StringValue regarding_;
    private String sourceWalletId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
            q();
            ((WalletOuterClass$RequestPayMoneyRequestByWallet) this.b).setAmount(collectionsStruct$Int64Value);
            return this;
        }

        public a B(MessagingStruct$HistoryMessageIdentifier.a aVar) {
            q();
            ((WalletOuterClass$RequestPayMoneyRequestByWallet) this.b).setMsg((MessagingStruct$HistoryMessageIdentifier) aVar.a());
            return this;
        }

        public a C(StringValue stringValue) {
            q();
            ((WalletOuterClass$RequestPayMoneyRequestByWallet) this.b).setRegarding(stringValue);
            return this;
        }

        public a D(String str) {
            q();
            ((WalletOuterClass$RequestPayMoneyRequestByWallet) this.b).setSourceWalletId(str);
            return this;
        }

        private a() {
            super(WalletOuterClass$RequestPayMoneyRequestByWallet.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$RequestPayMoneyRequestByWallet walletOuterClass$RequestPayMoneyRequestByWallet = new WalletOuterClass$RequestPayMoneyRequestByWallet();
        DEFAULT_INSTANCE = walletOuterClass$RequestPayMoneyRequestByWallet;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$RequestPayMoneyRequestByWallet.class, walletOuterClass$RequestPayMoneyRequestByWallet);
    }

    private WalletOuterClass$RequestPayMoneyRequestByWallet() {
    }

    private void clearAmount() {
        this.amount_ = null;
        this.bitField0_ &= -3;
    }

    private void clearMsg() {
        this.msg_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRegarding() {
        this.regarding_ = null;
        this.bitField0_ &= -5;
    }

    private void clearSourceWalletId() {
        this.sourceWalletId_ = getDefaultInstance().getSourceWalletId();
    }

    public static WalletOuterClass$RequestPayMoneyRequestByWallet getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAmount(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.amount_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.amount_ = collectionsStruct$Int64Value;
        } else {
            this.amount_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.amount_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeMsg(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier2 = this.msg_;
        if (messagingStruct$HistoryMessageIdentifier2 == null || messagingStruct$HistoryMessageIdentifier2 == MessagingStruct$HistoryMessageIdentifier.getDefaultInstance()) {
            this.msg_ = messagingStruct$HistoryMessageIdentifier;
        } else {
            this.msg_ = (MessagingStruct$HistoryMessageIdentifier) ((MessagingStruct$HistoryMessageIdentifier.a) MessagingStruct$HistoryMessageIdentifier.newBuilder(this.msg_).v(messagingStruct$HistoryMessageIdentifier)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeRegarding(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.regarding_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.regarding_ = stringValue;
        } else {
            this.regarding_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.regarding_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$RequestPayMoneyRequestByWallet parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestPayMoneyRequestByWallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestPayMoneyRequestByWallet parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$RequestPayMoneyRequestByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmount(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.amount_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMsg(MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier) {
        messagingStruct$HistoryMessageIdentifier.getClass();
        this.msg_ = messagingStruct$HistoryMessageIdentifier;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegarding(StringValue stringValue) {
        stringValue.getClass();
        this.regarding_ = stringValue;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceWalletId(String str) {
        str.getClass();
        this.sourceWalletId_ = str;
    }

    private void setSourceWalletIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.sourceWalletId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$RequestPayMoneyRequestByWallet();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "sourceWalletId_", "msg_", "amount_", "regarding_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$RequestPayMoneyRequestByWallet.class) {
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

    public CollectionsStruct$Int64Value getAmount() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.amount_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public MessagingStruct$HistoryMessageIdentifier getMsg() {
        MessagingStruct$HistoryMessageIdentifier messagingStruct$HistoryMessageIdentifier = this.msg_;
        return messagingStruct$HistoryMessageIdentifier == null ? MessagingStruct$HistoryMessageIdentifier.getDefaultInstance() : messagingStruct$HistoryMessageIdentifier;
    }

    public StringValue getRegarding() {
        StringValue stringValue = this.regarding_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public String getSourceWalletId() {
        return this.sourceWalletId_;
    }

    public AbstractC2383g getSourceWalletIdBytes() {
        return AbstractC2383g.N(this.sourceWalletId_);
    }

    public boolean hasAmount() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMsg() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasRegarding() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(WalletOuterClass$RequestPayMoneyRequestByWallet walletOuterClass$RequestPayMoneyRequestByWallet) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$RequestPayMoneyRequestByWallet);
    }

    public static WalletOuterClass$RequestPayMoneyRequestByWallet parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestPayMoneyRequestByWallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestPayMoneyRequestByWallet parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$RequestPayMoneyRequestByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$RequestPayMoneyRequestByWallet parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$RequestPayMoneyRequestByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$RequestPayMoneyRequestByWallet parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$RequestPayMoneyRequestByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$RequestPayMoneyRequestByWallet parseFrom(byte[] bArr) {
        return (WalletOuterClass$RequestPayMoneyRequestByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$RequestPayMoneyRequestByWallet parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$RequestPayMoneyRequestByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$RequestPayMoneyRequestByWallet parseFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestPayMoneyRequestByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestPayMoneyRequestByWallet parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestPayMoneyRequestByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestPayMoneyRequestByWallet parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$RequestPayMoneyRequestByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$RequestPayMoneyRequestByWallet parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$RequestPayMoneyRequestByWallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
