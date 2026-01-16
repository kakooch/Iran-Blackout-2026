package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class SafirOuterClass$RequestGetOrganizationOwner extends GeneratedMessageLite implements U64 {
    private static final SafirOuterClass$RequestGetOrganizationOwner DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SAFIR_BOT_ID_FIELD_NUMBER = 1;
    private int safirBotId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirOuterClass$RequestGetOrganizationOwner.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirOuterClass$RequestGetOrganizationOwner safirOuterClass$RequestGetOrganizationOwner = new SafirOuterClass$RequestGetOrganizationOwner();
        DEFAULT_INSTANCE = safirOuterClass$RequestGetOrganizationOwner;
        GeneratedMessageLite.registerDefaultInstance(SafirOuterClass$RequestGetOrganizationOwner.class, safirOuterClass$RequestGetOrganizationOwner);
    }

    private SafirOuterClass$RequestGetOrganizationOwner() {
    }

    private void clearSafirBotId() {
        this.safirBotId_ = 0;
    }

    public static SafirOuterClass$RequestGetOrganizationOwner getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirOuterClass$RequestGetOrganizationOwner parseDelimitedFrom(InputStream inputStream) {
        return (SafirOuterClass$RequestGetOrganizationOwner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirOuterClass$RequestGetOrganizationOwner parseFrom(ByteBuffer byteBuffer) {
        return (SafirOuterClass$RequestGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSafirBotId(int i) {
        this.safirBotId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E1.a[gVar.ordinal()]) {
            case 1:
                return new SafirOuterClass$RequestGetOrganizationOwner();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"safirBotId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirOuterClass$RequestGetOrganizationOwner.class) {
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

    public int getSafirBotId() {
        return this.safirBotId_;
    }

    public static a newBuilder(SafirOuterClass$RequestGetOrganizationOwner safirOuterClass$RequestGetOrganizationOwner) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirOuterClass$RequestGetOrganizationOwner);
    }

    public static SafirOuterClass$RequestGetOrganizationOwner parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirOuterClass$RequestGetOrganizationOwner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirOuterClass$RequestGetOrganizationOwner parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirOuterClass$RequestGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirOuterClass$RequestGetOrganizationOwner parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirOuterClass$RequestGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirOuterClass$RequestGetOrganizationOwner parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirOuterClass$RequestGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirOuterClass$RequestGetOrganizationOwner parseFrom(byte[] bArr) {
        return (SafirOuterClass$RequestGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirOuterClass$RequestGetOrganizationOwner parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirOuterClass$RequestGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirOuterClass$RequestGetOrganizationOwner parseFrom(InputStream inputStream) {
        return (SafirOuterClass$RequestGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirOuterClass$RequestGetOrganizationOwner parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirOuterClass$RequestGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirOuterClass$RequestGetOrganizationOwner parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirOuterClass$RequestGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirOuterClass$RequestGetOrganizationOwner parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirOuterClass$RequestGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
