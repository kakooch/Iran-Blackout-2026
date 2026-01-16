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
public final class SafirOuterClass$ResponseGetOrganizationOwner extends GeneratedMessageLite implements U64 {
    private static final SafirOuterClass$ResponseGetOrganizationOwner DEFAULT_INSTANCE;
    public static final int OWNER_USER_ID_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private int ownerUserId_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(SafirOuterClass$ResponseGetOrganizationOwner.DEFAULT_INSTANCE);
        }
    }

    static {
        SafirOuterClass$ResponseGetOrganizationOwner safirOuterClass$ResponseGetOrganizationOwner = new SafirOuterClass$ResponseGetOrganizationOwner();
        DEFAULT_INSTANCE = safirOuterClass$ResponseGetOrganizationOwner;
        GeneratedMessageLite.registerDefaultInstance(SafirOuterClass$ResponseGetOrganizationOwner.class, safirOuterClass$ResponseGetOrganizationOwner);
    }

    private SafirOuterClass$ResponseGetOrganizationOwner() {
    }

    private void clearOwnerUserId() {
        this.ownerUserId_ = 0;
    }

    public static SafirOuterClass$ResponseGetOrganizationOwner getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static SafirOuterClass$ResponseGetOrganizationOwner parseDelimitedFrom(InputStream inputStream) {
        return (SafirOuterClass$ResponseGetOrganizationOwner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirOuterClass$ResponseGetOrganizationOwner parseFrom(ByteBuffer byteBuffer) {
        return (SafirOuterClass$ResponseGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOwnerUserId(int i) {
        this.ownerUserId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (E1.a[gVar.ordinal()]) {
            case 1:
                return new SafirOuterClass$ResponseGetOrganizationOwner();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"ownerUserId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (SafirOuterClass$ResponseGetOrganizationOwner.class) {
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

    public int getOwnerUserId() {
        return this.ownerUserId_;
    }

    public static a newBuilder(SafirOuterClass$ResponseGetOrganizationOwner safirOuterClass$ResponseGetOrganizationOwner) {
        return (a) DEFAULT_INSTANCE.createBuilder(safirOuterClass$ResponseGetOrganizationOwner);
    }

    public static SafirOuterClass$ResponseGetOrganizationOwner parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirOuterClass$ResponseGetOrganizationOwner) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirOuterClass$ResponseGetOrganizationOwner parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (SafirOuterClass$ResponseGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static SafirOuterClass$ResponseGetOrganizationOwner parseFrom(AbstractC2383g abstractC2383g) {
        return (SafirOuterClass$ResponseGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static SafirOuterClass$ResponseGetOrganizationOwner parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (SafirOuterClass$ResponseGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static SafirOuterClass$ResponseGetOrganizationOwner parseFrom(byte[] bArr) {
        return (SafirOuterClass$ResponseGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SafirOuterClass$ResponseGetOrganizationOwner parseFrom(byte[] bArr, C2394s c2394s) {
        return (SafirOuterClass$ResponseGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static SafirOuterClass$ResponseGetOrganizationOwner parseFrom(InputStream inputStream) {
        return (SafirOuterClass$ResponseGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SafirOuterClass$ResponseGetOrganizationOwner parseFrom(InputStream inputStream, C2394s c2394s) {
        return (SafirOuterClass$ResponseGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static SafirOuterClass$ResponseGetOrganizationOwner parseFrom(AbstractC2384h abstractC2384h) {
        return (SafirOuterClass$ResponseGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static SafirOuterClass$ResponseGetOrganizationOwner parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (SafirOuterClass$ResponseGetOrganizationOwner) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
