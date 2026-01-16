package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$Int64Value;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$ResponseGetCredit extends GeneratedMessageLite implements U64 {
    public static final int BALANCE_FIELD_NUMBER = 1;
    private static final KifpoolOuterClass$ResponseGetCredit DEFAULT_INSTANCE;
    public static final int HAS_CREDIT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private CollectionsStruct$Int64Value balance_;
    private int bitField0_;
    private boolean hasCredit_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseGetCredit.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseGetCredit kifpoolOuterClass$ResponseGetCredit = new KifpoolOuterClass$ResponseGetCredit();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseGetCredit;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseGetCredit.class, kifpoolOuterClass$ResponseGetCredit);
    }

    private KifpoolOuterClass$ResponseGetCredit() {
    }

    private void clearBalance() {
        this.balance_ = null;
        this.bitField0_ &= -2;
    }

    private void clearHasCredit() {
        this.hasCredit_ = false;
    }

    public static KifpoolOuterClass$ResponseGetCredit getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBalance(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        CollectionsStruct$Int64Value collectionsStruct$Int64Value2 = this.balance_;
        if (collectionsStruct$Int64Value2 == null || collectionsStruct$Int64Value2 == CollectionsStruct$Int64Value.getDefaultInstance()) {
            this.balance_ = collectionsStruct$Int64Value;
        } else {
            this.balance_ = (CollectionsStruct$Int64Value) ((CollectionsStruct$Int64Value.a) CollectionsStruct$Int64Value.newBuilder(this.balance_).v(collectionsStruct$Int64Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseGetCredit parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetCredit) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetCredit parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseGetCredit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBalance(CollectionsStruct$Int64Value collectionsStruct$Int64Value) {
        collectionsStruct$Int64Value.getClass();
        this.balance_ = collectionsStruct$Int64Value;
        this.bitField0_ |= 1;
    }

    private void setHasCredit(boolean z) {
        this.hasCredit_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseGetCredit();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0007", new Object[]{"bitField0_", "balance_", "hasCredit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseGetCredit.class) {
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

    public CollectionsStruct$Int64Value getBalance() {
        CollectionsStruct$Int64Value collectionsStruct$Int64Value = this.balance_;
        return collectionsStruct$Int64Value == null ? CollectionsStruct$Int64Value.getDefaultInstance() : collectionsStruct$Int64Value;
    }

    public boolean getHasCredit() {
        return this.hasCredit_;
    }

    public boolean hasBalance() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$ResponseGetCredit kifpoolOuterClass$ResponseGetCredit) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseGetCredit);
    }

    public static KifpoolOuterClass$ResponseGetCredit parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetCredit) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetCredit parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetCredit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetCredit parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseGetCredit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static KifpoolOuterClass$ResponseGetCredit parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetCredit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetCredit parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseGetCredit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseGetCredit parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetCredit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetCredit parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetCredit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetCredit parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetCredit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetCredit parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseGetCredit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseGetCredit parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetCredit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
