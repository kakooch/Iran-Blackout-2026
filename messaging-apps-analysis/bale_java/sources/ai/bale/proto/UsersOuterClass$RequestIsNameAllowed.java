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
public final class UsersOuterClass$RequestIsNameAllowed extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$RequestIsNameAllowed DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private String name_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$RequestIsNameAllowed.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestIsNameAllowed usersOuterClass$RequestIsNameAllowed = new UsersOuterClass$RequestIsNameAllowed();
        DEFAULT_INSTANCE = usersOuterClass$RequestIsNameAllowed;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestIsNameAllowed.class, usersOuterClass$RequestIsNameAllowed);
    }

    private UsersOuterClass$RequestIsNameAllowed() {
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    public static UsersOuterClass$RequestIsNameAllowed getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestIsNameAllowed parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestIsNameAllowed) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestIsNameAllowed parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestIsNameAllowed) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
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
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestIsNameAllowed();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"name_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestIsNameAllowed.class) {
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

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public static a newBuilder(UsersOuterClass$RequestIsNameAllowed usersOuterClass$RequestIsNameAllowed) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestIsNameAllowed);
    }

    public static UsersOuterClass$RequestIsNameAllowed parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestIsNameAllowed) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestIsNameAllowed parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestIsNameAllowed) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestIsNameAllowed parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestIsNameAllowed) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestIsNameAllowed parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestIsNameAllowed) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestIsNameAllowed parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestIsNameAllowed) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestIsNameAllowed parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestIsNameAllowed) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestIsNameAllowed parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestIsNameAllowed) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestIsNameAllowed parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestIsNameAllowed) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestIsNameAllowed parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestIsNameAllowed) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestIsNameAllowed parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestIsNameAllowed) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
