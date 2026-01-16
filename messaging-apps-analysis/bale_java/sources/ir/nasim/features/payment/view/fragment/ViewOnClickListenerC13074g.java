package ir.nasim.features.payment.view.fragment;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.gov.nist.core.Separators;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13778go1;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC17457n0;
import ir.nasim.AbstractC17543n85;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20471s40;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC24063xz;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4277El1;
import ir.nasim.AbstractC4808Gq4;
import ir.nasim.AbstractC5830La0;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.C10333bU0;
import ir.nasim.C11483d50;
import ir.nasim.C11909dl1;
import ir.nasim.C12126e50;
import ir.nasim.C12366eV1;
import ir.nasim.C13396g93;
import ir.nasim.C13466gH0;
import ir.nasim.C13944h50;
import ir.nasim.C16247kx;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20514s83;
import ir.nasim.C21753u45;
import ir.nasim.C22055ub3;
import ir.nasim.C23381wp3;
import ir.nasim.C3343Am;
import ir.nasim.C4053Dm2;
import ir.nasim.C4100Dr4;
import ir.nasim.C5354Iz1;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C7419Rq1;
import ir.nasim.C7717Sx2;
import ir.nasim.C8563Wm6;
import ir.nasim.ED1;
import ir.nasim.EnumC16838lx;
import ir.nasim.EnumC4716Gg2;
import ir.nasim.GC6;
import ir.nasim.GY6;
import ir.nasim.H40;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18060o11;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC21074t40;
import ir.nasim.InterfaceC21545tj3;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC22409vB2;
import ir.nasim.InterfaceC5741Kq1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.J44;
import ir.nasim.KB5;
import ir.nasim.KS2;
import ir.nasim.NY;
import ir.nasim.QG4;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.UY6;
import ir.nasim.XY6;
import ir.nasim.ZY6;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;
import ir.nasim.features.payment.data.model.SelectableOption;
import ir.nasim.features.payment.data.response.Bank;
import ir.nasim.features.payment.data.response.CardToCardConfig;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import ir.nasim.features.payment.view.activity.CrowdfundingActivity;
import ir.nasim.features.payment.view.fragment.SelectableOptionsFragment;
import ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13074g;
import ir.nasim.features.payment.view.fragment.x;
import ir.nasim.features.payment.widget.LockableNestedScrollView;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\r*\u0002º\u0001\b\u0007\u0018\u0000 Ä\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0002Å\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\nJ\u0019\u0010\u0018\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\r2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b%\u0010$J\u0017\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\r2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\r2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b.\u0010-J\u000f\u0010/\u001a\u00020\rH\u0016¢\u0006\u0004\b/\u0010\nJ\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J)\u00108\u001a\u00020\u00022\u0006\u00104\u001a\u0002032\b\u00106\u001a\u0004\u0018\u0001052\u0006\u00107\u001a\u000200H\u0016¢\u0006\u0004\b8\u00109J\u0019\u0010<\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010:H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\rH\u0002¢\u0006\u0004\b>\u0010\nJ\u000f\u0010?\u001a\u00020\rH\u0002¢\u0006\u0004\b?\u0010\nJ\u0017\u0010B\u001a\u00020\r2\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020D2\u0006\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\rH\u0002¢\u0006\u0004\bG\u0010\nJ\u000f\u0010H\u001a\u00020\u0000H\u0002¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0000H\u0002¢\u0006\u0004\bJ\u0010IJ\u000f\u0010K\u001a\u00020\u0000H\u0002¢\u0006\u0004\bK\u0010IJ\u000f\u0010L\u001a\u00020\u0000H\u0002¢\u0006\u0004\bL\u0010IJ\u000f\u0010M\u001a\u00020\u0000H\u0002¢\u0006\u0004\bM\u0010IJ\u001b\u0010O\u001a\u00020\r2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010:H\u0002¢\u0006\u0004\bO\u0010=J\u000f\u0010P\u001a\u00020\rH\u0002¢\u0006\u0004\bP\u0010\nJ\u0017\u0010R\u001a\u00020\r2\u0006\u0010Q\u001a\u00020DH\u0002¢\u0006\u0004\bR\u0010SJ7\u0010X\u001a\u00020\r2\u0006\u0010A\u001a\u00020@2\u0016\u0010V\u001a\u0012\u0012\u0004\u0012\u00020D0Tj\b\u0012\u0004\u0012\u00020D`U2\u0006\u0010W\u001a\u000200H\u0002¢\u0006\u0004\bX\u0010YJ\u001f\u0010Z\u001a\u00020\r2\u0006\u0010A\u001a\u00020@2\u0006\u0010Q\u001a\u00020DH\u0002¢\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020\rH\u0002¢\u0006\u0004\b\\\u0010\nJ\u000f\u0010]\u001a\u00020\rH\u0002¢\u0006\u0004\b]\u0010\nJ\u000f\u0010^\u001a\u00020\rH\u0002¢\u0006\u0004\b^\u0010\nJ\u000f\u0010_\u001a\u00020\rH\u0002¢\u0006\u0004\b_\u0010\nJ\u000f\u0010`\u001a\u00020\rH\u0002¢\u0006\u0004\b`\u0010\nJ\u0017\u0010b\u001a\u00020\r2\u0006\u0010a\u001a\u00020*H\u0002¢\u0006\u0004\bb\u0010-J\u000f\u0010c\u001a\u00020\rH\u0002¢\u0006\u0004\bc\u0010\nJ\u0017\u0010f\u001a\u00020\r2\u0006\u0010e\u001a\u00020dH\u0002¢\u0006\u0004\bf\u0010gJ\u0017\u0010i\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0hH\u0002¢\u0006\u0004\bi\u0010jJ\u0019\u0010m\u001a\u0004\u0018\u00010l2\u0006\u0010k\u001a\u00020*H\u0002¢\u0006\u0004\bm\u0010nJ\u0017\u0010o\u001a\u00020\r2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\bo\u0010-J'\u0010q\u001a\u00020\r2\u0016\u0010p\u001a\u0012\u0012\u0004\u0012\u00020!0Tj\b\u0012\u0004\u0012\u00020!`UH\u0002¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020\rH\u0002¢\u0006\u0004\bs\u0010\nJ7\u0010x\u001a\u00020\r2\u0006\u0010t\u001a\u00020*2\u0006\u0010u\u001a\u00020*2\u0006\u0010A\u001a\u00020@2\u0006\u0010w\u001a\u00020v2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\bx\u0010yJ\u001f\u0010z\u001a\u00020\r2\u0006\u0010t\u001a\u00020*2\u0006\u0010u\u001a\u00020*H\u0002¢\u0006\u0004\bz\u0010{J\u0017\u0010}\u001a\u00020\r2\u0006\u0010|\u001a\u000200H\u0002¢\u0006\u0004\b}\u0010~R\u0016\u0010\u0081\u0001\u001a\u00020*8\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0017\u0010\u0083\u0001\u001a\u00020*8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0080\u0001R\u0017\u0010\u0085\u0001\u001a\u00020*8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0080\u0001R\u0017\u0010\u0087\u0001\u001a\u00020*8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0080\u0001R\u0017\u0010\u0089\u0001\u001a\u00020*8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0080\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0019\u0010\u0090\u0001\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R!\u0010\u0096\u0001\u001a\u00030\u0091\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001d\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020D0T8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R \u0010\u009c\u0001\u001a\u000b \u009a\u0001*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u0080\u0001R\u001b\u0010\u009e\u0001\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u0080\u0001R\u001b\u0010 \u0001\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010\u0080\u0001R\u001a\u0010¤\u0001\u001a\u00030¡\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001b\u0010§\u0001\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0018\u0010«\u0001\u001a\u00030¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u001d\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020!0T8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010\u0098\u0001R\u001e\u0010°\u0001\u001a\t\u0012\u0005\u0012\u00030®\u00010T8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¯\u0001\u0010\u0098\u0001R\u0019\u0010³\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u0019\u0010µ\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010²\u0001R\u001a\u0010¹\u0001\u001a\u00030¶\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u0018\u0010½\u0001\u001a\u00030º\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u001b\u0010À\u0001\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u001b\u0010Ã\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001¨\u0006Æ\u0001"}, d2 = {"Lir/nasim/features/payment/view/fragment/g;", "Lir/nasim/La0;", "Lir/nasim/Sx2;", "Landroid/view/View$OnClickListener;", "Lir/nasim/t40;", "Lir/nasim/e50$b;", "Lir/nasim/e50$c;", "Lir/nasim/e50$d;", "Lir/nasim/features/payment/view/activity/CardPaymentActivity$b;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "i7", "h7", "v", "onClick", "(Landroid/view/View;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "Lir/nasim/d50;", "bankCardSuggest", "t0", "(Lir/nasim/d50;)V", "p2", "Lir/nasim/h50;", "button", "t", "(Lir/nasim/h50;)V", "", "cardNumber", "m3", "(Ljava/lang/String;)V", "a0", "Q", "", "B1", "()Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "attachToParent", "k9", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lir/nasim/Sx2;", "Lir/nasim/tj3;", "jobListener", "f9", "(Lir/nasim/tj3;)V", "K9", "g9", "", "amount", "z9", "(J)V", "Lir/nasim/features/payment/data/model/SelectableOption;", "i9", "(J)Lir/nasim/features/payment/data/model/SelectableOption;", "t9", "u9", "()Lir/nasim/features/payment/view/fragment/g;", "v9", "m9", "r9", "s9", "listener", "n9", "T9", "item", "O9", "(Lir/nasim/features/payment/data/model/SelectableOption;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "quotaList", "fullExpandOpen", "U9", "(JLjava/util/ArrayList;Z)V", "P9", "(JLir/nasim/features/payment/data/model/SelectableOption;)V", "b9", "I9", "d9", "J9", "H9", "path", "R9", "N9", "Lir/nasim/components/textfield/view/CustomInputView;", "inputViewView", "B9", "(Lir/nasim/components/textfield/view/CustomInputView;)V", "Landroidx/lifecycle/r;", "j9", "()Landroidx/lifecycle/r;", "pattern", "Lir/nasim/features/payment/data/response/Bank;", "e9", "(Ljava/lang/String;)Lir/nasim/features/payment/data/response/Bank;", "V9", "list", "S9", "(Ljava/util/ArrayList;)V", "W9", "title", "description", "Ljava/util/Date;", "endTime", "Q9", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/Date;Ljava/lang/String;)V", "h9", "(Ljava/lang/String;Ljava/lang/String;)V", "enable", "D9", "(Z)V", "Y0", "Ljava/lang/String;", "durationKey", "Z0", "quotaAmountKey", "a1", "amountKey", "b1", "photoPathKey", "c1", "photoNameKey", "Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", "d1", "Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", "content", "e1", "J", "peerUniqueId", "Lir/nasim/Kq1;", "f1", "Lir/nasim/Yu3;", "l9", "()Lir/nasim/Kq1;", "viewModel", "g1", "Ljava/util/ArrayList;", "durationDaysList", "kotlin.jvm.PlatformType", "h1", "photoExternalFile", "i1", "photoPath", "j1", "photoName", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "k1", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "config", "l1", "Lir/nasim/features/payment/data/response/Bank;", "destBank", "Lir/nasim/e50;", "m1", "Lir/nasim/e50;", "suggestAdapter", "n1", "suggestList", "Lir/nasim/H40;", "o1", "savedList", "p1", "Z", "isConfigLoaded", "q1", "isSavedListLoaded", "Lir/nasim/bU0;", "r1", "Lir/nasim/bU0;", "loadingInitData", "ir/nasim/features/payment/view/fragment/g$b", "s1", "Lir/nasim/features/payment/view/fragment/g$b;", "cardTextWatcher", "t1", "Ljava/lang/Integer;", "durationDay", "u1", "Ljava/lang/Long;", "quotaAmount", "v1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.features.payment.view.fragment.g, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class ViewOnClickListenerC13074g extends AbstractC5830La0<C7717Sx2> implements View.OnClickListener, InterfaceC21074t40, C12126e50.b, C12126e50.c, C12126e50.d, CardPaymentActivity.b {

    /* renamed from: v1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int w1 = 8;

    /* renamed from: d1, reason: from kotlin metadata */
    private CrowdfundingContentInfo content;

    /* renamed from: i1, reason: from kotlin metadata */
    private String photoPath;

    /* renamed from: j1, reason: from kotlin metadata */
    private String photoName;

    /* renamed from: k1, reason: from kotlin metadata */
    private CardToCardConfig config;

    /* renamed from: l1, reason: from kotlin metadata */
    private Bank destBank;

    /* renamed from: p1, reason: from kotlin metadata */
    private boolean isConfigLoaded;

    /* renamed from: q1, reason: from kotlin metadata */
    private boolean isSavedListLoaded;

    /* renamed from: t1, reason: from kotlin metadata */
    private Integer durationDay;

    /* renamed from: u1, reason: from kotlin metadata */
    private Long quotaAmount;

    /* renamed from: Y0, reason: from kotlin metadata */
    private final String durationKey = "durationKey";

    /* renamed from: Z0, reason: from kotlin metadata */
    private final String quotaAmountKey = "quotaAmountKey";

    /* renamed from: a1, reason: from kotlin metadata */
    private final String amountKey = "amountKey";

    /* renamed from: b1, reason: from kotlin metadata */
    private final String photoPathKey = "photoPathKey";

    /* renamed from: c1, reason: from kotlin metadata */
    private final String photoNameKey = "photoNameKey";

    /* renamed from: e1, reason: from kotlin metadata */
    private long peerUniqueId = -1;

    /* renamed from: f1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Pp1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ViewOnClickListenerC13074g.ba(this.a);
        }
    });

    /* renamed from: g1, reason: from kotlin metadata */
    private final ArrayList durationDaysList = new ArrayList();

    /* renamed from: h1, reason: from kotlin metadata */
    private final String photoExternalFile = C4053Dm2.l("capture", "jpg");

    /* renamed from: m1, reason: from kotlin metadata */
    private final C12126e50 suggestAdapter = new C12126e50();

    /* renamed from: n1, reason: from kotlin metadata */
    private final ArrayList suggestList = new ArrayList();

    /* renamed from: o1, reason: from kotlin metadata */
    private final ArrayList savedList = new ArrayList();

    /* renamed from: r1, reason: from kotlin metadata */
    private C10333bU0 loadingInitData = new C10333bU0();

    /* renamed from: s1, reason: from kotlin metadata */
    private final b cardTextWatcher = new b();

    /* renamed from: ir.nasim.features.payment.view.fragment.g$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final ViewOnClickListenerC13074g a(CrowdfundingContentInfo crowdfundingContentInfo, long j) {
            ViewOnClickListenerC13074g viewOnClickListenerC13074g = new ViewOnClickListenerC13074g();
            Bundle bundle = new Bundle();
            if (crowdfundingContentInfo != null) {
                bundle.putParcelable("param_data", crowdfundingContentInfo);
            }
            bundle.putLong("param_peer_unique_id", j);
            viewOnClickListenerC13074g.a8(bundle);
            return viewOnClickListenerC13074g;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.g$b */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).o.setVisibility(0);
            if (editable == null) {
                ViewOnClickListenerC13074g viewOnClickListenerC13074g = ViewOnClickListenerC13074g.this;
                viewOnClickListenerC13074g.S9(viewOnClickListenerC13074g.suggestList);
                ViewOnClickListenerC13074g.this.suggestAdapter.notifyDataSetChanged();
                return;
            }
            if (ZY6.a(editable.toString()).length() < 6) {
                ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).n.setMaxLength(-1);
                ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).n.setErrorStroke(false);
                ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).n.setDrawableStart(AbstractC4043Dl1.f(ViewOnClickListenerC13074g.this.S7(), KB5.ic_card_payment_cardunknown_icon_classic));
                ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).n.setDrawableStartTint(ColorStateList.valueOf(C5495Jo7.a.L0()));
            } else if (ZY6.a(editable.toString()).length() >= 6) {
                ViewOnClickListenerC13074g viewOnClickListenerC13074g2 = ViewOnClickListenerC13074g.this;
                String strSubstring = AbstractC20153rZ6.M(editable.toString(), Separators.SP, "", false, 4, null).substring(0, 6);
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                Bank bankE9 = viewOnClickListenerC13074g2.e9(strSubstring);
                if (bankE9 == null) {
                    ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).n.setMaxLength(7);
                    CustomInputView customInputView = ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).n;
                    String strH6 = ViewOnClickListenerC13074g.this.h6(AbstractC12217eE5.card_payment_missing_destination_card);
                    AbstractC13042fc3.h(strH6, "getString(...)");
                    customInputView.setInputError(strH6);
                } else {
                    if (editable.length() == 19) {
                        ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).n.setMaxLength(19);
                        ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).o.setVisibility(8);
                    }
                    if (bankE9.getDestinationStatus().isEnable()) {
                        ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).n.setErrorStroke(false);
                        ViewOnClickListenerC13074g.this.destBank = bankE9;
                    } else {
                        ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).n.setMaxLength(7);
                        CustomInputView customInputView2 = ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).n;
                        String strI6 = ViewOnClickListenerC13074g.this.i6(AbstractC12217eE5.card_payment_unable_dest, bankE9.getName());
                        AbstractC13042fc3.h(strI6, "getString(...)");
                        customInputView2.setStartDrawableError(strI6);
                    }
                    Drawable drawableF = null;
                    ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).n.setDrawableStartTint(null);
                    CustomInputView customInputView3 = ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).n;
                    Integer drawableId = bankE9.getDrawableId();
                    if (drawableId != null) {
                        ViewOnClickListenerC13074g viewOnClickListenerC13074g3 = ViewOnClickListenerC13074g.this;
                        drawableF = AbstractC4043Dl1.f(viewOnClickListenerC13074g3.S7(), drawableId.intValue());
                    }
                    customInputView3.setDrawableStart(drawableF);
                }
            }
            ViewOnClickListenerC13074g.this.V9(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.g$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ H40 c;
        final /* synthetic */ ViewOnClickListenerC13074g d;

        /* renamed from: ir.nasim.features.payment.view.fragment.g$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ H40 c;
            final /* synthetic */ ViewOnClickListenerC13074g d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(H40 h40, ViewOnClickListenerC13074g viewOnClickListenerC13074g, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = h40;
                this.d = viewOnClickListenerC13074g;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC20471s40 abstractC20471s40A = this.c.a();
                AbstractC13042fc3.g(abstractC20471s40A, "null cannot be cast to non-null type ir.nasim.core.modules.banking.DigitOnlyBankCard");
                C13466gH0 c13466gH0E = ((ir.nasim.core.modules.banking.l) abstractC20471s40A).e();
                AbstractC13042fc3.f(c13466gH0E);
                this.d.suggestList.add(new C11483d50((int) c13466gH0E.s(), this.c.a(), C11483d50.a.a, this.c.b(), this.c.c(), this.c.d(), this.c.e(), null, null, null, 896, null));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(H40 h40, ViewOnClickListenerC13074g viewOnClickListenerC13074g, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = h40;
            this.d = viewOnClickListenerC13074g;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC13778go1 abstractC13778go1B = C12366eV1.b();
                a aVar = new a(this.c, this.d, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(abstractC13778go1B, aVar, this) == objE) {
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

    /* renamed from: ir.nasim.features.payment.view.fragment.g$d */
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ViewOnClickListenerC13074g.this.g9();
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.g$e */
    public static final class e implements x.a {
        final /* synthetic */ C11483d50 b;

        e(C11483d50 c11483d50) {
            this.b = c11483d50;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(ViewOnClickListenerC13074g viewOnClickListenerC13074g, C5354Iz1 c5354Iz1) {
            AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
            ViewOnClickListenerC13074g.o9(viewOnClickListenerC13074g, null, 1, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.features.payment.view.fragment.x.a
        public void a() {
            androidx.lifecycle.r rVarQ0 = ViewOnClickListenerC13074g.this.l9().q0(this.b.a());
            InterfaceC18633oz3 interfaceC18633oz3P6 = ViewOnClickListenerC13074g.this.p6();
            final ViewOnClickListenerC13074g viewOnClickListenerC13074g = ViewOnClickListenerC13074g.this;
            rVarQ0.j(interfaceC18633oz3P6, new C1205g(new UA2() { // from class: ir.nasim.gq1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ViewOnClickListenerC13074g.e.c(viewOnClickListenerC13074g, (C5354Iz1) obj);
                }
            }));
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.g$f */
    public static final class f implements InterfaceC21545tj3 {
        final /* synthetic */ String b;

        f(String str) {
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
            AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
            ((C7717Sx2) viewOnClickListenerC13074g.r8()).r.scrollTo(0, 0);
        }

        @Override // ir.nasim.InterfaceC21545tj3
        public void a() {
            ViewOnClickListenerC13074g.this.u9().v9().m9().r9().s9();
            if (ViewOnClickListenerC13074g.this.content == null) {
                String str = this.b;
                if (str != null) {
                    ViewOnClickListenerC13074g viewOnClickListenerC13074g = ViewOnClickListenerC13074g.this;
                    if (str.length() > 6) {
                        ((C7717Sx2) viewOnClickListenerC13074g.r8()).n.setText(str);
                    }
                }
                ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).x.clearFocus();
                ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).w.clearFocus();
                ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).m.clearFocus();
                ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).n.clearFocus();
            } else {
                ((C7717Sx2) ViewOnClickListenerC13074g.this.r8()).h.setVisibility(8);
            }
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            final ViewOnClickListenerC13074g viewOnClickListenerC13074g2 = ViewOnClickListenerC13074g.this;
            aVar.G(new Runnable() { // from class: ir.nasim.hq1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC13074g.f.c(viewOnClickListenerC13074g2);
                }
            }, 100L);
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.g$g, reason: collision with other inner class name */
    static final class C1205g implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        C1205g(UA2 ua2) {
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

    /* renamed from: ir.nasim.features.payment.view.fragment.g$h */
    public static final class h implements C8563Wm6.a {
        final /* synthetic */ SelectableOptionsFragment a;
        final /* synthetic */ ViewOnClickListenerC13074g b;

        h(SelectableOptionsFragment selectableOptionsFragment, ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
            this.a = selectableOptionsFragment;
            this.b = viewOnClickListenerC13074g;
        }

        @Override // ir.nasim.C8563Wm6.a
        public void a(SelectableOption selectableOption) {
            AbstractC13042fc3.i(selectableOption, "item");
            AbstractC16494lN1.a(this.a);
            this.b.O9(selectableOption);
            C3343Am.g("create_crowdfunding_duration_select");
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.g$i */
    public static final class i implements C8563Wm6.a {
        final /* synthetic */ SelectableOptionsFragment a;
        final /* synthetic */ ViewOnClickListenerC13074g b;
        final /* synthetic */ long c;

        i(SelectableOptionsFragment selectableOptionsFragment, ViewOnClickListenerC13074g viewOnClickListenerC13074g, long j) {
            this.a = selectableOptionsFragment;
            this.b = viewOnClickListenerC13074g;
            this.c = j;
        }

        @Override // ir.nasim.C8563Wm6.a
        public void a(SelectableOption selectableOption) {
            AbstractC13042fc3.i(selectableOption, "item");
            AbstractC16494lN1.a(this.a);
            this.b.P9(this.c, selectableOption);
            C3343Am.g("create_crowdfunding_quote_amount_select");
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.g$j */
    static final class j implements InterfaceC15796kB2 {

        /* renamed from: ir.nasim.features.payment.view.fragment.g$j$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ ViewOnClickListenerC13074g a;

            a(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
                this.a = viewOnClickListenerC13074g;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strH6 = this.a.h6(AbstractC12217eE5.crowdfunding_select_duration);
                AbstractC13042fc3.h(strH6, "getString(...)");
                AbstractC19555qZ.B0(strH6, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.payment.view.fragment.g$j$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ ViewOnClickListenerC13074g a;

            b(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
                this.a = viewOnClickListenerC13074g;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strH6 = this.a.h6(AbstractC12217eE5.crowdfunding_at_least_should_selected_one_option);
                AbstractC13042fc3.h(strH6, "getString(...)");
                AbstractC19555qZ.e0(strH6, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-133248692, true, new a(ViewOnClickListenerC13074g.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-360469682, true, new b(ViewOnClickListenerC13074g.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(319275428);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.h
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return ViewOnClickListenerC13074g.j.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.T(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, null, null, (SA2) objB, UY6.c(AbstractC12217eE5.card_payment_i_confirm, interfaceC22053ub1, 0), interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 48);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.g$k */
    static final class k implements InterfaceC15796kB2 {

        /* renamed from: ir.nasim.features.payment.view.fragment.g$k$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ ViewOnClickListenerC13074g a;

            a(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
                this.a = viewOnClickListenerC13074g;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strH6 = this.a.h6(AbstractC12217eE5.crowdfunding_select_quota_amount);
                AbstractC13042fc3.h(strH6, "getString(...)");
                AbstractC19555qZ.B0(strH6, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.features.payment.view.fragment.g$k$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ ViewOnClickListenerC13074g a;

            b(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
                this.a = viewOnClickListenerC13074g;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strH6 = this.a.h6(AbstractC12217eE5.crowdfunding_at_least_should_selected_one_option);
                AbstractC13042fc3.h(strH6, "getString(...)");
                AbstractC19555qZ.e0(strH6, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        k() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-2075427157, true, new a(ViewOnClickListenerC13074g.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1992319149, true, new b(ViewOnClickListenerC13074g.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(319302852);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.i
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return ViewOnClickListenerC13074g.k.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.T(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, null, null, (SA2) objB, UY6.c(AbstractC12217eE5.card_payment_i_confirm, interfaceC22053ub1, 0), interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 48);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A9(ViewOnClickListenerC13074g viewOnClickListenerC13074g, C10333bU0 c10333bU0, long j2, ArrayList arrayList, ArrayList arrayList2) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        AbstractC13042fc3.i(c10333bU0, "$loadingFragment");
        AbstractC13042fc3.i(arrayList, "$quotaList");
        if (arrayList2.isEmpty()) {
            Context contextS7 = viewOnClickListenerC13074g.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            NY nyX = new NY(contextS7).i(viewOnClickListenerC13074g.h6(AbstractC12217eE5.crowdfunding_amount_isnt_dividable)).x(viewOnClickListenerC13074g.h6(AbstractC12217eE5.card_payment_i_confirm));
            NY.a aVar = NY.O;
            nyX.E(aVar.a()).k(aVar.a()).a().z();
            AbstractC16494lN1.a(c10333bU0);
        } else {
            AbstractC13042fc3.f(arrayList2);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(viewOnClickListenerC13074g.i9(((Number) it.next()).longValue()));
            }
            AbstractC16494lN1.a(c10333bU0);
            viewOnClickListenerC13074g.U9(j2, arrayList, arrayList.size() < 6);
        }
        return C19938rB7.a;
    }

    private final void B9(final CustomInputView inputViewView) {
        inputViewView.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.Vp1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ViewOnClickListenerC13074g.C9(this.a, inputViewView, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(ViewOnClickListenerC13074g viewOnClickListenerC13074g, CustomInputView customInputView, View view, boolean z) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        AbstractC13042fc3.i(customInputView, "$inputViewView");
        if (z) {
            ((C7717Sx2) viewOnClickListenerC13074g.r8()).r.V((int) customInputView.getX(), (int) customInputView.getY());
        }
        try {
            C3343Am.g(customInputView.getTag().toString());
        } catch (Exception unused) {
        }
    }

    private final void D9(boolean enable) {
        if (!enable) {
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.Op1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC13074g.E9(this.a);
                }
            }, 500L);
        } else {
            ((C7717Sx2) r8()).r.setScrollable(false);
            ((C7717Sx2) r8()).j.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        ((C7717Sx2) viewOnClickListenerC13074g.r8()).r.setScrollable(true);
        ((C7717Sx2) viewOnClickListenerC13074g.r8()).j.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(ViewOnClickListenerC13074g viewOnClickListenerC13074g, String str, String str2) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        if (str != null) {
            viewOnClickListenerC13074g.R9(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G9(ViewOnClickListenerC13074g viewOnClickListenerC13074g, String str) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        viewOnClickListenerC13074g.n9(viewOnClickListenerC13074g.new f(str));
        return C19938rB7.a;
    }

    private final void H9() {
        FragmentActivity fragmentActivityQ7 = Q7();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        fragmentActivityQ7.startActivityForResult(C22055ub3.j(contextS7, true, false, true, false), 5004);
    }

    private final void I9() {
        if (this.photoExternalFile == null) {
            Toast.makeText(G5(), AbstractC12217eE5.toast_no_sdcard, 1).show();
            return;
        }
        if (AbstractC4043Dl1.a(S7(), "android.permission.CAMERA") == 0) {
            d9();
            return;
        }
        C21753u45 c21753u45 = C21753u45.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C21753u45.i0(c21753u45, fragmentActivityQ7, 5001, C21753u45.d.f, Integer.valueOf(AbstractC12217eE5.card_payment_camera_permission_desctiption), null, null, null, false, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, null);
    }

    private final void J9() {
        if (AbstractC4043Dl1.a(AbstractC5969Lp4.d().j2(), "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            H9();
            return;
        }
        C21753u45 c21753u45 = C21753u45.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C21753u45.P0(c21753u45, fragmentActivityQ7, 5002, Integer.valueOf(AbstractC12217eE5.card_payment_external_storage_permission_desctiption), null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 8, null);
    }

    private final void K9() throws NumberFormatException {
        long j2;
        boolean z = true;
        if (((C7717Sx2) r8()).w.getText().toString().length() > 0) {
            j2 = Long.parseLong(ZY6.a(((C7717Sx2) r8()).w.getText().toString()));
            if (j2 < 20000) {
                ((C7717Sx2) r8()).r.V((int) ((C7717Sx2) r8()).w.getX(), (int) ((C7717Sx2) r8()).w.getY());
                AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.cq1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewOnClickListenerC13074g.M9(this.a);
                    }
                }, 500L);
            } else {
                z = false;
            }
        } else {
            ((C7717Sx2) r8()).r.V((int) ((C7717Sx2) r8()).w.getX(), (int) ((C7717Sx2) r8()).w.getY());
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.dq1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC13074g.L9(this.a);
                }
            }, 500L);
            j2 = 0;
        }
        if (z) {
            return;
        }
        z9(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        CustomInputView customInputView = ((C7717Sx2) viewOnClickListenerC13074g.r8()).w;
        String strH6 = viewOnClickListenerC13074g.h6(AbstractC12217eE5.crowdfunding_insert_target_amount);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setInputError(strH6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        CustomInputView customInputView = ((C7717Sx2) viewOnClickListenerC13074g.r8()).w;
        String strH6 = viewOnClickListenerC13074g.h6(AbstractC12217eE5.crowdfunding_minimum_target_amoun_must_be_twenty_thousand);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setInputError(strH6);
    }

    private final void N9() {
        C3343Am.g("create_crowdfunding_remove_image_button");
        this.photoPath = null;
        this.photoName = null;
        ((C7717Sx2) r8()).i.setImageDrawable(null);
        ((C7717Sx2) r8()).e.setVisibility(8);
        ((C7717Sx2) r8()).f.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(SelectableOption item) {
        ((C7717Sx2) r8()).c.setTextColor(C5495Jo7.a.g0());
        ((C7717Sx2) r8()).c.setText(item.getTitle());
        ((C7717Sx2) r8()).c.setTypeface(C6011Lu2.i());
        Long longValue = item.getLongValue();
        this.durationDay = longValue != null ? Integer.valueOf((int) longValue.longValue()) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(long amount, SelectableOption item) {
        if (item.c()) {
            ((C7717Sx2) r8()).t.setTextColor(C5495Jo7.a.g0());
            ((C7717Sx2) r8()).t.setText(item.getTitle());
            ((C7717Sx2) r8()).t.setTypeface(C6011Lu2.i());
            Long longValue = item.getLongValue();
            AbstractC13042fc3.f(longValue);
            ((C7717Sx2) r8()).v.setText(i6(AbstractC12217eE5.crowdfunding_quota_count_param, XY6.e(GY6.g(String.valueOf(amount / longValue.longValue())))));
            ((C7717Sx2) r8()).v.setVisibility(0);
            this.quotaAmount = item.getLongValue();
        }
    }

    private final void Q9(String title, String description, long amount, Date endTime, String cardNumber) {
        if (this.photoName == null) {
            InterfaceC5741Kq1 interfaceC5741Kq1L9 = l9();
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            long j2 = this.peerUniqueId;
            Long l = this.quotaAmount;
            AbstractC13042fc3.f(l);
            InterfaceC5741Kq1.h0(interfaceC5741Kq1L9, contextS7, j2, null, null, title, description, amount, l.longValue(), endTime.getTime(), cardNumber, 12, null);
        } else {
            InterfaceC5741Kq1 interfaceC5741Kq1L92 = l9();
            Context contextS72 = S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            long j3 = this.peerUniqueId;
            String str = this.photoPath;
            AbstractC13042fc3.f(str);
            String str2 = this.photoName;
            AbstractC13042fc3.f(str2);
            Long l2 = this.quotaAmount;
            AbstractC13042fc3.f(l2);
            interfaceC5741Kq1L92.p(contextS72, j3, str, str2, title, description, amount, l2.longValue(), endTime.getTime(), cardNumber);
        }
        Q7().finish();
    }

    private final void R9(String path) {
        ((C7717Sx2) r8()).i.setImageURI(Uri.fromFile(new File(path)));
        this.photoName = GY6.e(path);
        this.photoPath = path;
        ((C7717Sx2) r8()).e.setVisibility(0);
        ((C7717Sx2) r8()).f.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(ArrayList list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList.add(list.get(0));
            arrayList.add(list.get(1));
            String strH6 = h6(AbstractC12217eE5.card_payment_show_all_source_card);
            AbstractC13042fc3.h(strH6, "getString(...)");
            arrayList.add(new C13944h50(SetUpdatesStruct$ComposedUpdates.CHANNEL_NICK_CHANGED_FIELD_NUMBER, strH6));
        } else {
            arrayList.addAll(list);
            String strH62 = h6(AbstractC12217eE5.card_payment_add_source_card);
            AbstractC13042fc3.h(strH62, "getString(...)");
            arrayList.add(new C13944h50(SetRpcStruct$ComposedRpc.JOIN_PUBLIC_GROUP_FIELD_NUMBER, strH62));
        }
        this.suggestAdapter.z(arrayList);
        this.suggestAdapter.notifyDataSetChanged();
        ((C7717Sx2) r8()).r.V((int) ((C7717Sx2) r8()).n.getX(), (int) ((C7717Sx2) r8()).n.getY());
    }

    private final void T9() {
        SelectableOptionsFragment.a aVar = SelectableOptionsFragment.r1;
        if (aVar.a()) {
            return;
        }
        String strH6 = h6(AbstractC12217eE5.crowdfunding_activity_duration);
        AbstractC13042fc3.h(strH6, "getString(...)");
        SelectableOptionsFragment selectableOptionsFragmentB = aVar.b(new SelectableOptionsFragment.Creator(strH6, this.durationDaysList, false, 4, null));
        selectableOptionsFragmentB.W8(new h(selectableOptionsFragmentB, this));
        selectableOptionsFragmentB.K8(Q7().B0(), null);
    }

    private final void U9(long amount, ArrayList quotaList, boolean fullExpandOpen) {
        SelectableOptionsFragment.a aVar = SelectableOptionsFragment.r1;
        if (aVar.a()) {
            return;
        }
        String strH6 = h6(AbstractC12217eE5.crowdfunding_quota_amount);
        AbstractC13042fc3.h(strH6, "getString(...)");
        SelectableOptionsFragment selectableOptionsFragmentB = aVar.b(new SelectableOptionsFragment.Creator(strH6, quotaList, fullExpandOpen));
        selectableOptionsFragmentB.W8(new i(selectableOptionsFragmentB, this, amount));
        selectableOptionsFragmentB.K8(Q7().B0(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(String cardNumber) {
        try {
            ArrayList arrayList = new ArrayList();
            for (C11483d50 c11483d50 : this.suggestList) {
                if (AbstractC20153rZ6.S(c11483d50.c(), XY6.h(AbstractC20153rZ6.M(cardNumber, Separators.SP, "", false, 4, null)), false, 2, null)) {
                    arrayList.add(c11483d50);
                }
            }
            S9(arrayList);
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    private final void W9() throws NumberFormatException {
        C23381wp3.f(((C7717Sx2) r8()).n);
        if (((C7717Sx2) r8()).x.getText().length() == 0) {
            LockableNestedScrollView lockableNestedScrollView = ((C7717Sx2) r8()).r;
            AbstractC13042fc3.h(lockableNestedScrollView, "nestedScrollView");
            CustomInputView customInputView = ((C7717Sx2) r8()).x;
            AbstractC13042fc3.h(customInputView, "titleInput");
            AbstractC4808Gq4.a(lockableNestedScrollView, customInputView);
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.Xp1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC13074g.X9(this.a);
                }
            }, 500L);
            D9(false);
            return;
        }
        String string = ((C7717Sx2) r8()).x.getText().toString();
        if (((C7717Sx2) r8()).w.getText().length() == 0) {
            LockableNestedScrollView lockableNestedScrollView2 = ((C7717Sx2) r8()).r;
            AbstractC13042fc3.h(lockableNestedScrollView2, "nestedScrollView");
            CustomInputView customInputView2 = ((C7717Sx2) r8()).w;
            AbstractC13042fc3.h(customInputView2, "targetAmountInput");
            AbstractC4808Gq4.a(lockableNestedScrollView2, customInputView2);
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.Yp1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC13074g.Y9(this.a);
                }
            }, 500L);
            D9(false);
            return;
        }
        long j2 = Long.parseLong(ZY6.a(((C7717Sx2) r8()).w.getText().toString()));
        if (((C7717Sx2) r8()).n.getText().length() == 0 || ((C7717Sx2) r8()).n.getText().length() < 19) {
            LockableNestedScrollView lockableNestedScrollView3 = ((C7717Sx2) r8()).r;
            AbstractC13042fc3.h(lockableNestedScrollView3, "nestedScrollView");
            CustomInputView customInputView3 = ((C7717Sx2) r8()).n;
            AbstractC13042fc3.h(customInputView3, "destinationCardNumberInput");
            AbstractC4808Gq4.a(lockableNestedScrollView3, customInputView3);
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.Zp1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC13074g.Z9(this.a);
                }
            }, 500L);
            D9(false);
            return;
        }
        String strA = ZY6.a(((C7717Sx2) r8()).n.getText().toString());
        if (((C7717Sx2) r8()).m.getText().length() == 0) {
            LockableNestedScrollView lockableNestedScrollView4 = ((C7717Sx2) r8()).r;
            AbstractC13042fc3.h(lockableNestedScrollView4, "nestedScrollView");
            CustomInputView customInputView4 = ((C7717Sx2) r8()).m;
            AbstractC13042fc3.h(customInputView4, "descriptionInput");
            AbstractC4808Gq4.a(lockableNestedScrollView4, customInputView4);
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.aq1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC13074g.aa(this.a);
                }
            }, 500L);
            D9(false);
            return;
        }
        String string2 = ((C7717Sx2) r8()).m.getText().toString();
        if (this.durationDay == null) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(704978365, true, new j()), 4, null).show();
            D9(false);
            return;
        }
        Long l = this.quotaAmount;
        if (l == null) {
            Context contextS72 = S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P62 = p6();
            AbstractC13042fc3.h(interfaceC18633oz3P62, "getViewLifecycleOwner(...)");
            AbstractC21375tZ.c(contextS72, interfaceC18633oz3P62, null, AbstractC19242q11.c(-1237200100, true, new k()), 4, null).show();
            D9(false);
            return;
        }
        if (this.destBank != null) {
            AbstractC13042fc3.f(l);
            long jLongValue = l.longValue();
            AbstractC13042fc3.f(this.destBank);
            if (jLongValue > r3.getMaximumAmount()) {
                Context contextS73 = S7();
                AbstractC13042fc3.h(contextS73, "requireContext(...)");
                NY nyW = new NY(contextS73).h(AbstractC12217eE5.card_payment_amount_more_than_destination_value).w(AbstractC12217eE5.card_payment_i_confirm);
                NY.a aVar = NY.O;
                nyW.E(aVar.a()).k(aVar.a()).a().z();
                D9(false);
                return;
            }
        }
        if (this.destBank != null) {
            Long l2 = this.quotaAmount;
            AbstractC13042fc3.f(l2);
            long jLongValue2 = l2.longValue();
            AbstractC13042fc3.f(this.destBank);
            if (jLongValue2 < r3.getMinimumAmount()) {
                Context contextS74 = S7();
                AbstractC13042fc3.h(contextS74, "requireContext(...)");
                NY nyW2 = new NY(contextS74).h(AbstractC12217eE5.card_payment_amount_lower_than_destination_value).w(AbstractC12217eE5.card_payment_i_confirm);
                NY.a aVar2 = NY.O;
                nyW2.E(aVar2.a()).k(aVar2.a()).a().z();
                D9(false);
                return;
            }
        }
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Integer num = this.durationDay;
        AbstractC13042fc3.f(num);
        calendar.add(5, num.intValue());
        Date time = calendar.getTime();
        String string3 = AbstractC20762sZ6.n1(string2).toString();
        Context contextS75 = S7();
        AbstractC13042fc3.h(contextS75, "requireContext(...)");
        if (!C4100Dr4.a(contextS75)) {
            Context contextS76 = S7();
            AbstractC13042fc3.h(contextS76, "requireContext(...)");
            String strH6 = h6(AbstractC12217eE5.card_payment_please_check_your_internet_conenction);
            AbstractC13042fc3.h(strH6, "getString(...)");
            AbstractC4277El1.e(contextS76, strH6, 0, 2, null);
            return;
        }
        if (this.content == null) {
            C3343Am.g("create_crowdfunding_send_button");
            Q9(string, string3, j2, time, strA);
        } else {
            h9(string, string3);
            C3343Am.g("create_crowdfunding_edit_button");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        CustomInputView customInputView = ((C7717Sx2) viewOnClickListenerC13074g.r8()).x;
        String strH6 = viewOnClickListenerC13074g.h6(AbstractC12217eE5.crowdfunding_insert_title);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setHintError(strH6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        CustomInputView customInputView = ((C7717Sx2) viewOnClickListenerC13074g.r8()).w;
        String strH6 = viewOnClickListenerC13074g.h6(AbstractC12217eE5.card_payment_insert_amount);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setHintError(strH6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        CustomInputView customInputView = ((C7717Sx2) viewOnClickListenerC13074g.r8()).n;
        String strH6 = viewOnClickListenerC13074g.h6(AbstractC12217eE5.card_payment_insert_dest_card);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setInputError(strH6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        CustomInputView customInputView = ((C7717Sx2) viewOnClickListenerC13074g.r8()).m;
        String strH6 = viewOnClickListenerC13074g.h6(AbstractC12217eE5.crowdfunding_insert_description);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setHintError(strH6);
    }

    private final void b9() {
        C3343Am.g("create_crowdfunding_attach_image_button");
        new AlertDialog.Builder(S7(), AbstractC23035wE5.AlertDialogStyle).setItems(new CharSequence[]{Q7().getString(AbstractC12217eE5.card_payment_pick_photo_camera), Q7().getString(AbstractC12217eE5.card_payment_pick_photo_gallery)}, new DialogInterface.OnClickListener() { // from class: ir.nasim.eq1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                ViewOnClickListenerC13074g.c9(this.a, dialogInterface, i2);
            }
        }).show().setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C7419Rq1 ba(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        FragmentActivity fragmentActivityQ7 = viewOnClickListenerC13074g.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C7419Rq1) new androidx.lifecycle.G(fragmentActivityQ7).b(C7419Rq1.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c9(ViewOnClickListenerC13074g viewOnClickListenerC13074g, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        if (i2 == 0) {
            viewOnClickListenerC13074g.I9();
        } else {
            if (i2 != 1) {
                return;
            }
            viewOnClickListenerC13074g.J9();
        }
    }

    private final void d9() {
        Uri uriH = FileProvider.h(S7(), S7().getPackageName() + ".provider", new File(this.photoExternalFile));
        FragmentActivity fragmentActivityQ7 = Q7();
        Intent intentPutExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uriH);
        AbstractC13042fc3.h(intentPutExtra, "putExtra(...)");
        fragmentActivityQ7.startActivityForResult(intentPutExtra, 5003);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bank e9(String pattern) {
        Bank bank = null;
        try {
            CardToCardConfig cardToCardConfig = this.config;
            if (cardToCardConfig == null) {
                AbstractC13042fc3.y("config");
                cardToCardConfig = null;
            }
            for (Bank bank2 : cardToCardConfig.getBankList()) {
                try {
                    if (bank2.getCardNumberPattern().contains(XY6.h(pattern))) {
                        bank = bank2;
                    }
                } catch (Exception e2) {
                    C19406qI3.d("NON_FATAL_EXCEPTION", e2);
                }
            }
        } catch (Exception e3) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e3);
        }
        return bank;
    }

    private final void f9(InterfaceC21545tj3 jobListener) {
        if (this.isConfigLoaded && this.isSavedListLoaded) {
            if (jobListener != null) {
                jobListener.a();
            }
            AbstractC16494lN1.a(this.loadingInitData);
            ((C7717Sx2) r8()).r.scrollTo(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g9() {
        ((C7717Sx2) r8()).t.setText(h6(AbstractC12217eE5.crowdfunding_select_your_option));
        ((C7717Sx2) r8()).t.setTextColor(C5495Jo7.a.o0());
        ((C7717Sx2) r8()).t.setTypeface(C6011Lu2.k());
        ((C7717Sx2) r8()).v.setVisibility(8);
        this.quotaAmount = null;
    }

    private final void h9(String title, String description) {
        CrowdfundingContentInfo crowdfundingContentInfo = this.content;
        AbstractC13042fc3.f(crowdfundingContentInfo);
        J44 j44J = crowdfundingContentInfo.j();
        AbstractC17457n0 abstractC17457n0F = j44J.F();
        AbstractC13042fc3.g(abstractC17457n0F, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.CrowdfundingContent");
        C11909dl1 c11909dl1V = ((ir.nasim.core.modules.messaging.entity.content.a) abstractC17457n0F).v();
        AbstractC13042fc3.f(c11909dl1V);
        AbstractC24063xz abstractC24063xzC = c11909dl1V.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiCrowdFundingMessage");
        C16247kx c16247kx = (C16247kx) abstractC24063xzC;
        l9().a(this.peerUniqueId, j44J.i(), j44J.h(), new C16247kx(c16247kx.F(), c16247kx.u(), c16247kx.C(), title, description, c16247kx.y(), c16247kx.D(), c16247kx.z()));
        Q7().finish();
    }

    private final SelectableOption i9(long amount) {
        return new SelectableOption(XY6.e(i6(AbstractC12217eE5.crowdfunding_rial_param, GY6.g(String.valueOf(amount)))), Long.valueOf(amount));
    }

    private final androidx.lifecycle.r j9() {
        return l9().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC5741Kq1 l9() {
        return (InterfaceC5741Kq1) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13074g m9() {
        /*
            r2 = this;
            ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo r0 = r2.content
            if (r0 != 0) goto L3c
            ir.nasim.aW7 r0 = r2.r8()
            ir.nasim.Sx2 r0 = (ir.nasim.C7717Sx2) r0
            com.google.android.material.card.MaterialCardView r0 = r0.b
            r0.setOnClickListener(r2)
            ir.nasim.aW7 r0 = r2.r8()
            ir.nasim.Sx2 r0 = (ir.nasim.C7717Sx2) r0
            com.google.android.material.card.MaterialCardView r0 = r0.s
            r0.setOnClickListener(r2)
            ir.nasim.aW7 r0 = r2.r8()
            ir.nasim.Sx2 r0 = (ir.nasim.C7717Sx2) r0
            android.widget.TextView r0 = r0.f
            r0.setOnClickListener(r2)
            ir.nasim.aW7 r0 = r2.r8()
            ir.nasim.Sx2 r0 = (ir.nasim.C7717Sx2) r0
            android.widget.TextView r0 = r0.e
            r0.setOnClickListener(r2)
            ir.nasim.aW7 r0 = r2.r8()
            ir.nasim.Sx2 r0 = (ir.nasim.C7717Sx2) r0
            com.google.android.material.card.MaterialCardView r0 = r0.j
            r0.setOnClickListener(r2)
            goto L7d
        L3c:
            ir.nasim.AbstractC13042fc3.f(r0)
            ir.nasim.lx r0 = r0.getStatus()
            ir.nasim.lx r1 = ir.nasim.EnumC16838lx.INPROGRESS
            if (r0 != r1) goto L70
            ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo r0 = r2.content
            ir.nasim.AbstractC13042fc3.f(r0)
            ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo$c r0 = r0.p()
            if (r0 != 0) goto L53
            goto L70
        L53:
            ir.nasim.aW7 r0 = r2.r8()
            ir.nasim.Sx2 r0 = (ir.nasim.C7717Sx2) r0
            com.google.android.material.card.MaterialCardView r0 = r0.j
            r0.setOnClickListener(r2)
            ir.nasim.aW7 r0 = r2.r8()
            ir.nasim.Sx2 r0 = (ir.nasim.C7717Sx2) r0
            android.widget.TextView r0 = r0.k
            int r1 = ir.nasim.AbstractC12217eE5.crowdfunding_edit
            java.lang.String r1 = r2.h6(r1)
            r0.setText(r1)
            goto L7d
        L70:
            ir.nasim.aW7 r0 = r2.r8()
            ir.nasim.Sx2 r0 = (ir.nasim.C7717Sx2) r0
            com.google.android.material.card.MaterialCardView r0 = r0.j
            r1 = 8
            r0.setVisibility(r1)
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13074g.m9():ir.nasim.features.payment.view.fragment.g");
    }

    private final void n9(final InterfaceC21545tj3 listener) {
        try {
            this.isConfigLoaded = false;
            this.isSavedListLoaded = false;
            C10333bU0 c10333bU0 = this.loadingInitData;
            FragmentManager fragmentManagerB0 = Q7().B0();
            AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
            AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
            l9().getConfig().j(p6(), new C1205g(new UA2() { // from class: ir.nasim.Rp1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ViewOnClickListenerC13074g.p9(this.a, listener, (CardToCardConfig) obj);
                }
            }));
            l9().h().j(p6(), new C1205g(new UA2() { // from class: ir.nasim.Sp1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ViewOnClickListenerC13074g.q9(this.a, listener, (C5354Iz1) obj);
                }
            }));
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            if (this.content == null) {
                Q7().finish();
            } else {
                Q7().B0().k1();
            }
        }
    }

    static /* synthetic */ void o9(ViewOnClickListenerC13074g viewOnClickListenerC13074g, InterfaceC21545tj3 interfaceC21545tj3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC21545tj3 = null;
        }
        viewOnClickListenerC13074g.n9(interfaceC21545tj3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p9(ViewOnClickListenerC13074g viewOnClickListenerC13074g, InterfaceC21545tj3 interfaceC21545tj3, CardToCardConfig cardToCardConfig) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        viewOnClickListenerC13074g.config = cardToCardConfig;
        viewOnClickListenerC13074g.isConfigLoaded = true;
        viewOnClickListenerC13074g.f9(interfaceC21545tj3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q9(ViewOnClickListenerC13074g viewOnClickListenerC13074g, InterfaceC21545tj3 interfaceC21545tj3, C5354Iz1 c5354Iz1) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        if (c5354Iz1.c()) {
            viewOnClickListenerC13074g.isSavedListLoaded = true;
            viewOnClickListenerC13074g.f9(interfaceC21545tj3);
        } else {
            viewOnClickListenerC13074g.suggestList.clear();
            viewOnClickListenerC13074g.savedList.clear();
            List<H40> list = (List) c5354Iz1.a();
            if (list != null) {
                for (H40 h40 : list) {
                    try {
                        InterfaceC18633oz3 interfaceC18633oz3P6 = viewOnClickListenerC13074g.p6();
                        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
                        AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P6), null, null, new c(h40, viewOnClickListenerC13074g, null), 3, null);
                    } catch (Exception unused) {
                    }
                }
            }
            viewOnClickListenerC13074g.S9(viewOnClickListenerC13074g.suggestList);
            ArrayList arrayList = viewOnClickListenerC13074g.savedList;
            Object objA = c5354Iz1.a();
            AbstractC13042fc3.f(objA);
            arrayList.addAll((Collection) objA);
            viewOnClickListenerC13074g.isSavedListLoaded = true;
            viewOnClickListenerC13074g.f9(interfaceC21545tj3);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewOnClickListenerC13074g r9() {
        if (this.content == null) {
            ((C7717Sx2) r8()).p.setAdapter(this.suggestAdapter);
            RecyclerView recyclerView = ((C7717Sx2) r8()).p;
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            recyclerView.addItemDecoration(new GC6(contextS7, KB5.ic_card_payment_divider_line));
            this.suggestAdapter.A(this);
            this.suggestAdapter.B(this);
            this.suggestAdapter.C(this);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewOnClickListenerC13074g s9() {
        if (this.content != null) {
            MaterialCardView materialCardView = ((C7717Sx2) r8()).b;
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            materialCardView.setCardBackgroundColor(c5495Jo7.I0());
            MaterialCardView materialCardView2 = ((C7717Sx2) r8()).b;
            materialCardView2.setForeground(null);
            materialCardView2.setClickable(false);
            materialCardView2.setFocusable(false);
            ((C7717Sx2) r8()).s.setCardBackgroundColor(c5495Jo7.I0());
            MaterialCardView materialCardView3 = ((C7717Sx2) r8()).s;
            materialCardView3.setForeground(null);
            materialCardView3.setClickable(false);
            materialCardView3.setFocusable(false);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            CrowdfundingContentInfo crowdfundingContentInfo = this.content;
            AbstractC13042fc3.f(crowdfundingContentInfo);
            long endTime = crowdfundingContentInfo.getEndTime();
            CrowdfundingContentInfo crowdfundingContentInfo2 = this.content;
            AbstractC13042fc3.f(crowdfundingContentInfo2);
            long days = timeUnit.toDays(endTime - crowdfundingContentInfo2.getStartTime());
            O9(new SelectableOption(XY6.e(i6(AbstractC12217eE5.crowdfunding_day_parameter, Long.valueOf(days))), Long.valueOf(days)));
            CrowdfundingContentInfo crowdfundingContentInfo3 = this.content;
            AbstractC13042fc3.f(crowdfundingContentInfo3);
            long amount = crowdfundingContentInfo3.getAmount();
            CrowdfundingContentInfo crowdfundingContentInfo4 = this.content;
            AbstractC13042fc3.f(crowdfundingContentInfo4);
            P9(amount, i9(crowdfundingContentInfo4.getQuotaAmount()));
        }
        return this;
    }

    private final void t9() {
        for (int i2 = 1; i2 < 32; i2++) {
            this.durationDaysList.add(new SelectableOption(XY6.e(i6(AbstractC12217eE5.crowdfunding_day_parameter, Integer.valueOf(i2))), Long.valueOf(i2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewOnClickListenerC13074g u9() {
        ((C7717Sx2) r8()).x.setHintTypeFace(C6011Lu2.i());
        ((C7717Sx2) r8()).x.setTextTypeFace(C6011Lu2.k());
        ((C7717Sx2) r8()).w.setHintTypeFace(C6011Lu2.i());
        ((C7717Sx2) r8()).w.setTextTypeFace(C6011Lu2.k());
        ((C7717Sx2) r8()).n.setHintTypeFace(C6011Lu2.i());
        ((C7717Sx2) r8()).n.setTextTypeFace(C6011Lu2.k());
        ((C7717Sx2) r8()).m.setHintTypeFace(C6011Lu2.i());
        ((C7717Sx2) r8()).m.setTextTypeFace(C6011Lu2.k());
        ((C7717Sx2) r8()).d.setTypeface(C6011Lu2.i());
        ((C7717Sx2) r8()).c.setTypeface(C6011Lu2.k());
        ((C7717Sx2) r8()).u.setTypeface(C6011Lu2.i());
        ((C7717Sx2) r8()).t.setTypeface(C6011Lu2.k());
        ((C7717Sx2) r8()).v.setTypeface(C6011Lu2.k());
        ((C7717Sx2) r8()).f.setTypeface(C6011Lu2.k());
        ((C7717Sx2) r8()).e.setTypeface(C6011Lu2.i());
        ((C7717Sx2) r8()).k.setTypeface(C6011Lu2.i());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewOnClickListenerC13074g v9() {
        ((C7717Sx2) r8()).x.setTag("create_crowdfunding_input_title_focus");
        ((C7717Sx2) r8()).m.setTag("create_crowdfunding_input_description_focus");
        ((C7717Sx2) r8()).w.setTag("create_crowdfunding_input_amount_focus");
        CustomInputView customInputView = ((C7717Sx2) r8()).x;
        AbstractC13042fc3.h(customInputView, "titleInput");
        B9(customInputView);
        CustomInputView customInputView2 = ((C7717Sx2) r8()).m;
        AbstractC13042fc3.h(customInputView2, "descriptionInput");
        B9(customInputView2);
        CustomInputView customInputView3 = ((C7717Sx2) r8()).w;
        AbstractC13042fc3.h(customInputView3, "targetAmountInput");
        B9(customInputView3);
        CustomInputView customInputView4 = ((C7717Sx2) r8()).w;
        CustomInputView customInputView5 = ((C7717Sx2) r8()).w;
        AbstractC13042fc3.h(customInputView5, "targetAmountInput");
        customInputView4.b(new C20514s83(customInputView5));
        ((C7717Sx2) r8()).w.b(new d());
        CustomInputView customInputView6 = ((C7717Sx2) r8()).n;
        CustomInputView customInputView7 = ((C7717Sx2) r8()).n;
        AbstractC13042fc3.h(customInputView7, "destinationCardNumberInput");
        customInputView6.b(new C13396g93(customInputView7));
        ((C7717Sx2) r8()).n.b(this.cardTextWatcher);
        ((C7717Sx2) r8()).r.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: ir.nasim.Tp1
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i2, int i3, int i4, int i5) {
                ViewOnClickListenerC13074g.w9(this.a, view, i2, i3, i4, i5);
            }
        });
        ((C7717Sx2) r8()).n.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.Up1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ViewOnClickListenerC13074g.x9(this.a, view, z);
            }
        });
        CrowdfundingContentInfo crowdfundingContentInfo = this.content;
        if (crowdfundingContentInfo != null) {
            CustomInputView customInputView8 = ((C7717Sx2) r8()).x;
            customInputView8.setText(crowdfundingContentInfo.getTitle());
            EnumC16838lx status = crowdfundingContentInfo.getStatus();
            EnumC16838lx enumC16838lx = EnumC16838lx.INPROGRESS;
            if (status != enumC16838lx || crowdfundingContentInfo.p() == null) {
                customInputView8.setEnabled(false);
                customInputView8.setFocusable(false);
            }
            CustomInputView customInputView9 = ((C7717Sx2) r8()).m;
            customInputView9.setText(crowdfundingContentInfo.getDescription());
            if (crowdfundingContentInfo.getStatus() != enumC16838lx || crowdfundingContentInfo.p() == null) {
                customInputView9.setEnabled(false);
                customInputView9.setFocusable(false);
            }
            CustomInputView customInputView10 = ((C7717Sx2) r8()).w;
            customInputView10.setText(String.valueOf(crowdfundingContentInfo.getAmount()));
            customInputView10.setEnabled(false);
            customInputView10.setFocusable(false);
            CustomInputView customInputView11 = ((C7717Sx2) r8()).n;
            customInputView11.setText(crowdfundingContentInfo.getCardNumber());
            customInputView11.setEnabled(false);
            customInputView11.setFocusable(false);
        }
        if (AbstractC5969Lp4.d().w0(EnumC4716Gg2.T3)) {
            ((C7717Sx2) r8()).w.setMaxLength(20);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w9(ViewOnClickListenerC13074g viewOnClickListenerC13074g, View view, int i2, int i3, int i4, int i5) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        if (i5 > 0) {
            ((C7717Sx2) viewOnClickListenerC13074g.r8()).x.c();
            ((C7717Sx2) viewOnClickListenerC13074g.r8()).w.c();
            ((C7717Sx2) viewOnClickListenerC13074g.r8()).n.c();
            ((C7717Sx2) viewOnClickListenerC13074g.r8()).m.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x9(final ViewOnClickListenerC13074g viewOnClickListenerC13074g, View view, boolean z) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        if (!z) {
            ((C7717Sx2) viewOnClickListenerC13074g.r8()).o.setVisibility(8);
            return;
        }
        C3343Am.g("create_crowdfunding_input_card_focus");
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.Wp1
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC13074g.y9(this.a);
            }
        }, 100L);
        ((C7717Sx2) viewOnClickListenerC13074g.r8()).o.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y9(ViewOnClickListenerC13074g viewOnClickListenerC13074g) {
        AbstractC13042fc3.i(viewOnClickListenerC13074g, "this$0");
        ((C7717Sx2) viewOnClickListenerC13074g.r8()).r.V((int) ((C7717Sx2) viewOnClickListenerC13074g.r8()).n.getX(), (int) ((C7717Sx2) viewOnClickListenerC13074g.r8()).n.getY());
    }

    private final void z9(final long amount) {
        final ArrayList arrayList = new ArrayList();
        if (amount <= 20000) {
            arrayList.add(i9(10000L));
            U9(amount, arrayList, true);
        } else {
            final C10333bU0 c10333bU0 = new C10333bU0();
            c10333bU0.K8(Q7().B0(), null);
            l9().a0(amount).j(p6(), new C1205g(new UA2() { // from class: ir.nasim.Qp1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ViewOnClickListenerC13074g.A9(this.a, c10333bU0, amount, arrayList, (ArrayList) obj);
                }
            }));
        }
    }

    @Override // ir.nasim.features.payment.view.activity.CardPaymentActivity.b
    public boolean B1() {
        if (!u6() || ((C7717Sx2) r8()).o.getVisibility() != 0) {
            return true;
        }
        ((C7717Sx2) r8()).o.setVisibility(8);
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        super.H6(requestCode, resultCode, data);
        if (requestCode == 5003) {
            String str = this.photoExternalFile;
            if (str == null || str.length() == 0) {
                return;
            }
            AbstractC17543n85.a(this, A5(), this.photoExternalFile, 1, true, new AbstractC17543n85.b() { // from class: ir.nasim.fq1
                @Override // ir.nasim.AbstractC17543n85.b
                public final void a(String str2, String str3) {
                    ViewOnClickListenerC13074g.F9(this.a, str2, str3);
                }
            });
            return;
        }
        if (requestCode != 5004) {
            return;
        }
        String str2 = null;
        ArrayList<String> stringArrayListExtra = data != null ? data.getStringArrayListExtra("PHOTOS") : null;
        if ((stringArrayListExtra == null || stringArrayListExtra.size() != 0) && stringArrayListExtra != null) {
            str2 = stringArrayListExtra.get(0);
        }
        if (str2 == null || str2.length() == 0) {
            return;
        }
        R9(str2);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.content = (CrowdfundingContentInfo) bundleE5.getParcelable("param_data");
            this.peerUniqueId = bundleE5.getLong("param_peer_unique_id");
        }
        if (this.content == null) {
            t9();
        }
    }

    @Override // ir.nasim.InterfaceC21074t40
    public void Q() {
        o9(this, null, 1, null);
    }

    @Override // ir.nasim.InterfaceC21074t40
    public void a0(String cardNumber) {
        AbstractC13042fc3.i(cardNumber, "cardNumber");
        ((C7717Sx2) r8()).n.setMaxLength(19);
        ((C7717Sx2) r8()).n.setText(cardNumber);
        ((C7717Sx2) r8()).n.setErrorStroke(false);
        ((C7717Sx2) r8()).n.setSelection(19);
        S9(new ArrayList());
    }

    @Override // ir.nasim.AbstractC5830La0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.g(fragmentActivityQ7, "null cannot be cast to non-null type ir.nasim.features.payment.view.activity.CrowdfundingActivity");
        CrowdfundingActivity crowdfundingActivity = (CrowdfundingActivity) fragmentActivityQ7;
        CrowdfundingActivity.P1(crowdfundingActivity, false, false, false, 6, null);
        crowdfundingActivity.S1(h6(AbstractC12217eE5.crowdfunding_title));
    }

    @Override // androidx.fragment.app.Fragment
    public void i7(Bundle outState) throws NumberFormatException {
        AbstractC13042fc3.i(outState, "outState");
        super.i7(outState);
        if (this.config == null) {
            AbstractC13042fc3.y("config");
        }
        KS2 ks2 = new KS2();
        CardToCardConfig cardToCardConfig = this.config;
        if (cardToCardConfig == null) {
            AbstractC13042fc3.y("config");
            cardToCardConfig = null;
        }
        outState.putString(CardToCardConfig.CONFIG_KEY, ks2.t(cardToCardConfig));
        Integer num = this.durationDay;
        if (num != null) {
            outState.putInt(this.durationKey, num.intValue());
        }
        Long l = this.quotaAmount;
        if (l != null) {
            long jLongValue = l.longValue();
            outState.putLong(this.amountKey, Long.parseLong(ZY6.a(((C7717Sx2) r8()).w.getText().toString())));
            outState.putLong(this.quotaAmountKey, jLongValue);
        }
        String str = this.photoPath;
        if (str != null) {
            outState.putString(this.photoPathKey, str);
        }
        String str2 = this.photoName;
        if (str2 != null) {
            outState.putString(this.photoNameKey, str2);
        }
    }

    @Override // ir.nasim.AbstractC5830La0
    /* renamed from: k9, reason: merged with bridge method [inline-methods] */
    public C7717Sx2 s8(LayoutInflater inflater, ViewGroup container, boolean attachToParent) {
        AbstractC13042fc3.i(inflater, "inflater");
        C7717Sx2 c7717Sx2C = C7717Sx2.c(inflater, container, attachToParent);
        AbstractC13042fc3.h(c7717Sx2C, "inflate(...)");
        return c7717Sx2C;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        if (savedInstanceState != null) {
            this.config = (CardToCardConfig) new KS2().k(savedInstanceState.getString(CardToCardConfig.CONFIG_KEY), CardToCardConfig.class);
            if (savedInstanceState.containsKey(this.durationKey)) {
                this.durationDay = Integer.valueOf(savedInstanceState.getInt(this.durationKey));
                String strE = XY6.e(i6(AbstractC12217eE5.crowdfunding_day_parameter, this.durationDay));
                AbstractC13042fc3.f(this.durationDay);
                O9(new SelectableOption(strE, Long.valueOf(r1.intValue())));
            }
            if (savedInstanceState.containsKey(this.quotaAmountKey)) {
                this.quotaAmount = Long.valueOf(savedInstanceState.getLong(this.quotaAmountKey));
                long j2 = savedInstanceState.getLong(this.amountKey);
                Long l = this.quotaAmount;
                AbstractC13042fc3.f(l);
                P9(j2, i9(l.longValue()));
            }
            if (savedInstanceState.containsKey(this.photoPathKey) && savedInstanceState.containsKey(this.photoNameKey)) {
                this.photoPath = savedInstanceState.getString(this.photoPathKey);
                this.photoName = savedInstanceState.getString(this.photoNameKey);
                String str = this.photoPath;
                AbstractC13042fc3.f(str);
                R9(str);
            }
        }
        j9().j(p6(), new C1205g(new UA2() { // from class: ir.nasim.bq1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ViewOnClickListenerC13074g.G9(this.a, (String) obj);
            }
        }));
    }

    @Override // ir.nasim.InterfaceC21074t40
    public void m3(String cardNumber) {
        AbstractC13042fc3.i(cardNumber, "cardNumber");
        ((C7717Sx2) r8()).n.setMaxLength(19);
        ((C7717Sx2) r8()).n.setText(cardNumber);
        ((C7717Sx2) r8()).n.setErrorStroke(false);
        ((C7717Sx2) r8()).n.setSelection(19);
        S9(new ArrayList());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) throws NumberFormatException {
        if (AbstractC13042fc3.d(v, ((C7717Sx2) r8()).b)) {
            T9();
            return;
        }
        if (AbstractC13042fc3.d(v, ((C7717Sx2) r8()).s)) {
            K9();
            return;
        }
        if (AbstractC13042fc3.d(v, ((C7717Sx2) r8()).f)) {
            b9();
            return;
        }
        if (AbstractC13042fc3.d(v, ((C7717Sx2) r8()).e)) {
            N9();
        } else if (AbstractC13042fc3.d(v, ((C7717Sx2) r8()).j)) {
            D9(true);
            W9();
        }
    }

    @Override // ir.nasim.C12126e50.c
    public void p2(C11483d50 bankCardSuggest) {
        AbstractC13042fc3.i(bankCardSuggest, "bankCardSuggest");
        if (bankCardSuggest.f() == C11483d50.a.a) {
            x xVar = new x();
            xVar.S8(new e(bankCardSuggest));
            xVar.K8(Q7().B0(), null);
        }
    }

    @Override // ir.nasim.C12126e50.d
    public void t(C13944h50 button) {
        AbstractC13042fc3.i(button, "button");
        int iA = button.a();
        if (iA == 2880) {
            I iA2 = I.INSTANCE.a(0);
            iA2.getSavedAdapter().C(this.savedList);
            iA2.k9(this);
            iA2.K8(Q7().B0(), null);
        } else if (iA == 2881) {
            C3343Am.g("create_crowdfunding_add_card_button");
            C13068a c13068aA = C13068a.INSTANCE.a(0);
            c13068aA.X8(this);
            c13068aA.K8(Q7().B0(), null);
        }
        ((C7717Sx2) r8()).o.setVisibility(8);
    }

    @Override // ir.nasim.C12126e50.b
    public void t0(C11483d50 bankCardSuggest) {
        AbstractC13042fc3.i(bankCardSuggest, "bankCardSuggest");
        ((C7717Sx2) r8()).o.setVisibility(8);
        if (bankCardSuggest.f() == C11483d50.a.a) {
            a0(bankCardSuggest.c());
        }
    }
}
