package ai.bale.proto;

import ai.bale.proto.PeersStruct$ExInfo;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UsersOuterClass$UpdateUserExInfoChanged extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$UpdateUserExInfoChanged DEFAULT_INSTANCE;
    public static final int EX_INFO_FIELD_NUMBER = 2;
    private static volatile KW4 PARSER = null;
    public static final int UID_FIELD_NUMBER = 1;
    private int bitField0_;
    private PeersStruct$ExInfo exInfo_;
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$UpdateUserExInfoChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$UpdateUserExInfoChanged usersOuterClass$UpdateUserExInfoChanged = new UsersOuterClass$UpdateUserExInfoChanged();
        DEFAULT_INSTANCE = usersOuterClass$UpdateUserExInfoChanged;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$UpdateUserExInfoChanged.class, usersOuterClass$UpdateUserExInfoChanged);
    }

    private UsersOuterClass$UpdateUserExInfoChanged() {
    }

    private void clearExInfo() {
        this.exInfo_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    public static UsersOuterClass$UpdateUserExInfoChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        PeersStruct$ExInfo peersStruct$ExInfo2 = this.exInfo_;
        if (peersStruct$ExInfo2 == null || peersStruct$ExInfo2 == PeersStruct$ExInfo.getDefaultInstance()) {
            this.exInfo_ = peersStruct$ExInfo;
        } else {
            this.exInfo_ = (PeersStruct$ExInfo) ((PeersStruct$ExInfo.a) PeersStruct$ExInfo.newBuilder(this.exInfo_).v(peersStruct$ExInfo)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$UpdateUserExInfoChanged parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateUserExInfoChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateUserExInfoChanged parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$UpdateUserExInfoChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setExInfo(PeersStruct$ExInfo peersStruct$ExInfo) {
        peersStruct$ExInfo.getClass();
        this.exInfo_ = peersStruct$ExInfo;
        this.bitField0_ |= 1;
    }

    private void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$UpdateUserExInfoChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002ဉ\u0000", new Object[]{"bitField0_", "uid_", "exInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$UpdateUserExInfoChanged.class) {
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

    public PeersStruct$ExInfo getExInfo() {
        PeersStruct$ExInfo peersStruct$ExInfo = this.exInfo_;
        return peersStruct$ExInfo == null ? PeersStruct$ExInfo.getDefaultInstance() : peersStruct$ExInfo;
    }

    public int getUid() {
        return this.uid_;
    }

    public boolean hasExInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersOuterClass$UpdateUserExInfoChanged usersOuterClass$UpdateUserExInfoChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$UpdateUserExInfoChanged);
    }

    public static UsersOuterClass$UpdateUserExInfoChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserExInfoChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateUserExInfoChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserExInfoChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$UpdateUserExInfoChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$UpdateUserExInfoChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$UpdateUserExInfoChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserExInfoChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$UpdateUserExInfoChanged parseFrom(byte[] bArr) {
        return (UsersOuterClass$UpdateUserExInfoChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$UpdateUserExInfoChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserExInfoChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$UpdateUserExInfoChanged parseFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateUserExInfoChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateUserExInfoChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserExInfoChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateUserExInfoChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$UpdateUserExInfoChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$UpdateUserExInfoChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserExInfoChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
