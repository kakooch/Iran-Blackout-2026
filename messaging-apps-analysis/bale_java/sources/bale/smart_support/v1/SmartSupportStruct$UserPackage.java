package bale.smart_support.v1;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC23635xF6;
import ir.nasim.InterfaceC23045wF6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportStruct$UserPackage extends GeneratedMessageLite implements InterfaceC23045wF6 {
    public static final int ASSISTANT_LIMIT_FIELD_NUMBER = 9;
    public static final int CREATED_AT_FIELD_NUMBER = 3;
    private static final SmartSupportStruct$UserPackage DEFAULT_INSTANCE;
    public static final int EXPIRE_TIME_FIELD_NUMBER = 4;
    public static final int FILES_LIMIT_FIELD_NUMBER = 10;
    public static final int FILE_CAPACITY_LIMIT_FIELD_NUMBER = 11;
    public static final int PACKAGE_ID_FIELD_NUMBER = 1;
    public static final int PACKAGE_NAME_FIELD_NUMBER = 12;
    private static volatile KW4 PARSER = null;
    public static final int REMAINING_DAYS_FIELD_NUMBER = 6;
    public static final int REMAINING_PHOSPHORUS_FIELD_NUMBER = 8;
    public static final int STATUS_FIELD_NUMBER = 2;
    public static final int TOTAL_DAYS_FIELD_NUMBER = 5;
    public static final int TOTAL_PHOSPHORUS_FIELD_NUMBER = 7;
    private int assistantLimit_;
    private long createdAt_;
    private long expireTime_;
    private int fileCapacityLimit_;
    private int filesLimit_;
    private int packageId_;
    private String packageName_ = "";
    private int remainingDays_;
    private float remainingPhosphorus_;
    private int status_;
    private int totalDays_;
    private int totalPhosphorus_;

    public static final class a extends GeneratedMessageLite.b implements InterfaceC23045wF6 {
        private a() {
            super(SmartSupportStruct$UserPackage.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportStruct$UserPackage smartSupportStruct$UserPackage = new SmartSupportStruct$UserPackage();
        DEFAULT_INSTANCE = smartSupportStruct$UserPackage;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportStruct$UserPackage.class, smartSupportStruct$UserPackage);
    }

    private SmartSupportStruct$UserPackage() {
    }

    private void clearAssistantLimit() {
        this.assistantLimit_ = 0;
    }

    private void clearCreatedAt() {
        this.createdAt_ = 0L;
    }

    private void clearExpireTime() {
        this.expireTime_ = 0L;
    }

    private void clearFileCapacityLimit() {
        this.fileCapacityLimit_ = 0;
    }

    private void clearFilesLimit() {
        this.filesLimit_ = 0;
    }

    private void clearPackageId() {
        this.packageId_ = 0;
    }

    private void clearPackageName() {
        this.packageName_ = getDefaultInstance().getPackageName();
    }

    private void clearRemainingDays() {
        this.remainingDays_ = 0;
    }

    private void clearRemainingPhosphorus() {
        this.remainingPhosphorus_ = 0.0f;
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    private void clearTotalDays() {
        this.totalDays_ = 0;
    }

    private void clearTotalPhosphorus() {
        this.totalPhosphorus_ = 0;
    }

    public static SmartSupportStruct$UserPackage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportStruct$UserPackage parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportStruct$UserPackage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportStruct$UserPackage parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportStruct$UserPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAssistantLimit(int i) {
        this.assistantLimit_ = i;
    }

    private void setCreatedAt(long j) {
        this.createdAt_ = j;
    }

    private void setExpireTime(long j) {
        this.expireTime_ = j;
    }

    private void setFileCapacityLimit(int i) {
        this.fileCapacityLimit_ = i;
    }

    private void setFilesLimit(int i) {
        this.filesLimit_ = i;
    }

    private void setPackageId(int i) {
        this.packageId_ = i;
    }

    private void setPackageName(String str) {
        str.getClass();
        this.packageName_ = str;
    }

    private void setPackageNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.packageName_ = abstractC2383g.f0();
    }

    private void setRemainingDays(int i) {
        this.remainingDays_ = i;
    }

    private void setRemainingPhosphorus(float f) {
        this.remainingPhosphorus_ = f;
    }

    private void setStatus(EnumC23635xF6 enumC23635xF6) {
        this.status_ = enumC23635xF6.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    private void setTotalDays(int i) {
        this.totalDays_ = i;
    }

    private void setTotalPhosphorus(int i) {
        this.totalPhosphorus_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (c.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportStruct$UserPackage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0000\u0001\f\f\u0000\u0000\u0000\u0001\u0004\u0002\f\u0003\u0002\u0004\u0002\u0005\u0004\u0006\u0004\u0007\u0004\b\u0001\t\u0004\n\u0004\u000b\u0004\fȈ", new Object[]{"packageId_", "status_", "createdAt_", "expireTime_", "totalDays_", "remainingDays_", "totalPhosphorus_", "remainingPhosphorus_", "assistantLimit_", "filesLimit_", "fileCapacityLimit_", "packageName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportStruct$UserPackage.class) {
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

    public long getCreatedAt() {
        return this.createdAt_;
    }

    public long getExpireTime() {
        return this.expireTime_;
    }

    public int getFileCapacityLimit() {
        return this.fileCapacityLimit_;
    }

    public int getFilesLimit() {
        return this.filesLimit_;
    }

    public int getPackageId() {
        return this.packageId_;
    }

    public String getPackageName() {
        return this.packageName_;
    }

    public AbstractC2383g getPackageNameBytes() {
        return AbstractC2383g.N(this.packageName_);
    }

    public int getRemainingDays() {
        return this.remainingDays_;
    }

    public float getRemainingPhosphorus() {
        return this.remainingPhosphorus_;
    }

    public EnumC23635xF6 getStatus() {
        EnumC23635xF6 enumC23635xF6J = EnumC23635xF6.j(this.status_);
        return enumC23635xF6J == null ? EnumC23635xF6.UNRECOGNIZED : enumC23635xF6J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public int getTotalDays() {
        return this.totalDays_;
    }

    public int getTotalPhosphorus() {
        return this.totalPhosphorus_;
    }

    public static a newBuilder(SmartSupportStruct$UserPackage smartSupportStruct$UserPackage) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportStruct$UserPackage);
    }

    public static SmartSupportStruct$UserPackage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportStruct$UserPackage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportStruct$UserPackage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportStruct$UserPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportStruct$UserPackage parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportStruct$UserPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportStruct$UserPackage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportStruct$UserPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportStruct$UserPackage parseFrom(byte[] bArr) {
        return (SmartSupportStruct$UserPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportStruct$UserPackage parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportStruct$UserPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportStruct$UserPackage parseFrom(InputStream inputStream) {
        return (SmartSupportStruct$UserPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportStruct$UserPackage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportStruct$UserPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportStruct$UserPackage parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportStruct$UserPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportStruct$UserPackage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportStruct$UserPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
