package bale.smart_support.v1;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.EnumC17018mF6;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class SmartSupportOuterClass$ResponseGetDataSourceStatus extends GeneratedMessageLite implements U64 {
    private static final SmartSupportOuterClass$ResponseGetDataSourceStatus DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 1;
    private int status_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SmartSupportOuterClass$ResponseGetDataSourceStatus.DEFAULT_INSTANCE);
        }
    }

    static {
        SmartSupportOuterClass$ResponseGetDataSourceStatus smartSupportOuterClass$ResponseGetDataSourceStatus = new SmartSupportOuterClass$ResponseGetDataSourceStatus();
        DEFAULT_INSTANCE = smartSupportOuterClass$ResponseGetDataSourceStatus;
        GeneratedMessageLite.registerDefaultInstance(SmartSupportOuterClass$ResponseGetDataSourceStatus.class, smartSupportOuterClass$ResponseGetDataSourceStatus);
    }

    private SmartSupportOuterClass$ResponseGetDataSourceStatus() {
    }

    private void clearStatus() {
        this.status_ = 0;
    }

    public static SmartSupportOuterClass$ResponseGetDataSourceStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SmartSupportOuterClass$ResponseGetDataSourceStatus parseDelimitedFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseGetDataSourceStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseGetDataSourceStatus parseFrom(ByteBuffer byteBuffer) {
        return (SmartSupportOuterClass$ResponseGetDataSourceStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setStatus(EnumC17018mF6 enumC17018mF6) {
        this.status_ = enumC17018mF6.getNumber();
    }

    private void setStatusValue(int i) {
        this.status_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (b.a[gVar.ordinal()]) {
            case 1:
                return new SmartSupportOuterClass$ResponseGetDataSourceStatus();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SmartSupportOuterClass$ResponseGetDataSourceStatus.class) {
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

    public EnumC17018mF6 getStatus() {
        EnumC17018mF6 enumC17018mF6J = EnumC17018mF6.j(this.status_);
        return enumC17018mF6J == null ? EnumC17018mF6.UNRECOGNIZED : enumC17018mF6J;
    }

    public int getStatusValue() {
        return this.status_;
    }

    public static a newBuilder(SmartSupportOuterClass$ResponseGetDataSourceStatus smartSupportOuterClass$ResponseGetDataSourceStatus) {
        return (a) DEFAULT_INSTANCE.createBuilder(smartSupportOuterClass$ResponseGetDataSourceStatus);
    }

    public static SmartSupportOuterClass$ResponseGetDataSourceStatus parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetDataSourceStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetDataSourceStatus parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetDataSourceStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetDataSourceStatus parseFrom(AbstractC2383g abstractC2383g) {
        return (SmartSupportOuterClass$ResponseGetDataSourceStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SmartSupportOuterClass$ResponseGetDataSourceStatus parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetDataSourceStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetDataSourceStatus parseFrom(byte[] bArr) {
        return (SmartSupportOuterClass$ResponseGetDataSourceStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SmartSupportOuterClass$ResponseGetDataSourceStatus parseFrom(byte[] bArr, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetDataSourceStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetDataSourceStatus parseFrom(InputStream inputStream) {
        return (SmartSupportOuterClass$ResponseGetDataSourceStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SmartSupportOuterClass$ResponseGetDataSourceStatus parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetDataSourceStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SmartSupportOuterClass$ResponseGetDataSourceStatus parseFrom(AbstractC2384h abstractC2384h) {
        return (SmartSupportOuterClass$ResponseGetDataSourceStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SmartSupportOuterClass$ResponseGetDataSourceStatus parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SmartSupportOuterClass$ResponseGetDataSourceStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
