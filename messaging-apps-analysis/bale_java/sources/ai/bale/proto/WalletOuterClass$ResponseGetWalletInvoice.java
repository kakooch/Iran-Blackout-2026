package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.S38;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class WalletOuterClass$ResponseGetWalletInvoice extends GeneratedMessageLite implements U64 {
    private static final WalletOuterClass$ResponseGetWalletInvoice DEFAULT_INSTANCE;
    public static final int INVOICES_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j invoices_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(WalletOuterClass$ResponseGetWalletInvoice.DEFAULT_INSTANCE);
        }
    }

    static {
        WalletOuterClass$ResponseGetWalletInvoice walletOuterClass$ResponseGetWalletInvoice = new WalletOuterClass$ResponseGetWalletInvoice();
        DEFAULT_INSTANCE = walletOuterClass$ResponseGetWalletInvoice;
        GeneratedMessageLite.registerDefaultInstance(WalletOuterClass$ResponseGetWalletInvoice.class, walletOuterClass$ResponseGetWalletInvoice);
    }

    private WalletOuterClass$ResponseGetWalletInvoice() {
    }

    private void addAllInvoices(Iterable<? extends WalletStruct$WalletInvoice> iterable) {
        ensureInvoicesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.invoices_);
    }

    private void addInvoices(WalletStruct$WalletInvoice walletStruct$WalletInvoice) {
        walletStruct$WalletInvoice.getClass();
        ensureInvoicesIsMutable();
        this.invoices_.add(walletStruct$WalletInvoice);
    }

    private void clearInvoices() {
        this.invoices_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureInvoicesIsMutable() {
        B.j jVar = this.invoices_;
        if (jVar.u()) {
            return;
        }
        this.invoices_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static WalletOuterClass$ResponseGetWalletInvoice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static WalletOuterClass$ResponseGetWalletInvoice parseDelimitedFrom(InputStream inputStream) {
        return (WalletOuterClass$ResponseGetWalletInvoice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$ResponseGetWalletInvoice parseFrom(ByteBuffer byteBuffer) {
        return (WalletOuterClass$ResponseGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeInvoices(int i) {
        ensureInvoicesIsMutable();
        this.invoices_.remove(i);
    }

    private void setInvoices(int i, WalletStruct$WalletInvoice walletStruct$WalletInvoice) {
        walletStruct$WalletInvoice.getClass();
        ensureInvoicesIsMutable();
        this.invoices_.set(i, walletStruct$WalletInvoice);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (u2.a[gVar.ordinal()]) {
            case 1:
                return new WalletOuterClass$ResponseGetWalletInvoice();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"invoices_", WalletStruct$WalletInvoice.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (WalletOuterClass$ResponseGetWalletInvoice.class) {
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

    public WalletStruct$WalletInvoice getInvoices(int i) {
        return (WalletStruct$WalletInvoice) this.invoices_.get(i);
    }

    public int getInvoicesCount() {
        return this.invoices_.size();
    }

    public List<WalletStruct$WalletInvoice> getInvoicesList() {
        return this.invoices_;
    }

    public S38 getInvoicesOrBuilder(int i) {
        return (S38) this.invoices_.get(i);
    }

    public List<? extends S38> getInvoicesOrBuilderList() {
        return this.invoices_;
    }

    public static a newBuilder(WalletOuterClass$ResponseGetWalletInvoice walletOuterClass$ResponseGetWalletInvoice) {
        return (a) DEFAULT_INSTANCE.createBuilder(walletOuterClass$ResponseGetWalletInvoice);
    }

    public static WalletOuterClass$ResponseGetWalletInvoice parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetWalletInvoice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$ResponseGetWalletInvoice parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static WalletOuterClass$ResponseGetWalletInvoice parseFrom(AbstractC2383g abstractC2383g) {
        return (WalletOuterClass$ResponseGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addInvoices(int i, WalletStruct$WalletInvoice walletStruct$WalletInvoice) {
        walletStruct$WalletInvoice.getClass();
        ensureInvoicesIsMutable();
        this.invoices_.add(i, walletStruct$WalletInvoice);
    }

    public static WalletOuterClass$ResponseGetWalletInvoice parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static WalletOuterClass$ResponseGetWalletInvoice parseFrom(byte[] bArr) {
        return (WalletOuterClass$ResponseGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static WalletOuterClass$ResponseGetWalletInvoice parseFrom(byte[] bArr, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static WalletOuterClass$ResponseGetWalletInvoice parseFrom(InputStream inputStream) {
        return (WalletOuterClass$ResponseGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static WalletOuterClass$ResponseGetWalletInvoice parseFrom(InputStream inputStream, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static WalletOuterClass$ResponseGetWalletInvoice parseFrom(AbstractC2384h abstractC2384h) {
        return (WalletOuterClass$ResponseGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static WalletOuterClass$ResponseGetWalletInvoice parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (WalletOuterClass$ResponseGetWalletInvoice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
