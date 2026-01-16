package ir.nasim.features.payment.view.fragment;

import ai.bale.proto.SapOuterClass$ResponseGetDestinationCardInfo;
import ai.bale.proto.SapOuterClass$ResponseReactivateApp;
import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.makeramen.roundedimageview.RoundedImageView;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC11342cq6;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15251jG3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC16751lo1;
import ir.nasim.AbstractC18623oy2;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20046rN7;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC6056Lz2;
import ir.nasim.AbstractC6550Nz2;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.BC5;
import ir.nasim.C10333bU0;
import ir.nasim.C11335cq;
import ir.nasim.C11458d25;
import ir.nasim.C12149e73;
import ir.nasim.C12889fL5;
import ir.nasim.C13353g50;
import ir.nasim.C13944h50;
import ir.nasim.C14819iX7;
import ir.nasim.C16259ky2;
import ir.nasim.C17468n10;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20481s50;
import ir.nasim.C20644sM5;
import ir.nasim.C21231tK7;
import ir.nasim.C22042ua0;
import ir.nasim.C22078ud6;
import ir.nasim.C22527vO3;
import ir.nasim.C23076wJ1;
import ir.nasim.C23381wp3;
import ir.nasim.C25226zw5;
import ir.nasim.C3343Am;
import ir.nasim.C3641Bs4;
import ir.nasim.C5495Jo7;
import ir.nasim.C7183Qq;
import ir.nasim.ED1;
import ir.nasim.EnumC18608ow5;
import ir.nasim.EnumC4716Gg2;
import ir.nasim.F92;
import ir.nasim.FV4;
import ir.nasim.G10;
import ir.nasim.G92;
import ir.nasim.GC6;
import ir.nasim.GY6;
import ir.nasim.InterfaceC10358bW7;
import ir.nasim.InterfaceC13295fz2;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18060o11;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC23146wR;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC3346Am2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC5239Im3;
import ir.nasim.InterfaceC8091Um2;
import ir.nasim.InterfaceC8327Vm4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9764aW7;
import ir.nasim.J44;
import ir.nasim.KB5;
import ir.nasim.KS2;
import ir.nasim.OU3;
import ir.nasim.OW2;
import ir.nasim.P50;
import ir.nasim.QI2;
import ir.nasim.SA2;
import ir.nasim.TA5;
import ir.nasim.TR;
import ir.nasim.UA2;
import ir.nasim.UY6;
import ir.nasim.XY6;
import ir.nasim.ZY6;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.core.modules.banking.entity.DuplicateTransactionException;
import ir.nasim.core.modules.banking.entity.HistoryMessageData;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.AvatarImage;
import ir.nasim.core.network.RpcException;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.contacts.BaleContactPickerActivity;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.response.Bank;
import ir.nasim.features.payment.data.response.CardToCardConfig;
import ir.nasim.features.payment.view.fragment.B;
import ir.nasim.features.payment.view.fragment.C13069b;
import ir.nasim.features.payment.view.fragment.N;
import ir.nasim.features.payment.view.fragment.x;
import ir.nasim.features.payment.view.fragment.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000¶\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0007*\u0004Ú\u0001Þ\u0001\b\u0007\u0018\u0000 â\u00012\u00020\u0001:\u0003|ã\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\bJ\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\bJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u0018J)\u0010 \u001a\u00020\u00062\u0018\b\u0002\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001dj\b\u0012\u0004\u0012\u00020\u0004`\u001eH\u0002¢\u0006\u0004\b \u0010!J)\u0010\"\u001a\u00020\u00062\u0018\b\u0002\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001dj\b\u0012\u0004\u0012\u00020\u0004`\u001eH\u0002¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010\u0003J\u0019\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010\u0003J\u0017\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-H\u0003¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u0010\u0003J\u000f\u00103\u001a\u000202H\u0002¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u000202H\u0002¢\u0006\u0004\b5\u00104J!\u00108\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00132\b\b\u0002\u00107\u001a\u00020\u0013H\u0002¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020\u00062\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010\u0003J/\u0010C\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u0013H\u0002¢\u0006\u0004\bC\u0010DJ\u001d\u0010G\u001a\u00020\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00060EH\u0002¢\u0006\u0004\bG\u0010HJ\u001d\u0010J\u001a\u00020\u00062\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060EH\u0002¢\u0006\u0004\bJ\u0010HJ7\u0010P\u001a\u00020\u00062\u0006\u0010L\u001a\u00020K2\u0006\u0010N\u001a\u00020M2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00132\u0006\u0010O\u001a\u000202H\u0002¢\u0006\u0004\bP\u0010QJ\u0019\u0010S\u001a\u0004\u0018\u00010M2\u0006\u0010R\u001a\u00020\u0013H\u0002¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\u0006H\u0002¢\u0006\u0004\bU\u0010\u0003J)\u0010W\u001a\u00020\u00062\u0018\b\u0002\u0010V\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001dj\b\u0012\u0004\u0012\u00020\u0004`\u001eH\u0002¢\u0006\u0004\bW\u0010!J\u0017\u0010X\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0013H\u0002¢\u0006\u0004\bX\u0010\u0018J\u000f\u0010Y\u001a\u00020\u0006H\u0002¢\u0006\u0004\bY\u0010\u0003J)\u0010Z\u001a\u00020\u00062\u0018\b\u0002\u0010V\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001dj\b\u0012\u0004\u0012\u00020\u0004`\u001eH\u0002¢\u0006\u0004\bZ\u0010!J1\u0010\\\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00132\u0018\b\u0002\u0010[\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001dj\b\u0012\u0004\u0012\u00020\u0004`\u001eH\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u000202H\u0002¢\u0006\u0004\b^\u00104J\u000f\u0010_\u001a\u000202H\u0002¢\u0006\u0004\b_\u00104J\u000f\u0010`\u001a\u000202H\u0002¢\u0006\u0004\b`\u00104J\u0019\u0010c\u001a\u00020\u00062\b\u0010b\u001a\u0004\u0018\u00010aH\u0016¢\u0006\u0004\bc\u0010dJ!\u0010g\u001a\u00020\u00062\u0006\u0010f\u001a\u00020e2\b\u0010b\u001a\u0004\u0018\u00010aH\u0017¢\u0006\u0004\bg\u0010hJ+\u0010m\u001a\u00020e2\u0006\u0010j\u001a\u00020i2\b\u0010l\u001a\u0004\u0018\u00010k2\b\u0010b\u001a\u0004\u0018\u00010aH\u0016¢\u0006\u0004\bm\u0010nJ\u0017\u0010p\u001a\u00020\u00062\u0006\u0010o\u001a\u00020aH\u0016¢\u0006\u0004\bp\u0010dJ\u000f\u0010q\u001a\u00020\u0006H\u0016¢\u0006\u0004\bq\u0010\u0003J\u000f\u0010r\u001a\u00020\u0006H\u0016¢\u0006\u0004\br\u0010\u0003J\u000f\u0010s\u001a\u00020\u0006H\u0016¢\u0006\u0004\bs\u0010\u0003J)\u0010y\u001a\u00020\u00062\u0006\u0010u\u001a\u00020t2\u0006\u0010v\u001a\u00020t2\b\u0010x\u001a\u0004\u0018\u00010wH\u0016¢\u0006\u0004\by\u0010zJ\u0015\u0010{\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0013¢\u0006\u0004\b{\u0010\u0018J\u000f\u0010|\u001a\u000202H\u0016¢\u0006\u0004\b|\u00104J\u0015\u0010}\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0013¢\u0006\u0004\b}\u0010\u0018R\u001f\u0010\u0083\u0001\u001a\u00020~8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R!\u0010\u0089\u0001\u001a\u00030\u0084\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001a\u0010\u0091\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001a\u0010\u0095\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R*\u0010\u009d\u0001\u001a\u00030\u0096\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001a\u0010¡\u0001\u001a\u00030\u009e\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001c\u0010¥\u0001\u001a\u0005\u0018\u00010¢\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001c\u0010©\u0001\u001a\u0005\u0018\u00010¦\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010ª\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001b\u0010°\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001c\u0010´\u0001\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u0018\u0010¸\u0001\u001a\u00030µ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u001a\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001b\u0010¼\u0001\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010º\u0001R\u0018\u0010À\u0001\u001a\u00030½\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0018\u0010Ä\u0001\u001a\u00030Á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u0018\u0010Æ\u0001\u001a\u00030Á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010Ã\u0001R\u001c\u0010Ê\u0001\u001a\u0005\u0018\u00010Ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u0019\u0010Í\u0001\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u001a\u0010Ñ\u0001\u001a\u00030Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u0019\u0010Ó\u0001\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ì\u0001R\u0019\u0010Õ\u0001\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Ì\u0001R\u0018\u0010Ù\u0001\u001a\u00030Ö\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R\u0018\u0010Ý\u0001\u001a\u00030Ú\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u0018\u0010á\u0001\u001a\u00030Þ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001¨\u0006ä\u0001"}, d2 = {"Lir/nasim/features/payment/view/fragment/B;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/features/payment/data/model/BankCreditCard;", ParameterNames.CARD, "Lir/nasim/rB7;", "Lb", "(Lir/nasim/features/payment/data/model/BankCreditCard;)V", "Kb", "Lir/nasim/h50;", "button", "Ob", "(Lir/nasim/h50;)V", "ab", "Sb", "creditCard", "Rb", "Ub", "", "Xa", "()Ljava/lang/String;", "Mb", "Nb", "(Ljava/lang/String;)V", "Qb", "Pb", "cardNumber", "a0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "cards", "hc", "(Ljava/util/ArrayList;)V", "lc", "Za", "dc", "Lir/nasim/core/modules/profile/entity/Avatar;", "avatar", "Lir/nasim/core/modules/profile/entity/AvatarImage;", "mb", "(Lir/nasim/core/modules/profile/entity/Avatar;)Lir/nasim/core/modules/profile/entity/AvatarImage;", "wb", "sb", "vb", "Lir/nasim/tK7;", "userVm", "cc", "(Lir/nasim/tK7;)V", "bb", "", "Fb", "()Z", "bc", "srcNumber", "destNumber", "nb", "(Ljava/lang/String;Ljava/lang/String;)V", "Lir/nasim/components/textfield/view/CustomInputView;", "inputViewView", "Ta", "(Lir/nasim/components/textfield/view/CustomInputView;)V", "rb", "destCardNumber", "sourceCard", "amountValue", "description", "Yb", "(Ljava/lang/String;Lir/nasim/features/payment/data/model/BankCreditCard;Ljava/lang/String;Ljava/lang/String;)V", "Lkotlin/Function0;", "doOnAuthentication", "Va", "(Lir/nasim/SA2;)V", "onAuthenticationSuccessful", "Wb", "Lir/nasim/wJ1;", "response", "Lir/nasim/features/payment/data/response/Bank;", "destBank", "isDestinationSaved", "Tb", "(Lir/nasim/wJ1;Lir/nasim/features/payment/data/response/Bank;Lir/nasim/features/payment/data/model/BankCreditCard;Ljava/lang/String;Z)V", "pattern", "Wa", "(Ljava/lang/String;)Lir/nasim/features/payment/data/response/Bank;", "Db", "list", "fc", "ib", "Eb", "jc", "sourceSuggestList", "sc", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "Gb", "Ib", "Hb", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "outState", "i7", "h7", "c7", "R6", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "m3", "a", "mc", "Lir/nasim/Bs4;", "h1", "Lir/nasim/Yu3;", "lb", "()Lir/nasim/Bs4;", "cardsViewModel", "Lir/nasim/ky2;", "i1", "Lir/nasim/bW7;", "kb", "()Lir/nasim/ky2;", "binding", "Lir/nasim/e73;", "j1", "Lir/nasim/e73;", "viewModel", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "k1", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "config", "Lir/nasim/n10;", "l1", "Lir/nasim/n10;", "snackBar", "Lir/nasim/wR;", "m1", "Lir/nasim/wR;", "jb", "()Lir/nasim/wR;", "setAuthenticatorNavigator", "(Lir/nasim/wR;)V", "authenticatorNavigator", "Lir/nasim/features/payment/view/fragment/B$b;", "n1", "Lir/nasim/features/payment/view/fragment/B$b;", "type", "Lir/nasim/d25;", "o1", "Lir/nasim/d25;", "peer", "Lir/nasim/core/modules/banking/entity/HistoryMessageData;", "p1", "Lir/nasim/core/modules/banking/entity/HistoryMessageData;", "messageData", "Lir/nasim/J44;", "q1", "Lir/nasim/J44;", DialogEntity.COLUMN_MESSAGE, "r1", "Ljava/lang/String;", "destinationCardNumber", "", "s1", "Ljava/lang/Long;", "amount", "Lir/nasim/P50;", "t1", "Lir/nasim/P50;", "bankLogoAdapter", "u1", "Lir/nasim/features/payment/data/response/Bank;", "v1", "srcBank", "Landroid/os/Handler;", "w1", "Landroid/os/Handler;", "autoScrollHandler", "Lir/nasim/g50;", "x1", "Lir/nasim/g50;", "destSuggestAdapter", "y1", "sourceSuggestAdapter", "Landroid/os/CountDownTimer;", "z1", "Landroid/os/CountDownTimer;", "verifyTimer", "A1", "Z", "isConfigLoaded", "Lir/nasim/bU0;", "B1", "Lir/nasim/bU0;", "loadingInitData", "C1", "loadDefaultCard", "D1", "ignoreFocusNextInput", "Ljava/lang/Runnable;", "E1", "Ljava/lang/Runnable;", "autoScrollRunnable", "ir/nasim/features/payment/view/fragment/B$d", "F1", "Lir/nasim/features/payment/view/fragment/B$d;", "destinationTextWatcher", "ir/nasim/features/payment/view/fragment/B$m", "G1", "Lir/nasim/features/payment/view/fragment/B$m;", "sourceTextWatcher", "H1", "b", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class B extends OW2 {

    /* renamed from: A1, reason: from kotlin metadata */
    private boolean isConfigLoaded;

    /* renamed from: C1, reason: from kotlin metadata */
    private boolean loadDefaultCard;

    /* renamed from: D1, reason: from kotlin metadata */
    private boolean ignoreFocusNextInput;

    /* renamed from: j1, reason: from kotlin metadata */
    private C12149e73 viewModel;

    /* renamed from: k1, reason: from kotlin metadata */
    private CardToCardConfig config;

    /* renamed from: l1, reason: from kotlin metadata */
    private C17468n10 snackBar;

    /* renamed from: m1, reason: from kotlin metadata */
    public InterfaceC23146wR authenticatorNavigator;

    /* renamed from: n1, reason: from kotlin metadata */
    private b type;

    /* renamed from: o1, reason: from kotlin metadata */
    private C11458d25 peer;

    /* renamed from: p1, reason: from kotlin metadata */
    private HistoryMessageData messageData;

    /* renamed from: q1, reason: from kotlin metadata */
    private J44 message;

    /* renamed from: r1, reason: from kotlin metadata */
    private String destinationCardNumber;

    /* renamed from: s1, reason: from kotlin metadata */
    private Long amount;

    /* renamed from: u1, reason: from kotlin metadata */
    private Bank destBank;

    /* renamed from: v1, reason: from kotlin metadata */
    private Bank srcBank;

    /* renamed from: z1, reason: from kotlin metadata */
    private CountDownTimer verifyTimer;
    static final /* synthetic */ InterfaceC5239Im3[] I1 = {AbstractC10882cM5.i(new C25226zw5(B.class, "binding", "getBinding()Lir/nasim/databinding/FragmentInformationBinding;", 0))};

    /* renamed from: H1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int J1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 cardsViewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C3641Bs4.class), new n(this), new o(null, this), new p(this));

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new q(), AbstractC20046rN7.c());

    /* renamed from: t1, reason: from kotlin metadata */
    private final P50 bankLogoAdapter = new P50();

    /* renamed from: w1, reason: from kotlin metadata */
    private final Handler autoScrollHandler = new Handler();

    /* renamed from: x1, reason: from kotlin metadata */
    private final C13353g50 destSuggestAdapter = new C13353g50(new UA2() { // from class: ir.nasim.Z63
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ir.nasim.features.payment.view.fragment.B.db(this.a, (C13944h50) obj);
        }
    }, new UA2() { // from class: ir.nasim.a73
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ir.nasim.features.payment.view.fragment.B.eb(this.a, (BankCreditCard) obj);
        }
    }, new UA2() { // from class: ir.nasim.b73
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ir.nasim.features.payment.view.fragment.B.fb(this.a, (BankCreditCard) obj);
        }
    }, new UA2() { // from class: ir.nasim.A63
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ir.nasim.features.payment.view.fragment.B.gb(this.a, (String) obj);
        }
    }, new SA2() { // from class: ir.nasim.B63
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ir.nasim.features.payment.view.fragment.B.hb(this.a);
        }
    });

    /* renamed from: y1, reason: from kotlin metadata */
    private final C13353g50 sourceSuggestAdapter = new C13353g50(new UA2() { // from class: ir.nasim.C63
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ir.nasim.features.payment.view.fragment.B.nc(this.a, (C13944h50) obj);
        }
    }, new UA2() { // from class: ir.nasim.D63
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ir.nasim.features.payment.view.fragment.B.oc(this.a, (BankCreditCard) obj);
        }
    }, new UA2() { // from class: ir.nasim.E63
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ir.nasim.features.payment.view.fragment.B.pc(this.a, (BankCreditCard) obj);
        }
    }, new UA2() { // from class: ir.nasim.F63
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ir.nasim.features.payment.view.fragment.B.qc(this.a, (String) obj);
        }
    }, new SA2() { // from class: ir.nasim.G63
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ir.nasim.features.payment.view.fragment.B.rc(this.a);
        }
    });

    /* renamed from: B1, reason: from kotlin metadata */
    private C10333bU0 loadingInitData = new C10333bU0();

    /* renamed from: E1, reason: from kotlin metadata */
    private final Runnable autoScrollRunnable = new c();

    /* renamed from: F1, reason: from kotlin metadata */
    private final d destinationTextWatcher = new d();

    /* renamed from: G1, reason: from kotlin metadata */
    private final m sourceTextWatcher = new m();

    /* renamed from: ir.nasim.features.payment.view.fragment.B$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ B b(Companion companion, Long l, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                l = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.a(l, str);
        }

        public final B a(Long l, String str) {
            B b = new B();
            Bundle bundle = new Bundle();
            bundle.putInt("TYPE_PARAM", b.a.ordinal());
            if (l != null) {
                bundle.putLong("PEER_ID_PARAM", l.longValue());
            }
            if (str != null) {
                bundle.putString("DESTINATION_CARD_NUMBER_PARAM", ZY6.a(str));
            }
            b.a8(bundle);
            return b;
        }

        public final B c(Long l, String str, long j, byte[] bArr, HistoryMessageData historyMessageData) {
            AbstractC13042fc3.i(str, "destinationCardNumber");
            AbstractC13042fc3.i(bArr, DialogEntity.COLUMN_MESSAGE);
            B b = new B();
            Bundle bundle = new Bundle();
            bundle.putInt("TYPE_PARAM", b.c.ordinal());
            if (l != null) {
                bundle.putLong("AMOUNT_PARAM", l.longValue());
            }
            bundle.putString("DESTINATION_CARD_NUMBER_PARAM", ZY6.a(str));
            bundle.putParcelable("MESSAGE_DATA_PARAM", historyMessageData);
            bundle.putLong("PEER_ID_PARAM", j);
            bundle.putByteArray("MESSAGE_PARAM", bArr);
            b.a8(bundle);
            return b;
        }

        public final B d(Long l, String str, byte[] bArr, HistoryMessageData historyMessageData) {
            AbstractC13042fc3.i(str, "destinationCardNumber");
            AbstractC13042fc3.i(bArr, DialogEntity.COLUMN_MESSAGE);
            B b = new B();
            Bundle bundle = new Bundle();
            bundle.putInt("TYPE_PARAM", b.b.ordinal());
            if (l != null) {
                bundle.putLong("AMOUNT_PARAM", l.longValue());
            }
            bundle.putString("DESTINATION_CARD_NUMBER_PARAM", ZY6.a(str));
            AbstractC13042fc3.f(historyMessageData);
            bundle.putLong("PEER_ID_PARAM", historyMessageData.getPeer());
            bundle.putParcelable("MESSAGE_DATA_PARAM", historyMessageData);
            bundle.putByteArray("MESSAGE_PARAM", bArr);
            b.a8(bundle);
            return b;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class b {
        public static final b a = new b("CARD_TO_CARD", 0);
        public static final b b = new b("MONEY_REQUEST", 1);
        public static final b c = new b("CROWDFUNDING", 2);
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

    public static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            B.this.kb().y.scrollBy(-2, 0);
            B.this.autoScrollHandler.postDelayed(this, 0L);
        }
    }

    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            B.this.kb().k.setVisibility(0);
            Drawable drawableF = null;
            if (editable == null || editable.toString().length() <= 0) {
                B.gc(B.this, null, 1, null);
                B.this.destSuggestAdapter.notifyDataSetChanged();
                B.this.kb().q.setErrorStroke(false);
                return;
            }
            if (ZY6.a(editable.toString()).length() < 6) {
                B.this.kb().q.setMaxLength(-1);
                B.this.kb().q.setErrorStroke(false);
                B.this.kb().q.setDrawableStart(AbstractC4043Dl1.f(B.this.S7(), KB5.ic_card_payment_cardunknown_icon_classic));
                B.this.kb().q.setDrawableStartTint(ColorStateList.valueOf(C5495Jo7.a.L0()));
            } else if (ZY6.a(editable.toString()).length() >= 6) {
                B b = B.this;
                String strSubstring = AbstractC20153rZ6.M(editable.toString(), Separators.SP, "", false, 4, null).substring(0, 6);
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                Bank bankWa = b.Wa(strSubstring);
                if (bankWa == null) {
                    B.this.kb().k.setVisibility(8);
                    B.this.kb().q.setMaxLength(7);
                    CustomInputView customInputView = B.this.kb().q;
                    String strH6 = B.this.h6(AbstractC12217eE5.card_payment_missing_destination_card);
                    AbstractC13042fc3.h(strH6, "getString(...)");
                    customInputView.setInputError(strH6);
                } else {
                    if (editable.length() == 19) {
                        B.this.kb().q.setMaxLength(19);
                        B.this.kb().k.setVisibility(8);
                        if (!B.this.ignoreFocusNextInput && B.this.kb().o.getText().toString().length() == 0 && B.this.loadDefaultCard) {
                            B.this.kb().o.requestFocus();
                        } else {
                            B.this.kb().q.clearFocus();
                            C23381wp3.f(B.this.kb().q);
                        }
                        B.this.kb().q.setDrawableEndFirst(AbstractC4043Dl1.f(B.this.S7(), KB5.ic_card_payment_close));
                    } else {
                        B.this.kb().q.setDrawableEndFirst(AbstractC4043Dl1.f(B.this.S7(), KB5.ic_card_payment_contact));
                    }
                    if (bankWa.getDestinationStatus().isEnable()) {
                        B.this.kb().q.setErrorStroke(false);
                        B.this.destBank = bankWa;
                    } else {
                        B.this.kb().k.setVisibility(8);
                        B.this.kb().q.setMaxLength(7);
                        CustomInputView customInputView2 = B.this.kb().q;
                        String strI6 = B.this.i6(AbstractC12217eE5.card_payment_unable_dest, bankWa.getName());
                        AbstractC13042fc3.h(strI6, "getString(...)");
                        customInputView2.setStartDrawableError(strI6);
                    }
                    B.this.kb().q.setDrawableStartTint(null);
                    CustomInputView customInputView3 = B.this.kb().q;
                    Integer drawableId = bankWa.getDrawableId();
                    if (drawableId != null) {
                        B b2 = B.this;
                        drawableF = AbstractC4043Dl1.f(b2.S7(), drawableId.intValue());
                    }
                    customInputView3.setDrawableStart(drawableF);
                }
            }
            B.this.ib(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static final class e extends RecyclerView.t {
        final /* synthetic */ LinearLayoutManager a;
        final /* synthetic */ B b;

        e(LinearLayoutManager linearLayoutManager, B b) {
            this.a = linearLayoutManager;
            this.b = b;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.b(recyclerView, i, i2);
            int iD2 = this.a.d2();
            if (iD2 != 0) {
                CardToCardConfig cardToCardConfig = this.b.config;
                if (cardToCardConfig == null) {
                    AbstractC13042fc3.y("config");
                    cardToCardConfig = null;
                }
                if (iD2 % cardToCardConfig.getBankList().size() == 0) {
                    RecyclerView.p layoutManager = recyclerView.getLayoutManager();
                    AbstractC13042fc3.f(layoutManager);
                    layoutManager.A1(0);
                }
            }
        }
    }

    public static final class f implements x.a {
        final /* synthetic */ BankCreditCard a;
        final /* synthetic */ B b;

        f(BankCreditCard bankCreditCard, B b) {
            this.a = bankCreditCard;
            this.b = b;
        }

        @Override // ir.nasim.features.payment.view.fragment.x.a
        public void a() {
            if (this.a.getType() == BankCreditCard.c.b) {
                this.b.lb().Z0(this.a);
            }
        }
    }

    public static final class g implements x.a {
        final /* synthetic */ BankCreditCard a;
        final /* synthetic */ B b;

        g(BankCreditCard bankCreditCard, B b) {
            this.a = bankCreditCard;
            this.b = b;
        }

        @Override // ir.nasim.features.payment.view.fragment.x.a
        public void a() {
            if (this.a.getType() == BankCreditCard.c.a) {
                this.b.lb().a1(this.a);
            }
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ B c;

            /* renamed from: ir.nasim.features.payment.view.fragment.B$h$a$a, reason: collision with other inner class name */
            static final class C1183a implements InterfaceC4806Gq2 {
                final /* synthetic */ B a;

                /* renamed from: ir.nasim.features.payment.view.fragment.B$h$a$a$a, reason: collision with other inner class name */
                static final class C1184a implements InterfaceC15796kB2 {
                    final /* synthetic */ B a;

                    /* renamed from: ir.nasim.features.payment.view.fragment.B$h$a$a$a$a, reason: collision with other inner class name */
                    static final class C1185a implements InterfaceC14603iB2 {
                        final /* synthetic */ B a;

                        C1185a(B b) {
                            this.a = b;
                        }

                        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                                interfaceC22053ub1.L();
                                return;
                            }
                            CardToCardConfig cardToCardConfig = this.a.config;
                            if (cardToCardConfig == null) {
                                AbstractC13042fc3.y("config");
                                cardToCardConfig = null;
                            }
                            String title = cardToCardConfig.getStatus().getTitle();
                            if (title == null) {
                                title = "";
                            }
                            AbstractC19555qZ.v0(title, null, FV4.c(KB5.ic_card_payment_ba_warning_dialog_icon, interfaceC22053ub1, 0), null, G10.a.a(interfaceC22053ub1, G10.b).p(), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 2);
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                            return C19938rB7.a;
                        }
                    }

                    /* renamed from: ir.nasim.features.payment.view.fragment.B$h$a$a$a$b */
                    static final class b implements InterfaceC14603iB2 {
                        final /* synthetic */ B a;

                        b(B b) {
                            this.a = b;
                        }

                        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                                interfaceC22053ub1.L();
                                return;
                            }
                            CardToCardConfig cardToCardConfig = this.a.config;
                            if (cardToCardConfig == null) {
                                AbstractC13042fc3.y("config");
                                cardToCardConfig = null;
                            }
                            AbstractC19555qZ.e0(cardToCardConfig.getStatus().getMessage(), interfaceC22053ub1, 0);
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                            return C19938rB7.a;
                        }
                    }

                    C1184a(B b2) {
                        this.a = b2;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 c(Dialog dialog, B b2) {
                        AbstractC13042fc3.i(dialog, "$dialog");
                        AbstractC13042fc3.i(b2, "this$0");
                        dialog.dismiss();
                        b2.Q7().finish();
                        return C19938rB7.a;
                    }

                    public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(dialog, "dialog");
                        InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-977538534, true, new C1185a(this.a), interfaceC22053ub1, 54);
                        AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
                        InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(1605402712, true, new b(this.a), interfaceC22053ub1, 54);
                        AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
                        InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                        interfaceC22053ub1.W(1143051140);
                        boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(this.a);
                        final B b2 = this.a;
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.C
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return B.h.a.C1183a.C1184a.c(dialog, b2);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC19555qZ.T(interfaceC18060o11E, c0905b, interfaceC18060o11E2, cVar, null, c1454b, (SA2) objB, UY6.c(AbstractC12217eE5.card_payment_i_confirm, interfaceC22053ub1, 0), interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 15) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 16);
                        dialog.setCancelable(false);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.features.payment.view.fragment.B$h$a$a$b */
                static final class b implements InterfaceC4806Gq2 {
                    final /* synthetic */ B a;

                    b(B b) {
                        this.a = b;
                    }

                    @Override // ir.nasim.InterfaceC4806Gq2
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final Object a(AbstractC15251jG3 abstractC15251jG3, InterfaceC20295rm1 interfaceC20295rm1) {
                        if (abstractC15251jG3 instanceof AbstractC15251jG3.b) {
                            Object objA = ((AbstractC15251jG3.b) abstractC15251jG3).a();
                            AbstractC13042fc3.g(objA, "null cannot be cast to non-null type java.util.ArrayList<ir.nasim.features.payment.data.model.BankCreditCard>");
                            this.a.lc((ArrayList) objA);
                            this.a.Za();
                        } else if (abstractC15251jG3 instanceof AbstractC15251jG3.c) {
                            C10333bU0 c10333bU0 = this.a.loadingInitData;
                            FragmentManager fragmentManagerB0 = this.a.Q7().B0();
                            AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
                            AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
                        } else if (abstractC15251jG3 instanceof AbstractC15251jG3.d) {
                            AbstractC16494lN1.a(this.a.loadingInitData);
                        } else if (!(abstractC15251jG3 instanceof AbstractC15251jG3.a)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.features.payment.view.fragment.B$h$a$a$c */
                static final class c extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int c;

                    c(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.c |= RecyclerView.UNDEFINED_DURATION;
                        return C1183a.this.a(null, this);
                    }
                }

                C1183a(B b2) {
                    this.a = b2;
                }

                /* JADX WARN: Removed duplicated region for block: B:27:0x0089  */
                /* JADX WARN: Removed duplicated region for block: B:30:0x00d5 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(ir.nasim.AbstractC15251jG3 r11, ir.nasim.InterfaceC20295rm1 r12) {
                    /*
                        Method dump skipped, instructions count: 267
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.payment.view.fragment.B.h.a.C1183a.a(ir.nasim.jG3, ir.nasim.rm1):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(B b, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = b;
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
                    InterfaceC8327Vm4 interfaceC8327Vm4F1 = this.c.lb().f1();
                    C1183a c1183a = new C1183a(this.c);
                    this.b = 1;
                    if (interfaceC8327Vm4F1.b(c1183a, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return B.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                B b = B.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(b, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(b, bVar, aVar, this) == objE) {
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

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ B c;

            /* renamed from: ir.nasim.features.payment.view.fragment.B$i$a$a, reason: collision with other inner class name */
            static final class C1186a implements InterfaceC4806Gq2 {
                final /* synthetic */ B a;

                C1186a(B b) {
                    this.a = b;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(AbstractC15251jG3 abstractC15251jG3, InterfaceC20295rm1 interfaceC20295rm1) {
                    if (abstractC15251jG3 instanceof AbstractC15251jG3.b) {
                        B b = this.a;
                        Object objA = ((AbstractC15251jG3.b) abstractC15251jG3).a();
                        AbstractC13042fc3.g(objA, "null cannot be cast to non-null type java.util.ArrayList<ir.nasim.features.payment.data.model.BankCreditCard>");
                        b.hc((ArrayList) objA);
                    } else if (!AbstractC13042fc3.d(abstractC15251jG3, AbstractC15251jG3.c.a)) {
                        if (!AbstractC13042fc3.d(abstractC15251jG3, AbstractC15251jG3.d.a) && !(abstractC15251jG3 instanceof AbstractC15251jG3.a)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        AbstractC16494lN1.a(this.a.loadingInitData);
                    }
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(B b, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = b;
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
                    InterfaceC8327Vm4 interfaceC8327Vm4I1 = this.c.lb().i1();
                    C1186a c1186a = new C1186a(this.c);
                    this.b = 1;
                    if (interfaceC8327Vm4I1.b(c1186a, this) == objE) {
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
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return B.this.new i(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                B b = B.this;
                j.b bVar = j.b.STARTED;
                a aVar = new a(b, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(b, bVar, aVar, this) == objE) {
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

    static final class j implements InterfaceC15796kB2 {

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ B a;

            a(B b) {
                this.a = b;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strH6 = this.a.h6(AbstractC12217eE5.authentication_in_shaparak_system);
                AbstractC13042fc3.h(strH6, "getString(...)");
                AbstractC19555qZ.B0(strH6, interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ B a;

            b(B b) {
                this.a = b;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strH6 = this.a.h6(AbstractC12217eE5.authentication_in_shaparak_system_description);
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
        public static final C19938rB7 d(Dialog dialog, B b2) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(b2, "this$0");
            dialog.dismiss();
            b2.Ub();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$dialog");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(665636468, true, new a(B.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-1007953418, true, new b(B.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(-1977636933);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(B.this);
            final B b2 = B.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.D
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return B.j.d(dialog, b2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            String strH6 = B.this.h6(AbstractC12217eE5.enter_phone_number_shaparak);
            AbstractC13042fc3.h(strH6, "getString(...)");
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-1977628134);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.features.payment.view.fragment.E
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return B.j.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa22 = (SA2) objB2;
            interfaceC22053ub1.Q();
            String strH62 = B.this.h6(AbstractC12217eE5.negative_remove_custom_tag);
            AbstractC13042fc3.h(strH62, "getString(...)");
            AbstractC19555qZ.F(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, aVar, sa2, strH6, c1454b, sa22, strH62, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
            dialog.setCancelable(true);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class k implements InterfaceC8091Um2 {
        k() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            Uri uriFromFile = Uri.fromFile(new File(interfaceC3346Am2.getDescriptor()));
            AbstractC13042fc3.f(uriFromFile);
            RoundedImageView roundedImageView = B.this.kb().b;
            AbstractC13042fc3.h(roundedImageView, "avatarImg");
            QI2.l(uriFromFile, roundedImageView);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
        }
    }

    static final class l implements InterfaceC15796kB2 {
        final /* synthetic */ String b;

        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ B a;

            a(B b) {
                this.a = b;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String strH6 = this.a.h6(AbstractC12217eE5.card_payment_money_transfar_is_impossible);
                AbstractC13042fc3.h(strH6, "getString(...)");
                AbstractC19555qZ.v0(strH6, null, FV4.c(KB5.ic_card_payment_ba_error_dialog_icon, interfaceC22053ub1, 0), null, G10.a.a(interfaceC22053ub1, G10.b).p(), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 2);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            b(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        l(String str) {
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$dialog");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1676463683, true, new a(B.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(487671109, true, new b(this.b), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-1604979129);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.F
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return B.l.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            String strH6 = B.this.h6(AbstractC12217eE5.card_payment_i_confirm);
            AbstractC13042fc3.h(strH6, "getString(...)");
            AbstractC19555qZ.T(interfaceC18060o11E, c0905b, interfaceC18060o11E2, cVar, null, c1454b, (SA2) objB, strH6, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 15) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 16);
            dialog.setCancelable(false);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class m implements TextWatcher {
        m() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Drawable drawableF;
            B.this.kb().z.setVisibility(0);
            if (editable == null || editable.toString().length() <= 0) {
                B.kc(B.this, null, 1, null);
                B.this.sourceSuggestAdapter.notifyDataSetChanged();
                B.this.kb().r.setErrorStroke(false);
                return;
            }
            if (ZY6.a(editable.toString()).length() < 6) {
                B.this.kb().r.setMaxLength(-1);
                B.this.kb().r.setErrorStroke(false);
                B.this.kb().r.setDrawableStart(AbstractC4043Dl1.f(B.this.S7(), KB5.ic_card_payment_cardunknown_icon_classic));
                B.this.kb().r.setDrawableStartTint(ColorStateList.valueOf(C5495Jo7.a.L0()));
            } else if (ZY6.a(editable.toString()).length() >= 6) {
                B b = B.this;
                String strSubstring = AbstractC20153rZ6.M(editable.toString(), Separators.SP, "", false, 4, null).substring(0, 6);
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                Bank bankWa = b.Wa(strSubstring);
                if (bankWa == null) {
                    B.this.kb().z.setVisibility(8);
                    B.this.kb().r.setMaxLength(7);
                    CustomInputView customInputView = B.this.kb().r;
                    String strH6 = B.this.h6(AbstractC12217eE5.card_payment_missing_source_card);
                    AbstractC13042fc3.h(strH6, "getString(...)");
                    customInputView.setInputError(strH6);
                } else {
                    if (editable.length() == 19) {
                        C3343Am.g("c2c_source_card_complete");
                        B.this.kb().r.setMaxLength(19);
                        if (!B.this.ignoreFocusNextInput && B.this.kb().q.getText().length() < 19 && !B.this.Gb() && !B.this.Ib() && !B.this.Hb() && B.this.loadDefaultCard) {
                            B.this.kb().q.requestFocus();
                        } else if (!B.this.ignoreFocusNextInput && B.this.kb().o.isEnabled() && B.this.kb().o.getText().toString().length() == 0 && B.this.amount == null && B.this.loadDefaultCard) {
                            B.this.kb().o.requestFocus();
                        } else {
                            B.this.kb().r.clearFocus();
                            C23381wp3.f(B.this.kb().r);
                        }
                        B.this.kb().z.setVisibility(8);
                        B.this.srcBank = bankWa;
                        B.this.kb().r.setDrawableEndFirst(AbstractC4043Dl1.f(B.this.S7(), KB5.ic_card_payment_close));
                    } else {
                        B.this.kb().r.setDrawableEndFirst(null);
                    }
                    if (bankWa.getSourceStatus().isEnable()) {
                        B.this.kb().r.setErrorStroke(false);
                    } else {
                        B.this.kb().z.setVisibility(8);
                        B.this.kb().r.setMaxLength(7);
                        CustomInputView customInputView2 = B.this.kb().r;
                        String strI6 = B.this.i6(AbstractC12217eE5.card_payment_unable_source, bankWa.getName());
                        AbstractC13042fc3.h(strI6, "getString(...)");
                        customInputView2.setStartDrawableError(strI6);
                    }
                    B.this.kb().r.setDrawableStartTint(null);
                    CustomInputView customInputView3 = B.this.kb().r;
                    Integer drawableId = bankWa.getDrawableId();
                    if (drawableId != null) {
                        drawableF = AbstractC4043Dl1.f(B.this.S7(), drawableId.intValue());
                    } else {
                        drawableF = null;
                    }
                    customInputView3.setDrawableStart(drawableF);
                }
            }
            B.tc(B.this, editable.toString(), null, 2, null);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public static final class n extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Fragment fragment) {
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

    public static final class o extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(SA2 sa2, Fragment fragment) {
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

    public static final class p extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Fragment fragment) {
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

    public static final class q extends AbstractC8614Ws3 implements UA2 {
        public q() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C16259ky2.a(fragment.V7());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ab(B b2) {
        AbstractC13042fc3.i(b2, "this$0");
        b2.ignoreFocusNextInput = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bb(B b2, View view, int i2, int i3, int i4, int i5) {
        AbstractC13042fc3.i(b2, "this$0");
        if (i5 > 50) {
            b2.kb().p.c();
            b2.kb().o.c();
            b2.kb().q.c();
            b2.kb().r.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Cb(B b2, View view) throws NumberFormatException {
        AbstractC13042fc3.i(b2, "this$0");
        b2.bb();
    }

    private final void Db() {
        kb().l.setAdapter(this.destSuggestAdapter);
        RecyclerView recyclerView = kb().l;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        recyclerView.addItemDecoration(new GC6(contextS7, KB5.ic_card_payment_divider_line));
    }

    private final void Eb() {
        kb().A.setAdapter(this.sourceSuggestAdapter);
        RecyclerView recyclerView = kb().A;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        recyclerView.addItemDecoration(new GC6(contextS7, KB5.ic_card_payment_divider_line));
    }

    private final boolean Fb() {
        b bVar = this.type;
        if (bVar == null) {
            AbstractC13042fc3.y("type");
            bVar = null;
        }
        return bVar == b.a && this.peer != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Gb() {
        b bVar = this.type;
        if (bVar == null) {
            AbstractC13042fc3.y("type");
            bVar = null;
        }
        return bVar == b.a && this.peer != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Hb() {
        b bVar = this.type;
        if (bVar == null) {
            AbstractC13042fc3.y("type");
            bVar = null;
        }
        if (bVar == b.c) {
            C11458d25 c11458d25 = this.peer;
            if (c11458d25 != null) {
                if ((c11458d25 != null ? Integer.valueOf(c11458d25.getPeerId()) : null) == null) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Ib() {
        b bVar = this.type;
        if (bVar == null) {
            AbstractC13042fc3.y("type");
            bVar = null;
        }
        if (bVar == b.b) {
            C11458d25 c11458d25 = this.peer;
            if (c11458d25 != null) {
                if ((c11458d25 != null ? Integer.valueOf(c11458d25.getPeerId()) : null) == null) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Jb(B b2, String str, Bundle bundle) {
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(str, "str");
        AbstractC13042fc3.i(bundle, "bundle");
        String string = bundle.getString("src_card_clicked");
        if (string != null) {
            b2.m3(string);
        }
        String string2 = bundle.getString("dst_card_clicked");
        if (string2 != null) {
            b2.a0(string2);
        }
        return C19938rB7.a;
    }

    private final void Kb(BankCreditCard card) {
        x xVar = new x();
        xVar.S8(new f(card, this));
        xVar.K8(Q7().B0(), null);
    }

    private final void Lb(BankCreditCard card) {
        x xVar = new x();
        xVar.S8(new g(card, this));
        xVar.K8(Q7().B0(), null);
    }

    private final void Mb(BankCreditCard card) {
        kb().k.setVisibility(8);
        kb().z.setVisibility(8);
        a0(card.getNumber());
    }

    private final void Nb(String card) {
        kb().k.setVisibility(8);
        kb().z.setVisibility(8);
        a0(card);
    }

    private final void Ob(C13944h50 button) {
        int iA = button.a();
        if (iA == 2880) {
            J.INSTANCE.a(0).K8(Q7().B0(), null);
        } else if (iA == 2881) {
            C23381wp3.f(o6());
            C13069b.Companion.b(C13069b.INSTANCE, 0, null, 2, null).K8(Q7().B0(), null);
        } else if (iA == 2950) {
            J.INSTANCE.a(1).K8(Q7().B0(), null);
        }
        kb().k.setVisibility(8);
        kb().z.setVisibility(8);
    }

    private final void Pb(BankCreditCard card) {
        kb().k.setVisibility(8);
        kb().z.setVisibility(8);
        m3(card.getNumber());
    }

    private final void Qb(String card) {
        kb().k.setVisibility(8);
        kb().z.setVisibility(8);
        m3(card);
    }

    private final void Rb(BankCreditCard creditCard) {
        if (lb().k1().isEmpty()) {
            C19406qI3.d("NON_FATAL_EXCEPTION", new Exception("local saved card is empty or null"));
            return;
        }
        C7183Qq.q(EnumC18608ow5.g).g("last_request_is_reactivate", false);
        y.Companion companion = y.INSTANCE;
        y yVarA = companion.a(creditCard);
        FragmentManager fragmentManagerB0 = Q7().B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        companion.b(yVarA, fragmentManagerB0, "EnrollmentCardFragment");
    }

    private final void Sb() {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1395534184, true, new j()), 4, null).show();
    }

    private final void Ta(final CustomInputView inputViewView) {
        inputViewView.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.P63
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ir.nasim.features.payment.view.fragment.B.Ua(this.a, inputViewView, view, z);
            }
        });
    }

    private final void Tb(C23076wJ1 response, Bank destBank, BankCreditCard sourceCard, String description, boolean isDestinationSaved) {
        N.Companion aVar = N.INSTANCE;
        b bVar = this.type;
        if (bVar == null) {
            AbstractC13042fc3.y("type");
            bVar = null;
        }
        int iOrdinal = bVar.ordinal();
        J44 j44 = this.message;
        byte[] byteArray = j44 != null ? j44.toByteArray() : null;
        C11458d25 c11458d25 = this.peer;
        N nA = aVar.a(iOrdinal, byteArray, c11458d25 != null ? Long.valueOf(c11458d25.u()) : null, destBank, sourceCard, description, isDestinationSaved);
        nA.t9(response);
        Q7().B0().s().q(BC5.fragment_container, nA).g(null).h();
        C3343Am.g("c2c_open_second_page");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ua(B b2, CustomInputView customInputView, View view, boolean z) {
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(customInputView, "$inputViewView");
        if (z) {
            b2.kb().t.V((int) customInputView.getX(), (int) customInputView.getY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ub() {
        AbstractC5969Lp4.d().o2().y().v2().m0(new InterfaceC24449ye1() { // from class: ir.nasim.T63
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.payment.view.fragment.B.Vb(this.a, (SapOuterClass$ResponseReactivateApp) obj);
            }
        });
    }

    private final void Va(SA2 doOnAuthentication) {
        Fragment fragmentA;
        C12149e73 c12149e73 = this.viewModel;
        C12149e73 c12149e732 = null;
        if (c12149e73 == null) {
            AbstractC13042fc3.y("viewModel");
            c12149e73 = null;
        }
        if (c12149e73.U0()) {
            InterfaceC23146wR interfaceC23146wRJb = jb();
            C12149e73 c12149e733 = this.viewModel;
            if (c12149e733 == null) {
                AbstractC13042fc3.y("viewModel");
            } else {
                c12149e732 = c12149e733;
            }
            fragmentA = InterfaceC23146wR.c(interfaceC23146wRJb, "AuthenticationResult_Key", new TR.b(c12149e732.T0()), false, false, null, 28, null);
        } else {
            InterfaceC23146wR interfaceC23146wRJb2 = jb();
            C12149e73 c12149e734 = this.viewModel;
            if (c12149e734 == null) {
                AbstractC13042fc3.y("viewModel");
            } else {
                c12149e732 = c12149e734;
            }
            fragmentA = InterfaceC23146wR.a(interfaceC23146wRJb2, "AuthenticationResult_Key", new TR.b(c12149e732.T0()), false, false, null, 28, null);
        }
        C22042ua0.w9(this, fragmentA, false, null, 6, null);
        Wb(doOnAuthentication);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vb(B b2, SapOuterClass$ResponseReactivateApp sapOuterClass$ResponseReactivateApp) {
        AbstractC13042fc3.i(b2, "this$0");
        C7183Qq.p().putString("last_request_for_shaparak_migration_transactionid", sapOuterClass$ResponseReactivateApp.getTransactionId());
        C7183Qq.q(EnumC18608ow5.g).g("last_request_is_reactivate", true);
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        FragmentActivity fragmentActivityQ7 = b2.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        Uri uri = Uri.parse(sapOuterClass$ResponseReactivateApp.getReactivationAddress());
        AbstractC13042fc3.h(uri, "parse(...)");
        aVar.A(fragmentActivityQ7, uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bank Wa(String pattern) {
        Bank bank = null;
        try {
            CardToCardConfig cardToCardConfig = this.config;
            if (cardToCardConfig == null) {
                AbstractC13042fc3.y("config");
                cardToCardConfig = null;
            }
            for (Bank bank2 : cardToCardConfig.getBankList()) {
                if (bank2.getCardNumberPattern().contains(XY6.h(pattern))) {
                    bank = bank2;
                }
            }
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
        return bank;
    }

    private final void Wb(final SA2 onAuthenticationSuccessful) {
        V5().H1("AuthenticationResult_Key", this, new InterfaceC13295fz2() { // from class: ir.nasim.S63
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle) {
                ir.nasim.features.payment.view.fragment.B.Xb(onAuthenticationSuccessful, str, bundle);
            }
        });
    }

    private final String Xa() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        try {
            ClipboardManager clipboardManager = (ClipboardManager) S7().getSystemService("clipboard");
            CharSequence text = (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || (itemAt = primaryClip.getItemAt(0)) == null) ? null : itemAt.getText();
            if (text == null || text.length() == 0 || !lb().Y0(text.toString())) {
                return null;
            }
            List<String> listK = AbstractC11342cq6.K(AbstractC11342cq6.C(C20644sM5.e(new C20644sM5("\\d{4}[ -_*\\t\\n]*?\\d{4}[ -_*\\t\\n]*?\\d{4}[ -_*\\t\\n]*?\\d{4}"), text, 0, 2, null), new UA2() { // from class: ir.nasim.I63
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ir.nasim.features.payment.view.fragment.B.Ya((OU3) obj);
                }
            }));
            if (listK.isEmpty()) {
                return null;
            }
            for (String str : listK) {
                C20481s50 c20481s50 = C20481s50.a;
                if (c20481s50.g(str)) {
                    String strSubstring = XY6.k(str).substring(0, 6);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    if (c20481s50.c(strSubstring) != null && AbstractC13042fc3.d(CustomInputView.INSTANCE.a(str), Boolean.TRUE)) {
                        return str;
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xb(SA2 sa2, String str, Bundle bundle) {
        AbstractC13042fc3.i(sa2, "$onAuthenticationSuccessful");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "result");
        if (bundle.getBoolean("AuthenticationResult_Key", false)) {
            sa2.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Ya(OU3 ou3) {
        AbstractC13042fc3.i(ou3, "it");
        return ou3.getValue();
    }

    private final void Yb(final String destCardNumber, final BankCreditCard sourceCard, String amountValue, final String description) throws NumberFormatException {
        Integer numValueOf;
        C12149e73 c12149e73;
        String strA = ZY6.a(destCardNumber);
        final long j2 = Long.parseLong(ZY6.a(amountValue));
        final C10333bU0 c10333bU0 = new C10333bU0();
        y.Companion companion = y.INSTANCE;
        FragmentManager fragmentManagerB0 = Q7().B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        companion.b(c10333bU0, fragmentManagerB0, null);
        if (bc()) {
            C11458d25 c11458d25 = this.peer;
            numValueOf = c11458d25 != null ? Integer.valueOf(c11458d25.getPeerId()) : null;
        } else {
            numValueOf = null;
        }
        C12149e73 c12149e732 = this.viewModel;
        if (c12149e732 == null) {
            AbstractC13042fc3.y("viewModel");
            c12149e73 = null;
        } else {
            c12149e73 = c12149e732;
        }
        String id = sourceCard.getId();
        if (id == null) {
            id = "";
        }
        c12149e73.x0(id, GY6.b(strA), (int) j2, this.messageData, numValueOf).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Q63
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.payment.view.fragment.B.Zb(c10333bU0, this, sourceCard, destCardNumber, j2, description, (SapOuterClass$ResponseGetDestinationCardInfo) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.R63
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.features.payment.view.fragment.B.ac(this.a, c10333bU0, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Za() {
        if (this.isConfigLoaded) {
            kb().t.scrollTo(0, 0);
            dc();
            AbstractC16494lN1.a(this.loadingInitData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zb(C10333bU0 c10333bU0, B b2, BankCreditCard bankCreditCard, String str, long j2, String str2, SapOuterClass$ResponseGetDestinationCardInfo sapOuterClass$ResponseGetDestinationCardInfo) {
        C11458d25 c11458d25;
        AbstractC13042fc3.i(c10333bU0, "$loadingDialogFragment");
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$sourceCard");
        AbstractC13042fc3.i(str, "$destCardNumber");
        AbstractC13042fc3.i(str2, "$description");
        AbstractC16494lN1.a(c10333bU0);
        Iterator it = b2.lb().h1().iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (AbstractC13042fc3.d(ZY6.a(b2.kb().q.getText().toString()), ((BankCreditCard) it.next()).getNumber())) {
                z = true;
            }
        }
        ir.nasim.core.modules.banking.l lVarA = ir.nasim.core.modules.banking.l.a(bankCreditCard.getNumber());
        ir.nasim.core.modules.banking.l lVarA2 = ir.nasim.core.modules.banking.l.a(str);
        Long lValueOf = Long.valueOf(j2);
        String cardHolderName = sapOuterClass$ResponseGetDestinationCardInfo.getCardHolderName();
        AbstractC13042fc3.h(cardHolderName, "getCardHolderName(...)");
        String approvalCode = sapOuterClass$ResponseGetDestinationCardInfo.getApprovalCode();
        AbstractC13042fc3.h(approvalCode, "getApprovalCode(...)");
        String number = bankCreditCard.getNumber();
        String id = bankCreditCard.getId();
        AbstractC13042fc3.f(id);
        C23076wJ1 c23076wJ1 = new C23076wJ1(lVarA, lVarA2, lValueOf, false, cardHolderName, approvalCode, str, number, id, str2, b2.messageData, (!b2.bc() || (c11458d25 = b2.peer) == null) ? null : Integer.valueOf(c11458d25.getPeerId()));
        Bank bank = b2.destBank;
        AbstractC13042fc3.f(bank);
        b2.Tb(c23076wJ1, bank, bankCreditCard, str2, z);
        C3343Am.g("c2c_verify_successful");
    }

    private final void a0(String cardNumber) {
        kb().q.setMaxLength(19);
        kb().q.setText(cardNumber);
        kb().q.setErrorStroke(false);
    }

    private final void ab(BankCreditCard card) {
        if (!lb().o1()) {
            C7183Qq.q(EnumC18608ow5.g).g("last_request_is_reactivate", false);
        } else if (AbstractC5969Lp4.d().w0(EnumC4716Gg2.Q3)) {
            Rb(card);
        } else {
            Sb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ac(B b2, C10333bU0 c10333bU0, Exception exc) {
        String strC;
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(c10333bU0, "$loadingDialogFragment");
        if ((exc instanceof RpcException) && ((RpcException) exc).getCode() == 15) {
            b2.lb().m1();
        }
        AbstractC16494lN1.a(c10333bU0);
        if (!(exc instanceof DuplicateTransactionException)) {
            String localizedMessage = exc.getLocalizedMessage();
            if (localizedMessage != null) {
                Context contextS7 = b2.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                strC = GY6.c(localizedMessage, contextS7);
            } else {
                strC = null;
            }
            if (strC == null) {
                strC = "";
            }
            b2.mc(strC);
        }
        C3343Am.g("c2c_verify_failure");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0167 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void bb() throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.payment.view.fragment.B.bb():void");
    }

    private final boolean bc() {
        b bVar = this.type;
        if (bVar == null) {
            AbstractC13042fc3.y("type");
            bVar = null;
        }
        return bVar == b.a && this.peer != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cb(B b2, String str, String str2) {
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(str, "$srcNumber");
        if (str2 == null || str2.length() == 0) {
            String strH6 = b2.h6(AbstractC12217eE5.user_default_card_not_found);
            AbstractC13042fc3.h(strH6, "getString(...)");
            b2.mc(strH6);
        } else {
            String strSubstring = AbstractC20153rZ6.M(str2, Separators.SP, "", false, 4, null).substring(0, 6);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            b2.destBank = b2.Wa(strSubstring);
            b2.destinationCardNumber = str2;
            AbstractC13042fc3.f(str2);
            b2.nb(str, GY6.b(str2));
        }
    }

    private final void cc(C21231tK7 userVm) throws Resources.NotFoundException {
        String string;
        try {
            Avatar avatar = (Avatar) userVm.h().b();
            if (avatar != null && avatar.getSmallImage() != null) {
                Object objB = userVm.h().b();
                AbstractC13042fc3.h(objB, "get(...)");
                AvatarImage avatarImageMb = mb((Avatar) objB);
                FileReference fileReference = avatarImageMb != null ? avatarImageMb.getFileReference() : null;
                if (fileReference != null) {
                    AbstractC5969Lp4.d().q(fileReference, true, new k());
                }
            }
            Object objB2 = userVm.r().b();
            AbstractC13042fc3.h(objB2, "get(...)");
            kb().x.setText(((CharSequence) objB2).length() == 0 ? (String) userVm.r().b() : String.valueOf(((String) userVm.r().b()).charAt(0)));
            kb().i.setText((CharSequence) userVm.r().b());
            String[] strArr = {h6(TA5.placeholder_0), h6(TA5.placeholder_1), h6(TA5.placeholder_2), h6(TA5.placeholder_3), h6(TA5.placeholder_4), h6(TA5.placeholder_5), h6(TA5.placeholder_6)};
            try {
                if (userVm.o() == 0) {
                    string = b6().getString(TA5.placeholder_empty);
                    AbstractC13042fc3.f(string);
                } else {
                    string = strArr[Math.abs(userVm.o()) % 7];
                    AbstractC13042fc3.f(string);
                }
                kb().w.getBackground().setColorFilter(Color.parseColor(string), PorterDuff.Mode.SRC_ATOP);
            } catch (Exception e2) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            }
            kb().q.setVisibility(4);
        } catch (Exception e3) {
            C19406qI3.i("InformationFragment", e3.getLocalizedMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 db(B b2, C13944h50 c13944h50) {
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(c13944h50, "btn");
        b2.Ob(c13944h50);
        return C19938rB7.a;
    }

    private final void dc() {
        if (this.loadDefaultCard) {
            return;
        }
        BankCreditCard bankCreditCardG1 = lb().g1();
        if (bankCreditCardG1 != null) {
            this.ignoreFocusNextInput = true;
            kb().r.setText(bankCreditCardG1.getNumber());
        }
        String str = this.destinationCardNumber;
        if (str != null && !AbstractC20762sZ6.n0(str)) {
            this.ignoreFocusNextInput = true;
            kb().q.setText(this.destinationCardNumber);
        }
        sb();
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.H63
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.payment.view.fragment.B.ec(this.a);
            }
        }, 100L);
        this.loadDefaultCard = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 eb(B b2, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        b2.Mb(bankCreditCard);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ec(B b2) {
        AbstractC13042fc3.i(b2, "this$0");
        b2.kb().q.clearFocus();
        b2.kb().r.clearFocus();
        b2.kb().o.clearFocus();
        b2.kb().t.scrollTo(0, 0);
        b2.ignoreFocusNextInput = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 fb(B b2, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        b2.Kb(bankCreditCard);
        return C19938rB7.a;
    }

    private final void fc(ArrayList list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList.add(list.get(0));
            arrayList.add(list.get(1));
            String strH6 = h6(AbstractC12217eE5.card_payment_show_all_destination_card);
            AbstractC13042fc3.h(strH6, "getString(...)");
            arrayList.add(new C13944h50(2950, strH6));
        } else {
            arrayList.addAll(list);
        }
        this.destSuggestAdapter.B(arrayList);
        this.destSuggestAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 gb(B b2, String str) {
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(str, ParameterNames.CARD);
        b2.Nb(str);
        b2.lb().q1(str);
        return C19938rB7.a;
    }

    static /* synthetic */ void gc(B b2, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = b2.lb().h1();
        }
        b2.fc(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String hb(B b2) {
        AbstractC13042fc3.i(b2, "this$0");
        return b2.Xa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hc(ArrayList cards) {
        kb().j.setPreserveColor(true);
        try {
            if (this.peer == null && (!cards.isEmpty())) {
                ib(kb().q.getText().toString());
            }
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ib(String cardNumber) {
        if (Fb()) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (BankCreditCard bankCreditCard : lb().h1()) {
                try {
                    if (AbstractC20153rZ6.S(bankCreditCard.getNumber(), XY6.h(AbstractC20153rZ6.M(cardNumber, Separators.SP, "", false, 4, null)), false, 2, null)) {
                        arrayList.add(bankCreditCard);
                    }
                } catch (Exception e2) {
                    C19406qI3.d("NON_FATAL_EXCEPTION", e2);
                }
            }
            fc(arrayList);
        } catch (Exception e3) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e3);
        }
    }

    static /* synthetic */ void ic(B b2, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = b2.lb().h1();
        }
        b2.hc(arrayList);
    }

    private final void jc(ArrayList list) {
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
        this.sourceSuggestAdapter.B(arrayList);
        this.sourceSuggestAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C16259ky2 kb() {
        return (C16259ky2) this.binding.a(this, I1[0]);
    }

    static /* synthetic */ void kc(B b2, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = b2.lb().k1();
        }
        b2.jc(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3641Bs4 lb() {
        return (C3641Bs4) this.cardsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void lc(ArrayList cards) {
        try {
            if (!cards.isEmpty()) {
                sc(kb().r.getText().toString(), cards);
            }
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    private final AvatarImage mb(Avatar avatar) {
        return C22078ud6.a(80.0f) >= 100 ? avatar.getLargeImage() : avatar.getSmallImage();
    }

    private final void nb(String srcNumber, final String destNumber) {
        final C12889fL5 c12889fL5 = new C12889fL5();
        for (BankCreditCard bankCreditCard : lb().k1()) {
            if (AbstractC13042fc3.d(GY6.b(bankCreditCard.getNumber()), GY6.b(srcNumber))) {
                c12889fL5.a = bankCreditCard;
            }
        }
        BankCreditCard bankCreditCard2 = (BankCreditCard) c12889fL5.a;
        if (bankCreditCard2 != null && bankCreditCard2.isEnrolled() && lb().o1()) {
            ab(bankCreditCard2);
            return;
        }
        BankCreditCard bankCreditCard3 = (BankCreditCard) c12889fL5.a;
        boolean z = false;
        if (bankCreditCard3 != null && bankCreditCard3.isEnrolled()) {
            z = true;
        }
        if (!(!z)) {
            final SA2 sa2 = new SA2() { // from class: ir.nasim.N63
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return ir.nasim.features.payment.view.fragment.B.pb(this.a, destNumber, c12889fL5);
                }
            };
            C12149e73 c12149e73 = this.viewModel;
            if (c12149e73 == null) {
                AbstractC13042fc3.y("viewModel");
                c12149e73 = null;
            }
            c12149e73.V0(new UA2() { // from class: ir.nasim.O63
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ir.nasim.features.payment.view.fragment.B.qb(this.a, sa2, ((Boolean) obj).booleanValue());
                }
            });
            return;
        }
        y.Companion companion = y.INSTANCE;
        BankCreditCard bankCreditCard4 = (BankCreditCard) c12889fL5.a;
        if (bankCreditCard4 == null) {
            bankCreditCard4 = new BankCreditCard(null, srcNumber, null, null, null, null, false, BankCreditCard.c.a, false, false, false, 1917, null);
        }
        y yVarA = companion.a(bankCreditCard4);
        FragmentManager fragmentManagerB0 = Q7().B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        companion.b(yVarA, fragmentManagerB0, "EnrollmentCardFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 nc(B b2, C13944h50 c13944h50) {
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(c13944h50, "btn");
        b2.Ob(c13944h50);
        return C19938rB7.a;
    }

    static /* synthetic */ void ob(B b2, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = GY6.b(b2.kb().q.getText().toString());
        }
        b2.nb(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 oc(B b2, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        b2.Pb(bankCreditCard);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pb(B b2, String str, C12889fL5 c12889fL5) throws NumberFormatException {
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(str, "$destNumber");
        AbstractC13042fc3.i(c12889fL5, "$creditCard");
        Object obj = c12889fL5.a;
        AbstractC13042fc3.f(obj);
        b2.Yb(str, (BankCreditCard) obj, b2.kb().o.getText().toString(), new C20644sM5("\n\n+").k(AbstractC20762sZ6.n1(b2.kb().p.getText().toString()).toString(), Separators.RETURN));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pc(B b2, BankCreditCard bankCreditCard) {
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        b2.Lb(bankCreditCard);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qb(B b2, SA2 sa2, boolean z) {
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(sa2, "$cardToCardAction");
        if (z) {
            b2.Va(sa2);
        } else {
            sa2.invoke();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qc(B b2, String str) {
        AbstractC13042fc3.i(b2, "this$0");
        AbstractC13042fc3.i(str, ParameterNames.CARD);
        b2.Qb(str);
        b2.lb().q1(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rb() {
        ArrayList arrayList = new ArrayList();
        CardToCardConfig cardToCardConfig = this.config;
        if (cardToCardConfig == null) {
            AbstractC13042fc3.y("config");
            cardToCardConfig = null;
        }
        for (Bank bank : cardToCardConfig.getBankList()) {
            if (bank.getSourceStatus().isEnable()) {
                arrayList.add(bank);
            }
        }
        this.bankLogoAdapter.B(arrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(S7(), 0, false);
        kb().y.setLayoutManager(linearLayoutManager);
        kb().y.setAdapter(this.bankLogoAdapter);
        kb().y.addItemDecoration(new C22527vO3(16, 16, 10, 0, 0, 24, null));
        kb().y.addOnScrollListener(new e(linearLayoutManager, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String rc(B b2) {
        AbstractC13042fc3.i(b2, "this$0");
        return b2.Xa();
    }

    private final void sb() {
        CustomInputView customInputView = kb().o;
        AbstractC13042fc3.h(customInputView, "inputAmount");
        Ta(customInputView);
        CustomInputView customInputView2 = kb().p;
        AbstractC13042fc3.h(customInputView2, "inputDescription");
        Ta(customInputView2);
        kb().r.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.J63
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ir.nasim.features.payment.view.fragment.B.tb(this.a, view, z);
            }
        });
        kb().q.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.L63
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ir.nasim.features.payment.view.fragment.B.ub(this.a, view, z);
            }
        });
    }

    private final void sc(String cardNumber, ArrayList sourceSuggestList) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = sourceSuggestList.iterator();
            while (it.hasNext()) {
                BankCreditCard bankCreditCard = (BankCreditCard) it.next();
                try {
                    if (AbstractC20153rZ6.S(bankCreditCard.getNumber(), XY6.h(AbstractC20153rZ6.M(cardNumber, Separators.SP, "", false, 4, null)), false, 2, null)) {
                        arrayList.add(bankCreditCard);
                    }
                    jc(arrayList);
                } catch (Exception e2) {
                    C19406qI3.d("NON_FATAL_EXCEPTION", e2);
                }
            }
        } catch (Exception e3) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tb(B b2, View view, boolean z) {
        AbstractC13042fc3.i(b2, "this$0");
        if (!z) {
            b2.kb().z.setVisibility(8);
            return;
        }
        b2.kb().t.V((int) b2.kb().r.getX(), (int) b2.kb().r.getY());
        if (b2.kb().r.getText().toString().length() == 0) {
            kc(b2, null, 1, null);
        }
        b2.kb().z.setVisibility(0);
    }

    static /* synthetic */ void tc(B b2, String str, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            arrayList = b2.lb().k1();
        }
        b2.sc(str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ub(B b2, View view, boolean z) {
        AbstractC13042fc3.i(b2, "this$0");
        if (!z) {
            b2.kb().k.setVisibility(8);
            return;
        }
        b2.kb().t.V((int) b2.kb().q.getX(), (int) b2.kb().q.getY());
        if (b2.kb().q.getText().toString().length() == 0) {
            gc(b2, null, 1, null);
        }
        b2.kb().k.setVisibility(0);
    }

    private final void vb() throws Resources.NotFoundException {
        QI2 qi2 = QI2.a;
        RoundedImageView roundedImageView = kb().b;
        AbstractC13042fc3.h(roundedImageView, "avatarImg");
        qi2.a(roundedImageView);
        C11458d25 c11458d25 = this.peer;
        if (c11458d25 != null) {
            b bVar = null;
            if ((c11458d25 != null ? Integer.valueOf(c11458d25.getPeerId()) : null) != null) {
                b bVar2 = this.type;
                if (bVar2 == null) {
                    AbstractC13042fc3.y("type");
                    bVar2 = null;
                }
                if (bVar2 != b.b) {
                    b bVar3 = this.type;
                    if (bVar3 == null) {
                        AbstractC13042fc3.y("type");
                    } else {
                        bVar = bVar3;
                    }
                    if (bVar != b.c) {
                        C11335cq c11335cqD = AbstractC5969Lp4.d();
                        C11458d25 c11458d252 = this.peer;
                        AbstractC13042fc3.f(c11458d252);
                        C21231tK7 c21231tK7I0 = c11335cqD.i0(c11458d252.getPeerId());
                        if (c21231tK7I0 != null) {
                            cc(c21231tK7I0);
                            return;
                        } else {
                            kb().k.setVisibility(8);
                            kb().v.setVisibility(8);
                            return;
                        }
                    }
                }
            }
        }
        kb().k.setVisibility(8);
        kb().v.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void wb() throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.payment.view.fragment.B.wb():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xb(B b2, View view) throws Resources.NotFoundException {
        AbstractC13042fc3.i(b2, "this$0");
        b2.peer = null;
        ic(b2, null, 1, null);
        b2.vb();
        b2.kb().q.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yb(B b2, View view) {
        AbstractC13042fc3.i(b2, "this$0");
        if (ZY6.a(b2.kb().q.getText().toString()).length() == 16) {
            b2.kb().q.setDrawableEndFirst(AbstractC4043Dl1.f(b2.S7(), KB5.ic_card_payment_contact));
            b2.kb().q.setText(null);
            b2.kb().q.setDrawableStart(AbstractC4043Dl1.f(b2.S7(), KB5.ic_card_payment_cardunknown_icon_classic));
            b2.kb().k.setVisibility(8);
            return;
        }
        BaleContactPickerActivity.Companion aVar = BaleContactPickerActivity.INSTANCE;
        Context contextS7 = b2.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        b2.startActivityForResult(aVar.a(contextS7, 2001), 20011);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zb(B b2, View view) {
        AbstractC13042fc3.i(b2, "this$0");
        b2.kb().r.setDrawableEndFirst(null);
        b2.kb().r.setText(null);
        b2.kb().r.setDrawableStart(AbstractC4043Dl1.f(b2.S7(), KB5.ic_card_payment_cardunknown_icon_classic));
        b2.kb().z.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        Integer num;
        super.H6(requestCode, resultCode, data);
        C12149e73 c12149e73 = null;
        try {
            if (requestCode != 2) {
                if (requestCode == 3) {
                    if (resultCode != -1) {
                        AbstractC16494lN1.a(this.loadingInitData);
                        return;
                    }
                    C10333bU0 c10333bU0 = this.loadingInitData;
                    FragmentManager fragmentManagerB0 = Q7().B0();
                    AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
                    AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
                    return;
                }
                if (requestCode != 20011) {
                    return;
                }
                try {
                    AbstractC13042fc3.f(data);
                    ArrayList<Integer> integerArrayListExtra = data.getIntegerArrayListExtra("USER_LIST");
                    if (integerArrayListExtra == null || (num = integerArrayListExtra.get(0)) == null) {
                        return;
                    }
                    this.peer = C11458d25.r(num.intValue());
                    ic(this, null, 1, null);
                    vb();
                    kb().v.setVisibility(0);
                    return;
                } catch (Exception e2) {
                    C19406qI3.d("NON_FATAL_EXCEPTION", e2);
                    return;
                }
            }
            AbstractC16494lN1.a(this.loadingInitData);
            ConstraintLayout constraintLayoutB = kb().getRoot();
            AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
            C17468n10 c17468n10 = new C17468n10(constraintLayoutB, null, 0, 6, null);
            c17468n10.k(kb().j);
            if (resultCode != -1) {
                if (resultCode != 0) {
                    return;
                }
                String strH6 = h6(AbstractC12217eE5.card_do_not_authentication);
                AbstractC13042fc3.h(strH6, "getString(...)");
                c17468n10.o(strH6);
                return;
            }
            C3641Bs4 c3641Bs4Lb = lb();
            C12149e73 c12149e732 = this.viewModel;
            if (c12149e732 == null) {
                AbstractC13042fc3.y("viewModel");
            } else {
                c12149e73 = c12149e732;
            }
            c3641Bs4Lb.t1(c12149e73.Y());
            if (C7183Qq.q(EnumC18608ow5.g).h("last_request_is_reactivate", true)) {
                String strH62 = h6(AbstractC12217eE5.authentication_is_success);
                AbstractC13042fc3.h(strH62, "getString(...)");
                c17468n10.o(strH62);
            } else {
                String strH63 = h6(AbstractC12217eE5.card_registered);
                AbstractC13042fc3.h(strH63, "getString(...)");
                c17468n10.o(strH63);
            }
        } catch (Exception e3) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        AbstractC18623oy2.d(this, "card_clicked", new InterfaceC14603iB2() { // from class: ir.nasim.Y63
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return ir.nasim.features.payment.view.fragment.B.Jb(this.a, (String) obj, (Bundle) obj2);
            }
        });
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.type = b.values()[bundleE5.getInt("TYPE_PARAM", 0)];
            if (bundleE5.getParcelable("MESSAGE_DATA_PARAM") != null) {
                this.messageData = (HistoryMessageData) bundleE5.getParcelable("MESSAGE_DATA_PARAM");
            }
            if (bundleE5.getLong("PEER_ID_PARAM", -1L) != -1) {
                this.peer = C11458d25.r(bundleE5.getLong("PEER_ID_PARAM"));
            }
            this.destinationCardNumber = bundleE5.getString("DESTINATION_CARD_NUMBER_PARAM");
            if (bundleE5.getLong("AMOUNT_PARAM", -1L) != -1) {
                this.amount = Long.valueOf(bundleE5.getLong("AMOUNT_PARAM"));
            }
            if (bundleE5.getByteArray("MESSAGE_PARAM") != null) {
                this.message = J44.v.a(bundleE5.getByteArray("MESSAGE_PARAM"));
            }
        }
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C12149e73 c12149e73 = (C12149e73) new androidx.lifecycle.G(fragmentActivityQ7).b(C12149e73.class);
        this.viewModel = c12149e73;
        if (c12149e73 == null) {
            AbstractC13042fc3.y("viewModel");
            c12149e73 = null;
        }
        c12149e73.S0();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout constraintLayoutB = C16259ky2.c(inflater).getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        return constraintLayoutB;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        CountDownTimer countDownTimer = this.verifyTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        if (kb().k.getVisibility() != 0 && kb().z.getVisibility() != 0) {
            return true;
        }
        kb().k.setVisibility(8);
        kb().z.setVisibility(8);
        return super.a();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        super.c7();
        this.autoScrollHandler.removeCallbacks(this.autoScrollRunnable);
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        this.autoScrollHandler.postDelayed(this.autoScrollRunnable, 0L);
    }

    @Override // androidx.fragment.app.Fragment
    public void i7(Bundle outState) {
        AbstractC13042fc3.i(outState, "outState");
        super.i7(outState);
        KS2 ks2 = new KS2();
        CardToCardConfig cardToCardConfig = this.config;
        if (cardToCardConfig == null) {
            AbstractC13042fc3.y("config");
            cardToCardConfig = null;
        }
        outState.putString(CardToCardConfig.CONFIG_KEY, ks2.t(cardToCardConfig));
    }

    public final InterfaceC23146wR jb() {
        InterfaceC23146wR interfaceC23146wR = this.authenticatorNavigator;
        if (interfaceC23146wR != null) {
            return interfaceC23146wR;
        }
        AbstractC13042fc3.y("authenticatorNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) throws Resources.NotFoundException {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        AbstractC16751lo1.a(this).b(new h(null));
        AbstractC16751lo1.a(this).b(new i(null));
        wb();
        Db();
        Eb();
    }

    public final void m3(String cardNumber) {
        AbstractC13042fc3.i(cardNumber, "cardNumber");
        kb().r.setMaxLength(19);
        kb().r.setText(cardNumber);
        kb().r.setErrorStroke(false);
    }

    public final void mc(String description) {
        AbstractC13042fc3.i(description, "description");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-652540620, true, new l(description)), 4, null).show();
    }
}
