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
public final class Arbainexchange$ResponseHasAccess extends GeneratedMessageLite implements U64 {
    public static final int ACCESS_FIELD_NUMBER = 1;
    private static final Arbainexchange$ResponseHasAccess DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private boolean access_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(Arbainexchange$ResponseHasAccess.DEFAULT_INSTANCE);
        }
    }

    static {
        Arbainexchange$ResponseHasAccess arbainexchange$ResponseHasAccess = new Arbainexchange$ResponseHasAccess();
        DEFAULT_INSTANCE = arbainexchange$ResponseHasAccess;
        GeneratedMessageLite.registerDefaultInstance(Arbainexchange$ResponseHasAccess.class, arbainexchange$ResponseHasAccess);
    }

    private Arbainexchange$ResponseHasAccess() {
    }

    private void clearAccess() {
        this.access_ = false;
    }

    public static Arbainexchange$ResponseHasAccess getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Arbainexchange$ResponseHasAccess parseDelimitedFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseHasAccess) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseHasAccess parseFrom(ByteBuffer byteBuffer) {
        return (Arbainexchange$ResponseHasAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAccess(boolean z) {
        this.access_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1861i.a[gVar.ordinal()]) {
            case 1:
                return new Arbainexchange$ResponseHasAccess();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007", new Object[]{"access_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Arbainexchange$ResponseHasAccess.class) {
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

    public boolean getAccess() {
        return this.access_;
    }

    public static a newBuilder(Arbainexchange$ResponseHasAccess arbainexchange$ResponseHasAccess) {
        return (a) DEFAULT_INSTANCE.createBuilder(arbainexchange$ResponseHasAccess);
    }

    public static Arbainexchange$ResponseHasAccess parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseHasAccess) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseHasAccess parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Arbainexchange$ResponseHasAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Arbainexchange$ResponseHasAccess parseFrom(AbstractC2383g abstractC2383g) {
        return (Arbainexchange$ResponseHasAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Arbainexchange$ResponseHasAccess parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Arbainexchange$ResponseHasAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Arbainexchange$ResponseHasAccess parseFrom(byte[] bArr) {
        return (Arbainexchange$ResponseHasAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Arbainexchange$ResponseHasAccess parseFrom(byte[] bArr, C2394s c2394s) {
        return (Arbainexchange$ResponseHasAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Arbainexchange$ResponseHasAccess parseFrom(InputStream inputStream) {
        return (Arbainexchange$ResponseHasAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Arbainexchange$ResponseHasAccess parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Arbainexchange$ResponseHasAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Arbainexchange$ResponseHasAccess parseFrom(AbstractC2384h abstractC2384h) {
        return (Arbainexchange$ResponseHasAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Arbainexchange$ResponseHasAccess parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Arbainexchange$ResponseHasAccess) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
