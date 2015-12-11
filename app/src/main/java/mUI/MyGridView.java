package mUI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import com.example.administrator.musicgame.R;

import java.util.ArrayList;

import Model.WorldButton;
import Util.Util;

/**
 * 待选文字的自定义View
 * Created by Zhaodj on 2015/12/11.
 */
public class MyGridView extends GridView {
    //待选文字的数据
    private ArrayList<WorldButton> mArrayList=new ArrayList<WorldButton>();
    //自定义的adapter
    private MyGridAdapter myAdapter;
    private Context mContext;

    public MyGridView(Context context) {
        this(context,null);
    }

    public MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
    }

    /**
     * 更新、显示数据
     * @param list
     */
    public void updateData(ArrayList<WorldButton> list){
        mArrayList=list;
        myAdapter=new MyGridAdapter();
        setAdapter(myAdapter);

    }


    /**
     * 为当前GridView设置的adapter
     */
    class MyGridAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return mArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return mArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            WorldButton holder;
            if(convertView==null){
                convertView=Util.getView(mContext, R.layout.gridview_item);
                holder=mArrayList.get(position);
                holder.setmIndex(position);
                holder.setmViewButton((Button) convertView.findViewById(R.id.item_btn));
                convertView.setTag(holder);
            }else {
                holder= (WorldButton) convertView.getTag();
            }
            holder.getmViewButton().setText(holder.getmString());

            return convertView;
        }
    }
}
