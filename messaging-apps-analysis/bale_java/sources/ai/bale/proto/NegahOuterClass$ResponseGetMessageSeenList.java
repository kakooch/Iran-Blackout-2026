package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC22206uq4;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class NegahOuterClass$ResponseGetMessageSeenList extends GeneratedMessageLite implements U64 {
    public static final int COUNT_FIELD_NUMBER = 2;
    private static final NegahOuterClass$ResponseGetMessageSeenList DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int USERS_SEEN_FIELD_NUMBER = 1;
    private int count_;
    private B.j usersSeen_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(NegahOuterClass$ResponseGetMessageSeenList.DEFAULT_INSTANCE);
        }
    }

    static {
        NegahOuterClass$ResponseGetMessageSeenList negahOuterClass$ResponseGetMessageSeenList = new NegahOuterClass$ResponseGetMessageSeenList();
        DEFAULT_INSTANCE = negahOuterClass$ResponseGetMessageSeenList;
        GeneratedMessageLite.registerDefaultInstance(NegahOuterClass$ResponseGetMessageSeenList.class, negahOuterClass$ResponseGetMessageSeenList);
    }

    private NegahOuterClass$ResponseGetMessageSeenList() {
    }

    private void addAllUsersSeen(Iterable<? extends NegahStruct$UserSeenMessage> iterable) {
        ensureUsersSeenIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.usersSeen_);
    }

    private void addUsersSeen(NegahStruct$UserSeenMessage negahStruct$UserSeenMessage) {
        negahStruct$UserSeenMessage.getClass();
        ensureUsersSeenIsMutable();
        this.usersSeen_.add(negahStruct$UserSeenMessage);
    }

    private void clearCount() {
        this.count_ = 0;
    }

    private void clearUsersSeen() {
        this.usersSeen_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUsersSeenIsMutable() {
        B.j jVar = this.usersSeen_;
        if (jVar.u()) {
            return;
        }
        this.usersSeen_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static NegahOuterClass$ResponseGetMessageSeenList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static NegahOuterClass$ResponseGetMessageSeenList parseDelimitedFrom(InputStream inputStream) {
        return (NegahOuterClass$ResponseGetMessageSeenList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NegahOuterClass$ResponseGetMessageSeenList parseFrom(ByteBuffer byteBuffer) {
        return (NegahOuterClass$ResponseGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUsersSeen(int i) {
        ensureUsersSeenIsMutable();
        this.usersSeen_.remove(i);
    }

    private void setCount(int i) {
        this.count_ = i;
    }

    private void setUsersSeen(int i, NegahStruct$UserSeenMessage negahStruct$UserSeenMessage) {
        negahStruct$UserSeenMessage.getClass();
        ensureUsersSeenIsMutable();
        this.usersSeen_.set(i, negahStruct$UserSeenMessage);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (S0.a[gVar.ordinal()]) {
            case 1:
                return new NegahOuterClass$ResponseGetMessageSeenList();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0004", new Object[]{"usersSeen_", NegahStruct$UserSeenMessage.class, "count_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (NegahOuterClass$ResponseGetMessageSeenList.class) {
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

    public int getCount() {
        return this.count_;
    }

    public NegahStruct$UserSeenMessage getUsersSeen(int i) {
        return (NegahStruct$UserSeenMessage) this.usersSeen_.get(i);
    }

    public int getUsersSeenCount() {
        return this.usersSeen_.size();
    }

    public List<NegahStruct$UserSeenMessage> getUsersSeenList() {
        return this.usersSeen_;
    }

    public InterfaceC22206uq4 getUsersSeenOrBuilder(int i) {
        return (InterfaceC22206uq4) this.usersSeen_.get(i);
    }

    public List<? extends InterfaceC22206uq4> getUsersSeenOrBuilderList() {
        return this.usersSeen_;
    }

    public static a newBuilder(NegahOuterClass$ResponseGetMessageSeenList negahOuterClass$ResponseGetMessageSeenList) {
        return (a) DEFAULT_INSTANCE.createBuilder(negahOuterClass$ResponseGetMessageSeenList);
    }

    public static NegahOuterClass$ResponseGetMessageSeenList parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (NegahOuterClass$ResponseGetMessageSeenList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static NegahOuterClass$ResponseGetMessageSeenList parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (NegahOuterClass$ResponseGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static NegahOuterClass$ResponseGetMessageSeenList parseFrom(AbstractC2383g abstractC2383g) {
        return (NegahOuterClass$ResponseGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUsersSeen(int i, NegahStruct$UserSeenMessage negahStruct$UserSeenMessage) {
        negahStruct$UserSeenMessage.getClass();
        ensureUsersSeenIsMutable();
        this.usersSeen_.add(i, negahStruct$UserSeenMessage);
    }

    public static NegahOuterClass$ResponseGetMessageSeenList parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (NegahOuterClass$ResponseGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static NegahOuterClass$ResponseGetMessageSeenList parseFrom(byte[] bArr) {
        return (NegahOuterClass$ResponseGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NegahOuterClass$ResponseGetMessageSeenList parseFrom(byte[] bArr, C2394s c2394s) {
        return (NegahOuterClass$ResponseGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static NegahOuterClass$ResponseGetMessageSeenList parseFrom(InputStream inputStream) {
        return (NegahOuterClass$ResponseGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NegahOuterClass$ResponseGetMessageSeenList parseFrom(InputStream inputStream, C2394s c2394s) {
        return (NegahOuterClass$ResponseGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static NegahOuterClass$ResponseGetMessageSeenList parseFrom(AbstractC2384h abstractC2384h) {
        return (NegahOuterClass$ResponseGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static NegahOuterClass$ResponseGetMessageSeenList parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (NegahOuterClass$ResponseGetMessageSeenList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
