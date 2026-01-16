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
public final class OrganizationsOuterClass$RequestGetUserOrganizationInfo extends GeneratedMessageLite implements U64 {
    private static final OrganizationsOuterClass$RequestGetUserOrganizationInfo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(OrganizationsOuterClass$RequestGetUserOrganizationInfo.DEFAULT_INSTANCE);
        }
    }

    static {
        OrganizationsOuterClass$RequestGetUserOrganizationInfo organizationsOuterClass$RequestGetUserOrganizationInfo = new OrganizationsOuterClass$RequestGetUserOrganizationInfo();
        DEFAULT_INSTANCE = organizationsOuterClass$RequestGetUserOrganizationInfo;
        GeneratedMessageLite.registerDefaultInstance(OrganizationsOuterClass$RequestGetUserOrganizationInfo.class, organizationsOuterClass$RequestGetUserOrganizationInfo);
    }

    private OrganizationsOuterClass$RequestGetUserOrganizationInfo() {
    }

    public static OrganizationsOuterClass$RequestGetUserOrganizationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static OrganizationsOuterClass$RequestGetUserOrganizationInfo parseDelimitedFrom(InputStream inputStream) {
        return (OrganizationsOuterClass$RequestGetUserOrganizationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OrganizationsOuterClass$RequestGetUserOrganizationInfo parseFrom(ByteBuffer byteBuffer) {
        return (OrganizationsOuterClass$RequestGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (W0.a[gVar.ordinal()]) {
            case 1:
                return new OrganizationsOuterClass$RequestGetUserOrganizationInfo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (OrganizationsOuterClass$RequestGetUserOrganizationInfo.class) {
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

    public static a newBuilder(OrganizationsOuterClass$RequestGetUserOrganizationInfo organizationsOuterClass$RequestGetUserOrganizationInfo) {
        return (a) DEFAULT_INSTANCE.createBuilder(organizationsOuterClass$RequestGetUserOrganizationInfo);
    }

    public static OrganizationsOuterClass$RequestGetUserOrganizationInfo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (OrganizationsOuterClass$RequestGetUserOrganizationInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OrganizationsOuterClass$RequestGetUserOrganizationInfo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (OrganizationsOuterClass$RequestGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static OrganizationsOuterClass$RequestGetUserOrganizationInfo parseFrom(AbstractC2383g abstractC2383g) {
        return (OrganizationsOuterClass$RequestGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static OrganizationsOuterClass$RequestGetUserOrganizationInfo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (OrganizationsOuterClass$RequestGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static OrganizationsOuterClass$RequestGetUserOrganizationInfo parseFrom(byte[] bArr) {
        return (OrganizationsOuterClass$RequestGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OrganizationsOuterClass$RequestGetUserOrganizationInfo parseFrom(byte[] bArr, C2394s c2394s) {
        return (OrganizationsOuterClass$RequestGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static OrganizationsOuterClass$RequestGetUserOrganizationInfo parseFrom(InputStream inputStream) {
        return (OrganizationsOuterClass$RequestGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OrganizationsOuterClass$RequestGetUserOrganizationInfo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (OrganizationsOuterClass$RequestGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static OrganizationsOuterClass$RequestGetUserOrganizationInfo parseFrom(AbstractC2384h abstractC2384h) {
        return (OrganizationsOuterClass$RequestGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static OrganizationsOuterClass$RequestGetUserOrganizationInfo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (OrganizationsOuterClass$RequestGetUserOrganizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
