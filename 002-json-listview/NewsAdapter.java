package com.example.demo_json;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter{
	private List<NewsBean> mList;
	private LayoutInflater mInflater;
	public NewsAdapter(Context context,List<NewsBean> list){
		mList = list;
		mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if(convertView == null){
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_layout, null);
			viewHolder.iv_Icon = (ImageView) convertView.findViewById(R.id.iv_icon);
			viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
			
			convertView.setTag(viewHolder);
			
		}else{
			viewHolder =(ViewHolder) convertView.getTag();
		}
		
		viewHolder.iv_Icon.setImageResource(R.drawable.ic_launcher);
		viewHolder.tv_title.setText(mList.get(position).newsTitle);
		viewHolder.tv_title.setText(mList.get(position).newsContent);
		
		return convertView;
	}
	
	class ViewHolder{
		public TextView tv_title,tv_content;
		public ImageView iv_Icon;
	}

}
