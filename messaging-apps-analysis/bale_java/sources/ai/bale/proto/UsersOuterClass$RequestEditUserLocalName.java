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
public final class UsersOuterClass$RequestEditUserLocalName extends GeneratedMessageLite implements U64 {
    public static final int ACCESS_HASH_FIELD_NUMBER = 2;
    private static final UsersOuterClass$RequestEditUserLocalName DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile KW4 PARSER = null;
    public static final int UID_FIELD_NUMBER = 1;
    private long accessHash_;
    private String name_ = "";
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(long j) {
            q();
            ((UsersOuterClass$RequestEditUserLocalName) this.b).setAccessHash(j);
            return this;
        }

        public a B(String str) {
            q();
            ((UsersOuterClass$RequestEditUserLocalName) this.b).setName(str);
            return this;
        }

        public a C(int i) {
            q();
            ((UsersOuterClass$RequestEditUserLocalName) this.b).setUid(i);
            return this;
        }

        private a() {
            super(UsersOuterClass$RequestEditUserLocalName.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestEditUserLocalName usersOuterClass$RequestEditUserLocalName = new UsersOuterClass$RequestEditUserLocalName();
        DEFAULT_INSTANCE = usersOuterClass$RequestEditUserLocalName;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestEditUserLocalName.class, usersOuterClass$RequestEditUserLocalName);
    }

    private UsersOuterClass$RequestEditUserLocalName() {
    }

    private void clearAccessHash() {
        this.accessHash_ = 0L;
    }

    private void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    public static UsersOuterClass$RequestEditUserLocalName getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestEditUserLocalName parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditUserLocalName) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditUserLocalName parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestEditUserLocalName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccessHash(long j) {
        this.accessHash_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.name_ = str;
    }

    private void setNameBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.name_ = abstractC2383g.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestEditUserLocalName();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003Ȉ", new Object[]{"uid_", "accessHash_", "name_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestEditUserLocalName.class) {
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

    public long getAccessHash() {
        return this.accessHash_;
    }

    public String getName() {
        return this.name_;
    }

    public AbstractC2383g getNameBytes() {
        return AbstractC2383g.N(this.name_);
    }

    public int getUid() {
        return this.uid_;
    }

    public static a newBuilder(UsersOuterClass$RequestEditUserLocalName usersOuterClass$RequestEditUserLocalName) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestEditUserLocalName);
    }

    public static UsersOuterClass$RequestEditUserLocalName parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditUserLocalName) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditUserLocalName parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestEditUserLocalName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestEditUserLocalName parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestEditUserLocalName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestEditUserLocalName parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestEditUserLocalName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestEditUserLocalName parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestEditUserLocalName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestEditUserLocalName parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestEditUserLocalName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestEditUserLocalName parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditUserLocalName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditUserLocalName parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditUserLocalName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditUserLocalName parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestEditUserLocalName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestEditUserLocalName parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestEditUserLocalName) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
