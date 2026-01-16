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
public final class UsersOuterClass$UpdateContactRegistered extends GeneratedMessageLite implements U64 {
    public static final int DATE_FIELD_NUMBER = 3;
    private static final UsersOuterClass$UpdateContactRegistered DEFAULT_INSTANCE;
    public static final int IS_SILENT_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int RID_FIELD_NUMBER = 4;
    public static final int UID_FIELD_NUMBER = 1;
    private long date_;
    private boolean isSilent_;
    private long rid_;
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$UpdateContactRegistered.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$UpdateContactRegistered usersOuterClass$UpdateContactRegistered = new UsersOuterClass$UpdateContactRegistered();
        DEFAULT_INSTANCE = usersOuterClass$UpdateContactRegistered;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$UpdateContactRegistered.class, usersOuterClass$UpdateContactRegistered);
    }

    private UsersOuterClass$UpdateContactRegistered() {
    }

    private void clearDate() {
        this.date_ = 0L;
    }

    private void clearIsSilent() {
        this.isSilent_ = false;
    }

    private void clearRid() {
        this.rid_ = 0L;
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    public static UsersOuterClass$UpdateContactRegistered getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$UpdateContactRegistered parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateContactRegistered) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateContactRegistered parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$UpdateContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(long j) {
        this.date_ = j;
    }

    private void setIsSilent(boolean z) {
        this.isSilent_ = z;
    }

    private void setRid(long j) {
        this.rid_ = j;
    }

    private void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$UpdateContactRegistered();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0007\u0003\u0002\u0004\u0002", new Object[]{"uid_", "isSilent_", "date_", "rid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$UpdateContactRegistered.class) {
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

    public boolean getIsSilent() {
        return this.isSilent_;
    }

    public long getRid() {
        return this.rid_;
    }

    public int getUid() {
        return this.uid_;
    }

    public static a newBuilder(UsersOuterClass$UpdateContactRegistered usersOuterClass$UpdateContactRegistered) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$UpdateContactRegistered);
    }

    public static UsersOuterClass$UpdateContactRegistered parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactRegistered) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateContactRegistered parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$UpdateContactRegistered parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$UpdateContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$UpdateContactRegistered parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$UpdateContactRegistered parseFrom(byte[] bArr) {
        return (UsersOuterClass$UpdateContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$UpdateContactRegistered parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$UpdateContactRegistered parseFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateContactRegistered parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateContactRegistered parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$UpdateContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$UpdateContactRegistered parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactRegistered) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
