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
public final class PfmOuterClass$RequestGetUserAccounts extends GeneratedMessageLite implements U64 {
    private static final PfmOuterClass$RequestGetUserAccounts DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PfmOuterClass$RequestGetUserAccounts.DEFAULT_INSTANCE);
        }
    }

    static {
        PfmOuterClass$RequestGetUserAccounts pfmOuterClass$RequestGetUserAccounts = new PfmOuterClass$RequestGetUserAccounts();
        DEFAULT_INSTANCE = pfmOuterClass$RequestGetUserAccounts;
        GeneratedMessageLite.registerDefaultInstance(PfmOuterClass$RequestGetUserAccounts.class, pfmOuterClass$RequestGetUserAccounts);
    }

    private PfmOuterClass$RequestGetUserAccounts() {
    }

    public static PfmOuterClass$RequestGetUserAccounts getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PfmOuterClass$RequestGetUserAccounts parseDelimitedFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestGetUserAccounts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestGetUserAccounts parseFrom(ByteBuffer byteBuffer) {
        return (PfmOuterClass$RequestGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1848d1.a[gVar.ordinal()]) {
            case 1:
                return new PfmOuterClass$RequestGetUserAccounts();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PfmOuterClass$RequestGetUserAccounts.class) {
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

    public static a newBuilder(PfmOuterClass$RequestGetUserAccounts pfmOuterClass$RequestGetUserAccounts) {
        return (a) DEFAULT_INSTANCE.createBuilder(pfmOuterClass$RequestGetUserAccounts);
    }

    public static PfmOuterClass$RequestGetUserAccounts parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestGetUserAccounts) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestGetUserAccounts parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PfmOuterClass$RequestGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PfmOuterClass$RequestGetUserAccounts parseFrom(AbstractC2383g abstractC2383g) {
        return (PfmOuterClass$RequestGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static PfmOuterClass$RequestGetUserAccounts parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PfmOuterClass$RequestGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PfmOuterClass$RequestGetUserAccounts parseFrom(byte[] bArr) {
        return (PfmOuterClass$RequestGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PfmOuterClass$RequestGetUserAccounts parseFrom(byte[] bArr, C2394s c2394s) {
        return (PfmOuterClass$RequestGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PfmOuterClass$RequestGetUserAccounts parseFrom(InputStream inputStream) {
        return (PfmOuterClass$RequestGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PfmOuterClass$RequestGetUserAccounts parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PfmOuterClass$RequestGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PfmOuterClass$RequestGetUserAccounts parseFrom(AbstractC2384h abstractC2384h) {
        return (PfmOuterClass$RequestGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PfmOuterClass$RequestGetUserAccounts parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PfmOuterClass$RequestGetUserAccounts) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
