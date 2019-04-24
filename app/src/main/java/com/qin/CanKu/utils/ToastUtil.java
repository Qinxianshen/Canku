package com.qin.CanKu.utils;

import android.content.Context;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.SuperToast;
import com.socks.library.KLog;

public class ToastUtil {

    //使用了superToast这个库 教程：https://github.com/JohnPersano/SuperToasts
    private Context mContext;
    private SuperToast mSuperToast;
    int i = 1;
    String msg = "";
    public ToastUtil(Context context) {
        this(context, null);
    }
    public ToastUtil(Context context, Type type) {
        mContext = context;
        if (type == null) assignFlyBlue();
        if (type == Type.FlyBlue) assignFlyBlue();
    }

    private ToastUtil assignFlyBlue() {
        if (mSuperToast == null) {
            mSuperToast = SuperActivityToast.create(mContext, new Style(), Style.TYPE_STANDARD)
                    .setText("New BitkyToast");
            mSuperToast.setDuration(Style.DURATION_VERY_SHORT)
                    .setFrame(Style.FRAME_STANDARD)
                    .setAnimations(Style.ANIMATIONS_FLY)
                    .setColor(0xcc1e90ff);
        }
        return this;
    }

    public void show(String msg) {
        if (mSuperToast == null) {
            KLog.w("对象未实例化");
        } else {
            if (!this.msg.equals(msg)) {
                this.msg = msg;
                mSuperToast.setText(msg).show();
            } else if (!mSuperToast.isShowing()) {
                mSuperToast.setText(msg).show();
            }
        }
    }
    enum Type {
        FlyBlue
    }
}
