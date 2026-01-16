package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC13219fr3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$ResponseGetPointSummery extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$ResponseGetPointSummery DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int POINT_SUMMERY_INFO_FIELD_NUMBER = 1;
    private B.j pointSummeryInfo_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseGetPointSummery.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseGetPointSummery kifpoolOuterClass$ResponseGetPointSummery = new KifpoolOuterClass$ResponseGetPointSummery();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseGetPointSummery;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseGetPointSummery.class, kifpoolOuterClass$ResponseGetPointSummery);
    }

    private KifpoolOuterClass$ResponseGetPointSummery() {
    }

    private void addAllPointSummeryInfo(Iterable<? extends KifpoolStruct$PointSummeryInfo> iterable) {
        ensurePointSummeryInfoIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.pointSummeryInfo_);
    }

    private void addPointSummeryInfo(KifpoolStruct$PointSummeryInfo kifpoolStruct$PointSummeryInfo) {
        kifpoolStruct$PointSummeryInfo.getClass();
        ensurePointSummeryInfoIsMutable();
        this.pointSummeryInfo_.add(kifpoolStruct$PointSummeryInfo);
    }

    private void clearPointSummeryInfo() {
        this.pointSummeryInfo_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePointSummeryInfoIsMutable() {
        B.j jVar = this.pointSummeryInfo_;
        if (jVar.u()) {
            return;
        }
        this.pointSummeryInfo_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static KifpoolOuterClass$ResponseGetPointSummery getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseGetPointSummery parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetPointSummery) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetPointSummery parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePointSummeryInfo(int i) {
        ensurePointSummeryInfoIsMutable();
        this.pointSummeryInfo_.remove(i);
    }

    private void setPointSummeryInfo(int i, KifpoolStruct$PointSummeryInfo kifpoolStruct$PointSummeryInfo) {
        kifpoolStruct$PointSummeryInfo.getClass();
        ensurePointSummeryInfoIsMutable();
        this.pointSummeryInfo_.set(i, kifpoolStruct$PointSummeryInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseGetPointSummery();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"pointSummeryInfo_", KifpoolStruct$PointSummeryInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseGetPointSummery.class) {
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

    public KifpoolStruct$PointSummeryInfo getPointSummeryInfo(int i) {
        return (KifpoolStruct$PointSummeryInfo) this.pointSummeryInfo_.get(i);
    }

    public int getPointSummeryInfoCount() {
        return this.pointSummeryInfo_.size();
    }

    public List<KifpoolStruct$PointSummeryInfo> getPointSummeryInfoList() {
        return this.pointSummeryInfo_;
    }

    public InterfaceC13219fr3 getPointSummeryInfoOrBuilder(int i) {
        return (InterfaceC13219fr3) this.pointSummeryInfo_.get(i);
    }

    public List<? extends InterfaceC13219fr3> getPointSummeryInfoOrBuilderList() {
        return this.pointSummeryInfo_;
    }

    public static a newBuilder(KifpoolOuterClass$ResponseGetPointSummery kifpoolOuterClass$ResponseGetPointSummery) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseGetPointSummery);
    }

    public static KifpoolOuterClass$ResponseGetPointSummery parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointSummery) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointSummery parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointSummery parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPointSummeryInfo(int i, KifpoolStruct$PointSummeryInfo kifpoolStruct$PointSummeryInfo) {
        kifpoolStruct$PointSummeryInfo.getClass();
        ensurePointSummeryInfoIsMutable();
        this.pointSummeryInfo_.add(i, kifpoolStruct$PointSummeryInfo);
    }

    public static KifpoolOuterClass$ResponseGetPointSummery parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointSummery parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseGetPointSummery parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointSummery parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetPointSummery parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointSummery parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseGetPointSummery parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointSummery) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
