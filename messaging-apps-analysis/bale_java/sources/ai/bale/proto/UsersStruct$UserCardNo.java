package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.NM7;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersStruct$UserCardNo extends GeneratedMessageLite implements NM7 {
    public static final int DEFAULT_CARD_NO_FIELD_NUMBER = 2;
    private static final UsersStruct$UserCardNo DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private String defaultCardNo_ = "";
    private int userId_;

    public static final class a extends GeneratedMessageLite.b implements NM7 {
        private a() {
            super(UsersStruct$UserCardNo.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersStruct$UserCardNo usersStruct$UserCardNo = new UsersStruct$UserCardNo();
        DEFAULT_INSTANCE = usersStruct$UserCardNo;
        GeneratedMessageLite.registerDefaultInstance(UsersStruct$UserCardNo.class, usersStruct$UserCardNo);
    }

    private UsersStruct$UserCardNo() {
    }

    private void clearDefaultCardNo() {
        this.defaultCardNo_ = getDefaultInstance().getDefaultCardNo();
    }

    private void clearUserId() {
        this.userId_ = 0;
    }

    public static UsersStruct$UserCardNo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersStruct$UserCardNo parseDelimitedFrom(InputStream inputStream) {
        return (UsersStruct$UserCardNo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$UserCardNo parseFrom(ByteBuffer byteBuffer) {
        return (UsersStruct$UserCardNo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDefaultCardNo(String str) {
        str.getClass();
        this.defaultCardNo_ = str;
    }

    private void setDefaultCardNoBytes(AbstractC2383g abstractC2383g) {
        AbstractC2377a.checkByteStringIsUtf8(abstractC2383g);
        this.defaultCardNo_ = abstractC2383g.f0();
    }

    private void setUserId(int i) {
        this.userId_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (q2.a[gVar.ordinal()]) {
            case 1:
                return new UsersStruct$UserCardNo();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"userId_", "defaultCardNo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersStruct$UserCardNo.class) {
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

    public String getDefaultCardNo() {
        return this.defaultCardNo_;
    }

    public AbstractC2383g getDefaultCardNoBytes() {
        return AbstractC2383g.N(this.defaultCardNo_);
    }

    public int getUserId() {
        return this.userId_;
    }

    public static a newBuilder(UsersStruct$UserCardNo usersStruct$UserCardNo) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersStruct$UserCardNo);
    }

    public static UsersStruct$UserCardNo parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$UserCardNo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$UserCardNo parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersStruct$UserCardNo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersStruct$UserCardNo parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersStruct$UserCardNo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersStruct$UserCardNo parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersStruct$UserCardNo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersStruct$UserCardNo parseFrom(byte[] bArr) {
        return (UsersStruct$UserCardNo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersStruct$UserCardNo parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersStruct$UserCardNo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersStruct$UserCardNo parseFrom(InputStream inputStream) {
        return (UsersStruct$UserCardNo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersStruct$UserCardNo parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersStruct$UserCardNo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersStruct$UserCardNo parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersStruct$UserCardNo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersStruct$UserCardNo parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersStruct$UserCardNo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
