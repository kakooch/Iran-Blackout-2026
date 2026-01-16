package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC8146Us3;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class LahzeOuterClass$ResponseGetGroupsLives extends GeneratedMessageLite implements U64 {
    private static final LahzeOuterClass$ResponseGetGroupsLives DEFAULT_INSTANCE;
    public static final int INFO_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j info_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(LahzeOuterClass$ResponseGetGroupsLives.DEFAULT_INSTANCE);
        }
    }

    static {
        LahzeOuterClass$ResponseGetGroupsLives lahzeOuterClass$ResponseGetGroupsLives = new LahzeOuterClass$ResponseGetGroupsLives();
        DEFAULT_INSTANCE = lahzeOuterClass$ResponseGetGroupsLives;
        GeneratedMessageLite.registerDefaultInstance(LahzeOuterClass$ResponseGetGroupsLives.class, lahzeOuterClass$ResponseGetGroupsLives);
    }

    private LahzeOuterClass$ResponseGetGroupsLives() {
    }

    private void addAllInfo(Iterable<? extends LahzeStruct$LiveInfo> iterable) {
        ensureInfoIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.info_);
    }

    private void addInfo(LahzeStruct$LiveInfo lahzeStruct$LiveInfo) {
        lahzeStruct$LiveInfo.getClass();
        ensureInfoIsMutable();
        this.info_.add(lahzeStruct$LiveInfo);
    }

    private void clearInfo() {
        this.info_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureInfoIsMutable() {
        B.j jVar = this.info_;
        if (jVar.u()) {
            return;
        }
        this.info_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static LahzeOuterClass$ResponseGetGroupsLives getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static LahzeOuterClass$ResponseGetGroupsLives parseDelimitedFrom(InputStream inputStream) {
        return (LahzeOuterClass$ResponseGetGroupsLives) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeOuterClass$ResponseGetGroupsLives parseFrom(ByteBuffer byteBuffer) {
        return (LahzeOuterClass$ResponseGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeInfo(int i) {
        ensureInfoIsMutable();
        this.info_.remove(i);
    }

    private void setInfo(int i, LahzeStruct$LiveInfo lahzeStruct$LiveInfo) {
        lahzeStruct$LiveInfo.getClass();
        ensureInfoIsMutable();
        this.info_.set(i, lahzeStruct$LiveInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1903w0.a[gVar.ordinal()]) {
            case 1:
                return new LahzeOuterClass$ResponseGetGroupsLives();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"info_", LahzeStruct$LiveInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (LahzeOuterClass$ResponseGetGroupsLives.class) {
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

    public LahzeStruct$LiveInfo getInfo(int i) {
        return (LahzeStruct$LiveInfo) this.info_.get(i);
    }

    public int getInfoCount() {
        return this.info_.size();
    }

    public List<LahzeStruct$LiveInfo> getInfoList() {
        return this.info_;
    }

    public InterfaceC8146Us3 getInfoOrBuilder(int i) {
        return (InterfaceC8146Us3) this.info_.get(i);
    }

    public List<? extends InterfaceC8146Us3> getInfoOrBuilderList() {
        return this.info_;
    }

    public static a newBuilder(LahzeOuterClass$ResponseGetGroupsLives lahzeOuterClass$ResponseGetGroupsLives) {
        return (a) DEFAULT_INSTANCE.createBuilder(lahzeOuterClass$ResponseGetGroupsLives);
    }

    public static LahzeOuterClass$ResponseGetGroupsLives parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeOuterClass$ResponseGetGroupsLives) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeOuterClass$ResponseGetGroupsLives parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (LahzeOuterClass$ResponseGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static LahzeOuterClass$ResponseGetGroupsLives parseFrom(AbstractC2383g abstractC2383g) {
        return (LahzeOuterClass$ResponseGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addInfo(int i, LahzeStruct$LiveInfo lahzeStruct$LiveInfo) {
        lahzeStruct$LiveInfo.getClass();
        ensureInfoIsMutable();
        this.info_.add(i, lahzeStruct$LiveInfo);
    }

    public static LahzeOuterClass$ResponseGetGroupsLives parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (LahzeOuterClass$ResponseGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static LahzeOuterClass$ResponseGetGroupsLives parseFrom(byte[] bArr) {
        return (LahzeOuterClass$ResponseGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LahzeOuterClass$ResponseGetGroupsLives parseFrom(byte[] bArr, C2394s c2394s) {
        return (LahzeOuterClass$ResponseGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static LahzeOuterClass$ResponseGetGroupsLives parseFrom(InputStream inputStream) {
        return (LahzeOuterClass$ResponseGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LahzeOuterClass$ResponseGetGroupsLives parseFrom(InputStream inputStream, C2394s c2394s) {
        return (LahzeOuterClass$ResponseGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static LahzeOuterClass$ResponseGetGroupsLives parseFrom(AbstractC2384h abstractC2384h) {
        return (LahzeOuterClass$ResponseGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static LahzeOuterClass$ResponseGetGroupsLives parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (LahzeOuterClass$ResponseGetGroupsLives) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
