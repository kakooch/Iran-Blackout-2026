package bale.smart_support.v1;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportAdminOuterClass$RequestDeactivatePackages extends GeneratedMessageLite implements U64 {
    private static final SmartSupportAdminOuterClass$RequestDeactivatePackages DEFAULT_INSTANCE;
    public static final int PACKAGE_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int packageId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportAdminOuterClass$RequestDeactivatePackages.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportAdminOuterClass$RequestDeactivatePackages smartSupportAdminOuterClass$RequestDeactivatePackages = new SmartSupportAdminOuterClass$RequestDeactivatePackages();
        DEFAULT_INSTANCE = smartSupportAdminOuterClass$RequestDeactivatePackages;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportAdminOuterClass$RequestDeactivatePackages.class, smartSupportAdminOuterClass$RequestDeactivatePackages);
    }

    private SmartSupportAdminOuterClass$RequestDeactivatePackages() {
    }

    private void clearPackageId() {
        this.packageId_ = 0;
    }

    public static SmartSupportAdminOuterClass$RequestDeactivatePackages getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportAdminOuterClass$RequestDeactivatePackages parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportAdminOuterClass$RequestDeactivatePackages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportAdminOuterClass$RequestDeactivatePackages parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportAdminOuterClass$RequestDeactivatePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPackageId(int i) {
        this.packageId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (bale.smart_support.v1.a.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportAdminOuterClass$RequestDeactivatePackages();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"packageId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportAdminOuterClass$RequestDeactivatePackages.class) {
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

    public int getPackageId() {
        return this.packageId_;
    }

    public static a newBuilder(SmartSupportAdminOuterClass$RequestDeactivatePackages smartSupportAdminOuterClass$RequestDeactivatePackages) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportAdminOuterClass$RequestDeactivatePackages);
    }

    public static SmartSupportAdminOuterClass$RequestDeactivatePackages parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestDeactivatePackages) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestDeactivatePackages parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestDeactivatePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestDeactivatePackages parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportAdminOuterClass$RequestDeactivatePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportAdminOuterClass$RequestDeactivatePackages parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestDeactivatePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestDeactivatePackages parseFrom(byte[] bArr) {
        return (SmartSupportAdminOuterClass$RequestDeactivatePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportAdminOuterClass$RequestDeactivatePackages parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestDeactivatePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestDeactivatePackages parseFrom(InputStream inputStream) {
        return (SmartSupportAdminOuterClass$RequestDeactivatePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportAdminOuterClass$RequestDeactivatePackages parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestDeactivatePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestDeactivatePackages parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportAdminOuterClass$RequestDeactivatePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportAdminOuterClass$RequestDeactivatePackages parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestDeactivatePackages) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
