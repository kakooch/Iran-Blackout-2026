package ai.bale.proto;

import com.google.protobuf.AbstractC2377a;
import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.AbstractC2384h;
import com.google.protobuf.B;
import com.google.protobuf.C2394s;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.InterfaceC11027cc4;
import ir.nasim.InterfaceC23748xS2;
import ir.nasim.InterfaceC7415Rp6;
import ir.nasim.KW4;
import ir.nasim.OM7;
import ir.nasim.U64;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class UpdateBoxStruct$CombinedUpdate extends GeneratedMessageLite implements U64 {
    private static final UpdateBoxStruct$CombinedUpdate DEFAULT_INSTANCE;
    public static final int GROUPS_FIELD_NUMBER = 5;
    public static final int MESSAGES_FIELD_NUMBER = 7;
    private static volatile KW4 PARSER = null;
    public static final int SEQ_END_FIELD_NUMBER = 2;
    public static final int SEQ_START_FIELD_NUMBER = 1;
    public static final int STATE_FIELD_NUMBER = 3;
    public static final int UPDATES_FIELD_NUMBER = 6;
    public static final int USERS_FIELD_NUMBER = 4;
    private int seqEnd_;
    private int seqStart_;
    private AbstractC2383g state_ = AbstractC2383g.b;
    private B.j users_ = GeneratedMessageLite.emptyProtobufList();
    private B.j groups_ = GeneratedMessageLite.emptyProtobufList();
    private B.j updates_ = GeneratedMessageLite.emptyProtobufList();
    private B.j messages_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.b implements U64 {
        private a() {
            super(UpdateBoxStruct$CombinedUpdate.DEFAULT_INSTANCE);
        }
    }

    static {
        UpdateBoxStruct$CombinedUpdate updateBoxStruct$CombinedUpdate = new UpdateBoxStruct$CombinedUpdate();
        DEFAULT_INSTANCE = updateBoxStruct$CombinedUpdate;
        GeneratedMessageLite.registerDefaultInstance(UpdateBoxStruct$CombinedUpdate.class, updateBoxStruct$CombinedUpdate);
    }

    private UpdateBoxStruct$CombinedUpdate() {
    }

    private void addAllGroups(Iterable<? extends GroupsStruct$Group> iterable) {
        ensureGroupsIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.groups_);
    }

    private void addAllMessages(Iterable<? extends MessagingStruct$MessageContainer> iterable) {
        ensureMessagesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.messages_);
    }

    private void addAllUpdates(Iterable<? extends SequenceStruct$ContainerUpdates> iterable) {
        ensureUpdatesIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.updates_);
    }

    private void addAllUsers(Iterable<? extends UsersStruct$User> iterable) {
        ensureUsersIsMutable();
        AbstractC2377a.addAll((Iterable) iterable, (List) this.users_);
    }

    private void addGroups(GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(groupsStruct$Group);
    }

    private void addMessages(MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(messagingStruct$MessageContainer);
    }

    private void addUpdates(SequenceStruct$ContainerUpdates sequenceStruct$ContainerUpdates) {
        sequenceStruct$ContainerUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(sequenceStruct$ContainerUpdates);
    }

    private void addUsers(UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.add(usersStruct$User);
    }

    private void clearGroups() {
        this.groups_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearMessages() {
        this.messages_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSeqEnd() {
        this.seqEnd_ = 0;
    }

    private void clearSeqStart() {
        this.seqStart_ = 0;
    }

    private void clearState() {
        this.state_ = getDefaultInstance().getState();
    }

    private void clearUpdates() {
        this.updates_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUsers() {
        this.users_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureGroupsIsMutable() {
        B.j jVar = this.groups_;
        if (jVar.u()) {
            return;
        }
        this.groups_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureMessagesIsMutable() {
        B.j jVar = this.messages_;
        if (jVar.u()) {
            return;
        }
        this.messages_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUpdatesIsMutable() {
        B.j jVar = this.updates_;
        if (jVar.u()) {
            return;
        }
        this.updates_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    private void ensureUsersIsMutable() {
        B.j jVar = this.users_;
        if (jVar.u()) {
            return;
        }
        this.users_ = GeneratedMessageLite.mutableCopy(jVar);
    }

    public static UpdateBoxStruct$CombinedUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static UpdateBoxStruct$CombinedUpdate parseDelimitedFrom(InputStream inputStream) {
        return (UpdateBoxStruct$CombinedUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$CombinedUpdate parseFrom(ByteBuffer byteBuffer) {
        return (UpdateBoxStruct$CombinedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static KW4 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeGroups(int i) {
        ensureGroupsIsMutable();
        this.groups_.remove(i);
    }

    private void removeMessages(int i) {
        ensureMessagesIsMutable();
        this.messages_.remove(i);
    }

    private void removeUpdates(int i) {
        ensureUpdatesIsMutable();
        this.updates_.remove(i);
    }

    private void removeUsers(int i) {
        ensureUsersIsMutable();
        this.users_.remove(i);
    }

    private void setGroups(int i, GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.set(i, groupsStruct$Group);
    }

    private void setMessages(int i, MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensureMessagesIsMutable();
        this.messages_.set(i, messagingStruct$MessageContainer);
    }

    private void setSeqEnd(int i) {
        this.seqEnd_ = i;
    }

    private void setSeqStart(int i) {
        this.seqStart_ = i;
    }

    private void setState(AbstractC2383g abstractC2383g) {
        abstractC2383g.getClass();
        this.state_ = abstractC2383g;
    }

    private void setUpdates(int i, SequenceStruct$ContainerUpdates sequenceStruct$ContainerUpdates) {
        sequenceStruct$ContainerUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.set(i, sequenceStruct$ContainerUpdates);
    }

    private void setUsers(int i, UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.set(i, usersStruct$User);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.g gVar, Object obj, Object obj2) {
        switch (o2.a[gVar.ordinal()]) {
            case 1:
                return new UpdateBoxStruct$CombinedUpdate();
            case 2:
                return new a();
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0004\u0000\u0001\u0004\u0002\u0004\u0003\n\u0004\u001b\u0005\u001b\u0006\u001b\u0007\u001b", new Object[]{"seqStart_", "seqEnd_", "state_", "users_", UsersStruct$User.class, "groups_", GroupsStruct$Group.class, "updates_", SequenceStruct$ContainerUpdates.class, "messages_", MessagingStruct$MessageContainer.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                KW4 cVar = PARSER;
                if (cVar == null) {
                    synchronized (UpdateBoxStruct$CombinedUpdate.class) {
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

    public GroupsStruct$Group getGroups(int i) {
        return (GroupsStruct$Group) this.groups_.get(i);
    }

    public int getGroupsCount() {
        return this.groups_.size();
    }

    public List<GroupsStruct$Group> getGroupsList() {
        return this.groups_;
    }

    public InterfaceC23748xS2 getGroupsOrBuilder(int i) {
        return (InterfaceC23748xS2) this.groups_.get(i);
    }

    public List<? extends InterfaceC23748xS2> getGroupsOrBuilderList() {
        return this.groups_;
    }

    public MessagingStruct$MessageContainer getMessages(int i) {
        return (MessagingStruct$MessageContainer) this.messages_.get(i);
    }

    public int getMessagesCount() {
        return this.messages_.size();
    }

    public List<MessagingStruct$MessageContainer> getMessagesList() {
        return this.messages_;
    }

    public InterfaceC11027cc4 getMessagesOrBuilder(int i) {
        return (InterfaceC11027cc4) this.messages_.get(i);
    }

    public List<? extends InterfaceC11027cc4> getMessagesOrBuilderList() {
        return this.messages_;
    }

    public int getSeqEnd() {
        return this.seqEnd_;
    }

    public int getSeqStart() {
        return this.seqStart_;
    }

    public AbstractC2383g getState() {
        return this.state_;
    }

    public SequenceStruct$ContainerUpdates getUpdates(int i) {
        return (SequenceStruct$ContainerUpdates) this.updates_.get(i);
    }

    public int getUpdatesCount() {
        return this.updates_.size();
    }

    public List<SequenceStruct$ContainerUpdates> getUpdatesList() {
        return this.updates_;
    }

    public InterfaceC7415Rp6 getUpdatesOrBuilder(int i) {
        return (InterfaceC7415Rp6) this.updates_.get(i);
    }

    public List<? extends InterfaceC7415Rp6> getUpdatesOrBuilderList() {
        return this.updates_;
    }

    public UsersStruct$User getUsers(int i) {
        return (UsersStruct$User) this.users_.get(i);
    }

    public int getUsersCount() {
        return this.users_.size();
    }

    public List<UsersStruct$User> getUsersList() {
        return this.users_;
    }

    public OM7 getUsersOrBuilder(int i) {
        return (OM7) this.users_.get(i);
    }

    public List<? extends OM7> getUsersOrBuilderList() {
        return this.users_;
    }

    public static a newBuilder(UpdateBoxStruct$CombinedUpdate updateBoxStruct$CombinedUpdate) {
        return (a) DEFAULT_INSTANCE.createBuilder(updateBoxStruct$CombinedUpdate);
    }

    public static UpdateBoxStruct$CombinedUpdate parseDelimitedFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$CombinedUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$CombinedUpdate parseFrom(ByteBuffer byteBuffer, C2394s c2394s) {
        return (UpdateBoxStruct$CombinedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, c2394s);
    }

    public static UpdateBoxStruct$CombinedUpdate parseFrom(AbstractC2383g abstractC2383g) {
        return (UpdateBoxStruct$CombinedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g);
    }

    private void addGroups(int i, GroupsStruct$Group groupsStruct$Group) {
        groupsStruct$Group.getClass();
        ensureGroupsIsMutable();
        this.groups_.add(i, groupsStruct$Group);
    }

    private void addMessages(int i, MessagingStruct$MessageContainer messagingStruct$MessageContainer) {
        messagingStruct$MessageContainer.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(i, messagingStruct$MessageContainer);
    }

    private void addUpdates(int i, SequenceStruct$ContainerUpdates sequenceStruct$ContainerUpdates) {
        sequenceStruct$ContainerUpdates.getClass();
        ensureUpdatesIsMutable();
        this.updates_.add(i, sequenceStruct$ContainerUpdates);
    }

    private void addUsers(int i, UsersStruct$User usersStruct$User) {
        usersStruct$User.getClass();
        ensureUsersIsMutable();
        this.users_.add(i, usersStruct$User);
    }

    public static UpdateBoxStruct$CombinedUpdate parseFrom(AbstractC2383g abstractC2383g, C2394s c2394s) {
        return (UpdateBoxStruct$CombinedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2383g, c2394s);
    }

    public static UpdateBoxStruct$CombinedUpdate parseFrom(byte[] bArr) {
        return (UpdateBoxStruct$CombinedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UpdateBoxStruct$CombinedUpdate parseFrom(byte[] bArr, C2394s c2394s) {
        return (UpdateBoxStruct$CombinedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, c2394s);
    }

    public static UpdateBoxStruct$CombinedUpdate parseFrom(InputStream inputStream) {
        return (UpdateBoxStruct$CombinedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateBoxStruct$CombinedUpdate parseFrom(InputStream inputStream, C2394s c2394s) {
        return (UpdateBoxStruct$CombinedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, c2394s);
    }

    public static UpdateBoxStruct$CombinedUpdate parseFrom(AbstractC2384h abstractC2384h) {
        return (UpdateBoxStruct$CombinedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h);
    }

    public static UpdateBoxStruct$CombinedUpdate parseFrom(AbstractC2384h abstractC2384h, C2394s c2394s) {
        return (UpdateBoxStruct$CombinedUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, abstractC2384h, c2394s);
    }
}
