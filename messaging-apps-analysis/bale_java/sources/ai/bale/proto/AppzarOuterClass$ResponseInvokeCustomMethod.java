package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class AppzarOuterClass$ResponseInvokeCustomMethod extends GeneratedMessageLite implements U64 {
    public static final int DATA_FIELD_NUMBER = 4;
    private static final AppzarOuterClass$ResponseInvokeCustomMethod DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private String data_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(AppzarOuterClass$ResponseInvokeCustomMethod.DEFAULT_INSTANCE);
        }
    }

    static {
        AppzarOuterClass$ResponseInvokeCustomMethod appzarOuterClass$ResponseInvokeCustomMethod = new AppzarOuterClass$ResponseInvokeCustomMethod();
        DEFAULT_INSTANCE = appzarOuterClass$ResponseInvokeCustomMethod;
        GeneratedMessageLite.registerDefaultInstance(AppzarOuterClass$ResponseInvokeCustomMethod.class, appzarOuterClass$ResponseInvokeCustomMethod);
    }

    private AppzarOuterClass$ResponseInvokeCustomMethod() {
    }

    private void clearData() {
        this.data_ = getDefaultInstance().getData();
    }

    public static AppzarOuterClass$ResponseInvokeCustomMethod getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static AppzarOuterClass$ResponseInvokeCustomMethod parseDelimitedFrom(InputStream inputStream) {
        return (AppzarOuterClass$ResponseInvokeCustomMethod) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarOuterClass$ResponseInvokeCustomMethod parseFrom(ByteBuffer byteBuffer) {
        return (AppzarOuterClass$ResponseInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setData(String str) {
        str.getClass();
        this.data_ = str;
    }

    private void setDataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.data_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1855g.a[gVar.ordinal()]) {
            case 1:
                return new AppzarOuterClass$ResponseInvokeCustomMethod();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0004\u0004\u0001\u0000\u0000\u0000\u0004Ȉ", new Object[]{"data_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (AppzarOuterClass$ResponseInvokeCustomMethod.class) {
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

    public String getData() {
        return this.data_;
    }

    public AbstractC2383g getDataBytes() {
        return AbstractC2383g.N(this.data_);
    }

    public static a newBuilder(AppzarOuterClass$ResponseInvokeCustomMethod appzarOuterClass$ResponseInvokeCustomMethod) {
        return (a) DEFAULT_INSTANCE.createBuilder(appzarOuterClass$ResponseInvokeCustomMethod);
    }

    public static AppzarOuterClass$ResponseInvokeCustomMethod parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarOuterClass$ResponseInvokeCustomMethod) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarOuterClass$ResponseInvokeCustomMethod parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (AppzarOuterClass$ResponseInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static AppzarOuterClass$ResponseInvokeCustomMethod parseFrom(AbstractC2383g abstractC2383g) {
        return (AppzarOuterClass$ResponseInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static AppzarOuterClass$ResponseInvokeCustomMethod parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (AppzarOuterClass$ResponseInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static AppzarOuterClass$ResponseInvokeCustomMethod parseFrom(byte[] bArr) {
        return (AppzarOuterClass$ResponseInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AppzarOuterClass$ResponseInvokeCustomMethod parseFrom(byte[] bArr, C2394s c2394s) {
        return (AppzarOuterClass$ResponseInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static AppzarOuterClass$ResponseInvokeCustomMethod parseFrom(InputStream inputStream) {
        return (AppzarOuterClass$ResponseInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AppzarOuterClass$ResponseInvokeCustomMethod parseFrom(InputStream inputStream, C2394s c2394s) {
        return (AppzarOuterClass$ResponseInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static AppzarOuterClass$ResponseInvokeCustomMethod parseFrom(AbstractC2384h abstractC2384h) {
        return (AppzarOuterClass$ResponseInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static AppzarOuterClass$ResponseInvokeCustomMethod parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (AppzarOuterClass$ResponseInvokeCustomMethod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
