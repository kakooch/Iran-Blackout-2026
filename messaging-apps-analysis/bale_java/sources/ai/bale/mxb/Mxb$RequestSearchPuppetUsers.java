package ai.bale.mxb;

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
public final class Mxb$RequestSearchPuppetUsers extends GeneratedMessageLite implements U64 {
    private static final Mxb$RequestSearchPuppetUsers DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 1;
    private String query_ = "";

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(String str) {
            q();
            ((Mxb$RequestSearchPuppetUsers) this.b).setQuery(str);
            return this;
        }

        private a() {
            super(Mxb$RequestSearchPuppetUsers.DEFAULT_INSTANCE);
        }
    }

    static {
        Mxb$RequestSearchPuppetUsers mxb$RequestSearchPuppetUsers = new Mxb$RequestSearchPuppetUsers();
        DEFAULT_INSTANCE = mxb$RequestSearchPuppetUsers;
        GeneratedMessageLite.registerDefaultInstance(Mxb$RequestSearchPuppetUsers.class, mxb$RequestSearchPuppetUsers);
    }

    private Mxb$RequestSearchPuppetUsers() {
    }

    private void clearQuery() {
        this.query_ = getDefaultInstance().getQuery();
    }

    public static Mxb$RequestSearchPuppetUsers getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Mxb$RequestSearchPuppetUsers parseDelimitedFrom(InputStream inputStream) {
        return (Mxb$RequestSearchPuppetUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$RequestSearchPuppetUsers parseFrom(ByteBuffer byteBuffer) {
        return (Mxb$RequestSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuery(String str) {
        str.getClass();
        this.query_ = str;
    }

    private void setQueryBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.query_ = abstractC2383g.f0();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (ai.bale.mxb.a.a[gVar.ordinal()]) {
            case 1:
                return new Mxb$RequestSearchPuppetUsers();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"query_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Mxb$RequestSearchPuppetUsers.class) {
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

    public String getQuery() {
        return this.query_;
    }

    public AbstractC2383g getQueryBytes() {
        return AbstractC2383g.N(this.query_);
    }

    public static a newBuilder(Mxb$RequestSearchPuppetUsers mxb$RequestSearchPuppetUsers) {
        return (a) DEFAULT_INSTANCE.createBuilder(mxb$RequestSearchPuppetUsers);
    }

    public static Mxb$RequestSearchPuppetUsers parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$RequestSearchPuppetUsers) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$RequestSearchPuppetUsers parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Mxb$RequestSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Mxb$RequestSearchPuppetUsers parseFrom(AbstractC2383g abstractC2383g) {
        return (Mxb$RequestSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Mxb$RequestSearchPuppetUsers parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Mxb$RequestSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Mxb$RequestSearchPuppetUsers parseFrom(byte[] bArr) {
        return (Mxb$RequestSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Mxb$RequestSearchPuppetUsers parseFrom(byte[] bArr, C2394s c2394s) {
        return (Mxb$RequestSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Mxb$RequestSearchPuppetUsers parseFrom(InputStream inputStream) {
        return (Mxb$RequestSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$RequestSearchPuppetUsers parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$RequestSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$RequestSearchPuppetUsers parseFrom(AbstractC2384h abstractC2384h) {
        return (Mxb$RequestSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Mxb$RequestSearchPuppetUsers parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Mxb$RequestSearchPuppetUsers) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
