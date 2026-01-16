package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18499ol6;
import ir.nasim.KW4;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SefteStruct$CityInfo extends GeneratedMessageLite implements InterfaceC18499ol6 {
    public static final int CODE_FIELD_NUMBER = 2;
    private static final SefteStruct$CityInfo DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int code_;
    private String name_ = "";

    public static final class a extends GeneratedMessageLite.b implements InterfaceC18499ol6 {
        private a() {
            super(SefteStruct$CityInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        SefteStruct$CityInfo sefteStruct$CityInfo = new SefteStruct$CityInfo();
        DEFAULT_INSTANCE = sefteStruct$CityInfo;
        GeneratedMessageLite.registerDefaultInstance(SefteStruct$CityInfo.class, sefteStruct$CityInfo);
    }

    private SefteStruct$CityInfo() {
    }

    private void clearCode() {
        this.code_ = 0;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    public static SefteStruct$CityInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SefteStruct$CityInfo parseDelimitedFrom(InputStream inputStream) {
        return (SefteStruct$CityInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteStruct$CityInfo parseFrom(ByteBuffer byteBuffer) {
        return (SefteStruct$CityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCode(int i) {
        this.code_ = i;
    }

    private void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Q1.a[gVar.ordinal()]) {
            case 1:
                return new SefteStruct$CityInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0004", new Object[]{"name_", "code_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SefteStruct$CityInfo.class) {
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

    public int getCode() {
        return this.code_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public static a newBuilder(SefteStruct$CityInfo sefteStruct$CityInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(sefteStruct$CityInfo);
    }

    public static SefteStruct$CityInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteStruct$CityInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteStruct$CityInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SefteStruct$CityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SefteStruct$CityInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (SefteStruct$CityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SefteStruct$CityInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SefteStruct$CityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SefteStruct$CityInfo parseFrom(byte[] bArr) {
        return (SefteStruct$CityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SefteStruct$CityInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (SefteStruct$CityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SefteStruct$CityInfo parseFrom(InputStream inputStream) {
        return (SefteStruct$CityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SefteStruct$CityInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SefteStruct$CityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SefteStruct$CityInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (SefteStruct$CityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SefteStruct$CityInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SefteStruct$CityInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
