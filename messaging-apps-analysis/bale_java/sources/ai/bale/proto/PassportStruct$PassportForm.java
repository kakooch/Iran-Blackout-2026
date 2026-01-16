package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC9464a05;
import ir.nasim.KW4;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes9.dex */
public final class PassportStruct$PassportForm extends GeneratedMessageLite implements U64 {
    private static final PassportStruct$PassportForm DEFAULT_INSTANCE;
    public static final int GROUPS_FIELD_NUMBER = 1;
    private static volatile KW4 PARSER;
    private B.j groups_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(PassportStruct$PassportForm.DEFAULT_INSTANCE);
        }
    }

    static {
        PassportStruct$PassportForm passportStruct$PassportForm = new PassportStruct$PassportForm();
        DEFAULT_INSTANCE = passportStruct$PassportForm;
        GeneratedMessageLite.registerDefaultInstance(PassportStruct$PassportForm.class, passportStruct$PassportForm);
    }

    private PassportStruct$PassportForm() {
    }

    private void addAllGroups(Iterable<? extends PassportStruct$PassportFieldGroup> iterable) {
        ensureGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groups_);
    }

    private void addGroups(PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup) {
        passportStruct$PassportFieldGroup.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(passportStruct$PassportFieldGroup);
    }

    private void clearGroups() {
        this.groups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureGroupsIsMutable() {
        B.j jVar = this.groups_;
        if (jVar.u()) {
            return;
        }
        this.groups_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static PassportStruct$PassportForm getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static PassportStruct$PassportForm parseDelimitedFrom(InputStream inputStream) {
        return (PassportStruct$PassportForm) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportForm parseFrom(ByteBuffer byteBuffer) {
        return (PassportStruct$PassportForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroups(int i) {
        ensureGroupsIsMutable();
        this.groups_.remove(i);
    }

    private void setGroups(int i, PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup) {
        passportStruct$PassportFieldGroup.getClass();
        ensureGroupsIsMutable();
        this.groups_.set(i, passportStruct$PassportFieldGroup);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (Z0.a[gVar.ordinal()]) {
            case 1:
                return new PassportStruct$PassportForm();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"groups_", PassportStruct$PassportFieldGroup.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (PassportStruct$PassportForm.class) {
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

    public PassportStruct$PassportFieldGroup getGroups(int i) {
        return (PassportStruct$PassportFieldGroup) this.groups_.get(i);
    }

    public int getGroupsCount() {
        return this.groups_.size();
    }

    public List<PassportStruct$PassportFieldGroup> getGroupsList() {
        return this.groups_;
    }

    public InterfaceC9464a05 getGroupsOrBuilder(int i) {
        return (InterfaceC9464a05) this.groups_.get(i);
    }

    public List<? extends InterfaceC9464a05> getGroupsOrBuilderList() {
        return this.groups_;
    }

    public static a newBuilder(PassportStruct$PassportForm passportStruct$PassportForm) {
        return (a) DEFAULT_INSTANCE.createBuilder(passportStruct$PassportForm);
    }

    public static PassportStruct$PassportForm parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportForm) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportForm parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (PassportStruct$PassportForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static PassportStruct$PassportForm parseFrom(AbstractC2383g abstractC2383g) {
        return (PassportStruct$PassportForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroups(int i, PassportStruct$PassportFieldGroup passportStruct$PassportFieldGroup) {
        passportStruct$PassportFieldGroup.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(i, passportStruct$PassportFieldGroup);
    }

    public static PassportStruct$PassportForm parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (PassportStruct$PassportForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static PassportStruct$PassportForm parseFrom(byte[] bArr) {
        return (PassportStruct$PassportForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PassportStruct$PassportForm parseFrom(byte[] bArr, C2394s c2394s) {
        return (PassportStruct$PassportForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static PassportStruct$PassportForm parseFrom(InputStream inputStream) {
        return (PassportStruct$PassportForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PassportStruct$PassportForm parseFrom(InputStream inputStream, C2394s c2394s) {
        return (PassportStruct$PassportForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static PassportStruct$PassportForm parseFrom(AbstractC2384h abstractC2384h) {
        return (PassportStruct$PassportForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static PassportStruct$PassportForm parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (PassportStruct$PassportForm) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
