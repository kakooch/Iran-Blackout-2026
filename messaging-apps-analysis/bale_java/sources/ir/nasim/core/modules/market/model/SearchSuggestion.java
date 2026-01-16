package ir.nasim.core.modules.market.model;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19406qI3;
import ir.nasim.ED1;
import ir.nasim.EnumC8772Xg3;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.KS2;
import ir.nasim.L17;
import java.util.ArrayList;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0003BCDBS\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b%\u0010$J\u0012\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b,\u0010$J`\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004HÇ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0004H×\u0001¢\u0006\u0004\b/\u0010$J\u0010\u00100\u001a\u00020\u001aH×\u0001¢\u0006\u0004\b0\u0010 J\u001a\u00103\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u000101H×\u0003¢\u0006\u0004\b3\u00104R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00105\u001a\u0004\b6\u0010\"R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00107\u001a\u0004\b8\u0010$R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u00107\u001a\u0004\b9\u0010$R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010:\u001a\u0004\b;\u0010'R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010<\u001a\u0004\b=\u0010)R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010>\u001a\u0004\b?\u0010+R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u00107\u001a\u0004\b@\u0010$¨\u0006E"}, d2 = {"Lir/nasim/core/modules/market/model/SearchSuggestion;", "Landroid/os/Parcelable;", "Lir/nasim/core/modules/market/model/SearchSuggestion$a;", "action", "", "term", "drawable", "Lir/nasim/core/modules/market/model/SearchSuggestion$Peer;", "peer", "Lir/nasim/L17;", "suggestionType", "Lir/nasim/Xg3;", "defaultTab", "displayName", "<init>", "(Lir/nasim/core/modules/market/model/SearchSuggestion$a;Ljava/lang/String;Ljava/lang/String;Lir/nasim/core/modules/market/model/SearchSuggestion$Peer;Lir/nasim/L17;Lir/nasim/Xg3;Ljava/lang/String;)V", "", "isWithDrawable", "()Z", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "getDrawableResources", "(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;", "Landroid/os/Parcel;", "dest", "", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Lir/nasim/core/modules/market/model/SearchSuggestion$a;", "component2", "()Ljava/lang/String;", "component3", "component4", "()Lir/nasim/core/modules/market/model/SearchSuggestion$Peer;", "component5", "()Lir/nasim/L17;", "component6", "()Lir/nasim/Xg3;", "component7", "copy", "(Lir/nasim/core/modules/market/model/SearchSuggestion$a;Ljava/lang/String;Ljava/lang/String;Lir/nasim/core/modules/market/model/SearchSuggestion$Peer;Lir/nasim/L17;Lir/nasim/Xg3;Ljava/lang/String;)Lir/nasim/core/modules/market/model/SearchSuggestion;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lir/nasim/core/modules/market/model/SearchSuggestion$a;", "getAction", "Ljava/lang/String;", "getTerm", "getDrawable", "Lir/nasim/core/modules/market/model/SearchSuggestion$Peer;", "getPeer", "Lir/nasim/L17;", "getSuggestionType", "Lir/nasim/Xg3;", "getDefaultTab", "getDisplayName", "Companion", "b", "a", "Peer", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final /* data */ class SearchSuggestion implements Parcelable {
    public static final int $stable = 0;
    public static final String ADS_ICON = "ads";
    public static final String CATEGORY_ICON = "category";
    public static final String TV_ICON = "tv";
    private final a action;
    private final EnumC8772Xg3 defaultTab;
    private final String displayName;
    private final String drawable;
    private final Peer peer;
    private final L17 suggestionType;
    private final String term;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SearchSuggestion> CREATOR = new c();

    @Keep
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0010J.\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÇ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002H×\u0001¢\u0006\u0004\b\u0017\u0010\u0012J\u0010\u0010\u0018\u001a\u00020\u0005H×\u0001¢\u0006\u0004\b\u0018\u0010\u0010J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H×\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b \u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010\u0010¨\u0006#"}, d2 = {"Lir/nasim/core/modules/market/model/SearchSuggestion$Peer;", "Landroid/os/Parcelable;", "", "nick", "title", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "Landroid/os/Parcel;", "dest", "flags", "Lir/nasim/rB7;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;I)Lir/nasim/core/modules/market/model/SearchSuggestion$Peer;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getNick", "getTitle", TokenNames.I, "getId", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final /* data */ class Peer implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Peer> CREATOR = new a();
        private final int id;
        private final String nick;
        private final String title;

        public static final class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Peer createFromParcel(Parcel parcel) {
                AbstractC13042fc3.i(parcel, "parcel");
                return new Peer(parcel.readString(), parcel.readString(), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Peer[] newArray(int i) {
                return new Peer[i];
            }
        }

        public Peer(String str, String str2, int i) {
            AbstractC13042fc3.i(str, "nick");
            AbstractC13042fc3.i(str2, "title");
            this.nick = str;
            this.title = str2;
            this.id = i;
        }

        public static /* synthetic */ Peer copy$default(Peer peer, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = peer.nick;
            }
            if ((i2 & 2) != 0) {
                str2 = peer.title;
            }
            if ((i2 & 4) != 0) {
                i = peer.id;
            }
            return peer.copy(str, str2, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getNick() {
            return this.nick;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final int getId() {
            return this.id;
        }

        public final Peer copy(String nick, String title, int id) {
            AbstractC13042fc3.i(nick, "nick");
            AbstractC13042fc3.i(title, "title");
            return new Peer(nick, title, id);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Peer)) {
                return false;
            }
            Peer peer = (Peer) other;
            return AbstractC13042fc3.d(this.nick, peer.nick) && AbstractC13042fc3.d(this.title, peer.title) && this.id == peer.id;
        }

        public final int getId() {
            return this.id;
        }

        public final String getNick() {
            return this.nick;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (((this.nick.hashCode() * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.id);
        }

        public String toString() {
            return "Peer(nick=" + this.nick + ", title=" + this.title + ", id=" + this.id + Separators.RPAREN;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int flags) {
            AbstractC13042fc3.i(dest, "dest");
            dest.writeString(this.nick);
            dest.writeString(this.title);
            dest.writeInt(this.id);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class a {
        public static final a a = new a("TERM_SEARCH", 0);
        public static final a b = new a("OPEN_PEER", 1);
        private static final /* synthetic */ a[] c;
        private static final /* synthetic */ F92 d;

        static {
            a[] aVarArrA = a();
            c = aVarArrA;
            d = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) c.clone();
        }
    }

    /* renamed from: ir.nasim.core.modules.market.model.SearchSuggestion$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final ArrayList a(String str) {
            AbstractC13042fc3.i(str, "json");
            try {
                Object objK = new KS2().k(str, SearchSuggestion[].class);
                AbstractC13042fc3.h(objK, "fromJson(...)");
                return new ArrayList(AbstractC10242bK.f1((Object[]) objK));
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
                return null;
            }
        }

        public final String b(ArrayList arrayList) {
            AbstractC13042fc3.i(arrayList, "arrayList");
            try {
                return new KS2().t(arrayList);
            } catch (Exception e) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e);
                return null;
            }
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class c implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SearchSuggestion createFromParcel(Parcel parcel) {
            AbstractC13042fc3.i(parcel, "parcel");
            return new SearchSuggestion(parcel.readInt() == 0 ? null : a.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Peer.CREATOR.createFromParcel(parcel) : null, L17.valueOf(parcel.readString()), EnumC8772Xg3.valueOf(parcel.readString()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SearchSuggestion[] newArray(int i) {
            return new SearchSuggestion[i];
        }
    }

    public SearchSuggestion(a aVar, String str, String str2, Peer peer, L17 l17, EnumC8772Xg3 enumC8772Xg3, String str3) {
        AbstractC13042fc3.i(l17, "suggestionType");
        AbstractC13042fc3.i(enumC8772Xg3, "defaultTab");
        this.action = aVar;
        this.term = str;
        this.drawable = str2;
        this.peer = peer;
        this.suggestionType = l17;
        this.defaultTab = enumC8772Xg3;
        this.displayName = str3;
    }

    public static /* synthetic */ SearchSuggestion copy$default(SearchSuggestion searchSuggestion, a aVar, String str, String str2, Peer peer, L17 l17, EnumC8772Xg3 enumC8772Xg3, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = searchSuggestion.action;
        }
        if ((i & 2) != 0) {
            str = searchSuggestion.term;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = searchSuggestion.drawable;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            peer = searchSuggestion.peer;
        }
        Peer peer2 = peer;
        if ((i & 16) != 0) {
            l17 = searchSuggestion.suggestionType;
        }
        L17 l172 = l17;
        if ((i & 32) != 0) {
            enumC8772Xg3 = searchSuggestion.defaultTab;
        }
        EnumC8772Xg3 enumC8772Xg32 = enumC8772Xg3;
        if ((i & 64) != 0) {
            str3 = searchSuggestion.displayName;
        }
        return searchSuggestion.copy(aVar, str4, str5, peer2, l172, enumC8772Xg32, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final a getAction() {
        return this.action;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTerm() {
        return this.term;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDrawable() {
        return this.drawable;
    }

    /* renamed from: component4, reason: from getter */
    public final Peer getPeer() {
        return this.peer;
    }

    /* renamed from: component5, reason: from getter */
    public final L17 getSuggestionType() {
        return this.suggestionType;
    }

    /* renamed from: component6, reason: from getter */
    public final EnumC8772Xg3 getDefaultTab() {
        return this.defaultTab;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    public final SearchSuggestion copy(a action, String term, String drawable, Peer peer, L17 suggestionType, EnumC8772Xg3 defaultTab, String displayName) {
        AbstractC13042fc3.i(suggestionType, "suggestionType");
        AbstractC13042fc3.i(defaultTab, "defaultTab");
        return new SearchSuggestion(action, term, drawable, peer, suggestionType, defaultTab, displayName);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchSuggestion)) {
            return false;
        }
        SearchSuggestion searchSuggestion = (SearchSuggestion) other;
        return this.action == searchSuggestion.action && AbstractC13042fc3.d(this.term, searchSuggestion.term) && AbstractC13042fc3.d(this.drawable, searchSuggestion.drawable) && AbstractC13042fc3.d(this.peer, searchSuggestion.peer) && this.suggestionType == searchSuggestion.suggestionType && this.defaultTab == searchSuggestion.defaultTab && AbstractC13042fc3.d(this.displayName, searchSuggestion.displayName);
    }

    public final a getAction() {
        return this.action;
    }

    public final EnumC8772Xg3 getDefaultTab() {
        return this.defaultTab;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getDrawable() {
        return this.drawable;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable getDrawableResources(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            ir.nasim.AbstractC13042fc3.i(r5, r0)
            java.lang.String r0 = r4.drawable
            r1 = 0
            if (r0 == 0) goto L4d
            int r2 = r0.hashCode()
            r3 = 3714(0xe82, float:5.204E-42)
            if (r2 == r3) goto L3d
            r3 = 96432(0x178b0, float:1.3513E-40)
            if (r2 == r3) goto L2d
            r3 = 50511102(0x302bcfe, float:3.842052E-37)
            if (r2 == r3) goto L1d
            goto L4d
        L1d:
            java.lang.String r2 = "category"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L26
            goto L4d
        L26:
            int r0 = ir.nasim.KB5.drawable_market_suggestion_category
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L4e
        L2d:
            java.lang.String r2 = "ads"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L36
            goto L4d
        L36:
            int r0 = ir.nasim.KB5.drawable_market_suggestion_ads
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L4e
        L3d:
            java.lang.String r2 = "tv"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L46
            goto L4d
        L46:
            int r0 = ir.nasim.KB5.drawable_market_suggestion_tv
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L4e
        L4d:
            r0 = r1
        L4e:
            if (r0 != 0) goto L51
            goto L59
        L51:
            int r0 = r0.intValue()
            android.graphics.drawable.Drawable r1 = ir.nasim.AbstractC4043Dl1.f(r5, r0)
        L59:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.core.modules.market.model.SearchSuggestion.getDrawableResources(android.content.Context):android.graphics.drawable.Drawable");
    }

    public final Peer getPeer() {
        return this.peer;
    }

    public final L17 getSuggestionType() {
        return this.suggestionType;
    }

    public final String getTerm() {
        return this.term;
    }

    public int hashCode() {
        a aVar = this.action;
        int iHashCode = (aVar == null ? 0 : aVar.hashCode()) * 31;
        String str = this.term;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.drawable;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Peer peer = this.peer;
        int iHashCode4 = (((((iHashCode3 + (peer == null ? 0 : peer.hashCode())) * 31) + this.suggestionType.hashCode()) * 31) + this.defaultTab.hashCode()) * 31;
        String str3 = this.displayName;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isWithDrawable() {
        return this.drawable != null;
    }

    public String toString() {
        return "SearchSuggestion(action=" + this.action + ", term=" + this.term + ", drawable=" + this.drawable + ", peer=" + this.peer + ", suggestionType=" + this.suggestionType + ", defaultTab=" + this.defaultTab + ", displayName=" + this.displayName + Separators.RPAREN;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        AbstractC13042fc3.i(dest, "dest");
        a aVar = this.action;
        if (aVar == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(aVar.name());
        }
        dest.writeString(this.term);
        dest.writeString(this.drawable);
        Peer peer = this.peer;
        if (peer == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            peer.writeToParcel(dest, flags);
        }
        dest.writeString(this.suggestionType.name());
        dest.writeString(this.defaultTab.name());
        dest.writeString(this.displayName);
    }

    public /* synthetic */ SearchSuggestion(a aVar, String str, String str2, Peer peer, L17 l17, EnumC8772Xg3 enumC8772Xg3, String str3, int i, ED1 ed1) {
        this(aVar, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : peer, (i & 16) != 0 ? L17.b : l17, (i & 32) != 0 ? EnumC8772Xg3.b : enumC8772Xg3, (i & 64) != 0 ? null : str3);
    }
}
