package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.e;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC23684xL1;
import ir.nasim.AbstractC24274yL1;
import ir.nasim.AbstractC24832zH1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.BB4;
import ir.nasim.C15225jD4;
import ir.nasim.C8899Xu4;
import ir.nasim.GO1;
import ir.nasim.InterfaceC13521gN1;
import ir.nasim.InterfaceC14139hQ1;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC18834pK4;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.TO1;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogFolderAssociationEntity;
import ir.nasim.dialoglist.data.model.DialogDTO;
import ir.nasim.features.root.AbstractC13089g;
import ir.nasim.features.root.C13090h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\bª\u0001´\u0001¾\u0001Â\u0001\b\u0007\u0018\u0000 à\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002á\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\tJ\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\tJ\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\tJ\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\tJ\u0013\u0010\u001a\u001a\u00020\n*\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\tJ\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\tJ\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\tJ\u000f\u0010\u001f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\tJ\u001f\u0010$\u001a\u00020\"2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010)\u001a\u00020\n2\u0006\u0010&\u001a\u00020\"2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u0019\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\n2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\nH\u0016¢\u0006\u0004\b4\u0010\tJ\u000f\u00105\u001a\u00020\nH\u0016¢\u0006\u0004\b5\u0010\tJ\u0019\u00108\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b8\u00109J+\u0010?\u001a\u00020>2\u0006\u0010;\u001a\u00020:2\b\u0010=\u001a\u0004\u0018\u00010<2\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b?\u0010@J!\u0010B\u001a\u00020\n2\u0006\u0010A\u001a\u00020>2\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020\n2\u0006\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\nH\u0016¢\u0006\u0004\bH\u0010\tJ/\u0010M\u001a\u00020\n2\u0006\u0010I\u001a\u00020'2\u0016\u0010L\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010K0J\"\u0004\u0018\u00010KH\u0016¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\nH\u0016¢\u0006\u0004\bO\u0010\tJ\u000f\u0010P\u001a\u00020\nH\u0016¢\u0006\u0004\bP\u0010\tJ\u000f\u0010Q\u001a\u00020\nH\u0016¢\u0006\u0004\bQ\u0010\tJ\u000f\u0010R\u001a\u00020\nH\u0016¢\u0006\u0004\bR\u0010\tJ\u0017\u0010T\u001a\u00020\n2\u0006\u0010S\u001a\u00020'H\u0016¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\nH\u0016¢\u0006\u0004\bV\u0010\tJ\u000f\u0010W\u001a\u00020\nH\u0016¢\u0006\u0004\bW\u0010\tJ\u000f\u0010X\u001a\u00020\nH\u0016¢\u0006\u0004\bX\u0010\tJ\u000f\u0010Y\u001a\u00020\nH\u0016¢\u0006\u0004\bY\u0010\tR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\"\u0010i\u001a\u00020b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010q\u001a\u00020j8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010y\u001a\u00020r8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR$\u0010\u0081\u0001\u001a\u00020z8\u0006@\u0006X\u0087.¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R*\u0010\u0089\u0001\u001a\u00030\u0082\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R*\u0010\u0091\u0001\u001a\u00030\u008a\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R*\u0010\u0099\u0001\u001a\u00030\u0092\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R!\u0010\u009f\u0001\u001a\u00030\u009a\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R!\u0010¤\u0001\u001a\u00030 \u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¡\u0001\u0010\u009c\u0001\u001a\u0006\b¢\u0001\u0010£\u0001R!\u0010©\u0001\u001a\u00030¥\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¦\u0001\u0010\u009c\u0001\u001a\u0006\b§\u0001\u0010¨\u0001R!\u0010®\u0001\u001a\u00030ª\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b«\u0001\u0010\u009c\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R!\u0010³\u0001\u001a\u00030¯\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b°\u0001\u0010\u009c\u0001\u001a\u0006\b±\u0001\u0010²\u0001R!\u0010¸\u0001\u001a\u00030´\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bµ\u0001\u0010\u009c\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R!\u0010½\u0001\u001a\u00030¹\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bº\u0001\u0010\u009c\u0001\u001a\u0006\b»\u0001\u0010¼\u0001R\u0018\u0010Á\u0001\u001a\u00030¾\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R!\u0010Æ\u0001\u001a\u00030Â\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÃ\u0001\u0010\u009c\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001R,\u0010Ì\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\n0Ç\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001R9\u0010Ó\u0001\u001a\u001c\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020'\u0012\u0005\u0012\u00030Î\u0001\u0012\u0004\u0012\u00020\n0Í\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÏ\u0001\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001R&\u0010Ù\u0001\u001a\t\u0012\u0004\u0012\u00020\n0Ô\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÕ\u0001\u0010Ö\u0001\u001a\u0006\b×\u0001\u0010Ø\u0001R,\u0010Ü\u0001\u001a\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\n0Ç\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÚ\u0001\u0010É\u0001\u001a\u0006\bÛ\u0001\u0010Ë\u0001R\u0017\u0010ß\u0001\u001a\u00020Z8BX\u0082\u0004¢\u0006\b\u001a\u0006\bÝ\u0001\u0010Þ\u0001¨\u0006ò\u0001²\u0006\u0010\u0010ã\u0001\u001a\u0005\u0018\u00010â\u00018\nX\u008a\u0084\u0002²\u0006\u000e\u0010å\u0001\u001a\u00030ä\u00018\nX\u008a\u0084\u0002²\u0006\u0015\u0010è\u0001\u001a\n\u0012\u0005\u0012\u00030ç\u00010æ\u00018\nX\u008a\u0084\u0002²\u0006\u000e\u0010ê\u0001\u001a\u00030é\u00018\nX\u008a\u0084\u0002²\u0006\u0015\u0010í\u0001\u001a\n\u0012\u0005\u0012\u00030ì\u00010ë\u00018\nX\u008a\u0084\u0002²\u0006\u0015\u0010è\u0001\u001a\n\u0012\u0005\u0012\u00030ç\u00010æ\u00018\nX\u008a\u0084\u0002²\u0006\r\u0010î\u0001\u001a\u00020'8\nX\u008a\u0084\u0002²\u0006\u000f\u0010ï\u0001\u001a\u0004\u0018\u00010'8\nX\u008a\u0084\u0002²\u0006\u000e\u0010ñ\u0001\u001a\u00030ð\u00018\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/BB4;", "Lir/nasim/ua0;", "Lir/nasim/fQ1;", "Lir/nasim/HI4;", "Lir/nasim/hK4;", "Lir/nasim/jD4$b;", "Lir/nasim/gs2;", "Lir/nasim/XO1;", "<init>", "()V", "Lir/nasim/rB7;", "wa", "ib", "Ba", "Lir/nasim/gj3;", "xa", "()Lir/nasim/gj3;", "ya", "Ca", "Na", "La", "Ma", "Ka", "za", "Ha", "Landroidx/viewpager2/widget/ViewPager2;", "qb", "(Landroidx/viewpager2/widget/ViewPager2;)V", "Ia", "Oa", "Aa", "Ga", "Lir/nasim/d25;", "peer", "", "title", "fb", "(Lir/nasim/d25;Ljava/lang/String;)Ljava/lang/String;", "folderName", "", DialogFolderAssociationEntity.COLUMN_FOLDER_ID, "rb", "(Ljava/lang/String;I)V", "", "fragmentPosition", "Landroidx/fragment/app/Fragment;", "Za", "(J)Landroidx/fragment/app/Fragment;", "Lir/nasim/features/root/g$b;", "mode", "J1", "(Lir/nasim/features/root/g$b;)V", "q5", "j7", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "R6", "id", "", "", "args", "didReceivedNotification", "(I[Ljava/lang/Object;)V", "i0", "A3", "ob", "h5", "storyId", "W1", "(I)V", "T0", "H2", "k7", "T6", "Lir/nasim/Py2;", "h1", "Lir/nasim/Py2;", "_binding", "Lir/nasim/cP1;", "i1", "Lir/nasim/cP1;", "pagerAdapter", "Lir/nasim/wb0;", "j1", "Lir/nasim/wb0;", "Ra", "()Lir/nasim/wb0;", "setBaseSettingsNavigator", "(Lir/nasim/wb0;)V", "baseSettingsNavigator", "Lir/nasim/Vi1;", "k1", "Lir/nasim/Vi1;", "Va", "()Lir/nasim/Vi1;", "setContactsNavigator", "(Lir/nasim/Vi1;)V", "contactsNavigator", "Lir/nasim/nw0;", "l1", "Lir/nasim/nw0;", "Ua", "()Lir/nasim/nw0;", "setCallLogNavigator", "(Lir/nasim/nw0;)V", "callLogNavigator", "Lir/nasim/Pl5;", "m1", "Lir/nasim/Pl5;", "eb", "()Lir/nasim/Pl5;", "setPremiumNavigator", "(Lir/nasim/Pl5;)V", "premiumNavigator", "Lir/nasim/Sg3;", "n1", "Lir/nasim/Sg3;", "bb", "()Lir/nasim/Sg3;", "setJaryanNavigator", "(Lir/nasim/Sg3;)V", "jaryanNavigator", "Lir/nasim/JM2;", "o1", "Lir/nasim/JM2;", "ab", "()Lir/nasim/JM2;", "setGroupProfileNavigator", "(Lir/nasim/JM2;)V", "groupProfileNavigator", "Lir/nasim/TO1$a;", "p1", "Lir/nasim/TO1$a;", "Xa", "()Lir/nasim/TO1$a;", "setDialogListUiActionFactory", "(Lir/nasim/TO1$a;)V", "dialogListUiActionFactory", "Lir/nasim/XB4;", "q1", "Lir/nasim/Yu3;", "hb", "()Lir/nasim/XB4;", "viewModel", "Lir/nasim/Mu0;", "r1", "Ta", "()Lir/nasim/Mu0;", "callBarViewModel", "Lir/nasim/eQ1;", "s1", "cb", "()Lir/nasim/eQ1;", "menuActions", "ir/nasim/BB4$c", "t1", "Qa", "()Lir/nasim/BB4$c;", "appBarActions", "Lir/nasim/KO1;", "u1", "Wa", "()Lir/nasim/KO1;", "dialogListUiAction", "ir/nasim/BB4$q", "v1", "Ya", "()Lir/nasim/BB4$q;", "folderListActions", "Lir/nasim/n10;", "w1", "gb", "()Lir/nasim/n10;", "snackBar", "ir/nasim/BB4$s", "x1", "Lir/nasim/BB4$s;", "onBackPressedCallback", "ir/nasim/BB4$t", "y1", "db", "()Lir/nasim/BB4$t;", "onScrollListener", "Lkotlin/Function1;", "z1", "Lir/nasim/UA2;", "h", "()Lir/nasim/UA2;", "onEditFolderClicked", "Lkotlin/Function3;", "", "A1", "Lir/nasim/kB2;", "p", "()Lir/nasim/kB2;", "onDeleteFolderClicked", "Lkotlin/Function0;", "B1", "Lir/nasim/SA2;", "V0", "()Lir/nasim/SA2;", "onCreateFolderClicked", "C1", "C3", "onAddReservedFolderClicked", "Sa", "()Lir/nasim/Py2;", "binding", "D1", "a", "Lir/nasim/Tx6;", "showShareContentDialog", "Lir/nasim/hQ1;", "appBarUiState", "Lir/nasim/g43;", "Lir/nasim/gN1;", "tabs", "Lir/nasim/Ur2;", "shouldShowFolderBottomSheet", "", "Lir/nasim/Xr2;", "inActiveReservedFolders", "selectedTab", "menuState", "Lir/nasim/mO;", "audioBarState", "dialogList_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class BB4 extends AbstractC15994kX2 implements InterfaceC12930fQ1, HI4, InterfaceC14088hK4, C15225jD4.b, InterfaceC13819gs2, XO1 {

    /* renamed from: D1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A1, reason: from kotlin metadata */
    private final InterfaceC15796kB2 onDeleteFolderClicked;

    /* renamed from: B1, reason: from kotlin metadata */
    private final SA2 onCreateFolderClicked;

    /* renamed from: C1, reason: from kotlin metadata */
    private final UA2 onAddReservedFolderClicked;

    /* renamed from: h1, reason: from kotlin metadata */
    private C7024Py2 _binding;

    /* renamed from: i1, reason: from kotlin metadata */
    private C10905cP1 pagerAdapter;

    /* renamed from: j1, reason: from kotlin metadata */
    public InterfaceC23238wb0 baseSettingsNavigator;

    /* renamed from: k1, reason: from kotlin metadata */
    public InterfaceC8288Vi1 contactsNavigator;

    /* renamed from: l1, reason: from kotlin metadata */
    public InterfaceC18012nw0 callLogNavigator;

    /* renamed from: m1, reason: from kotlin metadata */
    public InterfaceC6900Pl5 premiumNavigator;

    /* renamed from: n1, reason: from kotlin metadata */
    public InterfaceC7565Sg3 jaryanNavigator;

    /* renamed from: o1, reason: from kotlin metadata */
    public JM2 groupProfileNavigator;

    /* renamed from: p1, reason: from kotlin metadata */
    public TO1.a dialogListUiActionFactory;

    /* renamed from: q1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: r1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 callBarViewModel;

    /* renamed from: s1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 menuActions;

    /* renamed from: t1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 appBarActions;

    /* renamed from: u1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 dialogListUiAction;

    /* renamed from: v1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 folderListActions;

    /* renamed from: w1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 snackBar;

    /* renamed from: x1, reason: from kotlin metadata */
    private final s onBackPressedCallback;

    /* renamed from: y1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 onScrollListener;

    /* renamed from: z1, reason: from kotlin metadata */
    private final UA2 onEditFolderClicked;

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
            return (hVar == null || (cVarN3 = hVar.n3()) == null) ? this.e.n3() : cVarN3;
        }
    }

    /* renamed from: ir.nasim.BB4$a, reason: case insensitive filesystem and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final BB4 a(Boolean bool) {
            BB4 bb4 = new BB4();
            if (bool != null) {
                bb4.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("is_event_bar_enabled_argument", bool)));
            }
            return bb4;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.BB4$b, reason: case insensitive filesystem */
    public /* synthetic */ class C3470b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.BOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ExPeerType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ExPeerType.THREAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.BB4$c, reason: case insensitive filesystem */
    public static final class C3471c implements InterfaceC24868zL1, InterfaceC12930fQ1, HI4, InterfaceC12321eQ1 {
        private final /* synthetic */ BB4 b;
        private final /* synthetic */ InterfaceC12321eQ1 c;

        C3471c() {
            this.b = BB4.this;
            this.c = BB4.this.cb();
        }

        @Override // ir.nasim.InterfaceC12930fQ1
        public void A3() {
            BB4.this.A3();
        }

        @Override // ir.nasim.HI4
        public void T0() {
            this.b.T0();
        }

        @Override // ir.nasim.HI4
        public void W1(int i) {
            this.b.W1(i);
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 a() {
            return this.c.a();
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 b() {
            return this.c.b();
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 c() {
            return this.c.c();
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public UA2 d() {
            return this.c.d();
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 e() {
            return this.c.e();
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 f() {
            return this.c.f();
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public UA2 g() {
            return this.c.g();
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public UA2 h() {
            return this.c.h();
        }

        @Override // ir.nasim.InterfaceC12930fQ1
        public void h5() {
            BB4.this.h5();
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 i() {
            return this.c.i();
        }

        @Override // ir.nasim.InterfaceC12930fQ1
        public void i0() {
            BB4.this.i0();
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public UA2 j() {
            return this.c.j();
        }

        @Override // ir.nasim.InterfaceC12321eQ1
        public SA2 k() {
            return this.c.k();
        }
    }

    /* renamed from: ir.nasim.BB4$d, reason: case insensitive filesystem */
    static final class C3472d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.BB4$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ BB4 d;

            /* renamed from: ir.nasim.BB4$d$a$a, reason: collision with other inner class name */
            static final class C0275a implements InterfaceC15796kB2 {
                final /* synthetic */ BB4 a;
                final /* synthetic */ long b;

                /* renamed from: ir.nasim.BB4$d$a$a$a, reason: collision with other inner class name */
                static final class C0276a implements InterfaceC14603iB2 {
                    final /* synthetic */ BB4 a;

                    C0276a(BB4 bb4) {
                        this.a = bb4;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        String strH6 = this.a.h6(AbstractC12217eE5.premium_success);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        AbstractC19555qZ.B0(strH6, interfaceC22053ub1, 0);
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.BB4$d$a$a$b */
                static final class b implements InterfaceC14603iB2 {
                    final /* synthetic */ BB4 a;
                    final /* synthetic */ long b;

                    b(BB4 bb4, long j) {
                        this.a = bb4;
                        this.b = j;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        String strI6 = this.a.i6(AbstractC12217eE5.premium_success_desc, XY6.v(String.valueOf(this.b)));
                        AbstractC13042fc3.h(strI6, "getString(...)");
                        AbstractC19555qZ.e0(strI6, interfaceC22053ub1, 0);
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                C0275a(BB4 bb4, long j) {
                    this.a = bb4;
                    this.b = j;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 d(Dialog dialog, BB4 bb4) {
                    AbstractC13042fc3.i(dialog, "$it");
                    AbstractC13042fc3.i(bb4, "this$0");
                    dialog.dismiss();
                    C22042ua0.A9(bb4, bb4.Ra().b(), false, null, 6, null);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 f(Dialog dialog) {
                    AbstractC13042fc3.i(dialog, "$it");
                    dialog.dismiss();
                    return C19938rB7.a;
                }

                public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(dialog, "it");
                    AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
                    AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
                    InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
                    String strC = UY6.c(AbstractC12217eE5.premium_success_btn_change, interfaceC22053ub1, 0);
                    InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                    String strC2 = UY6.c(AbstractC12217eE5.gift_dialogs_back, interfaceC22053ub1, 0);
                    InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1278199435, true, new C0276a(this.a), interfaceC22053ub1, 54);
                    InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1080826057, true, new b(this.a, this.b), interfaceC22053ub1, 54);
                    interfaceC22053ub1.W(-2070196909);
                    boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.V(this.a);
                    final BB4 bb4 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.CB4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return BB4.C3472d.a.C0275a.d(dialog, bb4);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa2 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(-2070182349);
                    boolean zD2 = interfaceC22053ub1.D(dialog);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.DB4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return BB4.C3472d.a.C0275a.f(dialog);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC19555qZ.F(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, aVar, sa2, strC, c1454b, (SA2) objB2, strC2, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.BB4$d$a$b */
            static final class b implements InterfaceC15796kB2 {
                final /* synthetic */ BB4 a;

                /* renamed from: ir.nasim.BB4$d$a$b$a, reason: collision with other inner class name */
                static final class C0277a implements InterfaceC14603iB2 {
                    final /* synthetic */ BB4 a;

                    C0277a(BB4 bb4) {
                        this.a = bb4;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        String strH6 = this.a.h6(AbstractC12217eE5.premium_failed_tr);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        AbstractC19555qZ.B0(strH6, interfaceC22053ub1, 0);
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.BB4$d$a$b$b, reason: collision with other inner class name */
                static final class C0278b implements InterfaceC14603iB2 {
                    final /* synthetic */ BB4 a;

                    C0278b(BB4 bb4) {
                        this.a = bb4;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        String strH6 = this.a.h6(AbstractC12217eE5.premium_failed_tr_body);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        AbstractC19555qZ.e0(strH6, interfaceC22053ub1, 0);
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                b(BB4 bb4) {
                    this.a = bb4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(Dialog dialog) {
                    AbstractC13042fc3.i(dialog, "$it");
                    dialog.dismiss();
                    return C19938rB7.a;
                }

                public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(dialog, "it");
                    InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1771594080, true, new C0277a(this.a), interfaceC22053ub1, 54);
                    AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
                    InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-1804544542, true, new C0278b(this.a), interfaceC22053ub1, 54);
                    AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
                    InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
                    interfaceC22053ub1.W(-873807340);
                    boolean zD = interfaceC22053ub1.D(dialog);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.EB4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return BB4.C3472d.a.b.c(dialog);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC19555qZ.T(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, null, aVar, (SA2) objB, UY6.c(AbstractC12217eE5.dialog_positive_button_i_got_it, interfaceC22053ub1, 0), interfaceC22053ub1, (InterfaceC19114po0.b.a.b << 15) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 16);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.BB4$d$a$c */
            static final class c implements InterfaceC15796kB2 {
                final /* synthetic */ BB4 a;

                /* renamed from: ir.nasim.BB4$d$a$c$a, reason: collision with other inner class name */
                static final class C0279a implements InterfaceC14603iB2 {
                    final /* synthetic */ BB4 a;

                    C0279a(BB4 bb4) {
                        this.a = bb4;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        String strH6 = this.a.h6(AbstractC12217eE5.premium_unknown_tr);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        AbstractC19555qZ.B0(strH6, interfaceC22053ub1, 0);
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.BB4$d$a$c$b */
                static final class b implements InterfaceC14603iB2 {
                    final /* synthetic */ BB4 a;

                    b(BB4 bb4) {
                        this.a = bb4;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        String strH6 = this.a.h6(AbstractC12217eE5.premium_unknown_tr_body);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        AbstractC19555qZ.e0(strH6, interfaceC22053ub1, 0);
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                c(BB4 bb4) {
                    this.a = bb4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(Dialog dialog) {
                    AbstractC13042fc3.i(dialog, "$it");
                    dialog.dismiss();
                    return C19938rB7.a;
                }

                public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(dialog, "it");
                    InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-2075257631, true, new C0279a(this.a), interfaceC22053ub1, 54);
                    AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
                    InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-1356428957, true, new b(this.a), interfaceC22053ub1, 54);
                    AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
                    InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
                    interfaceC22053ub1.W(-873779884);
                    boolean zD = interfaceC22053ub1.D(dialog);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.FB4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return BB4.C3472d.a.c.c(dialog);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC19555qZ.T(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, null, aVar, (SA2) objB, UY6.c(AbstractC12217eE5.dialog_positive_button_i_got_it, interfaceC22053ub1, 0), interfaceC22053ub1, (InterfaceC19114po0.b.a.b << 15) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 16);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(BB4 bb4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = bb4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C17019mF7 c17019mF7 = (C17019mF7) this.c;
                    if (!c17019mF7.c()) {
                        if (c17019mF7.a()) {
                            Context contextS7 = this.d.S7();
                            AbstractC13042fc3.h(contextS7, "requireContext(...)");
                            InterfaceC18633oz3 interfaceC18633oz3P6 = this.d.p6();
                            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
                            AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(598756113, true, new b(this.d)), 4, null).show();
                        } else if (c17019mF7.b()) {
                            Context contextS72 = this.d.S7();
                            AbstractC13042fc3.h(contextS72, "requireContext(...)");
                            InterfaceC18633oz3 interfaceC18633oz3P62 = this.d.p6();
                            AbstractC13042fc3.h(interfaceC18633oz3P62, "getViewLifecycleOwner(...)");
                            AbstractC21375tZ.c(contextS72, interfaceC18633oz3P62, null, AbstractC19242q11.c(1046871698, true, new c(this.d)), 4, null).show();
                        }
                        return C19938rB7.a;
                    }
                    XB4 xb4Hb = this.d.hb();
                    this.b = 1;
                    obj = xb4Hb.O2(this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                if (((Long) obj) != null) {
                    BB4 bb4 = this.d;
                    long jCeil = (long) Math.ceil(AbstractC23053wG5.f(r14.longValue() - (AbstractC20507s76.o() / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT), 0L) / 86400);
                    Context contextS73 = bb4.S7();
                    AbstractC13042fc3.h(contextS73, "requireContext(...)");
                    InterfaceC18633oz3 interfaceC18633oz3P63 = bb4.p6();
                    AbstractC13042fc3.h(interfaceC18633oz3P63, "getViewLifecycleOwner(...)");
                    AbstractC21375tZ.c(contextS73, interfaceC18633oz3P63, null, AbstractC19242q11.c(-107006489, true, new C0275a(bb4, jCeil)), 4, null).show();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C17019mF7 c17019mF7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c17019mF7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C3472d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return BB4.this.new C3472d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2S2 = BB4.this.hb().s2();
                a aVar = new a(BB4.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2S2, aVar, this) == objE) {
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
            return ((C3472d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.BB4$e, reason: case insensitive filesystem */
    static final class C3473e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.BB4$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ BB4 c;

            /* renamed from: ir.nasim.BB4$e$a$a, reason: collision with other inner class name */
            static final class C0280a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ BB4 d;

                /* renamed from: ir.nasim.BB4$e$a$a$a, reason: collision with other inner class name */
                static final class C0281a implements InterfaceC15796kB2 {
                    final /* synthetic */ AbstractC24832zH1 a;
                    final /* synthetic */ XV4 b;
                    final /* synthetic */ BB4 c;

                    C0281a(AbstractC24832zH1 abstractC24832zH1, XV4 xv4, BB4 bb4) {
                        this.a = abstractC24832zH1;
                        this.b = xv4;
                        this.c = bb4;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 d(boolean z, BB4 bb4, AbstractC24832zH1 abstractC24832zH1, Dialog dialog, boolean z2) {
                        AbstractC13042fc3.i(bb4, "this$0");
                        AbstractC13042fc3.i(abstractC24832zH1, "$it");
                        AbstractC13042fc3.i(dialog, "$dialog");
                        if (z2 && z) {
                            bb4.hb().I1(((AbstractC24832zH1.b) abstractC24832zH1).c());
                        }
                        bb4.hb().U1();
                        bb4.hb().N1();
                        bb4.hb().V1();
                        dialog.dismiss();
                        return C19938rB7.a;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 f(BB4 bb4, Dialog dialog) {
                        AbstractC13042fc3.i(bb4, "this$0");
                        AbstractC13042fc3.i(dialog, "$dialog");
                        bb4.hb().V1();
                        dialog.dismiss();
                        return C19938rB7.a;
                    }

                    public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(dialog, "dialog");
                        final boolean z = this.a instanceof AbstractC24832zH1.b;
                        String str = (String) this.b.e();
                        String str2 = (String) this.b.f();
                        interfaceC22053ub1.W(-1696858639);
                        boolean zA = interfaceC22053ub1.a(z) | interfaceC22053ub1.V(this.c) | interfaceC22053ub1.V(this.a) | interfaceC22053ub1.D(dialog);
                        final BB4 bb4 = this.c;
                        final AbstractC24832zH1 abstractC24832zH1 = this.a;
                        Object objB = interfaceC22053ub1.B();
                        if (zA || objB == InterfaceC22053ub1.a.a()) {
                            objB = new UA2() { // from class: ir.nasim.HB4
                                @Override // ir.nasim.UA2
                                public final Object invoke(Object obj) {
                                    return BB4.C3473e.a.C0280a.C0281a.d(z, bb4, abstractC24832zH1, dialog, ((Boolean) obj).booleanValue());
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        UA2 ua2 = (UA2) objB;
                        interfaceC22053ub1.Q();
                        interfaceC22053ub1.W(-1696842231);
                        boolean zV = interfaceC22053ub1.V(this.c) | interfaceC22053ub1.D(dialog);
                        final BB4 bb42 = this.c;
                        Object objB2 = interfaceC22053ub1.B();
                        if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                            objB2 = new SA2() { // from class: ir.nasim.IB4
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return BB4.C3473e.a.C0280a.C0281a.f(bb42, dialog);
                                }
                            };
                            interfaceC22053ub1.s(objB2);
                        }
                        SA2 sa2 = (SA2) objB2;
                        interfaceC22053ub1.Q();
                        String strH6 = this.c.h6(AbstractC12217eE5.dialogs_menu_conversation_delete);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        String strH62 = this.c.h6(AbstractC12217eE5.dialog_cancel);
                        AbstractC13042fc3.h(strH62, "getString(...)");
                        AbstractC23648xH1.c(str, str2, z, ua2, sa2, strH6, strH62, interfaceC22053ub1, 0);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0280a(BB4 bb4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bb4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void y(BB4 bb4, DialogInterface dialogInterface) {
                    bb4.hb().V1();
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0280a c0280a = new C0280a(this.d, interfaceC20295rm1);
                    c0280a.c = obj;
                    return c0280a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    AbstractC24832zH1 abstractC24832zH1 = (AbstractC24832zH1) this.c;
                    Resources resourcesB6 = this.d.b6();
                    AbstractC13042fc3.h(resourcesB6, "getResources(...)");
                    XV4 xv4A = AH1.a(abstractC24832zH1, resourcesB6);
                    Context contextS7 = this.d.S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    BB4 bb4 = this.d;
                    Dialog dialogC = AbstractC21375tZ.c(contextS7, bb4, null, AbstractC19242q11.c(-543699656, true, new C0281a(abstractC24832zH1, xv4A, bb4)), 4, null);
                    final BB4 bb42 = this.d;
                    dialogC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.nasim.GB4
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            BB4.C3473e.a.C0280a.y(bb42, dialogInterface);
                        }
                    });
                    dialogC.show();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                public final Object invoke(AbstractC24832zH1 abstractC24832zH1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0280a) create(abstractC24832zH1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(BB4 bb4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = bb4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(this.c.hb().f2());
                    C0280a c0280a = new C0280a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2F, c0280a, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.BB4$e$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ BB4 c;

            /* renamed from: ir.nasim.BB4$e$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ BB4 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(BB4 bb4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bb4;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(this.d, interfaceC20295rm1);
                    aVar.c = obj;
                    return aVar;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) throws Resources.NotFoundException {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    VF6 vf6 = (VF6) this.c;
                    Resources resourcesB6 = this.d.b6();
                    AbstractC13042fc3.h(resourcesB6, "getResources(...)");
                    C14054hG6 c14054hG6A = AbstractC12236eG6.a(vf6, resourcesB6);
                    this.d.gb().m(c14054hG6A.a() instanceof AbstractC13463gG6.a ? 5000 : 0);
                    this.d.gb().n(c14054hG6A.b(), c14054hG6A.a(), vf6.c());
                    this.d.hb().n3();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(VF6 vf6, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(vf6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(BB4 bb4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = bb4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2F = AbstractC6459Nq2.F(this.c.hb().y2());
                    a aVar = new a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2F, aVar, this) == objE) {
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
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C3473e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C3473e c3473e = BB4.this.new C3473e(interfaceC20295rm1);
            c3473e.c = obj;
            return c3473e;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(BB4.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(BB4.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C3473e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ BB4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(BB4 bb4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = bb4;
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
                this.d.onBackPressedCallback.j(this.c);
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return BB4.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2I2 = BB4.this.hb().I2();
                a aVar = new a(BB4.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2I2, aVar, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g implements InterfaceC14603iB2 {

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ BB4 a;

            a(BB4 bb4) {
                this.a = bb4;
            }

            private static final InterfaceC14139hQ1 b(InterfaceC9664aL6 interfaceC9664aL6) {
                return (InterfaceC14139hQ1) interfaceC9664aL6.getValue();
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    DQ1.H(b(AbstractC5976Lq2.c(this.a.hb().Z(), null, null, null, interfaceC22053ub1, 0, 7)), this.a.Qa(), null, interfaceC22053ub1, 0, 4);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        g() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(2102048850, true, new a(BB4.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class h implements InterfaceC14603iB2 {

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ BB4 a;
            final /* synthetic */ InterfaceC9664aL6 b;
            final /* synthetic */ InterfaceC9664aL6 c;
            final /* synthetic */ InterfaceC9664aL6 d;

            a(BB4 bb4, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63) {
                this.a = bb4;
                this.b = interfaceC9664aL6;
                this.c = interfaceC9664aL62;
                this.d = interfaceC9664aL63;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(BB4 bb4) {
                AbstractC13042fc3.i(bb4, "this$0");
                bb4.hb().x3(false);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(BB4 bb4) {
                AbstractC13042fc3.i(bb4, "this$0");
                bb4.hb().w3(false);
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C8136Ur2 c8136Ur2H = h.h(this.b);
                InterfaceC13346g43 interfaceC13346g43F = h.f(this.c);
                KO1 ko1Wa = this.a.Wa();
                q qVarYa = this.a.Ya();
                List listI = h.i(this.d);
                interfaceC22053ub1.W(-1531752671);
                boolean zV = interfaceC22053ub1.V(this.a);
                final BB4 bb4 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.JB4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return BB4.h.a.d(bb4);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa2 = (SA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-1531757185);
                boolean zV2 = interfaceC22053ub1.V(this.a);
                final BB4 bb42 = this.a;
                Object objB2 = interfaceC22053ub1.B();
                if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.KB4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return BB4.h.a.f(bb42);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC9388Zs2.b(c8136Ur2H, interfaceC13346g43F, ko1Wa, qVarYa, listI, sa2, (SA2) objB2, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC13346g43 f(InterfaceC9664aL6 interfaceC9664aL6) {
            return (InterfaceC13346g43) interfaceC9664aL6.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C8136Ur2 h(InterfaceC9664aL6 interfaceC9664aL6) {
            return (C8136Ur2) interfaceC9664aL6.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List i(InterfaceC9664aL6 interfaceC9664aL6) {
            return (List) interfaceC9664aL6.getValue();
        }

        public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(BB4.this.hb().A2(), null, null, null, interfaceC22053ub1, 0, 7);
            M10.f(false, AbstractC19242q11.e(-38636066, true, new a(BB4.this, AbstractC5976Lq2.c(BB4.this.hb().x2(), null, null, null, interfaceC22053ub1, 0, 7), interfaceC9664aL6C, AbstractC5976Lq2.c(BB4.this.hb().l2(), null, null, null, interfaceC22053ub1, 0, 7)), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class i implements InterfaceC14603iB2 {

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ BB4 a;

            a(BB4 bb4) {
                this.a = bb4;
            }

            private static final C7960Tx6 h(InterfaceC9664aL6 interfaceC9664aL6) {
                return (C7960Tx6) interfaceC9664aL6.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final String i(BB4 bb4, C11458d25 c11458d25, String str) {
                AbstractC13042fc3.i(bb4, "this$0");
                AbstractC13042fc3.i(c11458d25, "peer");
                AbstractC13042fc3.i(str, "title");
                return bb4.fb(c11458d25, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final String k(String str, ExPeerType exPeerType) {
                AbstractC13042fc3.i(str, "$deniedBodyText");
                AbstractC13042fc3.i(exPeerType, "exType");
                String strA = AbstractC5969Lp4.a(str, exPeerType == ExPeerType.GROUP ? ZN2.GROUP : ZN2.CHANNEL);
                AbstractC13042fc3.h(strA, "formatGroupType(...)");
                return strA;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(BB4 bb4, C11458d25 c11458d25, String str) {
                AbstractC13042fc3.i(bb4, "this$0");
                AbstractC13042fc3.i(c11458d25, "peer");
                AbstractC13042fc3.i(str, "<unused var>");
                C18987pb3.x1(C18987pb3.a, c11458d25, null, null, false, null, null, false, null, null, false, null, 2046, null);
                bb4.hb().G0(null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(BB4 bb4) {
                AbstractC13042fc3.i(bb4, "this$0");
                bb4.hb().G0(null);
                return C19938rB7.a;
            }

            public final void f(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(this.a.hb().w2(), null, null, null, interfaceC22053ub1, 0, 7);
                if (h(interfaceC9664aL6C) == null) {
                    return;
                }
                final BB4 bb4 = this.a;
                final String strC = UY6.c(FD5.send_message_access_is_denied_in_this_group, interfaceC22053ub1, 0);
                C7960Tx6 c7960Tx6H = h(interfaceC9664aL6C);
                interfaceC22053ub1.W(1117174662);
                boolean zV = interfaceC22053ub1.V(bb4);
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new InterfaceC14603iB2() { // from class: ir.nasim.LB4
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return BB4.i.a.i(bb4, (C11458d25) obj, (String) obj2);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1117179639);
                boolean zV2 = interfaceC22053ub1.V(strC);
                Object objB2 = interfaceC22053ub1.B();
                if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.MB4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return BB4.i.a.k(strC, (ExPeerType) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua2 = (UA2) objB2;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1117189755);
                boolean zV3 = interfaceC22053ub1.V(bb4);
                Object objB3 = interfaceC22053ub1.B();
                if (zV3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new InterfaceC14603iB2() { // from class: ir.nasim.NB4
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return BB4.i.a.n(bb4, (C11458d25) obj, (String) obj2);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                InterfaceC14603iB2 interfaceC14603iB22 = (InterfaceC14603iB2) objB3;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1117195957);
                boolean zV4 = interfaceC22053ub1.V(bb4);
                Object objB4 = interfaceC22053ub1.B();
                if (zV4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.OB4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return BB4.i.a.o(bb4);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                AbstractC7721Sx6.b(c7960Tx6H, interfaceC14603iB2, ua2, interfaceC14603iB22, (SA2) objB4, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                f((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        i() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(431196390, true, new a(BB4.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ BB4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(BB4 bb4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = bb4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                EnumC23487x03 enumC23487x03;
                int i;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC13521gN1 interfaceC13521gN1 = (InterfaceC13521gN1) this.c;
                this.d.Ma();
                FloatingActionButton floatingActionButton = this.d.Sa().h;
                Context contextS7 = this.d.S7();
                boolean z = interfaceC13521gN1 instanceof InterfaceC13521gN1.a;
                if (z) {
                    enumC23487x03 = EnumC23487x03.z;
                } else {
                    if (!(interfaceC13521gN1 instanceof InterfaceC13521gN1.b) && !AbstractC13042fc3.d(interfaceC13521gN1, InterfaceC13521gN1.c.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    enumC23487x03 = EnumC23487x03.A;
                }
                floatingActionButton.setImageDrawable(AbstractC9594aE.b(contextS7, enumC23487x03.j()));
                FloatingActionButton floatingActionButton2 = this.d.Sa().h;
                Context context = this.d.Sa().j.getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                floatingActionButton2.setColorFilter(OY0.b(context, AbstractC13408gA5.colorOnPrimary), PorterDuff.Mode.SRC_IN);
                FloatingActionButton floatingActionButton3 = this.d.Sa().h;
                Context contextS72 = this.d.S7();
                if (z) {
                    i = FD5.call_logs_fragment_fab_content_description;
                } else if (interfaceC13521gN1 instanceof InterfaceC13521gN1.b) {
                    i = FD5.dialogs_fragment_fab_content_description;
                } else {
                    if (!AbstractC13042fc3.d(interfaceC13521gN1, InterfaceC13521gN1.c.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i = FD5.call_logs_fragment_fab_content_description;
                }
                floatingActionButton3.setContentDescription(contextS72.getString(i));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC13521gN1 interfaceC13521gN1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC13521gN1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return BB4.this.new j(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6Y1 = BB4.this.hb().Y1();
                a aVar = new a(BB4.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6Y1, aVar, this) == objE) {
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

    static final class k implements InterfaceC14603iB2 {

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ BB4 a;

            /* renamed from: ir.nasim.BB4$k$a$a, reason: collision with other inner class name */
            /* synthetic */ class C0282a extends EB2 implements UA2 {
                C0282a(Object obj) {
                    super(1, obj, XB4.class, "onMenuClick", "onMenuClick(I)V", 0);
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    y(((Number) obj).intValue());
                    return C19938rB7.a;
                }

                public final void y(int i) {
                    ((XB4) this.receiver).d3(i);
                }
            }

            /* synthetic */ class b extends EB2 implements SA2 {
                b(Object obj) {
                    super(0, obj, XB4.class, "onMenuDismiss", "onMenuDismiss()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((XB4) this.receiver).e3();
                }
            }

            a(BB4 bb4) {
                this.a = bb4;
            }

            private static final InterfaceC13346g43 d(InterfaceC9664aL6 interfaceC9664aL6) {
                return (InterfaceC13346g43) interfaceC9664aL6.getValue();
            }

            private static final int f(InterfaceC9664aL6 interfaceC9664aL6) {
                return ((Number) interfaceC9664aL6.getValue()).intValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(BB4 bb4, InterfaceC9664aL6 interfaceC9664aL6) {
                AbstractC13042fc3.i(bb4, "this$0");
                AbstractC13042fc3.i(interfaceC9664aL6, "$audioBarState$delegate");
                VL vlB = n(interfaceC9664aL6).b();
                if (vlB != null) {
                    bb4.Wa().j().invoke(vlB);
                }
                return C19938rB7.a;
            }

            private static final Integer i(InterfaceC9664aL6 interfaceC9664aL6) {
                return (Integer) interfaceC9664aL6.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(BB4 bb4, int i) {
                AbstractC13042fc3.i(bb4, "this$0");
                bb4.Sa().n.setCurrentItem(i, true);
                return C19938rB7.a;
            }

            private static final C17092mO n(InterfaceC9664aL6 interfaceC9664aL6) {
                return (C17092mO) interfaceC9664aL6.getValue();
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final BB4 bb4 = this.a;
                e.a aVar = androidx.compose.ui.e.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
                InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar2.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                AbstractC23412ws4.b(bb4.Wa().d(), bb4.Wa().i(), bb4.Ta().W0(), interfaceC22053ub1, 0);
                InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(bb4.hb().A2(), null, null, null, interfaceC22053ub1, 0, 7);
                InterfaceC9664aL6 interfaceC9664aL6C2 = AbstractC5976Lq2.c(bb4.hb().v2(), null, null, null, interfaceC22053ub1, 0, 7);
                interfaceC22053ub1.W(-278561898);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar3 = InterfaceC22053ub1.a;
                if (objB == aVar3.a()) {
                    objB = bb4.hb().i2();
                    interfaceC22053ub1.s(objB);
                }
                InterfaceC9664aL6 interfaceC9664aL6 = (InterfaceC9664aL6) objB;
                interfaceC22053ub1.Q();
                InterfaceC13346g43 interfaceC13346g43D = d(interfaceC9664aL6C);
                int iF = f(interfaceC9664aL6C2);
                Object objHb = bb4.hb();
                interfaceC22053ub1.W(-278551322);
                boolean zD = interfaceC22053ub1.D(objHb);
                Object objB2 = interfaceC22053ub1.B();
                if (zD || objB2 == aVar3.a()) {
                    objB2 = new C0282a(objHb);
                    interfaceC22053ub1.s(objB2);
                }
                InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB2;
                interfaceC22053ub1.Q();
                SA2 sa2K = bb4.Qa().k();
                Object objHb2 = bb4.hb();
                interfaceC22053ub1.W(-278546776);
                boolean zD2 = interfaceC22053ub1.D(objHb2);
                Object objB3 = interfaceC22053ub1.B();
                if (zD2 || objB3 == aVar3.a()) {
                    objB3 = new b(objHb2);
                    interfaceC22053ub1.s(objB3);
                }
                InterfaceC16733lm3 interfaceC16733lm32 = (InterfaceC16733lm3) objB3;
                interfaceC22053ub1.Q();
                q qVarYa = bb4.Ya();
                Integer numI = i(interfaceC9664aL6);
                interfaceC22053ub1.W(-278555446);
                boolean zV = interfaceC22053ub1.V(bb4);
                Object objB4 = interfaceC22053ub1.B();
                if (zV || objB4 == aVar3.a()) {
                    objB4 = new UA2() { // from class: ir.nasim.PB4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return BB4.k.a.k(bb4, ((Integer) obj).intValue());
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                AbstractC23693xM1.F(interfaceC13346g43D, iF, (UA2) objB4, (UA2) interfaceC16733lm3, sa2K, (SA2) interfaceC16733lm32, 0.0f, 0.0f, numI, qVarYa, interfaceC22053ub1, 0, 192);
                final InterfaceC9664aL6 interfaceC9664aL6C3 = AbstractC5976Lq2.c(bb4.hb().d2(), null, null, null, interfaceC22053ub1, 0, 7);
                C22505vM c22505vMA = n(interfaceC9664aL6C3).a();
                KA7 ka7D = c22505vMA != null ? DL1.a.d(c22505vMA) : null;
                interfaceC22053ub1.W(-278534619);
                boolean zV2 = interfaceC22053ub1.V(interfaceC9664aL6C3) | interfaceC22053ub1.V(bb4);
                Object objB5 = interfaceC22053ub1.B();
                if (zV2 || objB5 == aVar3.a()) {
                    objB5 = new SA2() { // from class: ir.nasim.QB4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return BB4.k.a.h(bb4, interfaceC9664aL6C3);
                        }
                    };
                    interfaceC22053ub1.s(objB5);
                }
                interfaceC22053ub1.Q();
                CL1.b(ka7D, (SA2) objB5, bb4.Wa().g(), bb4.Wa().k(), bb4.Wa().f(), null, interfaceC22053ub1, KA7.d, 32);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        k() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(1201226707, true, new a(BB4.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC10258bL6 e;
        final /* synthetic */ InterfaceC10258bL6 f;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC10258bL6 c;
            final /* synthetic */ InterfaceC10258bL6 d;
            final /* synthetic */ BB4 e;

            /* renamed from: ir.nasim.BB4$l$a$a, reason: collision with other inner class name */
            static final class C0283a extends AbstractC19859r37 implements InterfaceC15796kB2 {
                int b;
                /* synthetic */ Object c;
                /* synthetic */ Object d;

                C0283a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(3, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return AbstractC6392Nk0.a(((GO1.b) this.d).h((InterfaceC13521gN1) this.c));
                }

                @Override // ir.nasim.InterfaceC15796kB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object q(InterfaceC13521gN1 interfaceC13521gN1, GO1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0283a c0283a = new C0283a(interfaceC20295rm1);
                    c0283a.c = interfaceC13521gN1;
                    c0283a.d = bVar;
                    return c0283a.invokeSuspend(C19938rB7.a);
                }
            }

            static final class b implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC10258bL6 a;
                final /* synthetic */ InterfaceC10258bL6 b;
                final /* synthetic */ BB4 c;

                b(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, BB4 bb4) {
                    this.a = interfaceC10258bL6;
                    this.b = interfaceC10258bL62;
                    this.c = bb4;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return b(((Boolean) obj).booleanValue(), interfaceC20295rm1);
                }

                public final Object b(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                    if (((GO1.b) this.a.getValue()).h((InterfaceC13521gN1) this.b.getValue())) {
                        this.c.Wa().c().invoke(new GO1.a.b(new InterfaceC18834pK4.f(EO1.z((InterfaceC13521gN1) this.b.getValue()))));
                    }
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, BB4 bb4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC10258bL6;
                this.d = interfaceC10258bL62;
                this.e = bb4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.p(this.c, this.d, new C0283a(null)));
                    b bVar = new b(this.d, this.c, this.e);
                    this.b = 1;
                    if (interfaceC4557Fq2V.b(bVar, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC10258bL6 c;
            final /* synthetic */ InterfaceC10258bL6 d;
            final /* synthetic */ BB4 e;

            static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
                int b;
                /* synthetic */ Object c;

                a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(3, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    C23564x80 c23564x80A;
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    AbstractC24274yL1 abstractC24274yL1A = ((GO1.b) this.c).a();
                    AbstractC24274yL1.b.a aVar = abstractC24274yL1A instanceof AbstractC24274yL1.b.a ? (AbstractC24274yL1.b.a) abstractC24274yL1A : null;
                    if (aVar == null || (c23564x80A = aVar.a()) == null) {
                        return null;
                    }
                    return AbstractC6392Nk0.d(c23564x80A.a());
                }

                @Override // ir.nasim.InterfaceC15796kB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object q(InterfaceC13521gN1 interfaceC13521gN1, GO1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(interfaceC20295rm1);
                    aVar.c = bVar;
                    return aVar.invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.BB4$l$b$b, reason: collision with other inner class name */
            static final class C0284b implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC10258bL6 a;
                final /* synthetic */ InterfaceC10258bL6 b;
                final /* synthetic */ BB4 c;

                C0284b(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, BB4 bb4) {
                    this.a = interfaceC10258bL6;
                    this.b = interfaceC10258bL62;
                    this.c = bb4;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(Integer num, InterfaceC20295rm1 interfaceC20295rm1) {
                    if (num != null && ((GO1.b) this.a.getValue()).d((InterfaceC13521gN1) this.b.getValue())) {
                        this.c.Wa().c().invoke(new GO1.a.C0389a(AbstractC23684xL1.e.b));
                    }
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, BB4 bb4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC10258bL6;
                this.d = interfaceC10258bL62;
                this.e = bb4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.p(this.c, this.d, new a(null)));
                    C0284b c0284b = new C0284b(this.d, this.c, this.e);
                    this.b = 1;
                    if (interfaceC4557Fq2V.b(c0284b, this) == objE) {
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
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC10258bL6 c;
            final /* synthetic */ InterfaceC10258bL6 d;
            final /* synthetic */ BB4 e;

            static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
                int b;
                /* synthetic */ Object c;

                a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(3, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    String strB;
                    C17103mP1 c17103mP1C;
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    AbstractC24274yL1 abstractC24274yL1A = ((GO1.b) this.c).a();
                    AbstractC24274yL1.b.C1786b c1786b = abstractC24274yL1A instanceof AbstractC24274yL1.b.C1786b ? (AbstractC24274yL1.b.C1786b) abstractC24274yL1A : null;
                    if (c1786b == null || (c17103mP1C = c1786b.c()) == null || (strB = c17103mP1C.b()) == null) {
                        strB = "";
                    }
                    return AbstractC4616Fw7.a(strB, AbstractC6392Nk0.a(c1786b != null ? c1786b.g() : false));
                }

                @Override // ir.nasim.InterfaceC15796kB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object q(InterfaceC13521gN1 interfaceC13521gN1, GO1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(interfaceC20295rm1);
                    aVar.c = bVar;
                    return aVar.invokeSuspend(C19938rB7.a);
                }
            }

            static final class b implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC10258bL6 a;
                final /* synthetic */ InterfaceC10258bL6 b;
                final /* synthetic */ BB4 c;

                b(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, BB4 bb4) {
                    this.a = interfaceC10258bL6;
                    this.b = interfaceC10258bL62;
                    this.c = bb4;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(XV4 xv4, InterfaceC20295rm1 interfaceC20295rm1) {
                    String str = (String) xv4.a();
                    boolean zBooleanValue = ((Boolean) xv4.b()).booleanValue();
                    if ((!AbstractC20762sZ6.n0(str)) && ((GO1.b) this.a.getValue()).e((InterfaceC13521gN1) this.b.getValue()) && !zBooleanValue) {
                        this.c.Wa().c().invoke(new GO1.a.C0389a(AbstractC23684xL1.e.b));
                    }
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, BB4 bb4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC10258bL6;
                this.d = interfaceC10258bL62;
                this.e = bb4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new c(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.p(this.c, this.d, new a(null)));
                    b bVar = new b(this.d, this.c, this.e);
                    this.b = 1;
                    if (interfaceC4557Fq2V.b(bVar, this) == objE) {
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
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC10258bL6 interfaceC10258bL62, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC10258bL6;
            this.f = interfaceC10258bL62;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            l lVar = BB4.this.new l(this.e, this.f, interfaceC20295rm1);
            lVar.c = obj;
            return lVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            BB4.this.Wa().c().invoke(new GO1.a.b(InterfaceC18834pK4.c.a));
            BB4.this.Wa().c().invoke(new GO1.a.C0389a(AbstractC23684xL1.d.b));
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(this.e, this.f, BB4.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(this.e, this.f, BB4.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new c(this.e, this.f, BB4.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class m implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.BB4$m$a$a, reason: collision with other inner class name */
            public static final class C0285a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0285a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                    boolean r0 = r6 instanceof ir.nasim.BB4.m.a.C0285a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.BB4$m$a$a r0 = (ir.nasim.BB4.m.a.C0285a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.BB4$m$a$a r0 = new ir.nasim.BB4$m$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L47
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.hQ1 r5 = (ir.nasim.InterfaceC14139hQ1) r5
                    boolean r5 = r5 instanceof ir.nasim.InterfaceC14139hQ1.a
                    java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L47
                    return r1
                L47:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.BB4.m.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public m(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* synthetic */ class n extends EB2 implements UA2 {
        n(Object obj) {
            super(1, obj, XB4.class, "setAppBarState", "setAppBarState(Lir/nasim/ui/dialoglist/model/DialogsAppBarState;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((InterfaceC13548gQ1) obj);
            return C19938rB7.a;
        }

        public final void y(InterfaceC13548gQ1 interfaceC13548gQ1) {
            AbstractC13042fc3.i(interfaceC13548gQ1, "p0");
            ((XB4) this.receiver).r3(interfaceC13548gQ1);
        }
    }

    static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ BB4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(BB4 bb4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = bb4;
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
                InterfaceC13346g43 interfaceC13346g43 = (InterfaceC13346g43) this.c;
                C10905cP1 c10905cP1 = this.d.pagerAdapter;
                if (c10905cP1 != null) {
                    c10905cP1.U(interfaceC13346g43);
                }
                ViewPager2 viewPager2 = this.d.Sa().n;
                int size = interfaceC13346g43.size();
                if (size > 6) {
                    size = 6;
                }
                viewPager2.setOffscreenPageLimit(size);
                this.d.Sa().n.setCurrentItem(((Number) this.d.hb().v2().getValue()).intValue(), false);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC13346g43 interfaceC13346g43, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC13346g43, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        o(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return BB4.this.new o(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6Z2 = BB4.this.hb().z2();
                a aVar = new a(BB4.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6Z2, aVar, this) == objE) {
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
            return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class p extends ViewPager2.i {
        p() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i) {
            super.c(i);
            BB4.this.hb().u3(i);
        }
    }

    public static final class q implements InterfaceC13819gs2 {
        q() {
        }

        @Override // ir.nasim.InterfaceC13819gs2
        /* renamed from: C3 */
        public UA2 getOnAddReservedFolderClicked() {
            return BB4.this.getOnAddReservedFolderClicked();
        }

        @Override // ir.nasim.InterfaceC13819gs2
        /* renamed from: V0 */
        public SA2 getOnCreateFolderClicked() {
            return BB4.this.getOnCreateFolderClicked();
        }

        @Override // ir.nasim.InterfaceC13819gs2
        /* renamed from: h */
        public UA2 getOnEditFolderClicked() {
            return BB4.this.getOnEditFolderClicked();
        }

        @Override // ir.nasim.InterfaceC13819gs2
        /* renamed from: p */
        public InterfaceC15796kB2 getOnDeleteFolderClicked() {
            return BB4.this.getOnDeleteFolderClicked();
        }
    }

    static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ BB4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(BB4 bb4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = bb4;
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
                    this.d.Na();
                } else {
                    this.d.La();
                }
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        r(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return BB4.this.new r(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6H2 = BB4.this.hb().H2();
                a aVar = new a(BB4.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6H2, aVar, this) == objE) {
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
            return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class s extends AbstractC23070wI4 {
        s() {
            super(true);
        }

        @Override // ir.nasim.AbstractC23070wI4
        public void d() {
            if (BB4.this.hb().Z().getValue() instanceof InterfaceC14139hQ1.b) {
                BB4.this.hb().N1();
            } else {
                j(false);
                BB4.this.Q7().onBackPressed();
            }
        }
    }

    public static final class t extends RecyclerView.t {
        private final int a;
        final /* synthetic */ C9663aL5 c;

        t(C9663aL5 c9663aL5) {
            this.c = c9663aL5;
            this.a = BB4.this.b6().getDimensionPixelOffset(AbstractC14008hB5.fab_scroll_threshold);
        }

        private final void c() {
            C9663aL5 c9663aL5 = this.c;
            if (c9663aL5.a) {
                c9663aL5.a = false;
                BB4.this.Ma();
            }
        }

        private final void d() {
            C9663aL5 c9663aL5 = this.c;
            if (c9663aL5.a) {
                return;
            }
            c9663aL5.a = true;
            BB4.this.Ka();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            if (Math.abs(i2) > this.a) {
                if (i2 > 0) {
                    d();
                } else {
                    c();
                }
            }
        }
    }

    static final class u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        u(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return BB4.this.new u(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(300L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            BB4.this.wa();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((u) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class v implements InterfaceC15796kB2 {
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(UY6.d(FD5.delete_folder_message, new Object[]{this.a}, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        v(int i, String str) {
            this.b = i;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(BB4 bb4, int i, Dialog dialog) {
            AbstractC13042fc3.i(bb4, "this$0");
            AbstractC13042fc3.i(dialog, "$it");
            bb4.hb().R1(i);
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC14603iB2 interfaceC14603iB2A = K61.a.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(787356506, true, new a(this.c), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(283536392);
            boolean zV = interfaceC22053ub1.V(BB4.this) | interfaceC22053ub1.e(this.b) | interfaceC22053ub1.D(dialog);
            final BB4 bb4 = BB4.this;
            final int i2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.RB4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return BB4.v.d(bb4, i2, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            String strC = UY6.c(FD5.delete_folder, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(283545555);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.SB4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return BB4.v.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC14603iB2A, cVar, interfaceC18060o11E, cVar2, aVar, sa2, strC, c1454b, (SA2) objB2, UY6.c(FD5.cancel, interfaceC22053ub1, 0), null, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class w extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    public static final class x extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    public static final class y extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public static final class z extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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
            return (hVar == null || (cVarN3 = hVar.n3()) == null) ? this.e.n3() : cVarN3;
        }
    }

    public BB4() {
        SA2 sa2 = new SA2() { // from class: ir.nasim.uB4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return BB4.tb(this.a);
            }
        };
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(enumC4870Gx3, new w(sa2));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(XB4.class), new x(interfaceC9173Yu3B), new y(null, interfaceC9173Yu3B), new z(this, interfaceC9173Yu3B));
        InterfaceC9173Yu3 interfaceC9173Yu3B2 = AbstractC13269fw3.b(enumC4870Gx3, new B(new A(this)));
        this.callBarViewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C6243Mu0.class), new C(interfaceC9173Yu3B2), new D(null, interfaceC9173Yu3B2), new E(this, interfaceC9173Yu3B2));
        this.menuActions = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.wB4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return BB4.jb(this.a);
            }
        });
        this.appBarActions = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.xB4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return BB4.va(this.a);
            }
        });
        this.dialogListUiAction = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.yB4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return BB4.Ja(this.a);
            }
        });
        this.folderListActions = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.zB4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return BB4.Pa(this.a);
            }
        });
        this.snackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.AB4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return BB4.sb(this.a);
            }
        });
        this.onBackPressedCallback = new s();
        this.onScrollListener = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.oB4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return BB4.pb(this.a);
            }
        });
        this.onEditFolderClicked = new UA2() { // from class: ir.nasim.pB4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return BB4.nb(this.a, ((Integer) obj).intValue());
            }
        };
        this.onDeleteFolderClicked = new InterfaceC15796kB2() { // from class: ir.nasim.qB4
            @Override // ir.nasim.InterfaceC15796kB2
            public final Object q(Object obj, Object obj2, Object obj3) {
                return BB4.mb(this.a, (String) obj, ((Integer) obj2).intValue(), ((Boolean) obj3).booleanValue());
            }
        };
        this.onCreateFolderClicked = new SA2() { // from class: ir.nasim.rB4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return BB4.lb(this.a);
            }
        };
        this.onAddReservedFolderClicked = new UA2() { // from class: ir.nasim.vB4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return BB4.kb(this.a, ((Integer) obj).intValue());
            }
        };
    }

    private final void Aa() {
        Sa().e.setContent(AbstractC19242q11.c(-2081251229, true, new h()));
    }

    private final void Ba() {
        Sa().f.setContent(AbstractC19242q11.c(-685709077, true, new i()));
    }

    private final void Ca() {
        if (hb().J2()) {
            Sa().i.setVisibility(0);
            Sa().i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.nB4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BB4.Fa(this.a, view);
                }
            });
        } else {
            Sa().i.setVisibility(8);
        }
        AbstractC16751lo1.c(this, j.b.STARTED, new j(null));
        ib();
        Sa().h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sB4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BB4.Da(this.a, view);
            }
        });
        if (C8386Vt0.a.l9()) {
            Sa().h.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.tB4
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return BB4.Ea(this.a, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(BB4 bb4, View view) {
        AbstractC13042fc3.i(bb4, "this$0");
        InterfaceC13521gN1 interfaceC13521gN1 = (InterfaceC13521gN1) AbstractC15401jX0.t0((List) bb4.hb().A2().getValue(), ((Number) bb4.hb().v2().getValue()).intValue());
        if (interfaceC13521gN1 != null) {
            if (interfaceC13521gN1 instanceof InterfaceC13521gN1.b) {
                C22042ua0.A9(bb4, bb4.Va().b(EnumC6843Pf2.d), false, null, 6, null);
            } else if (interfaceC13521gN1 instanceof InterfaceC13521gN1.a) {
                C22042ua0.A9(bb4, bb4.Va().d(EnumC6843Pf2.e), false, null, 6, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ea(BB4 bb4, View view) {
        AbstractC13042fc3.i(bb4, "this$0");
        InterfaceC6900Pl5 interfaceC6900Pl5Eb = bb4.eb();
        AppBarLayout appBarLayout = bb4.Sa().d;
        AbstractC13042fc3.h(appBarLayout, "appBarLayout2");
        ConstraintLayout constraintLayout = bb4.Sa().j;
        AbstractC13042fc3.h(constraintLayout, "root");
        InterfaceC18633oz3 interfaceC18633oz3P6 = bb4.p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC5462Jl1.f(InterfaceC6900Pl5.c(interfaceC6900Pl5Eb, appBarLayout, constraintLayout, interfaceC18633oz3P6, null, 8, null), 0, 1, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(BB4 bb4, View view) {
        AbstractC13042fc3.i(bb4, "this$0");
        C18987pb3.i1(bb4.hb().n2(), bb4.A5());
    }

    private final void Ga() {
        Sa().k.setContent(AbstractC19242q11.c(-92517480, true, new k()));
    }

    private final void Ha() {
        InterfaceC10258bL6 interfaceC10258bL6G2 = hb().g2();
        AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new l(hb().Y1(), interfaceC10258bL6G2, null), 3, null);
    }

    private final void Ia() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        this.pagerAdapter = new C10905cP1(this, (List) hb().z2().getValue(), Ua(), db(), hb().C2(), new n(hb()), new m(hb().Z()));
        AbstractC16751lo1.c(this, j.b.STARTED, new o(null));
        ViewPager2 viewPager2 = Sa().n;
        viewPager2.setAdapter(this.pagerAdapter);
        viewPager2.setCurrentItem(1, false);
        viewPager2.k(new p());
        AbstractC13042fc3.f(viewPager2);
        qb(viewPager2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TO1 Ja(BB4 bb4) {
        AbstractC13042fc3.i(bb4, "this$0");
        return bb4.Xa().a(bb4, bb4.hb(), bb4.Ta(), 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ka() {
        AbstractC13042fc3.g(Sa().h.getLayoutParams(), "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        Sa().h.animate().translationY(Sa().h.getHeight() + ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) r0)).bottomMargin).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void La() {
        ViewGroup.LayoutParams layoutParams = Sa().h.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        marginLayoutParams.setMargins(0, 0, 0, aVar.f(22.0f));
        Sa().h.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams2 = Sa().i.getLayoutParams();
        AbstractC13042fc3.g(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.setMargins(0, 0, 0, aVar.f(22.0f));
        Sa().i.setLayoutParams(marginLayoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ma() {
        Sa().h.animate().translationY(0.0f).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Na() {
        ViewGroup.LayoutParams layoutParams = Sa().h.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 200);
        Sa().h.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams2 = Sa().i.getLayoutParams();
        AbstractC13042fc3.g(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.setMargins(0, 0, 0, 200);
        Sa().i.setLayoutParams(marginLayoutParams2);
    }

    private final void Oa() {
        ViewPager2 viewPager2 = Sa().n;
        int currentItem = viewPager2.getCurrentItem();
        viewPager2.setCurrentItem(Math.max(currentItem - 1, 0), false);
        viewPager2.setCurrentItem(currentItem, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final q Pa(BB4 bb4) {
        AbstractC13042fc3.i(bb4, "this$0");
        return bb4.new q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3471c Qa() {
        return (C3471c) this.appBarActions.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C7024Py2 Sa() {
        C7024Py2 c7024Py2 = this._binding;
        AbstractC13042fc3.f(c7024Py2);
        return c7024Py2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6243Mu0 Ta() {
        return (C6243Mu0) this.callBarViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KO1 Wa() {
        return (KO1) this.dialogListUiAction.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final q Ya() {
        return (q) this.folderListActions.getValue();
    }

    private final Fragment Za(long fragmentPosition) {
        return F5().p0("f" + fragmentPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC12321eQ1 cb() {
        return (InterfaceC12321eQ1) this.menuActions.getValue();
    }

    private final t db() {
        return (t) this.onScrollListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String fb(C11458d25 peer, String title) {
        if (peer.getPeerId() != AbstractC5969Lp4.f()) {
            String strH6 = h6(AbstractC12217eE5.confirm_share);
            AbstractC13042fc3.h(strH6, "getString(...)");
            return AbstractC20153rZ6.M(strH6, "$$$", title, false, 4, null);
        }
        String strH62 = h6(AbstractC12217eE5.confirm_share_saved_message);
        AbstractC13042fc3.h(strH62, "getString(...)");
        String strH63 = h6(AbstractC12217eE5.settings_saved_messages);
        AbstractC13042fc3.h(strH63, "getString(...)");
        return AbstractC20153rZ6.M(strH62, "$$$", strH63, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17468n10 gb() {
        return (C17468n10) this.snackBar.getValue();
    }

    private final void ib() {
        AbstractC16751lo1.c(this, j.b.STARTED, new r(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC12321eQ1 jb(BB4 bb4) {
        AbstractC13042fc3.i(bb4, "this$0");
        return bb4.hb().Z1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 kb(BB4 bb4, int i2) {
        AbstractC13042fc3.i(bb4, "this$0");
        bb4.hb().a3(i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 lb(BB4 bb4) {
        AbstractC13042fc3.i(bb4, "this$0");
        Collection collectionValues = ((Map) bb4.hb().u2().getValue()).values();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collectionValues, 10));
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((DialogDTO) it.next()).getPeerUniqueId()));
        }
        C22042ua0.A9(bb4, C6960Ps2.INSTANCE.a(null, arrayList), false, null, 6, null);
        bb4.hb().w3(false);
        bb4.hb().x3(false);
        bb4.hb().v3(false);
        bb4.hb().N1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 mb(BB4 bb4, String str, int i2, boolean z2) {
        AbstractC13042fc3.i(bb4, "this$0");
        AbstractC13042fc3.i(str, "folderName");
        if (z2) {
            bb4.rb(str, i2);
        } else {
            bb4.hb().R1(i2);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 nb(BB4 bb4, int i2) {
        AbstractC13042fc3.i(bb4, "this$0");
        C22042ua0.A9(bb4, C6960Ps2.INSTANCE.a(Integer.valueOf(i2), null), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t pb(BB4 bb4) {
        AbstractC13042fc3.i(bb4, "this$0");
        return bb4.new t(new C9663aL5());
    }

    private final void qb(ViewPager2 viewPager2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("j");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(viewPager2);
            RecyclerView recyclerView = obj instanceof RecyclerView ? (RecyclerView) obj : null;
            if (recyclerView == null) {
                return;
            }
            Field declaredField2 = RecyclerView.class.getDeclaredField("O0");
            declaredField2.setAccessible(true);
            declaredField2.setInt(recyclerView, declaredField2.getInt(recyclerView) * 4);
            C19406qI3.a("DialogPager", "Increased touch slop to reduce ViewPager2 drag sensitivity", new Object[0]);
        } catch (Exception e) {
            C19406qI3.j("DialogPager", "Reflection failed: field not found", e);
        }
    }

    private final void rb(String folderName, int folderId) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1157482248, true, new v(folderId, folderName)), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 sb(BB4 bb4) {
        AbstractC13042fc3.i(bb4, "this$0");
        ConstraintLayout constraintLayout = bb4.Sa().j;
        AbstractC13042fc3.h(constraintLayout, "root");
        C17468n10 c17468n10 = new C17468n10(constraintLayout, null, 0, 6, null);
        c17468n10.k(bb4.Sa().b);
        return c17468n10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC15408jX7 tb(BB4 bb4) {
        AbstractC13042fc3.i(bb4, "this$0");
        FragmentActivity fragmentActivityQ7 = bb4.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return fragmentActivityQ7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C3471c va(BB4 bb4) {
        AbstractC13042fc3.i(bb4, "this$0");
        return bb4.new C3471c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wa() {
        Fragment fragmentU5 = U5();
        C13090h c13090h = fragmentU5 instanceof C13090h ? (C13090h) fragmentU5 : null;
        if (c13090h != null) {
            AbstractC13089g.b dialogsMode = c13090h.getDialogsMode();
            AbstractC13089g.b bVar = AbstractC13089g.b.c;
            if (dialogsMode == bVar) {
                J1(bVar);
            }
        }
    }

    private final InterfaceC13730gj3 xa() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new C3472d(null), 3, null);
    }

    private final void ya() {
        AbstractC16751lo1.c(this, j.b.STARTED, new C3473e(null));
        if (C8386Vt0.a.p9()) {
            xa();
        }
    }

    private final void za() {
        AbstractC16751lo1.c(this, j.b.STARTED, new f(null));
        Sa().c.setContent(AbstractC19242q11.c(-1425977683, true, new g()));
    }

    @Override // ir.nasim.InterfaceC12930fQ1
    public void A3() {
        C8899Xu4.Companion companion = C8899Xu4.INSTANCE;
        String strH6 = h6(FD5.search_hint_dialogs);
        AbstractC13042fc3.h(strH6, "getString(...)");
        C22042ua0.A9(this, companion.a(strH6), false, null, 6, null);
        C17213mb2.j("Search_click");
    }

    @Override // ir.nasim.InterfaceC13819gs2
    /* renamed from: C3, reason: from getter */
    public UA2 getOnAddReservedFolderClicked() {
        return this.onAddReservedFolderClicked;
    }

    @Override // ir.nasim.InterfaceC14088hK4
    public void H2() {
        if (this._binding == null || Sa().n.getAdapter() == null) {
            return;
        }
        RecyclerView.h adapter = Sa().n.getAdapter();
        AbstractC13042fc3.f(adapter);
        Fragment fragmentZa = Za(adapter.getItemId(Sa().n.getCurrentItem()));
        C14166hT1 c14166hT1 = fragmentZa instanceof C14166hT1 ? (C14166hT1) fragmentZa : null;
        if (c14166hT1 != null) {
            c14166hT1.Ha();
        }
    }

    @Override // ir.nasim.XO1
    public void J1(AbstractC13089g.b mode) {
        AbstractC13042fc3.i(mode, "mode");
        hb().K1(mode);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Q7().z2().h(this, this.onBackPressedCallback);
        if (C8386Vt0.J5()) {
            return;
        }
        XB4 xb4Hb = hb();
        Bundle bundleE5 = E5();
        boolean z2 = false;
        if (bundleE5 != null && bundleE5.getBoolean("is_event_bar_enabled_argument")) {
            z2 = true;
        }
        xb4Hb.t3(z2);
        C15225jD4.b().a(this, C15225jD4.z);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        UO1.b(UO1.a, "Container", "onCreateView", null, 4, null);
        this._binding = C7024Py2.c(inflater.cloneInContext(new C16731lm1(S7(), AbstractC12826fE5.Theme_Bale_Base)), container, false);
        ConstraintLayout constraintLayout = Sa().j;
        AbstractC13042fc3.h(constraintLayout, "root");
        return constraintLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        if (C8386Vt0.J5()) {
            return;
        }
        C15225jD4.b().e(this, C15225jD4.z);
    }

    public final InterfaceC23238wb0 Ra() {
        InterfaceC23238wb0 interfaceC23238wb0 = this.baseSettingsNavigator;
        if (interfaceC23238wb0 != null) {
            return interfaceC23238wb0;
        }
        AbstractC13042fc3.y("baseSettingsNavigator");
        return null;
    }

    @Override // ir.nasim.HI4
    public void T0() {
        ob();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        ViewPager2 viewPager2;
        super.T6();
        C10905cP1 c10905cP1 = this.pagerAdapter;
        if (c10905cP1 != null) {
            c10905cP1.T();
        }
        this.pagerAdapter = null;
        C7024Py2 c7024Py2 = this._binding;
        if (c7024Py2 != null && (viewPager2 = c7024Py2.n) != null) {
            viewPager2.setAdapter(null);
        }
        this._binding = null;
    }

    public final InterfaceC18012nw0 Ua() {
        InterfaceC18012nw0 interfaceC18012nw0 = this.callLogNavigator;
        if (interfaceC18012nw0 != null) {
            return interfaceC18012nw0;
        }
        AbstractC13042fc3.y("callLogNavigator");
        return null;
    }

    @Override // ir.nasim.InterfaceC13819gs2
    /* renamed from: V0, reason: from getter */
    public SA2 getOnCreateFolderClicked() {
        return this.onCreateFolderClicked;
    }

    public final InterfaceC8288Vi1 Va() {
        InterfaceC8288Vi1 interfaceC8288Vi1 = this.contactsNavigator;
        if (interfaceC8288Vi1 != null) {
            return interfaceC8288Vi1;
        }
        AbstractC13042fc3.y("contactsNavigator");
        return null;
    }

    @Override // ir.nasim.HI4
    public void W1(int storyId) {
        C22042ua0.A9(this, bb().h(storyId, new ArrayList()), false, null, 6, null);
    }

    public final TO1.a Xa() {
        TO1.a aVar = this.dialogListUiActionFactory;
        if (aVar != null) {
            return aVar;
        }
        AbstractC13042fc3.y("dialogListUiActionFactory");
        return null;
    }

    public final JM2 ab() {
        JM2 jm2 = this.groupProfileNavigator;
        if (jm2 != null) {
            return jm2;
        }
        AbstractC13042fc3.y("groupProfileNavigator");
        return null;
    }

    public final InterfaceC7565Sg3 bb() {
        InterfaceC7565Sg3 interfaceC7565Sg3 = this.jaryanNavigator;
        if (interfaceC7565Sg3 != null) {
            return interfaceC7565Sg3;
        }
        AbstractC13042fc3.y("jaryanNavigator");
        return null;
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int id, Object... args) {
        AbstractC13042fc3.i(args, "args");
        if (id == C15225jD4.z) {
            hb().t3(false);
        }
    }

    public final InterfaceC6900Pl5 eb() {
        InterfaceC6900Pl5 interfaceC6900Pl5 = this.premiumNavigator;
        if (interfaceC6900Pl5 != null) {
            return interfaceC6900Pl5;
        }
        AbstractC13042fc3.y("premiumNavigator");
        return null;
    }

    @Override // ir.nasim.InterfaceC13819gs2
    /* renamed from: h, reason: from getter */
    public UA2 getOnEditFolderClicked() {
        return this.onEditFolderClicked;
    }

    @Override // ir.nasim.InterfaceC12930fQ1
    public void h5() {
        DialogDTO dialogDTOT2 = hb().t2();
        if (dialogDTOT2 != null) {
            long peerUniqueId = dialogDTOT2.getPeerUniqueId();
            switch (C3470b.a[dialogDTOT2.getExPeerType().ordinal()]) {
                case 1:
                case 2:
                    C22042ua0.A9(this, C24137y63.b((int) peerUniqueId), false, null, 6, null);
                    return;
                case 3:
                case 4:
                    C22042ua0.A9(this, ab().a((int) peerUniqueId, false), false, null, 6, null);
                    return;
                case 5:
                case 6:
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final XB4 hb() {
        return (XB4) this.viewModel.getValue();
    }

    @Override // ir.nasim.InterfaceC12930fQ1
    public void i0() {
        x9(Ra().d());
        hb().s3();
    }

    @Override // androidx.fragment.app.Fragment
    public void j7() {
        super.j7();
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new u(null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void k7() {
        if (C8386Vt0.ja()) {
            hb().S2(AbstractC15401jX0.r1(hb().e2()));
        }
        super.k7();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Ha();
        za();
        Ga();
        Ia();
        Ca();
        Aa();
        Ba();
        ya();
    }

    public void ob() {
        C22042ua0.A9(this, Va().b(EnumC6843Pf2.d), false, null, 6, null);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Oa();
    }

    @Override // ir.nasim.InterfaceC13819gs2
    /* renamed from: p, reason: from getter */
    public InterfaceC15796kB2 getOnDeleteFolderClicked() {
        return this.onDeleteFolderClicked;
    }

    @Override // ir.nasim.XO1
    public void q5() {
        Sa().n.setCurrentItem(0, false);
    }
}
