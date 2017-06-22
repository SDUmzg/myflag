package com.example.sdu.myflag.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sdu.myflag.R;
import com.example.sdu.myflag.base.BaseApplication;
import com.example.sdu.myflag.bean.ClockBean;
import com.example.sdu.myflag.bean.SuperViseBriefBean;
import com.example.sdu.myflag.util.BaseTools;
import com.example.sdu.myflag.util.NetUtil;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BinaryHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * 打卡适配器
 */
public class ClockListAdapter extends BaseAdapter {

    private ArrayList<ClockBean> clockList;
    private Context context;
    Bitmap b;

    public ClockListAdapter(Context context, ArrayList<ClockBean> clockList) {
        this.context = context;
        this.clockList = clockList;
    }

    @Override
    public int getCount() {
        return clockList.size();
    }

    @Override
    public Object getItem(int position) {
        return clockList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_clock_list, null);
        TextView nicknameTv = (TextView) convertView.findViewById(R.id.clock_nickname);
        TextView contentTv = (TextView) convertView.findViewById(R.id.clock_content);
        TextView timeTv = (TextView) convertView.findViewById(R.id.clock_time);
        ImageView icon = (ImageView) convertView.findViewById(R.id.clock_icon);
        final ImageView picture = (ImageView) convertView.findViewById(R.id.clock_picture);

        icon.setImageDrawable(context.getResources().getDrawable(BaseApplication.HeadIcon[clockList.get(position).iconId]));
        picture.setImageBitmap(getImage(clockList.get(position).photo));
/*        AsyncHttpClient client = new AsyncHttpClient();
        client.get(NetUtil.getImageUrl + clockList.get(position).photo, new BinaryHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] binaryData) {
                b = BitmapFactory.decodeByteArray(binaryData, 0, binaryData.length);
                picture.setImageBitmap(b);
                ClockListAdapter.this.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  byte[] binaryData, Throwable error) {
            }
        });*/
        nicknameTv.setText(clockList.get(position).nickname);
        contentTv.setText(clockList.get(position).content);
        timeTv.setText(clockList.get(position).time);
        return convertView;
    }

    private Bitmap getImage(String photo) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(NetUtil.getImageUrl + photo, new BinaryHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] binaryData) {
                b = BitmapFactory.decodeByteArray(binaryData, 0, binaryData.length);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  byte[] binaryData, Throwable error) {
            }
        });
        return b;
    }
}
