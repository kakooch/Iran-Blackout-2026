package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KM7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersOuterClass$RequestEditSex extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$RequestEditSex DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int SEX_FIELD_NUMBER = 1;
    private int sex_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$RequestEditSex.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestEditSex usersOuterClass$RequestEditSex = new UsersOuterClass$RequestEditSex();
        DEFAULT_INSTANCE = usersOuterClass$RequestEditSex;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestEditSex.class, usersOuterClass$RequestEditSex);
    }

    private UsersOuterClass$RequestEditSex() {
    }

    private void clearSex() {
        this.sex_ = 0;
    }

    public static UsersOuterClass$RequestEditSex getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestEditSex parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditSex) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditSex parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestEditSex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSex(KM7 km7) {
        this.sex_ = km7.getNumber();
    }

    private void setSexValue(int i) {
        this.sex_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestEditSex();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"sex_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestEditSex.class) {
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

    public KM7 getSex() {
        KM7 km7J = KM7.j(this.sex_);
        return km7J == null ? KM7.UNRECOGNIZED : km7J;
    }

    public int getSexValue() {
        return this.sex_;
    }

    public static a newBuilder(UsersOuterClass$RequestEditSex usersOuterClass$RequestEditSex) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestEditSex);
    }

    public static UsersOuterClass$RequestEditSex parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditSex) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditSex parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestEditSex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestEditSex parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestEditSex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestEditSex parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestEditSex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestEditSex parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestEditSex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestEditSex parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestEditSex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestEditSex parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditSex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditSex parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditSex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditSex parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestEditSex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestEditSex parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestEditSex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
