package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.material.button.MaterialButton;
import ir.nasim.AbstractC15520jj2;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C14330hk2;
import ir.nasim.C21051t17;
import ir.nasim.C6622Oh2;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.jaryan.search.ui.fragment.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000«\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000e\b\u0007\u0018\u0000 Ç\u00012\u00020\u0001:\u0001hB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001bH\u0002¢\u0006\u0004\b$\u0010\u001fJ\u000f\u0010%\u001a\u00020\nH\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u001bH\u0002¢\u0006\u0004\b&\u0010\u001fJ\u000f\u0010'\u001a\u00020\u001bH\u0002¢\u0006\u0004\b'\u0010\u001fJ\u000f\u0010(\u001a\u00020\u001bH\u0002¢\u0006\u0004\b(\u0010\u001fJ\u000f\u0010)\u001a\u00020\u001bH\u0002¢\u0006\u0004\b)\u0010\u001fJ\u0017\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J\u001d\u00104\u001a\u0004\u0018\u000103*\u00020\u00042\u0006\u00102\u001a\u00020\u0013H\u0002¢\u0006\u0004\b4\u00105J)\u00109\u001a\u00020\n2\u0018\u00108\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\n06H\u0002¢\u0006\u0004\b9\u0010:J)\u0010;\u001a\u00020\n2\u0018\u00108\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\n06H\u0002¢\u0006\u0004\b;\u0010:J\u000f\u0010<\u001a\u00020\nH\u0002¢\u0006\u0004\b<\u0010\u0003J\u000f\u0010=\u001a\u00020\nH\u0002¢\u0006\u0004\b=\u0010\u0003J5\u0010F\u001a\u00020\n2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020?0>2\u0006\u0010A\u001a\u00020?2\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bF\u0010GJa\u0010O\u001a\u00020\n2\u0006\u0010A\u001a\u00020?2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020H0>2\u0006\u0010E\u001a\u00020D2\u0006\u0010C\u001a\u00020B2\b\u0010K\u001a\u0004\u0018\u00010J2\u0006\u0010/\u001a\u00020H2\u0018\u0010N\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0>\u0012\u0004\u0012\u00020\n0LH\u0002¢\u0006\u0004\bO\u0010PJ+\u0010X\u001a\u00020W2\u0006\u0010R\u001a\u00020Q2\b\u0010T\u001a\u0004\u0018\u00010S2\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\bX\u0010YJ!\u0010[\u001a\u00020\n2\u0006\u0010Z\u001a\u00020W2\b\u0010V\u001a\u0004\u0018\u00010UH\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\nH\u0016¢\u0006\u0004\b]\u0010\u0003J3\u0010`\u001a\u00020\n2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020H0>2\u0006\u0010^\u001a\u0002072\u0006\u0010_\u001a\u00020?2\u0006\u0010C\u001a\u00020B¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\nH\u0016¢\u0006\u0004\bb\u0010\u0003J\u000f\u0010c\u001a\u00020\nH\u0016¢\u0006\u0004\bc\u0010\u0003J%\u0010e\u001a\u00020\n2\u0016\b\u0002\u0010d\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\n\u0018\u00010L¢\u0006\u0004\be\u0010fJ\u000f\u0010g\u001a\u00020\nH\u0016¢\u0006\u0004\bg\u0010\u0003J\u000f\u0010h\u001a\u00020*H\u0016¢\u0006\u0004\bh\u0010iR\"\u0010q\u001a\u00020j8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010y\u001a\u00020r8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR$\u0010\u0081\u0001\u001a\u00020z8\u0006@\u0006X\u0087.¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R!\u0010\u0087\u0001\u001a\u00030\u0082\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R!\u0010\u008d\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R!\u0010\u0092\u0001\u001a\u00030\u008e\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u008a\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R!\u0010\u009a\u0001\u001a\u00030\u0096\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u008a\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001c\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010¢\u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0019\u0010¥\u0001\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R!\u0010ª\u0001\u001a\u00030¦\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b§\u0001\u0010\u008a\u0001\u001a\u0006\b¨\u0001\u0010©\u0001R\u001c\u0010®\u0001\u001a\u0005\u0018\u00010«\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u0019\u0010±\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u0018\u0010µ\u0001\u001a\u00030²\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u0017\u0010·\u0001\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010°\u0001R\u0017\u0010º\u0001\u001a\u00020\u00068\u0002X\u0082D¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0019\u0010¼\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¹\u0001R\u001c\u0010À\u0001\u001a\u0005\u0018\u00010½\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0019\u0010Â\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010°\u0001R\u001c\u0010Æ\u0001\u001a\u0005\u0018\u00010Ã\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001¨\u0006È\u0001"}, d2 = {"Lir/nasim/Oh2;", "Lir/nasim/ua0;", "<init>", "()V", "Landroidx/viewpager2/widget/ViewPager2;", "pager", "", "offset", "", "duration", "Lir/nasim/rB7;", "Aa", "(Landroidx/viewpager2/widget/ViewPager2;FJ)V", "db", "ir/nasim/Oh2$y", "rb", "()Lir/nasim/Oh2$y;", "Lir/nasim/zh2;", "adapter", "", "newPage", "gb", "(Lir/nasim/zh2;I)V", "Ua", "(I)V", "newPagePos", "Va", "Lir/nasim/gj3;", "Ya", "(Lir/nasim/zh2;)Lir/nasim/gj3;", "cb", "()Lir/nasim/gj3;", "Lir/nasim/hk2$b;", "state", "sb", "(Lir/nasim/hk2$b;)V", "ab", "bb", "Za", "eb", "fb", "Xa", "", "isVisible", "pb", "(Z)V", "", DialogEntity.COLUMN_MESSAGE, "ub", "(Ljava/lang/String;)V", "position", "Landroidx/recyclerview/widget/RecyclerView$C;", "Oa", "(Landroidx/viewpager2/widget/ViewPager2;I)Landroidx/recyclerview/widget/RecyclerView$C;", "Lkotlin/Function2;", "Lir/nasim/OP5;", "onResult", "tb", "(Lir/nasim/iB2;)V", "hb", "Wa", "lb", "", "Lir/nasim/d25;", "peers", "forwardedPeer", "Lir/nasim/Lg2;", "feed", "Lir/nasim/XH6;", "sourceType", "ob", "(Ljava/util/List;Lir/nasim/d25;Lir/nasim/Lg2;Lir/nasim/XH6;)V", "Lir/nasim/J44;", "messages", "Lir/nasim/Gj2;", "feedUI", "Lkotlin/Function1;", "Lir/nasim/Tw2;", "onSuccess", "Da", "(Lir/nasim/d25;Ljava/util/List;Lir/nasim/XH6;Lir/nasim/Lg2;Lir/nasim/Gj2;Lir/nasim/J44;Lir/nasim/UA2;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "i9", "type", "peer", "jb", "(Ljava/util/List;Lir/nasim/OP5;Lir/nasim/d25;Lir/nasim/Lg2;)V", "a1", "S0", "onReportTypeSelected", "mb", "(Lir/nasim/UA2;)V", "T6", "a", "()Z", "Lir/nasim/zP5;", "h1", "Lir/nasim/zP5;", "Pa", "()Lir/nasim/zP5;", "setReportNavigator", "(Lir/nasim/zP5;)V", "reportNavigator", "Lir/nasim/Ow2;", "i1", "Lir/nasim/Ow2;", "Ma", "()Lir/nasim/Ow2;", "setForwardNavigator", "(Lir/nasim/Ow2;)V", "forwardNavigator", "Lir/nasim/ju1;", "j1", "Lir/nasim/ju1;", "La", "()Lir/nasim/ju1;", "setCreatePostLinkUseCase", "(Lir/nasim/ju1;)V", "createPostLinkUseCase", "Lir/nasim/hy2;", "k1", "Lir/nasim/bW7;", "Ka", "()Lir/nasim/hy2;", "binding", "Lir/nasim/Ai2;", "l1", "Lir/nasim/Yu3;", "Ra", "()Lir/nasim/Ai2;", "viewModel", "Lir/nasim/sX7;", "m1", "Sa", "()Lir/nasim/sX7;", "viewPagerViewTracker", "n1", "Lir/nasim/zh2;", "viewPagerAdapter", "Lir/nasim/n10;", "o1", "Qa", "()Lir/nasim/n10;", "snackBar", "Lir/nasim/vi2;", "p1", "Lir/nasim/vi2;", "currentVideoHolder", "Lcom/google/android/exoplayer2/a0;", "q1", "Lcom/google/android/exoplayer2/a0;", "originalMediaItem", "r1", "Z", "isScrolledToMoreContentOnce", "Lir/nasim/VI2;", "s1", "Na", "()Lir/nasim/VI2;", "glideRequests", "Lir/nasim/K37;", "t1", "Lir/nasim/K37;", "swipeGestureListener", "u1", TokenNames.I, "animFactor", "Landroid/animation/ValueAnimator;", "v1", "Landroid/animation/ValueAnimator;", "animator", "w1", "maxTextBoxHeightDp", "x1", TokenNames.F, "minTextBoxHeightDp", "y1", "previousHeightPx", "Landroidx/viewpager2/widget/ViewPager2$i;", "z1", "Landroidx/viewpager2/widget/ViewPager2$i;", "viewPagerListener", "A1", "currentPage", "Lir/nasim/fj2;", "B1", "Lir/nasim/fj2;", "feedListener", "C1", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Oh2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C6622Oh2 extends GW2 {

    /* renamed from: A1, reason: from kotlin metadata */
    private int currentPage;

    /* renamed from: B1, reason: from kotlin metadata */
    private InterfaceC13138fj2 feedListener;

    /* renamed from: h1, reason: from kotlin metadata */
    public InterfaceC24908zP5 reportNavigator;

    /* renamed from: i1, reason: from kotlin metadata */
    public InterfaceC6762Ow2 forwardNavigator;

    /* renamed from: j1, reason: from kotlin metadata */
    public C15629ju1 createPostLinkUseCase;

    /* renamed from: k1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new z(), AbstractC20046rN7.c());

    /* renamed from: l1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: m1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewPagerViewTracker;

    /* renamed from: n1, reason: from kotlin metadata */
    private C25074zh2 viewPagerAdapter;

    /* renamed from: o1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 snackBar;

    /* renamed from: p1, reason: from kotlin metadata */
    private C22714vi2 currentVideoHolder;

    /* renamed from: q1, reason: from kotlin metadata */
    private C2018a0 originalMediaItem;

    /* renamed from: r1, reason: from kotlin metadata */
    private boolean isScrolledToMoreContentOnce;

    /* renamed from: s1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 glideRequests;

    /* renamed from: t1, reason: from kotlin metadata */
    private K37 swipeGestureListener;

    /* renamed from: u1, reason: from kotlin metadata */
    private int animFactor;

    /* renamed from: v1, reason: from kotlin metadata */
    private final ValueAnimator animator;

    /* renamed from: w1, reason: from kotlin metadata */
    private final int maxTextBoxHeightDp;

    /* renamed from: x1, reason: from kotlin metadata */
    private final float minTextBoxHeightDp;

    /* renamed from: y1, reason: from kotlin metadata */
    private float previousHeightPx;

    /* renamed from: z1, reason: from kotlin metadata */
    private ViewPager2.i viewPagerListener;
    static final /* synthetic */ InterfaceC5239Im3[] D1 = {AbstractC10882cM5.i(new C25226zw5(C6622Oh2.class, "binding", "getBinding()Lir/nasim/jaryan/databinding/FragmentFullScreenFeedBinding;", 0))};

    /* renamed from: C1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int E1 = 8;

    /* renamed from: ir.nasim.Oh2$A */
    public static final class A extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public A(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Oh2$B */
    public static final class B extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public B(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Oh2$C */
    public static final class C extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.Oh2$D */
    public static final class D extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public D(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.Oh2$E */
    public static final class E extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public E(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    /* renamed from: ir.nasim.Oh2$a, reason: case insensitive filesystem and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ C6622Oh2 b(Companion companion, C8755Xe4 c8755Xe4, int i, boolean z, Integer num, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                z = false;
            }
            if ((i2 & 8) != 0) {
                num = -1;
            }
            return companion.a(c8755Xe4, i, z, num);
        }

        public final C6622Oh2 a(C8755Xe4 c8755Xe4, int i, boolean z, Integer num) {
            AbstractC13042fc3.i(c8755Xe4, "itemMid");
            C6622Oh2 c6622Oh2 = new C6622Oh2();
            c6622Oh2.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("FULL_SCREEN_FEED_MID", c8755Xe4), AbstractC4616Fw7.a("CATEGORY_ID", Integer.valueOf(i)), AbstractC4616Fw7.a("SHOW_MORE_CONTENT", Boolean.valueOf(z)), AbstractC4616Fw7.a("PLAYER_ID", num)));
            return c6622Oh2;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Oh2$b, reason: case insensitive filesystem */
    public static final class C6624b extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPager2 b;

        C6624b(ViewPager2 viewPager2) {
            this.b = viewPager2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(C6622Oh2 c6622Oh2) {
            AbstractC13042fc3.i(c6622Oh2, "this$0");
            LinearLayout linearLayout = c6622Oh2.Ka().e;
            AbstractC13042fc3.h(linearLayout, "similarPostTeaching");
            linearLayout.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(C6622Oh2 c6622Oh2) {
            AbstractC13042fc3.i(c6622Oh2, "this$0");
            LinearLayout linearLayout = c6622Oh2.Ka().e;
            AbstractC13042fc3.h(linearLayout, "similarPostTeaching");
            linearLayout.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            super.onAnimationCancel(animator);
            C6622Oh2.this.animator.removeListener(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            if (this.b.g()) {
                this.b.c();
            }
            if (C6622Oh2.this.o6() == null || !C6622Oh2.this.u6()) {
                return;
            }
            ViewPropertyAnimator duration = C6622Oh2.this.Ka().e.animate().alpha(0.0f).setDuration(50L);
            final C6622Oh2 c6622Oh2 = C6622Oh2.this;
            duration.withEndAction(new Runnable() { // from class: ir.nasim.Qh2
                @Override // java.lang.Runnable
                public final void run() {
                    C6622Oh2.C6624b.c(c6622Oh2);
                }
            });
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            C6622Oh2.this.animFactor = -1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            if (C6622Oh2.this.o6() == null || !C6622Oh2.this.u6()) {
                return;
            }
            C6622Oh2.this.animFactor = 1;
            ViewPropertyAnimator startDelay = C6622Oh2.this.Ka().e.animate().alpha(1.0f).setDuration(50L).setStartDelay(200L);
            final C6622Oh2 c6622Oh2 = C6622Oh2.this;
            startDelay.withStartAction(new Runnable() { // from class: ir.nasim.Ph2
                @Override // java.lang.Runnable
                public final void run() {
                    C6622Oh2.C6624b.d(c6622Oh2);
                }
            });
        }
    }

    /* renamed from: ir.nasim.Oh2$d, reason: case insensitive filesystem */
    /* synthetic */ class C6626d extends EB2 implements InterfaceC16978mB2 {
        C6626d(Object obj) {
            super(4, obj, C3310Ai2.class, "sendPostDurationEventVideo", "sendPostDurationEventVideo(IIILir/nasim/jaryan/feed/model/network/Feed;)V", 0);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            y(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), (C5886Lg2) obj4);
            return C19938rB7.a;
        }

        public final void y(int i, int i2, int i3, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c5886Lg2, "p3");
            ((C3310Ai2) this.receiver).P1(i, i2, i3, c5886Lg2);
        }
    }

    /* renamed from: ir.nasim.Oh2$e, reason: case insensitive filesystem */
    /* synthetic */ class C6627e extends EB2 implements InterfaceC14603iB2 {
        C6627e(Object obj) {
            super(2, obj, C3310Ai2.class, "sendPostDurationEventSimple", "sendPostDurationEventSimple(ILir/nasim/jaryan/feed/model/network/Feed;)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y(((Number) obj).intValue(), (C5886Lg2) obj2);
            return C19938rB7.a;
        }

        public final void y(int i, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c5886Lg2, "p1");
            ((C3310Ai2) this.receiver).O1(i, c5886Lg2);
        }
    }

    /* renamed from: ir.nasim.Oh2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = C6622Oh2.this.new f(interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro12 = (InterfaceC20315ro1) this.c;
                this.c = interfaceC20315ro12;
                this.b = 1;
                if (HG1.b(3000L, this) == objE) {
                    return objE;
                }
                interfaceC20315ro1 = interfaceC20315ro12;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
            }
            AbstractC20906so1.f(interfaceC20315ro1);
            C6622Oh2.this.Ra().E1();
            C6622Oh2.this.Ra().D1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Oh2$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Oh2$g$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6622Oh2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C6622Oh2 c6622Oh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6622Oh2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                LA2 la2 = (LA2) this.c;
                C19406qI3.a("FeedFullScreenFragment", "observeFakeDragAnimationVisibility: " + la2.c(), new Object[0]);
                if (la2.c()) {
                    C6622Oh2 c6622Oh2 = this.d;
                    ViewPager2 viewPager2 = c6622Oh2.Ka().c;
                    AbstractC13042fc3.h(viewPager2, "feedFullScreenViewPager");
                    c6622Oh2.Aa(viewPager2, -6.0f, 1000L);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(LA2 la2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(la2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6622Oh2.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C8386Vt0 c8386Vt0 = C8386Vt0.a;
                if (c8386Vt0.Ka() && c8386Vt0.I7()) {
                    InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(C6622Oh2.this.Ra().t1(), new C25226zw5() { // from class: ir.nasim.Oh2.g.a
                        @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                        public Object get(Object obj2) {
                            return Boolean.valueOf(((LA2) obj2).c());
                        }
                    });
                    b bVar = new b(C6622Oh2.this, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2X, bVar, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Oh2$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C25074zh2 d;

        /* renamed from: ir.nasim.Oh2$h$b */
        static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            final /* synthetic */ C6622Oh2 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C6622Oh2 c6622Oh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
                this.c = c6622Oh2;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ViewPager2.i iVar = this.c.viewPagerListener;
                if (iVar != null) {
                    this.c.Ka().c.r(iVar);
                }
                this.c.viewPagerListener = null;
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Oh2$h$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6622Oh2 d;
            final /* synthetic */ C25074zh2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(C6622Oh2 c6622Oh2, C25074zh2 c25074zh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6622Oh2;
                this.e = c25074zh2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(this.d, this.e, interfaceC20295rm1);
                cVar.c = obj;
                return cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.gb(this.e, ((LA2) this.c).a());
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(LA2 la2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(la2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Oh2$h$d */
        public static final class d implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.Oh2$h$d$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.Oh2$h$d$a$a, reason: collision with other inner class name */
                public static final class C0557a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0557a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof ir.nasim.C6622Oh2.h.d.a.C0557a
                        if (r0 == 0) goto L13
                        r0 = r7
                        ir.nasim.Oh2$h$d$a$a r0 = (ir.nasim.C6622Oh2.h.d.a.C0557a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.Oh2$h$d$a$a r0 = new ir.nasim.Oh2$h$d$a$a
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r7)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L31:
                        ir.nasim.AbstractC10685c16.b(r7)
                        ir.nasim.Gq2 r7 = r5.a
                        r2 = r6
                        ir.nasim.LA2 r2 = (ir.nasim.LA2) r2
                        int r2 = r2.a()
                        r4 = -1
                        if (r2 == r4) goto L49
                        r0.b = r3
                        java.lang.Object r6 = r7.a(r6, r0)
                        if (r6 != r1) goto L49
                        return r1
                    L49:
                        ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6622Oh2.h.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C25074zh2 c25074zh2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c25074zh2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6622Oh2.this.new h(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                d dVar = new d(AbstractC6459Nq2.a0(AbstractC6459Nq2.x(C6622Oh2.this.Ra().t1(), new C25226zw5() { // from class: ir.nasim.Oh2.h.a
                    @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                    public Object get(Object obj2) {
                        return Integer.valueOf(((LA2) obj2).a());
                    }
                }), new b(C6622Oh2.this, null)));
                c cVar = new c(C6622Oh2.this, this.d, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(dVar, cVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Oh2$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Oh2$i$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6622Oh2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C6622Oh2 c6622Oh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6622Oh2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    LA2 la2 = (LA2) this.c;
                    C25074zh2 c25074zh2 = this.d.viewPagerAdapter;
                    if (c25074zh2 != null) {
                        NT4 nt4B = la2.b();
                        this.b = 1;
                        if (c25074zh2.L(nt4B, this) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(LA2 la2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(la2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6622Oh2.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(C6622Oh2.this.Ra().t1(), new C25226zw5() { // from class: ir.nasim.Oh2.i.a
                    @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                    public Object get(Object obj2) {
                        return ((LA2) obj2).b();
                    }
                });
                b bVar = new b(C6622Oh2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2X, bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Oh2$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Oh2$j$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6622Oh2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C6622Oh2 c6622Oh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6622Oh2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C11863dg5 c11863dg5 = (C11863dg5) this.c;
                C6622Oh2 c6622Oh2 = this.d;
                int iC = c11863dg5.c();
                C22714vi2 c22714vi2 = this.d.currentVideoHolder;
                if (iC == 1) {
                    Log.w("FeedFullScreenFragment", "handlePlaybackStateChangeForVideoHolder: error while rendering");
                } else if (iC != 2) {
                    if (iC == 3) {
                        c6622Oh2.Ra().o1().D(c6622Oh2.D6() && c6622Oh2.getBaleResumed() && c6622Oh2.B6());
                        if (c22714vi2 != null) {
                            c22714vi2.l4(c6622Oh2.Ra().o1());
                        }
                        if (c22714vi2 != null) {
                            c22714vi2.g4(c6622Oh2.D6() && c6622Oh2.getBaleResumed() && c6622Oh2.B6());
                        }
                    } else if (iC == 4) {
                        if (c22714vi2 != null) {
                            c22714vi2.d4();
                        }
                        c6622Oh2.Ra().o1().x(0L);
                    }
                } else if (c22714vi2 != null) {
                    c22714vi2.c4();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C11863dg5 c11863dg5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(c11863dg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6622Oh2.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(C6622Oh2.this.Ra().s1(), new C25226zw5() { // from class: ir.nasim.Oh2.j.a
                    @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                    public Object get(Object obj2) {
                        return Integer.valueOf(((C11863dg5) obj2).c());
                    }
                });
                b bVar = new b(C6622Oh2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2X, bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Oh2$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Oh2$k$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6622Oh2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C6622Oh2 c6622Oh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6622Oh2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC6392Nk0.a(((double) (((float) ((C11863dg5) this.c).d()) / ((float) this.d.Ra().o1().f()))) > 0.9d);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C11863dg5 c11863dg5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(c11863dg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6622Oh2.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(C6622Oh2.this.Ra().s1(), new C25226zw5() { // from class: ir.nasim.Oh2.k.a
                    @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                    public Object get(Object obj2) {
                        return Long.valueOf(((C11863dg5) obj2).d());
                    }
                });
                b bVar = new b(C6622Oh2.this, null);
                this.b = 1;
                obj = AbstractC6459Nq2.H(interfaceC4557Fq2X, bVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C6622Oh2.this.Ra().E1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Oh2$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Oh2$l$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C6622Oh2 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C6622Oh2 c6622Oh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c6622Oh2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return AbstractC6392Nk0.a(((double) (((float) this.c.Ra().o1().D0()) / ((float) this.c.Ra().o1().f()))) > 0.97d);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C11863dg5 c11863dg5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(c11863dg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6622Oh2.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(C6622Oh2.this.Ra().s1(), new C25226zw5() { // from class: ir.nasim.Oh2.l.a
                    @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                    public Object get(Object obj2) {
                        return Long.valueOf(((C11863dg5) obj2).d());
                    }
                });
                b bVar = new b(C6622Oh2.this, null);
                this.b = 1;
                obj = AbstractC6459Nq2.H(interfaceC4557Fq2X, bVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C6622Oh2.this.Ra().D1();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Oh2$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Oh2$m$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6622Oh2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C6622Oh2 c6622Oh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6622Oh2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.sb(((C11863dg5) this.c).f() > 0.0f ? C14330hk2.EnumC14332b.b : C14330hk2.EnumC14332b.a);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C11863dg5 c11863dg5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(c11863dg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6622Oh2.this.new m(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(C6622Oh2.this.Ra().s1(), new C25226zw5() { // from class: ir.nasim.Oh2.m.a
                    @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                    public Object get(Object obj2) {
                        return Float.valueOf(((C11863dg5) obj2).f());
                    }
                });
                b bVar = new b(C6622Oh2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2X, bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Oh2$n */
    static final class n implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ValueAnimator a;
        final /* synthetic */ ViewPager2 b;

        n(ValueAnimator valueAnimator, ViewPager2 viewPager2) {
            this.a = valueAnimator;
            this.b = viewPager2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AbstractC13042fc3.i(valueAnimator, "it");
            this.a.setDuration(300L);
            Object animatedValue = valueAnimator.getAnimatedValue();
            AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float fFloatValue = ((Float) animatedValue).floatValue();
            if (!this.b.g()) {
                this.b.b();
            }
            this.b.e(fFloatValue);
        }
    }

    /* renamed from: ir.nasim.Oh2$o */
    public static final class o implements View.OnLayoutChangeListener {
        final /* synthetic */ ViewPager2 a;
        final /* synthetic */ C6622Oh2 b;

        public o(ViewPager2 viewPager2, C6622Oh2 c6622Oh2) {
            this.a = viewPager2;
            this.b = c6622Oh2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            if (this.a.getCurrentItem() == 0) {
                Bundle bundleE5 = this.b.E5();
                if (bundleE5 != null && !bundleE5.getBoolean("SHOW_MORE_CONTENT", false)) {
                    this.b.Ra().E1();
                }
                if (this.b.isScrolledToMoreContentOnce) {
                    return;
                }
                AbstractC13042fc3.f(this.a);
                ViewPager2 viewPager2 = this.a;
                if (!viewPager2.isLaidOut() || viewPager2.isLayoutRequested()) {
                    viewPager2.addOnLayoutChangeListener(new p(this.a, this.b));
                    return;
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, -15.0f);
                valueAnimatorOfFloat.addUpdateListener(new n(valueAnimatorOfFloat, this.a));
                AbstractC13042fc3.f(valueAnimatorOfFloat);
                valueAnimatorOfFloat.addListener(new q(this.a, this.b));
                valueAnimatorOfFloat.start();
            }
        }
    }

    /* renamed from: ir.nasim.Oh2$p */
    public static final class p implements View.OnLayoutChangeListener {
        final /* synthetic */ ViewPager2 a;
        final /* synthetic */ C6622Oh2 b;

        public p(ViewPager2 viewPager2, C6622Oh2 c6622Oh2) {
            this.a = viewPager2;
            this.b = c6622Oh2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, -15.0f);
            valueAnimatorOfFloat.addUpdateListener(new n(valueAnimatorOfFloat, this.a));
            AbstractC13042fc3.f(valueAnimatorOfFloat);
            valueAnimatorOfFloat.addListener(new q(this.a, this.b));
            valueAnimatorOfFloat.start();
        }
    }

    /* renamed from: ir.nasim.Oh2$r */
    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Oh2$r$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6622Oh2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C6622Oh2 c6622Oh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6622Oh2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                LA2 la2 = (LA2) this.c;
                C6622Oh2 c6622Oh2 = this.d;
                Integer numD = la2.d();
                AbstractC13042fc3.f(numD);
                String strH6 = c6622Oh2.h6(numD.intValue());
                AbstractC13042fc3.h(strH6, "getString(...)");
                c6622Oh2.ub(strH6);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(LA2 la2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(la2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Oh2$r$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.Oh2$r$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.Oh2$r$b$a$a, reason: collision with other inner class name */
                public static final class C0558a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C0558a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                    this.a = interfaceC4806Gq2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.C6622Oh2.r.b.a.C0558a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.Oh2$r$b$a$a r0 = (ir.nasim.C6622Oh2.r.b.a.C0558a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.Oh2$r$b$a$a r0 = new ir.nasim.Oh2$r$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L48
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        r2 = r5
                        ir.nasim.LA2 r2 = (ir.nasim.LA2) r2
                        java.lang.Integer r2 = r2.d()
                        if (r2 == 0) goto L48
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L48
                        return r1
                    L48:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6622Oh2.r.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Integer y(LA2 la2) {
            return la2.d();
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6622Oh2.this.new r(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(AbstractC6459Nq2.x(C6622Oh2.this.Ra().t1(), new UA2() { // from class: ir.nasim.Uh2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return C6622Oh2.r.y((LA2) obj2);
                    }
                }));
                a aVar = new a(C6622Oh2.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(bVar, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Oh2$s */
    static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Oh2$s$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6622Oh2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C6622Oh2 c6622Oh2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6622Oh2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                LA2 la2 = (LA2) this.c;
                C19406qI3.b("FeedFullScreenFragment", "observeSwipeAnimationVisibility: " + la2.e());
                this.d.pb(la2.e() && C8386Vt0.a.Ia());
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(LA2 la2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(la2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(C6622Oh2 c6622Oh2, View view) {
            c6622Oh2.Ra().F1();
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6622Oh2.this.new s(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C8386Vt0 c8386Vt0 = C8386Vt0.a;
                if (c8386Vt0.Ia() && c8386Vt0.I7()) {
                    C6622Oh2.this.Ka().d.getRoot().setOnTouchListener(C6622Oh2.this.swipeGestureListener);
                    MaterialButton materialButton = C6622Oh2.this.Ka().d.b;
                    final C6622Oh2 c6622Oh2 = C6622Oh2.this;
                    materialButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Vh2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C6622Oh2.s.y(c6622Oh2, view);
                        }
                    });
                    InterfaceC4557Fq2 interfaceC4557Fq2X = AbstractC6459Nq2.x(C6622Oh2.this.Ra().t1(), new C25226zw5() { // from class: ir.nasim.Oh2.s.a
                        @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
                        public Object get(Object obj2) {
                            return Boolean.valueOf(((LA2) obj2).e());
                        }
                    });
                    b bVar = new b(C6622Oh2.this, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2X, bVar, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Oh2$t */
    /* synthetic */ class t extends EB2 implements InterfaceC16978mB2 {
        t(Object obj) {
            super(4, obj, C3310Ai2.class, "sendPostDurationEventVideo", "sendPostDurationEventVideo(IIILir/nasim/jaryan/feed/model/network/Feed;)V", 0);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            y(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Number) obj3).intValue(), (C5886Lg2) obj4);
            return C19938rB7.a;
        }

        public final void y(int i, int i2, int i3, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c5886Lg2, "p3");
            ((C3310Ai2) this.receiver).P1(i, i2, i3, c5886Lg2);
        }
    }

    /* renamed from: ir.nasim.Oh2$u */
    /* synthetic */ class u extends EB2 implements InterfaceC14603iB2 {
        u(Object obj) {
            super(2, obj, C3310Ai2.class, "sendPostDurationEventSimple", "sendPostDurationEventSimple(ILir/nasim/jaryan/feed/model/network/Feed;)V", 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            y(((Number) obj).intValue(), (C5886Lg2) obj2);
            return C19938rB7.a;
        }

        public final void y(int i, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c5886Lg2, "p1");
            ((C3310Ai2) this.receiver).O1(i, c5886Lg2);
        }
    }

    /* renamed from: ir.nasim.Oh2$w */
    static final class w extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        w(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6622Oh2.this.new w(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(1000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C6622Oh2.this.db();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((w) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Oh2$x */
    public static final class x extends ViewPager2.i {
        x() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i) {
            C6622Oh2.this.Ra().C1(i);
        }
    }

    /* renamed from: ir.nasim.Oh2$y */
    public static final class y extends RecyclerView.j {
        final /* synthetic */ ViewPager2 b;

        /* renamed from: ir.nasim.Oh2$y$a */
        public static final class a implements View.OnLayoutChangeListener {
            final /* synthetic */ ViewPager2 a;

            public a(ViewPager2 viewPager2) {
                this.a = viewPager2;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                view.removeOnLayoutChangeListener(this);
                this.a.setCurrentItem(1, false);
            }
        }

        y(ViewPager2 viewPager2) {
            this.b = viewPager2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void d(int i, int i2) {
            super.d(i, i2);
            C6622Oh2 c6622Oh2 = C6622Oh2.this;
            c6622Oh2.currentPage = c6622Oh2.Ka().c.getCurrentItem();
            if (this.b.getCurrentItem() == 1) {
                ViewPager2 viewPager2 = this.b;
                AbstractC13042fc3.f(viewPager2);
                ViewPager2 viewPager22 = this.b;
                if (!viewPager2.isLaidOut() || viewPager2.isLayoutRequested()) {
                    viewPager2.addOnLayoutChangeListener(new a(viewPager22));
                } else {
                    viewPager22.setCurrentItem(1, false);
                }
            }
        }
    }

    /* renamed from: ir.nasim.Oh2$z */
    public static final class z extends AbstractC8614Ws3 implements UA2 {
        public z() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C14470hy2.a(fragment.V7());
        }
    }

    public C6622Oh2() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new B(new A(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C3310Ai2.class), new C(interfaceC9173Yu3B), new D(null, interfaceC9173Yu3B), new E(this, interfaceC9173Yu3B));
        this.viewPagerViewTracker = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ah2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6622Oh2.wb();
            }
        });
        this.snackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Fh2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6622Oh2.vb(this.a);
            }
        });
        this.glideRequests = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Gh2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6622Oh2.Ta(this.a);
            }
        });
        this.animator = new ValueAnimator();
        this.maxTextBoxHeightDp = AbstractC8943Xx1.c(70);
        this.minTextBoxHeightDp = 5.0f;
        this.currentPage = -1;
        this.feedListener = new C6625c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aa(final ViewPager2 pager, final float offset, long duration) {
        if (this.animator.isRunning()) {
            return;
        }
        this.animator.removeAllUpdateListeners();
        this.animator.removeAllListeners();
        this.animator.setFloatValues(0.0f, offset);
        this.animator.setDuration(duration);
        this.animator.setRepeatCount(1);
        this.animator.setRepeatMode(2);
        this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.animator.addListener(new C6624b(pager));
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Hh2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C6622Oh2.Ba(this.a, pager, offset, valueAnimator);
            }
        });
        this.animator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(C6622Oh2 c6622Oh2, ViewPager2 viewPager2, float f2, ValueAnimator valueAnimator) {
        AbstractC13042fc3.i(c6622Oh2, "this$0");
        AbstractC13042fc3.i(viewPager2, "$pager");
        AbstractC13042fc3.i(valueAnimator, "animation");
        if (c6622Oh2.o6() == null || !c6622Oh2.u6()) {
            return;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = c6622Oh2.animFactor * ((Float) animatedValue).floatValue();
        if (!viewPager2.g()) {
            viewPager2.b();
        }
        viewPager2.e(fFloatValue);
        float fAbs = Math.abs(fFloatValue / f2) * c6622Oh2.maxTextBoxHeightDp;
        if (fAbs < ((int) c6622Oh2.minTextBoxHeightDp) || Math.abs(fAbs - c6622Oh2.previousHeightPx) < 1.0f) {
            return;
        }
        Ca(c6622Oh2, (int) fAbs, c6622Oh2.maxTextBoxHeightDp);
        c6622Oh2.previousHeightPx = fAbs;
    }

    private static final void Ca(C6622Oh2 c6622Oh2, int i2, int i3) {
        LinearLayout linearLayout = c6622Oh2.Ka().e;
        AbstractC13042fc3.h(linearLayout, "similarPostTeaching");
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.height = AbstractC23053wG5.i(i2, i3);
        linearLayout.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Da(C11458d25 forwardedPeer, List messages, XH6 sourceType, C5886Lg2 feed, C4743Gj2 feedUI, J44 message, final UA2 onSuccess) {
        final ClipData clipDataNewPlainText;
        final C12889fL5 c12889fL5 = new C12889fL5();
        if (feedUI != null) {
            String strA = La().a(message, false, feedUI.g(), "https://ble.ir/");
            c12889fL5.a = strA;
            clipDataNewPlainText = ClipData.newPlainText("Post Link", strA);
        } else {
            clipDataNewPlainText = null;
        }
        Ma().a(this, forwardedPeer, messages, false, messages.size() == 1, new SA2() { // from class: ir.nasim.Jh2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6622Oh2.Ea();
            }
        }, new SA2() { // from class: ir.nasim.Kh2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6622Oh2.Fa(c12889fL5, clipDataNewPlainText, this);
            }
        }, new SA2() { // from class: ir.nasim.Lh2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6622Oh2.Ga();
            }
        }, new SA2() { // from class: ir.nasim.Mh2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6622Oh2.Ha(c12889fL5, this);
            }
        }, new UA2() { // from class: ir.nasim.Nh2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C6622Oh2.Ja(onSuccess, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ea() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClipData Fa(C12889fL5 c12889fL5, ClipData clipData, C6622Oh2 c6622Oh2) {
        AbstractC13042fc3.i(c12889fL5, "$postLink");
        AbstractC13042fc3.i(c6622Oh2, "this$0");
        String str = (String) c12889fL5.a;
        if (str != null) {
            C4851Gv2 c4851Gv2 = C4851Gv2.a;
            FragmentActivity fragmentActivityQ7 = c6622Oh2.Q7();
            AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
            c4851Gv2.a(str, fragmentActivityQ7);
        }
        return clipData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ga() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ha(C12889fL5 c12889fL5, final C6622Oh2 c6622Oh2) {
        AbstractC13042fc3.i(c12889fL5, "$postLink");
        AbstractC13042fc3.i(c6622Oh2, "this$0");
        String str = (String) c12889fL5.a;
        if (str != null) {
            C4851Gv2.c(C4851Gv2.a, str, null, new UA2() { // from class: ir.nasim.Dh2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C6622Oh2.Ia(this.a, (Intent) obj);
                }
            }, 2, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ia(C6622Oh2 c6622Oh2, Intent intent) {
        AbstractC13042fc3.i(c6622Oh2, "this$0");
        AbstractC13042fc3.i(intent, "it");
        c6622Oh2.n8(intent);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ja(UA2 ua2, List list) {
        AbstractC13042fc3.i(ua2, "$onSuccess");
        AbstractC13042fc3.i(list, "it");
        ua2.invoke(list);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C14470hy2 Ka() {
        Object objA = this.binding.a(this, D1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C14470hy2) objA;
    }

    private final VI2 Na() {
        return (VI2) this.glideRequests.getValue();
    }

    private final RecyclerView.C Oa(ViewPager2 viewPager2, int i2) {
        View viewA = AbstractC24379yW7.a(viewPager2, 0);
        AbstractC13042fc3.g(viewA, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        return ((RecyclerView) viewA).findViewHolderForAdapterPosition(i2);
    }

    private final C17468n10 Qa() {
        return (C17468n10) this.snackBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3310Ai2 Ra() {
        return (C3310Ai2) this.viewModel.getValue();
    }

    private final C20745sX7 Sa() {
        return (C20745sX7) this.viewPagerViewTracker.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VI2 Ta(C6622Oh2 c6622Oh2) {
        AbstractC13042fc3.i(c6622Oh2, "this$0");
        return OI2.d(c6622Oh2);
    }

    private final void Ua(int newPage) {
        if (newPage == 0) {
            Sa().a();
            return;
        }
        C20745sX7 c20745sX7Sa = Sa();
        ViewPager2 viewPager2 = Ka().c;
        AbstractC13042fc3.h(viewPager2, "feedFullScreenViewPager");
        View viewA = AbstractC24379yW7.a(viewPager2, 0);
        AbstractC13042fc3.g(viewA, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        c20745sX7Sa.b((RecyclerView) viewA, newPage, new C6626d(Ra()), new C6627e(Ra()));
        Sa().a();
    }

    private final void Va(int newPagePos) {
        C22714vi2 c22714vi2;
        C25074zh2 c25074zh2 = this.viewPagerAdapter;
        Integer numValueOf = c25074zh2 != null ? Integer.valueOf(c25074zh2.getItemViewType(newPagePos)) : null;
        EnumC12502ej2 enumC12502ej2 = EnumC12502ej2.e;
        int iJ = enumC12502ej2.j();
        if ((numValueOf == null || numValueOf.intValue() != iJ) && this.currentPage != -1 && newPagePos > 0) {
            Ra().o1().h();
        }
        int iJ2 = EnumC12502ej2.d.j();
        if (numValueOf != null && numValueOf.intValue() == iJ2 && newPagePos == 0) {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new f(null), 3, null);
        }
        int iJ3 = enumC12502ej2.j();
        if (numValueOf != null && numValueOf.intValue() == iJ3) {
            ViewPager2 viewPager2 = Ka().c;
            AbstractC13042fc3.h(viewPager2, "feedFullScreenViewPager");
            RecyclerView.C cOa = Oa(viewPager2, newPagePos);
            this.currentVideoHolder = cOa instanceof C22714vi2 ? (C22714vi2) cOa : null;
            int iP = Ra().o1().p();
            C22714vi2 c22714vi22 = this.currentVideoHolder;
            if (iP == 1) {
                Log.w("FeedFullScreenFragment", "handlePlaybackStateChangeForVideoHolder: error while rendering");
            } else if (iP != 2) {
                if (iP == 3) {
                    Ra().o1().D(D6() && getBaleResumed() && B6());
                    if (c22714vi22 != null) {
                        c22714vi22.l4(Ra().o1());
                    }
                    if (c22714vi22 != null) {
                        c22714vi22.g4(D6() && getBaleResumed() && B6());
                    }
                } else if (iP == 4) {
                    if (c22714vi22 != null) {
                        c22714vi22.d4();
                    }
                    Ra().o1().x(0L);
                }
            } else if (c22714vi22 != null) {
                c22714vi22.c4();
            }
            if (this.currentPage != -1) {
                if (newPagePos > 0) {
                    InterfaceC2037k interfaceC2037kO1 = Ra().o1();
                    interfaceC2037kO1.h();
                    interfaceC2037kO1.stop();
                    interfaceC2037kO1.w(0);
                }
                if ((this.currentPage != 0 || newPagePos != 0) && (c22714vi2 = this.currentVideoHolder) != null) {
                    c22714vi2.h4();
                }
                C22714vi2 c22714vi23 = this.currentVideoHolder;
                if (c22714vi23 != null) {
                    c22714vi23.l4(Ra().o1());
                }
            } else {
                C22714vi2 c22714vi24 = this.currentVideoHolder;
                if (c22714vi24 != null) {
                    c22714vi24.l4(Ra().o1());
                }
            }
            if (this.originalMediaItem == null) {
                this.originalMediaItem = Ra().o1().n();
            }
        }
        this.currentPage = newPagePos;
    }

    private final void Wa() {
        Q7().B0().G1("feed_full_screen_result_key", AbstractC23348wm0.a());
    }

    private final InterfaceC13730gj3 Xa() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new g(null), 3, null);
    }

    private final InterfaceC13730gj3 Ya(C25074zh2 adapter) {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new h(adapter, null), 3, null);
    }

    private final InterfaceC13730gj3 Za() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new i(null), 3, null);
    }

    private final InterfaceC13730gj3 ab() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new j(null), 3, null);
    }

    private final void bb() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new k(null), 3, null);
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new l(null), 3, null);
    }

    private final InterfaceC13730gj3 cb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new m(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void db() {
        Bundle bundleE5 = E5();
        if (bundleE5 == null || !bundleE5.getBoolean("SHOW_MORE_CONTENT", false)) {
            return;
        }
        ViewPager2 viewPager2 = Ka().c;
        AbstractC13042fc3.f(viewPager2);
        if (!viewPager2.isLaidOut() || viewPager2.isLayoutRequested()) {
            viewPager2.addOnLayoutChangeListener(new o(viewPager2, this));
            return;
        }
        if (viewPager2.getCurrentItem() == 0) {
            Bundle bundleE52 = E5();
            if (bundleE52 != null && !bundleE52.getBoolean("SHOW_MORE_CONTENT", false)) {
                Ra().E1();
            }
            if (this.isScrolledToMoreContentOnce) {
                return;
            }
            if (!viewPager2.isLaidOut() || viewPager2.isLayoutRequested()) {
                viewPager2.addOnLayoutChangeListener(new p(viewPager2, this));
                return;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, -15.0f);
            valueAnimatorOfFloat.addUpdateListener(new n(valueAnimatorOfFloat, viewPager2));
            AbstractC13042fc3.f(valueAnimatorOfFloat);
            valueAnimatorOfFloat.addListener(new q(viewPager2, this));
            valueAnimatorOfFloat.start();
        }
    }

    private final InterfaceC13730gj3 eb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new r(null), 3, null);
    }

    private final InterfaceC13730gj3 fb() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new s(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gb(C25074zh2 adapter, int newPage) {
        int itemViewType = adapter.getItemViewType(newPage);
        C19406qI3.g("FeedFullScreenFragment", "feed adapter: onPageSelected: " + newPage + ", prevPage: " + this.currentPage + ", holderType: " + itemViewType, new Object[0]);
        Ua(newPage);
        Va(newPage);
        this.currentPage = newPage;
    }

    private final void hb(final InterfaceC14603iB2 onResult) {
        final String str = "FeedFullScreenFragment";
        F5().z("FeedFullScreenFragment");
        F5().H1("FeedFullScreenFragment", this, new InterfaceC13295fz2() { // from class: ir.nasim.Eh2
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str2, Bundle bundle) {
                C6622Oh2.ib(this.a, str, onResult, str2, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ib(C6622Oh2 c6622Oh2, String str, InterfaceC14603iB2 interfaceC14603iB2, String str2, Bundle bundle) {
        OP5 op5;
        AbstractC13042fc3.i(c6622Oh2, "this$0");
        AbstractC13042fc3.i(str, "$resultKey");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onResult");
        AbstractC13042fc3.i(str2, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        c6622Oh2.F5().y(str);
        c6622Oh2.F5().z(str);
        int i2 = bundle.getInt("full_screen_feed_report_title_result_key", 0);
        if (Build.VERSION.SDK_INT >= 33) {
            op5 = (OP5) bundle.getSerializable("full_screen_feed_report_type_result_key", OP5.class);
        } else {
            Serializable serializable = bundle.getSerializable("full_screen_feed_report_type_result_key");
            op5 = serializable instanceof OP5 ? (OP5) serializable : null;
        }
        if (op5 == null) {
            return;
        }
        interfaceC14603iB2.invoke(Integer.valueOf(i2), op5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 kb(C6622Oh2 c6622Oh2, C11458d25 c11458d25, OP5 op5, List list, C5886Lg2 c5886Lg2, String str) {
        AbstractC13042fc3.i(c6622Oh2, "this$0");
        AbstractC13042fc3.i(c11458d25, "$peer");
        AbstractC13042fc3.i(op5, "$type");
        AbstractC13042fc3.i(list, "$messages");
        AbstractC13042fc3.i(c5886Lg2, "$feed");
        AbstractC13042fc3.i(str, "reportDescription");
        c6622Oh2.Ra().J1(c11458d25, str, op5, list, c5886Lg2);
        return C19938rB7.a;
    }

    private final void lb() {
        C2018a0 c2018a0;
        if (this.currentPage != 0 && (c2018a0 = this.originalMediaItem) != null) {
            if (c2018a0 != null) {
                Ra().o1().W(c2018a0);
            }
            this.originalMediaItem = null;
        } else if (this.originalMediaItem == null) {
            Ra().o1().m();
            Ra().o1().h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 nb(UA2 ua2, int i2, OP5 op5) {
        AbstractC13042fc3.i(op5, "reportType");
        if (ua2 != null) {
            ua2.invoke(op5);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ob(List peers, C11458d25 forwardedPeer, C5886Lg2 feed, XH6 sourceType) {
        if (peers.contains(new C11458d25(W25.a, Ra().q1()))) {
            C3310Ai2.N1(Ra(), forwardedPeer.getPeerId(), K5.h, XH6.d, null, null, feed, 24, null);
        } else {
            C3310Ai2.N1(Ra(), forwardedPeer.getPeerId(), K5.e, sourceType, null, null, feed, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pb(final boolean isVisible) {
        LinearLayout root = Ka().d.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        if (isVisible != (root.getVisibility() == 0)) {
            Ka().d.getRoot().animate().alpha(isVisible ? 1.0f : 0.0f).setDuration(250L).withEndAction(new Runnable() { // from class: ir.nasim.Ih2
                @Override // java.lang.Runnable
                public final void run() {
                    C6622Oh2.qb(this.a, isVisible);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qb(C6622Oh2 c6622Oh2, boolean z2) {
        AbstractC13042fc3.i(c6622Oh2, "this$0");
        LinearLayout root = c6622Oh2.Ka().d.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        root.setVisibility(z2 ? 0 : 8);
    }

    private final y rb() {
        ViewPager2 viewPager2 = Ka().c;
        x xVar = new x();
        this.viewPagerListener = xVar;
        viewPager2.k(xVar);
        y yVar = new y(viewPager2);
        C25074zh2 c25074zh2 = this.viewPagerAdapter;
        if (c25074zh2 != null) {
            c25074zh2.registerAdapterDataObserver(yVar);
        }
        return yVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sb(C14330hk2.EnumC14332b state) {
        Ra().o1().g(state == C14330hk2.EnumC14332b.a ? 0.0f : 1.0f);
    }

    private final void tb(InterfaceC14603iB2 onResult) {
        hb(onResult);
        InterfaceC24908zP5.b(Pa(), "FeedFullScreenFragment", "full_screen_feed_report_title_result_key", "full_screen_feed_report_type_result_key", null, 8, null).L8(F5(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ub(String message) {
        try {
            Qa().o(message);
        } catch (Exception e) {
            C19406qI3.j("FeedFullScreenFragment", "showSnackBar error: " + e.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 vb(C6622Oh2 c6622Oh2) {
        AbstractC13042fc3.i(c6622Oh2, "this$0");
        ConstraintLayout root = c6622Oh2.Ka().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return new C17468n10(root, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C20745sX7 wb() {
        return new C20745sX7();
    }

    public final C15629ju1 La() {
        C15629ju1 c15629ju1 = this.createPostLinkUseCase;
        if (c15629ju1 != null) {
            return c15629ju1;
        }
        AbstractC13042fc3.y("createPostLinkUseCase");
        return null;
    }

    public final InterfaceC6762Ow2 Ma() {
        InterfaceC6762Ow2 interfaceC6762Ow2 = this.forwardNavigator;
        if (interfaceC6762Ow2 != null) {
            return interfaceC6762Ow2;
        }
        AbstractC13042fc3.y("forwardNavigator");
        return null;
    }

    public final InterfaceC24908zP5 Pa() {
        InterfaceC24908zP5 interfaceC24908zP5 = this.reportNavigator;
        if (interfaceC24908zP5 != null) {
            return interfaceC24908zP5;
        }
        AbstractC13042fc3.y("reportNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        C14470hy2 c14470hy2C = C14470hy2.c(inflater.cloneInContext(new C16731lm1(S7(), AbstractC14035hE5.Theme_Bale_Feed_FullScreen)), container, false);
        AbstractC13042fc3.h(c14470hy2C, "inflate(...)");
        ConstraintLayout root = c14470hy2C.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.InterfaceC19822r00
    public void S0() {
        super.S0();
        Ra().o1().q();
        C19406qI3.b("FeedFullScreenFragment", "onBaleResume");
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        this.animator.removeAllListeners();
        this.animator.removeAllUpdateListeners();
        this.animator.cancel();
        this.swipeGestureListener = null;
        this.feedListener = null;
        super.T6();
        lb();
        Wa();
        C20745sX7 c20745sX7Sa = Sa();
        ViewPager2 viewPager2 = Ka().c;
        AbstractC13042fc3.h(viewPager2, "feedFullScreenViewPager");
        View viewA = AbstractC24379yW7.a(viewPager2, 0);
        AbstractC13042fc3.g(viewA, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        c20745sX7Sa.b((RecyclerView) viewA, 0, new t(Ra()), new u(Ra()));
        this.currentVideoHolder = null;
        Ka().c.setAdapter(null);
        this.viewPagerAdapter = null;
        Ra().K1();
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        this.isScrolledToMoreContentOnce = false;
        return super.a();
    }

    @Override // ir.nasim.InterfaceC19822r00
    public void a1() {
        super.a1();
        C19406qI3.b("FeedFullScreenFragment", "onBalePause");
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        super.i9();
        Ra().u1();
    }

    public final void jb(final List messages, final OP5 type, final C11458d25 peer, final C5886Lg2 feed) {
        AbstractC13042fc3.i(messages, "messages");
        AbstractC13042fc3.i(type, "type");
        AbstractC13042fc3.i(peer, "peer");
        AbstractC13042fc3.i(feed, "feed");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        C24398yZ.k(contextS7, interfaceC18633oz3P6, type.j(), false, null, new UA2() { // from class: ir.nasim.Ch2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C6622Oh2.kb(this.a, peer, type, messages, feed, (String) obj);
            }
        }, 16, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        O98 o98H = AbstractC12990fW7.H(view);
        InterfaceC13138fj2 interfaceC13138fj2 = this.feedListener;
        if (interfaceC13138fj2 == null) {
            return;
        }
        C25074zh2 c25074zh2 = new C25074zh2(o98H, interfaceC13138fj2, Ra().p1(), Na());
        this.viewPagerAdapter = c25074zh2;
        Ka().c.setAdapter(c25074zh2);
        Ka().c.setPageTransformer(new KA2(AbstractC9766aX0.e(Integer.valueOf(AbstractC12808fC5.feed_bottom_bar))));
        ViewPager2 viewPager2 = Ka().c;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        viewPager2.a(new GC6(contextS7, AbstractC18163oB5.simillar_posts_item_divider));
        v vVar = new v();
        ViewPager2 viewPager22 = Ka().c;
        AbstractC13042fc3.h(viewPager22, "feedFullScreenViewPager");
        this.swipeGestureListener = new K37(vVar, 0, viewPager22, 2, null);
        Za();
        rb();
        eb();
        ab();
        cb();
        Ya(c25074zh2);
        fb();
        Xa();
        bb();
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), C12366eV1.c(), null, new w(null), 2, null);
    }

    public final void mb(final UA2 onReportTypeSelected) {
        tb(new InterfaceC14603iB2() { // from class: ir.nasim.Bh2
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C6622Oh2.nb(onReportTypeSelected, ((Integer) obj).intValue(), (OP5) obj2);
            }
        });
    }

    /* renamed from: ir.nasim.Oh2$v */
    public static final class v implements L37 {
        v() {
        }

        @Override // ir.nasim.L37
        public void a() {
            C6622Oh2.this.Ra().B1();
        }

        @Override // ir.nasim.L37
        public void b() {
        }
    }

    /* renamed from: ir.nasim.Oh2$c, reason: case insensitive filesystem */
    public static final class C6625c implements InterfaceC13138fj2 {
        C6625c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 G(C6622Oh2 c6622Oh2, C11458d25 c11458d25, C5886Lg2 c5886Lg2, XH6 xh6, List list) {
            AbstractC13042fc3.i(c6622Oh2, "this$0");
            AbstractC13042fc3.i(c11458d25, "$forwardedPeer");
            AbstractC13042fc3.i(c5886Lg2, "$feed");
            AbstractC13042fc3.i(xh6, "$sourceType");
            AbstractC13042fc3.i(list, "peers");
            List<C7947Tw2> list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            for (C7947Tw2 c7947Tw2 : list2) {
                arrayList.add(new C11458d25(c7947Tw2.b().getPeerType(), c7947Tw2.c()));
            }
            c6622Oh2.ob(arrayList, c11458d25, c5886Lg2, xh6);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 H(C6622Oh2 c6622Oh2, C11458d25 c11458d25, C5886Lg2 c5886Lg2, XH6 xh6, List list) {
            AbstractC13042fc3.i(c6622Oh2, "this$0");
            AbstractC13042fc3.i(c11458d25, "$forwardedPeer");
            AbstractC13042fc3.i(c5886Lg2, "$feed");
            AbstractC13042fc3.i(xh6, "$sourceType");
            AbstractC13042fc3.i(list, "peers");
            c6622Oh2.ob(list, c11458d25, c5886Lg2, xh6);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 I(C6622Oh2 c6622Oh2, J44 j44, C11458d25 c11458d25, C5886Lg2 c5886Lg2, OP5 op5) {
            AbstractC13042fc3.i(c6622Oh2, "this$0");
            AbstractC13042fc3.i(j44, "$message");
            AbstractC13042fc3.i(c11458d25, "$peer");
            AbstractC13042fc3.i(c5886Lg2, "$feed");
            AbstractC13042fc3.i(op5, "reportType");
            c6622Oh2.jb(AbstractC9766aX0.e(j44), op5, c11458d25, c5886Lg2);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void A(String str, C14697iL2 c14697iL2, boolean z, WH5 wh5, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(str, "reactionCode");
            AbstractC13042fc3.i(c14697iL2, "group");
            AbstractC13042fc3.i(wh5, "reactionType");
            AbstractC13042fc3.i(c5886Lg2, "feed");
            if (z) {
                C6622Oh2.this.Ra().I1(str, c14697iL2, z, wh5, c5886Lg2);
            } else {
                C6622Oh2.this.Ra().g1(str, c14697iL2, z, wh5, c5886Lg2);
            }
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void B(C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c5886Lg2, "feed");
            C21051t17.Companion companion = C21051t17.INSTANCE;
            Boolean boolQ = c5886Lg2.q();
            boolean zBooleanValue = boolQ != null ? boolQ.booleanValue() : false;
            Integer numP = c5886Lg2.p();
            C21051t17 c21051t17A = companion.a(zBooleanValue, numP != null ? numP.intValue() : 0, c5886Lg2.f().getPeerId(), c5886Lg2.m(), c5886Lg2.e());
            C3310Ai2.N1(C6622Oh2.this.Ra(), c5886Lg2.f().getPeerId(), K5.j, null, null, null, c5886Lg2, 28, null);
            C22042ua0.A9(C6622Oh2.this, c21051t17A, false, null, 6, null);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void a() {
            super.a();
            C6622Oh2.this.Q7().onBackPressed();
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void b(long j, String str, long j2, long j3) {
            AbstractC13042fc3.i(str, "mimeType");
            C6622Oh2.this.Ra().Q1(j, str, j2, j3);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public boolean d() {
            return C6622Oh2.this.Ra().h1();
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public boolean e(String str) {
            AbstractC13042fc3.i(str, "url");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            C18987pb3 c18987pb3 = C18987pb3.a;
            FragmentActivity fragmentActivityQ7 = C6622Oh2.this.Q7();
            AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
            return c18987pb3.k0(intent, fragmentActivityQ7);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void f(final J44 j44, final C11458d25 c11458d25, final C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(c5886Lg2, "feed");
            final C6622Oh2 c6622Oh2 = C6622Oh2.this;
            c6622Oh2.mb(new UA2() { // from class: ir.nasim.Th2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C6622Oh2.C6625c.I(c6622Oh2, j44, c11458d25, c5886Lg2, (OP5) obj);
                }
            });
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void g(AbstractC15520jj2.h hVar, AbstractC13019fa0 abstractC13019fa0) {
            AbstractC13042fc3.i(hVar, "videoFeed");
            AbstractC13042fc3.i(abstractC13019fa0, "holder");
            C6622Oh2.this.Ra().z1(hVar);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void h(final C11458d25 c11458d25, List list, final XH6 xh6, final C5886Lg2 c5886Lg2, C4743Gj2 c4743Gj2) {
            AbstractC13042fc3.i(c11458d25, "forwardedPeer");
            AbstractC13042fc3.i(list, "messages");
            AbstractC13042fc3.i(xh6, "sourceType");
            AbstractC13042fc3.i(c5886Lg2, "feed");
            if (C8386Vt0.a.x8()) {
                C6622Oh2 c6622Oh2 = C6622Oh2.this;
                J44 j44 = (J44) AbstractC15401jX0.q0(list);
                final C6622Oh2 c6622Oh22 = C6622Oh2.this;
                c6622Oh2.Da(c11458d25, list, xh6, c5886Lg2, c4743Gj2, j44, new UA2() { // from class: ir.nasim.Rh2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C6622Oh2.C6625c.G(c6622Oh22, c11458d25, c5886Lg2, xh6, (List) obj);
                    }
                });
                return;
            }
            C3310Ai2 c3310Ai2Ra = C6622Oh2.this.Ra();
            Context contextS7 = C6622Oh2.this.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            final C6622Oh2 c6622Oh23 = C6622Oh2.this;
            C3310Ai2.k1(c3310Ai2Ra, c11458d25, list, contextS7, false, new UA2() { // from class: ir.nasim.Sh2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C6622Oh2.C6625c.H(c6622Oh23, c11458d25, c5886Lg2, xh6, (List) obj);
                }
            }, 8, null);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void i(C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c5886Lg2, "feed");
            C3310Ai2.N1(C6622Oh2.this.Ra(), c5886Lg2.f().getPeerId(), K5.i, null, null, null, c5886Lg2, 28, null);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void j(J44 j44) {
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            C6622Oh2.this.Ra().i1(j44);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void k(C11458d25 c11458d25, long j, C8755Xe4 c8755Xe4) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(c8755Xe4, "mid");
            C6622Oh2.this.Ra().x1(c11458d25, j, c8755Xe4);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void m(boolean z, C11458d25 c11458d25, XH6 xh6, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(xh6, "sourceType");
            AbstractC13042fc3.i(c5886Lg2, "feed");
            if (!z) {
                C6622Oh2.this.Ra().w1(c11458d25, xh6, c5886Lg2);
            } else {
                C6622Oh2.this.Ra().o1().h();
                C6622Oh2.this.Ra().H1(c11458d25, xh6, c5886Lg2);
            }
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void n() {
            C6622Oh2.this.Ra().v1();
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void o() {
            C6622Oh2.this.Ra().o1().h();
            C22714vi2 c22714vi2 = C6622Oh2.this.currentVideoHolder;
            if (c22714vi2 != null) {
                c22714vi2.X3();
            }
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public boolean q() {
            C6622Oh2.this.Ra().S1();
            return true;
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void r(FileReference fileReference, int i, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua22) {
            AbstractC13042fc3.i(fileReference, "fileReference");
            AbstractC13042fc3.i(ua2, "onDownloading");
            AbstractC13042fc3.i(interfaceC14603iB2, "onDownLoaded");
            AbstractC13042fc3.i(ua22, "onNotDownloaded");
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void s(String str) {
            AbstractC13042fc3.i(str, "url");
            C6622Oh2 c6622Oh2 = C6622Oh2.this;
            a.Companion companion = ir.nasim.jaryan.search.ui.fragment.a.INSTANCE;
            String strSubstring = str.substring(1);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            c6622Oh2.x9(a.Companion.b(companion, strSubstring, null, 2, null));
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void t() {
            C6622Oh2.this.Ra().R1();
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void u() {
            C6622Oh2.this.Ra().o1().q();
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void v(C8755Xe4 c8755Xe4, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c8755Xe4, "itemMid");
            AbstractC13042fc3.i(c5886Lg2, "feed");
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void w(C4743Gj2 c4743Gj2) {
            AbstractC13042fc3.i(c4743Gj2, "feed");
            C6622Oh2.this.Ra().o1().h();
            C6622Oh2.this.Ra().G1(c4743Gj2);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void x(C11458d25 c11458d25, J44 j44, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c11458d25, "fromPeer");
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(c5886Lg2, "feed");
            C6622Oh2.this.Ra().L1(c11458d25, j44, c5886Lg2);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void y(int i, C8755Xe4 c8755Xe4) {
            AbstractC13042fc3.i(c8755Xe4, "mid");
            C6622Oh2.this.Ra().y1(i, c8755Xe4);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void z(C11458d25 c11458d25, XH6 xh6, C5886Lg2 c5886Lg2) {
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(xh6, "sourceType");
            AbstractC13042fc3.i(c5886Lg2, "feed");
            C6622Oh2.this.Ra().o1().h();
            C6622Oh2.this.Ra().H1(c11458d25, xh6, c5886Lg2);
        }

        @Override // ir.nasim.InterfaceC13138fj2
        public void l(int i) {
        }
    }

    /* renamed from: ir.nasim.Oh2$q */
    public static final class q implements Animator.AnimatorListener {
        final /* synthetic */ ViewPager2 a;
        final /* synthetic */ C6622Oh2 b;

        public q(ViewPager2 viewPager2, C6622Oh2 c6622Oh2) {
            this.a = viewPager2;
            this.b = c6622Oh2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.c();
            this.b.isScrolledToMoreContentOnce = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
