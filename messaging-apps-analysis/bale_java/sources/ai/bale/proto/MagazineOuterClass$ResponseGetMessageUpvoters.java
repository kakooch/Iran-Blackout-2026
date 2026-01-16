package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.BytesValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC18084o35;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class MagazineOuterClass$ResponseGetMessageUpvoters extends GeneratedMessageLite implements U64 {
    private static final MagazineOuterClass$ResponseGetMessageUpvoters DEFAULT_INSTANCE;
    public static final int LOAD_MORE_STATE_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int USERS_FIELD_NUMBER = 2;
    private int bitField0_;
    private BytesValue loadMoreState_;
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(MagazineOuterClass$ResponseGetMessageUpvoters.DEFAULT_INSTANCE);
        }
    }

    static {
        MagazineOuterClass$ResponseGetMessageUpvoters magazineOuterClass$ResponseGetMessageUpvoters = new MagazineOuterClass$ResponseGetMessageUpvoters();
        DEFAULT_INSTANCE = magazineOuterClass$ResponseGetMessageUpvoters;
        GeneratedMessageLite.registerDefaultInstance(MagazineOuterClass$ResponseGetMessageUpvoters.class, magazineOuterClass$ResponseGetMessageUpvoters);
    }

    private MagazineOuterClass$ResponseGetMessageUpvoters() {
    }

    private void addAllUsers(Iterable<? extends PeersStruct$UserOutPeer> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    private void addUsers(PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.add(peersStruct$UserOutPeer);
    }

    private void clearLoadMoreState() {
        this.loadMoreState_ = null;
        this.bitField0_ &= -2;
    }

    private void clearUsers() {
        this.users_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUsersIsMutable() {
        B.j jVar = this.users_;
        if (jVar.u()) {
            return;
        }
        this.users_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static MagazineOuterClass$ResponseGetMessageUpvoters getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        BytesValue bytesValue2 = this.loadMoreState_;
        if (bytesValue2 == null || bytesValue2 == BytesValue.getDefaultInstance()) {
            this.loadMoreState_ = bytesValue;
        } else {
            this.loadMoreState_ = (BytesValue) ((BytesValue.b) BytesValue.newBuilder(this.loadMoreState_).v(bytesValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static MagazineOuterClass$ResponseGetMessageUpvoters parseDelimitedFrom(InputStream inputStream) {
        return (MagazineOuterClass$ResponseGetMessageUpvoters) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$ResponseGetMessageUpvoters parseFrom(ByteBuffer byteBuffer) {
        return (MagazineOuterClass$ResponseGetMessageUpvoters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    private void setLoadMoreState(BytesValue bytesValue) {
        bytesValue.getClass();
        this.loadMoreState_ = bytesValue;
        this.bitField0_ |= 1;
    }

    private void setUsers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.set(i, peersStruct$UserOutPeer);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (A0.a[gVar.ordinal()]) {
            case 1:
                return new MagazineOuterClass$ResponseGetMessageUpvoters();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "loadMoreState_", "users_", PeersStruct$UserOutPeer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (MagazineOuterClass$ResponseGetMessageUpvoters.class) {
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

    public BytesValue getLoadMoreState() {
        BytesValue bytesValue = this.loadMoreState_;
        return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
    }

    public PeersStruct$UserOutPeer getUsers(int i) {
        return (PeersStruct$UserOutPeer) this.users_.get(i);
    }

    public int getUsersCount() {
        return this.users_.size();
    }

    public List<PeersStruct$UserOutPeer> getUsersList() {
        return this.users_;
    }

    public InterfaceC18084o35 getUsersOrBuilder(int i) {
        return (InterfaceC18084o35) this.users_.get(i);
    }

    public List<? extends InterfaceC18084o35> getUsersOrBuilderList() {
        return this.users_;
    }

    public boolean hasLoadMoreState() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(MagazineOuterClass$ResponseGetMessageUpvoters magazineOuterClass$ResponseGetMessageUpvoters) {
        return (a) DEFAULT_INSTANCE.createBuilder(magazineOuterClass$ResponseGetMessageUpvoters);
    }

    public static MagazineOuterClass$ResponseGetMessageUpvoters parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$ResponseGetMessageUpvoters) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$ResponseGetMessageUpvoters parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (MagazineOuterClass$ResponseGetMessageUpvoters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static MagazineOuterClass$ResponseGetMessageUpvoters parseFrom(AbstractC2383g abstractC2383g) {
        return (MagazineOuterClass$ResponseGetMessageUpvoters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addUsers(int i, PeersStruct$UserOutPeer peersStruct$UserOutPeer) {
        peersStruct$UserOutPeer.getClass();
        ensureUsersIsMutable();
        this.users_.add(i, peersStruct$UserOutPeer);
    }

    public static MagazineOuterClass$ResponseGetMessageUpvoters parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (MagazineOuterClass$ResponseGetMessageUpvoters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static MagazineOuterClass$ResponseGetMessageUpvoters parseFrom(byte[] bArr) {
        return (MagazineOuterClass$ResponseGetMessageUpvoters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MagazineOuterClass$ResponseGetMessageUpvoters parseFrom(byte[] bArr, C2394s c2394s) {
        return (MagazineOuterClass$ResponseGetMessageUpvoters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static MagazineOuterClass$ResponseGetMessageUpvoters parseFrom(InputStream inputStream) {
        return (MagazineOuterClass$ResponseGetMessageUpvoters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MagazineOuterClass$ResponseGetMessageUpvoters parseFrom(InputStream inputStream, C2394s c2394s) {
        return (MagazineOuterClass$ResponseGetMessageUpvoters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static MagazineOuterClass$ResponseGetMessageUpvoters parseFrom(AbstractC2384h abstractC2384h) {
        return (MagazineOuterClass$ResponseGetMessageUpvoters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static MagazineOuterClass$ResponseGetMessageUpvoters parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (MagazineOuterClass$ResponseGetMessageUpvoters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
