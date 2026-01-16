package ir.nasim.database.dailogLists;

import ai.bale.proto.MessagingStruct$ServiceEx;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.annotation.Keep;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC19039pg5;
import ir.nasim.AbstractC21618tq6;
import ir.nasim.C18752pB3;
import ir.nasim.C3712Ca3;
import ir.nasim.C4219Ee6;
import ir.nasim.C8044Uh0;
import ir.nasim.ED1;
import ir.nasim.EnumC22968w74;
import ir.nasim.InterfaceC11299cm3;
import ir.nasim.InterfaceC14941ik3;
import ir.nasim.JJ;
import ir.nasim.NE2;
import ir.nasim.Q92;
import ir.nasim.U74;
import ir.nasim.VY6;
import ir.nasim.database.dailogLists.FastThumbnailItemEntity;
import ir.nasim.database.dailogLists.UserNamePlaceHolder;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@InterfaceC14941ik3(discriminator = "_messageType")
@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u000f2\u00020\u0001:\b\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0007\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lir/nasim/database/dailogLists/DialogLastMessage;", "", "Lir/nasim/database/dailogLists/MessageState;", "state", "setState", "(Lir/nasim/database/dailogLists/MessageState;)Lir/nasim/database/dailogLists/DialogLastMessage;", "", "isMine", "()Z", "", "getSenderUid", "()I", "senderUid", "getState", "()Lir/nasim/database/dailogLists/MessageState;", "Companion", "Text", "Document", "Link", "Album", "Unknown", "Call", "Live", "a", "Lir/nasim/database/dailogLists/DialogLastMessage$Album;", "Lir/nasim/database/dailogLists/DialogLastMessage$Call;", "Lir/nasim/database/dailogLists/DialogLastMessage$Document;", "Lir/nasim/database/dailogLists/DialogLastMessage$Link;", "Lir/nasim/database/dailogLists/DialogLastMessage$Live;", "Lir/nasim/database/dailogLists/DialogLastMessage$Text;", "Lir/nasim/database/dailogLists/DialogLastMessage$Unknown;", "database_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public interface DialogLastMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.a;

    @Keep
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0087\b\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0002EFBW\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013Bi\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0012\u0010\u0017J'\u0010 \u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b'\u0010$J\u0010\u0010(\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b(\u0010)J\u0018\u0010*\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b.\u0010/Jf\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b2\u0010$J\u0010\u00103\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b3\u0010-J\u001a\u00106\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u000104HÖ\u0003¢\u0006\u0004\b6\u00107R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u00108\u001a\u0004\b9\u0010$R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010:\u001a\u0004\b;\u0010&R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\b\u00108\u001a\u0004\b<\u0010$R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010=\u001a\u0004\b\n\u0010)R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010>\u001a\u0004\b?\u0010+R\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010@\u001a\u0004\bA\u0010-R\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010B\u001a\u0004\bC\u0010/¨\u0006G"}, d2 = {"Lir/nasim/database/dailogLists/DialogLastMessage$Album;", "Lir/nasim/database/dailogLists/DialogLastMessage;", "Lir/nasim/U74;", "", "content", "", "Lir/nasim/database/dailogLists/FastThumbnailItemEntity;", "thumbnailItems", "senderNamePlaceHolder", "", "isMine", "", "Lir/nasim/database/dailogLists/UserNamePlaceHolder;", "userNamePlaceHolders", "", "senderUid", "Lir/nasim/database/dailogLists/MessageState;", "state", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/util/Set;ILir/nasim/database/dailogLists/MessageState;)V", "seen0", "Lir/nasim/tq6;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/util/Set;ILir/nasim/database/dailogLists/MessageState;Lir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "write$Self$database_release", "(Lir/nasim/database/dailogLists/DialogLastMessage$Album;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "setState", "(Lir/nasim/database/dailogLists/MessageState;)Lir/nasim/database/dailogLists/DialogLastMessage$Album;", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/List;", "component3", "component4", "()Z", "component5", "()Ljava/util/Set;", "component6", "()I", "component7", "()Lir/nasim/database/dailogLists/MessageState;", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/util/Set;ILir/nasim/database/dailogLists/MessageState;)Lir/nasim/database/dailogLists/DialogLastMessage$Album;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getContent", "Ljava/util/List;", "getThumbnailItems", "getSenderNamePlaceHolder", "Z", "Ljava/util/Set;", "getUserNamePlaceHolders", TokenNames.I, "getSenderUid", "Lir/nasim/database/dailogLists/MessageState;", "getState", "Companion", "a", "b", "database_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Album implements DialogLastMessage, U74 {
        private final String content;
        private final boolean isMine;
        private final String senderNamePlaceHolder;
        private final int senderUid;
        private final MessageState state;
        private final List<FastThumbnailItemEntity> thumbnailItems;
        private final Set<UserNamePlaceHolder> userNamePlaceHolders;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {null, new JJ(FastThumbnailItemEntity.a.a), null, null, new C18752pB3(UserNamePlaceHolder.a.a), null, Q92.b("ir.nasim.database.dailogLists.MessageState", MessageState.values())};

        public /* synthetic */ class a implements NE2 {
            public static final a a;
            private static final SerialDescriptor b;

            static {
                a aVar = new a();
                a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("album", aVar, 7);
                pluginGeneratedSerialDescriptor.l("content", false);
                pluginGeneratedSerialDescriptor.l("thumbnailItems", false);
                pluginGeneratedSerialDescriptor.l("senderNamePlaceHolder", true);
                pluginGeneratedSerialDescriptor.l("isMine", false);
                pluginGeneratedSerialDescriptor.l("userNamePlaceHolders", true);
                pluginGeneratedSerialDescriptor.l("senderUid", true);
                pluginGeneratedSerialDescriptor.l("state", true);
                pluginGeneratedSerialDescriptor.s(new Text.a.C1011a("_messageType"));
                b = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // ir.nasim.XI1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Album deserialize(Decoder decoder) {
                int i;
                MessageState messageState;
                Set set;
                boolean z;
                int i2;
                String str;
                List list;
                String str2;
                AbstractC13042fc3.i(decoder, "decoder");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.c cVarB = decoder.b(serialDescriptor);
                KSerializer[] kSerializerArr = Album.$childSerializers;
                int i3 = 5;
                if (cVarB.p()) {
                    String strN = cVarB.n(serialDescriptor, 0);
                    List list2 = (List) cVarB.E(serialDescriptor, 1, kSerializerArr[1], null);
                    String str3 = (String) cVarB.H(serialDescriptor, 2, VY6.a, null);
                    boolean zB = cVarB.B(serialDescriptor, 3);
                    Set set2 = (Set) cVarB.H(serialDescriptor, 4, kSerializerArr[4], null);
                    int i4 = cVarB.i(serialDescriptor, 5);
                    messageState = (MessageState) cVarB.E(serialDescriptor, 6, kSerializerArr[6], null);
                    str = strN;
                    i = i4;
                    z = zB;
                    str2 = str3;
                    i2 = 127;
                    set = set2;
                    list = list2;
                } else {
                    boolean z2 = true;
                    int i5 = 0;
                    int i6 = 0;
                    MessageState messageState2 = null;
                    String strN2 = null;
                    List list3 = null;
                    String str4 = null;
                    Set set3 = null;
                    boolean zB2 = false;
                    while (z2) {
                        int iO = cVarB.o(serialDescriptor);
                        switch (iO) {
                            case -1:
                                z2 = false;
                                i3 = 5;
                            case 0:
                                strN2 = cVarB.n(serialDescriptor, 0);
                                i6 |= 1;
                                i3 = 5;
                            case 1:
                                list3 = (List) cVarB.E(serialDescriptor, 1, kSerializerArr[1], list3);
                                i6 |= 2;
                                i3 = 5;
                            case 2:
                                str4 = (String) cVarB.H(serialDescriptor, 2, VY6.a, str4);
                                i6 |= 4;
                                i3 = 5;
                            case 3:
                                zB2 = cVarB.B(serialDescriptor, 3);
                                i6 |= 8;
                            case 4:
                                set3 = (Set) cVarB.H(serialDescriptor, 4, kSerializerArr[4], set3);
                                i6 |= 16;
                            case 5:
                                i5 = cVarB.i(serialDescriptor, i3);
                                i6 |= 32;
                            case 6:
                                messageState2 = (MessageState) cVarB.E(serialDescriptor, 6, kSerializerArr[6], messageState2);
                                i6 |= 64;
                            default:
                                throw new UnknownFieldException(iO);
                        }
                    }
                    i = i5;
                    messageState = messageState2;
                    set = set3;
                    z = zB2;
                    i2 = i6;
                    str = strN2;
                    list = list3;
                    str2 = str4;
                }
                cVarB.c(serialDescriptor);
                return new Album(i2, str, list, str2, z, set, i, messageState, (AbstractC21618tq6) null);
            }

            @Override // ir.nasim.InterfaceC22798vq6
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final void serialize(Encoder encoder, Album album) {
                AbstractC13042fc3.i(encoder, "encoder");
                AbstractC13042fc3.i(album, "value");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.d dVarB = encoder.b(serialDescriptor);
                Album.write$Self$database_release(album, dVarB, serialDescriptor);
                dVarB.c(serialDescriptor);
            }

            @Override // ir.nasim.NE2
            public final KSerializer[] childSerializers() {
                KSerializer[] kSerializerArr = Album.$childSerializers;
                VY6 vy6 = VY6.a;
                return new KSerializer[]{vy6, kSerializerArr[1], AbstractC18503om0.p(vy6), C8044Uh0.a, AbstractC18503om0.p(kSerializerArr[4]), C3712Ca3.a, kSerializerArr[6]};
            }

            @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
            public final SerialDescriptor getDescriptor() {
                return b;
            }

            @Override // ir.nasim.NE2
            public KSerializer[] typeParametersSerializers() {
                return NE2.a.a(this);
            }
        }

        /* renamed from: ir.nasim.database.dailogLists.DialogLastMessage$Album$b, reason: from kotlin metadata */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer serializer() {
                return a.a;
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ Album(int i, String str, List list, String str2, boolean z, Set set, int i2, MessageState messageState, AbstractC21618tq6 abstractC21618tq6) {
            if (11 != (i & 11)) {
                AbstractC19039pg5.a(i, 11, a.a.getDescriptor());
            }
            this.content = str;
            this.thumbnailItems = list;
            if ((i & 4) == 0) {
                this.senderNamePlaceHolder = null;
            } else {
                this.senderNamePlaceHolder = str2;
            }
            this.isMine = z;
            if ((i & 16) == 0) {
                this.userNamePlaceHolders = null;
            } else {
                this.userNamePlaceHolders = set;
            }
            if ((i & 32) == 0) {
                this.senderUid = 0;
            } else {
                this.senderUid = i2;
            }
            if ((i & 64) == 0) {
                this.state = MessageState.Unknown;
            } else {
                this.state = messageState;
            }
        }

        public static /* synthetic */ Album copy$default(Album album, String str, List list, String str2, boolean z, Set set, int i, MessageState messageState, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = album.content;
            }
            if ((i2 & 2) != 0) {
                list = album.thumbnailItems;
            }
            List list2 = list;
            if ((i2 & 4) != 0) {
                str2 = album.senderNamePlaceHolder;
            }
            String str3 = str2;
            if ((i2 & 8) != 0) {
                z = album.isMine;
            }
            boolean z2 = z;
            if ((i2 & 16) != 0) {
                set = album.userNamePlaceHolders;
            }
            Set set2 = set;
            if ((i2 & 32) != 0) {
                i = album.senderUid;
            }
            int i3 = i;
            if ((i2 & 64) != 0) {
                messageState = album.state;
            }
            return album.copy(str, list2, str3, z2, set2, i3, messageState);
        }

        public static final /* synthetic */ void write$Self$database_release(Album self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            output.y(serialDesc, 0, self.content);
            output.B(serialDesc, 1, kSerializerArr[1], self.thumbnailItems);
            if (output.z(serialDesc, 2) || self.senderNamePlaceHolder != null) {
                output.m(serialDesc, 2, VY6.a, self.senderNamePlaceHolder);
            }
            output.x(serialDesc, 3, self.isMine());
            if (output.z(serialDesc, 4) || self.getUserNamePlaceHolders() != null) {
                output.m(serialDesc, 4, kSerializerArr[4], self.getUserNamePlaceHolders());
            }
            if (output.z(serialDesc, 5) || self.getSenderUid() != 0) {
                output.w(serialDesc, 5, self.getSenderUid());
            }
            if (!output.z(serialDesc, 6) && self.getState() == MessageState.Unknown) {
                return;
            }
            output.B(serialDesc, 6, kSerializerArr[6], self.getState());
        }

        /* renamed from: component1, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        public final List<FastThumbnailItemEntity> component2() {
            return this.thumbnailItems;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSenderNamePlaceHolder() {
            return this.senderNamePlaceHolder;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsMine() {
            return this.isMine;
        }

        public final Set<UserNamePlaceHolder> component5() {
            return this.userNamePlaceHolders;
        }

        /* renamed from: component6, reason: from getter */
        public final int getSenderUid() {
            return this.senderUid;
        }

        /* renamed from: component7, reason: from getter */
        public final MessageState getState() {
            return this.state;
        }

        public final Album copy(String content, List<FastThumbnailItemEntity> thumbnailItems, String senderNamePlaceHolder, boolean isMine, Set<UserNamePlaceHolder> userNamePlaceHolders, int senderUid, MessageState state) {
            AbstractC13042fc3.i(content, "content");
            AbstractC13042fc3.i(thumbnailItems, "thumbnailItems");
            AbstractC13042fc3.i(state, "state");
            return new Album(content, thumbnailItems, senderNamePlaceHolder, isMine, userNamePlaceHolders, senderUid, state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Album)) {
                return false;
            }
            Album album = (Album) other;
            return AbstractC13042fc3.d(this.content, album.content) && AbstractC13042fc3.d(this.thumbnailItems, album.thumbnailItems) && AbstractC13042fc3.d(this.senderNamePlaceHolder, album.senderNamePlaceHolder) && this.isMine == album.isMine && AbstractC13042fc3.d(this.userNamePlaceHolders, album.userNamePlaceHolders) && this.senderUid == album.senderUid && this.state == album.state;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getSenderNamePlaceHolder() {
            return this.senderNamePlaceHolder;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public int getSenderUid() {
            return this.senderUid;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public MessageState getState() {
            return this.state;
        }

        public final List<FastThumbnailItemEntity> getThumbnailItems() {
            return this.thumbnailItems;
        }

        @Override // ir.nasim.U74
        public Set<UserNamePlaceHolder> getUserNamePlaceHolders() {
            return this.userNamePlaceHolders;
        }

        public int hashCode() {
            int iHashCode = ((this.content.hashCode() * 31) + this.thumbnailItems.hashCode()) * 31;
            String str = this.senderNamePlaceHolder;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isMine)) * 31;
            Set<UserNamePlaceHolder> set = this.userNamePlaceHolders;
            return ((((iHashCode2 + (set != null ? set.hashCode() : 0)) * 31) + Integer.hashCode(this.senderUid)) * 31) + this.state.hashCode();
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public boolean isMine() {
            return this.isMine;
        }

        public String toString() {
            return "Album(content=" + this.content + ", thumbnailItems=" + this.thumbnailItems + ", senderNamePlaceHolder=" + this.senderNamePlaceHolder + ", isMine=" + this.isMine + ", userNamePlaceHolders=" + this.userNamePlaceHolders + ", senderUid=" + this.senderUid + ", state=" + this.state + Separators.RPAREN;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public Album setState(MessageState state) {
            AbstractC13042fc3.i(state, "state");
            return copy$default(this, null, null, null, false, null, 0, state, 63, null);
        }

        public Album(String str, List<FastThumbnailItemEntity> list, String str2, boolean z, Set<UserNamePlaceHolder> set, int i, MessageState messageState) {
            AbstractC13042fc3.i(str, "content");
            AbstractC13042fc3.i(list, "thumbnailItems");
            AbstractC13042fc3.i(messageState, "state");
            this.content = str;
            this.thumbnailItems = list;
            this.senderNamePlaceHolder = str2;
            this.isMine = z;
            this.userNamePlaceHolders = set;
            this.senderUid = i;
            this.state = messageState;
        }

        public /* synthetic */ Album(String str, List list, String str2, boolean z, Set set, int i, MessageState messageState, int i2, ED1 ed1) {
            this(str, list, (i2 & 4) != 0 ? null : str2, z, (i2 & 16) != 0 ? null : set, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? MessageState.Unknown : messageState);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0087\b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0002ABBG\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011BY\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0010\u0010\u0015J'\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b%\u0010&J\u0018\u0010'\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b+\u0010,JV\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b/\u0010$J\u0010\u00100\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b0\u0010*J\u001a\u00103\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u000101HÖ\u0003¢\u0006\u0004\b3\u00104R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u00105\u001a\u0004\b6\u0010\"R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u00107\u001a\u0004\b8\u0010$R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u00109\u001a\u0004\b\b\u0010&R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010:\u001a\u0004\b;\u0010(R\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010<\u001a\u0004\b=\u0010*R\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010>\u001a\u0004\b?\u0010,¨\u0006C"}, d2 = {"Lir/nasim/database/dailogLists/DialogLastMessage$Call;", "Lir/nasim/database/dailogLists/DialogLastMessage;", "Lir/nasim/U74;", "Lir/nasim/database/dailogLists/g;", "type", "", ParameterNames.TEXT, "", "isMine", "", "Lir/nasim/database/dailogLists/UserNamePlaceHolder;", "userNamePlaceHolders", "", "senderUid", "Lir/nasim/database/dailogLists/MessageState;", "state", "<init>", "(Lir/nasim/database/dailogLists/g;Ljava/lang/String;ZLjava/util/Set;ILir/nasim/database/dailogLists/MessageState;)V", "seen0", "Lir/nasim/tq6;", "serializationConstructorMarker", "(ILir/nasim/database/dailogLists/g;Ljava/lang/String;ZLjava/util/Set;ILir/nasim/database/dailogLists/MessageState;Lir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "write$Self$database_release", "(Lir/nasim/database/dailogLists/DialogLastMessage$Call;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "setState", "(Lir/nasim/database/dailogLists/MessageState;)Lir/nasim/database/dailogLists/DialogLastMessage$Call;", "component1", "()Lir/nasim/database/dailogLists/g;", "component2", "()Ljava/lang/String;", "component3", "()Z", "component4", "()Ljava/util/Set;", "component5", "()I", "component6", "()Lir/nasim/database/dailogLists/MessageState;", "copy", "(Lir/nasim/database/dailogLists/g;Ljava/lang/String;ZLjava/util/Set;ILir/nasim/database/dailogLists/MessageState;)Lir/nasim/database/dailogLists/DialogLastMessage$Call;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/database/dailogLists/g;", "getType", "Ljava/lang/String;", "getText", "Z", "Ljava/util/Set;", "getUserNamePlaceHolders", TokenNames.I, "getSenderUid", "Lir/nasim/database/dailogLists/MessageState;", "getState", "Companion", "a", "b", "database_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Call implements DialogLastMessage, U74 {
        private final boolean isMine;
        private final int senderUid;
        private final MessageState state;
        private final String text;
        private final g type;
        private final Set<UserNamePlaceHolder> userNamePlaceHolders;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {g.INSTANCE.serializer(), null, null, new C18752pB3(UserNamePlaceHolder.a.a), null, Q92.b("ir.nasim.database.dailogLists.MessageState", MessageState.values())};

        public /* synthetic */ class a implements NE2 {
            public static final a a;
            private static final SerialDescriptor b;

            static {
                a aVar = new a();
                a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("call", aVar, 6);
                pluginGeneratedSerialDescriptor.l("type", false);
                pluginGeneratedSerialDescriptor.l(ParameterNames.TEXT, false);
                pluginGeneratedSerialDescriptor.l("isMine", false);
                pluginGeneratedSerialDescriptor.l("userNamePlaceHolders", true);
                pluginGeneratedSerialDescriptor.l("senderUid", true);
                pluginGeneratedSerialDescriptor.l("state", true);
                pluginGeneratedSerialDescriptor.s(new Text.a.C1011a("_messageType"));
                b = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // ir.nasim.XI1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Call deserialize(Decoder decoder) {
                int i;
                boolean z;
                int i2;
                g gVar;
                String str;
                Set set;
                MessageState messageState;
                AbstractC13042fc3.i(decoder, "decoder");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.c cVarB = decoder.b(serialDescriptor);
                KSerializer[] kSerializerArr = Call.$childSerializers;
                int i3 = 4;
                if (cVarB.p()) {
                    g gVar2 = (g) cVarB.H(serialDescriptor, 0, kSerializerArr[0], null);
                    String strN = cVarB.n(serialDescriptor, 1);
                    boolean zB = cVarB.B(serialDescriptor, 2);
                    Set set2 = (Set) cVarB.H(serialDescriptor, 3, kSerializerArr[3], null);
                    int i4 = cVarB.i(serialDescriptor, 4);
                    messageState = (MessageState) cVarB.E(serialDescriptor, 5, kSerializerArr[5], null);
                    gVar = gVar2;
                    i = i4;
                    z = zB;
                    i2 = 63;
                    set = set2;
                    str = strN;
                } else {
                    boolean z2 = true;
                    int i5 = 0;
                    int i6 = 0;
                    g gVar3 = null;
                    String strN2 = null;
                    Set set3 = null;
                    MessageState messageState2 = null;
                    boolean zB2 = false;
                    while (z2) {
                        int iO = cVarB.o(serialDescriptor);
                        switch (iO) {
                            case -1:
                                z2 = false;
                                continue;
                            case 0:
                                gVar3 = (g) cVarB.H(serialDescriptor, 0, kSerializerArr[0], gVar3);
                                i6 |= 1;
                                i3 = 4;
                                continue;
                            case 1:
                                strN2 = cVarB.n(serialDescriptor, 1);
                                i6 |= 2;
                                break;
                            case 2:
                                zB2 = cVarB.B(serialDescriptor, 2);
                                i6 |= 4;
                                break;
                            case 3:
                                set3 = (Set) cVarB.H(serialDescriptor, 3, kSerializerArr[3], set3);
                                i6 |= 8;
                                break;
                            case 4:
                                i5 = cVarB.i(serialDescriptor, i3);
                                i6 |= 16;
                                break;
                            case 5:
                                messageState2 = (MessageState) cVarB.E(serialDescriptor, 5, kSerializerArr[5], messageState2);
                                i6 |= 32;
                                break;
                            default:
                                throw new UnknownFieldException(iO);
                        }
                    }
                    i = i5;
                    z = zB2;
                    i2 = i6;
                    gVar = gVar3;
                    str = strN2;
                    set = set3;
                    messageState = messageState2;
                }
                cVarB.c(serialDescriptor);
                return new Call(i2, gVar, str, z, set, i, messageState, (AbstractC21618tq6) null);
            }

            @Override // ir.nasim.InterfaceC22798vq6
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final void serialize(Encoder encoder, Call call) {
                AbstractC13042fc3.i(encoder, "encoder");
                AbstractC13042fc3.i(call, "value");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.d dVarB = encoder.b(serialDescriptor);
                Call.write$Self$database_release(call, dVarB, serialDescriptor);
                dVarB.c(serialDescriptor);
            }

            @Override // ir.nasim.NE2
            public final KSerializer[] childSerializers() {
                KSerializer[] kSerializerArr = Call.$childSerializers;
                return new KSerializer[]{AbstractC18503om0.p(kSerializerArr[0]), VY6.a, C8044Uh0.a, AbstractC18503om0.p(kSerializerArr[3]), C3712Ca3.a, kSerializerArr[5]};
            }

            @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
            public final SerialDescriptor getDescriptor() {
                return b;
            }

            @Override // ir.nasim.NE2
            public KSerializer[] typeParametersSerializers() {
                return NE2.a.a(this);
            }
        }

        /* renamed from: ir.nasim.database.dailogLists.DialogLastMessage$Call$b, reason: from kotlin metadata */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer serializer() {
                return a.a;
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ Call(int i, g gVar, String str, boolean z, Set set, int i2, MessageState messageState, AbstractC21618tq6 abstractC21618tq6) {
            if (7 != (i & 7)) {
                AbstractC19039pg5.a(i, 7, a.a.getDescriptor());
            }
            this.type = gVar;
            this.text = str;
            this.isMine = z;
            if ((i & 8) == 0) {
                this.userNamePlaceHolders = null;
            } else {
                this.userNamePlaceHolders = set;
            }
            if ((i & 16) == 0) {
                this.senderUid = 0;
            } else {
                this.senderUid = i2;
            }
            if ((i & 32) == 0) {
                this.state = MessageState.Unknown;
            } else {
                this.state = messageState;
            }
        }

        public static /* synthetic */ Call copy$default(Call call, g gVar, String str, boolean z, Set set, int i, MessageState messageState, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                gVar = call.type;
            }
            if ((i2 & 2) != 0) {
                str = call.text;
            }
            String str2 = str;
            if ((i2 & 4) != 0) {
                z = call.isMine;
            }
            boolean z2 = z;
            if ((i2 & 8) != 0) {
                set = call.userNamePlaceHolders;
            }
            Set set2 = set;
            if ((i2 & 16) != 0) {
                i = call.senderUid;
            }
            int i3 = i;
            if ((i2 & 32) != 0) {
                messageState = call.state;
            }
            return call.copy(gVar, str2, z2, set2, i3, messageState);
        }

        public static final /* synthetic */ void write$Self$database_release(Call self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            output.m(serialDesc, 0, kSerializerArr[0], self.type);
            output.y(serialDesc, 1, self.text);
            output.x(serialDesc, 2, self.isMine());
            if (output.z(serialDesc, 3) || self.getUserNamePlaceHolders() != null) {
                output.m(serialDesc, 3, kSerializerArr[3], self.getUserNamePlaceHolders());
            }
            if (output.z(serialDesc, 4) || self.getSenderUid() != 0) {
                output.w(serialDesc, 4, self.getSenderUid());
            }
            if (!output.z(serialDesc, 5) && self.getState() == MessageState.Unknown) {
                return;
            }
            output.B(serialDesc, 5, kSerializerArr[5], self.getState());
        }

        /* renamed from: component1, reason: from getter */
        public final g getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsMine() {
            return this.isMine;
        }

        public final Set<UserNamePlaceHolder> component4() {
            return this.userNamePlaceHolders;
        }

        /* renamed from: component5, reason: from getter */
        public final int getSenderUid() {
            return this.senderUid;
        }

        /* renamed from: component6, reason: from getter */
        public final MessageState getState() {
            return this.state;
        }

        public final Call copy(g type, String text, boolean isMine, Set<UserNamePlaceHolder> userNamePlaceHolders, int senderUid, MessageState state) {
            AbstractC13042fc3.i(text, ParameterNames.TEXT);
            AbstractC13042fc3.i(state, "state");
            return new Call(type, text, isMine, userNamePlaceHolders, senderUid, state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Call)) {
                return false;
            }
            Call call = (Call) other;
            return this.type == call.type && AbstractC13042fc3.d(this.text, call.text) && this.isMine == call.isMine && AbstractC13042fc3.d(this.userNamePlaceHolders, call.userNamePlaceHolders) && this.senderUid == call.senderUid && this.state == call.state;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public int getSenderUid() {
            return this.senderUid;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public MessageState getState() {
            return this.state;
        }

        public final String getText() {
            return this.text;
        }

        public final g getType() {
            return this.type;
        }

        @Override // ir.nasim.U74
        public Set<UserNamePlaceHolder> getUserNamePlaceHolders() {
            return this.userNamePlaceHolders;
        }

        public int hashCode() {
            g gVar = this.type;
            int iHashCode = (((((gVar == null ? 0 : gVar.hashCode()) * 31) + this.text.hashCode()) * 31) + Boolean.hashCode(this.isMine)) * 31;
            Set<UserNamePlaceHolder> set = this.userNamePlaceHolders;
            return ((((iHashCode + (set != null ? set.hashCode() : 0)) * 31) + Integer.hashCode(this.senderUid)) * 31) + this.state.hashCode();
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public boolean isMine() {
            return this.isMine;
        }

        public String toString() {
            return "Call(type=" + this.type + ", text=" + this.text + ", isMine=" + this.isMine + ", userNamePlaceHolders=" + this.userNamePlaceHolders + ", senderUid=" + this.senderUid + ", state=" + this.state + Separators.RPAREN;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public Call setState(MessageState state) {
            AbstractC13042fc3.i(state, "state");
            return copy$default(this, null, null, false, null, 0, state, 31, null);
        }

        public Call(g gVar, String str, boolean z, Set<UserNamePlaceHolder> set, int i, MessageState messageState) {
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC13042fc3.i(messageState, "state");
            this.type = gVar;
            this.text = str;
            this.isMine = z;
            this.userNamePlaceHolders = set;
            this.senderUid = i;
            this.state = messageState;
        }

        public /* synthetic */ Call(g gVar, String str, boolean z, Set set, int i, MessageState messageState, int i2, ED1 ed1) {
            this(gVar, str, z, (i2 & 8) != 0 ? null : set, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? MessageState.Unknown : messageState);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0087\b\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0002>?BI\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010BY\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000f\u0010\u0014J'\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b \u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\"\u0010!J\u0010\u0010#\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b)\u0010*JV\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b-\u0010!J\u0010\u0010.\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b.\u0010&J\u001a\u00101\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010/HÖ\u0003¢\u0006\u0004\b1\u00102R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u00103\u001a\u0004\b4\u0010!R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u00103\u001a\u0004\b5\u0010!R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u00106\u001a\u0004\b\u0007\u0010$R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u00107\u001a\u0004\b8\u0010&R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u00109\u001a\u0004\b:\u0010(R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010;\u001a\u0004\b<\u0010*¨\u0006@"}, d2 = {"Lir/nasim/database/dailogLists/DialogLastMessage$Document;", "Lir/nasim/database/dailogLists/DialogLastMessage;", "Lir/nasim/U74;", "", ParameterNames.TEXT, "thumb", "", "isMine", "", "senderUid", "Lir/nasim/database/dailogLists/MessageState;", "state", "", "Lir/nasim/database/dailogLists/UserNamePlaceHolder;", "userNamePlaceHolders", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZILir/nasim/database/dailogLists/MessageState;Ljava/util/Set;)V", "seen0", "Lir/nasim/tq6;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;ZILir/nasim/database/dailogLists/MessageState;Ljava/util/Set;Lir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "write$Self$database_release", "(Lir/nasim/database/dailogLists/DialogLastMessage$Document;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "setState", "(Lir/nasim/database/dailogLists/MessageState;)Lir/nasim/database/dailogLists/DialogLastMessage$Document;", "component1", "()Ljava/lang/String;", "component2", "component3", "()Z", "component4", "()I", "component5", "()Lir/nasim/database/dailogLists/MessageState;", "component6", "()Ljava/util/Set;", "copy", "(Ljava/lang/String;Ljava/lang/String;ZILir/nasim/database/dailogLists/MessageState;Ljava/util/Set;)Lir/nasim/database/dailogLists/DialogLastMessage$Document;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "getThumb", "Z", TokenNames.I, "getSenderUid", "Lir/nasim/database/dailogLists/MessageState;", "getState", "Ljava/util/Set;", "getUserNamePlaceHolders", "Companion", "a", "b", "database_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Document implements DialogLastMessage, U74 {
        private final boolean isMine;
        private final int senderUid;
        private final MessageState state;
        private final String text;
        private final String thumb;
        private final Set<UserNamePlaceHolder> userNamePlaceHolders;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {null, null, null, null, Q92.b("ir.nasim.database.dailogLists.MessageState", MessageState.values()), new C18752pB3(UserNamePlaceHolder.a.a)};

        public /* synthetic */ class a implements NE2 {
            public static final a a;
            private static final SerialDescriptor b;

            static {
                a aVar = new a();
                a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("document", aVar, 6);
                pluginGeneratedSerialDescriptor.l(ParameterNames.TEXT, false);
                pluginGeneratedSerialDescriptor.l("thumb", true);
                pluginGeneratedSerialDescriptor.l("isMine", false);
                pluginGeneratedSerialDescriptor.l("senderUid", true);
                pluginGeneratedSerialDescriptor.l("state", true);
                pluginGeneratedSerialDescriptor.l("userNamePlaceHolders", true);
                pluginGeneratedSerialDescriptor.s(new Text.a.C1011a("_messageType"));
                b = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // ir.nasim.XI1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Document deserialize(Decoder decoder) {
                int i;
                boolean z;
                int i2;
                String str;
                String str2;
                MessageState messageState;
                Set set;
                AbstractC13042fc3.i(decoder, "decoder");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.c cVarB = decoder.b(serialDescriptor);
                KSerializer[] kSerializerArr = Document.$childSerializers;
                if (cVarB.p()) {
                    String strN = cVarB.n(serialDescriptor, 0);
                    String str3 = (String) cVarB.H(serialDescriptor, 1, VY6.a, null);
                    boolean zB = cVarB.B(serialDescriptor, 2);
                    int i3 = cVarB.i(serialDescriptor, 3);
                    MessageState messageState2 = (MessageState) cVarB.E(serialDescriptor, 4, kSerializerArr[4], null);
                    set = (Set) cVarB.H(serialDescriptor, 5, kSerializerArr[5], null);
                    str = strN;
                    i = i3;
                    z = zB;
                    i2 = 63;
                    messageState = messageState2;
                    str2 = str3;
                } else {
                    boolean z2 = true;
                    int i4 = 0;
                    int i5 = 0;
                    String strN2 = null;
                    String str4 = null;
                    MessageState messageState3 = null;
                    Set set2 = null;
                    boolean zB2 = false;
                    while (z2) {
                        int iO = cVarB.o(serialDescriptor);
                        switch (iO) {
                            case -1:
                                z2 = false;
                                continue;
                            case 0:
                                strN2 = cVarB.n(serialDescriptor, 0);
                                i5 |= 1;
                                continue;
                            case 1:
                                str4 = (String) cVarB.H(serialDescriptor, 1, VY6.a, str4);
                                i5 |= 2;
                                break;
                            case 2:
                                zB2 = cVarB.B(serialDescriptor, 2);
                                i5 |= 4;
                                break;
                            case 3:
                                i4 = cVarB.i(serialDescriptor, 3);
                                i5 |= 8;
                                break;
                            case 4:
                                messageState3 = (MessageState) cVarB.E(serialDescriptor, 4, kSerializerArr[4], messageState3);
                                i5 |= 16;
                                break;
                            case 5:
                                set2 = (Set) cVarB.H(serialDescriptor, 5, kSerializerArr[5], set2);
                                i5 |= 32;
                                break;
                            default:
                                throw new UnknownFieldException(iO);
                        }
                    }
                    i = i4;
                    z = zB2;
                    i2 = i5;
                    str = strN2;
                    str2 = str4;
                    messageState = messageState3;
                    set = set2;
                }
                cVarB.c(serialDescriptor);
                return new Document(i2, str, str2, z, i, messageState, set, (AbstractC21618tq6) null);
            }

            @Override // ir.nasim.InterfaceC22798vq6
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final void serialize(Encoder encoder, Document document) {
                AbstractC13042fc3.i(encoder, "encoder");
                AbstractC13042fc3.i(document, "value");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.d dVarB = encoder.b(serialDescriptor);
                Document.write$Self$database_release(document, dVarB, serialDescriptor);
                dVarB.c(serialDescriptor);
            }

            @Override // ir.nasim.NE2
            public final KSerializer[] childSerializers() {
                KSerializer[] kSerializerArr = Document.$childSerializers;
                VY6 vy6 = VY6.a;
                return new KSerializer[]{vy6, AbstractC18503om0.p(vy6), C8044Uh0.a, C3712Ca3.a, kSerializerArr[4], AbstractC18503om0.p(kSerializerArr[5])};
            }

            @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
            public final SerialDescriptor getDescriptor() {
                return b;
            }

            @Override // ir.nasim.NE2
            public KSerializer[] typeParametersSerializers() {
                return NE2.a.a(this);
            }
        }

        /* renamed from: ir.nasim.database.dailogLists.DialogLastMessage$Document$b, reason: from kotlin metadata */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer serializer() {
                return a.a;
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ Document(int i, String str, String str2, boolean z, int i2, MessageState messageState, Set set, AbstractC21618tq6 abstractC21618tq6) {
            if (5 != (i & 5)) {
                AbstractC19039pg5.a(i, 5, a.a.getDescriptor());
            }
            this.text = str;
            if ((i & 2) == 0) {
                this.thumb = null;
            } else {
                this.thumb = str2;
            }
            this.isMine = z;
            if ((i & 8) == 0) {
                this.senderUid = 0;
            } else {
                this.senderUid = i2;
            }
            if ((i & 16) == 0) {
                this.state = MessageState.Unknown;
            } else {
                this.state = messageState;
            }
            if ((i & 32) == 0) {
                this.userNamePlaceHolders = null;
            } else {
                this.userNamePlaceHolders = set;
            }
        }

        public static /* synthetic */ Document copy$default(Document document, String str, String str2, boolean z, int i, MessageState messageState, Set set, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = document.text;
            }
            if ((i2 & 2) != 0) {
                str2 = document.thumb;
            }
            String str3 = str2;
            if ((i2 & 4) != 0) {
                z = document.isMine;
            }
            boolean z2 = z;
            if ((i2 & 8) != 0) {
                i = document.senderUid;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                messageState = document.state;
            }
            MessageState messageState2 = messageState;
            if ((i2 & 32) != 0) {
                set = document.userNamePlaceHolders;
            }
            return document.copy(str, str3, z2, i3, messageState2, set);
        }

        public static final /* synthetic */ void write$Self$database_release(Document self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            output.y(serialDesc, 0, self.text);
            if (output.z(serialDesc, 1) || self.thumb != null) {
                output.m(serialDesc, 1, VY6.a, self.thumb);
            }
            output.x(serialDesc, 2, self.isMine());
            if (output.z(serialDesc, 3) || self.getSenderUid() != 0) {
                output.w(serialDesc, 3, self.getSenderUid());
            }
            if (output.z(serialDesc, 4) || self.getState() != MessageState.Unknown) {
                output.B(serialDesc, 4, kSerializerArr[4], self.getState());
            }
            if (!output.z(serialDesc, 5) && self.getUserNamePlaceHolders() == null) {
                return;
            }
            output.m(serialDesc, 5, kSerializerArr[5], self.getUserNamePlaceHolders());
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final String getThumb() {
            return this.thumb;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsMine() {
            return this.isMine;
        }

        /* renamed from: component4, reason: from getter */
        public final int getSenderUid() {
            return this.senderUid;
        }

        /* renamed from: component5, reason: from getter */
        public final MessageState getState() {
            return this.state;
        }

        public final Set<UserNamePlaceHolder> component6() {
            return this.userNamePlaceHolders;
        }

        public final Document copy(String text, String thumb, boolean isMine, int senderUid, MessageState state, Set<UserNamePlaceHolder> userNamePlaceHolders) {
            AbstractC13042fc3.i(text, ParameterNames.TEXT);
            AbstractC13042fc3.i(state, "state");
            return new Document(text, thumb, isMine, senderUid, state, userNamePlaceHolders);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Document)) {
                return false;
            }
            Document document = (Document) other;
            return AbstractC13042fc3.d(this.text, document.text) && AbstractC13042fc3.d(this.thumb, document.thumb) && this.isMine == document.isMine && this.senderUid == document.senderUid && this.state == document.state && AbstractC13042fc3.d(this.userNamePlaceHolders, document.userNamePlaceHolders);
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public int getSenderUid() {
            return this.senderUid;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public MessageState getState() {
            return this.state;
        }

        public final String getText() {
            return this.text;
        }

        public final String getThumb() {
            return this.thumb;
        }

        @Override // ir.nasim.U74
        public Set<UserNamePlaceHolder> getUserNamePlaceHolders() {
            return this.userNamePlaceHolders;
        }

        public int hashCode() {
            int iHashCode = this.text.hashCode() * 31;
            String str = this.thumb;
            int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isMine)) * 31) + Integer.hashCode(this.senderUid)) * 31) + this.state.hashCode()) * 31;
            Set<UserNamePlaceHolder> set = this.userNamePlaceHolders;
            return iHashCode2 + (set != null ? set.hashCode() : 0);
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public boolean isMine() {
            return this.isMine;
        }

        public String toString() {
            return "Document(text=" + this.text + ", thumb=" + this.thumb + ", isMine=" + this.isMine + ", senderUid=" + this.senderUid + ", state=" + this.state + ", userNamePlaceHolders=" + this.userNamePlaceHolders + Separators.RPAREN;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public Document setState(MessageState state) {
            AbstractC13042fc3.i(state, "state");
            return copy$default(this, null, null, false, 0, state, null, 47, null);
        }

        public Document(String str, String str2, boolean z, int i, MessageState messageState, Set<UserNamePlaceHolder> set) {
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC13042fc3.i(messageState, "state");
            this.text = str;
            this.thumb = str2;
            this.isMine = z;
            this.senderUid = i;
            this.state = messageState;
            this.userNamePlaceHolders = set;
        }

        public /* synthetic */ Document(String str, String str2, boolean z, int i, MessageState messageState, Set set, int i2, ED1 ed1) {
            this(str, (i2 & 2) != 0 ? null : str2, z, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? MessageState.Unknown : messageState, (i2 & 32) != 0 ? null : set);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0087\b\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0002>?BI\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010BY\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000f\u0010\u0014J'\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b \u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\"\u0010!J\u0010\u0010#\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b)\u0010*JV\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b-\u0010!J\u0010\u0010.\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b.\u0010&J\u001a\u00101\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010/HÖ\u0003¢\u0006\u0004\b1\u00102R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u00103\u001a\u0004\b4\u0010!R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u00103\u001a\u0004\b5\u0010!R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u00106\u001a\u0004\b\u0007\u0010$R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u00107\u001a\u0004\b8\u0010&R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u00109\u001a\u0004\b:\u0010(R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010;\u001a\u0004\b<\u0010*¨\u0006@"}, d2 = {"Lir/nasim/database/dailogLists/DialogLastMessage$Link;", "Lir/nasim/database/dailogLists/DialogLastMessage;", "Lir/nasim/U74;", "", ParameterNames.TEXT, "senderNamePlaceHolder", "", "isMine", "", "senderUid", "Lir/nasim/database/dailogLists/MessageState;", "state", "", "Lir/nasim/database/dailogLists/UserNamePlaceHolder;", "userNamePlaceHolders", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZILir/nasim/database/dailogLists/MessageState;Ljava/util/Set;)V", "seen0", "Lir/nasim/tq6;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;ZILir/nasim/database/dailogLists/MessageState;Ljava/util/Set;Lir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "write$Self$database_release", "(Lir/nasim/database/dailogLists/DialogLastMessage$Link;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "setState", "(Lir/nasim/database/dailogLists/MessageState;)Lir/nasim/database/dailogLists/DialogLastMessage$Link;", "component1", "()Ljava/lang/String;", "component2", "component3", "()Z", "component4", "()I", "component5", "()Lir/nasim/database/dailogLists/MessageState;", "component6", "()Ljava/util/Set;", "copy", "(Ljava/lang/String;Ljava/lang/String;ZILir/nasim/database/dailogLists/MessageState;Ljava/util/Set;)Lir/nasim/database/dailogLists/DialogLastMessage$Link;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "getSenderNamePlaceHolder", "Z", TokenNames.I, "getSenderUid", "Lir/nasim/database/dailogLists/MessageState;", "getState", "Ljava/util/Set;", "getUserNamePlaceHolders", "Companion", "a", "b", "database_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Link implements DialogLastMessage, U74 {
        private final boolean isMine;
        private final String senderNamePlaceHolder;
        private final int senderUid;
        private final MessageState state;
        private final String text;
        private final Set<UserNamePlaceHolder> userNamePlaceHolders;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {null, null, null, null, Q92.b("ir.nasim.database.dailogLists.MessageState", MessageState.values()), new C18752pB3(UserNamePlaceHolder.a.a)};

        public /* synthetic */ class a implements NE2 {
            public static final a a;
            private static final SerialDescriptor b;

            static {
                a aVar = new a();
                a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("link", aVar, 6);
                pluginGeneratedSerialDescriptor.l(ParameterNames.TEXT, false);
                pluginGeneratedSerialDescriptor.l("senderNamePlaceHolder", true);
                pluginGeneratedSerialDescriptor.l("isMine", false);
                pluginGeneratedSerialDescriptor.l("senderUid", true);
                pluginGeneratedSerialDescriptor.l("state", true);
                pluginGeneratedSerialDescriptor.l("userNamePlaceHolders", true);
                pluginGeneratedSerialDescriptor.s(new Text.a.C1011a("_messageType"));
                b = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // ir.nasim.XI1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Link deserialize(Decoder decoder) {
                int i;
                boolean z;
                int i2;
                String str;
                String str2;
                MessageState messageState;
                Set set;
                AbstractC13042fc3.i(decoder, "decoder");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.c cVarB = decoder.b(serialDescriptor);
                KSerializer[] kSerializerArr = Link.$childSerializers;
                if (cVarB.p()) {
                    String strN = cVarB.n(serialDescriptor, 0);
                    String str3 = (String) cVarB.H(serialDescriptor, 1, VY6.a, null);
                    boolean zB = cVarB.B(serialDescriptor, 2);
                    int i3 = cVarB.i(serialDescriptor, 3);
                    MessageState messageState2 = (MessageState) cVarB.E(serialDescriptor, 4, kSerializerArr[4], null);
                    set = (Set) cVarB.H(serialDescriptor, 5, kSerializerArr[5], null);
                    str = strN;
                    i = i3;
                    z = zB;
                    i2 = 63;
                    messageState = messageState2;
                    str2 = str3;
                } else {
                    boolean z2 = true;
                    int i4 = 0;
                    int i5 = 0;
                    String strN2 = null;
                    String str4 = null;
                    MessageState messageState3 = null;
                    Set set2 = null;
                    boolean zB2 = false;
                    while (z2) {
                        int iO = cVarB.o(serialDescriptor);
                        switch (iO) {
                            case -1:
                                z2 = false;
                                continue;
                            case 0:
                                strN2 = cVarB.n(serialDescriptor, 0);
                                i5 |= 1;
                                continue;
                            case 1:
                                str4 = (String) cVarB.H(serialDescriptor, 1, VY6.a, str4);
                                i5 |= 2;
                                break;
                            case 2:
                                zB2 = cVarB.B(serialDescriptor, 2);
                                i5 |= 4;
                                break;
                            case 3:
                                i4 = cVarB.i(serialDescriptor, 3);
                                i5 |= 8;
                                break;
                            case 4:
                                messageState3 = (MessageState) cVarB.E(serialDescriptor, 4, kSerializerArr[4], messageState3);
                                i5 |= 16;
                                break;
                            case 5:
                                set2 = (Set) cVarB.H(serialDescriptor, 5, kSerializerArr[5], set2);
                                i5 |= 32;
                                break;
                            default:
                                throw new UnknownFieldException(iO);
                        }
                    }
                    i = i4;
                    z = zB2;
                    i2 = i5;
                    str = strN2;
                    str2 = str4;
                    messageState = messageState3;
                    set = set2;
                }
                cVarB.c(serialDescriptor);
                return new Link(i2, str, str2, z, i, messageState, set, (AbstractC21618tq6) null);
            }

            @Override // ir.nasim.InterfaceC22798vq6
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final void serialize(Encoder encoder, Link link) {
                AbstractC13042fc3.i(encoder, "encoder");
                AbstractC13042fc3.i(link, "value");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.d dVarB = encoder.b(serialDescriptor);
                Link.write$Self$database_release(link, dVarB, serialDescriptor);
                dVarB.c(serialDescriptor);
            }

            @Override // ir.nasim.NE2
            public final KSerializer[] childSerializers() {
                KSerializer[] kSerializerArr = Link.$childSerializers;
                VY6 vy6 = VY6.a;
                return new KSerializer[]{vy6, AbstractC18503om0.p(vy6), C8044Uh0.a, C3712Ca3.a, kSerializerArr[4], AbstractC18503om0.p(kSerializerArr[5])};
            }

            @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
            public final SerialDescriptor getDescriptor() {
                return b;
            }

            @Override // ir.nasim.NE2
            public KSerializer[] typeParametersSerializers() {
                return NE2.a.a(this);
            }
        }

        /* renamed from: ir.nasim.database.dailogLists.DialogLastMessage$Link$b, reason: from kotlin metadata */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer serializer() {
                return a.a;
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ Link(int i, String str, String str2, boolean z, int i2, MessageState messageState, Set set, AbstractC21618tq6 abstractC21618tq6) {
            if (5 != (i & 5)) {
                AbstractC19039pg5.a(i, 5, a.a.getDescriptor());
            }
            this.text = str;
            if ((i & 2) == 0) {
                this.senderNamePlaceHolder = null;
            } else {
                this.senderNamePlaceHolder = str2;
            }
            this.isMine = z;
            if ((i & 8) == 0) {
                this.senderUid = 0;
            } else {
                this.senderUid = i2;
            }
            if ((i & 16) == 0) {
                this.state = MessageState.Unknown;
            } else {
                this.state = messageState;
            }
            if ((i & 32) == 0) {
                this.userNamePlaceHolders = null;
            } else {
                this.userNamePlaceHolders = set;
            }
        }

        public static /* synthetic */ Link copy$default(Link link, String str, String str2, boolean z, int i, MessageState messageState, Set set, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = link.text;
            }
            if ((i2 & 2) != 0) {
                str2 = link.senderNamePlaceHolder;
            }
            String str3 = str2;
            if ((i2 & 4) != 0) {
                z = link.isMine;
            }
            boolean z2 = z;
            if ((i2 & 8) != 0) {
                i = link.senderUid;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                messageState = link.state;
            }
            MessageState messageState2 = messageState;
            if ((i2 & 32) != 0) {
                set = link.userNamePlaceHolders;
            }
            return link.copy(str, str3, z2, i3, messageState2, set);
        }

        public static final /* synthetic */ void write$Self$database_release(Link self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            output.y(serialDesc, 0, self.text);
            if (output.z(serialDesc, 1) || self.senderNamePlaceHolder != null) {
                output.m(serialDesc, 1, VY6.a, self.senderNamePlaceHolder);
            }
            output.x(serialDesc, 2, self.isMine());
            if (output.z(serialDesc, 3) || self.getSenderUid() != 0) {
                output.w(serialDesc, 3, self.getSenderUid());
            }
            if (output.z(serialDesc, 4) || self.getState() != MessageState.Unknown) {
                output.B(serialDesc, 4, kSerializerArr[4], self.getState());
            }
            if (!output.z(serialDesc, 5) && self.getUserNamePlaceHolders() == null) {
                return;
            }
            output.m(serialDesc, 5, kSerializerArr[5], self.getUserNamePlaceHolders());
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSenderNamePlaceHolder() {
            return this.senderNamePlaceHolder;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsMine() {
            return this.isMine;
        }

        /* renamed from: component4, reason: from getter */
        public final int getSenderUid() {
            return this.senderUid;
        }

        /* renamed from: component5, reason: from getter */
        public final MessageState getState() {
            return this.state;
        }

        public final Set<UserNamePlaceHolder> component6() {
            return this.userNamePlaceHolders;
        }

        public final Link copy(String text, String senderNamePlaceHolder, boolean isMine, int senderUid, MessageState state, Set<UserNamePlaceHolder> userNamePlaceHolders) {
            AbstractC13042fc3.i(text, ParameterNames.TEXT);
            AbstractC13042fc3.i(state, "state");
            return new Link(text, senderNamePlaceHolder, isMine, senderUid, state, userNamePlaceHolders);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Link)) {
                return false;
            }
            Link link = (Link) other;
            return AbstractC13042fc3.d(this.text, link.text) && AbstractC13042fc3.d(this.senderNamePlaceHolder, link.senderNamePlaceHolder) && this.isMine == link.isMine && this.senderUid == link.senderUid && this.state == link.state && AbstractC13042fc3.d(this.userNamePlaceHolders, link.userNamePlaceHolders);
        }

        public final String getSenderNamePlaceHolder() {
            return this.senderNamePlaceHolder;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public int getSenderUid() {
            return this.senderUid;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public MessageState getState() {
            return this.state;
        }

        public final String getText() {
            return this.text;
        }

        @Override // ir.nasim.U74
        public Set<UserNamePlaceHolder> getUserNamePlaceHolders() {
            return this.userNamePlaceHolders;
        }

        public int hashCode() {
            int iHashCode = this.text.hashCode() * 31;
            String str = this.senderNamePlaceHolder;
            int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isMine)) * 31) + Integer.hashCode(this.senderUid)) * 31) + this.state.hashCode()) * 31;
            Set<UserNamePlaceHolder> set = this.userNamePlaceHolders;
            return iHashCode2 + (set != null ? set.hashCode() : 0);
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public boolean isMine() {
            return this.isMine;
        }

        public String toString() {
            return "Link(text=" + this.text + ", senderNamePlaceHolder=" + this.senderNamePlaceHolder + ", isMine=" + this.isMine + ", senderUid=" + this.senderUid + ", state=" + this.state + ", userNamePlaceHolders=" + this.userNamePlaceHolders + Separators.RPAREN;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public Link setState(MessageState state) {
            AbstractC13042fc3.i(state, "state");
            return copy$default(this, null, null, false, 0, state, null, 47, null);
        }

        public Link(String str, String str2, boolean z, int i, MessageState messageState, Set<UserNamePlaceHolder> set) {
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC13042fc3.i(messageState, "state");
            this.text = str;
            this.senderNamePlaceHolder = str2;
            this.isMine = z;
            this.senderUid = i;
            this.state = messageState;
            this.userNamePlaceHolders = set;
        }

        public /* synthetic */ Link(String str, String str2, boolean z, int i, MessageState messageState, Set set, int i2, ED1 ed1) {
            this(str, (i2 & 2) != 0 ? null : str2, z, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? MessageState.Unknown : messageState, (i2 & 32) != 0 ? null : set);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000234B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB?\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\n\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b!\u0010\"J8\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010\u001cJ\u0010\u0010&\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b&\u0010 J\u001a\u0010)\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b\u0005\u0010\u001eR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010.\u001a\u0004\b/\u0010 R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b1\u0010\"¨\u00065"}, d2 = {"Lir/nasim/database/dailogLists/DialogLastMessage$Live;", "Lir/nasim/database/dailogLists/DialogLastMessage;", "", "caption", "", "isMine", "", "senderUid", "Lir/nasim/database/dailogLists/MessageState;", "state", "<init>", "(Ljava/lang/String;ZILir/nasim/database/dailogLists/MessageState;)V", "seen0", "Lir/nasim/tq6;", "serializationConstructorMarker", "(ILjava/lang/String;ZILir/nasim/database/dailogLists/MessageState;Lir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "write$Self$database_release", "(Lir/nasim/database/dailogLists/DialogLastMessage$Live;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "setState", "(Lir/nasim/database/dailogLists/MessageState;)Lir/nasim/database/dailogLists/DialogLastMessage$Live;", "component1", "()Ljava/lang/String;", "component2", "()Z", "component3", "()I", "component4", "()Lir/nasim/database/dailogLists/MessageState;", "copy", "(Ljava/lang/String;ZILir/nasim/database/dailogLists/MessageState;)Lir/nasim/database/dailogLists/DialogLastMessage$Live;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCaption", "Z", TokenNames.I, "getSenderUid", "Lir/nasim/database/dailogLists/MessageState;", "getState", "Companion", "a", "b", "database_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Live implements DialogLastMessage {
        private final String caption;
        private final boolean isMine;
        private final int senderUid;
        private final MessageState state;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {null, null, null, Q92.b("ir.nasim.database.dailogLists.MessageState", MessageState.values())};

        public /* synthetic */ class a implements NE2 {
            public static final a a;
            private static final SerialDescriptor b;

            static {
                a aVar = new a();
                a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("live", aVar, 4);
                pluginGeneratedSerialDescriptor.l("caption", false);
                pluginGeneratedSerialDescriptor.l("isMine", false);
                pluginGeneratedSerialDescriptor.l("senderUid", true);
                pluginGeneratedSerialDescriptor.l("state", true);
                pluginGeneratedSerialDescriptor.s(new Text.a.C1011a("_messageType"));
                b = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // ir.nasim.XI1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Live deserialize(Decoder decoder) {
                int i;
                int i2;
                boolean z;
                String str;
                MessageState messageState;
                AbstractC13042fc3.i(decoder, "decoder");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.c cVarB = decoder.b(serialDescriptor);
                KSerializer[] kSerializerArr = Live.$childSerializers;
                if (cVarB.p()) {
                    String strN = cVarB.n(serialDescriptor, 0);
                    boolean zB = cVarB.B(serialDescriptor, 1);
                    int i3 = cVarB.i(serialDescriptor, 2);
                    messageState = (MessageState) cVarB.E(serialDescriptor, 3, kSerializerArr[3], null);
                    str = strN;
                    i = i3;
                    i2 = 15;
                    z = zB;
                } else {
                    boolean z2 = true;
                    int i4 = 0;
                    boolean zB2 = false;
                    String strN2 = null;
                    MessageState messageState2 = null;
                    int i5 = 0;
                    while (z2) {
                        int iO = cVarB.o(serialDescriptor);
                        if (iO == -1) {
                            z2 = false;
                        } else if (iO == 0) {
                            strN2 = cVarB.n(serialDescriptor, 0);
                            i5 |= 1;
                        } else if (iO == 1) {
                            zB2 = cVarB.B(serialDescriptor, 1);
                            i5 |= 2;
                        } else if (iO == 2) {
                            i4 = cVarB.i(serialDescriptor, 2);
                            i5 |= 4;
                        } else {
                            if (iO != 3) {
                                throw new UnknownFieldException(iO);
                            }
                            messageState2 = (MessageState) cVarB.E(serialDescriptor, 3, kSerializerArr[3], messageState2);
                            i5 |= 8;
                        }
                    }
                    i = i4;
                    i2 = i5;
                    z = zB2;
                    str = strN2;
                    messageState = messageState2;
                }
                cVarB.c(serialDescriptor);
                return new Live(i2, str, z, i, messageState, (AbstractC21618tq6) null);
            }

            @Override // ir.nasim.InterfaceC22798vq6
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final void serialize(Encoder encoder, Live live) {
                AbstractC13042fc3.i(encoder, "encoder");
                AbstractC13042fc3.i(live, "value");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.d dVarB = encoder.b(serialDescriptor);
                Live.write$Self$database_release(live, dVarB, serialDescriptor);
                dVarB.c(serialDescriptor);
            }

            @Override // ir.nasim.NE2
            public final KSerializer[] childSerializers() {
                return new KSerializer[]{VY6.a, C8044Uh0.a, C3712Ca3.a, Live.$childSerializers[3]};
            }

            @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
            public final SerialDescriptor getDescriptor() {
                return b;
            }

            @Override // ir.nasim.NE2
            public KSerializer[] typeParametersSerializers() {
                return NE2.a.a(this);
            }
        }

        /* renamed from: ir.nasim.database.dailogLists.DialogLastMessage$Live$b, reason: from kotlin metadata */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer serializer() {
                return a.a;
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ Live(int i, String str, boolean z, int i2, MessageState messageState, AbstractC21618tq6 abstractC21618tq6) {
            if (3 != (i & 3)) {
                AbstractC19039pg5.a(i, 3, a.a.getDescriptor());
            }
            this.caption = str;
            this.isMine = z;
            if ((i & 4) == 0) {
                this.senderUid = 0;
            } else {
                this.senderUid = i2;
            }
            if ((i & 8) == 0) {
                this.state = MessageState.Unknown;
            } else {
                this.state = messageState;
            }
        }

        public static /* synthetic */ Live copy$default(Live live, String str, boolean z, int i, MessageState messageState, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = live.caption;
            }
            if ((i2 & 2) != 0) {
                z = live.isMine;
            }
            if ((i2 & 4) != 0) {
                i = live.senderUid;
            }
            if ((i2 & 8) != 0) {
                messageState = live.state;
            }
            return live.copy(str, z, i, messageState);
        }

        public static final /* synthetic */ void write$Self$database_release(Live self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            output.y(serialDesc, 0, self.caption);
            output.x(serialDesc, 1, self.isMine());
            if (output.z(serialDesc, 2) || self.getSenderUid() != 0) {
                output.w(serialDesc, 2, self.getSenderUid());
            }
            if (!output.z(serialDesc, 3) && self.getState() == MessageState.Unknown) {
                return;
            }
            output.B(serialDesc, 3, kSerializerArr[3], self.getState());
        }

        /* renamed from: component1, reason: from getter */
        public final String getCaption() {
            return this.caption;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsMine() {
            return this.isMine;
        }

        /* renamed from: component3, reason: from getter */
        public final int getSenderUid() {
            return this.senderUid;
        }

        /* renamed from: component4, reason: from getter */
        public final MessageState getState() {
            return this.state;
        }

        public final Live copy(String caption, boolean isMine, int senderUid, MessageState state) {
            AbstractC13042fc3.i(caption, "caption");
            AbstractC13042fc3.i(state, "state");
            return new Live(caption, isMine, senderUid, state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Live)) {
                return false;
            }
            Live live = (Live) other;
            return AbstractC13042fc3.d(this.caption, live.caption) && this.isMine == live.isMine && this.senderUid == live.senderUid && this.state == live.state;
        }

        public final String getCaption() {
            return this.caption;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public int getSenderUid() {
            return this.senderUid;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public MessageState getState() {
            return this.state;
        }

        public int hashCode() {
            return (((((this.caption.hashCode() * 31) + Boolean.hashCode(this.isMine)) * 31) + Integer.hashCode(this.senderUid)) * 31) + this.state.hashCode();
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public boolean isMine() {
            return this.isMine;
        }

        public String toString() {
            return "Live(caption=" + this.caption + ", isMine=" + this.isMine + ", senderUid=" + this.senderUid + ", state=" + this.state + Separators.RPAREN;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public Live setState(MessageState state) {
            AbstractC13042fc3.i(state, "state");
            return copy$default(this, null, false, 0, state, 7, null);
        }

        public Live(String str, boolean z, int i, MessageState messageState) {
            AbstractC13042fc3.i(str, "caption");
            AbstractC13042fc3.i(messageState, "state");
            this.caption = str;
            this.isMine = z;
            this.senderUid = i;
            this.state = messageState;
        }

        public /* synthetic */ Live(String str, boolean z, int i, MessageState messageState, int i2, ED1 ed1) {
            this(str, z, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? MessageState.Unknown : messageState);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0017\b\u0087\b\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0002PQBu\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016B}\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0015\u0010\u001aJ'\u0010#\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b&\u0010'J\u0018\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b(\u0010)J\u0012\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b,\u0010'J\u0010\u0010-\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b1\u00102J\u0018\u00103\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b3\u00104J\u0012\u00105\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b5\u00106J\u0080\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b9\u0010'J\u0010\u0010:\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b:\u00100J\u001a\u0010=\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010;HÖ\u0003¢\u0006\u0004\b=\u0010>R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010?\u001a\u0004\b@\u0010'R\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010A\u001a\u0004\bB\u0010)R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010C\u001a\u0004\bD\u0010+R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\n\u0010?\u001a\u0004\bE\u0010'R\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010F\u001a\u0004\b\f\u0010.R\u001a\u0010\r\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010G\u001a\u0004\bH\u00100R\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010I\u001a\u0004\bJ\u00102R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010K\u001a\u0004\bL\u00104R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010M\u001a\u0004\bN\u00106¨\u0006R"}, d2 = {"Lir/nasim/database/dailogLists/DialogLastMessage$Text;", "Lir/nasim/database/dailogLists/DialogLastMessage;", "Lir/nasim/U74;", "", ParameterNames.TEXT, "", "", "mentions", "Lir/nasim/w74;", "typeIcon", "senderNamePlaceHolder", "", "isMine", "senderUid", "Lir/nasim/database/dailogLists/MessageState;", "state", "", "Lir/nasim/database/dailogLists/UserNamePlaceHolder;", "userNamePlaceHolders", "Lai/bale/proto/MessagingStruct$ServiceEx$b;", "serviceEx", "<init>", "(Ljava/lang/String;Ljava/util/List;Lir/nasim/w74;Ljava/lang/String;ZILir/nasim/database/dailogLists/MessageState;Ljava/util/Set;Lai/bale/proto/MessagingStruct$ServiceEx$b;)V", "seen0", "Lir/nasim/tq6;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/List;Lir/nasim/w74;Ljava/lang/String;ZILir/nasim/database/dailogLists/MessageState;Ljava/util/Set;Lai/bale/proto/MessagingStruct$ServiceEx$b;Lir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "write$Self$database_release", "(Lir/nasim/database/dailogLists/DialogLastMessage$Text;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "setState", "(Lir/nasim/database/dailogLists/MessageState;)Lir/nasim/database/dailogLists/DialogLastMessage$Text;", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/List;", "component3", "()Lir/nasim/w74;", "component4", "component5", "()Z", "component6", "()I", "component7", "()Lir/nasim/database/dailogLists/MessageState;", "component8", "()Ljava/util/Set;", "component9", "()Lai/bale/proto/MessagingStruct$ServiceEx$b;", "copy", "(Ljava/lang/String;Ljava/util/List;Lir/nasim/w74;Ljava/lang/String;ZILir/nasim/database/dailogLists/MessageState;Ljava/util/Set;Lai/bale/proto/MessagingStruct$ServiceEx$b;)Lir/nasim/database/dailogLists/DialogLastMessage$Text;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "Ljava/util/List;", "getMentions", "Lir/nasim/w74;", "getTypeIcon", "getSenderNamePlaceHolder", "Z", TokenNames.I, "getSenderUid", "Lir/nasim/database/dailogLists/MessageState;", "getState", "Ljava/util/Set;", "getUserNamePlaceHolders", "Lai/bale/proto/MessagingStruct$ServiceEx$b;", "getServiceEx", "Companion", "a", "b", "database_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Text implements DialogLastMessage, U74 {
        private final boolean isMine;
        private final List<Integer> mentions;
        private final String senderNamePlaceHolder;
        private final int senderUid;
        private final MessagingStruct$ServiceEx.b serviceEx;
        private final MessageState state;
        private final String text;
        private final EnumC22968w74 typeIcon;
        private final Set<UserNamePlaceHolder> userNamePlaceHolders;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {null, new JJ(C3712Ca3.a), Q92.b("ir.nasim.database.dailogLists.MessageStartEmoji", EnumC22968w74.values()), null, null, null, Q92.b("ir.nasim.database.dailogLists.MessageState", MessageState.values()), new C18752pB3(UserNamePlaceHolder.a.a), Q92.b("ai.bale.proto.MessagingStruct.ServiceEx.TraitCase", MessagingStruct$ServiceEx.b.values())};

        public /* synthetic */ class a implements NE2 {
            public static final a a;
            private static final SerialDescriptor b;

            /* renamed from: ir.nasim.database.dailogLists.DialogLastMessage$Text$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C1011a implements InterfaceC14941ik3 {
                private final /* synthetic */ String b;

                public C1011a(String str) {
                    AbstractC13042fc3.i(str, "discriminator");
                    this.b = str;
                }

                @Override // java.lang.annotation.Annotation
                public final /* synthetic */ Class annotationType() {
                    return InterfaceC14941ik3.class;
                }

                @Override // ir.nasim.InterfaceC14941ik3
                public final /* synthetic */ String discriminator() {
                    return this.b;
                }

                @Override // java.lang.annotation.Annotation
                public final boolean equals(Object obj) {
                    return (obj instanceof InterfaceC14941ik3) && AbstractC13042fc3.d(discriminator(), ((InterfaceC14941ik3) obj).discriminator());
                }

                @Override // java.lang.annotation.Annotation
                public final int hashCode() {
                    return this.b.hashCode() ^ 707790692;
                }

                @Override // java.lang.annotation.Annotation
                public final String toString() {
                    return "@kotlinx.serialization.json.JsonClassDiscriminator(discriminator=" + this.b + Separators.RPAREN;
                }
            }

            static {
                a aVar = new a();
                a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor(ParameterNames.TEXT, aVar, 9);
                pluginGeneratedSerialDescriptor.l(ParameterNames.TEXT, false);
                pluginGeneratedSerialDescriptor.l("mentions", true);
                pluginGeneratedSerialDescriptor.l("typeIcon", true);
                pluginGeneratedSerialDescriptor.l("senderNamePlaceHolder", true);
                pluginGeneratedSerialDescriptor.l("isMine", true);
                pluginGeneratedSerialDescriptor.l("senderUid", true);
                pluginGeneratedSerialDescriptor.l("state", true);
                pluginGeneratedSerialDescriptor.l("userNamePlaceHolders", true);
                pluginGeneratedSerialDescriptor.l("serviceEx", true);
                pluginGeneratedSerialDescriptor.s(new C1011a("_messageType"));
                b = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // ir.nasim.XI1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Text deserialize(Decoder decoder) {
                int i;
                MessagingStruct$ServiceEx.b bVar;
                MessageState messageState;
                Set set;
                String str;
                EnumC22968w74 enumC22968w74;
                List list;
                boolean z;
                int i2;
                String str2;
                AbstractC13042fc3.i(decoder, "decoder");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.c cVarB = decoder.b(serialDescriptor);
                KSerializer[] kSerializerArr = Text.$childSerializers;
                int i3 = 7;
                if (cVarB.p()) {
                    String strN = cVarB.n(serialDescriptor, 0);
                    List list2 = (List) cVarB.H(serialDescriptor, 1, kSerializerArr[1], null);
                    EnumC22968w74 enumC22968w742 = (EnumC22968w74) cVarB.H(serialDescriptor, 2, kSerializerArr[2], null);
                    String str3 = (String) cVarB.H(serialDescriptor, 3, VY6.a, null);
                    boolean zB = cVarB.B(serialDescriptor, 4);
                    int i4 = cVarB.i(serialDescriptor, 5);
                    MessageState messageState2 = (MessageState) cVarB.E(serialDescriptor, 6, kSerializerArr[6], null);
                    Set set2 = (Set) cVarB.H(serialDescriptor, 7, kSerializerArr[7], null);
                    bVar = (MessagingStruct$ServiceEx.b) cVarB.H(serialDescriptor, 8, kSerializerArr[8], null);
                    str2 = strN;
                    i = i4;
                    str = str3;
                    z = zB;
                    set = set2;
                    messageState = messageState2;
                    i2 = 511;
                    enumC22968w74 = enumC22968w742;
                    list = list2;
                } else {
                    boolean z2 = true;
                    int i5 = 0;
                    int i6 = 0;
                    MessagingStruct$ServiceEx.b bVar2 = null;
                    MessageState messageState3 = null;
                    Set set3 = null;
                    String str4 = null;
                    EnumC22968w74 enumC22968w743 = null;
                    String strN2 = null;
                    List list3 = null;
                    boolean zB2 = false;
                    while (z2) {
                        int iO = cVarB.o(serialDescriptor);
                        switch (iO) {
                            case -1:
                                z2 = false;
                                i3 = 7;
                            case 0:
                                strN2 = cVarB.n(serialDescriptor, 0);
                                i6 |= 1;
                                i3 = 7;
                            case 1:
                                list3 = (List) cVarB.H(serialDescriptor, 1, kSerializerArr[1], list3);
                                i6 |= 2;
                                i3 = 7;
                            case 2:
                                enumC22968w743 = (EnumC22968w74) cVarB.H(serialDescriptor, 2, kSerializerArr[2], enumC22968w743);
                                i6 |= 4;
                                i3 = 7;
                            case 3:
                                str4 = (String) cVarB.H(serialDescriptor, 3, VY6.a, str4);
                                i6 |= 8;
                                i3 = 7;
                            case 4:
                                i6 |= 16;
                                zB2 = cVarB.B(serialDescriptor, 4);
                                i3 = 7;
                            case 5:
                                i5 = cVarB.i(serialDescriptor, 5);
                                i6 |= 32;
                                i3 = 7;
                            case 6:
                                messageState3 = (MessageState) cVarB.E(serialDescriptor, 6, kSerializerArr[6], messageState3);
                                i6 |= 64;
                                i3 = 7;
                            case 7:
                                set3 = (Set) cVarB.H(serialDescriptor, i3, kSerializerArr[i3], set3);
                                i6 |= 128;
                            case 8:
                                bVar2 = (MessagingStruct$ServiceEx.b) cVarB.H(serialDescriptor, 8, kSerializerArr[8], bVar2);
                                i6 |= 256;
                            default:
                                throw new UnknownFieldException(iO);
                        }
                    }
                    i = i5;
                    bVar = bVar2;
                    messageState = messageState3;
                    set = set3;
                    str = str4;
                    enumC22968w74 = enumC22968w743;
                    list = list3;
                    z = zB2;
                    i2 = i6;
                    str2 = strN2;
                }
                cVarB.c(serialDescriptor);
                return new Text(i2, str2, list, enumC22968w74, str, z, i, messageState, set, bVar, (AbstractC21618tq6) null);
            }

            @Override // ir.nasim.InterfaceC22798vq6
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final void serialize(Encoder encoder, Text text) {
                AbstractC13042fc3.i(encoder, "encoder");
                AbstractC13042fc3.i(text, "value");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.d dVarB = encoder.b(serialDescriptor);
                Text.write$Self$database_release(text, dVarB, serialDescriptor);
                dVarB.c(serialDescriptor);
            }

            @Override // ir.nasim.NE2
            public final KSerializer[] childSerializers() {
                KSerializer[] kSerializerArr = Text.$childSerializers;
                VY6 vy6 = VY6.a;
                return new KSerializer[]{vy6, AbstractC18503om0.p(kSerializerArr[1]), AbstractC18503om0.p(kSerializerArr[2]), AbstractC18503om0.p(vy6), C8044Uh0.a, C3712Ca3.a, kSerializerArr[6], AbstractC18503om0.p(kSerializerArr[7]), AbstractC18503om0.p(kSerializerArr[8])};
            }

            @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
            public final SerialDescriptor getDescriptor() {
                return b;
            }

            @Override // ir.nasim.NE2
            public KSerializer[] typeParametersSerializers() {
                return NE2.a.a(this);
            }
        }

        /* renamed from: ir.nasim.database.dailogLists.DialogLastMessage$Text$b, reason: from kotlin metadata */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer serializer() {
                return a.a;
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public /* synthetic */ Text(int i, String str, List list, EnumC22968w74 enumC22968w74, String str2, boolean z, int i2, MessageState messageState, Set set, MessagingStruct$ServiceEx.b bVar, AbstractC21618tq6 abstractC21618tq6) {
            if (1 != (i & 1)) {
                AbstractC19039pg5.a(i, 1, a.a.getDescriptor());
            }
            this.text = str;
            if ((i & 2) == 0) {
                this.mentions = null;
            } else {
                this.mentions = list;
            }
            if ((i & 4) == 0) {
                this.typeIcon = null;
            } else {
                this.typeIcon = enumC22968w74;
            }
            if ((i & 8) == 0) {
                this.senderNamePlaceHolder = null;
            } else {
                this.senderNamePlaceHolder = str2;
            }
            if ((i & 16) == 0) {
                this.isMine = false;
            } else {
                this.isMine = z;
            }
            if ((i & 32) == 0) {
                this.senderUid = 0;
            } else {
                this.senderUid = i2;
            }
            if ((i & 64) == 0) {
                this.state = MessageState.Unknown;
            } else {
                this.state = messageState;
            }
            if ((i & 128) == 0) {
                this.userNamePlaceHolders = null;
            } else {
                this.userNamePlaceHolders = set;
            }
            if ((i & 256) == 0) {
                this.serviceEx = null;
            } else {
                this.serviceEx = bVar;
            }
        }

        public static /* synthetic */ Text copy$default(Text text, String str, List list, EnumC22968w74 enumC22968w74, String str2, boolean z, int i, MessageState messageState, Set set, MessagingStruct$ServiceEx.b bVar, int i2, Object obj) {
            return text.copy((i2 & 1) != 0 ? text.text : str, (i2 & 2) != 0 ? text.mentions : list, (i2 & 4) != 0 ? text.typeIcon : enumC22968w74, (i2 & 8) != 0 ? text.senderNamePlaceHolder : str2, (i2 & 16) != 0 ? text.isMine : z, (i2 & 32) != 0 ? text.senderUid : i, (i2 & 64) != 0 ? text.state : messageState, (i2 & 128) != 0 ? text.userNamePlaceHolders : set, (i2 & 256) != 0 ? text.serviceEx : bVar);
        }

        public static final /* synthetic */ void write$Self$database_release(Text self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            output.y(serialDesc, 0, self.text);
            if (output.z(serialDesc, 1) || self.mentions != null) {
                output.m(serialDesc, 1, kSerializerArr[1], self.mentions);
            }
            if (output.z(serialDesc, 2) || self.typeIcon != null) {
                output.m(serialDesc, 2, kSerializerArr[2], self.typeIcon);
            }
            if (output.z(serialDesc, 3) || self.senderNamePlaceHolder != null) {
                output.m(serialDesc, 3, VY6.a, self.senderNamePlaceHolder);
            }
            if (output.z(serialDesc, 4) || self.isMine()) {
                output.x(serialDesc, 4, self.isMine());
            }
            if (output.z(serialDesc, 5) || self.getSenderUid() != 0) {
                output.w(serialDesc, 5, self.getSenderUid());
            }
            if (output.z(serialDesc, 6) || self.getState() != MessageState.Unknown) {
                output.B(serialDesc, 6, kSerializerArr[6], self.getState());
            }
            if (output.z(serialDesc, 7) || self.getUserNamePlaceHolders() != null) {
                output.m(serialDesc, 7, kSerializerArr[7], self.getUserNamePlaceHolders());
            }
            if (!output.z(serialDesc, 8) && self.serviceEx == null) {
                return;
            }
            output.m(serialDesc, 8, kSerializerArr[8], self.serviceEx);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final List<Integer> component2() {
            return this.mentions;
        }

        /* renamed from: component3, reason: from getter */
        public final EnumC22968w74 getTypeIcon() {
            return this.typeIcon;
        }

        /* renamed from: component4, reason: from getter */
        public final String getSenderNamePlaceHolder() {
            return this.senderNamePlaceHolder;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsMine() {
            return this.isMine;
        }

        /* renamed from: component6, reason: from getter */
        public final int getSenderUid() {
            return this.senderUid;
        }

        /* renamed from: component7, reason: from getter */
        public final MessageState getState() {
            return this.state;
        }

        public final Set<UserNamePlaceHolder> component8() {
            return this.userNamePlaceHolders;
        }

        /* renamed from: component9, reason: from getter */
        public final MessagingStruct$ServiceEx.b getServiceEx() {
            return this.serviceEx;
        }

        public final Text copy(String text, List<Integer> mentions, EnumC22968w74 typeIcon, String senderNamePlaceHolder, boolean isMine, int senderUid, MessageState state, Set<UserNamePlaceHolder> userNamePlaceHolders, MessagingStruct$ServiceEx.b serviceEx) {
            AbstractC13042fc3.i(text, ParameterNames.TEXT);
            AbstractC13042fc3.i(state, "state");
            return new Text(text, mentions, typeIcon, senderNamePlaceHolder, isMine, senderUid, state, userNamePlaceHolders, serviceEx);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Text)) {
                return false;
            }
            Text text = (Text) other;
            return AbstractC13042fc3.d(this.text, text.text) && AbstractC13042fc3.d(this.mentions, text.mentions) && this.typeIcon == text.typeIcon && AbstractC13042fc3.d(this.senderNamePlaceHolder, text.senderNamePlaceHolder) && this.isMine == text.isMine && this.senderUid == text.senderUid && this.state == text.state && AbstractC13042fc3.d(this.userNamePlaceHolders, text.userNamePlaceHolders) && this.serviceEx == text.serviceEx;
        }

        public final List<Integer> getMentions() {
            return this.mentions;
        }

        public final String getSenderNamePlaceHolder() {
            return this.senderNamePlaceHolder;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public int getSenderUid() {
            return this.senderUid;
        }

        public final MessagingStruct$ServiceEx.b getServiceEx() {
            return this.serviceEx;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public MessageState getState() {
            return this.state;
        }

        public final String getText() {
            return this.text;
        }

        public final EnumC22968w74 getTypeIcon() {
            return this.typeIcon;
        }

        @Override // ir.nasim.U74
        public Set<UserNamePlaceHolder> getUserNamePlaceHolders() {
            return this.userNamePlaceHolders;
        }

        public int hashCode() {
            int iHashCode = this.text.hashCode() * 31;
            List<Integer> list = this.mentions;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            EnumC22968w74 enumC22968w74 = this.typeIcon;
            int iHashCode3 = (iHashCode2 + (enumC22968w74 == null ? 0 : enumC22968w74.hashCode())) * 31;
            String str = this.senderNamePlaceHolder;
            int iHashCode4 = (((((((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isMine)) * 31) + Integer.hashCode(this.senderUid)) * 31) + this.state.hashCode()) * 31;
            Set<UserNamePlaceHolder> set = this.userNamePlaceHolders;
            int iHashCode5 = (iHashCode4 + (set == null ? 0 : set.hashCode())) * 31;
            MessagingStruct$ServiceEx.b bVar = this.serviceEx;
            return iHashCode5 + (bVar != null ? bVar.hashCode() : 0);
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public boolean isMine() {
            return this.isMine;
        }

        public String toString() {
            return "Text(text=" + this.text + ", mentions=" + this.mentions + ", typeIcon=" + this.typeIcon + ", senderNamePlaceHolder=" + this.senderNamePlaceHolder + ", isMine=" + this.isMine + ", senderUid=" + this.senderUid + ", state=" + this.state + ", userNamePlaceHolders=" + this.userNamePlaceHolders + ", serviceEx=" + this.serviceEx + Separators.RPAREN;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public Text setState(MessageState state) {
            AbstractC13042fc3.i(state, "state");
            return copy$default(this, null, null, null, null, false, 0, state, null, null, 447, null);
        }

        public Text(String str, List<Integer> list, EnumC22968w74 enumC22968w74, String str2, boolean z, int i, MessageState messageState, Set<UserNamePlaceHolder> set, MessagingStruct$ServiceEx.b bVar) {
            AbstractC13042fc3.i(str, ParameterNames.TEXT);
            AbstractC13042fc3.i(messageState, "state");
            this.text = str;
            this.mentions = list;
            this.typeIcon = enumC22968w74;
            this.senderNamePlaceHolder = str2;
            this.isMine = z;
            this.senderUid = i;
            this.state = messageState;
            this.userNamePlaceHolders = set;
            this.serviceEx = bVar;
        }

        public /* synthetic */ Text(String str, List list, EnumC22968w74 enumC22968w74, String str2, boolean z, int i, MessageState messageState, Set set, MessagingStruct$ServiceEx.b bVar, int i2, ED1 ed1) {
            this(str, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? null : enumC22968w74, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? false : z, (i2 & 32) == 0 ? i : 0, (i2 & 64) != 0 ? MessageState.Unknown : messageState, (i2 & 128) != 0 ? null : set, (i2 & 256) == 0 ? bVar : null);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\f\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/0B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB5\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\b\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ.\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u001aJ\u001a\u0010'\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b'\u0010(R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010+\u001a\u0004\b,\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010-\u001a\u0004\b\u0007\u0010\u001e¨\u00061"}, d2 = {"Lir/nasim/database/dailogLists/DialogLastMessage$Unknown;", "Lir/nasim/database/dailogLists/DialogLastMessage;", "", "senderUid", "Lir/nasim/database/dailogLists/MessageState;", "state", "", "isMine", "<init>", "(ILir/nasim/database/dailogLists/MessageState;Z)V", "seen0", "Lir/nasim/tq6;", "serializationConstructorMarker", "(IILir/nasim/database/dailogLists/MessageState;ZLir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "write$Self$database_release", "(Lir/nasim/database/dailogLists/DialogLastMessage$Unknown;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "setState", "(Lir/nasim/database/dailogLists/MessageState;)Lir/nasim/database/dailogLists/DialogLastMessage$Unknown;", "component1", "()I", "component2", "()Lir/nasim/database/dailogLists/MessageState;", "component3", "()Z", "copy", "(ILir/nasim/database/dailogLists/MessageState;Z)Lir/nasim/database/dailogLists/DialogLastMessage$Unknown;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", TokenNames.I, "getSenderUid", "Lir/nasim/database/dailogLists/MessageState;", "getState", "Z", "Companion", "a", "b", "database_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Unknown implements DialogLastMessage {
        private final boolean isMine;
        private final int senderUid;
        private final MessageState state;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {null, Q92.b("ir.nasim.database.dailogLists.MessageState", MessageState.values()), null};

        public /* synthetic */ class a implements NE2 {
            public static final a a;
            private static final SerialDescriptor b;

            static {
                a aVar = new a();
                a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor(CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE, aVar, 3);
                pluginGeneratedSerialDescriptor.l("senderUid", true);
                pluginGeneratedSerialDescriptor.l("state", true);
                pluginGeneratedSerialDescriptor.l("isMine", true);
                pluginGeneratedSerialDescriptor.s(new Text.a.C1011a("_messageType"));
                b = pluginGeneratedSerialDescriptor;
            }

            private a() {
            }

            @Override // ir.nasim.XI1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Unknown deserialize(Decoder decoder) {
                int i;
                boolean zB;
                int i2;
                MessageState messageState;
                AbstractC13042fc3.i(decoder, "decoder");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.c cVarB = decoder.b(serialDescriptor);
                KSerializer[] kSerializerArr = Unknown.$childSerializers;
                if (cVarB.p()) {
                    int i3 = cVarB.i(serialDescriptor, 0);
                    messageState = (MessageState) cVarB.E(serialDescriptor, 1, kSerializerArr[1], null);
                    i = i3;
                    zB = cVarB.B(serialDescriptor, 2);
                    i2 = 7;
                } else {
                    boolean z = true;
                    int i4 = 0;
                    int i5 = 0;
                    MessageState messageState2 = null;
                    boolean zB2 = false;
                    while (z) {
                        int iO = cVarB.o(serialDescriptor);
                        if (iO == -1) {
                            z = false;
                        } else if (iO == 0) {
                            i4 = cVarB.i(serialDescriptor, 0);
                            i5 |= 1;
                        } else if (iO == 1) {
                            messageState2 = (MessageState) cVarB.E(serialDescriptor, 1, kSerializerArr[1], messageState2);
                            i5 |= 2;
                        } else {
                            if (iO != 2) {
                                throw new UnknownFieldException(iO);
                            }
                            zB2 = cVarB.B(serialDescriptor, 2);
                            i5 |= 4;
                        }
                    }
                    i = i4;
                    zB = zB2;
                    i2 = i5;
                    messageState = messageState2;
                }
                cVarB.c(serialDescriptor);
                return new Unknown(i2, i, messageState, zB, (AbstractC21618tq6) null);
            }

            @Override // ir.nasim.InterfaceC22798vq6
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final void serialize(Encoder encoder, Unknown unknown) {
                AbstractC13042fc3.i(encoder, "encoder");
                AbstractC13042fc3.i(unknown, "value");
                SerialDescriptor serialDescriptor = b;
                kotlinx.serialization.encoding.d dVarB = encoder.b(serialDescriptor);
                Unknown.write$Self$database_release(unknown, dVarB, serialDescriptor);
                dVarB.c(serialDescriptor);
            }

            @Override // ir.nasim.NE2
            public final KSerializer[] childSerializers() {
                return new KSerializer[]{C3712Ca3.a, Unknown.$childSerializers[1], C8044Uh0.a};
            }

            @Override // kotlinx.serialization.KSerializer, ir.nasim.InterfaceC22798vq6, ir.nasim.XI1
            public final SerialDescriptor getDescriptor() {
                return b;
            }

            @Override // ir.nasim.NE2
            public KSerializer[] typeParametersSerializers() {
                return NE2.a.a(this);
            }
        }

        /* renamed from: ir.nasim.database.dailogLists.DialogLastMessage$Unknown$b, reason: from kotlin metadata */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer serializer() {
                return a.a;
            }

            public /* synthetic */ Companion(ED1 ed1) {
                this();
            }
        }

        public Unknown() {
            this(0, (MessageState) null, false, 7, (ED1) null);
        }

        public static /* synthetic */ Unknown copy$default(Unknown unknown, int i, MessageState messageState, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = unknown.senderUid;
            }
            if ((i2 & 2) != 0) {
                messageState = unknown.state;
            }
            if ((i2 & 4) != 0) {
                z = unknown.isMine;
            }
            return unknown.copy(i, messageState, z);
        }

        public static final /* synthetic */ void write$Self$database_release(Unknown self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            if (output.z(serialDesc, 0) || self.getSenderUid() != 1) {
                output.w(serialDesc, 0, self.getSenderUid());
            }
            if (output.z(serialDesc, 1) || self.getState() != MessageState.Unknown) {
                output.B(serialDesc, 1, kSerializerArr[1], self.getState());
            }
            if (output.z(serialDesc, 2) || self.isMine()) {
                output.x(serialDesc, 2, self.isMine());
            }
        }

        /* renamed from: component1, reason: from getter */
        public final int getSenderUid() {
            return this.senderUid;
        }

        /* renamed from: component2, reason: from getter */
        public final MessageState getState() {
            return this.state;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsMine() {
            return this.isMine;
        }

        public final Unknown copy(int senderUid, MessageState state, boolean isMine) {
            AbstractC13042fc3.i(state, "state");
            return new Unknown(senderUid, state, isMine);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unknown)) {
                return false;
            }
            Unknown unknown = (Unknown) other;
            return this.senderUid == unknown.senderUid && this.state == unknown.state && this.isMine == unknown.isMine;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public int getSenderUid() {
            return this.senderUid;
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public MessageState getState() {
            return this.state;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.senderUid) * 31) + this.state.hashCode()) * 31) + Boolean.hashCode(this.isMine);
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public boolean isMine() {
            return this.isMine;
        }

        public String toString() {
            return "Unknown(senderUid=" + this.senderUid + ", state=" + this.state + ", isMine=" + this.isMine + Separators.RPAREN;
        }

        public /* synthetic */ Unknown(int i, int i2, MessageState messageState, boolean z, AbstractC21618tq6 abstractC21618tq6) {
            this.senderUid = (i & 1) == 0 ? 1 : i2;
            if ((i & 2) == 0) {
                this.state = MessageState.Unknown;
            } else {
                this.state = messageState;
            }
            if ((i & 4) == 0) {
                this.isMine = false;
            } else {
                this.isMine = z;
            }
        }

        @Override // ir.nasim.database.dailogLists.DialogLastMessage
        public Unknown setState(MessageState state) {
            AbstractC13042fc3.i(state, "state");
            return copy$default(this, 0, state, false, 5, null);
        }

        public Unknown(int i, MessageState messageState, boolean z) {
            AbstractC13042fc3.i(messageState, "state");
            this.senderUid = i;
            this.state = messageState;
            this.isMine = z;
        }

        public /* synthetic */ Unknown(int i, MessageState messageState, boolean z, int i2, ED1 ed1) {
            this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? MessageState.Unknown : messageState, (i2 & 4) != 0 ? false : z);
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.DialogLastMessage$a, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion a = new Companion();

        private Companion() {
        }

        public final KSerializer serializer() {
            return new C4219Ee6("ir.nasim.database.dailogLists.DialogLastMessage", AbstractC10882cM5.b(DialogLastMessage.class), new InterfaceC11299cm3[]{AbstractC10882cM5.b(Album.class), AbstractC10882cM5.b(Call.class), AbstractC10882cM5.b(Document.class), AbstractC10882cM5.b(Link.class), AbstractC10882cM5.b(Live.class), AbstractC10882cM5.b(Text.class), AbstractC10882cM5.b(Unknown.class)}, new KSerializer[]{Album.a.a, Call.a.a, Document.a.a, Link.a.a, Live.a.a, Text.a.a, Unknown.a.a}, new Annotation[]{new Text.a.C1011a("_messageType")});
        }
    }

    int getSenderUid();

    MessageState getState();

    boolean isMine();

    DialogLastMessage setState(MessageState state);
}
