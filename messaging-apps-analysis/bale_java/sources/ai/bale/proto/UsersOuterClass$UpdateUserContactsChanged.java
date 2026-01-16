package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC16491lM7;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UsersOuterClass$UpdateUserContactsChanged extends GeneratedMessageLite implements U64 {
    public static final int CONTACT_RECORDS_FIELD_NUMBER = 4;
    private static final UsersOuterClass$UpdateUserContactsChanged DEFAULT_INSTANCE;
    private static volatile KW4 PARSER = null;
    public static final int UID_FIELD_NUMBER = 1;
    private B.j contactRecords_ = GeneratedMessageLite.emptyProtobufList();
    private int uid_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UsersOuterClass$UpdateUserContactsChanged.DEFAULT_INSTANCE);
        }
    }

    static {
        UsersOuterClass$UpdateUserContactsChanged usersOuterClass$UpdateUserContactsChanged = new UsersOuterClass$UpdateUserContactsChanged();
        DEFAULT_INSTANCE = usersOuterClass$UpdateUserContactsChanged;
        GeneratedMessageLite.registerDefaultInstance(UsersOuterClass$UpdateUserContactsChanged.class, usersOuterClass$UpdateUserContactsChanged);
    }

    private UsersOuterClass$UpdateUserContactsChanged() {
    }

    private void addAllContactRecords(Iterable<? extends UsersStruct$ContactRecord> iterable) {
        ensureContactRecordsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.contactRecords_);
    }

    private void addContactRecords(UsersStruct$ContactRecord usersStruct$ContactRecord) {
        usersStruct$ContactRecord.getClass();
        ensureContactRecordsIsMutable();
        this.contactRecords_.add(usersStruct$ContactRecord);
    }

    private void clearContactRecords() {
        this.contactRecords_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUid() {
        this.uid_ = 0;
    }

    private void ensureContactRecordsIsMutable() {
        B.j jVar = this.contactRecords_;
        if (jVar.u()) {
            return;
        }
        this.contactRecords_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static UsersOuterClass$UpdateUserContactsChanged getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UsersOuterClass$UpdateUserContactsChanged parseDelimitedFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateUserContactsChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateUserContactsChanged parseFrom(ByteBuffer byteBuffer) {
        return (UsersOuterClass$UpdateUserContactsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeContactRecords(int i) {
        ensureContactRecordsIsMutable();
        this.contactRecords_.remove(i);
    }

    private void setContactRecords(int i, UsersStruct$ContactRecord usersStruct$ContactRecord) {
        usersStruct$ContactRecord.getClass();
        ensureContactRecordsIsMutable();
        this.contactRecords_.set(i, usersStruct$ContactRecord);
    }

    private void setUid(int i) {
        this.uid_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (p2.a[gVar.ordinal()]) {
            case 1:
                return new UsersOuterClass$UpdateUserContactsChanged();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0004\u0002\u0000\u0001\u0000\u0001\u0004\u0004\u001b", new Object[]{"uid_", "contactRecords_", UsersStruct$ContactRecord.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UsersOuterClass$UpdateUserContactsChanged.class) {
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

    public UsersStruct$ContactRecord getContactRecords(int i) {
        return (UsersStruct$ContactRecord) this.contactRecords_.get(i);
    }

    public int getContactRecordsCount() {
        return this.contactRecords_.size();
    }

    public List<UsersStruct$ContactRecord> getContactRecordsList() {
        return this.contactRecords_;
    }

    public InterfaceC16491lM7 getContactRecordsOrBuilder(int i) {
        return (InterfaceC16491lM7) this.contactRecords_.get(i);
    }

    public List<? extends InterfaceC16491lM7> getContactRecordsOrBuilderList() {
        return this.contactRecords_;
    }

    public int getUid() {
        return this.uid_;
    }

    public static a newBuilder(UsersOuterClass$UpdateUserContactsChanged usersOuterClass$UpdateUserContactsChanged) {
        return (a) DEFAULT_INSTANCE.createBuilder(usersOuterClass$UpdateUserContactsChanged);
    }

    public static UsersOuterClass$UpdateUserContactsChanged parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserContactsChanged) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateUserContactsChanged parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserContactsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UsersOuterClass$UpdateUserContactsChanged parseFrom(AbstractC2383g abstractC2383g) {
        return (UsersOuterClass$UpdateUserContactsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addContactRecords(int i, UsersStruct$ContactRecord usersStruct$ContactRecord) {
        usersStruct$ContactRecord.getClass();
        ensureContactRecordsIsMutable();
        this.contactRecords_.add(i, usersStruct$ContactRecord);
    }

    public static UsersOuterClass$UpdateUserContactsChanged parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserContactsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UsersOuterClass$UpdateUserContactsChanged parseFrom(byte[] bArr) {
        return (UsersOuterClass$UpdateUserContactsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UsersOuterClass$UpdateUserContactsChanged parseFrom(byte[] bArr, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserContactsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UsersOuterClass$UpdateUserContactsChanged parseFrom(InputStream inputStream) {
        return (UsersOuterClass$UpdateUserContactsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UsersOuterClass$UpdateUserContactsChanged parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserContactsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UsersOuterClass$UpdateUserContactsChanged parseFrom(AbstractC2384h abstractC2384h) {
        return (UsersOuterClass$UpdateUserContactsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UsersOuterClass$UpdateUserContactsChanged parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UsersOuterClass$UpdateUserContactsChanged) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
