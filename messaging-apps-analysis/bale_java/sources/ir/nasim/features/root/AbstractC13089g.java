package ir.nasim.features.root;

import android.os.Bundle;
import ir.nasim.C11458d25;
import ir.nasim.C22042ua0;
import ir.nasim.C8386Vt0;
import ir.nasim.ED1;
import ir.nasim.EnumC14097hL4;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.HQ0;
import ir.nasim.InterfaceC23769xU5;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.database.entity.ContactEntity;
import ir.nasim.features.root.EmptyStateOnboardingItemAction;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 h2\u00020\u0001:\u0002ijB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0015\u0010\u000eJ\u0019\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\u0006H&¢\u0006\u0004\b#\u0010\u0003J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0006H&¢\u0006\u0004\b(\u0010\u0003J\u000f\u0010)\u001a\u00020\u0006H&¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0006H&¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0006H&¢\u0006\u0004\b+\u0010\u0003J9\u00103\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020\u00102\b\b\u0002\u00102\u001a\u000201H&¢\u0006\u0004\b3\u00104J\u0087\u0001\u0010A\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u00010-2\b\u00106\u001a\u0004\u0018\u00010-2\u0006\u00107\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u00010\u000b2\b\u00109\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010:\u001a\u00020\u00102\b\b\u0002\u0010;\u001a\u00020\u00102\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010>\u001a\u00020\u00102\b\b\u0002\u0010@\u001a\u00020?H&¢\u0006\u0004\bA\u0010BJQ\u0010C\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u00010-2\b\u00106\u001a\u0004\u0018\u00010-2\u0006\u00107\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u00010\u000b2\b\u00109\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010:\u001a\u00020\u0010H&¢\u0006\u0004\bC\u0010DJ'\u0010F\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u00105\u001a\u00020-2\u0006\u0010E\u001a\u00020\u000bH&¢\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u0004H&¢\u0006\u0004\bI\u0010\bJ\u0019\u0010K\u001a\u00020\u00062\b\u0010J\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\bK\u0010\u001dJ\u0019\u0010M\u001a\u00020\u00062\b\u0010L\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\bM\u0010\u000eJS\u0010U\u001a\u00020\u00062\b\u0010N\u001a\u0004\u0018\u00010\u000b2\b\u0010O\u001a\u0004\u0018\u00010\u000b2\u001a\u0010R\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010Pj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`Q2\b\u0010S\u001a\u0004\u0018\u00010\u000b2\b\u0010T\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u0006H&¢\u0006\u0004\bW\u0010\u0003J\u001f\u0010Z\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u0010H&¢\u0006\u0004\bZ\u0010\u0013R\u001c\u0010_\u001a\u00020\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001e\u0010c\u001a\u0004\u0018\u00010\u001a8&@&X¦\u000e¢\u0006\f\u001a\u0004\b`\u0010a\"\u0004\bb\u0010\u001dR\u0014\u0010g\u001a\u00020d8&X¦\u0004¢\u0006\u0006\u001a\u0004\be\u0010f¨\u0006k"}, d2 = {"Lir/nasim/features/root/g;", "Lir/nasim/ua0;", "<init>", "()V", "", "messageRes", "Lir/nasim/rB7;", "sa", "(I)V", "index", "ia", "", "query", "ha", "(Ljava/lang/String;)V", "tabName", "", "openStory", "ja", "(Ljava/lang/String;Z)V", "storyId", "da", "Landroid/os/Bundle;", "bundle", "V9", "(Landroid/os/Bundle;)V", "Lir/nasim/d25;", "peer", "na", "(Lir/nasim/d25;)V", "Lir/nasim/xU5;", "listener", "ua", "(Lir/nasim/xU5;)V", "ta", "O9", "Lir/nasim/hL4;", "openedPFMFrom", "ea", "(Lir/nasim/hL4;)V", "ga", "fa", "U9", "ra", "discussionGroupId", "", "topId", "topDate", "shouldLoadComment", "Lir/nasim/HQ0;", "spot", "W9", "(IJJZLir/nasim/HQ0;)V", DialogEntity.COLUMN_RID, ContactEntity.COLUMN_SORT_KEY, "shouldLoadMessage", DialogEntity.COLUMN_MESSAGE, "jaryanTabType", "isAllowingStateLossEnabled", "openComment", "intendedPeer", "joinViaLink", "isFromDialogAd", "Lir/nasim/features/root/EmptyStateOnboardingItemAction;", "emptyStateOnboardingItemAction", "Z9", "(Lir/nasim/d25;Ljava/lang/Long;Ljava/lang/Long;ZLjava/lang/String;Ljava/lang/String;ZZLir/nasim/d25;Ljava/lang/Boolean;ZLir/nasim/features/root/EmptyStateOnboardingItemAction;)V", "Y9", "(Lir/nasim/d25;Ljava/lang/Long;Ljava/lang/Long;ZLjava/lang/String;Ljava/lang/String;Z)V", "param", "T9", "(Lir/nasim/d25;JLjava/lang/String;)V", "tabIndex", "ma", "pendingPeer", "pa", "pendingMessage", "oa", "sendText", "sendUriString", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sendUriMultiple", "sendMimeType", "peerIdDirectShare", "la", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "P9", "token", "isOpenOutSideOfBale", "ca", "S9", "()Z", "qa", "(Z)V", "isSharingDialogSelected", "Q9", "()Lir/nasim/d25;", "ka", "currentPeer", "Lir/nasim/features/root/g$b;", "R9", "()Lir/nasim/features/root/g$b;", "dialogsMode", "c1", "b", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.features.root.g, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC13089g extends C22042ua0 {

    /* renamed from: c1, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final int d1;
    public static final int e1;

    /* renamed from: ir.nasim.features.root.g$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i) {
            return i;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.features.root.g$b */
    public static final class b {
        public static final b a = new b("DIALOGS", 0);
        public static final b b = new b("FORWARD", 1);
        public static final b c = new b("SHARE", 2);
        private static final /* synthetic */ b[] d;
        private static final /* synthetic */ F92 e;

        static {
            b[] bVarArrA = a();
            d = bVarArrA;
            e = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b, c};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) d.clone();
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        d1 = companion.b(1);
        e1 = companion.b(C8386Vt0.a.h4() ? 3 : 2);
    }

    public static /* synthetic */ void X9(AbstractC13089g abstractC13089g, int i, long j, long j2, boolean z, HQ0 hq0, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openComment");
        }
        abstractC13089g.W9(i, j, j2, z, (i2 & 16) != 0 ? HQ0.b : hq0);
    }

    public static /* synthetic */ void aa(AbstractC13089g abstractC13089g, C11458d25 c11458d25, Long l, Long l2, boolean z, String str, String str2, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openDialog");
        }
        abstractC13089g.Y9(c11458d25, l, l2, z, str, str2, (i & 64) != 0 ? false : z2);
    }

    public static /* synthetic */ void ba(AbstractC13089g abstractC13089g, C11458d25 c11458d25, Long l, Long l2, boolean z, String str, String str2, boolean z2, boolean z3, C11458d25 c11458d252, Boolean bool, boolean z4, EmptyStateOnboardingItemAction emptyStateOnboardingItemAction, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openDialog");
        }
        abstractC13089g.Z9(c11458d25, l, l2, z, str, str2, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? false : z3, (i & 256) != 0 ? null : c11458d252, (i & 512) != 0 ? null : bool, (i & 1024) != 0 ? false : z4, (i & 2048) != 0 ? EmptyStateOnboardingItemAction.NotOpened.e : emptyStateOnboardingItemAction);
    }

    public abstract void O9();

    public abstract void P9();

    public abstract C11458d25 Q9();

    public abstract b R9();

    public abstract boolean S9();

    public abstract void T9(C11458d25 peer, long rid, String param);

    public abstract void U9();

    public abstract void V9(Bundle bundle);

    public abstract void W9(int discussionGroupId, long topId, long topDate, boolean shouldLoadComment, HQ0 spot);

    public abstract void Y9(C11458d25 peer, Long rid, Long sortKey, boolean shouldLoadMessage, String message, String jaryanTabType, boolean isAllowingStateLossEnabled);

    public abstract void Z9(C11458d25 peer, Long rid, Long sortKey, boolean shouldLoadMessage, String message, String jaryanTabType, boolean isAllowingStateLossEnabled, boolean openComment, C11458d25 intendedPeer, Boolean joinViaLink, boolean isFromDialogAd, EmptyStateOnboardingItemAction emptyStateOnboardingItemAction);

    public abstract void ca(String token, boolean isOpenOutSideOfBale);

    public abstract void da(String storyId);

    public abstract void ea(EnumC14097hL4 openedPFMFrom);

    public abstract void fa();

    public abstract void ga();

    public abstract void ha(String query);

    public abstract void ia(int index);

    public abstract void ja(String tabName, boolean openStory);

    public abstract void ka(C11458d25 c11458d25);

    public abstract void la(String sendText, String sendUriString, ArrayList sendUriMultiple, String sendMimeType, String peerIdDirectShare);

    public abstract void ma(int tabIndex);

    public abstract void na(C11458d25 peer);

    public abstract void oa(String pendingMessage);

    public abstract void pa(C11458d25 pendingPeer);

    public abstract void qa(boolean z);

    public abstract void ra();

    public abstract void sa(int messageRes);

    public abstract void ta(InterfaceC23769xU5 listener);

    public abstract void ua(InterfaceC23769xU5 listener);
}
