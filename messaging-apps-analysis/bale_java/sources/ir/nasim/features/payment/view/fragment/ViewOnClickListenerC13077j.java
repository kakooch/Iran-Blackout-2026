package ir.nasim.features.payment.view.fragment;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC11342cq6;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13463gG6;
import ir.nasim.AbstractC15985kW2;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC17457n0;
import ir.nasim.AbstractC17543n85;
import ir.nasim.AbstractC18623oy2;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC19555qZ;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC24063xz;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4277El1;
import ir.nasim.AbstractC4808Gq4;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C10333bU0;
import ir.nasim.C11458d25;
import ir.nasim.C11909dl1;
import ir.nasim.C13353g50;
import ir.nasim.C13396g93;
import ir.nasim.C13944h50;
import ir.nasim.C16247kx;
import ir.nasim.C17468n10;
import ir.nasim.C18987pb3;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C20481s50;
import ir.nasim.C20514s83;
import ir.nasim.C20644sM5;
import ir.nasim.C21753u45;
import ir.nasim.C22055ub3;
import ir.nasim.C23381wp3;
import ir.nasim.C3343Am;
import ir.nasim.C4053Dm2;
import ir.nasim.C4100Dr4;
import ir.nasim.C5354Iz1;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C7653Sq1;
import ir.nasim.C7717Sx2;
import ir.nasim.C8563Wm6;
import ir.nasim.ED1;
import ir.nasim.EnumC16838lx;
import ir.nasim.EnumC4716Gg2;
import ir.nasim.GC6;
import ir.nasim.GY6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC14778iT2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18060o11;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.InterfaceC21074t40;
import ir.nasim.InterfaceC21545tj3;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC22409vB2;
import ir.nasim.InterfaceC8360Vq1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.J44;
import ir.nasim.KB5;
import ir.nasim.KS2;
import ir.nasim.OU3;
import ir.nasim.QG4;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.UY6;
import ir.nasim.V31;
import ir.nasim.XY6;
import ir.nasim.ZY6;
import ir.nasim.components.textfield.view.CustomInputView;
import ir.nasim.core.modules.messaging.entity.content.CrowdfundingContentInfo;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.model.SelectableOption;
import ir.nasim.features.payment.data.response.Bank;
import ir.nasim.features.payment.data.response.CardToCardConfig;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import ir.nasim.features.payment.view.activity.CrowdfundingActivity;
import ir.nasim.features.payment.view.fragment.C13069b;
import ir.nasim.features.payment.view.fragment.SelectableOptionsFragment;
import ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13077j;
import ir.nasim.features.payment.view.fragment.x;
import ir.nasim.features.payment.widget.LockableNestedScrollView;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u001f*\u0002É\u0001\b\u0007\u0018\u0000 å\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0002æ\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\nJ\u000f\u0010\u0014\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\nJ\u0017\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\nJ\u000f\u0010\u001d\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\u0000H\u0002¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\u0000H\u0002¢\u0006\u0004\b!\u0010\u001eJ\u000f\u0010\"\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\"\u0010\u001eJ\u001b\u0010$\u001a\u00020\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b$\u0010\u0012J\u000f\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b%\u0010\nJ\u0017\u0010'\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0019H\u0002¢\u0006\u0004\b'\u0010(J7\u0010.\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00190)j\b\u0012\u0004\u0012\u00020\u0019`*2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0019H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0010H\u0002¢\u0006\u0004\b2\u0010\nJ\u000f\u00103\u001a\u00020\u0010H\u0002¢\u0006\u0004\b3\u0010\nJ\u000f\u00104\u001a\u00020\u0010H\u0002¢\u0006\u0004\b4\u0010\nJ\u000f\u00105\u001a\u00020\u0010H\u0002¢\u0006\u0004\b5\u0010\nJ\u000f\u00106\u001a\u00020\u0010H\u0002¢\u0006\u0004\b6\u0010\nJ\u0017\u00108\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u000bH\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0010H\u0002¢\u0006\u0004\b:\u0010\nJ\u0017\u0010=\u001a\u00020\u00102\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0?H\u0002¢\u0006\u0004\b@\u0010AJ\u0019\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010B\u001a\u00020\u000bH\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u000bH\u0002¢\u0006\u0004\bG\u00109J'\u0010J\u001a\u00020\u00102\u0016\u0010I\u001a\u0012\u0012\u0004\u0012\u00020H0)j\b\u0012\u0004\u0012\u00020H`*H\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0010H\u0002¢\u0006\u0004\bL\u0010\nJ7\u0010Q\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010P\u001a\u00020O2\u0006\u0010F\u001a\u00020\u000bH\u0002¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\u0010H\u0002¢\u0006\u0004\bS\u0010\nJ\u000f\u0010T\u001a\u00020\u0010H\u0002¢\u0006\u0004\bT\u0010\nJ\u001f\u0010U\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000bH\u0002¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u00020\u00102\u0006\u0010W\u001a\u00020,H\u0002¢\u0006\u0004\bX\u0010YJ\u0017\u0010\\\u001a\u00020\u00102\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b\\\u0010]J\u0019\u0010`\u001a\u00020\u00102\b\u0010_\u001a\u0004\u0018\u00010^H\u0016¢\u0006\u0004\b`\u0010aJ!\u0010d\u001a\u00020\u00102\u0006\u0010c\u001a\u00020b2\b\u0010_\u001a\u0004\u0018\u00010^H\u0016¢\u0006\u0004\bd\u0010eJ\u0017\u0010g\u001a\u00020\u00102\u0006\u0010f\u001a\u00020^H\u0016¢\u0006\u0004\bg\u0010aJ\u000f\u0010h\u001a\u00020\u0010H\u0016¢\u0006\u0004\bh\u0010\nJ\u0019\u0010j\u001a\u00020\u00102\b\u0010i\u001a\u0004\u0018\u00010bH\u0016¢\u0006\u0004\bj\u0010kJ)\u0010q\u001a\u00020\u00102\u0006\u0010m\u001a\u00020l2\u0006\u0010n\u001a\u00020l2\b\u0010p\u001a\u0004\u0018\u00010oH\u0016¢\u0006\u0004\bq\u0010rJ\u0017\u0010t\u001a\u00020\u00102\u0006\u0010s\u001a\u00020HH\u0016¢\u0006\u0004\bt\u0010uJ\u0017\u0010v\u001a\u00020\u00102\u0006\u0010s\u001a\u00020HH\u0016¢\u0006\u0004\bv\u0010uJ\u0017\u0010y\u001a\u00020\u00102\u0006\u0010x\u001a\u00020wH\u0016¢\u0006\u0004\by\u0010zJ\u0017\u0010{\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u000bH\u0016¢\u0006\u0004\b{\u00109J\u0017\u0010|\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u000bH\u0016¢\u0006\u0004\b|\u00109J\u000f\u0010}\u001a\u00020\u0010H\u0016¢\u0006\u0004\b}\u0010\nJ\u000f\u0010~\u001a\u00020,H\u0016¢\u0006\u0004\b~\u0010\u007fJ\u0011\u0010\u0080\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0005\b\u0080\u0001\u0010\nJ1\u0010\u0086\u0001\u001a\u00020\u00022\b\u0010\u0082\u0001\u001a\u00030\u0081\u00012\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00012\u0007\u0010\u0085\u0001\u001a\u00020,H\u0016¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0017\u0010\u008e\u0001\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0017\u0010\u0090\u0001\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u008d\u0001R\u0017\u0010\u0092\u0001\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u008d\u0001R\u0017\u0010\u0094\u0001\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u008d\u0001R\u0017\u0010\u0096\u0001\u001a\u00020\u000b8\u0002X\u0082D¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u008d\u0001R\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0019\u0010\u009d\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R'\u0010¢\u0001\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0005\b \u0001\u0010\u007f\"\u0005\b¡\u0001\u0010YR!\u0010¨\u0001\u001a\u00030£\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001R\u001d\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190)8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R \u0010®\u0001\u001a\u000b ¬\u0001*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0001\u0010\u008d\u0001R\u001b\u0010°\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010\u008d\u0001R\u001b\u0010²\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010\u008d\u0001R\u001a\u0010¶\u0001\u001a\u00030³\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u001b\u0010¹\u0001\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u0018\u0010½\u0001\u001a\u00030º\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u001d\u0010¿\u0001\u001a\b\u0012\u0004\u0012\u00020H0)8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010ª\u0001R\u001a\u0010Ã\u0001\u001a\u00030À\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R!\u0010È\u0001\u001a\u00030Ä\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÅ\u0001\u0010¥\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0018\u0010Ì\u0001\u001a\u00030É\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u001b\u0010Ï\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R\u001b\u0010Ò\u0001\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R&\u0010M\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÓ\u0001\u0010\u008d\u0001\u001a\u0005\bÔ\u0001\u0010\r\"\u0005\bÕ\u0001\u00109R&\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b~\u0010\u009c\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0005\bØ\u0001\u0010\u0018R&\u0010F\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÙ\u0001\u0010\u008d\u0001\u001a\u0005\bÚ\u0001\u0010\r\"\u0005\bÛ\u0001\u00109R&\u0010N\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÜ\u0001\u0010\u008d\u0001\u001a\u0005\bÝ\u0001\u0010\r\"\u0005\bÞ\u0001\u00109R(\u0010P\u001a\u00020O8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bß\u0001\u0010à\u0001\u001a\u0006\bá\u0001\u0010â\u0001\"\u0006\bã\u0001\u0010ä\u0001¨\u0006ç\u0001"}, d2 = {"Lir/nasim/features/payment/view/fragment/j;", "Lir/nasim/La0;", "Lir/nasim/Sx2;", "Landroid/view/View$OnClickListener;", "Lir/nasim/t40;", "Lir/nasim/g50$d;", "Lir/nasim/g50$e;", "Lir/nasim/g50$c;", "Lir/nasim/features/payment/view/activity/CardPaymentActivity$b;", "<init>", "()V", "", "l9", "()Ljava/lang/String;", "Lir/nasim/tj3;", "jobListener", "Lir/nasim/rB7;", "o9", "(Lir/nasim/tj3;)V", "X9", "n9", "", "amount", "K9", "(J)V", "Lir/nasim/features/payment/data/model/SelectableOption;", "q9", "(J)Lir/nasim/features/payment/data/model/SelectableOption;", "E9", "F9", "()Lir/nasim/features/payment/view/fragment/j;", "G9", "x9", "C9", "D9", "listener", "y9", "ga", "item", "ba", "(Lir/nasim/features/payment/data/model/SelectableOption;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "quotaList", "", "fullExpandOpen", "ja", "(JLjava/util/ArrayList;Z)V", "ca", "(JLir/nasim/features/payment/data/model/SelectableOption;)V", "h9", "V9", "j9", "W9", "U9", "path", "ea", "(Ljava/lang/String;)V", "aa", "Lir/nasim/components/textfield/view/CustomInputView;", "inputViewView", "M9", "(Lir/nasim/components/textfield/view/CustomInputView;)V", "Landroidx/lifecycle/r;", "r9", "()Landroidx/lifecycle/r;", "pattern", "Lir/nasim/features/payment/data/response/Bank;", "k9", "(Ljava/lang/String;)Lir/nasim/features/payment/data/response/Bank;", "cardNumber", "la", "Lir/nasim/features/payment/data/model/BankCreditCard;", "list", "fa", "(Ljava/util/ArrayList;)V", "oa", "title", "description", "Ljava/util/Date;", "endTime", "da", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/Date;Ljava/lang/String;)V", "ha", "v9", "p9", "(Ljava/lang/String;Ljava/lang/String;)V", "enable", "O9", "(Z)V", "Landroid/content/Context;", "context", "J6", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "outState", "i7", "h7", "v", "onClick", "(Landroid/view/View;)V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", ParameterNames.CARD, "i5", "(Lir/nasim/features/payment/data/model/BankCreditCard;)V", "Z0", "Lir/nasim/h50;", "button", "t", "(Lir/nasim/h50;)V", "m3", "a0", "Q", "B1", "()Z", "k7", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "attachToParent", "t9", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lir/nasim/Sx2;", "Lir/nasim/iT2;", "d1", "Lir/nasim/iT2;", "handleInfoCallback", "e1", "Ljava/lang/String;", "durationKey", "f1", "quotaAmountKey", "g1", "amountKey", "h1", "photoPathKey", "i1", "photoNameKey", "Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", "j1", "Lir/nasim/core/modules/messaging/entity/content/CrowdfundingContentInfo;", "content", "k1", "J", "peerUniqueId", "l1", "Z", "getFromMyBank", "setFromMyBank", "fromMyBank", "Lir/nasim/Sq1;", "m1", "Lir/nasim/Yu3;", "u9", "()Lir/nasim/Sq1;", "viewModel", "n1", "Ljava/util/ArrayList;", "durationDaysList", "kotlin.jvm.PlatformType", "o1", "photoExternalFile", "p1", "photoPath", "q1", "photoName", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "r1", "Lir/nasim/features/payment/data/response/CardToCardConfig;", "config", "s1", "Lir/nasim/features/payment/data/response/Bank;", "destBank", "Lir/nasim/g50;", "t1", "Lir/nasim/g50;", "suggestAdapter", "u1", "suggestList", "Lir/nasim/bU0;", "v1", "Lir/nasim/bU0;", "loadingInitData", "Lir/nasim/n10;", "w1", "s9", "()Lir/nasim/n10;", "snackbar", "ir/nasim/features/payment/view/fragment/j$b", "x1", "Lir/nasim/features/payment/view/fragment/j$b;", "cardTextWatcher", "y1", "Ljava/lang/Long;", "quotaAmount", "z1", "Ljava/lang/Integer;", "durationDay", "A1", "getTitle", "setTitle", "getAmount", "()J", "setAmount", "C1", "getCardNumber", "setCardNumber", "D1", "getDescription", "setDescription", "E1", "Ljava/util/Date;", "getEndTime", "()Ljava/util/Date;", "setEndTime", "(Ljava/util/Date;)V", "F1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.features.payment.view.fragment.j, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class ViewOnClickListenerC13077j extends AbstractC15985kW2<C7717Sx2> implements View.OnClickListener, InterfaceC21074t40, C13353g50.d, C13353g50.e, C13353g50.c, CardPaymentActivity.b {

    /* renamed from: F1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int G1 = 8;

    /* renamed from: B1, reason: from kotlin metadata */
    private long amount;

    /* renamed from: d1, reason: from kotlin metadata */
    private InterfaceC14778iT2 handleInfoCallback;

    /* renamed from: j1, reason: from kotlin metadata */
    private CrowdfundingContentInfo content;

    /* renamed from: l1, reason: from kotlin metadata */
    private boolean fromMyBank;

    /* renamed from: p1, reason: from kotlin metadata */
    private String photoPath;

    /* renamed from: q1, reason: from kotlin metadata */
    private String photoName;

    /* renamed from: r1, reason: from kotlin metadata */
    private CardToCardConfig config;

    /* renamed from: s1, reason: from kotlin metadata */
    private Bank destBank;

    /* renamed from: y1, reason: from kotlin metadata */
    private Long quotaAmount;

    /* renamed from: z1, reason: from kotlin metadata */
    private Integer durationDay;

    /* renamed from: e1, reason: from kotlin metadata */
    private final String durationKey = "durationKey";

    /* renamed from: f1, reason: from kotlin metadata */
    private final String quotaAmountKey = "quotaAmountKey";

    /* renamed from: g1, reason: from kotlin metadata */
    private final String amountKey = "amountKey";

    /* renamed from: h1, reason: from kotlin metadata */
    private final String photoPathKey = "photoPathKey";

    /* renamed from: i1, reason: from kotlin metadata */
    private final String photoNameKey = "photoNameKey";

    /* renamed from: k1, reason: from kotlin metadata */
    private long peerUniqueId = -1;

    /* renamed from: m1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Cq1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ViewOnClickListenerC13077j.ta(this.a);
        }
    });

    /* renamed from: n1, reason: from kotlin metadata */
    private final ArrayList durationDaysList = new ArrayList();

    /* renamed from: o1, reason: from kotlin metadata */
    private final String photoExternalFile = C4053Dm2.l("capture", "jpg");

    /* renamed from: t1, reason: from kotlin metadata */
    private final C13353g50 suggestAdapter = new C13353g50(null, null, null, new UA2() { // from class: ir.nasim.Dq1
        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return ViewOnClickListenerC13077j.ma(this.a, (String) obj);
        }
    }, new SA2() { // from class: ir.nasim.Eq1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ViewOnClickListenerC13077j.na(this.a);
        }
    }, 7, null);

    /* renamed from: u1, reason: from kotlin metadata */
    private final ArrayList suggestList = new ArrayList();

    /* renamed from: v1, reason: from kotlin metadata */
    private C10333bU0 loadingInitData = new C10333bU0();

    /* renamed from: w1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 snackbar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Fq1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ViewOnClickListenerC13077j.ka(this.a);
        }
    });

    /* renamed from: x1, reason: from kotlin metadata */
    private final b cardTextWatcher = new b();

    /* renamed from: A1, reason: from kotlin metadata */
    private String title = "";

    /* renamed from: C1, reason: from kotlin metadata */
    private String cardNumber = "";

    /* renamed from: D1, reason: from kotlin metadata */
    private String description = "";

    /* renamed from: E1, reason: from kotlin metadata */
    private Date endTime = new Date();

    /* renamed from: ir.nasim.features.payment.view.fragment.j$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final ViewOnClickListenerC13077j a(CrowdfundingContentInfo crowdfundingContentInfo, long j, boolean z) {
            ViewOnClickListenerC13077j viewOnClickListenerC13077j = new ViewOnClickListenerC13077j();
            Bundle bundle = new Bundle();
            if (crowdfundingContentInfo != null) {
                bundle.putParcelable("param_data", crowdfundingContentInfo);
            }
            bundle.putBoolean("from_my_bank", z);
            bundle.putLong("param_peer_unique_id", j);
            viewOnClickListenerC13077j.a8(bundle);
            return viewOnClickListenerC13077j;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.j$b */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).o.setVisibility(0);
            if (editable != null) {
                if (ZY6.a(editable.toString()).length() < 6) {
                    ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).n.setMaxLength(-1);
                    ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).n.setErrorStroke(false);
                    ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).n.setDrawableStart(AbstractC4043Dl1.f(ViewOnClickListenerC13077j.this.S7(), KB5.ic_card_payment_cardunknown_icon_classic));
                    ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).n.setDrawableStartTint(ColorStateList.valueOf(C5495Jo7.a.L0()));
                } else if (ZY6.a(editable.toString()).length() >= 6) {
                    ViewOnClickListenerC13077j viewOnClickListenerC13077j = ViewOnClickListenerC13077j.this;
                    String strSubstring = AbstractC20153rZ6.M(editable.toString(), Separators.SP, "", false, 4, null).substring(0, 6);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    Bank bankK9 = viewOnClickListenerC13077j.k9(strSubstring);
                    if (bankK9 == null) {
                        ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).n.setMaxLength(7);
                        CustomInputView customInputView = ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).n;
                        String strH6 = ViewOnClickListenerC13077j.this.h6(AbstractC12217eE5.card_payment_missing_destination_card);
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        customInputView.setInputError(strH6);
                    } else {
                        if (editable.length() == 19) {
                            ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).n.setMaxLength(19);
                            ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).o.setVisibility(8);
                        }
                        if (bankK9.getDestinationStatus().isEnable()) {
                            ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).n.setErrorStroke(false);
                            ViewOnClickListenerC13077j.this.destBank = bankK9;
                        } else {
                            ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).n.setMaxLength(7);
                            CustomInputView customInputView2 = ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).n;
                            String strI6 = ViewOnClickListenerC13077j.this.i6(AbstractC12217eE5.card_payment_unable_dest, bankK9.getName());
                            AbstractC13042fc3.h(strI6, "getString(...)");
                            customInputView2.setStartDrawableError(strI6);
                        }
                        Drawable drawableF = null;
                        ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).n.setDrawableStartTint(null);
                        CustomInputView customInputView3 = ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).n;
                        Integer drawableId = bankK9.getDrawableId();
                        if (drawableId != null) {
                            ViewOnClickListenerC13077j viewOnClickListenerC13077j2 = ViewOnClickListenerC13077j.this;
                            drawableF = AbstractC4043Dl1.f(viewOnClickListenerC13077j2.S7(), drawableId.intValue());
                        }
                        customInputView3.setDrawableStart(drawableF);
                    }
                }
                ViewOnClickListenerC13077j.this.la(editable.toString());
            } else {
                ViewOnClickListenerC13077j viewOnClickListenerC13077j3 = ViewOnClickListenerC13077j.this;
                viewOnClickListenerC13077j3.fa(viewOnClickListenerC13077j3.suggestList);
                ViewOnClickListenerC13077j.this.suggestAdapter.notifyDataSetChanged();
            }
            if (editable == null || editable.length() == 0) {
                ((C7717Sx2) ViewOnClickListenerC13077j.this.r8()).m.setErrorStroke(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.j$c */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ViewOnClickListenerC13077j.this.n9();
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.j$d */
    public static final class d implements x.a {
        final /* synthetic */ BankCreditCard b;

        d(BankCreditCard bankCreditCard) {
            this.b = bankCreditCard;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C10333bU0 c10333bU0, ViewOnClickListenerC13077j viewOnClickListenerC13077j, C5354Iz1 c5354Iz1) {
            AbstractC13042fc3.i(c10333bU0, "$loadingFragment");
            AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
            c10333bU0.u8();
            ViewOnClickListenerC13077j.z9(viewOnClickListenerC13077j, null, 1, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.features.payment.view.fragment.x.a
        public void a() {
            final C10333bU0 c10333bU0 = new C10333bU0();
            c10333bU0.K8(ViewOnClickListenerC13077j.this.Q7().B0(), null);
            androidx.lifecycle.r rVarQ = ViewOnClickListenerC13077j.this.u9().Q(this.b);
            InterfaceC18633oz3 interfaceC18633oz3P6 = ViewOnClickListenerC13077j.this.p6();
            final ViewOnClickListenerC13077j viewOnClickListenerC13077j = ViewOnClickListenerC13077j.this;
            rVarQ.j(interfaceC18633oz3P6, new e(new UA2() { // from class: ir.nasim.Iq1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ViewOnClickListenerC13077j.d.c(c10333bU0, viewOnClickListenerC13077j, (C5354Iz1) obj);
                }
            }));
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.j$e */
    static final class e implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        e(UA2 ua2) {
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

    /* renamed from: ir.nasim.features.payment.view.fragment.j$f */
    public static final class f implements C8563Wm6.a {
        final /* synthetic */ SelectableOptionsFragment a;
        final /* synthetic */ ViewOnClickListenerC13077j b;

        f(SelectableOptionsFragment selectableOptionsFragment, ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
            this.a = selectableOptionsFragment;
            this.b = viewOnClickListenerC13077j;
        }

        @Override // ir.nasim.C8563Wm6.a
        public void a(SelectableOption selectableOption) {
            AbstractC13042fc3.i(selectableOption, "item");
            AbstractC16494lN1.a(this.a);
            this.b.ba(selectableOption);
            C3343Am.g("create_crowdfunding_duration_select");
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.j$g */
    public static final class g implements C8563Wm6.a {
        final /* synthetic */ SelectableOptionsFragment a;
        final /* synthetic */ ViewOnClickListenerC13077j b;
        final /* synthetic */ long c;

        g(SelectableOptionsFragment selectableOptionsFragment, ViewOnClickListenerC13077j viewOnClickListenerC13077j, long j) {
            this.a = selectableOptionsFragment;
            this.b = viewOnClickListenerC13077j;
            this.c = j;
        }

        @Override // ir.nasim.C8563Wm6.a
        public void a(SelectableOption selectableOption) {
            AbstractC13042fc3.i(selectableOption, "item");
            AbstractC16494lN1.a(this.a);
            this.b.ca(this.c, selectableOption);
            C3343Am.g("create_crowdfunding_quote_amount_select");
        }
    }

    /* renamed from: ir.nasim.features.payment.view.fragment.j$h */
    static final class h implements InterfaceC15796kB2 {

        /* renamed from: ir.nasim.features.payment.view.fragment.j$h$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ ViewOnClickListenerC13077j a;

            a(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
                this.a = viewOnClickListenerC13077j;
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

        /* renamed from: ir.nasim.features.payment.view.fragment.j$h$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ ViewOnClickListenerC13077j a;

            b(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
                this.a = viewOnClickListenerC13077j;
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

        h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(521189590, true, new a(ViewOnClickListenerC13077j.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(873846104, true, new b(ViewOnClickListenerC13077j.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(-374676934);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.k
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return ViewOnClickListenerC13077j.h.c(dialog);
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

    /* renamed from: ir.nasim.features.payment.view.fragment.j$i */
    static final class i implements InterfaceC15796kB2 {

        /* renamed from: ir.nasim.features.payment.view.fragment.j$i$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ ViewOnClickListenerC13077j a;

            a(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
                this.a = viewOnClickListenerC13077j;
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

        /* renamed from: ir.nasim.features.payment.view.fragment.j$i$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ ViewOnClickListenerC13077j a;

            b(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
                this.a = viewOnClickListenerC13077j;
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

        i() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void b(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(619498245, true, new a(ViewOnClickListenerC13077j.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(444375943, true, new b(ViewOnClickListenerC13077j.this), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            interfaceC22053ub1.W(-374649734);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.features.payment.view.fragment.l
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return ViewOnClickListenerC13077j.i.c(dialog);
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
    public static final C19938rB7 A9(final ViewOnClickListenerC13077j viewOnClickListenerC13077j, final InterfaceC21545tj3 interfaceC21545tj3, CardToCardConfig cardToCardConfig) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        viewOnClickListenerC13077j.config = cardToCardConfig;
        viewOnClickListenerC13077j.u9().c0().j(viewOnClickListenerC13077j.p6(), new e(new UA2() { // from class: ir.nasim.yq1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ViewOnClickListenerC13077j.B9(this.a, interfaceC21545tj3, (ArrayList) obj);
            }
        }));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B9(ViewOnClickListenerC13077j viewOnClickListenerC13077j, InterfaceC21545tj3 interfaceC21545tj3, ArrayList arrayList) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        if (arrayList == null || arrayList.isEmpty()) {
            viewOnClickListenerC13077j.o9(interfaceC21545tj3);
        } else {
            viewOnClickListenerC13077j.suggestList.clear();
            viewOnClickListenerC13077j.suggestList.addAll(arrayList);
            if (((C7717Sx2) viewOnClickListenerC13077j.r8()).n.getText().length() == 0) {
                viewOnClickListenerC13077j.fa(viewOnClickListenerC13077j.suggestList);
            } else {
                viewOnClickListenerC13077j.la(((C7717Sx2) viewOnClickListenerC13077j.r8()).n.getText().toString());
            }
            viewOnClickListenerC13077j.o9(interfaceC21545tj3);
        }
        return C19938rB7.a;
    }

    private final ViewOnClickListenerC13077j C9() {
        if (this.content == null) {
            ((C7717Sx2) r8()).p.setAdapter(this.suggestAdapter);
            RecyclerView recyclerView = ((C7717Sx2) r8()).p;
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            recyclerView.addItemDecoration(new GC6(contextS7, KB5.ic_card_payment_divider_line));
            this.suggestAdapter.C(this);
            this.suggestAdapter.D(this);
            this.suggestAdapter.E(this);
        }
        return this;
    }

    private final ViewOnClickListenerC13077j D9() {
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
            ba(new SelectableOption(XY6.e(i6(AbstractC12217eE5.crowdfunding_day_parameter, Long.valueOf(days))), Long.valueOf(days)));
            CrowdfundingContentInfo crowdfundingContentInfo3 = this.content;
            AbstractC13042fc3.f(crowdfundingContentInfo3);
            long amount = crowdfundingContentInfo3.getAmount();
            CrowdfundingContentInfo crowdfundingContentInfo4 = this.content;
            AbstractC13042fc3.f(crowdfundingContentInfo4);
            ca(amount, q9(crowdfundingContentInfo4.getQuotaAmount()));
        }
        return this;
    }

    private final void E9() {
        for (int i2 = 1; i2 < 32; i2++) {
            this.durationDaysList.add(new SelectableOption(XY6.e(i6(AbstractC12217eE5.crowdfunding_day_parameter, Integer.valueOf(i2))), Long.valueOf(i2)));
        }
    }

    private final ViewOnClickListenerC13077j F9() {
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
        ((C7717Sx2) r8()).z.setTypeface(C6011Lu2.i());
        ((C7717Sx2) r8()).y.setTypeface(C6011Lu2.i());
        return this;
    }

    private final ViewOnClickListenerC13077j G9() {
        ((C7717Sx2) r8()).x.setTag("create_crowdfunding_input_title_focus");
        ((C7717Sx2) r8()).m.setTag("create_crowdfunding_input_description_focus");
        ((C7717Sx2) r8()).w.setTag("create_crowdfunding_input_amount_focus");
        CustomInputView customInputView = ((C7717Sx2) r8()).x;
        AbstractC13042fc3.h(customInputView, "titleInput");
        M9(customInputView);
        CustomInputView customInputView2 = ((C7717Sx2) r8()).m;
        AbstractC13042fc3.h(customInputView2, "descriptionInput");
        M9(customInputView2);
        CustomInputView customInputView3 = ((C7717Sx2) r8()).w;
        AbstractC13042fc3.h(customInputView3, "targetAmountInput");
        M9(customInputView3);
        CustomInputView customInputView4 = ((C7717Sx2) r8()).w;
        CustomInputView customInputView5 = ((C7717Sx2) r8()).w;
        AbstractC13042fc3.h(customInputView5, "targetAmountInput");
        customInputView4.b(new C20514s83(customInputView5));
        ((C7717Sx2) r8()).w.b(new c());
        CustomInputView customInputView6 = ((C7717Sx2) r8()).n;
        CustomInputView customInputView7 = ((C7717Sx2) r8()).n;
        AbstractC13042fc3.h(customInputView7, "destinationCardNumberInput");
        customInputView6.b(new C13396g93(customInputView7));
        ((C7717Sx2) r8()).n.b(this.cardTextWatcher);
        ((C7717Sx2) r8()).r.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: ir.nasim.qq1
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i2, int i3, int i4, int i5) {
                ViewOnClickListenerC13077j.H9(this.a, view, i2, i3, i4, i5);
            }
        });
        ((C7717Sx2) r8()).n.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.rq1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ViewOnClickListenerC13077j.I9(this.a, view, z);
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
    public static final void H9(ViewOnClickListenerC13077j viewOnClickListenerC13077j, View view, int i2, int i3, int i4, int i5) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        if (i5 > 0) {
            ((C7717Sx2) viewOnClickListenerC13077j.r8()).x.c();
            ((C7717Sx2) viewOnClickListenerC13077j.r8()).w.c();
            ((C7717Sx2) viewOnClickListenerC13077j.r8()).n.c();
            ((C7717Sx2) viewOnClickListenerC13077j.r8()).m.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(final ViewOnClickListenerC13077j viewOnClickListenerC13077j, View view, boolean z) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        if (!z) {
            ((C7717Sx2) viewOnClickListenerC13077j.r8()).o.setVisibility(8);
            return;
        }
        C3343Am.g("create_crowdfunding_input_card_focus");
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.zq1
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC13077j.J9(this.a);
            }
        }, 100L);
        ((C7717Sx2) viewOnClickListenerC13077j.r8()).o.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        ((C7717Sx2) viewOnClickListenerC13077j.r8()).r.V((int) ((C7717Sx2) viewOnClickListenerC13077j.r8()).n.getX(), (int) ((C7717Sx2) viewOnClickListenerC13077j.r8()).n.getY());
    }

    private final void K9(final long amount) {
        final ArrayList arrayList = new ArrayList();
        if (amount <= 20000) {
            arrayList.add(q9(10000L));
            ja(amount, arrayList, true);
        } else {
            final C10333bU0 c10333bU0 = new C10333bU0();
            c10333bU0.K8(Q7().B0(), null);
            u9().a0(amount).j(p6(), new e(new UA2() { // from class: ir.nasim.uq1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ViewOnClickListenerC13077j.L9(this.a, c10333bU0, amount, arrayList, (ArrayList) obj);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L9(ViewOnClickListenerC13077j viewOnClickListenerC13077j, C10333bU0 c10333bU0, long j, ArrayList arrayList, ArrayList arrayList2) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        AbstractC13042fc3.i(c10333bU0, "$loadingFragment");
        AbstractC13042fc3.i(arrayList, "$quotaList");
        if (arrayList2.isEmpty()) {
            Context contextS7 = viewOnClickListenerC13077j.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P6 = viewOnClickListenerC13077j.p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, V31.a.c(), 4, null).show();
            AbstractC16494lN1.a(c10333bU0);
        } else {
            AbstractC13042fc3.f(arrayList2);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(viewOnClickListenerC13077j.q9(((Number) it.next()).longValue()));
            }
            AbstractC16494lN1.a(c10333bU0);
            viewOnClickListenerC13077j.ja(j, arrayList, arrayList.size() < 6);
        }
        return C19938rB7.a;
    }

    private final void M9(final CustomInputView inputViewView) {
        inputViewView.setFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.xq1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ViewOnClickListenerC13077j.N9(this.a, inputViewView, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(ViewOnClickListenerC13077j viewOnClickListenerC13077j, CustomInputView customInputView, View view, boolean z) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        AbstractC13042fc3.i(customInputView, "$inputViewView");
        if (z) {
            ((C7717Sx2) viewOnClickListenerC13077j.r8()).r.V((int) customInputView.getX(), (int) customInputView.getY());
        }
        try {
            C3343Am.g(customInputView.getTag().toString());
        } catch (Exception unused) {
        }
    }

    private final void O9(boolean enable) {
        if (!enable) {
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.iq1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC13077j.P9(this.a);
                }
            }, 500L);
        } else {
            ((C7717Sx2) r8()).r.setScrollable(false);
            ((C7717Sx2) r8()).j.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        ((C7717Sx2) viewOnClickListenerC13077j.r8()).r.setScrollable(true);
        ((C7717Sx2) viewOnClickListenerC13077j.r8()).j.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(ViewOnClickListenerC13077j viewOnClickListenerC13077j, String str, String str2) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        if (str != null) {
            viewOnClickListenerC13077j.ea(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 R9(ViewOnClickListenerC13077j viewOnClickListenerC13077j, String str, Bundle bundle) throws Throwable {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        AbstractC13042fc3.i(str, "str");
        AbstractC13042fc3.i(bundle, "bundle");
        long j = bundle.getLong("ARG_PEER_UNIQUE_ID");
        if (j != 0) {
            viewOnClickListenerC13077j.peerUniqueId = j;
            viewOnClickListenerC13077j.da(viewOnClickListenerC13077j.title, viewOnClickListenerC13077j.description, viewOnClickListenerC13077j.amount, viewOnClickListenerC13077j.endTime, viewOnClickListenerC13077j.cardNumber);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 S9(final ViewOnClickListenerC13077j viewOnClickListenerC13077j, String str) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        if (viewOnClickListenerC13077j.content == null) {
            if (str != null && str.length() > 6) {
                ((C7717Sx2) viewOnClickListenerC13077j.r8()).n.setText(str);
            }
            ((C7717Sx2) viewOnClickListenerC13077j.r8()).x.clearFocus();
            ((C7717Sx2) viewOnClickListenerC13077j.r8()).w.clearFocus();
            ((C7717Sx2) viewOnClickListenerC13077j.r8()).m.clearFocus();
            ((C7717Sx2) viewOnClickListenerC13077j.r8()).n.clearFocus();
        } else {
            ((C7717Sx2) viewOnClickListenerC13077j.r8()).h.setVisibility(8);
        }
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.sq1
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC13077j.T9(this.a);
            }
        }, 100L);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        ((C7717Sx2) viewOnClickListenerC13077j.r8()).r.scrollTo(0, 0);
    }

    private final void U9() {
        FragmentActivity fragmentActivityQ7 = Q7();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        fragmentActivityQ7.startActivityForResult(C22055ub3.j(contextS7, true, false, true, false), 5004);
    }

    private final void V9() {
        if (this.photoExternalFile == null) {
            Toast.makeText(G5(), AbstractC12217eE5.toast_no_sdcard, 1).show();
            return;
        }
        if (AbstractC4043Dl1.a(S7(), "android.permission.CAMERA") == 0) {
            j9();
            return;
        }
        C21753u45 c21753u45 = C21753u45.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C21753u45.i0(c21753u45, fragmentActivityQ7, 5001, C21753u45.d.f, Integer.valueOf(AbstractC12217eE5.card_payment_camera_permission_desctiption), null, null, null, false, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, null);
    }

    private final void W9() {
        if (AbstractC4043Dl1.a(AbstractC5969Lp4.d().j2(), "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            U9();
            return;
        }
        C21753u45 c21753u45 = C21753u45.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C21753u45.P0(c21753u45, fragmentActivityQ7, 5002, Integer.valueOf(AbstractC12217eE5.card_payment_external_storage_permission_desctiption), null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 8, null);
    }

    private final void X9() throws NumberFormatException {
        long j;
        boolean z = true;
        if (((C7717Sx2) r8()).w.getText().toString().length() > 0) {
            j = Long.parseLong(ZY6.a(((C7717Sx2) r8()).w.getText().toString()));
            if (j < 20000) {
                ((C7717Sx2) r8()).r.V((int) ((C7717Sx2) r8()).w.getX(), (int) ((C7717Sx2) r8()).w.getY());
                AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.tq1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewOnClickListenerC13077j.Y9(this.a);
                    }
                }, 500L);
            } else {
                z = false;
            }
        } else {
            ((C7717Sx2) r8()).r.V((int) ((C7717Sx2) r8()).w.getX(), (int) ((C7717Sx2) r8()).w.getY());
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.Aq1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC13077j.Z9(this.a);
                }
            }, 500L);
            j = 0;
        }
        if (z) {
            return;
        }
        K9(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        CustomInputView customInputView = ((C7717Sx2) viewOnClickListenerC13077j.r8()).w;
        String strH6 = viewOnClickListenerC13077j.h6(AbstractC12217eE5.crowdfunding_minimum_target_amoun_must_be_twenty_thousand);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setInputError(strH6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        CustomInputView customInputView = ((C7717Sx2) viewOnClickListenerC13077j.r8()).w;
        String strH6 = viewOnClickListenerC13077j.h6(AbstractC12217eE5.crowdfunding_insert_target_amount);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setInputError(strH6);
    }

    private final void aa() {
        C3343Am.g("create_crowdfunding_remove_image_button");
        this.photoPath = null;
        this.photoName = null;
        ((C7717Sx2) r8()).i.setImageDrawable(null);
        ((C7717Sx2) r8()).e.setVisibility(8);
        ((C7717Sx2) r8()).f.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(SelectableOption item) {
        ((C7717Sx2) r8()).c.setTextColor(C5495Jo7.a.g0());
        ((C7717Sx2) r8()).c.setText(item.getTitle());
        ((C7717Sx2) r8()).c.setTypeface(C6011Lu2.i());
        Long longValue = item.getLongValue();
        this.durationDay = longValue != null ? Integer.valueOf((int) longValue.longValue()) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca(long amount, SelectableOption item) {
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

    private final void da(String title, String description, long amount, Date endTime, String cardNumber) throws Throwable {
        if (this.photoName == null) {
            C7653Sq1 c7653Sq1U9 = u9();
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            long j = this.peerUniqueId;
            Long l = this.quotaAmount;
            AbstractC13042fc3.f(l);
            InterfaceC8360Vq1.s0(c7653Sq1U9, contextS7, j, null, null, title, description, amount, l.longValue(), endTime.getTime(), cardNumber, 12, null);
        } else {
            C7653Sq1 c7653Sq1U92 = u9();
            Context contextS72 = S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            long j2 = this.peerUniqueId;
            String str = this.photoPath;
            AbstractC13042fc3.f(str);
            String str2 = this.photoName;
            AbstractC13042fc3.f(str2);
            Long l2 = this.quotaAmount;
            AbstractC13042fc3.f(l2);
            c7653Sq1U92.p(contextS72, j2, str, str2, title, description, amount, l2.longValue(), endTime.getTime(), cardNumber);
        }
        if (this.fromMyBank) {
            C18987pb3 c18987pb3 = C18987pb3.a;
            C11458d25 c11458d25R = C11458d25.r(this.peerUniqueId);
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            C18987pb3.x1(c18987pb3, c11458d25R, null, null, false, null, null, false, null, null, false, null, 2046, null);
        }
        Q7().finish();
    }

    private final void ea(String path) {
        ((C7717Sx2) r8()).i.setImageURI(Uri.fromFile(new File(path)));
        this.photoName = GY6.e(path);
        this.photoPath = path;
        ((C7717Sx2) r8()).e.setVisibility(0);
        ((C7717Sx2) r8()).f.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fa(ArrayList list) {
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
        this.suggestAdapter.B(arrayList);
        this.suggestAdapter.notifyDataSetChanged();
        ((C7717Sx2) r8()).r.V((int) ((C7717Sx2) r8()).n.getX(), (int) ((C7717Sx2) r8()).n.getY());
    }

    private final void ga() {
        SelectableOptionsFragment.a aVar = SelectableOptionsFragment.r1;
        if (aVar.a()) {
            return;
        }
        String strH6 = h6(AbstractC12217eE5.crowdfunding_activity_duration);
        AbstractC13042fc3.h(strH6, "getString(...)");
        SelectableOptionsFragment selectableOptionsFragmentB = aVar.b(new SelectableOptionsFragment.Creator(strH6, this.durationDaysList, false, 4, null));
        selectableOptionsFragmentB.W8(new f(selectableOptionsFragmentB, this));
        selectableOptionsFragmentB.K8(Q7().B0(), null);
    }

    private final void h9() {
        C3343Am.g("create_crowdfunding_attach_image_button");
        new AlertDialog.Builder(S7(), AbstractC23035wE5.AlertDialogStyle).setItems(new CharSequence[]{Q7().getString(AbstractC12217eE5.card_payment_pick_photo_camera), Q7().getString(AbstractC12217eE5.card_payment_pick_photo_gallery)}, new DialogInterface.OnClickListener() { // from class: ir.nasim.Bq1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                ViewOnClickListenerC13077j.i9(this.a, dialogInterface, i2);
            }
        }).show().setCanceledOnTouchOutside(true);
    }

    private final void ha() {
        ((C7717Sx2) r8()).l.animate().alpha(0.1f).setDuration(140L).withEndAction(new Runnable() { // from class: ir.nasim.pq1
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC13077j.ia(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i9(ViewOnClickListenerC13077j viewOnClickListenerC13077j, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        if (i2 == 0) {
            viewOnClickListenerC13077j.V9();
        } else {
            if (i2 != 1) {
                return;
            }
            viewOnClickListenerC13077j.W9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        ((C7717Sx2) viewOnClickListenerC13077j.r8()).q.setAlpha(0.0f);
        ((C7717Sx2) viewOnClickListenerC13077j.r8()).q.setVisibility(0);
        ((C7717Sx2) viewOnClickListenerC13077j.r8()).l.setVisibility(8);
        ((C7717Sx2) viewOnClickListenerC13077j.r8()).q.animate().alpha(1.0f).setDuration(160L);
    }

    private final void j9() {
        Uri uriH = FileProvider.h(S7(), S7().getPackageName() + ".provider", new File(this.photoExternalFile));
        FragmentActivity fragmentActivityQ7 = Q7();
        Intent intentPutExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uriH);
        AbstractC13042fc3.h(intentPutExtra, "putExtra(...)");
        fragmentActivityQ7.startActivityForResult(intentPutExtra, 5003);
    }

    private final void ja(long amount, ArrayList quotaList, boolean fullExpandOpen) {
        SelectableOptionsFragment.a aVar = SelectableOptionsFragment.r1;
        if (aVar.a()) {
            return;
        }
        String strH6 = h6(AbstractC12217eE5.crowdfunding_quota_amount);
        AbstractC13042fc3.h(strH6, "getString(...)");
        SelectableOptionsFragment selectableOptionsFragmentB = aVar.b(new SelectableOptionsFragment.Creator(strH6, quotaList, fullExpandOpen));
        selectableOptionsFragmentB.W8(new g(selectableOptionsFragmentB, this, amount));
        selectableOptionsFragmentB.K8(Q7().B0(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bank k9(String pattern) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 ka(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        FrameLayout root = ((C7717Sx2) viewOnClickListenerC13077j.r8()).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.m(0);
        return c17468n10;
    }

    private final String l9() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        try {
            ClipboardManager clipboardManager = (ClipboardManager) S7().getSystemService("clipboard");
            CharSequence text = (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || (itemAt = primaryClip.getItemAt(0)) == null) ? null : itemAt.getText();
            if (text == null || text.length() == 0 || !u9().P0(text.toString())) {
                return null;
            }
            List<String> listK = AbstractC11342cq6.K(AbstractC11342cq6.C(C20644sM5.e(new C20644sM5("\\d{4}[ -_*\\t\\n]*?\\d{4}[ -_*\\t\\n]*?\\d{4}[ -_*\\t\\n]*?\\d{4}"), text, 0, 2, null), new UA2() { // from class: ir.nasim.oq1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ViewOnClickListenerC13077j.m9((OU3) obj);
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
    public final void la(String cardNumber) {
        try {
            ArrayList arrayList = new ArrayList();
            for (BankCreditCard bankCreditCard : this.suggestList) {
                if (AbstractC20153rZ6.S(bankCreditCard.getNumber(), XY6.h(ZY6.a(cardNumber)), false, 2, null)) {
                    arrayList.add(bankCreditCard);
                }
            }
            fa(arrayList);
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String m9(OU3 ou3) {
        AbstractC13042fc3.i(ou3, "it");
        return ou3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ma(ViewOnClickListenerC13077j viewOnClickListenerC13077j, String str) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        AbstractC13042fc3.i(str, ParameterNames.CARD);
        viewOnClickListenerC13077j.m3(str);
        viewOnClickListenerC13077j.u9().R0(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n9() {
        ((C7717Sx2) r8()).t.setText(h6(AbstractC12217eE5.crowdfunding_select_your_option));
        ((C7717Sx2) r8()).t.setTextColor(C5495Jo7.a.o0());
        ((C7717Sx2) r8()).t.setTypeface(C6011Lu2.k());
        ((C7717Sx2) r8()).v.setVisibility(8);
        this.quotaAmount = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String na(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        return viewOnClickListenerC13077j.l9();
    }

    private final void o9(InterfaceC21545tj3 jobListener) {
        AbstractC16494lN1.a(this.loadingInitData);
        if (jobListener != null) {
            jobListener.a();
        }
        ((C7717Sx2) r8()).r.scrollTo(0, 0);
    }

    private final void oa() throws Throwable {
        C23381wp3.f(((C7717Sx2) r8()).n);
        if (((C7717Sx2) r8()).x.getText().length() == 0) {
            LockableNestedScrollView lockableNestedScrollView = ((C7717Sx2) r8()).r;
            AbstractC13042fc3.h(lockableNestedScrollView, "nestedScrollView");
            CustomInputView customInputView = ((C7717Sx2) r8()).x;
            AbstractC13042fc3.h(customInputView, "titleInput");
            AbstractC4808Gq4.a(lockableNestedScrollView, customInputView);
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.Hq1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC13077j.pa(this.a);
                }
            }, 500L);
            O9(false);
            return;
        }
        this.title = ((C7717Sx2) r8()).x.getText().toString();
        if (((C7717Sx2) r8()).w.getText().length() == 0) {
            LockableNestedScrollView lockableNestedScrollView2 = ((C7717Sx2) r8()).r;
            AbstractC13042fc3.h(lockableNestedScrollView2, "nestedScrollView");
            CustomInputView customInputView2 = ((C7717Sx2) r8()).w;
            AbstractC13042fc3.h(customInputView2, "targetAmountInput");
            AbstractC4808Gq4.a(lockableNestedScrollView2, customInputView2);
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.jq1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC13077j.qa(this.a);
                }
            }, 500L);
            O9(false);
            return;
        }
        this.amount = Long.parseLong(ZY6.a(((C7717Sx2) r8()).w.getText().toString()));
        if (((C7717Sx2) r8()).n.getText().length() == 0 || ((C7717Sx2) r8()).n.getText().length() < 19) {
            LockableNestedScrollView lockableNestedScrollView3 = ((C7717Sx2) r8()).r;
            AbstractC13042fc3.h(lockableNestedScrollView3, "nestedScrollView");
            CustomInputView customInputView3 = ((C7717Sx2) r8()).n;
            AbstractC13042fc3.h(customInputView3, "destinationCardNumberInput");
            AbstractC4808Gq4.a(lockableNestedScrollView3, customInputView3);
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.kq1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC13077j.ra(this.a);
                }
            }, 500L);
            O9(false);
            return;
        }
        this.cardNumber = ZY6.a(((C7717Sx2) r8()).n.getText().toString());
        if (((C7717Sx2) r8()).m.getText().length() == 0) {
            LockableNestedScrollView lockableNestedScrollView4 = ((C7717Sx2) r8()).r;
            AbstractC13042fc3.h(lockableNestedScrollView4, "nestedScrollView");
            CustomInputView customInputView4 = ((C7717Sx2) r8()).m;
            AbstractC13042fc3.h(customInputView4, "descriptionInput");
            AbstractC4808Gq4.a(lockableNestedScrollView4, customInputView4);
            AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.lq1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewOnClickListenerC13077j.sa(this.a);
                }
            }, 500L);
            O9(false);
            return;
        }
        this.description = ((C7717Sx2) r8()).m.getText().toString();
        if (this.durationDay == null) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-608192889, true, new h()), 4, null);
            O9(false);
            return;
        }
        Long l = this.quotaAmount;
        if (l == null) {
            Context contextS72 = S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P62 = p6();
            AbstractC13042fc3.h(interfaceC18633oz3P62, "getViewLifecycleOwner(...)");
            AbstractC21375tZ.c(contextS72, interfaceC18633oz3P62, null, AbstractC19242q11.c(1802782390, true, new i()), 4, null).show();
            O9(false);
            return;
        }
        if (this.destBank != null) {
            AbstractC13042fc3.f(l);
            long jLongValue = l.longValue();
            AbstractC13042fc3.f(this.destBank);
            if (jLongValue > r5.getMaximumAmount()) {
                C17468n10 c17468n10S9 = s9();
                String strH6 = h6(AbstractC12217eE5.card_payment_amount_more_than_destination_value);
                AbstractC13042fc3.h(strH6, "getString(...)");
                C17468n10.p(c17468n10S9, strH6, new AbstractC13463gG6.a(h6(AbstractC12217eE5.card_payment_i_confirm), null, false, null, 14, null), null, 4, null);
                O9(false);
                return;
            }
        }
        if (this.destBank != null) {
            Long l2 = this.quotaAmount;
            AbstractC13042fc3.f(l2);
            long jLongValue2 = l2.longValue();
            AbstractC13042fc3.f(this.destBank);
            if (jLongValue2 < r5.getMinimumAmount()) {
                C17468n10 c17468n10S92 = s9();
                String strH62 = h6(AbstractC12217eE5.card_payment_amount_lower_than_destination_value);
                AbstractC13042fc3.h(strH62, "getString(...)");
                C17468n10.p(c17468n10S92, strH62, new AbstractC13463gG6.a(h6(AbstractC12217eE5.card_payment_i_confirm), null, false, null, 14, null), null, 4, null);
                O9(false);
                return;
            }
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.endTime);
        Integer num = this.durationDay;
        AbstractC13042fc3.f(num);
        calendar.add(5, num.intValue());
        this.endTime = calendar.getTime();
        if (!((C7717Sx2) r8()).n.r()) {
            O9(false);
            ((C7717Sx2) r8()).n.requestFocus();
            return;
        }
        this.description = AbstractC20762sZ6.n1(this.description).toString();
        Context contextS73 = S7();
        AbstractC13042fc3.h(contextS73, "requireContext(...)");
        if (!C4100Dr4.a(contextS73)) {
            Context contextS74 = S7();
            AbstractC13042fc3.h(contextS74, "requireContext(...)");
            String strH63 = h6(AbstractC12217eE5.card_payment_please_check_your_internet_conenction);
            AbstractC13042fc3.h(strH63, "getString(...)");
            AbstractC4277El1.e(contextS74, strH63, 0, 2, null);
            return;
        }
        if (this.content == null) {
            C3343Am.g("create_crowdfunding_send_button");
            da(this.title, this.description, this.amount, this.endTime, this.cardNumber);
        } else {
            p9(this.title, this.description);
            C3343Am.g("create_crowdfunding_edit_button");
        }
    }

    private final void p9(String title, String description) {
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
        u9().a(this.peerUniqueId, j44J.i(), j44J.h(), new C16247kx(c16247kx.F(), c16247kx.u(), c16247kx.C(), title, description, c16247kx.y(), c16247kx.D(), c16247kx.z()));
        Q7().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        CustomInputView customInputView = ((C7717Sx2) viewOnClickListenerC13077j.r8()).x;
        String strH6 = viewOnClickListenerC13077j.h6(AbstractC12217eE5.crowdfunding_insert_title);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setHintError(strH6);
    }

    private final SelectableOption q9(long amount) {
        return new SelectableOption(XY6.e(i6(AbstractC12217eE5.crowdfunding_rial_param, GY6.g(String.valueOf(amount)))), Long.valueOf(amount));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        CustomInputView customInputView = ((C7717Sx2) viewOnClickListenerC13077j.r8()).w;
        String strH6 = viewOnClickListenerC13077j.h6(AbstractC12217eE5.card_payment_insert_amount);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setHintError(strH6);
    }

    private final androidx.lifecycle.r r9() {
        return u9().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        CustomInputView customInputView = ((C7717Sx2) viewOnClickListenerC13077j.r8()).n;
        String strH6 = viewOnClickListenerC13077j.h6(AbstractC12217eE5.card_payment_insert_dest_card);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setInputError(strH6);
    }

    private final C17468n10 s9() {
        return (C17468n10) this.snackbar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        CustomInputView customInputView = ((C7717Sx2) viewOnClickListenerC13077j.r8()).m;
        String strH6 = viewOnClickListenerC13077j.h6(AbstractC12217eE5.crowdfunding_insert_description);
        AbstractC13042fc3.h(strH6, "getString(...)");
        customInputView.setHintError(strH6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C7653Sq1 ta(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        FragmentActivity fragmentActivityQ7 = viewOnClickListenerC13077j.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C7653Sq1) new androidx.lifecycle.G(fragmentActivityQ7).b(C7653Sq1.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C7653Sq1 u9() {
        return (C7653Sq1) this.viewModel.getValue();
    }

    private final void v9() {
        ((C7717Sx2) r8()).q.animate().alpha(0.1f).setDuration(100L).withEndAction(new Runnable() { // from class: ir.nasim.vq1
            @Override // java.lang.Runnable
            public final void run() {
                ViewOnClickListenerC13077j.w9(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w9(ViewOnClickListenerC13077j viewOnClickListenerC13077j) {
        AbstractC13042fc3.i(viewOnClickListenerC13077j, "this$0");
        ((C7717Sx2) viewOnClickListenerC13077j.r8()).l.setAlpha(0.0f);
        ((C7717Sx2) viewOnClickListenerC13077j.r8()).l.setVisibility(0);
        ((C7717Sx2) viewOnClickListenerC13077j.r8()).q.setVisibility(8);
        ((C7717Sx2) viewOnClickListenerC13077j.r8()).l.animate().alpha(1.0f).setDuration(120L);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13077j x9() {
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
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.payment.view.fragment.ViewOnClickListenerC13077j.x9():ir.nasim.features.payment.view.fragment.j");
    }

    private final void y9(final InterfaceC21545tj3 listener) {
        C10333bU0 c10333bU0 = this.loadingInitData;
        FragmentManager fragmentManagerB0 = Q7().B0();
        AbstractC13042fc3.h(fragmentManagerB0, "getSupportFragmentManager(...)");
        AbstractC16494lN1.b(c10333bU0, fragmentManagerB0);
        try {
            u9().getConfig().j(p6(), new e(new UA2() { // from class: ir.nasim.wq1
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ViewOnClickListenerC13077j.A9(this.a, listener, (CardToCardConfig) obj);
                }
            }));
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
            try {
                this.loadingInitData.u8();
            } catch (Exception e3) {
                C19406qI3.d("NON_FATAL_EXCEPTION", e3);
                AbstractC16494lN1.a(this.loadingInitData);
            }
            Q7().finish();
        }
    }

    static /* synthetic */ void z9(ViewOnClickListenerC13077j viewOnClickListenerC13077j, InterfaceC21545tj3 interfaceC21545tj3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC21545tj3 = null;
        }
        viewOnClickListenerC13077j.y9(interfaceC21545tj3);
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
        if (requestCode == 4) {
            ha();
            return;
        }
        if (requestCode == 5001) {
            v9();
            return;
        }
        if (requestCode == 5003) {
            String str = this.photoExternalFile;
            if (str == null || str.length() == 0) {
                return;
            }
            AbstractC17543n85.a(this, A5(), this.photoExternalFile, 1, true, new AbstractC17543n85.b() { // from class: ir.nasim.Gq1
                @Override // ir.nasim.AbstractC17543n85.b
                public final void a(String str2, String str3) {
                    ViewOnClickListenerC13077j.Q9(this.a, str2, str3);
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
        ea(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.AbstractC15985kW2, androidx.fragment.app.Fragment
    public void J6(Context context) {
        AbstractC13042fc3.i(context, "context");
        super.J6(context);
        if (context instanceof InterfaceC14778iT2) {
            this.handleInfoCallback = (InterfaceC14778iT2) context;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        AbstractC18623oy2.d(this, "money_request_selected_peer", new InterfaceC14603iB2() { // from class: ir.nasim.mq1
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return ViewOnClickListenerC13077j.R9(this.a, (String) obj, (Bundle) obj2);
            }
        });
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.content = (CrowdfundingContentInfo) bundleE5.getParcelable("param_data");
            this.fromMyBank = bundleE5.getBoolean("from_my_bank", false);
            this.peerUniqueId = bundleE5.getLong("param_peer_unique_id");
        }
        if (this.content == null) {
            E9();
        }
    }

    @Override // ir.nasim.InterfaceC21074t40
    public void Q() {
        z9(this, null, 1, null);
    }

    @Override // ir.nasim.C13353g50.d
    public void Z0(BankCreditCard card) {
        AbstractC13042fc3.i(card, ParameterNames.CARD);
        ((C7717Sx2) r8()).o.setVisibility(8);
        if (card.getType() == BankCreditCard.c.a) {
            a0(card.getNumber());
        }
    }

    @Override // ir.nasim.InterfaceC21074t40
    public void a0(String cardNumber) {
        AbstractC13042fc3.i(cardNumber, "cardNumber");
        ((C7717Sx2) r8()).n.setMaxLength(19);
        ((C7717Sx2) r8()).n.setText(cardNumber);
        ((C7717Sx2) r8()).n.setErrorStroke(false);
        ((C7717Sx2) r8()).n.setSelection(19);
        fa(new ArrayList());
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

    @Override // ir.nasim.C13353g50.e
    public void i5(BankCreditCard card) {
        AbstractC13042fc3.i(card, ParameterNames.CARD);
        if (card.getType() == BankCreditCard.c.a) {
            x xVar = new x();
            xVar.S8(new d(card));
            xVar.K8(Q7().B0(), null);
        }
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

    @Override // androidx.fragment.app.Fragment
    public void k7() {
        super.k7();
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
                ba(new SelectableOption(strE, Long.valueOf(r1.intValue())));
            }
            if (savedInstanceState.containsKey(this.quotaAmountKey)) {
                this.quotaAmount = Long.valueOf(savedInstanceState.getLong(this.quotaAmountKey));
                long j = savedInstanceState.getLong(this.amountKey);
                Long l = this.quotaAmount;
                AbstractC13042fc3.f(l);
                ca(j, q9(l.longValue()));
            }
            if (savedInstanceState.containsKey(this.photoPathKey) && savedInstanceState.containsKey(this.photoNameKey)) {
                this.photoPath = savedInstanceState.getString(this.photoPathKey);
                this.photoName = savedInstanceState.getString(this.photoNameKey);
                String str = this.photoPath;
                AbstractC13042fc3.f(str);
                ea(str);
            }
        }
        z9(F9().G9().x9().C9().D9(), null, 1, null);
        r9().j(p6(), new e(new UA2() { // from class: ir.nasim.nq1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ViewOnClickListenerC13077j.S9(this.a, (String) obj);
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
        fa(new ArrayList());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) throws Throwable {
        if (AbstractC13042fc3.d(v, ((C7717Sx2) r8()).b)) {
            ga();
            return;
        }
        if (AbstractC13042fc3.d(v, ((C7717Sx2) r8()).s)) {
            X9();
            return;
        }
        if (AbstractC13042fc3.d(v, ((C7717Sx2) r8()).f)) {
            h9();
            return;
        }
        if (AbstractC13042fc3.d(v, ((C7717Sx2) r8()).e)) {
            aa();
        } else if (AbstractC13042fc3.d(v, ((C7717Sx2) r8()).j)) {
            O9(true);
            oa();
        }
    }

    @Override // ir.nasim.C13353g50.c
    public void t(C13944h50 button) {
        AbstractC13042fc3.i(button, "button");
        int iA = button.a();
        if (iA == 2880) {
            J jA = J.INSTANCE.a(0);
            jA.getSavedAdapter().M(this.suggestList);
            jA.K8(Q7().B0(), null);
        } else if (iA == 2881) {
            C3343Am.g("create_crowdfunding_add_card_button");
            C13069b.Companion.b(C13069b.INSTANCE, 0, null, 2, null).K8(Q7().B0(), null);
        }
        ((C7717Sx2) r8()).o.setVisibility(8);
    }

    @Override // ir.nasim.AbstractC5830La0
    /* renamed from: t9, reason: merged with bridge method [inline-methods] */
    public C7717Sx2 s8(LayoutInflater inflater, ViewGroup container, boolean attachToParent) {
        AbstractC13042fc3.i(inflater, "inflater");
        C7717Sx2 c7717Sx2C = C7717Sx2.c(inflater, container, attachToParent);
        AbstractC13042fc3.h(c7717Sx2C, "inflate(...)");
        return c7717Sx2C;
    }
}
