package android.support.v4.media;

import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();
    private final int a;
    private final float b;
    private Object c;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    }

    private static class b {
        static float a(Rating rating) {
            return rating.getPercentRating();
        }

        static int b(Rating rating) {
            return rating.getRatingStyle();
        }

        static float c(Rating rating) {
            return rating.getStarRating();
        }

        static boolean d(Rating rating) {
            return rating.hasHeart();
        }

        static boolean e(Rating rating) {
            return rating.isRated();
        }

        static boolean f(Rating rating) {
            return rating.isThumbUp();
        }

        static Rating g(boolean z) {
            return Rating.newHeartRating(z);
        }

        static Rating h(float f) {
            return Rating.newPercentageRating(f);
        }

        static Rating i(int i, float f) {
            return Rating.newStarRating(i, f);
        }

        static Rating j(boolean z) {
            return Rating.newThumbRating(z);
        }

        static Rating k(int i) {
            return Rating.newUnratedRating(i);
        }
    }

    RatingCompat(int i, float f) {
        this.a = i;
        this.b = f;
    }

    public static RatingCompat a(Object obj) {
        RatingCompat ratingCompatM = null;
        if (obj != null) {
            Rating rating = (Rating) obj;
            int iB = b.b(rating);
            if (b.e(rating)) {
                switch (iB) {
                    case 1:
                        ratingCompatM = i(b.d(rating));
                        break;
                    case 2:
                        ratingCompatM = l(b.f(rating));
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompatM = k(iB, b.c(rating));
                        break;
                    case 6:
                        ratingCompatM = j(b.a(rating));
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompatM = m(iB);
            }
            ratingCompatM.c = obj;
        }
        return ratingCompatM;
    }

    public static RatingCompat i(boolean z) {
        return new RatingCompat(1, z ? 1.0f : 0.0f);
    }

    public static RatingCompat j(float f) {
        if (f >= 0.0f && f <= 100.0f) {
            return new RatingCompat(6, f);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat k(int i, float f) {
        float f2;
        if (i == 3) {
            f2 = 3.0f;
        } else if (i == 4) {
            f2 = 4.0f;
        } else {
            if (i != 5) {
                Log.e("Rating", "Invalid rating style (" + i + ") for a star rating");
                return null;
            }
            f2 = 5.0f;
        }
        if (f >= 0.0f && f <= f2) {
            return new RatingCompat(i, f);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat l(boolean z) {
        return new RatingCompat(2, z ? 1.0f : 0.0f);
    }

    public static RatingCompat m(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i, -1.0f);
            default:
                return null;
        }
    }

    public float b() {
        if (this.a == 6 && g()) {
            return this.b;
        }
        return -1.0f;
    }

    public Object c() {
        if (this.c == null) {
            if (g()) {
                int i = this.a;
                switch (i) {
                    case 1:
                        this.c = b.g(f());
                        break;
                    case 2:
                        this.c = b.j(h());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        this.c = b.i(i, e());
                        break;
                    case 6:
                        this.c = b.h(b());
                        break;
                    default:
                        return null;
                }
            } else {
                this.c = b.k(this.a);
            }
        }
        return this.c;
    }

    public int d() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.a;
    }

    public float e() {
        int i = this.a;
        if ((i == 3 || i == 4 || i == 5) && g()) {
            return this.b;
        }
        return -1.0f;
    }

    public boolean f() {
        return this.a == 1 && this.b == 1.0f;
    }

    public boolean g() {
        return this.b >= 0.0f;
    }

    public boolean h() {
        return this.a == 2 && this.b == 1.0f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.a);
        sb.append(" rating=");
        float f = this.b;
        sb.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeFloat(this.b);
    }
}
