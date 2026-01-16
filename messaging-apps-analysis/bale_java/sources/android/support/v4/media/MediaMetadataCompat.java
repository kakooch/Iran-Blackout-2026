package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import ir.nasim.KJ;
import java.util.Set;

/* loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    static final KJ d;
    private static final String[] e;
    private static final String[] f;
    private static final String[] g;
    final Bundle a;
    private MediaMetadata b;
    private MediaDescriptionCompat c;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaMetadataCompat[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }
    }

    public static final class b {
        private final Bundle a = new Bundle();

        public MediaMetadataCompat a() {
            return new MediaMetadataCompat(this.a);
        }

        public b b(String str, Bitmap bitmap) {
            KJ kj = MediaMetadataCompat.d;
            if (!kj.containsKey(str) || ((Integer) kj.get(str)).intValue() == 2) {
                this.a.putParcelable(str, bitmap);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
        }

        public b c(String str, long j) {
            KJ kj = MediaMetadataCompat.d;
            if (!kj.containsKey(str) || ((Integer) kj.get(str)).intValue() == 0) {
                this.a.putLong(str, j);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
        }

        public b d(String str, RatingCompat ratingCompat) {
            KJ kj = MediaMetadataCompat.d;
            if (!kj.containsKey(str) || ((Integer) kj.get(str)).intValue() == 3) {
                this.a.putParcelable(str, (Parcelable) ratingCompat.c());
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
        }

        public b e(String str, String str2) {
            KJ kj = MediaMetadataCompat.d;
            if (!kj.containsKey(str) || ((Integer) kj.get(str)).intValue() == 1) {
                this.a.putCharSequence(str, str2);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
        }

        public b f(String str, CharSequence charSequence) {
            KJ kj = MediaMetadataCompat.d;
            if (!kj.containsKey(str) || ((Integer) kj.get(str)).intValue() == 1) {
                this.a.putCharSequence(str, charSequence);
                return this;
            }
            throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
        }
    }

    static {
        KJ kj = new KJ();
        d = kj;
        kj.put("android.media.metadata.TITLE", 1);
        kj.put("android.media.metadata.ARTIST", 1);
        kj.put("android.media.metadata.DURATION", 0);
        kj.put("android.media.metadata.ALBUM", 1);
        kj.put("android.media.metadata.AUTHOR", 1);
        kj.put("android.media.metadata.WRITER", 1);
        kj.put("android.media.metadata.COMPOSER", 1);
        kj.put("android.media.metadata.COMPILATION", 1);
        kj.put("android.media.metadata.DATE", 1);
        kj.put("android.media.metadata.YEAR", 0);
        kj.put("android.media.metadata.GENRE", 1);
        kj.put("android.media.metadata.TRACK_NUMBER", 0);
        kj.put("android.media.metadata.NUM_TRACKS", 0);
        kj.put("android.media.metadata.DISC_NUMBER", 0);
        kj.put("android.media.metadata.ALBUM_ARTIST", 1);
        kj.put("android.media.metadata.ART", 2);
        kj.put("android.media.metadata.ART_URI", 1);
        kj.put("android.media.metadata.ALBUM_ART", 2);
        kj.put("android.media.metadata.ALBUM_ART_URI", 1);
        kj.put("android.media.metadata.USER_RATING", 3);
        kj.put("android.media.metadata.RATING", 3);
        kj.put("android.media.metadata.DISPLAY_TITLE", 1);
        kj.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        kj.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        kj.put("android.media.metadata.DISPLAY_ICON", 2);
        kj.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        kj.put("android.media.metadata.MEDIA_ID", 1);
        kj.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        kj.put("android.media.metadata.MEDIA_URI", 1);
        kj.put("android.media.metadata.ADVERTISEMENT", 0);
        kj.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        e = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        f = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        g = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        CREATOR = new a();
    }

    MediaMetadataCompat(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        this.a = bundle2;
        MediaSessionCompat.a(bundle2);
    }

    public static MediaMetadataCompat b(Object obj) {
        if (obj == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        mediaMetadata.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompatCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        mediaMetadataCompatCreateFromParcel.b = mediaMetadata;
        return mediaMetadataCompatCreateFromParcel;
    }

    public boolean a(String str) {
        return this.a.containsKey(str);
    }

    public Bitmap c(String str) {
        try {
            return (Bitmap) this.a.getParcelable(str);
        } catch (Exception e2) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", e2);
            return null;
        }
    }

    public Bundle d() {
        return new Bundle(this.a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MediaDescriptionCompat e() {
        Bitmap bitmapC;
        Uri uri;
        MediaDescriptionCompat mediaDescriptionCompat = this.c;
        if (mediaDescriptionCompat != null) {
            return mediaDescriptionCompat;
        }
        String strH = h("android.media.metadata.MEDIA_ID");
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence charSequenceI = i("android.media.metadata.DISPLAY_TITLE");
        if (TextUtils.isEmpty(charSequenceI)) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                String[] strArr = e;
                if (i2 >= strArr.length) {
                    break;
                }
                int i3 = i2 + 1;
                CharSequence charSequenceI2 = i(strArr[i2]);
                if (!TextUtils.isEmpty(charSequenceI2)) {
                    charSequenceArr[i] = charSequenceI2;
                    i++;
                }
                i2 = i3;
            }
        } else {
            charSequenceArr[0] = charSequenceI;
            charSequenceArr[1] = i("android.media.metadata.DISPLAY_SUBTITLE");
            charSequenceArr[2] = i("android.media.metadata.DISPLAY_DESCRIPTION");
        }
        int i4 = 0;
        while (true) {
            String[] strArr2 = f;
            if (i4 >= strArr2.length) {
                bitmapC = null;
                break;
            }
            bitmapC = c(strArr2[i4]);
            if (bitmapC != null) {
                break;
            }
            i4++;
        }
        int i5 = 0;
        while (true) {
            String[] strArr3 = g;
            if (i5 >= strArr3.length) {
                uri = null;
                break;
            }
            String strH2 = h(strArr3[i5]);
            if (!TextUtils.isEmpty(strH2)) {
                uri = Uri.parse(strH2);
                break;
            }
            i5++;
        }
        String strH3 = h("android.media.metadata.MEDIA_URI");
        Uri uri2 = TextUtils.isEmpty(strH3) ? null : Uri.parse(strH3);
        MediaDescriptionCompat.d dVar = new MediaDescriptionCompat.d();
        dVar.f(strH);
        dVar.i(charSequenceArr[0]);
        dVar.h(charSequenceArr[1]);
        dVar.b(charSequenceArr[2]);
        dVar.d(bitmapC);
        dVar.e(uri);
        dVar.g(uri2);
        Bundle bundle = new Bundle();
        if (this.a.containsKey("android.media.metadata.BT_FOLDER_TYPE")) {
            bundle.putLong("android.media.extra.BT_FOLDER_TYPE", f("android.media.metadata.BT_FOLDER_TYPE"));
        }
        if (this.a.containsKey("android.media.metadata.DOWNLOAD_STATUS")) {
            bundle.putLong("android.media.extra.DOWNLOAD_STATUS", f("android.media.metadata.DOWNLOAD_STATUS"));
        }
        if (!bundle.isEmpty()) {
            dVar.c(bundle);
        }
        MediaDescriptionCompat mediaDescriptionCompatA = dVar.a();
        this.c = mediaDescriptionCompatA;
        return mediaDescriptionCompatA;
    }

    public long f(String str) {
        return this.a.getLong(str, 0L);
    }

    public Object g() {
        if (this.b == null) {
            Parcel parcelObtain = Parcel.obtain();
            writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            this.b = (MediaMetadata) MediaMetadata.CREATOR.createFromParcel(parcelObtain);
            parcelObtain.recycle();
        }
        return this.b;
    }

    public String h(String str) {
        CharSequence charSequence = this.a.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public CharSequence i(String str) {
        return this.a.getCharSequence(str);
    }

    public Set j() {
        return this.a.keySet();
    }

    public int k() {
        return this.a.size();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.a);
    }

    MediaMetadataCompat(Parcel parcel) {
        this.a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }
}
