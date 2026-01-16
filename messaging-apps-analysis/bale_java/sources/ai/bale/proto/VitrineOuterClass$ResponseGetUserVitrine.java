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

/* loaded from: classes.dex */
public final class VitrineOuterClass$ResponseGetUserVitrine extends GeneratedMessageLite implements U64 {
    private static final VitrineOuterClass$ResponseGetUserVitrine DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VITRINE_DATA_FIELD_NUMBER = 1;
    private String vitrineData_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineOuterClass$ResponseGetUserVitrine.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$ResponseGetUserVitrine vitrineOuterClass$ResponseGetUserVitrine = new VitrineOuterClass$ResponseGetUserVitrine();
        DEFAULT_INSTANCE = vitrineOuterClass$ResponseGetUserVitrine;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$ResponseGetUserVitrine.class, vitrineOuterClass$ResponseGetUserVitrine);
    }

    private VitrineOuterClass$ResponseGetUserVitrine() {
    }

    private void clearVitrineData() {
        this.vitrineData_ = getDefaultInstance().getVitrineData();
    }

    public static VitrineOuterClass$ResponseGetUserVitrine getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$ResponseGetUserVitrine parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$ResponseGetUserVitrine) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$ResponseGetUserVitrine parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$ResponseGetUserVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setVitrineData(String str) {
        str.getClass();
        this.vitrineData_ = str;
    }

    private void setVitrineDataBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.vitrineData_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$ResponseGetUserVitrine();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"vitrineData_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$ResponseGetUserVitrine.class) {
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

    public String getVitrineData() {
        return this.vitrineData_;
    }

    public AbstractC2383g getVitrineDataBytes() {
        return AbstractC2383g.N(this.vitrineData_);
    }

    public static a newBuilder(VitrineOuterClass$ResponseGetUserVitrine vitrineOuterClass$ResponseGetUserVitrine) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$ResponseGetUserVitrine);
    }

    public static VitrineOuterClass$ResponseGetUserVitrine parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetUserVitrine) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$ResponseGetUserVitrine parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetUserVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$ResponseGetUserVitrine parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$ResponseGetUserVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineOuterClass$ResponseGetUserVitrine parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetUserVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$ResponseGetUserVitrine parseFrom(byte[] bArr) {
        return (VitrineOuterClass$ResponseGetUserVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$ResponseGetUserVitrine parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetUserVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$ResponseGetUserVitrine parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$ResponseGetUserVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$ResponseGetUserVitrine parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetUserVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$ResponseGetUserVitrine parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$ResponseGetUserVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$ResponseGetUserVitrine parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$ResponseGetUserVitrine) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
