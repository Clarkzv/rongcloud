package cn.rongcloud.im.ui.widget.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import org.w3c.dom.Text;

import cn.rongcloud.im.R;
import io.rong.imkit.RongExtension;
import io.rong.imkit.RongIM;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.TextMessage;

public class ApkPlugin implements IPluginModule {

    private Context context;
    private Conversation.ConversationType conversationType;
    private String targetId;

    @Override
    public Drawable obtainDrawable(Context context) {

        return context.getResources().getDrawable(R.drawable.u261d);
    }

    @Override
    public String obtainTitle(Context context) {
        return "见一见";
    }

    @Override
    public void onClick(final Fragment fragment, RongExtension rongExtension) {
        Toast.makeText(rongExtension.getContext(),"发送一条自定义消息",Toast.LENGTH_LONG).show();
        final ApkMessage apkMessage =new ApkMessage();
        apkMessage.setUserName("我的手机号：131111111111");
        apkMessage.setPhoneNum("我约见的地址：海淀区");
        Message message = Message.obtain(rongExtension.getTargetId(), rongExtension.getConversationType(),apkMessage);
        RongIM.getInstance().sendMessage(message, null, null, new IRongCallback.ISendMessageCallback() {

            @Override
            public void onAttached(Message message) {

            }

            @Override
            public void onSuccess(Message message) {
//                if(message.getContent() instanceof ApkMessage){
//
//                    ApkMessage msg = (ApkMessage)message.getContent();
//
//                    msg.setExtra("1");
//
//                }
                Log.i("TAG",message.getMessageId()+"!!!");
            }

            @Override
            public void onError(Message message, RongIMClient.ErrorCode errorCode) {
                Log.i("TAG!!!",message.getContent()+"!"+errorCode.getMessage());
            }
        });
    }

    @Override
    public void onActivityResult(int i, int i1, Intent intent) {

        Log.i("TAG","1asdf");

    }
}
