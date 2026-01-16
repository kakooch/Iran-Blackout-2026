package bale.smart_support.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
import ir.nasim.InterfaceC20582sF6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportStruct$Package extends GeneratedMessageLite implements InterfaceC20582sF6 {
    public static final int ASSISTANT_LIMIT_FIELD_NUMBER = 5;
    private static final SmartSupportStruct$Package DEFAULT_INSTANCE;
    public static final int FILES_LIMIT_FIELD_NUMBER = 6;
    public static final int FILE_SIZE_FIELD_NUMBER = 7;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int PHOSPHORUS_FIELD_NUMBER = 3;
    public static final int PRICE_FIELD_NUMBER = 8;
    public static final int TIME_LIMIT_FIELD_NUMBER = 4;
    private int assistantLimit_;
    private int bitField0_;
    private int fileSize_;
    private int filesLimit_;
    private Int32Value id_;
    private String packageName_ = "";
    private int phosphorus_;
    private int price_;
    private int timeLimit_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC20582sF6 {
        private a() {
            super(SmartSupportStruct$Package.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportStruct$Package smartSupportStruct$Package = new SmartSupportStruct$Package();
        DEFAULT_INSTANCE = smartSupportStruct$Package;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportStruct$Package.class, smartSupportStruct$Package);
    }

    private SmartSupportStruct$Package() {
    }

    private void clearAssistantLimit() {
        this.assistantLimit_ = 0;
    }

    private void clearFileSize() {
        this.fileSize_ = 0;
    }

    private void clearFilesLimit() {
        this.filesLimit_ = 0;
    }

    private void clearId() {
        this.id_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPackageName() {
        this.packageName_ = getDefaultInstance().getPackageName();
    }

    private void clearPhosphorus() {
        this.phosphorus_ = 0;
    }

    private void clearPrice() {
        this.price_ = 0;
    }

    private void clearTimeLimit() {
        this.timeLimit_ = 0;
    }

    public static SmartSupportStruct$Package getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeId(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.id_;
        if (int32Value2 == null || int32Value2 == Int32Value.getDefaultInstance()) {
            this.id_ = int32Value;
        } else {
            this.id_ = (Int32Value) ((Int32Value.b) Int32Value.newBuilder(this.id_).v(int32Value)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportStruct$Package parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportStruct$Package) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportStruct$Package parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportStruct$Package) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAssistantLimit(int i) {
        this.assistantLimit_ = i;
    }

    private void setFileSize(int i) {
        this.fileSize_ = i;
    }

    private void setFilesLimit(int i) {
        this.filesLimit_ = i;
    }

    private void setId(Int32Value int32Value) {
        int32Value.getClass();
        this.id_ = int32Value;
        this.bitField0_ |= 1;
    }

    private void setPackageName(String str) {
        str.getClass();
        this.packageName_ = str;
    }

    private void setPackageNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.packageName_ = abstractC2383g.f0();
    }

    private void setPhosphorus(int i) {
        this.phosphorus_ = i;
    }

    private void setPrice(int i) {
        this.price_ = i;
    }

    private void setTimeLimit(int i) {
        this.timeLimit_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportStruct$Package();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003\u0004\u0004\u0004\u0005\u0004\u0006\u0004\u0007\u0004\b\u0004", new Object[]{"bitField0_", "id_", "packageName_", "phosphorus_", "timeLimit_", "assistantLimit_", "filesLimit_", "fileSize_", "price_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportStruct$Package.class) {
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

    public int getAssistantLimit() {
        return this.assistantLimit_;
    }

    public int getFileSize() {
        return this.fileSize_;
    }

    public int getFilesLimit() {
        return this.filesLimit_;
    }

    public Int32Value getId() {
        Int32Value int32Value = this.id_;
        return int32Value == null ? Int32Value.getDefaultInstance() : int32Value;
    }

    public String getPackageName() {
        return this.packageName_;
    }

    public AbstractC2383g getPackageNameBytes() {
        return AbstractC2383g.N(this.packageName_);
    }

    public int getPhosphorus() {
        return this.phosphorus_;
    }

    public int getPrice() {
        return this.price_;
    }

    public int getTimeLimit() {
        return this.timeLimit_;
    }

    public boolean hasId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SmartSupportStruct$Package smartSupportStruct$Package) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportStruct$Package);
    }

    public static SmartSupportStruct$Package parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportStruct$Package) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportStruct$Package parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportStruct$Package) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportStruct$Package parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportStruct$Package) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportStruct$Package parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportStruct$Package) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportStruct$Package parseFrom(byte[] bArr) {
        return (SmartSupportStruct$Package) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportStruct$Package parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportStruct$Package) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportStruct$Package parseFrom(InputStream inputStream) {
        return (SmartSupportStruct$Package) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportStruct$Package parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportStruct$Package) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportStruct$Package parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportStruct$Package) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportStruct$Package parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportStruct$Package) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
