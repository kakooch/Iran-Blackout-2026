package ir.nasim.database.dailogLists;

import android.gov.nist.core.Separators;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC19039pg5;
import ir.nasim.AbstractC21618tq6;
import ir.nasim.C20006rJ3;
import ir.nasim.ED1;
import ir.nasim.NE2;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002*+B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007B3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J.\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b'\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b(\u0010\u0017¨\u0006,"}, d2 = {"Lir/nasim/database/dailogLists/MessageIdentifier;", "", "", DialogEntity.COLUMN_RID, "date", "seq", "<init>", "(JJJ)V", "", "seen0", "Lir/nasim/tq6;", "serializationConstructorMarker", "(IJJJLir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "write$Self$database_release", "(Lir/nasim/database/dailogLists/MessageIdentifier;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()J", "component2", "component3", "copy", "(JJJ)Lir/nasim/database/dailogLists/MessageIdentifier;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getRid", "getDate", "getSeq", "Companion", "a", "b", "database_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class MessageIdentifier {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long date;
    private final long rid;
    private final long seq;

    public /* synthetic */ class a implements NE2 {
        public static final a a;
        private static final SerialDescriptor b;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ir.nasim.database.dailogLists.MessageIdentifier", aVar, 3);
            pluginGeneratedSerialDescriptor.l(DialogEntity.COLUMN_RID, false);
            pluginGeneratedSerialDescriptor.l("date", false);
            pluginGeneratedSerialDescriptor.l("seq", true);
            b = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // ir.nasim.XI1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MessageIdentifier deserialize(Decoder decoder) {
            int i;
            long jF;
            long j;
            long j2;
            AbstractC13042fc3.i(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            kotlinx.serialization.encoding.c cVarB = decoder.b(serialDescriptor);
            if (cVarB.p()) {
                long jF2 = cVarB.f(serialDescriptor, 0);
                long jF3 = cVarB.f(serialDescriptor, 1);
                jF = cVarB.f(serialDescriptor, 2);
                i = 7;
                j = jF2;
                j2 = jF3;
            } else {
                long jF4 = 0;
                boolean z = true;
                int i2 = 0;
                long jF5 = 0;
                long jF6 = 0;
                while (z) {
                    int iO = cVarB.o(serialDescriptor);
                    if (iO == -1) {
                        z = false;
                    } else if (iO == 0) {
                        jF5 = cVarB.f(serialDescriptor, 0);
                        i2 |= 1;
                    } else if (iO == 1) {
                        jF6 = cVarB.f(serialDescriptor, 1);
                        i2 |= 2;
                    } else {
                        if (iO != 2) {
                            throw new UnknownFieldException(iO);
                        }
                        jF4 = cVarB.f(serialDescriptor, 2);
                        i2 |= 4;
                    }
                }
                i = i2;
                jF = jF4;
                j = jF5;
                j2 = jF6;
            }
            cVarB.c(serialDescriptor);
            return new MessageIdentifier(i, j, j2, jF, (AbstractC21618tq6) null);
        }

        @Override // ir.nasim.InterfaceC22798vq6
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, MessageIdentifier messageIdentifier) {
            AbstractC13042fc3.i(encoder, "encoder");
            AbstractC13042fc3.i(messageIdentifier, "value");
            SerialDescriptor serialDescriptor = b;
            kotlinx.serialization.encoding.d dVarB = encoder.b(serialDescriptor);
            MessageIdentifier.write$Self$database_release(messageIdentifier, dVarB, serialDescriptor);
            dVarB.c(serialDescriptor);
        }

        @Override // ir.nasim.NE2
        public final KSerializer[] childSerializers() {
            C20006rJ3 c20006rJ3 = C20006rJ3.a;
            return new KSerializer[]{c20006rJ3, c20006rJ3, c20006rJ3};
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

    /* renamed from: ir.nasim.database.dailogLists.MessageIdentifier$b, reason: from kotlin metadata */
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

    public /* synthetic */ MessageIdentifier(int i, long j, long j2, long j3, AbstractC21618tq6 abstractC21618tq6) {
        if (3 != (i & 3)) {
            AbstractC19039pg5.a(i, 3, a.a.getDescriptor());
        }
        this.rid = j;
        this.date = j2;
        if ((i & 4) == 0) {
            this.seq = 0L;
        } else {
            this.seq = j3;
        }
    }

    public static /* synthetic */ MessageIdentifier copy$default(MessageIdentifier messageIdentifier, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = messageIdentifier.rid;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = messageIdentifier.date;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = messageIdentifier.seq;
        }
        return messageIdentifier.copy(j4, j5, j3);
    }

    public static final /* synthetic */ void write$Self$database_release(MessageIdentifier self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
        output.E(serialDesc, 0, self.rid);
        output.E(serialDesc, 1, self.date);
        if (!output.z(serialDesc, 2) && self.seq == 0) {
            return;
        }
        output.E(serialDesc, 2, self.seq);
    }

    /* renamed from: component1, reason: from getter */
    public final long getRid() {
        return this.rid;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSeq() {
        return this.seq;
    }

    public final MessageIdentifier copy(long rid, long date, long seq) {
        return new MessageIdentifier(rid, date, seq);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageIdentifier)) {
            return false;
        }
        MessageIdentifier messageIdentifier = (MessageIdentifier) other;
        return this.rid == messageIdentifier.rid && this.date == messageIdentifier.date && this.seq == messageIdentifier.seq;
    }

    public final long getDate() {
        return this.date;
    }

    public final long getRid() {
        return this.rid;
    }

    public final long getSeq() {
        return this.seq;
    }

    public int hashCode() {
        return (((Long.hashCode(this.rid) * 31) + Long.hashCode(this.date)) * 31) + Long.hashCode(this.seq);
    }

    public String toString() {
        return "MessageIdentifier(rid=" + this.rid + ", date=" + this.date + ", seq=" + this.seq + Separators.RPAREN;
    }

    public MessageIdentifier(long j, long j2, long j3) {
        this.rid = j;
        this.date = j2;
        this.seq = j3;
    }

    public /* synthetic */ MessageIdentifier(long j, long j2, long j3, int i, ED1 ed1) {
        this(j, j2, (i & 4) != 0 ? 0L : j3);
    }
}
