package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GarsonOuterClass$RequestGetServices extends GeneratedMessageLite implements U64 {
    private static final GarsonOuterClass$RequestGetServices DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int version_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(int i) {
            q();
            ((GarsonOuterClass$RequestGetServices) this.b).setVersion(i);
            return this;
        }

        private a() {
            super(GarsonOuterClass$RequestGetServices.DEFAULT_INSTANCE);
        }
    }

    static {
        GarsonOuterClass$RequestGetServices garsonOuterClass$RequestGetServices = new GarsonOuterClass$RequestGetServices();
        DEFAULT_INSTANCE = garsonOuterClass$RequestGetServices;
        GeneratedMessageLite.registerDefaultInstance(GarsonOuterClass$RequestGetServices.class, garsonOuterClass$RequestGetServices);
    }

    private GarsonOuterClass$RequestGetServices() {
    }

    private void clearVersion() {
        this.version_ = 0;
    }

    public static GarsonOuterClass$RequestGetServices getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GarsonOuterClass$RequestGetServices parseDelimitedFrom(InputStream inputStream) {
        return (GarsonOuterClass$RequestGetServices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$RequestGetServices parseFrom(ByteBuffer byteBuffer) {
        return (GarsonOuterClass$RequestGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1847d0.a[gVar.ordinal()]) {
            case 1:
                return new GarsonOuterClass$RequestGetServices();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GarsonOuterClass$RequestGetServices.class) {
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

    public int getVersion() {
        return this.version_;
    }

    public static a newBuilder(GarsonOuterClass$RequestGetServices garsonOuterClass$RequestGetServices) {
        return (a) DEFAULT_INSTANCE.createBuilder(garsonOuterClass$RequestGetServices);
    }

    public static GarsonOuterClass$RequestGetServices parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$RequestGetServices) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$RequestGetServices parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GarsonOuterClass$RequestGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GarsonOuterClass$RequestGetServices parseFrom(AbstractC2383g abstractC2383g) {
        return (GarsonOuterClass$RequestGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GarsonOuterClass$RequestGetServices parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GarsonOuterClass$RequestGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GarsonOuterClass$RequestGetServices parseFrom(byte[] bArr) {
        return (GarsonOuterClass$RequestGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GarsonOuterClass$RequestGetServices parseFrom(byte[] bArr, C2394s c2394s) {
        return (GarsonOuterClass$RequestGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GarsonOuterClass$RequestGetServices parseFrom(InputStream inputStream) {
        return (GarsonOuterClass$RequestGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GarsonOuterClass$RequestGetServices parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GarsonOuterClass$RequestGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GarsonOuterClass$RequestGetServices parseFrom(AbstractC2384h abstractC2384h) {
        return (GarsonOuterClass$RequestGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GarsonOuterClass$RequestGetServices parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GarsonOuterClass$RequestGetServices) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
