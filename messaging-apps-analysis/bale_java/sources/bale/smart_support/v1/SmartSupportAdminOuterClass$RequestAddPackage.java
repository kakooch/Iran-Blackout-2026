package bale.smart_support.v1;

import bale.smart_support.v1.SmartSupportStruct$Package;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportAdminOuterClass$RequestAddPackage extends GeneratedMessageLite implements U64 {
    private static final SmartSupportAdminOuterClass$RequestAddPackage DEFAULT_INSTANCE;
    public static final int PACKAGE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int bitField0_;
    private SmartSupportStruct$Package package_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportAdminOuterClass$RequestAddPackage.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportAdminOuterClass$RequestAddPackage smartSupportAdminOuterClass$RequestAddPackage = new SmartSupportAdminOuterClass$RequestAddPackage();
        DEFAULT_INSTANCE = smartSupportAdminOuterClass$RequestAddPackage;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportAdminOuterClass$RequestAddPackage.class, smartSupportAdminOuterClass$RequestAddPackage);
    }

    private SmartSupportAdminOuterClass$RequestAddPackage() {
    }

    private void clearPackage() {
        this.package_ = null;
        this.bitField0_ &= -2;
    }

    public static SmartSupportAdminOuterClass$RequestAddPackage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePackage(SmartSupportStruct$Package smartSupportStruct$Package) {
        smartSupportStruct$Package.getClass();
        SmartSupportStruct$Package smartSupportStruct$Package2 = this.package_;
        if (smartSupportStruct$Package2 == null || smartSupportStruct$Package2 == SmartSupportStruct$Package.getDefaultInstance()) {
            this.package_ = smartSupportStruct$Package;
        } else {
            this.package_ = (SmartSupportStruct$Package) ((SmartSupportStruct$Package.a) SmartSupportStruct$Package.newBuilder(this.package_).v(smartSupportStruct$Package)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportAdminOuterClass$RequestAddPackage parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportAdminOuterClass$RequestAddPackage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportAdminOuterClass$RequestAddPackage parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportAdminOuterClass$RequestAddPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPackage(SmartSupportStruct$Package smartSupportStruct$Package) {
        smartSupportStruct$Package.getClass();
        this.package_ = smartSupportStruct$Package;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (bale.smart_support.v1.a.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportAdminOuterClass$RequestAddPackage();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "package_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportAdminOuterClass$RequestAddPackage.class) {
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

    public SmartSupportStruct$Package getPackage() {
        SmartSupportStruct$Package smartSupportStruct$Package = this.package_;
        return smartSupportStruct$Package == null ? SmartSupportStruct$Package.getDefaultInstance() : smartSupportStruct$Package;
    }

    public boolean hasPackage() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(SmartSupportAdminOuterClass$RequestAddPackage smartSupportAdminOuterClass$RequestAddPackage) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportAdminOuterClass$RequestAddPackage);
    }

    public static SmartSupportAdminOuterClass$RequestAddPackage parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestAddPackage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestAddPackage parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestAddPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestAddPackage parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportAdminOuterClass$RequestAddPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportAdminOuterClass$RequestAddPackage parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestAddPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestAddPackage parseFrom(byte[] bArr) {
        return (SmartSupportAdminOuterClass$RequestAddPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportAdminOuterClass$RequestAddPackage parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestAddPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestAddPackage parseFrom(InputStream inputStream) {
        return (SmartSupportAdminOuterClass$RequestAddPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportAdminOuterClass$RequestAddPackage parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestAddPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportAdminOuterClass$RequestAddPackage parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportAdminOuterClass$RequestAddPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportAdminOuterClass$RequestAddPackage parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportAdminOuterClass$RequestAddPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
