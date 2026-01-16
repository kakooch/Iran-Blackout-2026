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
public final class VitrineOuterClass$UpdateVitrineChanged extends GeneratedMessageLite implements U64 {
    private static final VitrineOuterClass$UpdateVitrineChanged DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private String version_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(VitrineOuterClass$UpdateVitrineChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        VitrineOuterClass$UpdateVitrineChanged vitrineOuterClass$UpdateVitrineChanged = new VitrineOuterClass$UpdateVitrineChanged();
        DEFAULT_INSTANCE = vitrineOuterClass$UpdateVitrineChanged;
        GeneratedMessageLite.registerDefaultInstance(VitrineOuterClass$UpdateVitrineChanged.class, vitrineOuterClass$UpdateVitrineChanged);
    }

    private VitrineOuterClass$UpdateVitrineChanged() {
    }

    private void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    public static VitrineOuterClass$UpdateVitrineChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static VitrineOuterClass$UpdateVitrineChanged parseDelimitedFrom(InputStream inputStream) {
        return (VitrineOuterClass$UpdateVitrineChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$UpdateVitrineChanged parseFrom(ByteBuffer byteBuffer) {
        return (VitrineOuterClass$UpdateVitrineChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setVersion(String str) {
        str.getClass();
        this.version_ = str;
    }

    private void setVersionBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.version_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (r2.a[gVar.ordinal()]) {
            case 1:
                return new VitrineOuterClass$UpdateVitrineChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (VitrineOuterClass$UpdateVitrineChanged.class) {
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

    public String getVersion() {
        return this.version_;
    }

    public AbstractC2383g getVersionBytes() {
        return AbstractC2383g.N(this.version_);
    }

    public static a newBuilder(VitrineOuterClass$UpdateVitrineChanged vitrineOuterClass$UpdateVitrineChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(vitrineOuterClass$UpdateVitrineChanged);
    }

    public static VitrineOuterClass$UpdateVitrineChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$UpdateVitrineChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$UpdateVitrineChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (VitrineOuterClass$UpdateVitrineChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static VitrineOuterClass$UpdateVitrineChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (VitrineOuterClass$UpdateVitrineChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static VitrineOuterClass$UpdateVitrineChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (VitrineOuterClass$UpdateVitrineChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static VitrineOuterClass$UpdateVitrineChanged parseFrom(byte[] bArr) {
        return (VitrineOuterClass$UpdateVitrineChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static VitrineOuterClass$UpdateVitrineChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (VitrineOuterClass$UpdateVitrineChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static VitrineOuterClass$UpdateVitrineChanged parseFrom(InputStream inputStream) {
        return (VitrineOuterClass$UpdateVitrineChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static VitrineOuterClass$UpdateVitrineChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (VitrineOuterClass$UpdateVitrineChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static VitrineOuterClass$UpdateVitrineChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (VitrineOuterClass$UpdateVitrineChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static VitrineOuterClass$UpdateVitrineChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (VitrineOuterClass$UpdateVitrineChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
