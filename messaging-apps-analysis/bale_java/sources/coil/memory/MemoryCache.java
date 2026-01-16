package coil.memory;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18638p;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.ED1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* loaded from: classes2.dex */
public interface MemoryCache {

    public static final class a {
        private final Context a;
        private double b;
        private int c;
        private boolean d = true;
        private boolean e = true;

        public a(Context context) {
            this.a = context;
            this.b = AbstractC18638p.e(context);
        }

        public final MemoryCache a() {
            g aVar;
            h fVar = this.e ? new f() : new coil.memory.b();
            if (this.d) {
                double d = this.b;
                int iC = d > 0.0d ? AbstractC18638p.c(this.a, d) : this.c;
                aVar = iC > 0 ? new e(iC, fVar) : new coil.memory.a(fVar);
            } else {
                aVar = new coil.memory.a(fVar);
            }
            return new d(aVar, fVar);
        }

        public final a b(double d) {
            if (0.0d > d || d > 1.0d) {
                throw new IllegalArgumentException("size must be in the range [0.0, 1.0].".toString());
            }
            this.c = 0;
            this.b = d;
            return this;
        }
    }

    public static final class b {
        private final Bitmap a;
        private final Map b;

        public b(Bitmap bitmap, Map map) {
            this.a = bitmap;
            this.b = map;
        }

        public final Bitmap a() {
            return this.a;
        }

        public final Map b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "Value(bitmap=" + this.a + ", extras=" + this.b + ')';
        }
    }

    void a(int i);

    b b(Key key);

    void c(Key key, b bVar);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001dB%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0013R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcoil/memory/MemoryCache$Key;", "Landroid/os/Parcelable;", "", "key", "", "extras", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "a", "(Ljava/lang/String;Ljava/util/Map;)Lcoil/memory/MemoryCache$Key;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getKey", "b", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "coil-base_release"}, k = 1, mv = {1, 9, 0})
    public static final class Key implements Parcelable {

        /* renamed from: a, reason: from kotlin metadata and from toString */
        private final String key;

        /* renamed from: b, reason: from kotlin metadata and from toString */
        private final Map extras;
        private static final b c = new b(null);

        @Deprecated
        public static final Parcelable.Creator<Key> CREATOR = new a();

        public static final class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Key createFromParcel(Parcel parcel) {
                String string = parcel.readString();
                AbstractC13042fc3.f(string);
                int i = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i);
                for (int i2 = 0; i2 < i; i2++) {
                    String string2 = parcel.readString();
                    AbstractC13042fc3.f(string2);
                    String string3 = parcel.readString();
                    AbstractC13042fc3.f(string3);
                    linkedHashMap.put(string2, string3);
                }
                return new Key(string, linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Key[] newArray(int i) {
                return new Key[i];
            }
        }

        private static final class b {
            private b() {
            }

            public /* synthetic */ b(ED1 ed1) {
                this();
            }
        }

        public Key(String str, Map map) {
            this.key = str;
            this.extras = map;
        }

        public static /* synthetic */ Key b(Key key, String str, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = key.key;
            }
            if ((i & 2) != 0) {
                map = key.extras;
            }
            return key.a(str, map);
        }

        public final Key a(String key, Map extras) {
            return new Key(key, extras);
        }

        /* renamed from: c, reason: from getter */
        public final Map getExtras() {
            return this.extras;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Key) {
                Key key = (Key) other;
                if (AbstractC13042fc3.d(this.key, key.key) && AbstractC13042fc3.d(this.extras, key.extras)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.extras.hashCode();
        }

        public String toString() {
            return "Key(key=" + this.key + ", extras=" + this.extras + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeString(this.key);
            parcel.writeInt(this.extras.size());
            for (Map.Entry entry : this.extras.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                parcel.writeString(str);
                parcel.writeString(str2);
            }
        }

        public /* synthetic */ Key(String str, Map map, int i, ED1 ed1) {
            this(str, (i & 2) != 0 ? AbstractC20051rO3.k() : map);
        }
    }
}
