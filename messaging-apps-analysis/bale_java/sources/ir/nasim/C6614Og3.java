package ir.nasim;

import android.content.Context;
import android.content.res.ColorStateList;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.AbstractC8081Ul1;
import ir.nasim.C15225jD4;
import ir.nasim.C23891xh3;
import ir.nasim.GY;
import ir.nasim.O98;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.features.dialogs.view.DialogTabView;
import ir.nasim.jaryan.JaryanSwipeToRefresh;
import ir.nasim.jaryan.search.ui.fragment.a;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 Ì\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Í\u0001B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001a\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u0006J\u000f\u0010\u001c\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001c\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b!\u0010\"J/\u0010&\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010\u001d2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110$H\u0016¢\u0006\u0004\b&\u0010'J/\u0010-\u001a\u00020\u00112\u0006\u0010)\u001a\u00020(2\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*\"\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0011H\u0016¢\u0006\u0004\b/\u0010\u0006J\u000f\u00100\u001a\u00020\u0011H\u0016¢\u0006\u0004\b0\u0010\u0006J\u001f\u00103\u001a\u00020\u00112\u0006\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020\u0014H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0011H\u0016¢\u0006\u0004\b5\u0010\u0006J\u000f\u00106\u001a\u00020\u0011H\u0016¢\u0006\u0004\b6\u0010\u0006J\u0017\u00108\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u0014H\u0016¢\u0006\u0004\b8\u0010\u0017J\u000f\u00109\u001a\u00020\u0011H\u0002¢\u0006\u0004\b9\u0010\u0006J\u0017\u0010;\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u001dH\u0002¢\u0006\u0004\b;\u0010 J=\u0010@\u001a\u00020\u0011*\u00020<2\u0006\u0010=\u001a\u00020\u00142\b\b\u0001\u0010>\u001a\u00020(2\b\b\u0001\u0010?\u001a\u00020(2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110$H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0011H\u0002¢\u0006\u0004\bB\u0010\u0006J\u000f\u0010C\u001a\u00020\u0011H\u0002¢\u0006\u0004\bC\u0010\u0006J\u000f\u0010D\u001a\u00020\u0011H\u0002¢\u0006\u0004\bD\u0010\u0006J\u000f\u0010E\u001a\u00020\u0011H\u0002¢\u0006\u0004\bE\u0010\u0006J\u000f\u0010F\u001a\u00020\u0011H\u0002¢\u0006\u0004\bF\u0010\u0006J\u000f\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0011H\u0002¢\u0006\u0004\bJ\u0010\u0006J\u001f\u0010N\u001a\u00020\u00112\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020(H\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0011H\u0002¢\u0006\u0004\bP\u0010\u0006J\u000f\u0010Q\u001a\u00020\u0011H\u0002¢\u0006\u0004\bQ\u0010\u0006J'\u0010V\u001a\u00020\u00112\u0006\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020(H\u0002¢\u0006\u0004\bV\u0010WJ'\u0010\\\u001a\u00020\u00112\u0006\u0010Y\u001a\u00020X2\u0006\u0010Z\u001a\u00020(2\u0006\u0010[\u001a\u00020(H\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\u0011H\u0002¢\u0006\u0004\b^\u0010\u0006J\u0017\u0010a\u001a\u00020\u00112\u0006\u0010`\u001a\u00020_H\u0002¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u00020\u0011H\u0002¢\u0006\u0004\bc\u0010\u0006J\u000f\u0010d\u001a\u00020\u0011H\u0002¢\u0006\u0004\bd\u0010\u0006J\u000f\u0010e\u001a\u00020\u001dH\u0002¢\u0006\u0004\be\u0010fJ\u000f\u0010g\u001a\u00020\u0011H\u0002¢\u0006\u0004\bg\u0010\u0006J\u000f\u0010h\u001a\u00020\u0011H\u0002¢\u0006\u0004\bh\u0010\u0006J\u000f\u0010i\u001a\u00020\u0011H\u0002¢\u0006\u0004\bi\u0010\u0006J\u000f\u0010j\u001a\u00020\u0011H\u0002¢\u0006\u0004\bj\u0010\u0006J\u000f\u0010k\u001a\u00020\u0011H\u0002¢\u0006\u0004\bk\u0010\u0006J\u000f\u0010l\u001a\u00020\u0011H\u0002¢\u0006\u0004\bl\u0010\u0006J\u000f\u0010m\u001a\u00020\u0011H\u0003¢\u0006\u0004\bm\u0010\u0006J\u0017\u0010n\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\bn\u0010oJ\u0011\u0010q\u001a\u0004\u0018\u00010pH\u0002¢\u0006\u0004\bq\u0010rJ\u001d\u0010u\u001a\u00020\u0011*\u00020\r2\b\b\u0002\u0010t\u001a\u00020sH\u0002¢\u0006\u0004\bu\u0010vR\u001b\u0010|\u001a\u00020w8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0019\u0010\u0083\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R*\u0010\u008b\u0001\u001a\u00030\u0084\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001a\u0010\u008f\u0001\u001a\u00030\u008c\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001a\u0010\u0093\u0001\u001a\u00030\u0090\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R$\u0010\u009a\u0001\u001a\n\u0012\u0005\u0012\u00030\u0095\u00010\u0094\u00018\u0006¢\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R \u0010\u009f\u0001\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R'\u0010¤\u0001\u001a\u00020_8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b!\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0005\b£\u0001\u0010bR\u0019\u0010¦\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010\u0082\u0001R!\u0010«\u0001\u001a\u00030§\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¨\u0001\u0010\u009c\u0001\u001a\u0006\b©\u0001\u0010ª\u0001R)\u0010²\u0001\u001a\u00030¬\u00018\u0006@\u0006X\u0087.¢\u0006\u0017\n\u0005\b6\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R*\u0010º\u0001\u001a\u00030³\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R*\u0010Â\u0001\u001a\u00030»\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R\u001c\u0010Æ\u0001\u001a\u0005\u0018\u00010Ã\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R!\u0010Ë\u0001\u001a\u00030Ç\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÈ\u0001\u0010\u009c\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001¨\u0006Î\u0001"}, d2 = {"Lir/nasim/Og3;", "Lir/nasim/ug3;", "Lir/nasim/wV6;", "Lir/nasim/jD4$b;", "Lir/nasim/Wg3;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lir/nasim/rB7;", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "", ParameterNames.HIDDEN, "W6", "(Z)V", "Q9", "h7", "R6", "c7", "A0", "", "msg", "U2", "(Ljava/lang/String;)V", "q1", "(Lir/nasim/rm1;)Ljava/lang/Object;", "action", "Lkotlin/Function0;", "retry", "W0", "(Ljava/lang/String;Ljava/lang/String;Lir/nasim/SA2;)V", "", "id", "", "", "args", "didReceivedNotification", "(I[Ljava/lang/Object;)V", "O9", "o2", "dy", "isStoryPinned", "C1", "(IZ)V", "I1", "t1", "isEnable", "C2", "yb", "option", "sb", "Lir/nasim/Ul1$b;", "isFocus", "titleRes", "iconRes", "ua", "(Lir/nasim/Ul1$b;ZIILir/nasim/SA2;)V", "Ga", "xa", "Qa", "Pa", "bb", "Lir/nasim/gj3;", "pb", "()Lir/nasim/gj3;", "La", "Landroid/widget/TextView;", "textView", "color", "vb", "(Landroid/widget/TextView;I)V", "ub", "Ka", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "externalMargin", "internalMargin", "Ab", "(Lcom/google/android/material/tabs/TabLayout;II)V", "Landroid/view/ViewGroup$MarginLayoutParams;", "layoutParams", "start", "end", "wb", "(Landroid/view/ViewGroup$MarginLayoutParams;II)V", "Fa", "Lir/nasim/vh3;", "selectedJaryanTab", "Na", "(Lir/nasim/vh3;)V", "qb", "Ba", "ab", "()Ljava/lang/String;", "za", "rb", "H2", "cb", "jb", "kb", "gb", "hb", "(Landroid/view/View;)V", "Landroidx/fragment/app/Fragment;", "Ta", "()Landroidx/fragment/app/Fragment;", "", "duration", "va", "(Landroid/view/View;J)V", "Lir/nasim/ly2;", "i1", "Lir/nasim/bW7;", "Sa", "()Lir/nasim/ly2;", "binding", "Lir/nasim/AQ6;", "j1", "Lir/nasim/AQ6;", "storyFragment", "k1", "Z", "expandStory", "Lir/nasim/core/modules/settings/SettingsModule;", "l1", "Lir/nasim/core/modules/settings/SettingsModule;", "Ya", "()Lir/nasim/core/modules/settings/SettingsModule;", "setSettingsModule", "(Lir/nasim/core/modules/settings/SettingsModule;)V", "settingsModule", "Lcom/google/android/material/tabs/d;", "m1", "Lcom/google/android/material/tabs/d;", "tabLayoutMediator", "Lir/nasim/Bh3;", "n1", "Lir/nasim/Bh3;", "jaryanViewPagerAdapter", "", "Lir/nasim/th3;", "o1", "Ljava/util/List;", "Za", "()Ljava/util/List;", "tabsList", "p1", "Lir/nasim/Yu3;", "eb", "()Z", "isArbaeenUSSDEnabled", "Lir/nasim/vh3;", "Wa", "()Lir/nasim/vh3;", "tb", "lastSelectedTab", "r1", "isEventBarEnabled", "Lir/nasim/xh3;", "s1", "Va", "()Lir/nasim/xh3;", "jaryanViewModel", "Lir/nasim/aO2;", "Lir/nasim/aO2;", "getGroupTypeMakerNavigator", "()Lir/nasim/aO2;", "setGroupTypeMakerNavigator", "(Lir/nasim/aO2;)V", "groupTypeMakerNavigator", "Lir/nasim/wb0;", "u1", "Lir/nasim/wb0;", "Ra", "()Lir/nasim/wb0;", "setBaseSettingsNavigator", "(Lir/nasim/wb0;)V", "baseSettingsNavigator", "Lir/nasim/JM2;", "v1", "Lir/nasim/JM2;", "Xa", "()Lir/nasim/JM2;", "setProfileNavigator", "(Lir/nasim/JM2;)V", "profileNavigator", "Lir/nasim/GY;", "w1", "Lir/nasim/GY;", "multiSelectMoreMenu", "Lir/nasim/n10;", "x1", "Ua", "()Lir/nasim/n10;", "errorAlert", "y1", "a", "jaryan_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Og3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C6614Og3 extends RW2 implements InterfaceC23189wV6, C15225jD4.b, InterfaceC8506Wg3 {

    /* renamed from: j1, reason: from kotlin metadata */
    private AQ6 storyFragment;

    /* renamed from: l1, reason: from kotlin metadata */
    public SettingsModule settingsModule;

    /* renamed from: m1, reason: from kotlin metadata */
    private com.google.android.material.tabs.d tabLayoutMediator;

    /* renamed from: n1, reason: from kotlin metadata */
    private C3541Bh3 jaryanViewPagerAdapter;

    /* renamed from: o1, reason: from kotlin metadata */
    private final List tabsList;

    /* renamed from: p1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 isArbaeenUSSDEnabled;

    /* renamed from: q1, reason: from kotlin metadata */
    private EnumC22705vh3 lastSelectedTab;

    /* renamed from: r1, reason: from kotlin metadata */
    private boolean isEventBarEnabled;

    /* renamed from: s1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 jaryanViewModel;

    /* renamed from: t1, reason: from kotlin metadata */
    public InterfaceC9687aO2 groupTypeMakerNavigator;

    /* renamed from: u1, reason: from kotlin metadata */
    public InterfaceC23238wb0 baseSettingsNavigator;

    /* renamed from: v1, reason: from kotlin metadata */
    public JM2 profileNavigator;

    /* renamed from: w1, reason: from kotlin metadata */
    private GY multiSelectMoreMenu;

    /* renamed from: x1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 errorAlert;
    static final /* synthetic */ InterfaceC5239Im3[] z1 = {AbstractC10882cM5.i(new C25226zw5(C6614Og3.class, "binding", "getBinding()Lir/nasim/jaryan/databinding/FragmentJaryanBinding;", 0))};

    /* renamed from: y1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int A1 = 8;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new p(), AbstractC20046rN7.c());

    /* renamed from: k1, reason: from kotlin metadata */
    private boolean expandStory = true;

    /* renamed from: ir.nasim.Og3$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C6614Og3 a(boolean z, boolean z2) {
            C6614Og3 c6614Og3 = new C6614Og3();
            Bundle bundle = new Bundle();
            bundle.putBoolean("fromTooltip", z2);
            bundle.putBoolean("is_event_bar_enabled_argument", z);
            c6614Og3.a8(bundle);
            return c6614Og3;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Og3$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[C23891xh3.b.values().length];
            try {
                iArr[C23891xh3.b.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C23891xh3.b.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[C23891xh3.c.values().length];
            try {
                iArr2[C23891xh3.c.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[C23891xh3.c.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[C23891xh3.c.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
            int[] iArr3 = new int[EnumC22705vh3.values().length];
            try {
                iArr3[EnumC22705vh3.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[EnumC22705vh3.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[EnumC22705vh3.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            c = iArr3;
        }
    }

    /* renamed from: ir.nasim.Og3$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6614Og3.this.new c(interfaceC20295rm1);
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
            C6614Og3.this.A0();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Og3$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6614Og3.this.new d(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a6  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r9.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r9.b
                ir.nasim.XV4 r0 = (ir.nasim.XV4) r0
                ir.nasim.AbstractC10685c16.b(r10)
                goto L6e
            L16:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L1e:
                java.lang.Object r1 = r9.b
                ir.nasim.XV4 r1 = (ir.nasim.XV4) r1
                ir.nasim.AbstractC10685c16.b(r10)
                goto L55
            L26:
                ir.nasim.AbstractC10685c16.b(r10)
                ir.nasim.Og3 r10 = ir.nasim.C6614Og3.this
                ir.nasim.xh3 r10 = ir.nasim.C6614Og3.sa(r10)
                ir.nasim.XV4 r10 = r10.U0()
                java.lang.Object r1 = r10.e()
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 != 0) goto L45
                java.lang.Object r1 = r10.f()
                if (r1 == 0) goto Lf0
            L45:
                ir.nasim.Og3 r1 = ir.nasim.C6614Og3.this
                r9.b = r10
                r9.c = r3
                java.lang.Object r1 = r1.q1(r9)
                if (r1 != r0) goto L52
                return r0
            L52:
                r8 = r1
                r1 = r10
                r10 = r8
            L55:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 != 0) goto L60
                ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                return r10
            L60:
                r9.b = r1
                r9.c = r2
                r4 = 300(0x12c, double:1.48E-321)
                java.lang.Object r10 = ir.nasim.HG1.b(r4, r9)
                if (r10 != r0) goto L6d
                return r0
            L6d:
                r0 = r1
            L6e:
                java.lang.Object r10 = r0.f()
                r1 = 0
                if (r10 == 0) goto La6
                ir.nasim.Og3 r10 = ir.nasim.C6614Og3.this
                ir.nasim.xh3 r10 = ir.nasim.C6614Og3.sa(r10)
                ir.nasim.C23891xh3.q1(r10, r1, r3, r1)
                ir.nasim.Og3 r10 = ir.nasim.C6614Og3.this
                ir.nasim.xh3 r10 = ir.nasim.C6614Og3.sa(r10)
                java.lang.Object r1 = r0.f()
                ir.nasim.AbstractC13042fc3.f(r1)
                ir.nasim.jaryan.search.data.TooltipConfig r1 = (ir.nasim.jaryan.search.data.TooltipConfig) r1
                long r1 = r1.getUid()
                java.lang.Long r1 = ir.nasim.AbstractC6392Nk0.e(r1)
                r10.p1(r1)
                java.lang.Object r10 = r0.f()
                ir.nasim.AbstractC13042fc3.f(r10)
                ir.nasim.jaryan.search.data.TooltipConfig r10 = (ir.nasim.jaryan.search.data.TooltipConfig) r10
                java.lang.String r10 = r10.getMessage()
                goto Lba
            La6:
                ir.nasim.Og3 r10 = ir.nasim.C6614Og3.this
                ir.nasim.xh3 r10 = ir.nasim.C6614Og3.sa(r10)
                ir.nasim.C23891xh3.q1(r10, r1, r3, r1)
                ir.nasim.Og3 r10 = ir.nasim.C6614Og3.this
                int r0 = ir.nasim.ID5.search_in_channel_and_content
                java.lang.String r10 = r10.h6(r0)
                ir.nasim.AbstractC13042fc3.f(r10)
            Lba:
                ir.nasim.bs7 r0 = ir.nasim.C10600bs7.a
                ir.nasim.Og3 r1 = ir.nasim.C6614Og3.this
                ir.nasim.D20$a r0 = r0.a(r1)
                r1 = 1061997773(0x3f4ccccd, float:0.8)
                r0.a1(r1)
                r1 = 1096810496(0x41600000, float:14.0)
                r0.e2(r1)
                android.graphics.Typeface r1 = ir.nasim.C6011Lu2.k()
                r0.h2(r1)
                r0.X1(r10)
                ir.nasim.D20 r2 = r0.a()
                ir.nasim.Og3 r10 = ir.nasim.C6614Og3.this
                ir.nasim.ly2 r10 = ir.nasim.C6614Og3.ra(r10)
                android.widget.ImageView r3 = r10.r
                java.lang.String r10 = "toolbarSearchImage"
                ir.nasim.AbstractC13042fc3.h(r3, r10)
                r6 = 4
                r7 = 0
                r4 = -10
                r5 = 0
                ir.nasim.D20.K0(r2, r3, r4, r5, r6, r7)
            Lf0:
                ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6614Og3.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Og3$e */
    public static final class e extends ViewPager2.i {
        e() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void b(int i, float f, int i2) {
            super.b(i, f, i2);
            C6614Og3.this.Sa().m.setExpanded(true, true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i) {
            super.c(i);
            EnumC22705vh3 enumC22705vh3C = ((AbstractC21525th3) C6614Og3.this.getTabsList().get(i)).c();
            C6614Og3.this.Va().m1(enumC22705vh3C);
            MaterialButton materialButton = C6614Og3.this.Sa().d;
            AbstractC13042fc3.h(materialButton, "filterFab");
            materialButton.setVisibility(enumC22705vh3C == EnumC22705vh3.b ? 0 : 8);
            C22115uh3.a(C6614Og3.this.getLastSelectedTab(), enumC22705vh3C);
            C22115uh3.b();
            if (enumC22705vh3C == EnumC22705vh3.c) {
                C6614Og3.this.getIsFeedActive().setValue(Boolean.TRUE);
                C6614Og3.this.O9();
            } else {
                C24480yh2.a.c().h();
                C6614Og3.this.getIsFeedActive().setValue(Boolean.FALSE);
            }
            C6614Og3.this.tb(enumC22705vh3C);
        }
    }

    /* renamed from: ir.nasim.Og3$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC8081Ul1.b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(AbstractC8081Ul1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = bVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6614Og3.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            MaterialButton materialButton = C6614Og3.this.Sa().d;
            AbstractC13042fc3.h(materialButton, "filterFab");
            ConstraintLayout root = C6614Og3.this.Sa().getRoot();
            AbstractC13042fc3.h(root, "getRoot(...)");
            new GY.a(materialButton, root, null, 4, null).d(false).b(this.d).showAtLocation(C6614Og3.this.Sa().getRoot(), 0, C6614Og3.this.Sa().d.getLeft(), (C6614Og3.this.Sa().d.getTop() - AbstractC8943Xx1.c(C6614Og3.this.Sa().d.getHeight())) - C6614Og3.this.Sa().d.getPaddingTop());
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Og3$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Og3$h$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ C6614Og3 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C6614Og3 c6614Og3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6614Og3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c) {
                    this.d.Qa();
                } else {
                    this.d.Pa();
                }
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6614Og3.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6K1 = C6614Og3.this.Va().k1();
                a aVar = new a(C6614Og3.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6K1, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.Og3$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Og3$i$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C6614Og3 a;

            a(C6614Og3 c6614Og3) {
                this.a = c6614Og3;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(EnumC22705vh3 enumC22705vh3, InterfaceC20295rm1 interfaceC20295rm1) {
                if (enumC22705vh3 != null) {
                    C6614Og3 c6614Og3 = this.a;
                    c6614Og3.tb(enumC22705vh3);
                    c6614Og3.Na(enumC22705vh3);
                    TabLayout tabLayout = c6614Og3.Sa().g;
                    AbstractC13042fc3.h(tabLayout, "jaryanTabLayout");
                    tabLayout.setVisibility(C8386Vt0.a.cb() ^ true ? 0 : 8);
                    ViewPager2 viewPager2 = c6614Og3.Sa().h;
                    AbstractC13042fc3.h(viewPager2, "jaryanViewPager");
                    viewPager2.setVisibility(0);
                }
                return C19938rB7.a;
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6614Og3.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4F1 = C6614Og3.this.Va().f1();
                a aVar = new a(C6614Og3.this);
                this.b = 1;
                if (interfaceC8327Vm4F1.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Og3$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.Og3$j$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ InterfaceC20315ro1 d;
            final /* synthetic */ C6614Og3 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC20315ro1 interfaceC20315ro1, C6614Og3 c6614Og3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC20315ro1;
                this.e = c6614Og3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                String name;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c) {
                    InterfaceC20315ro1 interfaceC20315ro1 = this.d;
                    if (interfaceC20315ro1.getClass().isAnonymousClass()) {
                        name = interfaceC20315ro1.getClass().getName();
                        int length = name.length();
                        AbstractC13042fc3.f(name);
                        if (length > 23) {
                            name = name.substring(name.length() - 23, name.length());
                            AbstractC13042fc3.h(name, "substring(...)");
                        }
                    } else {
                        name = interfaceC20315ro1.getClass().getSimpleName();
                        int length2 = name.length();
                        AbstractC13042fc3.f(name);
                        if (length2 > 23) {
                            name = name.substring(0, 23);
                            AbstractC13042fc3.h(name, "substring(...)");
                        }
                    }
                    C19406qI3.a(name, "screen off, calling onFeedFragmentHidden", new Object[0]);
                    this.e.Q9();
                }
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = C6614Og3.this.new j(interfaceC20295rm1);
            jVar.c = obj;
            return jVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC10258bL6 interfaceC10258bL6C1 = C6614Og3.this.Va().c1();
                a aVar = new a(interfaceC20315ro1, C6614Og3.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6C1, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.Og3$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6614Og3.this.new k(interfaceC20295rm1);
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
            C6614Og3.this.A0();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Og3$l */
    static final class l implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        l(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "function");
            this.a = ua2;
        }

        @Override // ir.nasim.QG4
        public final /* synthetic */ void a(Object obj) {
            this.a.invoke(obj);
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof QG4) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    /* renamed from: ir.nasim.Og3$m */
    public static final class m extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            C14819iX7 c14819iX7D1 = this.e.Q7().d1();
            AbstractC13042fc3.h(c14819iX7D1, "requireActivity().viewModelStore");
            return c14819iX7D1;
        }
    }

    /* renamed from: ir.nasim.Og3$n */
    public static final class n extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            AbstractC20375ru1 abstractC20375ru1P3 = this.f.Q7().p3();
            AbstractC13042fc3.h(abstractC20375ru1P3, "requireActivity().defaultViewModelCreationExtras");
            return abstractC20375ru1P3;
        }
    }

    /* renamed from: ir.nasim.Og3$o */
    public static final class o extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3 = this.e.Q7().n3();
            AbstractC13042fc3.h(cVarN3, "requireActivity().defaultViewModelProviderFactory");
            return cVarN3;
        }
    }

    /* renamed from: ir.nasim.Og3$p */
    public static final class p extends AbstractC8614Ws3 implements UA2 {
        public p() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C16850ly2.a(fragment.V7());
        }
    }

    public C6614Og3() {
        this.tabsList = C8386Vt0.a.cb() ? AbstractC9766aX0.e(new C13689gf2(this)) : AbstractC10360bX0.p(new C13689gf2(this), new C8189Ux1(this));
        this.isArbaeenUSSDEnabled = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ng3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C6614Og3.fb());
            }
        });
        this.lastSelectedTab = EnumC22705vh3.b;
        this.jaryanViewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C23891xh3.class), new m(this), new n(null, this), new o(this));
        this.errorAlert = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.wg3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6614Og3.Oa(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(C6614Og3 c6614Og3) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        c6614Og3.Va().a1();
        AQ6 aq6 = c6614Og3.storyFragment;
        if (aq6 != null) {
            if (aq6.ga()) {
                aq6.na();
            } else {
                AbstractC10533bm0.d(AbstractC19224pz3.a(c6614Og3), null, null, c6614Og3.new c(null), 3, null);
            }
        }
        c6614Og3.rb();
    }

    private final void Ab(TabLayout tabLayout, int externalMargin, int internalMargin) {
        View childAt = tabLayout.getChildAt(0);
        if (childAt instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) childAt;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt2 = viewGroup.getChildAt(i2);
                childAt2.setMinimumWidth(0);
                childAt2.setPadding(0, childAt2.getPaddingTop(), 0, childAt2.getPaddingBottom());
                if (childAt2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                    AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (i2 == 0) {
                        wb(marginLayoutParams, externalMargin, internalMargin);
                    } else if (i2 == childCount - 1) {
                        wb(marginLayoutParams, internalMargin, externalMargin);
                    } else {
                        wb(marginLayoutParams, internalMargin, internalMargin);
                    }
                }
            }
            tabLayout.requestLayout();
        }
    }

    private final void Ba() {
        if (Va().X0()) {
            Sa().r.setImageResource(AbstractC18163oB5.smiles_search);
            Sa().r.setImageTintList(ColorStateList.valueOf(S7().getResources().getColor(AA5.n100)));
        } else {
            Sa().r.setImageResource(AbstractC18163oB5.search_badge);
        }
        Sa().i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.xg3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C6614Og3.Ca(this.a, view);
            }
        });
        Sa().j.setTypeface(C6011Lu2.k());
        Sa().q.y(AbstractC14026hD5.dialog_container_new);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new d(null), 3, null);
        Sa().j.setText(ab());
        Sa().q.setNavigationDrawerFragment(Va().T0());
        Sa().q.setNavigationOnClickListener(new View.OnClickListener() { // from class: ir.nasim.yg3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C6614Og3.Da(this.a, view);
            }
        });
        Sa().q.getMenu().setGroupVisible(BC5.menu_dialog_normal, false);
        Sa().q.setOnMenuItemClickListener(new Toolbar.g() { // from class: ir.nasim.zg3
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return C6614Og3.Ea(this.a, menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(C6614Og3 c6614Og3, View view) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        ir.nasim.jaryan.search.ui.fragment.a aVarB = a.Companion.b(ir.nasim.jaryan.search.ui.fragment.a.INSTANCE, null, null, 3, null);
        c6614Og3.Va().s1();
        c6614Og3.Sa().r.setImageResource(AbstractC18163oB5.smiles_search);
        C22042ua0.A9(c6614Og3, aVarB, false, null, 6, null);
        C22115uh3.a.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(C6614Og3 c6614Og3, View view) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        c6614Og3.x9(c6614Og3.Ra().d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ea(C6614Og3 c6614Og3, MenuItem menuItem) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        AbstractC13042fc3.i(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == AbstractC12808fC5.dialog_action_mute) {
            c6614Og3.jb();
            return true;
        }
        if (itemId == AbstractC12808fC5.dialog_action_pin) {
            c6614Og3.kb();
            return true;
        }
        if (itemId == AbstractC12808fC5.dialog_action_delete) {
            c6614Og3.gb();
            return true;
        }
        if (itemId != AbstractC12808fC5.dialog_action_more) {
            return false;
        }
        ConstraintLayout root = c6614Og3.Sa().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        c6614Og3.hb(root);
        return true;
    }

    private final void Fa() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        this.jaryanViewPagerAdapter = new C3541Bh3(this, this.tabsList);
        ViewPager2 viewPager2 = Sa().h;
        C3541Bh3 c3541Bh3 = this.jaryanViewPagerAdapter;
        if (c3541Bh3 == null) {
            AbstractC13042fc3.y("jaryanViewPagerAdapter");
            c3541Bh3 = null;
        }
        viewPager2.setAdapter(c3541Bh3);
        viewPager2.k(new e());
        qb();
    }

    private final void Ga() {
        AbstractC8081Ul1.b bVar = new AbstractC8081Ul1.b();
        ua(bVar, Va().Z0() == EnumC17739nU1.a, ID5.chat_album_message_action_delete_all, AbstractC18163oB5.drawable_market_suggestion_category, new SA2() { // from class: ir.nasim.Fg3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6614Og3.Ha(this.a);
            }
        });
        ua(bVar, Va().Z0() == EnumC17739nU1.b, ID5.store_channel, AbstractC18163oB5.shop, new SA2() { // from class: ir.nasim.Gg3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6614Og3.Ia(this.a);
            }
        });
        ua(bVar, Va().Z0() == EnumC17739nU1.c, ID5.content_channel, AbstractC18163oB5.drawable_market_suggestion_tv, new SA2() { // from class: ir.nasim.Hg3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6614Og3.Ja(this.a);
            }
        });
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new f(bVar, null), 3, null);
    }

    private final void H2() {
        int i2 = b.c[this.lastSelectedTab.ordinal()];
        if (i2 == 1) {
            C3541Bh3 c3541Bh3 = this.jaryanViewPagerAdapter;
            if (c3541Bh3 == null) {
                AbstractC13042fc3.y("jaryanViewPagerAdapter");
                c3541Bh3 = null;
            }
            Object obj = c3541Bh3.T().get(EnumC22705vh3.a);
            C11680dQ3 c11680dQ3 = obj instanceof C11680dQ3 ? (C11680dQ3) obj : null;
            if (c11680dQ3 != null) {
                c11680dQ3.xa();
            }
        } else if (i2 == 2) {
            C3541Bh3 c3541Bh32 = this.jaryanViewPagerAdapter;
            if (c3541Bh32 == null) {
                AbstractC13042fc3.y("jaryanViewPagerAdapter");
                c3541Bh32 = null;
            }
            Object obj2 = c3541Bh32.T().get(EnumC22705vh3.b);
            C15375jU1 c15375jU1 = obj2 instanceof C15375jU1 ? (C15375jU1) obj2 : null;
            if (c15375jU1 != null) {
                c15375jU1.qa();
            }
            Sa().o.setEnabled(true);
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            C3541Bh3 c3541Bh33 = this.jaryanViewPagerAdapter;
            if (c3541Bh33 == null) {
                AbstractC13042fc3.y("jaryanViewPagerAdapter");
                c3541Bh33 = null;
            }
            Object obj3 = c3541Bh33.T().get(EnumC22705vh3.c);
            C14330hk2 c14330hk2 = obj3 instanceof C14330hk2 ? (C14330hk2) obj3 : null;
            if (c14330hk2 != null) {
                C14330hk2.bb(c14330hk2, true, false, 2, null);
            }
            Sa().o.setEnabled(true);
        }
        ConstraintLayout constraintLayout = Sa().p;
        AbstractC13042fc3.h(constraintLayout, "storyView");
        if (AbstractC14828iY7.i(constraintLayout)) {
            return;
        }
        ConstraintLayout constraintLayout2 = Sa().p;
        AbstractC13042fc3.h(constraintLayout2, "storyView");
        wa(this, constraintLayout2, 0L, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ha(C6614Og3 c6614Og3) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        c6614Og3.sb("discover_all");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ia(C6614Og3 c6614Og3) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        c6614Og3.sb("store_channel");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ja(C6614Og3 c6614Og3) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        c6614Og3.sb("CONTENT_channel");
        return C19938rB7.a;
    }

    private final void Ka() {
        TabLayout tabLayout = Sa().g;
        AbstractC13042fc3.h(tabLayout, "jaryanTabLayout");
        Ab(tabLayout, 16, 16);
    }

    private final void La() {
        com.google.android.material.tabs.d dVar = new com.google.android.material.tabs.d(Sa().g, Sa().h, new d.b() { // from class: ir.nasim.Bg3
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i2) {
                C6614Og3.Ma(this.a, gVar, i2);
            }
        });
        this.tabLayoutMediator = dVar;
        dVar.a();
        Sa().g.d(new g());
        ub();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(C6614Og3 c6614Og3, TabLayout.g gVar, int i2) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        AbstractC13042fc3.i(gVar, "tab");
        AbstractC21525th3 abstractC21525th3 = (AbstractC21525th3) c6614Og3.tabsList.get(i2);
        Context contextS7 = c6614Og3.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        DialogTabView dialogTabView = new DialogTabView(contextS7);
        dialogTabView.setTitleSize(14.0f);
        dialogTabView.c();
        String strH6 = c6614Og3.h6(abstractC21525th3.b());
        AbstractC13042fc3.h(strH6, "getString(...)");
        dialogTabView.setTitle(strH6);
        gVar.r(dialogTabView);
        gVar.w(abstractC21525th3.c().name());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Na(EnumC22705vh3 selectedJaryanTab) {
        Iterator it = this.tabsList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (((AbstractC21525th3) it.next()).c() == selectedJaryanTab) {
                break;
            } else {
                i2++;
            }
        }
        Sa().h.setCurrentItem(i2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 Oa(C6614Og3 c6614Og3) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        ConstraintLayout root = c6614Og3.Sa().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.k(c6614Og3.Sa().l);
        c17468n10.m(0);
        return c17468n10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pa() {
        MaterialButton materialButton = Sa().d;
        AbstractC13042fc3.h(materialButton, "filterFab");
        ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = 22;
        materialButton.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qa() {
        MaterialButton materialButton = Sa().d;
        AbstractC13042fc3.h(materialButton, "filterFab");
        ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = 200;
        materialButton.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C16850ly2 Sa() {
        Object objA = this.binding.a(this, z1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C16850ly2) objA;
    }

    private final Fragment Ta() {
        AbstractC21525th3 abstractC21525th3 = (AbstractC21525th3) this.tabsList.get(Sa().h.getCurrentItem());
        C3541Bh3 c3541Bh3 = this.jaryanViewPagerAdapter;
        if (c3541Bh3 == null) {
            AbstractC13042fc3.y("jaryanViewPagerAdapter");
            c3541Bh3 = null;
        }
        return (Fragment) c3541Bh3.T().get(abstractC21525th3.c());
    }

    private final C17468n10 Ua() {
        return (C17468n10) this.errorAlert.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C23891xh3 Va() {
        return (C23891xh3) this.jaryanViewModel.getValue();
    }

    private final String ab() {
        return Ya().getString(JF5.g() ? "jaryan_searchbar_placeholder" : "jaryan_searchbar_placeholder_english", JF5.g() ? "جستجوی محتوا، تصویر و کانال" : "Search contents, photos and channels");
    }

    private final void bb() {
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new h(null), 3, null);
    }

    private final void cb() {
        Sa().i.setVisibility(0);
        Sa().q.getMenu().setGroupVisible(BC5.menu_dialog_action_mode, false);
        Sa().q.f0(new View.OnClickListener() { // from class: ir.nasim.Ag3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C6614Og3.db(this.a, view);
            }
        });
        if (Sa().k.getVisibility() == 0) {
            Sa().k.setVisibility(8);
        }
        Va().v1(true, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void db(C6614Og3 c6614Og3, View view) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        c6614Og3.x9(c6614Og3.Ra().d());
    }

    private final boolean eb() {
        return ((Boolean) this.isArbaeenUSSDEnabled.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean fb() {
        return AbstractC5969Lp4.e().H().w0(EnumC4196Ec1.w);
    }

    private final void gb() {
        Va().g1().f();
    }

    private final void hb(View view) {
        List list = (List) Va().d1().f();
        if (list != null) {
            AbstractC8081Ul1.b bVar = new AbstractC8081Ul1.b();
            if (list.size() == 1) {
                C17067mL1 c17067mL1 = (C17067mL1) list.get(0);
                final int peerId = c17067mL1.R().getPeerId();
                final W25 w25S = c17067mL1.R().s();
                AbstractC13042fc3.h(w25S, "getPeerType(...)");
                if (peerId != AbstractC5969Lp4.f()) {
                    AbstractC8081Ul1.b.k(bVar, ID5.dialogs_menu_contact_view, AbstractC18163oB5.ic_profile, null, new SA2() { // from class: ir.nasim.vg3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C6614Og3.ib(w25S, peerId, this);
                        }
                    }, 4, null);
                }
            }
            if (bVar.b()) {
                return;
            }
            View rootView = view.getRootView();
            AbstractC13042fc3.g(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            GY gyB = new GY.a(view, (ViewGroup) rootView, null, 4, null).d(true).g(new RS4(4.0f, 4.0f, 4.0f, 2.0f)).b(bVar);
            this.multiSelectMoreMenu = gyB;
            if (gyB != null) {
                gyB.x();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ib(W25 w25, int i2, C6614Og3 c6614Og3) {
        AbstractC13042fc3.i(w25, "$peerType");
        AbstractC13042fc3.i(c6614Og3, "this$0");
        if (w25 == W25.a) {
            C22042ua0.A9(c6614Og3, C24137y63.b(i2), false, null, 6, null);
        } else if (w25 == W25.b) {
            Bundle bundle = new Bundle();
            bundle.putInt("chat_id", i2);
            C22042ua0 c22042ua0E = JM2.e(c6614Og3.Xa(), i2, false, 2, null);
            c22042ua0E.a8(bundle);
            C22042ua0.A9(c6614Og3, c22042ua0E, false, null, 6, null);
        }
        c6614Og3.Va().w1(C23891xh3.d.b.a);
        return C19938rB7.a;
    }

    private final void jb() {
        List list = (List) Va().d1().f();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AbstractC5969Lp4.d().t(((C17067mL1) it.next()).R(), Va().h1().f() == C23891xh3.b.a);
            }
        }
        Va().w1(C23891xh3.d.b.a);
    }

    private final void kb() {
        List list = (List) Va().d1().f();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Va().l1((C17067mL1) it.next());
            }
        }
        Va().w1(C23891xh3.d.b.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 lb(C6614Og3 c6614Og3, C23891xh3.d dVar) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        if (dVar instanceof C23891xh3.d.b) {
            c6614Og3.cb();
            c6614Og3.Va().W0();
            c6614Og3.Va().v1(true, 0);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 mb(C6614Og3 c6614Og3, MenuItem menuItem, C23891xh3.b bVar) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        AbstractC13042fc3.i(menuItem, "$muteItem");
        int i2 = bVar == null ? -1 : b.a[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                if (AbstractC13042fc3.d(c6614Og3.Va().g1().f(), C23891xh3.d.b.a)) {
                    menuItem.setVisible(false);
                } else {
                    c6614Og3.Va().g1().f();
                }
            }
        } else if (AbstractC13042fc3.d(c6614Og3.Va().g1().f(), C23891xh3.d.b.a)) {
            menuItem.setVisible(false);
        } else {
            c6614Og3.Va().g1().f();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 nb(MenuItem menuItem, C6614Og3 c6614Og3, C23891xh3.c cVar) {
        AbstractC13042fc3.i(menuItem, "$pinItem");
        AbstractC13042fc3.i(c6614Og3, "this$0");
        int i2 = cVar == null ? -1 : b.b[cVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    menuItem.setVisible(false);
                }
            } else if (AbstractC13042fc3.d(c6614Og3.Va().g1().f(), C23891xh3.d.b.a)) {
                menuItem.setVisible(false);
            } else {
                c6614Og3.Va().g1().f();
            }
        } else if (AbstractC13042fc3.d(c6614Og3.Va().g1().f(), C23891xh3.d.b.a)) {
            menuItem.setVisible(false);
        } else {
            c6614Og3.Va().g1().f();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ob(C6614Og3 c6614Og3, int i2) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        if (c6614Og3.Sa().k.getVisibility() == 0) {
            if (i2 == Integer.MAX_VALUE) {
                c6614Og3.Sa().k.setText(c6614Og3.h6(ID5.toolbar_all_title));
            } else {
                String strValueOf = String.valueOf(i2);
                if (JF5.g()) {
                    strValueOf = XY6.e(strValueOf);
                }
                c6614Og3.Sa().k.setText(strValueOf);
            }
        }
        return C19938rB7.a;
    }

    private final InterfaceC13730gj3 pb() {
        return AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new j(null), 3, null);
    }

    private final void qb() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        String name;
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("j");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(Sa().h);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) obj;
            Field declaredField2 = RecyclerView.class.getDeclaredField("O0");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(recyclerView);
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Int");
            declaredField2.set(recyclerView, Integer.valueOf(((Integer) obj2).intValue() * 4));
        } catch (Exception e2) {
            if (C6614Og3.class.isAnonymousClass()) {
                name = C6614Og3.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C6614Og3.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.j(name, "reduceDragSensitivity: " + e2.getMessage(), new Object[0]);
        }
    }

    private final void rb() {
        C3541Bh3 c3541Bh3 = this.jaryanViewPagerAdapter;
        if (c3541Bh3 == null) {
            AbstractC13042fc3.y("jaryanViewPagerAdapter");
            c3541Bh3 = null;
        }
        Object obj = c3541Bh3.T().get(EnumC22705vh3.c);
        C14330hk2 c14330hk2 = obj instanceof C14330hk2 ? (C14330hk2) obj : null;
        if (c14330hk2 != null) {
            C14330hk2.xb(c14330hk2, false, 1, null);
        }
        if (this.storyFragment == null) {
            AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new k(null), 3, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void sb(java.lang.String r4) {
        /*
            r3 = this;
            ir.nasim.xh3 r0 = r3.Va()
            int r1 = r4.hashCode()
            r2 = 819178405(0x30d3aba5, float:1.5401055E-9)
            if (r1 == r2) goto L2f
            r2 = 1177879627(0x4635044b, float:11585.073)
            if (r1 == r2) goto L24
            r2 = 1495825181(0x59287b1d, float:2.9639475E15)
            if (r1 == r2) goto L18
            goto L37
        L18:
            java.lang.String r1 = "CONTENT_channel"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L21
            goto L37
        L21:
            ir.nasim.nU1 r1 = ir.nasim.EnumC17739nU1.c
            goto L3c
        L24:
            java.lang.String r1 = "discover_all"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L37
            ir.nasim.nU1 r1 = ir.nasim.EnumC17739nU1.a
            goto L3c
        L2f:
            java.lang.String r1 = "store_channel"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L3a
        L37:
            ir.nasim.nU1 r1 = ir.nasim.EnumC17739nU1.a
            goto L3c
        L3a:
            ir.nasim.nU1 r1 = ir.nasim.EnumC17739nU1.b
        L3c:
            r0.t1(r1)
            androidx.fragment.app.FragmentManager r0 = r3.F5()
            ir.nasim.XV4 r1 = new ir.nasim.XV4
            java.lang.String r2 = "discover_option"
            r1.<init>(r2, r4)
            ir.nasim.XV4[] r4 = new ir.nasim.XV4[]{r1}
            android.os.Bundle r4 = ir.nasim.AbstractC23348wm0.b(r4)
            java.lang.String r1 = "request_key_discover_data_changed"
            r0.G1(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6614Og3.sb(java.lang.String):void");
    }

    private final void ua(AbstractC8081Ul1.b bVar, boolean z, int i2, int i3, SA2 sa2) {
        if (z) {
            AbstractC8081Ul1.b.f(bVar, i2, i3, null, sa2, 4, null);
        } else {
            AbstractC8081Ul1.b.k(bVar, i2, i3, null, sa2, 4, null);
        }
    }

    private final void ub() {
        String name;
        TabLayout.g gVarY = Sa().g.y(Sa().g.getSelectedTabPosition());
        if (gVarY != null) {
            try {
                View viewE = gVarY.e();
                TextView textView = viewE != null ? (TextView) viewE.findViewById(BC5.tv_dialog_tab_title) : null;
                if (textView != null) {
                    C5495Jo7 c5495Jo7 = C5495Jo7.a;
                    textView.setTextColor(c5495Jo7.y2());
                    vb(textView, c5495Jo7.y2());
                }
            } catch (Exception e2) {
                if (C6614Og3.class.isAnonymousClass()) {
                    name = C6614Og3.class.getName();
                    int length = name.length();
                    AbstractC13042fc3.f(name);
                    if (length > 23) {
                        name = name.substring(name.length() - 23, name.length());
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                } else {
                    name = C6614Og3.class.getSimpleName();
                    int length2 = name.length();
                    AbstractC13042fc3.f(name);
                    if (length2 > 23) {
                        name = name.substring(0, 23);
                        AbstractC13042fc3.h(name, "substring(...)");
                    }
                }
                C19406qI3.d(name, e2);
            }
        }
    }

    private final void va(View view, long j2) {
        view.setAlpha(0.0f);
        view.setVisibility(0);
        view.animate().alpha(1.0f).setDuration(j2).setListener(null).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void vb(TextView textView, int color) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
            }
        }
    }

    static /* synthetic */ void wa(C6614Og3 c6614Og3, View view, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 300;
        }
        c6614Og3.va(view, j2);
    }

    private final void wb(ViewGroup.MarginLayoutParams layoutParams, int start, int end) {
        layoutParams.setMarginStart(start);
        layoutParams.setMarginEnd(end);
        layoutParams.leftMargin = start;
        layoutParams.rightMargin = end;
    }

    private final void xa() {
        Sa().d.setTypeface(C6011Lu2.i());
        Sa().d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Cg3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C6614Og3.ya(this.a, view);
            }
        });
        bb();
        if (this.isEventBarEnabled) {
            Qa();
            Va().u1(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 xb(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$retry");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ya(C6614Og3 c6614Og3, View view) {
        AbstractC13042fc3.i(c6614Og3, "this$0");
        c6614Og3.Ga();
    }

    private final void yb() {
        AbstractC12990fW7.E0(Sa().getRoot(), new InterfaceC22474vI4() { // from class: ir.nasim.Dg3
            @Override // ir.nasim.InterfaceC22474vI4
            public final O98 b(View view, O98 o98) {
                return C6614Og3.zb(view, o98);
            }
        });
    }

    private final void za() {
        JaryanSwipeToRefresh jaryanSwipeToRefresh = Sa().o;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        jaryanSwipeToRefresh.setProgressBackgroundColorSchemeColor(c5495Jo7.i0());
        jaryanSwipeToRefresh.setColorSchemeColors(c5495Jo7.t2());
        jaryanSwipeToRefresh.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: ir.nasim.Eg3
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void H1() {
                C6614Og3.Aa(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final O98 zb(View view, O98 o98) {
        AbstractC13042fc3.i(view, "v");
        AbstractC13042fc3.i(o98, "insets");
        L93 l93F = o98.f(O98.m.h());
        AbstractC13042fc3.h(l93F, "getInsets(...)");
        view.setPadding(view.getPaddingLeft(), l93F.b, view.getPaddingRight(), view.getPaddingBottom());
        return O98.b;
    }

    @Override // ir.nasim.InterfaceC23189wV6
    public void A0() {
        Sa().o.setRefreshing(false);
    }

    @Override // ir.nasim.InterfaceC8506Wg3
    public void C1(int dy, boolean isStoryPinned) {
        if (dy != 0) {
            ConstraintLayout constraintLayout = Sa().p;
            AbstractC13042fc3.h(constraintLayout, "storyView");
            if (AbstractC14828iY7.i(constraintLayout)) {
                return;
            }
            Sa().p.setVisibility(8);
            return;
        }
        if (isStoryPinned) {
            Sa().p.setVisibility(0);
            return;
        }
        ConstraintLayout constraintLayout2 = Sa().p;
        AbstractC13042fc3.h(constraintLayout2, "storyView");
        if (AbstractC14828iY7.i(constraintLayout2)) {
            return;
        }
        ConstraintLayout constraintLayout3 = Sa().p;
        AbstractC13042fc3.h(constraintLayout3, "storyView");
        wa(this, constraintLayout3, 0L, 1, null);
    }

    @Override // ir.nasim.InterfaceC8506Wg3
    public void C2(boolean isEnable) {
        Sa().h.setUserInputEnabled(isEnable);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0032  */
    @Override // ir.nasim.InterfaceC8506Wg3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void I1() {
        /*
            r3 = this;
            ir.nasim.ly2 r0 = r3.Sa()
            ir.nasim.jaryan.JaryanSwipeToRefresh r0 = r0.o
            ir.nasim.Vt0 r1 = ir.nasim.C8386Vt0.a
            boolean r1 = r1.cb()
            if (r1 != 0) goto L1f
            ir.nasim.ly2 r1 = r3.Sa()
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.p
            java.lang.String r2 = "storyView"
            ir.nasim.AbstractC13042fc3.h(r1, r2)
            boolean r1 = ir.nasim.AbstractC14828iY7.i(r1)
            if (r1 == 0) goto L32
        L1f:
            ir.nasim.ly2 r1 = r3.Sa()
            ir.nasim.components.appbar.view.DrawerToolbar r1 = r1.q
            java.lang.String r2 = "toolbar"
            ir.nasim.AbstractC13042fc3.h(r1, r2)
            boolean r1 = ir.nasim.AbstractC14828iY7.i(r1)
            if (r1 == 0) goto L32
            r1 = 1
            goto L33
        L32:
            r1 = 0
        L33:
            r0.setEnabled(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6614Og3.I1():void");
    }

    @Override // ir.nasim.AbstractC22105ug3
    public void O9() {
        String name;
        Fragment fragmentTa = Ta();
        C14330hk2 c14330hk2 = fragmentTa instanceof C14330hk2 ? (C14330hk2) fragmentTa : null;
        if (c14330hk2 != null) {
            c14330hk2.Ga();
        }
        if (c14330hk2 != null) {
            if (C6614Og3.class.isAnonymousClass()) {
                name = C6614Og3.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C6614Og3.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.g(name, "checkVisiblePlayerAndPlay called inside checkFeedOnTop", new Object[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        C15225jD4.b().a(this, C15225jD4.z);
        C15225jD4.b().a(this, C15225jD4.A);
        C15225jD4.b().a(this, C15225jD4.E);
        Va().Y0();
        Bundle bundleE5 = E5();
        this.isEventBarEnabled = bundleE5 != null ? bundleE5.getBoolean("is_event_bar_enabled_argument", false) : false;
        ConstraintLayout root = C16850ly2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.AbstractC22105ug3
    public void Q9() {
        Fragment fragmentTa = Ta();
        C14330hk2 c14330hk2 = fragmentTa instanceof C14330hk2 ? (C14330hk2) fragmentTa : null;
        if (c14330hk2 != null) {
            c14330hk2.sb();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        C15225jD4.b().e(this, C15225jD4.z);
        C15225jD4.b().e(this, C15225jD4.A);
        C15225jD4.b().e(this, C15225jD4.E);
    }

    public final InterfaceC23238wb0 Ra() {
        InterfaceC23238wb0 interfaceC23238wb0 = this.baseSettingsNavigator;
        if (interfaceC23238wb0 != null) {
            return interfaceC23238wb0;
        }
        AbstractC13042fc3.y("baseSettingsNavigator");
        return null;
    }

    @Override // ir.nasim.InterfaceC23189wV6
    public void U2(String msg) {
        AbstractC13042fc3.i(msg, "msg");
        Ua().o(msg);
    }

    @Override // ir.nasim.InterfaceC23189wV6
    public void W0(String msg, String action, final SA2 retry) {
        AbstractC13042fc3.i(msg, "msg");
        AbstractC13042fc3.i(retry, "retry");
        if (action != null) {
            C17468n10.p(Ua(), msg, new AbstractC13463gG6.a(action, null, false, new SA2() { // from class: ir.nasim.Ig3
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C6614Og3.xb(retry);
                }
            }, 6, null), null, 4, null);
        } else {
            Ua().o(msg);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void W6(boolean hidden) {
        String name;
        super.W6(hidden);
        Fragment fragmentTa = Ta();
        if (!hidden) {
            if (fragmentTa instanceof C14330hk2) {
                ((C14330hk2) fragmentTa).Ga();
            }
            Va().a1();
            C22115uh3.b();
            AQ6 aq6 = this.storyFragment;
            if (aq6 != null) {
                Bundle bundleE5 = E5();
                aq6.oa(bundleE5 != null ? bundleE5.getBoolean("fromTooltip") : false);
                return;
            }
            return;
        }
        if (C6614Og3.class.isAnonymousClass()) {
            name = C6614Og3.class.getName();
            int length = name.length();
            AbstractC13042fc3.f(name);
            if (length > 23) {
                name = name.substring(name.length() - 23, name.length());
                AbstractC13042fc3.h(name, "substring(...)");
            }
        } else {
            name = C6614Og3.class.getSimpleName();
            int length2 = name.length();
            AbstractC13042fc3.f(name);
            if (length2 > 23) {
                name = name.substring(0, 23);
                AbstractC13042fc3.h(name, "substring(...)");
            }
        }
        C19406qI3.b(name, "onHiddenChanged called, current fragment is " + (fragmentTa != null ? fragmentTa.getClass().getName() : null));
        C22115uh3.c(this.lastSelectedTab);
        if ((fragmentTa instanceof C14330hk2 ? (C14330hk2) fragmentTa : null) != null) {
            Q9();
        }
    }

    /* renamed from: Wa, reason: from getter */
    public final EnumC22705vh3 getLastSelectedTab() {
        return this.lastSelectedTab;
    }

    public final JM2 Xa() {
        JM2 jm2 = this.profileNavigator;
        if (jm2 != null) {
            return jm2;
        }
        AbstractC13042fc3.y("profileNavigator");
        return null;
    }

    public final SettingsModule Ya() {
        SettingsModule settingsModule = this.settingsModule;
        if (settingsModule != null) {
            return settingsModule;
        }
        AbstractC13042fc3.y("settingsModule");
        return null;
    }

    /* renamed from: Za, reason: from getter */
    public final List getTabsList() {
        return this.tabsList;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        super.c7();
        C22115uh3.c(this.lastSelectedTab);
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int id, Object... args) {
        AbstractC13042fc3.i(args, "args");
        if (id == C15225jD4.z) {
            Va().u1(false);
            Pa();
            return;
        }
        if (id != C15225jD4.A) {
            if (id == C15225jD4.E) {
                H2();
                return;
            }
            return;
        }
        Object obj = args[0];
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        Object obj2 = args[1];
        AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type kotlin.Boolean");
        this.expandStory = ((Boolean) obj2).booleanValue();
        if (AbstractC13042fc3.d(str, "MARKET")) {
            str = "DISCOVER";
        }
        this.lastSelectedTab = EnumC22705vh3.valueOf(str);
        Va().o1(str);
        Va().Y0();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        C22115uh3.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        if (eb()) {
            F5().s().q(AbstractC12808fC5.arbaeenContainer, new NG()).h();
        } else {
            Sa().b.setVisibility(8);
        }
        if (C8386Vt0.a.cb()) {
            Sa().n.setVisibility(8);
        } else {
            AQ6 aq6 = new AQ6();
            Bundle bundle = new Bundle();
            Bundle bundleE5 = E5();
            bundle.putBoolean("fromTooltip", bundleE5 != null ? bundleE5.getBoolean("fromTooltip") : false);
            aq6.a8(bundle);
            this.storyFragment = aq6;
            F5().s().q(AbstractC12808fC5.storyFragmentContainer, aq6).h();
        }
        Ba();
        za();
        Fa();
        Ka();
        La();
        xa();
        yb();
        TabLayout tabLayout = Sa().g;
        AbstractC13042fc3.h(tabLayout, "jaryanTabLayout");
        tabLayout.setVisibility(8);
        ViewPager2 viewPager2 = Sa().h;
        AbstractC13042fc3.h(viewPager2, "jaryanViewPager");
        viewPager2.setVisibility(8);
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new i(null), 3, null);
        final MenuItem menuItemFindItem = Sa().q.getMenu().findItem(AbstractC12808fC5.dialog_action_mute);
        AbstractC13042fc3.h(menuItemFindItem, "findItem(...)");
        final MenuItem menuItemFindItem2 = Sa().q.getMenu().findItem(AbstractC12808fC5.dialog_action_pin);
        AbstractC13042fc3.h(menuItemFindItem2, "findItem(...)");
        Va().g1().j(p6(), new l(new UA2() { // from class: ir.nasim.Jg3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C6614Og3.lb(this.a, (C23891xh3.d) obj);
            }
        }));
        Va().h1().j(p6(), new l(new UA2() { // from class: ir.nasim.Kg3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C6614Og3.mb(this.a, menuItemFindItem, (C23891xh3.b) obj);
            }
        }));
        Va().i1().j(p6(), new l(new UA2() { // from class: ir.nasim.Lg3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C6614Og3.nb(menuItemFindItem2, this, (C23891xh3.c) obj);
            }
        }));
        Va().e1().j(p6(), new l(new UA2() { // from class: ir.nasim.Mg3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C6614Og3.ob(this.a, ((Integer) obj).intValue());
            }
        }));
        pb();
    }

    @Override // ir.nasim.InterfaceC8506Wg3
    public void o2() {
        Sa().m.setExpanded(true, true);
        Sa().h.setUserInputEnabled(true);
    }

    @Override // ir.nasim.InterfaceC23189wV6
    public Object q1(InterfaceC20295rm1 interfaceC20295rm1) {
        return Va().V0(interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC8506Wg3
    public void t1() {
        AppBarLayout appBarLayout = Sa().m;
        AbstractC13042fc3.h(appBarLayout, "storyAppbar");
        if (AbstractC14828iY7.i(appBarLayout)) {
            return;
        }
        Sa().m.setExpanded(false, false);
    }

    public final void tb(EnumC22705vh3 enumC22705vh3) {
        AbstractC13042fc3.i(enumC22705vh3, "<set-?>");
        this.lastSelectedTab = enumC22705vh3;
    }

    /* renamed from: ir.nasim.Og3$g */
    public static final class g implements TabLayout.d {
        g() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
            View viewE;
            TextView textView = (gVar == null || (viewE = gVar.e()) == null) ? null : (TextView) viewE.findViewById(AbstractC12808fC5.tv_dialog_tab_title);
            if (textView != null) {
                textView.setTextColor(C5495Jo7.a.y2());
            }
            if (textView != null) {
                C6614Og3.this.vb(textView, C5495Jo7.a.y2());
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
            View viewE;
            TextView textView = (gVar == null || (viewE = gVar.e()) == null) ? null : (TextView) viewE.findViewById(AbstractC12808fC5.tv_dialog_tab_title);
            if (textView != null) {
                textView.setTextColor(C5495Jo7.a.z2());
            }
            if (textView != null) {
                C6614Og3.this.vb(textView, C5495Jo7.a.z2());
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }
}
