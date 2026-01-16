package ai.bale.proto;

import ai.bale.proto.CollectionsStruct$MapValue;
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
public final class UsersOuterClass$UpdateContactsAdded extends GeneratedMessageLite implements U64 {
    private static final UsersOuterClass$UpdateContactsAdded DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int PHONES_FIELD_NUMBER = 2;
    public static final int UIDS_FIELD_NUMBER = 1;
    private int bitField0_;
    private CollectionsStruct$MapValue phones_;
    private int uidsMemoizedSerializedSize = -1;
    private B.g uids_ = GeneratedMessageLite.emptyIntList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$UpdateContactsAdded.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$UpdateContactsAdded usersOuterClass$UpdateContactsAdded = new UsersOuterClass$UpdateContactsAdded();
        DEFAULT_INSTANCE = usersOuterClass$UpdateContactsAdded;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$UpdateContactsAdded.class, usersOuterClass$UpdateContactsAdded);
    }

    private UsersOuterClass$UpdateContactsAdded() {
    }

    private void addAllUids(Iterable<? extends Integer> iterable) {
        ensureUidsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.uids_);
    }

    private void addUids(int i) {
        ensureUidsIsMutable();
        this.uids_.b1(i);
    }

    private void clearPhones() {
        this.phones_ = null;
        this.bitField0_ &= -2;
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

    public static UsersOuterClass$UpdateContactsAdded getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePhones(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        CollectionsStruct$MapValue collectionsStruct$MapValue2 = this.phones_;
        if (collectionsStruct$MapValue2 == null || collectionsStruct$MapValue2 == CollectionsStruct$MapValue.getDefaultInstance()) {
            this.phones_ = collectionsStruct$MapValue;
        } else {
            this.phones_ = (CollectionsStruct$MapValue) ((CollectionsStruct$MapValue.a) CollectionsStruct$MapValue.newBuilder(this.phones_).v(collectionsStruct$MapValue)).j();
        }
        this.bitField0_ |= 1;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$UpdateContactsAdded parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateContactsAdded) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateContactsAdded parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$UpdateContactsAdded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPhones(CollectionsStruct$MapValue collectionsStruct$MapValue) {
        collectionsStruct$MapValue.getClass();
        this.phones_ = collectionsStruct$MapValue;
        this.bitField0_ |= 1;
    }

    private void setUids(int i, int i2) {
        ensureUidsIsMutable();
        this.uids_.U(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$UpdateContactsAdded();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001'\u0002ဉ\u0000", new Object[]{"bitField0_", "uids_", "phones_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$UpdateContactsAdded.class) {
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

    public CollectionsStruct$MapValue getPhones() {
        CollectionsStruct$MapValue collectionsStruct$MapValue = this.phones_;
        return collectionsStruct$MapValue == null ? CollectionsStruct$MapValue.getDefaultInstance() : collectionsStruct$MapValue;
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

    public boolean hasPhones() {
        return (this.bitField0_ & 1) != 0;
    }

    public static a newBuilder(UsersOuterClass$UpdateContactsAdded usersOuterClass$UpdateContactsAdded) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$UpdateContactsAdded);
    }

    public static UsersOuterClass$UpdateContactsAdded parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactsAdded) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateContactsAdded parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactsAdded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$UpdateContactsAdded parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$UpdateContactsAdded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static UsersOuterClass$UpdateContactsAdded parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactsAdded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$UpdateContactsAdded parseFrom(byte[] bArr) {
        return (UsersOuterClass$UpdateContactsAdded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$UpdateContactsAdded parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactsAdded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$UpdateContactsAdded parseFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateContactsAdded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateContactsAdded parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactsAdded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateContactsAdded parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$UpdateContactsAdded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$UpdateContactsAdded parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$UpdateContactsAdded) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
