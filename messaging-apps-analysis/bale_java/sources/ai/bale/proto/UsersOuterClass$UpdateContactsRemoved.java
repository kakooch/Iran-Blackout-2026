package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersOuterClass$UpdateContactsRemoved extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$UpdateContactsRemoved DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UIDS_FIELD_NUMBER = 1;
    private int uidsMemoizedSerializedSize = -1;
    private B.g uids_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$UpdateContactsRemoved.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$UpdateContactsRemoved usersOuterClass$UpdateContactsRemoved = new UsersOuterClass$UpdateContactsRemoved();
        DEFAULT_INSTANCE = usersOuterClass$UpdateContactsRemoved;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$UpdateContactsRemoved.class, usersOuterClass$UpdateContactsRemoved);
    }

    private UsersOuterClass$UpdateContactsRemoved() {
    }

    private void addAllUids(Iterable<? extends Integer> iterable) {
        ensureUidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.uids_);
    }

    private void addUids(int i) {
        ensureUidsIsMutable();
        this.uids_.b1(i);
    }

    private void clearUids() {
        this.uids_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureUidsIsMutable() {
        B.g gVar = this.uids_;
        if (gVar.u()) {
            return;
        }
        this.uids_ = GeneratedMessageLite.mutableCopy(gVar);
    }

    public static UsersOuterClass$UpdateContactsRemoved getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$UpdateContactsRemoved parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateContactsRemoved) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateContactsRemoved parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$UpdateContactsRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUids(int i, int i2) {
        ensureUidsIsMutable();
        this.uids_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$UpdateContactsRemoved();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001'", new Object[]{"uids_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$UpdateContactsRemoved.class) {
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

    public int getUids(int i) {
        return this.uids_.getInt(i);
    }

    public int getUidsCount() {
        return this.uids_.size();
    }

    public List<Integer> getUidsList() {
        return this.uids_;
    }

    public static a newBuilder(UsersOuterClass$UpdateContactsRemoved usersOuterClass$UpdateContactsRemoved) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$UpdateContactsRemoved);
    }

    public static UsersOuterClass$UpdateContactsRemoved parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactsRemoved) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateContactsRemoved parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactsRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$UpdateContactsRemoved parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$UpdateContactsRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$UpdateContactsRemoved parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactsRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$UpdateContactsRemoved parseFrom(byte[] bArr) {
        return (UsersOuterClass$UpdateContactsRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$UpdateContactsRemoved parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactsRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$UpdateContactsRemoved parseFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateContactsRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateContactsRemoved parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactsRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateContactsRemoved parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$UpdateContactsRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$UpdateContactsRemoved parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactsRemoved) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
