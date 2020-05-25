package kr.co.tjoeun.baseballgame_20200525.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Objects;

import kr.co.tjoeun.baseballgame_20200525.R;
import kr.co.tjoeun.baseballgame_20200525.datas.Message;

public class MessageAdapter extends ArrayAdapter<Message> {

    Context mContext;
    List<Message> mList;
    LayoutInflater inf;

    public MessageAdapter(@NonNull Context context, int resource, @NonNull List<Message> objects) {
        super(context, resource, objects);

        mContext=context;
        mList = objects;
        inf=LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null){
            row = inf.inflate(R.layout.message_list_item,null);
        }

//        화면의 컴포넌트들을 가져오는 코드들
        FrameLayout myMessageLayout = row.findViewById(R.id.myMessageLayout);
        FrameLayout cpuMessageLayout = row.findViewById(R.id.cpuMessageLayout);
        TextView myMessage = row.findViewById(R.id.myMessage);
        TextView cpuMessage = row.findViewById(R.id.cpuMessage);

//        이번에 보여줘야할 채팅 메세지
        Message data = mList.get(position);

        if (data.getWho().equals("Me")){

            myMessageLayout.setVisibility(View.VISIBLE);
            cpuMessageLayout.setVisibility(View.GONE);

            myMessage.setText(data.getContent());
        }
        else{

            myMessageLayout.setVisibility(View.GONE);
            cpuMessageLayout.setVisibility(View.VISIBLE);

            cpuMessage.setText(data.getContent());
        }
        return  row;
    }
}
