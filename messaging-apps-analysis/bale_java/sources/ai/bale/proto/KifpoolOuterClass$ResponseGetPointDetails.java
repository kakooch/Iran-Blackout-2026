package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11970dr3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class KifpoolOuterClass$ResponseGetPointDetails extends GeneratedMessageLite implements U64 {
    private static final KifpoolOuterClass$ResponseGetPointDetails DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int POINT_DETAILS_INFO_FIELD_NUMBER = 1;
    private B.j pointDetailsInfo_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(KifpoolOuterClass$ResponseGetPointDetails.DEFAULT_INSTANCE);
        }
    }

    static {
        KifpoolOuterClass$ResponseGetPointDetails kifpoolOuterClass$ResponseGetPointDetails = new KifpoolOuterClass$ResponseGetPointDetails();
        DEFAULT_INSTANCE = kifpoolOuterClass$ResponseGetPointDetails;
        GeneratedMessageLite.registerDefaultInstance(KifpoolOuterClass$ResponseGetPointDetails.class, kifpoolOuterClass$ResponseGetPointDetails);
    }

    private KifpoolOuterClass$ResponseGetPointDetails() {
    }

    private void addAllPointDetailsInfo(Iterable<? extends KifpoolStruct$PointDetailsInfo> iterable) {
        ensurePointDetailsInfoIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.pointDetailsInfo_);
    }

    private void addPointDetailsInfo(KifpoolStruct$PointDetailsInfo kifpoolStruct$PointDetailsInfo) {
        kifpoolStruct$PointDetailsInfo.getClass();
        ensurePointDetailsInfoIsMutable();
        this.pointDetailsInfo_.add(kifpoolStruct$PointDetailsInfo);
    }

    private void clearPointDetailsInfo() {
        this.pointDetailsInfo_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePointDetailsInfoIsMutable() {
        B.j jVar = this.pointDetailsInfo_;
        if (jVar.u()) {
            return;
        }
        this.pointDetailsInfo_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static KifpoolOuterClass$ResponseGetPointDetails getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static KifpoolOuterClass$ResponseGetPointDetails parseDelimitedFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetPointDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetPointDetails parseFrom(ByteBuffer byteBuffer) {
        return (KifpoolOuterClass$ResponseGetPointDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePointDetailsInfo(int i) {
        ensurePointDetailsInfoIsMutable();
        this.pointDetailsInfo_.remove(i);
    }

    private void setPointDetailsInfo(int i, KifpoolStruct$PointDetailsInfo kifpoolStruct$PointDetailsInfo) {
        kifpoolStruct$PointDetailsInfo.getClass();
        ensurePointDetailsInfoIsMutable();
        this.pointDetailsInfo_.set(i, kifpoolStruct$PointDetailsInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1897u0.a[gVar.ordinal()]) {
            case 1:
                return new KifpoolOuterClass$ResponseGetPointDetails();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"pointDetailsInfo_", KifpoolStruct$PointDetailsInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (KifpoolOuterClass$ResponseGetPointDetails.class) {
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

    public KifpoolStruct$PointDetailsInfo getPointDetailsInfo(int i) {
        return (KifpoolStruct$PointDetailsInfo) this.pointDetailsInfo_.get(i);
    }

    public int getPointDetailsInfoCount() {
        return this.pointDetailsInfo_.size();
    }

    public List<KifpoolStruct$PointDetailsInfo> getPointDetailsInfoList() {
        return this.pointDetailsInfo_;
    }

    public InterfaceC11970dr3 getPointDetailsInfoOrBuilder(int i) {
        return (InterfaceC11970dr3) this.pointDetailsInfo_.get(i);
    }

    public List<? extends InterfaceC11970dr3> getPointDetailsInfoOrBuilderList() {
        return this.pointDetailsInfo_;
    }

    public static a newBuilder(KifpoolOuterClass$ResponseGetPointDetails kifpoolOuterClass$ResponseGetPointDetails) {
        return (a) DEFAULT_INSTANCE.createBuilder(kifpoolOuterClass$ResponseGetPointDetails);
    }

    public static KifpoolOuterClass$ResponseGetPointDetails parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointDetails) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointDetails parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointDetails parseFrom(AbstractC2383g abstractC2383g) {
        return (KifpoolOuterClass$ResponseGetPointDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPointDetailsInfo(int i, KifpoolStruct$PointDetailsInfo kifpoolStruct$PointDetailsInfo) {
        kifpoolStruct$PointDetailsInfo.getClass();
        ensurePointDetailsInfoIsMutable();
        this.pointDetailsInfo_.add(i, kifpoolStruct$PointDetailsInfo);
    }

    public static KifpoolOuterClass$ResponseGetPointDetails parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointDetails parseFrom(byte[] bArr) {
        return (KifpoolOuterClass$ResponseGetPointDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static KifpoolOuterClass$ResponseGetPointDetails parseFrom(byte[] bArr, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointDetails parseFrom(InputStream inputStream) {
        return (KifpoolOuterClass$ResponseGetPointDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static KifpoolOuterClass$ResponseGetPointDetails parseFrom(InputStream inputStream, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static KifpoolOuterClass$ResponseGetPointDetails parseFrom(AbstractC2384h abstractC2384h) {
        return (KifpoolOuterClass$ResponseGetPointDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static KifpoolOuterClass$ResponseGetPointDetails parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (KifpoolOuterClass$ResponseGetPointDetails) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
