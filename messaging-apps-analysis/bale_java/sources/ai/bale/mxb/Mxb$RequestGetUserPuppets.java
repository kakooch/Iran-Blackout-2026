package ai.bale.mxb;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class Mxb$RequestGetUserPuppets extends GeneratedMessageLite implements U64 {
    private static final Mxb$RequestGetUserPuppets DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PHONE_FIELD_NUMBER = 1;
    public static final int USER_ID_FIELD_NUMBER = 2;
    private int queryCase_ = 0;
    private Object query_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((Mxb$RequestGetUserPuppets) this.b).setPhone(j);
            return this;
        }

        private a() {
            super(Mxb$RequestGetUserPuppets.DEFAULT_INSTANCE);
        }
    }

    public enum b {
        PHONE(1),
        USER_ID(2),
        QUERY_NOT_SET(0);

        private final int a;

        b(int i) {
            this.a = i;
        }

        public static b j(int i) {
            if (i == 0) {
                return QUERY_NOT_SET;
            }
            if (i == 1) {
                return PHONE;
            }
            if (i != 2) {
                return null;
            }
            return USER_ID;
        }
    }

    static {
        Mxb$RequestGetUserPuppets mxb$RequestGetUserPuppets = new Mxb$RequestGetUserPuppets();
        DEFAULT_INSTANCE = mxb$RequestGetUserPuppets;
        GeneratedMessageLite.registerDefaultInstance(Mxb$RequestGetUserPuppets.class, mxb$RequestGetUserPuppets);
    }

    private Mxb$RequestGetUserPuppets() {
    }

    private void clearPhone() {
        if (this.queryCase_ == 1) {
            this.queryCase_ = 0;
            this.query_ = null;
        }
    }

    private void clearQuery() {
        this.queryCase_ = 0;
        this.query_ = null;
    }

    private void clearUserId() {
        if (this.queryCase_ == 2) {
            this.queryCase_ = 0;
            this.query_ = null;
        }
    }

    public static Mxb$RequestGetUserPuppets getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Mxb$RequestGetUserPuppets parseDelimitedFrom(InputStream inputStream) {
        return (Mxb$RequestGetUserPuppets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$RequestGetUserPuppets parseFrom(ByteBuffer byteBuffer) {
        return (Mxb$RequestGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPhone(long j) {
        this.queryCase_ = 1;
        this.query_ = Long.valueOf(j);
    }

    private void setUserId(int i) {
        this.queryCase_ = 2;
        this.query_ = Integer.valueOf(i);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (ai.bale.mxb.a.a[gVar.ordinal()]) {
            case 1:
                return new Mxb$RequestGetUserPuppets();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u00015\u0000\u00027\u0000", new Object[]{"query_", "queryCase_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (Mxb$RequestGetUserPuppets.class) {
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

    public long getPhone() {
        if (this.queryCase_ == 1) {
            return ((Long) this.query_).longValue();
        }
        return 0L;
    }

    public b getQueryCase() {
        return b.j(this.queryCase_);
    }

    public int getUserId() {
        if (this.queryCase_ == 2) {
            return ((Integer) this.query_).intValue();
        }
        return 0;
    }

    public boolean hasPhone() {
        return this.queryCase_ == 1;
    }

    public boolean hasUserId() {
        return this.queryCase_ == 2;
    }

    public static a newBuilder(Mxb$RequestGetUserPuppets mxb$RequestGetUserPuppets) {
        return (a) DEFAULT_INSTANCE.createBuilder(mxb$RequestGetUserPuppets);
    }

    public static Mxb$RequestGetUserPuppets parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$RequestGetUserPuppets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$RequestGetUserPuppets parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (Mxb$RequestGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static Mxb$RequestGetUserPuppets parseFrom(AbstractC2383g abstractC2383g) {
        return (Mxb$RequestGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static Mxb$RequestGetUserPuppets parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (Mxb$RequestGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static Mxb$RequestGetUserPuppets parseFrom(byte[] bArr) {
        return (Mxb$RequestGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Mxb$RequestGetUserPuppets parseFrom(byte[] bArr, C2394s c2394s) {
        return (Mxb$RequestGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static Mxb$RequestGetUserPuppets parseFrom(InputStream inputStream) {
        return (Mxb$RequestGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Mxb$RequestGetUserPuppets parseFrom(InputStream inputStream, C2394s c2394s) {
        return (Mxb$RequestGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static Mxb$RequestGetUserPuppets parseFrom(AbstractC2384h abstractC2384h) {
        return (Mxb$RequestGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static Mxb$RequestGetUserPuppets parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (Mxb$RequestGetUserPuppets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
