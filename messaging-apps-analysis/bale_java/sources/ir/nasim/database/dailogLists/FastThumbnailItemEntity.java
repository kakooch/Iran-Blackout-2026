package ir.nasim.database.dailogLists;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.annotation.Keep;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18503om0;
import ir.nasim.AbstractC19039pg5;
import ir.nasim.AbstractC21618tq6;
import ir.nasim.C3712Ca3;
import ir.nasim.C8044Uh0;
import ir.nasim.ED1;
import ir.nasim.NE2;
import java.util.Arrays;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/0B-\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ:\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b$\u0010\u001bJ\u001a\u0010&\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b,\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010-\u001a\u0004\b\b\u0010\u001e¨\u00061"}, d2 = {"Lir/nasim/database/dailogLists/FastThumbnailItemEntity;", "", "", "fastThumb", "", "width", "height", "", "isVideo", "<init>", "([BIIZ)V", "seen0", "Lir/nasim/tq6;", "serializationConstructorMarker", "(I[BIIZLir/nasim/tq6;)V", "self", "Lkotlinx/serialization/encoding/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lir/nasim/rB7;", "write$Self$database_release", "(Lir/nasim/database/dailogLists/FastThumbnailItemEntity;Lkotlinx/serialization/encoding/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()[B", "component2", "()I", "component3", "component4", "()Z", "copy", "([BIIZ)Lir/nasim/database/dailogLists/FastThumbnailItemEntity;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "[B", "getFastThumb", TokenNames.I, "getWidth", "getHeight", "Z", "Companion", "a", "b", "database_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class FastThumbnailItemEntity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final byte[] fastThumb;
    private final int height;
    private final boolean isVideo;
    private final int width;

    public /* synthetic */ class a implements NE2 {
        public static final a a;
        private static final SerialDescriptor b;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ir.nasim.database.dailogLists.FastThumbnailItemEntity", aVar, 4);
            pluginGeneratedSerialDescriptor.l("fastThumb", true);
            pluginGeneratedSerialDescriptor.l("width", false);
            pluginGeneratedSerialDescriptor.l("height", false);
            pluginGeneratedSerialDescriptor.l("isVideo", true);
            b = pluginGeneratedSerialDescriptor;
        }

        private a() {
        }

        @Override // ir.nasim.XI1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FastThumbnailItemEntity deserialize(Decoder decoder) {
            boolean zB;
            int i;
            int i2;
            int i3;
            byte[] bArr;
            AbstractC13042fc3.i(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            kotlinx.serialization.encoding.c cVarB = decoder.b(serialDescriptor);
            if (cVarB.p()) {
                byte[] bArr2 = (byte[]) cVarB.H(serialDescriptor, 0, kotlinx.serialization.internal.b.c, null);
                int i4 = cVarB.i(serialDescriptor, 1);
                int i5 = cVarB.i(serialDescriptor, 2);
                bArr = bArr2;
                zB = cVarB.B(serialDescriptor, 3);
                i = i5;
                i2 = i4;
                i3 = 15;
            } else {
                boolean z = true;
                boolean zB2 = false;
                int i6 = 0;
                int i7 = 0;
                byte[] bArr3 = null;
                int i8 = 0;
                while (z) {
                    int iO = cVarB.o(serialDescriptor);
                    if (iO == -1) {
                        z = false;
                    } else if (iO == 0) {
                        bArr3 = (byte[]) cVarB.H(serialDescriptor, 0, kotlinx.serialization.internal.b.c, bArr3);
                        i7 |= 1;
                    } else if (iO == 1) {
                        i6 = cVarB.i(serialDescriptor, 1);
                        i7 |= 2;
                    } else if (iO == 2) {
                        i8 = cVarB.i(serialDescriptor, 2);
                        i7 |= 4;
                    } else {
                        if (iO != 3) {
                            throw new UnknownFieldException(iO);
                        }
                        zB2 = cVarB.B(serialDescriptor, 3);
                        i7 |= 8;
                    }
                }
                zB = zB2;
                i = i8;
                i2 = i6;
                i3 = i7;
                bArr = bArr3;
            }
            cVarB.c(serialDescriptor);
            return new FastThumbnailItemEntity(i3, bArr, i2, i, zB, (AbstractC21618tq6) null);
        }

        @Override // ir.nasim.InterfaceC22798vq6
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, FastThumbnailItemEntity fastThumbnailItemEntity) {
            AbstractC13042fc3.i(encoder, "encoder");
            AbstractC13042fc3.i(fastThumbnailItemEntity, "value");
            SerialDescriptor serialDescriptor = b;
            kotlinx.serialization.encoding.d dVarB = encoder.b(serialDescriptor);
            FastThumbnailItemEntity.write$Self$database_release(fastThumbnailItemEntity, dVarB, serialDescriptor);
            dVarB.c(serialDescriptor);
        }

        @Override // ir.nasim.NE2
        public final KSerializer[] childSerializers() {
            C3712Ca3 c3712Ca3 = C3712Ca3.a;
            return new KSerializer[]{AbstractC18503om0.p(kotlinx.serialization.internal.b.c), c3712Ca3, c3712Ca3, C8044Uh0.a};
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

    /* renamed from: ir.nasim.database.dailogLists.FastThumbnailItemEntity$b, reason: from kotlin metadata */
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

    public /* synthetic */ FastThumbnailItemEntity(int i, byte[] bArr, int i2, int i3, boolean z, AbstractC21618tq6 abstractC21618tq6) {
        if (6 != (i & 6)) {
            AbstractC19039pg5.a(i, 6, a.a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.fastThumb = null;
        } else {
            this.fastThumb = bArr;
        }
        this.width = i2;
        this.height = i3;
        if ((i & 8) == 0) {
            this.isVideo = false;
        } else {
            this.isVideo = z;
        }
    }

    public static /* synthetic */ FastThumbnailItemEntity copy$default(FastThumbnailItemEntity fastThumbnailItemEntity, byte[] bArr, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            bArr = fastThumbnailItemEntity.fastThumb;
        }
        if ((i3 & 2) != 0) {
            i = fastThumbnailItemEntity.width;
        }
        if ((i3 & 4) != 0) {
            i2 = fastThumbnailItemEntity.height;
        }
        if ((i3 & 8) != 0) {
            z = fastThumbnailItemEntity.isVideo;
        }
        return fastThumbnailItemEntity.copy(bArr, i, i2, z);
    }

    public static final /* synthetic */ void write$Self$database_release(FastThumbnailItemEntity self, kotlinx.serialization.encoding.d output, SerialDescriptor serialDesc) {
        if (output.z(serialDesc, 0) || self.fastThumb != null) {
            output.m(serialDesc, 0, kotlinx.serialization.internal.b.c, self.fastThumb);
        }
        output.w(serialDesc, 1, self.width);
        output.w(serialDesc, 2, self.height);
        if (output.z(serialDesc, 3) || self.isVideo) {
            output.x(serialDesc, 3, self.isVideo);
        }
    }

    /* renamed from: component1, reason: from getter */
    public final byte[] getFastThumb() {
        return this.fastThumb;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsVideo() {
        return this.isVideo;
    }

    public final FastThumbnailItemEntity copy(byte[] fastThumb, int width, int height, boolean isVideo) {
        return new FastThumbnailItemEntity(fastThumb, width, height, isVideo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FastThumbnailItemEntity)) {
            return false;
        }
        FastThumbnailItemEntity fastThumbnailItemEntity = (FastThumbnailItemEntity) other;
        return AbstractC13042fc3.d(this.fastThumb, fastThumbnailItemEntity.fastThumb) && this.width == fastThumbnailItemEntity.width && this.height == fastThumbnailItemEntity.height && this.isVideo == fastThumbnailItemEntity.isVideo;
    }

    public final byte[] getFastThumb() {
        return this.fastThumb;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        byte[] bArr = this.fastThumb;
        return ((((((bArr == null ? 0 : Arrays.hashCode(bArr)) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Boolean.hashCode(this.isVideo);
    }

    public final boolean isVideo() {
        return this.isVideo;
    }

    public String toString() {
        return "FastThumbnailItemEntity(fastThumb=" + Arrays.toString(this.fastThumb) + ", width=" + this.width + ", height=" + this.height + ", isVideo=" + this.isVideo + Separators.RPAREN;
    }

    public FastThumbnailItemEntity(byte[] bArr, int i, int i2, boolean z) {
        this.fastThumb = bArr;
        this.width = i;
        this.height = i2;
        this.isVideo = z;
    }

    public /* synthetic */ FastThumbnailItemEntity(byte[] bArr, int i, int i2, boolean z, int i3, ED1 ed1) {
        this((i3 & 1) != 0 ? null : bArr, i, i2, (i3 & 8) != 0 ? false : z);
    }
}
