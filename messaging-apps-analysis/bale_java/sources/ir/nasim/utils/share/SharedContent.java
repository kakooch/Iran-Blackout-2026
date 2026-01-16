package ir.nasim.utils.share;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.ED1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lir/nasim/utils/share/SharedContent;", "Landroid/os/Parcelable;", "<init>", "()V", "Text", "Album", "MediaContent", "Lir/nasim/utils/share/SharedContent$Album;", "Lir/nasim/utils/share/SharedContent$MediaContent;", "Lir/nasim/utils/share/SharedContent$Text;", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class SharedContent implements Parcelable {

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0080\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013H×\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\fH×\u0001¢\u0006\u0004\b\u0016\u0010\u0012J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H×\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e¨\u0006\u001f"}, d2 = {"Lir/nasim/utils/share/SharedContent$Album;", "Lir/nasim/utils/share/SharedContent;", "", "Lir/nasim/utils/share/SharedContent$MediaContent;", "sharedContents", "<init>", "(Ljava/util/List;)V", "sharedContent", "b", "(Lir/nasim/utils/share/SharedContent$MediaContent;)Lir/nasim/utils/share/SharedContent$Album;", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "()Ljava/util/List;", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Album extends SharedContent {
        public static final Parcelable.Creator<Album> CREATOR = new a();

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final List sharedContents;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Album createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(parcel.readParcelable(Album.class.getClassLoader()));
                }
                return new Album(arrayList);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Album[] newArray(int i) {
                return new Album[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Album(List list) {
            super(null);
            AbstractC13042fc3.i(list, "sharedContents");
            this.sharedContents = list;
        }

        /* renamed from: a, reason: from getter */
        public final List getSharedContents() {
            return this.sharedContents;
        }

        public final Album b(MediaContent sharedContent) {
            AbstractC13042fc3.i(sharedContent, "sharedContent");
            return new Album(AbstractC15401jX0.S0(this.sharedContents, sharedContent));
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Album) && AbstractC13042fc3.d(this.sharedContents, ((Album) other).sharedContents);
        }

        public int hashCode() {
            return this.sharedContents.hashCode();
        }

        public String toString() {
            return "Album(sharedContents=" + this.sharedContents + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            List list = this.sharedContents;
            dest.writeInt(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                dest.writeParcelable((Parcelable) it.next(), flags);
            }
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0018\u0019\u001a\u001b\u001cB\t\b\u0005¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000H\u0080\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0001\u0005\u001d\u001e\u001f !¨\u0006\""}, d2 = {"Lir/nasim/utils/share/SharedContent$MediaContent;", "Lir/nasim/utils/share/SharedContent;", "<init>", "()V", "sharedContent", "Lir/nasim/utils/share/SharedContent$Album;", "f", "(Lir/nasim/utils/share/SharedContent$MediaContent;)Lir/nasim/utils/share/SharedContent$Album;", "", "caption", "a", "(Ljava/lang/CharSequence;)Lir/nasim/utils/share/SharedContent$MediaContent;", "", "d", "()Ljava/lang/String;", "filePath", "e", "mimeType", "", "b", "()Z", "canBeGrouped", "c", "()Ljava/lang/CharSequence;", "Gif", "Image", "Video", "Audio", "File", "Lir/nasim/utils/share/SharedContent$MediaContent$Audio;", "Lir/nasim/utils/share/SharedContent$MediaContent$File;", "Lir/nasim/utils/share/SharedContent$MediaContent$Gif;", "Lir/nasim/utils/share/SharedContent$MediaContent$Image;", "Lir/nasim/utils/share/SharedContent$MediaContent$Video;", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static abstract class MediaContent extends SharedContent {

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÇ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000fH×\u0001¢\u0006\u0004\b\u001a\u0010\u0015J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH×\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010%\u001a\u0004\b(\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010)\u001a\u0004\b'\u0010*R\u001a\u0010-\u001a\u00020\u001d8\u0016X\u0096D¢\u0006\f\n\u0004\b(\u0010+\u001a\u0004\b$\u0010,¨\u0006."}, d2 = {"Lir/nasim/utils/share/SharedContent$MediaContent$Audio;", "Lir/nasim/utils/share/SharedContent$MediaContent;", "Landroid/net/Uri;", "uri", "", "filePath", "mimeType", "", "caption", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;)V", "g", "(Ljava/lang/CharSequence;)Lir/nasim/utils/share/SharedContent$MediaContent$Audio;", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "h", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;)Lir/nasim/utils/share/SharedContent$MediaContent$Audio;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "b", "Ljava/lang/String;", "d", "c", "e", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "Z", "()Z", "canBeGrouped", "nasim_release"}, k = 1, mv = {2, 0, 0})
        public static final /* data */ class Audio extends MediaContent {
            public static final Parcelable.Creator<Audio> CREATOR = new a();

            /* renamed from: a, reason: from kotlin metadata and from toString */
            private final Uri uri;

            /* renamed from: b, reason: from kotlin metadata and from toString */
            private final String filePath;

            /* renamed from: c, reason: from kotlin metadata and from toString */
            private final String mimeType;

            /* renamed from: d, reason: from kotlin metadata and from toString */
            private final CharSequence caption;

            /* renamed from: e, reason: from kotlin metadata */
            private final boolean canBeGrouped;

            public static final class a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Audio createFromParcel(Parcel parcel) {
                    AbstractC13042fc3.i(parcel, "parcel");
                    return new Audio((Uri) parcel.readParcelable(Audio.class.getClassLoader()), parcel.readString(), parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Audio[] newArray(int i) {
                    return new Audio[i];
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Audio(Uri uri, String str, String str2, CharSequence charSequence) {
                super(null);
                AbstractC13042fc3.i(uri, "uri");
                AbstractC13042fc3.i(str, "filePath");
                AbstractC13042fc3.i(str2, "mimeType");
                this.uri = uri;
                this.filePath = str;
                this.mimeType = str2;
                this.caption = charSequence;
            }

            public static /* synthetic */ Audio i(Audio audio, Uri uri, String str, String str2, CharSequence charSequence, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = audio.uri;
                }
                if ((i & 2) != 0) {
                    str = audio.filePath;
                }
                if ((i & 4) != 0) {
                    str2 = audio.mimeType;
                }
                if ((i & 8) != 0) {
                    charSequence = audio.caption;
                }
                return audio.h(uri, str, str2, charSequence);
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: b, reason: from getter */
            public boolean getCanBeGrouped() {
                return this.canBeGrouped;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: c, reason: from getter */
            public CharSequence getCaption() {
                return this.caption;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: d, reason: from getter */
            public String getFilePath() {
                return this.filePath;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: e, reason: from getter */
            public String getMimeType() {
                return this.mimeType;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Audio)) {
                    return false;
                }
                Audio audio = (Audio) other;
                return AbstractC13042fc3.d(this.uri, audio.uri) && AbstractC13042fc3.d(this.filePath, audio.filePath) && AbstractC13042fc3.d(this.mimeType, audio.mimeType) && AbstractC13042fc3.d(this.caption, audio.caption);
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public Audio a(CharSequence caption) {
                return i(this, null, null, null, caption, 7, null);
            }

            public final Audio h(Uri uri, String filePath, String mimeType, CharSequence caption) {
                AbstractC13042fc3.i(uri, "uri");
                AbstractC13042fc3.i(filePath, "filePath");
                AbstractC13042fc3.i(mimeType, "mimeType");
                return new Audio(uri, filePath, mimeType, caption);
            }

            public int hashCode() {
                int iHashCode = ((((this.uri.hashCode() * 31) + this.filePath.hashCode()) * 31) + this.mimeType.hashCode()) * 31;
                CharSequence charSequence = this.caption;
                return iHashCode + (charSequence == null ? 0 : charSequence.hashCode());
            }

            public String toString() {
                return "Audio(uri=" + this.uri + ", filePath=" + this.filePath + ", mimeType=" + this.mimeType + ", caption=" + ((Object) this.caption) + Separators.RPAREN;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                AbstractC13042fc3.i(dest, "dest");
                dest.writeParcelable(this.uri, flags);
                dest.writeString(this.filePath);
                dest.writeString(this.mimeType);
                TextUtils.writeToParcel(this.caption, dest, flags);
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÇ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000fH×\u0001¢\u0006\u0004\b\u001a\u0010\u0015J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH×\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010%\u001a\u0004\b(\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010)\u001a\u0004\b'\u0010*R\u001a\u0010-\u001a\u00020\u001d8\u0016X\u0096D¢\u0006\f\n\u0004\b(\u0010+\u001a\u0004\b$\u0010,¨\u0006."}, d2 = {"Lir/nasim/utils/share/SharedContent$MediaContent$File;", "Lir/nasim/utils/share/SharedContent$MediaContent;", "Landroid/net/Uri;", "uri", "", "filePath", "mimeType", "", "caption", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;)V", "g", "(Ljava/lang/CharSequence;)Lir/nasim/utils/share/SharedContent$MediaContent$File;", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "h", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;)Lir/nasim/utils/share/SharedContent$MediaContent$File;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "b", "Ljava/lang/String;", "d", "c", "e", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "Z", "()Z", "canBeGrouped", "nasim_release"}, k = 1, mv = {2, 0, 0})
        public static final /* data */ class File extends MediaContent {
            public static final Parcelable.Creator<File> CREATOR = new a();

            /* renamed from: a, reason: from kotlin metadata and from toString */
            private final Uri uri;

            /* renamed from: b, reason: from kotlin metadata and from toString */
            private final String filePath;

            /* renamed from: c, reason: from kotlin metadata and from toString */
            private final String mimeType;

            /* renamed from: d, reason: from kotlin metadata and from toString */
            private final CharSequence caption;

            /* renamed from: e, reason: from kotlin metadata */
            private final boolean canBeGrouped;

            public static final class a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final File createFromParcel(Parcel parcel) {
                    AbstractC13042fc3.i(parcel, "parcel");
                    return new File((Uri) parcel.readParcelable(File.class.getClassLoader()), parcel.readString(), parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final File[] newArray(int i) {
                    return new File[i];
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public File(Uri uri, String str, String str2, CharSequence charSequence) {
                super(null);
                AbstractC13042fc3.i(uri, "uri");
                AbstractC13042fc3.i(str, "filePath");
                AbstractC13042fc3.i(str2, "mimeType");
                this.uri = uri;
                this.filePath = str;
                this.mimeType = str2;
                this.caption = charSequence;
            }

            public static /* synthetic */ File i(File file, Uri uri, String str, String str2, CharSequence charSequence, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = file.uri;
                }
                if ((i & 2) != 0) {
                    str = file.filePath;
                }
                if ((i & 4) != 0) {
                    str2 = file.mimeType;
                }
                if ((i & 8) != 0) {
                    charSequence = file.caption;
                }
                return file.h(uri, str, str2, charSequence);
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: b, reason: from getter */
            public boolean getCanBeGrouped() {
                return this.canBeGrouped;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: c, reason: from getter */
            public CharSequence getCaption() {
                return this.caption;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: d, reason: from getter */
            public String getFilePath() {
                return this.filePath;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: e, reason: from getter */
            public String getMimeType() {
                return this.mimeType;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof File)) {
                    return false;
                }
                File file = (File) other;
                return AbstractC13042fc3.d(this.uri, file.uri) && AbstractC13042fc3.d(this.filePath, file.filePath) && AbstractC13042fc3.d(this.mimeType, file.mimeType) && AbstractC13042fc3.d(this.caption, file.caption);
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public File a(CharSequence caption) {
                return i(this, null, null, null, caption, 7, null);
            }

            public final File h(Uri uri, String filePath, String mimeType, CharSequence caption) {
                AbstractC13042fc3.i(uri, "uri");
                AbstractC13042fc3.i(filePath, "filePath");
                AbstractC13042fc3.i(mimeType, "mimeType");
                return new File(uri, filePath, mimeType, caption);
            }

            public int hashCode() {
                int iHashCode = ((((this.uri.hashCode() * 31) + this.filePath.hashCode()) * 31) + this.mimeType.hashCode()) * 31;
                CharSequence charSequence = this.caption;
                return iHashCode + (charSequence == null ? 0 : charSequence.hashCode());
            }

            public String toString() {
                return "File(uri=" + this.uri + ", filePath=" + this.filePath + ", mimeType=" + this.mimeType + ", caption=" + ((Object) this.caption) + Separators.RPAREN;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                AbstractC13042fc3.i(dest, "dest");
                dest.writeParcelable(this.uri, flags);
                dest.writeString(this.filePath);
                dest.writeString(this.mimeType);
                TextUtils.writeToParcel(this.caption, dest, flags);
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÇ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000fH×\u0001¢\u0006\u0004\b\u001a\u0010\u0015J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH×\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010%\u001a\u0004\b(\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010)\u001a\u0004\b'\u0010*R\u001a\u0010-\u001a\u00020\u001d8\u0016X\u0096D¢\u0006\f\n\u0004\b(\u0010+\u001a\u0004\b$\u0010,¨\u0006."}, d2 = {"Lir/nasim/utils/share/SharedContent$MediaContent$Image;", "Lir/nasim/utils/share/SharedContent$MediaContent;", "Landroid/net/Uri;", "uri", "", "filePath", "mimeType", "", "caption", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;)V", "g", "(Ljava/lang/CharSequence;)Lir/nasim/utils/share/SharedContent$MediaContent$Image;", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "h", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;)Lir/nasim/utils/share/SharedContent$MediaContent$Image;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Landroid/net/Uri;", "j", "()Landroid/net/Uri;", "b", "Ljava/lang/String;", "d", "c", "e", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "Z", "()Z", "canBeGrouped", "nasim_release"}, k = 1, mv = {2, 0, 0})
        public static final /* data */ class Image extends MediaContent {
            public static final Parcelable.Creator<Image> CREATOR = new a();

            /* renamed from: a, reason: from kotlin metadata and from toString */
            private final Uri uri;

            /* renamed from: b, reason: from kotlin metadata and from toString */
            private final String filePath;

            /* renamed from: c, reason: from kotlin metadata and from toString */
            private final String mimeType;

            /* renamed from: d, reason: from kotlin metadata and from toString */
            private final CharSequence caption;

            /* renamed from: e, reason: from kotlin metadata */
            private final boolean canBeGrouped;

            public static final class a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Image createFromParcel(Parcel parcel) {
                    AbstractC13042fc3.i(parcel, "parcel");
                    return new Image((Uri) parcel.readParcelable(Image.class.getClassLoader()), parcel.readString(), parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Image[] newArray(int i) {
                    return new Image[i];
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Image(Uri uri, String str, String str2, CharSequence charSequence) {
                super(null);
                AbstractC13042fc3.i(uri, "uri");
                AbstractC13042fc3.i(str, "filePath");
                AbstractC13042fc3.i(str2, "mimeType");
                this.uri = uri;
                this.filePath = str;
                this.mimeType = str2;
                this.caption = charSequence;
                this.canBeGrouped = true;
            }

            public static /* synthetic */ Image i(Image image, Uri uri, String str, String str2, CharSequence charSequence, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = image.uri;
                }
                if ((i & 2) != 0) {
                    str = image.filePath;
                }
                if ((i & 4) != 0) {
                    str2 = image.mimeType;
                }
                if ((i & 8) != 0) {
                    charSequence = image.caption;
                }
                return image.h(uri, str, str2, charSequence);
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: b, reason: from getter */
            public boolean getCanBeGrouped() {
                return this.canBeGrouped;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: c, reason: from getter */
            public CharSequence getCaption() {
                return this.caption;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: d, reason: from getter */
            public String getFilePath() {
                return this.filePath;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: e, reason: from getter */
            public String getMimeType() {
                return this.mimeType;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Image)) {
                    return false;
                }
                Image image = (Image) other;
                return AbstractC13042fc3.d(this.uri, image.uri) && AbstractC13042fc3.d(this.filePath, image.filePath) && AbstractC13042fc3.d(this.mimeType, image.mimeType) && AbstractC13042fc3.d(this.caption, image.caption);
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public Image a(CharSequence caption) {
                return i(this, null, null, null, caption, 7, null);
            }

            public final Image h(Uri uri, String filePath, String mimeType, CharSequence caption) {
                AbstractC13042fc3.i(uri, "uri");
                AbstractC13042fc3.i(filePath, "filePath");
                AbstractC13042fc3.i(mimeType, "mimeType");
                return new Image(uri, filePath, mimeType, caption);
            }

            public int hashCode() {
                int iHashCode = ((((this.uri.hashCode() * 31) + this.filePath.hashCode()) * 31) + this.mimeType.hashCode()) * 31;
                CharSequence charSequence = this.caption;
                return iHashCode + (charSequence == null ? 0 : charSequence.hashCode());
            }

            /* renamed from: j, reason: from getter */
            public Uri getUri() {
                return this.uri;
            }

            public String toString() {
                return "Image(uri=" + this.uri + ", filePath=" + this.filePath + ", mimeType=" + this.mimeType + ", caption=" + ((Object) this.caption) + Separators.RPAREN;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                AbstractC13042fc3.i(dest, "dest");
                dest.writeParcelable(this.uri, flags);
                dest.writeString(this.filePath);
                dest.writeString(this.mimeType);
                TextUtils.writeToParcel(this.caption, dest, flags);
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0016\u0010\u0017JD\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\tHÇ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0011H×\u0001¢\u0006\u0004\b\u001c\u0010\u0017J\u001a\u0010\u001f\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH×\u0003¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u001bR\u001a\u0010\u0006\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010*\u001a\u0004\b(\u0010+R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b)\u0010,\u001a\u0004\b-\u0010.R\u001a\u00100\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b%\u0010.¨\u00061"}, d2 = {"Lir/nasim/utils/share/SharedContent$MediaContent$Video;", "Lir/nasim/utils/share/SharedContent$MediaContent;", "Landroid/net/Uri;", "uri", "", "filePath", "mimeType", "", "caption", "", "needToBeCompressed", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Z)V", "g", "(Ljava/lang/CharSequence;)Lir/nasim/utils/share/SharedContent$MediaContent$Video;", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "h", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Z)Lir/nasim/utils/share/SharedContent$MediaContent$Video;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Landroid/net/Uri;", "k", "()Landroid/net/Uri;", "b", "Ljava/lang/String;", "d", "c", "e", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "Z", "j", "()Z", "f", "canBeGrouped", "nasim_release"}, k = 1, mv = {2, 0, 0})
        public static final /* data */ class Video extends MediaContent {
            public static final Parcelable.Creator<Video> CREATOR = new a();

            /* renamed from: a, reason: from kotlin metadata and from toString */
            private final Uri uri;

            /* renamed from: b, reason: from kotlin metadata and from toString */
            private final String filePath;

            /* renamed from: c, reason: from kotlin metadata and from toString */
            private final String mimeType;

            /* renamed from: d, reason: from kotlin metadata and from toString */
            private final CharSequence caption;

            /* renamed from: e, reason: from kotlin metadata and from toString */
            private final boolean needToBeCompressed;

            /* renamed from: f, reason: from kotlin metadata */
            private final boolean canBeGrouped;

            public static final class a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Video createFromParcel(Parcel parcel) {
                    AbstractC13042fc3.i(parcel, "parcel");
                    return new Video((Uri) parcel.readParcelable(Video.class.getClassLoader()), parcel.readString(), parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Video[] newArray(int i) {
                    return new Video[i];
                }
            }

            public /* synthetic */ Video(Uri uri, String str, String str2, CharSequence charSequence, boolean z, int i, ED1 ed1) {
                this(uri, str, str2, charSequence, (i & 16) != 0 ? false : z);
            }

            public static /* synthetic */ Video i(Video video, Uri uri, String str, String str2, CharSequence charSequence, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = video.uri;
                }
                if ((i & 2) != 0) {
                    str = video.filePath;
                }
                String str3 = str;
                if ((i & 4) != 0) {
                    str2 = video.mimeType;
                }
                String str4 = str2;
                if ((i & 8) != 0) {
                    charSequence = video.caption;
                }
                CharSequence charSequence2 = charSequence;
                if ((i & 16) != 0) {
                    z = video.needToBeCompressed;
                }
                return video.h(uri, str3, str4, charSequence2, z);
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: b, reason: from getter */
            public boolean getCanBeGrouped() {
                return this.canBeGrouped;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: c, reason: from getter */
            public CharSequence getCaption() {
                return this.caption;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: d, reason: from getter */
            public String getFilePath() {
                return this.filePath;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: e, reason: from getter */
            public String getMimeType() {
                return this.mimeType;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Video)) {
                    return false;
                }
                Video video = (Video) other;
                return AbstractC13042fc3.d(this.uri, video.uri) && AbstractC13042fc3.d(this.filePath, video.filePath) && AbstractC13042fc3.d(this.mimeType, video.mimeType) && AbstractC13042fc3.d(this.caption, video.caption) && this.needToBeCompressed == video.needToBeCompressed;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public Video a(CharSequence caption) {
                return i(this, null, null, null, caption, false, 23, null);
            }

            public final Video h(Uri uri, String filePath, String mimeType, CharSequence caption, boolean needToBeCompressed) {
                AbstractC13042fc3.i(uri, "uri");
                AbstractC13042fc3.i(filePath, "filePath");
                AbstractC13042fc3.i(mimeType, "mimeType");
                return new Video(uri, filePath, mimeType, caption, needToBeCompressed);
            }

            public int hashCode() {
                int iHashCode = ((((this.uri.hashCode() * 31) + this.filePath.hashCode()) * 31) + this.mimeType.hashCode()) * 31;
                CharSequence charSequence = this.caption;
                return ((iHashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31) + Boolean.hashCode(this.needToBeCompressed);
            }

            /* renamed from: j, reason: from getter */
            public final boolean getNeedToBeCompressed() {
                return this.needToBeCompressed;
            }

            /* renamed from: k, reason: from getter */
            public Uri getUri() {
                return this.uri;
            }

            public String toString() {
                Uri uri = this.uri;
                String str = this.filePath;
                String str2 = this.mimeType;
                CharSequence charSequence = this.caption;
                return "Video(uri=" + uri + ", filePath=" + str + ", mimeType=" + str2 + ", caption=" + ((Object) charSequence) + ", needToBeCompressed=" + this.needToBeCompressed + Separators.RPAREN;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                AbstractC13042fc3.i(dest, "dest");
                dest.writeParcelable(this.uri, flags);
                dest.writeString(this.filePath);
                dest.writeString(this.mimeType);
                TextUtils.writeToParcel(this.caption, dest, flags);
                dest.writeInt(this.needToBeCompressed ? 1 : 0);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Video(Uri uri, String str, String str2, CharSequence charSequence, boolean z) {
                super(null);
                AbstractC13042fc3.i(uri, "uri");
                AbstractC13042fc3.i(str, "filePath");
                AbstractC13042fc3.i(str2, "mimeType");
                this.uri = uri;
                this.filePath = str;
                this.mimeType = str2;
                this.caption = charSequence;
                this.needToBeCompressed = z;
                this.canBeGrouped = true;
            }
        }

        public /* synthetic */ MediaContent(ED1 ed1) {
            this();
        }

        public abstract MediaContent a(CharSequence caption);

        /* renamed from: b */
        public abstract boolean getCanBeGrouped();

        /* renamed from: c */
        public abstract CharSequence getCaption();

        /* renamed from: d */
        public abstract String getFilePath();

        /* renamed from: e */
        public abstract String getMimeType();

        public final Album f(MediaContent sharedContent) {
            AbstractC13042fc3.i(sharedContent, "sharedContent");
            return new Album(AbstractC10360bX0.p(this, sharedContent));
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004HÇ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000fH×\u0001¢\u0006\u0004\b\u001a\u0010\u0015J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH×\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b'\u0010)R\u001a\u0010\b\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010%\u001a\u0004\b*\u0010\u0019R\u001a\u0010-\u001a\u00020\u001d8\u0016X\u0096D¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b$\u0010,¨\u0006."}, d2 = {"Lir/nasim/utils/share/SharedContent$MediaContent$Gif;", "Lir/nasim/utils/share/SharedContent$MediaContent;", "Landroid/net/Uri;", "uri", "", "filePath", "", "caption", "mimeType", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;)V", "g", "(Ljava/lang/CharSequence;)Lir/nasim/utils/share/SharedContent$MediaContent$Gif;", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "h", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/String;)Lir/nasim/utils/share/SharedContent$MediaContent$Gif;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "b", "Ljava/lang/String;", "d", "c", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "e", "Z", "()Z", "canBeGrouped", "nasim_release"}, k = 1, mv = {2, 0, 0})
        public static final /* data */ class Gif extends MediaContent {
            public static final Parcelable.Creator<Gif> CREATOR = new a();

            /* renamed from: a, reason: from kotlin metadata and from toString */
            private final Uri uri;

            /* renamed from: b, reason: from kotlin metadata and from toString */
            private final String filePath;

            /* renamed from: c, reason: from kotlin metadata and from toString */
            private final CharSequence caption;

            /* renamed from: d, reason: from kotlin metadata and from toString */
            private final String mimeType;

            /* renamed from: e, reason: from kotlin metadata */
            private final boolean canBeGrouped;

            public static final class a implements Parcelable.Creator {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Gif createFromParcel(Parcel parcel) {
                    AbstractC13042fc3.i(parcel, "parcel");
                    return new Gif((Uri) parcel.readParcelable(Gif.class.getClassLoader()), parcel.readString(), (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Gif[] newArray(int i) {
                    return new Gif[i];
                }
            }

            public /* synthetic */ Gif(Uri uri, String str, CharSequence charSequence, String str2, int i, ED1 ed1) {
                this(uri, str, charSequence, (i & 8) != 0 ? "image/gif" : str2);
            }

            public static /* synthetic */ Gif i(Gif gif, Uri uri, String str, CharSequence charSequence, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = gif.uri;
                }
                if ((i & 2) != 0) {
                    str = gif.filePath;
                }
                if ((i & 4) != 0) {
                    charSequence = gif.caption;
                }
                if ((i & 8) != 0) {
                    str2 = gif.mimeType;
                }
                return gif.h(uri, str, charSequence, str2);
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: b, reason: from getter */
            public boolean getCanBeGrouped() {
                return this.canBeGrouped;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: c, reason: from getter */
            public CharSequence getCaption() {
                return this.caption;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: d, reason: from getter */
            public String getFilePath() {
                return this.filePath;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: e, reason: from getter */
            public String getMimeType() {
                return this.mimeType;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Gif)) {
                    return false;
                }
                Gif gif = (Gif) other;
                return AbstractC13042fc3.d(this.uri, gif.uri) && AbstractC13042fc3.d(this.filePath, gif.filePath) && AbstractC13042fc3.d(this.caption, gif.caption) && AbstractC13042fc3.d(this.mimeType, gif.mimeType);
            }

            @Override // ir.nasim.utils.share.SharedContent.MediaContent
            /* renamed from: g, reason: merged with bridge method [inline-methods] */
            public Gif a(CharSequence caption) {
                return i(this, null, null, caption, null, 11, null);
            }

            public final Gif h(Uri uri, String filePath, CharSequence caption, String mimeType) {
                AbstractC13042fc3.i(uri, "uri");
                AbstractC13042fc3.i(filePath, "filePath");
                AbstractC13042fc3.i(mimeType, "mimeType");
                return new Gif(uri, filePath, caption, mimeType);
            }

            public int hashCode() {
                int iHashCode = ((this.uri.hashCode() * 31) + this.filePath.hashCode()) * 31;
                CharSequence charSequence = this.caption;
                return ((iHashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31) + this.mimeType.hashCode();
            }

            public String toString() {
                Uri uri = this.uri;
                String str = this.filePath;
                CharSequence charSequence = this.caption;
                return "Gif(uri=" + uri + ", filePath=" + str + ", caption=" + ((Object) charSequence) + ", mimeType=" + this.mimeType + Separators.RPAREN;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel dest, int flags) {
                AbstractC13042fc3.i(dest, "dest");
                dest.writeParcelable(this.uri, flags);
                dest.writeString(this.filePath);
                TextUtils.writeToParcel(this.caption, dest, flags);
                dest.writeString(this.mimeType);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Gif(Uri uri, String str, CharSequence charSequence, String str2) {
                super(null);
                AbstractC13042fc3.i(uri, "uri");
                AbstractC13042fc3.i(str, "filePath");
                AbstractC13042fc3.i(str2, "mimeType");
                this.uri = uri;
                this.filePath = str;
                this.caption = charSequence;
                this.mimeType = str2;
            }
        }

        private MediaContent() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH×\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\bH×\u0001¢\u0006\u0004\b\u0012\u0010\u000eJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H×\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a¨\u0006\u001b"}, d2 = {"Lir/nasim/utils/share/SharedContent$Text;", "Lir/nasim/utils/share/SharedContent;", "", ParameterNames.TEXT, "<init>", "(Ljava/lang/CharSequence;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Text extends SharedContent {
        public static final Parcelable.Creator<Text> CREATOR = new a();

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final CharSequence text;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Text createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new Text((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Text[] newArray(int i) {
                return new Text[i];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Text(CharSequence charSequence) {
            super(null);
            AbstractC13042fc3.i(charSequence, ParameterNames.TEXT);
            this.text = charSequence;
        }

        /* renamed from: a, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Text) && AbstractC13042fc3.d(this.text, ((Text) other).text);
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public String toString() {
            return "Text(text=" + ((Object) this.text) + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            TextUtils.writeToParcel(this.text, dest, flags);
        }
    }

    private SharedContent() {
    }

    public /* synthetic */ SharedContent(ED1 ed1) {
        this();
    }
}
