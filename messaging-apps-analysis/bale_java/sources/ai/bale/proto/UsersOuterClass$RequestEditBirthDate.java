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
public final class UsersOuterClass$RequestEditBirthDate extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 1;
    private static final UsersOuterClass$RequestEditBirthDate DEFAULT_INSTANCE;
    private static volatile KW4 PARSER;
    private long date_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$RequestEditBirthDate.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$RequestEditBirthDate usersOuterClass$RequestEditBirthDate = new UsersOuterClass$RequestEditBirthDate();
        DEFAULT_INSTANCE = usersOuterClass$RequestEditBirthDate;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$RequestEditBirthDate.class, usersOuterClass$RequestEditBirthDate);
    }

    private UsersOuterClass$RequestEditBirthDate() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    public static UsersOuterClass$RequestEditBirthDate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$RequestEditBirthDate parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditBirthDate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditBirthDate parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$RequestEditBirthDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$RequestEditBirthDate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002", new Object[]{"date_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$RequestEditBirthDate.class) {
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

    public long getDate() {
        return this.date_;
    }

    public static a newBuilder(UsersOuterClass$RequestEditBirthDate usersOuterClass$RequestEditBirthDate) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$RequestEditBirthDate);
    }

    public static UsersOuterClass$RequestEditBirthDate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditBirthDate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditBirthDate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$RequestEditBirthDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$RequestEditBirthDate parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$RequestEditBirthDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$RequestEditBirthDate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$RequestEditBirthDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$RequestEditBirthDate parseFrom(byte[] bArr) {
        return (UsersOuterClass$RequestEditBirthDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$RequestEditBirthDate parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$RequestEditBirthDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$RequestEditBirthDate parseFrom(InputStream inputStream) {
        return (UsersOuterClass$RequestEditBirthDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$RequestEditBirthDate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$RequestEditBirthDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$RequestEditBirthDate parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$RequestEditBirthDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$RequestEditBirthDate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$RequestEditBirthDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
