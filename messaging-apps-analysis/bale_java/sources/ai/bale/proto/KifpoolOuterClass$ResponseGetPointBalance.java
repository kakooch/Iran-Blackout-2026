package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC9969ar3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$ResponseGetPointBalance extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$ResponseGetPointBalance DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int POINT_BALANCE_INFO_FIELD_NUMBER = 1;
    private B.j pointBalanceInfo_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseGetPointBalance.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseGetPointBalance kifpoolOuterClass$ResponseGetPointBalance = new KifpoolOuterClass$ResponseGetPointBalance();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseGetPointBalance;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseGetPointBalance.class, kifpoolOuterClass$ResponseGetPointBalance);
    }

    private KifpoolOuterClass$ResponseGetPointBalance() {
    }

    private void addAllPointBalanceInfo(Iterable<? extends KifpoolStruct$PointBalanceInfo> iterable) {
        ensurePointBalanceInfoIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.pointBalanceInfo_);
    }

    private void addPointBalanceInfo(KifpoolStruct$PointBalanceInfo kifpoolStruct$PointBalanceInfo) {
        kifpoolStruct$PointBalanceInfo.getClass();
        ensurePointBalanceInfoIsMutable();
        this.pointBalanceInfo_.add(kifpoolStruct$PointBalanceInfo);
    }

    private void clearPointBalanceInfo() {
        this.pointBalanceInfo_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePointBalanceInfoIsMutable() {
        B.j jVar = this.pointBalanceInfo_;
        if (jVar.u()) {
            return;
        }
        this.pointBalanceInfo_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static KifpoolOuterClass$ResponseGetPointBalance getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseGetPointBalance parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetPointBalance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetPointBalance parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseGetPointBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePointBalanceInfo(int i) {
        ensurePointBalanceInfoIsMutable();
        this.pointBalanceInfo_.remove(i);
    }

    private void setPointBalanceInfo(int i, KifpoolStruct$PointBalanceInfo kifpoolStruct$PointBalanceInfo) {
        kifpoolStruct$PointBalanceInfo.getClass();
        ensurePointBalanceInfoIsMutable();
        this.pointBalanceInfo_.set(i, kifpoolStruct$PointBalanceInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseGetPointBalance();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"pointBalanceInfo_", KifpoolStruct$PointBalanceInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseGetPointBalance.class) {
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

    public KifpoolStruct$PointBalanceInfo getPointBalanceInfo(int i) {
        return (KifpoolStruct$PointBalanceInfo) this.pointBalanceInfo_.get(i);
    }

    public int getPointBalanceInfoCount() {
        return this.pointBalanceInfo_.size();
    }

    public List<KifpoolStruct$PointBalanceInfo> getPointBalanceInfoList() {
        return this.pointBalanceInfo_;
    }

    public InterfaceC9969ar3 getPointBalanceInfoOrBuilder(int i) {
        return (InterfaceC9969ar3) this.pointBalanceInfo_.get(i);
    }

    public List<? extends InterfaceC9969ar3> getPointBalanceInfoOrBuilderList() {
        return this.pointBalanceInfo_;
    }

    public static a newBuilder(KifpoolOuterClass$ResponseGetPointBalance kifpoolOuterClass$ResponseGetPointBalance) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseGetPointBalance);
    }

    public static KifpoolOuterClass$ResponseGetPointBalance parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointBalance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointBalance parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointBalance parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseGetPointBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPointBalanceInfo(int i, KifpoolStruct$PointBalanceInfo kifpoolStruct$PointBalanceInfo) {
        kifpoolStruct$PointBalanceInfo.getClass();
        ensurePointBalanceInfoIsMutable();
        this.pointBalanceInfo_.add(i, kifpoolStruct$PointBalanceInfo);
    }

    public static KifpoolOuterClass$ResponseGetPointBalance parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointBalance parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseGetPointBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseGetPointBalance parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointBalance parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetPointBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetPointBalance parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointBalance parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseGetPointBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseGetPointBalance parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointBalance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
