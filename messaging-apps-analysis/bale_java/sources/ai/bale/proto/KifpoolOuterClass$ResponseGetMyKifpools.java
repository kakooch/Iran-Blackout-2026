package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.InterfaceC8596Wq3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$ResponseGetMyKifpools extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$ResponseGetMyKifpools DEFAULT_INSTANCE;
    public static final int FIRST_NAME_FIELD_NUMBER = 2;
    public static final int LAST_NAME_FIELD_NUMBER = 3;
    public static final int MY_WALLETS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private StringValue firstName_;
    private StringValue lastName_;
    private B.j myWallets_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseGetMyKifpools.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseGetMyKifpools kifpoolOuterClass$ResponseGetMyKifpools = new KifpoolOuterClass$ResponseGetMyKifpools();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseGetMyKifpools;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseGetMyKifpools.class, kifpoolOuterClass$ResponseGetMyKifpools);
    }

    private KifpoolOuterClass$ResponseGetMyKifpools() {
    }

    private void addAllMyWallets(Iterable<? extends KifpoolStruct$Kifpool> iterable) {
        ensureMyWalletsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.myWallets_);
    }

    private void addMyWallets(KifpoolStruct$Kifpool kifpoolStruct$Kifpool) {
        kifpoolStruct$Kifpool.getClass();
        ensureMyWalletsIsMutable();
        this.myWallets_.add(kifpoolStruct$Kifpool);
    }

    private void clearFirstName() {
        this.firstName_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLastName() {
        this.lastName_ = null;
        this.bitField0_ &= -3;
    }

    private void clearMyWallets() {
        this.myWallets_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureMyWalletsIsMutable() {
        B.j jVar = this.myWallets_;
        if (jVar.u()) {
            return;
        }
        this.myWallets_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static KifpoolOuterClass$ResponseGetMyKifpools getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeFirstName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.firstName_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.firstName_ = stringValue;
        } else {
            this.firstName_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.firstName_).v(stringValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeLastName(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.lastName_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.lastName_ = stringValue;
        } else {
            this.lastName_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.lastName_).v(stringValue)).j();
        }
        this.bitField0_ |= 2;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseGetMyKifpools parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetMyKifpools) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetMyKifpools parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMyWallets(int i) {
        ensureMyWalletsIsMutable();
        this.myWallets_.remove(i);
    }

    private void setFirstName(StringValue stringValue) {
        stringValue.getClass();
        this.firstName_ = stringValue;
        this.bitField0_ |= 1;
    }

    private void setLastName(StringValue stringValue) {
        stringValue.getClass();
        this.lastName_ = stringValue;
        this.bitField0_ |= 2;
    }

    private void setMyWallets(int i, KifpoolStruct$Kifpool kifpoolStruct$Kifpool) {
        kifpoolStruct$Kifpool.getClass();
        ensureMyWalletsIsMutable();
        this.myWallets_.set(i, kifpoolStruct$Kifpool);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseGetMyKifpools();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"bitField0_", "myWallets_", KifpoolStruct$Kifpool.class, "firstName_", "lastName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseGetMyKifpools.class) {
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

    public StringValue getFirstName() {
        StringValue stringValue = this.firstName_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public StringValue getLastName() {
        StringValue stringValue = this.lastName_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public KifpoolStruct$Kifpool getMyWallets(int i) {
        return (KifpoolStruct$Kifpool) this.myWallets_.get(i);
    }

    public int getMyWalletsCount() {
        return this.myWallets_.size();
    }

    public List<KifpoolStruct$Kifpool> getMyWalletsList() {
        return this.myWallets_;
    }

    public InterfaceC8596Wq3 getMyWalletsOrBuilder(int i) {
        return (InterfaceC8596Wq3) this.myWallets_.get(i);
    }

    public List<? extends InterfaceC8596Wq3> getMyWalletsOrBuilderList() {
        return this.myWallets_;
    }

    public boolean hasFirstName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasLastName() {
        return (this.bitField0_ & 2) != 0;
    }

    public static a newBuilder(KifpoolOuterClass$ResponseGetMyKifpools kifpoolOuterClass$ResponseGetMyKifpools) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseGetMyKifpools);
    }

    public static KifpoolOuterClass$ResponseGetMyKifpools parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetMyKifpools) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetMyKifpools parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetMyKifpools parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addMyWallets(int i, KifpoolStruct$Kifpool kifpoolStruct$Kifpool) {
        kifpoolStruct$Kifpool.getClass();
        ensureMyWalletsIsMutable();
        this.myWallets_.add(i, kifpoolStruct$Kifpool);
    }

    public static KifpoolOuterClass$ResponseGetMyKifpools parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetMyKifpools parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseGetMyKifpools parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetMyKifpools parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetMyKifpools parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetMyKifpools parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseGetMyKifpools parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetMyKifpools) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
