package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class WalletOuterClass$RequestGetWalletInvoice extends GeneratedMessageLite implements U64 {
    private static final WalletOuterClass$RequestGetWalletInvoice DEFAULT_INSTANCE;
    public static final int PAGE_NUMBER_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int WALLET_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private Int32Value pageNumber_;
    private String walletId_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(Int32Value int32Value) {
            q();
            ((WalletOuterClass$RequestGetWalletInvoice) this.b).setPageNumber(int32Value);
            return this;
        }

        public a B(String str) {
            q();
            ((WalletOuterClass$RequestGetWalletInvoice) this.b).setWalletId(str);
            return this;
        }

        private a() {
            super(WalletOuterClass$RequestGetWalletInvoice.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$RequestGetWalletInvoice walletOuterClass$RequestGetWalletInvoice = new WalletOuterClass$RequestGetWalletInvoice();
        DEFAULT_INSTANCE = walletOuterClass$RequestGetWalletInvoice;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$RequestGetWalletInvoice.class, walletOuterClass$RequestGetWalletInvoice);
    }

    private WalletOuterClass$RequestGetWalletInvoice() {
    }

    private void clearPageNumber() {
        this.pageNumber_ = null;
        this.bitField0_ &= -2;
    }

    private void clearWalletId() {
        this.walletId_ = getDefaultInstance().getWalletId();
    }

    public static WalletOuterClass$RequestGetWalletInvoice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePageNumber(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.pageNumber_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.pageNumber_ = int32Value;
        } else {
            this.pageNumber_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.pageNumber_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$RequestGetWalletInvoice parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestGetWalletInvoice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestGetWalletInvoice parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$RequestGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageNumber(Int32Value int32Value) {
        int32Value.getClass();
        this.pageNumber_ = int32Value;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWalletId(String str) {
        str.getClass();
        this.walletId_ = str;
    }

    private void setWalletIdBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.walletId_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$RequestGetWalletInvoice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "walletId_", "pageNumber_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$RequestGetWalletInvoice.class) {
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

    public Int32Value getPageNumber() {
        Int32Value int32Value = this.pageNumber_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public String getWalletId() {
        return this.walletId_;
    }

    public AbstractC2383g getWalletIdBytes() {
        return AbstractC2383g.N(this.walletId_);
    }

    public boolean hasPageNumber() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(WalletOuterClass$RequestGetWalletInvoice walletOuterClass$RequestGetWalletInvoice) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$RequestGetWalletInvoice);
    }

    public static WalletOuterClass$RequestGetWalletInvoice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestGetWalletInvoice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestGetWalletInvoice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$RequestGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$RequestGetWalletInvoice parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$RequestGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static WalletOuterClass$RequestGetWalletInvoice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$RequestGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$RequestGetWalletInvoice parseFrom(byte[] bArr) {
        return (WalletOuterClass$RequestGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$RequestGetWalletInvoice parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$RequestGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$RequestGetWalletInvoice parseFrom(InputStream inputStream) {
        return (WalletOuterClass$RequestGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$RequestGetWalletInvoice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$RequestGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$RequestGetWalletInvoice parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$RequestGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$RequestGetWalletInvoice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$RequestGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
