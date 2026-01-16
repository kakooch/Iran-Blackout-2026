package ai.bale.proto;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.BoolValue;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes9.dex */
public final class GroupsStruct$LoadMembersCondition extends GeneratedMessageLite implements U64 {
    public static final int CONTACTS_FIELD_NUMBER = 2;
    private static final GroupsStruct$LoadMembersCondition DEFAULT_INSTANCE;
    public static final int EXCEPTED_PERMISSIONS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 3;
    private int bitField0_;
    private BoolValue contacts_;
    private BoolValue exceptedPermissions_;
    private StringValue query_;

    public static final class a extends GeneratedMessageLite.b implements U64 {
        public a A(BoolValue boolValue) {
            q();
            ((GroupsStruct$LoadMembersCondition) this.b).setExceptedPermissions(boolValue);
            return this;
        }

        private a() {
            super(GroupsStruct$LoadMembersCondition.DEFAULT_INSTANCE);
        }
    }

    static {
        GroupsStruct$LoadMembersCondition groupsStruct$LoadMembersCondition = new GroupsStruct$LoadMembersCondition();
        DEFAULT_INSTANCE = groupsStruct$LoadMembersCondition;
        GeneratedMessageLite.registerDefaultInstance(GroupsStruct$LoadMembersCondition.class, groupsStruct$LoadMembersCondition);
    }

    private GroupsStruct$LoadMembersCondition() {
    }

    private void clearContacts() {
        this.contacts_ = null;
        this.bitField0_ &= -3;
    }

    private void clearExceptedPermissions() {
        this.exceptedPermissions_ = null;
        this.bitField0_ &= -2;
    }

    private void clearQuery() {
        this.query_ = null;
        this.bitField0_ &= -5;
    }

    public static GroupsStruct$LoadMembersCondition getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeContacts(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.contacts_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.contacts_ = boolValue;
        } else {
            this.contacts_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.contacts_).v(boolValue)).j();
        }
        this.bitField0_ |= 2;
    }

    private void mergeExceptedPermissions(BoolValue boolValue) {
        boolValue.getClass();
        BoolValue boolValue2 = this.exceptedPermissions_;
        if (boolValue2 == null || boolValue2 == BoolValue.getDefaultInstance()) {
            this.exceptedPermissions_ = boolValue;
        } else {
            this.exceptedPermissions_ = (BoolValue) ((BoolValue.b) BoolValue.newBuilder(this.exceptedPermissions_).v(boolValue)).j();
        }
        this.bitField0_ |= 1;
    }

    private void mergeQuery(StringValue stringValue) {
        stringValue.getClass();
        StringValue stringValue2 = this.query_;
        if (stringValue2 == null || stringValue2 == StringValue.getDefaultInstance()) {
            this.query_ = stringValue;
        } else {
            this.query_ = (StringValue) ((StringValue.b) StringValue.newBuilder(this.query_).v(stringValue)).j();
        }
        this.bitField0_ |= 4;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static GroupsStruct$LoadMembersCondition parseDelimitedFrom(InputStream inputStream) {
        return (GroupsStruct$LoadMembersCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$LoadMembersCondition parseFrom(ByteBuffer byteBuffer) {
        return (GroupsStruct$LoadMembersCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setContacts(BoolValue boolValue) {
        boolValue.getClass();
        this.contacts_ = boolValue;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExceptedPermissions(BoolValue boolValue) {
        boolValue.getClass();
        this.exceptedPermissions_ = boolValue;
        this.bitField0_ |= 1;
    }

    private void setQuery(StringValue stringValue) {
        stringValue.getClass();
        this.query_ = stringValue;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (AbstractC1877n0.a[gVar.ordinal()]) {
            case 1:
                return new GroupsStruct$LoadMembersCondition();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "exceptedPermissions_", "contacts_", "query_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (GroupsStruct$LoadMembersCondition.class) {
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

    public BoolValue getContacts() {
        BoolValue boolValue = this.contacts_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public BoolValue getExceptedPermissions() {
        BoolValue boolValue = this.exceptedPermissions_;
        return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
    }

    public StringValue getQuery() {
        StringValue stringValue = this.query_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    public boolean hasContacts() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasExceptedPermissions() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasQuery() {
        return (this.bitField0_ & 4) != 0;
    }

    public static a newBuilder(GroupsStruct$LoadMembersCondition groupsStruct$LoadMembersCondition) {
        return (a) DEFAULT_INSTANCE.createBuilder(groupsStruct$LoadMembersCondition);
    }

    public static GroupsStruct$LoadMembersCondition parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$LoadMembersCondition) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$LoadMembersCondition parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (GroupsStruct$LoadMembersCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static GroupsStruct$LoadMembersCondition parseFrom(AbstractC2383g abstractC2383g) {
        return (GroupsStruct$LoadMembersCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    public static GroupsStruct$LoadMembersCondition parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (GroupsStruct$LoadMembersCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static GroupsStruct$LoadMembersCondition parseFrom(byte[] bArr) {
        return (GroupsStruct$LoadMembersCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GroupsStruct$LoadMembersCondition parseFrom(byte[] bArr, C2394s c2394s) {
        return (GroupsStruct$LoadMembersCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static GroupsStruct$LoadMembersCondition parseFrom(InputStream inputStream) {
        return (GroupsStruct$LoadMembersCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GroupsStruct$LoadMembersCondition parseFrom(InputStream inputStream, C2394s c2394s) {
        return (GroupsStruct$LoadMembersCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static GroupsStruct$LoadMembersCondition parseFrom(AbstractC2384h abstractC2384h) {
        return (GroupsStruct$LoadMembersCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static GroupsStruct$LoadMembersCondition parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (GroupsStruct$LoadMembersCondition) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
