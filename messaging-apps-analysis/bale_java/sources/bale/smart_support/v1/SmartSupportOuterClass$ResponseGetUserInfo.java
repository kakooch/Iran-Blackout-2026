package bale.smart_support.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC23045wF6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$ResponseGetUserInfo extends GeneratedMessageLite implements U64 {
    public static final int BOT_IDS_FIELD_NUMBER = 1;
    private static final SmartSupportOuterClass$ResponseGetUserInfo DEFAULT_INSTANCE;
    public static final int PACKAGES_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER;
    private int botIdsMemoizedSerializedSize = -1;
    private B.g botIds_ = GeneratedMessageLite.emptyIntList();
    private B.j packages_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$ResponseGetUserInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$ResponseGetUserInfo smartSupportOuterClass$ResponseGetUserInfo = new SmartSupportOuterClass$ResponseGetUserInfo();
        DEFAULT_INSTANCE = smartSupportOuterClass$ResponseGetUserInfo;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$ResponseGetUserInfo.class, smartSupportOuterClass$ResponseGetUserInfo);
    }

    private SmartSupportOuterClass$ResponseGetUserInfo() {
    }

    private void addAllBotIds(Iterable<? extends Integer> iterable) {
        ensureBotIdsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.botIds_);
    }

    private void addAllPackages(Iterable<? extends SmartSupportStruct$UserPackage> iterable) {
        ensurePackagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.packages_);
    }

    private void addBotIds(int i) {
        ensureBotIdsIsMutable();
        this.botIds_.b1(i);
    }

    private void addPackages(SmartSupportStruct$UserPackage smartSupportStruct$UserPackage) {
        smartSupportStruct$UserPackage.getClass();
        ensurePackagesIsMutable();
        this.packages_.add(smartSupportStruct$UserPackage);
    }

    private void clearBotIds() {
        this.botIds_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearPackages() {
        this.packages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureBotIdsIsMutable() {
        B.g gVar = this.botIds_;
        if (gVar.u()) {
            return;
        }
        this.botIds_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    private void ensurePackagesIsMutable() {
        B.j jVar = this.packages_;
        if (jVar.u()) {
            return;
        }
        this.packages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static SmartSupportOuterClass$ResponseGetUserInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$ResponseGetUserInfo parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseGetUserInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseGetUserInfo parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$ResponseGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePackages(int i) {
        ensurePackagesIsMutable();
        this.packages_.remove(i);
    }

    private void setBotIds(int i, int i2) {
        ensureBotIdsIsMutable();
        this.botIds_.U(i, i2);
    }

    private void setPackages(int i, SmartSupportStruct$UserPackage smartSupportStruct$UserPackage) {
        smartSupportStruct$UserPackage.getClass();
        ensurePackagesIsMutable();
        this.packages_.set(i, smartSupportStruct$UserPackage);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$ResponseGetUserInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001'\u0002\u001b", new Object[]{"botIds_", "packages_", SmartSupportStruct$UserPackage.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$ResponseGetUserInfo.class) {
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

    public int getBotIds(int i) {
        return this.botIds_.getInt(i);
    }

    public int getBotIdsCount() {
        return this.botIds_.size();
    }

    public List<Integer> getBotIdsList() {
        return this.botIds_;
    }

    public SmartSupportStruct$UserPackage getPackages(int i) {
        return (SmartSupportStruct$UserPackage) this.packages_.get(i);
    }

    public int getPackagesCount() {
        return this.packages_.size();
    }

    public List<SmartSupportStruct$UserPackage> getPackagesList() {
        return this.packages_;
    }

    public InterfaceC23045wF6 getPackagesOrBuilder(int i) {
        return (InterfaceC23045wF6) this.packages_.get(i);
    }

    public List<? extends InterfaceC23045wF6> getPackagesOrBuilderList() {
        return this.packages_;
    }

    public static a newBuilder(SmartSupportOuterClass$ResponseGetUserInfo smartSupportOuterClass$ResponseGetUserInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$ResponseGetUserInfo);
    }

    public static SmartSupportOuterClass$ResponseGetUserInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetUserInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetUserInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetUserInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$ResponseGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addPackages(int i, SmartSupportStruct$UserPackage smartSupportStruct$UserPackage) {
        smartSupportStruct$UserPackage.getClass();
        ensurePackagesIsMutable();
        this.packages_.add(i, smartSupportStruct$UserPackage);
    }

    public static SmartSupportOuterClass$ResponseGetUserInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetUserInfo parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$ResponseGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$ResponseGetUserInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetUserInfo parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseGetUserInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetUserInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$ResponseGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$ResponseGetUserInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
