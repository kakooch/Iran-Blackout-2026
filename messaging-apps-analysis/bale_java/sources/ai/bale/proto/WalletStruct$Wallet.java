package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.M38;
import ir.nasim.T38;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class WalletStruct$Wallet extends GeneratedMessageLite implements T38 {
    public static final int BALANCES_FIELD_NUMBER = 2;
    private static final WalletStruct$Wallet DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IS_ACTIVE_FIELD_NUMBER = 4;
    private static volatile KW4 PARSER = null;
    public static final int WALLET_LINK_FIELD_NUMBER = 3;
    private int bitField0_;
    private BoolValue isActive_;
    private StringValue walletLink_;
    private String id_ = "";
    private B.j balances_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements T38 {
        public a A(Iterable iterable) {
            q();
            ((WalletStruct$Wallet) this.b).addAllBalances(iterable);
            return this;
        }

        public a B(String str) {
            q();
            ((WalletStruct$Wallet) this.b).setId(str);
            return this;
        }

        public a C(BoolValue boolValue) {
            q();
            ((WalletStruct$Wallet) this.b).setIsActive(boolValue);
            return this;
        }

        public a D(StringValue stringValue) {
            q();
            ((WalletStruct$Wallet) this.b).setWalletLink(stringValue);
            return this;
        }

        private a() {
            super(WalletStruct$Wallet.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletStruct$Wallet walletStruct$Wallet = new WalletStruct$Wallet();
        DEFAULT_INSTANCE = walletStruct$Wallet;
        GeneratedMessageLite.registerDefaultInstance(WalletStruct$Wallet.class, walletStruct$Wallet);
    }

    private WalletStruct$Wallet() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllBalances(Iterable<? extends WalletStruct$Balance> iterable) {
        ensureBalancesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.balances_);
    }

    private void addBalances(WalletStruct$Balance walletStruct$Balance) {
        walletStruct$Balance.getClass();
        ensureBalancesIsMutable();
        this.balances_.add(walletStruct$Balance);
    }

    private void clearBalances() {
        this.balances_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    private void clearIsActive() {
        this.isActive_ = null;
        this.bitField0_ &= -3;
    }

    private void clearWalletLink() {
        this.walletLink_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureBalancesIsMutable() {
        B.j jVar = this.balances_;
        if (jVar.u()) {
            return;
        }
        this.balances_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static WalletStruct$Wallet getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeIsActive(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.isActive_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.isActive_ = boolValue;
        } else {
            this.isActive_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.isActive_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeWalletLink(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.walletLink_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.walletLink_ = stringValue;
        } else {
            this.walletLink_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.walletLink_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletStruct$Wallet parseDelimitedFrom(InputStream inputStream) {
        return (WalletStruct$Wallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletStruct$Wallet parseFrom(ByteBuffer byteBuffer) {
        return (WalletStruct$Wallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeBalances(int i) {
        ensureBalancesIsMutable();
        this.balances_.remove(i);
    }

    private void setBalances(int i, WalletStruct$Balance walletStruct$Balance) {
        walletStruct$Balance.getClass();
        ensureBalancesIsMutable();
        this.balances_.set(i, walletStruct$Balance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    private void setIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.id_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsActive(BoolValue boolValue) {
        boolValue.getClass();
        this.isActive_ = boolValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWalletLink(StringValue stringValue) {
        stringValue.getClass();
        this.walletLink_ = stringValue;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (v2.a[gVar.ordinal()]) {
            case 1:
                return new WalletStruct$Wallet();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003ဉ\u0000\u0004ဉ\u0001", new Object[]{"bitField0_", "id_", "balances_", WalletStruct$Balance.class, "walletLink_", "isActive_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletStruct$Wallet.class) {
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

    public WalletStruct$Balance getBalances(int i) {
        return (WalletStruct$Balance) this.balances_.get(i);
    }

    public int getBalancesCount() {
        return this.balances_.size();
    }

    public List<WalletStruct$Balance> getBalancesList() {
        return this.balances_;
    }

    public M38 getBalancesOrBuilder(int i) {
        return (M38) this.balances_.get(i);
    }

    public List<? extends M38> getBalancesOrBuilderList() {
        return this.balances_;
    }

    public String getId() {
        return this.id_;
    }

    public AbstractC2383g getIdBytes() {
        return AbstractC2383g.N(this.id_);
    }

    public BoolValue getIsActive() {
        BoolValue boolValue = this.isActive_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public StringValue getWalletLink() {
        StringValue stringValue = this.walletLink_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasIsActive() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasWalletLink() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(WalletStruct$Wallet walletStruct$Wallet) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletStruct$Wallet);
    }

    public static WalletStruct$Wallet parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletStruct$Wallet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletStruct$Wallet parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletStruct$Wallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletStruct$Wallet parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletStruct$Wallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addBalances(int i, WalletStruct$Balance walletStruct$Balance) {
        walletStruct$Balance.getClass();
        ensureBalancesIsMutable();
        this.balances_.add(i, walletStruct$Balance);
    }

    public static WalletStruct$Wallet parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletStruct$Wallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletStruct$Wallet parseFrom(byte[] bArr) {
        return (WalletStruct$Wallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletStruct$Wallet parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletStruct$Wallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletStruct$Wallet parseFrom(InputStream inputStream) {
        return (WalletStruct$Wallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletStruct$Wallet parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletStruct$Wallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletStruct$Wallet parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletStruct$Wallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletStruct$Wallet parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletStruct$Wallet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
