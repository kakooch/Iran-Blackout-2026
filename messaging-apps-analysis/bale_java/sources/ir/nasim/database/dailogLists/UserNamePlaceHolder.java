package ir.nasim.database.dailogLists;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19039pg5;
import ir.nasim.AbstractC21618tq6;
import ir.nasim.C3712Ca3;
import ir.nasim.ED1;
import ir.nasim.NE2;
import ir.nasim.VY6;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002&'B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J$\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0016J\u0010\u0010\u001c\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0018J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010\u0018¨\u0006("}, d2 = {"Lir/nasim/database/dailogLists/UserNamePlaceHolder;", "", "", "key", "", "userId", "<init>", "(Ljava/lang/String;I)V", "seen0", "Lir/nasim/tq6;", "serializationConstructorMarker", "(ILjava/lang/String;ILir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "write$Self$database_release", "(Lir/nasim/database/dailogLists/UserNamePlaceHolder;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()I", "copy", "(Ljava/lang/String;I)Lir/nasim/database/dailogLists/UserNamePlaceHolder;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKey", TokenNames.I, "getUserId", "Companion", "a", "b", "database_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class UserNamePlaceHolder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String key;
    private final int userId;

    public /* synthetic */ class a implements NE2 {
        public static final a a;
        private static final SerialDescriptor b;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ir.nasim.database.dailogLists.UserNamePlaceHolder", aVar, 2);
            pluginGeneratedSerialDescriptor.l("key", false);
            pluginGeneratedSerialDescriptor.l("userId", false);
            b = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // ir.nasim.XI1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserNamePlaceHolder deserialize(Decoder decoder) {
            String strN;
            int i;
            int i2;
            AbstractC13042fc3.i(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            kotlinx.serialization.encoding.c cVarB = decoder.b(serialDescriptor);
            AbstractC21618tq6 abstractC21618tq6 = null;
            if (cVarB.p()) {
                strN = cVarB.n(serialDescriptor, 0);
                i = cVarB.i(serialDescriptor, 1);
                i2 = 3;
            } else {
                boolean z = true;
                int i3 = 0;
                int i4 = 0;
                strN = null;
                while (z) {
                    int iO = cVarB.o(serialDescriptor);
                    if (iO == -1) {
                        z = false;
                    } else if (iO == 0) {
                        strN = cVarB.n(serialDescriptor, 0);
                        i4 |= 1;
                    } else {
                        if (iO != 1) {
                            throw new UnknownFieldException(iO);
                        }
                        i3 = cVarB.i(serialDescriptor, 1);
                        i4 |= 2;
                    }
                }
                i = i3;
                i2 = i4;
            }
            cVarB.c(serialDescriptor);
            return new UserNamePlaceHolder(i2, strN, i, abstractC21618tq6);
        }

        @Override // ir.nasim.InterfaceC22798vq6
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, UserNamePlaceHolder userNamePlaceHolder) {
            AbstractC13042fc3.i(encoder, "encoder");
            AbstractC13042fc3.i(userNamePlaceHolder, "value");
            SerialDescriptor serialDescriptor = b;
            kotlinx.serialization.encoding.d dVarB = encoder.b(serialDescriptor);
            UserNamePlaceHolder.write$Self$database_release(userNamePlaceHolder, dVarB, serialDescriptor);
            dVarB.c(serialDescriptor);
        }

        @Override // ir.nasim.NE2
        public final KSerializer[] childSerializers() {
            return new KSerializer[]{VY6.a, C3712Ca3.a};
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

    /* renamed from: ir.nasim.database.dailogLists.UserNamePlaceHolder$b, reason: from kotlin metadata */
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

    public /* synthetic */ UserNamePlaceHolder(int i, String str, int i2, AbstractC21618tq6 abstractC21618tq6) {
        if (3 != (i & 3)) {
            AbstractC19039pg5.a(i, 3, a.a.getDescriptor());
        }
        this.key = str;
        this.userId = i2;
    }

    public static /* synthetic */ UserNamePlaceHolder copy$default(UserNamePlaceHolder userNamePlaceHolder, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userNamePlaceHolder.key;
        }
        if ((i2 & 2) != 0) {
            i = userNamePlaceHolder.userId;
        }
        return userNamePlaceHolder.copy(str, i);
    }

    public static final /* synthetic */ void write$Self$database_release(UserNamePlaceHolder self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
        output.y(serialDesc, 0, self.key);
        output.w(serialDesc, 1, self.userId);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component2, reason: from getter */
    public final int getUserId() {
        return this.userId;
    }

    public final UserNamePlaceHolder copy(String key, int userId) {
        AbstractC13042fc3.i(key, "key");
        return new UserNamePlaceHolder(key, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserNamePlaceHolder)) {
            return false;
        }
        UserNamePlaceHolder userNamePlaceHolder = (UserNamePlaceHolder) other;
        return AbstractC13042fc3.d(this.key, userNamePlaceHolder.key) && this.userId == userNamePlaceHolder.userId;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (this.key.hashCode() * 31) + Integer.hashCode(this.userId);
    }

    public String toString() {
        return "UserNamePlaceHolder(key=" + this.key + ", userId=" + this.userId + Separators.RPAREN;
    }

    public UserNamePlaceHolder(String str, int i) {
        AbstractC13042fc3.i(str, "key");
        this.key = str;
        this.userId = i;
    }
}
