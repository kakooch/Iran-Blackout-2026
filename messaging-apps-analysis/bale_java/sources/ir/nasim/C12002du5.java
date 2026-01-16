package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.SwitchCompat;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC17543n85;
import ir.nasim.AbstractC17858ng6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC4886Gz1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.AbstractC8081Ul1;
import ir.nasim.C12002du5;
import ir.nasim.C14486i0;
import ir.nasim.C21753u45;
import ir.nasim.C24254yJ;
import ir.nasim.C24840zI0;
import ir.nasim.GY;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.KA3;
import ir.nasim.O98;
import ir.nasim.OA2;
import ir.nasim.OC4;
import ir.nasim.PA7;
import ir.nasim.PC4;
import ir.nasim.QC4;
import ir.nasim.RC4;
import ir.nasim.SC4;
import ir.nasim.TC2;
import ir.nasim.TY1;
import ir.nasim.core.model.webapp.WebAppArguments;
import ir.nasim.core.model.webapp.WebAppType;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.modules.settings.SettingsModule;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.base.activity.BaseActivity;
import ir.nasim.designsystem.modal.bottomSheet.BottomSheetWebView;
import ir.nasim.features.call.ui.startOutGoingCall.StartOutGoingCallPeerData;
import ir.nasim.features.conversation.NewAdvancedForward;
import ir.nasim.features.root.C13090h;
import ir.nasim.features.story.avatarwithstory.AvatarWithStoryOpeningSelectionBottomSheet;
import ir.nasim.sharedmedia.ui.state.ChangeNickErrorState;
import ir.nasim.story.ui.ownerfragment.StoryOwnerFragment;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import livekit.org.webrtc.MediaStreamTrack;

@Metadata(d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0006*\u0002ê\u0001\b\u0007\u0018\u0000 î\u00012\u00020\u0001:\u0002\u0096\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0003¢\u0006\u0004\b\u001a\u0010\u0011J\u000f\u0010\u001b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\u0003J\u0019\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b%\u0010\u0018J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\bJ\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020'H\u0002¢\u0006\u0004\b,\u0010-J\u0013\u0010/\u001a\u00020\u0004*\u00020.H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104J\u0013\u00105\u001a\u00020\u0004*\u00020.H\u0002¢\u0006\u0004\b5\u00100J\u0013\u00106\u001a\u00020\u0004*\u00020.H\u0002¢\u0006\u0004\b6\u00100J\u0013\u00107\u001a\u00020\u0004*\u00020.H\u0002¢\u0006\u0004\b7\u00100J\u0013\u00108\u001a\u00020\u0004*\u00020.H\u0002¢\u0006\u0004\b8\u00100J\u0013\u00109\u001a\u00020\u0004*\u00020.H\u0002¢\u0006\u0004\b9\u00100J\u000f\u0010:\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u0010\u0003J\u0017\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0015H\u0002¢\u0006\u0004\b<\u0010\u0018J\u0017\u0010=\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0015H\u0002¢\u0006\u0004\b=\u0010\u0018J\u000f\u0010>\u001a\u00020\u0004H\u0002¢\u0006\u0004\b>\u0010\u0003J\u000f\u0010?\u001a\u00020\u0004H\u0002¢\u0006\u0004\b?\u0010\u0003J\u000f\u0010@\u001a\u00020\u0004H\u0002¢\u0006\u0004\b@\u0010\u0003J\u000f\u0010A\u001a\u00020\u0004H\u0002¢\u0006\u0004\bA\u0010\u0003J\u000f\u0010B\u001a\u00020\u0004H\u0002¢\u0006\u0004\bB\u0010\u0003J\u000f\u0010C\u001a\u00020\u0004H\u0002¢\u0006\u0004\bC\u0010\u0003J\u001b\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F0E*\u00020DH\u0002¢\u0006\u0004\bG\u0010HJ\u0019\u0010K\u001a\u00020\u00042\b\b\u0002\u0010J\u001a\u00020IH\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020\u00042\u0006\u0010N\u001a\u00020MH\u0002¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0004H\u0002¢\u0006\u0004\bQ\u0010\u0003J'\u0010V\u001a\u00020\u00042\u0006\u0010R\u001a\u00020M2\u0006\u0010T\u001a\u00020S2\u0006\u0010U\u001a\u00020\u0015H\u0002¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\u0004H\u0002¢\u0006\u0004\bX\u0010\u0003J\u000f\u0010Y\u001a\u00020\u0004H\u0002¢\u0006\u0004\bY\u0010\u0003J\u001f\u0010]\u001a\u00020\u00042\u0006\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020\u0012H\u0002¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020\u0004H\u0002¢\u0006\u0004\b_\u0010\u0003J\u000f\u0010`\u001a\u00020\u0004H\u0002¢\u0006\u0004\b`\u0010\u0003J\u000f\u0010a\u001a\u00020\u0004H\u0002¢\u0006\u0004\ba\u0010\u0003J\u000f\u0010b\u001a\u00020\u0004H\u0002¢\u0006\u0004\bb\u0010\u0003J\u001f\u0010f\u001a\u00020\u00042\u000e\b\u0002\u0010e\u001a\b\u0012\u0004\u0012\u00020d0cH\u0002¢\u0006\u0004\bf\u0010gJ\u0017\u0010j\u001a\u00020\u00042\u0006\u0010i\u001a\u00020hH\u0002¢\u0006\u0004\bj\u0010kJ)\u0010n\u001a\u00020\u00042\b\u0010i\u001a\u0004\u0018\u00010h2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010lH\u0002¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020\u0004H\u0002¢\u0006\u0004\bp\u0010\u0003J\u001d\u0010r\u001a\u00020\u00042\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0002¢\u0006\u0004\br\u0010sJU\u0010{\u001a\u00020\u00042\u0006\u0010u\u001a\u00020t2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020h0c2\u0006\u0010x\u001a\u00020w2\b\b\u0002\u0010y\u001a\u00020M2\u001c\b\u0002\u0010q\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020t0c\u0012\u0004\u0012\u00020\u0004\u0018\u00010zH\u0002¢\u0006\u0004\b{\u0010|J\u0019\u0010~\u001a\u00020\u00042\b\b\u0002\u0010}\u001a\u00020MH\u0002¢\u0006\u0004\b~\u0010PJ\u000f\u0010\u007f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u007f\u0010\u0003J\u0011\u0010\u0080\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u0080\u0001\u0010\u0003J\u001e\u0010\u0083\u0001\u001a\u00020\u00042\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J6\u0010\u0089\u0001\u001a\u0004\u0018\u00010S2\b\u0010\u0086\u0001\u001a\u00030\u0085\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00012\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J&\u0010\u008b\u0001\u001a\u00020\u00042\u0006\u0010T\u001a\u00020S2\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0019\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u008d\u0001\u001a\u00020t¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u0090\u0001\u0010\u0003J/\u0010\u0094\u0001\u001a\u00020\u00042\u0007\u0010\u0091\u0001\u001a\u00020\u00122\u0007\u0010\u0092\u0001\u001a\u00020\u00122\t\u0010\u000b\u001a\u0005\u0018\u00010\u0093\u0001H\u0016¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0012\u0010\u0096\u0001\u001a\u00020MH\u0016¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001R*\u0010\u009f\u0001\u001a\u00030\u0098\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R*\u0010§\u0001\u001a\u00030 \u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R*\u0010¯\u0001\u001a\u00030¨\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R*\u0010·\u0001\u001a\u00030°\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R*\u0010¿\u0001\u001a\u00030¸\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b¹\u0001\u0010º\u0001\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001R*\u0010Ç\u0001\u001a\u00030À\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R*\u0010Ï\u0001\u001a\u00030È\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0006\bÍ\u0001\u0010Î\u0001R!\u0010Õ\u0001\u001a\u00030Ð\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÑ\u0001\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001R\u001c\u0010Ù\u0001\u001a\u0005\u0018\u00010Ö\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R!\u0010ß\u0001\u001a\u00030Ú\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÛ\u0001\u0010Ü\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001R\u0019\u0010â\u0001\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R\u001b\u0010å\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R\u001b\u0010ç\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010ä\u0001R\u001b\u0010é\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010ä\u0001R\u0018\u0010í\u0001\u001a\u00030ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001¨\u0006ï\u0001"}, d2 = {"Lir/nasim/du5;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "vc", "Lir/nasim/gj3;", "yc", "()Lir/nasim/gj3;", "zd", "Lir/nasim/Gz1$b;", "data", "Le", "(Lir/nasim/Gz1$b;)V", "Lkotlin/Function0;", "onClick", "Db", "(Lir/nasim/SA2;Lir/nasim/ub1;I)V", "", "Ic", "()I", "", ParameterNames.INFO, "Pe", "(Ljava/lang/String;)V", "onclick", "Ab", "xb", "(Lir/nasim/ub1;I)V", "Dd", "Ad", "se", "ye", "pc", "qc", "Je", "path", "ee", "xc", "Lir/nasim/Ul1;", "builder", "Fe", "(Lir/nasim/Ul1;)V", "Zd", "Nc", "()Lir/nasim/Ul1;", "Lir/nasim/Ul1$b;", "fc", "(Lir/nasim/Ul1$b;)V", "Lir/nasim/tK7;", "userVM", "ue", "(Lir/nasim/tK7;)V", "nc", "dc", "lc", "hc", "jc", "Yd", "number", "Nd", "Ke", "De", "te", "Ee", "yd", "he", "Ce", "Landroidx/appcompat/widget/AppCompatEditText;", "Lir/nasim/Fq2;", "", "Oe", "(Landroidx/appcompat/widget/AppCompatEditText;)Lir/nasim/Fq2;", "Lir/nasim/ZN2;", "groupType", "ae", "(Lir/nasim/ZN2;)V", "", "add", "ve", "(Z)V", "je", "isEnabled", "Landroid/view/View;", "view", "label", "qe", "(ZLandroid/view/View;Ljava/lang/String;)V", "ie", "pe", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "tabCount", "re", "(Lcom/google/android/material/tabs/TabLayout;I)V", "Ge", "fe", "ge", "rd", "", "Lir/nasim/my6;", "list", "Fc", "(Ljava/util/List;)V", "Lir/nasim/J44;", DialogEntity.COLUMN_MESSAGE, "Bc", "(Lir/nasim/J44;)V", "Lir/nasim/Kc6;", "schedulerOnSuccess", "ld", "(Lir/nasim/J44;Lir/nasim/Kc6;)V", "Be", "successCallback", "Ec", "(Lir/nasim/SA2;)V", "Lir/nasim/d25;", "forwardedPeer", "messages", "Landroid/content/Context;", "parent", "shouldShowToast", "Lkotlin/Function1;", "Ac", "(Lir/nasim/d25;Ljava/util/List;Landroid/content/Context;ZLir/nasim/UA2;)V", "isSelectedMode", "wc", "zc", "h7", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "bot", "s4", "(Lir/nasim/d25;)V", "R6", "requestCode", "resultCode", "Landroid/content/Intent;", "H6", "(IILandroid/content/Intent;)V", "a", "()Z", "Lir/nasim/dQ0;", "h1", "Lir/nasim/dQ0;", "Kc", "()Lir/nasim/dQ0;", "setChatNavigator", "(Lir/nasim/dQ0;)V", "chatNavigator", "Lir/nasim/core/modules/settings/SettingsModule;", "i1", "Lir/nasim/core/modules/settings/SettingsModule;", "od", "()Lir/nasim/core/modules/settings/SettingsModule;", "setSettingsModule", "(Lir/nasim/core/modules/settings/SettingsModule;)V", "settingsModule", "Lir/nasim/Na;", "j1", "Lir/nasim/Na;", "Hc", "()Lir/nasim/Na;", "setAdminListFragmentNavigator", "(Lir/nasim/Na;)V", "adminListFragmentNavigator", "Lir/nasim/PH5;", "k1", "Lir/nasim/PH5;", "nd", "()Lir/nasim/PH5;", "setReactionsSettingsFragmentNavigator", "(Lir/nasim/PH5;)V", "reactionsSettingsFragmentNavigator", "Lir/nasim/B34;", "l1", "Lir/nasim/B34;", "Mc", "()Lir/nasim/B34;", "setMembersAccessFragmentNavigator", "(Lir/nasim/B34;)V", "membersAccessFragmentNavigator", "Lir/nasim/kD2;", "m1", "Lir/nasim/kD2;", "Lc", "()Lir/nasim/kD2;", "setGalleryNavigator", "(Lir/nasim/kD2;)V", "galleryNavigator", "Lir/nasim/m68;", "n1", "Lir/nasim/m68;", "qd", "()Lir/nasim/m68;", "setWebappNavigator", "(Lir/nasim/m68;)V", "webappNavigator", "Lir/nasim/Wy6;", "o1", "Lir/nasim/Yu3;", "pd", "()Lir/nasim/Wy6;", "viewModel", "Lir/nasim/n10;", "p1", "Lir/nasim/n10;", "snackBar", "Lir/nasim/My2;", "q1", "Lir/nasim/bW7;", "Jc", "()Lir/nasim/My2;", "binding", "r1", "Z", "loadedInitialData", "s1", "Ljava/lang/String;", "externalFile", "t1", "avatarPath", "u1", "event_type", "ir/nasim/du5$y", "v1", "Lir/nasim/du5$y;", "onlyLatinInputFilter", "w1", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.du5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C12002du5 extends AX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    public InterfaceC11677dQ0 chatNavigator;

    /* renamed from: i1, reason: from kotlin metadata */
    public SettingsModule settingsModule;

    /* renamed from: j1, reason: from kotlin metadata */
    public InterfaceC6301Na adminListFragmentNavigator;

    /* renamed from: k1, reason: from kotlin metadata */
    public PH5 reactionsSettingsFragmentNavigator;

    /* renamed from: l1, reason: from kotlin metadata */
    public B34 membersAccessFragmentNavigator;

    /* renamed from: m1, reason: from kotlin metadata */
    public InterfaceC15814kD2 galleryNavigator;

    /* renamed from: n1, reason: from kotlin metadata */
    public InterfaceC16935m68 webappNavigator;

    /* renamed from: o1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: p1, reason: from kotlin metadata */
    private C17468n10 snackBar;

    /* renamed from: q1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding;

    /* renamed from: r1, reason: from kotlin metadata */
    private boolean loadedInitialData;

    /* renamed from: s1, reason: from kotlin metadata */
    private String externalFile;

    /* renamed from: t1, reason: from kotlin metadata */
    private String avatarPath;

    /* renamed from: u1, reason: from kotlin metadata */
    private String event_type;

    /* renamed from: v1, reason: from kotlin metadata */
    private final y onlyLatinInputFilter;
    static final /* synthetic */ InterfaceC5239Im3[] x1 = {AbstractC10882cM5.i(new C25226zw5(C12002du5.class, "binding", "getBinding()Lir/nasim/sharedmedia/databinding/FragmentNewProfileBinding;", 0))};

    /* renamed from: w1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int y1 = 8;

    /* renamed from: ir.nasim.du5$A */
    public static final class A implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ C12002du5 b;

        /* renamed from: ir.nasim.du5$A$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ C12002du5 b;

            /* renamed from: ir.nasim.du5$A$a$a, reason: collision with other inner class name */
            public static final class C1032a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C1032a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, C12002du5 c12002du5) {
                this.a = interfaceC4806Gq2;
                this.b = c12002du5;
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
                    boolean r0 = r7 instanceof ir.nasim.C12002du5.A.a.C1032a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.du5$A$a$a r0 = (ir.nasim.C12002du5.A.a.C1032a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.du5$A$a$a r0 = new ir.nasim.du5$A$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L60
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    r2 = r6
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    if (r2 == 0) goto L60
                    int r4 = r2.length()
                    if (r4 != 0) goto L42
                    goto L60
                L42:
                    java.lang.String r2 = r2.toString()
                    ir.nasim.du5 r4 = r5.b
                    ir.nasim.Wy6 r4 = ir.nasim.C12002du5.Rb(r4)
                    java.lang.String r4 = r4.t3()
                    boolean r2 = ir.nasim.AbstractC13042fc3.d(r2, r4)
                    if (r2 == 0) goto L57
                    goto L60
                L57:
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r6, r0)
                    if (r6 != r1) goto L60
                    return r1
                L60:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12002du5.A.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public A(InterfaceC4557Fq2 interfaceC4557Fq2, C12002du5 c12002du5) {
            this.a = interfaceC4557Fq2;
            this.b = c12002du5;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.du5$B */
    static final class B implements InterfaceC15796kB2 {
        final /* synthetic */ int a;
        final /* synthetic */ C12002du5 b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;

        /* renamed from: ir.nasim.du5$B$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.B0(UY6.c(this.a, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.du5$B$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            b(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(UY6.c(this.a, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        B(int i, C12002du5 c12002du5, int i2, int i3) {
            this.a = i;
            this.b = c12002du5;
            this.c = i2;
            this.d = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, C12002du5 c12002du5) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(c12002du5, "this$0");
            dialog.dismiss();
            c12002du5.pd().E2();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog, C12002du5 c12002du5) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(c12002du5, "this$0");
            dialog.dismiss();
            C22042ua0.A9(c12002du5, C7695Su7.INSTANCE.a(c12002du5.pd().v3().getPeerId(), c12002du5.pd().d3() == ExPeerType.GROUP), false, null, 6, null);
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            String strC = UY6.c(this.a, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC2 = UY6.c(RD5.alert_group_owner_yes, interfaceC22053ub1, 0);
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-1999756128, true, new a(this.c), interfaceC22053ub1, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-2001590494, true, new b(this.d), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(657025169);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(this.b);
            final C12002du5 c12002du5 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.ju5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C12002du5.B.d(dialog, c12002du5);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(657034504);
            boolean zD2 = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(this.b);
            final C12002du5 c12002du52 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.ku5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C12002du5.B.f(dialog, c12002du52);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC18060o11E, c0905b, interfaceC18060o11E2, cVar, aVar, sa2, strC, c1454b, (SA2) objB2, strC2, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.du5$C */
    static final class C extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.du5$C$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C12002du5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12002du5 c12002du5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12002du5;
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
                PI7 pi7 = (PI7) this.c;
                TextView textView = this.d.Jc().n0;
                Context contextS7 = this.d.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                textView.setText(C14593iA1.x(contextS7, pi7, true));
                C12002du5 c12002du5 = this.d;
                c12002du5.Pe(c12002du5.Jc().n0.getText().toString());
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(PI7 pi7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(pi7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12002du5.this.new C(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2M4 = C12002du5.this.pd().m4(C12002du5.this.pd().v3().getPeerId());
                a aVar = new a(C12002du5.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2M4, aVar, this) == objE) {
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
            return ((C) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$D */
    static final class D extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.du5$D$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C12002du5 c;

            /* renamed from: ir.nasim.du5$D$a$a, reason: collision with other inner class name */
            static final class C1033a implements InterfaceC4806Gq2 {
                final /* synthetic */ C12002du5 a;

                C1033a(C12002du5 c12002du5) {
                    this.a = c12002du5;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                    C12002du5 c12002du5 = this.a;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        C14755iQ6 c14755iQ6 = (C14755iQ6) it.next();
                        if (c14755iQ6.a().getPeerId() == c12002du5.pd().v3().getPeerId()) {
                            if (c14755iQ6.b()) {
                                c12002du5.Jc().j.setAvatarState(EnumC18928pV.b);
                            } else {
                                c12002du5.Jc().j.setAvatarState(EnumC18928pV.a);
                            }
                        }
                    }
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12002du5 c12002du5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c12002du5;
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
                    InterfaceC10258bL6 interfaceC10258bL6A = InterfaceC23301wh3.a.a().a();
                    C1033a c1033a = new C1033a(this.c);
                    this.b = 1;
                    if (interfaceC10258bL6A.b(c1033a, this) == objE) {
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

        D(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            D d = C12002du5.this.new D(interfaceC20295rm1);
            d.c = obj;
            return d;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new a(C12002du5.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((D) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$E */
    static final class E extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C6281My2 c;
        final /* synthetic */ C12002du5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        E(C6281My2 c6281My2, C12002du5 c12002du5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c6281My2;
            this.d = c12002du5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(C12002du5 c12002du5, CompoundButton compoundButton, boolean z) {
            c12002du5.od().M(c12002du5.pd().v3(), z);
            ConstraintLayout constraintLayout = c12002du5.Jc().o;
            AbstractC13042fc3.h(constraintLayout, "callNotifSoundContainer");
            String string = c12002du5.S7().getString(RD5.features_sharedmedia_call_ringtone_enabled);
            AbstractC13042fc3.h(string, "getString(...)");
            c12002du5.qe(z, constraintLayout, string);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new E(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.p.setChecked(this.d.od().u5(this.d.pd().v3()));
            C12002du5 c12002du5 = this.d;
            boolean zU5 = c12002du5.od().u5(this.d.pd().v3());
            ConstraintLayout constraintLayout = this.d.Jc().o;
            AbstractC13042fc3.h(constraintLayout, "callNotifSoundContainer");
            String string = this.d.S7().getString(RD5.features_sharedmedia_call_ringtone_enabled);
            AbstractC13042fc3.h(string, "getString(...)");
            c12002du5.qe(zU5, constraintLayout, string);
            SwitchCompat switchCompat = this.c.p;
            final C12002du5 c12002du52 = this.d;
            switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.lu5
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    C12002du5.E.y(c12002du52, compoundButton, z);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((E) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$F */
    static final class F implements InterfaceC14603iB2 {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ C12002du5 c;
        final /* synthetic */ C6281My2 d;

        /* renamed from: ir.nasim.du5$F$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;
            final /* synthetic */ String b;
            final /* synthetic */ C12002du5 c;
            final /* synthetic */ C6281My2 d;

            /* renamed from: ir.nasim.du5$F$a$a, reason: collision with other inner class name */
            static final class C1034a implements InterfaceC15796kB2 {
                final /* synthetic */ C12002du5 a;

                C1034a(C12002du5 c12002du5) {
                    this.a = c12002du5;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 d(C12002du5 c12002du5, Dialog dialog) {
                    AbstractC13042fc3.i(c12002du5, "this$0");
                    AbstractC13042fc3.i(dialog, "$it");
                    AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                    Context contextS7 = c12002du5.S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    Uri uri = Uri.parse(c12002du5.od().f0());
                    AbstractC13042fc3.h(uri, "parse(...)");
                    aVar.A(contextS7, uri);
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
                    AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
                    AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
                    int i2 = RD5.features_sharedmedia_ad_panel;
                    InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
                    int i3 = RD5.dialog_negative_button_cancel;
                    InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                    N81 n81 = N81.a;
                    InterfaceC14603iB2 interfaceC14603iB2B = n81.b();
                    InterfaceC14603iB2 interfaceC14603iB2C = n81.c();
                    interfaceC22053ub1.W(1570058233);
                    boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(dialog);
                    final C12002du5 c12002du5 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.ou5
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C12002du5.F.a.C1034a.d(c12002du5, dialog);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa2 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1570081349);
                    boolean zD2 = interfaceC22053ub1.D(dialog);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.pu5
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C12002du5.F.a.C1034a.f(dialog);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC19555qZ.E(interfaceC14603iB2B, cVar, interfaceC14603iB2C, cVar2, aVar, sa2, i2, c1454b, (SA2) objB2, i3, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            a(String str, String str2, C12002du5 c12002du5, C6281My2 c6281My2) {
                this.a = str;
                this.b = str2;
                this.c = c12002du5;
                this.d = c6281My2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(C12002du5 c12002du5) {
                AbstractC13042fc3.i(c12002du5, "this$0");
                SettingsModule settingsModuleOd = c12002du5.od();
                Map mapT = c12002du5.od().T();
                if (mapT.get("notice_bar_interacted_channels") != null) {
                    List list = (List) mapT.get("notice_bar_interacted_channels");
                    if (list != null) {
                        list.add(Integer.valueOf(c12002du5.pd().v3().getPeerId()));
                    }
                } else {
                    mapT.put("notice_bar_interacted_channels", AbstractC10360bX0.s(Integer.valueOf(c12002du5.pd().v3().getPeerId())));
                }
                settingsModuleOd.a6(mapT);
                Context contextS7 = c12002du5.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                InterfaceC18633oz3 interfaceC18633oz3P6 = c12002du5.p6();
                AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
                AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-943841531, true, new C1034a(c12002du5)), 4, null).show();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(C12002du5 c12002du5, C6281My2 c6281My2) {
                AbstractC13042fc3.i(c12002du5, "this$0");
                AbstractC13042fc3.i(c6281My2, "$this_with");
                SettingsModule settingsModuleOd = c12002du5.od();
                Map mapT = c12002du5.od().T();
                if (mapT.get("notice_bar_interacted_channels") != null) {
                    List list = (List) mapT.get("notice_bar_interacted_channels");
                    if (list != null) {
                        list.add(Integer.valueOf(c12002du5.pd().v3().getPeerId()));
                    }
                } else {
                    mapT.put("notice_bar_interacted_channels", AbstractC10360bX0.s(Integer.valueOf(c12002du5.pd().v3().getPeerId())));
                }
                settingsModuleOd.a6(mapT);
                ComposeView composeView = c6281My2.e;
                AbstractC13042fc3.h(composeView, "adDiscountPromotionNoticeBar");
                composeView.setVisibility(8);
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                QC4.b.C0590b c0590b = QC4.b.C0590b.a;
                SC4.a aVar = new SC4.a(this.a);
                RC4.a aVar2 = new RC4.a(this.b);
                String strC = UY6.c(RD5.features_sharedmedia_publish_ad, interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-1489052949);
                boolean zD = interfaceC22053ub1.D(this.c);
                final C12002du5 c12002du5 = this.c;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.mu5
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C12002du5.F.a.d(c12002du5);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                OC4.a aVar3 = new OC4.a(strC, (SA2) objB);
                interfaceC22053ub1.W(-1488940508);
                boolean zD2 = interfaceC22053ub1.D(this.c) | interfaceC22053ub1.D(this.d);
                final C12002du5 c12002du52 = this.c;
                final C6281My2 c6281My2 = this.d;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.nu5
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C12002du5.F.a.f(c12002du52, c6281My2);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                LC4.i(c0590b, aVar, aVar2, aVar3, new PC4.a((SA2) objB2), interfaceC22053ub1, QC4.b.C0590b.b | (SC4.a.b << 3) | (RC4.a.b << 6) | (OC4.a.c << 9) | (PC4.a.b << 12));
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        F(String str, String str2, C12002du5 c12002du5, C6281My2 c6281My2) {
            this.a = str;
            this.b = str2;
            this.c = c12002du5;
            this.d = c6281My2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-506206100, true, new a(this.a, this.b, this.c, this.d), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.du5$G */
    static final class G implements InterfaceC14603iB2 {
        final /* synthetic */ Dialog a;

        G(Dialog dialog) {
            this.a = dialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$channelEarnMoneyGuideDialog");
            dialog.show();
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            QC4.c.a aVar = new QC4.c.a(AbstractC22412vB5.moneys);
            SC4.a aVar2 = new SC4.a(UY6.c(RD5.features_sharedmedia_income_ability_notice_bar_title, interfaceC22053ub1, 0));
            RC4.a aVar3 = new RC4.a(UY6.c(RD5.features_sharedmedia_income_ability_notice_bar_label, interfaceC22053ub1, 0));
            String strC = UY6.c(RD5.features_sharedmedia_activate_notice_bar_button, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(-1627178341);
            boolean zD = interfaceC22053ub1.D(this.a);
            final Dialog dialog = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.qu5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C12002du5.G.c(dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            LC4.u(aVar, aVar2, aVar3, new OC4.a(strC, (SA2) objB), PC4.b.a, interfaceC22053ub1, QC4.c.a.b | (SC4.a.b << 3) | (RC4.a.b << 6) | (OC4.a.c << 9) | (PC4.b.b << 12));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.du5$H */
    static final class H extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C6281My2 c;
        final /* synthetic */ C12002du5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        H(C6281My2 c6281My2, C12002du5 c12002du5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c6281My2;
            this.d = c12002du5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(C12002du5 c12002du5, CompoundButton compoundButton, boolean z) {
            c12002du5.od().P(c12002du5.pd().v3(), z);
            ConstraintLayout constraintLayout = c12002du5.Jc().U;
            AbstractC13042fc3.h(constraintLayout, "notifContainer");
            String string = c12002du5.S7().getString(RD5.settings_notifications);
            AbstractC13042fc3.h(string, "getString(...)");
            c12002du5.qe(z, constraintLayout, string);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new H(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.V.setChecked(this.d.od().H5(this.d.pd().v3()));
            C12002du5 c12002du5 = this.d;
            boolean zH5 = c12002du5.od().H5(this.d.pd().v3());
            ConstraintLayout constraintLayout = this.d.Jc().U;
            AbstractC13042fc3.h(constraintLayout, "notifContainer");
            String string = this.d.S7().getString(RD5.settings_notifications);
            AbstractC13042fc3.h(string, "getString(...)");
            c12002du5.qe(zH5, constraintLayout, string);
            SwitchCompat switchCompat = this.c.V;
            final C12002du5 c12002du52 = this.d;
            switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.ru5
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    C12002du5.H.y(c12002du52, compoundButton, z);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((H) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$I */
    static final class I implements InterfaceC15796kB2 {
        I() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(C12002du5 c12002du5, Dialog dialog) {
            AbstractC13042fc3.i(c12002du5, "this$0");
            AbstractC13042fc3.i(dialog, "$it");
            c12002du5.od().x6(true);
            InterfaceC11677dQ0 interfaceC11677dQ0Kc = c12002du5.Kc();
            C11458d25 c11458d25Y = C11458d25.y(c12002du5.od().h1());
            AbstractC13042fc3.h(c11458d25Y, "group(...)");
            C22042ua0.A9(c12002du5, InterfaceC11677dQ0.b(interfaceC11677dQ0Kc, c11458d25Y, ExPeerType.CHANNEL, Long.valueOf(c12002du5.od().j1()), Long.valueOf(c12002du5.od().i1()), true, null, null, null, null, 0L, null, null, null, false, null, null, null, null, null, false, null, null, null, null, null, false, null, 134217696, null), false, null, 6, null);
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
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            int i2 = RD5.features_sharedmedia_more_information_dialog_start_button;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            int i3 = RD5.features_sharedmedia_understand_dialog_end_button;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            N81 n81 = N81.a;
            InterfaceC14603iB2 interfaceC14603iB2D = n81.d();
            InterfaceC14603iB2 interfaceC14603iB2E = n81.e();
            interfaceC22053ub1.W(-1627257092);
            boolean zD = interfaceC22053ub1.D(C12002du5.this) | interfaceC22053ub1.D(dialog);
            final C12002du5 c12002du5 = C12002du5.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.su5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C12002du5.I.d(c12002du5, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1627221015);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.tu5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C12002du5.I.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2D, cVar, interfaceC14603iB2E, cVar2, aVar, sa2, i2, c1454b, (SA2) objB2, i3, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.du5$J */
    static final class J extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C21379tZ3 d;

        /* renamed from: ir.nasim.du5$J$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C12002du5 c;
            final /* synthetic */ C21379tZ3 d;

            /* renamed from: ir.nasim.du5$J$a$a, reason: collision with other inner class name */
            static final class C1035a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ boolean c;
                final /* synthetic */ C12002du5 d;
                final /* synthetic */ C21379tZ3 e;

                /* renamed from: ir.nasim.du5$J$a$a$a, reason: collision with other inner class name */
                static final class C1036a implements InterfaceC4806Gq2 {
                    final /* synthetic */ boolean a;
                    final /* synthetic */ C21379tZ3 b;
                    final /* synthetic */ C12002du5 c;

                    /* renamed from: ir.nasim.du5$J$a$a$a$a, reason: collision with other inner class name */
                    public static final class C1037a extends ViewPager2.i {
                        final /* synthetic */ C12002du5 a;
                        final /* synthetic */ List b;

                        C1037a(C12002du5 c12002du5, List list) {
                            this.a = c12002du5;
                            this.b = list;
                        }

                        @Override // androidx.viewpager2.widget.ViewPager2.i
                        public void c(int i) {
                            String str;
                            super.c(i);
                            HashMap map = new HashMap();
                            C12002du5 c12002du5 = this.a;
                            Integer num = (Integer) AbstractC15401jX0.t0(this.b, i);
                            int i2 = RD5.media_picture;
                            if (num != null && num.intValue() == i2) {
                                str = "picture";
                            } else {
                                int i3 = RD5.media_video2;
                                if (num != null && num.intValue() == i3) {
                                    str = MediaStreamTrack.VIDEO_TRACK_KIND;
                                } else {
                                    int i4 = RD5.media_Document;
                                    if (num != null && num.intValue() == i4) {
                                        str = "file";
                                    } else {
                                        int i5 = RD5.shared_media_audio;
                                        if (num != null && num.intValue() == i5) {
                                            str = "music";
                                        } else {
                                            int i6 = RD5.media_audio;
                                            if (num != null && num.intValue() == i6) {
                                                str = "voice";
                                            } else {
                                                int i7 = RD5.group_members;
                                                if (num != null && num.intValue() == i7) {
                                                    str = "member";
                                                } else {
                                                    int i8 = RD5.media_link;
                                                    if (num != null && num.intValue() == i8) {
                                                        str = "link";
                                                    } else {
                                                        str = (num != null && num.intValue() == RD5.media_recommended_peer_bot) ? "recommended" : null;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            c12002du5.event_type = str;
                            String str2 = this.a.event_type;
                            if (str2 != null) {
                                C12002du5 c12002du52 = this.a;
                                map.put("peer_id", Integer.valueOf(c12002du52.pd().v3().getPeerId()));
                                String lowerCase = c12002du52.pd().d3().name().toLowerCase(Locale.ROOT);
                                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                                map.put("peer_type", lowerCase);
                                map.put("event_type", str2);
                                C3343Am.i("shared_media_tab_navigation", map);
                            }
                        }
                    }

                    C1036a(boolean z, C21379tZ3 c21379tZ3, C12002du5 c12002du5) {
                        this.a = z;
                        this.b = c21379tZ3;
                        this.c = c12002du5;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void g(List list, C12002du5 c12002du5, TabLayout.g gVar, int i) {
                        AbstractC13042fc3.i(list, "$sharedMediaTabs");
                        AbstractC13042fc3.i(c12002du5, "this$0");
                        AbstractC13042fc3.i(gVar, "tab");
                        Integer num = (Integer) AbstractC15401jX0.t0(list, i);
                        gVar.y(num != null ? c12002du5.h6(num.intValue()) : null);
                    }

                    @Override // ir.nasim.InterfaceC4806Gq2
                    /* renamed from: e, reason: merged with bridge method [inline-methods] */
                    public final Object a(final List list, InterfaceC20295rm1 interfaceC20295rm1) {
                        if (this.a) {
                            list.add(0, AbstractC6392Nk0.d(RD5.group_members));
                        }
                        this.b.U(list);
                        this.b.T(this.a);
                        TabLayout tabLayout = this.c.Jc().j0;
                        ViewPager2 viewPager2 = this.c.Jc().Y;
                        final C12002du5 c12002du5 = this.c;
                        new com.google.android.material.tabs.d(tabLayout, viewPager2, new d.b() { // from class: ir.nasim.uu5
                            @Override // com.google.android.material.tabs.d.b
                            public final void a(TabLayout.g gVar, int i) {
                                C12002du5.J.a.C1035a.C1036a.g(list, c12002du5, gVar, i);
                            }
                        }).a();
                        C12002du5 c12002du52 = this.c;
                        TabLayout tabLayout2 = c12002du52.Jc().j0;
                        AbstractC13042fc3.h(tabLayout2, "tabLayout");
                        c12002du52.re(tabLayout2, list.size());
                        this.c.Jc().Y.k(new C1037a(this.c, list));
                        return C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1035a(C12002du5 c12002du5, C21379tZ3 c21379tZ3, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c12002du5;
                    this.e = c21379tZ3;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1035a c1035a = new C1035a(this.d, this.e, interfaceC20295rm1);
                    c1035a.c = ((Boolean) obj).booleanValue();
                    return c1035a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        boolean z = this.c;
                        InterfaceC10258bL6 interfaceC10258bL6H3 = this.d.pd().H3();
                        C1036a c1036a = new C1036a(z, this.e, this.d);
                        this.b = 1;
                        if (interfaceC10258bL6H3.b(c1036a, this) == objE) {
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

                public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1035a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12002du5 c12002du5, C21379tZ3 c21379tZ3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c12002du5;
                this.d = c21379tZ3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    this.c.pd().d4();
                    InterfaceC10258bL6 interfaceC10258bL6B3 = this.c.pd().b3();
                    C1035a c1035a = new C1035a(this.c, this.d, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC10258bL6B3, c1035a, this) == objE) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        J(C21379tZ3 c21379tZ3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c21379tZ3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12002du5.this.new J(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C12002du5 c12002du5 = C12002du5.this;
            AbstractC16751lo1.c(c12002du5, j.b.STARTED, new a(c12002du5, this.d, null));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((J) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$K */
    static final class K extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.du5$K$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ C12002du5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12002du5 c12002du5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12002du5;
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
                    this.d.wc(true);
                    this.d.rd();
                } else {
                    this.d.wc(false);
                }
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        K(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12002du5.this.new K(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6Z3 = C12002du5.this.pd().Z3();
                a aVar = new a(C12002du5.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6Z3, aVar, this) == objE) {
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
            return ((K) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$L */
    static final class L implements InterfaceC15796kB2 {
        final /* synthetic */ C21231tK7 b;

        /* renamed from: ir.nasim.du5$L$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C21231tK7 a;

            a(C21231tK7 c21231tK7) {
                this.a = c21231tK7;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(UY6.d(RD5.profile_settings_block_bot_confirm, new Object[]{this.a.r().b()}, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        L(C21231tK7 c21231tK7) {
            this.b = c21231tK7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog, final C12002du5 c12002du5, final boolean z) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(c12002du5, "this$0");
            dialog.dismiss();
            c12002du5.pd().n2(true, new SA2() { // from class: ir.nasim.xu5
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C12002du5.L.h(z, c12002du5);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(boolean z, C12002du5 c12002du5) {
            AbstractC13042fc3.i(c12002du5, "this$0");
            if (z) {
                c12002du5.pd().E2();
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$dialog");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void d(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            String strH6 = C12002du5.this.h6(RD5.alert_delete_chat_yes);
            AbstractC13042fc3.h(strH6, "getString(...)");
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            String strH62 = C12002du5.this.h6(RD5.profile_settings_block);
            AbstractC13042fc3.h(strH62, "getString(...)");
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strH63 = C12002du5.this.h6(RD5.dialog_cancel);
            AbstractC13042fc3.h(strH63, "getString(...)");
            InterfaceC14603iB2 interfaceC14603iB2A = N81.a.a();
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-292058127, true, new a(this.b), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(1502447296);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(C12002du5.this);
            final C12002du5 c12002du5 = C12002du5.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.vu5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C12002du5.L.f(dialog, c12002du5, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1502461639);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.wu5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C12002du5.L.i(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.I(interfaceC14603iB2A, cVar, interfaceC18060o11E, cVar2, aVar, ua2, strH62, c1454b, (SA2) objB2, strH63, null, strH6, true, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 384, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            d((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.du5$M */
    static final class M implements InterfaceC15796kB2 {
        final /* synthetic */ int a;
        final /* synthetic */ C12002du5 b;
        final /* synthetic */ int c;

        /* renamed from: ir.nasim.du5$M$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            a(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.B0(UY6.c(this.a, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.du5$M$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            b(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(UY6.c(this.a, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        M(int i, C12002du5 c12002du5, int i2) {
            this.a = i;
            this.b = c12002du5;
            this.c = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, C12002du5 c12002du5) {
            AbstractC13042fc3.i(dialog, "$dialog");
            AbstractC13042fc3.i(c12002du5, "this$0");
            dialog.dismiss();
            c12002du5.pd().E2();
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
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            String strC = UY6.c(this.a, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            String strC2 = UY6.c(RD5.dialog_cancel, interfaceC22053ub1, 0);
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(1898250201, true, new a(this.a), interfaceC22053ub1, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(135424475, true, new b(this.c), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(-1581078614);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(this.b);
            final C12002du5 c12002du5 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.yu5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C12002du5.M.d(dialog, c12002du5);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1581070060);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.zu5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C12002du5.M.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC18060o11E, c0905b, interfaceC18060o11E2, cVar, aVar, sa2, strC, c1454b, (SA2) objB2, strC2, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.du5$N */
    public static final class N extends AbstractC8614Ws3 implements UA2 {
        public N() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C6281My2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.du5$O */
    public static final class O extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public O(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.du5$P */
    public static final class P extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public P(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.du5$Q */
    public static final class Q extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Q(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.du5$R */
    public static final class R extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public R(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.du5$S */
    public static final class S extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public S(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.du5$T */
    static final class T extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ StoryOwnerFragment c;
        final /* synthetic */ C12002du5 d;

        /* renamed from: ir.nasim.du5$T$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C12002du5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12002du5 c12002du5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12002du5;
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
                String str = (String) this.c;
                C17468n10 c17468n10 = this.d.snackBar;
                if (c17468n10 != null) {
                    c17468n10.o(str);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.du5$T$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.du5$T$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.du5$T$b$a$a, reason: collision with other inner class name */
                public static final class C1038a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1038a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r6 instanceof ir.nasim.C12002du5.T.b.a.C1038a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.du5$T$b$a$a r0 = (ir.nasim.C12002du5.T.b.a.C1038a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.du5$T$b$a$a r0 = new ir.nasim.du5$T$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L4e
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        r2 = r5
                        java.lang.String r2 = (java.lang.String) r2
                        int r2 = r2.length()
                        if (r2 != 0) goto L41
                        r2 = r3
                        goto L42
                    L41:
                        r2 = 0
                    L42:
                        r2 = r2 ^ r3
                        if (r2 == 0) goto L4e
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L4e
                        return r1
                    L4e:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12002du5.T.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        T(StoryOwnerFragment storyOwnerFragment, C12002du5 c12002du5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = storyOwnerFragment;
            this.d = c12002du5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new T(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(this.c.ka());
                a aVar = new a(this.d, null);
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
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((T) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$U */
    static final class U implements InterfaceC14603iB2 {
        final /* synthetic */ AbstractC4886Gz1.b a;
        final /* synthetic */ C12002du5 b;

        /* renamed from: ir.nasim.du5$U$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ AbstractC4886Gz1.b a;
            final /* synthetic */ C12002du5 b;

            a(AbstractC4886Gz1.b bVar, C12002du5 c12002du5) {
                this.a = bVar;
                this.b = c12002du5;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(C12002du5 c12002du5, AbstractC4886Gz1.b bVar) {
                AbstractC13042fc3.i(c12002du5, "this$0");
                AbstractC13042fc3.i(bVar, "$data");
                C22042ua0.w9(c12002du5, c12002du5.qd().a(new WebAppArguments(bVar.o().a(), bVar.o().b() != null ? new WebAppType.DirectLink(bVar.o().b(), bVar.o().c()) : new WebAppType.Main(bVar.o().c()), H48.c, AbstractC17026mG5.a.f(), null, null, null, false, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, null)), false, null, 6, null);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(C12002du5 c12002du5) {
                AbstractC13042fc3.i(c12002du5, "this$0");
                C22042ua0.w9(c12002du5, c12002du5.qd().a(new WebAppArguments(c12002du5.pd().v3().getPeerId(), new WebAppType.Main(null), H48.c, AbstractC17026mG5.a.f(), null, null, null, false, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, null)), false, null, 6, null);
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C24254yJ.f fVarB = C24254yJ.a.b();
                InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null);
                final AbstractC4886Gz1.b bVar = this.a;
                final C12002du5 c12002du5 = this.b;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarB, bVarG, interfaceC22053ub1, 54);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH);
                InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar.a();
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                if (bVar.o() != null) {
                    interfaceC22053ub1.W(-753169146);
                    interfaceC22053ub1.W(-1132672762);
                    boolean zD = interfaceC22053ub1.D(c12002du5) | interfaceC22053ub1.D(bVar);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.Au5
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C12002du5.U.a.d(c12002du5, bVar);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    c12002du5.Db((SA2) objB, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                } else if (bVar.f()) {
                    interfaceC22053ub1.W(-751885374);
                    interfaceC22053ub1.W(-1132631164);
                    boolean zD2 = interfaceC22053ub1.D(c12002du5);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.Bu5
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C12002du5.U.a.f(c12002du5);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    c12002du5.Ab((SA2) objB2, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(-751173273);
                    interfaceC22053ub1.Q();
                }
                interfaceC22053ub1.W(-1132608708);
                if (bVar.n() && C8386Vt0.a.ta()) {
                    MY2.b(null, EnumC10352bW1.a, DX0.b(C5495Jo7.a.r0()), interfaceC22053ub1, 48, 1);
                    c12002du5.xb(interfaceC22053ub1, 0);
                }
                interfaceC22053ub1.Q();
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        U(AbstractC4886Gz1.b bVar, C12002du5 c12002du5) {
            this.a = bVar;
            this.b = c12002du5;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-1671224326, true, new a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.du5$a, reason: case insensitive filesystem and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C12002du5 a(int i, boolean z, boolean z2) {
            C12002du5 c12002du5 = new C12002du5();
            Bundle bundle = new Bundle();
            bundle.putInt("uid_profile_fragment", i);
            bundle.putBoolean("is_private", z);
            bundle.putBoolean("open_photo", z2);
            c12002du5.a8(bundle);
            return c12002du5;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.du5$b, reason: case insensitive filesystem */
    static final class C12004b implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ C12002du5 b;

        /* renamed from: ir.nasim.du5$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ androidx.compose.ui.e a;
            final /* synthetic */ C12002du5 b;

            a(androidx.compose.ui.e eVar, C12002du5 c12002du5) {
                this.a = eVar;
                this.b = c12002du5;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                androidx.compose.ui.e eVar = this.a;
                G10 g10 = G10.a;
                int i2 = G10.b;
                AbstractC24077y03.b(FV4.c(this.b.Ic(), interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(eVar, g10.c(interfaceC22053ub1, i2).b().j()), g10.a(interfaceC22053ub1, i2).B(), interfaceC22053ub1, 48, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        C12004b(SA2 sa2, C12002du5 c12002du5) {
            this.a = sa2;
            this.b = c12002du5;
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "it");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.V(eVar) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC20434s03.a(this.a, androidx.compose.foundation.layout.t.t(eVar, G10.a.c(interfaceC22053ub1, G10.b).b().m()), false, null, null, AbstractC19242q11.e(1679661931, true, new a(eVar, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 196608, 28);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.du5$c, reason: case insensitive filesystem */
    public /* synthetic */ class C12005c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ExPeerType.THREAD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ExPeerType.UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.du5$d, reason: case insensitive filesystem */
    static final class C12006d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.du5$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C12002du5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12002du5 c12002du5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12002du5;
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
                String strB = ((KW3) AbstractC15401jX0.q0(((C19951rD2) this.c).a())).b();
                if (this.d.pd().v3().s() == W25.a && this.d.pd().Y3()) {
                    this.d.pd().t2(strB);
                } else if (this.d.pd().v3().s() == W25.b) {
                    this.d.pd().p2(this.d.pd().v3().getPeerId(), strB);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C19951rD2 c19951rD2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c19951rD2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C12006d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12002du5.this.new C12006d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2H3 = C12002du5.this.pd().h3();
                a aVar = new a(C12002du5.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2H3, aVar, this) == objE) {
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
            return ((C12006d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$e, reason: case insensitive filesystem */
    static final class C12007e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.du5$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C12002du5 c;

            /* renamed from: ir.nasim.du5$e$a$a, reason: collision with other inner class name */
            static final class C1039a implements InterfaceC4806Gq2 {
                final /* synthetic */ C12002du5 a;

                /* renamed from: ir.nasim.du5$e$a$a$a, reason: collision with other inner class name */
                static final class C1040a implements InterfaceC15796kB2 {
                    final /* synthetic */ KA3 a;
                    final /* synthetic */ C12002du5 b;

                    C1040a(KA3 ka3, C12002du5 c12002du5) {
                        this.a = ka3;
                        this.b = c12002du5;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 c(C12002du5 c12002du5, KA3 ka3) {
                        AbstractC13042fc3.i(c12002du5, "this$0");
                        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                        Context contextS7 = c12002du5.S7();
                        AbstractC13042fc3.h(contextS7, "requireContext(...)");
                        aVar.A(contextS7, Uri.parse(((KA3.a) ka3).a()));
                        return C19938rB7.a;
                    }

                    public final void b(Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(dialog, "dialog");
                        String strA = ((KA3.a) this.a).a();
                        interfaceC22053ub1.W(93655019);
                        boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
                        final C12002du5 c12002du5 = this.b;
                        final KA3 ka3 = this.a;
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.eu5
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C12002du5.C12007e.a.C1039a.C1040a.c(c12002du5, ka3);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC10781cB3.q(dialog, strA, (SA2) objB, interfaceC22053ub1, i & 14);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.du5$e$a$a$b */
                static final class b implements InterfaceC15796kB2 {
                    final /* synthetic */ KA3 a;

                    b(KA3 ka3) {
                        this.a = ka3;
                    }

                    public final void a(Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(dialog, "dialog");
                        AbstractC10781cB3.n(dialog, ((KA3.b) this.a).b(), interfaceC22053ub1, i & 14);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        a((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.du5$e$a$a$c */
                static final class c implements InterfaceC15796kB2 {
                    final /* synthetic */ KA3 a;
                    final /* synthetic */ C12002du5 b;

                    c(KA3 ka3, C12002du5 c12002du5) {
                        this.a = ka3;
                        this.b = c12002du5;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 c(C12002du5 c12002du5, KA3 ka3) {
                        AbstractC13042fc3.i(c12002du5, "this$0");
                        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                        Context contextS7 = c12002du5.S7();
                        AbstractC13042fc3.h(contextS7, "requireContext(...)");
                        aVar.A(contextS7, Uri.parse(((KA3.b) ka3).b()));
                        return C19938rB7.a;
                    }

                    public final void b(Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(dialog, "dialog");
                        String strB = ((KA3.b) this.a).b();
                        interfaceC22053ub1.W(93703091);
                        boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
                        final C12002du5 c12002du5 = this.b;
                        final KA3 ka3 = this.a;
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.fu5
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C12002du5.C12007e.a.C1039a.c.c(c12002du5, ka3);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC10781cB3.C(dialog, strB, (SA2) objB, interfaceC22053ub1, i & 14);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.du5$e$a$a$d */
                public /* synthetic */ class d {
                    public static final /* synthetic */ int[] a;

                    static {
                        int[] iArr = new int[EnumC4458Ff2.values().length];
                        try {
                            iArr[EnumC4458Ff2.a.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[EnumC4458Ff2.b.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[EnumC4458Ff2.c.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        a = iArr;
                    }
                }

                C1039a(C12002du5 c12002du5) {
                    this.a = c12002du5;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(KA3 ka3, InterfaceC20295rm1 interfaceC20295rm1) {
                    this.a.Jc().N.setVisibility(8);
                    if (ka3 == null) {
                        return C19938rB7.a;
                    }
                    if (ka3 instanceof KA3.a) {
                        Context contextS7 = this.a.S7();
                        AbstractC13042fc3.h(contextS7, "requireContext(...)");
                        C12002du5 c12002du5 = this.a;
                        AbstractC21375tZ.c(contextS7, c12002du5, null, AbstractC19242q11.c(-924641909, true, new C1040a(ka3, c12002du5)), 4, null).show();
                    } else {
                        if (!(ka3 instanceof KA3.b)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        KA3.b bVar = (KA3.b) ka3;
                        int i = d.a[bVar.a().ordinal()];
                        if (i == 1) {
                            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                            Context contextS72 = this.a.S7();
                            AbstractC13042fc3.h(contextS72, "requireContext(...)");
                            aVar.A(contextS72, Uri.parse(bVar.b()));
                        } else if (i == 2) {
                            Context contextS73 = this.a.S7();
                            AbstractC13042fc3.h(contextS73, "requireContext(...)");
                            AbstractC21375tZ.c(contextS73, this.a, null, AbstractC19242q11.c(1127517249, true, new b(ka3)), 4, null).show();
                        } else {
                            if (i != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            Context contextS74 = this.a.S7();
                            AbstractC13042fc3.h(contextS74, "requireContext(...)");
                            C12002du5 c12002du52 = this.a;
                            AbstractC21375tZ.c(contextS74, c12002du52, null, AbstractC19242q11.c(-2025102462, true, new c(ka3, c12002du52)), 4, null).show();
                        }
                    }
                    this.a.pd().q4();
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12002du5 c12002du5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c12002du5;
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
                    InterfaceC10258bL6 interfaceC10258bL6M3 = this.c.pd().m3();
                    C1039a c1039a = new C1039a(this.c);
                    this.b = 1;
                    if (interfaceC10258bL6M3.b(c1039a, this) == objE) {
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

        C12007e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12002du5.this.new C12007e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C12002du5 c12002du5 = C12002du5.this;
                j.b bVar = j.b.RESUMED;
                a aVar = new a(c12002du5, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c12002du5, bVar, aVar, this) == objE) {
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
            return ((C12007e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$f, reason: case insensitive filesystem */
    static final class C12008f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List c;
        final /* synthetic */ C12002du5 d;
        final /* synthetic */ ExPeerType e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12008f(List list, C12002du5 c12002du5, ExPeerType exPeerType, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = list;
            this.d = c12002du5;
            this.e = exPeerType;
            this.f = list2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D(List list, C12002du5 c12002du5, List list2, List list3, C9663aL5 c9663aL5, View view) {
            if (!list.isEmpty()) {
                c12002du5.pd().F2(AbstractC15401jX0.m1(list2), list, list3, !c9663aL5.a);
                HashMap map = new HashMap();
                String str = c12002du5.event_type;
                if (str != null) {
                    map.put("peer_id", Integer.valueOf(c12002du5.pd().v3().getPeerId()));
                    String lowerCase = c12002du5.pd().v3().s().toString().toLowerCase(Locale.ROOT);
                    AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                    map.put("peer_type", lowerCase);
                    map.put("tab", str);
                    map.put("action_type", 1);
                    C3343Am.i("shared_media_file_action", map);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(C9663aL5 c9663aL5, CompoundButton compoundButton, boolean z) {
            c9663aL5.a = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new C12008f(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x012c  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 420
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12002du5.C12008f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C12008f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$g, reason: case insensitive filesystem */
    static final class C12009g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;
        final /* synthetic */ int e;
        final /* synthetic */ SA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12009g(List list, int i, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
            this.e = i;
            this.f = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(int i, C12002du5 c12002du5, SA2 sa2, List list) {
            if (i > 1) {
                C8671Wy6 c8671Wy6Pd = c12002du5.pd();
                String strH6 = c12002du5.h6(RD5.messages_were_forwarded);
                AbstractC13042fc3.h(strH6, "getString(...)");
                c8671Wy6Pd.I2(strH6);
            } else {
                C8671Wy6 c8671Wy6Pd2 = c12002du5.pd();
                String strH62 = c12002du5.h6(RD5.message_was_forwarded);
                AbstractC13042fc3.h(strH62, "getString(...)");
                c8671Wy6Pd2.I2(strH62);
            }
            HashMap map = new HashMap();
            String str = c12002du5.event_type;
            if (str != null) {
                map.put("peer_id", Integer.valueOf(c12002du5.pd().v3().getPeerId()));
                String lowerCase = c12002du5.pd().v3().s().toString().toLowerCase(Locale.ROOT);
                AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
                map.put("peer_type", lowerCase);
                map.put("tab", str);
                map.put("action_type", 2);
                C3343Am.i("shared_media_file_action", map);
            }
            sa2.invoke();
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12002du5.this.new C12009g(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            C12002du5 c12002du5 = C12002du5.this;
            C11458d25 c11458d25V3 = c12002du5.pd().v3();
            List list = this.d;
            Context contextS7 = C12002du5.this.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            final int i = this.e;
            final C12002du5 c12002du52 = C12002du5.this;
            final SA2 sa2 = this.f;
            c12002du5.Ac(c11458d25V3, list, contextS7, false, new UA2() { // from class: ir.nasim.iu5
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return C12002du5.C12009g.y(i, c12002du52, sa2, (List) obj2);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C12009g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$h, reason: case insensitive filesystem */
    /* synthetic */ class C12010h extends EB2 implements SA2 {
        C12010h(Object obj) {
            super(0, obj, C12002du5.class, "changeAvatarMenu", "changeAvatarMenu()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C12002du5) this.receiver).qc();
        }
    }

    /* renamed from: ir.nasim.du5$i, reason: case insensitive filesystem */
    /* synthetic */ class C12011i extends EB2 implements SA2 {
        C12011i(Object obj) {
            super(0, obj, C12002du5.class, "changeAvatarMenu", "changeAvatarMenu()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C12002du5) this.receiver).qc();
        }
    }

    /* renamed from: ir.nasim.du5$j, reason: case insensitive filesystem */
    /* synthetic */ class C12012j extends EB2 implements SA2 {
        C12012j(Object obj) {
            super(0, obj, C12002du5.class, "showMembersAccessFragment", "showMembersAccessFragment()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C12002du5) this.receiver).De();
        }
    }

    /* renamed from: ir.nasim.du5$k, reason: case insensitive filesystem */
    /* synthetic */ class C12013k extends EB2 implements SA2 {
        C12013k(Object obj) {
            super(0, obj, C12002du5.class, "showReactionSettingsFragment", "showReactionSettingsFragment()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C12002du5) this.receiver).Ee();
        }
    }

    /* renamed from: ir.nasim.du5$l, reason: case insensitive filesystem */
    /* synthetic */ class C12014l extends EB2 implements SA2 {
        C12014l(Object obj) {
            super(0, obj, C12002du5.class, "showLeaveAndDeleteDialog", "showLeaveAndDeleteDialog()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C12002du5) this.receiver).Ce();
        }
    }

    /* renamed from: ir.nasim.du5$m, reason: case insensitive filesystem */
    /* synthetic */ class C12015m extends EB2 implements SA2 {
        C12015m(Object obj) {
            super(0, obj, C12002du5.class, "showMembersAccessFragment", "showMembersAccessFragment()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C12002du5) this.receiver).De();
        }
    }

    /* renamed from: ir.nasim.du5$n, reason: case insensitive filesystem */
    /* synthetic */ class C12016n extends EB2 implements SA2 {
        C12016n(Object obj) {
            super(0, obj, C12002du5.class, "showReactionSettingsFragment", "showReactionSettingsFragment()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C12002du5) this.receiver).Ee();
        }
    }

    /* renamed from: ir.nasim.du5$o, reason: case insensitive filesystem */
    /* synthetic */ class C12017o extends EB2 implements SA2 {
        C12017o(Object obj) {
            super(0, obj, C12002du5.class, "showReactionSettingsFragment", "showReactionSettingsFragment()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C12002du5) this.receiver).Ee();
        }
    }

    /* renamed from: ir.nasim.du5$p, reason: case insensitive filesystem */
    /* synthetic */ class C12018p extends EB2 implements SA2 {
        C12018p(Object obj) {
            super(0, obj, C12002du5.class, "showLeaveAndDeleteDialog", "showLeaveAndDeleteDialog()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C12002du5) this.receiver).Ce();
        }
    }

    /* renamed from: ir.nasim.du5$q, reason: case insensitive filesystem */
    /* synthetic */ class C12019q extends C23553x7 implements SA2 {
        C12019q(Object obj) {
            super(0, obj, C12002du5.class, "openEditChannelNickNameDialog", "openEditChannelNickNameDialog(Lir/nasim/core/modules/groups/entity/GroupType;)V", 0);
        }

        public final void a() {
            C12002du5.be((C12002du5) this.a, null, 1, null);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.du5$r, reason: case insensitive filesystem */
    /* synthetic */ class C12020r extends EB2 implements SA2 {
        C12020r(Object obj) {
            super(0, obj, C12002du5.class, "showReactionSettingsFragment", "showReactionSettingsFragment()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C12002du5) this.receiver).Ee();
        }
    }

    /* renamed from: ir.nasim.du5$s, reason: case insensitive filesystem */
    static final class C12021s extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.du5$s$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C12002du5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12002du5 c12002du5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12002du5;
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
                List list = (List) this.c;
                ImageView imageView = this.d.Jc().z;
                AbstractC13042fc3.h(imageView, "downloadImg");
                imageView.setVisibility(list.isEmpty() ? 0 : 8);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C12021s(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12002du5.this.new C12021s(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6F3 = C12002du5.this.pd().F3();
                a aVar = new a(C12002du5.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6F3, aVar, this) == objE) {
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
            return ((C12021s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$t, reason: case insensitive filesystem */
    static final class C12022t extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C24119y45 d;

        /* renamed from: ir.nasim.du5$t$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ int c;
            final /* synthetic */ C12002du5 d;
            final /* synthetic */ C24119y45 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12002du5 c12002du5, C24119y45 c24119y45, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12002du5;
                this.e = c24119y45;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = ((Number) obj).intValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Number) obj).intValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                C24119y45 c24119y45;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                int i = this.c;
                if (((Boolean) this.d.pd().Z3().getValue()).booleanValue()) {
                    this.d.Jc().d0.setText(JF5.g() ? GY6.a(String.valueOf(i)) : GY6.b(String.valueOf(i)));
                }
                if (this.d.pd().X3() || ((c24119y45 = this.e) != null && c24119y45.n() && i == 1)) {
                    this.d.Jc().g0.setVisibility(0);
                } else {
                    this.d.Jc().g0.setVisibility(8);
                }
                if (i > 0) {
                    this.d.Jc().E.setVisibility(0);
                    this.d.Jc().y.setVisibility(0);
                } else {
                    this.d.Jc().E.setVisibility(8);
                    this.d.Jc().y.setVisibility(8);
                }
                return C19938rB7.a;
            }

            public final Object n(int i, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Integer.valueOf(i), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12022t(C24119y45 c24119y45, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c24119y45;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12002du5.this.new C12022t(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4G3 = C12002du5.this.pd().G3();
                a aVar = new a(C12002du5.this, this.d, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC9336Zm4G3, aVar, this) == objE) {
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
            return ((C12022t) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$u, reason: case insensitive filesystem */
    static final class C12023u extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.du5$u$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C12002du5 d;
            final /* synthetic */ InterfaceC20315ro1 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12002du5 c12002du5, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12002du5;
                this.e = interfaceC20315ro1;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object next;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                PA7 pa7 = (PA7) this.c;
                if (pa7 instanceof PA7.c) {
                    if (this.d.loadedInitialData) {
                        this.d.Le(((PA7.c) pa7).a());
                    } else {
                        this.d.je();
                        this.d.pc();
                        this.d.Le(((PA7.c) pa7).a());
                        this.d.loadedInitialData = true;
                    }
                } else if (pa7 instanceof PA7.b) {
                    this.d.Jc().G.setVisibility(8);
                    this.d.Jc().k.setVisibility(8);
                    this.d.Jc().N.setVisibility(0);
                } else {
                    if (!(pa7 instanceof PA7.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    List listC0 = this.d.Q7().B0().C0();
                    AbstractC13042fc3.h(listC0, "getFragments(...)");
                    Iterator it = listC0.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (((Fragment) next) instanceof C13090h) {
                            break;
                        }
                    }
                    Fragment fragment = (Fragment) next;
                    if (fragment != null) {
                        C12002du5 c12002du5 = this.d;
                        ((C13090h) fragment).Bd(c12002du5.pd().v3(), c12002du5.pd().d3(), null);
                    } else {
                        this.d.pd().D2();
                    }
                    C12002du5 c12002du52 = this.d;
                    FragmentActivity fragmentActivityQ7 = c12002du52.Q7();
                    AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
                    c12002du52.j9(fragmentActivityQ7);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(PA7 pa7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(pa7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C12023u(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C12023u c12023u = C12002du5.this.new C12023u(interfaceC20295rm1);
            c12023u.c = obj;
            return c12023u;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC10258bL6 interfaceC10258bL6J3 = C12002du5.this.pd().J3();
                a aVar = new a(C12002du5.this, interfaceC20315ro1, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6J3, aVar, this) == objE) {
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
            return ((C12023u) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$v, reason: case insensitive filesystem */
    static final class C12024v extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.du5$v$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C12002du5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12002du5 c12002du5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12002du5;
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
                String str = (String) this.c;
                C17468n10 c17468n10 = this.d.snackBar;
                if (c17468n10 != null) {
                    c17468n10.o(str);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        C12024v(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12002du5.this.new C12024v(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC8327Vm4 interfaceC8327Vm4J3 = C12002du5.this.pd().j3();
                a aVar = new a(C12002du5.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC8327Vm4J3, aVar, this) == objE) {
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
            return ((C12024v) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$w */
    static final class w extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.du5$w$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C12002du5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12002du5 c12002du5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12002du5;
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
                if (((AbstractC17858ng6) this.c) instanceof AbstractC17858ng6.a) {
                    this.d.Jc().m.setExpanded(false);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC17858ng6 abstractC17858ng6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(abstractC17858ng6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.du5$w$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.du5$w$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.du5$w$b$a$a, reason: collision with other inner class name */
                public static final class C1041a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1041a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                        boolean r0 = r6 instanceof ir.nasim.C12002du5.w.b.a.C1041a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.du5$w$b$a$a r0 = (ir.nasim.C12002du5.w.b.a.C1041a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.du5$w$b$a$a r0 = new ir.nasim.du5$w$b$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.Gq2 r6 = r4.a
                        ir.nasim.fi6 r5 = (ir.nasim.C13132fi6) r5
                        ir.nasim.ng6 r5 = r5.c()
                        r0.b = r3
                        java.lang.Object r5 = r6.a(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12002du5.w.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
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

        w(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12002du5.this.new w(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                b bVar = new b(C12002du5.this.pd().D3());
                a aVar = new a(C12002du5.this, null);
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
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((w) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$x */
    static final class x extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.du5$x$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C12002du5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12002du5 c12002du5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12002du5;
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
                if (((AbstractC17858ng6) this.c) instanceof AbstractC17858ng6.a) {
                    this.d.Jc().m.setExpanded(false);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC17858ng6 abstractC17858ng6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(abstractC17858ng6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        x(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C12002du5.this.new x(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6C3 = C12002du5.this.pd().C3();
                a aVar = new a(C12002du5.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6C3, aVar, this) == objE) {
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
            return ((x) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.du5$y */
    public static final class y implements InputFilter {
        private final List a = AbstractC15401jX0.S0(AbstractC15401jX0.P0(new C12266eK0('a', 'z'), new C12266eK0('0', '9')), '_');

        y() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AbstractC13042fc3.i(spanned, "dest");
            if (charSequence == null) {
                return null;
            }
            String string = charSequence.toString();
            Locale locale = Locale.getDefault();
            AbstractC13042fc3.h(locale, "getDefault(...)");
            String lowerCase = string.toLowerCase(locale);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            StringBuilder sb = new StringBuilder();
            for (int i5 = i; i5 < i2; i5++) {
                char cCharAt = lowerCase.charAt(i5);
                if (this.a.contains(Character.valueOf(cCharAt))) {
                    sb.append(cCharAt);
                }
            }
            if (sb.length() == i2 - i && AbstractC13042fc3.d(lowerCase, charSequence.toString())) {
                return null;
            }
            return sb.toString();
        }
    }

    /* renamed from: ir.nasim.du5$z */
    static final class z extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ C12889fL5 e;
        final /* synthetic */ ZN2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        z(C12889fL5 c12889fL5, ZN2 zn2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c12889fL5;
            this.f = zn2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            z zVar = C12002du5.this.new z(this.e, this.f, interfaceC20295rm1);
            zVar.c = obj;
            return zVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objK2;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                CharSequence charSequence = (CharSequence) this.c;
                C8671Wy6 c8671Wy6Pd = C12002du5.this.pd();
                String strValueOf = String.valueOf(charSequence);
                this.b = 1;
                objK2 = c8671Wy6Pd.k2(strValueOf, this);
                if (objK2 == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objK2 = ((C9475a16) obj).l();
            }
            C12889fL5 c12889fL5 = this.e;
            if (C9475a16.j(objK2)) {
                ((Boolean) objK2).booleanValue();
                AppCompatEditText appCompatEditTextQ = ((MY) c12889fL5.a).q();
                if (appCompatEditTextQ != null) {
                    appCompatEditTextQ.setError(null);
                }
            }
            C12889fL5 c12889fL52 = this.e;
            C12002du5 c12002du5 = C12002du5.this;
            ZN2 zn2 = this.f;
            Throwable thE = C9475a16.e(objK2);
            if (thE != null) {
                MY my = (MY) c12889fL52.a;
                String strH6 = thE instanceof ChangeNickErrorState.InvalidChannelInput ? AbstractC5969Lp4.a(c12002du5.h6(AbstractC12217eE5.create_channel_ID_invalid_input), zn2) : ((thE instanceof ChangeNickErrorState.InvalidChannelNick) || (thE instanceof ChangeNickErrorState.ForbiddenNick)) ? c12002du5.h6(AbstractC12217eE5.invalid_channel_ID_error) : AbstractC5969Lp4.a(c12002du5.h6(AbstractC12217eE5.create_channel_ID_error), zn2);
                MY.B(my, strH6, false, 2, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CharSequence charSequence, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((z) create(charSequence, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C12002du5() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new P(new O(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C8671Wy6.class), new Q(interfaceC9173Yu3B), new R(null, interfaceC9173Yu3B), new S(this, interfaceC9173Yu3B));
        this.binding = AbstractC6056Lz2.f(this, new N(), AbstractC20046rN7.c());
        this.onlyLatinInputFilter = new y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ab(final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1722953198);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.j(aVar, g10.c(interfaceC22053ub1J, i3).b().c(), g10.c(interfaceC22053ub1J, i3).b().u()), 0.0f, 1, null);
            OA2.b.C0545b c0545b = OA2.b.C0545b.c;
            String strC = UY6.c(RD5.open_web_app_button, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(2027918514);
            boolean z2 = (i2 & 14) == 4;
            Object objB = interfaceC22053ub1J.B();
            if (z2 || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.xt5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C12002du5.Bb(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC17932no0.A((SA2) objB, c0545b, strC, eVarH, null, null, interfaceC22053ub1J, OA2.b.C0545b.d << 3, 48);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.yt5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C12002du5.Cb(this.a, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ac(C11458d25 forwardedPeer, List messages, Context parent, boolean shouldShowToast, UA2 successCallback) {
        View viewInflate = LayoutInflater.from(parent).inflate(QC5.advanced_forward_new_bottom, (ViewGroup) null, false);
        AbstractC13042fc3.g(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewInflate;
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        NewAdvancedForward newAdvancedForward = new NewAdvancedForward(parent, forwardedPeer, messages, linearLayout, shouldShowToast, successCallback);
        DialogC7946Tw1 dialogC7946Tw1 = new DialogC7946Tw1(parent, AbstractC15235jE5.TransparentBottomSheetDialog, linearLayout, newAdvancedForward);
        newAdvancedForward.setParentDialog(dialogC7946Tw1);
        dialogC7946Tw1.show();
    }

    private final void Ad() {
        final C6281My2 c6281My2Jc = Jc();
        c6281My2Jc.H.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lt5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12002du5.Bd(this.a, view);
            }
        });
        c6281My2Jc.m0.setTypeface(C6011Lu2.k());
        c6281My2Jc.n0.setTypeface(C6011Lu2.k());
        c6281My2Jc.j.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.mt5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12002du5.Cd(c6281My2Jc, this, view);
            }
        });
        c6281My2Jc.j.setSize(44);
        c6281My2Jc.j.setRingDrawable(AbstractC4043Dl1.f(S7(), AbstractC22412vB5.drawable_ring_new_story_appbar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ae(C12889fL5 c12889fL5, View view) {
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        MY my = (MY) c12889fL5.a;
        if (my != null) {
            my.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Bb(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onclick");
        sa2.invoke();
        return C19938rB7.a;
    }

    private final void Bc(final J44 message) {
        final C24967zW1 c24967zW1H = message.H();
        if (Build.VERSION.SDK_INT > 29 || S7().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            ld(message, new InterfaceC5620Kc6() { // from class: ir.nasim.Pt5
                @Override // ir.nasim.InterfaceC5620Kc6
                public final void onSuccess(Object obj) {
                    C12002du5.Dc(c24967zW1H, this, message, (String) obj);
                }
            });
            return;
        }
        C21753u45 c21753u45 = C21753u45.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        c21753u45.J0(fragmentActivityQ7, 77, new SA2() { // from class: ir.nasim.Ot5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.Cc();
            }
        }, C21753u45.d.j, C21753u45.d.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bd(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.Q7().onBackPressed();
    }

    private final void Be() {
        HashMap map = new HashMap();
        String str = this.event_type;
        if (str != null) {
            map.put("peer_id", Integer.valueOf(pd().v3().getPeerId()));
            String lowerCase = pd().v3().s().toString().toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            map.put("peer_type", lowerCase);
            map.put("tab", str);
            map.put("action_type", 3);
            C3343Am.i("shared_media_file_action", map);
        }
        C9562aA3 c9562aA3 = (C9562aA3) AbstractC15401jX0.s0((List) pd().F3().getValue());
        InterfaceC17445my6 interfaceC17445my6 = (InterfaceC17445my6) AbstractC15401jX0.s0(pd().E3());
        if (c9562aA3 != null) {
            C18987pb3.x1(C18987pb3.a, pd().v3(), Long.valueOf(c9562aA3.f()), Long.valueOf(c9562aA3.c()), true, null, null, false, null, null, false, null, 2032, null);
        } else if (interfaceC17445my6 != null) {
            C18987pb3.x1(C18987pb3.a, pd().v3(), Long.valueOf(interfaceC17445my6.getContent().i()), Long.valueOf(interfaceC17445my6.getContent().u()), true, null, null, false, null, null, false, null, 2032, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Cb(C12002du5 c12002du5, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c12002du5, "$tmp1_rcvr");
        AbstractC13042fc3.i(sa2, "$onclick");
        c12002du5.Ab(sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Cc() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Cd(C6281My2 c6281My2, C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c6281My2, "$this_with");
        AbstractC13042fc3.i(c12002du5, "this$0");
        if (c6281My2.j.getHasStory()) {
            c12002du5.Ge();
        } else {
            c12002du5.fe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ce() {
        boolean z2 = pd().d3() == ExPeerType.GROUP;
        int i = z2 ? RD5.alert_leave_group_title : RD5.leave_channel;
        int i2 = z2 ? RD5.are_you_sure_to_leave_group : RD5.are_you_sure_to_leave_channel;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-312349443, true, new M(i, this, i2)), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Db(final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1334535339);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(this) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            String strC = UY6.c(RD5.features_sharedmedia_timche_profile_btn, interfaceC22053ub1J, 0);
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC16797ls7.j(strC, null, androidx.compose.foundation.layout.q.d(g10.c(interfaceC22053ub1J, i3).b().e(), g10.c(interfaceC22053ub1J, i3).b().u(), g10.c(interfaceC22053ub1J, i3).b().d(), g10.c(interfaceC22053ub1J, i3).b().u()), null, AbstractC19242q11.e(-1506070386, true, new C12004b(sa2, this), interfaceC22053ub1J, 54), null, null, sa2, null, interfaceC22053ub1J, ((i2 << 21) & 29360128) | 24576, 362);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Vt5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C12002du5.Eb(this.a, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dc(C24967zW1 c24967zW1, C12002du5 c12002du5, J44 j44, String str) {
        String strSubstring;
        AbstractC13042fc3.i(c12002du5, "this$0");
        AbstractC13042fc3.i(j44, "$message");
        AbstractC13042fc3.i(str, "path");
        if (c24967zW1 != null && !TextUtils.isEmpty(c24967zW1.y())) {
            strSubstring = c24967zW1.y();
        } else if (TextUtils.isEmpty(str)) {
            strSubstring = null;
        } else {
            strSubstring = str.substring(AbstractC20762sZ6.r0(str, Separators.SLASH, 0, false, 6, null));
            AbstractC13042fc3.h(strSubstring, "substring(...)");
        }
        if (strSubstring == null) {
            long jA = AbstractC19981rG5.a();
            StringBuilder sb = new StringBuilder();
            sb.append(jA);
            strSubstring = sb.toString();
        }
        Context contextS7 = c12002du5.S7();
        int i = AbstractC14815iX3.h(j44) ? 3 : 2;
        C24967zW1 c24967zW1H = j44.H();
        C6906Pm2.A(str, contextS7, i, strSubstring, c24967zW1H != null ? c24967zW1H.x() : null);
    }

    private final void Dd() {
        final C6281My2 c6281My2Jc = Jc();
        Ad();
        ConstraintLayout constraintLayoutB = c6281My2Jc.getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(constraintLayoutB, null, 0, 6, null);
        c17468n10.k(c6281My2Jc.D);
        c17468n10.m(4000);
        this.snackBar = c17468n10;
        if (!pd().Y3()) {
            c6281My2Jc.r.setTypeface(C6011Lu2.i());
            c6281My2Jc.Q.setTypeface(C6011Lu2.i());
            c6281My2Jc.C.setTypeface(C6011Lu2.i());
            c6281My2Jc.m0.setSelected(true);
            ConstraintLayout constraintLayout = c6281My2Jc.U;
            AbstractC13042fc3.h(constraintLayout, "notifContainer");
            constraintLayout.setVisibility(0);
            AppBarLayout appBarLayout = c6281My2Jc.m;
            AbstractC13042fc3.h(appBarLayout, "bodyContainerToolbar");
            appBarLayout.setVisibility(0);
            final C11637dL5 c11637dL5 = new C11637dL5();
            c6281My2Jc.m.d(new AppBarLayout.f() { // from class: ir.nasim.As5
                @Override // com.google.android.material.appbar.AppBarLayout.c
                public final void a(AppBarLayout appBarLayout2, int i) {
                    C12002du5.Ed(c11637dL5, c6281My2Jc, appBarLayout2, i);
                }
            });
            c6281My2Jc.t.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Bs5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C12002du5.Gd(this.a, view);
                }
            });
            c6281My2Jc.f0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Cs5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C12002du5.Hd(this.a, view);
                }
            });
            c6281My2Jc.R.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ds5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C12002du5.Id(this.a, view);
                }
            });
            c6281My2Jc.b0.setTypeface(C6011Lu2.k());
            c6281My2Jc.d.setTypeface(C6011Lu2.k());
            c6281My2Jc.W.setTypeface(C6011Lu2.k());
            c6281My2Jc.q.setTypeface(C6011Lu2.k());
            c6281My2Jc.i.setTypeface(C6011Lu2.k());
            c6281My2Jc.T.setTypeface(C6011Lu2.k());
            c6281My2Jc.a0.setTypeface(C6011Lu2.i());
            c6281My2Jc.c.setTypeface(C6011Lu2.i());
            c6281My2Jc.S.setTypeface(C6011Lu2.i());
            c6281My2Jc.J.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Es5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C12002du5.Jd(this.a, view);
                }
            });
            c6281My2Jc.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Fs5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C12002du5.Kd(this.a, view);
                }
            });
            c6281My2Jc.M.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Gs5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C12002du5.Ld(this.a, view);
                }
            });
        }
        Jc().L.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Hs5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12002du5.Md(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void De() {
        C22042ua0.A9(this, Mc().a(pd().i3().r(), false), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Eb(C12002du5 c12002du5, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c12002du5, "$tmp0_rcvr");
        AbstractC13042fc3.i(sa2, "$onClick");
        c12002du5.Db(sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private final void Ec(SA2 successCallback) {
        List listE3 = pd().E3();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listE3, 10));
        Iterator it = listE3.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC24061xy6.b(((InterfaceC17445my6) it.next()).getContent()));
        }
        Iterable iterable = (Iterable) pd().F3().getValue();
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(iterable, 10));
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((C9562aA3) it2.next()).e());
        }
        List listR0 = AbstractC15401jX0.R0(arrayList, arrayList2);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new C12009g(listR0, listR0.size(), successCallback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ed(C11637dL5 c11637dL5, final C6281My2 c6281My2, AppBarLayout appBarLayout, int i) {
        AbstractC13042fc3.i(c11637dL5, "$lastVerticalOffset");
        AbstractC13042fc3.i(c6281My2, "$this_with");
        if (c11637dL5.a == i) {
            return;
        }
        c11637dL5.a = i;
        if (i <= (-(c6281My2.k.getHeight() / 3))) {
            if (c6281My2.t.getVisibility() == 8 || c6281My2.t.getAlpha() < 1.0f) {
                return;
            }
            c6281My2.t.animate().alpha(0.0f).setDuration(110L).withEndAction(new Runnable() { // from class: ir.nasim.tt5
                @Override // java.lang.Runnable
                public final void run() {
                    C12002du5.Fd(c6281My2);
                }
            }).start();
            return;
        }
        if (c6281My2.t.getVisibility() == 0) {
            return;
        }
        c6281My2.t.setAlpha(0.2f);
        c6281My2.t.setVisibility(0);
        c6281My2.t.animate().alpha(1.0f).setDuration(120L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ee() {
        PH5 ph5Nd = nd();
        long jU = pd().v3().u();
        ZN2 zn2Q = pd().i3().q();
        AbstractC13042fc3.h(zn2Q, "getGroupType(...)");
        C22042ua0.A9(this, ph5Nd.a(jU, zn2Q), false, null, 6, null);
    }

    private final void Fc(List list) {
        List<InterfaceC17445my6> list2 = list;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (((InterfaceC17445my6) obj).d() instanceof TY1.a) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C11507d74 c11507d74B = AbstractC24061xy6.b(((InterfaceC17445my6) it.next()).getContent());
            AbstractC13042fc3.f(c11507d74B);
            Bc(c11507d74B);
        }
        for (InterfaceC17445my6 interfaceC17445my6 : list2) {
            if (interfaceC17445my6.d() instanceof TY1.c) {
                InterfaceC17445my6.a.e(interfaceC17445my6);
            }
        }
        HashMap map = new HashMap();
        String str = this.event_type;
        if (str != null) {
            map.put("peer_id", Integer.valueOf(pd().v3().getPeerId()));
            String lowerCase = pd().v3().s().toString().toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            map.put("peer_type", lowerCase);
            map.put("tab", str);
            map.put("action_type", 4);
            C3343Am.i("shared_media_file_action", map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fd(C6281My2 c6281My2) {
        AbstractC13042fc3.i(c6281My2, "$this_with");
        c6281My2.t.setVisibility(8);
    }

    private final void Fe(AbstractC8081Ul1 builder) {
        ImageView imageView = Jc().I;
        AbstractC13042fc3.h(imageView, "imgMore");
        ConstraintLayout constraintLayoutB = Jc().getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        AbstractC5462Jl1.f(new GY.a(imageView, constraintLayoutB, null, 4, null).d(true).h(new Point(AbstractC8943Xx1.c(-220), 0)).b(builder), 0, 1, null);
    }

    static /* synthetic */ void Gc(C12002du5 c12002du5, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = c12002du5.pd().E3();
        }
        c12002du5.Fc(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gd(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        if (!c12002du5.pd().U3()) {
            C18987pb3.a.w1(c12002du5.pd().v3(), null, false);
            return;
        }
        FragmentActivity fragmentActivityQ7 = c12002du5.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        c12002du5.j9(fragmentActivityQ7);
    }

    private final void Ge() {
        C14486i0.a aVar = C14486i0.f;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C14486i0 c14486i0A = aVar.a(fragmentActivityQ7);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AvatarWithStoryOpeningSelectionBottomSheet avatarWithStoryOpeningSelectionBottomSheet = new AvatarWithStoryOpeningSelectionBottomSheet(contextS7, new SA2() { // from class: ir.nasim.Lt5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.He(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Nt5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.Ie(this.a);
            }
        });
        avatarWithStoryOpeningSelectionBottomSheet.setAbolInstance(c14486i0A);
        c14486i0A.o(avatarWithStoryOpeningSelectionBottomSheet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hd(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.se();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 He(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.fe();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Ic() {
        return JF5.g() ? AbstractC22412vB5.simple_arrow_left : AbstractC22412vB5.simple_arrow_right;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Id(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.se();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ie(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ge();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6281My2 Jc() {
        Object objA = this.binding.a(this, x1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C6281My2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jd(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.yd();
    }

    private final void Je() {
        Uri uriH;
        String str = this.externalFile;
        if (str != null) {
            File file = new File(str);
            uriH = FileProvider.h(S7(), S7().getPackageName() + ".provider", file);
        } else {
            uriH = null;
        }
        startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uriH), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kd(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.te();
    }

    private final void Ke(String number) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + number));
        S7().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ld(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        C8671Wy6 c8671Wy6Pd = c12002du5.pd();
        FragmentActivity fragmentActivityQ7 = c12002du5.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        c8671Wy6Pd.i4(fragmentActivityQ7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:112:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Le(final ir.nasim.AbstractC4886Gz1.b r20) {
        /*
            Method dump skipped, instructions count: 926
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12002du5.Le(ir.nasim.Gz1$b):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Md(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        C11458d25 c11458d25R = C11458d25.r(c12002du5.od().W3());
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        c12002du5.s4(c11458d25R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Me(C12002du5 c12002du5, String str) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        AbstractC13042fc3.i(str, "link");
        c12002du5.Jc().N.setVisibility(0);
        c12002du5.pd().x2(str);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.AbstractC8081Ul1 Nc() {
        /*
            Method dump skipped, instructions count: 1171
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12002du5.Nc():ir.nasim.Ul1");
    }

    private final void Nd(final String number) {
        TextView textView = Jc().b0;
        AbstractC13042fc3.h(textView, "phoneTxt");
        ConstraintLayout constraintLayoutB = Jc().getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        GY.a aVarH = new GY.a(textView, constraintLayoutB, null, 4, null).d(true).h(new Point(AbstractC8943Xx1.c(-140), 0));
        AbstractC8081Ul1.b bVar = new AbstractC8081Ul1.b();
        AbstractC8081Ul1.b.k(bVar, RD5.call_with_bale, AbstractC22412vB5.voice_call_new_icon, null, new SA2() { // from class: ir.nasim.ut5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.Od(this.a);
            }
        }, 4, null);
        AbstractC8081Ul1.b.k(bVar, RD5.call_by_mobile_phone, AbstractC22412vB5.mobile, null, new SA2() { // from class: ir.nasim.vt5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.Pd(this.a, number);
            }
        }, 4, null);
        AbstractC8081Ul1.b.k(bVar, RD5.copy_of_phone_number, AbstractC22412vB5.copy, null, new SA2() { // from class: ir.nasim.wt5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.Qd(this.a, number);
            }
        }, 4, null);
        AbstractC5462Jl1.f(aVarH.b(bVar), 0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ne(C12002du5 c12002du5, AbstractC4886Gz1.b bVar, View view) {
        int i;
        AbstractC13042fc3.i(c12002du5, "this$0");
        AbstractC13042fc3.i(bVar, "$data");
        Context contextS7 = c12002du5.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        if (!KV0.a(contextS7, bVar.c()) || !KV0.b()) {
            return true;
        }
        switch (C12005c.a[c12002du5.pd().d3().ordinal()]) {
            case 1:
                i = RD5.toast_about_me_copied;
                break;
            case 2:
                i = RD5.toast_about_group_copied;
                break;
            case 3:
                i = RD5.toast_about_channel_copied;
                break;
            case 4:
                i = RD5.toast_about_bot_copied;
                break;
            case 5:
                i = RD5.toast_copied;
                break;
            case 6:
                i = RD5.toast_copied;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        C8671Wy6 c8671Wy6Pd = c12002du5.pd();
        String strH6 = c12002du5.h6(i);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c8671Wy6Pd.I2(strH6);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Oc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ye();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Od(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.yd();
        return C19938rB7.a;
    }

    private final InterfaceC4557Fq2 Oe(AppCompatEditText appCompatEditText) {
        return AbstractC6459Nq2.f(new V(appCompatEditText, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Pc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.qc();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Pd(C12002du5 c12002du5, String str) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        AbstractC13042fc3.i(str, "$number");
        c12002du5.Ke(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pe(String info) {
        Jc().P.setContentDescription("");
        Jc().P.setContentDescription(pd().s3() + Separators.SP + info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Qc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ve(true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Qd(C12002du5 c12002du5, String str) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        AbstractC13042fc3.i(str, "$number");
        Context contextS7 = c12002du5.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        if (KV0.a(contextS7, str) && KV0.b()) {
            C8671Wy6 c8671Wy6Pd = c12002du5.pd();
            String strH6 = c12002du5.h6(RD5.toast_phone_copied);
            AbstractC13042fc3.h(strH6, "getString(...)");
            c8671Wy6Pd.I2(strH6);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Rc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ve(false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rd(C12002du5 c12002du5, String str, String str2) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ee(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Sc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ae(ZN2.GROUP);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Sd(C12002du5 c12002du5, String str, Bundle bundle) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "<unused var>");
        c12002du5.Q7().onBackPressed();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Tc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.Zd();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Td(C12002du5 c12002du5, String str, Bundle bundle) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        if (bundle.getBoolean("EXTRA_NICK_CHANGED", false)) {
            c12002du5.vc();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Uc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.he();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ud(C12002du5 c12002du5, String str, Bundle bundle) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        if (bundle.getBoolean("transferred", false)) {
            c12002du5.pd().r2();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Vc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ye();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vd(C12002du5 c12002du5, String str, Bundle bundle) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        AbstractC13042fc3.i(str, "requestKey");
        AbstractC13042fc3.i(bundle, "bundle");
        if (str.hashCode() == 1132715298 && str.equals("add_new_admin_request")) {
            c12002du5.pd().Q3(bundle.getBoolean("extra_new_admin_added"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Wc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ve(true);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wd(C12002du5 c12002du5, String str, Bundle bundle) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        AbstractC13042fc3.i(str, "requestKey");
        AbstractC13042fc3.i(bundle, "bundle");
        if (str.hashCode() == -803190203 && str.equals("remove_new_admin_request")) {
            c12002du5.pd().Q3(bundle.getBoolean("extra_new_admin_removed"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Xc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ve(false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xd(C11458d25 c11458d25, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c11458d25, "$bot");
        C18987pb3.x1(C18987pb3.a, c11458d25, null, null, false, null, null, false, null, null, false, null, 2046, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Yc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ye();
        return C19938rB7.a;
    }

    private final void Yd() {
        String strS2 = pd().S2();
        if (!(!AbstractC20762sZ6.n0(strS2))) {
            strS2 = null;
        }
        if (strS2 == null) {
            return;
        }
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        aVar.A(contextS7, Uri.parse(strS2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Zc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.qc();
        return C19938rB7.a;
    }

    private final void Zd() {
        C24840zI0.Companion aVar = C24840zI0.INSTANCE;
        W06 w06 = (W06) pd().i3().E().b();
        if (w06 == null) {
            w06 = W06.PRIVATE;
        }
        C22042ua0.w9(this, aVar.a(w06, pd().d3() == ExPeerType.CHANNEL ? ZN2.CHANNEL : ZN2.GROUP, pd().v3().getPeerId(), pd().s3(), pd().t3()), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ad(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ve(true);
        return C19938rB7.a;
    }

    private final void ae(ZN2 groupType) {
        AppCompatEditText appCompatEditTextQ;
        final C12889fL5 c12889fL5 = new C12889fL5();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        NY ny = new NY(contextS7);
        ZN2 zn2 = ZN2.GROUP;
        MY myA = ny.A(groupType == zn2 ? RD5.edit_group_nick_name_profile_fragment : RD5.edit_channel_nick_name_profile_fragment).E(4).j(false).l(true).z(pd().t3()).C(groupType == zn2 ? RD5.create_group_ID_title : RD5.create_channel_ID_title).n(groupType == zn2 ? RD5.edit_group_nick_name_profile_fragment : RD5.edit_channel_nick_name_profile_fragment).w(RD5.edit).t(RD5.dialog_cancel).c(false).d(true).m(32).v(new View.OnClickListener() { // from class: ir.nasim.Qt5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12002du5.ce(c12889fL5, this, view);
            }
        }).s(new View.OnClickListener() { // from class: ir.nasim.Rt5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12002du5.de(c12889fL5, view);
            }
        }).a();
        c12889fL5.a = myA;
        if (myA == null || (appCompatEditTextQ = myA.q()) == null) {
            return;
        }
        InputFilter[] filters = appCompatEditTextQ.getFilters();
        AbstractC13042fc3.h(filters, "getFilters(...)");
        appCompatEditTextQ.setFilters((InputFilter[]) AbstractC9648aK.E(filters, this.onlyLatinInputFilter));
        AbstractC6459Nq2.W(AbstractC6459Nq2.b0(AbstractC6459Nq2.s(new A(Oe(appCompatEditTextQ), this), 300L), new z(c12889fL5, groupType, null)), AbstractC16751lo1.a(this));
        AppCompatEditText appCompatEditTextQ2 = ((MY) c12889fL5.a).q();
        if (appCompatEditTextQ2 != null) {
            appCompatEditTextQ2.setInputType(1);
        }
        ((MY) c12889fL5.a).z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 bd(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ve(false);
        return C19938rB7.a;
    }

    static /* synthetic */ void be(C12002du5 c12002du5, ZN2 zn2, int i, Object obj) {
        if ((i & 1) != 0) {
            zn2 = ZN2.CHANNEL;
        }
        c12002du5.ae(zn2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 cd(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.Zd();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ce(C12889fL5 c12889fL5, C12002du5 c12002du5, View view) {
        AppCompatEditText appCompatEditTextQ;
        Editable text;
        AppCompatEditText appCompatEditTextQ2;
        Editable text2;
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        AbstractC13042fc3.i(c12002du5, "this$0");
        MY my = (MY) c12889fL5.a;
        CharSequence charSequenceN1 = null;
        CharSequence charSequenceN12 = (my == null || (appCompatEditTextQ2 = my.q()) == null || (text2 = appCompatEditTextQ2.getText()) == null) ? null : AbstractC20762sZ6.n1(text2);
        if (charSequenceN12 == null || charSequenceN12.length() == 0) {
            MY my2 = (MY) c12889fL5.a;
            if (my2 != null) {
                MY.B(my2, c12002du5.S7().getString(RD5.name_can_not_be_empty), false, 2, null);
                return;
            }
            return;
        }
        C8671Wy6 c8671Wy6Pd = c12002du5.pd();
        MY my3 = (MY) c12889fL5.a;
        if (my3 != null && (appCompatEditTextQ = my3.q()) != null && (text = appCompatEditTextQ.getText()) != null) {
            charSequenceN1 = AbstractC20762sZ6.n1(text);
        }
        c8671Wy6Pd.v2(String.valueOf(charSequenceN1));
        MY my4 = (MY) c12889fL5.a;
        if (my4 != null) {
            my4.o();
        }
    }

    private final void dc(AbstractC8081Ul1.b bVar) {
        AbstractC8081Ul1.b.k(bVar, RD5.profile_contacts_available, AbstractC22412vB5.add_user, null, new SA2() { // from class: ir.nasim.Ht5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.ec(this.a);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 dd(C12002du5 c12002du5, C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        AbstractC13042fc3.i(c14733iO2, "$groupVM");
        C22042ua0.A9(c12002du5, JZ0.INSTANCE.a(c14733iO2.r()), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void de(C12889fL5 c12889fL5, View view) {
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        MY my = (MY) c12889fL5.a;
        if (my != null) {
            my.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ec(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.pd().d2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ed(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        C22042ua0.A9(c12002du5, IM2.INSTANCE.a().b(c12002du5.pd().i3().r(), ZN2.CHANNEL), false, null, 6, null);
        return C19938rB7.a;
    }

    private final void ee(String path) {
        if (path == null || path.length() == 0) {
            return;
        }
        this.avatarPath = path;
        if (pd().v3().s() == W25.a) {
            pd().t2(path);
        } else if (pd().v3().s() == W25.b) {
            pd().p2(pd().v3().getPeerId(), path);
        }
    }

    private final void fc(AbstractC8081Ul1.b bVar) {
        AbstractC8081Ul1.b.k(bVar, RD5.features_sharedmedia_more_menu_add_to_home_screen, AbstractC22412vB5.home, null, new SA2() { // from class: ir.nasim.Ut5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.gc(this.a);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 fd(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.he();
        return C19938rB7.a;
    }

    private final void fe() {
        Intent intentB;
        if (pd().Y3()) {
            return;
        }
        if (pd().v3().C()) {
            int peerId = pd().v3().getPeerId();
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            intentB = XV7.a(peerId, contextS7);
        } else {
            int peerId2 = pd().v3().getPeerId();
            Context contextS72 = S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            intentB = XV7.b(peerId2, contextS72, pd().d3() == ExPeerType.GROUP ? ZN2.GROUP : ZN2.CHANNEL);
        }
        n8(intentB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 gc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.pd().z2();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 gd(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ye();
        return C19938rB7.a;
    }

    private final void ge() {
        C22042ua0.w9(this, MW6.INSTANCE.a(pd().v3().getPeerId(), AbstractC9766aX0.e(Integer.valueOf(pd().v3().getPeerId())), (60 & 4) != 0 ? null : null, (60 & 8) != 0 ? null : null, (60 & 16) != 0 ? null : null, (60 & 32) != 0 ? -1 : 0), false, null, 6, null);
    }

    private final void hc(AbstractC8081Ul1.b bVar) {
        Boolean bool = (Boolean) pd().K3().p().b();
        AbstractC8081Ul1.b.d(bVar, !bool.booleanValue() ? pd().K3().n() == ExPeerType.BOT ? RD5.profile_settings_block_and_delete : RD5.profile_settings_block : RD5.profile_settings_unblock, bool.booleanValue() ? AbstractC22412vB5.unlock : AbstractC22412vB5.block, null, new SA2() { // from class: ir.nasim.At5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.ic(this.a);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 hd(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.qc();
        return C19938rB7.a;
    }

    private final void he() {
        ExPeerType exPeerTypeD3 = pd().d3();
        ExPeerType exPeerType = ExPeerType.GROUP;
        boolean z2 = exPeerTypeD3 == exPeerType;
        int i = z2 ? RD5.leave_delete_group : RD5.leave_delete_channel;
        int i2 = z2 ? RD5.leave_delete_group_description : RD5.leave_delete_channel_description;
        int i3 = pd().d3() == exPeerType ? RD5.alert_delete_group_yes : RD5.delete_channel;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1796470076, true, new B(i3, this, i, i2)), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ic(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        if (((Boolean) c12002du5.pd().K3().p().b()).booleanValue()) {
            C8671Wy6.o2(c12002du5.pd(), false, null, 2, null);
        } else if (c12002du5.pd().K3().n() == ExPeerType.BOT) {
            c12002du5.ue(c12002du5.pd().K3());
            C19938rB7 c19938rB7 = C19938rB7.a;
        } else {
            C8671Wy6.o2(c12002du5.pd(), true, null, 2, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 id(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ve(true);
        return C19938rB7.a;
    }

    private final void ie() {
        if (pd().X3()) {
            ImageView imageView = Jc().J;
            AbstractC13042fc3.h(imageView, "imgVoiceCall");
            imageView.setVisibility((pd().Y3() || pd().d3() == ExPeerType.BOT) ? false : true ? 0 : 8);
            if (pd().Y3()) {
                Jc().m0.setText(h6(RD5.feed_save_message_menu));
                Jc().j.setPlaceHolder(AbstractC4043Dl1.f(S7(), AbstractC22412vB5.ic_saved_message));
                TextView textView = Jc().n0;
                AbstractC13042fc3.h(textView, "txtPresence");
                textView.setVisibility(8);
            } else {
                Jc().j.a(pd().v3().getPeerId(), pd().t3());
                if (pd().d3() == ExPeerType.BOT) {
                    String strR2 = pd().R2();
                    if (strR2 == null || AbstractC20762sZ6.n0(strR2)) {
                        TextView textView2 = Jc().n0;
                        AbstractC13042fc3.h(textView2, "txtPresence");
                        textView2.setVisibility(8);
                    } else {
                        Jc().n0.setText(i6(RD5.bot_monthly_users, XY6.v(strR2)));
                        String strI6 = i6(RD5.bot_monthly_users, XY6.v(strR2));
                        AbstractC13042fc3.h(strI6, "getString(...)");
                        Pe(strI6);
                    }
                } else {
                    TextView textView3 = Jc().n0;
                    AbstractC13042fc3.h(textView3, "txtPresence");
                    textView3.setVisibility(0);
                    AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new C(null), 3, null);
                }
            }
        } else {
            Jc().j.a(pd().v3().getPeerId(), pd().t3());
            TextView textView4 = Jc().n0;
            AbstractC13042fc3.h(textView4, "txtPresence");
            textView4.setVisibility(0);
            int iN3 = pd().n3();
            ImageView imageView2 = Jc().J;
            AbstractC13042fc3.h(imageView2, "imgVoiceCall");
            imageView2.setVisibility(pd().U2() ? 0 : 8);
            DY6 dy6 = DY6.a;
            String str = String.format("%,d", Arrays.copyOf(new Object[]{Integer.valueOf(iN3)}, 1));
            AbstractC13042fc3.h(str, "format(...)");
            String strA = JF5.g() ? GY6.a(str) : GY6.b(str);
            Jc().n0.setText(strA + Separators.SP + h6(RD5.member));
            Pe(strA + Separators.SP + h6(RD5.member));
        }
        AbstractC16751lo1.c(this, j.b.RESUMED, new D(null));
    }

    private final void jc(AbstractC8081Ul1.b bVar) {
        AbstractC8081Ul1.b.k(bVar, RD5.features_sharedmedia_more_menu_privacy_bot, AbstractC22412vB5.document, null, new SA2() { // from class: ir.nasim.zt5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.kc(this.a);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 jd(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.ve(false);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void je() {
        C6281My2 c6281My2Jc = Jc();
        pe();
        ie();
        if (pd().Y3()) {
            return;
        }
        int i = C12005c.a[pd().d3().ordinal()];
        if (i == 2) {
            c6281My2Jc.c.setText(h6(RD5.about_group_profile));
            c6281My2Jc.S.setText(h6(RD5.userName_group_profile));
            c6281My2Jc.n0.setVisibility(0);
            if (C8386Vt0.a.T8()) {
                c6281My2Jc.o.setVisibility(0);
                AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new E(c6281My2Jc, this, null), 3, null);
            }
        } else if (i == 3) {
            ComposeView composeView = c6281My2Jc.e;
            AbstractC13042fc3.h(composeView, "adDiscountPromotionNoticeBar");
            composeView.setVisibility(pd().W2() ? 0 : 8);
            if (pd().W2()) {
                int iN3 = pd().n3();
                C24411ya3 c24411ya3 = (C24411ya3) od().S().get("low_member_range");
                String strX = (c24411ya3 == null || !c24411ya3.B(iN3)) ? od().X() : od().W();
                C24411ya3 c24411ya32 = (C24411ya3) od().S().get("low_member_range");
                c6281My2Jc.e.setContent(AbstractC19242q11.c(-5856697, true, new F(strX, (c24411ya32 == null || !c24411ya32.B(iN3)) ? od().V() : od().U(), this, c6281My2Jc)));
            }
            if (pd().a3()) {
                c6281My2Jc.s.setVisibility(0);
                TextView textView = c6281My2Jc.Q;
                AbstractC13042fc3.h(textView, "newTv");
                textView.setVisibility(!od().l1() && od().m1() < 3 ? 0 : 8);
                if (pd().W3()) {
                    if (od().m1() < 3) {
                        SettingsModule settingsModuleOd = od();
                        settingsModuleOd.z6(settingsModuleOd.m1() + 1);
                    }
                    c6281My2Jc.A.setVisibility(0);
                    c6281My2Jc.B.setVisibility(8);
                    c6281My2Jc.A.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ys5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            C12002du5.le(this.a, view);
                        }
                    });
                } else if (pd().S3()) {
                    Context contextS7 = S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
                    AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
                    final Dialog dialogC = AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1047372401, true, new I()), 4, null);
                    if (od().k1()) {
                        if (od().m1() < 3) {
                            SettingsModule settingsModuleOd2 = od();
                            settingsModuleOd2.z6(settingsModuleOd2.m1() + 1);
                        }
                        c6281My2Jc.A.setVisibility(0);
                        c6281My2Jc.B.setVisibility(8);
                        c6281My2Jc.A.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Js5
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                C12002du5.me(this.a, dialogC, view);
                            }
                        });
                    } else {
                        c6281My2Jc.A.setVisibility(8);
                        c6281My2Jc.B.setVisibility(0);
                        c6281My2Jc.B.setContent(AbstractC19242q11.c(1525085213, true, new G(dialogC)));
                    }
                }
            }
            c6281My2Jc.c.setText(h6(RD5.about_channel_profile));
            c6281My2Jc.S.setText(h6(RD5.userName_channel_profile));
            c6281My2Jc.n0.setVisibility(0);
        } else if (i != 4) {
            c6281My2Jc.c.setText(h6(RD5.about_contact_profile));
            c6281My2Jc.S.setText(h6(RD5.user_name));
            c6281My2Jc.n0.setVisibility(0);
        } else {
            c6281My2Jc.c.setText(h6(RD5.about_bot_profile));
        }
        c6281My2Jc.R.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.Us5
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return C12002du5.ne(this.a, view);
            }
        });
        if (!Nc().b()) {
            ImageView imageView = c6281My2Jc.I;
            AbstractC13042fc3.h(imageView, "imgMore");
            imageView.setVisibility(0);
            c6281My2Jc.I.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ft5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C12002du5.oe(this.a, view);
                }
            });
        }
        FloatingActionButton floatingActionButton = c6281My2Jc.t;
        AbstractC13042fc3.h(floatingActionButton, "chatFab");
        floatingActionButton.setVisibility(0);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new H(c6281My2Jc, this, null), 3, null);
        c6281My2Jc.Z.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.qt5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12002du5.ke(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 kc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.Yd();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 kd(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        C22042ua0.A9(c12002du5, IM2.INSTANCE.a().b(c12002du5.pd().i3().r(), ZN2.CHANNEL), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ke(C12002du5 c12002du5, View view) {
        String strK;
        AbstractC13042fc3.i(c12002du5, "this$0");
        PA7 pa7 = (PA7) c12002du5.pd().J3().getValue();
        if (!(pa7 instanceof PA7.c) || (strK = ((PA7.c) pa7).a().k()) == null) {
            return;
        }
        c12002du5.Nd(strK);
    }

    private final void lc(AbstractC8081Ul1.b bVar) {
        AbstractC8081Ul1.b.d(bVar, RD5.delete_contact, AbstractC22412vB5.delete_card_icon, null, new SA2() { // from class: ir.nasim.Ct5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.mc(this.a);
            }
        }, 4, null);
    }

    private final void ld(final J44 message, InterfaceC5620Kc6 schedulerOnSuccess) {
        C9248Zc6 c9248Zc6G = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.Zt5
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return C12002du5.md(message);
            }
        }).h(EnumC11723dV1.IO).f(true).g(schedulerOnSuccess);
        AbstractC13042fc3.h(c9248Zc6G, "onSuccess(...)");
        SZ.e(c9248Zc6G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void le(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        C14486i0.a aVar = C14486i0.f;
        FragmentActivity fragmentActivityQ7 = c12002du5.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C14486i0 c14486i0A = aVar.a(fragmentActivityQ7);
        c12002du5.od().y6(true);
        Context contextS7 = c12002du5.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        FragmentActivity fragmentActivityQ72 = c12002du5.Q7();
        AbstractC13042fc3.g(fragmentActivityQ72, "null cannot be cast to non-null type ir.nasim.designsystem.base.activity.BaseActivity");
        c14486i0A.o(new BottomSheetWebView(contextS7, (BaseActivity) fragmentActivityQ72, "https://tooshle.bale.ai/channel_report?channel_id=" + c12002du5.pd().v3().u(), c14486i0A, null, null, 32, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 mc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.pd().p4();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String md(J44 j44) {
        return C4044Dl2.r(j44);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void me(C12002du5 c12002du5, Dialog dialog, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        AbstractC13042fc3.i(dialog, "$channelEarnMoneyGuideDialog");
        c12002du5.od().y6(true);
        dialog.show();
    }

    private final void nc(AbstractC8081Ul1.b bVar) {
        AbstractC8081Ul1.b.k(bVar, RD5.edit_contact_name, AbstractC22412vB5.edit, null, new SA2() { // from class: ir.nasim.Wt5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.oc(this.a);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ne(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        C8671Wy6 c8671Wy6Pd = c12002du5.pd();
        Context contextS7 = c12002du5.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        return c8671Wy6Pd.l4(contextS7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 oc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        int peerId = c12002du5.pd().v3().getPeerId();
        FragmentActivity fragmentActivityQ7 = c12002du5.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        c12002du5.n8(C22055ub3.c(peerId, fragmentActivityQ7));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oe(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.Fe(c12002du5.Nc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pc() {
        Jc().l0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C8671Wy6 pd() {
        return (C8671Wy6) this.viewModel.getValue();
    }

    private final void pe() {
        C21379tZ3 c21379tZ3 = new C21379tZ3(this, pd().v3(), pd().d3(), ((Boolean) pd().b3().getValue()).booleanValue(), pd().U3(), null, 32, null);
        Jc().Y.setAdapter(c21379tZ3);
        Jc().Y.setOffscreenPageLimit(3);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new J(c21379tZ3, null), 3, null);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new K(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qc() {
        AbstractC8081Ul1.b bVar = new AbstractC8081Ul1.b();
        AbstractC8081Ul1.b.k(bVar, RD5.pick_photo_gallery, AbstractC22412vB5.image, null, new SA2() { // from class: ir.nasim.Dt5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.rc(this.a);
            }
        }, 4, null);
        AbstractC8081Ul1.b.k(bVar, RD5.pick_photo_camera, AbstractC22412vB5.camera, null, new SA2() { // from class: ir.nasim.Et5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.tc(this.a);
            }
        }, 4, null);
        ImageView imageView = Jc().I;
        AbstractC13042fc3.h(imageView, "imgMore");
        ConstraintLayout constraintLayoutB = Jc().getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        AbstractC5462Jl1.f(new GY.a(imageView, constraintLayoutB, null, 4, null).d(true).h(new Point(AbstractC8943Xx1.c(-220), 0)).b(bVar), 0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qe(boolean isEnabled, View view, String label) {
        int i = isEnabled ? RD5.switch_on : RD5.switch_off;
        Context contextG5 = G5();
        view.setContentDescription(label + (contextG5 != null ? contextG5.getString(i) : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 rc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        if (AbstractC4043Dl1.a(AbstractC5969Lp4.d().j2(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            C21753u45.a.M0(c12002du5, 10001, new SA2() { // from class: ir.nasim.au5
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C12002du5.sc();
                }
            }, C21753u45.d.j, C21753u45.d.m);
        } else if (C8386Vt0.a.z8()) {
            InterfaceC15814kD2.b(c12002du5.Lc(), c12002du5.pd().v3().getPeerId(), c12002du5.pd().d3(), "SharedMediaViewModel", new TC2.a(false, false, false, null, 15, null), false, 16, null).L8(c12002du5.F5(), null);
        } else {
            Context contextS7 = c12002du5.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            c12002du5.startActivityForResult(C22055ub3.j(contextS7, true, false, false, false), 1);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rd() {
        C24119y45 c24119y45W3 = pd().w3();
        Jc().h0.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.nt5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12002du5.sd(this.a, view);
            }
        });
        Jc().v.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ot5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12002du5.td(this.a, view);
            }
        });
        Jc().F.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.pt5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12002du5.ud(this.a, view);
            }
        });
        Jc().z.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.rt5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12002du5.wd(this.a, view);
            }
        });
        if (pd().X3() || (c24119y45W3 != null && c24119y45W3.g())) {
            Jc().w.setVisibility(0);
            Jc().x.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.st5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C12002du5.xd(this.a, view);
                }
            });
        } else {
            Jc().w.setVisibility(8);
        }
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new C12021s(null), 3, null);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new C12022t(c24119y45W3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void re(TabLayout tabLayout, int tabCount) {
        tabLayout.setTabMode((tabCount > 5 || AbstractC8943Xx1.c(105) * tabCount > Resources.getSystem().getDisplayMetrics().widthPixels) ? 0 : 1);
        tabLayout.setTabGravity(tabLayout.getTabMode() != 1 ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 sc() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sd(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.Be();
        c12002du5.pd().x4(false);
    }

    private final void se() {
        String strS3 = pd().s3();
        String strM2 = pd().M2();
        String str = "https://" + pd().Q2() + Separators.SLASH + pd().t3();
        StringBuilder sb = new StringBuilder();
        if ((!AbstractC20762sZ6.n0(strS3)) && pd().d3() != ExPeerType.PRIVATE) {
            sb.append("«" + strS3 + "»");
            sb.append("\n\n");
        }
        if (strM2 != null && !AbstractC20762sZ6.n0(strM2) && pd().d3() != ExPeerType.PRIVATE) {
            sb.append(strM2);
            sb.append("\n\n");
        }
        if (pd().d3() != ExPeerType.PRIVATE) {
            sb.append(h6(RD5.features_sharedmedia_share_nick_name_nick_name_title));
            sb.append(Separators.RETURN);
        }
        sb.append(str);
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", string);
        n8(Intent.createChooser(intent, h6(RD5.menu_share)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 tc(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        String strL = C4053Dm2.l("capture", "jpg");
        c12002du5.externalFile = strL;
        if (strL == null) {
            c12002du5.pd().I2(c12002du5.Y8(RD5.toast_no_sdcard));
            return C19938rB7.a;
        }
        if (AbstractC4043Dl1.a(c12002du5.S7(), "android.permission.CAMERA") != 0) {
            C21753u45.a.e0(c12002du5, 3, C21753u45.d.f, new SA2() { // from class: ir.nasim.Yt5
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C12002du5.uc();
                }
            });
        } else {
            c12002du5.Je();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void td(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.pd().x4(false);
    }

    private final void te() {
        C22042ua0.A9(this, Hc().a(pd().v3().getPeerId()), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 uc() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ud(final C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.Ec(new SA2() { // from class: ir.nasim.It5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C12002du5.vd(this.a);
            }
        });
    }

    private final void ue(C21231tK7 userVM) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1204482902, true, new L(userVM)), 4, null).show();
    }

    private final void vc() {
        CharSequence charSequence;
        C14733iO2 c14733iO2I3 = pd().i3();
        if (C8386Vt0.a.D9() || !((charSequence = (CharSequence) c14733iO2I3.w().b()) == null || charSequence.length() == 0)) {
            ConstraintLayout constraintLayout = Jc().R;
            AbstractC13042fc3.h(constraintLayout, "nickContainer");
            Object objB = c14733iO2I3.E().b();
            W06 w06 = W06.PUBLIC;
            constraintLayout.setVisibility(objB == w06 ? 0 : 8);
            C10410bZ6 c10410bZ6H = c14733iO2I3.h();
            String str = c10410bZ6H != null ? (String) c10410bZ6H.b() : null;
            if ((str == null || str.length() == 0) && pd().i3().E().b() != w06) {
                Jc().U.setPadding(0, AbstractC8943Xx1.c(20), 0, 0);
            } else {
                Jc().U.setPadding(0, 0, 0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 vd(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.pd().x4(false);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void ve(boolean r11) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12002du5.ve(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wc(boolean isSelectedMode) {
        if (isSelectedMode) {
            Jc().j0.setVisibility(8);
            Jc().e0.setVisibility(0);
        } else {
            Jc().j0.setVisibility(0);
            Jc().e0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wd(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        Gc(c12002du5, null, 1, null);
        c12002du5.pd().x4(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void we(C12002du5 c12002du5, C12889fL5 c12889fL5, View view) {
        AppCompatEditText appCompatEditTextQ;
        Editable text;
        AbstractC13042fc3.i(c12002du5, "this$0");
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        C8671Wy6 c8671Wy6Pd = c12002du5.pd();
        MY my = (MY) c12889fL5.a;
        c8671Wy6Pd.s2(String.valueOf((my == null || (appCompatEditTextQ = my.q()) == null || (text = appCompatEditTextQ.getText()) == null) ? null : AbstractC20762sZ6.n1(text)));
        MY my2 = (MY) c12889fL5.a;
        if (my2 != null) {
            my2.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xb(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1780682558);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            C24254yJ.e eVarG = C24254yJ.a.g();
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            interfaceC22053ub1J.W(-464297150);
            boolean zD = interfaceC22053ub1J.D(this);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Ft5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C12002du5.yb(this.a);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarH, false, null, null, (SA2) objB, 7, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(eVarF, g10.c(interfaceC22053ub1J, i3).b().c(), g10.c(interfaceC22053ub1J, i3).b().e());
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarG, cVarI, interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            AbstractC24077y03.b(FV4.c(AbstractC22412vB5.three_user, interfaceC22053ub1J, 0), UY6.c(RD5.add_bot_to_group_desc, interfaceC22053ub1J, 0), androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i3).b().j()), g10.a(interfaceC22053ub1J, i3).B(), interfaceC22053ub1J, 0, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i3).b().c()), interfaceC22053ub1J, 0);
            AbstractC9339Zm7.b(UY6.c(RD5.add_bot_to_group_desc, interfaceC22053ub1J, 0), null, g10.a(interfaceC22053ub1J, i3).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i3).a(), interfaceC22053ub1J, 0, 0, 65530);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Gt5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C12002du5.zb(this.a, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private final InterfaceC13730gj3 xc() {
        return AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new C12006d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xd(C12002du5 c12002du5, View view) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        c12002du5.zc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xe(C12889fL5 c12889fL5, View view) {
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        MY my = (MY) c12889fL5.a;
        if (my != null) {
            my.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 yb(C12002du5 c12002du5) {
        AbstractC13042fc3.i(c12002du5, "this$0");
        C22042ua0.A9(c12002du5, F7.INSTANCE.a(c12002du5.pd().v3().getPeerId(), c12002du5.pd().s3()), false, null, 6, null);
        return C19938rB7.a;
    }

    private final InterfaceC13730gj3 yc() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new C12007e(null), 3, null);
    }

    private final void yd() {
        C22042ua0.A9(this, C24270yK6.m1.b(StartOutGoingCallPeerData.INSTANCE.a(pd().v3())), false, null, 6, null);
    }

    private final void ye() {
        int i = pd().v3().s() == W25.b ? 128 : 64;
        final C12889fL5 c12889fL5 = new C12889fL5();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        MY myA = new NY(contextS7).B(h6(RD5.edit_name)).E(4).j(false).l(true).C(RD5.name).n(RD5.hint_enter_name).z(pd().s3()).x(h6(RD5.edit)).u(h6(RD5.dialog_cancel)).c(false).d(true).m(i).v(new View.OnClickListener() { // from class: ir.nasim.St5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12002du5.ze(c12889fL5, this, view);
            }
        }).s(new View.OnClickListener() { // from class: ir.nasim.Tt5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12002du5.Ae(c12889fL5, view);
            }
        }).a();
        myA.z();
        AppCompatEditText appCompatEditTextQ = myA.q();
        if (appCompatEditTextQ != null) {
            appCompatEditTextQ.setInputType(1);
        }
        c12889fL5.a = myA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 zb(C12002du5 c12002du5, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c12002du5, "$tmp1_rcvr");
        c12002du5.xb(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private final void zc() {
        List listE3 = pd().E3();
        List list = listE3;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(AbstractC24061xy6.b(((InterfaceC17445my6) it.next()).getContent()));
        }
        Iterable iterable = (Iterable) pd().F3().getValue();
        ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(iterable, 10));
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((C9562aA3) it2.next()).e());
        }
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new C12008f(AbstractC15401jX0.R0(arrayList, arrayList2), this, pd().d3(), listE3, null), 3, null);
    }

    private final void zd() {
        AbstractC19329q98.a(Q7().getWindow(), Jc().l).a(O98.m.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ze(C12889fL5 c12889fL5, C12002du5 c12002du5, View view) {
        AppCompatEditText appCompatEditTextQ;
        Editable text;
        AppCompatEditText appCompatEditTextQ2;
        Editable text2;
        AbstractC13042fc3.i(c12889fL5, "$dialog");
        AbstractC13042fc3.i(c12002du5, "this$0");
        MY my = (MY) c12889fL5.a;
        CharSequence charSequenceN1 = null;
        CharSequence charSequenceN12 = (my == null || (appCompatEditTextQ2 = my.q()) == null || (text2 = appCompatEditTextQ2.getText()) == null) ? null : AbstractC20762sZ6.n1(text2);
        if (charSequenceN12 == null || charSequenceN12.length() == 0) {
            MY my2 = (MY) c12889fL5.a;
            if (my2 != null) {
                MY.B(my2, c12002du5.S7().getString(RD5.name_can_not_be_empty), false, 2, null);
                return;
            }
            return;
        }
        C8671Wy6 c8671Wy6Pd = c12002du5.pd();
        MY my3 = (MY) c12889fL5.a;
        if (my3 != null && (appCompatEditTextQ = my3.q()) != null && (text = appCompatEditTextQ.getText()) != null) {
            charSequenceN1 = AbstractC20762sZ6.n1(text);
        }
        c8671Wy6Pd.u2(String.valueOf(charSequenceN1));
        MY my4 = (MY) c12889fL5.a;
        if (my4 != null) {
            my4.o();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == -1) {
            if (data == null) {
                return;
            }
            ArrayList arrayList = (ArrayList) data.getSerializableExtra("PHOTOS");
            String str = (arrayList == null || arrayList.size() == 0) ? null : (String) arrayList.get(0);
            this.avatarPath = str;
            if (str == null) {
                return;
            }
            if (pd().v3().s() == W25.a && pd().Y3()) {
                pd().t2(this.avatarPath);
            } else if (pd().v3().s() == W25.b) {
                pd().p2(pd().v3().getPeerId(), this.avatarPath);
            }
        } else if (requestCode == 2 && resultCode == -1) {
            this.avatarPath = C4053Dm2.n("avatar", "jpg");
            String str2 = this.externalFile;
            if (str2 != null && str2 != null && str2.length() != 0 && new File(this.externalFile).exists()) {
                AbstractC17543n85.a(null, A5(), this.externalFile, 1, false, new AbstractC17543n85.b() { // from class: ir.nasim.Bt5
                    @Override // ir.nasim.AbstractC17543n85.b
                    public final void a(String str3, String str4) {
                        C12002du5.Rd(this.a, str3, str4);
                    }
                });
            }
        }
        super.H6(requestCode, resultCode, data);
    }

    public final InterfaceC6301Na Hc() {
        InterfaceC6301Na interfaceC6301Na = this.adminListFragmentNavigator;
        if (interfaceC6301Na != null) {
            return interfaceC6301Na;
        }
        AbstractC13042fc3.y("adminListFragmentNavigator");
        return null;
    }

    public final InterfaceC11677dQ0 Kc() {
        InterfaceC11677dQ0 interfaceC11677dQ0 = this.chatNavigator;
        if (interfaceC11677dQ0 != null) {
            return interfaceC11677dQ0;
        }
        AbstractC13042fc3.y("chatNavigator");
        return null;
    }

    public final InterfaceC15814kD2 Lc() {
        InterfaceC15814kD2 interfaceC15814kD2 = this.galleryNavigator;
        if (interfaceC15814kD2 != null) {
            return interfaceC15814kD2;
        }
        AbstractC13042fc3.y("galleryNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        AbstractC18623oy2.d(this, "success_leave", new InterfaceC14603iB2() { // from class: ir.nasim.Mt5
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C12002du5.Sd(this.a, (String) obj, (Bundle) obj2);
            }
        });
        AbstractC18623oy2.d(this, "CHANNEL_NICK_CHANGED", new InterfaceC14603iB2() { // from class: ir.nasim.Xt5
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C12002du5.Td(this.a, (String) obj, (Bundle) obj2);
            }
        });
        AbstractC18623oy2.d(this, "profile_transferred_owner_ship", new InterfaceC14603iB2() { // from class: ir.nasim.bu5
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C12002du5.Ud(this.a, (String) obj, (Bundle) obj2);
            }
        });
        pd().C4();
    }

    public final B34 Mc() {
        B34 b34 = this.membersAccessFragmentNavigator;
        if (b34 != null) {
            return b34;
        }
        AbstractC13042fc3.y("membersAccessFragmentNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.inflate(QC5.fragment_new_profile, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        Jc().j.o();
        Jc().l0.E();
        Jc().Y.setAdapter(null);
        Jc().I.setOnClickListener(null);
        super.R6();
    }

    @Override // ir.nasim.C22042ua0
    public boolean a() {
        if (!((Boolean) pd().Z3().getValue()).booleanValue()) {
            return false;
        }
        pd().x4(false);
        return true;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        V5().H1("add_new_admin_request", p6(), new InterfaceC13295fz2() { // from class: ir.nasim.cu5
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle) {
                C12002du5.Vd(this.a, str, bundle);
            }
        });
        V5().H1("remove_new_admin_request", p6(), new InterfaceC13295fz2() { // from class: ir.nasim.zs5
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle) {
                C12002du5.Wd(this.a, str, bundle);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        zd();
        Dd();
        yc();
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new C12023u(null), 3, null);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new C12024v(null), 3, null);
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new w(null), 3, null);
        C8386Vt0 c8386Vt0 = C8386Vt0.a;
        if (c8386Vt0.X9()) {
            AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new x(null), 3, null);
        }
        if (c8386Vt0.z8()) {
            xc();
        }
        if (od().V3() && pd().v3().getPeerId() == 270066638) {
            Jc().L.setVisibility(0);
        }
    }

    public final PH5 nd() {
        PH5 ph5 = this.reactionsSettingsFragmentNavigator;
        if (ph5 != null) {
            return ph5;
        }
        AbstractC13042fc3.y("reactionsSettingsFragmentNavigator");
        return null;
    }

    public final SettingsModule od() {
        SettingsModule settingsModule = this.settingsModule;
        if (settingsModule != null) {
            return settingsModule;
        }
        AbstractC13042fc3.y("settingsModule");
        return null;
    }

    public final InterfaceC16935m68 qd() {
        InterfaceC16935m68 interfaceC16935m68 = this.webappNavigator;
        if (interfaceC16935m68 != null) {
            return interfaceC16935m68;
        }
        AbstractC13042fc3.y("webappNavigator");
        return null;
    }

    public final void s4(final C11458d25 bot) {
        AbstractC13042fc3.i(bot, "bot");
        try {
            if (AbstractC5969Lp4.g() == null || AbstractC5969Lp4.g().n(bot.getPeerId()) == null) {
                AbstractC5969Lp4.d().Y().V().t0(Arrays.asList(new C18766pD(bot.getPeerId(), 0L)), new ArrayList(), true).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Ls5
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj) {
                        C12002du5.Xd(bot, (C14505i18) obj);
                    }
                });
            } else {
                C18987pb3.x1(C18987pb3.a, bot, null, null, false, null, null, false, null, null, false, null, 2046, null);
            }
        } catch (Exception e) {
            C19406qI3.d("MyBankHandlers", e);
        }
    }

    /* renamed from: ir.nasim.du5$V */
    static final class V extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ AppCompatEditText d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        V(AppCompatEditText appCompatEditText, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = appCompatEditText;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(AppCompatEditText appCompatEditText, TextWatcher textWatcher, InterfaceC16204ks5 interfaceC16204ks5) {
            appCompatEditText.removeTextChangedListener(textWatcher);
            AbstractC20906so1.d(interfaceC16204ks5, null, 1, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            V v = new V(this.d, interfaceC20295rm1);
            v.c = obj;
            return v;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                final InterfaceC16204ks5 interfaceC16204ks5 = (InterfaceC16204ks5) this.c;
                AppCompatEditText appCompatEditText = this.d;
                final a aVar = new a(interfaceC16204ks5);
                appCompatEditText.addTextChangedListener(aVar);
                final AppCompatEditText appCompatEditText2 = this.d;
                SA2 sa2 = new SA2() { // from class: ir.nasim.Cu5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C12002du5.V.y(appCompatEditText2, aVar, interfaceC16204ks5);
                    }
                };
                this.b = 1;
                if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
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
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((V) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* renamed from: ir.nasim.du5$V$a */
        public static final class a implements TextWatcher {
            final /* synthetic */ InterfaceC16204ks5 a;

            public a(InterfaceC16204ks5 interfaceC16204ks5) {
                this.a = interfaceC16204ks5;
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                GJ0.i(this.a.h(charSequence));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        }
    }
}
